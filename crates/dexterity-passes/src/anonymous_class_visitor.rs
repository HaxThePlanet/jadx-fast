//! AnonymousClassVisitor - Analyze anonymous class constructors for inlining
//!
//! This pass runs after type inference. It analyzes anonymous class constructors
//! to find which args map to synthetic fields, enabling constructor inlining.
//!
//! Equivalent to JADX's AnonymousClassVisitor.java

use std::collections::{HashMap, HashSet};

use dexterity_ir::{
    attributes::AFlag,
    instructions::{InsnArg, InsnNode, InsnType},
    ClassData, MethodData,
};
use dexterity_ir::ssa::SSAContext;

/// Result of anonymous class visitor processing
#[derive(Debug, Default)]
pub struct AnonymousClassVisitorResult {
    /// Number of constructors processed
    pub constructors_processed: usize,
    /// Number of args mapped to fields
    pub args_mapped: usize,
    /// Number of instructions marked DONT_GENERATE
    pub insns_marked: usize,
    /// Constructors that couldn't be processed (with reason)
    pub skipped: Vec<(String, String)>,
    /// Args to skip when generating constructor call (class_type -> arg indices)
    pub skip_args: HashMap<String, Vec<u32>>,
    /// Field replacement info (class_type -> mappings)
    pub field_mappings: HashMap<String, Vec<ArgToFieldMapping>>,
    /// Instructions to mark as DONT_GENERATE (class_type -> insn indices)
    pub insns_to_hide: HashMap<String, HashSet<usize>>,
}

/// Mapping from arg register to field for anonymous class inlining
#[derive(Debug, Clone)]
pub struct ArgToFieldMapping {
    /// Arg register number
    pub arg_reg: u16,
    /// Arg index (0-based, not counting 'this')
    pub arg_index: usize,
    /// Field name being assigned
    pub field_name: String,
    /// Field index in instance_fields
    pub field_idx: usize,
    /// Instruction index of the IPUT
    pub iput_insn_idx: usize,
}

/// Check if a class is an anonymous class candidate
pub fn is_anonymous_class(class: &ClassData) -> bool {
    let short_name = class.class_type
        .rsplit('/')
        .next()
        .unwrap_or(&class.class_type)
        .trim_end_matches(';')
        .trim_start_matches('L');

    // Check for $N pattern (e.g., Foo$1, Foo$Bar$2)
    if let Some(dollar_pos) = short_name.rfind('$') {
        let suffix = &short_name[dollar_pos + 1..];
        if suffix.chars().next().map(|c| c.is_ascii_digit()).unwrap_or(false) {
            return true;
        }
    }

    // Check for synthetic class with single constructor
    let is_synthetic = class.access_flags & 0x1000 != 0;
    let constructor_count = class.methods.iter()
        .filter(|m| m.name == "<init>")
        .count();

    is_synthetic && constructor_count == 1
}

/// Process an anonymous class for inlining
pub fn process_anonymous_class(
    class: &mut ClassData,
    ssa_info: Option<&SSAContext>,
    outer_class_type: Option<&str>,
) -> AnonymousClassVisitorResult {
    let mut result = AnonymousClassVisitorResult::default();

    // Find the constructor
    let constructor_idx = class.methods.iter().position(|m| m.name == "<init>");

    if let Some(idx) = constructor_idx {
        let class_type = class.class_type.clone();

        // Collect synthetic field info
        let synthetic_fields: HashMap<String, usize> = class.instance_fields.iter()
            .enumerate()
            .filter(|(_, f)| f.access_flags & 0x1000 != 0) // ACC_SYNTHETIC
            .map(|(i, f)| (f.name.clone(), i))
            .collect();

        // Analyze the constructor
        let (mappings, skip_args, insns_to_hide) = analyze_anonymous_constructor(
            &class.methods[idx],
            &synthetic_fields,
            ssa_info,
            outer_class_type,
            &mut result,
        );

        result.constructors_processed += 1;
        result.args_mapped = mappings.len();
        result.insns_marked = insns_to_hide.len();

        // Store results
        if !skip_args.is_empty() {
            result.skip_args.insert(class_type.clone(), skip_args.iter().map(|&x| x as u32).collect());
        }
        if !mappings.is_empty() {
            result.field_mappings.insert(class_type.clone(), mappings);
        }
        if !insns_to_hide.is_empty() {
            result.insns_to_hide.insert(class_type.clone(), insns_to_hide.clone());
        }

        // Mark instructions as DONT_GENERATE
        if let Some(ref mut insns) = class.methods[idx].instructions {
            for &insn_idx in &insns_to_hide {
                if insn_idx < insns.len() {
                    insns[insn_idx].add_flag(AFlag::DontGenerate);
                }
            }
        }
    }

    result
}

