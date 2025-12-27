package i.b.m0.g;

import i.b.j0.b;
import i.b.m0.a.d;
import i.b.z;
import i.b.z.c;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: SingleScheduler.java */
/* loaded from: classes3.dex */
public final class m extends z {

    static final h c = new h();
    static final ScheduledExecutorService d;
    final AtomicReference<ScheduledExecutorService> b;

    static final class a extends z.c {

        final ScheduledExecutorService a;
        final i.b.j0.a b = new a();
        volatile boolean c;
        a(ScheduledExecutorService scheduledExecutorService) {
            super();
            this.a = scheduledExecutorService;
            final i.b.j0.a aVar = new a();
        }

        @Override // i.b.z$c
        public b c(Runnable runnable, long j, TimeUnit timeUnit) {
            java.util.concurrent.Future submit;
            if (this.c) {
                return d.INSTANCE;
            }
            i.b.m0.g.k kVar = new k(a.w(runnable), this.b);
            this.b.b(kVar);
            if (j <= 0) {
                try {
                    submit = this.a.submit(kVar);
                    java.util.concurrent.ScheduledFuture schedule = this.a.schedule(kVar, j, timeUnit);
                    kVar.a(submit);
                } catch (java.util.concurrent.RejectedExecutionException rejectedExecution) {
                    dispose();
                    a.t(rejectedExecution);
                    rejectedExecution = d.INSTANCE;
                    return rejectedExecution;
                }
                return kVar;
            }
        }

        @Override // i.b.z$c
        public void dispose() {
            if (!this.c) {
                this.c = true;
                this.b.dispose();
            }
        }

        @Override // i.b.z$c
        public boolean isDisposed() {
            return this.c;
        }
    }
    static {
        ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(0);
        m.d = scheduledThreadPool;
        scheduledThreadPool.shutdown();
    }

    public m() {
        this(m.c);
    }

    static ScheduledExecutorService f(ThreadFactory threadFactory) {
        return l.a(threadFactory);
    }

    @Override // i.b.z
    public z.c a() {
        return new m.a((ScheduledExecutorService)this.b.get());
    }

    @Override // i.b.z
    public b d(Runnable runnable, long j, TimeUnit timeUnit) {
        java.util.concurrent.Future submit;
        final i.b.m0.g.j jVar = new j(a.w(runnable));
        if (j <= 0) {
            try {
                submit = (ScheduledExecutorService)this.b.get().submit(jVar);
                java.util.concurrent.ScheduledFuture schedule = (ScheduledExecutorService)this.b.get().schedule(jVar, j, timeUnit);
                jVar.a(submit);
            } catch (java.util.concurrent.RejectedExecutionException rejectedExecution) {
                a.t(rejectedExecution);
                rejectedExecution = d.INSTANCE;
                return rejectedExecution;
            }
            return jVar;
        }
    }

    @Override // i.b.z
    public b e(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        Object obj3;
        Runnable runnable3 = a.w(runnable);
        long l = 0L;
        if (j2 <= l) {
            Object obj4 = this.b.get();
            final i.b.m0.g.c cVar = new c(runnable3, obj4);
            if (j <= l) {
                try {
                    java.util.concurrent.Future submit = obj4.submit(cVar);
                    java.util.concurrent.ScheduledFuture schedule = obj4.schedule(cVar, j, timeUnit);
                    cVar.b(obj3);
                } catch (java.util.concurrent.RejectedExecutionException rejectedExecution) {
                    a.t(rejectedExecution);
                    rejectedExecution = d.INSTANCE;
                    return rejectedExecution;
                }
                return cVar;
            }
        }
        final i.b.m0.g.i iVar = new i(runnable3);
        try {
            iVar.a((ScheduledExecutorService)runnable2.scheduleAtFixedRate(iVar, j, j2, timeUnit));
        } catch (java.util.concurrent.RejectedExecutionException rejectedExecution) {
            a.t(rejectedExecution);
            rejectedExecution = d.INSTANCE;
            return rejectedExecution;
        }
        return iVar;
    }

    public m(ThreadFactory threadFactory) {
        super();
        final AtomicReference atomicReference = new AtomicReference();
        this.b = atomicReference;
        atomicReference.lazySet(m.f(threadFactory));
    }
}
