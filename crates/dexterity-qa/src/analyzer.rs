use crate::metrics::*;
use crate::patterns::*;
use anyhow::Result;
use std::collections::HashMap;
use std::fs;
use std::path::{Path, PathBuf};
use walkdir::WalkDir;

/// Core analyzer for comparing decompiled outputs
pub struct Analyzer;

impl Analyzer {
    pub fn new() -> Self {
        Self
    }

    /// Analyze a single Java file
    pub fn analyze_file(&self, path: &Path) -> Result<ClassMetrics> {
        let content = fs::read_to_string(path)?;
        let file_name = path
            .file_name()
            .and_then(|n| n.to_str())
            .unwrap_or("Unknown");

        // Extract class name from file name
        let class_name = file_name.strip_suffix(".java").unwrap_or(file_name);

        Ok(ClassMetrics {
            class_name: class_name.to_string(),
            file_path: path.display().to_string(),
            lines_of_code: count_loc(&content),
            method_count: count_methods(&content),
            field_count: count_fields(&content),
            variable_quality_score: analyze_variable_quality(&content),
            method_quality_score: analyze_method_quality(&content),
            package_quality_score: analyze_package_quality(&content),
            defects: detect_defects(&content, class_name),
        })
    }

    /// Collect all Java files from a directory
    pub fn collect_java_files(&self, root_dir: &Path) -> Result<HashMap<String, PathBuf>> {
        let mut files = HashMap::new();

        for entry in WalkDir::new(root_dir)
            .into_iter()
            .filter_map(|e| e.ok())
            .filter(|e| e.path().extension().and_then(|s| s.to_str()) == Some("java"))
        {
            let path = entry.path();
            // Use relative path as key for matching between directories
            if let Ok(relative) = path.strip_prefix(root_dir) {
                if let Some(rel_str) = relative.to_str() {
                    files.insert(rel_str.to_string(), path.to_path_buf());
                }
            }
        }

        Ok(files)
    }

    /// Analyze all files in a directory
    pub fn analyze_directory(&self, root_dir: &Path) -> Result<AggregateMetrics> {
        let files = self.collect_java_files(root_dir)?;
        let mut metrics = AggregateMetrics::default();
        let mut class_metrics_list = Vec::new();

        for (_rel_path, file_path) in files {
            match self.analyze_file(&file_path) {
                Ok(class_metrics) => {
                    metrics.total_loc += class_metrics.lines_of_code;
                    metrics.total_methods += class_metrics.method_count;
                    metrics.total_fields += class_metrics.field_count;
                    metrics.total_defects += class_metrics.defects.len();

                    // Update defect breakdown
                    for defect in &class_metrics.defects {
                        let defect_type = match defect {
                            Defect::UnreachableCode { .. } => "UnreachableCode",
                            Defect::MultipleDeclaration { .. } => "MultipleDeclaration",
                            Defect::IncompleteSwitch { .. } => "IncompleteSwitch",
                            Defect::ObfuscatedVariable { .. } => "ObfuscatedVariable",
                            Defect::ObfuscatedMethod { .. } => "ObfuscatedMethod",
                            Defect::ObfuscatedPackage { .. } => "ObfuscatedPackage",
                        };
                        *metrics.defect_breakdown.entry(defect_type.to_string()).or_insert(0) += 1;
                    }

                    class_metrics_list.push(class_metrics);
                }
                Err(e) => {
                    eprintln!("Error analyzing {}: {}", file_path.display(), e);
                }
            }
        }

        metrics.file_count = class_metrics_list.len();

        // Calculate averages
        if !class_metrics_list.is_empty() {
            metrics.avg_loc_per_class = metrics.total_loc as f32 / class_metrics_list.len() as f32;

            let sum_var_quality: f32 = class_metrics_list.iter().map(|m| m.variable_quality_score).sum();
            metrics.avg_variable_quality = sum_var_quality / class_metrics_list.len() as f32;

            let sum_method_quality: f32 = class_metrics_list.iter().map(|m| m.method_quality_score).sum();
            metrics.avg_method_quality = sum_method_quality / class_metrics_list.len() as f32;

            let sum_package_quality: f32 = class_metrics_list.iter().map(|m| m.package_quality_score).sum();
            metrics.avg_package_quality = sum_package_quality / class_metrics_list.len() as f32;
        }

        Ok(metrics)
    }

