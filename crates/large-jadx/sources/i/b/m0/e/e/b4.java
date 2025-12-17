package i.b.m0.e.e;

import i.b.j0.b;
import i.b.m0.a.c;
import i.b.m0.a.d;
import i.b.m0.b.a;
import i.b.m0.b.b;
import i.b.w;
import i.b.y;
import io.reactivex.exceptions.a;
import java.util.Collection;
import java.util.concurrent.Callable;

/* loaded from: classes3.dex */
public final class b4<T, U extends Collection<? super T>>  extends i.b.m0.e.e.a<T, U> {

    final Callable<U> b;

    static final class a implements y<T>, b {

        final y<? super U> a;
        b b;
        U c;
        a(y<? super U> y, U u2) {
            super();
            this.a = y;
            this.c = u2;
        }

        @Override // i.b.y
        public void dispose() {
            this.b.dispose();
        }

        @Override // i.b.y
        public boolean isDisposed() {
            return this.b.isDisposed();
        }

        @Override // i.b.y
        public void onComplete() {
            this.c = 0;
            this.a.onNext(this.c);
            this.a.onComplete();
        }

        @Override // i.b.y
        public void onError(Throwable throwable) {
            this.c = 0;
            this.a.onError(throwable);
        }

        public void onNext(T t) {
            this.c.add(t);
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
    public b4(w<T> w, int i2) {
        super(w);
        this.b = a.e(i2);
    }

    public b4(w<T> w, Callable<U> callable2) {
        super(w);
        this.b = callable2;
    }

    public void subscribeActual(y<? super U> y) {
        try {
            Object call = this.b.call();
            b.e(call, "The collectionSupplier returned a null collection. Null values are generally not allowed in 2.x operators and sources.");
            b4.a aVar = new b4.a(y, (Collection)call);
            this.a.subscribe(aVar);
            a.b(th);
            d.error(th, y);
        }
    }
}
