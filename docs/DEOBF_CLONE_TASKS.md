# Dexterity-Deobf JADX Clone Tasks

**Status**: Comprehensive analysis of JADX vs Dexterity deobfuscation parity
**Date**: 2025-12-23
**Goal**: 100% JADX parity - clone functionality exactly, not improve

---

## Philosophy

We are **CLONING** JADX's deobfuscation functionality, not reimplementing it.
The JADX deobfuscation codebase has 10 years of edge case handling that we must preserve.

---

## Executive Summary

Dexterity-deobf has **good foundation** but is missing several key JADX features:

| Category | Status | Notes |
|----------|--------|-------|
| Core Conditions | ✅ 95% | All 6 JADX conditions cloned |
| Alias Provider | ✅ 90% | Missing recursive superclass resolution |
| RenameVisitor | ⚠️ 70% | Missing case-sensitivity, root package collision |
| DeobfPresets (.jobf) | ✅ 95% | Cloned well |
| SourceFileRename | ✅ 90% | BetterName logic cloned |
| UserRenames | ✅ 85% | Missing shortId lookup |
| CodeRenameVisitor | ⚠️ 60% | SSA variable renaming not integrated |
| Override Method Detection | ⚠️ 50% | Exists but not integrated into rename flow |

---

## JADX Source Files Reference

### Core Deobf (jadx-core/src/main/java/jadx/core/deobf/)

| JADX File | Dexterity File | Status |
|-----------|----------------|--------|
| DeobfuscatorVisitor.java | visitor.rs | ✅ Cloned |
| DeobfAliasProvider.java | alias_provider.rs | ⚠️ 90% - Missing recursive resolution |
| NameMapper.java | name_mapper.rs | ✅ Cloned |
| DeobfPresets.java | jobf.rs | ✅ Cloned |
| SaveDeobfMapping.java | jobf.rs | ✅ Included in jobf.rs |
| FileTypeDetector.java | file_type_detector.rs | ✅ Cloned |

### Conditions (jadx-core/src/main/java/jadx/core/deobf/conditions/)

| JADX File | Dexterity Location | Status |
|-----------|-------------------|--------|
| JadxRenameConditions.java | conditions.rs | ✅ Cloned |
| AbstractDeobfCondition.java | conditions.rs (trait) | ✅ Cloned |
| BaseDeobfCondition.java | conditions.rs | ✅ Cloned |
| DeobfWhitelist.java | conditions.rs | ✅ Cloned |
| ExcludePackageWithTLDNames.java | tlds.rs | ✅ Cloned |
| ExcludeAndroidRClass.java | conditions.rs | ✅ Cloned |
| AvoidClsAndPkgNamesCollision.java | conditions.rs | ✅ Cloned |
| DeobfLengthCondition.java | conditions.rs | ✅ Cloned |

### Rename Visitors (jadx-core/src/main/java/jadx/core/dex/visitors/rename/)

| JADX File | Dexterity File | Status | Priority |
|-----------|----------------|--------|----------|
| RenameVisitor.java | rename_validator.rs | ⚠️ 70% | P1 |
| CodeRenameVisitor.java | code_rename.rs | ⚠️ 60% | P2 |
| UserRenames.java | user_renames.rs | ⚠️ 85% | P2 |
| SourceFileRename.java | source_file_rename.rs | ✅ 90% | P3 |

### API/Interface (jadx-core/src/main/java/jadx/api/deobf/)

| JADX File | Dexterity Location | Status |
|-----------|-------------------|--------|
| IAliasProvider.java | alias_provider.rs (trait) | ✅ Cloned |
| IRenameCondition.java | conditions.rs | ✅ Cloned |
| IDeobfCondition.java | conditions.rs (Action enum) | ✅ Cloned |
| impl/AlwaysRename.java | conditions.rs | ✅ Cloned |
| impl/AnyRenameCondition.java | conditions.rs | ✅ Cloned |
| impl/CombineDeobfConditions.java | conditions.rs | ✅ Cloned |

---

## P1: Critical Missing Features (Must Clone)

