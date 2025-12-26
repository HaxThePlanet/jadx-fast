//! Design Pattern Detection
//!
//! Detects common design patterns for improved class naming:
//! - Singleton: private constructor + static getInstance
//! - Builder: self-returning setters + build() method
//! - Factory: static creation methods
//! - Adapter: wraps another type
//! - Repository: CRUD-like methods for entity type

use dexterity_ir::{ArgType, ClassData};

/// Detected design patterns
#[derive(Debug, Clone, PartialEq, Eq)]
pub enum DetectedPattern {
    /// Singleton pattern: private static instance + getInstance()
    Singleton,
    /// Builder pattern: fluent setters + build()
    Builder {
        /// The type being built (if detectable)
        built_type: Option<String>,
    },
    /// Factory pattern: static creation methods
    Factory {
        /// The type being created
        created_type: Option<String>,
    },
    /// Adapter pattern: wraps another type
    Adapter {
        /// The wrapped type
        wrapped_type: Option<String>,
    },
    /// Repository pattern: data access for entity type
    Repository {
        /// The entity type
        entity_type: Option<String>,
    },
    /// ViewModel pattern: holds UI state
    ViewModel,
    /// Presenter pattern: MVP presenter
    Presenter,
    /// UseCase/Interactor pattern: clean architecture
    UseCase,
    /// Data class: primarily holds data
    DataClass,
    /// Enum companion: holds enum values
    EnumCompanion,
    /// Comparator: implements comparison
    Comparator,
    /// Serializer: handles serialization
    Serializer,
}

impl DetectedPattern {
    /// Get a naming suffix for this pattern
    pub fn naming_suffix(&self) -> Option<&'static str> {
        match self {
            DetectedPattern::Singleton => Some("Singleton"),
            DetectedPattern::Builder { .. } => Some("Builder"),
            DetectedPattern::Factory { .. } => Some("Factory"),
            DetectedPattern::Adapter { .. } => Some("Adapter"),
            DetectedPattern::Repository { .. } => Some("Repository"),
            DetectedPattern::ViewModel => Some("ViewModel"),
            DetectedPattern::Presenter => Some("Presenter"),
            DetectedPattern::UseCase => Some("UseCase"),
            DetectedPattern::DataClass => Some("Data"),
            DetectedPattern::EnumCompanion => Some("Companion"),
            DetectedPattern::Comparator => Some("Comparator"),
            DetectedPattern::Serializer => Some("Serializer"),
        }
    }
}

/// Detects common design patterns in classes
pub struct PatternDetector;

impl PatternDetector {
    /// Detect all patterns in a class
    pub fn detect(cls: &ClassData) -> Vec<DetectedPattern> {
        let mut patterns = Vec::new();

        // Check for Singleton
        if Self::is_singleton(cls) {
            patterns.push(DetectedPattern::Singleton);
        }

        // Check for Builder
        if let Some(built_type) = Self::detect_builder(cls) {
            patterns.push(DetectedPattern::Builder { built_type });
        }

        // Check for Factory
        if let Some(created_type) = Self::detect_factory(cls) {
            patterns.push(DetectedPattern::Factory { created_type });
        }

        // Check for Adapter
        if let Some(wrapped_type) = Self::detect_adapter(cls) {
            patterns.push(DetectedPattern::Adapter { wrapped_type });
        }

        // Check for Repository
        if let Some(entity_type) = Self::detect_repository(cls) {
            patterns.push(DetectedPattern::Repository { entity_type });
        }

        // Check for ViewModel
        if Self::is_viewmodel(cls) {
            patterns.push(DetectedPattern::ViewModel);
        }

        // Check for Comparator
        if Self::is_comparator(cls) {
            patterns.push(DetectedPattern::Comparator);
        }

        // Check for Data class
        if Self::is_data_class(cls) {
            patterns.push(DetectedPattern::DataClass);
        }

        patterns
    }

