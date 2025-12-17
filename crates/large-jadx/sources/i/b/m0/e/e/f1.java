package i.b.m0.e.e;

import i.b.j0.b;
import i.b.k;
import i.b.m0.i.g;
import i.b.r;
import i.b.y;
import m.c.a;
import m.c.c;

/* loaded from: classes3.dex */
public final class f1<T>  extends r<T> {

    final a<? extends T> a;

    static final class a implements k<T>, b {

        final y<? super T> a;
        c b;
        a(y<? super T> y) {
            super();
            this.a = y;
        }

        @Override // i.b.k
        public void dispose() {
            this.b.cancel();
            this.b = g.CANCELLED;
        }

        @Override // i.b.k
        public boolean isDisposed() {
            int i;
            i = this.b == g.CANCELLED ? 1 : 0;
            return i;
        }

        @Override // i.b.k
        public void onComplete() {
            this.a.onComplete();
        }

        @Override // i.b.k
        public void onError(Throwable throwable) {
            this.a.onError(throwable);
        }

        public void onNext(T t) {
            this.a.onNext(t);
        }

        @Override // i.b.k
        public void onSubscribe(c c) {
            boolean validate;
            if (g.validate(this.b, c)) {
                this.b = c;
                this.a.onSubscribe(this);
                c.request(Long.MAX_VALUE);
            }
        }
    }
    public f1(a<? extends T> a) {
        super();
        this.a = a;
    }

    protected void subscribeActual(y<? super T> y) {
        f1.a aVar2 = new f1.a(y);
        this.a.a(aVar2);
    }
}
