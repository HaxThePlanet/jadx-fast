package i.b.m0.e.e;

import i.b.j0.b;
import i.b.m0.a.c;
import i.b.s0.b;
import i.b.w;
import i.b.y;
import i.b.z;
import java.util.concurrent.TimeUnit;

/* loaded from: classes3.dex */
public final class x3<T>  extends i.b.m0.e.e.a<T, b<T>> {

    final z b;
    final TimeUnit c;

    static final class a implements y<T>, b {

        final y<? super b<T>> a;
        final TimeUnit b;
        final z c;
        long v;
        b w;
        a(y<? super b<T>> y, TimeUnit timeUnit2, z z3) {
            super();
            this.a = y;
            this.c = z3;
            this.b = timeUnit2;
        }

        @Override // i.b.y
        public void dispose() {
            this.w.dispose();
        }

        @Override // i.b.y
        public boolean isDisposed() {
            return this.w.isDisposed();
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
            final TimeUnit time = this.b;
            long l = this.c.b(time);
            this.v = l;
            b bVar = new b(t, l -= l2, time, this.b);
            this.a.onNext(bVar);
        }

        @Override // i.b.y
        public void onSubscribe(b b) {
            boolean validate;
            Object obj3;
            if (c.validate(this.w, b)) {
                this.w = b;
                this.v = this.c.b(this.b);
                this.a.onSubscribe(this);
            }
        }
    }
    public x3(w<T> w, TimeUnit timeUnit2, z z3) {
        super(w);
        this.b = z3;
        this.c = timeUnit2;
    }

    public void subscribeActual(y<? super b<T>> y) {
        x3.a aVar = new x3.a(y, this.c, this.b);
        this.a.subscribe(aVar);
    }
}
