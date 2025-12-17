//! ModVisitor pass - Instruction modification and optimization
//!
//! This pass modifies and optimizes instructions, based on JADX's ModVisitor.java
//! and ReplaceNewArray.java.
//!
//! ## Array Initialization Fusion
//!
//! ### Pattern 1: NEW_ARRAY + FILL_ARRAY_DATA
//! ```java
//! // Before:
//! int[] arr = new int[3];        // NewArray
//! fill-array-data arr, [1,2,3]   // FillArrayData
//!
//! // After:
//! int[] arr = {1, 2, 3};         // FilledNewArray
//! ```
//!
//! ### Pattern 2: NEW_ARRAY + APUT sequence (from ReplaceNewArray.java)
//! ```java
//! // Before:
//! int[] arr = new int[3];        // NewArray
//! arr[0] = 1;                    // ArrayPut
//! arr[1] = 2;                    // ArrayPut
//! arr[2] = 3;                    // ArrayPut
//!
//! // After:
//! int[] arr = {1, 2, 3};         // FilledNewArray
//! ```
//!
//! ## Dead Instruction Removal
//! - Removes NOP, GOTO instructions
//! - Removes instructions marked for removal
//!
//! Based on JADX's ModVisitor.java (634 lines) and ReplaceNewArray.java (218 lines)

use std::collections::{HashMap, HashSet};
use dexterity_ir::instructions::{InsnArg, InsnNode, InsnType, LiteralArg};
use crate::ssa::SsaResult;

/// Result of the ModVisitor pass
#[derive(Debug)]
pub struct ModVisitorResult {
    /// Number of arrays fused (NewArray + FillArrayData -> FilledNewArray)
    pub arrays_fused: usize,
    /// Number of arrays fused from APUT sequence (NewArray + ArrayPut[] -> FilledNewArray)
    pub aput_arrays_fused: usize,
    /// Number of instructions removed (NOP, GOTO, dead moves)
    pub instructions_removed: usize,
}

/// Run the ModVisitor pass on SSA form
///
/// This pass should run early in the pipeline, before type inference and code shrinking.
pub fn run_mod_visitor(ssa: &mut SsaResult) -> ModVisitorResult {
    let mut arrays_fused = 0;
    let mut aput_arrays_fused = 0;
    let mut instructions_removed = 0;

    // Phase 1a: Array initialization fusion (NEW_ARRAY + FILL_ARRAY_DATA)
    arrays_fused += fuse_array_init(ssa);

    // Phase 1b: APUT sequence fusion (NEW_ARRAY + ArrayPut[])
    // Based on JADX's ReplaceNewArray.java
    aput_arrays_fused += fuse_aput_sequence(ssa);

    // Phase 2: Remove dead instructions (NOP, GOTO)
    instructions_removed += remove_dead_instructions(ssa);

    // Phase 3: Iterative dead MOVE removal
    instructions_removed += iterative_remove_dead_moves(ssa);

    ModVisitorResult {
        arrays_fused,
        aput_arrays_fused,
        instructions_removed,
    }
}

