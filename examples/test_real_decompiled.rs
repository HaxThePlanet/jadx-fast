//! Test LLM renaming on REAL decompiled code from the output directory
//! Run: cargo run --release --example test_real_decompiled

use dexterity_llm_postproc::{Config, LLMPostProcessor};
use std::fs;
use std::path::Path;

fn find_java_files_with_vars(dir: &Path, limit: usize) -> Vec<String> {
    let mut files = Vec::new();
    if let Ok(entries) = fs::read_dir(dir) {
        for entry in entries.flatten() {
            let path = entry.path();
            if path.is_dir() {
                files.extend(find_java_files_with_vars(&path, limit - files.len()));
            } else if path.extension().map_or(false, |e| e == "java") {
                if let Ok(content) = fs::read_to_string(&path) {
                    // Only include files that have register-based variable names
                    if content.contains(" v0") || content.contains(" v1") || content.contains(" v2") {
                        files.push(path.to_string_lossy().to_string());
                    }
                }
            }
            if files.len() >= limit {
                break;
            }
        }
    }
    files
}

#[tokio::main]
async fn main() -> anyhow::Result<()> {
    println!("╔════════════════════════════════════════════════════════════╗");
    println!("║  Testing LLM Renaming on REAL Decompiled Code              ║");
    println!("╚════════════════════════════════════════════════════════════╝\n");

    // Find a file with register variables
    let output_dir = Path::new("/mnt/nvme4tb/jadx-rust/output/medium/dexterity/sources");
    let files = find_java_files_with_vars(output_dir, 3);

    if files.is_empty() {
        println!("No files with register variables found");
        return Ok(());
    }

    match Config::from_env() {
        Ok(config) => {
            if !config.enabled {
                println!("LLM disabled. Start Ollama: ollama serve");
                return Ok(());
            }

            println!("✅ LLM: {:?} / {}\n", config.backend, config.model);

            let processor = LLMPostProcessor::new(config).await?;

            for file_path in files.iter().take(1) {
                let content = fs::read_to_string(file_path)?;

                // Only process first 100 lines to keep output readable
                let lines: Vec<&str> = content.lines().take(100).collect();
                let truncated = lines.join("\n");

                println!("FILE: {}", file_path);
                println!("═════════════════════════════════════════════════════════════════════\n");

                println!("BEFORE (original decompiled):");
                println!("─────────────────────────────────────────────────────────────────────");
                println!("{}\n", truncated);

                match processor.process(&truncated, None, None).await {
                    Ok(enhanced) => {
                        println!("AFTER (LLM-enhanced names):");
                        println!("─────────────────────────────────────────────────────────────────────");
                        println!("{}", enhanced);
                    }
                    Err(e) => {
                        eprintln!("Error: {}", e);
                    }
                }
            }
        }
        Err(e) => {
            eprintln!("Config error: {}", e);
        }
    }

    Ok(())
}