### GAP-P1-1: RenameVisitor - Case Sensitivity Handling
**JADX**: `RenameVisitor.java` lines 62-72
```java
// JADX checks for case-insensitive filesystem collisions
if (!args.isFsCaseSensitive() && args.isRenameCaseSensitive()) {
    Set<String> clsFullPaths = new HashSet<>(classes.size());
    for (ClassNode cls : classes) {
        ClassInfo clsInfo = cls.getClassInfo();
        if (!clsFullPaths.add(clsInfo.getAliasFullPath().toLowerCase())) {
            clsInfo.changeShortName(aliasProvider.forClass(cls));
            cls.addAttr(new RenameReasonAttr(cls).append("case insensitive filesystem"));
            clsFullPaths.add(clsInfo.getAliasFullPath().toLowerCase());
        }
    }
}
```
**Dexterity**: Missing in `rename_validator.rs`
**Task**: Add `validate_case_sensitivity()` function
```rust
/// JADX Reference: RenameVisitor.java lines 62-72
/// Clone from JADX's case-insensitive filesystem collision check
pub fn validate_case_sensitivity<A: AliasProvider>(
    classes: &mut [ClassData],
    alias_provider: &A,
) -> usize {
    let mut renamed = 0;
    let mut full_paths_lower: HashSet<String> = HashSet::new();

    for cls in classes.iter_mut() {
        let alias_path = cls.get_alias_full_path().to_lowercase();
        if !full_paths_lower.insert(alias_path.clone()) {
            // Collision detected - rename this class
            let new_alias = alias_provider.for_class(cls);
            cls.alias = Some(new_alias);
            // Re-insert with new alias path
            full_paths_lower.insert(cls.get_alias_full_path().to_lowercase());
            renamed += 1;
        }
    }
    renamed
}
```

### GAP-P1-2: RenameVisitor - Root Package Collision
**JADX**: `RenameVisitor.java` lines 225-239
```java
// Rename field if collide with any root package
public static void processRootPackages(List<ClassNode> classes, CacheStorage cache, IAliasProvider aliasProvider) {
    Set<String> rootPkgs = buildRootPackages(classes);
    cache.setRootPkgs(rootPkgs);
    for (ClassNode cls : classes) {
        for (FieldNode field : cls.getFields()) {
            if (rootPkgs.contains(field.getAlias())) {
                field.rename(aliasProvider.forField(field));
                field.addAttr(new RenameReasonAttr("collision with root package name"));
            }
        }
    }
}
```
**Dexterity**: Missing
**Task**: Add `check_root_package_collision()` function
```rust
/// JADX Reference: RenameVisitor.java lines 225-239
/// Clone from JADX's root package collision detection
pub fn check_root_package_collision<A: AliasProvider>(
    classes: &mut [ClassData],
    alias_provider: &A,
) -> usize {
    // Build set of root packages
    let root_pkgs: HashSet<String> = classes.iter()
        .filter_map(|cls| {
            let class_type = cls.class_type.trim_start_matches('L').trim_end_matches(';');
            class_type.split('/').next().map(|s| s.to_string())
        })
        .collect();

    let mut renamed = 0;
    for cls in classes.iter_mut() {
        for field in cls.static_fields.iter_mut().chain(cls.instance_fields.iter_mut()) {
            let field_alias = field.alias.as_ref().unwrap_or(&field.name);
            if root_pkgs.contains(field_alias) {
                let new_alias = alias_provider.for_field(field);
                field.alias = Some(new_alias);
                renamed += 1;
            }
        }
    }
    renamed
}
```

### GAP-P1-3: DeobfAliasProvider - Recursive Superclass Resolution
**JADX**: `DeobfAliasProvider.java` lines 85-115
```java
// JADX walks up the class hierarchy to find meaningful base names
private static String getBaseName(ClassNode cls) {
    ClassNode currentCls = cls;
    while (currentCls != null) {
        // Check superclass for android.app.*, android.os.*
        ArgType superCls = currentCls.getSuperClass();
        if (superCls != null) {
            String superClsName = superCls.getObject();
            if (superClsName.startsWith("android.app.") || superClsName.startsWith("android.os.")) {
                return getClsName(superClsName);
            }
        }
        // Check interfaces for Runnable, Callable, etc.
        for (ArgType interfaceType : cls.getInterfaces()) {
            // ... interface checks ...
        }
        // RECURSIVE: Walk up class hierarchy
        currentCls = cls.root().resolveClass(superCls);
    }
    return "";
}
```
**Dexterity**: Has `get_base_name_with_resolver()` but not integrated
**Task**: Integrate resolver callback into `DeobfuscatorVisitor`
```rust
// In visitor.rs - add resolver integration
impl<C, A> DeobfuscatorVisitor<C, A> {
    /// Process class with recursive superclass resolution for base names
    /// JADX Reference: DeobfAliasProvider.getBaseName() lines 85-115
    pub fn process_class_with_resolver<F>(
        &self,
        cls: &mut ClassData,
        resolver: F
    ) where F: Fn(&str) -> Option<&ClassData>
    {
        // Use resolver to get better base name
        let base_name = get_base_name_with_resolver(cls, &resolver);
        // ... use base_name in alias generation ...
    }
}
```

