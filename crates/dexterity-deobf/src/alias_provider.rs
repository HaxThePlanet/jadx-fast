//! Alias providers for deobfuscation
//!
//! Ported from jadx-core/src/main/java/jadx/core/deobf/DeobfAliasProvider.java

use dexterity_ir::{ArgType, ClassData, FieldData, MethodData};
use crate::name_mapper::NameMapper;
use std::sync::atomic::{AtomicU32, Ordering};

/// Trait for generating alias names
pub trait AliasProvider: Send + Sync {
    /// Generate alias for a package
    fn for_package(&self, name: &str) -> String;

    /// Generate alias for a class
    fn for_class(&self, cls: &ClassData) -> String;

    /// Generate alias for a field
    fn for_field(&self, field: &FieldData) -> String;

    /// Generate alias for a method
    fn for_method(&self, method: &MethodData, is_override: bool) -> String;
}

/// Default JADX-style alias provider
///
/// Generates names like:
/// - Packages: p001Name
/// - Classes: AbstractActivityC0001Name
/// - Fields: f0Name
/// - Methods: m0Name or mo0Name (for overrides)
pub struct DeobfAliasProvider {
    pkg_index: AtomicU32,
    cls_index: AtomicU32,
    fld_index: AtomicU32,
    mth_index: AtomicU32,
    max_length: usize,
}

impl DeobfAliasProvider {
    pub fn new(max_length: usize) -> Self {
        Self {
            pkg_index: AtomicU32::new(0),
            cls_index: AtomicU32::new(0),
            fld_index: AtomicU32::new(0),
            mth_index: AtomicU32::new(0),
            max_length,
        }
    }

    /// Initialize indexes from a loaded mapping file
    pub fn init_indexes(&self, pkg: u32, cls: u32, fld: u32, mth: u32) {
        self.pkg_index.store(pkg, Ordering::SeqCst);
        self.cls_index.store(cls, Ordering::SeqCst);
        self.fld_index.store(fld, Ordering::SeqCst);
        self.mth_index.store(mth, Ordering::SeqCst);
    }

    fn prepare_name_part(&self, name: &str) -> String {
        if name.len() > self.max_length {
            // Hash long names
            format!("x{:x}", Self::hash_string(name))
        } else {
            NameMapper::remove_invalid_chars_middle(name)
        }
    }

    fn hash_string(s: &str) -> u32 {
        // Simple hash matching Java's String.hashCode()
        let mut h: i32 = 0;
        for c in s.chars() {
            h = h.wrapping_mul(31).wrapping_add(c as i32);
        }
        h as u32
    }

    /// Generate a prefix for a class based on its properties
    fn make_cls_prefix(&self, cls: &ClassData) -> String {
        let mut result = String::new();

        // Add modifier prefix
        if cls.is_enum() {
            return "Enum".to_string();
        }
        if cls.is_interface() {
            result.push_str("Interface");
        } else if cls.is_abstract() {
            result.push_str("Abstract");
        }

        // Add base class name
        result.push_str(&Self::get_base_name(cls));
        result
    }

    /// Get a meaningful base name from superclass or interfaces
    fn get_base_name(cls: &ClassData) -> String {
        // Check superclass
        if let Some(ref super_cls) = cls.superclass {
            let super_name = super_cls.trim_start_matches('L').trim_end_matches(';');

            // Android framework classes
            if super_name.starts_with("android/app/") || super_name.starts_with("android/os/") {
                return Self::get_simple_cls_name(super_name);
            }
        }

        // Check interfaces
        for iface in &cls.interfaces {
            // Extract class name from ArgType (could be Object or Generic)
            let iface_str = match iface {
                ArgType::Object(name) => name.as_str(),
                ArgType::Generic { base, .. } => base.as_str(),
                _ => continue,
            };
            let iface_name = iface_str.trim_start_matches('L').trim_end_matches(';');

            if iface_name == "java/lang/Runnable" {
                return "Runnable".to_string();
            }
            if iface_name.starts_with("java/util/concurrent/")
                || iface_name.starts_with("android/view/")
                || iface_name.starts_with("android/content/")
            {
                return Self::get_simple_cls_name(iface_name);
            }
        }

        String::new()
    }

    fn get_simple_cls_name(full_name: &str) -> String {
        let name = full_name.rsplit('/').next().unwrap_or(full_name);
        // Remove inner class markers
        name.replace('$', "")
    }
}

impl AliasProvider for DeobfAliasProvider {
    fn for_package(&self, name: &str) -> String {
        let idx = self.pkg_index.fetch_add(1, Ordering::SeqCst);
        let name_part = self.prepare_name_part(name);
        format!("p{:03}{}", idx, name_part)
    }

    fn for_class(&self, cls: &ClassData) -> String {
        let idx = self.cls_index.fetch_add(1, Ordering::SeqCst);
        let prefix = self.make_cls_prefix(cls);
        let name_part = self.prepare_name_part(cls.simple_name());
        format!("{}C{:04}{}", prefix, idx, name_part)
    }

    fn for_field(&self, field: &FieldData) -> String {
        let idx = self.fld_index.fetch_add(1, Ordering::SeqCst);
        let name_part = self.prepare_name_part(&field.name);
        format!("f{}{}", idx, name_part)
    }

    fn for_method(&self, method: &MethodData, is_override: bool) -> String {
        let idx = self.mth_index.fetch_add(1, Ordering::SeqCst);
        let prefix = if is_override { "mo" } else { "m" };
        let name_part = self.prepare_name_part(&method.name);
        format!("{}{}{}", prefix, idx, name_part)
    }
}

#[cfg(test)]
mod tests {
    use super::*;
    use dexterity_ir::ArgType;

    #[test]
    fn test_alias_provider() {
        let provider = DeobfAliasProvider::new(64);

        // Package
        assert_eq!(provider.for_package("a"), "p000a");
        assert_eq!(provider.for_package("b"), "p001b");

        // Class
        let cls = ClassData::new("La/b/C;".to_string(), 0);
        let alias = provider.for_class(&cls);
        assert!(alias.starts_with("C0000"));

        // Field
        let field = FieldData::new("x".to_string(), 0, ArgType::Int);
        assert_eq!(provider.for_field(&field), "f0x");

        // Method
        let method = MethodData::new("a".to_string(), 0, ArgType::Void);
        assert_eq!(provider.for_method(&method, false), "m0a");
        assert_eq!(provider.for_method(&method, true), "mo1a");
    }

    #[test]
    fn test_class_prefix() {
        let provider = DeobfAliasProvider::new(64);

        // Enum
        let mut cls = ClassData::new("La/b/E;".to_string(), 0x4000); // ACC_ENUM
        let alias = provider.for_class(&cls);
        assert!(alias.starts_with("EnumC"));

        // Interface
        cls = ClassData::new("La/b/I;".to_string(), 0x0200); // ACC_INTERFACE
        let alias = provider.for_class(&cls);
        assert!(alias.starts_with("InterfaceC"));

        // Abstract
        cls = ClassData::new("La/b/A;".to_string(), 0x0400); // ACC_ABSTRACT
        let alias = provider.for_class(&cls);
        assert!(alias.starts_with("AbstractC"));
    }

    #[test]
    fn test_activity_prefix() {
        let provider = DeobfAliasProvider::new(64);

        let mut cls = ClassData::new("La/b/C;".to_string(), 0);
        cls.superclass = Some("Landroid/app/Activity;".to_string());

        let alias = provider.for_class(&cls);
        assert!(alias.contains("Activity"), "Expected Activity in alias: {}", alias);
    }
}
