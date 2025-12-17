package i.b.m0.e.e;

import i.b.a0;
import i.b.d0;
import i.b.j0.b;
import i.b.l0.c;
import i.b.m0.a.c;
import i.b.m0.b.b;
import i.b.p0.a;
import i.b.w;
import i.b.y;
import io.reactivex.exceptions.a;

/* loaded from: classes3.dex */
public final class m2<T, R>  extends a0<R> {

    final w<T> a;
    final R b;
    final c<R, ? super T, R> c;

    static final class a implements y<T>, b {

        final d0<? super R> a;
        final c<R, ? super T, R> b;
        R c;
        b v;
        a(d0<? super R> d0, c<R, ? super T, R> c2, R r3) {
            super();
            this.a = d0;
            this.c = r3;
            this.b = c2;
        }

        @Override // i.b.y
        public void dispose() {
            this.v.dispose();
        }

        @Override // i.b.y
        public boolean isDisposed() {
            return this.v.isDisposed();
        }

        @Override // i.b.y
        public void onComplete() {
            d0 d0Var;
            final Object obj = this.c;
            if (obj != null) {
                this.c = 0;
                this.a.onSuccess(obj);
            }
        }

        @Override // i.b.y
        public void onError(Throwable throwable) {
            Object obj;
            if (this.c != null) {
                this.c = 0;
                this.a.onError(throwable);
            } else {
                a.t(throwable);
            }
        }

        public void onNext(T t) {
            Object str;
            c cVar;
            Object obj3;
            str = this.c;
            if (str != null) {
                obj3 = this.b.apply(str, t);
                b.e(obj3, "The reducer returned a null value");
                this.c = obj3;
            }
        }

        @Override // i.b.y
        public void onSubscribe(b b) {
            Object obj2;
            if (c.validate(this.v, b)) {
                this.v = b;
                this.a.onSubscribe(this);
            }
        }
    }
    public m2(w<T> w, R r2, c<R, ? super T, R> c3) {
        super();
        this.a = w;
        this.b = r2;
        this.c = c3;
    }

    protected void subscribeActual(d0<? super R> d0) {
        m2.a aVar = new m2.a(d0, this.c, this.b);
        this.a.subscribe(aVar);
    }
}
