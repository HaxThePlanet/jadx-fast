//! Type-Based Naming Hints
//!
//! Generates naming hints based on type information:
//! - Collection types (Map, List, Set) -> suffix hints
//! - Android types (Handler, Adapter, Listener) -> suffix hints
//! - Generic type parameter extraction for element hints

use dexterity_ir::ArgType;
use lazy_static::lazy_static;
use std::collections::HashMap;

/// Generates naming hints based on type information
pub struct TypeHintsEngine {
    /// Type -> suffix mappings
    type_suffixes: HashMap<TypePattern, &'static str>,
}

/// Type matching pattern
#[derive(Debug, Clone, Hash, Eq, PartialEq)]
pub enum TypePattern {
    /// Exact class match (e.g., "java/util/HashMap")
    Exact(String),
    /// Class name suffix match (e.g., "*List", "*Map")
    Suffix(String),
    /// Package prefix match (e.g., "android/widget/*")
    Prefix(String),
}

/// Hints derived from type analysis
#[derive(Debug, Clone, Default)]
pub struct TypeHints {
    /// Suggested prefix for the name
    pub prefix: Option<String>,
    /// Suggested suffix for the name
    pub suffix: Option<String>,
    /// Element type hint (from generic parameters)
    pub element_hint: Option<String>,
    /// Whether this type suggests a collection
    pub is_collection: bool,
    /// Whether this type is typically nullable
    pub typically_nullable: bool,
}

impl TypeHintsEngine {
    /// Create engine with default mappings
    pub fn new() -> Self {
        let mut engine = Self {
            type_suffixes: HashMap::new(),
        };
        engine.add_default_mappings();
        engine
    }

