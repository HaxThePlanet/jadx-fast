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

/// Reason why a name was renamed
///
/// JADX Reference: jadx-core/src/main/java/jadx/core/dex/attributes/nodes/RenameReasonAttr.java
/// Tracks why each rename happened for debugging and logging purposes.
#[derive(Debug, Clone, PartialEq, Eq)]
pub enum RenameReason {
    /// Name contained invalid characters for Java identifier
    NotValid,
    /// Name contained non-printable characters
    NotPrintable,
    /// Inner class name collided with parent class name
    InnerClassCollision,
    /// Field name collided with another field in same class
    FieldNameCollision,
    /// Method signature collided with another method in same class
    MethodSignatureCollision,
    /// Class path collided due to case-insensitive filesystem
    CaseSensitiveCollision,
    /// Field name collided with root package name
    RootPackageCollision,
    /// Renamed from source file name
    SourceFileName,
    /// User-provided rename via codedata
    UserRename,
    /// Invalid class name (anonymous pattern, leading digit)
    InvalidClassName,
    /// Custom reason
    Custom(String),
}

impl RenameReason {
    /// Create a reason for not valid + not printable combination
    ///
    /// JADX Reference: RenameReasonAttr constructor with notValid/notPrintable params
    pub fn from_validity(not_valid: bool, not_printable: bool) -> Self {
        if not_valid && not_printable {
            Self::NotValid // Prioritize not valid
        } else if not_valid {
            Self::NotValid
        } else if not_printable {
            Self::NotPrintable
        } else {
            Self::Custom("unknown".to_string())
        }
    }
}

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
#[allow(non_upper_case_globals)]
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

/// Always rename condition - singleton
///
/// JADX Reference: jadx-core/src/main/java/jadx/api/deobf/impl/AlwaysRename.java
/// Returns ForceRename for all nodes, used when applying preset mappings.
pub struct AlwaysRename;

/// Predicate-based rename condition for custom rename logic
///
/// JADX Reference: jadx-core/src/main/java/jadx/api/deobf/impl/AnyRenameCondition.java
///
/// Allows users to define custom rename conditions using a closure.
/// The predicate receives the name and returns whether to rename.
pub struct PredicateCondition<F>
where
    F: Fn(&str) -> bool + Send + Sync,
{
    predicate: F,
}

impl<F> PredicateCondition<F>
where
    F: Fn(&str) -> bool + Send + Sync,
{
    /// Create a new predicate condition
    pub fn new(predicate: F) -> Self {
        Self { predicate }
    }
}

impl<F> DeobfCondition for PredicateCondition<F>
where
    F: Fn(&str) -> bool + Send + Sync,
{
    fn check_package(&self, name: &str) -> Action {
        if (self.predicate)(name) {
            Action::ForceRename
        } else {
            Action::NoAction
        }
    }

    fn check_class(&self, cls: &ClassData) -> Action {
        let name = cls.alias.as_deref().unwrap_or(cls.simple_name());
        if (self.predicate)(name) {
            Action::ForceRename
        } else {
            Action::NoAction
        }
    }

    fn check_field(&self, field: &FieldData) -> Action {
        let name = field.alias.as_deref().unwrap_or(&field.name);
        if (self.predicate)(name) {
            Action::ForceRename
        } else {
            Action::NoAction
        }
    }

    fn check_method(&self, method: &MethodData) -> Action {
        let name = method.alias.as_deref().unwrap_or(&method.name);
        if (self.predicate)(name) {
            Action::ForceRename
        } else {
            Action::NoAction
        }
    }
}

/// Create a condition that renames names matching a regex pattern
///
/// JADX Reference: Inspired by AnyRenameCondition usage patterns
pub fn rename_matching_pattern(pattern: &str) -> impl DeobfCondition {
    let regex = regex::Regex::new(pattern).expect("Invalid regex pattern");
    PredicateCondition::new(move |name: &str| regex.is_match(name))
}

/// Create a condition that renames names shorter than a given length
pub fn rename_shorter_than(min_len: usize) -> impl DeobfCondition {
    PredicateCondition::new(move |name: &str| name.len() < min_len)
}

impl AlwaysRename {
    pub fn new() -> Self {
        Self
    }
}

impl Default for AlwaysRename {
    fn default() -> Self {
        Self::new()
    }
}

impl DeobfCondition for AlwaysRename {
    fn check_package(&self, _name: &str) -> Action {
        Action::ForceRename
    }

    fn check_class(&self, _cls: &ClassData) -> Action {
        Action::ForceRename
    }

    fn check_field(&self, _field: &FieldData) -> Action {
        Action::ForceRename
    }

    fn check_method(&self, _method: &MethodData) -> Action {
        Action::ForceRename
    }
}

