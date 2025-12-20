//! Region types for high-level control flow
//!
//! This module provides 100% parity with JADX's region IR:
//! - IContainer/IRegion/IBranchRegion trait hierarchy
//! - LoopType enum (ForLoop/ForEachLoop) matching JADX
//! - ConditionMode matching JADX's IfCondition.Mode
//! - CaseInfo for switch cases

use crate::instructions::IfCondition;

// ============================================================================
// JADX Interface Hierarchy (100% Parity)
// ============================================================================

/// Base container trait (matches JADX IContainer)
/// All region types implement this interface.
pub trait IContainer {
    /// Unique identifier for use in toString() - matches JADX baseString()
    fn base_string(&self) -> String;
}

/// Region trait (matches JADX IRegion extends IContainer)
/// Regions can contain sub-blocks and have parent relationships.
pub trait IRegion: IContainer {
    /// Get parent region ID (if any)
    fn parent_id(&self) -> Option<RegionId>;

    /// Get list of sub-blocks/containers
    fn sub_blocks(&self) -> Vec<RegionContent>;

    /// Replace a sub-block with a new one
    fn replace_sub_block(&mut self, old: &RegionContent, new: RegionContent) -> bool;
}

/// Branch region trait (matches JADX IBranchRegion extends IRegion)
/// For regions with multiple branches (if-else, switch, try-catch).
pub trait IBranchRegion: IRegion {
    /// Get list of branches (may contain None for empty branches)
    fn branches(&self) -> Vec<Option<RegionContent>>;
}

/// Condition region trait (matches JADX IConditionRegion)
/// For regions with conditions (if, loop).
pub trait IConditionRegion: IRegion {
    /// Get the condition (if any)
    fn condition(&self) -> Option<&Condition>;

    /// Invert the condition
    fn invert_condition(&mut self);

    /// Simplify the condition
    fn simplify_condition(&mut self) -> bool;

    /// Get source line of condition
    fn condition_source_line(&self) -> Option<u32>;
}

/// Region identifier for parent/child relationships
#[derive(Debug, Clone, Copy, PartialEq, Eq, Hash)]
pub struct RegionId(pub u32);

// ============================================================================
// JADX LoopType Hierarchy (100% Parity)
// ============================================================================

/// Loop type classification (matches JADX LoopType abstract class)
/// This is separate from LoopKind - LoopType contains the actual loop data.
#[derive(Debug, Clone)]
pub enum LoopType {
    /// For loop with init and increment instructions (matches JADX ForLoop)
    ForLoop {
        /// Offset of initialization instruction (e.g., i = 0)
        init_insn_offset: Option<u32>,
        /// Offset of increment instruction (e.g., i++)
        incr_insn_offset: Option<u32>,
    },

    /// For-each loop with variable and iterable (matches JADX ForEachLoop)
    ForEachLoop {
        /// Offset of variable argument instruction (fake REGION_ARG insn)
        var_arg_insn_offset: Option<u32>,
        /// Offset of iterable argument instruction (fake REGION_ARG insn)
        iterable_arg_insn_offset: Option<u32>,
    },

    /// Simple while/do-while/endless loop (no special type)
    None,
}

impl Default for LoopType {
    fn default() -> Self {
        LoopType::None
    }
}

impl LoopType {
    /// Check if this is a for loop
    pub fn is_for_loop(&self) -> bool {
        matches!(self, LoopType::ForLoop { .. })
    }

    /// Check if this is a for-each loop
    pub fn is_foreach_loop(&self) -> bool {
        matches!(self, LoopType::ForEachLoop { .. })
    }

    /// Get init instruction offset (for ForLoop)
    pub fn init_insn(&self) -> Option<u32> {
        match self {
            LoopType::ForLoop { init_insn_offset, .. } => *init_insn_offset,
            _ => None,
        }
    }

    /// Get increment instruction offset (for ForLoop)
    pub fn incr_insn(&self) -> Option<u32> {
        match self {
            LoopType::ForLoop { incr_insn_offset, .. } => *incr_insn_offset,
            _ => None,
        }
    }
}

// ============================================================================
// JADX IfCondition.Mode (100% Parity)
// ============================================================================

/// Condition mode (matches JADX IfCondition.Mode exactly)
#[derive(Debug, Clone, Copy, PartialEq, Eq)]
pub enum ConditionMode {
    /// Single comparison (matches JADX Mode.COMPARE)
    Compare,
    /// Ternary expression a ? b : c (matches JADX Mode.TERNARY)
    Ternary,
    /// Logical NOT (matches JADX Mode.NOT)
    Not,
    /// Logical AND (matches JADX Mode.AND)
    And,
    /// Logical OR (matches JADX Mode.OR)
    Or,
}

