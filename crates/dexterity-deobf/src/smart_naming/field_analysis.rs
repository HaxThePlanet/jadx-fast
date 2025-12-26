//! Field Access Pattern Analysis
//!
//! Analyzes field usage patterns for naming hints:
//! - Dependency injection patterns
//! - Configuration/settings fields
//! - State management fields
//! - Cached values

use dexterity_ir::{ArgType, FieldData, ClassData};

/// Field pattern type
#[derive(Debug, Clone, Copy, PartialEq, Eq, Default)]
pub enum FieldPattern {
    #[default]
    Unknown,
    /// Injected dependency (set in constructor, read elsewhere)
    Dependency,
    /// Configuration value (typically final)
    Configuration,
    /// Mutable state
    State,
    /// Cached/lazy value
    CachedValue,
    /// Counter or index
    Counter,
    /// Flag or boolean state
    Flag,
    /// Constant value (static final)
    Constant,
    /// Companion/singleton instance
    Instance,
    /// Collection (list, map, set)
    Collection,
    /// Listener/callback reference
    Listener,
    /// UI component reference
    ViewReference,
}

/// Analysis result for a field
#[derive(Debug, Clone, Default)]
pub struct FieldAnalysis {
    /// Detected pattern
    pub pattern: FieldPattern,
    /// Suggested name prefix
    pub suggested_prefix: Option<String>,
    /// Suggested name suffix
    pub suggested_suffix: Option<String>,
    /// Suggested full name
    pub suggested_name: Option<String>,
    /// Whether field is likely nullable
    pub likely_nullable: bool,
    /// Confidence score (0.0 - 1.0)
    pub confidence: f32,
}

/// Analyzer for field patterns
pub struct FieldAccessAnalyzer;

impl FieldAccessAnalyzer {
    /// Analyze a field within its class context
    pub fn analyze(field: &FieldData, cls: &ClassData) -> FieldAnalysis {
        let mut analysis = FieldAnalysis::default();

        // Check for constant (static final)
        if field.is_static() && field.is_final() {
            analysis.pattern = FieldPattern::Constant;
            analysis.confidence = 0.9;

            // Constants often have uppercase names
            if Self::is_primitive_or_string(&field.field_type) {
                analysis.suggested_prefix = Some("CONST".to_string());
            }
            return analysis;
        }

        // Check for singleton instance
        if field.is_static() && Self::type_matches_class(&field.field_type, &cls.class_type) {
            analysis.pattern = FieldPattern::Instance;
            analysis.suggested_name = Some("INSTANCE".to_string());
            analysis.confidence = 0.9;
            return analysis;
        }

        // Check for listener/callback
        if Self::is_listener_type(&field.field_type) {
            analysis.pattern = FieldPattern::Listener;
            analysis.suggested_suffix = Self::extract_listener_suffix(&field.field_type);
            analysis.likely_nullable = true;
            analysis.confidence = 0.8;
            return analysis;
        }

        // Check for view reference
        if Self::is_view_type(&field.field_type) {
            analysis.pattern = FieldPattern::ViewReference;
            analysis.suggested_suffix = Self::extract_view_suffix(&field.field_type);
            analysis.likely_nullable = true;
            analysis.confidence = 0.8;
            return analysis;
        }

        // Check for collection type
        if Self::is_collection_type(&field.field_type) {
            analysis.pattern = FieldPattern::Collection;
            analysis.suggested_suffix = Self::extract_collection_suffix(&field.field_type);
            analysis.confidence = 0.8;
            return analysis;
        }

        // Check for flag (boolean)
        if matches!(field.field_type, ArgType::Boolean) {
            analysis.pattern = FieldPattern::Flag;
            analysis.suggested_prefix = Some("is".to_string());
            analysis.confidence = 0.7;
            return analysis;
        }

        // Check for counter (int/long that might be index/count)
        if matches!(field.field_type, ArgType::Int | ArgType::Long) && !field.is_final() {
            // Could be counter or state - low confidence
            analysis.pattern = FieldPattern::Counter;
            analysis.confidence = 0.4;
            return analysis;
        }

        // Check for dependency (injected, typically final)
        if field.is_final() && !field.is_static() && !Self::is_primitive_or_string(&field.field_type) {
            analysis.pattern = FieldPattern::Dependency;
            if let Some(type_name) = Self::extract_simple_type_name(&field.field_type) {
                analysis.suggested_name = Some(to_lower_camel(&type_name));
            }
            analysis.confidence = 0.7;
            return analysis;
        }

        // Check for configuration (might have config-like type)
        if Self::is_config_type(&field.field_type) {
            analysis.pattern = FieldPattern::Configuration;
            analysis.suggested_suffix = Some("Config".to_string());
            analysis.confidence = 0.6;
            return analysis;
        }

        // Default: mutable state
        if !field.is_final() && !field.is_static() {
            analysis.pattern = FieldPattern::State;
            analysis.confidence = 0.3;
        }

        analysis
    }

