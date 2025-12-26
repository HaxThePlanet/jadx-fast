//! Detection Report
//!
//! Aggregates all obfuscation detection results into a comprehensive report
//! that can be exported as JSON or displayed to users.

use crate::obfuscator_signatures::{ObfuscatorDetection, Confidence};
use crate::string_decryption::DecryptorMethod;

/// Complete obfuscation detection report
#[derive(Debug, Clone)]
pub struct DetectionReport {
    /// APK/DEX file name
    pub file_name: String,
    /// Detected obfuscators
    pub obfuscators: Vec<ObfuscatorDetection>,
    /// String decryption methods found
    pub string_decryptors: Vec<DecryptorMethod>,
    /// Obfuscation statistics
    pub stats: ObfuscationStats,
    /// Recommendations for analysis
    pub recommendations: Vec<String>,
}

/// Statistics about obfuscation level
#[derive(Debug, Clone, Default)]
pub struct ObfuscationStats {
    /// Total classes
    pub total_classes: usize,
    /// Classes with short names (<=3 chars)
    pub short_name_classes: usize,
    /// Classes with single-char names
    pub single_char_classes: usize,
    /// Total methods
    pub total_methods: usize,
    /// Methods with short names
    pub short_name_methods: usize,
    /// Total fields
    pub total_fields: usize,
    /// Fields with short names
    pub short_name_fields: usize,
    /// Encrypted strings found
    pub encrypted_strings: usize,
    /// Native libraries detected
    pub native_libs: usize,
    /// Control flow flattening detected
    pub cff_methods: usize,
    /// Opaque predicates detected
    pub opaque_predicates: usize,
}

impl ObfuscationStats {
    /// Calculate obfuscation level (0-100)
    pub fn obfuscation_level(&self) -> u32 {
        let mut score = 0u32;

        // Short name percentage contributes up to 40 points
        if self.total_classes > 0 {
            let short_pct = (self.short_name_classes as f64 / self.total_classes as f64) * 100.0;
            score += (short_pct * 0.4) as u32;
        }

        // Single char classes add up to 20 points
        if self.total_classes > 0 {
            let single_pct = (self.single_char_classes as f64 / self.total_classes as f64) * 100.0;
            score += (single_pct * 0.2) as u32;
        }

        // Encrypted strings add up to 15 points
        score += (self.encrypted_strings.min(50) as u32 * 15) / 50;

        // Native libs add 10 points if present
        if self.native_libs > 0 {
            score += 10;
        }

        // Control flow obfuscation adds up to 15 points
        if self.total_methods > 0 {
            let cff_pct = (self.cff_methods as f64 / self.total_methods as f64) * 100.0;
            score += (cff_pct * 0.15) as u32;
        }

        score.min(100)
    }

    /// Get human-readable obfuscation level
    pub fn level_description(&self) -> &'static str {
        match self.obfuscation_level() {
            0..=20 => "Light",
            21..=40 => "Moderate",
            41..=60 => "Heavy",
            61..=80 => "Very Heavy",
            _ => "Extreme",
        }
    }
}

impl DetectionReport {
    /// Create a new empty report
    pub fn new(file_name: String) -> Self {
        Self {
            file_name,
            obfuscators: Vec::new(),
            string_decryptors: Vec::new(),
            stats: ObfuscationStats::default(),
            recommendations: Vec::new(),
        }
    }

    /// Add an obfuscator detection
    pub fn add_obfuscator(&mut self, detection: ObfuscatorDetection) {
        // Avoid duplicates
        if !self.obfuscators.iter().any(|d| d.obfuscator == detection.obfuscator) {
            self.obfuscators.push(detection);
        }
    }

    /// Add a string decryptor
    pub fn add_decryptor(&mut self, decryptor: DecryptorMethod) {
        self.string_decryptors.push(decryptor);
    }

