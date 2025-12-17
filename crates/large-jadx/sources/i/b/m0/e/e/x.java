package i.b.m0.e.e;

import i.b.j0.b;
import i.b.m0.a.c;
import i.b.n;
import i.b.p;
import i.b.r;
import i.b.w;
import i.b.y;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes3.dex */
public final class x<T>  extends i.b.m0.e.e.a<T, T> {

    final p<? extends T> b;

    static final class a extends AtomicReference<b> implements y<T>, n<T>, b {

        private static final long serialVersionUID = -1953724749712440952L;
        final y<? super T> downstream;
        boolean inMaybe;
        p<? extends T> other;
        a(y<? super T> y, p<? extends T> p2) {
            super();
            this.downstream = y;
            this.other = p2;
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
            y downstream;
            p other;
            if (this.inMaybe) {
                this.downstream.onComplete();
            } else {
                this.inMaybe = true;
                downstream = 0;
                c.replace(this, downstream);
                this.other = downstream;
                this.other.b(this);
            }
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void onError(Throwable throwable) {
            this.downstream.onError(throwable);
        }

        public void onNext(T t) {
            this.downstream.onNext(t);
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void onSubscribe(b b) {
            boolean obj1;
            if (c.setOnce(this, b) && !this.inMaybe) {
                if (!this.inMaybe) {
                    this.downstream.onSubscribe(this);
                }
            }
        }

        public void onSuccess(T t) {
            this.downstream.onNext(t);
            this.downstream.onComplete();
        }
    }
    public x(r<T> r, p<? extends T> p2) {
        super(r);
        this.b = p2;
    }

    protected void subscribeActual(y<? super T> y) {
        x.a aVar = new x.a(y, this.b);
        this.a.subscribe(aVar);
    }
}
