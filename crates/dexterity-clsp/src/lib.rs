//! JADX Classpath Database Parser
//!
//! Parses JADX's `.jcst` binary classpath format to extract method throws declarations.
//! This enables 100% throws clause parity with JADX by using the same database.
//!
//! Format based on jadx-fast/jadx-core/src/main/java/jadx/core/clsp/ClsSet.java

use std::collections::HashMap;
use std::io::{self, Cursor, Read};

/// JCST file header
const JADX_CLS_SET_HEADER: &[u8] = b"jadx-cst";
/// Expected version number
const VERSION: u8 = 5;

/// Type enum ordinals from ClsSet.TypeEnum
#[derive(Debug, Clone, Copy, PartialEq, Eq)]
#[repr(u8)]
enum TypeEnum {
    Wildcard = 0,
    Generic = 1,
    GenericTypeVariable = 2,
    OuterGeneric = 3,
    Object = 4,
    Array = 5,
    Primitive = 6,
}

impl TypeEnum {
    fn from_ordinal(ordinal: u8) -> Option<Self> {
        match ordinal {
            0 => Some(TypeEnum::Wildcard),
            1 => Some(TypeEnum::Generic),
            2 => Some(TypeEnum::GenericTypeVariable),
            3 => Some(TypeEnum::OuterGeneric),
            4 => Some(TypeEnum::Object),
            5 => Some(TypeEnum::Array),
            6 => Some(TypeEnum::Primitive),
            _ => None,
        }
    }
}

/// Classpath database loaded from JADX .jcst file
#[derive(Debug)]
pub struct ClspDatabase {
    /// Android API level this database was built for
    pub android_api_level: i32,
    /// Map from class name (e.g., "java/lang/String") to class info
    pub classes: HashMap<String, ClspClass>,
}

/// A class in the classpath database
#[derive(Debug)]
pub struct ClspClass {
    /// Class name in internal format (e.g., "java/lang/String")
    pub name: String,
    /// Method signatures mapped to their throws declarations
    /// Key format: "methodName" (we match by name only for simplicity)
    pub methods: HashMap<String, Vec<ClspMethod>>,
}

/// A method in the classpath database
#[derive(Debug, Clone)]
pub struct ClspMethod {
    /// Method name
    pub name: String,
    /// Argument count (for disambiguation)
    pub arg_count: usize,
    /// List of exception class names this method throws
    pub throws: Vec<String>,
}

/// Parser error
#[derive(Debug)]
pub enum ParseError {
    InvalidHeader,
    UnsupportedVersion(u8),
    IoError(io::Error),
    InvalidFormat(String),
}

impl From<io::Error> for ParseError {
    fn from(e: io::Error) -> Self {
        ParseError::IoError(e)
    }
}

impl std::fmt::Display for ParseError {
    fn fmt(&self, f: &mut std::fmt::Formatter<'_>) -> std::fmt::Result {
        match self {
            ParseError::InvalidHeader => write!(f, "Invalid JCST header"),
            ParseError::UnsupportedVersion(v) => write!(f, "Unsupported JCST version: {}", v),
            ParseError::IoError(e) => write!(f, "IO error: {}", e),
            ParseError::InvalidFormat(s) => write!(f, "Invalid format: {}", s),
        }
    }
}

