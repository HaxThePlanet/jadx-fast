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

/* loaded from: classes3.dex */
public final class d extends z {

    static final i.b.m0.g.h d;
    static final i.b.m0.g.h e;
    private static final long f;
    private static final TimeUnit g;
    static final i.b.m0.g.d.c h;
    static final i.b.m0.g.d.a i;
    final ThreadFactory b;
    final AtomicReference<i.b.m0.g.d.a> c;

    static final class a implements Runnable {

        private final long a = 0;
        private final ConcurrentLinkedQueue<i.b.m0.g.d.c> b;
        final a c;
        private final ScheduledExecutorService v;
        private final Future<?> w;
        private final ThreadFactory x;
        a(long l, TimeUnit timeUnit2, ThreadFactory threadFactory3) {
            ScheduledExecutorService service;
            Object obj;
            long l2;
            TimeUnit nANOSECONDS;
            long obj8;
            int obj9;
            super();
            if (threadFactory3 != null) {
                obj8 = threadFactory3.toNanos(l);
            } else {
                obj8 = 0;
            }
            final long l3 = obj8;
            obj8 = new ConcurrentLinkedQueue();
            this.b = obj8;
            obj8 = new a();
            this.c = obj8;
            this.x = obj11;
            if (threadFactory3 != null) {
                obj9 = Executors.newScheduledThreadPool(1, d.e).scheduleWithFixedDelay(this, l3, obj3, l3);
            } else {
                obj9 = obj8;
            }
            this.v = obj8;
            this.w = obj9;
        }

        @Override // java.lang.Runnable
        void a() {
            boolean empty;
            Iterator iterator;
            Object next;
            boolean remove;
            if (!this.b.isEmpty()) {
                iterator = this.b.iterator();
                while (iterator.hasNext()) {
                    next = iterator.next();
                    if (Long.compare(l, empty) <= 0) {
                    }
                    if (this.b.remove(next)) {
                    }
                    this.c.a(next);
                }
            }
        }

        @Override // java.lang.Runnable
        i.b.m0.g.d.c b() {
            boolean disposed;
            if (this.c.isDisposed()) {
                return d.h;
            }
            while (!this.b.isEmpty()) {
                disposed = this.b.poll();
            }
            d.c cVar2 = new d.c(this.x);
            this.c.b(cVar2);
            return cVar2;
        }

        @Override // java.lang.Runnable
        long c() {
            return System.nanoTime();
        }

        @Override // java.lang.Runnable
        void d(i.b.m0.g.d.c d$c) {
            c.j(l += l2);
            this.b.offer(c);
        }

        @Override // java.lang.Runnable
        void e() {
            int i;
            this.c.dispose();
            Future future = this.w;
            if (future != null) {
                future.cancel(true);
            }
            ScheduledExecutorService service = this.v;
            if (service != null) {
                service.shutdownNow();
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            a();
        }
    }

    static final class b extends z.c {

        private final a a;
        private final i.b.m0.g.d.a b;
        private final i.b.m0.g.d.c c;
        final AtomicBoolean v;
        b(i.b.m0.g.d.a d$a) {
            super();
            AtomicBoolean atomicBoolean = new AtomicBoolean();
            this.v = atomicBoolean;
            this.b = a;
            a aVar = new a();
            this.a = aVar;
            this.c = a.b();
        }

        @Override // i.b.z$c
        public b c(Runnable runnable, long l2, TimeUnit timeUnit3) {
            if (this.a.isDisposed()) {
                return d.INSTANCE;
            }
            return this.c.e(runnable, l2, obj3, obj10);
        }

        @Override // i.b.z$c
        public void dispose() {
            boolean compareAndSet;
            int i;
            if (this.v.compareAndSet(false, true)) {
                this.a.dispose();
                this.b.d(this.c);
            }
        }

        @Override // i.b.z$c
        public boolean isDisposed() {
            return this.v.get();
        }
    }

    static final class c extends i.b.m0.g.f {

        private long c = 0;
        c(ThreadFactory threadFactory) {
            super(threadFactory);
            final int i = 0;
        }

        @Override // i.b.m0.g.f
        public long i() {
            return this.c;
        }

        @Override // i.b.m0.g.f
        public void j(long l) {
            this.c = l;
        }
    }
    static {
        d.g = TimeUnit.SECONDS;
        d.f = Long.getLong("rx2.io-keep-alive-time", 60).longValue();
        h hVar = new h("RxCachedThreadSchedulerShutdown");
        d.c cVar = new d.c(hVar);
        d.h = cVar;
        cVar.dispose();
        int i2 = Math.max(1, Math.min(10, Integer.getInteger("rx2.io-priority", 5).intValue()));
        h hVar2 = new h("RxCachedThreadScheduler", i2);
        d.d = hVar2;
        final String str5 = "RxCachedWorkerPoolEvictor";
        h hVar3 = new h(str5, i2);
        d.e = hVar3;
        d.a aVar = new d.a(0, str5, 0, hVar2);
        d.i = aVar;
        aVar.e();
    }

    public d() {
        super(d.d);
    }

    public d(ThreadFactory threadFactory) {
        super();
        this.b = threadFactory;
        AtomicReference obj2 = new AtomicReference(d.i);
        this.c = obj2;
        f();
    }

    @Override // i.b.z
    public z.c a() {
        d.b bVar = new d.b((d.a)this.c.get());
        return bVar;
    }

    @Override // i.b.z
    public void f() {
        d.a aVar = new d.a(d.f, obj2, d.g, this.b);
        if (!this.c.compareAndSet(d.i, aVar)) {
            aVar.e();
        }
    }
}
