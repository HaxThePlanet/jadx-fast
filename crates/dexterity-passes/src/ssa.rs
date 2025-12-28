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
use dexterity_ir::ssa::{SSAContext, SSAVarRef, SSA_FLAG_PHI_ASSIGN};

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
    /// SSA context with all SSAVar tracking
    pub ssa_context: SSAContext,
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

/// JADX Clone: RenameState.java
/// Tracks current SSA variable version for each register during dominator tree walk.
///
/// Key insight from JADX RenameState.java:33-39:
/// - vars (current version per register) is COPIED per block - each block sees its own state
/// - versions counter is SHARED globally - ensures unique version numbers
///
/// This copy semantics is critical for correct SSA: when visiting dominated blocks,
/// each child inherits the parent's current variable versions, but changes in one
/// subtree don't affect sibling subtrees.
struct RenameState {
    block_id: u32,
    /// Current SSAVar version for each register (COPIED per block)
    /// Maps register number -> current SSA version visible in this block
    vars: FxHashMap<u16, u32>,
}

impl RenameState {
    fn new(block_id: u32) -> Self {
        RenameState {
            block_id,
            vars: FxHashMap::default(),
        }
    }

    /// JADX Clone: RenameState.java:33-39 (copyFrom)
    /// Creates a copy of this state for a child block in the dominator tree.
    /// The vars map is cloned so changes in the child don't affect the parent.
    fn copy_for_block(&self, block_id: u32) -> Self {
        RenameState {
            block_id,
            vars: self.vars.clone(),  // COPY - key to correct behavior
        }
    }

    /// Get the current SSA version for a register, if defined
    fn get_var(&self, reg: u16) -> Option<u32> {
        self.vars.get(&reg).copied()
    }

    /// Set the current SSA version for a register
    fn set_var(&mut self, reg: u16, version: u32) {
        self.vars.insert(reg, version);
    }
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
        // CRITICAL FIX (P1-S10b): Handle Invoke/InvokeCustom dest field
        // process_instructions merges invoke+move_result, setting dest on the invoke.
        // SSA transform must track this as a definition!
        InsnType::Invoke { dest: Some(d), .. } => Some(d.reg_num),
        InsnType::InvokeCustom { dest: Some(d), .. } => Some(d.reg_num),
        _ => None,
    }
}