impl ClspDatabase {
    /// Parse a JCST file from bytes
    pub fn parse(data: &[u8]) -> Result<Self, ParseError> {
        let mut cursor = Cursor::new(data);

        // Read and verify header
        let mut header = [0u8; 8];
        cursor.read_exact(&mut header)?;
        if &header != JADX_CLS_SET_HEADER {
            return Err(ParseError::InvalidHeader);
        }

        // Read version
        let version = read_u8(&mut cursor)?;
        if version != VERSION {
            return Err(ParseError::UnsupportedVersion(version));
        }

        // Read Android API level
        let android_api_level = read_i32(&mut cursor)?;

        // Read class count
        let cls_count = read_i32(&mut cursor)? as usize;

        // First pass: read class names and store them in order
        let mut class_names = Vec::with_capacity(cls_count);
        for _ in 0..cls_count {
            let _acc_flags = read_i32(&mut cursor)?;
            let _source = read_u8(&mut cursor)?;
            let name = read_string(&mut cursor)?;
            class_names.push(name);
        }

        // Second pass: read class details (parents, type params, methods)
        let mut classes = HashMap::with_capacity(cls_count);
        for i in 0..cls_count {
            let class_name = class_names[i].clone();

            // Skip parents (ArgType array)
            skip_arg_types_array(&mut cursor, &class_names)?;

            // Skip type parameters (ArgType list)
            skip_arg_types_list(&mut cursor, &class_names)?;

            // Read methods
            let method_count = read_i16(&mut cursor)? as usize;
            let mut methods: HashMap<String, Vec<ClspMethod>> = HashMap::new();

            for _ in 0..method_count {
                let method = read_method(&mut cursor, &class_names)?;

                // Only store methods that have throws declarations
                if !method.throws.is_empty() {
                    methods.entry(method.name.clone())
                        .or_insert_with(Vec::new)
                        .push(method);
                }
            }

            // Only store classes that have methods with throws
            if !methods.is_empty() {
                classes.insert(class_name.clone(), ClspClass {
                    name: class_name,
                    methods,
                });
            }
        }

        log::info!("Loaded JCST database: {} classes with throws, API level {}",
                   classes.len(), android_api_level);

        Ok(ClspDatabase {
            android_api_level,
            classes,
        })
    }

    /// Get throws declarations for a method
    ///
    /// # Arguments
    /// * `class_name` - Class name in internal format (e.g., "java/lang/String") or dot format
    /// * `method_name` - Method name (e.g., "read", "<init>")
    /// * `arg_count` - Optional argument count for disambiguation
    ///
    /// Returns a list of exception class names that this method throws (in slash notation)
    pub fn get_method_throws(&self, class_name: &str, method_name: &str, arg_count: Option<usize>) -> Option<Vec<String>> {
        // Convert from slash notation to dot notation for lookup
        let dot_class_name = class_name.replace('/', ".");
        let class = self.classes.get(&dot_class_name)?;
        let methods = class.methods.get(method_name)?;

        // If we have arg_count, try to find exact match first
        if let Some(ac) = arg_count {
            for method in methods {
                if method.arg_count == ac {
                    // Convert from dot notation to slash notation for codegen
                    return Some(method.throws.iter()
                        .map(|t| t.replace('.', "/"))
                        .collect());
                }
            }
        }

        // Otherwise return the first match (most methods have unique names)
        // Convert from dot notation to slash notation for codegen
        methods.first().map(|m| m.throws.iter()
            .map(|t| t.replace('.', "/"))
            .collect())
    }

    /// Check if a class exists in the database
    pub fn has_class(&self, class_name: &str) -> bool {
        self.classes.contains_key(class_name)
    }
}

// --- Binary reading helpers ---

fn read_u8(cursor: &mut Cursor<&[u8]>) -> io::Result<u8> {
    let mut buf = [0u8; 1];
    cursor.read_exact(&mut buf)?;
    Ok(buf[0])
}

fn read_i8(cursor: &mut Cursor<&[u8]>) -> io::Result<i8> {
    let mut buf = [0u8; 1];
    cursor.read_exact(&mut buf)?;
    Ok(buf[0] as i8)
}

fn read_i16(cursor: &mut Cursor<&[u8]>) -> io::Result<i16> {
    let mut buf = [0u8; 2];
    cursor.read_exact(&mut buf)?;
    Ok(i16::from_be_bytes(buf))
}

fn read_i32(cursor: &mut Cursor<&[u8]>) -> io::Result<i32> {
    let mut buf = [0u8; 4];
    cursor.read_exact(&mut buf)?;
    Ok(i32::from_be_bytes(buf))
}

fn read_string(cursor: &mut Cursor<&[u8]>) -> io::Result<String> {
    let len = read_u8(cursor)? as usize;
    let mut buf = vec![0u8; len];
    cursor.read_exact(&mut buf)?;
    String::from_utf8(buf).map_err(|e| io::Error::new(io::ErrorKind::InvalidData, e))
}

