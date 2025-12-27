package i.b.m0.d;

import i.b.j0.b;
import i.b.l0.f;
import i.b.m0.a.c;
import i.b.y;
import io.reactivex.exceptions.CompositeException;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: LambdaObserver.java */
/* loaded from: classes3.dex */
public final class t<T> extends AtomicReference<b> implements y<T>, b {

    private static final long serialVersionUID = -7251123623727029452L;
    final i.b.l0.a onComplete;
    final f<? super Throwable> onError;
    final f<? super T> onNext;
    final f<? super b> onSubscribe;
    public t(f<? super T> fVar, f<? super Throwable> fVar2, i.b.l0.a aVar, f<? super b> fVar3) {
        super();
        this.onNext = fVar;
        this.onError = fVar2;
        this.onComplete = aVar;
        this.onSubscribe = fVar3;
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
    public void onComplete() {
        if (!isDisposed()) {
            lazySet(c.DISPOSED);
            try {
                this.onComplete.run();
            } catch (Throwable th) {
                a.b(th);
                a.t(th);
            }
        }
    }

    @Override // java.util.concurrent.atomic.AtomicReference
    public void onError(Throwable th) {
        if (!isDisposed()) {
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
        } else {
            a.t(th);
        }
    }

    @Override // java.util.concurrent.atomic.AtomicReference
    public void onNext(T t) {
        if (!isDisposed()) {
            try {
                this.onNext.accept(t);
            } catch (Throwable th) {
                a.b(th);
                (b)get().dispose();
                onError(th);
            }
        }
    }

    @Override // java.util.concurrent.atomic.AtomicReference
    public void onSubscribe(b bVar) {
        if (c.setOnce(this, bVar)) {
            try {
                this.onSubscribe.accept(this);
            } catch (Throwable th) {
                a.b(th);
                bVar.dispose();
                onError(th);
            }
        }
    }
}
