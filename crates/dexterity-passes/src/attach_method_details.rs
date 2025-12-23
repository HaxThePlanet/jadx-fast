//! Method details attachment pass
//!
//! This pass attaches additional method details:
//! - Parses method signatures from DEX
//! - Extracts throws clause information
//! - Attaches parameter names from debug info
//! - Handles generic type parameters
//!
//! Based on JADX's AttachMethodDetails.java visitor.

use dexterity_ir::types::ArgType;

/// Method signature information
#[derive(Debug, Clone)]
pub struct MethodSignature {
    /// Generic type parameters (e.g., <T, U extends Comparable>)
    pub type_parameters: Vec<TypeParameter>,
    /// Parameter types
    pub param_types: Vec<ArgType>,
    /// Return type
    pub return_type: ArgType,
    /// Exception types that can be thrown
    pub throws: Vec<String>,
}

/// Type parameter information
#[derive(Debug, Clone)]
pub struct TypeParameter {
    /// Parameter name (e.g., "T")
    pub name: String,
    /// Upper bound (e.g., "Comparable" for "T extends Comparable")
    pub bound: Option<String>,
    /// Interface bounds (e.g., ["Serializable"] for "T extends Comparable & Serializable")
    pub interface_bounds: Vec<String>,
}

/// Result of attaching method details
#[derive(Debug, Default)]
pub struct AttachMethodDetailsResult {
    /// Number of signatures parsed
    pub signatures_parsed: usize,
    /// Number of throws clauses found
    pub throws_found: usize,
    /// Number of parameter names attached
    pub param_names_attached: usize,
    /// Number of generic type parameters found
    pub type_params_found: usize,
}

/// Method details
#[derive(Debug, Clone)]
pub struct MethodDetails {
    /// Method index
    pub method_idx: u32,
    /// Method name
    pub name: String,
    /// Parsed signature (if generic)
    pub signature: Option<MethodSignature>,
    /// Parameter names (from debug info or Kotlin metadata)
    pub param_names: Vec<Option<String>>,
    /// Whether this is a varargs method
    pub is_varargs: bool,
    /// Whether this method has ACC_SYNTHETIC
    pub is_synthetic: bool,
    /// Whether this method has ACC_BRIDGE
    pub is_bridge: bool,
}

impl MethodDetails {
    /// Create new method details
    pub fn new(method_idx: u32, name: String) -> Self {
        MethodDetails {
            method_idx,
            name,
            signature: None,
            param_names: vec![],
            is_varargs: false,
            is_synthetic: false,
            is_bridge: false,
        }
    }

    /// Check if this method has a generic signature
    pub fn has_generics(&self) -> bool {
        self.signature.as_ref()
            .map(|s| !s.type_parameters.is_empty())
            .unwrap_or(false)
    }

    /// Check if this method throws exceptions
    pub fn has_throws(&self) -> bool {
        self.signature.as_ref()
            .map(|s| !s.throws.is_empty())
            .unwrap_or(false)
    }

    /// Get the throws types
    pub fn get_throws(&self) -> Vec<&str> {
        self.signature.as_ref()
            .map(|s| s.throws.iter().map(|t| t.as_str()).collect())
            .unwrap_or_default()
    }
}

/// Parse a generic method signature from the signature attribute
///
/// # Arguments
/// * `signature` - The raw signature string from the DEX file
///
/// # Returns
/// * `Option<MethodSignature>` - Parsed signature or None if parsing fails
pub fn parse_method_signature(signature: &str) -> Option<MethodSignature> {
    // Generic signature format:
    // <T:Ljava/lang/Object;U:Ljava/lang/Comparable;>(TT;TU;)TT;^Ljava/lang/Exception;
    //
    // Parts:
    // - <...>: Type parameters
    // - (...): Parameter types
    // - Return type
    // - ^...: Throws clause (optional)

    if signature.is_empty() {
        return None;
    }

    let mut result = MethodSignature {
        type_parameters: vec![],
        param_types: vec![],
        return_type: ArgType::Void,
        throws: vec![],
    };

    let mut chars = signature.chars().peekable();
    let mut pos = 0;

    // Parse type parameters if present
    if chars.peek() == Some(&'<') {
        chars.next(); // consume '<'
        pos += 1;

        while chars.peek() != Some(&'>') && chars.peek().is_some() {
            // Parse type parameter
            let name: String = chars.by_ref()
                .take_while(|c| *c != ':')
                .collect();
            pos += name.len() + 1;

            // Parse bound
            let bound = parse_type_bound(&signature[pos..]);
            pos += bound.as_ref().map(|b| b.len() + 1).unwrap_or(0);

            result.type_parameters.push(TypeParameter {
                name,
                bound,
                interface_bounds: vec![],
            });

            // Skip to next parameter or end
            while chars.peek().map(|c| *c != '>').unwrap_or(false) {
                if chars.peek() == Some(&':') || chars.peek() == Some(&';') {
                    chars.next();
                    pos += 1;
                } else if chars.peek().map(|c| c.is_ascii_uppercase()).unwrap_or(false) {
                    break;
                } else {
                    chars.next();
                    pos += 1;
                }
            }
        }

        if chars.peek() == Some(&'>') {
            chars.next();
            pos += 1;
        }
    }

    // Parse parameter types
    if signature[pos..].starts_with('(') {
        let end_paren = signature[pos..].find(')')?;
        let params_str = &signature[pos + 1..pos + end_paren];
        result.param_types = parse_param_types(params_str);
        pos += end_paren + 1;
    }

    // Parse return type
    let throws_pos = signature[pos..].find('^');
    let return_str = if let Some(tp) = throws_pos {
        &signature[pos..pos + tp]
    } else {
        &signature[pos..]
    };
    result.return_type = parse_single_type(return_str);

    // Parse throws clause
    if let Some(tp) = throws_pos {
        let throws_str = &signature[pos + tp..];
        result.throws = parse_throws_clause(throws_str);
    }

    Some(result)
}

