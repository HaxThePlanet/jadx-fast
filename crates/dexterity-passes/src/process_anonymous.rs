//! Anonymous class processing pass
//!
//! This pass marks anonymous and lambda classes for future inlining:
//! - Detects classes with single constructor used only once
//! - Marks classes with AnonymousClassAttr
//! - Handles anonymous dependency merging
//! - Supports Kotlin lambda inlining
//!
//! Based on JADX's ProcessAnonymous.java visitor.
//! JADX Reference: jadx-core/src/main/java/jadx/core/dex/visitors/ProcessAnonymous.java

use crate::usage_info::{MethodRef, UsageInfo};
use std::collections::HashSet;

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

/// Method information for anonymous class detection
/// JADX Reference: ProcessAnonymous.java - method access checks
#[derive(Debug, Clone)]
pub struct MethodInfo {
    /// Method index
    pub method_idx: u32,
    /// Whether this is a <clinit> method
    pub is_class_init: bool,
    /// Whether this is a constructor
    pub is_constructor: bool,
    /// Whether the method is synthetic
    pub is_synthetic: bool,
}

/// Field information for instance field detection
/// JADX Reference: ProcessAnonymous.checkForInstanceFieldUsage()
#[derive(Debug, Clone)]
pub struct FieldInfo {
    /// Field index
    pub field_idx: u32,
    /// Field type index (for matching class type)
    pub field_type_idx: u32,
    /// Whether the field is public
    pub is_public: bool,
    /// Whether the field is static
    pub is_static: bool,
    /// Whether the field is final
    pub is_final: bool,
    /// Whether the field is synthetic
    pub is_synthetic: bool,
}

impl FieldInfo {
    /// Check if field matches INSTANCE pattern (public static final)
    /// JADX Reference: ProcessAnonymous.checkForInstanceFieldUsage() lines 286-288
    pub fn is_instance_field_candidate(&self) -> bool {
        self.is_public && self.is_static && self.is_final
    }
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
    /// Warnings generated during processing
    /// JADX Reference: ProcessAnonymous.updateDeps() line 178
    pub warnings: Vec<AnonymousWarning>,
}

/// Warning generated during anonymous class processing
#[derive(Debug, Clone)]
pub struct AnonymousWarning {
    /// Class that triggered the warning
    pub class_idx: u32,
    /// Warning message
    pub message: String,
    /// Classes in the loop path (for loop warnings)
    pub loop_path: Vec<u32>,
}

impl ProcessAnonymousResult {
    /// Check if a class was marked as anonymous
    pub fn is_anonymous(&self, class_idx: u32) -> bool {
        self.anonymous_classes
            .iter()
            .any(|a| a.class_idx == class_idx)
    }

    /// Get anonymous info for a class
    pub fn get_anonymous_info(&self, class_idx: u32) -> Option<&AnonymousClassInfo> {
        self.anonymous_classes
            .iter()
            .find(|a| a.class_idx == class_idx)
    }
}

/// Class metadata for anonymous detection
/// JADX Reference: ProcessAnonymous.java - ClassNode fields used
pub struct ClassInfo {
    /// Class index
    pub class_idx: u32,
    /// Short name (e.g., "Foo$1")
    pub short_name: String,
    /// Whether class is synthetic
    pub is_synthetic: bool,
    /// Whether class is an enum
    /// JADX Reference: canBeAnonymous() line 214
    pub is_enum: bool,
    /// Superclass type index (None for Object)
    pub super_class: Option<u32>,
    /// Parent class index for inner classes (None for top-level)
    /// JADX Reference: badMethodUsage() line 323
    pub parent_class_idx: Option<u32>,
    /// Interface type indices
    pub interfaces: Vec<u32>,
    /// Constructor method indices
    pub constructors: Vec<u32>,
    /// All method indices
    pub methods: Vec<u32>,
    /// All field indices
    pub fields: Vec<u32>,
    /// Detailed method info (optional, for full checks)
    pub method_infos: Vec<MethodInfo>,
    /// Detailed field info (optional, for INSTANCE field detection)
    pub field_infos: Vec<FieldInfo>,
}

