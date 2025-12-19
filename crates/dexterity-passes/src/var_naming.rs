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

/// Sanitize a name to be a valid Java identifier
/// Converts invalid characters (like hyphens) to valid alternatives
/// Returns None if the name cannot be sanitized (e.g., empty or all invalid)
fn sanitize_identifier(name: &str) -> Option<String> {
    if name.is_empty() {
        return None;
    }

    // If already valid, return as-is
    if is_valid_identifier(name) {
        return Some(name.to_string());
    }

    let mut result = String::with_capacity(name.len());
    let mut chars = name.chars().peekable();
    let mut prev_was_hyphen = false;

    // Handle first character
    if let Some(first) = chars.next() {
        if first.is_alphabetic() || first == '_' || first == '$' {
            result.push(first);
        } else if first == '-' {
            // Skip leading hyphen, capitalize next char
            prev_was_hyphen = true;
        } else if first.is_ascii_digit() {
            // Prefix digit with underscore
            result.push('_');
            result.push(first);
        } else {
            // Skip other invalid start characters
            prev_was_hyphen = true;
        }
    }

    // Handle remaining characters
    for c in chars {
        if c == '-' {
            // Replace hyphen: capitalize next character (camelCase)
            prev_was_hyphen = true;
        } else if c.is_alphanumeric() || c == '_' || c == '$' {
            if prev_was_hyphen && c.is_alphabetic() {
                result.push(c.to_ascii_uppercase());
            } else {
                result.push(c);
            }
            prev_was_hyphen = false;
        }
        // Skip other invalid characters
    }

    // Check if result is valid
    if result.is_empty() {
        return None;
    }

    // Check reserved words - if sanitized name is reserved, prefix with underscore
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

    if RESERVED.contains(&result.as_str()) {
        result.insert(0, '_');
    }

    Some(result)
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
            // Sanitize name to ensure valid Java identifier
            // Handles Kotlin synthetic names with hyphens (e.g., "constructor-impl" -> "constructorImpl")
            return sanitize_identifier(&local_var.name);
        }
    }
    None
}

/// Check if two types are compatible for sharing the same variable name.
/// Types are compatible if they're the same, or one is a supertype/subtype of the other.
/// This is more lenient than Java assignment compatibility to avoid over-splitting.
fn types_compatible_for_naming(t1: &ArgType, t2: &ArgType) -> bool {
    // Same type - always compatible
    if t1 == t2 {
        return true;
    }

    // Unknown types are compatible with anything (they'll be resolved later)
    match (t1, t2) {
        (ArgType::Unknown | ArgType::UnknownNarrow | ArgType::UnknownWide |
         ArgType::UnknownObject | ArgType::UnknownArray | ArgType::UnknownIntegral, _) |
        (_, ArgType::Unknown | ArgType::UnknownNarrow | ArgType::UnknownWide |
         ArgType::UnknownObject | ArgType::UnknownArray | ArgType::UnknownIntegral) => {
            return true;
        }
        _ => {}
    }

    // Primitive types must match exactly (int != boolean, etc.)
    match (t1, t2) {
        (ArgType::Boolean, ArgType::Boolean) |
        (ArgType::Byte, ArgType::Byte) |
        (ArgType::Char, ArgType::Char) |
        (ArgType::Short, ArgType::Short) |
        (ArgType::Int, ArgType::Int) |
        (ArgType::Long, ArgType::Long) |
        (ArgType::Float, ArgType::Float) |
        (ArgType::Double, ArgType::Double) |
        (ArgType::Void, ArgType::Void) => true,

        // Primitives are NOT compatible with each other (int != boolean, etc.)
        (ArgType::Boolean | ArgType::Byte | ArgType::Char | ArgType::Short |
         ArgType::Int | ArgType::Long | ArgType::Float | ArgType::Double | ArgType::Void,
         ArgType::Boolean | ArgType::Byte | ArgType::Char | ArgType::Short |
         ArgType::Int | ArgType::Long | ArgType::Float | ArgType::Double | ArgType::Void) => false,

        // Primitives are NOT compatible with objects
        (ArgType::Boolean | ArgType::Byte | ArgType::Char | ArgType::Short |
         ArgType::Int | ArgType::Long | ArgType::Float | ArgType::Double | ArgType::Void,
         ArgType::Object(_) | ArgType::Array(_) | ArgType::Generic { .. }) |
        (ArgType::Object(_) | ArgType::Array(_) | ArgType::Generic { .. },
         ArgType::Boolean | ArgType::Byte | ArgType::Char | ArgType::Short |
         ArgType::Int | ArgType::Long | ArgType::Float | ArgType::Double | ArgType::Void) => false,

        // Object types are compatible with each other (they share a common ancestor)
        (ArgType::Object(_), ArgType::Object(_)) => true,

        // Arrays are compatible if element types are compatible
        (ArgType::Array(e1), ArgType::Array(e2)) => types_compatible_for_naming(e1, e2),

        // Arrays are NOT compatible with non-array Objects for naming purposes
        // While arrays ARE objects at the JVM level, in Java source code:
        //   String str = readFile();
        //   str = str.split(" ");  // COMPILE ERROR: String[] cannot be assigned to String
        // So Array and Object types must have different variable names.
        (ArgType::Array(_), ArgType::Object(_)) |
        (ArgType::Object(_), ArgType::Array(_)) => false,

        // Generic types - base types must be compatible
        (ArgType::Generic { base: b1, .. }, ArgType::Generic { base: b2, .. }) => {
            b1 == b2 || true  // Generics with same base or different bases can share names
        }
        (ArgType::Generic { .. }, ArgType::Object(_)) |
        (ArgType::Object(_), ArgType::Generic { .. }) => true,

        // Default: incompatible
        _ => false,
    }
}

