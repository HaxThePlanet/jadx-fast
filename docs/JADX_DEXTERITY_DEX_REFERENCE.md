# JADX DEX vs Dexterity DEX Reference

This document provides a comprehensive 1:1 mapping between JADX's Java-based DEX parser and Dexterity's Rust-based `dexterity-dex` crate. Both implement the Android DEX file format specification.

---

## Architecture Overview

```
JADX (Java):
  DEX File → DexFileLoader → DexReader → DexHeader
                                       → SectionReader → ClassDef/MethodDef/FieldDef
                                       → DexCodeReader → InsnDecoder

Dexterity (Rust):
  DEX File → DexReader (memmap) → DexHeader
                                → Sections → ClassDef/MethodId/FieldId
                                → CodeItem → Decoder (DecodedInsn)
```

---

## Module/Class Mapping Table

| Component | JADX (Java) | Dexterity (Rust) |
|-----------|-------------|------------------|
| File Loader | `DexFileLoader.java` | `reader.rs` (with memmap2) |
| Header Parser | `DexHeader.java` | `header.rs` |
| Section Reader | `SectionReader.java` | `sections/mod.rs` |
| Class Definition | `DexClassData.java` | `sections/class_def.rs` |
| Field Reference | `DexFieldData.java` | `sections/field_id.rs` |
| Method Reference | `DexMethodData.java`, `DexMethodRef.java` | `sections/method_id.rs` |
| Prototype | `DexMethodProto.java` | `sections/proto_id.rs` |
| Bytecode Reader | `DexCodeReader.java` | `sections/code_item.rs` |
| Opcodes | `DexOpcodes.java` | `insns/opcode.rs` |
| Instruction Format | `DexInsnFormat.java` | `insns/format.rs` |
| Instruction Decoder | `DexInsnData.java` | `insns/decoder.rs` |
| LEB128 | `Leb128.java` | `utils/leb128.rs` |
| MUTF-8 | `MUtf8.java` | `utils/mutf8.rs` |
| Annotations | `AnnotationsParser.java` | `sections/class_def.rs` (inline) |
| Encoded Values | `EncodedValueParser.java` | `sections/encoded_value.rs` |
| Method Handles | `DexMethodHandle.java` | `sections/method_handle.rs` |

---

## DEX Header (112 bytes)

### JADX DexHeader

```java
// DexHeader.java - reads 108 bytes (excludes link section details)
public class DexHeader {
    private final byte[] magic;      // 4 bytes: "dex\n"
    private final int version;       // 3 bytes: "035"-"041"
    private final int checksum;      // CRC32
    private final byte[] signature;  // SHA-1 (20 bytes)
    private final int fileSize;
    private final int headerSize;    // Always 0x70 (112)
    private final int endianTag;     // 0x12345678
    private final int stringIdsSize, stringIdsOff;
    private final int typeIdsSize, typeIdsOff;
    private final int protoIdsSize, protoIdsOff;
    private final int fieldIdsSize, fieldIdsOff;
    private final int methodIdsSize, methodIdsOff;
    private final int classDefsSize, classDefsOff;
    private final int mapOff;        // For v41 multi-dex
    // Map list items for call sites, method handles (DEX 038+)
}
```

### Dexterity DexHeader

```rust
// header.rs
pub struct DexHeader {
    pub magic: [u8; 4],          // "dex\n" (0x6465780A)
    pub version: [u8; 3],        // "035"-"041"
    pub checksum: u32,           // Adler32
    pub signature: [u8; 20],     // SHA-1
    pub file_size: u32,
    pub header_size: u32,        // 0x70 (112)
    pub endian_tag: u32,         // 0x12345678
    pub link_size: u32,
    pub link_off: u32,
    pub map_off: u32,
    pub string_ids_size: u32,
    pub string_ids_off: u32,
    pub type_ids_size: u32,
    pub type_ids_off: u32,
    pub proto_ids_size: u32,
    pub proto_ids_off: u32,
    pub field_ids_size: u32,
    pub field_ids_off: u32,
    pub method_ids_size: u32,
    pub method_ids_off: u32,
    pub class_defs_size: u32,
    pub class_defs_off: u32,
    pub data_size: u32,
    pub data_off: u32,
    // Parsed from map list (DEX 038+):
    pub call_site_ids_size: u32,
    pub call_site_ids_off: u32,
    pub method_handle_ids_size: u32,
    pub method_handle_ids_off: u32,
}
```

### Header Field Comparison

