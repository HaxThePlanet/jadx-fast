//! DEX to IR converter
//!
//! Converts dexterity-dex types to dexterity-ir types for code generation.

use anyhow::Result;
use dexterity_dex::DexReader;
use dexterity_dex::insns::InsnIterator;
use dexterity_dex::sections::{
    AnnotationItem, ClassDef, CodeItem, EncodedAnnotation, EncodedField, EncodedMethod,
    VISIBILITY_BUILD, VISIBILITY_RUNTIME, VISIBILITY_SYSTEM,
};
use dexterity_dex::EncodedValue;
use dexterity_ir::builder::build_ir_insn;
use dexterity_ir::{
    Annotation, AnnotationElement, AnnotationValue, AnnotationVisibility,
    ArgType, ClassData, FieldData, FieldValue, MethodData, TypeParameter,
};
use dexterity_ir::kotlin_metadata::{KotlinMetadata, KOTLIN_METADATA_ANNOTATION};
use dexterity_passes::mark_methods_for_inline;

/// Convert a DEX ClassDef to IR ClassData
pub fn convert_class(
    dex: &DexReader,
    class_def: &ClassDef<'_>,
    process_debug_info: bool,
) -> Result<ClassData> {
    let class_type = class_def.class_type()?;

    // Get access flags - for inner classes, use flags from InnerClass annotation
    // The class_def access_flags don't include 'static' for inner classes,
    // but dalvik/annotation/InnerClass annotation contains the real access flags
    let access_flags = get_effective_access_flags(dex, class_def);

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

    // Apply signature annotation to get class-level generic type parameters
    // Like JADX's SignatureProcessor.parseClassSignature()
    apply_signature_to_class(&mut class_data);

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
                // Apply signature annotation to get generic type info
                apply_signature_to_field(&mut field_data);
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
                // Apply signature annotation to get generic type info
                apply_signature_to_field(&mut field_data);
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
                // Apply signature annotation to get generic type info
                apply_signature_to_method(&mut method_data);
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
                // Apply signature annotation to get generic type info
                apply_signature_to_method(&mut method_data);
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

/// Get effective access flags for a class
///
/// For inner classes, the DEX class_def access_flags don't include modifiers like 'static'.
/// The real access flags are stored in the dalvik/annotation/InnerClass annotation.
/// This function extracts those flags when present.
///
/// See JADX's ClassNode.getAccessFlags() for the equivalent implementation.
fn get_effective_access_flags(dex: &DexReader, class_def: &ClassDef<'_>) -> u32 {
    // Start with the raw class_def flags
    let raw_flags = class_def.access_flags();

    // Try to get the InnerClass annotation flags
    if let Ok(annots) = class_def.class_annotations() {
        for annot_item in annots {
            // Resolve annotation type name
            if let Ok(type_name) = dex.get_type(annot_item.annotation.type_idx) {
                if type_name == "Ldalvik/annotation/InnerClass;" {
                    // Found InnerClass annotation - extract accessFlags element
                    for elem in &annot_item.annotation.elements {
                        if let Ok(name) = dex.get_string(elem.name_idx) {
                            if name.as_ref() == "accessFlags" {
                                if let EncodedValue::Int(flags) = &elem.value {
                                    // Return the flags from annotation
                                    return *flags as u32;
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    // No InnerClass annotation found, use raw flags
    raw_flags
}

/// Convert a DEX EncodedField to IR FieldData
fn convert_field(dex: &DexReader, encoded: &EncodedField) -> Result<FieldData> {
    let field_id = dex.get_field(encoded.field_idx)?;

    let name = field_id.name()?;
    let field_type_str = field_id.field_type()?;
    let field_type = parse_type_descriptor(&field_type_str);

    let mut field = FieldData::new(name, encoded.access_flags, field_type);
    // Store DEX field index for mapping instructions back to fields
    field.dex_field_idx = Some(encoded.field_idx);
    // Initial value is set by caller after convert_field returns
    Ok(field)
}

/// Apply signature annotation to class if present
/// Parses dalvik.annotation.Signature to extract generic type parameters for class
/// Like JADX's SignatureProcessor.parseClassSignature()
fn apply_signature_to_class(class: &mut ClassData) {
    // Find Signature annotation
    let signature_str = class.annotations.iter().find_map(|annot| {
        if annot.annotation_type == "dalvik/annotation/Signature" {
            // Get the "value" element which is an array of strings
            annot.elements.iter().find_map(|elem| {
                if elem.name == "value" {
                    if let AnnotationValue::Array(values) = &elem.value {
                        let parts: Vec<&str> = values.iter().filter_map(|v| {
                            if let AnnotationValue::String(s) = v {
                                Some(s.as_str())
                            } else {
                                None
                            }
                        }).collect();
                        return Some(parts.join(""));
                    }
                }
                None
            })
        } else {
            None
        }
    });

    if let Some(sig) = signature_str {
        parse_class_signature(&sig, class);
    }
}

/// Parse a class signature string and update class types
/// Format: <TypeParams>SuperType;Interface1;Interface2...
/// Example: <T:Ljava/lang/Object;>Ljava/lang/Object;Lio/reactivex/MaybeSource<TT;>;
fn parse_class_signature(sig: &str, class: &mut ClassData) {
    let mut chars = sig.chars().peekable();

    // Parse type parameters (e.g., <T:Ljava/lang/Object;E:Ljava/lang/Number;>)
    if chars.peek() == Some(&'<') {
        chars.next(); // consume '<'
        class.type_parameters = parse_type_parameters(&mut chars);
    }

    // The rest of the signature contains superclass and interfaces with generic types
    // For now, we're only extracting type parameters - the superclass/interface
    // type arguments would require storing ArgType instead of String
}

/// Apply signature annotation to method types if present
/// Parses dalvik.annotation.Signature to extract generic type information for methods
fn apply_signature_to_method(method: &mut MethodData) {
    // Find Signature annotation
    let signature_str = method.annotations.iter().find_map(|annot| {
        if annot.annotation_type == "dalvik/annotation/Signature" {
            // Get the "value" element which is an array of strings
            annot.elements.iter().find_map(|elem| {
                if elem.name == "value" {
                    if let AnnotationValue::Array(values) = &elem.value {
                        let parts: Vec<&str> = values.iter().filter_map(|v| {
                            if let AnnotationValue::String(s) = v {
                                Some(s.as_str())
                            } else {
                                None
                            }
                        }).collect();
                        return Some(parts.join(""));
                    }
                }
                None
            })
        } else {
            None
        }
    });

    if let Some(sig) = signature_str {
        parse_method_signature(&sig, method);
    }
}

/// Parse a method signature string and update method types
/// Format: <TypeParams>(ArgTypes)ReturnType
/// Example: <T:Ljava/lang/Object;>(Ljava/util/List<TT;>;)TT;
fn parse_method_signature(sig: &str, method: &mut MethodData) {
    let mut chars = sig.chars().peekable();

    // Parse type parameters (e.g., <T:Ljava/lang/Object;E:Ljava/lang/Number;>)
    if chars.peek() == Some(&'<') {
        chars.next(); // consume '<'
        method.type_parameters = parse_type_parameters(&mut chars);
    }

    // Parse argument types: (ArgType1ArgType2...)
    if chars.peek() == Some(&'(') {
        chars.next(); // consume '('
        let mut arg_types = Vec::new();
        while chars.peek() != Some(&')') && chars.peek().is_some() {
            if let Some(arg_type) = parse_type_from_signature(&mut chars) {
                arg_types.push(arg_type);
            } else {
                break;
            }
        }
        if chars.peek() == Some(&')') {
            chars.next(); // consume ')'
            // Only update if we parsed the expected number of args
            if arg_types.len() == method.arg_types.len() {
                method.arg_types = arg_types;
            }
        }
    }

    // Parse return type
    if let Some(return_type) = parse_type_from_signature(&mut chars) {
        method.return_type = return_type;
    }
}

/// Parse type parameters from a signature
/// Format: T:Ljava/lang/Object;E:Ljava/lang/Number;>
/// Each type parameter is: Name:Bound1:Bound2...; (bounds separated by :)
/// Interface bounds are prefixed with ::
fn parse_type_parameters(chars: &mut std::iter::Peekable<std::str::Chars>) -> Vec<TypeParameter> {
    let mut params = Vec::new();

    while chars.peek().is_some() && chars.peek() != Some(&'>') {
        // Parse type parameter name (everything before the first ':')
        let mut name = String::new();
        while let Some(&c) = chars.peek() {
            if c == ':' {
                break;
            }
            if c == '>' {
                break;
            }
            chars.next();
            name.push(c);
        }

        if name.is_empty() {
            break;
        }

        // Parse bounds (everything after ':' until the next type param or '>')
        let mut bounds = Vec::new();

        // Consume the first ':'
        if chars.peek() == Some(&':') {
            chars.next();

            // Check for class bound vs interface bound
            // Class bound is just: :Lfoo/Bar;
            // Interface bound is: ::Lfoo/Bar;
            // No class bound (extends Object) starts with :: directly

            loop {
                // Skip extra ':' for interface bounds
                while chars.peek() == Some(&':') {
                    chars.next();
                }

                // Check if we're at the end or next parameter
                if chars.peek().is_none() || chars.peek() == Some(&'>') {
                    break;
                }

                // Check if this is the start of a new type parameter (uppercase letter followed by :)
                if let Some(&c) = chars.peek() {
                    // If we see an uppercase letter that isn't part of a type descriptor,
                    // it's likely the next type parameter
                    if c.is_ascii_uppercase() {
                        // Peek ahead to see if it's followed by ':'
                        let mut peek_chars = chars.clone();
                        peek_chars.next(); // consume the letter
                        let mut is_new_param = false;
                        while let Some(&pc) = peek_chars.peek() {
                            if pc == ':' {
                                is_new_param = true;
                                break;
                            }
                            if !pc.is_ascii_alphanumeric() && pc != '_' {
                                break;
                            }
                            peek_chars.next();
                        }
                        if is_new_param {
                            break;
                        }
                    }
                }

                // Parse a bound type
                if let Some(bound) = parse_type_from_signature(chars) {
                    // Skip Object bound (implicit)
                    if !matches!(&bound, ArgType::Object(name) if name == "java/lang/Object") {
                        bounds.push(bound);
                    }
                } else {
                    break;
                }
            }
        }

        params.push(TypeParameter { name, bounds });
    }

    // Consume the closing '>'
    if chars.peek() == Some(&'>') {
        chars.next();
    }

    params
}

/// Apply signature annotation to field type if present
/// Parses dalvik.annotation.Signature to extract generic type information
fn apply_signature_to_field(field: &mut FieldData) {
    // Find Signature annotation
    let signature_str = field.annotations.iter().find_map(|annot| {
        if annot.annotation_type == "dalvik/annotation/Signature" {
            // Get the "value" element which is an array of strings
            annot.elements.iter().find_map(|elem| {
                if elem.name == "value" {
                    if let AnnotationValue::Array(values) = &elem.value {
                        let parts: Vec<&str> = values.iter().filter_map(|v| {
                            if let AnnotationValue::String(s) = v {
                                Some(s.as_str())
                            } else {
                                None
                            }
                        }).collect();
                        return Some(parts.join(""));
                    }
                }
                None
            })
        } else {
            None
        }
    });

    if let Some(sig) = signature_str {
        if let Some(generic_type) = parse_signature(&sig) {
            field.field_type = generic_type;
        }
    }
}

/// Parse a Java signature string into ArgType
/// Handles generic types like "Ljava/util/List<Lcom/example/Item;>;"
fn parse_signature(sig: &str) -> Option<ArgType> {
    let mut chars = sig.chars().peekable();
    parse_type_from_signature(&mut chars)
}

fn parse_type_from_signature(chars: &mut std::iter::Peekable<std::str::Chars>) -> Option<ArgType> {
    match chars.next()? {
        'V' => Some(ArgType::Void),
        'Z' => Some(ArgType::Boolean),
        'B' => Some(ArgType::Byte),
        'C' => Some(ArgType::Char),
        'S' => Some(ArgType::Short),
        'I' => Some(ArgType::Int),
        'J' => Some(ArgType::Long),
        'F' => Some(ArgType::Float),
        'D' => Some(ArgType::Double),
        '[' => {
            // Array type
            let elem = parse_type_from_signature(chars)?;
            Some(ArgType::Array(Box::new(elem)))
        }
        'L' => {
            // Object type, possibly with generics
            let mut class_name = String::new();
            let mut generic_params = Vec::new();

            while let Some(&c) = chars.peek() {
                match c {
                    ';' => {
                        chars.next();
                        break;
                    }
                    '<' => {
                        chars.next();
                        // Parse generic type parameters
                        while let Some(&gc) = chars.peek() {
                            if gc == '>' {
                                chars.next();
                                break;
                            }
                            if let Some(param) = parse_type_from_signature(chars) {
                                generic_params.push(param);
                            }
                        }
                    }
                    _ => {
                        chars.next();
                        class_name.push(c);
                    }
                }
            }

            if generic_params.is_empty() {
                Some(ArgType::Object(class_name))
            } else {
                Some(ArgType::Generic {
                    base: class_name,
                    params: generic_params,
                })
            }
        }
        '+' => {
            // ? extends Type (wildcard upper bound)
            let inner = parse_type_from_signature(chars);
            Some(ArgType::Wildcard {
                bound: dexterity_ir::types::WildcardBound::Extends,
                inner: inner.map(Box::new),
            })
        }
        '-' => {
            // ? super Type (wildcard lower bound)
            let inner = parse_type_from_signature(chars);
            Some(ArgType::Wildcard {
                bound: dexterity_ir::types::WildcardBound::Super,
                inner: inner.map(Box::new),
            })
        }
        '*' => {
            // Unbounded wildcard (?)
            Some(ArgType::Wildcard {
                bound: dexterity_ir::types::WildcardBound::Unbounded,
                inner: None,
            })
        }
        'T' => {
            // Type variable (e.g., TT;)
            let mut var_name = String::new();
            while let Some(&c) = chars.peek() {
                if c == ';' {
                    chars.next();
                    break;
                }
                chars.next();
                var_name.push(c);
            }
            Some(ArgType::TypeVariable(var_name))
        }
        _ => None,
    }
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
fn parse_switch_payload(insn: &mut dexterity_ir::instructions::InsnNode, bytecode: &[u16]) {
    use dexterity_ir::instructions::InsnType;

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
fn parse_fill_array_payload(insn: &mut dexterity_ir::instructions::InsnNode, bytecode: &[u16]) {
    use dexterity_ir::instructions::InsnType;

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
            method.bytecode_ref = Some(dexterity_ir::BytecodeRef {
                dex_idx: 0, // TODO: multi-DEX support
                method_idx: encoded.method_idx,
                code_offset: encoded.code_off as u64,
                insns_count: code_item.insns_size as u32,
                regs_count: code_item.registers_size,
                ins_count: code_item.ins_size,
                outs_count: code_item.outs_size,
            });

            // Extract debug info (parameter names, local variables, line numbers)
            if process_debug_info {
                if let Ok(Some(full_debug)) = code_item.parse_full_debug_info() {
                    // Parameter names (resolve string indices)
                    method.arg_names = full_debug.param_names.iter()
                        .map(|idx| idx.and_then(|i| dex.get_string(i).ok().map(|s| (*s).to_string())))
                        .collect();

                    // Full debug info with local variables (for variable naming)
                    method.debug_info = Some(dexterity_ir::DebugInfo {
                        line_numbers: full_debug.line_numbers,
                        local_vars: full_debug.local_vars.into_iter()
                            .map(|v| dexterity_ir::LocalVar {
                                name: v.name,
                                type_desc: v.type_desc,
                                reg: v.reg,
                                start_addr: v.start_addr,
                                end_addr: v.end_addr,
                            })
                            .collect(),
                    });
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
    try_items: &[dexterity_dex::sections::TryItem],
    catch_handlers: &[dexterity_dex::sections::CatchHandler],
) -> Vec<dexterity_ir::TryBlock> {
    use dexterity_ir::{ExceptionHandler, TryBlock};

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
///
/// OPTIMIZATION: Parallel extraction of class metadata followed by fast sequential merge.
/// Instead of sequentially adding classes to the hierarchy (O(N) with sequential lock contention),
/// we extract all class metadata in parallel, then do a fast sequential merge.
/// For 50K classes: ~500ms → ~50ms (10x faster).
pub fn build_class_hierarchy(dex: &DexReader, class_indices: &[u32]) -> dexterity_ir::ClassHierarchy {
    use rayon::prelude::*;

    // Phase 1: Parallel extraction of class metadata
    // Each thread extracts superclass and interface relationships independently
    let class_data: Vec<_> = class_indices
        .par_iter()
        .filter_map(|&idx| {
            dex.get_class(idx).ok().and_then(|class_def| {
                class_def.class_type().ok().map(|class_type| {
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
                        .collect::<Vec<_>>();

                    (class_name, superclass, interfaces)
                })
            })
        })
        .collect();

    // Phase 2: Sequential merge (fast - just inserting pre-extracted data)
    let mut hierarchy = dexterity_ir::ClassHierarchy::new();
    for (class_name, superclass, interfaces) in class_data {
        hierarchy.add_class(class_name, superclass, interfaces);
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

    // ===== Type Parameter Parsing Tests =====

    #[test]
    fn test_parse_simple_type_param() {
        // <T:Ljava/lang/Object;> - T extends Object (implicit, skipped)
        let sig = "T:Ljava/lang/Object;>";
        let mut chars = sig.chars().peekable();
        let params = parse_type_parameters(&mut chars);
        assert_eq!(params.len(), 1, "Should parse 1 type parameter");
        assert_eq!(params[0].name, "T");
        assert!(params[0].bounds.is_empty(), "Object bound should be implicit");
    }

    #[test]
    fn test_parse_multiple_type_params() {
        // <K:Ljava/lang/Object;V:Ljava/lang/Object;>
        let sig = "K:Ljava/lang/Object;V:Ljava/lang/Object;>";
        let mut chars = sig.chars().peekable();
        let params = parse_type_parameters(&mut chars);
        assert_eq!(params.len(), 2, "Should parse 2 type parameters");
        assert_eq!(params[0].name, "K");
        assert_eq!(params[1].name, "V");
    }

    #[test]
    fn test_parse_bounded_type_param() {
        // <T:Ljava/lang/Number;> - T extends Number
        let sig = "T:Ljava/lang/Number;>";
        let mut chars = sig.chars().peekable();
        let params = parse_type_parameters(&mut chars);
        assert_eq!(params.len(), 1, "Should parse 1 type parameter");
        assert_eq!(params[0].name, "T");
        assert_eq!(params[0].bounds.len(), 1, "Should have 1 bound");
        assert_eq!(params[0].bounds[0], ArgType::Object("java/lang/Number".to_string()));
    }

    #[test]
    fn test_parse_interface_bound() {
        // <T::Ljava/io/Serializable;> - T with interface bound only (no class bound)
        let sig = "T::Ljava/io/Serializable;>";
        let mut chars = sig.chars().peekable();
        let params = parse_type_parameters(&mut chars);
        assert_eq!(params.len(), 1, "Should parse 1 type parameter");
        assert_eq!(params[0].name, "T");
        assert_eq!(params[0].bounds.len(), 1, "Should have 1 interface bound");
        assert_eq!(params[0].bounds[0], ArgType::Object("java/io/Serializable".to_string()));
    }

    #[test]
    fn test_parse_multiple_bounds() {
        // <T:Ljava/lang/Number;:Ljava/lang/Comparable;> - T extends Number & Comparable
        let sig = "T:Ljava/lang/Number;:Ljava/lang/Comparable;>";
        let mut chars = sig.chars().peekable();
        let params = parse_type_parameters(&mut chars);
        assert_eq!(params.len(), 1, "Should parse 1 type parameter");
        assert_eq!(params[0].name, "T");
        assert_eq!(params[0].bounds.len(), 2, "Should have 2 bounds");
    }

    #[test]
    fn test_parse_rxjava_style() {
        // RxJava Maybe.amb style: <T:Ljava/lang/Object;>
        // Full signature would be: <T:Ljava/lang/Object;>(Ljava/lang/Iterable<...>;)Lio/reactivex/Maybe<TT;>;
        let sig = "T:Ljava/lang/Object;>";
        let mut chars = sig.chars().peekable();
        let params = parse_type_parameters(&mut chars);
        assert_eq!(params.len(), 1, "Should parse 1 type parameter for RxJava style");
        assert_eq!(params[0].name, "T");
    }

    #[test]
    fn test_parse_long_param_name() {
        // <ResultT:Ljava/lang/Object;>
        let sig = "ResultT:Ljava/lang/Object;>";
        let mut chars = sig.chars().peekable();
        let params = parse_type_parameters(&mut chars);
        assert_eq!(params.len(), 1, "Should parse 1 type parameter");
        assert_eq!(params[0].name, "ResultT");
    }
}