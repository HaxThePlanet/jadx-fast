//! Class code generation
//!
//! Generates Java source code for classes using dexterity-ir types.
//!
//! ## Inner Class Support
//!
//! This module detects and handles several types of inner classes:
//! - **Named inner classes**: `OuterClass$InnerClass`
//! - **Anonymous inner classes**: `OuterClass$1`, `OuterClass$2`, etc.
//! - **Lambda classes**: `OuterClass$$Lambda$1` (Java 8+ lambdas)
//!
//! When generating code for an outer class, inner classes can be embedded within.

use std::collections::{BTreeMap, BTreeSet, HashMap, HashSet};

use dexterity_ir::{ArgType, ClassData, FieldData, FieldValue};

use crate::access_flags::{self, AccessContext};
use crate::dex_info::{DexInfoProvider, replace_inner_class_separator};
use crate::method_gen::{generate_annotation, generate_type_parameters, should_emit_annotation};
use crate::type_gen::{get_package, literal_to_string, type_to_string};
use crate::writer::{CodeWriter, SimpleCodeWriter};

// ====================
// Comments Level System
// ====================

/// Level of comments to include in generated code (matches JADX CommentsLevel)
#[derive(Debug, Clone, Copy, PartialEq, Eq, PartialOrd, Ord, Default)]
pub enum CommentsLevel {
    /// No comments at all
    None,
    /// Only user-provided comments
    UserOnly,
    /// Include error comments (/* Dexterity ERROR: ... */)
    Error,
    /// Include warning comments (/* Dexterity WARNING: ... */)
    Warn,
    /// Include info comments (/* loaded from: ... */, /* renamed from: ... */)
    #[default]
    Info,
    /// Include debug comments
    Debug,
}

impl CommentsLevel {
    /// Check if a comment at the given level should be included
    pub fn should_show(&self, comment_level: CommentsLevel) -> bool {
        // Higher ordinal = more verbose. Show if current level >= comment level
        *self >= comment_level
    }

    /// Check if INFO level comments should be shown
    pub fn show_info(&self) -> bool {
        self.should_show(CommentsLevel::Info)
    }

    /// Check if WARN level comments should be shown
    pub fn show_warn(&self) -> bool {
        self.should_show(CommentsLevel::Warn)
    }

    /// Check if ERROR level comments should be shown
    pub fn show_error(&self) -> bool {
        self.should_show(CommentsLevel::Error)
    }

    /// Check if DEBUG level comments should be shown
    pub fn show_debug(&self) -> bool {
        self.should_show(CommentsLevel::Debug)
    }
}

// =====================
// Inner Class Utilities
// =====================

/// Information about an inner class
#[derive(Debug, Clone)]
pub struct InnerClassInfo {
    /// Full class type (e.g., "Lcom/example/Outer$Inner;")
    pub class_type: String,
    /// Simple name of inner class (e.g., "Inner" or "1")
    pub simple_name: String,
    /// Outer class type (e.g., "Lcom/example/Outer;")
    pub outer_class: String,
    /// Kind of inner class
    pub kind: InnerClassKind,
}

/// Kind of inner class
#[derive(Debug, Clone, Copy, PartialEq, Eq)]
pub enum InnerClassKind {
    /// Named inner class (Outer$Inner)
    Named,
    /// Anonymous inner class (Outer$1)
    Anonymous,
    /// Lambda implementation (Outer$$Lambda$1)
    Lambda,
    /// Local class (Outer$1LocalClass)
    Local,
}

/// Check if a class type is an inner class
pub fn is_inner_class(class_type: &str) -> bool {
    let stripped = class_type
        .strip_prefix('L')
        .unwrap_or(class_type)
        .strip_suffix(';')
        .unwrap_or(class_type);
    stripped.contains('$')
}

/// Get inner class info from a class type
pub fn get_inner_class_info(class_type: &str) -> Option<InnerClassInfo> {
    let stripped = class_type
        .strip_prefix('L')
        .unwrap_or(class_type)
        .strip_suffix(';')
        .unwrap_or(class_type);

    let dollar_pos = stripped.rfind('$')?;
    let outer_part = &stripped[..dollar_pos];
    let inner_part = &stripped[dollar_pos + 1..];

    if inner_part.is_empty() {
        return None;
    }

    // Determine kind
    // D8/R8 generates $$ExternalSyntheticLambda, older toolchains generate $$Lambda$
    // Kotlin generates $lambda-N (with hyphen) for composable lambda classes
    let kind = if stripped.contains("$$Lambda$")
        || stripped.contains("$$ExternalSyntheticLambda")
        || stripped.contains("$lambda-") {
        InnerClassKind::Lambda
    } else if inner_part.chars().next().map(|c| c.is_ascii_digit()).unwrap_or(false) {
        // Starts with digit: could be anonymous or local
        if inner_part.chars().all(|c| c.is_ascii_digit()) {
            InnerClassKind::Anonymous
        } else {
            InnerClassKind::Local
        }
    } else {
        InnerClassKind::Named
    };

    Some(InnerClassInfo {
        class_type: class_type.to_string(),
        simple_name: inner_part.to_string(),
        outer_class: format!("L{};", outer_part),
        kind,
    })
}

/// Get the outer class type from an inner class type
pub fn get_outer_class(class_type: &str) -> Option<String> {
    get_inner_class_info(class_type).map(|info| info.outer_class)
}

/// Check if a class is anonymous
pub fn is_anonymous_class(class_type: &str) -> bool {
    get_inner_class_info(class_type)
        .map(|info| info.kind == InnerClassKind::Anonymous)
        .unwrap_or(false)
}

/// Check if a class is a lambda implementation
pub fn is_lambda_class(class_type: &str) -> bool {
    get_inner_class_info(class_type)
        .map(|info| info.kind == InnerClassKind::Lambda)
        .unwrap_or(false)
}

/// Check if a class is a switch map synthetic class
///
/// These are anonymous inner classes generated by Java/Kotlin compilers for enum switch statements.
/// They contain static int[] fields with names like `$SwitchMap$*` (Java) or `$EnumSwitchMapping$*` (Kotlin).
/// Unlike regular anonymous classes that should be inlined, these need to be generated as inner classes
/// because they contain static initializers that set up the switch map arrays.
///
/// Example patterns:
/// - Java: `$SwitchMap$com$example$MyEnum`
/// - Kotlin: `$EnumSwitchMapping$0`
/// - Kotlin WhenMappings: class named `WhenMappings` with synthetic fields
pub fn is_switch_map_class(class: &ClassData) -> bool {
    // Check if it's an anonymous class (e.g., Outer$1) or WhenMappings class
    let is_anonymous = is_anonymous_class(&class.class_type);
    let is_when_mappings = class.class_type.ends_with("WhenMappings;")
        || class.class_type.ends_with("$WhenMappings;");

    if !is_anonymous && !is_when_mappings {
        return false;
    }

    // Check if it has switch map fields (typically in static_fields)
    for field in &class.static_fields {
        let field_name = &field.name;
        // Java-style: $SwitchMap$package$name$EnumName
        // Kotlin-style: $EnumSwitchMapping$0, $EnumSwitchMapping$1, etc.
        if field_name.starts_with("$SwitchMap$")
            || field_name.starts_with("$EnumSwitchMapping$") {
            return true;
        }
    }

    false
}

/// Group classes by outer class for nested generation
pub fn group_by_outer_class<'a>(
    classes: impl Iterator<Item = &'a ClassData>,
) -> BTreeMap<String, Vec<&'a ClassData>> {
    let mut result: BTreeMap<String, Vec<&'a ClassData>> = BTreeMap::new();

    for class in classes {
        if let Some(info) = get_inner_class_info(&class.class_type) {
            result
                .entry(info.outer_class)
                .or_default()
                .push(class);
        }
    }

    result
}

/// Check if a class implements a single abstract method interface (SAM)
/// Used for lambda detection
pub fn is_sam_interface(class: &ClassData) -> bool {
    // Check if it's an anonymous class implementing exactly one interface
    if !is_anonymous_class(&class.class_type) {
        return false;
    }

    // Should implement exactly one interface
    if class.interfaces.len() != 1 {
        return false;
    }

    // Should have exactly one non-constructor method
    let abstract_methods: Vec<_> = class.methods.iter()
        .filter(|m| !m.is_constructor() && !m.is_class_init())
        .collect();

    abstract_methods.len() == 1
}

/// Collects types used in a class for import generation
#[derive(Debug, Default)]
pub struct ImportCollector {
    /// Types that need importing (fully qualified internal names)
    imports: BTreeSet<String>,
    /// Current class package (types in same package don't need imports)
    current_package: Option<String>,
    /// Maps simple names to list of fully qualified names (for conflict detection)
    /// P0-C01 fix: When multiple FQNs have the same simple name, none are imported
    simple_name_map: HashMap<String, Vec<String>>,
    /// Inner class simple names (for JADX checkInnerCollision parity)
    /// Clone of JADX ClassGen.java:785-802 - types whose simple name matches any inner class
    /// cannot use short names and must be fully qualified
    inner_class_names: HashSet<String>,
}

impl ImportCollector {
    /// Create a new import collector for a class
    pub fn new(class_type: &str) -> Self {
        ImportCollector {
            imports: BTreeSet::new(),
            current_package: get_package(class_type),
            simple_name_map: HashMap::new(),
            inner_class_names: HashSet::new(),
        }
    }

    /// Clone of JADX ClassGen.checkInnerCollision()
    /// Reference: jadx-core/src/main/java/jadx/core/codegen/ClassGen.java:785-802
    ///
    /// Register inner class names to prevent import collision.
    /// Types with simple names matching any inner class cannot be imported.
    pub fn add_inner_class_name(&mut self, inner_class_type: &str) {
        // Extract simple name from inner class type (e.g., "Outer$Inner" -> "Inner")
        let simple_name = if let Some(dollar_pos) = inner_class_type.rfind('$') {
            &inner_class_type[dollar_pos + 1..]
        } else {
            inner_class_type.rsplit('/').next().unwrap_or(inner_class_type)
        };
        self.inner_class_names.insert(simple_name.to_string());
    }

    /// Register all inner classes from a class
    pub fn register_inner_classes(&mut self, class: &ClassData) {
        // Note: In JADX, this would recursively walk up parent classes
        // For now, we register the class's own inner classes based on naming convention
        for method in &class.methods {
            // Lambda classes show up as inner classes in some patterns
            if let Some(info) = get_inner_class_info(&class.class_type) {
                if info.kind == InnerClassKind::Named {
                    self.add_inner_class_name(&class.class_type);
                }
            }
        }
    }

