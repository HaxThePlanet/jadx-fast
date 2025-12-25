use lazy_static::lazy_static;
use regex::Regex;
use crate::metrics::Defect;

lazy_static! {
    /// Matches unreachable code: throw followed by code on next line
    pub static ref UNREACHABLE_CODE: Regex =
        Regex::new(r"throw new \w+\([^)]*\);\s*\n\s+\w+").unwrap();

    /// Matches obfuscated variables: v1, i2, length2, etc
    pub static ref OBFUSCATED_VAR: Regex =
        Regex::new(r"\b(v\d+|i\d+|length\d+|arg\d+)\b").unwrap();

    /// Matches obfuscated methods: m2325wrap, m0001, etc
    pub static ref OBFUSCATED_METHOD: Regex =
        Regex::new(r"\bm\d{4}\w*\(").unwrap();

    /// Matches obfuscated package names: p000io, p102org, etc
    pub static ref OBFUSCATED_PACKAGE: Regex =
        Regex::new(r"package p\d{3}").unwrap();

    /// Matches switch statement starts
    pub static ref SWITCH_START: Regex =
        Regex::new(r"switch\s*\([^)]+\)\s*\{").unwrap();

    /// Matches case statements
    pub static ref CASE_STMT: Regex =
        Regex::new(r"case\s+\d+\s*:|default\s*:").unwrap();

    /// Matches method declarations
    pub static ref METHOD_DECL: Regex =
        Regex::new(r"(?m)^\s*(public|private|protected|static|\s)*\s+\w+\s+\w+\s*\([^)]*\)\s*\{").unwrap();

    /// Matches field declarations
    pub static ref FIELD_DECL: Regex =
        Regex::new(r"(?m)^\s*(public|private|protected|static|\s)*\s+(\w+)\s+(\w+)\s*(=|;)").unwrap();

    /// Matches try-catch blocks
    pub static ref TRY_CATCH: Regex =
        Regex::new(r"try\s*\{").unwrap();

    /// Matches catch handlers
    pub static ref CATCH_HANDLER: Regex =
        Regex::new(r"catch\s*\([^)]+\)\s*\{").unwrap();

    /// Matches multiple variable declarations (same name redeclared)
    pub static ref MULTI_DECL: Regex =
        Regex::new(r"(?m)(int|String|Object|boolean|long|double|float|byte|short|char)\s+(\w+)\s*=").unwrap();
}

/// Detect defects in Java source code
pub fn detect_defects(content: &str, class_name: &str) -> Vec<Defect> {
    let mut defects = Vec::new();

    // Detect unreachable code
    if let Some(caps) = UNREACHABLE_CODE.captures(content) {
        if let Some(matched) = caps.get(0) {
            let line = content[..matched.start()].lines().count();
            defects.push(Defect::UnreachableCode {
                line,
                context: matched.as_str().to_string(),
            });
        }
    }

    // Detect multiple variable declarations
    let mut var_decls: std::collections::HashMap<String, usize> = std::collections::HashMap::new();
    for line_match in MULTI_DECL.captures_iter(content) {
        if let Some(var_name) = line_match.get(2) {
            *var_decls.entry(var_name.as_str().to_string()).or_insert(0) += 1;
        }
    }

    for (var_name, count) in var_decls {
        if count > 1 {
            defects.push(Defect::MultipleDeclaration {
                variable: var_name,
                line: 0, // Would need more complex parsing to get exact line
            });
        }
    }

    // Detect obfuscated package names
    if OBFUSCATED_PACKAGE.is_match(content) {
        if let Some(caps) = OBFUSCATED_PACKAGE.captures(content) {
            if let Some(matched) = caps.get(0) {
                defects.push(Defect::ObfuscatedPackage {
                    name: matched.as_str().to_string(),
                });
            }
        }
    }

    defects
}

