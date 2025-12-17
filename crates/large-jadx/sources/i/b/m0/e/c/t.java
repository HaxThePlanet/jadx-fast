package i.b.m0.e.c;

import i.b.j0.b;
import i.b.m0.a.c;
import i.b.n;
import i.b.p;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes3.dex */
public final class t<T>  extends i.b.m0.e.c.a<T, T> {

    final p<? extends T> b;

    static final class a extends AtomicReference<b> implements n<T>, b {

        private static final long serialVersionUID = -2223459372976438024L;
        final n<? super T> downstream;
        final p<? extends T> other;
        a(n<? super T> n, p<? extends T> p2) {
            super();
            this.downstream = n;
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
            Object compareAndSet;
            c dISPOSED;
            n downstream;
            compareAndSet = get();
            if (compareAndSet != c.DISPOSED && compareAndSet((b)compareAndSet, 0)) {
                if (compareAndSet(compareAndSet, 0)) {
                    dISPOSED = new t.a.a(this.downstream, this);
                    this.other.b(dISPOSED);
                }
            }
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void onError(Throwable throwable) {
            this.downstream.onError(throwable);
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void onSubscribe(b b) {
            boolean obj1;
            if (c.setOnce(this, b)) {
                this.downstream.onSubscribe(this);
            }
        }

        public void onSuccess(T t) {
            this.downstream.onSuccess(t);
        }
    }
    public t(p<T> p, p<? extends T> p2) {
        super(p);
        this.b = p2;
    }

    protected void w(n<? super T> n) {
        t.a aVar = new t.a(n, this.b);
        this.a.b(aVar);
    }
}