    /// Add default type -> suffix mappings
    fn add_default_mappings(&mut self) {
        // ============================================================
        // COLLECTION TYPES
        // ============================================================

        // Lists
        self.add_suffix_mapping("java/util/List", "List");
        self.add_suffix_mapping("java/util/ArrayList", "List");
        self.add_suffix_mapping("java/util/LinkedList", "List");
        self.add_suffix_mapping("java/util/Vector", "List");
        self.add_suffix_mapping("java/util/Stack", "Stack");
        self.add_suffix_mapping("kotlin/collections/List", "List");
        self.add_suffix_mapping("kotlin/collections/MutableList", "List");

        // Maps
        self.add_suffix_mapping("java/util/Map", "Map");
        self.add_suffix_mapping("java/util/HashMap", "Map");
        self.add_suffix_mapping("java/util/LinkedHashMap", "Map");
        self.add_suffix_mapping("java/util/TreeMap", "Map");
        self.add_suffix_mapping("java/util/ConcurrentHashMap", "Map");
        self.add_suffix_mapping("java/util/WeakHashMap", "Map");
        self.add_suffix_mapping("android/util/SparseArray", "Map");
        self.add_suffix_mapping("android/util/ArrayMap", "Map");
        self.add_suffix_mapping("androidx/collection/ArrayMap", "Map");
        self.add_suffix_mapping("kotlin/collections/Map", "Map");

        // Sets
        self.add_suffix_mapping("java/util/Set", "Set");
        self.add_suffix_mapping("java/util/HashSet", "Set");
        self.add_suffix_mapping("java/util/LinkedHashSet", "Set");
        self.add_suffix_mapping("java/util/TreeSet", "Set");
        self.add_suffix_mapping("kotlin/collections/Set", "Set");

        // Queues
        self.add_suffix_mapping("java/util/Queue", "Queue");
        self.add_suffix_mapping("java/util/Deque", "Queue");
        self.add_suffix_mapping("java/util/ArrayDeque", "Queue");
        self.add_suffix_mapping("java/util/PriorityQueue", "Queue");
        self.add_suffix_mapping("java/util/concurrent/BlockingQueue", "Queue");

        // ============================================================
        // ANDROID TYPES
        // ============================================================

        // Handlers and Callbacks
        self.add_suffix_pattern(TypePattern::Suffix("Handler".into()), "Handler");
        self.add_suffix_pattern(TypePattern::Suffix("Listener".into()), "Listener");
        self.add_suffix_pattern(TypePattern::Suffix("Callback".into()), "Callback");
        self.add_suffix_pattern(TypePattern::Suffix("Observer".into()), "Observer");

        // Adapters
        self.add_suffix_pattern(TypePattern::Suffix("Adapter".into()), "Adapter");
        self.add_suffix_mapping("android/widget/ArrayAdapter", "Adapter");
        self.add_suffix_mapping("android/widget/BaseAdapter", "Adapter");
        self.add_suffix_mapping("androidx/recyclerview/widget/RecyclerView$Adapter", "Adapter");

        // Android Components
        self.add_suffix_mapping("android/content/Intent", "Intent");
        self.add_suffix_mapping("android/os/Bundle", "Bundle");
        self.add_suffix_mapping("android/os/Handler", "Handler");
        self.add_suffix_mapping("android/os/Message", "Message");
        self.add_suffix_mapping("android/content/Context", "Context");
        self.add_suffix_mapping("android/app/Activity", "Activity");
        self.add_suffix_mapping("android/content/SharedPreferences", "Prefs");

        // Views
        self.add_suffix_pattern(TypePattern::Prefix("android/widget/".into()), "View");
        self.add_suffix_pattern(TypePattern::Prefix("android/view/".into()), "View");
        self.add_suffix_pattern(TypePattern::Prefix("androidx/appcompat/widget/".into()), "View");

        // ============================================================
        // THREADING TYPES
        // ============================================================

        self.add_suffix_mapping("java/lang/Thread", "Thread");
        self.add_suffix_mapping("java/lang/Runnable", "Runnable");
        self.add_suffix_mapping("java/util/concurrent/Executor", "Executor");
        self.add_suffix_mapping("java/util/concurrent/ExecutorService", "Executor");
        self.add_suffix_mapping("java/util/concurrent/Future", "Future");
        self.add_suffix_mapping("java/util/concurrent/CompletableFuture", "Future");
        self.add_suffix_mapping("java/util/concurrent/Callable", "Callable");
        self.add_suffix_mapping("kotlinx/coroutines/Job", "Job");
        self.add_suffix_mapping("kotlinx/coroutines/Deferred", "Deferred");

        // ============================================================
        // STREAM AND BUILDER TYPES
        // ============================================================

        self.add_suffix_pattern(TypePattern::Suffix("Builder".into()), "Builder");
        self.add_suffix_pattern(TypePattern::Suffix("Stream".into()), "Stream");
        self.add_suffix_pattern(TypePattern::Suffix("Iterator".into()), "Iterator");
        self.add_suffix_pattern(TypePattern::Suffix("Factory".into()), "Factory");
        self.add_suffix_pattern(TypePattern::Suffix("Provider".into()), "Provider");

        // IO Streams
        self.add_suffix_mapping("java/io/InputStream", "InputStream");
        self.add_suffix_mapping("java/io/OutputStream", "OutputStream");
        self.add_suffix_mapping("java/io/Reader", "Reader");
        self.add_suffix_mapping("java/io/Writer", "Writer");
        self.add_suffix_mapping("java/io/BufferedReader", "Reader");
        self.add_suffix_mapping("java/io/BufferedWriter", "Writer");

        // ============================================================
        // NETWORKING TYPES
        // ============================================================

        self.add_suffix_mapping("java/net/URL", "Url");
        self.add_suffix_mapping("java/net/URI", "Uri");
        self.add_suffix_mapping("android/net/Uri", "Uri");
        self.add_suffix_mapping("java/net/Socket", "Socket");
        self.add_suffix_mapping("java/net/HttpURLConnection", "Connection");
        self.add_suffix_mapping("okhttp3/OkHttpClient", "Client");
        self.add_suffix_mapping("okhttp3/Request", "Request");
        self.add_suffix_mapping("okhttp3/Response", "Response");
        self.add_suffix_mapping("okhttp3/Call", "Call");
        self.add_suffix_mapping("retrofit2/Retrofit", "Retrofit");
    }

    /// Add an exact type -> suffix mapping
    fn add_suffix_mapping(&mut self, class_name: &str, suffix: &'static str) {
        self.type_suffixes.insert(TypePattern::Exact(class_name.to_string()), suffix);
    }

