package i.b.m0.e.b;

import i.b.a0;
import i.b.d0;
import i.b.h;
import i.b.j0.b;
import i.b.k;
import i.b.m0.c.b;
import i.b.m0.i.g;
import i.b.p0.a;
import java.util.NoSuchElementException;
import m.c.c;

/* loaded from: classes3.dex */
public final class k0<T>  extends a0<T> implements b<T> {

    final h<T> a;
    final T b;

    static final class a implements k<T>, b {

        final d0<? super T> a;
        final T b;
        c c;
        boolean v;
        T w;
        a(d0<? super T> d0, T t2) {
            super();
            this.a = d0;
            this.b = t2;
        }

        @Override // i.b.k
        public void dispose() {
            this.c.cancel();
            this.c = g.CANCELLED;
        }

        @Override // i.b.k
        public boolean isDisposed() {
            int i;
            i = this.c == g.CANCELLED ? 1 : 0;
            return i;
        }

        @Override // i.b.k
        public void onComplete() {
            Object obj;
            Object noSuchElementException;
            if (this.v) {
            }
            this.v = true;
            this.c = g.CANCELLED;
            this.w = 0;
            if (this.w == null) {
                obj = this.b;
            }
            if (obj != null) {
                this.a.onSuccess(obj);
            } else {
                noSuchElementException = new NoSuchElementException();
                this.a.onError(noSuchElementException);
            }
        }

        @Override // i.b.k
        public void onError(Throwable throwable) {
            if (this.v) {
                a.t(throwable);
            }
            this.v = true;
            this.c = g.CANCELLED;
            this.a.onError(throwable);
        }

        public void onNext(T t) {
            if (this.v) {
            }
            if (this.w != null) {
                this.v = true;
                this.c.cancel();
                this.c = g.CANCELLED;
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Sequence contains more than one element!");
                this.a.onError(illegalArgumentException);
            }
            this.w = t;
        }

        @Override // i.b.k
        public void onSubscribe(c c) {
            boolean validate;
            if (g.validate(this.c, c)) {
                this.c = c;
                this.a.onSubscribe(this);
                c.request(Long.MAX_VALUE);
            }
        }
    }
    public k0(h<T> h, T t2) {
        super();
        this.a = h;
        this.b = t2;
    }

    public h<T> c() {
        j0 j0Var = new j0(this.a, this.b, 1);
        return a.l(j0Var);
    }

    protected void subscribeActual(d0<? super T> d0) {
        k0.a aVar = new k0.a(d0, this.b);
        this.a.b0(aVar);
    }
}
