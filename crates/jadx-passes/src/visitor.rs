//! Visitor trait definitions for IR traversal
//!
//! This module provides visitor patterns for traversing and modifying the IR.

use jadx_ir::instructions::InsnNode;

/// Visitor for instructions
pub trait InsnVisitor {
    /// Visit an instruction, potentially modifying it
    fn visit_insn(&mut self, insn: &mut InsnNode) {
        // Default implementation does nothing
        let _ = insn;
    }

    /// Called before visiting a method's instructions
    fn enter_method(&mut self) {}

    /// Called after visiting a method's instructions
    fn exit_method(&mut self) {}
}

/// Read-only visitor for instructions
pub trait InsnReader {
    /// Visit an instruction (read-only)
    fn read_insn(&mut self, insn: &InsnNode) {
        let _ = insn;
    }
}

/// Result of visiting an instruction
#[derive(Debug, Clone, Copy, PartialEq, Eq)]
pub enum VisitResult {
    /// Continue visiting
    Continue,
    /// Skip children/remaining items
    Skip,
    /// Stop visiting entirely
    Stop,
}

/// Visitor that can control traversal
pub trait ControlledVisitor {
    /// Visit an instruction with traversal control
    fn visit(&mut self, insn: &InsnNode) -> VisitResult {
        let _ = insn;
        VisitResult::Continue
    }
}
