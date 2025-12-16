//! Deobfuscation helpers (JADX-compatible)
//!
//! Java JADX `--deobf` generates aliases in a deterministic order:
//! packages (sorted), then classes (sorted by raw name), then fields and methods.
//!
//! Features:
//! - Deterministic alias generation in a single-thread prepass (sorted like Java)
//! - Store aliases in `AliasRegistry` with method signature keys (avoid overload collisions)
//! - Apply aliases onto `jadx-ir` nodes before code generation
//! - Package renaming with hierarchical composition
//! - Class/package name collision detection
//! - JOBF file persistence for alias caching
//! - Whitelist support for excluding packages/classes

use std::collections::{HashMap, HashSet};
use std::fs;
use std::io::{BufRead, BufReader, Write};
use std::path::PathBuf;

use anyhow::Result;
use tracing::{info, warn};

use dexterity_deobf::{AliasProvider, AliasRegistry, DeobfAliasProvider, method_proto_to_descriptor};
use dexterity_dex::DexReader;
use dexterity_ir::{ArgType, ClassData, FieldData, MethodData};

use crate::args::DeobfCfgFileMode;
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

    // Load JOBF file if specified and mode allows
    if let Some(ref jobf_path) = args.deobf_cfg_file {
        if args.deobf_cfg_file_mode == DeobfCfgFileMode::Read
            || args.deobf_cfg_file_mode == DeobfCfgFileMode::ReadOrSave
        {
            if let Err(e) = load_jobf_file(jobf_path, registry) {
                warn!("Failed to load JOBF file {}: {}", jobf_path.display(), e);
            }
        }
    }

    // Parse whitelist into packages and classes
    let (whitelist_packages, whitelist_classes) = parse_whitelist(&args.deobf_whitelist);

    // Sort classes by raw name (descriptor), like Java JADX `RootNode.finishClassLoad()`.
    let mut by_name: Vec<(String, u32)> = class_indices
        .iter()
        .filter_map(|&idx| {
            let class = dex.get_class(idx).ok()?;
            let name = class.class_type().ok()?;
            Some((name, idx))
        })
        .collect();
    by_name.sort_by(|a, b| a.0.cmp(&b.0));

    let provider = DeobfAliasProvider::new(args.deobf_max_length);

    // Android R-class detection (precomputed, linear scan).
    // The previous per-class scan was O(n^2) on real apps and can explode memory.
    let android_r_tops = collect_android_r_tops(dex, &by_name);

    // Collect all unique package prefixes (JADX processes each package segment)
    // For "a/b/c", we collect: "a", "a/b", "a/b/c"
    let mut all_prefixes: HashSet<String> = HashSet::new();
    for (desc, _) in &by_name {
        let internal = strip_desc_to_internal(desc);
        if let Some((pkg, _)) = internal.rsplit_once('/') {
            let mut current = String::new();
            for part in pkg.split('/') {
                if !current.is_empty() {
                    current.push('/');
                }
                current.push_str(part);
                all_prefixes.insert(current.clone());
            }
        }
    }
    let mut packages: Vec<String> = all_prefixes.into_iter().collect();
    packages.sort();

    // Build collision avoidance set: package leaf names that classes should avoid
    let mut avoid_cls_names: HashSet<String> = HashSet::new();
    for pkg in &packages {
        let leaf = pkg.rsplit('/').next().unwrap_or(pkg);
        avoid_cls_names.insert(leaf.to_string());
    }

    // Generate package aliases for each segment
    // Store the FULL aliased path (e.g., "a/b" → "p000a/p001b")
    for pkg in &packages {
        let leaf = pkg.rsplit('/').next().unwrap_or(pkg);

        // Check whitelist - skip if package matches
        let pkg_dotted = pkg.replace('/', ".");
        if is_whitelisted_package(&pkg_dotted, &whitelist_packages) {
            continue;
        }

        // Build the full aliased path by composing parent alias + this leaf's alias
        let full_alias = if let Some((parent, _)) = pkg.rsplit_once('/') {
            // Has parent - get parent's alias and append this leaf
            let parent_alias = registry
                .get_package_alias(parent)
                .unwrap_or_else(|| parent.to_string());

            let leaf_alias = if should_rename_simple_name(leaf, args) {
                provider.for_package(leaf)
            } else {
                leaf.to_string()
            };
            format!("{}/{}", parent_alias, leaf_alias)
        } else {
            // Root package segment
            if should_rename_simple_name(leaf, args) {
                provider.for_package(leaf)
            } else {
                leaf.to_string()
            }
        };

        // Only store if different from original
        if full_alias != *pkg {
            registry.set_package_alias(pkg, &full_alias);
        }
    }

    for (class_desc, idx) in by_name {
        let class_def = match dex.get_class(idx) {
            Ok(c) => c,
            Err(_) => continue,
        };

        // Get class info for whitelist/collision checks
        let internal = strip_desc_to_internal(&class_desc);
        let class_full_name = internal.replace('/', ".");
        let simple_name = simple_name_from_desc(&class_desc);

        // Check whitelist - skip if class or its package is whitelisted
        if is_whitelisted_class(&class_full_name, &whitelist_classes, &whitelist_packages) {
            continue;
        }

        // Class rename (skip if Android R* class)
        let is_r = is_android_r_class(&class_desc, &android_r_tops);

        // Determine if we need to rename: either name needs renaming OR would collide with package
        let needs_length_rename = should_rename_simple_name(simple_name, args);
        let would_collide = avoid_cls_names.contains(simple_name);

        if !is_r && registry.get_class_alias(&class_desc).is_none() && (needs_length_rename || would_collide) {
            let mut cls_stub = ClassData::new(class_desc.clone(), class_def.access_flags());

            if let Ok(Some(super_type)) = class_def.superclass_type() {
                cls_stub.superclass = Some(strip_descriptor(&super_type).to_string());
            }
            if let Ok(ifaces) = class_def.interfaces() {
                for iface in ifaces {
                    cls_stub.interfaces.push(strip_descriptor(&iface).to_string());
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

                if registry.get_field_alias(&class_desc, &field_name).is_some() {
                    continue;
                }
                if !should_rename_simple_name(&field_name, args) {
                    continue;
                }

                let fld_stub = FieldData::new(field_name.to_string(), field.access_flags, ArgType::Unknown);
                let alias = provider.for_field(&fld_stub);
                registry.set_field_alias(&class_desc, &field_name, &alias);
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
                    .get_method_alias(&class_desc, &method_name, &proto_desc)
                    .is_some()
                {
                    continue;
                }

                if !should_rename_simple_name(&method_name, args) {
                    continue;
                }

                let is_override = method_has_override_annotation(dex, &class_def, method.method_idx);
                let mth_stub = MethodData::new(method_name.to_string(), method.access_flags, ArgType::Void);
                let alias = provider.for_method(&mth_stub, is_override);
                registry.set_method_alias(&class_desc, &method_name, &proto_desc, &alias);
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

/// Build the output relative path for a class, using deobfuscated package and class aliases.
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
        // Apply package aliases to output path
        let aliased_pkg = apply_package_aliases(pkg_internal, registry);
        rel.push(aliased_pkg.replace('/', std::path::MAIN_SEPARATOR_STR));
    }
    rel.push(format!("{}.java", file_stem));
    rel
}

/// Apply package aliases to an internal package path.
fn apply_package_aliases(pkg_internal: &str, registry: &AliasRegistry) -> String {
    // Look up the full aliased path for this package
    registry
        .get_package_alias(pkg_internal)
        .unwrap_or_else(|| pkg_internal.to_string())
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

fn method_proto_descriptor(method_id: &dexterity_dex::sections::MethodId<'_>) -> Result<String> {
    let proto = method_id.proto()?;
    let ret = proto.return_type()?;
    let params = proto.parameters()?;
    let mut out = String::with_capacity(2 + ret.len() + params.iter().map(|p| p.len()).sum::<usize>());
    out.push('(');
    for p in params {
        out.push_str(&p);
    }
    out.push(')');
    out.push_str(&ret);
    Ok(out)
}

fn method_has_override_annotation(dex: &DexReader, class_def: &dexterity_dex::sections::ClassDef<'_>, method_idx: u32) -> bool {
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

#[derive(Debug, Default, Clone, Copy)]
struct AndroidRFamilyState {
    has_top: bool,
    found_inner: bool,
    invalid: bool,
}

fn strip_desc_to_internal(desc: &str) -> &str {
    desc.strip_prefix('L')
        .unwrap_or(desc)
        .strip_suffix(';')
        .unwrap_or(desc)
}

fn top_parent_internal(internal: &str) -> &str {
    match internal.find('$') {
        Some(pos) => &internal[..pos],
        None => internal,
    }
}

fn simple_name_from_internal(internal: &str) -> &str {
    internal.rsplit('/').next().unwrap_or(internal)
}

fn collect_android_r_tops(dex: &DexReader, classes: &[(String, u32)]) -> HashSet<String> {
    // Map: top internal name (e.g., "com/example/R") -> family validation state.
    let mut families: HashMap<String, AndroidRFamilyState> = HashMap::new();

    for (class_desc, idx) in classes {
        let internal = strip_desc_to_internal(class_desc);
        let top_internal = top_parent_internal(internal);

        // Must be named exactly "R"
        if simple_name_from_internal(top_internal) != "R" {
            continue;
        }

        let state = match families.get_mut(top_internal) {
            Some(s) => s,
            None => {
                families.insert(top_internal.to_string(), AndroidRFamilyState::default());
                families.get_mut(top_internal).expect("just inserted")
            }
        };

        if state.invalid {
            continue;
        }

        let class_def = match dex.get_class(*idx) {
            Ok(c) => c,
            Err(_) => continue,
        };

        if internal == top_internal {
            state.has_top = true;
            if let Ok(Some(data)) = class_def.class_data() {
                if data.static_fields().next().is_some()
                    || data.instance_fields().next().is_some()
                    || data.direct_methods().next().is_some()
                    || data.virtual_methods().next().is_some()
                {
                    state.invalid = true;
                }
            }
            continue;
        }

        // Inner classes: only constructors/clinit and int/int[] fields.
        state.found_inner = true;
        if let Ok(Some(data)) = class_def.class_data() {
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
                    state.invalid = true;
                    break;
                }
            }

            if !state.invalid {
                for field in data.static_fields().chain(data.instance_fields()) {
                    let f_id = match dex.get_field(field.field_idx) {
                        Ok(f) => f,
                        Err(_) => continue,
                    };
                    let f_ty = match f_id.field_type() {
                        Ok(t) => t,
                        Err(_) => continue,
                    };
                    if !is_int_or_int_array(&f_ty) {
                        state.invalid = true;
                        break;
                    }
                }
            }
        }
    }

    families
        .into_iter()
        .filter_map(|(top_internal, state)| {
            if state.has_top && state.found_inner && !state.invalid {
                Some(top_internal)
            } else {
                None
            }
        })
        .collect()
}

fn is_android_r_class(class_desc: &str, android_r_tops: &HashSet<String>) -> bool {
    let internal = strip_desc_to_internal(class_desc);
    let top_internal = top_parent_internal(internal);
    android_r_tops.contains(top_internal)
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

// ============================================================================
// Whitelist support
// ============================================================================

/// Parse whitelist patterns into package prefixes and exact class names.
///
/// Patterns ending with ".*" are treated as package prefixes.
/// Other patterns are treated as exact class names.
fn parse_whitelist(patterns: &[String]) -> (HashSet<String>, HashSet<String>) {
    let mut packages = HashSet::new();
    let mut classes = HashSet::new();

    for pattern in patterns {
        let pattern = pattern.trim();
        if pattern.is_empty() {
            continue;
        }
        if pattern.ends_with(".*") {
            // Package prefix pattern
            packages.insert(pattern[..pattern.len() - 2].to_string());
        } else {
            // Exact class name
            classes.insert(pattern.to_string());
        }
    }

    (packages, classes)
}

/// Check if a package (dotted format) matches any whitelist pattern.
fn is_whitelisted_package(pkg_dotted: &str, whitelist_packages: &HashSet<String>) -> bool {
    // Check exact match
    if whitelist_packages.contains(pkg_dotted) {
        return true;
    }
    // Check if any prefix matches
    for prefix in whitelist_packages {
        if pkg_dotted.starts_with(prefix) && pkg_dotted[prefix.len()..].starts_with('.') {
            return true;
        }
    }
    false
}

/// Check if a class (dotted format) is whitelisted by exact match or package prefix.
fn is_whitelisted_class(
    class_full_name: &str,
    whitelist_classes: &HashSet<String>,
    whitelist_packages: &HashSet<String>,
) -> bool {
    // Exact class match
    if whitelist_classes.contains(class_full_name) {
        return true;
    }
    // Package prefix match
    if let Some(dot_pos) = class_full_name.rfind('.') {
        let pkg = &class_full_name[..dot_pos];
        if is_whitelisted_package(pkg, whitelist_packages) {
            return true;
        }
    }
    false
}

// ============================================================================
// JOBF file persistence
// ============================================================================

/// Load aliases from a JOBF file into the registry.
///
/// JOBF format (one per line):
/// - `p fullPkgName = alias` for packages
/// - `c fullClassName = alias` for classes
/// - `f classRawName.fieldName = alias` for fields
/// - `m classRawName.methodName(signature) = alias` for methods
fn load_jobf_file(path: &PathBuf, registry: &AliasRegistry) -> Result<()> {
    if !path.exists() {
        return Ok(());
    }

    let file = fs::File::open(path)?;
    let reader = BufReader::new(file);
    let mut count = 0;

    for line in reader.lines() {
        let line = line?;
        let line = line.trim();
        if line.is_empty() || line.starts_with('#') {
            continue;
        }

        // Format: "X origName = alias" where X is p/c/f/m
        if line.len() < 4 {
            continue;
        }
        let kind = line.chars().next().unwrap();
        let rest = &line[2..]; // Skip "X "

        let parts: Vec<&str> = rest.splitn(2, '=').collect();
        if parts.len() != 2 {
            continue;
        }
        let orig_name = parts[0].trim();
        let alias = parts[1].trim();

        match kind {
            'p' => {
                // Package: store as internal format (slashes)
                let internal = orig_name.replace('.', "/");
                registry.set_package_alias(&internal, alias);
                count += 1;
            }
            'c' => {
                // Class: convert to descriptor format
                let internal = orig_name.replace('.', "/");
                let desc = format!("L{};", internal);
                registry.set_class_alias(&desc, alias);
                count += 1;
            }
            'f' => {
                // Field: format is "class.field"
                if let Some(dot_pos) = orig_name.rfind('.') {
                    let class_name = &orig_name[..dot_pos];
                    let field_name = &orig_name[dot_pos + 1..];
                    let internal = class_name.replace('.', "/");
                    let desc = format!("L{};", internal);
                    registry.set_field_alias(&desc, field_name, alias);
                    count += 1;
                }
            }
            'm' => {
                // Method: format is "class.method(sig)" - we store without signature for now
                if let Some(dot_pos) = orig_name.rfind('.') {
                    let class_name = &orig_name[..dot_pos];
                    let method_part = &orig_name[dot_pos + 1..];
                    // Extract method name (before any parenthesis)
                    let method_name = method_part.split('(').next().unwrap_or(method_part);
                    let internal = class_name.replace('.', "/");
                    let desc = format!("L{};", internal);
                    // Store with empty proto since JOBF doesn't include full signature
                    registry.set_method_alias(&desc, method_name, "", alias);
                    count += 1;
                }
            }
            _ => {}
        }
    }

    if count > 0 {
        info!("Loaded {} aliases from JOBF file: {}", count, path.display());
    }
    Ok(())
}

/// Save aliases from the registry to a JOBF file.
pub fn save_jobf_file(path: &PathBuf, registry: &AliasRegistry) -> Result<()> {
    let mut lines: Vec<String> = Vec::new();

    // Collect all aliases from registry
    // Note: We iterate through the DashMap entries
    for entry in registry.iter_packages() {
        let orig = entry.key();
        let alias = entry.value();
        let dotted = orig.replace('/', ".");
        lines.push(format!("p {} = {}", dotted, alias));
    }

    for entry in registry.iter_classes() {
        let orig = entry.key();
        let alias = entry.value();
        // Convert descriptor to dotted format
        let internal = orig
            .strip_prefix('L')
            .unwrap_or(orig)
            .strip_suffix(';')
            .unwrap_or(orig);
        let dotted = internal.replace('/', ".");
        lines.push(format!("c {} = {}", dotted, alias));
    }

    for entry in registry.iter_fields() {
        let (class_desc, field_name) = entry.key();
        let alias = entry.value();
        let internal = class_desc
            .strip_prefix('L')
            .unwrap_or(class_desc)
            .strip_suffix(';')
            .unwrap_or(class_desc);
        let class_dotted = internal.replace('/', ".");
        lines.push(format!("f {}.{} = {}", class_dotted, field_name, alias));
    }

    for entry in registry.iter_methods() {
        let (class_desc, method_name, proto) = entry.key();
        let alias = entry.value();
        let internal = class_desc
            .strip_prefix('L')
            .unwrap_or(class_desc)
            .strip_suffix(';')
            .unwrap_or(class_desc);
        let class_dotted = internal.replace('/', ".");
        if proto.is_empty() {
            lines.push(format!("m {}.{} = {}", class_dotted, method_name, alias));
        } else {
            lines.push(format!("m {}.{}{} = {}", class_dotted, method_name, proto, alias));
        }
    }

    if lines.is_empty() {
        return Ok(());
    }

    // Sort for deterministic output
    lines.sort();

    // Write to file
    let mut file = fs::File::create(path)?;
    for line in &lines {
        writeln!(file, "{}", line)?;
    }

    info!("Saved {} aliases to JOBF file: {}", lines.len(), path.display());
    Ok(())
}