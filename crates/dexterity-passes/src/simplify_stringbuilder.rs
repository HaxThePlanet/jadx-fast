//! StringBuilder chain to STR_CONCAT conversion pass
//!
//! Clone of JADX SimplifyVisitor.convertStringBuilderChain()
//! Reference: jadx-fast/jadx-core/src/main/java/jadx/core/dex/visitors/SimplifyVisitor.java:301-428
//!
//! This pass converts StringBuilder chains like:
//!   `new StringBuilder("a").append(b).append("c").toString()`
//! into clean string concatenation:
//!   `"a" + b + "c"`
//!
//! The pass works by:
//! 1. Finding calls to StringBuilder.toString()
//! 2. Tracing back through the SSA graph to find the constructor and append() chain
//! 3. Collecting all arguments from the chain
//! 4. Replacing with a single StrConcat instruction
//! 5. Marking original instructions as dead

use std::collections::{HashMap, HashSet};
use dexterity_ir::attributes::AFlag;
use dexterity_ir::instructions::{InsnArg, InsnNode, InsnType, InvokeKind, RegisterArg};
use crate::ssa::SsaResult;

/// Result of StringBuilder chain simplification
#[derive(Debug, Default)]
pub struct SimplifyStringBuilderResult {
    /// Number of StringBuilder chains converted to STR_CONCAT
    pub chains_converted: usize,
    /// Number of instructions marked as dead
    pub insns_removed: usize,
}

/// Method info for StringBuilder detection
#[derive(Debug, Clone)]
pub struct MethodInfo {
    pub class_name: String,
    pub method_name: String,
}

/// Type alias for method resolver function
/// Takes method_idx and returns Option<MethodInfo>
pub type MethodResolver<'a> = &'a dyn Fn(u32) -> Option<MethodInfo>;