    /// Check if class is a Singleton
    ///
    /// Pattern indicators:
    /// - Private constructor
    /// - Static field of same type as class
    /// - Static getInstance/get method returning class type
    fn is_singleton(cls: &ClassData) -> bool {
        let class_type = &cls.class_type;

        // Check for private constructor (0x0002 is private access flag)
        let has_private_constructor = cls.methods.iter().any(|m| {
            m.name == "<init>" && (m.access_flags & 0x0002) != 0
        });

        // Check for static field of same type
        let has_static_self_field = cls.static_fields.iter().any(|f| {
            f.is_static() && Self::type_matches_class(&f.field_type, class_type)
        });

        // Check for static getInstance-like method
        let has_get_instance = cls.methods.iter().any(|m| {
            m.is_static()
                && m.arg_types.is_empty()
                && Self::type_matches_class(&m.return_type, class_type)
                && (m.name.to_lowercase().contains("instance")
                    || m.name.to_lowercase().contains("singleton")
                    || m.name == "get")
        });

        // Need at least 2 of 3 indicators
        let count = [has_private_constructor, has_static_self_field, has_get_instance]
            .iter()
            .filter(|&&b| b)
            .count();

        count >= 2
    }

    /// Detect Builder pattern
    ///
    /// Returns the type being built if detected
    fn detect_builder(cls: &ClassData) -> Option<Option<String>> {
        // Check for fluent setters (methods that return self type)
        let class_type = &cls.class_type;
        let fluent_setters: Vec<_> = cls.methods.iter()
            .filter(|m| {
                !m.is_static()
                    && m.arg_types.len() == 1
                    && Self::type_matches_class(&m.return_type, class_type)
                    && (m.name.starts_with("set")
                        || m.name.starts_with("with")
                        || m.name.starts_with("add"))
            })
            .collect();

        // Need at least 2 fluent setters
        if fluent_setters.len() < 2 {
            return None;
        }

        // Check for build() method
        let build_method = cls.methods.iter().find(|m| {
            m.name == "build" || m.name == "create" || m.name == "make"
        });

        if let Some(build) = build_method {
            // Extract the built type
            let built_type = match &build.return_type {
                ArgType::Object(name) => {
                    let simple = name.trim_start_matches('L').trim_end_matches(';');
                    Some(simple.rsplit('/').next().unwrap_or(simple).to_string())
                }
                _ => None,
            };
            Some(built_type)
        } else if fluent_setters.len() >= 3 {
            // Many fluent setters without build() - still likely a builder
            Some(None)
        } else {
            None
        }
    }

    /// Detect Factory pattern
    fn detect_factory(cls: &ClassData) -> Option<Option<String>> {
        // Look for static creation methods
        let factory_methods: Vec<_> = cls.methods.iter()
            .filter(|m| {
                m.is_static()
                    && !m.return_type.is_void()
                    && !m.return_type.is_primitive()
                    && (m.name.starts_with("create")
                        || m.name.starts_with("new")
                        || m.name.starts_with("of")
                        || m.name.starts_with("from")
                        || m.name.starts_with("make")
                        || m.name.starts_with("build")
                        || m.name == "getInstance")
            })
            .collect();

        if factory_methods.len() >= 2 {
            // Find the most common return type
            let created_type = factory_methods.first().and_then(|m| {
                match &m.return_type {
                    ArgType::Object(name) => {
                        let simple = name.trim_start_matches('L').trim_end_matches(';');
                        Some(simple.rsplit('/').next().unwrap_or(simple).to_string())
                    }
                    _ => None,
                }
            });
            Some(created_type)
        } else {
            None
        }
    }

    /// Detect Adapter pattern
    fn detect_adapter(cls: &ClassData) -> Option<Option<String>> {
        // Check if implements an interface and wraps another type
        if cls.interfaces.is_empty() {
            return None;
        }

        // Look for a single non-primitive field that could be the wrapped type
        let potential_wrapped: Vec<_> = cls.instance_fields.iter()
            .filter(|f| !f.field_type.is_primitive())
            .collect();

        if potential_wrapped.len() == 1 {
            // Check for delegation methods (methods that call the wrapped field)
            let methods_count = cls.methods.iter()
                .filter(|m| !m.is_static() && m.name != "<init>" && m.name != "<clinit>")
                .count();

            if methods_count >= 2 {
                let wrapped_type = match &potential_wrapped[0].field_type {
                    ArgType::Object(name) => {
                        let simple = name.trim_start_matches('L').trim_end_matches(';');
                        Some(simple.rsplit('/').next().unwrap_or(simple).to_string())
                    }
                    _ => None,
                };
                return Some(wrapped_type);
            }
        }

        None
    }

