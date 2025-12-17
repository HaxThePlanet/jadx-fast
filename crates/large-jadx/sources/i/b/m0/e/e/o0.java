package i.b.m0.e.e;

import i.b.j0.b;
import i.b.l0.a;
import i.b.l0.f;
import i.b.m0.d.m;
import i.b.r;
import i.b.w;
import i.b.y;

/* loaded from: classes3.dex */
public final class o0<T>  extends i.b.m0.e.e.a<T, T> {

    private final f<? super b> b;
    private final a c;
    public o0(r<T> r, f<? super b> f2, a a3) {
        super(r);
        this.b = f2;
        this.c = a3;
    }

    protected void subscribeActual(y<? super T> y) {
        m mVar = new m(y, this.b, this.c);
        this.a.subscribe(mVar);
    }
}
