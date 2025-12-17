package i.b.m0.e.e;

import i.b.j0.b;
import i.b.l0.n;
import i.b.m0.a.c;
import i.b.m0.b.b;
import i.b.o0.e;
import i.b.w;
import i.b.y;
import io.reactivex.exceptions.a;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes3.dex */
public final class c0<T, U>  extends i.b.m0.e.e.a<T, T> {

    final n<? super T, ? extends w<U>> b;

    static final class a implements y<T>, b {

        final y<? super T> a;
        final n<? super T, ? extends w<U>> b;
        b c;
        final AtomicReference<b> v;
        volatile long w;
        boolean x;
        a(y<? super T> y, n<? super T, ? extends w<U>> n2) {
            super();
            AtomicReference atomicReference = new AtomicReference();
            this.v = atomicReference;
            this.a = y;
            this.b = n2;
        }

        void a(long l, T t2) {
            int obj3;
            if (Long.compare(l, l2) == 0) {
                this.a.onNext(obj5);
            }
        }

        @Override // i.b.y
        public void dispose() {
            this.c.dispose();
            c.dispose(this.v);
        }

        @Override // i.b.y
        public boolean isDisposed() {
            return this.c.isDisposed();
        }

        @Override // i.b.y
        public void onComplete() {
            Object obj;
            if (this.x) {
            }
            this.x = true;
            obj = this.v.get();
            if ((c0.a.a)(b)obj != c.DISPOSED && (c0.a.a)(b)obj != null) {
                if ((c0.a.a)(c0.a.a)(b)obj != null) {
                    (c0.a.a)(c0.a.a)(b)obj.c();
                }
                c.dispose(this.v);
                this.a.onComplete();
            }
        }

        @Override // i.b.y
        public void onError(Throwable throwable) {
            c.dispose(this.v);
            this.a.onError(throwable);
        }

        public void onNext(T t) {
            if (this.x) {
            }
            l += i2;
            this.w = i;
            Object obj = this.v.get();
            if ((b)obj != null) {
                (b)obj.dispose();
            }
            Object apply = this.b.apply(t);
            b.e(apply, "The ObservableSource supplied is null");
            c0.a.a aVar = new c0.a.a(this, i, obj1, t);
            if (this.v.compareAndSet(obj, aVar)) {
                (w)apply.subscribe(aVar);
            }
        }

        @Override // i.b.y
        public void onSubscribe(b b) {
            Object obj2;
            if (c.validate(this.c, b)) {
                this.c = b;
                this.a.onSubscribe(this);
            }
        }
    }
    public c0(w<T> w, n<? super T, ? extends w<U>> n2) {
        super(w);
        this.b = n2;
    }

    public void subscribeActual(y<? super T> y) {
        e eVar = new e(y);
        c0.a aVar = new c0.a(eVar, this.b);
        this.a.subscribe(aVar);
    }
}
