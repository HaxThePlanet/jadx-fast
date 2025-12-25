# JADX Deobfuscation & Renaming System Reference

This document provides implementation-level detail of JADX's deobfuscation and renaming system for building a 1:1 clone in Rust.

## Architecture Overview

The deobfuscation system consists of two main phases:

### Phase 1: Deobfuscation (Early in Pipeline)

| Component | Purpose |
|-----------|---------|
| `DeobfuscatorVisitor` | Core visitor that runs early and applies renaming based on conditions |
| `DeobfPresets` | Loads/saves persistent mapping files (.jobf format) |
| `IAliasProvider` | Interface for generating new names |
| `IRenameCondition` | Interface for deciding whether to rename |

### Phase 2: Validation & Refinement (Late in Pipeline)

| Component | Purpose |
|-----------|---------|
| `RenameVisitor` | Validates and fixes names after deobfuscation |
| `CodeRenameVisitor` | Renames variables in method code |
| `SourceFileRename` | Uses source file names for better naming |
| `SaveDeobfMapping` | Persists final mappings |

---

## Key Files & Locations

### Core Deobfuscation Files

| File | Purpose |
|------|---------|
| `core/deobf/DeobfPresets.java` | Mapping file I/O |
| `core/deobf/DeobfuscatorVisitor.java` | Main deobfuscation logic |
| `core/deobf/DeobfAliasProvider.java` | Name generation |
| `core/deobf/NameMapper.java` | Name validation utilities |
| `core/deobf/FileTypeDetector.java` | Binary file type detection |

### Renaming Files

| File | Purpose |
|------|---------|
| `dex/visitors/rename/RenameVisitor.java` | Validation phase |
| `dex/visitors/rename/CodeRenameVisitor.java` | Code-level renames |
| `dex/visitors/rename/UserRenames.java` | User-provided renames |
| `dex/visitors/rename/SourceFileRename.java` | Source file heuristics |

### Condition Files

| File | Purpose |
|------|---------|
| `deobf/conditions/JadxRenameConditions.java` | Default conditions builder |
| `deobf/conditions/BaseDeobfCondition.java` | Already renamed check |
| `deobf/conditions/DeobfLengthCondition.java` | Min/max length filter |
| `deobf/conditions/DeobfWhitelist.java` | Whitelist support (e.g., androidx) |
| `deobf/conditions/ExcludeAndroidRClass.java` | Android R class exclusion |
| `deobf/conditions/AvoidClsAndPkgNamesCollision.java` | Collision detection |
| `deobf/conditions/ExcludePackageWithTLDNames.java` | Top-level domain filtering |

---

## DeobfPresets (Mapping File Management)

### Structure

```
Format: Text-based mapping file (.jobf)
Syntax: [type] [originalName] = [alias]
Types:  p (package), c (class), f (field), m (method)
```

### Load Flow

```
- Loads from <input>.jobf if exists and shouldRead() mode is enabled
- Applies loaded mappings immediately via apply()
- Initializes indexes for subsequent name generation
```

### Save Flow

```
- Collects current aliases from RootNode (fill())
- Writes sorted list to deobf map file
- Triggered after code generation via SaveDeobfMapping visitor
```

---

## Name Detection & Renaming

### DeobfuscatorVisitor.process() - Core Renaming Logic

```
For each package/class/field/method:
  1. Check IRenameCondition.shouldRename() - combined logic from all conditions
  2. If should rename, call IAliasProvider.forPackage/Class/Field/Method()
  3. Apply alias via node.rename(alias)
```

### Name Detection Flow

| Step | Condition | Action |
|------|-----------|--------|
| 1 | Is it already renamed? (BaseDeobfCondition) | FORBID if hasAlias() |
| 2 | Is it on whitelist? (DeobfWhitelist) | FORBID if matches patterns like "androidx.*" |
| 3 | Is it a TLD? (ExcludePackageWithTLDNames) | FORBID if root package name is in tlds.txt |
| 4 | Is it Android R class? (ExcludeAndroidRClass) | FORBID if detected R class |
| 5 | Name length check (DeobfLengthCondition) | FORCE_RENAME if outside min/max range |
| 6 | Collision detection (AvoidClsAndPkgNamesCollision) | FORCE_RENAME if conflicts with package name |

### IRenameCondition Actions

| Action | Meaning |
|--------|---------|
| `NO_ACTION` | Use default logic, don't force anything |
| `FORCE_RENAME` | Always rename this element |
| `FORBID_RENAME` | Never rename this element |

### CombineDeobfConditions Aggregation

