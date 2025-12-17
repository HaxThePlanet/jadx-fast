# JADX Variable Naming System

This document describes the variable naming system used in JADX, based on analysis of the jadx-fast reference implementation. Understanding this system is essential for achieving parity with JADX's decompiled output.

## Overview

JADX uses a multi-stage pipeline to assign meaningful names to variables in decompiled code:

1. **Debug Info Application** - Apply names from bytecode debug symbols (if available)
2. **Intelligent Name Guessing** - Derive names from types and usage patterns
3. **Name Generation** - Assign unique names with collision handling during code generation
4. **Validation** - Ensure all names are valid Java identifiers

The system prioritizes debug info names when available, falls back to type-based naming, and ensures uniqueness through numeric suffixes.

---

## Core Data Structures

### Named Interface
**File:** `jadx-core/src/main/java/jadx/core/dex/instructions/args/Named.java`

Simple contract for objects that have names:
```java
public interface Named {
    String getName();
    void setName(String name);
}
```

### CodeVar
**File:** `jadx-core/src/main/java/jadx/core/dex/instructions/args/CodeVar.java`

High-level representation of a code variable (local variable, parameter, or field):
- `String name` - The variable's assigned name
- `ArgType type` - Variable type
- `List<SSAVar> ssaVars` - SSA variables linked to this CodeVar
- `boolean isDeclared` - Whether variable is used in code
- `boolean isFinal` - Final modifier
- `boolean isThis` - Special "this" reference

### SSAVar
**File:** `jadx-core/src/main/java/jadx/core/dex/instructions/args/SSAVar.java`

Static Single Assignment form variable - bridges bytecode registers to high-level variables:
- `int regNum` - Register number from bytecode
- `int version` - SSA version number
- `CodeVar codeVar` - Associated high-level variable

Name access delegates to CodeVar:
```java
public String getName() {
    return codeVar.getName();
}
public void setName(String name) {
    codeVar.setName(name);
}
```

### RegisterArg
**File:** `jadx-core/src/main/java/jadx/core/dex/instructions/args/RegisterArg.java`

Represents a register argument in bytecode instructions. Implements `Named` interface.

Special constants:
```java
public static final String THIS_ARG_NAME = "this";
public static final String SUPER_ARG_NAME = "super";
```

---

## Name Generation Engine (NameGen)

**File:** `jadx-core/src/main/java/jadx/core/codegen/NameGen.java`

The core class responsible for assigning unique variable names during code generation.

### Key Methods

#### `assignArg(CodeVar var)`
Main entry point for assigning names to variables:
```java
public String assignArg(CodeVar var) {
    if (fallback) {
        return getFallbackName(var);
    }
    if (var.isThis()) {
        return RegisterArg.THIS_ARG_NAME;
    }
    String name = getUniqueVarName(makeArgName(var));
    var.setName(name);
    return name;
}
```

#### `getUniqueVarName(String name)`
Ensures name uniqueness by appending numeric suffixes:
```java
private String getUniqueVarName(String name) {
    String r = name;
    int i = 2;
    while (varNames.contains(r)) {
        r = name + i;
        i++;
    }
    varNames.add(r);
    return r;
}
```

Example: `str` → `str2` → `str3` → ...

#### `getFallbackName(CodeVar var)`
Generates register-based names when in fallback mode:
```java
private String getFallbackName(RegisterArg arg) {
    return "r" + arg.getRegNum();
}
```

Results in: `r0`, `r1`, `r2`, etc.

### Initialization

NameGen initializes by reserving names that could cause collisions:
- Static field names from the parent class
- Inner class names
- Root package names (to avoid collisions with fully-qualified class names)

```java
private void addNamesUsedInClass() {
    ClassNode parentClass = mth.getParentClass();
    for (FieldNode field : parentClass.getFields()) {
        if (field.isStatic()) {
            varNames.add(field.getAlias());
        }
    }
    for (ClassNode innerClass : parentClass.getInnerClasses()) {
        varNames.add(innerClass.getClassInfo().getAliasShortName());
    }
    varNames.addAll(mth.root().getCacheStorage().getRootPkgs());
}
```

---

## Type-Based Naming (ApplyVariableNames)

**File:** `jadx-core/src/main/java/jadx/core/dex/visitors/ApplyVariableNames.java`

This visitor derives meaningful variable names from types and usage patterns when debug info is unavailable.

### Object Type Aliases

Common types have predefined short aliases:

