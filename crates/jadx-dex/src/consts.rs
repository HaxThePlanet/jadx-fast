//! DEX format constants

/// DEX header size in bytes
pub const HEADER_SIZE: usize = 112;

/// Known DEX versions
pub mod versions {
    pub const DEX_035: &[u8; 3] = b"035";
    pub const DEX_037: &[u8; 3] = b"037";
    pub const DEX_038: &[u8; 3] = b"038";
    pub const DEX_039: &[u8; 3] = b"039";
    pub const DEX_040: &[u8; 3] = b"040";
    pub const DEX_041: &[u8; 3] = b"041";
}

/// Access flags for classes, methods, and fields
pub mod access_flags {
    pub const ACC_PUBLIC: u32 = 0x0001;
    pub const ACC_PRIVATE: u32 = 0x0002;
    pub const ACC_PROTECTED: u32 = 0x0004;
    pub const ACC_STATIC: u32 = 0x0008;
    pub const ACC_FINAL: u32 = 0x0010;
    pub const ACC_SYNCHRONIZED: u32 = 0x0020;
    pub const ACC_VOLATILE: u32 = 0x0040;
    pub const ACC_BRIDGE: u32 = 0x0040;
    pub const ACC_TRANSIENT: u32 = 0x0080;
    pub const ACC_VARARGS: u32 = 0x0080;
    pub const ACC_NATIVE: u32 = 0x0100;
    pub const ACC_INTERFACE: u32 = 0x0200;
    pub const ACC_ABSTRACT: u32 = 0x0400;
    pub const ACC_STRICT: u32 = 0x0800;
    pub const ACC_SYNTHETIC: u32 = 0x1000;
    pub const ACC_ANNOTATION: u32 = 0x2000;
    pub const ACC_ENUM: u32 = 0x4000;
    pub const ACC_CONSTRUCTOR: u32 = 0x10000;
    pub const ACC_DECLARED_SYNCHRONIZED: u32 = 0x20000;
}

/// Type codes used in encoded values
pub mod type_codes {
    pub const VALUE_BYTE: u8 = 0x00;
    pub const VALUE_SHORT: u8 = 0x02;
    pub const VALUE_CHAR: u8 = 0x03;
    pub const VALUE_INT: u8 = 0x04;
    pub const VALUE_LONG: u8 = 0x06;
    pub const VALUE_FLOAT: u8 = 0x10;
    pub const VALUE_DOUBLE: u8 = 0x11;
    pub const VALUE_METHOD_TYPE: u8 = 0x15;
    pub const VALUE_METHOD_HANDLE: u8 = 0x16;
    pub const VALUE_STRING: u8 = 0x17;
    pub const VALUE_TYPE: u8 = 0x18;
    pub const VALUE_FIELD: u8 = 0x19;
    pub const VALUE_METHOD: u8 = 0x1a;
    pub const VALUE_ENUM: u8 = 0x1b;
    pub const VALUE_ARRAY: u8 = 0x1c;
    pub const VALUE_ANNOTATION: u8 = 0x1d;
    pub const VALUE_NULL: u8 = 0x1e;
    pub const VALUE_BOOLEAN: u8 = 0x1f;
}

/// Map item types
pub mod map_types {
    pub const TYPE_HEADER_ITEM: u16 = 0x0000;
    pub const TYPE_STRING_ID_ITEM: u16 = 0x0001;
    pub const TYPE_TYPE_ID_ITEM: u16 = 0x0002;
    pub const TYPE_PROTO_ID_ITEM: u16 = 0x0003;
    pub const TYPE_FIELD_ID_ITEM: u16 = 0x0004;
    pub const TYPE_METHOD_ID_ITEM: u16 = 0x0005;
    pub const TYPE_CLASS_DEF_ITEM: u16 = 0x0006;
    pub const TYPE_CALL_SITE_ID_ITEM: u16 = 0x0007;
    pub const TYPE_METHOD_HANDLE_ITEM: u16 = 0x0008;
    pub const TYPE_MAP_LIST: u16 = 0x1000;
    pub const TYPE_TYPE_LIST: u16 = 0x1001;
    pub const TYPE_ANNOTATION_SET_REF_LIST: u16 = 0x1002;
    pub const TYPE_ANNOTATION_SET_ITEM: u16 = 0x1003;
    pub const TYPE_CLASS_DATA_ITEM: u16 = 0x2000;
    pub const TYPE_CODE_ITEM: u16 = 0x2001;
    pub const TYPE_STRING_DATA_ITEM: u16 = 0x2002;
    pub const TYPE_DEBUG_INFO_ITEM: u16 = 0x2003;
    pub const TYPE_ANNOTATION_ITEM: u16 = 0x2004;
    pub const TYPE_ENCODED_ARRAY_ITEM: u16 = 0x2005;
    pub const TYPE_ANNOTATIONS_DIRECTORY_ITEM: u16 = 0x2006;
    pub const TYPE_HIDDENAPI_CLASS_DATA_ITEM: u16 = 0xF000;
}
