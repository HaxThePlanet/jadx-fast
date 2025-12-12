//! DEX information for code generation
//!
//! This module provides a bridge between DEX file data and code generation,
//! enabling proper name resolution instead of placeholder indices like `Type#123`.
//!
//! ## Purpose
//!
//! During code generation, instructions reference strings, types, fields, and
//! methods by index (e.g., `const-string v0, string@1234`). Without DEX data,
//! we'd generate `"string#1234"`. With `DexInfo`, we generate the actual value.
//!
//! ## Memory Optimization
//!
//! This module provides two implementations:
//!
//! - `DexInfo` - Eager loading (legacy, high memory usage for large APKs)
//! - `LazyDexInfo` - On-demand loading (recommended for large APKs)
//!
//! `LazyDexInfo` keeps only the memory-mapped DEX file and loads strings,
//! types, fields, and methods on-demand, similar to Java JADX's approach.
//!
//! ## Usage
//!
//! ```ignore
//! // Create lazy info from DexReader (minimal memory footprint)
//! let lazy_info = LazyDexInfo::new(Arc::new(dex));
//!
//! // Passed to code generation - lookups happen on-demand
//! generate_class_with_dex(&class, &config, Some(&lazy_info));
//! ```

use std::collections::HashMap;
use std::sync::{Arc, RwLock};

use crate::expr_gen::{ExprGen, FieldInfo, MethodInfo};
use jadx_dex::DexReader;
use jadx_ir::types::ArgType;

// =============================================================================
// DexInfoProvider trait - unified interface for DEX data access
// =============================================================================

/// Trait for providing DEX information during code generation
///
/// This trait allows both eager-loading (`DexInfo`) and lazy-loading
/// (`LazyDexInfo`) implementations to be used interchangeably.
pub trait DexInfoProvider: Send + Sync {
    /// Get a string by index
    fn get_string(&self, idx: u32) -> Option<String>;

    /// Get a type name by index, converting descriptor to simple name
    fn get_type_name(&self, idx: u32) -> Option<String>;

    /// Get type descriptor by index (raw form like "Ljava/lang/String;")
    fn get_type_descriptor(&self, idx: u32) -> Option<String>;

    /// Get field info by index
    fn get_field(&self, idx: u32) -> Option<FieldInfo>;

    /// Get method info by index
    fn get_method(&self, idx: u32) -> Option<MethodInfo>;

    /// Get field type by index (for type inference)
    fn get_field_type(&self, idx: u32) -> Option<ArgType>;

    /// Get type by index as ArgType (for type inference)
    fn get_type_as_argtype(&self, idx: u32) -> Option<ArgType>;

    /// Get method return type by index (for type inference)
    fn get_method_return_type(&self, idx: u32) -> Option<(Vec<ArgType>, ArgType)>;

    /// Populate an ExprGen with DEX info
    fn populate_expr_gen(&self, expr_gen: &mut ExprGen);

    /// Check if a type is an anonymous inner class (e.g., OuterClass$1)
    fn is_anonymous_class(&self, type_idx: u32) -> bool {
        if let Some(desc) = self.get_type_descriptor(type_idx) {
            crate::class_gen::is_anonymous_class(&desc)
        } else {
            false
        }
    }
}

/// DEX information needed for code generation
///
/// This struct holds pre-extracted data from a DEX file that's needed
/// during code generation to resolve indices to actual names.
#[derive(Default)]
pub struct DexInfo {
    /// String pool: string_idx -> string value
    pub strings: HashMap<u32, String>,
    /// Type names: type_idx -> type descriptor (e.g., "Ljava/lang/String;")
    pub types: HashMap<u32, String>,
    /// Field info: field_idx -> (class_name, field_name, field_type)
    pub fields: HashMap<u32, FieldInfo>,
    /// Method info: method_idx -> (class_name, method_name, return_type, param_types)
    pub methods: HashMap<u32, MethodInfo>,
}

impl DexInfo {
    /// Create a new empty DexInfo
    pub fn new() -> Self {
        Self::default()
    }

    /// Add a string to the pool
    pub fn add_string(&mut self, idx: u32, value: String) {
        self.strings.insert(idx, value);
    }

    /// Add a type name
    pub fn add_type(&mut self, idx: u32, descriptor: String) {
        self.types.insert(idx, descriptor);
    }

    /// Add field info
    pub fn add_field(&mut self, idx: u32, info: FieldInfo) {
        self.fields.insert(idx, info);
    }

