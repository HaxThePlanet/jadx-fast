//! Integration tests for fingerprinting real DEX files

use dexterity_dex::DexReader;
use dexterity_fingerprint::{fingerprint_class, ClassFingerprint, FingerprintCache};

/// Test fingerprinting a real DEX file
#[test]
fn test_fingerprint_hello_dex() {
    let dex_path = concat!(
        env!("CARGO_MANIFEST_DIR"),
        "/../../jadx-fast/jadx-core/src/test/resources/test-samples/hello.dex"
    );

    // Skip if file doesn't exist
    if !std::path::Path::new(dex_path).exists() {
        eprintln!("Skipping test: {} not found", dex_path);
        return;
    }

    let dex = DexReader::from_file(0, dex_path).expect("Failed to load DEX");

    let mut fingerprints: Vec<ClassFingerprint> = Vec::new();

    // Fingerprint all classes
    for class_result in dex.classes() {
        let class = match class_result {
            Ok(c) => c,
            Err(e) => {
                eprintln!("Failed to parse class: {:?}", e);
                continue;
            }
        };

        let class_name = class.class_type().unwrap_or_else(|_| "unknown".to_string());

        match fingerprint_class(&class, &dex) {
            Ok(fp) => {
                println!(
                    "Class: {} -> fingerprint: {:016x} ({} methods, {} fields)",
                    class_name,
                    fp.combined_hash(),
                    fp.method_count,
                    fp.field_count
                );
                fingerprints.push(fp);
            }
            Err(e) => {
                eprintln!("Failed to fingerprint {}: {:?}", class_name, e);
            }
        }
    }

    // Verify we got some fingerprints
    assert!(!fingerprints.is_empty(), "Should have fingerprinted at least one class");

    // Verify fingerprints are deterministic - fingerprint again and compare
    let mut fingerprints2: Vec<ClassFingerprint> = Vec::new();
    for class_result in dex.classes() {
        if let Ok(class) = class_result {
            if let Ok(fp) = fingerprint_class(&class, &dex) {
                fingerprints2.push(fp);
            }
        }
    }

    assert_eq!(
        fingerprints.len(),
        fingerprints2.len(),
        "Should get same number of fingerprints"
    );

    for (i, (fp1, fp2)) in fingerprints.iter().zip(fingerprints2.iter()).enumerate() {
        assert!(
            fp1.matches(fp2),
            "Fingerprint {} should match: {:016x} vs {:016x}",
            i,
            fp1.combined_hash(),
            fp2.combined_hash()
        );
    }

    println!("\nTotal classes fingerprinted: {}", fingerprints.len());
}

/// Test cache hit/miss behavior
#[test]
fn test_cache_with_real_dex() {
    let dex_path = concat!(
        env!("CARGO_MANIFEST_DIR"),
        "/../../jadx-fast/jadx-core/src/test/resources/test-samples/hello.dex"
    );

    if !std::path::Path::new(dex_path).exists() {
        eprintln!("Skipping test: {} not found", dex_path);
        return;
    }

    let dex = DexReader::from_file(0, dex_path).expect("Failed to load DEX");
    let cache = FingerprintCache::new();

    // First pass - populate cache
    for class_result in dex.classes() {
        if let Ok(class) = class_result {
            if let Ok(fp) = fingerprint_class(&class, &dex) {
                let class_name = class.class_type().unwrap_or_default();
                cache.store(
                    fp,
                    format!("// Decompiled from {}", class_name),
                    class_name,
                );
            }
        }
    }

    println!("Cache populated with {} entries", cache.len());

    // Second pass - should hit cache
    let mut hits = 0;
    let mut misses = 0;

    for class_result in dex.classes() {
        if let Ok(class) = class_result {
            if let Ok(fp) = fingerprint_class(&class, &dex) {
                if cache.lookup(&fp).is_some() {
                    hits += 1;
                } else {
                    misses += 1;
                }
            }
        }
    }

    println!("Cache hits: {}, misses: {}", hits, misses);
    assert!(hits > 0, "Should have at least one cache hit");
    assert_eq!(misses, 0, "Should have no misses for previously cached classes");

    let stats = cache.stats();
    println!("Hit rate: {:.1}%", stats.hit_rate());
    assert!(stats.hit_rate() > 99.0, "Hit rate should be ~100%");
}

/// Test that different methods produce different fingerprints
#[test]
fn test_method_fingerprints_differ() {
    let dex_path = concat!(
        env!("CARGO_MANIFEST_DIR"),
        "/../../jadx-fast/jadx-core/src/test/resources/test-samples/hello.dex"
    );

    if !std::path::Path::new(dex_path).exists() {
        eprintln!("Skipping test: {} not found", dex_path);
        return;
    }

    let dex = DexReader::from_file(0, dex_path).expect("Failed to load DEX");

    let mut all_method_hashes: Vec<u64> = Vec::new();

    for class_result in dex.classes() {
        if let Ok(class) = class_result {
            if let Ok(fp) = fingerprint_class(&class, &dex) {
                for method_fp in &fp.method_fingerprints {
                    all_method_hashes.push(method_fp.combined_hash());
                }
            }
        }
    }

    // Check for uniqueness (or at least reasonable diversity)
    let unique_count = {
        let mut sorted = all_method_hashes.clone();
        sorted.sort();
        sorted.dedup();
        sorted.len()
    };

    println!(
        "Total methods: {}, Unique fingerprints: {} ({:.1}%)",
        all_method_hashes.len(),
        unique_count,
        (unique_count as f64 / all_method_hashes.len() as f64) * 100.0
    );

    // Most methods should have unique fingerprints
    // (some may be identical like empty constructors)
    if !all_method_hashes.is_empty() {
        let uniqueness_ratio = unique_count as f64 / all_method_hashes.len() as f64;
        assert!(
            uniqueness_ratio > 0.5,
            "At least 50% of methods should have unique fingerprints, got {:.1}%",
            uniqueness_ratio * 100.0
        );
    }
}
