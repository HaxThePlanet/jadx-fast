//! Class-level fingerprinting
//!
//! Creates fingerprints for entire classes by combining method fingerprints
//! with class metadata (hierarchy, fields).

use crate::method::{fingerprint_method, MethodFingerprint};
use crate::combine_hashes;
use dexterity_dex::{ClassDef, CodeItem, DexReader};
use serde::{Deserialize, Serialize};
use std::hash::{Hash, Hasher};
use rustc_hash::FxHasher;

/// Mapping of class/method/field names for cache normalization
///
/// Names are ordered by their fingerprint hash, ensuring consistent
/// ordering across APKs with identical bytecode structure.
#[derive(Debug, Clone, Serialize, Deserialize)]
pub struct ClassNameMapping {
    /// The package name (e.g., "com.example")
    pub package_name: String,
    /// The class name (simple name without package, e.g., "MyClass")
    pub class_name: String,
    /// The full class descriptor (e.g., "Lcom/example/MyClass;")
    pub class_descriptor: String,
    /// Method names ordered by method fingerprint hash
    pub method_names: Vec<String>,
    /// Field names ordered by (type, access_flags) for deterministic ordering
    pub field_names: Vec<String>,
}

/// Fingerprint for an entire class
#[derive(Debug, Clone, Serialize, Deserialize)]
pub struct ClassFingerprint {
    /// Combined hash of all method fingerprints (sorted for stability)
    pub methods_hash: u64,
    /// Hash of field types (not names)
    pub fields_hash: u64,
    /// Hash of class hierarchy (superclass + interfaces)
    pub hierarchy_hash: u64,
    /// Access flags
    pub access_flags: u32,
    /// Number of methods
    pub method_count: u32,
    /// Number of fields
    pub field_count: u32,
    /// Individual method fingerprints (sorted by combined hash)
    pub method_fingerprints: Vec<MethodFingerprint>,
}

impl ClassFingerprint {
    /// Get a combined hash of all components
    #[inline]
    pub fn combined_hash(&self) -> u64 {
        combine_hashes(&[
            self.methods_hash,
            self.fields_hash,
            self.hierarchy_hash,
            self.access_flags as u64,
        ])
    }

    /// Check if two class fingerprints match
    pub fn matches(&self, other: &Self) -> bool {
        // Quick reject based on counts
        if self.method_count != other.method_count || self.field_count != other.field_count {
            return false;
        }
        // Full comparison
        self.methods_hash == other.methods_hash
            && self.fields_hash == other.fields_hash
            && self.hierarchy_hash == other.hierarchy_hash
            && self.access_flags == other.access_flags
    }

    /// Calculate similarity score with another class (0.0 to 1.0)
    ///
    /// This enables fuzzy matching for slightly different library versions.
    pub fn similarity(&self, other: &Self) -> f64 {
        if self.method_fingerprints.is_empty() && other.method_fingerprints.is_empty() {
            // Both empty - check other attributes
            if self.hierarchy_hash == other.hierarchy_hash
                && self.fields_hash == other.fields_hash
            {
                return 1.0;
            }
            return 0.5;
        }

        // Count matching methods
        let mut matches = 0;
        for fp in &self.method_fingerprints {
            if other.method_fingerprints.iter().any(|o| fp.matches(o)) {
                matches += 1;
            }
        }

        let total = self.method_fingerprints.len().max(other.method_fingerprints.len());
        if total == 0 {
            return 1.0;
        }

        matches as f64 / total as f64
    }
}

/// Create a fingerprint for a class
///
/// # Arguments
/// * `class_def` - The class definition from the DEX file
/// * `dex` - The DEX reader for resolving references
///
/// # Returns
/// A fingerprint capturing the class's structural identity
pub fn fingerprint_class(
    class_def: &ClassDef,
    dex: &DexReader,
) -> dexterity_dex::Result<ClassFingerprint> {
    // Get class data for methods and fields
    let class_data = class_def.class_data()?;

    let mut method_fingerprints = Vec::new();
    let mut method_count = 0u32;
    let mut field_count = 0u32;

    // Collect all method fingerprints
    if let Some(ref data) = class_data {
        // Process direct methods
        for method in data.direct_methods() {
            method_count += 1;
            if let Some(fp) = fingerprint_encoded_method(method.method_idx, method.code_off, method.access_flags, dex)? {
                method_fingerprints.push(fp);
            }
        }

        // Process virtual methods
        for method in data.virtual_methods() {
            method_count += 1;
            if let Some(fp) = fingerprint_encoded_method(method.method_idx, method.code_off, method.access_flags, dex)? {
                method_fingerprints.push(fp);
            }
        }

        // Count fields
        field_count = data.field_count();
    }

    // Sort method fingerprints by combined hash for deterministic ordering
    method_fingerprints.sort_by_key(|fp| fp.combined_hash());

    // Create combined methods hash
    let method_hashes: Vec<u64> = method_fingerprints.iter().map(|fp| fp.combined_hash()).collect();
    let methods_hash = combine_hashes(&method_hashes);

    // Hash field types
    let fields_hash = hash_field_types(class_def, dex)?;

    // Hash class hierarchy
    let hierarchy_hash = hash_hierarchy(class_def)?;

    Ok(ClassFingerprint {
        methods_hash,
        fields_hash,
        hierarchy_hash,
        access_flags: class_def.access_flags(),
        method_count,
        field_count,
        method_fingerprints,
    })
}

