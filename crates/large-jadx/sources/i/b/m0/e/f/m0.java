package i.b.m0.e.f;

import i.b.a0;
import i.b.d0;
import i.b.m0.a.d;

/* compiled from: SingleNever.java */
/* loaded from: classes3.dex */
public final class m0 extends a0<Object> {

    public static final a0<Object> a = new m0<>();

    private m0() {
        super();
    }

    @Override // i.b.a0
    protected void subscribeActual(d0<? super Object> d0Var) {
        d0Var.onSubscribe(d.NEVER);
    }
}
