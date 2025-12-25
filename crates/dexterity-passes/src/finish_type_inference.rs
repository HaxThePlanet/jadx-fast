//! Finish Type Inference Pass
//!
//! This pass runs after type inference to validate and finalize types.
//! It matches JADX's `FinishTypeInference.java` visitor.
//!
//! ## Purpose
//!
//! 1. Check all SSA variables have known types
//! 2. Generate warning messages for variables with unknown types
//! 3. Track statistics about type inference completeness
//!
//! ## Usage
//!
//! ```ignore
//! let result = finish_type_inference(&ssa_result, &type_result);
//! for warning in &result.warnings {
//!     println!("Warning: {}", warning);
//! }
//! ```
//!
//! ## JADX Parity
//!
//! This matches JADX's FinishTypeInference.java which:
//! - Iterates all SSA variables in the method
//! - Checks if type is known via `type.isTypeKnown()`
//! - Adds warning comment if type inference failed
//! - Sets CodeVar type to UNKNOWN if it was null

use dexterity_ir::types::ArgType;

use crate::ssa::SsaResult;
use crate::type_inference::TypeInferenceResult;
use crate::var_naming::VarNamingResult;

/// Result of the finish type inference pass
#[derive(Debug, Default, Clone)]
pub struct FinishTypeInferenceResult {
    /// Warning messages for variables with unknown types
    /// Format: "Type inference failed for: r{reg}v{version}, type: {type}"
    pub warnings: Vec<String>,

    /// Number of variables checked
    pub total_vars: usize,

    /// Number of variables with known types
    pub known_types: usize,

    /// Number of variables with unknown types
    pub unknown_types: usize,

    /// Whether all types are now known
    pub all_types_known: bool,
}

impl FinishTypeInferenceResult {
    /// Check if the method has type inference issues
    pub fn has_warnings(&self) -> bool {
        !self.warnings.is_empty()
    }

    /// Get a summary string
    pub fn summary(&self) -> String {
        format!(
            "FinishTypeInference: {}/{} types known, {} warnings",
            self.known_types, self.total_vars, self.warnings.len()
        )
    }
}

/// Run the finish type inference pass
///
/// This validates type inference results and generates warnings for
/// any SSA variables that still have unknown types.
///
/// # Arguments
///
/// * `ssa` - The SSA result containing all SSA variables
/// * `types` - The type inference result with resolved types
///
/// # Returns
///
/// A result containing warnings and statistics about type inference completeness.
pub fn finish_type_inference(
    ssa: &SsaResult,
    types: &TypeInferenceResult,
) -> FinishTypeInferenceResult {
    finish_type_inference_with_names(ssa, types, None)
}

/// Run the finish type inference pass with optional variable names
///
/// This variant includes variable names in warning messages if available.
///
/// # Arguments
///
/// * `ssa` - The SSA result containing all SSA variables
/// * `types` - The type inference result with resolved types
/// * `var_naming` - Optional var naming result for variable names in warnings
///
/// # Returns
///
/// A result containing warnings and statistics about type inference completeness.
pub fn finish_type_inference_with_names(
    ssa: &SsaResult,
    types: &TypeInferenceResult,
    var_naming: Option<&VarNamingResult>,
) -> FinishTypeInferenceResult {
    let mut result = FinishTypeInferenceResult::default();

    // Collect all SSA variable references from the SSA result
    // Variables are identified by (reg_num, version) pairs
    let mut all_vars: Vec<(u16, u32)> = Vec::new();

    // Gather from max_versions (all registers that have SSA versions)
    for (&reg, &max_ver) in &ssa.max_versions {
        for ver in 0..=max_ver {
            all_vars.push((reg, ver));
        }
    }

    result.total_vars = all_vars.len();

    // Check each variable
    for (reg, ver) in all_vars {
        let type_key = (reg, ver);

        // Get the resolved type for this variable
        let resolved_type = types.types.get(&type_key);

        let is_known = match resolved_type {
            Some(ty) => is_type_known(ty),
            None => false,
        };

        if is_known {
            result.known_types += 1;
        } else {
            result.unknown_types += 1;

            // Generate warning message matching JADX format
            let var_info = get_detailed_var_info(reg, ver, resolved_type, var_naming);
            let warning = format!("Type inference failed for: {}", var_info);
            result.warnings.push(warning);
        }
    }

    result.all_types_known = result.unknown_types == 0;
    result
}

