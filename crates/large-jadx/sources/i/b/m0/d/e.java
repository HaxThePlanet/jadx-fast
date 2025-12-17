package i.b.m0.d;

import i.b.j0.b;
import i.b.m0.j.e;
import i.b.m0.j.k;
import i.b.y;
import java.util.concurrent.CountDownLatch;

/* loaded from: classes3.dex */
public abstract class e<T>  extends CountDownLatch implements y<T>, b {

    T a;
    Throwable b;
    b c;
    volatile boolean v;
    public e() {
        super(1);
    }

    public final T a() {
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
    public final void dispose() {
        this.v = true;
        b bVar = this.c;
        if (bVar != null) {
            bVar.dispose();
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
    public final void onSubscribe(b b) {
        this.c = b;
        if (this.v) {
            b.dispose();
        }
    }
}
