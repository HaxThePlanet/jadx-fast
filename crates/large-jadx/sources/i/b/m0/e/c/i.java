package i.b.m0.e.c;

import i.b.j0.b;
import i.b.j0.c;
import i.b.l;
import i.b.n;
import java.util.concurrent.Callable;

/* compiled from: MaybeFromCallable.java */
/* loaded from: classes3.dex */
public final class i<T> extends l<T> implements Callable<T> {

    final Callable<? extends T> a;
    public i(Callable<? extends T> callable) {
        super();
        this.a = callable;
    }

    @Override // i.b.l
    public T call() throws Exception {
        return this.a.call();
    }

    @Override // i.b.l
    protected void w(n<? super T> nVar) {
        b bVar = c.b();
        nVar.onSubscribe(bVar);
        if (!bVar.isDisposed()) {
            try {
                Object call = this.a.call();
            } catch (Throwable th) {
                a.b(th);
                boolean disposed2 = disposed2.isDisposed();
            }
            if (!bVar.isDisposed() && this.a == null) {
                nVar.onComplete();
            }
        }
    }
}
