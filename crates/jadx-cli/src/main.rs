//! jadx-rust command-line interface
//!
//! Full CLI matching Java JADX's command-line options.

mod args;
mod converter;
mod decompiler;

use std::io::Read;
use std::path::PathBuf;
use std::time::Instant;

use anyhow::{Context, Result};
use clap::Parser;
use indicatif::{ProgressBar, ProgressStyle};
use rayon::prelude::*;

use jadx_codegen::{DexInfo, FieldInfo, MethodInfo};
use jadx_ir::ClassData;
use jadx_dex::DexReader;
use jadx_ir::ArgType;

pub use args::*;

fn main() -> Result<()> {
    let args = Args::parse();

    // Handle --version
    if args.version {
        println!("jadx-rust {}", env!("CARGO_PKG_VERSION"));
        return Ok(());
    }

    // Initialize logging
    init_logging(&args);

    // Validate args
    args.validate()?;

    let start = Instant::now();

    tracing::info!("jadx-rust v{}", env!("CARGO_PKG_VERSION"));
    tracing::info!(
        "Processing {} input file(s) with {} thread(s)",
        args.input.len(),
        args.effective_threads()
    );

    // Configure rayon thread pool
    rayon::ThreadPoolBuilder::new()
        .num_threads(args.effective_threads())
        .build_global()
        .ok();

    // Process each input file
    for input in &args.input {
        process_input(input, &args)?;
    }

    let elapsed = start.elapsed();
    tracing::info!("Done in {:.2}s", elapsed.as_secs_f64());

    Ok(())
}

fn init_logging(args: &Args) {
    use tracing_subscriber::EnvFilter;

    let level = if args.quiet {
        "error"
    } else if args.verbose {
        "debug"
    } else {
        match args.log_level {
            LogLevel::Quiet => "error",
            LogLevel::Progress => "info",
            LogLevel::Error => "error",
            LogLevel::Warn => "warn",
            LogLevel::Info => "info",
            LogLevel::Debug => "debug",
        }
    };

    tracing_subscriber::fmt()
        .with_env_filter(EnvFilter::new(level))
        .with_target(false)
        .init();
}

fn process_input(input: &PathBuf, args: &Args) -> Result<()> {
    tracing::info!("Loading: {}", input.display());

    // Determine output directory
    let out_dir = args.output_dir.clone().unwrap_or_else(|| {
        let stem = input.file_stem().unwrap_or_default().to_string_lossy();
        PathBuf::from(format!("{}-jadx", stem))
    });

    let out_dir_src = args
        .output_dir_src
        .clone()
        .unwrap_or_else(|| out_dir.join("sources"));
    let out_dir_res = args
        .output_dir_res
        .clone()
        .unwrap_or_else(|| out_dir.join("resources"));

    // Create output directories
    if !args.skip_sources {
        std::fs::create_dir_all(&out_dir_src).with_context(|| {
            format!("Failed to create source dir: {}", out_dir_src.display())
        })?;
    }
    if !args.skip_resources {
        std::fs::create_dir_all(&out_dir_res).with_context(|| {
            format!("Failed to create resources dir: {}", out_dir_res.display())
        })?;
    }

    // Detect file type and process
    let extension = input
        .extension()
        .map(|e| e.to_string_lossy().to_lowercase())
        .unwrap_or_default();

    match extension.as_str() {
        "apk" | "xapk" | "apkm" | "aab" => {
            process_apk(input, &out_dir_src, &out_dir_res, args)?;
        }
        "dex" => {
            process_dex(input, &out_dir_src, args)?;
        }
        "jar" | "aar" | "zip" => {
            tracing::warn!("JAR/AAR processing not yet implemented");
        }
        "class" => {
            tracing::warn!("Class file processing not yet implemented");
        }
        "smali" => {
            tracing::warn!("Smali processing not yet implemented");
        }
        _ => {
            anyhow::bail!("Unsupported file type: {}", extension);
        }
    }

    Ok(())
}

