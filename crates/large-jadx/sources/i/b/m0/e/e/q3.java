package i.b.m0.e.e;

import i.b.j0.b;
import i.b.m0.a.c;
import i.b.w;
import i.b.y;

/* loaded from: classes3.dex */
public final class q3<T>  extends i.b.m0.e.e.a<T, T> {

    static final class a implements y<T>, b {

        final y<? super T> a;
        b b;
        T c;
        a(y<? super T> y) {
            super();
            this.a = y;
        }

        @Override // i.b.y
        void a() {
            y yVar;
            Object obj = this.c;
            if (obj != null) {
                this.c = 0;
                this.a.onNext(obj);
            }
            this.a.onComplete();
        }

        @Override // i.b.y
        public void dispose() {
            this.c = 0;
            this.b.dispose();
        }

        @Override // i.b.y
        public boolean isDisposed() {
            return this.b.isDisposed();
        }

        @Override // i.b.y
        public void onComplete() {
            a();
        }

        @Override // i.b.y
        public void onError(Throwable throwable) {
            this.c = 0;
            this.a.onError(throwable);
        }

        public void onNext(T t) {
            this.c = t;
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
    public q3(w<T> w) {
        super(w);
    }

    public void subscribeActual(y<? super T> y) {
        q3.a aVar = new q3.a(y);
        this.a.subscribe(aVar);
    }
}
