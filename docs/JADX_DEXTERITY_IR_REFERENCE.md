# JADX IR vs Dexterity IR Reference

This document provides a comprehensive comparison of JADX's Java-based IR (Intermediate Representation) and Dexterity's Rust-based IR. Understanding both systems is essential for maintaining feature parity and debugging decompilation quality issues.

---

## Architecture Overview

```
JADX (Java):
  DEX → InsnDecoder → InsnNode[] → BlockNode → Region → CodeGen → Java

Dexterity (Rust):
  DEX → dexterity-dex → InsnNode → BasicBlock → Region → CodeGen → Java
```

Both decompilers follow the same high-level pipeline, but differ in implementation details.

---

## IR Parity Summary (0-100%)

**Overall IR Parity: ~85%** (Updated 2025-12-17)

| Component | Parity | Status | Notes |
|-----------|--------|--------|-------|
| Type System | 90% | ✅ | Unknown variants (NARROW, WIDE, INTEGRAL), type narrowing |
| Instructions | 85% | ✅ | All JADX types: MOVE_MULTI, STR_CONCAT, REGION_ARG, JSR/RET |
| Instruction Args | 85% | ✅ | InsnWrapArg, NamedArg, This reference |
| Class/Method/Field | 68% | 🔶 | Dependency tracking, LoadStage, innerClasses detail |
| Regions | 72% | 🔶 | ForEachLoop/ForLoop distinction, IContainer hierarchy |
| Attribute System | 80% | ✅ | 55+ JADX flags (was 13), organized by category |
| Class Hierarchy | 85% | ✅ | Minor: integrated type comparison |
| SSA/Registers | 85% | ✅ | Full SSAVar, use-def chains, CodeVar, TypeBound |
| Exception Handling | 70% | 🔶 | Block-level tracking, multi-catch type lists |
| Debug Info | 75% | 🔶 | End-scope tracking, complex debug attributes |
| Annotations | 78% | ✅ | Minor: nested element name handling |
| Lazy Loading | 90% | ✅ | Excellent match with ProcessState pattern |

### Recent Improvements (2025-12-17)
- **AFlag System** (55%→80%): Added 55+ JADX-compatible attribute flags
- **SSA Infrastructure** (60%→85%): Full SSAVar, TypeInfo, CodeVar, TypeBound
- **Instruction Args** (65%→85%): InsnWrapArg, NamedArg, This variants
- **Instructions** (70%→85%): MoveMulti, StrConcat, RegionArg, Constructor, JavaJsr/Ret
- **Type System** (75%→90%): UnknownNarrow/Wide/Object/Array/Integral variants

### Key Advantages
- **Memory Efficiency** - Shared instruction pool reduces memory 3-4x
- **Rust Type Safety** - Compile-time guarantees, no null pointer exceptions
- **Explicit Condition Logic** - De Morgan's laws clearly separated
- **Comprehensive SSA** - Full use-def chains with type bounds for inference

---

## Module Comparison

| Component | JADX (Java) | Dexterity (Rust) |
|-----------|-------------|------------------|
| Type System | `jadx.core.dex.instructions.args.ArgType` | `dexterity_ir::types::ArgType` |
| Instructions | `jadx.core.dex.nodes.InsnNode` | `dexterity_ir::instructions::InsnNode` |
| Classes | `jadx.core.dex.nodes.ClassNode` | `dexterity_ir::info::ClassData` |
| Methods | `jadx.core.dex.nodes.MethodNode` | `dexterity_ir::info::MethodData` |
| Fields | `jadx.core.dex.nodes.FieldNode` | `dexterity_ir::info::FieldData` |
| Blocks | `jadx.core.dex.nodes.BlockNode` | `dexterity_ir::nodes::BlockNode` |
| Regions | `jadx.core.dex.regions.*` | `dexterity_ir::regions::Region` |
| Hierarchy | N/A (uses RootNode) | `dexterity_ir::class_hierarchy::ClassHierarchy` |
| Attributes | `jadx.core.dex.attributes.*` | `dexterity_ir::attributes::AttributeStorage` |

---

## Type System

### JADX ArgType (Java)

