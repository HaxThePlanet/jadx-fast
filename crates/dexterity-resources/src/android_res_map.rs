//! Android framework resource ID to name mapping
//!
//! This module provides comprehensive mappings from Android framework resource IDs
//! to their names, based on JADX's res-map.txt (derived from AOSP).
//!
//! Resource ID format: 0xPPTTEEEE
//! - PP: Package ID (0x01 for android framework)
//! - TT: Type ID
//! - EEEE: Entry ID
//!
//! Resource types by package 0x01:
//! - 0x01010xxx: attr
//! - 0x01020xxx: id
//! - 0x01030xxx: style
//! - 0x01040xxx: string
//! - 0x01050xxx: dimen
//! - 0x01060xxx: color
//! - 0x01070xxx: array
//! - 0x01080xxx: drawable
//! - ...and more

use std::collections::HashMap;
use std::sync::LazyLock;

/// The bundled Android resource map data (JADX res-map.txt)
const RES_MAP_DATA: &str = include_str!("data/android-res-map.txt");

/// Complete Android resource map: resource ID -> "type/name"
pub static ANDROID_RES_MAP: LazyLock<HashMap<u32, String>> = LazyLock::new(|| {
    let mut map = HashMap::with_capacity(16000);
    for line in RES_MAP_DATA.lines() {
        let line = line.trim();
        if line.is_empty() || line.starts_with('#') {
            continue;
        }
        if let Some((id_str, name)) = line.split_once('=') {
            if let Ok(id) = u32::from_str_radix(id_str.trim(), 16) {
                map.insert(id, name.trim().to_string());
            }
        }
    }
    map
});

/// Android attribute map: resource ID -> "attr_name" (without type prefix)
/// For attributes (0x0101xxxx), extracts just the name part
pub static ANDROID_ATTR_MAP: LazyLock<HashMap<u32, String>> = LazyLock::new(|| {
    let mut map = HashMap::with_capacity(2000);
    for line in RES_MAP_DATA.lines() {
        let line = line.trim();
        if line.is_empty() || line.starts_with('#') {
            continue;
        }
        if let Some((id_str, name)) = line.split_once('=') {
            if let Ok(id) = u32::from_str_radix(id_str.trim(), 16) {
                // Only include attrs (0x0101xxxx) and ^attr-private
                if name.starts_with("attr/") || name.starts_with("^attr-private/") {
                    // Extract just the name part
                    if let Some(attr_name) = name.split('/').nth(1) {
                        map.insert(id, attr_name.to_string());
                    }
                }
            }
        }
    }
    map
});

/// Look up Android framework resource name by ID
/// Returns full "type/name" format like "attr/theme" or "drawable/ic_menu_add"
pub fn get_android_res_name(res_id: u32) -> Option<&'static str> {
    // Note: We return a reference to the static String which lives as long as the program
    ANDROID_RES_MAP.get(&res_id).map(|s| s.as_str())
}

/// Look up Android framework attribute name by ID
/// Returns just the name like "theme" for attr/theme
pub fn get_android_attr_name(res_id: u32) -> Option<&'static str> {
    ANDROID_ATTR_MAP.get(&res_id).map(|s| s.as_str())
}

/// Check if a resource ID is an Android framework resource (package 0x01)
pub fn is_android_framework_res(res_id: u32) -> bool {
    (res_id >> 24) == 0x01
}

/// Get the resource type from an ID (returns type index like 1 for attr, 2 for id, etc.)
pub fn get_res_type_id(res_id: u32) -> u8 {
    ((res_id >> 16) & 0xFF) as u8
}

/// Get the entry index from a resource ID
pub fn get_res_entry_id(res_id: u32) -> u16 {
    (res_id & 0xFFFF) as u16
}

/// Format a resource ID as "@android:type/name" or "@0x{id:08x}" if unknown
pub fn format_android_res_ref(res_id: u32) -> String {
    if let Some(name) = get_android_res_name(res_id) {
        format!("@android:{}", name)
    } else if is_android_framework_res(res_id) {
        format!("@android:0x{:08x}", res_id)
    } else {
        format!("@0x{:08x}", res_id)
    }
}

/// Format a resource ID as "?android:attr/name" for theme attributes
pub fn format_android_attr_ref(res_id: u32) -> String {
    if let Some(name) = get_android_attr_name(res_id) {
        format!("?android:attr/{}", name)
    } else if let Some(name) = get_android_res_name(res_id) {
        format!("?android:{}", name)
    } else if is_android_framework_res(res_id) {
        format!("?android:0x{:08x}", res_id)
    } else {
        format!("?0x{:08x}", res_id)
    }
}

/// Type indices for common Android resource types
pub mod res_types {
    pub const ATTR: u8 = 0x01;
    pub const ID: u8 = 0x02;
    pub const STYLE: u8 = 0x03;
    pub const STRING: u8 = 0x04;
    pub const DIMEN: u8 = 0x05;
    pub const COLOR: u8 = 0x06;
    pub const ARRAY: u8 = 0x07;
    pub const DRAWABLE: u8 = 0x08;
    pub const LAYOUT: u8 = 0x09;
    pub const ANIM: u8 = 0x0a;
    pub const ANIMATOR: u8 = 0x0b;
    pub const INTERPOLATOR: u8 = 0x0c;
    pub const MIPMAP: u8 = 0x0d;
    pub const INTEGER: u8 = 0x0e;
    pub const TRANSITION: u8 = 0x0f;
    pub const RAW: u8 = 0x10;
    pub const XML: u8 = 0x11;
    pub const MENU: u8 = 0x12;
    pub const FONT: u8 = 0x13;
    pub const BOOL: u8 = 0x14;
    pub const FRACTION: u8 = 0x15;
    pub const PLURALS: u8 = 0x16;
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn test_res_map_loaded() {
        // Should have loaded thousands of entries
        assert!(ANDROID_RES_MAP.len() > 10000, "Expected 10000+ entries, got {}", ANDROID_RES_MAP.len());
        assert!(ANDROID_ATTR_MAP.len() > 1500, "Expected 1500+ attrs, got {}", ANDROID_ATTR_MAP.len());
    }

    #[test]
    fn test_common_attrs() {
        // Test some well-known attributes
        assert_eq!(get_android_attr_name(0x01010000), Some("theme"));
        assert_eq!(get_android_attr_name(0x01010001), Some("label"));
        assert_eq!(get_android_attr_name(0x01010002), Some("icon"));
        assert_eq!(get_android_attr_name(0x01010003), Some("name"));
    }

    #[test]
    fn test_common_resources() {
        // Test some well-known resources
        assert_eq!(get_android_res_name(0x01010000), Some("attr/theme"));
        assert_eq!(get_android_res_name(0x01020014), Some("id/text1"));
        assert_eq!(get_android_res_name(0x01020015), Some("id/text2"));
    }

    #[test]
    fn test_format_functions() {
        assert_eq!(format_android_res_ref(0x01010000), "@android:attr/theme");
        assert_eq!(format_android_attr_ref(0x01010000), "?android:attr/theme");
    }

    #[test]
    fn test_type_extraction() {
        assert_eq!(get_res_type_id(0x01010000), 0x01); // attr
        assert_eq!(get_res_type_id(0x01020000), 0x02); // id
        assert_eq!(get_res_entry_id(0x01010123), 0x0123);
    }
}
