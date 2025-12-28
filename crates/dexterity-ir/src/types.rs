//! Type representation
//!
//! This module provides a comprehensive type system matching JADX's ArgType hierarchy.
//! Key features:
//! - Primitive types with automatic widening hierarchy
//! - Object and array types
//! - Generic types with type parameters
//! - Unknown type variants (NARROW, WIDE) for constraint-based type inference
//! - Type comparison with hierarchy support

/// Argument/variable type representation
///
/// Matches JADX's `jadx.core.dex.instructions.args.ArgType` hierarchy
#[derive(Debug, Clone, PartialEq, Eq, Hash, Default)]
pub enum ArgType {
    // === Primitive types ===
    Void,
    Boolean,
    Byte,
    Char,
    Short,
    Int,
    Long,
    Float,
    Double,

    // === Reference types ===

    /// Object type (class reference)
    Object(String),

    /// Array type
    Array(Box<ArgType>),

    /// Generic type with parameters (e.g., List<String>)
    Generic {
        base: String,
        params: Vec<ArgType>,
    },

    /// Wildcard type (? extends T, ? super T)
    Wildcard {
        bound: WildcardBound,
        inner: Option<Box<ArgType>>,
    },

    /// Type variable (e.g., T, E, K, V) with optional extend bounds
    /// Matches JADX's GenericType which stores extendTypes
    TypeVariable {
        name: String,
        /// Extend bounds (e.g., [Number, Comparable] for T extends Number & Comparable)
        extend_types: Vec<ArgType>,
    },

    /// Outer generic class with inner class: Outer<T>.Inner
    /// Matches JADX's OuterGenericObject for nested class generics
    OuterGeneric {
        /// The outer class type (e.g., Outer<T>)
        outer: Box<ArgType>,
        /// The inner class type (e.g., Inner)
        inner: Box<ArgType>,
    },

    // === Unknown type variants for type inference ===
    // Matches JADX's UnknownArg with possible types

    /// Completely unknown type (can be anything)
    /// Used as initial state before any constraints are gathered
    #[default]
    Unknown,

    /// Unknown narrow type (32-bit: int, float, boolean, byte, char, short, or object reference)
    /// Used when we know the value is a single register (32-bit) but don't know the exact type
    /// Matches JADX's NARROW = unknown(INT, FLOAT, BOOLEAN, BYTE, CHAR, SHORT, OBJECT)
    UnknownNarrow,

    /// Unknown wide type (64-bit: long or double)
    /// Used when we know the value spans two registers (64-bit) but don't know if it's long or double
    /// Matches JADX's WIDE = unknown(LONG, DOUBLE)
    UnknownWide,

    /// Unknown object type (any reference type)
    /// Used when we know it's an object but don't know which class
    /// Matches JADX's UNKNOWN_OBJECT
    UnknownObject,

    /// Unknown array type (any array)
    /// Used when we know it's an array but don't know the element type
    UnknownArray,

    /// Unknown integer subtype (byte, char, short, int, or boolean when used as int)
    /// Used for const instructions that could be any integral type
    /// Matches JADX's NARROW_INTEGRAL
    UnknownIntegral,

    // === Additional JADX Unknown type variants for precise type inference ===

    /// Unknown narrow numbers with boolean (int, float, short, byte, char, boolean)
    /// Matches JADX's NARROW_NUMBERS
    UnknownNarrowNumbers,

    /// Unknown narrow numbers without boolean (int, float, short, byte, char)
    /// Matches JADX's NARROW_NUMBERS_NO_BOOL
    UnknownNumbersNoBool,

    /// Unknown narrow numbers without float (int, short, byte, char, boolean)
    /// Matches JADX's NARROW_NUMBERS_NO_FLOAT
    UnknownNumbersNoFloat,

    /// Unknown type that could be int or float
    /// Matches JADX's INT_FLOAT
    UnknownIntFloat,

    /// Unknown type that could be int or boolean
    /// Matches JADX's INT_BOOLEAN
    UnknownIntBoolean,

    /// Unknown type that could be byte or boolean
    /// Matches JADX's BYTE_BOOLEAN
    UnknownByteBoolean,

    /// Unknown object type that is NOT an array
    /// Matches JADX's UNKNOWN_OBJECT_NO_ARRAY
    UnknownObjectNoArray,

    /// Unknown type that is specifically int (used for inference)
    /// Matches JADX's UNKNOWN_INT
    UnknownInt,
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
    // === Common types as constants ===

    /// java.lang.Object type
    pub const OBJECT: ArgType = ArgType::Object(String::new()); // Will be "java/lang/Object" in practice

    /// java.lang.String type
    pub const STRING: ArgType = ArgType::Object(String::new()); // Will be "java/lang/String" in practice

    // === Factory methods ===

    /// Create an object type from a descriptor
    pub fn object(descriptor: impl Into<String>) -> Self {
        ArgType::Object(descriptor.into())
    }

    /// Create an array type
    pub fn array(element: ArgType) -> Self {
        ArgType::Array(Box::new(element))
    }

    /// Create a generic type
    pub fn generic(base: impl Into<String>, params: Vec<ArgType>) -> Self {
        ArgType::Generic {
            base: base.into(),
            params,
        }
    }

    /// Create a type variable (without bounds)
    pub fn type_var(name: impl Into<String>) -> Self {
        ArgType::TypeVariable {
            name: name.into(),
            extend_types: Vec::new(),
        }
    }

    /// Create a type variable with extend bounds
    pub fn type_var_bounded(name: impl Into<String>, extend_types: Vec<ArgType>) -> Self {
        ArgType::TypeVariable {
            name: name.into(),
            extend_types,
        }
    }

    /// Create an outer generic type (Outer<T>.Inner)
    pub fn outer_generic(outer: ArgType, inner: ArgType) -> Self {
        ArgType::OuterGeneric {
            outer: Box::new(outer),
            inner: Box::new(inner),
        }
    }

