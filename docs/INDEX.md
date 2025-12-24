# Dexterity Documentation

High-performance Android decompiler written in Rust, targeting JADX parity.

**Current Status:** 2 P0 Bugs | ~80% Syntax Quality | ~62% File Coverage

## Core Status Docs

| Document | Description |
|----------|-------------|
| [ROADMAP](ROADMAP.md) | **Authoritative** - Open work, P0/P1 bugs, remaining tasks |
| [QUALITY_STATUS](QUALITY_STATUS.md) | Current grades, output comparison data, metrics |

## Getting Started

| Document | Description |
|----------|-------------|
| [README](../README.md) | Project overview and quick start |
| [CLI Reference](CLI_REFERENCE.md) | Complete command-line options |
| [Performance](PERFORMANCE.md) | Benchmarks and scaling |

## Architecture

| Document | Description |
|----------|-------------|
| [Architecture](ARCHITECTURE.md) | Crate structure and pipeline |
| [Design Decisions](DESIGN_DECISIONS.md) | Framework filtering, Compose detection |
| [Code Navigation](CODE_NAVIGATION.md) | Finding your way around |

## JADX Algorithm References

These docs describe the JADX algorithms that Dexterity ports:

| Document | Description |
|----------|-------------|
| [SSA & CFG](JADX_SSA_CFG.md) | Static single assignment and control flow |
| [Type Inference](JADX_TYPE_INFERENCE.md) | Type constraint propagation |
| [Region/Control Flow](JADX_REGION_CONTROL_FLOW.md) | if/else, loops, switch reconstruction |
| [Exception Handling](JADX_EXCEPTION_HANDLING.md) | try-catch-finally |
| [Variable Naming](JADX_VARIABLE_NAMING.md) | Name generation and deobfuscation |
| [Deobfuscation](JADX_DEOBFUSCATION.md) | ProGuard mapping support |
| [Deobfuscation Reference](JADX_DEOBFUSCATION_REFERENCE.md) | Detailed deobf algorithm |

## Parity Status

| Document | Status | Description |
|----------|--------|-------------|
| [DEX Parity](DEX_PARITY.md) | **A+** | Binary parsing - complete |
| [IR Clone Status](IR_CLONE_STATUS.md) | **B (85%)** | JADX IR clone |
| [IR Remaining Tasks](IR_REMAINING_TASKS.md) | - | Open IR work |
| [Codegen Parity](CODEGEN_PARITY_MASTER.md) | **B- (80%)** | Java generation |
| [Deobf Parity](JADX_DEOBF_PARITY_AUDIT.md) | **B (85%)** | ProGuard/JOBF |
| [Kotlin Parity](KOTLIN_PARITY.md) | **C (70%)** | Field decl OK, usages P1 bug |
| [Passes Parity](PASSES_PARITY.md) | **B- (80%)** | 86/105 JADX passes |
| [Clone Tasks](CLONE_TASKS.md) | - | Remaining JADX features to port |

## JADX Reference Docs

| Document | Description |
|----------|-------------|
| [DEX Reference](JADX_DEXTERITY_DEX_REFERENCE.md) | DEX format details |
| [IR Reference](JADX_DEXTERITY_IR_REFERENCE.md) | IR type system, SSA, instructions |
| [Resources Reference](JADX_DEXTERITY_RESOURCES_REFERENCE.md) | ARSC/AXML format |

## Other

| Document | Description |
|----------|-------------|
| [Known Issues](KNOWN_ISSUES.md) | Known limitations and workarounds |
| [Changelog](CHANGELOG.md) | Development history |
| [Testing Guide](TESTING_GUIDE.md) | Running tests |
| [Security](SECURITY.md) | Security considerations |
| [Code of Conduct](CODE_OF_CONDUCT.md) | Community guidelines |
