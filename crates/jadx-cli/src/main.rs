//! Dexterity - A high-performance Android DEX/APK decompiler
//!
//! Written in Rust for speed and safety.
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
mod deobf;
mod decompiler;
mod gradle_export;

use std::io::Read;
use std::path::PathBuf;
use std::time::Instant;

use anyhow::{Context, Result};

// Memory tracking for debugging
fn get_mem_mb() -> usize {
    std::fs::read_to_string("/proc/self/statm")
        .ok()
        .and_then(|s| s.split_whitespace().next()?.parse::<usize>().ok())
        .map(|pages| pages * 4096 / 1024 / 1024)
        .unwrap_or(0)
}

macro_rules! mem_checkpoint {
    ($msg:expr) => {
        eprintln!("MEM[{}]: {} MB", $msg, get_mem_mb());
    };
}
use clap::Parser;
use indicatif::{ProgressBar, ProgressStyle};
use rayon::prelude::*;

use jadx_codegen::{LazyDexInfo, DexInfoProvider, AliasAwareDexInfo, GlobalFieldPool};
use jadx_ir::ClassData;
use jadx_dex::DexReader;
use jadx_kotlin;
use jadx_deobf::{
    AliasRegistry, parse_proguard_mapping,
};
use std::collections::HashMap;
use std::sync::Arc;

pub use args::*;

