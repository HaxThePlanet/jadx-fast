//! Detect known libraries in APKs by fingerprint matching
//!
//! Usage: cargo run --example detect_library -- <library.dex> <version> <apk1> [apk2] ...

use std::collections::HashMap;
use std::env;
use std::io::Read;
use std::path::Path;

use dexterity_dex::DexReader;
use dexterity_fingerprint::{fingerprint_class, ClassFingerprint};

fn main() {
    let args: Vec<String> = env::args().collect();

    if args.len() < 4 {
        eprintln!("Usage: {} <library.dex> <version> <apk1> [apk2] ...", args[0]);
        eprintln!("Example: {} /tmp/gson.dex 2.10.1 app1.apk app2.apk", args[0]);
        std::process::exit(1);
    }

    let lib_dex_path = &args[1];
    let lib_version = &args[2];
    let apk_paths: Vec<&String> = args[3..].iter().collect();

    // Step 1: Build fingerprint database from library DEX
    println!("=== Building Library Fingerprint Database ===");
    println!("Library: {} (version {})", lib_dex_path, lib_version);

    let lib_fingerprints = fingerprint_library_dex(lib_dex_path, lib_version);
    println!("Fingerprinted {} classes from library\n", lib_fingerprints.len());

    // Step 2: Scan each APK for matches
    println!("=== Scanning APKs for Library Matches ===\n");

    for apk_path in apk_paths {
        scan_apk_for_library(apk_path, &lib_fingerprints, lib_version);
    }
}

/// Minimum method count for a class to be considered "significant"
/// Small classes (interfaces, callbacks) produce too many false positives
const MIN_METHODS_FOR_DETECTION: u32 = 3;

/// Fingerprint all classes in a library DEX file
fn fingerprint_library_dex(dex_path: &str, version: &str) -> HashMap<u64, (String, String)> {
    let mut fingerprints = HashMap::new();

    let data = std::fs::read(dex_path).expect("Failed to read DEX file");
    let dex = DexReader::from_bytes(0, dex_path.to_string(), data)
        .expect("Failed to parse DEX");

    for class_result in dex.classes() {
        let class = match class_result {
            Ok(c) => c,
            Err(_) => continue,
        };

        let class_name = class.class_type().unwrap_or_default();

        // Skip framework classes
        if class_name.starts_with("Ljava/") ||
           class_name.starts_with("Landroid/") ||
           class_name.starts_with("Lkotlin/") {
            continue;
        }

        match fingerprint_class(&class, &dex) {
            Ok(fp) => {
                // Only include classes with enough methods to be distinctive
                if fp.method_count >= MIN_METHODS_FOR_DETECTION {
                    let hash = fp.combined_hash();
                    fingerprints.insert(hash, (class_name, version.to_string()));
                }
            }
            Err(_) => continue,
        }
    }

    fingerprints
}

/// Scan an APK for matching library fingerprints
fn scan_apk_for_library(
    apk_path: &str,
    lib_fingerprints: &HashMap<u64, (String, String)>,
    lib_version: &str,
) {
    use std::collections::HashSet;

    let apk_name = Path::new(apk_path)
        .file_name()
        .map(|s| s.to_string_lossy().to_string())
        .unwrap_or_else(|| apk_path.to_string());

    println!("Scanning: {}", apk_name);

    // Extract DEX files from APK
    let dex_readers = match extract_dex_from_apk(apk_path) {
        Ok(readers) => readers,
        Err(e) => {
            eprintln!("  Error: {}", e);
            return;
        }
    };

    let mut matches = Vec::new();
    let mut matched_lib_hashes: HashSet<u64> = HashSet::new();
    let mut total_classes = 0;

    for dex in &dex_readers {
        for class_result in dex.classes() {
            let class = match class_result {
                Ok(c) => c,
                Err(_) => continue,
            };

            total_classes += 1;

            match fingerprint_class(&class, dex) {
                Ok(fp) => {
                    // Only consider classes with enough methods
                    if fp.method_count < MIN_METHODS_FOR_DETECTION {
                        continue;
                    }

                    let hash = fp.combined_hash();
                    if let Some((lib_class_name, _version)) = lib_fingerprints.get(&hash) {
                        // Only count each library class once
                        if matched_lib_hashes.insert(hash) {
                            let apk_class_name = class.class_type().unwrap_or_default();
                            matches.push((apk_class_name, lib_class_name.clone()));
                        }
                    }
                }
                Err(_) => continue,
            }
        }
    }

    let lib_total = lib_fingerprints.len();
    let matched = matches.len();
    let match_pct = (matched as f64 / lib_total as f64) * 100.0;

    if matches.is_empty() {
        println!("  ❌ Library NOT detected (scanned {} classes)\n", total_classes);
    } else if match_pct >= 50.0 {
        // High confidence detection
        println!("  ✅ DETECTED: Gson {} ({}/{} classes = {:.1}%)",
            lib_version, matched, lib_total, match_pct);
        println!("  Sample matches:");
        for (apk_class, lib_class) in matches.iter().take(5) {
            println!("    {} → {}", apk_class, lib_class);
        }
        if matches.len() > 5 {
            println!("    ... and {} more", matches.len() - 5);
        }
        println!();
    } else if match_pct >= 10.0 {
        // Partial match - maybe different version or stripped
        println!("  ⚠️  PARTIAL: Possibly Gson (different version?) ({}/{} = {:.1}%)\n",
            matched, lib_total, match_pct);
    } else {
        // Too few matches to be confident
        println!("  ❌ Library NOT detected ({} weak matches, {:.1}%)\n",
            matched, match_pct);
    }
}

fn extract_dex_from_apk(apk_path: &str) -> anyhow::Result<Vec<DexReader>> {
    use std::fs::File;

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
