//! Deobfuscation helpers (JADX-compatible basics)
//!
//! Java JADX `--deobf` generates aliases in a deterministic order:
//! packages (sorted), then classes (sorted by raw name), then fields and methods.
//!
//! For now we implement the core pieces needed for 1:1 naming:
//! - Deterministic alias generation in a single-thread prepass (sorted like Java)
//! - Store aliases in `AliasRegistry` with method signature keys (avoid overload collisions)
//! - Apply aliases onto `jadx-ir` nodes before code generation

use std::collections::HashMap;
use std::path::PathBuf;

use anyhow::Result;

use jadx_deobf::{AliasProvider, AliasRegistry, DeobfAliasProvider, method_proto_to_descriptor};
use jadx_dex::DexReader;
use jadx_ir::{ArgType, ClassData, FieldData, MethodData};

use crate::Args;

/// Generate (and register) deobfuscation aliases for all selected classes.
///
/// This is a deterministic, single-threaded prepass so alias numbering matches Java JADX.
pub fn precompute_deobf_aliases(
    dex: &DexReader,
    class_indices: &[u32],
    args: &Args,
    registry: &AliasRegistry,
) {
    if !args.deobfuscation {
        return;
    }

    // Sort classes by raw name (descriptor), like Java JADX `RootNode.finishClassLoad()`.
    let mut by_name: Vec<(String, u32)> = class_indices
        .iter()
        .filter_map(|&idx| {
            let class = dex.get_class(idx).ok()?;
            let name = class.class_type().ok()?.to_string();
            Some((name, idx))
        })
        .collect();
    by_name.sort_by(|a, b| a.0.cmp(&b.0));

    let provider = DeobfAliasProvider::new(args.deobf_max_length);

    // Cache for Android R-class detection (top parent descriptor -> is_r)
    let mut r_cache: HashMap<String, bool> = HashMap::new();

    for (class_desc, idx) in by_name {
        let class_def = match dex.get_class(idx) {
            Ok(c) => c,
            Err(_) => continue,
        };

        // Class rename (skip if Android R* class)
        let is_r = is_android_r_class(dex, &class_desc, &mut r_cache);
        if !is_r
            && registry.get_class_alias(&class_desc).is_none()
            && should_rename_simple_name(simple_name_from_desc(&class_desc), args)
        {
            let mut cls_stub = ClassData::new(class_desc.clone(), class_def.access_flags());

            if let Ok(Some(super_type)) = class_def.superclass_type() {
                cls_stub.superclass = Some(strip_descriptor(super_type).to_string());
            }
            if let Ok(ifaces) = class_def.interfaces() {
                for iface in ifaces {
                    cls_stub.interfaces.push(strip_descriptor(iface).to_string());
                }
            }

            let alias = provider.for_class(&cls_stub);
            registry.set_class_alias(&class_desc, &alias);
        }

        // Fields
        if let Ok(Some(data)) = class_def.class_data() {
            // Static fields first, then instance fields (matches DEX order)
            for field in data.static_fields().chain(data.instance_fields()) {
                let field_id = match dex.get_field(field.field_idx) {
                    Ok(f) => f,
                    Err(_) => continue,
                };
                let field_name = match field_id.name() {
                    Ok(n) => n,
                    Err(_) => continue,
                };

                if registry.get_field_alias(&class_desc, field_name).is_some() {
                    continue;
                }
                if !should_rename_simple_name(field_name, args) {
                    continue;
                }

                let fld_stub = FieldData::new(field_name.to_string(), field.access_flags, ArgType::Unknown);
                let alias = provider.for_field(&fld_stub);
                registry.set_field_alias(&class_desc, field_name, &alias);
            }

            // Methods: direct then virtual (matches DEX order)
            for method in data.direct_methods().chain(data.virtual_methods()) {
                let method_id = match dex.get_method(method.method_idx) {
                    Ok(m) => m,
                    Err(_) => continue,
                };
                let method_name = match method_id.name() {
                    Ok(n) => n,
                    Err(_) => continue,
                };

                // Skip constructors and class initializers (matches Java BaseDeobfCondition)
                if method_name == "<init>" || method_name == "<clinit>" {
                    continue;
                }

                let proto_desc = match method_proto_descriptor(&method_id) {
                    Ok(p) => p,
                    Err(_) => continue,
                };

                // If user mapping already provides an alias, keep it.
                if registry
                    .get_method_alias(&class_desc, method_name, &proto_desc)
                    .is_some()
                {
                    continue;
                }

                if !should_rename_simple_name(method_name, args) {
                    continue;
                }

                let is_override = method_has_override_annotation(dex, &class_def, method.method_idx);
                let mth_stub = MethodData::new(method_name.to_string(), method.access_flags, ArgType::Void);
                let alias = provider.for_method(&mth_stub, is_override);
                registry.set_method_alias(&class_desc, method_name, &proto_desc, &alias);
            }
        }
    }
}

