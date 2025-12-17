package g.b;

import java.util.Objects;

/* loaded from: classes2.dex */
public final class d {
    public static <T> void a(T t, Class<T> class2) {
        if (t == 0) {
        } else {
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(class2.getCanonicalName());
        stringBuilder.append(" must be set");
        IllegalStateException obj1 = new IllegalStateException(stringBuilder.toString());
        throw obj1;
    }

    public static <T> T b(T t) {
        Objects.requireNonNull(t);
        return t;
    }

    public static <T> T c(T t, String string2) {
        Objects.requireNonNull(t, string2);
        return t;
    }
}