- FORBID takes precedence (return false immediately)
- FORCE_RENAME sets flag, checks remaining conditions
- Returns true if any FORCE_RENAME encountered

---

## Name Regeneration & Generation

### DeobfAliasProvider - Strategic Name Generation

```
Package: p[index][originalName_part]
  - Example: p001android, p002java

Class:   [Prefix]C[index][originalName_part]
  - Prefix based on class properties:
    - Enum -> "Enum"
    - Interface -> "Interface"
    - Abstract -> "Abstract"
    - Otherwise: derives from superclass (Activity, Runnable, etc.)
  - Example: EnumC0001Activity, AbstractC0002Widget

Field:   f[index][originalName_part]
  - Example: f0mTempVar, f1mHandler

Method:  [mo/m][index][originalName_part]
  - mo = method with override attribute (bridge methods, etc.)
  - m = regular method
  - Example: mo0onCreate, m1processData
```

### prepareNamePart() - Name Sanitization

- Removes invalid identifier characters
- If name > maxLength: uses hexadecimal hash instead
- Handles Unicode and special characters

---

## Name Aliasing & Mapping Persistence

### Alias Model

- Each ClassInfo, FieldInfo, MethodInfo has optional `alias` field
- `hasAlias()` returns true if different from original name
- `getAlias()` returns current alias

### Mapping Formats Supported

**JADX internal format (.jobf):** Simple text format

**External formats (via jadx-rename-mappings plugin):** Fabric MappingIO formats
- Supports: Tiny, Tiny v2, MojMap, SRG, TSRG, CSRG, ProGuard, etc.

### Mapping Files

| Type | Description |
|------|-------------|
| **Output** | Generated .jobf files side-by-side with input files |
| **Input** | User can provide mappings via `-user-renames-mappings` option or DeobfPresets mechanism |
| **Load/Apply** | RenameMappingsData -> LoadMappingsPass -> ApplyMappingsPass -> CodeMappingsPass |

---

## Renaming Visitors (Execution Order)

### DeobfuscatorVisitor (init phase)

- Loads persisted mappings, applies them
- Runs deobfuscation logic with combined conditions
- **RUNS EARLY** - before code generation

### RenameVisitor (init phase)

Validates all names after deobfuscation. Checks for:
- Invalid Java identifiers (starting with $, digits)
- Non-printable characters
- Anonymous class patterns (pure digits)
- Name collisions (fields, methods, packages)
- Case-sensitivity issues on case-insensitive filesystems

Falls back to DeobfAliasProvider.forX() if validation fails.
Validates method name collisions via signature (includeRetType=false).

### SourceFileRename (init phase)

- Attempts to use source file names for classes
- Deduplicates if multiple classes use same source file
- Respects UseSourceNameAsClassNameAlias strategy (ALWAYS, IF_BETTER, NEVER)

### UserRenames (init phase)

- Applies user-provided renames from ICodeData
- Supports both class-level and code-level renames

### CodeRenameVisitor (decompile phase)

- Renames method parameters and local variables
- Requires InitCodeVariables and DebugInfoApplyVisitor to run first
- Handles SSAVar -> CodeVar mapping

### SaveDeobfMapping (init phase)

- Collects final aliases from all nodes
- Writes .jobf mapping file
- Respects GeneratedRenamesMappingFileMode options

---

## Edge Cases Handling

### Overloaded Methods

```
Handled via MethodInfo.makeSignature(useAlias=true, includeRetType=false)
- Signature includes method name and argument types, NOT return type
- DeobfAliasProvider uses "mo" prefix for overridden methods (mo0, mo1, etc.)
- RenameVisitor detects collisions by checking all methods in class
- If collision found and can be renamed: applies new deobfuscated name
```

### Inner Classes

```
- ClassInfo tracks parentClass and isInner() status
- getFullName() includes parent class prefix
- RenameVisitor checks for name collision with parent class names
- SourceFileRename skips inner classes (inner classes don't have source files)
- DeobfAliasProvider prefixes inner class generation with type info
```

### Lambda & Anonymous Classes

```
- Anonymous classes detected by pure digit names (\d+)
- RenameVisitor.fixClsShortName() converts "123" -> "C123"
  (with Consts.ANONYMOUS_CLASS_PREFIX)
- DeobfAliasProvider handles same way
- Lambda naming deferred to code generation phase
```

### Generic Types

```
- ArgType tracks generics but deobfuscation works on raw types
- MethodInfo.makeSignature() uses TypeGen.signature() for non-generic types
- ClassInfo.makeRawFullName() strips generics
```

### Constructor & Bridge Methods

