//! LLM-powered code commenting for decompiled Java
//!
//! This module adds brief Javadoc comments to classes and methods
//! using LLM analysis of the decompiled code.

use crate::client::ClaudeClient;
use anyhow::Result;
use regex::Regex;
use serde::{Deserialize, Serialize};
use std::collections::HashMap;

/// Manages LLM-powered code commenting
pub struct CodeCommenter {
    client: ClaudeClient,
    class_pattern: Regex,
    method_pattern: Regex,
}

/// Structure representing parsed code elements
#[derive(Debug)]
struct CodeStructure {
    classes: Vec<ClassInfo>,
    methods: Vec<MethodInfo>,
}

#[derive(Debug)]
struct ClassInfo {
    name: String,
    line_number: usize,
    indent: String,
    full_match: String,
}

#[derive(Debug)]
struct MethodInfo {
    name: String,
    line_number: usize,
    indent: String,
    full_match: String,
    return_type: String,
}

/// Map of element names to their comments
#[derive(Debug, Serialize, Deserialize)]
struct CommentMap {
    classes: HashMap<String, String>,
    methods: HashMap<String, String>,
}

impl CodeCommenter {
    /// Create a new code commenter
    pub fn new(client: ClaudeClient) -> Self {
        // Pattern to match class declarations (including inner classes)
        // Captures: indent, modifiers, type (class/interface/enum), name
        let class_pattern = Regex::new(
            r"(?m)^(\s*)((?:public|private|protected)\s+)?(?:static\s+)?(?:final\s+)?(?:abstract\s+)?(class|interface|enum)\s+(\w+)"
        ).expect("Failed to compile class regex");

        // Pattern to match method declarations
        // Captures: indent, modifiers, return type, method name
        let method_pattern = Regex::new(
            r"(?m)^(\s*)((?:public|private|protected)\s+)?(?:static\s+)?(?:final\s+)?(?:synchronized\s+)?(?:native\s+)?(\w+(?:<[^>]+>)?)\s+(\w+)\s*\("
        ).expect("Failed to compile method regex");

        Self {
            client,
            class_pattern,
            method_pattern,
        }
    }

    /// Add comments to a single Java file
    pub async fn add_comments(&self, java_code: &str) -> Result<String> {
        // Extract code structure
        let structure = self.extract_code_structure(java_code)?;

        // Skip if no classes or methods found
        if structure.classes.is_empty() && structure.methods.is_empty() {
            return Ok(java_code.to_string());
        }

        // Generate comments via LLM
        let comments = self.generate_comments(&structure, java_code).await?;

        // Insert comments into code
        let result = self.insert_comments(java_code, &comments, &structure)?;

        Ok(result)
    }

    /// Extract class and method information from Java code
    fn extract_code_structure(&self, code: &str) -> Result<CodeStructure> {
        let lines: Vec<&str> = code.lines().collect();
        let mut classes = Vec::new();
        let mut methods = Vec::new();

        // Find all class declarations
        for (line_num, line) in lines.iter().enumerate() {
            if let Some(caps) = self.class_pattern.captures(line) {
                let indent = caps.get(1).map_or("", |m| m.as_str());
                let class_name = caps.get(4).map_or("", |m| m.as_str());

                // Skip if already has a Javadoc comment (check previous line)
                if line_num > 0 {
                    let prev_line = lines[line_num - 1].trim();
                    if prev_line.ends_with("*/") {
                        continue;
                    }
                }

                classes.push(ClassInfo {
                    name: class_name.to_string(),
                    line_number: line_num,
                    indent: indent.to_string(),
                    full_match: line.to_string(),
                });
            }

            // Find all method declarations (but not constructors)
            if let Some(caps) = self.method_pattern.captures(line) {
                let indent = caps.get(1).map_or("", |m| m.as_str());
                let return_type = caps.get(3).map_or("", |m| m.as_str());
                let method_name = caps.get(4).map_or("", |m| m.as_str());

                // Skip constructors (method name matches a class name)
                let is_constructor = classes.iter().any(|c| c.name == method_name);
                if is_constructor {
                    continue;
                }

                // Skip if already has a Javadoc comment or annotation (check previous line)
                if line_num > 0 {
                    let prev_line = lines[line_num - 1].trim();
                    if prev_line.ends_with("*/") || prev_line.starts_with('@') {
                        continue;
                    }
                }

                methods.push(MethodInfo {
                    name: method_name.to_string(),
                    line_number: line_num,
                    indent: indent.to_string(),
                    full_match: line.to_string(),
                    return_type: return_type.to_string(),
                });
            }
        }

        Ok(CodeStructure { classes, methods })
    }