    /// Add a type to the imports (handles internal class name format)
    pub fn add_type(&mut self, ty: &ArgType) {
        match ty {
            ArgType::Object(name) => {
                self.add_internal_name(name);
            }
            ArgType::Array(elem) => {
                self.add_type(elem);
            }
            ArgType::Generic { base, params } => {
                self.add_internal_name(base);
                for param in params {
                    self.add_type(param);
                }
            }
            ArgType::Wildcard { inner, .. } => {
                if let Some(inner_ty) = inner {
                    self.add_type(inner_ty);
                }
            }
            // Primitives and void don't need imports
            _ => {}
        }
    }

    /// Collect types from annotation value
    fn collect_from_annotation_value(&mut self, value: &dexterity_ir::info::AnnotationValue) {
        use dexterity_ir::info::AnnotationValue;
        match value {
            AnnotationValue::Type(class_name) => {
                // Type reference like RetentionPolicy.class
                self.add_internal_name(class_name);
            }
            AnnotationValue::Enum(class_name, _field_name) => {
                // Enum constant like RetentionPolicy.SOURCE
                self.add_internal_name(class_name);
            }
            AnnotationValue::Annotation(nested) => {
                // Nested annotation - recursively collect from it
                self.add_internal_name(&nested.annotation_type);
                for element in &nested.elements {
                    self.collect_from_annotation_value(&element.value);
                }
            }
            AnnotationValue::Array(values) => {
                // Array of values - collect from each element
                for v in values {
                    self.collect_from_annotation_value(v);
                }
            }
            // Primitive values don't need imports
            _ => {}
        }
    }

    /// Add an internal class name (e.g., "java/lang/String" or "Ljava/lang/String;")
    /// Also handles array type descriptors like "[Ljava/lang/String;" by extracting the element type
    fn add_internal_name(&mut self, name: &str) {
        // Strip array prefixes (e.g., "[Ljava/lang/String;" -> "java/lang/String")
        // This fixes the array import syntax bug where "[Lio.grpc.q;" was being imported
        // instead of just "io.grpc.q"
        let mut stripped = name;

        // Strip all leading '[' for multi-dimensional arrays
        while stripped.starts_with('[') {
            stripped = &stripped[1..];
        }

        // Now strip L prefix and ; suffix if present
        stripped = stripped
            .strip_prefix('L')
            .unwrap_or(stripped);
        stripped = stripped
            .strip_suffix(';')
            .unwrap_or(stripped);

        // Skip primitive array element types (B, C, D, F, I, J, S, Z)
        if stripped.len() == 1 && "BCDFIJSZ".contains(stripped) {
            return;
        }

        // Skip java.lang.* (implicit imports)
        if stripped.starts_with("java/lang/") && !stripped[10..].contains('/') {
            return;
        }

        // Skip dalvik.annotation.* (system annotations not visible to user code)
        if stripped.starts_with("dalvik/annotation/") {
            return;
        }

        // Skip same package
        if let Some(ref pkg) = self.current_package {
            if let Some(type_pkg) = get_package_internal(stripped) {
                if &type_pkg == pkg {
                    return;
                }
            }
        }

        // Skip primitives that might slip through
        if !stripped.contains('/') {
            return;
        }

        // P0-C01 fix: Track simple name -> FQN mapping for conflict detection
        let simple_name = stripped.rsplit('/').next().unwrap_or(stripped).to_string();
        self.simple_name_map
            .entry(simple_name)
            .or_default()
            .push(stripped.to_string());

        self.imports.insert(stripped.to_string());
    }

    /// Collect types from a class
    pub fn collect_from_class(&mut self, class: &ClassData) {
        self.collect_from_class_with_dex(class, None);
    }

    /// Collect types from a class with DEX info for method body type resolution
    pub fn collect_from_class_with_dex(
        &mut self,
        class: &ClassData,
        dex_info: Option<&std::sync::Arc<dyn DexInfoProvider>>
    ) {
        // Class-level annotations (including @Metadata for Kotlin)
        for annotation in &class.annotations {
            self.add_internal_name(&annotation.annotation_type);
            // Collect types from annotation arguments (fixes P2-MEDIUM: Missing Import Statements)
            for element in &annotation.elements {
                self.collect_from_annotation_value(&element.value);
            }
        }

        // Superclass
        if let Some(ref superclass) = class.superclass {
            self.add_internal_name(superclass);
        }

        // Interfaces
        for iface in &class.interfaces {
            self.add_type(iface);
        }

        // Class type parameter bounds (e.g., <T extends Comparable<E>, E extends Number>)
        for type_param in &class.type_parameters {
            for bound in &type_param.bounds {
                self.add_type(bound);
            }
        }

        // Fields
        for field in &class.static_fields {
            self.add_type(&field.field_type);
            // Field annotations
            for annotation in &field.annotations {
                self.add_internal_name(&annotation.annotation_type);
                // Collect types from annotation arguments
                for element in &annotation.elements {
                    self.collect_from_annotation_value(&element.value);
                }
            }
        }
        for field in &class.instance_fields {
            self.add_type(&field.field_type);
            // Field annotations
            for annotation in &field.annotations {
                self.add_internal_name(&annotation.annotation_type);
                // Collect types from annotation arguments
                for element in &annotation.elements {
                    self.collect_from_annotation_value(&element.value);
                }
            }
        }

        // Methods
        for method in &class.methods {
            self.add_type(&method.return_type);
            for param in &method.arg_types {
                self.add_type(param);
            }
            // Method type parameter bounds (e.g., <T extends Comparable<E>>)
            for type_param in &method.type_parameters {
                for bound in &type_param.bounds {
                    self.add_type(bound);
                }
            }
            // Method annotations
            for annotation in &method.annotations {
                self.add_internal_name(&annotation.annotation_type);
                // Collect types from annotation arguments
                for element in &annotation.elements {
                    self.collect_from_annotation_value(&element.value);
                }
            }
            // Collect types from method body instructions
            if let Some(instructions) = method.instructions() {
                self.collect_from_instructions(instructions, dex_info);
            }
            // Collect exception types from try-catch blocks (MEDIUM-002 fix)
            for try_block in &method.try_blocks {
                for handler in &try_block.handlers {
                    if let Some(ref exception_type) = handler.exception_type {
                        self.add_internal_name(exception_type);
                    }
                }
            }
        }
    }

    /// Collect types from method body instructions
    fn collect_from_instructions(
        &mut self,
        instructions: &[dexterity_ir::instructions::InsnNode],
        dex_info: Option<&std::sync::Arc<dyn DexInfoProvider>>
    ) {
        use dexterity_ir::instructions::InsnType;

        for insn in instructions {
            // Check result type
            if let Some(ref ty) = insn.result_type {
                self.add_type(ty);
            }

            // Extract types from instruction using DEX info
            if let Some(dex) = dex_info {
                match &insn.insn_type {
                    // Invoke instructions - extract method's declaring class
                    InsnType::Invoke { method_idx, .. } => {
                        if let Some(method_info) = dex.get_method(*method_idx) {
                            self.add_internal_name(&method_info.class_type);
                        }
                    }
                    // Static field access - extract field's declaring class
                    InsnType::StaticGet { field_idx, .. } | InsnType::StaticPut { field_idx, .. } => {
                        if let Some(field_info) = dex.get_field(*field_idx) {
                            self.add_internal_name(&field_info.class_type);
                        }
                    }
                    // NewInstance - extract the type being created
                    InsnType::NewInstance { type_idx, .. } => {
                        if let Some(type_name) = dex.get_type_name(*type_idx) {
                            self.add_internal_name(&type_name);
                        }
                    }
                    // NewArray - extract array element type
                    InsnType::NewArray { type_idx, .. } | InsnType::FilledNewArray { type_idx, .. } => {
                        if let Some(type_name) = dex.get_type_name(*type_idx) {
                            // Strip array prefix [L and suffix ;
                            let elem_type = type_name
                                .trim_start_matches('[')
                                .trim_start_matches('L')
                                .trim_end_matches(';');
                            if elem_type.contains('/') {
                                self.add_internal_name(elem_type);
                            }
                        }
                    }
                    // CheckCast and InstanceOf - extract target type
                    InsnType::CheckCast { type_idx, .. } | InsnType::InstanceOf { type_idx, .. } => {
                        if let Some(type_name) = dex.get_type_name(*type_idx) {
                            self.add_internal_name(&type_name);
                        }
                    }
                    // ConstClass - extract the class being referenced (e.g., Foo.class)
                    InsnType::ConstClass { type_idx, .. } => {
                        if let Some(type_name) = dex.get_type_name(*type_idx) {
                            self.add_internal_name(&type_name);
                        }
                    }
                    // Instance field access - extract field's declaring class
                    InsnType::InstanceGet { field_idx, .. } | InsnType::InstancePut { field_idx, .. } => {
                        if let Some(field_info) = dex.get_field(*field_idx) {
                            self.add_internal_name(&field_info.class_type);
                        }
                    }
                    // InvokeCustom (lambdas) - extract types from lambda info
                    InsnType::InvokeCustom { lambda_info, .. } => {
                        if let Some(info) = lambda_info {
                            // Import the implementation class (for method references)
                            self.add_internal_name(&info.impl_class);
                            // Import lambda parameter types
                            for param_type in &info.lambda_param_types {
                                self.add_type(param_type);
                            }
                            // Import lambda return type
                            self.add_type(&info.lambda_return_type);
                        }
                    }
                    _ => {}
                }
            }
        }
    }

    /// Get sorted import statements
    /// P0-C01 fix: Excludes types with conflicting simple names (e.g., f.a.a.a and f.a.b.a)
    /// JADX parity: Also excludes types that conflict with inner class names
    pub fn get_imports(&self) -> Vec<String> {
        // Build set of conflicting FQNs (types whose simple names conflict with others)
        let conflicting_fqns: BTreeSet<&str> = self.simple_name_map
            .values()
            .filter(|fqns| {
                // A simple name has a conflict if there are multiple unique FQNs
                let unique: BTreeSet<&str> = fqns.iter().map(String::as_str).collect();
                unique.len() > 1
            })
            .flat_map(|fqns| fqns.iter().map(String::as_str))
            .collect();

        self.imports
            .iter()
            .filter(|name| {
                // Exclude types with conflicting simple names
                if conflicting_fqns.contains(name.as_str()) {
                    return false;
                }
                // Clone of JADX ClassGen.checkInnerCollision()
                // Reference: jadx-core/src/main/java/jadx/core/codegen/ClassGen.java:785-802
                // Exclude types whose simple name matches an inner class
                !self.has_inner_class_collision(name)
            })
            .map(|name| replace_inner_class_separator(&name.replace('/', ".")))
            .collect()
    }

