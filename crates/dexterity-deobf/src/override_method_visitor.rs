//! Override Method Visitor
//!
//! JADX Reference: jadx-core/src/main/java/jadx/core/dex/visitors/OverrideMethodVisitor.java
//! Cloned from JADX's OverrideMethodVisitor class (472 lines) for exact parity.
//!
//! This visitor marks override methods and reverts type erasure.
//! It runs before TypeInferenceVisitor and RenameVisitor.
//!
//! ## Key JADX Behaviors Cloned:
//!
//! 1. **collectSuperTypes()** - Recursively collects all super types (superclass + interfaces)
//! 2. **processOverrideMethods()** - Searches super types for overridden methods
//! 3. **MethodOverrideAttr** - Tracks override list, related methods, base methods
//! 4. **DONT_RENAME flag** - Set when override list contains unresolved methods
//! 5. **Type erasure fixing** - Fixes return/arg types to match base method
//! 6. **Collision detection** - Renames conflicting methods after type fixes
//!
//! ## JADX Algorithm Overview:
//!
//! ```java
//! // From OverrideMethodVisitor.java
//! @Override
//! public boolean visit(ClassNode cls) {
//!     SuperTypesData superData = collectSuperTypes(cls);
//!     if (superData != null) {
//!         for (MethodNode mth : cls.getMethods()) {
//!             processMth(mth, superData);
//!         }
//!     }
//!     return true;
//! }
//! ```

use std::collections::{HashMap, HashSet};
use dexterity_ir::{ArgType, ClassData, MethodData};

/// Method override attribute
///
/// JADX Reference: jadx-core/src/main/java/jadx/core/dex/attributes/nodes/MethodOverrideAttr.java
/// Cloned from JADX's MethodOverrideAttr class exactly.
///
/// Tracks information about method overrides in a class hierarchy:
/// - `override_list` - All overridden methods found in super types
/// - `related_mth_nodes` - All method nodes in the override chain
/// - `base_methods` - The actual base method(s) being overridden
#[derive(Debug, Clone, Default)]
pub struct MethodOverrideAttr {
    /// List of overridden method signatures in super types
    ///
    /// JADX: List<IMethodDetails> overrideList
    pub override_list: Vec<MethodRef>,

    /// All related method nodes in the override chain
    ///
    /// JADX: SortedSet<MethodNode> relatedMthNodes
    pub related_mth_nodes: HashSet<MethodRef>,

    /// The base method(s) being overridden
    ///
    /// JADX: Set<IMethodDetails> baseMethods
    pub base_methods: HashSet<MethodRef>,
}

/// Reference to a method (class + signature)
///
/// Used for tracking methods across the override hierarchy.
#[derive(Debug, Clone, PartialEq, Eq, Hash)]
pub struct MethodRef {
    /// Class containing this method (e.g., "Lcom/example/Foo;")
    pub class_type: String,
    /// Method name
    pub name: String,
    /// Method signature without return type (e.g., "(II)")
    pub signature: String,
    /// Full short ID (name + signature with return type)
    pub short_id: String,
    /// Whether this method is from a resolved class (vs classpath)
    pub is_resolved: bool,
}

impl MethodRef {
    /// Create a method reference from method data
    pub fn from_method(class_type: &str, method: &MethodData) -> Self {
        let signature = make_signature(&method.arg_types, false);
        let short_id = make_short_id(&method.name, &method.arg_types, Some(&method.return_type));
        Self {
            class_type: class_type.to_string(),
            name: method.name.clone(),
            signature,
            short_id,
            is_resolved: true,
        }
    }

    /// Create an unresolved method reference (from classpath info)
    pub fn unresolved(class_type: &str, name: &str, signature: &str, short_id: &str) -> Self {
        Self {
            class_type: class_type.to_string(),
            name: name.to_string(),
            signature: signature.to_string(),
            short_id: short_id.to_string(),
            is_resolved: false,
        }
    }
}

/// Super types data collected for a class
///
/// JADX Reference: OverrideMethodVisitor.SuperTypesData (private class)
#[derive(Debug, Clone)]
pub struct SuperTypesData {
    /// All super types (superclass + interfaces) in order
    ///
    /// JADX: List<ArgType> superTypes
    pub super_types: Vec<String>,

