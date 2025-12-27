package i.b.m0.g;

import i.b.j0.a;
import i.b.j0.b;
import i.b.m0.a.d;
import i.b.m0.a.e;
import i.b.z;
import i.b.z.c;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: ComputationScheduler.java */
/* loaded from: classes3.dex */
public final class b extends z {

    static final b.b d = new b$b();
    static final h e = new h();
    static final int f = 0;
    static final b.c g = new b$c();
    final ThreadFactory b;
    final AtomicReference<b.b> c;

    static final class b {

        final int a;
        final b.c[] b;
        long c;
        b(int i, ThreadFactory threadFactory) {
            int i2 = 0;
            super();
            this.a = i;
            this.b = new b.c[i];
            i2 = 0;
            while (new b.c[i] < i) {
                this.b[i2] = new b.c(threadFactory);
                i2 = i2 + 1;
            }
        }

        public b.c a() {
            if (this.a == 0) {
                return b.g;
            }
            this.c = 1L + l;
            return this.b[(int)(l % (long)i)];
        }

        public void b() {
            int i = 0;
            i = 0;
            for (i.b.m0.g.b.c cVar : objArr) {
                cVar.dispose();
            }
        }
    }

    static final class a extends z.c {

        private final e a = new e();
        private final a b = new a();
        private final e c = new e();
        private final b.c v;
        volatile boolean w;
        a(b.c cVar) {
            super();
            this.v = cVar;
            final e eVar = new e();
            eVar.b(new e());
            eVar.b(new a());
        }

        @Override // i.b.z$c
        public b b(Runnable runnable) {
            if (this.w) {
                return d.INSTANCE;
            }
            return this.v.e(runnable, 0L, TimeUnit.MILLISECONDS, this.a);
        }

        @Override // i.b.z$c
        public b c(Runnable runnable, long j, TimeUnit timeUnit) {
            if (this.w) {
                return d.INSTANCE;
            }
            return this.v.e(runnable, j, timeUnit, this.b);
        }

        @Override // i.b.z$c
        public void dispose() {
            if (!this.w) {
                this.w = true;
                this.c.dispose();
            }
        }

        @Override // i.b.z$c
        public boolean isDisposed() {
            return this.w;
        }
    }

    static final class c extends f {
        c(ThreadFactory threadFactory) {
            super(threadFactory);
        }
    }
    static {
        int i = b.f(Runtime.getRuntime().availableProcessors(), Integer.getInteger("rx2.computation-threads", 0).intValue());
        b.f = i;
        i.b.m0.g.h hVar = new h("RxComputationShutdown");
        i.dispose();
        Math.max(1, Math.min(10, Integer.getInteger("rx2.computation-priority", 5).intValue())).b();
    }

    public b() {
        this(b.e);
    }

    @Override // i.b.z
    public z.c a() {
        return new b.a((b.b)this.c.get().a());
    }

    @Override // i.b.z
    public b d(Runnable runnable, long j, TimeUnit timeUnit) {
        return (b.b)this.c.get().a().f(runnable, j, timeUnit);
    }

    @Override // i.b.z
    public b e(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        return (b.b)this.c.get().a().g(runnable, j, j2, timeUnit);
    }

    @Override // i.b.z
    public void g() {
        final i.b.m0.g.b.b bVar = new b.b(b.f, this.b);
        if (!this.c.compareAndSet(b.d, bVar)) {
            bVar.b();
        }
    }

    public b(ThreadFactory threadFactory) {
        super();
        this.b = threadFactory;
        this.c = new AtomicReference(b.d);
        g();
    }

    static int f(int i, int i2) {
        int i22;
        return i22;
    }
}
