//! Dalvik to JVM bytecode utilities
//!
//! JADX Reference: jadx-plugins/jadx-rename-mappings/src/main/java/jadx/plugins/mappings/utils/DalvikToJavaBytecodeUtils.java
//! Cloned from JADX's DalvikToJavaBytecodeUtils class.
//!
//! This module provides utilities for converting Dalvik register-based information
//! to JVM stack-based local variable table (LVT) indices.
//!
//! Key concepts:
//! - Dalvik uses registers (v0, v1, v2, ...) for variables
//! - JVM uses a local variable table with indices
//! - Method arguments in Dalvik start at high registers (pN), but in JVM start at low indices
//! - Instance methods have 'this' at index 0, static methods start at 0

use dexterity_ir::{ArgType, MethodData};

/// Get the JVM local variable index for a method argument
///
/// JADX Reference: DalvikToJavaBytecodeUtils.getMethodArgLvIndex()
///
/// # Arguments
/// * `arg_index` - The index of the argument (0-based, excluding 'this')
/// * `is_static` - Whether the method is static
///
/// # Returns
/// The LV index for the argument in JVM bytecode
pub fn get_method_arg_lv_index(arg_index: usize, is_static: bool) -> usize {
    // For instance methods, 'this' is at index 0
    // For static methods, first arg is at index 0
    if is_static {
        arg_index
    } else {
        arg_index + 1
    }
}

/// Get the JVM local variable table index for a method argument
///
/// JADX Reference: DalvikToJavaBytecodeUtils.getMethodArgLvtIndex()
///
/// This is similar to LV index but accounts for the actual position
/// in the local variable table (which may include wide types taking 2 slots).
///
/// # Arguments
/// * `arg_index` - The index of the argument (0-based, excluding 'this')
/// * `method` - The method containing the argument
///
/// # Returns
/// The LVT index for the argument
pub fn get_method_arg_lvt_index(arg_index: usize, method: &MethodData) -> usize {
    let is_static = method.access_flags & 0x0008 != 0; // ACC_STATIC
    let mut lvt_index = if is_static { 0 } else { 1 };

    // Add slots for preceding arguments
    for i in 0..arg_index {
        if i < method.arg_types.len() {
            lvt_index += get_type_slot_count(&method.arg_types[i]);
        }
    }

    lvt_index
}

/// Get the JVM local variable index for a method local variable
///
/// JADX Reference: DalvikToJavaBytecodeUtils.getMethodVarLvIndex()
///
/// # Arguments
/// * `reg_num` - The Dalvik register number
/// * `method` - The method containing the variable
///
/// # Returns
/// The LV index for the variable in JVM bytecode
pub fn get_method_var_lv_index(reg_num: u16, method: &MethodData) -> usize {
    let is_static = method.access_flags & 0x0008 != 0;

    // Calculate last argument LV index
    let last_arg_lv_index = if method.arg_types.is_empty() {
        if is_static { 0 } else { 1 }
    } else {
        get_method_arg_lvt_index(method.arg_types.len() - 1, method) + 1
    };

    // Variable index is relative to last argument
    last_arg_lv_index + reg_num as usize
}

/// Get the number of slots a type takes in the local variable table
///
/// Long and double take 2 slots, everything else takes 1.
pub fn get_type_slot_count(arg_type: &ArgType) -> usize {
    match arg_type {
        ArgType::Long | ArgType::Double => 2,
        _ => 1,
    }
}

/// Convert a Dalvik register number to a local variable index
///
/// This is a simplified conversion that doesn't account for SSA versioning.
///
/// # Arguments
/// * `reg_num` - The Dalvik register number
/// * `method` - The method containing the register
///
/// # Returns
/// An approximate LV index (may not be exact without SSA info)
pub fn dalvik_reg_to_lv_index(reg_num: u16, method: &MethodData) -> usize {
    let is_static = method.access_flags & 0x0008 != 0;
    let this_offset = if is_static { 0 } else { 1 };

    // Calculate total slots for arguments
    let arg_slots: usize = method.arg_types.iter()
        .map(get_type_slot_count)
        .sum();

    // First registers are for locals, last registers are for arguments
    // In a method with N locals and M argument slots:
    // - v0 to v(N-1) are locals
    // - vN to v(N+M-1) are arguments

    // We need to know the total register count to do proper mapping
    // Without that info, we make a best-effort approximation
    this_offset + reg_num as usize
}

/// Information about a local variable's scope
#[derive(Debug, Clone)]
pub struct VarInfo {
    /// Register number
    pub reg_num: u16,
    /// SSA version
    pub ssa_version: u16,
    /// Variable name (if known)
    pub name: Option<String>,
    /// Start instruction index
    pub start_insn_idx: usize,
    /// End instruction index
    pub end_insn_idx: usize,
}

