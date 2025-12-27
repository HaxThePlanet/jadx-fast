package i.b.m0.e.f;

import i.b.d0;
import i.b.g0;
import i.b.l;
import i.b.m0.a.c;
import i.b.p;
import io.reactivex.exceptions.a;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: SingleFlatMapMaybe.java */
/* loaded from: classes3.dex */
public final class b0<T, R> extends l<R> {

    final g0<? extends T> a;
    final i.b.l0.n<? super T, ? extends p<? extends R>> b;

    static final class a<R> implements i.b.n<R> {

        final AtomicReference<i.b.j0.b> a;
        final i.b.n<? super R> b;
        a(AtomicReference<i.b.j0.b> atomicReference, i.b.n<? super R> nVar) {
            super();
            this.a = atomicReference;
            this.b = nVar;
        }

        public void onComplete() {
            this.b.onComplete();
        }

        public void onError(Throwable th) {
            this.b.onError(th);
        }

        public void onSubscribe(i.b.j0.b bVar) {
            c.replace(this.a, bVar);
        }

        public void onSuccess(R r) {
            this.b.onSuccess(r);
        }
    }

    static final class b<T, R> extends AtomicReference<i.b.j0.b> implements d0<T>, i.b.j0.b {

        private static final long serialVersionUID = -5843758257109742742L;
        final i.b.n<? super R> downstream;
        final i.b.l0.n<? super T, ? extends p<? extends R>> mapper;
        b(i.b.n<? super R> nVar, i.b.l0.n<? super T, ? extends p<? extends R>> nVar2) {
            super();
            this.downstream = nVar;
            this.mapper = nVar2;
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
                b.e(apply, "The mapper returned a null MaybeSource");
            } catch (Throwable th) {
                a.b(th);
                onError(th);
                return;
            }
            if (!isDisposed()) {
                apply.b(new b0.a(this, this.downstream));
            }
        }
    }
    public b0(g0<? extends T> g0Var, i.b.l0.n<? super T, ? extends p<? extends R>> nVar) {
        super();
        this.b = nVar;
        this.a = g0Var;
    }

    @Override // i.b.l
    protected void w(i.b.n<? super R> nVar) {
        this.a.subscribe(new b0.b(nVar, this.b));
    }
}
