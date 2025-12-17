package i.b.m0.e.e;

import i.b.j0.b;
import i.b.l;
import i.b.l0.c;
import i.b.m0.a.c;
import i.b.m0.b.b;
import i.b.n;
import i.b.p0.a;
import i.b.w;
import i.b.y;
import io.reactivex.exceptions.a;

/* loaded from: classes3.dex */
public final class l2<T>  extends l<T> {

    final w<T> a;
    final c<T, T, T> b;

    static final class a implements y<T>, b {

        final n<? super T> a;
        final c<T, T, T> b;
        boolean c;
        T v;
        b w;
        a(n<? super T> n, c<T, T, T> c2) {
            super();
            this.a = n;
            this.b = c2;
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
            Object obj;
            n i;
            if (this.c) {
            }
            this.c = true;
            obj = this.v;
            this.v = 0;
            if (obj != null) {
                this.a.onSuccess(obj);
            } else {
                this.a.onComplete();
            }
        }

        @Override // i.b.y
        public void onError(Throwable throwable) {
            if (this.c) {
                a.t(throwable);
            }
            this.c = true;
            this.v = 0;
            this.a.onError(throwable);
        }

        public void onNext(T t) {
            boolean str;
            c cVar;
            Object obj3;
            if (!this.c) {
                str = this.v;
                if (str == null) {
                    this.v = t;
                } else {
                    obj3 = this.b.apply(str, t);
                    b.e(obj3, "The reducer returned a null value");
                    this.v = obj3;
                }
            }
        }

        @Override // i.b.y
        public void onSubscribe(b b) {
            Object obj2;
            if (c.validate(this.w, b)) {
                this.w = b;
                this.a.onSubscribe(this);
            }
        }
    }
    public l2(w<T> w, c<T, T, T> c2) {
        super();
        this.a = w;
        this.b = c2;
    }

    protected void w(n<? super T> n) {
        l2.a aVar = new l2.a(n, this.b);
        this.a.subscribe(aVar);
    }
}
