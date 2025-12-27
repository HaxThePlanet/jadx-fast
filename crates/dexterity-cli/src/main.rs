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
mod zip_fallback;

use std::io::{Read, Seek};
use std::path::PathBuf;
use std::time::Instant;

use anyhow::{Context, Result};

// Use jemalloc for better performance on high-core systems
// THP (Transparent Huge Pages) reduces TLB misses for graph-heavy CFG workloads
// This gives 8.8% speedup at 56 cores (4.20s vs 4.57s)
// Note: background_thread was tested but HURT performance at 56 cores (15% slower)
#[cfg(not(target_env = "msvc"))]
use tikv_jemallocator::Jemalloc;

#[cfg(not(target_env = "msvc"))]
#[global_allocator]
static GLOBAL: Jemalloc = Jemalloc;

// Bake jemalloc THP config into binary - no MALLOC_CONF env var needed
#[cfg(not(target_env = "msvc"))]
#[export_name = "_rjem_malloc_conf"]
pub static JEMALLOC_CONF: &[u8] = b"metadata_thp:always,thp:always\0";

// Memory tracking for debugging
// Uses RSS (resident set size) instead of VSZ to measure actual physical memory
// VSZ includes swapped memory and can be inflated on systems under memory pressure
fn get_mem_mb() -> usize {
    std::fs::read_to_string("/proc/self/status")
        .ok()
        .and_then(|s| {
            s.lines()
                .find(|line| line.starts_with("VmRSS:"))?
                .split_whitespace()
                .nth(1)?
                .parse::<usize>()
                .ok()
        })
        .unwrap_or(0)
}

/// Build Kotlin intrinsics context from DEX for variable name extraction.
/// JADX Reference: ProcessKotlinInternals.java - extracts names from Intrinsics calls
/// This provides method signatures and string pool for looking up intrinsics calls.
fn build_intrinsics_context(dex: &DexReader) -> dexterity_passes::IntrinsicsContext {
    let mut ctx = dexterity_passes::IntrinsicsContext::new();

    // Build method signatures map: method_idx -> (class, name, proto)
    // We only need to populate entries for methods that might be Kotlin intrinsics
    let method_count = dex.header.method_ids_size;
    for idx in 0..method_count {
        if let Ok(method_id) = dex.get_method(idx) {
            if let (Ok(class), Ok(name)) = (method_id.class_type(), method_id.name()) {
                // Only store Kotlin intrinsics class methods to save memory
                if class == "Lkotlin/jvm/internal/Intrinsics;" {
                    // Build proto string: (params)return_type
                    let proto_str = method_id.proto()
                        .ok()
                        .map(|proto| {
                            let params = proto.parameters().unwrap_or_default().join("");
                            let ret = proto.return_type().unwrap_or_else(|_| "V".to_string());
                            format!("({}){}", params, ret)
                        })
                        .unwrap_or_default();
                    ctx.method_signatures.insert(idx, (class, name, proto_str));
                }
            }
        }
    }

    // Build string pool map: string_idx -> string value
    // Only load strings on demand when processing intrinsics calls
    let string_count = dex.header.string_ids_size;
    for idx in 0..string_count {
        if let Ok(s) = dex.get_string(idx) {
            ctx.string_pool.insert(idx, s.to_string());
        }
    }

    // field_constants left empty for now - requires class analysis
    // P1.3 FIX would need constant field resolution here

    tracing::debug!(
        "Built intrinsics context: {} method sigs, {} strings",
        ctx.method_signatures.len(),
        ctx.string_pool.len()
    );

    ctx
}

macro_rules! mem_checkpoint {
    ($msg:expr) => {
        eprintln!("MEM[{}]: {} MB", $msg, get_mem_mb());
    };
}
use clap::Parser;
use indicatif::{ProgressBar, ProgressStyle};

use dexterity_codegen::{LazyDexInfo, DexInfoProvider, AliasAwareDexInfo, GlobalFieldPool};
use dexterity_dex::DexReader;
use dexterity_kotlin;
use dexterity_deobf::{
    AliasRegistry, parse_proguard_mapping,
};
use std::sync::Arc;

pub use args::*;

// =============================================================================
// ZIP Security Functions (Anti-RE Hardening)
// Clone of JADX's JadxZipSecurity.java patterns
// =============================================================================

/// Validate ZIP entry name for path traversal attacks.
/// Blocks entries with "../" or "..\" that could escape extraction directory.
/// JADX Reference: JadxZipSecurity.java:52-70
fn validate_entry_name(name: &str) -> bool {
    !name.contains("../") &&
    !name.contains("..\\") &&
    !name.starts_with("/") &&
    !name.starts_with("\\")
}

/// Detect compression bombs by checking compression ratio.
/// Returns true if the entry appears to be a bomb (ratio > 100x, size > 25MB).
/// JADX Reference: JadxZipSecurity.java:81-92
fn is_compression_bomb(compressed: u64, uncompressed: u64) -> bool {
    const FACTOR: u64 = 100;
    const MIN_SIZE: u64 = 25 * 1024 * 1024; // 25MB threshold

    uncompressed >= MIN_SIZE && compressed > 0 && compressed * FACTOR < uncompressed
}

/// Read from a ZIP entry with size limit to prevent memory exhaustion.
/// Default limit: 100MB per entry.
#[allow(dead_code)]
fn read_entry_limited<R: std::io::Read>(
    entry: &mut R,
    max_bytes: usize,
    actual_size: u64,
) -> Result<Vec<u8>> {
    use std::io::Read;

    let limit = max_bytes.min(actual_size as usize);
    let mut buf = Vec::with_capacity(limit);
    entry.take(max_bytes as u64).read_to_end(&mut buf)?;
    Ok(buf)
}

/// Maximum uncompressed size per entry (100MB default, configurable via env)
fn get_max_entry_size() -> usize {
    std::env::var("DEXTERITY_MAX_ENTRY_SIZE_MB")
        .ok()
        .and_then(|s| s.parse::<usize>().ok())
        .unwrap_or(100) * 1024 * 1024
}

fn main() -> Result<()> {
    let args = Args::parse();

    // Handle --version (quick exit, no stack needed)
    if args.version {
        println!("dexterity {}", env!("CARGO_PKG_VERSION"));
        return Ok(());
    }

    // Run main logic on thread with configurable stack to handle deep CFG recursion
    // Override with DEXTERITY_MAIN_STACK_MB env var (default: 256MB)
    let main_stack = dexterity_limits::memory::main_stack_size();
    let result = std::thread::Builder::new()
        .stack_size(main_stack)
        .spawn(move || run_main(args))
        .expect("Failed to spawn main thread")
        .join()
        .expect("Main thread panicked");

    result
}

