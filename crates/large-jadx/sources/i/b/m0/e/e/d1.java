package i.b.m0.e.e;

import i.b.m0.b.b;
import i.b.m0.d.l;
import i.b.r;
import i.b.y;
import io.reactivex.exceptions.a;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/* compiled from: ObservableFromFuture.java */
/* loaded from: classes3.dex */
public final class d1<T> extends r<T> {

    final Future<? extends T> a;
    final long b;
    final TimeUnit c;
    public d1(Future<? extends T> future, long j, TimeUnit timeUnit) {
        super();
        this.a = future;
        this.b = j;
        this.c = timeUnit;
    }

    @Override // i.b.r
    public void subscribeActual(y<? super T> yVar) {
        Object obj;
        long l;
        l lVar = new l(yVar);
        yVar.onSubscribe(lVar);
        if (!lVar.isDisposed() && this.c != null) {
            obj = this.a.get(this.b, this.c);
            str = "Future returned null";
            b.e(obj, str);
            lVar.b(obj);
        }
    }
}
