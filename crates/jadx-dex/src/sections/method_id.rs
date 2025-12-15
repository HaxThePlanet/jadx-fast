//! Method ID parsing

use crate::error::Result;
use crate::reader::DexReader;
use crate::sections::{read_u16, read_u32, ProtoId};

/// A method reference in the DEX file
///
/// Each method_id_item is 8 bytes:
/// - class_idx (u16): Index into type_ids for the defining class
/// - proto_idx (u16): Index into proto_ids for the method prototype
/// - name_idx (u32): Index into string_ids for the method name
pub struct MethodId<'a> {
    reader: &'a DexReader,
    offset: usize,
}

impl std::fmt::Debug for MethodId<'_> {
    fn fmt(&self, f: &mut std::fmt::Formatter<'_>) -> std::fmt::Result {
        f.debug_struct("MethodId")
            .field("offset", &self.offset)
            .finish()
    }
}

impl<'a> MethodId<'a> {
    /// Size of a method_id_item in bytes
    pub const SIZE: usize = 8;

    pub(crate) fn parse(reader: &'a DexReader, offset: usize) -> Result<Self> {
        Ok(MethodId { reader, offset })
    }

    /// Get the class type descriptor
    pub fn class_type(&self) -> Result<String> {
        let type_idx = read_u16(self.reader.data(), self.offset) as u32;
        self.reader.get_type(type_idx)
    }

    /// Get the method prototype index
    pub fn proto_idx(&self) -> u16 {
        read_u16(self.reader.data(), self.offset + 2)
    }

    /// Get the method prototype
    pub fn proto(&self) -> Result<ProtoId<'a>> {
        self.reader.get_proto(self.proto_idx() as u32)
    }

    /// Get the method name
    pub fn name(&self) -> Result<String> {
        let name_idx = read_u32(self.reader.data(), self.offset + 4);
        self.reader.get_string(name_idx)
    }

}
