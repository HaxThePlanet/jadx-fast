package i.b.m0.e.e;

import i.b.o0.e;
import i.b.r;
import i.b.w;
import i.b.y;

/* loaded from: classes3.dex */
public final class d3<T>  extends i.b.m0.e.e.a<T, T> {
    public d3(r<T> r) {
        super(r);
    }

    protected void subscribeActual(y<? super T> y) {
        e eVar = new e(y);
        this.a.subscribe(eVar);
    }
}
