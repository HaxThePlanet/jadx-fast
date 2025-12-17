package i.b.m0.e.e;

import i.b.j0.b;
import i.b.m0.a.c;
import i.b.m0.f.c;
import i.b.m0.j.e;
import i.b.m0.j.k;
import i.b.w;
import i.b.y;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* loaded from: classes3.dex */
public final class b<T>  implements Iterable<T> {

    final w<? extends T> a;
    final int b;

    static final class a extends AtomicReference<b> implements y<T>, Iterator<T>, b {

        private static final long serialVersionUID = 6695226475494099826L;
        final Condition condition;
        volatile boolean done;
        volatile Throwable error;
        final Lock lock;
        final c<T> queue;
        a(int i) {
            super();
            c cVar = new c(i);
            this.queue = cVar;
            ReentrantLock obj2 = new ReentrantLock();
            this.lock = obj2;
            this.condition = obj2.newCondition();
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        void b() {
            this.lock.lock();
            this.condition.signalAll();
            this.lock.unlock();
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void dispose() {
            c.dispose(this);
            b();
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public boolean hasNext() {
            boolean error;
            Lock condition;
            boolean disposed;
            final int i2 = 0;
            while (isDisposed()) {
                boolean empty = this.queue.isEmpty();
                if (empty) {
                }
                e.b();
                this.lock.lock();
                while (!this.done) {
                    if (this.queue.isEmpty()) {
                    }
                    if (!isDisposed()) {
                    }
                    this.condition.await();
                }
                this.lock.unlock();
                i2 = 0;
                if (this.queue.isEmpty()) {
                }
                if (!isDisposed()) {
                }
                this.condition.await();
                error = this.error;
            }
            Throwable error2 = this.error;
            if (error2 != null) {
            } else {
                return i2;
            }
            throw k.e(error2);
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public boolean isDisposed() {
            return c.isDisposed((b)get());
        }

        public T next() {
            if (!hasNext()) {
            } else {
                return this.queue.poll();
            }
            NoSuchElementException noSuchElementException = new NoSuchElementException();
            throw noSuchElementException;
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void onComplete() {
            this.done = true;
            b();
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void onError(Throwable throwable) {
            this.error = throwable;
            this.done = true;
            b();
        }

        public void onNext(T t) {
            this.queue.offer(t);
            b();
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void onSubscribe(b b) {
            c.setOnce(this, b);
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void remove() {
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("remove");
            throw unsupportedOperationException;
        }
    }
    public b(w<? extends T> w, int i2) {
        super();
        this.a = w;
        this.b = i2;
    }

    public Iterator<T> iterator() {
        b.a aVar = new b.a(this.b);
        this.a.subscribe(aVar);
        return aVar;
    }
}
