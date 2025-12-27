package i.b.m0.d;

import i.b.d;
import i.b.j0.b;
import i.b.l0.f;
import i.b.m0.a.c;
import io.reactivex.exceptions.OnErrorNotImplementedException;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: CallbackCompletableObserver.java */
/* loaded from: classes3.dex */
public final class j extends AtomicReference<b> implements d, b, f<Throwable> {

    private static final long serialVersionUID = -4361286194466301354L;
    final i.b.l0.a onComplete;
    final f<? super Throwable> onError;
    public j(i.b.l0.a aVar) {
        super();
        this.onError = this;
        this.onComplete = aVar;
    }

    @Override // java.util.concurrent.atomic.AtomicReference
    public void a(Throwable th) {
        a.t(new OnErrorNotImplementedException(th));
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
        try {
            this.onComplete.run();
        } catch (Throwable th) {
            a.b(th);
            a.t(th);
        }
        lazySet(c.DISPOSED);
    }

    @Override // java.util.concurrent.atomic.AtomicReference
    public void onError(Throwable th) {
        try {
            this.onError.accept(th);
        } catch (Throwable th) {
            a.b(th);
            a.t(th);
        }
        lazySet(c.DISPOSED);
    }

    @Override // java.util.concurrent.atomic.AtomicReference
    public void onSubscribe(b bVar) {
        c.setOnce(this, bVar);
    }

    public j(f<? super Throwable> fVar, i.b.l0.a aVar) {
        super();
        this.onError = fVar;
        this.onComplete = aVar;
    }
}
