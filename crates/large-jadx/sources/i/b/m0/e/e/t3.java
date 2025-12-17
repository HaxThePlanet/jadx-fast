package i.b.m0.e.e;

import i.b.j0.b;
import i.b.l0.o;
import i.b.m0.a.c;
import i.b.p0.a;
import i.b.w;
import i.b.y;
import io.reactivex.exceptions.a;

/* loaded from: classes3.dex */
public final class t3<T>  extends i.b.m0.e.e.a<T, T> {

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
            boolean z;
            if (!this.v) {
                this.v = true;
                this.a.onComplete();
            }
        }

        @Override // i.b.y
        public void onError(Throwable throwable) {
            y z;
            if (!this.v) {
                this.v = true;
                this.a.onError(throwable);
            } else {
                a.t(throwable);
            }
        }

        public void onNext(T t) {
            boolean z;
            Object obj2;
            this.a.onNext(t);
            if (!this.v && this.b.test(t)) {
                this.a.onNext(t);
                if (this.b.test(t)) {
                    this.v = true;
                    this.c.dispose();
                    this.a.onComplete();
                }
            }
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
    public t3(w<T> w, o<? super T> o2) {
        super(w);
        this.b = o2;
    }

    public void subscribeActual(y<? super T> y) {
        t3.a aVar = new t3.a(y, this.b);
        this.a.subscribe(aVar);
    }
}
