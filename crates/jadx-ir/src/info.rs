//! Information types (class info, method info, etc.)
//!
//! These types hold metadata about classes and methods during decompilation.

use crate::instructions::InsnNode;
use crate::types::ArgType;

/// An annotation with its type and element values
#[derive(Debug, Clone)]
pub struct Annotation {
    /// Annotation type (e.g., "java/lang/Override", "java/lang/Deprecated")
    pub annotation_type: String,
    /// Annotation visibility (build, runtime, system)
    pub visibility: AnnotationVisibility,
    /// Element name-value pairs
    pub elements: Vec<AnnotationElement>,
}

impl Annotation {
    /// Create a new annotation with the given type
    pub fn new(annotation_type: String, visibility: AnnotationVisibility) -> Self {
        Annotation {
            annotation_type,
            visibility,
            elements: Vec::new(),
        }
    }

    /// Get the simple name of this annotation (e.g., "Override" from "java/lang/Override")
    pub fn simple_name(&self) -> &str {
        self.annotation_type.rsplit('/').next().unwrap_or(&self.annotation_type)
    }

    /// Check if this is a standard annotation that should be emitted
    pub fn should_emit(&self) -> bool {
        // Only emit runtime-visible annotations by default
        matches!(self.visibility, AnnotationVisibility::Runtime | AnnotationVisibility::System)
    }
}

/// Annotation visibility
#[derive(Debug, Clone, Copy, PartialEq, Eq)]
pub enum AnnotationVisibility {
    /// Build-time only (not visible at runtime)
    Build,
    /// Visible at runtime via reflection
    Runtime,
    /// System annotation (visible to runtime, but not user code)
    System,
}

/// An annotation element (name-value pair)
#[derive(Debug, Clone)]
pub struct AnnotationElement {
    /// Element name
    pub name: String,
    /// Element value
    pub value: AnnotationValue,
}

/// Annotation element value
#[derive(Debug, Clone)]
pub enum AnnotationValue {
    /// Byte value
    Byte(i8),
    /// Short value
    Short(i16),
    /// Char value
    Char(u16),
    /// Int value
    Int(i32),
    /// Long value
    Long(i64),
    /// Float value
    Float(f32),
    /// Double value
    Double(f64),
    /// String value
    String(String),
    /// Type reference (class literal)
    Type(String),
    /// Enum constant (class name, field name)
    Enum(String, String),
    /// Nested annotation
    Annotation(Box<Annotation>),
    /// Array of values
    Array(Vec<AnnotationValue>),
    /// Boolean value
    Boolean(bool),
    /// Null
    Null,
}

/// Method information and IR
#[derive(Debug, Clone)]
pub struct MethodData {
    /// Method name
    pub name: String,
    /// Alias name (from deobfuscation or mapping file)
    pub alias: Option<String>,
    /// Access flags
    pub access_flags: u32,
    /// Return type
    pub return_type: ArgType,
    /// Parameter types
    pub arg_types: Vec<ArgType>,
    /// Parameter names from debug info (None = no debug info)
    pub arg_names: Vec<Option<String>>,
    /// Register count
    pub regs_count: u16,
    /// Input parameter count (includes 'this' for instance methods)
    pub ins_count: u16,
    /// Output count
    pub outs_count: u16,
    /// Instructions (after DEX -> IR conversion)
    pub instructions: Vec<InsnNode>,
    /// Try-catch blocks
    pub try_blocks: Vec<TryBlock>,
    /// Debug info (line numbers, local variables)
    pub debug_info: Option<DebugInfo>,
    /// Annotations on this method
    pub annotations: Vec<Annotation>,
}

impl MethodData {
    /// Create a new method data
    pub fn new(name: String, access_flags: u32, return_type: ArgType) -> Self {
        MethodData {
            name,
            alias: None,
            access_flags,
            return_type,
            arg_types: Vec::new(),
            arg_names: Vec::new(),
            regs_count: 0,
            ins_count: 0,
            outs_count: 0,
            instructions: Vec::new(),
            try_blocks: Vec::new(),
            debug_info: None,
            annotations: Vec::new(),
        }
    }

