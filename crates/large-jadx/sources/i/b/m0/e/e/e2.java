package i.b.m0.e.e;

import i.b.j0.b;
import i.b.l0.n;
import i.b.m0.a.c;
import i.b.w;
import i.b.y;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.a;

/* loaded from: classes3.dex */
public final class e2<T>  extends i.b.m0.e.e.a<T, T> {

    final n<? super Throwable, ? extends T> b;

    static final class a implements y<T>, b {

        final y<? super T> a;
        final n<? super Throwable, ? extends T> b;
        b c;
        a(y<? super T> y, n<? super Throwable, ? extends T> n2) {
            super();
            this.a = y;
            this.b = n2;
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
            this.a.onComplete();
        }

        @Override // i.b.y
        public void onError(Throwable throwable) {
            try {
                Object apply = this.b.apply(throwable);
                if (apply == null) {
                }
                NullPointerException nullPointerException = new NullPointerException("The supplied value is null");
                nullPointerException.initCause(throwable);
                this.a.onError(nullPointerException);
                this.a.onNext(apply);
                this.a.onComplete();
                a.b(th);
                int arr = 2;
                arr = new Throwable[arr];
                arr[0] = throwable;
                throwable = 1;
                arr[throwable] = th;
                CompositeException compositeException = new CompositeException(arr);
                this.a.onError(compositeException);
            }
        }

        public void onNext(T t) {
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
    public e2(w<T> w, n<? super Throwable, ? extends T> n2) {
        super(w);
        this.b = n2;
    }

    public void subscribeActual(y<? super T> y) {
        e2.a aVar = new e2.a(y, this.b);
        this.a.subscribe(aVar);
    }
}
