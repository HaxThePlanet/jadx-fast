package f.c.a.b.i.a0.j;

import f.c.a.b.i.w.b.b;
import f.c.a.b.i.w.b.d;

/* loaded from: classes.dex */
public final class l0 implements b<String> {

    private static final class a {

        private static final f.c.a.b.i.a0.j.l0 a;
        static {
            l0 l0Var = new l0();
            l0.a.a = l0Var;
        }

        static f.c.a.b.i.a0.j.l0 a() {
            return l0.a.a;
        }
    }
    public static f.c.a.b.i.a0.j.l0 a() {
        return l0.a.a();
    }

    public static String b() {
        final String str = k0.a();
        d.c(str, "Cannot return null from a non-@Nullable @Provides method");
        return (String)str;
    }

    @Override // f.c.a.b.i.w.b.b
    public String c() {
        return l0.b();
    }

    @Override // f.c.a.b.i.w.b.b
    public Object get() {
        return c();
    }
}
