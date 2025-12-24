//! Kotlin metadata parsing and processing for dexterity
//!
//! This crate provides support for parsing `@kotlin.Metadata` annotations
//! to extract original Kotlin names (classes, fields, methods, parameters)
//! for superior decompilation quality matching Java JADX output.
//!
//! Also supports `@kotlin.jvm.internal.SourceDebugExtension` (SMAP) for:
//! - Multifile classes (multiple .kt files compiled into one class)
//! - Inline functions (inlined code maps back to original function)
//! - Lambda source mapping

pub mod parser;
pub mod extractor;
pub mod types;
pub mod visitor;
pub mod tostring_parser;
pub mod smap_types;
pub mod smap_parser;

// Re-exports
pub use visitor::KotlinAwareCondition;
pub use extractor::{
    apply_getter_recognition, apply_tostring_names,
    find_getters_jadx_style, find_default_methods_jadx_style,
    analyze_companion_for_hiding, rename_companion_jadx_style,
    apply_kotlin_names_with_options,
    CompanionAnalysis,
};
pub use tostring_parser::TypeResolver;
pub use types::{KotlinClassMetadata, KotlinFunction, KotlinProperty, KotlinClassFlags, KotlinFunctionFlags, KotlinPropertyFlags, KotlinTypeParameter, KotlinVariance};
pub use smap_types::{SMAP, FileMapping, RangeMapping, SourcePosition, ClassAliasRename};
pub use smap_parser::parse_or_null as parse_smap;

// Re-export options for CLI integration

// Re-export generated protobuf types
pub mod proto {
    include!(concat!(env!("OUT_DIR"), "/org.jetbrains.kotlin.metadata.rs"));
}

// JVM-specific Kotlin metadata protobuf types
pub mod jvm_proto {
    include!(concat!(env!("OUT_DIR"), "/org.jetbrains.kotlin.metadata.jvm.rs"));
}

use anyhow::Result;
use dexterity_dex::DexReader;
use dexterity_ir::{ClassData, Annotation, AnnotationValue};

// ============================================================================
// JADX-Style Kotlin Processing Options
// ============================================================================
// Cloned from JADX: jadx-plugins/jadx-kotlin-metadata/src/main/kotlin/jadx/plugins/kotlin/metadata/KotlinMetadataOptions.kt

/// Options for Kotlin metadata processing
/// JADX Reference: KotlinMetadataOptions.kt:6-76
///
/// All options default to `true` to match JADX's default behavior.
/// These can be wired to CLI flags like `--kotlin-class-alias`, `--kotlin-method-args`, etc.
#[derive(Debug, Clone, Copy)]
pub struct KotlinProcessingOptions {
    /// Apply class alias from d2 array or SMAP
    /// JADX Reference: KotlinMetadataOptions.kt:16-22
    pub class_alias: bool,

    /// Apply method argument names from Kotlin metadata
    /// JADX Reference: KotlinMetadataOptions.kt:24-30
    pub method_args: bool,

    /// Apply field names from Kotlin metadata (properties)
    /// JADX Reference: KotlinMetadataOptions.kt:32-38
    pub fields: bool,

    /// Process companion objects
    /// JADX Reference: KotlinMetadataOptions.kt:40-46
    pub companion: bool,

    /// Apply data class flag for proper toString/equals/hashCode
    /// JADX Reference: KotlinMetadataOptions.kt:48-54
    pub data_class: bool,

    /// Use toString() bytecode analysis for field renames
    /// JADX Reference: KotlinMetadataOptions.kt:56-62
    pub to_string: bool,

    /// Recognize and rename getter methods
    /// JADX Reference: KotlinMetadataOptions.kt:64-70
    pub getters: bool,

    /// Use SMAP (SourceDebugExtension) for class alias
    /// JADX Reference: KotlinSmapOptions.kt
    pub smap_class_alias: bool,
}

impl Default for KotlinProcessingOptions {
    /// Default options match JADX defaults (all enabled)
    fn default() -> Self {
        Self {
            class_alias: true,
            method_args: true,
            fields: true,
            companion: true,
            data_class: true,
            to_string: true,
            getters: true,
            smap_class_alias: true,
        }
    }
}