| Full Type | Alias |
|-----------|-------|
| `java.lang.String` | `str` |
| `java.lang.Class` | `cls` |
| `java.lang.Throwable` | `th` |
| `java.lang.Object` | `obj` |
| `java.util.Iterator` | `it` |
| `java.util.HashMap` | `map` |
| `java.lang.Boolean` | `bool` |
| `java.lang.Integer` | `num` |
| `java.lang.StringBuilder` | `sb` |
| `java.lang.Exception` | `exc` |

### Primitive Type Naming

Primitive types use their short name in lowercase:
- `int` → `i`
- `boolean` → `z`
- `byte` → `b`
- `double` → `d`
- `long` → `l`
- `float` → `f`

### Array Naming

Arrays append "Arr" suffix to the element type name:
- `int[]` → `iArr`
- `String[]` → `strArr`
- `byte[][]` → `bArrArr`

### Class-Based Naming

For class types without aliases:
```java
private String makeNameForCheckedClass(ClassInfo classInfo) {
    String shortName = classInfo.getAliasShortName();
    // ... validation ...
    return fromName(shortName);
}

private String fromName(String name) {
    if (name.length() < 3) {
        return name.toLowerCase() + "Var";  // "OK" → "okVar"
    }
    if (isAllUpper(name)) {
        return name.toLowerCase();  // "HTTP" → "http"
    }
    return Character.toLowerCase(name.charAt(0)) + name.substring(1);  // "MyClass" → "myClass"
}
```

### Method-Based Naming

Names can be derived from method calls:

```java
private String makeNameFromInvoke(SSAVar ssaVar, InvokeNode inv) {
    String mthName = inv.getCallMth().getName();

    // Special cases
    if (mthName.equals("getInstance")) {
        return makeNameForObject(inv.getCallMth().getDeclClass().getType());
    }
    if (mthName.equals("iterator")) {
        return "it";
    }
    if (mthName.equals("toString")) {
        return makeObjName(inv);
    }

    // Strip common prefixes
    String name = cutPrefix(mthName);
    if (name != null) {
        return fromName(name);
    }
    return makeNameForType(ssaVar.getTypeInfo().getType());
}
```

**Recognized method prefixes:** `get`, `set`, `to`, `parse`, `read`, `format`

Examples:
- `getName()` → `name`
- `getUserId()` → `userId`
- `parseDate()` → `date`
- `Cipher.getInstance()` → `cipher`

---

## Debug Info Integration

**File:** `jadx-core/src/main/java/jadx/core/dex/visitors/debuginfo/DebugInfoApplyVisitor.java`

This visitor applies debug information from compiled bytecode to variables.

### Debug Info Sources

1. **RegDebugInfoAttr** - Attached to individual register assignments
2. **LocalVarsDebugInfoAttr** - Local variable table with offset ranges
3. **MethodParametersAttr** - Named method parameters

### Application Priority

Debug info names are validated before use:
```java
if (NameMapper.isValidAndPrintable(varName)) {
    ssaVar.setName(varName);
}
```

### Phi Instruction Handling

When multiple SSA variables merge at phi instructions:
- If all incoming names are identical → use that name
- Otherwise → use the first name and log a debug comment

---

## Name Validation (NameMapper)

**File:** `jadx-core/src/main/java/jadx/core/deobf/NameMapper.java`

Validates that names are legal Java identifiers.

### Validation Methods

#### `isReserved(String str)`
Checks against Java reserved keywords:
```java
private static final Set<String> RESERVED_WORDS = Set.of(
    "abstract", "assert", "boolean", "break", "byte", "case", "catch",
    "char", "class", "const", "continue", "default", "do", "double",
    "else", "enum", "extends", "false", "final", "finally", "float",
    "for", "goto", "if", "implements", "import", "instanceof", "int",
    "interface", "long", "native", "new", "null", "package", "private",
    "protected", "public", "return", "short", "static", "strictfp",
    "super", "switch", "synchronized", "this", "throw", "throws",
    "transient", "true", "try", "void", "volatile", "while"
);
```

#### `isValidIdentifier(String str)`
- Non-empty
- Not a reserved keyword
- Matches Java identifier pattern: `\p{javaJavaIdentifierStart}\p{javaJavaIdentifierPart}*`

#### `isValidAndPrintable(String str)`
Most restrictive check - valid identifier AND all characters are printable ASCII (32-126):
```java
public static boolean isAllCharsPrintable(String str) {
    for (int i = 0; i < str.length(); i++) {
        char c = str.charAt(i);
        if (c < 32 || c > 126) {
            return false;
        }
    }
    return true;
}
```

#### `removeInvalidChars(String name, String prefix)`
Sanitizes names by removing unprintable characters and prepending a prefix if the first character is invalid.

---

## Collision Handling