    /// Check if a type is imported (can use simple name)
    /// P0-C01 fix: Returns false for types with conflicting simple names
    pub fn is_imported(&self, internal_name: &str) -> bool {
        let stripped = internal_name
            .strip_prefix('L')
            .unwrap_or(internal_name)
            .strip_suffix(';')
            .unwrap_or(internal_name);
        if !self.imports.contains(stripped) {
            return false;
        }
        // Check if this type has a conflicting simple name
        let simple_name = stripped.rsplit('/').next().unwrap_or(stripped);

        // Clone of JADX ClassGen.checkInnerCollision()
        // Reference: jadx-core/src/main/java/jadx/core/codegen/ClassGen.java:785-802
        // If simple name matches any inner class, can't use short form
        if self.inner_class_names.contains(simple_name) {
            return false;
        }

        if let Some(fqns) = self.simple_name_map.get(simple_name) {
            let unique: BTreeSet<&str> = fqns.iter().map(String::as_str).collect();
            if unique.len() > 1 {
                return false; // Conflict - can't use simple name
            }
        }
        true
    }

    /// Clone of JADX ClassGen.checkInnerCollision() for a specific type
    /// Reference: jadx-core/src/main/java/jadx/core/codegen/ClassGen.java:785-802
    ///
    /// Returns true if the type's simple name conflicts with an inner class name
    fn has_inner_class_collision(&self, internal_name: &str) -> bool {
        let simple_name = internal_name.rsplit('/').next().unwrap_or(internal_name);
        self.inner_class_names.contains(simple_name)
    }

    /// Get the set of non-conflicting imports for type resolution
    /// P0-C01 fix: Excludes types with conflicting simple names
    /// JADX parity: Also excludes types that conflict with inner class names
    pub fn get_non_conflicting_imports(&self) -> BTreeSet<String> {
        // Build set of conflicting FQNs (same simple name, different FQN)
        let conflicting_fqns: BTreeSet<&str> = self.simple_name_map
            .values()
            .filter(|fqns| {
                let unique: BTreeSet<&str> = fqns.iter().map(String::as_str).collect();
                unique.len() > 1
            })
            .flat_map(|fqns| fqns.iter().map(String::as_str))
            .collect();

        self.imports
            .iter()
            .filter(|name| {
                // Exclude types with conflicting simple names
                if conflicting_fqns.contains(name.as_str()) {
                    return false;
                }
                // Clone of JADX ClassGen.checkInnerCollision()
                // Reference: jadx-core/src/main/java/jadx/core/codegen/ClassGen.java:785-802
                // Exclude types whose simple name matches an inner class
                !self.has_inner_class_collision(name)
            })
            .cloned()
            .collect()
    }
}

/// Get package from internal name without L; wrapping
fn get_package_internal(internal: &str) -> Option<String> {
    let pos = internal.rfind('/')?;
    Some(internal[..pos].replace('/', "."))
}

/// Configuration for class generation
#[derive(Debug, Clone)]
pub struct ClassGenConfig {
    /// Use imports for types (vs fully qualified names)
    pub use_imports: bool,
    /// Show debug comments
    pub show_debug: bool,
    /// Fallback mode (show raw bytecode on error)
    pub fallback: bool,
    /// Escape non-ASCII characters in strings as \uXXXX
    pub escape_unicode: bool,
    /// Inline anonymous class bodies at instantiation sites
    pub inline_anonymous: bool,
    /// Add comments with debug line numbers
    pub add_debug_lines: bool,
    /// Inline synthetic bridge methods (access$XXX methods)
    pub inline_methods: bool,
    /// Class hierarchy for improved type inference (LCA, subtype checking)
    pub hierarchy: Option<std::sync::Arc<dexterity_ir::ClassHierarchy>>,
    /// Deobfuscation: minimum name length (shorter names get renamed)
    pub deobf_min_length: usize,
    /// Deobfuscation: maximum name length (longer names get renamed)
    pub deobf_max_length: usize,
    /// Resource ID -> name mapping (e.g., 0x7f010001 -> "id/button")
    /// Wrapped in Arc for efficient sharing across parallel class processing.
    pub res_names: std::sync::Arc<std::collections::HashMap<u32, String>>,
    /// Whether to replace resource IDs with R.* field references
    pub replace_consts: bool,
    /// App package name for R class imports
    pub app_package_name: Option<String>,
    /// Level of comments to include (ERROR, WARN, INFO, DEBUG)
    pub comments_level: CommentsLevel,
}

impl Default for ClassGenConfig {
    fn default() -> Self {
        ClassGenConfig {
            use_imports: true,
            show_debug: false,
            fallback: false,
            escape_unicode: false,
            inline_anonymous: true,
            add_debug_lines: false,
            inline_methods: true,
            hierarchy: None,
            deobf_min_length: 3,
            deobf_max_length: 64,
            res_names: std::sync::Arc::new(std::collections::HashMap::new()),
            replace_consts: false,
            app_package_name: None,
            comments_level: CommentsLevel::Info,
        }
    }
}

/// Generate Java source code for a class
pub fn generate_class(class: &ClassData, config: &ClassGenConfig) -> String {
    let mut writer = SimpleCodeWriter::new();
    generate_class_to_writer(class, config, &mut writer);
    writer.finish()
}

/// Generate Java source code for a class with DEX info for name resolution
///
/// When `dex_info` is provided, type/field/method indices are resolved to actual names.
pub fn generate_class_with_dex(
    class: &ClassData,
    config: &ClassGenConfig,
    dex_info: Option<std::sync::Arc<dyn DexInfoProvider>>,
) -> String {
    generate_class_with_inner_classes(class, config, dex_info, None)
}

/// Generate Java source code for a class with inner classes for anonymous class inlining
///
/// When `inner_classes` is provided, anonymous inner class instantiations are inlined
/// with their full body (methods) instead of just `new AnonymousClass()`.
///
/// When `nested_inner_classes` is provided, those classes are generated as nested
/// declarations inside the outer class body (Java-style inner class output).
pub fn generate_class_with_inner_classes(
    class: &ClassData,
    config: &ClassGenConfig,
    dex_info: Option<std::sync::Arc<dyn DexInfoProvider>>,
    inner_classes: Option<&HashMap<String, std::sync::Arc<ClassData>>>,
) -> String {
    generate_class_with_nested_inner_classes(class, config, dex_info, inner_classes, None)
}

/// Generate Java source code for a class with nested inner classes
///
/// `nested_inner_classes` - Classes to generate as nested declarations inside this class
pub fn generate_class_with_nested_inner_classes(
    class: &ClassData,
    config: &ClassGenConfig,
    dex_info: Option<std::sync::Arc<dyn DexInfoProvider>>,
    inner_classes: Option<&HashMap<String, std::sync::Arc<ClassData>>>,
    nested_inner_classes: Option<&[ClassData]>,
) -> String {
    let mut writer = SimpleCodeWriter::new();
    generate_class_to_writer_with_nested_inner_classes(class, config, dex_info, inner_classes, nested_inner_classes, &mut writer);
    writer.finish()
}

/// Generate Java source code for a class into a writer
pub fn generate_class_to_writer<W: CodeWriter>(class: &ClassData, config: &ClassGenConfig, code: &mut W) {
    generate_class_to_writer_with_dex(class, config, None, code)
}

/// Generate Java source code for a class into a writer with DEX info
pub fn generate_class_to_writer_with_dex<W: CodeWriter>(
    class: &ClassData,
    config: &ClassGenConfig,
    dex_info: Option<std::sync::Arc<dyn DexInfoProvider>>,
    code: &mut W,
) {
    generate_class_to_writer_with_inner_classes(class, config, dex_info, None, code)
}

/// Generate Java source code for a class into a writer with inner classes
pub fn generate_class_to_writer_with_inner_classes<W: CodeWriter>(
    class: &ClassData,
    config: &ClassGenConfig,
    dex_info: Option<std::sync::Arc<dyn DexInfoProvider>>,
    inner_classes: Option<&HashMap<String, std::sync::Arc<ClassData>>>,
    code: &mut W,
) {
    generate_class_to_writer_with_nested_inner_classes(class, config, dex_info, inner_classes, None, code)
}

/// Generate Java source code for a class into a writer with nested inner classes
pub fn generate_class_to_writer_with_nested_inner_classes<W: CodeWriter>(
    class: &ClassData,
    config: &ClassGenConfig,
    dex_info: Option<std::sync::Arc<dyn DexInfoProvider>>,
    inner_classes: Option<&HashMap<String, std::sync::Arc<ClassData>>>,
    nested_inner_classes: Option<&[ClassData]>,
    code: &mut W,
) {
    let is_nested = is_inner_class(&class.class_type);

    // Package declaration (only for top-level classes)
    // Use pkg_alias from Kotlin metadata if available, otherwise extract from class_type
    if !is_nested {
        let pkg: Option<String> = class.pkg_alias.clone()
            .or_else(|| get_package(&class.class_type));
        if let Some(ref pkg) = pkg {
            code.add("package ").add(pkg).add(";").newline().newline();
        }
    }

    // Collect imports (used for both import statements and short name resolution)
    // Also collect from nested inner classes
    let (imports, current_package) = if config.use_imports && !is_nested {
        let mut collector = ImportCollector::new(&class.class_type);

        // Clone of JADX ClassGen.checkInnerCollision()
        // Reference: jadx-core/src/main/java/jadx/core/codegen/ClassGen.java:785-802
        // Register inner class names to prevent import collisions
        if let Some(nested) = nested_inner_classes {
            for inner in nested {
                collector.add_inner_class_name(&inner.class_type);
            }
        }

        collector.collect_from_class_with_dex(class, dex_info.as_ref());
        // Collect imports from nested inner classes too
        if let Some(nested) = nested_inner_classes {
            for inner in nested {
                collector.collect_from_class_with_dex(inner, dex_info.as_ref());
            }
        }
        // P0-C01 fix: Use non-conflicting imports for type resolution
        (Some(collector.get_non_conflicting_imports()), collector.current_package.clone())
    } else {
        (None, None)
    };

    // Generate import statements (only for top-level classes)
    if !is_nested {
        if let Some(ref imp) = imports {
            if !imp.is_empty() {
                for name in imp {
                    // Replace / with . for package separators
                    // Replace $ with . for inner classes (Build$VERSION -> Build.VERSION), but preserve $$
                    let import_name = replace_inner_class_separator(&name.replace('/', "."));
                    code.add("import ").add(&import_name).add(";").newline();
                }
                code.newline();
            }
        }
    }

    // Class declaration (use simple names when imports available)
    add_class_declaration(class, imports.as_ref(), config.comments_level, code);

    // Class body
    code.add(" {").newline();
    code.inc_indent();

    // Fields (use simple names when imports available, pass dex_info for enum string lookup)
    add_fields(class, imports.as_ref(), current_package.as_deref(), config.escape_unicode, dex_info.as_ref(), config.comments_level, code);

    // Nested inner classes (generated after fields, before methods for Java convention)
    if let Some(nested) = nested_inner_classes {
        add_nested_inner_classes(nested, config, imports.as_ref(), dex_info.clone(), inner_classes, code);
    }

    // Methods (pass DEX info for name resolution in method bodies)
    // inner_classes uses Arc<ClassData> to avoid cloning - O(1) reference count increment
    add_methods_with_inner_classes(class, config, imports.as_ref(), dex_info, inner_classes, code);

    code.dec_indent();
    code.start_line().add("}").newline();
}