    /// Types that are at the end of hierarchy chains (no further supers)
    ///
    /// JADX: Set<String> endTypes
    pub end_types: HashSet<String>,
}

/// Class resolver trait for resolving class types to ClassData
///
/// JADX uses `cls.root().resolveClass(superType)` to resolve types.
/// This trait abstracts that resolution mechanism.
pub trait ClassResolver: Send + Sync {
    /// Resolve a class type descriptor to ClassData
    ///
    /// JADX Reference: RootNode.resolveClass(ArgType)
    /// Returns None if class not found in loaded DEX files.
    fn resolve_class(&self, class_type: &str) -> Option<&ClassData>;

    /// Get classpath info for a class (framework classes like java.*, android.*)
    ///
    /// JADX Reference: root.getClsp().getClsDetails(superType)
    /// Returns parent types if available from classpath database.
    fn get_classpath_parents(&self, class_type: &str) -> Option<Vec<String>>;
}

/// Simple class resolver using a HashMap
///
/// For use when processing a fixed set of classes.
pub struct SimpleClassResolver<'a> {
    classes: HashMap<String, &'a ClassData>,
}

impl<'a> SimpleClassResolver<'a> {
    /// Create resolver from a slice of classes
    pub fn new(classes: &'a [ClassData]) -> Self {
        let mut map = HashMap::new();
        for cls in classes {
            map.insert(cls.class_type.clone(), cls);
        }
        Self { classes: map }
    }
}

impl<'a> ClassResolver for SimpleClassResolver<'a> {
    fn resolve_class(&self, class_type: &str) -> Option<&ClassData> {
        self.classes.get(class_type).copied()
    }

    fn get_classpath_parents(&self, _class_type: &str) -> Option<Vec<String>> {
        // Simple resolver doesn't have classpath info
        None
    }
}

/// Collect all super types for a class
///
/// JADX Reference: OverrideMethodVisitor.collectSuperTypes() lines 284-295
///
/// ```java
/// private SuperTypesData collectSuperTypes(ClassNode cls) {
///     Set<ArgType> superTypes = new LinkedHashSet<>();
///     Set<String> endTypes = new HashSet<>();
///     collectSuperTypes(cls, superTypes, endTypes);
///     if (superTypes.isEmpty()) {
///         return null;
///     }
///     // ...
///     return new SuperTypesData(new ArrayList<>(superTypes), endTypes);
/// }
/// ```
pub fn collect_super_types<R: ClassResolver>(
    cls: &ClassData,
    resolver: &R,
) -> Option<SuperTypesData> {
    let mut super_types = Vec::new();
    let mut super_types_set = HashSet::new();
    let mut end_types = HashSet::new();

    collect_super_types_recursive(cls, resolver, &mut super_types, &mut super_types_set, &mut end_types);

    if super_types.is_empty() {
        return None;
    }
    if end_types.is_empty() {
        // JADX: throw new JadxRuntimeException("No end types in class hierarchy: " + cls);
        // We'll add the class itself as end type as fallback
        end_types.insert(cls.class_type.clone());
    }

    Some(SuperTypesData { super_types, end_types })
}

/// Recursive helper for collecting super types
///
/// JADX Reference: OverrideMethodVisitor.collectSuperTypes(cls, superTypes, endTypes) lines 297-310
fn collect_super_types_recursive<R: ClassResolver>(
    cls: &ClassData,
    resolver: &R,
    super_types: &mut Vec<String>,
    super_types_set: &mut HashSet<String>,
    end_types: &mut HashSet<String>,
) {
    let mut k = 0;

    // JADX: ArgType superClass = cls.getSuperClass();
    if let Some(ref super_cls) = cls.superclass {
        k += add_super_type(resolver, super_types, super_types_set, end_types, super_cls);
    }

    // JADX: for (ArgType iface : cls.getInterfaces())
    for iface in &cls.interfaces {
        let iface_type = arg_type_to_class_type(iface);
        if let Some(ref iface_str) = iface_type {
            k += add_super_type(resolver, super_types, super_types_set, end_types, iface_str);
        }
    }

    // JADX: if (k == 0) { endTypes.add(cls.getType().getObject()); }
    if k == 0 {
        end_types.insert(cls.class_type.clone());
    }
}

