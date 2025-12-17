package i.b.m0.e.e;

import i.b.j0.b;
import i.b.m0.a.c;
import i.b.w;
import i.b.y;

/* loaded from: classes3.dex */
public final class z<T>  extends i.b.m0.e.e.a<T, Long> {

    static final class a implements y<Object>, b {

        final y<? super Long> a;
        b b;
        long c;
        a(y<? super Long> y) {
            super();
            this.a = y;
        }

        @Override // i.b.y
        public void dispose() {
            this.b.dispose();
        }

        @Override // i.b.y
        public boolean isDisposed() {
            return this.b.isDisposed();
        }

        @Override // i.b.y
        public void onComplete() {
            this.a.onNext(Long.valueOf(this.c));
            this.a.onComplete();
        }

        @Override // i.b.y
        public void onError(Throwable throwable) {
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
    public z(w<T> w) {
        super(w);
    }

    public void subscribeActual(y<? super Long> y) {
        z.a aVar = new z.a(y);
        this.a.subscribe(aVar);
    }
}
