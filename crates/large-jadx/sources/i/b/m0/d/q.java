package i.b.m0.d;

import i.b.d0;
import i.b.j0.b;
import i.b.m0.a.c;
import i.b.m0.j.e;
import i.b.m0.j.k;
import i.b.p0.a;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: FutureSingleObserver.java */
/* loaded from: classes3.dex */
public final class q<T> extends CountDownLatch implements d0<T>, Future<T>, b {

    T a;
    Throwable b;
    final AtomicReference<b> c = new AtomicReference<>();
    public q() {
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
    public T get() throws CancellationException, java.lang.InterruptedException, ExecutionException {
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
    public void onError(Throwable th) {
        Object obj = this.c.get();
        while (obj == c.DISPOSED) {
            this.b = th;
            if (this.c.compareAndSet(obj, this)) {
                countDown();
                return;
            }
            obj = this.c.get();
        }
        a.t(th);
    }

    @Override // java.util.concurrent.CountDownLatch
    public void onSubscribe(b bVar) {
        c.setOnce(this.c, bVar);
    }

    @Override // java.util.concurrent.CountDownLatch
    public void onSuccess(T t) {
        Object obj = this.c.get();
        if (obj == c.DISPOSED) {
            return;
        }
        this.a = t;
        this.c.compareAndSet(obj, this);
        countDown();
    }

    @Override // java.util.concurrent.CountDownLatch
    public T get(long j, TimeUnit timeUnit) throws TimeoutException, ExecutionException, java.lang.InterruptedException, CancellationException {
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
