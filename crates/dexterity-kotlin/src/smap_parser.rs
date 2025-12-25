//! SMAP (Source Map) parser for JSR-045 format
//!
//! Cloned from JADX: jadx-plugins/jadx-kotlin-source-debug-extension/src/main/kotlin/jadx/plugins/kotlin/smap/utils/SMAPParser.kt
//!
//! Copyright 2010-2015 JetBrains s.r.o.
//! Licensed under the Apache License, Version 2.0
//!
//! The SMAP format is defined in JSR-045 (Debugging Support for Other Languages).
//! Format example:
//! ```text
//! SMAP
//! MyClass.kt
//! Kotlin
//! *S Kotlin
//! *F
//! + 1 MyClass.kt
//! com/example/MyClass.kt
//! *L
//! 1#1,10:1
//! *E
//! ```

use crate::smap_types::{
    FileMapping, SMAP,
    KOTLIN_STRATA_NAME, KOTLIN_DEBUG_STRATA_NAME,
    FILE_SECTION, LINE_SECTION, STRATA_SECTION, END_SECTION,
};
use std::collections::HashMap;

/// Parse SMAP from SourceDebugExtension annotation value
/// Returns None if parsing fails or input is empty
///
/// JADX Reference: SMAPParser.kt:24-30
pub fn parse_or_null(mapping_info: &str) -> Option<SMAP> {
    if mapping_info.is_empty() {
        return None;
    }

    // First parse KotlinDebug stratum (for call site information)
    let call_sites = parse_stratum(mapping_info, KOTLIN_DEBUG_STRATA_NAME, None);

    // Then parse Kotlin stratum with call site info
    parse_stratum(mapping_info, KOTLIN_STRATA_NAME, call_sites.as_ref())
}

/// Tokenizer for SMAP format that advances line by line
/// JADX Reference: SMAPParser.kt:32-67
struct SMAPTokenizer<'a> {
    text: &'a str,
    pos: usize,
    current_line: Option<&'a str>,
}

impl<'a> SMAPTokenizer<'a> {
    /// Create tokenizer and advance to the line after header_string
    /// JADX Reference: SMAPParser.kt:37-45
    fn new(text: &'a str, header_string: &str) -> Self {
        let mut tokenizer = Self {
            text,
            pos: 0,
            current_line: None,
        };

        // Advance to first line
        tokenizer.advance();

        // Skip until we find the header string
        while tokenizer.current_line.is_some() && tokenizer.current_line != Some(header_string) {
            tokenizer.advance();
        }

        // If we found the header, advance past it
        if tokenizer.current_line == Some(header_string) {
            tokenizer.advance();
        }

        tokenizer
    }

    /// Advance to next line
    /// JADX Reference: SMAPParser.kt:47-56
    fn advance(&mut self) {
        if self.pos >= self.text.len() {
            self.current_line = None;
            return;
        }

        let from_pos = self.pos;

        // Find end of line (stop at \n or \r)
        while self.pos < self.text.len() {
            let c = self.text.as_bytes()[self.pos];
            if c == b'\n' || c == b'\r' {
                break;
            }
            self.pos += 1;
        }

        self.current_line = Some(&self.text[from_pos..self.pos]);

        // Skip the newline character(s)
        if self.pos < self.text.len() {
            self.pos += 1;
            // Handle \r\n
            if self.pos < self.text.len() && self.text.as_bytes()[self.pos - 1] == b'\r'
                && self.text.as_bytes()[self.pos] == b'\n'
            {
                self.pos += 1;
            }
        }
    }
}

impl<'a> SMAPTokenizer<'a> {
    /// Check if there are more lines
    fn has_next(&self) -> bool {
        self.current_line.is_some()
    }
}

impl<'a> Iterator for SMAPTokenizer<'a> {
    type Item = &'a str;

    fn next(&mut self) -> Option<Self::Item> {
        let result = self.current_line?;
        self.advance();
        Some(result)
    }
}