| Offset | Size | JADX Field | Dexterity Field |
|--------|------|------------|-----------------|
| 0x00 | 4 | `magic` | `magic` |
| 0x04 | 3 | `version` | `version` |
| 0x08 | 4 | `checksum` | `checksum` |
| 0x0C | 20 | `signature` | `signature` |
| 0x20 | 4 | `fileSize` | `file_size` |
| 0x24 | 4 | `headerSize` | `header_size` |
| 0x28 | 4 | `endianTag` | `endian_tag` |
| 0x2C | 4 | (skipped) | `link_size` |
| 0x30 | 4 | (skipped) | `link_off` |
| 0x34 | 4 | `mapOff` | `map_off` |
| 0x38 | 4 | `stringIdsSize` | `string_ids_size` |
| 0x3C | 4 | `stringIdsOff` | `string_ids_off` |
| 0x40 | 4 | `typeIdsSize` | `type_ids_size` |
| 0x44 | 4 | `typeIdsOff` | `type_ids_off` |
| 0x48 | 4 | `protoIdsSize` | `proto_ids_size` |
| 0x4C | 4 | `protoIdsOff` | `proto_ids_off` |
| 0x50 | 4 | `fieldIdsSize` | `field_ids_size` |
| 0x54 | 4 | `fieldIdsOff` | `field_ids_off` |
| 0x58 | 4 | `methodIdsSize` | `method_ids_size` |
| 0x5C | 4 | `methodIdsOff` | `method_ids_off` |
| 0x60 | 4 | `classDefsSize` | `class_defs_size` |
| 0x64 | 4 | `classDefsOff` | `class_defs_off` |
| 0x68 | 4 | (implicit) | `data_size` |
| 0x6C | 4 | (implicit) | `data_off` |

---

## Section Reader

### JADX SectionReader

```java
// SectionReader.java - binary reader with position tracking
public class SectionReader {
    private final ByteBuffer buf;
    private int offset;

    // Position management
    public int pos(int pos);           // Relative to section start
    public int absPos(int pos);        // Absolute file position
    public void shiftOffset(int shift);

    // Reading primitives
    public int readInt();              // Little-endian 32-bit
    public int readUShort();           // Unsigned 16-bit
    public int readUByte();            // Unsigned 8-bit
    public int readUleb128();          // Unsigned LEB128
    public int readLeb128();           // Signed LEB128

    // Pool lookups (cached)
    public String getString(int idx);
    public String getType(int idx);
    public void initMethodRef(DexMethodRef mthRef, int mthIdx);
}
```

### Dexterity DexReader

```rust
// reader.rs - main parser with concurrent string caching
pub struct DexReader {
    data: DexData,                       // Owned, borrowed, or mmap'd
    header: DexHeader,
    string_cache: DashMap<u32, Arc<str>>, // Lock-free concurrent cache
}

impl DexReader {
    // Construction
    pub fn from_file(path: &Path) -> Result<Self>;
    pub fn from_bytes(bytes: Vec<u8>) -> Result<Self>;
    pub fn from_slice(bytes: &[u8]) -> Result<Self>;

    // Pool access (cached)
    pub fn get_string(&self, idx: u32) -> Result<Arc<str>>;
    pub fn get_type(&self, idx: u32) -> Result<Arc<str>>;

    // Section access
    pub fn class_defs(&self) -> impl Iterator<Item = ClassDef>;
    pub fn get_proto(&self, idx: u32) -> Result<ProtoId>;
    pub fn get_field(&self, idx: u32) -> Result<FieldId>;
    pub fn get_method(&self, idx: u32) -> Result<MethodId>;
}
```

**Key Difference:** Dexterity uses `DashMap` for lock-free concurrent string caching, enabling safe parallel access. JADX caches at the section reader level.

---

## String/Type Pools

### JADX String Pool

```java
// In SectionReader - lazy string loading
public String getString(int idx) {
    if (idx < 0 || idx >= header.getStringIdsSize()) {
        return null;
    }
    // Position to string_ids[idx], read offset, read MUTF-8
    int off = absPos(header.getStringIdsOff() + idx * 4);
    buf.position(off);
    int stringOff = buf.getInt();
    // Read ULEB128 length + MUTF-8 data
    return MUtf8.decode(buf, stringOff);
}
```

### Dexterity String Pool

```rust
// reader.rs - cached string access
pub fn get_string(&self, idx: u32) -> Result<Arc<str>> {
    // Check cache first (DashMap is lock-free)
    if let Some(s) = self.string_cache.get(&idx) {
        return Ok(Arc::clone(&s));
    }

    // Read string_id offset
    let off = self.header.string_ids_off + idx * 4;
    let string_off = self.read_u32_at(off)?;

    // Decode MUTF-8 string
    let s = decode_mutf8(&self.data[string_off..])?;
    let arc: Arc<str> = s.into();

    // Cache and return
    self.string_cache.insert(idx, Arc::clone(&arc));
    Ok(arc)
}
```

