package androidx.camera.core.impl.o.a;

import com.google.common.util.concurrent.c;

/* loaded from: classes.dex */
public final class a {
    static {
    }

    public static <V> c<V> a(Throwable throwable) {
        b.a aVar = new b.a(throwable);
        return aVar;
    }

    public static <V> c<V> b(V v) {
        if (v == null) {
            return b.a();
        }
        b.b bVar = new b.b(v);
        return bVar;
    }
}
