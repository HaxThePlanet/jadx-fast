package i.b.m0.e.e;

import i.b.a0;
import i.b.d0;
import i.b.l0.c;
import i.b.m0.a.d;
import i.b.m0.b.b;
import i.b.w;
import io.reactivex.exceptions.a;
import java.util.concurrent.Callable;

/* loaded from: classes3.dex */
public final class n2<T, R>  extends a0<R> {

    final w<T> a;
    final Callable<R> b;
    final c<R, ? super T, R> c;
    public n2(w<T> w, Callable<R> callable2, c<R, ? super T, R> c3) {
        super();
        this.a = w;
        this.b = callable2;
        this.c = c3;
    }

    protected void subscribeActual(d0<? super R> d0) {
        try {
            Object call = this.b.call();
            b.e(call, "The seedSupplier returned a null value");
            m2.a aVar = new m2.a(d0, this.c, call);
            this.a.subscribe(aVar);
            a.b(th);
            d.error(th, d0);
        }
    }
}
