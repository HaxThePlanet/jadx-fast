package i.b.m0.e.e;

import i.b.j0.b;
import i.b.l0.c;
import i.b.m0.a.c;
import i.b.m0.b.b;
import i.b.o0.e;
import i.b.w;
import i.b.y;
import io.reactivex.exceptions.a;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes3.dex */
public final class k4<T, U, R>  extends i.b.m0.e.e.a<T, R> {

    final c<? super T, ? super U, ? extends R> b;
    final w<? extends U> c;

    static final class a extends AtomicReference<U> implements y<T>, b {

        private static final long serialVersionUID = -312246233408980075L;
        final c<? super T, ? super U, ? extends R> combiner;
        final y<? super R> downstream;
        final AtomicReference<b> other;
        final AtomicReference<b> upstream;
        a(y<? super R> y, c<? super T, ? super U, ? extends R> c2) {
            super();
            AtomicReference atomicReference = new AtomicReference();
            this.upstream = atomicReference;
            AtomicReference atomicReference2 = new AtomicReference();
            this.other = atomicReference2;
            this.downstream = y;
            this.combiner = c2;
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void a(Throwable throwable) {
            c.dispose(this.upstream);
            this.downstream.onError(throwable);
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public boolean b(b b) {
            return c.setOnce(this.other, b);
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void dispose() {
            c.dispose(this.upstream);
            c.dispose(this.other);
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public boolean isDisposed() {
            return c.isDisposed((b)this.upstream.get());
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void onComplete() {
            c.dispose(this.other);
            this.downstream.onComplete();
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void onError(Throwable throwable) {
            c.dispose(this.other);
            this.downstream.onError(throwable);
        }

        public void onNext(T t) {
            Object downstream;
            c combiner;
            Object obj3;
            downstream = get();
            if (downstream != null) {
                obj3 = this.combiner.apply(t, downstream);
                b.e(obj3, "The combiner returned a null value");
                this.downstream.onNext(obj3);
            }
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void onSubscribe(b b) {
            c.setOnce(this.upstream, b);
        }
    }

    final class b implements y<U> {

        private final i.b.m0.e.e.k4.a<T, U, R> a;
        b(i.b.m0.e.e.k4 k4, i.b.m0.e.e.k4.a k4$a2) {
            super();
            this.a = a2;
        }

        @Override // i.b.y
        public void onComplete() {
        }

        @Override // i.b.y
        public void onError(Throwable throwable) {
            this.a.a(throwable);
        }

        public void onNext(U u) {
            this.a.lazySet(u);
        }

        @Override // i.b.y
        public void onSubscribe(b b) {
            this.a.b(b);
        }
    }
    public k4(w<T> w, c<? super T, ? super U, ? extends R> c2, w<? extends U> w3) {
        super(w);
        this.b = c2;
        this.c = w3;
    }

    public void subscribeActual(y<? super R> y) {
        e eVar = new e(y);
        k4.a obj3 = new k4.a(eVar, this.b);
        eVar.onSubscribe(obj3);
        k4.b bVar = new k4.b(this, obj3);
        this.c.subscribe(bVar);
        this.a.subscribe(obj3);
    }
}
