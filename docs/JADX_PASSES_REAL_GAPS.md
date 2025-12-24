# JADX Passes - Real Parity Gaps

**Created:** Dec 23, 2025
**Evidence:** Actual decompilation output comparison (output/jadx vs output/dexterity)

## Executive Summary

Previous docs claimed ~82% parity. **Reality check from actual output: ~60-65%.**

The decompiled output shows **SEVERE** quality gaps that break code correctness.

---

## Critical Issues Found in Output Comparison

### NanoHTTPD.java Comparison (medium APK)

#### Issue 1: Synthetic Fields Exposed (P0) - ✅ PARTIALLY FIXED
**JADX Output:**
```java
public class ClientHandler implements Runnable {
    private final Socket acceptSocket;
    private final InputStream inputStream;
```

**Dexterity Output (BEFORE FIX):**
```java
public class ClientHandler implements Runnable {
    private final Socket acceptSocket;
    private final InputStream inputStream;
    final NanoHTTPD this$0;  // EXPOSED - should be hidden!
```

**Status:** Field declarations now filtered via `is_inner_class_synthetic_field()` in class_gen.rs.
Field usages in method bodies (`this.this$0`) still need `FieldReplaceAttr` equivalent.

**Root Cause:** ClassModifier.removeSyntheticFields() not fully cloned
**JADX Source:** `ClassModifier.java:80-110`

---

#### Issue 2: Synthetic Constructor Parameters Visible (P0) - ✅ PARTIALLY FIXED
**JADX Output:**
```java
private ClientHandler(InputStream inputStream, Socket socket) {
```

**Dexterity Output (BEFORE FIX):**
```java
ClientHandler(NanoHTTPD nanoHTTPD, InputStream inputStream, Socket socket, NanoHTTPD.AnonymousClass1 1Var) {
```

**Status:** Implemented `is_synthetic_constructor_arg()` in method_gen.rs to filter:
- Outer class reference args (first param for inner class constructors)
- Anonymous class markers (`$1`, `$Lambda$`, etc.)
Only applies to synthetic methods; non-synthetic methods need JADX's SkipMethodArgsAttr.

**Root Cause:** ClassModifier.modifySyntheticMethod() not cloned
**JADX Source:** `ClassModifier.java:213-241`

---

#### Issue 3: Completely Broken Exception Handling (P0-CRITICAL)
**JADX Output:**
```java
} catch (Exception e) {
    if ((!(e instanceof SocketException) || !"NanoHttpd Shutdown".equals(e.getMessage()))
        && !(e instanceof SocketTimeoutException)) {
        NanoHTTPD.LOG.log(Level.FINE, "Communication with the client broken", (Throwable) e);
    }
}
```

**Dexterity Output (BROKEN):**
```java
z = th instanceof SocketException;
if (!z || !z) {
    z = th instanceof SocketTimeoutException;
    if (!z) {
        z = NanoHTTPD.LOG;
        fINE2 = Level.FINE;
        z.equals(fINE2).log(th.getMessage(), "Communication with the client broken", th);
    }
}
```

This is **completely wrong code**:
- `z` is reused for boolean, Logger, and Level (type confusion)
- `z.equals(fINE2).log(...)` is nonsense - calling log on boolean result
- Control flow is garbled

**Root Cause:** Multiple issues:
1. Type inference not propagating correctly
2. Variable naming not differentiating types
3. SimplifyVisitor not cleaning up patterns

---

#### Issue 4: Variable Name Collisions (P0)
**JADX Output:**
```java
while (!this.acceptSocket.isClosed()) {
```

**Dexterity Output:**
```java
while (acceptSocket24.isClosed() == null) {
```

- Wrong variable name: `acceptSocket24` instead of `this.acceptSocket`
- Wrong comparison: `== null` instead of negation

---

#### Issue 5: Over-Qualified Inner Class References (P1)
**JADX Output:**
```java
AsyncRunner asyncRunner;
Cookie cookie;
```

**Dexterity Output:**
```java
NanoHTTPD.AsyncRunner asyncRunner;
NanoHTTPD.Cookie cookie;
```

**Root Cause:** Codegen not detecting same-class context
**JADX Source:** TypeGen and CodeWriter handling

---

#### Issue 6: Unused Array Allocations (P1)
**JADX Output:**
```java
return String.format("%s=%s; expires=%s", this.n, this.v, this.e);
```

**Dexterity Output:**
```java
Object[] arr = new Object[3];
return String.format("%s=%s; expires=%s", this.n, this.v, this.e);
```

**Root Cause:** Dead code not eliminated
**JADX Source:** ProcessVariables.removeUnusedResults()

---

#### Issue 7: super() Not Simplified (P2)
**JADX Output (small APK):**
```java
super.onCreate(savedInstanceState);
```

**Dexterity Output:**
```java
Activity.super.onCreate(savedInstanceState);
```

**Root Cause:** SimplifyVisitor not simplifying qualified super calls

---

## JADX Pass Inventory vs Dexterity

| JADX Pass | Dexterity File | Parity | Critical Missing Logic |
|-----------|----------------|--------|------------------------|
| ClassModifier.java (320 lines) | class_modifier.rs | 30% | removeSyntheticFields(), modifySyntheticMethod(), removeFieldUsageFromConstructor() |
| ProcessVariables.java (300 lines) | process_variables.rs | 40% | removeUnusedResults(), declareVar() region logic |
| PrepareForCodeGen.java (300 lines) | prepare_for_codegen.rs | 50% | checkInline(), removeInstructions(), modifyArith() |
| InlineMethods.java (250 lines) | inline_methods.rs | 60% | inlineMethod(), replaceRegs() |
| CodeShrinkVisitor.java (400 lines) | code_shrink.rs | 50% | checkInline(), cross-block inlining |
| SimplifyVisitor.java (600 lines) | simplify.rs | 40% | String builder patterns, super simplification |
| MarkMethodsForInline.java (200 lines) | method_inline.rs | 50% | Bridge method detection |

