//! Obfuscator Signature Database
//!
//! Detects known obfuscators by their telltale patterns:
//! - Marker classes and package names
//! - Native library names
//! - Naming patterns (sequential, unicode, special chars)
//! - Metadata signatures

use lazy_static::lazy_static;

/// Known obfuscator types
#[derive(Debug, Clone, Copy, PartialEq, Eq, Hash)]
pub enum ObfuscatorType {
    /// ProGuard (free, common)
    ProGuard,
    /// R8 (Android's default, ProGuard-compatible)
    R8,
    /// DexGuard (commercial, advanced)
    DexGuard,
    /// Allatori (commercial Java obfuscator)
    Allatori,
    /// Bangcle (Chinese packer)
    Bangcle,
    /// Qihoo 360 Jiagu (Chinese packer)
    Qihoo360,
    /// Tencent Legu (Chinese packer)
    TencentLegu,
    /// Baidu (Chinese packer)
    Baidu,
    /// iJiami (Chinese packer)
    IJiami,
    /// APKProtect
    APKProtect,
    /// Arxan (now Digital.ai)
    Arxan,
    /// StringEncrypt (string-only obfuscation)
    StringEncrypt,
    /// Custom/Unknown obfuscation detected
    Unknown,
}

impl ObfuscatorType {
    /// Get display name
    pub fn name(&self) -> &'static str {
        match self {
            ObfuscatorType::ProGuard => "ProGuard",
            ObfuscatorType::R8 => "R8",
            ObfuscatorType::DexGuard => "DexGuard",
            ObfuscatorType::Allatori => "Allatori",
            ObfuscatorType::Bangcle => "Bangcle",
            ObfuscatorType::Qihoo360 => "Qihoo 360 Jiagu",
            ObfuscatorType::TencentLegu => "Tencent Legu",
            ObfuscatorType::Baidu => "Baidu",
            ObfuscatorType::IJiami => "iJiami",
            ObfuscatorType::APKProtect => "APKProtect",
            ObfuscatorType::Arxan => "Arxan/Digital.ai",
            ObfuscatorType::StringEncrypt => "String Encryption",
            ObfuscatorType::Unknown => "Unknown",
        }
    }

    /// Whether this is a packer (includes native component)
    pub fn is_packer(&self) -> bool {
        matches!(self,
            ObfuscatorType::DexGuard |
            ObfuscatorType::Bangcle |
            ObfuscatorType::Qihoo360 |
            ObfuscatorType::TencentLegu |
            ObfuscatorType::Baidu |
            ObfuscatorType::IJiami |
            ObfuscatorType::APKProtect |
            ObfuscatorType::Arxan
        )
    }
}

/// Confidence level for detection
#[derive(Debug, Clone, Copy, PartialEq, Eq, PartialOrd, Ord)]
pub enum Confidence {
    /// Low confidence - might be false positive
    Low,
    /// Medium confidence - likely correct
    Medium,
    /// High confidence - strong indicators
    High,
    /// Definite - unmistakable signature
    Definite,
}

/// Detection result for an obfuscator
#[derive(Debug, Clone)]
pub struct ObfuscatorDetection {
    /// Detected obfuscator type
    pub obfuscator: ObfuscatorType,
    /// Confidence level
    pub confidence: Confidence,
    /// Evidence that led to detection
    pub evidence: Vec<String>,
}

/// Pattern types for class/package detection
#[derive(Debug, Clone)]
pub enum NamingPattern {
    /// Sequential single-char names (a, b, c, d...)
    SequentialSingleChar,
    /// Sequential multi-char names (aa, ab, ac...)
    SequentialMultiChar,
    /// Only lowercase letters
    LowercaseOnly,
    /// Mixed case but short
    ShortMixedCase(usize),
    /// Contains unicode/special characters
    UnicodeChars,
    /// Numeric suffixes (Class1, Class2...)
    NumericSuffix,
    /// Random-looking alphanumeric
    RandomAlphanumeric,
}

