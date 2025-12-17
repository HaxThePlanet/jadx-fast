package i.b.m0.d;

import java.util.concurrent.CountDownLatch;

/* loaded from: classes3.dex */
public final class g<T>  extends i.b.m0.d.e<T> {
    @Override // i.b.m0.d.e
    public void onError(Throwable throwable) {
        this.a = 0;
        this.b = throwable;
        countDown();
    }

    public void onNext(T t) {
        this.a = t;
    }
}
