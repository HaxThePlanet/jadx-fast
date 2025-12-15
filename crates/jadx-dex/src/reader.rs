//! Main DEX file reader
//!
//! Provides the primary interface for parsing DEX files.

use std::path::Path;
use std::collections::HashMap;
use std::sync::RwLock;

use memmap2::Mmap;

use crate::error::{DexError, Result};
use crate::header::DexHeader;
use crate::sections::{ClassDef, FieldId, MethodId, ProtoId};
use crate::utils::{decode_mutf8, read_uleb128};

/// A parsed DEX file
pub struct DexReader {
    /// Unique identifier for this DEX file
    pub id: u32,
    /// Input file name
    pub input_file: String,
    /// Raw DEX data (memory-mapped or owned)
    data: DexData,
    /// Parsed header
    pub header: DexHeader,
    /// String cache (lazily populated, thread-safe)
    strings: RwLock<HashMap<u32, String>>,
}

/// DEX data storage - either memory-mapped or owned bytes
enum DexData {
    Mmap(Mmap),
    Owned(Vec<u8>),
}

impl DexData {
    fn as_bytes(&self) -> &[u8] {
        match self {
            DexData::Mmap(mmap) => mmap,
            DexData::Owned(vec) => vec,
        }
    }
}

impl DexReader {
    /// Parse a DEX file from a file path using memory mapping
    pub fn from_file<P: AsRef<Path>>(id: u32, path: P) -> Result<Self> {
        let path = path.as_ref();
        let file = std::fs::File::open(path)?;
        let mmap = unsafe { Mmap::map(&file)? };
        let input_file = path.to_string_lossy().to_string();

        Self::from_data_internal(id, input_file, DexData::Mmap(mmap))
    }

    /// Parse a DEX file from bytes
    pub fn from_bytes(id: u32, input_file: String, data: Vec<u8>) -> Result<Self> {
        Self::from_data_internal(id, input_file, DexData::Owned(data))
    }

    /// Parse a DEX file from a byte slice (copies the data)
    pub fn from_slice(id: u32, input_file: String, data: &[u8]) -> Result<Self> {
        Self::from_bytes(id, input_file, data.to_vec())
    }

    /// Parse a DEX file from a byte slice without a filename (for embedded DEX)
    pub fn from_data(id: u32, data: &[u8]) -> Result<Self> {
        Self::from_bytes(id, format!("dex_{}", id), data.to_vec())
    }

    fn from_data_internal(id: u32, input_file: String, data: DexData) -> Result<Self> {
        let header = DexHeader::parse(data.as_bytes())?;
        
        Ok(DexReader {
            id,
            input_file,
            data,
            header,
            strings: RwLock::new(HashMap::new()),
        })
    }

    /// Get the raw DEX data
    pub fn data(&self) -> &[u8] {
        self.data.as_bytes()
    }

    /// Get a string by index (reads directly from DEX, no caching)
    pub fn get_string(&self, idx: u32) -> Result<String> {
        // Check cache first (read lock)
        {
            let strings = self.strings.read().unwrap();
            if let Some(s) = strings.get(&idx) {
                return Ok(s.clone()); // Return clone from cache
            }
        }

        // Not in cache, load and insert (write lock)
        let s = self.load_string(idx)?;
        let mut strings = self.strings.write().unwrap();

        // Double-check pattern - another thread may have inserted
        if let Some(existing_s) = strings.get(&idx) {
            return Ok(existing_s.clone());
        }

        strings.insert(idx, s.clone());
        Ok(s)
    }

    /// Load a string from the DEX file
    fn load_string(&self, idx: u32) -> Result<String> {
        if idx >= self.header.string_ids_size {
            return Err(DexError::InvalidStringIndex(idx));
        }

        let data = self.data();
        let string_ids_off = self.header.string_ids_off as usize;
        let str_data_off = read_u32(data, string_ids_off + (idx as usize * 4)) as usize;

        // Read ULEB128 length prefix and then MUTF-8 string data
        let (_, bytes_read) = read_uleb128(&data[str_data_off..])?;
        let str_start = str_data_off + bytes_read;

        // Find null terminator
        let str_end = data[str_start..]
            .iter()
            .position(|&b| b == 0)
            .map(|p| str_start + p)
            .unwrap_or(data.len());

        decode_mutf8(&data[str_start..str_end])
    }

