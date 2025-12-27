package i.b.m0.e.e;

import i.b.o0.e;
import i.b.r;
import i.b.w;
import i.b.y;

/* compiled from: ObservableSerialized.java */
/* loaded from: classes3.dex */
public final class d3<T> extends a<T, T> {
    public d3(r<T> rVar) {
        super(rVar);
    }

    @Override // i.b.m0.e.e.a
    protected void subscribeActual(y<? super T> yVar) {
        this.a.subscribe(new e(yVar));
    }
}