/// Add nested inner class declarations
fn add_nested_inner_classes<W: CodeWriter>(
    nested_classes: &[ClassData],
    config: &ClassGenConfig,
    imports: Option<&BTreeSet<String>>,
    dex_info: Option<std::sync::Arc<dyn DexInfoProvider>>,
    inner_classes: Option<&HashMap<String, std::sync::Arc<ClassData>>>,
    code: &mut W,
) {
    for inner_class in nested_classes {
        // Skip anonymous inner classes (they should be inlined at instantiation site)
        // EXCEPT for switch map synthetic classes which contain static switch map arrays
        // that need to be generated as inner classes (BUG-001 fix)
        if is_anonymous_class(&inner_class.class_type) && !is_switch_map_class(inner_class) {
            continue;
        }
        code.newline();
        // Generate the inner class declaration (recursively handles its own inner classes)
        add_inner_class_declaration(inner_class, config, imports, dex_info.clone(), inner_classes, code);
    }
}

/// Add a single inner class declaration (used for nested inner classes)
fn add_inner_class_declaration<W: CodeWriter>(
    class: &ClassData,
    config: &ClassGenConfig,
    imports: Option<&BTreeSet<String>>,
    dex_info: Option<std::sync::Arc<dyn DexInfoProvider>>,
    inner_classes: Option<&HashMap<String, std::sync::Arc<ClassData>>>,
    code: &mut W,
) {
    // Emit class-level annotations
    for annotation in &class.annotations {
        if should_emit_annotation(annotation) {
            code.start_line();
            generate_annotation(annotation, code);
            code.newline();
        }
    }

    // Get inner class simple name (after the last $)
    let simple_name = get_inner_class_simple_name(&class.class_type);

    let mut flags = class.access_flags;

    // Interfaces are implicitly abstract and static
    if access_flags::is_interface(flags) {
        flags &= !(access_flags::flags::ACC_ABSTRACT | access_flags::flags::ACC_STATIC);
    }
    // Enums are implicitly final and static (for inner enums)
    if access_flags::is_enum(flags) {
        flags &= !(access_flags::flags::ACC_FINAL | access_flags::flags::ACC_ABSTRACT | access_flags::flags::ACC_STATIC);
    }

    // Modifiers
    code.start_line();
    let mods = access_flags::access_flags_to_string(flags, AccessContext::Class);
    if !mods.is_empty() {
        code.add(&mods);
    }

    // Class type keyword
    let keyword = access_flags::class_type_keyword(class.access_flags);
    code.add(keyword).add(" ");

    // Class name (simple name for inner classes)
    code.add(&simple_name);

    // Get current package for simple type names
    let pkg = get_package(&class.class_type);

    // Generic type parameters (e.g., <T, E extends Number>)
    // Like JADX's ClassGen.addGenericTypeParameters() - needed for inner interfaces/classes
    generate_type_parameters(&class.type_parameters, imports, pkg.as_deref(), code);

    // Extends
    if let Some(ref superclass) = class.superclass {
        // Don't show "extends Object"
        // Don't show "extends Enum" for enum types (implicit in Java)
        if superclass != "java/lang/Object"
            && !(access_flags::is_annotation(class.access_flags) && superclass == "java/lang/annotation/Annotation")
            && !(access_flags::is_enum(class.access_flags) && (superclass == "java/lang/Enum" || superclass == "Ljava/lang/Enum;")) {
            code.add(" extends ");
            // Use superclass_type with generics if available, otherwise fall back to plain Object type
            let ty = class.superclass_type.clone().unwrap_or_else(|| ArgType::Object(superclass.clone()));
            code.add(&type_to_string_with_imports_and_package(&ty, imports, pkg.as_deref()));
        }
    }

    // Implements (skip entirely for annotations)
    if !class.interfaces.is_empty() && !access_flags::is_annotation(class.access_flags) {
        if access_flags::is_interface(class.access_flags) {
            code.add(" extends ");
        } else {
            code.add(" implements ");
        }
        let ifaces: Vec<_> = class
            .interfaces
            .iter()
            .map(|ty| type_to_string_with_imports_and_package(ty, imports, pkg.as_deref()))
            .collect();
        code.add(&ifaces.join(", "));
    }

    // Class body
    code.add(" {").newline();
    code.inc_indent();

    // Fields (pass dex_info for enum string lookup)
    add_fields(class, imports, pkg.as_deref(), config.escape_unicode, dex_info.as_ref(), config.comments_level, code);

    // Methods
    add_methods_with_inner_classes(class, config, imports, dex_info, inner_classes, code);

    code.dec_indent();
    code.start_line().add("}").newline();
}

/// Get the simple name of an inner class (the part after the last $)
///
/// Examples:
/// - "Lcom/example/Outer$Inner;" -> "Inner"
/// - "Lcom/example/Outer$1;" -> "AnonymousClass1" (anonymous classes get prefix to be valid Java)
/// - "com/example/Outer$Inner" -> "Inner"
pub fn get_inner_class_simple_name(class_type: &str) -> String {
    let stripped = class_type
        .strip_prefix('L')
        .unwrap_or(class_type)
        .strip_suffix(';')
        .unwrap_or(class_type);

    let simple = if let Some(dollar_pos) = stripped.rfind('$') {
        &stripped[dollar_pos + 1..]
    } else if let Some(slash_pos) = stripped.rfind('/') {
        &stripped[slash_pos + 1..]
    } else {
        stripped
    };

    // If the name starts with a digit (e.g., "1" from "$1"), it's not a valid Java identifier.
    // Prefix with "AnonymousClass" to make it valid, matching JADX's behavior.
    if simple.chars().next().map(|c| c.is_ascii_digit()).unwrap_or(false) {
        format!("AnonymousClass{}", simple)
    } else {
        simple.to_string()
    }
}

use crate::type_gen::{type_to_string_with_imports, type_to_string_with_imports_and_package};

/// Add a rename comment if the entity was renamed during deobfuscation
/// JADX Clone: jadx-core/src/main/java/jadx/core/dex/attributes/RenameReasonAttr.java:31-50
fn add_renamed_comment<W: CodeWriter>(code: &mut W, original_name: &str, comments_level: CommentsLevel) {
    add_renamed_comment_with_reasons(code, original_name, &[], comments_level)
}

/// Add a rename comment with reasons (JADX parity)
/// JADX Clone: RenameReasonAttr.buildReason() joins reasons with " and "
fn add_renamed_comment_with_reasons<W: CodeWriter>(
    code: &mut W,
    original_name: &str,
    reasons: &[String],
    comments_level: CommentsLevel,
) {
    if !comments_level.show_info() {
        return;
    }
    code.start_line()
        .add("/* renamed from: ")
        .add(original_name);
    if !reasons.is_empty() {
        // JADX Clone: "reason: " + String.join(" and ", reasons)
        code.add(", reason: ");
        code.add(&reasons.join(" and "));
    }
    code.add(" */")
        .newline();
}

