//! Anonymous class processing pass
//!
//! This pass marks anonymous and lambda classes for future inlining:
//! - Detects classes with single constructor used only once
//! - Marks classes with AnonymousClassAttr
//! - Handles anonymous dependency merging
//! - Supports Kotlin lambda inlining
//!
//! Based on JADX's ProcessAnonymous.java visitor.

use std::collections::HashSet;
use crate::usage_info::{MethodRef, UsageInfo};

/// Information about an anonymous class
#[derive(Debug, Clone)]
pub struct AnonymousClassInfo {
    /// The class index of the anonymous class
    pub class_idx: u32,
    /// The outer class that contains this anonymous class
    pub outer_class_idx: u32,
    /// The base type (interface or superclass) being extended/implemented
    pub base_type_idx: u32,
    /// How this anonymous class is inlined
    pub inline_type: InlineType,
    /// The constructor method index
    pub constructor_idx: u32,
}

/// How an anonymous class is inlined
#[derive(Debug, Clone, Copy, PartialEq, Eq)]
pub enum InlineType {
    /// Inlined at constructor call site
    Constructor,
    /// Inlined as instance field (static INSTANCE pattern)
    InstanceField,
}

/// Result of processing anonymous classes
#[derive(Debug, Default)]
pub struct ProcessAnonymousResult {
    /// Classes marked as anonymous
    pub anonymous_classes: Vec<AnonymousClassInfo>,
    /// Classes that couldn't be marked (with reason)
    pub skipped_classes: Vec<(u32, String)>,
    /// Dependencies that were updated
    pub updated_dependencies: Vec<(u32, u32)>,
}

impl ProcessAnonymousResult {
    /// Check if a class was marked as anonymous
    pub fn is_anonymous(&self, class_idx: u32) -> bool {
        self.anonymous_classes.iter().any(|a| a.class_idx == class_idx)
    }

    /// Get anonymous info for a class
    pub fn get_anonymous_info(&self, class_idx: u32) -> Option<&AnonymousClassInfo> {
        self.anonymous_classes.iter().find(|a| a.class_idx == class_idx)
    }
}

/// Class metadata for anonymous detection
pub struct ClassInfo {
    /// Class index
    pub class_idx: u32,
    /// Short name (e.g., "Foo$1")
    pub short_name: String,
    /// Whether class is synthetic
    pub is_synthetic: bool,
    /// Superclass type index (None for Object)
    pub super_class: Option<u32>,
    /// Interface type indices
    pub interfaces: Vec<u32>,
    /// Constructor method indices
    pub constructors: Vec<u32>,
    /// All method indices
    pub methods: Vec<u32>,
    /// All field indices
    pub fields: Vec<u32>,
}

/// Process anonymous classes in a DEX file
///
/// # Arguments
/// * `classes` - List of class info
/// * `usage` - Usage information for the DEX file
///
/// # Returns
/// * `ProcessAnonymousResult` with detected anonymous classes
pub fn process_anonymous(
    classes: &[ClassInfo],
    usage: &UsageInfo,
) -> ProcessAnonymousResult {
    let mut result = ProcessAnonymousResult::default();

    for class_info in classes {
        if let Some(anonymous) = try_mark_anonymous(class_info, usage, &result) {
            result.anonymous_classes.push(anonymous);
        }
    }

    // Merge anonymous dependencies
    merge_anonymous_deps(&mut result, usage);

    result
}

/// Try to mark a class as anonymous
fn try_mark_anonymous(
    class_info: &ClassInfo,
    usage: &UsageInfo,
    _current_result: &ProcessAnonymousResult,
) -> Option<AnonymousClassInfo> {
    // Check if class can be anonymous
    if !can_be_anonymous(class_info, usage) {
        return None;
    }

    // Must have exactly one constructor
    if class_info.constructors.len() != 1 {
        return None;
    }

    let constructor_idx = class_info.constructors[0];
    let constructor_ref = MethodRef::new(class_info.class_idx, constructor_idx);

    // Check constructor usage
    let inline_type = check_usage(class_info, constructor_ref, usage)?;

    // Get base type (interface or superclass)
    let base_type_idx = get_base_type(class_info)?;

    // Find the outer class
    let outer_class_idx = find_outer_class(class_info, constructor_ref, inline_type, usage)?;

    Some(AnonymousClassInfo {
        class_idx: class_info.class_idx,
        outer_class_idx,
        base_type_idx,
        inline_type,
        constructor_idx,
    })
}

