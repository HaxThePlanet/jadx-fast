package i.b.m0.e.e;

import i.b.j0.b;
import i.b.l;
import i.b.m0.a.c;
import i.b.n;
import i.b.p0.a;
import i.b.w;
import i.b.y;

/* loaded from: classes3.dex */
public final class e3<T>  extends l<T> {

    final w<T> a;

    static final class a implements y<T>, b {

        final n<? super T> a;
        b b;
        T c;
        boolean v;
        a(n<? super T> n) {
            super();
            this.a = n;
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
            Object obj;
            int i;
            if (this.v) {
            }
            this.v = true;
            obj = this.c;
            this.c = 0;
            if (obj == null) {
                this.a.onComplete();
            } else {
                this.a.onSuccess(obj);
            }
        }

        @Override // i.b.y
        public void onError(Throwable throwable) {
            if (this.v) {
                a.t(throwable);
            }
            this.v = true;
            this.a.onError(throwable);
        }

        public void onNext(T t) {
            if (this.v) {
            }
            if (this.c != null) {
                this.v = true;
                this.b.dispose();
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Sequence contains more than one element!");
                this.a.onError(illegalArgumentException);
            }
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
    public e3(w<T> w) {
        super();
        this.a = w;
    }

    public void w(n<? super T> n) {
        e3.a aVar = new e3.a(n);
        this.a.subscribe(aVar);
    }
}
