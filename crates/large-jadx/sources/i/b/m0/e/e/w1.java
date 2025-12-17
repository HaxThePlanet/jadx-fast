package i.b.m0.e.e;

import i.b.j0.b;
import i.b.l0.n;
import i.b.m0.a.c;
import i.b.m0.b.b;
import i.b.w;
import i.b.y;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.a;
import java.util.concurrent.Callable;

/* loaded from: classes3.dex */
public final class w1<T, R>  extends i.b.m0.e.e.a<T, w<? extends R>> {

    final n<? super T, ? extends w<? extends R>> b;
    final n<? super Throwable, ? extends w<? extends R>> c;
    final Callable<? extends w<? extends R>> v;

    static final class a implements y<T>, b {

        final y<? super w<? extends R>> a;
        final n<? super T, ? extends w<? extends R>> b;
        final n<? super Throwable, ? extends w<? extends R>> c;
        final Callable<? extends w<? extends R>> v;
        b w;
        a(y<? super w<? extends R>> y, n<? super T, ? extends w<? extends R>> n2, n<? super Throwable, ? extends w<? extends R>> n3, Callable<? extends w<? extends R>> callable4) {
            super();
            this.a = y;
            this.b = n2;
            this.c = n3;
            this.v = callable4;
        }

        @Override // i.b.y
        public void dispose() {
            this.w.dispose();
        }

        @Override // i.b.y
        public boolean isDisposed() {
            return this.w.isDisposed();
        }

        @Override // i.b.y
        public void onComplete() {
            try {
                Object call = this.v.call();
                b.e(call, "The onComplete ObservableSource returned is null");
                this.a.onNext((w)call);
                this.a.onComplete();
                a.b(th);
                this.a.onError(th);
            }
        }

        @Override // i.b.y
        public void onError(Throwable throwable) {
            try {
                Object apply = this.c.apply(throwable);
                b.e(apply, "The onError ObservableSource returned is null");
                this.a.onNext((w)apply);
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
            try {
                final Object obj2 = this.b.apply(t);
                b.e(obj2, "The onNext ObservableSource returned is null");
                this.a.onNext((w)obj2);
                a.b(t);
                this.a.onError(t);
            }
        }

        @Override // i.b.y
        public void onSubscribe(b b) {
            Object obj2;
            if (c.validate(this.w, b)) {
                this.w = b;
                this.a.onSubscribe(this);
            }
        }
    }
    public w1(w<T> w, n<? super T, ? extends w<? extends R>> n2, n<? super Throwable, ? extends w<? extends R>> n3, Callable<? extends w<? extends R>> callable4) {
        super(w);
        this.b = n2;
        this.c = n3;
        this.v = callable4;
    }

    public void subscribeActual(y<? super w<? extends R>> y) {
        w1.a aVar = new w1.a(y, this.b, this.c, this.v);
        this.a.subscribe(aVar);
    }
}
