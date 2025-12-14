//! Command-line argument definitions matching Java JADX CLI

use std::collections::HashSet;
use std::path::PathBuf;

use anyhow::{bail, Result};
use clap::{Parser, ValueEnum};

/// Android DEX/APK decompiler
#[derive(Parser, Debug)]
#[command(name = "jadx-rust")]
#[command(author = "jadx-rust contributors")]
#[command(version, disable_version_flag = true)]
#[command(about = "Dex to Java decompiler", long_about = None)]
#[command(after_help = "Examples:
  jadx-rust -d output/ app.apk
  jadx-rust --deobf -d output/ app.apk
  jadx-rust -j 16 -d output/ classes.dex")]
pub struct Args {
    /// Input files (.apk, .dex, .jar, .class, .smali, .zip, .aar, .arsc, .aab, .xapk, .apkm)
    #[arg(required_unless_present = "version")]
    pub input: Vec<PathBuf>,

    // === Output options ===
    /// Output directory
    #[arg(short = 'd', long = "output-dir")]
    pub output_dir: Option<PathBuf>,

    /// Output directory for sources
    #[arg(long = "output-dir-src")]
    pub output_dir_src: Option<PathBuf>,

    /// Output directory for resources
    #[arg(long = "output-dir-res")]
    pub output_dir_res: Option<PathBuf>,

    // === Processing options ===
    /// Do not decode resources
    #[arg(short = 'r', long = "no-res")]
    pub skip_resources: bool,

    /// Do not decompile source code
    #[arg(short = 's', long = "no-src")]
    pub skip_sources: bool,

    /// Processing threads count (0 = auto)
    #[arg(short = 'j', long = "threads-count", default_value = "0")]
    pub threads: usize,

    /// Decompile a single class (full name, raw or alias)
    #[arg(long = "single-class")]
    pub single_class: Option<String>,

    /// File or dir for single class output
    #[arg(long = "single-class-output")]
    pub single_class_output: Option<PathBuf>,

    /// Output format
    #[arg(long = "output-format", value_enum, default_value = "java")]
    pub output_format: OutputFormat,

    // === Decompilation mode ===
    /// Decompilation mode
    #[arg(short = 'm', long = "decompilation-mode", value_enum, default_value = "auto")]
    pub decompilation_mode: DecompilationMode,

    /// Show inconsistent code (incorrectly decompiled)
    #[arg(long = "show-bad-code")]
    pub show_bad_code: bool,

    /// Fallback mode (deprecated, use --decompilation-mode=fallback)
    #[arg(short = 'f', long = "fallback", hide = true)]
    pub fallback_mode: bool,

    // === Code style options ===
    /// Disable use of imports, always write entire package name
    #[arg(long = "no-imports")]
    pub no_imports: bool,

    /// Disable debug info parsing and processing
    #[arg(long = "no-debug-info")]
    pub no_debug_info: bool,

    /// Add comments with debug line numbers if available
    #[arg(long = "add-debug-lines")]
    pub add_debug_lines: bool,

    /// Disable anonymous classes inline
    #[arg(long = "no-inline-anonymous")]
    pub no_inline_anonymous: bool,

    /// Disable methods inline
    #[arg(long = "no-inline-methods")]
    pub no_inline_methods: bool,

    /// Disable move inner classes into parent
    #[arg(long = "no-move-inner-classes")]
    pub no_move_inner: bool,

    /// Disable inline for Kotlin lambdas
    #[arg(long = "no-inline-kotlin-lambda")]
    pub no_inline_kotlin_lambda: bool,

    /// Don't extract finally block
    #[arg(long = "no-finally")]
    pub no_finally: bool,

    /// Process Kotlin metadata annotations to extract original names (enabled by default)
    #[arg(long = "kotlin-metadata", default_value_t = true)]
    pub kotlin_metadata: bool,

    /// Disable Kotlin metadata processing
    #[arg(long = "no-kotlin-metadata")]
    pub no_kotlin_metadata: bool,

    /// Don't restore switch over string
    #[arg(long = "no-restore-switch-over-string")]
    pub no_restore_switch_string: bool,

    /// Don't replace constant value with matching constant field
    #[arg(long = "no-replace-consts")]
    pub no_replace_consts: bool,

    /// Escape non-latin characters in strings (with \\u)
    #[arg(long = "escape-unicode")]
    pub escape_unicode: bool,

    /// Don't change original access modifiers
    #[arg(long = "respect-bytecode-access-modifiers")]
    pub respect_bytecode_access: bool,

    // === Deobfuscation options ===
    /// Activate deobfuscation
    #[arg(long = "deobf")]
    pub deobfuscation: bool,

    /// Min length of name, renamed if shorter
    #[arg(long = "deobf-min", default_value = "3")]
    pub deobf_min_length: usize,

