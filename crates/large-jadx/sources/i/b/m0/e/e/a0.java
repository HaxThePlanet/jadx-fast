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

/* loaded from: classes3.dex */
public final class a0<T>  extends a0<Long> implements d<Long> {

    final w<T> a;

    static final class a implements y<Object>, b {

        final d0<? super Long> a;
        b b;
        long c;
        a(d0<? super Long> d0) {
            super();
            this.a = d0;
        }

        @Override // i.b.y
        public void dispose() {
            this.b.dispose();
            this.b = c.DISPOSED;
        }

        @Override // i.b.y
        public boolean isDisposed() {
            return this.b.isDisposed();
        }

        @Override // i.b.y
        public void onComplete() {
            this.b = c.DISPOSED;
            this.a.onSuccess(Long.valueOf(this.c));
        }

        @Override // i.b.y
        public void onError(Throwable throwable) {
            this.b = c.DISPOSED;
            this.a.onError(throwable);
        }

        @Override // i.b.y
        public void onNext(Object object) {
            this.c = l += i2;
        }

        @Override // i.b.y
        public void onSubscribe(b b) {
            Object obj2;
            if (c.validate(this.b, b)) {
                this.b = b;
                this.a.onSubscribe(this);
            }
        }
    }
    public a0(w<T> w) {
        super();
        this.a = w;
    }

    public r<Long> a() {
        z zVar = new z(this.a);
        return a.n(zVar);
    }

    public void subscribeActual(d0<? super Long> d0) {
        a0.a aVar = new a0.a(d0);
        this.a.subscribe(aVar);
    }
}
