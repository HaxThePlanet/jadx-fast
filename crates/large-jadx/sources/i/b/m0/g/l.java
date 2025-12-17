package i.b.m0.g;

import i.b.l0.n;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes3.dex */
public final class l {

    public static final boolean a;
    public static final int b;
    static final AtomicReference<ScheduledExecutorService> c;
    static final Map<ScheduledThreadPoolExecutor, Object> d;

    static final class a implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
            java.util.Set keySet;
            Map shutdown;
            ArrayList arrayList = new ArrayList(l.d.keySet());
            Iterator iterator = arrayList.iterator();
            while (iterator.hasNext()) {
                keySet = iterator.next();
                if ((ScheduledThreadPoolExecutor)keySet.isShutdown()) {
                } else {
                }
                keySet.purge();
                l.d.remove(keySet);
            }
        }
    }

    static final class b implements n<String, String> {
        @Override // i.b.l0.n
        public String a(String string) {
            return System.getProperty(string);
        }

        @Override // i.b.l0.n
        public Object apply(Object object) {
            return a((String)object);
        }
    }
    static {
        AtomicReference atomicReference = new AtomicReference();
        l.c = atomicReference;
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        l.d = concurrentHashMap;
        l.b bVar = new l.b();
        final int i2 = 1;
        boolean z = l.b(i2, "rx2.purge-enabled", i2, i2, bVar);
        l.a = z;
        l.b = l.c(z, "rx2.purge-period-seconds", i2, i2, bVar);
        l.d();
    }

    public static ScheduledExecutorService a(ThreadFactory threadFactory) {
        final ScheduledExecutorService obj1 = Executors.newScheduledThreadPool(1, threadFactory);
        l.e(l.a, obj1);
        return obj1;
    }

    static boolean b(boolean z, String string2, boolean z3, boolean z4, n<String, String> n5) {
        Object obj0 = n5.apply(string2);
        if (z && (String)obj0 == null) {
            obj0 = n5.apply(string2);
            if ((String)(String)obj0 == null) {
                try {
                    return z3;
                    return "true".equals((String)(String)obj0);
                    return z3;
                    return z4;
                }
            }
        }
    }

    static int c(boolean z, String string2, int i3, int i4, n<String, String> n5) {
        Object obj0 = n5.apply(string2);
        if (z && (String)obj0 == null) {
            obj0 = n5.apply(string2);
            if ((String)(String)obj0 == null) {
                try {
                    return i3;
                    return Integer.parseInt((String)(String)obj0);
                    return i3;
                    return i4;
                }
            }
        }
    }

    public static void d() {
        l.f(l.a);
    }

    static void e(boolean z, ScheduledExecutorService scheduledExecutorService2) {
        Map map;
        boolean obj1;
        if (z && scheduledExecutorService2 instanceof ScheduledThreadPoolExecutor) {
            if (scheduledExecutorService2 instanceof ScheduledThreadPoolExecutor) {
                l.d.put((ScheduledThreadPoolExecutor)scheduledExecutorService2, scheduledExecutorService2);
            }
        }
    }

    static void f(boolean z) {
        Object obj;
        int i;
        i.b.m0.g.h hVar;
        String str;
        ScheduledExecutorService scheduledThreadPool;
        boolean obj11;
        if (z) {
        }
    }
}