impl KotlinProcessingOptions {
    /// Create options with all features enabled (JADX defaults)
    pub fn all_enabled() -> Self {
        Self::default()
    }

    /// Create options with all features disabled
    pub fn all_disabled() -> Self {
        Self {
            class_alias: false,
            method_args: false,
            fields: false,
            companion: false,
            data_class: false,
            to_string: false,
            getters: false,
            smap_class_alias: false,
        }
    }

    /// Builder pattern: enable class alias processing
    pub fn with_class_alias(mut self, enabled: bool) -> Self {
        self.class_alias = enabled;
        self
    }

    /// Builder pattern: enable method args processing
    pub fn with_method_args(mut self, enabled: bool) -> Self {
        self.method_args = enabled;
        self
    }

    /// Builder pattern: enable field processing
    pub fn with_fields(mut self, enabled: bool) -> Self {
        self.fields = enabled;
        self
    }

    /// Builder pattern: enable companion processing
    pub fn with_companion(mut self, enabled: bool) -> Self {
        self.companion = enabled;
        self
    }

    /// Builder pattern: enable data class processing
    pub fn with_data_class(mut self, enabled: bool) -> Self {
        self.data_class = enabled;
        self
    }

    /// Builder pattern: enable toString processing
    pub fn with_to_string(mut self, enabled: bool) -> Self {
        self.to_string = enabled;
        self
    }

    /// Builder pattern: enable getters processing
    pub fn with_getters(mut self, enabled: bool) -> Self {
        self.getters = enabled;
        self
    }

    /// Builder pattern: enable SMAP class alias processing
    pub fn with_smap_class_alias(mut self, enabled: bool) -> Self {
        self.smap_class_alias = enabled;
        self
    }
}

// ============================================================================
// JADX-Style Identifier Validation
// ============================================================================
// Cloned from JADX: jadx-core/src/main/java/jadx/core/deobf/NameMapper.java

/// Java reserved keywords that cannot be used as identifiers
/// JADX Reference: NameMapper.java
const JAVA_KEYWORDS: &[&str] = &[
    "abstract", "assert", "boolean", "break", "byte", "case", "catch", "char",
    "class", "const", "continue", "default", "do", "double", "else", "enum",
    "extends", "final", "finally", "float", "for", "goto", "if", "implements",
    "import", "instanceof", "int", "interface", "long", "native", "new", "package",
    "private", "protected", "public", "return", "short", "static", "strictfp",
    "super", "switch", "synchronized", "this", "throw", "throws", "transient",
    "try", "void", "volatile", "while", "true", "false", "null",
];

/// Check if a name is a valid Java identifier
/// JADX Reference: NameMapper.isValidIdentifier
///
/// Validates:
/// - Name is not empty
/// - First char is valid identifier start (letter, '_', '$')
/// - All subsequent chars are valid identifier parts (letter, digit, '_', '$')
/// - Name is not a Java reserved keyword
pub fn is_valid_identifier(name: &str) -> bool {
    if name.is_empty() {
        return false;
    }

    let mut chars = name.chars();

    // First char must be valid Java identifier start
    // JADX Reference: Character.isJavaIdentifierStart
    let first = chars.next().unwrap();
    if !first.is_alphabetic() && first != '_' && first != '$' {
        return false;
    }

    // Remaining chars must be valid Java identifier parts
    // JADX Reference: Character.isJavaIdentifierPart
    for c in chars {
        if !c.is_alphanumeric() && c != '_' && c != '$' {
            return false;
        }
    }

    // Check not a Java keyword
    !is_java_keyword(name)
}

/// Check if a name is a Java reserved keyword
/// JADX Reference: NameMapper.isReserved
fn is_java_keyword(name: &str) -> bool {
    JAVA_KEYWORDS.contains(&name)
}

/// Check if a full qualified name is valid (e.g., "com.example.MyClass")
/// JADX Reference: NameMapper.isValidFullIdentifier
pub fn is_valid_full_identifier(name: &str) -> bool {
    if name.is_empty() {
        return false;
    }

    // Split by '.' and validate each part
    for part in name.split('.') {
        if !is_valid_identifier(part) {
            return false;
        }
    }

    true
}

