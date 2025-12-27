# Changelog

See [ROADMAP.md](ROADMAP.md) for current status, detailed bug fixes, and known issues.

---

## December 2025

### Dec 27 - ProcessVariables Pass (JADX Parity)

**Status:** Complete | **Impact:** Fixes undeclared variable bugs in complex control flow

Implemented JADX-style two-phase variable declaration system:
1. **Phase 1:** `process_variables.rs` pre-analyzes code and marks instructions with `DeclareVar` flag
2. **Phase 2:** `emit_assignment_insn()` checks flag to determine if declaration needed

| Change | Description |
|--------|-------------|
| **process_variables.rs** | New pass marks first assignment with `AFlag::DeclareVar` |
| **body_gen.rs** | All 3 SSA transform locations now call `init_code_variables` + `process_variables` |
| **emit_assignment_insn()** | Checks `insn.has_flag(AFlag::DeclareVar)` before emitting type declaration |

**Before (broken):**
```java
str2 = "android.permission.READ_CONTACTS";  // ERROR: str2 never declared
```

**After (fixed):**
```java
String str2 = "android.permission.READ_CONTACTS";  // Properly declared
```

**JADX Reference:** `ProcessVariables.java`, `InsnGen.java:149-156`

---

### Dec 26 - Control Flow Deobfuscation Passes

**Status:** Complete | **Impact:** Reverses common obfuscation techniques

Added comprehensive control flow deobfuscation passes in `dexterity-passes/src/deobf/`.

| Flag | Description |
|------|-------------|
| `--deobf-cff` | Control Flow Flattening recovery |
| `--deobf-opaque` | Opaque predicate detection and removal |
| `--deobf-dead-code` | Dead code elimination |
| `--deobf-bogus` | Bogus code removal (identity ops, dead stores) |
| `--deobf-patterns` | Pattern simplification (x*2->x<<1, MBA patterns) |
| `--deobf-aggressive` | Enable all deobfuscation passes |

**New Modules:**
- `dexterity-passes/src/deobf/opaque_predicates.rs` - Detects x^x==0, x==x, constant comparisons
- `dexterity-passes/src/deobf/dead_code.rs` - Removes dead instructions, unreachable blocks
- `dexterity-passes/src/deobf/cff_detector.rs` - Detects Control Flow Flattening patterns
- `dexterity-passes/src/deobf/bogus_code.rs` - Removes identity ops (x+0, x*1)
- `dexterity-passes/src/deobf/pattern_simplify.rs` - Simplifies arithmetic encoding

**Pipeline:** `run_deobf_passes()` with `DeobfConfig` for selective pass enabling.

---

### Dec 26 - Obfuscator Detection & Smart Naming

**Status:** Complete | **Impact:** New analysis capabilities for obfuscated APKs

Added comprehensive obfuscator detection and smart semantic naming features.

| Feature | Description |
|---------|-------------|
| `--detect-obfuscators` | Analyze APK and display obfuscation report |
| `--smart-naming` | Enable type-hint and pattern-based semantic naming |
| Obfuscation Level | None, Light, Moderate, Heavy, Extreme (percentage-based) |
| String Decryption Detection | XOR, AES, DES, RC4, Base64 patterns |
| Obfuscator Signatures | ProGuard, R8, DexGuard, Allatori, Bangcle, Qihoo360, TencentLegu |

**New Modules:**
- `dexterity-deobf/src/obfuscator_signatures.rs` - Signature database with confidence levels
- `dexterity-deobf/src/string_decryption.rs` - String encryption pattern analysis
- `dexterity-deobf/src/detection_report.rs` - Report generation and formatting
- `dexterity-deobf/src/smart_naming/` - Smart alias provider with:
  - `dictionary.rs` - Domain vocabulary (Android, networking, crypto, etc.)
  - `type_hints.rs` - Type-based naming patterns (Map->xxxMap, Handler->xxxHandler)
  - `patterns.rs` - Pattern detection (Singleton, Builder, Factory, Repository)
  - `android.rs` - Android component detection (Activity, Fragment, Service, ViewModel)
  - `method_analysis.rs` - Method signature analysis
  - `field_analysis.rs` - Field access pattern analysis
  - `provider.rs` - SmartAliasProvider implementing AliasProvider trait

