//! Usage information collection pass
//!
//! This pass builds a usage graph for classes, methods, and fields:
//! - Tracks which classes depend on which other classes
//! - Tracks which methods are used by which methods
//! - Tracks which fields are used by which methods
//! - Enables class dependency ordering and anonymous class detection
//!
//! Based on JADX's UsageInfoVisitor.java and UsageInfo.java.

use std::collections::{HashMap, HashSet};
use dexterity_ir::instructions::{InsnArg, InsnNode, InsnType};
use dexterity_ir::types::ArgType;

/// Usage information for a DEX file
///
/// This tracks the usage relationships between classes, methods, and fields.
#[derive(Debug, Default)]
pub struct UsageInfo {
    /// Class dependencies: class -> set of classes it depends on
    /// (for load ordering)
    pub class_dependencies: HashMap<u32, HashSet<u32>>,

    /// Class usage: class -> set of classes that use it
    /// (reverse of dependencies)
    pub class_usage: HashMap<u32, HashSet<u32>>,

    /// Class usage in methods: class -> set of methods that use it
    pub class_use_in_methods: HashMap<u32, HashSet<MethodRef>>,

    /// Field usage: field -> set of methods that use it
    pub field_usage: HashMap<FieldRef, HashSet<MethodRef>>,

    /// Method usage: method -> set of methods that call it
    pub method_usage: HashMap<MethodRef, HashSet<MethodRef>>,
}

/// Reference to a method (class_idx, method_idx)
#[derive(Debug, Clone, Copy, PartialEq, Eq, Hash)]
pub struct MethodRef {
    pub class_idx: u32,
    pub method_idx: u32,
}

/// Reference to a field (class_idx, field_idx)
#[derive(Debug, Clone, Copy, PartialEq, Eq, Hash)]
pub struct FieldRef {
    pub class_idx: u32,
    pub field_idx: u32,
}

impl MethodRef {
    pub fn new(class_idx: u32, method_idx: u32) -> Self {
        MethodRef { class_idx, method_idx }
    }
}

impl FieldRef {
    pub fn new(class_idx: u32, field_idx: u32) -> Self {
        FieldRef { class_idx, field_idx }
    }
}

impl UsageInfo {
    /// Create a new empty usage info
    pub fn new() -> Self {
        UsageInfo::default()
    }

    /// Record that a class uses another class
    pub fn add_class_use(&mut self, from_class: u32, to_class: u32) {
        if from_class == to_class {
            return; // Skip self-references
        }

        // Add dependency: from_class depends on to_class
        self.class_dependencies
            .entry(from_class)
            .or_default()
            .insert(to_class);

        // Add reverse usage: to_class is used by from_class
        self.class_usage
            .entry(to_class)
            .or_default()
            .insert(from_class);
    }

    /// Record that a method uses a class
    pub fn add_class_use_in_method(&mut self, class_idx: u32, method: MethodRef) {
        if class_idx == method.class_idx {
            return; // Skip self-references (class usage in its own methods)
        }

        self.class_use_in_methods
            .entry(class_idx)
            .or_default()
            .insert(method);

        // Also record class dependency
        self.add_class_use(method.class_idx, class_idx);
    }

    /// Record that a method uses a field
    pub fn add_field_use(&mut self, field: FieldRef, method: MethodRef) {
        self.field_usage
            .entry(field)
            .or_default()
            .insert(method);

        // Also record class dependency (method's class depends on field's class)
        self.add_class_use(method.class_idx, field.class_idx);
    }

    /// Record that a method calls another method
    pub fn add_method_use(&mut self, called_method: MethodRef, calling_method: MethodRef) {
        self.method_usage
            .entry(called_method)
            .or_default()
            .insert(calling_method);

        // Also record class dependency
        self.add_class_use(calling_method.class_idx, called_method.class_idx);
    }

    /// Get classes that a class depends on
    pub fn get_dependencies(&self, class_idx: u32) -> Vec<u32> {
        self.class_dependencies
            .get(&class_idx)
            .map(|s| s.iter().copied().collect())
            .unwrap_or_default()
    }

    /// Get classes that use a class
    pub fn get_class_usage(&self, class_idx: u32) -> Vec<u32> {
        self.class_usage
            .get(&class_idx)
            .map(|s| s.iter().copied().collect())
            .unwrap_or_default()
    }

    /// Get methods that use a class
    pub fn get_class_use_in_methods(&self, class_idx: u32) -> Vec<MethodRef> {
        self.class_use_in_methods
            .get(&class_idx)
            .map(|s| s.iter().copied().collect())
            .unwrap_or_default()
    }

    /// Get methods that use a field
    pub fn get_field_usage(&self, field: FieldRef) -> Vec<MethodRef> {
        self.field_usage
            .get(&field)
            .map(|s| s.iter().copied().collect())
            .unwrap_or_default()
    }

