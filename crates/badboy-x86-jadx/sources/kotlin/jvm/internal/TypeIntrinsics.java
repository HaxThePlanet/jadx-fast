package kotlin.jvm.internal;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/* loaded from: classes5.dex */
public class TypeIntrinsics {
    public static Collection asMutableCollection(Object obj) {
        boolean str;
        if (obj instanceof KMappedMarker && obj instanceof KMutableCollection == null) {
            if (obj instanceof KMutableCollection == null) {
                TypeIntrinsics.throwCce(obj, "kotlin.collections.MutableCollection");
            }
        }
        return TypeIntrinsics.castToCollection(obj);
    }

    public static Collection asMutableCollection(Object obj, String message) {
        boolean z;
        if (obj instanceof KMappedMarker && obj instanceof KMutableCollection == null) {
            if (obj instanceof KMutableCollection == null) {
                TypeIntrinsics.throwCce(message);
            }
        }
        return TypeIntrinsics.castToCollection(obj);
    }

    public static Iterable asMutableIterable(Object obj) {
        boolean str;
        if (obj instanceof KMappedMarker && !obj instanceof KMutableIterable) {
            if (!obj instanceof KMutableIterable) {
                TypeIntrinsics.throwCce(obj, "kotlin.collections.MutableIterable");
            }
        }
        return TypeIntrinsics.castToIterable(obj);
    }

    public static Iterable asMutableIterable(Object obj, String message) {
        boolean z;
        if (obj instanceof KMappedMarker && !obj instanceof KMutableIterable) {
            if (!obj instanceof KMutableIterable) {
                TypeIntrinsics.throwCce(message);
            }
        }
        return TypeIntrinsics.castToIterable(obj);
    }

    public static Iterator asMutableIterator(Object obj) {
        boolean str;
        if (obj instanceof KMappedMarker && !obj instanceof KMutableIterator) {
            if (!obj instanceof KMutableIterator) {
                TypeIntrinsics.throwCce(obj, "kotlin.collections.MutableIterator");
            }
        }
        return TypeIntrinsics.castToIterator(obj);
    }

    public static Iterator asMutableIterator(Object obj, String message) {
        boolean z;
        if (obj instanceof KMappedMarker && !obj instanceof KMutableIterator) {
            if (!obj instanceof KMutableIterator) {
                TypeIntrinsics.throwCce(message);
            }
        }
        return TypeIntrinsics.castToIterator(obj);
    }

    public static List asMutableList(Object obj) {
        boolean str;
        if (obj instanceof KMappedMarker && obj instanceof KMutableList == null) {
            if (obj instanceof KMutableList == null) {
                TypeIntrinsics.throwCce(obj, "kotlin.collections.MutableList");
            }
        }
        return TypeIntrinsics.castToList(obj);
    }

    public static List asMutableList(Object obj, String message) {
        boolean z;
        if (obj instanceof KMappedMarker && obj instanceof KMutableList == null) {
            if (obj instanceof KMutableList == null) {
                TypeIntrinsics.throwCce(message);
            }
        }
        return TypeIntrinsics.castToList(obj);
    }

    public static ListIterator asMutableListIterator(Object obj) {
        boolean str;
        if (obj instanceof KMappedMarker && !obj instanceof KMutableListIterator) {
            if (!obj instanceof KMutableListIterator) {
                TypeIntrinsics.throwCce(obj, "kotlin.collections.MutableListIterator");
            }
        }
        return TypeIntrinsics.castToListIterator(obj);
    }

    public static ListIterator asMutableListIterator(Object obj, String message) {
        boolean z;
        if (obj instanceof KMappedMarker && !obj instanceof KMutableListIterator) {
            if (!obj instanceof KMutableListIterator) {
                TypeIntrinsics.throwCce(message);
            }
        }
        return TypeIntrinsics.castToListIterator(obj);
    }

    public static Map asMutableMap(Object obj) {
        boolean str;
        if (obj instanceof KMappedMarker && obj instanceof KMutableMap == null) {
            if (obj instanceof KMutableMap == null) {
                TypeIntrinsics.throwCce(obj, "kotlin.collections.MutableMap");
            }
        }
        return TypeIntrinsics.castToMap(obj);
    }

    public static Map asMutableMap(Object obj, String message) {
        boolean z;
        if (obj instanceof KMappedMarker && obj instanceof KMutableMap == null) {
            if (obj instanceof KMutableMap == null) {
                TypeIntrinsics.throwCce(message);
            }
        }
        return TypeIntrinsics.castToMap(obj);
    }