/// Add class declaration (modifiers, name, extends, implements)
fn add_class_declaration<W: CodeWriter>(class: &ClassData, imports: Option<&BTreeSet<String>>, comments_level: CommentsLevel, code: &mut W) {
    // Add "compiled from" comment for top-level classes when source file differs from class name (INFO level)
    // Matches JADX's CodeGenUtils.addSourceFileInfo() logic exactly
    if !is_inner_class(&class.class_type) && comments_level.show_info() {
        if let Some(ref source_file) = class.source_file {
            let class_name = class.simple_name();
            // JADX: if (topClsName.contains(fileName)) { return; }
            // JADX keeps the extension (e.g., "Keep.java") in the contains check
            // "Keep".contains("Keep.java") = false, so comment IS emitted
            // This effectively means comment is always emitted for INFO level
            if !class_name.contains(source_file.as_str()) {
                code.start_line()
                    .add("/* compiled from: ")
                    .add(source_file)
                    .add(" */")
                    .newline();
            }
        }
    }

    // Emit class-level annotations (JADX puts these between "compiled from" and "loaded from")
    for annotation in &class.annotations {
        if should_emit_annotation(annotation) {
            generate_annotation(annotation, code);
            code.newline();
        }
    }

    // Add "loaded from" comment for top-level classes (INFO level)
    // JADX puts this after annotations, right before class declaration
    if !is_inner_class(&class.class_type) && comments_level.show_info() {
        let dex_name = class.dex_name.as_deref().unwrap_or("classes.dex");
        code.start_line()
            .add("/* loaded from: ")
            .add(dex_name)
            .add(" */")
            .newline();
    }

    // Add rename comment if class was renamed during deobfuscation (INFO level)
    // JADX Clone: Include rename reasons from Kotlin metadata, SMAP, etc.
    if let Some(ref alias) = class.alias {
        if alias != &class.simple_name() {
            add_renamed_comment_with_reasons(code, &class.simple_name(), &class.rename_reasons, comments_level);
        }
    }

    let mut flags = class.access_flags;

    // Interfaces are implicitly abstract and static
    if access_flags::is_interface(flags) {
        flags &= !(access_flags::flags::ACC_ABSTRACT | access_flags::flags::ACC_STATIC);
    }
    // Enums are implicitly final and static (for inner enums)
    if access_flags::is_enum(flags) {
        flags &= !(access_flags::flags::ACC_FINAL | access_flags::flags::ACC_ABSTRACT | access_flags::flags::ACC_STATIC);
    }

    // Java access modifiers (public, final, etc.)
    let mods = access_flags::access_flags_to_string(flags, AccessContext::Class);
    if !mods.is_empty() {
        code.add(&mods);
    }

    // Kotlin class modifiers (emitted as comments for Java output)
    // These appear after Java modifiers, like JADX's kotlin-metadata plugin
    // Format: "public final /* data */ class ClassName"
    let mut kotlin_class_mods = Vec::new();
    if class.is_data_class() {
        kotlin_class_mods.push("data");
    }
    if class.is_sealed_class() {
        kotlin_class_mods.push("sealed");
    }
    if class.is_inline_class() {
        kotlin_class_mods.push("value");
    }
    if !kotlin_class_mods.is_empty() {
        code.add("/* ").add(&kotlin_class_mods.join(" ")).add(" */ ");
    }

    // Class type keyword
    let keyword = access_flags::class_type_keyword(class.access_flags);
    code.add(keyword).add(" ");

    // Class name (use alias if available from deobfuscation)
    code.add(class.display_name());

    // Get current package for simple type names
    let pkg = get_package(&class.class_type);

    // Generic type parameters (e.g., <T, E extends Number>)
    // Like JADX's ClassGen.addGenericTypeParameters() at line 203
    generate_type_parameters(&class.type_parameters, imports, pkg.as_deref(), code);

    // Extends
    if let Some(ref superclass) = class.superclass {
        // Don't show "extends Object"
        // Don't show "extends Annotation" for annotation types (implicit in Java)
        // Don't show "extends Enum" for enum types (implicit in Java)
        if superclass != "java/lang/Object"
            && !(access_flags::is_annotation(class.access_flags) && superclass == "java/lang/annotation/Annotation")
            && !(access_flags::is_enum(class.access_flags) && (superclass == "java/lang/Enum" || superclass == "Ljava/lang/Enum;")) {
            code.add(" extends ");
            // Use superclass_type with generics if available, otherwise fall back to plain Object type
            let ty = class.superclass_type.clone().unwrap_or_else(|| ArgType::Object(superclass.clone()));
            code.add(&type_to_string_with_imports_and_package(&ty, imports, pkg.as_deref()));
        }
    }

    // Implements (skip entirely for annotations - they can't implement interfaces)
    if !class.interfaces.is_empty() && !access_flags::is_annotation(class.access_flags) {
        if access_flags::is_interface(class.access_flags) {
            code.add(" extends ");
        } else {
            code.add(" implements ");
        }
        let ifaces: Vec<_> = class
            .interfaces
            .iter()
            .map(|ty| type_to_string_with_imports_and_package(ty, imports, pkg.as_deref()))
            .collect();
        code.add(&ifaces.join(", "));
    }
}

/// JADX parity: Compute collision-resolved field names
/// Returns a Vec of (resolved_name, original_name, rename_reason) for each field in order
/// Uses JADX's f{index}{name} pattern for colliding fields
fn compute_field_collision_renames(fields: &[&FieldData]) -> Vec<(String, String, Option<String>)> {
    use std::collections::HashSet;

    let mut result = Vec::with_capacity(fields.len());
    let mut used_names: HashSet<String> = HashSet::new();
    let mut field_index: u32 = 0;

    for field in fields {
        let original_name = field.display_name().to_string();

        if used_names.insert(original_name.clone()) {
            // First occurrence - use original name, no rename reason
            result.push((original_name.clone(), original_name, None));
        } else {
            // Collision - use JADX pattern: f{index}{name}
            let new_name = format!("f{}{}", field_index, original_name);
            result.push((new_name, original_name, Some("collision with other field name".to_string())));
        }
        field_index += 1;
    }

    result
}

/// Add field declarations
fn add_fields<W: CodeWriter>(
    class: &ClassData,
    imports: Option<&BTreeSet<String>>,
    current_package: Option<&str>,
    escape_unicode: bool,
    dex_info: Option<&std::sync::Arc<dyn DexInfoProvider>>,
    comments_level: CommentsLevel,
    code: &mut W,
) {
    let is_enum = class.is_enum();

    // For enum classes, generate proper enum constant declarations
    if is_enum {
        // Analyze the enum to extract constant info with string lookup
        let enum_info = if let Some(dex) = dex_info {
            let dex_clone = dex.clone();
            dexterity_passes::analyze_enum_class_with_strings(
                class,
                Some(move |idx: u32| dex_clone.get_string(idx)),
            )
        } else {
            dexterity_passes::analyze_enum_class(class)
        };

        if let Some(info) = enum_info {
            add_enum_constants(class, &info, code);
        } else {
            // Fallback: generate enum constants without arguments
            add_enum_constants_fallback(class, code);
        }

        // Generate instance fields (not static enum fields or synthetic inner class fields)
        // JADX parity: Filter synthetic fields like this$0, val$
        let instance_fields: Vec<_> = class.instance_fields.iter()
            .filter(|f| !is_enum_synthetic_field(f, is_enum) && !is_inner_class_synthetic_field(f))
            .collect();

        if !instance_fields.is_empty() {
            code.newline();
            // JADX parity: Compute collision-resolved names for enum instance fields
            let renames = compute_field_collision_renames(&instance_fields);
            for (i, field) in instance_fields.iter().enumerate() {
                let (ref resolved_name, ref _original, ref reason) = renames[i];
                let name_override = reason.as_ref().map(|_| resolved_name.as_str());
                let reason_str = reason.as_ref().map(|s| s.as_str());
                add_field(field, imports, current_package, escape_unicode, comments_level, name_override, reason_str, code);
            }
        }
        return;
    }

    // Non-enum class: regular field generation
    // JADX parity: Filter out synthetic fields (enum $VALUES, inner class this$0, val$)
    // Reference: ClassModifier.java:80-110 - removeSyntheticFields()
    let static_fields: Vec<_> = class.static_fields.iter()
        .filter(|f| !is_enum_synthetic_field(f, is_enum) && !is_inner_class_synthetic_field(f))
        .collect();
    let instance_fields: Vec<_> = class.instance_fields.iter()
        .filter(|f| !is_enum_synthetic_field(f, is_enum) && !is_inner_class_synthetic_field(f))
        .collect();

    let has_fields = !static_fields.is_empty() || !instance_fields.is_empty();

    if has_fields {
        code.newline();
    }

    // JADX parity: Compute collision-resolved names for all fields
    let all_fields: Vec<_> = static_fields.iter().chain(instance_fields.iter()).copied().collect();
    let renames = compute_field_collision_renames(&all_fields);

    // Static fields first
    for (i, field) in static_fields.iter().enumerate() {
        let (ref resolved_name, ref _original, ref reason) = renames[i];
        let name_override = reason.as_ref().map(|_| resolved_name.as_str());
        let reason_str = reason.as_ref().map(|s| s.as_str());
        add_field(field, imports, current_package, escape_unicode, comments_level, name_override, reason_str, code);
    }

    // Instance fields
    let offset = static_fields.len();
    for (i, field) in instance_fields.iter().enumerate() {
        let (ref resolved_name, ref _original, ref reason) = renames[offset + i];
        let name_override = reason.as_ref().map(|_| resolved_name.as_str());
        let reason_str = reason.as_ref().map(|s| s.as_str());
        add_field(field, imports, current_package, escape_unicode, comments_level, name_override, reason_str, code);
    }
}

/// Generate enum constant declarations in proper Java syntax
/// e.g., VERBOSE(2), DEBUG(3), INFO(4);
fn add_enum_constants<W: CodeWriter>(
    _class: &ClassData,
    enum_info: &dexterity_passes::EnumClassInfo,
    code: &mut W,
) {
    if enum_info.fields.is_empty() {
        return;
    }

    code.newline();

    for (i, field_info) in enum_info.fields.iter().enumerate() {
        code.start_line();
        code.add(&field_info.name);

        // Add constructor arguments if any (beyond implicit name and ordinal)
        if !field_info.extra_args.is_empty() {
            code.add("(");
            for (j, arg) in field_info.extra_args.iter().enumerate() {
                if j > 0 {
                    code.add(", ");
                }
                code.add(&enum_arg_to_string(arg));
            }
            code.add(")");
        }

        // Add comma or semicolon
        if i < enum_info.fields.len() - 1 {
            code.add(",");
        } else {
            code.add(";");
        }
        code.newline();
    }
}

/// Fallback enum constant generation when analysis fails
/// Just outputs the constant names without arguments
fn add_enum_constants_fallback<W: CodeWriter>(class: &ClassData, code: &mut W) {
    // Normalize class type (strip L prefix and ; suffix for comparison)
    let class_type_normalized = class.class_type
        .strip_prefix('L')
        .unwrap_or(&class.class_type)
        .strip_suffix(';')
        .unwrap_or(&class.class_type);

    // Find enum constant fields (static fields with type matching the enum)
    let enum_fields: Vec<_> = class.static_fields.iter()
        .filter(|f| {
            // Check if field type matches enum class type
            // ArgType::Object stores names without L prefix and ; suffix
            if let ArgType::Object(ref obj_type) = f.field_type {
                obj_type == class_type_normalized
            } else {
                false
            }
        })
        .filter(|f| !f.name.starts_with('$')) // Skip $VALUES
        .collect();

    if enum_fields.is_empty() {
        return;
    }

    code.newline();

    for (i, field) in enum_fields.iter().enumerate() {
        code.start_line();
        code.add(field.display_name());

        // Add comma or semicolon
        if i < enum_fields.len() - 1 {
            code.add(",");
        } else {
            code.add(";");
        }
        code.newline();
    }
}

/// Convert an EnumArg to a string representation
fn enum_arg_to_string(arg: &dexterity_passes::EnumArg) -> String {
    use dexterity_passes::EnumArg;
    match arg {
        EnumArg::Int(n) => n.to_string(),
        EnumArg::Float(f) => {
            // Check if it's a whole number that needs 'd' suffix for double
            if f.fract() == 0.0 && *f >= i64::MIN as f64 && *f <= i64::MAX as f64 {
                format!("{}.0d", *f as i64)
            } else {
                format!("{}d", f)
            }
        }
        EnumArg::Bool(b) => if *b { "true" } else { "false" }.to_string(),
        EnumArg::String(s) => crate::type_gen::escape_string(s),
        EnumArg::Null => "null".to_string(),
        EnumArg::EnumRef(name) => name.clone(),
        EnumArg::Other => "/* unknown */".to_string(),
    }
}

