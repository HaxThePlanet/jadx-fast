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
    ├── KmExt.kt                     # shortId extensions (signature property)
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
├── smap_parser.rs                   # SMAP parser (cloned from JADX)
├── smap_types.rs                    # SMAP data model (cloned from JADX)
└── visitor.rs                       # KotlinAwareCondition

crates/dexterity-passes/src/
└── kotlin_intrinsics.rs             # Intrinsics variable name extraction
```

---

## Gap Analysis Summary (Updated 2025-12-23)

| Feature | JADX Source | Dexterity | Status |
|---------|-------------|-----------|--------|
| **ProcessKotlinInternals** | ProcessKotlinInternals.java | kotlin_intrinsics.rs | 90% ⚠️ |
| **Metadata Protobuf Parsing** | kotlinx.metadata library | Custom prost | 80% ⚠️ |
| **Class Alias (d2)** | KotlinMetadataUtils.kt | lib.rs + extractor.rs | 90% ⚠️ |
| **Method Args Rename** | KotlinMetadataUtils.kt:93-108 | extractor.rs | 85% ⚠️ |
| **Field Rename** | KotlinMetadataUtils.kt:111-115 | extractor.rs | 85% ⚠️ |
| **Companion Rename** | KotlinMetadataUtils.kt:118-141 | extractor.rs | 70% ⚠️ |
| **Data Class Flag** | KmClassWrapper.kt:24 | extractor.rs | 100% ✅ |
| **ToString Field Rename** | ToStringParser.kt | tostring_parser.rs | 85% ⚠️ |
| **Getter Recognition** | KotlinUtils.kt:25-44 | extractor.rs | 100% ✅ |
| **SMAP Support** | SMAPParser.kt + SMAP.kt | smap_parser.rs + smap_types.rs | 100% ✅ |
| **Default Method Rename** | KotlinUtils.kt:53-89 | extractor.rs | 100% ✅ |
| **Hide Intrinsics Option** | ProcessKotlinInternals.java:76 | KotlinIntrinsicsOptions | 100% ✅ |
| **Rename Reason Tracking** | RenameReasonAttr | rename_reasons: Vec<String> | 100% ✅ |
| **JADX Options System** | KotlinMetadataOptions.kt | KotlinProcessingOptions | 100% ✅ |
| **AFlag Integration** | AFlag.DONT_RENAME etc | No flag system | 60% ⚠️ |
| **BlockUtils Path Simplify** | BlockUtils.buildSimplePath | No block utils | 0% ❌ |

---

## P0 - Critical Missing Features (MUST FIX)

### P0.1: Clone JVM Method/Field Signature Extraction
**Source:** `jadx-kotlin-metadata/src/main/kotlin/jadx/plugins/kotlin/metadata/utils/KmExt.kt`
**Target:** `crates/dexterity-kotlin/src/parser.rs`

**CRITICAL GAP:** Dexterity uses simplified signatures, not actual JVM signatures.

```kotlin
// JADX Reference: KmExt.kt:4-5
import kotlin.metadata.jvm.signature

inline val KmFunction.shortId: String? get() = signature?.toString()
inline val KmProperty.shortId: String? get() = fieldSignature?.toString()
```

The `signature` property returns `JvmMethodSignature` with format `"methodName(Ljava/lang/String;)V"`.

**Current Dexterity (WRONG):**
```rust
// parser.rs:790-792
let jvm_signature = format!("{}()", name);  // WRONG: Missing param/return types!