    public static Map.Entry asMutableMapEntry(Object obj) {
        boolean str;
        if (obj instanceof KMappedMarker && !obj instanceof KMutableMap.Entry) {
            if (!obj instanceof KMutableMap.Entry) {
                TypeIntrinsics.throwCce(obj, "kotlin.collections.MutableMap.MutableEntry");
            }
        }
        return TypeIntrinsics.castToMapEntry(obj);
    }

    public static Map.Entry asMutableMapEntry(Object obj, String message) {
        boolean z;
        if (obj instanceof KMappedMarker && !obj instanceof KMutableMap.Entry) {
            if (!obj instanceof KMutableMap.Entry) {
                TypeIntrinsics.throwCce(message);
            }
        }
        return TypeIntrinsics.castToMapEntry(obj);
    }

    public static Set asMutableSet(Object obj) {
        boolean str;
        if (obj instanceof KMappedMarker && obj instanceof KMutableSet == null) {
            if (obj instanceof KMutableSet == null) {
                TypeIntrinsics.throwCce(obj, "kotlin.collections.MutableSet");
            }
        }
        return TypeIntrinsics.castToSet(obj);
    }

    public static Set asMutableSet(Object obj, String message) {
        boolean z;
        if (obj instanceof KMappedMarker && obj instanceof KMutableSet == null) {
            if (obj instanceof KMutableSet == null) {
                TypeIntrinsics.throwCce(message);
            }
        }
        return TypeIntrinsics.castToSet(obj);
    }

    public static Object beforeCheckcastToFunctionOfArity(Object obj, int arity) {
        boolean functionOfArity;
        String str;
        if (obj != null && !TypeIntrinsics.isFunctionOfArity(obj, arity)) {
            if (!TypeIntrinsics.isFunctionOfArity(obj, arity)) {
                StringBuilder stringBuilder = new StringBuilder();
                TypeIntrinsics.throwCce(obj, stringBuilder.append("kotlin.jvm.functions.Function").append(arity).toString());
            }
        }
        return obj;
    }

    public static Object beforeCheckcastToFunctionOfArity(Object obj, int arity, String message) {
        boolean functionOfArity;
        if (obj != null && !TypeIntrinsics.isFunctionOfArity(obj, arity)) {
            if (!TypeIntrinsics.isFunctionOfArity(obj, arity)) {
                TypeIntrinsics.throwCce(message);
            }
        }
        return obj;
    }

    public static Collection castToCollection(Object obj) {
        try {
            return (Collection)obj;
            throw TypeIntrinsics.throwCce(th);
        }
    }

    public static Iterable castToIterable(Object obj) {
        try {
            return (Iterable)obj;
            throw TypeIntrinsics.throwCce(th);
        }
    }

    public static Iterator castToIterator(Object obj) {
        try {
            return (Iterator)obj;
            throw TypeIntrinsics.throwCce(th);
        }
    }

    public static List castToList(Object obj) {
        try {
            return (List)obj;
            throw TypeIntrinsics.throwCce(th);
        }
    }

    public static ListIterator castToListIterator(Object obj) {
        try {
            return (ListIterator)obj;
            throw TypeIntrinsics.throwCce(th);
        }
    }

    public static Map castToMap(Object obj) {
        try {
            return (Map)obj;
            throw TypeIntrinsics.throwCce(th);
        }
    }

    public static Map.Entry castToMapEntry(Object obj) {
        try {
            return (Map.Entry)obj;
            throw TypeIntrinsics.throwCce(th);
        }
    }

    public static Set castToSet(Object obj) {
        try {
            return (Set)obj;
            throw TypeIntrinsics.throwCce(th);
        }
    }

