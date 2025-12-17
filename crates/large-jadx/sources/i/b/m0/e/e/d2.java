package i.b.m0.e.e;

import i.b.j0.b;
import i.b.l0.n;
import i.b.m0.a.g;
import i.b.p0.a;
import i.b.w;
import i.b.y;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.a;

/* loaded from: classes3.dex */
public final class d2<T>  extends i.b.m0.e.e.a<T, T> {

    final n<? super Throwable, ? extends w<? extends T>> b;
    final boolean c;

    static final class a implements y<T> {

        final y<? super T> a;
        final n<? super Throwable, ? extends w<? extends T>> b;
        final boolean c;
        final g v;
        boolean w;
        boolean x;
        a(y<? super T> y, n<? super Throwable, ? extends w<? extends T>> n2, boolean z3) {
            super();
            this.a = y;
            this.b = n2;
            this.c = z3;
            g obj1 = new g();
            this.v = obj1;
        }

        @Override // i.b.y
        public void onComplete() {
            if (this.x) {
            }
            int i = 1;
            this.x = i;
            this.w = i;
            this.a.onComplete();
        }

        @Override // i.b.y
        public void onError(Throwable throwable) {
            boolean z;
            if (this.w && this.x) {
                if (this.x) {
                    a.t(throwable);
                }
                this.a.onError(throwable);
            }
            this.w = true;
            if (this.c && throwable instanceof Exception == null) {
                if (throwable instanceof Exception == null) {
                    this.a.onError(throwable);
                }
            }
            Object apply = this.b.apply(throwable);
            if ((w)apply == null) {
                NullPointerException nullPointerException = new NullPointerException("Observable is null");
                nullPointerException.initCause(throwable);
                this.a.onError(nullPointerException);
            }
            (w)apply.subscribe(this);
        }

        public void onNext(T t) {
            if (this.x) {
            }
            this.a.onNext(t);
        }

        @Override // i.b.y
        public void onSubscribe(b b) {
            this.v.a(b);
        }
    }
    public d2(w<T> w, n<? super Throwable, ? extends w<? extends T>> n2, boolean z3) {
        super(w);
        this.b = n2;
        this.c = z3;
    }

    public void subscribeActual(y<? super T> y) {
        d2.a aVar = new d2.a(y, this.b, this.c);
        y.onSubscribe(aVar.v);
        this.a.subscribe(aVar);
    }
}