fn main() -> Result<()> {
    let args = Args::parse();

    // Handle --version
    if args.version {
        println!("dexterity {}", env!("CARGO_PKG_VERSION"));
        return Ok(());
    }

    // Initialize logging
    init_logging(&args);

    // Validate args
    args.validate()?;

    // Handle Knox-Vision integration if enabled
    if args.enable_knox_vision {
        if let Some(ref path) = args.knox_vision_path {
            tracing::info!("Knox-Vision integration enabled. Path: {}", path.display());
            // TODO: Add actual integration logic here (e.g., call knox-vision tool)
        } else {
            tracing::warn!("Knox-Vision integration enabled, but --knox-vision-path was not provided.");
        }
    }

    let start = Instant::now();

    tracing::info!("dexterity v{}", env!("CARGO_PKG_VERSION"));

    // Configure rayon thread pool BEFORE any rayon code runs
    // Note: build_global() can only be called once, so we set it early
    let num_threads = args.effective_threads();

    // First, try to configure via ThreadPoolBuilder (works if rayon isn't initialized yet)
    let config_result = rayon::ThreadPoolBuilder::new()
        .num_threads(num_threads)
        .build_global();

    match config_result {
        Ok(_) => {
            tracing::info!("Configured rayon with {} thread(s)", num_threads);
        }
        Err(_) => {
            // If build_global() fails, rayon is already initialized
            // Check if we got the requested thread count anyway
            let actual_threads = rayon::current_num_threads();
            if actual_threads != num_threads {
                tracing::warn!("Rayon already initialized with {} thread(s), but requested {}", actual_threads, num_threads);
                tracing::warn!("To use {} threads on next run, set: RAYON_NUM_THREADS={} dexterity [args]", num_threads, num_threads);
            } else {
                tracing::info!("Using existing rayon configuration with {} thread(s)", actual_threads);
            }
        }
    }

    tracing::info!(
        "Processing {} input file(s)",
        args.input.len()
    );

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
        "jar" | "zip" => {
            process_jar(input, &out_dir_src, args)?;
        }
        "aar" => {
            process_aar(input, &out_dir_src, &out_dir_res, args)?;
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

    // Export as Gradle project if requested
    if args.export_gradle {
        let project_name = input
            .file_stem()
            .map(|s| s.to_string_lossy().to_string())
            .unwrap_or_else(|| "app".to_string());

        gradle_export::export_gradle_project(
            &out_dir,
            &out_dir_src,
            &out_dir_res,
            args.export_gradle_type,
            &project_name,
        )?;
    }

    Ok(())
}

fn process_apk(input: &PathBuf, out_src: &PathBuf, out_res: &PathBuf, args: &Args) -> Result<()> {
    tracing::info!("Processing APK: {}", input.display());

    let file = std::fs::File::open(input)?;
    let mut archive = zip::ZipArchive::new(file)?;

    let mut dex_file_names = Vec::new();  // Only store names, not data
    let mut manifest_data: Option<Vec<u8>> = None;
    let mut arsc_data: Option<Vec<u8>> = None;
    let mut xml_resource_names: Vec<String> = Vec::new();  // Only store names
    let mut raw_file_count = 0;

    // First pass: Extract resources immediately, collect DEX file names
    for i in 0..archive.len() {
        let mut entry = archive.by_index(i)?;
        let name = entry.name().to_string();

        // Skip directories
        if name.ends_with('/') {
            continue;
        }

        if name.ends_with(".dex") {
            // Only store the name, we'll process it later
            dex_file_names.push(name);
        } else if name == "AndroidManifest.xml" {
            let mut data = Vec::new();
            entry.read_to_end(&mut data)?;
            manifest_data = Some(data);
        } else if name == "resources.arsc" {
            let mut data = Vec::new();
            entry.read_to_end(&mut data)?;
            arsc_data = Some(data);
        } else if name.starts_with("res/") && name.ends_with(".xml") {
            // Store name for later processing (need arsc first for resource name mappings)
            xml_resource_names.push(name);
        } else if !args.skip_resources && should_extract_raw_file(&name) {
            // Extract raw files IMMEDIATELY to avoid memory accumulation
            let out_path = out_res.join(&name);
            if let Some(parent) = out_path.parent() {
                std::fs::create_dir_all(parent)?;
            }
            let mut out_file = std::fs::File::create(&out_path)?;
            std::io::copy(&mut entry, &mut out_file)?;
            raw_file_count += 1;
        }
    }

    tracing::info!("Found {} DEX file(s), {} resource XMLs", dex_file_names.len(), xml_resource_names.len());

    // Process resources (ARSC + AXML)
    if !args.skip_resources {
        process_resources_streaming(out_res, manifest_data, arsc_data, &xml_resource_names, raw_file_count, input)?;
    }

    // Process source code (DEX) - one at a time to minimize memory
    if !args.skip_sources {
        let progress = create_progress_bar(args);
        let mut total_classes = 0;
        let mut total_errors = 0;

        // Create global field pool for multi-DEX deduplication
        // This mirrors Java JADX's InfoStorage behavior, ensuring that fields
        // with the same (class, name, type) are deduplicated across all DEX files
        let global_field_pool = Arc::new(GlobalFieldPool::new());
        tracing::debug!("Created global field pool for {} DEX files", dex_file_names.len());

        // Re-open archive to process DEX files one at a time
        drop(archive);
        let file = std::fs::File::open(input)?;
        let mut archive = zip::ZipArchive::new(file)?;

        for dex_name in &dex_file_names {
            tracing::debug!("Processing DEX: {}", dex_name);

            // Extract this DEX file
            let mut dex_data = Vec::new();
            let mut entry = archive.by_name(dex_name)?;
            entry.read_to_end(&mut dex_data)?;

            // Process it immediately
            match process_dex_bytes(&dex_data, out_src, args, progress.as_ref(), Arc::clone(&global_field_pool)) {
                Ok(count) => total_classes += count,
                Err(e) => {
                    tracing::warn!("Failed to process {}: {}", dex_name, e);
                    total_errors += 1;
                }
            }

            // Drop the DEX data before moving to next file
            drop(dex_data);
        }

        if let Some(pb) = progress {
            pb.finish_with_message("done");
        }

        let (field_count, _) = global_field_pool.stats();
        tracing::info!(
            "Processed {} classes from {} DEX files ({} errors, {} deduplicated fields)",
            total_classes,
            dex_file_names.len(),
            total_errors,
            field_count
        );
    }

    Ok(())
}

fn process_resources_streaming(
    out_res: &PathBuf,
    manifest_data: Option<Vec<u8>>,
    arsc_data: Option<Vec<u8>>,
    xml_resource_names: &[String],
    raw_file_count: usize,
    apk_path: &PathBuf,
) -> Result<()> {
    use jadx_resources::{ArscParser, AxmlParser};
    use std::collections::HashMap;

    tracing::info!("Processing resources ({} raw files)...", raw_file_count);

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

    // Process XML resources one at a time by re-opening the ZIP
    let xml_count = xml_resource_names.len();
    let mut xml_errors = 0;

    if !xml_resource_names.is_empty() {
        let file = std::fs::File::open(apk_path)?;
        let mut archive = zip::ZipArchive::new(file)?;

        for xml_name in xml_resource_names {
            // Extract this XML file
            let mut xml_data = Vec::new();
            match archive.by_name(xml_name) {
                Ok(mut entry) => {
                    entry.read_to_end(&mut xml_data)?;

                    // Parse it immediately
                    let mut axml_parser = AxmlParser::new();
                    axml_parser.set_res_names(res_names.clone());

                    match axml_parser.parse(&xml_data) {
                        Ok(xml) => {
                            // Normalize config qualifiers (remove redundant -v21 for anydpi, etc.)
                            let normalized_name = normalize_config_qualifier(xml_name);
                            let out_path = out_res.join(&normalized_name);
                            if let Some(parent) = out_path.parent() {
                                std::fs::create_dir_all(parent)?;
                            }
                            std::fs::write(&out_path, &xml)?;
                        }
                        Err(e) => {
                            tracing::debug!("Failed to parse {}: {}", xml_name, e);
                            xml_errors += 1;
                        }
                    }

                    // Drop the XML data before moving to next file
                    drop(xml_data);
                }
                Err(e) => {
                    tracing::warn!("Failed to extract {}: {}", xml_name, e);
                    xml_errors += 1;
                }
            }
        }
    }

    tracing::info!("Processed {} resource XMLs ({} errors)", xml_count, xml_errors);
    tracing::info!("Extracted {} raw files", raw_file_count);

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
    let global_field_pool = Arc::new(GlobalFieldPool::new());
    let count = process_dex_bytes(&data, out_src, args, progress.as_ref(), Arc::clone(&global_field_pool))?;

    if let Some(pb) = progress {
        pb.finish_with_message("done");
    }

    tracing::info!("Processed {} classes", count);
    Ok(())
}

/// Process a JAR file
///
/// JAR files may contain:
/// - DEX files (rare, but some Android builds include them)
/// - .class files (standard Java bytecode - requires conversion)
///
/// For .class files, we attempt to use D8/dx for conversion to DEX.
fn process_jar(input: &PathBuf, out_src: &PathBuf, args: &Args) -> Result<()> {
    tracing::info!("Processing JAR: {}", input.display());

    let file = std::fs::File::open(input)?;
    let mut archive = zip::ZipArchive::new(file)?;

    let mut dex_file_names: Vec<String> = Vec::new();
    let mut class_files: Vec<String> = Vec::new();

    // Scan JAR contents
    for i in 0..archive.len() {
        let mut entry = archive.by_index(i)?;
        let name = entry.name().to_string();

        if name.ends_with('/') {
            continue;
        }

        if name.ends_with(".dex") {
            // Found DEX file - just store the name
            dex_file_names.push(name);
        } else if name.ends_with(".class") && !name.contains("module-info") {
            // Track .class files
            class_files.push(name);
        }
    }

    tracing::info!(
        "JAR contains {} DEX file(s), {} class file(s)",
        dex_file_names.len(),
        class_files.len()
    );

    // Process any DEX files found - one at a time
    if !dex_file_names.is_empty() {
        let progress = create_progress_bar(args);
        let mut total_classes = 0;
        let global_field_pool = Arc::new(GlobalFieldPool::new());

        // Re-open archive to process DEX files one at a time
        drop(archive);
        let file = std::fs::File::open(input)?;
        let mut archive = zip::ZipArchive::new(file)?;

        for dex_name in &dex_file_names {
            tracing::debug!("Processing DEX: {}", dex_name);

            // Extract this DEX file
            let mut dex_data = Vec::new();
            let mut entry = archive.by_name(dex_name)?;
            entry.read_to_end(&mut dex_data)?;

            // Process it immediately
            match process_dex_bytes(&dex_data, out_src, args, progress.as_ref(), Arc::clone(&global_field_pool)) {
                Ok(count) => total_classes += count,
                Err(e) => tracing::warn!("Failed to process {}: {}", dex_name, e),
            }

            // Drop the DEX data before moving to next file
            drop(dex_data);
        }

        if let Some(pb) = progress {
            pb.finish_with_message("done");
        }

        tracing::info!("Processed {} classes from DEX files", total_classes);
    }

    // Handle .class files
    if !class_files.is_empty() && dex_file_names.is_empty() {
        // Try to find D8 or dx for conversion
        if let Some(converter) = find_dex_converter() {
            tracing::info!("Found DEX converter: {}", converter);
            convert_jar_to_dex(input, out_src, &converter, args)?;
        } else {
            tracing::warn!(
                "JAR contains {} .class files but no DEX converter found.",
                class_files.len()
            );
            tracing::warn!("To decompile Java bytecode (.class files), install Android SDK Build Tools");
            tracing::warn!("and ensure 'd8' or 'dx' is in your PATH.");
            tracing::warn!("");
            tracing::warn!("Alternatively, convert the JAR to DEX manually:");
            tracing::warn!("  d8 --output output.zip {}", input.display());
            tracing::warn!("  dexterity -d output/ output.zip");
        }
    }

    Ok(())
}

/// Process an AAR (Android Archive) file
///
/// AAR files contain:
/// - classes.jar (Java bytecode)
/// - AndroidManifest.xml (text format, not binary AXML)
/// - res/ (resources)
/// - libs/ (additional JARs)
/// - Optional DEX files
fn process_aar(input: &PathBuf, out_src: &PathBuf, out_res: &PathBuf, args: &Args) -> Result<()> {
    tracing::info!("Processing AAR: {}", input.display());

    let file = std::fs::File::open(input)?;
    let mut archive = zip::ZipArchive::new(file)?;

    let mut dex_file_names: Vec<String> = Vec::new();
    let mut jar_files: Vec<(String, Vec<u8>)> = Vec::new();
    let mut manifest_data: Option<Vec<u8>> = None;
    let mut resource_files: Vec<(String, Vec<u8>)> = Vec::new();

    // Extract AAR contents
    for i in 0..archive.len() {
        let mut entry = archive.by_index(i)?;
        let name = entry.name().to_string();

        if name.ends_with('/') {
            continue;
        }

        if name.ends_with(".dex") {
            // Only store the name, we'll process it later
            dex_file_names.push(name);
        } else if name.ends_with(".jar") {
            let mut data = Vec::new();
            entry.read_to_end(&mut data)?;
            jar_files.push((name, data));
        } else if name == "AndroidManifest.xml" {
            let mut data = Vec::new();
            entry.read_to_end(&mut data)?;
            manifest_data = Some(data);
        } else if name.starts_with("res/") {
            let mut data = Vec::new();
            entry.read_to_end(&mut data)?;
            resource_files.push((name, data));
        }
    }

    tracing::info!(
        "AAR contains {} DEX file(s), {} JAR file(s), {} resource file(s)",
        dex_file_names.len(),
        jar_files.len(),
        resource_files.len()
    );

    // Extract resources
    if !args.skip_resources {
        // Write AndroidManifest.xml (it's plain text in AAR, not binary AXML)
        if let Some(manifest) = manifest_data {
            let out_path = out_res.join("AndroidManifest.xml");
            std::fs::write(&out_path, &manifest)?;
            tracing::info!("Wrote AndroidManifest.xml ({} bytes)", manifest.len());
        }

        // Write resource files
        for (name, data) in &resource_files {
            let out_path = out_res.join(name);
            if let Some(parent) = out_path.parent() {
                std::fs::create_dir_all(parent)?;
            }
            std::fs::write(&out_path, data)?;
        }
        if !resource_files.is_empty() {
            tracing::info!("Extracted {} resource files", resource_files.len());
        }
    }

    // Process DEX files directly - one at a time
    if !args.skip_sources && !dex_file_names.is_empty() {
        let progress = create_progress_bar(args);
        let mut total_classes = 0;
        let global_field_pool = Arc::new(GlobalFieldPool::new());

        // Re-open archive to process DEX files one at a time
        drop(archive);
        let file = std::fs::File::open(input)?;
        let mut archive = zip::ZipArchive::new(file)?;

        for dex_name in &dex_file_names {
            tracing::debug!("Processing DEX: {}", dex_name);

            // Extract this DEX file
            let mut dex_data = Vec::new();
            let mut entry = archive.by_name(dex_name)?;
            entry.read_to_end(&mut dex_data)?;

            // Process it immediately
            match process_dex_bytes(&dex_data, out_src, args, progress.as_ref(), Arc::clone(&global_field_pool)) {
                Ok(count) => total_classes += count,
                Err(e) => tracing::warn!("Failed to process {}: {}", dex_name, e),
            }

            // Drop the DEX data before moving to next file
            drop(dex_data);
        }

        if let Some(pb) = progress {
            pb.finish_with_message("done");
        }

        tracing::info!("Processed {} classes from DEX files", total_classes);
    }

    // Process JAR files (typically classes.jar)
    if !args.skip_sources && !jar_files.is_empty() && dex_file_names.is_empty() {
        // Write JARs to temp files and process them
        let temp_dir = std::env::temp_dir().join("dexterity-aar");
        std::fs::create_dir_all(&temp_dir)?;

        for (name, data) in &jar_files {
            let jar_name = std::path::Path::new(name)
                .file_name()
                .unwrap_or_default()
                .to_string_lossy();
            let temp_jar = temp_dir.join(jar_name.as_ref());
            std::fs::write(&temp_jar, data)?;

            tracing::info!("Processing embedded JAR: {}", name);
            if let Err(e) = process_jar(&temp_jar, out_src, args) {
                tracing::warn!("Failed to process {}: {}", name, e);
            }

            // Clean up temp file
            let _ = std::fs::remove_file(&temp_jar);
        }

        // Clean up temp dir
        let _ = std::fs::remove_dir(&temp_dir);
    }

    Ok(())
}

/// Find a DEX converter (D8 or dx) in PATH
fn find_dex_converter() -> Option<String> {
    // Check for d8 first (modern, preferred)
    if std::process::Command::new("d8")
        .arg("--version")
        .output()
        .is_ok()
    {
        return Some("d8".to_string());
    }

    // Check for dx (legacy)
    if std::process::Command::new("dx")
        .arg("--version")
        .output()
        .is_ok()
    {
        return Some("dx".to_string());
    }

    None
}

/// Convert JAR to DEX using d8 or dx, then process the resulting DEX
fn convert_jar_to_dex(
    input: &PathBuf,
    out_src: &PathBuf,
    converter: &str,
    args: &Args,
) -> Result<()> {
    use std::process::Command;

    let temp_dir = std::env::temp_dir().join("dexterity-convert");
    std::fs::create_dir_all(&temp_dir)?;

    let output_zip = temp_dir.join("classes.zip");

    tracing::info!("Converting JAR to DEX using {}...", converter);

    let status = if converter == "d8" {
        Command::new("d8")
            .arg("--output")
            .arg(&output_zip)
            .arg(input)
            .status()?
    } else {
        // dx --dex --output=classes.zip input.jar
        Command::new("dx")
            .arg("--dex")
            .arg(format!("--output={}", output_zip.display()))
            .arg(input)
            .status()?
    };

    if !status.success() {
        anyhow::bail!("DEX conversion failed with exit code: {:?}", status.code());
    }

    tracing::info!("Conversion successful, processing DEX...");

    // Process the output ZIP (contains classes.dex)
    process_jar(&output_zip, out_src, args)?;

    // Clean up
    let _ = std::fs::remove_file(&output_zip);
    let _ = std::fs::remove_dir(&temp_dir);

    Ok(())
}

fn process_dex_bytes(
    data: &[u8],
    out_src: &PathBuf,
    args: &Args,
    progress: Option<&ProgressBar>,
    global_field_pool: Arc<GlobalFieldPool>,
) -> Result<usize> {
    mem_checkpoint!("before DexReader");

    // Wrap DexReader in Arc for sharing with LazyDexInfo
    // (DexReader already holds the bytes internally, no need to duplicate)
    let dex = std::sync::Arc::new(DexReader::from_slice(0, "input.dex".to_string(), data)?);

    mem_checkpoint!("after DexReader");

    let class_count = dex.header.class_defs_size as usize;
    let method_count = dex.header.method_ids_size as usize;

    tracing::info!(
        "DEX: {} classes, {} methods, {} strings",
        class_count,
        method_count,
        dex.header.string_ids_size
    );

    // Auto-detect huge obfuscated APKs and warn about memory usage
    // Heuristic: If avg methods/class > 50, it's likely obfuscated with huge classes
    let avg_methods_per_class = if class_count > 0 { method_count / class_count } else { 0 };
    if avg_methods_per_class > 50 {
        let current_threads = rayon::current_num_threads();
        tracing::warn!(
            "⚠️  LARGE APK DETECTED: {} methods/class average (obfuscated?)",
            avg_methods_per_class
        );
        tracing::warn!(
            "⚠️  Using {} threads may cause high memory usage (~10-20GB per thread)",
            current_threads
        );
        tracing::warn!(
            "⚠️  If you hit OOM, reduce to: --threads-count 2"
        );
    }

    // Create LazyDexInfo for name resolution during code generation
    // This is O(1) - no data is loaded upfront (lazy loading like Java JADX)
    // The global_field_pool enables deduplication of fields across all DEX files
    tracing::debug!("Creating lazy DEX info with global field pool for name resolution...");
    let dex_info = LazyDexInfo::new_with_pool(std::sync::Arc::clone(&dex), global_field_pool);
    tracing::debug!("LazyDexInfo ready (on-demand loading with global deduplication enabled)");

    // ========================================================================
    // OPTIMIZE: Pre-load strings to avoid RwLock contention in parallel phase
    // Only for small DEX files (<100k strings) to avoid memory explosion on huge APKs
    // ========================================================================
    let string_count = dex.header.string_ids_size as usize;
    const MAX_PRELOAD_STRINGS: usize = 100_000;
    if string_count > 0 && string_count <= MAX_PRELOAD_STRINGS {
        tracing::debug!("Pre-loading {} strings from DEX to avoid lock contention...", string_count);
        let preload_start = std::time::Instant::now();
        for idx in 0..string_count {
            let _ = dex.get_string(idx as u32);
        }
        let preload_elapsed = preload_start.elapsed();
        tracing::debug!("Strings pre-loaded in {:.2}ms", preload_elapsed.as_secs_f64() * 1000.0);
    } else if string_count > MAX_PRELOAD_STRINGS {
        tracing::debug!("Skipping string pre-load ({} strings > {} limit)", string_count, MAX_PRELOAD_STRINGS);
    }

    mem_checkpoint!("after string preload");

    if let Some(pb) = progress {
        pb.set_length(class_count as u64);
    }

    // ========================================================================
    // MEMORY-OPTIMIZED CLASS COLLECTION
    // Collect all class indices for processing - each class becomes a separate file
    // Pre-allocate vector based on class count to avoid reallocations
    // ========================================================================

    let mut class_indices: Vec<u32> = Vec::with_capacity(class_count);
    let mut outer_count = 0usize;
    let mut inner_count = 0usize;

    for (i, class_result) in dex.classes().enumerate() {
        match class_result {
            Ok(class) => {
                if let Ok(class_type) = class.class_type() {
                    let class_name = class_type.to_string();

                    // Apply filters
                    if let Some(ref single) = args.single_class {
                        if !class_name.contains(single) {
                            continue;
                        }
                    } else if should_skip_class(&class_name) {
                        continue;
                    }

                    // Track outer vs inner for logging
                    if class_name.contains('$') {
                        inner_count += 1;
                    } else {
                        outer_count += 1;
                    }

                    class_indices.push(i as u32);
                }
            }
            Err(e) => {
                tracing::warn!("Failed to parse class {}: {}", i, e);
            }
        }
    }

    let count = class_indices.len();
    tracing::info!("Processing {} classes ({} outer, {} inner)", count, outer_count, inner_count);

    mem_checkpoint!("before parallel processing");

    // ========================================================================
    // STREAMING PROCESSING (like Java JADX)
    // Process each class: convert -> generate -> write -> drop
    // This keeps memory bounded by batch size, not total class count
    // ========================================================================
    let start = Instant::now();
    let num_threads = rayon::current_num_threads();
    tracing::info!("Streaming processing with {} threads...", num_threads);

    // Wrap LazyDexInfo in Arc for sharing across threads
    let dex_info: std::sync::Arc<dyn DexInfoProvider> = std::sync::Arc::new(dex_info);

    // Create global alias registry for deobfuscation (used for cross-reference resolution)
    let alias_registry = std::sync::Arc::new(AliasRegistry::new());

    // Load ProGuard mapping file if provided
    if let Some(ref mapping_path) = args.mappings_path {
        if args.mappings_mode != crate::args::MappingsMode::Ignore {
            match std::fs::read_to_string(mapping_path) {
                Ok(content) => {
                    match parse_proguard_mapping(&content, &alias_registry) {
                        Ok(()) => {
                            tracing::info!(
                                "Loaded {} class, {} field, {} method mappings from {}",
                                alias_registry.class_count(),
                                alias_registry.field_count(),
                                alias_registry.method_count(),
                                mapping_path.display()
                            );
                        }
                        Err(e) => {
                            tracing::warn!("Failed to parse mapping file {}: {}", mapping_path.display(), e);
                        }
                    }
                }
                Err(e) => {
                    tracing::warn!("Failed to read mapping file {}: {}", mapping_path.display(), e);
                }
            }
        }
    }

    // Deterministic deobfuscation prepass (populate registry once, then apply per-class)
    if args.deobfuscation {
        tracing::info!(
            "Deobfuscation enabled (min={}, max={})",
            args.deobf_min_length,
            args.deobf_max_length
        );
        deobf::precompute_deobf_aliases(&dex, &class_indices, args, &alias_registry);
    }

    // Build class hierarchy for type inference (enables LCA, subtype checking)
    tracing::info!("Building class hierarchy from {} classes", class_indices.len());
    let hierarchy_start = std::time::Instant::now();
    let class_hierarchy = converter::build_class_hierarchy(&dex, &class_indices);
    tracing::info!(
        "Class hierarchy built in {:?} ({} classes)",
        hierarchy_start.elapsed(),
        class_hierarchy.has_class("java/lang/Object")
    );

    // Wrap dex_info with alias-aware version if deobfuscation or mappings are active
    let dex_info: std::sync::Arc<dyn DexInfoProvider> = if args.deobfuscation || args.mappings_path.is_some() {
        std::sync::Arc::new(AliasAwareDexInfo::new(dex_info, alias_registry.clone()))
    } else {
        dex_info
    };

    // NOTE: inner_to_outer and class_name_to_idx HashMaps were removed
    // as they were allocated but never used, wasting memory

    if let Some(pb) = progress {
        pb.set_length(count as u64);
    }

    // Pre-create directories (fetch class names on-demand)
    for &idx in &class_indices {
        if let Ok(class) = dex.get_class(idx) {
            if let Ok(class_type) = class.class_type() {
                let class_desc = class_type.to_string();
                let rel_path = deobf::class_output_rel_path(&class_desc, &alias_registry);
                let out_path = out_src.join(&rel_path);
                if let Some(parent) = out_path.parent() {
                    std::fs::create_dir_all(parent).ok();
                }
            }
        }
    }

    // Java JADX memory strategy: Batched parallel processing
    // See: jadx-fast/jadx-core/src/main/java/jadx/core/ProcessClass.java
    // Process classes in thread-safe batches: each thread gets N classes to process sequentially.
    // This balances parallelism (uses all cores) with memory safety (each thread processes one class at a time).
    // Memory stays bounded because only num_threads classes are in memory at once, not total count.

    let error_count = std::sync::atomic::AtomicUsize::new(0);
    let hierarchy_arc = std::sync::Arc::new(class_hierarchy);

    // Extract args values for parallel closure
    let debug_info = args.debug_info();
    let process_kotlin = args.process_kotlin_metadata();
    let use_imports = args.use_imports();
    let fallback_mode = args.effective_decompilation_mode() == DecompilationMode::Fallback;
    let escape_unicode = args.escape_unicode;
    let inline_anonymous = args.inline_anonymous();
    let add_debug_lines = args.add_debug_lines;
    let inline_methods = args.inline_methods();

    // Prepare progress bar for parallel use
    let progress_ref = progress.as_ref();

    // Process classes in parallel using rayon
    use rayon::prelude::*;
    // Dynamic chunk size: ensure at least 4 chunks per thread for good load balancing
    // For small APKs, use smaller chunks to utilize all threads
    let num_threads = rayon::current_num_threads();
    let chunk_size = std::cmp::max(1, class_indices.len() / (num_threads * 4));
    let chunk_size = std::cmp::min(chunk_size, 48); // Cap at 48 for memory reasons
    tracing::debug!("Using chunk size {} for {} classes across {} threads", chunk_size, class_indices.len(), num_threads);
    let processed_count = std::sync::atomic::AtomicUsize::new(0);
    class_indices.par_chunks(chunk_size).for_each(|chunk| {
        for &idx in chunk {
        // Memory checkpoint every 100 classes
        let pc = processed_count.fetch_add(1, std::sync::atomic::Ordering::Relaxed);
        if pc % 100 == 0 {
            eprintln!("MEM[class {}]: {} MB", pc, get_mem_mb());
        }
        // Fetch class name on-demand to avoid storing all names in memory
        let class_desc = dex.get_class(idx)
            .ok()
            .and_then(|c| c.class_type().ok().map(|t| t.to_string()))
            .unwrap_or_else(|| format!("LUnknownClass{};", idx));

        let out_path = {
            let rel_path = deobf::class_output_rel_path(&class_desc, &alias_registry);
            out_src.join(&rel_path)
        };

        // Convert class to IR
        let ir_result = std::panic::catch_unwind(std::panic::AssertUnwindSafe(|| {
            dex.get_class(idx)
                .map_err(|e| format!("Failed to get class: {}", e))
                .and_then(|class| {
                    converter::convert_class(&dex, &class, debug_info)
                        .map(|mut class_data| {
                            // Process Kotlin metadata annotations (extracts names)
                            if process_kotlin {
                                if let Err(e) = jadx_kotlin::process_kotlin_metadata(&mut class_data) {
                                    tracing::debug!("Kotlin metadata processing failed for {}: {}", class_desc, e);
                                }
                            }

                            // Apply aliases from deterministic prepass (if any)
                            deobf::apply_aliases_from_registry(&mut class_data, &alias_registry);
                            class_data
                        })
                        .map_err(|e| format!("Failed to convert: {}", e))
                })
        }))
        .unwrap_or_else(|_| Err(format!("Panic during conversion of {}", class_desc)));

        // Generate code
        let java_code = match ir_result {
            Ok(mut ir_class) => {
                // Load instructions before codegen
                for method in &mut ir_class.methods {
                    let _ = converter::load_method_instructions(method, &dex);
                }

                // Extract static field initializations
                jadx_passes::extract_field_init(&mut ir_class);

                let config = jadx_codegen::ClassGenConfig {
                    use_imports,
                    show_debug: false,
                    fallback: fallback_mode,
                    escape_unicode,
                    inline_anonymous,
                    add_debug_lines,
                    inline_methods,
                    hierarchy: Some(hierarchy_arc.clone()),
                };
                let dex_arc: std::sync::Arc<dyn jadx_codegen::DexInfoProvider> = dex_info.clone();
                let code = jadx_codegen::generate_class_with_inner_classes(
                    &ir_class,
                    &config,
                    Some(dex_arc),
                    None,
                );

                // Unload immediately after codegen to free memory
                ir_class.unload();
                code
            }
            Err(e) => {
                error_count.fetch_add(1, std::sync::atomic::Ordering::Relaxed);
                format!(
                    "// Failed to decompile: {}\nclass {} {{\n}}\n",
                    e,
                    class_desc.trim_start_matches('L').trim_end_matches(';').rsplit('/').next().unwrap_or("Unknown")
                )
            }
        };

        // Write to file
        if let Err(e) = std::fs::write(&out_path, java_code) {
            tracing::warn!("Failed to write {}: {}", out_path.display(), e);
            error_count.fetch_add(1, std::sync::atomic::Ordering::Relaxed);
        }

        if let Some(pb) = progress_ref {
            pb.inc(1);
        }
        }
    });

    if let Some(pb) = progress {
        pb.finish_with_message("done");
    }

    // Explicit cleanup - drop class_indices before returning
    drop(class_indices);

    let elapsed = start.elapsed();
    let errors = error_count.load(std::sync::atomic::Ordering::Relaxed);
    tracing::info!(
        "Processed {} classes ({} outer, {} inner) in {:.2}s ({} errors)",
        count,
        outer_count,
        inner_count,
        elapsed.as_secs_f64(),
        errors
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
    should_skip_class_full(class_name)
}

fn should_skip_class_full(class_name: &str) -> bool {
    // Filter approved framework and library prefixes
    const SKIP_PREFIXES: &[&str] = &[
        "Landroid/",
        "Landroidx/",
        "Lkotlin/",
        "Lkotlinx/",
        "Ljava/",
        "Ljavax/",
        "Lsun/",
        "Lcom/google/android/",
        "Lcom/android/internal/",
        "Lcom/android/support/",
    ];

    for prefix in SKIP_PREFIXES {
        if class_name.starts_with(prefix) {
            return true;
        }
    }

    // Filter generated code patterns
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
