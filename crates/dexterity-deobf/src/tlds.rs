//! Top Level Domain (TLD) filtering for deobfuscation
//!
//! Ported from jadx-core/src/main/java/jadx/core/deobf/conditions/ExcludePackageWithTLDNames.java
//!
//! This module prevents renaming of packages that start with known TLDs like "com", "org", "net".
//! These are standard Java package prefixes and shouldn't be obfuscated.

use std::collections::HashSet;

use lazy_static::lazy_static;

use crate::conditions::{Action, DeobfCondition};
use dexterity_ir::ClassData;

/// List of all IANA top-level domains (TLDs)
/// Loaded from tlds.txt at compile time
static TLDS_TXT: &str = include_str!("tlds.txt");

lazy_static! {
    /// Set of all TLDs for O(1) lookup
    static ref TLD_SET: HashSet<&'static str> = {
        TLDS_TXT
            .lines()
            .filter(|line| !line.starts_with('#') && !line.is_empty())
            .collect()
    };
}

/// Condition that excludes packages starting with TLD names from renaming
///
/// This prevents renaming of common package prefixes like:
/// - com (com.example.app)
/// - org (org.apache.commons)
/// - net (net.minecraft)
/// - io (io.github.user)
/// - edu (edu.university.dept)
///
/// Matches JADX's ExcludePackageWithTLDNames.java
pub struct ExcludePackageWithTLDNames;

impl ExcludePackageWithTLDNames {
    pub fn new() -> Self {
        Self
    }

    /// Check if a package name is a known TLD
    pub fn is_tld(name: &str) -> bool {
        TLD_SET.contains(name)
    }

    /// Get the number of TLDs loaded
    pub fn tld_count() -> usize {
        TLD_SET.len()
    }
}

impl Default for ExcludePackageWithTLDNames {
    fn default() -> Self {
        Self::new()
    }
}

impl DeobfCondition for ExcludePackageWithTLDNames {
    fn check_package(&self, package: &str) -> Action {
        // Get the root package (first segment)
        // JADX Reference: ExcludePackageWithTLDNames.check(PackageNode) - returns FORBID_RENAME for TLD packages
        let root = package.split('/').next().unwrap_or(package);
        if TLD_SET.contains(root) {
            Action::ForbidRename
        } else {
            Action::NoAction
        }
    }

    fn check_class(&self, cls: &ClassData) -> Action {
        // Check if the class's package starts with a TLD
        let class_type = cls.class_type.trim_start_matches('L').trim_end_matches(';');
        if let Some(slash_pos) = class_type.find('/') {
            let root = &class_type[..slash_pos];
            if TLD_SET.contains(root) {
                // Package starts with TLD - don't rename the package, but class might be renamed
                return Action::NoAction;
            }
        }
        Action::NoAction
    }
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn test_tld_loading() {
        // Should have ~1452 TLDs loaded
        assert!(ExcludePackageWithTLDNames::tld_count() > 1000);
        assert!(ExcludePackageWithTLDNames::tld_count() < 2000);
    }

    #[test]
    fn test_common_tlds() {
        assert!(ExcludePackageWithTLDNames::is_tld("com"));
        assert!(ExcludePackageWithTLDNames::is_tld("org"));
        assert!(ExcludePackageWithTLDNames::is_tld("net"));
        assert!(ExcludePackageWithTLDNames::is_tld("io"));
        assert!(ExcludePackageWithTLDNames::is_tld("edu"));
        assert!(ExcludePackageWithTLDNames::is_tld("gov"));
    }

    #[test]
    fn test_non_tlds() {
        // Common package names that are NOT TLDs
        assert!(!ExcludePackageWithTLDNames::is_tld("example"));
        assert!(!ExcludePackageWithTLDNames::is_tld("kotlin"));
        assert!(!ExcludePackageWithTLDNames::is_tld("apache"));
        assert!(!ExcludePackageWithTLDNames::is_tld("github"));
        assert!(!ExcludePackageWithTLDNames::is_tld("mypackage"));

        // Some common package prefixes that ARE TLDs:
        // "android" - Google's .android gTLD
        // "java" - Oracle's .java gTLD
        assert!(ExcludePackageWithTLDNames::is_tld("android"));
        assert!(ExcludePackageWithTLDNames::is_tld("java"));
    }

    #[test]
    fn test_check_package() {
        let cond = ExcludePackageWithTLDNames::new();

        // TLD packages shouldn't be renamed
        // JADX Reference: ExcludePackageWithTLDNames - returns FORBID_RENAME for TLD roots
        assert_eq!(cond.check_package("com"), Action::ForbidRename);
        assert_eq!(cond.check_package("com/example"), Action::ForbidRename);
        assert_eq!(cond.check_package("org/apache"), Action::ForbidRename);

        // Non-TLD packages are allowed to be renamed
        assert_eq!(cond.check_package("myapp"), Action::NoAction);
        assert_eq!(cond.check_package("a"), Action::NoAction);
    }
}
