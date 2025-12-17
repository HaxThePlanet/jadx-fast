package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.Unit;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0007\n\u0002\u0010\u0003\n\u0000\u0008\u0011\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0008\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0005J\u0008\u0010\u000c\u001a\u00020\u0007H\u0016J\u0010\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0008\u0010\u0006\u001a\u00020\u0007H\u0003R\u0014\u0010\u0006\u001a\u00020\u0007X\u0090\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0008\u0010\tR\u0014\u0010\n\u001a\u00020\u00078PX\u0090\u0004¢\u0006\u0006\u001a\u0004\u0008\u000b\u0010\t¨\u0006\u0010", d2 = {"Lkotlinx/coroutines/JobImpl;", "Lkotlinx/coroutines/JobSupport;", "Lkotlinx/coroutines/CompletableJob;", "parent", "Lkotlinx/coroutines/Job;", "(Lkotlinx/coroutines/Job;)V", "handlesException", "", "getHandlesException$kotlinx_coroutines_core", "()Z", "onCancelComplete", "getOnCancelComplete$kotlinx_coroutines_core", "complete", "completeExceptionally", "exception", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
public class JobImpl extends kotlinx.coroutines.JobSupport implements kotlinx.coroutines.CompletableJob {

    private final boolean handlesException;
    public JobImpl(kotlinx.coroutines.Job parent) {
        super(1);
        initParentJob(parent);
        this.handlesException = handlesException();
    }

    private final boolean handlesException() {
        kotlinx.coroutines.ChildHandle parentJob;
        kotlinx.coroutines.JobSupport parentHandle$kotlinx_coroutines_core;
        boolean z;
        final int i3 = 0;
        if (parentJob instanceof ChildHandleNode) {
        } else {
            parentJob = i3;
        }
        int i = 0;
        if (parentJob != null && parentJob.getJob() == null) {
            if (parentJob.getJob() == null) {
            }
            return i;
        }
        return i;
    }

    @Override // kotlinx.coroutines.JobSupport
    public boolean complete() {
        return makeCompleting$kotlinx_coroutines_core(Unit.INSTANCE);
    }

    @Override // kotlinx.coroutines.JobSupport
    public boolean completeExceptionally(Throwable exception) {
        CompletedExceptionally completedExceptionally = new CompletedExceptionally(exception, 0, 2, 0);
        return makeCompleting$kotlinx_coroutines_core(completedExceptionally);
    }

    @Override // kotlinx.coroutines.JobSupport
    public boolean getHandlesException$kotlinx_coroutines_core() {
        return this.handlesException;
    }

    @Override // kotlinx.coroutines.JobSupport
    public boolean getOnCancelComplete$kotlinx_coroutines_core() {
        return 1;
    }
}
