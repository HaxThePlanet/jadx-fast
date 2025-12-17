package i.b.m0.e.f;

import i.b.a0;
import i.b.d0;
import i.b.m0.a.d;

/* loaded from: classes3.dex */
public final class m0 extends a0<Object> {

    public static final a0<Object> a;
    static {
        m0 m0Var = new m0();
        m0.a = m0Var;
    }

    protected void subscribeActual(d0<? super Object> d0) {
        d0.onSubscribe(d.NEVER);
    }
}
