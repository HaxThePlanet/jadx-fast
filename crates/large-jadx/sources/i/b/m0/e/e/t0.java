package i.b.m0.e.e;

import i.b.m0.a.d;
import i.b.m0.b.b;
import i.b.r;
import i.b.y;
import io.reactivex.exceptions.a;
import java.util.concurrent.Callable;

/* loaded from: classes3.dex */
public final class t0<T>  extends r<T> {

    final Callable<? extends Throwable> a;
    public t0(Callable<? extends Throwable> callable) {
        super();
        this.a = callable;
    }

    public void subscribeActual(y<? super T> y) {
        Object call;
        try {
            b.e(this.a.call(), "Callable returned null throwable. Null values are generally not allowed in 2.x operators and sources.");
            a.b(th);
            d.error(call, y);
        }
    }
}
