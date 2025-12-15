//! DEX to IR converter
//!
//! Converts jadx-dex types to jadx-ir types for code generation.

use anyhow::Result;
use jadx_dex::DexReader;
use jadx_dex::insns::InsnIterator;
use jadx_dex::sections::{
    AnnotationItem, ClassDef, CodeItem, EncodedAnnotation, EncodedField, EncodedMethod,
    VISIBILITY_BUILD, VISIBILITY_RUNTIME, VISIBILITY_SYSTEM,
};
use jadx_dex::EncodedValue;
use jadx_ir::builder::build_ir_insn;
use jadx_ir::{
    Annotation, AnnotationElement, AnnotationValue, AnnotationVisibility,
    ArgType, ClassData, FieldData, FieldValue, MethodData,
};
use jadx_ir::kotlin_metadata::{KotlinMetadata, KOTLIN_METADATA_ANNOTATION};
use jadx_passes::mark_methods_for_inline;

/// Convert a DEX ClassDef to IR ClassData
pub fn convert_class(
    dex: &DexReader,
    class_def: &ClassDef<'_>,
    process_debug_info: bool,
) -> Result<ClassData> {
    let class_type = class_def.class_type()?;
    let access_flags = class_def.access_flags();

    let mut class_data = ClassData::new(class_type, access_flags);

    // Superclass
    if let Some(super_type) = class_def.superclass_type()? {
        class_data.superclass = Some(strip_descriptor(&super_type).to_string());
    }

    // Interfaces
    for iface in class_def.interfaces()? {
        class_data.interfaces.push(strip_descriptor(&iface).to_string());
    }

    // Source file
    if process_debug_info {
        class_data.source_file = class_def.source_file()?.map(|s| s.to_string());
    }

    // Get static field initial values (if any)
    let static_values = class_def.static_values().unwrap_or_default();

    // Class-level annotations
    if let Ok(annots) = class_def.class_annotations() {
        for annot_item in annots {
            if let Some(annotation) = convert_annotation_item(dex, &annot_item) {
                class_data.annotations.push(annotation);
            }
        }

        // After all annotations are added, check for Kotlin metadata
        for annotation in &class_data.annotations {
            if annotation.annotation_type == KOTLIN_METADATA_ANNOTATION {
                if let Some(metadata) = KotlinMetadata::from_annotation(annotation) {
                    class_data.set_kotlin_metadata(metadata);
                    break; // Found Kotlin metadata, no need to check other annotations
                }
            }
        }
    }

    // Fields and methods from class data
    if let Some(data) = class_def.class_data()? {
        // Static fields - pair with initial values and annotations
        for (i, field) in data.static_fields().enumerate() {
            if let Ok(mut field_data) = convert_field(dex, &field) {
                // Assign initial value if present
                if let Some(encoded) = static_values.get(i) {
                    field_data.initial_value = convert_encoded_value(dex, encoded);
                }
                // Field annotations
                if let Ok(annots) = class_def.field_annotations(field.field_idx) {
                    for annot_item in annots {
                        if let Some(annotation) = convert_annotation_item(dex, &annot_item) {
                            field_data.annotations.push(annotation);
                        }
                    }
                }
                class_data.static_fields.push(field_data);
            }
        }

        // Instance fields
        for field in data.instance_fields() {
            if let Ok(mut field_data) = convert_field(dex, &field) {
                // Field annotations
                if let Ok(annots) = class_def.field_annotations(field.field_idx) {
                    for annot_item in annots {
                        if let Some(annotation) = convert_annotation_item(dex, &annot_item) {
                            field_data.annotations.push(annotation);
                        }
                    }
                }
                class_data.instance_fields.push(field_data);
            }
        }

        // Direct methods (constructors, static methods, private methods)
        for method in data.direct_methods() {
            if let Ok(mut method_data) = convert_method(dex, &method, process_debug_info) {
                // Method annotations
                if let Ok(annots) = class_def.method_annotations(method.method_idx) {
                    for annot_item in annots {
                        if let Some(annotation) = convert_annotation_item(dex, &annot_item) {
                            method_data.annotations.push(annotation);
                        }
                    }
                }
                class_data.methods.push(method_data);
            }
        }

        // Virtual methods
        for method in data.virtual_methods() {
            if let Ok(mut method_data) = convert_method(dex, &method, process_debug_info) {
                // Method annotations
                if let Ok(annots) = class_def.method_annotations(method.method_idx) {
                    for annot_item in annots {
                        if let Some(annotation) = convert_annotation_item(dex, &annot_item) {
                            method_data.annotations.push(annotation);
                        }
                    }
                }
                class_data.methods.push(method_data);
            }
        }
    }

    // Mark synthetic methods for inlining
    mark_methods_for_inline(&mut class_data.methods);

    // NOTE: extract_field_init is NOT called here because instructions are not yet loaded.
    // Instructions are stored as BytecodeRef (lazy loading).
    // extract_field_init must be called AFTER instructions are loaded in main.rs,
    // right after load_method_instructions().
    // See Java JADX pattern: ProcessClass.java processes classes AFTER load().

    Ok(class_data)
}

