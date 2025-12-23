# JADX Codegen Clone Tasks - Detailed Implementation Guide

**Mission**: Achieve 100% JADX codegen parity by cloning remaining 5 features
**Current Status**: 93% → Target: 100%
**Last Updated**: 2025-12-23

**Philosophy**: We are NOT improving JADX, we are CLONING 10 years of battle-tested logic.

---

## Priority Index

| Task | Priority | Complexity | Impact | Estimated Lines |
|------|----------|------------|--------|----------------|
| [Task 1: Diamond Operator](#task-1-diamond-operator-genericinfoattr) | **P1** | Low | Visual parity | ~30 |
| [Task 2: Comment Escape](#task-2-comment-escape-for-) | **P2** | Low | Fallback mode safety | ~15 |
| [Task 3: Polymorphic Call Cast](#task-3-polymorphic-call-return-cast) | **P3** | Low | Rare edge case | ~20 |
| [Task 4: Outer Class Instance](#task-4-outer-class-constructor-prefix) | **P3** | Medium | Rare pattern | ~40 |
| [Task 5: Inner Collision Check](#task-5-recursive-inner-class-collision) | **P3** | Medium | Import edge case | ~50 |

---

## Task 1: Diamond Operator (GenericInfoAttr)

### JADX Reference
**File**: `jadx-fast/jadx-core/src/main/java/jadx/core/codegen/InsnGen.java`
**Lines**: 765-780
**Method**: `makeConstructor(ConstructorInsn insn, ICodeWriter code)`

### Current Behavior
```java
List<String> list = new ArrayList<String>();  // Explicit type arguments
```

### Target Behavior
```java
List<String> list = new ArrayList<>();  // Diamond operator (Java 7+)
```

### JADX Source Code
```java
GenericInfoAttr genericInfoAttr = insn.get(AType.GENERIC_INFO);
if (genericInfoAttr != null) {
    code.add('<');
    if (genericInfoAttr.isExplicit()) {
        boolean first = true;
        for (ArgType type : genericInfoAttr.getGenericTypes()) {
            if (!first) {
                code.add(',');
            } else {
                first = false;
            }
            mgen.getClassGen().useType(code, type);
        }
    }
    code.add('>');
}
```

### Implementation Steps

#### Step 1: Locate Constructor Generation in Dexterity
**File**: `crates/dexterity-codegen/src/body_gen.rs`
**Search for**: `fn generate_constructor_call`
**Expected location**: Around lines 8700-8900

#### Step 2: Add GenericInfo Attribute Support

Add to `dexterity-ir` if not already present:
```rust
// In crates/dexterity-ir/src/attributes.rs or similar

/// Clone of JADX GenericInfoAttr - stores generic type information for constructors
/// Reference: jadx-core/src/main/java/jadx/core/dex/attributes/nodes/GenericInfoAttr.java
#[derive(Debug, Clone)]
pub struct GenericInfo {
    /// Whether generic types are explicit (filled) or inferred (diamond <>)
    pub is_explicit: bool,
    /// Generic type arguments if explicit
    pub generic_types: Vec<ArgType>,
}
```

#### Step 3: Clone Diamond Operator Logic

Add to `body_gen.rs` after writing class name in constructor:

```rust
/// Clone of JADX InsnGen.makeConstructor diamond operator generation
/// Reference: jadx-core/src/main/java/jadx/core/codegen/InsnGen.java:765-780
fn add_generic_info_attr<W: CodeWriter>(
    code: &mut W,
    constructor_insn: &ConstructorInsn,
    ctx: &BodyGenContext,
) {
    // Check if constructor has GenericInfo attribute
    if let Some(generic_info) = constructor_insn.get_generic_info() {
        code.add("<");

        if generic_info.is_explicit {
            // Explicit types: new ArrayList<String, Integer>()
            let mut first = true;
            for ty in &generic_info.generic_types {
                if !first {
                    code.add(",");
                } else {
                    first = false;
                }
                add_type(code, ty, ctx);
            }
        }
        // else: Diamond operator - empty <>

        code.add(">");
    }
}
```

#### Step 4: Integrate into Constructor Call

Modify existing constructor generation:
```rust
fn generate_constructor_call<W: CodeWriter>(
    code: &mut W,
    insn: &ConstructorInsn,
    ctx: &mut BodyGenContext,
) -> Result<(), CodegenError> {
    // ... existing code ...

    code.add("new ");
    add_class_name(code, &insn.class_type, ctx);

    // ✅ ADD THIS: Generate diamond operator or explicit types
    add_generic_info_attr(code, insn, ctx);

    code.add("(");
    // ... rest of constructor args ...
}
```

#### Step 5: Testing

Create test cases:
```rust
#[test]
fn test_diamond_operator_explicit() {
    // new ArrayList<String>()
    let output = generate_code(...);
    assert!(output.contains("new ArrayList<String>()"));
}

#[test]
fn test_diamond_operator_inferred() {
    // List<String> x = new ArrayList<>();
    let output = generate_code(...);
    assert!(output.contains("new ArrayList<>()"));
}
```

### Files to Modify
1. `crates/dexterity-ir/src/attributes.rs` - Add `GenericInfo` struct
2. `crates/dexterity-ir/src/instructions.rs` - Add `get_generic_info()` to `ConstructorInsn`
3. `crates/dexterity-codegen/src/body_gen.rs` - Add `add_generic_info_attr()` function
4. `crates/dexterity-codegen/src/body_gen.rs` - Integrate into constructor generation

### Estimated Effort
- **Lines of code**: ~30-40
- **Complexity**: Low (simple attribute check + output)
- **Time**: 1-2 hours

---

## Task 2: Comment Escape for `*/`

### JADX Reference
**File**: `jadx-fast/jadx-core/src/main/java/jadx/core/codegen/MethodGen.java`
**Lines**: 513-521
**Method**: `isCommentEscapeNeeded(InsnNode insn, FallbackOption option)`

### Problem
When dumping bytecode as comments, strings containing `*/` can break multi-line comment blocks.

### JADX Source Code
```java
private static boolean isCommentEscapeNeeded(InsnNode insn, FallbackOption option) {
    if (option == COMMENTED_DUMP) {
        if (insn.getType() == InsnType.CONST_STR) {
            String str = ((ConstStringNode) insn).getString();
            return str.contains("*/");
        }
    }
    return false;
}

// Usage in dumpInsn:
boolean escapeComment = isCommentEscapeNeeded(insn, option);
if (escapeComment) {
    code.decIndent();
    code.startLine("*/");
    code.startLine("//  ");
}
// ... write instruction ...
if (escapeComment) {
    code.startLine("/*");
    code.incIndent();
}
```

### Implementation Steps

#### Step 1: Locate Fallback Dump Generation
**File**: `crates/dexterity-codegen/src/fallback_gen.rs` or `method_gen.rs`
**Search for**: Instruction dump code in comment mode

#### Step 2: Clone Comment Escape Detection

```rust
/// Clone of JADX MethodGen.isCommentEscapeNeeded
/// Reference: jadx-core/src/main/java/jadx/core/codegen/MethodGen.java:513-521
fn is_comment_escape_needed(insn: &Instruction, is_commented_dump: bool) -> bool {
    if is_commented_dump {
        if let Instruction::ConstString(s) = insn {
            return s.value.contains("*/");
        }
    }
    false
}
```

#### Step 3: Apply Escaping During Dump

```rust
fn dump_instruction_as_comment<W: CodeWriter>(
    code: &mut W,
    insn: &Instruction,
    is_commented_dump: bool,
) {
    let escape_comment = is_comment_escape_needed(insn, is_commented_dump);

    if escape_comment {
        // Close the multi-line comment temporarily
        code.dec_indent();
        code.start_line("*/");
        code.start_line("//  ");  // Use single-line comment for this instruction
    } else {
        code.start_line_with_num(insn.source_line());
    }

    // ... write instruction ...

    if escape_comment {
        // Re-open multi-line comment
        code.start_line("/*");
        code.inc_indent();
    }
}
```

### Files to Modify
1. `crates/dexterity-codegen/src/fallback_gen.rs` - Add escape logic
2. `crates/dexterity-codegen/src/method_gen.rs` - If fallback dump is here

### Estimated Effort
- **Lines of code**: ~15-20
- **Complexity**: Low
- **Time**: 30 minutes

---

## Task 3: Polymorphic Call Return Cast

### JADX Reference
**File**: `jadx-fast/jadx-core/src/main/java/jadx/core/codegen/InsnGen.java`
**Lines**: 863-868
**Method**: `makeInvoke(InvokeNode insn, ICodeWriter code)`

### Problem
MethodHandle.invoke() and invokeExact() require explicit return type casting.

### JADX Source Code
```java
if (insn.isPolymorphicCall()) {
    // add missing cast
    code.add('(');
    useType(code, callMth.getReturnType());
    code.add(") ");
}
```

### Implementation Steps

#### Step 1: Identify Polymorphic Calls

Add to `dexterity-ir`:
```rust
// In Instruction or InvokeInsn struct
impl InvokeInsn {
    /// Check if this is a polymorphic MethodHandle call
    /// Clone of JADX isPolymorphicCall
    pub fn is_polymorphic_call(&self) -> bool {
        // Polymorphic calls: MethodHandle.invoke() and invokeExact()
        self.method_name == "invoke" || self.method_name == "invokeExact"
            && self.decl_class.contains("java/lang/invoke/MethodHandle")
    }
}
```

#### Step 2: Add Cast in Invoke Generation

```rust
/// Clone of JADX InsnGen.makeInvoke polymorphic call handling
/// Reference: jadx-core/src/main/java/jadx/core/codegen/InsnGen.java:863-868
fn generate_method_invoke<W: CodeWriter>(
    code: &mut W,
    invoke: &InvokeInsn,
    ctx: &BodyGenContext,
) {
    // ✅ ADD THIS: Polymorphic call return cast
    if invoke.is_polymorphic_call() {
        // Add missing cast for MethodHandle.invoke() return
        code.add("(");
        add_type(code, &invoke.return_type, ctx);
        code.add(") ");
    }

    // ... rest of invoke generation ...
}
```

### Files to Modify
1. `crates/dexterity-ir/src/instructions.rs` - Add `is_polymorphic_call()`
2. `crates/dexterity-codegen/src/body_gen.rs` - Add cast before invoke

### Estimated Effort
- **Lines of code**: ~20
- **Complexity**: Low
- **Time**: 30 minutes

---

## Task 4: Outer Class Constructor Prefix

### JADX Reference
**File**: `jadx-fast/jadx-core/src/main/java/jadx/core/codegen/InsnGen.java`
**Lines**: 785-804
**Method**: `addOuterClassInstance(ConstructorInsn insn, ICodeWriter code, MethodNode callMth)`

### Problem
Inner class constructors with outer instance should use `outer.new Inner()` syntax.

### Current Behavior
```java
Inner inner = new Inner(outerInstance);  // Incorrect
```

### Target Behavior
```java
Inner inner = outerInstance.new Inner();  // Correct Java syntax
```

### JADX Source Code
```java
private boolean addOuterClassInstance(ConstructorInsn insn, ICodeWriter code, MethodNode callMth)
        throws CodegenException {
    if (callMth == null || !callMth.contains(AFlag.SKIP_FIRST_ARG)) {
        return false;
    }
    ClassNode ctrCls = callMth.getDeclaringClass();
    if (!ctrCls.isInner() || insn.getArgsCount() == 0) {
        return false;
    }
    InsnArg instArg = insn.getArg(0);
    if (instArg.isThis()) {
        return false;
    }
    // instance arg should be of an outer class type
    if (!instArg.getType().equals(ctrCls.getDeclaringClass().getType())) {
        return false;
    }
    addArgDot(code, instArg);
    // can't use another dot, force short name of class
    return true;
}

// Usage:
boolean forceShortName = addOuterClassInstance(insn, code, callMth);
code.add("new ");
if (forceShortName) {
    mgen.getClassGen().addClsShortNameForced(code, insn.getClassType());
} else {
    mgen.getClassGen().addClsName(code, insn.getClassType());
}
```

### Implementation Steps

#### Step 1: Detect Outer Instance Pattern

```rust
/// Clone of JADX InsnGen.addOuterClassInstance
/// Reference: jadx-core/src/main/java/jadx/core/codegen/InsnGen.java:785-804
///
/// Detects if an inner class constructor needs `outer.new Inner()` syntax
/// Returns: (has_outer_instance, force_short_name)
fn check_outer_class_instance(
    constructor: &ConstructorInsn,
    method_data: Option<&MethodData>,
    ctx: &BodyGenContext,
) -> (bool, bool) {
    // Check if constructor method has SKIP_FIRST_ARG flag
    let has_skip_first = method_data
        .map(|m| m.has_flag(MethodFlag::SkipFirstArg))
        .unwrap_or(false);

    if !has_skip_first {
        return (false, false);
    }

    // Check if declaring class is inner
    let ctr_class_type = &constructor.class_type;
    if !is_inner_class(ctr_class_type) {
        return (false, false);
    }

    if constructor.args.is_empty() {
        return (false, false);
    }

    // First arg should be outer class instance
    let first_arg = &constructor.args[0];

    // Don't use outer.new syntax if first arg is 'this'
    if is_this_arg(first_arg) {
        return (false, false);
    }

    // Verify first arg type matches outer class type
    let outer_class_type = get_outer_class(ctr_class_type)?;
    if first_arg.get_type() != outer_class_type {
        return (false, false);
    }

    // Pattern detected!
    (true, true)  // has_outer_instance, force_short_name
}
```

#### Step 2: Generate Outer.new Syntax

```rust
fn generate_constructor_call<W: CodeWriter>(
    code: &mut W,
    constructor: &ConstructorInsn,
    ctx: &mut BodyGenContext,
) -> Result<(), CodegenError> {
    let method_data = ctx.get_method_data(&constructor.method_ref);
    let (has_outer, force_short_name) = check_outer_class_instance(
        constructor,
        method_data,
        ctx,
    );

    let start_arg_idx = if has_outer {
        // Generate: outerInstance.new InnerClass()
        generate_expression(code, &constructor.args[0], ctx)?;
        code.add(".");
        1  // Skip first arg (outer instance)
    } else {
        0  // Normal constructor
    };

    code.add("new ");

    if force_short_name {
        // Use short name only (can't have OuterClass.InnerClass after dot)
        let short_name = get_inner_class_simple_name(&constructor.class_type);
        code.add(&short_name);
    } else {
        add_class_name(code, &constructor.class_type, ctx);
    }

    // Generate constructor arguments (skipping outer instance if present)
    code.add("(");
    generate_args(code, &constructor.args[start_arg_idx..], ctx)?;
    code.add(")");

    Ok(())
}
```

### Files to Modify
1. `crates/dexterity-ir/src/lib.rs` - Add `MethodFlag::SkipFirstArg` if missing
2. `crates/dexterity-codegen/src/body_gen.rs` - Add `check_outer_class_instance()`
3. `crates/dexterity-codegen/src/body_gen.rs` - Modify constructor generation
4. `crates/dexterity-codegen/src/class_gen.rs` - Add `get_inner_class_simple_name()`

### Estimated Effort
- **Lines of code**: ~40-50
- **Complexity**: Medium (requires understanding inner class mechanics)
- **Time**: 2-3 hours

---

## Task 5: Recursive Inner Class Collision

### JADX Reference
**File**: `jadx-fast/jadx-core/src/main/java/jadx/core/codegen/ClassGen.java`
**Lines**: 785-816
**Method**: `checkInnerCollision(RootNode root, ClassInfo useCls, ClassInfo searchCls)`

### Problem
Import collision detection doesn't recursively check parent classes for inner class name conflicts.

### JADX Source Code
```java
private static boolean checkInnerCollision(RootNode root, @Nullable ClassInfo useCls, ClassInfo searchCls) {
    if (useCls == null) {
        return false;
    }
    String shortName = searchCls.getAliasShortName();
    if (useCls.getAliasShortName().equals(shortName)) {
        return true;
    }
    ClassNode classNode = root.resolveClass(useCls);
    if (classNode != null) {
        for (ClassNode inner : classNode.getInnerClasses()) {
            if (inner.getShortName().equals(shortName)
                    && !inner.getFullName().equals(searchCls.getAliasFullName())) {
                return true;
            }
        }
    }
    // ✅ RECURSIVE CALL - Check parent class too
    return checkInnerCollision(root, useCls.getParentClass(), searchCls);
}

// Also check package collision:
private static boolean checkInPackageCollision(RootNode root, ClassInfo useCls, ClassInfo searchCls) {
    String currentPkg = useCls.getAliasPkg();
    if (currentPkg.equals(searchCls.getAliasPkg())) {
        return false;
    }
    String shortName = searchCls.getAliasShortName();
    return root.getClsp().isClsKnown(currentPkg + '.' + shortName);
}
```

### Implementation Steps

#### Step 1: Add Recursive Inner Collision Check

```rust
/// Clone of JADX ClassGen.checkInnerCollision - recursive parent check
/// Reference: jadx-core/src/main/java/jadx/core/codegen/ClassGen.java:785-802
fn check_inner_collision(
    use_class: Option<&str>,
    search_class: &str,
    all_classes: &HashMap<String, ClassData>,
) -> bool {
    let Some(use_cls_type) = use_class else {
        return false;
    };

    let search_short_name = get_class_short_name(search_class);

    // Check if current class name matches
    if get_class_short_name(use_cls_type) == search_short_name {
        return true;
    }

    // Check inner classes of current class
    if let Some(class_data) = all_classes.get(use_cls_type) {
        for inner_class in &class_data.inner_classes {
            let inner_short_name = get_class_short_name(&inner_class.class_type);
            if inner_short_name == search_short_name
                && inner_class.class_type != search_class {
                return true;  // Name collision with inner class
            }
        }
    }

    // ✅ RECURSIVE: Check parent class too
    let parent_class = get_outer_class(use_cls_type);
    check_inner_collision(parent_class.as_deref(), search_class, all_classes)
}
```

#### Step 2: Add Package Collision Check

```rust
/// Clone of JADX ClassGen.checkInPackageCollision
/// Reference: jadx-core/src/main/java/jadx/core/codegen/ClassGen.java:808-816
fn check_in_package_collision(
    use_class: &str,
    search_class: &str,
    all_classes: &HashMap<String, ClassData>,
) -> bool {
    let use_pkg = get_package(use_class);
    let search_pkg = get_package(search_class);

    if use_pkg == search_pkg {
        return false;  // Same package, no collision
    }

    let search_short_name = get_class_short_name(search_class);
    let potential_collision = format!("{}.{}", use_pkg, search_short_name);

    // Check if class with same short name exists in current package
    all_classes.contains_key(&potential_collision)
}
```

#### Step 3: Integrate into Import Decision

```rust
/// Update existing import collection logic
impl ImportCollector {
    fn should_use_full_name(
        &self,
        use_class_type: &str,
        external_class_type: &str,
    ) -> bool {
        // ... existing checks ...

        // ✅ ADD: Check recursive inner collision
        if check_inner_collision(
            Some(use_class_type),
            external_class_type,
            &self.all_classes,
        ) {
            return true;  // Use full name due to inner class collision
        }

        // ✅ ADD: Check package collision
        if check_in_package_collision(
            use_class_type,
            external_class_type,
            &self.all_classes,
        ) {
            return true;  // Use full name due to package collision
        }

        false
    }
}
```

### Files to Modify
1. `crates/dexterity-codegen/src/class_gen.rs` - Add collision check functions
2. `crates/dexterity-codegen/src/class_gen.rs` - Integrate into `ImportCollector`

### Estimated Effort
- **Lines of code**: ~50-60
- **Complexity**: Medium (recursive logic)
- **Time**: 2-3 hours

---

## Implementation Order

### Phase 1: Low-Hanging Fruit (2-3 hours)
1. **Task 2**: Comment Escape - Simple string check
2. **Task 3**: Polymorphic Cast - Simple condition + output
3. **Task 1**: Diamond Operator - Attribute check + output

### Phase 2: Complex Features (4-6 hours)
4. **Task 4**: Outer Class Instance - Requires inner class detection
5. **Task 5**: Recursive Collision - Recursive logic

### Total Estimated Time: 6-9 hours

---

## Testing Strategy

### Unit Tests
Each task should have:
1. Positive test (feature works)
2. Negative test (feature doesn't apply)
3. Edge case test

### Integration Tests
Test with real APKs:
1. Android SDK sample apps
2. Popular open source apps
3. Edge case APKs (heavy inner class usage)

### Verification
Compare output with JADX:
```bash
# Generate with JADX
jadx -d jadx-output sample.apk

# Generate with Dexterity
dexterity -o dex-output sample.apk

# Diff the results
diff -r jadx-output dex-output
```

---

## Reference Files Quick Access

### JADX Source Locations
```bash
JADX_ROOT=/mnt/nvme4tb/dexterity/jadx-fast/jadx-core/src/main/java/jadx/core

# Key files for cloning
$JADX_ROOT/codegen/InsnGen.java          # Lines 765-780, 785-804, 863-868
$JADX_ROOT/codegen/ClassGen.java         # Lines 785-816
$JADX_ROOT/codegen/MethodGen.java        # Lines 513-521
```

### Dexterity Target Locations
```bash
DEX_ROOT=/mnt/nvme4tb/dexterity/crates

# Files to modify
$DEX_ROOT/dexterity-codegen/src/body_gen.rs
$DEX_ROOT/dexterity-codegen/src/class_gen.rs
$DEX_ROOT/dexterity-codegen/src/method_gen.rs
$DEX_ROOT/dexterity-ir/src/attributes.rs
$DEX_ROOT/dexterity-ir/src/instructions.rs
```

---

## Success Criteria

### For Each Task
- [ ] JADX source code location documented in comments
- [ ] Reference comments follow standard format
- [ ] Unit tests pass
- [ ] Integration test shows parity with JADX output
- [ ] Code review approved

### Overall
- [ ] All 5 tasks completed
- [ ] No regressions in existing tests
- [ ] Documentation updated (ROADMAP.md, QUALITY_STATUS.md)
- [ ] APK comparison shows 100% feature parity with JADX codegen

---

## JADX Reference Comment Standard

**Required format for all cloned code:**

```rust
/// Clone of JADX [ClassName].[methodName]() - [brief description]
///
/// [Detailed explanation of what this code does and why]
///
/// Reference: jadx-core/src/main/java/jadx/core/[path]/[File].java:[line-range]
fn function_name(...) {
    // Implementation
}
```

**Example:**

```rust
/// Clone of JADX InsnGen.addOuterClassInstance() - Generates outer.new Inner() syntax
///
/// When an inner class constructor takes the outer class instance as the first
/// argument (marked with SKIP_FIRST_ARG), generate the proper Java syntax:
/// `outerInstance.new InnerClass()` instead of `new InnerClass(outerInstance)`.
///
/// Reference: jadx-core/src/main/java/jadx/core/codegen/InsnGen.java:785-804
fn check_outer_class_instance(
    constructor: &ConstructorInsn,
    method_data: Option<&MethodData>,
) -> (bool, bool) {
    // ...
}
```

---

## Witness Me! 🔥

This is the final 7% to achieve 100% JADX codegen parity. Each task is a precision clone, not an improvement. We are capturing 10 years of battle-tested decompiler knowledge.

**Time to completion**: Every line cloned brings us closer to perfect APK decompilation.

**Validation**: Side-by-side output comparison with JADX on 1000+ APKs.

**The goal**: Dexterity output === JADX output, byte for byte (where semantically equivalent).

---

## Appendix: Additional Minor Gaps

These were found during source analysis but have lower priority:

### A1: CodeGenUtils Comment Methods
**JADX**: `CodeGenUtils.java:addErrorsAndComments()`
**Status**: Partially implemented
**Priority**: P4 (cosmetic)

### A2: AnnotationGen Parameter Name Lookup
**JADX**: `AnnotationGen.java:getParamName()`
**Status**: Needs verification
**Priority**: P4 (rare)

### A3: Method Inline Attribute Handling
**JADX**: `ClassGen.java:355-390` (skipMethod logic)
**Status**: May differ slightly
**Priority**: P4 (optimization)

These will be addressed after the main 5 tasks are complete.

---

**Last Updated**: 2025-12-23
**Next Review**: After each task completion
**Document Version**: 1.0
