//! Integration tests for dexterity decompiler
//!
//! These tests compile Java source → DEX → decompile → assert on output.
//! They require javac and d8/dx (Android SDK) to be installed.
//!
//! If tools are not available, tests will be skipped gracefully.
//!
//! Test categories:
//! - arith: Arithmetic operations, increment/decrement
//! - arrays: Array operations
//! - conditions: If/else, ternary, boolean logic
//! - enums: Enum declarations and usage
//! - generics: Generic types
//! - inner: Inner classes
//! - loops: While, for, do-while loops
//! - switches: Switch statements
//! - trycatch: Try-catch-finally handling
//! - types: Type inference and casts
//! And more...

mod sample_tests;

// Ported tests from Java JADX integration test suite
mod android_tests;
mod annotations_tests;
mod arith_tests;
mod arrays_tests;
mod code_tests;
mod conditions_tests;
mod debuginfo_tests;
mod deobf_tests;
mod enums_tests;
mod fallback_tests;
mod generics_tests;
mod inline_tests;
mod inner_tests;
mod invoke_tests;
mod java8_tests;
mod jbc_tests;
mod loops_tests;
mod names_tests;
mod others_tests;
mod rename_tests;
mod special_tests;
mod switches_tests;
mod synchronize_tests;
mod trycatch_tests;
mod types_tests;
mod usethis_tests;
mod variables_tests;
