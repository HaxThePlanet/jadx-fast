//! Deobfuscation conditions
//!
//! Ported from jadx-core/src/main/java/jadx/core/deobf/conditions/
//!
//! JADX Reference: jadx-core/src/main/java/jadx/api/deobf/IDeobfCondition.java
//! JADX Reference: jadx-core/src/main/java/jadx/api/deobf/impl/CombineDeobfConditions.java
//! JADX Reference: jadx-core/src/main/java/jadx/core/deobf/conditions/JadxRenameConditions.java

use std::collections::HashSet;
use dexterity_ir::{ClassData, FieldData, MethodData};
use crate::name_mapper::NameMapper;

/// Rename flags that control deobfuscation behavior
#[derive(Debug, Clone, Copy, PartialEq, Eq, Hash)]
pub enum RenameFlag {
    /// Rename for case-insensitive filesystem safety
    Case,
    /// Rename invalid Java identifiers
    Valid,
    /// Rename non-printable characters
    Printable,
}

/// Action to take for a node
///
/// JADX Reference: jadx-core/src/main/java/jadx/api/deobf/IDeobfCondition.java:Action
/// JADX has exactly 3 states: NO_ACTION, FORCE_RENAME, FORBID_RENAME
#[derive(Debug, Clone, Copy, PartialEq, Eq)]
pub enum Action {
    /// No action needed - condition doesn't apply, continue to next
    /// JADX: NO_ACTION
    NoAction,
    /// Force rename (e.g., invalid identifier, too short)
    /// JADX: FORCE_RENAME
    ForceRename,
    /// Do not rename under any circumstances
    /// JADX: FORBID_RENAME
    ForbidRename,
}

// Backwards compatibility aliases
impl Action {
    /// Alias for ForbidRename (legacy name)
    pub const DontRename: Action = Action::ForbidRename;
    /// Alias for ForceRename (legacy soft rename)
    pub const Rename: Action = Action::ForceRename;
}

impl Action {
    /// Check if this action should trigger renaming
    /// JADX: Only FORCE_RENAME triggers renaming
    pub fn should_rename(&self) -> bool {
        matches!(self, Action::ForceRename)
    }
}

/// Trait for deobfuscation conditions
///
/// JADX Reference: jadx-core/src/main/java/jadx/api/deobf/IDeobfCondition.java
pub trait DeobfCondition: Send + Sync {
    /// Check if a package should be renamed
    fn check_package(&self, name: &str) -> Action {
        let _ = name;
        Action::NoAction
    }

    /// Check if a class should be renamed
    fn check_class(&self, cls: &ClassData) -> Action {
        let _ = cls;
        Action::NoAction
    }

    /// Check if a field should be renamed
    fn check_field(&self, field: &FieldData) -> Action {
        let _ = field;
        Action::NoAction
    }

    /// Check if a method should be renamed
    fn check_method(&self, method: &MethodData) -> Action {
        let _ = method;
        Action::NoAction
    }
}

/// Base deobfuscation condition that forbids renaming for:
/// - Nodes with DONT_RENAME flag (not applicable in our IR, but checked via alias presence)
/// - Nodes that already have an alias
/// - Constructor methods (<init>, <clinit>)
///
/// JADX Reference: jadx-core/src/main/java/jadx/core/deobf/conditions/BaseDeobfCondition.java
pub struct BaseDeobfCondition;

impl BaseDeobfCondition {
    pub fn new() -> Self {
        Self
    }
}

impl Default for BaseDeobfCondition {
    fn default() -> Self {
        Self::new()
    }
}

impl DeobfCondition for BaseDeobfCondition {
    fn check_class(&self, cls: &ClassData) -> Action {
        // JADX: if (cls.contains(AFlag.DONT_RENAME) || cls.getClassInfo().hasAlias())
        // We check if class already has an alias
        if cls.alias.is_some() {
            return Action::ForbidRename;
        }
        Action::NoAction
    }

    fn check_field(&self, field: &FieldData) -> Action {
        // JADX: if (fld.contains(AFlag.DONT_RENAME) || fld.getFieldInfo().hasAlias())
        if field.alias.is_some() {
            return Action::ForbidRename;
        }
        Action::NoAction
    }

