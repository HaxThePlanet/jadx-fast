# JADX Kotlin Clone Tasks

This document tracks the systematic cloning of JADX's Kotlin handling into Dexterity.
The goal is **exact parity** with JADX's 10+ years of Kotlin decompilation edge cases.

## Reference Source Files

### JADX jadx-core (ProcessKotlinInternals)
```
jadx-fast/jadx-core/src/main/java/jadx/core/dex/visitors/kotlin/ProcessKotlinInternals.java
```

### JADX jadx-kotlin-metadata Plugin
```
jadx-fast/jadx-plugins/jadx-kotlin-metadata/src/main/kotlin/jadx/plugins/kotlin/metadata/
├── KotlinMetadataPlugin.kt          # Plugin entry point
├── KotlinMetadataOptions.kt         # 7 config options
├── model/
│   ├── KotlinMetadataConsts.kt      # Annotation constants
│   └── KotlinRenameResults.kt       # Rename result types
├── pass/
│   ├── KotlinMetadataPreparePass.kt # Class/package rename pass
│   └── KotlinMetadataDecompilePass.kt # Main decompile pass (6 rename functions)
└── utils/
    ├── KotlinMetadataExt.kt         # Annotation parsing extensions
    ├── KotlinMetadataUtils.kt       # mapMethodArgs, mapFields, mapCompanion
    ├── KotlinUtils.kt               # parseToString, findGetters, parseDefaultMethods
    ├── KmClassWrapper.kt            # KmClass wrapper
    ├── KmExt.kt                     # shortId extensions
    ├── ToStringParser.kt            # StringBuilder bytecode analysis
    └── LogExt.kt                    # Logging utilities
```

### JADX jadx-kotlin-source-debug-extension Plugin (SMAP)
```
jadx-fast/jadx-plugins/jadx-kotlin-source-debug-extension/src/main/kotlin/jadx/plugins/kotlin/smap/
├── KotlinSmapPlugin.kt              # Plugin entry point
├── KotlinSmapOptions.kt             # Config options
├── model/
│   ├── SMAP.kt                      # SMAP data model + FileMapping, RangeMapping
│   ├── ClassAliasRename.kt          # Rename result type
│   ├── Constants.kt                 # Annotation constant
│   └── SourceInfo.kt                # Source file info
├── pass/
│   └── KotlinSourceDebugExtensionPass.kt # Class/package rename pass
└── utils/
    ├── SMAPParser.kt                # JSR-045 SMAP format parser
    ├── KotlinSmapUtils.kt           # getClassAlias, splitAndCheckClsName
    └── Extensions.kt                # getSourceDebugExtension extension
```

### Dexterity Current Kotlin Support
```
crates/dexterity-kotlin/src/
├── lib.rs                           # process_kotlin_metadata()
├── parser.rs                        # Protobuf parsing, BitEncoding
├── extractor.rs                     # apply_kotlin_names, getter recognition
├── types.rs                         # KotlinClassMetadata, KotlinFunction, etc.
├── tostring_parser.rs               # StringBuilder bytecode analysis
└── visitor.rs                       # KotlinAwareCondition

crates/dexterity-passes/src/
└── kotlin_intrinsics.rs             # Intrinsics variable name extraction
```

---

## Gap Analysis Summary

| Feature | JADX | Dexterity | Status |
|---------|------|-----------|--------|
| **ProcessKotlinInternals** | Full | Partial | 85% |
| **Metadata Protobuf Parsing** | kotlinx.metadata | Custom prost | 90% |
| **Class Alias (d2)** | Full | Full | 100% |
| **Method Args Rename** | Full | Full | 100% |
| **Field Rename** | Full | Full | 100% |
| **Companion Rename** | Full | Partial | 70% |
| **Data Class Flag** | Full | Full | 100% |
| **ToString Field Rename** | Full | Full | 95% |
| **Getter Recognition** | Full | Partial | 60% |
| **SMAP Support** | Full | Missing | 0% |
| **Default Method Rename** | Full | Missing | 0% |
| **Hide Intrinsics Option** | Full | Missing | 0% |
| **Rename Reason Tracking** | Full | Missing | 0% |

---

## P1 - Critical Missing Features

### P1.1: Clone SMAP Parser
**Source:** `jadx-kotlin-source-debug-extension/src/main/kotlin/jadx/plugins/kotlin/smap/utils/SMAPParser.kt`
**Target:** `crates/dexterity-kotlin/src/smap_parser.rs` (new file)

