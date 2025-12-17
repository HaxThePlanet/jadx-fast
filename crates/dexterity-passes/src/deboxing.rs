//! Deboxing visitor for removing primitive boxing
//!
//! This pass removes unnecessary primitive boxing operations like:
//! - `Integer.valueOf(1)` -> `1`
//! - `Boolean.valueOf(true)` -> `true`
//! - `Long.valueOf(42L)` -> `42L`
//!
//! Based on JADX's DeboxingVisitor.java

use rustc_hash::{FxHashMap, FxHashSet};

use dexterity_ir::instructions::{InsnArg, InsnNode, InsnType, LiteralArg, RegisterArg};
use dexterity_ir::types::ArgType;

use crate::ssa::SsaResult;

/// Result of the deboxing pass
#[derive(Debug, Default)]
pub struct DeboxingResult {
    /// Number of boxing calls removed
    pub deboxed_count: usize,
    /// Types of boxing removed (for diagnostics)
    pub deboxed_types: Vec<String>,
}

/// Boxing method signatures for each primitive type
#[derive(Debug, Clone)]
struct BoxingMethod {
    /// Class name (e.g., "java/lang/Integer")
    class_name: &'static str,
    /// Method name (always "valueOf")
    method_name: &'static str,
    /// Primitive argument type
    primitive_type: ArgType,
    /// Box return type
    box_type: ArgType,
}

/// Get boxing methods dynamically (can't use const with String)
fn get_boxing_methods() -> Vec<BoxingMethod> {
    vec![
        BoxingMethod {
            class_name: "java/lang/Integer",
            method_name: "valueOf",
            primitive_type: ArgType::Int,
            box_type: ArgType::Object("java/lang/Integer".to_string()),
        },
        BoxingMethod {
            class_name: "java/lang/Boolean",
            method_name: "valueOf",
            primitive_type: ArgType::Boolean,
            box_type: ArgType::Object("java/lang/Boolean".to_string()),
        },
        BoxingMethod {
            class_name: "java/lang/Byte",
            method_name: "valueOf",
            primitive_type: ArgType::Byte,
            box_type: ArgType::Object("java/lang/Byte".to_string()),
        },
        BoxingMethod {
            class_name: "java/lang/Short",
            method_name: "valueOf",
            primitive_type: ArgType::Short,
            box_type: ArgType::Object("java/lang/Short".to_string()),
        },
        BoxingMethod {
            class_name: "java/lang/Character",
            method_name: "valueOf",
            primitive_type: ArgType::Char,
            box_type: ArgType::Object("java/lang/Character".to_string()),
        },
        BoxingMethod {
            class_name: "java/lang/Long",
            method_name: "valueOf",
            primitive_type: ArgType::Long,
            box_type: ArgType::Object("java/lang/Long".to_string()),
        },
        BoxingMethod {
            class_name: "java/lang/Float",
            method_name: "valueOf",
            primitive_type: ArgType::Float,
            box_type: ArgType::Object("java/lang/Float".to_string()),
        },
        BoxingMethod {
            class_name: "java/lang/Double",
            method_name: "valueOf",
            primitive_type: ArgType::Double,
            box_type: ArgType::Object("java/lang/Double".to_string()),
        },
    ]
}

/// Deboxing context
pub struct Deboxing {
    /// Method lookup for checking invoke targets
    method_lookup: Option<Box<dyn Fn(u32) -> Option<MethodInfo> + Send + Sync>>,
}

/// Method info for boxing method detection
#[derive(Debug, Clone)]
pub struct MethodInfo {
    /// Declaring class
    pub class_name: String,
    /// Method name
    pub method_name: String,
    /// Parameter types
    pub param_types: Vec<ArgType>,
    /// Return type
    pub return_type: ArgType,
    /// Is static method
    pub is_static: bool,
}

impl Deboxing {
    /// Create a new deboxing pass
    pub fn new() -> Self {
        Self {
            method_lookup: None,
        }
    }

    /// Set method lookup function
    pub fn with_method_lookup<F>(mut self, lookup: F) -> Self
    where
        F: Fn(u32) -> Option<MethodInfo> + Send + Sync + 'static,
    {
        self.method_lookup = Some(Box::new(lookup));
        self
    }

    /// Check if a method is a boxing valueOf method
    fn is_boxing_method(&self, method_idx: u32) -> Option<BoxingMethod> {
        let lookup = self.method_lookup.as_ref()?;
        let method_info = lookup(method_idx)?;

        // Must be static valueOf method
        if !method_info.is_static || method_info.method_name != "valueOf" {
            return None;
        }

        // Must have exactly one argument
        if method_info.param_types.len() != 1 {
            return None;
        }

        // Find matching boxing method
        for boxing in get_boxing_methods() {
            if method_info.class_name == boxing.class_name
                && method_info.param_types[0] == boxing.primitive_type
            {
                return Some(boxing);
            }
        }

        None
    }