/// Add a single field declaration
/// Optional name_override and rename_reason for collision handling
fn add_field<W: CodeWriter>(
    field: &FieldData,
    imports: Option<&BTreeSet<String>>,
    current_package: Option<&str>,
    escape_unicode: bool,
    comments_level: CommentsLevel,
    name_override: Option<&str>,
    rename_reason: Option<&str>,
    code: &mut W,
) {
    // Emit field annotations
    for annotation in &field.annotations {
        if should_emit_annotation(annotation) {
            code.start_line();
            generate_annotation(annotation, code);
            code.newline();
        }
    }

    // Add rename comment if field was renamed during deobfuscation (INFO level)
    // or if renamed due to collision
    if let Some(reason) = rename_reason {
        // JADX parity: /* renamed from: X, reason: collision with other field name */
        if comments_level.show_info() {
            code.start_line()
                .add("/* renamed from: ")
                .add(field.display_name())
                .add(", reason: ")
                .add(reason)
                .add(" */")
                .newline();
        }
    } else if let Some(ref alias) = field.alias {
        if alias != &field.name {
            // JADX Clone: Include rename reasons from Kotlin metadata, toString parsing, etc.
            add_renamed_comment_with_reasons(code, &field.name, &field.rename_reasons, comments_level);
        }
    }

    code.start_line();

    // Modifiers
    let mods = access_flags::access_flags_to_string(field.access_flags, AccessContext::Field);
    if !mods.is_empty() {
        code.add(&mods);
    }

    // Clone of JADX ClassGen.java - synthetic field comment (CG-019)
    // Reference: jadx-core/src/main/java/jadx/core/codegen/ClassGen.java
    // JADX adds /* synthetic */ inline for fields with ACC_SYNTHETIC flag
    if access_flags::is_synthetic(field.access_flags) {
        code.add("/* synthetic */ ");
    }

    // Type (use simple name if imported or same package)
    code.add(&type_to_string_with_imports_and_package(&field.field_type, imports, current_package));
    code.add(" ");

    // Name (use override if provided, else alias if available from deobfuscation)
    if let Some(name) = name_override {
        code.add(name);
    } else {
        code.add(field.display_name());
    }

    // Initial value
    // Clone of JADX ClassGen.java - field initialization handling (GAP-04)
    // Reference: jadx-core/src/main/java/jadx/core/codegen/ClassGen.java
    // For static final primitive fields with no explicit init value, JADX adds the default.
    // This makes the output compilable and matches Java semantics where static finals must be initialized.
    if let Some(ref value) = field.initial_value {
        code.add(" = ");
        add_field_value(value, &field.field_type, escape_unicode, code);
    } else if access_flags::is_static(field.access_flags) && access_flags::is_final(field.access_flags) {
        // Static final field with no init value - add default for primitive types
        if let Some(default_value) = get_primitive_default_value(&field.field_type) {
            code.add(" = ");
            code.add(default_value);
        }
    }

    code.add(";").newline();
}

/// Add field initial value
fn add_field_value<W: CodeWriter>(value: &FieldValue, field_type: &dexterity_ir::ArgType, escape_unicode: bool, code: &mut W) {
    match value {
        FieldValue::Byte(v) => code.add(&literal_to_string(*v as i64, &dexterity_ir::ArgType::Byte)),
        FieldValue::Short(v) => code.add(&literal_to_string(*v as i64, &dexterity_ir::ArgType::Short)),
        FieldValue::Char(v) => code.add(&literal_to_string(*v as i64, &dexterity_ir::ArgType::Char)),
        FieldValue::Int(v) => code.add(&literal_to_string(*v as i64, &dexterity_ir::ArgType::Int)),
        FieldValue::Long(v) => code.add(&literal_to_string(*v, &dexterity_ir::ArgType::Long)),
        FieldValue::Float(v) => code.add(&format!("{}f", v)),
        FieldValue::Double(v) => code.add(&format!("{}d", v)),
        FieldValue::String(s) => code.add(&crate::type_gen::escape_string_with_unicode(s, escape_unicode)),
        FieldValue::Type(t) => {
            code.add(&type_to_string(&dexterity_ir::ArgType::Object(t.clone())));
            code.add(".class")
        }
        FieldValue::Boolean(b) => code.add(if *b { "true" } else { "false" }),
        FieldValue::Null => code.add("null"),
        FieldValue::Array(values) => {
            // Get element type from field type
            let elem_type = match field_type {
                dexterity_ir::ArgType::Array(inner) => inner.as_ref().clone(),
                _ => dexterity_ir::ArgType::Unknown,
            };
            code.add("{");
            for (i, v) in values.iter().enumerate() {
                if i > 0 {
                    code.add(", ");
                }
                add_field_value(v, &elem_type, escape_unicode, code);
            }
            code.add("}")
        }
        FieldValue::Enum(class_name, field_name) => {
            // Format: ClassName.FIELD_NAME
            let simple_name = class_name.rsplit('/').next().unwrap_or(class_name);
            code.add(simple_name);
            code.add(".");
            code.add(field_name)
        }
        FieldValue::Field(class_name, field_name) => {
            // Format: ClassName.fieldName
            let simple_name = class_name.rsplit('/').next().unwrap_or(class_name);
            code.add(simple_name);
            code.add(".");
            code.add(field_name)
        }
        FieldValue::NewInstance(class_name, args) => {
            // Format: new ClassName(args...) - for static field initialization
            // Clone of JADX FieldInitInsnAttr rendering
            // Reference: jadx-fast/jadx-core/src/main/java/jadx/core/dex/visitors/ExtractFieldInit.java:387-396
            // P0-TYPO01 fix: Strip L prefix and ; suffix BEFORE splitting on '/'
            let stripped = class_name.strip_prefix('L').unwrap_or(class_name);
            let stripped = stripped.strip_suffix(';').unwrap_or(stripped);
            let simple_name = stripped.rsplit('/').next().unwrap_or(stripped);
            code.add("new ");
            code.add(simple_name);
            code.add("(");
            for (i, arg) in args.iter().enumerate() {
                if i > 0 {
                    code.add(", ");
                }
                // Recursively render each constructor argument
                // Pass Unknown type - the arg type is determined by the FieldValue variant
                add_field_value(arg, &dexterity_ir::ArgType::Unknown, escape_unicode, code);
            }
            code.add(")")
        }
    };
}

/// Get the default initialization value for primitive types
/// Clone of JADX TypeGen.literalToString behavior for null/default values (GAP-04)
/// Reference: jadx-core/src/main/java/jadx/core/codegen/TypeGen.java
fn get_primitive_default_value(field_type: &dexterity_ir::ArgType) -> Option<&'static str> {
    match field_type {
        dexterity_ir::ArgType::Boolean => Some("false"),
        dexterity_ir::ArgType::Byte => Some("0"),
        dexterity_ir::ArgType::Char => Some("'\\u0000'"),
        dexterity_ir::ArgType::Short => Some("0"),
        dexterity_ir::ArgType::Int => Some("0"),
        dexterity_ir::ArgType::Long => Some("0L"),
        dexterity_ir::ArgType::Float => Some("0.0f"),
        dexterity_ir::ArgType::Double => Some("0.0d"),
        _ => None, // Object/array types don't get default values
    }
}

/// Check if a method is a default constructor (just calls super(), no other code)
/// These are implicit in Java and can be omitted for cleaner output
///
/// JADX Parity: Only skip public default constructors, not private/protected ones.
/// Private no-arg constructors (like in singletons) must be shown explicitly.
/// Reference: jadx-core/src/main/java/jadx/core/codegen/MethodGen.java
fn is_default_constructor(method: &dexterity_ir::MethodData) -> bool {
    // Must be a constructor
    if !method.is_constructor() {
        return false;
    }

    // JADX Parity: Only skip PUBLIC default constructors
    // Private/protected constructors must always be shown (e.g., singletons, utility classes)
    // Java only implicitly generates public default constructors
    if !access_flags::is_public(method.access_flags) {
        return false;
    }

    // Must have no declared parameters (excluding 'this')
    if !method.arg_types.is_empty() {
        return false;
    }

    // Check instructions: should only be invoke-direct <init> on super and return
    // A default constructor typically has 2-3 instructions:
    // 1. invoke-direct {v0}, Ljava/lang/Object;-><init>()V  (or similar super call)
    // 2. return-void
    // May also have a const for literal 0 or similar
    let insns = match method.instructions() {
        Some(i) => i,
        None => return false, // Can't check without instructions
    };
    let insn_count = insns.len();
    if insn_count > 3 {
        return false;
    }

    // Check that instructions are just invoke-direct super() and return
    use dexterity_ir::instructions::{InsnType, InvokeKind};
    let mut has_super_init = false;
    let mut has_return = false;

    for insn in insns {
        match &insn.insn_type {
            InsnType::Invoke { kind: InvokeKind::Direct | InvokeKind::Super, .. } => {
                // This is likely the super() call
                has_super_init = true;
            }
            InsnType::Return { value: None } => {
                has_return = true;
            }
            InsnType::Nop => {
                // Ignore nops
            }
            _ => {
                // Any other instruction means this is not a default constructor
                return false;
            }
        }
    }

    has_super_init && has_return
}

/// Check if a method is a synthetic enum method that should be filtered
/// Enums have auto-generated values(), valueOf(), <clinit>, and constructor methods
fn is_enum_synthetic_method(method: &dexterity_ir::MethodData, is_enum_class: bool) -> bool {
    if !is_enum_class {
        return false;
    }

    // Check for values() method: public static EnumType[] values()
    if method.name == "values" && method.arg_types.is_empty() {
        // Should have array return type matching enum
        return true;
    }

    // Check for valueOf() method: public static EnumType valueOf(String)
    if method.name == "valueOf" && method.arg_types.len() == 1 {
        if let dexterity_ir::ArgType::Object(name) = &method.arg_types[0] {
            if name == "java/lang/String" {
                return true;
            }
        }
    }

    // Check for <clinit> (static initializer) - enum constants are already generated
    if method.is_class_init() {
        return true;
    }

    // Check for enum constructor: private <init>(String, int)
    if method.is_constructor() {
        // Enum constructors have (String name, int ordinal, ...) parameters
        // The first two args are the implicit name and ordinal
        if method.arg_types.len() >= 2 {
            let first_is_string = matches!(&method.arg_types[0], dexterity_ir::ArgType::Object(n) if n == "java/lang/String");
            let second_is_int = matches!(&method.arg_types[1], dexterity_ir::ArgType::Int);
            if first_is_string && second_is_int {
                return true;
            }
        }
    }

    false
}

