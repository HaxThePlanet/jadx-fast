# Dexterity Documentation

High-performance Android decompiler written in Rust, targeting JADX parity.

**Current Status:** 🟢 PRODUCTION-READY | 0 P0 Bugs | A-/B+ Grade (85-90%) | Dec 25, 2025
**Performance:** 14x faster than JADX | 5.2K apps/hour @ 2.7 sec avg

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
| [Algorithm References](ALGORITHM_REFERENCES.md) | Quick links to JADX source for key algorithms |
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
| [Codegen Parity](CODEGEN_PARITY_MASTER.md) | **A-/B+ (85-90%)** | Java gen - production-ready |
| [Deobf Parity](JADX_DEOBF_PARITY_AUDIT.md) | **A- (90%)** | ProGuard/JOBF |
| [Kotlin Parity](KOTLIN_PARITY.md) | **B+ (85-90%)** | Field aliases FIXED Dec 24 |
| [Passes Parity](PASSES_PARITY.md) | **B- (80%)** | 86/105 JADX passes |
| [Clone Tasks](CLONE_TASKS.md) | - | Remaining JADX features to port |

## JADX Reference Docs

| Document | Description |
|----------|-------------|
| [DEX Reference](JADX_DEXTERITY_DEX_REFERENCE.md) | DEX format details |
| [IR Reference](JADX_DEXTERITY_IR_REFERENCE.md) | IR type system, SSA, instructions |
| [Resources Reference](JADX_DEXTERITY_RESOURCES_REFERENCE.md) | ARSC/AXML format |

## Development

| Document | Description |
|----------|-------------|
| [Refactor Plan](REFACTOR_PLAN.md) | Current refactoring tasks and status |
| [Optimization Plan](OPTIMIZATION_PLAN.md) | Performance optimization roadmap |
| [Performance Study](PERFORMANCE_STUDY.md) | Detailed performance analysis |
| [Comparison Reference Files](COMPARISON_REFERENCE_FILES.md) | Test APKs for JADX comparison |
| [Quality Analysis Report](QUALITY_ANALYSIS_REPORT.md) | Detailed quality metrics analysis |

## LLM Tools

| Document | Description |
|----------|-------------|
| [LLM Agent Guide](LLM_AGENT_GUIDE.md) | Guide for AI agents working on codebase |
| [LLM Postprocessing](LLM_POSTPROC.md) | LLM-based output enhancement |

## Other

| Document | Description |
|----------|-------------|
| [Known Issues](KNOWN_ISSUES.md) | Known limitations and workarounds |
| [Changelog](CHANGELOG.md) | Development history |
| [Testing Guide](TESTING_GUIDE.md) | Running tests |
| [Security](SECURITY.md) | Security considerations |
| [Code of Conduct](CODE_OF_CONDUCT.md) | Community guidelines |
