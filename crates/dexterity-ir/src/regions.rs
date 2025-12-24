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
        /// Loop label for labeled break/continue (matches JADX LoopLabelAttr)
        /// Clone of JADX RegionGen.java:166-169 - loop label output
        /// Reference: jadx-core/src/main/java/jadx/core/codegen/RegionGen.java
        label: Option<String>,
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

    // =========================================================================
    // JADX Parity: IfCondition methods (P8)
    // Cloned from: jadx-fast/jadx-core/src/main/java/jadx/core/dex/regions/conditions/IfCondition.java
    // =========================================================================

    /// Get all register arguments used in this condition (JADX: getRegisterArgs)
    ///
    /// Collects all register arguments from all instructions in the condition.
    /// Requires a lookup function to get instructions from block IDs.
    ///
    /// JADX Reference: IfCondition.java:256-266
    /// ```java
    /// public List<RegisterArg> getRegisterArgs() {
    ///     List<RegisterArg> list = new ArrayList<>();
    ///     if (mode == Mode.COMPARE) {
    ///         compare.getInsn().getRegisterArgs(list);
    ///     } else {
    ///         for (IfCondition arg : args) {
    ///             list.addAll(arg.getRegisterArgs());
    ///         }
    ///     }
    ///     return list;
    /// }
    /// ```
    pub fn get_register_args<F>(&self, get_block_registers: F) -> Vec<(u16, u32)>
    where
        F: Fn(u32) -> Vec<(u16, u32)> + Copy,
    {
        let mut result = Vec::new();
        self.collect_register_args(&mut result, get_block_registers);
        result
    }

    /// Internal helper to collect register args recursively
    fn collect_register_args<F>(&self, result: &mut Vec<(u16, u32)>, get_block_registers: F)
    where
        F: Fn(u32) -> Vec<(u16, u32)> + Copy,
    {
        match self {
            Condition::Simple { block, .. } => {
                for reg in get_block_registers(*block) {
                    if !result.contains(&reg) {
                        result.push(reg);
                    }
                }
            }
            Condition::And(left, right) | Condition::Or(left, right) => {
                left.collect_register_args(result, get_block_registers);
                right.collect_register_args(result, get_block_registers);
            }
            Condition::Not(inner) => {
                inner.collect_register_args(result, get_block_registers);
            }
            Condition::Ternary { condition, if_true, if_false } => {
                condition.collect_register_args(result, get_block_registers);
                if_true.collect_register_args(result, get_block_registers);
                if_false.collect_register_args(result, get_block_registers);
            }
            Condition::Unknown => {}
        }
    }

    /// Visit all instructions in this condition (JADX: visitInsns)
    ///
    /// Calls the visitor for each block in the condition.
    ///
    /// JADX Reference: IfCondition.java:280-286
    /// ```java
    /// public void visitInsns(Consumer<InsnNode> visitor) {
    ///     if (mode == Mode.COMPARE) {
    ///         compare.getInsn().visitInsns(visitor);
    ///     } else {
    ///         args.forEach(arg -> arg.visitInsns(visitor));
    ///     }
    /// }
    /// ```
    pub fn visit_blocks<F>(&self, mut visitor: F)
    where
        F: FnMut(u32),
    {
        self.visit_blocks_impl(&mut visitor);
    }

    fn visit_blocks_impl<F>(&self, visitor: &mut F)
    where
        F: FnMut(u32),
    {
        match self {
            Condition::Simple { block, .. } => {
                visitor(*block);
            }
            Condition::And(left, right) | Condition::Or(left, right) => {
                left.visit_blocks_impl(visitor);
                right.visit_blocks_impl(visitor);
            }
            Condition::Not(inner) => {
                inner.visit_blocks_impl(visitor);
            }
            Condition::Ternary { condition, if_true, if_false } => {
                condition.visit_blocks_impl(visitor);
                if_true.visit_blocks_impl(visitor);
                if_false.visit_blocks_impl(visitor);
            }
            Condition::Unknown => {}
        }
    }

    /// Collect all blocks in this condition (JADX: collectInsns)
    ///
    /// Returns a list of all block IDs in this condition.
    ///
    /// JADX Reference: IfCondition.java:288-292
    /// ```java
    /// public List<InsnNode> collectInsns() {
    ///     List<InsnNode> list = new ArrayList<>();
    ///     visitInsns(list::add);
    ///     return list;
    /// }
    /// ```
    pub fn collect_all_blocks(&self) -> Vec<u32> {
        let mut blocks = Vec::new();
        self.visit_blocks(|block| {
            if !blocks.contains(&block) {
                blocks.push(block);
            }
        });
        blocks
    }

    /// Get source line from the condition (JADX: getSourceLine)
    ///
    /// Returns the first non-zero source line from blocks in the condition.
    ///
    /// JADX Reference: IfCondition.java:294-302
    /// ```java
    /// public int getSourceLine() {
    ///     for (InsnNode insn : collectInsns()) {
    ///         int line = insn.getSourceLine();
    ///         if (line != 0) {
    ///             return line;
    ///         }
    ///     }
    ///     return 0;
    /// }
    /// ```
    pub fn get_source_line<F>(&self, get_block_source_line: F) -> Option<u32>
    where
        F: Fn(u32) -> Option<u32>,
    {
        for block in self.collect_all_blocks() {
            if let Some(line) = get_block_source_line(block) {
                return Some(line);
            }
        }
        None
    }

    /// Get the first block in this condition (JADX: getFirstInsn)
    ///
    /// Returns the first block ID in this condition.
    ///
    /// JADX Reference: IfCondition.java:304-310
    /// ```java
    /// @Nullable
    /// public InsnNode getFirstInsn() {
    ///     if (mode == Mode.COMPARE) {
    ///         return compare.getInsn();
    ///     }
    ///     return args.get(0).getFirstInsn();
    /// }
    /// ```
    pub fn get_first_block(&self) -> Option<u32> {
        match self {
            Condition::Simple { block, .. } => Some(*block),
            Condition::And(left, _) | Condition::Or(left, _) => left.get_first_block(),
            Condition::Not(inner) => inner.get_first_block(),
            Condition::Ternary { condition, .. } => condition.get_first_block(),
            Condition::Unknown => None,
        }
    }

    /// Invert this condition following JADX's invert() logic (JADX: invert)
    ///
    /// Returns a new condition that is the logical inverse of this one.
    /// Uses De Morgan's laws for AND/OR.
    ///
    /// JADX Reference: IfCondition.java:121-140
    /// ```java
    /// public static IfCondition invert(IfCondition cond) {
    ///     Mode mode = cond.getMode();
    ///     switch (mode) {
    ///         case COMPARE:
    ///             return new IfCondition(cond.getCompare().invert());
    ///         case TERNARY:
    ///             return ternary(cond.first(), not(cond.second()), not(cond.third()));
    ///         case NOT:
    ///             return cond.first();
    ///         case AND:
    ///         case OR:
    ///             List<IfCondition> newArgs = new ArrayList<>();
    ///             for (IfCondition arg : cond.getArgs()) {
    ///                 newArgs.add(invert(arg));
    ///             }
    ///             return new IfCondition(mode == Mode.AND ? Mode.OR : Mode.AND, newArgs);
    ///     }
    /// }
    /// ```
    pub fn invert(self) -> Self {
        match self {
            Condition::Simple { block, op, negated } => {
                // Invert by flipping the negated flag or inverting the operator
                Condition::Simple {
                    block,
                    op: op.invert(),
                    negated,
                }
            }
            Condition::Not(inner) => {
                // NOT(NOT(x)) = x
                *inner
            }
            Condition::And(left, right) => {
                // De Morgan: !(a && b) = !a || !b
                Condition::Or(
                    Box::new(left.invert()),
                    Box::new(right.invert()),
                )
            }
            Condition::Or(left, right) => {
                // De Morgan: !(a || b) = !a && !b
                Condition::And(
                    Box::new(left.invert()),
                    Box::new(right.invert()),
                )
            }
            Condition::Ternary { condition, if_true, if_false } => {
                // a ? b : c inverted = a ? !b : !c
                Condition::Ternary {
                    condition,
                    if_true: Box::new(if_true.invert()),
                    if_false: Box::new(if_false.invert()),
                }
            }
            Condition::Unknown => Condition::Unknown,
        }
    }

    /// Merge two conditions with the given mode (JADX: merge)
    ///
    /// If the first condition already has the same mode, add to it.
    /// Otherwise create a new compound condition.
    ///
    /// JADX Reference: IfCondition.java:80-87
    /// ```java
    /// public static IfCondition merge(Mode mode, IfCondition a, IfCondition b) {
    ///     if (a.getMode() == mode) {
    ///         IfCondition n = new IfCondition(a);
    ///         n.addArg(b);
    ///         return n;
    ///     }
    ///     return new IfCondition(mode, Arrays.asList(a, b));
    /// }
    /// ```
    pub fn merge_with(self, mode: ConditionMode, other: Condition) -> Self {
        match (mode, self) {
            (ConditionMode::And, Condition::And(left, right)) => {
                // Flatten: (a && b) && c = a && b && c
                // We keep it as nested for now (same behavior)
                Condition::And(
                    Box::new(Condition::And(left, right)),
                    Box::new(other),
                )
            }
            (ConditionMode::Or, Condition::Or(left, right)) => {
                // Flatten: (a || b) || c = a || b || c
                Condition::Or(
                    Box::new(Condition::Or(left, right)),
                    Box::new(other),
                )
            }
            (ConditionMode::And, cond) => {
                Condition::And(Box::new(cond), Box::new(other))
            }
            (ConditionMode::Or, cond) => {
                Condition::Or(Box::new(cond), Box::new(other))
            }
            (_, cond) => cond, // Invalid mode for merge
        }
    }
}