/// Parse a type bound from a signature
fn parse_type_bound(signature: &str) -> Option<String> {
    if signature.starts_with(':') || signature.starts_with("Ljava/lang/Object;") {
        return None;
    }

    // Find the class name
    let end = signature.find(';')?;
    if signature.starts_with('L') {
        Some(signature[1..end].replace('/', "."))
    } else {
        None
    }
}

/// Parse parameter types from a signature
fn parse_param_types(signature: &str) -> Vec<ArgType> {
    let mut types = vec![];
    let mut i = 0;
    let chars: Vec<char> = signature.chars().collect();

    while i < chars.len() {
        let (ty, consumed) = parse_type_at(&signature[i..]);
        types.push(ty);
        i += consumed;
    }

    types
}

/// Parse a single type from signature
fn parse_single_type(signature: &str) -> ArgType {
    let (ty, _) = parse_type_at(signature);
    ty
}

/// Parse a type at the current position, returning type and chars consumed
fn parse_type_at(signature: &str) -> (ArgType, usize) {
    if signature.is_empty() {
        return (ArgType::Void, 0);
    }

    let first = signature.chars().next().unwrap();

    match first {
        'V' => (ArgType::Void, 1),
        'Z' => (ArgType::Boolean, 1),
        'B' => (ArgType::Byte, 1),
        'C' => (ArgType::Char, 1),
        'S' => (ArgType::Short, 1),
        'I' => (ArgType::Int, 1),
        'J' => (ArgType::Long, 1),
        'F' => (ArgType::Float, 1),
        'D' => (ArgType::Double, 1),
        '[' => {
            let (elem_type, elem_consumed) = parse_type_at(&signature[1..]);
            (ArgType::Array(Box::new(elem_type)), 1 + elem_consumed)
        }
        'L' => {
            let end = signature.find(';').unwrap_or(signature.len());
            let class_name = signature[1..end].replace('/', ".");
            (ArgType::Object(class_name), end + 1)
        }
        'T' => {
            // Type variable
            let end = signature.find(';').unwrap_or(signature.len());
            let var_name = &signature[1..end];
            (ArgType::TypeVariable {
                name: var_name.to_string(),
                extend_types: vec![],
            }, end + 1)
        }
        _ => (ArgType::Unknown, 1),
    }
}

/// Parse throws clause from signature
fn parse_throws_clause(signature: &str) -> Vec<String> {
    let mut throws = vec![];

    for part in signature.split('^').skip(1) {
        if let Some(end) = part.find(';') {
            if part.starts_with('L') {
                throws.push(part[1..end].replace('/', "."));
            }
        }
    }

    throws
}

/// Attach parameter names to a method
pub fn attach_param_names(
    details: &mut MethodDetails,
    debug_param_names: &[Option<String>],
) {
    details.param_names = debug_param_names.to_vec();
}

/// Check if a method is likely a synthetic accessor
pub fn is_synthetic_accessor(name: &str) -> bool {
    name.starts_with("access$")
}

/// Check if a method is likely a lambda implementation
pub fn is_lambda_impl(name: &str) -> bool {
    name.starts_with("lambda$")
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn test_parse_simple_signature() {
        let sig = "(II)V";
        let parsed = parse_method_signature(sig);

        assert!(parsed.is_some());
        let parsed = parsed.unwrap();
        assert_eq!(parsed.param_types.len(), 2);
        assert!(matches!(parsed.return_type, ArgType::Void));
    }

    #[test]
    fn test_parse_type_variable() {
        let (ty, consumed) = parse_type_at("TT;");
        assert!(matches!(ty, ArgType::TypeVariable { name, .. } if name == "T"));
        assert_eq!(consumed, 3);
    }

    #[test]
    fn test_parse_object_type() {
        let (ty, consumed) = parse_type_at("Ljava/lang/String;");
        assert!(matches!(ty, ArgType::Object(name) if name == "java.lang.String"));
        assert_eq!(consumed, 18);
    }

    #[test]
    fn test_is_synthetic_accessor() {
        assert!(is_synthetic_accessor("access$000"));
        assert!(is_synthetic_accessor("access$100"));
        assert!(!is_synthetic_accessor("getData"));
    }

    #[test]
    fn test_is_lambda_impl() {
        assert!(is_lambda_impl("lambda$run$0"));
        assert!(!is_lambda_impl("run"));
    }
}