JADX has full JSR-045 SMAP (Source Map) format support. This is critical for:
- Kotlin multifile classes
- Inline functions
- Lambda source mapping

```kotlin
// JADX Reference: SMAPParser.kt:24-116
object SMAPParser {
    fun parseOrNull(mappingInfo: String): SMAP? =
        if (mappingInfo.isNotEmpty()) {
            parseStratum(mappingInfo, KOTLIN_STRATA_NAME, parseStratum(mappingInfo, KOTLIN_DEBUG_STRATA_NAME, null))
        } else {
            null
        }
    // ... tokenizer and parseStratum logic
}
```

**Clone Task:**
1. Create `smap_parser.rs` with `SMAPTokenizer` and `parse_stratum()` logic
2. Handle FILE_SECTION (`*F`), LINE_SECTION (`*L`), STRATA_SECTION (`*S`), END (`*E`)
3. Parse line mappings: `<source>#<file>,<sourceRange>:<dest>,<destMultiplier>`

---

### P1.2: Clone SMAP Data Model
**Source:** `jadx-kotlin-source-debug-extension/src/main/kotlin/jadx/plugins/kotlin/smap/model/SMAP.kt`
**Target:** `crates/dexterity-kotlin/src/smap_types.rs` (new file)

```kotlin
// JADX Reference: SMAP.kt:16-78
class SMAP(val fileMappings: List<FileMapping>) {
    fun findRange(lineNumber: Int): RangeMapping?
}

class FileMapping(val name: String, val path: String) {
    val lineMappings = arrayListOf<RangeMapping>()
    fun mapNewInterval(source: Int, dest: Int, range: Int, callSite: SourcePosition? = null): RangeMapping
}

data class RangeMapping(
    val source: Int, val dest: Int, var range: Int,
    val callSite: SourcePosition?, val parent: FileMapping
) {
    fun mapDestToSource(destLine: Int): SourcePosition
    fun mapSourceToDest(sourceLine: Int): Int
}
```

**Clone Task:**
1. Create `smap_types.rs` with `SMAP`, `FileMapping`, `RangeMapping` structs
2. Implement `findRange()` with binary search
3. Implement line mapping functions

---

### P1.3: Clone SourceDebugExtension Pass
**Source:** `jadx-kotlin-source-debug-extension/src/main/kotlin/jadx/plugins/kotlin/smap/pass/KotlinSourceDebugExtensionPass.kt`
**Target:** Add to `crates/dexterity-kotlin/src/lib.rs` or new pass

```kotlin
// JADX Reference: KotlinSourceDebugExtensionPass.kt:23-37
override fun init(root: RootNode) {
    if (options.isClassAliasSourceDbg) {
        for (cls in root.classes) {
            if (cls.contains(AFlag.DONT_RENAME)) {
                continue
            }
            val kotlinCls = KotlinSmapUtils.getClassAlias(cls)
            if (kotlinCls != null) {
                cls.rename(kotlinCls.name)
                cls.packageNode.rename(kotlinCls.pkg)
            }
        }
    }
}
```

**Clone Task:**
1. Parse `@kotlin.jvm.internal.SourceDebugExtension` annotation
2. Extract class alias from SMAP first file mapping
3. Apply class/package rename

---

## P2 - Important Missing Features

### P2.1: Clone Getter Recognition
**Source:** `jadx-kotlin-metadata/src/main/kotlin/jadx/plugins/kotlin/metadata/utils/KotlinUtils.kt:25-44`
**Target:** Improve `crates/dexterity-kotlin/src/extractor.rs`

```kotlin
// JADX Reference: KotlinUtils.kt:25-44
fun findGetters(cls: ClassNode): List<MethodRename> {
    return cls.fields.filter(FieldNode::isInstance).mapNotNull { field ->
        val mth = getFieldGetterMethod(cls, field.fieldInfo) ?: return@mapNotNull null
        MethodRename(mth = mth, alias = getGetterAlias(field.alias))
    }
}

private fun getFieldGetterMethod(cls: ClassNode, field: FieldInfo): MethodNode? {
    return cls.methods.firstOrNull {
        it.returnType == field.type &&
            it.argTypes.isEmpty() &&
            it.insnsCount == 3 &&               // <-- EXACT COUNT CHECK
            it.sVars.size == 2 &&               // <-- EXACT SVAR COUNT
            (it.sVars[1].assignInsn as? IndexInsnNode)?.index == field
    }
}

private fun getGetterAlias(fieldAlias: String): String {
    val capitalized = fieldAlias.replaceFirstChar {
        if (it.isLowerCase()) it.titlecase(Locale.ROOT) else it.toString()
    }
    return "get$capitalized"
}
```