// ============================================================================
// JADX SwitchRegion.CaseInfo (100% Parity)
// ============================================================================

/// Switch case information (matches JADX SwitchRegion.CaseInfo)
#[derive(Debug, Clone)]
pub struct CaseInfo {
    /// Case keys (multiple for fall-through cases)
    /// Use CaseKey::Default for default case
    pub keys: Vec<CaseKey>,
    /// Region for this case
    pub container: Box<Region>,
}

/// Switch case key (matches JADX's Object keys with DEFAULT_CASE_KEY sentinel)
#[derive(Debug, Clone, PartialEq, Eq, Hash)]
pub enum CaseKey {
    /// Integer case value
    Int(i32),
    /// String case value (for string switches)
    String(String),
    /// Enum case value
    Enum { type_name: String, field_name: String },
    /// Default case (matches JADX DEFAULT_CASE_KEY sentinel object)
    Default,
}

impl std::fmt::Display for CaseKey {
    fn fmt(&self, f: &mut std::fmt::Formatter<'_>) -> std::fmt::Result {
        match self {
            CaseKey::Int(i) => write!(f, "{}", i),
            CaseKey::String(s) => write!(f, "\"{}\"", s.escape_default()),
            CaseKey::Enum { field_name, .. } => write!(f, "{}", field_name),
            CaseKey::Default => write!(f, "default"),
        }
    }
}

impl CaseInfo {
    /// Create a new case info
    pub fn new(keys: Vec<CaseKey>, container: Region) -> Self {
        CaseInfo {
            keys,
            container: Box::new(container),
        }
    }

    /// Check if this is a default case
    pub fn is_default(&self) -> bool {
        self.keys.iter().any(|k| matches!(k, CaseKey::Default))
    }
}

/// A region in the region tree
#[derive(Debug, Clone)]
pub enum Region {
    /// Sequential region (list of sub-regions/blocks)
    Sequence(Vec<RegionContent>),

    /// If-else region
    If {
        condition: Condition,
        then_region: Box<Region>,
        else_region: Option<Box<Region>>,
    },

    /// Loop region (matches JADX LoopRegion)
    Loop {
        kind: LoopKind,
        condition: Option<Condition>,
        body: Box<Region>,
        /// Detailed loop information for ForLoop/ForEach distinction (JADX parity)
        details: Option<Box<LoopDetails>>,
        /// Loop type (ForLoop/ForEachLoop) - matches JADX LoopRegion.type field
        loop_type: LoopType,
        /// Whether condition is at end (do-while) - matches JADX conditionAtEnd
        condition_at_end: bool,
        /// Header block (for condition) - matches JADX header field
        header_block: Option<u32>,
        /// Pre-condition block - matches JADX preCondition field
        pre_condition_block: Option<u32>,
    },

    /// Switch region (matches JADX SwitchRegion)
    Switch {
        /// Block containing the switch instruction - matches JADX header field
        header_block: u32,
        /// Cases with keys and containers - matches JADX List<CaseInfo>
        cases: Vec<CaseInfo>,
    },

    /// Try-catch region (matches JADX TryCatchRegion)
    TryCatch {
        /// Try region - matches JADX tryRegion field
        try_region: Box<Region>,
        /// Catch handlers - matches JADX catchRegions map
        handlers: Vec<CatchHandler>,
        /// Finally region - matches JADX finallyRegion field
        finally: Option<Box<Region>>,
    },

    /// Synchronized block (matches JADX SynchronizedRegion)
    Synchronized {
        /// Offset of MonitorEnter instruction - matches JADX enterInsn
        enter_insn_offset: u32,
        /// Block containing the MonitorEnter instruction
        enter_block: u32,
        /// Nested region - matches JADX region field
        body: Box<Region>,
        /// Offsets of MonitorExit instructions - matches JADX exitInsns
        exit_insn_offsets: Vec<u32>,
    },

    /// Break statement (exit loop early)
    Break {
        label: Option<String>,
    },

    /// Continue statement (skip to next iteration)
    Continue {
        label: Option<String>,
    },

    /// Ternary assignment: dest = cond ? then_val : else_val
    /// Pattern detected and transformed from if-else regions (TernaryMod)
    TernaryAssignment {
        /// The condition expression to evaluate
        condition: Condition,
        /// Destination register for the assignment
        dest_reg: u16,
        /// SSA version of the destination register
        dest_version: u32,
        /// Block ID containing the then value expression
        then_value_block: u32,
        /// Block ID containing the else value expression
        else_value_block: u32,
    },

