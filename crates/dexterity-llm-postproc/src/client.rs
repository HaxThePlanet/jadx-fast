//! LLM API client supporting both Anthropic Claude and Ollama

use anyhow::{anyhow, Result};
use reqwest::Client as HttpClient;
use serde::{Deserialize, Serialize};
use std::sync::Arc;
use tokio::sync::RwLock;
use crate::config::LLMBackend;

#[derive(Clone)]
pub struct ClaudeClient {
    backend: LLMBackend,
    api_key: String,
    model: String,
    api_endpoint: String,
    http_client: Arc<HttpClient>,
    // Track usage for quota management
    usage: Arc<RwLock<Usage>>,
}

#[derive(Debug, Default, Clone)]
struct Usage {
    requests: u64,
    input_tokens: u64,
    output_tokens: u64,
}

// Anthropic API structures
#[derive(Serialize)]
struct AnthropicRequest {
    model: String,
    max_tokens: u32,
    messages: Vec<Message>,
}

#[derive(Serialize)]
struct Message {
    role: String,
    content: String,
}

#[derive(Deserialize)]
struct AnthropicResponse {
    content: Vec<ResponseContent>,
    usage: ResponseUsage,
}

#[derive(Deserialize)]
struct ResponseContent {
    text: Option<String>,
}

#[derive(Deserialize)]
struct ResponseUsage {
    input_tokens: u64,
    output_tokens: u64,
}

// Ollama API structures (OpenAI-compatible)
#[derive(Serialize)]
struct OllamaRequest {
    model: String,
    messages: Vec<Message>,
    stream: bool,
}

#[derive(Deserialize)]
struct OllamaResponse {
    message: OllamaMessage,
    #[serde(default)]
    usage: OllamaUsage,
}

#[derive(Deserialize)]
struct OllamaMessage {
    content: String,
}

#[derive(Default, Deserialize)]
struct OllamaUsage {
    #[serde(default)]
    prompt_tokens: u64,
    #[serde(default)]
    completion_tokens: u64,
}

impl ClaudeClient {
    /// Create a new LLM client (auto-detects Ollama or Anthropic)
    pub fn new(backend: LLMBackend, api_key: String, model: String, api_endpoint: String) -> Result<Self> {
        let http_client = HttpClient::new();

        Ok(Self {
            backend,
            api_key,
            model,
            api_endpoint,
            http_client: Arc::new(http_client),
            usage: Arc::new(RwLock::new(Usage::default())),
        })
    }

    /// Call the LLM API with a prompt
    pub async fn call(&self, system_prompt: &str, user_message: &str) -> Result<String> {
        match self.backend {
            LLMBackend::Anthropic => self.call_anthropic(system_prompt, user_message).await,
            LLMBackend::Ollama => self.call_ollama(system_prompt, user_message).await,
        }
    }

    /// Call Anthropic Claude API
    async fn call_anthropic(&self, system_prompt: &str, user_message: &str) -> Result<String> {
        let request = AnthropicRequest {
            model: self.model.clone(),
            max_tokens: 4096,
            messages: vec![
                Message {
                    role: "user".to_string(),
                    content: format!(
                        "{}\n\nUser message:\n{}",
                        system_prompt, user_message
                    ),
                },
            ],
        };

        let response = self
            .http_client
            .post(&self.api_endpoint)
            .header("x-api-key", &self.api_key)
            .header("anthropic-version", "2023-06-01")
            .header("content-type", "application/json")
            .json(&request)
            .send()
            .await
            .map_err(|e| anyhow!("Anthropic API request failed: {}", e))?;

        if !response.status().is_success() {
            let status = response.status();
            let text = response
                .text()
                .await
                .unwrap_or_else(|_| "unknown error".to_string());
            return Err(anyhow!("Anthropic API error {}: {}", status, text));
        }

        let claude_response: AnthropicResponse = response
            .json()
            .await
            .map_err(|e| anyhow!("Failed to parse Anthropic response: {}", e))?;

        // Track usage
        {
            let mut usage = self.usage.write().await;
            usage.requests += 1;
            usage.input_tokens += claude_response.usage.input_tokens;
            usage.output_tokens += claude_response.usage.output_tokens;
        }

        if claude_response.content.is_empty() {
            return Err(anyhow!("Empty response from Anthropic API"));
        }

        let text = claude_response.content[0]
            .text
            .as_ref()
            .ok_or_else(|| anyhow!("No text in Anthropic response"))?;

        Ok(text.clone())
    }

    /// Call Ollama API (OpenAI-compatible)
    async fn call_ollama(&self, system_prompt: &str, user_message: &str) -> Result<String> {
        let request = OllamaRequest {
            model: self.model.clone(),
            messages: vec![
                Message {
                    role: "system".to_string(),
                    content: system_prompt.to_string(),
                },
                Message {
                    role: "user".to_string(),
                    content: user_message.to_string(),
                },
            ],
            stream: false,
        };

        // Build Ollama API endpoint
        let ollama_url = format!("{}/api/chat", self.api_endpoint);

        tracing::debug!("Calling Ollama at {} with model {}", ollama_url, self.model);

        let response = self
            .http_client
            .post(&ollama_url)
            .header("content-type", "application/json")
            .json(&request)
            .send()
            .await
            .map_err(|e| anyhow!("Ollama API request failed: {}", e))?;

        if !response.status().is_success() {
            let status = response.status();
            let text = response
                .text()
                .await
                .unwrap_or_else(|_| "unknown error".to_string());
            return Err(anyhow!("Ollama API error {}: {}", status, text));
        }

        let ollama_response: OllamaResponse = response
            .json()
            .await
            .map_err(|e| anyhow!("Failed to parse Ollama response: {}", e))?;

        // Track usage
        {
            let mut usage = self.usage.write().await;
            usage.requests += 1;
            usage.input_tokens += ollama_response.usage.prompt_tokens;
            usage.output_tokens += ollama_response.usage.completion_tokens;
        }

        Ok(ollama_response.message.content)
    }

    /// Get usage statistics
    pub async fn get_usage(&self) -> (u64, u64, u64) {
        let usage = self.usage.read().await;
        (usage.requests, usage.input_tokens, usage.output_tokens)
    }

    /// Reset usage statistics
    pub async fn reset_usage(&self) {
        let mut usage = self.usage.write().await;
        *usage = Usage::default();
    }
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn test_valid_ollama_client() {
        let result = ClaudeClient::new(
            LLMBackend::Ollama,
            String::new(),
            "qwen2.5-coder:7b".to_string(),
            "http://localhost:11434".to_string(),
        );
        assert!(result.is_ok());
    }

    #[test]
    fn test_valid_anthropic_client() {
        let result = ClaudeClient::new(
            LLMBackend::Anthropic,
            "test-key".to_string(),
            "claude-3-5-haiku-20241022".to_string(),
            "https://api.anthropic.com/v1/messages".to_string(),
        );
        assert!(result.is_ok());
    }

    #[tokio::test]
    async fn test_usage_tracking() {
        let client = ClaudeClient::new(
            LLMBackend::Ollama,
            String::new(),
            "qwen2.5-coder:7b".to_string(),
            "http://localhost:11434".to_string(),
        ).unwrap();
        let (requests, input, output) = client.get_usage().await;
        assert_eq!(requests, 0);
        assert_eq!(input, 0);
        assert_eq!(output, 0);
    }
}
