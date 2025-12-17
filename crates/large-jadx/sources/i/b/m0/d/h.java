package i.b.m0.d;

import i.b.d;
import i.b.d0;
import i.b.j0.b;
import i.b.m0.j.e;
import i.b.m0.j.k;
import i.b.n;
import java.util.concurrent.CountDownLatch;

/* loaded from: classes3.dex */
public final class h<T>  extends CountDownLatch implements d0<T>, d, n<T> {

    T a;
    Throwable b;
    b c;
    volatile boolean v;
    public h() {
        super(1);
    }

    public T a() {
        if (Long.compare(count, i) != 0) {
            e.b();
            await();
        }
        Throwable th2 = this.b;
        if (th2 != null) {
        } else {
            return this.a;
        }
        throw k.e(th2);
    }

    @Override // java.util.concurrent.CountDownLatch
    void b() {
        this.v = true;
        b bVar = this.c;
        if (bVar != null) {
            bVar.dispose();
        }
    }

    @Override // java.util.concurrent.CountDownLatch
    public void onComplete() {
        countDown();
    }

    @Override // java.util.concurrent.CountDownLatch
    public void onError(Throwable throwable) {
        this.b = throwable;
        countDown();
    }

    @Override // java.util.concurrent.CountDownLatch
    public void onSubscribe(b b) {
        this.c = b;
        if (this.v) {
            b.dispose();
        }
    }

    public void onSuccess(T t) {
        this.a = t;
        countDown();
    }
}