/// Parse a single stratum from SMAP
/// JADX Reference: SMAPParser.kt:69-116
fn parse_stratum(mapping_info: &str, stratum: &str, call_sites: Option<&SMAP>) -> Option<SMAP> {
    let mut file_mappings: HashMap<i32, FileMapping> = HashMap::new();
    let header = format!("{} {}", STRATA_SECTION, stratum);
    let mut iterator = SMAPTokenizer::new(mapping_info, &header);

    // JSR-045 allows the line section to come before the file section,
    // but we don't generate SMAPs like this.
    // JADX Reference: SMAPParser.kt:72-73
    let first_line = iterator.next()?;
    if first_line != FILE_SECTION {
        return None;
    }

    // Parse file section (*F)
    // JADX Reference: SMAPParser.kt:75-86
    let mut file_index_counter = 0usize;
    loop {
        let line = match iterator.next() {
            Some(l) => l,
            None => break,
        };

        // Check for section transitions
        if line == LINE_SECTION {
            break;
        }
        if line == FILE_SECTION || line == END_SECTION || line.starts_with(STRATA_SECTION) {
            return None;
        }

        // Parse file entry
        // Format: "1 MyClass.kt" or "+ 1 MyClass.kt" (with path on next line)
        // JADX Reference: SMAPParser.kt:81-85
        let (has_path, index_and_name) = if line.starts_with("+ ") {
            (true, &line[2..])
        } else {
            (false, line)
        };

        let space_idx = index_and_name.find(' ')?;
        let file_index: i32 = index_and_name[..space_idx].parse().ok()?;
        let file_name = &index_and_name[space_idx + 1..];

        let path = if has_path {
            iterator.next()?.to_string()
        } else {
            file_name.to_string()
        };

        file_mappings.insert(
            file_index,
            FileMapping::new(file_name.to_string(), path, file_index_counter),
        );
        file_index_counter += 1;
    }

    // Parse line section (*L)
    // JADX Reference: SMAPParser.kt:88-113
    loop {
        let line = match iterator.next() {
            Some(l) => l,
            None => break,
        };

        // Check for section transitions
        if line == LINE_SECTION || line == FILE_SECTION {
            return None;
        }
        if line == END_SECTION || line.starts_with(STRATA_SECTION) {
            break;
        }

        // Parse line mapping
        // Format: <source>#<file>,<sourceRange>:<dest>,<destMultiplier>
        // Example: 1#1,10:1 means lines 1-10 of file 1 map to bytecode line 1
        // JADX Reference: SMAPParser.kt:94-112

        let file_separator = line.find('#')?;
        let dest_separator = line[file_separator..].find(':')? + file_separator;

        // Find sourceRange separator (comma between # and :)
        let source_range_separator = line[..dest_separator].find(',')
            .filter(|&idx| idx > file_separator)
            .unwrap_or(dest_separator);

        // Find destMultiplier separator (comma after :)
        let dest_multiplier_separator = line[dest_separator + 1..].find(',')
            .map(|idx| idx + dest_separator + 1)
            .unwrap_or(line.len());

        // Extract components
        let file_id: i32 = line[file_separator + 1..source_range_separator].parse().ok()?;
        let file = file_mappings.get_mut(&file_id)?;

        let source: i32 = line[..file_separator].parse().ok()?;
        let dest: i32 = line[dest_separator + 1..dest_multiplier_separator].parse().ok()?;

        // Determine range
        // JADX Reference: SMAPParser.kt:105-110
        let range: i32 = if dest_multiplier_separator != line.len() {
            // Has destMultiplier
            line[dest_multiplier_separator + 1..].parse().ok()?
        } else if source_range_separator != dest_separator {
            // Has sourceRange
            line[source_range_separator + 1..dest_separator].parse().ok()?
        } else {
            1
        };

        // Get call site from KotlinDebug stratum if available
        // JADX Reference: SMAPParser.kt:111-112
        let call_site = call_sites.and_then(|cs| {
            cs.find_range(dest).map(|(file, mapping)| {
                mapping.map_dest_to_source(mapping.dest, &file.name, &file.path)
            })
        });

        file.map_new_interval(source, dest, range, call_site);
    }

    // Build SMAP from file mappings (preserving order)
    // JADX Reference: SMAPParser.kt:115
    let mut files: Vec<_> = file_mappings.into_iter().collect();
    files.sort_by_key(|(idx, _)| *idx);
    let file_mappings: Vec<FileMapping> = files.into_iter().map(|(_, f)| f).collect();

    if file_mappings.is_empty() {
        return None;
    }

    Some(SMAP::new(file_mappings))
}

#[cfg(test)]
mod tests {
    use super::*;

