//! Source file-based class renaming
//!
//! Ported from jadx-core/src/main/java/jadx/core/dex/visitors/rename/SourceFileRename.java
//!
//! This module renames classes based on their SourceFile attribute. When a class
//! has a source file like "MyClass.java" but is obfuscated to "a", we can use
//! the source file name as a better alias.

use std::collections::HashMap;

use dexterity_ir::ClassData;

use crate::name_mapper::NameMapper;

/// Strategy for using source file names as class aliases
#[derive(Debug, Clone, Copy, PartialEq, Eq, Default)]
pub enum UseSourceNameAsClassNameAlias {
    /// Always use source file name as alias
    Always,
    /// Use source file name only if it's "better" than current name
    #[default]
    IfBetter,
    /// Never use source file name
    Never,
}

/// Apply source file renames to classes
///
/// # Arguments
/// * `classes` - Mutable slice of classes to rename
/// * `use_source_name` - Strategy for when to use source names
/// * `repeat_limit` - Maximum times an alias can be reused (default: 5)
///
/// # Example
/// ```ignore
/// apply_source_file_renames(&mut classes, UseSourceNameAsClassNameAlias::IfBetter, 5);
/// ```
pub fn apply_source_file_renames(
    classes: &mut [ClassData],
    use_source_name: UseSourceNameAsClassNameAlias,
    repeat_limit: usize,
) {
    if use_source_name == UseSourceNameAsClassNameAlias::Never {
        return;
    }
    if repeat_limit <= 1 {
        return;
    }

    // Track usage count of each alias (starting with existing short names)
    let mut alias_use_count: HashMap<String, usize> = HashMap::new();
    for cls in classes.iter() {
        let short_name = cls.simple_name().to_string();
        alias_use_count.insert(short_name, 1);
    }

    // Collect renames
    let mut renames: Vec<ClsRename> = Vec::new();
    for (idx, cls) in classes.iter().enumerate() {
        // Skip classes that already have an alias (JADX uses DONT_RENAME flag,
        // but checking for existing alias achieves the same result here)
        // Note: We still process classes with aliases later in apply_rename
        // to potentially upgrade to a "better" name

        if let Some(alias) = get_alias_from_source_file(cls) {
            let count = alias_use_count.entry(alias.clone()).or_insert(0);
            *count += 1;
            if *count < repeat_limit {
                renames.push(ClsRename {
                    class_idx: idx,
                    alias,
                    suffix: *count,
                });
            }
        }
    }

    // Apply renames
    for cls_rename in renames {
        let alias = &cls_rename.alias;
        if let Some(&count) = alias_use_count.get(alias) {
            if count < repeat_limit {
                let cls = &mut classes[cls_rename.class_idx];
                apply_rename(cls, cls_rename.build_alias(), use_source_name);
            }
        }
    }
}

/// Apply a rename to a class
fn apply_rename(cls: &mut ClassData, alias: String, use_source_name: UseSourceNameAsClassNameAlias) {
    if let Some(ref current_alias) = cls.alias {
        let better_name = get_better_name(current_alias, &alias, use_source_name);
        if better_name == *current_alias {
            return;
        }
    }
    cls.alias = Some(alias);
}

/// Get the "better" class name based on the strategy
fn get_better_name(
    current_name: &str,
    source_name: &str,
    use_source_name: UseSourceNameAsClassNameAlias,
) -> String {
    match use_source_name {
        UseSourceNameAsClassNameAlias::Always => source_name.to_string(),
        UseSourceNameAsClassNameAlias::IfBetter => get_better_class_name(source_name, current_name),
        UseSourceNameAsClassNameAlias::Never => current_name.to_string(),
    }
}

