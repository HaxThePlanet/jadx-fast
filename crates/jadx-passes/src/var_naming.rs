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
            ArgType::Long => "l",  // Fixed: was "j", should be "l" for JADX compatibility
            ArgType::Float => "f",
            ArgType::Double => "d",
            ArgType::Object(name) => {
                // OBJ_ALIAS mappings from JADX for 1:1 compatibility
                // IMPORTANT: More specific patterns must come before general ones
                // (e.g., StringBuilder before String, StringBuffer before Buffer)

                if name.contains("StringBuilder") || name.contains("StringBuffer") {
                    "sb"
                } else if name.contains("String") {
                    "str"
                } else if name.contains("Class") {
                    "cls"
                } else if name.contains("Throwable") {
                    "th"
                } else if name.contains("Exception") {
                    "th"  // JADX uses "th" for Throwable and Exception
                } else if name.contains("Integer") {
                    "num"
                } else if name.contains("Long") && !name.contains("LongSparseArray") {
                    "num"
                } else if name.contains("Double") && !name.contains("DoubleArray") {
                    "num"
                } else if name.contains("Float") && !name.contains("FloatArray") {
                    "num"
                } else if name.contains("Boolean") && !name.contains("BooleanArray") {
                    "bool"
                } else if name.contains("ArrayList") {
                    "list"
                } else if name.contains("List") {
                    "list"
                } else if name.contains("HashMap") {
                    "map"
                } else if name.contains("Map") {
                    "map"
                } else if name.contains("HashSet") {
                    "set"
                } else if name.contains("Set") {
                    "set"
                } else if name.contains("Iterator") {
                    "it"
                } else if name.contains("Stream") {
                    "stream"
                } else if name.contains("Builder") {
                    "builder"
                } else if name.contains("Buffer") {
                    "buf"
                } else if name.contains("Object") && name.ends_with("/Object") {
                    "obj"
                } else {
                    // Extract simple class name and use lowercase first char
                    return Self::extract_class_name_base(name);
                }
            }
            ArgType::Array(elem) => {
                match elem.as_ref() {
                    ArgType::Byte => "bArr",
                    ArgType::Char => "cArr",
                    ArgType::Int => "iArr",
                    ArgType::Long => "lArr",  // Fixed: was "jArr", should be "lArr"
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

    /// Extract simple class name and generate base variable name
    /// Examples:
    /// - "android/view/View" → "view"
    /// - "com/example/Outer$Inner" → "inner"
    /// - "java/io/IOException" → "ioException"
    /// - "ABC" (all uppercase) → "abc"
    /// - "AB" (short) → "abVar"
    fn extract_class_name_base(full_name: &str) -> &'static str {
        // Leak the string to get 'static lifetime - variable names are small and cached
        // This is acceptable because we only generate a limited set of base names

        // Extract simple name (after last '/', '$', or '.')
        // Note: Types may be in internal format (/) or Java format (.), and inner classes may use $ or .
        let simple_name = full_name
            .rsplit('/')
            .next()
            .unwrap_or(full_name)
            .rsplit('$')
            .next()
            .unwrap_or(full_name)
            .rsplit('.')
            .next()
            .unwrap_or(full_name);

        // If empty or non-ASCII, fallback to "obj"
        if simple_name.is_empty() || !simple_name.is_ascii() {
            return "obj";
        }

        // Check if all uppercase
        let is_all_uppercase = simple_name.chars().all(|c| !c.is_ascii_lowercase());

        // Generate base name
        let base = if is_all_uppercase {
            // Convert all-uppercase to lowercase
            let lower = simple_name.to_lowercase();
            if lower.len() < 3 {
                // Short names get "Var" suffix
                Box::leak(format!("{}Var", lower).into_boxed_str())
            } else {
                Box::leak(lower.into_boxed_str())
            }
        } else {
            // Lowercase first character
            let mut chars = simple_name.chars();
            if let Some(first) = chars.next() {
                let rest: String = chars.collect();
                let base = format!("{}{}", first.to_lowercase(), rest);

                if base.len() < 3 {
                    // Short names get "Var" suffix
                    Box::leak(format!("{}Var", base).into_boxed_str())
                } else {
                    Box::leak(base.into_boxed_str())
                }
            } else {
                "obj"
            }
        };

        base
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

    /// Try to generate a name from instruction context (like JADX's makeNameFromInsn)
    /// Returns None if no suitable context-based name can be generated
    ///
    /// Note: This currently handles cases that don't require DexInfo lookup.
    /// TODO: Add method invocation and constructor handling when DexInfo is available
    fn name_from_instruction_context(
        &mut self,
        insn: &jadx_ir::instructions::InsnNode,
    ) -> Option<String> {
        use jadx_ir::instructions::InsnType;

        match &insn.insn_type {
            // Array length (like JADX's ARRAY_LENGTH case)
            InsnType::ArrayLength { .. } => {
                Some(self.make_unique("length"))
            }

            // String constant - use "str"
            InsnType::ConstString { .. } => {
                Some(self.make_unique("str"))
            }

            // TODO: Add these when DexInfo is wired through:
            // - Invoke: cut prefixes from method names (getUser -> user)
            // - NewInstance: use class name (new Builder() -> builder)

            // For other instructions, return None to fall back to type-based naming
            _ => None,
        }
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

    // Build assignment map: (reg, version) -> instruction that assigns to it
    // (like JADX's SSAVar.getAssignInsn())
    let mut assignment_map: HashMap<(u16, u32), &jadx_ir::instructions::InsnNode> = HashMap::new();
    for block in &ssa.blocks {
        for insn in &block.instructions {
            if let Some((reg, version)) = get_insn_dest(&insn.insn_type) {
                assignment_map.insert((reg, version), insn);
            }
        }
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

    // Assign names (following JADX's guessName and makeNameForSSAVar logic)
    for (reg, version) in vars_to_name {
        // Try to get name from assignment instruction (like JADX's makeNameForSSAVar)
        let context_name = assignment_map.get(&(reg, version))
            .and_then(|assign_insn| naming.name_from_instruction_context(assign_insn));

        let name = if let Some(name) = context_name {
            // Got a name from instruction context (like makeNameFromInsn succeeded)
            name
        } else if let Some(arg_type) = type_info.types.get(&(reg, version)) {
            // Fall back to type-based naming (like JADX's makeNameForType)
            naming.name_for_type(arg_type)
        } else {
            // Last resort: use vN naming
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
        assert_eq!(naming.name_for_type(&ArgType::Long), "l"); // Fixed: was "j", now "l"
        assert_eq!(
            naming.name_for_type(&ArgType::Object("java/lang/String".to_string())),
            "str"
        );
        assert_eq!(
            naming.name_for_type(&ArgType::Array(Box::new(ArgType::Int))),
            "iArr"
        );
        assert_eq!(
            naming.name_for_type(&ArgType::Array(Box::new(ArgType::Long))),
            "lArr" // Fixed: was "jArr", now "lArr"
        );
    }

    #[test]
    fn test_obj_alias_mappings() {
        // Test base name mappings (each gets a fresh naming context)
        assert_eq!(
            VarNaming::base_name_for_type(&ArgType::Object("java/lang/Class".to_string())),
            "cls"
        );
        assert_eq!(
            VarNaming::base_name_for_type(&ArgType::Object("java/lang/Throwable".to_string())),
            "th"
        );
        assert_eq!(
            VarNaming::base_name_for_type(&ArgType::Object("java/lang/Exception".to_string())),
            "th"
        );
        assert_eq!(
            VarNaming::base_name_for_type(&ArgType::Object("java/lang/Integer".to_string())),
            "num"
        );
        assert_eq!(
            VarNaming::base_name_for_type(&ArgType::Object("java/lang/Long".to_string())),
            "num"
        );
        assert_eq!(
            VarNaming::base_name_for_type(&ArgType::Object("java/lang/Double".to_string())),
            "num"
        );
        assert_eq!(
            VarNaming::base_name_for_type(&ArgType::Object("java/lang/Boolean".to_string())),
            "bool"
        );
        assert_eq!(
            VarNaming::base_name_for_type(&ArgType::Object("java/lang/StringBuilder".to_string())),
            "sb"
        );
        assert_eq!(
            VarNaming::base_name_for_type(&ArgType::Object("java/lang/StringBuffer".to_string())),
            "sb"
        );
    }

    #[test]
    fn test_obj_alias_uniqueness() {
        let mut naming = VarNaming::new(10);

        // When multiple variables have the same base type, they get numeric suffixes
        let th1 = naming.name_for_type(&ArgType::Object("java/lang/Throwable".to_string()));
        let th2 = naming.name_for_type(&ArgType::Object("java/lang/Exception".to_string()));
        let num1 = naming.name_for_type(&ArgType::Object("java/lang/Integer".to_string()));
        let num2 = naming.name_for_type(&ArgType::Object("java/lang/Long".to_string()));

        assert_eq!(th1, "th");
        assert_eq!(th2, "th2"); // Second throwable-type gets suffix
        assert_eq!(num1, "num");
        assert_eq!(num2, "num2"); // Second numeric-type gets suffix
    }

    #[test]
    fn test_class_name_extraction() {
        // Test base name extraction for various class names
        assert_eq!(
            VarNaming::base_name_for_type(&ArgType::Object("android/view/View".to_string())),
            "view"
        );
        assert_eq!(
            VarNaming::base_name_for_type(&ArgType::Object("android/app/Activity".to_string())),
            "activity"
        );

        // Inner classes
        assert_eq!(
            VarNaming::base_name_for_type(&ArgType::Object("com/example/Outer$Inner".to_string())),
            "inner"
        );

        // All-uppercase names
        assert_eq!(
            VarNaming::base_name_for_type(&ArgType::Object("com/example/ABC".to_string())),
            "abc"
        );

        // Short names get "Var" suffix
        assert_eq!(
            VarNaming::base_name_for_type(&ArgType::Object("com/example/AB".to_string())),
            "abVar"
        );

        // Complex inner class paths
        assert_eq!(
            VarNaming::base_name_for_type(&ArgType::Object("com/example/Outer$Middle$Inner".to_string())),
            "inner"
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
