# JADX Type Inference System Reference

This document provides implementation-level detail of JADX's type inference system for building a 1:1 clone in Rust.

## Package Structure

**Location:** `jadx-core/src/main/java/jadx/core/dex/visitors/typeinference/`

### Complete File Inventory (26 files)

**Core Classes:**
- `TypeInferenceVisitor.java` (366 lines) - Main visitor, entry point
- `TypeUpdate.java` (681 lines) - Type propagation and constraint validation engine
- `TypeCompare.java` (394 lines) - Type comparison logic (narrow, wider, conflict detection)
- `TypeSearch.java` (403 lines) - Multi-variable constraint solving algorithm

**Type Bounds (Constraint Storage):**
- `TypeInfo.java` (33 lines) - Container holding current type + set of ITypeBound
- `ITypeBound.java` (20 lines) - Base interface for bounds
- `ITypeBoundDynamic.java` (17 lines) - Dynamic bounds that depend on other variables
- `TypeBoundConst.java` (60 lines) - Static constant bounds
- `TypeBoundInvokeAssign.java` (106 lines) - Generic return type bounds from invoke
- `TypeBoundInvokeUse.java` (79 lines) - Generic argument type bounds from invoke
- `TypeBoundCheckCastAssign.java` (58 lines) - Check-cast bounds
- `TypeBoundFieldGetAssign.java` (84 lines) - Generic field access bounds

**Type Constraints (for TypeSearch):**
- `ITypeConstraint.java` (13 lines) - Constraint interface
- `AbstractTypeConstraint.java` (50 lines) - Base constraint implementation
- `TypeSearchState.java` (63 lines) - Search state management
- `TypeSearchVarInfo.java` (100 lines) - Per-variable search info

**Supporting Classes:**
- `BoundEnum.java` (7 lines) - ASSIGN vs USE bound types
- `TypeCompareEnum.java` (60 lines) - Comparison results
- `TypeUpdateResult.java` (8 lines) - REJECT, SAME, CHANGED
- `TypeUpdateFlags.java` (62 lines) - Type update behavior flags
- `TypeUpdateInfo.java` (95 lines) - Transaction-like update tracking
- `TypeUpdateEntry.java` (41 lines) - Individual type update
- `TypeUpdateRegistry.java` - Registry for type listeners
- `ITypeListener.java` (21 lines) - Listener interface for instruction-specific logic

**Post-Processing:**
- `FixTypesVisitor.java` (600+ lines) - Fallback resolver for unresolved types
- `FinishTypeInference.java` (39 lines) - Final validation pass

---

## Entry Point & Control Flow

### TypeInferenceVisitor Main Class

```
visit(MethodNode mth)
  |
  +-- assignImmutableTypes(mth)
  |   +-- Mark variables with immutable type flags
  |
  +-- initTypeBounds(mth)
  |   +-- attachBounds(SSAVar) - Collect bounds from assignments & uses
  |   |   +-- addAssignBound() - Bounds from variable assignment
  |   |   |   +-- NEW_INSTANCE -> TypeBoundConst(ASSIGN, classType)
  |   |   |   +-- CONSTRUCTOR -> TypeBoundConst(ASSIGN, classType)
  |   |   |   +-- CONST -> TypeBoundConst(ASSIGN, literalType)
  |   |   |   +-- MOVE_EXCEPTION -> TypeBoundConst(ASSIGN, catchType)
  |   |   |   +-- INVOKE -> TypeBoundInvokeAssign (if generic return)
  |   |   |   +-- IGET -> TypeBoundFieldGetAssign (if generic field)
  |   |   |   +-- CHECK_CAST -> TypeBoundCheckCastAssign
  |   |   |
  |   |   +-- For each use: makeUseBound(RegisterArg)
  |   |       +-- makeInvokeUseBound() -> TypeBoundInvokeUse (if generic args)
  |   |       +-- Else -> TypeBoundConst(USE, initType)
  |   |
  |   +-- mergePhiBounds(SSAVar) - Phi instruction merging
  |       +-- Merge bounds from all phi sources
  |
  +-- runTypePropagation(mth)
      +-- setImmutableType() - Apply immutable types first
      +-- setBestType() - Calculate & apply best type from bounds
          +-- selectBestTypeFromBounds() - Use comparator to find max
```

