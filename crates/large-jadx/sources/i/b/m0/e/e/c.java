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

/* compiled from: BlockingObservableLatest.java */
/* loaded from: classes3.dex */
public final class c<T> implements Iterable<T> {

    final w<T> a;

    static final class a<T> extends c<q<T>> implements Iterator<T> {

        q<T> b;
        final Semaphore c = new Semaphore(0);
        final AtomicReference<q<T>> v = new AtomicReference<>();
        a() {
            super();
            Semaphore semaphore = new Semaphore(0);
            AtomicReference atomicReference = new AtomicReference();
        }

        @Override // i.b.o0.c
        public void c(q<T> qVar) {
            int i = 1;
            qVar = this.v.getAndSet(qVar) == null ? 1 : 0;
            if (i != 0) {
                this.c.release();
            }
        }

        @Override // i.b.o0.c
        public boolean hasNext() {
            if (this.b != null) {
                if (this.b.g()) {
                    throw k.e(this.b.d());
                }
            }
            if (this.b == null) {
                try {
                    e.b();
                    this.c.acquire();
                } catch (java.lang.InterruptedException interrupted) {
                    dispose();
                    this.b = q.b(interrupted);
                    Throwable interrupted2 = k.e(interrupted);
                    throw interrupted2;
                }
                Object andSet = this.v.getAndSet(null);
                this.b = andSet;
                if (andSet.g()) {
                    throw k.e(andSet.d());
                }
            }
            return this.b.h();
        }

        @Override // i.b.o0.c
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            } else {
                this.b = null;
                return this.b.e();
            }
        }

        @Override // i.b.o0.c
        public void onError(Throwable th) {
            a.t(th);
        }

        @Override // i.b.o0.c
        public void remove() {
            throw new UnsupportedOperationException("Read-only iterator.");
        }

        @Override // i.b.o0.c
        public void onComplete() {
        }
    }
    public c(w<T> wVar) {
        super();
        this.a = wVar;
    }

    @Override // java.lang.Iterable
    public Iterator<T> iterator() {
        final i.b.m0.e.e.c.a aVar = new c.a();
        r.wrap(this.a).materialize().subscribe(aVar);
        return aVar;
    }
}
