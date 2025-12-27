package io.jsonwebtoken.lang;

import java.util.Collection;
import java.util.Map;

/* compiled from: Assert.java */
/* loaded from: classes3.dex */
public final class Assert {
    private Assert() {
        super();
    }

    public static void doesNotContain(String str, String str2, String str3) {
        if (Strings.hasLength(str) && Strings.hasLength(str2)) {
            int i = -1;
            if (str.indexOf(str2) != -1) {
                throw new IllegalArgumentException(str3);
            }
        }
    }

    public static void hasLength(String str, String str2) {
        if (!Strings.hasLength(str)) {
            throw new IllegalArgumentException(str2);
        }
    }

    public static void hasText(String str, String str2) {
        if (!Strings.hasText(str)) {
            throw new IllegalArgumentException(str2);
        }
    }

    public static void isAssignable(Class cls, Class cls2) {
        Assert.isAssignable(cls, cls2, "");
    }

    public static void isInstanceOf(Class cls, Object object) {
        Assert.isInstanceOf(cls, object, "");
    }

    public static void isNull(Object object, String str) {
        if (object != null) {
            throw new IllegalArgumentException(str);
        }
    }

    public static void isTrue(boolean z, String str) {
        if (!z) {
            throw new IllegalArgumentException(str);
        }
    }

    public static void noNullElements(Object[] objectArr, String str) {
        int i = 0;
        if (objectArr != null) {
            i = 0;
            length = objectArr.length;
            for (Object obj : objectArr) {
                if (obj == null) {
                    throw new IllegalArgumentException(str);
                }
            }
        }
    }

    public static void notEmpty(Object[] objectArr, String str) {
        if (Objects.isEmpty(objectArr)) {
            throw new IllegalArgumentException(str);
        }
    }

    public static void notNull(Object object, String str) {
        if (object == null) {
            throw new IllegalArgumentException(str);
        }
    }

    public static void state(boolean z, String str) {
        if (!z) {
            throw new IllegalStateException(str);
        }
    }

    public static void isAssignable(Class cls, Class cls2, String str) {
        str = "Type to check against must not be null";
        Assert.notNull(cls, str);
        if (cls2 == null) {
            final StringBuilder stringBuilder = new StringBuilder();
            final String str2 = " is not assignable to ";
            cls = str + cls2 + str2 + cls;
            throw new IllegalArgumentException(cls);
        } else {
            if (cls.isAssignableFrom(cls2)) {
                return;
            }
        }
    }

    public static void isInstanceOf(Class cls, Object object, String str) {
        String name;
        Assert.notNull(cls, "Type to check against must not be null");
        if (!cls.isInstance(object)) {
            final StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append("Object of class [");
            if (object != null) {
                name = object.getClass().getName();
            } else {
                name = "null";
            }
            stringBuilder.append(name);
            stringBuilder.append("] must be an instance of ");
            stringBuilder.append(cls);
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.toString());
            throw illegalArgumentException;
        }
    }

    public static void isNull(Object object) {
        Assert.isNull(object, "[Assertion failed] - the object argument must be null");
    }

    public static void isTrue(boolean z) {
        Assert.isTrue(z, "[Assertion failed] - this expression must be true");
    }

    public static void notNull(Object object) {
        Assert.notNull(object, "[Assertion failed] - this argument is required; it must not be null");
    }

    public static void state(boolean z) {
        Assert.state(z, "[Assertion failed] - this state invariant must be true");
    }

    public static void doesNotContain(String str, String str2) {
        StringBuilder stringBuilder = new StringBuilder();
        String str4 = "[Assertion failed] - this String argument must not contain the substring [";
        String str5 = "]";
        str3 = str4 + str2 + str5;
        Assert.doesNotContain(str, str2, str3);
    }

    public static void hasLength(String str) {
        Assert.hasLength(str, "[Assertion failed] - this String argument must have length; it must not be null or empty");
    }

    public static void hasText(String str) {
        Assert.hasText(str, "[Assertion failed] - this String argument must have text; it must not be null, empty, or blank");
    }

    public static void notEmpty(Object[] objectArr) {
        Assert.notEmpty(objectArr, "[Assertion failed] - this array must not be empty: it must contain at least 1 element");
    }

    public static void noNullElements(Object[] objectArr) {
        Assert.noNullElements(objectArr, "[Assertion failed] - this array must not contain any null elements");
    }

    public static void notEmpty(byte[] bArr, String str) {
        if (Objects.isEmpty(bArr)) {
            throw new IllegalArgumentException(str);
        }
    }

    public static void notEmpty(Collection list, String str) {
        if (Collections.isEmpty(list)) {
            throw new IllegalArgumentException(str);
        }
    }

    public static void notEmpty(Collection list) {
        Assert.notEmpty(list, "[Assertion failed] - this collection must not be empty: it must contain at least 1 element");
    }

    public static void notEmpty(Map map, String str) {
        if (Collections.isEmpty(map)) {
            throw new IllegalArgumentException(str);
        }
    }

    public static void notEmpty(Map map) {
        Assert.notEmpty(map, "[Assertion failed] - this map must not be empty; it must contain at least one entry");
    }
}