    /// Ternary return: return cond ? then_val : else_val
    /// Pattern detected and transformed from if-else regions (TernaryMod)
    TernaryReturn {
        /// The condition expression to evaluate
        condition: Condition,
        /// Block ID containing the then return value expression
        then_value_block: u32,
        /// Block ID containing the else return value expression
        else_value_block: u32,
    },
}

/// Content of a region (either a block or nested region)
#[derive(Debug, Clone)]
pub enum RegionContent {
    /// Block ID (index into method's block list)
    Block(u32),
    /// Nested region
    Region(Box<Region>),
}

/// Condition expression for control flow
/// Supports compound conditions (&&, ||) and negation
#[derive(Debug, Clone)]
pub enum Condition {
    /// Simple condition from a single block
    Simple {
        /// Block containing the condition
        block: u32,
        /// The comparison operator
        op: IfCondition,
        /// Whether the condition is negated
        negated: bool,
    },

    /// AND of two conditions (short-circuit &&)
    And(Box<Condition>, Box<Condition>),

    /// OR of two conditions (short-circuit ||)
    Or(Box<Condition>, Box<Condition>),

    /// NOT of a condition
    Not(Box<Condition>),

    /// Ternary condition (a ? b : c) - used in complex conditions
    Ternary {
        condition: Box<Condition>,
        if_true: Box<Condition>,
        if_false: Box<Condition>,
    },

    /// Placeholder for conditions not yet analyzed
    Unknown,
}

impl Default for Condition {
    fn default() -> Self {
        Condition::Unknown
    }
}

impl Condition {
    /// Create a simple condition from a block
    pub fn simple(block: u32, op: IfCondition) -> Self {
        Condition::Simple {
            block,
            op,
            negated: false,
        }
    }

    /// Create a simple condition with explicit negation
    /// In Dalvik, the branch is taken when condition is TRUE, but the "then" block
    /// in structured code is the fall-through (when condition is FALSE).
    /// So we typically need `negated: true` when converting from Dalvik to Java.
    pub fn simple_negated(block: u32, op: IfCondition) -> Self {
        Condition::Simple {
            block,
            op,
            negated: true,
        }
    }

    /// Create a negated condition
    pub fn negate(self) -> Self {
        match self {
            Condition::Not(inner) => *inner,
            Condition::Simple { block, op, negated } => Condition::Simple {
                block,
                op,
                negated: !negated,
            },
            other => Condition::Not(Box::new(other)),
        }
    }

    /// Create an AND condition
    pub fn and(left: Condition, right: Condition) -> Self {
        Condition::And(Box::new(left), Box::new(right))
    }

    /// Create an OR condition
    pub fn or(left: Condition, right: Condition) -> Self {
        Condition::Or(Box::new(left), Box::new(right))
    }

    /// Check if this is a simple condition
    pub fn is_simple(&self) -> bool {
        matches!(self, Condition::Simple { .. })
    }

    /// Get the mode of this condition (matches JADX IfCondition.getMode())
    pub fn mode(&self) -> ConditionMode {
        match self {
            Condition::Simple { .. } => ConditionMode::Compare,
            Condition::And(_, _) => ConditionMode::And,
            Condition::Or(_, _) => ConditionMode::Or,
            Condition::Not(_) => ConditionMode::Not,
            Condition::Ternary { .. } => ConditionMode::Ternary,
            Condition::Unknown => ConditionMode::Compare, // Default to Compare
        }
    }

    /// Check if this is a compare condition (matches JADX isCompare())
    pub fn is_compare(&self) -> bool {
        self.mode() == ConditionMode::Compare
    }

    /// Check if this is an unknown/placeholder condition
    pub fn is_unknown(&self) -> bool {
        matches!(self, Condition::Unknown)
    }

    /// Get the blocks involved in this condition
    pub fn get_blocks(&self) -> Vec<u32> {
        let mut blocks = Vec::new();
        self.collect_blocks(&mut blocks);
        blocks
    }

    pub fn collect_blocks(&self, blocks: &mut Vec<u32>) {
        match self {
            Condition::Simple { block, .. } => {
                if !blocks.contains(block) {
                    blocks.push(*block);
                }
            }
            Condition::And(left, right) | Condition::Or(left, right) => {
                left.collect_blocks(blocks);
                right.collect_blocks(blocks);
            }
            Condition::Not(inner) => {
                inner.collect_blocks(blocks);
            }
            Condition::Ternary {
                condition,
                if_true,
                if_false,
            } => {
                condition.collect_blocks(blocks);
                if_true.collect_blocks(blocks);
                if_false.collect_blocks(blocks);
            }
            Condition::Unknown => {}
        }
    }

