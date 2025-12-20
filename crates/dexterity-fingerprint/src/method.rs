//! Method-level fingerprinting
//!
//! Creates fingerprints for individual methods that remain stable across obfuscation.
//! The fingerprint is based on:
//!
//! - Opcode sequence (not operand indices which change per-DEX)
//! - Method signature (parameter types, return type)
//! - Structural metadata (registers, instruction count)
//! - Exception handler structure

use dexterity_dex::{CodeItem, ProtoId};
use serde::{Deserialize, Serialize};
use std::hash::{Hash, Hasher};
use rustc_hash::FxHasher;

/// Fingerprint for a single method
///
/// This captures the essential structural characteristics of a method
/// that survive obfuscation transformations.
#[derive(Debug, Clone, PartialEq, Eq, Hash, Serialize, Deserialize)]
pub struct MethodFingerprint {
    /// Hash of the opcode sequence (just opcodes, not operands)
    pub opcode_hash: u64,
    /// Hash of the method signature (param types + return type)
    pub signature_hash: u64,
    /// Structural hash (registers, instruction count, try blocks)
    pub structure_hash: u64,
    /// Number of instructions (for quick filtering)
    pub insn_count: u32,
    /// Number of exception handlers
    pub handler_count: u16,
}

impl MethodFingerprint {
    /// Create a fingerprint for an abstract/native method (no code)
    pub fn abstract_method(signature_hash: u64) -> Self {
        Self {
            opcode_hash: 0,
            signature_hash,
            structure_hash: 0,
            insn_count: 0,
            handler_count: 0,
        }
    }

    /// Get a combined hash of all fingerprint components
    #[inline]
    pub fn combined_hash(&self) -> u64 {
        let mut hasher = FxHasher::default();
        self.opcode_hash.hash(&mut hasher);
        self.signature_hash.hash(&mut hasher);
        self.structure_hash.hash(&mut hasher);
        hasher.finish()
    }

    /// Check if two fingerprints are likely the same method
    ///
    /// This uses a multi-stage comparison for efficiency:
    /// 1. Quick check on instruction count (fast reject)
    /// 2. Full fingerprint comparison
    pub fn matches(&self, other: &Self) -> bool {
        // Quick reject based on instruction count
        if self.insn_count != other.insn_count {
            return false;
        }
        if self.handler_count != other.handler_count {
            return false;
        }
        // Full comparison
        self.opcode_hash == other.opcode_hash
            && self.signature_hash == other.signature_hash
            && self.structure_hash == other.structure_hash
    }
}

/// Create a fingerprint for a method
///
/// # Arguments
/// * `code` - The method's code item (bytecode)
/// * `proto` - The method's prototype (signature)
/// * `access_flags` - The method's access flags
///
/// # Returns
/// A fingerprint that uniquely identifies this method's behavior
pub fn fingerprint_method(
    code: &CodeItem,
    proto: &ProtoId,
    access_flags: u32,
) -> dexterity_dex::Result<MethodFingerprint> {
    // 1. Hash the opcode sequence
    let opcode_hash = hash_opcodes(code);

    // 2. Hash the method signature
    let signature_hash = hash_signature(proto)?;

    // 3. Hash structural metadata
    let structure_hash = hash_structure(code, access_flags)?;

    // 4. Get counts for quick filtering
    let handler_count = code.tries_size;

    Ok(MethodFingerprint {
        opcode_hash,
        signature_hash,
        structure_hash,
        insn_count: code.insns_size,
        handler_count,
    })
}

