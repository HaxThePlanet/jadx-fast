//! Live variable analysis
//!
//! Iterative dataflow analysis to determine which variables are live at each program point.
//! Used for SSA phi node placement.

use fixedbitset::FixedBitSet;

/// Result of live variable analysis
#[derive(Debug)]
pub struct LivenessInfo {
    /// Live-in set for each block (registers live at block entry)
    pub live_in: Vec<FixedBitSet>,
    /// Blocks where each register is assigned (def sites)
    pub assign_blocks: Vec<FixedBitSet>,
    /// Use set for each block (registers used before any def)
    pub uses: Vec<FixedBitSet>,
    /// Def set for each block (registers defined in block)
    pub defs: Vec<FixedBitSet>,
}

/// Live variable analysis for a method
pub struct LiveVarAnalysis {
    num_blocks: usize,
    num_regs: usize,
    uses: Vec<FixedBitSet>,
    defs: Vec<FixedBitSet>,
    live_in: Vec<FixedBitSet>,
    assign_blocks: Vec<FixedBitSet>,
}

impl LiveVarAnalysis {
    /// Create a new live variable analysis
    pub fn new(num_blocks: usize, num_regs: usize) -> Self {
        LiveVarAnalysis {
            num_blocks,
            num_regs,
            uses: vec![FixedBitSet::with_capacity(num_regs); num_blocks],
            defs: vec![FixedBitSet::with_capacity(num_regs); num_blocks],
            live_in: vec![FixedBitSet::with_capacity(num_regs); num_blocks],
            assign_blocks: vec![FixedBitSet::with_capacity(num_blocks); num_regs],
        }
    }

    /// Record a use of a register in a block
    /// Call this for each register read BEFORE checking if it's been defined
    #[inline]
    pub fn add_use(&mut self, block_id: usize, reg: u16) {
        let reg = reg as usize;
        if reg < self.num_regs && !self.defs[block_id].contains(reg) {
            self.uses[block_id].insert(reg);
        }
    }

    /// Record a definition of a register in a block
    #[inline]
    pub fn add_def(&mut self, block_id: usize, reg: u16) {
        let reg = reg as usize;
        if reg < self.num_regs {
            self.defs[block_id].insert(reg);
            self.assign_blocks[reg].insert(block_id);
        }
    }

    /// Run the dataflow analysis
    ///
    /// # Arguments
    /// * `successors` - For each block, list of successor block indices
    ///
    /// # Returns
    /// LivenessInfo with computed live sets
    pub fn run_analysis(mut self, successors: &[Vec<u32>]) -> LivenessInfo {
        self.process_live_info(successors);

        LivenessInfo {
            live_in: self.live_in,
            assign_blocks: self.assign_blocks,
            uses: self.uses,
            defs: self.defs,
        }
    }

    /// Iterative dataflow computation
    fn process_live_info(&mut self, successors: &[Vec<u32>]) {
        let iterations_limit = self.num_blocks * 10;
        let mut iteration = 0;

        // Temporary buffer to avoid allocation in hot loop
        let mut new_in = FixedBitSet::with_capacity(self.num_regs);

        loop {
            let mut changed = false;

            for block_id in 0..self.num_blocks {
                new_in.clear();

                // live_out = union of live_in of all successors
                for &succ in &successors[block_id] {
                    new_in.union_with(&self.live_in[succ as usize]);
                }

                // live_in = use ∪ (live_out - def)
                // Equivalent to: new_in = (new_in - defs) ∪ uses
                new_in.difference_with(&self.defs[block_id]);
                new_in.union_with(&self.uses[block_id]);

                if new_in != self.live_in[block_id] {
                    changed = true;
                    std::mem::swap(&mut self.live_in[block_id], &mut new_in);
                }
            }

            if !changed {
                break;
            }

            iteration += 1;
            if iteration > iterations_limit {
                panic!(
                    "Live variable analysis exceeded iteration limit ({}) for {} blocks",
                    iterations_limit, self.num_blocks
                );
            }
        }
    }
}

impl LivenessInfo {
    /// Check if a register is live at the entry of a block
    #[inline]
    pub fn is_live(&self, block_id: usize, reg: u16) -> bool {
        if block_id >= self.live_in.len() {
            return false;
        }
        self.live_in[block_id].contains(reg as usize)
    }

    /// Get the blocks where a register is assigned
    #[inline]
    pub fn get_assign_blocks(&self, reg: u16) -> &FixedBitSet {
        &self.assign_blocks[reg as usize]
    }

    /// Iterate over blocks where a register is assigned
    pub fn assign_blocks_iter(&self, reg: u16) -> impl Iterator<Item = usize> + '_ {
        self.assign_blocks[reg as usize].ones()
    }
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn test_simple_liveness() {
        // Block 0: def r0
        // Block 1: use r0, def r1
        // Block 2: use r1
        let successors = vec![
            vec![1],  // 0 -> 1
            vec![2],  // 1 -> 2
            vec![],   // 2 (exit)
        ];

        let mut analysis = LiveVarAnalysis::new(3, 2);

        // Block 0: def r0
        analysis.add_def(0, 0);

        // Block 1: use r0, def r1
        analysis.add_use(1, 0);
        analysis.add_def(1, 1);

        // Block 2: use r1
        analysis.add_use(2, 1);

        let info = analysis.run_analysis(&successors);

        // r0 should be live at entry of block 1
        assert!(info.is_live(1, 0));

        // r1 should be live at entry of block 2
        assert!(info.is_live(2, 1));

        // r0 should NOT be live at entry of block 2
        assert!(!info.is_live(2, 0));

        // Check assign blocks
        assert!(info.assign_blocks[0].contains(0)); // r0 assigned in block 0
        assert!(info.assign_blocks[1].contains(1)); // r1 assigned in block 1
    }

    #[test]
    fn test_loop_liveness() {
        // Block 0: def r0 = 0
        // Block 1: use r0, def r0 = r0 + 1 (loop body)
        // Block 2: use r0 (after loop)
        //
        // 0 -> 1 -> 2
        //      ^    |
        //      +----+ (back edge from 1 to 1 simulating loop)
        let successors = vec![
            vec![1],     // 0 -> 1
            vec![1, 2],  // 1 -> 1, 2
            vec![],      // 2 (exit)
        ];

        let mut analysis = LiveVarAnalysis::new(3, 1);

        // Block 0: def r0
        analysis.add_def(0, 0);

        // Block 1: use r0, then def r0
        analysis.add_use(1, 0);
        analysis.add_def(1, 0);

        // Block 2: use r0
        analysis.add_use(2, 0);

        let info = analysis.run_analysis(&successors);

        // r0 should be live at entry of block 1 (used before def)
        assert!(info.is_live(1, 0));

        // r0 should be live at entry of block 2
        assert!(info.is_live(2, 0));

        // r0 assigned in blocks 0 and 1
        assert!(info.assign_blocks[0].contains(0));
        assert!(info.assign_blocks[0].contains(1));
    }

    #[test]
    fn test_dead_variable() {
        // Block 0: def r0 (never used)
        // Block 1: (empty)
        let successors = vec![
            vec![1],
            vec![],
        ];

        let mut analysis = LiveVarAnalysis::new(2, 1);
        analysis.add_def(0, 0);

        let info = analysis.run_analysis(&successors);

        // r0 should NOT be live at entry of block 1 (never used)
        assert!(!info.is_live(1, 0));
    }
}