    /// Check if an instruction is a boxing call that can be deboxed
    fn check_for_deboxing(&self, insn: &InsnNode) -> Option<DeboxingReplacement> {
        match &insn.insn_type {
            InsnType::Invoke { method_idx, args, .. } => {
                // Check if this is a static valueOf call
                let boxing = self.is_boxing_method(*method_idx)?;

                // Must have exactly one argument (the primitive value)
                if args.len() != 1 {
                    return None;
                }

                // The argument should be a literal for best results
                let arg = &args[0];
                if let InsnArg::Literal(lit) = arg {
                    Some(DeboxingReplacement {
                        literal: lit.clone(),
                        primitive_type: boxing.primitive_type.clone(),
                        needs_explicit_cast: self.needs_explicit_cast(&boxing.primitive_type),
                    })
                } else {
                    // For register arguments, we can still potentially debox
                    // but need more analysis
                    None
                }
            }
            _ => None,
        }
    }

    /// Check if we need an explicit cast for this primitive type
    fn needs_explicit_cast(&self, prim_type: &ArgType) -> bool {
        // Long always needs explicit cast (L suffix)
        matches!(prim_type, ArgType::Long)
    }

    /// Process a single block and return replacement instructions
    fn process_block(&self, insns: &[InsnNode]) -> Vec<(usize, InsnNode)> {
        let mut replacements = Vec::new();

        for (idx, insn) in insns.iter().enumerate() {
            if let Some(replacement) = self.check_for_deboxing(insn) {
                // Create a CONST instruction to replace the INVOKE
                if let InsnType::Invoke { .. } = &insn.insn_type {
                    // We need the result register from the original instruction
                    // In SSA form, MoveResult captures the return value
                    // For now, create a standalone const that will need pairing
                    let const_insn = InsnNode::new(
                        InsnType::Const {
                            dest: RegisterArg::new(0), // placeholder
                            value: replacement.literal,
                        },
                        insn.offset,
                    );
                    replacements.push((idx, const_insn));
                }
            }
        }

        replacements
    }
}

impl Default for Deboxing {
    fn default() -> Self {
        Self::new()
    }
}

/// Replacement information for deboxing
#[derive(Debug)]
struct DeboxingReplacement {
    /// The literal value to use
    literal: LiteralArg,
    /// The primitive type
    primitive_type: ArgType,
    /// Whether an explicit cast is needed
    needs_explicit_cast: bool,
}

/// Run the deboxing pass on SSA result
pub fn debox_primitives(ssa: &SsaResult) -> DeboxingResult {
    let deboxing = Deboxing::new();
    let mut result = DeboxingResult::default();

    for block in &ssa.blocks {
        let replacements = deboxing.process_block(&block.instructions);
        result.deboxed_count += replacements.len();
    }

    result
}

/// Run the deboxing pass with method lookup
pub fn debox_primitives_with_lookup<F>(ssa: &SsaResult, method_lookup: F) -> DeboxingResult
where
    F: Fn(u32) -> Option<MethodInfo> + Send + Sync + 'static,
{
    let deboxing = Deboxing::new().with_method_lookup(method_lookup);
    let mut result = DeboxingResult::default();

    for block in &ssa.blocks {
        let replacements = deboxing.process_block(&block.instructions);
        for (_, _) in &replacements {
            result.deboxed_count += 1;
        }
    }

    result
}

/// Unboxing methods for primitive extraction
/// These handle calls like `intValue()`, `booleanValue()`, etc.
#[derive(Debug, Clone)]
struct UnboxingMethod {
    /// Class name (e.g., "java/lang/Integer")
    class_name: &'static str,
    /// Method name (e.g., "intValue")
    method_name: &'static str,
    /// Primitive result type
    primitive_type: ArgType,
}

/// Standard unboxing methods
const UNBOXING_METHODS: &[UnboxingMethod] = &[
    UnboxingMethod {
        class_name: "java/lang/Integer",
        method_name: "intValue",
        primitive_type: ArgType::Int,
    },
    UnboxingMethod {
        class_name: "java/lang/Boolean",
        method_name: "booleanValue",
        primitive_type: ArgType::Boolean,
    },
    UnboxingMethod {
        class_name: "java/lang/Byte",
        method_name: "byteValue",
        primitive_type: ArgType::Byte,
    },
    UnboxingMethod {
        class_name: "java/lang/Short",
        method_name: "shortValue",
        primitive_type: ArgType::Short,
    },
    UnboxingMethod {
        class_name: "java/lang/Character",
        method_name: "charValue",
        primitive_type: ArgType::Char,
    },
    UnboxingMethod {
        class_name: "java/lang/Long",
        method_name: "longValue",
        primitive_type: ArgType::Long,
    },
    UnboxingMethod {
        class_name: "java/lang/Float",
        method_name: "floatValue",
        primitive_type: ArgType::Float,
    },
    UnboxingMethod {
        class_name: "java/lang/Double",
        method_name: "doubleValue",
        primitive_type: ArgType::Double,
    },
];

