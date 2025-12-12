//! Modified UTF-8 (MUTF-8) decoding
//!
//! DEX files use a modified UTF-8 encoding where:
//! - NULL (U+0000) is encoded as C0 80 (two bytes)
//! - Supplementary characters (> U+FFFF) use surrogate pairs

use crate::error::{DexError, Result};

/// Decode a MUTF-8 encoded string
pub fn decode_mutf8(data: &[u8]) -> Result<String> {
    let mut result = String::with_capacity(data.len());
    let mut i = 0;

    while i < data.len() {
        let b1 = data[i];

        if b1 == 0 {
            // End of string (null terminator in DEX)
            break;
        } else if b1 < 0x80 {
            // Single byte (ASCII)
            result.push(b1 as char);
            i += 1;
        } else if b1 & 0xE0 == 0xC0 {
            // Two-byte sequence
            if i + 1 >= data.len() {
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
            i += 2;
        } else if b1 & 0xF0 == 0xE0 {
            // Three-byte sequence
            if i + 2 >= data.len() {
                return Err(DexError::InvalidMutf8);
            }
            let b2 = data[i + 1];
            let b3 = data[i + 2];
            if (b2 & 0xC0 != 0x80) || (b3 & 0xC0 != 0x80) {
                return Err(DexError::InvalidMutf8);
            }

            let code_point = ((b1 as u32 & 0x0F) << 12)
                | ((b2 as u32 & 0x3F) << 6)
                | (b3 as u32 & 0x3F);

            // Check for surrogate pairs (MUTF-8 uses UTF-16 surrogates for > U+FFFF)
            if (0xD800..=0xDBFF).contains(&code_point) {
                // High surrogate - look for low surrogate
                if i + 5 >= data.len() {
                    return Err(DexError::InvalidMutf8);
                }
                let b4 = data[i + 3];
                let b5 = data[i + 4];
                let b6 = data[i + 5];

                if b4 & 0xF0 != 0xE0 || b5 & 0xC0 != 0x80 || b6 & 0xC0 != 0x80 {
                    return Err(DexError::InvalidMutf8);
                }

                let low_surrogate = ((b4 as u32 & 0x0F) << 12)
                    | ((b5 as u32 & 0x3F) << 6)
                    | (b6 as u32 & 0x3F);

                if !(0xDC00..=0xDFFF).contains(&low_surrogate) {
                    return Err(DexError::InvalidMutf8);
                }

                // Combine surrogates into supplementary character
                let supplementary = 0x10000
                    + ((code_point - 0xD800) << 10)
                    + (low_surrogate - 0xDC00);

                if let Some(c) = char::from_u32(supplementary) {
                    result.push(c);
                } else {
                    return Err(DexError::InvalidMutf8);
                }
                i += 6;
            } else if let Some(c) = char::from_u32(code_point) {
                result.push(c);
                i += 3;
            } else {
                return Err(DexError::InvalidMutf8);
            }
        } else {
            return Err(DexError::InvalidMutf8);
        }
    }

    Ok(result)
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
}
