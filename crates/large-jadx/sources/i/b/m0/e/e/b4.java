package i.b.m0.e.e;

import i.b.m0.a.c;
import i.b.m0.a.d;
import i.b.w;
import i.b.y;
import java.util.Collection;
import java.util.concurrent.Callable;

/* compiled from: ObservableToList.java */
/* loaded from: classes3.dex */
public final class b4<T, U extends Collection<? super T>> extends a<T, U> {

    final Callable<U> b;

    static final class a<T, U extends Collection<? super T>> implements y<T>, i.b.j0.b {

        final y<? super U> a;
        i.b.j0.b b;
        U c;
        a(y<? super U> yVar, U u) {
            super();
            this.a = yVar;
            this.c = u;
        }

        public void dispose() {
            this.b.dispose();
        }

        public boolean isDisposed() {
            return this.b.isDisposed();
        }

        public void onComplete() {
            this.c = null;
            this.a.onNext(this.c);
            this.a.onComplete();
        }

        public void onError(Throwable th) {
            this.c = null;
            this.a.onError(th);
        }

        public void onNext(T t) {
            this.c.add(t);
        }

        public void onSubscribe(i.b.j0.b bVar) {
            if (c.validate(this.b, bVar)) {
                this.b = bVar;
                this.a.onSubscribe(this);
            }
        }
    }
    public b4(w<T> wVar, int i) {
        super(wVar);
        this.b = a.e(i);
    }

    @Override // i.b.m0.e.e.a
    public void subscribeActual(y<? super U> yVar) {
        try {
            Object call = this.b.call();
            b.e(call, "The collectionSupplier returned a null collection. Null values are generally not allowed in 2.x operators and sources.");
        } catch (Throwable th) {
            a.b(th);
            d.error(th, yVar);
            return;
        }
        this.a.subscribe(new b4.a(yVar, call));
    }

    public b4(w<T> wVar, Callable<U> callable) {
        super(wVar);
        this.b = callable;
    }
}
