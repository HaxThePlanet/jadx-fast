//! Fingerprint multiple APKs and show cache hit ratio with SKIP simulation
//!
//! Usage: cargo run --example fingerprint_apks -- /path/to/apks/*.apk

use std::env;
use std::path::Path;
use std::time::Instant;
use std::thread;

use dexterity_dex::DexReader;
use dexterity_fingerprint::{fingerprint_class, FingerprintCache};

/// Simulated decompilation time per class (milliseconds)
/// Real decompilation takes 10-100ms per class
const SIMULATED_DECOMPILE_TIME_MS: u64 = 15;

fn main() {
    let args: Vec<String> = env::args().collect();

    if args.len() < 2 {
        eprintln!("Usage: {} <apk1> [apk2] [apk3] ...", args[0]);
        eprintln!("  or:  {} /path/to/apks/", args[0]);
        std::process::exit(1);
    }

    // Collect APK files
    let mut apk_files: Vec<String> = Vec::new();
    for arg in &args[1..] {
        let path = Path::new(arg);
        if path.is_dir() {
            // Scan directory for APKs
            if let Ok(entries) = std::fs::read_dir(path) {
                for entry in entries.flatten() {
                    let p = entry.path();
                    if p.extension().map(|e| e == "apk").unwrap_or(false) {
                        apk_files.push(p.to_string_lossy().to_string());
                    }
                }
            }
        } else if path.extension().map(|e| e == "apk").unwrap_or(false) {
            apk_files.push(arg.clone());
        }
    }

    if apk_files.is_empty() {
        eprintln!("No APK files found");
        std::process::exit(1);
    }

    apk_files.sort();
    println!("Found {} APK files\n", apk_files.len());

    // Create shared cache
    let cache = FingerprintCache::new();
    let start = Instant::now();

    let mut total_classes = 0u64;
    let mut total_methods = 0u64;
    let mut total_skipped = 0u64;
    let mut total_decompiled = 0u64;

    for (i, apk_path) in apk_files.iter().enumerate() {
        let apk_name = Path::new(apk_path)
            .file_name()
            .map(|s| s.to_string_lossy().to_string())
            .unwrap_or_else(|| apk_path.clone());

        println!("=== [{}/{}] {} ===", i + 1, apk_files.len(), apk_name);

        // Extract DEX files from APK
        let dex_readers = match extract_dex_from_apk(apk_path) {
            Ok(readers) => readers,
            Err(e) => {
                eprintln!("  Error extracting DEX: {}", e);
                continue;
            }
        };

        let mut apk_classes = 0u64;
        let mut apk_methods = 0u64;
        let mut apk_skipped = 0u64;
        let mut apk_decompiled = 0u64;
        let apk_start = Instant::now();

        for dex in &dex_readers {
            for class_result in dex.classes() {
                let class = match class_result {
                    Ok(c) => c,
                    Err(_) => continue,
                };

                match fingerprint_class(&class, dex) {
                    Ok(fp) => {
                        apk_classes += 1;
                        apk_methods += fp.method_count as u64;

                        // Check cache - SKIP if hit!
                        if cache.lookup(&fp).is_some() {
                            // CACHE HIT - SKIP decompilation!
                            apk_skipped += 1;
                        } else {
                            // Cache miss - "decompile" (simulate work)
                            apk_decompiled += 1;

                            // Simulate decompilation time
                            thread::sleep(std::time::Duration::from_micros(
                                SIMULATED_DECOMPILE_TIME_MS * 1000 / 100  // Speed up 100x for demo
                            ));

                            let class_name = class.class_type().unwrap_or_default();
                            cache.store(
                                fp,
                                format!("// Decompiled from {}", class_name),
                                class_name,
                            );
                        }
                    }
                    Err(_) => continue,
                }
            }
        }

        let apk_elapsed = apk_start.elapsed();
        let skip_rate = if apk_classes > 0 {
            (apk_skipped as f64 / apk_classes as f64) * 100.0
        } else {
            0.0
        };

        // Calculate time saved
        let time_saved_ms = apk_skipped * SIMULATED_DECOMPILE_TIME_MS / 100; // Scaled

        println!(
            "  Classes: {} | SKIPPED: {} ({:.1}%) | Decompiled: {} | Time: {:.2}s (saved ~{:.1}s)",
            apk_classes,
            apk_skipped,
            skip_rate,
            apk_decompiled,
            apk_elapsed.as_secs_f64(),
            time_saved_ms as f64 / 1000.0
        );

        total_classes += apk_classes;
        total_methods += apk_methods;
        total_skipped += apk_skipped;
        total_decompiled += apk_decompiled;
    }

    let elapsed = start.elapsed();
    let stats = cache.stats();

    // Calculate theoretical speedup
    let theoretical_no_cache_time = total_classes * SIMULATED_DECOMPILE_TIME_MS;
    let theoretical_with_cache_time = total_decompiled * SIMULATED_DECOMPILE_TIME_MS;
    let speedup = if theoretical_with_cache_time > 0 {
        theoretical_no_cache_time as f64 / theoretical_with_cache_time as f64
    } else {
        1.0
    };

    println!("\n=== SUMMARY ===");
    println!("APKs processed:      {}", apk_files.len());
    println!("Total classes:       {}", total_classes);
    println!("Total methods:       {}", total_methods);
    println!();
    println!("SKIPPED (cache hit): {} ({:.1}%)", total_skipped,
        (total_skipped as f64 / total_classes as f64) * 100.0);
    println!("Decompiled:          {} ({:.1}%)", total_decompiled,
        (total_decompiled as f64 / total_classes as f64) * 100.0);
    println!();
    println!("Unique fingerprints: {}", cache.len());
    println!("Actual time:         {:.2}s", elapsed.as_secs_f64());
    println!();
    println!("=== SPEEDUP ===");
    println!("Without cache:       ~{:.1}s (estimated)",
        theoretical_no_cache_time as f64 / 1000.0);
    println!("With cache:          ~{:.1}s (estimated)",
        theoretical_with_cache_time as f64 / 1000.0);
    println!("SPEEDUP:             {:.2}x faster!", speedup);
}

fn extract_dex_from_apk(apk_path: &str) -> anyhow::Result<Vec<DexReader>> {
    use std::fs::File;
    use std::io::Read;

    let file = File::open(apk_path)?;
    let mut archive = zip::ZipArchive::new(file)?;

    let mut dex_readers = Vec::new();
    let mut dex_id = 0u32;

    for i in 0..archive.len() {
        let mut entry = archive.by_index(i)?;
        let name = entry.name().to_string();

        if name.ends_with(".dex") {
            let mut data = Vec::new();
            entry.read_to_end(&mut data)?;

            match DexReader::from_bytes(dex_id, name.clone(), data) {
                Ok(reader) => {
                    dex_readers.push(reader);
                    dex_id += 1;
                }
                Err(e) => {
                    eprintln!("  Warning: Could not parse {}: {}", name, e);
                }
            }
        }
    }

    Ok(dex_readers)
}
