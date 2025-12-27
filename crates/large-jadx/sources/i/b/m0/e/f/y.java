package i.b.m0.e.f;

import i.b.d;
import i.b.d0;
import i.b.f;
import i.b.g0;
import i.b.l0.n;
import i.b.m0.a.c;
import io.reactivex.exceptions.a;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: SingleFlatMapCompletable.java */
/* loaded from: classes3.dex */
public final class y<T> extends i.b.b {

    final g0<T> a;
    final n<? super T, ? extends f> b;

    static final class a<T> extends AtomicReference<i.b.j0.b> implements d0<T>, d, i.b.j0.b {

        private static final long serialVersionUID = -2177128922851101253L;
        final d downstream;
        final n<? super T, ? extends f> mapper;
        a(d dVar, n<? super T, ? extends f> nVar) {
            super();
            this.downstream = dVar;
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
        public void onSubscribe(i.b.j0.b bVar) {
            c.replace(this, bVar);
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void onSuccess(T t) {
            try {
                final Object apply = this.mapper.apply(t);
                b.e(apply, "The mapper returned a null CompletableSource");
            } catch (Throwable th) {
                a.b(th);
                onError(th);
                return;
            }
            if (!isDisposed()) {
                apply.b(this);
            }
        }
    }
    public y(g0<T> g0Var, n<? super T, ? extends f> nVar) {
        super();
        this.a = g0Var;
        this.b = nVar;
    }

    @Override // i.b.b
    protected void x(d dVar) {
        final i.b.m0.e.f.y.a aVar = new y.a(dVar, this.b);
        dVar.onSubscribe(aVar);
        this.a.subscribe(aVar);
    }
}
