//! Smart Naming System for enhanced deobfuscation
//!
//! This module provides intelligent naming beyond JADX's basic aliasing:
//! - Word dictionary system for readable compound names
//! - Type-based naming hints (Map -> xxxMap, Handler -> xxxHandler)
//! - Pattern detection (Singleton, Builder, Factory, etc.)
//! - Android component detection (Activity, Fragment, Service, etc.)
//! - Semantic analysis from method signatures and field usage
//!
//! The SmartAliasProvider implements the AliasProvider trait and can be
//! used as a drop-in replacement for DeobfAliasProvider.

pub mod dictionary;
pub mod type_hints;
pub mod patterns;
pub mod android;
pub mod method_analysis;
pub mod field_analysis;
pub mod provider;

pub use dictionary::{Dictionary, DomainVocabulary};
pub use type_hints::{TypeHintsEngine, TypeHints, TypePattern};
pub use patterns::{PatternDetector, DetectedPattern};
pub use android::{AndroidComponentDetector, AndroidComponent};
pub use method_analysis::{MethodSignatureAnalyzer, MethodAnalysis, MethodPattern};
pub use field_analysis::{FieldAccessAnalyzer, FieldAnalysis, FieldPattern};
pub use provider::SmartAliasProvider;
