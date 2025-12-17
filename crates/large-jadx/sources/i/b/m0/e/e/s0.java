package i.b.m0.e.e;

import i.b.m0.a.d;
import i.b.m0.c.h;
import i.b.r;
import i.b.y;

/* loaded from: classes3.dex */
public final class s0 extends r<Object> implements h<Object> {

    public static final r<Object> a;
    static {
        s0 s0Var = new s0();
        s0.a = s0Var;
    }

    @Override // i.b.r
    public Object call() {
        return null;
    }

    protected void subscribeActual(y<? super Object> y) {
        d.complete(y);
    }
}
