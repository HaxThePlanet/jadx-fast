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

/* loaded from: classes3.dex */
public final class b extends z {

    static final i.b.m0.g.b.b d;
    static final i.b.m0.g.h e;
    static final int f;
    static final i.b.m0.g.b.c g;
    final ThreadFactory b;
    final AtomicReference<i.b.m0.g.b.b> c;

    static final class b {

        final int a;
        final i.b.m0.g.b.c[] b;
        long c;
        b(int i, ThreadFactory threadFactory2) {
            int i2;
            i.b.m0.g.b.c[] objArr;
            i.b.m0.g.b.c cVar;
            super();
            this.a = i;
            this.b = new b.c[i];
            i2 = 0;
            while (i2 < i) {
                cVar = new b.c(threadFactory2);
                this.b[i2] = cVar;
                i2++;
            }
        }

        public i.b.m0.g.b.c a() {
            int i = this.a;
            if (i == 0) {
                return b.g;
            }
            long l = this.c;
            this.c = i4 += l;
            return this.b[(int)i3];
        }

        public void b() {
            int i;
            i.b.m0.g.b.c cVar;
            final i.b.m0.g.b.c[] objArr = this.b;
            i = 0;
            while (i < objArr.length) {
                objArr[i].dispose();
                i++;
            }
        }
    }

    static final class a extends z.c {

        private final e a;
        private final a b;
        private final e c;
        private final i.b.m0.g.b.c v;
        volatile boolean w;
        a(i.b.m0.g.b.c b$c) {
            super();
            this.v = c;
            e obj3 = new e();
            this.a = obj3;
            a aVar = new a();
            this.b = aVar;
            e eVar = new e();
            this.c = eVar;
            eVar.b(obj3);
            eVar.b(aVar);
        }

        @Override // i.b.z$c
        public b b(Runnable runnable) {
            if (this.w) {
                return d.INSTANCE;
            }
            return this.v.e(runnable, 0, obj3, TimeUnit.MILLISECONDS);
        }

        @Override // i.b.z$c
        public b c(Runnable runnable, long l2, TimeUnit timeUnit3) {
            if (this.w) {
                return d.INSTANCE;
            }
            return this.v.e(runnable, l2, obj3, obj10);
        }

        @Override // i.b.z$c
        public void dispose() {
            boolean z;
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

    static final class c extends i.b.m0.g.f {
        c(ThreadFactory threadFactory) {
            super(threadFactory);
        }
    }
    static {
        final int i7 = 0;
        b.f = b.f(Runtime.getRuntime().availableProcessors(), Integer.getInteger("rx2.computation-threads", i7).intValue());
        h hVar = new h("RxComputationShutdown");
        b.c cVar = new b.c(hVar);
        b.g = cVar;
        cVar.dispose();
        int i6 = 1;
        h hVar2 = new h("RxComputationThreadPool", Math.max(i6, Math.min(10, Integer.getInteger("rx2.computation-priority", 5).intValue())), i6);
        b.e = hVar2;
        b.b bVar = new b.b(i7, hVar2);
        b.d = bVar;
        bVar.b();
    }

    public b() {
        super(b.e);
    }

    public b(ThreadFactory threadFactory) {
        super();
        this.b = threadFactory;
        AtomicReference obj2 = new AtomicReference(b.d);
        this.c = obj2;
        g();
    }

    static int f(int i, int i2) {
        int obj0;
        if (i2 > 0) {
            if (i2 > i) {
            } else {
                obj0 = i2;
            }
        }
        return obj0;
    }

    @Override // i.b.z
    public z.c a() {
        b.a aVar = new b.a((b.b)this.c.get().a());
        return aVar;
    }

    @Override // i.b.z
    public b d(Runnable runnable, long l2, TimeUnit timeUnit3) {
        return (b.b)this.c.get().a().f(runnable, l2, timeUnit3);
    }

    @Override // i.b.z
    public b e(Runnable runnable, long l2, long l3, TimeUnit timeUnit4) {
        return (b.b)this.c.get().a().g(runnable, l2, obj4, timeUnit4);
    }

    @Override // i.b.z
    public void g() {
        b.b bVar = new b.b(b.f, this.b);
        if (!this.c.compareAndSet(b.d, bVar)) {
            bVar.b();
        }
    }
}
