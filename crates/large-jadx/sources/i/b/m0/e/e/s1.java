package i.b.m0.e.e;

import i.b.j0.b;
import i.b.l;
import i.b.m0.a.c;
import i.b.n;
import i.b.w;
import i.b.y;

/* loaded from: classes3.dex */
public final class s1<T>  extends l<T> {

    final w<T> a;

    static final class a implements y<T>, b {

        final n<? super T> a;
        b b;
        T c;
        a(n<? super T> n) {
            super();
            this.a = n;
        }

        @Override // i.b.y
        public void dispose() {
            this.b.dispose();
            this.b = c.DISPOSED;
        }

        @Override // i.b.y
        public boolean isDisposed() {
            int i;
            i = this.b == c.DISPOSED ? 1 : 0;
            return i;
        }

        @Override // i.b.y
        public void onComplete() {
            Object obj;
            n nVar;
            this.b = c.DISPOSED;
            obj = this.c;
            if (obj != null) {
                this.c = 0;
                this.a.onSuccess(obj);
            } else {
                this.a.onComplete();
            }
        }

        @Override // i.b.y
        public void onError(Throwable throwable) {
            this.b = c.DISPOSED;
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
    public s1(w<T> w) {
        super();
        this.a = w;
    }

    protected void w(n<? super T> n) {
        s1.a aVar = new s1.a(n);
        this.a.subscribe(aVar);
    }
}
