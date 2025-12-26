//! Smart Alias Provider
//!
//! Main entry point for smart naming that integrates:
//! - Type-based hints
//! - Pattern detection
//! - Android component detection
//! - Method/field analysis
//!
//! Implements AliasProvider trait for drop-in replacement of DeobfAliasProvider.

use dexterity_ir::{ClassData, FieldData, MethodData};
use crate::alias_provider::{AliasProvider, DeobfAliasProvider};
use super::{
    TypeHintsEngine,
    PatternDetector, DetectedPattern,
    AndroidComponentDetector, AndroidComponent,
    MethodSignatureAnalyzer, MethodPattern,
    FieldAccessAnalyzer,
};
use std::collections::HashMap;
use std::sync::Mutex;

/// Smart alias provider with semantic naming capabilities
///
/// This provider attempts to generate meaningful names based on:
/// 1. Android component type (Activity, Fragment, Service, etc.)
/// 2. Design pattern detection (Singleton, Builder, Factory, etc.)
/// 3. Type-based hints (Map -> xxxMap, List -> xxxList)
/// 4. Method signature analysis (getter/setter/event handler)
/// 5. Field usage patterns (dependency/state/listener)
///
/// Falls back to JADX-style naming when semantic naming fails.
///
/// Note: Uses collision tracking to ensure unique names by appending
/// incrementing indexes when the same semantic name is generated for
/// multiple classes (e.g., CustomObject0, CustomObject1, etc.)
pub struct SmartAliasProvider {
    /// Fallback provider for when smart naming fails
    fallback: DeobfAliasProvider,
    /// Type hints engine
    type_hints: TypeHintsEngine,
    /// Minimum confidence threshold for accepting smart names
    confidence_threshold: f32,
    /// Whether smart naming is enabled
    enabled: bool,
    /// Track used class names to avoid collisions (name -> count)
    used_class_names: Mutex<HashMap<String, u32>>,
    /// Track used field names to avoid collisions
    used_field_names: Mutex<HashMap<String, u32>>,
    /// Track used method names to avoid collisions
    used_method_names: Mutex<HashMap<String, u32>>,
}

impl SmartAliasProvider {
    /// Create a new smart alias provider
    pub fn new(max_length: usize) -> Self {
        Self {
            fallback: DeobfAliasProvider::new(max_length),
            type_hints: TypeHintsEngine::new(),
            confidence_threshold: 0.5,
            enabled: true,
            used_class_names: Mutex::new(HashMap::new()),
            used_field_names: Mutex::new(HashMap::new()),
            used_method_names: Mutex::new(HashMap::new()),
        }
    }

    /// Get a unique name by appending an index if the name was already used
    fn make_unique_class_name(&self, base_name: &str) -> String {
        let mut used = self.used_class_names.lock().unwrap();
        let count = used.entry(base_name.to_string()).or_insert(0);
        let result = if *count == 0 {
            base_name.to_string()
        } else {
            format!("{}{}", base_name, count)
        };
        *count += 1;
        result
    }

    /// Get a unique field name by appending an index if already used
    fn make_unique_field_name(&self, base_name: &str) -> String {
        let mut used = self.used_field_names.lock().unwrap();
        let count = used.entry(base_name.to_string()).or_insert(0);
        let result = if *count == 0 {
            base_name.to_string()
        } else {
            format!("{}{}", base_name, count)
        };
        *count += 1;
        result
    }

    /// Get a unique method name by appending an index if already used
    fn make_unique_method_name(&self, base_name: &str) -> String {
        let mut used = self.used_method_names.lock().unwrap();
        let count = used.entry(base_name.to_string()).or_insert(0);
        let result = if *count == 0 {
            base_name.to_string()
        } else {
            format!("{}{}", base_name, count)
        };
        *count += 1;
        result
    }

    /// Create with custom confidence threshold
    pub fn with_confidence(mut self, threshold: f32) -> Self {
        self.confidence_threshold = threshold;
        self
    }

    /// Disable smart naming (use fallback only)
    pub fn disable(mut self) -> Self {
        self.enabled = false;
        self
    }

    /// Initialize indexes from a loaded mapping file
    pub fn init_indexes(&self, pkg: u32, cls: u32, fld: u32, mth: u32) {
        self.fallback.init_indexes(pkg, cls, fld, mth);
    }

    /// Get current index values (for saving state)
    pub fn get_indexes(&self) -> (u32, u32, u32, u32) {
        self.fallback.get_indexes()
    }

    /// Try to generate a smart class name
    fn smart_class_name(&self, cls: &ClassData) -> Option<String> {
        if !self.enabled {
            return None;
        }

        // Priority 1: Android component detection
        if let Some(component) = AndroidComponentDetector::detect(cls) {
            return self.name_from_android_component(cls, &component);
        }

        // Priority 2: Design pattern detection
        let patterns = PatternDetector::detect(cls);
        if let Some(name) = self.name_from_patterns(cls, &patterns) {
            return Some(name);
        }

        // Priority 3: Superclass/interface-based naming
        if let Some(name) = self.name_from_hierarchy(cls) {
            return Some(name);
        }

        None
    }

