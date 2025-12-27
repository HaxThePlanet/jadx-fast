package i.b.m0.e.e;

import i.b.j0.b;
import i.b.l0.a;
import i.b.l0.f;
import i.b.m0.d.m;
import i.b.r;
import i.b.w;
import i.b.y;

/* compiled from: ObservableDoOnLifecycle.java */
/* loaded from: classes3.dex */
public final class o0<T> extends a<T, T> {

    private final f<? super b> b;
    private final a c;
    public o0(r<T> rVar, f<? super b> fVar, a aVar) {
        super(rVar);
        this.b = fVar;
        this.c = aVar;
    }

    @Override // i.b.m0.e.e.a
    protected void subscribeActual(y<? super T> yVar) {
        this.a.subscribe(new m(yVar, this.b, this.c));
    }
}