**Key Difference:** Dexterity returns `Arc<str>` for zero-copy sharing across threads.

---

## Class Definition (32 bytes)

### JADX DexClassData

```java
// DexClassData.java
public class DexClassData implements IClassData {
    // 32 bytes from DEX file:
    private final int classIdx;       // type_ids index
    private final int accessFlags;
    private final int superclassIdx;  // type_ids index (NO_INDEX = 0xFFFFFFFF)
    private final int interfacesOff;  // offset to type_list
    private final int sourceFileIdx;  // string_ids index
    private final int annotationsOff;
    private final int classDataOff;
    private final int staticValuesOff;

    // Interface methods
    public String getType();
    public String getSuperType();
    public List<String> getInterfacesTypes();
    public void visitFieldsAndMethods(Consumer<IFieldData>, Consumer<IMethodData>);
}
```

### Dexterity ClassDef

```rust
// sections/class_def.rs
pub struct ClassDef<'a> {
    reader: &'a DexReader,
    offset: u32,
    // Parsed from 32 bytes:
    pub class_idx: u32,
    pub access_flags: u32,
    pub superclass_idx: u32,      // NO_INDEX = 0xFFFFFFFF
    pub interfaces_off: u32,
    pub source_file_idx: u32,
    pub annotations_off: u32,
    pub class_data_off: u32,
    pub static_values_off: u32,
}

impl<'a> ClassDef<'a> {
    pub fn class_type(&self) -> Result<Arc<str>>;
    pub fn superclass(&self) -> Result<Option<Arc<str>>>;
    pub fn interfaces(&self) -> Result<Vec<Arc<str>>>;
    pub fn source_file(&self) -> Result<Option<Arc<str>>>;
    pub fn class_data(&self) -> Result<Option<ClassData>>;
    pub fn static_values(&self) -> Result<Vec<EncodedValue>>;
    pub fn annotations(&self) -> Result<ClassAnnotations>;
}
```

### Class Data (Variable-Length)

```
// Encoded with ULEB128
static_fields_size: uleb128
instance_fields_size: uleb128
direct_methods_size: uleb128
virtual_methods_size: uleb128
static_fields: [EncodedField; static_fields_size]
instance_fields: [EncodedField; instance_fields_size]
direct_methods: [EncodedMethod; direct_methods_size]
virtual_methods: [EncodedMethod; virtual_methods_size]
```

### JADX ClassData Iteration

```java
// Uses visitor pattern
classData.visitFieldsAndMethods(
    field -> { /* process field */ },
    method -> { /* process method */ }
);
```

### Dexterity ClassData Iteration

```rust
pub struct ClassData<'a> {
    pub static_fields_count: u32,
    pub instance_fields_count: u32,
    pub direct_methods_count: u32,
    pub virtual_methods_count: u32,
    // Internal iterators
}

impl<'a> ClassData<'a> {
    pub fn static_fields(&self) -> impl Iterator<Item = EncodedField>;
    pub fn instance_fields(&self) -> impl Iterator<Item = EncodedField>;
    pub fn direct_methods(&self) -> impl Iterator<Item = EncodedMethod>;
    pub fn virtual_methods(&self) -> impl Iterator<Item = EncodedMethod>;
}
```

---

## Field ID (8 bytes)

### JADX DexFieldData

```java
// DexFieldData.java
public class DexFieldData implements IFieldData {
    private final int classIdx;   // u16 - defining class
    private final int typeIdx;    // u16 - field type
    private final int nameIdx;    // u32 - field name string
    private int accessFlags;      // from class_data

    public String getParentClassType();
    public String getType();
    public String getName();
}
```

### Dexterity FieldId

```rust
// sections/field_id.rs
pub struct FieldId<'a> {
    reader: &'a DexReader,
    pub class_idx: u16,
    pub type_idx: u16,
    pub name_idx: u32,
}

impl<'a> FieldId<'a> {
    pub fn class_type(&self) -> Result<Arc<str>>;
    pub fn field_type(&self) -> Result<Arc<str>>;
    pub fn name(&self) -> Result<Arc<str>>;
}
```

---

## Method ID (8 bytes)

### JADX DexMethodRef

