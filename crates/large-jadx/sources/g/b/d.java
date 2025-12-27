package g.b;

import java.util.Objects;

/* compiled from: Preconditions.java */
/* loaded from: classes2.dex */
public final class d {
    public static <T> void a(T t, Class<T> cls) {
        if (t == 0) {
            final StringBuilder stringBuilder = new StringBuilder();
            String canonicalName = cls.getCanonicalName();
            String str = " must be set";
            cls = canonicalName + str;
            throw new IllegalStateException(cls);
        }
    }

    public static <T> T b(T t) {
        Objects.requireNonNull(t);
        return t;
    }

    public static <T> T c(T t, String str) {
        Objects.requireNonNull(t, str);
        return t;
    }
}
