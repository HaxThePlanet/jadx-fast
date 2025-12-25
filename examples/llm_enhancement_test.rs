// Example showing LLM post-processing enhancement on decompiled Java code

use dexterity_llm_postproc::{Config, LLMPostProcessor};
use std::fs;

#[tokio::main]
async fn main() -> anyhow::Result<()> {
    println!("╔════════════════════════════════════════════════════════╗");
    println!("║     Dexterity LLM Post-Processing Demo                ║");
    println!("╚════════════════════════════════════════════════════════╝\n");

    // Initialize logging
    tracing_subscriber::fmt()
        .with_max_level(tracing::Level::INFO)
        .init();

    // Load sample Java code
    let sample_code = r#"package io.example;

import java.util.List;
import android.content.Context;

public class DataProcessor {
    private Object v0;
    private int v1;
    private String v2;

    public void process(List data) {
        Object v3 = getData();
        int v4 = 0;

        while (v4 < 10) {
            if (v3 == 0) {
                return;
            }
            processItem(v3);
            v4++;
        }
    }

    private Object getData() {
        return null;
    }

    private void processItem(Object v5) {
        // Process item
    }
}
"#;

    println!("Original decompiled code (before LLM):");
    println!("─────────────────────────────────────");
    println!("{}\n", sample_code);

    // Try to create and use the LLM post-processor
    match Config::from_env() {
        Ok(config) => {
            if config.enabled {
                println!("✅ LLM post-processor enabled!");
                println!("Backend: {:?}", config.backend);
                println!("Model: {}", config.model);
                println!("Endpoint: {}\n", config.api_endpoint);

                match LLMPostProcessor::new(config).await {
                    Ok(processor) => {
                        println!("Processing code with LLM...\n");

                        // Try variable renaming
                        match processor.process(sample_code, None, None).await {
                            Ok(enhanced_code) => {
                                println!("Enhanced code (after LLM):");
                                println!("─────────────────────────");
                                println!("{}", enhanced_code);
                            }
                            Err(e) => {
                                eprintln!("❌ Error processing code: {}", e);
                                println!("\nNote: If you see an error above, check that:");
                                println!("  1. Ollama is running: ollama serve");
                                println!("  2. A model is loaded: ollama pull qwen2.5-coder:7b");
                                println!("  3. OR set ANTHROPIC_API_KEY for cloud processing");
                            }
                        }
                    }
                    Err(e) => {
                        eprintln!("❌ Error creating LLM post-processor: {}", e);
                    }
                }
            } else {
                println!("ℹ️  LLM post-processor is disabled.");
                println!("\nTo enable:");
                println!("  Option 1 (Ollama - local, $0 cost):");
                println!("    1. Install Ollama: https://ollama.ai");
                println!("    2. Run: ollama serve");
                println!("    3. In another terminal: ollama pull qwen2.5-coder:7b");
                println!("    4. This script will auto-detect and use it");
                println!();
                println!("  Option 2 (Anthropic - cloud):");
                println!("    1. Get API key: https://console.anthropic.com");
                println!("    2. Export: export ANTHROPIC_API_KEY=sk-...");
                println!("    3. Run this script again");
                println!();
                println!("Without LLM, code looks like this:\n");
                println!("{}", sample_code);
            }
        }
        Err(e) => {
            eprintln!("❌ Error loading config: {}", e);
        }
    }

    Ok(())
}
