package i.b.m0.g;

import i.b.j0.a;
import i.b.j0.b;
import i.b.m0.a.d;
import i.b.p0.a;
import i.b.z;
import i.b.z.c;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes3.dex */
public final class m extends z {

    static final i.b.m0.g.h c;
    static final ScheduledExecutorService d;
    final AtomicReference<ScheduledExecutorService> b;

    static final class a extends z.c {

        final ScheduledExecutorService a;
        final a b;
        volatile boolean c;
        a(ScheduledExecutorService scheduledExecutorService) {
            super();
            this.a = scheduledExecutorService;
            a obj1 = new a();
            this.b = obj1;
        }

        @Override // i.b.z$c
        public b c(Runnable runnable, long l2, TimeUnit timeUnit3) {
            Object obj4;
            if (this.c) {
                return d.INSTANCE;
            }
            k kVar = new k(a.w(runnable), this.b);
            this.b.b(kVar);
            if (Long.compare(l2, i) <= 0) {
                obj4 = this.a.submit(kVar);
            } else {
                obj4 = this.a.schedule(kVar, l2, timeUnit3);
            }
            kVar.a(obj4);
            return kVar;
        }

        @Override // i.b.z$c
        public void dispose() {
            boolean z;
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
        int i6 = 1;
        h hVar = new h("RxSingleScheduler", Math.max(i6, Math.min(10, Integer.getInteger("rx2.single-priority", 5).intValue())), i6);
        m.c = hVar;
    }

    public m() {
        super(m.c);
    }

    public m(ThreadFactory threadFactory) {
        super();
        AtomicReference atomicReference = new AtomicReference();
        this.b = atomicReference;
        atomicReference.lazySet(m.f(threadFactory));
    }

    static ScheduledExecutorService f(ThreadFactory threadFactory) {
        return l.a(threadFactory);
    }

    @Override // i.b.z
    public z.c a() {
        m.a aVar = new m.a((ScheduledExecutorService)this.b.get());
        return aVar;
    }

    @Override // i.b.z
    public b d(Runnable runnable, long l2, TimeUnit timeUnit3) {
        Object obj4;
        j jVar = new j(a.w(runnable));
        if (Long.compare(l2, i) <= 0) {
            obj4 = (ScheduledExecutorService)this.b.get().submit(jVar);
        } else {
            obj4 = (ScheduledExecutorService)this.b.get().schedule(jVar, l2, timeUnit3);
        }
        jVar.a(obj4);
        return jVar;
    }

    @Override // i.b.z
    public b e(Runnable runnable, long l2, long l3, TimeUnit timeUnit4) {
        Object obj9;
        obj9 = a.w(runnable);
        int i = 0;
        if (Long.compare(timeUnit4, i) <= 0) {
            Object obj12 = this.b.get();
            c obj13 = new c(obj9, (ScheduledExecutorService)obj12);
            if (Long.compare(l2, i) <= 0) {
                obj9 = obj12.submit(obj13);
            } else {
                obj9 = obj12.schedule(obj13, l2, l3);
            }
            obj13.b(obj9);
            return obj13;
        }
        i iVar2 = new i(obj9);
        iVar2.a((ScheduledExecutorService)this.b.get().scheduleAtFixedRate(iVar2, l2, obj3, timeUnit4));
        return iVar2;
    }
}
