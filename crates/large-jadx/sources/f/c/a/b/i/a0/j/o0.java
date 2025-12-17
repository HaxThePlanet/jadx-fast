package f.c.a.b.i.a0.j;

import f.c.a.b.i.w.b.b;
import f.c.a.b.i.w.b.d;

/* loaded from: classes.dex */
public final class o0 implements b<f.c.a.b.i.a0.j.j0> {

    private static final class a {

        private static final f.c.a.b.i.a0.j.o0 a;
        static {
            o0 o0Var = new o0();
            o0.a.a = o0Var;
        }

        static f.c.a.b.i.a0.j.o0 a() {
            return o0.a.a;
        }
    }
    public static f.c.a.b.i.a0.j.o0 a() {
        return o0.a.a();
    }

    public static f.c.a.b.i.a0.j.j0 c() {
        final f.c.a.b.i.a0.j.j0 j0Var = k0.d();
        d.c(j0Var, "Cannot return null from a non-@Nullable @Provides method");
        return (j0)j0Var;
    }

    @Override // f.c.a.b.i.w.b.b
    public f.c.a.b.i.a0.j.j0 b() {
        return o0.c();
    }

    @Override // f.c.a.b.i.w.b.b
    public Object get() {
        return b();
    }
}
