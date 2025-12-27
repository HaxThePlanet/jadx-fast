package i.b.m0.e.e;

import i.b.o0.e;
import i.b.w;
import i.b.y;
import io.reactivex.exceptions.a;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: ObservableWithLatestFrom.java */
/* loaded from: classes3.dex */
public final class k4<T, U, R> extends a<T, R> {

    final i.b.l0.c<? super T, ? super U, ? extends R> b;
    final w<? extends U> c;

    static final class a<T, U, R> extends AtomicReference<U> implements y<T>, i.b.j0.b {

        private static final long serialVersionUID = -312246233408980075L;
        final i.b.l0.c<? super T, ? super U, ? extends R> combiner;
        final y<? super R> downstream;
        final AtomicReference<i.b.j0.b> other = new AtomicReference<>();
        final AtomicReference<i.b.j0.b> upstream = new AtomicReference<>();
        a(y<? super R> yVar, i.b.l0.c<? super T, ? super U, ? extends R> cVar) {
            super();
            AtomicReference atomicReference = new AtomicReference();
            AtomicReference atomicReference2 = new AtomicReference();
            this.downstream = yVar;
            this.combiner = cVar;
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void a(Throwable th) {
            c.dispose(this.upstream);
            this.downstream.onError(th);
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public boolean b(i.b.j0.b bVar) {
            return c.setOnce(this.other, bVar);
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void dispose() {
            c.dispose(this.upstream);
            c.dispose(this.other);
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public boolean isDisposed() {
            return c.isDisposed((b)this.upstream.get());
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void onComplete() {
            c.dispose(this.other);
            this.downstream.onComplete();
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void onError(Throwable th) {
            c.dispose(this.other);
            this.downstream.onError(th);
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void onNext(T t) {
            Object obj = get();
            if (obj != null) {
                try {
                    Object apply = this.combiner.apply(t, obj);
                    b.e(apply, "The combiner returned a null value");
                } catch (Throwable th) {
                    a.b(th);
                    dispose();
                    this.downstream.onError(th);
                }
                this.downstream.onNext(apply);
            }
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void onSubscribe(i.b.j0.b bVar) {
            c.setOnce(this.upstream, bVar);
        }
    }

    final class b implements y<U> {

        private final k4.a<T, U, R> a;
        b(k4.a aVar) {
            super();
            this.a = aVar;
        }

        public void onError(Throwable th) {
            this.a.a(th);
        }

        public void onNext(U u) {
            this.a.lazySet(u);
        }

        public void onSubscribe(i.b.j0.b bVar) {
            this.a.b(bVar);
        }

        public void onComplete() {
        }
    }
    public k4(w<T> wVar, i.b.l0.c<? super T, ? super U, ? extends R> cVar, w<? extends U> wVar2) {
        super(wVar);
        this.b = cVar;
        this.c = wVar2;
    }

    @Override // i.b.m0.e.e.a
    public void subscribeActual(y<? super R> yVar) {
        e eVar = new e(yVar);
        final i.b.m0.e.e.k4.a aVar = new k4.a(eVar, this.b);
        eVar.onSubscribe(aVar);
        this.c.subscribe(new k4.b(this, aVar));
        this.a.subscribe(aVar);
    }
}