    fn check_method(&self, method: &MethodData) -> Action {
        // JADX: if (mth.contains(AFlag.DONT_RENAME) || mth.getMethodInfo().hasAlias() || mth.isConstructor())
        if method.alias.is_some() {
            return Action::ForbidRename;
        }
        // Forbid renaming constructors
        if method.name == "<init>" || method.name == "<clinit>" {
            return Action::ForbidRename;
        }
        Action::NoAction
    }
}

/// Condition based on name length (min/max)
pub struct LengthCondition {
    min_length: usize,
    max_length: usize,
}

impl LengthCondition {
    pub fn new(min_length: usize, max_length: usize) -> Self {
        Self { min_length, max_length }
    }

    fn check_name(&self, name: &str) -> Action {
        let len = name.len();
        if len < self.min_length || len > self.max_length {
            Action::ForceRename
        } else {
            Action::NoAction
        }
    }
}

impl DeobfCondition for LengthCondition {
    fn check_package(&self, name: &str) -> Action {
        self.check_name(name)
    }

    fn check_class(&self, cls: &ClassData) -> Action {
        self.check_name(cls.simple_name())
    }

    fn check_field(&self, field: &FieldData) -> Action {
        self.check_name(&field.name)
    }

    fn check_method(&self, method: &MethodData) -> Action {
        self.check_name(&method.name)
    }
}

/// Condition based on identifier validity
pub struct ValidityCondition;

impl ValidityCondition {
    pub fn new() -> Self {
        Self
    }

    fn check_name(&self, name: &str) -> Action {
        if !NameMapper::is_valid_and_printable(name) {
            Action::ForceRename
        } else {
            Action::NoAction
        }
    }
}

impl Default for ValidityCondition {
    fn default() -> Self {
        Self::new()
    }
}

impl DeobfCondition for ValidityCondition {
    fn check_package(&self, name: &str) -> Action {
        self.check_name(name)
    }

    fn check_class(&self, cls: &ClassData) -> Action {
        self.check_name(cls.simple_name())
    }

    fn check_field(&self, field: &FieldData) -> Action {
        self.check_name(&field.name)
    }

    fn check_method(&self, method: &MethodData) -> Action {
        self.check_name(&method.name)
    }
}

/// Combined condition that applies multiple conditions
///
/// JADX Reference: jadx-core/src/main/java/jadx/api/deobf/impl/CombineDeobfConditions.java
///
/// Voting logic matches JADX exactly:
/// - Iterate through conditions IN ORDER
/// - First FORCE_RENAME -> return true (should rename)
/// - First FORBID_RENAME -> return false (don't rename)
/// - NO_ACTION -> ignore, continue to next
/// - Default (all NO_ACTION) -> return false (don't rename)
pub struct CombinedCondition {
    conditions: Vec<Box<dyn DeobfCondition>>,
}

impl CombinedCondition {
    pub fn new(conditions: Vec<Box<dyn DeobfCondition>>) -> Self {
        Self { conditions }
    }

    /// Build default JADX conditions in the exact order from JadxRenameConditions.java
    ///
    /// JADX Reference: jadx-core/src/main/java/jadx/core/deobf/conditions/JadxRenameConditions.java
    ///
    /// Order matters! JADX uses "first definitive action wins":
    /// 1. BaseDeobfCondition - checks DONT_RENAME flag, existing alias, constructor
    /// 2. DeobfWhitelist - user-configured whitelist patterns
    /// 3. ExcludePackageWithTLDNames - skip packages starting with TLDs
    /// 4. ExcludeAndroidRClass - skip Android R classes
    /// 5. AvoidClsAndPkgNamesCollision - force rename if class collides with package
    /// 6. DeobfLengthCondition - force rename if name too short/long
    pub fn default_jadx(min_length: usize, max_length: usize) -> Self {
        Self::new(vec![
            // 1. BaseDeobfCondition - forbid if already has alias or is constructor
            Box::new(BaseDeobfCondition::new()),
            // 2. DeobfWhitelist equivalent (common package names)
            Box::new(PackageWhitelistCondition::new()),
            // 3. ExcludePackageWithTLDNames
            Box::new(crate::tlds::ExcludePackageWithTLDNames::new()),
            // 4. ExcludeAndroidRClass
            Box::new(ExcludeAndroidRClass::new()),
            // 5. AvoidClsAndPkgNamesCollision - initialized empty, caller should populate
            Box::new(AvoidClsAndPkgNamesCollision::new()),
            // 6. DeobfLengthCondition - force rename if too short/long
            Box::new(LengthCondition::new(min_length, max_length)),
        ])
    }

