//! JADX Obfuscation Format (.jobf) support
//!
//! Ported from jadx-core/src/main/java/jadx/core/deobf/DeobfPresets.java
//!
//! The .jobf format is JADX's native format for storing deobfuscation mappings.
//! It's a simple text format:
//! - Lines starting with `#` are comments
//! - Lines starting with `p ` are package mappings: `p original = alias`
//! - Lines starting with `c ` are class mappings: `c original = alias`
//! - Lines starting with `f ` are field mappings: `f class:field = alias`
//! - Lines starting with `m ` are method mappings: `m class:method(proto) = alias`

use std::collections::HashMap;
use std::fs;
use std::io::{self, BufRead, BufReader, Write};
use std::path::Path;

use crate::registry::AliasRegistry;

/// JOBF file mode for how to handle the mapping file
///
/// JADX Reference: jadx-core/src/main/java/jadx/api/args/GeneratedRenamesMappingFileMode.java
/// Cloned from JADX's GeneratedRenamesMappingFileMode enum exactly.
///
/// Controls how the .jobf mapping file is handled during deobfuscation.
#[derive(Debug, Clone, Copy, PartialEq, Eq, Default)]
pub enum JobfMode {
    /// Load if found, don't save (default in JADX)
    ///
    /// JADX: READ - Load existing mappings but never write them back
    #[default]
    Read,
    /// Load if found, save only if new (don't overwrite)
    ///
    /// JADX: READ_OR_SAVE - Load existing mappings if present, save new mappings only if file doesn't exist
    ReadOrSave,
    /// Don't load, always save (overwrite existing)
    ///
    /// JADX: OVERWRITE - Ignore existing mappings, regenerate and save
    Overwrite,
    /// Don't load and don't save
    ///
    /// JADX: IGNORE - Completely skip .jobf file handling
    Ignore,
}

impl JobfMode {
    /// Get the default mode (matches JADX's getDefault())
    ///
    /// JADX Reference: GeneratedRenamesMappingFileMode.getDefault() returns READ
    pub fn get_default() -> Self {
        Self::Read
    }

    /// Check if this mode should read existing mappings
    ///
    /// JADX Reference: GeneratedRenamesMappingFileMode.shouldRead()
    /// Returns true for READ and READ_OR_SAVE
    pub fn should_read(&self) -> bool {
        matches!(self, Self::Read | Self::ReadOrSave)
    }

    /// Check if this mode should write mappings
    ///
    /// JADX Reference: GeneratedRenamesMappingFileMode.shouldWrite()
    /// Returns true for READ_OR_SAVE and OVERWRITE
    pub fn should_write(&self) -> bool {
        matches!(self, Self::ReadOrSave | Self::Overwrite)
    }
}

/// JOBF preset mappings
#[derive(Debug, Default)]
pub struct JobfPresets {
    /// Package mappings (original -> alias)
    pub packages: HashMap<String, String>,
    /// Class mappings (original_full_name -> alias)
    pub classes: HashMap<String, String>,
    /// Field mappings (class:field_name -> alias)
    pub fields: HashMap<String, String>,
    /// Method mappings (class:method_name(proto) -> alias)
    pub methods: HashMap<String, String>,
}

impl JobfPresets {
    /// Create empty presets
    pub fn new() -> Self {
        Self::default()
    }

