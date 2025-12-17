package i.b.m0.b;

import i.b.l0.d;
import java.util.Objects;

/* loaded from: classes3.dex */
public final class b {

    static final d<Object, Object> a;

    static final class a implements d<Object, Object> {
        @Override // i.b.l0.d
        public boolean a(Object object, Object object2) {
            return b.c(object, object2);
        }
    }
    static {
        b.a aVar = new b.a();
        b.a = aVar;
    }

    public static int a(int i, int i2) {
        int obj0;
        obj0 = i < i2 ? -1 : i > i2 ? 1 : 0;
        return obj0;
    }

    public static int b(long l, long l2) {
        int obj0;
        obj0 = Long.compare(l, obj2);
        obj0 = obj0 < 0 ? -1 : obj0 > 0 ? 1 : 0;
        return obj0;
    }

    public static boolean c(Object object, Object object2) {
        boolean obj0;
        if (object != object2) {
            if (object != null && object.equals(object2)) {
                if (object.equals(object2)) {
                    obj0 = 1;
                } else {
                    obj0 = 0;
                }
            } else {
            }
        } else {
        }
        return obj0;
    }

    public static <T> d<T, T> d() {
        return b.a;
    }

    public static <T> T e(T t, String string2) {
        Objects.requireNonNull(t, string2);
        return t;
    }

    public static int f(int i, String string2) {
        if (i <= 0) {
        } else {
            return i;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string2);
        stringBuilder.append(" > 0 required but it was ");
        stringBuilder.append(i);
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.toString());
        throw illegalArgumentException;
    }

    public static long g(long l, String string2) {
        if (Long.compare(l, i) <= 0) {
        } else {
            return l;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(obj4);
        stringBuilder.append(" > 0 required but it was ");
        stringBuilder.append(l);
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.toString());
        throw illegalArgumentException;
    }
}
