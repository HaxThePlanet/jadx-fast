//! Configuration for LLM post-processor

use anyhow::Result;
use std::env;

#[derive(Clone, Debug)]
pub struct Config {
    /// Anthropic API key
    pub api_key: String,
    /// Model to use (default: claude-3-5-haiku-20241022)
    pub model: String,
    /// Enable all post-processing
    pub enabled: bool,
    /// Enable variable renaming
    pub enable_variable_renaming: bool,
    /// Enable type refinement
    pub enable_type_refinement: bool,
    /// Enable code correction
    pub enable_code_correction: bool,
    /// Cache directory
    pub cache_dir: String,
    /// Enable result caching
    pub cache_enabled: bool,
    /// Batch size for processing multiple items
    pub batch_size: usize,
    /// API timeout in seconds
    pub timeout_secs: u64,
}

impl Config {
    /// Create config from environment variables
    pub fn from_env() -> Result<Self> {
        let api_key = env::var("ANTHROPIC_API_KEY")
            .unwrap_or_else(|_| String::new());

        let enabled = !api_key.is_empty();
        if !enabled {
            tracing::warn!("ANTHROPIC_API_KEY not set, LLM post-processing disabled");
        }

        Ok(Self {
            api_key,
            model: "claude-3-5-haiku-20241022".to_string(),
            enabled,
            enable_variable_renaming: true,
            enable_type_refinement: true,
            enable_code_correction: false, // Disabled by default (more conservative)
            cache_dir: env::var("DEXTERITY_CACHE_DIR")
                .unwrap_or_else(|_| "/tmp/dexterity-cache".to_string()),
            cache_enabled: true,
            batch_size: 5,
            timeout_secs: 30,
        })
    }

    /// Create with API key for testing
    pub fn with_api_key(api_key: String) -> Self {
        Self {
            api_key,
            model: "claude-3-5-haiku-20241022".to_string(),
            enabled: true,
            enable_variable_renaming: true,
            enable_type_refinement: true,
            enable_code_correction: false,
            cache_dir: "/tmp/dexterity-cache".to_string(),
            cache_enabled: true,
            batch_size: 5,
            timeout_secs: 30,
        }
    }
}

impl Default for Config {
    fn default() -> Self {
        Self::from_env().unwrap_or_else(|_| Self {
            api_key: String::new(),
            model: "claude-3-5-haiku-20241022".to_string(),
            enabled: false,
            enable_variable_renaming: false,
            enable_type_refinement: false,
            enable_code_correction: false,
            cache_dir: "/tmp/dexterity-cache".to_string(),
            cache_enabled: false,
            batch_size: 5,
            timeout_secs: 30,
        })
    }
}
