package i.b.j0;

import i.b.m0.a.d;
import i.b.m0.b.a;
import i.b.m0.b.b;

/* loaded from: classes3.dex */
public final class c {
    public static i.b.j0.b a() {
        return d.INSTANCE;
    }

    public static i.b.j0.b b() {
        return c.c(a.b);
    }

    public static i.b.j0.b c(Runnable runnable) {
        b.e(runnable, "run is null");
        e eVar = new e(runnable);
        return eVar;
    }
}
