package i.b.m0.g;

import i.b.m0.a.d;
import i.b.p0.a;
import i.b.z.c;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

/* compiled from: NewThreadWorker.java */
/* loaded from: classes3.dex */
public class f extends z.c implements i.b.j0.b {

    private final ScheduledExecutorService a;
    volatile boolean b;
    public f(ThreadFactory threadFactory) {
        super();
        this.a = l.a(threadFactory);
    }

    @Override // i.b.z$c
    public i.b.j0.b b(Runnable runnable) {
        return c(runnable, 0L, null);
    }

    @Override // i.b.z$c
    public i.b.j0.b c(Runnable runnable, long j, TimeUnit timeUnit) {
        if (this.b) {
            return d.INSTANCE;
        }
        return this.e(runnable, j, timeUnit, null);
    }

    @Override // i.b.z$c
    public void dispose() {
        if (!this.b) {
            this.b = true;
            this.a.shutdownNow();
        }
    }

    @Override // i.b.z$c
    public k e(Runnable runnable, long j, TimeUnit timeUnit, i.b.m0.a.b bVar) {
        Object obj;
        final i.b.m0.g.k kVar = new k(a.w(runnable), bVar);
        if (bVar != null && !bVar.b(kVar)) {
            return kVar;
        }
        if (j <= 0) {
            try {
                java.util.concurrent.Future submit = this.a.submit(kVar);
                java.util.concurrent.ScheduledFuture schedule = this.a.schedule(kVar, j, timeUnit);
                kVar.a(obj);
            } catch (java.util.concurrent.RejectedExecutionException rejectedExecution) {
            }
            return kVar;
        }
    }

    @Override // i.b.z$c
    public i.b.j0.b f(Runnable runnable, long j, TimeUnit timeUnit) {
        java.util.concurrent.Future submit;
        final i.b.m0.g.j jVar = new j(a.w(runnable));
        if (j <= 0) {
            try {
                submit = this.a.submit(jVar);
                java.util.concurrent.ScheduledFuture schedule = this.a.schedule(jVar, j, timeUnit);
                jVar.a(submit);
            } catch (java.util.concurrent.RejectedExecutionException rejectedExecution) {
                a.t(rejectedExecution);
                rejectedExecution = d.INSTANCE;
                return rejectedExecution;
            }
            return jVar;
        }
    }

    @Override // i.b.z$c
    public i.b.j0.b g(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        Object obj3;
        Runnable runnable2 = a.w(runnable);
        long l = 0L;
        if (j2 <= l) {
            final i.b.m0.g.c cVar = new c(runnable2, this.a);
            if (j <= l) {
                try {
                    java.util.concurrent.Future submit = this.a.submit(cVar);
                    java.util.concurrent.ScheduledFuture schedule = this.a.schedule(cVar, j, timeUnit);
                    cVar.b(obj3);
                } catch (java.util.concurrent.RejectedExecutionException rejectedExecution) {
                    a.t(rejectedExecution);
                    rejectedExecution = d.INSTANCE;
                    return rejectedExecution;
                }
                return cVar;
            }
        }
        final i.b.m0.g.i iVar = new i(runnable2);
        try {
            iVar.a(this.a.scheduleAtFixedRate(iVar, j, j2, timeUnit));
        } catch (java.util.concurrent.RejectedExecutionException rejectedExecution) {
            a.t(rejectedExecution);
            rejectedExecution = d.INSTANCE;
            return rejectedExecution;
        }
        return iVar;
    }

    @Override // i.b.z$c
    public void h() {
        if (!this.b) {
            this.b = true;
            this.a.shutdown();
        }
    }

    @Override // i.b.z$c
    public boolean isDisposed() {
        return this.b;
    }
}
