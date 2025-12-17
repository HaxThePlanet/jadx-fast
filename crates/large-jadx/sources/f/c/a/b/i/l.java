package f.c.a.b.i;

import f.c.a.b.i.w.b.b;
import f.c.a.b.i.w.b.d;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public final class l implements b<Executor> {

    private static final class a {

        private static final f.c.a.b.i.l a;
        static {
            l lVar = new l();
            l.a.a = lVar;
        }

        static f.c.a.b.i.l a() {
            return l.a.a;
        }
    }
    public static f.c.a.b.i.l a() {
        return l.a.a();
    }

    public static Executor b() {
        final Executor executor = k.a();
        d.c(executor, "Cannot return null from a non-@Nullable @Provides method");
        return (Executor)executor;
    }

    @Override // f.c.a.b.i.w.b.b
    public Executor c() {
        return l.b();
    }

    @Override // f.c.a.b.i.w.b.b
    public Object get() {
        return c();
    }
}
