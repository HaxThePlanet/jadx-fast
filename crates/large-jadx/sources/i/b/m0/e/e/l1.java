package i.b.m0.e.e;

import i.b.j0.b;
import i.b.w;
import i.b.y;

/* loaded from: classes3.dex */
public final class l1<T>  extends i.b.m0.e.e.a<T, T> {

    static final class a implements y<T>, b {

        final y<? super T> a;
        b b;
        a(y<? super T> y) {
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
            this.a.onComplete();
        }

        @Override // i.b.y
        public void onError(Throwable throwable) {
            this.a.onError(throwable);
        }

        public void onNext(T t) {
        }

        @Override // i.b.y
        public void onSubscribe(b b) {
            this.b = b;
            this.a.onSubscribe(this);
        }
    }
    public l1(w<T> w) {
        super(w);
    }

    public void subscribeActual(y<? super T> y) {
        l1.a aVar = new l1.a(y);
        this.a.subscribe(aVar);
    }
}