    // === Type queries ===

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
        matches!(self, ArgType::Long | ArgType::Double | ArgType::UnknownWide)
    }

    /// Check if this is a narrow type (32-bit)
    pub fn is_narrow(&self) -> bool {
        matches!(
            self,
            ArgType::Boolean
                | ArgType::Byte
                | ArgType::Char
                | ArgType::Short
                | ArgType::Int
                | ArgType::Float
                | ArgType::Object(_)
                | ArgType::Array(_)
                | ArgType::UnknownNarrow
                | ArgType::UnknownObject
                | ArgType::UnknownIntegral
        )
    }

    /// Check if this is an object or array type
    pub fn is_object(&self) -> bool {
        matches!(
            self,
            ArgType::Object(_)
                | ArgType::Array(_)
                | ArgType::Generic { .. }
                | ArgType::TypeVariable { .. }
                | ArgType::Wildcard { .. }
                | ArgType::OuterGeneric { .. }
                | ArgType::UnknownObject
                | ArgType::UnknownObjectNoArray
                | ArgType::UnknownArray
        )
    }

    /// Check if this is an array type
    pub fn is_array(&self) -> bool {
        matches!(self, ArgType::Array(_) | ArgType::UnknownArray)
    }

    /// Check if this is any unknown type variant
    pub fn is_unknown(&self) -> bool {
        matches!(
            self,
            ArgType::Unknown
                | ArgType::UnknownNarrow
                | ArgType::UnknownWide
                | ArgType::UnknownObject
                | ArgType::UnknownArray
                | ArgType::UnknownIntegral
                | ArgType::UnknownNarrowNumbers
                | ArgType::UnknownNumbersNoBool
                | ArgType::UnknownNumbersNoFloat
                | ArgType::UnknownIntFloat
                | ArgType::UnknownIntBoolean
                | ArgType::UnknownByteBoolean
                | ArgType::UnknownObjectNoArray
                | ArgType::UnknownInt
        )
    }

    /// Check if the type is fully known (not unknown in any way)
    pub fn is_type_known(&self) -> bool {
        !self.is_unknown()
    }

    /// Check if this is an integral type (byte, char, short, int, or boolean)
    pub fn is_integral(&self) -> bool {
        matches!(
            self,
            ArgType::Boolean
                | ArgType::Byte
                | ArgType::Char
                | ArgType::Short
                | ArgType::Int
                | ArgType::UnknownIntegral
                | ArgType::UnknownIntBoolean
                | ArgType::UnknownByteBoolean
                | ArgType::UnknownInt
        )
    }

    /// Check if this is a numeric type (NOT including boolean)
    /// JADX Reference: ArgType.canBeAnyNumber() for USE bounds in FixTypesVisitor
    /// This is used for boolean->numeric conversion: when a boolean is used as
    /// a numeric type, it needs to be converted with `(boolVar) ? 1 : 0`
    pub fn is_numeric(&self) -> bool {
        matches!(
            self,
            ArgType::Byte
                | ArgType::Char
                | ArgType::Short
                | ArgType::Int
                | ArgType::Long
                | ArgType::Float
                | ArgType::Double
        )
    }

    /// Check if this is a floating point type
    pub fn is_float(&self) -> bool {
        matches!(self, ArgType::Float | ArgType::Double)
    }

    /// Get the narrowest unknown type that contains this type
    /// Used for type inference constraint propagation
    pub fn to_unknown_category(&self) -> ArgType {
        match self {
            ArgType::Long | ArgType::Double => ArgType::UnknownWide,
            ArgType::Object(_) | ArgType::Array(_) | ArgType::Generic { .. } => {
                ArgType::UnknownObject
            }
            ArgType::Boolean
            | ArgType::Byte
            | ArgType::Char
            | ArgType::Short
            | ArgType::Int => ArgType::UnknownIntegral,
            ArgType::Float => ArgType::UnknownNarrow,
            _ => ArgType::Unknown,
        }
    }

    /// Check if this unknown type can contain the given concrete type
    /// Used for type inference constraint checking
    pub fn can_contain(&self, other: &ArgType) -> bool {
        match self {
            ArgType::Unknown => true,
            ArgType::UnknownNarrow => other.is_narrow(),
            ArgType::UnknownWide => other.is_wide(),
            ArgType::UnknownObject => other.is_object(),
            ArgType::UnknownArray => other.is_array(),
            ArgType::UnknownIntegral => other.is_integral(),
            _ => self == other,
        }
    }

    /// Narrow this type based on a constraint
    /// Returns the more specific type if compatible, or None if conflict
    pub fn narrow_with(&self, constraint: &ArgType) -> Option<ArgType> {
        if self == constraint {
            return Some(self.clone());
        }

        match (self, constraint) {
            // Unknown can be narrowed to anything
            (ArgType::Unknown, other) | (other, ArgType::Unknown) => Some(other.clone()),

            // UnknownNarrow can be narrowed to any 32-bit type
            (ArgType::UnknownNarrow, other) if other.is_narrow() => Some(other.clone()),
            (other, ArgType::UnknownNarrow) if other.is_narrow() => Some(other.clone()),

            // UnknownWide can be narrowed to long or double
            (ArgType::UnknownWide, other) if other.is_wide() => Some(other.clone()),
            (other, ArgType::UnknownWide) if other.is_wide() => Some(other.clone()),

            // UnknownObject can be narrowed to any object type
            (ArgType::UnknownObject, other) if other.is_object() => Some(other.clone()),
            (other, ArgType::UnknownObject) if other.is_object() => Some(other.clone()),

            // UnknownIntegral can be narrowed to any integral type
            (ArgType::UnknownIntegral, other) if other.is_integral() => Some(other.clone()),
            (other, ArgType::UnknownIntegral) if other.is_integral() => Some(other.clone()),

            // UnknownArray can be narrowed to any array type
            (ArgType::UnknownArray, ArgType::Array(elem)) => {
                Some(ArgType::Array(elem.clone()))
            }
            (ArgType::Array(elem), ArgType::UnknownArray) => {
                Some(ArgType::Array(elem.clone()))
            }

            // No narrowing possible - conflict
            _ => None,
        }
    }

    // === Parsing ===

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

    /// Convert to DEX type descriptor string
    pub fn to_descriptor(&self) -> String {
        match self {
            ArgType::Void => "V".to_string(),
            ArgType::Boolean => "Z".to_string(),
            ArgType::Byte => "B".to_string(),
            ArgType::Char => "C".to_string(),
            ArgType::Short => "S".to_string(),
            ArgType::Int => "I".to_string(),
            ArgType::Long => "J".to_string(),
            ArgType::Float => "F".to_string(),
            ArgType::Double => "D".to_string(),
            ArgType::Object(name) => format!("L{};", name),
            ArgType::Array(elem) => format!("[{}", elem.to_descriptor()),
            ArgType::Generic { base, .. } => format!("L{};", base),
            ArgType::TypeVariable { .. } => "Ljava/lang/Object;".to_string(),
            ArgType::Wildcard { .. } => "Ljava/lang/Object;".to_string(),
            ArgType::OuterGeneric { outer, inner } => {
                // Combine outer and inner descriptors
                let outer_desc = outer.to_descriptor();
                let inner_desc = inner.to_descriptor();
                // Strip L and ; from both and combine with $
                let outer_name = outer_desc.trim_start_matches('L').trim_end_matches(';');
                let inner_name = inner_desc.trim_start_matches('L').trim_end_matches(';');
                format!("L{}${};", outer_name, inner_name)
            }
            ArgType::Unknown
            | ArgType::UnknownNarrow
            | ArgType::UnknownWide
            | ArgType::UnknownObject
            | ArgType::UnknownArray
            | ArgType::UnknownIntegral
            | ArgType::UnknownNarrowNumbers
            | ArgType::UnknownNumbersNoBool
            | ArgType::UnknownNumbersNoFloat
            | ArgType::UnknownIntFloat
            | ArgType::UnknownIntBoolean
            | ArgType::UnknownByteBoolean
            | ArgType::UnknownObjectNoArray
            | ArgType::UnknownInt => "?".to_string(),
        }
    }

    // === JADX ArgType methods for 100% parity ===

    /// Short name representation for display (JADX: toShortString-like)
    ///
    /// Returns a concise type name suitable for debug output and wrapped instruction display.
    pub fn short_name(&self) -> String {
        match self {
            ArgType::Void => "V".to_string(),
            ArgType::Boolean => "Z".to_string(),
            ArgType::Byte => "B".to_string(),
            ArgType::Char => "C".to_string(),
            ArgType::Short => "S".to_string(),
            ArgType::Int => "I".to_string(),
            ArgType::Long => "J".to_string(),
            ArgType::Float => "F".to_string(),
            ArgType::Double => "D".to_string(),
            ArgType::Object(name) => {
                // Extract simple class name from full path
                name.rsplit('/').next().unwrap_or(name).to_string()
            }
            ArgType::Array(elem) => format!("{}[]", elem.short_name()),
            ArgType::Generic { base, params } => {
                let base_name = base.rsplit('/').next().unwrap_or(base);
                if params.is_empty() {
                    base_name.to_string()
                } else {
                    let param_strs: Vec<_> = params.iter().map(|p| p.short_name()).collect();
                    format!("{}<{}>", base_name, param_strs.join(","))
                }
            }
            ArgType::TypeVariable { name, extend_types } => {
                if extend_types.is_empty() {
                    name.clone()
                } else {
                    let bounds: Vec<_> = extend_types.iter().map(|t| t.short_name()).collect();
                    format!("{} extends {}", name, bounds.join(" & "))
                }
            }
            ArgType::Wildcard { bound, inner } => match (bound, inner) {
                (WildcardBound::Unbounded, _) => "?".to_string(),
                (WildcardBound::Extends, Some(t)) => format!("?e{}", t.short_name()),
                (WildcardBound::Super, Some(t)) => format!("?s{}", t.short_name()),
                _ => "?".to_string(),
            },
            ArgType::OuterGeneric { outer, inner } => {
                format!("{}.{}", outer.short_name(), inner.short_name())
            }
            ArgType::Unknown => "?".to_string(),
            ArgType::UnknownNarrow => "?N".to_string(),
            ArgType::UnknownWide => "?W".to_string(),
            ArgType::UnknownObject => "?O".to_string(),
            ArgType::UnknownArray => "?A".to_string(),
            ArgType::UnknownIntegral => "?I".to_string(),
            ArgType::UnknownNarrowNumbers => "?NN".to_string(),
            ArgType::UnknownNumbersNoBool => "?NNB".to_string(),
            ArgType::UnknownNumbersNoFloat => "?NNF".to_string(),
            ArgType::UnknownIntFloat => "?IF".to_string(),
            ArgType::UnknownIntBoolean => "?IB".to_string(),
            ArgType::UnknownByteBoolean => "?BB".to_string(),
            ArgType::UnknownObjectNoArray => "?ONA".to_string(),
            ArgType::UnknownInt => "?Int".to_string(),
        }
    }

    /// Get the simple name (just class name without package) (JADX: getObject for objects)
    pub fn get_simple_name(&self) -> Option<String> {
        match self {
            ArgType::Object(name) => Some(name.rsplit('/').next().unwrap_or(name).to_string()),
            ArgType::Generic { base, .. } => Some(base.rsplit('/').next().unwrap_or(base).to_string()),
            ArgType::OuterGeneric { inner, .. } => inner.get_simple_name(),
            _ => None,
        }
    }

    // === New JADX parity methods ===

    /// Check if this is an outer generic type
    pub fn is_outer_generic(&self) -> bool {
        matches!(self, ArgType::OuterGeneric { .. })
    }

    /// Get the outer type for OuterGeneric
    pub fn get_outer_type(&self) -> Option<&ArgType> {
        match self {
            ArgType::OuterGeneric { outer, .. } => Some(outer),
            _ => None,
        }
    }

    /// Get the inner type for OuterGeneric
    pub fn get_inner_type(&self) -> Option<&ArgType> {
        match self {
            ArgType::OuterGeneric { inner, .. } => Some(inner),
            _ => None,
        }
    }

    /// Get extend types for TypeVariable
    pub fn get_extend_types(&self) -> &[ArgType] {
        match self {
            ArgType::TypeVariable { extend_types, .. } => extend_types,
            _ => &[],
        }
    }

    /// Check if type is a generic type (including type variables)
    pub fn is_generic(&self) -> bool {
        matches!(
            self,
            ArgType::Generic { .. }
                | ArgType::Wildcard { .. }
                | ArgType::OuterGeneric { .. }
        )
    }

    /// Check if this is a type variable (T, E, K, V etc.)
    pub fn is_generic_type(&self) -> bool {
        matches!(self, ArgType::TypeVariable { .. })
    }

    // === Type utility methods for JADX parity (Phase 2) ===

    /// Select the first possible concrete type from an unknown type.
    /// Returns None for already-known types.
    /// For unknown types: prefers Object > Array > first primitive.
    /// (JADX parity: selectFirst)
    pub fn select_first(&self) -> Option<ArgType> {
        match self {
            // Known types return None (already concrete)
            ArgType::Void
            | ArgType::Boolean
            | ArgType::Byte
            | ArgType::Char
            | ArgType::Short
            | ArgType::Int
            | ArgType::Long
            | ArgType::Float
            | ArgType::Double
            | ArgType::Object(_)
            | ArgType::Generic { .. }
            | ArgType::TypeVariable { .. }
            | ArgType::Wildcard { .. }
            | ArgType::OuterGeneric { .. } => None,

            // Array: recurse
            ArgType::Array(elem) => elem.select_first().map(|e| ArgType::Array(Box::new(e))),

            // Unknown variants: select preferred type
            ArgType::Unknown
            | ArgType::UnknownNarrow
            | ArgType::UnknownObject
            | ArgType::UnknownObjectNoArray => Some(ArgType::Object("java/lang/Object".into())),

            ArgType::UnknownArray => {
                Some(ArgType::Array(Box::new(ArgType::Object("java/lang/Object".into()))))
            }

            ArgType::UnknownWide => Some(ArgType::Long),

            ArgType::UnknownIntegral
            | ArgType::UnknownNarrowNumbers
            | ArgType::UnknownNumbersNoBool
            | ArgType::UnknownNumbersNoFloat
            | ArgType::UnknownInt
            | ArgType::UnknownIntFloat
            | ArgType::UnknownIntBoolean => Some(ArgType::Int),

            ArgType::UnknownByteBoolean => Some(ArgType::Byte),
        }
    }

    /// Visit all nested types recursively.
    /// Visitor is called for self and all contained types.
    /// (JADX parity: visitTypes)
    pub fn visit_types<F>(&self, visitor: &mut F)
    where
        F: FnMut(&ArgType),
    {
        visitor(self);
        match self {
            ArgType::Array(elem) => elem.visit_types(visitor),
            ArgType::Generic { params, .. } => {
                for p in params {
                    p.visit_types(visitor);
                }
            }
            ArgType::Wildcard { inner: Some(i), .. } => i.visit_types(visitor),
            ArgType::OuterGeneric { outer, inner } => {
                outer.visit_types(visitor);
                inner.visit_types(visitor);
            }
            ArgType::TypeVariable { extend_types, .. } => {
                for t in extend_types {
                    t.visit_types(visitor);
                }
            }
            _ => {}
        }
    }

    /// Get the array nesting depth.
    /// Returns 0 for non-arrays, 1 for [], 2 for [][], etc.
    /// (JADX parity: getArrayDimension)
    pub fn get_array_dimension(&self) -> usize {
        match self {
            ArgType::Array(elem) => 1 + elem.get_array_dimension(),
            _ => 0,
        }
    }

    /// Check if this type contains any TypeVariable anywhere.
    /// (JADX parity: containsTypeVariable)
    pub fn contains_type_variable(&self) -> bool {
        match self {
            ArgType::TypeVariable { .. } => true,
            ArgType::Array(elem) => elem.contains_type_variable(),
            ArgType::Generic { params, .. } => params.iter().any(|p| p.contains_type_variable()),
            ArgType::Wildcard { inner: Some(i), .. } => i.contains_type_variable(),
            ArgType::OuterGeneric { outer, inner } => {
                outer.contains_type_variable() || inner.contains_type_variable()
            }
            _ => false,
        }
    }

    /// Check if type contains any generic parameters (Generic, TypeVariable, or Wildcard).
    /// (JADX parity: containsGeneric)
    pub fn contains_generic(&self) -> bool {
        match self {
            ArgType::Generic { .. } | ArgType::TypeVariable { .. } | ArgType::Wildcard { .. } => {
                true
            }
            ArgType::Array(elem) => elem.contains_generic(),
            ArgType::OuterGeneric { outer, inner } => {
                outer.contains_generic() || inner.contains_generic()
            }
            _ => false,
        }
    }

    // === JADX parity methods ===

    /// Check if this type is void (JADX: isVoid)
    pub fn is_void(&self) -> bool {
        matches!(self, ArgType::Void)
    }

    /// Check if this is a wildcard type (JADX: isWildcard)
    pub fn is_wildcard(&self) -> bool {
        matches!(self, ArgType::Wildcard { .. })
    }

    /// Get the immediate element type of an array (JADX: getArrayElement)
    pub fn get_array_element(&self) -> Option<&ArgType> {
        match self {
            ArgType::Array(elem) => Some(elem.as_ref()),
            _ => None,
        }
    }

    /// Get the root element type of a nested array (JADX: getArrayRootElement)
    pub fn get_array_root_element(&self) -> &ArgType {
        match self {
            ArgType::Array(elem) => elem.get_array_root_element(),
            _ => self,
        }
    }

    /// Check if this unknown type could be an object (JADX: canBeObject)
    pub fn can_be_object(&self) -> bool {
        match self {
            ArgType::Object(_) | ArgType::Generic { .. } | ArgType::Array(_) => true,
            ArgType::Unknown | ArgType::UnknownNarrow | ArgType::UnknownObject
            | ArgType::UnknownArray | ArgType::UnknownObjectNoArray => true,
            _ => false,
        }
    }

    /// Check if this unknown type could be an array (JADX: canBeArray)
    pub fn can_be_array(&self) -> bool {
        match self {
            ArgType::Array(_) | ArgType::UnknownArray => true,
            ArgType::Unknown | ArgType::UnknownNarrow | ArgType::UnknownObject => true,
            ArgType::UnknownObjectNoArray => false,
            _ => false,
        }
    }

    /// Check if this type could be a specific primitive (JADX: canBePrimitive)
    pub fn can_be_primitive(&self, primitive: &ArgType) -> bool {
        if self == primitive {
            return true;
        }
        match (self, primitive) {
            (ArgType::Unknown, _) => primitive.is_primitive(),
            (ArgType::UnknownNarrow, ArgType::Long | ArgType::Double) => false,
            (ArgType::UnknownNarrow, p) => p.is_primitive() && *p != ArgType::Void,
            (ArgType::UnknownWide, ArgType::Long | ArgType::Double) => true,
            (ArgType::UnknownWide, _) => false,
            (ArgType::UnknownIntegral, ArgType::Int | ArgType::Short | ArgType::Byte | ArgType::Char | ArgType::Boolean) => true,
            (ArgType::UnknownIntFloat, ArgType::Int | ArgType::Float) => true,
            (ArgType::UnknownIntBoolean, ArgType::Int | ArgType::Boolean) => true,
            (ArgType::UnknownByteBoolean, ArgType::Byte | ArgType::Boolean) => true,
            _ => false,
        }
    }

    /// Check if this type could be any numeric type (JADX: canBeAnyNumber)
    pub fn can_be_any_number(&self) -> bool {
        match self {
            ArgType::Int | ArgType::Long | ArgType::Float | ArgType::Double
            | ArgType::Short | ArgType::Byte | ArgType::Char => true,
            ArgType::Unknown | ArgType::UnknownNarrow | ArgType::UnknownWide
            | ArgType::UnknownIntegral | ArgType::UnknownIntFloat => true,
            _ => false,
        }
    }

    /// Get register count (1 for narrow, 2 for wide) (JADX: getRegCount)
    pub fn get_reg_count(&self) -> usize {
        if self.is_wide() { 2 } else { 1 }
    }

    /// Get generic type parameters (JADX: getGenericTypes)
    pub fn get_generic_types(&self) -> &[ArgType] {
        match self {
            ArgType::Generic { params, .. } => params.as_slice(),
            _ => &[],
        }
    }

    /// Get the inner type of a wildcard (JADX: getWildcardType)
    pub fn get_wildcard_type(&self) -> Option<&ArgType> {
        match self {
            ArgType::Wildcard { inner: Some(inner), .. } => Some(inner.as_ref()),
            _ => None,
        }
    }

    /// Get the wildcard bound direction (JADX: getWildcardBound)
    pub fn get_wildcard_bound(&self) -> Option<WildcardBound> {
        match self {
            ArgType::Wildcard { bound, .. } => Some(*bound),
            _ => None,
        }
    }

    /// Create a multi-dimensional array type (JADX: array(type, dimension))
    pub fn array_of_dimension(element: ArgType, dimension: usize) -> ArgType {
        if dimension == 0 {
            element
        } else {
            ArgType::Array(Box::new(ArgType::array_of_dimension(element, dimension - 1)))
        }
    }
}

