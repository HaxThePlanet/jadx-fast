
use crate::info::{Annotation, AnnotationValue, ClassData};

/// Trait for resolving class existence in the codebase.
/// Used by Kotlin metadata processing to validate class aliases.
pub trait ClassResolver {
    /// Check if a class exists in the codebase.
    /// The class name should be in JVM internal format (e.g., "com/example/MyClass").
    fn class_exists(&self, class_name: &str) -> bool;
}

/// Simple class resolver that uses a set of known class names.
pub struct SetClassResolver<'a> {
    class_names: &'a std::collections::HashSet<String>,
}

impl<'a> SetClassResolver<'a> {
    pub fn new(class_names: &'a std::collections::HashSet<String>) -> Self {
        Self { class_names }
    }
}

impl<'a> ClassResolver for SetClassResolver<'a> {
    fn class_exists(&self, class_name: &str) -> bool {
        self.class_names.contains(class_name)
    }
}

/// Class resolver backed by a closure for flexible lookups.
pub struct FnClassResolver<F>
where
    F: Fn(&str) -> bool,
{
    resolver: F,
}

impl<F> FnClassResolver<F>
where
    F: Fn(&str) -> bool,
{
    pub fn new(resolver: F) -> Self {
        Self { resolver }
    }
}

impl<F> ClassResolver for FnClassResolver<F>
where
    F: Fn(&str) -> bool,
{
    fn class_exists(&self, class_name: &str) -> bool {
        (self.resolver)(class_name)
    }
}

#[derive(Debug, Clone, Default)]
pub struct KotlinMetadata {
    pub kind: Option<i32>,
    pub metadata_version: Option<Vec<i32>>,
    pub data1: Option<Vec<String>>,
    pub data2: Option<Vec<String>>,
    pub extra_string: Option<String>,
    pub package_name: Option<String>,
    pub extra_int: Option<i32>,
}

pub const KOTLIN_METADATA_ANNOTATION: &str = "Lkotlin/Metadata;";
pub const KOTLIN_METADATA_K_PARAMETER: &str = "k";
pub const KOTLIN_METADATA_MV_PARAMETER: &str = "mv";
pub const KOTLIN_METADATA_D1_PARAMETER: &str = "d1";
pub const KOTLIN_METADATA_D2_PARAMETER: &str = "d2";
pub const KOTLIN_METADATA_XS_PARAMETER: &str = "xs";
pub const KOTLIN_METADATA_PN_PARAMETER: &str = "pn";
pub const KOTLIN_METADATA_XI_PARAMETER: &str = "xi";

impl KotlinMetadata {
    pub fn from_annotation(annotation: &Annotation) -> Option<Self> {
        if annotation.annotation_type != KOTLIN_METADATA_ANNOTATION {
            return None;
        }

        let mut metadata = KotlinMetadata::default();

        for element in &annotation.elements {
            match element.name.as_str() {
                KOTLIN_METADATA_K_PARAMETER => {
                    if let AnnotationValue::Int(val_k) = element.value {
                        metadata.kind = Some(val_k);
                    }
                }
                KOTLIN_METADATA_MV_PARAMETER => {
                    if let AnnotationValue::Array(array_val) = &element.value {
                        metadata.metadata_version = Some(
                            array_val
                                .iter()
                                .filter_map(|v| {
                                    if let AnnotationValue::Int(i) = v {
                                        Some(*i)
                                    } else {
                                        None
                                    }
                                })
                                .collect(),
                        );
                    }
                }
                KOTLIN_METADATA_D1_PARAMETER => {
                    if let AnnotationValue::Array(array_val) = &element.value {
                        metadata.data1 = Some(
                            array_val
                                .iter()
                                .filter_map(|v| {
                                    if let AnnotationValue::String(s) = v {
                                        Some(s.clone())
                                    } else {
                                        None
                                    }
                                })
                                .collect(),
                        );
                    }
                }
                KOTLIN_METADATA_D2_PARAMETER => {
                    if let AnnotationValue::Array(array_val) = &element.value {
                        metadata.data2 = Some(
                            array_val
                                .iter()
                                .filter_map(|v| {
                                    if let AnnotationValue::String(s) = v {
                                        Some(s.clone())
                                    } else {
                                        None
                                    }
                                })
                                .collect(),
                        );
                    }
                }
                KOTLIN_METADATA_XS_PARAMETER => {
                    if let AnnotationValue::String(val_xs) = &element.value {
                        metadata.extra_string = Some(val_xs.clone());
                    }
                }
                KOTLIN_METADATA_PN_PARAMETER => {
                    if let AnnotationValue::String(val_pn) = &element.value {
                        metadata.package_name = Some(val_pn.clone());
                    }
                }
                KOTLIN_METADATA_XI_PARAMETER => {
                    if let AnnotationValue::Int(val_xi) = element.value {
                        metadata.extra_int = Some(val_xi);
                    }
                }
                _ => {} // Ignore unknown parameters
            }
        }
        Some(metadata)
    }
}

