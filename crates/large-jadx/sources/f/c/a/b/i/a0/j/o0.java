package f.c.a.b.i.a0.j;

import f.c.a.b.i.w.b.b;
import f.c.a.b.i.w.b.d;

/* compiled from: EventStoreModule_StoreConfigFactory.java */
/* loaded from: classes.dex */
public final class o0 implements b<j0> {

    private static final class a {

        private static final o0 a = new o0();

        static /* synthetic */ o0 a() {
            return o0.a.a;
        }
    }
    public static o0 a() {
        return o0.a.a;
    }

    public static j0 c() {
        final f.c.a.b.i.a0.j.j0 j0Var = k0.d();
        d.c(j0Var, "Cannot return null from a non-@Nullable @Provides method");
        return j0Var;
    }

    public j0 b() {
        return o0.c();
    }
}
