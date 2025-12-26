//! String Decryption Detection
//!
//! Detects encrypted strings and their decryption methods:
//! - XOR encryption (static key, derived key)
//! - Base64 encoding
//! - AES/DES encryption
//! - Custom encryption patterns

use dexterity_ir::{ArgType, MethodData};

/// Encryption type detected
#[derive(Debug, Clone, Copy, PartialEq, Eq)]
pub enum EncryptionType {
    /// XOR with static key
    XorStatic,
    /// XOR with derived key (from string position, etc.)
    XorDerived,
    /// Base64 encoding
    Base64,
    /// AES encryption
    Aes,
    /// DES encryption
    Des,
    /// RC4 stream cipher
    Rc4,
    /// Custom/unknown encryption
    Custom,
}

impl EncryptionType {
    /// Get display name
    pub fn name(&self) -> &'static str {
        match self {
            EncryptionType::XorStatic => "XOR (static key)",
            EncryptionType::XorDerived => "XOR (derived key)",
            EncryptionType::Base64 => "Base64",
            EncryptionType::Aes => "AES",
            EncryptionType::Des => "DES",
            EncryptionType::Rc4 => "RC4",
            EncryptionType::Custom => "Custom",
        }
    }

    /// Whether we can automatically decrypt this type
    pub fn can_auto_decrypt(&self) -> bool {
        matches!(self, EncryptionType::XorStatic | EncryptionType::Base64)
    }
}

/// A detected string decryptor method
#[derive(Debug, Clone)]
pub struct DecryptorMethod {
    /// Class containing the decryptor
    pub class_type: String,
    /// Method name
    pub method_name: String,
    /// Method signature
    pub signature: String,
    /// Detected encryption type
    pub encryption_type: EncryptionType,
    /// Confidence score (0.0 - 1.0)
    pub confidence: f32,
    /// XOR key if detected (for XorStatic)
    pub xor_key: Option<Vec<u8>>,
}

/// A string that appears to be encrypted
#[derive(Debug, Clone)]
pub struct EncryptedString {
    /// The encrypted string value
    pub encrypted: String,
    /// Location where this string is used
    pub location: StringLocation,
    /// Decrypted value if we could decrypt it
    pub decrypted: Option<String>,
    /// Decryptor method used
    pub decryptor: Option<DecryptorMethod>,
}

/// Location of an encrypted string usage
#[derive(Debug, Clone)]
pub struct StringLocation {
    /// Class where string is used
    pub class_type: String,
    /// Method where string is used
    pub method_name: String,
    /// Approximate instruction index
    pub instruction_index: usize,
}

/// Analyzer for detecting string decryption patterns
pub struct StringDecryptionAnalyzer {
    /// Detected decryptor methods
    pub decryptors: Vec<DecryptorMethod>,
    /// Detected encrypted strings
    pub encrypted_strings: Vec<EncryptedString>,
}

impl StringDecryptionAnalyzer {
    /// Create new analyzer
    pub fn new() -> Self {
        Self {
            decryptors: Vec::new(),
            encrypted_strings: Vec::new(),
        }
    }

    /// Analyze a method to detect if it's a string decryptor
    ///
    /// Common decryptor signatures:
    /// - static String xxx(byte[]) - byte array to string
    /// - static String xxx(String) - string transformation
    /// - static String xxx(int) - index-based lookup
    /// - static String xxx(String, int) - string + key/index
    pub fn analyze_potential_decryptor(&mut self, method: &MethodData, class_type: &str) {
        // Check signature: static method returning String
        if !method.is_static() {
            return;
        }
        if !matches!(&method.return_type, ArgType::Object(t) if t.contains("String")) {
            return;
        }

        // Must have at least one argument
        if method.arg_types.is_empty() {
            return;
        }

        // Build signature
        let signature = format!("({}){}",
            method.arg_types.iter()
                .map(|a| arg_type_descriptor(a))
                .collect::<String>(),
            arg_type_descriptor(&method.return_type)
        );

        // Detect based on signature pattern
        let encryption_type = self.detect_from_signature(method);

        if let Some(enc_type) = encryption_type {
            self.decryptors.push(DecryptorMethod {
                class_type: class_type.to_string(),
                method_name: method.name.clone(),
                signature,
                encryption_type: enc_type,
                confidence: 0.6, // Signature-based detection has moderate confidence
                xor_key: None,
            });
        }
    }

    /// Detect encryption type from method signature
    fn detect_from_signature(&self, method: &MethodData) -> Option<EncryptionType> {
        // Check argument types
        let arg_types: Vec<_> = method.arg_types.iter().collect();

        // String xxx(byte[]) - likely XOR or custom
        if arg_types.len() == 1 {
            if let ArgType::Array(elem) = &arg_types[0] {
                if matches!(**elem, ArgType::Byte) {
                    return Some(EncryptionType::XorStatic);
                }
            }
        }

        // String xxx(String) - could be Base64, XOR, or custom
        if arg_types.len() == 1 {
            if matches!(arg_types[0], ArgType::Object(t) if t.contains("String")) {
                // Check method name for hints
                let name = method.name.to_lowercase();
                if name.contains("base64") || name.contains("decode") {
                    return Some(EncryptionType::Base64);
                }
                if name.contains("decrypt") || name.contains("xor") {
                    return Some(EncryptionType::XorStatic);
                }
                return Some(EncryptionType::Custom);
            }
        }

        // String xxx(String, int) or String xxx(int, String) - keyed encryption
        if arg_types.len() == 2 {
            let has_string = arg_types.iter().any(|t| matches!(t, ArgType::Object(s) if s.contains("String")));
            let has_int = arg_types.iter().any(|t| matches!(t, ArgType::Int));

            if has_string && has_int {
                return Some(EncryptionType::XorDerived);
            }
        }

        // String xxx(int) - lookup table
        if arg_types.len() == 1 && matches!(arg_types[0], ArgType::Int) {
            return Some(EncryptionType::Custom);
        }

        None
    }

