package d.b.a.a;

import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public class a extends d.b.a.a.c {

    private static volatile d.b.a.a.a c;
    private static final Executor d;
    private d.b.a.a.c a;
    private d.b.a.a.c b;

    static class a implements Executor {
        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            a.e().a(runnable);
        }
    }
    static {
        a.a aVar = new a.a();
        a.d = aVar;
    }

    private a() {
        super();
        b bVar = new b();
        this.b = bVar;
        this.a = bVar;
    }

    public static Executor d() {
        return a.d;
    }

    public static d.b.a.a.a e() {
        d.b.a.a.a aVar;
        if (a.c != null) {
            return a.c;
        }
        Class<d.b.a.a.a> obj = a.class;
        synchronized (obj) {
            aVar = new a();
            a.c = aVar;
            return a.c;
        }
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
