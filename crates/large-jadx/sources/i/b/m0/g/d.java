package i.b.m0.g;

import i.b.j0.a;
import i.b.j0.b;
import i.b.m0.a.d;
import i.b.z;
import i.b.z.c;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: IoScheduler.java */
/* loaded from: classes3.dex */
public final class d extends z {

    static final h d = new h();
    static final h e = new h();
    private static final long f = 0L;
    private static final TimeUnit g;
    static final d.c h = new d$c();
    static final d.a i = new d$a();
    final ThreadFactory b;
    final AtomicReference<d.a> c;

    static final class a implements Runnable {

        private final long a = 0;
        private final ConcurrentLinkedQueue<d.c> b = new ConcurrentLinkedQueue<>();
        final a c = new a();
        private final ScheduledExecutorService v;
        private final Future<?> w;
        private final ThreadFactory x;
        a(long j, TimeUnit timeUnit, ThreadFactory threadFactory) {
            long nanos = 0;
            int j3 = 0;
            super();
            if (timeUnit != null) {
                nanos = timeUnit.toNanos(j);
            } else {
                int i2 = 0;
            }
            final TimeUnit timeUnit22 = nanos;
            ConcurrentLinkedQueue concurrentLinkedQueue = new ConcurrentLinkedQueue();
            a aVar = new a();
            this.x = threadFactory;
            j3 = 0;
            if (timeUnit != null) {
                java.util.concurrent.ScheduledFuture scheduleWithFixedDelay = j2.scheduleWithFixedDelay(this, timeUnit22, timeUnit22, TimeUnit.NANOSECONDS);
            } else {
            }
            this.v = j3;
            this.w = j3;
        }

        void a() {
            boolean remove;
            if (!this.b.isEmpty()) {
                long l = c();
                Iterator it = this.b.iterator();
                while (it.hasNext()) {
                    Object item = it.next();
                    long l2 = item.i();
                    if (l2 > this.b) {
                        return;
                    }
                }
            }
        }

        d.c b() {
            if (this.c.isDisposed()) {
                return d.h;
            }
            while (!this.b.isEmpty()) {
                Object poll = this.b.poll();
                if (poll != null) {
                    return poll;
                }
            }
            i.b.m0.g.d.c cVar2 = new d.c(this.x);
            this.c.b(cVar2);
            return cVar2;
        }

        long c() {
            return System.nanoTime();
        }

        void d(d.c cVar) {
            cVar.j(c() + this.a);
            this.b.offer(cVar);
        }

        void e() {
            this.c.dispose();
            if (this.w != null) {
                boolean z = true;
                this.w.cancel(z);
            }
            if (this.v != null) {
                this.v.shutdownNow();
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            a();
        }
    }

    static final class b extends z.c {

        private final a a = new a();
        private final d.a b;
        private final d.c c;
        final AtomicBoolean v = new AtomicBoolean();
        b(d.a aVar) {
            super();
            AtomicBoolean atomicBoolean = new AtomicBoolean();
            this.b = aVar;
            a aVar2 = new a();
            this.c = aVar.b();
        }

        @Override // i.b.z$c
        public b c(Runnable runnable, long j, TimeUnit timeUnit) {
            if (this.a.isDisposed()) {
                return d.INSTANCE;
            }
            return this.c.e(runnable, j, timeUnit, this.a);
        }

        @Override // i.b.z$c
        public void dispose() {
            boolean z = false;
            if (this.v.compareAndSet(z, true)) {
                this.a.dispose();
                this.b.d(this.c);
            }
        }

        @Override // i.b.z$c
        public boolean isDisposed() {
            return this.v.get();
        }
    }

    static final class c extends f {

        private long c = 0;
        c(ThreadFactory threadFactory) {
            super(threadFactory);
        }

        @Override // i.b.m0.g.f
        public long i() {
            return this.c;
        }

        @Override // i.b.m0.g.f
        public void j(long j) {
            this.c = j;
        }
    }
    static {
        d.g = TimeUnit.SECONDS;
        long value = Long.getLong("rx2.io-keep-alive-time", 60L).longValue();
        d.f = value;
        i.b.m0.g.h hVar = new h("RxCachedThreadSchedulerShutdown");
        value.dispose();
        Math.max(1, Math.min(10, Integer.getInteger("rx2.io-priority", 5).intValue())).e();
    }

    public d() {
        this(d.d);
    }

    @Override // i.b.z
    public z.c a() {
        return new d.b((d.a)this.c.get());
    }

    @Override // i.b.z
    public void f() {
        final i.b.m0.g.d.a aVar = new d.a(d.f, r2, d.g, this.b);
        if (!this.c.compareAndSet(d.i, aVar)) {
            aVar.e();
        }
    }

    public d(ThreadFactory threadFactory) {
        super();
        this.b = threadFactory;
        this.c = new AtomicReference(d.i);
        f();
    }
}
