//! Method Signature Analysis
//!
//! Analyzes method signatures for naming hints:
//! - Getter/setter detection
//! - Event handler patterns
//! - Factory method detection
//! - Lifecycle method detection

use dexterity_ir::{ArgType, MethodData};

/// Method pattern type
#[derive(Debug, Clone, Copy, PartialEq, Eq, Default)]
pub enum MethodPattern {
    #[default]
    Unknown,
    /// Getter: no args, returns value
    Getter,
    /// Setter: one arg, returns void
    Setter,
    /// Boolean getter: no args, returns boolean
    BooleanGetter,
    /// Event handler: void return, event-type arg
    EventHandler,
    /// Factory method: static, returns object
    Factory,
    /// Builder method: returns self type
    BuilderMethod,
    /// Callback method: matches callback interface
    Callback,
    /// Lifecycle method: onCreate, onStart, etc.
    Lifecycle,
    /// Comparator method: compare
    Comparator,
    /// Predicate/filter: returns boolean with args
    Predicate,
    /// Transformer: takes one type, returns another
    Transformer,
}

/// Analysis result for a method
#[derive(Debug, Clone, Default)]
pub struct MethodAnalysis {
    /// Detected pattern
    pub pattern: MethodPattern,
    /// Suggested prefix (e.g., "get", "set", "on")
    pub suggested_prefix: Option<String>,
    /// Suggested suffix (e.g., "Handler", "Callback")
    pub suggested_suffix: Option<String>,
    /// Suggested full name (if determinable)
    pub suggested_name: Option<String>,
    /// Confidence score (0.0 - 1.0)
    pub confidence: f32,
}

/// Analyzer for method signatures
pub struct MethodSignatureAnalyzer;

impl MethodSignatureAnalyzer {
    /// Analyze a method and return naming hints
    pub fn analyze(method: &MethodData, class_type: &str) -> MethodAnalysis {
        let mut analysis = MethodAnalysis::default();

        // Skip constructors and class initializers
        if method.name == "<init>" || method.name == "<clinit>" {
            return analysis;
        }

        // Check for lifecycle methods first (high confidence)
        if let Some(lifecycle_name) = Self::detect_lifecycle_method(method) {
            analysis.pattern = MethodPattern::Lifecycle;
            analysis.suggested_name = Some(lifecycle_name);
            analysis.confidence = 1.0;
            return analysis;
        }

        // Check for getter pattern
        if Self::is_getter(method) {
            analysis.pattern = MethodPattern::Getter;
            analysis.suggested_prefix = Some("get".to_string());
            if let Some(suffix) = Self::extract_type_suffix(&method.return_type) {
                analysis.suggested_suffix = Some(suffix);
            }
            analysis.confidence = 0.8;
            return analysis;
        }

        // Check for boolean getter
        if Self::is_boolean_getter(method) {
            analysis.pattern = MethodPattern::BooleanGetter;
            analysis.suggested_prefix = Some("is".to_string());
            analysis.confidence = 0.8;
            return analysis;
        }

        // Check for setter pattern
        if Self::is_setter(method) {
            analysis.pattern = MethodPattern::Setter;
            analysis.suggested_prefix = Some("set".to_string());
            if let Some(suffix) = Self::extract_type_suffix(&method.arg_types[0]) {
                analysis.suggested_suffix = Some(suffix);
            }
            analysis.confidence = 0.8;
            return analysis;
        }

        // Check for event handler
        if Self::is_event_handler(method) {
            analysis.pattern = MethodPattern::EventHandler;
            analysis.suggested_prefix = Some("on".to_string());
            if let Some(event_type) = Self::extract_event_type(method) {
                analysis.suggested_suffix = Some(event_type);
            }
            analysis.confidence = 0.7;
            return analysis;
        }

        // Check for factory method
        if Self::is_factory_method(method, class_type) {
            analysis.pattern = MethodPattern::Factory;
            analysis.suggested_prefix = Some("create".to_string());
            if let Some(suffix) = Self::extract_type_suffix(&method.return_type) {
                analysis.suggested_suffix = Some(suffix);
            }
            analysis.confidence = 0.7;
            return analysis;
        }

        // Check for builder method
        if Self::is_builder_method(method, class_type) {
            analysis.pattern = MethodPattern::BuilderMethod;
            // Keep original name but add hint
            if method.arg_types.len() == 1 {
                analysis.suggested_prefix = Some("with".to_string());
            }
            analysis.confidence = 0.6;
            return analysis;
        }

        // Check for comparator
        if Self::is_comparator_method(method) {
            analysis.pattern = MethodPattern::Comparator;
            analysis.suggested_name = Some("compare".to_string());
            analysis.confidence = 0.9;
            return analysis;
        }

        // Check for predicate/filter
        if Self::is_predicate(method) {
            analysis.pattern = MethodPattern::Predicate;
            analysis.suggested_prefix = Some("matches".to_string());
            analysis.confidence = 0.5;
            return analysis;
        }

        // Check for transformer
        if Self::is_transformer(method) {
            analysis.pattern = MethodPattern::Transformer;
            analysis.suggested_prefix = Some("transform".to_string());
            analysis.confidence = 0.5;
            return analysis;
        }

        analysis
    }

