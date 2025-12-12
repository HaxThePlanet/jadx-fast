//! jadx-rust command-line interface
//!
//! A high-performance Android DEX/APK decompiler written in Rust.
//! Full CLI matching Java JADX's command-line options.
//!
//! ## Processing Pipeline
//!
//! Decompilation uses a two-phase approach for optimal performance:
//!
//! ### Phase 1: Sequential IR Conversion
//! - Parses DEX bytecode into intermediate representation (IR)
//! - Must be sequential because `DexReader` uses internal caching
//! - Uses `catch_unwind` for robustness against panics in complex methods
//!
//! ### Phase 2: Parallel Code Generation
//! - Converts IR to Java source code using rayon for parallelism
//! - `LazyDexInfo` wrapped in `Arc` for thread-safe sharing
//! - Pre-creates output directories to avoid race conditions
//!
//! ## Memory Optimization
//!
//! Uses `LazyDexInfo` for on-demand loading of DEX pools (strings, types, fields,
//! methods), similar to Java JADX's approach. Only loads data when needed during
//! code generation, dramatically reducing memory usage for large APKs.
//!
//! ## Framework Filtering
//!
//! By default, skips framework classes (android.*, kotlin.*, java.*) and
//! generated code (R.class, databinding, Dagger) for faster decompilation
//! of app-specific code.

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

use jadx_codegen::{LazyDexInfo, DexInfoProvider};
use jadx_ir::ClassData;
use jadx_dex::DexReader;
use std::collections::HashMap;

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

