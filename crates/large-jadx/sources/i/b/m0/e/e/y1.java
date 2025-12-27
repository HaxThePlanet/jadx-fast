package i.b.m0.e.e;

import i.b.f;
import i.b.j0.b;
import i.b.m0.j.l;
import i.b.r;
import i.b.w;
import i.b.y;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: ObservableMergeWithCompletable.java */
/* loaded from: classes3.dex */
public final class y1<T> extends a<T, T> {

    final f b;

    static final class a<T> extends AtomicInteger implements y<T>, b {

        private static final long serialVersionUID = -4592979584110982903L;
        final y<? super T> downstream;
        final i.b.m0.j.c error = new c();
        final AtomicReference<b> mainDisposable = new AtomicReference<>();
        volatile boolean mainDone;
        volatile boolean otherDone;
        final y1.a.a otherObserver = new y1$a$a();
        a(y<? super T> yVar) {
            super();
            this.downstream = yVar;
            AtomicReference atomicReference = new AtomicReference();
            i.b.m0.e.e.y1.a.a aVar = new y1.a.a(this);
            i.b.m0.j.c cVar = new c();
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        void a() {
            this.otherDone = true;
            if (this.mainDone) {
                l.a(this.downstream, this, this.error);
            }
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        void b(Throwable th) {
            c.dispose(this.mainDisposable);
            l.c(this.downstream, th, this, this.error);
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
            this.mainDone = true;
            if (this.otherDone) {
                l.a(this.downstream, this, this.error);
            }
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public void onError(Throwable th) {
            c.dispose(this.otherObserver);
            l.c(this.downstream, th, this, this.error);
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public void onNext(T t) {
            l.e(this.downstream, t, this, this.error);
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public void onSubscribe(b bVar) {
            c.setOnce(this.mainDisposable, bVar);
        }
    }
    public y1(r<T> rVar, f fVar) {
        super(rVar);
        this.b = fVar;
    }

    @Override // i.b.m0.e.e.a
    protected void subscribeActual(y<? super T> yVar) {
        i.b.m0.e.e.y1.a aVar = new y1.a(yVar);
        yVar.onSubscribe(aVar);
        this.a.subscribe(aVar);
        this.b.b(aVar.otherObserver);
    }
}
