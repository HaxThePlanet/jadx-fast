package i.b.m0.a;

import i.b.j0.b;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes3.dex */
public final class g extends AtomicReference<b> implements b {

    private static final long serialVersionUID = -754898800686245608L;
    public g(b b) {
        super();
        lazySet(b);
    }

    @Override // java.util.concurrent.atomic.AtomicReference
    public boolean a(b b) {
        return c.replace(this, b);
    }

    @Override // java.util.concurrent.atomic.AtomicReference
    public boolean b(b b) {
        return c.set(this, b);
    }

    @Override // java.util.concurrent.atomic.AtomicReference
    public void dispose() {
        c.dispose(this);
    }

    @Override // java.util.concurrent.atomic.AtomicReference
    public boolean isDisposed() {
        return c.isDisposed((b)get());
    }
}
