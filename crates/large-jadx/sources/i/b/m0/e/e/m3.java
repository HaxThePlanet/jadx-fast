package i.b.m0.e.e;

import i.b.j0.b;
import i.b.m0.a.g;
import i.b.w;
import i.b.y;

/* loaded from: classes3.dex */
public final class m3<T>  extends i.b.m0.e.e.a<T, T> {

    final w<? extends T> b;

    static final class a implements y<T> {

        final y<? super T> a;
        final w<? extends T> b;
        final g c;
        boolean v = true;
        a(y<? super T> y, w<? extends T> w2) {
            super();
            this.a = y;
            this.b = w2;
            int obj1 = 1;
            obj1 = new g();
            this.c = obj1;
        }

        @Override // i.b.y
        public void onComplete() {
            Object obj;
            if (this.v) {
                this.v = false;
                this.b.subscribe(this);
            } else {
                this.a.onComplete();
            }
        }

        @Override // i.b.y
        public void onError(Throwable throwable) {
            this.a.onError(throwable);
        }

        public void onNext(T t) {
            boolean z;
            if (this.v) {
                this.v = false;
            }
            this.a.onNext(t);
        }

        @Override // i.b.y
        public void onSubscribe(b b) {
            this.c.b(b);
        }
    }
    public m3(w<T> w, w<? extends T> w2) {
        super(w);
        this.b = w2;
    }

    public void subscribeActual(y<? super T> y) {
        m3.a aVar = new m3.a(y, this.b);
        y.onSubscribe(aVar.c);
        this.a.subscribe(aVar);
    }
}
