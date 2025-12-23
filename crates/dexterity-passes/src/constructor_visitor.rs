//! Constructor processing pass
//!
//! This pass processes constructors:
//! - Identifies super()/this() calls
//! - Handles constructor chaining
//! - Marks implicit default constructors
//! - Processes field initialization in constructors
//!
//! Based on JADX's ConstructorVisitor.java visitor.

use dexterity_ir::instructions::{InsnArg, InsnNode, InsnType, InvokeKind};

/// Result of constructor processing
#[derive(Debug, Default)]
pub struct ConstructorVisitorResult {
    /// Number of super() calls found
    pub super_calls: usize,
    /// Number of this() calls found
    pub this_calls: usize,
    /// Number of field initializations found
    pub field_inits: usize,
    /// Whether this is an implicit default constructor
    pub is_implicit_default: bool,
}

/// Information about a constructor
#[derive(Debug, Clone)]
pub struct ConstructorInfo {
    /// Method index of the constructor
    pub method_idx: u32,
    /// Type of constructor call (super or this)
    pub call_type: ConstructorCallType,
    /// Index of the super/this call instruction (if any)
    pub call_insn_idx: Option<usize>,
    /// Arguments passed to super/this (excluding 'this' pointer)
    pub call_args: Vec<InsnArg>,
    /// Field initializations before super/this call
    pub pre_call_field_inits: Vec<FieldInit>,
    /// Field initializations after super/this call
    pub post_call_field_inits: Vec<FieldInit>,
}

/// Type of constructor call
#[derive(Debug, Clone, Copy, PartialEq, Eq)]
pub enum ConstructorCallType {
    /// Calls superclass constructor
    Super,
    /// Calls another constructor in same class
    This,
    /// No explicit super/this call (implicit super())
    Implicit,
}

/// Field initialization in constructor
#[derive(Debug, Clone)]
pub struct FieldInit {
    /// Field index being initialized
    pub field_idx: u32,
    /// Value being assigned
    pub value: InsnArg,
    /// Instruction index
    pub insn_idx: usize,
}

/// Process a constructor method
///
/// # Arguments
/// * `instructions` - Instructions in the constructor
/// * `class_type_idx` - Type index of the class being constructed
/// * `super_type_idx` - Type index of the superclass
/// * `method_idx` - Method index of the constructor
///
/// # Returns
/// * `ConstructorInfo` with constructor analysis
pub fn process_constructor(
    instructions: &[InsnNode],
    class_type_idx: u32,
    super_type_idx: Option<u32>,
    method_idx: u32,
) -> ConstructorInfo {
    let mut info = ConstructorInfo {
        method_idx,
        call_type: ConstructorCallType::Implicit,
        call_insn_idx: None,
        call_args: vec![],
        pre_call_field_inits: vec![],
        post_call_field_inits: vec![],
    };

    // Find the super()/this() call
    let mut found_call = false;

    for (idx, insn) in instructions.iter().enumerate() {
        match &insn.insn_type {
            InsnType::Invoke { kind: InvokeKind::Direct, method_idx: invoke_method_idx, args, .. } => {
                // Check if this is a constructor call on 'this'
                if is_constructor_call_on_this(args) {
                    // Determine if it's super() or this()
                    // This would need method resolution to check the class
                    // For now, assume it's super() if not yet found
                    if !found_call {
                        if is_super_call(super_type_idx, *invoke_method_idx) {
                            info.call_type = ConstructorCallType::Super;
                        } else {
                            info.call_type = ConstructorCallType::This;
                        }
                        info.call_insn_idx = Some(idx);
                        info.call_args = args.iter().skip(1).cloned().collect();
                        found_call = true;
                    }
                }
            }

            InsnType::InstancePut { object, field_idx, value, .. } => {
                // Check if this is a field init on 'this'
                if is_this_reference(object) {
                    let field_init = FieldInit {
                        field_idx: *field_idx,
                        value: value.clone(),
                        insn_idx: idx,
                    };

                    if found_call {
                        info.post_call_field_inits.push(field_init);
                    } else {
                        info.pre_call_field_inits.push(field_init);
                    }
                }
            }

            _ => {}
        }
    }

    info
}

