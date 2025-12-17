package i.b.m0.e.f;

import i.b.a0;
import i.b.d0;
import i.b.g0;
import i.b.m0.a.d;
import i.b.m0.b.b;
import io.reactivex.exceptions.a;
import java.util.concurrent.Callable;

/* loaded from: classes3.dex */
public final class e<T>  extends a0<T> {

    final Callable<? extends g0<? extends T>> a;
    public e(Callable<? extends g0<? extends T>> callable) {
        super();
        this.a = callable;
    }

    protected void subscribeActual(d0<? super T> d0) {
        try {
            Object call = this.a.call();
            b.e(call, "The singleSupplier returned a null SingleSource");
            (g0)call.subscribe(d0);
            a.b(th);
            d.error(th, d0);
        }
    }
}
