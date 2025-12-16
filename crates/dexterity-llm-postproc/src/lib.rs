//! LLM-based post-processing for Dexterity decompiled code
//!
//! This module provides:
//! - Variable renaming using Claude 3 Haiku
//! - Type inference refinement via bytecode analysis
//! - Post-decompilation code correction
//! - Efficient caching to minimize API calls

pub mod cache;
pub mod client;
pub mod variable_renamer;
pub mod type_refiner;
pub mod code_corrector;
pub mod config;

pub use cache::Cache;
pub use client::ClaudeClient;
pub use variable_renamer::VariableRenamer;
pub use type_refiner::TypeRefiner;
pub use code_corrector::CodeCorrector;
pub use config::Config;

use anyhow::Result;

/// Main coordinator for all LLM-based post-processing
pub struct LLMPostProcessor {
    config: Config,
    client: ClaudeClient,
    cache: Cache,
    variable_renamer: VariableRenamer,
    type_refiner: TypeRefiner,
    code_corrector: CodeCorrector,
}

impl LLMPostProcessor {
    /// Create a new LLM post-processor
    pub async fn new(config: Config) -> Result<Self> {
        let client = ClaudeClient::new(
            config.backend.clone(),
            config.api_key.clone(),
            config.model.clone(),
            config.api_endpoint.clone(),
        )?;
        let cache = Cache::new(config.cache_dir.clone());
        let variable_renamer = VariableRenamer::new(client.clone());
        let type_refiner = TypeRefiner::new(client.clone());
        let code_corrector = CodeCorrector::new(client.clone());

        Ok(Self {
            config,
            client,
            cache,
            variable_renamer,
            type_refiner,
            code_corrector,
        })
    }

    /// Process decompiled code with optional bytecode context
    pub async fn process(
        &self,
        decompiled_code: &str,
        bytecode_context: Option<&str>,
        _method_info: Option<MethodInfo>,
    ) -> Result<String> {
        if !self.config.enabled {
            return Ok(decompiled_code.to_string());
        }

        let mut result = decompiled_code.to_string();

        // Step 1: Variable renaming (highest impact)
        if self.config.enable_variable_renaming {
            result = self.variable_renamer
                .rename_variables(&result, bytecode_context)
                .await?;
        }

        // Step 2: Type refinement
        if self.config.enable_type_refinement && bytecode_context.is_some() {
            result = self.type_refiner
                .refine_types(&result, bytecode_context.unwrap())
                .await?;
        }

        // Step 3: Code correction (for detected errors)
        if self.config.enable_code_correction {
            result = self.code_corrector
                .correct_code(&result, bytecode_context)
                .await?;
        }

        Ok(result)
    }
}

/// Information about a method for context
#[derive(Clone, Debug)]
pub struct MethodInfo {
    pub class_name: String,
    pub method_name: String,
    pub signature: String,
    pub return_type: String,
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn test_method_info() {
        let info = MethodInfo {
            class_name: "TestClass".to_string(),
            method_name: "testMethod".to_string(),
            signature: "()V".to_string(),
            return_type: "void".to_string(),
        };
        assert_eq!(info.class_name, "TestClass");
    }
}
