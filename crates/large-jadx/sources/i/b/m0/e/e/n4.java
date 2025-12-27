package i.b.m0.e.e;

import i.b.m0.a.d;
import i.b.r;
import i.b.y;
import java.util.Iterator;

/* compiled from: ObservableZipIterable.java */
/* loaded from: classes3.dex */
public final class n4<T, U, V> extends r<V> {

    final r<? extends T> a;
    final Iterable<U> b;
    final i.b.l0.c<? super T, ? super U, ? extends V> c;

    static final class a<T, U, V> implements y<T>, i.b.j0.b {

        final y<? super V> a;
        final Iterator<U> b;
        final i.b.l0.c<? super T, ? super U, ? extends V> c;
        i.b.j0.b v;
        boolean w;
        a(y<? super V> yVar, Iterator<U> iterator, i.b.l0.c<? super T, ? super U, ? extends V> cVar) {
            super();
            this.a = yVar;
            this.b = iterator;
            this.c = cVar;
        }

        void a(Throwable th) {
            this.w = true;
            this.v.dispose();
            this.a.onError(th);
        }

        public void dispose() {
            this.v.dispose();
        }

        public boolean isDisposed() {
            return this.v.isDisposed();
        }

        public void onComplete() {
            if (this.w) {
                return;
            }
            this.w = true;
            this.a.onComplete();
        }

        public void onError(Throwable th) {
            if (this.w) {
                a.t(th);
                return;
            }
            this.w = true;
            this.a.onError(th);
        }

        public void onNext(T t) {
            if (this.w) {
                return;
            }
            try {
                Object item = this.b.next();
                b.e(item, "The iterator returned a null value");
            } catch (Throwable th) {
                a.b(th);
                a(th);
                return;
            }
            try {
                Object apply = this.c.apply(th, item);
                b.e(apply, "The zipper function returned a null value");
            } catch (Throwable th) {
                a.b(th);
                a(th);
                return;
            }
            this.a.onNext(apply);
            try {
            } catch (Throwable th) {
                a.b(th);
                a(th);
                return;
            }
            if (!this.b.hasNext()) {
                this.w = true;
                this.v.dispose();
                this.a.onComplete();
            }
        }

        public void onSubscribe(i.b.j0.b bVar) {
            if (c.validate(this.v, bVar)) {
                this.v = bVar;
                this.a.onSubscribe(this);
            }
        }
    }
    public n4(r<? extends T> rVar, Iterable<U> iterable, i.b.l0.c<? super T, ? super U, ? extends V> cVar) {
        super();
        this.a = rVar;
        this.b = iterable;
        this.c = cVar;
    }

    @Override // i.b.r
    public void subscribeActual(y<? super V> yVar) {
        try {
            Iterator it = this.b.iterator();
            b.e(it, "The iterator returned by other is null");
        } catch (Throwable th) {
            a.b(th);
            d.error(th, yVar);
            return;
        }
        try {
        } catch (Throwable th) {
            a.b(th);
            d.error(th, yVar);
            return;
        }
        if (!it.hasNext()) {
            d.complete(yVar);
            return;
        }
        this.a.subscribe(new n4.a(yVar, it, this.c));
    }
}
