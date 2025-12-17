package i.b.m0.e.e;

import i.b.j0.b;
import i.b.m0.a.c;
import i.b.w;
import i.b.y;
import i.b.z;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes3.dex */
public final class l3<T>  extends i.b.m0.e.e.a<T, T> {

    final z b;

    final class b implements Runnable {

        private final i.b.m0.e.e.l3.a<T> a;
        final i.b.m0.e.e.l3 b;
        b(i.b.m0.e.e.l3 l3, i.b.m0.e.e.l3.a l3$a2) {
            this.b = l3;
            super();
            this.a = a2;
        }

        @Override // java.lang.Runnable
        public void run() {
            l3Var.a.subscribe(this.a);
        }
    }

    static final class a extends AtomicReference<b> implements y<T>, b {

        private static final long serialVersionUID = 8094547886072529208L;
        final y<? super T> downstream;
        final AtomicReference<b> upstream;
        a(y<? super T> y) {
            super();
            this.downstream = y;
            AtomicReference obj1 = new AtomicReference();
            this.upstream = obj1;
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        void a(b b) {
            c.setOnce(this, b);
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void dispose() {
            c.dispose(this.upstream);
            c.dispose(this);
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
        public void onError(Throwable throwable) {
            this.downstream.onError(throwable);
        }

        public void onNext(T t) {
            this.downstream.onNext(t);
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void onSubscribe(b b) {
            c.setOnce(this.upstream, b);
        }
    }
    public l3(w<T> w, z z2) {
        super(w);
        this.b = z2;
    }

    public void subscribeActual(y<? super T> y) {
        l3.a aVar = new l3.a(y);
        y.onSubscribe(aVar);
        l3.b bVar = new l3.b(this, aVar);
        aVar.a(this.b.c(bVar));
    }
}
