package i.b.m0.e.e;

import i.b.j0.b;
import i.b.l0.o;
import i.b.m0.a.c;
import i.b.p0.a;
import i.b.w;
import i.b.y;
import io.reactivex.exceptions.a;

/* loaded from: classes3.dex */
public final class u3<T>  extends i.b.m0.e.e.a<T, T> {

    final o<? super T> b;

    static final class a implements y<T>, b {

        final y<? super T> a;
        final o<? super T> b;
        b c;
        boolean v;
        a(y<? super T> y, o<? super T> o2) {
            super();
            this.a = y;
            this.b = o2;
        }

        @Override // i.b.y
        public void dispose() {
            this.c.dispose();
        }

        @Override // i.b.y
        public boolean isDisposed() {
            return this.c.isDisposed();
        }

        @Override // i.b.y
        public void onComplete() {
            if (this.v) {
            }
            this.v = true;
            this.a.onComplete();
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
            if (!this.b.test(t)) {
                this.v = true;
                this.c.dispose();
                this.a.onComplete();
            }
            this.a.onNext(t);
        }

        @Override // i.b.y
        public void onSubscribe(b b) {
            Object obj2;
            if (c.validate(this.c, b)) {
                this.c = b;
                this.a.onSubscribe(this);
            }
        }
    }
    public u3(w<T> w, o<? super T> o2) {
        super(w);
        this.b = o2;
    }

    public void subscribeActual(y<? super T> y) {
        u3.a aVar = new u3.a(y, this.b);
        this.a.subscribe(aVar);
    }
}