```java
// Abstract class with multiple implementations
public abstract class ArgType {
    // Primitives
    public static final ArgType INT = primitive(PrimitiveType.INT);
    public static final ArgType BOOLEAN = primitive(PrimitiveType.BOOLEAN);
    // ...

    // Objects
    public static final ArgType OBJECT = objectNoCache("java.lang.Object");
    public static final ArgType STRING = objectNoCache("java.lang.String");

    // Special unknown types for type inference
    public static final ArgType UNKNOWN = unknown(PrimitiveType.values());
    public static final ArgType NARROW = unknown(INT, FLOAT, BOOLEAN, ...);
    public static final ArgType WIDE = unknown(LONG, DOUBLE);

    // Factory methods
    public static ArgType object(String obj);
    public static ArgType array(ArgType vtype);
    public static ArgType generic(ArgType obj, List<ArgType> generics);
    public static ArgType wildcard(ArgType obj, WildcardBound bound);
    public static ArgType genericType(String type);  // Type variable (T, E)
}
```

**Key Classes:**
- `PrimitiveArg` - Primitives (int, boolean, etc.)
- `ObjectType` - Object references (`Ljava/lang/String;`)
- `ArrayArg` - Arrays (`[I`, `[Ljava/lang/String;`)
- `GenericObject` - Parameterized types (`List<String>`)
- `GenericType` - Type variables (`T`, `E extends Number`)
- `WildcardType` - Wildcards (`?`, `? extends T`, `? super T`)
- `UnknownArg` - Unknown types for inference (contains possible types)

### Dexterity ArgType (Rust)

```rust
#[derive(Debug, Clone, PartialEq, Eq, Hash)]
pub enum ArgType {
    // Primitives
    Void,
    Boolean,
    Byte,
    Char,
    Short,
    Int,
    Long,
    Float,
    Double,

    // Object type (class reference)
    Object(String),

    // Array type
    Array(Box<ArgType>),

    // Generic type with parameters (e.g., List<String>)
    Generic {
        base: String,
        params: Vec<ArgType>,
    },

    // Wildcard type (? extends T, ? super T)
    Wildcard {
        bound: WildcardBound,
        inner: Option<Box<ArgType>>,
    },

    // Type variable (e.g., T, E, K, V)
    TypeVariable(String),

    // Unknown type (for type inference)
    Unknown,
}

#[derive(Debug, Clone, Copy, PartialEq, Eq, Hash)]
pub enum WildcardBound {
    Unbounded,  // ?
    Extends,    // ? extends T
    Super,      // ? super T
}
```

### Type Comparison

| Feature | JADX | Dexterity |
|---------|------|-----------|
| Primitives | Static constants | Enum variants |
| Objects | `ObjectType` class | `Object(String)` |
| Arrays | `ArrayArg` class | `Array(Box<ArgType>)` |
| Generics | `GenericObject` class | `Generic { base, params }` |
| Type Variables | `GenericType` class | `TypeVariable(String)` |
| Wildcards | `WildcardType` class | `Wildcard { bound, inner }` |
| Unknown | `UnknownArg` with possible types | Simple `Unknown` variant |

**Key Difference:** JADX's `UnknownArg` stores a set of *possible* primitive types (e.g., `NARROW` = int/float/boolean/...), enabling constraint-based narrowing. Dexterity uses a single `Unknown` variant and relies on the type inference pass to resolve types.

---

## Type Comparison Results

### JADX TypeCompareEnum

```java
public enum TypeCompareEnum {
    EQUAL,              // Types are identical
    NARROW,             // First is more specific (subtype)
    WIDER,              // First is more general (supertype)
    NARROW_BY_GENERIC,  // Same base, first has generics
    WIDER_BY_GENERIC,   // Same base, second has generics
    CONFLICT_BY_GENERIC,// Same base, incompatible generics
    CONFLICT,           // Types are incompatible
    UNKNOWN             // Cannot determine relationship
}
```

### Dexterity TypeCompare

```rust
pub enum TypeCompare {
    Equal,
    Narrow,
    Wider,
    NarrowByGeneric,
    WiderByGeneric,
    ConflictByGeneric,
    Conflict,
    Unknown,
}
```

**Mapping:** Direct 1:1 correspondence. Both use the same comparison semantics.

---

## Instruction Representation

### JADX InsnNode

