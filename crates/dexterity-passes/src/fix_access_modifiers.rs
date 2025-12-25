//! Fix Access Modifiers Pass
//!
//! JADX Clone: jadx-core/src/main/java/jadx/core/dex/visitors/fixaccessmodifiers/
//! - FixAccessModifiers.java (122 lines)
//! - VisibilityUtils.java (90 lines)
//! Original Author: Skylot (skylot@gmail.com)
//! Clone Date: Dec 2025
//!
//! ## Purpose
//!
//! When inner classes access private members of outer classes (or vice versa),
//! the Java compiler generates synthetic accessor methods. However, JADX removes
//! these accessors and inlines the access. For this to compile, the accessed
//! member must be at least package-private.
//!
//! This pass changes visibility modifiers to make the decompiled code compilable:
//! - private → package-private (when accessed from same package)
//! - private/package → protected (when accessed from subclass in different package)
//! - private/package/protected → public (when accessed from unrelated class in different package)
//!
//! ## JADX Reference
//!
//! ```java
//! // FixAccessModifiers.java:58-67
//! private void fixClassVisibility(ClassNode cls) {
//!     if (cls.isTopClass() && (accessFlags.isPrivate() || accessFlags.isProtected())) {
//!         changeVisibility(cls, AccessFlags.PUBLIC);
//!     }
//!     for (ClassNode useCls : cls.getUseIn()) {
//!         visibilityUtils.checkVisibility(cls, useCls, this::changeVisibility);
//!     }
//! }
//! ```

use std::collections::HashSet;

/// Access modifier flags matching Android/Java conventions
#[derive(Debug, Clone, Copy, PartialEq, Eq)]
pub struct AccessFlags(pub u32);

impl AccessFlags {
    pub const PUBLIC: u32 = 0x0001;
    pub const PRIVATE: u32 = 0x0002;
    pub const PROTECTED: u32 = 0x0004;
    pub const STATIC: u32 = 0x0008;
    pub const FINAL: u32 = 0x0010;

    /// Package-private (no flag set for visibility)
    pub const PACKAGE_PRIVATE: u32 = 0;

    pub fn is_public(&self) -> bool {
        self.0 & Self::PUBLIC != 0
    }

    pub fn is_private(&self) -> bool {
        self.0 & Self::PRIVATE != 0
    }

    pub fn is_protected(&self) -> bool {
        self.0 & Self::PROTECTED != 0
    }

    pub fn is_package_private(&self) -> bool {
        !self.is_public() && !self.is_private() && !self.is_protected()
    }

    /// Get just the visibility portion of flags
    pub fn visibility(&self) -> AccessFlags {
        AccessFlags(self.0 & (Self::PUBLIC | Self::PRIVATE | Self::PROTECTED))
    }

    /// Check if this visibility is weaker than another
    /// JADX Reference: AccessInfo.java isVisibilityWeakerThan()
    pub fn is_weaker_than(&self, other: &AccessFlags) -> bool {
        let self_level = self.visibility_level();
        let other_level = other.visibility_level();
        self_level < other_level
    }

    /// Get visibility level (higher = more visible)
    /// private=0, package=1, protected=2, public=3
    fn visibility_level(&self) -> u8 {
        if self.is_private() { 0 }
        else if self.is_package_private() { 1 }
        else if self.is_protected() { 2 }
        else { 3 } // public
    }

    /// Change visibility to new flag
    /// JADX Reference: AccessInfo.changeVisibility()
    pub fn change_visibility(&self, new_vis: u32) -> AccessFlags {
        // Clear existing visibility flags
        let cleared = self.0 & !(Self::PUBLIC | Self::PRIVATE | Self::PROTECTED);
        // Set new visibility (0 = package-private, so just OR in)
        AccessFlags(cleared | new_vis)
    }

    /// Get visibility name for comments
    pub fn visibility_name(&self) -> &'static str {
        if self.is_public() { "public" }
        else if self.is_private() { "private" }
        else if self.is_protected() { "protected" }
        else { "package-private" }
    }
}

