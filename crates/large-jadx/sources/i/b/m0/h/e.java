package i.b.m0.h;

import i.b.j0.b;
import i.b.k;
import i.b.l0.f;
import i.b.m0.i.g;
import io.reactivex.exceptions.CompositeException;
import java.util.concurrent.atomic.AtomicReference;
import m.c.c;

/* compiled from: LambdaSubscriber.java */
/* loaded from: classes3.dex */
public final class e<T> extends AtomicReference<c> implements k<T>, c, b {

    private static final long serialVersionUID = -7251123623727029452L;
    final i.b.l0.a onComplete;
    final f<? super Throwable> onError;
    final f<? super T> onNext;
    final f<? super c> onSubscribe;
    public e(f<? super T> fVar, f<? super Throwable> fVar2, i.b.l0.a aVar, f<? super c> fVar3) {
        super();
        this.onNext = fVar;
        this.onError = fVar2;
        this.onComplete = aVar;
        this.onSubscribe = fVar3;
    }

    @Override // java.util.concurrent.atomic.AtomicReference
    public void cancel() {
        g.cancel(this);
    }

    @Override // java.util.concurrent.atomic.AtomicReference
    public void dispose() {
        cancel();
    }

    @Override // java.util.concurrent.atomic.AtomicReference
    public boolean isDisposed() {
        boolean z = true;
        int r0 = get() == g.CANCELLED ? 1 : 0;
        return (get() == g.CANCELLED ? 1 : 0);
    }

    @Override // java.util.concurrent.atomic.AtomicReference
    public void onComplete() {
        final g cANCELLED2 = g.CANCELLED;
        if (get() != g.CANCELLED) {
            lazySet(g.CANCELLED);
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
        cANCELLED2 = g.CANCELLED;
        if (get() != g.CANCELLED) {
            lazySet(g.CANCELLED);
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
                (c)get().cancel();
                onError(th);
            }
        }
    }

    @Override // java.util.concurrent.atomic.AtomicReference
    public void onSubscribe(c cVar) {
        if (g.setOnce(this, cVar)) {
            try {
                this.onSubscribe.accept(this);
            } catch (Throwable th) {
                a.b(th);
                cVar.cancel();
                onError(th);
            }
        }
    }

    @Override // java.util.concurrent.atomic.AtomicReference
    public void request(long j) {
        (c)get().request(j);
    }
}