    /// Add method info
    pub fn add_method(&mut self, idx: u32, info: MethodInfo) {
        self.methods.insert(idx, info);
    }

    /// Get a string by index
    pub fn get_string(&self, idx: u32) -> Option<&str> {
        self.strings.get(&idx).map(|s| s.as_str())
    }

    /// Get a type name by index, converting descriptor to simple name
    pub fn get_type_name(&self, idx: u32) -> Option<String> {
        self.types.get(&idx).map(|desc| descriptor_to_java_name(desc))
    }

    /// Get field info by index
    pub fn get_field(&self, idx: u32) -> Option<&FieldInfo> {
        self.fields.get(&idx)
    }

    /// Get method info by index
    pub fn get_method(&self, idx: u32) -> Option<&MethodInfo> {
        self.methods.get(&idx)
    }

    /// Get field type by index (for type inference)
    pub fn get_field_type(&self, idx: u32) -> Option<ArgType> {
        self.fields.get(&idx).map(|f| f.field_type.clone())
    }

    /// Get type by index as ArgType (for type inference)
    pub fn get_type_as_argtype(&self, idx: u32) -> Option<ArgType> {
        self.types.get(&idx).and_then(|desc| descriptor_to_argtype(desc))
    }

    /// Get method return type by index (for type inference)
    pub fn get_method_return_type(&self, idx: u32) -> Option<(Vec<ArgType>, ArgType)> {
        self.methods.get(&idx).map(|m| {
            (m.param_types.clone(), m.return_type.clone())
        })
    }

    /// Populate an ExprGen with this DEX info
    pub fn populate_expr_gen(&self, expr_gen: &mut ExprGen) {
        // Add all strings
        for (&idx, value) in &self.strings {
            expr_gen.set_string(idx, value.clone());
        }

        // Add all type names (converting descriptors to Java names)
        for (&idx, desc) in &self.types {
            let java_name = descriptor_to_java_name(desc);
            expr_gen.set_type_name(idx, java_name);
        }

        // Add all field info
        for (&idx, info) in &self.fields {
            expr_gen.set_field_info(idx, info.clone());
        }

        // Add all method info
        for (&idx, info) in &self.methods {
            expr_gen.set_method_info(idx, info.clone());
        }
    }
}

impl DexInfoProvider for DexInfo {
    fn get_string(&self, idx: u32) -> Option<String> {
        self.strings.get(&idx).cloned()
    }

    fn get_type_name(&self, idx: u32) -> Option<String> {
        self.types.get(&idx).map(|desc| descriptor_to_java_name(desc))
    }

    fn get_type_descriptor(&self, idx: u32) -> Option<String> {
        self.types.get(&idx).cloned()
    }

    fn get_field(&self, idx: u32) -> Option<FieldInfo> {
        self.fields.get(&idx).cloned()
    }

    fn get_method(&self, idx: u32) -> Option<MethodInfo> {
        self.methods.get(&idx).cloned()
    }

    fn get_field_type(&self, idx: u32) -> Option<ArgType> {
        self.fields.get(&idx).map(|f| f.field_type.clone())
    }

    fn get_type_as_argtype(&self, idx: u32) -> Option<ArgType> {
        self.types.get(&idx).and_then(|desc| descriptor_to_argtype(desc))
    }

    fn get_method_return_type(&self, idx: u32) -> Option<(Vec<ArgType>, ArgType)> {
        self.methods.get(&idx).map(|m| (m.param_types.clone(), m.return_type.clone()))
    }

    fn populate_expr_gen(&self, expr_gen: &mut ExprGen) {
        DexInfo::populate_expr_gen(self, expr_gen)
    }
}

// =============================================================================
// LazyDexInfo - Memory-efficient on-demand loading (like Java JADX)
// =============================================================================

/// Lazy DEX information for code generation
///
/// Unlike `DexInfo` which loads all data upfront, `LazyDexInfo` keeps only the
/// memory-mapped DEX file and loads strings/types/fields/methods on-demand.
/// This dramatically reduces memory usage for large APKs.
///
/// Thread-safe for parallel code generation via interior mutability.
pub struct LazyDexInfo {
    /// The underlying DEX reader (memory-mapped)
    dex: Arc<DexReader>,
    /// Cached FieldInfo (computed on-demand)
    field_cache: RwLock<HashMap<u32, FieldInfo>>,
    /// Cached MethodInfo (computed on-demand)
    method_cache: RwLock<HashMap<u32, MethodInfo>>,
}

