//! Alias providers for deobfuscation
//!
//! JADX Reference: jadx-core/src/main/java/jadx/core/deobf/DeobfAliasProvider.java
//! Cloned from JADX's DeobfAliasProvider class for exact parity.
//!
//! This module provides the default JADX-style alias generation.

use dexterity_ir::{ArgType, ClassData, FieldData, MethodData};
use crate::name_mapper::NameMapper;
use std::sync::atomic::{AtomicU32, Ordering};

/// Trait for generating alias names
///
/// JADX Reference: jadx-api/src/main/java/jadx/api/deobf/IAliasProvider.java
/// Interface for alias providers that can be plugged into the deobfuscator.
pub trait AliasProvider: Send + Sync {
    /// Generate alias for a package
    ///
    /// JADX: String forPackage(PackageNode pkg)
    fn for_package(&self, name: &str) -> String;

    /// Generate alias for a class
    ///
    /// JADX: String forClass(ClassNode cls)
    fn for_class(&self, cls: &ClassData) -> String;

    /// Generate alias for a field
    ///
    /// JADX: String forField(FieldNode fld)
    fn for_field(&self, field: &FieldData) -> String;

    /// Generate alias for a method
    ///
    /// JADX: String forMethod(MethodNode mth)
    /// Note: JADX checks mth.contains(AType.METHOD_OVERRIDE) internally
    fn for_method(&self, method: &MethodData, is_override: bool) -> String;
}

/// Default JADX-style alias provider
///
/// JADX Reference: jadx-core/src/main/java/jadx/core/deobf/DeobfAliasProvider.java
/// Cloned from JADX's DeobfAliasProvider class exactly.
///
/// Generates names in JADX format:
/// - Packages: p001Name (3-digit padded index)
/// - Classes: AbstractActivityC0001Name (4-digit padded index + prefix)
/// - Fields: f0Name (no padding)
/// - Methods: m0Name or mo0Name (for overrides, no padding)
pub struct DeobfAliasProvider {
    /// JADX: private int pkgIndex = 0;
    pkg_index: AtomicU32,
    /// JADX: private int clsIndex = 0;
    cls_index: AtomicU32,
    /// JADX: private int fldIndex = 0;
    fld_index: AtomicU32,
    /// JADX: private int mthIndex = 0;
    mth_index: AtomicU32,
    /// JADX: private int maxLength;
    max_length: usize,
}

impl DeobfAliasProvider {
    /// Create a new alias provider with specified max name length
    ///
    /// JADX Reference: DeobfAliasProvider.init(RootNode) lines 23-25
    /// ```java
    /// public void init(RootNode root) {
    ///     this.maxLength = root.getArgs().getDeobfuscationMaxLength();
    /// }
    /// ```
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
    ///
    /// JADX Reference: DeobfAliasProvider.initIndexes() lines 27-33
    /// ```java
    /// public void initIndexes(int pkg, int cls, int fld, int mth) {
    ///     pkgIndex = pkg;
    ///     clsIndex = cls;
    ///     fldIndex = fld;
    ///     mthIndex = mth;
    /// }
    /// ```
    ///
    /// This is called after loading a .jobf preset file to continue
    /// numbering from where the previous deobfuscation left off.
    pub fn init_indexes(&self, pkg: u32, cls: u32, fld: u32, mth: u32) {
        self.pkg_index.store(pkg, Ordering::SeqCst);
        self.cls_index.store(cls, Ordering::SeqCst);
        self.fld_index.store(fld, Ordering::SeqCst);
        self.mth_index.store(mth, Ordering::SeqCst);
    }

    /// Get current index values (for saving state)
    pub fn get_indexes(&self) -> (u32, u32, u32, u32) {
        (
            self.pkg_index.load(Ordering::SeqCst),
            self.cls_index.load(Ordering::SeqCst),
            self.fld_index.load(Ordering::SeqCst),
            self.mth_index.load(Ordering::SeqCst),
        )
    }