/// Type comparison result (matching JADX's TypeCompareEnum)
#[derive(Debug, Clone, Copy, PartialEq, Eq)]
pub enum TypeCompare {
    /// Types are identical
    Equal,
    /// First type is more specific (subtype)
    Narrow,
    /// First type is more general (supertype)
    Wider,
    /// Same base type, but first has generic parameters
    NarrowByGeneric,
    /// Same base type, but second has generic parameters
    WiderByGeneric,
    /// Same base type, but incompatible generic parameters
    ConflictByGeneric,
    /// Types are incompatible
    Conflict,
    /// Relationship cannot be determined
    Unknown,
}

impl TypeCompare {
    /// Invert the comparison direction (NARROW ↔ WIDER)
    pub fn invert(self) -> Self {
        match self {
            TypeCompare::Narrow => TypeCompare::Wider,
            TypeCompare::Wider => TypeCompare::Narrow,
            TypeCompare::NarrowByGeneric => TypeCompare::WiderByGeneric,
            TypeCompare::WiderByGeneric => TypeCompare::NarrowByGeneric,
            other => other,
        }
    }

    /// Check if types are equal
    pub fn is_equal(self) -> bool {
        matches!(self, TypeCompare::Equal)
    }

    /// Check if first type is wider (more general)
    pub fn is_wider(self) -> bool {
        matches!(
            self,
            TypeCompare::Wider | TypeCompare::WiderByGeneric
        )
    }

