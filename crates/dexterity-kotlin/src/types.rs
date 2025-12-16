//! High-level types for Kotlin metadata

#[derive(Debug, Clone)]
pub enum KotlinKind {
    Class,
    FileFacade,
    SyntheticClass,
    MultiFileClassFacade,
    MultiFileClassPart,
}

#[derive(Debug, Clone)]
pub struct KotlinClassMetadata {
    pub kind: KotlinKind,
    pub class_name: String,
    pub functions: Vec<KotlinFunction>,
    pub properties: Vec<KotlinProperty>,
    pub companion_object: Option<String>,
    pub is_data_class: bool,
}

#[derive(Debug, Clone)]
pub struct KotlinFunction {
    pub name: String,
    pub jvm_signature: String,
    pub parameters: Vec<KotlinParameter>,
}

#[derive(Debug, Clone)]
pub struct KotlinParameter {
    pub name: String,
    pub index: usize,
}

#[derive(Debug, Clone)]
pub struct KotlinProperty {
    pub name: String,
    pub jvm_field_signature: String,
    pub getter_signature: Option<String>,
    pub setter_signature: Option<String>,
}
