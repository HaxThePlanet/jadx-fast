package i.b.m0.e.e;

import i.b.j0.b;
import i.b.l0.n;
import i.b.m0.a.c;
import i.b.m0.b.b;
import i.b.p0.a;
import i.b.q;
import i.b.w;
import i.b.y;
import io.reactivex.exceptions.a;

/* loaded from: classes3.dex */
public final class h0<T, R>  extends i.b.m0.e.e.a<T, R> {

    final n<? super T, ? extends q<R>> b;

    static final class a implements y<T>, b {

        final y<? super R> a;
        final n<? super T, ? extends q<R>> b;
        boolean c;
        b v;
        a(y<? super R> y, n<? super T, ? extends q<R>> n2) {
            super();
            this.a = y;
            this.b = n2;
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
            if (this.c) {
            }
            this.c = true;
            this.a.onComplete();
        }

        @Override // i.b.y
        public void onError(Throwable throwable) {
            if (this.c) {
                a.t(throwable);
            }
            this.c = true;
            this.a.onError(throwable);
        }

        public void onNext(T t) {
            y z;
            boolean z2;
            Object obj2;
            if (this.c && t instanceof q && (q)t.g()) {
                if (t instanceof q) {
                    if ((q)t.g()) {
                        a.t(t.d());
                    }
                }
            }
            obj2 = this.b.apply(t);
            b.e(obj2, "The selector returned a null Notification");
            if ((q)obj2.g()) {
                this.v.dispose();
                onError(obj2.d());
            } else {
                if (obj2.f()) {
                    this.v.dispose();
                    onComplete();
                } else {
                    this.a.onNext(obj2.e());
                }
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
    public h0(w<T> w, n<? super T, ? extends q<R>> n2) {
        super(w);
        this.b = n2;
    }

    public void subscribeActual(y<? super R> y) {
        h0.a aVar = new h0.a(y, this.b);
        this.a.subscribe(aVar);
    }
}