/// Fuse NEW_ARRAY + FILL_ARRAY_DATA into FILLED_NEW_ARRAY
fn fuse_array_init(ssa: &mut SsaResult) -> usize {
    let mut fused_count = 0;

    // Step 1: Build a map of NewArray definitions
    // Key: (reg_num, ssa_version) of the result register
    // Value: (block_idx, insn_idx, size_as_literal, type_idx)
    let mut new_array_defs: HashMap<(u16, u32), (usize, usize, Option<i64>, u32)> = HashMap::new();

    for (block_idx, block) in ssa.blocks.iter().enumerate() {
        for (insn_idx, insn) in block.instructions.iter().enumerate() {
            if let InsnType::NewArray { dest, size, type_idx } = &insn.insn_type {
                let size_literal = extract_literal(size);
                new_array_defs.insert(
                    (dest.reg_num, dest.ssa_version),
                    (block_idx, insn_idx, size_literal, *type_idx),
                );
            }
        }
    }

    // Step 2: Find FillArrayData that reference NewArray results
    // Collect fusion candidates: (new_array_block, new_array_idx, fill_block, fill_idx, data, type_idx)
    let mut fusion_candidates: Vec<(usize, usize, usize, usize, Vec<i64>, u32)> = Vec::new();

    for (block_idx, block) in ssa.blocks.iter().enumerate() {
        for (insn_idx, insn) in block.instructions.iter().enumerate() {
            if let InsnType::FillArrayData { array, data, .. } = &insn.insn_type {
                // Check if array arg references a NewArray result
                if let InsnArg::Register(reg) = array {
                    let key = (reg.reg_num, reg.ssa_version);
                    if let Some(&(na_block, na_idx, size_lit, type_idx)) = new_array_defs.get(&key) {
                        // Verify array sizes match
                        if let Some(declared_size) = size_lit {
                            if declared_size as usize == data.len() {
                                fusion_candidates.push((
                                    na_block, na_idx, block_idx, insn_idx,
                                    data.clone(), type_idx
                                ));
                            }
                        } else if !data.is_empty() {
                            // If we can't verify size, still fuse if data is non-empty
                            // The data size becomes the authoritative size
                            fusion_candidates.push((
                                na_block, na_idx, block_idx, insn_idx,
                                data.clone(), type_idx
                            ));
                        }
                    }
                }
            }
        }
    }

    // Step 3: Apply fusions
    // Track which instructions to remove (FillArrayData)
    let mut to_remove: HashSet<(usize, usize)> = HashSet::new();
    // Track which NewArray to replace with FilledNewArray
    let mut replacements: HashMap<(usize, usize), InsnNode> = HashMap::new();

    for (na_block, na_idx, fill_block, fill_idx, data, type_idx) in fusion_candidates {
        // Get the original NewArray to copy its dest register
        let new_array_insn = &ssa.blocks[na_block].instructions[na_idx];
        if let InsnType::NewArray { dest, .. } = &new_array_insn.insn_type {
            // Convert data elements to InsnArgs
            let args: Vec<InsnArg> = data.iter().map(|&val| {
                InsnArg::Literal(LiteralArg::Int(val))
            }).collect();

            let filled_array = InsnNode::new(
                InsnType::FilledNewArray {
                    dest: Some(*dest),
                    type_idx,
                    args,
                },
                new_array_insn.offset,
            );

            replacements.insert((na_block, na_idx), filled_array);
            to_remove.insert((fill_block, fill_idx));
            fused_count += 1;
        }
    }

    // Step 4: Apply replacements
    for ((block_idx, insn_idx), new_insn) in replacements {
        ssa.blocks[block_idx].instructions[insn_idx] = new_insn;
    }

    // Step 5: Remove FillArrayData instructions (replace with NOP placeholder)
    for (block_idx, insn_idx) in to_remove {
        let offset = ssa.blocks[block_idx].instructions[insn_idx].offset;
        ssa.blocks[block_idx].instructions[insn_idx] = InsnNode::new(InsnType::Nop, offset);
    }

    fused_count
}

/// Extract literal value from an InsnArg if it's a constant
fn extract_literal(arg: &InsnArg) -> Option<i64> {
    match arg {
        InsnArg::Literal(LiteralArg::Int(val)) => Some(*val),
        _ => None,
    }
}