/// Convert a DEX EncodedField to IR FieldData
fn convert_field(dex: &DexReader, encoded: &EncodedField) -> Result<FieldData> {
    let field_id = dex.get_field(encoded.field_idx)?;

    let name = field_id.name()?;
    let field_type_str = field_id.field_type()?;
    let field_type = parse_type_descriptor(&field_type_str);

    let field = FieldData::new(name, encoded.access_flags, field_type);
    // Initial value is set by caller after convert_field returns
    Ok(field)
}

/// Convert a DEX EncodedValue to IR FieldValue
fn convert_encoded_value(dex: &DexReader, encoded: &EncodedValue) -> Option<FieldValue> {
    match encoded {
        EncodedValue::Byte(v) => Some(FieldValue::Byte(*v)),
        EncodedValue::Short(v) => Some(FieldValue::Short(*v)),
        EncodedValue::Char(v) => Some(FieldValue::Char(*v)),
        EncodedValue::Int(v) => Some(FieldValue::Int(*v)),
        EncodedValue::Long(v) => Some(FieldValue::Long(*v)),
        EncodedValue::Float(v) => Some(FieldValue::Float(*v)),
        EncodedValue::Double(v) => Some(FieldValue::Double(*v)),
        EncodedValue::String(idx) => {
            // Resolve string from DEX string pool
            dex.get_string(*idx)
                .ok()
                .map(|s| FieldValue::String(s.to_string()))
        }
        EncodedValue::Type(idx) => {
            // Resolve type name from DEX type pool
            dex.get_type(*idx)
                .ok()
                .map(|s| FieldValue::Type(s.to_string()))
        }
        EncodedValue::Null => Some(FieldValue::Null),
        EncodedValue::Boolean(v) => Some(FieldValue::Boolean(*v)),
        EncodedValue::Array(values) => {
            // Recursively convert array elements
            let converted: Vec<FieldValue> = values
                .iter()
                .filter_map(|v| convert_encoded_value(dex, v))
                .collect();
            Some(FieldValue::Array(converted))
        }
        EncodedValue::Enum(field_idx) => {
            // Resolve enum constant: class name and field name
            dex.get_field(*field_idx).ok().and_then(|field_id| {
                let class_type = field_id.class_type().ok()?;
                let field_name = field_id.name().ok()?;
                Some(FieldValue::Enum(
                    strip_descriptor(&class_type).to_string(),
                    field_name.to_string(),
                ))
            })
        }
        EncodedValue::Field(field_idx) => {
            // Resolve field reference: class name and field name
            dex.get_field(*field_idx).ok().and_then(|field_id| {
                let class_type = field_id.class_type().ok()?;
                let field_name = field_id.name().ok()?;
                Some(FieldValue::Field(
                    strip_descriptor(&class_type).to_string(),
                    field_name.to_string(),
                ))
            })
        }
        // These types aren't directly representable as field values
        EncodedValue::Method(_)
        | EncodedValue::MethodType(_)
        | EncodedValue::MethodHandle(_)
        | EncodedValue::Annotation(_) => None,
    }
}