**Clone Task:**
1. Add `insnsCount == 3` check to getter detection
2. Add SSA variable count check (sVars.size == 2)
3. Verify assignment instruction matches field

---

### P2.2: Clone Default Method Renaming
**Source:** `jadx-kotlin-metadata/src/main/kotlin/jadx/plugins/kotlin/metadata/utils/KotlinUtils.kt:53-89`
**Target:** New function in `crates/dexterity-kotlin/src/extractor.rs`

Kotlin generates `$default` suffix methods for functions with default parameters.

```kotlin
// JADX Reference: KotlinUtils.kt:53-89
fun parseDefaultMethods(cls: ClassNode): List<MethodRename> {
    val possibleMthList = cls.methods.filter {
        it.accessFlags.isStatic && it.accessFlags.isSynthetic &&
            it.argTypes.run {
                size > 3 &&
                    first().isObject && first().`object` == cls.fullName &&
                    get(size - 2).isPrimitive && get(size - 2).primitiveType == PrimitiveType.INT &&
                    last().isObject && last().`object` == Consts.CLASS_OBJECT
            }
    }
    // ... dominator analysis to find original method
}

private fun getDefaultMethodAlias(alias: String): String {
    return "$alias\$default"
}
```

**Clone Task:**
1. Detect synthetic static methods with default parameter signature pattern
2. Use dominator analysis to find original method
3. Rename to `originalName$default`

---

### P2.3: Clone Companion Hide Logic
**Source:** `jadx-kotlin-metadata/src/main/kotlin/jadx/plugins/kotlin/metadata/pass/KotlinMetadataDecompilePass.kt:71-88`
**Target:** Enhance companion handling in `crates/dexterity-kotlin/src/extractor.rs`

```kotlin
// JADX Reference: KotlinMetadataDecompilePass.kt:71-88
private fun renameCompanion(wrapper: KmClassWrapper) {
    val companion = wrapper.getCompanion()
    companion?.run {
        // ... rename field/class to "INSTANCE"/"Companion" ...

        if (hide) {
            field.add(AFlag.DONT_GENERATE)
            cls.add(AFlag.DONT_GENERATE)
            cls.add(AFlag.DONT_INLINE)
        }
    }
}
```

And the hide detection logic:

```kotlin
// JADX Reference: KotlinMetadataUtils.kt:118-141
fun mapCompanion(cls: ClassNode, kmCls: KmClass): CompanionRename? {
    // ...
    val isOnlyInit = compField.useIn.size == 1 && compField.useIn[0].methodInfo.isClassInit
    val isEmpty = compCls.run { methods.all { it.isConstructor } && fields.isEmpty() }
    return CompanionRename(field = compField, cls = compCls, hide = isOnlyInit && isEmpty)
}
```

**Clone Task:**
1. Track field use-sites to detect "only used in <clinit>"
2. Check if companion class is empty (only constructors, no fields)
3. Add `DONT_GENERATE` flag when `hide = true`

---

### P2.4: Clone Package Part Counting
**Source:** `jadx-kotlin-metadata/src/main/kotlin/jadx/plugins/kotlin/metadata/utils/KotlinMetadataUtils.kt:77-90`
**Target:** Add validation to class alias logic

```kotlin
// JADX Reference: KotlinMetadataUtils.kt:77-90
private fun countPkgParts(pkg: String): Int {
    if (pkg.isEmpty()) return 0
    var count = 1
    var pos = 0
    while (true) {
        pos = pkg.indexOf('.', pos)
        if (pos == -1) return count
        pos++
        count++
    }
}

// Used in validation:
if (countPkgParts(originClsInfo.getPackage()) != countPkgParts(pkg) || pkg.startsWith("java.")) {
    return null
}
```

**Clone Task:**
1. Add `count_pkg_parts()` helper function
2. Validate package part count matches when renaming classes
3. Reject renames that would change package depth