---

## Constraint-Based Type Inference Algorithm

### Two-Phase Approach

#### Phase 1: Fast Type Propagation (TypeInferenceVisitor + TypeUpdate)

**Bound Accumulation:**
- Each SSAVar maintains a `Set<ITypeBound>` in its `TypeInfo`
- Bounds are collected from:
  - **ASSIGN bounds**: Type information from assignment sources
  - **USE bounds**: Type information from usage contexts

**Best Type Selection:**
```
For each SSAVar:
  candidateType = max(bounds.stream().map(ITypeBound::getType))
  where max() uses TypeCompare.getComparator()

  TypeUpdateResult apply(SSAVar, candidateType):
    - Verify type against all bounds
    - Recursively propagate to related variables
    - Use instruction-specific listeners for constraints
```

**Type Update Propagation:**
When assigning type to a variable, propagates through:
- **Assignment chain**: The SSAVar's assign RegisterArg
- **Use chain**: All RegisterArg uses of this SSAVar
- **Phi instructions**: Merges propagate to/from phi nodes

Each instruction type has a listener (ITypeListener) for custom logic.

#### Phase 2: Multi-Variable Search (TypeSearch) - Fallback

If phase 1 leaves unresolved variables, TypeSearch runs:

**Candidate Generation:**
```
For each unresolved variable:
  - Collect types from ASSIGN bounds
  - Collect types from USE bounds
  - Generate wider types (superclasses)
  - Generate narrower types (subclasses)
  - Filter to those satisfying all bounds
  - Limit to CANDIDATES_COUNT_LIMIT (10) types
```

**Constraint Building:**
```
For each variable with multiple candidates:
  - Extract MOVE constraints (type compatibility)
  - Extract PHI constraints (all args must be same type)
  - Track related variables through constraints
```

**Search Execution:**
```
- Resolve independent variables first (no dependencies)
- For dependent variables: exhaustive search
  (iteration through all candidate combinations, limit: 1M)
- Check constraints on each combination
- Apply successful resolution
```

---

## TypeInfo, TypeBound, and TypeCompare Classes

### TypeInfo (Simple Container)

```java
class TypeInfo {
  ArgType type = UNKNOWN;           // Current resolved type
  Set<ITypeBound> bounds;           // All constraints on this variable
}
```

### ITypeBound Interface Hierarchy

```
ITypeBound (interface)
  +-- getBound(): BoundEnum         // ASSIGN or USE
  +-- getType(): ArgType            // Type constraint
  +-- getArg(): RegisterArg         // Associated register arg

ITypeBoundDynamic extends ITypeBound
  +-- getType(TypeUpdateInfo): ArgType  // Dynamic calculation
```

**Implementations:**
- `TypeBoundConst` - Simple static type bound
- `TypeBoundInvokeAssign` - Generic method return type (depends on instance type)
- `TypeBoundInvokeUse` - Generic method argument type (depends on instance type)
- `TypeBoundCheckCastAssign` - Check-cast with dynamic narrowing decision
- `TypeBoundFieldGetAssign` - Generic field type (depends on instance type)

### BoundEnum

```java
enum BoundEnum {
  ASSIGN,  // Type from assignment source (upper bound for object types)
  USE      // Type from usage context (lower bound constraint)
}
```

### TypeCompare (Comparison Engine)

```
compareTypes(ArgType first, ArgType second) -> TypeCompareEnum

Returns: EQUAL, NARROW, NARROW_BY_GENERIC, WIDER, WIDER_BY_GENERIC,
         CONFLICT, CONFLICT_BY_GENERIC, UNKNOWN

Special cases handled:
  - Known vs Unknown types
  - Array types (recursive element comparison)
  - Primitive types (byte->short->int->long->float->double width ordering)
  - Object types (hierarchy + instanceof checks)
  - Generic types (including wildcards and type variables)
  - Generic type compatibility

Comparator<ArgType> used for:
  - Selecting "best" type from bound set
  - max(bounds.stream().map(Type)): finds most specific/narrow type
  - reversed(): finds most general/wide type
```

---

## Unknown Type Resolution Strategy

### Unknown Type Representation

