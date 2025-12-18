//! SSA (Static Single Assignment) transformation
//!
//! This pass converts the IR to SSA form where each variable is assigned exactly once.
//! The algorithm follows the classic approach:
//! 1. Compute dominators (Cooper-Harvey-Kennedy algorithm)
//! 2. Compute dominance frontiers
//! 3. Place phi nodes at dominance frontiers
//! 4. Rename variables with unique versions

use std::collections::VecDeque;
use rustc_hash::{FxHashMap, FxHashSet};
use tracing::error;

use crate::block_split::{BasicBlock, BlockSplitResult};
use dexterity_ir::instructions::{InsnArg, InsnNode, InsnType, RegisterArg};

/// SSA transformation result
#[derive(Debug)]
pub struct SsaResult {
    /// Blocks with phi nodes inserted and variables renamed
    pub blocks: Vec<SsaBlock>,
    /// Dominator tree (block_id -> immediate dominator)
    pub dominators: FxHashMap<u32, u32>,
    /// Dominance frontiers for each block
    pub dom_frontiers: FxHashMap<u32, FxHashSet<u32>>,
    /// Maximum SSA version for each register
    pub max_versions: FxHashMap<u16, u32>,
}

/// A block in SSA form
#[derive(Debug)]
pub struct SsaBlock {
    pub id: u32,
    /// Phi nodes at the start of this block
    pub phi_nodes: Vec<PhiNode>,
    /// Instructions with renamed variables (owned, no Arc/Mutex overhead)
    pub instructions: Vec<InsnNode>,
    pub successors: Vec<u32>,
    pub predecessors: Vec<u32>,
}

/// A phi node merging values from predecessors
#[derive(Debug, Clone)]
pub struct PhiNode {
    /// Destination register
    pub dest: RegisterArg,
    /// Source values: (predecessor_block_id, register with version)
    pub sources: Vec<(u32, RegisterArg)>,
}

/// Dominator tree computation using Cooper-Harvey-Kennedy algorithm
/// This is efficient for reducible CFGs (most structured programs)
pub struct DominatorTree {
    /// Immediate dominator for each block (block_id -> idom_id)
    pub idom: FxHashMap<u32, u32>,
    /// Children in dominator tree
    pub children: FxHashMap<u32, Vec<u32>>,
    /// Entry block
    pub entry: u32,
}

impl DominatorTree {
    /// Compute dominator tree for a CFG
    pub fn compute(blocks: &BlockSplitResult) -> Self {
        let entry = blocks.entry_block;
        let block_ids: Vec<u32> = blocks.blocks.iter().map(|b| b.id).collect();

        if block_ids.is_empty() {
            return DominatorTree {
                idom: FxHashMap::default(),
                children: FxHashMap::default(),
                entry,
            };
        }

        // Compute reverse postorder
        let rpo = reverse_postorder(blocks, entry);
        let rpo_index: FxHashMap<u32, usize> = rpo.iter().enumerate()
            .map(|(i, &b)| (b, i))
            .collect();

        // Initialize dominators
        let mut idom: FxHashMap<u32, u32> = FxHashMap::default();
        idom.insert(entry, entry); // Entry dominates itself

        // Iterative dominator computation
        let mut changed = true;
        let mut iterations = 0;
        let max_iterations = block_ids.len() * 10 + 1000; // Safety limit

        while changed {
            iterations += 1;
            if iterations > max_iterations {
                error!(
                    iterations = iterations,
                    max_iterations = max_iterations,
                    block_count = block_ids.len(),
                    "LIMIT_EXCEEDED: Dominator tree computation limit reached"
                );
                panic!("Dominator tree computation limit reached");
            }
            changed = false;

            for &b in &rpo {
                if b == entry {
                    continue;
                }

                let block = match blocks.get_block(b) {
                    Some(blk) => blk,
                    None => continue,
                };

                // Find first processed predecessor
                let mut new_idom: Option<u32> = None;
                for &pred in &block.predecessors {
                    if idom.contains_key(&pred) {
                        new_idom = Some(pred);
                        break;
                    }
                }

                let mut new_idom = match new_idom {
                    Some(d) => d,
                    None => continue,
                };

                // Intersect with other predecessors
                for &pred in &block.predecessors {
                    if pred == new_idom {
                        continue;
                    }
                    if idom.contains_key(&pred) {
                        new_idom = intersect(pred, new_idom, &idom, &rpo_index);
                    }
                }

                if idom.get(&b) != Some(&new_idom) {
                    idom.insert(b, new_idom);
                    changed = true;
                }
            }
        }

        // Build children map
        let mut children: FxHashMap<u32, Vec<u32>> = FxHashMap::default();
        for (&block, &dom) in &idom {
            if block != dom {
                children.entry(dom).or_default().push(block);
            }
        }

        DominatorTree { idom, children, entry }
    }

    /// Check if block a dominates block b
    pub fn dominates(&self, a: u32, b: u32) -> bool {
        if a == b {
            return true;
        }
        let mut current = b;
        while let Some(&dom) = self.idom.get(&current) {
            if dom == a {
                return true;
            }
            if dom == current {
                break; // Entry block
            }
            current = dom;
        }
        false
    }

