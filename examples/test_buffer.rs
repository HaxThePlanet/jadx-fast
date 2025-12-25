//! Test LLM on Buffer.java (1961 lines, 288 bad variable names)
//! Run: cargo run --release --example test_buffer

use dexterity_llm_postproc::{Config, LLMPostProcessor};
use std::fs;
use std::time::Instant;

#[tokio::main]
async fn main() -> anyhow::Result<()> {
    let file_path = "/mnt/nvme4tb/jadx-rust/output/medium/dexterity/sources/okio/Buffer.java";
    let content = fs::read_to_string(file_path)?;

    println!("╔════════════════════════════════════════════════════════════╗");
    println!("║  LLM Test: Buffer.java ({} lines)                        ║", content.lines().count());
    println!("╚════════════════════════════════════════════════════════════╝\n");

    let config = Config::from_env()?;
    println!("Model: {} ({})", config.model, if config.model.contains("1b") { "FAST" } else { "standard" });

    if !config.enabled {
        println!("LLM disabled!");
        return Ok(());
    }

    let processor = LLMPostProcessor::new(config).await?;

    // Only process first 200 lines to keep it fast
    let truncated: String = content.lines().take(200).collect::<Vec<_>>().join("\n");

    println!("\nProcessing first 200 lines...");
    let start = Instant::now();

    match processor.process(&truncated, None, None).await {
        Ok(enhanced) => {
            let elapsed = start.elapsed();
            println!("✓ Done in {:.2}s\n", elapsed.as_secs_f64());

            // Count changes
            let orig_arg0 = truncated.matches("arg0").count();
            let new_arg0 = enhanced.matches("arg0").count();

            println!("Changes:");
            println!("  arg0: {} → {} ({} renamed)", orig_arg0, new_arg0, orig_arg0 - new_arg0);

            println!("\n--- Sample of enhanced code (lines 50-80) ---");
            for (i, line) in enhanced.lines().skip(50).take(30).enumerate() {
                println!("{:3} | {}", i + 51, line);
            }
        }
        Err(e) => {
            eprintln!("Error: {}", e);
        }
    }

    Ok(())
}