```java
// DexMethodRef.java
public class DexMethodRef implements IMethodRef {
    private final int classIdx;   // u16
    private final int protoIdx;   // u16
    private final int nameIdx;    // u32

    // Lazy loading
    private String name;
    private String parentClassType;
    private String returnType;
    private List<String> argTypes;

    public void load();  // Populates fields on demand
}
```

### Dexterity MethodId

```rust
// sections/method_id.rs
pub struct MethodId<'a> {
    reader: &'a DexReader,
    pub class_idx: u16,
    pub proto_idx: u16,
    pub name_idx: u32,
}

impl<'a> MethodId<'a> {
    pub fn class_type(&self) -> Result<Arc<str>>;
    pub fn name(&self) -> Result<Arc<str>>;
    pub fn proto(&self) -> Result<ProtoId>;
    pub fn return_type(&self) -> Result<Arc<str>>;
    pub fn param_types(&self) -> Result<Vec<Arc<str>>>;
}
```

---

## Proto ID (12 bytes)

### JADX DexMethodProto

```java
// DexMethodProto.java
public class DexMethodProto {
    private final int shortyIdx;      // u32 - shorty string
    private final int returnTypeIdx;  // u32 - type index
    private final int parametersOff;  // u32 - type_list offset

    public List<String> getArgTypes();
    public String getReturnType();
}
```

### Dexterity ProtoId

```rust
// sections/proto_id.rs
pub struct ProtoId<'a> {
    reader: &'a DexReader,
    pub shorty_idx: u32,
    pub return_type_idx: u32,
    pub parameters_off: u32,
}

impl<'a> ProtoId<'a> {
    pub fn shorty(&self) -> Result<Arc<str>>;
    pub fn return_type(&self) -> Result<Arc<str>>;
    pub fn param_types(&self) -> Result<Vec<Arc<str>>>;
}
```

---

## Bytecode / Code Item

### JADX DexCodeReader

```java
// DexCodeReader.java
public class DexCodeReader implements ICodeReader {
    private final int registersCount;
    private final int insSize;        // Incoming args
    private final int outsSize;       // Outgoing args
    private final int triesCount;
    private final int debugInfoOff;
    private final int insnsCount;     // In 16-bit units

    public int getRegistersCount();
    public int getUnitsCount();
    public void visitInstructions(InsnConsumer consumer);
    public ITryData[] getTries();
    public IDebugInfo getDebugInfo();
}
```

### Dexterity CodeItem

```rust
// sections/code_item.rs
pub struct CodeItem<'a> {
    reader: &'a DexReader,
    pub registers_size: u16,
    pub ins_size: u16,
    pub outs_size: u16,
    pub tries_size: u16,
    pub debug_info_off: u32,
    pub insns_size: u32,
    insns_data: &'a [u8],  // Zero-copy slice
}

impl<'a> CodeItem<'a> {
    pub fn instructions(&self) -> &[u16];  // Zero-copy
    pub fn decode_instructions(&self) -> Vec<DecodedInsn>;
    pub fn try_items(&self) -> Vec<TryItem>;
    pub fn catch_handlers(&self) -> Vec<CatchHandler>;
    pub fn debug_info(&self) -> Option<DebugInfo>;
}
```

### Code Item Layout

```
Offset  Size  Field
0x00    2     registers_size
0x02    2     ins_size
0x04    2     outs_size
0x06    2     tries_size
0x08    4     debug_info_off
0x0C    4     insns_size (in 16-bit units)
0x10    var   insns[insns_size] (16-bit array)
        2     padding (if tries_size > 0 && insns_size is odd)
        var   tries[tries_size] (8 bytes each)
        var   encoded_catch_handler_list
```

---

## Instruction Opcodes (256)

### JADX DexOpcodes

```java
// DexOpcodes.java - static constants
public static final int NOP = 0x00;
public static final int MOVE = 0x01;
public static final int MOVE_FROM16 = 0x02;
// ... 256 opcodes total
public static final int CONST_METHOD_HANDLE = 0xFE;
public static final int CONST_METHOD_TYPE = 0xFF;
```

### Dexterity Opcode Enum

```rust
// insns/opcode.rs
#[repr(u8)]
pub enum Opcode {
    Nop = 0x00,
    Move = 0x01,
    MoveFrom16 = 0x02,
    Move16 = 0x03,
    MoveWide = 0x04,
    // ... 256 variants
    ConstMethodHandle = 0xFE,
    ConstMethodType = 0xFF,
}

impl Opcode {
    pub fn from_u8(byte: u8) -> Self;
    pub fn format(&self) -> InsnFormat;
}
```

### Selected Opcode Mapping

