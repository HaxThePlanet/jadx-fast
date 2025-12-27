package i.b.m0.e.b;

import i.b.h;
import i.b.l0.n;
import m.c.a;
import m.c.b;

/* compiled from: FlowableFlatMapPublisher.java */
/* loaded from: classes3.dex */
public final class m<T, U> extends h<U> {

    final a<T> b;
    final n<? super T, ? extends a<? extends U>> c;
    final boolean v;
    final int w;
    final int x;
    public m(a<T> aVar, n<? super T, ? extends a<? extends U>> nVar, boolean z, int i, int i2) {
        super();
        this.b = aVar;
        this.c = nVar;
        this.v = z;
        this.w = i;
        this.x = i2;
    }

    @Override // i.b.h
    protected void c0(b<? super U> bVar) {
        if (i0.b(this.b, bVar, this.c)) {
            return;
        }
        this.b.a(k.g0(bVar, this.c, this.v, this.w, this.x));
    }
}
