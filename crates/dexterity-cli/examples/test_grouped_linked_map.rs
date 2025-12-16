//! Test LLM on GroupedLinkedMap.java from real decompilation
//! Run: cargo run --release --example test_grouped_linked_map

use dexterity_llm_postproc::{Config, LLMPostProcessor};
use std::fs;

#[tokio::main]
async fn main() -> anyhow::Result<()> {
    println!("╔════════════════════════════════════════════════════════════╗");
    println!("║  LLM Enhancement on GroupedLinkedMap.java                  ║");
    println!("╚════════════════════════════════════════════════════════════╝\n");

    let file_path = "/mnt/nvme4tb/jadx-rust/output/medium/dexterity/sources/com/bumptech/glide/load/engine/bitmap_recycle/GroupedLinkedMap.java";
    let content = fs::read_to_string(file_path)?;

    println!("BEFORE (original):");
    println!("─────────────────────────────────────────────────────────────");
    println!("{}\n", content);

    match Config::from_env() {
        Ok(config) => {
            if !config.enabled {
                println!("LLM disabled. Start Ollama: ollama serve");
                return Ok(());
            }

            println!("✅ LLM: {:?} / {}\n", config.backend, config.model);

            let processor = LLMPostProcessor::new(config).await?;

            match processor.process(&content, None, None).await {
                Ok(enhanced) => {
                    println!("AFTER (LLM-enhanced):");
                    println!("─────────────────────────────────────────────────────────────");
                    println!("{}", enhanced);
                }
                Err(e) => {
                    eprintln!("Error: {}", e);
                }
            }
        }
        Err(e) => {
            eprintln!("Config error: {}", e);
        }
    }

    Ok(())
}
