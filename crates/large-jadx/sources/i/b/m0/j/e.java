package i.b.m0.j;

import i.b.j0.b;
import i.b.p0.a;
import java.util.concurrent.CountDownLatch;

/* loaded from: classes3.dex */
public final class e {
    public static void a(CountDownLatch countDownLatch, b b2) {
        if (Long.compare(count, i) == 0) {
        }
        e.b();
        countDownLatch.await();
    }

    public static void b() {
        boolean z;
        if (a.j()) {
            if (currentThread instanceof g) {
            } else {
                if (a.r()) {
                } else {
                }
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Attempt to block on a Scheduler ");
            stringBuilder.append(Thread.currentThread().getName());
            stringBuilder.append(" that doesn't support blocking operators as they may lead to deadlock");
            IllegalStateException illegalStateException = new IllegalStateException(stringBuilder.toString());
            throw illegalStateException;
        }
    }
}
