//! Configuration for LLM post-processor

use anyhow::Result;
use std::env;

#[derive(Clone, Debug, PartialEq, Eq)]
pub enum LLMBackend {
    /// Anthropic Claude API
    Anthropic,
    /// Local Ollama instance
    Ollama,
}

#[derive(Clone, Debug)]
pub struct Config {
    /// LLM backend to use
    pub backend: LLMBackend,
    /// API key (for Anthropic) or empty (for Ollama)
    pub api_key: String,
    /// API endpoint URL
    pub api_endpoint: String,
    /// Model to use
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
    /// Detects Ollama if running, falls back to Anthropic if API key available
    pub fn from_env() -> Result<Self> {
        // Check for explicit backend selection
        let backend_env = env::var("DEXTERITY_LLM_BACKEND")
            .unwrap_or_else(|_| "auto".to_string())
            .to_lowercase();

        // Try Ollama first (local, free, GPU support)
        let ollama_endpoint = env::var("OLLAMA_API_ENDPOINT")
            .unwrap_or_else(|_| "http://localhost:11434".to_string());

        // Try Anthropic if API key available
        let api_key = env::var("ANTHROPIC_API_KEY")
            .unwrap_or_else(|_| String::new());

        // Determine backend
        let (backend, model, api_endpoint, enabled) = if backend_env == "ollama" ||
            (backend_env == "auto" && Self::is_ollama_available(&ollama_endpoint)) {
            let model = env::var("DEXTERITY_OLLAMA_MODEL")
                .unwrap_or_else(|_| "qwen2.5-coder:7b".to_string());
            tracing::info!("Using Ollama backend at {} with model {}", ollama_endpoint, model);
            (LLMBackend::Ollama, model, ollama_endpoint, true)
        } else if backend_env == "anthropic" || (!api_key.is_empty() && backend_env != "ollama") {
            tracing::info!("Using Anthropic Claude API");
            (LLMBackend::Anthropic, "claude-3-5-haiku-20241022".to_string(),
             "https://api.anthropic.com/v1/messages".to_string(), true)
        } else {
            tracing::warn!("No LLM backend available. Set ANTHROPIC_API_KEY or ensure Ollama is running on localhost:11434");
            (LLMBackend::Ollama, "qwen2.5-coder:7b".to_string(), ollama_endpoint, false)
        };

        Ok(Self {
            backend,
            api_key,
            api_endpoint,
            model,
            enabled,
            enable_variable_renaming: true,
            enable_type_refinement: true,
            enable_code_correction: false,
            cache_dir: env::var("DEXTERITY_CACHE_DIR")
                .unwrap_or_else(|_| "/tmp/dexterity-cache".to_string()),
            cache_enabled: true,
            batch_size: 5,
            timeout_secs: 60, // Ollama might be slower on first run
        })
    }

    /// Check if Ollama is available at the given endpoint
    fn is_ollama_available(endpoint: &str) -> bool {
        let url = format!("{}/api/tags", endpoint);
        match std::net::TcpStream::connect("127.0.0.1:11434") {
            Ok(_) => {
                tracing::debug!("Ollama is available at {}", endpoint);
                true
            }
            Err(_) => {
                tracing::debug!("Ollama not available at {}", endpoint);
                false
            }
        }
    }

    /// Create with Ollama backend
    pub fn with_ollama(model: String, endpoint: String) -> Self {
        Self {
            backend: LLMBackend::Ollama,
            api_key: String::new(),
            api_endpoint: endpoint,
            model,
            enabled: true,
            enable_variable_renaming: true,
            enable_type_refinement: true,
            enable_code_correction: false,
            cache_dir: "/tmp/dexterity-cache".to_string(),
            cache_enabled: true,
            batch_size: 5,
            timeout_secs: 60,
        }
    }

    /// Create with Anthropic API key
    pub fn with_anthropic(api_key: String) -> Self {
        Self {
            backend: LLMBackend::Anthropic,
            api_key,
            api_endpoint: "https://api.anthropic.com/v1/messages".to_string(),
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
            backend: LLMBackend::Ollama,
            api_key: String::new(),
            api_endpoint: "http://localhost:11434".to_string(),
            model: "qwen2.5-coder:7b".to_string(),
            enabled: false,
            enable_variable_renaming: false,
            enable_type_refinement: false,
            enable_code_correction: false,
            cache_dir: "/tmp/dexterity-cache".to_string(),
            cache_enabled: false,
            batch_size: 5,
            timeout_secs: 60,
        })
    }
}