    /// Get methods that call a method
    pub fn get_method_usage(&self, method: MethodRef) -> Vec<MethodRef> {
        self.method_usage
            .get(&method)
            .map(|s| s.iter().copied().collect())
            .unwrap_or_default()
    }

    /// Check if a class is used by only one method
    pub fn is_single_use_class(&self, class_idx: u32) -> bool {
        self.class_use_in_methods
            .get(&class_idx)
            .map(|s| s.len() == 1)
            .unwrap_or(false)
    }

    /// Check if a method is called from only one place
    pub fn is_single_use_method(&self, method: MethodRef) -> bool {
        self.method_usage
            .get(&method)
            .map(|s| s.len() == 1)
            .unwrap_or(false)
    }

    /// Get the single caller of a method (if there is exactly one)
    pub fn get_single_caller(&self, method: MethodRef) -> Option<MethodRef> {
        self.method_usage
            .get(&method)
            .and_then(|callers| {
                if callers.len() == 1 {
                    callers.iter().next().copied()
                } else {
                    None
                }
            })
    }
}

/// Collect usage info from a list of instructions
///
/// # Arguments
/// * `instructions` - Instructions to analyze
/// * `current_class` - Class index of the current class
/// * `current_method` - Method index of the current method
/// * `usage` - Usage info to update
/// * `resolve_class` - Function to resolve a type_idx to class_idx (or None if external)
pub fn collect_usage_from_instructions<F>(
    instructions: &[InsnNode],
    current_class: u32,
    current_method: u32,
    usage: &mut UsageInfo,
    resolve_class: F,
) where
    F: Fn(u32) -> Option<u32>,
{
    let current_method_ref = MethodRef::new(current_class, current_method);

    for insn in instructions {
        collect_usage_from_insn(insn, current_method_ref, usage, &resolve_class);
    }
}

/// Collect usage info with full DEX context (field and method resolution)
///
/// JADX Reference: UsageInfoVisitor.java
///
/// # Arguments
/// * `instructions` - Instructions to analyze
/// * `current_class` - Class index of the current class
/// * `current_method` - Method index of the current method
/// * `usage` - Usage info to update
/// * `resolve_class` - Function to resolve a type_idx to class_idx (or None if external)
/// * `resolve_field` - Function to resolve a field_idx to (declaring_class_idx, field_idx) (or None if external)
/// * `resolve_method` - Function to resolve a method_idx to (declaring_class_idx, method_idx) (or None if external)
pub fn collect_usage_from_instructions_full<FC, FF, FM>(
    instructions: &[InsnNode],
    current_class: u32,
    current_method: u32,
    usage: &mut UsageInfo,
    resolve_class: FC,
    resolve_field: FF,
    resolve_method: FM,
) where
    FC: Fn(u32) -> Option<u32>,
    FF: Fn(u32) -> Option<(u32, u32)>,
    FM: Fn(u32) -> Option<(u32, u32)>,
{
    let current_method_ref = MethodRef::new(current_class, current_method);

    for insn in instructions {
        collect_usage_from_insn_full(
            insn,
            current_method_ref,
            usage,
            &resolve_class,
            &resolve_field,
            &resolve_method,
        );
    }
}

/// Collect usage from a single instruction
fn collect_usage_from_insn<F>(
    insn: &InsnNode,
    current_method: MethodRef,
    usage: &mut UsageInfo,
    resolve_class: &F,
) where
    F: Fn(u32) -> Option<u32>,
{
    match &insn.insn_type {
        // Type references
        InsnType::ConstClass { type_idx, .. } |
        InsnType::NewInstance { type_idx, .. } |
        InsnType::NewArray { type_idx, .. } |
        InsnType::CheckCast { type_idx, .. } |
        InsnType::InstanceOf { type_idx, .. } => {
            if let Some(class_idx) = resolve_class(*type_idx) {
                usage.add_class_use_in_method(class_idx, current_method);
            }
        }

        InsnType::FilledNewArray { type_idx, .. } => {
            if let Some(class_idx) = resolve_class(*type_idx) {
                usage.add_class_use_in_method(class_idx, current_method);
            }
        }

        // Field references
        // NOTE: For proper class resolution, use collect_usage_from_instructions_full()
        // JADX Reference: UsageInfoVisitor.java - field handling with class resolution
        InsnType::InstanceGet { field_idx, .. } |
        InsnType::InstancePut { field_idx, .. } |
        InsnType::StaticGet { field_idx, .. } |
        InsnType::StaticPut { field_idx, .. } => {
            // Without resolver, use field_idx as both class and field (legacy behavior)
            // For proper resolution, use collect_usage_from_instructions_full() with resolve_field
            let field_ref = FieldRef::new(0, *field_idx);
            usage.add_field_use(field_ref, current_method);
        }

        // Method references
        // NOTE: For proper class resolution, use collect_usage_from_instructions_full()
        // JADX Reference: UsageInfoVisitor.java - method handling with class resolution
        InsnType::Invoke { method_idx, .. } => {
            // Without resolver, use method_idx as both class and method (legacy behavior)
            // For proper resolution, use collect_usage_from_instructions_full() with resolve_method
            let called_method = MethodRef::new(0, *method_idx);
            usage.add_method_use(called_method, current_method);
        }

        InsnType::InvokeCustom { .. } => {
            // Lambda/method references - would need call site resolution
            // For now, skip
        }

        InsnType::Constructor { type_idx, method_idx, .. } => {
            if let Some(class_idx) = resolve_class(*type_idx) {
                usage.add_class_use_in_method(class_idx, current_method);
                let called_method = MethodRef::new(class_idx, *method_idx);
                usage.add_method_use(called_method, current_method);
            }
        }

        // Other instructions don't create usage relationships
        _ => {}
    }
}