    /// Generate comments via LLM
    async fn generate_comments(
        &self,
        structure: &CodeStructure,
        java_code: &str,
    ) -> Result<CommentMap> {
        let system_prompt = r#"You are a code documentation assistant. Generate brief Javadoc comments.

RULES:
1. Focus on PURPOSE and BEHAVIOR
2. One sentence, no period at end
3. Use present tense ("Manages authentication" not "This manages authentication")

OUTPUT FORMAT - CRITICAL RULES:
- Return ONLY raw JSON
- NO markdown (no ```, no ```json, no code blocks)
- NO trailing commas
- NO extra text before or after JSON
- Start with { and end with }

EXACT format (copy this structure):
{"classes": {"ClassName": "Brief description"}, "methods": {"methodName": "Brief description"}}

Example correct output:
{"classes": {"MainActivity": "Handles app initialization"}, "methods": {"onCreate": "Initializes activity components", "onDestroy": "Cleans up resources"}}

WRONG - DO NOT DO THIS:
```json
{"classes": {"Test": "Description"},}
```

WRONG - DO NOT DO THIS:
{"classes": {"Test": "Description"},}

CORRECT - DO THIS:
{"classes": {"Test": "Description"}, "methods": {}}

If no classes/methods found, return:
{"classes": {}, "methods": {}}"#;

        // Build user message with context
        let class_names: Vec<&str> = structure.classes.iter().map(|c| c.name.as_str()).collect();
        let method_names: Vec<&str> = structure.methods.iter().map(|m| m.name.as_str()).collect();

        // Truncate code if too long (keep first 500 lines for context)
        let code_lines: Vec<&str> = java_code.lines().take(500).collect();
        let truncated_code = code_lines.join("\n");

        let user_message = format!(
            "Code:\n{}\n\nGenerate comments for:\nClasses: {}\nMethods: {}\n\nReturn raw JSON only (no markdown):",
            truncated_code,
            if class_names.is_empty() { "none".to_string() } else { class_names.join(", ") },
            if method_names.is_empty() { "none".to_string() } else { method_names.join(", ") }
        );

        // Call LLM
        let response = self.client.call(system_prompt, &user_message).await?;

        // Strip markdown code blocks if present (```json ... ``` or ```...```)
        let json_str = {
            let trimmed = response.trim();
            if trimmed.starts_with("```") {
                // Find the JSON content between ``` markers
                let lines: Vec<&str> = response.lines().collect();
                let start_idx = lines.iter().position(|l| l.trim().starts_with("```")).unwrap_or(0) + 1;
                let end_idx = lines[start_idx..].iter().position(|l| l.trim().starts_with("```"))
                    .map(|i| i + start_idx)
                    .unwrap_or(lines.len());
                lines[start_idx..end_idx].join("\n")
            } else {
                response.clone()
            }
        };

        // Parse JSON response
        let comment_map: CommentMap = serde_json::from_str(&json_str)
            .map_err(|e| anyhow::anyhow!("Failed to parse LLM response as JSON: {}. Response: {}", e, response))?;

        Ok(comment_map)
    }

