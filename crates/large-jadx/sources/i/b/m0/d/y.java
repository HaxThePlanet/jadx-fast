package i.b.m0.d;

import i.b.d0;
import i.b.j0.b;
import i.b.m0.a.c;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: ResumeSingleObserver.java */
/* loaded from: classes3.dex */
public final class y<T> implements d0<T> {

    final AtomicReference<b> a;
    final d0<? super T> b;
    public y(AtomicReference<b> atomicReference, d0<? super T> d0Var) {
        super();
        this.a = atomicReference;
        this.b = d0Var;
    }

    public void onError(Throwable th) {
        this.b.onError(th);
    }

    public void onSubscribe(b bVar) {
        c.replace(this.a, bVar);
    }

    public void onSuccess(T t) {
        this.b.onSuccess(t);
    }
}
