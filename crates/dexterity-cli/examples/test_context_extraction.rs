//! Test the context extraction for variable renaming
//! Run: cargo run --release --example test_context_extraction

use dexterity_llm_postproc::{Config, LLMPostProcessor};

#[tokio::main]
async fn main() -> anyhow::Result<()> {
    println!("╔════════════════════════════════════════════════════════════╗");
    println!("║  Testing Rich Variable Context Extraction                  ║");
    println!("╚════════════════════════════════════════════════════════════╝\n");

    // Sample code that looks like real decompiled output with bad names
    let sample_code = r#"package com.example;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.List;
import java.util.ArrayList;

public class DataManager {
    private SharedPreferences v0;
    private List<String> v1;

    public DataManager(Context v2) {
        Object v3 = v2.getSharedPreferences("settings", 0);
        this.v0 = (SharedPreferences) v3;
        ArrayList v4 = new ArrayList();
        this.v1 = v4;
    }

    public void loadData() {
        String v5 = this.v0.getString("user_name", "");
        int v6 = this.v0.getInt("user_count", 0);
        for (int i = 0; i < v6; i++) {
            String v7 = this.v0.getString("item_" + i, "");
            this.v1.add(v7);
        }
    }

    public void saveItem(String v8) {
        if (v8 != null) {
            this.v1.add(v8);
            SharedPreferences.Editor v9 = this.v0.edit();
            v9.putInt("user_count", this.v1.size());
            v9.apply();
        }
    }

    public List<String> getItems() {
        return this.v1;
    }
}"#;

    println!("ORIGINAL CODE (typical decompiled output):");
    println!("─────────────────────────────────────────────────────────────");
    println!("{}\n", sample_code);

    // Try to process with LLM
    match Config::from_env() {
        Ok(config) => {
            if config.enabled {
                println!("✅ LLM enabled - Backend: {:?}, Model: {}", config.backend, config.model);
                println!("Processing with Ollama...\n");

                match LLMPostProcessor::new(config).await {
                    Ok(processor) => {
                        match processor.process(sample_code, None, None).await {
                            Ok(enhanced_code) => {
                                println!("ENHANCED CODE (after LLM variable renaming):");
                                println!("─────────────────────────────────────────────────────────────");
                                println!("{}", enhanced_code);
                            }
                            Err(e) => {
                                eprintln!("❌ LLM processing error: {}", e);
                            }
                        }
                    }
                    Err(e) => {
                        eprintln!("❌ Error creating processor: {}", e);
                    }
                }
            } else {
                println!("⚠️  LLM is disabled. To enable:");
                println!("   1. Start Ollama: ollama serve");
                println!("   2. Pull a model: ollama pull qwen2.5-coder:7b");
            }
        }
        Err(e) => {
            eprintln!("❌ Config error: {}", e);
        }
    }

    Ok(())
}