```java
public class InsnNode extends LineAttrNode {
    protected final InsnType insnType;
    private RegisterArg result;
    private final List<InsnArg> arguments;
    protected int offset;

    // Key methods
    public InsnType getType();
    public RegisterArg getResult();
    public List<InsnArg> getArgList();
    public int getOffset();

    // SSA integration
    public void setResult(RegisterArg res);
    public void rebindArgs();  // Fix SSA references after modifications
}
```

**Instruction Arguments:**
```java
public abstract class InsnArg {
    // Implementations:
    // - RegisterArg: register reference with SSA info
    // - LiteralArg: constant value
    // - InsnWrapArg: inlined instruction (expression tree)
    // - FieldArg: field reference
    // - MethodArg: method reference
}

public class RegisterArg extends InsnArg {
    private int regNum;
    private SSAVar sVar;      // SSA variable binding
    private ArgType initType;
    private ArgType type;
    private String name;
}
```

### Dexterity InsnNode

```rust
pub struct InsnNode {
    pub insn_type: InsnType,
    pub result_type: Option<ArgType>,
    pub source_line: Option<u32>,
    pub offset: u32,
    pub flags: u64,  // Attribute flags
}

pub enum InsnType {
    Nop,
    Const { dest: RegisterArg, value: LiteralArg },
    ConstString { dest: RegisterArg, string_idx: u32 },
    Move { dest: RegisterArg, src: InsnArg },
    Return { value: Option<InsnArg> },
    Invoke { kind: InvokeKind, method_idx: u32, args: Vec<InsnArg> },
    Binary { dest: RegisterArg, op: BinaryOp, left: InsnArg, right: InsnArg },
    If { condition: IfCondition, left: InsnArg, right: Option<InsnArg>, target: u32 },
    Ternary { dest: RegisterArg, condition: IfCondition, left: InsnArg, right: Option<InsnArg>, then_value: InsnArg, else_value: InsnArg },
    Phi { dest: RegisterArg, sources: Vec<(u32, InsnArg)> },
    // ... 40+ instruction types
}

pub enum InsnArg {
    Register(RegisterArg),
    Literal(LiteralArg),
    Type(u32),
    Field(u32),
    Method(u32),
    String(u32),
}

pub struct RegisterArg {
    pub reg_num: u16,
    pub ssa_version: u32,
}
```

### Instruction Comparison

| Aspect | JADX | Dexterity |
|--------|------|-----------|
| Structure | OOP class hierarchy | Rust enum with variants |
| Arguments | `List<InsnArg>` | Embedded in each `InsnType` variant |
| SSA | `RegisterArg.sVar` field | `RegisterArg.ssa_version` field |
| Attributes | Inheritance from `LineAttrNode` | `flags: u64` bitfield |
| Inlining | `InsnWrapArg` wraps instructions | Not supported (separate pass) |

**Key Difference:** JADX uses object-oriented inheritance with a flexible argument list. Dexterity uses a sum type (enum) with strongly-typed arguments per instruction type. Dexterity's approach is more explicit and catches type errors at compile time.

---

## Class, Method, and Field Nodes

### JADX ClassNode

```java
public class ClassNode extends NotificationAttrNode implements ILoadable {
    private final RootNode root;
    private final ClassInfo clsInfo;
    private AccessInfo accessFlags;
    private ArgType superClass;
    private List<ArgType> interfaces;
    private List<ArgType> generics;  // Type parameters <T, E>

    private List<MethodNode> methods;
    private List<FieldNode> fields;
    private List<ClassNode> innerClasses;

    private volatile ProcessState state;  // Lazy loading state

    // Lazy loading
    public void load();
    public void unload();
}
```

### Dexterity ClassData

```rust
pub struct ClassData {
    pub class_type: String,           // e.g., "Lcom/example/Foo;"
    pub alias: Option<String>,        // Deobfuscated name
    pub access_flags: u32,
    pub superclass: Option<String>,
    pub superclass_type: Option<ArgType>,  // With generics
    pub interfaces: Vec<ArgType>,     // With generics
    pub type_parameters: Vec<TypeParameter>,  // <T, E extends Number>

    pub methods: Vec<MethodData>,
    pub static_fields: Vec<FieldData>,
    pub instance_fields: Vec<FieldData>,
    pub annotations: Vec<Annotation>,

    pub state: ProcessState,
    pub all_instructions: Vec<InsnNode>,  // Shared instruction pool
    pub kotlin_metadata: Option<KotlinMetadata>,
}

pub struct TypeParameter {
    pub name: String,           // "T", "E"
    pub bounds: Vec<ArgType>,   // extends constraints
}
```