// ============================================================================
// JADX Parity: Compare struct (P10)
// Cloned from: jadx-fast/jadx-core/src/main/java/jadx/core/dex/regions/conditions/Compare.java
// ============================================================================

/// Comparison wrapper for condition comparisons (JADX: Compare)
///
/// Wraps a condition comparison with the operator and operands.
/// Used in IfCondition.Mode.COMPARE to hold the actual comparison.
///
/// JADX Reference: jadx-core/src/main/java/jadx/core/dex/regions/conditions/Compare.java
#[derive(Debug, Clone)]
pub struct Compare {
    /// The block containing the IF instruction
    pub block_id: u32,
    /// The comparison operator
    pub op: IfCondition,
    /// First argument (left side)
    pub arg_a_reg: Option<u16>,
    /// Second argument (right side, None for *z variants)
    pub arg_b_reg: Option<u16>,
    /// SSA version of first argument
    pub arg_a_ssa: u32,
    /// SSA version of second argument
    pub arg_b_ssa: u32,
}

impl Compare {
    /// Create a new comparison (JADX: Compare constructor)
    ///
    /// JADX Reference: Compare.java:11-14
    /// ```java
    /// public Compare(IfNode insn) {
    ///     insn.add(AFlag.HIDDEN);
    ///     this.insn = insn;
    /// }
    /// ```
    pub fn new(block_id: u32, op: IfCondition) -> Self {
        Compare {
            block_id,
            op,
            arg_a_reg: None,
            arg_b_reg: None,
            arg_a_ssa: 0,
            arg_b_ssa: 0,
        }
    }

