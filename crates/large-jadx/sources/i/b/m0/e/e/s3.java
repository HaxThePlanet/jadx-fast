package i.b.m0.e.e;

import i.b.j0.b;
import i.b.m0.j.l;
import i.b.w;
import i.b.y;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: ObservableTakeUntil.java */
/* loaded from: classes3.dex */
public final class s3<T, U> extends a<T, T> {

    final w<? extends U> b;

    static final class a<T, U> extends AtomicInteger implements y<T>, b {

        private static final long serialVersionUID = 1418547743690811973L;
        final y<? super T> downstream;
        final i.b.m0.j.c error = new c();
        final s3.a.a<T, U> otherObserver = new s3$a$a<>();
        final AtomicReference<b> upstream = new AtomicReference<>();
        a(y<? super T> yVar) {
            super();
            this.downstream = yVar;
            AtomicReference atomicReference = new AtomicReference();
            i.b.m0.e.e.s3.a.a aVar = new s3.a.a(this);
            i.b.m0.j.c cVar = new c();
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        void a() {
            c.dispose(this.upstream);
            l.a(this.downstream, this, this.error);
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        void b(Throwable th) {
            c.dispose(this.upstream);
            l.c(this.downstream, th, this, this.error);
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
            c.setOnce(this.upstream, bVar);
        }
    }
    public s3(w<T> wVar, w<? extends U> wVar2) {
        super(wVar);
        this.b = wVar2;
    }

    @Override // i.b.m0.e.e.a
    public void subscribeActual(y<? super T> yVar) {
        final i.b.m0.e.e.s3.a aVar = new s3.a(yVar);
        yVar.onSubscribe(aVar);
        this.b.subscribe(aVar.otherObserver);
        this.a.subscribe(aVar);
    }
}