/// Fuse NEW_ARRAY + ArrayPut sequence into FILLED_NEW_ARRAY
///
/// Based on JADX's ReplaceNewArray.java. This handles the pattern:
/// ```java
/// int[] arr = new int[3];
/// arr[0] = 1;
/// arr[1] = 2;
/// arr[2] = 3;
/// // becomes: int[] arr = {1, 2, 3};
/// ```
///
/// The algorithm:
/// 1. Find NEW_ARRAY instructions with constant size
/// 2. Track all ArrayPut uses that write to consecutive indices
/// 3. If all indices 0..len-1 are covered (or at least half for primitives), fuse
/// 4. All ArrayPuts must be in the same block as the NEW_ARRAY
fn fuse_aput_sequence(ssa: &mut SsaResult) -> usize {
    use std::collections::BTreeMap;

    let mut fused_count = 0;

    // Process each block independently (APUTs must be in same block)
    for block_idx in 0..ssa.blocks.len() {
        // Step 1: Find all NEW_ARRAY instructions in this block with constant size
        // Key: (reg_num, ssa_version), Value: (insn_idx, size, type_idx)
        let mut new_arrays: HashMap<(u16, u32), (usize, i64, u32)> = HashMap::new();

        for (insn_idx, insn) in ssa.blocks[block_idx].instructions.iter().enumerate() {
            if let InsnType::NewArray { dest, size, type_idx } = &insn.insn_type {
                if let Some(size_val) = extract_literal(size) {
                    if size_val > 0 && size_val <= 256 {  // Reasonable size limit
                        new_arrays.insert(
                            (dest.reg_num, dest.ssa_version),
                            (insn_idx, size_val, *type_idx),
                        );
                    }
                }
            }
        }

        if new_arrays.is_empty() {
            continue;
        }

        // Step 2: For each NEW_ARRAY, collect ArrayPut instructions
        // Key: (reg_num, ssa_version) of array
        // Value: BTreeMap<index, (insn_idx, value_arg)>
        let mut array_puts: HashMap<(u16, u32), BTreeMap<i64, (usize, InsnArg)>> = HashMap::new();

        for (insn_idx, insn) in ssa.blocks[block_idx].instructions.iter().enumerate() {
            if let InsnType::ArrayPut { array, index, value, .. } = &insn.insn_type {
                // Check if array is a register referencing a NEW_ARRAY
                if let InsnArg::Register(arr_reg) = array {
                    let arr_key = (arr_reg.reg_num, arr_reg.ssa_version);
                    if new_arrays.contains_key(&arr_key) {
                        // Check if index is a constant
                        if let Some(idx_val) = extract_literal(index) {
                            let puts = array_puts.entry(arr_key).or_insert_with(BTreeMap::new);
                            // Only store first write to each index (JADX stops on rewrite)
                            if !puts.contains_key(&idx_val) {
                                puts.insert(idx_val, (insn_idx, value.clone()));
                            }
                        }
                    }
                }
            }
        }

        // Step 3: Check which arrays can be fused
        let mut to_fuse: Vec<((u16, u32), usize, i64, u32, BTreeMap<i64, (usize, InsnArg)>)> = Vec::new();

        for (arr_key, (na_insn_idx, size, type_idx)) in &new_arrays {
            if let Some(puts) = array_puts.get(arr_key) {
                let len = *size as usize;
                // JADX allows primitives with at least half coverage, objects need full
                // For simplicity, we require at least half coverage
                let min_puts = (len + 1) / 2;

                if puts.len() >= min_puts {
                    // Verify all indices are in bounds
                    let all_in_bounds = puts.keys().all(|&idx| idx >= 0 && idx < *size);
                    if all_in_bounds {
                        // Verify no self-reference (array not used in put values)
                        let no_self_ref = puts.values().all(|(_, val)| {
                            if let InsnArg::Register(reg) = val {
                                (reg.reg_num, reg.ssa_version) != *arr_key
                            } else {
                                true
                            }
                        });

                        if no_self_ref {
                            to_fuse.push((*arr_key, *na_insn_idx, *size, *type_idx, puts.clone()));
                        }
                    }
                }
            }
        }

        // Step 4: Apply fusions
        for (_arr_key, na_insn_idx, size, type_idx, puts) in to_fuse {
            // Get the dest register from the NEW_ARRAY
            let dest = if let InsnType::NewArray { dest, .. } = &ssa.blocks[block_idx].instructions[na_insn_idx].insn_type {
                *dest
            } else {
                continue;
            };

            // Build the args array, filling gaps with zero literals
            let mut args: Vec<InsnArg> = Vec::with_capacity(size as usize);
            for i in 0..size {
                if let Some((_, val)) = puts.get(&i) {
                    args.push(val.clone());
                } else {
                    // Fill missing indices with 0 (JADX behavior)
                    args.push(InsnArg::Literal(LiteralArg::Int(0)));
                }
            }

            // Get last APUT index to determine where to place FilledNewArray
            let last_put_idx = puts.values().map(|(idx, _)| *idx).max().unwrap_or(na_insn_idx);
            let offset = ssa.blocks[block_idx].instructions[last_put_idx].offset;

            // Create the FilledNewArray instruction
            let filled_array = InsnNode::new(
                InsnType::FilledNewArray {
                    dest: Some(dest),
                    type_idx,
                    args,
                },
                offset,
            );

            // Mark NEW_ARRAY and all APUTs for removal
            let na_offset = ssa.blocks[block_idx].instructions[na_insn_idx].offset;
            ssa.blocks[block_idx].instructions[na_insn_idx] = InsnNode::new(InsnType::Nop, na_offset);

            for (_, (put_idx, _)) in &puts {
                let put_offset = ssa.blocks[block_idx].instructions[*put_idx].offset;
                ssa.blocks[block_idx].instructions[*put_idx] = InsnNode::new(InsnType::Nop, put_offset);
            }

            // Insert the new FilledNewArray at the position of last APUT
            ssa.blocks[block_idx].instructions[last_put_idx] = filled_array;

            fused_count += 1;

            // Remove arr_key from new_arrays to prevent double processing
            // (This is needed because we're modifying instructions while iterating)
        }
    }

    fused_count
}