/// Signature database for obfuscator detection
pub struct SignatureDatabase {
    /// Marker class patterns by obfuscator
    marker_classes: Vec<(ObfuscatorType, &'static str)>,
    /// Native library patterns
    native_libs: Vec<(ObfuscatorType, &'static str)>,
    /// Package name patterns
    package_patterns: Vec<(ObfuscatorType, &'static str)>,
}

lazy_static! {
    /// Global signature database instance
    pub static ref SIGNATURES: SignatureDatabase = SignatureDatabase::new();
}

impl SignatureDatabase {
    /// Create new signature database with all known patterns
    pub fn new() -> Self {
        Self {
            marker_classes: vec![
                // DexGuard
                (ObfuscatorType::DexGuard, "com/guardsquare/dexguard/"),
                (ObfuscatorType::DexGuard, "com/guardsquare/proguard/"),
                (ObfuscatorType::DexGuard, "dexguard/"),

                // Bangcle
                (ObfuscatorType::Bangcle, "com/secneo/"),
                (ObfuscatorType::Bangcle, "com/bangcle/"),

                // Qihoo 360
                (ObfuscatorType::Qihoo360, "com/qihoo/util/"),
                (ObfuscatorType::Qihoo360, "com/stub/StubApp"),

                // Tencent Legu
                (ObfuscatorType::TencentLegu, "com/tencent/bugly/legu/"),
                (ObfuscatorType::TencentLegu, "com/tencent/StubShell"),

                // Baidu
                (ObfuscatorType::Baidu, "com/baidu/protect/"),

                // iJiami
                (ObfuscatorType::IJiami, "com/shell/NativeApplication"),
                (ObfuscatorType::IJiami, "com/ijiami/"),

                // APKProtect
                (ObfuscatorType::APKProtect, "com/apkprotect/"),

                // Allatori
                (ObfuscatorType::Allatori, "com/allatori/"),

                // Arxan
                (ObfuscatorType::Arxan, "com/arxan/"),
                (ObfuscatorType::Arxan, "com/digitalai/"),
            ],

            native_libs: vec![
                // DexGuard
                (ObfuscatorType::DexGuard, "libdexguard.so"),

                // Bangcle
                (ObfuscatorType::Bangcle, "libsecexe.so"),
                (ObfuscatorType::Bangcle, "libsecmain.so"),
                (ObfuscatorType::Bangcle, "libDexHelper.so"),

                // Qihoo 360
                (ObfuscatorType::Qihoo360, "libjiagu.so"),
                (ObfuscatorType::Qihoo360, "libjiagu_x86.so"),
                (ObfuscatorType::Qihoo360, "libprotectClass.so"),

                // Tencent Legu
                (ObfuscatorType::TencentLegu, "libshell.so"),
                (ObfuscatorType::TencentLegu, "libshellx.so"),
                (ObfuscatorType::TencentLegu, "libtxAppProtect.so"),

                // Baidu
                (ObfuscatorType::Baidu, "libbaiduprotect.so"),

                // iJiami
                (ObfuscatorType::IJiami, "libexec.so"),
                (ObfuscatorType::IJiami, "libexecmain.so"),

                // APKProtect
                (ObfuscatorType::APKProtect, "libAPKProtect.so"),

                // Arxan
                (ObfuscatorType::Arxan, "libarxan.so"),
            ],

            package_patterns: vec![
                // Common obfuscated package patterns
                (ObfuscatorType::ProGuard, "a/a/a"),
                (ObfuscatorType::R8, "a/b"),
            ],
        }
    }

    /// Check if a class name matches any marker pattern
    pub fn check_marker_class(&self, class_name: &str) -> Option<ObfuscatorDetection> {
        for (obf_type, pattern) in &self.marker_classes {
            if class_name.contains(pattern) {
                return Some(ObfuscatorDetection {
                    obfuscator: *obf_type,
                    confidence: Confidence::Definite,
                    evidence: vec![format!("Marker class pattern: {}", pattern)],
                });
            }
        }
        None
    }

    /// Check if a native library name matches known patterns
    pub fn check_native_lib(&self, lib_name: &str) -> Option<ObfuscatorDetection> {
        for (obf_type, pattern) in &self.native_libs {
            if lib_name.ends_with(pattern) || lib_name.contains(pattern) {
                return Some(ObfuscatorDetection {
                    obfuscator: *obf_type,
                    confidence: Confidence::Definite,
                    evidence: vec![format!("Native library: {}", pattern)],
                });
            }
        }
        None
    }

    /// Analyze naming patterns to detect obfuscation style
    pub fn analyze_naming_pattern(&self, names: &[&str]) -> Option<NamingPattern> {
        if names.is_empty() {
            return None;
        }

        let mut single_char_count = 0;
        let mut sequential_count = 0;
        let mut prev_name: Option<&str> = None;
        let mut unicode_count = 0;
        let mut short_name_count = 0;

        for name in names {
            // Check for single char names
            if name.len() == 1 && name.chars().all(|c| c.is_ascii_lowercase()) {
                single_char_count += 1;
            }

            // Check for short names (<=3 chars)
            if name.len() <= 3 {
                short_name_count += 1;
            }

            // Check for unicode
            if name.chars().any(|c| !c.is_ascii()) {
                unicode_count += 1;
            }

            // Check for sequential pattern
            if let Some(prev) = prev_name {
                if is_sequential(prev, name) {
                    sequential_count += 1;
                }
            }
            prev_name = Some(name);
        }

        let total = names.len();
        let threshold = 0.7; // 70% of names matching pattern

        if unicode_count as f64 / total as f64 > 0.1 {
            return Some(NamingPattern::UnicodeChars);
        }

        if single_char_count as f64 / total as f64 > threshold {
            if sequential_count as f64 / (total - 1).max(1) as f64 > threshold {
                return Some(NamingPattern::SequentialSingleChar);
            }
            return Some(NamingPattern::LowercaseOnly);
        }

        if short_name_count as f64 / total as f64 > threshold {
            let avg_len = names.iter().map(|n| n.len()).sum::<usize>() / total;
            return Some(NamingPattern::ShortMixedCase(avg_len));
        }

        None
    }

    /// Detect ProGuard/R8 based on naming patterns
    pub fn detect_proguard_r8(&self, class_names: &[&str], package_names: &[&str]) -> Option<ObfuscatorDetection> {
        let mut evidence = Vec::new();

        // Check for typical a/b/c package structure
        let short_package_count = package_names.iter()
            .filter(|p| p.split('/').all(|seg| seg.len() <= 2))
            .count();

        if short_package_count as f64 / package_names.len().max(1) as f64 > 0.3 {
            evidence.push(format!("{}/{} packages have short segments", short_package_count, package_names.len()));
        }

        // Check class naming patterns
        if let Some(pattern) = self.analyze_naming_pattern(class_names) {
            match pattern {
                NamingPattern::SequentialSingleChar |
                NamingPattern::SequentialMultiChar => {
                    evidence.push(format!("Sequential naming pattern: {:?}", pattern));
                }
                NamingPattern::LowercaseOnly => {
                    evidence.push("Lowercase-only class names".to_string());
                }
                _ => {}
            }
        }

        if !evidence.is_empty() {
            // R8 is default for modern Android, ProGuard for older
            Some(ObfuscatorDetection {
                obfuscator: ObfuscatorType::R8,  // Default to R8 for modern apps
                confidence: Confidence::Medium,
                evidence,
            })
        } else {
            None
        }
    }
}

impl Default for SignatureDatabase {
    fn default() -> Self {
        Self::new()
    }
}

/// Check if two names are sequential (a->b, aa->ab, etc.)
fn is_sequential(a: &str, b: &str) -> bool {
    if a.len() != b.len() {
        // Could be aa -> ab -> ... -> az -> ba
        if b.len() == a.len() + 1 && a.chars().all(|c| c == 'z') {
            return true;
        }
        return false;
    }

    let a_chars: Vec<_> = a.chars().collect();
    let b_chars: Vec<_> = b.chars().collect();

    // Find rightmost differing position
    for i in (0..a_chars.len()).rev() {
        if a_chars[i] != b_chars[i] {
            // Check if it's increment by 1
            if a_chars[i].is_ascii_lowercase() && b_chars[i].is_ascii_lowercase() {
                if (b_chars[i] as u8) == (a_chars[i] as u8) + 1 {
                    return true;
                }
                // Wrap around z -> a with carry
                if a_chars[i] == 'z' && b_chars[i] == 'a' {
                    continue;  // Check next position for carry
                }
            }
            return false;
        }
    }

    false
}

/// Obfuscator detector that combines all detection methods
pub struct ObfuscatorDetector {
    /// Signature database
    signatures: &'static SignatureDatabase,
    /// Detected obfuscators
    detections: Vec<ObfuscatorDetection>,
}

impl ObfuscatorDetector {
    /// Create new detector
    pub fn new() -> Self {
        Self {
            signatures: &SIGNATURES,
            detections: Vec::new(),
        }
    }

    /// Add a detection result
    pub fn add_detection(&mut self, detection: ObfuscatorDetection) {
        // Check for duplicates
        if !self.detections.iter().any(|d|
            d.obfuscator == detection.obfuscator &&
            d.confidence >= detection.confidence
        ) {
            self.detections.push(detection);
        }
    }

    /// Check a class name for obfuscator signatures
    pub fn check_class(&mut self, class_name: &str) {
        if let Some(detection) = self.signatures.check_marker_class(class_name) {
            self.add_detection(detection);
        }
    }

    /// Check a native library name
    pub fn check_native_lib(&mut self, lib_name: &str) {
        if let Some(detection) = self.signatures.check_native_lib(lib_name) {
            self.add_detection(detection);
        }
    }

    /// Analyze all class names for patterns
    pub fn analyze_classes(&mut self, class_names: &[&str], package_names: &[&str]) {
        if let Some(detection) = self.signatures.detect_proguard_r8(class_names, package_names) {
            self.add_detection(detection);
        }
    }

    /// Get all detections sorted by confidence
    pub fn get_detections(&self) -> Vec<&ObfuscatorDetection> {
        let mut sorted: Vec<_> = self.detections.iter().collect();
        sorted.sort_by(|a, b| b.confidence.cmp(&a.confidence));
        sorted
    }

    /// Get primary (highest confidence) detection
    pub fn primary_detection(&self) -> Option<&ObfuscatorDetection> {
        self.get_detections().first().copied()
    }

    /// Check if any obfuscator was detected
    pub fn has_detections(&self) -> bool {
        !self.detections.is_empty()
    }
}

impl Default for ObfuscatorDetector {
    fn default() -> Self {
        Self::new()
    }
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn test_marker_class_detection() {
        let db = SignatureDatabase::new();

        // DexGuard marker
        let result = db.check_marker_class("Lcom/guardsquare/dexguard/runtime/DexGuardLoader;");
        assert!(result.is_some());
        assert_eq!(result.unwrap().obfuscator, ObfuscatorType::DexGuard);

        // Bangcle marker
        let result = db.check_marker_class("Lcom/secneo/apkwrapper/ApplicationWrapper;");
        assert!(result.is_some());
        assert_eq!(result.unwrap().obfuscator, ObfuscatorType::Bangcle);
    }

    #[test]
    fn test_native_lib_detection() {
        let db = SignatureDatabase::new();

        // Qihoo 360
        let result = db.check_native_lib("libjiagu.so");
        assert!(result.is_some());
        assert_eq!(result.unwrap().obfuscator, ObfuscatorType::Qihoo360);

        // Tencent Legu
        let result = db.check_native_lib("libshell.so");
        assert!(result.is_some());
        assert_eq!(result.unwrap().obfuscator, ObfuscatorType::TencentLegu);
    }

    #[test]
    fn test_sequential_check() {
        assert!(is_sequential("a", "b"));
        assert!(is_sequential("aa", "ab"));
        assert!(is_sequential("az", "ba"));
        assert!(!is_sequential("a", "c"));
        assert!(!is_sequential("a", "aa"));
    }

    #[test]
    fn test_naming_pattern_detection() {
        let db = SignatureDatabase::new();

        // Sequential single char
        let names = vec!["a", "b", "c", "d", "e", "f"];
        let pattern = db.analyze_naming_pattern(&names);
        assert!(matches!(pattern, Some(NamingPattern::SequentialSingleChar)));
    }

    #[test]
    fn test_proguard_detection() {
        let db = SignatureDatabase::new();

        let classes = vec!["a", "b", "c", "d", "e"];
        let packages = vec!["a", "a/b", "a/b/c"];

        let result = db.detect_proguard_r8(&classes, &packages);
        assert!(result.is_some());
    }

    #[test]
    fn test_detector_workflow() {
        let mut detector = ObfuscatorDetector::new();

        // Check some classes
        detector.check_class("Lcom/guardsquare/dexguard/Main;");
        detector.check_class("La;");
        detector.check_class("Lb;");

        assert!(detector.has_detections());
        let primary = detector.primary_detection().unwrap();
        assert_eq!(primary.obfuscator, ObfuscatorType::DexGuard);
        assert_eq!(primary.confidence, Confidence::Definite);
    }
}