| Value | JADX Name | Dexterity Variant | Format |
|-------|-----------|-------------------|--------|
| 0x00 | `NOP` | `Nop` | 10x |
| 0x01 | `MOVE` | `Move` | 12x |
| 0x12 | `CONST_4` | `Const4` | 11n |
| 0x1A | `CONST_STRING` | `ConstString` | 21c |
| 0x1C | `CONST_CLASS` | `ConstClass` | 21c |
| 0x22 | `NEW_INSTANCE` | `NewInstance` | 21c |
| 0x2B | `PACKED_SWITCH` | `PackedSwitch` | 31t |
| 0x2C | `SPARSE_SWITCH` | `SparseSwitch` | 31t |
| 0x6E | `INVOKE_VIRTUAL` | `InvokeVirtual` | 35c |
| 0x71 | `INVOKE_STATIC` | `InvokeStatic` | 35c |
| 0xFA | `INVOKE_POLYMORPHIC` | `InvokePolymorphic` | 45cc |
| 0xFC | `INVOKE_CUSTOM` | `InvokeCustom` | 35c |

---

## Instruction Formats (23)

### JADX DexInsnFormat

```java
// DexInsnFormat.java
public enum DexInsnFormat {
    FORMAT_10x(1, 0),   // op
    FORMAT_12x(1, 2),   // op vA, vB
    FORMAT_11n(1, 1),   // op vA, #+B
    FORMAT_11x(1, 1),   // op vAA
    FORMAT_10t(1, 0),   // op +AA
    FORMAT_20t(2, 0),   // op +AAAA
    FORMAT_22x(2, 2),   // op vAA, vBBBB
    FORMAT_21t(2, 1),   // op vAA, +BBBB
    FORMAT_21s(2, 1),   // op vAA, #+BBBB
    FORMAT_21h(2, 1),   // op vAA, #+BBBB0000
    FORMAT_21c(2, 1),   // op vAA, type/string@BBBB
    FORMAT_23x(2, 3),   // op vAA, vBB, vCC
    FORMAT_22b(2, 2),   // op vAA, vBB, #+CC
    FORMAT_22t(2, 2),   // op vA, vB, +CCCC
    FORMAT_22s(2, 2),   // op vA, vB, #+CCCC
    FORMAT_22c(2, 2),   // op vA, vB, type/field@CCCC
    FORMAT_30t(3, 0),   // op +AAAAAAAA
    FORMAT_32x(3, 2),   // op vAAAA, vBBBB
    FORMAT_31i(3, 1),   // op vAA, #+BBBBBBBB
    FORMAT_31t(3, 1),   // op vAA, +BBBBBBBB
    FORMAT_31c(3, 1),   // op vAA, string@BBBBBBBB
    FORMAT_35c(3, 5),   // op {vC,vD,vE,vF,vG}, thing@BBBB
    FORMAT_3rc(3, 0),   // op {vCCCC..vNNNN}, thing@BBBB
    FORMAT_45cc(4, 5),  // invoke-polymorphic
    FORMAT_4rcc(4, 0),  // invoke-polymorphic/range
    FORMAT_51l(5, 1);   // op vAA, #+BBBBBBBBBBBBBBBB

    private final int size;      // In 16-bit code units
    private final int regsCount; // Max registers
}
```

### Dexterity InsnFormat

```rust
// insns/format.rs
#[derive(Debug, Clone, Copy)]
pub enum InsnFormat {
    F10x, F12x, F11n, F11x, F10t,
    F20t, F22x, F21t, F21s, F21h, F21c,
    F23x, F22b, F22t, F22s, F22c,
    F30t, F32x, F31i, F31t, F31c,
    F35c, F3rc,
    F45cc, F4rcc,
    F51l,
}

impl InsnFormat {
    pub fn size(&self) -> u8 {
        match self {
            F10x | F12x | F11n | F11x | F10t => 1,
            F20t | F22x | F21t | F21s | F21h | F21c |
            F23x | F22b | F22t | F22s | F22c => 2,
            F30t | F32x | F31i | F31t | F31c | F35c | F3rc => 3,
            F45cc | F4rcc => 4,
            F51l => 5,
        }
    }
}
```

---

## Decoded Instruction

### JADX DexInsnData

```java
// Accessed via visitor pattern
public interface InsnConsumer {
    void accept(
        int opcode,
        int offset,
        int[] args,      // Register arguments
        long literal,    // Literal value
        int target,      // Branch target
        int index        // String/type/method/field index
    );
}
```

### Dexterity DecodedInsn

