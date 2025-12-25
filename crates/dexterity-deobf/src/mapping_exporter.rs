//! Mapping exporter for various formats
//!
//! JADX Reference: jadx-plugins/jadx-rename-mappings/src/main/java/jadx/plugins/mappings/save/MappingExporter.java
//! Cloned from JADX's MappingExporter class.
//!
//! This module exports deobfuscation mappings to various formats:
//! - Tiny (Fabric's mapping format)
//! - Tiny v2
//! - Enigma
//! - SRG (Searge)
//! - TSRG (Forge's format)
//! - ProGuard
//!
//! These formats are used for interoperability with tools like:
//! - Enigma (deobfuscation tool)
//! - Recaf (bytecode editor)
//! - Fabric toolchain
//! - Forge toolchain

use std::collections::HashMap;
use std::io::{self, Write};
use std::path::Path;
use std::fs::File;

use dexterity_ir::ClassData;

use crate::registry::AliasRegistry;
use crate::signature::method_proto_to_descriptor;

/// Supported mapping formats
///
/// JADX Reference: net.fabricmc.mappingio.format.MappingFormat
#[derive(Debug, Clone, Copy, PartialEq, Eq)]
pub enum MappingFormat {
    /// Tiny v1 format (Fabric)
    Tiny,
    /// Tiny v2 format (Fabric)
    TinyV2,
    /// Enigma format
    Enigma,
    /// SRG format (Searge/MCP)
    Srg,
    /// TSRG format (Forge)
    Tsrg,
    /// TSRG v2 format (Forge)
    TsrgV2,
    /// ProGuard format
    ProGuard,
    /// JOBF format (JADX native)
    Jobf,
}

impl MappingFormat {
    /// Get file extension for this format
    pub fn extension(&self) -> &'static str {
        match self {
            MappingFormat::Tiny => ".tiny",
            MappingFormat::TinyV2 => ".tiny",
            MappingFormat::Enigma => "", // Enigma uses directory
            MappingFormat::Srg => ".srg",
            MappingFormat::Tsrg => ".tsrg",
            MappingFormat::TsrgV2 => ".tsrg",
            MappingFormat::ProGuard => ".txt",
            MappingFormat::Jobf => ".jobf",
        }
    }

    /// Check if format uses a single file (vs directory)
    pub fn has_single_file(&self) -> bool {
        !matches!(self, MappingFormat::Enigma)
    }
}

/// Mapping exporter
///
/// JADX Reference: jadx-plugins/jadx-rename-mappings/src/main/java/jadx/plugins/mappings/save/MappingExporter.java
pub struct MappingExporter<'a> {
    classes: &'a [ClassData],
    registry: Option<&'a AliasRegistry>,
}

impl<'a> MappingExporter<'a> {
    /// Create a new mapping exporter
    pub fn new(classes: &'a [ClassData]) -> Self {
        Self {
            classes,
            registry: None,
        }
    }

    /// Set the alias registry for additional mapping info
    pub fn with_registry(mut self, registry: &'a AliasRegistry) -> Self {
        self.registry = Some(registry);
        self
    }

    /// Export mappings to the specified format
    ///
    /// JADX Reference: MappingExporter.exportMappings()
    pub fn export<P: AsRef<Path>>(&self, path: P, format: MappingFormat) -> io::Result<()> {
        let mut output: Box<dyn Write> = Box::new(File::create(path)?);

        match format {
            MappingFormat::Tiny => self.export_tiny_v1(&mut output),
            MappingFormat::TinyV2 => self.export_tiny_v2(&mut output),
            MappingFormat::Srg => self.export_srg(&mut output),
            MappingFormat::Tsrg => self.export_tsrg(&mut output),
            MappingFormat::TsrgV2 => self.export_tsrg_v2(&mut output),
            MappingFormat::ProGuard => self.export_proguard(&mut output),
            MappingFormat::Jobf => self.export_jobf(&mut output),
            MappingFormat::Enigma => {
                // Enigma uses directory structure - not implemented yet
                Err(io::Error::new(
                    io::ErrorKind::Unsupported,
                    "Enigma format requires directory export",
                ))
            }
        }
    }

