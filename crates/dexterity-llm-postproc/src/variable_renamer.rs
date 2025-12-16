//! LLM-based variable renaming module
//!
//! Extracts FULL context for each variable: all usages, method calls, field accesses,
//! casts, and assignments - then sends this rich context to the LLM for naming.

use anyhow::Result;
use regex::Regex;
use std::collections::HashMap;
use crate::client::ClaudeClient;

/// Represents all the usage context for a single variable
#[derive(Debug, Default)]
pub struct VariableContext {
    /// The variable name (e.g., "v0", "a")
    pub name: String,
    /// Type from declaration (if known)
    pub declared_type: Option<String>,
    /// What it's assigned from (e.g., "getData()", "new ArrayList()")
    pub assigned_from: Vec<String>,
    /// Methods called ON this variable (e.g., ".getString()", ".add()")
    pub method_calls: Vec<String>,
    /// Fields accessed on this variable (e.g., ".length", ".size")
    pub field_accesses: Vec<String>,
    /// Methods this variable is passed TO as argument
    pub passed_to_methods: Vec<String>,
    /// What this variable is cast to
    pub cast_to: Vec<String>,
    /// Operators used with this variable
    pub operators: Vec<String>,
    /// Full lines where variable appears (for context)
    pub usage_lines: Vec<String>,
}

pub struct VariableRenamer {
    client: ClaudeClient,
}

impl VariableRenamer {
    pub fn new(client: ClaudeClient) -> Self {
        Self { client }
    }

    /// Rename variables in decompiled code using LLM with full context
    pub async fn rename_variables(
        &self,
        decompiled_code: &str,
        _bytecode_context: Option<&str>,
    ) -> Result<String> {
        // Extract ALL context for each variable that needs renaming
        let var_contexts = self.extract_all_variable_contexts(decompiled_code);

        if var_contexts.is_empty() {
            return Ok(decompiled_code.to_string());
        }

        // Build rich context for LLM
        let context = self.build_rich_context(&var_contexts);

        // Generate renaming suggestions
        let suggestions = self.get_llm_suggestions(&context).await?;

        // Apply renames
        let result = self.apply_renames(decompiled_code, &suggestions);

        Ok(result)
    }

    /// Extract comprehensive context for all variables that need renaming
    fn extract_all_variable_contexts(&self, code: &str) -> Vec<VariableContext> {
        // Match register-based names and single-letter vars
        let var_pattern = Regex::new(r"\b([vpr]\d{1,3}|[a-z])\b").unwrap();

        // Find all candidate variables
        let mut var_names: HashMap<String, usize> = HashMap::new();
        for cap in var_pattern.captures_iter(code) {
            let var = cap[1].to_string();
            // Skip common loop vars and known good names
            if var == "i" || var == "j" || var == "k" || var == "e" || var == "t" {
                continue;
            }
            *var_names.entry(var).or_insert(0) += 1;
        }

        // Only process vars that appear multiple times (worth renaming)
        let candidates: Vec<_> = var_names.into_iter()
            .filter(|(_, count)| *count >= 2)
            .map(|(name, _)| name)
            .collect();

        // Extract full context for each variable
        let mut contexts = Vec::new();
        for var_name in candidates {
            let ctx = self.extract_context_for_variable(code, &var_name);
            if !ctx.usage_lines.is_empty() {
                contexts.push(ctx);
            }
        }

        contexts
    }

