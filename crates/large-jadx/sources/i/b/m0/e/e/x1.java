package i.b.m0.e.e;

import i.b.j0.b;
import i.b.m0.a.c;
import i.b.q;
import i.b.w;
import i.b.y;

/* loaded from: classes3.dex */
public final class x1<T>  extends i.b.m0.e.e.a<T, q<T>> {

    static final class a implements y<T>, b {

        final y<? super q<T>> a;
        b b;
        a(y<? super q<T>> y) {
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
            this.a.onNext(q.a());
            this.a.onComplete();
        }

        @Override // i.b.y
        public void onError(Throwable throwable) {
            this.a.onNext(q.b(throwable));
            this.a.onComplete();
        }

        public void onNext(T t) {
            this.a.onNext(q.c(t));
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
    public x1(w<T> w) {
        super(w);
    }

    public void subscribeActual(y<? super q<T>> y) {
        x1.a aVar = new x1.a(y);
        this.a.subscribe(aVar);
    }
}