/// Represents a renamed class and its package from Kotlin metadata
#[derive(Debug, Clone, PartialEq, Eq)]
pub struct ClassAlias {
    pub pkg: String,
    pub name: String,
}

impl ClassAlias {
    pub fn new(pkg: String, name: String) -> Self {
        Self { pkg, name }
    }
}

/// Get class alias from Kotlin metadata without class existence validation.
/// For strict validation, use `get_class_alias_with_resolver` instead.
pub fn get_class_alias(cls: &ClassData) -> Option<ClassAlias> {
    get_class_alias_internal(cls, None::<&FnClassResolver<fn(&str) -> bool>>)
}

/// Get class alias from Kotlin metadata with class existence validation.
/// The resolver is used to verify that the resolved class actually exists.
pub fn get_class_alias_with_resolver<R: ClassResolver>(
    cls: &ClassData,
    resolver: &R,
) -> Option<ClassAlias> {
    get_class_alias_internal(cls, Some(resolver))
}

fn get_class_alias_internal<R: ClassResolver>(
    cls: &ClassData,
    resolver: Option<&R>,
) -> Option<ClassAlias> {
    let kotlin_metadata = cls.get_kotlin_metadata()?;

    // Check the kind (k) value:
    // k=1: Class metadata - d2[0] is the class name
    // k=2: File facade (*Kt classes) - d2 contains function names, NOT class name
    // k=3: Synthetic class (lambdas)
    // k=4: Multi-file facade
    // We should only extract class alias for k=1
    if let Some(kind) = kotlin_metadata.kind {
        if kind != 1 {
            return None; // Not a regular class, d2[0] is not a class name
        }
    }

    let first_value = kotlin_metadata.data2.as_ref()?.get(0)?.trim();

    if first_value.is_empty() {
        return None;
    }

    let cleaned_name = clean_object_name(first_value);
    if cleaned_name.is_empty() {
        return None;
    }

    let result = split_and_check_cls_name(cls, &cleaned_name, resolver);
    if result.is_some() && cls.class_type.contains("/c/") {
        eprintln!("Kotlin alias SUCCESS: {} -> {:?}", cls.class_type, result);
    }
    result
}