/// Information about a class for visibility checking
#[derive(Debug, Clone)]
pub struct ClassInfo {
    /// Full class name (e.g., "com.example.Outer$Inner")
    pub full_name: String,
    /// Package name (e.g., "com.example")
    pub package: String,
    /// Top parent class (for nested classes)
    pub top_parent: String,
    /// Access flags
    pub access_flags: AccessFlags,
    /// Is this a top-level class?
    pub is_top_class: bool,
    /// Classes that use this class
    pub use_in: HashSet<String>,
    /// Methods that use this class (for inline tracking)
    pub use_in_mth: HashSet<String>,
}

/// Information about a method for visibility checking
#[derive(Debug, Clone)]
pub struct MethodInfo {
    /// Method identifier (class + signature)
    pub id: String,
    /// Declaring class
    pub declaring_class: String,
    /// Access flags
    pub access_flags: AccessFlags,
    /// Whether marked for inline
    pub is_inline: bool,
    /// Whether candidate for inline
    pub is_inline_candidate: bool,
    /// Methods that use this method
    pub use_in: HashSet<String>,
}

/// Information about a field for visibility checking
#[derive(Debug, Clone)]
pub struct FieldInfo {
    /// Field identifier
    pub id: String,
    /// Declaring class
    pub declaring_class: String,
    /// Access flags
    pub access_flags: AccessFlags,
}

/// Record of a visibility change
#[derive(Debug, Clone)]
pub struct VisibilityChange {
    /// The node that was modified
    pub node_id: String,
    /// Original visibility
    pub original: &'static str,
    /// New visibility
    pub new_visibility: &'static str,
    /// Reason for the change
    pub reason: String,
}

/// Result of fix access modifiers pass
#[derive(Debug, Default)]
pub struct FixAccessModifiersResult {
    /// Number of class visibility changes
    pub class_changes: usize,
    /// Number of method visibility changes
    pub method_changes: usize,
    /// Number of field visibility changes
    pub field_changes: usize,
    /// Detailed change log
    pub changes: Vec<VisibilityChange>,
}

/// Context for visibility checking
/// JADX Reference: VisibilityUtils.java
pub struct VisibilityContext<'a> {
    /// All class information
    pub classes: &'a std::collections::HashMap<String, ClassInfo>,
    /// Super types for each class (for protected access checks)
    pub super_types: &'a std::collections::HashMap<String, Vec<String>>,
    /// Whether to respect bytecode access modifiers (skip fixing if true)
    pub respect_bytecode_modifiers: bool,
}

impl<'a> VisibilityContext<'a> {
    /// Check if two classes are in the same package
    /// JADX Reference: VisibilityUtils.java:73-75
    fn in_same_package(&self, cls1: &str, cls2: &str) -> bool {
        let pkg1 = self.get_package(cls1);
        let pkg2 = self.get_package(cls2);
        pkg1 == pkg2
    }

    /// Check if two classes are in the same top-level class
    /// JADX Reference: VisibilityUtils.java:77-79
    fn in_same_top_class(&self, cls1: &str, cls2: &str) -> bool {
        let top1 = self.get_top_parent(cls1);
        let top2 = self.get_top_parent(cls2);
        top1 == top2
    }

    /// Check if caller extends target (for protected access)
    /// JADX Reference: VisibilityUtils.java:81-84
    fn is_super_type(&self, caller: &str, target: &str) -> bool {
        if let Some(supers) = self.super_types.get(caller) {
            supers.iter().any(|s| s == target)
        } else {
            false
        }
    }

    fn get_package<'b>(&'b self, class_name: &'b str) -> &'b str {
        if let Some(info) = self.classes.get(class_name) {
            &info.package
        } else {
            // Extract package from class name
            class_name.rfind('.').map(|i| &class_name[..i]).unwrap_or("")
        }
    }

