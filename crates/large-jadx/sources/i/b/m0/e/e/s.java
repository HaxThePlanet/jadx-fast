package i.b.m0.e.e;

import i.b.a0;
import i.b.d0;
import i.b.m0.a.c;
import i.b.p0.a;
import i.b.r;
import i.b.w;
import i.b.y;
import java.util.concurrent.Callable;

/* compiled from: ObservableCollectSingle.java */
/* loaded from: classes3.dex */
public final class s<T, U> extends a0<U> implements i.b.m0.c.d<U> {

    final w<T> a;
    final Callable<? extends U> b;
    final i.b.l0.b<? super U, ? super T> c;

    static final class a<T, U> implements y<T>, i.b.j0.b {

        final d0<? super U> a;
        final i.b.l0.b<? super U, ? super T> b;
        final U c;
        i.b.j0.b v;
        boolean w;
        a(d0<? super U> d0Var, U u, i.b.l0.b<? super U, ? super T> bVar) {
            super();
            this.a = d0Var;
            this.b = bVar;
            this.c = u;
        }

        public void dispose() {
            this.v.dispose();
        }

        public boolean isDisposed() {
            return this.v.isDisposed();
        }

        public void onComplete() {
            if (this.w) {
                return;
            }
            this.w = true;
            this.a.onSuccess(this.c);
        }

        public void onError(Throwable th) {
            if (this.w) {
                a.t(th);
                return;
            }
            this.w = true;
            this.a.onError(th);
        }

        public void onNext(T t) {
            if (this.w) {
                return;
            }
            try {
                this.b.a(this.c, t);
            } catch (Throwable th) {
                this.v.dispose();
                onError(th);
            }
        }

        public void onSubscribe(i.b.j0.b bVar) {
            if (c.validate(this.v, bVar)) {
                this.v = bVar;
                this.a.onSubscribe(this);
            }
        }
    }
    public s(w<T> wVar, Callable<? extends U> callable, i.b.l0.b<? super U, ? super T> bVar) {
        super();
        this.a = wVar;
        this.b = callable;
        this.c = bVar;
    }

    @Override // i.b.a0
    public r<U> a() {
        return a.n(new r(this.a, this.b, this.c));
    }

    @Override // i.b.a0
    protected void subscribeActual(d0<? super U> d0Var) {
        try {
            Object call = this.b.call();
            b.e(call, "The initialSupplier returned a null value");
        } catch (Throwable th) {
            d.error(th, d0Var);
            return;
        }
        this.a.subscribe(new s.a(d0Var, call, this.c));
    }
}