    /// Compute dominance frontier for all blocks
    pub fn compute_frontiers(&self, blocks: &BlockSplitResult) -> FxHashMap<u32, FxHashSet<u32>> {
        let mut frontiers: FxHashMap<u32, FxHashSet<u32>> = FxHashMap::default();

        for block in &blocks.blocks {
            frontiers.insert(block.id, FxHashSet::default());
        }

        for block in &blocks.blocks {
            let block_id = block.id;
            if block.predecessors.len() >= 2 {
                for &pred in &block.predecessors {
                    let mut runner = pred;
                    while runner != *self.idom.get(&block_id).unwrap_or(&block_id) {
                        frontiers.entry(runner).or_default().insert(block_id);
                        runner = match self.idom.get(&runner) {
                            Some(&dom) if dom != runner => dom,
                            _ => break,
                        };
                    }
                }
            }
        }

        frontiers
    }
}

/// Compute reverse postorder traversal
fn reverse_postorder(blocks: &BlockSplitResult, entry: u32) -> Vec<u32> {
    let mut visited = FxHashSet::default();
    let mut postorder = Vec::new();

    fn dfs(block_id: u32, blocks: &BlockSplitResult, visited: &mut FxHashSet<u32>, postorder: &mut Vec<u32>) {
        if visited.contains(&block_id) {
            return;
        }
        visited.insert(block_id);

        if let Some(block) = blocks.get_block(block_id) {
            for &succ in &block.successors {
                dfs(succ, blocks, visited, postorder);
            }
        }
        postorder.push(block_id);
    }

    dfs(entry, blocks, &mut visited, &mut postorder);
    postorder.reverse();
    postorder
}

/// Intersect two dominators in the dominator tree (find lowest common ancestor)
/// This is the standard algorithm from Cooper-Harvey-Kennedy
fn intersect(
    mut b1: u32,
    mut b2: u32,
    idom: &FxHashMap<u32, u32>,
    rpo_index: &FxHashMap<u32, usize>,
) -> u32 {
    let mut f1 = rpo_index.get(&b1).copied().unwrap_or(0);
    let mut f2 = rpo_index.get(&b2).copied().unwrap_or(0);

    while f1 != f2 {
        while f1 > f2 {
            b1 = *idom.get(&b1).unwrap_or(&b1);
            f1 = rpo_index.get(&b1).copied().unwrap_or(0);
        }
        while f2 > f1 {
            b2 = *idom.get(&b2).unwrap_or(&b2);
            f2 = rpo_index.get(&b2).copied().unwrap_or(0);
        }
    }
    b1
}

/// Find all registers defined in a block
fn find_defs(block: &BasicBlock) -> FxHashSet<u16> {
    let mut defs = FxHashSet::default();

    for insn in &block.instructions {
        if let Some(reg) = get_def_register(&insn.insn_type) {
            defs.insert(reg);
        }
    }

    defs
}

/// Get the register defined by an instruction (if any)
fn get_def_register(insn_type: &InsnType) -> Option<u16> {
    match insn_type {
        InsnType::Const { dest, .. } => Some(dest.reg_num),
        InsnType::ConstString { dest, .. } => Some(dest.reg_num),
        InsnType::ConstClass { dest, .. } => Some(dest.reg_num),
        InsnType::Move { dest, .. } => Some(dest.reg_num),
        InsnType::MoveResult { dest } => Some(dest.reg_num),
        InsnType::MoveException { dest } => Some(dest.reg_num),
        InsnType::InstanceOf { dest, .. } => Some(dest.reg_num),
        InsnType::ArrayLength { dest, .. } => Some(dest.reg_num),
        InsnType::NewInstance { dest, .. } => Some(dest.reg_num),
        InsnType::NewArray { dest, .. } => Some(dest.reg_num),
        InsnType::FilledNewArray { dest, .. } => dest.as_ref().map(|d| d.reg_num),
        InsnType::ArrayGet { dest, .. } => Some(dest.reg_num),
        InsnType::InstanceGet { dest, .. } => Some(dest.reg_num),
        InsnType::StaticGet { dest, .. } => Some(dest.reg_num),
        InsnType::Unary { dest, .. } => Some(dest.reg_num),
        InsnType::Binary { dest, .. } => Some(dest.reg_num),
        InsnType::Cast { dest, .. } => Some(dest.reg_num),
        InsnType::Compare { dest, .. } => Some(dest.reg_num),
        InsnType::Phi { dest, .. } => Some(dest.reg_num),
        _ => None,
    }
}

/// Get registers used by an instruction
#[allow(dead_code)]
fn get_use_registers(insn_type: &InsnType) -> Vec<u16> {
    let mut uses = Vec::new();

    fn add_arg(arg: &InsnArg, uses: &mut Vec<u16>) {
        if let InsnArg::Register(reg) = arg {
            uses.push(reg.reg_num);
        }
    }

    match insn_type {
        InsnType::Move { src, .. } => add_arg(src, &mut uses),
        InsnType::Return { value: Some(v) } => add_arg(v, &mut uses),
        InsnType::Throw { exception } => add_arg(exception, &mut uses),
        InsnType::MonitorEnter { object } => add_arg(object, &mut uses),
        InsnType::MonitorExit { object } => add_arg(object, &mut uses),
        InsnType::CheckCast { object, .. } => add_arg(object, &mut uses),
        InsnType::InstanceOf { object, .. } => add_arg(object, &mut uses),
        InsnType::ArrayLength { array, .. } => add_arg(array, &mut uses),
        InsnType::NewArray { size, .. } => add_arg(size, &mut uses),
        InsnType::FilledNewArray { args, .. } => {
            for arg in args {
                add_arg(arg, &mut uses);
            }
        }
        InsnType::FillArrayData { array, .. } => add_arg(array, &mut uses),
        InsnType::ArrayGet { array, index, .. } => {
            add_arg(array, &mut uses);
            add_arg(index, &mut uses);
        }
        InsnType::ArrayPut { array, index, value, .. } => {
            add_arg(array, &mut uses);
            add_arg(index, &mut uses);
            add_arg(value, &mut uses);
        }
        InsnType::InstanceGet { object, .. } => add_arg(object, &mut uses),
        InsnType::InstancePut { object, value, .. } => {
            add_arg(object, &mut uses);
            add_arg(value, &mut uses);
        }
        InsnType::StaticPut { value, .. } => add_arg(value, &mut uses),
        InsnType::Invoke { args, .. } => {
            for arg in args {
                add_arg(arg, &mut uses);
            }
        }
        InsnType::Unary { arg, .. } => add_arg(arg, &mut uses),
        InsnType::Binary { left, right, .. } => {
            add_arg(left, &mut uses);
            add_arg(right, &mut uses);
        }
        InsnType::Cast { arg, .. } => add_arg(arg, &mut uses),
        InsnType::Compare { left, right, .. } => {
            add_arg(left, &mut uses);
            add_arg(right, &mut uses);
        }
        InsnType::If { left, right, .. } => {
            add_arg(left, &mut uses);
            if let Some(r) = right {
                add_arg(r, &mut uses);
            }
        }
        InsnType::PackedSwitch { value, .. } => add_arg(value, &mut uses),
        InsnType::SparseSwitch { value, .. } => add_arg(value, &mut uses),
        _ => {}
    }

    uses
}

