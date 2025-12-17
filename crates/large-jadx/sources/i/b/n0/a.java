package i.b.n0;

import i.b.j0.b;
import i.b.l0.f;
import i.b.m0.e.e.g2;
import i.b.m0.e.e.h2;
import i.b.m0.e.e.o2;
import i.b.p0.a;
import i.b.r;

/* loaded from: classes3.dex */
public abstract class a<T>  extends r<T> {
    private i.b.n0.a<T> d() {
        if (this instanceof h2) {
            g2 g2Var = new g2((h2)this.b());
            return a.q(g2Var);
        }
        return this;
    }

    public abstract void c(f<? super b> f);

    public r<T> e() {
        o2 o2Var = new o2(d());
        return a.n(o2Var);
    }
}
