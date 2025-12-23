//! IR node types
//!
//! This module defines the node types for the intermediate representation.
//! BlockNode includes full JADX-compatible dominator infrastructure.

use crate::arena::ArenaId;
use crate::attributes::AttributeStorage;
use crate::types::ArgType;
use fixedbitset::FixedBitSet;

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
    /// Implemented interfaces with full type information (including generics)
    pub interfaces: Vec<ArgType>,
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
///
/// Includes full JADX-compatible dominator infrastructure.
///
/// JADX Reference: jadx-core/src/main/java/jadx/core/dex/nodes/BlockNode.java
#[derive(Debug)]
pub struct BlockNode {
    // === Basic block identity ===

    /// Const ID - never changes after creation (JADX: cid)
    ///
    /// JADX Reference: BlockNode.java:25-26
    pub cid: u32,

    /// Position in blocks list - used for BitSet operations (JADX: pos)
    ///
    /// This can change when blocks are reordered during optimization.
    /// Use `cid` for stable identity.
    ///
    /// JADX Reference: BlockNode.java:29-30
    pub pos: u32,

    /// Offset in method bytecode (JADX: startOffset)
    ///
    /// JADX Reference: BlockNode.java:35
    pub start_offset: u32,

    // === Instructions ===

    /// Instructions in this block
    pub instructions: Vec<InsnId>,

    // === Control flow graph ===

    /// Predecessor blocks (JADX: predecessors)
    ///
    /// JADX Reference: BlockNode.java:39
    pub predecessors: Vec<BlockId>,

    /// Successor blocks (JADX: successors)
    ///
    /// JADX Reference: BlockNode.java:40
    pub successors: Vec<BlockId>,

    /// Clean successors - excludes exception handlers and loop back edges (JADX: cleanSuccessors)
    ///
    /// Lazily computed via update_clean_successors().
    ///
    /// JADX Reference: BlockNode.java:41
    pub clean_successors: Option<Vec<BlockId>>,

    // === Dominator tree infrastructure ===

    /// All dominators, excluding self (JADX: doms)
    ///
    /// A block D dominates block B if every path from the entry to B
    /// must pass through D. Used for loop detection and PHI placement.
    ///
    /// JADX Reference: BlockNode.java:46
    pub doms: Option<FixedBitSet>,

    /// Post dominators, excluding self (JADX: postDoms)
    ///
    /// A block P post-dominates block B if every path from B to exit
    /// must pass through P. Used for exception analysis.
    ///
    /// JADX Reference: BlockNode.java:51
    pub post_doms: Option<FixedBitSet>,

    /// Dominance frontier (JADX: domFrontier)
    ///
    /// The dominance frontier of block B is the set of blocks where
    /// B's dominance ends. Critical for PHI node placement.
    ///
    /// JADX Reference: BlockNode.java:56
    pub dom_frontier: Option<FixedBitSet>,

    /// Immediate dominator (JADX: idom)
    ///
    /// The unique block that strictly dominates this block but does not
    /// strictly dominate any other dominator of this block.
    ///
    /// JADX Reference: BlockNode.java:61
    pub idom: Option<BlockId>,

    /// Immediate post dominator (JADX: iPostDom)
    ///
    /// JADX Reference: BlockNode.java:66
    pub ipost_dom: Option<BlockId>,

    /// Blocks that this block dominates (JADX: dominatesOn)
    ///
    /// Reverse mapping of the dominator tree for efficient traversal.
    ///
    /// JADX Reference: BlockNode.java:71
    pub dominates_on: Vec<BlockId>,

    // === Lock state ===

    /// Whether this block is locked (post-analysis mutation prevention)
    ///
    /// JADX Reference: BlockNode.java:122-135
    pub locked: bool,

    /// Attributes
    pub attrs: AttributeStorage,
}