/// Base deobfuscation condition that forbids renaming for:
/// - Nodes with DONT_RENAME flag (modeled as nodes with existing alias)
/// - Nodes that already have an alias
/// - Constructor methods (<init>, <clinit>)
///
/// JADX Reference: jadx-core/src/main/java/jadx/core/deobf/conditions/BaseDeobfCondition.java
/// Cloned from JADX's BaseDeobfCondition class exactly.
///
/// Note on DONT_RENAME: In JADX, nodes can have an AFlag.DONT_RENAME attribute
/// that prevents renaming. In dexterity, we model this by checking if an alias
/// already exists - nodes with aliases are considered "locked" and won't be renamed.
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
    /// Check class for renaming eligibility
    ///
    /// JADX Reference: BaseDeobfCondition.check(ClassNode) lines 25-30
    /// ```java
    /// if (cls.contains(AFlag.DONT_RENAME) || cls.getClassInfo().hasAlias()) {
    ///     return Action.FORBID_RENAME;
    /// }
    /// return Action.NO_ACTION;
    /// ```
    fn check_class(&self, cls: &ClassData) -> Action {
        // JADX: cls.contains(AFlag.DONT_RENAME) || cls.getClassInfo().hasAlias()
        if cls.alias.is_some() {
            return Action::ForbidRename;
        }
        Action::NoAction
    }

    /// Check field for renaming eligibility
    ///
    /// JADX Reference: BaseDeobfCondition.check(FieldNode) lines 43-48
    /// ```java
    /// if (fld.contains(AFlag.DONT_RENAME) || fld.getFieldInfo().hasAlias()) {
    ///     return Action.FORBID_RENAME;
    /// }
    /// return Action.NO_ACTION;
    /// ```
    fn check_field(&self, field: &FieldData) -> Action {
        // JADX: fld.contains(AFlag.DONT_RENAME) || fld.getFieldInfo().hasAlias()
        if field.alias.is_some() {
            return Action::ForbidRename;
        }
        Action::NoAction
    }

    /// Check method for renaming eligibility
    ///
    /// JADX Reference: BaseDeobfCondition.check(MethodNode) lines 33-40
    /// ```java
    /// if (mth.contains(AFlag.DONT_RENAME)
    ///         || mth.getMethodInfo().hasAlias()
    ///         || mth.isConstructor()) {
    ///     return Action.FORBID_RENAME;
    /// }
    /// return Action.NO_ACTION;
    /// ```
    fn check_method(&self, method: &MethodData) -> Action {
        // JADX: mth.contains(AFlag.DONT_RENAME) || mth.getMethodInfo().hasAlias()
        if method.alias.is_some() {
            return Action::ForbidRename;
        }
        // JADX: mth.isConstructor() - forbid renaming constructors
        if method.name == "<init>" || method.name == "<clinit>" {
            return Action::ForbidRename;
        }
        Action::NoAction
    }
}

/// Condition based on name length (min/max)
///
/// JADX Reference: jadx-core/src/main/java/jadx/core/deobf/conditions/DeobfLengthCondition.java
/// Cloned from JADX's DeobfLengthCondition class exactly.
///
/// Forces renaming of identifiers that are too short or too long.
/// This is a key heuristic for detecting obfuscated names:
/// - Very short names (1-2 chars) are likely obfuscated (e.g., "a", "b")
/// - Very long names (>100 chars) may be obfuscated or corrupted
///
/// Default values from JADX (JadxArgs):
/// - minLength: 3 (names shorter than this are renamed)
/// - maxLength: 64 (names longer than this are renamed)
pub struct LengthCondition {
    min_length: usize,
    max_length: usize,
}

/// Default minimum name length for deobfuscation
///
/// JADX Reference: JadxArgs.getDeobfuscationMinLength() default
pub const DEFAULT_DEOBF_MIN_LENGTH: usize = 3;

/// Default maximum name length for deobfuscation
///
/// JADX Reference: JadxArgs.getDeobfuscationMaxLength() default
pub const DEFAULT_DEOBF_MAX_LENGTH: usize = 64;

impl LengthCondition {
    /// Create with specific min/max lengths
    ///
    /// JADX Reference: DeobfLengthCondition uses values from init(RootNode)
    pub fn new(min_length: usize, max_length: usize) -> Self {
        Self { min_length, max_length }
    }

    /// Create with JADX default values
    ///
    /// JADX Reference: JadxArgs default values (minLength=3, maxLength=64)
    pub fn default_jadx() -> Self {
        Self::new(DEFAULT_DEOBF_MIN_LENGTH, DEFAULT_DEOBF_MAX_LENGTH)
    }

    /// Initialize/update with new values
    ///
    /// JADX Reference: DeobfLengthCondition.init(RootNode) lines 17-20
    /// ```java
    /// JadxArgs args = root.getArgs();
    /// this.minLength = args.getDeobfuscationMinLength();
    /// this.maxLength = args.getDeobfuscationMaxLength();
    /// ```
    pub fn init(&mut self, min_length: usize, max_length: usize) {
        self.min_length = min_length;
        self.max_length = max_length;
    }

    /// Get current min length
    pub fn min_length(&self) -> usize {
        self.min_length
    }

    /// Get current max length
    pub fn max_length(&self) -> usize {
        self.max_length
    }

    /// Check name against length bounds
    ///
    /// JADX Reference: DeobfLengthCondition.checkName() lines 22-28
    /// ```java
    /// private Action checkName(String s) {
    ///     int len = s.length();
    ///     if (len < minLength || len > maxLength) {
    ///         return Action.FORCE_RENAME;
    ///     }
    ///     return Action.NO_ACTION;
    /// }
    /// ```
    fn check_name(&self, name: &str) -> Action {
        let len = name.len();
        if len < self.min_length || len > self.max_length {
            Action::ForceRename
        } else {
            Action::NoAction
        }
    }
}

impl Default for LengthCondition {
    fn default() -> Self {
        Self::default_jadx()
    }
}

