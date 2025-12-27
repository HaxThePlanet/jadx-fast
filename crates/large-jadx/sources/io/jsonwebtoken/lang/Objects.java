package io.jsonwebtoken.lang;

import java.io.Closeable;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;

/* compiled from: Objects.java */
/* loaded from: classes3.dex */
public final class Objects {

    private static final String ARRAY_ELEMENT_SEPARATOR = ", ";
    private static final String ARRAY_END = "}";
    private static final String ARRAY_START = "{";
    private static final String EMPTY_ARRAY = "{}";
    private static final String EMPTY_STRING = "";
    private static final int INITIAL_HASH = 7;
    private static final int MULTIPLIER = 31;
    private static final String NULL_STRING = "null";
    private Objects() {
        super();
    }

    public static <A, O extends A> A[] addObjectToArray(A[] aArr, O o) {
        Class cls;
        int length;
        cls = Object.class;
        if (aArr != null) {
            cls = aArr.getClass().getComponentType();
        } else {
            if (o != null) {
                cls = o.getClass();
            }
        }
        length = 1;
        length = aArr != null ? length2 + length : length;
        Object array = Array.newInstance(cls, length);
        if (aArr != null) {
            length = aArr.length;
            int i = 0;
            System.arraycopy(aArr, i, array, i, length);
        }
        array[array.length - length] = o;
        return array;
    }

    public static <E extends Enum<?>> E caseInsensitiveValueOf(E[] eArr, String str) {
        int i;
        i = 0;
        for (Object obj : eArr) {
            if (obj.toString().equalsIgnoreCase(str)) {
                return obj;
            }
        }
        Object[] arr = new Object[2];
        arr[i] = str;
        arr[1] = eArr.getClass().getComponentType().getName();
        throw new IllegalArgumentException(String.format("constant [%s] does not exist in enum type %s", arr));
    }

    public static boolean containsConstant(Enum<?>[] enum_Arr, String str) {
        return Objects.containsConstant(enum_Arr, str, false);
    }

    public static boolean containsElement(Object[] objectArr, Object object) {
        int i;
        i = 0;
        if (objectArr == null) {
            return false;
        }
        for (Object obj : objectArr) {
            if (Objects.nullSafeEquals(obj, object)) {
                return true;
            }
        }
        return false;
    }

    public static String getDisplayString(Object object) {
        if (object == null) {
            return "";
        }
        return Objects.nullSafeToString(object);
    }

    public static String getIdentityHexString(Object object) {
        return Integer.toHexString(System.identityHashCode(object));
    }

    public static int hashCode(double d) {
        return Objects.hashCode(Double.doubleToLongBits(d));
    }

    public static String identityToString(Object object) {
        if (object == null) {
            return "";
        }
        final StringBuilder stringBuilder = new StringBuilder();
        String name = object.getClass().getName();
        String str = "@";
        String identityHexString = Objects.getIdentityHexString(object);
        str3 = name + str + identityHexString;
        return str3;
    }

    public static boolean isArray(Object object) {
        boolean z = false;
        if (object != null) {
            object = object.getClass().isArray() ? 1 : 0;
        }
        return (object.getClass().isArray() ? 1 : 0);
    }

    public static boolean isCheckedException(Throwable th) {
        boolean z3 = false;
        if (!(th instanceof RuntimeException)) {
            z = th instanceof Error;
            th = !(th instanceof Error) ? 1 : 0;
        }
        return (!(th instanceof Error) ? 1 : 0);
    }

