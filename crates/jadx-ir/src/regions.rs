//! Region types for high-level control flow

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

/// Condition expression (placeholder)
#[derive(Debug, Clone, Default)]
pub struct Condition {
    // Will be expanded with proper condition representation
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
    pub exception_type: Option<String>,
    pub region: Box<Region>,
}