/// Clean object name from Kotlin/JVM descriptor format
/// JADX Reference: Utils.cleanObjectName
///
/// Handles:
/// - "Lcom/example/Foo;" -> "com.example.Foo"
/// - "com/example/Foo" -> "com.example.Foo"
/// - "[Lcom/example/Foo;" -> "com.example.Foo[]"
pub fn clean_object_name(name: &str) -> Option<String> {
    let name = name.trim();
    if name.is_empty() {
        return None;
    }

    // Handle array types
    let (name, is_array) = if name.starts_with('[') {
        let inner = name.trim_start_matches('[');
        (inner, true)
    } else {
        (name, false)
    };

    // Handle "Lcom/example/Foo;" format
    let cleaned = if name.starts_with('L') && name.ends_with(';') {
        &name[1..name.len() - 1]
    } else {
        name
    };

    // Convert / to .
    let mut result = cleaned.replace('/', ".");

    // Add array suffix if needed
    if is_array {
        result.push_str("[]");
    }

    Some(result)
}

use dexterity_ir::kotlin_metadata::get_class_alias;

/// SourceDebugExtension annotation type
/// JADX Reference: jadx-plugins/jadx-kotlin-source-debug-extension/src/main/kotlin/jadx/plugins/kotlin/smap/model/Constants.kt
const SOURCE_DEBUG_EXTENSION_ANNOTATION: &str = "kotlin/jvm/internal/SourceDebugExtension";

/// Find @kotlin.jvm.internal.SourceDebugExtension annotation
/// JADX Reference: jadx-plugins/jadx-kotlin-source-debug-extension/src/main/kotlin/jadx/plugins/kotlin/smap/utils/Extensions.kt:13-19
fn find_source_debug_extension(annotations: &[Annotation]) -> Option<&Annotation> {
    annotations.iter().find(|a| {
        a.annotation_type == SOURCE_DEBUG_EXTENSION_ANNOTATION
            || a.annotation_type.ends_with("/SourceDebugExtension")
            || a.annotation_type == "Lkotlin/jvm/internal/SourceDebugExtension;"
    })
}

/// Extract SMAP value from SourceDebugExtension annotation
/// JADX Reference: jadx-plugins/jadx-kotlin-source-debug-extension/src/main/kotlin/jadx/plugins/kotlin/smap/utils/Extensions.kt:15-17
fn get_smap_from_annotation(annot: &Annotation) -> Option<String> {
    // The annotation has a "value" element which is an array of strings
    for elem in &annot.elements {
        if elem.name == "value" {
            match &elem.value {
                AnnotationValue::Array(arr) => {
                    // Concatenate all strings in the array
                    let parts: Vec<String> = arr.iter()
                        .filter_map(|v| match v {
                            AnnotationValue::String(s) => Some(s.clone()),
                            _ => None,
                        })
                        .collect();
                    if !parts.is_empty() {
                        return Some(parts.join(""));
                    }
                }
                AnnotationValue::String(s) => {
                    return Some(s.clone());
                }
                _ => {}
            }
        }
    }
    None
}