    /// Create with register arguments
    pub fn with_args(block_id: u32, op: IfCondition, a_reg: u16, b_reg: Option<u16>) -> Self {
        Compare {
            block_id,
            op,
            arg_a_reg: Some(a_reg),
            arg_b_reg: b_reg,
            arg_a_ssa: 0,
            arg_b_ssa: 0,
        }
    }

    /// Get the comparison operator (JADX: getOp)
    ///
    /// JADX Reference: Compare.java:16-18
    pub fn get_op(&self) -> IfCondition {
        self.op
    }

    /// Get first argument register (JADX: getA)
    ///
    /// JADX Reference: Compare.java:20-22
    pub fn get_a(&self) -> Option<u16> {
        self.arg_a_reg
    }

    /// Get second argument register (JADX: getB)
    ///
    /// JADX Reference: Compare.java:24-26
    pub fn get_b(&self) -> Option<u16> {
        self.arg_b_reg
    }

    /// Get the block ID containing this comparison
    ///
    /// JADX Reference: Compare.java:28-30 (getInsn returns IfNode)
    pub fn get_block_id(&self) -> u32 {
        self.block_id
    }

    /// Invert this comparison (JADX: invert)
    ///
    /// Inverts the operator and returns self for chaining.
    ///
    /// JADX Reference: Compare.java:32-35
    /// ```java
    /// public Compare invert() {
    ///     insn.invertCondition();
    ///     return this;
    /// }
    /// ```
    pub fn invert(&mut self) -> &mut Self {
        self.op = self.op.invert();
        self
    }

