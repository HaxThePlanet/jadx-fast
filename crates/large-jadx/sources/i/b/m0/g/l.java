package i.b.m0.g;

import i.b.l0.n;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: SchedulerPoolFactory.java */
/* loaded from: classes3.dex */
public final class l {

    public static final boolean a = false;
    public static final int b = 0;
    static final AtomicReference<ScheduledExecutorService> c = new AtomicReference<>();
    static final Map<ScheduledThreadPoolExecutor, Object> d = new ConcurrentHashMap<>();

    static final class a implements Runnable {
        a() {
            super();
        }

        @Override // java.lang.Runnable
        public void run() {
            Iterator it = new ArrayList(l.d.keySet()).iterator();
            while (it.hasNext()) {
                java.util.Set keys = it.next();
            }
        }
    }

    static final class b implements n<String, String> {
        b() {
            super();
        }

        public String a(String str) {
            return System.getProperty(str);
        }
    }
    static {
        i.b.m0.g.l.b bVar = new l.b();
        final boolean z = true;
        boolean z2 = l.b(z, "rx2.purge-enabled", z, z, bVar);
        l.a = z2;
        l.b = l.c(z2, "rx2.purge-period-seconds", z, z, bVar);
        l.d();
    }

    public static ScheduledExecutorService a(ThreadFactory threadFactory) {
        final ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(1, threadFactory);
        l.e(l.a, scheduledThreadPool);
        return scheduledThreadPool;
    }

    static boolean b(boolean z, String str, boolean z2, boolean z3, n<String, String> nVar) {
        if (z) {
            try {
                Object apply = nVar.apply(str);
                if (apply == null) {
                    return z2;
                }
            } catch (Throwable unused) {
                return z2;
            }
            return "true".equals(apply);
        }
        return z3;
    }

    static int c(boolean z, String str, int i, int i2, n<String, String> nVar) {
        if (z) {
            try {
                Object apply = nVar.apply(str);
                if (apply == null) {
                    return i;
                }
            } catch (Throwable unused) {
                return i;
            }
            return Integer.parseInt(apply);
        }
        return i2;
    }

    public static void d() {
        l.f(l.a);
    }

    static void e(boolean z, ScheduledExecutorService scheduledExecutorService) {
        if (z) {
            z2 = scheduledExecutorService instanceof ScheduledThreadPoolExecutor;
            if (scheduledExecutorService instanceof ScheduledThreadPoolExecutor) {
                l.d.put((ScheduledThreadPoolExecutor)scheduledExecutorService, scheduledExecutorService);
            }
        }
    }

    static void f(boolean z) {
        if (z) {
            AtomicReference atomicReference = l.c;
            Object obj = atomicReference.get();
            while (obj != null) {
                int i = 1;
                str = "RxSchedulerPurge";
                ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(i, new h(str));
                if (l.c.compareAndSet(obj, scheduledThreadPool)) {
                    int i2 = l.b;
                    scheduledThreadPool.scheduleAtFixedRate(new l.a(), (long)i2, (long)i2, TimeUnit.SECONDS);
                    return;
                }
            }
            return;
        }
    }
}
