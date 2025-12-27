package i.b.m0.e.b;

import i.b.a0;
import i.b.d0;
import i.b.h;
import i.b.k;
import i.b.m0.a.d;
import i.b.m0.i.g;
import java.util.Collection;
import java.util.concurrent.Callable;
import m.c.c;

/* compiled from: FlowableToListSingle.java */
/* loaded from: classes3.dex */
public final class n0<T, U extends Collection<? super T>> extends a0<U> implements i.b.m0.c.b<U> {

    final h<T> a;
    final Callable<U> b;

    static final class a<T, U extends Collection<? super T>> implements k<T>, i.b.j0.b {

        final d0<? super U> a;
        c b;
        U c;
        a(d0<? super U> d0Var, U u) {
            super();
            this.a = d0Var;
            this.c = u;
        }

        public void dispose() {
            this.b.cancel();
            this.b = g.CANCELLED;
        }

        public boolean isDisposed() {
            boolean z = true;
            int r0 = this.b == g.CANCELLED ? 1 : 0;
            return (this.b == g.CANCELLED ? 1 : 0);
        }

        public void onComplete() {
            this.b = g.CANCELLED;
            this.a.onSuccess(this.c);
        }

        public void onError(Throwable th) {
            this.c = null;
            this.b = g.CANCELLED;
            this.a.onError(th);
        }

        public void onNext(T t) {
            this.c.add(t);
        }

        public void onSubscribe(c cVar) {
            if (g.validate(this.b, cVar)) {
                this.b = cVar;
                this.a.onSubscribe(this);
                cVar.request(Long.MAX_VALUE);
            }
        }
    }
    public n0(h<T> hVar) {
        this(hVar, b.asCallable());
    }

    @Override // i.b.a0
    public h<U> c() {
        return a.l(new m0(this.a, this.b));
    }

    @Override // i.b.a0
    protected void subscribeActual(d0<? super U> d0Var) {
        try {
            Object call = this.b.call();
            b.e(call, "The collectionSupplier returned a null collection. Null values are generally not allowed in 2.x operators and sources.");
        } catch (Throwable th) {
            a.b(th);
            d.error(th, d0Var);
            return;
        }
        this.a.b0(new n0.a(d0Var, call));
    }

    public n0(h<T> hVar, Callable<U> callable) {
        super();
        this.a = hVar;
        this.b = callable;
    }
}
