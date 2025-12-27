package i.b.m0.d;

import i.b.j0.b;
import java.util.concurrent.CountDownLatch;

/* compiled from: BlockingFirstObserver.java */
/* loaded from: classes3.dex */
public final class f<T> extends e<T> {
    @Override // i.b.m0.d.e
    public void onError(Throwable th) {
        if (this.a == null) {
            this.b = th;
        }
        countDown();
    }

    @Override // i.b.m0.d.e
    public void onNext(T t) {
        if (this.a == null) {
            this.a = t;
            this.c.dispose();
            countDown();
        }
    }
}
