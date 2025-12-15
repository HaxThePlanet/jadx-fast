# Decompilation Quality Status

This document outlines the current quality of decompilation for Rust JADX compared to Java JADX, highlighting key differences and areas for improvement.

## Java JADX (Target Quality)

Java JADX is considered the gold standard for Android decompilation. Its output typically features:

-   ✅ Full import statements with proper package resolution
-   ✅ Correct constructor initialization with actual values
-   ✅ Proper control flow with meaningful variable names (aVar, z5, etc.)
-   ✅ Type casts and annotations
-   ✅ Field rename comments (/* renamed from: S, reason: collision with root package name */)
-   ✅ JADX warning comments for type inference issues
-   ✅ Proper exception handling in method signatures
-   ✅ Anonymous inner class support

## Rust JADX (Current State)

The Rust JADX implementation is still under active development, and its decompilation output currently has several limitations compared to Java JADX:

-   ❌ No import statements (only package)
-   ❌ Completely broken constructor (nonsensical object creation)
-   ❌ Broken control flow logic (e.g., if (mainActivity == 0))
-   ❌ Generic variable names (v0, i, i2) everywhere
-   ❌ Missing type information and casts
-   ❌ No comments or warnings
-   ❌ Incorrect method logic throughout