    /// Check if first type is narrower (more specific)
    pub fn is_narrow(self) -> bool {
        matches!(
            self,
            TypeCompare::Narrow | TypeCompare::NarrowByGeneric
        )
    }

    /// Check if types conflict
    pub fn is_conflict(self) -> bool {
        matches!(
            self,
            TypeCompare::Conflict | TypeCompare::ConflictByGeneric
        )
    }

    /// Check if first type is wider or equal
    pub fn is_wider_or_equal(self) -> bool {
        self.is_wider() || self.is_equal()
    }

    /// Check if first type is narrower or equal
    pub fn is_narrow_or_equal(self) -> bool {
        self.is_narrow() || self.is_equal()
    }
}

/// Compare two types using class hierarchy
///
/// This implements JADX's type comparison logic with hierarchy-aware subtype checking.
/// Handles all unknown type variants for constraint-based type inference.
pub fn compare_types(
    first: &ArgType,
    second: &ArgType,
    hierarchy: Option<&crate::ClassHierarchy>,
) -> TypeCompare {
    use ArgType::*;

    // Identity and equality check
    if first == second {
        return TypeCompare::Equal;
    }

    match (first, second) {
        // === Unknown type variant handling ===
        // Unknown is compatible with everything
        (Unknown, _) | (_, Unknown) => TypeCompare::Equal,

        // UnknownNarrow is compatible with all 32-bit types
        (UnknownNarrow, other) | (other, UnknownNarrow) if other.is_narrow() => TypeCompare::Equal,
        (UnknownNarrow, _) | (_, UnknownNarrow) => TypeCompare::Conflict,

        // UnknownWide is compatible with long and double
        (UnknownWide, other) | (other, UnknownWide) if other.is_wide() => TypeCompare::Equal,
        (UnknownWide, _) | (_, UnknownWide) => TypeCompare::Conflict,

        // UnknownObject is compatible with all object types
        (UnknownObject, other) | (other, UnknownObject) if other.is_object() => TypeCompare::Equal,
        (UnknownObject, _) | (_, UnknownObject) => TypeCompare::Conflict,

        // UnknownArray is compatible with all array types
        (UnknownArray, Array(_)) | (Array(_), UnknownArray) => TypeCompare::Equal,
        (UnknownArray, _) | (_, UnknownArray) => TypeCompare::Conflict,

        // UnknownIntegral is compatible with integral types
        (UnknownIntegral, other) | (other, UnknownIntegral) if other.is_integral() => {
            TypeCompare::Equal
        }
        (UnknownIntegral, _) | (_, UnknownIntegral) => TypeCompare::Conflict,

        // Primitive type comparisons
        (Int, Byte) | (Int, Short) | (Int, Char) => TypeCompare::Wider,
        (Byte, Int) | (Short, Int) | (Char, Int) => TypeCompare::Narrow,

        // Primitive widening hierarchy: byte → short → int → long → float → double
        (Long, Int) | (Long, Short) | (Long, Byte) => TypeCompare::Wider,
        (Int, Long) | (Short, Long) | (Byte, Long) => TypeCompare::Narrow,

        (Float, Int) | (Float, Long) | (Float, Short) | (Float, Byte) => TypeCompare::Wider,
        (Int, Float) | (Long, Float) | (Short, Float) | (Byte, Float) => TypeCompare::Narrow,

        (Double, Float) | (Double, Long) | (Double, Int) | (Double, Short) | (Double, Byte) => {
            TypeCompare::Wider
        }
        (Float, Double) | (Long, Double) | (Int, Double) | (Short, Double) | (Byte, Double) => {
            TypeCompare::Narrow
        }

        // Boolean and Void cannot widen
        (Boolean, _) | (_, Boolean) | (Void, _) | (_, Void) => TypeCompare::Conflict,

        // Array comparisons
        (Array(elem1), Array(elem2)) => {
            let elem_cmp = compare_types(elem1, elem2, hierarchy);
            if elem_cmp.is_equal() {
                TypeCompare::Equal
            } else if elem_cmp.is_narrow() {
                TypeCompare::Narrow
            } else if elem_cmp.is_wider() {
                TypeCompare::Wider
            } else {
                TypeCompare::Conflict
            }
        }

        // Array vs Object (arrays are objects)
        (Array(_), Object(name)) if name == "java/lang/Object" => TypeCompare::Narrow,
        (Object(name), Array(_)) if name == "java/lang/Object" => TypeCompare::Wider,

        // Object type comparisons (use hierarchy if available)
        (Object(name1), Object(name2)) => {
            if let Some(h) = hierarchy {
                if h.is_subtype_of(name1, name2) {
                    TypeCompare::Narrow
                } else if h.is_subtype_of(name2, name1) {
                    TypeCompare::Wider
                } else {
                    TypeCompare::Conflict
                }
            } else {
                // No hierarchy - fall back to simple comparison
                if name1 == name2 {
                    TypeCompare::Equal
                } else if name2 == "java/lang/Object" {
                    TypeCompare::Narrow
                } else if name1 == "java/lang/Object" {
                    TypeCompare::Wider
                } else {
                    TypeCompare::Unknown
                }
            }
        }

        // Generic type comparisons
        (Generic { base: b1, params: p1 }, Generic { base: b2, params: p2 }) => {
            if b1 != b2 {
                return TypeCompare::Conflict;
            }

            // Same base type - compare parameters
            if p1.len() != p2.len() {
                return TypeCompare::ConflictByGeneric;
            }

            // Java generics are invariant - parameters must match exactly
            let mut all_equal = true;
            for (param1, param2) in p1.iter().zip(p2.iter()) {
                let param_cmp = compare_types(param1, param2, hierarchy);
                if param_cmp.is_conflict() {
                    return TypeCompare::ConflictByGeneric;
                }
                // For generics, Unknown relationships (unrelated types) are also conflicts
                // because generics require exact type matches (invariance)
                if param_cmp == TypeCompare::Unknown {
                    return TypeCompare::ConflictByGeneric;
                }
                if !param_cmp.is_equal() {
                    all_equal = false;
                }
            }

            if all_equal {
                TypeCompare::Equal
            } else {
                TypeCompare::NarrowByGeneric
            }
        }

        // Generic vs raw type
        (Generic { base, .. }, Object(name)) | (Object(name), Generic { base, .. }) => {
            if base == name {
                TypeCompare::NarrowByGeneric
            } else {
                // Check hierarchy for base type
                if let Some(h) = hierarchy {
                    if h.is_subtype_of(base, name) {
                        TypeCompare::Narrow
                    } else if h.is_subtype_of(name, base) {
                        TypeCompare::Wider
                    } else {
                        TypeCompare::Conflict
                    }
                } else {
                    TypeCompare::Conflict
                }
            }
        }

        // TypeVariable comparisons (JADX parity for generic type variables like T, E, K, V)
        (
            TypeVariable { name: n1, extend_types: e1 },
            TypeVariable { name: n2, extend_types: e2 },
        ) => {
            // Same type variable name = equal
            if n1 == n2 {
                TypeCompare::Equal
            } else if e1.is_empty() && e2.is_empty() {
                // Both unbounded - can't determine relationship
                TypeCompare::Unknown
            } else {
                // Compare based on extend bounds
                // A type var with more restrictive bounds is narrower
                let e1_has_bounds = !e1.is_empty();
                let e2_has_bounds = !e2.is_empty();

                match (e1_has_bounds, e2_has_bounds) {
                    (true, false) => TypeCompare::Narrow, // T extends X is narrower than unbounded U
                    (false, true) => TypeCompare::Wider,
                    (true, true) => {
                        // Both have bounds - compare first bound (simplified)
                        if let (Some(b1), Some(b2)) = (e1.first(), e2.first()) {
                            compare_types(b1, b2, hierarchy)
                        } else {
                            TypeCompare::Unknown
                        }
                    }
                    (false, false) => TypeCompare::Unknown,
                }
            }
        }

        // TypeVariable vs concrete type
        (TypeVariable { extend_types, .. }, other) | (other, TypeVariable { extend_types, .. }) => {
            // If type var has extend bounds, check if other satisfies them
            if extend_types.is_empty() {
                // Unbounded type variable - compatible with any object type
                if other.is_object() {
                    TypeCompare::WiderByGeneric
                } else {
                    TypeCompare::Conflict
                }
            } else {
                // Type var with bounds - other must be subtype of all bounds
                for bound in extend_types {
                    let cmp = compare_types(other, bound, hierarchy);
                    if cmp.is_conflict() {
                        return TypeCompare::ConflictByGeneric;
                    }
                }
                TypeCompare::NarrowByGeneric
            }
        }

        // OuterGeneric comparisons (Outer<T>.Inner types)
        (
            OuterGeneric { outer: o1, inner: i1 },
            OuterGeneric { outer: o2, inner: i2 },
        ) => {
            // Both outer and inner must be compatible
            let outer_cmp = compare_types(o1, o2, hierarchy);
            if outer_cmp.is_conflict() {
                return outer_cmp;
            }

            let inner_cmp = compare_types(i1, i2, hierarchy);
            if inner_cmp.is_conflict() {
                return inner_cmp;
            }

            // Return the more restrictive result
            if outer_cmp.is_equal() {
                inner_cmp
            } else if inner_cmp.is_equal() {
                outer_cmp
            } else if outer_cmp.is_narrow() || inner_cmp.is_narrow() {
                TypeCompare::NarrowByGeneric
            } else {
                TypeCompare::WiderByGeneric
            }
        }

        // OuterGeneric vs simple type
        (OuterGeneric { inner, .. }, other) | (other, OuterGeneric { inner, .. }) => {
            // Compare inner type with other
            compare_types(inner, other, hierarchy)
        }

        // Wildcard comparisons with proper variance handling (JADX parity)
        (
            Wildcard {
                bound: bound1,
                inner: inner1,
            },
            Wildcard {
                bound: bound2,
                inner: inner2,
            },
        ) => compare_wildcards(*bound1, inner1.as_deref(), *bound2, inner2.as_deref(), hierarchy),

        // Wildcard vs concrete type
        // compare_wildcard_to_type returns comparison for (wildcard, concrete)
        (Wildcard { bound: b, inner }, other) => {
            compare_wildcard_to_type(*b, inner.as_deref(), other, hierarchy)
        }

        (other, Wildcard { bound: b, inner }) => {
            // Swap: we have (concrete, wildcard), but function returns (wildcard, concrete)
            // So invert the result
            compare_wildcard_to_type(*b, inner.as_deref(), other, hierarchy).invert()
        }

        // Primitive vs object/array = conflict
        _ => TypeCompare::Conflict,
    }
}