    /// Extract all usage context for a single variable
    fn extract_context_for_variable(&self, code: &str, var_name: &str) -> VariableContext {
        let mut ctx = VariableContext {
            name: var_name.to_string(),
            ..Default::default()
        };

        let escaped_var = regex::escape(var_name);
        let lines: Vec<&str> = code.lines().collect();

        for line in &lines {
            let trimmed = line.trim();

            // Check if this line contains the variable
            let var_word_pattern = Regex::new(&format!(r"\b{}\b", escaped_var)).unwrap();
            if !var_word_pattern.is_match(line) {
                continue;
            }

            ctx.usage_lines.push(trimmed.to_string());

            // Pattern 1: Declaration with type - "Type varname" or "Type varname ="
            let decl_pattern = Regex::new(&format!(
                r"(?:^|[,\(\s])([A-Z][a-zA-Z0-9_<>,\s]*)\s+{}\s*[=;,\)]",
                escaped_var
            )).unwrap();
            if let Some(cap) = decl_pattern.captures(line) {
                let typ = cap[1].trim().to_string();
                if !typ.is_empty() && typ != "new" && typ != "return" {
                    ctx.declared_type = Some(typ);
                }
            }

            // Pattern 2: Assignment from something - "varname = something"
            let assign_pattern = Regex::new(&format!(
                r"\b{}\s*=\s*([^;]+)",
                escaped_var
            )).unwrap();
            if let Some(cap) = assign_pattern.captures(line) {
                let rhs = cap[1].trim().to_string();
                if !rhs.is_empty() {
                    ctx.assigned_from.push(rhs);
                }
            }

            // Pattern 3: Method calls ON this variable - "varname.method("
            let method_on_pattern = Regex::new(&format!(
                r"\b{}\.([a-zA-Z_][a-zA-Z0-9_]*)\s*\(",
                escaped_var
            )).unwrap();
            for cap in method_on_pattern.captures_iter(line) {
                let method = cap[1].to_string();
                if !ctx.method_calls.contains(&method) {
                    ctx.method_calls.push(method);
                }
            }

            // Pattern 4: Field access - "varname.field" (not followed by '(')
            let field_pattern = Regex::new(&format!(
                r"\b{}\.([a-zA-Z_][a-zA-Z0-9_]*)\b(?!\s*\()",
                escaped_var
            )).unwrap();
            for cap in field_pattern.captures_iter(line) {
                let field = cap[1].to_string();
                if !ctx.field_accesses.contains(&field) {
                    ctx.field_accesses.push(field);
                }
            }

            // Pattern 5: Passed to methods - "method(varname" or "method(x, varname"
            let passed_pattern = Regex::new(&format!(
                r"([a-zA-Z_][a-zA-Z0-9_]*)\s*\([^)]*\b{}\b",
                escaped_var
            )).unwrap();
            for cap in passed_pattern.captures_iter(line) {
                let method = cap[1].to_string();
                // Skip common non-methods
                if method != "if" && method != "while" && method != "for" && method != "switch" {
                    if !ctx.passed_to_methods.contains(&method) {
                        ctx.passed_to_methods.push(method);
                    }
                }
            }

            // Pattern 6: Cast - "(Type) varname"
            let cast_pattern = Regex::new(&format!(
                r"\(([A-Z][a-zA-Z0-9_<>]*)\)\s*{}\b",
                escaped_var
            )).unwrap();
            for cap in cast_pattern.captures_iter(line) {
                let cast_type = cap[1].to_string();
                if !ctx.cast_to.contains(&cast_type) {
                    ctx.cast_to.push(cast_type);
                }
            }

            // Pattern 7: Comparison operators
            if line.contains(&format!("{} ==", var_name)) || line.contains(&format!("== {}", var_name)) {
                if !ctx.operators.contains(&"==".to_string()) {
                    ctx.operators.push("==".to_string());
                }
            }
            if line.contains(&format!("{} !=", var_name)) || line.contains(&format!("!= {}", var_name)) {
                if !ctx.operators.contains(&"!=".to_string()) {
                    ctx.operators.push("!=".to_string());
                }
            }
            if line.contains(&format!("{} <", var_name)) || line.contains(&format!("{} >", var_name))
               || line.contains(&format!("< {}", var_name)) || line.contains(&format!("> {}", var_name)) {
                if !ctx.operators.contains(&"<>".to_string()) {
                    ctx.operators.push("<>".to_string());
                }
            }
        }

        ctx
    }

    /// Build rich context string for LLM
    fn build_rich_context(&self, contexts: &[VariableContext]) -> String {
        let mut output = String::new();
        output.push_str("# Variable Context Analysis\n\n");
        output.push_str("For each variable below, I've extracted ALL usages. Suggest a better name.\n\n");

        for ctx in contexts.iter().take(15) { // Limit to 15 vars for token budget
            output.push_str(&format!("## Variable: `{}`\n", ctx.name));

            if let Some(ref typ) = ctx.declared_type {
                output.push_str(&format!("- Declared type: `{}`\n", typ));
            }

            if !ctx.assigned_from.is_empty() {
                output.push_str("- Assigned from:\n");
                for (i, src) in ctx.assigned_from.iter().take(5).enumerate() {
                    output.push_str(&format!("  {}. `{}`\n", i+1, src));
                }
            }

            if !ctx.method_calls.is_empty() {
                output.push_str(&format!("- Methods called ON it: `{}`\n", ctx.method_calls.join("`, `")));
            }

            if !ctx.field_accesses.is_empty() {
                output.push_str(&format!("- Fields accessed: `.{}`\n", ctx.field_accesses.join("`, `.")));
            }

            if !ctx.passed_to_methods.is_empty() {
                output.push_str(&format!("- Passed to methods: `{}`\n", ctx.passed_to_methods.join("`, `")));
            }

            if !ctx.cast_to.is_empty() {
                output.push_str(&format!("- Cast to types: `{}`\n", ctx.cast_to.join("`, `")));
            }

            output.push_str("- Usage examples:\n");
            for (i, line) in ctx.usage_lines.iter().take(5).enumerate() {
                output.push_str(&format!("  {}. `{}`\n", i+1, line));
            }
            output.push('\n');
        }

        output
    }

