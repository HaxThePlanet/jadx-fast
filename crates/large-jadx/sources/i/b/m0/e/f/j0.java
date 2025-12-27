package i.b.m0.e.f;

import i.b.a0;
import i.b.d0;
import i.b.f0;
import i.b.g0;
import i.b.m0.a.d;
import i.b.m0.b.b;
import io.reactivex.exceptions.a;

/* compiled from: SingleLift.java */
/* loaded from: classes3.dex */
public final class j0<T, R> extends a0<R> {

    final g0<T> a;
    final f0<? extends R, ? super T> b;
    public j0(g0<T> g0Var, f0<? extends R, ? super T> f0Var) {
        super();
        this.a = g0Var;
        this.b = f0Var;
    }

    @Override // i.b.a0
    protected void subscribeActual(d0<? super R> d0Var) {
        try {
            d0 d0Var2 = this.b.a(d0Var);
            b.e(d0Var2, "The onLift returned a null SingleObserver");
        } catch (Throwable th) {
            a.b(th);
            d.error(th, d0Var);
            return;
        }
        this.a.subscribe(d0Var2);
    }
}