    /// Add a pattern-based suffix mapping
    fn add_suffix_pattern(&mut self, pattern: TypePattern, suffix: &'static str) {
        self.type_suffixes.insert(pattern, suffix);
    }

    /// Get naming hints for a type
    pub fn get_hints(&self, arg_type: &ArgType) -> TypeHints {
        let mut hints = TypeHints::default();

        // Extract the class name from the type
        let class_name = match arg_type {
            ArgType::Object(name) => name.trim_start_matches('L').trim_end_matches(';'),
            ArgType::Array { element, .. } => {
                hints.is_collection = true;
                // Get element type hint
                hints.element_hint = self.extract_element_name(element);
                hints.suffix = Some("Array".to_string());
                return hints;
            }
            ArgType::Generic { base, params } => {
                // Extract element hint from generic parameters
                if !params.is_empty() {
                    hints.element_hint = self.extract_best_element_name(params);
                }
                base.trim_start_matches('L').trim_end_matches(';')
            }
            _ => return hints, // Primitives don't get type hints
        };

        // Check for exact match
        if let Some(suffix) = self.type_suffixes.get(&TypePattern::Exact(class_name.to_string())) {
            hints.suffix = Some((*suffix).to_string());
            hints.is_collection = self.is_collection_type(class_name);
            return hints;
        }

        // Check for suffix match
        let simple_name = class_name.rsplit('/').next().unwrap_or(class_name);
        for (pattern, suffix) in &self.type_suffixes {
            match pattern {
                TypePattern::Suffix(s) if simple_name.ends_with(s.as_str()) => {
                    hints.suffix = Some((*suffix).to_string());
                    return hints;
                }
                TypePattern::Prefix(p) if class_name.starts_with(p.as_str()) => {
                    hints.suffix = Some((*suffix).to_string());
                    return hints;
                }
                _ => {}
            }
        }

        // No hint found, try to extract something from the class name itself
        if simple_name.len() > 2 {
            // Use the simple class name as a potential suffix
            hints.suffix = Some(simple_name.to_string());
        }

        hints
    }

    /// Check if a type is a collection type
    fn is_collection_type(&self, class_name: &str) -> bool {
        class_name.contains("List")
            || class_name.contains("Map")
            || class_name.contains("Set")
            || class_name.contains("Queue")
            || class_name.contains("Collection")
            || class_name.contains("Array")
    }

    /// Extract a readable name from an element type
    fn extract_element_name(&self, element: &ArgType) -> Option<String> {
        match element {
            ArgType::Object(name) => {
                let simple = name.trim_start_matches('L').trim_end_matches(';');
                let class_name = simple.rsplit('/').next().unwrap_or(simple);
                // Remove common prefixes/suffixes
                Some(self.simplify_class_name(class_name))
            }
            ArgType::Generic { base, .. } => {
                let simple = base.trim_start_matches('L').trim_end_matches(';');
                let class_name = simple.rsplit('/').next().unwrap_or(simple);
                Some(self.simplify_class_name(class_name))
            }
            ArgType::Int => Some("Int".to_string()),
            ArgType::Long => Some("Long".to_string()),
            ArgType::Float => Some("Float".to_string()),
            ArgType::Double => Some("Double".to_string()),
            ArgType::Boolean => Some("Bool".to_string()),
            ArgType::Byte => Some("Byte".to_string()),
            ArgType::Char => Some("Char".to_string()),
            ArgType::Short => Some("Short".to_string()),
            _ => None,
        }
    }

    /// Extract the best element name from generic parameters
    /// For Map<K, V>, prefer V (the value type)
    fn extract_best_element_name(&self, params: &[ArgType]) -> Option<String> {
        // For maps (2 params), take the second (value) type
        if params.len() == 2 {
            return self.extract_element_name(&params[1]);
        }
        // For lists/sets (1 param), take the first
        if !params.is_empty() {
            return self.extract_element_name(&params[0]);
        }
        None
    }

