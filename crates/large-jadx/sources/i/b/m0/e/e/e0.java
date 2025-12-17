package i.b.m0.e.e;

import i.b.m0.a.d;
import i.b.m0.b.b;
import i.b.r;
import i.b.w;
import i.b.y;
import io.reactivex.exceptions.a;
import java.util.concurrent.Callable;

/* loaded from: classes3.dex */
public final class e0<T>  extends r<T> {

    final Callable<? extends w<? extends T>> a;
    public e0(Callable<? extends w<? extends T>> callable) {
        super();
        this.a = callable;
    }

    public void subscribeActual(y<? super T> y) {
        try {
            Object call = this.a.call();
            b.e(call, "null ObservableSource supplied");
            (w)call.subscribe(y);
            a.b(th);
            d.error(th, y);
        }
    }
}