fn process_apk(input: &PathBuf, out_src: &PathBuf, _out_res: &PathBuf, args: &Args) -> Result<()> {
    tracing::info!("Processing APK: {}", input.display());

    let file = std::fs::File::open(input)?;
    let mut archive = zip::ZipArchive::new(file)?;

    let mut dex_files = Vec::new();

    // Extract DEX files from APK
    for i in 0..archive.len() {
        let mut entry = archive.by_index(i)?;
        let name = entry.name().to_string();

        if name.ends_with(".dex") {
            let mut data = Vec::new();
            entry.read_to_end(&mut data)?;
            dex_files.push((name, data));
        }
    }

    tracing::info!("Found {} DEX file(s)", dex_files.len());

    if !args.skip_sources {
        let progress = create_progress_bar(args);
        let mut total_classes = 0;
        let mut total_errors = 0;

        for (name, data) in &dex_files {
            tracing::debug!("Processing DEX: {}", name);
            match process_dex_bytes(data, out_src, args, progress.as_ref()) {
                Ok(count) => total_classes += count,
                Err(e) => {
                    tracing::warn!("Failed to process {}: {}", name, e);
                    total_errors += 1;
                }
            }
        }

        if let Some(pb) = progress {
            pb.finish_with_message("done");
        }

        tracing::info!(
            "Processed {} classes from {} DEX files ({} errors)",
            total_classes,
            dex_files.len(),
            total_errors
        );
    }

    Ok(())
}

fn process_dex(input: &PathBuf, out_src: &PathBuf, args: &Args) -> Result<()> {
    tracing::info!("Processing DEX: {}", input.display());

    let data = std::fs::read(input)?;
    let progress = create_progress_bar(args);
    let count = process_dex_bytes(&data, out_src, args, progress.as_ref())?;

    if let Some(pb) = progress {
        pb.finish_with_message("done");
    }

    tracing::info!("Processed {} classes", count);
    Ok(())
}

fn process_dex_bytes(
    data: &[u8],
    out_src: &PathBuf,
    args: &Args,
    progress: Option<&ProgressBar>,
) -> Result<usize> {
    let dex = DexReader::from_slice(0, "input.dex".to_string(), data)?;

    let class_count = dex.header.class_defs_size as usize;
    tracing::info!(
        "DEX: {} classes, {} methods, {} strings",
        class_count,
        dex.header.method_ids_size,
        dex.header.string_ids_size
    );

    // Build DexInfo for name resolution during code generation
    tracing::debug!("Building DEX info for name resolution...");
    let dex_info = build_dex_info(&dex);
    tracing::debug!(
        "Loaded {} strings, {} types, {} fields, {} methods",
        dex_info.strings.len(),
        dex_info.types.len(),
        dex_info.fields.len(),
        dex_info.methods.len()
    );

    if let Some(pb) = progress {
        pb.set_length(class_count as u64);
    }

    // Collect class indices to process (with filtering)
    let class_indices: Vec<(u32, String)> = dex
        .classes()
        .enumerate()
        .filter_map(|(i, class_result)| {
            match class_result {
                Ok(class) => {
                    let class_name = class.class_type().ok()?.to_string();

                    // Single-class filter
                    if let Some(ref single) = args.single_class {
                        if !class_name.contains(single) {
                            return None;
                        }
                    }

                    // Framework class filter (jadx-fast optimization)
                    if should_skip_class(&class_name) {
                        return None;
                    }

                    Some((i as u32, class_name))
                }
                Err(e) => {
                    tracing::warn!("Failed to parse class {}: {}", i, e);
                    None
                }
            }
        })
        .collect();

    let count = class_indices.len();
    tracing::info!("Processing {} classes (after filtering)", count);

    // ========================================================================
    // PHASE 1: Sequential IR conversion (DexReader not Sync due to caching)
    // ========================================================================
    let phase1_start = Instant::now();
    tracing::info!("Phase 1: Converting DEX to IR (sequential)...");

    let ir_classes: Vec<(String, Result<ClassData, String>)> = class_indices
        .iter()
        .map(|(idx, class_name)| {
            // Use catch_unwind to handle panics in IR conversion gracefully
            let result = std::panic::catch_unwind(std::panic::AssertUnwindSafe(|| {
                dex.get_class(*idx)
                    .map_err(|e| format!("Failed to get class: {}", e))
                    .and_then(|class| {
                        converter::convert_class(&dex, &class)
                            .map_err(|e| format!("Failed to convert: {}", e))
                    })
            }))
            .unwrap_or_else(|_| Err(format!("Panic during conversion of {}", class_name)));
            (class_name.clone(), result)
        })
        .collect();

    let phase1_elapsed = phase1_start.elapsed();
    tracing::info!(
        "Phase 1 complete: {} classes in {:.2}s",
        ir_classes.len(),
        phase1_elapsed.as_secs_f64()
    );

    // ========================================================================
    // PHASE 2: Parallel code generation (ClassData + DexInfo are Send+Sync)
    // ========================================================================
    let phase2_start = Instant::now();
    let num_threads = rayon::current_num_threads();
    tracing::info!(
        "Phase 2: Generating Java code (parallel, {} threads)...",
        num_threads
    );

    // Wrap DexInfo in Arc for sharing across threads
    let dex_info = std::sync::Arc::new(dex_info);

    // Pre-create all necessary directories (sequential to avoid races)
    for (class_name, _) in &ir_classes {
        let rel_path = class_name_to_path(class_name);
        let out_path = out_src.join(&rel_path);
        if let Some(parent) = out_path.parent() {
            std::fs::create_dir_all(parent).ok();
        }
    }

    // Parallel code generation and file writing
    let results: Vec<Result<(), String>> = ir_classes
        .par_iter()
        .map(|(class_name, ir_result)| {
            let rel_path = class_name_to_path(class_name);
            let out_path = out_src.join(&rel_path);

            let java_code = match ir_result {
                Ok(ir_class) => {
                    let config = jadx_codegen::ClassGenConfig::default();
                    jadx_codegen::generate_class_with_dex(ir_class, &config, Some(&dex_info))
                }
                Err(e) => {
                    // Generate stub for failed conversions
                    format!(
                        "// Failed to decompile: {}\nclass {} {{\n}}\n",
                        e,
                        class_name.trim_start_matches('L').trim_end_matches(';').rsplit('/').next().unwrap_or("Unknown")
                    )
                }
            };

            std::fs::write(&out_path, java_code)
                .map_err(|e| format!("Failed to write {}: {}", out_path.display(), e))?;

            if let Some(pb) = progress {
                pb.inc(1);
            }

            Ok(())
        })
        .collect();

    let phase2_elapsed = phase2_start.elapsed();
    let errors: Vec<_> = results.iter().filter(|r| r.is_err()).collect();
    tracing::info!(
        "Phase 2 complete: {} files in {:.2}s ({} errors)",
        ir_classes.len(),
        phase2_elapsed.as_secs_f64(),
        errors.len()
    );

    tracing::info!(
        "Total: {:.2}s (IR: {:.2}s, codegen: {:.2}s)",
        phase1_elapsed.as_secs_f64() + phase2_elapsed.as_secs_f64(),
        phase1_elapsed.as_secs_f64(),
        phase2_elapsed.as_secs_f64()
    );

    Ok(count)
}

