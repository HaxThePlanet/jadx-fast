package i.b.m0.e.e;

import i.b.j0.b;
import i.b.m0.a.c;
import i.b.m0.j.c;
import i.b.m0.j.l;
import i.b.w;
import i.b.y;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes3.dex */
public final class s3<T, U>  extends i.b.m0.e.e.a<T, T> {

    final w<? extends U> b;

    static final class a extends AtomicInteger implements y<T>, b {

        private static final long serialVersionUID = 1418547743690811973L;
        final y<? super T> downstream;
        final c error;
        final i.b.m0.e.e.s3.a.a<T, U> otherObserver;
        final AtomicReference<b> upstream;
        a(y<? super T> y) {
            super();
            this.downstream = y;
            AtomicReference obj1 = new AtomicReference();
            this.upstream = obj1;
            obj1 = new s3.a.a(this);
            this.otherObserver = obj1;
            obj1 = new c();
            this.error = obj1;
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        void a() {
            c.dispose(this.upstream);
            l.a(this.downstream, this, this.error);
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        void b(Throwable throwable) {
            c.dispose(this.upstream);
            l.c(this.downstream, throwable, this, this.error);
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public void dispose() {
            c.dispose(this.upstream);
            c.dispose(this.otherObserver);
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public boolean isDisposed() {
            return c.isDisposed((b)this.upstream.get());
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public void onComplete() {
            c.dispose(this.otherObserver);
            l.a(this.downstream, this, this.error);
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public void onError(Throwable throwable) {
            c.dispose(this.otherObserver);
            l.c(this.downstream, throwable, this, this.error);
        }

        public void onNext(T t) {
            l.e(this.downstream, t, this, this.error);
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public void onSubscribe(b b) {
            c.setOnce(this.upstream, b);
        }
    }
    public s3(w<T> w, w<? extends U> w2) {
        super(w);
        this.b = w2;
    }

    public void subscribeActual(y<? super T> y) {
        s3.a aVar = new s3.a(y);
        y.onSubscribe(aVar);
        this.b.subscribe(aVar.otherObserver);
        this.a.subscribe(aVar);
    }
}