    public static boolean isCompatibleWithThrowsClause(Throwable th, Class[] clsArr) {
        int i;
        Class cls;
        final boolean z = true;
        if (!Objects.isCheckedException(th)) {
            return true;
        }
        i = 0;
        if (clsArr != null) {
            length = clsArr.length;
            for (Object obj : clsArr) {
                if (obj.isAssignableFrom(th.getClass())) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean isEmpty(Object[] objectArr) {
        boolean z = false;
        if (objectArr != null) {
            length = objectArr.length;
            if (objectArr.length == 0) {
                int i2 = 1;
            } else {
                int i = 0;
            }
        }
        return z;
    }

    public static String nullSafeClassName(Object object) {
        String name;
        if (object != null) {
            name = object.getClass().getName();
        } else {
            name = "null";
        }
        return name;
    }

    public static void nullSafeClose(Closeable... closeableArr) {
        int i = 0;
        if (closeableArr == null) {
            return;
        }
        i = 0;
        for (Object obj : closeableArr) {
        }
    }

    public static boolean nullSafeEquals(Object object, Object object2) {
        int i = 1;
        if (object == object2) {
            return true;
        }
        return false;
    }

    public static int nullSafeHashCode(Object object) {
        if (object == null) {
            return 0;
        }
        if (object.getClass().isArray()) {
            if (object instanceof Object[]) {
                return Objects.nullSafeHashCode(object);
            }
            if (object instanceof boolean[]) {
                return Objects.nullSafeHashCode(object);
            }
            if (object instanceof byte[]) {
                return Objects.nullSafeHashCode(object);
            }
            if (object instanceof char[]) {
                return Objects.nullSafeHashCode(object);
            }
            if (object instanceof double[]) {
                return Objects.nullSafeHashCode(object);
            }
            if (object instanceof float[]) {
                return Objects.nullSafeHashCode(object);
            }
            if (object instanceof int[]) {
                return Objects.nullSafeHashCode(object);
            }
            if (object instanceof long[]) {
                return Objects.nullSafeHashCode(object);
            }
            array = object instanceof short[];
            if (object instanceof short[]) {
                return Objects.nullSafeHashCode(object);
            }
        }
        return object.hashCode();
    }

    public static String nullSafeToString(Object object) {
        String object2;
        if (object == null) {
            return "null";
        }
        if (object instanceof String) {
            return object;
        }
        if (object instanceof Object[]) {
            return Objects.nullSafeToString(object);
        }
        if (object instanceof boolean[]) {
            return Objects.nullSafeToString(object);
        }
        if (object instanceof byte[]) {
            return Objects.nullSafeToString(object);
        }
        if (object instanceof char[]) {
            return Objects.nullSafeToString(object);
        }
        if (object instanceof double[]) {
            return Objects.nullSafeToString(object);
        }
        if (object instanceof float[]) {
            return Objects.nullSafeToString(object);
        }
        if (object instanceof int[]) {
            return Objects.nullSafeToString(object);
        }
        if (object instanceof long[]) {
            return Objects.nullSafeToString(object);
        }
        if (object instanceof short[]) {
            return Objects.nullSafeToString(object);
        }
        if (object.toString() == null) {
            object2 = "";
        }
        return object2;
    }

    public static Object[] toObjectArray(Object object) {
        int i = 0;
        if (object instanceof Object[]) {
            return object;
        }
        i = 0;
        if (object == null) {
            return new Object[i];
        }
        if (!object.getClass().isArray()) {
            StringBuilder stringBuilder = new StringBuilder();
            String str = "Source is not an array: ";
            object = str + object;
            throw new IllegalArgumentException(object);
        } else {
            int length = Array.getLength(object);
            if (length == 0) {
                return new Object[i];
            }
            Object array2 = Array.newInstance(Array.get(object, i).getClass(), length);
            while (i < length) {
                array2[i] = Array.get(object, i);
                i = i + 1;
            }
            return array2;
        }
    }

    public static boolean containsConstant(Enum<?>[] enum_Arr, String str, boolean z) {
        int i;
        boolean equalsIgnoreCase;
        i = 0;
        for (Object obj : enum_Arr) {
            String obj2 = obj.toString();
            if (obj2.equalsIgnoreCase(str)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isEmpty(byte[] bArr) {
        boolean z = false;
        if (bArr != null) {
            length = bArr.length;
            if (bArr.length == 0) {
                int i2 = 1;
            } else {
                int i = 0;
            }
        }
        return z;
    }

    public static int hashCode(float f) {
        return Float.floatToIntBits(f);
    }

    public static int nullSafeHashCode(Object[] objectArr) {
        int i = 0;
        int i2 = 7;
        i = 0;
        if (objectArr == null) {
            return 0;
        }
        i2 = 7;
        for (Object obj : objectArr) {
            i2 = (i2 * 31) + Objects.nullSafeHashCode(obj);
        }
        return i2;
    }

    public static String nullSafeToString(Object[] objectArr) {
        int i = 0;
        if (objectArr == null) {
            return "null";
        }
        final int length = objectArr.length;
        if (length == 0) {
            return "{}";
        }
        final StringBuilder stringBuilder = new StringBuilder();
        i = 0;
        while (i < length) {
            stringBuilder.append(String.valueOf(objectArr[i]));
            i = i + 1;
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public static int nullSafeHashCode(boolean[] zArr) {
        int i = 0;
        int i2 = 7;
        i = 0;
        if (zArr == null) {
            return 0;
        }
        i2 = 7;
        for (boolean z : zArr) {
            i2 = (i2 * 31) + Objects.hashCode(z);
        }
        return i2;
    }

    public static int nullSafeHashCode(byte[] bArr) {
        int i = 0;
        int i2 = 7;
        i = 0;
        if (bArr == null) {
            return 0;
        }
        i2 = 7;
        for (byte b : bArr) {
            i2 = (i2 * 31) + b;
        }
        return i2;
    }

    public static int nullSafeHashCode(char[] cArr) {
        int i = 0;
        int i2 = 7;
        i = 0;
        if (cArr == null) {
            return 0;
        }
        i2 = 7;
        for (char c : cArr) {
            i2 = (i2 * 31) + c;
        }
        return i2;
    }

    public static int nullSafeHashCode(double[] dArr) {
        int i = 0;
        int i2 = 7;
        i = 0;
        if (dArr == null) {
            return 0;
        }
        i2 = 7;
        for (long l : dArr) {
            i2 = (i2 * 31) + Objects.hashCode(l);
        }
        return i2;
    }

    public static String nullSafeToString(boolean[] zArr) {
        int i = 0;
        if (zArr == null) {
            return "null";
        }
        final int length = zArr.length;
        if (length == 0) {
            return "{}";
        }
        final StringBuilder stringBuilder = new StringBuilder();
        i = 0;
        while (i < length) {
            stringBuilder.append(zArr[i]);
            i = i + 1;
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public static int nullSafeHashCode(float[] fArr) {
        int i = 0;
        int i2 = 7;
        i = 0;
        if (fArr == null) {
            return 0;
        }
        i2 = 7;
        for (int i4 : fArr) {
            i2 = (i2 * 31) + Objects.hashCode(i4);
        }
        return i2;
    }

    public static int nullSafeHashCode(int[] iArr) {
        int i = 0;
        int i2 = 7;
        i = 0;
        if (iArr == null) {
            return 0;
        }
        i2 = 7;
        for (int i3 : iArr) {
            i2 = (i2 * 31) + i3;
        }
        return i2;
    }

    public static int nullSafeHashCode(long[] jArr) {
        int i = 0;
        int i2 = 7;
        i = 0;
        if (jArr == null) {
            return 0;
        }
        i2 = 7;
        for (long l : jArr) {
            i2 = (i2 * 31) + Objects.hashCode(l);
        }
        return i2;
    }

    public static String nullSafeToString(byte[] bArr) {
        int i = 0;
        if (bArr == null) {
            return "null";
        }
        final int length = bArr.length;
        if (length == 0) {
            return "{}";
        }
        final StringBuilder stringBuilder = new StringBuilder();
        i = 0;
        while (i < length) {
            stringBuilder.append(bArr[i]);
            i = i + 1;
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public static int nullSafeHashCode(short[] sArr) {
        int i = 0;
        int i2 = 7;
        i = 0;
        if (sArr == null) {
            return 0;
        }
        i2 = 7;
        for (short s : sArr) {
            i2 = (i2 * 31) + s;
        }
        return i2;
    }

    public static String nullSafeToString(char[] cArr) {
        int i = 0;
        if (cArr == null) {
            return "null";
        }
        final int length = cArr.length;
        if (length == 0) {
            return "{}";
        }
        final StringBuilder stringBuilder = new StringBuilder();
        i = 0;
        while (i < length) {
            str = "'";
            stringBuilder.append(str);
            stringBuilder.append(cArr[i]);
            stringBuilder.append(str);
            i = i + 1;
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public static String nullSafeToString(double[] dArr) {
        int i = 0;
        if (dArr == null) {
            return "null";
        }
        final int length = dArr.length;
        if (length == 0) {
            return "{}";
        }
        final StringBuilder stringBuilder = new StringBuilder();
        i = 0;
        while (i < length) {
            stringBuilder.append(dArr[i]);
            i = i + 1;
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public static String nullSafeToString(float[] fArr) {
        int i = 0;
        if (fArr == null) {
            return "null";
        }
        final int length = fArr.length;
        if (length == 0) {
            return "{}";
        }
        final StringBuilder stringBuilder = new StringBuilder();
        i = 0;
        while (i < length) {
            stringBuilder.append(fArr[i]);
            i = i + 1;
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public static String nullSafeToString(int[] iArr) {
        int i = 0;
        if (iArr == null) {
            return "null";
        }
        final int length = iArr.length;
        if (length == 0) {
            return "{}";
        }
        final StringBuilder stringBuilder = new StringBuilder();
        i = 0;
        while (i < length) {
            stringBuilder.append(iArr[i]);
            i = i + 1;
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public static String nullSafeToString(long[] jArr) {
        int i = 0;
        if (jArr == null) {
            return "null";
        }
        final int length = jArr.length;
        if (length == 0) {
            return "{}";
        }
        final StringBuilder stringBuilder = new StringBuilder();
        i = 0;
        while (i < length) {
            stringBuilder.append(jArr[i]);
            i = i + 1;
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public static String nullSafeToString(short[] sArr) {
        int i = 0;
        if (sArr == null) {
            return "null";
        }
        final int length = sArr.length;
        if (length == 0) {
            return "{}";
        }
        final StringBuilder stringBuilder = new StringBuilder();
        i = 0;
        while (i < length) {
            stringBuilder.append(sArr[i]);
            i = i + 1;
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public static int hashCode(long j) {
        return (int)(j ^ (j >>> 32L));
    }

    public static int hashCode(boolean z) {
        int i = 1231;
        z = z ? 1231 : 1237;
        return (z ? 1231 : 1237);
    }
}