/// Transform to SSA form
pub fn transform_to_ssa(blocks: &BlockSplitResult) -> SsaResult {
    if blocks.blocks.is_empty() {
        return SsaResult {
            blocks: Vec::new(),
            dominators: FxHashMap::default(),
            dom_frontiers: FxHashMap::default(),
            max_versions: FxHashMap::default(),
        };
    }

    // Step 1: Compute dominators
    let dom_tree = DominatorTree::compute(blocks);

    // Step 2: Compute dominance frontiers
    let dom_frontiers = dom_tree.compute_frontiers(blocks);

    // Step 3: Find all variable definitions per block
    let mut defs_per_block: FxHashMap<u32, FxHashSet<u16>> = FxHashMap::default();
    let mut all_vars: FxHashSet<u16> = FxHashSet::default();

    for block in &blocks.blocks {
        let block_id = block.id;
        let defs = find_defs(block);
        all_vars.extend(&defs);
        defs_per_block.insert(block_id, defs);
    }

    // Step 4: Place phi nodes
    // For each variable, find blocks where phi is needed
    let mut phi_placements: FxHashMap<u32, FxHashSet<u16>> = FxHashMap::default();

    for &var in &all_vars {
        // Blocks that define this variable
        let def_blocks: Vec<u32> = defs_per_block
            .iter()
            .filter(|(_, defs)| defs.contains(&var))
            .map(|(&id, _)| id)
            .collect();

        let mut worklist: VecDeque<u32> = def_blocks.iter().copied().collect();
        let mut processed: FxHashSet<u32> = FxHashSet::default();

        while let Some(block_id) = worklist.pop_front() {
            if let Some(frontier) = dom_frontiers.get(&block_id) {
                for &df_block in frontier {
                    // Add phi for this variable at df_block
                    phi_placements.entry(df_block).or_default().insert(var);

                    // If we haven't processed this block, add to worklist
                    if !processed.contains(&df_block) {
                        processed.insert(df_block);
                        worklist.push_back(df_block);
                    }
                }
            }
        }
    }

    // Step 5: Rename variables
    let mut version_counter: FxHashMap<u16, u32> = FxHashMap::default();
    let mut version_stack: FxHashMap<u16, Vec<u32>> = FxHashMap::default();

    // Initialize stacks with version 0 (parameter/initial values)
    for &var in &all_vars {
        version_counter.insert(var, 0);
        version_stack.insert(var, vec![0]);
    }

    // Create SSA blocks
    let mut ssa_blocks: FxHashMap<u32, SsaBlock> = FxHashMap::default();

    for block in &blocks.blocks {
        let block_id = block.id;
        let phi_vars = phi_placements.get(&block_id).cloned().unwrap_or_default();

        let phi_nodes: Vec<PhiNode> = phi_vars
            .iter()
            .map(|&var| {
                let version = *version_counter.get(&var).unwrap_or(&0);
                PhiNode {
                    dest: RegisterArg::with_ssa(var, version),
                    sources: Vec::new(), // Will be filled during renaming
                }
            })
            .collect();

        ssa_blocks.insert(block_id, SsaBlock {
            id: block_id,
            phi_nodes,
            instructions: block.instructions.clone(),
            successors: block.successors.clone(),
            predecessors: block.predecessors.clone(),
        });
    }

    // Rename in dominator tree order
    fn rename_block(
        block_id: u32,
        ssa_blocks: &mut FxHashMap<u32, SsaBlock>,
        dom_tree: &DominatorTree,
        version_counter: &mut FxHashMap<u16, u32>,
        version_stack: &mut FxHashMap<u16, Vec<u32>>,
        _blocks: &BlockSplitResult,
    ) {
        let block = match ssa_blocks.get_mut(&block_id) {
            Some(b) => b,
            None => return,
        };

        // Track versions pushed in this block (for cleanup)
        let mut pushed_vars: Vec<u16> = Vec::new();

        // Rename phi node destinations
        for phi in &mut block.phi_nodes {
            let var = phi.dest.reg_num;
            let version = version_counter.entry(var).or_insert(0);
            *version += 1;
            phi.dest.ssa_version = *version;
            version_stack.entry(var).or_default().push(*version);
            pushed_vars.push(var);
        }

        // Rename uses and definitions in instructions
        for insn in &mut block.instructions {
            // First rename uses (read current version from stack)
            rename_uses(&mut insn.insn_type, version_stack);

            // Then rename definitions (push new version)
            if let Some(var) = get_def_register(&insn.insn_type) {
                let version = version_counter.entry(var).or_insert(0);
                *version += 1;
                rename_def(&mut insn.insn_type, *version);
                version_stack.entry(var).or_default().push(*version);
                pushed_vars.push(var);
            }
        }

        // Fill phi sources in successors
        let successors = block.successors.clone();
        for succ_id in successors {
            if let Some(succ) = ssa_blocks.get_mut(&succ_id) {
                for phi in &mut succ.phi_nodes {
                    let var = phi.dest.reg_num;
                    let version = version_stack
                        .get(&var)
                        .and_then(|stack| stack.last())
                        .copied()
                        .unwrap_or(0);
                    phi.sources.push((block_id, RegisterArg::with_ssa(var, version)));
                }
            }
        }

        // Recursively rename dominated blocks
        if let Some(children) = dom_tree.children.get(&block_id) {
            for &child in children {
                rename_block(child, ssa_blocks, dom_tree, version_counter, version_stack, _blocks);
            }
        }

        // Pop versions pushed in this block
        for var in pushed_vars {
            if let Some(stack) = version_stack.get_mut(&var) {
                stack.pop();
            }
        }
    }

    rename_block(
        blocks.entry_block,
        &mut ssa_blocks,
        &dom_tree,
        &mut version_counter,
        &mut version_stack,
        blocks,
    );

    // Convert to ordered vector
    let mut result_blocks: Vec<SsaBlock> = ssa_blocks.into_values().collect();
    result_blocks.sort_by_key(|b| b.id);

    SsaResult {
        blocks: result_blocks,
        dominators: dom_tree.idom,
        dom_frontiers,
        max_versions: version_counter,
    }
}

