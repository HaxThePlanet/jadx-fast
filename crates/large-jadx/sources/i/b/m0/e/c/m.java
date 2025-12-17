package i.b.m0.e.c;

import i.b.a0;
import i.b.d0;
import i.b.j0.b;
import i.b.l;
import i.b.m0.a.c;
import i.b.m0.c.c;
import i.b.n;
import i.b.p;
import i.b.p0.a;

/* loaded from: classes3.dex */
public final class m<T>  extends a0<Boolean> implements c {

    final p<T> a;

    static final class a implements n<T>, b {

        final d0<? super Boolean> a;
        b b;
        a(d0<? super Boolean> d0) {
            super();
            this.a = d0;
        }

        @Override // i.b.n
        public void dispose() {
            this.b.dispose();
            this.b = c.DISPOSED;
        }

        @Override // i.b.n
        public boolean isDisposed() {
            return this.b.isDisposed();
        }

        @Override // i.b.n
        public void onComplete() {
            this.b = c.DISPOSED;
            this.a.onSuccess(Boolean.TRUE);
        }

        @Override // i.b.n
        public void onError(Throwable throwable) {
            this.b = c.DISPOSED;
            this.a.onError(throwable);
        }

        @Override // i.b.n
        public void onSubscribe(b b) {
            Object obj2;
            if (c.validate(this.b, b)) {
                this.b = b;
                this.a.onSubscribe(this);
            }
        }

        public void onSuccess(T t) {
            this.b = c.DISPOSED;
            this.a.onSuccess(Boolean.FALSE);
        }
    }
    public m(p<T> p) {
        super();
        this.a = p;
    }

    public l<Boolean> b() {
        l lVar = new l(this.a);
        return a.m(lVar);
    }

    protected void subscribeActual(d0<? super Boolean> d0) {
        m.a aVar = new m.a(d0);
        this.a.b(aVar);
    }
}
