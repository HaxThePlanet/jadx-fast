//! Class code generation
//!
//! Generates Java source code for classes using jadx-ir types.
//!
//! ## Inner Class Support
//!
//! This module detects and handles several types of inner classes:
//! - **Named inner classes**: `OuterClass$InnerClass`
//! - **Anonymous inner classes**: `OuterClass$1`, `OuterClass$2`, etc.
//! - **Lambda classes**: `OuterClass$$Lambda$1` (Java 8+ lambdas)
//!
//! When generating code for an outer class, inner classes can be embedded within.

use std::collections::{BTreeMap, BTreeSet, HashMap};

use jadx_ir::{Annotation, AnnotationVisibility, ArgType, ClassData, FieldData, FieldValue};

use crate::access_flags::{self, AccessContext};
use crate::dex_info::DexInfoProvider;
use crate::method_gen::{generate_method, generate_method_with_dex};
use crate::type_gen::{escape_string, get_package, get_simple_name, literal_to_string, type_to_string};
use crate::writer::{CodeWriter, SimpleCodeWriter};

// Import annotation generation functions from method_gen
use crate::method_gen::{generate_annotation, should_emit_annotation};

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
    let kind = if stripped.contains("$$Lambda$") {
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
}

impl ImportCollector {
    /// Create a new import collector for a class
    pub fn new(class_type: &str) -> Self {
        ImportCollector {
            imports: BTreeSet::new(),
            current_package: get_package(class_type),
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

    /// Add an internal class name (e.g., "java/lang/String" or "Ljava/lang/String;")
    fn add_internal_name(&mut self, name: &str) {
        // Strip L prefix and ; suffix if present
        let stripped = name
            .strip_prefix('L')
            .unwrap_or(name)
            .strip_suffix(';')
            .unwrap_or(name);

        // Skip java.lang.* (implicit imports)
        if stripped.starts_with("java/lang/") && !stripped[10..].contains('/') {
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
        }

        // Superclass
        if let Some(ref superclass) = class.superclass {
            self.add_internal_name(superclass);
        }

        // Interfaces
        for iface in &class.interfaces {
            self.add_internal_name(iface);
        }

        // Fields
        for field in &class.static_fields {
            self.add_type(&field.field_type);
            // Field annotations
            for annotation in &field.annotations {
                self.add_internal_name(&annotation.annotation_type);
            }
        }
        for field in &class.instance_fields {
            self.add_type(&field.field_type);
            // Field annotations
            for annotation in &field.annotations {
                self.add_internal_name(&annotation.annotation_type);
            }
        }

        // Methods
        for method in &class.methods {
            self.add_type(&method.return_type);
            for param in &method.arg_types {
                self.add_type(param);
            }
            // Method annotations
            for annotation in &method.annotations {
                self.add_internal_name(&annotation.annotation_type);
            }
            // Collect types from method body instructions
            if let Some(instructions) = method.instructions() {
                self.collect_from_instructions(instructions, dex_info);
            }
        }
    }

    /// Collect types from method body instructions
    fn collect_from_instructions(
        &mut self,
        instructions: &[jadx_ir::instructions::InsnNode],
        dex_info: Option<&std::sync::Arc<dyn DexInfoProvider>>
    ) {
        use jadx_ir::instructions::InsnType;

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
                    _ => {}
                }
            }
        }
    }

    /// Get sorted import statements
    pub fn get_imports(&self) -> Vec<String> {
        self.imports
            .iter()
            .map(|name| name.replace('/', ".").replace('$', "."))
            .collect()
    }

    /// Check if a type is imported (can use simple name)
    pub fn is_imported(&self, internal_name: &str) -> bool {
        let stripped = internal_name
            .strip_prefix('L')
            .unwrap_or(internal_name)
            .strip_suffix(';')
            .unwrap_or(internal_name);
        self.imports.contains(stripped)
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
    pub hierarchy: Option<std::sync::Arc<jadx_ir::ClassHierarchy>>,
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
pub fn generate_class_with_inner_classes(
    class: &ClassData,
    config: &ClassGenConfig,
    dex_info: Option<std::sync::Arc<dyn DexInfoProvider>>,
    inner_classes: Option<&HashMap<String, std::sync::Arc<ClassData>>>,
) -> String {
    let mut writer = SimpleCodeWriter::new();
    generate_class_to_writer_with_inner_classes(class, config, dex_info, inner_classes, &mut writer);
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
    use std::io::Write;
    print!(" [Pkg]"); std::io::stdout().flush().unwrap();
    // Package declaration
    if let Some(pkg) = get_package(&class.class_type) {
        code.add("package ").add(&pkg).add(";").newline().newline();
    }

    print!(" [ImpColl]"); std::io::stdout().flush().unwrap();
    // Collect imports (used for both import statements and short name resolution)
    let imports = if config.use_imports {
        let mut collector = ImportCollector::new(&class.class_type);
        collector.collect_from_class_with_dex(class, dex_info.as_ref());
        Some(collector.imports.clone())
    } else {
        None
    };

    print!(" [ImpGen]"); std::io::stdout().flush().unwrap();
    // Generate import statements
    if let Some(ref imp) = imports {
        if !imp.is_empty() {
            for name in imp {
                // Replace / with . for package separators
                // Replace $ with . for inner classes (Build$VERSION -> Build.VERSION)
                let import_name = name.replace('/', ".").replace('$', ".");
                code.add("import ").add(&import_name).add(";").newline();
            }
            code.newline();
        }
    }

    // Class declaration (use simple names when imports available)
    add_class_declaration(class, imports.as_ref(), code);

    // Class body
    code.add(" {").newline();
    code.inc_indent();

    // Fields (use simple names when imports available)
    add_fields(class, imports.as_ref(), code);

    // Methods (pass DEX info for name resolution in method bodies)
    // inner_classes uses Arc<ClassData> to avoid cloning - O(1) reference count increment
    add_methods_with_inner_classes(class, config, imports.as_ref(), dex_info, inner_classes, code);

    code.dec_indent();
    code.start_line().add("}").newline();
}

use crate::type_gen::type_to_string_with_imports;

/// Add class declaration (modifiers, name, extends, implements)
fn add_class_declaration<W: CodeWriter>(class: &ClassData, imports: Option<&BTreeSet<String>>, code: &mut W) {
    // Add "loaded from" comment for top-level classes
    if !is_inner_class(&class.class_type) {
        code.start_line().add("/* loaded from: classes.dex */").newline();
    }

    // Emit class-level annotations
    for annotation in &class.annotations {
        if should_emit_annotation(annotation) {
            generate_annotation(annotation, code);
            code.newline();
        }
    }

    let mut flags = class.access_flags;

    // Interfaces are implicitly abstract and static
    if access_flags::is_interface(flags) {
        flags &= !(access_flags::flags::ACC_ABSTRACT | access_flags::flags::ACC_STATIC);
    }
    // Enums are implicitly final
    if access_flags::is_enum(flags) {
        flags &= !(access_flags::flags::ACC_FINAL | access_flags::flags::ACC_ABSTRACT);
    }

    // Modifiers
    let mods = access_flags::access_flags_to_string(flags, AccessContext::Class);
    if !mods.is_empty() {
        code.add(&mods);
    }

    // Class type keyword
    let keyword = access_flags::class_type_keyword(class.access_flags);
    code.add(keyword).add(" ");

    // Class name (use alias if available from deobfuscation)
    code.add(class.display_name());

    // Extends
    if let Some(ref superclass) = class.superclass {
        // Don't show "extends Object"
        // Don't show "extends Annotation" for annotation types (implicit in Java)
        if superclass != "java/lang/Object"
            && !(access_flags::is_annotation(class.access_flags) && superclass == "java/lang/annotation/Annotation") {
            code.add(" extends ");
            let ty = ArgType::Object(superclass.clone());
            code.add(&type_to_string_with_imports(&ty, imports));
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
            .map(|i| {
                let ty = ArgType::Object(i.clone());
                type_to_string_with_imports(&ty, imports)
            })
            .collect();
        code.add(&ifaces.join(", "));
    }
}

/// Add field declarations
fn add_fields<W: CodeWriter>(class: &ClassData, imports: Option<&BTreeSet<String>>, code: &mut W) {
    let has_fields = !class.static_fields.is_empty() || !class.instance_fields.is_empty();

    if has_fields {
        code.newline();
    }

    // Static fields first
    for field in &class.static_fields {
        add_field(field, imports, code);
    }

    // Instance fields
    for field in &class.instance_fields {
        add_field(field, imports, code);
    }
}

/// Add a single field declaration
fn add_field<W: CodeWriter>(field: &FieldData, imports: Option<&BTreeSet<String>>, code: &mut W) {
    // Emit field annotations
    for annotation in &field.annotations {
        if should_emit_annotation(annotation) {
            code.start_line();
            generate_annotation(annotation, code);
            code.newline();
        }
    }

    code.start_line();

    // Modifiers
    let mods = access_flags::access_flags_to_string(field.access_flags, AccessContext::Field);
    if !mods.is_empty() {
        code.add(&mods);
    }

    // Type (use simple name if imported)
    code.add(&type_to_string_with_imports(&field.field_type, imports));
    code.add(" ");

    // Name (use alias if available from deobfuscation)
    code.add(field.display_name());

    // Initial value
    if let Some(ref value) = field.initial_value {
        code.add(" = ");
        add_field_value(value, &field.field_type, code);
    }

    code.add(";").newline();
}

/// Add field initial value
fn add_field_value<W: CodeWriter>(value: &FieldValue, field_type: &jadx_ir::ArgType, code: &mut W) {
    match value {
        FieldValue::Byte(v) => code.add(&literal_to_string(*v as i64, &jadx_ir::ArgType::Byte)),
        FieldValue::Short(v) => code.add(&literal_to_string(*v as i64, &jadx_ir::ArgType::Short)),
        FieldValue::Char(v) => code.add(&literal_to_string(*v as i64, &jadx_ir::ArgType::Char)),
        FieldValue::Int(v) => code.add(&literal_to_string(*v as i64, &jadx_ir::ArgType::Int)),
        FieldValue::Long(v) => code.add(&literal_to_string(*v, &jadx_ir::ArgType::Long)),
        FieldValue::Float(v) => code.add(&format!("{}f", v)),
        FieldValue::Double(v) => code.add(&format!("{}d", v)),
        FieldValue::String(s) => code.add(&escape_string(s)),
        FieldValue::Type(t) => {
            code.add(&type_to_string(&jadx_ir::ArgType::Object(t.clone())));
            code.add(".class")
        }
        FieldValue::Boolean(b) => code.add(if *b { "true" } else { "false" }),
        FieldValue::Null => code.add("null"),
        FieldValue::Array(values) => {
            // Get element type from field type
            let elem_type = match field_type {
                jadx_ir::ArgType::Array(inner) => inner.as_ref().clone(),
                _ => jadx_ir::ArgType::Unknown,
            };
            code.add("{");
            for (i, v) in values.iter().enumerate() {
                if i > 0 {
                    code.add(", ");
                }
                add_field_value(v, &elem_type, code);
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
    };
}

/// Check if a method is a default constructor (just calls super(), no other code)
/// These are implicit in Java and can be omitted for cleaner output
fn is_default_constructor(method: &jadx_ir::MethodData) -> bool {
    // Must be a constructor
    if !method.is_constructor() {
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
    use jadx_ir::instructions::{InsnType, InvokeKind};
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
fn add_methods_with_inner_classes<W: CodeWriter>(
    class: &ClassData,
    config: &ClassGenConfig,
    imports: Option<&BTreeSet<String>>,
    dex_info: Option<std::sync::Arc<dyn DexInfoProvider>>,
    inner_classes: Option<&HashMap<String, std::sync::Arc<ClassData>>>,
    code: &mut W,
) {
    use crate::method_gen::generate_method_with_inner_classes;
    use jadx_ir::MethodInlineAttr;

    let mut first_method = true;
    for method in &class.methods {
        // Skip default constructors that just call super() - implicit in Java
        if is_default_constructor(method) {
            continue;
        }
        // Skip synthetic methods that will be inlined (when inline_methods is enabled)
        if config.inline_methods {
            if let Some(ref attr) = method.inline_attr {
                match attr {
                    MethodInlineAttr::FieldGet { .. }
                    | MethodInlineAttr::FieldSet { .. }
                    | MethodInlineAttr::MethodCall { .. } => continue,
                    MethodInlineAttr::NotNeeded => {}
                }
            }
        }
        // Add blank line between methods, but not before the first method (unless there are fields)
        if !first_method {
            code.newline();
        }
        first_method = false;
        generate_method_with_inner_classes(method, class, config.fallback, imports, dex_info.clone(), inner_classes, config.hierarchy.as_deref(), code);
    }
}

#[cfg(test)]
mod tests {
    use super::*;
    use jadx_ir::ArgType;

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
            access_flags: 0x0002, // private
            field_type: ArgType::Int,
            initial_value: None,
            annotations: Vec::new(),
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
            access_flags: 0x0019, // public static final
            field_type: ArgType::Int,
            initial_value: Some(FieldValue::Int(100)),
            annotations: Vec::new(),
        });
        let config = ClassGenConfig::default();
        let code = generate_class(&class, &config);

        assert!(code.contains("public static final int MAX_VALUE = 100;"));
    }

    #[test]
    fn test_implements() {
        let mut class = make_class("com/example/MyClass", 0x0001);
        class.interfaces.push("java/io/Serializable".to_string());
        class.interfaces.push("java/lang/Cloneable".to_string());
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
    fn test_import_collector_from_class() {
        let mut class = make_class("com/example/MyClass", 0x0001);
        class.superclass = Some("android/app/Activity".to_string());
        class.interfaces.push("java/io/Serializable".to_string());
        class.instance_fields.push(FieldData {
            name: "view".to_string(),
            alias: None,
            access_flags: 0x0002,
            field_type: ArgType::Object("android/view/View".to_string()),
            initial_value: None,
            annotations: Vec::new(),
        });

        let mut collector = ImportCollector::new(&class.class_type);
        collector.collect_from_class(&class);

        let imports = collector.get_imports();
        assert!(imports.contains(&"android.app.Activity".to_string()));
        assert!(imports.contains(&"android.view.View".to_string()));
        assert!(imports.contains(&"java.io.Serializable".to_string()));
    }

    #[test]
    fn test_class_with_imports() {
        let mut class = make_class("com/example/MyClass", 0x0001);
        class.superclass = Some("android/app/Activity".to_string());
        class.instance_fields.push(FieldData {
            name: "view".to_string(),
            alias: None,
            access_flags: 0x0002,
            field_type: ArgType::Object("android/view/View".to_string()),
            initial_value: None,
            annotations: Vec::new(),
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
        assert!(is_lambda_class("Lcom/example/Outer$$Lambda$1;"));
        assert!(is_lambda_class("Lcom/example/Outer$$Lambda$42;"));
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
