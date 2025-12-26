//! Replace New Array Pass
//!
//! JADX Clone: jadx-core/src/main/java/jadx/core/dex/visitors/ReplaceNewArray.java
//! Original Author: Skylot (skylot@gmail.com)
//! Clone Date: Dec 2025
//!
//! Transforms sequential array initialization patterns into array literals.
//!
//! Before:
//! ```java
//! int[] arr = new int[3];
//! arr[0] = 1;
//! arr[1] = 2;
//! arr[2] = 3;
//! ```
//!
//! After:
//! ```java
//! int[] arr = {1, 2, 3};
//! ```

use std::collections::{BTreeMap, HashSet};

use dexterity_ir::instructions::InsnType;
use dexterity_ir::types::ArgType;

/// Result of replace new array pass
#[derive(Debug, Default)]
pub struct ReplaceNewArrayResult {
    /// Number of arrays replaced with filled array literals
    pub arrays_replaced: usize,
    /// Number of APUT instructions removed
    pub aputs_removed: usize,
    /// Warnings encountered during processing
    pub warnings: Vec<String>,
}

/// Information about an array put instruction
#[derive(Debug, Clone)]
struct ArrayPutInfo {
    /// Offset of the APUT instruction
    insn_offset: u32,
    /// Index being written to
    index: i64,
    /// Value being written (instruction offset or literal)
    value: ArrayValue,
}

/// Value being stored in array
#[derive(Debug, Clone)]
enum ArrayValue {
    /// Literal value
    Literal(i64),
    /// Value from another instruction
    InsnRef(u32),
    /// Register reference
    Register { reg: u16, version: u32 },
}

/// Information about a new-array instruction and its associated puts
struct NewArrayInfo {
    /// Offset of the NEW_ARRAY instruction
    new_array_offset: u32,
    /// Block containing the new array
    block_id: u32,
    /// Result register
    result_reg: u16,
    /// SSA version of result
    result_version: u32,
    /// Array length
    length: usize,
    /// Element type
    elem_type: ArgType,
    /// Array dimension
    array_dim: usize,
    /// Sorted puts by index
    puts: BTreeMap<i64, ArrayPutInfo>,
}

/// Process new array patterns in a method.
///
/// JADX Reference: ReplaceNewArray.java:41-67
pub fn process_replace_new_array<F, G, H, I, J>(
    block_instructions: &[(u32, Vec<u32>)], // (block_id, instruction offsets)
    get_insn_type: F,
    get_const_value: G,
    get_ssa_uses: H,
    get_insn_arg: I,
    get_array_type: J,
) -> ReplaceNewArrayResult
where
    F: Fn(u32) -> Option<InsnType> + Copy,
    G: Fn(u32, usize) -> Option<i64> + Copy,         // (insn_offset, arg_idx) -> literal value
    H: Fn(u16, u32) -> Vec<(u32, u16)> + Copy,       // (reg, version) -> uses
    I: Fn(u32, usize) -> Option<(u16, u32)> + Copy,  // (insn_offset, arg_idx) -> (reg, version)
    J: Fn(u32) -> Option<(ArgType, usize)> + Copy,   // insn_offset -> (elem_type, dimension)
{
    let mut result = ReplaceNewArrayResult::default();
    let mut iteration = 0;
    let max_iterations = dexterity_limits::regions::REPLACE_ARRAY_MAX_ITERATIONS;

    loop {
        let mut changed = false;

        for (block_id, insn_offsets) in block_instructions {
            for &insn_offset in insn_offsets {
                if let Some(InsnType::NewArray { .. }) = get_insn_type(insn_offset) {
                    if let Some((replaced, aputs)) = process_new_array(
                        *block_id,
                        insn_offset,
                        insn_offsets,
                        get_insn_type,
                        get_const_value,
                        get_ssa_uses,
                        get_insn_arg,
                        get_array_type,
                    ) {
                        if replaced {
                            result.arrays_replaced += 1;
                            result.aputs_removed += aputs;
                            changed = true;
                        }
                    }
                }
            }
        }

        if !changed {
            break;
        }

        iteration += 1;
        if iteration > max_iterations {
            tracing::error!(
                iteration = iteration,
                limit = max_iterations,
                "LIMIT_EXCEEDED: Replace new array max iterations reached"
            );
            result.warnings.push(format!(
                "Reached limit for ReplaceNewArray iterations ({})",
                max_iterations
            ));
            break;
        }
    }

    result
}

/// Process a single NEW_ARRAY instruction.
/// Returns (replaced: bool, aputs_removed: usize).
///
/// JADX Reference: ReplaceNewArray.java:77-182
fn process_new_array<F, G, H, I, J>(
    block_id: u32,
    new_array_offset: u32,
    block_insns: &[u32],
    get_insn_type: F,
    get_const_value: G,
    get_ssa_uses: H,
    get_insn_arg: I,
    get_array_type: J,
) -> Option<(bool, usize)>
where
    F: Fn(u32) -> Option<InsnType> + Copy,
    G: Fn(u32, usize) -> Option<i64> + Copy,
    H: Fn(u16, u32) -> Vec<(u32, u16)> + Copy,
    I: Fn(u32, usize) -> Option<(u16, u32)> + Copy,
    J: Fn(u32) -> Option<(ArgType, usize)> + Copy,
{
    // Step 1: Get array length from const argument
    // JADX Reference: ReplaceNewArray.java:79-83
    let len = get_const_value(new_array_offset, 0)?;
    if len <= 0 {
        return None;
    }
    let len = len as usize;

    // Step 2: Get element type and check if primitive 1D array
    // JADX Reference: ReplaceNewArray.java:87-90
    let (elem_type, array_dim) = get_array_type(new_array_offset)?;
    let allow_missing_keys = array_dim == 1 && elem_type.is_primitive();
    let min_len = if allow_missing_keys { len / 2 } else { len };

    // Step 3: Get result register and its uses
    // JADX Reference: ReplaceNewArray.java:92-96
    // This would need to get the result register from the instruction
    // For now, we'll use a placeholder approach

    // Step 4: Check for APUT uses
    // JADX Reference: ReplaceNewArray.java:98-108

    // Step 5: Collect puts sorted by index
    // JADX Reference: ReplaceNewArray.java:109-135
    let mut arr_puts: BTreeMap<i64, ArrayPutInfo> = BTreeMap::new();

    // This is a simplified placeholder - full implementation would:
    // 1. Get result register from NEW_ARRAY instruction
    // 2. Find all uses via SSA
    // 3. Filter for APUT instructions
    // 4. Collect indices and values

    // Step 6: Verify puts are all in same block
    // JADX Reference: ReplaceNewArray.java:139-141
    // verify_put_insns(...)

    // Step 7: Build filled array instruction
    // JADX Reference: ReplaceNewArray.java:143-181

    // For now, return None as this needs full instruction access
    None
}

