//! Variable naming pass
//!
//! This pass assigns meaningful names to variables based on:
//! - Type information (e.g., "s" for String, "i" for int loop counters)
//! - Context (e.g., loop counters, array indices)
//! - SSA versioning (e.g., x1, x2 for different definitions)
//!
//! Based on JADX's variable naming strategy for 1:1 output compatibility.

use std::collections::{HashMap, HashSet, VecDeque};

use dexterity_ir::info::DebugInfo;
use dexterity_ir::types::ArgType;

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

/// Field info for variable naming (simplified from codegen's FieldInfo)
pub struct FieldNameInfo {
    pub field_name: String,
    pub class_name: String,
}

/// Variable naming context
pub struct VarNaming<'a> {
    /// Used names at each scope level
    used_names: HashSet<String>,
    /// Counter for each base name (to generate unique suffixes)
    name_counters: HashMap<String, u32>,
    /// Parameter register start (parameters already have names)
    #[allow(dead_code)]
    first_param_reg: u16,
    /// Method lookup: method_idx -> (method_name, class_name)
    method_lookup: Option<&'a dyn Fn(u32) -> Option<MethodNameInfo>>,
    /// Type lookup: type_idx -> type_name (internal format like "java/lang/StringBuilder")
    type_lookup: Option<&'a dyn Fn(u32) -> Option<String>>,
    /// Field lookup: field_idx -> (field_name, class_name)
    field_lookup: Option<&'a dyn Fn(u32) -> Option<FieldNameInfo>>,
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
            field_lookup: None,
        }
    }

    /// Create a new variable naming context with lookups
    pub fn with_lookups(
        first_param_reg: u16,
        method_lookup: Option<&'a dyn Fn(u32) -> Option<MethodNameInfo>>,
        type_lookup: Option<&'a dyn Fn(u32) -> Option<String>>,
        field_lookup: Option<&'a dyn Fn(u32) -> Option<FieldNameInfo>>,
    ) -> Self {
        VarNaming {
            used_names: HashSet::new(),
            name_counters: HashMap::new(),
            first_param_reg,
            method_lookup,
            type_lookup,
            field_lookup,
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
                // Extended with additional common Java types

                // String types (most common, check first)
                if name.contains("StringBuilder") || name.contains("StringBuffer") {
                    "sb"
                } else if name.contains("String") {
                    "str"
                }
                // Throwable types
                else if name.contains("Throwable") || name.contains("Error") {
                    "th"
                } else if name.contains("Exception") {
                    "exc"  // More specific than "th"
                }
                // Numeric wrapper types
                else if name.contains("Integer") {
                    "num"
                } else if name.contains("Long") && !name.contains("LongSparseArray") {
                    "num"
                } else if name.contains("Double") && !name.contains("DoubleArray") {
                    "num"
                } else if name.contains("Float") && !name.contains("FloatArray") {
                    "num"
                } else if name.contains("Number") {
                    "num"
                } else if name.contains("BigDecimal") || name.contains("BigInteger") {
                    "num"
                } else if name.contains("Boolean") && !name.contains("BooleanArray") {
                    "bool"
                }
                // Collection types
                else if name.contains("ArrayList") || name.contains("LinkedList") {
                    "list"
                } else if name.contains("List") {
                    "list"
                } else if name.contains("HashMap") || name.contains("LinkedHashMap") || name.contains("TreeMap") {
                    "map"
                } else if name.contains("Map") {
                    "map"
                } else if name.contains("HashSet") || name.contains("LinkedHashSet") || name.contains("TreeSet") {
                    "set"
                } else if name.contains("Set") {
                    "set"
                } else if name.contains("Queue") || name.contains("Deque") {
                    "queue"
                } else if name.contains("Stack") {
                    "stack"
                } else if name.contains("Collection") {
                    "collection"
                }
                // Iterator/Enumeration
                else if name.contains("Iterator") {
                    "it"
                } else if name.contains("Enumeration") {
                    "enumeration"
                }
                // Stream types
                else if name.contains("InputStream") {
                    "inputStream"
                } else if name.contains("OutputStream") {
                    "outputStream"
                } else if name.contains("Stream") {
                    "stream"
                }
                // Reader/Writer
                else if name.contains("Reader") {
                    "reader"
                } else if name.contains("Writer") {
                    "writer"
                }
                // Reflection types
                else if name.contains("Class") {
                    "cls"
                } else if name.contains("Method") {
                    "method"
                } else if name.contains("Field") {
                    "field"
                } else if name.contains("Constructor") {
                    "constructor"
                }
                // Pattern/Matcher
                else if name.contains("Pattern") {
                    "pattern"
                } else if name.contains("Matcher") {
                    "matcher"
                }
                // Date/Time
                else if name.contains("Date") {
                    "date"
                } else if name.contains("Calendar") {
                    "calendar"
                } else if name.contains("Time") {
                    "time"
                }
                // Builder/Factory patterns
                else if name.contains("Builder") {
                    "builder"
                } else if name.contains("Factory") {
                    "factory"
                }
                // Buffer types
                else if name.contains("ByteBuffer") {
                    "byteBuffer"
                } else if name.contains("Buffer") {
                    "buf"
                }
                // Context types (Android)
                else if name.contains("Context") {
                    "context"
                } else if name.contains("Activity") {
                    "activity"
                } else if name.contains("Service") {
                    "service"
                } else if name.contains("Intent") {
                    "intent"
                } else if name.contains("Bundle") {
                    "bundle"
                } else if name.contains("View") {
                    "view"
                } else if name.contains("Handler") {
                    "handler"
                } else if name.contains("Runnable") {
                    "runnable"
                } else if name.contains("Callable") {
                    "callable"
                } else if name.contains("Future") {
                    "future"
                } else if name.contains("Promise") {
                    "promise"
                } else if name.contains("Task") {
                    "task"
                }
                // Network types
                else if name.contains("Socket") {
                    "socket"
                } else if name.contains("Connection") {
                    "connection"
                } else if name.contains("Request") {
                    "request"
                } else if name.contains("Response") {
                    "response"
                } else if name.contains("Client") {
                    "client"
                }
                // Generic Object
                else if name.contains("Object") && name.ends_with("/Object") {
                    "obj"
                } else {
                    // Extract simple class name and use lowercase first char
                    return Self::extract_class_name_base(name);
                }
            }
            ArgType::Array(elem) => {
                match elem.as_ref() {
                    ArgType::Boolean => "zArr",
                    ArgType::Byte => "bArr",
                    ArgType::Char => "cArr",
                    ArgType::Short => "sArr",
                    ArgType::Int => "iArr",
                    ArgType::Long => "lArr",  // Fixed: was "jArr", should be "lArr"
                    ArgType::Float => "fArr",
                    ArgType::Double => "dArr",
                    ArgType::Object(name) if name.contains("String") => "strArr",
                    ArgType::Object(_) => "objArr",
                    _ => "arr",
                }
            }
            ArgType::Void => "v",
            ArgType::Unknown => "obj",  // Use "obj" for unknown types, not "var"
            _ => "obj",
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

        // Check if name is all digits (anonymous inner class like $1, $2)
        // This catches cases like "MainActivity$1" → "1" which would produce invalid "1Var"
        if simple_name.chars().all(|c| c.is_ascii_digit()) {
            return "anon";
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

        // Final validation - ensure identifier is valid (catches edge cases)
        if !is_valid_identifier(base) {
            return "obj";
        }

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
        insn: &dexterity_ir::instructions::InsnNode,
    ) -> Option<String> {
        use dexterity_ir::instructions::{InsnType, CastType};

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

            // Instance field get - use field name for variable name (JADX's IGET case)
            // e.g., obj.buffer -> "buffer", this.name -> "name"
            InsnType::InstanceGet { field_idx, .. } => {
                if let Some(lookup) = &self.field_lookup {
                    if let Some(info) = lookup(*field_idx) {
                        // Use field name as variable name base
                        let base = Self::sanitize_field_name(&info.field_name);
                        if !base.is_empty() && base.len() >= 2 {
                            return Some(self.make_unique(&base));
                        }
                    }
                }
                None
            }

            // Static field get - use field name for variable name (JADX's SGET case)
            // e.g., Config.DEBUG -> "debug", System.out -> "out"
            InsnType::StaticGet { field_idx, .. } => {
                if let Some(lookup) = &self.field_lookup {
                    if let Some(info) = lookup(*field_idx) {
                        let base = Self::sanitize_field_name(&info.field_name);
                        if !base.is_empty() && base.len() >= 2 {
                            return Some(self.make_unique(&base));
                        }
                    }
                }
                None
            }

            // CheckCast - use target type for variable name (JADX's CHECK_CAST case)
            // e.g., (String)obj -> "str", (MyClass)obj -> "myClass"
            InsnType::CheckCast { type_idx, .. } => {
                if let Some(lookup) = &self.type_lookup {
                    if let Some(type_name) = lookup(*type_idx) {
                        let base = Self::extract_class_name_base(&type_name);
                        return Some(self.make_unique(base));
                    }
                }
                None
            }

            // Primitive Cast - use target type for variable name
            // e.g., (long)i -> "l", (int)l -> "i"
            InsnType::Cast { cast_type, .. } => {
                let base = match cast_type {
                    CastType::IntToLong | CastType::FloatToLong | CastType::DoubleToLong => "l",
                    CastType::IntToFloat | CastType::LongToFloat | CastType::DoubleToFloat => "f",
                    CastType::IntToDouble | CastType::LongToDouble | CastType::FloatToDouble => "d",
                    CastType::LongToInt | CastType::FloatToInt | CastType::DoubleToInt => "i",
                    CastType::IntToByte => "b",
                    CastType::IntToChar => "c",
                    CastType::IntToShort => "s",
                };
                Some(self.make_unique(base))
            }

            // NewArray - use "arr" or element type-based name
            InsnType::NewArray { type_idx, .. } => {
                if let Some(lookup) = &self.type_lookup {
                    if let Some(type_name) = lookup(*type_idx) {
                        // Try to get element type from array type name
                        if let Some(base) = Self::array_var_name_from_type(&type_name) {
                            return Some(self.make_unique(base));
                        }
                    }
                }
                Some(self.make_unique("arr"))
            }

            // FilledNewArray - similar to NewArray
            InsnType::FilledNewArray { type_idx, .. } => {
                if let Some(lookup) = &self.type_lookup {
                    if let Some(type_name) = lookup(*type_idx) {
                        if let Some(base) = Self::array_var_name_from_type(&type_name) {
                            return Some(self.make_unique(base));
                        }
                    }
                }
                Some(self.make_unique("arr"))
            }

            // InstanceOf - use boolean-like name
            InsnType::InstanceOf { .. } => {
                Some(self.make_unique("z"))
            }

            // Compare - result is int used for comparison
            InsnType::Compare { .. } => {
                Some(self.make_unique("cmp"))
            }

            // For other instructions, return None to fall back to type-based naming
            _ => None,
        }
    }

    /// Sanitize field name for use as variable name
    /// Handles common field naming patterns and obfuscated names
    fn sanitize_field_name(field_name: &str) -> String {
        // Skip very short names (likely obfuscated like "a", "b")
        if field_name.len() < 2 {
            return String::new();
        }

        // Skip names that look obfuscated (single letter or letter+number)
        if field_name.len() <= 2 && field_name.chars().all(|c| c.is_alphanumeric()) {
            let first_char = field_name.chars().next().unwrap();
            if first_char.is_ascii_lowercase() {
                return String::new();
            }
        }

        // Convert to lowercase first char (Java convention for variables)
        let mut chars = field_name.chars();
        if let Some(first) = chars.next() {
            let rest: String = chars.collect();
            format!("{}{}", first.to_lowercase(), rest)
        } else {
            String::new()
        }
    }

    /// Get array variable name from array type
    /// e.g., "[B" -> "bArr", "[Ljava/lang/String;" -> "strArr"
    fn array_var_name_from_type(type_name: &str) -> Option<&'static str> {
        // Type name might be in descriptor format or Java format
        if type_name.starts_with('[') {
            // Descriptor format
            let elem = type_name.trim_start_matches('[');
            return match elem.chars().next()? {
                'B' => Some("bArr"),
                'C' => Some("cArr"),
                'I' => Some("iArr"),
                'J' => Some("lArr"),
                'F' => Some("fArr"),
                'D' => Some("dArr"),
                'Z' => Some("zArr"),
                'S' => Some("sArr"),
                'L' if elem.contains("String") => Some("strArr"),
                _ => Some("arr"),
            };
        }
        // Java format (String[], int[], etc.)
        if type_name.ends_with("[]") {
            let base = type_name.trim_end_matches("[]");
            return match base {
                "byte" => Some("bArr"),
                "char" => Some("cArr"),
                "int" => Some("iArr"),
                "long" => Some("lArr"),
                "float" => Some("fArr"),
                "double" => Some("dArr"),
                "boolean" => Some("zArr"),
                "short" => Some("sArr"),
                "String" => Some("strArr"),
                _ => Some("arr"),
            };
        }
        None
    }

    /// Extract a variable name from a method name by stripping common prefixes
    /// Following JADX's cutPrefix logic in NameGen.java
    fn extract_name_from_method(method_name: &str) -> Option<String> {
        // Skip constructors
        if method_name == "<init>" || method_name == "<clinit>" {
            return None;
        }

        // Comprehensive list of method prefixes (JADX-compatible + extended)
        // Higher priority prefixes first (get/set are most common and reliable)
        let prefixes = [
            // Primary getters/setters (JADX's INVOKE_PREFIXES)
            "get", "set", "put",
            // Boolean getters
            "is", "has", "can", "should", "will", "was", "are", "does",
            // Transformation methods
            "to", "as", "into", "from",
            // Factory methods
            "create", "new", "make", "build", "of", "parse",
            // Data access methods
            "read", "write", "load", "save", "fetch", "find", "lookup",
            // Processing methods
            "compute", "calculate", "process", "generate", "extract",
            // Collection methods
            "add", "remove", "contains", "obtain", "acquire",
        ];

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

        // For methods without matching prefix but with clear names, use method name directly
        // This catches methods like "execute()", "run()", "start()" etc.
        // Only use if the name is long enough and descriptive
        if method_name.len() >= 4 && !method_name.starts_with('$') && !method_name.starts_with("access$") {
            // Check it's a valid identifier start
            if method_name.chars().next().map(|c| c.is_ascii_lowercase()).unwrap_or(false) {
                // Don't use method names that start with known prefixes but didn't match above
                // (these are likely single-char results like getX -> x which is too short)
                let has_getter_prefix = method_name.starts_with("get") || method_name.starts_with("set")
                    || method_name.starts_with("is") || method_name.starts_with("has");
                if !has_getter_prefix {
                    // Use the method name as-is if it's descriptive enough
                    return Some(method_name.to_string());
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
    assign_var_names_with_lookups(ssa, type_info, first_param_reg, num_params, None, None, None, None)
}

/// Assign names to all variables in an SSA result with optional method/type/field lookups
pub fn assign_var_names_with_lookups<'a>(
    ssa: &SsaResult,
    type_info: &TypeInferenceResult,
    first_param_reg: u16,
    num_params: u16,
    method_lookup: Option<&'a dyn Fn(u32) -> Option<MethodNameInfo>>,
    type_lookup: Option<&'a dyn Fn(u32) -> Option<String>>,
    field_lookup: Option<&'a dyn Fn(u32) -> Option<FieldNameInfo>>,
    debug_info: Option<&'a DebugInfo>,
) -> VarNamingResult {
    let mut naming = VarNaming::with_lookups(first_param_reg, method_lookup, type_lookup, field_lookup);

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

    // Build reverse map: code_var_idx -> list of (reg, version)
    let mut code_var_members: HashMap<usize, Vec<(u16, u32)>> = HashMap::new();
    for &(reg, version) in &vars_to_name {
        if let Some(&code_var_idx) = code_var_map.get(&(reg, version)) {
            code_var_members.entry(code_var_idx).or_default().push((reg, version));
        }
    }

    // Helper closure to get potential name and its score for a variable
    let get_name_candidate = |reg: u16, version: u32, naming: &mut VarNaming| -> Option<(String, u32)> {
        let insn_offset = assignment_map.get(&(reg, version)).map(|&(_, _, off)| off).unwrap_or(0);

        // Priority 1: Debug info name (score 100)
        if let Some(debug_name) = get_debug_name(debug_info, reg, insn_offset) {
            return Some((debug_name, 100));
        }

        // Priority 2: Context-based name from assignment instruction (score 80)
        if let Some(&(block_idx, insn_idx, _)) = assignment_map.get(&(reg, version)) {
            let block = &ssa.blocks[block_idx];
            let insn = &block.instructions[insn_idx];

            // For MoveResult, look at the previous instruction
            if matches!(insn.insn_type, dexterity_ir::instructions::InsnType::MoveResult { .. }) {
                if insn_idx > 0 {
                    let prev_insn = &block.instructions[insn_idx - 1];
                    if let Some(name) = naming.name_from_instruction_context(prev_insn) {
                        // Score based on name quality
                        let score = score_name(&name);
                        return Some((name, score));
                    }
                }
            }

            if let Some(name) = naming.name_from_instruction_context(insn) {
                let score = score_name(&name);
                return Some((name, score));
            }
        }

        // Priority 3: Type-based name (score 40)
        if let Some(arg_type) = type_info.types.get(&(reg, version)) {
            let base = VarNaming::base_name_for_type(arg_type);
            return Some((base.to_string(), 40));
        }

        None
    };

    // For each CodeVar group, find the best name across all members
    for (&code_var_idx, members) in &code_var_members {
        let mut best_name: Option<String> = None;
        let mut best_score: u32 = 0;

        // Collect name candidates from all members
        for &(reg, version) in members {
            if let Some((name, score)) = get_name_candidate(reg, version, &mut naming) {
                if score > best_score {
                    best_score = score;
                    best_name = Some(name);
                }
            }
        }

        // Use the best name for the entire group
        if let Some(name) = best_name {
            let unique_name = naming.make_unique(&name);
            code_var_names.insert(code_var_idx, unique_name);
        }
    }

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
                    if matches!(insn.insn_type, dexterity_ir::instructions::InsnType::MoveResult { .. }) {
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
            // Last resort: use descriptive fallback name (like JADX's NameGen.getFallbackName)
            // Using "obj" for object-likely variables is more readable than "r{reg}"
            // This matches JADX's approach for unknown types
            naming.make_unique("obj")
        };

        // If this variable belongs to a CodeVar group, save the name for other members
        if let Some(&code_var_idx) = code_var_map.get(&(reg, version)) {
            code_var_names.insert(code_var_idx, name.clone());
        }

        names.insert((reg, version), name);
    }

    VarNamingResult { names }
}

/// Score a variable name based on quality
/// Higher scores = better names
fn score_name(name: &str) -> u32 {
    // Penalize register-like names (r0, v1, v123, etc.) - very low priority
    if name.len() >= 2
        && (name.starts_with('r') || name.starts_with('v'))
        && name[1..].chars().all(|c| c.is_ascii_digit())
    {
        return 5;
    }

    // Penalize very short names (likely cryptic)
    if name.len() <= 1 {
        return 10;
    }
    if name.len() == 2 {
        return 20;
    }

    // Penalize names ending with many digits (i23, str12, etc.)
    let trailing_digits: usize = name.chars().rev().take_while(|c| c.is_ascii_digit()).count();
    if trailing_digits >= 2 {
        return 30;
    }
    if trailing_digits == 1 {
        return 50;
    }

    // Prefer longer, more descriptive names
    let base_score: u32 = 60;
    let length_bonus: u32 = std::cmp::min(name.len() as u32, 20);

    // Prefer camelCase names (typical Java style)
    let camel_case_bonus: u32 = if name.chars().any(|c| c.is_uppercase()) { 5 } else { 0 };

    base_score + length_bonus + camel_case_bonus
}

/// Get the destination register from an instruction type
fn get_insn_dest(insn: &dexterity_ir::instructions::InsnType) -> Option<(u16, u32)> {
    use dexterity_ir::instructions::InsnType;

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
            "exc"
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
        let th2 = naming.name_for_type(&ArgType::Object("java/lang/Error".to_string()));
        let num1 = naming.name_for_type(&ArgType::Object("java/lang/Integer".to_string()));
        let num2 = naming.name_for_type(&ArgType::Object("java/lang/Long".to_string()));

        assert_eq!(th1, "th");
        assert_eq!(th2, "th2"); // Second throwable-type gets suffix
        assert_eq!(num1, "num");
        assert_eq!(num2, "num2"); // Second numeric-type gets suffix
    }

    #[test]
    fn test_android_type_aliases() {
        // Test Android-specific type mappings
        assert_eq!(
            VarNaming::base_name_for_type(&ArgType::Object("android/content/Context".to_string())),
            "context"
        );
        assert_eq!(
            VarNaming::base_name_for_type(&ArgType::Object("android/content/Intent".to_string())),
            "intent"
        );
        assert_eq!(
            VarNaming::base_name_for_type(&ArgType::Object("android/os/Bundle".to_string())),
            "bundle"
        );
        assert_eq!(
            VarNaming::base_name_for_type(&ArgType::Object("android/os/Handler".to_string())),
            "handler"
        );
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

        // Test new prefixes added: find, load, parse, read, compute
        assert_eq!(VarNaming::extract_name_from_method("findUser"), Some("user".to_string()));
        assert_eq!(VarNaming::extract_name_from_method("loadData"), Some("data".to_string()));
        assert_eq!(VarNaming::extract_name_from_method("parseJson"), Some("json".to_string()));
        assert_eq!(VarNaming::extract_name_from_method("readValue"), Some("value".to_string()));
        assert_eq!(VarNaming::extract_name_from_method("computeHash"), Some("hash".to_string()));

        // Test descriptive method names (4+ chars, lowercase start) - now captured
        assert_eq!(VarNaming::extract_name_from_method("execute"), Some("execute".to_string()));
        assert_eq!(VarNaming::extract_name_from_method("start"), Some("start".to_string()));
        assert_eq!(VarNaming::extract_name_from_method("stop"), Some("stop".to_string()));

        // But short methods should not match
        assert_eq!(VarNaming::extract_name_from_method("run"), None);
        assert_eq!(VarNaming::extract_name_from_method("foo"), None);

        // Test short names
        assert_eq!(VarNaming::extract_name_from_method("getId"), Some("id".to_string())); // "id" is 2 chars, valid
        assert_eq!(VarNaming::extract_name_from_method("getX"), None); // "x" too short (1 char)

        // Test non-camelCase (should not match)
        assert_eq!(VarNaming::extract_name_from_method("getuser"), None); // lowercase after prefix
    }

    #[test]
    fn test_sanitize_field_name() {
        // Normal field names should be preserved with lowercase first char
        assert_eq!(VarNaming::sanitize_field_name("buffer"), "buffer");
        assert_eq!(VarNaming::sanitize_field_name("Name"), "name");
        assert_eq!(VarNaming::sanitize_field_name("mBuffer"), "mBuffer");
        assert_eq!(VarNaming::sanitize_field_name("MAX_SIZE"), "mAX_SIZE");

        // Short/obfuscated names should return empty
        assert_eq!(VarNaming::sanitize_field_name("a"), "");
        assert_eq!(VarNaming::sanitize_field_name("b"), "");
        assert_eq!(VarNaming::sanitize_field_name("a1"), "");

        // Two-char names with uppercase OK
        assert_eq!(VarNaming::sanitize_field_name("ID"), "iD");
    }

    #[test]
    fn test_array_var_name_from_type() {
        // Descriptor format
        assert_eq!(VarNaming::array_var_name_from_type("[B"), Some("bArr"));
        assert_eq!(VarNaming::array_var_name_from_type("[I"), Some("iArr"));
        assert_eq!(VarNaming::array_var_name_from_type("[J"), Some("lArr"));
        assert_eq!(VarNaming::array_var_name_from_type("[Ljava/lang/String;"), Some("strArr"));
        assert_eq!(VarNaming::array_var_name_from_type("[Ljava/lang/Object;"), Some("arr"));

        // Java format
        assert_eq!(VarNaming::array_var_name_from_type("byte[]"), Some("bArr"));
        assert_eq!(VarNaming::array_var_name_from_type("int[]"), Some("iArr"));
        assert_eq!(VarNaming::array_var_name_from_type("String[]"), Some("strArr"));
        assert_eq!(VarNaming::array_var_name_from_type("Object[]"), Some("arr"));

        // Non-array types
        assert_eq!(VarNaming::array_var_name_from_type("int"), None);
        assert_eq!(VarNaming::array_var_name_from_type("java/lang/String"), None);
    }

    #[test]
    fn test_score_name() {
        // Very short names get low scores
        assert!(score_name("i") < score_name("index"));
        assert!(score_name("s") < score_name("str"));

        // Register-like names get very low scores
        assert!(score_name("r0") < score_name("buffer"));  // r0=5 < buffer=66
        assert!(score_name("v1") < score_name("value"));   // v1=5 < value=65

        // Names with trailing digits get penalized
        assert!(score_name("str2") < score_name("str"));   // single digit penalty
        assert!(score_name("str23") < score_name("str2")); // multi-digit penalty worse

        // Descriptive names get high scores
        assert!(score_name("buffer") > score_name("b"));
        assert!(score_name("userName") > score_name("user"));
        assert!(score_name("completableSourceArr") > score_name("arr"));

        // Verify register names are penalized
        assert_eq!(score_name("r0"), 5);
        assert_eq!(score_name("v123"), 5);
    }

    #[test]
    fn test_anonymous_class_names() {
        // Test that anonymous inner classes (numbers like $1, $2) generate "anon" not "1Var"
        // Use class names that don't match any predefined patterns
        let mut naming = VarNaming::new(10);

        // Single digit anonymous inner class - use a name that won't match common patterns
        let name1 = naming.name_for_type(&ArgType::Object("com/example/Foobar$1".to_string()));
        assert_eq!(name1, "anon", "Failed: {} doesn't match anon", name1);
        assert!(is_valid_identifier(&name1));

        // Verify multi-digit
        let name2 = naming.name_for_type(&ArgType::Object("com/example/Bazbar$123".to_string()));
        assert_eq!(name2, "anon2");
        assert!(is_valid_identifier(&name2));

        // Verify they don't start with digits
        assert!(!name1.chars().next().unwrap().is_ascii_digit());
        assert!(!name2.chars().next().unwrap().is_ascii_digit());
    }

    #[test]
    fn test_normal_numbered_classes_still_work() {
        // Ensure classes like "Foobar1" (not all-digits) still work normally
        let mut naming = VarNaming::new(10);

        // Foobar1 should NOT become "anon" since it has letters mixed with digits
        let name = naming.name_for_type(&ArgType::Object("com/example/Foobar1".to_string()));
        assert_eq!(name, "foobar1");
        assert!(is_valid_identifier(&name));
    }
}
