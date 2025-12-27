package i.b.m0.e.e;

import i.b.l0.n;
import i.b.m0.a.c;
import i.b.w;
import i.b.y;
import java.util.Iterator;

/* compiled from: ObservableFlattenIterable.java */
/* loaded from: classes3.dex */
public final class a1<T, R> extends a<T, R> {

    final n<? super T, ? extends Iterable<? extends R>> b;

    static final class a<T, R> implements y<T>, i.b.j0.b {

        final y<? super R> a;
        final n<? super T, ? extends Iterable<? extends R>> b;
        i.b.j0.b c;
        a(y<? super R> yVar, n<? super T, ? extends Iterable<? extends R>> nVar) {
            super();
            this.a = yVar;
            this.b = nVar;
        }

        public void dispose() {
            this.c.dispose();
            this.c = c.DISPOSED;
        }

        public boolean isDisposed() {
            return this.c.isDisposed();
        }

        public void onComplete() {
            final c dISPOSED2 = c.DISPOSED;
            if (this.c == c.DISPOSED) {
                return;
            }
            this.c = c.DISPOSED;
            this.a.onComplete();
        }

        public void onError(Throwable th) {
            final c dISPOSED2 = c.DISPOSED;
            if (this.c == c.DISPOSED) {
                a.t(th);
                return;
            }
            this.c = c.DISPOSED;
            this.a.onError(th);
        }

        public void onNext(T t) {
            if (this.c == c.DISPOSED) {
                return;
            }
            try {
                Iterator it = (Iterable)this.b.apply(t).iterator();
            } catch (Throwable th) {
                a.b(th);
                this.c.dispose();
                onError(th);
                return;
            }
            while (/* condition */) {
            }
        }

        public void onSubscribe(i.b.j0.b bVar) {
            if (c.validate(this.c, bVar)) {
                this.c = bVar;
                this.a.onSubscribe(this);
            }
        }
    }
    public a1(w<T> wVar, n<? super T, ? extends Iterable<? extends R>> nVar) {
        super(wVar);
        this.b = nVar;
    }

    @Override // i.b.m0.e.e.a
    protected void subscribeActual(y<? super R> yVar) {
        this.a.subscribe(new a1.a(yVar, this.b));
    }
}
