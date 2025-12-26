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
    /// Type aliases defined in this class/package (Kotlin 1.1+)
    pub type_aliases: Vec<KotlinTypeAlias>,
    /// Context receivers for the class (Kotlin 1.6+)
    pub context_receivers: Vec<String>,
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
    /// Context receivers for the function (Kotlin 1.6+)
    pub context_receivers: Vec<String>,
    /// Function contract (Kotlin 1.3+)
    pub contract: Option<KotlinContract>,
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
    /// Context receivers for the property (Kotlin 1.6+)
    pub context_receivers: Vec<String>,
}

// ============================================================================
// Type Alias Support (Kotlin 1.1+)
// ============================================================================

/// A Kotlin type alias definition
/// Proto reference: metadata.proto:461-485
#[derive(Debug, Clone)]
pub struct KotlinTypeAlias {
    /// The name of the type alias (e.g., "StringList")
    pub name: String,
    /// Type parameters if generic (e.g., for `typealias Predicate<T> = (T) -> Boolean`)
    pub type_parameters: Vec<KotlinTypeParameter>,
    /// The underlying type (immediate alias target)
    pub underlying_type: String,
    /// The fully expanded type (all aliases resolved)
    pub expanded_type: String,
}

// ============================================================================
// Function Contract Support (Kotlin 1.3+)
// ============================================================================

/// A Kotlin function contract
/// Proto reference: metadata.proto:586-588
#[derive(Debug, Clone)]
pub struct KotlinContract {
    /// List of effects in the contract
    pub effects: Vec<KotlinEffect>,
}

impl KotlinContract {
    /// Format the contract as a human-readable string for output
    pub fn format(&self, param_names: &[String]) -> String {
        self.effects
            .iter()
            .map(|e| e.format(param_names))
            .collect::<Vec<_>>()
            .join("; ")
    }
}

/// A single effect in a contract
/// Proto reference: metadata.proto:590-632
#[derive(Debug, Clone)]
pub struct KotlinEffect {
    /// The type of effect
    pub effect_type: ContractEffectType,
    /// Invocation kind for CallsInPlace effects
    pub invocation_kind: Option<InvocationKind>,
    /// Condition for conditional effects (Effect -> Expression)
    pub condition: Option<ContractExpression>,
}

impl KotlinEffect {
    /// Format the effect as a human-readable string
    pub fn format(&self, param_names: &[String]) -> String {
        let base = match &self.effect_type {
            ContractEffectType::ReturnsConstant { value } => {
                match value {
                    Some(ConstantValue::True) => "returns(true)".to_string(),
                    Some(ConstantValue::False) => "returns(false)".to_string(),
                    Some(ConstantValue::Null) => "returns(null)".to_string(),
                    None => "returns()".to_string(),
                }
            }
            ContractEffectType::CallsInPlace { param_index } => {
                let param_name = param_names.get(*param_index)
                    .map(|s| s.as_str())
                    .unwrap_or("param");
                let kind = self.invocation_kind
                    .as_ref()
                    .map(|k| format!(", {}", k.as_str()))
                    .unwrap_or_default();
                format!("callsInPlace({}{})", param_name, kind)
            }
            ContractEffectType::ReturnsNotNull => "returnsNotNull()".to_string(),
        };

        if let Some(ref cond) = self.condition {
            format!("{} -> {}", base, cond.format(param_names))
        } else {
            base
        }
    }
}

/// The type of contract effect
/// Proto reference: metadata.proto:596-606
#[derive(Debug, Clone)]
pub enum ContractEffectType {
    /// Returns a constant value (true, false, null, or unspecified)
    ReturnsConstant { value: Option<ConstantValue> },
    /// Calls a lambda parameter in place
    CallsInPlace { param_index: usize },
    /// Returns a non-null value
    ReturnsNotNull,
}

/// How many times a lambda is invoked
/// Proto reference: metadata.proto:615-619
#[derive(Debug, Clone, Copy, PartialEq, Eq)]
pub enum InvocationKind {
    AtMostOnce,
    ExactlyOnce,
    AtLeastOnce,
}

