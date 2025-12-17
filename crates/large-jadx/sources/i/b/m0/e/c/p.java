package i.b.m0.e.c;

import i.b.j0.b;
import i.b.m0.a.c;
import i.b.n;
import i.b.p;
import i.b.z;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes3.dex */
public final class p<T>  extends i.b.m0.e.c.a<T, T> {

    final z b;

    static final class a extends AtomicReference<b> implements n<T>, b, Runnable {

        private static final long serialVersionUID = 8571289934935992137L;
        final n<? super T> downstream;
        Throwable error;
        final z scheduler;
        T value;
        a(n<? super T> n, z z2) {
            super();
            this.downstream = n;
            this.scheduler = z2;
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
            c.replace(this, this.scheduler.c(this));
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void onError(Throwable throwable) {
            this.error = throwable;
            c.replace(this, this.scheduler.c(this));
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void onSubscribe(b b) {
            boolean obj1;
            if (c.setOnce(this, b)) {
                this.downstream.onSubscribe(this);
            }
        }

        public void onSuccess(T t) {
            this.value = t;
            c.replace(this, this.scheduler.c(this));
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void run() {
            Object downstream;
            n downstream2;
            downstream = this.error;
            downstream2 = 0;
            if (downstream != null) {
                this.error = downstream2;
                this.downstream.onError(downstream);
            } else {
                downstream = this.value;
                if (downstream != null) {
                    this.value = downstream2;
                    this.downstream.onSuccess(downstream);
                } else {
                    this.downstream.onComplete();
                }
            }
        }
    }
    public p(p<T> p, z z2) {
        super(p);
        this.b = z2;
    }

    protected void w(n<? super T> n) {
        p.a aVar = new p.a(n, this.b);
        this.a.b(aVar);
    }
}