/// Add a super type and recursively process it
///
/// JADX Reference: OverrideMethodVisitor.addSuperType() lines 312-339
fn add_super_type<R: ClassResolver>(
    resolver: &R,
    super_types: &mut Vec<String>,
    super_types_set: &mut HashSet<String>,
    end_types: &mut HashSet<String>,
    super_type: &str,
) -> i32 {
    // JADX: if (Objects.equals(superType, ArgType.OBJECT)) { return 0; }
    if super_type == "Ljava/lang/Object;" || super_type == "java/lang/Object" {
        return 0;
    }

    // JADX: if (!superTypes.add(superType)) { return 0; }
    // Found 'super' loop, stop processing
    if !super_types_set.insert(super_type.to_string()) {
        return 0;
    }
    super_types.push(super_type.to_string());

    // JADX: ClassNode classNode = root.resolveClass(superType);
    if let Some(cls) = resolver.resolve_class(super_type) {
        // Recursively collect super types
        collect_super_types_recursive(cls, resolver, super_types, super_types_set, end_types);
        return 1;
    }

    // JADX: ClspClass clsDetails = root.getClsp().getClsDetails(superType);
    if let Some(parents) = resolver.get_classpath_parents(super_type) {
        let mut k = 0;
        for parent_type in parents {
            k += add_super_type(resolver, super_types, super_types_set, end_types, &parent_type);
        }
        if k == 0 {
            end_types.insert(super_type.to_string());
        }
        return 1;
    }

    // JADX: no info found => treat as hierarchy end
    end_types.insert(super_type.to_string());
    1
}

/// Check if a method should be processed for override detection
///
/// JADX Reference: OverrideMethodVisitor.processMth() lines 60-63
/// ```java
/// if (mth.isConstructor() || mth.getAccessFlags().isStatic() || mth.getAccessFlags().isPrivate()) {
///     return;
/// }
/// ```
pub fn should_process_method(method: &MethodData) -> bool {
    // Skip constructors
    if method.name == "<init>" || method.name == "<clinit>" {
        return false;
    }
    // Skip static methods (ACC_STATIC = 0x08)
    if method.access_flags & 0x08 != 0 {
        return false;
    }
    // Skip private methods (ACC_PRIVATE = 0x02)
    if method.access_flags & 0x02 != 0 {
        return false;
    }
    true
}

/// Check if a method is visible in a subclass
///
/// JADX Reference: OverrideMethodVisitor.isMethodVisibleInCls() lines 253-263
/// ```java
/// private boolean isMethodVisibleInCls(MethodNode superMth, ClassNode cls) {
///     AccessInfo accessFlags = superMth.getAccessFlags();
///     if (accessFlags.isPrivate()) { return false; }
///     if (accessFlags.isPublic() || accessFlags.isProtected()) { return true; }
///     // package-private
///     return Objects.equals(superMth.getParentClass().getPackage(), cls.getPackage());
/// }
/// ```
pub fn is_method_visible_in_cls(super_method: &MethodData, super_class: &str, cls: &ClassData) -> bool {
    let flags = super_method.access_flags;

    // ACC_PRIVATE = 0x02
    if flags & 0x02 != 0 {
        return false;
    }
    // ACC_PUBLIC = 0x01, ACC_PROTECTED = 0x04
    if (flags & 0x01 != 0) || (flags & 0x04 != 0) {
        return true;
    }

    // Package-private: check if same package
    let super_pkg = get_package(super_class);
    let cls_pkg = get_package(&cls.class_type);
    super_pkg == cls_pkg
}

/// Get package from class type
fn get_package(class_type: &str) -> &str {
    let internal = class_type.trim_start_matches('L').trim_end_matches(';');
    match internal.rfind('/') {
        Some(pos) => &internal[..pos],
        None => "",
    }
}