### JADX MethodNode

```java
public class MethodNode extends NotificationAttrNode implements ILoadable {
    private final MethodInfo mthInfo;
    private final ClassNode parentClass;
    private AccessInfo accFlags;
    private final ICodeReader codeReader;  // Lazy bytecode access

    private ArgType retType;
    private List<ArgType> argTypes;
    private List<ArgType> typeParameters;

    // Decompilation data (reset on unload)
    private RegisterArg thisArg;
    private List<RegisterArg> argsList;
    private InsnNode[] instructions;
    private List<BlockNode> blocks;
    private List<SSAVar> sVars;
    private List<ExceptionHandler> exceptionHandlers;
    private List<LoopInfo> loops;
    private Region region;  // High-level control flow

    // Lazy loading
    public void load() throws DecodeException;
    public void unload();
    public void unloadInsnArr();  // Free instructions but keep blocks
}
```

### Dexterity MethodData

```rust
pub struct MethodData {
    pub name: String,
    pub alias: Option<String>,
    pub access_flags: u32,
    pub return_type: ArgType,
    pub arg_types: Vec<ArgType>,
    pub arg_names: Vec<Option<String>>,  // From debug info
    pub type_parameters: Vec<TypeParameter>,

    pub regs_count: u16,
    pub ins_count: u16,
    pub outs_count: u16,

    pub state: ProcessState,
    pub bytecode_ref: Option<BytecodeRef>,  // For lazy loading
    pub insn_indices: Vec<u32>,  // Indices into ClassData.all_instructions
    pub instructions: Option<Vec<InsnNode>>,  // Legacy field

    pub try_blocks: Vec<TryBlock>,
    pub debug_info: Option<DebugInfo>,
    pub annotations: Vec<Annotation>,
    pub inline_attr: Option<MethodInlineAttr>,
}

pub enum ProcessState {
    NotLoaded,
    Loaded,
    ProcessStarted,
    ProcessComplete,
    GeneratedAndUnloaded,
}
```

### Lazy Loading Comparison

| Feature | JADX | Dexterity |
|---------|------|-----------|
| Bytecode reference | `ICodeReader codeReader` | `BytecodeRef` struct |
| State tracking | `ProcessState` enum | `ProcessState` enum |
| Instruction unload | `unloadInsnArr()` | `unload_instruction_array()` |
| Full unload | `unload()` | `unload()` |
| Shared pool | No | `ClassData.all_instructions` |

**Key Difference:** Dexterity uses a shared instruction pool (`all_instructions`) with index-based references to eliminate memory cloning during block splitting. This reduces peak memory from 7-12 GB to 2-3 GB for large methods.

---

## Region (High-Level Control Flow)

### JADX Regions

```java
// Base interface
public interface IRegion extends IContainer {
    List<IContainer> getSubBlocks();
    IRegion getParent();
}

// Implementations
public class Region extends AbstractRegion {
    private final List<IContainer> blocks;
}

public class LoopRegion extends AbstractRegion implements IBranchRegion {
    private LoopType loopType;
    private IfCondition condition;
    private IContainer body;
}

public class IfRegion extends AbstractRegion implements IConditionRegion {
    private IfCondition condition;
    private IContainer thenRegion;
    private IContainer elseRegion;
}

public class SwitchRegion extends AbstractRegion {
    private InsnNode insn;
    private List<CaseInfo> cases;
    private IContainer defaultCase;
}

public class TryCatchRegion extends AbstractRegion {
    private IContainer tryRegion;
    private Map<ExceptionHandler, IContainer> catchRegions;
    private IContainer finallyRegion;
}

public class SynchronizedRegion extends AbstractRegion {
    private InsnArg lockArg;
    private Region region;
}
```

### Dexterity Regions

