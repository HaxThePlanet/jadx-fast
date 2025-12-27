package f.c.a.b.i.a0.j;

import f.c.a.b.i.w.b.b;
import f.c.a.b.i.w.b.d;

/* compiled from: EventStoreModule_DbNameFactory.java */
/* loaded from: classes.dex */
public final class l0 implements b<String> {

    private static final class a {

        private static final l0 a = new l0();

        static /* synthetic */ l0 a() {
            return l0.a.a;
        }
    }
    public static l0 a() {
        return l0.a.a;
    }

    public static String b() {
        final String str = k0.a();
        d.c(str, "Cannot return null from a non-@Nullable @Provides method");
        return str;
    }

    public String c() {
        return l0.b();
    }
}
