//! Class definition parsing

use crate::error::Result;
use crate::reader::DexReader;
use crate::sections::read_u32;
use crate::utils::read_uleb128;

/// A class definition in the DEX file
///
/// Each class_def_item is 32 bytes:
/// - class_idx (u32): Index into type_ids for this class
/// - access_flags (u32): Access flags for the class
/// - superclass_idx (u32): Index into type_ids for superclass (or NO_INDEX)
/// - interfaces_off (u32): Offset to type_list of interfaces
/// - source_file_idx (u32): Index into string_ids for source file name
/// - annotations_off (u32): Offset to annotations
/// - class_data_off (u32): Offset to class_data_item
/// - static_values_off (u32): Offset to static field initializers
pub struct ClassDef<'a> {
    reader: &'a DexReader,
    offset: usize,
}

impl std::fmt::Debug for ClassDef<'_> {
    fn fmt(&self, f: &mut std::fmt::Formatter<'_>) -> std::fmt::Result {
        f.debug_struct("ClassDef")
            .field("offset", &self.offset)
            .finish()
    }
}

impl<'a> ClassDef<'a> {
    /// Size of a class_def_item in bytes
    pub const SIZE: usize = 32;

    pub(crate) fn parse(reader: &'a DexReader, offset: usize) -> Result<Self> {
        Ok(ClassDef { reader, offset })
    }

    /// Get the class type descriptor (e.g., "Ljava/lang/String;")
    pub fn class_type(&self) -> Result<&str> {
        let type_idx = read_u32(self.reader.data(), self.offset);
        self.reader.get_type(type_idx)
    }

    /// Get access flags
    pub fn access_flags(&self) -> u32 {
        read_u32(self.reader.data(), self.offset + 4)
    }

    /// Get superclass type descriptor, if any
    pub fn superclass_type(&self) -> Result<Option<&str>> {
        let type_idx = read_u32(self.reader.data(), self.offset + 8);
        if type_idx == crate::NO_INDEX {
            Ok(None)
        } else {
            self.reader.get_type(type_idx).map(Some)
        }
    }

    /// Get interface type descriptors
    pub fn interfaces(&self) -> Result<Vec<&str>> {
        let interfaces_off = read_u32(self.reader.data(), self.offset + 12);
        self.reader.read_type_list(interfaces_off)
    }

    /// Get source file name, if any
    pub fn source_file(&self) -> Result<Option<&str>> {
        let str_idx = read_u32(self.reader.data(), self.offset + 16);
        if str_idx == crate::NO_INDEX {
            Ok(None)
        } else {
            self.reader.get_string(str_idx).map(Some)
        }
    }

    /// Get annotations offset
    pub fn annotations_off(&self) -> u32 {
        read_u32(self.reader.data(), self.offset + 20)
    }

    /// Get class data offset
    pub fn class_data_off(&self) -> u32 {
        read_u32(self.reader.data(), self.offset + 24)
    }

    /// Get static values offset
    pub fn static_values_off(&self) -> u32 {
        read_u32(self.reader.data(), self.offset + 28)
    }

    /// Parse the class data (fields and methods)
    pub fn class_data(&self) -> Result<Option<ClassData<'a>>> {
        let off = self.class_data_off();
        if off == 0 {
            return Ok(None);
        }
        ClassData::parse(self.reader, off as usize).map(Some)
    }
}

/// Parsed class data containing field and method counts
pub struct ClassData<'a> {
    reader: &'a DexReader,
    /// Offset to the class data
    offset: usize,
    /// Number of static fields
    pub static_fields_size: u32,
    /// Number of instance fields
    pub instance_fields_size: u32,
    /// Number of direct methods
    pub direct_methods_size: u32,
    /// Number of virtual methods
    pub virtual_methods_size: u32,
    /// Offset to field/method data (after the size fields)
    data_offset: usize,
}

impl<'a> ClassData<'a> {
    fn parse(reader: &'a DexReader, offset: usize) -> Result<Self> {
        let data = reader.data();
        let mut pos = offset;

        let (static_fields_size, len) = read_uleb128(&data[pos..])?;
        pos += len;
        let (instance_fields_size, len) = read_uleb128(&data[pos..])?;
        pos += len;
        let (direct_methods_size, len) = read_uleb128(&data[pos..])?;
        pos += len;
        let (virtual_methods_size, len) = read_uleb128(&data[pos..])?;
        pos += len;

        Ok(ClassData {
            reader,
            offset,
            static_fields_size,
            instance_fields_size,
            direct_methods_size,
            virtual_methods_size,
            data_offset: pos,
        })
    }

