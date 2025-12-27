package i.b.m0.d;

import i.b.d0;
import i.b.m0.a.c;
import io.reactivex.exceptions.CompositeException;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: BiConsumerSingleObserver.java */
/* loaded from: classes3.dex */
public final class d<T> extends AtomicReference<i.b.j0.b> implements d0<T>, i.b.j0.b {

    private static final long serialVersionUID = 4943102778943297569L;
    final i.b.l0.b<? super T, ? super Throwable> onCallback;
    public d(i.b.l0.b<? super T, ? super Throwable> bVar) {
        super();
        this.onCallback = bVar;
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
        try {
            lazySet(c.DISPOSED);
            Object obj = null;
            this.onCallback.a(obj, th);
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
    public void onSubscribe(i.b.j0.b bVar) {
        c.setOnce(this, bVar);
    }

    @Override // java.util.concurrent.atomic.AtomicReference
    public void onSuccess(T t) {
        try {
            lazySet(c.DISPOSED);
            this.onCallback.a(t, null);
        } catch (Throwable th) {
            a.b(th);
            a.t(th);
        }
    }
}