fn split_and_check_cls_name<R: ClassResolver>(
    origin_cls: &ClassData,
    full_cls_name: &str,
    resolver: Option<&R>,
) -> Option<ClassAlias> {
    if !is_valid_full_identifier(full_cls_name) {
        if origin_cls.class_type.contains("/c/") {
            eprintln!("Kotlin alias fail [invalid identifier]: {} -> {}", origin_cls.class_type, full_cls_name);
        }
        return None;
    }

    let pkg: String;
    let name: String;
    if let Some(dot) = full_cls_name.rfind('.') {
        pkg = full_cls_name[..dot].to_string();
        name = full_cls_name[dot + 1..].to_string();
    } else {
        pkg = "".to_string();
        name = full_cls_name.to_string();
    }

    let origin_name = origin_cls.simple_name();
    if origin_name == name {
        if origin_cls.class_type.contains("/c/") {
            eprintln!("Kotlin alias fail [same name]: {} -> {}", origin_cls.class_type, full_cls_name);
        }
        return None;
    }
    if name.contains('$') {
        if origin_cls.class_type.contains("/c/") {
            eprintln!("Kotlin alias fail [contains $]: {} -> {}", origin_cls.class_type, full_cls_name);
        }
        return None;
    }
    if !is_valid_identifier(&name) {
        if origin_cls.class_type.contains("/c/") {
            eprintln!("Kotlin alias fail [invalid name]: {} -> {} name={}", origin_cls.class_type, full_cls_name, name);
        }
        return None;
    }
    if pkg.starts_with("java.") {
        if origin_cls.class_type.contains("/c/") {
            eprintln!("Kotlin alias fail [java pkg]: {} -> {}", origin_cls.class_type, full_cls_name);
        }
        return None;
    }

    // Check package depth matches - prevent moving classes across package hierarchies
    // Note: origin_cls.package() returns with slashes, convert to dots for comparison
    let origin_pkg = origin_cls.package().unwrap_or("").replace('/', ".");
    if count_pkg_parts(&origin_pkg) != count_pkg_parts(&pkg) {
        if origin_cls.class_type.contains("/c/") {
            eprintln!("Kotlin alias fail [pkg depth]: {} origin_pkg={} ({}) vs pkg={} ({})",
                origin_cls.class_type, origin_pkg, count_pkg_parts(&origin_pkg), pkg, count_pkg_parts(&pkg));
        }
        return None;
    }

    // Check if the resolved class exists (if a resolver is provided)
    if let Some(resolver) = resolver {
        // Convert dotted package name to JVM internal format for lookup
        let internal_name = full_cls_name.replace('.', "/");
        if !resolver.class_exists(&internal_name) {
            if origin_cls.class_type.contains("/c/") {
                eprintln!("Kotlin alias fail [class not found]: {} -> {} (internal: {})",
                    origin_cls.class_type, full_cls_name, internal_name);
            }
            return None;
        }
    }

    Some(ClassAlias::new(pkg, name))
}

fn clean_object_name(name: &str) -> String {
    // Basic cleaning, similar to Jadx's Utils.cleanObjectName
    // First, handle DEX descriptor format: strip L prefix and ; suffix
    let stripped = name
        .strip_prefix('L')
        .unwrap_or(name)
        .strip_suffix(';')
        .unwrap_or(name);

    // Convert JVM internal format (slashes) to dots
    let with_dots = stripped.replace('/', ".");

    // Replace remaining invalid characters with '_'
    with_dots.chars()
        .map(|c| if c.is_alphanumeric() || c == '_' || c == '.' { c } else { '_' })
        .collect()
}

fn is_valid_full_identifier(name: &str) -> bool {
    if name.is_empty() {
        return false;
    }
    let mut parts = name.split('.');
    for part in parts.by_ref() {
        if !is_valid_identifier(part) {
            return false;
        }
    }
    true
}

fn is_valid_identifier(name: &str) -> bool {
    if name.is_empty() {
        return false;
    }
    let mut chars = name.chars();
    let first_char = chars.next().unwrap(); // name is not empty
    if !(first_char.is_alphabetic() || first_char == '_') {
        return false;
    }
    for c in chars {
        if !(c.is_alphanumeric() || c == '_') {
            return false;
        }
    }
    true
}

/// Counts the number of parts in a package name (dot-separated segments).
/// Empty package = 0, "com" = 1, "com.example" = 2, etc.
fn count_pkg_parts(pkg: &str) -> usize {
    if pkg.is_empty() {
        return 0;
    }
    pkg.chars().filter(|&c| c == '.').count() + 1
}