impl VarInfo {
    /// Create a new VarInfo
    pub fn new(reg_num: u16, ssa_version: u16) -> Self {
        Self {
            reg_num,
            ssa_version,
            name: None,
            start_insn_idx: 0,
            end_insn_idx: 0,
        }
    }

    /// Set the variable name
    pub fn with_name(mut self, name: String) -> Self {
        self.name = Some(name);
        self
    }

    /// Set the scope range
    pub fn with_range(mut self, start: usize, end: usize) -> Self {
        self.start_insn_idx = start;
        self.end_insn_idx = end;
        self
    }
}

/// Collect variable information from a method
///
/// JADX Reference: jadx-plugins/jadx-rename-mappings/src/main/java/jadx/plugins/mappings/utils/VariablesUtils.java
///
/// Note: Full implementation requires SSA variable tracking from dexterity-ir.
/// This provides a basic structure for when that becomes available.
pub fn collect_method_vars(method: &MethodData) -> Vec<VarInfo> {
    let mut vars = Vec::new();

    // Collect argument variables
    for (i, _arg_type) in method.arg_types.iter().enumerate() {
        let mut var = VarInfo::new(i as u16, 0);
        if i < method.arg_names.len() {
            if let Some(ref name) = method.arg_names[i] {
                var.name = Some(name.clone());
            }
        }
        vars.push(var);
    }

    // Local variables would be collected from SSA info when available
    // For now, we just return argument variables

    vars
}

#[cfg(test)]
mod tests {
    use super::*;

    fn create_test_method(is_static: bool) -> MethodData {
        let mut method = MethodData::new("test".to_string(), 0, ArgType::Void);
        if is_static {
            method.access_flags |= 0x0008;
        }
        method.arg_types = vec![ArgType::Int, ArgType::Long, ArgType::Object("Ljava/lang/String;".to_string())];
        method
    }

    #[test]
    fn test_get_method_arg_lv_index() {
        // Static method: args start at 0
        assert_eq!(get_method_arg_lv_index(0, true), 0);
        assert_eq!(get_method_arg_lv_index(1, true), 1);
        assert_eq!(get_method_arg_lv_index(2, true), 2);

        // Instance method: 'this' at 0, args start at 1
        assert_eq!(get_method_arg_lv_index(0, false), 1);
        assert_eq!(get_method_arg_lv_index(1, false), 2);
        assert_eq!(get_method_arg_lv_index(2, false), 3);
    }

    #[test]
    fn test_get_method_arg_lvt_index() {
        let method = create_test_method(false);

        // Instance method with (int, long, String):
        // this=0, int=1, long=2-3, String=4
        assert_eq!(get_method_arg_lvt_index(0, &method), 1); // int at slot 1
        assert_eq!(get_method_arg_lvt_index(1, &method), 2); // long at slot 2 (takes 2 slots)
        assert_eq!(get_method_arg_lvt_index(2, &method), 4); // String at slot 4
    }

    #[test]
    fn test_get_method_arg_lvt_index_static() {
        let method = create_test_method(true);

        // Static method with (int, long, String):
        // int=0, long=1-2, String=3
        assert_eq!(get_method_arg_lvt_index(0, &method), 0); // int at slot 0
        assert_eq!(get_method_arg_lvt_index(1, &method), 1); // long at slot 1 (takes 2 slots)
        assert_eq!(get_method_arg_lvt_index(2, &method), 3); // String at slot 3
    }

    #[test]
    fn test_get_type_slot_count() {
        assert_eq!(get_type_slot_count(&ArgType::Int), 1);
        assert_eq!(get_type_slot_count(&ArgType::Long), 2);
        assert_eq!(get_type_slot_count(&ArgType::Double), 2);
        assert_eq!(get_type_slot_count(&ArgType::Float), 1);
        assert_eq!(get_type_slot_count(&ArgType::Object("Ljava/lang/String;".to_string())), 1);
    }

    #[test]
    fn test_var_info() {
        let var = VarInfo::new(5, 2)
            .with_name("myVar".to_string())
            .with_range(10, 50);

        assert_eq!(var.reg_num, 5);
        assert_eq!(var.ssa_version, 2);
        assert_eq!(var.name, Some("myVar".to_string()));
        assert_eq!(var.start_insn_idx, 10);
        assert_eq!(var.end_insn_idx, 50);
    }

    #[test]
    fn test_collect_method_vars() {
        let mut method = create_test_method(false);
        method.arg_names = vec![
            Some("x".to_string()),
            Some("y".to_string()),
            None,
        ];

        let vars = collect_method_vars(&method);

        assert_eq!(vars.len(), 3);
        assert_eq!(vars[0].name, Some("x".to_string()));
        assert_eq!(vars[1].name, Some("y".to_string()));
        assert_eq!(vars[2].name, None);
    }
}