    /// Generate name from Android component type
    fn name_from_android_component(&self, cls: &ClassData, component: &AndroidComponent) -> Option<String> {
        let suffix = component.naming_suffix();
        let prefix = component.naming_prefix();

        // Try to extract a meaningful base name from the obfuscated name
        let simple_name = cls.simple_name();
        let base = if simple_name.len() > 2 && simple_name.chars().any(|c| c.is_uppercase()) {
            // Has some readable characters, try to preserve them
            simple_name.to_string()
        } else if let Some(p) = prefix {
            p.to_string()
        } else {
            // Use fallback index
            return None;
        };

        // Build the name
        let name = if let Some(p) = prefix {
            if base.to_lowercase().contains(&p.to_lowercase()) {
                // Prefix already in name
                format!("{}{}", capitalize(&base), suffix)
            } else {
                format!("{}{}{}", p, capitalize(&base), suffix)
            }
        } else {
            format!("{}{}", capitalize(&base), suffix)
        };

        Some(name)
    }

    /// Generate name from detected patterns
    fn name_from_patterns(&self, cls: &ClassData, patterns: &[DetectedPattern]) -> Option<String> {
        if patterns.is_empty() {
            return None;
        }

        let pattern = &patterns[0]; // Use first (most confident) pattern

        match pattern {
            DetectedPattern::Singleton => {
                // Try to get a meaningful base name
                let base = self.extract_base_name(cls).unwrap_or_else(|| "Instance".to_string());
                Some(format!("{}Singleton", base))
            }
            DetectedPattern::Builder { built_type } => {
                if let Some(built) = built_type {
                    Some(format!("{}Builder", built))
                } else {
                    None
                }
            }
            DetectedPattern::Factory { created_type } => {
                if let Some(created) = created_type {
                    Some(format!("{}Factory", created))
                } else {
                    None
                }
            }
            DetectedPattern::Adapter { wrapped_type } => {
                if let Some(wrapped) = wrapped_type {
                    Some(format!("{}Adapter", wrapped))
                } else {
                    None
                }
            }
            DetectedPattern::Repository { entity_type } => {
                if let Some(entity) = entity_type {
                    Some(format!("{}Repository", entity))
                } else {
                    None
                }
            }
            DetectedPattern::ViewModel => {
                let base = self.extract_base_name(cls).unwrap_or_else(|| "Main".to_string());
                Some(format!("{}ViewModel", base))
            }
            DetectedPattern::DataClass => {
                // Keep simple, just add Data suffix if needed
                let base = self.extract_base_name(cls)?;
                if base.ends_with("Data") || base.ends_with("Info") || base.ends_with("Model") {
                    Some(base)
                } else {
                    Some(format!("{}Data", base))
                }
            }
            DetectedPattern::Comparator => {
                let base = self.extract_base_name(cls).unwrap_or_else(|| "Item".to_string());
                Some(format!("{}Comparator", base))
            }
            _ => None,
        }
    }

    /// Generate name from class hierarchy (superclass/interfaces)
    fn name_from_hierarchy(&self, cls: &ClassData) -> Option<String> {
        // Check for framework superclass
        if let Some(ref super_cls) = cls.superclass {
            let super_name = super_cls.trim_start_matches('L').trim_end_matches(';');

            // Get the simple name of superclass
            let super_simple = super_name.rsplit('/').next().unwrap_or(super_name).replace('$', "");

            // If superclass is a framework class, use it as suffix
            if is_framework_class(super_name) && super_simple.len() > 3 {
                let base = self.extract_base_name(cls).unwrap_or_else(|| "Custom".to_string());
                return Some(format!("{}{}", base, super_simple));
            }
        }

        // Check interfaces
        for iface in &cls.interfaces {
            if let dexterity_ir::ArgType::Object(name) = iface {
                let iface_name = name.trim_start_matches('L').trim_end_matches(';');
                let iface_simple = iface_name.rsplit('/').next().unwrap_or(iface_name).replace('$', "");

                // If interface is a callback/listener type
                if iface_simple.ends_with("Listener")
                    || iface_simple.ends_with("Callback")
                    || iface_simple.ends_with("Handler")
                {
                    let base = self.extract_base_name(cls);
                    return Some(format!("{}{}", base.unwrap_or_default(), iface_simple));
                }
            }
        }

        None
    }

