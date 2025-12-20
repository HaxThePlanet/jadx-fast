# JADX Deobfuscation Reference for Dexterity

This document provides a comprehensive reference of JADX's deobfuscation system for achieving 1:1 feature parity in Dexterity.

## Table of Contents

1. [Architecture Overview](#architecture-overview)
2. [Deobfuscation Passes](#deobfuscation-passes)
3. [Name Generation Strategies](#name-generation-strategies)
4. [Rename Conditions](#rename-conditions)
5. [What Gets Renamed](#what-gets-renamed)
6. [Configuration Options](#configuration-options)
7. [Mapping File Formats](#mapping-file-formats)
8. [Feature Comparison Matrix](#feature-comparison-matrix)
9. [Implementation Gaps](#implementation-gaps)
10. [Key Files Reference](#key-files-reference)

---

## Architecture Overview

### JADX (Java Reference)

JADX uses a **two-phase approach**:

**Phase 1: Early Deobfuscation (Pre-Code Generation)**
- Loads and applies persisted mapping files
- Determines which names need renaming using conditions
- Generates deterministic aliases
- Stores aliases in a global registry for cross-reference resolution

**Phase 2: Validation & Refinement (Code Generation & Beyond)**
- Validates generated names for Java identifier rules
- Fixes naming collisions
- Applies source file heuristics
- Persists final mappings for caching

### Dexterity (Rust Implementation)

Dexterity uses a **single deterministic prepass** before code generation:

**Precompute Phase:**
1. Load JOBF file (if mode allows)
2. Parse whitelist patterns
3. Sort classes deterministically
4. Detect Android R classes
5. Generate all aliases (packages → classes → fields → methods)
6. Store in thread-safe registry

**Application Phase:**
- Apply aliases from registry to IR before code generation

---

## Deobfuscation Passes

### JADX Pass Order

| Stage | Pass | Description |
|-------|------|-------------|
| PRE-DECOMPILE | SignatureProcessor | Extract generic type information |
| PRE-DECOMPILE | OverrideMethodVisitor | Detect @Override annotations |
| PRE-DECOMPILE | **DeobfuscatorVisitor** | Main deobfuscation pass |
| PRE-DECOMPILE | **RenameVisitor** | Validate and fix names |
| PRE-DECOMPILE | UsageInfoVisitor | Track dependencies |
| TYPE INFERENCE | TypeInferenceVisitor | Infer register types |
| TYPE INFERENCE | DebugInfoApplyVisitor | Apply debug info |
| CODE PREP | **CodeRenameVisitor** | Apply variable naming |
| CODE PREP | ApplyVariableNames | Apply final variable names |
| POST-GEN | SaveDeobfMapping | Persist final mapping |

### Dexterity Pass Order

| Stage | Pass | Description | Status |
|-------|------|-------------|--------|
| PRE-DECOMPILE | precompute_deobf_aliases | Main deobfuscation | ✅ Implemented |
| PRE-DECOMPILE | apply_aliases_from_registry | Apply to IR | ✅ Implemented |
| CODE GEN | class_output_rel_path | Use aliased paths | ✅ Implemented |
| POST-GEN | save_jobf_file | Persist mappings | ✅ Implemented |
| - | RenameVisitor equivalent | Collision detection | ❌ Not implemented |
| - | Variable naming deobf | Local var renaming | ❌ Not implemented |

---

## Name Generation Strategies

### Package Names

| Aspect | JADX | Dexterity |
|--------|------|-----------|
| Format | `p[3-digit-index][name_part]` | `p[index][sanitized_name]` |
| Example | `p000android`, `p001com` | `p000a`, `p001io` |
| Hierarchy | Composed: `p000com/p001example` | Composed: `p000a/p001b` |
| Index Width | Fixed 3 digits | Variable width |

### Class Names

| Aspect | JADX | Dexterity |
|--------|------|-----------|
| Format | `[Prefix]C[4-digit-index][name_part]` | `[Prefix]C[index][name_part]` |
| Index Width | Fixed 4 digits | Variable width |

**Class Prefix Logic (Both JADX and Dexterity):**

| Condition | Prefix |
|-----------|--------|
| Is enum | `Enum` |
| Is interface | `Interface` |
| Is abstract | `Abstract` |
| Extends Activity | `Activity` |
| Extends Service | `Service` |
| Implements Runnable | `Runnable` |
| Extends View/ViewGroup | Base class name |
| Otherwise | (empty) |

**Examples:**
- `EnumC0001Mode`
- `AbstractActivityC0002MainActivity`
- `InterfaceC0003Listener`
- `C0004Helper`

### Field Names

| Aspect | JADX | Dexterity |
|--------|------|-----------|
| Format | `f[index][name_part]` | `f[index][sanitized_name]` |
| Example | `f0tempVar`, `f1handler` | `f0temp`, `f1count` |

### Method Names

| Aspect | JADX | Dexterity |
|--------|------|-----------|
| Format | `[mo/m][index][name_part]` | `[mo/m][index][name_part]` |
| Override prefix | `mo` (for @Override) | `mo` (for @Override) |
| Regular prefix | `m` | `m` |
| Example | `mo0onCreate`, `m1doSomething` | `mo0onCreate`, `m1process` |

### Name Sanitization

Both implementations:
- Remove invalid identifier characters
- If name > max_length: use hex hash `x[hash]`
- Validate against Java identifier rules

---

## Rename Conditions

### Condition Action Types

```
NoAction    - Use default logic
Rename      - Suggest renaming (can be overridden)
ForceRename - Must rename
DontRename  - Never rename (highest priority)
```

### Built-in Conditions

| Condition | JADX | Dexterity | Description |
|-----------|------|-----------|-------------|
| LengthCondition | ✅ | ✅ | Rename if len < min OR len > max |
| ValidityCondition | ✅ | ✅ | Rename invalid Java identifiers |
| PrintableCondition | ✅ | ✅ | Rename non-printable characters |
| PackageWhitelistCondition | ✅ | ✅ | Skip whitelisted packages |
| CombinedCondition | ✅ | ✅ | Chain multiple conditions |

### Default Combined Condition (JADX-Style)

```
1. PackageWhitelistCondition -> DontRename for whitelisted
2. ValidityCondition -> ForceRename for invalid identifiers
3. LengthCondition -> ForceRename if outside min/max range
```

### Package Whitelist (Static)

Both JADX and Dexterity whitelist these packages by default:

**Two-Letter TLDs:**
`io`, `rx`, `me`, `tv`, `uk`, `de`, `it`, `jp`, `cn`, `co`, `pl`, `fr`, `es`, `nl`, `be`, `ch`, `at`, `se`, `no`, `fi`, `hu`, `cz`, `sk`, `ua`, `ru`, `br`, `in`, `id`, `my`, `sg`, `au`, `nz`, `za`, `mx`, `ar`

**Three+ Letter TLDs:**
`com`, `org`, `net`, `edu`, `gov`, `mil`, `int`, `pro`, `biz`, `app`, `pub`, `dev`, `xyz`

**Well-Known Libraries:**
`java`, `javax`, `kotlin`, `kotlinx`, `okio`, `okhttp3`, `grpc`, `bolt`, `gson`, `glide`, `dagger`, `junit`, `mockito`, `apache`

---

## What Gets Renamed

### Elements That ARE Renamed

| Element | JADX | Dexterity | Condition |
|---------|------|-----------|-----------|
| Packages | ✅ | ✅ | Short/invalid names |
| Classes | ✅ | ✅ | Short/invalid names |
| Static Fields | ✅ | ✅ | Short/invalid names |
| Instance Fields | ✅ | ✅ | Short/invalid names |
| Methods | ✅ | ✅ | Short/invalid names |
| Local Variables | ✅ | ❌ | Via SSA variable naming |

### Elements That Are NOT Renamed

| Element | JADX | Dexterity | Reason |
|---------|------|-----------|--------|
| Constructors | ❌ | ❌ | `<init>` preserved |
| Class Initializers | ❌ | ❌ | `<clinit>` preserved |
| Android R Classes | ❌ | ❌ | Auto-detected, excluded |
| Whitelisted packages | ❌ | ❌ | User-specified patterns |
| Valid long names | ❌ | ❌ | Pass all conditions |

### Android R-Class Detection

Both implementations detect resource classes using these criteria:

1. Top-level class named exactly `R`
2. Has zero fields/methods in top class
3. Has inner classes (R.attr, R.id, R.string, etc.)
4. Each inner class has ONLY:
   - `int` or `int[]` static fields
   - Constructors and/or `<clinit>`
5. No other methods

---

## Configuration Options

### CLI Flags Comparison

| Flag | JADX | Dexterity | Default |
|------|------|-----------|---------|
| Enable deobfuscation | `--deobfuscation` | `--deobf` | false |
| Min name length | `--deobf-min` | `--deobf-min` | 3 |
| Max name length | `--deobf-max` | `--deobf-max` | 64 |
| Whitelist patterns | `--deobf-whitelist` | `--deobf-whitelist` | (none) |
| ProGuard mapping path | `--mapping-path` | `--mappings-path` | (none) |
| Mapping mode | `--mapping-mode` | `--mappings-mode` | read |
| JOBF cache file | `--deobf-cfg-file` | `--deobf-cfg-file` | (auto) |
| JOBF cache mode | `--deobf-cfg-file-mode` | `--deobf-cfg-file-mode` | read |
| Source name mode | `--use-source-name-as-class-name-alias` | `--use-source-name-as-class-name-alias` | never |
| Source name limit | `--source-name-repeat-limit` | `--source-name-repeat-limit` | 10 |
| Rename flags | `--rename-flags` | `--rename-flags` | all |
| FS case sensitive | `--fs-case-sensitive` | `--fs-case-sensitive` | false |

### JOBF Cache Modes

| Mode | JADX | Dexterity | Behavior |
|------|------|-----------|----------|
| read | ✅ | ✅ | Load only, don't save |
| readOrSave | ✅ | ✅ | Load if exists, save if not |
| save | ✅ | ✅ | Always save |
| overwrite | ✅ | ✅ | Always save, overwriting |
| ignore | ✅ | ✅ | Don't use at all |

### Rename Flags

| Flag | JADX | Dexterity | Description |
|------|------|-----------|-------------|
| case | ✅ | ⚠️ Partial | Filesystem case safety |
| valid | ✅ | ✅ | Java identifier validity |
| printable | ✅ | ✅ | Printable ASCII only |
| none | ✅ | ✅ | Disable all conditions |
| all | ✅ | ✅ | Enable all conditions |

---

## Mapping File Formats

### ProGuard Format (Supported by Both)

```
# Comment line
com.example.Original -> a:
    int fieldName -> a
    void methodName(int,java.lang.String) -> b
    1:10:void methodWithLineNumbers():15:24 -> c
```

**Parsing:**
- Left side = original name
- Right side = obfuscated name (as in DEX)
- Line numbers stripped from methods
- Stored as obfuscated → original mapping

### JOBF Format (Native Cache)

```
# Auto-generated mapping cache
p android.support.v4 = p001support
c com/example/MainActivity = ActivityC0001MainActivity
f com/example/MainActivity.mTemp = f0mVariable
m com/example/MainActivity.onCreate(Landroid/os/Bundle;)V = mo0onCreate
```

**Type Prefixes:**
- `p` = package
- `c` = class
- `f` = field
- `m` = method

### Other Formats (JADX Only via Plugins)

| Format | JADX | Dexterity |
|--------|------|-----------|
| ProGuard | ✅ | ✅ |
| Tiny v1 | ✅ (plugin) | ❌ |
| Tiny v2 | ✅ (plugin) | ❌ |
| MojMap | ✅ (plugin) | ❌ |
| SRG | ✅ (plugin) | ❌ |
| TSRG | ✅ (plugin) | ❌ |
| CSRG | ✅ (plugin) | ❌ |

---

## Feature Comparison Matrix

### Core Features

| Feature | JADX | Dexterity | Notes |
|---------|------|-----------|-------|
| Package renaming | ✅ | ✅ | Hierarchical composition |
| Class renaming | ✅ | ✅ | With modifier prefixes |
| Field renaming | ✅ | ✅ | Static and instance |
| Method renaming | ✅ | ✅ | With override detection |
| Local variable renaming | ✅ | ❌ | Requires SSA |
| Deterministic ordering | ✅ | ✅ | Sorted by descriptor |
| Thread-safe registry | ✅ | ✅ | DashMap in Dexterity |
| Android R detection | ✅ | ✅ | Auto-excluded |
| Whitelist support | ✅ | ✅ | Package and class patterns |

### Mapping & Persistence

| Feature | JADX | Dexterity | Notes |
|---------|------|-----------|-------|
| ProGuard mapping read | ✅ | ✅ | Standard format |
| ProGuard mapping write | ✅ | ❌ | Not implemented |
| JOBF cache load | ✅ | ✅ | Auto-generated |
| JOBF cache save | ✅ | ✅ | Persists aliases |
| External format plugins | ✅ | ❌ | Tiny, MojMap, etc. |

### Validation & Collision Handling

| Feature | JADX | Dexterity | Notes |
|---------|------|-----------|-------|
| Java identifier validation | ✅ | ✅ | Reserved keywords |
| Class-package collision | ✅ | ✅ | Force rename on collision |
| Method overload handling | ✅ | ✅ | Proto descriptor in key |
| Inner class collision | ✅ | ❌ | RenameVisitor needed |
| Case collision detection | ✅ | ❌ | For case-insensitive FS |
| Second-pass validation | ✅ | ❌ | RenameVisitor needed |

### Source Name Features

| Feature | JADX | Dexterity | Notes |
|---------|------|-----------|-------|
| Source file name hints | ✅ | ⚠️ Partial | Flag exists but limited |
| Repeat limit enforcement | ✅ | ⚠️ Partial | Config available |
| SourceFileRename pass | ✅ | ❌ | Not implemented |

---

## Implementation Gaps

### High Priority (P1)

| Gap | Impact | Effort |
|-----|--------|--------|
| **RenameVisitor second-pass** | Collision bugs possible | Medium |
| **Local variable deobfuscation** | Variable names not renamed | High |
| **Case collision detection** | Windows FS issues | Low |

### Medium Priority (P2)

| Gap | Impact | Effort |
|-----|--------|--------|
| Inner class collision handling | Edge case bugs | Medium |
| Source file name extraction | Missing rename hints | Medium |
| ProGuard mapping write | Can't export mappings | Low |

### Low Priority (P3)

| Gap | Impact | Effort |
|-----|--------|--------|
| Additional mapping formats | Power user feature | Medium |
| Custom condition plugins | Extensibility | Medium |
| GUI integration | CLI-only currently | High |

---

## Key Files Reference

### Dexterity Implementation

| File | Lines | Purpose |
|------|-------|---------|
| `dexterity-deobf/src/lib.rs` | 27 | Public API exports |
| `dexterity-deobf/src/alias_provider.rs` | 224 | Name generation |
| `dexterity-deobf/src/conditions.rs` | 492 | Rename conditions |
| `dexterity-deobf/src/name_mapper.rs` | 162 | Name validation |
| `dexterity-deobf/src/registry.rs` | 288 | Thread-safe storage |
| `dexterity-deobf/src/visitor.rs` | 190 | Core visitor |
| `dexterity-deobf/src/mapping_parser.rs` | 389 | ProGuard parsing |
| `dexterity-cli/src/deobf.rs` | 1007 | CLI integration |

### JADX Reference (jadx-fast/)

| File | Purpose |
|------|---------|
| `jadx-core/src/main/java/jadx/core/deobf/` | Main deobf package |
| `Deobfuscator.java` | Entry point |
| `DeobfuscatorVisitor.java` | Main visitor |
| `DeobfCondition.java` | Condition interface |
| `DeobfAliasProvider.java` | Name generation |
| `NameMapper.java` | Name validation |
| `RenameVisitor.java` | Second-pass validation |

---

## Example Workflow

### Input (Obfuscated)

```smali
.class public La;
.super Landroid/app/Activity;

.field public a:I

.method public a()V
    .annotation runtime Ljava/lang/Override;
    .end annotation
    return-void
.end method
```

### Processing Steps

1. **Enable deobf**: `--deobf --deobf-min 3`
2. **Package `L`**: 1 char < 3 → rename to `p000a`
3. **Class `La;`**: 1 char < 3, extends Activity → rename to `AbstractActivityC0000a`
4. **Field `a:I`**: 1 char < 3 → rename to `f0a`
5. **Method `a()V`**: 1 char < 3, has @Override → rename to `mo0onCreate`

### Output (Deobfuscated)

```java
package p000a;

public abstract class AbstractActivityC0000a extends Activity {
    public int f0a;

    @Override
    public void mo0onCreate() {
        // renamed from: a
    }
}
```

### JOBF Cache

```
p a = p000a
c La; = AbstractActivityC0000a
f La;.a = f0a
m La;.a()V = mo0onCreate
```

---

## Reserved Keywords (Java)

Both implementations check against these reserved keywords:

```
abstract, assert, boolean, break, byte, case, catch, char, class,
const, continue, default, do, double, else, enum, extends, false,
final, finally, float, for, goto, if, implements, import, instanceof,
int, interface, long, native, new, null, package, private, protected,
public, return, short, static, strictfp, super, switch, synchronized,
this, throw, throws, transient, true, try, void, volatile, while, _
```

---

## Performance Considerations

### Dexterity Optimizations

1. **DashMap Registry**: Lock-free concurrent HashMap (30-50% faster)
2. **Atomic Counters**: Thread-safe index generation without locks
3. **Single Prepass**: Deterministic ordering, parallelized application
4. **Lazy Static Init**: Regex/reserved sets compiled once
5. **O(n) R-Class Detection**: Linear scan vs per-class checks

### JADX Reference Performance

1. **Synchronized Registry**: Traditional locking (contention possible)
2. **Sequential Processing**: Deterministic but single-threaded alias gen
3. **Two-Pass Approach**: More thorough but higher latency

---

## Testing Checklist

When implementing missing features, verify:

- [ ] Package aliases compose hierarchically
- [ ] Class prefixes match element type (Enum, Interface, Abstract)
- [ ] Methods with @Override get `mo` prefix
- [ ] Constructors (`<init>`) never renamed
- [ ] Class initializers (`<clinit>`) never renamed
- [ ] Android R classes completely excluded
- [ ] Whitelisted packages/classes skipped
- [ ] JOBF load/save round-trips correctly
- [ ] ProGuard mapping reverses correctly (obfuscated → original)
- [ ] Names outside length bounds trigger rename
- [ ] Invalid identifiers trigger rename
- [ ] Reserved keywords trigger rename
- [ ] Class-package name collisions handled
- [ ] Method overloads distinguished by proto