### GAP-P1-4: Override Method Detection Integration
**JADX**: Uses `AType.METHOD_OVERRIDE` throughout for "mo" prefix
```java
// DeobfAliasProvider.java:51-53
public String forMethod(MethodNode mth) {
    String prefix = mth.contains(AType.METHOD_OVERRIDE) ? "mo" : "m";
    return String.format("%s%d%s", prefix, mthIndex++, prepareNamePart(mth.getName()));
}
```
**Dexterity**: Has `override_method_visitor.rs` but not connected to deobf
**Task**: Connect override detection to alias generation
```rust
// Current in alias_provider.rs - is_override is passed but not detected
fn for_method(&self, method: &MethodData, is_override: bool) -> String

// Need to add in visitor.rs:
fn is_likely_override(method: &dexterity_ir::MethodData) -> bool {
    // Check @Override annotation
    method.annotations.iter().any(|a| {
        a.annotation_type == "java/lang/Override"
            || a.annotation_type.ends_with("/Override")
    })
    // TODO: Also check OverrideMethodVisitor results
}
```

---

## P2: Important Missing Features

### GAP-P2-1: UserRenames - Short ID Lookup
**JADX**: `UserRenames.java` lines 59-67
```java
// JADX uses searchFieldByShortId/searchMethodByShortId
FieldNode fieldNode = cls.searchFieldByShortId(nodeRef.getShortId());
if (fieldNode == null) {
    // Log all fields with same name for debugging
    String fieldSign = cls.getFields().stream()
        .filter(f -> f.getFieldInfo().getName().equals(fieldName))
        .map(f -> f.getFieldInfo().getShortId())
        .collect(Collectors.joining());
    LOG.warn("Field reference not found: {}. Fields with same name: {}", nodeRef, fieldSign);
}
```
**Dexterity**: Uses direct name lookup only
**Task**: Add `search_field_by_short_id()` and `search_method_by_short_id()`

### GAP-P2-2: CodeRenameVisitor - SSA Variable Integration
**JADX**: `CodeRenameVisitor.java` lines 87-96
```java
case VAR: {
    int regNum = codeRef.getIndex() >> 16;
    int ssaVer = codeRef.getIndex() & 0xFFFF;
    for (SSAVar ssaVar : mth.getSVars()) {
        if (ssaVar.getRegNum() == regNum && ssaVar.getVersion() == ssaVer) {
            ssaVar.getCodeVar().setName(rename.getNewName());
            return;
        }
    }
    LOG.warn("Can't find variable ref by {}_{} in {}", regNum, ssaVer, mth);
}
```
**Dexterity**: Has structure but doesn't integrate with SSA
**Task**: Connect to dexterity-passes SSA system for variable naming

### GAP-P2-3: RenameVisitor - Method Collision with Override Check
**JADX**: `RenameVisitor.java` lines 208-223
```java
private static boolean canRename(MethodNode mth) {
    if (mth.contains(AFlag.DONT_RENAME)) {
        return false;
    }
    MethodOverrideAttr overrideAttr = mth.get(AType.METHOD_OVERRIDE);
    if (overrideAttr != null) {
        for (MethodNode relatedMth : overrideAttr.getRelatedMthNodes()) {
            if (relatedMth != mth && mth.getParentClass().equals(relatedMth.getParentClass())) {
                // ignore rename if exists related method from same class (bridge method)
                return false;
            }
        }
    }
    return true;
}
```
**Dexterity**: Missing override-based rename restriction
**Task**: Add bridge method detection to `validate_methods()`

---

## P3: Minor Missing Features

### GAP-P3-1: SourceFileRename - BetterName Edge Cases
**JADX**: Uses `BetterName.getBetterClassName()` with full JADX logic
**Dexterity**: Has basic implementation
**Task**: Verify exact matching with JADX BetterName.java

### GAP-P3-2: RenameReasonAttr - Full Audit Trail
**JADX**: `RenameReasonAttr.java` - tracks WHY each rename happened
**Dexterity**: Has `RenameReason` enum but not fully used
**Task**: Propagate RenameReason through all rename operations

### GAP-P3-3: Package Rename - Leaf vs Full Path
**JADX**: `DeobfPresets.fill()` lines 151-157
```java
if (pkg.isLeaf()) { // ignore middle packages
    if (pkg.hasParentAlias()) {
        pkgPresetMap.put(pkg.getPkgInfo().getFullName(), pkg.getAliasPkgInfo().getFullName());
    } else if (pkg.hasAlias()) {
        pkgPresetMap.put(pkg.getPkgInfo().getFullName(), pkg.getAliasPkgInfo().getName());
    }
}
```
**Dexterity**: Always saves full path
**Task**: Add leaf package detection in jobf.rs

