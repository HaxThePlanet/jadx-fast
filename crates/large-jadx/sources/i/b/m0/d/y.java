package i.b.m0.d;

import i.b.d0;
import i.b.j0.b;
import i.b.m0.a.c;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes3.dex */
public final class y<T>  implements d0<T> {

    final AtomicReference<b> a;
    final d0<? super T> b;
    public y(AtomicReference<b> atomicReference, d0<? super T> d02) {
        super();
        this.a = atomicReference;
        this.b = d02;
    }

    @Override // i.b.d0
    public void onError(Throwable throwable) {
        this.b.onError(throwable);
    }

    @Override // i.b.d0
    public void onSubscribe(b b) {
        c.replace(this.a, b);
    }

    public void onSuccess(T t) {
        this.b.onSuccess(t);
    }
}
