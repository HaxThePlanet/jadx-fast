//! Kotlin toString() method bytecode parser for extracting field names
//!
//! Kotlin data classes generate toString() methods with a predictable pattern:
//! ```kotlin
//! override fun toString() = "ClassName(field1=$field1, field2=$field2)"
//! ```
//!
//! This compiles to bytecode like:
//! ```text
//! new-instance StringBuilder
//! invoke-direct StringBuilder.<init>
//! const-string "ClassName(field1="
//! invoke-virtual StringBuilder.append(String)
//! iget-object this.field1
//! invoke-virtual StringBuilder.append(Object)
//! const-string ", field2="
//! invoke-virtual StringBuilder.append(String)
//! iget-object this.field2
//! invoke-virtual StringBuilder.append(Object)
//! const-string ")"
//! invoke-virtual StringBuilder.append(String)
//! invoke-virtual StringBuilder.toString() -> result
//! return-object result
//! ```
//!
//! By parsing this pattern, we can extract original field names even when
//! the bytecode has been obfuscated.

use dexterity_ir::instructions::{InsnArg, InsnNode, InsnType, InvokeKind};
use dexterity_ir::MethodData;

/// Helper to get register number from InsnArg
fn get_reg_num(arg: &InsnArg) -> Option<u16> {
    arg.as_register().map(|r| r.reg_num)
}

/// Result of parsing a toString() method
#[derive(Debug, Default)]
pub struct ToStringResult {
    /// Class name extracted from first string (e.g., "User" from "User(name=...")
    pub class_alias: Option<String>,
    /// Field renames: (field_idx, alias)
    pub field_renames: Vec<(u32, String)>,
}

/// Parser state machine for toString() bytecode
struct ToStringParser {
    /// Has StringBuilder construction been detected
    is_started: bool,
    /// Has first property been processed (contains class name)
    is_first_processed: bool,
    /// Has toString() call been detected (parsing complete)
    is_finished: bool,
    /// Pending field name from most recent string literal
    pending_alias: Option<String>,
    /// Extracted class name
    class_alias: Option<String>,
    /// Collected (field_idx, alias) pairs
    field_mappings: Vec<(u32, String)>,
    /// Track which register holds the StringBuilder instance
    sb_register: Option<u16>,
    /// Track registers and their source (for data flow)
    register_sources: std::collections::HashMap<u16, RegisterSource>,
}

/// Source of a register value
#[derive(Debug, Clone)]
enum RegisterSource {
    /// ConstString with value
    ConstString(String),
    /// InstanceGet with field_idx
    InstanceGet(u32),
    /// MoveResult from invoke (StringBuilder.append returns StringBuilder)
    MoveResult,
    /// Other/unknown
    Other,
}

impl ToStringParser {
    fn new() -> Self {
        Self {
            is_started: false,
            is_first_processed: false,
            is_finished: false,
            pending_alias: None,
            class_alias: None,
            field_mappings: Vec::new(),
            sb_register: None,
            register_sources: std::collections::HashMap::new(),
        }
    }

    /// Process a single instruction
    fn process(&mut self, insn: &InsnNode, type_resolver: &impl TypeResolver) {
        // Track register sources for data flow analysis
        self.track_register_source(insn, type_resolver);

        if !self.is_started {
            self.is_started = self.is_start_string_builder(insn, type_resolver);
            return;
        }

        if self.is_finished {
            return;
        }

        // Check for StringBuilder.append() invocation
        if self.is_append_invoke(insn, type_resolver) {
            self.handle_append(insn);
            return;
        }

        // Check for StringBuilder.toString() invocation (end of pattern)
        self.is_finished = self.is_tostring_call(insn, type_resolver);
    }