```
- BaseDeobfCondition forbids renaming constructors
- DeobfAliasProvider detects METHOD_OVERRIDE attribute for bridge methods
- Uses "mo" prefix for methods with overrides to preserve identity
- MethodOverrideAttr prevents renaming if related method in same class
```

### Package Collisions

```
AvoidClsAndPkgNamesCollision:
- Collects all root package names during init()
- FORCE_RENAME if class alias matches any package name
- RenameVisitor.processRootPackages() also checks field names
```

---

## Mapping File Format (.jobf)

```
# Comments start with #
p android.support.v4 = p001support
p androidx.core = p002core
c android/support/v4/app/Activity;$Inner = IntentActivity
f android/support/v4/app/Activity.mTemp:I = mVariable
m android/support/v4/app/Activity.onCreate(Landroid/os/Bundle;)V = onCreate

Format: [type] [rawId] = [alias]
Types:
  p = package (just name)
  c = class (raw full name)
  f = field (rawFullId format: class.name:signature)
  m = method (rawFullId format: class.shortId including args)
  v = variable (deprecated)

Raw Full IDs:
- Class: "android.support.v4.app.Activity" -> "android/support/v4/app/Activity"
- Field: "android.support.v4.app.Activity.mTemp:I"
- Method: "android.support.v4.app.Activity.onCreate(Landroid/os/Bundle;)V"
```

---

## Key Implementation Details

### NameMapper Utility Class

| Method | Purpose |
|--------|---------|
| `isValidIdentifier(String)` | Checks Java identifier rules + reserved words |
| `isValidFullIdentifier(String)` | Package.Class format validation |
| `isValidAndPrintable(String)` | ASCII printable check |
| `removeInvalidChars(String, String prefix)` | Sanitizes names |

Maintains static set of 50+ Java reserved keywords.

### Identifier Validation Rules

```
Valid Java identifier:
- Starts with: letter, underscore, $
- Contains: letter, digit, underscore, $
- NOT reserved keyword or "_"
- All characters ASCII printable (32-126)
```

### Variable Renaming via Mappings

```
Uses Dalvik-to-Java bytecode conversion:
- Local variable table index (LvIndex) mapping
- Register to LvIndex conversion
- Handles instance methods (LvIndex=0 is 'this')
- Handles static methods (LvIndex=0 is first arg)
DalvikToJavaBytecodeUtils: Complex conversion logic
```

### Condition Precedence Logic

```
CombineDeobfConditions.combineFunc() processes conditions in order:
  FORBID_RENAME -> immediate false (highest priority)
  FORCE_RENAME -> mark and continue
  NO_ACTION -> ignore
  Returns: true if any FORCE_RENAME and no FORBID encountered
```

---

## Integration with Rest of JADX

### Visitor Chain

```
1. DeobfuscatorVisitor (early) - apply deobfuscation
2. RenameVisitor (still early) - validate and fix names
3. [Code generation and other visitors]
4. CodeRenameVisitor (decompile phase) - rename code variables
5. SaveDeobfMapping - persist mappings
```

### Node Attributes

| Attribute | Purpose |
|-----------|---------|
| `AFlag.DONT_RENAME` | Skip renaming for specific nodes |
| `AFlag.ANDROID_R_CLASS` | Mark Android R classes |
| `RenameReasonAttr` | Tracks why renaming occurred |
| `METHOD_OVERRIDE` | Marks methods with overrides |

### Input/Output

| Direction | Description |
|-----------|-------------|
| **Input** | Raw DEX/APK with obfuscated names |
| **Output** | Deobfuscated Java code + .jobf mapping file |
| **User can provide** | .jobf mapping, external mapping files |

---

## Performance Considerations

- **DeobfPresets uses HashMap**: O(1) lookups for class/field/method names
- **Index-based generation**: Maintains counters (pkgIndex, clsIndex, etc.)
- **Lazy TLD loading**: Static holder pattern with BufferedReader
- **Condition short-circuiting**: FORBID_RENAME stops evaluation immediately
- **Mapping trees**: Memory-based (MemoryMappingTree) for speed

---

## Configuration Options

### Key JadxArgs Parameters