/// Collect usage from a single instruction with full DEX context
///
/// JADX Reference: UsageInfoVisitor.java - processInsn()
fn collect_usage_from_insn_full<FC, FF, FM>(
    insn: &InsnNode,
    current_method: MethodRef,
    usage: &mut UsageInfo,
    resolve_class: &FC,
    resolve_field: &FF,
    resolve_method: &FM,
) where
    FC: Fn(u32) -> Option<u32>,
    FF: Fn(u32) -> Option<(u32, u32)>,
    FM: Fn(u32) -> Option<(u32, u32)>,
{
    match &insn.insn_type {
        // Type references
        InsnType::ConstClass { type_idx, .. } |
        InsnType::NewInstance { type_idx, .. } |
        InsnType::NewArray { type_idx, .. } |
        InsnType::CheckCast { type_idx, .. } |
        InsnType::InstanceOf { type_idx, .. } => {
            if let Some(class_idx) = resolve_class(*type_idx) {
                usage.add_class_use_in_method(class_idx, current_method);
            }
        }

        InsnType::FilledNewArray { type_idx, .. } => {
            if let Some(class_idx) = resolve_class(*type_idx) {
                usage.add_class_use_in_method(class_idx, current_method);
            }
        }

        // Field references - JADX parity: resolve declaring class from field_idx
        // JADX Reference: UsageInfoVisitor.processInsn() - field handling
        InsnType::InstanceGet { field_idx, .. } |
        InsnType::InstancePut { field_idx, .. } |
        InsnType::StaticGet { field_idx, .. } |
        InsnType::StaticPut { field_idx, .. } => {
            if let Some((declaring_class, field_id)) = resolve_field(*field_idx) {
                let field_ref = FieldRef::new(declaring_class, field_id);
                usage.add_field_use(field_ref, current_method);
            }
        }

        // Method references - JADX parity: resolve declaring class from method_idx
        // JADX Reference: UsageInfoVisitor.processInsn() - method handling
        InsnType::Invoke { method_idx, .. } => {
            if let Some((declaring_class, method_id)) = resolve_method(*method_idx) {
                let called_method = MethodRef::new(declaring_class, method_id);
                usage.add_method_use(called_method, current_method);
            }
        }

        InsnType::InvokeCustom { .. } => {
            // Lambda/method references - would need call site resolution
            // JADX handles this via CallSite resolution
        }

        InsnType::Constructor { type_idx, method_idx, .. } => {
            if let Some(class_idx) = resolve_class(*type_idx) {
                usage.add_class_use_in_method(class_idx, current_method);
                // For constructors, the method_idx is relative to the type
                if let Some((_, method_id)) = resolve_method(*method_idx) {
                    let called_method = MethodRef::new(class_idx, method_id);
                    usage.add_method_use(called_method, current_method);
                }
            }
        }

        // Other instructions don't create usage relationships
        _ => {}
    }
}

/// Result of usage collection
#[derive(Debug)]
pub struct UsageCollectionResult {
    /// The collected usage information
    pub usage: UsageInfo,
    /// Number of type references processed
    pub type_refs: usize,
    /// Number of field references processed
    pub field_refs: usize,
    /// Number of method references processed
    pub method_refs: usize,
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn test_class_dependency() {
        let mut usage = UsageInfo::new();

        usage.add_class_use(1, 2);
        usage.add_class_use(1, 3);
        usage.add_class_use(2, 3);

        let deps = usage.get_dependencies(1);
        assert!(deps.contains(&2));
        assert!(deps.contains(&3));

        let users = usage.get_class_usage(3);
        assert!(users.contains(&1));
        assert!(users.contains(&2));
    }

    #[test]
    fn test_method_usage() {
        let mut usage = UsageInfo::new();

        let caller = MethodRef::new(1, 10);
        let callee = MethodRef::new(2, 20);

        usage.add_method_use(callee, caller);

        assert!(usage.is_single_use_method(callee));
        assert_eq!(usage.get_single_caller(callee), Some(caller));
    }

    #[test]
    fn test_skip_self_reference() {
        let mut usage = UsageInfo::new();

        usage.add_class_use(1, 1); // Self-reference

        assert!(usage.get_dependencies(1).is_empty());
    }
}