    /// Load presets from a .jobf file
    pub fn load<P: AsRef<Path>>(path: P) -> io::Result<Self> {
        let file = fs::File::open(path)?;
        let reader = BufReader::new(file);
        let mut presets = JobfPresets::new();

        for line in reader.lines() {
            let line = line?;
            let trimmed = line.trim();

            // Skip empty lines and comments
            if trimmed.is_empty() || trimmed.starts_with('#') {
                continue;
            }

            // Parse the line - format: "x original = alias" where x is p/c/f/m
            if trimmed.len() < 2 {
                continue;
            }

            let prefix = trimmed.chars().next().unwrap();
            let rest = trimmed[2..].trim();

            // Split on '=' and trim
            let parts: Vec<&str> = rest.splitn(2, '=').map(|s| s.trim()).collect();
            if parts.len() != 2 {
                continue;
            }

            let original = parts[0].to_string();
            let alias = parts[1].to_string();

            match prefix {
                'p' => {
                    presets.packages.insert(original, alias);
                }
                'c' => {
                    presets.classes.insert(original, alias);
                }
                'f' => {
                    presets.fields.insert(original, alias);
                }
                'm' => {
                    presets.methods.insert(original, alias);
                }
                'v' => {
                    // Deprecated variable format - ignore
                }
                _ => {
                    // Unknown prefix - ignore
                }
            }
        }

        Ok(presets)
    }

    /// Save presets to a .jobf file
    pub fn save<P: AsRef<Path>>(&self, path: P) -> io::Result<()> {
        if self.is_empty() {
            return Ok(()); // Don't save empty files
        }

        let mut lines: Vec<String> = Vec::new();

        // Add package mappings
        for (orig, alias) in &self.packages {
            lines.push(format!("p {} = {}", orig, alias));
        }

        // Add class mappings
        for (orig, alias) in &self.classes {
            lines.push(format!("c {} = {}", orig, alias));
        }

        // Add field mappings
        for (orig, alias) in &self.fields {
            lines.push(format!("f {} = {}", orig, alias));
        }

        // Add method mappings
        for (orig, alias) in &self.methods {
            lines.push(format!("m {} = {}", orig, alias));
        }

        // Sort for deterministic output
        lines.sort();

        // Write to file
        let mut file = fs::File::create(path)?;
        for line in lines {
            writeln!(file, "{}", line)?;
        }

        Ok(())
    }

    /// Check if presets are empty
    pub fn is_empty(&self) -> bool {
        self.packages.is_empty()
            && self.classes.is_empty()
            && self.fields.is_empty()
            && self.methods.is_empty()
    }

    /// Apply presets to an alias registry
    pub fn apply_to_registry(&self, registry: &AliasRegistry) {
        // Apply package aliases
        for (original, alias) in &self.packages {
            registry.set_package_alias(original, alias);
        }

        // Apply class aliases
        for (original, alias) in &self.classes {
            registry.set_class_alias(original, alias);
        }

        // Apply field aliases
        // Format: "class:field" -> alias
        for (key, alias) in &self.fields {
            if let Some((class, field)) = key.split_once(':') {
                registry.set_field_alias(class, field, alias);
            }
        }

        // Apply method aliases
        // Format: "class:method(proto)" -> alias
        for (key, alias) in &self.methods {
            if let Some((class, rest)) = key.split_once(':') {
                if let Some(paren_pos) = rest.find('(') {
                    let method = &rest[..paren_pos];
                    let proto = &rest[paren_pos..];
                    registry.set_method_alias(class, method, proto, alias);
                }
            }
        }
    }

    /// Fill presets from an alias registry
    pub fn fill_from_registry(&mut self, registry: &AliasRegistry) {
        // Get all package aliases
        for entry in registry.iter_packages() {
            self.packages.insert(entry.key().clone(), entry.value().to_string());
        }

        // Get all class aliases
        for entry in registry.iter_classes() {
            self.classes.insert(entry.key().clone(), entry.value().to_string());
        }

        // Get all field aliases
        for entry in registry.iter_fields() {
            let (class, field) = entry.key();
            self.fields.insert(format!("{}:{}", class, field), entry.value().to_string());
        }

        // Get all method aliases
        for entry in registry.iter_methods() {
            let (class, method, proto) = entry.key();
            self.methods
                .insert(format!("{}:{}{}", class, method, proto), entry.value().to_string());
        }
    }

