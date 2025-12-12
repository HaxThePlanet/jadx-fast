//! IR node types

use crate::arena::ArenaId;
use crate::attributes::AttributeStorage;
use crate::types::ArgType;

/// Class node ID
pub type ClassId = ArenaId<ClassNode>;
/// Method node ID
pub type MethodId = ArenaId<MethodNode>;
/// Field node ID
pub type FieldId = ArenaId<FieldNode>;
/// Block node ID
pub type BlockId = ArenaId<BlockNode>;
/// Instruction node ID
pub type InsnId = ArenaId<InsnNode>;

/// A class definition
#[derive(Debug)]
pub struct ClassNode {
    /// Class type descriptor
    pub class_type: String,
    /// Access flags
    pub access_flags: u32,
    /// Superclass type (None for java/lang/Object)
    pub superclass: Option<String>,
    /// Implemented interfaces
    pub interfaces: Vec<String>,
    /// Source file name
    pub source_file: Option<String>,
    /// Fields in this class
    pub fields: Vec<FieldId>,
    /// Methods in this class
    pub methods: Vec<MethodId>,
    /// Inner classes
    pub inner_classes: Vec<ClassId>,
    /// Attributes
    pub attrs: AttributeStorage,
}

/// A method definition
#[derive(Debug)]
pub struct MethodNode {
    /// Method name
    pub name: String,
    /// Access flags
    pub access_flags: u32,
    /// Return type
    pub return_type: ArgType,
    /// Parameter types
    pub param_types: Vec<ArgType>,
    /// Basic blocks (after block splitting)
    pub blocks: Vec<BlockId>,
    /// Register count
    pub regs_count: u16,
    /// Input parameter count
    pub ins_count: u16,
    /// Attributes
    pub attrs: AttributeStorage,
}

/// A field definition
#[derive(Debug)]
pub struct FieldNode {
    /// Field name
    pub name: String,
    /// Access flags
    pub access_flags: u32,
    /// Field type
    pub field_type: ArgType,
    /// Attributes
    pub attrs: AttributeStorage,
}

/// A basic block in the control flow graph
#[derive(Debug)]
pub struct BlockNode {
    /// Block ID (unique within method)
    pub id: u32,
    /// Instructions in this block
    pub instructions: Vec<InsnId>,
    /// Predecessor blocks
    pub predecessors: Vec<BlockId>,
    /// Successor blocks
    pub successors: Vec<BlockId>,
    /// Attributes
    pub attrs: AttributeStorage,
}

/// An instruction node (placeholder - will be expanded)
#[derive(Debug)]
pub struct InsnNode {
    /// Instruction offset
    pub offset: u32,
    /// Attributes
    pub attrs: AttributeStorage,
}
