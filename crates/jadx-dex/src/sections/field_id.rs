//! Field ID parsing

use crate::error::Result;
use crate::reader::DexReader;
use crate::sections::{read_u16, read_u32};

/// A field reference in the DEX file
///
/// Each field_id_item is 8 bytes:
/// - class_idx (u16): Index into type_ids for the defining class
/// - type_idx (u16): Index into type_ids for the field type
/// - name_idx (u32): Index into string_ids for the field name
pub struct FieldId<'a> {
    reader: &'a DexReader,
    offset: usize,
}

impl std::fmt::Debug for FieldId<'_> {
    fn fmt(&self, f: &mut std::fmt::Formatter<'_>) -> std::fmt::Result {
        f.debug_struct("FieldId")
            .field("offset", &self.offset)
            .finish()
    }
}

impl<'a> FieldId<'a> {
    /// Size of a field_id_item in bytes
    pub const SIZE: usize = 8;

    pub(crate) fn parse(reader: &'a DexReader, offset: usize) -> Result<Self> {
        Ok(FieldId { reader, offset })
    }

    /// Get the class type descriptor
    pub fn class_type(&self) -> Result<String> {
        let type_idx = read_u16(self.reader.data(), self.offset) as u32;
        self.reader.get_type(type_idx)
    }

    /// Get the field type descriptor
    pub fn field_type(&self) -> Result<String> {
        let type_idx = read_u16(self.reader.data(), self.offset + 2) as u32;
        self.reader.get_type(type_idx)
    }

    /// Get the field name
    pub fn name(&self) -> Result<String> {
        let name_idx = read_u32(self.reader.data(), self.offset + 4);
        self.reader.get_string_owned(name_idx)
    }
}
