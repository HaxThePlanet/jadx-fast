package i.b.m0.e.e;

import i.b.m0.a.d;
import i.b.r;
import i.b.y;

/* loaded from: classes3.dex */
public final class b2 extends r<Object> {

    public static final r<Object> a;
    static {
        b2 b2Var = new b2();
        b2.a = b2Var;
    }

    protected void subscribeActual(y<? super Object> y) {
        y.onSubscribe(d.NEVER);
    }
}
