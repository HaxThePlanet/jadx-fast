package i.b.m0.e.e;

import i.b.a0;
import i.b.d0;
import i.b.m0.a.c;
import i.b.r;
import i.b.w;
import i.b.y;
import java.util.Collection;
import java.util.concurrent.Callable;

/* compiled from: ObservableToListSingle.java */
/* loaded from: classes3.dex */
public final class c4<T, U extends Collection<? super T>> extends a0<U> implements i.b.m0.c.d<U> {

    final w<T> a;
    final Callable<U> b;

    static final class a<T, U extends Collection<? super T>> implements y<T>, i.b.j0.b {

        final d0<? super U> a;
        U b;
        i.b.j0.b c;
        a(d0<? super U> d0Var, U u) {
            super();
            this.a = d0Var;
            this.b = u;
        }

        public void dispose() {
            this.c.dispose();
        }

        public boolean isDisposed() {
            return this.c.isDisposed();
        }

        public void onComplete() {
            this.b = null;
            this.a.onSuccess(this.b);
        }

        public void onError(Throwable th) {
            this.b = null;
            this.a.onError(th);
        }

        public void onNext(T t) {
            this.b.add(t);
        }

        public void onSubscribe(i.b.j0.b bVar) {
            if (c.validate(this.c, bVar)) {
                this.c = bVar;
                this.a.onSubscribe(this);
            }
        }
    }
    public c4(w<T> wVar, int i) {
        super();
        this.a = wVar;
        this.b = a.e(i);
    }

    @Override // i.b.a0
    public r<U> a() {
        return a.n(new b4(this.a, this.b));
    }

    @Override // i.b.a0
    public void subscribeActual(d0<? super U> d0Var) {
        try {
            Object call = this.b.call();
            b.e(call, "The collectionSupplier returned a null collection. Null values are generally not allowed in 2.x operators and sources.");
        } catch (Throwable th) {
            a.b(th);
            d.error(th, d0Var);
            return;
        }
        this.a.subscribe(new c4.a(d0Var, call));
    }

    public c4(w<T> wVar, Callable<U> callable) {
        super();
        this.a = wVar;
        this.b = callable;
    }
}