/// Convert a DEX AnnotationItem to IR Annotation
fn convert_annotation_item(dex: &DexReader, item: &AnnotationItem) -> Option<Annotation> {
    let visibility = match item.visibility {
        VISIBILITY_BUILD => AnnotationVisibility::Build,
        VISIBILITY_RUNTIME => AnnotationVisibility::Runtime,
        VISIBILITY_SYSTEM => AnnotationVisibility::System,
        _ => AnnotationVisibility::Runtime, // Default to runtime
    };

    convert_encoded_annotation(dex, &item.annotation, visibility)
}

/// Convert a DEX EncodedAnnotation to IR Annotation
fn convert_encoded_annotation(
    dex: &DexReader,
    encoded: &EncodedAnnotation,
    visibility: AnnotationVisibility,
) -> Option<Annotation> {
    // Resolve annotation type name
    let type_name = dex.get_type(encoded.type_idx).ok()?;
    let annotation_type = strip_descriptor(&type_name).to_string();

    let mut annotation = Annotation::new(annotation_type, visibility);

    // Convert elements
    for elem in &encoded.elements {
        let name = dex.get_string(elem.name_idx).ok()?.to_string();
        if let Some(value) = convert_annotation_value(dex, &elem.value) {
            annotation.elements.push(AnnotationElement { name, value });
        }
    }

    Some(annotation)
}

/// Convert a DEX EncodedValue to IR AnnotationValue
fn convert_annotation_value(dex: &DexReader, encoded: &EncodedValue) -> Option<AnnotationValue> {
    match encoded {
        EncodedValue::Byte(v) => Some(AnnotationValue::Byte(*v)),
        EncodedValue::Short(v) => Some(AnnotationValue::Short(*v)),
        EncodedValue::Char(v) => Some(AnnotationValue::Char(*v)),
        EncodedValue::Int(v) => Some(AnnotationValue::Int(*v)),
        EncodedValue::Long(v) => Some(AnnotationValue::Long(*v)),
        EncodedValue::Float(v) => Some(AnnotationValue::Float(*v)),
        EncodedValue::Double(v) => Some(AnnotationValue::Double(*v)),
        EncodedValue::String(idx) => {
            dex.get_string(*idx)
                .ok()
                .map(|s| AnnotationValue::String(s.to_string()))
        }
        EncodedValue::Type(idx) => {
            dex.get_type(*idx)
                .ok()
                .as_ref()
                .map(|s| AnnotationValue::Type(strip_descriptor(s).to_string()))
        }
        EncodedValue::Enum(field_idx) => {
            dex.get_field(*field_idx).ok().and_then(|field_id| {
                let class_type = field_id.class_type().ok()?;
                let field_name = field_id.name().ok()?;
                Some(AnnotationValue::Enum(
                    strip_descriptor(&class_type).to_string(),
                    field_name.to_string(),
                ))
            })
        }
        EncodedValue::Annotation(nested) => {
            // Nested annotations inherit visibility
            convert_encoded_annotation(dex, nested, AnnotationVisibility::Runtime)
                .map(|a| AnnotationValue::Annotation(Box::new(a)))
        }
        EncodedValue::Array(values) => {
            let converted: Vec<AnnotationValue> = values
                .iter()
                .filter_map(|v| convert_annotation_value(dex, v))
                .collect();
            Some(AnnotationValue::Array(converted))
        }
        EncodedValue::Boolean(v) => Some(AnnotationValue::Boolean(*v)),
        EncodedValue::Null => Some(AnnotationValue::Null),
        // These types aren't annotation values
        EncodedValue::Field(_)
        | EncodedValue::Method(_)
        | EncodedValue::MethodType(_)
        | EncodedValue::MethodHandle(_) => None,
    }
}

