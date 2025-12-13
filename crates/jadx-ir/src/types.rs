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
        // Unknown is compatible with everything
        (Unknown, _) | (_, Unknown) => TypeCompare::Equal,

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
                TypeCompare::Conflict
            }
        }

        // Wildcard comparisons (simplified for now)
        (Wildcard { .. }, _) | (_, Wildcard { .. }) => TypeCompare::Unknown,

        // Primitive vs object/array = conflict
        _ => TypeCompare::Conflict,
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
}