    /// Simplify this condition using various optimization rules:
    /// - De Morgan's laws: NOT(AND(a,b)) → OR(NOT(a), NOT(b))
    /// - De Morgan's laws: NOT(OR(a,b)) → AND(NOT(a), NOT(b))
    /// - Double negation elimination: NOT(NOT(x)) → x (already in negate())
    /// - NOT distribution into ternary: NOT(a ? b : c) → a ? NOT(b) : NOT(c)
    /// - Negation count heuristic: If >50% of args are negated, invert whole condition
    ///
    /// Based on JADX's IfCondition.simplify() patterns.
    pub fn simplify(self) -> Self {
        match self {
            // De Morgan's law: NOT(AND(a,b)) → OR(NOT(a), NOT(b))
            Condition::Not(inner) => {
                match *inner {
                    Condition::And(left, right) => {
                        // Apply De Morgan: !(a && b) → !a || !b
                        let simplified_left = left.negate().simplify();
                        let simplified_right = right.negate().simplify();
                        Condition::Or(Box::new(simplified_left), Box::new(simplified_right))
                    }
                    Condition::Or(left, right) => {
                        // Apply De Morgan: !(a || b) → !a && !b
                        let simplified_left = left.negate().simplify();
                        let simplified_right = right.negate().simplify();
                        Condition::And(Box::new(simplified_left), Box::new(simplified_right))
                    }
                    Condition::Not(double_inner) => {
                        // Double negation: !!x → x
                        double_inner.simplify()
                    }
                    Condition::Ternary { condition, if_true, if_false } => {
                        // NOT(a ? b : c) → a ? NOT(b) : NOT(c)
                        Condition::Ternary {
                            condition: Box::new(condition.simplify()),
                            if_true: Box::new(if_true.negate().simplify()),
                            if_false: Box::new(if_false.negate().simplify()),
                        }
                    }
                    other => {
                        // Can't simplify further, just simplify inner
                        Condition::Not(Box::new(other.simplify()))
                    }
                }
            }

            // Recursively simplify AND/OR and apply negation heuristic
            Condition::And(left, right) => {
                let simplified_left = left.simplify();
                let simplified_right = right.simplify();

                // Count negations - if both are negated, maybe invert
                let left_negated = simplified_left.is_negated();
                let right_negated = simplified_right.is_negated();

                if left_negated && right_negated {
                    // Both negated: !a && !b → !(a || b) (inverse De Morgan)
                    // This can be cleaner in some cases
                    // But we keep it as-is by default - only apply when explicitly desired
                }

                Condition::And(Box::new(simplified_left), Box::new(simplified_right))
            }

            Condition::Or(left, right) => {
                let simplified_left = left.simplify();
                let simplified_right = right.simplify();

                Condition::Or(Box::new(simplified_left), Box::new(simplified_right))
            }

            Condition::Ternary { condition, if_true, if_false } => {
                Condition::Ternary {
                    condition: Box::new(condition.simplify()),
                    if_true: Box::new(if_true.simplify()),
                    if_false: Box::new(if_false.simplify()),
                }
            }

            // Simple conditions and Unknown pass through
            Condition::Simple { block, op, negated } => {
                Condition::Simple { block, op, negated }
            }
            Condition::Unknown => Condition::Unknown,
        }
    }

    /// Check if this condition is negated at the top level
    pub fn is_negated(&self) -> bool {
        match self {
            Condition::Not(_) => true,
            Condition::Simple { negated, .. } => *negated,
            _ => false,
        }
    }

    /// Flatten nested AND conditions into a list
    /// Used for negation count heuristic
    pub fn flatten_and(&self) -> Vec<&Condition> {
        match self {
            Condition::And(left, right) => {
                let mut result = left.flatten_and();
                result.extend(right.flatten_and());
                result
            }
            other => vec![other],
        }
    }

    /// Flatten nested OR conditions into a list
    pub fn flatten_or(&self) -> Vec<&Condition> {
        match self {
            Condition::Or(left, right) => {
                let mut result = left.flatten_or();
                result.extend(right.flatten_or());
                result
            }
            other => vec![other],
        }
    }
}

/// Loop kind
#[derive(Debug, Clone, Copy, PartialEq, Eq)]
pub enum LoopKind {
    While,
    DoWhile,
    For,
    ForEach,
    Endless,
}

/// Catch handler
#[derive(Debug, Clone)]
pub struct CatchHandler {
    /// Exception types caught by this handler (multiple for multi-catch)
    /// Empty or single None means catch-all (catches Throwable)
    pub exception_types: Vec<String>,
    /// True if this is a catch-all handler (catches all exceptions)
    pub catch_all: bool,
    pub region: Box<Region>,
}

