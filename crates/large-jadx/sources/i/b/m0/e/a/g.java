package i.b.m0.e.a;

import i.b.b;
import i.b.d;
import i.b.j0.b;
import i.b.j0.c;
import i.b.p0.a;
import io.reactivex.exceptions.a;
import java.util.concurrent.Callable;

/* loaded from: classes3.dex */
public final class g extends b {

    final Callable<?> a;
    public g(Callable<?> callable) {
        super();
        this.a = callable;
    }

    @Override // i.b.b
    protected void x(d d) {
        b bVar = c.b();
        d.onSubscribe(bVar);
        this.a.call();
        if (!bVar.isDisposed()) {
            d.onComplete();
        }
    }
}
