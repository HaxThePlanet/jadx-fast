package i.b.m0.e.e;

import i.b.d0;
import i.b.g0;
import i.b.j0.b;
import i.b.m0.a.c;
import i.b.r;
import i.b.w;
import i.b.y;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes3.dex */
public final class y<T>  extends i.b.m0.e.e.a<T, T> {

    final g0<? extends T> b;

    static final class a extends AtomicReference<b> implements y<T>, d0<T>, b {

        private static final long serialVersionUID = -1953724749712440952L;
        final y<? super T> downstream;
        boolean inSingle;
        g0<? extends T> other;
        a(y<? super T> y, g0<? extends T> g02) {
            super();
            this.downstream = y;
            this.other = g02;
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
            this.inSingle = true;
            int i2 = 0;
            c.replace(this, i2);
            this.other = i2;
            this.other.subscribe(this);
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
            if (c.setOnce(this, b) && !this.inSingle) {
                if (!this.inSingle) {
                    this.downstream.onSubscribe(this);
                }
            }
        }

        public void onSuccess(T t) {
            this.downstream.onNext(t);
            this.downstream.onComplete();
        }
    }
    public y(r<T> r, g0<? extends T> g02) {
        super(r);
        this.b = g02;
    }

    protected void subscribeActual(y<? super T> y) {
        y.a aVar = new y.a(y, this.b);
        this.a.subscribe(aVar);
    }
}
