use serde::{Deserialize, Serialize};
use std::collections::HashMap;

/// Defect found in decompiled code
#[derive(Debug, Clone, Serialize, Deserialize)]
pub enum Defect {
    UnreachableCode { line: usize, context: String },
    MultipleDeclaration { variable: String, line: usize },
    IncompleteSwitch { missing_cases: usize },
    ObfuscatedVariable { name: String, line: usize },
    ObfuscatedMethod { name: String, line: usize },
    ObfuscatedPackage { name: String },
}

/// Metrics for a single Java class
#[derive(Debug, Clone, Serialize, Deserialize)]
pub struct ClassMetrics {
    pub class_name: String,
    pub file_path: String,
    pub lines_of_code: usize,
    pub method_count: usize,
    pub field_count: usize,
    pub variable_quality_score: f32,
    pub method_quality_score: f32,
    pub package_quality_score: f32,
    pub defects: Vec<Defect>,
}

/// Aggregated metrics for all classes
#[derive(Debug, Clone, Serialize, Deserialize)]
pub struct AggregateMetrics {
    pub file_count: usize,
    pub total_loc: usize,
    pub avg_loc_per_class: f32,
    pub total_methods: usize,
    pub total_fields: usize,
    pub avg_variable_quality: f32,
    pub avg_method_quality: f32,
    pub avg_package_quality: f32,
    pub total_defects: usize,
    pub defect_breakdown: HashMap<String, usize>,
}

/// Comparison between JADX and Dexterity for a single class
#[derive(Debug, Clone, Serialize, Deserialize)]
pub struct ClassComparison {
    pub class_name: String,
    pub jadx_metrics: Option<ClassMetrics>,
    pub dexterity_metrics: Option<ClassMetrics>,
    pub loc_diff: i32,
    pub method_count_diff: i32,
    pub quality_score_diff: f32,
}

/// Overall quality summary
#[derive(Debug, Clone, Serialize, Deserialize)]
pub struct QualitySummary {
    pub completeness_score: f32,      // 0-100: % of files present
    pub code_quality_score: f32,      // 0-100: naming quality avg
    pub defect_score: f32,            // 0-100: 100 - defects_per_kloc
    pub overall_score: f32,           // weighted average
}

/// Full comparison report
#[derive(Debug, Clone, Serialize, Deserialize)]
pub struct ComparisonReport {
    pub test_case: String,
    pub jadx_metrics: AggregateMetrics,
    pub dexterity_metrics: AggregateMetrics,
    pub missing_classes: Vec<String>,
    pub per_class_comparison: Vec<ClassComparison>,
    pub summary: QualitySummary,
}

impl Default for AggregateMetrics {
    fn default() -> Self {
        Self {
            file_count: 0,
            total_loc: 0,
            avg_loc_per_class: 0.0,
            total_methods: 0,
            total_fields: 0,
            avg_variable_quality: 0.0,
            avg_method_quality: 0.0,
            avg_package_quality: 0.0,
            total_defects: 0,
            defect_breakdown: HashMap::new(),
        }
    }
}

impl Default for QualitySummary {
    fn default() -> Self {
        Self {
            completeness_score: 0.0,
            code_quality_score: 0.0,
            defect_score: 0.0,
            overall_score: 0.0,
        }
    }
}

impl Default for ClassMetrics {
    fn default() -> Self {
        Self {
            class_name: String::new(),
            file_path: String::new(),
            lines_of_code: 0,
            method_count: 0,
            field_count: 0,
            variable_quality_score: 1.0,
            method_quality_score: 1.0,
            package_quality_score: 1.0,
            defects: Vec::new(),
        }
    }
}