**Example Output:**
```
Obfuscation Level: Moderate (34%)
Classes: 9400 total, 6632 short names (70.6%)
Methods: 58335 total, 27418 short names (47.0%)
String Decryptors: 15 XOR-based, 40+ custom
```

---

### Dec 26 - P2-ENUM-CONSTANTS Complete

**Status:** Complete | **Impact:** +1-2% type accuracy, better code readability

Replaces integer literals (0, 1, 2) with enum constant names (MyEnum.VALUE_A, MyEnum.VALUE_B) when the expected type is an enum class.

| Change | Description |
|--------|-------------|
| **converter.rs** | Fixed ACC_ENUM flag preservation for inner classes |
| **main.rs** | Added `<clinit>` loading in enum prepass |
| **body_gen.rs** | Enum lookup via `try_resolve_enum_constant()` |
| **expr_gen.rs** | `try_resolve_enum_constant()` implementation |

**Test Results:**
- medium.apk: 111 enums detected
- large.apk: 283 enums detected

**Before:** `if (format == 0) { ... }`
**After:** `if (format == Format.ALPHA_8) { ... }`

---

### Dec 26 - P1-TRY-CATCH-INVERT Partial Fix

**Status:** Partial Fix | **Impact:** Improved try-catch block reconstruction accuracy

| Fix | Status |
|-----|--------|
| JSONObject constructor | ✅ FIXED - `putOnce()` now correctly in try block |
| JSONArray.getDouble | Still broken - `parseDouble()` return misplaced |

**Root Cause:** BFS fallback in `collect_handler_blocks_by_dominance()` followed loop back edges and re-entered try body blocks, causing them to be collected as handler blocks.

**Solution Applied:**
- Added dominance check to BFS fallback in `collect_handler_blocks_by_dominance()` at `region_builder.rs:689`
- Now only follows successors that are dominated by the handler (matches JADX `collectWhileDominates` pattern)

**Code Change:**
```rust
// BEFORE: followed ALL successors
for &succ in cfg.successors(b) {
    if !visited.contains(&succ) {
        worklist.push(succ);
    }
}

// AFTER: only follow dominated successors
for &succ in cfg.successors(b) {
    if !visited.contains(&succ) && cfg.dominates(handler_block, succ) {
        worklist.push(succ);
    }
}
```

**Remaining Issue:** Some patterns still broken when dominance tree itself incorrectly assigns try body blocks as dominated by handler. Needs investigation of dominance computation for exception edges.

**JADX Reference:** `BlockUtils.collectWhileDominates()`

---

### Dec 24 - Anti-RE ZIP Hardening

**Security Hardening:** Handles obfuscated/malicious APKs with JADX-compatible protections.

| Feature | Status |
|---------|--------|
| Path Traversal Protection | ✅ Blocks `../` patterns (JadxZipSecurity clone) |
| Compression Bomb Detection | ✅ 100x ratio threshold, 25MB min |
| Fallback ZIP Parser | ✅ Signature-based recovery (~300 lines) |
| Bad APK Success Rate | ✅ 43% → 83% (+93% improvement) |

**Files Added:**
- `crates/dexterity-cli/src/zip_fallback.rs` - Fallback parser for corrupted ZIPs
- `crates/dexterity-cli/src/main.rs` - Security checks integration

**Anti-RE Techniques Handled:** Truncated EOCD, filename obfuscation, multi-disk spoofing, compression bombs

---

### Dec 25 - 🟢 PRODUCTION-READY (A-/B+ Grade)

**Major Release:** All P0 and P2 bugs fixed, production-ready for decompilation.

| Feature | Status |
|---------|--------|
| **P0-UNDEF-LOOP** | ✅ PHI variable naming mismatch fixed (JADX CodeVar approach) |
| **P1-CHECKTRACER** | ✅ Kotlin method chain decompilation fixed (48 lines -> clean output) |
| **P2-BOOL-CHAIN-POLISH** | ✅ TernaryReturn simplification (return cond ? true : false -> return cond) |
| Boolean Simplification | ✅ `? true : false` -> `c`, De Morgan's law |
| Lambda Class Suppression | ✅ 92 -> 55 files (37 lambda classes filtered) |
| Diamond Operator | ✅ 1,254 instances emit `<>` (76% of JADX) |
| Lambda Inlining (invoke-custom) | ✅ Variable assignment, SAM types working |
| **TernaryMod Region-Level Pass** | ✅ Full JADX parity with `TernaryModVisitorFull` |
| **DebugInfo Visitors** | ✅ Attach (Stage 0.5) + Apply (Stage 5.1) integrated |
| **FixAccessModifiers** | ✅ Inner class visibility fixes (~120 lines) |
| **Throws Clause Parity** | ✅ Expanded from ~26% to ~75-80% (529 methods, 38 unchecked types) |

