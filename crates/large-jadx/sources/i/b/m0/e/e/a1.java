package i.b.m0.e.e;

import i.b.j0.b;
import i.b.l0.n;
import i.b.m0.a.c;
import i.b.m0.b.b;
import i.b.p0.a;
import i.b.w;
import i.b.y;
import io.reactivex.exceptions.a;
import java.util.Iterator;

/* loaded from: classes3.dex */
public final class a1<T, R>  extends i.b.m0.e.e.a<T, R> {

    final n<? super T, ? extends Iterable<? extends R>> b;

    static final class a implements y<T>, b {

        final y<? super R> a;
        final n<? super T, ? extends Iterable<? extends R>> b;
        b c;
        a(y<? super R> y, n<? super T, ? extends Iterable<? extends R>> n2) {
            super();
            this.a = y;
            this.b = n2;
        }

        @Override // i.b.y
        public void dispose() {
            this.c.dispose();
            this.c = c.DISPOSED;
        }

        @Override // i.b.y
        public boolean isDisposed() {
            return this.c.isDisposed();
        }

        @Override // i.b.y
        public void onComplete() {
            final c dISPOSED = c.DISPOSED;
            if (this.c == dISPOSED) {
            }
            this.c = dISPOSED;
            this.a.onComplete();
        }

        @Override // i.b.y
        public void onError(Throwable throwable) {
            final c dISPOSED = c.DISPOSED;
            if (this.c == dISPOSED) {
                a.t(throwable);
            }
            this.c = dISPOSED;
            this.a.onError(throwable);
        }

        public void onNext(T t) {
            y yVar;
            c dISPOSED;
            String str;
            Iterator obj4;
            if (this.c == c.DISPOSED) {
            }
            obj4 = (Iterable)this.b.apply(t).iterator();
            for (Object dISPOSED : obj4) {
                b.e(dISPOSED, "The iterator returned a null value");
                this.a.onNext(dISPOSED);
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
    public a1(w<T> w, n<? super T, ? extends Iterable<? extends R>> n2) {
        super(w);
        this.b = n2;
    }

    protected void subscribeActual(y<? super R> y) {
        a1.a aVar = new a1.a(y, this.b);
        this.a.subscribe(aVar);
    }
}
