package i.b.m0.e.f;

import i.b.a0;
import i.b.d0;
import i.b.j0.c;
import java.util.concurrent.Callable;

/* compiled from: SingleFromCallable.java */
/* loaded from: classes3.dex */
public final class d0<T> extends a0<T> {

    final Callable<? extends T> a;
    public d0(Callable<? extends T> callable) {
        super();
        this.a = callable;
    }

    @Override // i.b.a0
    protected void subscribeActual(d0<? super T> d0Var) {
        i.b.j0.b bVar = c.b();
        d0Var.onSubscribe(bVar);
        if (bVar.isDisposed()) {
            return;
        }
        try {
            Object call = this.a.call();
            b.e(call, "The callable returned a null value");
        } catch (Throwable th) {
            a.b(th);
            boolean disposed = disposed.isDisposed();
        }
        if (!bVar.isDisposed()) {
            d0Var.onSuccess(call);
        }
    }
}