    /// Analyze multiple fields to find better naming hints
    pub fn analyze_with_context(fields: &[FieldData], cls: &ClassData) -> Vec<FieldAnalysis> {
        fields.iter().map(|f| Self::analyze(f, cls)).collect()
    }

    /// Check if type is a listener/callback type
    fn is_listener_type(arg_type: &ArgType) -> bool {
        match arg_type {
            ArgType::Object(name) => {
                name.contains("Listener")
                    || name.contains("Callback")
                    || name.contains("Observer")
                    || name.contains("Handler")
            }
            ArgType::Generic { base, .. } => {
                base.contains("Listener")
                    || base.contains("Callback")
                    || base.contains("Observer")
            }
            _ => false,
        }
    }

    /// Check if type is a view type
    fn is_view_type(arg_type: &ArgType) -> bool {
        match arg_type {
            ArgType::Object(name) => {
                name.contains("android/widget/")
                    || name.contains("android/view/")
                    || name.contains("androidx/appcompat/widget/")
                    || name.ends_with("View;")
                    || name.ends_with("Button;")
                    || name.ends_with("Text;")
                    || name.ends_with("Layout;")
            }
            _ => false,
        }
    }

    /// Check if type is a collection type
    fn is_collection_type(arg_type: &ArgType) -> bool {
        match arg_type {
            ArgType::Object(name) => {
                name.contains("List")
                    || name.contains("Map")
                    || name.contains("Set")
                    || name.contains("Collection")
                    || name.contains("Array")
                    || name.contains("Queue")
            }
            ArgType::Generic { base, .. } => {
                base.contains("List")
                    || base.contains("Map")
                    || base.contains("Set")
                    || base.contains("Collection")
            }
            ArgType::Array(_) => true,
            _ => false,
        }
    }

    /// Check if type is a config-like type
    fn is_config_type(arg_type: &ArgType) -> bool {
        match arg_type {
            ArgType::Object(name) => {
                name.contains("Config")
                    || name.contains("Settings")
                    || name.contains("Options")
                    || name.contains("Preference")
                    || name.contains("Properties")
            }
            _ => false,
        }
    }

    /// Check if type is primitive or String
    fn is_primitive_or_string(arg_type: &ArgType) -> bool {
        match arg_type {
            ArgType::Int | ArgType::Long | ArgType::Float | ArgType::Double
            | ArgType::Boolean | ArgType::Byte | ArgType::Char | ArgType::Short => true,
            ArgType::Object(name) => name.contains("String"),
            _ => false,
        }
    }

    /// Check if type matches class type
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

    /// Extract simple type name from ArgType
    fn extract_simple_type_name(arg_type: &ArgType) -> Option<String> {
        match arg_type {
            ArgType::Object(name) => {
                let simple = name.trim_start_matches('L').trim_end_matches(';');
                let class_name = simple.rsplit('/').next().unwrap_or(simple);
                Some(class_name.replace('$', ""))
            }
            ArgType::Generic { base, .. } => {
                let simple = base.trim_start_matches('L').trim_end_matches(';');
                let class_name = simple.rsplit('/').next().unwrap_or(simple);
                Some(class_name.replace('$', ""))
            }
            _ => None,
        }
    }

    /// Extract listener suffix
    fn extract_listener_suffix(arg_type: &ArgType) -> Option<String> {
        Self::extract_simple_type_name(arg_type)
    }

    /// Extract view suffix
    fn extract_view_suffix(arg_type: &ArgType) -> Option<String> {
        match arg_type {
            ArgType::Object(name) => {
                let simple = name.trim_start_matches('L').trim_end_matches(';');
                let class_name = simple.rsplit('/').next().unwrap_or(simple);

                // Common view type mappings
                if class_name.contains("Button") {
                    Some("Button".to_string())
                } else if class_name.contains("TextView") || class_name.contains("EditText") {
                    Some("Text".to_string())
                } else if class_name.contains("ImageView") {
                    Some("Image".to_string())
                } else if class_name.contains("RecyclerView") {
                    Some("RecyclerView".to_string())
                } else if class_name.contains("ListView") {
                    Some("ListView".to_string())
                } else if class_name.contains("Layout") {
                    Some("Layout".to_string())
                } else {
                    Some("View".to_string())
                }
            }
            _ => None,
        }
    }

