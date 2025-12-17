package i.b.m0.g;

import i.b.j0.b;
import i.b.j0.c;
import i.b.m0.a.d;
import i.b.m0.b.b;
import i.b.p0.a;
import i.b.z;
import i.b.z.c;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes3.dex */
public final class n extends z {

    private static final i.b.m0.g.n b;

    static final class a implements Runnable {

        private final Runnable a;
        private final i.b.m0.g.n.c b;
        private final long c;
        a(Runnable runnable, i.b.m0.g.n.c n$c2, long l3) {
            super();
            this.a = runnable;
            this.b = c2;
            this.c = l3;
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean z;
            Object currentThread;
            long l;
            int cmp;
            long l2 = this.b.a(TimeUnit.MILLISECONDS);
            l = this.c;
            if (!cVar.v && Long.compare(l, l2) > 0) {
                l2 = this.b.a(TimeUnit.MILLISECONDS);
                l = this.c;
                if (Long.compare(l, l2) > 0) {
                    Thread.sleep(l -= l2);
                }
                if (!cVar3.v) {
                    this.a.run();
                }
            }
        }
    }

    static final class b implements Comparable<i.b.m0.g.n.b> {

        final Runnable a;
        final long b;
        final int c;
        volatile boolean v;
        b(Runnable runnable, Long long2, int i3) {
            super();
            this.a = runnable;
            this.b = long2.longValue();
            this.c = i3;
        }

        @Override // java.lang.Comparable
        public int a(i.b.m0.g.n.b n$b) {
            int i = b.b(this.b, obj1);
            if (i == 0) {
                return b.a(this.c, b.c);
            }
            return i;
        }

        @Override // java.lang.Comparable
        public int compareTo(Object object) {
            return a((n.b)object);
        }
    }

    static final class c extends z.c implements b {

        final PriorityBlockingQueue<i.b.m0.g.n.b> a;
        private final AtomicInteger b;
        final AtomicInteger c;
        volatile boolean v;
        c() {
            super();
            PriorityBlockingQueue priorityBlockingQueue = new PriorityBlockingQueue();
            this.a = priorityBlockingQueue;
            AtomicInteger atomicInteger = new AtomicInteger();
            this.b = atomicInteger;
            AtomicInteger atomicInteger2 = new AtomicInteger();
            this.c = atomicInteger2;
        }

        @Override // i.b.z$c
        public b b(Runnable runnable) {
            return e(runnable, a(TimeUnit.MILLISECONDS));
        }

        @Override // i.b.z$c
        public b c(Runnable runnable, long l2, TimeUnit timeUnit3) {
            l += obj4;
            n.a obj4 = new n.a(runnable, this, i, obj1);
            return e(obj4, i);
        }

        @Override // i.b.z$c
        public void dispose() {
            this.v = true;
        }

        @Override // i.b.z$c
        b e(Runnable runnable, long l2) {
            int obj2;
            Long obj3;
            int obj4;
            if (this.v) {
                return d.INSTANCE;
            }
            n.b bVar = new n.b(runnable, Long.valueOf(l2), this.c.incrementAndGet());
            this.a.add(bVar);
            if (this.b.getAndIncrement() == 0) {
                obj2 = 1;
                while (this.v) {
                    obj3 = this.a.poll();
                    if (obj3.v == 0) {
                    }
                    obj3.a.run();
                }
                this.a.clear();
                return d.INSTANCE;
            }
            obj2 = new n.c.a(this, bVar);
            return c.c(obj2);
        }

        @Override // i.b.z$c
        public boolean isDisposed() {
            return this.v;
        }
    }
    static {
        n nVar = new n();
        n.b = nVar;
    }

    public static i.b.m0.g.n f() {
        return n.b;
    }

    @Override // i.b.z
    public z.c a() {
        n.c cVar = new n.c();
        return cVar;
    }

    @Override // i.b.z
    public b c(Runnable runnable) {
        a.w(runnable).run();
        return d.INSTANCE;
    }

    @Override // i.b.z
    public b d(Runnable runnable, long l2, TimeUnit timeUnit3) {
        Runnable obj1;
        long obj2;
        try {
            obj4.sleep(l2);
            a.w(runnable).run();
            l2 = Thread.currentThread();
            l2.interrupt();
            a.t(runnable);
            return d.INSTANCE;
        }
    }
}
