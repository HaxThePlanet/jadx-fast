# Memory Explosion FIX: Index-Based Instructions (Java JADX Pattern)

## Root Cause
Line 166 in block_split.rs: `Arc::new(Mutex::new(i.clone()))`
- Clones ENTIRE InsnNode for EACH instruction
- 10,000 instructions × ~200 bytes = 2MB clones per method
- × 58,000 methods = 116GB potential memory usage

## Java JADX Architecture
```java
ClassNode {
    List<InsnNode> instructions;  // All instructions in ONE list
}

BlockNode {
    int startOffset, endOffset;   // Reference by offset, not clone
}
```

Access: BlockNode uses startOffset/endOffset to find relevant instructions in ClassNode.instructions

## Rust Refactor (EXACT COPY of Java)
```rust
ClassData {
    all_instructions: Vec<InsnNode>,  // Already exists!
}

BasicBlock {
    id: u32,
    start_offset: u32,
    end_offset: u32,
    // Remove: instructions: Vec<Arc<Mutex<InsnNode>>>
    // Use: access instructions from ClassData by offset range
}
```

## Implementation Steps
1. Modify BasicBlock to remove `instructions` field
2. Add method: `fn get_instructions(&self, class_data: &ClassData) -> Vec<&InsnNode>`
3. Refactor all code that accesses `block.instructions` to use the new getter
4. Update split_blocks() to NOT clone instructions
5. Pass ClassData through entire pipeline (CFG, SSA, type_inference, codegen)
6. After codegen: `class_data.all_instructions.clear()` in unload()

## Expected Memory Reduction
- 10,000 instructions: 2MB clones → 0MB clones
- 58,000 methods: 116GB potential → ~20GB (actual instruction memory only)
- Single method: 3-5MB pipeline overhead → <1MB overhead

## Implementation Complexity
HIGH - touches:
- BasicBlock definition
- split_blocks()
- CFG, SSA, type_inference, codegen (all use block.instructions)
- All tests

## Time Estimate
8-12 hours to fully refactor and test

## PRIORITY: DO THIS FIRST
This is the ONLY way to fix the 50GB+ memory explosion.
Everything else is band-aids.