/// Verify all put instructions are valid for replacement.
///
/// JADX Reference: ReplaceNewArray.java:184-204
fn verify_put_insns(
    arr_reg: u16,
    arr_version: u32,
    block_insns: &HashSet<u32>,
    arr_puts: &BTreeMap<i64, ArrayPutInfo>,
    get_insn_arg: impl Fn(u32, usize) -> Option<(u16, u32)>,
) -> bool {
    // All puts must be in the same block
    // JADX Reference: ReplaceNewArray.java:187-195
    for put_info in arr_puts.values() {
        if !block_insns.contains(&put_info.insn_offset) {
            return false;
        }
    }

    // Array arg shouldn't be used in put values
    // JADX Reference: ReplaceNewArray.java:196-202
    for put_info in arr_puts.values() {
        // Get the value argument (arg[2] in APUT)
        if let Some((reg, version)) = get_insn_arg(put_info.insn_offset, 2) {
            if reg == arr_reg && version == arr_version {
                return false;
            }
        }
    }

    true
}

/// Build a filled array from the collected puts.
///
/// JADX Reference: ReplaceNewArray.java:143-181
pub fn build_filled_array(
    elem_type: &ArgType,
    length: usize,
    puts: &BTreeMap<i64, ArrayPutInfo>,
) -> FilledArrayData {
    let mut values = Vec::with_capacity(length);
    let mut prev_index: i64 = -1;

    for (&index, put_info) in puts {
        // Fill missing indices with zeros
        // JADX Reference: ReplaceNewArray.java:153-158
        for _ in (prev_index + 1)..index {
            values.push(ArrayValue::Literal(0));
        }

        values.push(put_info.value.clone());
        prev_index = index;
    }

    // Add trailing zeros
    // JADX Reference: ReplaceNewArray.java:165-167
    for _ in (prev_index + 1) as usize..length {
        values.push(ArrayValue::Literal(0));
    }

    FilledArrayData {
        elem_type: elem_type.clone(),
        values,
    }
}

/// Data for a filled array literal
#[derive(Debug, Clone)]
pub struct FilledArrayData {
    /// Element type
    pub elem_type: ArgType,
    /// Array values
    pub values: Vec<ArrayValue>,
}

/// Replace a const literal with a field reference if available.
///
/// JADX Reference: ReplaceNewArray.java:206-217
pub fn replace_const_in_arg<F>(
    value: i64,
    _elem_type: &ArgType,
    find_const_field: F,
) -> ArrayValue
where
    F: Fn(i64) -> Option<(String, String)>, // literal -> (class_name, field_name)
{
    if let Some((class_name, field_name)) = find_const_field(value) {
        ArrayValue::InsnRef(0) // Would be replaced with actual SGET instruction
    } else {
        ArrayValue::Literal(value)
    }
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn test_filled_array_data() {
        let mut puts = BTreeMap::new();
        puts.insert(0, ArrayPutInfo {
            insn_offset: 100,
            index: 0,
            value: ArrayValue::Literal(1),
        });
        puts.insert(1, ArrayPutInfo {
            insn_offset: 104,
            index: 1,
            value: ArrayValue::Literal(2),
        });
        puts.insert(2, ArrayPutInfo {
            insn_offset: 108,
            index: 2,
            value: ArrayValue::Literal(3),
        });

        let filled = build_filled_array(&ArgType::Int, 3, &puts);
        assert_eq!(filled.values.len(), 3);
    }

    #[test]
    fn test_filled_array_with_gaps() {
        let mut puts = BTreeMap::new();
        puts.insert(0, ArrayPutInfo {
            insn_offset: 100,
            index: 0,
            value: ArrayValue::Literal(1),
        });
        puts.insert(2, ArrayPutInfo {
            insn_offset: 108,
            index: 2,
            value: ArrayValue::Literal(3),
        });

        let filled = build_filled_array(&ArgType::Int, 4, &puts);
        assert_eq!(filled.values.len(), 4);

        // Check that gaps are filled with zeros
        match &filled.values[1] {
            ArrayValue::Literal(0) => {}
            _ => panic!("Expected zero at index 1"),
        }
        match &filled.values[3] {
            ArrayValue::Literal(0) => {}
            _ => panic!("Expected zero at index 3"),
        }
    }

    #[test]
    fn test_result_default() {
        let result = ReplaceNewArrayResult::default();
        assert_eq!(result.arrays_replaced, 0);
        assert_eq!(result.aputs_removed, 0);
        assert!(result.warnings.is_empty());
    }
}
