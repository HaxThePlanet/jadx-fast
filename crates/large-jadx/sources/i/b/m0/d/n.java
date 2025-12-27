package i.b.m0.d;

import i.b.d;
import i.b.j0.b;
import i.b.m0.a.c;
import i.b.p0.a;
import io.reactivex.exceptions.OnErrorNotImplementedException;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: EmptyCompletableObserver.java */
/* loaded from: classes3.dex */
public final class n extends AtomicReference<b> implements d, b {

    private static final long serialVersionUID = -7545121636549663526L;
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
        lazySet(c.DISPOSED);
    }

    @Override // java.util.concurrent.atomic.AtomicReference
    public void onError(Throwable th) {
        lazySet(c.DISPOSED);
        a.t(new OnErrorNotImplementedException(th));
    }

    @Override // java.util.concurrent.atomic.AtomicReference
    public void onSubscribe(b bVar) {
        c.setOnce(this, bVar);
    }
}