/// Remove NOP and GOTO instructions
fn remove_dead_instructions(ssa: &mut SsaResult) -> usize {
    let mut removed = 0;

    for block in &mut ssa.blocks {
        let orig_len = block.instructions.len();
        block.instructions.retain(|insn| {
            !matches!(insn.insn_type, InsnType::Nop)
        });
        removed += orig_len - block.instructions.len();
    }

    removed
}

/// Iteratively remove dead MOVE instructions
///
/// A MOVE is dead if its result register is never used.
fn iterative_remove_dead_moves(ssa: &mut SsaResult) -> usize {
    let mut total_removed = 0;

    loop {
        // Build use count map
        let mut use_counts: HashMap<(u16, u32), usize> = HashMap::new();

        // Count uses across all instructions
        for block in &ssa.blocks {
            for insn in &block.instructions {
                count_uses(&insn.insn_type, &mut use_counts);
            }
        }

        // Also count PHI uses
        for block in &ssa.blocks {
            for phi in &block.phi_nodes {
                for (_, source) in &phi.sources {
                    let key = (source.reg_num, source.ssa_version);
                    *use_counts.entry(key).or_insert(0) += 1;
                }
            }
        }

        // Find and remove dead MOVEs
        let mut removed_this_pass = 0;

        for block in &mut ssa.blocks {
            let orig_len = block.instructions.len();
            block.instructions.retain(|insn| {
                if let InsnType::Move { dest, .. } = &insn.insn_type {
                    let key = (dest.reg_num, dest.ssa_version);
                    let uses = use_counts.get(&key).copied().unwrap_or(0);
                    if uses == 0 {
                        return false; // Remove dead MOVE
                    }
                }
                true
            });
            removed_this_pass += orig_len - block.instructions.len();
        }

        total_removed += removed_this_pass;

        if removed_this_pass == 0 {
            break; // No more dead moves found
        }
    }

    total_removed
}

/// Count register uses in an instruction
fn count_uses(insn_type: &InsnType, counts: &mut HashMap<(u16, u32), usize>) {
    let mut count_arg = |arg: &InsnArg| {
        if let InsnArg::Register(reg) = arg {
            let key = (reg.reg_num, reg.ssa_version);
            *counts.entry(key).or_insert(0) += 1;
        }
    };

    match insn_type {
        InsnType::Move { src, .. } => count_arg(src),
        InsnType::Return { value: Some(v) } => count_arg(v),
        InsnType::Const { .. } | InsnType::ConstString { .. } | InsnType::ConstClass { .. } => {}
        InsnType::If { left, right, .. } => {
            count_arg(left);
            if let Some(r) = right {
                count_arg(r);
            }
        }
        InsnType::Binary { left, right, .. } => {
            count_arg(left);
            count_arg(right);
        }
        InsnType::Unary { arg, .. } => count_arg(arg),
        InsnType::Cast { arg, .. } => count_arg(arg),
        InsnType::Compare { left, right, .. } => {
            count_arg(left);
            count_arg(right);
        }
        InsnType::Invoke { args, .. } => {
            for arg in args {
                count_arg(arg);
            }
        }
        InsnType::MoveResult { .. } => {
            // MoveResult has no input args, only dest
        }
        InsnType::NewArray { size, .. } => count_arg(size),
        InsnType::FilledNewArray { args, .. } => {
            for arg in args {
                count_arg(arg);
            }
        }
        InsnType::FillArrayData { array, .. } => count_arg(array),
        InsnType::ArrayGet { array, index, .. } => {
            count_arg(array);
            count_arg(index);
        }
        InsnType::ArrayPut { array, index, value, .. } => {
            count_arg(array);
            count_arg(index);
            count_arg(value);
        }
        InsnType::ArrayLength { array, .. } => count_arg(array),
        InsnType::InstanceGet { object, .. } => count_arg(object),
        InsnType::InstancePut { object, value, .. } => {
            count_arg(object);
            count_arg(value);
        }
        InsnType::StaticGet { .. } => {}
        InsnType::StaticPut { value, .. } => count_arg(value),
        InsnType::CheckCast { object, .. } => count_arg(object),
        InsnType::InstanceOf { object, .. } => count_arg(object),
        InsnType::MonitorEnter { object } => count_arg(object),
        InsnType::MonitorExit { object } => count_arg(object),
        InsnType::Throw { exception } => count_arg(exception),
        InsnType::PackedSwitch { value, .. } => count_arg(value),
        InsnType::SparseSwitch { value, .. } => count_arg(value),
        _ => {} // Nop, Goto, Return without value, NewInstance, Break, Continue, Phi
    }
}