    /// Basic SMAP format test
    #[test]
    fn test_parse_simple_smap() {
        let smap = r#"SMAP
MyClass.kt
Kotlin
*S Kotlin
*F
1 MyClass.kt
*L
1#1:1
*E
"#;
        let result = parse_or_null(smap);
        assert!(result.is_some());
        let smap = result.unwrap();
        assert_eq!(smap.file_mappings.len(), 1);
        assert_eq!(smap.file_mappings[0].name, "MyClass.kt");
        assert_eq!(smap.file_mappings[0].line_mappings.len(), 1);
    }

    /// Test SMAP with file path on separate line (+ prefix)
    #[test]
    fn test_parse_smap_with_path() {
        let smap = r#"SMAP
MyClass.kt
Kotlin
*S Kotlin
*F
+ 1 MyClass.kt
com/example/MyClass.kt
*L
1#1,10:1
*E
"#;
        let result = parse_or_null(smap);
        assert!(result.is_some());
        let smap = result.unwrap();
        assert_eq!(smap.file_mappings[0].name, "MyClass.kt");
        assert_eq!(smap.file_mappings[0].path, "com/example/MyClass.kt");
    }

    /// Test SMAP with multiple files
    #[test]
    fn test_parse_multifile_smap() {
        let smap = r#"SMAP
MultiFile.kt
Kotlin
*S Kotlin
*F
+ 1 File1.kt
com/example/File1.kt
+ 2 File2.kt
com/example/File2.kt
*L
1#1,5:1
1#2,3:10
*E
"#;
        let result = parse_or_null(smap);
        assert!(result.is_some());
        let smap = result.unwrap();
        assert_eq!(smap.file_mappings.len(), 2);
        assert_eq!(smap.file_mappings[0].name, "File1.kt");
        assert_eq!(smap.file_mappings[1].name, "File2.kt");
    }

    /// Test line mapping parsing with ranges
    #[test]
    fn test_parse_line_mappings() {
        let smap = r#"SMAP
Test.kt
Kotlin
*S Kotlin
*F
1 Test.kt
*L
1#1,10:1
15#1,5:11
*E
"#;
        let result = parse_or_null(smap);
        assert!(result.is_some());
        let smap = result.unwrap();

        let file = &smap.file_mappings[0];
        assert_eq!(file.line_mappings.len(), 2);

        // First range: source 1-10 -> dest 1-10
        assert_eq!(file.line_mappings[0].source, 1);
        assert_eq!(file.line_mappings[0].dest, 1);
        assert_eq!(file.line_mappings[0].range, 10);

        // Second range: source 15-19 -> dest 11-15
        assert_eq!(file.line_mappings[1].source, 15);
        assert_eq!(file.line_mappings[1].dest, 11);
        assert_eq!(file.line_mappings[1].range, 5);
    }

    /// Test find_range binary search
    #[test]
    fn test_find_range() {
        let smap = r#"SMAP
Test.kt
Kotlin
*S Kotlin
*F
1 Test.kt
*L
1#1,10:1
20#1,5:15
*E
"#;
        let result = parse_or_null(smap);
        assert!(result.is_some());
        let smap = result.unwrap();

        // Find in first range
        let found = smap.find_range(5);
        assert!(found.is_some());
        let (_, mapping) = found.unwrap();
        assert_eq!(mapping.source, 1);

        // Find in second range
        let found = smap.find_range(17);
        assert!(found.is_some());
        let (_, mapping) = found.unwrap();
        assert_eq!(mapping.source, 20);

        // Not in any range
        let found = smap.find_range(12);
        assert!(found.is_none());
    }

    /// Test empty input
    #[test]
    fn test_parse_empty() {
        assert!(parse_or_null("").is_none());
    }

    /// Test malformed input
    #[test]
    fn test_parse_malformed() {
        // Missing file section (has *L but no *F)
        let smap = "*S Kotlin\n*L\n1#1:1\n*E";
        assert!(parse_or_null(smap).is_none());

        // Missing line section (has *F but no *L before *E)
        // JADX Reference: SMAPParser.kt:78 returns null if *E seen before *L
        let smap = "*S Kotlin\n*F\n1 Test.kt\n*E";
        assert!(parse_or_null(smap).is_none());
    }

    /// Test with dest multiplier format
    #[test]
    fn test_parse_dest_multiplier() {
        let smap = r#"SMAP
Test.kt
Kotlin
*S Kotlin
*F
1 Test.kt
*L
1#1:1,5
*E
"#;
        let result = parse_or_null(smap);
        assert!(result.is_some());
        let smap = result.unwrap();
        assert_eq!(smap.file_mappings[0].line_mappings[0].range, 5);
    }
}
