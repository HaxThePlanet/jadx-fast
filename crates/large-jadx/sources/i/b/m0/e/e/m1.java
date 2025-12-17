package i.b.m0.e.e;

import i.b.b;
import i.b.d;
import i.b.j0.b;
import i.b.m0.c.d;
import i.b.p0.a;
import i.b.r;
import i.b.w;
import i.b.y;

/* loaded from: classes3.dex */
public final class m1<T>  extends b implements d<T> {

    final w<T> a;

    static final class a implements y<T>, b {

        final d a;
        b b;
        a(d d) {
            super();
            this.a = d;
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
    public m1(w<T> w) {
        super();
        this.a = w;
    }

    public r<T> a() {
        l1 l1Var = new l1(this.a);
        return a.n(l1Var);
    }

    @Override // i.b.b
    public void x(d d) {
        m1.a aVar = new m1.a(d);
        this.a.subscribe(aVar);
    }
}