#[cfg(test)]
mod tests {
    use super::*;
    use crate::ssa::SsaBlock;
    use dexterity_ir::instructions::RegisterArg;
    use rustc_hash::FxHashMap;

    #[test]
    fn test_array_fusion_basic() {
        // Create a simple test case:
        // v0 = new int[3]
        // fill-array-data v0, [1, 2, 3]

        let new_array = InsnNode::new(
            InsnType::NewArray {
                dest: RegisterArg::with_ssa(0, 0),
                size: InsnArg::Literal(LiteralArg::Int(3)),
                type_idx: 1, // int[]
            },
            0,
        );

        let fill_array = InsnNode::new(
            InsnType::FillArrayData {
                array: InsnArg::Register(RegisterArg::with_ssa(0, 0)),
                payload_offset: 0,
                element_width: 4,
                data: vec![1, 2, 3],
            },
            4,
        );

        let mut ssa = SsaResult {
            blocks: vec![SsaBlock {
                id: 0,
                instructions: vec![new_array, fill_array],
                phi_nodes: vec![],
                successors: vec![],
                predecessors: vec![],
            }],
            dominators: FxHashMap::default(),
            dom_frontiers: FxHashMap::default(),
            max_versions: FxHashMap::default(),
        };

        let result = run_mod_visitor(&mut ssa);

        assert_eq!(result.arrays_fused, 1);
        assert_eq!(ssa.blocks[0].instructions.len(), 1);

        // Verify the fused instruction
        if let InsnType::FilledNewArray { dest, args, .. } = &ssa.blocks[0].instructions[0].insn_type {
            assert!(dest.is_some());
            assert_eq!(args.len(), 3);
            // Verify values
            for (i, arg) in args.iter().enumerate() {
                if let InsnArg::Literal(LiteralArg::Int(val)) = arg {
                    assert_eq!(*val, (i + 1) as i64);
                } else {
                    panic!("Expected literal Int arg");
                }
            }
        } else {
            panic!("Expected FilledNewArray instruction");
        }
    }

    #[test]
    fn test_dead_move_removal() {
        // Create: v0 = v1 (where v0 is never used)
        let dead_move = InsnNode::new(
            InsnType::Move {
                dest: RegisterArg::with_ssa(0, 0),
                src: InsnArg::Register(RegisterArg::with_ssa(1, 0)),
            },
            0,
        );

        let mut ssa = SsaResult {
            blocks: vec![SsaBlock {
                id: 0,
                instructions: vec![dead_move],
                phi_nodes: vec![],
                successors: vec![],
                predecessors: vec![],
            }],
            dominators: FxHashMap::default(),
            dom_frontiers: FxHashMap::default(),
            max_versions: FxHashMap::default(),
        };

        let result = run_mod_visitor(&mut ssa);

        assert_eq!(result.instructions_removed, 1);
        assert!(ssa.blocks[0].instructions.is_empty());
    }

