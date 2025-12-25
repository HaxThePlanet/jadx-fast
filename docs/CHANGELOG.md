# Changelog

See [ROADMAP.md](ROADMAP.md) for current status, detailed bug fixes, and known issues.

---

## December 2025

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

**Bug Fixes (Dec 25, 2025):**
- Fixed missing `attrs` field in `InsnNode::copy()`
- Fixed `converter.rs` to use `method.method_idx` and `bytecode_ref.method_idx`

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
