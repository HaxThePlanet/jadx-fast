//! Add Android Constants Pass
//!
//! JADX Clone: jadx-core/src/main/java/jadx/core/dex/visitors/prepare/AddAndroidConstants.java (45 lines)
//! Original Author: Skylot (skylot@gmail.com)
//! Clone Date: Dec 2025
//!
//! ## Purpose
//!
//! Insert Android framework resource constants (android.R.*) from the SDK resource mapping
//! into the constant storage. This allows the decompiler to replace resource ID literals
//! (e.g., 0x0101000a) with their symbolic names (e.g., android.R.attr.entries).
//!
//! ## JADX Reference
//!
//! ```java
//! // AddAndroidConstants.java:27-44
//! @Override
//! public void init(RootNode root) throws JadxException {
//!     if (!root.getArgs().isReplaceConsts()) {
//!         return;
//!     }
//!     if (root.resolveClass(R_CLS) != null) {
//!         return; // Android R class already loaded
//!     }
//!     ConstStorage constStorage = root.getConstValues();
//!     AndroidResourcesMap.getMap().forEach((resId, path) -> {
//!         int sep = path.indexOf('/');
//!         String clsName = R_INNER_CLS + path.substring(0, sep);
//!         String resName = path.substring(sep + 1);
//!         ClassInfo cls = ClassInfo.fromName(root, clsName);
//!         FieldInfo field = FieldInfo.from(root, cls, resName, ArgType.INT);
//!         constStorage.addGlobalConstField(field, resId);
//!     });
//! }
//! ```
//!
//! ## Resource Map Format
//!
//! The Android SDK resource map maps resource IDs (integers) to paths like:
//! - `attr/entries` → android.R.attr.entries
//! - `drawable/ic_menu_more` → android.R.drawable.ic_menu_more
//! - `id/text1` → android.R.id.text1

use std::collections::HashMap;

/// The Android R class path
const R_CLS: &str = "android.R";

/// Prefix for inner R classes (e.g., android.R$attr)
const R_INNER_CLS: &str = "android.R$";

/// Information about an Android resource constant
#[derive(Debug, Clone)]
pub struct AndroidResConstant {
    /// Full class name (e.g., "android.R$attr")
    pub class_name: String,
    /// Field name (e.g., "entries")
    pub field_name: String,
    /// Resource ID value
    pub res_id: i32,
}

/// Result of add android constants pass
#[derive(Debug, Default)]
pub struct AddAndroidConstantsResult {
    /// Number of constants added
    pub constants_added: usize,
    /// Whether the pass was skipped (Android R class already present)
    pub skipped: bool,
    /// Reason for skipping
    pub skip_reason: Option<String>,
}

/// Android resources map - maps resource IDs to path strings
///
/// Path format: "type/name" (e.g., "attr/entries", "drawable/ic_menu_more")
#[derive(Debug, Default)]
pub struct AndroidResourcesMap {
    /// Resource ID → path mapping
    pub entries: HashMap<i32, String>,
}

impl AndroidResourcesMap {
    /// Create an empty resource map
    pub fn new() -> Self {
        Self {
            entries: HashMap::new(),
        }
    }

    /// Load resource map from text file content
    ///
    /// Format: Each line is "resId=path" (e.g., "0x0101000a=attr/entries")
    /// JADX Reference: TextResMapFile.java
    pub fn from_text(content: &str) -> Self {
        let mut entries = HashMap::new();

        for line in content.lines() {
            let line = line.trim();
            if line.is_empty() || line.starts_with('#') {
                continue;
            }

            if let Some(eq_pos) = line.find('=') {
                let id_str = &line[..eq_pos];
                let path = &line[eq_pos + 1..];

                // Parse resource ID (handles 0x prefix and decimal)
                if let Ok(res_id) = parse_res_id(id_str.trim()) {
                    entries.insert(res_id, path.to_string());
                }
            }
        }

        Self { entries }
    }

    /// Get the resource name for an ID
    pub fn get_res_name(&self, res_id: i32) -> Option<&str> {
        self.entries.get(&res_id).map(|s| s.as_str())
    }

    /// Parse a path into (class_name, field_name)
    ///
    /// "attr/entries" → ("android.R$attr", "entries")
    pub fn parse_path(path: &str) -> Option<(String, String)> {
        let sep = path.find('/')?;
        let type_name = &path[..sep];
        let res_name = &path[sep + 1..];

        let class_name = format!("{}{}", R_INNER_CLS, type_name);
        Some((class_name, res_name.to_string()))
    }
}

/// Parse a resource ID string (hex or decimal)
fn parse_res_id(s: &str) -> Result<i32, std::num::ParseIntError> {
    if s.starts_with("0x") || s.starts_with("0X") {
        i32::from_str_radix(&s[2..], 16)
    } else {
        s.parse::<i32>()
    }
}

