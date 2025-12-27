package i.b.m0.e.f;

import i.b.a0;
import i.b.d0;
import i.b.g0;
import i.b.l0.n;
import i.b.m0.a.c;
import io.reactivex.exceptions.a;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: SingleFlatMap.java */
/* loaded from: classes3.dex */
public final class x<T, R> extends a0<R> {

    final g0<? extends T> a;
    final n<? super T, ? extends g0<? extends R>> b;

    static final class a<T, R> extends AtomicReference<i.b.j0.b> implements d0<T>, i.b.j0.b {

        private static final long serialVersionUID = 3258103020495908596L;
        final d0<? super R> downstream;
        final n<? super T, ? extends g0<? extends R>> mapper;
        a(d0<? super R> d0Var, n<? super T, ? extends g0<? extends R>> nVar) {
            super();
            this.downstream = d0Var;
            this.mapper = nVar;
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void dispose() {
            c.dispose(this);
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public boolean isDisposed() {
            return c.isDisposed((b)get());
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void onError(Throwable th) {
            this.downstream.onError(th);
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void onSubscribe(i.b.j0.b bVar) {
            if (c.setOnce(this, bVar)) {
                this.downstream.onSubscribe(this);
            }
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void onSuccess(T t) {
            try {
                final Object apply = this.mapper.apply(t);
                b.e(apply, "The single returned by the mapper is null");
            } catch (Throwable th) {
                a.b(th);
                this.downstream.onError(th);
                return;
            }
            if (!isDisposed()) {
                apply.subscribe(new x.a.a(this, this.downstream));
            }
        }
    }
    public x(g0<? extends T> g0Var, n<? super T, ? extends g0<? extends R>> nVar) {
        super();
        this.b = nVar;
        this.a = g0Var;
    }

    @Override // i.b.a0
    protected void subscribeActual(d0<? super R> d0Var) {
        this.a.subscribe(new x.a(d0Var, this.b));
    }
}