    public static int getFunctionArity(Object obj) {
        if (obj instanceof FunctionBase) {
            return (FunctionBase)obj.getArity();
        }
        if (obj instanceof Function0) {
            return 0;
        }
        if (obj instanceof Function1) {
            return 1;
        }
        if (obj instanceof Function2) {
            return 2;
        }
        if (obj instanceof Function3) {
            return 3;
        }
        if (obj instanceof Function4) {
            return 4;
        }
        if (obj instanceof Function5) {
            return 5;
        }
        if (obj instanceof Function6) {
            return 6;
        }
        if (obj instanceof Function7) {
            return 7;
        }
        if (obj instanceof Function8) {
            return 8;
        }
        if (obj instanceof Function9) {
            return 9;
        }
        if (obj instanceof Function10) {
            return 10;
        }
        if (obj instanceof Function11) {
            return 11;
        }
        if (obj instanceof Function12) {
            return 12;
        }
        if (obj instanceof Function13) {
            return 13;
        }
        if (obj instanceof Function14) {
            return 14;
        }
        if (obj instanceof Function15) {
            return 15;
        }
        if (obj instanceof Function16) {
            return 16;
        }
        if (obj instanceof Function17) {
            return 17;
        }
        if (obj instanceof Function18) {
            return 18;
        }
        if (obj instanceof Function19) {
            return 19;
        }
        if (obj instanceof Function20) {
            return 20;
        }
        if (obj instanceof Function21) {
            return 21;
        }
        if (obj instanceof Function22) {
            return 22;
        }
        return -1;
    }

    public static boolean isFunctionOfArity(Object obj, int arity) {
        boolean functionArity;
        int i;
        if (obj instanceof Function && TypeIntrinsics.getFunctionArity(obj) == arity) {
            i = TypeIntrinsics.getFunctionArity(obj) == arity ? 1 : 0;
        } else {
        }
        return i;
    }

    public static boolean isMutableCollection(Object obj) {
        boolean z;
        int i;
        if (obj instanceof Collection != null) {
            if (obj instanceof KMappedMarker) {
                i = obj instanceof KMutableCollection != null ? 1 : 0;
            } else {
            }
        } else {
        }
        return i;
    }

    public static boolean isMutableIterable(Object obj) {
        boolean z;
        int i;
        if (obj instanceof Iterable) {
            if (obj instanceof KMappedMarker) {
                i = obj instanceof KMutableIterable ? 1 : 0;
            } else {
            }
        } else {
        }
        return i;
    }

    public static boolean isMutableIterator(Object obj) {
        boolean z;
        int i;
        if (obj instanceof Iterator) {
            if (obj instanceof KMappedMarker) {
                i = obj instanceof KMutableIterator ? 1 : 0;
            } else {
            }
        } else {
        }
        return i;
    }

    public static boolean isMutableList(Object obj) {
        boolean z;
        int i;
        if (obj instanceof List != null) {
            if (obj instanceof KMappedMarker) {
                i = obj instanceof KMutableList != null ? 1 : 0;
            } else {
            }
        } else {
        }
        return i;
    }

    public static boolean isMutableListIterator(Object obj) {
        boolean z;
        int i;
        if (obj instanceof ListIterator) {
            if (obj instanceof KMappedMarker) {
                i = obj instanceof KMutableListIterator ? 1 : 0;
            } else {
            }
        } else {
        }
        return i;
    }

    public static boolean isMutableMap(Object obj) {
        boolean z;
        int i;
        if (obj instanceof Map != null) {
            if (obj instanceof KMappedMarker) {
                i = obj instanceof KMutableMap != null ? 1 : 0;
            } else {
            }
        } else {
        }
        return i;
    }

    public static boolean isMutableMapEntry(Object obj) {
        boolean z;
        int i;
        if (obj instanceof Map.Entry) {
            if (obj instanceof KMappedMarker) {
                i = obj instanceof KMutableMap.Entry ? 1 : 0;
            } else {
            }
        } else {
        }
        return i;
    }

    public static boolean isMutableSet(Object obj) {
        boolean z;
        int i;
        if (obj instanceof Set != null) {
            if (obj instanceof KMappedMarker) {
                i = obj instanceof KMutableSet != null ? 1 : 0;
            } else {
            }
        } else {
        }
        return i;
    }

    private static <T extends Throwable> T sanitizeStackTrace(T t) {
        return Intrinsics.sanitizeStackTrace(t, TypeIntrinsics.class.getName());
    }

    public static java.lang.ClassCastException throwCce(java.lang.ClassCastException e) {
        throw (ClassCastException)TypeIntrinsics.sanitizeStackTrace(e);
    }

    public static void throwCce(Object argument, String requestedClassName) {
        String name;
        if (argument == null) {
            name = "null";
        } else {
            name = argument.getClass().getName();
        }
        StringBuilder stringBuilder = new StringBuilder();
        TypeIntrinsics.throwCce(stringBuilder.append(name).append(" cannot be cast to ").append(requestedClassName).toString());
    }

    public static void throwCce(String message) {
        ClassCastException classCastException = new ClassCastException(message);
        throw TypeIntrinsics.throwCce(classCastException);
    }
}