// parser.rs:813-814
let jvm_field_signature = name.clone();     // WRONG: Just the name, no type!
```

**Clone Task:**
1. Parse JVM proto extensions from Kotlin metadata protobuf
2. Extract `JvmMethodSignature` and `JvmFieldSignature` from extensions 100-18999
3. Use full JVM signature for `searchMethodByShortId()` equivalent matching
4. This requires understanding the protobuf extension format used by kotlinx.metadata

**Why Critical:** Without proper JVM signatures, method/field matching is unreliable. JADX's
`cls.searchMethodByShortId(kmFunction.shortId)` uses the full signature for precise matching.

---

### P0.2: Clone Class Alias Collision Check
**Source:** `jadx-kotlin-metadata/src/main/kotlin/jadx/plugins/kotlin/metadata/utils/KotlinMetadataUtils.kt:68-71`
**Target:** `crates/dexterity-kotlin/src/extractor.rs`

**CRITICAL GAP:** Dexterity doesn't check if target alias name already exists.

```kotlin
// JADX Reference: KotlinMetadataUtils.kt:68-71
val newClsNode = originCls.root().resolveClass(fullClsName)
return if (newClsNode != null) {
    // class with alias name already exist
    null  // Return null to prevent rename
} else {
    ClassAliasRename(pkg, name)
}
```

**Clone Task:**
1. Before applying a class alias, check if a class with that name already exists
2. If collision detected, skip the rename
3. This prevents class name conflicts that could break compilation

---

### P0.3: Clone Kotlin Metadata Kinds 4 & 5
**Source:** kotlinx.metadata library
**Target:** `crates/dexterity-kotlin/src/parser.rs`

**CRITICAL GAP:** MultiFileClassFacade and MultiFileClassPart return errors.

```rust
// parser.rs:471 - Current code
_ => Err(anyhow!("Unsupported Kotlin metadata kind: {}", annot.kind)),
```

Kotlin metadata kinds:
- 1: Class
- 2: File Facade (package-level functions)
- 3: Synthetic Class (lambdas)
- 4: **MultiFileClassFacade** (NOT IMPLEMENTED)
- 5: **MultiFileClassPart** (NOT IMPLEMENTED)

**Clone Task:**
1. Implement `parse_multifile_class_facade_metadata()` for kind=4
2. Implement `parse_multifile_class_part_metadata()` for kind=5
3. Handle the `@file:JvmMultifileClass` and `@file:JvmName` annotations

---

## P1 - Important Missing Features

### P1.1: Complete Companion Object Hiding
**Source:** `jadx-kotlin-metadata/src/main/kotlin/jadx/plugins/kotlin/metadata/pass/KotlinMetadataDecompilePass.kt:71-88`
**Target:** `crates/dexterity-kotlin/src/lib.rs:481-483`

**GAP:** Analysis is done but flags are never applied.

```kotlin
// JADX Reference: KotlinMetadataDecompilePass.kt:84-88
if (hide) {
    field.add(AFlag.DONT_GENERATE)
    cls.add(AFlag.DONT_GENERATE)
    cls.add(AFlag.DONT_INLINE)
}
```

**Current Dexterity (INCOMPLETE):**
```rust
// lib.rs:481-482
// Note: To fully implement hiding, we would need to add DONT_GENERATE flags
// to both the companion field and the companion inner class
```

**Clone Task:**
1. After `analyze_companion_for_hiding()` returns `should_hide: true`
2. Add `AFlag::DontGenerate` to companion field
3. Add `AFlag::DontGenerate` to companion inner class
4. Add `AFlag::DontInline` to companion inner class

---

### P1.2: Clone ToString Arrays.toString() Handling
**Source:** `jadx-kotlin-metadata/src/main/kotlin/jadx/plugins/kotlin/metadata/utils/ToStringParser.kt:66-74`
**Target:** `crates/dexterity-kotlin/src/tostring_parser.rs`

**GAP:** Rare case of `Arrays.toString(...)` formatting not handled.

```kotlin
// JADX Reference: ToStringParser.kt:66-74
// string formatted argument, for rare cases like Arrays.toString(...)
if (assign is InvokeNode && assign.invokeType == InvokeType.STATIC && assign.argsCount == 1) {
    val prevArg = assign.getArg(0)
    if (prevArg.isRegister && prevArg is RegisterArg) {
        if (prevArg.sVar.assignInsn is IndexInsnNode) {
            val info: FieldInfo? = (prevArg.sVar.assignInsn as IndexInsnNode).index as? FieldInfo
            handleFieldInfo(requireNotNull(info) { "Failed to get nested FieldInfo from index" })
        }
    }
}
```

**Clone Task:**
1. In `handle_append()`, check if register source is a static invoke with 1 arg
2. If so, trace through the invoke's argument to find the original field
3. Handle `Arrays.toString(field)` pattern for array fields

---

### P1.3: Clone Intrinsics SGET Constant Revert
**Source:** `jadx-core/src/main/java/jadx/core/dex/visitors/kotlin/ProcessKotlinInternals.java:159-169`
**Target:** `crates/dexterity-passes/src/kotlin_intrinsics.rs`

**GAP:** When a string constant is inlined from a static field, JADX reverts it.

```java
// JADX Reference: ProcessKotlinInternals.java:159-169
if (insnType == InsnType.SGET) {
    // revert const field inline :(
    FieldInfo fieldInfo = (FieldInfo) ((IndexInsnNode) constInsn).getIndex();
    FieldNode fieldNode = mth.root().resolveField(fieldInfo);
    if (fieldNode != null) {
        String str = (String) fieldNode.get(JadxAttrType.CONSTANT_VALUE).getValue();
        InsnArg newArg = InsnArg.wrapArg(new ConstStringNode(str));
        insn.replaceArg(strArg, newArg);
        return str;
    }
}
```

**Clone Task:**
1. Detect when string argument comes from SGET (static field get)
2. Resolve the static field to find its constant value
3. Extract the string constant from the field's CONSTANT_VALUE attribute

---

## P2 - Minor Gaps (Polish)

### P2.1: Package Part Count Validation for SMAP
**Source:** `jadx-kotlin-metadata/src/main/kotlin/jadx/plugins/kotlin/metadata/utils/KotlinMetadataUtils.kt:77-90`

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

**Status:** Partially implemented in SMAP alias validation.

---

### P2.2: Clone BlockUtils.buildSimplePath for ToString Parsing
**Source:** `jadx-kotlin-metadata/src/main/kotlin/jadx/plugins/kotlin/metadata/utils/ToStringParser.kt:30`
**Target:** `crates/dexterity-kotlin/src/tostring_parser.rs`

**GAP:** JADX uses `BlockUtils.buildSimplePath()` to get a simplified linear path of blocks.

```kotlin
// JADX Reference: ToStringParser.kt:29-36
init {
    val blocks: List<BlockNode> = BlockUtils.buildSimplePath(mthToString.enterBlock)
    blocks.forEach { block ->
        block.instructions.forEach { insn ->
            process(insn)
        }
    }
}
```

**Current Dexterity:** Iterates all instructions directly without block simplification:
```rust
// tostring_parser.rs:319-325
for insn in instructions {
    parser.process(insn, type_resolver);
}
```

**Clone Task:**
1. Create equivalent `build_simple_path()` function in dexterity-ir
2. Walk basic blocks following the simple path (no branches)
3. Use simplified block list in tostring_parser.rs

---

### P2.3: Clone AFlag System for Rename/Generate Control
**Source:** `jadx-core/src/main/java/jadx/core/dex/attributes/AFlag.java`
**Target:** `crates/dexterity-ir/src/lib.rs`

**GAP:** JADX uses attribute flags for control:

```java
// JADX Reference: Various locations
cls.add(AFlag.DONT_RENAME)      // Prevent renaming
cls.add(AFlag.DONT_GENERATE)    // Skip code generation
cls.add(AFlag.DONT_INLINE)      // Prevent inlining