/// Parse switch payload data and update the instruction
fn parse_switch_payload(insn: &mut jadx_ir::instructions::InsnNode, bytecode: &[u16]) {
    use jadx_ir::instructions::InsnType;

    match &mut insn.insn_type {
        InsnType::PackedSwitch {
            payload_offset,
            first_key,
            targets,
            ..
        } => {
            // Payload is at insn.offset + payload_offset (in code units)
            let payload_addr = (insn.offset as i32 + *payload_offset) as usize;
            if payload_addr + 2 >= bytecode.len() {
                return;
            }

            // Packed switch payload format:
            // ident (ushort): 0x0100
            // size (ushort): number of entries
            // first_key (int): first case value
            // targets (int[]): relative branch targets
            let ident = bytecode[payload_addr];
            if ident != 0x0100 {
                return; // Not a valid packed-switch payload
            }

            let size = bytecode[payload_addr + 1] as usize;
            if payload_addr + 4 + size * 2 > bytecode.len() {
                return;
            }

            // Read first_key (2 code units = 4 bytes, little-endian)
            let key_lo = bytecode[payload_addr + 2] as u32;
            let key_hi = bytecode[payload_addr + 3] as u32;
            *first_key = ((key_hi << 16) | key_lo) as i32;

            // Read targets (each is 2 code units = 4 bytes)
            targets.clear();
            for i in 0..size {
                let target_lo = bytecode[payload_addr + 4 + i * 2] as u32;
                let target_hi = bytecode[payload_addr + 4 + i * 2 + 1] as u32;
                let relative_target = ((target_hi << 16) | target_lo) as i32;
                // Convert relative to absolute offset
                let absolute_target = (insn.offset as i32 + relative_target) as u32;
                targets.push(absolute_target);
            }
        }
        InsnType::SparseSwitch {
            payload_offset,
            keys,
            targets,
            ..
        } => {
            // Payload is at insn.offset + payload_offset (in code units)
            let payload_addr = (insn.offset as i32 + *payload_offset) as usize;
            if payload_addr + 2 >= bytecode.len() {
                return;
            }

            // Sparse switch payload format:
            // ident (ushort): 0x0200
            // size (ushort): number of entries
            // keys (int[]): case values (sorted)
            // targets (int[]): relative branch targets
            let ident = bytecode[payload_addr];
            if ident != 0x0200 {
                return; // Not a valid sparse-switch payload
            }

            let size = bytecode[payload_addr + 1] as usize;
            if payload_addr + 2 + size * 4 > bytecode.len() {
                return;
            }

            // Read keys (each is 2 code units = 4 bytes)
            keys.clear();
            for i in 0..size {
                let key_lo = bytecode[payload_addr + 2 + i * 2] as u32;
                let key_hi = bytecode[payload_addr + 2 + i * 2 + 1] as u32;
                keys.push(((key_hi << 16) | key_lo) as i32);
            }

            // Read targets (each is 2 code units = 4 bytes, after keys)
            targets.clear();
            let targets_start = payload_addr + 2 + size * 2;
            for i in 0..size {
                let target_lo = bytecode[targets_start + i * 2] as u32;
                let target_hi = bytecode[targets_start + i * 2 + 1] as u32;
                let relative_target = ((target_hi << 16) | target_lo) as i32;
                // Convert relative to absolute offset
                let absolute_target = (insn.offset as i32 + relative_target) as u32;
                targets.push(absolute_target);
            }
        }
        _ => {}
    }
}

