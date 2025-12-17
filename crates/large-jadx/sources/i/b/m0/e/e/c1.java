package i.b.m0.e.e;

import i.b.m0.b.b;
import i.b.m0.d.l;
import i.b.p0.a;
import i.b.r;
import i.b.y;
import io.reactivex.exceptions.a;
import java.util.concurrent.Callable;

/* loaded from: classes3.dex */
public final class c1<T>  extends r<T> implements Callable<T> {

    final Callable<? extends T> a;
    public c1(Callable<? extends T> callable) {
        super();
        this.a = callable;
    }

    public T call() {
        Object call = this.a.call();
        b.e(call, "The callable returned a null value");
        return call;
    }

    public void subscribeActual(y<? super T> y) {
        l lVar = new l(y);
        y.onSubscribe(lVar);
        if (lVar.isDisposed()) {
        }
        Object call = this.a.call();
        b.e(call, "Callable returned null");
        lVar.b(call);
    }
}