/// Check if a type is considered "known" (not Unknown or unresolved)
///
/// Matches JADX's `ArgType.isTypeKnown()` method.
fn is_type_known(ty: &ArgType) -> bool {
    match ty {
        ArgType::Unknown => false,
        ArgType::UnknownNarrow => false,
        ArgType::UnknownWide => false,
        ArgType::UnknownObject => false,
        ArgType::UnknownArray => false,
        ArgType::Array(elem) => is_type_known(elem),
        // Generic types are known if base class is specified
        ArgType::Generic { base, .. } => !base.is_empty(),
        _ => true,
    }
}

/// Get detailed variable info for warning messages
///
/// Matches JADX's `SSAVar.getDetailedVarInfo(mth)` format:
/// "r{reg}v{version}, name: '...', type: ..."
fn get_detailed_var_info(
    reg: u16,
    ver: u32,
    resolved_type: Option<&ArgType>,
    var_naming: Option<&VarNamingResult>,
) -> String {
    let mut parts = vec![format!("r{}v{}", reg, ver)];

    // Add variable name if available
    if let Some(naming) = var_naming {
        if let Some(name) = naming.names.get(&(reg, ver)) {
            parts.push(format!("name: '{}'", name));
        }
    }

    // Add type info
    if let Some(ty) = resolved_type {
        parts.push(format!("type: {}", ty.short_name()));
    } else {
        parts.push("type: <unresolved>".to_string());
    }

    parts.join(", ")
}

#[cfg(test)]
mod tests {
    use super::*;
    use crate::ssa::SsaResult;
    use rustc_hash::FxHashMap;
    use std::collections::HashMap;

    fn make_test_ssa() -> SsaResult {
        SsaResult {
            blocks: vec![],
            dominators: FxHashMap::default(),
            dom_frontiers: FxHashMap::default(),
            max_versions: FxHashMap::from_iter([(0, 2), (1, 1)]),
            ssa_context: dexterity_ir::ssa::SSAContext::new(),
        }
    }

    fn make_test_types() -> TypeInferenceResult {
        let mut types = HashMap::new();
        types.insert((0, 0), ArgType::Int);
        types.insert((0, 1), ArgType::Int);
        types.insert((0, 2), ArgType::Unknown); // Unknown type!
        types.insert((1, 0), ArgType::Object("java/lang/String".to_string()));
        types.insert((1, 1), ArgType::Object("java/lang/String".to_string()));

        TypeInferenceResult {
            types,
            num_constraints: 5,
            num_type_vars: 5,
            num_resolved: 4,
        }
    }

    #[test]
    fn test_finish_detects_unknown_types() {
        let ssa = make_test_ssa();
        let types = make_test_types();

        let result = finish_type_inference(&ssa, &types);

        assert_eq!(result.total_vars, 5); // 3 versions of r0, 2 versions of r1
        assert_eq!(result.known_types, 4);
        assert_eq!(result.unknown_types, 1);
        assert!(!result.all_types_known);
        assert_eq!(result.warnings.len(), 1);
        assert!(result.warnings[0].contains("r0v2"));
    }

    #[test]
    fn test_finish_all_known() {
        let ssa = SsaResult {
            blocks: vec![],
            dominators: FxHashMap::default(),
            dom_frontiers: FxHashMap::default(),
            max_versions: FxHashMap::from_iter([(0, 0)]),
            ssa_context: dexterity_ir::ssa::SSAContext::new(),
        };

        let mut types = HashMap::new();
        types.insert((0, 0), ArgType::Int);

        let type_result = TypeInferenceResult {
            types,
            num_constraints: 1,
            num_type_vars: 1,
            num_resolved: 1,
        };

        let result = finish_type_inference(&ssa, &type_result);

        assert!(result.all_types_known);
        assert!(result.warnings.is_empty());
    }

    #[test]
    fn test_finish_with_names() {
        let ssa = make_test_ssa();
        let types = make_test_types();

        let mut naming = VarNamingResult {
            names: HashMap::new(),
        };
        naming.names.insert((0, 2), "myVar".to_string());

        let result = finish_type_inference_with_names(&ssa, &types, Some(&naming));

        assert_eq!(result.warnings.len(), 1);
        assert!(result.warnings[0].contains("myVar"));
    }

    #[test]
    fn test_is_type_known() {
        assert!(is_type_known(&ArgType::Int));
        assert!(is_type_known(&ArgType::Long));
        assert!(is_type_known(&ArgType::Object("java/lang/String".to_string())));
        assert!(is_type_known(&ArgType::Array(Box::new(ArgType::Int))));

        assert!(!is_type_known(&ArgType::Unknown));
        assert!(!is_type_known(&ArgType::UnknownNarrow));
        assert!(!is_type_known(&ArgType::UnknownWide));
        assert!(!is_type_known(&ArgType::UnknownObject));
        assert!(!is_type_known(&ArgType::Array(Box::new(ArgType::Unknown))));
    }
}
