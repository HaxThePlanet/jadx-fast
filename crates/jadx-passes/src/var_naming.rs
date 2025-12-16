//! Variable naming pass
//!
//! This pass assigns meaningful names to variables based on:
//! - Type information (e.g., "s" for String, "i" for int loop counters)
//! - Context (e.g., loop counters, array indices)
//! - SSA versioning (e.g., x1, x2 for different definitions)
//!
//! Based on JADX's variable naming strategy for 1:1 output compatibility.

use std::collections::{HashMap, HashSet, VecDeque};

use jadx_ir::info::DebugInfo;
use jadx_ir::types::ArgType;

use crate::ssa::SsaResult;
use crate::type_inference::TypeInferenceResult;

/// Check if a name is a valid Java identifier and printable
/// (like JADX's NameMapper.isValidAndPrintable)
fn is_valid_identifier(name: &str) -> bool {
    if name.is_empty() {
        return false;
    }

    // Check reserved words
    const RESERVED: &[&str] = &[
        "abstract", "assert", "boolean", "break", "byte", "case", "catch",
        "char", "class", "const", "continue", "default", "do", "double",
        "else", "enum", "extends", "false", "final", "finally", "float",
        "for", "goto", "if", "implements", "import", "instanceof", "int",
        "interface", "long", "native", "new", "null", "package", "private",
        "protected", "public", "return", "short", "static", "strictfp",
        "super", "switch", "synchronized", "this", "throw", "throws",
        "transient", "true", "try", "void", "volatile", "while", "_",
    ];

    if RESERVED.contains(&name) {
        return false;
    }

    // Check valid Java identifier
    let mut chars = name.chars();
    if let Some(first) = chars.next() {
        if !first.is_alphabetic() && first != '_' && first != '$' {
            return false;
        }
    }

    for c in chars {
        if !c.is_alphanumeric() && c != '_' && c != '$' {
            return false;
        }
    }

    // Check printable (ASCII 32-126)
    name.chars().all(|c| (32..=126).contains(&(c as u32)))
}

/// Get variable name from debug info by register and instruction offset
/// (like JADX's DebugInfoApplyVisitor)
fn get_debug_name(debug_info: Option<&DebugInfo>, reg: u16, insn_offset: u32) -> Option<String> {
    let debug = debug_info?;

    for local_var in &debug.local_vars {
        if local_var.reg == reg
           && local_var.start_addr <= insn_offset
           && insn_offset <= local_var.end_addr
        {
            // Validate name (like JADX's NameMapper.isValidAndPrintable)
            if is_valid_identifier(&local_var.name) {
                return Some(local_var.name.clone());
            }
        }
    }
    None
}

/// Build CodeVar groups from SSA result by following PHI node connections.
/// This mirrors JADX's InitCodeVariables.collectConnectedVars() - all SSA variables
/// connected through PHI nodes should share the same name.
///
/// Returns a map: (reg, version) -> code_var_index
/// Variables with the same index should get the same name.
fn build_code_vars(ssa: &SsaResult) -> HashMap<(u16, u32), usize> {
    let mut ssa_to_code_var: HashMap<(u16, u32), usize> = HashMap::new();
    let mut next_code_var_idx = 0usize;

    // Build adjacency list from PHI nodes
    // For each PHI: dest is connected to all sources
    let mut phi_connections: HashMap<(u16, u32), HashSet<(u16, u32)>> = HashMap::new();

    for block in &ssa.blocks {
        for phi in &block.phi_nodes {
            let dest = (phi.dest.reg_num, phi.dest.ssa_version);

            for (_, source) in &phi.sources {
                let src = (source.reg_num, source.ssa_version);

                // Bidirectional connection (like JADX's collectConnectedVars)
                phi_connections.entry(dest).or_default().insert(src);
                phi_connections.entry(src).or_default().insert(dest);
            }
        }
    }

    // BFS to find connected components - each component becomes one CodeVar
    let mut visited: HashSet<(u16, u32)> = HashSet::new();

    for block in &ssa.blocks {
        for phi in &block.phi_nodes {
            let start = (phi.dest.reg_num, phi.dest.ssa_version);
            if visited.contains(&start) {
                continue;
            }

            // BFS to find all connected SSA vars
            let mut connected: Vec<(u16, u32)> = Vec::new();
            let mut queue: VecDeque<(u16, u32)> = VecDeque::new();
            queue.push_back(start);

            while let Some(current) = queue.pop_front() {
                if visited.contains(&current) {
                    continue;
                }
                visited.insert(current);
                connected.push(current);

                if let Some(neighbors) = phi_connections.get(&current) {
                    for neighbor in neighbors {
                        if !visited.contains(neighbor) {
                            queue.push_back(*neighbor);
                        }
                    }
                }
            }

            // Assign all connected vars to the same CodeVar index
            let code_var_idx = next_code_var_idx;
            next_code_var_idx += 1;

            for ssa_var in connected {
                ssa_to_code_var.insert(ssa_var, code_var_idx);
            }
        }
    }

    ssa_to_code_var
}