/// Build CodeVar groups from SSA result by following PHI node connections.
/// This mirrors JADX's InitCodeVariables.collectConnectedVars() - all SSA variables
/// connected through PHI nodes should share the same name.
///
/// TYPE-AWARE VERSION: Variables with incompatible types are NOT grouped together,
/// even if they're PHI-connected. This prevents assigning boolean values to int variables.
///
/// Returns a map: (reg, version) -> code_var_index
/// Variables with the same index should get the same name.
fn build_code_vars(ssa: &SsaResult, type_info: &TypeInferenceResult) -> HashMap<(u16, u32), usize> {
    let mut ssa_to_code_var: HashMap<(u16, u32), usize> = HashMap::new();
    let mut next_code_var_idx = 0usize;

    // Build adjacency list from PHI nodes
    // For each PHI: dest is connected to all sources IF their types are compatible
    let mut phi_connections: HashMap<(u16, u32), HashSet<(u16, u32)>> = HashMap::new();

    for block in &ssa.blocks {
        for phi in &block.phi_nodes {
            let dest = (phi.dest.reg_num, phi.dest.ssa_version);
            let dest_type = type_info.types.get(&dest);

            for (_, source) in &phi.sources {
                let src = (source.reg_num, source.ssa_version);
                let src_type = type_info.types.get(&src);

                // Only connect if types are compatible
                // PHI nodes connect SSA versions of the SAME variable by definition,
                // so we should allow grouping even when types are missing.
                // The name propagation will still work because PHI sources often have
                // instruction-based names (from method calls, field access, etc.)
                let compatible = match (dest_type, src_type) {
                    (Some(dt), Some(st)) => types_compatible_for_naming(dt, st),
                    // If one or both are missing types, allow grouping - PHI means same variable
                    // Name propagation from sources with instruction context will still work
                    _ => true,
                };

                if compatible {
                    // Bidirectional connection (like JADX's collectConnectedVars)
                    phi_connections.entry(dest).or_default().insert(src);
                    phi_connections.entry(src).or_default().insert(dest);
                }
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

            let start_type = type_info.types.get(&start);

            // BFS to find all connected SSA vars with COMPATIBLE types
            let mut connected: Vec<(u16, u32)> = Vec::new();
            let mut queue: VecDeque<(u16, u32)> = VecDeque::new();
            queue.push_back(start);

            while let Some(current) = queue.pop_front() {
                if visited.contains(&current) {
                    continue;
                }

                // Double-check type compatibility before adding to group
                let current_type = type_info.types.get(&current);
                let compatible = match (start_type, current_type) {
                    (Some(st), Some(ct)) => types_compatible_for_naming(st, ct),
                    _ => true,
                };

                if !compatible {
                    // Mark as visited but don't add to this group
                    // It will get its own group later
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
            if !connected.is_empty() {
                let code_var_idx = next_code_var_idx;
                next_code_var_idx += 1;

                for ssa_var in connected {
                    ssa_to_code_var.insert(ssa_var, code_var_idx);
                }
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

    /// Common root package names that should be reserved to prevent collision with
    /// fully-qualified class names. This matches JADX's behavior.
    const DEFAULT_ROOT_PACKAGES: &'static [&'static str] = &[
        // Java core packages
        "java", "javax",
        // Android packages
        "android", "androidx", "dalvik",
        // Common domain packages
        "com", "org", "net", "io", "edu", "gov", "info", "biz",
        // Kotlin packages
        "kotlin", "kotlinx",
    ];

    /// Create a new variable naming context with lookups
    ///
    /// When `inner_class_names` is provided, those names are pre-reserved to prevent
    /// variable names from colliding with inner class short names. This matches JADX's
    /// NameGen.addNamesUsedInClass() behavior.
    ///
    /// Root package names are also reserved by default to prevent collisions with
    /// fully-qualified class names (like `com.example.Foo`).
    pub fn with_lookups(
        first_param_reg: u16,
        method_lookup: Option<&'a dyn Fn(u32) -> Option<MethodNameInfo>>,
        type_lookup: Option<&'a dyn Fn(u32) -> Option<String>>,
        field_lookup: Option<&'a dyn Fn(u32) -> Option<FieldNameInfo>>,
        inner_class_names: Option<&'a [String]>,
    ) -> Self {
        // Pre-reserve names to prevent collisions (JADX's addNamesUsedInClass behavior)
        let mut used_names = HashSet::new();

        // 1. Reserve root package names to avoid collision with fully-qualified class names
        // e.g., prevent `com` variable from conflicting with `com.example.Foo`
        for &pkg in Self::DEFAULT_ROOT_PACKAGES {
            used_names.insert(pkg.to_string());
        }

        // 2. Reserve inner class short names
        if let Some(names) = inner_class_names {
            for name in names {
                // Reserve both the exact name and lowercase version
                // e.g., if inner class is "Builder", reserve "builder" for variables
                let lowercase = name.chars().next()
                    .map(|c| c.to_lowercase().to_string() + &name[1..])
                    .unwrap_or_default();
                if !lowercase.is_empty() {
                    used_names.insert(lowercase);
                }
            }
        }

        VarNaming {
            used_names,
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
        let base = if let Some(first) = chars.next() {
            let rest: String = chars.collect();
            format!("{}{}", first.to_lowercase(), rest)
        } else {
            return String::new();
        };

        // Sanitize to handle invalid characters like hyphens
        sanitize_identifier(&base).unwrap_or_default()
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
            "to", "as", "into", "from", "with",
            // Factory methods
            "create", "new", "make", "build", "of", "parse",
            // Data access methods
            "read", "write", "load", "save", "fetch", "find", "lookup",
            // Database/query methods
            "select", "query", "insert", "update", "delete",
            // Processing methods
            "compute", "calculate", "process", "generate", "extract",
            // Action methods
            "execute", "run", "handle", "apply", "perform", "invoke",
            // Configuration methods
            "configure", "setup", "init", "start", "stop",
            // Resource methods
            "open", "close", "connect", "disconnect",
            // Collection methods
            "add", "remove", "contains", "obtain", "acquire",
        ];

        for prefix in prefixes {
            if method_name.starts_with(prefix) && method_name.len() > prefix.len() {
                let rest = &method_name[prefix.len()..];
                let first_char = rest.chars().next();

                // Check if the next character is uppercase (camelCase: getUser)
                // OR underscore followed by uppercase (snake_case: get_User, build_Manufacturer_UC)
                let is_camel_case = first_char.map(|c| c.is_ascii_uppercase()).unwrap_or(false);
                let is_snake_case = first_char == Some('_') && rest.chars().nth(1).map(|c| c.is_ascii_uppercase()).unwrap_or(false);

                if is_camel_case {
                    // camelCase: convert first char to lowercase
                    let mut chars = rest.chars();
                    if let Some(first) = chars.next() {
                        let rest_str: String = chars.collect();
                        let result = format!("{}{}", first.to_lowercase(), rest_str);
                        // Skip very short names
                        if result.len() >= 2 {
                            // Sanitize result (may contain Kotlin synthetic hyphens)
                            return sanitize_identifier(&result);
                        }
                    }
                } else if is_snake_case {
                    // snake_case: skip underscore, use rest as name (e.g., build_Manufacturer_UC -> manufacturer_UC)
                    let name_part = &rest[1..]; // Skip leading underscore
                    if name_part.len() >= 2 {
                        // Convert first char to lowercase
                        let mut chars = name_part.chars();
                        if let Some(first) = chars.next() {
                            let rest_str: String = chars.collect();
                            let result = format!("{}{}", first.to_lowercase(), rest_str);
                            return sanitize_identifier(&result);
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
                    // Sanitize method name (may contain Kotlin synthetic hyphens like "constructor-impl")
                    return sanitize_identifier(method_name);
                }
            }
        }

        None
    }

    /// Sanitize a name before using it as a variable name
    /// Public wrapper for use in other modules
    pub fn sanitize_name(name: &str) -> Option<String> {
        sanitize_identifier(name)
    }
}

/// Assign names to all variables in an SSA result (without lookups)
pub fn assign_var_names(
    ssa: &SsaResult,
    type_info: &TypeInferenceResult,
    first_param_reg: u16,
    num_params: u16,
) -> VarNamingResult {
    assign_var_names_with_lookups(ssa, type_info, first_param_reg, num_params, None, None, None, None, None, None)
}

/// Assign names to all variables in an SSA result with optional method/type/field lookups
pub fn assign_var_names_with_lookups<'a>(
    ssa: &SsaResult,
    type_info: &TypeInferenceResult,
    first_param_reg: u16,
    num_params: u16,
    param_names: Option<&[String]>,
    method_lookup: Option<&'a dyn Fn(u32) -> Option<MethodNameInfo>>,
    type_lookup: Option<&'a dyn Fn(u32) -> Option<String>>,
    field_lookup: Option<&'a dyn Fn(u32) -> Option<FieldNameInfo>>,
    debug_info: Option<&'a DebugInfo>,
    inner_class_names: Option<&'a [String]>,
) -> VarNamingResult {
    let mut naming = VarNaming::with_lookups(first_param_reg, method_lookup, type_lookup, field_lookup, inner_class_names);

    // Estimate capacity based on SSA result size
    let estimated_vars = ssa.blocks.iter()
        .map(|b| b.instructions.len() + b.phi_nodes.len())
        .sum::<usize>();

    let mut names = HashMap::with_capacity(estimated_vars);

    // Reserve actual parameter names (they're already set up in method signature)
    if let Some(names_slice) = param_names {
        for name in names_slice {
            naming.mark_used(name);
        }
    } else {
        // Fallback: reserve placeholder names for backward compatibility
        for i in 0..num_params {
            let name = format!("p{}", i);
            naming.mark_used(&name);
        }
    }

    // Reserve inner class short names to prevent variable-inner class collisions
    // (like JADX's NameGen.addNamesUsedInClass())
    if let Some(inner_names) = inner_class_names {
        for name in inner_names {
            naming.mark_used(name);
        }
    }

    // Build CodeVar groups from PHI nodes (like JADX's InitCodeVariables)
    // Variables connected through PHI nodes should share the same name
    // TYPE-AWARE: Variables with incompatible types get separate names
    let code_var_map = build_code_vars(ssa, type_info);
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

    // Helper closure to get potential BASE name and its score for a variable
    // IMPORTANT: This returns the BASE name (e.g., "i", "str") without making it unique.
    // The caller must call make_unique() once on the final selected name.
    // This prevents multiple calls to make_unique when evaluating PHI group candidates,
    // which was causing names like i2, i3, i4 when i, i, i should merge to just "i".
    let get_name_candidate_base = |reg: u16, version: u32, ssa: &SsaResult, assignment_map: &HashMap<(u16, u32), (usize, usize, u32)>| -> Option<(String, u32)> {
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
                    if let Some(base_name) = get_base_name_from_instruction(prev_insn, method_lookup, type_lookup, field_lookup) {
                        let score = score_name(&base_name);
                        return Some((base_name, score));
                    }
                }
            }

            // For Move from parameter register, propagate parameter name
            // This fixes the backpressureMode2 vs emitter$BackpressureMode2 issue
            if let dexterity_ir::instructions::InsnType::Move { src, .. } = &insn.insn_type {
                if let dexterity_ir::instructions::InsnArg::Register(src_reg) = src {
                    if src_reg.reg_num >= first_param_reg {
                        // Source is a parameter - try to get the parameter name
                        if let Some(names_slice) = param_names {
                            let param_idx = (src_reg.reg_num - first_param_reg) as usize;
                            if let Some(param_name) = names_slice.get(param_idx) {
                                return Some((param_name.clone(), 90)); // High priority for param names
                            }
                        }
                    }
                }
            }

            if let Some(base_name) = get_base_name_from_instruction(insn, method_lookup, type_lookup, field_lookup) {
                let score = score_name(&base_name);
                return Some((base_name, score));
            }
        }

        // Priority 3: Type-based name (score depends on type quality)
        if let Some(arg_type) = type_info.types.get(&(reg, version)) {
            let base = VarNaming::base_name_for_type(arg_type);
            // Give Unknown types a much lower score so known types always win in groups
            // This prevents "obj" from winning over "str", "list", etc. when PHI nodes
            // connect variables with different type inference quality
            let score = if matches!(arg_type,
                ArgType::Unknown | ArgType::UnknownNarrow | ArgType::UnknownWide |
                ArgType::UnknownObject | ArgType::UnknownArray | ArgType::UnknownIntegral
            ) {
                5  // Low score for unknown types
            } else {
                40  // Normal score for known types
            };
            return Some((base.to_string(), score));
        }

        None
    };

    // For each CodeVar group, find the best BASE name across all members
    for (&code_var_idx, members) in &code_var_members {
        let mut best_name: Option<String> = None;
        let mut best_score: u32 = 0;

        // Collect name candidates from all members (returns BASE names, not unique)
        for &(reg, version) in members {
            if let Some((base_name, score)) = get_name_candidate_base(reg, version, ssa, &assignment_map) {
                if score > best_score {
                    best_score = score;
                    best_name = Some(base_name);
                }
            }
        }

        // Use the best name for the entire group (make unique ONCE here)
        if let Some(base_name) = best_name {
            let unique_name = naming.make_unique(&base_name);
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

        // Priority 2: Context-based BASE name from assignment instruction
        // IMPORTANT: Get base name here, NOT unique name. We call make_unique once at the end.
        let context_base_name = if debug_name.is_none() {
            assignment_map.get(&(reg, version))
                .and_then(|&(block_idx, insn_idx, _)| {
                    let block = &ssa.blocks[block_idx];
                    let insn = &block.instructions[insn_idx];

                    // For MoveResult, look at the previous instruction (should be Invoke)
                    if matches!(insn.insn_type, dexterity_ir::instructions::InsnType::MoveResult { .. }) {
                        if insn_idx > 0 {
                            let prev_insn = &block.instructions[insn_idx - 1];
                            // Get base name from the preceding Invoke instruction
                            if let Some(base) = get_base_name_from_instruction(prev_insn, method_lookup, type_lookup, field_lookup) {
                                return Some(base);
                            }
                        }
                    }

                    // For Move from parameter register, propagate parameter name
                    if let dexterity_ir::instructions::InsnType::Move { src, .. } = &insn.insn_type {
                        if let dexterity_ir::instructions::InsnArg::Register(src_reg) = src {
                            if src_reg.reg_num >= first_param_reg {
                                if let Some(names_slice) = param_names {
                                    let param_idx = (src_reg.reg_num - first_param_reg) as usize;
                                    if let Some(param_name) = names_slice.get(param_idx) {
                                        return Some(param_name.clone());
                                    }
                                }
                            }
                        }
                    }

                    get_base_name_from_instruction(insn, method_lookup, type_lookup, field_lookup)
                })
        } else {
            None
        };

        // Now make the name unique - exactly ONE call to make_unique per variable
        let name = if let Some(name) = debug_name {
            // Got name from debug info (highest priority)
            naming.make_unique(&name)
        } else if let Some(base_name) = context_base_name {
            // Got a base name from instruction context - make it unique now
            naming.make_unique(&base_name)
        } else if let Some(arg_type) = type_info.types.get(&(reg, version)) {
            // Fall back to type-based naming (like JADX's makeNameForType)
            naming.name_for_type(arg_type)
        } else {
            // Last resort: use descriptive fallback name
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

/// Get base name from instruction context without making it unique
/// This is a static function that doesn't consume names from the VarNaming pool.
/// Returns the base name (e.g., "length", "str", "user") that should later be made unique.
fn get_base_name_from_instruction<'a>(
    insn: &dexterity_ir::instructions::InsnNode,
    method_lookup: Option<&'a dyn Fn(u32) -> Option<MethodNameInfo>>,
    type_lookup: Option<&'a dyn Fn(u32) -> Option<String>>,
    field_lookup: Option<&'a dyn Fn(u32) -> Option<FieldNameInfo>>,
) -> Option<String> {
    use dexterity_ir::instructions::{InsnType, CastType};

    match &insn.insn_type {
        // Array length
        InsnType::ArrayLength { .. } => Some("length".to_string()),

        // String constant
        InsnType::ConstString { .. } => Some("str".to_string()),

        // Method invocation - extract name from method name
        InsnType::Invoke { method_idx, .. } => {
            if let Some(lookup) = method_lookup {
                if let Some(info) = lookup(*method_idx) {
                    if let Some(base) = VarNaming::extract_name_from_method(&info.method_name) {
                        return Some(base);
                    }
                }
            }
            None
        }

        // NewInstance - use class name for variable name
        InsnType::NewInstance { type_idx, .. } => {
            if let Some(lookup) = type_lookup {
                if let Some(type_name) = lookup(*type_idx) {
                    let base = VarNaming::extract_class_name_base(&type_name);
                    return Some(base.to_string());
                }
            }
            None
        }

        // Instance field get
        InsnType::InstanceGet { field_idx, .. } => {
            if let Some(lookup) = field_lookup {
                if let Some(info) = lookup(*field_idx) {
                    let base = VarNaming::sanitize_field_name(&info.field_name);
                    if !base.is_empty() && base.len() >= 2 {
                        return Some(base);
                    }
                }
            }
            None
        }

        // Static field get
        InsnType::StaticGet { field_idx, .. } => {
            if let Some(lookup) = field_lookup {
                if let Some(info) = lookup(*field_idx) {
                    let base = VarNaming::sanitize_field_name(&info.field_name);
                    if !base.is_empty() && base.len() >= 2 {
                        return Some(base);
                    }
                }
            }
            None
        }

        // CheckCast - use target type
        InsnType::CheckCast { type_idx, .. } => {
            if let Some(lookup) = type_lookup {
                if let Some(type_name) = lookup(*type_idx) {
                    let base = VarNaming::extract_class_name_base(&type_name);
                    return Some(base.to_string());
                }
            }
            None
        }

        // Primitive Cast
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
            Some(base.to_string())
        }

        // NewArray
        InsnType::NewArray { type_idx, .. } => {
            if let Some(lookup) = type_lookup {
                if let Some(type_name) = lookup(*type_idx) {
                    if let Some(base) = VarNaming::array_var_name_from_type(&type_name) {
                        return Some(base.to_string());
                    }
                }
            }
            Some("arr".to_string())
        }

        // FilledNewArray
        InsnType::FilledNewArray { type_idx, .. } => {
            if let Some(lookup) = type_lookup {
                if let Some(type_name) = lookup(*type_idx) {
                    if let Some(base) = VarNaming::array_var_name_from_type(&type_name) {
                        return Some(base.to_string());
                    }
                }
            }
            Some("arr".to_string())
        }

        // InstanceOf
        InsnType::InstanceOf { .. } => Some("z".to_string()),

        // Compare
        InsnType::Compare { .. } => Some("cmp".to_string()),

        _ => None,
    }
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

    #[test]
    fn test_inner_class_reserved_names() {
        // Test that inner class short names are reserved to prevent variable-class collisions
        // This matches JADX's NameGen.addNamesUsedInClass() behavior

        // When inner class names are provided, they should be reserved
        let inner_class_names = vec![
            "Builder".to_string(),
            "Handler".to_string(),
            "Factory".to_string(),
        ];

        let naming = VarNaming::with_lookups(
            10,
            None,
            None,
            None,
            Some(&inner_class_names),
        );

        // "builder" should be reserved (lowercase version of "Builder")
        assert!(naming.used_names.contains("builder"), "builder should be reserved");
        assert!(naming.used_names.contains("handler"), "handler should be reserved");
        assert!(naming.used_names.contains("factory"), "factory should be reserved");

        // When we try to name a variable, it should get a suffix
        let mut naming = VarNaming::with_lookups(
            10,
            None,
            None,
            None,
            Some(&inner_class_names),
        );

        // A StringBuilder type would normally get "sb", not affected
        let sb_name = naming.name_for_type(&ArgType::Object("java/lang/StringBuilder".to_string()));
        assert_eq!(sb_name, "sb");

        // But a Builder type should get "builder2" since "builder" is reserved
        let builder_name = naming.name_for_type(&ArgType::Object("com/example/Builder".to_string()));
        assert_eq!(builder_name, "builder2", "Should be builder2 since builder is reserved");
    }

    #[test]
    fn test_inner_class_reserved_names_empty() {
        // Test with no inner class names - should still reserve root package names
        let naming = VarNaming::with_lookups(
            10,
            None,
            None,
            None,
            None,
        );

        // Root package names should be reserved by default (JADX parity)
        assert!(naming.used_names.contains("java"), "java should be reserved");
        assert!(naming.used_names.contains("android"), "android should be reserved");
        assert!(naming.used_names.contains("com"), "com should be reserved");
        assert!(naming.used_names.contains("org"), "org should be reserved");
        assert!(naming.used_names.contains("kotlin"), "kotlin should be reserved");
    }

    #[test]
    fn test_root_package_names_reserved() {
        // Test that root package names get numeric suffixes
        let mut naming = VarNaming::with_lookups(
            10,
            None,
            None,
            None,
            None,
        );

        // Try to name a variable "com" - should get "com2" since "com" is reserved
        let name = naming.make_unique("com");
        assert_eq!(name, "com2", "Should be com2 since com is reserved for package names");

        // Similarly for other root packages
        let mut naming2 = VarNaming::with_lookups(10, None, None, None, None);
        let java_name = naming2.make_unique("java");
        assert_eq!(java_name, "java2", "Should be java2 since java is reserved");
    }

    #[test]
    fn test_sanitize_identifier() {
        // Valid identifiers should pass through unchanged
        assert_eq!(sanitize_identifier("validName"), Some("validName".to_string()));
        assert_eq!(sanitize_identifier("_underscore"), Some("_underscore".to_string()));
        assert_eq!(sanitize_identifier("$dollar"), Some("$dollar".to_string()));

        // Hyphens should be converted to camelCase
        assert_eq!(sanitize_identifier("constructor-impl"), Some("constructorImpl".to_string()));
        assert_eq!(sanitize_identifier("padding-3ABfNKs"), Some("padding3ABfNKs".to_string()));
        assert_eq!(sanitize_identifier("lambda-5$app_debug"), Some("lambda5$app_debug".to_string()));

        // Leading digits should get underscore prefix
        assert_eq!(sanitize_identifier("3value"), Some("_3value".to_string()));

        // Empty and all-invalid should return None
        assert_eq!(sanitize_identifier(""), None);
        assert_eq!(sanitize_identifier("---"), None);

        // Reserved words after sanitization should get underscore prefix
        assert_eq!(sanitize_identifier("class"), Some("_class".to_string()));
        assert_eq!(sanitize_identifier("int"), Some("_int".to_string()));

        // Multiple hyphens
        assert_eq!(sanitize_identifier("a-b-c"), Some("aBC".to_string()));

        // Hyphen at start
        assert_eq!(sanitize_identifier("-leading"), Some("Leading".to_string()));
    }

    #[test]
    fn test_sanitize_identifier_kotlin_synthetic() {
        // Real-world Kotlin synthetic name examples
        assert_eq!(sanitize_identifier("get-impl"), Some("getImpl".to_string()));
        assert_eq!(sanitize_identifier("set-impl"), Some("setImpl".to_string()));
        assert_eq!(sanitize_identifier("box-impl"), Some("boxImpl".to_string()));
        assert_eq!(sanitize_identifier("unbox-impl"), Some("unboxImpl".to_string()));

        // Inline class bridge methods
        assert_eq!(sanitize_identifier("equals-impl"), Some("equalsImpl".to_string()));
        assert_eq!(sanitize_identifier("hashCode-impl"), Some("hashCodeImpl".to_string()));
        assert_eq!(sanitize_identifier("toString-impl"), Some("toStringImpl".to_string()));
    }

    #[test]
    fn test_types_compatible_for_naming() {
        // Same types are compatible
        assert!(types_compatible_for_naming(&ArgType::Int, &ArgType::Int));
        assert!(types_compatible_for_naming(&ArgType::Boolean, &ArgType::Boolean));
        assert!(types_compatible_for_naming(
            &ArgType::Object("java/lang/String".to_string()),
            &ArgType::Object("java/lang/String".to_string())
        ));

        // Different primitives are NOT compatible
        assert!(!types_compatible_for_naming(&ArgType::Int, &ArgType::Boolean));
        assert!(!types_compatible_for_naming(&ArgType::Int, &ArgType::Long));
        assert!(!types_compatible_for_naming(&ArgType::Float, &ArgType::Double));
        assert!(!types_compatible_for_naming(&ArgType::Char, &ArgType::Short));

        // Primitives and objects are NOT compatible
        assert!(!types_compatible_for_naming(
            &ArgType::Int,
            &ArgType::Object("java/lang/String".to_string())
        ));
        assert!(!types_compatible_for_naming(
            &ArgType::Boolean,
            &ArgType::Object("java/lang/Boolean".to_string())
        ));

        // Different objects ARE compatible (common ancestor Object)
        assert!(types_compatible_for_naming(
            &ArgType::Object("java/lang/String".to_string()),
            &ArgType::Object("java/lang/Integer".to_string())
        ));

        // Arrays and non-array objects are NOT compatible for naming
        // (commit 3cc55ee8d fixed this - String and String[] must have different names)
        assert!(!types_compatible_for_naming(
            &ArgType::Array(Box::new(ArgType::Int)),
            &ArgType::Object("java/lang/Object".to_string())
        ));

        // Unknown types are compatible with anything
        assert!(types_compatible_for_naming(&ArgType::Unknown, &ArgType::Int));
        assert!(types_compatible_for_naming(&ArgType::Unknown, &ArgType::Boolean));
        assert!(types_compatible_for_naming(
            &ArgType::Unknown,
            &ArgType::Object("java/lang/String".to_string())
        ));
        assert!(types_compatible_for_naming(&ArgType::Int, &ArgType::Unknown));
    }
}
