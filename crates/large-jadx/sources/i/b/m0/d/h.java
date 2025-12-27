package i.b.m0.d;

import i.b.d;
import i.b.d0;
import i.b.j0.b;
import i.b.m0.j.e;
import i.b.m0.j.k;
import i.b.n;
import java.util.concurrent.CountDownLatch;

/* compiled from: BlockingMultiObserver.java */
/* loaded from: classes3.dex */
public final class h<T> extends CountDownLatch implements d0<T>, d, n<T> {

    T a;
    Throwable b;
    b c;
    volatile boolean v;
    public h() {
        super(1);
    }

    @Override // java.util.concurrent.CountDownLatch
    public T a() {
        long count = getCount();
        if (count != 0) {
            try {
                e.b();
                await();
            } catch (java.lang.InterruptedException interrupted) {
                b();
                Throwable interrupted2 = k.e(interrupted);
                throw interrupted2;
            }
        }
        if (this.b != null) {
            throw k.e(this.b);
        } else {
            return this.a;
        }
    }

    @Override // java.util.concurrent.CountDownLatch
    void b() {
        this.v = true;
        if (this.c != null) {
            this.c.dispose();
        }
    }

    @Override // java.util.concurrent.CountDownLatch
    public void onComplete() {
        countDown();
    }

    @Override // java.util.concurrent.CountDownLatch
    public void onError(Throwable th) {
        this.b = th;
        countDown();
    }

    @Override // java.util.concurrent.CountDownLatch
    public void onSubscribe(b bVar) {
        this.c = bVar;
        if (this.v) {
            bVar.dispose();
        }
    }

    @Override // java.util.concurrent.CountDownLatch
    public void onSuccess(T t) {
        this.a = t;
        countDown();
    }
}
