package i.b;

import i.b.j0.b;
import i.b.m0.a.d;
import i.b.m0.a.g;
import i.b.m0.g.f;
import i.b.m0.j.k;
import i.b.p0.a;
import io.reactivex.exceptions.a;
import java.util.concurrent.TimeUnit;

/* loaded from: classes3.dex */
public abstract class z {

    static final long a;

    static final class a implements b, Runnable {

        final Runnable a;
        final i.b.z.c b;
        Thread c;
        a(Runnable runnable, i.b.z.c z$c2) {
            super();
            this.a = runnable;
            this.b = c2;
        }

        @Override // i.b.j0.b
        public void dispose() {
            Object thread;
            Thread currentThread;
            thread = this.b;
            if (this.c == Thread.currentThread() && thread instanceof f) {
                thread = this.b;
                if (thread instanceof f) {
                    (f)thread.h();
                } else {
                    this.b.dispose();
                }
            } else {
            }
        }

        @Override // i.b.j0.b
        public boolean isDisposed() {
            return this.b.isDisposed();
        }

        @Override // i.b.j0.b
        public void run() {
            this.c = Thread.currentThread();
            this.a.run();
            dispose();
            this.c = 0;
        }
    }

    static final class b implements b, Runnable {

        final Runnable a;
        final i.b.z.c b;
        volatile boolean c;
        b(Runnable runnable, i.b.z.c z$c2) {
            super();
            this.a = runnable;
            this.b = c2;
        }

        @Override // i.b.j0.b
        public void dispose() {
            this.c = true;
            this.b.dispose();
        }

        @Override // i.b.j0.b
        public boolean isDisposed() {
            return this.c;
        }

        @Override // i.b.j0.b
        public void run() {
            boolean z;
            if (!this.c) {
                this.a.run();
            }
        }
    }

    public static abstract class c implements b {
        @Override // i.b.j0.b
        public long a(TimeUnit timeUnit) {
            return timeUnit.convert(System.currentTimeMillis(), obj1);
        }

        @Override // i.b.j0.b
        public b b(Runnable runnable) {
            return c(runnable, 0, obj2);
        }

        @Override // i.b.j0.b
        public abstract b c(Runnable runnable, long l2, TimeUnit timeUnit3);

        @Override // i.b.j0.b
        public b d(Runnable runnable, long l2, long l3, TimeUnit timeUnit4) {
            final i.b.z.c cVar2 = this;
            final long l5 = l2;
            final Object obj = obj23;
            g gVar3 = new g();
            g gVar4 = new g(gVar3);
            final long l4 = cVar2.a(TimeUnit.NANOSECONDS);
            super(this, l4 + nanos, obj3, a.w(runnable), l4, obj6, gVar4, obj.toNanos(timeUnit4), obj9);
            b bVar = cVar2.c(aVar2, l5, obj12);
            if (bVar == d.INSTANCE) {
                return bVar;
            }
            gVar3.a(bVar);
            return gVar4;
        }
    }
    static {
        final int i = 15;
        z.a = TimeUnit.MINUTES.toNanos(Long.getLong("rx2.scheduler.drift-tolerance", i).longValue());
    }

    public abstract i.b.z.c a();

    public long b(TimeUnit timeUnit) {
        return timeUnit.convert(System.currentTimeMillis(), obj1);
    }

    public b c(Runnable runnable) {
        return d(runnable, 0, obj2);
    }

    public b d(Runnable runnable, long l2, TimeUnit timeUnit3) {
        final i.b.z.c cVar = a();
        z.a aVar = new z.a(a.w(runnable), cVar);
        cVar.c(aVar, l2, timeUnit3);
        return aVar;
    }

    public b e(Runnable runnable, long l2, long l3, TimeUnit timeUnit4) {
        final i.b.z.c cVar = a();
        z.b bVar2 = new z.b(a.w(runnable), cVar);
        b obj9 = cVar.d(bVar2, l2, obj3, timeUnit4);
        if (obj9 == d.INSTANCE) {
            return obj9;
        }
        return bVar2;
    }
}
