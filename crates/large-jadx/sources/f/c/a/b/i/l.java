package f.c.a.b.i;

import f.c.a.b.i.w.b.b;
import f.c.a.b.i.w.b.d;
import java.util.concurrent.Executor;

/* compiled from: ExecutionModule_ExecutorFactory.java */
/* loaded from: classes.dex */
public final class l implements b<Executor> {

    private static final class a {

        private static final l a = new l();

        static /* synthetic */ l a() {
            return l.a.a;
        }
    }
    public static l a() {
        return l.a.a;
    }

    public static Executor b() {
        final Executor executor = k.a();
        d.c(executor, "Cannot return null from a non-@Nullable @Provides method");
        return executor;
    }

    public Executor c() {
        return l.b();
    }
}