    /// Try to decrypt a string using XOR
    pub fn try_xor_decrypt(&self, encrypted: &[u8], key: &[u8]) -> Option<String> {
        if key.is_empty() {
            return None;
        }

        let decrypted: Vec<u8> = encrypted
            .iter()
            .enumerate()
            .map(|(i, b)| b ^ key[i % key.len()])
            .collect();

        String::from_utf8(decrypted).ok()
    }

    /// Check if a string looks encrypted (non-printable chars, high entropy)
    pub fn looks_encrypted(&self, s: &str) -> bool {
        if s.is_empty() || s.len() < 4 {
            return false;
        }

        // Check for non-printable characters
        let non_printable = s.chars().filter(|c| !c.is_ascii_graphic() && !c.is_whitespace()).count();
        if non_printable as f64 / s.len() as f64 > 0.2 {
            return true;
        }

        // Check entropy (simplified)
        let mut char_counts = [0u32; 256];
        for c in s.chars() {
            if c.is_ascii() {
                char_counts[c as usize] += 1;
            }
        }

        let len = s.len() as f64;
        let entropy: f64 = char_counts.iter()
            .filter(|&&c| c > 0)
            .map(|&c| {
                let p = c as f64 / len;
                -p * p.log2()
            })
            .sum();

        // High entropy (> 3.5 bits/char) suggests encryption
        entropy > 3.5
    }

    /// Get summary of detected decryptors
    pub fn summary(&self) -> String {
        if self.decryptors.is_empty() {
            return "No string decryptors detected".to_string();
        }

        let mut summary = format!("Found {} potential string decryptor(s):\n", self.decryptors.len());
        for decryptor in &self.decryptors {
            summary.push_str(&format!(
                "  - {}.{}: {} (confidence: {:.0}%)\n",
                decryptor.class_type,
                decryptor.method_name,
                decryptor.encryption_type.name(),
                decryptor.confidence * 100.0
            ));
        }
        summary
    }
}

impl Default for StringDecryptionAnalyzer {
    fn default() -> Self {
        Self::new()
    }
}

/// Convert ArgType to descriptor string
fn arg_type_descriptor(arg_type: &ArgType) -> String {
    match arg_type {
        ArgType::Void => "V".to_string(),
        ArgType::Boolean => "Z".to_string(),
        ArgType::Byte => "B".to_string(),
        ArgType::Char => "C".to_string(),
        ArgType::Short => "S".to_string(),
        ArgType::Int => "I".to_string(),
        ArgType::Long => "J".to_string(),
        ArgType::Float => "F".to_string(),
        ArgType::Double => "D".to_string(),
        ArgType::Object(s) => format!("L{};", s.trim_start_matches('L').trim_end_matches(';')),
        ArgType::Array(elem) => format!("[{}", arg_type_descriptor(elem)),
        ArgType::Generic { base, .. } => format!("L{};", base.trim_start_matches('L').trim_end_matches(';')),
        ArgType::Wildcard { .. } => "Ljava/lang/Object;".to_string(),
        // All other types (Unknown, TypeVariable, etc.) map to Object
        _ => "Ljava/lang/Object;".to_string(),
    }
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn test_encryption_detection() {
        let analyzer = StringDecryptionAnalyzer::new();

        // Normal strings should not look encrypted
        assert!(!analyzer.looks_encrypted("Hello World"));
        assert!(!analyzer.looks_encrypted("Hello"));
        assert!(!analyzer.looks_encrypted("test"));

        // Strings with many non-printable chars should look encrypted
        let encrypted: String = (0..20).map(|i| (i * 17 % 256) as u8 as char).collect();
        assert!(analyzer.looks_encrypted(&encrypted));
    }

    #[test]
    fn test_xor_decrypt() {
        let analyzer = StringDecryptionAnalyzer::new();

        // Simple XOR test
        let key = vec![0x42];  // 'B'
        let encrypted: Vec<u8> = "Hello".bytes().map(|b| b ^ 0x42).collect();

        let decrypted = analyzer.try_xor_decrypt(&encrypted, &key);
        assert_eq!(decrypted, Some("Hello".to_string()));
    }

    #[test]
    fn test_encryption_type_auto_decrypt() {
        assert!(EncryptionType::XorStatic.can_auto_decrypt());
        assert!(EncryptionType::Base64.can_auto_decrypt());
        assert!(!EncryptionType::Aes.can_auto_decrypt());
        assert!(!EncryptionType::Custom.can_auto_decrypt());
    }

    #[test]
    fn test_signature_detection() {
        let mut analyzer = StringDecryptionAnalyzer::new();

        // Create a method with byte[] -> String signature
        let mut method = MethodData::new(
            "decrypt".to_string(),
            0x0008, // static
            ArgType::Object("Ljava/lang/String;".to_string())
        );
        method.arg_types = vec![ArgType::Array(Box::new(ArgType::Byte))];

        analyzer.analyze_potential_decryptor(&method, "Lcom/example/Crypto;");

        assert_eq!(analyzer.decryptors.len(), 1);
        assert_eq!(analyzer.decryptors[0].encryption_type, EncryptionType::XorStatic);
    }
}
