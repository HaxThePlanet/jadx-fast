//! Prototype ID parsing

use crate::error::Result;
use crate::reader::DexReader;
use crate::sections::read_u32;

/// A method prototype in the DEX file
///
/// Each proto_id_item is 12 bytes:
/// - shorty_idx (u32): Index into string_ids for shorty descriptor
/// - return_type_idx (u32): Index into type_ids for return type
/// - parameters_off (u32): Offset to type_list for parameters
pub struct ProtoId<'a> {
    reader: &'a DexReader,
    offset: usize,
}

impl std::fmt::Debug for ProtoId<'_> {
    fn fmt(&self, f: &mut std::fmt::Formatter<'_>) -> std::fmt::Result {
        f.debug_struct("ProtoId")
            .field("offset", &self.offset)
            .finish()
    }
}

impl<'a> ProtoId<'a> {
    /// Size of a proto_id_item in bytes
    pub const SIZE: usize = 12;

    pub(crate) fn parse(reader: &'a DexReader, offset: usize) -> Result<Self> {
        Ok(ProtoId { reader, offset })
    }

    /// Get the shorty descriptor
    pub fn shorty(&self) -> Result<String> {
        let shorty_idx = read_u32(self.reader.data(), self.offset);
        self.reader.get_string_owned(shorty_idx)
    }

    /// Get the return type descriptor
    pub fn return_type(&self) -> Result<String> {
        let return_type_idx = read_u32(self.reader.data(), self.offset + 4);
        self.reader.get_type(return_type_idx)
    }

    /// Get the parameter types
    pub fn parameters(&self) -> Result<Vec<String>> {
        let params_off = read_u32(self.reader.data(), self.offset + 8);
        self.reader.read_type_list(params_off)
    }
}