    /// Check if method is a getter
    fn is_getter(method: &MethodData) -> bool {
        !method.is_static()
            && method.arg_types.is_empty()
            && !method.return_type.is_void()
            && !matches!(method.return_type, ArgType::Boolean)
    }

    /// Check if method is a boolean getter
    fn is_boolean_getter(method: &MethodData) -> bool {
        !method.is_static()
            && method.arg_types.is_empty()
            && matches!(method.return_type, ArgType::Boolean)
    }

    /// Check if method is a setter
    fn is_setter(method: &MethodData) -> bool {
        !method.is_static()
            && method.arg_types.len() == 1
            && method.return_type.is_void()
    }

    /// Check if method is an event handler
    fn is_event_handler(method: &MethodData) -> bool {
        method.return_type.is_void()
            && !method.arg_types.is_empty()
            && method.arg_types.iter().any(|arg| {
                match arg {
                    ArgType::Object(name) => {
                        name.contains("Event")
                            || name.contains("Motion")
                            || name.contains("Key")
                            || name.contains("Touch")
                            || name.contains("Click")
                    }
                    _ => false,
                }
            })
    }

    /// Check if method is a factory method
    fn is_factory_method(method: &MethodData, class_type: &str) -> bool {
        method.is_static()
            && !method.return_type.is_void()
            && !method.return_type.is_primitive()
            && !Self::type_matches_class(&method.return_type, class_type)
    }

    /// Check if method is a builder method (returns self)
    fn is_builder_method(method: &MethodData, class_type: &str) -> bool {
        !method.is_static()
            && Self::type_matches_class(&method.return_type, class_type)
            && !method.arg_types.is_empty()
    }

    /// Check if method is a comparator
    fn is_comparator_method(method: &MethodData) -> bool {
        method.arg_types.len() == 2
            && matches!(method.return_type, ArgType::Int)
            && method.arg_types[0] == method.arg_types[1]
    }

    /// Check if method is a predicate (filter function)
    fn is_predicate(method: &MethodData) -> bool {
        matches!(method.return_type, ArgType::Boolean)
            && !method.arg_types.is_empty()
            && !method.is_static()
    }

    /// Check if method is a transformer (takes one type, returns another)
    fn is_transformer(method: &MethodData) -> bool {
        method.arg_types.len() == 1
            && !method.return_type.is_void()
            && !method.return_type.is_primitive()
            && method.arg_types[0] != method.return_type
    }

    /// Detect lifecycle method
    fn detect_lifecycle_method(method: &MethodData) -> Option<String> {
        // Android Activity/Fragment lifecycle
        let lifecycle_methods = [
            "onCreate", "onStart", "onResume", "onPause", "onStop", "onDestroy",
            "onRestart", "onCreateView", "onViewCreated", "onDestroyView",
            "onAttach", "onDetach", "onSaveInstanceState", "onRestoreInstanceState",
            "onActivityResult", "onRequestPermissionsResult", "onConfigurationChanged",
            "onNewIntent", "onBackPressed", "onOptionsItemSelected", "onCreateOptionsMenu",
        ];

        // Check for exact match (common for lifecycle methods to remain named)
        if lifecycle_methods.contains(&method.name.as_str()) {
            return Some(method.name.clone());
        }

        // Check for signature-based detection
        // onCreate(Bundle) -> onCreate
        if method.return_type.is_void() && method.arg_types.len() == 1 {
            if let ArgType::Object(name) = &method.arg_types[0] {
                if name.contains("Bundle") {
                    return Some("onCreate".to_string());
                }
            }
        }

        None
    }

    /// Extract a readable suffix from a type
    fn extract_type_suffix(arg_type: &ArgType) -> Option<String> {
        match arg_type {
            ArgType::Object(name) => {
                let simple = name.trim_start_matches('L').trim_end_matches(';');
                let class_name = simple.rsplit('/').next().unwrap_or(simple);
                // Remove common suffixes
                let cleaned = class_name
                    .trim_end_matches("Impl")
                    .trim_end_matches("Data")
                    .trim_end_matches("Info");
                if !cleaned.is_empty() {
                    Some(cleaned.to_string())
                } else {
                    None
                }
            }
            ArgType::Generic { base, params } => {
                // For generics, try to get element type
                if !params.is_empty() {
                    Self::extract_type_suffix(&params[0])
                } else {
                    let simple = base.trim_start_matches('L').trim_end_matches(';');
                    Some(simple.rsplit('/').next().unwrap_or(simple).to_string())
                }
            }
            ArgType::Array(element) => {
                Self::extract_type_suffix(element).map(|s| format!("{}Array", s))
            }
            ArgType::Int => Some("Int".to_string()),
            ArgType::Long => Some("Long".to_string()),
            ArgType::Float => Some("Float".to_string()),
            ArgType::Double => Some("Double".to_string()),
            ArgType::Boolean => Some("Boolean".to_string()),
            ArgType::Byte => Some("Byte".to_string()),
            ArgType::Char => Some("Char".to_string()),
            ArgType::Short => Some("Short".to_string()),
            _ => None,
        }
    }