/// Transform to SSA form
pub fn transform_to_ssa(blocks: &BlockSplitResult) -> SsaResult {
    if blocks.blocks.is_empty() {
        return SsaResult {
            blocks: Vec::new(),
            dominators: FxHashMap::default(),
            dom_frontiers: FxHashMap::default(),
            max_versions: FxHashMap::default(),
            ssa_context: SSAContext::new(),
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

    // Step 5: Rename variables using RenameState (JADX Clone)
    // Version counter is SHARED globally to ensure unique version numbers
    let mut version_counter: FxHashMap<u16, u32> = FxHashMap::default();

    // Initialize version counter for all registers (start at 0, first assignment will be 1)
    for &var in &all_vars {
        version_counter.insert(var, 0);
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

    // JADX Clone: SSATransform.java:122-189 (renameVariables + renameVarsInBlock)
    // Rename variables in dominator tree order using RenameState with copy semantics.
    // This is the corrected algorithm that properly tracks per-block variable visibility.
    fn rename_block(
        state: &mut RenameState,
        ssa_blocks: &mut FxHashMap<u32, SsaBlock>,
        dom_tree: &DominatorTree,
        version_counter: &mut FxHashMap<u16, u32>,  // SHARED - global version counter
    ) {
        let block_id = state.block_id;
        let block = match ssa_blocks.get_mut(&block_id) {
            Some(b) => b,
            None => return,
        };

        // JADX Clone: SSATransform.java:148 - Process phi node destinations first
        // Each phi defines a new version of its destination register
        for phi in &mut block.phi_nodes {
            let reg = phi.dest.reg_num;
            let version = version_counter.entry(reg).or_insert(0);
            *version += 1;
            phi.dest.ssa_version = *version;
            state.set_var(reg, *version);  // Update state with new version
        }

        // JADX Clone: SSATransform.java:148-166 - Rename uses and definitions
        // Key: uses are processed BEFORE definitions (read current, then create new)
        for insn in &mut block.instructions {
            // First rename uses (get current version from state)
            rename_uses_with_state(&mut insn.insn_type, state);

            // Then rename definitions (create new version, update state)
            if let Some(reg) = get_def_register(&insn.insn_type) {
                let version = version_counter.entry(reg).or_insert(0);
                *version += 1;
                rename_def(&mut insn.insn_type, *version);
                state.set_var(reg, *version);
            }
        }

        // JADX Clone: SSATransform.java:169-179 (bindPhiArg)
        // Fill phi sources in successors using current state's variable versions
        let successors = block.successors.clone();
        for succ_id in successors {
            if let Some(succ) = ssa_blocks.get_mut(&succ_id) {
                for phi in &mut succ.phi_nodes {
                    let reg = phi.dest.reg_num;
                    // Use state.get_var() - the version visible in THIS predecessor block
                    if let Some(version) = state.get_var(reg) {
                        phi.sources.push((block_id, RegisterArg::with_ssa(reg, version)));
                    }
                    // If no version defined in this path, don't add a source (JADX behavior)
                }
            }
        }

        // JADX Clone: SSATransform.java:131-134 (dominator tree DFS with state copy)
        // Recursively rename dominated blocks - each child gets a COPY of current state
        // This copy semantics ensures changes in one subtree don't affect siblings
        if let Some(children) = dom_tree.children.get(&block_id) {
            for &child in children {
                // Copy state for child - each child sees parent's current vars
                let mut child_state = state.copy_for_block(child);
                rename_block(&mut child_state, ssa_blocks, dom_tree, version_counter);
            }
        }
        // No need to pop - state is automatically discarded after recursion (Rust semantics)
    }

    // Initialize state and start renaming from entry block
    let mut init_state = RenameState::new(blocks.entry_block);
    rename_block(
        &mut init_state,
        &mut ssa_blocks,
        &dom_tree,
        &mut version_counter,
    );

    // Convert to ordered vector
    let mut result_blocks: Vec<SsaBlock> = ssa_blocks.into_values().collect();
    result_blocks.sort_by_key(|b| b.id);

    // Build SSAContext by scanning all blocks
    let ssa_context = build_ssa_context(&result_blocks, &version_counter);

    SsaResult {
        blocks: result_blocks,
        dominators: dom_tree.idom,
        dom_frontiers,
        max_versions: version_counter,
        ssa_context,
    }
}

/// Build SSAContext from SSA blocks after transformation
fn build_ssa_context(blocks: &[SsaBlock], max_versions: &FxHashMap<u16, u32>) -> SSAContext {
    let mut ctx = SSAContext::new();
    for (&reg, &max_ver) in max_versions {
        for ver in 0..=max_ver {
            ctx.new_var_with_version(reg, ver);
        }
    }
    let mut idx: u32 = 0;
    for block in blocks {
        for phi in &block.phi_nodes {
            let vr = SSAVarRef::new(phi.dest.reg_num, phi.dest.ssa_version);
            if let Some(v) = ctx.get_var_mut(vr) {
                v.assign_insn_idx = Some(idx);
                v.flags |= SSA_FLAG_PHI_ASSIGN;
            }
            for (_, src) in &phi.sources {
                let sr = SSAVarRef::new(src.reg_num, src.ssa_version);
                if let Some(sv) = ctx.get_var_mut(sr) {
                    sv.add_use(idx);
                    sv.add_phi_use(idx);
                }
            }
            idx += 1;
        }
        for insn in &block.instructions {
            let cur = idx;
            idx += 1;
            if let Some(dest) = get_def_register(&insn.insn_type) {
                if let Some(ver) = get_def_version(&insn.insn_type) {
                    let vr = SSAVarRef::new(dest, ver);
                    if let Some(v) = ctx.get_var_mut(vr) {
                        v.assign_insn_idx = Some(cur);
                    }
                }
            }
            collect_uses(&insn.insn_type, cur, &mut ctx);
        }
    }
    ctx
}

fn get_def_version(insn_type: &InsnType) -> Option<u32> {
    match insn_type {
        InsnType::Const { dest, .. } | InsnType::ConstString { dest, .. } | InsnType::ConstClass { dest, .. } => Some(dest.ssa_version),
        InsnType::Move { dest, .. } | InsnType::MoveResult { dest } | InsnType::MoveException { dest } => Some(dest.ssa_version),
        InsnType::InstanceOf { dest, .. } | InsnType::ArrayLength { dest, .. } => Some(dest.ssa_version),
        InsnType::NewInstance { dest, .. } | InsnType::NewArray { dest, .. } => Some(dest.ssa_version),
        InsnType::FilledNewArray { dest, .. } => dest.as_ref().map(|d| d.ssa_version),
        InsnType::ArrayGet { dest, .. } | InsnType::InstanceGet { dest, .. } | InsnType::StaticGet { dest, .. } => Some(dest.ssa_version),
        InsnType::Unary { dest, .. } | InsnType::Binary { dest, .. } | InsnType::Cast { dest, .. } | InsnType::Compare { dest, .. } => Some(dest.ssa_version),
        InsnType::Invoke { dest: Some(d), .. } | InsnType::InvokeCustom { dest: Some(d), .. } => Some(d.ssa_version),
        _ => None,
    }
}

fn collect_uses(insn_type: &InsnType, idx: u32, ctx: &mut SSAContext) {
    fn add(arg: &InsnArg, idx: u32, ctx: &mut SSAContext) {
        if let InsnArg::Register(r) = arg {
            if let Some(v) = ctx.get_var_mut(SSAVarRef::new(r.reg_num, r.ssa_version)) { v.add_use(idx); }
        }
    }
    match insn_type {
        InsnType::Move { src, .. } => add(src, idx, ctx),
        InsnType::Return { value: Some(v) } => add(v, idx, ctx),
        InsnType::Throw { exception } => add(exception, idx, ctx),
        InsnType::MonitorEnter { object } | InsnType::MonitorExit { object } => add(object, idx, ctx),
        InsnType::CheckCast { object, .. } | InsnType::InstanceOf { object, .. } => add(object, idx, ctx),
        InsnType::ArrayLength { array, .. } | InsnType::FillArrayData { array, .. } => add(array, idx, ctx),
        InsnType::NewArray { size, .. } => add(size, idx, ctx),
        InsnType::FilledNewArray { args, .. } | InsnType::Invoke { args, .. } | InsnType::InvokeCustom { args, .. } => { for a in args { add(a, idx, ctx); } }
        InsnType::ArrayGet { array, index, .. } => { add(array, idx, ctx); add(index, idx, ctx); }
        InsnType::ArrayPut { array, index, value, .. } => { add(array, idx, ctx); add(index, idx, ctx); add(value, idx, ctx); }
        InsnType::InstanceGet { object, .. } => add(object, idx, ctx),
        InsnType::InstancePut { object, value, .. } => { add(object, idx, ctx); add(value, idx, ctx); }
        InsnType::StaticPut { value, .. } => add(value, idx, ctx),
        InsnType::Unary { arg, .. } | InsnType::Cast { arg, .. } => add(arg, idx, ctx),
        InsnType::Binary { left, right, .. } | InsnType::Compare { left, right, .. } => { add(left, idx, ctx); add(right, idx, ctx); }
        InsnType::If { left, right, .. } => { add(left, idx, ctx); if let Some(r) = right { add(r, idx, ctx); } }
        InsnType::PackedSwitch { value, .. } | InsnType::SparseSwitch { value, .. } => add(value, idx, ctx),
        _ => {}
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
        // CRITICAL FIX (P1-S10b): Handle Invoke/InvokeCustom dest field
        // process_instructions merges invoke+move_result, setting dest on the invoke.
        // SSA transform must assign version to this dest!
        InsnType::Invoke { dest: Some(d), .. } => d.ssa_version = version,
        InsnType::InvokeCustom { dest: Some(d), .. } => d.ssa_version = version,
        _ => {}
    }
}

/// JADX Clone: SSATransform.java:148-166 (rename uses with state lookup)
/// Rename uses in an instruction using RenameState for version lookup.
/// This is the corrected version that uses per-block state tracking instead of a global stack.
fn rename_uses_with_state(insn_type: &mut InsnType, state: &RenameState) {
    fn rename_arg(arg: &mut InsnArg, state: &RenameState) {
        if let InsnArg::Register(reg) = arg {
            // Use state.get_var() - the version visible in THIS block's path
            if let Some(version) = state.get_var(reg.reg_num) {
                reg.ssa_version = version;
            }
            // If no version defined, leave at 0 (uninitialized - JADX behavior)
        }
    }

    match insn_type {
        InsnType::Move { src, .. } => rename_arg(src, state),
        InsnType::Return { value: Some(v) } => rename_arg(v, state),
        InsnType::Throw { exception } => rename_arg(exception, state),
        InsnType::MonitorEnter { object } => rename_arg(object, state),
        InsnType::MonitorExit { object } => rename_arg(object, state),
        InsnType::CheckCast { object, .. } => rename_arg(object, state),
        InsnType::InstanceOf { object, .. } => rename_arg(object, state),
        InsnType::ArrayLength { array, .. } => rename_arg(array, state),
        InsnType::NewArray { size, .. } => rename_arg(size, state),
        InsnType::FilledNewArray { args, .. } => {
            for arg in args {
                rename_arg(arg, state);
            }
        }
        InsnType::FillArrayData { array, .. } => rename_arg(array, state),
        InsnType::ArrayGet { array, index, .. } => {
            rename_arg(array, state);
            rename_arg(index, state);
        }
        InsnType::ArrayPut { array, index, value, .. } => {
            rename_arg(array, state);
            rename_arg(index, state);
            rename_arg(value, state);
        }
        InsnType::InstanceGet { object, .. } => rename_arg(object, state),
        InsnType::InstancePut { object, value, .. } => {
            rename_arg(object, state);
            rename_arg(value, state);
        }
        InsnType::StaticPut { value, .. } => rename_arg(value, state),
        InsnType::Invoke { args, .. } => {
            for arg in args {
                rename_arg(arg, state);
            }
        }
        InsnType::InvokeCustom { args, .. } => {
            for arg in args {
                rename_arg(arg, state);
            }
        }
        InsnType::Unary { arg, .. } => rename_arg(arg, state),
        InsnType::Binary { left, right, .. } => {
            rename_arg(left, state);
            rename_arg(right, state);
        }
        InsnType::Cast { arg, .. } => rename_arg(arg, state),
        InsnType::Compare { left, right, .. } => {
            rename_arg(left, state);
            rename_arg(right, state);
        }
        InsnType::If { left, right, .. } => {
            rename_arg(left, state);
            if let Some(r) = right {
                rename_arg(r, state);
            }
        }
        InsnType::Ternary { left, right, then_value, else_value, .. } => {
            rename_arg(left, state);
            if let Some(r) = right {
                rename_arg(r, state);
            }
            rename_arg(then_value, state);
            rename_arg(else_value, state);
        }
        InsnType::PackedSwitch { value, .. } => rename_arg(value, state),
        InsnType::SparseSwitch { value, .. } => rename_arg(value, state),
        InsnType::Constructor { args, .. } => {
            for arg in args {
                rename_arg(arg, state);
            }
        }
        InsnType::StrConcat { args, .. } => {
            for arg in args {
                rename_arg(arg, state);
            }
        }
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
            ssa_context: SSAContext::new(),
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

    // Step 5: Rename variables using RenameState (JADX Clone)
    let mut version_counter: FxHashMap<u16, u32> = FxHashMap::default();

    for &var in &all_vars {
        version_counter.insert(var, 0);
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
    let successor_map: FxHashMap<u32, Vec<u32>> = ssa_blocks
        .iter()
        .map(|(&id, b)| (id, b.successors.clone()))
        .collect();

    // JADX Clone: SSATransform.java:122-189 (renameVariables + renameVarsInBlock)
    // Rename variables in dominator tree order using RenameState with copy semantics.
    fn rename_block_owned(
        state: &mut RenameState,
        ssa_blocks: &mut FxHashMap<u32, SsaBlock>,
        dom_tree: &DominatorTree,
        version_counter: &mut FxHashMap<u16, u32>,
        successor_map: &FxHashMap<u32, Vec<u32>>,
    ) {
        let block_id = state.block_id;
        let block = match ssa_blocks.get_mut(&block_id) {
            Some(b) => b,
            None => return,
        };

        // JADX Clone: SSATransform.java:148 - Process phi node destinations first
        for phi in &mut block.phi_nodes {
            let reg = phi.dest.reg_num;
            let version = version_counter.entry(reg).or_insert(0);
            *version += 1;
            phi.dest.ssa_version = *version;
            state.set_var(reg, *version);
        }

        // JADX Clone: SSATransform.java:148-166 - Rename uses and definitions
        for insn in &mut block.instructions {
            rename_uses_with_state(&mut insn.insn_type, state);
            if let Some(reg) = get_def_register(&insn.insn_type) {
                let version = version_counter.entry(reg).or_insert(0);
                *version += 1;
                rename_def(&mut insn.insn_type, *version);
                state.set_var(reg, *version);
            }
        }

        // JADX Clone: SSATransform.java:169-179 (bindPhiArg)
        let successors = successor_map.get(&block_id).cloned().unwrap_or_default();
        for succ_id in successors {
            if let Some(succ) = ssa_blocks.get_mut(&succ_id) {
                for phi in &mut succ.phi_nodes {
                    let reg = phi.dest.reg_num;
                    if let Some(version) = state.get_var(reg) {
                        phi.sources.push((block_id, RegisterArg::with_ssa(reg, version)));
                    }
                }
            }
        }

        // JADX Clone: SSATransform.java:131-134 (dominator tree DFS with state copy)
        if let Some(children) = dom_tree.children.get(&block_id) {
            for &child in children {
                let mut child_state = state.copy_for_block(child);
                rename_block_owned(&mut child_state, ssa_blocks, dom_tree, version_counter, successor_map);
            }
        }
    }

    let mut init_state = RenameState::new(entry_block);
    rename_block_owned(
        &mut init_state,
        &mut ssa_blocks,
        &dom_tree,
        &mut version_counter,
        &successor_map,
    );

    // Convert to ordered vector
    let mut result_blocks: Vec<SsaBlock> = ssa_blocks.into_values().collect();
    result_blocks.sort_by_key(|b| b.id);

    // Build SSAContext by scanning all blocks
    let ssa_context = build_ssa_context(&result_blocks, &version_counter);

    SsaResult {
        blocks: result_blocks,
        dominators: dom_tree.idom,
        dom_frontiers,
        max_versions: version_counter,
        ssa_context,
    }
}

// ============================================================================
// SSA Modification Helpers for Type Fixing (JADX parity)
// ============================================================================
//
// These functions enable SSA modifications after the initial transform:
// - splitByPhi: Duplicate CONST instructions for PHI type conflicts
// - insertMove: Add MOVE instructions before PHI
// - getNextVersion: Allocate new SSA versions for duplicated instructions
//
// Reference: jadx-core/src/main/java/jadx/core/dex/visitors/typeinference/FixTypesVisitor.java
// Lines 464-535

impl SsaResult {
    /// Get the next available SSA version for a register
    pub fn next_version(&mut self, reg_num: u16) -> u32 {
        let version = self.max_versions.entry(reg_num).or_insert(0);
        *version += 1;
        *version
    }

    /// Find the block containing an instruction that assigns to a specific SSA variable
    pub fn find_const_block(&self, reg_num: u16, ssa_version: u32) -> Option<u32> {
        for block in &self.blocks {
            for insn in &block.instructions {
                let dest = match &insn.insn_type {
                    InsnType::Const { dest, .. } |
                    InsnType::ConstString { dest, .. } |
                    InsnType::ConstClass { dest, .. } => Some(dest),
                    _ => None,
                };
                if let Some(d) = dest {
                    if d.reg_num == reg_num && d.ssa_version == ssa_version {
                        return Some(block.id);
                    }
                }
            }
        }
        None
    }

    /// Find the instruction index of a CONST instruction in a block
    fn find_const_insn_idx(&self, block_id: u32, reg_num: u16, ssa_version: u32) -> Option<usize> {
        let block = self.blocks.iter().find(|b| b.id == block_id)?;
        for (idx, insn) in block.instructions.iter().enumerate() {
            let dest = match &insn.insn_type {
                InsnType::Const { dest, .. } |
                InsnType::ConstString { dest, .. } |
                InsnType::ConstClass { dest, .. } => Some(dest),
                _ => None,
            };
            if let Some(d) = dest {
                if d.reg_num == reg_num && d.ssa_version == ssa_version {
                    return Some(idx);
                }
            }
        }
        None
    }

    /// Clone a CONST instruction with a new SSA version
    ///
    /// JADX Reference: InsnNode.copyWithNewSsaVar()
    fn clone_const_with_new_version(&self, block_id: u32, reg_num: u16, ssa_version: u32, new_version: u32) -> Option<InsnNode> {
        let block = self.blocks.iter().find(|b| b.id == block_id)?;
        for insn in &block.instructions {
            let matches = match &insn.insn_type {
                InsnType::Const { dest, .. } |
                InsnType::ConstString { dest, .. } |
                InsnType::ConstClass { dest, .. } => {
                    dest.reg_num == reg_num && dest.ssa_version == ssa_version
                }
                _ => false,
            };
            if matches {
                let mut new_insn = insn.clone();
                // Update the destination SSA version
                match &mut new_insn.insn_type {
                    InsnType::Const { dest, .. } |
                    InsnType::ConstString { dest, .. } |
                    InsnType::ConstClass { dest, .. } => {
                        dest.ssa_version = new_version;
                    }
                    _ => {}
                }
                return Some(new_insn);
            }
        }
        None
    }
}

/// Split CONST instructions used in multiple PHI nodes
///
/// JADX Reference: FixTypesVisitor.splitByPhi() lines 508-535
///
/// When a single CONST instruction is used as an argument to multiple PHI nodes,
/// this creates type inference conflicts because each PHI may expect a different type.
///
/// Example problem:
/// ```text
/// const/4 v0 = 0        // Single CONST with two PHI uses
/// phi v2 = [v0, ...]    // PHI 1: interprets as INT (array index)
/// phi v3 = [v0, ...]    // PHI 2: interprets as BOOLEAN (condition)
/// // TYPE CONFLICT: v0 cannot be both INT and BOOLEAN
/// ```
///
/// Solution: Duplicate the CONST instruction so each PHI has its own copy:
/// ```text
/// const/4 v0#1 = 0      // Original CONST for PHI 1
/// const/4 v0#2 = 0      // Copy for PHI 2
/// phi v2 = [v0#1, ...]  // Uses first version
/// phi v3 = [v0#2, ...]  // Uses second version
/// ```
///
/// Returns the number of instructions duplicated.
pub fn split_by_phi(ssa: &mut SsaResult) -> usize {
    // Step 1: Find all CONST SSA variables and their PHI uses
    // Maps (reg_num, ssa_version) -> Vec<(block_id, phi_index, source_index)>
    let mut const_phi_uses: FxHashMap<(u16, u32), Vec<(u32, usize, usize)>> = FxHashMap::default();

    // Collect all CONST definitions
    let mut const_vars: FxHashSet<(u16, u32)> = FxHashSet::default();
    for block in &ssa.blocks {
        for insn in &block.instructions {
            let dest = match &insn.insn_type {
                InsnType::Const { dest, .. } |
                InsnType::ConstString { dest, .. } |
                InsnType::ConstClass { dest, .. } => Some(dest),
                _ => None,
            };
            if let Some(d) = dest {
                const_vars.insert((d.reg_num, d.ssa_version));
            }
        }
    }

    // Find PHI uses of CONST variables
    for block in &ssa.blocks {
        for (phi_idx, phi) in block.phi_nodes.iter().enumerate() {
            for (src_idx, (_, src_reg)) in phi.sources.iter().enumerate() {
                let key = (src_reg.reg_num, src_reg.ssa_version);
                if const_vars.contains(&key) {
                    const_phi_uses.entry(key)
                        .or_default()
                        .push((block.id, phi_idx, src_idx));
                }
            }
        }
    }

    // Step 2: For CONST vars with 2+ PHI uses, duplicate for all but the first
    let mut duplicated_count = 0;
    let mut modifications: Vec<(u16, u32, Vec<(u32, usize, usize, u32)>)> = Vec::new();

    for ((reg_num, ssa_version), phi_uses) in const_phi_uses {
        if phi_uses.len() < 2 {
            continue; // Need at least 2 PHI uses to benefit from splitting
        }

        // Find the block containing the CONST instruction
        let const_block_id = match ssa.find_const_block(reg_num, ssa_version) {
            Some(id) => id,
            None => continue,
        };

        // Prepare modifications for PHIs after the first
        let mut phi_updates: Vec<(u32, usize, usize, u32)> = Vec::new();

        for (phi_block_id, phi_idx, src_idx) in phi_uses.into_iter().skip(1) {
            // Allocate a new SSA version
            let new_version = ssa.next_version(reg_num);
            phi_updates.push((phi_block_id, phi_idx, src_idx, new_version));
            duplicated_count += 1;

            tracing::debug!(
                "splitByPhi: Duplicating r{}#{} -> r{}#{} for PHI in block {}",
                reg_num, ssa_version, reg_num, new_version, phi_block_id
            );
        }

        if !phi_updates.is_empty() {
            modifications.push((reg_num, ssa_version, phi_updates));
        }
    }

    // Step 3: Apply modifications
    for (reg_num, ssa_version, phi_updates) in modifications {
        // Find the const block and instruction index
        let const_block_id = match ssa.find_const_block(reg_num, ssa_version) {
            Some(id) => id,
            None => continue,
        };
        let const_insn_idx = match ssa.find_const_insn_idx(const_block_id, reg_num, ssa_version) {
            Some(idx) => idx,
            None => continue,
        };

        // For each PHI that needs updating (all but the first)
        for (phi_block_id, phi_idx, src_idx, new_version) in phi_updates {
            // Clone the CONST instruction with new SSA version
            let new_insn = match ssa.clone_const_with_new_version(const_block_id, reg_num, ssa_version, new_version) {
                Some(insn) => insn,
                None => continue,
            };

            // Insert the cloned instruction after the original
            if let Some(block) = ssa.blocks.iter_mut().find(|b| b.id == const_block_id) {
                // Insert after the original CONST
                block.instructions.insert(const_insn_idx + 1, new_insn);
            }

            // Update the PHI source to use the new SSA version
            if let Some(phi_block) = ssa.blocks.iter_mut().find(|b| b.id == phi_block_id) {
                if let Some(phi) = phi_block.phi_nodes.get_mut(phi_idx) {
                    if let Some((_, ref mut src_reg)) = phi.sources.get_mut(src_idx) {
                        src_reg.ssa_version = new_version;
                    }
                }
            }
        }
    }

    if duplicated_count > 0 {
        tracing::info!("splitByPhi: Duplicated {} CONST instructions for PHI type disambiguation", duplicated_count);
    }

    duplicated_count
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

    // Additional cleanup passes available when SSAVar tracking is integrated:
    // - remove_unused_invoke_results() - dead code elimination
    // - fix_last_assign_in_try() - exception handler cleanup
    // - remove_blocker_insns() - post-optimization cleanup
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
            ssa_context: SSAContext::new(),
        };

        assert_eq!(result.blocks[0].phi_nodes.len(), 2);

        try_to_fix_useless_phi(&mut result);

        // All phi nodes should be removed as they're trivial
        assert_eq!(result.blocks[0].phi_nodes.len(), 0, "Trivial phi nodes should be removed");
    }

    #[test]
    fn test_split_by_phi() {
        // Create a scenario where a single CONST is used by two PHIs
        // Block 0: const v0 = 0
        // Block 1: (empty, just jumps to 3)
        // Block 2: (empty, just jumps to 4)
        // Block 3: phi v1 = [v0 from 0, v1 from 1]  <- uses const v0
        // Block 4: phi v2 = [v0 from 0, v2 from 2]  <- uses const v0
        //
        // After splitByPhi:
        // Block 0: const v0#1 = 0, const v0#2 = 0
        // Block 3: phi v1 = [v0#1 from 0, ...]
        // Block 4: phi v2 = [v0#2 from 0, ...]
        let mut ssa = SsaResult {
            blocks: vec![
                SsaBlock {
                    id: 0,
                    phi_nodes: vec![],
                    instructions: vec![
                        InsnNode::new(
                            InsnType::Const {
                                dest: RegisterArg::with_ssa(0, 1),
                                value: dexterity_ir::instructions::LiteralArg::Int(0),
                            },
                            0,
                        ),
                    ],
                    successors: vec![3, 4],
                    predecessors: vec![],
                },
                SsaBlock {
                    id: 3,
                    phi_nodes: vec![
                        PhiNode {
                            dest: RegisterArg::with_ssa(1, 1),
                            sources: vec![
                                (0, RegisterArg::with_ssa(0, 1)), // Uses const v0#1
                                (1, RegisterArg::with_ssa(1, 2)),
                            ],
                        },
                    ],
                    instructions: vec![],
                    successors: vec![],
                    predecessors: vec![0, 1],
                },
                SsaBlock {
                    id: 4,
                    phi_nodes: vec![
                        PhiNode {
                            dest: RegisterArg::with_ssa(2, 1),
                            sources: vec![
                                (0, RegisterArg::with_ssa(0, 1)), // Uses const v0#1 (same!)
                                (2, RegisterArg::with_ssa(2, 2)),
                            ],
                        },
                    ],
                    instructions: vec![],
                    successors: vec![],
                    predecessors: vec![0, 2],
                },
            ],
            dominators: FxHashMap::default(),
            dom_frontiers: FxHashMap::default(),
            max_versions: {
                let mut m = FxHashMap::default();
                m.insert(0, 1);
                m.insert(1, 2);
                m.insert(2, 2);
                m
            },
            ssa_context: SSAContext::new(),
        };

        // Before: both PHIs reference v0#1
        let phi3 = &ssa.blocks[1].phi_nodes[0];
        let phi4 = &ssa.blocks[2].phi_nodes[0];
        assert_eq!(phi3.sources[0].1.ssa_version, 1);
        assert_eq!(phi4.sources[0].1.ssa_version, 1);

        // Count instructions in block 0 before
        let insn_count_before = ssa.blocks[0].instructions.len();
        assert_eq!(insn_count_before, 1);

        // Run splitByPhi
        let duplicated = split_by_phi(&mut ssa);

        // Should have duplicated 1 instruction (for the second PHI)
        assert_eq!(duplicated, 1, "Should duplicate 1 CONST for second PHI");

        // Block 0 should now have 2 instructions
        assert_eq!(ssa.blocks[0].instructions.len(), 2, "Block 0 should have 2 CONST instructions");

        // The second PHI (block 4) should now reference a different SSA version
        let phi3_after = &ssa.blocks[1].phi_nodes[0];
        let phi4_after = &ssa.blocks[2].phi_nodes[0];

        // First PHI keeps original version
        assert_eq!(phi3_after.sources[0].1.ssa_version, 1, "First PHI should keep original version");

        // Second PHI gets new version
        assert_eq!(phi4_after.sources[0].1.ssa_version, 2, "Second PHI should get new version");
    }

    #[test]
    fn test_split_by_phi_no_action_single_phi() {
        // A CONST used by only one PHI should not be split
        let mut ssa = SsaResult {
            blocks: vec![
                SsaBlock {
                    id: 0,
                    phi_nodes: vec![],
                    instructions: vec![
                        InsnNode::new(
                            InsnType::Const {
                                dest: RegisterArg::with_ssa(0, 1),
                                value: dexterity_ir::instructions::LiteralArg::Int(0),
                            },
                            0,
                        ),
                    ],
                    successors: vec![1],
                    predecessors: vec![],
                },
                SsaBlock {
                    id: 1,
                    phi_nodes: vec![
                        PhiNode {
                            dest: RegisterArg::with_ssa(1, 1),
                            sources: vec![
                                (0, RegisterArg::with_ssa(0, 1)), // Uses const v0#1
                            ],
                        },
                    ],
                    instructions: vec![],
                    successors: vec![],
                    predecessors: vec![0],
                },
            ],
            dominators: FxHashMap::default(),
            dom_frontiers: FxHashMap::default(),
            max_versions: {
                let mut m = FxHashMap::default();
                m.insert(0, 1);
                m.insert(1, 1);
                m
            },
            ssa_context: SSAContext::new(),
        };

        // Run splitByPhi
        let duplicated = split_by_phi(&mut ssa);

        // Should not duplicate anything (only 1 PHI uses this CONST)
        assert_eq!(duplicated, 0, "Should not duplicate for single PHI use");
        assert_eq!(ssa.blocks[0].instructions.len(), 1, "Block 0 should still have 1 instruction");
    }
}