/// Fingerprint a single encoded method
fn fingerprint_encoded_method(
    method_idx: u32,
    code_off: u32,
    access_flags: u32,
    dex: &DexReader,
) -> dexterity_dex::Result<Option<MethodFingerprint>> {
    // Get method prototype
    let method_id = dex.get_method(method_idx)?;
    let proto = dex.get_proto(method_id.proto_idx() as u32)?;

    if code_off == 0 {
        // Abstract or native method - create signature-only fingerprint
        let sig_hash = hash_signature_from_proto(&proto)?;
        return Ok(Some(MethodFingerprint::abstract_method(sig_hash)));
    }

    // Parse code item
    let code = CodeItem::parse(dex, code_off)?;

    // Create full fingerprint
    let fp = fingerprint_method(&code, &proto, access_flags)?;
    Ok(Some(fp))
}

/// Hash field types AND static field values
///
/// SAFETY: We include static field values (not just types) to prevent
/// false matches between classes with same structure but different constants.
/// This is critical for classes with only a static final int and no methods.
fn hash_field_types(class_def: &ClassDef, dex: &DexReader) -> dexterity_dex::Result<u64> {
    let mut hasher = FxHasher::default();

    if let Some(ref data) = class_def.class_data()? {
        // Collect field types for instance fields (they don't have compile-time values)
        let mut field_types: Vec<String> = Vec::new();

        for field in data.instance_fields() {
            let field_id = dex.get_field(field.field_idx)?;
            let field_type = field_id.field_type()?;
            field_types.push(field_type);
        }

        // For static fields, hash both type AND initial value (if present)
        // Static values are stored in static_values array, matching static_fields order
        let static_values = class_def.static_values().unwrap_or_default();

        for (i, field) in data.static_fields().enumerate() {
            let field_id = dex.get_field(field.field_idx)?;
            let field_type = field_id.field_type()?;
            field_types.push(field_type.clone());

            // Hash the static value if present (critical for const fields)
            if let Some(value) = static_values.get(i) {
                // Hash value type discriminant and value
                std::mem::discriminant(value).hash(&mut hasher);
                // Hash the debug representation to capture the actual value
                format!("{:?}", value).hash(&mut hasher);
            }
        }

        // Sort for deterministic ordering (field names may change)
        field_types.sort();

        // Hash types
        field_types.len().hash(&mut hasher);
        for ft in field_types {
            ft.hash(&mut hasher);
        }
    }

    Ok(hasher.finish())
}

/// Hash class hierarchy (superclass + interfaces)
fn hash_hierarchy(class_def: &ClassDef) -> dexterity_dex::Result<u64> {
    let mut hasher = FxHasher::default();

    // Superclass
    if let Some(super_type) = class_def.superclass_type()? {
        super_type.hash(&mut hasher);
    } else {
        0u8.hash(&mut hasher); // No superclass marker
    }

    // Interfaces (sorted for deterministic ordering)
    let mut interfaces = class_def.interfaces()?;
    interfaces.sort();
    interfaces.len().hash(&mut hasher);
    for iface in interfaces {
        iface.hash(&mut hasher);
    }

    Ok(hasher.finish())
}

/// Hash a method signature from its prototype
fn hash_signature_from_proto(proto: &dexterity_dex::ProtoId) -> dexterity_dex::Result<u64> {
    let mut hasher = FxHasher::default();

    let return_type = proto.return_type()?;
    return_type.hash(&mut hasher);

    let params = proto.parameters()?;
    params.len().hash(&mut hasher);
    for param in params {
        param.hash(&mut hasher);
    }

    Ok(hasher.finish())
}

