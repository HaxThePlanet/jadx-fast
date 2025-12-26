# Dexterity Documentation Index

High-performance Android decompiler written in Rust, targeting JADX parity.

**Status:** 🟢 PRODUCTION-READY | A-/B+ Grade (85-90%) | 0 P0 | 0 P1 | 0 P1-CG | 0 P2-CG | Build: CLEAN | Dec 26, 2025
**Performance:** 14x faster than JADX | 5.2K apps/hour @ 2.7 sec avg
**Security:** Anti-RE ZIP hardening | 83% bad APK recovery (was 43%)

---

## Primary Documents

| Document | Description |
|----------|-------------|
| **[ROADMAP.md](ROADMAP.md)** | **Single source of truth** - Status, bugs, quality grades, known issues, benchmarks |
| [CHANGELOG.md](CHANGELOG.md) | Development history (milestones only) |
| [ARCHITECTURE.md](ARCHITECTURE.md) | Crate structure, pipeline, design overview |

---

## Getting Started

| Document | Description |
|----------|-------------|
| [README](../README.md) | Project overview and quick start |
| [CLI_REFERENCE.md](CLI_REFERENCE.md) | Complete command-line options |
| [TESTING_GUIDE.md](TESTING_GUIDE.md) | Running tests |

---

## Architecture & Design

| Document | Description |
|----------|-------------|
| [ARCHITECTURE.md](ARCHITECTURE.md) | Crate structure (~126K lines), pipeline overview |
| [DESIGN_DECISIONS.md](DESIGN_DECISIONS.md) | Framework filtering, Compose detection, design rationale |
| [CODE_NAVIGATION.md](CODE_NAVIGATION.md) | Finding your way around the codebase |
| [OPTIMIZATION_PLAN.md](OPTIMIZATION_PLAN.md) | Performance optimization roadmap |
| [REFACTOR_PLAN.md](REFACTOR_PLAN.md) | Current refactoring tasks |

---

## JADX Algorithm References

Documentation of JADX algorithms that Dexterity ports:

| Document | Description |
|----------|-------------|
| [ALGORITHM_REFERENCES.md](ALGORITHM_REFERENCES.md) | Quick links to JADX source for key algorithms |
| [JADX_SSA_CFG.md](JADX_SSA_CFG.md) | Static single assignment and control flow |
| [JADX_TYPE_INFERENCE.md](JADX_TYPE_INFERENCE.md) | Type constraint propagation |
| [JADX_REGION_CONTROL_FLOW.md](JADX_REGION_CONTROL_FLOW.md) | if/else, loops, switch reconstruction |
| [JADX_EXCEPTION_HANDLING.md](JADX_EXCEPTION_HANDLING.md) | try-catch-finally |
| [JADX_VARIABLE_NAMING.md](JADX_VARIABLE_NAMING.md) | Name generation and deobfuscation |
| [JADX_DEOBFUSCATION.md](JADX_DEOBFUSCATION.md) | ProGuard mapping support |
| [JADX_DEOBFUSCATION_REFERENCE.md](JADX_DEOBFUSCATION_REFERENCE.md) | Detailed deobf algorithm |

---

## JADX Format References

Detailed documentation of JADX data structures and formats:

| Document | Description |
|----------|-------------|
| [JADX_DEXTERITY_DEX_REFERENCE.md](JADX_DEXTERITY_DEX_REFERENCE.md) | DEX format details |
| [JADX_DEXTERITY_IR_REFERENCE.md](JADX_DEXTERITY_IR_REFERENCE.md) | IR type system, SSA, instructions |
| [JADX_DEXTERITY_RESOURCES_REFERENCE.md](JADX_DEXTERITY_RESOURCES_REFERENCE.md) | ARSC/AXML format |

---

## Parity Tracking

Status of Dexterity vs JADX feature parity:

| Document | Grade | Description |
|----------|-------|-------------|
| [DEX_PARITY.md](DEX_PARITY.md) | A+ (100%) | Binary parsing - complete |
| [CODEGEN_PARITY_MASTER.md](CODEGEN_PARITY_MASTER.md) | A-/B+ (85-90%) | Java codegen - production-ready |
| [IR_CLONE_STATUS.md](IR_CLONE_STATUS.md) | B (85%) | JADX IR clone status |
| [IR_REMAINING_TASKS.md](IR_REMAINING_TASKS.md) | - | Open IR work |
| [PASSES_PARITY.md](PASSES_PARITY.md) | B- (80%) | 86/105 JADX passes |
| [KOTLIN_PARITY.md](KOTLIN_PARITY.md) | A (~95%) | BEYOND JADX: contracts, context receivers, type aliases |
| [JADX_DEOBF_PARITY_AUDIT.md](JADX_DEOBF_PARITY_AUDIT.md) | A (~98%) | ProGuard/JOBF/RenameValidator (100% parity Dec 26) |
| [CLONE_TASKS.md](CLONE_TASKS.md) | - | Remaining JADX features to port |

---

## Performance & Quality

| Document | Description |
|----------|-------------|
| [PERFORMANCE.md](PERFORMANCE.md) | Benchmarks and scaling data |
| [PERFORMANCE_STUDY.md](PERFORMANCE_STUDY.md) | Detailed performance analysis |
| [QUALITY_ANALYSIS_REPORT.md](QUALITY_ANALYSIS_REPORT.md) | Detailed quality metrics |
| [COMPARISON_REFERENCE_FILES.md](COMPARISON_REFERENCE_FILES.md) | Test APKs for JADX comparison |
| [BADBOY_REFERENCE.md](BADBOY_REFERENCE.md) | Reference for badboy APK testing |

---

## Development Tools

| Document | Description |
|----------|-------------|
| [LLM_AGENT_GUIDE.md](LLM_AGENT_GUIDE.md) | Guide for AI agents working on codebase |
| [LLM_POSTPROC.md](LLM_POSTPROC.md) | LLM-based output enhancement |

---

## Project

| Document | Description |
|----------|-------------|
| [SECURITY.md](SECURITY.md) | Security considerations |
| [CODE_OF_CONDUCT.md](CODE_OF_CONDUCT.md) | Community guidelines |

---

## Document Hierarchy

```
ROADMAP.md (Single Source of Truth)
├── Status, quality grades, per-category grades
├── All P0/P1/P2 bug tracking with fixes
├── Known issues & workarounds
├── Performance benchmarks
└── Test coverage

CHANGELOG.md (Historical Record)
└── Milestone summaries only (points to ROADMAP for details)

ARCHITECTURE.md (Technical Design)
└── Crate structure, pipeline, design decisions

All other docs (Reference Material)
└── JADX algorithms, parity tracking, format specs
```