    /// Export to Tiny v1 format
    ///
    /// Format:
    /// ```text
    /// v1	official	named
    /// CLASS	a	com/example/MyClass
    /// FIELD	a	I	b	myField
    /// METHOD	a	()V	c	myMethod
    /// ```
    fn export_tiny_v1<W: Write>(&self, out: &mut W) -> io::Result<()> {
        // Header
        writeln!(out, "v1\tofficial\tnamed")?;

        for cls in self.classes {
            let src_name = cls.class_type.trim_start_matches('L').trim_end_matches(';');

            // Only export if class has alias
            if let Some(ref alias) = cls.alias {
                let dst_name = self.get_full_alias_path(cls, alias);
                writeln!(out, "CLASS\t{}\t{}", src_name, dst_name)?;
            }

            // Fields
            for field in cls.static_fields.iter().chain(cls.instance_fields.iter()) {
                if let Some(ref alias) = field.alias {
                    let field_desc = field.field_type.to_descriptor();
                    writeln!(
                        out,
                        "FIELD\t{}\t{}\t{}\t{}",
                        src_name, field_desc, field.name, alias
                    )?;
                }
            }

            // Methods
            for method in &cls.methods {
                if let Some(ref alias) = method.alias {
                    let method_desc = method_proto_to_descriptor(&method.arg_types, &method.return_type);
                    writeln!(
                        out,
                        "METHOD\t{}\t{}\t{}\t{}",
                        src_name, method_desc, method.name, alias
                    )?;
                }
            }
        }

        Ok(())
    }

    /// Export to Tiny v2 format
    ///
    /// Format:
    /// ```text
    /// tiny	2	0	official	named
    /// c	a	com/example/MyClass
    /// 	f	I	b	myField
    /// 	m	()V	c	myMethod
    /// ```
    fn export_tiny_v2<W: Write>(&self, out: &mut W) -> io::Result<()> {
        // Header
        writeln!(out, "tiny\t2\t0\tofficial\tnamed")?;

        for cls in self.classes {
            let src_name = cls.class_type.trim_start_matches('L').trim_end_matches(';');
            let has_alias = cls.alias.is_some();

            // Only export classes with aliases or members with aliases
            let has_member_aliases = cls.static_fields.iter().any(|f| f.alias.is_some())
                || cls.instance_fields.iter().any(|f| f.alias.is_some())
                || cls.methods.iter().any(|m| m.alias.is_some());

            if !has_alias && !has_member_aliases {
                continue;
            }

            // Class line
            if let Some(ref alias) = cls.alias {
                let dst_name = self.get_full_alias_path(cls, alias);
                writeln!(out, "c\t{}\t{}", src_name, dst_name)?;
            } else {
                writeln!(out, "c\t{}\t{}", src_name, src_name)?;
            }

            // Fields
            for field in cls.static_fields.iter().chain(cls.instance_fields.iter()) {
                if let Some(ref alias) = field.alias {
                    let field_desc = field.field_type.to_descriptor();
                    writeln!(out, "\tf\t{}\t{}\t{}", field_desc, field.name, alias)?;
                }
            }

            // Methods
            for method in &cls.methods {
                if let Some(ref alias) = method.alias {
                    let method_desc = method_proto_to_descriptor(&method.arg_types, &method.return_type);
                    writeln!(out, "\tm\t{}\t{}\t{}", method_desc, method.name, alias)?;
                }
            }
        }

        Ok(())
    }

    /// Export to SRG format
    ///
    /// Format:
    /// ```text
    /// CL: a com/example/MyClass
    /// FD: a/b com/example/MyClass/myField
    /// MD: a/c ()V com/example/MyClass/myMethod ()V
    /// ```
    fn export_srg<W: Write>(&self, out: &mut W) -> io::Result<()> {
        for cls in self.classes {
            let src_name = cls.class_type.trim_start_matches('L').trim_end_matches(';');

            if let Some(ref alias) = cls.alias {
                let dst_name = self.get_full_alias_path(cls, alias);
                writeln!(out, "CL: {} {}", src_name, dst_name)?;
            }

            for field in cls.static_fields.iter().chain(cls.instance_fields.iter()) {
                if let Some(ref alias) = field.alias {
                    let dst_class = cls.alias.as_ref().map(|a| self.get_full_alias_path(cls, a))
                        .unwrap_or_else(|| src_name.to_string());
                    writeln!(
                        out,
                        "FD: {}/{} {}/{}",
                        src_name, field.name, dst_class, alias
                    )?;
                }
            }

            for method in &cls.methods {
                if let Some(ref alias) = method.alias {
                    let method_desc = method_proto_to_descriptor(&method.arg_types, &method.return_type);
                    let dst_class = cls.alias.as_ref().map(|a| self.get_full_alias_path(cls, a))
                        .unwrap_or_else(|| src_name.to_string());
                    writeln!(
                        out,
                        "MD: {}/{} {} {}/{} {}",
                        src_name, method.name, method_desc, dst_class, alias, method_desc
                    )?;
                }
            }
        }

        Ok(())
    }

