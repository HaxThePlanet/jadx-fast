package i.b.m0.e.f;

import i.b.a0;
import i.b.d0;
import i.b.f0;
import i.b.g0;
import i.b.m0.a.d;
import i.b.m0.b.b;
import io.reactivex.exceptions.a;

/* loaded from: classes3.dex */
public final class j0<T, R>  extends a0<R> {

    final g0<T> a;
    final f0<? extends R, ? super T> b;
    public j0(g0<T> g0, f0<? extends R, ? super T> f02) {
        super();
        this.a = g0;
        this.b = f02;
    }

    protected void subscribeActual(d0<? super R> d0) {
        try {
            d0 d0Var = this.b.a(d0);
            b.e(d0Var, "The onLift returned a null SingleObserver");
            this.a.subscribe((d0)d0Var);
            a.b(th);
            d.error(th, d0);
        }
    }
}