/// Convert StringBuilder chains to STR_CONCAT instructions
///
/// Clone of JADX SimplifyVisitor.convertStringBuilderChain()
/// Reference: jadx-fast/jadx-core/src/main/java/jadx/core/dex/visitors/SimplifyVisitor.java:301-428
///
/// # Arguments
/// * `ssa` - SSA result to modify
/// * `method_resolver` - Function to resolve method_idx to MethodInfo
///
/// # Returns
/// * `SimplifyStringBuilderResult` with conversion statistics
pub fn simplify_stringbuilder_chains(
    ssa: &mut SsaResult,
    method_resolver: MethodResolver,
) -> SimplifyStringBuilderResult {
    let mut result = SimplifyStringBuilderResult::default();
    let debug_sb = std::env::var("DEXTERITY_DEBUG_SB").is_ok();

    // Phase 1: Build maps
    // def_map: (reg_num, ssa_version) -> (block_idx, insn_idx) - which instruction defines each SSA var
    // use_map: (reg_num, ssa_version) -> Vec<(block_idx, insn_idx)> - which instructions USE each SSA var
    let mut def_map: HashMap<(u16, u32), (usize, usize)> = HashMap::new();
    let mut use_map: HashMap<(u16, u32), Vec<(usize, usize)>> = HashMap::new();

    for (block_idx, block) in ssa.blocks.iter().enumerate() {
        for (insn_idx, insn) in block.instructions.iter().enumerate() {
            // Record definitions
            if let Some(dest) = insn.insn_type.get_dest() {
                def_map.insert((dest.reg_num, dest.ssa_version), (block_idx, insn_idx));
            }

            // Record uses - collect all register arguments
            for arg in insn.insn_type.get_args_vec() {
                if let InsnArg::Register(reg) = arg {
                    use_map.entry((reg.reg_num, reg.ssa_version))
                        .or_insert_with(Vec::new)
                        .push((block_idx, insn_idx));
                }
            }
        }
    }

    if debug_sb {
        eprintln!("[SB DEBUG] Built maps: {} defs, {} use entries", def_map.len(), use_map.len());
    }

    // Phase 2: Find StringBuilder.toString() calls and collect use chains
    // Clone of JADX SimplifyVisitor.convertInvoke() + collectUseChain()
    let mut replacements: Vec<(usize, usize, InsnNode, HashSet<(usize, usize)>)> = Vec::new();

    for (block_idx, block) in ssa.blocks.iter().enumerate() {
        for (insn_idx, insn) in block.instructions.iter().enumerate() {
            // Skip instructions already marked for removal
            if insn.has_flag(AFlag::DontGenerate) {
                continue;
            }

            // Look for Invoke instructions
            if let InsnType::Invoke { method_idx, args, dest,  .. } = &insn.insn_type {
                // Resolve method to check if it's StringBuilder.toString()
                if let Some(method_info) = method_resolver(*method_idx) {
                    // Debug: log StringBuilder-related calls
                    if debug_sb && (method_info.class_name.contains("StringBuilder") || method_info.class_name.contains("StringBuffer")) {
                        eprintln!("[SB DEBUG] Found call: class='{}' method='{}' idx={}",
                            method_info.class_name, method_info.method_name, method_idx);
                    }
                    if is_stringbuilder_class(&method_info.class_name)
                        && method_info.method_name == "toString"
                    {
                        if debug_sb {
                            eprintln!("[SB DEBUG] Found toString() at block {} insn {}", block_idx, insn_idx);
                        }
                        // Get the receiver (first arg for instance methods)
                        if let Some(InsnArg::Register(recv_reg)) = args.first() {
                            if debug_sb {
                                eprintln!("[SB DEBUG] Receiver reg: r{}v{}", recv_reg.reg_num, recv_reg.ssa_version);
                            }
                            // Try to collect the chain by tracing backwards through SSA defs
                            if let Some((concat_args, dead_insns)) = collect_chain_backwards(
                                ssa,
                                recv_reg,
                                &def_map,
                                method_resolver,
                            ) {
                                if debug_sb {
                                    eprintln!("[SB DEBUG] Chain found with {} args, {} dead insns", concat_args.len(), dead_insns.len());
                                }
                                // We have a valid chain - create replacement
                                if !concat_args.is_empty() {
                                    // Create StrConcat instruction with same dest
                                    let new_dest = dest.clone().unwrap_or_else(|| {
                                        RegisterArg::with_ssa(recv_reg.reg_num, recv_reg.ssa_version + 1000)
                                    });

                                    let str_concat = InsnNode::new(
                                        InsnType::StrConcat {
                                            dest: new_dest,
                                            args: concat_args,
                                        },
                                        insn.offset,
                                    );

                                    replacements.push((block_idx, insn_idx, str_concat, dead_insns));
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    // Phase 3: Apply replacements
    for (block_idx, insn_idx, replacement, dead_insns) in replacements {
        // Replace the toString() call with StrConcat
        ssa.blocks[block_idx].instructions[insn_idx] = replacement;
        result.chains_converted += 1;

        // Mark chain instructions as dead
        for (dead_block, dead_idx) in dead_insns {
            if dead_block < ssa.blocks.len() && dead_idx < ssa.blocks[dead_block].instructions.len() {
                ssa.blocks[dead_block].instructions[dead_idx].add_flag(AFlag::DontGenerate);
                result.insns_removed += 1;
            }
        }
    }

    result
}

/// Check if a class name is StringBuilder or StringBuffer
/// Clone of JADX Consts check
fn is_stringbuilder_class(class_name: &str) -> bool {
    class_name == "java/lang/StringBuilder"
        || class_name == "java.lang.StringBuilder"
        || class_name == "StringBuilder"  // Short name variant
        || class_name == "java/lang/StringBuffer"
        || class_name == "java.lang.StringBuffer"
        || class_name == "StringBuffer"  // Short name variant
        || class_name.ends_with("/StringBuilder")
        || class_name.ends_with("/StringBuffer")
}

/// Collect StringBuilder chain by tracing BACKWARDS through SSA definitions
///
/// This is the correct algorithm for Kotlin-compiled code where each append()
/// creates a NEW SSA version:
///   r0_v1 = new StringBuilder()
///   r0_v2 = r0_v1.<init>("SMS Count: ")
///   r0_v3 = r0_v2.append(count)
///   r0_v4 = r0_v3.toString()
///
/// We start at the toString() receiver (r0_v3) and trace backwards:
///   r0_v3 -> defined by append(r0_v2, count) -> collect 'count'
///   r0_v2 -> defined by <init>(r0_v1, "SMS Count: ") -> collect "SMS Count: "
///   r0_v1 -> defined by NewInstance -> end of chain
///
/// Returns (concat_args, instructions_to_remove) or None if not a valid chain
#[allow(dead_code)]
fn collect_use_chain(
    _ssa: &SsaResult,
    _receiver_reg: &RegisterArg,
    _def_map: &HashMap<(u16, u32), (usize, usize)>,
    _use_map: &HashMap<(u16, u32), Vec<(usize, usize)>>,
    _method_resolver: MethodResolver,
) -> Option<(Vec<InsnArg>, HashSet<(usize, usize)>)> {
    // Old forward-tracing algorithm - replaced by collect_chain_backwards
    None
}

/// Collect StringBuilder chain by tracing BACKWARDS through SSA definitions
fn collect_chain_backwards(
    ssa: &SsaResult,
    receiver_reg: &RegisterArg,
    def_map: &HashMap<(u16, u32), (usize, usize)>,
    method_resolver: MethodResolver,
) -> Option<(Vec<InsnArg>, HashSet<(usize, usize)>)> {
    let debug_sb = std::env::var("DEXTERITY_DEBUG_SB").is_ok();

    let mut concat_args: Vec<InsnArg> = Vec::new();
    let mut dead_insns: HashSet<(usize, usize)> = HashSet::new();
    let mut current_reg = receiver_reg.clone();
    let mut chain_block: Option<usize> = None;
    let mut iteration = 0;
    const MAX_ITERATIONS: usize = 100; // Prevent infinite loops

    if debug_sb {
        eprintln!("[SB BACK] Starting backwards trace from r{}v{}",
            receiver_reg.reg_num, receiver_reg.ssa_version);
    }

    // Trace backwards from toString() receiver
    loop {
        iteration += 1;
        if iteration > MAX_ITERATIONS {
            if debug_sb {
                eprintln!("[SB BACK] Max iterations exceeded");
            }
            return None;
        }

        let key = (current_reg.reg_num, current_reg.ssa_version);
        let (def_block, def_idx) = match def_map.get(&key) {
            Some(loc) => loc,
            None => {
                if debug_sb {
                    eprintln!("[SB BACK] No definition found for r{}v{}",
                        current_reg.reg_num, current_reg.ssa_version);
                }
                return None;
            }
        };

        // All must be in same block
        if let Some(expected_block) = chain_block {
            if *def_block != expected_block {
                if debug_sb {
                    eprintln!("[SB BACK] Cross-block chain: {} vs {}", def_block, expected_block);
                }
                return None;
            }
        }
        chain_block = Some(*def_block);

        let insn = &ssa.blocks[*def_block].instructions[*def_idx];

        if debug_sb {
            eprintln!("[SB BACK] Iteration {}: r{}v{} defined at block {} insn {} -> {:?}",
                iteration, current_reg.reg_num, current_reg.ssa_version,
                def_block, def_idx, std::mem::discriminant(&insn.insn_type));
        }

        match &insn.insn_type {
            InsnType::Invoke { method_idx, args, .. } => {
                let method_info = match method_resolver(*method_idx) {
                    Some(info) => info,
                    None => {
                        if debug_sb {
                            eprintln!("[SB BACK] Could not resolve method {}", method_idx);
                        }
                        return None;
                    }
                };

                if !is_stringbuilder_class(&method_info.class_name) {
                    if debug_sb {
                        eprintln!("[SB BACK] Not StringBuilder class: {}", method_info.class_name);
                    }
                    return None;
                }

                match method_info.method_name.as_str() {
                    "append" => {
                        // Extract appended arg (args[1]), continue with receiver (args[0])
                        if args.len() >= 2 {
                            concat_args.push(args[1].clone());
                            dead_insns.insert((*def_block, *def_idx));
                            if debug_sb {
                                eprintln!("[SB BACK] Found append, collected arg");
                            }
                            // Follow the receiver backwards
                            if let InsnArg::Register(recv) = &args[0] {
                                current_reg = recv.clone();
                            } else {
                                if debug_sb {
                                    eprintln!("[SB BACK] append receiver not a register");
                                }
                                return None;
                            }
                        } else {
                            if debug_sb {
                                eprintln!("[SB BACK] append has < 2 args");
                            }
                            return None;
                        }
                    }
                    "<init>" => {
                        // Constructor - may have initial string arg
                        if args.len() >= 2 {
                            concat_args.push(args[1].clone());
                            if debug_sb {
                                eprintln!("[SB BACK] Found <init> with initial arg");
                            }
                        } else if debug_sb {
                            eprintln!("[SB BACK] Found <init> without initial arg");
                        }
                        dead_insns.insert((*def_block, *def_idx));
                        // Find the NewInstance that created this
                        if let Some(InsnArg::Register(recv)) = args.first() {
                            current_reg = recv.clone();
                            // Continue to find NewInstance
                        } else {
                            // End of chain (no receiver means standalone constructor?)
                            break;
                        }
                    }
                    _ => {
                        // Other method (e.g., delete, reverse) - invalidates chain
                        if debug_sb {
                            eprintln!("[SB BACK] Invalid method: {}", method_info.method_name);
                        }
                        return None;
                    }
                }
            }

            InsnType::NewInstance { .. } => {
                // Found the start - we're done
                dead_insns.insert((*def_block, *def_idx));
                if debug_sb {
                    eprintln!("[SB BACK] Found NewInstance - chain complete!");
                }
                break;
            }

            InsnType::Constructor { args, .. } => {
                // Alternative constructor representation
                if args.len() >= 2 {
                    concat_args.push(args[1].clone());
                }
                dead_insns.insert((*def_block, *def_idx));
                if debug_sb {
                    eprintln!("[SB BACK] Found Constructor insn");
                }
                // Find the NewInstance
                if let Some(InsnArg::Register(recv)) = args.first() {
                    current_reg = recv.clone();
                } else {
                    break;
                }
            }

            _ => {
                // Unknown instruction breaks chain
                if debug_sb {
                    eprintln!("[SB BACK] Unknown insn type in chain: {:?}",
                        std::mem::discriminant(&insn.insn_type));
                }
                return None;
            }
        }
    }

    // Reverse args since we collected backwards (from toString back to constructor)
    concat_args.reverse();

    if concat_args.is_empty() {
        if debug_sb {
            eprintln!("[SB BACK] No args collected");
        }
        return None;
    }

    if debug_sb {
        eprintln!("[SB BACK] Success! {} args, {} dead insns (reversed)",
            concat_args.len(), dead_insns.len());
    }

    Some((concat_args, dead_insns))
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn test_is_stringbuilder_class() {
        assert!(is_stringbuilder_class("java/lang/StringBuilder"));
        assert!(is_stringbuilder_class("java.lang.StringBuilder"));
        assert!(is_stringbuilder_class("StringBuilder"));  // Short name
        assert!(is_stringbuilder_class("java/lang/StringBuffer"));
        assert!(is_stringbuilder_class("StringBuffer"));  // Short name
        assert!(!is_stringbuilder_class("java/lang/String"));
        assert!(!is_stringbuilder_class("java/util/List"));
    }
}
