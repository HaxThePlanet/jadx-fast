package androidx.core.util;

import java.util.Objects;

/* loaded from: classes5.dex */
public class ObjectsCompat {
    public static boolean equals(Object a, Object b) {
        return Objects.equals(a, b);
    }

    public static int hash(Object... values) {
        return Objects.hash(values);
    }

    public static int hashCode(Object o) {
        int i;
        if (o != null) {
            i = o.hashCode();
        } else {
            i = 0;
        }
        return i;
    }

    public static <T> T requireNonNull(T t) {
        if (t == 0) {
        } else {
            return t;
        }
        NullPointerException nullPointerException = new NullPointerException();
        throw nullPointerException;
    }

    public static <T> T requireNonNull(T t, String message) {
        if (t == 0) {
        } else {
            return t;
        }
        NullPointerException nullPointerException = new NullPointerException(message);
        throw nullPointerException;
    }

    public static String toString(Object o, String nullDefault) {
        String string;
        if (o != null) {
            string = o.toString();
        } else {
            string = nullDefault;
        }
        return string;
    }
}
