//! Modified UTF-8 (MUTF-8) decoding
//!
//! DEX files use a modified UTF-8 encoding where:
//! - NULL (U+0000) is encoded as C0 80 (two bytes)
//! - Supplementary characters (> U+FFFF) use surrogate pairs
//!
//! This implementation uses SIMD-like techniques for fast ASCII detection,
//! processing 8 bytes at a time when possible.

use crate::error::{DexError, Result};

/// Mask to detect high bits in a u64 (indicates non-ASCII or null)
const HIGH_BITS_MASK: u64 = 0x8080_8080_8080_8080;

/// Find the position of the first byte with high bit set or null byte in a u64
/// Returns 8 if all bytes are ASCII (0x01-0x7F)
#[inline(always)]
fn find_non_ascii_or_null(chunk: u64) -> usize {
    // Detect bytes with high bit set (non-ASCII: >= 0x80)
    let high_bits = chunk & HIGH_BITS_MASK;

    // Detect null bytes using the classic null-byte detection trick:
    // For each byte b: (b - 1) & !b & 0x80 is non-zero iff b == 0
    let null_test = chunk.wrapping_sub(0x0101_0101_0101_0101) & !chunk & HIGH_BITS_MASK;

    // Combine: we want to stop at either high bit or null
    let stop_mask = high_bits | null_test;

    if stop_mask == 0 {
        8 // All 8 bytes are valid ASCII (0x01-0x7F)
    } else {
        // Find first set bit position, divide by 8 to get byte index
        (stop_mask.to_le().trailing_zeros() / 8) as usize
    }
}

/// Decode a MUTF-8 encoded string
///
/// Uses fast-path SIMD-like processing for ASCII sequences (90%+ of DEX strings)
pub fn decode_mutf8(data: &[u8]) -> Result<String> {
    let mut result = String::with_capacity(data.len());
    let mut i = 0;
    let len = data.len();

    // Fast path: process 8 bytes at a time for ASCII sequences
    while i + 8 <= len {
        // Load 8 bytes as u64 (little-endian for x86, handled correctly on all platforms)
        let chunk = u64::from_ne_bytes([
            data[i], data[i + 1], data[i + 2], data[i + 3],
            data[i + 4], data[i + 5], data[i + 6], data[i + 7],
        ]);

        let ascii_len = find_non_ascii_or_null(chunk);

        if ascii_len > 0 {
            // Safety: we verified these are valid ASCII bytes (0x01-0x7F)
            // ASCII is always valid UTF-8
            let ascii_slice = unsafe {
                std::str::from_utf8_unchecked(&data[i..i + ascii_len])
            };
            result.push_str(ascii_slice);
            i += ascii_len;
        }

        if ascii_len < 8 {
            // Hit a non-ASCII byte or null, switch to scalar processing for this byte
            if i >= len {
                break;
            }
            let b1 = data[i];
            if b1 == 0 {
                break; // Null terminator
            }
            i = decode_multibyte(&data, i, &mut result)?;
        }
    }

    // Scalar tail: process remaining bytes one at a time
    while i < len {
        let b1 = data[i];

        if b1 == 0 {
            // End of string (null terminator in DEX)
            break;
        } else if b1 < 0x80 {
            // Single byte (ASCII)
            result.push(b1 as char);
            i += 1;
        } else {
            i = decode_multibyte(&data, i, &mut result)?;
        }
    }

    Ok(result)
}