```rust
// insns/decoder.rs
pub struct DecodedInsn {
    pub opcode: Opcode,
    pub format: InsnFormat,
    pub offset: u32,         // Address in code units
    pub size: u8,            // Size in code units
    pub regs: [u16; 5],      // Up to 5 register operands
    pub reg_count: u8,
    pub literal: i64,        // For const instructions
    pub index: u32,          // Pool index
    pub target: i32,         // Signed branch offset
}

impl DecodedInsn {
    pub fn is_branch(&self) -> bool;
    pub fn is_return(&self) -> bool;
    pub fn is_throw(&self) -> bool;
    pub fn is_switch(&self) -> bool;
    pub fn branch_target(&self) -> Option<u32>;
}
```

---

## Variable-Length Encoding

### LEB128

**JADX Leb128.java:**
```java
public static int readUnsignedLeb128(ByteBuffer buf) {
    int result = 0;
    int shift = 0;
    while (true) {
        int b = buf.get() & 0xFF;
        result |= (b & 0x7F) << shift;
        if ((b & 0x80) == 0) break;
        shift += 7;
    }
    return result;
}

public static int readSignedLeb128(ByteBuffer buf) {
    int result = 0;
    int shift = 0;
    int b;
    do {
        b = buf.get() & 0xFF;
        result |= (b & 0x7F) << shift;
        shift += 7;
    } while ((b & 0x80) != 0);
    // Sign extend
    if (shift < 32 && (b & 0x40) != 0) {
        result |= -(1 << shift);
    }
    return result;
}
```

**Dexterity leb128.rs:**
```rust
pub fn read_uleb128(data: &[u8], pos: &mut usize) -> Result<u32> {
    let mut result: u32 = 0;
    let mut shift = 0;
    loop {
        let byte = data[*pos];
        *pos += 1;
        result |= ((byte & 0x7F) as u32) << shift;
        if byte & 0x80 == 0 { break; }
        shift += 7;
        if shift > 35 { return Err(Leb128Overflow); }
    }
    Ok(result)
}

pub fn read_sleb128(data: &[u8], pos: &mut usize) -> Result<i32> {
    let mut result: i32 = 0;
    let mut shift = 0;
    let mut byte;
    loop {
        byte = data[*pos];
        *pos += 1;
        result |= ((byte & 0x7F) as i32) << shift;
        shift += 7;
        if byte & 0x80 == 0 { break; }
    }
    // Sign extend
    if shift < 32 && (byte & 0x40) != 0 {
        result |= !0 << shift;
    }
    Ok(result)
}

// ULEB128p1: value + 1 encoded, used for optional indices
pub fn read_uleb128p1(data: &[u8], pos: &mut usize) -> Result<Option<u32>> {
    let val = read_uleb128(data, pos)?;
    if val == 0 { Ok(None) } else { Ok(Some(val - 1)) }
}
```

### MUTF-8 (Modified UTF-8)

**JADX MUtf8.java:**
```java
public static String decode(ByteBuffer buf, int offset) {
    buf.position(offset);
    int len = readUleb128(buf);
    byte[] bytes = new byte[len];
    buf.get(bytes);
    // Decode modified UTF-8 (null encoded as 0xC0 0x80)
    return decodeModifiedUtf8(bytes);
}
```

**Dexterity mutf8.rs:**
```rust
pub fn decode_mutf8(data: &[u8]) -> Result<String> {
    let mut result = String::new();
    let mut i = 0;

    // Fast path: process ASCII bytes in bulk (SIMD-like)
    while i + 8 <= data.len() {
        let chunk = &data[i..i+8];
        if chunk.iter().all(|&b| b != 0 && b < 0x80) {
            // All ASCII - fast append
            result.push_str(std::str::from_utf8(chunk)?);
            i += 8;
            continue;
        }
        break;  // Fall back to byte-by-byte
    }

    while i < data.len() && data[i] != 0 {
        let b = data[i];
        if b < 0x80 {
            result.push(b as char);
            i += 1;
        } else if b & 0xE0 == 0xC0 {
            // 2-byte sequence (includes null encoding 0xC0 0x80)
            let c = ((b & 0x1F) as u32) << 6 | (data[i+1] & 0x3F) as u32;
            result.push(char::from_u32(c).unwrap_or('\u{FFFD}'));
            i += 2;
        } else if b & 0xF0 == 0xE0 {
            // 3-byte sequence
            let c = ((b & 0x0F) as u32) << 12
                  | ((data[i+1] & 0x3F) as u32) << 6
                  | (data[i+2] & 0x3F) as u32;
            result.push(char::from_u32(c).unwrap_or('\u{FFFD}'));
            i += 3;
        }
        // Handle surrogate pairs for supplementary characters
    }
    Ok(result)
}
```

