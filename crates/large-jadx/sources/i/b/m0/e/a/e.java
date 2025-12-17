package i.b.m0.e.a;

import i.b.b;
import i.b.d;
import i.b.m0.a.d;

/* loaded from: classes3.dex */
public final class e extends b {

    final Throwable a;
    public e(Throwable throwable) {
        super();
        this.a = throwable;
    }

    @Override // i.b.b
    protected void x(d d) {
        d.error(this.a, d);
    }
}
