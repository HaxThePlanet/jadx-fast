# Dexterity Documentation

High-performance Android decompiler written in Rust, targeting 1:1 JADX parity.

## Getting Started

| Document | Description |
|----------|-------------|
| [README](../README.md) | Project overview and quick start |
| [CLI Reference](CLI_REFERENCE.md) | Complete command-line options |
| [Performance](PERFORMANCE.md) | Benchmarks and scaling |

## Project Status

| Document | Description |
|----------|-------------|
| [Quality Status](QUALITY_STATUS.md) | Current quality grades and bug status |
| [Roadmap](ROADMAP.md) | Future work and priorities |
| [Changelog](CHANGELOG.md) | Development history |
| [Known Issues](KNOWN_ISSUES.md) | Known limitations and workarounds |

## Architecture

| Document | Description |
|----------|-------------|
| [Architecture](ARCHITECTURE.md) | Crate structure and pipeline |
| [Design Decisions](DESIGN_DECISIONS.md) | Framework filtering, Compose detection |

## Algorithm References (JADX Ports)

| Document | Description |
|----------|-------------|
| [SSA & CFG](JADX_SSA_CFG.md) | Static single assignment and control flow |
| [Type Inference](JADX_TYPE_INFERENCE.md) | Type constraint propagation |
| [Region/Control Flow](JADX_REGION_CONTROL_FLOW.md) | if/else, loops, switch reconstruction |
| [Exception Handling](JADX_EXCEPTION_HANDLING.md) | try-catch-finally |
| [Variable Naming](JADX_VARIABLE_NAMING.md) | Name generation and deobfuscation |
| [Optimization Passes](JADX_OPTIMIZATION_PASSES.md) | Code simplification passes |
| [Deobfuscation](JADX_DEOBFUSCATION.md) | ProGuard mapping support |
| [Codegen Reference](JADX_CODEGEN_REFERENCE.md) | Java source generation |

## Parity Documentation

| Document | Description |
|----------|-------------|
| [DEX Parity](DEX_PARITY.md) | 100% - Binary parsing |
| [Codegen Parity](CODEGEN_PARITY.md) | 94% - Java generation |
| [Kotlin Parity](KOTLIN_PARITY.md) | ~85% - Metadata extraction |
| [Passes Comparison](PASSES_COMPARISON.md) | 95% - Optimization passes |

## Other

| Document | Description |
|----------|-------------|
| [Testing Guide](TESTING_GUIDE.md) | Running tests |
| [Code Navigation](CODE_NAVIGATION.md) | Finding your way around |
| [Security](SECURITY.md) | Security considerations |
| [Code of Conduct](CODE_OF_CONDUCT.md) | Community guidelines |