    /// Export to TSRG format
    ///
    /// Format:
    /// ```text
    /// a com/example/MyClass
    /// 	b myField
    /// 	c ()V myMethod
    /// ```
    fn export_tsrg<W: Write>(&self, out: &mut W) -> io::Result<()> {
        for cls in self.classes {
            let src_name = cls.class_type.trim_start_matches('L').trim_end_matches(';');
            let has_alias = cls.alias.is_some();

            let has_member_aliases = cls.static_fields.iter().any(|f| f.alias.is_some())
                || cls.instance_fields.iter().any(|f| f.alias.is_some())
                || cls.methods.iter().any(|m| m.alias.is_some());

            if !has_alias && !has_member_aliases {
                continue;
            }

            // Class line
            let dst_name = cls.alias.as_ref()
                .map(|a| self.get_full_alias_path(cls, a))
                .unwrap_or_else(|| src_name.to_string());
            writeln!(out, "{} {}", src_name, dst_name)?;

            // Fields
            for field in cls.static_fields.iter().chain(cls.instance_fields.iter()) {
                if let Some(ref alias) = field.alias {
                    writeln!(out, "\t{} {}", field.name, alias)?;
                }
            }

            // Methods
            for method in &cls.methods {
                if let Some(ref alias) = method.alias {
                    let method_desc = method_proto_to_descriptor(&method.arg_types, &method.return_type);
                    writeln!(out, "\t{} {} {}", method.name, method_desc, alias)?;
                }
            }
        }

        Ok(())
    }

    /// Export to TSRG v2 format
    ///
    /// Format:
    /// ```text
    /// tsrg2 official named
    /// a com/example/MyClass
    /// 	b I myField
    /// 	c ()V myMethod
    /// ```
    fn export_tsrg_v2<W: Write>(&self, out: &mut W) -> io::Result<()> {
        // Header
        writeln!(out, "tsrg2 official named")?;

        for cls in self.classes {
            let src_name = cls.class_type.trim_start_matches('L').trim_end_matches(';');
            let has_alias = cls.alias.is_some();

            let has_member_aliases = cls.static_fields.iter().any(|f| f.alias.is_some())
                || cls.instance_fields.iter().any(|f| f.alias.is_some())
                || cls.methods.iter().any(|m| m.alias.is_some());

            if !has_alias && !has_member_aliases {
                continue;
            }

            // Class line
            let dst_name = cls.alias.as_ref()
                .map(|a| self.get_full_alias_path(cls, a))
                .unwrap_or_else(|| src_name.to_string());
            writeln!(out, "{} {}", src_name, dst_name)?;

            // Fields (with descriptor in v2)
            for field in cls.static_fields.iter().chain(cls.instance_fields.iter()) {
                if let Some(ref alias) = field.alias {
                    let field_desc = field.field_type.to_descriptor();
                    writeln!(out, "\t{} {} {}", field.name, field_desc, alias)?;
                }
            }

            // Methods
            for method in &cls.methods {
                if let Some(ref alias) = method.alias {
                    let method_desc = method_proto_to_descriptor(&method.arg_types, &method.return_type);
                    writeln!(out, "\t{} {} {}", method.name, method_desc, alias)?;
                }
            }
        }

        Ok(())
    }