/// Compare two wildcards with proper variance handling
///
/// Wildcard comparison rules (JADX parity):
/// - `?` vs `?` = Equal
/// - `? extends A` vs `? extends B`: compare A and B
/// - `? super A` vs `? super B`: compare A and B (inverted)
/// - `? extends A` vs `? super B`: conflict (unless one contains the other)
fn compare_wildcards(
    bound1: WildcardBound,
    inner1: Option<&ArgType>,
    bound2: WildcardBound,
    inner2: Option<&ArgType>,
    hierarchy: Option<&crate::ClassHierarchy>,
) -> TypeCompare {
    use WildcardBound::*;

    match (bound1, bound2) {
        // Both unbounded
        (Unbounded, Unbounded) => TypeCompare::Equal,

        // Unbounded vs bounded - unbounded is wider
        (Unbounded, Extends | Super) => TypeCompare::Wider,
        (Extends | Super, Unbounded) => TypeCompare::Narrow,

        // Both extends - compare upper bounds (covariant)
        (Extends, Extends) => {
            match (inner1, inner2) {
                (Some(t1), Some(t2)) => compare_types(t1, t2, hierarchy),
                (None, None) => TypeCompare::Equal,
                (Some(_), None) => TypeCompare::Narrow, // has bound vs unbounded
                (None, Some(_)) => TypeCompare::Wider,
            }
        }

        // Both super - compare lower bounds (contravariant - inverted)
        (Super, Super) => {
            match (inner1, inner2) {
                (Some(t1), Some(t2)) => compare_types(t1, t2, hierarchy).invert(),
                (None, None) => TypeCompare::Equal,
                (Some(_), None) => TypeCompare::Wider, // has bound vs unbounded (inverted)
                (None, Some(_)) => TypeCompare::Narrow,
            }
        }

        // extends vs super - generally conflict, but check for containment
        (Extends, Super) | (Super, Extends) => {
            match (inner1, inner2) {
                (Some(t1), Some(t2)) => {
                    // Check if one contains the other
                    let cmp = compare_types(t1, t2, hierarchy);
                    if cmp.is_equal() {
                        // ? extends T vs ? super T - any T satisfies both only if T is exact
                        TypeCompare::ConflictByGeneric
                    } else {
                        // Different bounds directions are generally incompatible
                        TypeCompare::Conflict
                    }
                }
                _ => TypeCompare::Conflict,
            }
        }
    }
}