```java
ArgType.UNKNOWN              // Complete unknown (all primitive types possible)
ArgType.UNKNOWN_OBJECT       // Unknown object type
ArgType with PossibleTypes[] // Multiple primitive types possible
```

### Resolution Process

**1. Immutable Types First** (Pre-marked during SSA):
- Type constants from literal values
- Return types from method declarations
- Field types from class definitions

**2. Bound-Based Resolution** (Main algorithm):
- ASSIGN bounds constrain from above (assignment sources)
- USE bounds constrain from below (usage requirements)
- TypeCompare determines if candidate fits all constraints

**3. Bound Checking Logic:**
```
inBounds(SSAVar, candidateType, bounds):
  for each bound in bounds:
    boundType = bound.getType()  // Static or dynamic via TypeUpdateInfo
    compareResult = typeCompare.compareTypes(candidateType, boundType)

    switch(compareResult):
      EQUAL: pass
      WIDER:  pass if bound is ASSIGN (not USE)
      NARROW: pass if bound is ASSIGN or UNKNOWN
      CONFLICT: fail
      WIDER_BY_GENERIC: pass (allow generic variance)
```

**4. Dynamic Bounds Calculation:**
- `ITypeBoundDynamic.getType(TypeUpdateInfo)` uses current state
- Enables inference of generic return types based on instance type
- Example: `List<String> list; String s = list.get(0);`
  - get() return type is generic `T`
  - T is resolved based on instance type `List<String>` -> `String`

---

## Iteration & Fixpoint Approach

### Not Iterative in Traditional Sense

The algorithm is **single-pass with recursive propagation**:

```
Phase 1 (TypeInferenceVisitor):
  For each SSAVar:
    1. Collect all bounds (one pass through usages)
    2. Select best type from bounds (comparison)
    3. Apply type recursively:
       updateTypeChecked(arg, candidateType)
         -> TypeUpdateInfo tracks all pending updates
         -> Listeners process instruction-specific constraints
         -> Recursive propagation through SSA graph
         -> On conflict: REJECT (rollback all changes for this SSAVar)
         -> If success: CHANGED or SAME

  No explicit iterations/fixpoint - single pass with depth-first propagation

Phase 2 (TypeSearch) - Only if needed:
  Exhaustive search with constraint checking
  - Limited to SEARCH_ITERATION_LIMIT (1M iterations)
  - Limited to VARS_PROCESS_LIMIT (5000 variables)
  - Early exit on success or limit reach
```

### TypeUpdateInfo Transaction-Like Behavior

```java
class TypeUpdateInfo {
  Map<InsnArg, TypeUpdateEntry> updateMap;

  requestUpdate(arg, type)    // Queue update
  isProcessed(arg)            // Check if already queued
  rollbackUpdate(arg)         // Undo updates for this arg and dependent
  applyUpdates()              // Batch apply all queued updates

  // Enables: try type, if conflict rollback all changes
}
```

**No explicit loop**, but **recursive traversal**:
```
apply(mth, ssaVar, candidateType)
  -> updateTypeForSsaVar(ssaVar, candidateType)
     -> requestUpdate(assign, candidateType)
        -> runListeners(arg, candidateType)
           -> instruction-specific listener
              -> updateTypeChecked() [RECURSIVE]
                 -> for each related arg/var
```

---

## Array, Generic, and Primitive Type Handling

### Array Types

```
ArgType.isArray()  ->  element type resolved recursively
ArgType.array(elementType)

In bounds:
  - AGET instruction: array type maps to element type
    if arr_arg is assigned: ArrayType -> element propagates to result
    if result is assigned: ElementType -> array(element) propagates to arr_arg

  - APUT instruction: similar bidirectional propagation
    array type constrains element; element type constrains array
```

### Generic Types

