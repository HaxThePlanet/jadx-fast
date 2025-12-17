package i.b.m0.e.b;

import i.b.h;
import i.b.l0.n;
import i.b.m0.j.j;
import m.c.a;
import m.c.b;

/* loaded from: classes3.dex */
public final class d<T, R>  extends h<R> {

    final a<T> b;
    final n<? super T, ? extends a<? extends R>> c;
    final int v;
    final j w;
    public d(a<T> a, n<? super T, ? extends a<? extends R>> n2, int i3, j j4) {
        super();
        this.b = a;
        this.c = n2;
        this.v = i3;
        this.w = j4;
    }

    protected void c0(b<? super R> b) {
        if (i0.b(this.b, b, this.c)) {
        }
        this.b.a(b.g0(b, this.c, this.v, this.w));
    }
}
