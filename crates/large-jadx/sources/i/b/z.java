package i.b;

import i.b.j0.b;
import i.b.m0.a.d;
import i.b.m0.a.g;
import i.b.m0.g.f;
import i.b.m0.j.k;
import java.util.concurrent.TimeUnit;

/* compiled from: Scheduler.java */
/* loaded from: classes3.dex */
public abstract class z {

    static final long a = 0L;

    static final class a implements b, Runnable {

        final Runnable a;
        final z.c b;
        Thread c;
        a(Runnable runnable, z.c cVar) {
            super();
            this.a = runnable;
            this.b = cVar;
        }

        public void dispose() {
            Thread currentThread;
            if (this.c == Thread.currentThread()) {
                if (cVar instanceof f) {
                    cVar.h();
                } else {
                    this.b.dispose();
                }
            }
        }

        public boolean isDisposed() {
            return this.b.isDisposed();
        }

        @Override // java.lang.Runnable
        public void run() {
            this.c = Thread.currentThread();
            try {
                this.a.run();
            } finally {
                dispose();
                this.c = thread;
                throw th;
            }
            dispose();
            this.c = null;
        }
    }

    static final class b implements b, Runnable {

        final Runnable a;
        final z.c b;
        volatile boolean c;
        b(Runnable runnable, z.c cVar) {
            super();
            this.a = runnable;
            this.b = cVar;
        }

        public void dispose() {
            this.c = true;
            this.b.dispose();
        }

        public boolean isDisposed() {
            return this.c;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!this.c) {
                try {
                    this.a.run();
                } finally {
                    a.b(th);
                    this.b.dispose();
                    Throwable th = k.e(th);
                    throw th;
                }
            }
        }
    }

    public static abstract class c implements b {
        public long a(TimeUnit timeUnit) {
            return timeUnit.convert(System.currentTimeMillis(), TimeUnit.MILLISECONDS);
        }

        public b b(Runnable runnable) {
            return c(runnable, 0L, TimeUnit.NANOSECONDS);
        }

        public b d(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
            final i.b.z.c runnable2 = this;
            final long j22 = j;
            final Object obj3 = timeUnit;
            g gVar = new g();
            final g gVar2 = new g(gVar);
            final long l2 = runnable2.a(TimeUnit.NANOSECONDS);
            z.c.a aVar = new z.c.a(this, l2 + obj3.toNanos(j22), runnable3, a.w(runnable), l2, l3, gVar2, obj3.toNanos(j2), obj2);
            b bVar = runnable2.c(aVar, j22, obj3);
            if (bVar == d.INSTANCE) {
                return bVar;
            }
            gVar.a(bVar);
            return gVar2;
        }

        public abstract b c(Runnable runnable, long j, TimeUnit timeUnit);
    }
    static {
        final String str2 = 15;
        z.a = TimeUnit.MINUTES.toNanos(Long.getLong("rx2.scheduler.drift-tolerance", str2).longValue());
    }

    public long b(TimeUnit timeUnit) {
        return timeUnit.convert(System.currentTimeMillis(), TimeUnit.MILLISECONDS);
    }

    public b c(Runnable runnable) {
        return d(runnable, 0L, TimeUnit.NANOSECONDS);
    }

    public b d(Runnable runnable, long j, TimeUnit timeUnit) {
        final i.b.z.c cVar = a();
        final i.b.z.a aVar = new z.a(a.w(runnable), cVar);
        cVar.c(aVar, j, timeUnit);
        return aVar;
    }

    public b e(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        final i.b.z.c cVar = a();
        final i.b.z.b bVar = new z.b(a.w(runnable), cVar);
        b bVar2 = cVar.d(bVar, j, j2, timeUnit);
        return bVar2 == d.INSTANCE ? bVar2 : bVar;
    }

    public abstract z.c a();
}