/// Analyze an anonymous constructor to find arg-to-field mappings
fn analyze_anonymous_constructor(
    method: &MethodData,
    synthetic_fields: &HashMap<String, usize>,
    ssa_info: Option<&SSAContext>,
    outer_class_type: Option<&str>,
    result: &mut AnonymousClassVisitorResult,
) -> (Vec<ArgToFieldMapping>, Vec<usize>, HashSet<usize>) {
    let mut mappings = Vec::new();
    let mut skip_args = Vec::new();
    let mut insns_to_hide = HashSet::new();

    let instructions = match &method.instructions {
        Some(insns) => insns,
        None => return (mappings, skip_args, insns_to_hide),
    };

    // Determine start arg (skip outer class ref if present)
    let start_arg = if let Some(outer_type) = outer_class_type {
        if method.arg_types.first()
            .map(|t| t.get_object_name().map(|n| n == outer_type).unwrap_or(false))
            .unwrap_or(false)
        {
            1
        } else {
            0
        }
    } else {
        0
    };

    let this_reg = method.regs_count.saturating_sub(method.ins_count);
    let arg_count = method.arg_types.len();

    for arg_idx in start_arg..arg_count {
        let arg_reg = this_reg + 1 + arg_idx as u16;

        let use_insn_idx = if let Some(ssa) = ssa_info {
            find_use_via_ssa(arg_reg, ssa)
        } else {
            find_use_by_scan(arg_reg, instructions)
        };

        let use_insn_idx = match use_insn_idx {
            Some(idx) => idx,
            None => {
                result.skipped.push((method.name.clone(), format!("No use for arg {}", arg_idx)));
                continue;
            }
        };

        let actual_use_idx = skip_move_chain(use_insn_idx, instructions);
        if actual_use_idx >= instructions.len() {
            continue;
        }

        let use_insn = &instructions[actual_use_idx];

        match &use_insn.insn_type {
            InsnType::InstancePut { field_idx, .. } => {
                // Look up field name by index
                if let Some(field_name) = find_field_name_by_idx(*field_idx, synthetic_fields) {
                    if let Some(&field_idx_in_list) = synthetic_fields.get(&field_name) {
                        mappings.push(ArgToFieldMapping {
                            arg_reg,
                            arg_index: arg_idx,
                            field_name,
                            field_idx: field_idx_in_list,
                            iput_insn_idx: actual_use_idx,
                        });
                        skip_args.push(arg_idx);
                        insns_to_hide.insert(actual_use_idx);
                    }
                } else {
                    // Field not synthetic - can't inline
                    result.skipped.push((method.name.clone(), format!("Field not synthetic")));
                    return (vec![], vec![], HashSet::new());
                }
            }
            InsnType::Constructor { .. } => {
                // Constructor call (likely super) - mark for removal
                insns_to_hide.insert(actual_use_idx);
            }
            InsnType::Invoke { .. } => {
                // Could be super() - mark for removal
                insns_to_hide.insert(actual_use_idx);
            }
            _ => {
                result.skipped.push((method.name.clone(), format!("Unexpected insn {:?}", use_insn.insn_type.name())));
                return (vec![], vec![], HashSet::new());
            }
        }
    }

    (mappings, skip_args, insns_to_hide)
}

fn find_use_via_ssa(reg: u16, ssa: &SSAContext) -> Option<usize> {
    for (var_ref, var) in ssa.vars.iter() {
        if var_ref.reg_num == reg {
            if let Some(&use_idx) = var.use_list.first() {
                return Some(use_idx as usize);
            }
        }
    }
    None
}

fn find_use_by_scan(reg: u16, instructions: &[InsnNode]) -> Option<usize> {
    for (idx, insn) in instructions.iter().enumerate() {
        if insn_uses_reg(insn, reg) {
            return Some(idx);
        }
    }
    None
}

fn insn_uses_reg(insn: &InsnNode, reg: u16) -> bool {
    match &insn.insn_type {
        InsnType::Move { src, .. } => {
            if let InsnArg::Register(r) = src {
                r.reg_num == reg
            } else {
                false
            }
        }
        InsnType::InstancePut { object, value, .. } => {
            let obj_match = if let InsnArg::Register(r) = object {
                r.reg_num == reg
            } else {
                false
            };
            let val_match = if let InsnArg::Register(r) = value {
                r.reg_num == reg
            } else {
                false
            };
            obj_match || val_match
        }
        InsnType::Invoke { args, .. } => {
            args.iter().any(|arg| {
                if let InsnArg::Register(r) = arg {
                    r.reg_num == reg
                } else {
                    false
                }
            })
        }
        InsnType::Constructor { args, .. } => {
            args.iter().any(|arg| {
                if let InsnArg::Register(r) = arg {
                    r.reg_num == reg
                } else {
                    false
                }
            })
        }
        _ => false,
    }
}

fn skip_move_chain(start_idx: usize, instructions: &[InsnNode]) -> usize {
    let mut current_idx = start_idx;
    let mut visited = HashSet::new();

    while current_idx < instructions.len() {
        if visited.contains(&current_idx) {
            break;
        }
        visited.insert(current_idx);

        if let InsnType::Move { dest, .. } = &instructions[current_idx].insn_type {
            if let Some(next) = find_next_use(dest.reg_num, current_idx + 1, instructions) {
                current_idx = next;
                continue;
            }
        }
        break;
    }
    current_idx
}

fn find_next_use(reg: u16, start_idx: usize, instructions: &[InsnNode]) -> Option<usize> {
    instructions.iter().enumerate().skip(start_idx)
        .find(|(_, insn)| insn_uses_reg(insn, reg))
        .map(|(idx, _)| idx)
}

fn find_field_name_by_idx(field_idx: u32, synthetic_fields: &HashMap<String, usize>) -> Option<String> {
    // This is a simplification - in practice we'd need to look up the field
    // by its DEX index. For now, we just check if we have any synthetic fields.
    // A full implementation would need access to the DEX string pool.
    synthetic_fields.keys().next().cloned()
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn test_is_anonymous_class() {
        let class = ClassData::new("Lcom/example/Outer$1;".to_string(), 0);
        assert!(is_anonymous_class(&class));

        let class = ClassData::new("Lcom/example/Regular;".to_string(), 0);
        assert!(!is_anonymous_class(&class));
    }
}
