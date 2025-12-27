package i.b.m0.e.b;

import i.b.h;
import i.b.m0.i.c;
import io.reactivex.exceptions.a;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import m.c.b;

/* compiled from: FlowableFromFuture.java */
/* loaded from: classes3.dex */
public final class p<T> extends h<T> {

    final Future<? extends T> b;
    final long c;
    final TimeUnit v;
    public p(Future<? extends T> future, long j, TimeUnit timeUnit) {
        super();
        this.b = future;
        this.c = j;
        this.v = timeUnit;
    }

    @Override // i.b.h
    public void c0(b<? super T> bVar) {
        Throwable th;
        Object obj;
        c cVar = new c(bVar);
        bVar.onSubscribe(cVar);
        try {
            if (this.v != null) {
                obj = this.b.get(this.c, this.v);
            } else {
                obj = this.b.get();
            }
        } catch (Throwable th) {
            a.b(th);
            boolean z = z.b();
        }
        if (this.v == null) {
            bVar.onError(new NullPointerException("The future returned null"));
        } else {
            cVar.a(obj);
        }
    }
}
