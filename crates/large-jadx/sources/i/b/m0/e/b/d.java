package i.b.m0.e.b;

import i.b.h;
import i.b.l0.n;
import i.b.m0.j.j;
import m.c.a;
import m.c.b;

/* compiled from: FlowableConcatMapPublisher.java */
/* loaded from: classes3.dex */
public final class d<T, R> extends h<R> {

    final a<T> b;
    final n<? super T, ? extends a<? extends R>> c;
    final int v;
    final j w;
    public d(a<T> aVar, n<? super T, ? extends a<? extends R>> nVar, int i, j jVar) {
        super();
        this.b = aVar;
        this.c = nVar;
        this.v = i;
        this.w = jVar;
    }

    @Override // i.b.h
    protected void c0(b<? super R> bVar) {
        if (i0.b(this.b, bVar, this.c)) {
            return;
        }
        this.b.a(b.g0(bVar, this.c, this.v, this.w));
    }
}