impl BlockNode {
    /// Create a new block node (JADX: BlockNode constructor)
    ///
    /// JADX Reference: BlockNode.java:73-77
    pub fn new(cid: u32, pos: u32, start_offset: u32) -> Self {
        BlockNode {
            cid,
            pos,
            start_offset,
            instructions: Vec::new(),
            predecessors: Vec::with_capacity(1),
            successors: Vec::with_capacity(1),
            clean_successors: None,
            doms: None,
            post_doms: None,
            dom_frontier: None,
            idom: None,
            ipost_dom: None,
            dominates_on: Vec::with_capacity(3),
            locked: false,
            attrs: AttributeStorage::new(),
        }
    }

    /// Get the const ID (JADX: getCId)
    ///
    /// JADX Reference: BlockNode.java:79-81
    pub fn get_cid(&self) -> u32 {
        self.cid
    }

    /// Get the position in blocks list (JADX: getPos)
    ///
    /// JADX Reference: BlockNode.java:95-97
    pub fn get_pos(&self) -> u32 {
        self.pos
    }

    /// Set the position (JADX: setPos)
    ///
    /// JADX Reference: BlockNode.java:83-85
    pub fn set_pos(&mut self, pos: u32) {
        self.pos = pos;
    }

    /// Get the start offset (JADX: getStartOffset)
    ///
    /// JADX Reference: BlockNode.java:170-172
    pub fn get_start_offset(&self) -> u32 {
        self.start_offset
    }

    // === Dominator accessors (JADX-compatible) ===

    /// Check if 'other' block dominates this node (JADX: isDominator)
    ///
    /// JADX Reference: BlockNode.java:177-179
    pub fn is_dominator(&self, other_pos: u32) -> bool {
        self.doms.as_ref().map_or(false, |d| d.contains(other_pos as usize))
    }

    /// Get dominators (JADX: getDoms)
    ///
    /// JADX Reference: BlockNode.java:184-186
    pub fn get_doms(&self) -> Option<&FixedBitSet> {
        self.doms.as_ref()
    }

    /// Set dominators (JADX: setDoms)
    ///
    /// JADX Reference: BlockNode.java:188-190
    pub fn set_doms(&mut self, doms: FixedBitSet) {
        self.doms = Some(doms);
    }

    /// Get post-dominators (JADX: getPostDoms)
    ///
    /// JADX Reference: BlockNode.java:192-194
    pub fn get_post_doms(&self) -> Option<&FixedBitSet> {
        self.post_doms.as_ref()
    }

    /// Set post-dominators (JADX: setPostDoms)
    ///
    /// JADX Reference: BlockNode.java:196-198
    pub fn set_post_doms(&mut self, post_doms: FixedBitSet) {
        self.post_doms = Some(post_doms);
    }

    /// Get dominance frontier (JADX: getDomFrontier)
    ///
    /// JADX Reference: BlockNode.java:200-202
    pub fn get_dom_frontier(&self) -> Option<&FixedBitSet> {
        self.dom_frontier.as_ref()
    }

    /// Set dominance frontier (JADX: setDomFrontier)
    ///
    /// JADX Reference: BlockNode.java:204-206
    pub fn set_dom_frontier(&mut self, dom_frontier: FixedBitSet) {
        self.dom_frontier = Some(dom_frontier);
    }

    /// Get immediate dominator (JADX: getIDom)
    ///
    /// JADX Reference: BlockNode.java:211-213
    pub fn get_idom(&self) -> Option<BlockId> {
        self.idom.as_ref().copied()
    }

    /// Set immediate dominator (JADX: setIDom)
    ///
    /// JADX Reference: BlockNode.java:215-217
    pub fn set_idom(&mut self, idom: BlockId) {
        self.idom = Some(idom);
    }

    /// Get immediate post-dominator (JADX: getIPostDom)
    ///
    /// JADX Reference: BlockNode.java:219-221
    pub fn get_ipost_dom(&self) -> Option<BlockId> {
        self.ipost_dom.as_ref().copied()
    }

