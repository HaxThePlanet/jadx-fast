//! LEB128 (Little Endian Base 128) encoding utilities
//!
//! DEX files use LEB128 encoding for variable-length integers to save space.

use crate::error::{DexError, Result};

/// Read an unsigned LEB128 value from a byte slice
///
/// Returns the decoded value and the number of bytes consumed
pub fn read_uleb128(data: &[u8]) -> Result<(u32, usize)> {
    let mut result: u32 = 0;
    let mut shift: u32 = 0;
    let mut bytes_read = 0;

    loop {
        if bytes_read >= data.len() {
            return Err(DexError::InvalidLeb128);
        }
        if bytes_read >= 5 {
            return Err(DexError::InvalidLeb128);
        }

        let byte = data[bytes_read];
        bytes_read += 1;

        result |= ((byte & 0x7F) as u32) << shift;

        if byte & 0x80 == 0 {
            break;
        }

        shift += 7;
    }

    Ok((result, bytes_read))
}

/// Read an unsigned LEB128 value plus 1 (used for optional indices)
///
/// A value of 0 encodes to -1 (NO_INDEX), otherwise value encodes to value-1
pub fn read_uleb128p1(data: &[u8]) -> Result<(i32, usize)> {
    let (value, bytes_read) = read_uleb128(data)?;
    Ok((value as i32 - 1, bytes_read))
}

/// Read a signed LEB128 value from a byte slice
///
/// Returns the decoded value and the number of bytes consumed
pub fn read_sleb128(data: &[u8]) -> Result<(i32, usize)> {
    let mut result: i32 = 0;
    let mut shift: u32 = 0;
    let mut bytes_read = 0;
    let mut byte: u8;

    loop {
        if bytes_read >= data.len() {
            return Err(DexError::InvalidLeb128);
        }
        if bytes_read >= 5 {
            return Err(DexError::InvalidLeb128);
        }

        byte = data[bytes_read];
        bytes_read += 1;

        result |= ((byte & 0x7F) as i32) << shift;
        shift += 7;

        if byte & 0x80 == 0 {
            break;
        }
    }

    // Sign extend if necessary
    if shift < 32 && (byte & 0x40) != 0 {
        result |= !0 << shift;
    }

    Ok((result, bytes_read))
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn test_uleb128_single_byte() {
        assert_eq!(read_uleb128(&[0x00]).unwrap(), (0, 1));
        assert_eq!(read_uleb128(&[0x01]).unwrap(), (1, 1));
        assert_eq!(read_uleb128(&[0x7F]).unwrap(), (127, 1));
    }

    #[test]
    fn test_uleb128_multi_byte() {
        assert_eq!(read_uleb128(&[0x80, 0x01]).unwrap(), (128, 2));
        assert_eq!(read_uleb128(&[0xFF, 0x01]).unwrap(), (255, 2));
        assert_eq!(read_uleb128(&[0x80, 0x80, 0x01]).unwrap(), (16384, 3));
    }

    #[test]
    fn test_sleb128_positive() {
        assert_eq!(read_sleb128(&[0x00]).unwrap(), (0, 1));
        assert_eq!(read_sleb128(&[0x01]).unwrap(), (1, 1));
        assert_eq!(read_sleb128(&[0x3F]).unwrap(), (63, 1));
    }

    #[test]
    fn test_sleb128_negative() {
        assert_eq!(read_sleb128(&[0x7F]).unwrap(), (-1, 1));
        assert_eq!(read_sleb128(&[0x40]).unwrap(), (-64, 1));
        assert_eq!(read_sleb128(&[0x80, 0x7F]).unwrap(), (-128, 2));
    }

    #[test]
    fn test_uleb128p1() {
        assert_eq!(read_uleb128p1(&[0x00]).unwrap(), (-1, 1)); // NO_INDEX
        assert_eq!(read_uleb128p1(&[0x01]).unwrap(), (0, 1));
        assert_eq!(read_uleb128p1(&[0x02]).unwrap(), (1, 1));
    }
}
