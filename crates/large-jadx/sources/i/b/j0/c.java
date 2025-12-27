package i.b.j0;

import i.b.m0.a.d;
import i.b.m0.b.a;
import i.b.m0.b.b;

/* compiled from: Disposables.java */
/* loaded from: classes3.dex */
public final class c {
    public static b a() {
        return d.INSTANCE;
    }

    public static b b() {
        return c.c(a.b);
    }

    public static b c(Runnable runnable) {
        b.e(runnable, "run is null");
        return new e(runnable);
    }
}