impl DeobfCondition for LengthCondition {
    fn check_package(&self, name: &str) -> Action {
        // JADX Reference: DeobfLengthCondition.check(PackageNode)
        self.check_name(name)
    }

    fn check_class(&self, cls: &ClassData) -> Action {
        // JADX Reference: DeobfLengthCondition.check(ClassNode)
        self.check_name(cls.simple_name())
    }

    fn check_field(&self, field: &FieldData) -> Action {
        // JADX Reference: DeobfLengthCondition.check(FieldNode)
        self.check_name(&field.name)
    }

    fn check_method(&self, method: &MethodData) -> Action {
        // JADX Reference: DeobfLengthCondition.check(MethodNode)
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
    /// Create default JADX conditions in exact JADX order
    ///
    /// JADX Reference: jadx-core/src/main/java/jadx/core/deobf/conditions/JadxRenameConditions.java
    /// Order is critical - first definitive action wins!
    pub fn default_jadx(min_length: usize, max_length: usize) -> Self {
        Self::new(vec![
            // 1. BaseDeobfCondition - forbid if already has alias or is constructor
            // JADX: list.add(new BaseDeobfCondition());
            Box::new(BaseDeobfCondition::new()),
            // 2. DeobfWhitelist - JADX's exact whitelist patterns
            // JADX: list.add(new DeobfWhitelist());
            Box::new(DeobfWhitelist::default_jadx()),
            // 3. ExcludePackageWithTLDNames - don't rename packages starting with TLDs
            // JADX: list.add(new ExcludePackageWithTLDNames());
            Box::new(crate::tlds::ExcludePackageWithTLDNames::new()),
            // 4. ExcludeAndroidRClass - don't rename Android R.* classes
            // JADX: list.add(new ExcludeAndroidRClass());
            Box::new(ExcludeAndroidRClass::new()),
            // 5. AvoidClsAndPkgNamesCollision - force rename if class name = package name
            // JADX: list.add(new AvoidClsAndPkgNamesCollision());
            Box::new(AvoidClsAndPkgNamesCollision::new()),
            // 6. DeobfLengthCondition - force rename if name too short/long
            // JADX: list.add(new DeobfLengthCondition());
            Box::new(LengthCondition::new(min_length, max_length)),
        ])
    }

    /// Create conditions with dexterity extensions (includes PackageWhitelistCondition)
    ///
    /// This adds dexterity's extra package whitelist on top of JADX's defaults.
    /// Use `default_jadx()` for strict JADX parity.
    pub fn default_dexterity(min_length: usize, max_length: usize) -> Self {
        Self::new(vec![
            Box::new(BaseDeobfCondition::new()),
            Box::new(DeobfWhitelist::default_jadx()),
            Box::new(PackageWhitelistCondition::new()), // Dexterity extension
            Box::new(crate::tlds::ExcludePackageWithTLDNames::new()),
            Box::new(ExcludeAndroidRClass::new()),
            Box::new(AvoidClsAndPkgNamesCollision::new()),
            Box::new(LengthCondition::new(min_length, max_length)),
        ])
    }

    /// Build default JADX conditions initialized with package context
    ///
    /// JADX Reference: JadxRenameConditions.buildDefaultDeobfConditions()
    /// + CombineDeobfConditions.init(RootNode) which calls init() on all conditions
    ///
    /// This is the preferred way to create conditions when you have package information.
    /// AvoidClsAndPkgNamesCollision needs package names to detect collisions.
    ///
    /// ```java
    /// // JADX: AvoidClsAndPkgNamesCollision.init(RootNode) lines 15-19
    /// @Override
    /// public void init(RootNode root) {
    ///     avoidClsNames.clear();
    ///     for (PackageNode pkg : root.getPackages()) {
    ///         avoidClsNames.add(pkg.getName());
    ///     }
    /// }
    /// ```
    pub fn default_jadx_initialized(
        min_length: usize,
        max_length: usize,
        packages: impl IntoIterator<Item = impl AsRef<str>>,
    ) -> Self {
        // JADX Reference: AvoidClsAndPkgNamesCollision gets initialized with package names
        let avoid_collision = AvoidClsAndPkgNamesCollision::with_packages(packages);

        Self::new(vec![
            // 1. BaseDeobfCondition - forbid if already has alias or is constructor
            Box::new(BaseDeobfCondition::new()),
            // 2. DeobfWhitelist - JADX's exact whitelist patterns
            Box::new(DeobfWhitelist::default_jadx()),
            // 3. ExcludePackageWithTLDNames - don't rename packages starting with TLDs
            Box::new(crate::tlds::ExcludePackageWithTLDNames::new()),
            // 4. ExcludeAndroidRClass - don't rename Android R.* classes
            Box::new(ExcludeAndroidRClass::new()),
            // 5. AvoidClsAndPkgNamesCollision - INITIALIZED with package names
            // JADX: This condition's init() populates avoidClsNames from root.getPackages()
            Box::new(avoid_collision),
            // 6. DeobfLengthCondition - force rename if name too short/long
            Box::new(LengthCondition::new(min_length, max_length)),
        ])
    }

    /// Create dexterity conditions initialized with package context
    ///
    /// This is the preferred way to create dexterity conditions when you have package info.
    pub fn default_dexterity_initialized(
        min_length: usize,
        max_length: usize,
        packages: impl IntoIterator<Item = impl AsRef<str>>,
    ) -> Self {
        let avoid_collision = AvoidClsAndPkgNamesCollision::with_packages(packages);

        Self::new(vec![
            Box::new(BaseDeobfCondition::new()),
            Box::new(DeobfWhitelist::default_jadx()),
            Box::new(PackageWhitelistCondition::new()), // Dexterity extension
            Box::new(crate::tlds::ExcludePackageWithTLDNames::new()),
            Box::new(ExcludeAndroidRClass::new()),
            Box::new(avoid_collision),
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

/// Deobfuscation whitelist matching JADX's DeobfWhitelist
///
/// JADX Reference: jadx-core/src/main/java/jadx/core/deobf/conditions/DeobfWhitelist.java
///
/// Forbids renaming of packages and classes matching user-configured patterns.
/// Supports two pattern types:
/// - Package patterns ending with `.*` (e.g., "android.support.v4.*")
/// - Exact class names (e.g., "androidx.annotation.Px")
pub struct DeobfWhitelist {
    /// Package patterns (without the .* suffix, using / separators)
    packages: HashSet<String>,
    /// Exact class names (using / separators)
    classes: HashSet<String>,
}

/// JADX's default whitelist patterns
///
/// JADX Reference: jadx-core/src/main/java/jadx/core/deobf/conditions/DeobfWhitelist.java:15-21
pub const JADX_DEFAULT_WHITELIST: &[&str] = &[
    "android.support.v4.*",
    "android.support.v7.*",
    "android.support.v4.os.*",
    "android.support.annotation.Px",
    "androidx.core.os.*",
    "androidx.annotation.Px",
];

impl DeobfWhitelist {
    /// Create with JADX default patterns
    pub fn default_jadx() -> Self {
        Self::from_patterns(JADX_DEFAULT_WHITELIST.iter().copied())
    }

    /// Create from pattern list
    pub fn from_patterns<'a>(patterns: impl IntoIterator<Item = &'a str>) -> Self {
        let mut packages = HashSet::new();
        let mut classes = HashSet::new();

        for pattern in patterns {
            let pattern = pattern.trim();
            if pattern.is_empty() {
                continue;
            }
            // Convert dots to slashes for internal representation
            let converted = pattern.replace('.', "/");
            if let Some(pkg) = converted.strip_suffix("/*") {
                packages.insert(pkg.to_string());
            } else {
                classes.insert(converted);
            }
        }

        Self { packages, classes }
    }

    /// Create empty whitelist
    pub fn new() -> Self {
        Self {
            packages: HashSet::new(),
            classes: HashSet::new(),
        }
    }
}

impl Default for DeobfWhitelist {
    fn default() -> Self {
        Self::default_jadx()
    }
}

impl DeobfCondition for DeobfWhitelist {
    fn check_package(&self, name: &str) -> Action {
        // JADX Reference: DeobfWhitelist.check(PackageNode):44-48
        // Check if the full package name is in the whitelist
        if self.packages.contains(name) {
            return Action::ForbidRename;
        }
        Action::NoAction
    }

    fn check_class(&self, cls: &ClassData) -> Action {
        // JADX Reference: DeobfWhitelist.check(ClassNode):51-56
        // Check if the full class name matches a whitelisted class
        let full_name = cls.class_type.trim_start_matches('L').trim_end_matches(';');
        if self.classes.contains(full_name) {
            return Action::ForbidRename;
        }
        Action::NoAction
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
///
/// NOTE: This is a dexterity extension, not from JADX. JADX uses DeobfWhitelist instead.
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
/// JADX Reference: jadx-core/src/main/java/jadx/core/deobf/conditions/ExcludeAndroidRClass.java
/// Cloned from JADX's ExcludeAndroidRClass class exactly.
///
/// Android R classes are resource ID holders generated by AAPT. They have:
/// - Class name "R" with inner classes like R$string, R$layout, R$id
/// - No methods (except constructors and class init)
/// - Only static final int or int[] fields
///
/// IMPORTANT: JADX uses cls.getTopParentClass() to check the outermost enclosing class.
/// For inner classes like R$id or even R$id$Foo, this returns the R class.
pub struct ExcludeAndroidRClass;

impl ExcludeAndroidRClass {
    pub fn new() -> Self {
        Self
    }

    /// Get the top parent class type (outermost enclosing class)
    ///
    /// JADX Reference: ClassNode.getTopParentClass()
    /// For inner classes like "Lcom/example/R$id;" or "Lcom/example/R$id$Foo;",
    /// this returns "Lcom/example/R;".
    ///
    /// ```java
    /// // JADX: ClassNode.getTopParentClass()
    /// public ClassNode getTopParentClass() {
    ///     ClassNode parent = getParentClass();
    ///     return parent == null ? this : parent.getTopParentClass();
    /// }
    /// ```
    fn get_top_parent_class_type(class_type: &str) -> String {
        let name = class_type.trim_start_matches('L').trim_end_matches(';');
        // Get the part before first $ (the outermost class)
        if let Some(dollar_pos) = name.find('$') {
            format!("L{};", &name[..dollar_pos])
        } else {
            class_type.to_string()
        }
    }

    /// Check if a class type looks like an R class (quick check by naming)
    ///
    /// JADX Reference: ExcludeAndroidRClass.isR() - checks simple name == "R"
    /// This is used as a fast path when we only have the class type string.
    fn looks_like_r_class(class_type: &str) -> bool {
        let name = class_type.trim_start_matches('L').trim_end_matches(';');
        // Check if it ends with "/R" (top-level R class)
        name.ends_with("/R")
    }

    /// Check if a class is an Android R class
    ///
    /// JADX Reference: ExcludeAndroidRClass.isR(ClassNode) lines 19-35
    /// ```java
    /// private boolean isR(ClassNode cls) {
    ///     if (!cls.getShortName().equals("R")) {
    ///         return false;
    ///     }
    ///     // Check for: only inner classes, no methods except constructors
    ///     // Inner classes have only static final int or int[] fields
    /// }
    /// ```
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
        // JADX: R class itself is empty, inner classes hold the fields
        if name_after_pkg == "R" {
            // R class itself should be mostly empty
            // Inner classes will have the actual fields
            let has_no_fields = cls.static_fields.is_empty() && cls.instance_fields.is_empty();
            return cls.methods.is_empty() && has_no_fields;
        }

        // For inner classes (R$string, R$layout, etc.):
        // JADX: Methods should only be constructors or clinit
        // JADX: Fields should be static final int or int[]
        for method in &cls.methods {
            let name = &method.name;
            if name != "<init>" && name != "<clinit>" {
                return false;
            }
        }

        // Check all fields (both static and instance)
        // JADX Reference: ExcludeAndroidRClass.isR() field type checks
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
    /// Check if a class should be excluded from renaming (R class check)
    ///
    /// JADX Reference: ExcludeAndroidRClass.check(ClassNode) lines 12-17
    /// ```java
    /// @Override
    /// public Action check(ClassNode cls) {
    ///     if (isR(cls.getTopParentClass())) {  // <-- Gets top-level parent!
    ///         return Action.FORBID_RENAME;
    ///     }
    ///     return Action.NO_ACTION;
    /// }
    /// ```
    ///
    /// IMPORTANT: JADX uses getTopParentClass() to check the outermost enclosing class.
    /// For inner classes like R$id$Foo, this checks the R class itself.
    fn check_class(&self, cls: &ClassData) -> Action {
        // JADX Reference: ExcludeAndroidRClass.check(ClassNode) lines 12-17
        // JADX: if (isR(cls.getTopParentClass())) { return FORBID_RENAME; }

        // First, get the top parent class type (strip inner class suffixes)
        let top_parent_type = Self::get_top_parent_class_type(&cls.class_type);

        // Quick check: if the top parent looks like an R class by naming
        // JADX: cls.getTopParentClass().getShortName().equals("R")
        if Self::looks_like_r_class(&top_parent_type) {
            // The naming suggests this is an R class or its inner class
            // For inner classes, we trust the naming pattern since we can't
            // access the parent ClassData directly
            return Action::ForbidRename;
        }

        // Fall back to full structural check on the current class
        // This handles the case where we're checking the R class itself
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

/// Condition that forces renaming when class ALIAS collides with package name
///
/// JADX Reference: jadx-core/src/main/java/jadx/core/deobf/conditions/AvoidClsAndPkgNamesCollision.java
/// Cloned from JADX's AvoidClsAndPkgNamesCollision class exactly.
///
/// In Java, a class cannot have the same name as a package in the same scope.
/// For example, if there's a package "com.example.util", you can't have a
/// class named "util" in "com.example".
///
/// IMPORTANT: This checks the class ALIAS (not original name) against package names.
/// This means if a class was previously renamed to "util", it would trigger a
/// force rename to avoid collision with a "util" package.
///
/// JADX behavior:
/// - init(RootNode): Populates avoidClsNames from root.getPackages().getName()
/// - check(ClassNode): Returns FORCE_RENAME if avoidClsNames.contains(cls.getAlias())
pub struct AvoidClsAndPkgNamesCollision {
    /// Set of package names to avoid (just the leaf name, not full path)
    /// JADX: private final Set<String> avoidClsNames = new HashSet<>();
    avoid_cls_names: HashSet<String>,
}

impl AvoidClsAndPkgNamesCollision {
    /// Create a new empty condition
    ///
    /// JADX Note: In JADX, this is populated during init(RootNode).
    /// For dexterity, call with_packages() or init_from_packages() to populate.
    pub fn new() -> Self {
        Self {
            avoid_cls_names: HashSet::new(),
        }
    }

    /// Initialize from a list of packages
    ///
    /// JADX Reference: AvoidClsAndPkgNamesCollision.init(RootNode) lines 15-19
    /// ```java
    /// avoidClsNames.clear();
    /// for (PackageNode pkg : root.getPackages()) {
    ///     avoidClsNames.add(pkg.getName());
    /// }
    /// ```
    ///
    /// Note: In JADX, pkg.getName() returns just the leaf segment (e.g., "util" not "com/example/util")
    pub fn with_packages(packages: impl IntoIterator<Item = impl AsRef<str>>) -> Self {
        let mut avoid_cls_names = HashSet::new();
        for pkg in packages {
            // JADX: pkg.getName() returns just the leaf segment
            let pkg_str = pkg.as_ref();
            // Get the leaf segment (last part after /)
            let name = pkg_str.rsplit('/').next().unwrap_or(pkg_str);
            avoid_cls_names.insert(name.to_string());
        }
        Self { avoid_cls_names }
    }

    /// Initialize with full package paths and extract leaf names
    ///
    /// This is an alternative to with_packages that stores all leaf segments.
    pub fn init_from_packages(&mut self, packages: impl IntoIterator<Item = impl AsRef<str>>) {
        self.avoid_cls_names.clear();
        for pkg in packages {
            let pkg_str = pkg.as_ref();
            // Get the leaf segment (last part after /)
            // JADX: pkg.getName() returns the leaf
            let name = pkg_str.rsplit('/').next().unwrap_or(pkg_str);
            self.avoid_cls_names.insert(name.to_string());
        }
    }

    /// Add a package name to track (just the leaf segment)
    pub fn add_package(&mut self, package_name: &str) {
        self.avoid_cls_names.insert(package_name.to_string());
    }

    /// Get the number of package names being tracked
    pub fn len(&self) -> usize {
        self.avoid_cls_names.len()
    }

    /// Check if empty
    pub fn is_empty(&self) -> bool {
        self.avoid_cls_names.is_empty()
    }
}

impl Default for AvoidClsAndPkgNamesCollision {
    fn default() -> Self {
        Self::new()
    }
}

impl DeobfCondition for AvoidClsAndPkgNamesCollision {
    fn check_class(&self, cls: &ClassData) -> Action {
        // JADX Reference: AvoidClsAndPkgNamesCollision.check(ClassNode) lines 22-27
        // ```java
        // if (avoidClsNames.contains(cls.getAlias())) {
        //     return Action.FORCE_RENAME;
        // }
        // return Action.NO_ACTION;
        // ```
        //
        // IMPORTANT: JADX checks cls.getAlias(), NOT the original name.
        // This means we check the current alias (or original name if no alias set).
        let alias = cls.alias.as_deref().unwrap_or(cls.simple_name());
        if self.avoid_cls_names.contains(alias) {
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

        // "io" is a TLD, so gets FORBID_RENAME from ExcludePackageWithTLDNames
        // JADX: ExcludePackageWithTLDNames returns FORBID_RENAME for TLD roots
        assert_eq!(cond.check_package("io"), Action::ForbidRename);

        // "rx" is NOT a TLD and short (2 chars < 3), so should be renamed
        // JADX: LengthCondition returns FORCE_RENAME for short names
        assert_eq!(cond.check_package("rx"), Action::ForceRename);

        // "a" is short and NOT whitelisted, so should be renamed
        // JADX: LengthCondition returns FORCE_RENAME
        assert_eq!(cond.check_package("a"), Action::ForceRename);

        // "ab" is short and NOT whitelisted
        assert_eq!(cond.check_package("ab"), Action::ForceRename);

        // "example" is long enough and valid, so should NOT be renamed
        // JADX: All conditions return NO_ACTION, default is don't rename
        assert_eq!(cond.check_package("example"), Action::NoAction);

        // Test JADX DeobfWhitelist packages (android.support.*)
        // These should get ForbidRename from DeobfWhitelist
        assert_eq!(cond.check_package("android/support/v4"), Action::ForbidRename);
        assert_eq!(cond.check_package("androidx/core/os"), Action::ForbidRename);
    }

    #[test]
    fn test_combined_dexterity_extension() {
        // default_dexterity includes PackageWhitelistCondition with "io", "rx", etc.
        let cond = CombinedCondition::default_dexterity(3, 64);

        // "io" is whitelisted in PackageWhitelistCondition
        assert_eq!(cond.check_package("io"), Action::ForbidRename);

        // "rx" is whitelisted in PackageWhitelistCondition
        assert_eq!(cond.check_package("rx"), Action::ForbidRename);

        // "kotlin" is whitelisted in PackageWhitelistCondition
        assert_eq!(cond.check_package("kotlin"), Action::ForbidRename);
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

        // Class with wrong field types in R$ namespace
        // JADX Reference: ExcludeAndroidRClass checks cls.getTopParentClass()
        // Since top parent is R (ends with /R), this IS protected as an R inner class
        // even if its structure doesn't match typical R inner class patterns.
        // JADX would check isR(R), not isR(R$fake), so structure of inner class doesn't matter.
        let mut fake_r = ClassData::new("Lcom/example/R$fake;".to_string(), 0);
        fake_r.static_fields.push(FieldData {
            name: "notAnInt".to_string(),
            field_type: dexterity_ir::ArgType::Object("Ljava/lang/String;".to_string()),
            access_flags: 0x19,
            ..Default::default()
        });
        // ForbidRename because top parent is R (naming-based check)
        assert_eq!(cond.check_class(&fake_r), Action::ForbidRename);
    }

    #[test]
    fn test_exclude_android_r_class_top_parent() {
        // JADX Reference: ExcludeAndroidRClass.check(ClassNode) lines 12-17
        // JADX uses cls.getTopParentClass() to check the outermost enclosing class
        // For inner classes like R$id$Foo, this should check the R class itself
        let cond = ExcludeAndroidRClass::new();

        // Test get_top_parent_class_type helper
        assert_eq!(
            ExcludeAndroidRClass::get_top_parent_class_type("Lcom/example/R;"),
            "Lcom/example/R;"
        );
        assert_eq!(
            ExcludeAndroidRClass::get_top_parent_class_type("Lcom/example/R$id;"),
            "Lcom/example/R;"
        );
        assert_eq!(
            ExcludeAndroidRClass::get_top_parent_class_type("Lcom/example/R$id$Foo;"),
            "Lcom/example/R;"
        );
        assert_eq!(
            ExcludeAndroidRClass::get_top_parent_class_type("Lcom/example/MainActivity;"),
            "Lcom/example/MainActivity;"
        );
        assert_eq!(
            ExcludeAndroidRClass::get_top_parent_class_type("Lcom/example/Outer$Inner;"),
            "Lcom/example/Outer;"
        );

        // Test looks_like_r_class helper
        assert!(ExcludeAndroidRClass::looks_like_r_class("Lcom/example/R;"));
        assert!(!ExcludeAndroidRClass::looks_like_r_class("Lcom/example/R$id;"));
        assert!(!ExcludeAndroidRClass::looks_like_r_class("Lcom/example/MainActivity;"));
        assert!(!ExcludeAndroidRClass::looks_like_r_class("Lcom/example/Router;"));

        // Nested R class inner classes should be detected
        // JADX: getTopParentClass() returns R, then isR(R) == true
        let r_nested = ClassData::new("Lcom/example/R$id$Foo;".to_string(), 0);
        assert_eq!(cond.check_class(&r_nested), Action::ForbidRename);

        // Non-R class inner class should NOT be detected
        let non_r_inner = ClassData::new("Lcom/example/Outer$Inner;".to_string(), 0);
        assert_eq!(cond.check_class(&non_r_inner), Action::NoAction);
    }

    #[test]
    fn test_avoid_cls_pkg_collision() {
        // JADX Reference: AvoidClsAndPkgNamesCollision.java
        // Key: JADX checks cls.getAlias(), not the original name

        let packages = vec!["com/example/util", "com/example/data", "org/test"];
        let cond = AvoidClsAndPkgNamesCollision::with_packages(packages);

        // Class named "util" should be force renamed (collides with package "util")
        // Note: simple_name() returns "util" from "Lcom/other/util;"
        let util_class = ClassData::new("Lcom/other/util;".to_string(), 0);
        assert_eq!(cond.check_class(&util_class), Action::ForceRename);

        // Class named "data" should be force renamed (collides with package "data")
        let data_class = ClassData::new("Lorg/example/data;".to_string(), 0);
        assert_eq!(cond.check_class(&data_class), Action::ForceRename);

        // Class named "MainActivity" should not collide
        let main_class = ClassData::new("Lcom/example/MainActivity;".to_string(), 0);
        assert_eq!(cond.check_class(&main_class), Action::NoAction);

        // JADX behavior: Check ALIAS, not original name
        // A class with alias "util" should collide even if original name is different
        let mut aliased_class = ClassData::new("Lcom/other/a;".to_string(), 0);
        aliased_class.alias = Some("util".to_string());
        assert_eq!(cond.check_class(&aliased_class), Action::ForceRename);

        // A class with non-colliding alias should NOT be renamed
        let mut safe_alias = ClassData::new("Lcom/other/data;".to_string(), 0);
        safe_alias.alias = Some("SafeName".to_string());
        assert_eq!(cond.check_class(&safe_alias), Action::NoAction);
    }

    #[test]
    fn test_avoid_cls_pkg_collision_init() {
        // JADX Reference: AvoidClsAndPkgNamesCollision.init(RootNode)
        // Test the init_from_packages pattern

        let mut cond = AvoidClsAndPkgNamesCollision::new();
        assert!(cond.is_empty());

        // Initialize from package paths - should extract just the leaf names
        cond.init_from_packages(vec!["com/example/util", "com/example/data"]);
        assert_eq!(cond.len(), 2);

        // Should have "util" and "data" (leaf names)
        let util_class = ClassData::new("Lorg/other/util;".to_string(), 0);
        assert_eq!(cond.check_class(&util_class), Action::ForceRename);

        let data_class = ClassData::new("Lorg/other/data;".to_string(), 0);
        assert_eq!(cond.check_class(&data_class), Action::ForceRename);

        // "example" should NOT be tracked (it's not a leaf in these paths)
        let example_class = ClassData::new("Lorg/other/example;".to_string(), 0);
        assert_eq!(cond.check_class(&example_class), Action::NoAction);
    }

    #[test]
    fn test_combined_jadx_initialized() {
        // JADX Reference: CombineDeobfConditions.init(RootNode) + AvoidClsAndPkgNamesCollision
        // Test that default_jadx_initialized properly initializes collision detection

        let packages = vec!["com/example/util", "com/example/config", "org/app/data"];
        let cond = CombinedCondition::default_jadx_initialized(3, 64, packages);

        // Class named "util" should be force renamed (collides with package "util")
        // JADX: AvoidClsAndPkgNamesCollision triggers ForceRename
        let util_class = ClassData::new("Lorg/other/util;".to_string(), 0);
        assert_eq!(cond.check_class(&util_class), Action::ForceRename);

        // Class named "config" should be force renamed (collides with package "config")
        let config_class = ClassData::new("Lcom/test/config;".to_string(), 0);
        assert_eq!(cond.check_class(&config_class), Action::ForceRename);

        // Class named "data" should be force renamed (collides with package "data")
        let data_class = ClassData::new("Lorg/example/data;".to_string(), 0);
        assert_eq!(cond.check_class(&data_class), Action::ForceRename);

        // Class named "MainActivity" should not collide (no package named "MainActivity")
        let main_class = ClassData::new("Lcom/example/MainActivity;".to_string(), 0);
        assert_eq!(cond.check_class(&main_class), Action::NoAction);

        // Short class names still get renamed by LengthCondition even without collision
        let short_class = ClassData::new("Lcom/example/A;".to_string(), 0);
        assert_eq!(cond.check_class(&short_class), Action::ForceRename);
    }

    #[test]
    fn test_always_rename() {
        // JADX Reference: jadx-core/src/main/java/jadx/api/deobf/impl/AlwaysRename.java
        let cond = AlwaysRename::new();

        // All nodes should be force renamed
        assert_eq!(cond.check_package("anything"), Action::ForceRename);

        let cls = ClassData::new("Lcom/example/Any;".to_string(), 0);
        assert_eq!(cond.check_class(&cls), Action::ForceRename);

        let field = FieldData::new("field".to_string(), 0, dexterity_ir::ArgType::Int);
        assert_eq!(cond.check_field(&field), Action::ForceRename);

        let method = MethodData::new("method".to_string(), 0, dexterity_ir::ArgType::Void);
        assert_eq!(cond.check_method(&method), Action::ForceRename);
    }

    #[test]
    fn test_deobf_whitelist_jadx_default() {
        // JADX Reference: jadx-core/src/main/java/jadx/core/deobf/conditions/DeobfWhitelist.java
        let whitelist = DeobfWhitelist::default_jadx();

        // Check package patterns (ending with .*)
        // android.support.v4.* -> forbid rename
        assert_eq!(whitelist.check_package("android/support/v4"), Action::ForbidRename);
        assert_eq!(whitelist.check_package("android/support/v7"), Action::ForbidRename);
        assert_eq!(whitelist.check_package("android/support/v4/os"), Action::ForbidRename);
        assert_eq!(whitelist.check_package("androidx/core/os"), Action::ForbidRename);

        // Check exact class patterns
        // androidx.annotation.Px -> forbid rename (stored as class, not package)
        let px_class = ClassData::new("Landroidx/annotation/Px;".to_string(), 0);
        assert_eq!(whitelist.check_class(&px_class), Action::ForbidRename);

        let support_px_class = ClassData::new("Landroid/support/annotation/Px;".to_string(), 0);
        assert_eq!(whitelist.check_class(&support_px_class), Action::ForbidRename);

        // Non-whitelisted packages should get NoAction
        assert_eq!(whitelist.check_package("com/example"), Action::NoAction);
        assert_eq!(whitelist.check_package("org/test"), Action::NoAction);

        // Non-whitelisted classes should get NoAction
        let other_class = ClassData::new("Lcom/example/MyClass;".to_string(), 0);
        assert_eq!(whitelist.check_class(&other_class), Action::NoAction);
    }

    #[test]
    fn test_deobf_whitelist_custom_patterns() {
        // Test custom patterns
        let patterns = vec![
            "com.mycompany.*",
            "org.internal.util.*",
            "com.mycompany.special.SpecificClass",
        ];
        let whitelist = DeobfWhitelist::from_patterns(patterns);

        // Package patterns
        assert_eq!(whitelist.check_package("com/mycompany"), Action::ForbidRename);
        assert_eq!(whitelist.check_package("org/internal/util"), Action::ForbidRename);

        // Exact class
        let specific_class = ClassData::new("Lcom/mycompany/special/SpecificClass;".to_string(), 0);
        assert_eq!(whitelist.check_class(&specific_class), Action::ForbidRename);

        // Other packages/classes not affected
        assert_eq!(whitelist.check_package("com/other"), Action::NoAction);
    }

    #[test]
    fn test_rename_reason() {
        // JADX Reference: jadx-core/src/main/java/jadx/core/dex/attributes/nodes/RenameReasonAttr.java

        // Test from_validity helper
        assert_eq!(RenameReason::from_validity(true, false), RenameReason::NotValid);
        assert_eq!(RenameReason::from_validity(false, true), RenameReason::NotPrintable);
        assert_eq!(RenameReason::from_validity(true, true), RenameReason::NotValid);

        // Test various reason types
        let reasons = vec![
            RenameReason::NotValid,
            RenameReason::NotPrintable,
            RenameReason::InnerClassCollision,
            RenameReason::FieldNameCollision,
            RenameReason::MethodSignatureCollision,
            RenameReason::CaseSensitiveCollision,
            RenameReason::RootPackageCollision,
            RenameReason::SourceFileName,
            RenameReason::UserRename,
            RenameReason::InvalidClassName,
            RenameReason::Custom("test reason".to_string()),
        ];

        for reason in reasons {
            // Just verify they can be created and compared
            assert_eq!(reason.clone(), reason);
        }
    }

    #[test]
    fn test_jadx_default_whitelist_constant() {
        // Verify the exact JADX default list
        assert_eq!(JADX_DEFAULT_WHITELIST.len(), 6);
        assert!(JADX_DEFAULT_WHITELIST.contains(&"android.support.v4.*"));
        assert!(JADX_DEFAULT_WHITELIST.contains(&"android.support.v7.*"));
        assert!(JADX_DEFAULT_WHITELIST.contains(&"android.support.v4.os.*"));
        assert!(JADX_DEFAULT_WHITELIST.contains(&"android.support.annotation.Px"));
        assert!(JADX_DEFAULT_WHITELIST.contains(&"androidx.core.os.*"));
        assert!(JADX_DEFAULT_WHITELIST.contains(&"androidx.annotation.Px"));
    }
}