---

## Implementation Priority Order

```
Phase 1: Core Integration (P1) - CRITICAL
├── GAP-P1-1: Case sensitivity validation
├── GAP-P1-2: Root package collision check
├── GAP-P1-3: Recursive superclass resolution in alias provider
└── GAP-P1-4: Override method detection integration

Phase 2: User Experience (P2)
├── GAP-P2-1: Short ID lookup for user renames
├── GAP-P2-2: SSA variable rename integration
└── GAP-P2-3: Bridge method detection in rename validation

Phase 3: Polish (P3)
├── GAP-P3-1: BetterName edge case verification
├── GAP-P3-2: Full RenameReason propagation
└── GAP-P3-3: Leaf package handling in .jobf
```

---

## Previously Completed (Dec 23, 2025)

### ✅ GAP-D3: ExcludeAndroidRClass getTopParentClass()
**Status:** IMPLEMENTED
- Added `get_top_parent_class_type()` helper (conditions.rs:932-940)
- Added `looks_like_r_class()` helper (conditions.rs:946-950)
- Updated `check_class()` to check top parent first (conditions.rs:1037-1060)

### ✅ GAP-D4: Package Processing in DeobfuscatorVisitor
**Status:** IMPLEMENTED
- Added `process_with_packages()` method (visitor.rs:139-157)
- Added `process_packages()` helper (visitor.rs:164-187)
- Added `update_class_packages()` helper (visitor.rs:194-218)

### ✅ GAP-D6: AvoidClsAndPkgNamesCollision Init
**Status:** IMPLEMENTED
- Added `default_jadx_initialized()` method (conditions.rs:577-600)
- Added `default_dexterity_initialized()` method (conditions.rs:605-621)

---

## Testing Strategy

For each cloned feature, create tests that:
1. Match JADX integration test behavior exactly
2. Use the same edge cases from JADX test files
3. Compare output with JADX for identical APKs

### JADX Test Files to Clone
```
jadx-core/src/test/java/jadx/tests/integration/deobf/
├── TestMthRename.java
├── TestNegativeRenameCondition.java
├── TestRenameOverriddenMethod.java
├── TestRenameOverriddenMethod2.java
├── TestRenameOverriddenMethod3.java
├── TestInheritedMethodRename.java
├── TestDontRenameClspOverriddenMethod.java
├── TestFieldFromInnerClass.java
└── a/TestNegativeRenameCondition.java
```

---

## File-by-File Clone Tasks

### rename_validator.rs - Priority Tasks
```rust
// TODO: Clone from JADX RenameVisitor.java

// GAP-P1-1: Case-insensitive filesystem check (lines 62-72)
pub fn validate_case_sensitivity(classes: &mut [ClassData], provider: &impl AliasProvider) -> usize

// GAP-P1-2: Root package collision (lines 225-239)
pub fn check_root_package_collision(classes: &mut [ClassData], provider: &impl AliasProvider) -> usize

// GAP-P2-3: Bridge method detection in canRename (lines 208-223)
fn can_rename_method(method: &MethodData, override_info: Option<&OverrideInfo>) -> bool
```

### alias_provider.rs - Priority Tasks
```rust
// GAP-P1-3: Integrate resolver callback
pub fn for_class_with_resolver<F>(&self, cls: &ClassData, resolver: F) -> String
where
    F: Fn(&str) -> Option<&ClassData>
```

### visitor.rs - Priority Tasks
```rust
// Integrate full RenameVisitor pipeline after deobf
pub fn process_full_pipeline(
    &self,
    packages: &mut Vec<String>,
    classes: &mut [ClassData],
    fs_case_sensitive: bool,
) -> DeobfResult
```

---

## Verification Checklist

Before marking a task complete:

- [ ] Code references exact JADX file and line numbers
- [ ] Logic matches JADX exactly (not "improved")
- [ ] Comments include JADX reference comments
- [ ] Tests cover JADX edge cases
- [ ] Output matches JADX for test APKs

---

## Verification Commands

```bash
# Build and run comparison
cargo build --release
./target/release/dexterity --output-dir test-out test.apk
/opt/jadx/bin/jadx --output-dir jadx-out test.apk

# Compare class names
diff <(find test-out -name "*.java" | sort) <(find jadx-out -name "*.java" | sort)
```

---

## Notes

- **Do NOT improve on JADX** - 10 years of edge case handling
- **Clone first, optimize later** - parity before performance
- **Comment everything** - reference JADX sources liberally
- **Test with real APKs** - compare dexterity vs jadx output

---

*This document provides exact clone specifications for JADX deobf parity.*