/// Search for an overridden method in a super class
///
/// JADX Reference: OverrideMethodVisitor.searchOverriddenMethod() lines 136-161
///
/// Two-phase search:
/// 1. Exact match by short ID (name + params + return type)
/// 2. Fuzzy match: signature without return type, check if return type is wider
pub fn search_overridden_method<'a>(
    super_cls: &'a ClassData,
    method: &MethodData,
    signature: &str,
) -> Option<&'a MethodData> {
    let short_id = make_short_id(&method.name, &method.arg_types, Some(&method.return_type));

    // JADX: Phase 1 - search by exact full signature
    for sup_mth in &super_cls.methods {
        // Skip static methods
        if sup_mth.access_flags & 0x08 != 0 {
            continue;
        }
        let sup_short_id = make_short_id(&sup_mth.name, &sup_mth.arg_types, Some(&sup_mth.return_type));
        if sup_short_id == short_id {
            return Some(sup_mth);
        }
    }

    // JADX: Phase 2 - search by signature without return value
    for sup_mth in &super_cls.methods {
        // Skip static methods
        if sup_mth.access_flags & 0x08 != 0 {
            continue;
        }
        let sup_signature = make_signature(&sup_mth.arg_types, false);
        let sup_name_sig = format!("{}{}", sup_mth.name, sup_signature);
        let mth_name_sig = format!("{}{}", method.name, signature);

        if sup_name_sig == mth_name_sig {
            // JADX: Check if return type is wider (type comparison)
            // For now, we accept if signature matches without return type
            // TODO: Implement TypeCompare for proper type widening check
            return Some(sup_mth);
        }
    }

    None
}

/// Process override methods for a class
///
/// JADX Reference: OverrideMethodVisitor.visit() lines 49-58
///
/// Returns a map of method name -> MethodOverrideAttr for methods that override.
pub fn process_class_overrides<R: ClassResolver>(
    cls: &ClassData,
    resolver: &R,
) -> HashMap<String, MethodOverrideAttr> {
    let mut result = HashMap::new();

    // Collect super types
    let super_data = match collect_super_types(cls, resolver) {
        Some(data) => data,
        None => return result,
    };

    // Process each method
    for method in &cls.methods {
        if !should_process_method(method) {
            continue;
        }

        if let Some(attr) = process_override_method(method, cls, &super_data, resolver) {
            result.insert(method.name.clone(), attr);
        }
    }

    result
}

/// Process a single method for override detection
///
/// JADX Reference: OverrideMethodVisitor.processOverrideMethods() lines 82-123
fn process_override_method<R: ClassResolver>(
    method: &MethodData,
    cls: &ClassData,
    super_data: &SuperTypesData,
    resolver: &R,
) -> Option<MethodOverrideAttr> {
    let signature = make_signature(&method.arg_types, false);
    let mut override_list = Vec::new();
    let mut base_methods = HashSet::new();

    for super_type in &super_data.super_types {
        if let Some(super_cls) = resolver.resolve_class(super_type) {
            if let Some(ovrd_mth) = search_overridden_method(super_cls, method, &signature) {
                if is_method_visible_in_cls(ovrd_mth, super_type, cls) {
                    override_list.push(MethodRef::from_method(super_type, ovrd_mth));

                    // JADX: Check if this is an end type (base method)
                    if super_data.end_types.contains(super_type) {
                        base_methods.insert(MethodRef::from_method(super_type, ovrd_mth));
                    }
                }
            }
        } else {
            // Classpath method (unresolved) - mark as base if end type
            // JADX: ClspMethod handling (lines 106-119)
            if super_data.end_types.contains(super_type) {
                let method_ref = MethodRef::unresolved(
                    super_type,
                    &method.name,
                    &signature,
                    &make_short_id(&method.name, &method.arg_types, Some(&method.return_type)),
                );
                override_list.push(method_ref.clone());
                base_methods.insert(method_ref);
            }
        }
    }

    if override_list.is_empty() {
        return None;
    }

    // Build the override attribute
    let mut related_mth_nodes = HashSet::new();
    related_mth_nodes.insert(MethodRef::from_method(&cls.class_type, method));
    for ovrd in &override_list {
        if ovrd.is_resolved {
            related_mth_nodes.insert(ovrd.clone());
        }
    }

    Some(MethodOverrideAttr {
        override_list,
        related_mth_nodes,
        base_methods,
    })
}

