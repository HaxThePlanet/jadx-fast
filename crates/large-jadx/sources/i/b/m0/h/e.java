package i.b.m0.h;

import i.b.j0.b;
import i.b.k;
import i.b.l0.a;
import i.b.l0.f;
import i.b.m0.i.g;
import i.b.p0.a;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.a;
import java.util.concurrent.atomic.AtomicReference;
import m.c.c;

/* loaded from: classes3.dex */
public final class e<T>  extends AtomicReference<c> implements k<T>, c, b {

    private static final long serialVersionUID = -7251123623727029452L;
    final a onComplete;
    final f<? super Throwable> onError;
    final f<? super T> onNext;
    final f<? super c> onSubscribe;
    public e(f<? super T> f, f<? super Throwable> f2, a a3, f<? super c> f4) {
        super();
        this.onNext = f;
        this.onError = f2;
        this.onComplete = a3;
        this.onSubscribe = f4;
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
        int i;
        i = get() == g.CANCELLED ? 1 : 0;
        return i;
    }

    @Override // java.util.concurrent.atomic.AtomicReference
    public void onComplete() {
        Object onComplete;
        final g cANCELLED = g.CANCELLED;
        if (get() != cANCELLED) {
            lazySet(cANCELLED);
            this.onComplete.run();
        }
    }

    @Override // java.util.concurrent.atomic.AtomicReference
    public void onError(Throwable throwable) {
        Object onError;
        g cANCELLED;
        int arr;
        int i;
        Object obj5;
        cANCELLED = g.CANCELLED;
        if (get() != cANCELLED) {
            lazySet(cANCELLED);
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
    public void onSubscribe(c c) {
        boolean onSubscribe;
        if (g.setOnce(this, c)) {
            this.onSubscribe.accept(this);
        }
    }

    @Override // java.util.concurrent.atomic.AtomicReference
    public void request(long l) {
        (c)get().request(l);
    }
}