    /// Total number of fields
    pub fn field_count(&self) -> u32 {
        self.static_fields_size + self.instance_fields_size
    }

    /// Total number of methods
    pub fn method_count(&self) -> u32 {
        self.direct_methods_size + self.virtual_methods_size
    }

    /// Iterate over static fields
    pub fn static_fields(&self) -> FieldIterator<'a> {
        FieldIterator::new(
            self.reader,
            self.data_offset,
            self.static_fields_size as usize,
        )
    }

    /// Iterate over instance fields
    pub fn instance_fields(&self) -> FieldIterator<'a> {
        // Skip past static fields first
        let mut iter = self.static_fields();
        while iter.next().is_some() {}

        FieldIterator::new(self.reader, iter.offset, self.instance_fields_size as usize)
    }

    /// Iterate over direct methods
    pub fn direct_methods(&self) -> MethodIterator<'a> {
        // Skip past all fields
        let mut field_iter = self.instance_fields();
        while field_iter.next().is_some() {}

        MethodIterator::new(
            self.reader,
            field_iter.offset,
            self.direct_methods_size as usize,
        )
    }

    /// Iterate over virtual methods
    pub fn virtual_methods(&self) -> MethodIterator<'a> {
        // Skip past direct methods
        let mut iter = self.direct_methods();
        while iter.next().is_some() {}

        MethodIterator::new(self.reader, iter.offset, self.virtual_methods_size as usize)
    }
}

/// An encoded field in class data
#[derive(Debug)]
pub struct EncodedField {
    /// Field index (into field_ids)
    pub field_idx: u32,
    /// Access flags
    pub access_flags: u32,
}

/// Iterator over encoded fields
pub struct FieldIterator<'a> {
    reader: &'a DexReader,
    offset: usize,
    remaining: usize,
    prev_idx: u32,
}

impl<'a> FieldIterator<'a> {
    fn new(reader: &'a DexReader, offset: usize, count: usize) -> Self {
        FieldIterator {
            reader,
            offset,
            remaining: count,
            prev_idx: 0,
        }
    }
}

impl<'a> Iterator for FieldIterator<'a> {
    type Item = EncodedField;

    fn next(&mut self) -> Option<Self::Item> {
        if self.remaining == 0 {
            return None;
        }

        let data = self.reader.data();

        let (field_idx_diff, len) = read_uleb128(&data[self.offset..]).ok()?;
        self.offset += len;
        let (access_flags, len) = read_uleb128(&data[self.offset..]).ok()?;
        self.offset += len;

        self.remaining -= 1;
        self.prev_idx += field_idx_diff;

        Some(EncodedField {
            field_idx: self.prev_idx,
            access_flags,
        })
    }

    fn size_hint(&self) -> (usize, Option<usize>) {
        (self.remaining, Some(self.remaining))
    }
}

/// An encoded method in class data
#[derive(Debug)]
pub struct EncodedMethod {
    /// Method index (into method_ids)
    pub method_idx: u32,
    /// Access flags
    pub access_flags: u32,
    /// Offset to code_item (0 if no code)
    pub code_off: u32,
}

/// Iterator over encoded methods
pub struct MethodIterator<'a> {
    reader: &'a DexReader,
    offset: usize,
    remaining: usize,
    prev_idx: u32,
}

impl<'a> MethodIterator<'a> {
    fn new(reader: &'a DexReader, offset: usize, count: usize) -> Self {
        MethodIterator {
            reader,
            offset,
            remaining: count,
            prev_idx: 0,
        }
    }
}

impl<'a> Iterator for MethodIterator<'a> {
    type Item = EncodedMethod;

    fn next(&mut self) -> Option<Self::Item> {
        if self.remaining == 0 {
            return None;
        }

        let data = self.reader.data();

        let (method_idx_diff, len) = read_uleb128(&data[self.offset..]).ok()?;
        self.offset += len;
        let (access_flags, len) = read_uleb128(&data[self.offset..]).ok()?;
        self.offset += len;
        let (code_off, len) = read_uleb128(&data[self.offset..]).ok()?;
        self.offset += len;

        self.remaining -= 1;
        self.prev_idx += method_idx_diff;

        Some(EncodedMethod {
            method_idx: self.prev_idx,
            access_flags,
            code_off,
        })
    }

    fn size_hint(&self) -> (usize, Option<usize>) {
        (self.remaining, Some(self.remaining))
    }
}
