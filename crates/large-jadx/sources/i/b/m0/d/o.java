package i.b.m0.d;

import i.b.j0.b;
import i.b.l0.f;
import i.b.l0.o;
import i.b.m0.a.c;
import i.b.y;
import io.reactivex.exceptions.CompositeException;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: ForEachWhileObserver.java */
/* loaded from: classes3.dex */
public final class o<T> extends AtomicReference<b> implements y<T>, b {

    private static final long serialVersionUID = -4403180040475402120L;
    boolean done;
    final i.b.l0.a onComplete;
    final f<? super Throwable> onError;
    final o<? super T> onNext;
    public o(o<? super T> oVar, f<? super Throwable> fVar, i.b.l0.a aVar) {
        super();
        this.onNext = oVar;
        this.onError = fVar;
        this.onComplete = aVar;
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
        if (this.done) {
            return;
        }
        this.done = true;
        try {
            this.onComplete.run();
        } catch (Throwable th) {
            a.b(th);
            a.t(th);
        }
    }

    @Override // java.util.concurrent.atomic.AtomicReference
    public void onError(Throwable th) {
        if (this.done) {
            a.t(th);
            return;
        }
        this.done = true;
        try {
            this.onError.accept(th);
        } catch (Throwable th) {
            a.b(th);
            int arr = 2;
            arr = new Throwable[arr];
            arr[0] = th;
            arr[i] = th;
            a.t(new CompositeException(arr));
        }
    }

    @Override // java.util.concurrent.atomic.AtomicReference
    public void onNext(T t) {
        if (this.done) {
            return;
        }
        try {
        } catch (Throwable th) {
            a.b(th);
            dispose();
            onError(th);
            return;
        }
        if (!this.onNext.test(t)) {
            dispose();
            onComplete();
        }
    }

    @Override // java.util.concurrent.atomic.AtomicReference
    public void onSubscribe(b bVar) {
        c.setOnce(this, bVar);
    }
}
