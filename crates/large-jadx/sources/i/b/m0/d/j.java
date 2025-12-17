package i.b.m0.d;

import i.b.d;
import i.b.j0.b;
import i.b.l0.a;
import i.b.l0.f;
import i.b.m0.a.c;
import i.b.p0.a;
import io.reactivex.exceptions.OnErrorNotImplementedException;
import io.reactivex.exceptions.a;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes3.dex */
public final class j extends AtomicReference<b> implements d, b, f<Throwable> {

    private static final long serialVersionUID = -4361286194466301354L;
    final a onComplete;
    final f<? super Throwable> onError;
    public j(a a) {
        super();
        this.onError = this;
        this.onComplete = a;
    }

    public j(f<? super Throwable> f, a a2) {
        super();
        this.onError = f;
        this.onComplete = a2;
    }

    @Override // java.util.concurrent.atomic.AtomicReference
    public void a(Throwable throwable) {
        OnErrorNotImplementedException onErrorNotImplementedException = new OnErrorNotImplementedException(throwable);
        a.t(onErrorNotImplementedException);
    }

    @Override // java.util.concurrent.atomic.AtomicReference
    public void accept(Object object) {
        a((Throwable)object);
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
        a onComplete;
        try {
            this.onComplete.run();
            a.b(th);
            a.t(th);
            lazySet(c.DISPOSED);
        }
    }

    @Override // java.util.concurrent.atomic.AtomicReference
    public void onError(Throwable throwable) {
        Object obj2;
        try {
            this.onError.accept(throwable);
            a.b(throwable);
            a.t(throwable);
            lazySet(c.DISPOSED);
        }
    }

    @Override // java.util.concurrent.atomic.AtomicReference
    public void onSubscribe(b b) {
        c.setOnce(this, b);
    }
}
