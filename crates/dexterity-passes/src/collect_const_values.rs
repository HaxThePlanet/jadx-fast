//! Collect Const Values Pass
//!
//! JADX Clone: jadx-core/src/main/java/jadx/core/dex/visitors/prepare/CollectConstValues.java (65 lines)
//! Original Author: Skylot (skylot@gmail.com)
//! Clone Date: Dec 2025
//!
//! ## Purpose
//!
//! Collects values from static final fields and stores them in a constant storage.
//! These values can then be used to replace inline constant references with field
//! references, improving code readability.
//!
//! For example, if a class has:
//! ```java
//! public static final int MAX_SIZE = 100;
//! ```
//!
//! And somewhere else in the code uses `100`, we can replace it with `ClassName.MAX_SIZE`.
//!
//! ## JADX Reference
//!
//! ```java
//! // CollectConstValues.java:27-47
//! @Override
//! public boolean visit(ClassNode cls) throws JadxException {
//!     RootNode root = cls.root();
//!     if (!root.getArgs().isReplaceConsts()) {
//!         return true;
//!     }
//!     if (cls.getFields().isEmpty()) {
//!         return true;
//!     }
//!     ConstStorage constStorage = root.getConstValues();
//!     for (FieldNode fld : cls.getFields()) {
//!         try {
//!             Object value = getFieldConstValue(fld);
//!             if (value != null) {
//!                 constStorage.addConstField(fld, value, fld.getAccessFlags().isPublic());
//!             }
//!         } catch (Exception e) {
//!             cls.addWarnComment("Failed to process value of field: " + fld, e);
//!         }
//!     }
//!     return true;
//! }
//! ```
//!
//! ## Field Value Detection
//!
//! A field value is collected only if:
//! 1. Field is `static final`
//! 2. Field has a CONSTANT_VALUE attribute (compile-time constant)
//! 3. Field is NOT used anywhere (already inlined by compiler)

use std::collections::HashMap;

/// Information about a constant field
#[derive(Debug, Clone)]
pub struct ConstFieldInfo {
    /// Class containing the field
    pub class_name: String,
    /// Field name
    pub field_name: String,
    /// Field type descriptor
    pub type_descriptor: String,
    /// Constant value
    pub value: ConstValue,
    /// Whether the field is public
    pub is_public: bool,
}

/// Constant value types
#[derive(Debug, Clone, PartialEq)]
pub enum ConstValue {
    /// Integer constant (byte, short, int)
    Int(i32),
    /// Long constant
    Long(i64),
    /// Float constant
    Float(f32),
    /// Double constant
    Double(f64),
    /// Boolean constant
    Boolean(bool),
    /// Char constant
    Char(char),
    /// String constant
    String(String),
    /// Class constant (type descriptor)
    Class(String),
    /// Null constant
    Null,
}

impl ConstValue {
    /// Check if this value matches an integer literal
    pub fn matches_int(&self, value: i32) -> bool {
        matches!(self, ConstValue::Int(v) if *v == value)
    }

    /// Check if this value matches a long literal
    pub fn matches_long(&self, value: i64) -> bool {
        matches!(self, ConstValue::Long(v) if *v == value)
    }

    /// Check if this value matches a string literal
    pub fn matches_string(&self, value: &str) -> bool {
        matches!(self, ConstValue::String(v) if v == value)
    }
}

/// Storage for constant values
/// JADX Reference: ConstStorage.java
#[derive(Debug, Default)]
pub struct ConstStorage {
    /// Map from value hash to field info
    /// For fast lookup when replacing literals
    int_consts: HashMap<i32, Vec<ConstFieldInfo>>,
    long_consts: HashMap<i64, Vec<ConstFieldInfo>>,
    string_consts: HashMap<String, Vec<ConstFieldInfo>>,
    /// All const fields (for iteration)
    all_fields: Vec<ConstFieldInfo>,
    /// Global const fields (Android R.* etc.)
    global_fields: Vec<ConstFieldInfo>,
}

impl ConstStorage {
    /// Create empty storage
    pub fn new() -> Self {
        Self::default()
    }

    /// Add a constant field
    ///
    /// JADX Reference: ConstStorage.addConstField()
    pub fn add_const_field(&mut self, field: ConstFieldInfo) {
        // Index by value for fast lookup
        match &field.value {
            ConstValue::Int(v) => {
                self.int_consts.entry(*v).or_default().push(field.clone());
            }
            ConstValue::Long(v) => {
                self.long_consts.entry(*v).or_default().push(field.clone());
            }
            ConstValue::String(v) => {
                self.string_consts.entry(v.clone()).or_default().push(field.clone());
            }
            _ => {}
        }
        self.all_fields.push(field);
    }