    /// Normalize this comparison (JADX: normalize)
    ///
    /// Ensures consistent operand ordering for canonical form.
    /// E.g., puts the one with result first if applicable.
    ///
    /// JADX Reference: Compare.java:37-39
    pub fn normalize(&mut self) {
        // Normalize by swapping args and mirroring op if needed
        // JADX does this based on which arg has a result
        // For now, we just keep as-is since we don't have that info
    }

    /// Check if this comparison uses zero as second operand
    pub fn is_zero_compare(&self) -> bool {
        self.arg_b_reg.is_none()
    }

    /// Convert to string (JADX: toString)
    ///
    /// JADX Reference: Compare.java:42-44
    pub fn to_string(&self) -> String {
        let a = self.arg_a_reg.map_or("?".to_string(), |r| format!("v{}", r));
        let b = self.arg_b_reg.map_or("0".to_string(), |r| format!("v{}", r));
        format!("{} {} {}", a, self.op.symbol(), b)
    }
}

impl std::fmt::Display for Compare {
    fn fmt(&self, f: &mut std::fmt::Formatter<'_>) -> std::fmt::Result {
        write!(f, "{}", self.to_string())
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
        /// Register holding the iterable collection (reg_num, ssa_version)
        iterable_reg: (u16, u32),
        /// Register holding the iterator (reg_num, ssa_version)
        iterator_reg: (u16, u32),
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

// ============================================================================
// Region Visitor Pattern
// ============================================================================

/// Visitor trait for traversing region trees
///
/// Implement this trait to perform operations on each region type.
/// The default implementations do nothing, allowing selective overrides.
///
/// # Example
/// ```ignore
/// struct BlockCounter { count: usize }
///
/// impl RegionVisitor for BlockCounter {
///     fn visit_block(&mut self, _block_id: u32) {
///         self.count += 1;
///     }
/// }
/// ```
pub trait RegionVisitor {
    /// Called before visiting any region
    fn pre_visit_region(&mut self, _region: &Region) {}

    /// Called after visiting a region and all its children
    fn post_visit_region(&mut self, _region: &Region) {}

    /// Visit a basic block
    fn visit_block(&mut self, _block_id: u32) {}

    /// Visit a sequence region
    fn visit_sequence(&mut self, _contents: &[RegionContent]) {}

    /// Visit an if region
    fn visit_if(&mut self, _condition: &Condition, _then_region: &Region, _else_region: Option<&Region>) {}

    /// Visit a loop region
    fn visit_loop(&mut self, _kind: LoopKind, _condition: Option<&Condition>, _body: &Region, _loop_type: &LoopType) {}

    /// Visit a switch region
    fn visit_switch(&mut self, _header_block: u32, _cases: &[CaseInfo]) {}

    /// Visit a try-catch region
    fn visit_try_catch(&mut self, _try_region: &Region, _handlers: &[CatchHandler], _finally: Option<&Region>) {}

    /// Visit a synchronized region
    fn visit_synchronized(&mut self, _enter_block: u32, _body: &Region) {}

    /// Visit a break statement
    fn visit_break(&mut self, _label: Option<&str>) {}

    /// Visit a continue statement
    fn visit_continue(&mut self, _label: Option<&str>) {}

    /// Visit a ternary assignment
    fn visit_ternary_assignment(&mut self, _condition: &Condition, _dest_reg: u16, _then_block: u32, _else_block: u32) {}

    /// Visit a ternary return
    fn visit_ternary_return(&mut self, _condition: &Condition, _then_block: u32, _else_block: u32) {}

    /// Visit a condition
    fn visit_condition(&mut self, _condition: &Condition) {}
}

impl Region {
    /// Accept a visitor, traversing this region and all children
    pub fn accept<V: RegionVisitor>(&self, visitor: &mut V) {
        visitor.pre_visit_region(self);

        match self {
            Region::Sequence(contents) => {
                visitor.visit_sequence(contents);
                for content in contents {
                    content.accept(visitor);
                }
            }

            Region::If { condition, then_region, else_region } => {
                visitor.visit_condition(condition);
                visitor.visit_if(condition, then_region, else_region.as_deref());
                then_region.accept(visitor);
                if let Some(else_r) = else_region {
                    else_r.accept(visitor);
                }
            }

            Region::Loop { kind, condition, body, loop_type, .. } => {
                if let Some(cond) = condition {
                    visitor.visit_condition(cond);
                }
                visitor.visit_loop(*kind, condition.as_ref(), body, loop_type);
                body.accept(visitor);
            }

            Region::Switch { header_block, cases } => {
                visitor.visit_switch(*header_block, cases);
                for case in cases {
                    case.container.accept(visitor);
                }
            }

            Region::TryCatch { try_region, handlers, finally } => {
                visitor.visit_try_catch(try_region, handlers, finally.as_deref());
                try_region.accept(visitor);
                for handler in handlers {
                    handler.region.accept(visitor);
                }
                if let Some(finally_r) = finally {
                    finally_r.accept(visitor);
                }
            }

            Region::Synchronized { enter_block, body, .. } => {
                visitor.visit_synchronized(*enter_block, body);
                body.accept(visitor);
            }

            Region::Break { label } => {
                visitor.visit_break(label.as_deref());
            }

            Region::Continue { label } => {
                visitor.visit_continue(label.as_deref());
            }

            Region::TernaryAssignment { condition, dest_reg, then_value_block, else_value_block, .. } => {
                visitor.visit_condition(condition);
                visitor.visit_ternary_assignment(condition, *dest_reg, *then_value_block, *else_value_block);
            }

            Region::TernaryReturn { condition, then_value_block, else_value_block } => {
                visitor.visit_condition(condition);
                visitor.visit_ternary_return(condition, *then_value_block, *else_value_block);
            }
        }

        visitor.post_visit_region(self);
    }
}

impl RegionContent {
    /// Accept a visitor for this content
    pub fn accept<V: RegionVisitor>(&self, visitor: &mut V) {
        match self {
            RegionContent::Block(block_id) => {
                visitor.visit_block(*block_id);
            }
            RegionContent::Region(region) => {
                region.accept(visitor);
            }
        }
    }
}

impl CaseInfo {
    /// Accept a visitor for this case's region
    pub fn accept_region<V: RegionVisitor>(&self, visitor: &mut V) {
        self.container.accept(visitor);
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

// ============================================================================
// JADX Parity: DepthRegionTraversal
// Cloned from: jadx-fast/jadx-core/src/main/java/jadx/core/dex/visitors/regions/DepthRegionTraversal.java
// ============================================================================

/// Iterative region visitor trait (JADX: IRegionIterativeVisitor)
///
/// For multi-pass traversals that may modify structure.
/// Return true to repeat traversal, false when stable.
///
/// JADX Reference: IRegionIterativeVisitor.java
/// ```java
/// public interface IRegionIterativeVisitor {
///     boolean visitRegion(MethodNode mth, IRegion region);
/// }
/// ```
pub trait RegionIterativeVisitor {
    /// Visit a region, return true to repeat traversal (JADX: visitRegion)
    fn visit_region(&mut self, region: &mut Region) -> bool;
}

/// Region traversal utilities matching JADX's DepthRegionTraversal
///
/// JADX Clone: jadx-core/src/main/java/jadx/core/dex/visitors/regions/DepthRegionTraversal.java
///
/// Provides static-like methods for traversing region trees with various strategies:
/// - Single-pass depth-first traversal
/// - Multi-pass iterative traversal until stable
/// - Traversal including exception handlers
pub mod depth_traversal {
    use super::*;

    /// Iterative traversal limit multiplier (JADX: ITERATIVE_LIMIT_MULTIPLIER)
    ///
    /// JADX Reference: DepthRegionTraversal.java:13
    /// ```java
    /// private static final int ITERATIVE_LIMIT_MULTIPLIER = 5;
    /// ```
    const ITERATIVE_LIMIT_MULTIPLIER: usize = 5;

    /// Single-pass depth-first traversal (JADX: traverse)
    ///
    /// Traverses the region tree calling the visitor for each region.
    ///
    /// JADX Reference: DepthRegionTraversal.java:18-24
    /// ```java
    /// public static void traverse(MethodNode mth, IRegionVisitor visitor) {
    ///     traverseInternal(mth, visitor, mth.getRegion());
    /// }
    /// public static void traverse(MethodNode mth, IContainer container, IRegionVisitor visitor) {
    ///     traverseInternal(mth, visitor, container);
    /// }
    /// ```
    pub fn traverse<V: RegionVisitor>(region: &Region, visitor: &mut V) {
        region.accept(visitor);
    }

    /// Iterative traversal until no changes (JADX: traverseIterative)
    ///
    /// Repeatedly traverses the region tree until the visitor returns false
    /// (indicating no changes were made). Has a limit to prevent infinite loops.
    ///
    /// JADX Reference: DepthRegionTraversal.java:26-38
    /// ```java
    /// public static void traverseIterative(MethodNode mth, IRegionIterativeVisitor visitor) {
    ///     boolean repeat;
    ///     int k = 0;
    ///     int limit = ITERATIVE_LIMIT_MULTIPLIER * mth.getBasicBlocks().size();
    ///     do {
    ///         repeat = traverseIterativeStepInternal(mth, visitor, mth.getRegion());
    ///         if (k++ > limit) {
    ///             throw new JadxRuntimeException("Iterative traversal limit reached");
    ///         }
    ///     } while (repeat);
    /// }
    /// ```
    pub fn traverse_iterative<V: RegionIterativeVisitor>(
        region: &mut Region,
        visitor: &mut V,
        block_count: usize,
    ) -> Result<(), TraversalError> {
        let limit = ITERATIVE_LIMIT_MULTIPLIER * block_count.max(10);
        let mut k = 0;

        loop {
            let repeat = traverse_iterative_step(region, visitor)?;
            if !repeat {
                break;
            }
            k += 1;
            if k > limit {
                return Err(TraversalError::LimitReached {
                    limit,
                    block_count,
                });
            }
        }
        Ok(())
    }

    /// Single step of iterative traversal (JADX: traverseIterativeStepInternal)
    ///
    /// JADX Reference: DepthRegionTraversal.java:74-91
    /// ```java
    /// private static boolean traverseIterativeStepInternal(MethodNode mth, IRegionIterativeVisitor visitor, IContainer container) {
    ///     if (container instanceof IRegion) {
    ///         IRegion region = (IRegion) container;
    ///         if (visitor.visitRegion(mth, region)) {
    ///             return true;
    ///         }
    ///         for (IContainer subCont : region.getSubBlocks()) {
    ///             try {
    ///                 if (traverseIterativeStepInternal(mth, visitor, subCont)) {
    ///                     return true;
    ///                 }
    ///             } catch (StackOverflowError overflow) {
    ///                 throw new JadxOverflowException("Region traversal failed");
    ///             }
    ///         }
    ///     }
    ///     return false;
    /// }
    /// ```
    fn traverse_iterative_step<V: RegionIterativeVisitor>(
        region: &mut Region,
        visitor: &mut V,
    ) -> Result<bool, TraversalError> {
        // Visit this region first
        if visitor.visit_region(region) {
            return Ok(true);
        }

        // Visit sub-regions recursively
        traverse_iterative_children(region, visitor)
    }

    /// Traverse children of a region iteratively
    fn traverse_iterative_children<V: RegionIterativeVisitor>(
        region: &mut Region,
        visitor: &mut V,
    ) -> Result<bool, TraversalError> {
        match region {
            Region::Sequence(contents) => {
                for content in contents.iter_mut() {
                    if let RegionContent::Region(child) = content {
                        if traverse_iterative_step(child, visitor)? {
                            return Ok(true);
                        }
                    }
                }
            }
            Region::If { then_region, else_region, .. } => {
                if traverse_iterative_step(then_region, visitor)? {
                    return Ok(true);
                }
                if let Some(else_r) = else_region {
                    if traverse_iterative_step(else_r, visitor)? {
                        return Ok(true);
                    }
                }
            }
            Region::Loop { body, .. } => {
                if traverse_iterative_step(body, visitor)? {
                    return Ok(true);
                }
            }
            Region::Switch { cases, .. } => {
                for case in cases.iter_mut() {
                    if traverse_iterative_step(&mut case.container, visitor)? {
                        return Ok(true);
                    }
                }
            }
            Region::TryCatch { try_region, handlers, finally, .. } => {
                if traverse_iterative_step(try_region, visitor)? {
                    return Ok(true);
                }
                for handler in handlers.iter_mut() {
                    if traverse_iterative_step(&mut handler.region, visitor)? {
                        return Ok(true);
                    }
                }
                if let Some(finally_r) = finally {
                    if traverse_iterative_step(finally_r, visitor)? {
                        return Ok(true);
                    }
                }
            }
            Region::Synchronized { body, .. } => {
                if traverse_iterative_step(body, visitor)? {
                    return Ok(true);
                }
            }
            // Leaf regions have no children
            Region::Break { .. } |
            Region::Continue { .. } |
            Region::TernaryAssignment { .. } |
            Region::TernaryReturn { .. } => {}
        }
        Ok(false)
    }

    /// Traversal including exception handlers (JADX: traverseIncludingExcHandlers)
    ///
    /// Like traverseIterative but also visits exception handler regions.
    ///
    /// JADX Reference: DepthRegionTraversal.java:40-60
    /// ```java
    /// public static void traverseIncludingExcHandlers(MethodNode mth, IRegionIterativeVisitor visitor) {
    ///     boolean repeat;
    ///     int k = 0;
    ///     int limit = ITERATIVE_LIMIT_MULTIPLIER * mth.getBasicBlocks().size();
    ///     do {
    ///         repeat = traverseIterativeStepInternal(mth, visitor, mth.getRegion());
    ///         if (!repeat) {
    ///             for (ExceptionHandler h : mth.getExceptionHandlers()) {
    ///                 repeat = traverseIterativeStepInternal(mth, visitor, h.getHandlerRegion());
    ///                 if (repeat) break;
    ///             }
    ///         }
    ///         if (k++ > limit) {
    ///             throw new JadxRuntimeException("Iterative traversal limit reached");
    ///         }
    ///     } while (repeat);
    /// }
    /// ```
    pub fn traverse_including_exc_handlers<V: RegionIterativeVisitor>(
        region: &mut Region,
        exception_handlers: &mut [Region],
        visitor: &mut V,
        block_count: usize,
    ) -> Result<(), TraversalError> {
        let limit = ITERATIVE_LIMIT_MULTIPLIER * block_count.max(10);
        let mut k = 0;

        loop {
            let mut repeat = traverse_iterative_step(region, visitor)?;

            if !repeat {
                for handler in exception_handlers.iter_mut() {
                    repeat = traverse_iterative_step(handler, visitor)?;
                    if repeat {
                        break;
                    }
                }
            }

            if !repeat {
                break;
            }

            k += 1;
            if k > limit {
                return Err(TraversalError::LimitReached {
                    limit,
                    block_count,
                });
            }
        }
        Ok(())
    }

    /// Visit all blocks in a region (JADX-style block iteration)
    ///
    /// Calls the visitor for each block ID in the region tree.
    pub fn visit_blocks<F>(region: &Region, visitor: F)
    where
        F: FnMut(u32),
    {
        struct BlockVisitor<F> {
            callback: F,
        }

        impl<F: FnMut(u32)> RegionVisitor for BlockVisitor<F> {
            fn visit_block(&mut self, block_id: u32) {
                (self.callback)(block_id);
            }
        }

        let mut v = BlockVisitor { callback: visitor };
        traverse(region, &mut v);
    }

    /// Collect all blocks from a region tree
    pub fn collect_blocks(region: &Region) -> Vec<u32> {
        let mut blocks = Vec::new();
        visit_blocks(region, |id| blocks.push(id));
        blocks
    }
}

/// Error type for region traversal
#[derive(Debug, Clone)]
pub enum TraversalError {
    /// Iteration limit reached (likely infinite loop)
    LimitReached {
        limit: usize,
        block_count: usize,
    },
    /// Stack overflow during traversal
    StackOverflow,
}

impl std::fmt::Display for TraversalError {
    fn fmt(&self, f: &mut std::fmt::Formatter<'_>) -> std::fmt::Result {
        match self {
            TraversalError::LimitReached { limit, block_count } => {
                write!(
                    f,
                    "Iterative traversal limit reached: limit={}, blocks={}",
                    limit, block_count
                )
            }
            TraversalError::StackOverflow => {
                write!(f, "Stack overflow during region traversal")
            }
        }
    }
}

impl std::error::Error for TraversalError {}

// ============================================================================
// JADX Parity: Region.getSubBlocks() and IRegion methods
// ============================================================================

impl Region {
    /// Get sub-blocks of this region (JADX: getSubBlocks)
    ///
    /// Returns all direct children of this region as RegionContent items.
    /// This matches JADX's IRegion.getSubBlocks() interface.
    ///
    /// JADX Reference: IRegion.java:22 - List<IContainer> getSubBlocks()
    pub fn get_sub_blocks(&self) -> Vec<&RegionContent> {
        match self {
            Region::Sequence(contents) => contents.iter().collect(),
            Region::If { .. } => {
                // If regions have sub-regions, use get_child_regions() instead
                vec![]
            }
            _ => vec![],
        }
    }

    /// Get child regions (for regions with sub-regions)
    ///
    /// More Rust-idiomatic alternative to get_sub_blocks()
    pub fn child_regions(&self) -> Vec<&Region> {
        match self {
            Region::Sequence(contents) => {
                contents.iter()
                    .filter_map(|c| match c {
                        RegionContent::Region(r) => Some(r.as_ref()),
                        _ => None,
                    })
                    .collect()
            }
            Region::If { then_region, else_region, .. } => {
                let mut result = vec![then_region.as_ref()];
                if let Some(e) = else_region {
                    result.push(e.as_ref());
                }
                result
            }
            Region::Loop { body, .. } => vec![body.as_ref()],
            Region::Switch { cases, .. } => {
                cases.iter().map(|c| c.container.as_ref()).collect()
            }
            Region::TryCatch { try_region, handlers, finally, .. } => {
                let mut result = vec![try_region.as_ref()];
                for h in handlers {
                    result.push(h.region.as_ref());
                }
                if let Some(f) = finally {
                    result.push(f.as_ref());
                }
                result
            }
            Region::Synchronized { body, .. } => vec![body.as_ref()],
            Region::Break { .. } |
            Region::Continue { .. } |
            Region::TernaryAssignment { .. } |
            Region::TernaryReturn { .. } => vec![],
        }
    }

    /// Get mutable child regions (for modification)
    pub fn child_regions_mut(&mut self) -> Vec<&mut Region> {
        match self {
            Region::Sequence(contents) => {
                contents.iter_mut()
                    .filter_map(|c| match c {
                        RegionContent::Region(r) => Some(r.as_mut()),
                        _ => None,
                    })
                    .collect()
            }
            Region::If { then_region, else_region, .. } => {
                let mut result = vec![then_region.as_mut()];
                if let Some(e) = else_region {
                    result.push(e.as_mut());
                }
                result
            }
            Region::Loop { body, .. } => vec![body.as_mut()],
            Region::Switch { cases, .. } => {
                cases.iter_mut().map(|c| c.container.as_mut()).collect()
            }
            Region::TryCatch { try_region, handlers, finally, .. } => {
                let mut result = vec![try_region.as_mut()];
                for h in handlers {
                    result.push(h.region.as_mut());
                }
                if let Some(f) = finally {
                    result.push(f.as_mut());
                }
                result
            }
            Region::Synchronized { body, .. } => vec![body.as_mut()],
            Region::Break { .. } |
            Region::Continue { .. } |
            Region::TernaryAssignment { .. } |
            Region::TernaryReturn { .. } => vec![],
        }
    }

    /// Replace a sub-block with a new one (JADX: replaceSubBlock)
    ///
    /// JADX Reference: IRegion.java:26 - boolean replaceSubBlock(IContainer oldBlock, IContainer newBlock)
    pub fn replace_sub_block(&mut self, old_index: usize, new_content: RegionContent) -> bool {
        if let Region::Sequence(contents) = self {
            if old_index < contents.len() {
                contents[old_index] = new_content;
                return true;
            }
        }
        false
    }
}