/// Parse fill-array-data payload and update the instruction
fn parse_fill_array_payload(insn: &mut jadx_ir::instructions::InsnNode, bytecode: &[u16]) {
    use jadx_ir::instructions::InsnType;

    if let InsnType::FillArrayData {
        payload_offset,
        element_width,
        data,
        ..
    } = &mut insn.insn_type
    {
        // Payload is at insn.offset + payload_offset (in code units)
        let payload_addr = (insn.offset as i32 + *payload_offset) as usize;
        if payload_addr + 4 >= bytecode.len() {
            return;
        }

        // fill-array-data-payload format:
        // ident (ushort): 0x0300
        // element_width (ushort): size of each element in bytes (1, 2, 4, 8)
        // size (uint): number of elements
        // data[size * element_width]: raw data (byte-aligned)
        let ident = bytecode[payload_addr];
        if ident != 0x0300 {
            return; // Not a valid fill-array-data payload
        }

        let width = bytecode[payload_addr + 1] as u8;
        *element_width = width;

        // Read size (2 code units = 4 bytes, little-endian)
        let size_lo = bytecode[payload_addr + 2] as u32;
        let size_hi = bytecode[payload_addr + 3] as u32;
        let size = ((size_hi << 16) | size_lo) as usize;

        if size == 0 {
            return;
        }

        // Calculate data start and check bounds
        // Data starts at payload_addr + 4 (4 code units for header)
        // Total data size in bytes = size * element_width
        // Total data size in code units = (size * element_width + 1) / 2
        let data_start = payload_addr + 4;
        let data_bytes = size * (width as usize);
        let data_units = (data_bytes + 1) / 2;

        if data_start + data_units > bytecode.len() {
            return;
        }

        // Read elements based on element width
        data.clear();
        match width {
            1 => {
                // 1-byte elements (byte)
                for i in 0..size {
                    let unit_idx = data_start + i / 2;
                    let byte_in_unit = i % 2;
                    let unit = bytecode[unit_idx];
                    let byte_val = if byte_in_unit == 0 {
                        (unit & 0xFF) as i8
                    } else {
                        ((unit >> 8) & 0xFF) as i8
                    };
                    data.push(byte_val as i64);
                }
            }
            2 => {
                // 2-byte elements (short/char)
                for i in 0..size {
                    let val = bytecode[data_start + i] as i16;
                    data.push(val as i64);
                }
            }
            4 => {
                // 4-byte elements (int/float)
                for i in 0..size {
                    let lo = bytecode[data_start + i * 2] as u32;
                    let hi = bytecode[data_start + i * 2 + 1] as u32;
                    let val = ((hi << 16) | lo) as i32;
                    data.push(val as i64);
                }
            }
            8 => {
                // 8-byte elements (long/double)
                for i in 0..size {
                    let w0 = bytecode[data_start + i * 4] as u64;
                    let w1 = bytecode[data_start + i * 4 + 1] as u64;
                    let w2 = bytecode[data_start + i * 4 + 2] as u64;
                    let w3 = bytecode[data_start + i * 4 + 3] as u64;
                    let val = (w3 << 48) | (w2 << 32) | (w1 << 16) | w0;
                    data.push(val as i64);
                }
            }
            _ => {
                // Unknown element width, leave data empty
            }
        }
    }
}

/// Convert a DEX EncodedMethod to IR MethodData
fn convert_method(
    dex: &DexReader,
    encoded: &EncodedMethod,
    process_debug_info: bool,
) -> Result<MethodData> {
    let method_id = dex.get_method(encoded.method_idx)?;
    let proto = method_id.proto()?;

    let name = method_id.name()?;
    let return_type_str = proto.return_type()?;
    let return_type = parse_type_descriptor(&return_type_str);

    let mut method = MethodData::new(name, encoded.access_flags, return_type);

    // Parameters
    for param_type_str in proto.parameters()? {
        method.arg_types.push(parse_type_descriptor(&param_type_str));
    }

    // Parse code_item for instructions
    if encoded.code_off != 0 {
        if let Ok(code_item) = CodeItem::parse(dex, encoded.code_off) {
            method.regs_count = code_item.registers_size;
            method.ins_count = code_item.ins_size;
            method.outs_count = code_item.outs_size;

            // Store bytecode reference for lazy loading (like Java JADX's ICodeReader)
            // This allows for true lazy loading later (instructions loaded on-demand)
            method.bytecode_ref = Some(jadx_ir::BytecodeRef {
                dex_idx: 0, // TODO: multi-DEX support
                method_idx: encoded.method_idx,
                code_offset: encoded.code_off as u64,
                insns_count: code_item.insns_size as u32,
                regs_count: code_item.registers_size,
                ins_count: code_item.ins_size,
                outs_count: code_item.outs_size,
            });

            // Extract parameter names from debug info
            if process_debug_info {
                if let Ok(param_names) = code_item.get_parameter_names() {
                    method.arg_names = param_names;
                }
            }

            // ✅ DO NOT DECODE INSTRUCTIONS IN CONVERTER
            // Store ONLY bytecode reference - instructions loaded later in single-threaded phase
            // This follows Java JADX pattern exactly: reference storage, deferred load

            // Convert try-catch blocks (these are lightweight and can be stored now)
            if let Ok(try_items) = code_item.try_items() {
                if let Ok(catch_handlers) = code_item.catch_handlers() {
                    method.try_blocks = convert_try_catch_blocks(dex, &try_items, &catch_handlers);
                }
            }
        }
    }

    Ok(method)
}