    /// Get LLM suggestions for variable names
    async fn get_llm_suggestions(&self, context: &str) -> Result<Vec<(String, String)>> {
        let system_prompt = r#"You are a Java code expert. Given detailed variable usage context, suggest meaningful names.

RULES:
1. Use camelCase for all names
2. Be SPECIFIC based on the context clues:
   - If it calls .getString(), .getInt() → likely SharedPreferences or Bundle → name it "prefs" or "bundle"
   - If it calls .add(), .remove(), .size() → likely a Collection → name it "items", "list", "entries"
   - If it calls .put(), .get() with keys → likely a Map → name it "cache", "mapping", "lookup"
   - If passed to findViewById() → likely a View → name it "view", "button", "textView"
   - If assigned from getIntent() → name it "intent"
   - If assigned from getContext() → name it "context"
   - If assigned from getActivity() → name it "activity"
   - If .length field accessed → likely array → name it "items", "data", "buffer"
3. For loop counters (compared with <, >, used with ++) → keep as i, j, k, or use "index", "count"
4. If unsure, don't rename (omit from output)

OUTPUT: Return ONLY valid JSON mapping old names to new names:
{"v0": "userData", "v1": "settings", "a": "callback"}

NO explanation, NO markdown, JUST the JSON object."#;

        let response = self.client.call(system_prompt, context).await?;

        // Try to extract JSON from response (handle markdown code blocks)
        let json_str = if response.contains("```") {
            // Extract from code block
            response
                .split("```")
                .nth(1)
                .map(|s| s.trim_start_matches("json").trim())
                .unwrap_or(&response)
        } else {
            response.trim()
        };

        // Parse JSON response
        let suggestions: Vec<(String, String)> = serde_json::from_str(json_str)
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
            // Skip if names are the same or new name is empty
            if old_name == new_name || new_name.is_empty() {
                continue;
            }
            // Use word boundaries to avoid partial replacements
            let pattern = format!(r"\b{}\b", regex::escape(old_name));
            if let Ok(re) = Regex::new(&pattern) {
                result = re.replace_all(&result, new_name.as_str()).to_string();
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
    fn test_extract_context_method_calls() {
        let client = ClaudeClient::new(
            LLMBackend::Ollama,
            String::new(),
            "test-model".to_string(),
            "http://localhost:11434".to_string(),
        ).unwrap();
        let renamer = VariableRenamer::new(client);

        let code = r#"
            Object v0 = getSettings();
            String v1 = v0.getString("key");
            v0.putInt("count", 5);
            saveData(v0);
        "#;

        let ctx = renamer.extract_context_for_variable(code, "v0");

        assert!(ctx.assigned_from.iter().any(|s| s.contains("getSettings")));
        assert!(ctx.method_calls.contains(&"getString".to_string()));
        assert!(ctx.method_calls.contains(&"putInt".to_string()));
        assert!(ctx.passed_to_methods.contains(&"saveData".to_string()));
    }

    #[test]
    fn test_extract_context_field_access() {
        let client = ClaudeClient::new(
            LLMBackend::Ollama,
            String::new(),
            "test-model".to_string(),
            "http://localhost:11434".to_string(),
        ).unwrap();
        let renamer = VariableRenamer::new(client);

        let code = r#"
            int[] v0 = getData();
            int v1 = v0.length;
            for (int i = 0; i < v0.length; i++) {
                process(v0[i]);
            }
        "#;

        let ctx = renamer.extract_context_for_variable(code, "v0");

        assert!(ctx.field_accesses.contains(&"length".to_string()));
        assert!(ctx.passed_to_methods.contains(&"process".to_string()));
    }

    #[test]
    fn test_extract_context_casts() {
        let client = ClaudeClient::new(
            LLMBackend::Ollama,
            String::new(),
            "test-model".to_string(),
            "http://localhost:11434".to_string(),
        ).unwrap();
        let renamer = VariableRenamer::new(client);

        let code = r#"
            Object v0 = getItem();
            String v1 = (String) v0;
            TextView v2 = (TextView) v0;
        "#;

        let ctx = renamer.extract_context_for_variable(code, "v0");

        assert!(ctx.cast_to.contains(&"String".to_string()));
        assert!(ctx.cast_to.contains(&"TextView".to_string()));
    }

    #[test]
    fn test_build_rich_context() {
        let client = ClaudeClient::new(
            LLMBackend::Ollama,
            String::new(),
            "test-model".to_string(),
            "http://localhost:11434".to_string(),
        ).unwrap();
        let renamer = VariableRenamer::new(client);

        let mut ctx = VariableContext {
            name: "v0".to_string(),
            declared_type: Some("SharedPreferences".to_string()),
            assigned_from: vec!["getSharedPreferences(\"prefs\", 0)".to_string()],
            method_calls: vec!["getString".to_string(), "edit".to_string()],
            field_accesses: vec![],
            passed_to_methods: vec![],
            cast_to: vec![],
            operators: vec![],
            usage_lines: vec!["v0.getString(\"key\")".to_string()],
        };

        let rich_ctx = renamer.build_rich_context(&[ctx]);

        assert!(rich_ctx.contains("SharedPreferences"));
        assert!(rich_ctx.contains("getString"));
        assert!(rich_ctx.contains("getSharedPreferences"));
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
        // Should NOT rename v0_copy's v0 part
        assert!(!result.contains("count_copy"));
    }
}
