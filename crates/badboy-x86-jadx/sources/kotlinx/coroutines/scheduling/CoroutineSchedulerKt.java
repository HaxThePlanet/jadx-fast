package kotlinx.coroutines.scheduling;

import kotlin.Metadata;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0001\u001a\u0010\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0001¨\u0006\u0005", d2 = {"isSchedulerWorker", "", "thread", "Ljava/lang/Thread;", "mayNotBlock", "kotlinx-coroutines-core"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class CoroutineSchedulerKt {
    public static final boolean isSchedulerWorker(Thread thread) {
        return thread instanceof CoroutineScheduler.Worker;
    }

    public static final boolean mayNotBlock(Thread thread) {
        boolean state;
        int i;
        kotlinx.coroutines.scheduling.CoroutineScheduler.WorkerState cPU_ACQUIRED;
        if (thread instanceof CoroutineScheduler.Worker && obj.state == CoroutineScheduler.WorkerState.CPU_ACQUIRED) {
            i = obj.state == CoroutineScheduler.WorkerState.CPU_ACQUIRED ? 1 : 0;
        } else {
        }
        return i;
    }
}
