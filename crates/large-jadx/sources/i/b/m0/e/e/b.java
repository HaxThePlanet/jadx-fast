package i.b.m0.e.e;

import i.b.j0.b;
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

/* compiled from: BlockingObservableIterable.java */
/* loaded from: classes3.dex */
public final class b<T> implements Iterable<T> {

    final w<? extends T> a;
    final int b;

    static final class a<T> extends AtomicReference<b> implements y<T>, Iterator<T>, b {

        private static final long serialVersionUID = 6695226475494099826L;
        final Condition condition;
        volatile boolean done;
        volatile Throwable error;
        final Lock lock = new ReentrantLock();
        final i.b.m0.f.c<T> queue = new c<>();
        a(int i) {
            super();
            final i.b.m0.f.c cVar = new c(i);
            this.condition = new ReentrantLock().newCondition();
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        void b() {
            this.lock.lock();
            try {
                this.condition.signalAll();
            } finally {
                this.lock.unlock();
                throw th;
            }
            this.lock.unlock();
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void dispose() {
            c.dispose(this);
            b();
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public boolean hasNext() {
            final boolean z = false;
            while (isDisposed()) {
                boolean empty = this.queue.isEmpty();
                if (!this.done || this.error == null) {
                }
            }
            if (this.error != null) {
                throw k.e(this.error);
            } else {
                return false;
            }
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public boolean isDisposed() {
            return c.isDisposed((b)get());
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            } else {
                return this.queue.poll();
            }
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void onComplete() {
            this.done = true;
            b();
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void onError(Throwable th) {
            this.error = th;
            this.done = true;
            b();
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void onNext(T t) {
            this.queue.offer(t);
            b();
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void onSubscribe(b bVar) {
            c.setOnce(this, bVar);
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void remove() {
            throw new UnsupportedOperationException("remove");
        }
    }
    public b(w<? extends T> wVar, int i) {
        super();
        this.a = wVar;
        this.b = i;
    }

    @Override // java.lang.Iterable
    public Iterator<T> iterator() {
        final i.b.m0.e.e.b.a aVar = new b.a(this.b);
        this.a.subscribe(aVar);
        return aVar;
    }
}
