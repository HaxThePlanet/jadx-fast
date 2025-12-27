package i.b.m0.e.e;

import i.b.j0.b;
import i.b.m0.a.c;
import i.b.y;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: ObserverResourceWrapper.java */
/* loaded from: classes3.dex */
public final class o4<T> extends AtomicReference<b> implements y<T>, b {

    private static final long serialVersionUID = -8612022020200669122L;
    final y<? super T> downstream;
    final AtomicReference<b> upstream = new AtomicReference<>();
    public o4(y<? super T> yVar) {
        super();
        final AtomicReference atomicReference = new AtomicReference();
        this.downstream = yVar;
    }

    @Override // java.util.concurrent.atomic.AtomicReference
    public void a(b bVar) {
        c.set(this, bVar);
    }

    @Override // java.util.concurrent.atomic.AtomicReference
    public void dispose() {
        c.dispose(this.upstream);
        c.dispose(this);
    }

    @Override // java.util.concurrent.atomic.AtomicReference
    public boolean isDisposed() {
        boolean z = true;
        int r0 = this.upstream.get() == c.DISPOSED ? 1 : 0;
        return (this.upstream.get() == c.DISPOSED ? 1 : 0);
    }

    @Override // java.util.concurrent.atomic.AtomicReference
    public void onComplete() {
        dispose();
        this.downstream.onComplete();
    }

    @Override // java.util.concurrent.atomic.AtomicReference
    public void onError(Throwable th) {
        dispose();
        this.downstream.onError(th);
    }

    @Override // java.util.concurrent.atomic.AtomicReference
    public void onNext(T t) {
        this.downstream.onNext(t);
    }

    @Override // java.util.concurrent.atomic.AtomicReference
    public void onSubscribe(b bVar) {
        if (c.setOnce(this.upstream, bVar)) {
            this.downstream.onSubscribe(this);
        }
    }
}
