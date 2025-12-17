package i.b.m0.e.e;

import i.b.j0.b;
import i.b.m0.a.c;
import i.b.p0.a;
import i.b.w;
import i.b.y;
import i.b.z;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes3.dex */
public final class d4<T>  extends i.b.m0.e.e.a<T, T> {

    final z b;

    static final class a extends AtomicBoolean implements y<T>, b {

        private static final long serialVersionUID = 1015244841293359600L;
        final y<? super T> downstream;
        final z scheduler;
        b upstream;
        a(y<? super T> y, z z2) {
            super();
            this.downstream = y;
            this.scheduler = z2;
        }

        @Override // java.util.concurrent.atomic.AtomicBoolean
        public void dispose() {
            boolean compareAndSet;
            int aVar;
            if (compareAndSet(false, true)) {
                aVar = new d4.a.a(this);
                this.scheduler.c(aVar);
            }
        }

        @Override // java.util.concurrent.atomic.AtomicBoolean
        public boolean isDisposed() {
            return get();
        }

        @Override // java.util.concurrent.atomic.AtomicBoolean
        public void onComplete() {
            boolean downstream;
            if (!get()) {
                this.downstream.onComplete();
            }
        }

        @Override // java.util.concurrent.atomic.AtomicBoolean
        public void onError(Throwable throwable) {
            if (get()) {
                a.t(throwable);
            }
            this.downstream.onError(throwable);
        }

        public void onNext(T t) {
            boolean downstream;
            if (!get()) {
                this.downstream.onNext(t);
            }
        }

        @Override // java.util.concurrent.atomic.AtomicBoolean
        public void onSubscribe(b b) {
            Object obj2;
            if (c.validate(this.upstream, b)) {
                this.upstream = b;
                this.downstream.onSubscribe(this);
            }
        }
    }
    public d4(w<T> w, z z2) {
        super(w);
        this.b = z2;
    }

    public void subscribeActual(y<? super T> y) {
        d4.a aVar = new d4.a(y, this.b);
        this.a.subscribe(aVar);
    }
}
