package i.b.m0.d;

import i.b.j0.b;
import i.b.m0.j.e;
import i.b.m0.j.k;
import i.b.y;
import java.util.concurrent.CountDownLatch;

/* compiled from: BlockingBaseObserver.java */
/* loaded from: classes3.dex */
public abstract class e<T> extends CountDownLatch implements y<T>, b {

    T a;
    Throwable b;
    b c;
    volatile boolean v;
    public e() {
        super(1);
    }

    @Override // java.util.concurrent.CountDownLatch
    public final T a() {
        long count = getCount();
        if (count != 0) {
            try {
                e.b();
                await();
            } catch (java.lang.InterruptedException interrupted) {
                dispose();
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
    public final void dispose() {
        this.v = true;
        if (this.c != null) {
            this.c.dispose();
        }
    }

    @Override // java.util.concurrent.CountDownLatch
    public final boolean isDisposed() {
        return this.v;
    }

    @Override // java.util.concurrent.CountDownLatch
    public final void onComplete() {
        countDown();
    }

    @Override // java.util.concurrent.CountDownLatch
    public final void onSubscribe(b bVar) {
        this.c = bVar;
        if (this.v) {
            bVar.dispose();
        }
    }
}
