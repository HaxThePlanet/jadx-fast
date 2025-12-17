package f.c.a.f.a.d;

import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public final class e {

    private static ThreadPoolExecutor a;
    public static Executor a() {
        ThreadPoolExecutor threadPoolExecutor;
        int i3;
        int i2;
        int i4;
        int i;
        TimeUnit sECONDS;
        LinkedBlockingQueue linkedBlockingQueue;
        f.c.a.f.a.d.d dVar;
        if (e.a == null) {
            linkedBlockingQueue = new LinkedBlockingQueue();
            dVar = new d();
            super(1, 1, 10, obj5, TimeUnit.SECONDS, linkedBlockingQueue, dVar);
            e.a = threadPoolExecutor;
            threadPoolExecutor.allowCoreThreadTimeOut(true);
        }
        return e.a;
    }
}
