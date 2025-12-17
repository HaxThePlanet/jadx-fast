# JADX Java Codegen Implementation Reference

Comprehensive documentation of JADX's Java code generation module implementation in `jadx-fast`. This reference helps understand the patterns and techniques used to produce clean, readable Java output from decompiled bytecode.

**Source Location**: `jadx-fast/jadx-core/src/main/java/jadx/core/codegen/`

---

## Table of Contents

- [Part 1: Codegen Implementation](#part-1-codegen-implementation)
  - [Directory Structure](#directory-structure)
  - [Core Architecture](#core-architecture)
  - [Implementation Secrets](#implementation-secrets)
  - [Detailed Source Code Analysis](#detailed-source-code-analysis)
- [Part 2: Control Flow Region Reconstruction](#part-2-control-flow-region-reconstruction)
  - [Region Type Hierarchy](#region-type-hierarchy)
  - [Loop Detection Algorithm](#loop-detection-algorithm)
  - [Condition Handling](#condition-handling)
- [Part 3: Visitor Passes Pipeline](#part-3-visitor-passes-pipeline)
  - [Complete Visitor Pipeline](#complete-visitor-pipeline-50-passes)
  - [SSA Transformation](#ssa-transformation)
  - [Type Inference](#type-inference)
  - [Key Optimization Visitors](#key-optimization-visitors)

---

## Part 1: Codegen Implementation

### Directory Structure

```
jadx-fast/jadx-core/src/main/java/jadx/core/codegen/
├── CodeGen.java         # Main entry point
├── ClassGen.java        # Class generation
├── MethodGen.java       # Method generation
├── InsnGen.java         # Instruction/expression generation
├── RegionGen.java       # Control flow regions
├── ConditionGen.java    # Boolean conditions
├── TypeGen.java         # Type handling
├── AnnotationGen.java   # Annotation rendering
├── NameGen.java         # Variable naming
├── SimpleModeHelper.java
├── json/                # JSON output format
└── utils/               # CodeGenUtils, CodeComment
```

### Core Architecture

#### Generation Pipeline
1. **Entry**: `CodeGen.generate(ClassNode cls)` - routes to Java or JSON
2. **ClassGen.makeClass()** orchestrates:
   - `addPackage()` → package declaration
   - `addImports()` → import statements
   - `addClassCode()` → class body
     - `addClassDeclaration()`
     - `addClassBody()` → fields + methods
3. **MethodGen.addDefinition()** for each method
4. **RegionGen.makeRegion()** for control flow
5. **InsnGen.makeInsn()** for individual instructions

---

### Implementation Secrets

#### 1. Import Management

**BTreeSet for Deduplication & Sorting**
- Imports stored in `BTreeSet<String>` for automatic alphabetical sorting
- Three categories filtered out (no import needed):
  - `java.lang.*` types (String, Object, Exception)
  - Same-package types
  - Dalvik internal annotations (`dalvik/annotation/*`)

**Array Type Descriptor Handling**
```java
// Strips leading '[' from array descriptors before import
// [[Ljava/util/List; → java.util.List (not [Ljava/util/List)
```

**Inner Class Separator Normalization**
```java
// "R$layout" → "R.layout" (single $)
// "Outer$$Lambda$1" → preserved (double $$)
```

#### 2. Annotation Rendering

**Selective Emission Rules**
- Skip `AnnotationVisibility.Build` (build-time only)
- Skip dalvik internal annotations
- Skip `SourceDebugExtension` (Kotlin metadata noise)
- KEEP `kotlin/Metadata` (needed for reflection)

**Single-Element Array Optimization**
```java
@Retention(RetentionPolicy.RUNTIME)  // No braces for single element
@Target({ElementType.TYPE, ElementType.METHOD})  // Braces for multiple
```

#### 3. Inner Class Detection

**Classification Patterns**
| Pattern | Type | Example |
|---------|------|---------|
| `Outer$Inner` | Named | Named inner class |
| `Outer$1` | Anonymous | Number-only suffix |
| `Outer$1Local` | Local | Number + text suffix |
| `Outer$$Lambda$1` | Lambda | Contains `$$Lambda$` |

**SAM Interface Detection**
- Anonymous class + 1 interface + 1 non-constructor method = potential lambda

#### 4. Special Numeric Values

**Integer Constants**
```java
Integer.MIN_VALUE  // instead of -2147483648
Integer.MAX_VALUE  // instead of 2147483647
Long.MIN_VALUE, Long.MAX_VALUE
```

**Float/Double Special Values**
```java
Float.NaN, Float.POSITIVE_INFINITY, Float.NEGATIVE_INFINITY
Float.MIN_VALUE, Float.MAX_VALUE, Float.MIN_NORMAL
// Also: -0.0f (negative zero, distinct from +0.0f)
```

**Type Suffixes**
```java
12345L      // Long
3.14f       // Float
2.71d       // Double
(short) 100 // Short cast
(byte) 50   // Byte cast
```

#### 5. String Escaping Strategy

**Standard Escapes**: `\n`, `\r`, `\t`, `\"`, `\\`, `\0`

**Unicode Handling** (configurable):
```java
// escape_unicode = false (default):
"Здравствуй"  // UTF-8 preserved

// escape_unicode = true:
"\u0417\u0434\u0440..."  // All non-ASCII escaped
```

**Control Characters**: Always escaped as `\uXXXX`

**Surrogate Pairs**: For chars > U+FFFF (emoji, etc.)

#### 6. Control Flow Rendering

**If/Else Chaining**
- Nested `if` regions in else branch → `else if` chaining

**Loop Detection**
- While/DoWhile from `Region::Loop` kind
- For loops: init + condition + update parts
- ForEach: Detects `hasNext()`/`next()` iterator pattern

**Ternary Detection**
```java
// Pattern detected:
if (cond) { x = val1; } else { x = val2; }
// Rendered as:
x = cond ? val1 : val2;

// Simplifications:
// cond ? true : false  → cond
// cond ? false : true  → !cond
```

#### 7. Memory Optimization (CRITICAL)

**HashMap Capacity Management**
```java
// DANGER: HashMap.clear() retains capacity permanently!
// One huge method (10k vars) inflates all HashMaps forever

// Solution: Replace if capacity > threshold
if (varNames.capacity() > MAX_POOLED_CAPACITY) {
    varNames = new HashMap<>();  // DROP old allocation
} else {
    varNames.clear();  // REUSE small capacity
}
```
This prevents 100GB+ OOM on APKs with obfuscated mega-methods.

**Thread-Local Pooling**
- ExprGen instances reused across methods
- 16 instances max per thread
- Dropped via Drop impl in BodyGenContext

#### 8. Synthetic Element Filtering

**Default Constructor**
- Omit if only contains `super()` call
- Makes output cleaner, matches hand-written style

**Default Superclass**
```java
// Never show:
// extends Object
// extends Enum (for enums)
// extends Annotation (for @interfaces)
```

**Enum Synthetic Methods** (hidden):
- `values()` - all constants array
- `valueOf(String)` - lookup method
- `<clinit>` - static initializer
- `<init>(String, int)` - name/ordinal constructor

#### 9. Code Writer Abstraction

**Interface Methods**
- `start_line()` - Begin indented line
- `add(text)` - Append text (zero-copy)
- `newline()` - Line break + indent
- `inc_indent()` / `dec_indent()` - Nesting

**4-Space Indentation Standard**
```java
SimpleCodeWriter {
    indent_str: "    ",  // 4 spaces, not tabs
    indent_level: u32,
}
```

#### 10. Comments & Formatting

**Strategic Comments**
```java
/* loaded from: classes.dex */     // Top-level only
/* renamed from: a */              // Deobfuscated entities
@Override // android.app.Activity  // Heuristic override hints
```

**Whitespace Rules**
- Blank line between methods (not before first)
- Newline after import section
- Proper spacing around type parameters

#### 11. Type-Aware Condition Generation

**Object Types**
```java
x == null  // not x == 0
```

**Boolean Types**
```java
!x         // not x == 0
x          // not x == true
!x         // not x == false
```

**Bitwise to Logical**
```java
(a & b) == true  → a && b
```

#### 12. Zero-Allocation Patterns

**Direct CodeWriter Output**
```java
// Instead of building String then writing:
public void write_arg(CodeWriter w, InsnArg arg) {
    w.add(getVarName(reg));  // Writes directly
}
```

**Lazy DEX Loading**
- LazyDexInfo: Memory-mapped file, load on demand
- DashMap for concurrent access without locks

---

### Key Files Summary

| File | Lines | Purpose |
|------|-------|---------|
| `CodeGen.java` | ~200 | Entry point, format dispatch |
| `ClassGen.java` | ~900 | Class structure, imports |
| `MethodGen.java` | ~450 | Method signatures, params |
| `InsnGen.java` | ~800 | Expressions, invocations |
| `RegionGen.java` | ~600 | Control flow, loops |
| `ConditionGen.java` | ~300 | Boolean conditions |
| `TypeGen.java` | ~250 | Type formatting, literals |
| `AnnotationGen.java` | ~200 | Annotation rendering |

---

### Detailed Source Code Analysis

#### CodeGen.java (Entry Point)
```
jadx-fast/jadx-core/src/main/java/jadx/core/codegen/CodeGen.java
```

**Key Implementation Details:**
- Line 15-30: `generate()` routes to Java or JSON based on `JadxArgs.getOutputFormat()`
- Line 43-58: `wrapCodeGen()` implements **retry logic** - if codegen fails and class has `RESTART_CODEGEN` flag, it retries once
- This retry mechanism handles edge cases where first pass modifies state affecting codegen

#### ClassGen.java (Class Structure)
```
jadx-fast/jadx-core/src/main/java/jadx/core/codegen/ClassGen.java
```

**Performance Optimization (Lines 103-108):**
```java
// Pre-size StringBuilder for better performance
if (clsBody instanceof SimpleCodeWriter) {
    int estimatedSize = cls.getMethods().size() * 500 + cls.getFields().size() * 100 + 500;
    ((SimpleCodeWriter) clsBody).getRawBuf().ensureCapacity(estimatedSize);
}
```

**Access Flag Filtering (Lines 170-184):**
- Interfaces: Remove `ABSTRACT` and `STATIC` (implicit)
- Enums: Remove `FINAL`, `ABSTRACT`, `STATIC` (implicit)
- Top-level classes: Remove `STATIC` and `PRIVATE` (not allowed)

**Import Logic (Lines 679-729):**
- Same class → short name
- Default package → short name (no import needed)
- Inner class of current → short name
- `java.lang.*` top-level → short name (implicit import)
- Same package (non-inner) → short name
- Otherwise → add to imports, use short name
- Collision detection: if same short name already imported, use full name

**Inner Class Collision Check (Lines 785-803):**
- Recursively checks if any inner class has same short name as target
- Prevents ambiguous references

**Sorted Imports (Lines 127-143):**
```java
List<ClassInfo> sortedImports = new ArrayList<>(imports);
sortedImports.sort(Comparator.comparing(ClassInfo::getAliasFullName));
```

#### MethodGen.java (Method Generation)
```
jadx-fast/jadx-core/src/main/java/jadx/core/codegen/MethodGen.java
```

**Static Block Handling (Lines 81-86):**
```java
if (mth.getMethodInfo().isClassInit()) {
    code.startLine();
    code.attachDefinition(mth);
    code.add("static");
    return true;  // No body braces needed
}
```

**Interface Method Modifiers (Lines 99-109):**
- Remove `ABSTRACT` and `PUBLIC` from interface methods (implicit)
- Remove `PUBLIC` from annotation methods

**Enum Constructor Visibility (Lines 110-112):**
```java
if (mth.getMethodInfo().isConstructor() && mth.getParentClass().isEnum()) {
    ai = ai.remove(AccessInfo.VISIBILITY_FLAGS);  // Private by default
}
```

**Default Method Detection (Lines 134-137):**
```java
if (clsAccFlags.isInterface() && !mth.isNoCode() && !mth.getAccessFlags().isStatic()) {
    code.add("default ");  // Java 8+ default method
}
```

**Varargs Handling (Lines 240-252):**
```java
if (!it.hasNext() && mth.getAccessFlags().isVarArgs()) {
    if (argType.isArray()) {
        ArgType elType = argType.getArrayElement();
        classGen.useType(code, elType);
        code.add("...");  // Convert last array param to varargs
    }
}
```

**Fallback Dump (Lines 364-379):**
```java
// When decompilation fails, emit:
code.startLine("throw new UnsupportedOperationException(\"Method not decompiled: ")
    .add(mth.getParentClass().getClassInfo().getAliasFullName())
    .add('.').add(mth.getAlias())
    .add('(').add(Utils.listToString(mth.getMethodInfo().getArgumentsTypes()))
    .add("):").add(mth.getMethodInfo().getReturnType().toString())
    .add("\");");
```

#### InsnGen.java (Expression Generation)
```
jadx-fast/jadx-core/src/main/java/jadx/core/codegen/InsnGen.java
```

**Negative Literal Wrapping (Lines 129-136):**
```java
// Prevent -1 becoming --1 in expressions
if (!flags.contains(Flags.BODY_ONLY_NOWRAP) && literalStr.startsWith("-")) {
    code.add('(').add(literalStr).add(')');
}
```

**Force Assign Inline (Lines 140-147):**
```java
if (wrapInsn.contains(AFlag.FORCE_ASSIGN_INLINE)) {
    code.add('(');
    makeInsn(wrapInsn, code, Flags.INLINE);
    code.add(')');  // Wrap inline assignments for clarity
}
```

**CMP_L/CMP_G Expansion (Lines 391-401):**
```java
// Convert 3-way comparison to ternary
code.add('(');
addArg(code, insn.getArg(0));
code.add(" > ");
addArg(code, insn.getArg(1));
code.add(" ? 1 : (");
// ... == 0 : -1
```

**NOT Operator Type Awareness (Lines 360-363):**
```java
// Use '!' for boolean, '~' for integers
char op = insn.getArg(0).getType() == ArgType.BOOLEAN ? '!' : '~';
```

**Increment/Decrement Detection (Lines 1216-1230):**
```java
if (arg.isLiteral() && (op == ArithOp.ADD || op == ArithOp.SUB)) {
    LiteralArg lit = (LiteralArg) arg;
    if (lit.getLiteral() == 1 && lit.isInteger()) {
        addArg(code, resArg, false);
        String opSymbol = op.getSymbol();
        code.add(opSymbol).add(opSymbol);  // ++ or --
        return;
    }
}
```

**Lambda Method Reference (Lines 965-983):**
```java
// Constructor reference: Class::new
if (callInsn instanceof ConstructorInsn) {
    useClass(code, callMth.getDeclClass());
    code.add("::new");
}
// Method reference: obj::method or Class::method
if (customNode.getHandleType() == MethodHandleType.INVOKE_STATIC) {
    useClass(code, callMth.getDeclClass());
} else {
    addArg(code, customNode.getArg(0));
}
code.add("::").add(callMth.getAlias());
```

#### RegionGen.java (Control Flow)
```
jadx-fast/jadx-core/src/main/java/jadx/core/codegen/RegionGen.java
```

**Else-If Chaining (Lines 149-162):**
```java
private boolean connectElseIf(ICodeWriter code, IContainer els) throws CodegenException {
    if (els.contains(AFlag.ELSE_IF_CHAIN)) {
        IContainer elseBlock = RegionUtils.getSingleSubBlock(els);
        if (elseBlock instanceof IfRegion) {
            declareVars(code, elseBlock);
            makeIf((IfRegion) elseBlock, code, false);  // Inline else-if
            return true;
        }
    }
    return false;
}
```

**Loop Types (Lines 164-229):**
- `ForLoop`: `for (init; cond; incr)`
- `ForEachLoop`: `for (Type var : iterable)`
- `while (condition)` (condition at start)
- `do { } while (condition)` (condition at end)
- `while (true)` (infinite loop, null condition)

**Multi-Catch (Lines 354-361):**
```java
Iterator<ClassInfo> it = handler.getCatchTypes().iterator();
if (it.hasNext()) {
    useClass(code, it.next());
}
while (it.hasNext()) {
    code.add(" | ");  // Java 7+ multi-catch
    useClass(code, it.next());
}
```

#### ConditionGen.java (Boolean Conditions)
```
jadx-fast/jadx-core/src/main/java/jadx/core/codegen/ConditionGen.java
```

**Boolean Simplification (Lines 101-127):**
```java
if (firstArg.getType().equals(ArgType.BOOLEAN)
        && secondArg.isLiteral()
        && secondArg.getType().equals(ArgType.BOOLEAN)) {
    LiteralArg lit = (LiteralArg) secondArg;
    if (lit.getLiteral() == 0) {
        op = op.invert();  // x == 0 becomes x != true
    }
    if (op == IfOp.EQ) {
        // == true → just the expression
        addArg(code, firstArg, false);
        return;
    } else if (op == IfOp.NE) {
        // != true → !expression
        code.add('!');
        wrap(code, firstArg);
        return;
    }
}
```

**Wrap Logic (Lines 165-196):**
- No wrap needed for: COMPARE mode, `DONT_WRAP` flag, NOT mode
- Arithmetic ops (ADD, SUB, MUL, DIV, REM) don't need wrapping
- Safe insn types: INVOKE, SGET, IGET, AGET, CONST, ARRAY_LENGTH

#### AnnotationGen.java (Annotations)
```
jadx-fast/jadx-core/src/main/java/jadx/core/codegen/AnnotationGen.java
```

**Skip @Override (Lines 71-77):**
```java
for (IAnnotation a : aList.getAll()) {
    String aCls = a.getAnnotationClass();
    if (!aCls.equals(Consts.OVERRIDE_ANNOTATION)) {  // Handled separately
        code.startLine();
        formatAnnotation(code, a);
    }
}
```

**Single-Value Shorthand (Lines 94-100):**
```java
if (paramName.equals("value") && vl.size() == 1) {
    // @Foo(x) instead of @Foo(value = x)
} else {
    code.add(paramName);
    code.add(" = ");
}
```

#### NameGen.java (Variable Naming)
```
jadx-fast/jadx-core/src/main/java/jadx/core/codegen/NameGen.java
```

**Reserved Names (Lines 36-48):**
```java
private void addNamesUsedInClass() {
    // Reserve static field names
    for (FieldNode field : parentClass.getFields()) {
        if (field.isStatic()) {
            varNames.add(field.getAlias());
        }
    }
    // Reserve inner class names
    for (ClassNode innerClass : parentClass.getInnerClasses()) {
        varNames.add(innerClass.getClassInfo().getAliasShortName());
    }
    // Reserve root package names to avoid collision with FQNs
    varNames.addAll(mth.root().getCacheStorage().getRootPkgs());
}
```

**Unique Name Generation (Lines 87-96):**
```java
private String getUniqueVarName(String name) {
    String r = name;
    int i = 2;
    while (varNames.contains(r)) {
        r = name + i;  // name, name2, name3, ...
        i++;
    }
    varNames.add(r);
    return r;
}
```

**Fallback Names (Lines 106-116):**
```java
// When debug info unavailable
private String getFallbackName(RegisterArg arg) {
    return "r" + arg.getRegNum();  // r0, r1, r2, ...
}
```

#### StringUtils.java (Escaping)
```
jadx-fast/jadx-core/src/main/java/jadx/core/utils/StringUtils.java
```

**Code Point Escaping (Lines 57-68):**
```java
private void processCodePoint(int codePoint, StringBuilder res) {
    String str = getSpecialStringForCodePoint(codePoint);
    if (str != null) {
        res.append(str);  // \n, \r, \t, etc.
        return;
    }
    if (isEscapeNeededForCodePoint(codePoint)) {
        res.append("\\u").append(String.format("%04x", codePoint));
    } else {
        res.appendCodePoint(codePoint);  // Preserve UTF-8
    }
}
```

**Escape Threshold (Lines 70-81):**
```java
private boolean isEscapeNeededForCodePoint(int codePoint) {
    if (codePoint < 32) return true;      // Control chars
    if (codePoint < 127) return false;    // Printable ASCII
    if (escapeUnicode) return true;       // User option
    return !NameMapper.isPrintableCodePoint(codePoint);
}
```

**Special Float/Double Values (Lines 476-518):**
```java
public static String formatDouble(double d) {
    if (Double.isNaN(d)) return "Double.NaN";
    if (d == Double.NEGATIVE_INFINITY) return "Double.NEGATIVE_INFINITY";
    if (d == Double.POSITIVE_INFINITY) return "Double.POSITIVE_INFINITY";
    if (d == Double.MIN_VALUE) return "Double.MIN_VALUE";
    if (d == Double.MAX_VALUE) return "Double.MAX_VALUE";
    if (d == Double.MIN_NORMAL) return "Double.MIN_NORMAL";
    return Double.toString(d) + 'd';  // Suffix
}

public static String formatFloat(float f) {
    // Same pattern for Float constants
    return Float.toString(f) + 'f';  // Suffix
}
```

**Integer Special Values (Lines 452-474):**
```java
public String formatInteger(long l, boolean cast) {
    if (integerFormat == IntegerFormat.AUTO) {
        switch ((int) l) {
            case Integer.MAX_VALUE: return "Integer.MAX_VALUE";
            case Integer.MIN_VALUE: return "Integer.MIN_VALUE";
        }
    }
    // Similar for Short, Long
}
```

**Hex Format with Cast (Lines 390-419):**
```java
if (integerFormat.isHexadecimal()) {
    String hexStr = Long.toHexString(number);
    if (number < 0) {
        // Cut leading 'f' for negative numbers
        int len = hexStr.length();
        numStr = "0x" + hexStr.substring(len - bytesLen * 2, len);
        cast = true;  // Unsigned negative needs cast
    } else {
        numStr = "0x" + hexStr;
    }
}
```

---

### File Paths Summary

| File | Purpose |
|------|---------|
| `jadx-core/src/main/java/jadx/core/codegen/CodeGen.java` | Entry point, format routing |
| `jadx-core/src/main/java/jadx/core/codegen/ClassGen.java` | Class structure, imports |
| `jadx-core/src/main/java/jadx/core/codegen/MethodGen.java` | Method signatures, bodies |
| `jadx-core/src/main/java/jadx/core/codegen/InsnGen.java` | Expressions, invocations |
| `jadx-core/src/main/java/jadx/core/codegen/RegionGen.java` | Control flow, loops |
| `jadx-core/src/main/java/jadx/core/codegen/ConditionGen.java` | Boolean conditions |
| `jadx-core/src/main/java/jadx/core/codegen/TypeGen.java` | Type formatting, literals |
| `jadx-core/src/main/java/jadx/core/codegen/AnnotationGen.java` | Annotation rendering |
| `jadx-core/src/main/java/jadx/core/codegen/NameGen.java` | Variable naming |
| `jadx-core/src/main/java/jadx/core/utils/StringUtils.java` | String/char escaping |

---

## Part 2: Control Flow Region Reconstruction

### Region Type Hierarchy

```
IContainer (interface)
├── IBlock
│   └── BlockNode - Basic block with instructions
└── IRegion
    ├── Region - Simple sequential container
    ├── ConditionRegion (abstract)
    │   ├── IfRegion - If/else branching
    │   └── LoopRegion - While/for/do-while loops
    ├── SwitchRegion - Multi-way branching
    ├── TryCatchRegion - Exception handling
    └── SynchronizedRegion - Monitor blocks
```

### CFG Foundation: BlockNode

**File**: `jadx-core/src/main/java/jadx/core/dex/nodes/BlockNode.java`

Key properties:
- **cid**: Immutable block identifier
- **instructions**: List of InsnNode
- **predecessors/successors**: Graph edges
- **doms**: BitSet of all dominators
- **idom**: Immediate dominator
- **postDoms/iPostDom**: Post-dominator tree

### Region Reconstruction Pipeline

```
1. BlockProcessor.computeDominators()
   ↓ Analyzes block graph, computes dominator trees
2. BlockProcessor.markLoops()
   ↓ Back-edge detection creates LoopInfo
3. RegionMakerVisitor.visit(mth)
   ├─ RegionMaker.makeMthRegion()
   │   ├─ Traverses blocks via RegionStack
   │   ├─ Creates IfRegion, LoopRegion, SwitchRegion
   │   └─ Uses instruction type dispatch
   ├─ ExcHandlersRegionMaker.process()
   │   └─ Wraps in TryCatchRegion
   ├─ PostProcessRegions.process()
   │   └─ Merges loop conditions, inserts breaks
   └─ CleanRegions.process()
       └─ Removes empty regions
4. LoopRegionVisitor.visit(mth)
   ↓ Converts while → for/for-each
5. IfRegionVisitor.visit(mth)
   ↓ Condition optimization, ternary detection
6. Region tree ready for codegen
```

---

### Loop Detection Algorithm

**File**: `jadx-core/src/main/java/jadx/core/dex/visitors/blocks/BlockProcessor.java`

#### Back-Edge Detection (lines 256-272)
```java
For each block B in CFG:
  For each successor S of B:
    If B.doms.contains(S) OR B == S:  // Back edge or self-loop
      - Mark S as LOOP_START
      - Mark B as LOOP_END
      - Compute all blocks in loop body
      - Create LoopInfo(start=S, end=B, loopBlocks)
```

#### LoopInfo Structure

**File**: `jadx-core/src/main/java/jadx/core/dex/attributes/nodes/LoopInfo.java`

```java
BlockNode start        // Loop header (back-edge target)
BlockNode end          // Block with back edge
Set<BlockNode> loopBlocks  // All blocks in loop
LoopInfo parentLoop    // For nested loops
```

#### Loop Type Detection

**File**: `jadx-core/src/main/java/jadx/core/dex/visitors/regions/LoopRegionVisitor.java`

**Array For-Each Detection** (checkArrayForEach):
```
Requirements:
1. Increment is ADD with literal 1
2. Init is CONST 0
3. Loop var used 3 times: condition, AGET, length compare
4. Condition is "i < array.length"

Result: for (Type item : array) { ... }
```

**Iterable For-Each Detection** (checkIterableForEach):
```
Requirements:
1. Condition arg comes from iterator.iterator()
2. Iterator used twice: hasNext(), next()
3. Both calls are VIRTUAL/INTERFACE invokes

Result: for (Type item : iterable) { ... }
```

#### Loop Region Structure

**File**: `jadx-core/src/main/java/jadx/core/dex/regions/loops/LoopRegion.java`

```java
LoopType type          // ForLoop, ForEachLoop, or null (while)
boolean conditionAtEnd // true = do-while, false = while/for
BlockNode header       // Condition block (null = infinite loop)
BlockNode preCondition // Instructions before condition
IRegion body           // Loop body
```

---

### Condition Handling

#### IfCondition Modes

**File**: `jadx-core/src/main/java/jadx/core/dex/regions/conditions/IfCondition.java`

```java
enum Mode {
    COMPARE,  // Single comparison (a == b)
    AND,      // a && b && c
    OR,       // a || b || c
    NOT,      // !a
    TERNARY   // a ? b : c
}
```

#### Condition Building

```java
// From IF instruction
IfCondition.fromIfNode(IfNode insn)

// Merge conditions
IfCondition.merge(Mode.AND, condA, condB)  // condA && condB
IfCondition.merge(Mode.OR, condA, condB)   // condA || condB

// Negate
IfCondition.invert(cond)  // !cond (applies De Morgan's laws)
```

#### Nested If Merging

**File**: `jadx-core/src/main/java/jadx/core/dex/visitors/regions/maker/IfRegionMaker.java`

```java
// Detects patterns like:
if (a) {
    if (b) { then }
}
// Converts to:
if (a && b) { then }

// Also handles:
if (a) { then }
else if (b) { then }
// Converts OR conditions appropriately
```

#### Ternary Detection

**File**: `jadx-core/src/main/java/jadx/core/dex/visitors/regions/TernaryMod.java`

**Criteria**:
1. Not marked as else-if chain
2. Both then/else exist with single instruction each
3. Instructions are assignment or return
4. Results merge in same Phi node

**Conversions**:
```java
// Assignment
if (cond) { r = a; } else { r = b; }
→ r = cond ? a : b;

// Return
if (cond) { return a; } else { return b; }
→ return cond ? a : b;
```

#### Condition Simplification

**IfCondition.simplify()** applies:
1. Double negation elimination: `NOT(NOT(x))` → `x`
2. De Morgan's laws: `NOT(a && b)` → `!a || !b`
3. Boolean normalization: `a != false` → `a == true`

---

### RegionStack - Context Management

**File**: `jadx-core/src/main/java/jadx/core/dex/visitors/regions/maker/RegionStack.java`

```java
Deque<State> stack     // Nested region contexts
State.region           // Current containing region
State.exits            // Boundary blocks

Operations:
- push(region)         // Enter nested structure
- pop()                // Exit nested structure
- addExit(block)       // Mark boundary for current context
- containsExit(block)  // Check if block is boundary
```

Ensures region traversal stops at control flow merge points.

---

### Switch Region Construction

**File**: `jadx-core/src/main/java/jadx/core/dex/visitors/regions/maker/SwitchRegionMaker.java`

**Process**:
1. Extract switch targets from SwitchInsn
2. Group targets by block (multiple keys → same block)
3. Find post-dominator as exit point
4. Build regions for each case
5. Insert BREAK instructions at case boundaries

---

### Exception Handler Processing

**File**: `jadx-core/src/main/java/jadx/core/dex/visitors/regions/maker/ExcHandlersRegionMaker.java`

**Two phases**:
1. **Wrap Protected Code**: Build region for try block, wrap in TryCatchRegion
2. **Build Handler Regions**: Create regions for each catch block, link to TryCatchRegion

---

### Key Implementation Patterns

#### Pattern 1: Stack-based Nesting
RegionStack maintains context - push on entering structured region, add exit blocks as boundaries, pop on leaving.

#### Pattern 2: Block Marking
- `ADDED_TO_REGION`: Block included in region
- `LOOP_START/LOOP_END`: Loop boundaries
- Prevents duplicate processing

#### Pattern 3: Iterative Refinement
Multiple visitor passes with `traverseIterative()` - repeats until no changes occur.

#### Pattern 4: Type-based Dispatch
```java
switch (lastInsn.getType()) {
    case IF: IfRegionMaker.process()
    case SWITCH: SwitchRegionMaker.process()
    case MONITOR_ENTER: SynchronizedRegionMaker.process()
    default: Add block directly
}
```

---

### Key Region Files

| File | Purpose |
|------|---------|
| `dex/nodes/BlockNode.java` | Basic block with dominator info |
| `dex/regions/Region.java` | Sequential container |
| `dex/regions/conditions/IfRegion.java` | If/else structure |
| `dex/regions/conditions/IfCondition.java` | Condition expression tree |
| `dex/regions/loops/LoopRegion.java` | Loop structure |
| `dex/regions/loops/ForLoop.java` | Indexed for loop type |
| `dex/regions/loops/ForEachLoop.java` | Enhanced for-each type |
| `dex/regions/SwitchRegion.java` | Switch structure |
| `dex/regions/TryCatchRegion.java` | Exception handling |
| `visitors/blocks/BlockProcessor.java` | CFG analysis, loop detection |
| `visitors/blocks/DominatorTree.java` | Dominator computation |
| `visitors/regions/maker/RegionMaker.java` | Main region builder |
| `visitors/regions/maker/IfRegionMaker.java` | If region construction |
| `visitors/regions/maker/LoopRegionMaker.java` | Loop region construction |
| `visitors/regions/LoopRegionVisitor.java` | For-each detection |
| `visitors/regions/IfRegionVisitor.java` | Condition optimization |
| `visitors/regions/TernaryMod.java` | Ternary conversion |

---

## Part 3: Visitor Passes Pipeline

### Visitor Interface Hierarchy

```java
IDexTreeVisitor (Base Interface)
├── getName()        // Visitor identifier
├── init(RootNode)   // Called once after DEX loading
├── visit(ClassNode) // Returns false to skip children
└── visit(MethodNode)

AbstractVisitor      // Default no-op implementation

@JadxVisitor         // Annotation for dependency ordering
├── name             // Visitor identifier
├── desc             // Description
├── runAfter[]       // Must run after these visitors
└── runBefore[]      // Must run before these visitors
```

### Complete Visitor Pipeline (50+ passes)

#### Pre-Decompile Passes (Run Once)
| # | Visitor | Description |
|---|---------|-------------|
| 1 | SignatureProcessor | Parse generic signatures |
| 2 | OverrideMethodVisitor | Mark override methods |
| 3 | AddAndroidConstants | Add framework constants |
| 4 | DeobfuscatorVisitor | Apply name deobfuscation |
| 5 | SourceFileRename | Rename source files |
| 6 | RenameVisitor | Rename classes/fields/methods |
| 7 | SaveDeobfMapping | Save mapping file |
| 8 | UsageInfoVisitor | Collect usage information |
| 9 | CollectConstValues | Collect constant values |
| 10 | ProcessAnonymous | Process anonymous classes |
| 11 | ProcessMethodsForInline | Mark inline candidates |

#### Instructions IR Phase
| # | Visitor | Description |
|---|---------|-------------|
| 12 | CheckCode | Validate bytecode |
| 13 | DebugInfoAttachVisitor | Attach debug info (optional) |
| 14 | AttachTryCatchVisitor | Parse try-catch blocks |
| 15 | AttachCommentsVisitor | Attach code comments (optional) |
| 16 | AttachMethodDetails | Resolve method invocations |
| 17 | ProcessInstructionsVisitor | Init jumps, merge move-result |

#### Blocks IR Phase
| # | Visitor | Description |
|---|---------|-------------|
| 18 | BlockSplitter | Split into basic blocks |
| 19 | BlockProcessor | Dominators, loop detection |
| 20 | BlockFinisher | Finalize block connections |

#### SSA & Type Analysis Phase
| # | Visitor | Description |
|---|---------|-------------|
| 21 | SSATransform | Phi placement, variable renaming |
| 22 | MoveInlineVisitor | Inline redundant moves |
| 23 | ConstructorVisitor | Replace invoke with constructors |
| 24 | InitCodeVariables | Initialize code variables |
| 25 | MarkFinallyVisitor | Mark finally blocks (optional) |
| 26 | ConstInlineVisitor | Inline constant values |
| 27 | TypeInferenceVisitor | Infer types for SSA vars |
| 28 | DebugInfoApplyVisitor | Apply debug info (optional) |
| 29 | FixTypesVisitor | Resolve type conflicts |
| 30 | FinishTypeInference | Complete type inference |

#### Code Enhancement Phase
| # | Visitor | Description |
|---|---------|-------------|
| 31 | ProcessKotlinInternals | Handle Kotlin metadata (optional) |
| 32 | CodeRenameVisitor | Rename variables |
| 33 | InlineMethods | Inline marked methods (optional) |
| 34 | GenericTypesVisitor | Apply generic type info |
| 35 | ShadowFieldVisitor | Handle shadowed fields |
| 36 | DeboxingVisitor | Remove `Integer.valueOf()` boxing |
| 37 | AnonymousClassVisitor | Prepare anonymous classes |
| 38 | ModVisitor | Modify instructions |
| 39 | CodeShrinkVisitor | Remove redundant code (pass 1) |
| 40 | ReplaceNewArray | Optimize array creation |

#### Regions IR Phase
| # | Visitor | Description |
|---|---------|-------------|
| 41 | RegionMakerVisitor | Pack blocks into regions |
| 42 | IfRegionVisitor | Create if-else regions |
| 43 | SwitchOverStringVisitor | Restore switch-over-string (optional) |
| 44 | ReturnVisitor | Simplify return statements |
| 45 | CleanRegions | Remove empty regions |
| 46 | MethodThrowsVisitor | Extract thrown exceptions |
| 47 | CodeShrinkVisitor | Remove redundant code (pass 2) |
| 48 | MethodInvokeVisitor | Process overload/vararg |
| 49 | SimplifyVisitor | Simplify expressions |
| 50 | CheckRegions | Validate region structure |

#### Class Transformation Phase
| # | Visitor | Description |
|---|---------|-------------|
| 51 | EnumVisitor | Restore enum classes |
| 52 | FixSwitchOverEnum | Fix switch over enum |
| 53 | NonFinalResIdsVisitor | Fix non-final resource IDs |
| 54 | ExtractFieldInit | Move field initialization |
| 55 | FixAccessModifiers | Fix visibility modifiers |
| 56 | ClassModifier | Modify class attributes |
| 57 | LoopRegionVisitor | Transform loops (for-each) |
| 58 | SwitchBreakVisitor | Handle switch breaks |

#### Finalization Phase
| # | Visitor | Description |
|---|---------|-------------|
| 59 | MarkMethodsForInline | Mark for inlining (pass 2) |
| 60 | ProcessVariables | Process variable assignments |
| 61 | ApplyVariableNames | Apply variable names |
| 62 | PrepareForCodeGen | Final prep for codegen |

---

### SSA Transformation

**File**: `visitors/ssa/SSATransform.java`

#### Phi Placement Algorithm
```
for each register r:
    worklist = {blocks where r is assigned}
    while worklist not empty:
        B = pop(worklist)
        for each D in dominance_frontier(B):
            if phi not placed at D and r is live at D:
                place_phi(D, r)
                worklist.add(D)
```

#### Variable Renaming
- DFS traversal of dominator tree
- RenameState tracks variable versions per register
- Each SSAVar has exactly one assignment point
- Version counter increments during construction

---

### Type Inference

**File**: `visitors/typeinference/TypeInferenceVisitor.java`

#### Multi-Stage Pipeline

**Stage 1: Bound Collection**
- ASSIGN bounds: Types from instruction results
- USE bounds: Types required by instruction args
- PHI merging: Union bounds from all operands

**Stage 2: Type Search** (fallback, max 5000 vars)
1. Generate candidates from bounds + supertypes
2. Independent variable resolution (no dependencies)
3. Constraint building (MOVE, PHI constraints)
4. Exhaustive search (max 1M iterations)

#### Type Comparison Lattice
```
EQUAL → Same type
WIDER/NARROW → Subtyping
CONFLICT → Incompatible
UNKNOWN → Incomplete hierarchy
```

#### Listener-Based Updates
```java
registry.put(InsnType.CONST, this::sameFirstArgListener);
registry.put(InsnType.MOVE, this::moveListener);
registry.put(InsnType.PHI, this::allSameListener);
registry.put(InsnType.AGET, this::arrayGetListener);
registry.put(InsnType.INVOKE, this::invokeListener);
```

---

### Key Optimization Visitors

#### SimplifyVisitor
- Arithmetic: `c + (-1)` → `c - 1`
- Cast removal: Eliminate redundant casts
- String building: `StringBuilder.append()` chains → `STRING_CONCAT`
- IF conditions: Remove CMP instructions

#### ConstInlineVisitor
- Inline CONST, MOVE, CONST_STR, CONST_CLASS
- Replace literals with static final fields
- Null safety checks for NPE prevention

#### DeboxingVisitor
- `Integer.valueOf(1)` → literal `1`
- Handles Integer, Boolean, Byte, Short, Char, Long

#### CodeShrinkVisitor
- Variable inlining (single use)
- Unused assignment removal
- Cross-block inlining when safe

#### ModVisitor (470+ lines)
- Constant replacement with field refs
- Array optimization: NEW_ARRAY + FILL → FILLED_NEW_ARRAY
- Exception handling cleanup
- Primitive cast → ternary conversion

#### InlineMethods
- Inline synthetic getter/setter methods
- Register remapping from caller to callee
- Visibility fixing (field/method → PUBLIC)

---

### Optimization Flags

| Flag | Purpose |
|------|---------|
| `DONT_GENERATE` | Skip in output |
| `DONT_INLINE` | Prevent inlining |
| `DONT_INLINE_CONST` | Prevent const inlining |
| `WRAPPED` | Synthetic instruction |
| `FORCE_ASSIGN_INLINE` | Force inlining |
| `REQUEST_CODE_SHRINK` | Trigger shrinking |
| `METHOD_CANDIDATE_FOR_INLINE` | Eligible for inlining |

---

### Layered IR Representation

```
DEX Bytecode
    ↓ ProcessInstructionsVisitor
Instructions IR (InsnNode[])
    ↓ BlockSplitter, BlockProcessor
Blocks IR (BlockNode graph)
    ↓ SSATransform
SSA Form (SSAVar, PhiInsn)
    ↓ TypeInferenceVisitor
Typed SSA (ArgType on each var)
    ↓ RegionMakerVisitor
Regions IR (IfRegion, LoopRegion, etc.)
    ↓ CodeGen
Java Source Code
```

---

### Key Visitor Files

| File | Purpose |
|------|---------|
| `visitors/ssa/SSATransform.java` | SSA construction |
| `visitors/ssa/LiveVarAnalysis.java` | Liveness analysis |
| `visitors/typeinference/TypeInferenceVisitor.java` | Type inference |
| `visitors/typeinference/TypeSearch.java` | Fallback type search |
| `visitors/typeinference/TypeUpdate.java` | Type propagation |
| `visitors/SimplifyVisitor.java` | Expression simplification |
| `visitors/ConstInlineVisitor.java` | Constant inlining |
| `visitors/DeboxingVisitor.java` | Remove boxing |
| `visitors/shrink/CodeShrinkVisitor.java` | Dead code elimination |
| `visitors/ModVisitor.java` | Instruction modification |
| `visitors/InlineMethods.java` | Method inlining |
| `visitors/PrepareForCodeGen.java` | Final preparation |

---

## Summary

JADX achieves clean, readable Java output through:

1. **Smart filtering** - Omit implicit Java constructs
2. **Intelligent formatting** - Special values, proper escaping
3. **Careful naming** - Import management, inner class handling
4. **Performance engineering** - HashMap pooling, zero-allocation
5. **Pattern detection** - Ternary, for-each, lambda candidates
6. **Memory safety** - Capacity management prevents OOM

These techniques produce code rivaling hand-written Java while handling complex obfuscated APKs.

---

---

## Part 4: JADX vs Dexterity Codegen Comparison

This section provides a detailed architectural comparison between JADX's 10+ years of refined Java codegen and Dexterity's Rust implementation. Understanding these differences is critical for achieving full parity.

### Architecture Overview

#### JADX Core Classes (Java)

| Class | Lines | Purpose |
|-------|-------|---------|
| `InsnGen` | ~1200 | Instruction → Java expression/statement |
| `RegionGen extends InsnGen` | ~400 | Control flow regions (if, loop, switch, try) |
| `ConditionGen` | ~200 | Boolean condition generation |
| `ClassGen` | ~800 | Class structure, imports, inner classes |
| `MethodGen` | ~500 | Method signature, body delegation |
| `TypeGen` | ~300 | Type formatting, literals |
| `AnnotationGen` | ~200 | Annotation handling |
| `NameGen` | ~400 | Variable naming, conflict resolution |

#### Dexterity Core Modules (Rust)

| Module | Lines | Purpose |
|--------|-------|---------|
| `body_gen.rs` | ~5000 | Full pipeline + region traversal |
| `expr_gen.rs` | ~1400 | Expression generation + memory management |
| `stmt_gen.rs` | ~700 | Statement templates |
| `class_gen.rs` | ~1500 | Class structure |
| `method_gen.rs` | ~700 | Method signatures |
| `type_gen.rs` | ~400 | Type formatting |

---

### Key Design Pattern Differences

#### 1. Visitor Pattern vs Direct Pattern Matching

**JADX (Visitor Pattern):**
```java
// IContainer interface - regions call generate() on themselves
public interface IContainer {
    void generate(RegionGen regionGen, ICodeWriter code);
}

// RegionGen.makeRegion()
public void makeRegion(ICodeWriter code, IContainer cont) {
    declareVars(code, cont);
    cont.generate(this, code);  // Polymorphic dispatch
}
```

**Dexterity (Direct Pattern Matching):**
```rust
fn generate_region(region: &Region, ctx: &mut BodyGenContext, code: &mut W) {
    match region {
        Region::Sequence(contents) => { ... }
        Region::If { condition, then_region, else_region } => { ... }
        Region::Loop { kind, condition, body } => { ... }
        Region::Switch { value, cases, default } => { ... }
        Region::TryCatch { try_region, handlers, finally } => { ... }
        // ...
    }
}
```

#### 2. Inline Expression Handling

**JADX (InsnWrapArg wrapper class):**
```java
// Expressions are inlined by wrapping in InsnWrapArg
public class InsnWrapArg extends InsnArg {
    private final InsnNode wrapInsn;

    // When generating an arg that is InsnWrapArg, recursively generate inner insn
}

// In InsnGen.addArg():
if (arg.isInsnWrap()) {
    InsnNode wrapInsn = ((InsnWrapArg) arg).getWrapInsn();
    makeInsnBody(code, wrapInsn, flags);  // Recursive generation
}
```

**Dexterity (HashMap storage):**
```rust
// Store expression strings for single-use variables
pub struct BodyGenContext {
    // Variables used exactly once store their expression for later inlining
    inlined_exprs: HashMap<(u16, u32), String>,  // (reg, version) -> expr string
    use_counts: HashMap<(u16, u32), usize>,      // Track how many times each var is used
}

// Check if should inline (used exactly once)
pub fn should_inline(&self, reg: u16, version: u32) -> bool {
    self.use_counts.get(&(reg, version)).copied().unwrap_or(0) == 1
}
```

#### 3. Attribute System

**JADX (Rich AFlag/AType system):**
```java
// Flags are attached to any node
insn.contains(AFlag.DECLARE_VAR)     // Should emit type declaration
insn.contains(AFlag.DONT_GENERATE)   // Skip this instruction
insn.get(AType.LOOP_LABEL)           // Get loop label for break/continue
insn.get(AType.FIELD_REPLACE)        // Field substitution info

// Used throughout codegen for decisions
if (insn.contains(AFlag.COMMENT_OUT)) {
    code.add("// ");
}
```

**Dexterity (Simpler AFlag enum):**
```rust
pub enum AFlag {
    Synthetic,
    Bridge,
    Varargs,
    DontGenerate,
    // ... fewer flags, more logic in passes
}
```

#### 4. Code Generation Flags

**JADX (Flags enum for context):**
```java
protected enum Flags {
    BODY_ONLY,        // Just the expression body
    BODY_ONLY_NOWRAP, // Body without wrapping negative literals
    INLINE            // No semicolon, can be wrapped
}

// Passed through generation chain
makeInsn(insn, code, Flags.INLINE);  // For ternary branches, etc.
```

**Dexterity (Implicit context):**
```rust
// Context carried in BodyGenContext struct
// No explicit flag passing - decisions made based on context
```

---

### IfCondition System (JADX)

JADX uses a tree-based condition representation that's more powerful than Dexterity's:

```java
public final class IfCondition extends AttrNode {
    public enum Mode {
        COMPARE,   // Simple comparison: a == b, x < 5
        TERNARY,   // Nested ternary in condition: (a ? b : c)
        NOT,       // Negation: !condition
        AND,       // Conjunction: a && b && c
        OR         // Disjunction: a || b || c
    }

    private final Mode mode;
    private final List<IfCondition> args;  // Child conditions
    private final Compare compare;          // For COMPARE mode
}
```

**Key methods:**
```java
// Merge conditions
IfCondition.merge(Mode.AND, condA, condB)  // condA && condB

// Negate with De Morgan's laws
IfCondition.invert(cond)  // !cond, applies !(a && b) = !a || !b

// Simplification
IfCondition.simplify()    // Double negation, boolean normalization
```

**Dexterity equivalent (simpler):**
```rust
pub enum Condition {
    Simple { block: u32, negated: bool },
    And(Vec<Condition>),
    Or(Vec<Condition>),
    Not(Box<Condition>),
}
```

---

### TernaryInsn (JADX)

JADX has a dedicated IR type for ternary expressions:

```java
public final class TernaryInsn extends InsnNode {
    private IfCondition condition;
    // Args: [thenValue, elseValue]
    // condition ? arg(0) : arg(1)

    // Auto-invert if false/true pattern detected
    public TernaryInsn(IfCondition condition, RegisterArg result,
                       InsnArg th, InsnArg els) {
        if (th.isFalse() && els.isTrue()) {
            // Invert: (cond ? false : true) → (!cond)
            this.condition = IfCondition.invert(condition);
            addArg(els);  // Swap args
            addArg(th);
        } else {
            this.condition = condition;
            addArg(th);
            addArg(els);
        }
    }
}
```

**Dexterity approach:**
- Detects ternary patterns in `body_gen.rs` during code generation
- No dedicated IR type - analysis done at emit time

---

### Feature Parity Gap Analysis

#### ❌ Missing in Dexterity (Critical for Full Parity)

| Feature | JADX Location | Impact | Priority |
|---------|--------------|--------|----------|
| **Lambda expressions** | `InsnGen.makeInvokeLambda()` | Android 8+ apps use heavily | P1 |
| **Method references** | `InsnGen.makeRefLambda()` | `Foo::method`, `Foo::new` | P1 |
| **INVOKE_CUSTOM** | `InvokeCustomNode` | Required for lambdas | P1 |
| **TernaryInsn IR type** | `TernaryInsn.java` | Cleaner ternary output | P2 |

#### ⚠️ Missing (Important)

| Feature | JADX Location | Impact |
|---------|--------------|--------|
| **Fallback mode** | `fallbackOnlyInsn()` | Raw bytecode on failure |
| **Code comments** | `CodeGenUtils.addCodeComments()` | Warning annotations |
| **Source line tracking** | `code.startLineWithNum()` | Debug mapping |
| **Polymorphic invoke** | `insn.isPolymorphicCall()` | MethodHandle cases |
| **Android R.* handling** | `handleAppResField()` | Resource IDs |

---

### JADX InsnGen Key Methods Missing in Dexterity

```java
// Lambda generation (CRITICAL - blocks ~40% of modern Android apps)
private void makeInvokeLambda(ICodeWriter code, InvokeCustomNode customNode) {
    if (customNode.isUseRef()) {
        makeRefLambda(code, customNode);  // Foo::method
        return;
    }
    if (fallback || !customNode.isInlineInsn()) {
        makeSimpleLambda(code, customNode);  // (args) -> { body }
        return;
    }
    makeInlinedLambdaMethod(code, customNode, callMth);  // Full inline
}

// Method reference: Foo::new, obj::method
private void makeRefLambda(ICodeWriter code, InvokeCustomNode customNode) {
    if (callInsn instanceof ConstructorInsn) {
        useClass(code, callMth.getDeclClass());
        code.add("::new");
        return;
    }
    if (customNode.getHandleType() == MethodHandleType.INVOKE_STATIC) {
        useClass(code, callMth.getDeclClass());
    } else {
        addArg(code, customNode.getArg(0));  // Instance receiver
    }
    code.add("::").add(callMth.getAlias());
}

// Anonymous class inlining
private void inlineAnonymousConstructor(ICodeWriter code, ClassNode cls,
                                        ConstructorInsn insn) {
    cls.ensureProcessed();
    // Recursion detection
    if (this.mth.getParentClass() == cls) {
        throw new CodegenException("Anonymous inner class recursion detected");
    }
    // Generate: new BaseType(args) { body }
    code.add("new ");
    useClass(code, parent);
    generateMethodArguments(code, insn, 0, callMth);
    code.add(' ');
    ClassGen classGen = new ClassGen(cls, mgen.getClassGen().getParentGen());
    classGen.addClassBody(code, true);  // Inline the class body
}

// Super call with custom class handling (for inlined synthetic calls)
private void callSuper(ICodeWriter code, MethodInfo callMth) {
    ClassInfo superCallCls = getClassForSuperCall(callMth);
    if (superCallCls == null) {
        code.add("super/*").add(callMth.getDeclClass().getFullName()).add("*/");
        return;
    }
    if (!superCallCls.equals(curClass)) {
        useClass(code, superCallCls);
        code.add(".super");  // Custom class super call
    } else {
        code.add("super");
    }
}

// Varargs expansion from filled array
private boolean processVarArg(ICodeWriter code, BaseInvokeNode invokeInsn,
                              InsnArg lastArg) {
    if (!invokeInsn.contains(AFlag.VARARG_CALL)) return false;
    if (!lastArg.getType().isArray() || !lastArg.isInsnWrap()) return false;

    InsnNode insn = ((InsnWrapArg) lastArg).getWrapInsn();
    if (insn.getType() != InsnType.FILLED_NEW_ARRAY) return false;

    // Expand: foo(new String[]{"a", "b"}) → foo("a", "b")
    for (int i = 0; i < insn.getArgsCount(); i++) {
        addArg(code, insn.getArg(i), false);
        if (i < count - 1) code.add(", ");
    }
    return true;
}
```

---

### Boolean Simplification (ConditionGen)

JADX's ConditionGen has sophisticated boolean simplification:

```java
private void addCompare(ICodeWriter code, CondStack stack, Compare compare) {
    IfOp op = compare.getOp();
    InsnArg firstArg = compare.getA();
    InsnArg secondArg = compare.getB();

    // Boolean type optimization
    if (firstArg.getType().equals(ArgType.BOOLEAN)
            && secondArg.isLiteral()
            && secondArg.getType().equals(ArgType.BOOLEAN)) {
        LiteralArg lit = (LiteralArg) secondArg;
        if (lit.getLiteral() == 0) {
            op = op.invert();  // x == 0 → x != true
        }
        if (op == IfOp.EQ) {
            // == true → just emit the expression
            addArg(code, firstArg, false);
            return;
        } else if (op == IfOp.NE) {
            // != true → !expression
            code.add('!');
            wrap(code, firstArg);
            return;
        }
    }
    // Fall through to normal comparison
    addArg(code, firstArg, isArgWrapNeeded(firstArg));
    code.add(' ').add(op.getSymbol()).add(' ');
    addArg(code, secondArg, isArgWrapNeeded(secondArg));
}
```

---

### Recommended Parity Roadmap

#### Phase 1: Lambda Support (Highest Impact)
1. Add `InvokeCustom` instruction type to `dexterity-ir`
2. Parse `invoke-custom` from DEX in `dexterity-dex`
3. Implement lambda detection pass in `dexterity-passes`
4. Add `makeInvokeLambda` equivalent in `body_gen.rs`
5. Support method references (`::` syntax)

**Files to modify:**
- `crates/dexterity-ir/src/instructions.rs` - Add InvokeCustom
- `crates/dexterity-dex/src/reader.rs` - Parse invoke-custom
- `crates/dexterity-passes/src/lambda_detection.rs` - New pass
- `crates/dexterity-codegen/src/body_gen.rs` - Lambda codegen

#### Phase 2: Code Quality
1. Add `TernaryInsn` IR type for cleaner ternary handling
2. Implement fallback mode with raw bytecode
3. Add code comment system (WARN, INFO levels)

#### Phase 3: Edge Cases
1. Polymorphic invoke handling
2. Android resource field handling (`R.*`)
3. JSR/RET for old Java bytecode

---

### InsnGen Instruction Switch Coverage

**JADX InsnGen.makeInsnBody() handles:**
```
CONST_STR, CONST_CLASS, CONST, MOVE, CHECK_CAST, CAST, ARITH, NEG, NOT,
RETURN, BREAK, CONTINUE, THROW, CMP_L, CMP_G, INSTANCE_OF, CONSTRUCTOR,
INVOKE, NEW_ARRAY, ARRAY_LENGTH, FILLED_NEW_ARRAY, FILL_ARRAY, AGET,
APUT, IGET, IPUT, SGET, SPUT, STR_CONCAT, MONITOR_ENTER, MONITOR_EXIT,
TERNARY, ONE_ARG, IF, GOTO, MOVE_EXCEPTION, SWITCH, NEW_INSTANCE,
PHI, MOVE_RESULT, FILL_ARRAY_DATA, SWITCH_DATA, MOVE_MULTI, JAVA_JSR, JAVA_RET
```

**Dexterity expr_gen.rs gen_insn() handles:**
```
Const, ConstString, ConstClass, Move, NewInstance, NewArray, FilledNewArray,
ArrayLength, ArrayGet, InstanceOf, InstanceGet, StaticGet, Invoke, Unary,
Binary, Cast, Compare, CheckCast
```

**Key differences:**
- JADX has `CONSTRUCTOR` as separate type (Dexterity uses `Invoke`)
- JADX has `TERNARY` built into IR (Dexterity detects at codegen)
- JADX has `STR_CONCAT` (StringBuilder optimization result)
- JADX separates `ARITH` from `Binary`

---

**Last Updated: 2025-12-16**
**Related Documentation:**
- `ALGORITHM_REFERENCES.md` - Algorithm explanations for Dexterity implementation
- `CODE_NAVIGATION.md` - Source file locations
- `LLM_AGENT_GUIDE.md` - Development workflow
