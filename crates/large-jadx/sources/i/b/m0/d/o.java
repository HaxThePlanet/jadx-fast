package i.b.m0.d;

import i.b.j0.b;
import i.b.l0.a;
import i.b.l0.f;
import i.b.l0.o;
import i.b.m0.a.c;
import i.b.p0.a;
import i.b.y;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.a;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes3.dex */
public final class o<T>  extends AtomicReference<b> implements y<T>, b {

    private static final long serialVersionUID = -4403180040475402120L;
    boolean done;
    final a onComplete;
    final f<? super Throwable> onError;
    final o<? super T> onNext;
    public o(o<? super T> o, f<? super Throwable> f2, a a3) {
        super();
        this.onNext = o;
        this.onError = f2;
        this.onComplete = a3;
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
        a onComplete;
        if (this.done) {
        }
        this.done = true;
        this.onComplete.run();
    }

    @Override // java.util.concurrent.atomic.AtomicReference
    public void onError(Throwable throwable) {
        f onError;
        CompositeException compositeException;
        int arr;
        int i;
        if (this.done) {
            a.t(throwable);
        }
        this.done = true;
        this.onError.accept(throwable);
    }

    public void onNext(T t) {
        if (this.done) {
        }
        if (!this.onNext.test(t)) {
            dispose();
            onComplete();
        }
    }

    @Override // java.util.concurrent.atomic.AtomicReference
    public void onSubscribe(b b) {
        c.setOnce(this, b);
    }
}
