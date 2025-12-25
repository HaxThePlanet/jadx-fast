//! File type detection by magic bytes and content
//!
//! JADX Reference: jadx-core/src/main/java/jadx/core/deobf/FileTypeDetector.java
//! Cloned from JADX's FileTypeDetector class exactly.
//!
//! Detects file extensions from binary content using:
//! 1. Magic byte signatures (PNG, JPG, MP4, etc.)
//! 2. Text content patterns (certificates, HTML, XML)
//!
//! File signatures are identical to JADX's static initializer block.

use lazy_static::lazy_static;
use regex::Regex;

/// A file signature pattern for magic byte detection
struct FileSignature {
    file_type: &'static str,
    /// Pattern bytes - None means wildcard (match any byte)
    pattern: Vec<Option<u8>>,
}

impl FileSignature {
    /// Create from hex string like "89 50 4E 47" or "00 00 00 ?? 66 74 79 70"
    fn from_hex(file_type: &'static str, hex: &str) -> Self {
        let pattern = hex
            .split_whitespace()
            .map(|b| {
                if b == "??" {
                    None // Wildcard
                } else {
                    Some(u8::from_str_radix(b, 16).expect("Invalid hex byte"))
                }
            })
            .collect();
        Self { file_type, pattern }
    }

    /// Check if data matches this signature
    fn matches(&self, data: &[u8]) -> bool {
        if data.len() < self.pattern.len() {
            return false;
        }
        for (i, expected) in self.pattern.iter().enumerate() {
            if let Some(byte) = expected {
                if data[i] != *byte {
                    return false;
                }
            }
            // None = wildcard, matches any byte
        }
        true
    }
}

lazy_static! {
    /// JADX Reference: FileTypeDetector static initializer
    static ref FILE_SIGNATURES: Vec<FileSignature> = vec![
        // Images
        FileSignature::from_hex("png", "89 50 4E 47"),
        FileSignature::from_hex("jpg", "FF D8 FF"),
        FileSignature::from_hex("gif", "47 49 46 38"),
        FileSignature::from_hex("webp", "52 49 46 46 ?? ?? ?? ?? 57 45 42 50 56 50 38"),
        FileSignature::from_hex("bmp", "42 4D"),
        FileSignature::from_hex("bmp", "42 41"),
        FileSignature::from_hex("bmp", "43 49"),
        FileSignature::from_hex("bmp", "43 50"),
        FileSignature::from_hex("bmp", "49 43"),
        FileSignature::from_hex("bmp", "50 54"),
        // Video/Audio
        FileSignature::from_hex("mp4", "00 00 00 ?? 66 74 79 70 69 73 6F 36"),
        FileSignature::from_hex("mp4", "00 00 00 ?? 66 74 79 70 6D 70 34 32"),
        FileSignature::from_hex("m4a", "00 00 00 ?? 66 74 79 70 4D 34 41 20"),
        FileSignature::from_hex("mp3", "49 44 33"),
        FileSignature::from_hex("ogg", "4F 67 67 53"),
        FileSignature::from_hex("wav", "52 49 46 46 ?? ?? ?? ?? 57 41 56 45"),
        // Fonts
        FileSignature::from_hex("ttf", "00 01 00 00"),
        FileSignature::from_hex("ttc", "74 74 63 66"),
        FileSignature::from_hex("otf", "4F 54 54 4F"),
        // Android binary XML
        FileSignature::from_hex("xml", "03 00 08 00"),
    ];

    /// DOCTYPE pattern for HTML/XML detection
    /// JADX Reference: FileTypeDetector.DOCTYPE_PATTERN
    static ref DOCTYPE_PATTERN: Regex = Regex::new(r"(?i)^\s*<!doctype\s*(\w+)[\s>]").unwrap();
}

/// Read a big-endian 32-bit integer from data
///
/// JADX Reference: FileTypeDetector.readInt()
fn read_int(data: &[u8], offset: usize) -> u32 {
    if offset + 4 > data.len() {
        return 0;
    }
    ((data[offset] as u32) << 24)
        | ((data[offset + 1] as u32) << 16)
        | ((data[offset + 2] as u32) << 8)
        | (data[offset + 3] as u32)
}

/// Check if PNG data is a 9-patch image
///
/// JADX Reference: FileTypeDetector.isNinePatch()
/// 9-patch PNGs have an 'npTc' chunk (0x6e705463)
fn is_nine_patch(data: &[u8]) -> bool {
    let mut offset = 8; // Skip PNG signature
    while offset + 8 < data.len() {
        let chunk_length = read_int(data, offset) as usize;
        let chunk_type = read_int(data, offset + 4);
        if chunk_type == 0x6e705463 {
            // 'npTc'
            return true;
        }
        offset += 8 + chunk_length + 4; // chunk header + data + CRC
    }
    false
}

/// Detect file extension by magic byte headers
///
/// JADX Reference: FileTypeDetector.detectByHeaders()
fn detect_by_headers(data: &[u8]) -> Option<&'static str> {
    for sig in FILE_SIGNATURES.iter() {
        if sig.matches(data) {
            if sig.file_type == "png" && is_nine_patch(data) {
                return Some(".9.png");
            }
            return Some(match sig.file_type {
                "png" => ".png",
                "jpg" => ".jpg",
                "gif" => ".gif",
                "webp" => ".webp",
                "bmp" => ".bmp",
                "mp4" => ".mp4",
                "m4a" => ".m4a",
                "mp3" => ".mp3",
                "ogg" => ".ogg",
                "wav" => ".wav",
                "ttf" => ".ttf",
                "ttc" => ".ttc",
                "otf" => ".otf",
                "xml" => ".xml",
                _ => {
                    // Unknown file type - return None for caller to handle
                    return None;
                }
            });
        }
    }
    None
}