/// Check if a class can be anonymous
fn can_be_anonymous(class_info: &ClassInfo, usage: &UsageInfo) -> bool {
    // Synthetic classes are candidates
    if class_info.is_synthetic {
        return true;
    }

    // Classes with $ in name or starting with digit are candidates
    if class_info.short_name.contains('$') ||
       class_info.short_name.chars().next().map(|c| c.is_ascii_digit()).unwrap_or(false) {
        return true;
    }

    // Single-use classes in enum class init
    if usage.is_single_use_class(class_info.class_idx) {
        let methods = usage.get_class_use_in_methods(class_info.class_idx);
        if methods.len() == 1 {
            // TODO: Check if use is in enum class init (<clinit>)
            return true;
        }
    }

    false
}

/// Check constructor usage to determine inline type
fn check_usage(
    class_info: &ClassInfo,
    constructor_ref: MethodRef,
    usage: &UsageInfo,
) -> Option<InlineType> {
    let callers = usage.get_method_usage(constructor_ref);

    if callers.len() != 1 {
        // Check for common field init pattern (constructor called in multiple constructors of same class)
        if !check_for_common_field_init(&callers, class_info.class_idx) {
            return None;
        }
    }

    // Get the single caller
    let caller = callers.first()?;

    // Self-usage check
    if caller.class_idx == class_info.class_idx {
        // Check for instance field pattern
        if check_for_instance_field_usage(class_info, constructor_ref, usage) {
            return Some(InlineType::InstanceField);
        }
        // Exclude self-usage
        return None;
    }

    // Check if methods/fields are used outside
    if !check_methods_usage(class_info, constructor_ref, *caller, usage) {
        return None;
    }

    for field_idx in &class_info.fields {
        let field_ref = crate::usage_info::FieldRef::new(class_info.class_idx, *field_idx);
        for use_method in usage.get_field_usage(field_ref) {
            if bad_method_usage(class_info.class_idx, use_method) {
                return None;
            }
        }
    }

    Some(InlineType::Constructor)
}

/// Check if all callers are constructors of the same class
fn check_for_common_field_init(callers: &[MethodRef], class_idx: u32) -> bool {
    if callers.is_empty() {
        return false;
    }

    let first_class = callers[0].class_idx;

    // All callers must be in the same class (not self)
    // and ideally all be constructors (we'd need method info to check that)
    callers.iter().all(|caller| {
        caller.class_idx == first_class && caller.class_idx != class_idx
    })
}

/// Check for instance field usage pattern (INSTANCE field)
fn check_for_instance_field_usage(
    _class_info: &ClassInfo,
    _constructor_ref: MethodRef,
    _usage: &UsageInfo,
) -> bool {
    // TODO: Full implementation would check:
    // 1. Constructor is called only in <clinit>
    // 2. There's a public static final field of the class type
    // 3. Field is used for all external access
    false
}

/// Check methods usage
fn check_methods_usage(
    class_info: &ClassInfo,
    constructor_ref: MethodRef,
    caller: MethodRef,
    usage: &UsageInfo,
) -> bool {
    for method_idx in &class_info.methods {
        let method_ref = MethodRef::new(class_info.class_idx, *method_idx);
        if method_ref == constructor_ref {
            continue;
        }

        for use_method in usage.get_method_usage(method_ref) {
            if use_method == caller {
                continue;
            }
            if bad_method_usage(class_info.class_idx, use_method) {
                return false;
            }
        }
    }
    true
}

/// Check if method usage is "bad" (prevents anonymous marking)
fn bad_method_usage(class_idx: u32, use_method: MethodRef) -> bool {
    // Usage from same class is OK
    if use_method.class_idx == class_idx {
        return false;
    }

    // TODO: Check for synthetic usage in inner class (would be OK)
    // For now, any external usage is bad
    true
}

