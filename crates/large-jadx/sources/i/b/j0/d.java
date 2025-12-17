package i.b.j0;

import i.b.m0.b.b;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes3.dex */
abstract class d<T>  extends AtomicReference<T> implements i.b.j0.b {

    private static final long serialVersionUID = 6537757548749041217L;
    d(T t) {
        b.e(t, "value is null");
        super(t);
    }

    protected abstract void a(T t);

    @Override // java.util.concurrent.atomic.AtomicReference
    public final void dispose() {
        Object andSet;
        andSet = getAndSet(0);
        if (get() != null && andSet != null) {
            andSet = getAndSet(0);
            if (andSet != null) {
                a(andSet);
            }
        }
    }

    @Override // java.util.concurrent.atomic.AtomicReference
    public final boolean isDisposed() {
        int i;
        i = get() == null ? 1 : 0;
        return i;
    }
}
