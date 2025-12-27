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

/* compiled from: BlockingObservableNext.java */
/* loaded from: classes3.dex */
public final class e<T> implements Iterable<T> {

    final w<T> a;

    static final class a<T> implements Iterator<T> {

        private final e.b<T> a;
        private final w<T> b;
        private T c;
        private boolean v = true;
        private boolean w = true;
        private Throwable x;
        private boolean y;
        a(w<T> wVar, e.b<T> bVar) {
            super();
            this.b = wVar;
            this.a = bVar;
        }

        private boolean b() throws x1 {
            boolean z2 = true;
            if (!this.y) {
                this.y = z2;
                this.a.d();
                new x1(this.b).subscribe(this.a);
            }
            try {
                q qVar = this.a.e();
            } catch (java.lang.InterruptedException interrupted) {
                this.a.dispose();
                this.x = interrupted;
                Throwable interrupted2 = k.e(interrupted);
                throw interrupted2;
            }
            final boolean z5 = false;
            if (qVar.h()) {
                this.w = z5;
                this.c = qVar.e();
                return true;
            }
            this.v = z5;
            if (!qVar.f()) {
                Throwable th2 = qVar.d();
                this.x = th2;
                throw k.e(th2);
            } else {
                return false;
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            boolean z;
            boolean z2 = true;
            if (this.x != null) {
                throw k.e(this.x);
            } else {
                z2 = false;
                if (!this.v) {
                    return false;
                }
                int r1 = 1;
                return true;
            }
        }

        @Override // java.util.Iterator
        public T next() {
            if (this.x != null) {
                throw k.e(this.x);
            } else {
                if (!hasNext()) {
                    throw new NoSuchElementException("No more elements");
                } else {
                    this.w = true;
                    return this.c;
                }
            }
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Read only iterator");
        }
    }

    static final class b<T> extends c<q<T>> {

        private final BlockingQueue<q<T>> b = new ArrayBlockingQueue<>(1);
        final AtomicInteger c = new AtomicInteger();
        b() {
            super();
            ArrayBlockingQueue arrayBlockingQueue = new ArrayBlockingQueue(1);
            AtomicInteger atomicInteger = new AtomicInteger();
        }

        @Override // i.b.o0.c
        public void c(q<T> qVar) throws java.lang.InterruptedException {
            int i = 1;
            Object poll;
            i = 1;
            if (this.c.getAndSet(0) == 1 || !qVar.h()) {
                while (!this.b.offer(poll)) {
                    poll = this.b.poll();
                }
            }
        }

        @Override // i.b.o0.c
        void d() {
            this.c.set(1);
        }

        @Override // i.b.o0.c
        public q<T> e() throws java.lang.InterruptedException {
            d();
            e.b();
            return (q)this.b.take();
        }

        @Override // i.b.o0.c
        public void onError(Throwable th) {
            a.t(th);
        }

        @Override // i.b.o0.c
        public void onComplete() {
        }
    }
    public e(w<T> wVar) {
        super();
        this.a = wVar;
    }

    @Override // java.lang.Iterable
    public Iterator<T> iterator() {
        return new e.a(this.a, new e.b());
    }
}
