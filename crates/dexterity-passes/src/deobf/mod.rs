//! Deobfuscation Passes
//!
//! This module contains passes that reverse common obfuscation techniques:
//! - Opaque predicate detection and removal
//! - Dead code elimination
//! - Control flow flattening (CFF) recovery
//! - Bogus code removal
//! - Pattern simplification

mod opaque_predicates;
mod dead_code;
mod cff_detector;
mod bogus_code;
mod pattern_simplify;

pub use opaque_predicates::{OpaquePredicate, OpaquePredicateDetector, PredicateType};
pub use dead_code::{DeadCodeEliminator, DeadCodeStats};
pub use cff_detector::{CffDetector, CffPattern, StateVariable};
pub use bogus_code::{BogusCodeRemover, BogusCodeStats};
pub use pattern_simplify::{PatternSimplifier, SimplificationStats};

use dexterity_ir::MethodData;

/// Configuration for deobfuscation passes
#[derive(Debug, Clone)]
pub struct DeobfConfig {
    /// Enable opaque predicate detection
    pub detect_opaque_predicates: bool,
    /// Enable dead code elimination
    pub eliminate_dead_code: bool,
    /// Enable CFF recovery
    pub recover_cff: bool,
    /// Enable bogus code removal
    pub remove_bogus_code: bool,
    /// Enable pattern simplification
    pub simplify_patterns: bool,
    /// Maximum iterations for fixed-point passes
    pub max_iterations: usize,
}

impl Default for DeobfConfig {
    fn default() -> Self {
        Self {
            detect_opaque_predicates: true,
            eliminate_dead_code: true,
            recover_cff: true,
            remove_bogus_code: true,
            simplify_patterns: true,
            max_iterations: 10,
        }
    }
}

/// Statistics from running deobfuscation passes
#[derive(Debug, Clone, Default)]
pub struct DeobfStats {
    /// Number of opaque predicates found
    pub opaque_predicates_found: usize,
    /// Number of opaque predicates simplified
    pub opaque_predicates_simplified: usize,
    /// Number of dead instructions removed
    pub dead_instructions_removed: usize,
    /// Number of unreachable blocks removed
    pub unreachable_blocks_removed: usize,
    /// Number of CFF patterns detected
    pub cff_patterns_detected: usize,
    /// Number of CFF patterns recovered
    pub cff_patterns_recovered: usize,
    /// Number of bogus instructions removed
    pub bogus_instructions_removed: usize,
    /// Number of patterns simplified
    pub patterns_simplified: usize,
}

impl DeobfStats {
    /// Merge stats from another run
    pub fn merge(&mut self, other: &DeobfStats) {
        self.opaque_predicates_found += other.opaque_predicates_found;
        self.opaque_predicates_simplified += other.opaque_predicates_simplified;
        self.dead_instructions_removed += other.dead_instructions_removed;
        self.unreachable_blocks_removed += other.unreachable_blocks_removed;
        self.cff_patterns_detected += other.cff_patterns_detected;
        self.cff_patterns_recovered += other.cff_patterns_recovered;
        self.bogus_instructions_removed += other.bogus_instructions_removed;
        self.patterns_simplified += other.patterns_simplified;
    }

    /// Check if any work was done
    pub fn has_changes(&self) -> bool {
        self.opaque_predicates_simplified > 0
            || self.dead_instructions_removed > 0
            || self.unreachable_blocks_removed > 0
            || self.cff_patterns_recovered > 0
            || self.bogus_instructions_removed > 0
            || self.patterns_simplified > 0
    }
}

/// Run all deobfuscation passes on a method
pub fn run_deobf_passes(method: &mut MethodData, config: &DeobfConfig) -> DeobfStats {
    let mut total_stats = DeobfStats::default();

    // Phase 1: CFF Recovery (restructures CFG)
    if config.recover_cff {
        let mut detector = CffDetector::new();
        if let Some(pattern) = detector.detect(method) {
            total_stats.cff_patterns_detected += 1;
            // CFF recovery would modify CFG here
            // For now, just detect
            let _ = pattern;
        }
    }

    // Phase 2: Opaque Predicates + Dead Code (iterate to fixed point)
    for _ in 0..config.max_iterations {
        let mut iteration_stats = DeobfStats::default();

        if config.detect_opaque_predicates {
            let mut detector = OpaquePredicateDetector::new();
            let predicates = detector.detect(method);
            iteration_stats.opaque_predicates_found += predicates.len();

            // Simplify detected predicates
            for predicate in &predicates {
                if detector.simplify(method, predicate) {
                    iteration_stats.opaque_predicates_simplified += 1;
                }
            }
        }

        if config.eliminate_dead_code {
            let mut eliminator = DeadCodeEliminator::new();
            let stats = eliminator.eliminate(method);
            iteration_stats.dead_instructions_removed += stats.instructions_removed;
            iteration_stats.unreachable_blocks_removed += stats.blocks_removed;
        }

        total_stats.merge(&iteration_stats);

        // Stop if no changes
        if !iteration_stats.has_changes() {
            break;
        }
    }

    // Phase 3: Bogus Code Removal
    if config.remove_bogus_code {
        let mut remover = BogusCodeRemover::new();
        let stats = remover.remove(method);
        total_stats.bogus_instructions_removed += stats.instructions_removed;
    }

    // Phase 4: Pattern Simplification
    if config.simplify_patterns {
        let mut simplifier = PatternSimplifier::new();
        let stats = simplifier.simplify(method);
        total_stats.patterns_simplified += stats.patterns_simplified;
    }

    total_stats
}
