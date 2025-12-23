# JADX Deobfuscation Clone Tasks

This document tracks the effort to achieve 100% parity with JADX's deobfuscation system.
The goal is exact behavioral cloning, not improvement.

## JADX Source Reference Files

### Core Deobfuscation (jadx-core/src/main/java/jadx/core/deobf/)
- `DeobfuscatorVisitor.java` - Main orchestrator
- `DeobfPresets.java` - JOBF mapping persistence
- `DeobfAliasProvider.java` - Alias name generation
- `NameMapper.java` - Name validation/sanitization
- `SaveDeobfMapping.java` - Saves mappings after processing

### Conditions (jadx-core/src/main/java/jadx/core/deobf/conditions/)
- `JadxRenameConditions.java` - Factory for default conditions
- `AbstractDeobfCondition.java` - Base class (NO_ACTION default)
- `BaseDeobfCondition.java` - DONT_RENAME flag, existing alias, constructor checks
- `DeobfLengthCondition.java` - Min/max name length
- `DeobfWhitelist.java` - User whitelist patterns
- `ExcludeAndroidRClass.java` - Android R class detection
- `ExcludePackageWithTLDNames.java` - TLD package exclusion
- `AvoidClsAndPkgNamesCollision.java` - Class/package name collision

### API Interfaces (jadx-core/src/main/java/jadx/api/deobf/)
- `IDeobfCondition.java` - Condition interface with Action enum
- `IRenameCondition.java` - Simplified rename decision interface
- `IAliasProvider.java` - Alias generation interface

### API Implementations (jadx-core/src/main/java/jadx/api/deobf/impl/)
- `CombineDeobfConditions.java` - Combines multiple conditions with voting logic
- `AlwaysRename.java` - Always returns true (used when applying presets)
- `AnyRenameCondition.java` - Predicate-based condition

### Related Visitors (jadx-core/src/main/java/jadx/core/dex/visitors/rename/)
- `RenameVisitor.java` - Post-processing renames (fields, methods, packages)
- `UserRenames.java` - Applies user-provided renames
- `CodeRenameVisitor.java` - Variable renaming in method code
- `SourceFileRename.java` - Source file-based class renaming

---

## Completed Tasks

### 1. Action Enum Alignment
**Status:** ✅ COMPLETED

**JADX:** `IDeobfCondition.Action` has exactly 3 values:
- `NO_ACTION` - Condition doesn't apply
- `FORCE_RENAME` - Must rename
- `FORBID_RENAME` - Must not rename

**Dexterity Fix:** Updated `conditions.rs` Action enum to match:
- `NoAction` → JADX `NO_ACTION`
- `ForceRename` → JADX `FORCE_RENAME`
- `ForbidRename` → JADX `FORBID_RENAME`

Removed extra `Rename` state (kept as backward-compat const alias).

### 2. CombineDeobfConditions Voting Logic
**Status:** ✅ COMPLETED

**JADX Logic (CombineDeobfConditions.combineFunc):**
```java
for (IDeobfCondition c : conditions) {
    switch (check.apply(c)) {
        case NO_ACTION: break;           // ignore, continue
        case FORCE_RENAME: return true;  // FIRST force wins immediately
        case FORBID_RENAME: return false; // FIRST forbid wins immediately
    }
}
return false; // default: don't rename
```

**Critical:** JADX uses "first definitive action wins" - order matters!
The previous Dexterity implementation gave FORBID higher priority regardless of order.

**Dexterity Fix:** Updated `CombinedCondition.combine_actions()` to match exact JADX behavior.

### 3. Default Conditions Order
**Status:** ✅ COMPLETED

**JADX Order (JadxRenameConditions.buildDefaultDeobfConditions):**
1. `BaseDeobfCondition` - DONT_RENAME flag, existing alias, constructor
2. `DeobfWhitelist` - User-configured whitelist patterns
3. `ExcludePackageWithTLDNames` - Skip TLD packages
4. `ExcludeAndroidRClass` - Skip Android R classes
5. `AvoidClsAndPkgNamesCollision` - Force rename on collision
6. `DeobfLengthCondition` - Force rename if too short/long

**Dexterity Fix:** Updated `CombinedCondition::default_jadx()` to include all conditions in correct order.

### 4. BaseDeobfCondition
**Status:** ✅ COMPLETED

