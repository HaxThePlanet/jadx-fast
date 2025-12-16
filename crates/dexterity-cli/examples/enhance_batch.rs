//! Batch enhance files with LLM
use dexterity_llm_postproc::{Config, LLMPostProcessor};
use std::fs;
use std::time::Instant;

#[tokio::main]
async fn main() -> anyhow::Result<()> {
    let args: Vec<String> = std::env::args().collect();
    let limit: usize = args.get(1).and_then(|s| s.parse().ok()).unwrap_or(5);

    println!("Enhancing {} files with LLM...\n", limit);

    let config = Config::from_env()?;
    if !config.enabled {
        println!("LLM disabled!");
        return Ok(());
    }
    println!("Model: {}\n", config.model);

    let processor = LLMPostProcessor::new(config).await?;

    // Find files with bad variable names
    let output = std::process::Command::new("grep")
        .args(["-rl", "arg0\\|var0", "/mnt/nvme4tb/jadx-rust/output/medium/dexterity_llm/sources", "--include=*.java"])
        .output()?;

    let files: Vec<&str> = std::str::from_utf8(&output.stdout)?
        .lines()
        .take(limit)
        .collect();

    let total_start = Instant::now();

    for (i, file_path) in files.iter().enumerate() {
        let content = fs::read_to_string(file_path)?;
        let lines = content.lines().count();

        print!("[{}/{}] {} ({} lines)... ", i + 1, limit, file_path.split('/').last().unwrap_or("?"), lines);

        let start = Instant::now();
        match processor.process(&content, None, None).await {
            Ok(enhanced) => {
                if enhanced != content {
                    fs::write(file_path, &enhanced)?;
                    println!("✓ enhanced in {:.1}s", start.elapsed().as_secs_f64());
                } else {
                    println!("- no changes ({:.1}s)", start.elapsed().as_secs_f64());
                }
            }
            Err(e) => {
                println!("✗ error: {}", e);
            }
        }
    }

    println!("\nTotal: {:.1}s for {} files", total_start.elapsed().as_secs_f64(), limit);
    Ok(())
}
