package i.b.m0.e.a;

import i.b.d;
import i.b.j0.c;
import java.util.concurrent.Callable;

/* compiled from: CompletableFromCallable.java */
/* loaded from: classes3.dex */
public final class g extends i.b.b {

    final Callable<?> a;
    public g(Callable<?> callable) {
        super();
        this.a = callable;
    }

    @Override // i.b.b
    protected void x(d dVar) {
        i.b.j0.b bVar = c.b();
        dVar.onSubscribe(bVar);
        try {
            this.a.call();
        } catch (Throwable th) {
            a.b(th);
            boolean disposed = disposed.isDisposed();
        }
        if (!bVar.isDisposed()) {
            dVar.onComplete();
        }
    }
}
