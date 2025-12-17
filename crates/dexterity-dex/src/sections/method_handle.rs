//! DEX method_handle_item and call_site_item parsing
//!
//! Method handles and call sites are used for invoke-dynamic (lambdas in Java 8+).
//! Format (method_handle_item): type (2) + unused (2) + field_or_method_id (2) + unused (2)

use crate::error::{DexError, Result};
use crate::reader::DexReader;
use super::{read_u16, EncodedValue, parse_encoded_array};

/// Method handle type (from DEX format spec)
#[derive(Debug, Clone, Copy, PartialEq, Eq)]
#[repr(u8)]
pub enum MethodHandleType {
    /// Static field put
    StaticPut = 0x00,
    /// Static field get
    StaticGet = 0x01,
    /// Instance field put
    InstancePut = 0x02,
    /// Instance field get
    InstanceGet = 0x03,
    /// Invoke static method
    InvokeStatic = 0x04,
    /// Invoke instance method (non-polymorphic)
    InvokeInstance = 0x05,
    /// Invoke constructor
    InvokeConstructor = 0x06,
    /// Invoke direct method
    InvokeDirect = 0x07,
    /// Invoke interface method
    InvokeInterface = 0x08,
}

impl MethodHandleType {
    /// Parse from u16 value
    pub fn from_u16(value: u16) -> Option<Self> {
        match value {
            0x00 => Some(Self::StaticPut),
            0x01 => Some(Self::StaticGet),
            0x02 => Some(Self::InstancePut),
            0x03 => Some(Self::InstanceGet),
            0x04 => Some(Self::InvokeStatic),
            0x05 => Some(Self::InvokeInstance),
            0x06 => Some(Self::InvokeConstructor),
            0x07 => Some(Self::InvokeDirect),
            0x08 => Some(Self::InvokeInterface),
            _ => None,
        }
    }

    /// Check if this handle type references a field (vs method)
    pub fn is_field(&self) -> bool {
        matches!(
            self,
            Self::StaticPut | Self::StaticGet | Self::InstancePut | Self::InstanceGet
        )
    }

    /// Check if this is an invocation type
    pub fn is_invoke(&self) -> bool {
        !self.is_field()
    }
}

/// A parsed method handle from the DEX file
#[derive(Debug, Clone)]
pub struct MethodHandle {
    /// Handle type
    pub handle_type: MethodHandleType,
    /// Field or method index depending on handle type
    pub field_or_method_idx: u16,
}

impl MethodHandle {
    /// Size of a method_handle_item in bytes
    pub const SIZE: usize = 8;

    /// Parse a method handle from a byte slice
    pub fn parse(data: &[u8], offset: usize) -> Result<Self> {
        if offset + Self::SIZE > data.len() {
            return Err(DexError::UnexpectedEof {
                offset,
                needed: Self::SIZE,
            });
        }

        let type_val = read_u16(data, offset);
        let handle_type = MethodHandleType::from_u16(type_val).ok_or_else(|| DexError::Parse {
            offset,
            message: format!("invalid method handle type: {}", type_val),
        })?;

        // unused at offset+2
        let field_or_method_idx = read_u16(data, offset + 4);
        // unused at offset+6

        Ok(MethodHandle {
            handle_type,
            field_or_method_idx,
        })
    }
}

/// A parsed call site from the DEX file
///
/// Call sites contain encoded values used to set up invoke-dynamic operations.
/// For lambdas, the values typically include:
/// - [0] MethodHandle for bootstrap method (LambdaMetafactory.metafactory)
/// - [1] String - method name in functional interface
/// - [2] MethodType - erased method type
/// - [3] MethodType - instantiated method type
/// - [4] MethodHandle - implementation method
/// - [5] MethodType - dynamic method type (effective signature)
#[derive(Debug, Clone)]
pub struct CallSite {
    /// The encoded values making up this call site
    pub values: Vec<EncodedValue>,
}

impl CallSite {
    /// Parse a call site from the DEX file
    ///
    /// call_site_id_item points to an encoded_array_item offset
    pub fn parse(reader: &DexReader, call_site_idx: u32) -> Result<Self> {
        let data = reader.data();

        // Get the call_site_off from header
        let call_site_off = reader.header.call_site_off.ok_or_else(|| DexError::Parse {
            offset: 0,
            message: "DEX file has no call_site section".to_string(),
        })?;

        // call_site_id_item is just a u32 offset to encoded_array_item
        let id_offset = call_site_off as usize + (call_site_idx as usize * 4);
        if id_offset + 4 > data.len() {
            return Err(DexError::UnexpectedEof {
                offset: id_offset,
                needed: 4,
            });
        }

        let array_offset = u32::from_le_bytes([
            data[id_offset],
            data[id_offset + 1],
            data[id_offset + 2],
            data[id_offset + 3],
        ]) as usize;

        // Parse the encoded array
        let (values, _) = parse_encoded_array(data, array_offset)?;

        Ok(CallSite { values })
    }

    /// Check if this call site is a lambda invocation (uses LambdaMetafactory)
    pub fn is_lambda_invoke(&self) -> bool {
        if self.values.len() < 6 {
            return false;
        }

        // First value should be a MethodHandle for the bootstrap method
        if let EncodedValue::MethodHandle(_) = &self.values[0] {
            // We can't easily check if it's LambdaMetafactory without resolving
            // the method handle, so we'll just assume it is for now if it has
            // the right structure (6+ values with method handle first)
            true
        } else {
            false
        }
    }

    /// Get the implementation method handle index (for lambdas)
    /// This is typically at index 4 in the call site values
    pub fn get_impl_method_handle(&self) -> Option<u32> {
        if self.values.len() > 4 {
            if let EncodedValue::MethodHandle(idx) = &self.values[4] {
                return Some(*idx);
            }
        }
        None
    }

    /// Get the interface method name (for lambdas)
    /// This is typically at index 1 in the call site values
    pub fn get_method_name(&self) -> Option<u32> {
        if self.values.len() > 1 {
            if let EncodedValue::String(idx) = &self.values[1] {
                return Some(*idx);
            }
        }
        None
    }
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn test_method_handle_type() {
        assert!(MethodHandleType::StaticGet.is_field());
        assert!(MethodHandleType::InstancePut.is_field());
        assert!(MethodHandleType::InvokeStatic.is_invoke());
        assert!(MethodHandleType::InvokeConstructor.is_invoke());
    }

    #[test]
    fn test_method_handle_parse() {
        // type=InvokeStatic(4), unused, method_idx=42, unused
        let data = [0x04, 0x00, 0x00, 0x00, 0x2a, 0x00, 0x00, 0x00];
        let handle = MethodHandle::parse(&data, 0).unwrap();
        assert_eq!(handle.handle_type, MethodHandleType::InvokeStatic);
        assert_eq!(handle.field_or_method_idx, 42);
    }
}