fn run_main(args: Args) -> Result<()> {
    // Initialize logging
    init_logging(&args);

    // Validate args
    args.validate()?;

    // Handle Knox-Vision integration if enabled
    if args.enable_knox_vision {
        if let Some(ref path) = args.knox_vision_path {
            tracing::info!("Knox-Vision integration enabled. Path: {}", path.display());
            // Knox-Vision integration point - configured via KNOX_VISION_PATH environment
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
    // Need large stack for deeply nested regions, expressions, and control flow structures
    // Large/obfuscated APKs can have 100+ levels of nesting across multiple recursion points
    // Override with DEXTERITY_THREAD_STACK_MB env var (default: 4096MB = 4GB)
    let worker_stack = dexterity_limits::memory::thread_stack_size();
    let worker_stack_mb = worker_stack / (1024 * 1024);
    let config_result = rayon::ThreadPoolBuilder::new()
        .num_threads(num_threads)
        .stack_size(worker_stack)
        .build_global();

    match config_result {
        Ok(_) => {
            tracing::info!("Configured rayon with {} thread(s), {}MB stack per thread", num_threads, worker_stack_mb);
        }
        Err(e) => {
            // If build_global() fails, rayon is already initialized with different settings
            // This happens if another library calls rayon before dexterity does
            tracing::warn!("Failed to configure rayon thread pool: {}", e);

            let actual_threads = rayon::current_num_threads();
            if actual_threads != num_threads {
                tracing::warn!("Rayon initialized by another library with {} thread(s), but dexterity requested {}", actual_threads, num_threads);
                tracing::warn!("To override, set environment variable: RAYON_NUM_THREADS={} dexterity [args]", num_threads);
            } else {
                tracing::info!("Using pre-initialized rayon configuration with {} thread(s)", actual_threads);
            }

            tracing::warn!("If you encounter stack overflow crashes, increase stack size with: RUST_MIN_STACK=33554432 dexterity [args]");
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
        "jar" => {
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

    // LLM Post-Processing: Add comments if requested
    if args.llm_add_comments {
        tracing::info!("Running LLM post-processing to add code comments...");
        let llm_start = std::time::Instant::now();

        // Create a Tokio runtime for async LLM processing
        let runtime = tokio::runtime::Runtime::new()?;
        if let Err(e) = runtime.block_on(add_llm_comments(&out_dir_src, args)) {
            tracing::warn!("LLM commenting failed: {}", e);
            tracing::warn!("Continuing with uncommented code...");
        } else {
            let llm_elapsed = llm_start.elapsed();
            tracing::info!("LLM commenting completed in {:.2}s", llm_elapsed.as_secs_f64());
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

async fn add_llm_comments(src_dir: &PathBuf, args: &Args) -> Result<()> {
    use dexterity_llm_postproc::{Config, LLMPostProcessor};
    use walkdir::WalkDir;

    // Build config from args and environment
    let mut config = Config::from_env()?;
    config.enable_code_commenting = true;
    config.enable_variable_renaming = false;
    config.enable_type_refinement = false;
    config.enable_code_correction = false;

    // Override backend/model if specified
    if let Some(ref backend) = args.llm_backend {
        config.backend = match backend.as_str() {
            "anthropic" => dexterity_llm_postproc::config::LLMBackend::Anthropic,
            "ollama" => dexterity_llm_postproc::config::LLMBackend::Ollama,
            _ => {
                tracing::warn!("Unknown backend '{}', using auto-detected backend", backend);
                config.backend
            }
        };
    }
    if let Some(ref model) = args.llm_model {
        config.model = model.clone();
    }

    let processor = LLMPostProcessor::new(config).await?;

    // Walk all .java files
    let java_files: Vec<_> = WalkDir::new(src_dir)
        .into_iter()
        .filter_map(|e| e.ok())
        .filter(|e| e.path().extension().map_or(false, |ext| ext == "java"))
        .collect();

    tracing::info!("Processing {} Java files...", java_files.len());

    // Process files sequentially to avoid rate limits with external services
    for entry in java_files {
        let path = entry.path();
        let content = std::fs::read_to_string(path)?;

        match processor.add_comments(&content).await {
            Ok(enhanced) => {
                std::fs::write(path, enhanced)?;
                tracing::debug!("Enhanced: {}", path.display());
            }
            Err(e) => {
                tracing::warn!("Failed to enhance {}: {}", path.display(), e);
            }
        }
    }

    Ok(())
}

fn process_apk(input: &PathBuf, out_src: &PathBuf, out_res: &PathBuf, args: &Args) -> Result<()> {
    tracing::info!("Processing APK: {}", input.display());

    let mut file = std::fs::File::open(input)?;

    // Fast validation: Check ZIP magic bytes to avoid hanging on non-ZIP files
    let mut magic = [0u8; 4];
    file.read_exact(&mut magic)?;
    file.seek(std::io::SeekFrom::Start(0))?;
    if magic[0..2] != [0x50, 0x4B] || (magic[2] != 0x03 && magic[2] != 0x05) {
        anyhow::bail!("Not a valid ZIP file (magic: {:02X}{:02X}{:02X}{:02X})",
            magic[0], magic[1], magic[2], magic[3]);
    }

    // Try standard ZIP parsing first; fall back to signature scanning on failure
    let archive_result = zip::ZipArchive::new(file);

    let mut archive = match archive_result {
        Ok(a) => a,
        Err(e) => {
            // Check if this is a recoverable error (EOCD/CD corruption)
            if zip_fallback::is_recoverable_zip_error(&e) {
                tracing::warn!("Standard ZIP parsing failed: {}. Attempting fallback recovery...", e);
                return process_apk_fallback(input, out_src, out_res, args);
            }
            return Err(e.into());
        }
    };

    // Security: Check Zip entries limit (Zip Bomb protection)
    let zip_limit = std::env::var("JADX_ZIP_MAX_ENTRIES_COUNT")
        .ok()
        .and_then(|s| s.parse().ok())
        .unwrap_or(100_000);
    
    if archive.len() > zip_limit {
        anyhow::bail!("Zip entries count limit reached: {} > {}. Use JADX_ZIP_MAX_ENTRIES_COUNT to increase.", archive.len(), zip_limit);
    }

    let mut dex_file_names = Vec::new();  // Only store names, not data
    let mut manifest_data: Option<Vec<u8>> = None;
    let mut arsc_data: Option<Vec<u8>> = None;
    let mut xml_resources: Vec<(String, Vec<u8>)> = Vec::new();  // Store name + data for parallel processing
    let mut raw_file_count = 0;

    // First pass: Extract all data in single ZIP traversal
    let max_entry_size = get_max_entry_size();
    let mut skipped_entries = 0usize;
    for i in 0..archive.len() {
        // P2-ZIP-ENCRYPTED/P2-ZIP-COMPRESSION: Skip encrypted or unsupported entries
        let mut entry = match archive.by_index(i) {
            Ok(e) => e,
            Err(e) => {
                if zip_fallback::is_skippable_entry_error(&e) {
                    skipped_entries += 1;
                    tracing::debug!("Skipping entry {}: {}", i, e);
                    continue;
                }
                return Err(e.into());
            }
        };
        let name = entry.name().to_string();

        // Skip directories
        if name.ends_with('/') {
            continue;
        }

        // Security: Path traversal detection (Anti-RE)
        if !validate_entry_name(&name) {
            tracing::warn!("SECURITY: Skipping entry with path traversal: {}", name);
            continue;
        }

        // Security: Compression bomb detection (Anti-RE)
        if is_compression_bomb(entry.compressed_size(), entry.size()) {
            tracing::warn!(
                "SECURITY: Skipping potential compression bomb: {} ({}B compressed -> {}B)",
                name, entry.compressed_size(), entry.size()
            );
            continue;
        }

        if name.ends_with(".dex") {
            // DEX header is 112 bytes minimum - skip fake/placeholder DEX files
            if entry.size() >= 112 {
                dex_file_names.push(name);
            } else {
                tracing::debug!("Skipping invalid DEX file {} ({} bytes < 112 byte header)", name, entry.size());
            }
        } else if name == "AndroidManifest.xml" {
            // P2-ZIP-ENCRYPTED/P2-ZIP-COMPRESSION: Use safe read
            if let Some(data) = zip_fallback::safe_read_entry(&mut entry, &name) {
                manifest_data = Some(data);
            } else {
                skipped_entries += 1;
            }
        } else if name == "resources.arsc" {
            // P2-ZIP-ENCRYPTED/P2-ZIP-COMPRESSION: Use safe read
            if let Some(data) = zip_fallback::safe_read_entry(&mut entry, &name) {
                arsc_data = Some(data);
            } else {
                skipped_entries += 1;
            }
        } else if name.starts_with("res/") && name.ends_with(".xml") {
            // Skip qualified resources (drawable-hdpi, values-en, etc.) unless --include-framework
            if !args.include_framework && is_qualified_resource_path(&name) {
                continue;
            }
            // P2-ZIP-ENCRYPTED/P2-ZIP-COMPRESSION: Use safe read
            if let Some(data) = zip_fallback::safe_read_entry(&mut entry, &name) {
                xml_resources.push((name, data));
            } else {
                skipped_entries += 1;
            }
        } else if !args.skip_resources && should_extract_raw_file(&name) {
            // Skip qualified resources (res/drawable-hdpi/*, etc.) unless --include-framework
            if !args.include_framework && is_qualified_resource_path(&name) {
                continue;
            }
            // Extract raw files immediately (ramdisk is fast)
            let normalized_name = normalize_config_qualifier(&name);
            let out_path = out_res.join(&normalized_name);
            if let Some(parent) = out_path.parent() {
                std::fs::create_dir_all(parent)?;
            }
            let mut out_file = std::fs::File::create(&out_path)?;
            // P2-ZIP-ENCRYPTED/P2-ZIP-COMPRESSION: Use safe copy
            if zip_fallback::safe_copy_entry(&mut entry, &mut out_file, &name) {
                raw_file_count += 1;
            } else {
                skipped_entries += 1;
                // Clean up empty file on failure
                let _ = std::fs::remove_file(&out_path);
            }
        }
    }

    if skipped_entries > 0 {
        tracing::warn!("Skipped {} encrypted/unsupported entries", skipped_entries);
    }
    tracing::info!("Found {} DEX file(s), {} resource XMLs", dex_file_names.len(), xml_resources.len());

    // Process resources (ARSC + AXML) with parallel XML processing
    let mut res_names: std::collections::HashMap<u32, String> = std::collections::HashMap::new();
    let mut app_package_name: Option<String> = None;
    if !args.skip_resources {
        let pretty_print = !args.no_xml_pretty_print;
        (res_names, app_package_name) = process_resources_parallel(out_res, manifest_data, arsc_data, xml_resources, raw_file_count, pretty_print, args.include_framework)?;
    }
    // Wrap res_names in Arc for efficient sharing across parallel class processing
    let res_names = Arc::new(res_names);
    let app_package_name = Arc::new(app_package_name);
    // P2-ENUM-CONSTANTS: Empty for now, will be populated from enum class analysis in future
    let enum_constants: Arc<std::collections::HashMap<String, std::collections::HashMap<i32, String>>> = Arc::new(std::collections::HashMap::new());

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

        // P1-DEOBF-MULTI-DEX: Create shared alias registry BEFORE processing any DEX files
        // This ensures consistent package/class/method aliases across all DEX files,
        // matching JADX's behavior of merging all classes into a single RootNode
        let alias_registry = std::sync::Arc::new(AliasRegistry::new());

        // Load ProGuard mapping once for all DEX files
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

        // PASS 1: If deobfuscation or Kotlin metadata is enabled, precompute aliases
        // across ALL DEX files before processing any of them
        let needs_deobf_prepass = args.deobf_enabled() || args.process_kotlin_metadata();
        if needs_deobf_prepass && dex_file_names.len() > 1 {
            tracing::info!("Multi-DEX deobfuscation: collecting classes from {} DEX files", dex_file_names.len());

            // Open archive for deobf prepass
            let file = std::fs::File::open(input)?;
            let mut archive = zip::ZipArchive::new(file)?;

            for (dex_idx, dex_name) in dex_file_names.iter().enumerate() {
                // P2-ZIP-ENCRYPTED/P2-ZIP-COMPRESSION: Handle unreadable DEX files
                let mut entry = match archive.by_name(dex_name) {
                    Ok(e) => e,
                    Err(e) => {
                        tracing::warn!("Skipping DEX {} (prepass): {}", dex_name, e);
                        continue;
                    }
                };
                let dex_data = match zip_fallback::safe_read_entry(&mut entry, dex_name) {
                    Some(data) => data,
                    None => {
                        tracing::warn!("Skipping unreadable DEX: {}", dex_name);
                        continue;
                    }
                };

                let dex = std::sync::Arc::new(DexReader::from_slice(dex_idx as u32, dex_name.clone(), &dex_data)?);
                let class_indices: Vec<u32> = (0..dex.header.class_defs_size).collect();

                if args.deobf_enabled() {
                    deobf::precompute_deobf_aliases(&dex, &class_indices, args, &alias_registry);
                }
                if args.process_kotlin_metadata() {
                    deobf::precompute_kotlin_aliases(&dex, &class_indices, &alias_registry);
                }

                // Run obfuscator detection on first DEX if requested
                if args.detect_obfuscators && dex_idx == 0 {
                    let report = deobf::detect_obfuscators(&dex, &class_indices, dex_name);
                    deobf::print_detection_report(&report);
                }

                drop(dex_data);
            }

            tracing::info!(
                "Multi-DEX deobfuscation complete: {} classes, {} methods, {} fields aliased",
                alias_registry.class_count(),
                alias_registry.method_count(),
                alias_registry.field_count()
            );
        }

        // PASS 2: Process each DEX file with the shared alias registry
        // Re-open archive to process DEX files one at a time
        let file = std::fs::File::open(input)?;
        let mut archive = zip::ZipArchive::new(file)?;

        // For multi-DEX with deobf enabled, aliases are already computed
        // For single-DEX or no deobf, let process_dex_bytes handle it
        let deobf_already_run = needs_deobf_prepass && dex_file_names.len() > 1;

        for (dex_idx, dex_name) in dex_file_names.iter().enumerate() {
            tracing::debug!("Processing DEX {}: {}", dex_idx, dex_name);

            // P2-ZIP-ENCRYPTED/P2-ZIP-COMPRESSION: Handle unreadable DEX files
            let mut entry = match archive.by_name(dex_name) {
                Ok(e) => e,
                Err(e) => {
                    tracing::warn!("Skipping DEX {}: {}", dex_name, e);
                    total_errors += 1;
                    continue;
                }
            };
            let dex_data = match zip_fallback::safe_read_entry(&mut entry, dex_name) {
                Some(data) => data,
                None => {
                    tracing::warn!("Skipping unreadable DEX: {}", dex_name);
                    total_errors += 1;
                    continue;
                }
            };

            // Process it immediately with the shared alias registry
            match process_dex_bytes(
                &dex_data,
                out_src,
                args,
                progress.as_ref(),
                Arc::clone(&global_field_pool),
                dex_idx as u32,
                dex_name,
                std::sync::Arc::clone(&res_names),
                std::sync::Arc::clone(&enum_constants),
                std::sync::Arc::clone(&app_package_name),
                std::sync::Arc::clone(&alias_registry),
                deobf_already_run,
            ) {
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

/// Fallback APK processing using signature-based ZIP recovery.
/// Called when standard ZIP parsing fails due to corrupted EOCD/central directory.
/// This enables processing of anti-RE malware APKs that intentionally corrupt ZIP metadata.
fn process_apk_fallback(input: &PathBuf, out_src: &PathBuf, out_res: &PathBuf, args: &Args) -> Result<()> {
    use zip_fallback::{scan_for_entries, recover_filename, decompress_entry, analyze_recovery};

    // Read entire file for signature scanning
    let data = std::fs::read(input)
        .context("Failed to read APK for fallback processing")?;

    // Analyze what we can recover
    let stats = analyze_recovery(&data);
    tracing::info!(
        "Fallback recovery: {} entries found, {} DEX files, manifest={}, resources={}",
        stats.total_entries,
        stats.dex_files,
        stats.manifest_found,
        stats.resources_found
    );

    if stats.total_entries == 0 {
        anyhow::bail!("Fallback recovery found no valid ZIP entries");
    }

    // Scan for all entries
    let headers = scan_for_entries(&data);

    let mut dex_entries: Vec<(String, Vec<u8>)> = Vec::new();
    let mut manifest_data: Option<Vec<u8>> = None;
    let mut arsc_data: Option<Vec<u8>> = None;
    let mut xml_resources: Vec<(String, Vec<u8>)> = Vec::new();
    let mut raw_file_count = 0;

    for header in &headers {
        // Get filename (try recovery if empty)
        let name = recover_filename(header).unwrap_or_else(|| format!("unknown_{:08x}", header.offset));

        // Security: Path traversal check
        if !validate_entry_name(&name) {
            tracing::warn!("SECURITY: Skipping entry with path traversal: {}", name);
            continue;
        }

        // Security: Compression bomb check
        if is_compression_bomb(header.compressed_size as u64, header.uncompressed_size as u64) {
            tracing::warn!(
                "SECURITY: Skipping potential compression bomb: {} ({}B -> {}B)",
                name, header.compressed_size, header.uncompressed_size
            );
            continue;
        }

        // Skip directories
        if name.ends_with('/') {
            continue;
        }

        // Try to decompress the entry
        let entry_data = match decompress_entry(&data, header) {
            Ok(d) => d,
            Err(e) => {
                tracing::debug!("Failed to decompress {}: {}", name, e);
                continue;
            }
        };

        // Categorize entry
        if name.ends_with(".dex") {
            // DEX header is 112 bytes minimum - skip fake/placeholder DEX files
            if entry_data.len() >= 112 {
                dex_entries.push((name, entry_data));
            } else {
                tracing::debug!("Skipping invalid DEX file {} ({} bytes < 112 byte header)", name, entry_data.len());
            }
        } else if name == "AndroidManifest.xml" {
            manifest_data = Some(entry_data);
        } else if name == "resources.arsc" {
            arsc_data = Some(entry_data);
        } else if name.starts_with("res/") && name.ends_with(".xml") {
            if !args.include_framework && is_qualified_resource_path(&name) {
                continue;
            }
            xml_resources.push((name, entry_data));
        } else if !args.skip_resources && should_extract_raw_file(&name) {
            if !args.include_framework && is_qualified_resource_path(&name) {
                continue;
            }
            let normalized_name = normalize_config_qualifier(&name);
            let out_path = out_res.join(&normalized_name);
            if let Some(parent) = out_path.parent() {
                std::fs::create_dir_all(parent)?;
            }
            std::fs::write(&out_path, entry_data)?;
            raw_file_count += 1;
        }
    }

    tracing::info!(
        "Fallback extracted: {} DEX files, {} XMLs, {} raw files",
        dex_entries.len(),
        xml_resources.len(),
        raw_file_count
    );

    // Process resources
    let mut res_names: std::collections::HashMap<u32, String> = std::collections::HashMap::new();
    let mut app_package_name: Option<String> = None;
    if !args.skip_resources {
        let pretty_print = !args.no_xml_pretty_print;
        (res_names, app_package_name) = process_resources_parallel(
            out_res,
            manifest_data,
            arsc_data,
            xml_resources,
            raw_file_count,
            pretty_print,
            args.include_framework,
        )?;
    }
    let res_names = Arc::new(res_names);
    let app_package_name = Arc::new(app_package_name);
    // P2-ENUM-CONSTANTS: Empty for now
    let enum_constants: Arc<std::collections::HashMap<String, std::collections::HashMap<i32, String>>> = Arc::new(std::collections::HashMap::new());

    // Process DEX files
    if !args.skip_sources && !dex_entries.is_empty() {
        let progress = create_progress_bar(args);
        let mut total_classes = 0;
        let mut total_errors = 0;

        let global_field_pool = Arc::new(GlobalFieldPool::new());

        // P1-DEOBF-MULTI-DEX: Create shared alias registry for all DEX files
        let alias_registry = std::sync::Arc::new(AliasRegistry::new());

        // Load ProGuard mapping once for all DEX files
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

        // PASS 1: Precompute deobfuscation aliases across all DEX files
        let needs_deobf_prepass = args.deobf_enabled() || args.process_kotlin_metadata();
        if needs_deobf_prepass && dex_entries.len() > 1 {
            tracing::info!("Multi-DEX deobfuscation (fallback): collecting classes from {} DEX files", dex_entries.len());

            for (dex_idx, (dex_name, dex_data)) in dex_entries.iter().enumerate() {
                let dex = std::sync::Arc::new(DexReader::from_slice(dex_idx as u32, dex_name.clone(), dex_data)?);
                let class_indices: Vec<u32> = (0..dex.header.class_defs_size).collect();

                if args.deobf_enabled() {
                    deobf::precompute_deobf_aliases(&dex, &class_indices, args, &alias_registry);
                }
                if args.process_kotlin_metadata() {
                    deobf::precompute_kotlin_aliases(&dex, &class_indices, &alias_registry);
                }
            }

            tracing::info!(
                "Multi-DEX deobfuscation complete: {} classes, {} methods, {} fields aliased",
                alias_registry.class_count(),
                alias_registry.method_count(),
                alias_registry.field_count()
            );
        }

        // PASS 2: Process each DEX file with shared alias registry
        let deobf_already_run = needs_deobf_prepass && dex_entries.len() > 1;

        for (dex_idx, (dex_name, dex_data)) in dex_entries.iter().enumerate() {
            tracing::debug!("Processing DEX {}: {}", dex_idx, dex_name);

            match process_dex_bytes(
                dex_data,
                out_src,
                args,
                progress.as_ref(),
                Arc::clone(&global_field_pool),
                dex_idx as u32,
                dex_name,
                Arc::clone(&res_names),
                Arc::clone(&enum_constants),
                Arc::clone(&app_package_name),
                Arc::clone(&alias_registry),
                deobf_already_run,
            ) {
                Ok(count) => total_classes += count,
                Err(e) => {
                    tracing::warn!("Failed to process {}: {}", dex_name, e);
                    total_errors += 1;
                }
            }
        }

        if let Some(pb) = progress {
            pb.finish_with_message("done");
        }

        let (field_count, _) = global_field_pool.stats();
        tracing::info!(
            "Fallback processed {} classes from {} DEX files ({} errors, {} fields)",
            total_classes,
            dex_entries.len(),
            total_errors,
            field_count
        );
    }

    Ok(())
}

#[allow(dead_code)]
fn process_resources_streaming(
    out_res: &PathBuf,
    manifest_data: Option<Vec<u8>>,
    arsc_data: Option<Vec<u8>>,
    xml_resource_names: &[String],
    raw_file_count: usize,
    apk_path: &PathBuf,
    pretty_print: bool,
) -> Result<(std::collections::HashMap<u32, String>, Option<String>)> {
    use dexterity_resources::{ArscParser, AxmlParser};
    use std::collections::HashMap;

    tracing::info!("Processing resources ({} raw files)...", raw_file_count);

    // Parse resources.arsc first to get resource name mappings
    let mut res_names: HashMap<u32, String> = HashMap::new();
    let mut path_mappings: HashMap<String, String> = HashMap::new();
    let mut app_package_name: Option<String> = None;
    if let Some(ref data) = arsc_data {
        tracing::debug!("Parsing resources.arsc ({} bytes)", data.len());
        let mut arsc_parser = ArscParser::new();
        match arsc_parser.parse(data) {
            Ok(()) => {
                res_names = arsc_parser.get_res_names();
                path_mappings = arsc_parser.get_path_mappings();
                app_package_name = arsc_parser.get_package_name();
                tracing::info!("Parsed {} resource entries ({} path mappings)", res_names.len(), path_mappings.len());

                // Generate values/*.xml files
                let res_dir = out_res.join("res");
                let values_dir = res_dir.join("values");
                std::fs::create_dir_all(&values_dir)?;

                let values_files = arsc_parser.generate_values_xml();
                let values_count = values_files.len();
                for (filename, content) in values_files {
                    // Handle filenames that may include subdirectories (e.g., "values-af/strings.xml")
                    let out_path = if filename.contains('/') {
                        // File is in a subdirectory like "values-af/strings.xml"
                        let full_path = res_dir.join(&filename);
                        if let Some(parent) = full_path.parent() {
                            std::fs::create_dir_all(parent)?;
                        }
                        full_path
                    } else {
                        // File is in the base values directory
                        values_dir.join(&filename)
                    };
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
        axml_parser.set_pretty_print(pretty_print);

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
            // Extract this XML file - P2-ZIP-ENCRYPTED/P2-ZIP-COMPRESSION safe read
            let xml_data = match archive.by_name(xml_name) {
                Ok(mut entry) => {
                    match zip_fallback::safe_read_entry(&mut entry, xml_name) {
                        Some(data) => data,
                        None => {
                            xml_errors += 1;
                            continue;
                        }
                    }
                }
                Err(e) => {
                    tracing::warn!("Failed to extract {}: {}", xml_name, e);
                    xml_errors += 1;
                    continue;
                }
            };

            // Parse it immediately
            let mut axml_parser = AxmlParser::new();
            axml_parser.set_res_names(res_names.clone());
            axml_parser.set_pretty_print(pretty_print);

            match axml_parser.parse(&xml_data) {
                Ok(xml) => {
                    // Normalize config qualifiers (remove redundant -v21 for anydpi, etc.)
                    let normalized_name = normalize_config_qualifier(xml_name);
                    // Apply resource name mapping if available (JADX compatibility)
                    let final_name = apply_resource_path_mapping(&normalized_name, &path_mappings);
                    let out_path = out_res.join(&final_name);
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
        }
    }

    tracing::info!("Processed {} resource XMLs ({} errors)", xml_count, xml_errors);
    tracing::info!("Extracted {} raw files", raw_file_count);

    Ok((res_names, app_package_name))
}

/// Process resources with parallel XML parsing
fn process_resources_parallel(
    out_res: &PathBuf,
    manifest_data: Option<Vec<u8>>,
    arsc_data: Option<Vec<u8>>,
    xml_resources: Vec<(String, Vec<u8>)>,
    raw_file_count: usize,
    pretty_print: bool,
    include_framework: bool,
) -> Result<(std::collections::HashMap<u32, String>, Option<String>)> {
    use dexterity_resources::{ArscParser, AxmlParser};
    use rayon::prelude::*;
    use std::collections::HashMap;

    tracing::info!("Processing resources ({} raw files, {} XMLs)...", raw_file_count, xml_resources.len());

    // Parse resources.arsc first to get resource name mappings
    let mut res_names: HashMap<u32, String> = HashMap::new();
    let mut path_mappings: HashMap<String, String> = HashMap::new();
    let mut app_package_name: Option<String> = None;

    if let Some(ref data) = arsc_data {
        tracing::debug!("Parsing resources.arsc ({} bytes)", data.len());
        let mut arsc_parser = ArscParser::new();
        match arsc_parser.parse(data) {
            Ok(()) => {
                res_names = arsc_parser.get_res_names();
                path_mappings = arsc_parser.get_path_mappings();
                app_package_name = arsc_parser.get_package_name();
                tracing::info!("Parsed {} resource entries", res_names.len());

                // Generate values/*.xml files (already parallel internally)
                let res_dir = out_res.join("res");
                let values_dir = res_dir.join("values");
                std::fs::create_dir_all(&values_dir)?;

                let values_files = arsc_parser.generate_values_xml();

                // Filter out qualified values directories (values-en, values-hdpi, etc.)
                // unless --include-framework is set
                let values_files: Vec<_> = if include_framework {
                    values_files.into_iter().collect()
                } else {
                    values_files.into_iter().filter(|(filename, _)| {
                        // Keep files in base values/ dir or files without path separator
                        if let Some(slash_pos) = filename.find('/') {
                            let dir_name = &filename[..slash_pos];
                            // Skip if directory has qualifier (contains '-')
                            !dir_name.contains('-')
                        } else {
                            true // No path separator, keep it
                        }
                    }).collect()
                };
                let values_count = values_files.len();

                // Write values files in parallel
                values_files.par_iter().for_each(|(filename, content)| {
                    let out_path = if filename.contains('/') {
                        let full_path = res_dir.join(filename);
                        if let Some(parent) = full_path.parent() {
                            std::fs::create_dir_all(parent).ok();
                        }
                        full_path
                    } else {
                        values_dir.join(filename)
                    };
                    std::fs::write(&out_path, content).ok();
                });
                tracing::info!("Generated {} values XML files", values_count);
            }
            Err(e) => {
                tracing::warn!("Failed to parse resources.arsc: {}", e);
            }
        }
    }

    // Parse and write AndroidManifest.xml
    if let Some(data) = manifest_data {
        let mut axml_parser = AxmlParser::new();
        axml_parser.set_res_names(res_names.clone());
        axml_parser.set_pretty_print(pretty_print);

        match axml_parser.parse(&data) {
            Ok(xml) => {
                let out_path = out_res.join("AndroidManifest.xml");
                std::fs::write(&out_path, &xml)?;
                tracing::info!("Wrote AndroidManifest.xml");
            }
            Err(e) => {
                tracing::warn!("Failed to parse AndroidManifest.xml: {}", e);
            }
        }
    }

    // Process XML resources in parallel
    let xml_count = xml_resources.len();
    if !xml_resources.is_empty() {
        let res_names_arc = std::sync::Arc::new(res_names.clone());
        let path_mappings_arc = std::sync::Arc::new(path_mappings);
        let out_res_arc = std::sync::Arc::new(out_res.clone());

        let errors = std::sync::atomic::AtomicUsize::new(0);

        xml_resources.par_iter().for_each(|(name, data)| {
            let mut axml_parser = AxmlParser::new();
            axml_parser.set_res_names((*res_names_arc).clone());
            axml_parser.set_pretty_print(pretty_print);

            match axml_parser.parse(data) {
                Ok(xml) => {
                    let normalized_name = normalize_config_qualifier(name);
                    let final_name = apply_resource_path_mapping(&normalized_name, &path_mappings_arc);
                    let out_path = out_res_arc.join(&final_name);
                    if let Some(parent) = out_path.parent() {
                        std::fs::create_dir_all(parent).ok();
                    }
                    std::fs::write(&out_path, &xml).ok();
                }
                Err(_) => {
                    errors.fetch_add(1, std::sync::atomic::Ordering::Relaxed);
                }
            }
        });

        let xml_errors = errors.load(std::sync::atomic::Ordering::Relaxed);
        tracing::info!("Processed {} resource XMLs ({} errors)", xml_count, xml_errors);
    }

    tracing::info!("Extracted {} raw files", raw_file_count);
    Ok((res_names, app_package_name))
}

fn process_dex(input: &PathBuf, out_src: &PathBuf, args: &Args) -> Result<()> {
    tracing::info!("Processing DEX: {}", input.display());

    let data = std::fs::read(input)?;
    let progress = create_progress_bar(args);
    let global_field_pool = Arc::new(GlobalFieldPool::new());
    let dex_name = input.file_name().and_then(|n| n.to_str()).unwrap_or("classes.dex");
    let res_names = Arc::new(std::collections::HashMap::new()); // DEX files don't have resources
    let enum_constants: Arc<std::collections::HashMap<String, std::collections::HashMap<i32, String>>> = Arc::new(std::collections::HashMap::new());
    let app_package_name = Arc::new(None); // DEX files don't have ARSC resources
    let alias_registry = std::sync::Arc::new(AliasRegistry::new()); // Single DEX file, let process_dex_bytes handle deobf
    let count = process_dex_bytes(&data, out_src, args, progress.as_ref(), Arc::clone(&global_field_pool), 0, dex_name, Arc::clone(&res_names), Arc::clone(&enum_constants), Arc::clone(&app_package_name), alias_registry, false)?;

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

    let mut file = std::fs::File::open(input)?;

    // Fast validation: Check ZIP magic bytes to avoid hanging on non-ZIP files
    let mut magic = [0u8; 4];
    file.read_exact(&mut magic)?;
    file.seek(std::io::SeekFrom::Start(0))?;
    if magic[0..2] != [0x50, 0x4B] || (magic[2] != 0x03 && magic[2] != 0x05) {
        anyhow::bail!("Not a valid ZIP file (magic: {:02X}{:02X}{:02X}{:02X})",
            magic[0], magic[1], magic[2], magic[3]);
    }

    let mut archive = zip::ZipArchive::new(file)?;

    let mut dex_file_names: Vec<String> = Vec::new();
    let mut class_files: Vec<String> = Vec::new();

    // Scan JAR contents
    for i in 0..archive.len() {
        // P2-ZIP-ENCRYPTED/P2-ZIP-COMPRESSION: Skip encrypted or unsupported entries
        let entry = match archive.by_index(i) {
            Ok(e) => e,
            Err(e) => {
                if zip_fallback::is_skippable_entry_error(&e) {
                    tracing::debug!("Skipping JAR entry {}: {}", i, e);
                    continue;
                }
                return Err(e.into());
            }
        };
        let name = entry.name().to_string();

        if name.ends_with('/') {
            continue;
        }

        if name.ends_with(".dex") {
            // DEX header is 112 bytes minimum - skip fake/placeholder DEX files
            if entry.size() >= 112 {
                dex_file_names.push(name);
            } else {
                tracing::debug!("Skipping invalid DEX file {} ({} bytes < 112 byte header)", name, entry.size());
            }
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

        // P1-DEOBF-MULTI-DEX: Create shared alias registry for all DEX files in JAR
        let alias_registry = std::sync::Arc::new(AliasRegistry::new());
        let empty_res_names = Arc::new(std::collections::HashMap::new());
        let empty_enum_constants: Arc<std::collections::HashMap<String, std::collections::HashMap<i32, String>>> = Arc::new(std::collections::HashMap::new());
        let empty_package_name = Arc::new(None);

        // PASS 1: Precompute deobfuscation aliases across all DEX files
        let needs_deobf_prepass = args.deobf_enabled() || args.process_kotlin_metadata();
        if needs_deobf_prepass && dex_file_names.len() > 1 {
            tracing::info!("Multi-DEX deobfuscation (JAR): collecting classes from {} DEX files", dex_file_names.len());

            drop(archive);
            let file = std::fs::File::open(input)?;
            let mut archive = zip::ZipArchive::new(file)?;

            for (dex_idx, dex_name) in dex_file_names.iter().enumerate() {
                // P2-ZIP-ENCRYPTED/P2-ZIP-COMPRESSION: Handle unreadable DEX files
                let mut entry = match archive.by_name(dex_name) {
                    Ok(e) => e,
                    Err(e) => {
                        tracing::warn!("Skipping DEX {} (prepass): {}", dex_name, e);
                        continue;
                    }
                };
                let dex_data = match zip_fallback::safe_read_entry(&mut entry, dex_name) {
                    Some(data) => data,
                    None => {
                        tracing::warn!("Skipping unreadable DEX: {}", dex_name);
                        continue;
                    }
                };

                let dex = std::sync::Arc::new(DexReader::from_slice(dex_idx as u32, dex_name.clone(), &dex_data)?);
                let class_indices: Vec<u32> = (0..dex.header.class_defs_size).collect();

                if args.deobf_enabled() {
                    deobf::precompute_deobf_aliases(&dex, &class_indices, args, &alias_registry);
                }
                if args.process_kotlin_metadata() {
                    deobf::precompute_kotlin_aliases(&dex, &class_indices, &alias_registry);
                }

                drop(dex_data);
            }

            tracing::info!(
                "Multi-DEX deobfuscation complete: {} classes, {} methods, {} fields aliased",
                alias_registry.class_count(),
                alias_registry.method_count(),
                alias_registry.field_count()
            );
        }

        // PASS 2: Process each DEX file with shared alias registry
        let deobf_already_run = needs_deobf_prepass && dex_file_names.len() > 1;

        let file = std::fs::File::open(input)?;
        let mut archive = zip::ZipArchive::new(file)?;

        for (dex_idx, dex_name) in dex_file_names.iter().enumerate() {
            tracing::debug!("Processing DEX {}: {}", dex_idx, dex_name);

            // P2-ZIP-ENCRYPTED/P2-ZIP-COMPRESSION: Handle unreadable DEX files
            let mut entry = match archive.by_name(dex_name) {
                Ok(e) => e,
                Err(e) => {
                    tracing::warn!("Skipping DEX {}: {}", dex_name, e);
                    continue;
                }
            };
            let dex_data = match zip_fallback::safe_read_entry(&mut entry, dex_name) {
                Some(data) => data,
                None => {
                    tracing::warn!("Skipping unreadable DEX: {}", dex_name);
                    continue;
                }
            };

            // Process it immediately - JAR DEX files have no resource mappings
            match process_dex_bytes(&dex_data, out_src, args, progress.as_ref(), Arc::clone(&global_field_pool), dex_idx as u32, dex_name, Arc::clone(&empty_res_names), Arc::clone(&empty_enum_constants), Arc::clone(&empty_package_name), Arc::clone(&alias_registry), deobf_already_run) {
                Ok(count) => total_classes += count,
                Err(e) => tracing::warn!("Failed to process {}: {}", dex_name, e),
            }
        }

        if let Some(pb) = progress {
            pb.finish_with_message("done");
        }

        tracing::info!("Processed {} classes from DEX files", total_classes);
    }

    // Handle .class files
    if !class_files.is_empty() && dex_file_names.is_empty() {
        // Try to find D8 or dx for conversion (only if --use-dx is enabled)
        if args.use_dx {
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
        } else {
            tracing::info!(
                "JAR contains {} .class files. Use --use-dx to enable automatic conversion to DEX.",
                class_files.len()
            );
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

    let mut file = std::fs::File::open(input)?;

    // Fast validation: Check ZIP magic bytes to avoid hanging on non-ZIP files
    let mut magic = [0u8; 4];
    file.read_exact(&mut magic)?;
    file.seek(std::io::SeekFrom::Start(0))?;
    if magic[0..2] != [0x50, 0x4B] || (magic[2] != 0x03 && magic[2] != 0x05) {
        anyhow::bail!("Not a valid ZIP file (magic: {:02X}{:02X}{:02X}{:02X})",
            magic[0], magic[1], magic[2], magic[3]);
    }

    let mut archive = zip::ZipArchive::new(file)?;

    let mut dex_file_names: Vec<String> = Vec::new();
    let mut jar_files: Vec<(String, Vec<u8>)> = Vec::new();
    let mut manifest_data: Option<Vec<u8>> = None;
    let mut resource_files: Vec<(String, Vec<u8>)> = Vec::new();

    // Extract AAR contents
    for i in 0..archive.len() {
        // P2-ZIP-ENCRYPTED/P2-ZIP-COMPRESSION: Skip encrypted or unsupported entries
        let mut entry = match archive.by_index(i) {
            Ok(e) => e,
            Err(e) => {
                if zip_fallback::is_skippable_entry_error(&e) {
                    tracing::debug!("Skipping AAR entry {}: {}", i, e);
                    continue;
                }
                return Err(e.into());
            }
        };
        let name = entry.name().to_string();

        if name.ends_with('/') {
            continue;
        }

        if name.ends_with(".dex") {
            // DEX header is 112 bytes minimum - skip fake/placeholder DEX files
            if entry.size() >= 112 {
                dex_file_names.push(name);
            } else {
                tracing::debug!("Skipping invalid DEX file {} ({} bytes < 112 byte header)", name, entry.size());
            }
        } else if name.ends_with(".jar") {
            // P2-ZIP-ENCRYPTED/P2-ZIP-COMPRESSION: Use safe read
            if let Some(data) = zip_fallback::safe_read_entry(&mut entry, &name) {
                jar_files.push((name, data));
            }
        } else if name == "AndroidManifest.xml" {
            // P2-ZIP-ENCRYPTED/P2-ZIP-COMPRESSION: Use safe read
            if let Some(data) = zip_fallback::safe_read_entry(&mut entry, &name) {
                manifest_data = Some(data);
            }
        } else if name.starts_with("res/") {
            // P2-ZIP-ENCRYPTED/P2-ZIP-COMPRESSION: Use safe read
            if let Some(data) = zip_fallback::safe_read_entry(&mut entry, &name) {
                resource_files.push((name, data));
            }
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

        // P1-DEOBF-MULTI-DEX: Create shared alias registry for all DEX files in AAR
        let alias_registry = std::sync::Arc::new(AliasRegistry::new());
        let empty_res_names = Arc::new(std::collections::HashMap::new());
        let empty_enum_constants: Arc<std::collections::HashMap<String, std::collections::HashMap<i32, String>>> = Arc::new(std::collections::HashMap::new());
        let empty_package_name = Arc::new(None);

        // PASS 1: Precompute deobfuscation aliases across all DEX files
        let needs_deobf_prepass = args.deobf_enabled() || args.process_kotlin_metadata();
        if needs_deobf_prepass && dex_file_names.len() > 1 {
            tracing::info!("Multi-DEX deobfuscation (AAR): collecting classes from {} DEX files", dex_file_names.len());

            drop(archive);
            let file = std::fs::File::open(input)?;
            let mut archive = zip::ZipArchive::new(file)?;

            for (dex_idx, dex_name) in dex_file_names.iter().enumerate() {
                // P2-ZIP-ENCRYPTED/P2-ZIP-COMPRESSION: Handle unreadable DEX files
                let mut entry = match archive.by_name(dex_name) {
                    Ok(e) => e,
                    Err(e) => {
                        tracing::warn!("Skipping DEX {} (prepass): {}", dex_name, e);
                        continue;
                    }
                };
                let dex_data = match zip_fallback::safe_read_entry(&mut entry, dex_name) {
                    Some(data) => data,
                    None => {
                        tracing::warn!("Skipping unreadable DEX: {}", dex_name);
                        continue;
                    }
                };

                let dex = std::sync::Arc::new(DexReader::from_slice(dex_idx as u32, dex_name.clone(), &dex_data)?);
                let class_indices: Vec<u32> = (0..dex.header.class_defs_size).collect();

                if args.deobf_enabled() {
                    deobf::precompute_deobf_aliases(&dex, &class_indices, args, &alias_registry);
                }
                if args.process_kotlin_metadata() {
                    deobf::precompute_kotlin_aliases(&dex, &class_indices, &alias_registry);
                }

                drop(dex_data);
            }

            tracing::info!(
                "Multi-DEX deobfuscation complete: {} classes, {} methods, {} fields aliased",
                alias_registry.class_count(),
                alias_registry.method_count(),
                alias_registry.field_count()
            );
        }

        // PASS 2: Process each DEX file with shared alias registry
        let deobf_already_run = needs_deobf_prepass && dex_file_names.len() > 1;

        let file = std::fs::File::open(input)?;
        let mut archive = zip::ZipArchive::new(file)?;

        for (dex_idx, dex_name) in dex_file_names.iter().enumerate() {
            tracing::debug!("Processing DEX {}: {}", dex_idx, dex_name);

            // P2-ZIP-ENCRYPTED/P2-ZIP-COMPRESSION: Handle unreadable DEX files
            let mut entry = match archive.by_name(dex_name) {
                Ok(e) => e,
                Err(e) => {
                    tracing::warn!("Skipping DEX {}: {}", dex_name, e);
                    continue;
                }
            };
            let dex_data = match zip_fallback::safe_read_entry(&mut entry, dex_name) {
                Some(data) => data,
                None => {
                    tracing::warn!("Skipping unreadable DEX: {}", dex_name);
                    continue;
                }
            };

            // Process it immediately - AAR DEX files have no resource mappings
            match process_dex_bytes(&dex_data, out_src, args, progress.as_ref(), Arc::clone(&global_field_pool), dex_idx as u32, dex_name, Arc::clone(&empty_res_names), Arc::clone(&empty_enum_constants), Arc::clone(&empty_package_name), Arc::clone(&alias_registry), deobf_already_run) {
                Ok(count) => total_classes += count,
                Err(e) => tracing::warn!("Failed to process {}: {}", dex_name, e),
            }
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
    dex_idx: u32,
    dex_name: &str,
    res_names: std::sync::Arc<std::collections::HashMap<u32, String>>,
    enum_constants: std::sync::Arc<std::collections::HashMap<String, std::collections::HashMap<i32, String>>>,
    app_package_name: std::sync::Arc<Option<String>>,
    alias_registry: std::sync::Arc<AliasRegistry>,
    deobf_already_run: bool,
) -> Result<usize> {
    mem_checkpoint!("before DexReader");

    // Wrap DexReader in Arc for sharing with LazyDexInfo
    // (DexReader already holds the bytes internally, no need to duplicate)
    let dex = std::sync::Arc::new(DexReader::from_slice(dex_idx, dex_name.to_string(), data)?);

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
    tracing::debug!("Creating lazy DEX info with GlobalFieldPool enabled...");
    let dex_info = LazyDexInfo::new_with_pool(std::sync::Arc::clone(&dex), global_field_pool);
    tracing::debug!("LazyDexInfo ready (on-demand loading, field deduplication enabled)");

    // ========================================================================
    // OPTIMIZE: Parallel string pre-loading using DashMap's lock-free concurrency
    // With DashMap, multiple threads can populate the cache simultaneously without
    // contention, making parallel pre-loading much faster than sequential.
    // Only for DEX files with <100k strings to avoid memory explosion on huge APKs.
    // ========================================================================
    // OPTIMIZATION: Chunked string pre-loading for large files
    // Previously disabled pre-loading for >100K strings to avoid memory explosion.
    // New approach: Pre-load in chunks so we get parallelism benefits while keeping
    // memory bounded. Each chunk of 100K strings is pre-loaded in parallel, then
    // memory can be reclaimed before the next chunk.
    let string_count = dex.header.string_ids_size as usize;
    const CHUNK_SIZE: usize = 100_000;

    if string_count > 0 {
        tracing::debug!("Pre-loading {} strings from DEX in parallel (chunked)...", string_count);
        let preload_start = std::time::Instant::now();

        // Process strings in chunks to handle large files while bounding memory
        for chunk_start in (0..string_count as u32).step_by(CHUNK_SIZE) {
            let chunk_end = std::cmp::min(chunk_start + CHUNK_SIZE as u32, string_count as u32);
            // Parallel pre-loading using rayon - DashMap handles concurrent inserts efficiently
            (chunk_start..chunk_end).into_par_iter().for_each(|idx| {
                let _ = dex.get_string(idx);
            });
        }

        let preload_elapsed = preload_start.elapsed();
        tracing::debug!("Strings pre-loaded in {:.2}ms (parallel, chunked)", preload_elapsed.as_secs_f64() * 1000.0);
    }

    mem_checkpoint!("after string preload");

    if let Some(pb) = progress {
        pb.set_length(class_count as u64);
    }

    // ========================================================================
    // CLASS COLLECTION - Two-pass for proper inner class detection
    // Pass 1: Collect all class names to build existence set
    // Pass 2: Determine inner vs outer (inner class must have existing parent)
    //
    // P0-SYNTHETIC FIX: Classes like ComposableSingletons$MainActivityKt should be
    // treated as outer classes because ComposableSingletons doesn't exist in DEX.
    // This matches JADX's RootNode.initInnerClasses() behavior.
    // ========================================================================

    let mut class_indices: Vec<u32> = Vec::with_capacity(class_count);
    let mut class_descs: rustc_hash::FxHashMap<u32, String> = rustc_hash::FxHashMap::default();
    let mut outer_class_indices: Vec<u32> = Vec::with_capacity(class_count);
    let mut inner_class_map: rustc_hash::FxHashMap<String, Vec<(u32, String)>> = rustc_hash::FxHashMap::default();
    let mut outer_count = 0usize;
    let mut inner_count = 0usize;

    // Pass 1: Collect all class names into a set for existence checking
    let mut all_class_names: rustc_hash::FxHashSet<String> = rustc_hash::FxHashSet::default();
    let mut filtered_classes: Vec<(u32, String)> = Vec::with_capacity(class_count);

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
                    } else if !args.include_framework && should_skip_class(&class_name) {
                        continue;
                    }

                    all_class_names.insert(class_name.clone());
                    filtered_classes.push((i as u32, class_name));
                }
            }
            Err(e) => {
                tracing::warn!("Failed to parse class {}: {}", i, e);
            }
        }
    }

    // Pass 2: Determine inner vs outer with parent existence validation
    for (idx, class_name) in filtered_classes {
        // Check if this could be an inner class (has $ in name)
        let is_inner = dexterity_codegen::is_inner_class(&class_name);
        let mut treat_as_outer = !is_inner;

        if is_inner {
            // JADX Parity: Only treat as inner class if the parent class actually exists
            // If parent doesn't exist, this is a top-level class with $ in its name
            // (e.g., Kotlin synthetic classes like ComposableSingletons$MainActivityKt)
            if let Some(outer) = dexterity_codegen::get_outer_class(&class_name) {
                if all_class_names.contains(&outer) {
                    // Parent exists - this is a true inner class
                    inner_count += 1;
                    inner_class_map.entry(outer).or_default().push((idx, class_name.clone()));
                } else {
                    // Parent doesn't exist - treat as outer class (P0-SYNTHETIC fix)
                    treat_as_outer = true;
                    tracing::debug!("Class {} has no parent {} in DEX, treating as outer", class_name, outer);
                }
            } else {
                treat_as_outer = true;
            }
        }

        // JADX Reference: ClassGen.java:158-160 - skip DONT_GENERATE classes
        // Lambda classes should be inlined at invoke-custom call sites, not output as files.
        // D8/R8 generates $$ExternalSyntheticLambda, older toolchains generate $$Lambda$,
        // Kotlin Compose generates $lambda-N$1 classes.
        if dexterity_codegen::is_lambda_class(&class_name) {
            tracing::debug!("Skipping lambda class: {}", class_name);
            continue; // Skip - lambda will be inlined at use site
        }

        if treat_as_outer {
            outer_count += 1;
            outer_class_indices.push(idx);
        }

        class_descs.insert(idx, class_name);
        class_indices.push(idx);
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

    // Note: alias_registry is now passed in from caller to enable multi-DEX sharing

    // Load ProGuard mapping file if provided (only if not already loaded at APK level)
    if !deobf_already_run {
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
        if args.deobf_enabled() {
            tracing::info!(
                "Deobfuscation enabled (min={}, max={})",
                args.deobf_min_length,
                args.deobf_max_length
            );
            deobf::precompute_deobf_aliases(&dex, &class_indices, args, &alias_registry);
        }

        // Kotlin metadata prepass: extract class aliases for cross-reference resolution
        // This runs even when deobfuscation is disabled, as Kotlin classes may have
        // obfuscated names (by R8/ProGuard) with aliases stored in @kotlin.Metadata
        if args.process_kotlin_metadata() {
            deobf::precompute_kotlin_aliases(&dex, &class_indices, &alias_registry);
        }

        // Run obfuscator detection if requested
        if args.detect_obfuscators {
            let report = deobf::detect_obfuscators(&dex, &class_indices, dex_name);
            deobf::print_detection_report(&report);
        }
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

    // Wrap dex_info with alias-aware version if deobfuscation, mappings, or Kotlin metadata is active
    // Kotlin metadata may register class aliases that need to be resolved during code generation
    let dex_info: std::sync::Arc<dyn DexInfoProvider> = if args.deobf_enabled() || args.mappings_path.is_some() || args.process_kotlin_metadata() {
        std::sync::Arc::new(AliasAwareDexInfo::new(dex_info, alias_registry.clone()))
    } else {
        dex_info
    };

    // P2-ENUM-CONSTANTS: Build enum ordinal->name mapping for enum constant replacement
    // This enables replacing integer literals (0, 1, 2) with enum constants (MyEnum.VALUE_A)
    // when the expected type is an enum class.
    let enum_constants_start = std::time::Instant::now();
    let mut enum_constants_map: std::collections::HashMap<String, std::collections::HashMap<i32, String>> = std::collections::HashMap::new();
    let mut enum_count = 0usize;
    for &idx in &class_indices {
        if let Ok(raw_class) = dex.get_class(idx) {
            if let Ok(mut class) = converter::convert_class(&dex, &raw_class, args.debug_info(), dex_idx, Some(dex_name)) {
                if class.is_enum() {
                    // Load <clinit> method instructions (required for enum analysis)
                    for method in class.methods.iter_mut() {
                        if method.name == "<clinit>" {
                            let _ = converter::load_method_instructions(method, &dex);
                            break;
                        }
                    }

                    // Analyze enum to get ordinal->name mapping
                    let dex_clone = std::sync::Arc::clone(&dex);
                    if let Some(info) = dexterity_passes::analyze_enum_class_with_strings(
                        &class,
                        Some(move |idx: u32| dex_clone.get_string(idx).ok().map(|s| s.to_string())),
                    ) {
                        // Build ordinal map for this enum class
                        let mut ordinal_map: std::collections::HashMap<i32, String> = std::collections::HashMap::new();
                        for field in &info.fields {
                            ordinal_map.insert(field.ordinal, field.name.clone());
                        }
                        if !ordinal_map.is_empty() {
                            // Normalize class type: strip L prefix and ; suffix
                            let normalized = class.class_type.strip_prefix('L').unwrap_or(&class.class_type)
                                .strip_suffix(';').unwrap_or(&class.class_type);
                            enum_constants_map.insert(normalized.to_string(), ordinal_map);
                            enum_count += 1;
                        }
                    }
                }
            }
        }
    }
    let enum_constants = Arc::new(enum_constants_map);
    tracing::info!(
        "Enum constant mapping built in {:?} ({} enums)",
        enum_constants_start.elapsed(),
        enum_count
    );

    // inner_class_map and outer_class_indices were built in the optimized single-pass loop above
    tracing::info!(
        "Processing {} outer classes ({} inner classes will be nested)",
        outer_class_indices.len(),
        inner_count
    );

    // Share the inner class map across threads
    let inner_class_map = std::sync::Arc::new(inner_class_map);

    if let Some(pb) = progress {
        pb.set_length(outer_class_indices.len() as u64);
    }

    // OPTIMIZATION: Parallelize directory creation using pre-computed class_descs
    // No redundant dex.get_class() or to_string() calls needed
    tracing::debug!("Pre-creating {} output directories in parallel...", class_indices.len());
    let class_descs_arc = std::sync::Arc::new(class_descs);
    class_indices.par_iter().for_each(|&idx| {
        if let Some(class_desc) = class_descs_arc.get(&idx) {
            let rel_path = deobf::class_output_rel_path(class_desc, &alias_registry);
            let out_path = out_src.join(&rel_path);
            if let Some(parent) = out_path.parent() {
                std::fs::create_dir_all(parent).ok();
            }
        }
    });

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
    let deobfuscation = args.deobf_enabled();
    let fs_case_sensitive = args.fs_case_sensitive;
    let use_kotlin_var_names = args.use_kotlin_methods_for_var_names();

    // Build Kotlin intrinsics context for variable name extraction
    // JADX Reference: ProcessKotlinInternals.java - extracts names from Intrinsics calls
    // Only build if not disabled - this scans all method IDs in the DEX
    let intrinsics_ctx = if use_kotlin_var_names != KotlinVarNamesMode::Disable {
        tracing::debug!("Building Kotlin intrinsics context (mode: {:?})", use_kotlin_var_names);
        let ctx = build_intrinsics_context(&dex);
        tracing::debug!("Intrinsics context: {} method signatures, {} strings",
            ctx.method_signatures.len(), ctx.string_pool.len());
        Some(Arc::new(ctx))
    } else {
        None
    };

    // Create shared alias provider for rename validation (thread-safe atomic counters)
    // JADX Reference: RenameVisitor uses IAliasProvider for collision renaming
    let rename_alias_provider = std::sync::Arc::new(
        dexterity_deobf::DeobfAliasProvider::new(args.deobf_max_length)
    );

    // Prepare progress bar for parallel use
    let progress_ref = progress.as_ref();

    // Process classes in parallel using rayon
    use rayon::prelude::*;
    // OPTIMIZATION: Use rayon's native work-stealing instead of fixed chunking
    // This provides better load balancing when classes have vastly different complexity.
    // Instead of processing 16 classes per chunk (which can leave threads idle if a chunk
    // contains expensive classes), let rayon's work-stealing queue distribute work on-demand.
    // Result: Eliminates load imbalance on obfuscated APKs with giant classes.
    let num_threads = rayon::current_num_threads();
    tracing::debug!("Using work-stealing load balancing for {} outer classes across {} threads", outer_class_indices.len(), num_threads);
    let processed_count = std::sync::atomic::AtomicUsize::new(0);

    // Process only outer classes - inner classes are nested inside
    outer_class_indices.par_iter().for_each(|&idx| {
        // Memory checkpoint every 1000 classes (reduced from 100 to minimize syscall overhead)
        let pc = processed_count.fetch_add(1, std::sync::atomic::Ordering::Relaxed);

        // Use pre-computed class_desc from single-pass loop (eliminates redundant dex lookup + to_string)
        let class_desc = class_descs_arc.get(&idx)
            .map(|s| s.as_str())
            .unwrap_or("LUnknownClass;");

        // Log every class in debug mode or single-threaded mode for hang debugging
        if num_threads == 1 || (pc > 1000 && pc < 2000) {
            tracing::debug!("Processing class[{}]: {}", pc, class_desc);
        }

        if pc % 1000 == 0 { // Reduced frequency for better parallel scaling
            let mem = get_mem_mb();
            eprintln!("MEM[class {}]: {} MB", pc, mem);
            // Memory limit check disabled - memory growth investigation complete
        }

        let out_path = {
            let rel_path = deobf::class_output_rel_path(&class_desc, &alias_registry);
            out_src.join(&rel_path)
        };

        // Convert class to IR
        let ir_result = std::panic::catch_unwind(std::panic::AssertUnwindSafe(|| {
            dex.get_class(idx)
                .map_err(|e| format!("Failed to get class: {}", e))
                .and_then(|class| {
                    converter::convert_class(&dex, &class, debug_info, dex_idx, Some(dex_name))
                        .map(|mut class_data| {
                            // Process Kotlin metadata annotations (extracts names)
                            if process_kotlin {
                                if let Err(e) = dexterity_kotlin::process_kotlin_metadata(&mut class_data, Some(&dex)) {
                                    tracing::debug!("Kotlin metadata processing failed for {}: {}", class_desc, e);
                                }
                                // Register Kotlin-derived field/method aliases into the registry
                                // so AliasAwareDexInfo.get_field() can look them up during codegen
                                deobf::register_kotlin_aliases(&class_data, &alias_registry);
                            }

                            // Apply aliases from deterministic prepass (if any)
                            deobf::apply_aliases_from_registry(&mut class_data, &alias_registry);

                            // P1-RENAME-VALIDATION: Apply per-class rename validation
                            // JADX Reference: RenameVisitor.checkFields() and checkMethods()
                            // This validates and fixes field/method names within the class
                            if deobfuscation {
                                dexterity_passes::validate_class_names(
                                    &mut class_data,
                                    rename_alias_provider.as_ref(),
                                    true,  // rename_valid: check for valid Java identifiers
                                    true,  // rename_printable: check for printable characters
                                );
                            }

                            class_data
                        })
                        .map_err(|e| format!("Failed to convert: {}", e))
                })
        }))
        .unwrap_or_else(|_| Err(format!("Panic during conversion of {}", class_desc)));

        // Convert inner classes to IR (if any)
        let nested_inner_classes: Vec<dexterity_ir::ClassData> = inner_class_map
            .get(class_desc)
            .map(|inners| {
                inners.iter().filter_map(|(inner_idx, _inner_desc)| {
                    std::panic::catch_unwind(std::panic::AssertUnwindSafe(|| {
                        dex.get_class(*inner_idx)
                            .ok()
                            .and_then(|inner_class| {
                                converter::convert_class(&dex, &inner_class, debug_info, dex_idx, Some(dex_name))
                                    .ok()
                                    .map(|mut inner_data| {
                                        // Process Kotlin metadata
                                        if process_kotlin {
                                            let _ = dexterity_kotlin::process_kotlin_metadata(&mut inner_data, Some(&dex));
                                            // Register Kotlin aliases into registry
                                            deobf::register_kotlin_aliases(&inner_data, &alias_registry);
                                        }
                                        // Apply aliases
                                        deobf::apply_aliases_from_registry(&mut inner_data, &alias_registry);

                                        // P1-RENAME-VALIDATION: Apply per-class rename validation for inner classes
                                        if deobfuscation {
                                            dexterity_passes::validate_class_names(
                                                &mut inner_data,
                                                rename_alias_provider.as_ref(),
                                                true,
                                                true,
                                            );
                                        }

                                        // Load instructions
                                        for method in &mut inner_data.methods {
                                            let _ = converter::load_method_instructions(method, &dex);
                                        }

                                        // Kotlin Intrinsics name extraction for inner classes
                                        if let Some(ref ctx) = intrinsics_ctx {
                                            let options = dexterity_passes::kotlin_intrinsics::KotlinIntrinsicsOptions {
                                                hide_intrinsics: use_kotlin_var_names == KotlinVarNamesMode::ApplyAndHide,
                                            };
                                            for method in &mut inner_data.methods {
                                                dexterity_passes::process_kotlin_intrinsics_with_options(method, ctx, &options);
                                            }
                                        }

                                        // Extract field initializations
                                        dexterity_passes::extract_field_init(&mut inner_data, Some(&dex));
                                        dexterity_passes::extract_instance_field_init(&mut inner_data, Some(&dex));
                                        inner_data
                                    })
                            })
                    }))
                    .ok()
                    .flatten()
                }).collect()
            })
            .unwrap_or_default();

        // Generate code
        let (java_code, final_out_path) = match ir_result {
            Ok(mut ir_class) => {
                // Recalculate output path using Kotlin metadata pkg_alias if available
                let actual_out_path = if ir_class.pkg_alias.is_some() || ir_class.alias.is_some() {
                    let rel = deobf::class_output_rel_path_with_kotlin(
                        &class_desc,
                        &alias_registry,
                        ir_class.pkg_alias.as_deref(),
                        ir_class.alias.as_deref(),
                    );
                    out_src.join(&rel)
                } else {
                    out_path.clone()
                };

                // Load instructions before codegen
                for method in &mut ir_class.methods {
                    let _ = converter::load_method_instructions(method, &dex);
                }

                // Stage: Kotlin Intrinsics name extraction (JADX ProcessKotlinInternals)
                // Extracts parameter names from Intrinsics.checkNotNullParameter() calls
                // JADX Reference: ProcessKotlinInternals.java:107-137
                if let Some(ref ctx) = intrinsics_ctx {
                    let options = dexterity_passes::kotlin_intrinsics::KotlinIntrinsicsOptions {
                        hide_intrinsics: use_kotlin_var_names == KotlinVarNamesMode::ApplyAndHide,
                    };
                    for method in &mut ir_class.methods {
                        dexterity_passes::process_kotlin_intrinsics_with_options(method, ctx, &options);
                    }
                }

                // P1-LAMBDA: Mark synthetic lambda methods for non-generation
                // JADX Ref: CustomLambdaCall.java:97-102 - marks synthetic lambdas with DONT_GENERATE
                converter::mark_synthetic_lambda_methods(&mut ir_class);

                // Extract static field initializations from <clinit>
                dexterity_passes::extract_field_init(&mut ir_class, Some(&dex));
                // Extract instance field initializations from constructors
                dexterity_passes::extract_instance_field_init(&mut ir_class, Some(&dex));

                // Run deobfuscation passes if enabled
                if args.has_deobf_passes() {
                    let deobf_config = args.get_deobf_config();
                    for method in &mut ir_class.methods {
                        let _ = dexterity_passes::run_deobf_passes(method, &deobf_config);
                    }
                }

                // P3-FIXACCESSMODIFIERS: Fix visibility for inner class access patterns
                // When inner classes access private members of outer classes, JADX removes
                // synthetic accessors and inlines the access. For recompilable code, the
                // accessed member must be at least package-private.
                if !nested_inner_classes.is_empty() {
                    converter::fix_inner_class_visibility(&mut ir_class, &nested_inner_classes, &dex);
                }

                // Convert CLI CommentsLevel to codegen CommentsLevel
                let comments_level = match args.comments_level {
                    crate::args::CommentsLevel::None => dexterity_codegen::CommentsLevel::None,
                    crate::args::CommentsLevel::UserOnly => dexterity_codegen::CommentsLevel::UserOnly,
                    crate::args::CommentsLevel::Error => dexterity_codegen::CommentsLevel::Error,
                    crate::args::CommentsLevel::Warn => dexterity_codegen::CommentsLevel::Warn,
                    crate::args::CommentsLevel::Info => dexterity_codegen::CommentsLevel::Info,
                    crate::args::CommentsLevel::Debug => dexterity_codegen::CommentsLevel::Debug,
                };
                let config = dexterity_codegen::ClassGenConfig {
                    use_imports,
                    show_debug: false,
                    fallback: fallback_mode,
                    escape_unicode,
                    inline_anonymous,
                    add_debug_lines,
                    inline_methods,
                    hierarchy: Some(hierarchy_arc.clone()),
                    deobf_min_length: args.deobf_min_length,
                    deobf_max_length: args.deobf_max_length,
                    res_names: std::sync::Arc::clone(&res_names),
                    replace_consts: args.replace_consts(),
                    enum_constants: std::sync::Arc::clone(&enum_constants),
                    app_package_name: (*app_package_name).clone(),
                    comments_level,
                };
                let dex_arc: std::sync::Arc<dyn dexterity_codegen::DexInfoProvider> = dex_info.clone();

                // Wrap codegen in catch_unwind to handle SKIP limits
                let nested_slice = if nested_inner_classes.is_empty() {
                    None
                } else {
                    Some(nested_inner_classes.as_slice())
                };
                let codegen_result = std::panic::catch_unwind(std::panic::AssertUnwindSafe(|| {
                    dexterity_codegen::generate_class_with_nested_inner_classes(
                        &ir_class,
                        &config,
                        Some(dex_arc),
                        None,
                        nested_slice,
                    )
                }));

                let code = match codegen_result {
                    Ok(c) => c,
                    Err(payload) => {
                        let msg = if let Some(s) = payload.downcast_ref::<&str>() {
                            s.to_string()
                        } else if let Some(s) = payload.downcast_ref::<String>() {
                            s.clone()
                        } else {
                            "Unknown panic".to_string()
                        };

                        if msg.starts_with("SKIP:") {
                            tracing::warn!("Method processing skipped in {}: {}", class_desc, msg);
                            format!("// {}\nclass {} {{}}\n", msg, class_desc.trim_start_matches('L').trim_end_matches(';').rsplit('/').next().unwrap_or("Unknown"))
                        } else {
                            error_count.fetch_add(1, std::sync::atomic::Ordering::Relaxed);
                            tracing::error!("Decompilation failed in {}: {}", class_desc, msg);
                            format!("// Decompilation failed: {}\nclass {} {{}}\n", msg, class_desc.trim_start_matches('L').trim_end_matches(';').rsplit('/').next().unwrap_or("Unknown"))
                        }
                    }
                };

                // Unload immediately after codegen to free memory
                ir_class.unload();
                (code, actual_out_path)
            }
            Err(e) => {
                error_count.fetch_add(1, std::sync::atomic::Ordering::Relaxed);
                (format!(
                    "// Failed to decompile: {}\nclass {} {{\n}}\n",
                    e,
                    class_desc.trim_start_matches('L').trim_end_matches(';').rsplit('/').next().unwrap_or("Unknown")
                ), out_path.clone())
            }
        };

        // Create parent directory if using Kotlin metadata path (may differ from pre-created dirs)
        if let Some(parent) = final_out_path.parent() {
            std::fs::create_dir_all(parent).ok();
        }

        // Write to file
        if let Err(e) = std::fs::write(&final_out_path, &java_code) {
            tracing::warn!("Failed to write {}: {}", final_out_path.display(), e);
            error_count.fetch_add(1, std::sync::atomic::Ordering::Relaxed);
        }

        // OPTIMIZATION: Batch progress bar updates to reduce mutex contention
        // Update every 10 classes instead of every single class to reduce lock contention
        if let Some(pb) = progress_ref {
            if (pc + 1) % 10 == 0 {
                pb.inc(10);
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

    // Save JOBF file if deobfuscation is enabled and mode allows saving
    if args.deobf_enabled() {
        let should_save = match args.deobf_cfg_file_mode {
            crate::args::DeobfCfgFileMode::ReadOrSave | crate::args::DeobfCfgFileMode::Overwrite => true,
            _ => false,
        };
        if should_save {
            let jobf_path = args.deobf_cfg_file.clone().unwrap_or_else(|| {
                // Default: output directory with deobf.jobf name
                out_src.join("deobf.jobf")
            });
            if let Err(e) = deobf::save_jobf_file(&jobf_path, &alias_registry) {
                tracing::warn!("Failed to save JOBF file {}: {}", jobf_path.display(), e);
            }
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
        "Lcom/google/",
        "Lcom/android/internal/",
        "Lcom/android/support/",
        "Lcom/facebook/",
        "Lcom/twitter/",
        "Lcom/unity3d/",
        "Lokhttp3/",
        "Lokio/",
        "Lretrofit2/",
        "Lio/reactivex/",
        "Lrx/",
        "Lorg/intellij/",
        "Lorg/jetbrains/",
        "Lcom/appsflyer/",   // AppsFlyer SDK
        "Lcom/revenuecat/",  // RevenueCat SDK
        "Lzendesk/",         // Zendesk SDK
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

// NOTE: build_dex_info() was removed - replaced by LazyDexInfo for memory efficiency
// LazyDexInfo loads strings/types/fields/methods on-demand instead of upfront

/// Normalize config qualifier by removing redundant API version suffixes.
/// Follows JADX behavior: strips version qualifiers when implied by other qualifiers.
/// E.g., "drawable-hdpi-v4" -> "drawable-hdpi" (density implies v4+)
///       "mipmap-anydpi-v21" -> "mipmap-anydpi" (anydpi implies v21)
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

    // The second component is the resource type + config (e.g., "drawable-hdpi-v4")
    let type_config = parts[1];

    // Apply JADX-style normalization rules:
    // 1. anydpi implies v21 (API 21+)
    // 2. density qualifiers (ldpi, mdpi, hdpi, xhdpi, xxhdpi, xxxhdpi, tvdpi, nodpi) imply v4
    // 3. standalone version qualifiers (layout-v21, drawable-v21) are stripped
    //    because JADX doesn't add version qualifiers when it's the only qualifier
    let normalized = {
        let mut result = type_config.to_string();

        // Strip -v21 from anydpi (anydpi was introduced in API 21)
        if result.contains("anydpi-v21") {
            result = result.replace("-v21", "");
        }

        // Strip -v4 from density qualifiers (density support was added in API 4 / Donut)
        // Only strip -v4, not higher versions which may indicate specific requirements
        if result.ends_with("-v4") {
            let has_density = result.contains("-ldpi")
                || result.contains("-mdpi")
                || result.contains("-hdpi")
                || result.contains("-xhdpi")
                || result.contains("-xxhdpi")
                || result.contains("-xxxhdpi")
                || result.contains("-tvdpi")
                || result.contains("-nodpi");
            if has_density {
                result = result.trim_end_matches("-v4").to_string();
            }
        }

        // Strip standalone version qualifiers (e.g., layout-v21 -> layout)
        // JADX doesn't add version qualifiers when it's the only qualifier
        // This regex-like pattern matches "type-vN" where N is a number
        if let Some(hyphen_idx) = result.rfind('-') {
            let suffix = &result[hyphen_idx + 1..];
            if suffix.starts_with('v') && suffix[1..].chars().all(|c| c.is_ascii_digit()) {
                // Check if this is the ONLY qualifier (e.g., "layout-v21" not "layout-fr-v21")
                let prefix = &result[..hyphen_idx];
                // Base types that shouldn't have version-only qualifiers stripped
                let base_types = [
                    "drawable", "layout", "anim", "animator", "color", "menu",
                    "mipmap", "raw", "xml", "font", "navigation", "transition",
                ];
                if base_types.contains(&prefix) {
                    result = prefix.to_string();
                }
            }
        }

        result
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

/// Apply resource path mapping for JADX compatibility.
/// Handles resource names with invalid chars ($, /, -, etc.) that need sanitization.
/// The path_mappings maps original paths (without extension) to sanitized paths.
fn apply_resource_path_mapping(
    path: &str,
    path_mappings: &std::collections::HashMap<String, String>,
) -> String {
    if path_mappings.is_empty() {
        return path.to_string();
    }

    // Extract the path without extension
    let (base_path, extension) = match path.rfind('.') {
        Some(idx) if path[idx..].len() <= 10 => (&path[..idx], &path[idx..]),
        _ => (path, ""),
    };

    // Check if we have a mapping for this base path
    if let Some(new_base) = path_mappings.get(base_path) {
        format!("{}{}", new_base, extension)
    } else {
        path.to_string()
    }
}

/// Check if a file should be extracted as raw (unprocessed) from the APK.
///
/// Uses a blacklist approach to achieve 1:1 parity with JADX extraction:
/// - Extract everything EXCEPT files that need special processing
/// - Special processing: .dex (decompiled), .xml in res/ (decoded),
///   AndroidManifest.xml (decoded), resources.arsc (parsed)
///
/// This ensures complete resource extraction including:
/// - Kotlin metadata (.kotlin_builtins)
/// - Build metadata (.properties, .bin, versions)
/// - Library resources (okhttp3/, com/, etc.)
/// - All META-INF subdirectories
fn should_extract_raw_file(name: &str) -> bool {
    // Skip .dex files (processed separately as code)
    if name.ends_with(".dex") {
        return false;
    }

    // Skip AndroidManifest.xml (processed separately with binary XML parser)
    if name == "AndroidManifest.xml" {
        return false;
    }

    // Skip resources.arsc (processed separately with ARSC parser)
    if name == "resources.arsc" {
        return false;
    }

    // Skip res/*.xml files (processed separately with binary XML parser)
    if name.starts_with("res/") && name.ends_with(".xml") {
        return false;
    }

    // Extract everything else (1:1 JADX parity)
    true
}

/// Check if a resource path has qualifiers (e.g., drawable-hdpi, values-en)
/// Used to skip localized/density-specific resources when --include-framework is not set.
/// This keeps only base resources (drawable, values, layout, etc.) for faster output.
fn is_qualified_resource_path(path: &str) -> bool {
    // Must be in res/ directory
    if !path.starts_with("res/") {
        return false;
    }

    // Get the directory component after res/
    let after_res = &path[4..]; // Skip "res/"
    if let Some(slash_pos) = after_res.find('/') {
        let dir_name = &after_res[..slash_pos];
        // Check if directory has a qualifier (contains '-')
        // Examples: drawable-hdpi, values-en, mipmap-xxxhdpi
        dir_name.contains('-')
    } else {
        false
    }
}