/// Apply aliases from registry to a converted class (class/field/method declaration aliases).
pub fn apply_aliases_from_registry(class: &mut ClassData, registry: &AliasRegistry) {
    let class_desc = normalize_class_descriptor(&class.class_type);

    if let Some(alias) = registry.get_class_alias(&class_desc) {
        class.alias = Some(alias);
    }

    for field in class.static_fields.iter_mut().chain(class.instance_fields.iter_mut()) {
        if let Some(alias) = registry.get_field_alias(&class_desc, &field.name) {
            field.alias = Some(alias);
        }
    }

    for method in &mut class.methods {
        if method.is_constructor() || method.is_class_init() {
            continue;
        }
        let proto_desc = method_proto_to_descriptor(&method.arg_types, &method.return_type);
        if let Some(alias) = registry.get_method_alias(&class_desc, &method.name, &proto_desc) {
            method.alias = Some(alias);
        }
    }
}

/// Build the output relative path for a class, using a deobfuscated class alias if present.
///
/// Note: This only changes the leaf filename. Package renaming is handled separately.
pub fn class_output_rel_path(class_desc: &str, registry: &AliasRegistry) -> PathBuf {
    let stripped = class_desc
        .strip_prefix('L')
        .unwrap_or(class_desc)
        .strip_suffix(';')
        .unwrap_or(class_desc);

    let (pkg, simple) = match stripped.rsplit_once('/') {
        Some((p, s)) => (Some(p), s),
        None => (None, stripped),
    };

    let file_stem = registry
        .get_class_alias(class_desc)
        .unwrap_or_else(|| simple.to_string());

    let mut rel = PathBuf::new();
    if let Some(pkg_internal) = pkg {
        rel.push(pkg_internal.replace('/', std::path::MAIN_SEPARATOR_STR));
    }
    rel.push(format!("{}.java", file_stem));
    rel
}

fn should_rename_simple_name(name: &str, args: &Args) -> bool {
    let len = name.len();
    len < args.deobf_min_length || len > args.deobf_max_length
}

fn simple_name_from_desc(desc: &str) -> &str {
    let stripped = desc
        .strip_prefix('L')
        .unwrap_or(desc)
        .strip_suffix(';')
        .unwrap_or(desc);
    stripped.rsplit('/').next().unwrap_or(stripped)
}

fn strip_descriptor(desc: &str) -> &str {
    let s = desc.strip_prefix('L').unwrap_or(desc);
    s.strip_suffix(';').unwrap_or(s)
}

fn normalize_class_descriptor(class_type: &str) -> String {
    let stripped = class_type
        .strip_prefix('L')
        .unwrap_or(class_type)
        .strip_suffix(';')
        .unwrap_or(class_type);
    format!("L{};", stripped)
}

fn method_proto_descriptor(method_id: &jadx_dex::sections::MethodId<'_>) -> Result<String> {
    let proto = method_id.proto()?;
    let ret = proto.return_type()?;
    let params = proto.parameters()?;
    let mut out = String::with_capacity(2 + ret.len() + params.iter().map(|p| p.len()).sum::<usize>());
    out.push('(');
    for p in params {
        out.push_str(p);
    }
    out.push(')');
    out.push_str(ret);
    Ok(out)
}

