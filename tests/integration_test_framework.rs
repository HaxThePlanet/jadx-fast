//! Integration test framework for dexterity
//!
//! This module provides utilities to test decompilation end-to-end,
//! similar to Java JADX's IntegrationTest class.
//!
//! Test pattern:
//! 1. Compile Java source to .class using javac
//! 2. Convert .class to .dex using d8 (or dx fallback)
//! 3. Decompile .dex using dexterity CLI
//! 4. Assert on decompiled output
//!
//! ## Tool Requirements
//!
//! - `javac` - Java compiler (required)
//! - `d8` or `dx` - DEX compiler (required; from Android SDK)
//!
//! If tools are not available, tests will be skipped with a clear message.

use std::collections::HashMap;
use std::fs;
use std::path::{Path, PathBuf};
use std::process::Command;
use std::sync::OnceLock;

/// Check if required tools are available (cached for performance)
static TOOLS_AVAILABLE: OnceLock<ToolsStatus> = OnceLock::new();

#[derive(Debug, Clone)]
pub struct ToolsStatus {
    pub javac: bool,
    pub d8: bool,
    pub dx: bool,
}

impl ToolsStatus {
    fn check() -> Self {
        Self {
            javac: Command::new("javac").arg("--version").output().map(|o| o.status.success()).unwrap_or(false),
            d8: Command::new("d8").arg("--version").output().map(|o| o.status.success()).unwrap_or(false),
            dx: Command::new("dx").arg("--version").output().map(|o| o.status.success()).unwrap_or(false),
        }
    }

    pub fn can_run_tests(&self) -> bool {
        self.javac && (self.d8 || self.dx)
    }

    pub fn dex_tool(&self) -> Option<&'static str> {
        if self.d8 {
            Some("d8")
        } else if self.dx {
            Some("dx")
        } else {
            None
        }
    }

    pub fn skip_reason(&self) -> String {
        let mut missing = Vec::new();
        if !self.javac {
            missing.push("javac");
        }
        if !self.d8 && !self.dx {
            missing.push("d8/dx (Android SDK)");
        }
        format!("Missing tools: {}", missing.join(", "))
    }
}

/// Get cached tool status
pub fn tools_status() -> &'static ToolsStatus {
    TOOLS_AVAILABLE.get_or_init(ToolsStatus::check)
}

/// Skip test if required tools are not available
#[macro_export]
macro_rules! skip_if_no_tools {
    () => {
        let status = $crate::integration_test_framework::tools_status();
        if !status.can_run_tests() {
            eprintln!("SKIPPED: {}", status.skip_reason());
            return;
        }
    };
}

/// Integration test helper
pub struct IntegrationTestHelper {
    temp_dir: PathBuf,
    test_name: String,
    /// Include debug info when compiling (default: true)
    pub include_debug_info: bool,
}

impl IntegrationTestHelper {
    /// Create a new test helper with automatic temp directory
    pub fn new(test_name: &str) -> Self {
        let temp_dir = std::env::temp_dir().join(format!("dexterity_test_{}", test_name));
        let _ = fs::remove_dir_all(&temp_dir);
        fs::create_dir_all(&temp_dir).expect("Failed to create temp dir");

        Self {
            temp_dir,
            test_name: test_name.to_string(),
            include_debug_info: true,
        }
    }

    /// Disable debug info in compiled class files
    pub fn no_debug_info(&mut self) -> &mut Self {
        self.include_debug_info = false;
        self
    }

    /// Compile Java source to .class file
    pub fn compile_java(&self, java_source: &str) -> Result<Vec<PathBuf>, String> {
        // Extract class name from source
        let class_name = extract_class_name(java_source)
            .ok_or("Failed to extract class name from source")?;

        // Write Java source file
        let java_file = self.temp_dir.join(format!("{}.java", class_name));
        fs::write(&java_file, java_source)
            .map_err(|e| format!("Failed to write Java source: {}", e))?;

        // Build javac arguments
        let mut args = vec!["-source", "11", "-target", "11"];
        if self.include_debug_info {
            args.push("-g");
        } else {
            args.push("-g:none");
        }

        // Compile with javac
        let output = Command::new("javac")
            .args(&args)
            .arg(&java_file)
            .current_dir(&self.temp_dir)
            .output()
            .map_err(|e| format!("Failed to run javac: {}", e))?;

        if !output.status.success() {
            return Err(format!(
                "javac failed:\nstderr: {}",
                String::from_utf8_lossy(&output.stderr)
            ));
        }

        // Find all generated .class files (handles inner classes)
        let mut class_files = Vec::new();
        for entry in fs::read_dir(&self.temp_dir).map_err(|e| e.to_string())? {
            let entry = entry.map_err(|e| e.to_string())?;
            let path = entry.path();
            if path.extension().map(|e| e == "class").unwrap_or(false) {
                class_files.push(path);
            }
        }

        if class_files.is_empty() {
            return Err("No .class files generated".to_string());
        }

        Ok(class_files)
    }