    #[test]
    fn test_no_fusion_when_sizes_mismatch() {
        // new int[5] with fill-array of 3 elements -> no fusion
        let new_array = InsnNode::new(
            InsnType::NewArray {
                dest: RegisterArg::with_ssa(0, 0),
                size: InsnArg::Literal(LiteralArg::Int(5)),
                type_idx: 1,
            },
            0,
        );

        let fill_array = InsnNode::new(
            InsnType::FillArrayData {
                array: InsnArg::Register(RegisterArg::with_ssa(0, 0)),
                payload_offset: 0,
                element_width: 4,
                data: vec![1, 2, 3], // Only 3 elements, but array is size 5
            },
            4,
        );

        let mut ssa = SsaResult {
            blocks: vec![SsaBlock {
                id: 0,
                instructions: vec![new_array, fill_array],
                phi_nodes: vec![],
                successors: vec![],
                predecessors: vec![],
            }],
            dominators: FxHashMap::default(),
            dom_frontiers: FxHashMap::default(),
            max_versions: FxHashMap::default(),
        };

        let result = run_mod_visitor(&mut ssa);

        assert_eq!(result.arrays_fused, 0);
        // Both instructions should remain
        assert_eq!(ssa.blocks[0].instructions.len(), 2);
    }

    #[test]
    fn test_aput_sequence_fusion_basic() {
        use dexterity_ir::instructions::ArrayElemType;

        // Create a test case:
        // v0 = new int[3]
        // v0[0] = 10
        // v0[1] = 20
        // v0[2] = 30

        let new_array = InsnNode::new(
            InsnType::NewArray {
                dest: RegisterArg::with_ssa(0, 0),
                size: InsnArg::Literal(LiteralArg::Int(3)),
                type_idx: 1, // int[]
            },
            0,
        );

        let put0 = InsnNode::new(
            InsnType::ArrayPut {
                array: InsnArg::Register(RegisterArg::with_ssa(0, 0)),
                index: InsnArg::Literal(LiteralArg::Int(0)),
                value: InsnArg::Literal(LiteralArg::Int(10)),
                elem_type: ArrayElemType::Int,
            },
            4,
        );

        let put1 = InsnNode::new(
            InsnType::ArrayPut {
                array: InsnArg::Register(RegisterArg::with_ssa(0, 0)),
                index: InsnArg::Literal(LiteralArg::Int(1)),
                value: InsnArg::Literal(LiteralArg::Int(20)),
                elem_type: ArrayElemType::Int,
            },
            8,
        );

        let put2 = InsnNode::new(
            InsnType::ArrayPut {
                array: InsnArg::Register(RegisterArg::with_ssa(0, 0)),
                index: InsnArg::Literal(LiteralArg::Int(2)),
                value: InsnArg::Literal(LiteralArg::Int(30)),
                elem_type: ArrayElemType::Int,
            },
            12,
        );

        let mut ssa = SsaResult {
            blocks: vec![SsaBlock {
                id: 0,
                instructions: vec![new_array, put0, put1, put2],
                phi_nodes: vec![],
                successors: vec![],
                predecessors: vec![],
            }],
            dominators: FxHashMap::default(),
            dom_frontiers: FxHashMap::default(),
            max_versions: FxHashMap::default(),
        };

        let result = run_mod_visitor(&mut ssa);

        assert_eq!(result.aput_arrays_fused, 1);
        // Should have 1 FilledNewArray (replaces last APUT) + 3 Nops (removed by next phase)
        // After NOP removal, only FilledNewArray remains
        assert_eq!(ssa.blocks[0].instructions.len(), 1);

        // Verify the fused instruction
        if let InsnType::FilledNewArray { dest, args, .. } = &ssa.blocks[0].instructions[0].insn_type {
            assert!(dest.is_some());
            assert_eq!(args.len(), 3);
            // Verify values: 10, 20, 30
            if let InsnArg::Literal(LiteralArg::Int(val)) = &args[0] {
                assert_eq!(*val, 10);
            } else {
                panic!("Expected literal Int arg for index 0");
            }
            if let InsnArg::Literal(LiteralArg::Int(val)) = &args[1] {
                assert_eq!(*val, 20);
            } else {
                panic!("Expected literal Int arg for index 1");
            }
            if let InsnArg::Literal(LiteralArg::Int(val)) = &args[2] {
                assert_eq!(*val, 30);
            } else {
                panic!("Expected literal Int arg for index 2");
            }
        } else {
            panic!("Expected FilledNewArray instruction, got {:?}", ssa.blocks[0].instructions[0].insn_type);
        }
    }