    /// Extract collection suffix
    fn extract_collection_suffix(arg_type: &ArgType) -> Option<String> {
        match arg_type {
            ArgType::Object(name) | ArgType::Generic { base: name, .. } => {
                if name.contains("List") || name.contains("ArrayList") {
                    Some("List".to_string())
                } else if name.contains("Map") || name.contains("HashMap") {
                    Some("Map".to_string())
                } else if name.contains("Set") || name.contains("HashSet") {
                    Some("Set".to_string())
                } else if name.contains("Queue") {
                    Some("Queue".to_string())
                } else {
                    Some("Collection".to_string())
                }
            }
            ArgType::Array(_) => Some("Array".to_string()),
            _ => None,
        }
    }

    /// Generate a field name from analysis
    pub fn generate_field_name(analysis: &FieldAnalysis, type_hint: Option<&str>) -> Option<String> {
        // If we have a suggested full name, use it
        if let Some(ref name) = analysis.suggested_name {
            return Some(name.clone());
        }

        // Combine prefix and suffix with type hint
        let suffix = analysis.suggested_suffix.as_deref()
            .or(type_hint)
            .unwrap_or("value");

        let name = if let Some(ref prefix) = analysis.suggested_prefix {
            if prefix == "is" || prefix == "has" {
                format!("{}{}", prefix, capitalize_first(suffix))
            } else {
                format!("{}{}", to_lower_camel(suffix), capitalize_first(prefix))
            }
        } else {
            to_lower_camel(suffix)
        };

        Some(name)
    }
}

/// Convert to lowerCamelCase
fn to_lower_camel(s: &str) -> String {
    let mut chars = s.chars();
    match chars.next() {
        None => String::new(),
        Some(c) => c.to_lowercase().collect::<String>() + chars.as_str(),
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

    fn make_field(name: &str, flags: u32, field_type: ArgType) -> FieldData {
        FieldData::new(name.to_string(), flags, field_type)
    }

    #[test]
    fn test_constant_detection() {
        let field = make_field("a", 0x0018, ArgType::Int); // static final
        let cls = ClassData::new("Lcom/example/Test;".to_string(), 0);
        let analysis = FieldAccessAnalyzer::analyze(&field, &cls);
        assert_eq!(analysis.pattern, FieldPattern::Constant);
    }

    #[test]
    fn test_listener_detection() {
        let field = make_field(
            "a",
            0,
            ArgType::Object("Landroid/view/View$OnClickListener;".to_string()),
        );
        let cls = ClassData::new("Lcom/example/Test;".to_string(), 0);
        let analysis = FieldAccessAnalyzer::analyze(&field, &cls);
        assert_eq!(analysis.pattern, FieldPattern::Listener);
    }

    #[test]
    fn test_view_detection() {
        let field = make_field(
            "a",
            0,
            ArgType::Object("Landroid/widget/Button;".to_string()),
        );
        let cls = ClassData::new("Lcom/example/Test;".to_string(), 0);
        let analysis = FieldAccessAnalyzer::analyze(&field, &cls);
        assert_eq!(analysis.pattern, FieldPattern::ViewReference);
        assert_eq!(analysis.suggested_suffix, Some("Button".to_string()));
    }

    #[test]
    fn test_collection_detection() {
        let field = make_field(
            "a",
            0,
            ArgType::Object("Ljava/util/ArrayList;".to_string()),
        );
        let cls = ClassData::new("Lcom/example/Test;".to_string(), 0);
        let analysis = FieldAccessAnalyzer::analyze(&field, &cls);
        assert_eq!(analysis.pattern, FieldPattern::Collection);
        assert_eq!(analysis.suggested_suffix, Some("List".to_string()));
    }

    #[test]
    fn test_flag_detection() {
        let field = make_field("a", 0, ArgType::Boolean);
        let cls = ClassData::new("Lcom/example/Test;".to_string(), 0);
        let analysis = FieldAccessAnalyzer::analyze(&field, &cls);
        assert_eq!(analysis.pattern, FieldPattern::Flag);
        assert_eq!(analysis.suggested_prefix, Some("is".to_string()));
    }

    #[test]
    fn test_singleton_instance_detection() {
        let field = make_field(
            "a",
            0x0008, // static
            ArgType::Object("Lcom/example/Test;".to_string()),
        );
        let cls = ClassData::new("Lcom/example/Test;".to_string(), 0);
        let analysis = FieldAccessAnalyzer::analyze(&field, &cls);
        assert_eq!(analysis.pattern, FieldPattern::Instance);
        assert_eq!(analysis.suggested_name, Some("INSTANCE".to_string()));
    }
}
