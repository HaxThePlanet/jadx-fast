package i.b.m0.e.e;

import i.b.j0.b;
import i.b.m0.a.c;
import i.b.m0.j.h;
import i.b.w;
import i.b.y;

/* loaded from: classes3.dex */
public final class i0<T>  extends i.b.m0.e.e.a<T, T> {

    static final class a implements y<T>, b {

        y<? super T> a;
        b b;
        a(y<? super T> y) {
            super();
            this.a = y;
        }

        @Override // i.b.y
        public void dispose() {
            this.b = h.INSTANCE;
            this.a = h.asObserver();
            this.b.dispose();
        }

        @Override // i.b.y
        public boolean isDisposed() {
            return this.b.isDisposed();
        }

        @Override // i.b.y
        public void onComplete() {
            this.b = h.INSTANCE;
            this.a = h.asObserver();
            this.a.onComplete();
        }

        @Override // i.b.y
        public void onError(Throwable throwable) {
            this.b = h.INSTANCE;
            this.a = h.asObserver();
            this.a.onError(throwable);
        }

        public void onNext(T t) {
            this.a.onNext(t);
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
    public i0(w<T> w) {
        super(w);
    }

    protected void subscribeActual(y<? super T> y) {
        i0.a aVar = new i0.a(y);
        this.a.subscribe(aVar);
    }
}
