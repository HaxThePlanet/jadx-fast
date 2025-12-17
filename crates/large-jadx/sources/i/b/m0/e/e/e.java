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
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes3.dex */
public final class e<T>  implements Iterable<T> {

    final w<T> a;

    static final class a implements Iterator<T> {

        private final i.b.m0.e.e.e.b<T> a;
        private final w<T> b;
        private T c;
        private boolean v = true;
        private boolean w = true;
        private Throwable x;
        private boolean y;
        a(w<T> w, i.b.m0.e.e.e.b<T> e$b2) {
            super();
            final int i = 1;
            this.b = w;
            this.a = b2;
        }

        private boolean b() {
            boolean x1Var;
            i.b.m0.e.e.e.b bVar;
            int i = 1;
            if (!this.y) {
                this.y = i;
                this.a.d();
                x1Var = new x1(this.b);
                x1Var.subscribe(this.a);
            }
            q qVar = this.a.e();
            final int i2 = 0;
            if (qVar.h()) {
                this.w = i2;
                this.c = qVar.e();
                return i;
            }
            this.v = i2;
            if (!qVar.f()) {
            } else {
                return i2;
            }
            Throwable th2 = qVar.d();
            this.x = th2;
            throw k.e(th2);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            boolean z;
            int i;
            Throwable th = this.x;
            if (th != null) {
            } else {
                if (!this.v) {
                    return 0;
                }
                if (this.w) {
                    if (b()) {
                        i = 1;
                    }
                } else {
                }
                return i;
            }
            throw k.e(th);
        }

        public T next() {
            Throwable th = this.x;
            if (th != null) {
            } else {
                if (!hasNext()) {
                } else {
                    this.w = true;
                    return this.c;
                }
                NoSuchElementException noSuchElementException = new NoSuchElementException("No more elements");
                throw noSuchElementException;
            }
            throw k.e(th);
        }

        @Override // java.util.Iterator
        public void remove() {
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Read only iterator");
            throw unsupportedOperationException;
        }
    }

    static final class b extends c<q<T>> {

        private final BlockingQueue<q<T>> b;
        final AtomicInteger c;
        b() {
            super();
            ArrayBlockingQueue arrayBlockingQueue = new ArrayBlockingQueue(1);
            this.b = arrayBlockingQueue;
            AtomicInteger atomicInteger = new AtomicInteger();
            this.c = atomicInteger;
        }

        public void c(q<T> q) {
            boolean andSet;
            int i;
            Object obj3;
            if (this.c.getAndSet(0) != 1 && !q.h()) {
                if (!q.h()) {
                }
            }
        }

        @Override // i.b.o0.c
        void d() {
            this.c.set(1);
        }

        public q<T> e() {
            d();
            e.b();
            return (q)this.b.take();
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
    }
    public e(w<T> w) {
        super();
        this.a = w;
    }

    public Iterator<T> iterator() {
        e.b bVar = new e.b();
        e.a aVar = new e.a(this.a, bVar);
        return aVar;
    }
}