/// Result of variable naming pass
#[derive(Debug, Clone)]
pub struct VarNamingResult {
    /// Variable names: (reg, ssa_version) -> name
    pub names: HashMap<(u16, u32), String>,
}

/// Method info for variable naming
pub struct MethodNameInfo {
    pub method_name: String,
    pub class_name: String,
}

/// Variable naming context
pub struct VarNaming<'a> {
    /// Used names at each scope level
    used_names: HashSet<String>,
    /// Counter for each base name (to generate unique suffixes)
    name_counters: HashMap<String, u32>,
    /// Parameter register start (parameters already have names)
    first_param_reg: u16,
    /// Method lookup: method_idx -> (method_name, class_name)
    method_lookup: Option<&'a dyn Fn(u32) -> Option<MethodNameInfo>>,
    /// Type lookup: type_idx -> type_name (internal format like "java/lang/StringBuilder")
    type_lookup: Option<&'a dyn Fn(u32) -> Option<String>>,
}

impl<'a> VarNaming<'a> {
    /// Create a new variable naming context
    pub fn new(first_param_reg: u16) -> Self {
        VarNaming {
            used_names: HashSet::new(),
            name_counters: HashMap::new(),
            first_param_reg,
            method_lookup: None,
            type_lookup: None,
        }
    }

    /// Create a new variable naming context with lookups
    pub fn with_lookups(
        first_param_reg: u16,
        method_lookup: Option<&'a dyn Fn(u32) -> Option<MethodNameInfo>>,
        type_lookup: Option<&'a dyn Fn(u32) -> Option<String>>,
    ) -> Self {
        VarNaming {
            used_names: HashSet::new(),
            name_counters: HashMap::new(),
            first_param_reg,
            method_lookup,
            type_lookup,
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

            // Method invocation - extract name from method name
            // e.g., getUser() -> "user", createBuilder() -> "builder"
            InsnType::Invoke { method_idx, .. } => {
                if let Some(lookup) = &self.method_lookup {
                    if let Some(info) = lookup(*method_idx) {
                        if let Some(base) = Self::extract_name_from_method(&info.method_name) {
                            return Some(self.make_unique(&base));
                        }
                    }
                }
                None
            }

            // NewInstance - use class name for variable name
            // e.g., new StringBuilder() -> "sb", new MyClass() -> "myClass"
            InsnType::NewInstance { type_idx, .. } => {
                if let Some(lookup) = &self.type_lookup {
                    if let Some(type_name) = lookup(*type_idx) {
                        let base = Self::extract_class_name_base(&type_name);
                        return Some(self.make_unique(base));
                    }
                }
                None
            }

            // For other instructions, return None to fall back to type-based naming
            _ => None,
        }
    }