impl InvocationKind {
    /// Convert from proto enum value
    pub fn from_proto(value: i32) -> Option<Self> {
        match value {
            0 => Some(InvocationKind::AtMostOnce),
            1 => Some(InvocationKind::ExactlyOnce),
            2 => Some(InvocationKind::AtLeastOnce),
            _ => None,
        }
    }

    /// Get the Kotlin keyword representation
    pub fn as_str(&self) -> &'static str {
        match self {
            InvocationKind::AtMostOnce => "AT_MOST_ONCE",
            InvocationKind::ExactlyOnce => "EXACTLY_ONCE",
            InvocationKind::AtLeastOnce => "AT_LEAST_ONCE",
        }
    }
}

/// A constant value in contract expressions
/// Proto reference: metadata.proto:647-651
#[derive(Debug, Clone, Copy, PartialEq, Eq)]
pub enum ConstantValue {
    True,
    False,
    Null,
}

impl ConstantValue {
    /// Convert from proto enum value
    pub fn from_proto(value: i32) -> Option<Self> {
        match value {
            0 => Some(ConstantValue::True),
            1 => Some(ConstantValue::False),
            2 => Some(ConstantValue::Null),
            _ => None,
        }
    }
}

/// A boolean expression in a contract
/// Proto reference: metadata.proto:636-668
#[derive(Debug, Clone)]
pub struct ContractExpression {
    /// Whether this expression is negated
    pub is_negated: bool,
    /// Whether this is an is-null predicate
    pub is_null_predicate: bool,
    /// Reference to a value parameter (1-indexed, 0 = extension receiver)
    pub param_reference: Option<usize>,
    /// Constant value (true, false, null)
    pub constant_value: Option<ConstantValue>,
    /// Type for is-instance predicate
    pub is_instance_type: Option<String>,
    /// AND expressions
    pub and_expressions: Vec<ContractExpression>,
    /// OR expressions
    pub or_expressions: Vec<ContractExpression>,
}

impl ContractExpression {
    /// Format the expression as a human-readable string
    pub fn format(&self, param_names: &[String]) -> String {
        let mut parts = Vec::new();

        // Handle parameter reference
        if let Some(idx) = self.param_reference {
            let param_name = if idx == 0 {
                "this".to_string()
            } else {
                param_names.get(idx - 1)
                    .cloned()
                    .unwrap_or_else(|| format!("param{}", idx))
            };

            let expr = if self.is_null_predicate {
                if self.is_negated {
                    format!("{} != null", param_name)
                } else {
                    format!("{} == null", param_name)
                }
            } else if let Some(ref type_name) = self.is_instance_type {
                if self.is_negated {
                    format!("{} !is {}", param_name, type_name)
                } else {
                    format!("{} is {}", param_name, type_name)
                }
            } else {
                param_name
            };
            parts.push(expr);
        }

        // Handle constant value
        if let Some(cv) = &self.constant_value {
            let val = match cv {
                ConstantValue::True => "true",
                ConstantValue::False => "false",
                ConstantValue::Null => "null",
            };
            parts.push(val.to_string());
        }

        // Handle AND expressions
        if !self.and_expressions.is_empty() {
            let and_parts: Vec<_> = self.and_expressions
                .iter()
                .map(|e| e.format(param_names))
                .collect();
            parts.push(format!("({})", and_parts.join(" && ")));
        }

        // Handle OR expressions
        if !self.or_expressions.is_empty() {
            let or_parts: Vec<_> = self.or_expressions
                .iter()
                .map(|e| e.format(param_names))
                .collect();
            parts.push(format!("({})", or_parts.join(" || ")));
        }

        if parts.is_empty() {
            "true".to_string()
        } else if parts.len() == 1 {
            parts.into_iter().next().unwrap()
        } else {
            parts.join(" && ")
        }
    }
}