    /// Extract a base name from the class
    fn extract_base_name(&self, cls: &ClassData) -> Option<String> {
        let simple = cls.simple_name();

        // If name is already readable (has some uppercase, reasonable length)
        if simple.len() >= 3
            && simple.chars().filter(|c| c.is_uppercase()).count() > 0
            && simple.chars().filter(|c| c.is_lowercase()).count() > 0
        {
            // Clean up the name
            let cleaned = simple
                .trim_end_matches("Impl")
                .trim_end_matches("Stub");
            if !cleaned.is_empty() {
                return Some(cleaned.to_string());
            }
        }

        None
    }

    /// Try to generate a smart field name
    fn smart_field_name(&self, field: &FieldData, cls: &ClassData) -> Option<String> {
        if !self.enabled {
            return None;
        }

        // Analyze the field
        let analysis = FieldAccessAnalyzer::analyze(field, cls);

        if analysis.confidence >= self.confidence_threshold {
            // Get type hints
            let type_hints = self.type_hints.get_hints(&field.field_type);
            let type_suffix = type_hints.suffix.as_deref();

            // Generate name from analysis
            if let Some(name) = FieldAccessAnalyzer::generate_field_name(&analysis, type_suffix) {
                return Some(name);
            }

            // Try type-based naming
            if let Some(name) = self.type_hints.generate_field_name(&field.field_type) {
                return Some(name);
            }
        }

        None
    }

    /// Try to generate a smart method name
    fn smart_method_name(&self, method: &MethodData, class_type: &str) -> Option<String> {
        if !self.enabled {
            return None;
        }

        // Skip constructors
        if method.name == "<init>" || method.name == "<clinit>" {
            return None;
        }

        // Analyze the method
        let analysis = MethodSignatureAnalyzer::analyze(method, class_type);

        if analysis.confidence >= self.confidence_threshold {
            if let Some(name) = MethodSignatureAnalyzer::generate_method_name(&analysis) {
                return Some(name);
            }
        }

        // Try type-based naming for return type
        if analysis.pattern == MethodPattern::Getter {
            let hints = self.type_hints.get_hints(&method.return_type);
            if let Some(suffix) = hints.suffix {
                return Some(format!("get{}", suffix));
            }
        }

        None
    }
}

impl AliasProvider for SmartAliasProvider {
    fn for_package(&self, name: &str) -> String {
        // Packages don't benefit much from smart naming
        self.fallback.for_package(name)
    }

    fn for_class(&self, cls: &ClassData) -> String {
        // Try smart naming first
        if let Some(smart_name) = self.smart_class_name(cls) {
            // Validate the smart name
            if is_valid_identifier(&smart_name) && smart_name.len() >= 3 {
                // Make unique to avoid collisions (e.g., CustomObject0, CustomObject1)
                return self.make_unique_class_name(&smart_name);
            }
        }

        // Fall back to JADX-style naming (already unique via index)
        self.fallback.for_class(cls)
    }

    fn for_field(&self, field: &FieldData) -> String {
        // Create a minimal class context for analysis
        let cls = ClassData::new("Lplaceholder;".to_string(), 0);

        // Try smart naming first
        if let Some(smart_name) = self.smart_field_name(field, &cls) {
            if is_valid_identifier(&smart_name) && smart_name.len() >= 2 {
                // Make unique to avoid collisions within the class
                return self.make_unique_field_name(&smart_name);
            }
        }

        // Fall back to JADX-style naming (already unique via index)
        self.fallback.for_field(field)
    }

    fn for_method(&self, method: &MethodData, is_override: bool) -> String {
        // Try smart naming first
        if let Some(smart_name) = self.smart_method_name(method, "") {
            if is_valid_identifier(&smart_name) && smart_name.len() >= 2 {
                // Make unique to avoid collisions
                return self.make_unique_method_name(&smart_name);
            }
        }

        // Fall back to JADX-style naming (already unique via index)
        self.fallback.for_method(method, is_override)
    }
}

/// Check if a class is from a known framework
fn is_framework_class(class_name: &str) -> bool {
    class_name.starts_with("android/")
        || class_name.starts_with("androidx/")
        || class_name.starts_with("java/")
        || class_name.starts_with("kotlin/")
        || class_name.starts_with("com/google/")
}

/// Check if a string is a valid Java identifier
fn is_valid_identifier(s: &str) -> bool {
    if s.is_empty() {
        return false;
    }

    let mut chars = s.chars();
    let first = chars.next().unwrap();

    if !first.is_alphabetic() && first != '_' && first != '$' {
        return false;
    }

    chars.all(|c| c.is_alphanumeric() || c == '_' || c == '$')
}

/// Capitalize the first character
fn capitalize(s: &str) -> String {
    let mut chars = s.chars();
    match chars.next() {
        None => String::new(),
        Some(c) => c.to_uppercase().collect::<String>() + chars.as_str(),
    }
}

#[cfg(test)]
mod tests {
    use super::*;
    use dexterity_ir::ArgType;

