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

    // Phase 1: Build a map of definitions - which instruction defines each SSA variable
    // Maps (reg_num, ssa_version) -> (block_idx, insn_idx)
    let mut def_map: HashMap<(u16, u32), (usize, usize)> = HashMap::new();

    for (block_idx, block) in ssa.blocks.iter().enumerate() {
        for (insn_idx, insn) in block.instructions.iter().enumerate() {
            if let Some(dest) = insn.insn_type.get_dest() {
                def_map.insert((dest.reg_num, dest.ssa_version), (block_idx, insn_idx));
            }
        }
    }

    // Phase 2: Find StringBuilder.toString() calls and trace back to find chains
    // Collect replacements to apply after iteration
    let mut replacements: Vec<(usize, usize, InsnNode, HashSet<(usize, usize)>)> = Vec::new();

    for (block_idx, block) in ssa.blocks.iter().enumerate() {
        for (insn_idx, insn) in block.instructions.iter().enumerate() {
            // Skip instructions already marked for removal
            if insn.has_flag(AFlag::DontGenerate) {
                continue;
            }

            // Look for Invoke instructions
            if let InsnType::Invoke { method_idx, args, dest, kind, .. } = &insn.insn_type {
                // Resolve method to check if it's StringBuilder.toString()
                if let Some(method_info) = method_resolver(*method_idx) {
                    if is_stringbuilder_class(&method_info.class_name)
                        && method_info.method_name == "toString"
                    {
                        // Get the receiver (first arg for instance methods)
                        if let Some(InsnArg::Register(recv_reg)) = args.first() {
                            // Try to trace back the StringBuilder chain
                            if let Some((concat_args, dead_insns)) = trace_stringbuilder_chain(
                                ssa,
                                recv_reg,
                                &def_map,
                                method_resolver,
                            ) {
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
        || class_name == "java/lang/StringBuffer"
        || class_name == "java.lang.StringBuffer"
        || class_name.ends_with("/StringBuilder")
        || class_name.ends_with("/StringBuffer")
}

/// Trace back through SSA to find a StringBuilder chain
///
/// Clone of JADX SimplifyVisitor.flattenInsnChainUntil() + collectUseChain()
/// Reference: jadx-fast/jadx-core/src/main/java/jadx/core/dex/visitors/SimplifyVisitor.java:325-367
///
/// Returns (concat_args, instructions_to_remove) or None if not a valid chain
fn trace_stringbuilder_chain(
    ssa: &SsaResult,
    start_reg: &RegisterArg,
    def_map: &HashMap<(u16, u32), (usize, usize)>,
    method_resolver: MethodResolver,
) -> Option<(Vec<InsnArg>, HashSet<(usize, usize)>)> {
    let mut concat_args: Vec<InsnArg> = Vec::new();
    let mut dead_insns: HashSet<(usize, usize)> = HashSet::new();
    let mut current_reg = start_reg.clone();
    let mut visited: HashSet<(u16, u32)> = HashSet::new();

    // Walk backwards through the chain
    loop {
        // Prevent infinite loops
        if !visited.insert((current_reg.reg_num, current_reg.ssa_version)) {
            return None;
        }

        // Find the instruction that defines this register
        let (block_idx, insn_idx) = def_map.get(&(current_reg.reg_num, current_reg.ssa_version))?;
        let insn = &ssa.blocks[*block_idx].instructions[*insn_idx];

        match &insn.insn_type {
            // append() call - collect the argument
            InsnType::Invoke { method_idx, args, kind, .. } if !matches!(kind, InvokeKind::Static) => {
                let method_info = method_resolver(*method_idx)?;

                if is_stringbuilder_class(&method_info.class_name) {
                    if method_info.method_name == "append" {
                        // Get the append argument (second arg after receiver)
                        if args.len() >= 2 {
                            concat_args.push(args[1].clone());
                            dead_insns.insert((*block_idx, *insn_idx));

                            // Continue with the receiver (first arg)
                            if let Some(InsnArg::Register(recv)) = args.first() {
                                current_reg = recv.clone();
                                continue;
                            }
                        }
                        return None;
                    } else if method_info.method_name == "<init>" {
                        // Constructor - may have initial value
                        if args.len() >= 2 {
                            // Constructor with argument - add it as first concat arg
                            concat_args.push(args[1].clone());
                        }
                        dead_insns.insert((*block_idx, *insn_idx));

                        // We've reached the constructor, reverse args and return
                        concat_args.reverse();
                        return validate_concat_args(concat_args, dead_insns);
                    } else {
                        // Other StringBuilder method - invalidates the chain
                        return None;
                    }
                } else {
                    return None;
                }
            }

            // Constructor instruction - end of chain
            InsnType::Constructor { args, .. } => {
                // Get initial value if present (args[0] is 'this' for constructor)
                if args.len() >= 1 {
                    // Check if the Constructor is for StringBuilder
                    // The first arg after 'this' might be an initial string value
                    if args.len() >= 2 {
                        concat_args.push(args[1].clone());
                    }
                }
                dead_insns.insert((*block_idx, *insn_idx));

                // Constructor reached - reverse and validate
                concat_args.reverse();
                return validate_concat_args(concat_args, dead_insns);
            }

            // NewInstance - the start of the chain
            InsnType::NewInstance { .. } => {
                dead_insns.insert((*block_idx, *insn_idx));
                concat_args.reverse();
                return validate_concat_args(concat_args, dead_insns);
            }

            // Move instruction - follow through
            InsnType::Move { src, .. } => {
                if let InsnArg::Register(src_reg) = src {
                    current_reg = src_reg.clone();
                    continue;
                }
                return None;
            }

            _ => return None,
        }
    }
}

/// Validate that concat args are suitable for string concatenation
/// Clone of JADX SimplifyVisitor.java:397-408 (string arg check)
fn validate_concat_args(
    args: Vec<InsnArg>,
    dead_insns: HashSet<(usize, usize)>,
) -> Option<(Vec<InsnArg>, HashSet<(usize, usize)>)> {
    if args.is_empty() {
        return None;
    }

    // JADX requires at least one String argument to ensure result is a String
    // For now, accept any chain with at least one argument
    // TODO: Type checking for String argument presence

    Some((args, dead_insns))
}

#[cfg(test)]
mod tests {
    use super::*;
    use dexterity_ir::instructions::{InsnNode, InsnType, LiteralArg, RegisterArg, InsnArg, InsnArgs};
    use crate::ssa::{SsaBlock, SsaResult};

    fn make_method_resolver() -> impl Fn(u32) -> Option<MethodInfo> {
        move |method_idx| {
            match method_idx {
                100 => Some(MethodInfo {
                    class_name: "java/lang/StringBuilder".to_string(),
                    method_name: "<init>".to_string(),
                }),
                101 => Some(MethodInfo {
                    class_name: "java/lang/StringBuilder".to_string(),
                    method_name: "append".to_string(),
                }),
                102 => Some(MethodInfo {
                    class_name: "java/lang/StringBuilder".to_string(),
                    method_name: "toString".to_string(),
                }),
                _ => None,
            }
        }
    }

    #[test]
    fn test_is_stringbuilder_class() {
        assert!(is_stringbuilder_class("java/lang/StringBuilder"));
        assert!(is_stringbuilder_class("java.lang.StringBuilder"));
        assert!(is_stringbuilder_class("java/lang/StringBuffer"));
        assert!(!is_stringbuilder_class("java/lang/String"));
        assert!(!is_stringbuilder_class("java/util/List"));
    }

    #[test]
    fn test_simple_chain_detection() {
        // Create a simple StringBuilder chain:
        // v0 = new StringBuilder()
        // v1 = v0.append("hello")
        // v2 = v1.toString()

        let mut ssa = SsaResult {
            blocks: vec![SsaBlock {
                id: 0,
                instructions: vec![
                    // new StringBuilder()
                    InsnNode::new(
                        InsnType::NewInstance {
                            dest: RegisterArg::with_ssa(0, 0),
                            type_idx: 1,
                        },
                        0,
                    ),
                    // <init>
                    InsnNode::new(
                        InsnType::Invoke {
                            kind: InvokeKind::Direct,
                            method_idx: 100,
                            args: InsnArgs::from_vec(vec![InsnArg::Register(RegisterArg::with_ssa(0, 0))]),
                            proto_idx: None,
                            dest: Some(RegisterArg::with_ssa(0, 1)),
                        },
                        1,
                    ),
                    // append("hello")
                    InsnNode::new(
                        InsnType::Invoke {
                            kind: InvokeKind::Virtual,
                            method_idx: 101,
                            args: InsnArgs::from_vec(vec![
                                InsnArg::Register(RegisterArg::with_ssa(0, 1)),
                                InsnArg::Literal(LiteralArg::from_string_idx(42)),
                            ]),
                            proto_idx: None,
                            dest: Some(RegisterArg::with_ssa(0, 2)),
                        },
                        2,
                    ),
                    // toString()
                    InsnNode::new(
                        InsnType::Invoke {
                            kind: InvokeKind::Virtual,
                            method_idx: 102,
                            args: InsnArgs::from_vec(vec![InsnArg::Register(RegisterArg::with_ssa(0, 2))]),
                            proto_idx: None,
                            dest: Some(RegisterArg::with_ssa(1, 0)),
                        },
                        3,
                    ),
                ],
                predecessors: vec![],
                successors: vec![],
                phis: vec![],
            }],
            entry_block: 0,
        };

        let resolver = make_method_resolver();
        let result = simplify_stringbuilder_chains(&mut ssa, &resolver);

        // Should have converted one chain
        assert_eq!(result.chains_converted, 1);

        // The toString() instruction should now be a StrConcat
        let last_insn = &ssa.blocks[0].instructions[3];
        assert!(matches!(last_insn.insn_type, InsnType::StrConcat { .. }));
    }
}