// Checked via:
if (AFlag.DONT_RENAME !in mth) { ... }
```

**Current Dexterity:** No unified flag system, uses ad-hoc fields like `alias.is_some()`.

**Clone Task:**
1. Add `NodeFlags` bitflags enum to `dexterity-ir`
2. Add `flags: NodeFlags` to `ClassData`, `MethodData`, `FieldData`
3. Migrate Kotlin alias checks to use flags
4. Support `DontRename`, `DontGenerate`, `DontInline` flags

---

### P2.4: Clone KotlinClassMetadata.readLenient Error Handling
**Source:** kotlinx.metadata library
**Target:** `crates/dexterity-kotlin/src/parser.rs`

**GAP:** JADX uses lenient parsing for malformed metadata:

```kotlin
// JADX Reference: KotlinMetadataExt.kt:70-72
fun ClassNode.getKotlinClassMetadata(): KotlinClassMetadata? {
    return getMetadata()?.let(KotlinClassMetadata::readLenient)
}
```

`readLenient` handles:
- Corrupted d1/d2 arrays
- Unknown version numbers
- Missing required fields
- Invalid protobuf encoding

**Current Dexterity:** Uses strict protobuf parsing that can fail on edge cases:
```rust
// parser.rs:489-490
let proto_class = proto::Class::decode(remaining)
    .map_err(|e| anyhow!("Failed to decode Class: {}", e))?;
