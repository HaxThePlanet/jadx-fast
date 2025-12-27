package i.b.m0.e.e;

import i.b.l0.n;
import i.b.m0.a.c;
import i.b.o0.e;
import i.b.w;
import i.b.y;
import io.reactivex.exceptions.a;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: ObservableDebounce.java */
/* loaded from: classes3.dex */
public final class c0<T, U> extends a<T, T> {

    final n<? super T, ? extends w<U>> b;

    static final class a<T, U> implements y<T>, i.b.j0.b {

        final y<? super T> a;
        final n<? super T, ? extends w<U>> b;
        i.b.j0.b c;
        final AtomicReference<i.b.j0.b> v = new AtomicReference<>();
        volatile long w;
        boolean x;
        a(y<? super T> yVar, n<? super T, ? extends w<U>> nVar) {
            super();
            final AtomicReference atomicReference = new AtomicReference();
            this.a = yVar;
            this.b = nVar;
        }

        void a(long j, T t) {
            if (j == this.w) {
                this.a.onNext(t);
            }
        }

        public void dispose() {
            this.c.dispose();
            c.dispose(this.v);
        }

        public boolean isDisposed() {
            return this.c.isDisposed();
        }

        public void onComplete() {
            if (this.x) {
                return;
            }
            this.x = true;
            Object obj = this.v.get();
            if (obj != c.DISPOSED) {
                if (obj != null) {
                    obj.c();
                }
                c.dispose(this.v);
                this.a.onComplete();
            }
        }

        public void onError(Throwable th) {
            c.dispose(this.v);
            this.a.onError(th);
        }

        public void onNext(T t) {
            if (this.x) {
                return;
            }
            this.w++;
            Object obj = this.v.get();
            if (obj != null) {
                obj.dispose();
            }
            try {
                Object apply = this.b.apply(t);
                b.e(apply, "The ObservableSource supplied is null");
            } catch (Throwable th) {
                a.b(th);
                dispose();
                this.a.onError(th);
                return;
            }
            i.b.m0.e.e.c0.a.a aVar = new c0.a.a(this, l2, r1, th);
            if (this.v.compareAndSet(obj, aVar)) {
                apply.subscribe(aVar);
            }
        }

        public void onSubscribe(i.b.j0.b bVar) {
            if (c.validate(this.c, bVar)) {
                this.c = bVar;
                this.a.onSubscribe(this);
            }
        }
    }
    public c0(w<T> wVar, n<? super T, ? extends w<U>> nVar) {
        super(wVar);
        this.b = nVar;
    }

    @Override // i.b.m0.e.e.a
    public void subscribeActual(y<? super T> yVar) {
        this.a.subscribe(new c0.a(new e(yVar), this.b));
    }
}
