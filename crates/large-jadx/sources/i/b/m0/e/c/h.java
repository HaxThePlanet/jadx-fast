package i.b.m0.e.c;

import i.b.m0.a.c;
import i.b.p;
import io.reactivex.exceptions.a;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: MaybeFlatten.java */
/* loaded from: classes3.dex */
public final class h<T, R> extends a<T, R> {

    final i.b.l0.n<? super T, ? extends p<? extends R>> b;

    static final class a<T, R> extends AtomicReference<i.b.j0.b> implements i.b.n<T>, i.b.j0.b {

        private static final long serialVersionUID = 4375739915521278546L;
        final i.b.n<? super R> downstream;
        final i.b.l0.n<? super T, ? extends p<? extends R>> mapper;
        i.b.j0.b upstream;
        a(i.b.n<? super R> nVar, i.b.l0.n<? super T, ? extends p<? extends R>> nVar2) {
            super();
            this.downstream = nVar;
            this.mapper = nVar2;
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void dispose() {
            c.dispose(this);
            this.upstream.dispose();
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
            if (c.validate(this.upstream, bVar)) {
                this.upstream = bVar;
                this.downstream.onSubscribe(this);
            }
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void onSuccess(T t) {
            try {
                final Object apply = this.mapper.apply(t);
                b.e(apply, "The mapper returned a null MaybeSource");
            } catch (Exception e) {
                a.b(e);
                this.downstream.onError(e);
                return;
            }
            if (!isDisposed()) {
                apply.b(new h.a.a(this));
            }
        }
    }
    public h(p<T> pVar, i.b.l0.n<? super T, ? extends p<? extends R>> nVar) {
        super(pVar);
        this.b = nVar;
    }

    @Override // i.b.m0.e.c.a
    protected void w(i.b.n<? super R> nVar) {
        this.a.b(new h.a(nVar, this.b));
    }
}
