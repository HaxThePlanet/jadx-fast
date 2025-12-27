package i.b.m0.d;

import i.b.j0.b;
import i.b.m0.a.c;
import i.b.m0.j.e;
import i.b.m0.j.k;
import i.b.p0.a;
import i.b.y;
import java.util.NoSuchElementException;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: FutureObserver.java */
/* loaded from: classes3.dex */
public final class p<T> extends CountDownLatch implements y<T>, Future<T>, b {

    T a;
    Throwable b;
    final AtomicReference<b> c = new AtomicReference<>();
    public p() {
        super(1);
        AtomicReference atomicReference = new AtomicReference();
    }

    @Override // java.util.concurrent.CountDownLatch
    public boolean cancel(boolean z) {
        Object obj = this.c.get();
        while (obj != this) {
            dISPOSED2 = c.DISPOSED;
            if (this.c.compareAndSet(obj, dISPOSED2)) {
            }
            obj = this.c.get();
        }
        return false;
    }

    @Override // java.util.concurrent.CountDownLatch
    public T get() throws ExecutionException, CancellationException, java.lang.InterruptedException {
        long count = getCount();
        if (count != 0) {
            e.b();
            await();
        }
        if (isCancelled()) {
            throw new CancellationException();
        } else {
            if (this.b != null) {
                throw new ExecutionException(th);
            } else {
                return this.a;
            }
        }
    }

    @Override // java.util.concurrent.CountDownLatch
    public boolean isCancelled() {
        return c.isDisposed((b)this.c.get());
    }

    @Override // java.util.concurrent.CountDownLatch
    public boolean isDisposed() {
        return isDone();
    }

    @Override // java.util.concurrent.CountDownLatch
    public boolean isDone() {
        boolean z = true;
        long count = getCount();
        int r0 = count == 0 ? 1 : 0;
        return (count == 0 ? 1 : 0);
    }

    @Override // java.util.concurrent.CountDownLatch
    public void onComplete() {
        AtomicReference atomicReference;
        if (this.a == null) {
            onError(new NoSuchElementException("The source is empty"));
            return;
        }
        Object obj2 = this.c.get();
        while (obj2 != this) {
            if (this.c.compareAndSet(obj2, this)) {
                countDown();
            }
            obj2 = this.c.get();
        }
    }

    @Override // java.util.concurrent.CountDownLatch
    public void onError(Throwable th) {
        AtomicReference atomicReference;
        if (this.b == null) {
            this.b = th;
            Object obj = this.c.get();
            while (obj != this) {
                if (this.c.compareAndSet(obj, this)) {
                    countDown();
                    return;
                }
                obj = this.c.get();
            }
            a.t(th);
            return;
        }
        a.t(th);
    }

    @Override // java.util.concurrent.CountDownLatch
    public void onNext(T t) {
        if (this.a != null) {
            (b)this.c.get().dispose();
            onError(new IndexOutOfBoundsException("More than one element received"));
            return;
        }
        this.a = t;
    }

    @Override // java.util.concurrent.CountDownLatch
    public void onSubscribe(b bVar) {
        c.setOnce(this.c, bVar);
    }

    @Override // java.util.concurrent.CountDownLatch
    public T get(long j, TimeUnit timeUnit) throws TimeoutException, java.lang.InterruptedException, CancellationException, ExecutionException {
        long count = getCount();
        if (count != 0) {
            e.b();
            if (!await(j, timeUnit)) {
                throw new TimeoutException(k.d(j, timeUnit));
            }
        }
        if (isCancelled()) {
            throw new CancellationException();
        } else {
            if (this.b != null) {
                throw new ExecutionException(th);
            } else {
                return this.a;
            }
        }
    }

    @Override // java.util.concurrent.CountDownLatch
    public void dispose() {
    }
}
