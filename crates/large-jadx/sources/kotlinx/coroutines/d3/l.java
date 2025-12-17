package kotlinx.coroutines.d3;

import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.h0.g;
import kotlinx.coroutines.internal.a0;

/* loaded from: classes3.dex */
@Metadata(d1 = "\u0000,\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0010\t\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\u0008\u0002\"\u0010\u0010\u0000\u001a\u00020\u00018\u0000X\u0081\u0004¢\u0006\u0002\n\u0000\"\u0010\u0010\u0002\u001a\u00020\u00018\u0000X\u0081\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000\"\u0010\u0010\u0006\u001a\u00020\u00078\u0000X\u0081\u0004¢\u0006\u0002\n\u0000\"\u0010\u0010\u0008\u001a\u00020\u00018\u0000X\u0081\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\t\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\n\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u0010\u0010\u000b\u001a\u00020\u00078\u0000X\u0081\u0004¢\u0006\u0002\n\u0000\"\u0012\u0010\u000c\u001a\u00020\r8\u0000@\u0000X\u0081\u000e¢\u0006\u0002\n\u0000\"\u0019\u0010\u000e\u001a\u00020\u000f*\u00020\u00108À\u0002X\u0080\u0004¢\u0006\u0006\u001a\u0004\u0008\u000e\u0010\u0011¨\u0006\u0012", d2 = {"BLOCKING_DEFAULT_PARALLELISM", "", "CORE_POOL_SIZE", "DEFAULT_DISPATCHER_NAME", "", "DEFAULT_SCHEDULER_NAME", "IDLE_WORKER_KEEP_ALIVE_NS", "", "MAX_POOL_SIZE", "TASK_NON_BLOCKING", "TASK_PROBABLY_BLOCKING", "WORK_STEALING_TIME_RESOLUTION_NS", "schedulerTimeSource", "Lkotlinx/coroutines/scheduling/SchedulerTimeSource;", "isBlocking", "", "Lkotlinx/coroutines/scheduling/Task;", "(Lkotlinx/coroutines/scheduling/Task;)Z", "kotlinx-coroutines-core"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class l {

    public static final long a;
    public static final int b;
    public static final int c;
    public static final long d;
    public static kotlinx.coroutines.d3.h e;
    static {
        int i26 = 0;
        l.a = a0.g("kotlinx.coroutines.scheduler.resolution.ns", 100000, obj2, 0, obj4, 0);
        int i18 = 0;
        int i24 = 0;
        a0.f("kotlinx.coroutines.scheduler.blocking.parallelism", 16, 0, i18, 12, i24);
        int i2 = a0.f("kotlinx.coroutines.scheduler.core.pool.size", g.b(a0.a(), 2), 1, i18, 8, i24);
        l.b = i2;
        String str5 = "kotlinx.coroutines.scheduler.max.pool.size";
        int i25 = 4;
        l.c = a0.f(str5, g.g(i6 *= 128, i2, 2097150), i18, 2097150, i25, i26);
        int i9 = 60;
        l.d = TimeUnit.SECONDS.toNanos(a0.g("kotlinx.coroutines.scheduler.keep.alive.sec", i9, str5, 0, i18, 0));
        l.e = f.a;
    }
}
