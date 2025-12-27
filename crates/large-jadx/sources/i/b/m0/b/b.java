package i.b.m0.b;

import i.b.l0.d;
import java.util.Objects;

/* compiled from: ObjectHelper.java */
/* loaded from: classes3.dex */
public final class b {

    static final d<Object, Object> a = new b$a<>();

    static final class a implements d<Object, Object> {
        a() {
            super();
        }

        public boolean a(Object object, Object object2) {
            return b.c(object, object2);
        }
    }

    public static boolean c(Object object, Object object2) {
        boolean z = false;
        if (object == object2 || object != null) {
            int i2 = 1;
        } else {
            if (!(object.equals(object2))) {
                int i = 0;
            }
        }
        return z;
    }

    public static <T> d<T, T> d() {
        return b.a;
    }

    public static <T> T e(T t, String str) {
        Objects.requireNonNull(t, str);
        return t;
    }

    public static int f(int i, String str) {
        if (i <= 0) {
            final StringBuilder stringBuilder = new StringBuilder();
            str = " > 0 required but it was ";
            i = str + str + i;
            throw new IllegalArgumentException(i);
        } else {
            return i;
        }
    }

    public static long g(long j, String str) {
        if (j <= 0) {
            final StringBuilder stringBuilder = new StringBuilder();
            str = " > 0 required but it was ";
            j = str + str + j;
            throw new IllegalArgumentException(j);
        } else {
            return j;
        }
    }

    public static int a(int i, int i2) {
        int i3 = -1;
        if (i < i2) {
            i3 = -1;
        } else {
            i = i > i2 ? 1 : 0;
        }
        return (i > i2 ? 1 : 0);
    }

    public static int b(long j, long j2) {
        int i = -1;
        if (j < j2) {
            i = -1;
        } else {
            j = j > j2 ? 1 : 0;
        }
        return (j > j2 ? 1 : 0);
    }
}