    /// Combine actions using JADX's "first definitive action wins" logic
    ///
    /// JADX Reference: CombineDeobfConditions.combineFunc()
    /// ```java
    /// for (IDeobfCondition c : conditions) {
    ///     switch (check.apply(c)) {
    ///         case NO_ACTION: break;           // ignore, continue
    ///         case FORCE_RENAME: return true;  // first force wins
    ///         case FORBID_RENAME: return false; // first forbid wins
    ///     }
    /// }
    /// return false; // default: don't rename
    /// ```
    fn combine_actions<F>(&self, f: F) -> Action
    where
        F: Fn(&dyn DeobfCondition) -> Action,
    {
        for cond in &self.conditions {
            match f(cond.as_ref()) {
                Action::NoAction => continue,           // ignore, check next condition
                Action::ForceRename => return Action::ForceRename,  // first FORCE wins
                Action::ForbidRename => return Action::ForbidRename, // first FORBID wins
            }
        }
        // Default: don't rename (matches JADX's `return false`)
        Action::NoAction
    }
}

impl DeobfCondition for CombinedCondition {
    fn check_package(&self, name: &str) -> Action {
        self.combine_actions(|c| c.check_package(name))
    }

    fn check_class(&self, cls: &ClassData) -> Action {
        self.combine_actions(|c| c.check_class(cls))
    }

    fn check_field(&self, field: &FieldData) -> Action {
        self.combine_actions(|c| c.check_field(field))
    }

    fn check_method(&self, method: &MethodData) -> Action {
        self.combine_actions(|c| c.check_method(method))
    }
}

/// Condition based on printable characters only
pub struct PrintableCondition;

impl PrintableCondition {
    pub fn new() -> Self {
        Self
    }

    fn check_name(&self, name: &str) -> Action {
        if !NameMapper::is_all_chars_printable(name) {
            Action::ForceRename
        } else {
            Action::NoAction
        }
    }
}

impl Default for PrintableCondition {
    fn default() -> Self {
        Self::new()
    }
}

impl DeobfCondition for PrintableCondition {
    fn check_package(&self, name: &str) -> Action {
        self.check_name(name)
    }

    fn check_class(&self, cls: &ClassData) -> Action {
        self.check_name(cls.simple_name())
    }

    fn check_field(&self, field: &FieldData) -> Action {
        self.check_name(&field.name)
    }

    fn check_method(&self, method: &MethodData) -> Action {
        self.check_name(&method.name)
    }
}

/// Condition that whitelists common short package names
///
/// Prevents renaming of well-known short package prefixes like:
/// - io (io.reactivex, io.netty, etc.)
/// - rx (rx.internal, etc.)
/// - me (me.everything, etc.)
/// - tv (tv.twitch, etc.)
/// - uk (uk.co.*, etc.)
/// - de (de.greenrobot, etc.)
///
/// These are legitimate package names that should NOT be treated as obfuscated
/// even though they are shorter than the typical min_length threshold.
pub struct PackageWhitelistCondition {
    /// Set of whitelisted package name segments
    whitelist: HashSet<&'static str>,
}