/// Analyze variable naming quality (0.0 = all cryptic, 1.0 = all meaningful)
pub fn analyze_variable_quality(content: &str) -> f32 {
    let mut total = 0;
    let mut cryptic = 0;

    for caps in MULTI_DECL.captures_iter(content) {
        if let Some(var_name) = caps.get(2) {
            total += 1;
            let name = var_name.as_str();

            // Check for cryptic patterns
            if (name.starts_with('v') && name[1..].chars().all(|c| c.is_numeric()))
                || (name.starts_with('i') && name[1..].chars().all(|c| c.is_numeric()))
                || name.starts_with("arg") && name[3..].chars().all(|c| c.is_numeric())
                || (name.starts_with("length") && name.len() > 6)
            {
                cryptic += 1;
            }
        }
    }

    if total == 0 {
        return 1.0;
    }

    1.0 - (cryptic as f32 / total as f32)
}

/// Analyze method naming quality (0.0 = all cryptic, 1.0 = all meaningful)
pub fn analyze_method_quality(content: &str) -> f32 {
    let mut total = 0;
    let mut cryptic = 0;

    for caps in METHOD_DECL.captures_iter(content) {
        if let Some(matched) = caps.get(0) {
            total += 1;
            let method_sig = matched.as_str();

            // Extract method name (rough heuristic: last word before parenthesis)
            if let Some(paren_idx) = method_sig.rfind('(') {
                let before_paren = &method_sig[..paren_idx];
                if let Some(space_idx) = before_paren.rfind(' ') {
                    let method_name = &before_paren[space_idx + 1..];

                    if method_name.starts_with('m') && method_name[1..].chars().take(4).all(|c| c.is_numeric()) {
                        cryptic += 1;
                    }
                }
            }
        }
    }

    if total == 0 {
        return 1.0;
    }

    1.0 - (cryptic as f32 / total as f32)
}

/// Analyze package naming quality
pub fn analyze_package_quality(content: &str) -> f32 {
    if OBFUSCATED_PACKAGE.is_match(content) {
        0.0 // Package is obfuscated
    } else {
        1.0 // Package appears clean
    }
}

/// Count lines of code (excluding comments and blank lines)
pub fn count_loc(content: &str) -> usize {
    content
        .lines()
        .filter(|line| {
            let trimmed = line.trim();
            !trimmed.is_empty()
                && !trimmed.starts_with("//")
                && !trimmed.starts_with("/*")
                && !trimmed.starts_with("*")
        })
        .count()
}

/// Count method declarations
pub fn count_methods(content: &str) -> usize {
    METHOD_DECL.find_iter(content).count()
}

/// Count field declarations
pub fn count_fields(content: &str) -> usize {
    // Rough heuristic: count field-like declarations at class level (simple version)
    FIELD_DECL.find_iter(content).count()
}

/// Detect incomplete switch statement (empty body or few cases)
pub fn detect_incomplete_switch(content: &str) -> bool {
    if let Some(switch_match) = SWITCH_START.find(content) {
        let after_switch = &content[switch_match.end()..];

        // Find matching closing brace
        let mut brace_count = 1;
        let mut pos = 0;
        for (i, ch) in after_switch.chars().enumerate() {
            if ch == '{' {
                brace_count += 1;
            } else if ch == '}' {
                brace_count -= 1;
                if brace_count == 0 {
                    pos = i;
                    break;
                }
            }
        }

        let switch_body = &after_switch[..pos];
        let case_count = CASE_STMT.find_iter(switch_body).count();

        // Flag as incomplete if < 2 cases or empty body
        case_count < 2 || switch_body.trim().is_empty()
    } else {
        false
    }
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn test_unreachable_code_detection() {
        let code = r#"
        switch (x) {
            case 0: return "A";
            case 1: return "B";
        }
        throw new Exception("error");
        return null;
        "#;
        let defects = detect_defects(code, "Test");
        assert!(defects.iter().any(|d| matches!(d, Defect::UnreachableCode { .. })));
    }

    #[test]
    fn test_cryptic_variable_detection() {
        let code = r#"
        int v1 = 0;
        int v2 = v1 + 1;
        String str = "hello";
        "#;
        let quality = analyze_variable_quality(code);
        assert!(quality < 1.0); // Should have some cryptic names
    }

    #[test]
    fn test_obfuscated_package_detection() {
        let code = "package p102io.reactivex;";
        let defects = detect_defects(code, "Test");
        assert!(defects.iter().any(|d| matches!(d, Defect::ObfuscatedPackage { .. })));
    }
}
