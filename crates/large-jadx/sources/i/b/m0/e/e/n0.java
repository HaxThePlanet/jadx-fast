package i.b.m0.e.e;

import i.b.j0.b;
import i.b.l0.a;
import i.b.l0.f;
import i.b.m0.a.c;
import i.b.p0.a;
import i.b.w;
import i.b.y;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.a;

/* loaded from: classes3.dex */
public final class n0<T>  extends i.b.m0.e.e.a<T, T> {

    final f<? super T> b;
    final f<? super Throwable> c;
    final a v;
    final a w;

    static final class a implements y<T>, b {

        final y<? super T> a;
        final f<? super T> b;
        final f<? super Throwable> c;
        final a v;
        final a w;
        b x;
        boolean y;
        a(y<? super T> y, f<? super T> f2, f<? super Throwable> f3, a a4, a a5) {
            super();
            this.a = y;
            this.b = f2;
            this.c = f3;
            this.v = a4;
            this.w = a5;
        }

        @Override // i.b.y
        public void dispose() {
            this.x.dispose();
        }

        @Override // i.b.y
        public boolean isDisposed() {
            return this.x.isDisposed();
        }

        @Override // i.b.y
        public void onComplete() {
            a aVar;
            if (this.y) {
            }
            this.v.run();
            this.y = true;
            this.a.onComplete();
            this.w.run();
        }

        @Override // i.b.y
        public void onError(Throwable throwable) {
            f fVar;
            CompositeException compositeException;
            int arr;
            int i;
            Throwable obj6;
            if (this.y) {
                a.t(throwable);
            }
            this.y = true;
            this.c.accept(throwable);
            this.a.onError(obj6);
            this.w.run();
        }

        public void onNext(T t) {
            if (this.y) {
            }
            this.b.accept(t);
            this.a.onNext(t);
        }

        @Override // i.b.y
        public void onSubscribe(b b) {
            Object obj2;
            if (c.validate(this.x, b)) {
                this.x = b;
                this.a.onSubscribe(this);
            }
        }
    }
    public n0(w<T> w, f<? super T> f2, f<? super Throwable> f3, a a4, a a5) {
        super(w);
        this.b = f2;
        this.c = f3;
        this.v = a4;
        this.w = a5;
    }

    public void subscribeActual(y<? super T> y) {
        super(y, this.b, this.c, this.v, this.w);
        this.a.subscribe(aVar4);
    }
}