impl PackageWhitelistCondition {
    pub fn new() -> Self {
        let mut whitelist = HashSet::new();
        // Common short package prefixes that are NOT obfuscated
        // Two-letter codes (often country codes or well-known libraries)
        whitelist.insert("io");    // io.reactivex, io.netty, io.grpc
        whitelist.insert("rx");    // rx.internal, rx.observers
        whitelist.insert("me");    // me.everything, me.leolin
        whitelist.insert("tv");    // tv.twitch
        whitelist.insert("uk");    // uk.co.chrisjenx
        whitelist.insert("de");    // de.greenrobot
        whitelist.insert("it");    // it.sephiroth
        whitelist.insert("jp");    // jp.wasabeef
        whitelist.insert("cn");    // cn.jpush
        whitelist.insert("co");    // co.aikar
        whitelist.insert("pl");    // pl.droidsonroids
        whitelist.insert("fr");    // fr.castorflex
        whitelist.insert("es");    // es.dmoral
        whitelist.insert("nl");    // nl.qbusict
        whitelist.insert("be");    // be.vergauwen
        whitelist.insert("ch");    // ch.acra
        whitelist.insert("at");    // at.favre
        whitelist.insert("se");    // se.emilsjolander
        whitelist.insert("no");    // no.nordicsemi
        whitelist.insert("fi");    // fi.iki
        whitelist.insert("hu");    // hu.supercluster
        whitelist.insert("cz");    // cz.msebera
        whitelist.insert("sk");    // sk.baka
        whitelist.insert("ua");    // ua.naiksoftware
        whitelist.insert("ru");    // ru.noties
        whitelist.insert("br");    // br.com.*
        whitelist.insert("in");    // in.srain
        whitelist.insert("id");    // id.zelory
        whitelist.insert("my");    // my.edu
        whitelist.insert("sg");    // sg.bigo
        whitelist.insert("au");    // au.com.*
        whitelist.insert("nz");    // nz.co.*
        whitelist.insert("za");    // za.co.*
        whitelist.insert("mx");    // mx.openpay
        whitelist.insert("ar");    // ar.com.*
        // Three-letter codes (common package starters)
        whitelist.insert("com");   // com.google, com.facebook
        whitelist.insert("org");   // org.apache, org.json
        whitelist.insert("net");   // net.sourceforge
        whitelist.insert("edu");   // edu.mit
        whitelist.insert("gov");   // gov.nist
        whitelist.insert("mil");   // mil.*
        whitelist.insert("int");   // int.*
        whitelist.insert("pro");   // pro.*
        whitelist.insert("biz");   // biz.*
        whitelist.insert("app");   // app.*
        whitelist.insert("pub");   // pub.*
        whitelist.insert("dev");   // dev.nicodemus
        whitelist.insert("xyz");   // xyz.*
        // Well-known library package names
        whitelist.insert("okio");      // okio (Square)
        whitelist.insert("okhttp3");   // okhttp3 (Square)
        whitelist.insert("grpc");      // grpc (Google)
        whitelist.insert("bolt");      // bolt (Facebook)
        whitelist.insert("gson");      // gson (Google)
        whitelist.insert("glide");     // glide (Bumptech)
        whitelist.insert("dagger");    // dagger (Google)
        whitelist.insert("kotlin");    // kotlin
        whitelist.insert("kotlinx");   // kotlinx
        whitelist.insert("java");      // java.*
        whitelist.insert("javax");     // javax.*
        whitelist.insert("junit");     // junit
        whitelist.insert("mockito");   // mockito
        whitelist.insert("apache");    // apache (within org.apache)

        Self { whitelist }
    }

    /// Check if a package segment is whitelisted
    pub fn is_whitelisted(&self, name: &str) -> bool {
        self.whitelist.contains(name)
    }
}

impl Default for PackageWhitelistCondition {
    fn default() -> Self {
        Self::new()
    }
}

impl DeobfCondition for PackageWhitelistCondition {
    fn check_package(&self, name: &str) -> Action {
        // If the package name (or any segment) is in the whitelist, don't rename
        // JADX Reference: DeobfWhitelist.check(PackageNode) - returns FORBID_RENAME for whitelisted
        if self.is_whitelisted(name) {
            Action::ForbidRename
        } else {
            Action::NoAction
        }
    }

    // Class, field, method checks return NoAction (don't affect)
}