/// Compare two class names and return the "better" one
///
/// JADX Reference: jadx-core/src/main/java/jadx/core/utils/BetterName.java
/// Cloned from JADX's getBetterClassName/getBetterName methods exactly.
///
/// Prefers names with:
/// 1. Lower digit ratio (fewer numbers = less obfuscated)
/// 2. Longer length (if digit ratios are similar = more descriptive)
///
/// This helps choose the better source file name when multiple classes share
/// the same source file, or when comparing a class name to its source file name.
pub fn get_better_class_name(first: &str, second: &str) -> String {
    // JADX: if (Objects.equals(firstName, secondName)) { return firstName; }
    if first == second {
        return first.to_string();
    }

    // JADX: if (StringUtils.isEmpty(firstName) || StringUtils.isEmpty(secondName))
    if first.is_empty() || second.is_empty() {
        return if !first.is_empty() {
            first.to_string()
        } else {
            second.to_string()
        };
    }

    // JADX: final var firstResult = analyze(firstName);
    // JADX: final var secondResult = analyze(secondName);
    let first_analysis = analyze_name(first);
    let second_analysis = analyze_name(second);

    // JADX: private static final double TOLERANCE = 0.001;
    const TOLERANCE: f32 = 0.001;

    // JADX: if (firstResult.digitCount != 0 || secondResult.digitCount != 0)
    // Compare digit ratios
    if first_analysis.digit_count != 0 || second_analysis.digit_count != 0 {
        // JADX: final var firstRatio = (float) firstResult.digitCount / firstResult.length;
        let first_ratio = first_analysis.digit_count as f32 / first_analysis.length as f32;
        let second_ratio = second_analysis.digit_count as f32 / second_analysis.length as f32;

        // JADX: if (Math.abs(secondRatio - firstRatio) >= TOLERANCE)
        if (second_ratio - first_ratio).abs() >= TOLERANCE {
            // JADX: return firstRatio <= secondRatio ? firstName : secondName;
            return if first_ratio <= second_ratio {
                first.to_string()
            } else {
                second.to_string()
            };
        }
    }

    // JADX: return firstResult.length >= secondResult.length ? firstName : secondName;
    // Prefer longer names
    if first_analysis.length >= second_analysis.length {
        first.to_string()
    } else {
        second.to_string()
    }
}

/// Analysis result for a name
///
/// JADX Reference: BetterName.AnalyzeResult inner class
struct NameAnalysis {
    /// Total number of code points
    /// JADX: result.length++;
    length: usize,
    /// Count of digit code points
    /// JADX: if (Character.isDigit(cp)) { result.digitCount++; }
    digit_count: usize,
}

/// Analyze a name for length and digit count
///
/// JADX Reference: BetterName.analyze() lines 66-78
/// ```java
/// StringUtils.visitCodePoints(name, cp -> {
///     if (Character.isDigit(cp)) {
///         result.digitCount++;
///     }
///     result.length++;
/// });
/// ```
fn analyze_name(name: &str) -> NameAnalysis {
    let mut length = 0;
    let mut digit_count = 0;

    // JADX: StringUtils.visitCodePoints(name, cp -> { ... })
    // We iterate over chars (code points in Rust)
    for c in name.chars() {
        // JADX: if (Character.isDigit(cp))
        // Java's Character.isDigit() includes Unicode digits, but for practical
        // APK class names, ASCII digits are sufficient. Use is_numeric() for
        // stricter Unicode parity if needed.
        if c.is_numeric() {
            digit_count += 1;
        }
        length += 1;
    }

    NameAnalysis { length, digit_count }
}

/// Get alias from source file attribute
fn get_alias_from_source_file(cls: &ClassData) -> Option<String> {
    // Get source file attribute
    let source_file = cls.source_file.as_ref()?;

    // Skip inner classes
    if cls.parent_class.is_some() {
        return None;
    }

    // Remove .java/.kt suffix
    let mut name = source_file.as_str();
    if let Some(stripped) = name.strip_suffix(".java") {
        name = stripped;
    } else if let Some(stripped) = name.strip_suffix(".kt") {
        name = stripped;
    }

    // Validate it's a valid identifier
    if !NameMapper::is_valid_and_printable(name) {
        return None;
    }

    // Skip if same as current name
    if name == cls.simple_name() {
        return None;
    }

    Some(name.to_string())
}

/// Pending class rename
struct ClsRename {
    class_idx: usize,
    alias: String,
    suffix: usize,
}

impl ClsRename {
    /// Build the final alias with suffix if needed
    fn build_alias(&self) -> String {
        if self.suffix < 2 {
            self.alias.clone()
        } else {
            format!("{}{}", self.alias, self.suffix)
        }
    }
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn test_get_better_class_name() {
        // First is better (fewer digits)
        assert_eq!(get_better_class_name("Foo", "a2"), "Foo");
        assert_eq!(get_better_class_name("MyClass", "a1b2c3"), "MyClass");

        // First is better (longer, same digit ratio)
        assert_eq!(get_better_class_name("LongerName", "Short"), "LongerName");

        // Second is better (fewer digits)
        assert_eq!(get_better_class_name("a123", "Foo"), "Foo");

        // Equal names
        assert_eq!(get_better_class_name("Same", "Same"), "Same");

        // Empty handling
        assert_eq!(get_better_class_name("", "Foo"), "Foo");
        assert_eq!(get_better_class_name("Foo", ""), "Foo");
    }

    #[test]
    fn test_analyze_name() {
        let analysis = analyze_name("abc123");
        assert_eq!(analysis.length, 6);
        assert_eq!(analysis.digit_count, 3);

        let analysis = analyze_name("NoDigits");
        assert_eq!(analysis.length, 8);
        assert_eq!(analysis.digit_count, 0);
    }