    /// Prepare name part for inclusion in alias
    ///
    /// JADX Reference: DeobfAliasProvider.prepareNamePart() lines 57-62
    /// ```java
    /// private String prepareNamePart(String name) {
    ///     if (name.length() > maxLength) {
    ///         return 'x' + Integer.toHexString(name.hashCode());
    ///     }
    ///     return NameMapper.removeInvalidCharsMiddle(name);
    /// }
    /// ```
    fn prepare_name_part(&self, name: &str) -> String {
        if name.len() > self.max_length {
            // JADX: return 'x' + Integer.toHexString(name.hashCode());
            format!("x{:x}", Self::java_hash_code(name))
        } else {
            // JADX: return NameMapper.removeInvalidCharsMiddle(name);
            NameMapper::remove_invalid_chars_middle(name)
        }
    }

    /// Calculate Java String.hashCode() compatible hash
    ///
    /// JADX uses Integer.toHexString(name.hashCode()) for long names.
    /// Java's String.hashCode(): h = h * 31 + char
    fn java_hash_code(s: &str) -> u32 {
        let mut h: i32 = 0;
        for c in s.chars() {
            h = h.wrapping_mul(31).wrapping_add(c as i32);
        }
        h as u32
    }

    /// Generate a prefix for a class based on its properties
    ///
    /// JADX Reference: DeobfAliasProvider.makeClsPrefix() lines 68-80
    /// ```java
    /// private String makeClsPrefix(ClassNode cls) {
    ///     if (cls.isEnum()) { return "Enum"; }
    ///     StringBuilder result = new StringBuilder();
    ///     if (cls.getAccessFlags().isInterface()) { result.append("Interface"); }
    ///     else if (cls.getAccessFlags().isAbstract()) { result.append("Abstract"); }
    ///     result.append(getBaseName(cls));
    ///     return result.toString();
    /// }
    /// ```
    fn make_cls_prefix(&self, cls: &ClassData) -> String {
        // JADX: if (cls.isEnum()) { return "Enum"; }
        if cls.is_enum() {
            return "Enum".to_string();
        }

        let mut result = String::new();

        // JADX: if (cls.getAccessFlags().isInterface()) { result.append("Interface"); }
        // JADX: else if (cls.getAccessFlags().isAbstract()) { result.append("Abstract"); }
        if cls.is_interface() {
            result.push_str("Interface");
        } else if cls.is_abstract() {
            result.push_str("Abstract");
        }

        // JADX: result.append(getBaseName(cls));
        result.push_str(&Self::get_base_name(cls));
        result
    }

    /// Get a meaningful base name from superclass or interfaces
    ///
    /// JADX Reference: DeobfAliasProvider.getBaseName() lines 85-115
    /// This processes superclasses and interfaces to find meaningful parent names.
    ///
    /// NOTE: For full JADX parity with recursive class resolution, use
    /// `get_base_name_with_resolver()` which can walk the class hierarchy.
    fn get_base_name(cls: &ClassData) -> String {
        // Check superclass
        if let Some(ref super_cls) = cls.superclass {
            let super_name = super_cls.trim_start_matches('L').trim_end_matches(';');

            // JADX: if (superClsName.startsWith("android.app.") || superClsName.startsWith("android.os."))
            // Android framework classes like Activity, Fragment, AsyncTask
            if super_name.starts_with("android/app/") || super_name.starts_with("android/os/") {
                return Self::get_cls_name(super_name);
            }
        }

        // Check interfaces
        // JADX: for (ArgType interfaceType : cls.getInterfaces())
        for iface in &cls.interfaces {
            if let Some(base_name) = Self::check_interface_for_base_name(iface) {
                return base_name;
            }
        }

        String::new()
    }

