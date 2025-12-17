package i.b.m0.e.c;

import i.b.j0.b;
import i.b.j0.c;
import i.b.l;
import i.b.n;
import i.b.p0.a;
import io.reactivex.exceptions.a;
import java.util.concurrent.Callable;

/* loaded from: classes3.dex */
public final class i<T>  extends l<T> implements Callable<T> {

    final Callable<? extends T> a;
    public i(Callable<? extends T> callable) {
        super();
        this.a = callable;
    }

    public T call() {
        return this.a.call();
    }

    protected void w(n<? super T> n) {
        b disposed;
        boolean disposed2;
        disposed = c.b();
        n.onSubscribe(disposed);
        disposed2 = this.a.call();
        if (!disposed.isDisposed() && !disposed.isDisposed()) {
            disposed2 = this.a.call();
            if (!disposed.isDisposed()) {
                if (disposed2 == null) {
                    n.onComplete();
                } else {
                    n.onSuccess(disposed2);
                }
            }
        }
    }
}
