package i.b.m0.e.b;

import i.b.h;
import i.b.m0.i.c;
import io.reactivex.exceptions.a;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import m.c.b;

/* loaded from: classes3.dex */
public final class p<T>  extends h<T> {

    final Future<? extends T> b;
    final long c;
    final TimeUnit v;
    public p(Future<? extends T> future, long l2, TimeUnit timeUnit3) {
        super();
        this.b = future;
        this.c = l2;
        this.v = obj4;
    }

    public void c0(b<? super T> b) {
        Object nullPointerException;
        Throwable th;
        Object str;
        Future future;
        long l;
        nullPointerException = new c(b);
        b.onSubscribe(nullPointerException);
        TimeUnit time = this.v;
        if (time != null) {
            str = this.b.get(this.c, obj4);
        } else {
            str = this.b.get();
        }
        if (str == null) {
            nullPointerException = new NullPointerException("The future returned null");
            b.onError(nullPointerException);
        } else {
            nullPointerException.a(str);
        }
    }
}