    /// Max length of name, renamed if longer
    #[arg(long = "deobf-max", default_value = "64")]
    pub deobf_max_length: usize,

    /// Deobfuscation mappings file path
    #[arg(long = "mappings-path")]
    pub mappings_path: Option<PathBuf>,

    /// Deobfuscation mappings mode
    #[arg(long = "mappings-mode", value_enum, default_value = "read")]
    pub mappings_mode: MappingsMode,

    /// JADX auto-generated names mapping file (.jobf)
    #[arg(long = "deobf-cfg-file")]
    pub deobf_cfg_file: Option<PathBuf>,

    /// Mode for JADX auto-generated names file
    #[arg(long = "deobf-cfg-file-mode", value_enum, default_value = "read")]
    pub deobf_cfg_file_mode: DeobfCfgFileMode,

    /// Resource name source
    #[arg(long = "deobf-res-name-source", value_enum, default_value = "auto")]
    pub resource_name_source: ResourceNameSource,

    /// Use source name as class name alias
    #[arg(long = "use-source-name-as-class-name-alias", value_enum)]
    pub use_source_name_as_alias: Option<UseSourceNameAlias>,

    // === Rename options ===
    /// Rename flags (comma-separated: case, valid, printable, none, all)
    #[arg(long = "rename-flags", default_value = "all")]
    pub rename_flags: String,

    /// Treat filesystem as case sensitive
    #[arg(long = "fs-case-sensitive")]
    pub fs_case_sensitive: bool,

    // === Format options ===
    /// Integer display format
    #[arg(long = "integer-format", value_enum, default_value = "auto")]
    pub integer_format: IntegerFormat,

    /// Code comments level
    #[arg(long = "comments-level", value_enum, default_value = "info")]
    pub comments_level: CommentsLevel,

    // === Export options ===
    /// Save as gradle project
    #[arg(short = 'e', long = "export-gradle")]
    pub export_gradle: bool,

    /// Gradle project template type
    #[arg(long = "export-gradle-type", value_enum)]
    pub export_gradle_type: Option<GradleType>,

    // === Debug options ===
    /// Save methods control flow graph to dot file
    #[arg(long = "cfg")]
    pub cfg_output: bool,

    /// Save raw methods control flow graph
    #[arg(long = "raw-cfg")]
    pub raw_cfg_output: bool,

    // === Logging options ===
    /// Log level
    #[arg(long = "log-level", value_enum, default_value = "progress")]
    pub log_level: LogLevel,

    /// Verbose output (set log level to debug)
    #[arg(short = 'v', long = "verbose")]
    pub verbose: bool,

    /// Turn off output (set log level to quiet)
    #[arg(short = 'q', long = "quiet")]
    pub quiet: bool,

    /// Print version
    #[arg(long = "version")]
    pub version: bool,
}

impl Args {
    /// Get effective thread count (0 means auto-detect)
    pub fn effective_threads(&self) -> usize {
        // First check RAYON_NUM_THREADS environment variable (highest priority)
        if let Ok(threads_str) = std::env::var("RAYON_NUM_THREADS") {
            if let Ok(threads) = threads_str.parse::<usize>() {
                if threads > 0 {
                    return threads;
                }
            }
        }
        // Then check CLI argument
        if self.threads > 0 {
            return self.threads;
        }
        // Java JADX uses small batches with limited parallelism (availableProcessors / 3)
        // to prevent memory exhaustion on high-core machines.
        std::cmp::max(1, num_cpus::get() / 3)
    }

    /// Validate arguments
    pub fn validate(&self) -> Result<()> {
        if self.input.is_empty() && !self.version {
            bail!("No input files specified");
        }

        for input in &self.input {
            if !input.exists() {
                bail!("Input file does not exist: {}", input.display());
            }
        }

        if self.deobf_min_length > self.deobf_max_length {
            bail!(
                "Deobfuscation min length ({}) cannot be greater than max length ({})",
                self.deobf_min_length,
                self.deobf_max_length
            );
        }

        Ok(())
    }

    /// Check if imports should be used
    pub fn use_imports(&self) -> bool {
        !self.no_imports
    }

    /// Check if debug info should be processed
    pub fn debug_info(&self) -> bool {
        !self.no_debug_info
    }

    /// Check if anonymous classes should be inlined
    pub fn inline_anonymous(&self) -> bool {
        !self.no_inline_anonymous
    }

    /// Check if methods should be inlined
    pub fn inline_methods(&self) -> bool {
        !self.no_inline_methods
    }

    /// Check if inner classes should be moved
    pub fn move_inner_classes(&self) -> bool {
        !self.no_move_inner
    }

