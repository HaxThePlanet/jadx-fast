package i.b.m0.i;

import i.b.m0.b.b;
import i.b.m0.j.d;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import m.c.c;

/* compiled from: SubscriptionArbiter.java */
/* loaded from: classes3.dex */
public class f extends AtomicInteger implements c {

    private static final long serialVersionUID = -2189523197179400958L;
    c actual;
    final boolean cancelOnReplace;
    volatile boolean cancelled;
    final AtomicLong missedProduced = new AtomicLong();
    final AtomicLong missedRequested = new AtomicLong();
    final AtomicReference<c> missedSubscription = new AtomicReference<>();
    long requested;
    protected boolean unbounded;
    public f(boolean z) {
        super();
        this.cancelOnReplace = z;
        AtomicReference atomicReference = new AtomicReference();
        AtomicLong atomicLong = new AtomicLong();
        AtomicLong atomicLong2 = new AtomicLong();
    }

    @Override // java.util.concurrent.atomic.AtomicInteger
    final void a() {
        if (getAndIncrement() != 0) {
            return;
        }
        b();
    }

    @Override // java.util.concurrent.atomic.AtomicInteger
    final void b() {
        int andGet = 1;
        int i;
        int i2;
        Object andSet;
        long andSet2;
        int cmp;
        long andSet3;
        long requested2;
        long l;
        int cmp2;
        final Object obj = this;
        Object obj2 = null;
        requested2 = 0L;
        andGet = 1;
        i2 = obj2;
        i = requested2;
        do {
            andSet2 = obj.missedRequested.get();
            andSet3 = obj.missedProduced.get();
            andSet = obj.missedSubscription.getAndSet(obj2);
        } while ((c)obj.missedSubscription.get() != null);
        if (i != requested2) {
            i2.request(i);
        }
    }

    @Override // java.util.concurrent.atomic.AtomicInteger
    public void cancel() {
        if (!this.cancelled) {
            boolean cancelled2 = true;
            this.cancelled = cancelled2;
            a();
        }
    }

    @Override // java.util.concurrent.atomic.AtomicInteger
    public final boolean d() {
        return this.cancelled;
    }

    @Override // java.util.concurrent.atomic.AtomicInteger
    public final boolean e() {
        return this.unbounded;
    }

    @Override // java.util.concurrent.atomic.AtomicInteger
    public final void f(long j) {
        long j2;
        if (this.unbounded) {
            return;
        }
        if (get() == 0) {
            int i2 = 1;
            if (compareAndSet(0, i2)) {
                if (this.requested != 9223372036854775807L) {
                    j2 = j2 - j;
                    j2 = 0L;
                    if (this.unbounded < j2) {
                        g.reportMoreProduced(j2);
                    }
                    this.requested = j2;
                }
                if (decrementAndGet() == 0) {
                    return;
                }
                b();
                return;
            }
        }
        d.a(this.missedProduced, j);
        a();
    }

    @Override // java.util.concurrent.atomic.AtomicInteger
    public final void g(c cVar) {
        int i2 = 1;
        if (this.cancelled) {
            cVar.cancel();
            return;
        }
        b.e(cVar, "s is null");
        if (get() == 0 && this.compareAndSet(0, 1) && this.actual != null && this.cancelOnReplace) {
            this.actual.cancel();
            this.actual = cVar;
            if (decrementAndGet() != 0) {
                b();
            }
            if (this.requested != 0) {
                cVar.request(this.requested);
            }
            return;
        }
        final Object andSet = this.missedSubscription.getAndSet(cVar);
        if (andSet != null && this.cancelOnReplace) {
            andSet.cancel();
        }
        a();
    }

    @Override // java.util.concurrent.atomic.AtomicInteger
    public final void request(long j) {
        int i2 = 1;
        if (g.validate(j) && this.unbounded) {
            return;
        }
    }
}
