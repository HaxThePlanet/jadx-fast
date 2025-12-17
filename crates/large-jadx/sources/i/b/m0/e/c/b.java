package i.b.m0.e.c;

import i.b.j0.b;
import i.b.l0.a;
import i.b.l0.f;
import i.b.m0.a.c;
import i.b.n;
import i.b.p0.a;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.a;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes3.dex */
public final class b<T>  extends AtomicReference<b> implements n<T>, b {

    private static final long serialVersionUID = -6076952298809384986L;
    final a onComplete;
    final f<? super Throwable> onError;
    final f<? super T> onSuccess;
    public b(f<? super T> f, f<? super Throwable> f2, a a3) {
        super();
        this.onSuccess = f;
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
        lazySet(c.DISPOSED);
        this.onComplete.run();
    }

    @Override // java.util.concurrent.atomic.AtomicReference
    public void onError(Throwable throwable) {
        f onError;
        CompositeException compositeException;
        int arr;
        int i;
        Object obj5;
        lazySet(c.DISPOSED);
        this.onError.accept(throwable);
    }

    @Override // java.util.concurrent.atomic.AtomicReference
    public void onSubscribe(b b) {
        c.setOnce(this, b);
    }

    public void onSuccess(T t) {
        Object obj2;
        lazySet(c.DISPOSED);
        this.onSuccess.accept(t);
    }
}