    /// Extract a variable name from a method name by stripping common prefixes
    /// Following JADX's cutPrefix logic in NameGen.java
    fn extract_name_from_method(method_name: &str) -> Option<String> {
        // Skip constructors
        if method_name == "<init>" || method_name == "<clinit>" {
            return None;
        }

        // Try common prefixes in order (like JADX's INVOKE_PREFIXES)
        let prefixes = ["get", "set", "put", "is", "has", "can", "to", "create", "new", "make", "build"];

        for prefix in prefixes {
            if method_name.starts_with(prefix) && method_name.len() > prefix.len() {
                let rest = &method_name[prefix.len()..];
                // Check if the next character is uppercase (proper camelCase)
                if rest.chars().next().map(|c| c.is_ascii_uppercase()).unwrap_or(false) {
                    // Convert first char to lowercase
                    let mut chars = rest.chars();
                    if let Some(first) = chars.next() {
                        let rest_str: String = chars.collect();
                        let result = format!("{}{}", first.to_lowercase(), rest_str);
                        // Skip very short names
                        if result.len() >= 2 {
                            return Some(result);
                        }
                    }
                }
            }
        }

        None
    }
}

/// Assign names to all variables in an SSA result (without lookups)
pub fn assign_var_names(
    ssa: &SsaResult,
    type_info: &TypeInferenceResult,
    first_param_reg: u16,
    num_params: u16,
) -> VarNamingResult {
    assign_var_names_with_lookups(ssa, type_info, first_param_reg, num_params, None, None, None)
}

