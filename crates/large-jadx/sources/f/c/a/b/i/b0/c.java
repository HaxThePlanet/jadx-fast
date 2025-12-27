package f.c.a.b.i.b0;

import f.c.a.b.i.w.b.b;
import f.c.a.b.i.w.b.d;

/* compiled from: TimeModule_EventClockFactory.java */
/* loaded from: classes.dex */
public final class c implements b<a> {

    private static final class a {

        private static final c a = new c();

        static /* synthetic */ c a() {
            return c.a.a;
        }
    }
    public static c a() {
        return c.a.a;
    }

    public static a b() {
        final f.c.a.b.i.b0.a aVar = b.a();
        d.c(aVar, "Cannot return null from a non-@Nullable @Provides method");
        return aVar;
    }

    public a c() {
        return c.b();
    }
}