    /// Add a global constant field (e.g., android.R.*)
    ///
    /// JADX Reference: ConstStorage.addGlobalConstField()
    pub fn add_global_const_field(&mut self, field: ConstFieldInfo) {
        match &field.value {
            ConstValue::Int(v) => {
                self.int_consts.entry(*v).or_default().push(field.clone());
            }
            ConstValue::Long(v) => {
                self.long_consts.entry(*v).or_default().push(field.clone());
            }
            ConstValue::String(v) => {
                self.string_consts.entry(v.clone()).or_default().push(field.clone());
            }
            _ => {}
        }
        self.global_fields.push(field);
    }

    /// Find a constant field by integer value
    pub fn find_by_int(&self, value: i32) -> Option<&ConstFieldInfo> {
        self.int_consts.get(&value).and_then(|v| v.first())
    }

    /// Find a constant field by long value
    pub fn find_by_long(&self, value: i64) -> Option<&ConstFieldInfo> {
        self.long_consts.get(&value).and_then(|v| v.first())
    }

    /// Find a constant field by string value
    pub fn find_by_string(&self, value: &str) -> Option<&ConstFieldInfo> {
        self.string_consts.get(value).and_then(|v| v.first())
    }

    /// Get all constant fields
    pub fn all_fields(&self) -> &[ConstFieldInfo] {
        &self.all_fields
    }

    /// Get all global constant fields
    pub fn global_fields(&self) -> &[ConstFieldInfo] {
        &self.global_fields
    }
}

/// Result of collect const values pass
#[derive(Debug, Default)]
pub struct CollectConstValuesResult {
    /// Number of constant values collected
    pub values_collected: usize,
    /// Number of fields skipped (not static final)
    pub fields_skipped_not_static_final: usize,
    /// Number of fields skipped (no constant value)
    pub fields_skipped_no_value: usize,
    /// Number of fields skipped (still in use)
    pub fields_skipped_in_use: usize,
    /// Warnings encountered
    pub warnings: Vec<String>,
}

/// Access flags for checking static final
#[derive(Debug, Clone, Copy)]
pub struct FieldAccessFlags(pub u32);

impl FieldAccessFlags {
    const STATIC: u32 = 0x0008;
    const FINAL: u32 = 0x0010;
    const PUBLIC: u32 = 0x0001;

    pub fn is_static(&self) -> bool {
        self.0 & Self::STATIC != 0
    }

    pub fn is_final(&self) -> bool {
        self.0 & Self::FINAL != 0
    }

    pub fn is_public(&self) -> bool {
        self.0 & Self::PUBLIC != 0
    }

    pub fn is_static_final(&self) -> bool {
        self.is_static() && self.is_final()
    }
}

/// Field information for const value collection
#[derive(Debug, Clone)]
pub struct FieldNodeInfo {
    /// Class name
    pub class_name: String,
    /// Field name
    pub field_name: String,
    /// Type descriptor
    pub type_descriptor: String,
    /// Access flags
    pub access_flags: FieldAccessFlags,
    /// Constant value (from ConstantValue attribute)
    pub constant_value: Option<ConstValue>,
    /// Number of places this field is used
    pub use_count: usize,
}

/// Get the constant value from a field if applicable.
///
/// JADX Reference: CollectConstValues.java:49-63
///
/// Returns Some(ConstValue) if:
/// - Field is static and final
/// - Field has a ConstantValue attribute
/// - Field is not used anywhere (already inlined by compiler)
pub fn get_field_const_value(field: &FieldNodeInfo) -> Option<ConstValue> {
    // JADX Reference: CollectConstValues.java:50-53
    if !field.access_flags.is_static_final() {
        return None;
    }

    // JADX Reference: CollectConstValues.java:54-57
    let const_val = field.constant_value.as_ref()?;
    if matches!(const_val, ConstValue::Null) {
        return None;
    }

    // JADX Reference: CollectConstValues.java:58-61
    // Field still used somewhere - don't collect (wasn't inlined by compiler)
    if field.use_count > 0 {
        return None;
    }

    Some(const_val.clone())
}

