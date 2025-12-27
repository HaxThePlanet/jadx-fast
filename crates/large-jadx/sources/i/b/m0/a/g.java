package i.b.m0.a;

import i.b.j0.b;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: SequentialDisposable.java */
/* loaded from: classes3.dex */
public final class g extends AtomicReference<b> implements b {

    private static final long serialVersionUID = -754898800686245608L;
    @Override // java.util.concurrent.atomic.AtomicReference
    public boolean a(b bVar) {
        return c.replace(this, bVar);
    }

    @Override // java.util.concurrent.atomic.AtomicReference
    public boolean b(b bVar) {
        return c.set(this, bVar);
    }

    @Override // java.util.concurrent.atomic.AtomicReference
    public void dispose() {
        c.dispose(this);
    }

    @Override // java.util.concurrent.atomic.AtomicReference
    public boolean isDisposed() {
        return c.isDisposed((b)get());
    }

    public g(b bVar) {
        super();
        lazySet(bVar);
    }
}