/// Compare a wildcard to a concrete type
///
/// Returns the comparison for (wildcard, concrete).
/// - `? extends T` accepts anything that is a subtype of T (covariant)
/// - `? super T` accepts anything that is a supertype of T (contravariant)
/// - `?` accepts any reference type
fn compare_wildcard_to_type(
    bound: WildcardBound,
    inner: Option<&ArgType>,
    concrete: &ArgType,
    hierarchy: Option<&crate::ClassHierarchy>,
) -> TypeCompare {
    use WildcardBound::*;

    // Wildcards only work with reference types
    if !concrete.is_object() && !matches!(concrete, ArgType::TypeVariable { .. }) {
        return TypeCompare::Conflict;
    }

    match bound {
        // Unbounded wildcard accepts any reference type
        // ? > concrete (wildcard is wider)
        Unbounded => TypeCompare::Wider,

        // ? extends T - wildcard accepts subtypes of T
        Extends => {
            match inner {
                Some(bound_type) => {
                    let cmp = compare_types(concrete, bound_type, hierarchy);
                    if cmp.is_narrow_or_equal() {
                        // concrete <= bound - wildcard can accept it
                        TypeCompare::Wider
                    } else if cmp.is_wider() {
                        // concrete > bound - concrete doesn't fit in wildcard
                        TypeCompare::Conflict
                    } else {
                        TypeCompare::Unknown
                    }
                }
                // No inner type means extends Object
                None => TypeCompare::Wider,
            }
        }

        // ? super T - wildcard accepts supertypes of T
        Super => {
            match inner {
                Some(bound_type) => {
                    let cmp = compare_types(concrete, bound_type, hierarchy);
                    if cmp.is_wider_or_equal() {
                        // concrete >= bound - wildcard can accept it
                        TypeCompare::Wider
                    } else if cmp.is_narrow() {
                        // concrete < bound - concrete doesn't fit in ? super T
                        TypeCompare::Conflict
                    } else {
                        TypeCompare::Unknown
                    }
                }
                // No inner type - any reference type accepted
                None => TypeCompare::Wider,
            }
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

    // TypeCompare tests

    #[test]
    fn test_type_compare_equal() {
        let t1 = ArgType::Int;
        let t2 = ArgType::Int;
        assert_eq!(compare_types(&t1, &t2, None), TypeCompare::Equal);
        assert!(compare_types(&t1, &t2, None).is_equal());
    }

    #[test]
    fn test_type_compare_unknown() {
        let t1 = ArgType::Unknown;
        let t2 = ArgType::Int;
        // Unknown is compatible with everything
        assert_eq!(compare_types(&t1, &t2, None), TypeCompare::Equal);
        assert_eq!(compare_types(&t2, &t1, None), TypeCompare::Equal);
    }

    #[test]
    fn test_primitive_widening() {
        // byte → int (narrow)
        assert_eq!(
            compare_types(&ArgType::Byte, &ArgType::Int, None),
            TypeCompare::Narrow
        );
        // int → byte (wider)
        assert_eq!(
            compare_types(&ArgType::Int, &ArgType::Byte, None),
            TypeCompare::Wider
        );

        // int → long (narrow)
        assert_eq!(
            compare_types(&ArgType::Int, &ArgType::Long, None),
            TypeCompare::Narrow
        );
        // long → int (wider)
        assert_eq!(
            compare_types(&ArgType::Long, &ArgType::Int, None),
            TypeCompare::Wider
        );

        // long → float (narrow)
        assert_eq!(
            compare_types(&ArgType::Long, &ArgType::Float, None),
            TypeCompare::Narrow
        );
        // float → long (wider)
        assert_eq!(
            compare_types(&ArgType::Float, &ArgType::Long, None),
            TypeCompare::Wider
        );

        // float → double (narrow)
        assert_eq!(
            compare_types(&ArgType::Float, &ArgType::Double, None),
            TypeCompare::Narrow
        );
        // double → float (wider)
        assert_eq!(
            compare_types(&ArgType::Double, &ArgType::Float, None),
            TypeCompare::Wider
        );
    }

    #[test]
    fn test_primitive_transitive_widening() {
        // byte → double (narrow, transitive through int, long, float)
        assert_eq!(
            compare_types(&ArgType::Byte, &ArgType::Double, None),
            TypeCompare::Narrow
        );
        // double → byte (wider)
        assert_eq!(
            compare_types(&ArgType::Double, &ArgType::Byte, None),
            TypeCompare::Wider
        );
    }

    #[test]
    fn test_primitive_conflicts() {
        // Boolean cannot widen
        assert!(compare_types(&ArgType::Boolean, &ArgType::Int, None).is_conflict());
        assert!(compare_types(&ArgType::Int, &ArgType::Boolean, None).is_conflict());

        // Void cannot widen
        assert!(compare_types(&ArgType::Void, &ArgType::Int, None).is_conflict());
        assert!(compare_types(&ArgType::Int, &ArgType::Void, None).is_conflict());
    }

    #[test]
    fn test_array_comparison() {
        let int_arr = ArgType::Array(Box::new(ArgType::Int));
        let long_arr = ArgType::Array(Box::new(ArgType::Long));

        // int[] vs long[] - element widening applies
        assert_eq!(
            compare_types(&int_arr, &long_arr, None),
            TypeCompare::Narrow
        );
        assert_eq!(
            compare_types(&long_arr, &int_arr, None),
            TypeCompare::Wider
        );

        // Same array types
        let int_arr2 = ArgType::Array(Box::new(ArgType::Int));
        assert_eq!(
            compare_types(&int_arr, &int_arr2, None),
            TypeCompare::Equal
        );
    }

    #[test]
    fn test_array_vs_object() {
        let int_arr = ArgType::Array(Box::new(ArgType::Int));
        let object = ArgType::Object("java/lang/Object".to_string());

        // Arrays are objects
        assert_eq!(compare_types(&int_arr, &object, None), TypeCompare::Narrow);
        assert_eq!(compare_types(&object, &int_arr, None), TypeCompare::Wider);

        // Array vs non-Object class
        let string = ArgType::Object("java/lang/String".to_string());
        assert!(compare_types(&int_arr, &string, None).is_conflict());
    }

    #[test]
    fn test_object_comparison_no_hierarchy() {
        let obj1 = ArgType::Object("java/lang/String".to_string());
        let obj2 = ArgType::Object("java/lang/Integer".to_string());
        let object = ArgType::Object("java/lang/Object".to_string());

        // String vs Object (no hierarchy)
        assert_eq!(compare_types(&obj1, &object, None), TypeCompare::Narrow);
        assert_eq!(compare_types(&object, &obj1, None), TypeCompare::Wider);

        // String vs Integer (no hierarchy - unknown relationship)
        assert_eq!(compare_types(&obj1, &obj2, None), TypeCompare::Unknown);
    }

    #[test]
    fn test_object_comparison_with_hierarchy() {
        let hierarchy = crate::ClassHierarchy::new();

        let integer = ArgType::Object("java/lang/Integer".to_string());
        let number = ArgType::Object("java/lang/Number".to_string());
        let object = ArgType::Object("java/lang/Object".to_string());

        // Integer < Number
        assert_eq!(
            compare_types(&integer, &number, Some(&hierarchy)),
            TypeCompare::Narrow
        );
        assert_eq!(
            compare_types(&number, &integer, Some(&hierarchy)),
            TypeCompare::Wider
        );

        // Integer < Object
        assert_eq!(
            compare_types(&integer, &object, Some(&hierarchy)),
            TypeCompare::Narrow
        );

        // Number < Object
        assert_eq!(
            compare_types(&number, &object, Some(&hierarchy)),
            TypeCompare::Narrow
        );
    }

    #[test]
    fn test_object_hierarchy_siblings() {
        let hierarchy = crate::ClassHierarchy::new();

        let integer = ArgType::Object("java/lang/Integer".to_string());
        let long = ArgType::Object("java/lang/Long".to_string());

        // Integer and Long are siblings (both extend Number)
        // Without explicit LCA check, they conflict
        assert!(compare_types(&integer, &long, Some(&hierarchy)).is_conflict());
    }

    #[test]
    fn test_generic_comparison() {
        let list_string = ArgType::Generic {
            base: "java/util/List".to_string(),
            params: vec![ArgType::Object("java/lang/String".to_string())],
        };
        let list_integer = ArgType::Generic {
            base: "java/util/List".to_string(),
            params: vec![ArgType::Object("java/lang/Integer".to_string())],
        };
        let list_raw = ArgType::Object("java/util/List".to_string());

        // Same base, same parameters
        let list_string2 = ArgType::Generic {
            base: "java/util/List".to_string(),
            params: vec![ArgType::Object("java/lang/String".to_string())],
        };
        assert_eq!(
            compare_types(&list_string, &list_string2, None),
            TypeCompare::Equal
        );

        // Same base, different parameters
        assert_eq!(
            compare_types(&list_string, &list_integer, None),
            TypeCompare::ConflictByGeneric
        );

        // Generic vs raw type
        assert_eq!(
            compare_types(&list_string, &list_raw, None),
            TypeCompare::NarrowByGeneric
        );
        assert_eq!(
            compare_types(&list_raw, &list_string, None),
            TypeCompare::NarrowByGeneric
        );

        // Different base types
        let set_string = ArgType::Generic {
            base: "java/util/Set".to_string(),
            params: vec![ArgType::Object("java/lang/String".to_string())],
        };
        assert!(compare_types(&list_string, &set_string, None).is_conflict());
    }

    #[test]
    fn test_type_compare_invert() {
        assert_eq!(TypeCompare::Equal.invert(), TypeCompare::Equal);
        assert_eq!(TypeCompare::Narrow.invert(), TypeCompare::Wider);
        assert_eq!(TypeCompare::Wider.invert(), TypeCompare::Narrow);
        assert_eq!(
            TypeCompare::NarrowByGeneric.invert(),
            TypeCompare::WiderByGeneric
        );
        assert_eq!(
            TypeCompare::WiderByGeneric.invert(),
            TypeCompare::NarrowByGeneric
        );
        assert_eq!(TypeCompare::Conflict.invert(), TypeCompare::Conflict);
        assert_eq!(
            TypeCompare::ConflictByGeneric.invert(),
            TypeCompare::ConflictByGeneric
        );
        assert_eq!(TypeCompare::Unknown.invert(), TypeCompare::Unknown);
    }

    #[test]
    fn test_type_compare_helper_methods() {
        assert!(TypeCompare::Equal.is_equal());
        assert!(!TypeCompare::Narrow.is_equal());

        assert!(TypeCompare::Wider.is_wider());
        assert!(TypeCompare::WiderByGeneric.is_wider());
        assert!(!TypeCompare::Narrow.is_wider());

        assert!(TypeCompare::Narrow.is_narrow());
        assert!(TypeCompare::NarrowByGeneric.is_narrow());
        assert!(!TypeCompare::Wider.is_narrow());

        assert!(TypeCompare::Conflict.is_conflict());
        assert!(TypeCompare::ConflictByGeneric.is_conflict());
        assert!(!TypeCompare::Narrow.is_conflict());

        assert!(TypeCompare::Equal.is_wider_or_equal());
        assert!(TypeCompare::Wider.is_wider_or_equal());
        assert!(!TypeCompare::Narrow.is_wider_or_equal());

        assert!(TypeCompare::Equal.is_narrow_or_equal());
        assert!(TypeCompare::Narrow.is_narrow_or_equal());
        assert!(!TypeCompare::Wider.is_narrow_or_equal());
    }

    #[test]
    fn test_primitive_vs_object_conflict() {
        let int_type = ArgType::Int;
        let object = ArgType::Object("java/lang/Integer".to_string());

        // Primitives and objects conflict (no auto-boxing in type comparison)
        assert!(compare_types(&int_type, &object, None).is_conflict());
        assert!(compare_types(&object, &int_type, None).is_conflict());
    }

    #[test]
    fn test_multidimensional_arrays() {
        let int_arr = ArgType::Array(Box::new(ArgType::Int));
        let int_arr_2d = ArgType::Array(Box::new(ArgType::Array(Box::new(ArgType::Int))));
        let long_arr_2d = ArgType::Array(Box::new(ArgType::Array(Box::new(ArgType::Long))));

        // 1D vs 2D arrays - conflict
        assert!(compare_types(&int_arr, &int_arr_2d, None).is_conflict());

        // 2D int[][] vs 2D long[][] - element widening applies recursively
        assert_eq!(
            compare_types(&int_arr_2d, &long_arr_2d, None),
            TypeCompare::Narrow
        );
    }

    // === Wildcard variance tests (JADX parity) ===

    #[test]
    fn test_wildcard_unbounded() {
        let unbounded = ArgType::Wildcard {
            bound: WildcardBound::Unbounded,
            inner: None,
        };
        let string = ArgType::Object("java/lang/String".to_string());

        // ? is wider than any concrete type
        assert_eq!(compare_types(&unbounded, &string, None), TypeCompare::Wider);
        assert_eq!(compare_types(&string, &unbounded, None), TypeCompare::Narrow);

        // ? vs ? is equal
        let unbounded2 = ArgType::Wildcard {
            bound: WildcardBound::Unbounded,
            inner: None,
        };
        assert_eq!(
            compare_types(&unbounded, &unbounded2, None),
            TypeCompare::Equal
        );
    }

    #[test]
    fn test_wildcard_extends() {
        let hierarchy = crate::ClassHierarchy::new();

        // ? extends Number
        let extends_number = ArgType::Wildcard {
            bound: WildcardBound::Extends,
            inner: Some(Box::new(ArgType::Object("java/lang/Number".to_string()))),
        };

        let integer = ArgType::Object("java/lang/Integer".to_string());
        let number = ArgType::Object("java/lang/Number".to_string());
        let object = ArgType::Object("java/lang/Object".to_string());

        // Integer < Number, so Integer fits ? extends Number
        assert_eq!(
            compare_types(&extends_number, &integer, Some(&hierarchy)),
            TypeCompare::Wider
        );
        assert_eq!(
            compare_types(&integer, &extends_number, Some(&hierarchy)),
            TypeCompare::Narrow
        );

        // Number = Number, so Number fits ? extends Number
        assert_eq!(
            compare_types(&extends_number, &number, Some(&hierarchy)),
            TypeCompare::Wider
        );

        // Object > Number, so Object does NOT fit ? extends Number
        assert!(compare_types(&extends_number, &object, Some(&hierarchy)).is_conflict());
    }

    #[test]
    fn test_wildcard_super() {
        let hierarchy = crate::ClassHierarchy::new();

        // ? super Integer
        let super_integer = ArgType::Wildcard {
            bound: WildcardBound::Super,
            inner: Some(Box::new(ArgType::Object("java/lang/Integer".to_string()))),
        };

        let integer = ArgType::Object("java/lang/Integer".to_string());
        let number = ArgType::Object("java/lang/Number".to_string());
        let object = ArgType::Object("java/lang/Object".to_string());

        // Integer = Integer, so Integer fits ? super Integer
        assert_eq!(
            compare_types(&super_integer, &integer, Some(&hierarchy)),
            TypeCompare::Wider
        );

        // Number > Integer, so Number fits ? super Integer
        assert_eq!(
            compare_types(&super_integer, &number, Some(&hierarchy)),
            TypeCompare::Wider
        );

        // Object > Integer, so Object fits ? super Integer
        assert_eq!(
            compare_types(&super_integer, &object, Some(&hierarchy)),
            TypeCompare::Wider
        );
    }

    #[test]
    fn test_wildcard_vs_wildcard() {
        // ? extends String vs ? extends Object
        let extends_string = ArgType::Wildcard {
            bound: WildcardBound::Extends,
            inner: Some(Box::new(ArgType::Object("java/lang/String".to_string()))),
        };
        let extends_object = ArgType::Wildcard {
            bound: WildcardBound::Extends,
            inner: Some(Box::new(ArgType::Object("java/lang/Object".to_string()))),
        };

        // ? extends String is narrower than ? extends Object
        assert_eq!(
            compare_types(&extends_string, &extends_object, None),
            TypeCompare::Narrow
        );
        assert_eq!(
            compare_types(&extends_object, &extends_string, None),
            TypeCompare::Wider
        );

        // ? extends T vs ? super T should conflict
        let super_string = ArgType::Wildcard {
            bound: WildcardBound::Super,
            inner: Some(Box::new(ArgType::Object("java/lang/String".to_string()))),
        };
        assert!(compare_types(&extends_string, &super_string, None).is_conflict());
    }

    #[test]
    fn test_wildcard_unbounded_vs_bounded() {
        let unbounded = ArgType::Wildcard {
            bound: WildcardBound::Unbounded,
            inner: None,
        };
        let extends_number = ArgType::Wildcard {
            bound: WildcardBound::Extends,
            inner: Some(Box::new(ArgType::Object("java/lang/Number".to_string()))),
        };

        // Unbounded is wider than any bounded wildcard
        assert_eq!(
            compare_types(&unbounded, &extends_number, None),
            TypeCompare::Wider
        );
        assert_eq!(
            compare_types(&extends_number, &unbounded, None),
            TypeCompare::Narrow
        );
    }

    #[test]
    fn test_wildcard_vs_primitive_conflict() {
        let extends_number = ArgType::Wildcard {
            bound: WildcardBound::Extends,
            inner: Some(Box::new(ArgType::Object("java/lang/Number".to_string()))),
        };
        let int_type = ArgType::Int;

        // Wildcards only work with reference types
        assert!(compare_types(&extends_number, &int_type, None).is_conflict());
        assert!(compare_types(&int_type, &extends_number, None).is_conflict());
    }

    // === Type utility method tests (Phase 2) ===

    #[test]
    fn test_select_first_known_types() {
        // Known types should return None
        assert_eq!(ArgType::Int.select_first(), None);
        assert_eq!(ArgType::Long.select_first(), None);
        assert_eq!(ArgType::Object("java/lang/String".into()).select_first(), None);
        assert_eq!(ArgType::type_var("T").select_first(), None);
    }

    #[test]
    fn test_select_first_unknown_types() {
        // Unknown types should return preferred concrete type
        assert_eq!(
            ArgType::Unknown.select_first(),
            Some(ArgType::Object("java/lang/Object".into()))
        );
        assert_eq!(
            ArgType::UnknownObject.select_first(),
            Some(ArgType::Object("java/lang/Object".into()))
        );
        assert_eq!(ArgType::UnknownWide.select_first(), Some(ArgType::Long));
        assert_eq!(ArgType::UnknownIntegral.select_first(), Some(ArgType::Int));
        assert_eq!(ArgType::UnknownByteBoolean.select_first(), Some(ArgType::Byte));
        assert_eq!(
            ArgType::UnknownArray.select_first(),
            Some(ArgType::Array(Box::new(ArgType::Object("java/lang/Object".into()))))
        );
    }

    #[test]
    fn test_get_array_dimension() {
        assert_eq!(ArgType::Int.get_array_dimension(), 0);
        assert_eq!(ArgType::Object("java/lang/String".into()).get_array_dimension(), 0);
        assert_eq!(ArgType::Array(Box::new(ArgType::Int)).get_array_dimension(), 1);
        assert_eq!(
            ArgType::Array(Box::new(ArgType::Array(Box::new(ArgType::Int)))).get_array_dimension(),
            2
        );
        assert_eq!(
            ArgType::Array(Box::new(ArgType::Array(Box::new(ArgType::Array(Box::new(
                ArgType::Object("java/lang/String".into())
            ))))))
            .get_array_dimension(),
            3
        );
    }

    #[test]
    fn test_contains_type_variable() {
        // Simple cases
        assert!(!ArgType::Int.contains_type_variable());
        assert!(!ArgType::Object("java/lang/String".into()).contains_type_variable());
        assert!(ArgType::type_var("T").contains_type_variable());

        // Nested in array
        assert!(ArgType::Array(Box::new(ArgType::type_var("T"))).contains_type_variable());
        assert!(!ArgType::Array(Box::new(ArgType::Int)).contains_type_variable());

        // Nested in generic
        let generic_with_var = ArgType::Generic {
            base: "java/util/List".into(),
            params: vec![ArgType::type_var("E")],
        };
        assert!(generic_with_var.contains_type_variable());

        let generic_without_var = ArgType::Generic {
            base: "java/util/List".into(),
            params: vec![ArgType::Object("java/lang/String".into())],
        };
        assert!(!generic_without_var.contains_type_variable());
    }

    #[test]
    fn test_contains_generic() {
        // Non-generic types
        assert!(!ArgType::Int.contains_generic());
        assert!(!ArgType::Object("java/lang/String".into()).contains_generic());

        // Generic types
        assert!(ArgType::type_var("T").contains_generic());
        assert!(ArgType::Generic {
            base: "java/util/List".into(),
            params: vec![ArgType::Object("java/lang/String".into())],
        }
        .contains_generic());
        assert!(ArgType::Wildcard {
            bound: WildcardBound::Unbounded,
            inner: None,
        }
        .contains_generic());

        // Nested in array
        assert!(ArgType::Array(Box::new(ArgType::type_var("T"))).contains_generic());
        assert!(!ArgType::Array(Box::new(ArgType::Int)).contains_generic());
    }

    #[test]
    fn test_visit_types() {
        let complex_type = ArgType::Generic {
            base: "java/util/Map".into(),
            params: vec![
                ArgType::Object("java/lang/String".into()),
                ArgType::Array(Box::new(ArgType::Int)),
            ],
        };

        let mut visited = Vec::new();
        complex_type.visit_types(&mut |t| {
            visited.push(t.short_name());
        });

        // Should visit: Map<String,int[]>, String, int[], int
        assert_eq!(visited.len(), 4);
        assert!(visited.contains(&"Map<String,I[]>".to_string()));
        assert!(visited.contains(&"String".to_string()));
        assert!(visited.contains(&"I[]".to_string()));
        assert!(visited.contains(&"I".to_string()));
    }
}