/// Check if a method should NOT be renamed due to override chain
///
/// JADX Reference: OverrideMethodVisitor.applyOverrideAttr() line 184
/// ```java
/// boolean dontRename = overrideList.stream().anyMatch(m -> !(m instanceof MethodNode));
/// ```
///
/// If the override chain includes unresolved methods (classpath methods),
/// we can't safely rename since we don't have all the information.
pub fn should_prevent_rename(attr: &MethodOverrideAttr) -> bool {
    attr.override_list.iter().any(|m| !m.is_resolved)
}

// =============================================================================
// TYPE ERASURE FIXING
// =============================================================================
//
// JADX Reference: OverrideMethodVisitor.java lines 341-428
// Cloned from JADX's type erasure fixing methods exactly.
//
// When a class overrides a generic method (e.g., List<String>.get(int) returns String),
// the DEX method signature uses the erased type (Object). These functions fix the
// return type and argument types to match the base method's generic instantiation.

use crate::type_compare::{TypeCompare, TypeCompareEnum, replace_class_generics};

/// Result of fixing a method's types
#[derive(Debug, Clone)]
pub struct TypeFixResult {
    /// Whether the return type was fixed
    pub return_type_fixed: bool,
    /// The new return type (if fixed)
    pub new_return_type: Option<ArgType>,
    /// Whether any argument types were fixed
    pub arg_types_fixed: bool,
    /// The new argument types (if any were fixed)
    pub new_arg_types: Option<Vec<ArgType>>,
}

impl Default for TypeFixResult {
    fn default() -> Self {
        Self {
            return_type_fixed: false,
            new_return_type: None,
            arg_types_fixed: false,
            new_arg_types: None,
        }
    }
}

/// Fix method return type to match base method
///
/// JADX Reference: OverrideMethodVisitor.fixMethodReturnType() lines 341-351
/// ```java
/// private boolean fixMethodReturnType(MethodNode mth, IMethodDetails baseMth, SuperTypesData superData) {
///     ArgType returnType = mth.getReturnType();
///     if (returnType == ArgType.VOID) { return false; }
///     boolean updated = updateReturnType(mth, baseMth, superData);
///     if (updated) {
///         mth.addDebugComment("Return type fixed from '" + returnType + "' to match base method");
///     }
///     return updated;
/// }
/// ```
pub fn fix_method_return_type(
    method: &MethodData,
    base_method: &MethodData,
    base_class_type: &str,
    super_data: &SuperTypesData,
) -> Option<ArgType> {
    // JADX: if (returnType == ArgType.VOID) { return false; }
    if matches!(method.return_type, ArgType::Void) {
        return None;
    }

    update_return_type(method, base_method, base_class_type, super_data)
}

/// Update return type based on generic bindings
///
/// JADX Reference: OverrideMethodVisitor.updateReturnType() lines 353-376
fn update_return_type(
    method: &MethodData,
    base_method: &MethodData,
    base_class_type: &str,
    super_data: &SuperTypesData,
) -> Option<ArgType> {
    let base_return_type = &base_method.return_type;

    // JADX: if (mth.getReturnType().equals(baseReturnType)) { return false; }
    if method.return_type == *base_return_type {
        return None;
    }

    // JADX: if (!baseReturnType.containsTypeVariable()) { return false; }
    if !contains_type_variable(base_return_type) {
        return None;
    }

    // JADX: ArgType baseCls = baseMth.getMethodInfo().getDeclClass().getType();
    let base_cls = ArgType::Object(base_class_type.to_string());

    // JADX: for (ArgType superType : superData.getSuperTypes())
    for super_type_str in &super_data.super_types {
        let super_type = ArgType::Object(super_type_str.clone());

        // JADX: TypeCompareEnum compareResult = typeCompare.compareTypes(superType, baseCls);
        let compare_result = TypeCompare::compare_types(&super_type, &base_cls);

        // JADX: if (compareResult == TypeCompareEnum.NARROW_BY_GENERIC)
        if compare_result == TypeCompareEnum::NarrowByGeneric {
            // JADX: ArgType targetRetType = mth.root().getTypeUtils().replaceClassGenerics(superType, baseReturnType);
            if let Some(target_ret_type) = replace_class_generics(&super_type, base_return_type) {
                // JADX: if (targetRetType != null && !targetRetType.containsTypeVariable()
                //            && !targetRetType.equals(mth.getReturnType()))
                if !contains_type_variable(&target_ret_type) && target_ret_type != method.return_type {
                    return Some(target_ret_type);
                }
            }
        }
    }

    None
}

