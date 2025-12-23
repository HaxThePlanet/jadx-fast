# JADX Codegen Clone Tasks

**Status: ~93% Complete (Dec 23, 2025 Source-Level Audit)**

After source-level audit comparing JADX codegen Java files to dexterity-codegen Rust files, most features are implemented.
See `JADX_CODEGEN_CLONE_STATUS.md` for the detailed source-level audit with line numbers.

**Philosophy**: We are NOT rewriting or improving JADX. We are CLONING 10 years of battle-tested decompilation logic.

**Reference Path**: `/mnt/nvme4tb/dexterity/jadx-fast/jadx-core/src/main/java/jadx/core/codegen/`

---

## ✅ ALREADY IMPLEMENTED

### P0 Critical (All Complete!)

| Feature | JADX Source | Dexterity Implementation |
|---------|-------------|-------------------------|
| **Lambda Generation** | `InsnGen.java:952-1078` | `body_gen.rs:5093-5528` |
| - Method references (`Type::method`) | `InsnGen.java:965-983` | `generate_method_reference()` |
| - Simple lambdas (`() -> {}`) | `InsnGen.java:985-1030` | `generate_lambda_expression()` |
| - Inlined lambda bodies | `InsnGen.java:1032-1078` | `try_inline_full_lambda_body()` |
| **Anonymous Class Inlining** | `InsnGen.java:806-848` | `body_gen.rs:7469-8400` |
| - Recursion detection | Line 806-810 | Line 8318-8333 |
| - Variable name inheritance | `setOuterNameGen()` | Via `BodyGenContext` |
| **Multi-catch Support** | `RegionGen.java:345-384` | `body_gen.rs:6258-6291` |
| - `Type1 \| Type2` syntax | Line 203-205 | `handler.is_multi_catch()` |
| - Catch-all with Throwable | Line 195-196 | Line 6260-6268 |

### P1 High Priority (All Complete!)

| Feature | JADX Source | Dexterity Implementation |
|---------|-------------|-------------------------|
| **Switch String Cases** | `RegionGen.java:244-311` | `body_gen.rs:3291-3368` |
| - String hash detection | Pattern matching | `detect_switch_over_string()` |
| - String literal cases | `addCaseKey()` | `SwitchOverStringInfo` |
| **Switch Enum Cases** | `RegionGen.java:288-311` | `body_gen.rs:5588-5591` |
| - Enum field names | `useField()` | `CaseKey::Enum` variant |
| **Synchronized Regions** | `RegionGen.java:231-242` | `body_gen.rs:6344-6400` |
| **TypeGen Literal Formatting** | `TypeGen.java:52-99` | `type_gen.rs:252-395` |
| - Special values (NaN, Infinity) | Line 84-86 | `format_float/double()` |
| - MIN/MAX_VALUE constants | Via StringUtils | Lines 302-324, 346-395 |

### P2 Medium Priority (All Complete!)

| Feature | JADX Source | Dexterity Implementation |
|---------|-------------|-------------------------|
| **Field Replacement** | `InsnGen.java:186-213` | `body_gen.rs:7527-7565` |
| - `this$N` → `OuterClass.this` | `FieldReplaceAttr` | `is_outer_this_field()` |
| - Outer class extraction | Line 326-327 | `get_outer_class_from_field_type()` |
| **Super Call Disambiguation** | `InsnGen.java:1080-1117` | `body_gen.rs:7567-7592` |
| - `OuterClass.super.method()` | `getClassForSuperCall()` | `needs_qualified_super()` |
| - Used at invoke sites | Line 1080-1095 | Line 8172-8183 |
| **Operator Precedence** | `ConditionGen.java:165-196` | `body_gen.rs:4385-4390` |
| - Bitwise op wrapping | `isArgWrapNeeded()` | Bitwise precedence checks |
| **Varargs Expansion** | `InsnGen.java:1149-1172` | `body_gen.rs:7598-7680` |
| - Array literal expansion | `processVarArg()` | `extract_vararg_array_elements()` |

---

## ✅ P3 LOW PRIORITY (Now Complete!)

### P3-01: TypeGen Fallback Hex Output
**Status**: ✅ IMPLEMENTED
**JADX Source**: `TypeGen.java:52-68`
**Dexterity Implementation**: `type_gen.rs:256-288` - `literal_to_string_with_fallback()`

When type is unknown AND fallback mode is enabled AND |value| > 100, outputs:
```
12345(0x3039, float:1.7292E-41, double:6.1E-320)
```

### P3-02: Filled Array Line Wrap at 1000 Elements
**Status**: ✅ IMPLEMENTED
**JADX Source**: `InsnGen.java:705-724`
**Dexterity Implementation**: `body_gen.rs:9352-9368`

Wraps long array literals every 1000 elements for readable output.

---

## Summary

| Priority | Total | Implemented | Remaining |
|----------|-------|-------------|-----------|
| P0 Critical | 3 | 3 | 0 |
| P1 High | 5 | 5 | 0 |
| P2 Medium | 6 | 6 | 0 |
| P3 Low | 2 | 2 | 0 |
| **Total** | **16** | **16** | **0** |

**Codegen Parity: ~93%**

All major features are implemented. See `JADX_CODEGEN_CLONE_STATUS.md` for the remaining 5 minor gaps preventing 100% parity:
1. Diamond operator (`new ArrayList<>()`)
2. Outer class constructor prefix (`outer.new Inner()`)
3. Polymorphic call return cast
4. Recursive inner class collision check
5. Comment escape (`*/`)

---

## JADX Reference Comments in Dexterity

The codebase already includes proper JADX reference comments:

```rust
// body_gen.rs:5093-5100
/// Generate a method reference expression (JADX parity: makeRefLambda)
///
/// Clones JADX's InsnGen.makeRefLambda behavior exactly:
/// - Constructor: `ClassName::new`
/// - Static method: `ClassName::methodName`
/// - Instance method: `instance::methodName`
///
/// JADX source: jadx-core/src/main/java/jadx/core/codegen/InsnGen.java:965-983
fn generate_method_reference<W: CodeWriter>(...)
```

```rust
// body_gen.rs:7567-7576
/// Check if a super call needs to be qualified with the outer class name
/// JADX parity: InsnGen.java:1080-1095 (callSuper method)
///
/// In Java, when an inner class calls a super method of its outer class, it uses
/// qualified super syntax: `OuterClass.super.method()`
fn needs_qualified_super(decl_class_type: &str, ctx: &BodyGenContext) -> bool
```

---

## Quick Reference: Key JADX Source Files

| File | Lines | Purpose | Dexterity Equivalent |
|------|-------|---------|---------------------|
| `InsnGen.java` | 1237 | Instructions → expressions | `body_gen.rs`, `expr_gen.rs` |
| `ClassGen.java` | 887 | Class structure | `class_gen.rs` |
| `MethodGen.java` | 570 | Method signatures | `method_gen.rs` |
| `RegionGen.java` | 385 | Control flow | `body_gen.rs` |
| `ConditionGen.java` | 198 | Boolean conditions | `body_gen.rs` |
| `TypeGen.java` | 137 | Literal formatting | `type_gen.rs` |
| `NameGen.java` | 117 | Variable naming | `body_gen.rs` (ExprGen) |
| `AnnotationGen.java` | 226 | Annotations | `method_gen.rs` |
