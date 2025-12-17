package i.b.m0.e.a;

import i.b.b;
import i.b.d;
import i.b.j0.b;
import i.b.j0.c;
import i.b.l0.a;
import i.b.p0.a;
import io.reactivex.exceptions.a;

/* loaded from: classes3.dex */
public final class f extends b {

    final a a;
    public f(a a) {
        super();
        this.a = a;
    }

    @Override // i.b.b
    protected void x(d d) {
        b bVar = c.b();
        d.onSubscribe(bVar);
        this.a.run();
        if (!bVar.isDisposed()) {
            d.onComplete();
        }
    }
}