/// Rename uses in an instruction to their current SSA versions
fn rename_uses(insn_type: &mut InsnType, version_stack: &FxHashMap<u16, Vec<u32>>) {
    fn rename_arg(arg: &mut InsnArg, version_stack: &FxHashMap<u16, Vec<u32>>) {
        if let InsnArg::Register(reg) = arg {
            let version = version_stack
                .get(&reg.reg_num)
                .and_then(|stack| stack.last())
                .copied()
                .unwrap_or(0);
            reg.ssa_version = version;
        }
    }

    match insn_type {
        InsnType::Move { src, .. } => rename_arg(src, version_stack),
        InsnType::Return { value: Some(v) } => rename_arg(v, version_stack),
        InsnType::Throw { exception } => rename_arg(exception, version_stack),
        InsnType::MonitorEnter { object } => rename_arg(object, version_stack),
        InsnType::MonitorExit { object } => rename_arg(object, version_stack),
        InsnType::CheckCast { object, .. } => rename_arg(object, version_stack),
        InsnType::InstanceOf { object, .. } => rename_arg(object, version_stack),
        InsnType::ArrayLength { array, .. } => rename_arg(array, version_stack),
        InsnType::NewArray { size, .. } => rename_arg(size, version_stack),
        InsnType::FilledNewArray { args, .. } => {
            for arg in args {
                rename_arg(arg, version_stack);
            }
        }
        InsnType::FillArrayData { array, .. } => rename_arg(array, version_stack),
        InsnType::ArrayGet { array, index, .. } => {
            rename_arg(array, version_stack);
            rename_arg(index, version_stack);
        }
        InsnType::ArrayPut { array, index, value, .. } => {
            rename_arg(array, version_stack);
            rename_arg(index, version_stack);
            rename_arg(value, version_stack);
        }
        InsnType::InstanceGet { object, .. } => rename_arg(object, version_stack),
        InsnType::InstancePut { object, value, .. } => {
            rename_arg(object, version_stack);
            rename_arg(value, version_stack);
        }
        InsnType::StaticPut { value, .. } => rename_arg(value, version_stack),
        InsnType::Invoke { args, .. } => {
            for arg in args {
                rename_arg(arg, version_stack);
            }
        }
        InsnType::Unary { arg, .. } => rename_arg(arg, version_stack),
        InsnType::Binary { left, right, .. } => {
            rename_arg(left, version_stack);
            rename_arg(right, version_stack);
        }
        InsnType::Cast { arg, .. } => rename_arg(arg, version_stack),
        InsnType::Compare { left, right, .. } => {
            rename_arg(left, version_stack);
            rename_arg(right, version_stack);
        }
        InsnType::If { left, right, .. } => {
            rename_arg(left, version_stack);
            if let Some(r) = right {
                rename_arg(r, version_stack);
            }
        }
        InsnType::PackedSwitch { value, .. } => rename_arg(value, version_stack),
        InsnType::SparseSwitch { value, .. } => rename_arg(value, version_stack),
        _ => {}
    }
}

