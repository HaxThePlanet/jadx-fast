package i.b.j0;

import i.b.m0.b.b;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: ReferenceDisposable.java */
/* loaded from: classes3.dex */
abstract class d<T> extends AtomicReference<T> implements b {

    private static final long serialVersionUID = 6537757548749041217L;
    d(T t) {
        b.e(t, "value is null");
        super(t);
    }

    @Override // java.util.concurrent.atomic.AtomicReference
    public final void dispose() {
        if (get() != null) {
            Object andSet = getAndSet(null);
            if (andSet != null) {
                a(andSet);
            }
        }
    }

    @Override // java.util.concurrent.atomic.AtomicReference
    public final boolean isDisposed() {
        boolean z = true;
        int r0 = get() == null ? 1 : 0;
        return (get() == null ? 1 : 0);
    }

    @Override // java.util.concurrent.atomic.AtomicReference
    protected abstract void a(T t);
}