    /// Generate recommendations based on findings
    pub fn generate_recommendations(&mut self) {
        self.recommendations.clear();

        // Check for packers
        for detection in &self.obfuscators {
            if detection.obfuscator.is_packer() {
                self.recommendations.push(format!(
                    "⚠️ {} packer detected - DEX may be encrypted. Consider unpacking first.",
                    detection.obfuscator.name()
                ));
            }
        }

        // String encryption recommendations
        if !self.string_decryptors.is_empty() {
            let auto_decrypt: Vec<_> = self.string_decryptors.iter()
                .filter(|d| d.encryption_type.can_auto_decrypt())
                .collect();

            if !auto_decrypt.is_empty() {
                self.recommendations.push(format!(
                    "📝 Found {} string decryptors that may be auto-decryptable (XOR/Base64)",
                    auto_decrypt.len()
                ));
            }

            let complex: Vec<_> = self.string_decryptors.iter()
                .filter(|d| !d.encryption_type.can_auto_decrypt())
                .collect();

            if !complex.is_empty() {
                self.recommendations.push(format!(
                    "🔐 Found {} string decryptors using complex encryption (AES/DES/custom)",
                    complex.len()
                ));
            }
        }

        // Obfuscation level recommendations
        let level = self.stats.obfuscation_level();
        if level > 60 {
            self.recommendations.push(
                "🔒 Heavy obfuscation detected - expect significant analysis difficulty".to_string()
            );
        }

        // Control flow recommendations
        if self.stats.cff_methods > 0 {
            self.recommendations.push(format!(
                "🔀 Control flow flattening detected in {} methods - consider CFF recovery pass",
                self.stats.cff_methods
            ));
        }

        // If no specific issues found
        if self.recommendations.is_empty() {
            if self.stats.obfuscation_level() < 20 {
                self.recommendations.push(
                    "✅ Light obfuscation - standard decompilation should work well".to_string()
                );
            } else {
                self.recommendations.push(
                    "ℹ️ Standard ProGuard/R8 obfuscation - smart naming enabled".to_string()
                );
            }
        }
    }

    /// Get primary obfuscator (highest confidence)
    pub fn primary_obfuscator(&self) -> Option<&ObfuscatorDetection> {
        self.obfuscators.iter()
            .max_by_key(|d| d.confidence)
    }

    /// Format report as text
    pub fn to_text(&self) -> String {
        let mut output = String::new();

        output.push_str(&format!("╔══════════════════════════════════════════════════════════════╗\n"));
        output.push_str(&format!("║            OBFUSCATION DETECTION REPORT                       ║\n"));
        output.push_str(&format!("╚══════════════════════════════════════════════════════════════╝\n\n"));

        output.push_str(&format!("File: {}\n", self.file_name));
        output.push_str(&format!("Obfuscation Level: {} ({}%)\n\n",
            self.stats.level_description(),
            self.stats.obfuscation_level()
        ));

        // Obfuscators
        output.push_str("━━━ Detected Obfuscators ━━━\n");
        if self.obfuscators.is_empty() {
            output.push_str("  None definitively detected (may be custom/ProGuard)\n");
        } else {
            for detection in &self.obfuscators {
                let conf = match detection.confidence {
                    Confidence::Definite => "DEFINITE",
                    Confidence::High => "HIGH",
                    Confidence::Medium => "MEDIUM",
                    Confidence::Low => "LOW",
                };
                output.push_str(&format!("  • {} [{}]\n", detection.obfuscator.name(), conf));
                for evidence in &detection.evidence {
                    output.push_str(&format!("    └─ {}\n", evidence));
                }
            }
        }
        output.push('\n');

        // Statistics
        output.push_str("━━━ Statistics ━━━\n");
        output.push_str(&format!("  Classes: {} total, {} short names ({:.1}%)\n",
            self.stats.total_classes,
            self.stats.short_name_classes,
            if self.stats.total_classes > 0 {
                self.stats.short_name_classes as f64 / self.stats.total_classes as f64 * 100.0
            } else { 0.0 }
        ));
        output.push_str(&format!("  Methods: {} total, {} short names ({:.1}%)\n",
            self.stats.total_methods,
            self.stats.short_name_methods,
            if self.stats.total_methods > 0 {
                self.stats.short_name_methods as f64 / self.stats.total_methods as f64 * 100.0
            } else { 0.0 }
        ));
        if self.stats.encrypted_strings > 0 {
            output.push_str(&format!("  Encrypted Strings: {}\n", self.stats.encrypted_strings));
        }
        if self.stats.native_libs > 0 {
            output.push_str(&format!("  Native Libraries: {}\n", self.stats.native_libs));
        }
        output.push('\n');

        // String decryptors
        if !self.string_decryptors.is_empty() {
            output.push_str("━━━ String Decryptors ━━━\n");
            for decryptor in &self.string_decryptors {
                output.push_str(&format!("  • {}.{}\n",
                    short_class_name(&decryptor.class_type),
                    decryptor.method_name
                ));
                output.push_str(&format!("    Type: {}\n", decryptor.encryption_type.name()));
            }
            output.push('\n');
        }

        // Recommendations
        output.push_str("━━━ Recommendations ━━━\n");
        for rec in &self.recommendations {
            output.push_str(&format!("  {}\n", rec));
        }

        output
    }