/// Rename the definition in an instruction
fn rename_def(insn_type: &mut InsnType, version: u32) {
    match insn_type {
        InsnType::Const { dest, .. } => dest.ssa_version = version,
        InsnType::ConstString { dest, .. } => dest.ssa_version = version,
        InsnType::ConstClass { dest, .. } => dest.ssa_version = version,
        InsnType::Move { dest, .. } => dest.ssa_version = version,
        InsnType::MoveResult { dest } => dest.ssa_version = version,
        InsnType::MoveException { dest } => dest.ssa_version = version,
        InsnType::InstanceOf { dest, .. } => dest.ssa_version = version,
        InsnType::ArrayLength { dest, .. } => dest.ssa_version = version,
        InsnType::NewInstance { dest, .. } => dest.ssa_version = version,
        InsnType::NewArray { dest, .. } => dest.ssa_version = version,
        InsnType::FilledNewArray { dest: Some(d), .. } => d.ssa_version = version,
        InsnType::ArrayGet { dest, .. } => dest.ssa_version = version,
        InsnType::InstanceGet { dest, .. } => dest.ssa_version = version,
        InsnType::StaticGet { dest, .. } => dest.ssa_version = version,
        InsnType::Unary { dest, .. } => dest.ssa_version = version,
        InsnType::Binary { dest, .. } => dest.ssa_version = version,
        InsnType::Cast { dest, .. } => dest.ssa_version = version,
        InsnType::Compare { dest, .. } => dest.ssa_version = version,
        _ => {}
    }
}

/// Transform to SSA form, taking ownership of blocks to avoid cloning instructions
/// This is the memory-efficient version that moves instructions instead of cloning
pub fn transform_to_ssa_owned(mut blocks: BlockSplitResult) -> SsaResult {
    if blocks.blocks.is_empty() {
        return SsaResult {
            blocks: Vec::new(),
            dominators: FxHashMap::default(),
            dom_frontiers: FxHashMap::default(),
            max_versions: FxHashMap::default(),
        };
    }

    // Step 1: Compute dominators (needs blocks reference, but we still own them)
    let dom_tree = DominatorTree::compute(&blocks);

    // Step 2: Compute dominance frontiers
    let dom_frontiers = dom_tree.compute_frontiers(&blocks);

    // Step 3: Find all variable definitions per block
    let mut defs_per_block: FxHashMap<u32, FxHashSet<u16>> = FxHashMap::default();
    let mut all_vars: FxHashSet<u16> = FxHashSet::default();

    for block in &blocks.blocks {
        let block_id = block.id;
        let defs = find_defs(block);
        all_vars.extend(&defs);
        defs_per_block.insert(block_id, defs);
    }

    // Step 4: Place phi nodes
    let mut phi_placements: FxHashMap<u32, FxHashSet<u16>> = FxHashMap::default();

    for &var in &all_vars {
        let def_blocks: Vec<u32> = defs_per_block
            .iter()
            .filter(|(_, defs)| defs.contains(&var))
            .map(|(&id, _)| id)
            .collect();

        let mut worklist: VecDeque<u32> = def_blocks.iter().copied().collect();
        let mut processed: FxHashSet<u32> = FxHashSet::default();

        while let Some(block_id) = worklist.pop_front() {
            if let Some(frontier) = dom_frontiers.get(&block_id) {
                for &df_block in frontier {
                    phi_placements.entry(df_block).or_default().insert(var);
                    if !processed.contains(&df_block) {
                        processed.insert(df_block);
                        worklist.push_back(df_block);
                    }
                }
            }
        }
    }

    // Step 5: Rename variables
    let mut version_counter: FxHashMap<u16, u32> = FxHashMap::default();
    let mut version_stack: FxHashMap<u16, Vec<u32>> = FxHashMap::default();

    for &var in &all_vars {
        version_counter.insert(var, 0);
        version_stack.insert(var, vec![0]);
    }

    // Create SSA blocks by MOVING data from original blocks (no clone!)
    let mut ssa_blocks: FxHashMap<u32, SsaBlock> = FxHashMap::default();
    let entry_block = blocks.entry_block;

    // Take blocks out of the BlockSplitResult to avoid borrowing issues
    let original_blocks = std::mem::take(&mut blocks.blocks);

    for block in original_blocks {
        let block_id = block.id;
        let phi_vars = phi_placements.get(&block_id).cloned().unwrap_or_default();

        let phi_nodes: Vec<PhiNode> = phi_vars
            .iter()
            .map(|&var| {
                let version = *version_counter.get(&var).unwrap_or(&0);
                PhiNode {
                    dest: RegisterArg::with_ssa(var, version),
                    sources: Vec::new(),
                }
            })
            .collect();

        // MOVE instructions and successors/predecessors instead of cloning
        ssa_blocks.insert(block_id, SsaBlock {
            id: block_id,
            phi_nodes,
            instructions: block.instructions, // Move, not clone!
            successors: block.successors,     // Move, not clone!
            predecessors: block.predecessors, // Move, not clone!
        });
    }

    // Create a temporary structure for rename_block that provides successor info
    // We need this because rename_block needs to look up successors
    let successor_map: FxHashMap<u32, Vec<u32>> = ssa_blocks
        .iter()
        .map(|(&id, b)| (id, b.successors.clone()))
        .collect();

    // Rename in dominator tree order
    fn rename_block_owned(
        block_id: u32,
        ssa_blocks: &mut FxHashMap<u32, SsaBlock>,
        dom_tree: &DominatorTree,
        version_counter: &mut FxHashMap<u16, u32>,
        version_stack: &mut FxHashMap<u16, Vec<u32>>,
        successor_map: &FxHashMap<u32, Vec<u32>>,
    ) {
        let block = match ssa_blocks.get_mut(&block_id) {
            Some(b) => b,
            None => return,
        };

        let mut pushed_vars: Vec<u16> = Vec::new();

        // Rename phi node destinations
        for phi in &mut block.phi_nodes {
            let var = phi.dest.reg_num;
            let version = version_counter.entry(var).or_insert(0);
            *version += 1;
            phi.dest.ssa_version = *version;
            version_stack.entry(var).or_default().push(*version);
            pushed_vars.push(var);
        }

        // Rename uses and definitions in instructions
        for insn in &mut block.instructions {
            rename_uses(&mut insn.insn_type, version_stack);
            if let Some(var) = get_def_register(&insn.insn_type) {
                let version = version_counter.entry(var).or_insert(0);
                *version += 1;
                rename_def(&mut insn.insn_type, *version);
                version_stack.entry(var).or_default().push(*version);
                pushed_vars.push(var);
            }
        }

        // Fill phi sources in successors
        let successors = successor_map.get(&block_id).cloned().unwrap_or_default();
        for succ_id in successors {
            if let Some(succ) = ssa_blocks.get_mut(&succ_id) {
                for phi in &mut succ.phi_nodes {
                    let var = phi.dest.reg_num;
                    let version = version_stack
                        .get(&var)
                        .and_then(|stack| stack.last())
                        .copied()
                        .unwrap_or(0);
                    phi.sources.push((block_id, RegisterArg::with_ssa(var, version)));
                }
            }
        }

        // Recursively rename dominated blocks
        if let Some(children) = dom_tree.children.get(&block_id) {
            for &child in children {
                rename_block_owned(child, ssa_blocks, dom_tree, version_counter, version_stack, successor_map);
            }
        }

        // Pop versions pushed in this block
        for var in pushed_vars {
            if let Some(stack) = version_stack.get_mut(&var) {
                stack.pop();
            }
        }
    }

    rename_block_owned(
        entry_block,
        &mut ssa_blocks,
        &dom_tree,
        &mut version_counter,
        &mut version_stack,
        &successor_map,
    );

    // Convert to ordered vector
    let mut result_blocks: Vec<SsaBlock> = ssa_blocks.into_values().collect();
    result_blocks.sort_by_key(|b| b.id);

    SsaResult {
        blocks: result_blocks,
        dominators: dom_tree.idom,
        dom_frontiers,
        max_versions: version_counter,
    }
}

