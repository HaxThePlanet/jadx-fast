package i.b.m0.d;

import java.util.concurrent.CountDownLatch;

/* compiled from: BlockingLastObserver.java */
/* loaded from: classes3.dex */
public final class g<T> extends e<T> {
    @Override // i.b.m0.d.e
    public void onError(Throwable th) {
        this.a = null;
        this.b = th;
        countDown();
    }

    @Override // i.b.m0.d.e
    public void onNext(T t) {
        this.a = t;
    }
}