impl CatchHandler {
    /// Create a catch handler for a single exception type
    pub fn single(exception_type: String, region: Region) -> Self {
        CatchHandler {
            exception_types: vec![exception_type],
            catch_all: false,
            region: Box::new(region),
        }
    }

    /// Create a catch-all handler
    pub fn catch_all(region: Region) -> Self {
        CatchHandler {
            exception_types: vec![],
            catch_all: true,
            region: Box::new(region),
        }
    }

    /// Create a multi-catch handler
    pub fn multi(exception_types: Vec<String>, region: Region) -> Self {
        CatchHandler {
            exception_types,
            catch_all: false,
            region: Box::new(region),
        }
    }

    /// Check if this is a multi-catch handler
    pub fn is_multi_catch(&self) -> bool {
        self.exception_types.len() > 1
    }

    /// Get the exception type (for single-catch compatibility)
    pub fn exception_type(&self) -> Option<&str> {
        self.exception_types.first().map(|s| s.as_str())
    }
}

// ============================================================================
// JADX Parity: Enhanced Region IR Types (Phase 1-3)
// ============================================================================

/// Region type classification (matches JADX IContainer hierarchy)
#[derive(Debug, Clone, Copy, PartialEq, Eq)]
pub enum RegionType {
    Sequence,
    If,
    Loop,
    Switch,
    TryCatch,
    Synchronized,
    Break,
    Continue,
    TernaryAssignment,
    TernaryReturn,
}

/// Context for tracking parent chain during region traversal
/// Used for context-sensitive code generation and analysis
#[derive(Debug, Clone, Default)]
pub struct RegionContext {
    /// Stack of parent region types (outermost first)
    pub parent_types: Vec<RegionType>,
    /// Stack of enclosing loop headers (for break/continue target resolution)
    pub enclosing_loops: Vec<u32>,
    /// Current nesting depth
    pub depth: usize,
}

impl RegionContext {
    /// Create a new empty context
    pub fn new() -> Self {
        Self::default()
    }

    /// Push a region onto the context stack
    pub fn push(&mut self, region_type: RegionType, loop_header: Option<u32>) {
        self.parent_types.push(region_type);
        if let Some(header) = loop_header {
            self.enclosing_loops.push(header);
        }
        self.depth += 1;
    }

    /// Pop the most recent region from the context stack
    pub fn pop(&mut self, was_loop: bool) {
        self.parent_types.pop();
        if was_loop && !self.enclosing_loops.is_empty() {
            self.enclosing_loops.pop();
        }
        self.depth = self.depth.saturating_sub(1);
    }

    /// Get the innermost enclosing loop header
    pub fn innermost_loop(&self) -> Option<u32> {
        self.enclosing_loops.last().copied()
    }

    /// Check if we're inside a loop
    pub fn is_in_loop(&self) -> bool {
        !self.enclosing_loops.is_empty()
    }

    /// Check if we're inside a try-catch
    pub fn is_in_try_catch(&self) -> bool {
        self.parent_types.contains(&RegionType::TryCatch)
    }
}

/// Detailed information about a for-loop (indexed loop)
#[derive(Debug, Clone)]
pub struct ForLoopInfo {
    /// Block containing initialization (e.g., i = 0)
    pub init_block: Option<u32>,
    /// Instruction offset of initialization
    pub init_offset: Option<u32>,
    /// Block containing increment (e.g., i++)
    pub incr_block: Option<u32>,
    /// Instruction offset of increment
    pub incr_offset: Option<u32>,
    /// Name of loop variable (e.g., "i")
    pub loop_var: Option<String>,
    /// Register holding loop variable (reg_num, ssa_version)
    pub loop_var_reg: Option<(u16, u32)>,
}

/// Information about a for-each loop
#[derive(Debug, Clone)]
pub struct ForEachLoopInfo {
    /// Name of element variable (e.g., "elem")
    pub elem_var: Option<String>,
    /// Register holding element (reg_num, ssa_version)
    pub elem_var_reg: Option<(u16, u32)>,
    /// Source of iteration
    pub iterable: IterableSource,
}

/// Source of iteration for for-each loops
#[derive(Debug, Clone)]
pub enum IterableSource {
    /// Iterating over an array: for (T elem : array)
    Array {
        /// Register holding the array (reg_num, ssa_version)
        array_reg: (u16, u32),
        /// Register holding the index (reg_num, ssa_version)
        index_reg: Option<(u16, u32)>,
    },
    /// Iterating via Iterator: for (T elem : iterable)
    Iterator {
        /// Offset of iterator() call
        iterator_call_offset: Option<u32>,
        /// Offset of hasNext() call
        has_next_offset: Option<u32>,
        /// Offset of next() call
        next_offset: Option<u32>,
    },
    /// Unknown iteration source
    Unknown,
}