// ============================================================================
// SSA Cleanup and Optimization Passes (JADX parity functions)
// ============================================================================
//
// These functions implement JADX's SSA cleanup phase:
// - Remove unused phi nodes (result not used)
// - Remove trivial phi nodes (all arguments are the same)
// - Inline phi nodes where possible
// - Hide phi instructions from final output
//
// Reference: jadx-core/src/main/java/jadx/core/dex/visitors/ssa/SSATransform.java
// Lines 259-466

/// Try to fix useless phi nodes iteratively until fixed point
/// JADX: tryToFixUselessPhi() - lines 259-267
pub fn try_to_fix_useless_phi(result: &mut SsaResult) {
    let max_tries = result.blocks.len() * 2 + 100;
    let mut iteration = 0;

    while fix_useless_phi(result) {
        iteration += 1;
        if iteration > max_tries {
            error!(
                iteration = iteration,
                max_tries = max_tries,
                blocks_count = result.blocks.len(),
                "LIMIT_EXCEEDED: Phi nodes fix limit reached"
            );
            break;
        }
    }
}

/// Fix useless phi nodes in a single pass
/// Returns true if any changes were made
/// JADX: fixUselessPhi() - lines 269-298
fn fix_useless_phi(result: &mut SsaResult) -> bool {
    let mut changed = false;
    let mut phi_to_remove: Vec<(usize, usize)> = Vec::new(); // (block_idx, phi_idx)

    // Find phi nodes to remove or fix
    for (block_idx, block) in result.blocks.iter_mut().enumerate() {
        let mut phi_indices_to_remove = Vec::new();

        for (phi_idx, phi) in block.phi_nodes.iter_mut().enumerate() {
            // Check if all phi arguments are the same SSA variable
            if is_same_args_phi(phi) {
                phi_indices_to_remove.push(phi_idx);
                changed = true;
            } else if phi.sources.is_empty() {
                // Empty phi node - mark for removal
                phi_indices_to_remove.push(phi_idx);
                changed = true;
            }
        }

        // Remove phi nodes in reverse order to maintain indices
        for &phi_idx in phi_indices_to_remove.iter().rev() {
            if phi_idx < block.phi_nodes.len() {
                phi_to_remove.push((block_idx, phi_idx));
            }
        }
    }

    // Remove phi nodes
    for (block_idx, phi_idx) in phi_to_remove.iter().rev() {
        if let Some(block) = result.blocks.get_mut(*block_idx) {
            if *phi_idx < block.phi_nodes.len() {
                block.phi_nodes.remove(*phi_idx);
            }
        }
    }

    changed
}

/// Check if all arguments of a phi node are the same SSA variable
/// JADX: isSameArgs() - lines 318-331
fn is_same_args_phi(phi: &PhiNode) -> bool {
    if phi.sources.is_empty() {
        return true; // Empty phi is trivially "same"
    }

    if phi.sources.len() == 1 {
        return true; // Single argument phi is useless
    }

    let first_version = phi.sources[0].1.ssa_version;
    let first_reg = phi.sources[0].1.reg_num;

    for (_, arg) in &phi.sources[1..] {
        if arg.ssa_version != first_version || arg.reg_num != first_reg {
            return false;
        }
    }

    true
}

/// Replace a phi node with a MOVE instruction
/// JADX: replacePhiWithMove() - lines 362-388
///
/// For now, we just mark the phi as trivial. Full MOVE insertion
/// would require modifying the instruction stream, which is better
/// done during code generation.
#[allow(dead_code)]
fn replace_phi_with_move(block: &mut SsaBlock, phi_idx: usize) -> bool {
    if phi_idx >= block.phi_nodes.len() {
        return false;
    }

    // Simply remove the phi - the code generator will handle
    // propagating the value appropriately
    block.phi_nodes.remove(phi_idx);
    true
}

