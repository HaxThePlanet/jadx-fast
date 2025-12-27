package i.b.m0.e.c;

import i.b.d;
import i.b.f;
import i.b.m0.a.c;
import i.b.p;
import io.reactivex.exceptions.a;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: MaybeFlatMapCompletable.java */
/* loaded from: classes3.dex */
public final class g<T> extends i.b.b {

    final p<T> a;
    final i.b.l0.n<? super T, ? extends f> b;

    static final class a<T> extends AtomicReference<i.b.j0.b> implements i.b.n<T>, d, i.b.j0.b {

        private static final long serialVersionUID = -2177128922851101253L;
        final d downstream;
        final i.b.l0.n<? super T, ? extends f> mapper;
        a(d dVar, i.b.l0.n<? super T, ? extends f> nVar) {
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
    public g(p<T> pVar, i.b.l0.n<? super T, ? extends f> nVar) {
        super();
        this.a = pVar;
        this.b = nVar;
    }

    @Override // i.b.b
    protected void x(d dVar) {
        final i.b.m0.e.c.g.a aVar = new g.a(dVar, this.b);
        dVar.onSubscribe(aVar);
        this.a.b(aVar);
    }
}