    /// Check if an interface provides a meaningful base name
    ///
    /// JADX Reference: Part of DeobfAliasProvider.getBaseName() interface loop
    fn check_interface_for_base_name(iface: &ArgType) -> Option<String> {
        // Extract class name from ArgType (could be Object or Generic)
        let iface_str = match iface {
            ArgType::Object(name) => name.as_str(),
            ArgType::Generic { base, .. } => base.as_str(),
            _ => return None,
        };
        let iface_name = iface_str.trim_start_matches('L').trim_end_matches(';');

        // JADX: if (name.equals("java.lang.Runnable")) { return "Runnable"; }
        if iface_name == "java/lang/Runnable" {
            return Some("Runnable".to_string());
        }
        // JADX: if (name.startsWith("java.util.concurrent.") || ...)
        if iface_name.starts_with("java/util/concurrent/")
            || iface_name.starts_with("android/view/")
            || iface_name.starts_with("android/content/")
        {
            return Some(Self::get_cls_name(iface_name));
        }
        None
    }

    /// Check if a superclass name is a known framework class
    ///
    /// JADX Reference: Part of DeobfAliasProvider.getBaseName() superclass check
    fn is_framework_superclass(super_name: &str) -> bool {
        super_name.starts_with("android/app/")
            || super_name.starts_with("android/os/")
            || super_name.starts_with("androidx/fragment/")
            || super_name.starts_with("androidx/appcompat/")
    }
}

/// Get a meaningful base name with recursive class resolution
///
/// JADX Reference: DeobfAliasProvider.getBaseName() lines 85-115
/// Cloned from JADX's getBaseName method with FULL recursive resolution.
///
/// ```java
/// // JADX algorithm (lines 86-113)
/// private static String getBaseName(ClassNode cls) {
///     ClassNode currentCls = cls;
///     while (currentCls != null) {
///         ArgType superCls = currentCls.getSuperClass();
///         if (superCls != null) {
///             String superClsName = superCls.getObject();
///             if (superClsName.startsWith("android.app.") || superClsName.startsWith("android.os.")) {
///                 return getClsName(superClsName);
///             }
///         }
///         for (ArgType interfaceType : cls.getInterfaces()) {
///             // ... check interfaces ...
///         }
///         if (superCls == null) { break; }
///         currentCls = cls.root().resolveClass(superCls); // RECURSIVE RESOLUTION
///     }
///     return "";
/// }
/// ```
///
/// # Arguments
/// * `cls` - The class to find base name for
/// * `resolver` - Function to resolve class types to ClassData
///
/// # Returns
/// The meaningful base name (e.g., "Activity", "Fragment", "Runnable") or empty string
pub fn get_base_name_with_resolver<F>(cls: &ClassData, resolver: F) -> String
where
    F: Fn(&str) -> Option<&ClassData>,
{
    let mut current_cls = Some(cls);
    let mut visited = std::collections::HashSet::new();

    while let Some(current) = current_cls {
        // Prevent infinite loops
        if !visited.insert(&current.class_type as &str) {
            break;
        }

        // Check superclass
        if let Some(ref super_cls) = current.superclass {
            let super_name = super_cls.trim_start_matches('L').trim_end_matches(';');

            // JADX: android.app.* -> Activity, Fragment, etc.
            // JADX: android.os.* -> AsyncTask, etc.
            if DeobfAliasProvider::is_framework_superclass(super_name) {
                return get_cls_name(super_name);
            }
        }

        // Check interfaces (use the ORIGINAL cls, not current)
        // JADX: Note interfaces are checked from the original class each iteration
        for iface in &cls.interfaces {
            if let Some(base_name) = DeobfAliasProvider::check_interface_for_base_name(iface) {
                return base_name;
            }
        }

        // Try to resolve and continue up the hierarchy
        // JADX: currentCls = cls.root().resolveClass(superCls);
        current_cls = current.superclass.as_ref().and_then(|sc| resolver(sc));
    }

    String::new()
}