    /// Detect Repository pattern
    fn detect_repository(cls: &ClassData) -> Option<Option<String>> {
        // Look for CRUD-like method names
        let crud_methods: Vec<_> = cls.methods.iter()
            .filter(|m| {
                let lower = m.name.to_lowercase();
                lower.contains("get")
                    || lower.contains("find")
                    || lower.contains("fetch")
                    || lower.contains("load")
                    || lower.contains("save")
                    || lower.contains("insert")
                    || lower.contains("update")
                    || lower.contains("delete")
                    || lower.contains("remove")
                    || lower.contains("create")
            })
            .collect();

        // Need at least 3 CRUD methods
        if crud_methods.len() >= 3 {
            // Try to find the entity type from return types
            let entity_type = crud_methods.iter()
                .filter_map(|m| {
                    match &m.return_type {
                        ArgType::Object(name) if !name.contains("List") && !name.contains("Optional") => {
                            let simple = name.trim_start_matches('L').trim_end_matches(';');
                            Some(simple.rsplit('/').next().unwrap_or(simple).to_string())
                        }
                        ArgType::Generic { params, .. } if !params.is_empty() => {
                            match &params[0] {
                                ArgType::Object(name) => {
                                    let simple = name.trim_start_matches('L').trim_end_matches(';');
                                    Some(simple.rsplit('/').next().unwrap_or(simple).to_string())
                                }
                                _ => None,
                            }
                        }
                        _ => None,
                    }
                })
                .next();

            return Some(entity_type);
        }

        None
    }

    /// Check if class is a ViewModel
    fn is_viewmodel(cls: &ClassData) -> bool {
        // Check superclass
        if let Some(ref super_cls) = cls.superclass {
            if super_cls.contains("ViewModel")
                || super_cls.contains("AndroidViewModel")
            {
                return true;
            }
        }

        // Check for LiveData fields and observe-like patterns
        let has_livedata = cls.instance_fields.iter().any(|f| {
            match &f.field_type {
                ArgType::Object(name) => name.contains("LiveData") || name.contains("StateFlow"),
                ArgType::Generic { base, .. } => base.contains("LiveData") || base.contains("StateFlow"),
                _ => false,
            }
        });

        has_livedata && cls.methods.len() >= 2
    }

    /// Check if class is a Comparator
    fn is_comparator(cls: &ClassData) -> bool {
        // Check interfaces
        cls.interfaces.iter().any(|iface| {
            match iface {
                ArgType::Object(name) => name.contains("Comparator") || name.contains("Comparable"),
                ArgType::Generic { base, .. } => base.contains("Comparator") || base.contains("Comparable"),
                _ => false,
            }
        })
    }

    /// Check if class is primarily a Data class
    fn is_data_class(cls: &ClassData) -> bool {
        // Data classes have many fields and few methods (mostly getters/setters)
        let field_count = cls.instance_fields.len();
        if field_count < 2 {
            return false;
        }

        let method_count = cls.methods.iter()
            .filter(|m| m.name != "<init>" && m.name != "<clinit>")
            .count();

        // Check if most methods are getters/setters
        let accessor_count = cls.methods.iter()
            .filter(|m| {
                let lower = m.name.to_lowercase();
                lower.starts_with("get")
                    || lower.starts_with("set")
                    || lower.starts_with("is")
                    || lower.starts_with("has")
            })
            .count();

        // Data class if:
        // - Many fields
        // - Most methods are accessors
        // - Or has toString, equals, hashCode (common data class methods)
        let has_data_methods = cls.methods.iter().any(|m| {
            m.name == "toString" || m.name == "equals" || m.name == "hashCode"
        });

        (accessor_count as f32 / method_count.max(1) as f32 > 0.6)
            || (field_count >= 3 && has_data_methods)
    }