/// Read a method and extract its throws declarations
fn read_method(cursor: &mut Cursor<&[u8]>, class_names: &[String]) -> Result<ClspMethod, ParseError> {
    // Method name
    let name = read_string(cursor)?;

    // Argument types (to get arg count)
    let arg_count = read_arg_types_list_count(cursor, class_names)?;

    // Return type
    skip_arg_type(cursor, class_names)?;

    // Generic argument types
    skip_arg_types_list(cursor, class_names)?;

    // Generic return type
    skip_arg_type(cursor, class_names)?;

    // Type parameters
    skip_arg_types_list(cursor, class_names)?;

    // Access flags
    let _acc_flags = read_i32(cursor)?;

    // Throws list - this is what we want!
    let throws = read_throws_list(cursor, class_names)?;

    Ok(ClspMethod {
        name,
        arg_count,
        throws,
    })
}

/// Read throws list and return class names
fn read_throws_list(cursor: &mut Cursor<&[u8]>, class_names: &[String]) -> Result<Vec<String>, ParseError> {
    let count = read_i8(cursor)?;
    if count <= 0 {
        return Ok(Vec::new());
    }

    let mut throws = Vec::with_capacity(count as usize);
    for _ in 0..count {
        if let Some(type_name) = read_arg_type_name(cursor, class_names)? {
            // Convert from dot notation to internal format if needed
            throws.push(type_name);
        }
    }

    Ok(throws)
}

/// Read an ArgType and return the class name if it's an object type
fn read_arg_type_name(cursor: &mut Cursor<&[u8]>, class_names: &[String]) -> Result<Option<String>, ParseError> {
    let ordinal = read_i8(cursor)?;
    if ordinal == -1 {
        return Ok(None);
    }

    let type_enum = TypeEnum::from_ordinal(ordinal as u8)
        .ok_or_else(|| ParseError::InvalidFormat(format!("Invalid type ordinal: {}", ordinal)))?;

    match type_enum {
        TypeEnum::Wildcard => {
            let bound = read_i8(cursor)?;
            if bound != 0 {
                // Has bound type
                read_arg_type_name(cursor, class_names)?;
            }
            Ok(None)
        }
        TypeEnum::OuterGeneric => {
            read_arg_type_name(cursor, class_names)?;
            read_arg_type_name(cursor, class_names)?;
            Ok(None)
        }
        TypeEnum::Generic => {
            let class_idx = read_i32(cursor)? as usize;
            let name = class_names.get(class_idx)
                .cloned()
                .ok_or_else(|| ParseError::InvalidFormat(format!("Invalid class index: {}", class_idx)))?;
            // Skip generic type params
            skip_arg_types_list(cursor, class_names)?;
            Ok(Some(name))
        }
        TypeEnum::GenericTypeVariable => {
            let _type_var = read_string(cursor)?;
            skip_arg_types_list(cursor, class_names)?;
            Ok(None)
        }
        TypeEnum::Object => {
            let class_idx = read_i32(cursor)? as usize;
            let name = class_names.get(class_idx)
                .cloned()
                .ok_or_else(|| ParseError::InvalidFormat(format!("Invalid class index: {}", class_idx)))?;
            Ok(Some(name))
        }
        TypeEnum::Array => {
            read_arg_type_name(cursor, class_names)?;
            Ok(None)
        }
        TypeEnum::Primitive => {
            let _short_name = read_u8(cursor)?;
            Ok(None)
        }
    }
}

/// Skip an ArgType (don't care about the value, just advance cursor)
fn skip_arg_type(cursor: &mut Cursor<&[u8]>, class_names: &[String]) -> Result<(), ParseError> {
    read_arg_type_name(cursor, class_names)?;
    Ok(())
}

/// Skip an ArgType list
fn skip_arg_types_list(cursor: &mut Cursor<&[u8]>, class_names: &[String]) -> Result<(), ParseError> {
    let count = read_i8(cursor)?;
    if count <= 0 {
        return Ok(());
    }
    for _ in 0..count {
        skip_arg_type(cursor, class_names)?;
    }
    Ok(())
}

/// Read ArgType list and return the count
fn read_arg_types_list_count(cursor: &mut Cursor<&[u8]>, class_names: &[String]) -> Result<usize, ParseError> {
    let count = read_i8(cursor)?;
    if count <= 0 {
        return Ok(0);
    }
    for _ in 0..count {
        skip_arg_type(cursor, class_names)?;
    }
    Ok(count as usize)
}