**JADX (BaseDeobfCondition.java):**
- Forbids rename if `DONT_RENAME` flag is set
- Forbids rename if node already has alias
- Forbids rename for constructor methods (`<init>`, `<clinit>`)

**Dexterity Fix:** Added `BaseDeobfCondition` struct implementing these checks.

---

## Remaining Tasks

### 5. RenameVisitor.canRename() - Bridge Method Detection
**Status:** ✅ COMPLETED

**JADX Location:** `RenameVisitor.java:208-223`

**Dexterity Implementation:** `rename_validator.rs:can_rename_method()`

Added bridge method detection that:
- Checks ACC_BRIDGE flag (0x40)
- Detects same-name-different-signature methods (bridge pattern)
- Allows collision resolution (same-name-same-signature) to proceed

### 6. RenameVisitor Inner Class Name Collision
**Status:** ✅ COMPLETED

**JADX Location:** `RenameVisitor.java:101-112`

**Dexterity Implementation:** `rename_validator.rs:check_inner_class_parent_collision()`

Added function to detect when an inner class name collides with any parent class name
in the hierarchy (e.g., `Foo$Foo` is problematic).

### 7. DeobfPresets.initIndexes()
**Status:** ✅ COMPLETED

**JADX Location:** `DeobfPresets.java:205-207`

**Dexterity Implementation:** `deobf.rs:load_jobf_file_with_counts()` + `provider.init_indexes()`

Modified JOBF loading to:
1. Return counts per category (pkg, cls, fld, mth)
2. Call `provider.init_indexes()` with those counts
3. Ensures new aliases don't collide with loaded ones

### 8. Default Package Rename to "defpackage"
**Status:** ✅ COMPLETED

**JADX Location:** `RenameVisitor.java:115-119`

**Dexterity Implementation:** `deobf.rs:precompute_deobf_aliases()`

Added detection of classes in the default package (no path separator in class name)
and automatic alias of empty package to "defpackage".

---

## DeobfWhitelist.DEFAULT_LIST Comparison

### JADX Defaults
```java
public static final List<String> DEFAULT_LIST = Arrays.asList(
    "android.support.v4.*",
    "android.support.v7.*",
    "android.support.v4.os.*",
    "android.support.annotation.Px",
    "androidx.core.os.*",
    "androidx.annotation.Px");
```

### Dexterity Implementation
Dexterity uses a much larger `COMMON_PACKAGE_NAMES` list and `PackageWhitelistCondition`
which includes many two-letter country codes and library names.

**Note:** The Dexterity approach is MORE comprehensive than JADX's default whitelist.
For exact parity, consider using JADX's exact defaults and allowing users to extend.

---

## Files Modified in This Clone Effort

### dexterity-deobf/src/conditions.rs
- Updated Action enum to match JADX (3 states: NoAction, ForceRename, ForbidRename)
- Added BaseDeobfCondition (checks alias, constructor)
- Fixed CombinedCondition voting logic ("first definitive wins")
- Updated default_jadx() to include all conditions in JADX order
- Added comprehensive JADX reference comments
- Updated tests to use new Action variants

### dexterity-deobf/src/tlds.rs
- Updated to use Action::ForbidRename
- Added JADX reference comments

### dexterity-deobf/src/lib.rs
- Exported BaseDeobfCondition

### dexterity-deobf/src/rename_validator.rs
- Added `can_rename_method()` for bridge method detection
- Added `check_inner_class_parent_collision()` for inner class name validation
- Updated `validate_methods()` to use bridge method check before renaming
- Added tests for new functions

### dexterity-cli/src/deobf.rs
- Created `load_jobf_file_with_counts()` that returns mapping counts
- Modified `precompute_deobf_aliases()` to call `provider.init_indexes()` with loaded counts
- Added JADX reference comments

---

## Testing Recommendations

1. **Unit Tests:** Run `cargo test --package dexterity-deobf`
2. **Integration Tests:** Compare output of Dexterity vs JADX on same APK with `--deobf` flag
3. **Edge Cases:**
   - APK with Android R classes
   - APK with bridge methods (Kotlin companion objects)
   - APK with inner classes having same names as parents
   - APK with default package classes
   - APK with TLD-named packages (com, org, io)

---

## JADX Reference Comments Style

All cloned code includes comments in this format:
```rust
// JADX Reference: ClassName.methodName() - brief description
// JADX Reference: package/path/File.java:lineNumber
```

This enables easy cross-referencing with JADX source code.
