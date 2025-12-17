package i.b.m0.e.e;

import i.b.a0;
import i.b.d0;
import i.b.j0.b;
import i.b.m0.a.c;
import i.b.p0.a;
import i.b.w;
import i.b.y;
import java.util.NoSuchElementException;

/* loaded from: classes3.dex */
public final class f3<T>  extends a0<T> {

    final w<? extends T> a;
    final T b;

    static final class a implements y<T>, b {

        final d0<? super T> a;
        final T b;
        b c;
        T v;
        boolean w;
        a(d0<? super T> d0, T t2) {
            super();
            this.a = d0;
            this.b = t2;
        }

        @Override // i.b.y
        public void dispose() {
            this.c.dispose();
        }

        @Override // i.b.y
        public boolean isDisposed() {
            return this.c.isDisposed();
        }

        @Override // i.b.y
        public void onComplete() {
            Object obj;
            Object noSuchElementException;
            if (this.w) {
            }
            this.w = true;
            this.v = 0;
            if (this.v == null) {
                obj = this.b;
            }
            if (obj != null) {
                this.a.onSuccess(obj);
            } else {
                noSuchElementException = new NoSuchElementException();
                this.a.onError(noSuchElementException);
            }
        }

        @Override // i.b.y
        public void onError(Throwable throwable) {
            if (this.w) {
                a.t(throwable);
            }
            this.w = true;
            this.a.onError(throwable);
        }

        public void onNext(T t) {
            if (this.w) {
            }
            if (this.v != null) {
                this.w = true;
                this.c.dispose();
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Sequence contains more than one element!");
                this.a.onError(illegalArgumentException);
            }
            this.v = t;
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
    public f3(w<? extends T> w, T t2) {
        super();
        this.a = w;
        this.b = t2;
    }

    public void subscribeActual(d0<? super T> d0) {
        f3.a aVar = new f3.a(d0, this.b);
        this.a.subscribe(aVar);
    }
}
