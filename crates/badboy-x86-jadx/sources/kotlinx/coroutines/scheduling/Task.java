package kotlinx.coroutines.scheduling;

import kotlin.Metadata;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0003\u0008!\u0018\u00002\u00060\u0001j\u0002`\u0002B\u0007\u0008\u0010¢\u0006\u0002\u0010\u0003B\u0017\u0008\u0000\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\u0008R\u0015\u0010\t\u001a\u00020\n8À\u0002X\u0080\u0004¢\u0006\u0006\u001a\u0004\u0008\u000b\u0010\u000cR\u0012\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u00020\u00078\u0000@\u0000X\u0081\u000e¢\u0006\u0002\n\u0000¨\u0006\r", d2 = {"Lkotlinx/coroutines/scheduling/Task;", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "()V", "submissionTime", "", "taskContext", "Lkotlinx/coroutines/scheduling/TaskContext;", "(JLkotlinx/coroutines/scheduling/TaskContext;)V", "mode", "", "getMode$kotlinx_coroutines_core", "()I", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
public abstract class Task implements Runnable {

    public long submissionTime;
    public kotlinx.coroutines.scheduling.TaskContext taskContext;
    public Task() {
        super(0, obj1, TasksKt.NonBlockingContext);
    }

    public Task(long submissionTime, kotlinx.coroutines.scheduling.TaskContext taskContext) {
        super();
        this.submissionTime = submissionTime;
        this.taskContext = obj3;
    }

    @Override // java.lang.Runnable
    public final int getMode$kotlinx_coroutines_core() {
        final int i = 0;
        return this.taskContext.getTaskMode();
    }
}
