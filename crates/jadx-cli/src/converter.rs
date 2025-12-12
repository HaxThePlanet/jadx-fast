//! DEX to IR converter
//!
//! Converts jadx-dex types to jadx-ir types for code generation.

use anyhow::Result;
use jadx_dex::DexReader;
use jadx_dex::insns::InsnIterator;
use jadx_dex::sections::{ClassDef, CodeItem, EncodedField, EncodedMethod};
use jadx_ir::builder::build_ir_insn;
use jadx_ir::{ArgType, ClassData, FieldData, MethodData};

/// Convert a DEX ClassDef to IR ClassData
pub fn convert_class(dex: &DexReader, class_def: &ClassDef<'_>) -> Result<ClassData> {
    let class_type = class_def.class_type()?.to_string();
    let access_flags = class_def.access_flags();

    let mut class_data = ClassData::new(class_type, access_flags);

    // Superclass
    if let Some(super_type) = class_def.superclass_type()? {
        class_data.superclass = Some(strip_descriptor(super_type).to_string());
    }

    // Interfaces
    for iface in class_def.interfaces()? {
        class_data.interfaces.push(strip_descriptor(iface).to_string());
    }

    // Source file
    class_data.source_file = class_def.source_file()?.map(|s| s.to_string());

    // Fields and methods from class data
    if let Some(data) = class_def.class_data()? {
        // Static fields
        for field in data.static_fields() {
            if let Ok(field_data) = convert_field(dex, &field) {
                class_data.static_fields.push(field_data);
            }
        }

        // Instance fields
        for field in data.instance_fields() {
            if let Ok(field_data) = convert_field(dex, &field) {
                class_data.instance_fields.push(field_data);
            }
        }

        // Direct methods (constructors, static methods, private methods)
        for method in data.direct_methods() {
            if let Ok(method_data) = convert_method(dex, &method) {
                class_data.methods.push(method_data);
            }
        }

        // Virtual methods
        for method in data.virtual_methods() {
            if let Ok(method_data) = convert_method(dex, &method) {
                class_data.methods.push(method_data);
            }
        }
    }

    Ok(class_data)
}

/// Convert a DEX EncodedField to IR FieldData
fn convert_field(dex: &DexReader, encoded: &EncodedField) -> Result<FieldData> {
    let field_id = dex.get_field(encoded.field_idx)?;

    let name = field_id.name()?.to_string();
    let field_type_str = field_id.field_type()?;
    let field_type = parse_type_descriptor(field_type_str);

    let mut field = FieldData::new(name, encoded.access_flags, field_type);

    // TODO: Extract initial values from static_values section
    field.initial_value = None;

    Ok(field)
}

/// Convert a DEX EncodedMethod to IR MethodData
fn convert_method(dex: &DexReader, encoded: &EncodedMethod) -> Result<MethodData> {
    let method_id = dex.get_method(encoded.method_idx)?;
    let proto = method_id.proto()?;

    let name = method_id.name()?.to_string();
    let return_type_str = proto.return_type()?;
    let return_type = parse_type_descriptor(return_type_str);

    let mut method = MethodData::new(name, encoded.access_flags, return_type);

    // Parameters
    for param_type_str in proto.parameters()? {
        method.arg_types.push(parse_type_descriptor(param_type_str));
    }

    // Parse code_item for instructions
    if encoded.code_off != 0 {
        if let Ok(code_item) = CodeItem::parse(dex, encoded.code_off) {
            method.regs_count = code_item.registers_size;
            method.ins_count = code_item.ins_size;
            method.outs_count = code_item.outs_size;

            // Decode instructions
            let bytecode = code_item.instructions();
            for decoded in InsnIterator::new(bytecode) {
                if let Ok(insn) = decoded {
                    let opcode_byte = insn.opcode as u8;
                    if let Some(ir_insn) = build_ir_insn(
                        opcode_byte,
                        insn.offset,
                        &insn.regs,
                        insn.reg_count,
                        insn.literal,
                        insn.index,
                        insn.target,
                    ) {
                        method.instructions.push(ir_insn);
                    }
                }
            }
        }
    }

    Ok(method)
}

/// Parse a DEX type descriptor into an ArgType
fn parse_type_descriptor(desc: &str) -> ArgType {
    ArgType::from_descriptor(desc).unwrap_or(ArgType::Unknown)
}

/// Strip the L and ; from a class descriptor if present
fn strip_descriptor(desc: &str) -> &str {
    let s = desc.strip_prefix('L').unwrap_or(desc);
    s.strip_suffix(';').unwrap_or(s)
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn test_parse_type_descriptor() {
        assert_eq!(parse_type_descriptor("I"), ArgType::Int);
        assert_eq!(parse_type_descriptor("V"), ArgType::Void);
        assert_eq!(parse_type_descriptor("Z"), ArgType::Boolean);
        assert_eq!(parse_type_descriptor("[I"), ArgType::Array(Box::new(ArgType::Int)));
        assert_eq!(
            parse_type_descriptor("Ljava/lang/String;"),
            ArgType::Object("java/lang/String".to_string())
        );
    }

    #[test]
    fn test_strip_descriptor() {
        assert_eq!(strip_descriptor("Ljava/lang/Object;"), "java/lang/Object");
        assert_eq!(strip_descriptor("java/lang/Object"), "java/lang/Object");
    }
}