/// Build conditions from a set of rename flags
///
/// This allows CLI flags to configure which conditions are applied.
pub fn build_conditions_from_flags(
    flags: &HashSet<RenameFlag>,
    min_length: usize,
    max_length: usize,
) -> CombinedCondition {
    let mut conditions: Vec<Box<dyn DeobfCondition>> = Vec::new();

    // If no flags specified, use default JADX behavior
    if flags.is_empty() {
        return CombinedCondition::default_jadx(min_length, max_length);
    }

    // Always add package whitelist first (to prevent false positives on common names)
    conditions.push(Box::new(PackageWhitelistCondition::new()));

    // Add conditions based on flags
    if flags.contains(&RenameFlag::Valid) {
        conditions.push(Box::new(ValidityCondition::new()));
        conditions.push(Box::new(LengthCondition::new(min_length, max_length)));
    }

    if flags.contains(&RenameFlag::Printable) {
        conditions.push(Box::new(PrintableCondition::new()));
    }

    // Note: Case flag would need filesystem context to implement properly
    // For now, it doesn't add any conditions (case sensitivity is OS-dependent)
    // In Java JADX, this is handled by checking for class name collisions
    if flags.contains(&RenameFlag::Case) {
        // Case-insensitive collision detection would need access to all class names
        // This is typically handled at a higher level in the pipeline
    }

    // If only Case flag and nothing else, still use default behavior
    if conditions.is_empty() {
        return CombinedCondition::default_jadx(min_length, max_length);
    }

    CombinedCondition::new(conditions)
}

/// Condition that excludes Android R classes from renaming
///
/// Android R classes are resource ID holders generated by AAPT. They have:
/// - Class name "R" with inner classes like R$string, R$layout, R$id
/// - No methods (except constructors and class init)
/// - Only static final int or int[] fields
///
/// Matches JADX's ExcludeAndroidRClass.java
pub struct ExcludeAndroidRClass;

impl ExcludeAndroidRClass {
    pub fn new() -> Self {
        Self
    }

    /// Check if a class is an Android R class
    fn is_r_class(cls: &ClassData) -> bool {
        // Get the class name after the package (e.g., "R$id" from "com/example/R$id")
        // Note: simple_name() returns just "id" for R$id, so we need the full class name
        let name = cls.class_type.trim_start_matches('L').trim_end_matches(';');
        let name_after_pkg = name.rsplit('/').next().unwrap_or(name);

        // Must be named "R" or be an inner class of R (e.g., "R$string")
        let is_r_or_inner = name_after_pkg == "R" || name_after_pkg.starts_with("R$");
        if !is_r_or_inner {
            return false;
        }

        // For the main R class: should have no methods and no fields
        // (all content is in inner classes)
        if name_after_pkg == "R" {
            // R class itself should be mostly empty
            // Inner classes will have the actual fields
            let has_no_fields = cls.static_fields.is_empty() && cls.instance_fields.is_empty();
            return cls.methods.is_empty() && has_no_fields;
        }

        // For inner classes (R$string, R$layout, etc.):
        // - Methods should only be constructors or clinit
        // - Fields should be static final int or int[]
        for method in &cls.methods {
            let name = &method.name;
            if name != "<init>" && name != "<clinit>" {
                return false;
            }
        }

        // Check all fields (both static and instance)
        let all_fields = cls.static_fields.iter().chain(cls.instance_fields.iter());
        for field in all_fields {
            // Check if field type is int or int[]
            let is_int = matches!(field.field_type, dexterity_ir::ArgType::Int);
            let is_int_array = matches!(
                &field.field_type,
                dexterity_ir::ArgType::Array(elem) if matches!(elem.as_ref(), dexterity_ir::ArgType::Int)
            );
            if !is_int && !is_int_array {
                return false;
            }
        }

        true
    }
}

impl Default for ExcludeAndroidRClass {
    fn default() -> Self {
        Self::new()
    }
}

impl DeobfCondition for ExcludeAndroidRClass {
    fn check_class(&self, cls: &ClassData) -> Action {
        // JADX Reference: ExcludeAndroidRClass.check(ClassNode) - returns FORBID_RENAME for R classes
        if Self::is_r_class(cls) {
            Action::ForbidRename
        } else {
            Action::NoAction
        }
    }