    /// Extract event type from method args
    fn extract_event_type(method: &MethodData) -> Option<String> {
        for arg in &method.arg_types {
            if let ArgType::Object(name) = arg {
                if name.contains("Event") || name.contains("Motion") {
                    let simple = name.trim_start_matches('L').trim_end_matches(';');
                    let class_name = simple.rsplit('/').next().unwrap_or(simple);
                    return Some(class_name.to_string());
                }
            }
        }
        None
    }

    /// Check if a type matches a class type
    fn type_matches_class(arg_type: &ArgType, class_type: &str) -> bool {
        match arg_type {
            ArgType::Object(name) => {
                name.trim_start_matches('L').trim_end_matches(';')
                    == class_type.trim_start_matches('L').trim_end_matches(';')
            }
            ArgType::Generic { base, .. } => {
                base.trim_start_matches('L').trim_end_matches(';')
                    == class_type.trim_start_matches('L').trim_end_matches(';')
            }
            _ => false,
        }
    }

    /// Generate a method name from analysis
    pub fn generate_method_name(analysis: &MethodAnalysis) -> Option<String> {
        // If we have a suggested full name, use it
        if let Some(ref name) = analysis.suggested_name {
            return Some(name.clone());
        }

        // Combine prefix and suffix
        match (&analysis.suggested_prefix, &analysis.suggested_suffix) {
            (Some(prefix), Some(suffix)) => Some(format!("{}{}", prefix, capitalize_first(suffix))),
            (Some(prefix), None) => Some(format!("{}Value", prefix)),
            (None, Some(suffix)) => Some(format!("do{}", capitalize_first(suffix))),
            (None, None) => None,
        }
    }
}

/// Capitalize the first character
fn capitalize_first(s: &str) -> String {
    let mut chars = s.chars();
    match chars.next() {
        None => String::new(),
        Some(c) => c.to_uppercase().collect::<String>() + chars.as_str(),
    }
}

#[cfg(test)]
mod tests {
    use super::*;

    fn make_method(name: &str, is_static: bool, return_type: ArgType, args: Vec<ArgType>) -> MethodData {
        let mut m = MethodData::new(name.to_string(), if is_static { 0x0008 } else { 0 }, return_type);
        m.arg_types = args;
        m
    }

    #[test]
    fn test_getter_detection() {
        let method = make_method("a", false, ArgType::Object("Ljava/lang/String;".to_string()), vec![]);
        let analysis = MethodSignatureAnalyzer::analyze(&method, "Lcom/example/Test;");
        assert_eq!(analysis.pattern, MethodPattern::Getter);
        assert_eq!(analysis.suggested_prefix, Some("get".to_string()));
    }

    #[test]
    fn test_boolean_getter_detection() {
        let method = make_method("a", false, ArgType::Boolean, vec![]);
        let analysis = MethodSignatureAnalyzer::analyze(&method, "Lcom/example/Test;");
        assert_eq!(analysis.pattern, MethodPattern::BooleanGetter);
        assert_eq!(analysis.suggested_prefix, Some("is".to_string()));
    }

    #[test]
    fn test_setter_detection() {
        let method = make_method("a", false, ArgType::Void, vec![ArgType::Int]);
        let analysis = MethodSignatureAnalyzer::analyze(&method, "Lcom/example/Test;");
        assert_eq!(analysis.pattern, MethodPattern::Setter);
        assert_eq!(analysis.suggested_prefix, Some("set".to_string()));
    }

    #[test]
    fn test_factory_detection() {
        let method = make_method(
            "a",
            true,
            ArgType::Object("Lcom/example/User;".to_string()),
            vec![ArgType::Object("Ljava/lang/String;".to_string())],
        );
        let analysis = MethodSignatureAnalyzer::analyze(&method, "Lcom/example/Factory;");
        assert_eq!(analysis.pattern, MethodPattern::Factory);
        assert_eq!(analysis.suggested_prefix, Some("create".to_string()));
    }

    #[test]
    fn test_lifecycle_detection() {
        let method = make_method(
            "onCreate",
            false,
            ArgType::Void,
            vec![ArgType::Object("Landroid/os/Bundle;".to_string())],
        );
        let analysis = MethodSignatureAnalyzer::analyze(&method, "Lcom/example/Activity;");
        assert_eq!(analysis.pattern, MethodPattern::Lifecycle);
        assert_eq!(analysis.suggested_name, Some("onCreate".to_string()));
    }

    #[test]
    fn test_method_name_generation() {
        let analysis = MethodAnalysis {
            pattern: MethodPattern::Getter,
            suggested_prefix: Some("get".to_string()),
            suggested_suffix: Some("User".to_string()),
            suggested_name: None,
            confidence: 0.8,
        };
        let name = MethodSignatureAnalyzer::generate_method_name(&analysis);
        assert_eq!(name, Some("getUser".to_string()));
    }
}
