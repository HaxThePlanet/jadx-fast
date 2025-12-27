package i.b.m0.e.e;

import i.b.m0.b.b;
import i.b.m0.d.l;
import i.b.r;
import i.b.y;
import java.util.concurrent.Callable;

/* compiled from: ObservableFromCallable.java */
/* loaded from: classes3.dex */
public final class c1<T> extends r<T> implements Callable<T> {

    final Callable<? extends T> a;
    public c1(Callable<? extends T> callable) {
        super();
        this.a = callable;
    }

    @Override // i.b.r
    public T call() throws Exception {
        Object call = this.a.call();
        b.e(call, "The callable returned a null value");
        return call;
    }

    @Override // i.b.r
    public void subscribeActual(y<? super T> yVar) {
        final l lVar = new l(yVar);
        yVar.onSubscribe(lVar);
        if (lVar.isDisposed()) {
            return;
        }
        try {
            Object call = this.a.call();
            b.e(call, "Callable returned null");
        } catch (Throwable th) {
            a.b(th);
            boolean disposed = disposed.isDisposed();
        }
        lVar.b(call);
    }
}