    #[test]
    fn test_aput_sequence_with_gaps() {
        use dexterity_ir::instructions::ArrayElemType;

        // Create a test case with missing index 1:
        // v0 = new int[3]
        // v0[0] = 10
        // v0[2] = 30
        // Missing index 1 should be filled with 0

        let new_array = InsnNode::new(
            InsnType::NewArray {
                dest: RegisterArg::with_ssa(0, 0),
                size: InsnArg::Literal(LiteralArg::Int(3)),
                type_idx: 1,
            },
            0,
        );

        let put0 = InsnNode::new(
            InsnType::ArrayPut {
                array: InsnArg::Register(RegisterArg::with_ssa(0, 0)),
                index: InsnArg::Literal(LiteralArg::Int(0)),
                value: InsnArg::Literal(LiteralArg::Int(10)),
                elem_type: ArrayElemType::Int,
            },
            4,
        );

        let put2 = InsnNode::new(
            InsnType::ArrayPut {
                array: InsnArg::Register(RegisterArg::with_ssa(0, 0)),
                index: InsnArg::Literal(LiteralArg::Int(2)),
                value: InsnArg::Literal(LiteralArg::Int(30)),
                elem_type: ArrayElemType::Int,
            },
            8,
        );

        let mut ssa = SsaResult {
            blocks: vec![SsaBlock {
                id: 0,
                instructions: vec![new_array, put0, put2],
                phi_nodes: vec![],
                successors: vec![],
                predecessors: vec![],
            }],
            dominators: FxHashMap::default(),
            dom_frontiers: FxHashMap::default(),
            max_versions: FxHashMap::default(),
        };

        let result = run_mod_visitor(&mut ssa);

        // 2 out of 3 elements = 66%, which is >= 50% so should fuse
        assert_eq!(result.aput_arrays_fused, 1);
        assert_eq!(ssa.blocks[0].instructions.len(), 1);

        // Verify the gap is filled with 0
        if let InsnType::FilledNewArray { args, .. } = &ssa.blocks[0].instructions[0].insn_type {
            assert_eq!(args.len(), 3);
            // Index 1 should be 0 (gap fill)
            if let InsnArg::Literal(LiteralArg::Int(val)) = &args[1] {
                assert_eq!(*val, 0);
            } else {
                panic!("Expected literal Int arg for gap at index 1");
            }
        } else {
            panic!("Expected FilledNewArray instruction");
        }
    }

    #[test]
    fn test_aput_no_fusion_too_few_puts() {
        use dexterity_ir::instructions::ArrayElemType;

        // Create a test case with only 1 put for size 3 array (33% < 50%)
        let new_array = InsnNode::new(
            InsnType::NewArray {
                dest: RegisterArg::with_ssa(0, 0),
                size: InsnArg::Literal(LiteralArg::Int(3)),
                type_idx: 1,
            },
            0,
        );

        let put0 = InsnNode::new(
            InsnType::ArrayPut {
                array: InsnArg::Register(RegisterArg::with_ssa(0, 0)),
                index: InsnArg::Literal(LiteralArg::Int(0)),
                value: InsnArg::Literal(LiteralArg::Int(10)),
                elem_type: ArrayElemType::Int,
            },
            4,
        );

        let mut ssa = SsaResult {
            blocks: vec![SsaBlock {
                id: 0,
                instructions: vec![new_array, put0],
                phi_nodes: vec![],
                successors: vec![],
                predecessors: vec![],
            }],
            dominators: FxHashMap::default(),
            dom_frontiers: FxHashMap::default(),
            max_versions: FxHashMap::default(),
        };

        let result = run_mod_visitor(&mut ssa);

        // Only 1 out of 3 = 33%, which is < 50% threshold
        assert_eq!(result.aput_arrays_fused, 0);
        // Both instructions should remain
        assert_eq!(ssa.blocks[0].instructions.len(), 2);
    }
}