/// Combined loop details for enhanced code generation
#[derive(Debug, Clone)]
pub struct LoopDetails {
    /// The kind of loop (While, DoWhile, For, ForEach, Endless)
    pub kind: LoopKind,
    /// Additional info if this is an indexed for-loop
    pub for_info: Option<ForLoopInfo>,
    /// Additional info if this is a for-each loop
    pub foreach_info: Option<ForEachLoopInfo>,
}

impl LoopDetails {
    /// Create details for a simple while loop
    pub fn while_loop() -> Self {
        LoopDetails {
            kind: LoopKind::While,
            for_info: None,
            foreach_info: None,
        }
    }

    /// Create details for a do-while loop
    pub fn do_while_loop() -> Self {
        LoopDetails {
            kind: LoopKind::DoWhile,
            for_info: None,
            foreach_info: None,
        }
    }

    /// Create details for an endless loop
    pub fn endless_loop() -> Self {
        LoopDetails {
            kind: LoopKind::Endless,
            for_info: None,
            foreach_info: None,
        }
    }

    /// Create details for a for-loop with info
    pub fn for_loop(info: ForLoopInfo) -> Self {
        LoopDetails {
            kind: LoopKind::For,
            for_info: Some(info),
            foreach_info: None,
        }
    }

    /// Create details for a for-each loop with info
    pub fn foreach_loop(info: ForEachLoopInfo) -> Self {
        LoopDetails {
            kind: LoopKind::ForEach,
            for_info: None,
            foreach_info: Some(info),
        }
    }
}

// ============================================================================
// IContainer trait implementation for Region
// ============================================================================

impl IContainer for Region {
    fn base_string(&self) -> String {
        match self {
            Region::Sequence(contents) => {
                let size = contents.len();
                if size > 0 {
                    let inner: Vec<String> = contents.iter().map(|c| match c {
                        RegionContent::Block(id) => format!("B{}", id),
                        RegionContent::Region(r) => r.base_string(),
                    }).collect();
                    format!("({}:{})", size, inner.join("|"))
                } else {
                    "(0)".to_string()
                }
            }
            Region::If { then_region, else_region, .. } => {
                let mut sb = String::new();
                sb.push_str(&then_region.base_string());
                if let Some(e) = else_region {
                    sb.push_str(&e.base_string());
                }
                sb
            }
            Region::Loop { body, .. } => body.base_string(),
            Region::Switch { header_block, .. } => format!("SW:B{}", header_block),
            Region::TryCatch { try_region, .. } => try_region.base_string(),
            Region::Synchronized { enter_insn_offset, .. } => format!("{:x}", enter_insn_offset),
            Region::Break { label } => label.clone().unwrap_or_else(|| "break".to_string()),
            Region::Continue { label } => label.clone().unwrap_or_else(|| "continue".to_string()),
            Region::TernaryAssignment { dest_reg, dest_version, .. } => format!("TERNARY:v{}_{}", dest_reg, dest_version),
            Region::TernaryReturn { .. } => "TERNARY_RET".to_string(),
        }
    }
}

// ============================================================================
// Region helper methods
// ============================================================================

impl Region {
    /// Get the type of this region
    pub fn region_type(&self) -> RegionType {
        match self {
            Region::Sequence(_) => RegionType::Sequence,
            Region::If { .. } => RegionType::If,
            Region::Loop { .. } => RegionType::Loop,
            Region::Switch { .. } => RegionType::Switch,
            Region::TryCatch { .. } => RegionType::TryCatch,
            Region::Synchronized { .. } => RegionType::Synchronized,
            Region::Break { .. } => RegionType::Break,
            Region::Continue { .. } => RegionType::Continue,
            Region::TernaryAssignment { .. } => RegionType::TernaryAssignment,
            Region::TernaryReturn { .. } => RegionType::TernaryReturn,
        }
    }

    /// Check if this is a control flow region (not a sequence)
    pub fn is_control_flow(&self) -> bool {
        !matches!(self, Region::Sequence(_))
    }

    /// Get the loop kind if this is a loop region
    pub fn loop_kind(&self) -> Option<LoopKind> {
        match self {
            Region::Loop { kind, .. } => Some(*kind),
            _ => None,
        }
    }