/// Get class alias from SMAP (SourceDebugExtension)
/// JADX Reference: jadx-plugins/jadx-kotlin-source-debug-extension/src/main/kotlin/jadx/plugins/kotlin/smap/utils/KotlinSmapUtils.kt:17-39
///
/// The `class_exists` function is used to check if a class with the target name already exists.
/// JADX Reference: KotlinMetadataUtils.kt:68-71 - collision check
fn get_class_alias_from_smap<F>(
    smap: &smap_types::SMAP,
    cls: &ClassData,
    class_exists: F,
) -> Option<smap_types::ClassAliasRename>
where
    F: Fn(&str) -> bool,
{
    let first_file = smap.first_file()?;

    // Get the path and convert "/" to "."
    // JADX Reference: KotlinSmapUtils.kt:24
    let full_cls_name = first_file.path.replace('/', ".");

    // Trim and clean the name
    let full_cls_name = full_cls_name.trim();
    if full_cls_name.is_empty() {
        return None;
    }

    // Clean object name (remove L prefix and ; suffix if present)
    let full_cls_name = if full_cls_name.starts_with('L') && full_cls_name.ends_with(';') {
        &full_cls_name[1..full_cls_name.len() - 1]
    } else {
        full_cls_name
    };

    // Remove .kt extension if present
    let full_cls_name = full_cls_name.strip_suffix(".kt").unwrap_or(full_cls_name);

    // Split into package and name
    // JADX Reference: KotlinSmapUtils.kt:43-58
    let (pkg, name) = match full_cls_name.rfind('.') {
        Some(dot) => {
            (full_cls_name[..dot].to_string(), full_cls_name[dot + 1..].to_string())
        }
        None => {
            (String::new(), full_cls_name.to_string())
        }
    };

    // Validation checks
    // JADX Reference: KotlinSmapUtils.kt:59-63

    // Check if name is valid identifier
    if !is_valid_identifier(&name) {
        return None;
    }

    // Check if name contains $ (inner class marker)
    if name.contains('$') {
        return None;
    }

    // Check if package starts with "java."
    if pkg.starts_with("java.") {
        return None;
    }

    // Check if name matches original (no need to rename)
    let origin_name = cls.simple_name();
    if origin_name == name {
        return None;
    }

    // Check if package part count matches
    // JADX Reference: KotlinSmapUtils.kt:64
    let origin_pkg = cls.package().unwrap_or("");
    if count_pkg_parts(origin_pkg) != count_pkg_parts(&pkg) {
        return None;
    }

    // P0.2 FIX: Check if a class with the alias name already exists
    // JADX Reference: KotlinMetadataUtils.kt:68-71
    // ```kotlin
    // val newClsNode = originCls.root().resolveClass(fullClsName)
    // return if (newClsNode != null) {
    //     // class with alias name already exist
    //     null  // Return null to prevent rename
    // } else {
    //     ClassAliasRename(pkg, name)
    // }
    // ```
    let full_target_name = if pkg.is_empty() {
        name.clone()
    } else {
        format!("{}.{}", pkg, name)
    };

    if class_exists(&full_target_name) {
        tracing::debug!(
            "Skipping class alias '{}' - class already exists",
            full_target_name
        );
        return None;
    }

    Some(smap_types::ClassAliasRename::new(pkg, name))
}

/// Count package parts (number of segments separated by .)
/// JADX Reference: KotlinMetadataUtils.kt:77-90
fn count_pkg_parts(pkg: &str) -> usize {
    if pkg.is_empty() {
        return 0;
    }
    pkg.matches('.').count() + 1
}

// Note: is_valid_identifier() moved to line ~205 with JADX Reference comments
// and extended to support '$' and Java keyword checking

/// Process Kotlin metadata for a class, extracting and applying names
///
/// If `dex` is provided, also applies toString() bytecode analysis as a fallback
/// for extracting field names when protobuf metadata is unavailable.
///
/// This is a convenience wrapper that uses default options (all features enabled).
pub fn process_kotlin_metadata(cls: &mut ClassData, dex: Option<&DexReader>) -> Result<()> {
    process_kotlin_metadata_with_options(cls, dex, &KotlinProcessingOptions::default())
}

/// Process Kotlin metadata for a class with custom options
///
/// JADX Reference: KotlinMetadataDecompilePass.kt, KotlinMetadataOptions.kt
///
/// If `dex` is provided, also applies toString() bytecode analysis as a fallback
/// for extracting field names when protobuf metadata is unavailable.
///
/// # Arguments
/// * `cls` - The class data to process
/// * `dex` - Optional DEX reader for toString() bytecode analysis
/// * `options` - Processing options controlling which features are enabled
///
/// # Example
/// ```ignore
/// let options = KotlinProcessingOptions::default()
///     .with_to_string(false)  // Disable toString analysis
///     .with_getters(true);    // Enable getter recognition
/// process_kotlin_metadata_with_options(&mut cls, Some(&dex), &options)?;
/// ```
pub fn process_kotlin_metadata_with_options(
    cls: &mut ClassData,
    dex: Option<&DexReader>,
    options: &KotlinProcessingOptions,
) -> Result<()> {
    // Use the new version with no collision check (backwards compatible)
    process_kotlin_metadata_with_collision_check(cls, dex, options, |_| false)
}