/// Hash bytecode instructions for fingerprinting
///
/// For SAFETY, we hash both opcodes AND literal operands (constants).
/// We exclude DEX-specific indices (string/type/method refs) as those change
/// per-DEX, but include literal values like const/4 0x5 to prevent
/// false matches between classes with different constant values.
fn hash_opcodes(code: &CodeItem) -> u64 {
    use dexterity_dex::insns::Opcode;

    let mut hasher = FxHasher::default();
    let insns = code.instructions();

    let mut i = 0;
    while i < insns.len() {
        let insn = insns[i];
        let opcode = (insn & 0xFF) as u8;

        // Always hash the opcode
        opcode.hash(&mut hasher);

        // Determine instruction size
        let size = instruction_size(opcode);

        // For const instructions, hash the literal value
        // This prevents false matches between classes with different constants
        match Opcode::from_u8(opcode) {
            Some(Opcode::Const4) | Some(Opcode::Const16) | Some(Opcode::Const) |
            Some(Opcode::ConstHigh16) | Some(Opcode::ConstWide16) |
            Some(Opcode::ConstWide32) | Some(Opcode::ConstWide) |
            Some(Opcode::ConstWideHigh16) => {
                // Hash all instruction words (contains the constant value)
                for j in 0..size {
                    if i + j < insns.len() {
                        insns[i + j].hash(&mut hasher);
                    }
                }
            }
            // For other instructions, just hash the opcode (already done above)
            // We don't hash type/method/field/string indices as those are DEX-specific
            _ => {}
        }

        i += size;
    }

    hasher.finish()
}

/// Get the size of an instruction in 16-bit code units
fn instruction_size(opcode: u8) -> usize {
    use dexterity_dex::insns::Opcode;

    match Opcode::from_u8(opcode) {
        Some(op) => op.format().size() as usize,
        None => 1, // Unknown opcode, assume 1 unit
    }
}

/// Hash the method signature (parameter types + return type)
fn hash_signature(proto: &ProtoId) -> dexterity_dex::Result<u64> {
    let mut hasher = FxHasher::default();

    // Hash return type
    let return_type = proto.return_type()?;
    return_type.hash(&mut hasher);

    // Hash parameter types in order
    let params = proto.parameters()?;
    params.len().hash(&mut hasher);
    for param in params {
        param.hash(&mut hasher);
    }

    Ok(hasher.finish())
}

/// Hash structural metadata
fn hash_structure(code: &CodeItem, access_flags: u32) -> dexterity_dex::Result<u64> {
    let mut hasher = FxHasher::default();

    // Register counts
    code.registers_size.hash(&mut hasher);
    code.ins_size.hash(&mut hasher);
    code.outs_size.hash(&mut hasher);

    // Exception handler structure (not types, which can be renamed)
    code.tries_size.hash(&mut hasher);

    // Hash try block ranges (these are structural, not index-dependent)
    if let Ok(tries) = code.try_items() {
        for try_item in tries {
            // Hash the span of each try block
            try_item.insn_count.hash(&mut hasher);
        }
    }

    // Hash catch handler structure
    if let Ok(handlers) = code.catch_handlers() {
        handlers.len().hash(&mut hasher);
        for handler in handlers {
            // Number of typed catches + whether there's a catch-all
            handler.pairs.len().hash(&mut hasher);
            handler.catch_all_addr.is_some().hash(&mut hasher);
        }
    }

    // Access flags affect behavior
    // Mask out SYNTHETIC flag which may vary
    let masked_flags = access_flags & !0x1000;
    masked_flags.hash(&mut hasher);

    Ok(hasher.finish())
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn test_method_fingerprint_equality() {
        let fp1 = MethodFingerprint {
            opcode_hash: 12345,
            signature_hash: 67890,
            structure_hash: 11111,
            insn_count: 50,
            handler_count: 2,
        };

        let fp2 = fp1.clone();
        assert!(fp1.matches(&fp2));
        assert_eq!(fp1.combined_hash(), fp2.combined_hash());
    }

    #[test]
    fn test_different_insn_count_no_match() {
        let fp1 = MethodFingerprint {
            opcode_hash: 12345,
            signature_hash: 67890,
            structure_hash: 11111,
            insn_count: 50,
            handler_count: 2,
        };

        let fp2 = MethodFingerprint {
            insn_count: 51,
            ..fp1.clone()
        };

        assert!(!fp1.matches(&fp2));
    }

    #[test]
    fn test_abstract_method_fingerprint() {
        let fp = MethodFingerprint::abstract_method(12345);
        assert_eq!(fp.opcode_hash, 0);
        assert_eq!(fp.insn_count, 0);
        assert_eq!(fp.signature_hash, 12345);
    }
}
