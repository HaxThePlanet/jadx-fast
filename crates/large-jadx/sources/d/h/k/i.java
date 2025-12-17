package d.h.k;

import java.util.Objects;

/* loaded from: classes.dex */
public final class i {
    public static void a(boolean z, Object object2) {
        if (!z) {
        } else {
        }
        IllegalArgumentException obj0 = new IllegalArgumentException(String.valueOf(object2));
        throw obj0;
    }

    public static int b(int i) {
        if (i < 0) {
        } else {
            return i;
        }
        IllegalArgumentException obj0 = new IllegalArgumentException();
        throw obj0;
    }

    public static <T> T c(T t) {
        Objects.requireNonNull(t);
        return t;
    }

    public static <T> T d(T t, Object object2) {
        if (t == 0) {
        } else {
            return t;
        }
        NullPointerException obj0 = new NullPointerException(String.valueOf(object2));
        throw obj0;
    }
}