    /// Convert .class files to .dex using d8 or dx
    pub fn class_to_dex(&self, class_files: &[PathBuf]) -> Result<PathBuf, String> {
        let status = tools_status();
        let dex_file = self.temp_dir.join("classes.dex");

        if status.d8 {
            // Use d8 (preferred)
            let output = Command::new("d8")
                .arg("--output")
                .arg(&self.temp_dir)
                .args(class_files)
                .output()
                .map_err(|e| format!("Failed to run d8: {}", e))?;

            if output.status.success() {
                return Ok(dex_file);
            }
            // Fall through to try dx
        }

        if status.dx {
            // Use dx (legacy fallback)
            let mut cmd = Command::new("dx");
            cmd.arg("--dex")
                .arg(format!("--output={}", dex_file.display()));
            for class_file in class_files {
                cmd.arg(class_file);
            }

            let output = cmd.output()
                .map_err(|e| format!("Failed to run dx: {}", e))?;

            if output.status.success() {
                return Ok(dex_file);
            }

            return Err(format!(
                "dx failed:\nstderr: {}",
                String::from_utf8_lossy(&output.stderr)
            ));
        }

        Err("Neither d8 nor dx is available".to_string())
    }

    /// Decompile .dex file using dexterity CLI
    pub fn decompile_dex(&self, dex_file: &Path) -> Result<HashMap<String, String>, String> {
        let out_dir = self.temp_dir.join("decompiled");
        fs::create_dir_all(&out_dir).map_err(|e| e.to_string())?;

        // Run dexterity CLI
        let output = Command::new(env!("CARGO_BIN_EXE_dexterity"))
            .args(["-d", out_dir.to_str().unwrap()])
            .arg(dex_file)
            .output()
            .map_err(|e| format!("Failed to run dexterity: {}", e))?;

        if !output.status.success() {
            return Err(format!(
                "dexterity failed:\nstderr: {}",
                String::from_utf8_lossy(&output.stderr)
            ));
        }

        // Collect all Java files from output
        let sources_dir = out_dir.join("sources");
        if !sources_dir.exists() {
            return Err("No sources directory in output".to_string());
        }

        let mut files = HashMap::new();
        collect_java_files(&sources_dir, &sources_dir, &mut files)?;
        Ok(files)
    }

    /// Full end-to-end test: compile Java -> DEX -> decompile
    pub fn test_decompilation(&self, java_source: &str) -> Result<String, String> {
        let class_files = self.compile_java(java_source)?;
        let dex_file = self.class_to_dex(&class_files)?;
        let results = self.decompile_dex(&dex_file)?;

        // Return the main class (not inner classes)
        let main_class_name = extract_class_name(java_source)
            .ok_or("Failed to extract class name")?;

        // Look for exact match first
        for (path, content) in &results {
            if path.ends_with(&format!("{}.java", main_class_name)) {
                return Ok(content.clone());
            }
        }

        // If not found, return the first result
        results.values()
            .next()
            .cloned()
            .ok_or_else(|| "No decompiled output".to_string())
    }

    /// Get all decompiled classes
    pub fn test_decompilation_all(&self, java_source: &str) -> Result<HashMap<String, String>, String> {
        let class_files = self.compile_java(java_source)?;
        let dex_file = self.class_to_dex(&class_files)?;
        self.decompile_dex(&dex_file)
    }
}

impl Drop for IntegrationTestHelper {
    fn drop(&mut self) {
        // Clean up temp directory
        let _ = fs::remove_dir_all(&self.temp_dir);
    }
}

/// Recursively collect Java files from a directory
fn collect_java_files(
    base: &Path,
    dir: &Path,
    files: &mut HashMap<String, String>,
) -> Result<(), String> {
    for entry in fs::read_dir(dir).map_err(|e| e.to_string())? {
        let entry = entry.map_err(|e| e.to_string())?;
        let path = entry.path();

        if path.is_dir() {
            collect_java_files(base, &path, files)?;
        } else if path.extension().map(|e| e == "java").unwrap_or(false) {
            let rel_path = path.strip_prefix(base).unwrap().to_string_lossy().to_string();
            let content = fs::read_to_string(&path).map_err(|e| e.to_string())?;
            files.insert(rel_path, content);
        }
    }
    Ok(())
}

/// Extract class name from Java source
fn extract_class_name(source: &str) -> Option<String> {
    for line in source.lines() {
        let trimmed = line.trim();
        // Handle: public class Foo, class Foo, abstract class Foo, final class Foo, etc.
        if let Some(idx) = trimmed.find(" class ") {
            let after_class = &trimmed[idx + 7..];
            let name = after_class
                .split(|c: char| !c.is_alphanumeric() && c != '_')
                .next()?;
            if !name.is_empty() {
                return Some(name.to_string());
            }
        }
        // Handle: class Foo at start of line
        if trimmed.starts_with("class ") {
            let after_class = &trimmed[6..];
            let name = after_class
                .split(|c: char| !c.is_alphanumeric() && c != '_')
                .next()?;
            if !name.is_empty() {
                return Some(name.to_string());
            }
        }
    }
    None
}