    /// Format report as JSON
    pub fn to_json(&self) -> String {
        let mut json = String::from("{\n");

        json.push_str(&format!("  \"file\": \"{}\",\n", escape_json(&self.file_name)));
        json.push_str(&format!("  \"obfuscationLevel\": {},\n", self.stats.obfuscation_level()));
        json.push_str(&format!("  \"levelDescription\": \"{}\",\n", self.stats.level_description()));

        // Obfuscators
        json.push_str("  \"obfuscators\": [\n");
        for (i, detection) in self.obfuscators.iter().enumerate() {
            json.push_str("    {\n");
            json.push_str(&format!("      \"type\": \"{}\",\n", detection.obfuscator.name()));
            json.push_str(&format!("      \"confidence\": \"{:?}\",\n", detection.confidence));
            json.push_str(&format!("      \"isPacker\": {}\n", detection.obfuscator.is_packer()));
            json.push_str("    }");
            if i < self.obfuscators.len() - 1 {
                json.push(',');
            }
            json.push('\n');
        }
        json.push_str("  ],\n");

        // Stats
        json.push_str("  \"stats\": {\n");
        json.push_str(&format!("    \"totalClasses\": {},\n", self.stats.total_classes));
        json.push_str(&format!("    \"shortNameClasses\": {},\n", self.stats.short_name_classes));
        json.push_str(&format!("    \"totalMethods\": {},\n", self.stats.total_methods));
        json.push_str(&format!("    \"shortNameMethods\": {},\n", self.stats.short_name_methods));
        json.push_str(&format!("    \"encryptedStrings\": {},\n", self.stats.encrypted_strings));
        json.push_str(&format!("    \"nativeLibs\": {}\n", self.stats.native_libs));
        json.push_str("  },\n");

        // Decryptors
        json.push_str("  \"stringDecryptors\": [\n");
        for (i, decryptor) in self.string_decryptors.iter().enumerate() {
            json.push_str("    {\n");
            json.push_str(&format!("      \"class\": \"{}\",\n", escape_json(&decryptor.class_type)));
            json.push_str(&format!("      \"method\": \"{}\",\n", escape_json(&decryptor.method_name)));
            json.push_str(&format!("      \"encryptionType\": \"{}\"\n", decryptor.encryption_type.name()));
            json.push_str("    }");
            if i < self.string_decryptors.len() - 1 {
                json.push(',');
            }
            json.push('\n');
        }
        json.push_str("  ],\n");

        // Recommendations
        json.push_str("  \"recommendations\": [\n");
        for (i, rec) in self.recommendations.iter().enumerate() {
            json.push_str(&format!("    \"{}\"", escape_json(rec)));
            if i < self.recommendations.len() - 1 {
                json.push(',');
            }
            json.push('\n');
        }
        json.push_str("  ]\n");

        json.push('}');
        json
    }
}

/// Get short class name from full type
fn short_class_name(class_type: &str) -> &str {
    class_type
        .trim_start_matches('L')
        .trim_end_matches(';')
        .rsplit('/')
        .next()
        .unwrap_or(class_type)
}

/// Escape string for JSON
fn escape_json(s: &str) -> String {
    s.replace('\\', "\\\\")
        .replace('"', "\\\"")
        .replace('\n', "\\n")
        .replace('\r', "\\r")
        .replace('\t', "\\t")
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn test_obfuscation_level() {
        let mut stats = ObfuscationStats::default();

        // Empty stats = 0 level
        assert_eq!(stats.obfuscation_level(), 0);

        // Add some obfuscation
        stats.total_classes = 100;
        stats.short_name_classes = 80;
        stats.single_char_classes = 40;

        let level = stats.obfuscation_level();
        assert!(level > 0);
        assert!(level <= 100);
    }

    #[test]
    fn test_report_generation() {
        let mut report = DetectionReport::new("test.apk".to_string());

        report.stats.total_classes = 100;
        report.stats.short_name_classes = 50;
        report.stats.total_methods = 500;
        report.stats.short_name_methods = 300;

        report.generate_recommendations();

        assert!(!report.recommendations.is_empty());
    }

    #[test]
    fn test_report_text_output() {
        let mut report = DetectionReport::new("sample.apk".to_string());
        report.stats.total_classes = 50;
        report.generate_recommendations();

        let text = report.to_text();
        assert!(text.contains("sample.apk"));
        assert!(text.contains("OBFUSCATION DETECTION REPORT"));
    }

    #[test]
    fn test_report_json_output() {
        let report = DetectionReport::new("sample.apk".to_string());
        let json = report.to_json();

        assert!(json.starts_with('{'));
        assert!(json.ends_with('}'));
        assert!(json.contains("\"file\""));
        assert!(json.contains("sample.apk"));
    }
}
