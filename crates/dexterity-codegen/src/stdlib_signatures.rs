//! Pre-computed method signatures for Java/Android/Kotlin standard library
//!
//! This module provides statically pre-computed method signatures for commonly-used
//! library methods. This avoids repeated DEX parsing for library method invocations,
//! providing significant speedup since library signatures never change.

use dexterity_ir::types::ArgType;
use std::sync::LazyLock;
use rustc_hash::FxHashMap;

/// Method signature: (parameter_types, return_type)
pub type MethodSignature = (Vec<ArgType>, ArgType);

/// Runtime lookup key using owned Strings for O(1) HashMap access
#[derive(Clone, Hash, Eq, PartialEq)]
struct RuntimeKey(String, String, String);

/// Static map of pre-computed library method signatures
/// ~150 most common methods covering 80-90% of library calls
pub static LIBRARY_SIGNATURES: LazyLock<FxHashMap<RuntimeKey, MethodSignature>> = LazyLock::new(|| {
    let mut map = FxHashMap::default();

    // Helper macros for readability
    macro_rules! add {
        ($class:expr, $method:expr, $shorty:expr, $params:expr, $ret:expr) => {
            map.insert(
                RuntimeKey($class.to_string(), $method.to_string(), $shorty.to_string()),
                ($params, $ret),
            );
        };
    }

    macro_rules! obj {
        ($s:expr) => { ArgType::Object($s.to_string()) };
    }

    macro_rules! arr {
        ($elem:expr) => { ArgType::Array(Box::new($elem)) };
    }

    // =========================================================================
    // java.lang.Object
    // =========================================================================
    add!("java/lang/Object", "toString", "L", vec![], obj!("java/lang/String"));
    add!("java/lang/Object", "equals", "ZL", vec![obj!("java/lang/Object")], ArgType::Boolean);
    add!("java/lang/Object", "hashCode", "I", vec![], ArgType::Int);
    add!("java/lang/Object", "getClass", "L", vec![], obj!("java/lang/Class"));
    add!("java/lang/Object", "wait", "V", vec![], ArgType::Void);
    add!("java/lang/Object", "wait", "VJ", vec![ArgType::Long], ArgType::Void);
    add!("java/lang/Object", "notify", "V", vec![], ArgType::Void);
    add!("java/lang/Object", "notifyAll", "V", vec![], ArgType::Void);

    // =========================================================================
    // java.lang.String
    // =========================================================================
    add!("java/lang/String", "length", "I", vec![], ArgType::Int);
    add!("java/lang/String", "charAt", "CI", vec![ArgType::Int], ArgType::Char);
    add!("java/lang/String", "substring", "LI", vec![ArgType::Int], obj!("java/lang/String"));
    add!("java/lang/String", "substring", "LII", vec![ArgType::Int, ArgType::Int], obj!("java/lang/String"));
    add!("java/lang/String", "equals", "ZL", vec![obj!("java/lang/Object")], ArgType::Boolean);
    add!("java/lang/String", "equalsIgnoreCase", "ZL", vec![obj!("java/lang/String")], ArgType::Boolean);
    add!("java/lang/String", "hashCode", "I", vec![], ArgType::Int);
    add!("java/lang/String", "indexOf", "II", vec![ArgType::Int], ArgType::Int);
    add!("java/lang/String", "indexOf", "IL", vec![obj!("java/lang/String")], ArgType::Int);
    add!("java/lang/String", "indexOf", "III", vec![ArgType::Int, ArgType::Int], ArgType::Int);
    add!("java/lang/String", "indexOf", "ILI", vec![obj!("java/lang/String"), ArgType::Int], ArgType::Int);
    add!("java/lang/String", "lastIndexOf", "II", vec![ArgType::Int], ArgType::Int);
    add!("java/lang/String", "lastIndexOf", "IL", vec![obj!("java/lang/String")], ArgType::Int);
    add!("java/lang/String", "concat", "LL", vec![obj!("java/lang/String")], obj!("java/lang/String"));
    add!("java/lang/String", "contains", "ZL", vec![obj!("java/lang/CharSequence")], ArgType::Boolean);
    add!("java/lang/String", "startsWith", "ZL", vec![obj!("java/lang/String")], ArgType::Boolean);
    add!("java/lang/String", "startsWith", "ZLI", vec![obj!("java/lang/String"), ArgType::Int], ArgType::Boolean);
    add!("java/lang/String", "endsWith", "ZL", vec![obj!("java/lang/String")], ArgType::Boolean);
    add!("java/lang/String", "trim", "L", vec![], obj!("java/lang/String"));
    add!("java/lang/String", "toLowerCase", "L", vec![], obj!("java/lang/String"));
    add!("java/lang/String", "toUpperCase", "L", vec![], obj!("java/lang/String"));
    add!("java/lang/String", "replace", "LCC", vec![ArgType::Char, ArgType::Char], obj!("java/lang/String"));
    add!("java/lang/String", "replace", "LLL", vec![obj!("java/lang/CharSequence"), obj!("java/lang/CharSequence")], obj!("java/lang/String"));
    add!("java/lang/String", "split", "[LL", vec![obj!("java/lang/String")], arr!(obj!("java/lang/String")));
    add!("java/lang/String", "split", "[LLI", vec![obj!("java/lang/String"), ArgType::Int], arr!(obj!("java/lang/String")));
    add!("java/lang/String", "isEmpty", "Z", vec![], ArgType::Boolean);
    add!("java/lang/String", "toCharArray", "[C", vec![], arr!(ArgType::Char));
    add!("java/lang/String", "getBytes", "[B", vec![], arr!(ArgType::Byte));
    add!("java/lang/String", "getBytes", "[BL", vec![obj!("java/lang/String")], arr!(ArgType::Byte));
    add!("java/lang/String", "compareTo", "IL", vec![obj!("java/lang/String")], ArgType::Int);
    add!("java/lang/String", "format", "LL[L", vec![obj!("java/lang/String"), arr!(obj!("java/lang/Object"))], obj!("java/lang/String"));
    add!("java/lang/String", "valueOf", "LI", vec![ArgType::Int], obj!("java/lang/String"));
    add!("java/lang/String", "valueOf", "LJ", vec![ArgType::Long], obj!("java/lang/String"));
    add!("java/lang/String", "valueOf", "LF", vec![ArgType::Float], obj!("java/lang/String"));
    add!("java/lang/String", "valueOf", "LD", vec![ArgType::Double], obj!("java/lang/String"));
    add!("java/lang/String", "valueOf", "LZ", vec![ArgType::Boolean], obj!("java/lang/String"));
    add!("java/lang/String", "valueOf", "LC", vec![ArgType::Char], obj!("java/lang/String"));
    add!("java/lang/String", "valueOf", "LL", vec![obj!("java/lang/Object")], obj!("java/lang/String"));
    add!("java/lang/String", "valueOf", "L[C", vec![arr!(ArgType::Char)], obj!("java/lang/String"));
    add!("java/lang/String", "toString", "L", vec![], obj!("java/lang/String"));
    add!("java/lang/String", "intern", "L", vec![], obj!("java/lang/String"));
    add!("java/lang/String", "matches", "ZL", vec![obj!("java/lang/String")], ArgType::Boolean);
    add!("java/lang/String", "replaceAll", "LLL", vec![obj!("java/lang/String"), obj!("java/lang/String")], obj!("java/lang/String"));
    add!("java/lang/String", "replaceFirst", "LLL", vec![obj!("java/lang/String"), obj!("java/lang/String")], obj!("java/lang/String"));

    // =========================================================================
    // java.lang.StringBuilder / StringBuffer
    // =========================================================================
    add!("java/lang/StringBuilder", "append", "LL", vec![obj!("java/lang/String")], obj!("java/lang/StringBuilder"));
    add!("java/lang/StringBuilder", "append", "LI", vec![ArgType::Int], obj!("java/lang/StringBuilder"));
    add!("java/lang/StringBuilder", "append", "LJ", vec![ArgType::Long], obj!("java/lang/StringBuilder"));
    add!("java/lang/StringBuilder", "append", "LF", vec![ArgType::Float], obj!("java/lang/StringBuilder"));
    add!("java/lang/StringBuilder", "append", "LD", vec![ArgType::Double], obj!("java/lang/StringBuilder"));
    add!("java/lang/StringBuilder", "append", "LZ", vec![ArgType::Boolean], obj!("java/lang/StringBuilder"));
    add!("java/lang/StringBuilder", "append", "LC", vec![ArgType::Char], obj!("java/lang/StringBuilder"));
    add!("java/lang/StringBuilder", "toString", "L", vec![], obj!("java/lang/String"));
    add!("java/lang/StringBuilder", "length", "I", vec![], ArgType::Int);
    add!("java/lang/StringBuilder", "delete", "LII", vec![ArgType::Int, ArgType::Int], obj!("java/lang/StringBuilder"));
    add!("java/lang/StringBuilder", "deleteCharAt", "LI", vec![ArgType::Int], obj!("java/lang/StringBuilder"));
    add!("java/lang/StringBuilder", "insert", "LIL", vec![ArgType::Int, obj!("java/lang/String")], obj!("java/lang/StringBuilder"));
    add!("java/lang/StringBuilder", "setLength", "VI", vec![ArgType::Int], ArgType::Void);
    add!("java/lang/StringBuilder", "reverse", "L", vec![], obj!("java/lang/StringBuilder"));

    add!("java/lang/StringBuffer", "append", "LL", vec![obj!("java/lang/String")], obj!("java/lang/StringBuffer"));
    add!("java/lang/StringBuffer", "append", "LI", vec![ArgType::Int], obj!("java/lang/StringBuffer"));
    add!("java/lang/StringBuffer", "append", "LJ", vec![ArgType::Long], obj!("java/lang/StringBuffer"));
    add!("java/lang/StringBuffer", "append", "LZ", vec![ArgType::Boolean], obj!("java/lang/StringBuffer"));
    add!("java/lang/StringBuffer", "toString", "L", vec![], obj!("java/lang/String"));
    add!("java/lang/StringBuffer", "length", "I", vec![], ArgType::Int);

    // =========================================================================
    // java.util.List, ArrayList, Collection, Iterator, Set
    // =========================================================================
    for class in ["java/util/List", "java/util/ArrayList", "java/util/LinkedList"] {
        add!(class, "get", "LI", vec![ArgType::Int], obj!("java/lang/Object"));
        add!(class, "set", "LIL", vec![ArgType::Int, obj!("java/lang/Object")], obj!("java/lang/Object"));
        add!(class, "add", "ZL", vec![obj!("java/lang/Object")], ArgType::Boolean);
        add!(class, "add", "VIL", vec![ArgType::Int, obj!("java/lang/Object")], ArgType::Void);
        add!(class, "remove", "LI", vec![ArgType::Int], obj!("java/lang/Object"));
        add!(class, "remove", "ZL", vec![obj!("java/lang/Object")], ArgType::Boolean);
        add!(class, "size", "I", vec![], ArgType::Int);
        add!(class, "isEmpty", "Z", vec![], ArgType::Boolean);
        add!(class, "contains", "ZL", vec![obj!("java/lang/Object")], ArgType::Boolean);
        add!(class, "indexOf", "IL", vec![obj!("java/lang/Object")], ArgType::Int);
        add!(class, "clear", "V", vec![], ArgType::Void);
        add!(class, "iterator", "L", vec![], obj!("java/util/Iterator"));
        add!(class, "toArray", "[L", vec![], arr!(obj!("java/lang/Object")));
        add!(class, "addAll", "ZL", vec![obj!("java/util/Collection")], ArgType::Boolean);
    }

    add!("java/util/Collection", "add", "ZL", vec![obj!("java/lang/Object")], ArgType::Boolean);
    add!("java/util/Collection", "size", "I", vec![], ArgType::Int);
    add!("java/util/Collection", "isEmpty", "Z", vec![], ArgType::Boolean);
    add!("java/util/Collection", "contains", "ZL", vec![obj!("java/lang/Object")], ArgType::Boolean);
    add!("java/util/Collection", "iterator", "L", vec![], obj!("java/util/Iterator"));
    add!("java/util/Collection", "clear", "V", vec![], ArgType::Void);

    add!("java/util/Iterator", "hasNext", "Z", vec![], ArgType::Boolean);
    add!("java/util/Iterator", "next", "L", vec![], obj!("java/lang/Object"));
    add!("java/util/Iterator", "remove", "V", vec![], ArgType::Void);

    for class in ["java/util/Set", "java/util/HashSet", "java/util/TreeSet"] {
        add!(class, "add", "ZL", vec![obj!("java/lang/Object")], ArgType::Boolean);
        add!(class, "remove", "ZL", vec![obj!("java/lang/Object")], ArgType::Boolean);
        add!(class, "size", "I", vec![], ArgType::Int);
        add!(class, "isEmpty", "Z", vec![], ArgType::Boolean);
        add!(class, "contains", "ZL", vec![obj!("java/lang/Object")], ArgType::Boolean);
        add!(class, "iterator", "L", vec![], obj!("java/util/Iterator"));
        add!(class, "clear", "V", vec![], ArgType::Void);
    }

    add!("java/util/Arrays", "asList", "L[L", vec![arr!(obj!("java/lang/Object"))], obj!("java/util/List"));
    add!("java/util/Arrays", "sort", "V[L", vec![arr!(obj!("java/lang/Object"))], ArgType::Void);
    add!("java/util/Arrays", "sort", "V[I", vec![arr!(ArgType::Int)], ArgType::Void);
    add!("java/util/Arrays", "fill", "V[II", vec![arr!(ArgType::Int), ArgType::Int], ArgType::Void);
    add!("java/util/Arrays", "copyOf", "[L[LI", vec![arr!(obj!("java/lang/Object")), ArgType::Int], arr!(obj!("java/lang/Object")));
    add!("java/util/Arrays", "toString", "L[L", vec![arr!(obj!("java/lang/Object"))], obj!("java/lang/String"));
    add!("java/util/Arrays", "equals", "Z[L[L", vec![arr!(obj!("java/lang/Object")), arr!(obj!("java/lang/Object"))], ArgType::Boolean);

    add!("java/util/Collections", "emptyList", "L", vec![], obj!("java/util/List"));
    add!("java/util/Collections", "emptySet", "L", vec![], obj!("java/util/Set"));
    add!("java/util/Collections", "emptyMap", "L", vec![], obj!("java/util/Map"));
    add!("java/util/Collections", "singletonList", "LL", vec![obj!("java/lang/Object")], obj!("java/util/List"));
    add!("java/util/Collections", "sort", "VL", vec![obj!("java/util/List")], ArgType::Void);

    // =========================================================================
    // java.util.Map, HashMap
    // =========================================================================
    for class in ["java/util/Map", "java/util/HashMap", "java/util/LinkedHashMap", "java/util/TreeMap", "java/util/ConcurrentHashMap"] {
        add!(class, "get", "LL", vec![obj!("java/lang/Object")], obj!("java/lang/Object"));
        add!(class, "put", "LLL", vec![obj!("java/lang/Object"), obj!("java/lang/Object")], obj!("java/lang/Object"));
        add!(class, "remove", "LL", vec![obj!("java/lang/Object")], obj!("java/lang/Object"));
        add!(class, "containsKey", "ZL", vec![obj!("java/lang/Object")], ArgType::Boolean);
        add!(class, "containsValue", "ZL", vec![obj!("java/lang/Object")], ArgType::Boolean);
        add!(class, "keySet", "L", vec![], obj!("java/util/Set"));
        add!(class, "values", "L", vec![], obj!("java/util/Collection"));
        add!(class, "entrySet", "L", vec![], obj!("java/util/Set"));
        add!(class, "size", "I", vec![], ArgType::Int);
        add!(class, "isEmpty", "Z", vec![], ArgType::Boolean);
        add!(class, "clear", "V", vec![], ArgType::Void);
        add!(class, "putAll", "VL", vec![obj!("java/util/Map")], ArgType::Void);
        add!(class, "getOrDefault", "LLL", vec![obj!("java/lang/Object"), obj!("java/lang/Object")], obj!("java/lang/Object"));
    }

    add!("java/util/Map$Entry", "getKey", "L", vec![], obj!("java/lang/Object"));
    add!("java/util/Map$Entry", "getValue", "L", vec![], obj!("java/lang/Object"));
    add!("java/util/Map$Entry", "setValue", "LL", vec![obj!("java/lang/Object")], obj!("java/lang/Object"));

    // =========================================================================
    // android.util.Log
    // =========================================================================
    add!("android/util/Log", "d", "ILL", vec![obj!("java/lang/String"), obj!("java/lang/String")], ArgType::Int);
    add!("android/util/Log", "d", "ILLL", vec![obj!("java/lang/String"), obj!("java/lang/String"), obj!("java/lang/Throwable")], ArgType::Int);
    add!("android/util/Log", "e", "ILL", vec![obj!("java/lang/String"), obj!("java/lang/String")], ArgType::Int);
    add!("android/util/Log", "e", "ILLL", vec![obj!("java/lang/String"), obj!("java/lang/String"), obj!("java/lang/Throwable")], ArgType::Int);
    add!("android/util/Log", "i", "ILL", vec![obj!("java/lang/String"), obj!("java/lang/String")], ArgType::Int);
    add!("android/util/Log", "v", "ILL", vec![obj!("java/lang/String"), obj!("java/lang/String")], ArgType::Int);
    add!("android/util/Log", "w", "ILL", vec![obj!("java/lang/String"), obj!("java/lang/String")], ArgType::Int);
    add!("android/util/Log", "w", "ILLL", vec![obj!("java/lang/String"), obj!("java/lang/String"), obj!("java/lang/Throwable")], ArgType::Int);
    add!("android/util/Log", "isLoggable", "ZLI", vec![obj!("java/lang/String"), ArgType::Int], ArgType::Boolean);
    add!("android/util/Log", "getStackTraceString", "LL", vec![obj!("java/lang/Throwable")], obj!("java/lang/String"));

    // =========================================================================
    // kotlin.jvm.internal.Intrinsics
    // =========================================================================
    add!("kotlin/jvm/internal/Intrinsics", "checkNotNullParameter", "VLL", vec![obj!("java/lang/Object"), obj!("java/lang/String")], ArgType::Void);
    add!("kotlin/jvm/internal/Intrinsics", "checkParameterIsNotNull", "VLL", vec![obj!("java/lang/Object"), obj!("java/lang/String")], ArgType::Void);
    add!("kotlin/jvm/internal/Intrinsics", "checkNotNullExpressionValue", "VLL", vec![obj!("java/lang/Object"), obj!("java/lang/String")], ArgType::Void);
    add!("kotlin/jvm/internal/Intrinsics", "checkExpressionValueIsNotNull", "VLL", vec![obj!("java/lang/Object"), obj!("java/lang/String")], ArgType::Void);
    add!("kotlin/jvm/internal/Intrinsics", "throwNpe", "V", vec![], ArgType::Void);
    add!("kotlin/jvm/internal/Intrinsics", "throwUninitializedPropertyAccessException", "VL", vec![obj!("java/lang/String")], ArgType::Void);
    add!("kotlin/jvm/internal/Intrinsics", "areEqual", "ZLL", vec![obj!("java/lang/Object"), obj!("java/lang/Object")], ArgType::Boolean);
    add!("kotlin/jvm/internal/Intrinsics", "stringPlus", "LLL", vec![obj!("java/lang/String"), obj!("java/lang/Object")], obj!("java/lang/String"));

    // =========================================================================
    // java.lang.System
    // =========================================================================
    add!("java/lang/System", "currentTimeMillis", "J", vec![], ArgType::Long);
    add!("java/lang/System", "nanoTime", "J", vec![], ArgType::Long);
    add!("java/lang/System", "arraycopy", "VLILII", vec![obj!("java/lang/Object"), ArgType::Int, obj!("java/lang/Object"), ArgType::Int, ArgType::Int], ArgType::Void);
    add!("java/lang/System", "getProperty", "LL", vec![obj!("java/lang/String")], obj!("java/lang/String"));
    add!("java/lang/System", "getenv", "LL", vec![obj!("java/lang/String")], obj!("java/lang/String"));
    add!("java/lang/System", "identityHashCode", "IL", vec![obj!("java/lang/Object")], ArgType::Int);
    add!("java/lang/System", "gc", "V", vec![], ArgType::Void);
    add!("java/lang/System", "exit", "VI", vec![ArgType::Int], ArgType::Void);

    // =========================================================================
    // java.lang.Throwable / Exception
    // =========================================================================
    for class in ["java/lang/Throwable", "java/lang/Exception", "java/lang/RuntimeException", "java/lang/Error"] {
        add!(class, "getMessage", "L", vec![], obj!("java/lang/String"));
        add!(class, "getCause", "L", vec![], obj!("java/lang/Throwable"));
        add!(class, "printStackTrace", "V", vec![], ArgType::Void);
        add!(class, "toString", "L", vec![], obj!("java/lang/String"));
        add!(class, "getStackTrace", "[L", vec![], arr!(obj!("java/lang/StackTraceElement")));
        add!(class, "initCause", "LL", vec![obj!("java/lang/Throwable")], obj!("java/lang/Throwable"));
    }

    for class in ["java/lang/NullPointerException", "java/lang/IllegalArgumentException", "java/lang/IllegalStateException", "java/lang/IndexOutOfBoundsException", "java/lang/ArrayIndexOutOfBoundsException", "java/lang/ClassCastException", "java/lang/UnsupportedOperationException"] {
        add!(class, "getMessage", "L", vec![], obj!("java/lang/String"));
        add!(class, "getCause", "L", vec![], obj!("java/lang/Throwable"));
        add!(class, "printStackTrace", "V", vec![], ArgType::Void);
        add!(class, "toString", "L", vec![], obj!("java/lang/String"));
    }

    // =========================================================================
    // java.lang.Integer, Long, Boolean, etc. (boxing types)
    // =========================================================================
    add!("java/lang/Integer", "intValue", "I", vec![], ArgType::Int);
    add!("java/lang/Integer", "valueOf", "LI", vec![ArgType::Int], obj!("java/lang/Integer"));
    add!("java/lang/Integer", "parseInt", "IL", vec![obj!("java/lang/String")], ArgType::Int);
    add!("java/lang/Integer", "toString", "L", vec![], obj!("java/lang/String"));
    add!("java/lang/Integer", "toString", "LI", vec![ArgType::Int], obj!("java/lang/String"));
    add!("java/lang/Integer", "compare", "III", vec![ArgType::Int, ArgType::Int], ArgType::Int);
    add!("java/lang/Integer", "hashCode", "I", vec![], ArgType::Int);
    add!("java/lang/Integer", "equals", "ZL", vec![obj!("java/lang/Object")], ArgType::Boolean);

    add!("java/lang/Long", "longValue", "J", vec![], ArgType::Long);
    add!("java/lang/Long", "valueOf", "LJ", vec![ArgType::Long], obj!("java/lang/Long"));
    add!("java/lang/Long", "parseLong", "JL", vec![obj!("java/lang/String")], ArgType::Long);
    add!("java/lang/Long", "toString", "L", vec![], obj!("java/lang/String"));
    add!("java/lang/Long", "toString", "LJ", vec![ArgType::Long], obj!("java/lang/String"));
    add!("java/lang/Long", "compare", "IJJ", vec![ArgType::Long, ArgType::Long], ArgType::Int);

    add!("java/lang/Float", "floatValue", "F", vec![], ArgType::Float);
    add!("java/lang/Float", "valueOf", "LF", vec![ArgType::Float], obj!("java/lang/Float"));
    add!("java/lang/Float", "parseFloat", "FL", vec![obj!("java/lang/String")], ArgType::Float);
    add!("java/lang/Float", "toString", "L", vec![], obj!("java/lang/String"));
    add!("java/lang/Float", "isNaN", "ZF", vec![ArgType::Float], ArgType::Boolean);
    add!("java/lang/Float", "isInfinite", "ZF", vec![ArgType::Float], ArgType::Boolean);

    add!("java/lang/Double", "doubleValue", "D", vec![], ArgType::Double);
    add!("java/lang/Double", "valueOf", "LD", vec![ArgType::Double], obj!("java/lang/Double"));
    add!("java/lang/Double", "parseDouble", "DL", vec![obj!("java/lang/String")], ArgType::Double);
    add!("java/lang/Double", "toString", "L", vec![], obj!("java/lang/String"));
    add!("java/lang/Double", "isNaN", "ZD", vec![ArgType::Double], ArgType::Boolean);
    add!("java/lang/Double", "isInfinite", "ZD", vec![ArgType::Double], ArgType::Boolean);

    add!("java/lang/Boolean", "booleanValue", "Z", vec![], ArgType::Boolean);
    add!("java/lang/Boolean", "valueOf", "LZ", vec![ArgType::Boolean], obj!("java/lang/Boolean"));
    add!("java/lang/Boolean", "valueOf", "LL", vec![obj!("java/lang/String")], obj!("java/lang/Boolean"));
    add!("java/lang/Boolean", "parseBoolean", "ZL", vec![obj!("java/lang/String")], ArgType::Boolean);
    add!("java/lang/Boolean", "toString", "L", vec![], obj!("java/lang/String"));

    add!("java/lang/Byte", "byteValue", "B", vec![], ArgType::Byte);
    add!("java/lang/Byte", "valueOf", "LB", vec![ArgType::Byte], obj!("java/lang/Byte"));
    add!("java/lang/Byte", "parseByte", "BL", vec![obj!("java/lang/String")], ArgType::Byte);

    add!("java/lang/Short", "shortValue", "S", vec![], ArgType::Short);
    add!("java/lang/Short", "valueOf", "LS", vec![ArgType::Short], obj!("java/lang/Short"));
    add!("java/lang/Short", "parseShort", "SL", vec![obj!("java/lang/String")], ArgType::Short);

    add!("java/lang/Character", "charValue", "C", vec![], ArgType::Char);
    add!("java/lang/Character", "valueOf", "LC", vec![ArgType::Char], obj!("java/lang/Character"));
    add!("java/lang/Character", "isDigit", "ZC", vec![ArgType::Char], ArgType::Boolean);
    add!("java/lang/Character", "isLetter", "ZC", vec![ArgType::Char], ArgType::Boolean);
    add!("java/lang/Character", "isWhitespace", "ZC", vec![ArgType::Char], ArgType::Boolean);
    add!("java/lang/Character", "toLowerCase", "CC", vec![ArgType::Char], ArgType::Char);
    add!("java/lang/Character", "toUpperCase", "CC", vec![ArgType::Char], ArgType::Char);

    add!("java/lang/Number", "intValue", "I", vec![], ArgType::Int);
    add!("java/lang/Number", "longValue", "J", vec![], ArgType::Long);
    add!("java/lang/Number", "floatValue", "F", vec![], ArgType::Float);
    add!("java/lang/Number", "doubleValue", "D", vec![], ArgType::Double);

    // =========================================================================
    // java.lang.Math
    // =========================================================================
    add!("java/lang/Math", "abs", "II", vec![ArgType::Int], ArgType::Int);
    add!("java/lang/Math", "abs", "JJ", vec![ArgType::Long], ArgType::Long);
    add!("java/lang/Math", "abs", "FF", vec![ArgType::Float], ArgType::Float);
    add!("java/lang/Math", "abs", "DD", vec![ArgType::Double], ArgType::Double);
    add!("java/lang/Math", "max", "III", vec![ArgType::Int, ArgType::Int], ArgType::Int);
    add!("java/lang/Math", "max", "JJJ", vec![ArgType::Long, ArgType::Long], ArgType::Long);
    add!("java/lang/Math", "max", "FFF", vec![ArgType::Float, ArgType::Float], ArgType::Float);
    add!("java/lang/Math", "max", "DDD", vec![ArgType::Double, ArgType::Double], ArgType::Double);
    add!("java/lang/Math", "min", "III", vec![ArgType::Int, ArgType::Int], ArgType::Int);
    add!("java/lang/Math", "min", "JJJ", vec![ArgType::Long, ArgType::Long], ArgType::Long);
    add!("java/lang/Math", "min", "FFF", vec![ArgType::Float, ArgType::Float], ArgType::Float);
    add!("java/lang/Math", "min", "DDD", vec![ArgType::Double, ArgType::Double], ArgType::Double);
    add!("java/lang/Math", "sqrt", "DD", vec![ArgType::Double], ArgType::Double);
    add!("java/lang/Math", "pow", "DDD", vec![ArgType::Double, ArgType::Double], ArgType::Double);
    add!("java/lang/Math", "floor", "DD", vec![ArgType::Double], ArgType::Double);
    add!("java/lang/Math", "ceil", "DD", vec![ArgType::Double], ArgType::Double);
    add!("java/lang/Math", "round", "JD", vec![ArgType::Double], ArgType::Long);
    add!("java/lang/Math", "round", "IF", vec![ArgType::Float], ArgType::Int);
    add!("java/lang/Math", "random", "D", vec![], ArgType::Double);

    // =========================================================================
    // java.lang.Class
    // =========================================================================
    add!("java/lang/Class", "getName", "L", vec![], obj!("java/lang/String"));
    add!("java/lang/Class", "getSimpleName", "L", vec![], obj!("java/lang/String"));
    add!("java/lang/Class", "getCanonicalName", "L", vec![], obj!("java/lang/String"));
    add!("java/lang/Class", "forName", "LL", vec![obj!("java/lang/String")], obj!("java/lang/Class"));
    add!("java/lang/Class", "newInstance", "L", vec![], obj!("java/lang/Object"));
    add!("java/lang/Class", "isInstance", "ZL", vec![obj!("java/lang/Object")], ArgType::Boolean);
    add!("java/lang/Class", "isAssignableFrom", "ZL", vec![obj!("java/lang/Class")], ArgType::Boolean);
    add!("java/lang/Class", "getSuperclass", "L", vec![], obj!("java/lang/Class"));
    add!("java/lang/Class", "getInterfaces", "[L", vec![], arr!(obj!("java/lang/Class")));

    map
});