    /// Set immediate post-dominator (JADX: setIPostDom)
    ///
    /// JADX Reference: BlockNode.java:223-225
    pub fn set_ipost_dom(&mut self, ipost_dom: BlockId) {
        self.ipost_dom = Some(ipost_dom);
    }

    /// Get blocks that this block dominates (JADX: getDominatesOn)
    ///
    /// JADX Reference: BlockNode.java:227-229
    pub fn get_dominates_on(&self) -> &[BlockId] {
        &self.dominates_on
    }

    /// Add a block that this block dominates (JADX: addDominatesOn)
    ///
    /// JADX Reference: BlockNode.java:231-233
    pub fn add_dominates_on(&mut self, block: BlockId) {
        self.dominates_on.push(block);
    }

    // === CFG manipulation ===

    /// Get clean successors - excludes exception handlers (JADX: getCleanSuccessors)
    ///
    /// JADX Reference: BlockNode.java:107-109
    pub fn get_clean_successors(&self) -> Option<&[BlockId]> {
        self.clean_successors.as_deref()
    }

    /// Set clean successors
    pub fn set_clean_successors(&mut self, successors: Vec<BlockId>) {
        self.clean_successors = Some(successors);
    }

    /// Check if block is empty (JADX: isEmpty)
    ///
    /// JADX Reference: BlockNode.java:247-249
    pub fn is_empty(&self) -> bool {
        self.instructions.is_empty()
    }

    /// Lock the block to prevent further modification (JADX: lock)
    ///
    /// After locking, the block's successors/predecessors/dominatesOn
    /// lists become immutable. Used after analysis phases complete.
    ///
    /// JADX Reference: BlockNode.java:122-135
    pub fn lock(&mut self) -> Result<(), &'static str> {
        if self.dom_frontier.is_none() {
            return Err("Dominance frontier not set for block");
        }
        self.locked = true;
        Ok(())
    }

    /// Check if block is locked
    pub fn is_locked(&self) -> bool {
        self.locked
    }

    // === Block state queries (JADX: via AFlag) ===

    /// Check if this is a synthetic block (JADX: isSynthetic)
    ///
    /// JADX Reference: BlockNode.java:235-237
    pub fn is_synthetic(&self) -> bool {
        self.attrs.has_flag(crate::attributes::AFlag::Synthetic)
    }

    /// Check if this is a return block (JADX: isReturnBlock)
    ///
    /// JADX Reference: BlockNode.java:239-241
    pub fn is_return_block(&self) -> bool {
        self.attrs.has_flag(crate::attributes::AFlag::Return)
    }

    /// Check if this is a method exit block (JADX: isMthExitBlock)
    ///
    /// JADX Reference: BlockNode.java:243-245
    pub fn is_mth_exit_block(&self) -> bool {
        self.attrs.has_flag(crate::attributes::AFlag::MthExitBlock)
    }
}

impl std::cmp::PartialEq for BlockNode {
    fn eq(&self, other: &Self) -> bool {
        self.cid == other.cid
    }
}

impl std::cmp::Eq for BlockNode {}

impl std::hash::Hash for BlockNode {
    fn hash<H: std::hash::Hasher>(&self, state: &mut H) {
        self.cid.hash(state);
    }
}

impl std::cmp::Ord for BlockNode {
    fn cmp(&self, other: &Self) -> std::cmp::Ordering {
        self.cid.cmp(&other.cid)
    }
}

impl std::cmp::PartialOrd for BlockNode {
    fn partial_cmp(&self, other: &Self) -> Option<std::cmp::Ordering> {
        Some(self.cmp(other))
    }
}

/// An instruction node (placeholder - will be expanded)
#[derive(Debug)]
pub struct InsnNode {
    /// Instruction offset
    pub offset: u32,
    /// Attributes
    pub attrs: AttributeStorage,
}
