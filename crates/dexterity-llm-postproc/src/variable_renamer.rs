//! LLM-based variable renaming module

use anyhow::Result;
use regex::Regex;
use crate::client::ClaudeClient;

pub struct VariableRenamer {
    client: ClaudeClient,
}

impl VariableRenamer {
    pub fn new(client: ClaudeClient) -> Self {
        Self { client }
    }

    /// Rename variables in decompiled code using LLM context
    pub async fn rename_variables(
        &self,
        decompiled_code: &str,
        bytecode_context: Option<&str>,
    ) -> Result<String> {
        // Extract variables that need renaming (register-based names like v0, v1, r0, etc.)
        let variables = self.extract_variables_to_rename(decompiled_code);

        if variables.is_empty() {
            return Ok(decompiled_code.to_string());
        }

        // Build context for LLM
        let context = self.build_context(decompiled_code, bytecode_context, &variables);

        // Generate renaming suggestions
        let suggestions = self.get_llm_suggestions(&context).await?;

        // Apply renames
        let result = self.apply_renames(decompiled_code, &suggestions);

        Ok(result)
    }

    /// Extract variables that need renaming
    /// Looks for: v0-v999, r0-r999, p0-p999 (register-based names)
    fn extract_variables_to_rename(&self, code: &str) -> Vec<(String, usize)> {
        let register_pattern = Regex::new(r"\b([vpr]\d{1,3})\b").unwrap();

        let mut vars = Vec::new();
        for cap in register_pattern.captures_iter(code) {
            let var = cap[1].to_string();
            if !vars.iter().any(|(v, _)| v == &var) {
                let count = code.matches(&format!(" {} ", var)).count()
                    + code.matches(&format!("({}", var)).count()
                    + code.matches(&format!("{})", var)).count();
                vars.push((var, count));
            }
        }

        // Sort by frequency (most common first for better context)
        vars.sort_by(|a, b| b.1.cmp(&a.1));
        vars
    }

    /// Build context for LLM analysis
    fn build_context(
        &self,
        decompiled_code: &str,
        bytecode_context: Option<&str>,
        variables: &[(String, usize)],
    ) -> String {
        let mut context = String::new();

        context.push_str("Decompiled Java code:\n");
        context.push_str(decompiled_code);
        context.push_str("\n\n");

        if let Some(bytecode) = bytecode_context {
            context.push_str("Bytecode context (for reference):\n");
            context.push_str(bytecode);
            context.push_str("\n\n");
        }

        context.push_str("Variables to rename:\n");
        for (var, count) in variables.iter().take(10) {
            context.push_str(&format!("- {} (appears {} times)\n", var, count));
        }

        context
    }

    /// Get LLM suggestions for variable names
    async fn get_llm_suggestions(&self, context: &str) -> Result<Vec<(String, String)>> {
        let system_prompt = r#"You are a Java code analyzer specializing in variable naming.

Given decompiled Java code with register-based variable names (v0, v1, r0, etc.) and bytecode context,
suggest meaningful variable names that improve code readability.

Rules:
1. Suggest names based on usage patterns: field access, method calls, type casts
2. For arrays: suggest names with 'Arr' suffix (e.g., 'v2' used as array -> 'dataArr')
3. For collections: suggest names like 'list', 'map', 'queue'
4. For primitives: suggest short names like 'i', 'j', 'count', 'index', 'size'
5. For objects: use descriptive names matching their usage
6. Keep names that are already meaningful (don't rename 'context', 'activity', etc.)

Return ONLY a JSON mapping of old->new names, nothing else:
{"v0": "userData", "v1": "responseData", "v2": "resultList"}

Be conservative - only suggest names you're confident about."#;

        let response = self.client.call(system_prompt, context).await?;

        // Parse JSON response
        let suggestions: Vec<(String, String)> = serde_json::from_str(&response)
            .ok()
            .and_then(|json: serde_json::Value| {
                json.as_object().map(|obj| {
                    obj.iter()
                        .filter_map(|(k, v)| {
                            v.as_str().map(|s| (k.clone(), s.to_string()))
                        })
                        .collect()
                })
            })
            .unwrap_or_default();

        Ok(suggestions)
    }

    /// Apply variable renames to code
    fn apply_renames(&self, code: &str, suggestions: &[(String, String)]) -> String {
        let mut result = code.to_string();

        for (old_name, new_name) in suggestions {
            // Use word boundaries to avoid partial replacements
            let pattern = format!(r"\b{}\b", regex::escape(old_name));
            if let Ok(re) = Regex::new(&pattern) {
                result = re.replace_all(&result, new_name).to_string();
            }
        }

        result
    }
}

#[cfg(test)]
mod tests {
    use super::*;
    use crate::config::LLMBackend;

    #[test]
    fn test_extract_variables() {
        let client = ClaudeClient::new(
            LLMBackend::Ollama,
            String::new(),
            "test-model".to_string(),
            "http://localhost:11434".to_string(),
        ).unwrap();
        let renamer = VariableRenamer::new(client);

        let code = r#"
        int v0 = v1 + v2;
        String v3 = getData();
        for (int i = 0; i < v0; i++) {
            process(v3);
        }
        "#;

        let vars = renamer.extract_variables_to_rename(code);
        assert!(!vars.is_empty());
        assert!(vars.iter().any(|(v, _)| v == "v0"));
    }

    #[test]
    fn test_build_context() {
        let client = ClaudeClient::new(
            LLMBackend::Ollama,
            String::new(),
            "test-model".to_string(),
            "http://localhost:11434".to_string(),
        ).unwrap();
        let renamer = VariableRenamer::new(client);

        let code = "int v0 = v1;";
        let bytecode = "const v0, 0x1\nmove v0, v1";
        let vars = vec![("v0".to_string(), 2)];

        let context = renamer.build_context(code, Some(bytecode), &vars);
        assert!(context.contains("Decompiled Java"));
        assert!(context.contains("Bytecode"));
        assert!(context.contains("Variables to rename"));
    }

    #[test]
    fn test_apply_renames() {
        let client = ClaudeClient::new(
            LLMBackend::Ollama,
            String::new(),
            "test-model".to_string(),
            "http://localhost:11434".to_string(),
        ).unwrap();
        let renamer = VariableRenamer::new(client);

        let code = "int v0 = v1; String v0_copy = v0;";
        let suggestions = vec![
            ("v0".to_string(), "count".to_string()),
            ("v1".to_string(), "total".to_string()),
        ];

        let result = renamer.apply_renames(code, &suggestions);
        assert!(result.contains("count"));
        assert!(result.contains("total"));
    }
}
