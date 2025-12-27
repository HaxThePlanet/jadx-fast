package i.b.m0.g;

import i.b.j0.c;
import i.b.m0.a.d;
import i.b.p0.a;
import i.b.z;
import i.b.z.c;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: TrampolineScheduler.java */
/* loaded from: classes3.dex */
public final class n extends z {

    private static final n b = new n();

    static final class a implements Runnable {

        private final Runnable a;
        private final n.c b;
        private final long c;
        a(Runnable runnable, n.c cVar, long j) {
            super();
            this.a = runnable;
            this.b = cVar;
            this.c = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            long l;
            if (!this.b.v) {
                long l2 = this.b.a(TimeUnit.MILLISECONDS);
                if (this.c > l2) {
                    l = l - l2;
                    try {
                        Thread.sleep(l);
                    } catch (java.lang.InterruptedException interrupted) {
                        Thread.currentThread().interrupt();
                        a.t(interrupted);
                        return;
                    }
                }
                if (!this.b.v) {
                    this.a.run();
                }
            }
        }
    }

    static final class b implements Comparable<n.b> {

        final Runnable a;
        final long b;
        final int c;
        volatile boolean v;
        b(Runnable runnable, Long long, int i) {
            super();
            this.a = runnable;
            this.b = long.longValue();
            this.c = i;
        }

        public int a(n.b bVar) {
            int i = b.b(this.b, bVar.b);
            if (i == 0) {
                return b.a(this.c, bVar.c);
            }
            return i;
        }
    }

    static final class c extends z.c implements i.b.j0.b {

        final PriorityBlockingQueue<n.b> a = new PriorityBlockingQueue<>();
        private final AtomicInteger b = new AtomicInteger();
        final AtomicInteger c = new AtomicInteger();
        volatile boolean v;
        c() {
            super();
            PriorityBlockingQueue priorityBlockingQueue = new PriorityBlockingQueue();
            AtomicInteger atomicInteger = new AtomicInteger();
            AtomicInteger atomicInteger2 = new AtomicInteger();
        }

        @Override // i.b.z$c
        public i.b.j0.b b(Runnable runnable) {
            return e(runnable, a(TimeUnit.MILLISECONDS));
        }

        @Override // i.b.z$c
        public i.b.j0.b c(Runnable runnable, long j, TimeUnit timeUnit) {
            long l2 = a(TimeUnit.MILLISECONDS) + timeUnit.toMillis(j);
            return e(new n.a(runnable, this, l2, obj), l2);
        }

        @Override // i.b.z$c
        public void dispose() {
            this.v = true;
        }

        @Override // i.b.z$c
        i.b.j0.b e(Runnable runnable, long j) throws java.lang.InterruptedException {
            int andGet = 1;
            int incrementAndGet;
            if (this.v) {
                return d.INSTANCE;
            }
            i.b.m0.g.n.b bVar = new n.b(runnable, Long.valueOf(j), this.c.incrementAndGet());
            this.a.add(bVar);
            if (this.b.getAndIncrement() == 0) {
                andGet = 1;
                while (this.v) {
                    Long poll = this.a.poll();
                    if (poll == null) {
                    }
                }
                this.a.clear();
                return d.INSTANCE;
            }
            return c.c(new n.c.a(this, bVar));
        }

        @Override // i.b.z$c
        public boolean isDisposed() {
            return this.v;
        }
    }

    n() {
        super();
    }

    public static n f() {
        return n.b;
    }

    @Override // i.b.z
    public z.c a() {
        return new n.c();
    }

    @Override // i.b.z
    public i.b.j0.b c(Runnable runnable) {
        a.w(runnable).run();
        return d.INSTANCE;
    }

    @Override // i.b.z
    public i.b.j0.b d(Runnable runnable, long j, TimeUnit timeUnit) {
        try {
            timeUnit.sleep(j);
            a.w(runnable).run();
        } catch (java.lang.InterruptedException interrupted) {
            j = Thread.currentThread();
            j.interrupt();
            a.t(interrupted);
        }
        return d.INSTANCE;
    }
}