    /// Track what value a register holds
    fn track_register_source(&mut self, insn: &InsnNode, type_resolver: &impl TypeResolver) {
        match &insn.insn_type {
            InsnType::ConstString { dest, string_idx } => {
                if let Some(s) = type_resolver.get_string(*string_idx) {
                    self.register_sources.insert(dest.reg_num, RegisterSource::ConstString(s));
                }
            }
            InsnType::InstanceGet { dest, field_idx, .. } => {
                self.register_sources.insert(dest.reg_num, RegisterSource::InstanceGet(*field_idx));
            }
            InsnType::MoveResult { dest } => {
                self.register_sources.insert(dest.reg_num, RegisterSource::MoveResult);
            }
            InsnType::Move { dest, src } => {
                // Propagate source tracking through moves
                if let Some(reg_num) = get_reg_num(src) {
                    if let Some(source) = self.register_sources.get(&reg_num).cloned() {
                        self.register_sources.insert(dest.reg_num, source);
                    }
                }
            }
            InsnType::NewInstance { dest, type_idx } => {
                // Check if this is StringBuilder
                if let Some(type_name) = type_resolver.get_type(*type_idx) {
                    if type_name.contains("StringBuilder") {
                        self.sb_register = Some(dest.reg_num);
                    }
                }
                self.register_sources.insert(dest.reg_num, RegisterSource::Other);
            }
            _ => {}
        }
    }

    /// Check if instruction starts StringBuilder construction
    fn is_start_string_builder(&mut self, insn: &InsnNode, type_resolver: &impl TypeResolver) -> bool {
        match &insn.insn_type {
            // Pattern 1: new-instance StringBuilder
            InsnType::NewInstance { dest, type_idx } => {
                if let Some(type_name) = type_resolver.get_type(*type_idx) {
                    if type_name.contains("StringBuilder") || type_name.contains("Ljava/lang/StringBuilder;") {
                        self.sb_register = Some(dest.reg_num);
                        return true;
                    }
                }
                false
            }
            // Pattern 2: Constructor invoke on StringBuilder (after new-instance)
            InsnType::Invoke { kind: InvokeKind::Direct, method_idx, args, .. } => {
                if let Some(method_name) = type_resolver.get_method(*method_idx) {
                    if method_name.contains("StringBuilder") && method_name.contains("<init>") {
                        // Mark the first arg register as StringBuilder
                        if let Some(first_arg) = args.first() {
                            if let Some(reg) = get_reg_num(first_arg) {
                                self.sb_register = Some(reg);
                                return true;
                            }
                        }
                    }
                }
                false
            }
            _ => false,
        }
    }

    /// Check if instruction is StringBuilder.append() call
    fn is_append_invoke(&self, insn: &InsnNode, type_resolver: &impl TypeResolver) -> bool {
        if let InsnType::Invoke { kind: InvokeKind::Virtual, method_idx, args, .. } = &insn.insn_type {
            // Must have at least 2 args (this + value to append)
            if args.len() < 2 {
                return false;
            }

            // Check if calling on StringBuilder
            if let Some(sb_reg) = self.sb_register {
                if let Some(first_arg) = args.first() {
                    if get_reg_num(first_arg) != Some(sb_reg) {
                        // Not calling on the tracked StringBuilder
                        // But result may be in a different register after previous append
                        // (StringBuilder.append returns 'this')
                    }
                }
            }

            if let Some(method_name) = type_resolver.get_method(*method_idx) {
                return method_name.contains("StringBuilder") && method_name.contains("append");
            }
        }
        false
    }

    /// Handle StringBuilder.append() - extract field name or field reference
    fn handle_append(&mut self, insn: &InsnNode) {
        if let InsnType::Invoke { args, .. } = &insn.insn_type {
            // Second argument is the value being appended
            if args.len() >= 2 {
                if let Some(arg_reg) = args.get(1).and_then(|a| get_reg_num(a)) {
                    // Clone the source to avoid borrow conflict with self.handle_*()
                    if let Some(source) = self.register_sources.get(&arg_reg).cloned() {
                        match source {
                            RegisterSource::ConstString(s) => {
                                self.handle_string(&s);
                            }
                            RegisterSource::InstanceGet(field_idx) => {
                                self.handle_field_info(field_idx);
                            }
                            _ => {}
                        }
                    }
                }
            }
        }
    }

    /// Handle string literal from toString pattern
    fn handle_string(&mut self, string: &str) {
        if self.pending_alias.is_some() {
            // Previous pending alias wasn't matched to a field - skip it
            tracing::trace!("Skipping unmatched pending alias");
        }

        if !self.is_first_processed {
            // First string contains class name: "ClassName(field1="
            // Extract class name (before '(')
            self.class_alias = string.split('(').next().map(|s| s.to_string());

            // Extract first field name (after '(' and before '=')
            if let Some(after_paren) = string.split('(').nth(1) {
                if let Some(field_name) = after_paren.strip_suffix('=') {
                    self.pending_alias = Some(field_name.to_string());
                }
            }
            self.is_first_processed = true;
        } else {
            // Subsequent strings: ", fieldN="
            // Extract field name (after ", " and before '=')
            let trimmed = string.trim_start_matches(", ").trim_start_matches(',').trim();
            if let Some(field_name) = trimmed.strip_suffix('=') {
                self.pending_alias = Some(field_name.to_string());
            } else if string == ")" {
                // End of toString pattern
            }
        }
    }