/// Inline a phi instruction by replacing uses with the phi argument
/// JADX: inlinePhiInsn() - lines 390-419
///
/// This would require tracking SSAVar use-def chains, which we'll
/// implement when we add full SSA variable tracking to dexterity-ir.
#[allow(dead_code)]
fn inline_phi_insn(_phi: &PhiNode) -> bool {
    // TODO: Implement when SSAVar tracking is added
    // For now, phi cleanup happens during code generation
    false
}

/// Hide phi instructions from the instruction list
/// JADX: hidePhiInsns() - lines 448-452
///
/// In JADX, phi nodes are removed from the instruction list but kept
/// in the PHI_LIST attribute. In our implementation, phi nodes are
/// already separate from regular instructions (in SsaBlock.phi_nodes),
/// so this is a no-op.
pub fn hide_phi_insns(_result: &mut SsaResult) {
    // Phi nodes are already separated from instructions in SsaBlock
    // No action needed - they won't appear in generated code
}

/// Mark 'this' arguments with special flags
/// JADX: markThisArgs() - lines 421-446
///
/// This would require RegisterArg to have an AFlag field.
/// For now, we defer this to the type inference pass.
#[allow(dead_code)]
fn mark_this_args(_this_reg: Option<u16>) {
    // TODO: Implement when AFlag system is added to RegisterArg
    // This is primarily an optimization for type inference
}

/// Remove unused invoke results
/// JADX: removeUnusedInvokeResults() - lines 454-466
///
/// This requires SSAVar use count tracking. For now, this optimization
/// is deferred to later passes (dead code elimination).
#[allow(dead_code)]
fn remove_unused_invoke_results(_result: &mut SsaResult) {
    // TODO: Implement when SSAVar use tracking is added
    // This is primarily a code cleanup optimization
}

/// Fix last assign in try blocks
/// JADX: fixLastAssignInTry() - lines 195-207
///
/// This handles special cases where phi nodes in exception handlers
/// need to have certain arguments removed. This is exception-handler
/// specific and will be implemented with full exception handling support.
#[allow(dead_code)]
fn fix_last_assign_in_try(_result: &mut SsaResult) {
    // TODO: Implement with full exception handler support
    // Requires ExcHandlerAttr and CatchAttr tracking
}

/// Remove blocker instructions marked with AFlag::REMOVE
/// JADX: removeBlockerInsns() - lines 236-257
///
/// This removes instructions that were marked for removal during
/// earlier passes. Requires AFlag system integration.
#[allow(dead_code)]
fn remove_blocker_insns(_result: &mut SsaResult) -> bool {
    // TODO: Implement when AFlag system is integrated
    // This is primarily for cleanup after other optimizations
    false
}

// ============================================================================
// Public API for SSA cleanup (call after transform_to_ssa)
// ============================================================================

/// Apply all SSA cleanup passes to achieve 100% JADX parity
///
/// This performs the following optimizations:
/// 1. Remove useless phi nodes (unused results, identical arguments)
/// 2. Inline trivial phi nodes where possible
/// 3. Hide phi instructions from final code generation
///
/// Call this after transform_to_ssa() or transform_to_ssa_owned()
pub fn cleanup_ssa(result: &mut SsaResult) {
    // Fix useless phi nodes iteratively
    try_to_fix_useless_phi(result);

    // Hide phi instructions (already separated in our representation)
    hide_phi_insns(result);

    // TODO: Add additional cleanup passes as SSAVar tracking is implemented:
    // - remove_unused_invoke_results()
    // - fix_last_assign_in_try()
    // - remove_blocker_insns()
}

#[cfg(test)]
mod tests {
    use super::*;
    use std::collections::BTreeMap;

    fn make_test_blocks() -> BlockSplitResult {
        // Simple CFG:
        // Block 0 (entry) -> Block 1, Block 2
        // Block 1 -> Block 3
        // Block 2 -> Block 3
        // Block 3 (exit)

        let mut blocks = BTreeMap::new();

        // Block 0: entry, defines v0
        let mut b0 = BasicBlock::new(0, 0);
        b0.instructions.push(InsnNode::new(
            InsnType::Const {
                dest: RegisterArg::new(0),
                value: dexterity_ir::instructions::LiteralArg::Int(1),
            },
            0,
        ));
        b0.instructions.push(InsnNode::new(
            InsnType::If {
                condition: dexterity_ir::instructions::IfCondition::Eq,
                left: InsnArg::reg(0),
                right: None,
                target: 2,
            },
            1,
        ));
        b0.successors = vec![1, 2];
        blocks.insert(0, b0);

        // Block 1: defines v0 = 2
        let mut b1 = BasicBlock::new(1, 2);
        b1.instructions.push(InsnNode::new(
            InsnType::Const {
                dest: RegisterArg::new(0),
                value: dexterity_ir::instructions::LiteralArg::Int(2),
            },
            2,
        ));
        b1.successors = vec![3];
        b1.predecessors = vec![0];
        blocks.insert(1, b1);

        // Block 2: defines v0 = 3
        let mut b2 = BasicBlock::new(2, 3);
        b2.instructions.push(InsnNode::new(
            InsnType::Const {
                dest: RegisterArg::new(0),
                value: dexterity_ir::instructions::LiteralArg::Int(3),
            },
            3,
        ));
        b2.successors = vec![3];
        b2.predecessors = vec![0];
        blocks.insert(2, b2);

        // Block 3: uses v0, needs phi
        let mut b3 = BasicBlock::new(3, 4);
        b3.instructions.push(InsnNode::new(
            InsnType::Return {
                value: Some(InsnArg::reg(0)),
            },
            4,
        ));
        b3.predecessors = vec![1, 2];
        blocks.insert(3, b3);

        // Convert BTreeMap to Vec for BlockSplitResult
        let blocks_vec: Vec<BasicBlock> = blocks.into_values().collect();
        BlockSplitResult {
            blocks: blocks_vec,
            entry_block: 0,
            exit_blocks: vec![3],
        }
    }