    /// Export to ProGuard format
    ///
    /// Format:
    /// ```text
    /// com.example.MyClass -> a:
    ///     int myField -> b
    ///     void myMethod() -> c
    /// ```
    fn export_proguard<W: Write>(&self, out: &mut W) -> io::Result<()> {
        for cls in self.classes {
            let src_name = cls.class_type
                .trim_start_matches('L')
                .trim_end_matches(';')
                .replace('/', ".");

            let has_alias = cls.alias.is_some();
            let has_member_aliases = cls.static_fields.iter().any(|f| f.alias.is_some())
                || cls.instance_fields.iter().any(|f| f.alias.is_some())
                || cls.methods.iter().any(|m| m.alias.is_some());

            if !has_alias && !has_member_aliases {
                continue;
            }

            // Class line (ProGuard format is reversed: original -> obfuscated)
            // For our purposes, we output: alias -> original (deobfuscation mapping)
            let dst_name = cls.alias.as_ref()
                .map(|a| {
                    let path = self.get_full_alias_path(cls, a);
                    path.replace('/', ".")
                })
                .unwrap_or_else(|| src_name.clone());
            writeln!(out, "{} -> {}:", dst_name, src_name)?;

            // Fields
            for field in cls.static_fields.iter().chain(cls.instance_fields.iter()) {
                if let Some(ref alias) = field.alias {
                    let field_type = Self::type_to_java(&field.field_type.to_descriptor());
                    writeln!(out, "    {} {} -> {}", field_type, alias, field.name)?;
                }
            }

            // Methods
            for method in &cls.methods {
                if let Some(ref alias) = method.alias {
                    let return_type = Self::type_to_java(&method.return_type.to_descriptor());
                    let params: Vec<String> = method.arg_types.iter()
                        .map(|t| Self::type_to_java(&t.to_descriptor()))
                        .collect();
                    writeln!(
                        out,
                        "    {} {}({}) -> {}",
                        return_type, alias, params.join(","), method.name
                    )?;
                }
            }
        }

        Ok(())
    }

    /// Export to JOBF format (JADX native)
    fn export_jobf<W: Write>(&self, out: &mut W) -> io::Result<()> {
        let mut lines: Vec<String> = Vec::new();

        for cls in self.classes {
            // Class alias
            if let Some(ref alias) = cls.alias {
                lines.push(format!("c {} = {}", cls.class_type, alias));
            }

            // Package alias
            if let Some(ref pkg_alias) = cls.pkg_alias {
                let class_type = cls.class_type.trim_start_matches('L').trim_end_matches(';');
                if let Some(last_slash) = class_type.rfind('/') {
                    let pkg = &class_type[..last_slash];
                    lines.push(format!("p {} = {}", pkg, pkg_alias));
                }
            }

            // Fields
            for field in cls.static_fields.iter().chain(cls.instance_fields.iter()) {
                if let Some(ref alias) = field.alias {
                    lines.push(format!(
                        "f {}:{} = {}",
                        cls.class_type.trim_start_matches('L').trim_end_matches(';'),
                        field.name,
                        alias
                    ));
                }
            }

            // Methods
            for method in &cls.methods {
                if let Some(ref alias) = method.alias {
                    let proto = method_proto_to_descriptor(&method.arg_types, &method.return_type);
                    lines.push(format!(
                        "m {}:{}{} = {}",
                        cls.class_type.trim_start_matches('L').trim_end_matches(';'),
                        method.name,
                        proto,
                        alias
                    ));
                }
            }
        }

        // Sort for deterministic output
        lines.sort();

        for line in lines {
            writeln!(out, "{}", line)?;
        }

        Ok(())
    }

    /// Get full alias path for a class (package + alias)
    fn get_full_alias_path(&self, cls: &ClassData, alias: &str) -> String {
        let class_type = cls.class_type.trim_start_matches('L').trim_end_matches(';');

        // Check for package alias
        if let Some(ref pkg_alias) = cls.pkg_alias {
            return format!("{}/{}", pkg_alias, alias);
        }

        // Use original package
        if let Some(last_slash) = class_type.rfind('/') {
            let pkg = &class_type[..last_slash];
            format!("{}/{}", pkg, alias)
        } else {
            alias.to_string()
        }
    }

    /// Convert descriptor to Java type name
    fn type_to_java(desc: &str) -> String {
        if desc.is_empty() {
            return "void".to_string();
        }

        let mut result = String::new();
        let mut chars = desc.chars().peekable();

        while let Some(c) = chars.next() {
            match c {
                'V' => result.push_str("void"),
                'Z' => result.push_str("boolean"),
                'B' => result.push_str("byte"),
                'C' => result.push_str("char"),
                'S' => result.push_str("short"),
                'I' => result.push_str("int"),
                'J' => result.push_str("long"),
                'F' => result.push_str("float"),
                'D' => result.push_str("double"),
                '[' => {
                    let inner = Self::type_to_java(&chars.collect::<String>());
                    return format!("{}[]", inner);
                }
                'L' => {
                    let class_name: String = chars.take_while(|&c| c != ';').collect();
                    result.push_str(&class_name.replace('/', "."));
                    break;
                }
                _ => {}
            }
        }

        result
    }
}

