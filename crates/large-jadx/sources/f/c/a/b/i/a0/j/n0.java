package f.c.a.b.i.a0.j;

import f.c.a.b.i.w.b.b;

/* loaded from: classes.dex */
public final class n0 implements b<Integer> {

    private static final class a {

        private static final f.c.a.b.i.a0.j.n0 a;
        static {
            n0 n0Var = new n0();
            n0.a.a = n0Var;
        }

        static f.c.a.b.i.a0.j.n0 a() {
            return n0.a.a;
        }
    }
    public static f.c.a.b.i.a0.j.n0 a() {
        return n0.a.a();
    }

    public static int c() {
        return k0.c();
    }

    @Override // f.c.a.b.i.w.b.b
    public Integer b() {
        return Integer.valueOf(n0.c());
    }

    @Override // f.c.a.b.i.w.b.b
    public Object get() {
        return b();
    }
}