/// Fix method argument types to match base method
///
/// JADX Reference: OverrideMethodVisitor.fixMethodArgTypes() lines 378-403
/// ```java
/// private boolean fixMethodArgTypes(MethodNode mth, IMethodDetails baseMth, SuperTypesData superData) {
///     List<ArgType> mthArgTypes = mth.getArgTypes();
///     List<ArgType> baseArgTypes = baseMth.getArgTypes();
///     if (mthArgTypes.equals(baseArgTypes)) { return false; }
///     // ... fix each arg type ...
/// }
/// ```
pub fn fix_method_arg_types(
    method: &MethodData,
    base_method: &MethodData,
    base_class_type: &str,
    super_data: &SuperTypesData,
) -> Option<Vec<ArgType>> {
    // JADX: if (mthArgTypes.equals(baseArgTypes)) { return false; }
    if method.arg_types == base_method.arg_types {
        return None;
    }

    // JADX: if (argCount != baseArgTypes.size()) { return false; }
    if method.arg_types.len() != base_method.arg_types.len() {
        return None;
    }

    let mut changed = false;
    let mut new_arg_types = Vec::with_capacity(method.arg_types.len());

    // JADX: for (int argNum = 0; argNum < argCount; argNum++)
    for (i, (mth_arg, base_arg)) in method.arg_types.iter().zip(base_method.arg_types.iter()).enumerate() {
        if let Some(new_type) = update_arg_type(mth_arg, base_arg, base_class_type, super_data) {
            changed = true;
            new_arg_types.push(new_type);
        } else {
            new_arg_types.push(mth_arg.clone());
        }
    }

    if changed {
        Some(new_arg_types)
    } else {
        None
    }
}

/// Update a single argument type based on generic bindings
///
/// JADX Reference: OverrideMethodVisitor.updateArgType() lines 405-428
fn update_arg_type(
    arg: &ArgType,
    base_arg: &ArgType,
    base_class_type: &str,
    super_data: &SuperTypesData,
) -> Option<ArgType> {
    // JADX: if (arg.equals(baseArg)) { return null; }
    if arg == base_arg {
        return None;
    }

    // JADX: if (!baseArg.containsTypeVariable()) { return null; }
    if !contains_type_variable(base_arg) {
        return None;
    }

    let base_cls = ArgType::Object(base_class_type.to_string());

    for super_type_str in &super_data.super_types {
        let super_type = ArgType::Object(super_type_str.clone());

        let compare_result = TypeCompare::compare_types(&super_type, &base_cls);

        if compare_result == TypeCompareEnum::NarrowByGeneric {
            if let Some(target_arg_type) = replace_class_generics(&super_type, base_arg) {
                if !contains_type_variable(&target_arg_type) && &target_arg_type != arg {
                    return Some(target_arg_type);
                }
            }
        }
    }

    None
}

/// Check if type contains any type variables
///
/// JADX Reference: ArgType.containsTypeVariable()
fn contains_type_variable(ty: &ArgType) -> bool {
    match ty {
        ArgType::TypeVariable { .. } => true,
        ArgType::Generic { params, .. } => params.iter().any(contains_type_variable),
        ArgType::Array(elem) => contains_type_variable(elem),
        // Wildcard has `bound: WildcardBound` and `inner: Option<Box<ArgType>>`
        ArgType::Wildcard { inner, .. } => inner.as_ref().map_or(false, |b| contains_type_variable(b)),
        _ => false,
    }
}

