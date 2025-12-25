//! Standalone LLM enhancement script for decompiled output
//! Run: cargo run --release -p dexterity-cli --example enhance_with_llm -- /path/to/sources

use dexterity_llm_postproc::{Config, LLMPostProcessor};
use std::fs;
use std::path::Path;
use walkdir::WalkDir;

fn find_java_files_with_vars(dir: &Path) -> Vec<String> {
    let mut files = Vec::new();
    for entry in WalkDir::new(dir).into_iter().filter_map(|e| e.ok()) {
        let path = entry.path();
        if path.extension().map_or(false, |e| e == "java") {
            if let Ok(content) = fs::read_to_string(path) {
                // Only include files that have decompiler-style variable names
                if content.contains("arg0") || content.contains("arg1")
                    || content.contains("var0") || content.contains("var1")
                    || content.contains(" v0") || content.contains(" v1")
                {
                    files.push(path.to_string_lossy().to_string());
                }
            }
        }
    }
    files
}

#[tokio::main]
async fn main() -> anyhow::Result<()> {
    let args: Vec<String> = std::env::args().collect();
    let input_dir = args.get(1).map(|s| s.as_str()).unwrap_or("/mnt/nvme4tb/jadx-rust/output/small/dexterity/sources");
    let output_dir = args.get(2).map(|s| s.as_str()).unwrap_or("/mnt/nvme4tb/jadx-rust/output/small/dexterity_llm");

    println!("╔════════════════════════════════════════════════════════════╗");
    println!("║  Dexterity LLM Enhancement - Batch Processing              ║");
    println!("╚════════════════════════════════════════════════════════════╝\n");

    println!("Input:  {}", input_dir);
    println!("Output: {}\n", output_dir);

    // Find files to process
    let input_path = Path::new(input_dir);
    let files = find_java_files_with_vars(input_path);

    println!("Found {} Java files with variable patterns to enhance", files.len());

    // Create output directory
    fs::create_dir_all(output_dir)?;

    // Copy ALL files first (preserve directory structure)
    for entry in WalkDir::new(input_path).into_iter().filter_map(|e| e.ok()) {
        let src = entry.path();
        let rel_path = src.strip_prefix(input_path)?;
        let dest = Path::new(output_dir).join(rel_path);

        if src.is_dir() {
            fs::create_dir_all(&dest)?;
        } else {
            if let Some(parent) = dest.parent() {
                fs::create_dir_all(parent)?;
            }
            fs::copy(src, &dest)?;
        }
    }
    println!("Copied all files to output directory");

    // Initialize LLM
    let config = Config::from_env()?;
    if !config.enabled {
        println!("\n⚠️  LLM is disabled. Start Ollama: ollama serve");
        return Ok(());
    }

    println!("\n✅ LLM: {:?} / {}", config.backend, config.model);
    let processor = LLMPostProcessor::new(config).await?;

    // Process files with LLM
    let mut enhanced_count = 0;
    for file_path in &files {
        let rel_path = Path::new(file_path).strip_prefix(input_path)?;
        let output_path = Path::new(output_dir).join(rel_path);

        let content = fs::read_to_string(file_path)?;

        match processor.process(&content, None, None).await {
            Ok(enhanced) => {
                if enhanced != content {
                    fs::write(&output_path, &enhanced)?;
                    enhanced_count += 1;
                    println!("✓ Enhanced: {}", rel_path.display());
                }
            }
            Err(e) => {
                eprintln!("✗ Error processing {}: {}", rel_path.display(), e);
            }
        }
    }

    println!("\n✅ Enhanced {} of {} files", enhanced_count, files.len());
    println!("Output: {}", output_dir);

    Ok(())
}