/// Check if a field is a synthetic enum field that should be filtered
/// Enums have auto-generated $VALUES field
fn is_enum_synthetic_field(field: &dexterity_ir::FieldData, is_enum_class: bool) -> bool {
    if !is_enum_class {
        return false;
    }

    // Filter $VALUES field (array holding all enum values)
    if field.name == "$VALUES" {
        return true;
    }

    false
}

/// Check if a field is a synthetic inner class field that should be filtered
///
/// JADX Reference: ClassModifier.java:80-110 - removeSyntheticFields()
/// Inner classes have synthetic fields for:
/// - Outer class reference: this$0, this$1, etc.
/// - Captured variables in anonymous classes: val$name
///
/// These are compiler-generated and should be hidden in decompiled output.
fn is_inner_class_synthetic_field(field: &dexterity_ir::FieldData) -> bool {
    // Must be synthetic
    if !access_flags::is_synthetic(field.access_flags) {
        return false;
    }

    // Filter this$N fields (outer class reference)
    // Pattern: this$0, this$1, etc.
    if field.name.starts_with("this$") {
        if let Some(suffix) = field.name.strip_prefix("this$") {
            if suffix.chars().all(|c| c.is_ascii_digit()) {
                return true;
            }
        }
    }

    // Filter val$name fields (captured variables in anonymous/local classes)
    // Pattern: val$someVariable
    if field.name.starts_with("val$") {
        return true;
    }

    false
}

/// Add method declarations
#[allow(dead_code)]
fn add_methods<W: CodeWriter>(class: &ClassData, config: &ClassGenConfig, code: &mut W) {
    add_methods_with_dex(class, config, None, None, code)
}

/// Add method declarations with DEX info for name resolution
fn add_methods_with_dex<W: CodeWriter>(
    class: &ClassData,
    config: &ClassGenConfig,
    imports: Option<&BTreeSet<String>>,
    dex_info: Option<std::sync::Arc<dyn DexInfoProvider>>,
    code: &mut W,
) {
    add_methods_with_inner_classes(class, config, imports, dex_info, None, code)
}

/// Add method declarations with inner classes for anonymous class inlining
///
/// Methods are sorted by their source line number to match JADX's output ordering.
/// This ensures abstract methods, constructors, and other methods appear in the
/// same order as the original source code (like JADX's ClassGen.addInnerClsAndMethods).
fn add_methods_with_inner_classes<W: CodeWriter>(
    class: &ClassData,
    config: &ClassGenConfig,
    imports: Option<&BTreeSet<String>>,
    dex_info: Option<std::sync::Arc<dyn DexInfoProvider>>,
    inner_classes: Option<&HashMap<String, std::sync::Arc<ClassData>>>,
    code: &mut W,
) {
    use crate::method_gen::generate_method_with_inner_classes;
    use dexterity_ir::MethodInlineAttr;

    let is_enum = class.is_enum();

    // P1-LAMBDA-FIX: Collect synthetic lambda methods BEFORE filtering them out
    // These need to be available for inlining into invoke-custom instructions.
    // JADX Ref: CustomLambdaCall.java:94-103 - synthetic same-class methods get inlined
    let lambda_methods: HashMap<String, std::sync::Arc<dexterity_ir::MethodData>> = class.methods.iter()
        .filter(|m| m.dont_generate && (m.name.starts_with("lambda$") ||
                    (crate::access_flags::is_synthetic(m.access_flags) && m.name.contains("$"))))
        .map(|m| (m.name.clone(), std::sync::Arc::new((*m).clone())))
        .collect();

    // Collect methods that should be generated, filtering out skipped ones
    let mut methods_to_generate: Vec<&dexterity_ir::MethodData> = class.methods.iter()
        .filter(|method| {
            // P1-LAMBDA: Skip methods marked for non-generation (e.g., synthetic lambda methods)
            // JADX Ref: AFlag.DONT_GENERATE - used for inlined synthetic methods
            if method.dont_generate {
                return false;
            }
            // Skip default constructors that just call super() - implicit in Java
            if is_default_constructor(method) {
                return false;
            }
            // Skip synthetic bridge methods (compiler-generated for covariant return types)
            // These just delegate to another overloaded method and look like infinite recursion
            // when decompiled (e.g., `return clone();` calling the other clone() method)
            if access_flags::is_synthetic(method.access_flags) && access_flags::is_bridge(method.access_flags) {
                return false;
            }
            // Skip synthetic enum methods (values(), valueOf(), enum constructors)
            if is_enum_synthetic_method(method, is_enum) {
                return false;
            }
            // Skip synthetic methods that will be inlined (when inline_methods is enabled)
            if config.inline_methods {
                if let Some(ref attr) = method.inline_attr {
                    match attr {
                        MethodInlineAttr::FieldGet { .. }
                        | MethodInlineAttr::FieldSet { .. }
                        | MethodInlineAttr::MethodCall { .. } => return false,
                        MethodInlineAttr::NotNeeded => {}
                    }
                }
            }
            true
        })
        .collect();

    // Sort methods by source line number (like JADX's ClassGen.addInnerClsAndMethods)
    // This ensures methods appear in the same order as the original source code,
    // achieving JADX parity for method ordering including abstract method placement.
    methods_to_generate.sort_by_key(|method| method.source_line());

    let mut first_method = true;
    for method in methods_to_generate {
        // Add blank line between methods, but not before the first method (unless there are fields)
        if !first_method {
            code.newline();
        }
        first_method = false;
        // P1-LAMBDA-FIX: Pass lambda_methods for inlining synthetic lambda$ methods
        let lambda_ref = if lambda_methods.is_empty() { None } else { Some(&lambda_methods) };
        generate_method_with_inner_classes(method, class, config.fallback, imports, dex_info.clone(), inner_classes, lambda_ref, config.hierarchy.as_deref(), config.deobf_min_length, config.deobf_max_length, &*config.res_names, config.replace_consts, config.comments_level, config.add_debug_lines, code);
    }
}

#[cfg(test)]
mod tests {
    use super::*;
    use dexterity_ir::ArgType;

    fn make_class(name: &str, flags: u32) -> ClassData {
        let mut class = ClassData::new(format!("L{};", name), flags);
        class.superclass = Some("java/lang/Object".to_string());
        class
    }

    #[test]
    fn test_simple_class() {
        let class = make_class("com/example/Foo", 0x0001); // public
        let config = ClassGenConfig::default();
        let code = generate_class(&class, &config);

        assert!(code.contains("package com.example;"));
        assert!(code.contains("public class Foo"));
    }

    #[test]
    fn test_interface() {
        let class = make_class("com/example/Bar", 0x0601); // public abstract interface
        let config = ClassGenConfig::default();
        let code = generate_class(&class, &config);

        assert!(code.contains("public interface Bar"));
        // Should NOT contain "abstract" for interface
        assert!(!code.contains("abstract interface"));
    }

    #[test]
    fn test_enum() {
        let class = make_class("com/example/MyEnum", 0x4011); // public final enum
        let config = ClassGenConfig::default();
        let code = generate_class(&class, &config);

        assert!(code.contains("public enum MyEnum"));
        // Should NOT contain "final" for enum
        assert!(!code.contains("final enum"));
    }

    #[test]
    fn test_with_field() {
        let mut class = make_class("com/example/Test", 0x0001);
        class.instance_fields.push(FieldData {
            name: "value".to_string(),
            alias: None,
            rename_reasons: Vec::new(),
            access_flags: 0x0002, // private
            field_type: ArgType::Int,
            initial_value: None,
            annotations: Vec::new(),
            dex_field_idx: None,
            use_in: Vec::new(),
            dont_generate: false,
        });
        let config = ClassGenConfig::default();
        let code = generate_class(&class, &config);

        assert!(code.contains("private int value;"));
    }

    #[test]
    fn test_with_static_final_field() {
        let mut class = make_class("com/example/Constants", 0x0001);
        class.static_fields.push(FieldData {
            name: "MAX_VALUE".to_string(),
            alias: None,
            rename_reasons: Vec::new(),
            access_flags: 0x0019, // public static final
            field_type: ArgType::Int,
            initial_value: Some(FieldValue::Int(100)),
            annotations: Vec::new(),
            dex_field_idx: None,
            use_in: Vec::new(),
            dont_generate: false,
        });
        let config = ClassGenConfig::default();
        let code = generate_class(&class, &config);

        assert!(code.contains("public static final int MAX_VALUE = 100;"));
    }

    #[test]
    fn test_implements() {
        let mut class = make_class("com/example/MyClass", 0x0001);
        class.interfaces.push(ArgType::Object("java/io/Serializable".to_string()));
        class.interfaces.push(ArgType::Object("java/lang/Cloneable".to_string()));
        let config = ClassGenConfig::default();
        let code = generate_class(&class, &config);

        // With imports enabled, should have import statements and short names
        assert!(code.contains("import java.io.Serializable;"));
        // Cloneable is in java.lang, so no import needed
        assert!(!code.contains("import java.lang.Cloneable;"));
    }

    #[test]
    fn test_import_collector_java_lang_not_imported() {
        let mut collector = ImportCollector::new("Lcom/example/Foo;");
        collector.add_internal_name("java/lang/String");
        collector.add_internal_name("java/lang/Object");
        collector.add_internal_name("java/lang/Integer");

        // java.lang.* should not be imported
        assert!(collector.get_imports().is_empty());
    }

    #[test]
    fn test_import_collector_same_package_not_imported() {
        let mut collector = ImportCollector::new("Lcom/example/Foo;");
        collector.add_internal_name("com/example/Bar");
        collector.add_internal_name("com/example/Baz");

        // Same package should not be imported
        assert!(collector.get_imports().is_empty());
    }

    #[test]
    fn test_import_collector_other_packages() {
        let mut collector = ImportCollector::new("Lcom/example/Foo;");
        collector.add_internal_name("java/io/File");
        collector.add_internal_name("android/os/Bundle");
        collector.add_internal_name("Landroid/view/View;"); // with L; wrapper

        let imports = collector.get_imports();
        assert!(imports.contains(&"android.os.Bundle".to_string()));
        assert!(imports.contains(&"android.view.View".to_string()));
        assert!(imports.contains(&"java.io.File".to_string()));
    }