```rust
pub enum Region {
    Sequence(Vec<RegionContent>),

    If {
        condition: Condition,
        then_region: Box<Region>,
        else_region: Option<Box<Region>>,
    },

    Loop {
        kind: LoopKind,
        condition: Option<Condition>,
        body: Box<Region>,
    },

    Switch {
        header_block: u32,
        cases: Vec<SwitchCase>,
        default: Option<Box<Region>>,
    },

    TryCatch {
        try_region: Box<Region>,
        handlers: Vec<CatchHandler>,
        finally: Option<Box<Region>>,
    },

    Synchronized {
        enter_block: u32,
        body: Box<Region>,
    },

    Break { label: Option<String> },
    Continue { label: Option<String> },
}

pub enum RegionContent {
    Block(u32),           // Block ID
    Region(Box<Region>),  // Nested region
}

pub enum LoopKind {
    While,
    DoWhile,
    For,
    ForEach,
    Endless,
}
```

### Condition Representation

**JADX:** Uses `IfCondition` class with static factory methods and composition.

**Dexterity:**
```rust
pub enum Condition {
    Simple {
        block: u32,
        op: IfCondition,
        negated: bool,
    },
    And(Box<Condition>, Box<Condition>),
    Or(Box<Condition>, Box<Condition>),
    Not(Box<Condition>),
    Ternary {
        condition: Box<Condition>,
        if_true: Box<Condition>,
        if_false: Box<Condition>,
    },
    Unknown,
}
```

Both support compound conditions (&&, ||) and simplification via De Morgan's laws.

---

## Class Hierarchy

### JADX

JADX uses `RootNode` as a central registry for all classes and provides hierarchy queries through `TypeUtils`:

```java
public class RootNode {
    private List<ClassNode> classes;
    private TypeUtils typeUtils;

    public ClassNode resolveClass(ClassInfo clsInfo);
}

public class TypeUtils {
    public void visitSuperTypes(ArgType type, BiConsumer<ArgType, ArgType> consumer);
    public boolean isAssignable(ArgType from, ArgType to);
}
```

### Dexterity

Dexterity uses an explicit `ClassHierarchy` graph:

```rust
pub struct ClassHierarchy {
    superclass_map: HashMap<String, String>,
    interfaces_map: HashMap<String, Vec<String>>,
    all_classes: HashSet<String>,
}

impl ClassHierarchy {
    pub fn add_class(&mut self, name: String, superclass: Option<String>, interfaces: Vec<String>);
    pub fn is_subtype_of(&self, subtype: &str, supertype: &str) -> bool;
    pub fn least_common_ancestor(&self, type1: &str, type2: &str) -> String;
    pub fn common_supertype(&self, types: &[&str]) -> String;  // For PHI nodes
}
```

**Key Difference:** Dexterity builds an explicit graph structure for hierarchy queries, while JADX traverses class nodes dynamically. Dexterity's approach is more efficient for repeated LCA queries during type inference.

---

## Attribute System

### JADX Attributes

```java
// Flag-based attributes
public enum AFlag {
    SYNTHETIC, DONT_GENERATE, DONT_INLINE, SKIP_FIRST_ARG,
    THIS, LOOP_START, LOOP_END, FINALLY_INSNS, ...
}

// Typed attributes
public enum AType<T> {
    LOOP(LoopInfo.class),
    EXC_HANDLER(ExcHandlerAttr.class),
    METHOD_OVERRIDE(MethodOverrideAttr.class),
    ...
}

// Usage
node.add(AFlag.SYNTHETIC);
node.contains(AFlag.SYNTHETIC);
node.get(AType.LOOP);
```

### Dexterity Attributes

```rust
pub struct AttributeStorage {
    flags: u64,
    attrs: HashMap<TypeId, Box<dyn Any + Send + Sync>>,
}

#[repr(u8)]
pub enum AFlag {
    Synthetic = 0,
    DontGenerate = 1,
    DontInline = 2,
    SkipFirstArg = 3,
    ThisArg = 5,
    LoopStart = 8,
    LoopEnd = 9,
    FinallyInsns = 10,
    DontWrap = 11,
    TmpEdge = 12,
}

// Usage
storage.add_flag(AFlag::Synthetic);
storage.has_flag(AFlag::Synthetic);
```

**Key Difference:** JADX uses a rich typed attribute system (`AType<T>`) with generics. Dexterity uses a simpler bitfield for flags with a generic `HashMap` for complex attributes.

---

## Exception Handling

### JADX

```java
public class TryBlock {
    private int startAddress;
    private int endAddress;
    private List<ExceptionHandler> handlers;
}

public class ExceptionHandler extends LineAttrNode {
    private ArgType catchType;  // null for catch-all
    private int handlerBlock;
    private BlockNode handleBlock;
    // Rich integration with BlockNode and SSA
}
```