/// Detect file extension from binary data
///
/// JADX Reference: FileTypeDetector.detectFileExtension()
///
/// Detection order:
/// 1. Magic byte signatures
/// 2. Text content patterns (certificates, HTML)
/// 3. DOCTYPE declarations
/// 4. XML root element names
pub fn detect_file_extension(data: &[u8]) -> Option<&'static str> {
    // 1. Detect by magic headers
    if let Some(ext) = detect_by_headers(data) {
        return Some(ext);
    }

    // 2. Try to parse as UTF-8 text
    if let Ok(text) = std::str::from_utf8(data) {
        // Certificate detection
        if text.starts_with("-----BEGIN CERTIFICATE-----") {
            return Some(".cer");
        }
        if text.starts_with("-----BEGIN PRIVATE KEY-----") {
            return Some(".key");
        }

        // HTML detection
        if text.to_lowercase().contains("<html>") {
            return Some(".html");
        }

        // DOCTYPE detection
        if let Some(caps) = DOCTYPE_PATTERN.captures(text) {
            if let Some(doctype) = caps.get(1) {
                let dt = doctype.as_str().to_lowercase();
                return match dt.as_str() {
                    "html" => Some(".html"),
                    "svg" => Some(".svg"),
                    "xml" => Some(".xml"),
                    _ => Some(".xml"), // Default to XML for unknown doctypes
                };
            }
        }

        // XML root element detection (simple heuristic)
        if text.trim_start().starts_with("<?xml") || text.trim_start().starts_with("<") {
            let trimmed = text.trim_start();
            // Check for common XML types by root element
            if trimmed.contains("<svg") {
                return Some(".svg");
            }
            if trimmed.contains("<plist") {
                return Some(".plist");
            }
            if trimmed.contains("<kml") {
                return Some(".kml");
            }
            // Generic XML
            if trimmed.starts_with("<?xml") || trimmed.starts_with("<") {
                return Some(".xml");
            }
        }
    }

    None
}

/// Get a descriptive file type name for logging
pub fn get_file_type_name(extension: &str) -> &'static str {
    match extension {
        ".png" | ".9.png" => "PNG image",
        ".jpg" => "JPEG image",
        ".gif" => "GIF image",
        ".webp" => "WebP image",
        ".bmp" => "BMP image",
        ".mp4" => "MP4 video",
        ".m4a" => "M4A audio",
        ".mp3" => "MP3 audio",
        ".ogg" => "OGG audio",
        ".wav" => "WAV audio",
        ".ttf" => "TrueType font",
        ".ttc" => "TrueType collection",
        ".otf" => "OpenType font",
        ".xml" => "XML document",
        ".html" => "HTML document",
        ".svg" => "SVG image",
        ".plist" => "Property list",
        ".kml" => "KML document",
        ".cer" => "Certificate",
        ".key" => "Private key",
        _ => "Unknown",
    }
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn test_png_detection() {
        // PNG magic bytes: 89 50 4E 47
        let png_data = [0x89, 0x50, 0x4E, 0x47, 0x0D, 0x0A, 0x1A, 0x0A];
        assert_eq!(detect_file_extension(&png_data), Some(".png"));
    }

    #[test]
    fn test_jpg_detection() {
        // JPEG magic bytes: FF D8 FF
        let jpg_data = [0xFF, 0xD8, 0xFF, 0xE0, 0x00, 0x10];
        assert_eq!(detect_file_extension(&jpg_data), Some(".jpg"));
    }

    #[test]
    fn test_gif_detection() {
        // GIF magic: GIF8
        let gif_data = b"GIF89a";
        assert_eq!(detect_file_extension(gif_data), Some(".gif"));
    }

    #[test]
    fn test_mp3_detection() {
        // MP3 ID3 tag
        let mp3_data = b"ID3\x04\x00\x00";
        assert_eq!(detect_file_extension(mp3_data), Some(".mp3"));
    }

    #[test]
    fn test_certificate_detection() {
        let cert_data = b"-----BEGIN CERTIFICATE-----\nMIIC...";
        assert_eq!(detect_file_extension(cert_data), Some(".cer"));
    }

    #[test]
    fn test_html_detection() {
        let html_data = b"<!DOCTYPE html>\n<html>\n<head>";
        assert_eq!(detect_file_extension(html_data), Some(".html"));
    }

    #[test]
    fn test_xml_detection() {
        let xml_data = b"<?xml version=\"1.0\"?>\n<root>";
        assert_eq!(detect_file_extension(xml_data), Some(".xml"));
    }

    #[test]
    fn test_svg_detection() {
        let svg_data = b"<?xml version=\"1.0\"?>\n<svg xmlns=\"http://www.w3.org/2000/svg\">";
        assert_eq!(detect_file_extension(svg_data), Some(".svg"));
    }

    #[test]
    fn test_android_binary_xml() {
        // Android binary XML magic: 03 00 08 00
        let axml_data = [0x03, 0x00, 0x08, 0x00, 0x00, 0x00];
        assert_eq!(detect_file_extension(&axml_data), Some(".xml"));
    }

    #[test]
    fn test_unknown_data() {
        let random_data = [0x00, 0x01, 0x02, 0x03];
        assert_eq!(detect_file_extension(&random_data), None);
    }

    #[test]
    fn test_file_type_name() {
        assert_eq!(get_file_type_name(".png"), "PNG image");
        assert_eq!(get_file_type_name(".9.png"), "PNG image");
        assert_eq!(get_file_type_name(".mp4"), "MP4 video");
        assert_eq!(get_file_type_name(".ttf"), "TrueType font");
        assert_eq!(get_file_type_name(".unknown"), "Unknown");
    }
}