**P0-UNDEF-LOOP Fix (Dec 25, 2025):**
- Added `unify_phi_variable_names()` - propagates unified names from PHI destinations to all sources
- Clones JADX's CodeVar approach: all SSA versions of a logical variable share one name
- Fixes: `boolean it2; ... it = iterator();` → `Iterator it = iterator();`
- Affected: `checkTracerPid()` and other iterator-based methods in MaliciousPatterns.java

**TernaryMod Implementation (Dec 25, 2025):**
- `TernaryModVisitorFull` - handles both two-branch and single-branch patterns
- `process_one_branch_ternary()` - implements JADX's `processOneBranchTernary()`
- `replace_with_ternary()` - full JADX logic with PHI validation
- Helper functions: `verify_line_hints()`, `check_line_stats()`, `contains_ternary()`, `is_literal_mismatch()`
- Else-if chain detection to skip inappropriate transformations
- Pipeline uses `process_ternary_transformations_full()` in `decompiler.rs`

**DebugInfo Visitors Integration (Dec 25, 2025):**
- `debug_info.rs` refactored to use IR types (`DebugInfo`, `LocalVar`)
- Added exports to `lib.rs` for `attach_debug_info`, `apply_debug_info`, etc.
- Wired into `decompiler.rs` pipeline:
  - Stage 0.5 (before block splitting): `attach_debug_info()` attaches source lines
  - Stage 5.1 (after type inference): `apply_debug_info()` applies variable names/types to SSA vars

**FixAccessModifiers Implementation (Dec 25, 2025):**
- Implemented in `converter.rs` (~120 lines)
- Called from `main.rs` streaming processing loop
- Detects inner class accesses to outer class private members
- Upgrades private → package-private visibility
- JADX Reference: `FixAccessModifiers.java`, `VisibilityUtils.java`

**Throws Clause Parity Improvement (Dec 25, 2025):**
- Expanded `get_library_method_throws()` from 113 to **529 methods**
- Expanded `is_checked_exception()` from 19 to **38 unchecked exception types**
- Added coverage for:
  - java.io (streams, readers, writers) - ~148 methods
  - java.lang reflection (Class, Method, Field, Constructor) - ~46 methods
  - java.util.zip/jar - ~45 methods
  - java.nio.channels/file - ~57 methods
  - java.text parsing - ~5 methods
  - javax.xml (parsers, transform, xpath) - ~20 methods
  - javax.net.ssl - ~14 methods
  - java.security (KeyStore, certs) - ~20 methods
  - Android-specific (Context, Resources, SQLite, Media) - ~70 methods
- **File:** `crates/dexterity-codegen/src/method_gen.rs`

**AttachCommentsVisitor Implementation (Dec 25, 2025):**
- New pass `attach_comments.rs` - JADX AttachCommentsVisitor clone for counting diagnostic comments
- New module `comment_gen.rs` - Comment emission utilities for code generation
- Enhanced `CommentStyle` enum with 5 styles: Line, Block, BlockCondensed, Javadoc, JavadocCondensed
- Enhanced `CodeComment` struct with `style: CommentStyle` field
- Added `CodeCommentsAttr` struct for multi-valued comment storage
- `InsnNode` now has optional `attrs: Option<Box<AttributeStorage>>` field for instruction-level attributes
- Helper methods: `attrs_mut()`, `get_attrs()`, `add_code_comment()`, `get_code_comments()`, `has_code_comments()`
- Pass counts: source file comments, renamed classes/fields/methods, instruction-level comments

**P2-BOOL-CHAIN-POLISH Fix (Dec 25, 2025):**
- **Bug:** Simple OR patterns produced 15-line if-else chains instead of single-line `return a || b`
- **Location:** `crates/dexterity-codegen/src/body_gen.rs` lines 8003-8046 (Region::TernaryReturn handler)
- **Solution:** Added call to `simplify_ternary_to_boolean` in TernaryReturn handler
- **Simplifications:**
  - `return cond ? true : false` -> `return cond;`
  - `return cond ? false : true` -> `return !cond;`
  - `return cond ? 1 : 0` (boolean context) -> `return cond;`
  - `return cond ? 0 : 1` (boolean context) -> `return !cond;`