    /// Get the display name (alias if set, otherwise original name)
    pub fn display_name(&self) -> &str {
        self.alias.as_deref().unwrap_or(&self.name)
    }

    /// Check if this is a static method
    pub fn is_static(&self) -> bool {
        self.access_flags & 0x0008 != 0
    }

    /// Check if this is a constructor
    pub fn is_constructor(&self) -> bool {
        self.name == "<init>"
    }

    /// Check if this is a static initializer
    pub fn is_class_init(&self) -> bool {
        self.name == "<clinit>"
    }

    /// Check if this is an abstract method
    pub fn is_abstract(&self) -> bool {
        self.access_flags & 0x0400 != 0
    }

    /// Check if this is a native method
    pub fn is_native(&self) -> bool {
        self.access_flags & 0x0100 != 0
    }

    /// Get the number of parameters (excluding 'this')
    pub fn param_count(&self) -> usize {
        self.arg_types.len()
    }

    /// Get the first register used for parameters
    pub fn first_arg_reg(&self) -> u16 {
        self.regs_count.saturating_sub(self.ins_count)
    }
}

/// Try-catch block information
#[derive(Debug, Clone)]
pub struct TryBlock {
    /// Start offset (code units)
    pub start_addr: u32,
    /// End offset (code units, exclusive)
    pub end_addr: u32,
    /// Exception handlers
    pub handlers: Vec<ExceptionHandler>,
}

/// Exception handler
#[derive(Debug, Clone)]
pub struct ExceptionHandler {
    /// Exception type (None for catch-all)
    pub exception_type: Option<String>,
    /// Handler address (code units)
    pub handler_addr: u32,
}

/// Debug information for a method
#[derive(Debug, Clone, Default)]
pub struct DebugInfo {
    /// Line number entries (address -> line number)
    pub line_numbers: Vec<(u32, u32)>,
    /// Local variable entries
    pub local_vars: Vec<LocalVar>,
}

/// Local variable debug info
#[derive(Debug, Clone)]
pub struct LocalVar {
    /// Variable name
    pub name: String,
    /// Variable type descriptor
    pub type_desc: String,
    /// Register number
    pub reg: u16,
    /// Start address (code units)
    pub start_addr: u32,
    /// End address (code units)
    pub end_addr: u32,
}

/// Class information
#[derive(Debug, Clone)]
pub struct ClassData {
    /// Class type descriptor (e.g., "Lcom/example/Foo;")
    pub class_type: String,
    /// Alias name (from deobfuscation or mapping file)
    pub alias: Option<String>,
    /// Package alias (from deobfuscation or mapping file)
    pub pkg_alias: Option<String>,
    /// Access flags
    pub access_flags: u32,
    /// Superclass type (None for java/lang/Object)
    pub superclass: Option<String>,
    /// Implemented interfaces
    pub interfaces: Vec<String>,
    /// Source file name
    pub source_file: Option<String>,
    /// Methods
    pub methods: Vec<MethodData>,
    /// Static fields
    pub static_fields: Vec<FieldData>,
    /// Instance fields
    pub instance_fields: Vec<FieldData>,
    /// Annotations on this class
    pub annotations: Vec<Annotation>,
}

impl ClassData {
    /// Create a new class data
    pub fn new(class_type: String, access_flags: u32) -> Self {
        ClassData {
            class_type,
            alias: None,
            pkg_alias: None,
            access_flags,
            superclass: None,
            interfaces: Vec::new(),
            source_file: None,
            methods: Vec::new(),
            static_fields: Vec::new(),
            instance_fields: Vec::new(),
            annotations: Vec::new(),
        }
    }