```
ArgType properties:
  - isGeneric(): has type parameters
  - getGenericTypes(): List<ArgType> of parameters
  - containsTypeVariable(): has unresolved type vars
  - isGenericType(): is a type variable (T, K, V, etc.)
  - getWildcardType(): if wildcard, the bounded type
  - getWildcardBound(): EXTENDS or SUPER

Dynamic bounds for generics:
  TypeBoundInvokeAssign:
    result_type = methodDetails.getReturnType()
    if (returnType has type vars):
      typeVarsMap = extractTypeVarMapping(instanceType)
      resultType = replaceTypeVariablesUsingMap(returnType, typeVarsMap)
    Example: List<String>.get() -> String (not T)

  TypeBoundFieldGetAssign:
    similar - field type with type vars resolved from instance type

  TypeBoundInvokeUse:
    argument type with type vars resolved from instance type

TypeCompare handles:
  - Generic variance (NARROW_BY_GENERIC, WIDER_BY_GENERIC)
  - Wildcard bounds (? extends X, ? super X)
  - Type variable bounds (T extends Number)
  - Generic conflicts (incompatible type parameters)
```

### Primitive Types

```
enum PrimitiveType:
  BYTE(0), SHORT(1), CHAR(2), INT(3), LONG(4), FLOAT(5), DOUBLE(6)
  + BOOLEAN, VOID, ARRAY, OBJECT

TypeCompare.comparePrimitives():
  - Width ordering: byte < short < int < long < float < double
  - Special cases:
    - BOOLEAN: only equals BOOLEAN (no implicit conversions)
    - VOID: only equals VOID
    - BYTE vs CHAR: BYTE is narrower
    - SHORT vs CHAR: SHORT is narrower

Unknown types with primitives:
  ArgType.UNKNOWN holds PrimitiveType[] possibleTypes
  Multiple possibilities until resolved by bounds

  tryPossibleTypes(): expand unknown to all possible primitive types
  then apply each to see which fits constraints
```

### Immutable Type Handling

```
isTypeImmutable(): IMMUTABLE_TYPE flag set
Immutable types cannot be changed:
  verifyType() rejects different types for immutable args
  Exception: ArgType.UNKNOWN -> specific type allowed

Sources of immutable types:
  - debug info annotations
  - synthetic assignments (literals, new instances)
  - catch block exception types
```

---

## Bound & Constraint Propagation Logic

### Bound Checking (checkBound)

```java
private boolean checkBound(ArgType candidateType, ITypeBound bound, ArgType boundType):

  TypeCompareEnum cmp = compareTypes(candidateType, boundType)

  switch (cmp):
    EQUAL:
      return true  // Perfect match

    WIDER:
      return bound.getBound() != BoundEnum.USE  // OK for ASSIGN, not USE
      // Reason: ASSIGN is upper bound (can be wider)
      //         USE is lower bound (must be narrower/equal)

    NARROW:
      if (bound is ASSIGN) and (boundType is unknown):
        return checkAssignForUnknown(boundType, candidateType)
      return true  // Narrower is OK for USE bounds

    WIDER_BY_GENERIC, NARROW_BY_GENERIC:
      return true  // Allow generic variance

    CONFLICT, CONFLICT_BY_GENERIC:
      return false  // Incompatible

    UNKNOWN:
      warn & return true  // Can't determine hierarchy
```

### Assignment Check for Unknown Bounds

```
checkAssignForUnknown(boundType, candidateType):
  - Recursively checks arrays
  - Checks primitive types match
  - Allows Object assignment from any object type
  - Ensures type variables match
```

### Instruction-Specific Listeners (ITypeListener Registry)

```
Type listeners for constraint propagation:

CONST -> sameFirstArgListener
  Both assign and use args must have same type

MOVE -> moveListener
  Special logic for move instructions
  Assign: result can be wider
  Use: arg must be compatible with result

PHI -> allSameListener
  All arguments must have identical types
  Result must match argument type

AGET -> arrayGetListener
  Array element type bidirectional propagation
  array.get(idx) -> element type
  Special case: implicit upcast for primitives

APUT -> arrayPutListener
  Array element type constraint from put value
  Allows wider array (Object[] can hold any object)

IF -> ifListener
  Both sides of comparison must be compatible
  Soft checks for objects/arrays

ARITH -> arithListener
  Special case: bitwise ops -> all args boolean
  Else: suggestAllSameListener

NEG, NOT -> suggestAllSameListener
  Try to propagate type to all args (soft)

CHECK_CAST -> checkCastListener
  Validate cast is compatible
  Propagate generic types through cast

INVOKE -> invokeListener
  Propagate resolved type vars to method args
  Generic return type resolution
```