/// Get the base type for an anonymous class
fn get_base_type(class_info: &ClassInfo) -> Option<u32> {
    let interfaces_count = class_info.interfaces.len();

    if interfaces_count > 1 {
        // Can't implement multiple interfaces in anonymous class
        return None;
    }

    if class_info.super_class.is_none() || class_info.super_class == Some(0) {
        // Superclass is Object
        if interfaces_count == 1 {
            return Some(class_info.interfaces[0]);
        }
        // Object with no interfaces - still valid (new Object() { ... })
        return Some(0); // Object
    }

    let super_class = class_info.super_class?;

    if interfaces_count == 0 {
        return Some(super_class);
    }

    // Has both superclass and interface - check if superclass implements interface
    // TODO: Check class hierarchy
    // For now, prefer superclass
    Some(super_class)
}

/// Find the outer class for an anonymous class
fn find_outer_class(
    _class_info: &ClassInfo,
    constructor_ref: MethodRef,
    inline_type: InlineType,
    usage: &UsageInfo,
) -> Option<u32> {
    match inline_type {
        InlineType::InstanceField => {
            // TODO: Get outer class from use site
            None
        }
        InlineType::Constructor => {
            // Outer class is the class containing the constructor call
            usage.get_single_caller(constructor_ref).map(|c| c.class_idx)
        }
    }
}

/// Merge anonymous dependencies
fn merge_anonymous_deps(
    result: &mut ProcessAnonymousResult,
    _usage: &UsageInfo,
) {
    // Build inline map: anonymous -> outer
    let mut inline_map = std::collections::HashMap::new();
    for anon in &result.anonymous_classes {
        inline_map.insert(anon.class_idx, anon.outer_class_idx);
    }

    // Build use map: outer -> [anonymous]
    let mut use_map: std::collections::HashMap<u32, Vec<u32>> = std::collections::HashMap::new();
    for anon in &result.anonymous_classes {
        use_map.entry(anon.outer_class_idx)
            .or_default()
            .push(anon.class_idx);
    }

    // Collect leaf nodes first (to avoid borrow conflict)
    let leaf_classes: Vec<u32> = result.anonymous_classes.iter()
        .filter(|anon| use_map.get(&anon.class_idx).map(|v| v.is_empty()).unwrap_or(true))
        .map(|anon| anon.class_idx)
        .collect();

    // Process leaf nodes up to root
    let mut processed = HashSet::new();
    for leaf_class in leaf_classes {
        update_deps(leaf_class, &inline_map, &mut processed, result);
    }
}

/// Update dependencies for an anonymous class chain
fn update_deps(
    leaf_class: u32,
    inline_map: &std::collections::HashMap<u32, u32>,
    processed: &mut HashSet<u32>,
    result: &mut ProcessAnonymousResult,
) {
    let mut current = leaf_class;
    let mut chain = Vec::new();

    loop {
        if !processed.insert(current) {
            // Loop detected - clear marks
            // TODO: Add warning
            return;
        }
        chain.push(current);

        if let Some(&next) = inline_map.get(&current) {
            current = next;
        } else {
            break;
        }
    }

    // Record updated dependencies
    if chain.len() > 2 {
        let top = current;
        for &dep in &chain {
            if dep != top {
                result.updated_dependencies.push((top, dep));
            }
        }
    }
}

#[cfg(test)]
mod tests {
    use super::*;

    fn make_class(class_idx: u32, name: &str, constructors: Vec<u32>) -> ClassInfo {
        ClassInfo {
            class_idx,
            short_name: name.to_string(),
            is_synthetic: false,
            super_class: Some(0),
            interfaces: vec![],
            constructors,
            methods: constructors.clone(),
            fields: vec![],
        }
    }

    #[test]
    fn test_can_be_anonymous_synthetic() {
        let usage = UsageInfo::new();
        let mut class_info = make_class(1, "Test", vec![10]);
        class_info.is_synthetic = true;

        assert!(can_be_anonymous(&class_info, &usage));
    }

    #[test]
    fn test_can_be_anonymous_dollar_name() {
        let usage = UsageInfo::new();
        let class_info = make_class(1, "Outer$1", vec![10]);

        assert!(can_be_anonymous(&class_info, &usage));
    }

    #[test]
    fn test_can_be_anonymous_digit_name() {
        let usage = UsageInfo::new();
        let class_info = make_class(1, "1", vec![10]);

        assert!(can_be_anonymous(&class_info, &usage));
    }

    #[test]
    fn test_regular_class_not_anonymous() {
        let usage = UsageInfo::new();
        let class_info = make_class(1, "RegularClass", vec![10]);

        assert!(!can_be_anonymous(&class_info, &usage));
    }
}