impl LazyDexInfo {
    /// Create a new LazyDexInfo wrapping a DexReader
    ///
    /// This is O(1) - no data is loaded upfront.
    pub fn new(dex: Arc<DexReader>) -> Self {
        LazyDexInfo {
            dex,
            field_cache: RwLock::new(HashMap::new()),
            method_cache: RwLock::new(HashMap::new()),
        }
    }

    /// Get a string by index (lazy - reads from DEX on-demand)
    pub fn get_string(&self, idx: u32) -> Option<String> {
        self.dex.get_string(idx).ok().map(|s| s.to_string())
    }

    /// Get a type name by index, converting descriptor to simple name
    pub fn get_type_name(&self, idx: u32) -> Option<String> {
        self.dex.get_type(idx).ok().map(|desc| descriptor_to_java_name(desc))
    }

    /// Get type descriptor by index (raw form like "Ljava/lang/String;")
    pub fn get_type_descriptor(&self, idx: u32) -> Option<String> {
        self.dex.get_type(idx).ok().map(|s| s.to_string())
    }

    /// Get field info by index (lazy - computed and cached on-demand)
    pub fn get_field(&self, idx: u32) -> Option<FieldInfo> {
        // Check cache first (read lock)
        {
            let cache = self.field_cache.read().unwrap();
            if let Some(info) = cache.get(&idx) {
                return Some(info.clone());
            }
        }

        // Load and cache (write lock)
        let field = self.dex.get_field(idx).ok()?;
        let class_type = field.class_type().ok()?;
        let field_name = field.name().ok()?;
        let field_type_desc = field.field_type().ok()?;

        let info = FieldInfo {
            class_name: descriptor_to_simple_name(class_type),
            class_type: descriptor_to_internal_name(class_type),
            field_name: field_name.to_string(),
            field_type: parse_type_descriptor(field_type_desc),
        };

        let mut cache = self.field_cache.write().unwrap();
        cache.insert(idx, info.clone());
        Some(info)
    }

    /// Get method info by index (lazy - computed and cached on-demand)
    pub fn get_method(&self, idx: u32) -> Option<MethodInfo> {
        // Check cache first (read lock)
        {
            let cache = self.method_cache.read().unwrap();
            if let Some(info) = cache.get(&idx) {
                return Some(info.clone());
            }
        }

        // Load and cache (write lock)
        let method = self.dex.get_method(idx).ok()?;
        let class_type = method.class_type().ok()?;
        let method_name = method.name().ok()?;
        let proto = method.proto().ok()?;

        let return_type = proto.return_type()
            .map(|d| parse_type_descriptor(d))
            .unwrap_or(ArgType::Void);
        let param_types: Vec<ArgType> = proto.parameters()
            .map(|params| params.into_iter().map(|d| parse_type_descriptor(d)).collect())
            .unwrap_or_default();

        let info = MethodInfo {
            class_name: descriptor_to_simple_name(class_type),
            class_type: descriptor_to_internal_name(class_type),
            method_name: method_name.to_string(),
            return_type,
            param_types,
        };

        let mut cache = self.method_cache.write().unwrap();
        cache.insert(idx, info.clone());
        Some(info)
    }

    /// Get field type by index (for type inference)
    pub fn get_field_type(&self, idx: u32) -> Option<ArgType> {
        self.get_field(idx).map(|f| f.field_type)
    }

    /// Get type by index as ArgType (for type inference)
    pub fn get_type_as_argtype(&self, idx: u32) -> Option<ArgType> {
        self.dex.get_type(idx).ok().and_then(|desc| descriptor_to_argtype(desc))
    }

    /// Get method return type by index (for type inference)
    pub fn get_method_return_type(&self, idx: u32) -> Option<(Vec<ArgType>, ArgType)> {
        self.get_method(idx).map(|m| (m.param_types, m.return_type))
    }

    /// Populate an ExprGen with lookups from this DEX info
    ///
    /// Note: For lazy operation, prefer passing LazyDexInfo directly to
    /// code generation instead of using this method.
    pub fn populate_expr_gen(&self, expr_gen: &mut ExprGen) {
        // This method exists for compatibility but is inefficient.
        // For truly lazy operation, use the LazyDexInfo directly in codegen.
        // We don't iterate all indices here - that would defeat the purpose.
    }

    /// Get cache statistics (for debugging/monitoring)
    pub fn cache_stats(&self) -> (usize, usize) {
        let fields = self.field_cache.read().unwrap().len();
        let methods = self.method_cache.read().unwrap().len();
        (fields, methods)
    }
}

