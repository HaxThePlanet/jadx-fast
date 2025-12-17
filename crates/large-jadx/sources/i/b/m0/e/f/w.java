package i.b.m0.e.f;

import i.b.a0;
import i.b.d0;
import i.b.m0.a.d;
import i.b.m0.b.b;
import io.reactivex.exceptions.a;
import java.util.concurrent.Callable;

/* loaded from: classes3.dex */
public final class w<T>  extends a0<T> {

    final Callable<? extends Throwable> a;
    public w(Callable<? extends Throwable> callable) {
        super();
        this.a = callable;
    }

    protected void subscribeActual(d0<? super T> d0) {
        Object call;
        try {
            b.e(this.a.call(), "Callable returned null throwable. Null values are generally not allowed in 2.x operators and sources.");
            a.b(th);
            d.error(call, d0);
        }
    }
}
