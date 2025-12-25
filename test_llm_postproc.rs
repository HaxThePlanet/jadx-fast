#!/usr/bin/env rust-script
//! Test script for LLM post-processor with local Ollama

use std::fs;
use std::path::Path;

#[tokio::main]
async fn main() -> Result<(), Box<dyn std::error::Error>> {
    println!("=== Dexterity LLM Post-Processor Test ===\n");

    // Read a sample decompiled Java file
    let java_file = "/mnt/nvme4tb/jadx-rust/output/small/dexterity/sources/io/github/skylot/android/smallapp/MainActivity.java";
    let code = fs::read_to_string(java_file)?;

    println!("Original decompiled code:");
    println!("{}", code);
    println!("\n");

    // Note: This would require integrating with dexterity-llm-postproc crate
    // For now, just demonstrate the configuration

    println!("=== Configuration ===");
    println!("Backend: Ollama (auto-detected or uses DEXTERITY_LLM_BACKEND)");
    println!("Model: gemma3:1b (or set via DEXTERITY_OLLAMA_MODEL)");
    println!("Endpoint: http://localhost:11434");
    println!("\n");

    println!("To enable LLM post-processing:");
    println!("  export DEXTERITY_LLM_BACKEND=ollama");
    println!("  export DEXTERITY_OLLAMA_MODEL=gemma3:1b  # very fast, 815MB");
    println!("  dexterity -d output/ app.apk\n");

    println!("Available small Ollama models on your system:");
    println!("  - gemma3:1b (815MB) - Very fast, good for quick processing");
    println!("  - gemma3:4b (3.3GB)  - Faster, better quality");
    println!("  - qwen2.5-coder:7b (4.7GB) - Recommended, best code quality");
    println!("\n");

    Ok(())
}
