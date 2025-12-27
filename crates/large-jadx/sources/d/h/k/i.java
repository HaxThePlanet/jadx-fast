package d.h.k;

import java.util.Objects;

/* compiled from: Preconditions.java */
/* loaded from: classes.dex */
public final class i {
    public static void a(boolean z, Object object) {
        if (!z) {
            throw new IllegalArgumentException(String.valueOf(object));
        }
    }

    public static int b(int i) {
        if (i < 0) {
            throw new IllegalArgumentException();
        } else {
            return i;
        }
    }

    public static <T> T c(T t) {
        Objects.requireNonNull(t);
        return t;
    }

    public static <T> T d(T t, Object object) {
        if (t == 0) {
            throw new NullPointerException(String.valueOf(object));
        } else {
            return t;
        }
    }
}