/// Assign names to all variables in an SSA result with optional method/type lookups
pub fn assign_var_names_with_lookups<'a>(
    ssa: &SsaResult,
    type_info: &TypeInferenceResult,
    first_param_reg: u16,
    num_params: u16,
    method_lookup: Option<&'a dyn Fn(u32) -> Option<MethodNameInfo>>,
    type_lookup: Option<&'a dyn Fn(u32) -> Option<String>>,
    debug_info: Option<&'a DebugInfo>,
) -> VarNamingResult {
    let mut naming = VarNaming::with_lookups(first_param_reg, method_lookup, type_lookup);

    // Estimate capacity based on SSA result size
    let estimated_vars = ssa.blocks.iter()
        .map(|b| b.instructions.len() + b.phi_nodes.len())
        .sum::<usize>();

    let mut names = HashMap::with_capacity(estimated_vars);

    // Reserve parameter names (they're already set up)
    for i in 0..num_params {
        let name = format!("p{}", i);
        naming.mark_used(&name);
    }

    // Build CodeVar groups from PHI nodes (like JADX's InitCodeVariables)
    // Variables connected through PHI nodes should share the same name
    let code_var_map = build_code_vars(ssa);
    let mut code_var_names: HashMap<usize, String> = HashMap::new();

    // Build assignment map: (reg, version) -> (block_idx, insn_idx, insn_offset)
    // (like JADX's SSAVar.getAssignInsn())
    // Also stores instruction offset for debug info lookup
    let mut assignment_map: HashMap<(u16, u32), (usize, usize, u32)> = HashMap::with_capacity(estimated_vars);
    for (block_idx, block) in ssa.blocks.iter().enumerate() {
        for (insn_idx, insn) in block.instructions.iter().enumerate() {
            if let Some((reg, version)) = get_insn_dest(&insn.insn_type) {
                assignment_map.insert((reg, version), (block_idx, insn_idx, insn.offset));
            }
        }
    }

    // Collect all (reg, version) pairs that need names
    let mut vars_to_name: Vec<(u16, u32)> = Vec::with_capacity(estimated_vars);

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
        // Check if this variable belongs to a CodeVar group that already has a name
        // (PHI-connected variables share the same name like JADX's CodeVar)
        if let Some(&code_var_idx) = code_var_map.get(&(reg, version)) {
            if let Some(existing_name) = code_var_names.get(&code_var_idx) {
                names.insert((reg, version), existing_name.clone());
                continue;
            }
        }

        // Get instruction offset for debug info lookup
        let insn_offset = assignment_map.get(&(reg, version)).map(|&(_, _, off)| off).unwrap_or(0);

        // Priority 1: Debug info name (like JADX's DebugInfoApplyVisitor)
        let debug_name = get_debug_name(debug_info, reg, insn_offset);

        // Priority 2: Context-based name from assignment instruction
        let context_name = if debug_name.is_none() {
            assignment_map.get(&(reg, version))
                .and_then(|&(block_idx, insn_idx, _)| {
                    let block = &ssa.blocks[block_idx];
                    let insn = &block.instructions[insn_idx];

                    // For MoveResult, look at the previous instruction (should be Invoke)
                    if matches!(insn.insn_type, jadx_ir::instructions::InsnType::MoveResult { .. }) {
                        if insn_idx > 0 {
                            let prev_insn = &block.instructions[insn_idx - 1];
                            // Try to get name from the preceding Invoke instruction
                            if let Some(name) = naming.name_from_instruction_context(prev_insn) {
                                return Some(name);
                            }
                        }
                    }

                    naming.name_from_instruction_context(insn)
                })
        } else {
            None
        };

        let name = if let Some(name) = debug_name {
            // Got name from debug info (highest priority)
            naming.make_unique(&name)
        } else if let Some(name) = context_name {
            // Got a name from instruction context (like makeNameFromInsn succeeded)
            name
        } else if let Some(arg_type) = type_info.types.get(&(reg, version)) {
            // Fall back to type-based naming (like JADX's makeNameForType)
            naming.name_for_type(arg_type)
        } else {
            // Last resort: use register-based naming (like JADX's NameGen.getFallbackName)
            naming.make_unique(&format!("r{}", reg))
        };

        // If this variable belongs to a CodeVar group, save the name for other members
        if let Some(&code_var_idx) = code_var_map.get(&(reg, version)) {
            code_var_names.insert(code_var_idx, name.clone());
        }

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

    #[test]
    fn test_extract_name_from_method() {
        // Test getter methods
        assert_eq!(VarNaming::extract_name_from_method("getUser"), Some("user".to_string()));
        assert_eq!(VarNaming::extract_name_from_method("getUserName"), Some("userName".to_string()));

        // Test setter methods
        assert_eq!(VarNaming::extract_name_from_method("setName"), Some("name".to_string()));

        // Test "is" prefix (boolean getters)
        assert_eq!(VarNaming::extract_name_from_method("isActive"), Some("active".to_string()));
        assert_eq!(VarNaming::extract_name_from_method("isEnabled"), Some("enabled".to_string()));

        // Test "has" prefix
        assert_eq!(VarNaming::extract_name_from_method("hasPermission"), Some("permission".to_string()));

        // Test "create" prefix
        assert_eq!(VarNaming::extract_name_from_method("createBuilder"), Some("builder".to_string()));

        // Test "to" prefix
        assert_eq!(VarNaming::extract_name_from_method("toString"), Some("string".to_string()));
        assert_eq!(VarNaming::extract_name_from_method("toArray"), Some("array".to_string()));

        // Test methods that shouldn't match
        assert_eq!(VarNaming::extract_name_from_method("getName"), Some("name".to_string()));

        // Test constructors (should not match)
        assert_eq!(VarNaming::extract_name_from_method("<init>"), None);
        assert_eq!(VarNaming::extract_name_from_method("<clinit>"), None);

        // Test methods without prefixes (should not match)
        assert_eq!(VarNaming::extract_name_from_method("calculate"), None);
        assert_eq!(VarNaming::extract_name_from_method("process"), None);

        // Test short names
        assert_eq!(VarNaming::extract_name_from_method("getId"), Some("id".to_string())); // "id" is 2 chars, valid
        assert_eq!(VarNaming::extract_name_from_method("getX"), None); // "x" too short (1 char)

        // Test non-camelCase (should not match)
        assert_eq!(VarNaming::extract_name_from_method("getuser"), None); // lowercase after prefix
    }
}