    /// Get the display name (alias if set, otherwise simple_name)
    pub fn display_name(&self) -> &str {
        self.alias.as_deref().unwrap_or_else(|| self.simple_name())
    }

    /// Get the simple name (without package)
    pub fn simple_name(&self) -> &str {
        let name = self.class_type.trim_start_matches('L').trim_end_matches(';');
        name.rsplit('/').next().unwrap_or(name)
    }

    /// Get the package name
    pub fn package(&self) -> Option<&str> {
        let name = self.class_type.trim_start_matches('L').trim_end_matches(';');
        let pos = name.rfind('/')?;
        Some(&name[..pos])
    }

    /// Check if public
    pub fn is_public(&self) -> bool {
        self.access_flags & 0x0001 != 0
    }

    /// Check if final
    pub fn is_final(&self) -> bool {
        self.access_flags & 0x0010 != 0
    }

    /// Check if interface
    pub fn is_interface(&self) -> bool {
        self.access_flags & 0x0200 != 0
    }

    /// Check if abstract
    pub fn is_abstract(&self) -> bool {
        self.access_flags & 0x0400 != 0
    }

    /// Check if enum
    pub fn is_enum(&self) -> bool {
        self.access_flags & 0x4000 != 0
    }

    /// Check if annotation
    pub fn is_annotation(&self) -> bool {
        self.access_flags & 0x2000 != 0
    }
}

/// Field information
#[derive(Debug, Clone)]
pub struct FieldData {
    /// Field name
    pub name: String,
    /// Alias name (from deobfuscation or mapping file)
    pub alias: Option<String>,
    /// Access flags
    pub access_flags: u32,
    /// Field type
    pub field_type: ArgType,
    /// Initial value (for static fields)
    pub initial_value: Option<FieldValue>,
    /// Annotations on this field
    pub annotations: Vec<Annotation>,
}

impl FieldData {
    /// Create a new field data
    pub fn new(name: String, access_flags: u32, field_type: ArgType) -> Self {
        FieldData {
            name,
            alias: None,
            access_flags,
            field_type,
            initial_value: None,
            annotations: Vec::new(),
        }
    }

    /// Get the display name (alias if set, otherwise original name)
    pub fn display_name(&self) -> &str {
        self.alias.as_deref().unwrap_or(&self.name)
    }

    /// Check if static
    pub fn is_static(&self) -> bool {
        self.access_flags & 0x0008 != 0
    }

    /// Check if final
    pub fn is_final(&self) -> bool {
        self.access_flags & 0x0010 != 0
    }
}

/// Field initial value
#[derive(Debug, Clone)]
pub enum FieldValue {
    Byte(i8),
    Short(i16),
    Char(u16),
    Int(i32),
    Long(i64),
    Float(f32),
    Double(f64),
    String(String),
    Type(String),
    Boolean(bool),
    Null,
    /// Array of values (for array field initializers)
    Array(Vec<FieldValue>),
    /// Enum constant reference (class name, field name)
    Enum(String, String),
    /// Field reference (class name, field name)
    Field(String, String),
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn test_class_simple_name() {
        let class = ClassData::new("Lcom/example/Foo;".to_string(), 0);
        assert_eq!(class.simple_name(), "Foo");
    }

    #[test]
    fn test_class_package() {
        let class = ClassData::new("Lcom/example/Foo;".to_string(), 0);
        assert_eq!(class.package(), Some("com/example"));
    }

    #[test]
    fn test_method_flags() {
        let mut method = MethodData::new("<init>".to_string(), 0x0001, ArgType::Void);
        assert!(method.is_constructor());
        assert!(!method.is_static());

        method.access_flags = 0x0008;
        assert!(method.is_static());
    }

    #[test]
    fn test_first_arg_reg() {
        let mut method = MethodData::new("test".to_string(), 0, ArgType::Void);
        method.regs_count = 5;
        method.ins_count = 2;
        assert_eq!(method.first_arg_reg(), 3);
    }
}
