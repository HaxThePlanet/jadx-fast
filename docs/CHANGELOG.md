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

**Major Release:** All P0 bugs fixed, production-ready for decompilation.

| Feature | Status |
|---------|--------|
| Boolean Simplification | ✅ `? true : false` -> `c`, De Morgan's law |
| Lambda Class Suppression | ✅ 92 -> 55 files (37 lambda classes filtered) |
| Diamond Operator | ✅ 1,254 instances emit `<>` (76% of JADX) |
| Lambda Inlining (invoke-custom) | ✅ Variable assignment, SAM types working |

**P0 Bugs Fixed:**
- P0-FOREACH-SEM: Empty for-each loop body - ported JADX `BlockProcessor.splitReturn()`
- P0-LOOP-VAR: Undefined loop variables - extended `ArrayForEachInfo` with alias tracking
- P0-BOOL-CHAIN: Return logic inverted - PHI-to-return transformation with polarity tracking
- P0-UNDEF-VAR: Undefined variables - static field inlining + `force_inline` flags
- P0-TERNARY-INLINE: Ternary variable declaration - force inline + static field vars

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
- Throws declaration support (13.7% → 41.7% parity)
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
