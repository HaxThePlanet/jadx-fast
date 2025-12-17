
use crate::info::{Annotation, AnnotationValue, ClassData};

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

pub fn get_class_alias(cls: &ClassData) -> Option<ClassAlias> {
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

    split_and_check_cls_name(cls, &cleaned_name)
}

fn split_and_check_cls_name(origin_cls: &ClassData, full_cls_name: &str) -> Option<ClassAlias> {
    if !is_valid_full_identifier(full_cls_name) {
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
    if origin_name == name || name.contains('$') || !is_valid_identifier(&name) || pkg.starts_with("java.") {
        return None;
    }

    // TODO: Implement check for package part count and class existence in root node
    // For now, these checks are omitted for simplicity, but are crucial for full JADX parity.
    // origin_cls.root().resolveClass(fullClsName) equivalent is needed here.
    // countPkgParts(originClsInfo.getPackage()) != countPkgParts(pkg) equivalent is needed here.

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
