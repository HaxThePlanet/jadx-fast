package i.b.m0.e.e;

import i.b.j0.b;
import i.b.m0.a.c;
import i.b.w;
import i.b.y;
import i.b.z;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: ObservableSubscribeOn.java */
/* loaded from: classes3.dex */
public final class l3<T> extends a<T, T> {

    final z b;

    final class b implements Runnable {

        private final l3.a<T> a;
        final /* synthetic */ l3 b;
        b(l3.a aVar) {
            this.b = l3Var;
            super();
            this.a = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.b.a.subscribe(this.a);
        }
    }

    static final class a<T> extends AtomicReference<b> implements y<T>, b {

        private static final long serialVersionUID = 8094547886072529208L;
        final y<? super T> downstream;
        final AtomicReference<b> upstream = new AtomicReference<>();
        a(y<? super T> yVar) {
            super();
            this.downstream = yVar;
            final AtomicReference atomicReference = new AtomicReference();
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        void a(b bVar) {
            c.setOnce(this, bVar);
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
        public void onError(Throwable th) {
            this.downstream.onError(th);
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void onNext(T t) {
            this.downstream.onNext(t);
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void onSubscribe(b bVar) {
            c.setOnce(this.upstream, bVar);
        }
    }
    public l3(w<T> wVar, z zVar) {
        super(wVar);
        this.b = zVar;
    }

    @Override // i.b.m0.e.e.a
    public void subscribeActual(y<? super T> yVar) {
        final i.b.m0.e.e.l3.a aVar = new l3.a(yVar);
        yVar.onSubscribe(aVar);
        aVar.a(this.b.c(new l3.b(this, aVar)));
    }
}