    /// Simplify a class name for use in naming
    fn simplify_class_name(&self, name: &str) -> String {
        // Remove common wrapper patterns
        let simplified = name
            .trim_end_matches("Impl")
            .trim_end_matches("Data")
            .trim_end_matches("Info")
            .trim_end_matches("Entity")
            .trim_end_matches("DTO")
            .trim_end_matches("VO");

        // Handle inner class names
        if let Some(inner) = simplified.rsplit('$').next() {
            // Skip anonymous class numbers
            if inner.chars().all(|c| c.is_ascii_digit()) {
                return simplified.split('$').next().unwrap_or(simplified).to_string();
            }
            return inner.to_string();
        }

        simplified.to_string()
    }

    /// Generate a field name from type hints
    pub fn generate_field_name(&self, arg_type: &ArgType) -> Option<String> {
        let hints = self.get_hints(arg_type);

        if let Some(suffix) = hints.suffix {
            let prefix = if let Some(element) = hints.element_hint {
                // userList, productMap, etc.
                to_lower_camel(&element)
            } else {
                // Default prefixes based on suffix
                match suffix.as_str() {
                    "List" | "Array" => "item".to_string(),
                    "Map" => "data".to_string(),
                    "Set" => "value".to_string(),
                    "Handler" => "main".to_string(),
                    "Listener" => "event".to_string(),
                    "Callback" => "result".to_string(),
                    "Thread" | "Executor" => "worker".to_string(),
                    "Future" | "Deferred" => "pending".to_string(),
                    _ => "temp".to_string(),
                }
            };

            Some(format!("{}{}", prefix, suffix))
        } else {
            None
        }
    }
}

impl Default for TypeHintsEngine {
    fn default() -> Self {
        Self::new()
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

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn test_list_type_hints() {
        let engine = TypeHintsEngine::new();

        let list_type = ArgType::Object("Ljava/util/ArrayList;".to_string());
        let hints = engine.get_hints(&list_type);
        assert_eq!(hints.suffix, Some("List".to_string()));
        assert!(hints.is_collection);
    }

    #[test]
    fn test_map_type_hints() {
        let engine = TypeHintsEngine::new();

        let map_type = ArgType::Object("Ljava/util/HashMap;".to_string());
        let hints = engine.get_hints(&map_type);
        assert_eq!(hints.suffix, Some("Map".to_string()));
    }

    #[test]
    fn test_handler_type_hints() {
        let engine = TypeHintsEngine::new();

        let handler_type = ArgType::Object("Landroid/os/Handler;".to_string());
        let hints = engine.get_hints(&handler_type);
        assert_eq!(hints.suffix, Some("Handler".to_string()));
    }

    #[test]
    fn test_generic_element_extraction() {
        let engine = TypeHintsEngine::new();

        let generic_list = ArgType::Generic {
            base: "Ljava/util/List;".to_string(),
            params: vec![ArgType::Object("Lcom/example/User;".to_string())],
        };
        let hints = engine.get_hints(&generic_list);
        assert_eq!(hints.suffix, Some("List".to_string()));
        assert_eq!(hints.element_hint, Some("User".to_string()));
    }

    #[test]
    fn test_suffix_pattern_matching() {
        let engine = TypeHintsEngine::new();

        // Custom listener type
        let listener_type = ArgType::Object("Lcom/example/MyCustomListener;".to_string());
        let hints = engine.get_hints(&listener_type);
        assert_eq!(hints.suffix, Some("Listener".to_string()));

        // Custom builder type
        let builder_type = ArgType::Object("Lcom/example/ConfigBuilder;".to_string());
        let hints = engine.get_hints(&builder_type);
        assert_eq!(hints.suffix, Some("Builder".to_string()));
    }

    #[test]
    fn test_field_name_generation() {
        let engine = TypeHintsEngine::new();

        // List<User> -> userList
        let user_list = ArgType::Generic {
            base: "Ljava/util/List;".to_string(),
            params: vec![ArgType::Object("Lcom/example/User;".to_string())],
        };
        let name = engine.generate_field_name(&user_list);
        assert_eq!(name, Some("userList".to_string()));

        // Map<String, Product> -> productMap
        let product_map = ArgType::Generic {
            base: "Ljava/util/Map;".to_string(),
            params: vec![
                ArgType::Object("Ljava/lang/String;".to_string()),
                ArgType::Object("Lcom/example/Product;".to_string()),
            ],
        };
        let name = engine.generate_field_name(&product_map);
        assert_eq!(name, Some("productMap".to_string()));
    }
}