/// Collect all renamed mappings into a HashMap for quick lookup
pub fn collect_mappings(classes: &[ClassData]) -> HashMap<String, String> {
    let mut mappings = HashMap::new();

    for cls in classes {
        if let Some(ref alias) = cls.alias {
            mappings.insert(cls.class_type.clone(), alias.clone());
        }

        for field in cls.static_fields.iter().chain(cls.instance_fields.iter()) {
            if let Some(ref alias) = field.alias {
                let key = format!("{}:{}", cls.class_type, field.name);
                mappings.insert(key, alias.clone());
            }
        }

        for method in &cls.methods {
            if let Some(ref alias) = method.alias {
                let proto = method_proto_to_descriptor(&method.arg_types, &method.return_type);
                let key = format!("{}:{}{}", cls.class_type, method.name, proto);
                mappings.insert(key, alias.clone());
            }
        }
    }

    mappings
}

#[cfg(test)]
mod tests {
    use super::*;
    use dexterity_ir::{ArgType, FieldData, MethodData};

    fn create_test_class() -> ClassData {
        let mut cls = ClassData::new("Lcom/example/a;".to_string(), 0);
        cls.alias = Some("MyClass".to_string());

        let mut field = FieldData::new("b".to_string(), 0, ArgType::Int);
        field.alias = Some("myField".to_string());
        cls.instance_fields.push(field);

        let mut method = MethodData::new("c".to_string(), 0, ArgType::Void);
        method.alias = Some("myMethod".to_string());
        cls.methods.push(method);

        cls
    }

    #[test]
    fn test_export_tiny_v1() {
        let classes = vec![create_test_class()];
        let exporter = MappingExporter::new(&classes);

        let mut output = Vec::new();
        exporter.export_tiny_v1(&mut output).unwrap();

        let result = String::from_utf8(output).unwrap();
        assert!(result.contains("v1\tofficial\tnamed"));
        assert!(result.contains("CLASS\tcom/example/a\tcom/example/MyClass"));
        assert!(result.contains("FIELD\tcom/example/a\tI\tb\tmyField"));
        assert!(result.contains("METHOD\tcom/example/a\t()V\tc\tmyMethod"));
    }

    #[test]
    fn test_export_tiny_v2() {
        let classes = vec![create_test_class()];
        let exporter = MappingExporter::new(&classes);

        let mut output = Vec::new();
        exporter.export_tiny_v2(&mut output).unwrap();

        let result = String::from_utf8(output).unwrap();
        assert!(result.contains("tiny\t2\t0\tofficial\tnamed"));
        assert!(result.contains("c\tcom/example/a\tcom/example/MyClass"));
        assert!(result.contains("\tf\tI\tb\tmyField"));
        assert!(result.contains("\tm\t()V\tc\tmyMethod"));
    }

    #[test]
    fn test_export_tsrg() {
        let classes = vec![create_test_class()];
        let exporter = MappingExporter::new(&classes);

        let mut output = Vec::new();
        exporter.export_tsrg(&mut output).unwrap();

        let result = String::from_utf8(output).unwrap();
        assert!(result.contains("com/example/a com/example/MyClass"));
        assert!(result.contains("\tb myField"));
        assert!(result.contains("\tc ()V myMethod"));
    }

    #[test]
    fn test_export_proguard() {
        let classes = vec![create_test_class()];
        let exporter = MappingExporter::new(&classes);

        let mut output = Vec::new();
        exporter.export_proguard(&mut output).unwrap();

        let result = String::from_utf8(output).unwrap();
        assert!(result.contains("com.example.MyClass -> com.example.a:"));
        assert!(result.contains("int myField -> b"));
        assert!(result.contains("void myMethod() -> c"));
    }

    #[test]
    fn test_type_to_java() {
        assert_eq!(MappingExporter::type_to_java("V"), "void");
        assert_eq!(MappingExporter::type_to_java("I"), "int");
        assert_eq!(MappingExporter::type_to_java("Z"), "boolean");
        assert_eq!(MappingExporter::type_to_java("[I"), "int[]");
        assert_eq!(MappingExporter::type_to_java("Ljava/lang/String;"), "java.lang.String");
    }

    #[test]
    fn test_collect_mappings() {
        let classes = vec![create_test_class()];
        let mappings = collect_mappings(&classes);

        assert_eq!(mappings.get("Lcom/example/a;"), Some(&"MyClass".to_string()));
        assert_eq!(mappings.get("Lcom/example/a;:b"), Some(&"myField".to_string()));
        assert_eq!(mappings.get("Lcom/example/a;:c()V"), Some(&"myMethod".to_string()));
    }
}
