package d.b.a.a;

import java.util.concurrent.Executor;

/* compiled from: ArchTaskExecutor.java */
/* loaded from: classes.dex */
public class a extends c {

    private static volatile a c;
    private static final Executor d = new a$a();
    private c a = new b();
    private c b = new b();

    static class a implements Executor {
        a() {
            super();
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            a.e().a(runnable);
        }
    }

    private a() {
        super();
        final d.b.a.a.b bVar = new b();
    }

    public static Executor d() {
        return a.d;
    }

    public static a e() {
        if (a.c != null) {
            return a.c;
        }
        Class<d.b.a.a.a> obj2 = a.class;
        synchronized (obj2) {
            try {
                if (a.c == null) {
                    a.c = new a();
                }
            } catch (Throwable th) {
            }
        }
        return a.c;
    }

    @Override // d.b.a.a.c
    public void a(Runnable runnable) {
        this.a.a(runnable);
    }

    @Override // d.b.a.a.c
    public boolean b() {
        return this.a.b();
    }

    @Override // d.b.a.a.c
    public void c(Runnable runnable) {
        this.a.c(runnable);
    }
}
