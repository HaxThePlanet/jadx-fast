package i.b.m0.e.e;

import i.b.m0.j.e;
import i.b.m0.j.k;
import i.b.o0.c;
import i.b.p0.a;
import i.b.q;
import i.b.r;
import i.b.w;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes3.dex */
public final class c<T>  implements Iterable<T> {

    final w<T> a;

    static final class a extends c<q<T>> implements Iterator<T> {

        q<T> b;
        final Semaphore c;
        final AtomicReference<q<T>> v;
        a() {
            super();
            Semaphore semaphore = new Semaphore(0);
            this.c = semaphore;
            AtomicReference atomicReference = new AtomicReference();
            this.v = atomicReference;
        }

        public void c(q<T> q) {
            int obj2;
            obj2 = this.v.getAndSet(q) == null ? 1 : 0;
            if (obj2 != null) {
                this.c.release();
            }
        }

        @Override // i.b.o0.c
        public boolean hasNext() {
            q qVar2;
            Object andSet;
            q qVar;
            qVar2 = this.b;
            if (qVar2 != null) {
                if (qVar2.g()) {
                } else {
                }
                throw k.e(this.b.d());
            }
            if (this.b == null) {
                e.b();
                this.c.acquire();
                andSet = this.v.getAndSet(0);
                this.b = (q)andSet;
                if (andSet.g()) {
                } else {
                }
                throw k.e(andSet.d());
            }
            return this.b.h();
        }

        public T next() {
            if (!hasNext()) {
            } else {
                this.b = 0;
                return this.b.e();
            }
            NoSuchElementException noSuchElementException = new NoSuchElementException();
            throw noSuchElementException;
        }

        @Override // i.b.o0.c
        public void onComplete() {
        }

        @Override // i.b.o0.c
        public void onError(Throwable throwable) {
            a.t(throwable);
        }

        @Override // i.b.o0.c
        public void onNext(Object object) {
            c((q)object);
        }

        @Override // i.b.o0.c
        public void remove() {
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Read-only iterator.");
            throw unsupportedOperationException;
        }
    }
    public c(w<T> w) {
        super();
        this.a = w;
    }

    public Iterator<T> iterator() {
        c.a aVar = new c.a();
        r.wrap(this.a).materialize().subscribe(aVar);
        return aVar;
    }
}
