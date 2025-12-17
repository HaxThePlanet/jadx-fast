package i.b.o0;

import i.b.j0.b;
import i.b.m0.a.c;
import i.b.m0.j.i;
import i.b.y;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes3.dex */
public abstract class c<T>  implements y<T>, b {

    final AtomicReference<b> a;
    public c() {
        super();
        AtomicReference atomicReference = new AtomicReference();
        this.a = atomicReference;
    }

    @Override // i.b.y
    protected void b() {
    }

    @Override // i.b.y
    public final void dispose() {
        c.dispose(this.a);
    }

    @Override // i.b.y
    public final boolean isDisposed() {
        int i;
        i = this.a.get() == c.DISPOSED ? 1 : 0;
        return i;
    }

    @Override // i.b.y
    public final void onSubscribe(b b) {
        if (i.c(this.a, b, getClass())) {
            b();
        }
    }
}
