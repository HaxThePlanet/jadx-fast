//! High-level types for Kotlin metadata

#[derive(Debug, Clone)]
pub enum KotlinKind {
    Class,
    FileFacade,
    SyntheticClass,
    MultiFileClassFacade,
    MultiFileClassPart,
}

/// Type parameter variance (in/out modifiers)
/// Maps to Kotlin's declaration-site variance annotations
#[derive(Debug, Clone, Copy, PartialEq, Eq, Default)]
pub enum KotlinVariance {
    /// Contravariant (`in` modifier)
    In,
    /// Covariant (`out` modifier)
    Out,
    /// Invariant (no modifier)
    #[default]
    Invariant,
}

impl KotlinVariance {
    /// Convert from proto variance enum value
    /// Proto: IN=0, OUT=1, INV=2
    pub fn from_proto(value: i32) -> Self {
        match value {
            0 => KotlinVariance::In,
            1 => KotlinVariance::Out,
            _ => KotlinVariance::Invariant,
        }
    }

    /// Convert to IR TypeVariance
    pub fn to_ir(&self) -> dexterity_ir::info::TypeVariance {
        match self {
            KotlinVariance::In => dexterity_ir::info::TypeVariance::Contravariant,
            KotlinVariance::Out => dexterity_ir::info::TypeVariance::Covariant,
            KotlinVariance::Invariant => dexterity_ir::info::TypeVariance::Invariant,
        }
    }
}

/// A Kotlin type parameter with variance and reification info
#[derive(Debug, Clone)]
pub struct KotlinTypeParameter {
    /// The name of the type parameter (e.g., "T", "E")
    pub name: String,
    /// Variance (in/out/invariant)
    pub variance: KotlinVariance,
    /// Whether this is a reified type parameter
    pub reified: bool,
    /// Upper bounds (e.g., T : Any, T : Comparable<T>)
    pub upper_bounds: Vec<String>,
}

/// Kotlin class flags extracted from protobuf
#[derive(Debug, Clone, Default)]
pub struct KotlinClassFlags {
    /// Is this a data class
    pub is_data: bool,
    /// Is this a sealed class
    pub is_sealed: bool,
    /// Is this an inline/value class
    pub is_inline: bool,
    /// Is this an inner class
    pub is_inner: bool,
    /// Is this an external class
    pub is_external: bool,
    /// Is this an expect class (multiplatform)
    pub is_expect: bool,
    /// Is this a fun interface (SAM)
    pub is_fun_interface: bool,
}

#[derive(Debug, Clone)]
pub struct KotlinClassMetadata {
    pub kind: KotlinKind,
    pub class_name: String,
    pub functions: Vec<KotlinFunction>,
    pub properties: Vec<KotlinProperty>,
    pub companion_object: Option<String>,
    pub is_data_class: bool,
    /// Additional class flags
    pub flags: KotlinClassFlags,
    /// Sealed subclass FQ names
    pub sealed_subclasses: Vec<String>,
    /// Type parameters with variance information
    pub type_parameters: Vec<KotlinTypeParameter>,
}

/// Kotlin function flags extracted from protobuf
#[derive(Debug, Clone, Default)]
pub struct KotlinFunctionFlags {
    /// Is this a suspend function
    pub is_suspend: bool,
    /// Is this an inline function
    pub is_inline: bool,
    /// Is this an operator function
    pub is_operator: bool,
    /// Is this an infix function
    pub is_infix: bool,
    /// Is this a tailrec function
    pub is_tailrec: bool,
    /// Is this an external function
    pub is_external: bool,
}

#[derive(Debug, Clone)]
pub struct KotlinFunction {
    pub name: String,
    pub jvm_signature: String,
    pub parameters: Vec<KotlinParameter>,
    /// Function modifier flags
    pub flags: KotlinFunctionFlags,
    /// Receiver type for extension functions (None for regular functions)
    pub receiver_type: Option<String>,
}

#[derive(Debug, Clone)]
pub struct KotlinParameter {
    pub name: String,
    pub index: usize,
    /// Is this parameter crossinline (lambdas)
    pub is_crossinline: bool,
    /// Is this parameter noinline (lambdas)
    pub is_noinline: bool,
}

/// Kotlin property flags extracted from protobuf
#[derive(Debug, Clone, Default)]
pub struct KotlinPropertyFlags {
    /// Is this a var (mutable) property
    pub is_var: bool,
    /// Is this a const property
    pub is_const: bool,
    /// Is this a lateinit property
    pub is_lateinit: bool,
    /// Is this a delegated property
    pub is_delegated: bool,
    /// Has this property a backing field
    pub has_backing_field: bool,
}

#[derive(Debug, Clone)]
pub struct KotlinProperty {
    pub name: String,
    pub jvm_field_signature: String,
    pub getter_signature: Option<String>,
    pub setter_signature: Option<String>,
    /// Property modifier flags
    pub flags: KotlinPropertyFlags,
}