    /// Handle field reference - pair with pending alias
    fn handle_field_info(&mut self, field_idx: u32) {
        if let Some(alias) = self.pending_alias.take() {
            self.field_mappings.push((field_idx, alias));
        }
    }

    /// Check if instruction is StringBuilder.toString() call
    fn is_tostring_call(&self, insn: &InsnNode, type_resolver: &impl TypeResolver) -> bool {
        if let InsnType::Invoke { kind: InvokeKind::Virtual, method_idx, .. } = &insn.insn_type {
            if let Some(method_name) = type_resolver.get_method(*method_idx) {
                return method_name.contains("StringBuilder") && method_name.contains("toString");
            }
        }
        false
    }

    /// Check if parsing was successful
    fn is_success(&self) -> bool {
        self.is_started && self.is_finished && !self.field_mappings.is_empty()
    }

    /// Build result
    fn into_result(self) -> Option<ToStringResult> {
        if self.is_success() {
            Some(ToStringResult {
                class_alias: self.class_alias,
                field_renames: self.field_mappings,
            })
        } else {
            None
        }
    }
}

/// Trait for resolving DEX type/method/string indices
pub trait TypeResolver {
    fn get_type(&self, type_idx: u32) -> Option<String>;
    fn get_method(&self, method_idx: u32) -> Option<String>;
    fn get_string(&self, string_idx: u32) -> Option<String>;
}

/// Parse toString() method to extract field names
///
/// This analyzes the bytecode pattern generated by Kotlin data classes
/// to extract original field names even when code is obfuscated.
pub fn parse_tostring<T: TypeResolver>(
    method: &MethodData,
    instructions: &[InsnNode],
    type_resolver: &T,
) -> Option<ToStringResult> {
    // Only process toString() methods
    if method.name != "toString" || !method.arg_types.is_empty() {
        return None;
    }

    let mut parser = ToStringParser::new();

    for insn in instructions {
        parser.process(insn, type_resolver);
    }

    parser.into_result()
}

#[cfg(test)]
mod tests {
    use super::*;

    struct MockResolver {
        types: std::collections::HashMap<u32, String>,
        methods: std::collections::HashMap<u32, String>,
        strings: std::collections::HashMap<u32, String>,
    }

    impl TypeResolver for MockResolver {
        fn get_type(&self, type_idx: u32) -> Option<String> {
            self.types.get(&type_idx).cloned()
        }
        fn get_method(&self, method_idx: u32) -> Option<String> {
            self.methods.get(&method_idx).cloned()
        }
        fn get_string(&self, string_idx: u32) -> Option<String> {
            self.strings.get(&string_idx).cloned()
        }
    }

    #[test]
    fn test_handle_string_first() {
        let mut parser = ToStringParser::new();
        parser.is_started = true;

        parser.handle_string("User(name=");
        assert_eq!(parser.class_alias, Some("User".to_string()));
        assert_eq!(parser.pending_alias, Some("name".to_string()));
        assert!(parser.is_first_processed);
    }

    #[test]
    fn test_handle_string_subsequent() {
        let mut parser = ToStringParser::new();
        parser.is_started = true;
        parser.is_first_processed = true;

        parser.handle_string(", age=");
        assert_eq!(parser.pending_alias, Some("age".to_string()));
    }

    #[test]
    fn test_handle_field_info() {
        let mut parser = ToStringParser::new();
        parser.pending_alias = Some("name".to_string());

        parser.handle_field_info(42);
        assert!(parser.pending_alias.is_none());
        assert_eq!(parser.field_mappings.len(), 1);
        assert_eq!(parser.field_mappings[0], (42, "name".to_string()));
    }

    #[test]
    fn test_success_detection() {
        let mut parser = ToStringParser::new();
        assert!(!parser.is_success());

        parser.is_started = true;
        assert!(!parser.is_success());

        parser.is_finished = true;
        assert!(!parser.is_success()); // No field mappings yet

        parser.field_mappings.push((1, "name".to_string()));
        assert!(parser.is_success());
    }
}
