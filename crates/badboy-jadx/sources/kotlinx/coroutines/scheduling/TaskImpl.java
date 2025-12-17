package kotlinx.coroutines.scheduling;

import kotlin.Metadata;
import kotlinx.coroutines.DebugStringsKt;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0008\u0000\u0018\u00002\u00020\u0001B!\u0012\n\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0008¢\u0006\u0002\u0010\tJ\u0008\u0010\n\u001a\u00020\u000bH\u0016J\u0008\u0010\u000c\u001a\u00020\rH\u0016R\u0014\u0010\u0002\u001a\u00060\u0003j\u0002`\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e", d2 = {"Lkotlinx/coroutines/scheduling/TaskImpl;", "Lkotlinx/coroutines/scheduling/Task;", "block", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "submissionTime", "", "taskContext", "Lkotlinx/coroutines/scheduling/TaskContext;", "(Ljava/lang/Runnable;JLkotlinx/coroutines/scheduling/TaskContext;)V", "run", "", "toString", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class TaskImpl extends kotlinx.coroutines.scheduling.Task {

    public final Runnable block;
    public TaskImpl(Runnable block, long submissionTime, kotlinx.coroutines.scheduling.TaskContext taskContext) {
        super(submissionTime, taskContext, obj4);
        this.block = block;
    }

    @Override // kotlinx.coroutines.scheduling.Task
    public void run() {
        this.block.run();
        this.taskContext.afterTask();
    }

    @Override // kotlinx.coroutines.scheduling.Task
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = ", ";
        return stringBuilder.append("Task[").append(DebugStringsKt.getClassSimpleName(this.block)).append('@').append(DebugStringsKt.getHexAddress(this.block)).append(str2).append(this.submissionTime).append(str2).append(this.taskContext).append(']').toString();
    }
}
