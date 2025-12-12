//! Region types for high-level control flow

use crate::instructions::IfCondition;

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

    /// Loop region
    Loop {
        kind: LoopKind,
        condition: Option<Condition>,
        body: Box<Region>,
    },

    /// Switch region
    Switch {
        /// Block containing the switch instruction (for extracting switch value)
        header_block: u32,
        cases: Vec<SwitchCase>,
        default: Option<Box<Region>>,
    },

    /// Try-catch region
    TryCatch {
        try_region: Box<Region>,
        handlers: Vec<CatchHandler>,
        finally: Option<Box<Region>>,
    },

    /// Synchronized block
    Synchronized {
        /// Block containing the MonitorEnter instruction (for extracting lock object)
        enter_block: u32,
        body: Box<Region>,
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

/// Switch case
#[derive(Debug, Clone)]
pub struct SwitchCase {
    pub keys: Vec<i32>,
    pub region: Box<Region>,
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
