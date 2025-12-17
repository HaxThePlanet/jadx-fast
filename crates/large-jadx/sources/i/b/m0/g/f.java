package i.b.m0.g;

import i.b.j0.b;
import i.b.m0.a.b;
import i.b.m0.a.d;
import i.b.p0.a;
import i.b.z.c;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

/* loaded from: classes3.dex */
public class f extends z.c implements b {

    private final ScheduledExecutorService a;
    volatile boolean b;
    public f(ThreadFactory threadFactory) {
        super();
        this.a = l.a(threadFactory);
    }

    @Override // i.b.z$c
    public b b(Runnable runnable) {
        return c(runnable, 0, obj1);
    }

    @Override // i.b.z$c
    public b c(Runnable runnable, long l2, TimeUnit timeUnit3) {
        if (this.b) {
            return d.INSTANCE;
        }
        return this.e(runnable, l2, obj3, obj10);
    }

    @Override // i.b.z$c
    public void dispose() {
        boolean z;
        if (!this.b) {
            this.b = true;
            this.a.shutdownNow();
        }
    }

    @Override // i.b.z$c
    public i.b.m0.g.k e(Runnable runnable, long l2, TimeUnit timeUnit3, b b4) {
        Runnable obj4;
        k kVar = new k(a.w(runnable), obj8);
        if (obj8 != null && !obj8.b(kVar)) {
            if (!obj8.b(kVar)) {
                return kVar;
            }
        }
        if (Long.compare(l2, i) <= 0) {
            obj4 = this.a.submit(kVar);
        } else {
            obj4 = this.a.schedule(kVar, l2, timeUnit3);
        }
        kVar.a(obj4);
        return kVar;
    }

    @Override // i.b.z$c
    public b f(Runnable runnable, long l2, TimeUnit timeUnit3) {
        Object obj4;
        j jVar = new j(a.w(runnable));
        if (Long.compare(l2, i) <= 0) {
            obj4 = this.a.submit(jVar);
        } else {
            obj4 = this.a.schedule(jVar, l2, timeUnit3);
        }
        jVar.a(obj4);
        return jVar;
    }

    @Override // i.b.z$c
    public b g(Runnable runnable, long l2, long l3, TimeUnit timeUnit4) {
        Object obj9;
        obj9 = a.w(runnable);
        int i = 0;
        if (Long.compare(timeUnit4, i) <= 0) {
            c obj12 = new c(obj9, this.a);
            if (Long.compare(l2, i) <= 0) {
                obj9 = this.a.submit(obj12);
            } else {
                obj9 = this.a.schedule(obj12, l2, l3);
            }
            obj12.b(obj9);
            return obj12;
        }
        i iVar2 = new i(obj9);
        iVar2.a(this.a.scheduleAtFixedRate(iVar2, l2, obj3, timeUnit4));
        return iVar2;
    }

    @Override // i.b.z$c
    public void h() {
        boolean z;
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