    /// Check if Kotlin lambdas should be inlined
    pub fn inline_kotlin_lambda(&self) -> bool {
        !self.no_inline_kotlin_lambda
    }

    /// Check if finally blocks should be extracted
    pub fn extract_finally(&self) -> bool {
        !self.no_finally
    }

    /// Check if switch over string should be restored
    pub fn restore_switch_string(&self) -> bool {
        !self.no_restore_switch_string
    }

    /// Check if constants should be replaced
    pub fn replace_consts(&self) -> bool {
        !self.no_replace_consts
    }

    /// Check if Kotlin metadata should be processed
    pub fn process_kotlin_metadata(&self) -> bool {
        self.kotlin_metadata && !self.no_kotlin_metadata
    }

    /// Get effective decompilation mode
    pub fn effective_decompilation_mode(&self) -> DecompilationMode {
        if self.fallback_mode {
            DecompilationMode::Fallback
        } else {
            self.decompilation_mode
        }
    }

    /// Parse rename flags into a set
    pub fn parse_rename_flags(&self) -> HashSet<RenameFlag> {
        let mut flags = HashSet::new();
        let input = self.rename_flags.to_lowercase();

        if input == "none" {
            return flags;
        }
        if input == "all" {
            flags.insert(RenameFlag::Case);
            flags.insert(RenameFlag::Valid);
            flags.insert(RenameFlag::Printable);
            return flags;
        }

        for part in input.split(',') {
            match part.trim() {
                "case" => {
                    flags.insert(RenameFlag::Case);
                }
                "valid" => {
                    flags.insert(RenameFlag::Valid);
                }
                "printable" => {
                    flags.insert(RenameFlag::Printable);
                }
                _ => {}
            }
        }
        flags
    }
}

// === Enums ===

#[derive(Debug, Clone, Copy, PartialEq, Eq, ValueEnum)]
pub enum OutputFormat {
    Java,
    Json,
}

#[derive(Debug, Clone, Copy, PartialEq, Eq, ValueEnum, Default)]
pub enum DecompilationMode {
    /// Try best options automatically
    #[default]
    Auto,
    /// Restore code structure (normal java code)
    Restructure,
    /// Simplified instructions (linear, with goto's)
    Simple,
    /// Raw instructions without modifications
    Fallback,
}

#[derive(Debug, Clone, Copy, PartialEq, Eq, ValueEnum)]
pub enum MappingsMode {
    /// Just read, user can save manually
    Read,
    /// Read and autosave after every change
    ReadAndAutosaveEveryChange,
    /// Read and autosave before closing
    ReadAndAutosaveBeforeClosing,
    /// Don't read or save
    Ignore,
}

#[derive(Debug, Clone, Copy, PartialEq, Eq, ValueEnum)]
pub enum DeobfCfgFileMode {
    /// Read if found, don't save
    Read,
    /// Read if found, save otherwise
    ReadOrSave,
    /// Don't read, always save
    Overwrite,
    /// Don't read and don't save
    Ignore,
}

#[derive(Debug, Clone, Copy, PartialEq, Eq, ValueEnum)]
pub enum ResourceNameSource {
    /// Automatically select best name
    Auto,
    /// Use resources names
    Resources,
    /// Use R class fields names
    Code,
}

#[derive(Debug, Clone, Copy, PartialEq, Eq, ValueEnum)]
pub enum UseSourceNameAlias {
    /// Always use source name if available
    Always,
    /// Use source name if it seems better
    IfBetter,
    /// Never use source name
    Never,
}

#[derive(Debug, Clone, Copy, PartialEq, Eq, ValueEnum)]
pub enum IntegerFormat {
    /// Automatically select
    Auto,
    /// Use decimal
    Decimal,
    /// Use hexadecimal
    Hexadecimal,
}

#[derive(Debug, Clone, Copy, PartialEq, Eq, ValueEnum)]
pub enum CommentsLevel {
    None,
    UserOnly,
    Error,
    Warn,
    Info,
    Debug,
}

#[derive(Debug, Clone, Copy, PartialEq, Eq, ValueEnum)]
pub enum GradleType {
    /// Detect automatically
    Auto,
    /// Android Application (apk)
    AndroidApp,
    /// Android Library (aar)
    AndroidLibrary,
    /// Simple Java
    SimpleJava,
}

#[derive(Debug, Clone, Copy, PartialEq, Eq, ValueEnum, Default)]
pub enum LogLevel {
    Quiet,
    #[default]
    Progress,
    Error,
    Warn,
    Info,
    Debug,
}

#[derive(Debug, Clone, Copy, PartialEq, Eq, Hash)]
pub enum RenameFlag {
    /// Fix case sensitivity issues
    Case,
    /// Rename to make valid java identifiers
    Valid,
    /// Remove non-printable chars
    Printable,
}
