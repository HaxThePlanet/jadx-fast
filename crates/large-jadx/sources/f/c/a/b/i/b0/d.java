package f.c.a.b.i.b0;

import f.c.a.b.i.w.b.b;
import f.c.a.b.i.w.b.d;

/* compiled from: TimeModule_UptimeClockFactory.java */
/* loaded from: classes.dex */
public final class d implements b<a> {

    private static final class a {

        private static final d a = new d();

        static /* synthetic */ d a() {
            return d.a.a;
        }
    }
    public static d a() {
        return d.a.a;
    }

    public static a c() {
        final f.c.a.b.i.b0.a aVar = b.b();
        d.c(aVar, "Cannot return null from a non-@Nullable @Provides method");
        return aVar;
    }

    public a b() {
        return d.c();
    }
}