    fn get_top_parent<'b>(&'b self, class_name: &'b str) -> &'b str {
        if let Some(info) = self.classes.get(class_name) {
            &info.top_parent
        } else {
            // For nested classes, extract top parent
            class_name.find('$').map(|i| &class_name[..i]).unwrap_or(class_name)
        }
    }
}

/// Check visibility and compute required fix.
///
/// JADX Reference: VisibilityUtils.java:20-63
///
/// Returns Some(new_visibility_flag) if a change is needed, None otherwise.
pub fn check_visibility(
    ctx: &VisibilityContext,
    target_class: &str,
    target_flags: &AccessFlags,
    caller_class: &str,
) -> Option<u32> {
    // Same class or same top-level class - no check needed
    // JADX Reference: VisibilityUtils.java:29-31
    if target_class == caller_class || ctx.in_same_top_class(target_class, caller_class) {
        return None;
    }

    if ctx.in_same_package(target_class, caller_class) {
        // Same package: private → package-private
        // JADX Reference: VisibilityUtils.java:33-38
        if target_flags.is_private() {
            return Some(AccessFlags::PACKAGE_PRIVATE);
        }
    } else {
        // Different package
        // JADX Reference: VisibilityUtils.java:39-62
        if target_flags.is_public() {
            return None;
        }

        if target_flags.is_private() || target_flags.is_package_private() {
            // Check if caller extends target's declaring class
            if ctx.is_super_type(caller_class, target_class) {
                return Some(AccessFlags::PROTECTED);
            } else {
                return Some(AccessFlags::PUBLIC);
            }
        } else if target_flags.is_protected() {
            // Protected is only accessible if caller extends the declaring class
            if !ctx.is_super_type(caller_class, target_class) {
                return Some(AccessFlags::PUBLIC);
            }
        }
    }

    None
}

/// Fix class visibility based on usage.
///
/// JADX Reference: FixAccessModifiers.java:58-92
pub fn fix_class_visibility(
    ctx: &VisibilityContext,
    class_info: &mut ClassInfo,
    result: &mut FixAccessModifiersResult,
) {
    let original_vis = class_info.access_flags.visibility_name();

    // Top-level classes with private/protected visibility must be public
    // JADX Reference: FixAccessModifiers.java:64-67
    if class_info.is_top_class {
        if class_info.access_flags.is_private() || class_info.access_flags.is_protected() {
            class_info.access_flags = class_info.access_flags.change_visibility(AccessFlags::PUBLIC);
            result.class_changes += 1;
            result.changes.push(VisibilityChange {
                node_id: class_info.full_name.clone(),
                original: original_vis,
                new_visibility: "public",
                reason: "Top-level class cannot be private/protected".to_string(),
            });
            return;
        }
    }

    // Check visibility for each class that uses this class
    // JADX Reference: FixAccessModifiers.java:69-73
    let mut max_required_vis: Option<u32> = None;
    let mut reason_class: Option<String> = None;

    for use_cls in &class_info.use_in {
        if let Some(required_vis) = check_visibility(
            ctx,
            &class_info.full_name,
            &class_info.access_flags,
            use_cls,
        ) {
            // Track the maximum visibility required
            if max_required_vis.is_none() || required_vis > max_required_vis.unwrap() {
                max_required_vis = Some(required_vis);
                reason_class = Some(use_cls.clone());
            }
        }
    }

    // Also check methods that use this class (for inline)
    // JADX Reference: FixAccessModifiers.java:75-91
    for use_mth in &class_info.use_in_mth {
        // Extract class from method ID
        if let Some(dot_pos) = use_mth.rfind('.') {
            let use_cls = &use_mth[..dot_pos];
            if let Some(required_vis) = check_visibility(
                ctx,
                &class_info.full_name,
                &class_info.access_flags,
                use_cls,
            ) {
                if max_required_vis.is_none() || required_vis > max_required_vis.unwrap() {
                    max_required_vis = Some(required_vis);
                    reason_class = Some(use_mth.clone());
                }
            }
        }
    }

    // Apply the required visibility change
    if let Some(new_vis) = max_required_vis {
        class_info.access_flags = class_info.access_flags.change_visibility(new_vis);
        result.class_changes += 1;

        let new_vis_name = match new_vis {
            AccessFlags::PUBLIC => "public",
            AccessFlags::PROTECTED => "protected",
            AccessFlags::PRIVATE => "private",
            _ => "package-private",
        };

        result.changes.push(VisibilityChange {
            node_id: class_info.full_name.clone(),
            original: original_vis,
            new_visibility: new_vis_name,
            reason: format!("Accessed from: {}", reason_class.unwrap_or_default()),
        });
    }
}

