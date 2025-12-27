package i.b.m0.d;

import i.b.d0;
import i.b.j0.b;
import i.b.l0.f;
import i.b.m0.a.c;
import io.reactivex.exceptions.CompositeException;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: ConsumerSingleObserver.java */
/* loaded from: classes3.dex */
public final class k<T> extends AtomicReference<b> implements d0<T>, b {

    private static final long serialVersionUID = -7012088219455310787L;
    final f<? super Throwable> onError;
    final f<? super T> onSuccess;
    public k(f<? super T> fVar, f<? super Throwable> fVar2) {
        super();
        this.onSuccess = fVar;
        this.onError = fVar2;
    }

    @Override // java.util.concurrent.atomic.AtomicReference
    public void dispose() {
        c.dispose(this);
    }

    @Override // java.util.concurrent.atomic.AtomicReference
    public boolean isDisposed() {
        boolean z = true;
        int r0 = get() == c.DISPOSED ? 1 : 0;
        return (get() == c.DISPOSED ? 1 : 0);
    }

    @Override // java.util.concurrent.atomic.AtomicReference
    public void onError(Throwable th) {
        lazySet(c.DISPOSED);
        try {
            this.onError.accept(th);
        } catch (Throwable th) {
            a.b(th);
            int arr = 2;
            arr = new Throwable[arr];
            arr[0] = th;
            th = 1;
            arr[th] = th;
            a.t(new CompositeException(arr));
        }
    }

    @Override // java.util.concurrent.atomic.AtomicReference
    public void onSubscribe(b bVar) {
        c.setOnce(this, bVar);
    }

    @Override // java.util.concurrent.atomic.AtomicReference
    public void onSuccess(T t) {
        lazySet(c.DISPOSED);
        try {
            this.onSuccess.accept(t);
        } catch (Throwable th) {
            a.b(th);
            a.t(th);
        }
    }
}