/// Check if a method is an unboxing method (e.g., intValue())
pub fn is_unboxing_method(class_name: &str, method_name: &str) -> Option<ArgType> {
    for unboxing in UNBOXING_METHODS {
        if class_name == unboxing.class_name && method_name == unboxing.method_name {
            return Some(unboxing.primitive_type.clone());
        }
    }
    None
}

/// Check if a class is a primitive wrapper class
pub fn is_wrapper_class(class_name: &str) -> bool {
    matches!(
        class_name,
        "java/lang/Integer"
            | "java/lang/Boolean"
            | "java/lang/Byte"
            | "java/lang/Short"
            | "java/lang/Character"
            | "java/lang/Long"
            | "java/lang/Float"
            | "java/lang/Double"
    )
}

/// Get the primitive type for a wrapper class
pub fn primitive_for_wrapper(class_name: &str) -> Option<ArgType> {
    match class_name {
        "java/lang/Integer" => Some(ArgType::Int),
        "java/lang/Boolean" => Some(ArgType::Boolean),
        "java/lang/Byte" => Some(ArgType::Byte),
        "java/lang/Short" => Some(ArgType::Short),
        "java/lang/Character" => Some(ArgType::Char),
        "java/lang/Long" => Some(ArgType::Long),
        "java/lang/Float" => Some(ArgType::Float),
        "java/lang/Double" => Some(ArgType::Double),
        _ => None,
    }
}

/// Get the wrapper class for a primitive type
pub fn wrapper_for_primitive(prim_type: &ArgType) -> Option<&'static str> {
    match prim_type {
        ArgType::Int => Some("java/lang/Integer"),
        ArgType::Boolean => Some("java/lang/Boolean"),
        ArgType::Byte => Some("java/lang/Byte"),
        ArgType::Short => Some("java/lang/Short"),
        ArgType::Char => Some("java/lang/Character"),
        ArgType::Long => Some("java/lang/Long"),
        ArgType::Float => Some("java/lang/Float"),
        ArgType::Double => Some("java/lang/Double"),
        _ => None,
    }
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn test_is_wrapper_class() {
        assert!(is_wrapper_class("java/lang/Integer"));
        assert!(is_wrapper_class("java/lang/Boolean"));
        assert!(is_wrapper_class("java/lang/Long"));
        assert!(!is_wrapper_class("java/lang/String"));
        assert!(!is_wrapper_class("java/lang/Object"));
    }

    #[test]
    fn test_primitive_for_wrapper() {
        assert_eq!(primitive_for_wrapper("java/lang/Integer"), Some(ArgType::Int));
        assert_eq!(primitive_for_wrapper("java/lang/Boolean"), Some(ArgType::Boolean));
        assert_eq!(primitive_for_wrapper("java/lang/Long"), Some(ArgType::Long));
        assert_eq!(primitive_for_wrapper("java/lang/String"), None);
    }

    #[test]
    fn test_wrapper_for_primitive() {
        assert_eq!(wrapper_for_primitive(&ArgType::Int), Some("java/lang/Integer"));
        assert_eq!(wrapper_for_primitive(&ArgType::Boolean), Some("java/lang/Boolean"));
        assert_eq!(wrapper_for_primitive(&ArgType::Long), Some("java/lang/Long"));
        assert_eq!(wrapper_for_primitive(&ArgType::Object("test".into())), None);
    }

    #[test]
    fn test_is_unboxing_method() {
        assert_eq!(
            is_unboxing_method("java/lang/Integer", "intValue"),
            Some(ArgType::Int)
        );
        assert_eq!(
            is_unboxing_method("java/lang/Boolean", "booleanValue"),
            Some(ArgType::Boolean)
        );
        assert_eq!(is_unboxing_method("java/lang/Integer", "toString"), None);
    }

    #[test]
    fn test_needs_explicit_cast() {
        let deboxing = Deboxing::new();
        assert!(deboxing.needs_explicit_cast(&ArgType::Long));
        assert!(!deboxing.needs_explicit_cast(&ArgType::Int));
        assert!(!deboxing.needs_explicit_cast(&ArgType::Boolean));
    }
}