/// Process Kotlin metadata with collision checking
///
/// JADX Reference: KotlinMetadataDecompilePass.kt, KotlinMetadataOptions.kt
/// P0.2 FIX: Implements collision check from KotlinMetadataUtils.kt:68-71
///
/// # Arguments
/// * `cls` - The class data to process
/// * `dex` - Optional DEX reader for toString() bytecode analysis
/// * `options` - Processing options controlling which features are enabled
/// * `class_exists` - Function that returns true if a class with the given FQ name exists
///
/// The `class_exists` function prevents class name collisions by checking if the
/// target alias name already exists in the codebase.
pub fn process_kotlin_metadata_with_collision_check<F>(
    cls: &mut ClassData,
    dex: Option<&DexReader>,
    options: &KotlinProcessingOptions,
    class_exists: F,
) -> Result<()>
where
    F: Fn(&str) -> bool,
{
    // STEP 1: Try SourceDebugExtension (SMAP) first for class alias
    // This is higher priority than d2 array for multifile classes
    // JADX Reference: jadx-plugins/jadx-kotlin-source-debug-extension/src/main/kotlin/jadx/plugins/kotlin/smap/pass/KotlinSourceDebugExtensionPass.kt
    if options.smap_class_alias && cls.alias.is_none() {
        if let Some(sde_annot) = find_source_debug_extension(&cls.annotations) {
            if let Some(smap_str) = get_smap_from_annotation(sde_annot) {
                if let Some(smap) = smap_parser::parse_or_null(&smap_str) {
                    if let Some(alias_rename) = get_class_alias_from_smap(&smap, cls, &class_exists) {
                        tracing::debug!(
                            "SMAP extracted class alias for {}: {} (pkg: {})",
                            cls.class_type, alias_rename.name, alias_rename.pkg
                        );
                        cls.alias = Some(alias_rename.name);
                        // JADX Reference: RenameReasonAttr pattern
                        cls.add_rename_reason("from SMAP");
                        if cls.pkg_alias.is_none() && !alias_rename.pkg.is_empty() {
                            cls.pkg_alias = Some(alias_rename.pkg);
                        }
                    }
                }
            }
        }
    }

    // STEP 2: Attempt to extract class alias from Kotlin metadata (d2 array)
    // This runs before protobuf parsing to ensure we have the correct class name
    // even if protobuf parsing fails or is incomplete.
    if options.class_alias {
        if let Some(alias_info) = get_class_alias(cls) {
            // P0.2 FIX: Check for collision before applying alias
            // JADX Reference: KotlinMetadataUtils.kt:68-71
            let full_target_name = if alias_info.pkg.is_empty() {
                alias_info.name.clone()
            } else {
                format!("{}.{}", alias_info.pkg, alias_info.name)
            };

            let collision = class_exists(&full_target_name);
            if collision {
                tracing::debug!(
                    "Skipping d2 class alias '{}' - class already exists",
                    full_target_name
                );
            } else {
                if cls.alias.is_none() {
                    cls.alias = Some(alias_info.name);
                    // JADX Reference: RenameReasonAttr pattern
                    cls.add_rename_reason("from kotlin metadata");
                }
                if cls.pkg_alias.is_none() {
                    cls.pkg_alias = Some(alias_info.pkg);
                }
            }
        }
    }

    // Find @kotlin.Metadata annotation
    let metadata_annot = match parser::find_kotlin_metadata(&cls.annotations) {
        Some(a) => {
            tracing::debug!("Found Kotlin metadata annotation in {}", cls.class_type);
            a
        }
        None => {
            // Not Kotlin code - log at debug level for debugging
            if !cls.annotations.is_empty() {
                tracing::debug!(
                    "No Kotlin metadata in {} (has {} annotations: {:?})",
                    cls.class_type,
                    cls.annotations.len(),
                    cls.annotations.iter().map(|a| &a.annotation_type).collect::<Vec<_>>()
                );
            }
            return Ok(());
        }
    };

    // Parse the annotation into structured form
    let kotlin_meta_annot = parser::parse_kotlin_metadata_annotation(metadata_annot)?;

    // Attempt to parse protobuf (d1 field)
    let kotlin_metadata = match parser::parse_d1_protobuf(&kotlin_meta_annot) {
        Ok(meta) => {
            tracing::debug!(
                "Parsed Kotlin metadata for {}: kind={:?}, is_data={}, functions={}",
                cls.class_type, meta.kind, meta.is_data_class, meta.functions.len()
            );
            meta
        }
        Err(e) => {
            tracing::debug!(
                "Failed to parse Kotlin metadata d1 for {}: {}",
                cls.class_type, e
            );
            // Fallback to d2 array
            match parser::parse_d2_fallback(&kotlin_meta_annot, cls) {
                Ok(_) => return Ok(()),
                Err(e) => {
                    tracing::debug!("Kotlin metadata d2 fallback also failed: {}", e);
                    return Ok(());
                }
            }
        }
    };

    // Extract and apply names to IR
    // This applies class alias, method args, and field names based on options
    extractor::apply_kotlin_names_with_options(cls, &kotlin_metadata, options)?;

    // Apply getter/setter recognition (metadata-based)
    if options.getters {
        extractor::apply_getter_recognition(cls, &kotlin_metadata);
    }

    // STEP 3: Apply JADX-style getter recognition (bytecode-based)
    // JADX Reference: KotlinUtils.kt:25-44
    // This uses exact instruction count and field matching like JADX
    if options.getters {
        extractor::find_getters_jadx_style(cls);
    }

    // STEP 4: Apply JADX-style default method recognition
    // JADX Reference: KotlinUtils.kt:53-89
    // Renames synthetic $default methods to match original method alias
    if options.method_args {
        extractor::find_default_methods_jadx_style(cls);
    }

    // STEP 5: Apply JADX-style companion object renaming
    // JADX Reference: KotlinMetadataDecompilePass.kt:71-88
    // Renames companion field to "Companion" and detects empty companions for hiding
    if options.companion {
        extractor::rename_companion_jadx_style(cls, &kotlin_metadata);

        // Analyze companion for potential hiding
        // JADX Reference: KotlinMetadataUtils.kt:118-141
        if let Some(analysis) = extractor::analyze_companion_for_hiding(cls, &kotlin_metadata) {
            if analysis.should_hide {
                tracing::debug!(
                    "Companion object '{}' in {} should be hidden",
                    analysis.field_name, cls.class_type
                );

                // P1.1 FIX: Apply DONT_GENERATE flag to companion field
                // JADX Reference: KotlinMetadataUtils.kt:137-138
                // ```kotlin
                // compField.add(AFlag.DONT_GENERATE)
                // compCls.add(AFlag.DONT_GENERATE)
                // ```
                if let Some(companion_field) = cls.static_fields.iter_mut().find(|f| f.name == analysis.field_name) {
                    companion_field.dont_generate = true;
                    tracing::debug!(
                        "Marked companion field '{}' for hiding (dont_generate=true)",
                        analysis.field_name
                    );
                }

                // Mark companion class for hiding if it's an inner class
                // We store the companion class type for the codegen to handle
                let companion_type = format!("{}${}", cls.class_type.trim_start_matches('L').trim_end_matches(';'), analysis.field_name);
                cls.hidden_inner_classes.push(companion_type);
            }
        }
    }

    // Apply toString() bytecode analysis (fallback for obfuscated metadata)
    if options.to_string {
        if let Some(dex_reader) = dex {
            extractor::apply_tostring_names(cls, dex_reader)?;
        }
    }

    Ok(())
}

#[cfg(test)]
mod tests {
    #[test]
    fn test_find_kotlin_metadata() {
        // Tested in parser module
    }
}