### Within Methods

NameGen maintains a `Set<String>` of used names and appends numeric suffixes:
- First occurrence: `str`
- Second occurrence: `str2`
- Third occurrence: `str3`
- etc.

### Reserved Names

Names are reserved to prevent collisions with:
1. Static fields in the current class
2. Inner class names
3. Root package names (prevents collision with fully-qualified class names)

### Test Examples

From `TestConstructorArgNames.java`:
- Parameter `str` collides with field `str` → parameter keeps `str`, field uses qualified access
- Parameter `STR` collides with static field `STR` → parameter renamed to `STR2`

From `TestDuplicatedNames.java`:
- Field `fieldName` (duplicate) → renamed to `f0fieldName`
- Method `run()` (duplicate signature) → renamed to `m0run()`

---

## Configuration Options

**File:** `jadx-core/src/main/java/jadx/api/JadxArgs.java`

### Fallback Mode
```java
private boolean fallbackMode = false;
```
When true, uses register-based naming (`r0`, `r1`, etc.) instead of meaningful names.

### Debug Info
```java
private boolean debugInfo = true;
```
Controls whether debug information is applied to variables.

### Deobfuscation Settings
```java
private boolean deobfuscationOn = false;
private int deobfuscationMinLength = 3;
private int deobfuscationMaxLength = 64;
```
Control automatic renaming of obfuscated names.

### Kotlin Method Names
```java
public enum UseKotlinMethodsForVarNames {
    DISABLE, APPLY, APPLY_AND_HIDE
}
private UseKotlinMethodsForVarNames useKotlinMethodsForVarNames = APPLY;
```
Controls whether Kotlin metadata is used for variable naming.

### Rename Flags
```java
public enum RenameEnum {
    CASE,      // Rename for case sensitivity issues
    VALID,     // Rename invalid identifiers
    PRINTABLE  // Rename unprintable names
}
private Set<RenameEnum> renameFlags = EnumSet.allOf(RenameEnum.class);
```

---

## Name Assignment Flow

Complete pipeline from bytecode to output:

```
1. Parse bytecode
   └─> RegisterArg created for each register usage

2. SSA transformation
   └─> RegisterArg → SSAVar (with version numbers)

3. Variable processing (ProcessVariables visitor)
   └─> SSAVar → CodeVar (merges related SSA vars)

4. Debug info application (DebugInfoApplyVisitor)
   └─> Apply names from RegDebugInfoAttr, LocalVarsDebugInfoAttr

5. Name guessing (ApplyVariableNames visitor)
   └─> Derive names from types/usage if no debug name

6. Code generation (MethodGen)
   └─> Create NameGen for method
   └─> assignArg(CodeVar) ensures uniqueness
   └─> Final name set on CodeVar

7. Output
   └─> Variable declarations and usages written with final names
```

---

## Key Files Reference

| File | Purpose |
|------|---------|
| `jadx-core/src/main/java/jadx/core/codegen/NameGen.java` | Core name generation and uniqueness |
| `jadx-core/src/main/java/jadx/core/deobf/NameMapper.java` | Name validation (Java identifiers, reserved words) |
| `jadx-core/src/main/java/jadx/core/dex/visitors/ApplyVariableNames.java` | Intelligent name guessing from types/usage |
| `jadx-core/src/main/java/jadx/core/dex/instructions/args/CodeVar.java` | High-level variable representation |
| `jadx-core/src/main/java/jadx/core/dex/instructions/args/SSAVar.java` | SSA form variable |
| `jadx-core/src/main/java/jadx/core/dex/instructions/args/RegisterArg.java` | Low-level register representation |
| `jadx-core/src/main/java/jadx/core/dex/visitors/debuginfo/DebugInfoApplyVisitor.java` | Debug info application |
| `jadx-core/src/main/java/jadx/core/codegen/MethodGen.java` | Integration point: uses NameGen |
| `jadx-core/src/main/java/jadx/api/JadxArgs.java` | Configuration options |
| `jadx-core/src/main/java/jadx/core/utils/BetterName.java` | Name quality comparison utility |

---

## Implementation Notes for Dexterity

To achieve parity with JADX variable naming:

1. **Implement NameGen equivalent** - Track used names per method, append numeric suffixes for collisions
2. **Type-based naming** - Use the same alias map and naming conventions
3. **Debug info support** - Parse and apply LocalVariableTable attributes
4. **Validation** - Reject reserved keywords and non-printable characters
5. **Method prefix stripping** - Recognize `get`, `set`, `parse`, etc.
6. **Fallback mode** - Support register-based naming (`r0`, `r1`, etc.)