---

## Exception Handling

### Try Item (8 bytes)

| Offset | Size | Field |
|--------|------|-------|
| 0x00 | 4 | start_addr (code units) |
| 0x04 | 2 | insn_count (code units) |
| 0x06 | 2 | handler_off (into catch handler list) |

### JADX Exception Handling

```java
// In DexCodeReader
public ITryData[] getTries() {
    // Parse try_item array and encoded_catch_handler_list
}
```

### Dexterity Exception Handling

```rust
// sections/code_item.rs
pub struct TryItem {
    pub start_addr: u32,
    pub insn_count: u16,
    pub handler_off: u16,
}

pub struct CatchHandler {
    pub handlers: Vec<(u32, u32)>,  // (type_idx, handler_addr)
    pub catch_all_addr: Option<u32>,
}
```

---

## Debug Info

### Debug Bytecode Opcodes

| Value | Name | Description |
|-------|------|-------------|
| 0x00 | DBG_END_SEQUENCE | End debug info |
| 0x01 | DBG_ADVANCE_PC | Advance PC by uleb128 |
| 0x02 | DBG_ADVANCE_LINE | Advance line by sleb128 |
| 0x03 | DBG_START_LOCAL | Local var starts (reg, name, type) |
| 0x04 | DBG_START_LOCAL_EXTENDED | + signature |
| 0x05 | DBG_END_LOCAL | Local var ends |
| 0x06 | DBG_RESTART_LOCAL | Restart local at current PC |
| 0x07 | DBG_SET_PROLOGUE_END | Prologue ends |
| 0x08 | DBG_SET_EPILOGUE_BEGIN | Epilogue begins |
| 0x09 | DBG_SET_FILE | Set source file |
| 0x0A-0xFF | Special | line_delta = (opcode - 10) % 15 - 4; addr_delta = (opcode - 10) / 15 |

### JADX Debug Info

```java
// IDebugInfo interface
public interface IDebugInfo {
    List<? extends ILocalVar> getLocalVars();
    int[] getSourceLineMapping();
}
```

### Dexterity Debug Info

```rust
pub struct DebugInfo {
    pub line_start: u32,
    pub parameter_names: Vec<Option<Arc<str>>>,
    pub positions: Vec<(u32, u32)>,  // (address, line)
    pub locals: Vec<LocalVariable>,
}

pub struct LocalVariable {
    pub name: Arc<str>,
    pub type_desc: Arc<str>,
    pub signature: Option<Arc<str>>,
    pub register: u16,
    pub start_addr: u32,
    pub end_addr: u32,
}
```

---

## Annotations

### Annotation Directory Item

```
class_annotations_off: u32
fields_size: u32
methods_size: u32
parameters_size: u32
field_annotations[fields_size]: (field_idx, annotations_off)
method_annotations[methods_size]: (method_idx, annotations_off)
parameter_annotations[parameters_size]: (method_idx, annotations_off)
```

### JADX AnnotationsParser

```java
// AnnotationsParser.java
public void readClassAnnotations(int off);
public Map<Integer, Integer> readFieldsAnnotationOffsetMap();
public Map<Integer, Integer> readMethodsAnnotationOffsetMap();
public List<IAnnotation> readAnnotationList(int off);
```

### Dexterity Annotations

```rust
// sections/class_def.rs
pub struct ClassAnnotations {
    pub class_annotations: Vec<Annotation>,
    pub field_annotations: HashMap<u32, Vec<Annotation>>,
    pub method_annotations: HashMap<u32, Vec<Annotation>>,
    pub parameter_annotations: HashMap<u32, Vec<Vec<Annotation>>>,
}

pub struct Annotation {
    pub visibility: u8,  // BUILD=0, RUNTIME=1, SYSTEM=2
    pub type_idx: u32,
    pub elements: Vec<AnnotationElement>,
}
```

---

## Encoded Values (19 Types)

| Type | Value | Description |
|------|-------|-------------|
| VALUE_BYTE | 0x00 | Signed 8-bit |
| VALUE_SHORT | 0x02 | Signed 16-bit |
| VALUE_CHAR | 0x03 | Unsigned 16-bit |
| VALUE_INT | 0x04 | Signed 32-bit |
| VALUE_LONG | 0x06 | Signed 64-bit |
| VALUE_FLOAT | 0x10 | 32-bit float |
| VALUE_DOUBLE | 0x11 | 64-bit double |
| VALUE_METHOD_TYPE | 0x15 | Proto index |
| VALUE_METHOD_HANDLE | 0x16 | Method handle index |
| VALUE_STRING | 0x17 | String index |
| VALUE_TYPE | 0x18 | Type index |
| VALUE_FIELD | 0x19 | Field index |
| VALUE_METHOD | 0x1A | Method index |
| VALUE_ENUM | 0x1B | Field index (enum constant) |
| VALUE_ARRAY | 0x1C | Encoded array |
| VALUE_ANNOTATION | 0x1D | Encoded annotation |
| VALUE_NULL | 0x1E | Null reference |
| VALUE_BOOLEAN | 0x1F | Boolean (0=false, 1=true) |