impl DexInfoProvider for LazyDexInfo {
    fn get_string(&self, idx: u32) -> Option<String> {
        LazyDexInfo::get_string(self, idx)
    }

    fn get_type_name(&self, idx: u32) -> Option<String> {
        LazyDexInfo::get_type_name(self, idx)
    }

    fn get_type_descriptor(&self, idx: u32) -> Option<String> {
        LazyDexInfo::get_type_descriptor(self, idx)
    }

    fn get_field(&self, idx: u32) -> Option<FieldInfo> {
        LazyDexInfo::get_field(self, idx)
    }

    fn get_method(&self, idx: u32) -> Option<MethodInfo> {
        LazyDexInfo::get_method(self, idx)
    }

    fn get_field_type(&self, idx: u32) -> Option<ArgType> {
        LazyDexInfo::get_field_type(self, idx)
    }

    fn get_type_as_argtype(&self, idx: u32) -> Option<ArgType> {
        LazyDexInfo::get_type_as_argtype(self, idx)
    }

    fn get_method_return_type(&self, idx: u32) -> Option<(Vec<ArgType>, ArgType)> {
        LazyDexInfo::get_method_return_type(self, idx)
    }

    fn populate_expr_gen(&self, expr_gen: &mut ExprGen) {
        LazyDexInfo::populate_expr_gen(self, expr_gen)
    }
}

/// Helper: Convert type descriptor to simple class name
/// Handles inner classes: "Lio/github/skylot/android/smallapp/R$layout;" -> "R.layout"
fn descriptor_to_simple_name(desc: &str) -> String {
    if desc.starts_with('L') && desc.ends_with(';') {
        let inner = &desc[1..desc.len() - 1];
        let simple = inner.rsplit('/').next().unwrap_or(inner);
        // Convert $ to . for inner class notation (R$layout -> R.layout)
        simple.replace('$', ".")
    } else {
        desc.to_string()
    }
}

/// Helper: Convert type descriptor to internal class name (for imports)
/// E.g., "Landroid/util/Log;" -> "android/util/Log"
fn descriptor_to_internal_name(desc: &str) -> String {
    if desc.starts_with('L') && desc.ends_with(';') {
        desc[1..desc.len() - 1].to_string()
    } else {
        desc.to_string()
    }
}

/// Helper: Parse type descriptor to ArgType
pub fn parse_type_descriptor(desc: &str) -> ArgType {
    descriptor_to_argtype(desc).unwrap_or(ArgType::Object(desc.to_string()))
}

/// Convert a DEX type descriptor to an ArgType (for type inference)
/// Public version for use from body_gen.rs
pub fn descriptor_to_argtype_pub(desc: &str) -> Option<ArgType> {
    descriptor_to_argtype(desc)
}

/// Convert a DEX type descriptor to an ArgType (for type inference)
fn descriptor_to_argtype(desc: &str) -> Option<ArgType> {
    if desc.is_empty() {
        return None;
    }

    let first = desc.chars().next()?;
    Some(match first {
        'V' => ArgType::Void,
        'Z' => ArgType::Boolean,
        'B' => ArgType::Byte,
        'S' => ArgType::Short,
        'C' => ArgType::Char,
        'I' => ArgType::Int,
        'J' => ArgType::Long,
        'F' => ArgType::Float,
        'D' => ArgType::Double,
        '[' => {
            let elem = descriptor_to_argtype(&desc[1..])?;
            ArgType::Array(Box::new(elem))
        }
        'L' => {
            let inner = desc
                .strip_prefix('L')?
                .strip_suffix(';')?;
            ArgType::Object(inner.to_string())
        }
        _ => return None,
    })
}

/// Convert a DEX type descriptor to a Java type name
///
/// Examples:
/// - "Ljava/lang/String;" -> "String"
/// - "[I" -> "int[]"
/// - "I" -> "int"
/// - "Lio/github/skylot/android/smallapp/R$layout;" -> "R.layout"
fn descriptor_to_java_name(desc: &str) -> String {
    if desc.is_empty() {
        return "Object".to_string();
    }

    let first = desc.chars().next().unwrap();
    match first {
        'V' => "void".to_string(),
        'Z' => "boolean".to_string(),
        'B' => "byte".to_string(),
        'S' => "short".to_string(),
        'C' => "char".to_string(),
        'I' => "int".to_string(),
        'J' => "long".to_string(),
        'F' => "float".to_string(),
        'D' => "double".to_string(),
        '[' => {
            let elem = descriptor_to_java_name(&desc[1..]);
            format!("{}[]", elem)
        }
        'L' => {
            // Object type: Ljava/lang/String; -> String (simple name)
            // Inner class: Lcom/example/R$layout; -> R.layout
            let inner = desc
                .strip_prefix('L')
                .unwrap_or(desc)
                .strip_suffix(';')
                .unwrap_or(desc);
            // Get simple name (last component after /)
            let simple = inner
                .rsplit('/')
                .next()
                .unwrap_or(inner);
            // Convert $ to . for inner class notation (R$layout -> R.layout)
            simple.replace('$', ".")
        }
        _ => desc.to_string(),
    }
}

