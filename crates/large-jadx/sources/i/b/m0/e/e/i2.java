package i.b.m0.e.e;

import i.b.l0.n;
import i.b.m0.a.c;
import i.b.m0.a.d;
import i.b.r;
import i.b.w;
import i.b.y;
import io.reactivex.exceptions.a;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: ObservablePublishSelector.java */
/* loaded from: classes3.dex */
public final class i2<T, R> extends a<T, R> {

    final n<? super r<T>, ? extends w<R>> b;

    static final class a<T, R> implements y<T> {

        final i.b.t0.b<T> a;
        final AtomicReference<i.b.j0.b> b;
        a(i.b.t0.b<T> bVar, AtomicReference<i.b.j0.b> atomicReference) {
            super();
            this.a = bVar;
            this.b = atomicReference;
        }

        public void onComplete() {
            this.a.onComplete();
        }

        public void onError(Throwable th) {
            this.a.onError(th);
        }

        public void onNext(T t) {
            this.a.onNext(t);
        }

        public void onSubscribe(i.b.j0.b bVar) {
            c.setOnce(this.b, bVar);
        }
    }

    static final class b<T, R> extends AtomicReference<i.b.j0.b> implements y<R>, i.b.j0.b {

        private static final long serialVersionUID = 854110278590336484L;
        final y<? super R> downstream;
        i.b.j0.b upstream;
        b(y<? super R> yVar) {
            super();
            this.downstream = yVar;
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void dispose() {
            this.upstream.dispose();
            c.dispose(this);
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public boolean isDisposed() {
            return this.upstream.isDisposed();
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void onComplete() {
            c.dispose(this);
            this.downstream.onComplete();
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void onError(Throwable th) {
            c.dispose(this);
            this.downstream.onError(th);
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void onNext(R r) {
            this.downstream.onNext(r);
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void onSubscribe(i.b.j0.b bVar) {
            if (c.validate(this.upstream, bVar)) {
                this.upstream = bVar;
                this.downstream.onSubscribe(this);
            }
        }
    }
    public i2(w<T> wVar, n<? super r<T>, ? extends w<R>> nVar) {
        super(wVar);
        this.b = nVar;
    }

    @Override // i.b.m0.e.e.a
    protected void subscribeActual(y<? super R> yVar) {
        final i.b.t0.b bVar = b.e();
        try {
            Object apply = this.b.apply(bVar);
            b.e(apply, "The selector returned a null ObservableSource");
        } catch (Throwable th) {
            a.b(th);
            d.error(th, yVar);
            return;
        }
        i.b.m0.e.e.i2.b bVar2 = new i2.b(yVar);
        apply.subscribe(bVar2);
        this.a.subscribe(new i2.a(bVar, bVar2));
    }
}