fn create_progress_bar(args: &Args) -> Option<ProgressBar> {
    if args.log_level == LogLevel::Quiet || args.quiet {
        return None;
    }

    let pb = ProgressBar::new(0);
    pb.set_style(
        ProgressStyle::default_bar()
            .template("{spinner:.green} [{elapsed_precise}] [{bar:40.cyan/blue}] {pos}/{len} ({eta})")
            .unwrap()
            .progress_chars("#>-"),
    );
    Some(pb)
}

/// Skip framework and generated classes (jadx-fast optimization)
fn should_skip_class(class_name: &str) -> bool {
    const SKIP_PREFIXES: &[&str] = &[
        "Landroid/",
        "Landroidx/",
        "Lkotlin/",
        "Lkotlinx/",
        "Ljava/",
        "Ljavax/",
        "Lsun/",
        "Ldalvik/",
        "Lcom/google/android/",
        "Lcom/android/internal/",
        "Lcom/android/support/",
        "Lorg/apache/http/",
        "Lorg/xmlpull/",
        "Lorg/xml/sax/",
        "Lorg/w3c/dom/",
        "Lorg/json/",
        "Lio/flutter/",
        "Lcom/facebook/react/",
        "Lcom/unity3d/",
    ];

    for prefix in SKIP_PREFIXES {
        if class_name.starts_with(prefix) {
            return true;
        }
    }

    // Generated code patterns
    class_name.contains("/R$")
        || class_name.ends_with("/R;")
        || class_name.ends_with("/BuildConfig;")
        || class_name.contains("_Factory;")
        || class_name.contains("_HiltModules")
        || class_name.contains("/databinding/")
}

