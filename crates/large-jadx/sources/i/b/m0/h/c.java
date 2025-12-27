package i.b.m0.h;

import i.b.k;
import i.b.m0.c.f;
import i.b.m0.c.j;
import i.b.m0.i.g;
import i.b.m0.j.r;
import java.util.concurrent.atomic.AtomicReference;
import m.c.c;

/* compiled from: InnerQueuedSubscriber.java */
/* loaded from: classes3.dex */
public final class c<T> extends AtomicReference<c> implements k<T>, c {

    private static final long serialVersionUID = 22876611072430776L;
    volatile boolean done;
    int fusionMode;
    final int limit;
    final d<T> parent;
    final int prefetch;
    long produced;
    volatile j<T> queue;
    public c(d<T> dVar, int i) {
        super();
        this.parent = dVar;
        this.prefetch = i;
        this.limit = i - (i >> 2);
    }

    @Override // java.util.concurrent.atomic.AtomicReference
    public boolean a() {
        return this.done;
    }

    @Override // java.util.concurrent.atomic.AtomicReference
    public j<T> b() {
        return this.queue;
    }

    @Override // java.util.concurrent.atomic.AtomicReference
    public void cancel() {
        g.cancel(this);
    }

    @Override // java.util.concurrent.atomic.AtomicReference
    public void d() {
        final int i = 1;
        if (this.fusionMode != i) {
            long l2 = (long)this.limit;
            if (this.fusionMode == this.limit) {
                this.produced = 0L;
                (c)get().request(l);
            } else {
                this.produced++;
            }
        }
    }

    @Override // java.util.concurrent.atomic.AtomicReference
    public void e() {
        this.done = true;
    }

    @Override // java.util.concurrent.atomic.AtomicReference
    public void onComplete() {
        this.parent.b(this);
    }

    @Override // java.util.concurrent.atomic.AtomicReference
    public void onError(Throwable th) {
        this.parent.e(this, th);
    }

    @Override // java.util.concurrent.atomic.AtomicReference
    public void onNext(T t) {
        if (this.fusionMode == 0) {
            this.parent.d(this, t);
        } else {
            this.parent.a();
        }
    }

    @Override // java.util.concurrent.atomic.AtomicReference
    public void onSubscribe(c cVar) {
        int requestFusion;
        int i = 2;
        if (g.setOnce(this, cVar)) {
            z = cVar instanceof g;
            if (cVar instanceof g) {
                c cVar2 = cVar;
                requestFusion = cVar2.requestFusion(3);
                int i3 = 1;
                if (requestFusion == i3) {
                    this.fusionMode = requestFusion;
                    this.queue = cVar2;
                    this.done = true;
                    this.parent.b(this);
                    return;
                }
                i = 2;
                if (requestFusion == 2) {
                    this.fusionMode = requestFusion;
                    this.queue = cVar2;
                    r.d(cVar, this.prefetch);
                    return;
                }
            }
            this.queue = r.b(this.prefetch);
            r.d(cVar, this.prefetch);
        }
    }

    @Override // java.util.concurrent.atomic.AtomicReference
    public void request(long j) {
        final int i = 1;
        if (this.fusionMode != i) {
            long l2 = (long)this.limit;
            if (this.produced >= this.limit) {
                this.produced = 0L;
                (c)get().request(l);
            } else {
                this.produced += j;
            }
        }
    }
}