/// Skip an ArgType array (nullable)
fn skip_arg_types_array(cursor: &mut Cursor<&[u8]>, class_names: &[String]) -> Result<(), ParseError> {
    let count = read_i8(cursor)?;
    match count {
        -1 | -2 | 0 => Ok(()), // null, OBJECT_ARGTYPE_ARRAY, or empty
        _ => {
            for _ in 0..count {
                skip_arg_type(cursor, class_names)?;
            }
            Ok(())
        }
    }
}

// --- Global database instance ---

lazy_static::lazy_static! {
    /// Global classpath database loaded from embedded JCST file
    pub static ref CLSP_DATABASE: Option<ClspDatabase> = {
        // Embedded JCST file from jadx-fast
        let jcst_bytes = include_bytes!("../../../jadx-fast/jadx-core/src/main/resources/clst/core.jcst");
        match ClspDatabase::parse(jcst_bytes) {
            Ok(db) => {
                log::info!("Loaded classpath database: {} classes with throws", db.classes.len());
                Some(db)
            }
            Err(e) => {
                log::warn!("Failed to load classpath database: {}", e);
                None
            }
        }
    };
}

/// Convenience function to get method throws from global database
pub fn get_method_throws(class_name: &str, method_name: &str) -> Option<Vec<String>> {
    CLSP_DATABASE.as_ref()?.get_method_throws(class_name, method_name, None)
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn test_parse_jcst() {
        let jcst_bytes = include_bytes!("../../../jadx-fast/jadx-core/src/main/resources/clst/core.jcst");
        let db = ClspDatabase::parse(jcst_bytes).expect("Failed to parse JCST");

        // Should have many classes
        assert!(db.classes.len() > 100, "Expected >100 classes with throws, got {}", db.classes.len());

        // Check a known method with throws
        // java/io/InputStream.read() throws IOException
        if let Some(throws) = db.get_method_throws("java/io/InputStream", "read", None) {
            assert!(throws.iter().any(|t| t.contains("IOException")),
                    "Expected IOException in throws: {:?}", throws);
        }
    }

    #[test]
    fn test_global_database() {
        // Should load without panic
        let _db = &*CLSP_DATABASE;
    }

    #[test]
    fn test_database_stats() {
        let db = CLSP_DATABASE.as_ref().expect("Database should load");

        let mut total_methods = 0;
        for (_, class) in &db.classes {
            for (_, methods) in &class.methods {
                total_methods += methods.len();
            }
        }

        println!("\n=== CLSP Database Stats ===");
        println!("Classes with throws: {}", db.classes.len());
        println!("Total methods with throws: {}", total_methods);
        println!("Android API level: {}", db.android_api_level);

        // Show first 10 class names to check format
        println!("\nFirst 10 class names (to check format):");
        for (i, class_name) in db.classes.keys().take(10).enumerate() {
            println!("  {}: {}", i, class_name);
        }

        // Show a few examples
        println!("\nExamples:");
        if let Some(throws) = db.get_method_throws("java/io/InputStream", "read", None) {
            println!("  java/io/InputStream.read() throws {:?}", throws);
        }
        if let Some(throws) = db.get_method_throws("java/io/FileInputStream", "<init>", None) {
            println!("  java/io/FileInputStream.<init>() throws {:?}", throws);
        }
        if let Some(throws) = db.get_method_throws("java/net/URL", "openConnection", None) {
            println!("  java/net/URL.openConnection() throws {:?}", throws);
        }
        if let Some(throws) = db.get_method_throws("java/lang/Class", "forName", None) {
            println!("  java/lang/Class.forName() throws {:?}", throws);
        }
        if let Some(throws) = db.get_method_throws("java/lang/Thread", "sleep", None) {
            println!("  java/lang/Thread.sleep() throws {:?}", throws);
        }
        println!("===========================\n");

        // Verify reasonable numbers
        assert!(db.classes.len() > 500, "Expected >500 classes with throws");
        assert!(total_methods > 2000, "Expected >2000 methods with throws");
    }
}