/// Extract class name from full path, removing inner class markers
///
/// JADX Reference: DeobfAliasProvider.getClsName() lines 117-121
/// Public version for use with recursive resolution.
fn get_cls_name(full_name: &str) -> String {
    // Get class name after last / (or . in JADX's dot-notation)
    let name = full_name.rsplit('/').next().unwrap_or(full_name);
    // JADX: StringUtils.removeChar(clsName, '$')
    name.replace('$', "")
}

impl DeobfAliasProvider {

    /// Extract class name from full path, removing inner class markers
    ///
    /// JADX Reference: DeobfAliasProvider.getClsName() lines 117-121
    /// ```java
    /// private static String getClsName(String name) {
    ///     int pgkEnd = name.lastIndexOf('.');
    ///     String clsName = name.substring(pgkEnd + 1);
    ///     return StringUtils.removeChar(clsName, '$');
    /// }
    /// ```
    fn get_cls_name(full_name: &str) -> String {
        // Get class name after last / (or . in JADX's dot-notation)
        let name = full_name.rsplit('/').next().unwrap_or(full_name);
        // JADX: StringUtils.removeChar(clsName, '$')
        name.replace('$', "")
    }
}

impl AliasProvider for DeobfAliasProvider {
    /// Generate package alias
    ///
    /// JADX Reference: DeobfAliasProvider.forPackage() lines 35-38
    /// ```java
    /// public String forPackage(PackageNode pkg) {
    ///     return String.format("p%03d%s", pkgIndex++, prepareNamePart(pkg.getPkgInfo().getName()));
    /// }
    /// ```
    fn for_package(&self, name: &str) -> String {
        let idx = self.pkg_index.fetch_add(1, Ordering::SeqCst);
        let name_part = self.prepare_name_part(name);
        // JADX: String.format("p%03d%s", ...)
        format!("p{:03}{}", idx, name_part)
    }

    /// Generate class alias
    ///
    /// JADX Reference: DeobfAliasProvider.forClass() lines 40-44
    /// ```java
    /// public String forClass(ClassNode cls) {
    ///     String prefix = makeClsPrefix(cls);
    ///     return String.format("%sC%04d%s", prefix, clsIndex++, prepareNamePart(cls.getName()));
    /// }
    /// ```
    fn for_class(&self, cls: &ClassData) -> String {
        let idx = self.cls_index.fetch_add(1, Ordering::SeqCst);
        let prefix = self.make_cls_prefix(cls);
        let name_part = self.prepare_name_part(cls.simple_name());
        // JADX: String.format("%sC%04d%s", ...)
        format!("{}C{:04}{}", prefix, idx, name_part)
    }

    /// Generate field alias
    ///
    /// JADX Reference: DeobfAliasProvider.forField() lines 46-49
    /// ```java
    /// public String forField(FieldNode fld) {
    ///     return String.format("f%d%s", fldIndex++, prepareNamePart(fld.getName()));
    /// }
    /// ```
    fn for_field(&self, field: &FieldData) -> String {
        let idx = self.fld_index.fetch_add(1, Ordering::SeqCst);
        let name_part = self.prepare_name_part(&field.name);
        // JADX: String.format("f%d%s", ...) - no padding for fields
        format!("f{}{}", idx, name_part)
    }

    /// Generate method alias
    ///
    /// JADX Reference: DeobfAliasProvider.forMethod() lines 51-55
    /// ```java
    /// public String forMethod(MethodNode mth) {
    ///     String prefix = mth.contains(AType.METHOD_OVERRIDE) ? "mo" : "m";
    ///     return String.format("%s%d%s", prefix, mthIndex++, prepareNamePart(mth.getName()));
    /// }
    /// ```
    fn for_method(&self, method: &MethodData, is_override: bool) -> String {
        let idx = self.mth_index.fetch_add(1, Ordering::SeqCst);
        // JADX: mth.contains(AType.METHOD_OVERRIDE) ? "mo" : "m"
        let prefix = if is_override { "mo" } else { "m" };
        let name_part = self.prepare_name_part(&method.name);
        // JADX: String.format("%s%d%s", ...) - no padding for methods
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
