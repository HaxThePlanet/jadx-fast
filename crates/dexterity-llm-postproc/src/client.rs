//! Anthropic Claude API client

use anyhow::{anyhow, Result};
use reqwest::Client as HttpClient;
use serde::{Deserialize, Serialize};
use std::sync::Arc;
use tokio::sync::RwLock;

const CLAUDE_API_URL: &str = "https://api.anthropic.com/v1/messages";

#[derive(Clone)]
pub struct ClaudeClient {
    api_key: String,
    model: String,
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

#[derive(Serialize)]
struct ClaudeRequest {
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
struct ClaudeResponse {
    content: Vec<ResponseContent>,
    usage: ResponseUsage,
}

#[derive(Deserialize)]
struct ResponseContent {
    text: String,
}

#[derive(Deserialize)]
struct ResponseUsage {
    input_tokens: u64,
    output_tokens: u64,
}

impl ClaudeClient {
    /// Create a new Claude API client
    pub fn new(api_key: String, model: String) -> Result<Self> {
        if api_key.is_empty() {
            return Err(anyhow!("API key is empty"));
        }

        let http_client = HttpClient::new();

        Ok(Self {
            api_key,
            model,
            http_client: Arc::new(http_client),
            usage: Arc::new(RwLock::new(Usage::default())),
        })
    }

    /// Call Claude API with a prompt
    pub async fn call(&self, system_prompt: &str, user_message: &str) -> Result<String> {
        let request = ClaudeRequest {
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
            .post(CLAUDE_API_URL)
            .header("x-api-key", &self.api_key)
            .header("anthropic-version", "2023-06-01")
            .header("content-type", "application/json")
            .json(&request)
            .send()
            .await
            .map_err(|e| anyhow!("API request failed: {}", e))?;

        if !response.status().is_success() {
            let status = response.status();
            let text = response
                .text()
                .await
                .unwrap_or_else(|_| "unknown error".to_string());
            return Err(anyhow!("API error {}: {}", status, text));
        }

        let claude_response: ClaudeResponse = response
            .json()
            .await
            .map_err(|e| anyhow!("Failed to parse response: {}", e))?;

        // Track usage
        {
            let mut usage = self.usage.write().await;
            usage.requests += 1;
            usage.input_tokens += claude_response.usage.input_tokens;
            usage.output_tokens += claude_response.usage.output_tokens;
        }

        if claude_response.content.is_empty() {
            return Err(anyhow!("Empty response from API"));
        }

        Ok(claude_response.content[0].text.clone())
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
    fn test_invalid_client() {
        let result = ClaudeClient::new(String::new(), "model".to_string());
        assert!(result.is_err());
    }

    #[test]
    fn test_valid_client() {
        let result = ClaudeClient::new("test-key".to_string(), "claude-3-5-haiku-20241022".to_string());
        assert!(result.is_ok());
    }

    #[tokio::test]
    async fn test_usage_tracking() {
        let client = ClaudeClient::new("test-key".to_string(), "claude-3-5-haiku-20241022".to_string()).unwrap();
        let (requests, input, output) = client.get_usage().await;
        assert_eq!(requests, 0);
        assert_eq!(input, 0);
        assert_eq!(output, 0);
    }
}