/// Context for anonymous class processing with full DEX information
/// JADX Reference: ProcessAnonymous.java - root node context
pub struct ProcessAnonymousContext<'a> {
    /// Class lookup: class_idx -> ClassInfo
    pub get_class: &'a dyn Fn(u32) -> Option<&'a ClassInfo>,
    /// Method info lookup: (class_idx, method_idx) -> MethodInfo
    pub get_method_info: Option<&'a dyn Fn(u32, u32) -> Option<MethodInfo>>,
    /// Check if superclass implements interface
    /// JADX Reference: getBaseType() line 361
    pub is_implements: Option<&'a dyn Fn(u32, u32) -> bool>,
    /// Whether to allow inline Kotlin lambda (extends kotlin.jvm.internal.Lambda)
    /// JADX Reference: getBaseType() line 364
    pub allow_inline_kotlin_lambda: bool,
    /// Kotlin Lambda superclass type index (if known)
    pub kotlin_lambda_type_idx: Option<u32>,
}

/// Process anonymous classes in a DEX file
///
/// # Arguments
/// * `classes` - List of class info
/// * `usage` - Usage information for the DEX file
///
/// # Returns
/// * `ProcessAnonymousResult` with detected anonymous classes
pub fn process_anonymous(classes: &[ClassInfo], usage: &UsageInfo) -> ProcessAnonymousResult {
    let mut result = ProcessAnonymousResult::default();

    for class_info in classes {
        if let Some(anonymous) = try_mark_anonymous(class_info, usage, &result, None) {
            result.anonymous_classes.push(anonymous);
        }
    }

    // Merge anonymous dependencies
    merge_anonymous_deps(&mut result);

    result
}

/// Process anonymous classes with full context for JADX parity
/// JADX Reference: ProcessAnonymous.init()
pub fn process_anonymous_with_context<'a>(
    classes: &'a [ClassInfo],
    usage: &UsageInfo,
    context: &ProcessAnonymousContext<'a>,
) -> ProcessAnonymousResult {
    let mut result = ProcessAnonymousResult::default();

    for class_info in classes {
        if let Some(anonymous) = try_mark_anonymous(class_info, usage, &result, Some(context)) {
            result.anonymous_classes.push(anonymous);
        }
    }

    // Merge anonymous dependencies
    merge_anonymous_deps(&mut result);

    result
}