    /// Get the default .jobf path for an input file
    pub fn default_jobf_path<P: AsRef<Path>>(input_path: P) -> std::path::PathBuf {
        let input = input_path.as_ref();
        let stem = input.file_stem().unwrap_or_default();
        let parent = input.parent().unwrap_or(Path::new("."));
        parent.join(format!("{}.jobf", stem.to_string_lossy()))
    }
}

/// Get class alias from presets
pub fn get_class_alias<'a>(presets: &'a JobfPresets, class_name: &str) -> Option<&'a str> {
    presets.classes.get(class_name).map(|s| s.as_str())
}

/// Get field alias from presets
pub fn get_field_alias<'a>(presets: &'a JobfPresets, class_name: &str, field_name: &str) -> Option<&'a str> {
    let key = format!("{}:{}", class_name, field_name);
    presets.fields.get(&key).map(|s| s.as_str())
}

/// Get method alias from presets
pub fn get_method_alias<'a>(
    presets: &'a JobfPresets,
    class_name: &str,
    method_name: &str,
    proto: &str,
) -> Option<&'a str> {
    let key = format!("{}:{}{}", class_name, method_name, proto);
    presets.methods.get(&key).map(|s| s.as_str())
}

/// Save deobfuscation mappings to a file
///
/// JADX Reference: jadx-core/src/main/java/jadx/core/deobf/SaveDeobfMapping.java
/// Cloned from JADX's SaveDeobfMapping visitor.
///
/// This function handles saving generated deobfuscation mappings to a .jobf file
/// according to the specified mode:
/// - `JobfMode::Read` - Don't save (read-only mode)
/// - `JobfMode::ReadOrSave` - Save only if file doesn't exist
/// - `JobfMode::Overwrite` - Always save (overwrite existing)
/// - `JobfMode::Ignore` - Don't save (ignored mode)
///
/// # Arguments
/// * `registry` - The alias registry containing all generated mappings
/// * `deobf_map_file` - Path to the .jobf file
/// * `mode` - How to handle the mapping file
///
/// # Returns
/// * `Ok(true)` - Mappings were saved successfully
/// * `Ok(false)` - Mappings were not saved (mode doesn't require saving, or file exists for READ_OR_SAVE)
/// * `Err(...)` - IO error occurred while saving
///
/// # Example
/// ```ignore
/// let registry = AliasRegistry::new();
/// // ... populate registry with aliases ...
/// save_deobf_mapping(&registry, Path::new("app.jobf"), JobfMode::ReadOrSave)?;
/// ```
pub fn save_deobf_mapping<P: AsRef<Path>>(
    registry: &AliasRegistry,
    deobf_map_file: P,
    mode: JobfMode,
) -> io::Result<bool> {
    // Check if we should write based on mode
    // JADX Reference: SaveDeobfMapping.init() lines 27-34
    if !mode.should_write() {
        return Ok(false);
    }

    let path = deobf_map_file.as_ref();

    // READ_OR_SAVE mode: don't overwrite existing file
    // JADX Reference: SaveDeobfMapping.init() line 30
    if mode == JobfMode::ReadOrSave && path.exists() {
        return Ok(false);
    }

    // Fill presets from registry and save
    // JADX Reference: SaveDeobfMapping.init() lines 32-33
    let mut presets = JobfPresets::new();
    presets.fill_from_registry(registry);
    presets.save(path)?;

    Ok(true)
}

/// Load deobfuscation mappings from a file if appropriate for the mode
///
/// JADX Reference: jadx-core/src/main/java/jadx/core/deobf/DeobfuscatorVisitor.java lines 47-52
/// Cloned from JADX's DeobfuscatorVisitor.loadPresets() logic.
///
/// # Arguments
/// * `deobf_map_file` - Path to the .jobf file
/// * `mode` - How to handle the mapping file
///
/// # Returns
/// * `Some(presets)` - Presets were loaded successfully
/// * `None` - Mode doesn't require loading, or file doesn't exist
pub fn load_deobf_mapping<P: AsRef<Path>>(
    deobf_map_file: P,
    mode: JobfMode,
) -> Option<JobfPresets> {
    // Check if we should read based on mode
    // JADX Reference: DeobfuscatorVisitor uses args.getGeneratedRenamesMappingFileMode().shouldRead()
    if !mode.should_read() {
        return None;
    }

    let path = deobf_map_file.as_ref();
    if !path.exists() {
        return None;
    }

    // Load presets, returning None on error
    // JADX Reference: DeobfPresets.load() is called in DeobfuscatorVisitor
    JobfPresets::load(path).ok()
}