- **Tests:** All 120 codegen tests pass

**Code Quality (CQ-M series, Dec 25):**
- CQ-M03: Remove dead nested type wrapper functions
- CQ-M04: Remove 5 dead struct fields from RegionBuilder
- CQ-M06: ExceptionType enum verified existing
- CQ-M08: Optimize clone abuse in type_inference.rs
- CQ-M09: Audit body_gen.rs clones - all justified

**New Crates (Dec 25):**
- `dexterity-error`: Unified error types (30+ variants)
- `dexterity-utils`: Shared utilities (keywords, identifiers, escaping)
- `dexterity-limits`: Resource limits & safety guards

**Version:** All crates now at 1.0.0 via workspace inheritance

**Bug Fixes (Dec 25, 2025):**
- Fixed missing `attrs` field in `InsnNode::copy()`
- Fixed `converter.rs` to use `method.method_idx` and `bytecode_ref.method_idx`

**Stack Overflow Fix (Dec 25-26, 2025):**
- **Problem:** Stack overflow crash on large APKs caused by unbounded recursion in visitor traversal functions
- **Root Cause:** Several recursive functions lacked depth limits. Unlike JADX (Java) which can catch StackOverflowError, Rust aborts immediately on stack overflow
- **Solution:** Added depth limits via `dexterity_limits` crate with configurable `visitor_max_depth()` (default: 200)
- **Files Using Limits:**
  - `dexterity-codegen/src/body_gen.rs` - `process_region_for_inlining_with_depth` uses `visitor_max_depth()`
  - `dexterity-passes/src/post_process_regions.rs` - All depth-recursive functions use `visitor_max_depth()`
  - `dexterity-passes/src/region_builder.rs` - Uses `region_stack_limit()` (default: 200)
  - `dexterity-passes/src/if_region_visitor.rs` - Uses `visitor_max_depth()`
  - `dexterity-passes/src/return_visitor.rs` - Uses `visitor_max_depth()`
  - `dexterity-passes/src/depth_region_traversal.rs` - Uses `visitor_max_depth()`
  - `dexterity-passes/src/dot_graph_visitor.rs` - Uses `visitor_max_depth()`
  - `dexterity-passes/src/finally_extract.rs` - Uses hardcoded MAX_DEPTH = 200
- **Behavior Change:** Deeply nested regions (>200 levels) are now truncated with error logs:
  - `LIMIT_EXCEEDED: Region stack overflow, bailing out`
  - `CODEGEN_LIMIT_EXCEEDED: Region nesting too deep, bailing out`
- **Test Results:**
  - Spotify APK (201MB): Completed in 4.34s with graceful depth limit handling
  - Badboy APK (24MB): Completed in 0.26s

**P0 Bugs Fixed:**
- P0-FOREACH-SEM: Empty for-each loop body - ported JADX `BlockProcessor.splitReturn()`
- P0-LOOP-VAR: Undefined loop variables - extended `ArrayForEachInfo` with alias tracking
- P0-BOOL-CHAIN: Return logic inverted - PHI-to-return transformation with polarity tracking
- P0-UNDEF-VAR: Undefined variables - static field inlining + `force_inline` flags
- P0-TERNARY-INLINE: Ternary variable declaration - force inline + static field vars
- P0-SPURIOUS-RET: Fixed via proper region-level TernaryMod pass

**P1 Bugs Fixed:**
- P1-STRING-CONST: String constant loss - `try_convert_string_char_array_constructor()` detects `new String(new char[]{...})`
- P1-STRING-CONCAT: String concatenation - Added `InsnType::StrConcat` handling to inline expressions
- P1-CHECKTRACER: Kotlin method chain decompilation (checkTracerPid() 48 lines -> clean output)
- P1-TRY-CATCH-RECON: Try-catch in loop bodies - Added try-catch detection in `build_loop_body()` (commit fc2165395)

**P1-CHECKTRACER Fix Details (Dec 25, 2025):**
- **Empty If-Branch Generation** (`body_gen.rs` lines 4974-5011, 7008-7027):
  - Added `invert_condition_string()` helper for clean condition inversion
  - Skip entirely empty if statements
  - Invert condition when then-branch is empty but else-branch has content