fn process_apk(input: &PathBuf, out_src: &PathBuf, out_res: &PathBuf, args: &Args) -> Result<()> {
    tracing::info!("Processing APK: {}", input.display());

    let file = std::fs::File::open(input)?;
    let mut archive = zip::ZipArchive::new(file)?;

    let mut dex_files = Vec::new();
    let mut manifest_data: Option<Vec<u8>> = None;
    let mut arsc_data: Option<Vec<u8>> = None;
    let mut xml_resources: Vec<(String, Vec<u8>)> = Vec::new();
    let mut raw_files: Vec<(String, Vec<u8>)> = Vec::new();

    // Extract files from APK
    for i in 0..archive.len() {
        let mut entry = archive.by_index(i)?;
        let name = entry.name().to_string();

        // Skip directories
        if name.ends_with('/') {
            continue;
        }

        if name.ends_with(".dex") {
            let mut data = Vec::new();
            entry.read_to_end(&mut data)?;
            dex_files.push((name, data));
        } else if name == "AndroidManifest.xml" {
            let mut data = Vec::new();
            entry.read_to_end(&mut data)?;
            manifest_data = Some(data);
        } else if name == "resources.arsc" {
            let mut data = Vec::new();
            entry.read_to_end(&mut data)?;
            arsc_data = Some(data);
        } else if name.starts_with("res/") && name.ends_with(".xml") {
            let mut data = Vec::new();
            entry.read_to_end(&mut data)?;
            xml_resources.push((name, data));
        } else if should_extract_raw_file(&name) {
            // Extract raw files (META-INF, assets, etc.)
            let mut data = Vec::new();
            entry.read_to_end(&mut data)?;
            raw_files.push((name, data));
        }
    }

    tracing::info!("Found {} DEX file(s), {} resource XMLs", dex_files.len(), xml_resources.len());

    // Process resources (ARSC + AXML)
    if !args.skip_resources {
        process_resources(out_res, manifest_data, arsc_data, xml_resources, raw_files)?;
    }

    // Process source code (DEX)
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

fn process_resources(
    out_res: &PathBuf,
    manifest_data: Option<Vec<u8>>,
    arsc_data: Option<Vec<u8>>,
    xml_resources: Vec<(String, Vec<u8>)>,
    raw_files: Vec<(String, Vec<u8>)>,
) -> Result<()> {
    use jadx_resources::{ArscParser, AxmlParser};
    use std::collections::HashMap;

    tracing::info!("Processing resources ({} raw files)...", raw_files.len());

    // Parse resources.arsc first to get resource name mappings
    let mut res_names: HashMap<u32, String> = HashMap::new();
    if let Some(ref data) = arsc_data {
        tracing::debug!("Parsing resources.arsc ({} bytes)", data.len());
        let mut arsc_parser = ArscParser::new();
        match arsc_parser.parse(data) {
            Ok(()) => {
                res_names = arsc_parser.get_res_names();
                tracing::info!("Parsed {} resource entries", res_names.len());

                // Generate values/*.xml files
                let values_dir = out_res.join("res").join("values");
                std::fs::create_dir_all(&values_dir)?;

                let values_files = arsc_parser.generate_values_xml();
                let values_count = values_files.len();
                for (filename, content) in values_files {
                    let out_path = values_dir.join(&filename);
                    std::fs::write(&out_path, &content)?;
                    tracing::debug!("Wrote {}", filename);
                }
                tracing::info!("Generated {} values XML files", values_count);
            }
            Err(e) => {
                tracing::warn!("Failed to parse resources.arsc: {}", e);
            }
        }
    }

    // Parse and write AndroidManifest.xml
    if let Some(data) = manifest_data {
        tracing::debug!("Parsing AndroidManifest.xml ({} bytes)", data.len());
        let mut axml_parser = AxmlParser::new();
        axml_parser.set_res_names(res_names.clone());

        match axml_parser.parse(&data) {
            Ok(xml) => {
                let out_path = out_res.join("AndroidManifest.xml");
                std::fs::write(&out_path, &xml)?;
                tracing::info!("Wrote AndroidManifest.xml ({} bytes)", xml.len());
            }
            Err(e) => {
                tracing::warn!("Failed to parse AndroidManifest.xml: {}", e);
            }
        }
    }

    // Parse and write other XML resources
    let xml_count = xml_resources.len();
    let mut xml_errors = 0;

    for (name, data) in xml_resources {
        let mut axml_parser = AxmlParser::new();
        axml_parser.set_res_names(res_names.clone());

        match axml_parser.parse(&data) {
            Ok(xml) => {
                // Normalize config qualifiers (remove redundant -v21 for anydpi, etc.)
                let normalized_name = normalize_config_qualifier(&name);
                let out_path = out_res.join(&normalized_name);
                if let Some(parent) = out_path.parent() {
                    std::fs::create_dir_all(parent)?;
                }
                std::fs::write(&out_path, &xml)?;
            }
            Err(e) => {
                tracing::debug!("Failed to parse {}: {}", name, e);
                xml_errors += 1;
            }
        }
    }

    tracing::info!("Processed {} resource XMLs ({} errors)", xml_count, xml_errors);

    // Write raw files (META-INF, assets, etc.)
    if !raw_files.is_empty() {
        let mut raw_count = 0;
        for (name, data) in raw_files {
            let out_path = out_res.join(&name);
            if let Some(parent) = out_path.parent() {
                std::fs::create_dir_all(parent)?;
            }
            std::fs::write(&out_path, &data)?;
            raw_count += 1;
        }
        tracing::info!("Extracted {} raw files", raw_count);
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
    // Wrap DexReader in Arc for sharing with LazyDexInfo
    let dex = std::sync::Arc::new(DexReader::from_slice(0, "input.dex".to_string(), data)?);

    let class_count = dex.header.class_defs_size as usize;
    tracing::info!(
        "DEX: {} classes, {} methods, {} strings",
        class_count,
        dex.header.method_ids_size,
        dex.header.string_ids_size
    );

    // Create LazyDexInfo for name resolution during code generation
    // This is O(1) - no data is loaded upfront (lazy loading like Java JADX)
    tracing::debug!("Creating lazy DEX info for name resolution...");
    let dex_info = LazyDexInfo::new(std::sync::Arc::clone(&dex));
    tracing::debug!("LazyDexInfo ready (on-demand loading enabled)");

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
                        // Skip framework filter when specific class requested
                    } else {
                        // Framework class filter (jadx-fast optimization)
                        if should_skip_class(&class_name) {
                            return None;
                        }
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

    // Wrap LazyDexInfo in Arc for sharing across threads
    let dex_info = std::sync::Arc::new(dex_info);

    // Group inner classes with their outer classes
    // Anonymous classes: Lcom/example/Outer$1; -> outer is Lcom/example/Outer;
    // Named inner classes: Lcom/example/Outer$Inner; -> outer is Lcom/example/Outer;
    let mut outer_classes: Vec<(String, Result<ClassData, String>)> = Vec::new();
    let mut inner_class_map: HashMap<String, HashMap<String, ClassData>> = HashMap::new();

    for (class_name, ir_result) in ir_classes {
        if let Some(dollar_pos) = class_name.rfind('$') {
            // This is an inner class
            let outer_name = format!("{};", &class_name[..dollar_pos]);
            if let Ok(inner_class) = ir_result {
                inner_class_map
                    .entry(outer_name)
                    .or_default()
                    .insert(class_name, inner_class);
            }
            // Don't add to outer_classes - it will be embedded in outer class
        } else {
            // This is an outer class (or standalone)
            outer_classes.push((class_name, ir_result));
        }
    }

    let inner_count: usize = inner_class_map.values().map(|m| m.len()).sum();
    tracing::info!(
        "Grouped {} outer classes with {} inner classes",
        outer_classes.len(),
        inner_count
    );

    // Update progress bar for actual file count (outer classes only)
    if let Some(pb) = progress {
        pb.set_length(outer_classes.len() as u64);
    }

    // Pre-create all necessary directories (sequential to avoid races)
    for (class_name, _) in &outer_classes {
        let rel_path = class_name_to_path(class_name);
        let out_path = out_src.join(&rel_path);
        if let Some(parent) = out_path.parent() {
            std::fs::create_dir_all(parent).ok();
        }
    }

    // Parallel code generation and file writing
    let results: Vec<Result<(), String>> = outer_classes
        .par_iter()
        .map(|(class_name, ir_result)| {
            let rel_path = class_name_to_path(class_name);
            let out_path = out_src.join(&rel_path);

            // Get inner classes for this outer class
            let inner_classes = inner_class_map.get(class_name);

            let java_code = match ir_result {
                Ok(ir_class) => {
                    let config = jadx_codegen::ClassGenConfig::default();
                    // Clone the Arc for each parallel thread
                    let dex_arc: std::sync::Arc<dyn jadx_codegen::DexInfoProvider> = dex_info.clone();
                    jadx_codegen::generate_class_with_inner_classes(
                        ir_class,
                        &config,
                        Some(dex_arc),
                        inner_classes,
                    )
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
        "Phase 2 complete: {} files in {:.2}s ({} errors, {} inner classes embedded)",
        outer_classes.len(),
        phase2_elapsed.as_secs_f64(),
        errors.len(),
        inner_count
    );

    tracing::info!(
        "Total: {:.2}s (IR: {:.2}s, codegen: {:.2}s)",
        phase1_elapsed.as_secs_f64() + phase2_elapsed.as_secs_f64(),
        phase1_elapsed.as_secs_f64(),
        phase2_elapsed.as_secs_f64()
    );

    Ok(outer_classes.len() + inner_count)
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

// NOTE: build_dex_info() was removed - replaced by LazyDexInfo for memory efficiency
// LazyDexInfo loads strings/types/fields/methods on-demand instead of upfront

/// Normalize config qualifier by removing redundant API version suffixes.
/// E.g., "mipmap-anydpi-v21" -> "mipmap-anydpi" (anydpi implies v21)
fn normalize_config_qualifier(path: &str) -> String {
    // Only process res/ paths with config qualifiers
    if !path.starts_with("res/") {
        return path.to_string();
    }

    // Split path into components
    let parts: Vec<&str> = path.split('/').collect();
    if parts.len() < 2 {
        return path.to_string();
    }

    // The second component is the resource type + config (e.g., "mipmap-anydpi-v21")
    let type_config = parts[1];

    // Handle anydpi-v21 -> anydpi (anydpi was introduced in API 21)
    // Handle anydpi-v26 etc. - keep the version if it's higher than 21
    let normalized = if type_config.contains("anydpi-v21") {
        type_config.replace("-v21", "")
    } else {
        type_config.to_string()
    };

    // Rebuild path with normalized qualifier
    let mut result = String::from("res/");
    result.push_str(&normalized);
    for part in &parts[2..] {
        result.push('/');
        result.push_str(part);
    }

    result
}

/// Check if a file should be extracted as raw (unprocessed) from the APK
fn should_extract_raw_file(name: &str) -> bool {
    // META-INF directory (certificates, manifests, signatures)
    if name.starts_with("META-INF/") {
        return true;
    }
    // Assets directory
    if name.starts_with("assets/") {
        return true;
    }
    // Raw resources (non-XML files in res/)
    if name.starts_with("res/") && !name.ends_with(".xml") {
        return true;
    }
    // lib/*.so files (native libraries)
    if name.starts_with("lib/") && name.ends_with(".so") {
        return true;
    }
    // kotlin metadata
    if name.starts_with("kotlin/") {
        return true;
    }
    false
}