// ============================================================================
// Assertion helpers for decompiled code
// ============================================================================

/// Fluent assertion trait for decompiled code
pub trait CodeAssertions {
    /// Assert that the code contains the expected substring
    fn contains(&self, expected: &str) -> &Self;

    /// Assert that the code contains exactly one occurrence of the expected substring
    fn contains_one(&self, expected: &str) -> &Self;

    /// Assert that the code contains exactly N occurrences of the pattern
    fn count_string(&self, expected_count: usize, pattern: &str) -> &Self;

    /// Assert that the code does NOT contain the unexpected substring
    fn does_not_contain(&self, unexpected: &str) -> &Self;

    /// Count occurrences of a pattern
    fn count_of(&self, pattern: &str) -> usize;

    /// Assert code contains a pattern matching the regex
    fn matches_pattern(&self, pattern: &str) -> &Self;
}

impl CodeAssertions for String {
    fn contains(&self, expected: &str) -> &Self {
        assert!(
            self.as_str().contains(expected),
            "Expected code to contain: {}\n\nActual code:\n{}",
            expected,
            self
        );
        self
    }

    fn contains_one(&self, expected: &str) -> &Self {
        let count = self.count_of(expected);
        assert_eq!(
            count, 1,
            "Expected exactly 1 occurrence of: {}\nFound: {}\n\nActual code:\n{}",
            expected, count, self
        );
        self
    }

    fn count_string(&self, expected_count: usize, pattern: &str) -> &Self {
        let count = self.count_of(pattern);
        assert_eq!(
            count, expected_count,
            "Expected {} occurrences of: {}\nFound: {}\n\nActual code:\n{}",
            expected_count, pattern, count, self
        );
        self
    }

    fn does_not_contain(&self, unexpected: &str) -> &Self {
        assert!(
            !self.as_str().contains(unexpected),
            "Expected code NOT to contain: {}\n\nActual code:\n{}",
            unexpected,
            self
        );
        self
    }

    fn count_of(&self, pattern: &str) -> usize {
        self.matches(pattern).count()
    }

    fn matches_pattern(&self, pattern: &str) -> &Self {
        // Simple pattern matching (for more complex patterns, use regex crate)
        assert!(
            self.as_str().contains(pattern),
            "Expected code to match pattern: {}\n\nActual code:\n{}",
            pattern,
            self
        );
        self
    }
}

impl CodeAssertions for str {
    fn contains(&self, expected: &str) -> &Self {
        assert!(
            self.contains(expected),
            "Expected code to contain: {}\n\nActual code:\n{}",
            expected,
            self
        );
        self
    }

    fn contains_one(&self, expected: &str) -> &Self {
        let count = self.count_of(expected);
        assert_eq!(
            count, 1,
            "Expected exactly 1 occurrence of: {}\nFound: {}\n\nActual code:\n{}",
            expected, count, self
        );
        self
    }

    fn count_string(&self, expected_count: usize, pattern: &str) -> &Self {
        let count = self.count_of(pattern);
        assert_eq!(
            count, expected_count,
            "Expected {} occurrences of: {}\nFound: {}\n\nActual code:\n{}",
            expected_count, pattern, count, self
        );
        self
    }

    fn does_not_contain(&self, unexpected: &str) -> &Self {
        assert!(
            !self.contains(unexpected),
            "Expected code NOT to contain: {}\n\nActual code:\n{}",
            unexpected,
            self
        );
        self
    }

    fn count_of(&self, pattern: &str) -> usize {
        self.matches(pattern).count()
    }

    fn matches_pattern(&self, pattern: &str) -> &Self {
        assert!(
            self.contains(pattern),
            "Expected code to match pattern: {}\n\nActual code:\n{}",
            pattern,
            self
        );
        self
    }
}

// ============================================================================
// Unit tests for the framework itself
// ============================================================================

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn test_extract_class_name() {
        assert_eq!(
            extract_class_name("public class TestCls {"),
            Some("TestCls".to_string())
        );
        assert_eq!(
            extract_class_name("class Foo {"),
            Some("Foo".to_string())
        );
        assert_eq!(
            extract_class_name("public abstract class Bar extends Base {"),
            Some("Bar".to_string())
        );
        assert_eq!(
            extract_class_name("public final class Baz implements I {"),
            Some("Baz".to_string())
        );
        assert_eq!(
            extract_class_name("// comment\npublic class Test {\n}"),
            Some("Test".to_string())
        );
    }

    #[test]
    fn test_tools_status() {
        let status = tools_status();
        println!("Tools status: {:?}", status);
        println!("Can run tests: {}", status.can_run_tests());
        if !status.can_run_tests() {
            println!("Skip reason: {}", status.skip_reason());
        }
    }

    #[test]
    fn test_code_assertions() {
        let code = "public class Foo { int x = 5; }".to_string();
        code.contains("class Foo")
            .contains("int x")
            .does_not_contain("class Bar")
            .count_string(1, "class");
    }
}