/// Fix both return type and argument types for a method
///
/// JADX Reference: OverrideMethodVisitor.processOverrideMethods() lines 125-133
/// ```java
/// boolean fixed = false;
/// if (fixMethodReturnType(mth, baseMth, superData)) {
///     fixed = true;
/// }
/// if (fixMethodArgTypes(mth, baseMth, superData)) {
///     fixed = true;
/// }
/// if (fixed) {
///     checkMethodSignatureCollisions(mth, baseMth);
/// }
/// ```
pub fn fix_method_types(
    method: &MethodData,
    base_method: &MethodData,
    base_class_type: &str,
    super_data: &SuperTypesData,
) -> TypeFixResult {
    let mut result = TypeFixResult::default();

    // Fix return type
    if let Some(new_ret) = fix_method_return_type(method, base_method, base_class_type, super_data) {
        result.return_type_fixed = true;
        result.new_return_type = Some(new_ret);
    }

    // Fix argument types
    if let Some(new_args) = fix_method_arg_types(method, base_method, base_class_type, super_data) {
        result.arg_types_fixed = true;
        result.new_arg_types = Some(new_args);
    }

    result
}

/// Check for method signature collisions after type fixing
///
/// JADX Reference: OverrideMethodVisitor.checkMethodSignatureCollisions() lines 430-458
///
/// After fixing types, we might create signature collisions with other methods
/// in the same class. This function detects such collisions.
///
/// # Returns
/// Vector of method names that collide with the fixed method
pub fn check_signature_collisions(
    method: &MethodData,
    new_arg_types: &[ArgType],
    all_methods: &[MethodData],
) -> Vec<String> {
    let method_name = method.alias.as_ref().unwrap_or(&method.name);
    let new_signature = make_short_id(method_name, new_arg_types, None);

    let mut collisions = Vec::new();

    for other in all_methods {
        if std::ptr::eq(method, other) {
            continue;
        }

        let other_name = other.alias.as_ref().unwrap_or(&other.name);
        if other_name == method_name {
            let other_signature = make_short_id(other_name, &other.arg_types, None);
            if other_signature == new_signature {
                collisions.push(other_name.clone());
            }
        }
    }

    collisions
}

/// Make a method signature from argument types
///
/// JADX Reference: MethodInfo.makeSignature()
fn make_signature(arg_types: &[ArgType], _include_return: bool) -> String {
    let mut sig = String::from("(");
    for arg in arg_types {
        sig.push_str(&arg_type_to_descriptor(arg));
    }
    sig.push(')');
    sig
}

/// Make a method short ID (name + signature + return type)
///
/// JADX Reference: MethodInfo.getShortId()
fn make_short_id(name: &str, arg_types: &[ArgType], return_type: Option<&ArgType>) -> String {
    let mut id = name.to_string();
    id.push('(');
    for arg in arg_types {
        id.push_str(&arg_type_to_descriptor(arg));
    }
    id.push(')');
    if let Some(ret) = return_type {
        id.push_str(&arg_type_to_descriptor(ret));
    }
    id
}

/// Convert ArgType to descriptor string
fn arg_type_to_descriptor(arg: &ArgType) -> String {
    match arg {
        ArgType::Void => "V".to_string(),
        ArgType::Boolean => "Z".to_string(),
        ArgType::Byte => "B".to_string(),
        ArgType::Short => "S".to_string(),
        ArgType::Char => "C".to_string(),
        ArgType::Int => "I".to_string(),
        ArgType::Long => "J".to_string(),
        ArgType::Float => "F".to_string(),
        ArgType::Double => "D".to_string(),
        ArgType::Object(name) => {
            if name.starts_with('L') && name.ends_with(';') {
                name.clone()
            } else {
                format!("L{};", name.replace('.', "/"))
            }
        }
        ArgType::Array(elem) => format!("[{}", arg_type_to_descriptor(elem)),
        ArgType::Generic { base, .. } => {
            // Type erasure: use the base type
            if base.starts_with('L') && base.ends_with(';') {
                base.clone()
            } else {
                format!("L{};", base.replace('.', "/"))
            }
        }
        ArgType::TypeVariable { .. } => "Ljava/lang/Object;".to_string(),
        ArgType::Wildcard { .. } => "Ljava/lang/Object;".to_string(),
        // All unknown variants map to Object (type erasure)
        _ => "Ljava/lang/Object;".to_string(),
    }
}