/// Decode a multi-byte MUTF-8 sequence starting at position i
/// Returns the new position after the sequence
#[inline]
fn decode_multibyte(data: &[u8], i: usize, result: &mut String) -> Result<usize> {
    let b1 = data[i];
    let len = data.len();

    if b1 & 0xE0 == 0xC0 {
        // Two-byte sequence
        if i + 1 >= len {
            return Err(DexError::InvalidMutf8);
        }
        let b2 = data[i + 1];
        if b2 & 0xC0 != 0x80 {
            return Err(DexError::InvalidMutf8);
        }

        let code_point = ((b1 as u32 & 0x1F) << 6) | (b2 as u32 & 0x3F);

        // Handle MUTF-8 null encoding (C0 80 = U+0000)
        if code_point == 0 && b1 == 0xC0 && b2 == 0x80 {
            result.push('\0');
        } else if let Some(c) = char::from_u32(code_point) {
            result.push(c);
        } else {
            return Err(DexError::InvalidMutf8);
        }
        Ok(i + 2)
    } else if b1 & 0xF0 == 0xE0 {
        // Three-byte sequence
        if i + 2 >= len {
            return Err(DexError::InvalidMutf8);
        }
        let b2 = data[i + 1];
        let b3 = data[i + 2];
        if (b2 & 0xC0 != 0x80) || (b3 & 0xC0 != 0x80) {
            return Err(DexError::InvalidMutf8);
        }

        let code_point =
            ((b1 as u32 & 0x0F) << 12) | ((b2 as u32 & 0x3F) << 6) | (b3 as u32 & 0x3F);

        // Check for surrogate pairs (MUTF-8 uses UTF-16 surrogates for > U+FFFF)
        if (0xD800..=0xDBFF).contains(&code_point) {
            // High surrogate - look for low surrogate
            if i + 5 >= len {
                return Err(DexError::InvalidMutf8);
            }
            let b4 = data[i + 3];
            let b5 = data[i + 4];
            let b6 = data[i + 5];

            if b4 & 0xF0 != 0xE0 || b5 & 0xC0 != 0x80 || b6 & 0xC0 != 0x80 {
                return Err(DexError::InvalidMutf8);
            }

            let low_surrogate =
                ((b4 as u32 & 0x0F) << 12) | ((b5 as u32 & 0x3F) << 6) | (b6 as u32 & 0x3F);

            if !(0xDC00..=0xDFFF).contains(&low_surrogate) {
                return Err(DexError::InvalidMutf8);
            }

            // Combine surrogates into supplementary character
            let supplementary =
                0x10000 + ((code_point - 0xD800) << 10) + (low_surrogate - 0xDC00);

            if let Some(c) = char::from_u32(supplementary) {
                result.push(c);
            } else {
                return Err(DexError::InvalidMutf8);
            }
            Ok(i + 6)
        } else if let Some(c) = char::from_u32(code_point) {
            result.push(c);
            Ok(i + 3)
        } else {
            Err(DexError::InvalidMutf8)
        }
    } else {
        Err(DexError::InvalidMutf8)
    }
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn test_ascii() {
        assert_eq!(decode_mutf8(b"Hello").unwrap(), "Hello");
        assert_eq!(decode_mutf8(b"").unwrap(), "");
    }

    #[test]
    fn test_ascii_long() {
        // Test SIMD path with long ASCII string (>8 bytes)
        let input = b"HelloWorld123456789";
        assert_eq!(decode_mutf8(input).unwrap(), "HelloWorld123456789");
    }

    #[test]
    fn test_ascii_exactly_8() {
        // Exactly 8 bytes - one full SIMD iteration
        assert_eq!(decode_mutf8(b"12345678").unwrap(), "12345678");
    }

    #[test]
    fn test_ascii_16_bytes() {
        // 16 bytes - two full SIMD iterations
        assert_eq!(decode_mutf8(b"1234567890ABCDEF").unwrap(), "1234567890ABCDEF");
    }

    #[test]
    fn test_ascii_mixed_with_multibyte() {
        // ASCII followed by multibyte then ASCII
        let mut input = b"Hello".to_vec();
        input.extend_from_slice(&[0xC2, 0xA9]); // ©
        input.extend_from_slice(b"World");
        assert_eq!(decode_mutf8(&input).unwrap(), "Hello©World");
    }

    #[test]
    fn test_null_encoding() {
        // MUTF-8 null is C0 80
        assert_eq!(decode_mutf8(&[0xC0, 0x80]).unwrap(), "\0");
    }

    #[test]
    fn test_two_byte() {
        // U+00A9 (copyright) = C2 A9
        assert_eq!(decode_mutf8(&[0xC2, 0xA9]).unwrap(), "\u{00A9}");
    }

    #[test]
    fn test_three_byte() {
        // U+20AC (euro) = E2 82 AC
        assert_eq!(decode_mutf8(&[0xE2, 0x82, 0xAC]).unwrap(), "\u{20AC}");
    }

    #[test]
    fn test_null_terminated() {
        assert_eq!(decode_mutf8(b"test\0extra").unwrap(), "test");
    }

    #[test]
    fn test_null_in_simd_range() {
        // Null byte within SIMD processing range
        assert_eq!(decode_mutf8(b"1234\0678").unwrap(), "1234");
    }

    #[test]
    fn test_typical_class_name() {
        // Typical Java class name (common in DEX)
        let input = b"Lcom/example/MyClass;";
        assert_eq!(decode_mutf8(input).unwrap(), "Lcom/example/MyClass;");
    }

    #[test]
    fn test_typical_method_signature() {
        // Typical method signature (common in DEX)
        let input = b"(Ljava/lang/String;I)V";
        assert_eq!(decode_mutf8(input).unwrap(), "(Ljava/lang/String;I)V");
    }
}