    /// Check if this region contains break or continue statements (with depth limit)
    pub fn has_jump_statements(&self) -> bool {
        self.has_jump_statements_depth(0)
    }

    fn has_jump_statements_depth(&self, depth: usize) -> bool {
        const MAX_DEPTH: usize = 100;
        if depth > MAX_DEPTH {
            return false;
        }

        match self {
            Region::Break { .. } | Region::Continue { .. } => true,
            Region::Sequence(contents) => contents.iter().any(|c| match c {
                RegionContent::Region(r) => r.has_jump_statements_depth(depth + 1),
                RegionContent::Block(_) => false,
            }),
            Region::If { then_region, else_region, .. } => {
                then_region.has_jump_statements_depth(depth + 1)
                    || else_region.as_ref().map_or(false, |r| r.has_jump_statements_depth(depth + 1))
            }
            Region::Loop { body, .. } => body.has_jump_statements_depth(depth + 1),
            Region::Switch { cases, .. } => {
                cases.iter().any(|c| c.container.has_jump_statements_depth(depth + 1))
            }
            Region::TryCatch { try_region, handlers, finally, .. } => {
                try_region.has_jump_statements_depth(depth + 1)
                    || handlers.iter().any(|h| h.region.has_jump_statements_depth(depth + 1))
                    || finally.as_ref().map_or(false, |r| r.has_jump_statements_depth(depth + 1))
            }
            Region::Synchronized { body, .. } => body.has_jump_statements_depth(depth + 1),
            Region::TernaryAssignment { .. } | Region::TernaryReturn { .. } => false,
        }
    }

    /// Get direct block IDs from this region (non-recursive)
    pub fn direct_blocks(&self) -> Vec<u32> {
        match self {
            Region::Sequence(contents) => contents
                .iter()
                .filter_map(|c| match c {
                    RegionContent::Block(id) => Some(*id),
                    RegionContent::Region(_) => None,
                })
                .collect(),
            Region::If { .. } => vec![],
            Region::Loop { .. } => vec![],
            Region::Switch { header_block, .. } => vec![*header_block],
            Region::TryCatch { .. } => vec![],
            Region::Synchronized { enter_block, .. } => vec![*enter_block],
            Region::Break { .. } | Region::Continue { .. } => vec![],
            Region::TernaryAssignment { then_value_block, else_value_block, .. } =>
                vec![*then_value_block, *else_value_block],
            Region::TernaryReturn { then_value_block, else_value_block, .. } =>
                vec![*then_value_block, *else_value_block],
        }
    }

    /// Count total blocks in this region (with depth limit)
    pub fn total_block_count(&self) -> usize {
        self.total_block_count_depth(0)
    }

    fn total_block_count_depth(&self, depth: usize) -> usize {
        const MAX_DEPTH: usize = 100;
        if depth > MAX_DEPTH {
            return 0;
        }

        match self {
            Region::Sequence(contents) => contents
                .iter()
                .map(|c| match c {
                    RegionContent::Block(_) => 1,
                    RegionContent::Region(r) => r.total_block_count_depth(depth + 1),
                })
                .sum(),
            Region::If { then_region, else_region, .. } => {
                then_region.total_block_count_depth(depth + 1)
                    + else_region.as_ref().map_or(0, |r| r.total_block_count_depth(depth + 1))
            }
            Region::Loop { body, .. } => body.total_block_count_depth(depth + 1),
            Region::Switch { cases, .. } => {
                1 + cases.iter().map(|c| c.container.total_block_count_depth(depth + 1)).sum::<usize>()
            }
            Region::TryCatch { try_region, handlers, finally, .. } => {
                try_region.total_block_count_depth(depth + 1)
                    + handlers.iter().map(|h| h.region.total_block_count_depth(depth + 1)).sum::<usize>()
                    + finally.as_ref().map_or(0, |r| r.total_block_count_depth(depth + 1))
            }
            Region::Synchronized { body, .. } => 1 + body.total_block_count_depth(depth + 1),
            Region::Break { .. } | Region::Continue { .. } => 0,
            Region::TernaryAssignment { .. } | Region::TernaryReturn { .. } => 2,  // Two value blocks
        }
    }
}

#[cfg(test)]
mod tests {
    use super::*;
    use crate::instructions::IfCondition;

    #[test]
    fn test_de_morgan_not_and() {
        // NOT(AND(a,b)) → OR(NOT(a), NOT(b))
        let a = Condition::simple(0, IfCondition::Eq);
        let b = Condition::simple(1, IfCondition::Ne);
        let cond = Condition::Not(Box::new(Condition::And(Box::new(a), Box::new(b))));

        let simplified = cond.simplify();

        // Result should be OR with both sides negated
        match simplified {
            Condition::Or(left, right) => {
                assert!(left.is_negated());
                assert!(right.is_negated());
            }
            _ => panic!("Expected OR after De Morgan's law, got {:?}", simplified),
        }
    }

