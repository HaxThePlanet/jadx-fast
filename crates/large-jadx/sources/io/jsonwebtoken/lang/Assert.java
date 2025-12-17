package io.jsonwebtoken.lang;

import java.util.Collection;
import java.util.Map;

/* loaded from: classes3.dex */
public final class Assert {
    public static void doesNotContain(String string, String string2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[Assertion failed] - this String argument must not contain the substring [");
        stringBuilder.append(string2);
        stringBuilder.append("]");
        Assert.doesNotContain(string, string2, stringBuilder.toString());
    }

    public static void doesNotContain(String string, String string2, String string3) {
        boolean length;
        String obj1;
        String obj2;
        if (Strings.hasLength(string) && Strings.hasLength(string2)) {
            if (Strings.hasLength(string2)) {
                if (string.indexOf(string2) != -1) {
                } else {
                }
                obj1 = new IllegalArgumentException(string3);
                throw obj1;
            }
        }
    }

    public static void hasLength(String string) {
        Assert.hasLength(string, "[Assertion failed] - this String argument must have length; it must not be null or empty");
    }

    public static void hasLength(String string, String string2) {
        if (!Strings.hasLength(string)) {
        } else {
        }
        IllegalArgumentException obj0 = new IllegalArgumentException(string2);
        throw obj0;
    }

    public static void hasText(String string) {
        Assert.hasText(string, "[Assertion failed] - this String argument must have text; it must not be null, empty, or blank");
    }

    public static void hasText(String string, String string2) {
        if (!Strings.hasText(string)) {
        } else {
        }
        IllegalArgumentException obj0 = new IllegalArgumentException(string2);
        throw obj0;
    }

    public static void isAssignable(Class class, Class class2) {
        Assert.isAssignable(class, class2, "");
    }

    public static void isAssignable(Class class, Class class2, String string3) {
        String assignableFrom;
        Assert.notNull(class, "Type to check against must not be null");
        if (class2 == null) {
        } else {
            if (!class.isAssignableFrom(class2)) {
            } else {
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string3);
        stringBuilder.append(class2);
        stringBuilder.append(" is not assignable to ");
        stringBuilder.append(class);
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.toString());
        throw illegalArgumentException;
    }

    public static void isInstanceOf(Class class, Object object2) {
        Assert.isInstanceOf(class, object2, "");
    }

    public static void isInstanceOf(Class class, Object object2, String string3) {
        String obj3;
        Assert.notNull(class, "Type to check against must not be null");
        if (!class.isInstance(object2)) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(string3);
            stringBuilder.append("Object of class [");
            if (object2 != null) {
                obj3 = object2.getClass().getName();
            } else {
                obj3 = "null";
            }
            stringBuilder.append(obj3);
            stringBuilder.append("] must be an instance of ");
            stringBuilder.append(class);
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.toString());
            throw illegalArgumentException;
        }
    }

    public static void isNull(Object object) {
        Assert.isNull(object, "[Assertion failed] - the object argument must be null");
    }

    public static void isNull(Object object, String string2) {
        if (object != null) {
        } else {
        }
        IllegalArgumentException obj0 = new IllegalArgumentException(string2);
        throw obj0;
    }

    public static void isTrue(boolean z) {
        Assert.isTrue(z, "[Assertion failed] - this expression must be true");
    }

    public static void isTrue(boolean z, String string2) {
        if (!z) {
        } else {
        }
        IllegalArgumentException obj0 = new IllegalArgumentException(string2);
        throw obj0;
    }

    public static void noNullElements(Object[] objectArr) {
        Assert.noNullElements(objectArr, "[Assertion failed] - this array must not contain any null elements");
    }

    public static void noNullElements(Object[] objectArr, String string2) {
        int i;
        Object length;
        if (objectArr != null) {
            i = 0;
            for (Object length : objectArr) {
            }
        }
    }

    public static void notEmpty(Collection collection) {
        Assert.notEmpty(collection, "[Assertion failed] - this collection must not be empty: it must contain at least 1 element");
    }

    public static void notEmpty(Collection collection, String string2) {
        if (Collections.isEmpty(collection)) {
        } else {
        }
        IllegalArgumentException obj0 = new IllegalArgumentException(string2);
        throw obj0;
    }

    public static void notEmpty(Map map) {
        Assert.notEmpty(map, "[Assertion failed] - this map must not be empty; it must contain at least one entry");
    }

    public static void notEmpty(Map map, String string2) {
        if (Collections.isEmpty(map)) {
        } else {
        }
        IllegalArgumentException obj0 = new IllegalArgumentException(string2);
        throw obj0;
    }

    public static void notEmpty(byte[] bArr, String string2) {
        if (Objects.isEmpty(bArr)) {
        } else {
        }
        IllegalArgumentException obj0 = new IllegalArgumentException(string2);
        throw obj0;
    }

    public static void notEmpty(Object[] objectArr) {
        Assert.notEmpty(objectArr, "[Assertion failed] - this array must not be empty: it must contain at least 1 element");
    }

    public static void notEmpty(Object[] objectArr, String string2) {
        if (Objects.isEmpty(objectArr)) {
        } else {
        }
        IllegalArgumentException obj0 = new IllegalArgumentException(string2);
        throw obj0;
    }

    public static void notNull(Object object) {
        Assert.notNull(object, "[Assertion failed] - this argument is required; it must not be null");
    }

    public static void notNull(Object object, String string2) {
        if (object == null) {
        } else {
        }
        IllegalArgumentException obj0 = new IllegalArgumentException(string2);
        throw obj0;
    }

    public static void state(boolean z) {
        Assert.state(z, "[Assertion failed] - this state invariant must be true");
    }

    public static void state(boolean z, String string2) {
        if (!z) {
        } else {
        }
        IllegalStateException obj0 = new IllegalStateException(string2);
        throw obj0;
    }
}
