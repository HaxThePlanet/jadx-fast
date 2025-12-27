package i.b.m0.e.f;

import i.b.d0;
import i.b.g0;
import i.b.h;
import i.b.k;
import i.b.l0.n;
import i.b.m0.i.g;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import m.c.c;

/* compiled from: SingleFlatMapPublisher.java */
/* loaded from: classes3.dex */
public final class c0<T, R> extends h<R> {

    final g0<T> b;
    final n<? super T, ? extends m.c.a<? extends R>> c;

    static final class a<S, T> extends AtomicLong implements d0<S>, k<T>, c {

        private static final long serialVersionUID = 7759721921468635667L;
        i.b.j0.b disposable;
        final m.c.b<? super T> downstream;
        final n<? super S, ? extends m.c.a<? extends T>> mapper;
        final AtomicReference<c> parent = new AtomicReference<>();
        a(m.c.b<? super T> bVar, n<? super S, ? extends m.c.a<? extends T>> nVar) {
            super();
            this.downstream = bVar;
            this.mapper = nVar;
            final AtomicReference atomicReference = new AtomicReference();
        }

        @Override // java.util.concurrent.atomic.AtomicLong
        public void cancel() {
            this.disposable.dispose();
            g.cancel(this.parent);
        }

        @Override // java.util.concurrent.atomic.AtomicLong
        public void onComplete() {
            this.downstream.onComplete();
        }

        @Override // java.util.concurrent.atomic.AtomicLong
        public void onError(Throwable th) {
            this.downstream.onError(th);
        }

        @Override // java.util.concurrent.atomic.AtomicLong
        public void onNext(T t) {
            this.downstream.onNext(t);
        }

        @Override // java.util.concurrent.atomic.AtomicLong
        public void onSubscribe(i.b.j0.b bVar) {
            this.disposable = bVar;
            this.downstream.onSubscribe(this);
        }

        @Override // java.util.concurrent.atomic.AtomicLong
        public void onSuccess(S s) {
            try {
                final Object apply = this.mapper.apply(s);
                b.e(apply, "the mapper returned a null Publisher");
            } catch (Throwable th) {
                a.b(th);
                this.downstream.onError(th);
                return;
            }
            apply.a(this);
        }

        @Override // java.util.concurrent.atomic.AtomicLong
        public void request(long j) {
            g.deferredRequest(this.parent, this, j);
        }

        @Override // java.util.concurrent.atomic.AtomicLong
        public void onSubscribe(c cVar) {
            g.deferredSetOnce(this.parent, this, cVar);
        }
    }
    public c0(g0<T> g0Var, n<? super T, ? extends m.c.a<? extends R>> nVar) {
        super();
        this.b = g0Var;
        this.c = nVar;
    }

    @Override // i.b.h
    protected void c0(m.c.b<? super R> bVar) {
        this.b.subscribe(new c0.a(bVar, this.c));
    }
}