### Dexterity EncodedValue

```rust
// sections/encoded_value.rs
pub enum EncodedValue {
    Byte(i8),
    Short(i16),
    Char(u16),
    Int(i32),
    Long(i64),
    Float(f32),
    Double(f64),
    MethodType(u32),
    MethodHandle(u32),
    String(Arc<str>),
    Type(Arc<str>),
    Field(u32),
    Method(u32),
    Enum(u32),
    Array(Vec<EncodedValue>),
    Annotation(Annotation),
    Null,
    Boolean(bool),
}
```

---

## Method Handles (DEX 038+)

### Method Handle Types

| Type | Value | Target |
|------|-------|--------|
| STATIC_PUT | 0x00 | Field |
| STATIC_GET | 0x01 | Field |
| INSTANCE_PUT | 0x02 | Field |
| INSTANCE_GET | 0x03 | Field |
| INVOKE_STATIC | 0x04 | Method |
| INVOKE_INSTANCE | 0x05 | Method |
| INVOKE_CONSTRUCTOR | 0x06 | Method |
| INVOKE_DIRECT | 0x07 | Method |
| INVOKE_INTERFACE | 0x08 | Method |

### JADX DexMethodHandle

```java
// DexMethodHandle.java
public class DexMethodHandle implements IMethodHandle {
    private final int type;        // 0-8
    private final int fieldOrMethodId;
}
```

### Dexterity MethodHandle

```rust
// sections/method_handle.rs
pub enum MethodHandleType {
    StaticPut = 0x00,
    StaticGet = 0x01,
    InstancePut = 0x02,
    InstanceGet = 0x03,
    InvokeStatic = 0x04,
    InvokeInstance = 0x05,
    InvokeConstructor = 0x06,
    InvokeDirect = 0x07,
    InvokeInterface = 0x08,
}

pub struct MethodHandle<'a> {
    reader: &'a DexReader,
    pub handle_type: MethodHandleType,
    pub field_or_method_id: u16,
}
```

---

## DEX Version Comparison

| Version | API | Features |
|---------|-----|----------|
| 035 | 1-23 | Base DEX format |
| 037 | 24-25 | Default methods |
| 038 | 26-27 | Method handles, invoke-custom |
| 039 | 28-29 | HIDDENAPI flags |
| 040 | 30-33 | Sealed classes |
| 041 | 34+ | Multi-DEX in single file |

---

## File Locations

### JADX (Java)

```
jadx-fast/jadx-plugins/jadx-dex-input/src/main/java/jadx/plugins/input/dex/
├── DexInputPlugin.java
├── DexFileLoader.java
├── DexReader.java
├── insns/
│   ├── DexOpcodes.java
│   ├── DexInsnFormat.java
│   └── DexInsnInfo.java
├── sections/
│   ├── DexHeader.java
│   ├── DexConsts.java
│   ├── SectionReader.java
│   ├── DexClassData.java
│   ├── DexFieldData.java
│   ├── DexMethodData.java
│   ├── DexMethodRef.java
│   ├── DexMethodProto.java
│   ├── DexCodeReader.java
│   └── DexMethodHandle.java
├── sections/annotations/
│   ├── AnnotationsParser.java
│   └── EncodedValueParser.java
└── utils/
    ├── Leb128.java
    └── MUtf8.java
```

### Dexterity (Rust)

```
crates/dexterity-dex/src/
├── lib.rs
├── error.rs
├── consts.rs
├── header.rs
├── reader.rs
├── sections/
│   ├── mod.rs
│   ├── class_def.rs
│   ├── field_id.rs
│   ├── method_id.rs
│   ├── proto_id.rs
│   ├── code_item.rs
│   ├── encoded_value.rs
│   └── method_handle.rs
├── insns/
│   ├── mod.rs
│   ├── opcode.rs
│   ├── format.rs
│   └── decoder.rs
└── utils/
    ├── mod.rs
    ├── leb128.rs
    └── mutf8.rs
```

---

**Last Updated:** December 2025