### Constraint Checking in TypeSearch

```
For MOVE instructions:
  moveConstraint:
    resType.isEqual(argType) or resType.isWider(argType)
    Ensures move doesn't narrow types

For PHI instructions:
  phiConstraint:
    All phi arguments must be equal type
    Result must equal argument types
```

---

## Key Algorithms & Pseudo-Code

### TypeCompare.compareTypes() - Core Type Ordering

```
compareTypes(first, second) -> TypeCompareEnum:

  1. Quick checks:
     - same reference or equal? -> EQUAL
     - one known, one unknown?
       if (known.isPrimitive() && possibleTypes.contains(known)):
         -> NARROW
       else -> CONFLICT

  2. Array check:
     - both arrays?
       return compareTypes(first.element, second.element)
     - one array?
       if (other.isObject()):
         other == Object? -> NARROW : CONFLICT
       else -> CONFLICT

  3. Both unknown:
     return len(first.types) > len(second.types) ? WIDER : NARROW

  4. Primitive comparison:
     if (both primitive):
       return comparePrimitives(first.prim, second.prim)
       // Uses width ordering

  5. Object comparison:
     if (both objects):
       return compareObjectsNoPreCheck()
       // Complex logic for generics, wildcards, hierarchy
     else (one primitive, one object):
       -> CONFLICT
```

### compareObjectsNoPreCheck() - Object & Generic Handling

```
1. Identical objects?
   - If generics differ: analyze generic variance

2. Generic type handling:
   - Generic type (T, K, V): special rules
   - Wildcard (?): check bounds
   - Type variables: extract bounds and compare

3. Hierarchy check:
   - isInstanceOf(root, first, second)? -> NARROW
   - isInstanceOf(root, second, first)? -> WIDER
   - Both unknown in hierarchy? -> UNKNOWN
   - Neither instance of other? -> CONFLICT

4. Special cases:
   - If one is Object: one narrower, one wider
```

### TypeSearch.search() - Multi-Variable Solver

```
search(vars: List<TypeSearchVarInfo>) -> boolean:

  1. Fill candidates for each variable
  2. Collect constraints
  3. Resolve independent variables (no dependencies)
  4. For dependent variables: exhaustive search

  // Exhaustive search:
  for (iteration = 0; iteration < SEARCH_ITERATION_LIMIT; iteration++):
    if (fullCheck(vars)):  // All constraints satisfied?
      vars.forEach(markTypeResolved)
      return true

    // Advance candidates (cartesian product iteration)
    advanceCandidates(vars)

  return false  // No solution found
```

---

## Rust Implementation Notes

### Transaction Pattern
Use Rust's Result type + transaction rollback mechanism. Collect all updates before applying; rollback if any fail.

### Dynamic Bounds
Use trait objects or enum dispatch for `ITypeBound` implementations. Cache computed types to avoid recalculation.

### Comparator Pattern
Implement `Ord`/`PartialOrd` for ArgType. Use `BTreeSet` for efficient "max" operation on bounds.

### Listener Registry
Use `HashMap<InsnType, Box<dyn TypeListener>>` or enum with direct dispatch.

### Type Graph
Build class hierarchy graph once (CLSP). Cache ancestor/descendant relationships.

### Constraint Checking
Use recursive constraint evaluation. Track visited variables to prevent infinite loops in cycles.

### Search Limits
Essential for safety - implement strict iteration/variable limits.

### Data Structures

```rust
pub struct TypeInfo {
    pub current_type: ArgType,
    pub bounds: HashSet<TypeBound>,
}

pub enum TypeBound {
    Const { bound: BoundEnum, arg_type: ArgType, arg: RegisterArgRef },
    InvokeAssign { /* ... */ },
    InvokeUse { /* ... */ },
    CheckCastAssign { /* ... */ },
    FieldGetAssign { /* ... */ },
}

pub enum BoundEnum {
    Assign,
    Use,
}

pub enum TypeCompareResult {
    Equal,
    Narrow,
    NarrowByGeneric,
    Wider,
    WiderByGeneric,
    Conflict,
    ConflictByGeneric,
    Unknown,
}

pub enum TypeUpdateResult {
    Reject,
    Same,
    Changed,
}
```