fn class_name_to_path(class_name: &str) -> PathBuf {
    let name = class_name
        .trim_start_matches('L')
        .trim_end_matches(';')
        .replace('/', std::path::MAIN_SEPARATOR_STR);
    PathBuf::from(format!("{}.java", name))
}

/// Generate stub Java code for a class (placeholder until full decompilation)
fn generate_class_stub(class: &jadx_dex::sections::ClassDef<'_>, class_name: &str) -> Result<String> {
    // Class name format: "Lcom/example/Foo;" -> extract "Foo"
    let stripped = class_name
        .trim_start_matches('L')
        .trim_end_matches(';');
    let simple_name = stripped
        .rsplit('/')
        .next()
        .unwrap_or(stripped);

    let package = {
        let name = class_name.trim_start_matches('L').trim_end_matches(';');
        if let Some(pos) = name.rfind('/') {
            name[..pos].replace('/', ".")
        } else {
            String::new()
        }
    };

    let mut out = String::with_capacity(512);

    if !package.is_empty() {
        out.push_str(&format!("package {};\n\n", package));
    }

    let flags = class.access_flags();
    let is_public = flags & 0x0001 != 0;
    let is_final = flags & 0x0010 != 0;
    let is_interface = flags & 0x0200 != 0;
    let is_abstract = flags & 0x0400 != 0;
    let is_enum = flags & 0x4000 != 0;

    if is_public {
        out.push_str("public ");
    }
    if is_final && !is_enum {
        out.push_str("final ");
    }
    if is_abstract && !is_interface {
        out.push_str("abstract ");
    }

    if is_interface {
        out.push_str("interface ");
    } else if is_enum {
        out.push_str("enum ");
    } else {
        out.push_str("class ");
    }

    out.push_str(simple_name);
    out.push_str(" {\n");
    out.push_str("    // TODO: Full decompilation not yet implemented\n");
    out.push_str("}\n");

    Ok(out)
}

/// Build DexInfo from DexReader for name resolution during code generation
fn build_dex_info(dex: &DexReader) -> DexInfo {
    let mut info = DexInfo::new();

    // Load all strings
    for idx in 0..dex.header.string_ids_size {
        if let Ok(s) = dex.get_string(idx) {
            info.add_string(idx, s.to_string());
        }
    }

    // Load all type descriptors
    for idx in 0..dex.header.type_ids_size {
        if let Ok(t) = dex.get_type(idx) {
            info.add_type(idx, t.to_string());
        }
    }

    // Load all field info
    for idx in 0..dex.header.field_ids_size {
        if let Ok(field) = dex.get_field(idx) {
            if let (Ok(class_type), Ok(field_name), Ok(field_type_desc)) =
                (field.class_type(), field.name(), field.field_type())
            {
                let class_name = descriptor_to_simple_name(class_type);
                let field_type = parse_type_descriptor(field_type_desc);
                info.add_field(idx, FieldInfo {
                    class_name,
                    field_name: field_name.to_string(),
                    field_type,
                });
            }
        }
    }

    // Load all method info
    for idx in 0..dex.header.method_ids_size {
        if let Ok(method) = dex.get_method(idx) {
            if let (Ok(class_type), Ok(method_name), Ok(proto)) =
                (method.class_type(), method.name(), method.proto())
            {
                let class_name = descriptor_to_simple_name(class_type);
                let return_type = proto.return_type()
                    .map(|d| parse_type_descriptor(d))
                    .unwrap_or(ArgType::Void);
                let param_types: Vec<ArgType> = proto.parameters()
                    .map(|params| params.into_iter().map(|d| parse_type_descriptor(d)).collect())
                    .unwrap_or_default();

                info.add_method(idx, MethodInfo {
                    class_name,
                    method_name: method_name.to_string(),
                    return_type,
                    param_types,
                });
            }
        }
    }

    info
}

/// Convert type descriptor to simple class name
fn descriptor_to_simple_name(desc: &str) -> String {
    if desc.starts_with('L') && desc.ends_with(';') {
        let inner = &desc[1..desc.len()-1];
        inner.rsplit('/').next().unwrap_or(inner).to_string()
    } else {
        desc.to_string()
    }
}

/// Parse type descriptor to ArgType
fn parse_type_descriptor(desc: &str) -> ArgType {
    ArgType::from_descriptor(desc).unwrap_or(ArgType::Unknown)
}
