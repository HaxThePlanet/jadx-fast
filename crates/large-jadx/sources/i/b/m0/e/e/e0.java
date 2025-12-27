package i.b.m0.e.e;

import i.b.m0.a.d;
import i.b.m0.b.b;
import i.b.r;
import i.b.w;
import i.b.y;
import io.reactivex.exceptions.a;
import java.util.concurrent.Callable;

/* compiled from: ObservableDefer.java */
/* loaded from: classes3.dex */
public final class e0<T> extends r<T> {

    final Callable<? extends w<? extends T>> a;
    public e0(Callable<? extends w<? extends T>> callable) {
        super();
        this.a = callable;
    }

    @Override // i.b.r
    public void subscribeActual(y<? super T> yVar) {
        try {
            Object call = this.a.call();
            b.e(call, "null ObservableSource supplied");
        } catch (Throwable th) {
            a.b(th);
            d.error(th, yVar);
            return;
        }
        call.subscribe(yVar);
    }
}
