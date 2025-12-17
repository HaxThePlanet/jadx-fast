package f.c.a.b.i.b0;

import f.c.a.b.i.w.b.b;
import f.c.a.b.i.w.b.d;

/* loaded from: classes.dex */
public final class c implements b<f.c.a.b.i.b0.a> {

    private static final class a {

        private static final f.c.a.b.i.b0.c a;
        static {
            c cVar = new c();
            c.a.a = cVar;
        }

        static f.c.a.b.i.b0.c a() {
            return c.a.a;
        }
    }
    public static f.c.a.b.i.b0.c a() {
        return c.a.a();
    }

    public static f.c.a.b.i.b0.a b() {
        final f.c.a.b.i.b0.a aVar = b.a();
        d.c(aVar, "Cannot return null from a non-@Nullable @Provides method");
        return (a)aVar;
    }

    @Override // f.c.a.b.i.w.b.b
    public f.c.a.b.i.b0.a c() {
        return c.b();
    }

    @Override // f.c.a.b.i.w.b.b
    public Object get() {
        return c();
    }
}