    // Note: Field-level R class detection is handled at the class level.
    // When a class is identified as an R class, all its fields are preserved.
    // The check_field method uses the default NoAction from the trait.
}

/// Condition that forces renaming when class name collides with package name
///
/// In Java, a class cannot have the same name as a package in the same scope.
/// For example, if there's a package "com.example.util", you can't have a
/// class named "util" in "com.example".
///
/// Matches JADX's AvoidClsAndPkgNamesCollision.java
pub struct AvoidClsAndPkgNamesCollision {
    /// Set of known package names (just the leaf segment)
    known_packages: HashSet<String>,
}

impl AvoidClsAndPkgNamesCollision {
    pub fn new() -> Self {
        Self {
            known_packages: HashSet::new(),
        }
    }

    /// Initialize with a list of all package names
    pub fn with_packages(packages: impl IntoIterator<Item = impl AsRef<str>>) -> Self {
        let mut known_packages = HashSet::new();
        for pkg in packages {
            // Store just the leaf segment of each package
            // e.g., "com/example/util" -> "util"
            let pkg_str = pkg.as_ref();
            if let Some(leaf) = pkg_str.rsplit('/').next() {
                known_packages.insert(leaf.to_string());
            }
            // Also store the full path segments
            for segment in pkg_str.split('/') {
                known_packages.insert(segment.to_string());
            }
        }
        Self { known_packages }
    }

    /// Add a package name to track
    pub fn add_package(&mut self, package: &str) {
        // Add all segments
        for segment in package.split('/') {
            self.known_packages.insert(segment.to_string());
        }
    }
}

impl Default for AvoidClsAndPkgNamesCollision {
    fn default() -> Self {
        Self::new()
    }
}

impl DeobfCondition for AvoidClsAndPkgNamesCollision {
    fn check_class(&self, cls: &ClassData) -> Action {
        // Get the simple class name and check if it matches any package name
        let simple_name = cls.simple_name();
        if self.known_packages.contains(simple_name) {
            Action::ForceRename
        } else {
            Action::NoAction
        }
    }
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn test_length_condition() {
        let cond = LengthCondition::new(3, 64);

        // Short names should be renamed
        let mut method = MethodData::new("a".to_string(), 0, dexterity_ir::ArgType::Void);
        assert_eq!(cond.check_method(&method), Action::ForceRename);

        // Normal names should not be renamed
        method.name = "onCreate".to_string();
        assert_eq!(cond.check_method(&method), Action::NoAction);
    }

    #[test]
    fn test_validity_condition() {
        let cond = ValidityCondition::new();

        // Valid name
        let mut method = MethodData::new("onCreate".to_string(), 0, dexterity_ir::ArgType::Void);
        assert_eq!(cond.check_method(&method), Action::NoAction);

        // Invalid name (starts with number)
        method.name = "123test".to_string();
        assert_eq!(cond.check_method(&method), Action::ForceRename);

        // Reserved word
        method.name = "class".to_string();
        assert_eq!(cond.check_method(&method), Action::ForceRename);
    }

    #[test]
    fn test_package_whitelist_condition() {
        let cond = PackageWhitelistCondition::new();

        // Whitelisted two-letter package names should NOT be renamed
        // JADX: FORBID_RENAME for whitelisted packages
        assert_eq!(cond.check_package("io"), Action::ForbidRename);
        assert_eq!(cond.check_package("rx"), Action::ForbidRename);
        assert_eq!(cond.check_package("me"), Action::ForbidRename);
        assert_eq!(cond.check_package("tv"), Action::ForbidRename);
        assert_eq!(cond.check_package("uk"), Action::ForbidRename);
        assert_eq!(cond.check_package("de"), Action::ForbidRename);

        // Whitelisted three-letter package names should NOT be renamed
        assert_eq!(cond.check_package("com"), Action::ForbidRename);
        assert_eq!(cond.check_package("org"), Action::ForbidRename);
        assert_eq!(cond.check_package("net"), Action::ForbidRename);

        // Whitelisted library names should NOT be renamed
        assert_eq!(cond.check_package("okio"), Action::ForbidRename);
        assert_eq!(cond.check_package("grpc"), Action::ForbidRename);
        assert_eq!(cond.check_package("kotlin"), Action::ForbidRename);

        // Non-whitelisted short names should get NoAction (allowing other conditions to rename)
        assert_eq!(cond.check_package("a"), Action::NoAction);
        assert_eq!(cond.check_package("ab"), Action::NoAction);
        assert_eq!(cond.check_package("xyz123"), Action::NoAction);
    }