- **Kotlin Stdlib Method Naming** (`var_naming.rs` lines 1755-1800):
  - StringsKt: split->parts, trim->trimmed, toIntOrNull->parsed
  - FilesKt: readLines->lines, readText->content
  - CollectionsKt: find->found, filter->filtered, map->mapped
  - Iterator: next->item
- **Semantic Origin Tracking** (`var_naming.rs` lines 414-433, 512-540):
  - Extended SemanticOrigin enum with Kotlin variants (KotlinFind, KotlinSplit, KotlinTrim, KotlinParsed, IteratorNext, KotlinReadLines)
  - Enhanced origins_compatible() to prevent merging Kotlin chain variables

**P1-TRY-CATCH-RECON Fix (Dec 25, 2025):**
- **Bug:** Try-catch blocks inside loop bodies weren't being reconstructed properly
- **Root Cause:** `build_loop_body()` in region_builder.rs only checked for nested loops and conditionals, NOT nested try-catch blocks
- **Solution:** Added try-catch detection in `build_loop_body()` to call `process_try_catch()` when a try-start block is found inside a loop
- **Location:** `crates/dexterity-passes/src/region_builder.rs` (+56 lines)
- **Commit:** fc2165395
- **Affected Methods (now fixed):** `checkRootManagementApps()`, `executeRootCheck()`, `getHiddenApi()`

---

### Dec 24 - GAP-01/GAP-02 Critical Fixes

- **GAP-01:** SSA->CodeVar mapping - use `peek` instead of `take` for field access
- **GAP-02:** Iterator for-each pattern detection - full JADX LoopRegionVisitor port
- **P0-WRONG-RETURN:** Boolean methods returning int - exclude Boolean from integral types

---

### Dec 23 - JADX Pass Cloning

- **3 new passes (~1,200 lines):** SignatureProcessor, SynchronizedRegionMaker, ExcHandlersRegionMaker
- **IR parity P8-P16 (~650 lines):** Condition, LiteralArg, Compare, FillArrayData, InvokeCustom, PhiInsn, SSAVar
- **Coverage:** 79% → 82% (86/105 JADX passes)

---

### Dec 22 - Performance Optimization (14x faster)

**Type Inference Speedup:**
- Library method signature cache (150 common signatures, O(1) lookup)
- Needed variables collection via backward dataflow
- Binary IR type hints for double/float/long literals

| APK | Dexterity | JADX | Speedup |
|-----|-----------|------|---------|
| Total (5 APKs) | 4.32s | 61.52s | **14.2x** |

**Bug Fixes:**
- P0-CFG04: Complex boolean expressions - wrap bitwise ops for correct precedence
- P1-CFG05: Exception variable scope - link generated exception names to actual registers
- P1-S05: Ternary detection - ported JADX block cleaning (`removeInsns()`)

---

### Dec 21 - IR 100% + Resources Parity

**IR Completion:**
- Lazy instruction loading, RegionVisitor pattern, PHI simplification
- Type variable bounds, Kotlin class validation
- All 15 Unknown type variants

**Resources 1:1 Parity:**
- Gravity flag decoding, resource name suffix fix, version qualifier stripping
- 103 directories, 152 files, zero differences with JADX

**Other:**
- Throws declaration support initial implementation (expanded to ~75-80% parity on Dec 25)
- HashMap-based annotation lookup optimization (O(1) per method vs O(n) linear search)
- Boolean dead code elimination
- Variable naming improvements (OBJ_ALIAS exact matching)

---

### Dec 20 - Kotlin Metadata 100%

- BitEncoding decoder (UTF-8 + 8-to-7 modes)
- 68 predefined Kotlin strings
- All function modifiers: suspend/inline/infix/operator/tailrec
- Data/sealed/value class detection

---

### Dec 19 - Control Flow

- TernaryMod + IfRegionVisitor improvements
- Kotlin type variance annotations
- Exception handler PHI declarations

---

### Dec 18 - Generics

- Interface generic type parameters
- Constructor generic types
- Missing import statements fixed

---

### Dec 17 - Variable Naming

- JADX variable naming algorithm ported
- THP optimization (8.8% faster)
- Multi-catch support
- Enum constant name fix

---

### Dec 16 - Foundation

- Variable naming: 27,794 → 0 `arg0/arg1` instances
- Class-level generic type parameters (736 classes)
- Invalid Java identifiers fix
