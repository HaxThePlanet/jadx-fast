package i.b.m0.e.e;

import i.b.r;
import i.b.w;
import i.b.y;

/* compiled from: ObservableFromUnsafeSource.java */
/* loaded from: classes3.dex */
public final class g1<T> extends r<T> {

    final w<T> a;
    public g1(w<T> wVar) {
        super();
        this.a = wVar;
    }

    @Override // i.b.r
    protected void subscribeActual(y<? super T> yVar) {
        this.a.subscribe(yVar);
    }
}