    #[test]
    fn test_combined_with_whitelist() {
        let cond = CombinedCondition::default_jadx(3, 64);

        // "io" is short but whitelisted, so should NOT be renamed
        // JADX: First FORBID_RENAME wins (from PackageWhitelistCondition)
        assert_eq!(cond.check_package("io"), Action::ForbidRename);

        // "rx" is short but whitelisted
        assert_eq!(cond.check_package("rx"), Action::ForbidRename);

        // "a" is short and NOT whitelisted, so should be renamed
        // JADX: LengthCondition returns FORCE_RENAME
        assert_eq!(cond.check_package("a"), Action::ForceRename);

        // "ab" is short and NOT whitelisted
        assert_eq!(cond.check_package("ab"), Action::ForceRename);

        // "example" is long enough and valid, so should NOT be renamed
        // JADX: All conditions return NO_ACTION, default is don't rename
        assert_eq!(cond.check_package("example"), Action::NoAction);
    }

    #[test]
    fn test_exclude_android_r_class() {
        let cond = ExcludeAndroidRClass::new();

        // Create an R class (empty, named "R")
        // JADX: FORBID_RENAME for Android R classes
        let r_class = ClassData::new("Lcom/example/R;".to_string(), 0);
        assert_eq!(cond.check_class(&r_class), Action::ForbidRename);

        // Create an R$id inner class with int fields
        let mut r_id_class = ClassData::new("Lcom/example/R$id;".to_string(), 0);
        r_id_class.static_fields.push(FieldData {
            name: "button".to_string(),
            field_type: dexterity_ir::ArgType::Int,
            access_flags: 0x19, // public static final
            ..Default::default()
        });
        assert_eq!(cond.check_class(&r_id_class), Action::ForbidRename);

        // Create an R$styleable with int[] field
        let mut r_styleable = ClassData::new("Lcom/example/R$styleable;".to_string(), 0);
        r_styleable.static_fields.push(FieldData {
            name: "MyView".to_string(),
            field_type: dexterity_ir::ArgType::Array(Box::new(dexterity_ir::ArgType::Int)),
            access_flags: 0x19,
            ..Default::default()
        });
        assert_eq!(cond.check_class(&r_styleable), Action::ForbidRename);

        // Non-R class should get NoAction
        let regular_class = ClassData::new("Lcom/example/MainActivity;".to_string(), 0);
        assert_eq!(cond.check_class(&regular_class), Action::NoAction);

        // Class with wrong field types should not be detected as R
        let mut fake_r = ClassData::new("Lcom/example/R$fake;".to_string(), 0);
        fake_r.static_fields.push(FieldData {
            name: "notAnInt".to_string(),
            field_type: dexterity_ir::ArgType::Object("Ljava/lang/String;".to_string()),
            access_flags: 0x19,
            ..Default::default()
        });
        assert_eq!(cond.check_class(&fake_r), Action::NoAction);
    }

    #[test]
    fn test_avoid_cls_pkg_collision() {
        let packages = vec!["com/example/util", "com/example/data", "org/test"];
        let cond = AvoidClsAndPkgNamesCollision::with_packages(packages);

        // Class named "util" should be force renamed (collides with package)
        let util_class = ClassData::new("Lcom/other/util;".to_string(), 0);
        assert_eq!(cond.check_class(&util_class), Action::ForceRename);

        // Class named "data" should be force renamed
        let data_class = ClassData::new("Lorg/example/data;".to_string(), 0);
        assert_eq!(cond.check_class(&data_class), Action::ForceRename);

        // Class named "MainActivity" should not collide
        let main_class = ClassData::new("Lcom/example/MainActivity;".to_string(), 0);
        assert_eq!(cond.check_class(&main_class), Action::NoAction);
    }
}
