package i.b.m0.e.e;

import i.b.m0.a.d;
import i.b.r;
import i.b.y;

/* compiled from: ObservableNever.java */
/* loaded from: classes3.dex */
public final class b2 extends r<Object> {

    public static final r<Object> a = new b2<>();

    private b2() {
        super();
    }

    @Override // i.b.r
    protected void subscribeActual(y<? super Object> yVar) {
        yVar.onSubscribe(d.NEVER);
    }
}