/// Collect constant values from a class's fields.
///
/// JADX Reference: CollectConstValues.java:27-47
pub fn collect_const_values(
    fields: &[FieldNodeInfo],
    storage: &mut ConstStorage,
    replace_consts: bool,
) -> CollectConstValuesResult {
    let mut result = CollectConstValuesResult::default();

    // JADX Reference: CollectConstValues.java:29-31
    if !replace_consts {
        return result;
    }

    // JADX Reference: CollectConstValues.java:32-34
    if fields.is_empty() {
        return result;
    }

    // JADX Reference: CollectConstValues.java:36-45
    for field in fields {
        // Check static final
        if !field.access_flags.is_static_final() {
            result.fields_skipped_not_static_final += 1;
            continue;
        }

        // Try to get constant value
        match get_field_const_value(field) {
            Some(value) => {
                let field_info = ConstFieldInfo {
                    class_name: field.class_name.clone(),
                    field_name: field.field_name.clone(),
                    type_descriptor: field.type_descriptor.clone(),
                    value,
                    is_public: field.access_flags.is_public(),
                };
                storage.add_const_field(field_info);
                result.values_collected += 1;
            }
            None => {
                if field.constant_value.is_none() {
                    result.fields_skipped_no_value += 1;
                } else {
                    result.fields_skipped_in_use += 1;
                }
            }
        }
    }

    result
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn test_const_value_matches() {
        let val = ConstValue::Int(42);
        assert!(val.matches_int(42));
        assert!(!val.matches_int(43));

        let val = ConstValue::String("hello".to_string());
        assert!(val.matches_string("hello"));
        assert!(!val.matches_string("world"));
    }

    #[test]
    fn test_field_access_flags() {
        let flags = FieldAccessFlags(0x0019); // public static final
        assert!(flags.is_public());
        assert!(flags.is_static());
        assert!(flags.is_final());
        assert!(flags.is_static_final());

        let flags = FieldAccessFlags(0x0001); // just public
        assert!(!flags.is_static_final());
    }

    #[test]
    fn test_get_field_const_value() {
        let field = FieldNodeInfo {
            class_name: "Test".to_string(),
            field_name: "MAX_SIZE".to_string(),
            type_descriptor: "I".to_string(),
            access_flags: FieldAccessFlags(0x0019), // public static final
            constant_value: Some(ConstValue::Int(100)),
            use_count: 0,
        };

        let value = get_field_const_value(&field);
        assert_eq!(value, Some(ConstValue::Int(100)));
    }

    #[test]
    fn test_get_field_const_value_in_use() {
        let field = FieldNodeInfo {
            class_name: "Test".to_string(),
            field_name: "MAX_SIZE".to_string(),
            type_descriptor: "I".to_string(),
            access_flags: FieldAccessFlags(0x0019),
            constant_value: Some(ConstValue::Int(100)),
            use_count: 1, // Still in use
        };

        let value = get_field_const_value(&field);
        assert!(value.is_none());
    }

    #[test]
    fn test_const_storage() {
        let mut storage = ConstStorage::new();

        storage.add_const_field(ConstFieldInfo {
            class_name: "Test".to_string(),
            field_name: "MAX_SIZE".to_string(),
            type_descriptor: "I".to_string(),
            value: ConstValue::Int(100),
            is_public: true,
        });

        let found = storage.find_by_int(100);
        assert!(found.is_some());
        assert_eq!(found.unwrap().field_name, "MAX_SIZE");

        let not_found = storage.find_by_int(999);
        assert!(not_found.is_none());
    }

    #[test]
    fn test_collect_const_values() {
        let fields = vec![
            FieldNodeInfo {
                class_name: "Test".to_string(),
                field_name: "MAX_SIZE".to_string(),
                type_descriptor: "I".to_string(),
                access_flags: FieldAccessFlags(0x0019),
                constant_value: Some(ConstValue::Int(100)),
                use_count: 0,
            },
            FieldNodeInfo {
                class_name: "Test".to_string(),
                field_name: "name".to_string(),
                type_descriptor: "Ljava/lang/String;".to_string(),
                access_flags: FieldAccessFlags(0x0001), // not static final
                constant_value: None,
                use_count: 1,
            },
        ];

        let mut storage = ConstStorage::new();
        let result = collect_const_values(&fields, &mut storage, true);

        assert_eq!(result.values_collected, 1);
        assert_eq!(result.fields_skipped_not_static_final, 1);
        assert!(storage.find_by_int(100).is_some());
    }
}
