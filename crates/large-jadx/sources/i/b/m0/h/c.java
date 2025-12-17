package i.b.m0.h;

import i.b.k;
import i.b.m0.c.f;
import i.b.m0.c.j;
import i.b.m0.i.g;
import i.b.m0.j.r;
import java.util.concurrent.atomic.AtomicReference;
import m.c.c;

/* loaded from: classes3.dex */
public final class c<T>  extends AtomicReference<c> implements k<T>, c {

    private static final long serialVersionUID = 22876611072430776L;
    volatile boolean done;
    int fusionMode;
    final int limit;
    final i.b.m0.h.d<T> parent;
    final int prefetch;
    long produced;
    volatile j<T> queue;
    public c(i.b.m0.h.d<T> d, int i2) {
        super();
        this.parent = d;
        this.prefetch = i2;
        this.limit = i2 -= obj1;
    }

    @Override // java.util.concurrent.atomic.AtomicReference
    public boolean a() {
        return this.done;
    }

    public j<T> b() {
        return this.queue;
    }

    @Override // java.util.concurrent.atomic.AtomicReference
    public void cancel() {
        g.cancel(this);
    }

    @Override // java.util.concurrent.atomic.AtomicReference
    public void d() {
        int fusionMode;
        int cmp;
        final int i = 1;
        if (this.fusionMode != i) {
            produced += i2;
            if (Long.compare(fusionMode, l) == 0) {
                this.produced = 0;
                (c)get().request(fusionMode);
            } else {
                this.produced = fusionMode;
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
    public void onError(Throwable throwable) {
        this.parent.e(this, throwable);
    }

    public void onNext(T t) {
        i.b.m0.h.d fusionMode;
        Object obj2;
        if (this.fusionMode == 0) {
            this.parent.d(this, t);
        } else {
            this.parent.a();
        }
    }

    @Override // java.util.concurrent.atomic.AtomicReference
    public void onSubscribe(c c) {
        boolean prefetch;
        boolean z;
        int requestFusion;
        int i;
        z = c;
        requestFusion = (g)z.requestFusion(3);
        int i3 = 1;
        if (g.setOnce(this, c) && c instanceof g && requestFusion == i3) {
            if (c instanceof g) {
                z = c;
                requestFusion = (g)z.requestFusion(3);
                i3 = 1;
                if (requestFusion == i3) {
                    this.fusionMode = requestFusion;
                    this.queue = z;
                    this.done = i3;
                    this.parent.b(this);
                }
                if (requestFusion == 2) {
                    this.fusionMode = requestFusion;
                    this.queue = z;
                    r.d(c, this.prefetch);
                }
            }
            this.queue = r.b(this.prefetch);
            r.d(c, this.prefetch);
        }
    }

    @Override // java.util.concurrent.atomic.AtomicReference
    public void request(long l) {
        int fusionMode;
        int obj3;
        final int i = 1;
        if (this.fusionMode != i) {
            produced += l;
            if (Long.compare(fusionMode, obj3) >= 0) {
                this.produced = 0;
                (c)get().request(fusionMode);
            } else {
                this.produced = fusionMode;
            }
        }
    }
}