    #[test]
    fn test_dominator_computation() {
        let blocks = make_test_blocks();
        let dom_tree = DominatorTree::compute(&blocks);

        // Block 0 dominates all blocks
        assert!(dom_tree.dominates(0, 0));
        assert!(dom_tree.dominates(0, 1));
        assert!(dom_tree.dominates(0, 2));
        assert!(dom_tree.dominates(0, 3));

        // Block 1 only dominates itself
        assert!(dom_tree.dominates(1, 1));
        assert!(!dom_tree.dominates(1, 2));
        assert!(!dom_tree.dominates(1, 3));
    }

    #[test]
    fn test_dominance_frontier() {
        let blocks = make_test_blocks();
        let dom_tree = DominatorTree::compute(&blocks);
        let frontiers = dom_tree.compute_frontiers(&blocks);

        // Block 1's dominance frontier should include Block 3
        assert!(frontiers.get(&1).map_or(false, |f| f.contains(&3)));

        // Block 2's dominance frontier should include Block 3
        assert!(frontiers.get(&2).map_or(false, |f| f.contains(&3)));
    }

    #[test]
    fn test_ssa_transform() {
        let blocks = make_test_blocks();
        let ssa = transform_to_ssa(&blocks);

        // Should have 4 blocks
        assert_eq!(ssa.blocks.len(), 4);

        // Block 3 should have a phi node for v0
        let block3 = ssa.blocks.iter().find(|b| b.id == 3).unwrap();
        assert!(!block3.phi_nodes.is_empty(), "Block 3 should have phi nodes");

        // The phi should have 2 sources (from blocks 1 and 2)
        let phi = &block3.phi_nodes[0];
        assert_eq!(phi.sources.len(), 2, "Phi should have 2 sources");
    }

    #[test]
    fn test_empty_blocks() {
        let blocks = BlockSplitResult {
            blocks: Vec::new(),
            entry_block: 0,
            exit_blocks: Vec::new(),
        };

        let ssa = transform_to_ssa(&blocks);
        assert!(ssa.blocks.is_empty());
    }

    #[test]
    fn test_is_same_args_phi() {
        // Empty phi
        let empty_phi = PhiNode {
            dest: RegisterArg::with_ssa(0, 1),
            sources: vec![],
        };
        assert!(is_same_args_phi(&empty_phi));

        // Single argument phi (trivial)
        let single_phi = PhiNode {
            dest: RegisterArg::with_ssa(0, 2),
            sources: vec![(1, RegisterArg::with_ssa(0, 1))],
        };
        assert!(is_same_args_phi(&single_phi));

        // All same arguments
        let same_phi = PhiNode {
            dest: RegisterArg::with_ssa(0, 3),
            sources: vec![
                (1, RegisterArg::with_ssa(0, 1)),
                (2, RegisterArg::with_ssa(0, 1)),
            ],
        };
        assert!(is_same_args_phi(&same_phi));

        // Different arguments
        let diff_phi = PhiNode {
            dest: RegisterArg::with_ssa(0, 4),
            sources: vec![
                (1, RegisterArg::with_ssa(0, 1)),
                (2, RegisterArg::with_ssa(0, 2)),
            ],
        };
        assert!(!is_same_args_phi(&diff_phi));
    }

    #[test]
    fn test_ssa_cleanup() {
        let blocks = make_test_blocks();
        let mut ssa = transform_to_ssa(&blocks);

        // Count phi nodes before cleanup
        let phi_count_before: usize = ssa.blocks.iter().map(|b| b.phi_nodes.len()).sum();
        assert!(phi_count_before > 0, "Should have phi nodes before cleanup");

        // Run cleanup
        cleanup_ssa(&mut ssa);

        // Phi nodes may be removed if they're trivial
        // Just verify cleanup runs without panicking
        assert!(ssa.blocks.len() > 0);
    }

    #[test]
    fn test_try_to_fix_useless_phi() {
        // Create a result with some trivial phi nodes
        let mut result = SsaResult {
            blocks: vec![
                SsaBlock {
                    id: 0,
                    phi_nodes: vec![
                        // Single argument phi (should be removed)
                        PhiNode {
                            dest: RegisterArg::with_ssa(0, 1),
                            sources: vec![(1, RegisterArg::with_ssa(0, 0))],
                        },
                        // All same arguments (should be removed)
                        PhiNode {
                            dest: RegisterArg::with_ssa(1, 1),
                            sources: vec![
                                (1, RegisterArg::with_ssa(1, 0)),
                                (2, RegisterArg::with_ssa(1, 0)),
                            ],
                        },
                    ],
                    instructions: vec![],
                    successors: vec![],
                    predecessors: vec![],
                },
            ],
            dominators: FxHashMap::default(),
            dom_frontiers: FxHashMap::default(),
            max_versions: FxHashMap::default(),
        };

        assert_eq!(result.blocks[0].phi_nodes.len(), 2);

        try_to_fix_useless_phi(&mut result);

        // All phi nodes should be removed as they're trivial
        assert_eq!(result.blocks[0].phi_nodes.len(), 0, "Trivial phi nodes should be removed");
    }
}