```

**Clone Task:**
1. Add `decode_lenient()` wrapper for protobuf parsing
2. Return default values for missing fields
3. Skip unknown extensions gracefully
4. Log warnings instead of errors for malformed data

---

## Implementation Priority Order

### Phase 1: Critical Fixes (Must fix for production quality)
1. **P0.1 (JVM Signatures)** - Critical for accurate method/field matching
2. **P0.2 (Class Collision)** - Prevents class name conflicts
3. **P0.3 (Kinds 4 & 5)** - Multifile class support

### Phase 2: Important Features (Cleaner output)
4. **P1.1 (Companion Hiding)** - Cleaner output for empty companions
5. **P1.2 (Arrays.toString)** - Edge case handling
6. **P1.3 (SGET Revert)** - Edge case in intrinsics

### Phase 3: Polish (Full JADX parity)
7. **P2.3 (AFlag System)** - Unified flag control
8. **P2.2 (Block Path Simplify)** - More accurate toString parsing
9. **P2.4 (Lenient Parsing)** - Handle malformed metadata
10. **P2.1 (Package Part Count)** - Validation consistency

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

### Completed (100%)
- [x] SMAP Parser (`smap_parser.rs` - 440+ lines, 13 tests)
- [x] SMAP Data Model (`smap_types.rs` - 378 lines)
- [x] SourceDebugExtension Pass (integrated into `lib.rs`, ~100 lines)
- [x] Getter Recognition (`find_getters_jadx_style()` - cloned from KotlinUtils.kt:25-44)
- [x] Default Method Renaming (`find_default_methods_jadx_style()` - cloned from KotlinUtils.kt:53-89)
- [x] Hide Intrinsics Option (`KotlinIntrinsicsOptions`)
- [x] RenameReasonAttr Tracking (`rename_reasons: Vec<String>`)
- [x] JADX Options System (`KotlinProcessingOptions` - matches KotlinMetadataOptions.kt)
- [x] Protobuf BitEncoding decode (`bit_encoding_decode()` - UTF-8 and 8-to-7 modes)
- [x] StringTableTypes resolution (`build_string_resolver()`)
- [x] Type Parameter Variance (`KotlinVariance` - in/out/invariant)
- [x] Function Flags (`is_suspend`, `is_inline`, `is_operator`, `is_infix`, `is_tailrec`)
- [x] Property Flags (`is_var`, `is_const`, `is_lateinit`, `is_delegated`)
- [x] Kotlin Class Info (`is_data_class`, `is_sealed`, `is_inline`, `companion_name`)
- [x] KotlinAwareCondition (`visitor.rs` - deobfuscation integration)

### Critical Tasks (P0) - Must Fix
- [ ] **P0.1: JVM Signature Extraction** - Uses `format!("{}()", name)` instead of full JVM signature
- [ ] **P0.2: Class Alias Collision Check** - No check if target class already exists
- [ ] **P0.3: Kotlin Metadata Kinds 4 & 5** - MultiFileClassFacade/Part not implemented

### Important Tasks (P1) - Should Fix
- [ ] **P1.1: Companion Hiding Flags** - Analysis done, DONT_GENERATE not applied
- [ ] **P1.2: ToString Arrays.toString()** - Nested invoke for array fields not handled
- [ ] **P1.3: Intrinsics SGET Revert** - Inlined constant from static field not reverted

### Polish Tasks (P2) - Nice to Have
- [ ] **P2.1: Package Part Count Validation** - Partially implemented
- [ ] **P2.2: BlockUtils.buildSimplePath** - Not implemented, parses all instructions
- [ ] **P2.3: AFlag System** - No unified flag system for rename/generate control
- [ ] **P2.4: Lenient Parsing** - Strict protobuf decoding, no error recovery

---

## Architecture Notes

### Why Not Use kotlinx.metadata Library?

JADX uses the official `kotlin.metadata` library (previously kotlinx-metadata-jvm) which provides:
- Pre-parsed JVM signatures via `signature` property
- Type-safe access to all metadata fields
- Extension properties for JVM-specific data

Dexterity parses the protobuf directly because:
- Rust can't use the Kotlin library
- Direct protobuf parsing with prost is more efficient
- Full control over parsing behavior

**The tradeoff:** We must implement all the convenience methods that kotlinx.metadata provides,
including JVM extension parsing, which is currently incomplete.

### Proto Extension Format

Kotlin metadata uses protobuf extensions (fields 100-18999) to store JVM-specific data.
These extensions are defined in `jvm_metadata.proto` but the actual JVM method/field
signatures are encoded as indices into a string table with specific operations.

The `StringTableTypes` message in `jvm_metadata.proto` describes:
- `predefined_index` - Index into predefined constants
- `string` - Literal string value
- `operation` - NONE, INTERNAL_TO_CLASS_ID, DESC_TO_CLASS_ID
- `substring_index` - Substring extraction
- `replace_char` - Character replacement

JADX/kotlinx.metadata handles all this transparently. We need to implement equivalent logic.

---

## Quick Reference: JADX File → Dexterity Mapping

| JADX Source File | Dexterity Target |
|------------------|------------------|
| `ProcessKotlinInternals.java` | `dexterity-passes/kotlin_intrinsics.rs` |
| `KotlinMetadataPlugin.kt` | `dexterity-kotlin/lib.rs` (main entry) |
| `KotlinMetadataOptions.kt` | `dexterity-kotlin/lib.rs` (KotlinProcessingOptions) |
| `KotlinMetadataDecompilePass.kt` | `dexterity-kotlin/extractor.rs` |
| `KotlinMetadataPreparePass.kt` | `dexterity-kotlin/lib.rs` (class alias) |
| `KotlinMetadataExt.kt` | `dexterity-kotlin/parser.rs` (annotation parsing) |
| `KotlinMetadataUtils.kt` | `dexterity-kotlin/extractor.rs` |
| `KotlinUtils.kt` | `dexterity-kotlin/extractor.rs` (getters, defaults) |
| `ToStringParser.kt` | `dexterity-kotlin/tostring_parser.rs` |
| `KmExt.kt` | `dexterity-kotlin/parser.rs` (shortId extraction) |
| `KmClassWrapper.kt` | N/A (Rust uses owned types) |
| `SMAPParser.kt` | `dexterity-kotlin/smap_parser.rs` ✅ |
| `SMAP.kt` + `FileMapping` | `dexterity-kotlin/smap_types.rs` ✅ |
| `KotlinSmapPlugin.kt` | `dexterity-kotlin/lib.rs` (SMAP processing) |
| `KotlinSmapUtils.kt` | `dexterity-kotlin/lib.rs` (class alias from SMAP) |

---

*Document created: 2025-12-23*
*Last updated: 2025-12-23*
*Status: ~85% PARITY - 3 P0 CRITICAL + 3 P1 IMPORTANT + 4 P2 POLISH TASKS REMAINING*
*Overall Assessment: Core functionality complete, edge cases and full signature matching needed*
