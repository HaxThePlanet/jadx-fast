package i.b.m0.e.e;

import i.b.m0.b.b;
import i.b.m0.d.l;
import i.b.r;
import i.b.y;
import io.reactivex.exceptions.a;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/* loaded from: classes3.dex */
public final class d1<T>  extends r<T> {

    final Future<? extends T> a;
    final long b;
    final TimeUnit c;
    public d1(Future<? extends T> future, long l2, TimeUnit timeUnit3) {
        super();
        this.a = future;
        this.b = l2;
        this.c = obj4;
    }

    public void subscribeActual(y<? super T> y) {
        l lVar;
        boolean disposed;
        Object str;
        long l;
        lVar = new l(y);
        y.onSubscribe(lVar);
        if (!lVar.isDisposed()) {
            TimeUnit time = this.c;
            if (time != null) {
                disposed = this.a.get(this.b, obj4);
            } else {
                disposed = this.a.get();
            }
            b.e(disposed, "Future returned null");
            lVar.b(disposed);
        }
    }
}
