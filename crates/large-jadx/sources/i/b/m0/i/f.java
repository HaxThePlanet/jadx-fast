package i.b.m0.i;

import i.b.m0.b.b;
import i.b.m0.j.d;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import m.c.c;

/* loaded from: classes3.dex */
public class f extends AtomicInteger implements c {

    private static final long serialVersionUID = -2189523197179400958L;
    c actual;
    final boolean cancelOnReplace;
    volatile boolean cancelled;
    final AtomicLong missedProduced;
    final AtomicLong missedRequested;
    final AtomicReference<c> missedSubscription;
    long requested;
    protected boolean unbounded;
    public f(boolean z) {
        super();
        this.cancelOnReplace = z;
        AtomicReference obj1 = new AtomicReference();
        this.missedSubscription = obj1;
        obj1 = new AtomicLong();
        this.missedRequested = obj1;
        obj1 = new AtomicLong();
        this.missedProduced = obj1;
    }

    @Override // java.util.concurrent.atomic.AtomicInteger
    final void a() {
        if (getAndIncrement() != 0) {
        }
        b();
    }

    @Override // java.util.concurrent.atomic.AtomicInteger
    final void b() {
        int andGet;
        int i2;
        int i;
        Object andSet;
        int cancelOnReplace;
        long andSet2;
        c actual;
        long cancelled;
        long cmp2;
        int cmp;
        final Object obj = this;
        int i3 = 0;
        final int i4 = 0;
        andGet = 1;
        i = i3;
        i2 = i4;
        do {
            if (Long.compare(cancelOnReplace, i4) != 0) {
            }
            if (Long.compare(andSet2, i4) != 0) {
            }
            actual = obj.actual;
            if (obj.cancelled) {
            } else {
            }
            cancelled = obj.requested;
            cmp2 = Long.MAX_VALUE;
            cancelled = d.c(cancelled, obj15);
            cancelled -= andSet2;
            if (Long.compare(cancelled, cmp2) != 0 && Long.compare(cancelled, cmp2) != 0 && Long.compare(cancelled, i4) < 0) {
            }
            if (andSet != null) {
            } else {
            }
            if (actual != null && Long.compare(cancelOnReplace, i4) != 0) {
            }
            if (obj.addAndGet(-andGet) != 0) {
            }
            if (Long.compare(cancelOnReplace, i4) != 0) {
            }
            i2 = d.c(i2, obj6);
            i = actual;
            if (actual != null && obj.cancelOnReplace) {
            }
            obj.actual = andSet;
            if (Long.compare(cancelled, i4) != 0) {
            }
            i2 = d.c(i2, obj6);
            i = andSet;
            if (obj.cancelOnReplace) {
            }
            actual.cancel();
            cancelled = d.c(cancelled, obj15);
            if (Long.compare(cancelled, cmp2) != 0) {
            }
            obj.requested = cancelled;
            cancelled -= andSet2;
            if (Long.compare(cancelled, i4) < 0) {
            }
            g.reportMoreProduced(cancelled);
            cancelled = i4;
            if (actual != null) {
            }
            if (andSet != null) {
            }
            andSet.cancel();
            actual.cancel();
            obj.actual = i3;
            andSet2 = obj.missedProduced.getAndSet(i4);
            cancelOnReplace = obj.missedRequested.getAndSet(i4);
            andSet = obj.missedSubscription.getAndSet(i3);
        } while ((c)obj.missedSubscription.get() != null);
        if (Long.compare(i2, i4) != 0) {
            i.request(i2);
        }
    }

    @Override // java.util.concurrent.atomic.AtomicInteger
    public void cancel() {
        boolean cancelled;
        if (!this.cancelled) {
            this.cancelled = true;
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
    public final void f(long l) {
        int compareAndSet;
        int requested;
        int i;
        int cmp;
        int obj5;
        if (this.unbounded) {
        }
        i = 1;
        requested = this.requested;
        requested -= l;
        obj5 = 0;
        if (get() == 0 && compareAndSet(0, i) && Long.compare(requested, l2) != 0 && Long.compare(requested, obj5) < 0) {
            i = 1;
            if (compareAndSet(0, i)) {
                requested = this.requested;
                if (Long.compare(requested, l2) != 0) {
                    requested -= l;
                    obj5 = 0;
                    if (Long.compare(requested, obj5) < 0) {
                        g.reportMoreProduced(requested);
                        requested = obj5;
                    }
                    this.requested = requested;
                }
                if (decrementAndGet() == 0) {
                }
                b();
            }
        }
        d.a(this.missedProduced, l);
        a();
    }

    @Override // java.util.concurrent.atomic.AtomicInteger
    public final void g(c c) {
        int compareAndSet;
        AtomicReference missedSubscription;
        int cancelOnReplace;
        if (this.cancelled) {
            c.cancel();
        }
        b.e(c, "s is null");
        c actual = this.actual;
        if (get() == 0 && compareAndSet(0, 1) && actual != null && this.cancelOnReplace) {
            if (compareAndSet(0, 1)) {
                actual = this.actual;
                if (actual != null) {
                    if (this.cancelOnReplace) {
                        actual.cancel();
                    }
                }
                this.actual = c;
                long requested = this.requested;
                if (decrementAndGet() != 0) {
                    b();
                }
                if (Long.compare(requested, i2) != 0) {
                    c.request(requested);
                }
            }
        }
        final Object obj5 = this.missedSubscription.getAndSet(c);
        if ((c)obj5 != null && this.cancelOnReplace) {
            if (this.cancelOnReplace) {
                (c)obj5.cancel();
            }
        }
        a();
    }

    @Override // java.util.concurrent.atomic.AtomicInteger
    public final void request(long l) {
        boolean missedRequested;
        int cmp;
        int compareAndSet;
        int i;
        long requested;
        if (g.validate(l) && this.unbounded) {
            if (this.unbounded) {
            }
            i = 1;
            requested = this.requested;
            final long l2 = Long.MAX_VALUE;
            requested = d.c(requested, obj3);
            this.requested = requested;
            if (get() == 0 && compareAndSet(0, i) && Long.compare(requested, l2) != 0 && Long.compare(requested, l2) == 0) {
                i = 1;
                if (compareAndSet(0, i)) {
                    requested = this.requested;
                    l2 = Long.MAX_VALUE;
                    if (Long.compare(requested, l2) != 0) {
                        requested = d.c(requested, obj3);
                        this.requested = requested;
                        if (Long.compare(requested, l2) == 0) {
                            this.unbounded = i;
                        }
                    }
                    c actual = this.actual;
                    if (decrementAndGet() != 0) {
                        b();
                    }
                    if (actual != null) {
                        actual.request(l);
                    }
                }
            }
            d.a(this.missedRequested, l);
            a();
        }
    }
}
