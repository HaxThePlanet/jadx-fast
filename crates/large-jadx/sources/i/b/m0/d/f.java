package i.b.m0.d;

import i.b.j0.b;
import java.util.concurrent.CountDownLatch;

/* loaded from: classes3.dex */
public final class f<T>  extends i.b.m0.d.e<T> {
    @Override // i.b.m0.d.e
    public void onError(Throwable throwable) {
        if (this.a == null) {
            this.b = throwable;
        }
        countDown();
    }

    public void onNext(T t) {
        Object obj2;
        if (this.a == null) {
            this.a = t;
            this.c.dispose();
            countDown();
        }
    }
}