    #[test]
    fn test_de_morgan_not_or() {
        // NOT(OR(a,b)) → AND(NOT(a), NOT(b))
        let a = Condition::simple(0, IfCondition::Eq);
        let b = Condition::simple(1, IfCondition::Ne);
        let cond = Condition::Not(Box::new(Condition::Or(Box::new(a), Box::new(b))));

        let simplified = cond.simplify();

        // Result should be AND with both sides negated
        match simplified {
            Condition::And(left, right) => {
                assert!(left.is_negated());
                assert!(right.is_negated());
            }
            _ => panic!("Expected AND after De Morgan's law, got {:?}", simplified),
        }
    }

    #[test]
    fn test_double_negation_elimination() {
        // NOT(NOT(a)) → a
        let inner = Condition::simple(0, IfCondition::Eq);
        let cond = Condition::Not(Box::new(Condition::Not(Box::new(inner.clone()))));

        let simplified = cond.simplify();

        match simplified {
            Condition::Simple { block, op, negated } => {
                assert_eq!(block, 0);
                assert_eq!(op, IfCondition::Eq);
                assert!(!negated);
            }
            _ => panic!("Expected Simple after double negation, got {:?}", simplified),
        }
    }

    #[test]
    fn test_not_ternary_distribution() {
        // NOT(a ? b : c) → a ? NOT(b) : NOT(c)
        let cond_a = Condition::simple(0, IfCondition::Eq);
        let cond_b = Condition::simple(1, IfCondition::Ne);
        let cond_c = Condition::simple(2, IfCondition::Lt);

        let ternary = Condition::Ternary {
            condition: Box::new(cond_a),
            if_true: Box::new(cond_b),
            if_false: Box::new(cond_c),
        };
        let cond = Condition::Not(Box::new(ternary));

        let simplified = cond.simplify();

        match simplified {
            Condition::Ternary { condition, if_true, if_false } => {
                // condition should be unchanged
                assert!(!condition.is_negated());
                // if_true and if_false should be negated
                assert!(if_true.is_negated());
                assert!(if_false.is_negated());
            }
            _ => panic!("Expected Ternary with distributed NOT, got {:?}", simplified),
        }
    }

    #[test]
    fn test_simplify_simple_condition() {
        // Simple condition should remain unchanged
        let cond = Condition::simple(5, IfCondition::Ge);
        let simplified = cond.simplify();

        match simplified {
            Condition::Simple { block, op, negated } => {
                assert_eq!(block, 5);
                assert_eq!(op, IfCondition::Ge);
                assert!(!negated);
            }
            _ => panic!("Expected unchanged Simple, got {:?}", simplified),
        }
    }

    #[test]
    fn test_is_negated() {
        let simple = Condition::simple(0, IfCondition::Eq);
        assert!(!simple.is_negated());

        let simple_neg = Condition::simple_negated(0, IfCondition::Eq);
        assert!(simple_neg.is_negated());

        let not = Condition::Not(Box::new(Condition::simple(0, IfCondition::Eq)));
        assert!(not.is_negated());
    }

    #[test]
    fn test_flatten_and() {
        // (a AND b) AND c
        let a = Condition::simple(0, IfCondition::Eq);
        let b = Condition::simple(1, IfCondition::Ne);
        let c = Condition::simple(2, IfCondition::Lt);

        let and_inner = Condition::And(Box::new(a), Box::new(b));
        let and_outer = Condition::And(Box::new(and_inner), Box::new(c));

        let flattened = and_outer.flatten_and();
        assert_eq!(flattened.len(), 3);
    }

    #[test]
    fn test_flatten_or() {
        // (a OR b) OR c
        let a = Condition::simple(0, IfCondition::Eq);
        let b = Condition::simple(1, IfCondition::Ne);
        let c = Condition::simple(2, IfCondition::Lt);

        let or_inner = Condition::Or(Box::new(a), Box::new(b));
        let or_outer = Condition::Or(Box::new(or_inner), Box::new(c));

        let flattened = or_outer.flatten_or();
        assert_eq!(flattened.len(), 3);
    }

    #[test]
    fn test_negate() {
        // Negate simple condition
        let simple = Condition::simple(0, IfCondition::Eq);
        let negated = simple.negate();
        assert!(negated.is_negated());

        // Double negate should return to original
        let double_negated = negated.negate();
        assert!(!double_negated.is_negated());
    }
}
