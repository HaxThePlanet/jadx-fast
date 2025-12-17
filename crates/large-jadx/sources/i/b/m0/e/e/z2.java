package i.b.m0.e.e;

import i.b.j0.b;
import i.b.l0.c;
import i.b.m0.a.c;
import i.b.m0.b.b;
import i.b.p0.a;
import i.b.w;
import i.b.y;
import io.reactivex.exceptions.a;

/* loaded from: classes3.dex */
public final class z2<T>  extends i.b.m0.e.e.a<T, T> {

    final c<T, T, T> b;

    static final class a implements y<T>, b {

        final y<? super T> a;
        final c<T, T, T> b;
        b c;
        T v;
        boolean w;
        a(y<? super T> y, c<T, T, T> c2) {
            super();
            this.a = y;
            this.b = c2;
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
            if (this.w) {
            }
            this.w = true;
            this.a.onComplete();
        }

        @Override // i.b.y
        public void onError(Throwable throwable) {
            if (this.w) {
                a.t(throwable);
            }
            this.w = true;
            this.a.onError(throwable);
        }

        public void onNext(T t) {
            Object str;
            c cVar;
            Object obj4;
            if (this.w) {
            }
            y yVar = this.a;
            str = this.v;
            if (str == null) {
                this.v = t;
                yVar.onNext(t);
            } else {
                obj4 = this.b.apply(str, t);
                b.e(obj4, "The value returned by the accumulator is null");
                this.v = obj4;
                yVar.onNext(obj4);
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
    public z2(w<T> w, c<T, T, T> c2) {
        super(w);
        this.b = c2;
    }

    public void subscribeActual(y<? super T> y) {
        z2.a aVar = new z2.a(y, this.b);
        this.a.subscribe(aVar);
    }
}