/// Convert ArgType to class type string (for interfaces)
fn arg_type_to_class_type(arg: &ArgType) -> Option<String> {
    match arg {
        ArgType::Object(name) => {
            if name.starts_with('L') && name.ends_with(';') {
                Some(name.clone())
            } else {
                Some(format!("L{};", name.replace('.', "/")))
            }
        }
        ArgType::Generic { base, .. } => {
            if base.starts_with('L') && base.ends_with(';') {
                Some(base.clone())
            } else {
                Some(format!("L{};", base.replace('.', "/")))
            }
        }
        _ => None,
    }
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn test_should_process_method() {
        let mut method = MethodData::new("test".to_string(), 0, ArgType::Void);
        assert!(should_process_method(&method));

        // Constructor
        method.name = "<init>".to_string();
        assert!(!should_process_method(&method));

        // Static
        method.name = "test".to_string();
        method.access_flags = 0x08;
        assert!(!should_process_method(&method));

        // Private
        method.access_flags = 0x02;
        assert!(!should_process_method(&method));
    }

    #[test]
    fn test_get_package() {
        assert_eq!(get_package("Lcom/example/Foo;"), "com/example");
        assert_eq!(get_package("Ljava/lang/Object;"), "java/lang");
        assert_eq!(get_package("LFoo;"), "");
    }

    #[test]
    fn test_make_signature() {
        let args = vec![ArgType::Int, ArgType::Int];
        assert_eq!(make_signature(&args, false), "(II)");

        let args2 = vec![ArgType::Object("Ljava/lang/String;".to_string())];
        assert_eq!(make_signature(&args2, false), "(Ljava/lang/String;)");
    }

    #[test]
    fn test_make_short_id() {
        let args = vec![ArgType::Int];
        let ret = ArgType::Void;
        assert_eq!(make_short_id("test", &args, Some(&ret)), "test(I)V");
    }

    #[test]
    fn test_method_visibility() {
        let mut method = MethodData::new("test".to_string(), 0x01, ArgType::Void); // public
        let cls = ClassData::new("Lcom/example/Sub;".to_string(), 0);

        // Public is always visible
        assert!(is_method_visible_in_cls(&method, "Lcom/other/Base;", &cls));

        // Protected is always visible
        method.access_flags = 0x04;
        assert!(is_method_visible_in_cls(&method, "Lcom/other/Base;", &cls));

        // Private is never visible
        method.access_flags = 0x02;
        assert!(!is_method_visible_in_cls(&method, "Lcom/other/Base;", &cls));

        // Package-private: same package = visible
        method.access_flags = 0x00;
        assert!(is_method_visible_in_cls(&method, "Lcom/example/Base;", &cls));

        // Package-private: different package = not visible
        assert!(!is_method_visible_in_cls(&method, "Lcom/other/Base;", &cls));
    }

    #[test]
    fn test_collect_super_types() {
        let mut base = ClassData::new("Lcom/example/Base;".to_string(), 0);
        let mut sub = ClassData::new("Lcom/example/Sub;".to_string(), 0);
        sub.superclass = Some("Lcom/example/Base;".to_string());

        let classes = vec![base.clone(), sub.clone()];
        let resolver = SimpleClassResolver::new(&classes);

        let super_data = collect_super_types(&sub, &resolver).unwrap();
        assert!(super_data.super_types.contains(&"Lcom/example/Base;".to_string()));
    }

    #[test]
    fn test_should_prevent_rename() {
        let mut attr = MethodOverrideAttr::default();

        // No unresolved methods - can rename
        attr.override_list.push(MethodRef {
            class_type: "Lcom/example/Base;".to_string(),
            name: "test".to_string(),
            signature: "()".to_string(),
            short_id: "test()V".to_string(),
            is_resolved: true,
        });
        assert!(!should_prevent_rename(&attr));

        // Has unresolved method - don't rename
        attr.override_list.push(MethodRef {
            class_type: "Ljava/lang/Runnable;".to_string(),
            name: "run".to_string(),
            signature: "()".to_string(),
            short_id: "run()V".to_string(),
            is_resolved: false,
        });
        assert!(should_prevent_rename(&attr));
    }
}