/// Fix method visibility based on overrides and usage.
///
/// JADX Reference: FixAccessModifiers.java:94-111
pub fn fix_method_visibility(
    ctx: &VisibilityContext,
    method_info: &mut MethodInfo,
    override_parent_flags: Option<&AccessFlags>,
    result: &mut FixAccessModifiersResult,
) {
    let original_vis = method_info.access_flags.visibility_name();

    // Check override constraint: visibility can't be weaker than parent
    // JADX Reference: FixAccessModifiers.java:96-104
    if let Some(parent_flags) = override_parent_flags {
        if method_info.access_flags.is_weaker_than(parent_flags) {
            let parent_vis = parent_flags.visibility().0;
            method_info.access_flags = method_info.access_flags.change_visibility(parent_vis);
            result.method_changes += 1;
            result.changes.push(VisibilityChange {
                node_id: method_info.id.clone(),
                original: original_vis,
                new_visibility: parent_flags.visibility_name(),
                reason: "Override requires at least parent visibility".to_string(),
            });
            return;
        }
    }

    // Check visibility for each method that uses this method
    // JADX Reference: FixAccessModifiers.java:106-110
    let mut max_required_vis: Option<u32> = None;
    let mut reason_mth: Option<String> = None;

    for use_mth in &method_info.use_in {
        // Extract class from method ID
        if let Some(dot_pos) = use_mth.rfind('.') {
            let use_cls = &use_mth[..dot_pos];
            if let Some(required_vis) = check_visibility(
                ctx,
                &method_info.declaring_class,
                &method_info.access_flags,
                use_cls,
            ) {
                if max_required_vis.is_none() || required_vis > max_required_vis.unwrap() {
                    max_required_vis = Some(required_vis);
                    reason_mth = Some(use_mth.clone());
                }
            }
        }
    }

    if let Some(new_vis) = max_required_vis {
        method_info.access_flags = method_info.access_flags.change_visibility(new_vis);
        result.method_changes += 1;

        let new_vis_name = match new_vis {
            AccessFlags::PUBLIC => "public",
            AccessFlags::PROTECTED => "protected",
            AccessFlags::PRIVATE => "private",
            _ => "package-private",
        };

        result.changes.push(VisibilityChange {
            node_id: method_info.id.clone(),
            original: original_vis,
            new_visibility: new_vis_name,
            reason: format!("Accessed from: {}", reason_mth.unwrap_or_default()),
        });
    }
}

/// Generate info comment for visibility change.
///
/// JADX Reference: FixAccessModifiers.java:118-119
pub fn make_visibility_comment(original: &str) -> String {
    format!("Access modifiers changed from: {}", original)
}

#[cfg(test)]
mod tests {
    use super::*;
    use std::collections::HashMap;

    #[test]
    fn test_access_flags_visibility() {
        let public = AccessFlags(AccessFlags::PUBLIC);
        assert!(public.is_public());
        assert!(!public.is_private());

        let private = AccessFlags(AccessFlags::PRIVATE);
        assert!(private.is_private());
        assert!(!private.is_public());

        let pkg = AccessFlags(0);
        assert!(pkg.is_package_private());
    }