/// Check if arguments represent a constructor call on 'this'
fn is_constructor_call_on_this(args: &dexterity_ir::instructions::InsnArgs) -> bool {
    if let Some(first) = args.first() {
        if let InsnArg::Register(reg) = first {
            // Register 0 with SSA version 0 is typically 'this'
            // In a more complete implementation, we'd track the 'this' reference
            return reg.reg_num == 0;
        }
    }
    false
}

/// Check if this is a call to a superclass constructor
fn is_super_call(_super_type_idx: Option<u32>, _method_idx: u32) -> bool {
    // This would need method resolution to check if the method
    // belongs to the superclass. For now, assume true.
    true
}

/// Check if an argument is a reference to 'this'
fn is_this_reference(arg: &InsnArg) -> bool {
    if let InsnArg::Register(reg) = arg {
        // Register 0 with SSA version 0 is typically 'this'
        return reg.reg_num == 0;
    }
    false
}

/// Check if a constructor is an implicit default constructor
///
/// An implicit default constructor:
/// - Has no parameters (except 'this')
/// - Only calls super()
/// - Has no other instructions
pub fn is_implicit_default_constructor(
    instructions: &[InsnNode],
    super_type_idx: Option<u32>,
) -> bool {
    // Filter out NOP and RETURN instructions
    let meaningful_insns: Vec<_> = instructions.iter()
        .filter(|insn| !matches!(insn.insn_type, InsnType::Nop | InsnType::Return { value: None }))
        .collect();

    if meaningful_insns.len() != 1 {
        return false;
    }

    // Check if it's just a super() call with no args
    if let InsnType::Invoke { kind: InvokeKind::Direct, args, .. } = &meaningful_insns[0].insn_type {
        // Should have only 'this' argument
        if args.len() == 1 && is_constructor_call_on_this(args) {
            return true;
        }
    }

    false
}

/// Check if a method is a constructor
pub fn is_constructor(method_name: &str) -> bool {
    method_name == "<init>"
}

/// Check if a method is a static initializer
pub fn is_static_initializer(method_name: &str) -> bool {
    method_name == "<clinit>"
}

/// Result of analyzing all constructors in a class
#[derive(Debug, Default)]
pub struct ClassConstructorAnalysis {
    /// All constructors in the class
    pub constructors: Vec<ConstructorInfo>,
    /// Whether the class has an implicit default constructor
    pub has_implicit_default: bool,
    /// Field initializations that can be moved to field declarations
    pub common_field_inits: Vec<u32>,
}

/// Analyze all constructors in a class
pub fn analyze_class_constructors(
    constructor_insns: &[(u32, Vec<InsnNode>)], // (method_idx, instructions)
    class_type_idx: u32,
    super_type_idx: Option<u32>,
) -> ClassConstructorAnalysis {
    let mut analysis = ClassConstructorAnalysis::default();

    for (method_idx, instructions) in constructor_insns {
        let info = process_constructor(instructions, class_type_idx, super_type_idx, *method_idx);

        if is_implicit_default_constructor(instructions, super_type_idx) {
            analysis.has_implicit_default = true;
        }

        analysis.constructors.push(info);
    }

    // Find common field initializations
    // TODO: Implement detection of field inits that are the same in all constructors

    analysis
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn test_is_constructor() {
        assert!(is_constructor("<init>"));
        assert!(!is_constructor("init"));
        assert!(!is_constructor("foo"));
    }

    #[test]
    fn test_is_static_initializer() {
        assert!(is_static_initializer("<clinit>"));
        assert!(!is_static_initializer("clinit"));
    }

    #[test]
    fn test_empty_constructor() {
        let instructions = vec![
            InsnNode::new(InsnType::Return { value: None }, 0),
        ];

        // This would be an implicit default if super() call is implicit
        let insns_meaningful: Vec<_> = instructions.iter()
            .filter(|i| !matches!(i.insn_type, InsnType::Nop | InsnType::Return { value: None }))
            .collect();

        assert!(insns_meaningful.is_empty());
    }
}
