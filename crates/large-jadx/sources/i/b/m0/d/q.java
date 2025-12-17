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

/* loaded from: classes3.dex */
public final class q<T>  extends CountDownLatch implements d0<T>, Future<T>, b {

    T a;
    Throwable b;
    final AtomicReference<b> c;
    public q() {
        super(1);
        AtomicReference atomicReference = new AtomicReference();
        this.c = atomicReference;
    }

    @Override // java.util.concurrent.CountDownLatch
    public boolean cancel(boolean z) {
        c dISPOSED;
        Object obj3 = this.c.get();
        while ((b)obj3 != this) {
            dISPOSED = c.DISPOSED;
            obj3 = this.c.get();
        }
        return 0;
    }

    @Override // java.util.concurrent.CountDownLatch
    public void dispose() {
    }

    public T get() {
        if (Long.compare(count, i) != 0) {
            e.b();
            await();
        }
        if (isCancelled()) {
        } else {
            Throwable th = this.b;
            if (th != null) {
            } else {
                return this.a;
            }
            ExecutionException executionException = new ExecutionException(th);
            throw executionException;
        }
        CancellationException cancellationException = new CancellationException();
        throw cancellationException;
    }

    public T get(long l, TimeUnit timeUnit2) {
        int await;
        if (Long.compare(count, i) != 0) {
            e.b();
            if (!await(l, timeUnit2)) {
            } else {
            }
            TimeoutException timeoutException = new TimeoutException(k.d(l, timeUnit2));
            throw timeoutException;
        }
        if (isCancelled()) {
        } else {
            Throwable obj5 = this.b;
            if (obj5 != null) {
            } else {
                return this.a;
            }
            ExecutionException obj6 = new ExecutionException(obj5);
            throw obj6;
        }
        obj5 = new CancellationException();
        throw obj5;
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
        int i;
        i = Long.compare(count, i2) == 0 ? 1 : 0;
        return i;
    }

    @Override // java.util.concurrent.CountDownLatch
    public void onError(Throwable throwable) {
        Object obj = this.c.get();
        while ((b)obj == c.DISPOSED) {
            this.b = throwable;
            obj = this.c.get();
        }
        a.t(throwable);
    }

    @Override // java.util.concurrent.CountDownLatch
    public void onSubscribe(b b) {
        c.setOnce(this.c, b);
    }

    public void onSuccess(T t) {
        Object obj = this.c.get();
        if ((b)obj == c.DISPOSED) {
        }
        this.a = t;
        this.c.compareAndSet((b)obj, this);
        countDown();
    }
}