/// Convert DEX try-catch items to IR TryBlock structures
fn convert_try_catch_blocks(
    dex: &DexReader,
    try_items: &[jadx_dex::sections::TryItem],
    catch_handlers: &[jadx_dex::sections::CatchHandler],
) -> Vec<jadx_ir::TryBlock> {
    use jadx_ir::{ExceptionHandler, TryBlock};

    let mut result = Vec::with_capacity(try_items.len());

    for try_item in try_items {
        // Find the handler for this try item
        // handler_off is an index into the catch_handlers list
        let handler_idx = try_item.handler_off as usize;

        let handlers = if handler_idx < catch_handlers.len() {
            let catch_handler = &catch_handlers[handler_idx];
            let mut handlers = Vec::with_capacity(catch_handler.pairs.len() + 1);

            // Add typed exception handlers
            for pair in &catch_handler.pairs {
                // Resolve type name from type_idx
                let exception_type = dex.get_type(pair.type_idx)
                    .ok()
                    .as_ref()
                    .map(|t| strip_descriptor(t).to_string());

                handlers.push(ExceptionHandler {
                    exception_type,
                    handler_addr: pair.addr,
                });
            }

            // Add catch-all handler if present
            if let Some(catch_all_addr) = catch_handler.catch_all_addr {
                handlers.push(ExceptionHandler {
                    exception_type: None, // catch-all
                    handler_addr: catch_all_addr,
                });
            }

            handlers
        } else {
            Vec::new()
        };

        result.push(TryBlock {
            start_addr: try_item.start_addr,
            end_addr: try_item.end_addr(),
            handlers,
        });
    }

    result
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

/// Build class hierarchy from all classes in the DEX file
///
/// This scans all classes to extract superclass and interface relationships,
/// enabling hierarchy-aware type inference and LCA calculation for PHI nodes.
pub fn build_class_hierarchy(dex: &DexReader, class_indices: &[u32]) -> jadx_ir::ClassHierarchy {
    let mut hierarchy = jadx_ir::ClassHierarchy::new();

    // Extract class relationships from DEX
    for &idx in class_indices {
        if let Ok(class_def) = dex.get_class(idx) {
            // Get class name
            if let Ok(class_type) = class_def.class_type() {
                let class_name = strip_descriptor(&class_type).to_string();

                // Get superclass
                let superclass = class_def
                    .superclass_type()
                    .ok()
                    .flatten()
                    .as_ref()
                    .map(|s| strip_descriptor(s).to_string());

                // Get interfaces
                let interfaces = class_def
                    .interfaces()
                    .ok()
                    .unwrap_or_default()
                    .into_iter()
                    .map(|s| strip_descriptor(&s).to_string())
                    .collect();

                // Add to hierarchy
                hierarchy.add_class(class_name, superclass, interfaces);
            }
        }
    }

    hierarchy
}

/// Load instructions for a method from its bytecode reference
///
/// This is called just before code generation to decode instructions from
/// the bytecode stored in BytecodeRef. This pattern (store reference, decode on-demand)
/// is key to Java JADX's memory efficiency.
pub fn load_method_instructions(method: &mut MethodData, dex: &DexReader) -> Result<()> {
    // Already loaded
    if method.is_loaded() {
        return Ok(());
    }

    // No code to load
    let Some(bytecode_ref) = &method.bytecode_ref else {
        return Ok(());
    };

    let code_offset = bytecode_ref.code_offset as u32;

    // Parse code_item at the stored offset
    let code_item = CodeItem::parse(dex, code_offset)?;

    // Decode instructions from bytecode
    let bytecode = code_item.instructions();
    let mut instructions = Vec::new();

    for decoded in InsnIterator::new(bytecode) {
        if let Ok(insn) = decoded {
            let opcode_byte = insn.opcode as u8;
            if let Some(mut ir_insn) = build_ir_insn(
                opcode_byte,
                insn.offset,
                &insn.regs,
                insn.reg_count,
                insn.literal,
                insn.index,
                insn.target,
            ) {
                // Parse payload data for switch and fill-array instructions
                parse_switch_payload(&mut ir_insn, bytecode);
                parse_fill_array_payload(&mut ir_insn, bytecode);
                instructions.push(ir_insn);
            }
        }
    }

    // Set instructions (marks as Loaded)
    method.set_instructions(instructions);
    Ok(())
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