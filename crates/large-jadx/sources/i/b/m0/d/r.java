package i.b.m0.d;

import i.b.j0.b;
import i.b.m0.a.c;
import i.b.m0.c.f;
import i.b.m0.c.j;
import i.b.m0.j.r;
import i.b.y;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: InnerQueuedObserver.java */
/* loaded from: classes3.dex */
public final class r<T> extends AtomicReference<b> implements y<T>, b {

    private static final long serialVersionUID = -5417183359794346637L;
    volatile boolean done;
    int fusionMode;
    final s<T> parent;
    final int prefetch;
    j<T> queue;
    public r(s<T> sVar, int i) {
        super();
        this.parent = sVar;
        this.prefetch = i;
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
    public void onError(Throwable th) {
        this.parent.b(this, th);
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
    public void onSubscribe(b bVar) {
        boolean once;
        int i = 2;
        if (c.setOnce(this, bVar)) {
            once = bVar instanceof e;
            if (bVar instanceof e) {
                int requestFusion = bVar.requestFusion(3);
                int i3 = 1;
                if (requestFusion == i3) {
                    this.fusionMode = requestFusion;
                    this.queue = bVar;
                    this.done = true;
                    this.parent.c(this);
                    return;
                }
                i = 2;
                if (requestFusion == 2) {
                    this.fusionMode = requestFusion;
                    this.queue = bVar;
                    return;
                }
            }
            this.queue = r.b(-this.prefetch);
        }
    }
}
