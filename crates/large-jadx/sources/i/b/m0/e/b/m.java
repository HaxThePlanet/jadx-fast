package i.b.m0.e.b;

import i.b.h;
import i.b.l0.n;
import m.c.a;
import m.c.b;

/* loaded from: classes3.dex */
public final class m<T, U>  extends h<U> {

    final a<T> b;
    final n<? super T, ? extends a<? extends U>> c;
    final boolean v;
    final int w;
    final int x;
    public m(a<T> a, n<? super T, ? extends a<? extends U>> n2, boolean z3, int i4, int i5) {
        super();
        this.b = a;
        this.c = n2;
        this.v = z3;
        this.w = i4;
        this.x = i5;
    }

    protected void c0(b<? super U> b) {
        if (i0.b(this.b, b, this.c)) {
        }
        this.b.a(k.g0(b, this.c, this.v, this.w, this.x));
    }
}
