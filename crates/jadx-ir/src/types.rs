//! Type representation

/// Argument/variable type representation
#[derive(Debug, Clone, PartialEq, Eq, Hash)]
pub enum ArgType {
    /// Primitive types
    Void,
    Boolean,
    Byte,
    Char,
    Short,
    Int,
    Long,
    Float,
    Double,

    /// Object type (class reference)
    Object(String),

    /// Array type
    Array(Box<ArgType>),

    /// Generic type with parameters
    Generic {
        base: String,
        params: Vec<ArgType>,
    },

    /// Wildcard type (? extends T, ? super T)
    Wildcard {
        bound: WildcardBound,
        inner: Option<Box<ArgType>>,
    },

    /// Unknown type (for type inference)
    Unknown,
}

/// Wildcard bound direction
#[derive(Debug, Clone, Copy, PartialEq, Eq, Hash)]
pub enum WildcardBound {
    /// Unbounded (?)
    Unbounded,
    /// Upper bound (? extends T)
    Extends,
    /// Lower bound (? super T)
    Super,
}

impl ArgType {
    /// Create an object type from a descriptor
    pub fn object(descriptor: impl Into<String>) -> Self {
        ArgType::Object(descriptor.into())
    }

    /// Create an array type
    pub fn array(element: ArgType) -> Self {
        ArgType::Array(Box::new(element))
    }

    /// Check if this is a primitive type
    pub fn is_primitive(&self) -> bool {
        matches!(
            self,
            ArgType::Void
                | ArgType::Boolean
                | ArgType::Byte
                | ArgType::Char
                | ArgType::Short
                | ArgType::Int
                | ArgType::Long
                | ArgType::Float
                | ArgType::Double
        )
    }

    /// Check if this is a wide type (64-bit: long, double)
    pub fn is_wide(&self) -> bool {
        matches!(self, ArgType::Long | ArgType::Double)
    }

    /// Check if this is an object or array type
    pub fn is_object(&self) -> bool {
        matches!(self, ArgType::Object(_) | ArgType::Array(_))
    }

    /// Parse a type from a DEX type descriptor
    pub fn from_descriptor(desc: &str) -> Option<Self> {
        let mut chars = desc.chars().peekable();
        Self::parse_type(&mut chars)
    }

    fn parse_type(chars: &mut std::iter::Peekable<std::str::Chars>) -> Option<Self> {
        match chars.next()? {
            'V' => Some(ArgType::Void),
            'Z' => Some(ArgType::Boolean),
            'B' => Some(ArgType::Byte),
            'C' => Some(ArgType::Char),
            'S' => Some(ArgType::Short),
            'I' => Some(ArgType::Int),
            'J' => Some(ArgType::Long),
            'F' => Some(ArgType::Float),
            'D' => Some(ArgType::Double),
            '[' => {
                let elem = Self::parse_type(chars)?;
                Some(ArgType::Array(Box::new(elem)))
            }
            'L' => {
                let mut class_name = String::new();
                loop {
                    match chars.next()? {
                        ';' => break,
                        c => class_name.push(c),
                    }
                }
                Some(ArgType::Object(class_name))
            }
            _ => None,
        }
    }
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn test_primitive_descriptors() {
        assert_eq!(ArgType::from_descriptor("V"), Some(ArgType::Void));
        assert_eq!(ArgType::from_descriptor("I"), Some(ArgType::Int));
        assert_eq!(ArgType::from_descriptor("J"), Some(ArgType::Long));
    }

    #[test]
    fn test_object_descriptor() {
        assert_eq!(
            ArgType::from_descriptor("Ljava/lang/String;"),
            Some(ArgType::Object("java/lang/String".to_string()))
        );
    }

    #[test]
    fn test_array_descriptor() {
        assert_eq!(
            ArgType::from_descriptor("[I"),
            Some(ArgType::Array(Box::new(ArgType::Int)))
        );
        assert_eq!(
            ArgType::from_descriptor("[[I"),
            Some(ArgType::Array(Box::new(ArgType::Array(Box::new(
                ArgType::Int
            )))))
        );
    }
}