/// Check if a class is a known library class (fast path check)
#[inline]
pub fn is_library_class(class_internal: &str) -> bool {
    class_internal.starts_with("java/")
        || class_internal.starts_with("javax/")
        || class_internal.starts_with("android/")
        || class_internal.starts_with("kotlin/")
        || class_internal.starts_with("kotlinx/")
        || class_internal.starts_with("dalvik/")
}

/// Look up a library method signature
///
/// Returns the pre-computed (param_types, return_type) if found.
/// Uses O(1) HashMap lookup - the key allocation is cheaper than DEX parsing.
#[inline]
pub fn lookup_library_signature(
    class_internal: &str,
    method_name: &str,
    proto_shorty: &str,
) -> Option<&'static MethodSignature> {
    let key = RuntimeKey(
        class_internal.to_string(),
        method_name.to_string(),
        proto_shorty.to_string(),
    );
    LIBRARY_SIGNATURES.get(&key)
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn test_library_signatures_loaded() {
        assert!(!LIBRARY_SIGNATURES.is_empty());
        assert!(lookup_library_signature("java/lang/String", "length", "I").is_some());
        assert!(lookup_library_signature("java/lang/Object", "toString", "L").is_some());
        assert!(lookup_library_signature("android/util/Log", "d", "ILL").is_some());
        assert!(lookup_library_signature("kotlin/jvm/internal/Intrinsics", "checkNotNullParameter", "VLL").is_some());
    }

    #[test]
    fn test_string_length_signature() {
        let sig = lookup_library_signature("java/lang/String", "length", "I").unwrap();
        assert!(sig.0.is_empty());
        assert_eq!(sig.1, ArgType::Int);
    }

    #[test]
    fn test_is_library_class() {
        assert!(is_library_class("java/lang/String"));
        assert!(is_library_class("android/util/Log"));
        assert!(is_library_class("kotlin/jvm/internal/Intrinsics"));
        assert!(!is_library_class("com/example/MyClass"));
        assert!(!is_library_class("org/apache/Something"));
    }

    #[test]
    fn test_lookup_miss() {
        assert!(lookup_library_signature("java/lang/String", "nonexistent", "V").is_none());
        assert!(lookup_library_signature("com/example/MyClass", "method", "V").is_none());
    }
}