#[cfg(test)]
mod tests {
    use super::*;
    use std::io::Write;
    use tempfile::NamedTempFile;

    #[test]
    fn test_load_jobf() {
        let mut file = NamedTempFile::new().unwrap();
        writeln!(file, "# This is a comment").unwrap();
        writeln!(file, "").unwrap();
        writeln!(file, "p com/example = com/renamed").unwrap();
        writeln!(file, "c com/example/Foo = Bar").unwrap();
        writeln!(file, "f com/example/Foo:mField = renamedField").unwrap();
        writeln!(file, "m com/example/Foo:doSomething(I)V = renamed").unwrap();
        file.flush().unwrap();

        let presets = JobfPresets::load(file.path()).unwrap();

        assert_eq!(presets.packages.get("com/example"), Some(&"com/renamed".to_string()));
        assert_eq!(presets.classes.get("com/example/Foo"), Some(&"Bar".to_string()));
        assert_eq!(
            presets.fields.get("com/example/Foo:mField"),
            Some(&"renamedField".to_string())
        );
        assert_eq!(
            presets.methods.get("com/example/Foo:doSomething(I)V"),
            Some(&"renamed".to_string())
        );
    }

    #[test]
    fn test_save_jobf() {
        let mut presets = JobfPresets::new();
        presets.packages.insert("com/old".to_string(), "com/new".to_string());
        presets.classes.insert("com/old/A".to_string(), "B".to_string());

        let file = NamedTempFile::new().unwrap();
        presets.save(file.path()).unwrap();

        // Read back and verify
        let content = fs::read_to_string(file.path()).unwrap();
        assert!(content.contains("c com/old/A = B"));
        assert!(content.contains("p com/old = com/new"));
    }

    #[test]
    fn test_empty_presets() {
        let presets = JobfPresets::new();
        assert!(presets.is_empty());

        // Empty presets should not create a file
        let file = NamedTempFile::new().unwrap();
        presets.save(file.path()).unwrap();
        // File should still be empty
        assert_eq!(fs::read_to_string(file.path()).unwrap(), "");
    }

    #[test]
    fn test_default_jobf_path() {
        let path = JobfPresets::default_jobf_path("/path/to/app.apk");
        assert_eq!(path.to_string_lossy(), "/path/to/app.jobf");

        let path = JobfPresets::default_jobf_path("test.dex");
        // Path::new(".") resolves to current dir without explicit "./"
        assert!(path.to_string_lossy().ends_with("test.jobf"));
    }

    #[test]
    fn test_get_helpers() {
        let mut presets = JobfPresets::new();
        presets.classes.insert("com/Foo".to_string(), "Bar".to_string());
        presets
            .fields
            .insert("com/Foo:field".to_string(), "renamed".to_string());
        presets
            .methods
            .insert("com/Foo:method()V".to_string(), "newMethod".to_string());

        assert_eq!(get_class_alias(&presets, "com/Foo"), Some("Bar"));
        assert_eq!(get_class_alias(&presets, "com/Other"), None);

        assert_eq!(get_field_alias(&presets, "com/Foo", "field"), Some("renamed"));
        assert_eq!(get_field_alias(&presets, "com/Foo", "other"), None);

        assert_eq!(
            get_method_alias(&presets, "com/Foo", "method", "()V"),
            Some("newMethod")
        );
        assert_eq!(get_method_alias(&presets, "com/Foo", "method", "(I)V"), None);
    }
}
