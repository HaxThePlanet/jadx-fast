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
    use jadx_dex::DexReader;

    let dex = DexReader::from_slice(0, "input.dex".to_string(), data)?;

    let class_count = dex.header.class_defs_size as usize;
    tracing::info!(
        "DEX: {} classes, {} methods, {} strings",
        class_count,
        dex.header.method_ids_size,
        dex.header.string_ids_size
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

    // Process classes sequentially (parallel requires Sync DexReader - TODO)
    for (idx, class_name) in &class_indices {
        let class = dex.get_class(*idx)?;
        let rel_path = class_name_to_path(class_name);
        let out_path = out_src.join(&rel_path);

        if let Some(parent) = out_path.parent() {
            std::fs::create_dir_all(parent)?;
        }

        // Convert DEX class to IR and generate Java code
        let java_code = match converter::convert_class(&dex, &class) {
            Ok(ir_class) => {
                let config = jadx_codegen::ClassGenConfig::default();
                jadx_codegen::generate_class(&ir_class, &config)
            }
            Err(e) => {
                tracing::warn!("Failed to convert class {}: {}", class_name, e);
                generate_class_stub(&class, class_name)?
            }
        };
        std::fs::write(&out_path, java_code)?;

        if let Some(pb) = progress {
            pb.inc(1);
        }
    }

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
