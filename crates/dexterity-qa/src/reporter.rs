use crate::metrics::*;
use anyhow::Result;
use std::fs;
use std::path::Path;

/// Generate reports in different formats
pub struct Reporter;

impl Reporter {
    pub fn new() -> Self {
        Self
    }

    /// Generate JSON report
    pub fn generate_json(&self, report: &ComparisonReport) -> Result<String> {
        Ok(serde_json::to_string_pretty(report)?)
    }

    /// Generate CSV report
    pub fn generate_csv(&self, report: &ComparisonReport) -> Result<String> {
        let mut csv = String::from(
            "class_name,jadx_loc,dexterity_loc,loc_diff,jadx_methods,dexterity_methods,method_diff,jadx_var_quality,dexterity_var_quality\n",
        );

        for comp in &report.per_class_comparison {
            csv.push_str(&format!(
                "{},{},{},{},{},{},{},{:.2},{:.2}\n",
                comp.class_name,
                comp.jadx_metrics.as_ref().map(|m| m.lines_of_code).unwrap_or(0),
                comp.dexterity_metrics.as_ref().map(|m| m.lines_of_code).unwrap_or(0),
                comp.loc_diff,
                comp.jadx_metrics.as_ref().map(|m| m.method_count).unwrap_or(0),
                comp.dexterity_metrics.as_ref().map(|m| m.method_count).unwrap_or(0),
                comp.method_count_diff,
                comp.jadx_metrics
                    .as_ref()
                    .map(|m| m.variable_quality_score)
                    .unwrap_or(0.0),
                comp.dexterity_metrics
                    .as_ref()
                    .map(|m| m.variable_quality_score)
                    .unwrap_or(0.0),
            ));
        }

        Ok(csv)
    }

