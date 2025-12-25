//! Integration tests for dexterity decompiler
//!
//! Run with: cargo test -p dexterity-cli --test integration_tests
//!
//! These tests compile Java source → DEX → decompile → assert on output.
//! They require javac and d8/dx (Android SDK) to be installed.
//!
//! If tools are not available, tests will be skipped gracefully.

// Include the test framework
mod integration_test_framework;

// Include integration test modules
mod integration;