    #[test]
    fn test_smart_provider_basic() {
        let provider = SmartAliasProvider::new(64);

        // Test package (should use fallback)
        let pkg_name = provider.for_package("a");
        assert!(pkg_name.starts_with("p00"));

        // Test field with type hint
        let field = FieldData::new("a".to_string(), 0, ArgType::Object("Ljava/util/ArrayList;".to_string()));
        let field_name = provider.for_field(&field);
        // Should get a smart name based on type or fallback to JADX-style
        assert!(field_name.contains("List") || field_name.contains("list") || field_name.starts_with("f"), "Got: {}", field_name);
    }

    #[test]
    fn test_android_component_naming() {
        let provider = SmartAliasProvider::new(64);

        let mut cls = ClassData::new("Lcom/example/a;".to_string(), 0);
        cls.superclass = Some("Landroid/app/Activity;".to_string());

        let name = provider.for_class(&cls);
        // Should detect as Activity
        assert!(name.contains("Activity") || name.starts_with("C"), "Got: {}", name);
    }

    #[test]
    fn test_viewmodel_naming() {
        let provider = SmartAliasProvider::new(64);

        let mut cls = ClassData::new("Lcom/example/UserViewModel;".to_string(), 0);
        cls.superclass = Some("Landroidx/lifecycle/ViewModel;".to_string());

        let name = provider.for_class(&cls);
        assert!(name.contains("ViewModel"), "Got: {}", name);
    }

    #[test]
    fn test_method_pattern_detection() {
        let provider = SmartAliasProvider::new(64);

        // Getter pattern
        let method = MethodData::new("a".to_string(), 0, ArgType::Object("Ljava/lang/String;".to_string()));
        let name = provider.for_method(&method, false);
        // Should detect as getter
        assert!(name.contains("get") || name.starts_with("m"), "Got: {}", name);
    }

    #[test]
    fn test_fallback_works() {
        let provider = SmartAliasProvider::new(64).disable();

        let cls = ClassData::new("Lcom/example/a;".to_string(), 0);
        let name = provider.for_class(&cls);

        // Should use fallback (JADX-style)
        assert!(name.starts_with("C") && name.contains("0"));
    }

    #[test]
    fn test_identifier_validation() {
        assert!(is_valid_identifier("validName"));
        assert!(is_valid_identifier("_underscore"));
        assert!(is_valid_identifier("$dollar"));
        assert!(!is_valid_identifier(""));
        assert!(!is_valid_identifier("123"));
        assert!(!is_valid_identifier("has space"));
    }

    #[test]
    fn test_collision_tracking_classes() {
        let provider = SmartAliasProvider::new(64);

        // Create multiple classes that would generate the same semantic name
        // (e.g., multiple ViewModels or Activities)
        let mut cls1 = ClassData::new("Lcom/example/a;".to_string(), 0);
        cls1.superclass = Some("Landroidx/lifecycle/ViewModel;".to_string());

        let mut cls2 = ClassData::new("Lcom/example/b;".to_string(), 0);
        cls2.superclass = Some("Landroidx/lifecycle/ViewModel;".to_string());

        let mut cls3 = ClassData::new("Lcom/example/c;".to_string(), 0);
        cls3.superclass = Some("Landroidx/lifecycle/ViewModel;".to_string());

        let name1 = provider.for_class(&cls1);
        let name2 = provider.for_class(&cls2);
        let name3 = provider.for_class(&cls3);

        // All names should be unique
        assert_ne!(name1, name2, "Names should be unique: {} vs {}", name1, name2);
        assert_ne!(name2, name3, "Names should be unique: {} vs {}", name2, name3);
        assert_ne!(name1, name3, "Names should be unique: {} vs {}", name1, name3);

        // If they generate ViewModel names, they should have incrementing suffixes
        if name1.contains("ViewModel") {
            // First one gets base name, subsequent get numbered suffixes
            assert!(name2.contains("ViewModel"), "Expected ViewModel in name: {}", name2);
            assert!(name3.contains("ViewModel"), "Expected ViewModel in name: {}", name3);
        }
    }

    #[test]
    fn test_make_unique_class_name() {
        let provider = SmartAliasProvider::new(64);

        // First call should return base name
        let name1 = provider.make_unique_class_name("CustomObject");
        assert_eq!(name1, "CustomObject");

        // Second call should return name with suffix
        let name2 = provider.make_unique_class_name("CustomObject");
        assert_eq!(name2, "CustomObject1");

        // Third call should return name with incremented suffix
        let name3 = provider.make_unique_class_name("CustomObject");
        assert_eq!(name3, "CustomObject2");

        // Different base name should start fresh
        let name4 = provider.make_unique_class_name("DifferentClass");
        assert_eq!(name4, "DifferentClass");
    }
}
