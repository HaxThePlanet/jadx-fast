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
                            // Try to collect the use chain (JADX algorithm)
                            if let Some((concat_args, dead_insns)) = collect_use_chain(
                                ssa,
                                recv_reg,
                                &def_map,
                                &use_map,
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

/// Clone of JADX SimplifyVisitor.collectUseChain()
/// Reference: jadx-fast/jadx-core/src/main/java/jadx/core/dex/visitors/SimplifyVisitor.java:325-367
///
/// JADX Algorithm:
/// 1. Get the SSA variable of the StringBuilder receiver
/// 2. Find ALL uses of that variable (append calls)
/// 3. Verify all are in same block and sequential
/// 4. Collect args from constructor + all append calls
///
/// Returns (concat_args, instructions_to_remove) or None if not a valid chain
fn collect_use_chain(
    ssa: &SsaResult,
    receiver_reg: &RegisterArg,
    def_map: &HashMap<(u16, u32), (usize, usize)>,
    use_map: &HashMap<(u16, u32), Vec<(usize, usize)>>,
    method_resolver: MethodResolver,
) -> Option<(Vec<InsnArg>, HashSet<(usize, usize)>)> {
    let debug_sb = std::env::var("DEXTERITY_DEBUG_SB").is_ok();
    let key = (receiver_reg.reg_num, receiver_reg.ssa_version);

    // Find uses of this SSA variable
    let uses = use_map.get(&key)?;
    if debug_sb {
        eprintln!("[SB CHAIN] Receiver r{}v{} has {} uses", receiver_reg.reg_num, receiver_reg.ssa_version, uses.len());
    }

    // Find the defining instruction (should be new-instance or constructor)
    let (def_block, def_idx) = def_map.get(&key)?;
    if debug_sb {
        eprintln!("[SB CHAIN] Definition at block {} insn {}", def_block, def_idx);
    }

    // Collect the chain: definition + all uses
    // All instructions must be in the same block (JADX requirement)
    let chain_block = *def_block;
    let mut chain: Vec<(usize, &InsnNode)> = Vec::new();

    // Add definition
    let def_insn = &ssa.blocks[*def_block].instructions[*def_idx];
    chain.push((*def_idx, def_insn));

    // Add all uses (including toString() at the end)
    for (use_block, use_idx) in uses {
        if *use_block != chain_block {
            if debug_sb {
                eprintln!("[SB CHAIN] Use at different block: {} vs {}", use_block, chain_block);
            }
            return None; // All must be in same block
        }
        let use_insn = &ssa.blocks[*use_block].instructions[*use_idx];
        chain.push((*use_idx, use_insn));
    }

    // Sort by instruction index for sequential order
    chain.sort_by_key(|(idx, _)| *idx);

    if debug_sb {
        eprintln!("[SB CHAIN] Chain has {} instructions", chain.len());
    }

    // Verify sequential (optional - JADX checks this but we can be lenient)
    // Extract arguments from the chain
    let mut concat_args: Vec<InsnArg> = Vec::new();
    let mut dead_insns: HashSet<(usize, usize)> = HashSet::new();

    for (idx, insn) in &chain {
        match &insn.insn_type {
            // Constructor - may have initial string arg
            InsnType::Invoke { method_idx, args, kind, .. } if !matches!(kind, InvokeKind::Static) => {
                if let Some(method_info) = method_resolver(*method_idx) {
                    if is_stringbuilder_class(&method_info.class_name) {
                        if method_info.method_name == "<init>" {
                            // Constructor - extract initial arg if present
                            if args.len() >= 2 {
                                concat_args.push(args[1].clone());
                            }
                            dead_insns.insert((chain_block, *idx));
                            if debug_sb {
                                eprintln!("[SB CHAIN] Found <init> with {} args", args.len());
                            }
                        } else if method_info.method_name == "append" {
                            // Append call - extract argument
                            if args.len() >= 2 {
                                concat_args.push(args[1].clone());
                                dead_insns.insert((chain_block, *idx));
                                if debug_sb {
                                    eprintln!("[SB CHAIN] Found append");
                                }
                            } else {
                                return None;
                            }
                        } else if method_info.method_name == "toString" {
                            // toString() - this is the end, don't add to dead_insns (we replace it)
                            if debug_sb {
                                eprintln!("[SB CHAIN] Found toString at end");
                            }
                        } else {
                            // Other method - invalidates chain
                            if debug_sb {
                                eprintln!("[SB CHAIN] Invalid method: {}", method_info.method_name);
                            }
                            return None;
                        }
                    }
                }
            }

            // NewInstance - mark for removal
            InsnType::NewInstance { .. } => {
                dead_insns.insert((chain_block, *idx));
                if debug_sb {
                    eprintln!("[SB CHAIN] Found NewInstance");
                }
            }

            // Constructor instruction type
            InsnType::Constructor { args, .. } => {
                if args.len() >= 2 {
                    concat_args.push(args[1].clone());
                }
                dead_insns.insert((chain_block, *idx));
                if debug_sb {
                    eprintln!("[SB CHAIN] Found Constructor");
                }
            }

            _ => {
                // Unknown instruction in chain
                if debug_sb {
                    eprintln!("[SB CHAIN] Unknown insn type in chain");
                }
            }
        }
    }

    if concat_args.is_empty() {
        if debug_sb {
            eprintln!("[SB CHAIN] No args collected");
        }
        return None;
    }

    if debug_sb {
        eprintln!("[SB CHAIN] Success! {} args, {} dead insns", concat_args.len(), dead_insns.len());
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