    #[test]
    fn test_import_collector_array_types() {
        // Test that array type descriptors are properly stripped
        // This was a bug where "[Lio/grpc/q;" was being imported as "[Lio.grpc.q"
        // instead of "io.grpc.q"
        let mut collector = ImportCollector::new("Lcom/example/Foo;");

        // Single-dimensional object array
        collector.add_internal_name("[Lio/grpc/q;");
        // Multi-dimensional object array
        collector.add_internal_name("[[Ljava/util/List;");
        // Without L; wrapper
        collector.add_internal_name("[io/grpc/Status");
        // Primitive arrays should be ignored
        collector.add_internal_name("[I"); // int[]
        collector.add_internal_name("[[B"); // byte[][]

        let imports = collector.get_imports();

        // Should NOT contain array syntax in imports
        assert!(!imports.iter().any(|s| s.contains('[')), "Import should not contain '[': {:?}", imports);

        // Should contain the element types (without array brackets)
        assert!(imports.contains(&"io.grpc.q".to_string()));
        assert!(imports.contains(&"java.util.List".to_string()));
        assert!(imports.contains(&"io.grpc.Status".to_string()));

        // Primitive types should not be imported
        assert!(!imports.iter().any(|s| s == "I" || s == "B"), "Primitive types should not be imported");
    }

    #[test]
    fn test_import_collector_from_class() {
        let mut class = make_class("com/example/MyClass", 0x0001);
        class.superclass = Some("android/app/Activity".to_string());
        class.interfaces.push(ArgType::Object("java/io/Serializable".to_string()));
        class.instance_fields.push(FieldData {
            name: "view".to_string(),
            alias: None,
            rename_reasons: Vec::new(),
            access_flags: 0x0002,
            field_type: ArgType::Object("android/view/View".to_string()),
            initial_value: None,
            annotations: Vec::new(),
            dex_field_idx: None,
            use_in: Vec::new(),
            dont_generate: false,
        });

        let mut collector = ImportCollector::new(&class.class_type);
        collector.collect_from_class(&class);

        let imports = collector.get_imports();
        assert!(imports.contains(&"android.app.Activity".to_string()));
        assert!(imports.contains(&"android.view.View".to_string()));
        assert!(imports.contains(&"java.io.Serializable".to_string()));
    }

    #[test]
    fn test_import_collector_annotation_arguments() {
        // Test P2-MEDIUM fix: Missing Import Statements
        // Annotations like @Retention(RetentionPolicy.SOURCE) should import RetentionPolicy
        use dexterity_ir::info::{Annotation, AnnotationElement, AnnotationValue, AnnotationVisibility};

        let mut class = make_class("com/example/MyAnnotation", 0x2601); // interface + annotation

        // Add @Retention(RetentionPolicy.SOURCE) annotation
        class.annotations.push(Annotation {
            annotation_type: "java/lang/annotation/Retention".to_string(),
            visibility: AnnotationVisibility::Runtime,
            elements: vec![
                AnnotationElement {
                    name: "value".to_string(),
                    value: AnnotationValue::Enum(
                        "java/lang/annotation/RetentionPolicy".to_string(),
                        "SOURCE".to_string()
                    ),
                }
            ],
        });

        // Add @Target({ElementType.FIELD, ElementType.METHOD}) annotation
        class.annotations.push(Annotation {
            annotation_type: "java/lang/annotation/Target".to_string(),
            visibility: AnnotationVisibility::Runtime,
            elements: vec![
                AnnotationElement {
                    name: "value".to_string(),
                    value: AnnotationValue::Array(vec![
                        AnnotationValue::Enum(
                            "java/lang/annotation/ElementType".to_string(),
                            "FIELD".to_string()
                        ),
                        AnnotationValue::Enum(
                            "java/lang/annotation/ElementType".to_string(),
                            "METHOD".to_string()
                        ),
                    ]),
                }
            ],
        });

        let mut collector = ImportCollector::new(&class.class_type);
        collector.collect_from_class(&class);

        let imports = collector.get_imports();

        // Should import the annotation classes themselves (already worked before)
        assert!(imports.contains(&"java.lang.annotation.Retention".to_string()));
        assert!(imports.contains(&"java.lang.annotation.Target".to_string()));

        // Should import the enum types from annotation arguments (THIS IS THE FIX)
        assert!(imports.contains(&"java.lang.annotation.RetentionPolicy".to_string()),
                "RetentionPolicy should be imported (from @Retention argument)");
        assert!(imports.contains(&"java.lang.annotation.ElementType".to_string()),
                "ElementType should be imported (from @Target argument)");
    }

    #[test]
    fn test_import_collector_conflicting_simple_names() {
        // Test P0-C01 fix: Duplicate import names
        // When two types have the same simple name (e.g., f.a.a.a and f.a.b.a),
        // neither should be imported - use FQN instead
        let mut collector = ImportCollector::new("Lcom/example/Test;");

        // Add two types with conflicting simple name 'a'
        collector.add_internal_name("f/a/a/a");
        collector.add_internal_name("f/a/b/a");

        // Neither should be in the import list
        let imports = collector.get_imports();
        assert!(!imports.contains(&"f.a.a.a".to_string()),
                "f.a.a.a should NOT be imported (conflicts with f.a.b.a)");
        assert!(!imports.contains(&"f.a.b.a".to_string()),
                "f.a.b.a should NOT be imported (conflicts with f.a.a.a)");

        // The is_imported check should also return false
        assert!(!collector.is_imported("f/a/a/a"),
                "is_imported should return false for conflicting type");
        assert!(!collector.is_imported("f/a/b/a"),
                "is_imported should return false for conflicting type");

        // But non-conflicting types should still work
        collector.add_internal_name("f/a/c/unique");
        let imports = collector.get_imports();
        assert!(imports.contains(&"f.a.c.unique".to_string()),
                "unique should be imported (no conflicts)");
    }

    #[test]
    fn test_class_with_imports() {
        let mut class = make_class("com/example/MyClass", 0x0001);
        class.superclass = Some("android/app/Activity".to_string());
        class.instance_fields.push(FieldData {
            name: "view".to_string(),
            alias: None,
            rename_reasons: Vec::new(),
            access_flags: 0x0002,
            field_type: ArgType::Object("android/view/View".to_string()),
            initial_value: None,
            annotations: Vec::new(),
            dex_field_idx: None,
            use_in: Vec::new(),
            dont_generate: false,
        });

        let config = ClassGenConfig::default();
        let code = generate_class(&class, &config);

        assert!(code.contains("import android.app.Activity;"));
        assert!(code.contains("import android.view.View;"));
        // Imports should come before the class declaration
        let import_pos = code.find("import android.app.Activity;").unwrap();
        let class_pos = code.find("public class MyClass").unwrap();
        assert!(import_pos < class_pos);
    }

    // =====================
    // Inner Class Tests
    // =====================

    #[test]
    fn test_is_inner_class() {
        assert!(!is_inner_class("Lcom/example/Outer;"));
        assert!(is_inner_class("Lcom/example/Outer$Inner;"));
        assert!(is_inner_class("Lcom/example/Outer$1;"));
        assert!(is_inner_class("com/example/Outer$Inner"));
    }

    #[test]
    fn test_get_inner_class_info_named() {
        let info = get_inner_class_info("Lcom/example/Outer$Inner;").unwrap();
        assert_eq!(info.simple_name, "Inner");
        assert_eq!(info.outer_class, "Lcom/example/Outer;");
        assert_eq!(info.kind, InnerClassKind::Named);
    }

    #[test]
    fn test_get_inner_class_info_anonymous() {
        let info = get_inner_class_info("Lcom/example/Outer$1;").unwrap();
        assert_eq!(info.simple_name, "1");
        assert_eq!(info.outer_class, "Lcom/example/Outer;");
        assert_eq!(info.kind, InnerClassKind::Anonymous);
    }

    #[test]
    fn test_get_inner_class_info_lambda() {
        let info = get_inner_class_info("Lcom/example/Outer$$Lambda$1;").unwrap();
        assert_eq!(info.kind, InnerClassKind::Lambda);
    }

    #[test]
    fn test_get_inner_class_info_local() {
        let info = get_inner_class_info("Lcom/example/Outer$1LocalClass;").unwrap();
        assert_eq!(info.simple_name, "1LocalClass");
        assert_eq!(info.kind, InnerClassKind::Local);
    }

    #[test]
    fn test_is_anonymous_class() {
        assert!(!is_anonymous_class("Lcom/example/Outer;"));
        assert!(!is_anonymous_class("Lcom/example/Outer$Inner;"));
        assert!(is_anonymous_class("Lcom/example/Outer$1;"));
        assert!(is_anonymous_class("Lcom/example/Outer$123;"));
        assert!(!is_anonymous_class("Lcom/example/Outer$1Local;"));
    }

    #[test]
    fn test_is_lambda_class() {
        assert!(!is_lambda_class("Lcom/example/Outer;"));
        assert!(!is_lambda_class("Lcom/example/Outer$1;"));
        // Old toolchain pattern ($$Lambda$)
        assert!(is_lambda_class("Lcom/example/Outer$$Lambda$1;"));
        assert!(is_lambda_class("Lcom/example/Outer$$Lambda$42;"));
        // D8/R8 pattern ($$ExternalSyntheticLambda)
        assert!(is_lambda_class("Lcom/example/MainActivity$$ExternalSyntheticLambda0;"));
        assert!(is_lambda_class("Lcom/example/Outer$$ExternalSyntheticLambda5;"));
        // Kotlin Compose lambda pattern ($lambda-N)
        assert!(is_lambda_class("Lcom/example/ComposableSingletons$MainActivityKt$lambda-1$1;"));
        assert!(is_lambda_class("Lcom/example/Outer$lambda-5;"));
    }

    #[test]
    fn test_get_outer_class() {
        assert_eq!(
            get_outer_class("Lcom/example/Outer$Inner;"),
            Some("Lcom/example/Outer;".to_string())
        );
        assert_eq!(
            get_outer_class("Lcom/example/Outer$1;"),
            Some("Lcom/example/Outer;".to_string())
        );
        assert_eq!(get_outer_class("Lcom/example/Outer;"), None);
    }
}
