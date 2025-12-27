package i.b.m0.j;

import i.b.l0.a;
import i.b.l0.f;
import java.util.concurrent.CountDownLatch;

/* compiled from: BlockingIgnoringReceiver.java */
/* loaded from: classes3.dex */
public final class f extends CountDownLatch implements f<Throwable>, a {

    public Throwable a;
    public f() {
        super(1);
    }

    @Override // java.util.concurrent.CountDownLatch
    public void a(Throwable th) {
        this.a = th;
        countDown();
    }

    @Override // java.util.concurrent.CountDownLatch
    public void run() {
        countDown();
    }
}
