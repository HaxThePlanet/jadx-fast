package i.b.m0.e.e;

import i.b.a0;
import i.b.d0;
import i.b.j0.b;
import i.b.m0.a.c;
import i.b.w;
import i.b.y;
import java.util.NoSuchElementException;

/* loaded from: classes3.dex */
public final class t1<T>  extends a0<T> {

    final w<T> a;
    final T b;

    static final class a implements y<T>, b {

        final d0<? super T> a;
        final T b;
        b c;
        T v;
        a(d0<? super T> d0, T t2) {
            super();
            this.a = d0;
            this.b = t2;
        }

        @Override // i.b.y
        public void dispose() {
            this.c.dispose();
            this.c = c.DISPOSED;
        }

        @Override // i.b.y
        public boolean isDisposed() {
            int i;
            i = this.c == c.DISPOSED ? 1 : 0;
            return i;
        }

        @Override // i.b.y
        public void onComplete() {
            Object obj;
            Object noSuchElementException;
            this.c = c.DISPOSED;
            obj = this.v;
            if (obj != null) {
                this.v = 0;
                this.a.onSuccess(obj);
            } else {
                obj = this.b;
                if (obj != null) {
                    this.a.onSuccess(obj);
                } else {
                    noSuchElementException = new NoSuchElementException();
                    this.a.onError(noSuchElementException);
                }
            }
        }

        @Override // i.b.y
        public void onError(Throwable throwable) {
            this.c = c.DISPOSED;
            this.v = 0;
            this.a.onError(throwable);
        }

        public void onNext(T t) {
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
    public t1(w<T> w, T t2) {
        super();
        this.a = w;
        this.b = t2;
    }

    protected void subscribeActual(d0<? super T> d0) {
        t1.a aVar = new t1.a(d0, this.b);
        this.a.subscribe(aVar);
    }
}
