//! Variable naming pass
//!
//! This pass assigns meaningful names to variables based on:
//! - Type information (e.g., "s" for String, "i" for int loop counters)
//! - Context (e.g., loop counters, array indices)
//! - SSA versioning (e.g., x1, x2 for different definitions)
//!
//! Based on JADX's variable naming strategy for 1:1 output compatibility.

use std::collections::{HashMap, HashSet};

use jadx_ir::types::ArgType;

use crate::ssa::SsaResult;
use crate::type_inference::TypeInferenceResult;

/// Result of variable naming pass
#[derive(Debug, Clone)]
pub struct VarNamingResult {
    /// Variable names: (reg, ssa_version) -> name
    pub names: HashMap<(u16, u32), String>,
}

/// Variable naming context
pub struct VarNaming {
    /// Used names at each scope level
    used_names: HashSet<String>,
    /// Counter for each base name (to generate unique suffixes)
    name_counters: HashMap<String, u32>,
    /// Parameter register start (parameters already have names)
    first_param_reg: u16,
}

impl VarNaming {
    /// Create a new variable naming context
    pub fn new(first_param_reg: u16) -> Self {
        VarNaming {
            used_names: HashSet::new(),
            name_counters: HashMap::new(),
            first_param_reg,
        }
    }

    /// Generate a unique name based on a base
    fn make_unique(&mut self, base: &str) -> String {
        // If base isn't used, use it directly
        if !self.used_names.contains(base) {
            self.used_names.insert(base.to_string());
            return base.to_string();
        }

        // Otherwise, add a numeric suffix
        let counter = self.name_counters.entry(base.to_string()).or_insert(1);
        loop {
            *counter += 1;
            let name = format!("{}{}", base, counter);
            if !self.used_names.contains(&name) {
                self.used_names.insert(name.clone());
                return name;
            }
        }
    }

    /// Get base name for a type
    fn base_name_for_type(ty: &ArgType) -> &'static str {
        match ty {
            ArgType::Boolean => "z",
            ArgType::Byte => "b",
            ArgType::Char => "c",
            ArgType::Short => "s",
            ArgType::Int => "i",
            ArgType::Long => "j",
            ArgType::Float => "f",
            ArgType::Double => "d",
            ArgType::Object(name) => {
                // Use first letter of simple name, lowercased
                if name.contains("String") {
                    "str"
                } else if name.contains("List") || name.contains("ArrayList") {
                    "list"
                } else if name.contains("Map") || name.contains("HashMap") {
                    "map"
                } else if name.contains("Set") || name.contains("HashSet") {
                    "set"
                } else if name.contains("Array") {
                    "arr"
                } else if name.contains("Iterator") {
                    "it"
                } else if name.contains("Exception") {
                    "e"
                } else if name.contains("Stream") {
                    "stream"
                } else if name.contains("Builder") {
                    "builder"
                } else if name.contains("Buffer") {
                    "buf"
                } else {
                    "obj"
                }
            }
            ArgType::Array(elem) => {
                match elem.as_ref() {
                    ArgType::Byte => "bArr",
                    ArgType::Char => "cArr",
                    ArgType::Int => "iArr",
                    ArgType::Long => "jArr",
                    ArgType::Float => "fArr",
                    ArgType::Double => "dArr",
                    ArgType::Object(name) if name.contains("String") => "strArr",
                    _ => "arr",
                }
            }
            ArgType::Void => "v",
            _ => "var",
        }
    }

    /// Generate a name for a variable based on its type
    pub fn name_for_type(&mut self, ty: &ArgType) -> String {
        let base = Self::base_name_for_type(ty);
        self.make_unique(base)
    }

    /// Mark a name as used (for parameters, etc.)
    pub fn mark_used(&mut self, name: &str) {
        self.used_names.insert(name.to_string());
    }
}

