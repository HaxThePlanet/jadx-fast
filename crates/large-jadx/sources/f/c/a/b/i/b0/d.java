package f.c.a.b.i.b0;

import f.c.a.b.i.w.b.b;
import f.c.a.b.i.w.b.d;

/* loaded from: classes.dex */
public final class d implements b<f.c.a.b.i.b0.a> {

    private static final class a {

        private static final f.c.a.b.i.b0.d a;
        static {
            d dVar = new d();
            d.a.a = dVar;
        }

        static f.c.a.b.i.b0.d a() {
            return d.a.a;
        }
    }
    public static f.c.a.b.i.b0.d a() {
        return d.a.a();
    }

    public static f.c.a.b.i.b0.a c() {
        final f.c.a.b.i.b0.a aVar = b.b();
        d.c(aVar, "Cannot return null from a non-@Nullable @Provides method");
        return (a)aVar;
    }

    @Override // f.c.a.b.i.w.b.b
    public f.c.a.b.i.b0.a b() {
        return d.c();
    }

    @Override // f.c.a.b.i.w.b.b
    public Object get() {
        return b();
    }
}