    /// Compare two directory trees (JADX vs Dexterity)
    pub fn compare_directories(
        &self,
        jadx_dir: &Path,
        dexterity_dir: &Path,
        test_case: &str,
    ) -> Result<ComparisonReport> {
        // Analyze both directories
        let jadx_metrics = self.analyze_directory(jadx_dir)?;
        let dexterity_metrics = self.analyze_directory(dexterity_dir)?;

        // Collect files from both
        let jadx_files = self.collect_java_files(jadx_dir)?;
        let dex_files = self.collect_java_files(dexterity_dir)?;

        // Find missing classes
        let mut missing_classes = Vec::new();
        for jadx_class in jadx_files.keys() {
            if !dex_files.contains_key(jadx_class) {
                missing_classes.push(jadx_class.clone());
            }
        }
        missing_classes.sort();

        // Build per-class comparisons (for matching files only)
        let mut per_class_comparison = Vec::new();
        for (rel_path, jadx_path) in &jadx_files {
            if let Some(dex_path) = dex_files.get(rel_path) {
                let jadx_metrics = self.analyze_file(jadx_path).ok();
                let dex_metrics = self.analyze_file(dex_path).ok();

                if let (Some(jm), Some(dm)) = (jadx_metrics.clone(), dex_metrics.clone()) {
                    per_class_comparison.push(ClassComparison {
                        class_name: rel_path.clone(),
                        jadx_metrics: Some(jm.clone()),
                        dexterity_metrics: Some(dm.clone()),
                        loc_diff: dm.lines_of_code as i32 - jm.lines_of_code as i32,
                        method_count_diff: dm.method_count as i32 - jm.method_count as i32,
                        quality_score_diff: (dm.variable_quality_score + dm.method_quality_score + dm.package_quality_score) / 3.0
                            - (jm.variable_quality_score + jm.method_quality_score + jm.package_quality_score) / 3.0,
                    });
                }
            }
        }

        // Calculate quality summary
        let completeness_score = if jadx_metrics.file_count > 0 {
            (dexterity_metrics.file_count as f32 / jadx_metrics.file_count as f32) * 100.0
        } else {
            100.0
        };

        let code_quality_score = dexterity_metrics.avg_variable_quality * 100.0;

        // Defect score: fewer defects = higher score
        let defects_per_kloc = if dexterity_metrics.total_loc > 0 {
            (dexterity_metrics.total_defects as f32 * 1000.0) / dexterity_metrics.total_loc as f32
        } else {
            0.0
        };
        let defect_score = (100.0 - defects_per_kloc.min(100.0)).max(0.0);

        // Overall score: weighted average
        let overall_score = (completeness_score * 0.2 + code_quality_score * 0.3 + defect_score * 0.5).min(100.0);

        let summary = QualitySummary {
            completeness_score,
            code_quality_score,
            defect_score,
            overall_score,
        };

        Ok(ComparisonReport {
            test_case: test_case.to_string(),
            jadx_metrics,
            dexterity_metrics,
            missing_classes,
            per_class_comparison,
            summary,
        })
    }
}

impl Default for Analyzer {
    fn default() -> Self {
        Self::new()
    }
}

#[cfg(test)]
mod tests {
    use super::*;
    use std::fs;
    use tempfile::TempDir;

    #[test]
    fn test_collect_java_files() {
        let temp_dir = TempDir::new().unwrap();
        let java_file = temp_dir.path().join("Test.java");
        fs::write(&java_file, "public class Test {}").unwrap();

        let analyzer = Analyzer::new();
        let files = analyzer.collect_java_files(temp_dir.path()).unwrap();

        assert_eq!(files.len(), 1);
        assert!(files.contains_key("Test.java"));
    }

    #[test]
    fn test_analyze_simple_file() {
        let temp_dir = TempDir::new().unwrap();
        let java_file = temp_dir.path().join("Test.java");
        fs::write(&java_file, "public class Test { public void test() {} }").unwrap();

        let analyzer = Analyzer::new();
        let metrics = analyzer.analyze_file(&java_file).unwrap();

        assert_eq!(metrics.class_name, "Test");
        assert!(metrics.lines_of_code > 0);
        assert_eq!(metrics.method_count, 1);
    }
}