| Parameter | Purpose |
|-----------|---------|
| `isDeobfuscationOn()` | Enable/disable deobfuscation |
| `getDeobfuscationMinLength()` | Min name length to trigger rename (default: 3) |
| `getDeobfuscationMaxLength()` | Max name length before hash substitution |
| `getDeobfuscationWhitelist()` | Packages/classes to never rename |
| `getAliasProvider()` | Custom IAliasProvider implementation |
| `getRenameCondition()` | Custom IRenameCondition implementation |
| `getGeneratedRenamesMappingFile()` | Override .jobf output location |
| `getGeneratedRenamesMappingFileMode()` | IGNORE, READ_OR_SAVE, SAVE, READ |
| `isRenameValid()` | Enforce Java identifier rules |
| `isRenamePrintable()` | Enforce ASCII printable characters |
| `isFsCaseSensitive()` | Check case-sensitivity in RenameVisitor |
| `getUseSourceNameAsClassNameAlias()` | Use source file for names |

---

## Rust Implementation

### Core Data Structures

```rust
pub struct DeobfPresets {
    pub pkg_map: HashMap<String, String>,
    pub cls_map: HashMap<String, String>,
    pub fld_map: HashMap<String, String>,
    pub mth_map: HashMap<String, String>,
}

pub struct DeobfAliasProvider {
    pub pkg_index: u32,
    pub cls_index: u32,
    pub fld_index: u32,
    pub mth_index: u32,
    pub max_name_length: usize,
}

pub enum RenameAction {
    NoAction,
    ForceRename,
    ForbidRename,
}

pub trait RenameCondition {
    fn should_rename_package(&self, pkg: &PackageInfo) -> RenameAction;
    fn should_rename_class(&self, cls: &ClassInfo) -> RenameAction;
    fn should_rename_field(&self, fld: &FieldInfo) -> RenameAction;
    fn should_rename_method(&self, mth: &MethodInfo) -> RenameAction;
}

pub trait AliasProvider {
    fn for_package(&mut self, pkg: &PackageInfo) -> String;
    fn for_class(&mut self, cls: &ClassInfo) -> String;
    fn for_field(&mut self, fld: &FieldInfo) -> String;
    fn for_method(&mut self, mth: &MethodInfo) -> String;
}
```

### Name Validation

```rust
pub fn is_valid_identifier(name: &str) -> bool {
    if name.is_empty() || RESERVED_KEYWORDS.contains(name) {
        return false;
    }

    let mut chars = name.chars();
    let first = chars.next().unwrap();

    if !first.is_alphabetic() && first != '_' && first != '$' {
        return false;
    }

    chars.all(|c| c.is_alphanumeric() || c == '_' || c == '$')
}

pub fn is_printable(name: &str) -> bool {
    name.chars().all(|c| c as u32 >= 32 && c as u32 <= 126)
}

lazy_static! {
    static ref RESERVED_KEYWORDS: HashSet<&'static str> = {
        let mut s = HashSet::new();
        s.insert("abstract"); s.insert("assert"); s.insert("boolean");
        s.insert("break"); s.insert("byte"); s.insert("case");
        // ... 50+ keywords
        s
    };
}
```

### Mapping File I/O

```rust
impl DeobfPresets {
    pub fn load(path: &Path) -> Result<Self> {
        let mut presets = DeobfPresets::default();
        let file = File::open(path)?;

        for line in BufReader::new(file).lines() {
            let line = line?;
            if line.starts_with('#') || line.is_empty() { continue; }

            let parts: Vec<&str> = line.splitn(3, ' ').collect();
            if parts.len() < 3 || parts[1] != "=" { continue; }

            let (type_char, name, alias) = (parts[0].chars().next(), &parts[0][1..], parts[2]);
            match type_char {
                Some('p') => presets.pkg_map.insert(name.to_string(), alias.to_string()),
                Some('c') => presets.cls_map.insert(name.to_string(), alias.to_string()),
                Some('f') => presets.fld_map.insert(name.to_string(), alias.to_string()),
                Some('m') => presets.mth_map.insert(name.to_string(), alias.to_string()),
                _ => None,
            };
        }
        Ok(presets)
    }

    pub fn save(&self, path: &Path) -> Result<()> {
        let mut file = File::create(path)?;

        for (name, alias) in &self.pkg_map {
            writeln!(file, "p {} = {}", name, alias)?;
        }
        for (name, alias) in &self.cls_map {
            writeln!(file, "c {} = {}", name, alias)?;
        }
        // ... fields, methods
        Ok(())
    }
}
```

---

## Key Files Summary

| File | Lines | Purpose |
|------|-------|---------|
| `DeobfPresets.java` | ~200 | Mapping file I/O |
| `DeobfuscatorVisitor.java` | ~300 | Main deobfuscation |
| `DeobfAliasProvider.java` | ~250 | Name generation |
| `RenameVisitor.java` | ~400 | Name validation |
| `NameMapper.java` | ~150 | Name utilities |
| `JadxRenameConditions.java` | ~100 | Condition builder |