/// Assign names to all variables in an SSA result
pub fn assign_var_names(
    ssa: &SsaResult,
    type_info: &TypeInferenceResult,
    first_param_reg: u16,
    num_params: u16,
) -> VarNamingResult {
    let mut naming = VarNaming::new(first_param_reg);
    let mut names = HashMap::new();

    // Reserve parameter names (they're already set up)
    for i in 0..num_params {
        let name = format!("p{}", i);
        naming.mark_used(&name);
    }

    // Collect all (reg, version) pairs that need names
    let mut vars_to_name: Vec<(u16, u32)> = Vec::new();

    for block in &ssa.blocks {
        // Add phi node destinations
        for phi in &block.phi_nodes {
            if phi.dest.reg_num < first_param_reg {
                vars_to_name.push((phi.dest.reg_num, phi.dest.ssa_version));
            }
        }

        // Add instruction destinations
        for insn in &block.instructions {
            if let Some(dest) = get_insn_dest(&insn.insn_type) {
                if dest.0 < first_param_reg {
                    vars_to_name.push(dest);
                }
            }
        }
    }

    // Sort and deduplicate
    vars_to_name.sort();
    vars_to_name.dedup();

    // Assign names
    for (reg, version) in vars_to_name {
        // Look up type
        let ty = type_info.types.get(&(reg, version));

        let name = if let Some(arg_type) = ty {
            naming.name_for_type(arg_type)
        } else {
            // Fallback: use vN naming
            naming.make_unique(&format!("v{}", reg))
        };

        names.insert((reg, version), name);
    }

    VarNamingResult { names }
}

/// Get the destination register from an instruction type
fn get_insn_dest(insn: &jadx_ir::instructions::InsnType) -> Option<(u16, u32)> {
    use jadx_ir::instructions::InsnType;

    match insn {
        InsnType::Const { dest, .. }
        | InsnType::ConstString { dest, .. }
        | InsnType::ConstClass { dest, .. }
        | InsnType::Move { dest, .. }
        | InsnType::MoveResult { dest }
        | InsnType::MoveException { dest }
        | InsnType::NewInstance { dest, .. }
        | InsnType::NewArray { dest, .. }
        | InsnType::ArrayLength { dest, .. }
        | InsnType::ArrayGet { dest, .. }
        | InsnType::InstanceOf { dest, .. }
        | InsnType::InstanceGet { dest, .. }
        | InsnType::StaticGet { dest, .. }
        | InsnType::Unary { dest, .. }
        | InsnType::Binary { dest, .. }
        | InsnType::Cast { dest, .. }
        | InsnType::Compare { dest, .. }
        | InsnType::Phi { dest, .. } => Some((dest.reg_num, dest.ssa_version)),

        InsnType::FilledNewArray { dest, .. } => {
            dest.as_ref().map(|d| (d.reg_num, d.ssa_version))
        }

        _ => None,
    }
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn test_unique_names() {
        let mut naming = VarNaming::new(10);

        let name1 = naming.name_for_type(&ArgType::Int);
        let name2 = naming.name_for_type(&ArgType::Int);
        let name3 = naming.name_for_type(&ArgType::Int);

        assert_eq!(name1, "i");
        assert_eq!(name2, "i2");
        assert_eq!(name3, "i3");
    }

    #[test]
    fn test_type_names() {
        let mut naming = VarNaming::new(10);

        assert_eq!(naming.name_for_type(&ArgType::Boolean), "z");
        assert_eq!(naming.name_for_type(&ArgType::Long), "j");
        assert_eq!(
            naming.name_for_type(&ArgType::Object("java/lang/String".to_string())),
            "str"
        );
        assert_eq!(
            naming.name_for_type(&ArgType::Array(Box::new(ArgType::Int))),
            "iArr"
        );
    }

    #[test]
    fn test_mark_used() {
        let mut naming = VarNaming::new(10);
        naming.mark_used("i");

        // "i" is taken, so we should get "i2"
        let name = naming.name_for_type(&ArgType::Int);
        assert_eq!(name, "i2");
    }
}
