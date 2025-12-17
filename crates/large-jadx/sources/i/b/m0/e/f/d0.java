package i.b.m0.e.f;

import i.b.a0;
import i.b.d0;
import i.b.j0.b;
import i.b.j0.c;
import i.b.m0.b.b;
import i.b.p0.a;
import io.reactivex.exceptions.a;
import java.util.concurrent.Callable;

/* loaded from: classes3.dex */
public final class d0<T>  extends a0<T> {

    final Callable<? extends T> a;
    public d0(Callable<? extends T> callable) {
        super();
        this.a = callable;
    }

    protected void subscribeActual(d0<? super T> d0) {
        b bVar = c.b();
        d0.onSubscribe(bVar);
        if (bVar.isDisposed()) {
        }
        Object call = this.a.call();
        b.e(call, "The callable returned a null value");
        if (!bVar.isDisposed()) {
            d0.onSuccess(call);
        }
    }
}
