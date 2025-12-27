package i.b.m0.e.c;

import i.b.j0.b;
import i.b.l0.f;
import i.b.m0.a.c;
import i.b.n;
import io.reactivex.exceptions.CompositeException;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: MaybeCallbackObserver.java */
/* loaded from: classes3.dex */
public final class b<T> extends AtomicReference<b> implements n<T>, b {

    private static final long serialVersionUID = -6076952298809384986L;
    final i.b.l0.a onComplete;
    final f<? super Throwable> onError;
    final f<? super T> onSuccess;
    public b(f<? super T> fVar, f<? super Throwable> fVar2, i.b.l0.a aVar) {
        super();
        this.onSuccess = fVar;
        this.onError = fVar2;
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
        lazySet(c.DISPOSED);
        try {
            this.onComplete.run();
        } catch (Throwable th) {
            a.b(th);
            a.t(th);
        }
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
