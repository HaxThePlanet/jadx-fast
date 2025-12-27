package i.b.m0.j;

import i.b.j0.b;
import i.b.p0.a;
import java.util.concurrent.CountDownLatch;

/* compiled from: BlockingHelper.java */
/* loaded from: classes3.dex */
public final class e {
    public static void a(CountDownLatch countDownLatch, b bVar) {
        long count = countDownLatch.getCount();
        if (count == 0) {
            return;
        }
        try {
            e.b();
            countDownLatch.await();
        } catch (java.lang.InterruptedException interrupted) {
            bVar.dispose();
            bVar = Thread.currentThread();
            bVar.interrupt();
            bVar = new IllegalStateException("Interrupted while waiting for subscription to complete.", interrupted);
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) bVar;
        }
    }

    public static void b() {
        if (a.j()) {
            z = Thread.currentThread() instanceof g;
            if (Thread.currentThread() instanceof g) {
                StringBuilder stringBuilder = new StringBuilder();
                String str = "Attempt to block on a Scheduler ";
                String name = Thread.currentThread().getName();
                String str2 = " that doesn't support blocking operators as they may lead to deadlock";
                r1 = str + name + str2;
                throw new IllegalStateException(r1);
            }
        }
    }
}
