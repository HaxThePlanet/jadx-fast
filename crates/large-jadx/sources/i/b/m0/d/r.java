package i.b.m0.d;

import i.b.j0.b;
import i.b.m0.a.c;
import i.b.m0.c.f;
import i.b.m0.c.j;
import i.b.m0.j.r;
import i.b.y;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes3.dex */
public final class r<T>  extends AtomicReference<b> implements y<T>, b {

    private static final long serialVersionUID = -5417183359794346637L;
    volatile boolean done;
    int fusionMode;
    final i.b.m0.d.s<T> parent;
    final int prefetch;
    j<T> queue;
    public r(i.b.m0.d.s<T> s, int i2) {
        super();
        this.parent = s;
        this.prefetch = i2;
    }

    @Override // java.util.concurrent.atomic.AtomicReference
    public boolean a() {
        return this.done;
    }

    public j<T> b() {
        return this.queue;
    }

    @Override // java.util.concurrent.atomic.AtomicReference
    public void c() {
        this.done = true;
    }

    @Override // java.util.concurrent.atomic.AtomicReference
    public void dispose() {
        c.dispose(this);
    }

    @Override // java.util.concurrent.atomic.AtomicReference
    public boolean isDisposed() {
        return c.isDisposed((b)get());
    }

    @Override // java.util.concurrent.atomic.AtomicReference
    public void onComplete() {
        this.parent.c(this);
    }

    @Override // java.util.concurrent.atomic.AtomicReference
    public void onError(Throwable throwable) {
        this.parent.b(this, throwable);
    }

    public void onNext(T t) {
        i.b.m0.d.s fusionMode;
        Object obj2;
        if (this.fusionMode == 0) {
            this.parent.d(this, t);
        } else {
            this.parent.a();
        }
    }

    @Override // java.util.concurrent.atomic.AtomicReference
    public void onSubscribe(b b) {
        boolean requestFusion;
        int i;
        Object obj3;
        requestFusion = (e)b.requestFusion(3);
        int i3 = 1;
        if (c.setOnce(this, b) && b instanceof e && requestFusion == i3) {
            if (b instanceof e) {
                requestFusion = (e)b.requestFusion(3);
                i3 = 1;
                if (requestFusion == i3) {
                    this.fusionMode = requestFusion;
                    this.queue = b;
                    this.done = i3;
                    this.parent.c(this);
                }
                if (requestFusion == 2) {
                    this.fusionMode = requestFusion;
                    this.queue = b;
                }
            }
            this.queue = r.b(-obj3);
        }
    }
}
