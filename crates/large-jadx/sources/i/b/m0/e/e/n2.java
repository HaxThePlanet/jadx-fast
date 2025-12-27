package i.b.m0.e.e;

import i.b.a0;
import i.b.d0;
import i.b.l0.c;
import i.b.m0.a.d;
import i.b.m0.b.b;
import i.b.w;
import io.reactivex.exceptions.a;
import java.util.concurrent.Callable;

/* compiled from: ObservableReduceWithSingle.java */
/* loaded from: classes3.dex */
public final class n2<T, R> extends a0<R> {

    final w<T> a;
    final Callable<R> b;
    final c<R, ? super T, R> c;
    public n2(w<T> wVar, Callable<R> callable, c<R, ? super T, R> cVar) {
        super();
        this.a = wVar;
        this.b = callable;
        this.c = cVar;
    }

    @Override // i.b.a0
    protected void subscribeActual(d0<? super R> d0Var) {
        try {
            Object call = this.b.call();
            b.e(call, "The seedSupplier returned a null value");
        } catch (Throwable th) {
            a.b(th);
            d.error(th, d0Var);
            return;
        }
        this.a.subscribe(new m2.a(d0Var, this.c, call));
    }
}
