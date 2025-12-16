//! Code correction and error fixing module

use anyhow::Result;
use crate::client::ClaudeClient;

pub struct CodeCorrector {
    client: ClaudeClient,
}

impl CodeCorrector {
    pub fn new(client: ClaudeClient) -> Self {
        Self { client }
    }

    /// Detect and correct errors in decompiled code
    pub async fn correct_code(
        &self,
        decompiled_code: &str,
        bytecode_context: Option<&str>,
    ) -> Result<String> {
        // Detect compilation errors and logic issues
        let errors = self.detect_errors(decompiled_code);

        if errors.is_empty() {
            return Ok(decompiled_code.to_string());
        }

        // Build correction context
        let context = self.build_correction_context(
            decompiled_code,
            bytecode_context,
            &errors,
        );

        // Get LLM corrections
        let corrections = self.get_llm_corrections(&context).await?;

        // Apply corrections
        let result = self.apply_corrections(decompiled_code, &corrections);

        Ok(result)
    }

    /// Detect compilation and logic errors
    fn detect_errors(&self, code: &str) -> Vec<CodeError> {
        let mut errors = Vec::new();

        for (i, line) in code.lines().enumerate() {
            // Detect undefined variable references
            if line.contains("undefined") || line.contains("unresolved") {
                errors.push(CodeError {
                    line_number: i,
                    line: line.to_string(),
                    error_type: "UndefinedVariable".to_string(),
                    severity: "high".to_string(),
                });
            }

            // Detect return type mismatches
            if line.contains("return") {
                if (line.contains("return 0;") || line.contains("return false;"))
                    && (code[..i].contains("Object") || code[..i].contains("String"))
                {
                    errors.push(CodeError {
                        line_number: i,
                        line: line.to_string(),
                        error_type: "ReturnTypeMismatch".to_string(),
                        severity: "high".to_string(),
                    });
                }
            }

            // Detect unreachable code
            if (line.contains("throw ") || line.contains("return "))
                && i + 1 < code.lines().count()
            {
                let next_line = code.lines().nth(i + 1).unwrap_or("");
                if !next_line.trim().is_empty()
                    && !next_line.trim().starts_with("}")
                    && !next_line.trim().starts_with("catch")
                {
                    errors.push(CodeError {
                        line_number: i + 1,
                        line: next_line.to_string(),
                        error_type: "UnreachableCode".to_string(),
                        severity: "medium".to_string(),
                    });
                }
            }

            // Detect missing method bodies
            if line.contains("void") || line.contains("public") || line.contains("private") {
                if line.trim().ends_with("{")
                    && i + 1 < code.lines().count()
                {
                    let next_line = code.lines().nth(i + 1).unwrap_or("").trim();
                    if next_line.starts_with("}") {
                        errors.push(CodeError {
                            line_number: i,
                            line: line.to_string(),
                            error_type: "EmptyMethodBody".to_string(),
                            severity: "medium".to_string(),
                        });
                    }
                }
            }
        }

        errors
    }

    /// Build context for code correction
    fn build_correction_context(
        &self,
        decompiled_code: &str,
        bytecode_context: Option<&str>,
        errors: &[CodeError],
    ) -> String {
        let mut context = String::new();

        context.push_str("Decompiled Java code with errors:\n");
        context.push_str(decompiled_code);
        context.push_str("\n\n");

        if let Some(bytecode) = bytecode_context {
            context.push_str("Bytecode (for correction reference):\n");
            context.push_str(bytecode);
            context.push_str("\n\n");
        }

        context.push_str("Detected errors:\n");
        for error in errors.iter().take(10) {
            context.push_str(&format!(
                "Line {}: [{}] {} - {}\n",
                error.line_number, error.severity, error.error_type, error.line
            ));
        }

        context
    }

    /// Get LLM code corrections
    async fn get_llm_corrections(&self, context: &str) -> Result<Vec<CodeFix>> {
        let system_prompt = r#"You are an expert Java decompiler correction system.

Given decompiled code with known errors and bytecode context,
provide corrections that fix compilation and logic errors.

Rules:
1. Fix undefined variables (check bytecode for correct references)
2. Fix return type mismatches (0 -> null for objects)
3. Remove unreachable code after return/throw
4. Complete empty method bodies based on bytecode
5. Fix logic inversions (inverted if conditions)
6. Add missing variable declarations

Return a JSON array of fixes:
[
  {"line": 5, "old_code": "return 0;", "new_code": "return null;"},
  {"line": 10, "old_code": "if (x == 0)", "new_code": "if (x == null)"}
]

Be conservative and correct - changes must be supported by bytecode."#;

        let response = self.client.call(system_prompt, context).await?;

        // Parse JSON response
        let fixes: Vec<CodeFix> = serde_json::from_str(&response)
            .ok()
            .and_then(|arr: serde_json::Value| {
                arr.as_array().map(|items| {
                    items
                        .iter()
                        .filter_map(|item| {
                            let line = item["line"].as_i64();
                            let old_code = item["old_code"].as_str();
                            let new_code = item["new_code"].as_str();

                            if let (Some(l), Some(old), Some(new)) = (line, old_code, new_code) {
                                return Some(CodeFix {
                                    line: l as usize,
                                    old_code: old.to_string(),
                                    new_code: new.to_string(),
                                });
                            }
                            None
                        })
                        .collect()
                })
            })
            .unwrap_or_default();

        Ok(fixes)
    }

    /// Apply code corrections
    fn apply_corrections(&self, code: &str, fixes: &[CodeFix]) -> String {
        let mut result = code.to_string();

        for fix in fixes {
            result = result.replace(&fix.old_code, &fix.new_code);
        }

        result
    }
}

#[derive(Debug, Clone)]
struct CodeError {
    line_number: usize,
    line: String,
    error_type: String,
    severity: String,
}

#[derive(Debug, Clone)]
struct CodeFix {
    line: usize,
    old_code: String,
    new_code: String,
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn test_detect_errors() {
        let corrector = CodeCorrector::new(
            ClaudeClient::new("test".to_string(), "model".to_string()).unwrap()
        );

        let code = r#"
        public void test() {
            String result = null;
            return 0;
            System.out.println("never reached");
        }
        "#;

        let errors = corrector.detect_errors(code);
        assert!(!errors.is_empty());
    }

    #[test]
    fn test_apply_corrections() {
        let corrector = CodeCorrector::new(
            ClaudeClient::new("test".to_string(), "model".to_string()).unwrap()
        );

        let code = "return 0;";
        let fixes = vec![CodeFix {
            line: 0,
            old_code: "return 0;".to_string(),
            new_code: "return null;".to_string(),
        }];

        let result = corrector.apply_corrections(code, &fixes);
        assert_eq!(result, "return null;");
    }
}
