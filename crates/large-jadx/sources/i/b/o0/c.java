package i.b.o0;

import i.b.j0.b;
import i.b.m0.a.c;
import i.b.m0.j.i;
import i.b.y;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: DisposableObserver.java */
/* loaded from: classes3.dex */
public abstract class c<T> implements y<T>, b {

    final AtomicReference<b> a = new AtomicReference<>();
    public c() {
        super();
        final AtomicReference atomicReference = new AtomicReference();
    }

    public final void dispose() {
        c.dispose(this.a);
    }

    public final boolean isDisposed() {
        boolean z = true;
        int r0 = this.a.get() == c.DISPOSED ? 1 : 0;
        return (this.a.get() == c.DISPOSED ? 1 : 0);
    }

    public final void onSubscribe(b bVar) {
        if (i.c(this.a, bVar, getClass())) {
            b();
        }
    }

    protected void b() {
    }
}