/// Add Android SDK resource constants to the constant storage.
///
/// JADX Reference: AddAndroidConstants.java:27-44
///
/// # Arguments
/// * `resources` - Android SDK resource map
/// * `has_r_class` - Whether android.R class is already present in the APK
/// * `replace_consts` - Whether constant replacement is enabled
///
/// # Returns
/// List of constants to add to the storage
pub fn add_android_constants(
    resources: &AndroidResourcesMap,
    has_r_class: bool,
    replace_consts: bool,
) -> (Vec<AndroidResConstant>, AddAndroidConstantsResult) {
    let mut result = AddAndroidConstantsResult::default();

    // JADX Reference: AddAndroidConstants.java:28-30
    if !replace_consts {
        result.skipped = true;
        result.skip_reason = Some("Constant replacement disabled".to_string());
        return (Vec::new(), result);
    }

    // JADX Reference: AddAndroidConstants.java:31-34
    if has_r_class {
        result.skipped = true;
        result.skip_reason = Some("Android R class already present".to_string());
        return (Vec::new(), result);
    }

    // JADX Reference: AddAndroidConstants.java:35-43
    let mut constants = Vec::new();

    for (&res_id, path) in &resources.entries {
        if let Some((class_name, field_name)) = AndroidResourcesMap::parse_path(path) {
            constants.push(AndroidResConstant {
                class_name,
                field_name,
                res_id,
            });
        }
    }

    result.constants_added = constants.len();
    (constants, result)
}

/// Check if a resource ID is from the android.* namespace
///
/// Android framework resources have IDs starting with 0x01
pub fn is_android_res_id(res_id: i32) -> bool {
    // Android framework resources: 0x01xxxxxx
    (res_id >> 24) & 0xFF == 0x01
}

/// Check if a resource ID is from the app namespace
///
/// App resources have IDs starting with 0x7f
pub fn is_app_res_id(res_id: i32) -> bool {
    // App resources: 0x7fxxxxxx
    (res_id >> 24) & 0xFF == 0x7f
}

/// Get the resource type from an ID
///
/// The type is encoded in bits 16-23
pub fn get_res_type(res_id: i32) -> u8 {
    ((res_id >> 16) & 0xFF) as u8
}

/// Get the resource entry ID from a full ID
///
/// The entry is the lower 16 bits
pub fn get_res_entry(res_id: i32) -> u16 {
    (res_id & 0xFFFF) as u16
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn test_parse_res_id() {
        assert_eq!(parse_res_id("0x0101000a").unwrap(), 0x0101000a);
        assert_eq!(parse_res_id("0X01010001").unwrap(), 0x01010001);
        assert_eq!(parse_res_id("16842754").unwrap(), 16842754);
    }

    #[test]
    fn test_parse_path() {
        let (cls, name) = AndroidResourcesMap::parse_path("attr/entries").unwrap();
        assert_eq!(cls, "android.R$attr");
        assert_eq!(name, "entries");

        let (cls, name) = AndroidResourcesMap::parse_path("drawable/ic_menu_more").unwrap();
        assert_eq!(cls, "android.R$drawable");
        assert_eq!(name, "ic_menu_more");
    }

    #[test]
    fn test_from_text() {
        let content = r#"
# Android SDK resources
0x0101000a=attr/entries
0x0101000b=attr/expandedEntries
0x7f010001=id/button1
"#;
        let map = AndroidResourcesMap::from_text(content);
        assert_eq!(map.entries.len(), 3);
        assert_eq!(map.get_res_name(0x0101000a), Some("attr/entries"));
        assert_eq!(map.get_res_name(0x0101000b), Some("attr/expandedEntries"));
    }

    #[test]
    fn test_is_android_res_id() {
        assert!(is_android_res_id(0x0101000a)); // Android SDK
        assert!(!is_android_res_id(0x7f010001)); // App resource
    }

    #[test]
    fn test_is_app_res_id() {
        assert!(is_app_res_id(0x7f010001)); // App resource
        assert!(!is_app_res_id(0x0101000a)); // Android SDK
    }

    #[test]
    fn test_get_res_type() {
        assert_eq!(get_res_type(0x01010001), 0x01); // attr type
        assert_eq!(get_res_type(0x7f020003), 0x02); // drawable type
    }

    #[test]
    fn test_add_android_constants_disabled() {
        let map = AndroidResourcesMap::new();
        let (constants, result) = add_android_constants(&map, false, false);
        assert!(constants.is_empty());
        assert!(result.skipped);
    }

    #[test]
    fn test_add_android_constants_r_present() {
        let map = AndroidResourcesMap::new();
        let (constants, result) = add_android_constants(&map, true, true);
        assert!(constants.is_empty());
        assert!(result.skipped);
    }

    #[test]
    fn test_add_android_constants() {
        let mut map = AndroidResourcesMap::new();
        map.entries.insert(0x0101000a, "attr/entries".to_string());
        map.entries.insert(0x0101000b, "attr/expandedEntries".to_string());

        let (constants, result) = add_android_constants(&map, false, true);
        assert_eq!(constants.len(), 2);
        assert_eq!(result.constants_added, 2);
        assert!(!result.skipped);
    }
}