    /// Get a type name by index
    pub fn get_type(&self, idx: u32) -> Result<String> {
        if idx == crate::NO_INDEX {
            return Err(DexError::InvalidTypeIndex(idx));
        }
        if idx >= self.header.type_ids_size {
            return Err(DexError::InvalidTypeIndex(idx));
        }

        let data = self.data();
        let type_ids_off = self.header.type_ids_off as usize;
        let str_idx = read_u32(data, type_ids_off + (idx as usize * 4));

        self.get_string(str_idx)
    }

    /// Get class count
    pub fn class_count(&self) -> u32 {
        self.header.class_defs_size
    }

    /// Iterate over class definitions
    pub fn classes(&self) -> ClassIterator<'_> {
        ClassIterator {
            reader: self,
            index: 0,
            count: self.header.class_defs_size,
        }
    }

    /// Get a class definition by index
    pub fn get_class(&self, idx: u32) -> Result<ClassDef<'_>> {
        if idx >= self.header.class_defs_size {
            return Err(DexError::InvalidClassDefIndex(idx));
        }

        let offset = self.header.class_defs_off as usize + (idx as usize * ClassDef::SIZE);
        ClassDef::parse(self, offset)
    }

    /// Get a field reference by index
    pub fn get_field(&self, idx: u32) -> Result<FieldId<'_>> {
        if idx >= self.header.field_ids_size {
            return Err(DexError::InvalidFieldIndex(idx));
        }

        let offset = self.header.field_ids_off as usize + (idx as usize * FieldId::SIZE);
        FieldId::parse(self, offset)
    }

    /// Get a method reference by index
    pub fn get_method(&self, idx: u32) -> Result<MethodId<'_>> {
        if idx >= self.header.method_ids_size {
            return Err(DexError::InvalidMethodIndex(idx));
        }

        let offset = self.header.method_ids_off as usize + (idx as usize * MethodId::SIZE);
        MethodId::parse(self, offset)
    }

    /// Get a method prototype by index
    pub fn get_proto(&self, idx: u32) -> Result<ProtoId<'_>> {
        if idx >= self.header.proto_ids_size {
            return Err(DexError::InvalidProtoIndex(idx));
        }

        let offset = self.header.proto_ids_off as usize + (idx as usize * ProtoId::SIZE);
        ProtoId::parse(self, offset)
    }

    /// Read a type list at the given offset
    pub fn read_type_list(&self, offset: u32) -> Result<Vec<String>> {
        if offset == 0 {
            return Ok(Vec::new());
        }

        let data = self.data();
        let off = offset as usize;

        if off + 4 > data.len() {
            return Err(DexError::UnexpectedEof {
                offset: off,
                needed: 4,
            });
        }

        let size = read_u32(data, off) as usize;
        let mut types = Vec::with_capacity(size);

        for i in 0..size {
            let type_idx = read_u16(data, off + 4 + (i * 2)) as u32;
            types.push(self.get_type(type_idx)?);
        }

        Ok(types)
    }
}

/// Iterator over class definitions
pub struct ClassIterator<'a> {
    reader: &'a DexReader,
    index: u32,
    count: u32,
}

impl<'a> Iterator for ClassIterator<'a> {
    type Item = Result<ClassDef<'a>>;

    fn next(&mut self) -> Option<Self::Item> {
        if self.index >= self.count {
            return None;
        }

        let result = self.reader.get_class(self.index);
        self.index += 1;
        Some(result)
    }

    fn size_hint(&self) -> (usize, Option<usize>) {
        let remaining = (self.count - self.index) as usize;
        (remaining, Some(remaining))
    }
}

impl<'a> ExactSizeIterator for ClassIterator<'a> {}

#[inline]
fn read_u32(data: &[u8], offset: usize) -> u32 {
    u32::from_le_bytes([
        data[offset],
        data[offset + 1],
        data[offset + 2],
        data[offset + 3],
    ])
}

#[inline]
fn read_u16(data: &[u8], offset: usize) -> u16 {
    u16::from_le_bytes([data[offset], data[offset + 1]])
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn test_invalid_data() {
        let result = DexReader::from_bytes(0, "test.dex".to_string(), vec![0; 50]);
        assert!(result.is_err());
    }
}