    #[test]
    fn test_get_alias_from_source_file() {
        let mut cls = ClassData::new("Lcom/test/a;".to_string(), 0);
        cls.source_file = Some("MyClass.java".to_string());
        assert_eq!(get_alias_from_source_file(&cls), Some("MyClass".to_string()));

        // Kotlin file
        let mut cls = ClassData::new("Lcom/test/b;".to_string(), 0);
        cls.source_file = Some("KotlinClass.kt".to_string());
        assert_eq!(get_alias_from_source_file(&cls), Some("KotlinClass".to_string()));

        // Skip inner classes
        let mut cls = ClassData::new("Lcom/test/Outer$Inner;".to_string(), 0);
        cls.source_file = Some("Outer.java".to_string());
        cls.parent_class = Some("Lcom/test/Outer;".to_string());
        assert_eq!(get_alias_from_source_file(&cls), None);

        // Skip if name matches
        let mut cls = ClassData::new("Lcom/test/MyClass;".to_string(), 0);
        cls.source_file = Some("MyClass.java".to_string());
        assert_eq!(get_alias_from_source_file(&cls), None);

        // No source file
        let cls = ClassData::new("Lcom/test/c;".to_string(), 0);
        assert_eq!(get_alias_from_source_file(&cls), None);
    }

    #[test]
    fn test_apply_source_file_renames() {
        let mut classes = vec![
            ClassData::new("Lcom/test/a;".to_string(), 0),
            ClassData::new("Lcom/test/b;".to_string(), 0),
            ClassData::new("Lcom/test/c;".to_string(), 0),
        ];

        classes[0].source_file = Some("FirstClass.java".to_string());
        classes[1].source_file = Some("SecondClass.kt".to_string());
        classes[2].source_file = Some("FirstClass.java".to_string()); // Duplicate

        apply_source_file_renames(&mut classes, UseSourceNameAsClassNameAlias::Always, 5);

        assert_eq!(classes[0].alias, Some("FirstClass".to_string()));
        assert_eq!(classes[1].alias, Some("SecondClass".to_string()));
        assert_eq!(classes[2].alias, Some("FirstClass2".to_string())); // Suffixed
    }

    #[test]
    fn test_repeat_limit() {
        // JADX behavior: if total count of an alias >= repeatLimit, NONE are renamed
        // This prevents renaming when many classes share the same source file name

        // Test 1: Total count exceeds limit - none should be renamed
        let mut classes: Vec<_> = (0..10)
            .map(|i| {
                let mut cls = ClassData::new(format!("Lcom/test/{};", (b'a' + i as u8) as char), 0);
                cls.source_file = Some("SameName.java".to_string());
                cls
            })
            .collect();

        apply_source_file_renames(&mut classes, UseSourceNameAsClassNameAlias::Always, 3);

        // With 10 classes sharing "SameName.java" and repeatLimit=3,
        // the final count is 10, so 10 < 3 = false, NONE are renamed
        for cls in &classes {
            assert!(cls.alias.is_none(), "No classes should be renamed when total exceeds limit");
        }

        // Test 2: Total count equals limit - none should be renamed
        let mut classes: Vec<_> = (0..3)
            .map(|i| {
                let mut cls = ClassData::new(format!("Lcom/test/{};", (b'a' + i as u8) as char), 0);
                cls.source_file = Some("ThreeClasses.java".to_string());
                cls
            })
            .collect();

        apply_source_file_renames(&mut classes, UseSourceNameAsClassNameAlias::Always, 3);

        // With 3 classes and repeatLimit=3, final count = 3, so 3 < 3 = false
        for cls in &classes {
            assert!(cls.alias.is_none(), "No classes should be renamed when count equals limit");
        }

        // Test 3: Total count under limit - all should be renamed with suffixes
        let mut classes: Vec<_> = (0..2)
            .map(|i| {
                let mut cls = ClassData::new(format!("Lcom/test/{};", (b'a' + i as u8) as char), 0);
                cls.source_file = Some("TwoClasses.java".to_string());
                cls
            })
            .collect();

        apply_source_file_renames(&mut classes, UseSourceNameAsClassNameAlias::Always, 5);

        // With 2 classes and repeatLimit=5, final count = 2, so 2 < 5 = true
        assert_eq!(classes[0].alias, Some("TwoClasses".to_string()));
        assert_eq!(classes[1].alias, Some("TwoClasses2".to_string()));
    }

    #[test]
    fn test_never_strategy() {
        let mut classes = vec![ClassData::new("Lcom/test/a;".to_string(), 0)];
        classes[0].source_file = Some("MyClass.java".to_string());

        apply_source_file_renames(&mut classes, UseSourceNameAsClassNameAlias::Never, 5);

        assert!(classes[0].alias.is_none());
    }
}
