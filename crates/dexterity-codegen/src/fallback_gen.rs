//! Fallback method body generator
//!
//! Used when the standard decompilation pipeline fails.
//! Dumps raw instructions with offsets.

use dexterity_ir::InsnNode;
use crate::writer::CodeWriter;

/// Generate method body in fallback mode (raw instructions)
pub fn generate_fallback_body<W: CodeWriter>(insns: &[InsnNode], code: &mut W) {
    code.start_line().add("// Method generation failed or fallback mode requested").newline();
    code.start_line().add("// dumping raw instructions").newline();

    if insns.is_empty() {
        code.start_line().add("// No instructions found").newline();
        return;
    }

    code.start_line().add("{").newline();
    code.inc_indent();

    for insn in insns {
        code.start_line();
        // Format: /* 000a */ <instruction>
        code.add(&format!("/* {:04x} */ ", insn.offset));

        // Format instruction
        let insn_str = format_insn_fallback(insn);
        code.add(&insn_str);

        code.add(";");
        code.newline();
    }

    code.dec_indent();
    code.start_line().add("}").newline();
}

/// Format instruction for fallback view
fn format_insn_fallback(insn: &InsnNode) -> String {
    // For now, use the Debug implementation which is reasonably readable for IR
    // In the future, we could make this look more like Java/Smali
    format!("{:?}", insn.insn_type)
}
