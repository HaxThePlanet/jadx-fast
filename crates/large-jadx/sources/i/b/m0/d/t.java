package i.b.m0.d;

import i.b.j0.b;
import i.b.l0.a;
import i.b.l0.f;
import i.b.m0.a.c;
import i.b.p0.a;
import i.b.y;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.a;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes3.dex */
public final class t<T>  extends AtomicReference<b> implements y<T>, b {

    private static final long serialVersionUID = -7251123623727029452L;
    final a onComplete;
    final f<? super Throwable> onError;
    final f<? super T> onNext;
    final f<? super b> onSubscribe;
    public t(f<? super T> f, f<? super Throwable> f2, a a3, f<? super b> f4) {
        super();
        this.onNext = f;
        this.onError = f2;
        this.onComplete = a3;
        this.onSubscribe = f4;
    }

    @Override // java.util.concurrent.atomic.AtomicReference
    public void dispose() {
        c.dispose(this);
    }

    @Override // java.util.concurrent.atomic.AtomicReference
    public boolean isDisposed() {
        int i;
        i = get() == c.DISPOSED ? 1 : 0;
        return i;
    }

    @Override // java.util.concurrent.atomic.AtomicReference
    public void onComplete() {
        boolean onComplete;
        if (!isDisposed()) {
            lazySet(c.DISPOSED);
            this.onComplete.run();
        }
    }

    @Override // java.util.concurrent.atomic.AtomicReference
    public void onError(Throwable throwable) {
        boolean onError;
        CompositeException compositeException;
        int arr;
        int i;
        Object obj5;
        if (!isDisposed()) {
            lazySet(c.DISPOSED);
            this.onError.accept(throwable);
        } else {
            a.t(throwable);
        }
    }

    public void onNext(T t) {
        boolean onNext;
        Object obj2;
        if (!isDisposed()) {
            this.onNext.accept(t);
        }
    }

    @Override // java.util.concurrent.atomic.AtomicReference
    public void onSubscribe(b b) {
        boolean onSubscribe;
        if (c.setOnce(this, b)) {
            this.onSubscribe.accept(this);
        }
    }
}
