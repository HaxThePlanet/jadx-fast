//! Attribute storage for IR nodes
//!
//! This module provides a comprehensive attribute system matching JADX's AFlag enum.
//! Attributes are used throughout the decompilation pipeline to mark nodes with
//! processing hints, analysis results, and code generation directives.

use std::collections::HashMap;
use std::any::{Any, TypeId};

/// Storage for node attributes
#[derive(Debug, Default)]
pub struct AttributeStorage {
    flags: u128,  // Extended to u128 to support 64+ flags
    #[allow(dead_code)] // Planned for future attribute storage
    attrs: HashMap<TypeId, Box<dyn Any + Send + Sync>>,
}

impl AttributeStorage {
    pub fn new() -> Self {
        Self::default()
    }

    /// Check if a flag is set
    pub fn has_flag(&self, flag: AFlag) -> bool {
        (self.flags & (1u128 << flag as u8)) != 0
    }

    /// Set a flag
    pub fn add_flag(&mut self, flag: AFlag) {
        self.flags |= 1u128 << flag as u8;
    }

    /// Remove a flag
    pub fn remove_flag(&mut self, flag: AFlag) {
        self.flags &= !(1u128 << flag as u8);
    }

    /// Get all flags as a bitfield
    pub fn get_flags(&self) -> u128 {
        self.flags
    }

    /// Clear all flags
    pub fn clear_flags(&mut self) {
        self.flags = 0;
    }

    /// Check if any flags are set
    pub fn has_any_flags(&self) -> bool {
        self.flags != 0
    }
}

/// Attribute flags matching JADX's AFlag enum
///
/// These flags are used throughout the decompilation pipeline to:
/// - Mark blocks/instructions for special processing
/// - Track analysis results
/// - Control code generation behavior
///
/// Organized by category for clarity.
#[derive(Debug, Clone, Copy, PartialEq, Eq, Hash)]
#[repr(u8)]
pub enum AFlag {
    // === Block Structure Flags (0-9) ===
    /// Method entry block
    MthEnterBlock = 0,
    /// Method exit block
    MthExitBlock = 1,
    /// Try block entry
    TryEnter = 2,
    /// Try block exit
    TryLeave = 3,
    /// Loop start marker
    LoopStart = 4,
    /// Loop end marker
    LoopEnd = 5,
    /// Block contains only return instruction
    Return = 6,
    /// Original return (before transforms)
    OrigReturn = 7,
    /// Fall-through block (no explicit jump)
    FallThrough = 8,
    /// Block added to region structure
    AddedToRegion = 9,

    // === Instruction Processing Flags (10-19) ===
    /// Compiler-generated code
    Synthetic = 10,
    /// Don't wrap in parentheses when inlined
    DontWrap = 11,
    /// Don't inline this instruction
    DontInline = 12,
    /// Don't inline constant values
    DontInlineConst = 13,
    /// Process but don't output to generated code
    DontGenerate = 14,
    /// Comment out in generated code
    CommentOut = 15,
    /// Can be completely removed
    Remove = 16,
    /// Instruction used inside other but not in args
    Hidden = 17,
    /// Instruction has been wrapped in another
    Wrapped = 18,
    /// Arithmetic one-arg form (x += 1)
    ArithOneArg = 19,

    // === Exception Handling Flags (20-29) ===
    /// Exception top splitter block
    ExcTopSplitter = 20,
    /// Exception bottom splitter block
    ExcBottomSplitter = 21,
    /// Instructions from finally block (duplicated)
    FinallyInsns = 22,
    /// Ignore throw for block splitting
    IgnoreThrowSplit = 23,
    /// Temporary CFG edge for exception handler
    TmpEdge = 24,

    // === Argument/Parameter Flags (25-34) ===
    /// Skip first argument (implicit this)
    SkipFirstArg = 25,
    /// Skip this argument in invoke
    SkipArg = 26,
    /// Don't skip any arguments
    NoSkipArgs = 27,
    /// This reference
    This = 28,
    /// Super reference
    Super = 29,
    /// Method argument register
    MethodArgument = 30,
    /// Type cannot be changed
    ImmutableType = 31,
    /// Varargs method call
    VarargCall = 32,

    // === Variable Declaration Flags (33-39) ===
    /// Custom variable declaration
    CustomDeclare = 33,
    /// Variable needs declaration
    DeclareVar = 34,
    /// Force inline with assign
    ForceAssignInline = 35,

    // === Type/Cast Flags (40-44) ===
    /// Use explicit primitive type (e.g., 7L)
    ExplicitPrimitiveType = 40,
    /// Explicit cast needed
    ExplicitCast = 41,
    /// Soft cast for generics (unchecked)
    SoftCast = 42,

    // === Class Flags (45-54) ===
    /// Don't add super class in output
    RemoveSuperClass = 45,
    /// Don't rename during deobfuscation
    DontRename = 46,
    /// Force use of raw name
    ForceRawName = 47,
    /// Anonymous class constructor
    AnonymousConstructor = 48,
    /// Inline instance field
    InlineInstanceField = 49,
    /// Package info class
    PackageInfo = 50,
    /// Android R resource class
    AndroidRClass = 51,
    /// Method candidate for inlining
    MethodCandidateForInline = 52,
    /// Source line hints can be trusted
    UseLinesHints = 53,

    // === Processing State Flags (55-64) ===
    /// Else-if chain pattern
    ElseIfChain = 55,
    /// Inconsistent code warning
    InconsistentCode = 56,
    /// Request if-region optimization
    RequestIfRegionOptimize = 57,
    /// Request code shrink pass
    RequestCodeShrink = 58,
    /// Disable blocks lock
    DisableBlocksLock = 59,
    /// Restart code generation
    RestartCodegen = 60,
    /// Reload at codegen stage
    ReloadAtCodegenStage = 61,
    /// Deep class reload needed
    ClassDeepReload = 62,
    /// Class was unloaded
    ClassUnloaded = 63,
    /// Don't unload class (debug)
    DontUnloadClass = 64,

    // === Special Processing Flags (65-70) ===
    /// Resolve Java JSR instructions
    ResolveJavaJsr = 65,
    /// Compute post-dominator tree
    ComputePostDom = 66,
    /// Return argument marker
    ReturnArg = 67,
    /// Skip method entirely
    SkipMth = 68,
}
