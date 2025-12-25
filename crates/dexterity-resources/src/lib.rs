//! Android resource decoding for dexterity
//!
//! This crate provides parsers for Android binary resource formats:
//! - **AXML**: Binary XML format used for AndroidManifest.xml and compiled layouts
//! - **ARSC**: Compiled resource table (resources.arsc)
//!
//! ## Binary XML (AXML)
//!
//! Android compiles XML files into a binary format for efficiency. This includes:
//! - AndroidManifest.xml
//! - Layout files (res/layout/*.xml)
//! - Other XML resources
//!
//! ```rust,ignore
//! use dexterity_resources::AxmlParser;
//!
//! let data = std::fs::read("AndroidManifest.xml")?;
//! let mut parser = AxmlParser::new();
//! let xml = parser.parse(&data)?;
//! println!("{}", xml);
//! ```
//!
//! ## Resource Table (ARSC)
//!
//! The resources.arsc file contains:
//! - String pools for all resource strings
//! - Resource ID mappings (R.layout.activity_main -> actual file)
//! - Configuration-specific resource variants (hdpi, en-US, etc.)
//!
//! ```rust,ignore
//! use dexterity_resources::ArscParser;
//!
//! let data = std::fs::read("resources.arsc")?;
//! let mut parser = ArscParser::new();
//! parser.parse(&data)?;
//!
//! // Get resource names for use with AXML parsing
//! let res_names = parser.get_res_names();
//! ```

pub mod axml;
pub mod arsc;
pub mod constants;
pub mod android_res_map;
mod string_pool;
mod error;

pub use axml::AxmlParser;
pub use arsc::ArscParser;
pub use android_res_map::{ANDROID_RES_MAP, ANDROID_ATTR_MAP, get_android_res_name, get_android_attr_name};
pub use error::{ResourceError, Result};