    /// Check if a type matches a class type
    fn type_matches_class(arg_type: &ArgType, class_type: &str) -> bool {
        match arg_type {
            ArgType::Object(name) => {
                name.trim_start_matches('L').trim_end_matches(';') == class_type.trim_start_matches('L').trim_end_matches(';')
            }
            ArgType::Generic { base, .. } => {
                base.trim_start_matches('L').trim_end_matches(';') == class_type.trim_start_matches('L').trim_end_matches(';')
            }
            _ => false,
        }
    }
}

#[cfg(test)]
mod tests {
    use super::*;
    use dexterity_ir::{MethodData, FieldData};

    fn make_method(name: &str, is_static: bool, return_type: ArgType) -> MethodData {
        let mut m = MethodData::new(name.to_string(), 0, return_type);
        if is_static {
            m.access_flags |= 0x0008; // ACC_STATIC
        }
        m
    }

    fn make_field(name: &str, is_static: bool, field_type: ArgType) -> FieldData {
        let flags = if is_static { 0x0008 } else { 0 };
        FieldData::new(name.to_string(), flags, field_type)
    }

    #[test]
    fn test_singleton_detection() {
        let mut cls = ClassData::new("Lcom/example/MySingleton;".to_string(), 0);

        // Add private constructor
        let mut init = MethodData::new("<init>".to_string(), 0x0002, ArgType::Void);
        init.access_flags = 0x0002; // ACC_PRIVATE
        cls.methods.push(init);

        // Add static instance field
        cls.static_fields.push(make_field(
            "INSTANCE",
            true,
            ArgType::Object("Lcom/example/MySingleton;".to_string()),
        ));

        // Add getInstance method
        cls.methods.push(make_method(
            "getInstance",
            true,
            ArgType::Object("Lcom/example/MySingleton;".to_string()),
        ));

        let patterns = PatternDetector::detect(&cls);
        assert!(patterns.contains(&DetectedPattern::Singleton));
    }

    #[test]
    fn test_builder_detection() {
        let mut cls = ClassData::new("Lcom/example/UserBuilder;".to_string(), 0);

        // Add fluent setters
        cls.methods.push(make_method(
            "setName",
            false,
            ArgType::Object("Lcom/example/UserBuilder;".to_string()),
        ));
        cls.methods[0].arg_types = vec![ArgType::Object("Ljava/lang/String;".to_string())];

        cls.methods.push(make_method(
            "setAge",
            false,
            ArgType::Object("Lcom/example/UserBuilder;".to_string()),
        ));
        cls.methods[1].arg_types = vec![ArgType::Int];

        cls.methods.push(make_method(
            "withEmail",
            false,
            ArgType::Object("Lcom/example/UserBuilder;".to_string()),
        ));
        cls.methods[2].arg_types = vec![ArgType::Object("Ljava/lang/String;".to_string())];

        // Add build method
        cls.methods.push(make_method(
            "build",
            false,
            ArgType::Object("Lcom/example/User;".to_string()),
        ));

        let patterns = PatternDetector::detect(&cls);
        assert!(patterns.iter().any(|p| matches!(p, DetectedPattern::Builder { .. })));
    }

    #[test]
    fn test_data_class_detection() {
        let mut cls = ClassData::new("Lcom/example/UserData;".to_string(), 0);

        // Add fields
        cls.instance_fields.push(make_field("name", false, ArgType::Object("Ljava/lang/String;".to_string())));
        cls.instance_fields.push(make_field("age", false, ArgType::Int));
        cls.instance_fields.push(make_field("email", false, ArgType::Object("Ljava/lang/String;".to_string())));

        // Add getters/setters
        cls.methods.push(make_method("getName", false, ArgType::Object("Ljava/lang/String;".to_string())));
        cls.methods.push(make_method("setName", false, ArgType::Void));
        cls.methods.push(make_method("getAge", false, ArgType::Int));
        cls.methods.push(make_method("setAge", false, ArgType::Void));
        cls.methods.push(make_method("toString", false, ArgType::Object("Ljava/lang/String;".to_string())));

        let patterns = PatternDetector::detect(&cls);
        assert!(patterns.contains(&DetectedPattern::DataClass));
    }
}