/// Try to mark a class as anonymous
/// JADX Reference: ProcessAnonymous.markAnonymousClass()
fn try_mark_anonymous(
    class_info: &ClassInfo,
    usage: &UsageInfo,
    _current_result: &ProcessAnonymousResult,
    context: Option<&ProcessAnonymousContext>,
) -> Option<AnonymousClassInfo> {
    // Check if class can be anonymous
    if !can_be_anonymous(class_info, usage, context) {
        return None;
    }

    // Must have exactly one constructor
    // JADX Reference: line 76 - ListUtils.filterOnlyOne(cls.getMethods(), MethodNode::isConstructor)
    if class_info.constructors.len() != 1 {
        return None;
    }

    let constructor_idx = class_info.constructors[0];
    let constructor_ref = MethodRef::new(class_info.class_idx, constructor_idx);

    // Check constructor usage
    let inline_type = check_usage(class_info, constructor_ref, usage, context)?;

    // Get base type (interface or superclass)
    let base_type_idx = get_base_type(class_info, context)?;

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
/// JADX Reference: ProcessAnonymous.canBeAnonymous() lines 203-216
fn can_be_anonymous(
    class_info: &ClassInfo,
    usage: &UsageInfo,
    context: Option<&ProcessAnonymousContext>,
) -> bool {
    // Synthetic classes are candidates
    // JADX Reference: line 204
    if class_info.is_synthetic {
        return true;
    }

    // Classes with $ in name or starting with digit are candidates
    // JADX Reference: line 208
    if class_info.short_name.contains('$')
        || class_info
            .short_name
            .chars()
            .next()
            .map(|c| c.is_ascii_digit())
            .unwrap_or(false)
    {
        return true;
    }

    // Single-use classes in enum class init
    // JADX Reference: lines 211-215
    if usage.is_single_use_class(class_info.class_idx) {
        let methods = usage.get_class_use_in_methods(class_info.class_idx);
        if methods.len() == 1 {
            // Check if use is in enum class init (<clinit>)
            // JADX Reference: line 214 - useMth.getMethodInfo().isClassInit() && useMth.getParentClass().isEnum()
            let use_method = &methods[0];

            // Try to get method info to check if it's <clinit>
            if let Some(ctx) = context {
                if let Some(ref get_method_info) = ctx.get_method_info {
                    if let Some(method_info) =
                        get_method_info(use_method.class_idx, use_method.method_idx)
                    {
                        if method_info.is_class_init {
                            // Check if the class containing the method is an enum
                            if let Some(use_class) = (ctx.get_class)(use_method.class_idx) {
                                if use_class.is_enum {
                                    return true;
                                }
                            }
                        }
                    }
                }
            }

            // Also check method_infos in the class using us (if available)
            // This is a fallback when context is not provided but class has method_infos
            if let Some(ctx) = context {
                if let Some(use_class) = (ctx.get_class)(use_method.class_idx) {
                    for method_info in &use_class.method_infos {
                        if method_info.method_idx == use_method.method_idx
                            && method_info.is_class_init
                        {
                            if use_class.is_enum {
                                return true;
                            }
                        }
                    }
                }
            }
        }
    }

    false
}

/// Check constructor usage to determine inline type
/// JADX Reference: ProcessAnonymous.checkUsage() lines 227-258
fn check_usage(
    class_info: &ClassInfo,
    constructor_ref: MethodRef,
    usage: &UsageInfo,
    context: Option<&ProcessAnonymousContext>,
) -> Option<InlineType> {
    let callers = usage.get_method_usage(constructor_ref);

    if callers.len() != 1 {
        // Check for common field init pattern (constructor called in multiple constructors of same class)
        // JADX Reference: line 230 - checkForCommonFieldInit(ctr)
        if !check_for_common_field_init(&callers, class_info.class_idx, context) {
            return None;
        }
    }

    // Get the single caller
    let caller = callers.first()?;

    // Self-usage check
    // JADX Reference: lines 236-246
    if caller.class_idx == class_info.class_idx {
        // Check for instance field pattern
        if check_for_instance_field_usage(class_info, constructor_ref, usage, context) {
            return Some(InlineType::InstanceField);
        }
        // Exclude self-usage
        return None;
    }

    // Check if top parent class equals this class (usage inside inner classes)
    // JADX Reference: lines 243-246
    if let Some(ctx) = context {
        if let Some(caller_class) = (ctx.get_class)(caller.class_idx) {
            // Walk up to find top parent class
            let mut top_parent = caller.class_idx;
            let mut current = caller_class;
            while let Some(parent_idx) = current.parent_class_idx {
                top_parent = parent_idx;
                if let Some(parent_class) = (ctx.get_class)(parent_idx) {
                    current = parent_class;
                } else {
                    break;
                }
            }
            if top_parent == class_info.class_idx {
                // Usage inside inner classes - exclude
                return None;
            }
        }
    }

    // Check if methods/fields are used outside
    // JADX Reference: lines 247-256
    if !check_methods_usage(class_info, constructor_ref, *caller, usage, context) {
        return None;
    }

    for field_idx in &class_info.fields {
        let field_ref = crate::usage_info::FieldRef::new(class_info.class_idx, *field_idx);
        // Get field info for synthetic check
        let field_info = class_info
            .field_infos
            .iter()
            .find(|f| f.field_idx == *field_idx);
        for use_method in usage.get_field_usage(field_ref) {
            if bad_method_usage(class_info, use_method, field_info, context) {
                return None;
            }
        }
    }

    Some(InlineType::Constructor)
}

/// Check if all callers are constructors of the same class
/// JADX Reference: ProcessAnonymous.checkForCommonFieldInit() lines 334-341
fn check_for_common_field_init(
    callers: &[MethodRef],
    class_idx: u32,
    context: Option<&ProcessAnonymousContext>,
) -> bool {
    if callers.is_empty() {
        return false;
    }

    let first_class = callers[0].class_idx;

    // All callers must be in the same class (not self) and all be constructors
    // JADX Reference: line 340 - m.isConstructor() && m.getParentClass().equals(firstUseCls)
    callers.iter().all(|caller| {
        if caller.class_idx != first_class || caller.class_idx == class_idx {
            return false;
        }
        // Check if caller is a constructor (if we have method info)
        if let Some(ctx) = context {
            if let Some(ref get_method_info) = ctx.get_method_info {
                if let Some(method_info) = get_method_info(caller.class_idx, caller.method_idx) {
                    return method_info.is_constructor;
                }
            }
            // Fallback: check class's method_infos
            if let Some(caller_class) = (ctx.get_class)(caller.class_idx) {
                for method_info in &caller_class.method_infos {
                    if method_info.method_idx == caller.method_idx {
                        return method_info.is_constructor;
                    }
                }
            }
        }
        // Without method info, assume true (legacy behavior)
        true
    })
}

/// Check for instance field usage pattern (INSTANCE field)
/// JADX Reference: ProcessAnonymous.checkForInstanceFieldUsage() lines 277-314
fn check_for_instance_field_usage(
    class_info: &ClassInfo,
    constructor_ref: MethodRef,
    usage: &UsageInfo,
    context: Option<&ProcessAnonymousContext>,
) -> bool {
    // Get the single caller of the constructor
    let callers = usage.get_method_usage(constructor_ref);
    if callers.len() != 1 {
        return false;
    }
    let ctr_use_method = &callers[0];

    // 1. Constructor must be called only in <clinit>
    // JADX Reference: line 279 - ctrUseMth.getMethodInfo().isClassInit()
    let is_clinit = if let Some(ctx) = context {
        if let Some(ref get_method_info) = ctx.get_method_info {
            if let Some(method_info) =
                get_method_info(ctr_use_method.class_idx, ctr_use_method.method_idx)
            {
                method_info.is_class_init
            } else {
                false
            }
        } else {
            // Check class's method_infos
            if let Some(caller_class) = (ctx.get_class)(ctr_use_method.class_idx) {
                caller_class
                    .method_infos
                    .iter()
                    .find(|m| m.method_idx == ctr_use_method.method_idx)
                    .map(|m| m.is_class_init)
                    .unwrap_or(false)
            } else {
                false
            }
        }
    } else {
        // Check using class_info's method_infos as fallback
        class_info
            .method_infos
            .iter()
            .find(|m| m.method_idx == ctr_use_method.method_idx)
            .map(|m| m.is_class_init)
            .unwrap_or(false)
    };

    if !is_clinit {
        return false;
    }

    // Check if class has outside usage (getUseInMth not empty)
    // JADX Reference: lines 282-285
    let class_use_methods = usage.get_class_use_in_methods(class_info.class_idx);
    if class_use_methods.is_empty() {
        // No outside usage, inline not needed
        return false;
    }

    // 2. Find public static final field of the class type
    // JADX Reference: lines 286-289
    let instance_field = class_info
        .field_infos
        .iter()
        .find(|f| f.is_instance_field_candidate() && f.field_type_idx == class_info.class_idx);

    let instance_field = match instance_field {
        Some(f) => f,
        None => return false,
    };

    // 3. Check field usage (must be used in exactly 2 places)
    // JADX Reference: lines 292-297
    let field_ref =
        crate::usage_info::FieldRef::new(class_info.class_idx, instance_field.field_idx);
    let field_use_methods = usage.get_field_usage(field_ref);

    if field_use_methods.len() != 2 {
        return false;
    }

    // Must contain the clinit method where it's initialized
    if !field_use_methods.iter().any(|m| m == ctr_use_method) {
        return false;
    }

    // Class must be used only with this field (field_use_methods contains all class use methods)
    for use_method in &class_use_methods {
        if !field_use_methods.contains(use_method) {
            return false;
        }
    }

    // 4. Check methods usage (same as constructor inline)
    // JADX Reference: lines 299-301
    if !check_methods_usage(class_info, constructor_ref, *ctr_use_method, usage, context) {
        return false;
    }

    // 5. Check other fields usage
    // JADX Reference: lines 302-311
    for field_info in &class_info.field_infos {
        if field_info.field_idx == instance_field.field_idx {
            continue;
        }
        let other_field_ref =
            crate::usage_info::FieldRef::new(class_info.class_idx, field_info.field_idx);
        for use_method in usage.get_field_usage(other_field_ref) {
            if bad_method_usage(class_info, use_method, Some(field_info), context) {
                return false;
            }
        }
    }

    // Mark field for inline (caller would need to set AFlag.INLINE_INSTANCE_FIELD)
    // JADX Reference: line 312 - instFld.add(AFlag.INLINE_INSTANCE_FIELD)
    true
}

/// Check methods usage
/// JADX Reference: ProcessAnonymous.checkMethodsUsage() lines 260-275
fn check_methods_usage(
    class_info: &ClassInfo,
    constructor_ref: MethodRef,
    caller: MethodRef,
    usage: &UsageInfo,
    context: Option<&ProcessAnonymousContext>,
) -> bool {
    for method_idx in &class_info.methods {
        let method_ref = MethodRef::new(class_info.class_idx, *method_idx);
        if method_ref == constructor_ref {
            continue;
        }

        // Get method info for access flags check
        let method_info = class_info
            .method_infos
            .iter()
            .find(|m| m.method_idx == *method_idx);

        for use_method in usage.get_method_usage(method_ref) {
            if use_method == caller {
                continue;
            }
            if bad_method_usage_for_method(class_info, use_method, method_info, context) {
                return false;
            }
        }
    }
    true
}

/// Check if method usage is "bad" for a field (prevents anonymous marking)
/// JADX Reference: ProcessAnonymous.badMethodUsage() lines 316-326
fn bad_method_usage(
    class_info: &ClassInfo,
    use_method: MethodRef,
    field_info: Option<&FieldInfo>,
    context: Option<&ProcessAnonymousContext>,
) -> bool {
    // Usage from same class is OK
    // JADX Reference: lines 317-319
    if use_method.class_idx == class_info.class_idx {
        return false;
    }

    // Check for synthetic usage in inner class (would be OK)
    // JADX Reference: lines 321-324
    // if (accessFlags.isSynthetic()) {
    //     return !useCls.getParentClass().equals(cls);
    // }
    if let Some(field) = field_info {
        if field.is_synthetic {
            // Allow synthetic usage in inner class
            if let Some(ctx) = context {
                if let Some(use_class) = (ctx.get_class)(use_method.class_idx) {
                    // Check if the use class's parent is this class
                    if use_class.parent_class_idx == Some(class_info.class_idx) {
                        return false; // Not bad - synthetic usage in inner class is OK
                    }
                }
            }
        }
    }

    // Any other external usage is bad
    true
}

/// Check if method usage is "bad" for a method (prevents anonymous marking)
/// Same logic as bad_method_usage but uses MethodInfo
fn bad_method_usage_for_method(
    class_info: &ClassInfo,
    use_method: MethodRef,
    method_info: Option<&MethodInfo>,
    context: Option<&ProcessAnonymousContext>,
) -> bool {
    // Usage from same class is OK
    if use_method.class_idx == class_info.class_idx {
        return false;
    }

    // Check for synthetic usage in inner class (would be OK)
    if let Some(method) = method_info {
        if method.is_synthetic {
            // Allow synthetic usage in inner class
            if let Some(ctx) = context {
                if let Some(use_class) = (ctx.get_class)(use_method.class_idx) {
                    // Check if the use class's parent is this class
                    if use_class.parent_class_idx == Some(class_info.class_idx) {
                        return false; // Not bad - synthetic usage in inner class is OK
                    }
                }
            }
        }
    }

    // Any other external usage is bad
    true
}

/// Get the base type for an anonymous class
/// JADX Reference: ProcessAnonymous.getBaseType() lines 344-372
fn get_base_type(class_info: &ClassInfo, context: Option<&ProcessAnonymousContext>) -> Option<u32> {
    let interfaces_count = class_info.interfaces.len();

    // JADX Reference: lines 346-348
    if interfaces_count > 1 {
        // Can't implement multiple interfaces in anonymous class
        return None;
    }

    // JADX Reference: lines 349-355
    if class_info.super_class.is_none() || class_info.super_class == Some(0) {
        // Superclass is Object
        if interfaces_count == 1 {
            return Some(class_info.interfaces[0]);
        }
        // Object with no interfaces - still valid (new Object() { ... })
        return Some(0); // Object
    }

    let super_class = class_info.super_class?;

    // JADX Reference: lines 356-358
    if interfaces_count == 0 {
        return Some(super_class);
    }

    // Has both superclass and interface - check if superclass implements interface
    // JADX Reference: lines 359-371
    let interface_type = class_info.interfaces[0];

    // Check class hierarchy using context callback
    if let Some(ctx) = context {
        if let Some(ref is_implements) = ctx.is_implements {
            if is_implements(super_class, interface_type) {
                // Superclass already implements the interface (weird case)
                return Some(super_class);
            }
        }

        // Check for Kotlin lambda special case
        // JADX Reference: lines 364-369
        if ctx.allow_inline_kotlin_lambda {
            if let Some(kotlin_lambda_type) = ctx.kotlin_lambda_type_idx {
                if super_class == kotlin_lambda_type {
                    // Inline Kotlin lambda with interface type
                    return Some(interface_type);
                }
            }
        }
    }

    // Without hierarchy check, can't determine - return None for safety
    // JADX returns null in this case too (line 371)
    None
}

/// Find the outer class for an anonymous class
/// JADX Reference: ProcessAnonymous.markAnonymousClass() lines 88-93
fn find_outer_class(
    class_info: &ClassInfo,
    constructor_ref: MethodRef,
    inline_type: InlineType,
    usage: &UsageInfo,
) -> Option<u32> {
    match inline_type {
        InlineType::InstanceField => {
            // Get outer class from use site
            // JADX Reference: line 90 - cls.getUseInMth().get(0).getParentClass()
            let use_methods = usage.get_class_use_in_methods(class_info.class_idx);
            use_methods.first().map(|m| m.class_idx)
        }
        InlineType::Constructor => {
            // Outer class is the class containing the constructor call
            // JADX Reference: line 92 - anonymousConstructor.getUseIn().get(0).getParentClass()
            usage
                .get_single_caller(constructor_ref)
                .map(|c| c.class_idx)
        }
    }
}

/// Merge anonymous dependencies
/// JADX Reference: ProcessAnonymous.mergeAnonymousDeps() lines 129-171
fn merge_anonymous_deps(result: &mut ProcessAnonymousResult) {
    // Build inline map: anonymous -> outer
    // JADX Reference: lines 133-148
    let mut inline_map = std::collections::HashMap::new();
    for anon in &result.anonymous_classes {
        inline_map.insert(anon.class_idx, anon.outer_class_idx);
    }

    // Build use map: outer -> [anonymous]
    let mut use_map: std::collections::HashMap<u32, Vec<u32>> = std::collections::HashMap::new();
    for anon in &result.anonymous_classes {
        use_map
            .entry(anon.outer_class_idx)
            .or_default()
            .push(anon.class_idx);
    }

    // Collect leaf nodes first (to avoid borrow conflict)
    // JADX Reference: lines 153-159
    let leaf_classes: Vec<u32> = result
        .anonymous_classes
        .iter()
        .filter(|anon| {
            use_map
                .get(&anon.class_idx)
                .map(|v| v.is_empty())
                .unwrap_or(true)
        })
        .map(|anon| anon.class_idx)
        .collect();

    // Process leaf nodes up to root
    let mut processed = HashSet::new();
    let mut warnings = Vec::new();
    for leaf_class in leaf_classes {
        update_deps(
            leaf_class,
            &inline_map,
            &mut processed,
            result,
            &mut warnings,
        );
    }

    // Add collected warnings to result
    result.warnings.extend(warnings);
}

/// Update dependencies for an anonymous class chain
/// JADX Reference: ProcessAnonymous.updateDeps() lines 173-201
fn update_deps(
    leaf_class: u32,
    inline_map: &std::collections::HashMap<u32, u32>,
    processed: &mut HashSet<u32>,
    result: &mut ProcessAnonymousResult,
    warnings: &mut Vec<AnonymousWarning>,
) {
    let mut current = leaf_class;
    let mut chain = Vec::new();

    loop {
        if !processed.insert(current) {
            // Loop detected - add warning
            // JADX Reference: line 178 - current.addWarnComment("Loop in anonymous inline: " + current + ", path: " + added)
            warnings.push(AnonymousWarning {
                class_idx: current,
                message: format!("Loop in anonymous inline: class {}", current),
                loop_path: chain.clone(),
            });
            // JADX also clears marks: added.forEach(ProcessAnonymous::undoAnonymousMark)
            // We don't modify the result here - caller can handle based on warnings
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
    // JADX Reference: lines 189-200
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
            is_enum: false,
            super_class: Some(0),
            parent_class_idx: None,
            interfaces: vec![],
            constructors: constructors.clone(),
            methods: constructors,
            fields: vec![],
            method_infos: vec![],
            field_infos: vec![],
        }
    }

    #[test]
    fn test_can_be_anonymous_synthetic() {
        let usage = UsageInfo::new();
        let mut class_info = make_class(1, "Test", vec![10]);
        class_info.is_synthetic = true;

        assert!(can_be_anonymous(&class_info, &usage, None));
    }

    #[test]
    fn test_can_be_anonymous_dollar_name() {
        let usage = UsageInfo::new();
        let class_info = make_class(1, "Outer$1", vec![10]);

        assert!(can_be_anonymous(&class_info, &usage, None));
    }

    #[test]
    fn test_can_be_anonymous_digit_name() {
        let usage = UsageInfo::new();
        let class_info = make_class(1, "1", vec![10]);

        assert!(can_be_anonymous(&class_info, &usage, None));
    }

    #[test]
    fn test_regular_class_not_anonymous() {
        let usage = UsageInfo::new();
        let class_info = make_class(1, "RegularClass", vec![10]);

        assert!(!can_be_anonymous(&class_info, &usage, None));
    }

    #[test]
    fn test_anonymous_warning_structure() {
        let warning = AnonymousWarning {
            class_idx: 1,
            message: "Loop detected".to_string(),
            loop_path: vec![1, 2, 3],
        };
        assert_eq!(warning.class_idx, 1);
        assert_eq!(warning.loop_path.len(), 3);
    }
}