fn method_has_override_annotation(dex: &DexReader, class_def: &jadx_dex::sections::ClassDef<'_>, method_idx: u32) -> bool {
    let annots = match class_def.method_annotations(method_idx) {
        Ok(a) => a,
        Err(_) => return false,
    };
    for annot_item in annots {
        let ty = match dex.get_type(annot_item.annotation.type_idx) {
            Ok(t) => t,
            Err(_) => continue,
        };
        if ty == "Ljava/lang/Override;" || ty.ends_with("/Override;") {
            return true;
        }
    }
    false
}

fn top_parent_descriptor(class_desc: &str) -> Option<String> {
    let stripped = class_desc
        .strip_prefix('L')
        .unwrap_or(class_desc)
        .strip_suffix(';')
        .unwrap_or(class_desc);
    let dollar = stripped.find('$')?;
    Some(format!("L{};", &stripped[..dollar]))
}

fn is_android_r_class(dex: &DexReader, class_desc: &str, cache: &mut HashMap<String, bool>) -> bool {
    let top = top_parent_descriptor(class_desc).unwrap_or_else(|| normalize_class_descriptor(class_desc));
    if let Some(v) = cache.get(&top) {
        return *v;
    }

    let is_r = is_android_r_top_class(dex, &top);
    cache.insert(top, is_r);
    is_r
}

fn is_android_r_top_class(dex: &DexReader, r_desc: &str) -> bool {
    // Must be named exactly "R"
    if simple_name_from_desc(r_desc) != "R" {
        return false;
    }

    // Find the class definition for R
    let mut r_idx: Option<u32> = None;
    for (i, cls_res) in dex.classes().enumerate() {
        let cls = match cls_res {
            Ok(c) => c,
            Err(_) => continue,
        };
        let ty = match cls.class_type() {
            Ok(t) => t,
            Err(_) => continue,
        };
        if ty == r_desc {
            r_idx = Some(i as u32);
            break;
        }
    }
    let Some(r_idx) = r_idx else {
        return false;
    };

    let r_def = match dex.get_class(r_idx) {
        Ok(c) => c,
        Err(_) => return false,
    };

    // R top class should not define methods or fields (as per JADX check).
    if let Ok(Some(data)) = r_def.class_data() {
        if data.static_fields().next().is_some() || data.instance_fields().next().is_some() {
            return false;
        }
        if data.direct_methods().next().is_some() || data.virtual_methods().next().is_some() {
            return false;
        }
    }

    // Validate inner classes: only constructors/clinit and int/int[] fields.
    // If no inner classes are found, treat it as not an Android R class.
    let r_prefix = r_desc.trim_end_matches(';').to_string() + "$";
    let mut found_inner = false;

    for cls_res in dex.classes() {
        let cls = match cls_res {
            Ok(c) => c,
            Err(_) => continue,
        };
        let ty = match cls.class_type() {
            Ok(t) => t,
            Err(_) => continue,
        };
        if !ty.starts_with(&r_prefix) {
            continue;
        }
        found_inner = true;

        if let Ok(Some(data)) = cls.class_data() {
            for method in data.direct_methods().chain(data.virtual_methods()) {
                let m_id = match dex.get_method(method.method_idx) {
                    Ok(m) => m,
                    Err(_) => continue,
                };
                let name = match m_id.name() {
                    Ok(n) => n,
                    Err(_) => continue,
                };
                if name != "<init>" && name != "<clinit>" {
                    return false;
                }
            }

            for field in data.static_fields().chain(data.instance_fields()) {
                let f_id = match dex.get_field(field.field_idx) {
                    Ok(f) => f,
                    Err(_) => continue,
                };
                let f_ty = match f_id.field_type() {
                    Ok(t) => t,
                    Err(_) => continue,
                };
                if !is_int_or_int_array(f_ty) {
                    return false;
                }
            }
        }
    }

    found_inner
}

fn is_int_or_int_array(desc: &str) -> bool {
    if desc == "I" {
        return true;
    }
    if !desc.starts_with('[') {
        return false;
    }
    desc.trim_start_matches('[') == "I"
}