---

## Priority Clone Tasks

### P0: Critical - Code Correctness

#### Task P0-1: Clone ClassModifier.removeSyntheticFields() - ✅ DONE
**JADX Source:** `jadx-core/src/main/java/jadx/core/dex/visitors/ClassModifier.java:80-110`

**Implementation:** Added `is_inner_class_synthetic_field()` in `class_gen.rs:1668-1700`
- Filters `this$0`, `this$1`, etc. (outer class references)
- Filters `val$name` (captured variables in anonymous/local classes)
- Applied to both static_fields and instance_fields filtering

```rust
// JADX Reference: ClassModifier.java:80-110 - removeSyntheticFields()
fn is_inner_class_synthetic_field(field: &dexterity_ir::FieldData) -> bool {
    if !access_flags::is_synthetic(field.access_flags) { return false; }
    if field.name.starts_with("this$") { /* check digit suffix */ return true; }
    if field.name.starts_with("val$") { return true; }
    false
}
```

**Remaining:** Field usage replacement (`this.this$0` → `NanoHTTPD.this`) needs FieldReplaceAttr clone

---

#### Task P0-2: Clone ClassModifier.modifySyntheticMethod() - ✅ PARTIALLY DONE
**JADX Source:** `jadx-core/src/main/java/jadx/core/dex/visitors/ClassModifier.java:213-241`

**Implementation:** Added `is_synthetic_constructor_arg()` in `method_gen.rs:61-115`
- Filters outer class reference (first arg for inner class constructors)
- Filters anonymous class markers (`$1`, `$2`, `$Lambda$`)
- Modified `add_parameters()` to accept class param and filter args

Key behaviors implemented:
1. ✅ Detect synthetic constructors with AnonymousClass parameters
2. ✅ Skip synthetic arguments in parameter list
3. ❌ Redirect calls to real constructor (MethodReplaceAttr) - NOT YET
4. ❌ Mark synthetic constructor DONT_GENERATE - NOT YET

---

#### Task P0-3: Clone ProcessVariables.removeUnusedResults()
**JADX Source:** `jadx-core/src/main/java/jadx/core/dex/visitors/regions/variables/ProcessVariables.java:72-100`

Key behaviors:
1. Remove unused instruction results
2. Remove whole instructions if safe (canRemoveInsn)
3. Clean up SSA variable references

---

#### Task P0-4: Fix Type Inference Variable Naming
The `z` variable holding Logger, Level, and boolean simultaneously indicates:
1. Type inference not differentiating incompatible types
2. Variable naming not checking type compatibility
3. SSA version collapsing incorrectly

---

### P1: High Priority - Code Quality

#### Task P1-1: Fix Inner Class Reference Qualification
**Location:** Codegen (type rendering)

Rule: When emitting type inside same class, use simple name:
- Inside NanoHTTPD: `Cookie` not `NanoHTTPD.Cookie`
- Inside NanoHTTPD: `AsyncRunner` not `NanoHTTPD.AsyncRunner`

#### Task P1-2: Clone SimplifyVisitor super() Simplification
**JADX Source:** SimplifyVisitor + codegen handling

Rule: `OuterClass.super.method()` should become `super.method()` when unambiguous

---

### P2: Medium Priority - Polish

#### Task P2-1: Clone CodeShrinkVisitor Cross-Block Inlining
**JADX Source:** `CodeShrinkVisitor.java` cross-block inlining section

#### Task P2-2: Dead Code Elimination for Unused Arrays
The `Object[] arr = new Object[3];` should be eliminated

---

## How to Clone a Pass

### Step 1: Read the JADX Source Completely
```bash
# Example for ClassModifier
cat jadx-fast/jadx-core/src/main/java/jadx/core/dex/visitors/ClassModifier.java
```

### Step 2: Map JADX Types to Dexterity Types

| JADX Type | Dexterity Type |
|-----------|---------------|
| ClassNode | ClassData |
| MethodNode | MethodData |
| FieldNode | FieldData |
| InsnNode | InsnNode |
| BlockNode | SsaBlock |
| RegisterArg | RegisterArg |
| SSAVar | (reg_num, ssa_version) tuple |
| AFlag | AFlag enum |
| AType | Attribute types |

### Step 3: Add JADX Reference Comments
```rust
// JADX Reference: ClassModifier.java:80-110
// Clone of: removeSyntheticFields()
// Key behaviors:
// 1. Check if field is synthetic and references parent class
// 2. Mark field DONT_GENERATE if confirmed
pub fn remove_synthetic_fields(class: &mut ClassData) -> Vec<HideElement> {
    // ...
}
```

### Step 4: Test with Edge Cases
JADX tests are in: `jadx-core/src/test/java/jadx/tests/`

---

## Verification Checklist

After implementing a clone task, verify:

1. [ ] Decompile small/medium/large APKs with both JADX and Dexterity
2. [ ] Compare specific file that had the issue
3. [ ] Check that the specific pattern is now handled correctly
4. [ ] Run integration tests: `cargo test --release`
5. [ ] Update this document with completion status

---

## Document History

- Dec 23, 2025: Created with actual output comparison evidence
- Dec 23, 2025: P0-1 DONE - Synthetic field filtering in class_gen.rs
- Dec 23, 2025: P0-2 PARTIAL - Synthetic constructor arg filtering in method_gen.rs