    /// Insert comments into Java code
    fn insert_comments(
        &self,
        code: &str,
        comments: &CommentMap,
        structure: &CodeStructure,
    ) -> Result<String> {
        let lines: Vec<&str> = code.lines().collect();
        let mut result_lines: Vec<String> = Vec::new();
        let mut inserted_at_lines: std::collections::HashSet<usize> = std::collections::HashSet::new();

        for (line_num, line) in lines.iter().enumerate() {
            // Check if we should insert a class comment before this line
            if let Some(class_info) = structure.classes.iter().find(|c| c.line_number == line_num) {
                if let Some(comment) = comments.classes.get(&class_info.name) {
                    if !comment.is_empty() && !inserted_at_lines.contains(&line_num) {
                        result_lines.push(format!("{}/**", class_info.indent));
                        result_lines.push(format!("{} * {}", class_info.indent, comment));
                        result_lines.push(format!("{} */", class_info.indent));
                        inserted_at_lines.insert(line_num);
                    }
                }
            }

            // Check if we should insert a method comment before this line
            if let Some(method_info) = structure.methods.iter().find(|m| m.line_number == line_num) {
                if let Some(comment) = comments.methods.get(&method_info.name) {
                    if !comment.is_empty() && !inserted_at_lines.contains(&line_num) {
                        result_lines.push(format!("{}/**", method_info.indent));
                        result_lines.push(format!("{} * {}", method_info.indent, comment));
                        result_lines.push(format!("{} */", method_info.indent));
                        inserted_at_lines.insert(line_num);
                    }
                }
            }

            // Add the original line
            result_lines.push(line.to_string());
        }

        Ok(result_lines.join("\n"))
    }
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn test_extract_class_structure() {
        let code = r#"
package com.example;

public class MainActivity {
    private static class Helper {
    }
}
"#;
        let client = ClaudeClient::new(
            crate::config::LLMBackend::Ollama,
            String::new(),
            "test".to_string(),
            "http://localhost:11434".to_string(),
        ).unwrap();
        let commenter = CodeCommenter::new(client);
        let structure = commenter.extract_code_structure(code).unwrap();

        assert_eq!(structure.classes.len(), 2);
        assert_eq!(structure.classes[0].name, "MainActivity");
        assert_eq!(structure.classes[1].name, "Helper");
    }

    #[test]
    fn test_extract_method_structure() {
        let code = r#"
public class Test {
    public void onCreate() {
    }

    private int calculate(int x) {
        return x * 2;
    }
}
"#;
        let client = ClaudeClient::new(
            crate::config::LLMBackend::Ollama,
            String::new(),
            "test".to_string(),
            "http://localhost:11434".to_string(),
        ).unwrap();
        let commenter = CodeCommenter::new(client);
        let structure = commenter.extract_code_structure(code).unwrap();

        assert_eq!(structure.methods.len(), 2);
        assert_eq!(structure.methods[0].name, "onCreate");
        assert_eq!(structure.methods[1].name, "calculate");
    }

    #[test]
    fn test_insert_comments() {
        let code = r#"public class Test {
    public void method() {
    }
}"#;

        let mut classes = HashMap::new();
        classes.insert("Test".to_string(), "Test class description".to_string());

        let mut methods = HashMap::new();
        methods.insert("method".to_string(), "Method description".to_string());

        let comments = CommentMap { classes, methods };

        let structure = CodeStructure {
            classes: vec![ClassInfo {
                name: "Test".to_string(),
                line_number: 0,
                indent: "".to_string(),
                full_match: "public class Test {".to_string(),
            }],
            methods: vec![MethodInfo {
                name: "method".to_string(),
                line_number: 1,
                indent: "    ".to_string(),
                full_match: "    public void method() {".to_string(),
                return_type: "void".to_string(),
            }],
        };

        let client = ClaudeClient::new(
            crate::config::LLMBackend::Ollama,
            String::new(),
            "test".to_string(),
            "http://localhost:11434".to_string(),
        ).unwrap();
        let commenter = CodeCommenter::new(client);
        let result = commenter.insert_comments(code, &comments, &structure).unwrap();

        assert!(result.contains("/**"));
        assert!(result.contains("Test class description"));
        assert!(result.contains("Method description"));
    }
}
