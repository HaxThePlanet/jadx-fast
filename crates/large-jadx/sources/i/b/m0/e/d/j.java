package i.b.m0.e.d;

import i.b.d0;
import i.b.g0;
import i.b.l0.n;
import i.b.m0.a.c;
import i.b.r;
import i.b.w;
import i.b.y;
import io.reactivex.exceptions.a;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: SingleFlatMapObservable.java */
/* loaded from: classes3.dex */
public final class j<T, R> extends r<R> {

    final g0<T> a;
    final n<? super T, ? extends w<? extends R>> b;

    static final class a<T, R> extends AtomicReference<i.b.j0.b> implements y<R>, d0<T>, i.b.j0.b {

        private static final long serialVersionUID = -8948264376121066672L;
        final y<? super R> downstream;
        final n<? super T, ? extends w<? extends R>> mapper;
        a(y<? super R> yVar, n<? super T, ? extends w<? extends R>> nVar) {
            super();
            this.downstream = yVar;
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
        public void onComplete() {
            this.downstream.onComplete();
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void onError(Throwable th) {
            this.downstream.onError(th);
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void onNext(R r) {
            this.downstream.onNext(r);
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void onSubscribe(i.b.j0.b bVar) {
            c.replace(this, bVar);
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void onSuccess(T t) {
            try {
                final Object apply = this.mapper.apply(t);
                b.e(apply, "The mapper returned a null Publisher");
            } catch (Throwable th) {
                a.b(th);
                this.downstream.onError(th);
                return;
            }
            apply.subscribe(this);
        }
    }
    public j(g0<T> g0Var, n<? super T, ? extends w<? extends R>> nVar) {
        super();
        this.a = g0Var;
        this.b = nVar;
    }

    @Override // i.b.r
    protected void subscribeActual(y<? super R> yVar) {
        final i.b.m0.e.d.j.a aVar = new j.a(yVar, this.b);
        yVar.onSubscribe(aVar);
        this.a.subscribe(aVar);
    }
}
