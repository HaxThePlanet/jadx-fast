package i.b.m0.e.e;

import i.b.j0.b;
import i.b.l0.n;
import i.b.m0.a.c;
import i.b.m0.a.d;
import i.b.m0.b.b;
import i.b.r;
import i.b.t0.b;
import i.b.w;
import i.b.y;
import io.reactivex.exceptions.a;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes3.dex */
public final class i2<T, R>  extends i.b.m0.e.e.a<T, R> {

    final n<? super r<T>, ? extends w<R>> b;

    static final class a implements y<T> {

        final b<T> a;
        final AtomicReference<b> b;
        a(b<T> b, AtomicReference<b> atomicReference2) {
            super();
            this.a = b;
            this.b = atomicReference2;
        }

        @Override // i.b.y
        public void onComplete() {
            this.a.onComplete();
        }

        @Override // i.b.y
        public void onError(Throwable throwable) {
            this.a.onError(throwable);
        }

        public void onNext(T t) {
            this.a.onNext(t);
        }

        @Override // i.b.y
        public void onSubscribe(b b) {
            c.setOnce(this.b, b);
        }
    }

    static final class b extends AtomicReference<b> implements y<R>, b {

        private static final long serialVersionUID = 854110278590336484L;
        final y<? super R> downstream;
        b upstream;
        b(y<? super R> y) {
            super();
            this.downstream = y;
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
        public void onError(Throwable throwable) {
            c.dispose(this);
            this.downstream.onError(throwable);
        }

        public void onNext(R r) {
            this.downstream.onNext(r);
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void onSubscribe(b b) {
            Object obj2;
            if (c.validate(this.upstream, b)) {
                this.upstream = b;
                this.downstream.onSubscribe(this);
            }
        }
    }
    public i2(w<T> w, n<? super r<T>, ? extends w<R>> n2) {
        super(w);
        this.b = n2;
    }

    protected void subscribeActual(y<? super R> y) {
        final b bVar = b.e();
        Object apply = this.b.apply(bVar);
        b.e(apply, "The selector returned a null ObservableSource");
        i2.b bVar2 = new i2.b(y);
        (w)apply.subscribe(bVar2);
        i2.a aVar = new i2.a(bVar, bVar2);
        this.a.subscribe(aVar);
    }
}