    #[test]
    fn test_visibility_weaker_than() {
        let public = AccessFlags(AccessFlags::PUBLIC);
        let protected = AccessFlags(AccessFlags::PROTECTED);
        let private = AccessFlags(AccessFlags::PRIVATE);
        let pkg = AccessFlags(0);

        assert!(private.is_weaker_than(&pkg));
        assert!(pkg.is_weaker_than(&protected));
        assert!(protected.is_weaker_than(&public));
        assert!(!public.is_weaker_than(&protected));
    }

    #[test]
    fn test_change_visibility() {
        let flags = AccessFlags(AccessFlags::PRIVATE | AccessFlags::STATIC);
        let changed = flags.change_visibility(AccessFlags::PUBLIC);

        assert!(changed.is_public());
        assert!(!changed.is_private());
        assert!(changed.0 & AccessFlags::STATIC != 0); // static preserved
    }

    #[test]
    fn test_check_visibility_same_class() {
        let classes = HashMap::new();
        let supers = HashMap::new();
        let ctx = VisibilityContext {
            classes: &classes,
            super_types: &supers,
            respect_bytecode_modifiers: false,
        };

        let flags = AccessFlags(AccessFlags::PRIVATE);
        let result = check_visibility(&ctx, "com.example.Foo", &flags, "com.example.Foo");
        assert!(result.is_none()); // Same class, no change needed
    }

    #[test]
    fn test_check_visibility_same_package() {
        let mut classes = HashMap::new();
        classes.insert("com.example.Foo".to_string(), ClassInfo {
            full_name: "com.example.Foo".to_string(),
            package: "com.example".to_string(),
            top_parent: "com.example.Foo".to_string(),
            access_flags: AccessFlags(AccessFlags::PRIVATE),
            is_top_class: true,
            use_in: HashSet::new(),
            use_in_mth: HashSet::new(),
        });
        classes.insert("com.example.Bar".to_string(), ClassInfo {
            full_name: "com.example.Bar".to_string(),
            package: "com.example".to_string(),
            top_parent: "com.example.Bar".to_string(),
            access_flags: AccessFlags(AccessFlags::PUBLIC),
            is_top_class: true,
            use_in: HashSet::new(),
            use_in_mth: HashSet::new(),
        });

        let supers = HashMap::new();
        let ctx = VisibilityContext {
            classes: &classes,
            super_types: &supers,
            respect_bytecode_modifiers: false,
        };

        let flags = AccessFlags(AccessFlags::PRIVATE);
        let result = check_visibility(&ctx, "com.example.Foo", &flags, "com.example.Bar");

        // Same package: private → package-private
        assert_eq!(result, Some(AccessFlags::PACKAGE_PRIVATE));
    }

    #[test]
    fn test_check_visibility_different_package() {
        let mut classes = HashMap::new();
        classes.insert("com.foo.Foo".to_string(), ClassInfo {
            full_name: "com.foo.Foo".to_string(),
            package: "com.foo".to_string(),
            top_parent: "com.foo.Foo".to_string(),
            access_flags: AccessFlags(AccessFlags::PRIVATE),
            is_top_class: true,
            use_in: HashSet::new(),
            use_in_mth: HashSet::new(),
        });
        classes.insert("com.bar.Bar".to_string(), ClassInfo {
            full_name: "com.bar.Bar".to_string(),
            package: "com.bar".to_string(),
            top_parent: "com.bar.Bar".to_string(),
            access_flags: AccessFlags(AccessFlags::PUBLIC),
            is_top_class: true,
            use_in: HashSet::new(),
            use_in_mth: HashSet::new(),
        });

        let supers = HashMap::new();
        let ctx = VisibilityContext {
            classes: &classes,
            super_types: &supers,
            respect_bytecode_modifiers: false,
        };

        let flags = AccessFlags(AccessFlags::PRIVATE);
        let result = check_visibility(&ctx, "com.foo.Foo", &flags, "com.bar.Bar");

        // Different package, no inheritance: private → public
        assert_eq!(result, Some(AccessFlags::PUBLIC));
    }
}
