package i.b.m0.e.f;

import i.b.a0;
import i.b.d0;
import i.b.j0.b;
import i.b.k;
import i.b.m0.i.g;
import i.b.p0.a;
import java.util.NoSuchElementException;
import m.c.a;
import m.c.c;

/* loaded from: classes3.dex */
public final class e0<T>  extends a0<T> {

    final a<? extends T> a;

    static final class a implements k<T>, b {

        final d0<? super T> a;
        c b;
        T c;
        boolean v;
        volatile boolean w;
        a(d0<? super T> d0) {
            super();
            this.a = d0;
        }

        @Override // i.b.k
        public void dispose() {
            this.w = true;
            this.b.cancel();
        }

        @Override // i.b.k
        public boolean isDisposed() {
            return this.w;
        }

        @Override // i.b.k
        public void onComplete() {
            Object obj;
            Object noSuchElementException;
            String str;
            if (this.v) {
            }
            this.v = true;
            obj = this.c;
            this.c = 0;
            if (obj == null) {
                noSuchElementException = new NoSuchElementException("The source Publisher is empty");
                this.a.onError(noSuchElementException);
            } else {
                this.a.onSuccess(obj);
            }
        }

        @Override // i.b.k
        public void onError(Throwable throwable) {
            if (this.v) {
                a.t(throwable);
            }
            this.v = true;
            this.c = 0;
            this.a.onError(throwable);
        }

        public void onNext(T t) {
            Object indexOutOfBoundsException;
            String str;
            Object obj3;
            if (this.v) {
            }
            if (this.c != null) {
                this.b.cancel();
                this.v = true;
                this.c = 0;
                indexOutOfBoundsException = new IndexOutOfBoundsException("Too many elements in the Publisher");
                this.a.onError(indexOutOfBoundsException);
            } else {
                this.c = t;
            }
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
    public e0(a<? extends T> a) {
        super();
        this.a = a;
    }

    protected void subscribeActual(d0<? super T> d0) {
        e0.a aVar2 = new e0.a(d0);
        this.a.a(aVar2);
    }
}
