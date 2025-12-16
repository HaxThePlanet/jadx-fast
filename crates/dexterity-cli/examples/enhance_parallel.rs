//! Parallel batch enhance with LLM - uses multiple concurrent requests
use dexterity_llm_postproc::{Config, LLMPostProcessor};
use std::fs;
use std::sync::Arc;
use std::time::Instant;
use tokio::sync::Semaphore;

#[tokio::main]
async fn main() -> anyhow::Result<()> {
    let args: Vec<String> = std::env::args().collect();
    let limit: usize = args.get(1).and_then(|s| s.parse().ok()).unwrap_or(100);
    let concurrency: usize = args.get(2).and_then(|s| s.parse().ok()).unwrap_or(8);

    println!("Enhancing {} files with {} concurrent LLM requests...\n", limit, concurrency);

    let config = Config::from_env()?;
    if !config.enabled {
        println!("LLM disabled!");
        return Ok(());
    }

    let processor = Arc::new(LLMPostProcessor::new(config).await?);
    let semaphore = Arc::new(Semaphore::new(concurrency));

    // Find files with bad variable names
    let search_dir = args.get(3).map(|s| s.as_str()).unwrap_or("/mnt/nvme4tb/jadx-rust/output/sources");
    let output = std::process::Command::new("grep")
        .args(["-rl", "arg0\\|var0\\|v0", search_dir, "--include=*.java"])
        .output()?;

    let files: Vec<String> = std::str::from_utf8(&output.stdout)?
        .lines()
        .take(limit)
        .map(|s| s.to_string())
        .collect();

    let total = files.len();
    println!("Processing {} files...\n", total);

    let total_start = Instant::now();
    let enhanced_count = Arc::new(std::sync::atomic::AtomicUsize::new(0));
    let processed_count = Arc::new(std::sync::atomic::AtomicUsize::new(0));

    let mut handles = Vec::new();

    for file_path in files {
        let processor = Arc::clone(&processor);
        let semaphore = Arc::clone(&semaphore);
        let enhanced_count = Arc::clone(&enhanced_count);
        let processed_count = Arc::clone(&processed_count);

        let handle = tokio::spawn(async move {
            let _permit = semaphore.acquire().await.unwrap();

            let content = match fs::read_to_string(&file_path) {
                Ok(c) => c,
                Err(_) => return,
            };

            match processor.process(&content, None, None).await {
                Ok(enhanced) => {
                    if enhanced != content {
                        let _ = fs::write(&file_path, &enhanced);
                        enhanced_count.fetch_add(1, std::sync::atomic::Ordering::Relaxed);
                    }
                }
                Err(_) => {}
            }

            let count = processed_count.fetch_add(1, std::sync::atomic::Ordering::Relaxed) + 1;
            if count % 10 == 0 {
                let enhanced = enhanced_count.load(std::sync::atomic::Ordering::Relaxed);
                let elapsed = total_start.elapsed().as_secs_f64();
                let rate = count as f64 / elapsed;
                println!("[{}/{}] {} enhanced, {:.1} files/sec", count, total, enhanced, rate);
            }
        });

        handles.push(handle);
    }

    for handle in handles {
        let _ = handle.await;
    }

    let enhanced = enhanced_count.load(std::sync::atomic::Ordering::Relaxed);
    let elapsed = total_start.elapsed().as_secs_f64();
    println!("\n✅ Done! {} enhanced of {} in {:.1}s ({:.1} files/sec)", enhanced, total, elapsed, total as f64 / elapsed);

    Ok(())
}
