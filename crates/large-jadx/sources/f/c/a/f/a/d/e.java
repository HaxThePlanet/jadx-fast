package f.c.a.f.a.d;

import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.play:core@@1.10.2 */
/* loaded from: classes2.dex */
public final class e {

    private static ThreadPoolExecutor a;
    public static Executor a() {
        if (e.a == null) {
            int i = 1;
            int i2 = 1;
            long l = 10L;
            ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(i, i2, l, timeUnit, TimeUnit.SECONDS, new LinkedBlockingQueue(), new d());
            e.a = threadPoolExecutor;
            boolean z = true;
            threadPoolExecutor.allowCoreThreadTimeOut(z);
        }
        return e.a;
    }
}
