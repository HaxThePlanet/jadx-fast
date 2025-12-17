package i.b.m0.d;

import i.b.d0;
import i.b.j0.b;
import i.b.l0.f;
import i.b.m0.a.c;
import i.b.p0.a;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.a;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes3.dex */
public final class k<T>  extends AtomicReference<b> implements d0<T>, b {

    private static final long serialVersionUID = -7012088219455310787L;
    final f<? super Throwable> onError;
    final f<? super T> onSuccess;
    public k(f<? super T> f, f<? super Throwable> f2) {
        super();
        this.onSuccess = f;
        this.onError = f2;
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