/// Extract class/method/field name mapping for cache normalization
///
/// Names are extracted in the same deterministic order as fingerprints:
/// - Methods: sorted by fingerprint combined hash
/// - Fields: sorted by (type, access_flags)
///
/// This ensures that two classes with identical fingerprints will have
/// their names in the same positions, enabling find-replace normalization.
pub fn extract_name_mapping(
    class_def: &ClassDef,
    dex: &DexReader,
) -> dexterity_dex::Result<ClassNameMapping> {
    // Get class name
    let class_descriptor = class_def.class_type()?;
    let class_name = descriptor_to_simple_name(&class_descriptor);

    // Collect method names with their fingerprint hashes
    let mut method_entries: Vec<(u64, String)> = Vec::new();

    if let Some(ref data) = class_def.class_data()? {
        // Process direct methods
        for method in data.direct_methods() {
            if let Ok(method_id) = dex.get_method(method.method_idx) {
                let method_name = method_id.name().unwrap_or_default();

                // Get fingerprint hash for ordering
                if let Some(fp) = fingerprint_encoded_method(
                    method.method_idx,
                    method.code_off,
                    method.access_flags,
                    dex
                )? {
                    method_entries.push((fp.combined_hash(), method_name));
                }
            }
        }

        // Process virtual methods
        for method in data.virtual_methods() {
            if let Ok(method_id) = dex.get_method(method.method_idx) {
                let method_name = method_id.name().unwrap_or_default();

                if let Some(fp) = fingerprint_encoded_method(
                    method.method_idx,
                    method.code_off,
                    method.access_flags,
                    dex
                )? {
                    method_entries.push((fp.combined_hash(), method_name));
                }
            }
        }
    }

    // Sort methods by fingerprint hash (same order as in fingerprint_class)
    method_entries.sort_by_key(|(hash, _)| *hash);
    let method_names: Vec<String> = method_entries.into_iter().map(|(_, name)| name).collect();

    // Collect field names with their types for deterministic ordering
    let mut field_entries: Vec<(String, u32, String)> = Vec::new(); // (type, access, name)

    if let Some(ref data) = class_def.class_data()? {
        for field in data.static_fields() {
            if let Ok(field_id) = dex.get_field(field.field_idx) {
                let field_name = field_id.name().unwrap_or_default();
                let field_type = field_id.field_type().unwrap_or_default();
                field_entries.push((field_type, field.access_flags, field_name));
            }
        }

        for field in data.instance_fields() {
            if let Ok(field_id) = dex.get_field(field.field_idx) {
                let field_name = field_id.name().unwrap_or_default();
                let field_type = field_id.field_type().unwrap_or_default();
                field_entries.push((field_type, field.access_flags, field_name));
            }
        }
    }

    // Sort fields by (type, access_flags) for deterministic ordering
    field_entries.sort_by(|a, b| (&a.0, a.1).cmp(&(&b.0, b.1)));
    let field_names: Vec<String> = field_entries.into_iter().map(|(_, _, name)| name).collect();

    // Extract package name from descriptor
    let package_name = descriptor_to_package(&class_descriptor);

    Ok(ClassNameMapping {
        package_name,
        class_name,
        class_descriptor,
        method_names,
        field_names,
    })
}

/// Convert a class descriptor like "Lcom/example/MyClass;" to simple name "MyClass"
fn descriptor_to_simple_name(descriptor: &str) -> String {
    // Remove L prefix and ; suffix
    let inner = descriptor.trim_start_matches('L').trim_end_matches(';');
    // Get the last component (after the last /)
    inner.rsplit('/').next().unwrap_or(inner).to_string()
}

/// Convert a class descriptor like "Lcom/example/MyClass;" to package "com.example"
fn descriptor_to_package(descriptor: &str) -> String {
    // Remove L prefix and ; suffix
    let inner = descriptor.trim_start_matches('L').trim_end_matches(';');
    // Get everything before the last /
    if let Some(pos) = inner.rfind('/') {
        inner[..pos].replace('/', ".")
    } else {
        String::new() // Default package
    }
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn test_class_fingerprint_similarity_identical() {
        let fp = ClassFingerprint {
            methods_hash: 12345,
            fields_hash: 67890,
            hierarchy_hash: 11111,
            access_flags: 0,
            method_count: 5,
            field_count: 3,
            method_fingerprints: vec![],
        };

        assert_eq!(fp.similarity(&fp), 1.0);
    }
}