### Dexterity

```rust
pub struct TryBlock {
    pub start_addr: u32,
    pub end_addr: u32,
    pub handlers: Vec<ExceptionHandler>,
}

pub struct ExceptionHandler {
    pub exception_type: Option<String>,  // None for catch-all
    pub handler_addr: u32,
}

// In regions:
pub struct CatchHandler {
    pub exception_types: Vec<String>,  // Multi-catch support
    pub catch_all: bool,
    pub region: Box<Region>,
}
```

---

## Debug Information

### JADX

```java
public interface IDebugInfo {
    List<? extends ILocalVar> getLocalVars();
    int[] getSourceLineMapping();
}
```

### Dexterity

```rust
pub struct DebugInfo {
    pub line_numbers: Vec<(u32, u32)>,  // (address, line)
    pub local_vars: Vec<LocalVar>,
}

pub struct LocalVar {
    pub name: String,
    pub type_desc: String,
    pub reg: u16,
    pub start_addr: u32,
    pub end_addr: u32,
}
```

---

## Annotations

### JADX

Uses the plugin system's `IAnnotation` interface with various attribute types.

### Dexterity

```rust
pub struct Annotation {
    pub annotation_type: String,
    pub visibility: AnnotationVisibility,
    pub elements: Vec<AnnotationElement>,
}

pub enum AnnotationVisibility {
    Build,    // Compile-time only
    Runtime,  // Visible via reflection
    System,   // Internal
}

pub enum AnnotationValue {
    Byte(i8),
    Short(i16),
    Int(i32),
    Long(i64),
    Float(f32),
    Double(f64),
    String(String),
    Type(String),
    Enum(String, String),  // (class, field)
    Annotation(Box<Annotation>),
    Array(Vec<AnnotationValue>),
    Boolean(bool),
    Null,
}
```

---

## Memory Management Comparison

| Aspect | JADX | Dexterity |
|--------|------|-----------|
| Instruction storage | Per-method `InsnNode[]` | Shared pool + indices |
| Block splitting | Copies instructions to blocks | Index references |
| Lazy loading | `ICodeReader` interface | `BytecodeRef` struct |
| Unloading | `unload()` clears arrays | `unload()` + `shrink_to_fit()` |
| Peak memory | Higher (cloning) | Lower (3-4x reduction) |

---

## Migration Guide

When porting JADX code to Dexterity:

1. **Types:** Replace `ArgType.object("...")` with `ArgType::Object("...".into())`
2. **Instructions:** Match JADX `InsnType` enum to Dexterity `InsnType` variants
3. **Attributes:** Convert `AFlag` usages to corresponding Dexterity flags
4. **Hierarchy:** Use explicit `ClassHierarchy::is_subtype_of()` instead of traversing nodes
5. **Regions:** Map JADX region classes to Dexterity `Region` enum variants
6. **SSA:** Convert `SSAVar` handling to `RegisterArg.ssa_version`

---

## File Locations

### JADX (Java)

```
jadx-fast/jadx-core/src/main/java/jadx/core/dex/
├── nodes/
│   ├── ClassNode.java
│   ├── MethodNode.java
│   ├── FieldNode.java
│   ├── InsnNode.java
│   └── BlockNode.java
├── instructions/
│   ├── args/ArgType.java
│   ├── args/InsnArg.java
│   └── InsnType.java
└── regions/
    ├── Region.java
    ├── LoopRegion.java
    ├── IfRegion.java
    └── SwitchRegion.java
```

### Dexterity (Rust)

```
crates/dexterity-ir/src/
├── lib.rs           # Module exports
├── types.rs         # ArgType, TypeCompare
├── instructions.rs  # InsnNode, InsnType, InsnArg
├── nodes.rs         # ClassNode, MethodNode, BlockNode (arena IDs)
├── info.rs          # ClassData, MethodData, FieldData
├── regions.rs       # Region enum, Condition
├── class_hierarchy.rs # ClassHierarchy, LCA
├── attributes.rs    # AttributeStorage, AFlag
├── arena.rs         # Arena allocation
└── kotlin_metadata.rs # Kotlin support
```

---

**Last Updated:** December 2025