---

## P3 - Parity Improvements

### P3.1: Clone Hide Intrinsics Option
**Source:** `jadx-core/src/main/java/jadx/core/dex/visitors/kotlin/ProcessKotlinInternals.java:134-136`
**Target:** `crates/dexterity-passes/src/kotlin_intrinsics.rs`

```java
// JADX Reference: ProcessKotlinInternals.java:134-136
if (renamed && hideInsns) {
    insn.add(AFlag.DONT_GENERATE);
}
```

**Clone Task:**
1. Add `hide_intrinsics` option to Dexterity CLI args
2. Mark intrinsics invoke instructions with `DontGenerate` flag when enabled
3. Honor flag in codegen to skip instruction output

---

### P3.2: Clone RenameReasonAttr Tracking
**Source:** Throughout JADX kotlin passes
**Target:** Add to IR attributes

```kotlin
// JADX Reference pattern:
RenameReasonAttr.forNode(field).append("from kotlin metadata")
RenameReasonAttr.forNode(cls).append("from toString")
RenameReasonAttr.forNode(mth).append("from getter")
```

**Clone Task:**
1. Add `rename_reason: Option<String>` to ClassData, MethodData, FieldData
2. Set reason when applying Kotlin renames
3. Include in decompiled output as comments (optional)

---

### P3.3: Clone JADX Options System
**Source:** `jadx-kotlin-metadata/src/main/kotlin/jadx/plugins/kotlin/metadata/KotlinMetadataOptions.kt`
**Target:** Extend CLI args

```kotlin
// JADX Reference: KotlinMetadataOptions.kt:6-76
class KotlinMetadataOptions : BasePluginOptionsBuilder() {
    var isClassAlias: Boolean = true
    var isMethodArgs: Boolean = true
    var isFields: Boolean = true
    var isCompanion: Boolean = true
    var isDataClass: Boolean = true
    var isToString: Boolean = true
    var isGetters: Boolean = true
}
```

**Clone Task:**
1. Add equivalent CLI flags: `--kotlin-class-alias`, `--kotlin-method-args`, etc.
2. Default all to `true` (matching JADX defaults)
3. Wire options into `process_kotlin_metadata()` calls

---

## Implementation Order

1. **P1.1-P1.3 (SMAP)** - Critical for Kotlin multifile/inline support
2. **P2.1 (Getter Recognition)** - Improves code readability
3. **P2.2 (Default Methods)** - Fixes method naming for default params
4. **P2.3 (Companion Hide)** - Cleaner output for empty companions
5. **P2.4 (Pkg Validation)** - Prevents invalid renames
6. **P3.1-P3.3 (Options/Tracking)** - Feature parity polish

---

## Testing Strategy

For each clone task:
1. Find JADX test cases in `jadx-fast/jadx-core/src/test/java/jadx/tests/integration/`
2. Create equivalent Dexterity integration test
3. Compare output against JADX baseline
4. Add edge cases found in JADX issue tracker

### Key Test Files:
```
jadx-fast/jadx-plugins/jadx-kotlin-metadata/src/test/kotlin/TestKotlinMetadata.kt
jadx-fast/jadx-plugins/jadx-kotlin-source-debug-extension/src/test/kotlin/TestSourceDebugExtension.kt
```

---

## Progress Tracking

- [x] P1.1: Clone SMAP Parser (`smap_parser.rs` - 250+ lines, 13 tests)
- [x] P1.2: Clone SMAP Data Model (`smap_types.rs` - 270+ lines)
- [x] P1.3: Clone SourceDebugExtension Pass (integrated into `lib.rs`, ~100 lines)
- [x] P2.1: Clone Getter Recognition (`find_getters_jadx_style()` - exact 3-insn + field_idx check)
- [x] P2.2: Clone Default Method Renaming (`find_default_methods_jadx_style()` - $default suffix)
- [x] P2.3: Clone Companion Hide Logic (`analyze_companion_for_hiding()`, `rename_companion_jadx_style()`)
- [x] P2.4: Clone Package Part Counting (integrated into SMAP class alias validation)
- [ ] P3.1: Clone Hide Intrinsics Option
- [ ] P3.2: Clone RenameReasonAttr Tracking
- [ ] P3.3: Clone JADX Options System

---

*Document created: 2025-12-23*
*Last updated: 2025-12-23*
