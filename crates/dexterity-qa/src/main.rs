mod analyzer;
mod metrics;
mod patterns;
mod reporter;

use analyzer::Analyzer;
use anyhow::Result;
use clap::Parser;
use reporter::Reporter;
use std::path::PathBuf;

#[derive(Parser, Debug)]
#[command(
    name = "dexterity-qa",
    about = "Quality comparison tool for Dexterity vs JADX decompilation"
)]
struct Args {
    /// JADX output directory (sources/)
    #[arg(short = 'j', long)]
    jadx_dir: PathBuf,

    /// Dexterity output directory (sources/)
    #[arg(short = 'd', long)]
    dexterity_dir: PathBuf,

    /// Test case name (for report labeling)
    #[arg(short = 't', long)]
    test_case: String,

    /// Output format: json, csv, markdown
    #[arg(short = 'f', long, default_value = "markdown")]
    format: String,

    /// Output file path (default: stdout)
    #[arg(short = 'o', long)]
    output: Option<PathBuf>,

    /// Also generate per-class detailed report
    #[arg(long)]
    detailed: bool,

    /// Class name filter (only compare matching classes)
    #[arg(long)]
    filter: Option<String>,
}

fn main() -> Result<()> {
    // Parse arguments
    let args = Args::parse();

    println!(
        "Comparing JADX vs Dexterity decompilation quality...",
    );
    println!("JADX dir:      {}", args.jadx_dir.display());
    println!("Dexterity dir: {}", args.dexterity_dir.display());
    println!("Test case:     {}", args.test_case);

    // Analyze directories
    let analyzer = Analyzer::new();
    println!("\nAnalyzing JADX output...");
    let jadx_files = analyzer.collect_java_files(&args.jadx_dir)?;
    println!("  Found {} files", jadx_files.len());

    println!("Analyzing Dexterity output...");
    let dex_files = analyzer.collect_java_files(&args.dexterity_dir)?;
    println!("  Found {} files", dex_files.len());

    // Run comparison
    println!("\nPerforming detailed comparison...");
    let report = analyzer.compare_directories(&args.jadx_dir, &args.dexterity_dir, &args.test_case)?;

    println!("\nComparison Results:");
    println!("  Completeness:   {:.1}%", report.summary.completeness_score);
    println!("  Code Quality:   {:.1}%", report.summary.code_quality_score);
    println!("  Defect Score:   {:.1}%", report.summary.defect_score);
    println!("  Overall Score:  {:.1}%", report.summary.overall_score);

    if !report.missing_classes.is_empty() {
        println!(
            "\n  Missing Classes: {} (first 5:)",
            report.missing_classes.len()
        );
        for class in report.missing_classes.iter().take(5) {
            println!("    - {}", class);
        }
        if report.missing_classes.len() > 5 {
            println!("    ... and {} more", report.missing_classes.len() - 5);
        }
    }

    // Generate report
    println!("\nGenerating {} report...", args.format);
    let reporter = Reporter::new();
    let content = match args.format.as_str() {
        "json" => reporter.generate_json(&report)?,
        "csv" => reporter.generate_csv(&report)?,
        "markdown" | "md" => reporter.generate_markdown(&report)?,
        _ => return Err(anyhow::anyhow!("Unknown format: {}", args.format)),
    };

    // Output
    if let Some(output_path) = args.output {
        std::fs::write(&output_path, &content)?;
        println!(
            "\nReport saved to: {}",
            output_path.display()
        );
    } else {
        println!("\n{}", content);
    }

    Ok(())
}