    /// Generate Markdown report
    pub fn generate_markdown(&self, report: &ComparisonReport) -> Result<String> {
        let mut md = String::new();

        md.push_str(&format!(
            "# Decompilation Quality Comparison Report: {}\n\n",
            report.test_case
        ));

        // Executive Summary
        md.push_str("## Executive Summary\n\n");
        md.push_str(&format!(
            "**Overall Quality Score:** {:.1}%\n\n",
            report.summary.overall_score
        ));
        md.push_str(&format!(
            "| Metric | Score |\n|--------|-------|\n"
        ));
        md.push_str(&format!(
            "| Completeness | {:.1}% |\n",
            report.summary.completeness_score
        ));
        md.push_str(&format!(
            "| Code Quality | {:.1}% |\n",
            report.summary.code_quality_score
        ));
        md.push_str(&format!(
            "| Defect Score | {:.1}% |\n\n",
            report.summary.defect_score
        ));

        // File Completeness
        md.push_str("## File Completeness\n\n");
        md.push_str(&format!(
            "| Tool | Files | LOC | Methods | Fields |\n"
        ));
        md.push_str(&format!("|------|-------|-----|---------|--------|\n"));
        md.push_str(&format!(
            "| JADX | {} | {} | {} | {} |\n",
            report.jadx_metrics.file_count,
            report.jadx_metrics.total_loc,
            report.jadx_metrics.total_methods,
            report.jadx_metrics.total_fields,
        ));
        md.push_str(&format!(
            "| Dexterity | {} | {} | {} | {} |\n\n",
            report.dexterity_metrics.file_count,
            report.dexterity_metrics.total_loc,
            report.dexterity_metrics.total_methods,
            report.dexterity_metrics.total_fields,
        ));

        // Missing Classes
        if !report.missing_classes.is_empty() {
            md.push_str(&format!(
                "### Missing Classes ({})\n\n",
                report.missing_classes.len()
            ));
            for (i, class) in report.missing_classes.iter().take(20).enumerate() {
                md.push_str(&format!("{}. {}\n", i + 1, class));
            }
            if report.missing_classes.len() > 20 {
                md.push_str(&format!(
                    "\n... and {} more\n\n",
                    report.missing_classes.len() - 20
                ));
            }
            md.push('\n');
        }

        // Quality Metrics
        md.push_str("## Quality Metrics\n\n");
        md.push_str(&format!(
            "| Metric | JADX | Dexterity | Diff |\n"
        ));
        md.push_str(&format!("|--------|------|-----------|------|\n"));
        md.push_str(&format!(
            "| Avg Variable Quality | {:.2} | {:.2} | {:.2} |\n",
            report.jadx_metrics.avg_variable_quality,
            report.dexterity_metrics.avg_variable_quality,
            report.dexterity_metrics.avg_variable_quality - report.jadx_metrics.avg_variable_quality,
        ));
        md.push_str(&format!(
            "| Avg Method Quality | {:.2} | {:.2} | {:.2} |\n",
            report.jadx_metrics.avg_method_quality,
            report.dexterity_metrics.avg_method_quality,
            report.dexterity_metrics.avg_method_quality - report.jadx_metrics.avg_method_quality,
        ));
        md.push_str(&format!(
            "| Avg Package Quality | {:.2} | {:.2} | {:.2} |\n\n",
            report.jadx_metrics.avg_package_quality,
            report.dexterity_metrics.avg_package_quality,
            report.dexterity_metrics.avg_package_quality - report.jadx_metrics.avg_package_quality,
        ));

        // Defect Analysis
        md.push_str("## Defect Analysis\n\n");
        md.push_str(&format!("|  Defect Type | JADX | Dexterity |\n"));
        md.push_str(&format!("|--------------|------|------------|\n"));

        let all_keys: std::collections::HashSet<_> = report
            .jadx_metrics
            .defect_breakdown
            .keys()
            .chain(report.dexterity_metrics.defect_breakdown.keys())
            .collect();

        for key in all_keys {
            let jadx_count = report.jadx_metrics.defect_breakdown.get(key).unwrap_or(&0);
            let dex_count = report.dexterity_metrics.defect_breakdown.get(key).unwrap_or(&0);
            md.push_str(&format!("| {} | {} | {} |\n", key, jadx_count, dex_count));
        }

        md.push_str("\n**Total Defects:**\n");
        md.push_str(&format!(
            "- JADX: {}\n",
            report.jadx_metrics.total_defects
        ));
        md.push_str(&format!(
            "- Dexterity: {}\n\n",
            report.dexterity_metrics.total_defects
        ));

        // Top Differences
        if !report.per_class_comparison.is_empty() {
            md.push_str("## Notable Differences (Top 10 Classes)\n\n");
            let mut sorted = report.per_class_comparison.clone();
            sorted.sort_by(|a, b| b.quality_score_diff.abs().partial_cmp(&a.quality_score_diff.abs()).unwrap());

            md.push_str(&format!("|Class|LOC Diff|Quality Diff|\n"));
            md.push_str(&format!("|-----|--------|------------|\n"));

            for comp in sorted.iter().take(10) {
                md.push_str(&format!(
                    "|{}|{}|{:.2}|\n",
                    comp.class_name, comp.loc_diff, comp.quality_score_diff
                ));
            }
        }

        md.push_str("\n---\n\n");
        md.push_str("*Report generated by dexterity-qa quality comparison tool*\n");

        Ok(md)
    }

    /// Save report to file
    pub fn save_report(&self, report: &ComparisonReport, output_path: &Path, format: &str) -> Result<()> {
        let content = match format {
            "json" => self.generate_json(report)?,
            "csv" => self.generate_csv(report)?,
            "markdown" | "md" => self.generate_markdown(report)?,
            _ => return Err(anyhow::anyhow!("Unknown format: {}", format)),
        };

        fs::write(output_path, content)?;
        Ok(())
    }
}

impl Default for Reporter {
    fn default() -> Self {
        Self::new()
    }
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn test_generate_json() {
        let report = ComparisonReport {
            test_case: "test".to_string(),
            jadx_metrics: AggregateMetrics::default(),
            dexterity_metrics: AggregateMetrics::default(),
            missing_classes: vec![],
            per_class_comparison: vec![],
            summary: QualitySummary::default(),
        };

        let reporter = Reporter::new();
        let json = reporter.generate_json(&report).unwrap();
        assert!(json.contains("test"));
    }

    #[test]
    fn test_generate_markdown() {
        let report = ComparisonReport {
            test_case: "test".to_string(),
            jadx_metrics: AggregateMetrics::default(),
            dexterity_metrics: AggregateMetrics::default(),
            missing_classes: vec!["MissingClass".to_string()],
            per_class_comparison: vec![],
            summary: QualitySummary::default(),
        };

        let reporter = Reporter::new();
        let md = reporter.generate_markdown(&report).unwrap();
        assert!(md.contains("test"));
        assert!(md.contains("MissingClass"));
    }
}
