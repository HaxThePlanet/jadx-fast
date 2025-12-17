package i.b.m0.e.e;

import i.b.a0;
import i.b.d0;
import i.b.j0.b;
import i.b.m0.a.c;
import i.b.m0.c.d;
import i.b.p0.a;
import i.b.r;
import i.b.w;
import i.b.y;
import java.util.NoSuchElementException;

/* loaded from: classes3.dex */
public final class r0<T>  extends a0<T> implements d<T> {

    final w<T> a;
    final long b;
    final T c;

    static final class a implements y<T>, b {

        final d0<? super T> a;
        final long b;
        final T c;
        b v;
        long w;
        boolean x;
        a(d0<? super T> d0, long l2, T t3) {
            super();
            this.a = d0;
            this.b = l2;
            this.c = obj4;
        }

        @Override // i.b.y
        public void dispose() {
            this.v.dispose();
        }

        @Override // i.b.y
        public boolean isDisposed() {
            return this.v.isDisposed();
        }

        @Override // i.b.y
        public void onComplete() {
            boolean z;
            Object noSuchElementException;
            if (!this.x) {
                this.x = true;
                z = this.c;
                if (z != null) {
                    this.a.onSuccess(z);
                } else {
                    noSuchElementException = new NoSuchElementException();
                    this.a.onError(noSuchElementException);
                }
            }
        }

        @Override // i.b.y
        public void onError(Throwable throwable) {
            if (this.x) {
                a.t(throwable);
            }
            this.x = true;
            this.a.onError(throwable);
        }

        public void onNext(T t) {
            if (this.x) {
            }
            long l = this.w;
            if (Long.compare(l, l2) == 0) {
                this.x = true;
                this.v.dispose();
                this.a.onSuccess(t);
            }
            this.w = l += i3;
        }

        @Override // i.b.y
        public void onSubscribe(b b) {
            Object obj2;
            if (c.validate(this.v, b)) {
                this.v = b;
                this.a.onSubscribe(this);
            }
        }
    }
    public r0(w<T> w, long l2, T t3) {
        super();
        this.a = w;
        this.b = l2;
        this.c = obj4;
    }

    public r<T> a() {
        super(this.a, this.b, obj3, this.c, 1);
        return a.n(p0Var2);
    }

    public void subscribeActual(d0<? super T> d0) {
        r0.a aVar = new r0.a(d0, this.b, obj3, this.c);
        this.a.subscribe(aVar);
    }
}
