# LLM Agent Guide: Autonomous Development Toward JADX Parity

**Status:** HIGH QUALITY ACHIEVED (Dec 16, 2025)
**Strategy:** Clone remaining JADX functionality using comprehensive algorithm documentation

---

## Quick Start

1. **Read the current state**: [QUALITY_STATUS.md](QUALITY_STATUS.md)
2. **Pick a task from roadmap**: [ROADMAP.md](ROADMAP.md)
3. **Find the JADX algorithm**: See [JADX Reference Documentation](#jadx-reference-documentation) below
4. **Reference JADX source**: `jadx-fast/jadx-core/src/main/java/jadx/core/`
5. **Implement and test**: Run `cargo test` (689 integration tests)

---

## Documentation Structure

### Project Status & Planning
| File | Purpose |
|------|---------|
| [QUALITY_STATUS.md](QUALITY_STATUS.md) | Current metrics, achievements, benchmarks |
| [ROADMAP.md](ROADMAP.md) | What to implement next with JADX references |

### JADX Reference Documentation

8 detailed algorithm documents for cloning JADX functionality:

| Document | Purpose | When to Use |
|----------|---------|-------------|
| [JADX_TYPE_INFERENCE.md](JADX_TYPE_INFERENCE.md) | Two-phase bounds-based type system | Type resolution issues |
| [JADX_VARIABLE_NAMING.md](JADX_VARIABLE_NAMING.md) | Multi-stage naming pipeline | Variable naming improvements |
| [JADX_CODEGEN_REFERENCE.md](JADX_CODEGEN_REFERENCE.md) | ClassGen/MethodGen/InsnGen/RegionGen | Code generation patterns |
| [JADX_REGION_CONTROL_FLOW.md](JADX_REGION_CONTROL_FLOW.md) | Region hierarchy and reconstruction | Control flow issues |
| [JADX_SSA_CFG.md](JADX_SSA_CFG.md) | SSA transformation and CFG | SSA/phi node issues |
| [JADX_EXCEPTION_HANDLING.md](JADX_EXCEPTION_HANDLING.md) | Try-catch-finally reconstruction | Exception handling |
| [JADX_OPTIMIZATION_PASSES.md](JADX_OPTIMIZATION_PASSES.md) | 50+ visitor classes pipeline | New optimization passes |
| [JADX_DEOBFUSCATION.md](JADX_DEOBFUSCATION.md) | Two-phase deobfuscation | Deobfuscation improvements |

### JADX Source Code

```
jadx-fast/jadx-core/src/main/java/jadx/core/
├── codegen/                    # Code generation
│   ├── ClassGen.java          # Class structure (900 LOC)
│   ├── MethodGen.java         # Method signatures (450 LOC)
│   ├── InsnGen.java           # Instruction gen (800 LOC)
│   └── RegionGen.java         # Control flow (600 LOC)
├── dex/visitors/
│   ├── regions/maker/         # Region construction
│   │   └── RegionMaker.java   # Core algorithm
│   ├── ssa/SSATransform.java  # SSA transformation
│   └── typeinference/         # Type inference (26 files)
└── utils/NameGen.java         # Variable naming
```

---

## Autonomous Workflow

### Step 1: Select a Task

Check [ROADMAP.md](ROADMAP.md) → "To Clone Next" section:

| Priority | Task | Reference Doc |
|----------|------|---------------|
| P1 | Interface Generics | JADX_CODEGEN_REFERENCE.md |
| P2 | SimplifyVisitor audit | JADX_OPTIMIZATION_PASSES.md |
| P2 | TernaryMod pass | JADX_OPTIMIZATION_PASSES.md |
| P2 | Multi-DEX support | jadx-core/dex/nodes/ |
| P3 | Warning comments | JADX_CODEGEN_REFERENCE.md |

### Step 2: Study the Algorithm

1. Read the relevant JADX_*.md reference document
2. Find the JADX Java source in `jadx-fast/`
3. Understand the algorithm at high level

### Step 3: Find Dexterity Code

| Component | Dexterity File |
|-----------|----------------|
| Type Inference | `crates/dexterity-passes/src/type_inference.rs` (2,432 LOC) |
| Region Builder | `crates/dexterity-passes/src/region_builder.rs` (2,066 LOC) |
| Variable Naming | `crates/dexterity-passes/src/var_naming.rs` (1,480 LOC) |
| Code Generation | `crates/dexterity-codegen/src/body_gen.rs` (4,985 LOC) |
| Expression Gen | `crates/dexterity-codegen/src/expr_gen.rs` (1,362 LOC) |
| Class Gen | `crates/dexterity-codegen/src/class_gen.rs` (1,537 LOC) |

### Step 4: Implement

Follow existing patterns in the file:
- Keep changes minimal and focused
- Add comments only where logic isn't obvious
- Test incrementally

### Step 5: Test

```bash
# Unit tests for specific crate
cargo test -p dexterity-passes

# All tests
cargo test

# Run on APK to validate
./target/release/dexterity -d output/ test.apk
```

### Step 6: Update Documentation

If you made significant improvements, update:
- [QUALITY_STATUS.md](QUALITY_STATUS.md) - Metrics and achievements
- [ROADMAP.md](ROADMAP.md) - Completed work, next priorities

---

## Current State Summary

### Achievements (Dec 16, 2025)

| Metric | Value |
|--------|-------|
| Variable Naming | 99.98% (27,794 → 6 arg0/arg1) |
| Class-Level Generics | 736 classes with `<T>` |
| Undefined Variables | 99.9% eliminated |
| Integration Tests | 689/689 passing |
| Speed Advantage | 3-88x faster than JADX |

### What's Implemented (JADX Parity)

- SSA transformation with phi nodes
- Bounds-based type inference
- Region reconstruction (If/Loop/Switch/TryCatch/Synchronized)
- Semantic variable naming
- Code generation with generics
- Exception handling
- Deobfuscation

### What's Remaining

| Task | Priority | Reference |
|------|----------|-----------|
| Interface generic params | P1 | JADX_CODEGEN_REFERENCE.md |
| Optimization pass audit | P2 | JADX_OPTIMIZATION_PASSES.md |
| Multi-DEX support | DONE | main.rs / converter.rs |
| Warning comments | P3 | JADX_CODEGEN_REFERENCE.md |

---

## Code Quality Standards

### When Implementing
- Follow existing code style (indentation, naming, patterns)
- Keep functions focused on one thing
- Use existing helper functions before writing new ones
- Test edge cases (empty, single item, large input)

### When Testing
- All 689 integration tests must pass
- Add tests for new functionality
- Test with real APKs, not just simple examples

---

## Common Tasks

### Adding a New Optimization Pass

1. Read [JADX_OPTIMIZATION_PASSES.md](JADX_OPTIMIZATION_PASSES.md)
2. Find the JADX Java implementation
3. Create new file in `crates/dexterity-passes/src/`
4. Add to pass pipeline in decompiler.rs
5. Test with integration tests

### Improving Type Inference

1. Read [JADX_TYPE_INFERENCE.md](JADX_TYPE_INFERENCE.md)
2. Check `type_inference.rs` for existing implementation
3. Look for `// TODO` or `// partial` comments
4. Reference TypeInferenceVisitor.java in JADX

### Improving Variable Naming

1. Read [JADX_VARIABLE_NAMING.md](JADX_VARIABLE_NAMING.md)
2. Check `var_naming.rs` for existing implementation
3. Reference NameGen.java in JADX

### Fixing Control Flow Issues

1. Read [JADX_REGION_CONTROL_FLOW.md](JADX_REGION_CONTROL_FLOW.md)
2. Check `region_builder.rs`
3. Reference RegionMaker.java in JADX

---

## File Reference Quick Guide

```
crates/
├── dexterity-dex/          # DEX binary parsing
├── dexterity-ir/           # Intermediate representation
│   └── src/
│       ├── types.rs        # Type system
│       ├── instructions.rs # IR instructions
│       └── info.rs         # Class/Method/Field data
├── dexterity-passes/       # Decompilation passes
│   └── src/
│       ├── type_inference.rs  # Type inference (2,432 LOC)
│       ├── region_builder.rs  # Control flow (2,066 LOC)
│       ├── var_naming.rs      # Variable naming (1,480 LOC)
│       ├── ssa.rs             # SSA transformation (964 LOC)
│       └── simplify.rs        # Simplification (1,646 LOC)
├── dexterity-codegen/      # Java code generation
│   └── src/
│       ├── body_gen.rs     # Region traversal (4,985 LOC)
│       ├── expr_gen.rs     # Expressions (1,362 LOC)
│       └── class_gen.rs    # Class structure (1,537 LOC)
└── dexterity-cli/          # CLI application
    └── src/
        ├── converter.rs    # DEX→IR conversion
        └── decompiler.rs   # Pipeline orchestration
```

---

**Last Updated:** Dec 16, 2025
