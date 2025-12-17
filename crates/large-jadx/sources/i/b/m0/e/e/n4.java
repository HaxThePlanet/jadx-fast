package i.b.m0.e.e;

import i.b.j0.b;
import i.b.l0.c;
import i.b.m0.a.c;
import i.b.m0.a.d;
import i.b.m0.b.b;
import i.b.p0.a;
import i.b.r;
import i.b.y;
import io.reactivex.exceptions.a;
import java.util.Iterator;

/* loaded from: classes3.dex */
public final class n4<T, U, V>  extends r<V> {

    final r<? extends T> a;
    final Iterable<U> b;
    final c<? super T, ? super U, ? extends V> c;

    static final class a implements y<T>, b {

        final y<? super V> a;
        final Iterator<U> b;
        final c<? super T, ? super U, ? extends V> c;
        b v;
        boolean w;
        a(y<? super V> y, Iterator<U> iterator2, c<? super T, ? super U, ? extends V> c3) {
            super();
            this.a = y;
            this.b = iterator2;
            this.c = c3;
        }

        @Override // i.b.y
        void a(Throwable throwable) {
            this.w = true;
            this.v.dispose();
            this.a.onError(throwable);
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
            if (this.w) {
            }
            this.w = true;
            this.a.onComplete();
        }

        @Override // i.b.y
        public void onError(Throwable throwable) {
            if (this.w) {
                a.t(throwable);
            }
            this.w = true;
            this.a.onError(throwable);
        }

        public void onNext(T t) {
            boolean obj3;
            if (this.w) {
            }
            Object next = this.b.next();
            b.e(next, "The iterator returned a null value");
            obj3 = this.c.apply(t, next);
            b.e(obj3, "The zipper function returned a null value");
            this.a.onNext(obj3);
            if (!this.b.hasNext()) {
                this.w = true;
                this.v.dispose();
                this.a.onComplete();
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
    public n4(r<? extends T> r, Iterable<U> iterable2, c<? super T, ? super U, ? extends V> c3) {
        super();
        this.a = r;
        this.b = iterable2;
        this.c = c3;
    }

    public void subscribeActual(y<? super V> y) {
        try {
            Iterator iterator = this.b.iterator();
            b.e(iterator, "The iterator returned by other is null");
            if (!(Iterator)iterator.hasNext()) {
            }
            d.complete(y);
            n4.a aVar = new n4.a(y, iterator, this.c);
            this.a.subscribe(aVar);
            a.b(th);
            d.error(th, y);
            a.b(th);
            d.error(th, y);
        } catch (Throwable th) {
        }
    }
}
