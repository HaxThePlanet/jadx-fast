//! Type inference refinement using bytecode analysis

use anyhow::Result;
use crate::client::ClaudeClient;

pub struct TypeRefiner {
    client: ClaudeClient,
}

impl TypeRefiner {
    pub fn new(client: ClaudeClient) -> Self {
        Self { client }
    }

    /// Refine type annotations using bytecode context
    pub async fn refine_types(
        &self,
        decompiled_code: &str,
        bytecode_context: &str,
    ) -> Result<String> {
        // Detect type anomalies (Unknown types, type mismatches)
        let type_issues = self.detect_type_issues(decompiled_code);

        if type_issues.is_empty() {
            return Ok(decompiled_code.to_string());
        }

        // Build analysis context
        let context = self.build_analysis_context(decompiled_code, bytecode_context, &type_issues);

        // Get LLM refinement suggestions
        let refinements = self.get_llm_refinements(&context).await?;

        // Apply refinements
        let result = self.apply_refinements(decompiled_code, &refinements);

        Ok(result)
    }

    /// Detect type annotation issues
    fn detect_type_issues(&self, code: &str) -> Vec<TypeIssue> {
        let mut issues = Vec::new();

        // Detect "Object" fallback types that should be refined
        for (i, line) in code.lines().enumerate() {
            if line.contains("Object ") && !line.contains("new Object") {
                issues.push(TypeIssue {
                    line_number: i,
                    line: line.to_string(),
                    issue_type: "ObjectFallback".to_string(),
                    description: "Variable typed as Object (likely should be refined)".to_string(),
                });
            }

            // Detect type comparisons that might be wrong
            if line.contains("== 0") && (line.contains("String") || line.contains("List") || line.contains("Map")) {
                issues.push(TypeIssue {
                    line_number: i,
                    line: line.to_string(),
                    issue_type: "TypeMismatch".to_string(),
                    description: "Comparing object to 0 (should be == null)".to_string(),
                });
            }

            // Detect Unknown types
            if line.contains("Unknown") || line.contains("<?>") {
                issues.push(TypeIssue {
                    line_number: i,
                    line: line.to_string(),
                    issue_type: "UnknownType".to_string(),
                    description: "Unknown type detected".to_string(),
                });
            }
        }

        issues
    }

    /// Build context for type analysis
    fn build_analysis_context(
        &self,
        decompiled_code: &str,
        bytecode_context: &str,
        issues: &[TypeIssue],
    ) -> String {
        let mut context = String::new();

        context.push_str("Decompiled Java code:\n");
        context.push_str(decompiled_code);
        context.push_str("\n\n");

        context.push_str("Bytecode representation (for type inference):\n");
        context.push_str(bytecode_context);
        context.push_str("\n\n");

        context.push_str("Type issues detected:\n");
        for issue in issues.iter().take(10) {
            context.push_str(&format!(
                "Line {}: {} - {}\nCode: {}\n\n",
                issue.line_number, issue.issue_type, issue.description, issue.line
            ));
        }

        context
    }

    /// Get LLM type refinement suggestions
    async fn get_llm_refinements(&self, context: &str) -> Result<Vec<TypeRefinement>> {
        let system_prompt = r#"You are a Java type inference expert analyzing decompiled bytecode.

Given decompiled code with type annotation issues and the bytecode context,
suggest type refinements that would improve type accuracy.

Rules:
1. If Object is used but should be more specific (List, Map, String, etc.), suggest refinement
2. If Unknown type exists, try to infer from bytecode operations
3. If comparison to 0 happens with object, suggest == null instead
4. Use bytecode opcodes to determine actual types

Return a JSON array with refinements:
[
  {"line": 5, "old_type": "Object", "new_type": "List<String>"},
  {"line": 10, "old_code": "== 0", "new_code": "== null"}
]

Be conservative - only suggest changes you're certain about."#;

        let response = self.client.call(system_prompt, context).await?;

        // Parse JSON response
        let refinements: Vec<TypeRefinement> = serde_json::from_str(&response)
            .ok()
            .and_then(|arr: serde_json::Value| {
                arr.as_array().map(|items| {
                    items
                        .iter()
                        .filter_map(|item| {
                            let line = item["line"].as_i64();
                            let old_type = item["old_type"].as_str();
                            let new_type = item["new_type"].as_str();

                            if let (Some(l), Some(ot), Some(nt)) = (line, old_type, new_type) {
                                return Some(TypeRefinement {
                                    line: l as usize,
                                    old_type: ot.to_string(),
                                    new_type: nt.to_string(),
                                });
                            }
                            None
                        })
                        .collect()
                })
            })
            .unwrap_or_default();

        Ok(refinements)
    }

    /// Apply type refinements
    fn apply_refinements(&self, code: &str, refinements: &[TypeRefinement]) -> String {
        let mut result = code.to_string();

        for refinement in refinements {
            let lines: Vec<&str> = result.lines().collect();
            if refinement.line < lines.len() {
                let line = lines[refinement.line];
                let updated_line = line.replace(&refinement.old_type, &refinement.new_type);
                result = result.replacen(line, &updated_line, 1);
            }
        }

        result
    }
}

#[derive(Debug, Clone)]
struct TypeIssue {
    line_number: usize,
    line: String,
    issue_type: String,
    description: String,
}

#[derive(Debug, Clone)]
struct TypeRefinement {
    line: usize,
    old_type: String,
    new_type: String,
}

#[cfg(test)]
mod tests {
    use super::*;
    use crate::config::LLMBackend;

    #[test]
    fn test_detect_type_issues() {
        let client = ClaudeClient::new(
            LLMBackend::Ollama,
            String::new(),
            "test-model".to_string(),
            "http://localhost:11434".to_string(),
        ).unwrap();
        let refiner = TypeRefiner::new(client);

        let code = r#"
        Object data = getData();
        String str = "test";
        if (str == 0) {
            System.out.println("error");
        }
        "#;

        let issues = refiner.detect_type_issues(code);
        assert!(!issues.is_empty());
    }

    #[test]
    fn test_apply_refinements() {
        let client = ClaudeClient::new(
            LLMBackend::Ollama,
            String::new(),
            "test-model".to_string(),
            "http://localhost:11434".to_string(),
        ).unwrap();
        let refiner = TypeRefiner::new(client);

        let code = "Object data = getData();";
        let refinements = vec![TypeRefinement {
            line: 0,
            old_type: "Object".to_string(),
            new_type: "List<String>".to_string(),
        }];

        let result = refiner.apply_refinements(code, &refinements);
        assert!(result.contains("List<String>"));
    }
}
