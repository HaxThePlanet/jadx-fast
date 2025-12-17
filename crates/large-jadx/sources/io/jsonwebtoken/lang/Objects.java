package io.jsonwebtoken.lang;

import java.io.Closeable;
import java.lang.reflect.Array;
import java.util.Arrays;

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
    public static <A, O extends A> A[] addObjectToArray(A[] aArr, O o2) {
        Class<Object> componentType;
        int length;
        int i;
        componentType = Object.class;
        if (aArr != null) {
            componentType = aArr.getClass().getComponentType();
        } else {
            if (o2 != null) {
                componentType = o2.getClass();
            }
        }
        final int i2 = 1;
        length = aArr != null ? length2 + i2 : i2;
        Object instance = Array.newInstance(componentType, length);
        if (aArr != null) {
            i = 0;
            System.arraycopy(aArr, i, (Object[])instance, i, aArr.length);
        }
        instance[obj4 -= i2] = o2;
        return instance;
    }

    public static <E extends Enum<?>> E caseInsensitiveValueOf(E[] eArr, String string2) {
        int i;
        Object obj;
        boolean equalsIgnoreCase;
        final int i2 = 0;
        i = i2;
        while (i < eArr.length) {
            obj = eArr[i];
            i++;
        }
        Object[] arr = new Object[2];
        arr[i2] = string2;
        arr[1] = eArr.getClass().getComponentType().getName();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(String.format("constant [%s] does not exist in enum type %s", arr));
        throw illegalArgumentException;
    }

    public static boolean containsConstant(Enum<?>[] enumArr, String string2) {
        return Objects.containsConstant(enumArr, string2, false);
    }

    public static boolean containsConstant(Enum<?>[] enumArr, String string2, boolean z3) {
        int i;
        boolean equalsIgnoreCase;
        final int i2 = 0;
        i = i2;
        while (i < enumArr.length) {
            String string = enumArr[i].toString();
            i++;
        }
        return i2;
    }

    public static boolean containsElement(Object[] objectArr, Object object2) {
        int i;
        boolean nullSafeEquals;
        final int i2 = 0;
        if (objectArr == null) {
            return i2;
        }
        i = i2;
        while (i < objectArr.length) {
            i++;
        }
        return i2;
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

    public static int hashCode(float f) {
        return Float.floatToIntBits(f);
    }

    public static int hashCode(long l) {
        return (int)obj2;
    }

    public static int hashCode(boolean z) {
        int obj0;
        obj0 = z ? 1231 : 1237;
        return obj0;
    }

    public static String identityToString(Object object) {
        if (object == null) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(object.getClass().getName());
        stringBuilder.append("@");
        stringBuilder.append(Objects.getIdentityHexString(object));
        return stringBuilder.toString();
    }

    public static boolean isArray(Object object) {
        boolean obj0;
        if (object != null && object.getClass().isArray()) {
            obj0 = object.getClass().isArray() ? 1 : 0;
        } else {
        }
        return obj0;
    }

    public static boolean isCheckedException(Throwable throwable) {
        Object obj1;
        if (throwable instanceof RuntimeException == null && throwable instanceof Error == null) {
            obj1 = throwable instanceof Error == null ? 1 : 0;
        } else {
        }
        return obj1;
    }

    public static boolean isCompatibleWithThrowsClause(Throwable throwable, Class[] class2Arr2) {
        int i;
        boolean assignableFrom;
        Class class;
        final int i3 = 1;
        if (!Objects.isCheckedException(throwable)) {
            return i3;
        }
        int i2 = 0;
        if (class2Arr2 != null) {
            i = i2;
            for (Object obj : class2Arr2) {
            }
        }
        return i2;
    }

    public static boolean isEmpty(byte[] bArr) {
        int obj0;
        if (bArr != 0) {
            if (bArr.length == 0) {
                obj0 = 1;
            } else {
                obj0 = 0;
            }
        } else {
        }
        return obj0;
    }

    public static boolean isEmpty(Object[] objectArr) {
        int obj0;
        if (objectArr != 0) {
            if (objectArr.length == 0) {
                obj0 = 1;
            } else {
                obj0 = 0;
            }
        } else {
        }
        return obj0;
    }

    public static String nullSafeClassName(Object object) {
        String obj0;
        if (object != null) {
            obj0 = object.getClass().getName();
        } else {
            obj0 = "null";
        }
        return obj0;
    }

    public static void nullSafeClose(Closeable... closeableArr) {
        int i;
        Object obj;
        if (closeableArr == null) {
        }
        i = 0;
        while (i < closeableArr.length) {
            obj = closeableArr[i];
            if (obj != null) {
            }
            i++;
            obj.close();
        }
    }

    public static boolean nullSafeEquals(Object object, Object object2) {
        boolean z2;
        boolean z4;
        boolean z;
        boolean z7;
        boolean z8;
        boolean z3;
        boolean z5;
        boolean z6;
        int array;
        boolean equals;
        array = 1;
        if (object == object2) {
            return array;
        }
        if (object != null) {
            if (object2 == null) {
            } else {
                if (object.equals(object2)) {
                    return array;
                }
                if (object.getClass().isArray() && object2.getClass().isArray() && object instanceof Object[] && object2 instanceof Object[]) {
                    if (object2.getClass().isArray()) {
                        if (object instanceof Object[]) {
                            if (object2 instanceof Object[]) {
                                return Arrays.equals((Object[])object, (Object[])object2);
                            }
                        }
                        if (object instanceof boolean[] && object2 instanceof boolean[]) {
                            if (object2 instanceof boolean[]) {
                                return Arrays.equals((boolean[])object, (boolean[])object2);
                            }
                        }
                        if (object instanceof byte[] && object2 instanceof byte[]) {
                            if (object2 instanceof byte[]) {
                                return Arrays.equals((byte[])object, (byte[])object2);
                            }
                        }
                        if (object instanceof char[] && object2 instanceof char[]) {
                            if (object2 instanceof char[]) {
                                return Arrays.equals((char[])object, (char[])object2);
                            }
                        }
                        if (object instanceof double[] && object2 instanceof double[]) {
                            if (object2 instanceof double[]) {
                                return Arrays.equals((double[])object, (double[])object2);
                            }
                        }
                        if (object instanceof float[] && object2 instanceof float[]) {
                            if (object2 instanceof float[]) {
                                return Arrays.equals((float[])object, (float[])object2);
                            }
                        }
                        if (object instanceof int[] && object2 instanceof int[]) {
                            if (object2 instanceof int[]) {
                                return Arrays.equals((int[])object, (int[])object2);
                            }
                        }
                        if (object instanceof long[] && object2 instanceof long[]) {
                            if (object2 instanceof long[]) {
                                return Arrays.equals((long[])object, (long[])object2);
                            }
                        }
                        if (object instanceof short[] && object2 instanceof short[]) {
                            if (object2 instanceof short[]) {
                                return Arrays.equals((short[])object, (short[])object2);
                            }
                        }
                    }
                }
            }
        }
        return 0;
    }

    public static int nullSafeHashCode(Object object) {
        boolean array;
        if (object == null) {
            return 0;
        }
        if (object.getClass().isArray() && object instanceof Object[]) {
            if (object instanceof Object[]) {
                return Objects.nullSafeHashCode((Object[])object);
            }
            if (object instanceof boolean[]) {
                return Objects.nullSafeHashCode((boolean[])object);
            }
            if (object instanceof byte[]) {
                return Objects.nullSafeHashCode((byte[])object);
            }
            if (object instanceof char[]) {
                return Objects.nullSafeHashCode((char[])object);
            }
            if (object instanceof double[]) {
                return Objects.nullSafeHashCode((double[])object);
            }
            if (object instanceof float[]) {
                return Objects.nullSafeHashCode((float[])object);
            }
            if (object instanceof int[]) {
                return Objects.nullSafeHashCode((int[])object);
            }
            if (object instanceof long[]) {
                return Objects.nullSafeHashCode((long[])object);
            }
            if (object instanceof short[]) {
                return Objects.nullSafeHashCode((short[])object);
            }
        }
        return object.hashCode();
    }

    public static int nullSafeHashCode(byte[] bArr) {
        int i2;
        int i;
        byte b;
        if (bArr == null) {
            return 0;
        }
        i = 7;
        while (i2 < bArr.length) {
            i3 += b;
            i2++;
        }
        return i;
    }

    public static int nullSafeHashCode(char[] cArr) {
        int i2;
        int i;
        char c;
        if (cArr == null) {
            return 0;
        }
        i = 7;
        while (i2 < cArr.length) {
            i3 += c;
            i2++;
        }
        return i;
    }

    public static int nullSafeHashCode(double[] dArr) {
        int i2;
        int i;
        int i3;
        if (dArr == null) {
            return 0;
        }
        i = 7;
        while (i2 < dArr.length) {
            i4 += i3;
            i2++;
        }
        return i;
    }

    public static int nullSafeHashCode(float[] fArr) {
        int i3;
        int i;
        int i2;
        if (fArr == null) {
            return 0;
        }
        i = 7;
        while (i3 < fArr.length) {
            i4 += i2;
            i3++;
        }
        return i;
    }

    public static int nullSafeHashCode(int[] iArr) {
        int i2;
        int i;
        int i3;
        if (iArr == null) {
            return 0;
        }
        i = 7;
        while (i2 < iArr.length) {
            i4 += i3;
            i2++;
        }
        return i;
    }

    public static int nullSafeHashCode(long[] lArr) {
        int i;
        int i2;
        int i3;
        if (lArr == null) {
            return 0;
        }
        i2 = 7;
        while (i < lArr.length) {
            i4 += i3;
            i++;
        }
        return i2;
    }

    public static int nullSafeHashCode(Object[] objectArr) {
        int i;
        int i2;
        int nullSafeHashCode;
        if (objectArr == null) {
            return 0;
        }
        i2 = 7;
        while (i < objectArr.length) {
            i3 += nullSafeHashCode;
            i++;
        }
        return i2;
    }

    public static int nullSafeHashCode(short[] sArr) {
        int i;
        int i2;
        short s;
        if (sArr == null) {
            return 0;
        }
        i2 = 7;
        while (i < sArr.length) {
            i3 += s;
            i++;
        }
        return i2;
    }

    public static int nullSafeHashCode(boolean[] zArr) {
        int i;
        int i2;
        int i3;
        if (zArr == null) {
            return 0;
        }
        i2 = 7;
        while (i < zArr.length) {
            i4 += i3;
            i++;
        }
        return i2;
    }

    public static String nullSafeToString(Object object) {
        String obj1;
        if (object == null) {
            return "null";
        }
        if (object instanceof String != null) {
            return (String)object;
        }
        if (object instanceof Object[]) {
            return Objects.nullSafeToString((Object[])object);
        }
        if (object instanceof boolean[]) {
            return Objects.nullSafeToString((boolean[])object);
        }
        if (object instanceof byte[]) {
            return Objects.nullSafeToString((byte[])object);
        }
        if (object instanceof char[]) {
            return Objects.nullSafeToString((char[])object);
        }
        if (object instanceof double[]) {
            return Objects.nullSafeToString((double[])object);
        }
        if (object instanceof float[]) {
            return Objects.nullSafeToString((float[])object);
        }
        if (object instanceof int[]) {
            return Objects.nullSafeToString((int[])object);
        }
        if (object instanceof long[]) {
            return Objects.nullSafeToString((long[])object);
        }
        if (object instanceof short[]) {
            return Objects.nullSafeToString((short[])object);
        }
        if (object.toString() != null) {
        } else {
            obj1 = "";
        }
        return obj1;
    }

    public static String nullSafeToString(byte[] bArr) {
        int i;
        byte b;
        String str;
        if (bArr == null) {
            return "null";
        }
        final int length = bArr.length;
        if (length == 0) {
            return "{}";
        }
        StringBuilder stringBuilder = new StringBuilder();
        i = 0;
        while (i < length) {
            if (i == 0) {
            } else {
            }
            stringBuilder.append(", ");
            stringBuilder.append(bArr[i]);
            i++;
            stringBuilder.append("{");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public static String nullSafeToString(char[] cArr) {
        int i;
        String str2;
        String str;
        char c;
        if (cArr == null) {
            return "null";
        }
        final int length = cArr.length;
        if (length == 0) {
            return "{}";
        }
        StringBuilder stringBuilder = new StringBuilder();
        i = 0;
        while (i < length) {
            if (i == 0) {
            } else {
            }
            stringBuilder.append(", ");
            str2 = "'";
            stringBuilder.append(str2);
            stringBuilder.append(cArr[i]);
            stringBuilder.append(str2);
            i++;
            stringBuilder.append("{");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public static String nullSafeToString(double[] dArr) {
        int i;
        long l;
        String str;
        if (dArr == null) {
            return "null";
        }
        final int length = dArr.length;
        if (length == 0) {
            return "{}";
        }
        StringBuilder stringBuilder = new StringBuilder();
        i = 0;
        while (i < length) {
            if (i == 0) {
            } else {
            }
            stringBuilder.append(", ");
            stringBuilder.append(dArr[i]);
            i++;
            stringBuilder.append("{");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public static String nullSafeToString(float[] fArr) {
        int i;
        int i2;
        String str;
        if (fArr == null) {
            return "null";
        }
        final int length = fArr.length;
        if (length == 0) {
            return "{}";
        }
        StringBuilder stringBuilder = new StringBuilder();
        i = 0;
        while (i < length) {
            if (i == 0) {
            } else {
            }
            stringBuilder.append(", ");
            stringBuilder.append(fArr[i]);
            i++;
            stringBuilder.append("{");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public static String nullSafeToString(int[] iArr) {
        int i2;
        int i;
        String str;
        if (iArr == null) {
            return "null";
        }
        final int length = iArr.length;
        if (length == 0) {
            return "{}";
        }
        StringBuilder stringBuilder = new StringBuilder();
        i2 = 0;
        while (i2 < length) {
            if (i2 == 0) {
            } else {
            }
            stringBuilder.append(", ");
            stringBuilder.append(iArr[i2]);
            i2++;
            stringBuilder.append("{");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public static String nullSafeToString(long[] lArr) {
        int i;
        long l;
        String str;
        if (lArr == null) {
            return "null";
        }
        final int length = lArr.length;
        if (length == 0) {
            return "{}";
        }
        StringBuilder stringBuilder = new StringBuilder();
        i = 0;
        while (i < length) {
            if (i == 0) {
            } else {
            }
            stringBuilder.append(", ");
            stringBuilder.append(lArr[i]);
            i++;
            stringBuilder.append("{");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public static String nullSafeToString(Object[] objectArr) {
        int i;
        String valueOf;
        String str;
        if (objectArr == null) {
            return "null";
        }
        final int length = objectArr.length;
        if (length == 0) {
            return "{}";
        }
        StringBuilder stringBuilder = new StringBuilder();
        i = 0;
        while (i < length) {
            if (i == 0) {
            } else {
            }
            stringBuilder.append(", ");
            stringBuilder.append(String.valueOf(objectArr[i]));
            i++;
            stringBuilder.append("{");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public static String nullSafeToString(short[] sArr) {
        int i;
        short s;
        String str;
        if (sArr == null) {
            return "null";
        }
        final int length = sArr.length;
        if (length == 0) {
            return "{}";
        }
        StringBuilder stringBuilder = new StringBuilder();
        i = 0;
        while (i < length) {
            if (i == 0) {
            } else {
            }
            stringBuilder.append(", ");
            stringBuilder.append(sArr[i]);
            i++;
            stringBuilder.append("{");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public static String nullSafeToString(boolean[] zArr) {
        int i;
        boolean z;
        String str;
        if (zArr == null) {
            return "null";
        }
        final int length = zArr.length;
        if (length == 0) {
            return "{}";
        }
        StringBuilder stringBuilder = new StringBuilder();
        i = 0;
        while (i < length) {
            if (i == 0) {
            } else {
            }
            stringBuilder.append(", ");
            stringBuilder.append(zArr[i]);
            i++;
            stringBuilder.append("{");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public static Object[] toObjectArray(Object object) {
        int i;
        Object obj;
        if (object instanceof Object[]) {
            return (Object[])object;
        }
        i = 0;
        if (object == null) {
            return new Object[i];
        }
        if (!object.getClass().isArray()) {
        } else {
            int length = Array.getLength(object);
            if (length == 0) {
                return new Object[i];
            }
            Object instance = Array.newInstance(Array.get(object, i).getClass(), length);
            while (i < length) {
                (Object[])instance[i] = Array.get(object, i);
                i++;
            }
            return instance;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Source is not an array: ");
        stringBuilder.append(object);
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.toString());
        throw illegalArgumentException;
    }
}