/// Convert a DEX type descriptor to a full Java type name (with package)
/// Inner classes use . notation: "Lcom/example/R$layout;" -> "com.example.R.layout"
pub fn descriptor_to_full_java_name(desc: &str) -> String {
    if desc.is_empty() {
        return "java.lang.Object".to_string();
    }

    let first = desc.chars().next().unwrap();
    match first {
        'V' => "void".to_string(),
        'Z' => "boolean".to_string(),
        'B' => "byte".to_string(),
        'S' => "short".to_string(),
        'C' => "char".to_string(),
        'I' => "int".to_string(),
        'J' => "long".to_string(),
        'F' => "float".to_string(),
        'D' => "double".to_string(),
        '[' => {
            let elem = descriptor_to_full_java_name(&desc[1..]);
            format!("{}[]", elem)
        }
        'L' => {
            let inner = desc
                .strip_prefix('L')
                .unwrap_or(desc)
                .strip_suffix(';')
                .unwrap_or(desc);
            // Convert both / and $ to . for Java source notation
            inner.replace('/', ".").replace('$', ".")
        }
        _ => desc.to_string(),
    }
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn test_descriptor_to_java_name() {
        assert_eq!(descriptor_to_java_name("I"), "int");
        assert_eq!(descriptor_to_java_name("Z"), "boolean");
        assert_eq!(descriptor_to_java_name("[I"), "int[]");
        assert_eq!(descriptor_to_java_name("[[D"), "double[][]");
        assert_eq!(descriptor_to_java_name("Ljava/lang/String;"), "String");
        assert_eq!(
            descriptor_to_java_name("Landroid/widget/TextView;"),
            "TextView"
        );
    }

    #[test]
    fn test_descriptor_to_java_name_inner_class() {
        // R$layout -> R.layout (inner class notation)
        assert_eq!(
            descriptor_to_java_name("Lio/github/skylot/android/smallapp/R$layout;"),
            "R.layout"
        );
        assert_eq!(
            descriptor_to_java_name("Lcom/example/Outer$Inner;"),
            "Outer.Inner"
        );
        assert_eq!(
            descriptor_to_java_name("Lcom/example/R$drawable;"),
            "R.drawable"
        );
        // Nested inner classes
        assert_eq!(
            descriptor_to_java_name("Lcom/example/A$B$C;"),
            "A.B.C"
        );
    }

    #[test]
    fn test_descriptor_to_full_java_name() {
        assert_eq!(descriptor_to_full_java_name("Ljava/lang/String;"), "java.lang.String");
        assert_eq!(
            descriptor_to_full_java_name("Landroid/widget/TextView;"),
            "android.widget.TextView"
        );
    }

    #[test]
    fn test_descriptor_to_full_java_name_inner_class() {
        // Inner classes should use . notation in full names too
        assert_eq!(
            descriptor_to_full_java_name("Lio/github/skylot/android/smallapp/R$layout;"),
            "io.github.skylot.android.smallapp.R.layout"
        );
        assert_eq!(
            descriptor_to_full_java_name("Lcom/example/Outer$Inner;"),
            "com.example.Outer.Inner"
        );
    }

    #[test]
    fn test_populate_expr_gen() {
        let mut dex_info = DexInfo::new();
        dex_info.add_string(0, "Hello".to_string());
        dex_info.add_type(0, "Ljava/lang/String;".to_string());
        dex_info.add_field(
            0,
            FieldInfo {
                class_name: "MyClass".to_string(),
                class_type: "com/example/MyClass".to_string(),
                field_name: "value".to_string(),
                field_type: ArgType::Int,
            },
        );

        let mut expr_gen = ExprGen::new();
        dex_info.populate_expr_gen(&mut expr_gen);

        // Verify strings were added (would need getter to verify)
        // For now just ensure no panic
    }
}
