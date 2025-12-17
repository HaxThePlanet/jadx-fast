package i.b.m0.e.e;

import i.b.j0.b;
import i.b.m0.a.c;
import i.b.y;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes3.dex */
public final class o4<T>  extends AtomicReference<b> implements y<T>, b {

    private static final long serialVersionUID = -8612022020200669122L;
    final y<? super T> downstream;
    final AtomicReference<b> upstream;
    public o4(y<? super T> y) {
        super();
        AtomicReference atomicReference = new AtomicReference();
        this.upstream = atomicReference;
        this.downstream = y;
    }

    @Override // java.util.concurrent.atomic.AtomicReference
    public void a(b b) {
        c.set(this, b);
    }

    @Override // java.util.concurrent.atomic.AtomicReference
    public void dispose() {
        c.dispose(this.upstream);
        c.dispose(this);
    }

    @Override // java.util.concurrent.atomic.AtomicReference
    public boolean isDisposed() {
        int i;
        i = this.upstream.get() == c.DISPOSED ? 1 : 0;
        return i;
    }

    @Override // java.util.concurrent.atomic.AtomicReference
    public void onComplete() {
        dispose();
        this.downstream.onComplete();
    }

    @Override // java.util.concurrent.atomic.AtomicReference
    public void onError(Throwable throwable) {
        dispose();
        this.downstream.onError(throwable);
    }

    public void onNext(T t) {
        this.downstream.onNext(t);
    }

    @Override // java.util.concurrent.atomic.AtomicReference
    public void onSubscribe(b b) {
        boolean obj2;
        if (c.setOnce(this.upstream, b)) {
            this.downstream.onSubscribe(this);
        }
    }
}
