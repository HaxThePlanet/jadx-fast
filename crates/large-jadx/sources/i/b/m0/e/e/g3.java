package i.b.m0.e.e;

import i.b.j0.b;
import i.b.m0.a.c;
import i.b.w;
import i.b.y;

/* loaded from: classes3.dex */
public final class g3<T>  extends i.b.m0.e.e.a<T, T> {

    final long b;

    static final class a implements y<T>, b {

        final y<? super T> a;
        long b;
        b c;
        a(y<? super T> y, long l2) {
            super();
            this.a = y;
            this.b = l2;
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
            this.a.onComplete();
        }

        @Override // i.b.y
        public void onError(Throwable throwable) {
            this.a.onError(throwable);
        }

        public void onNext(T t) {
            int i;
            int cmp;
            long l = this.b;
            if (Long.compare(l, i2) != 0) {
                this.b = l -= cmp;
            } else {
                this.a.onNext(t);
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
    public g3(w<T> w, long l2) {
        super(w);
        this.b = l2;
    }

    public void subscribeActual(y<? super T> y) {
        g3.a aVar = new g3.a(y, this.b, obj3);
        this.a.subscribe(aVar);
    }
}
