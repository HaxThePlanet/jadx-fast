package i.b.m0.e.e;

import i.b.f;
import i.b.j0.b;
import i.b.m0.a.c;
import i.b.m0.j.c;
import i.b.m0.j.l;
import i.b.r;
import i.b.w;
import i.b.y;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes3.dex */
public final class y1<T>  extends i.b.m0.e.e.a<T, T> {

    final f b;

    static final class a extends AtomicInteger implements y<T>, b {

        private static final long serialVersionUID = -4592979584110982903L;
        final y<? super T> downstream;
        final c error;
        final AtomicReference<b> mainDisposable;
        volatile boolean mainDone;
        volatile boolean otherDone;
        final i.b.m0.e.e.y1.a.a otherObserver;
        a(y<? super T> y) {
            super();
            this.downstream = y;
            AtomicReference obj1 = new AtomicReference();
            this.mainDisposable = obj1;
            obj1 = new y1.a.a(this);
            this.otherObserver = obj1;
            obj1 = new c();
            this.error = obj1;
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        void a() {
            boolean mainDone;
            c error;
            this.otherDone = true;
            if (this.mainDone) {
                l.a(this.downstream, this, this.error);
            }
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        void b(Throwable throwable) {
            c.dispose(this.mainDisposable);
            l.c(this.downstream, throwable, this, this.error);
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public void dispose() {
            c.dispose(this.mainDisposable);
            c.dispose(this.otherObserver);
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public boolean isDisposed() {
            return c.isDisposed((b)this.mainDisposable.get());
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public void onComplete() {
            boolean otherDone;
            c error;
            this.mainDone = true;
            if (this.otherDone) {
                l.a(this.downstream, this, this.error);
            }
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
            c.setOnce(this.mainDisposable, b);
        }
    }
    public y1(r<T> r, f f2) {
        super(r);
        this.b = f2;
    }

    protected void subscribeActual(y<? super T> y) {
        y1.a aVar = new y1.a(y);
        y.onSubscribe(aVar);
        this.a.subscribe(aVar);
        this.b.b(aVar.otherObserver);
    }
}
