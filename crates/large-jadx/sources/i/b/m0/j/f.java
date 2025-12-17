package i.b.m0.j;

import i.b.l0.a;
import i.b.l0.f;
import java.util.concurrent.CountDownLatch;

/* loaded from: classes3.dex */
public final class f extends CountDownLatch implements f<Throwable>, a {

    public Throwable a;
    public f() {
        super(1);
    }

    @Override // java.util.concurrent.CountDownLatch
    public void a(Throwable throwable) {
        this.a = throwable;
        countDown();
    }

    @Override // java.util.concurrent.CountDownLatch
    public void accept(Object object) {
        a((Throwable)object);
    }

    @Override // java.util.concurrent.CountDownLatch
    public void run() {
        countDown();
    }
}
