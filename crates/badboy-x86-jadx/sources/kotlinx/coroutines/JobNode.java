package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0008 \u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0005¢\u0006\u0002\u0010\u0004J\u0008\u0010\u0012\u001a\u00020\u0013H\u0016J\u0008\u0010\u0014\u001a\u00020\u0015H\u0016R\u0014\u0010\u0005\u001a\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u0005\u0010\u0007R\u001a\u0010\u0008\u001a\u00020\tX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\u0008\n\u0010\u000b\"\u0004\u0008\u000c\u0010\rR\u0016\u0010\u000e\u001a\u0004\u0018\u00010\u000f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u0010\u0010\u0011¨\u0006\u0016", d2 = {"Lkotlinx/coroutines/JobNode;", "Lkotlinx/coroutines/CompletionHandlerBase;", "Lkotlinx/coroutines/DisposableHandle;", "Lkotlinx/coroutines/Incomplete;", "()V", "isActive", "", "()Z", "job", "Lkotlinx/coroutines/JobSupport;", "getJob", "()Lkotlinx/coroutines/JobSupport;", "setJob", "(Lkotlinx/coroutines/JobSupport;)V", "list", "Lkotlinx/coroutines/NodeList;", "getList", "()Lkotlinx/coroutines/NodeList;", "dispose", "", "toString", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
public abstract class JobNode extends kotlinx.coroutines.CompletionHandlerBase implements kotlinx.coroutines.DisposableHandle, kotlinx.coroutines.Incomplete {

    public kotlinx.coroutines.JobSupport job;
    @Override // kotlinx.coroutines.CompletionHandlerBase
    public void dispose() {
        getJob().removeNode$kotlinx_coroutines_core(this);
    }

    @Override // kotlinx.coroutines.CompletionHandlerBase
    public final kotlinx.coroutines.JobSupport getJob() {
        kotlinx.coroutines.JobSupport job = this.job;
        if (job != null) {
            return job;
        }
        Intrinsics.throwUninitializedPropertyAccessException("job");
        return null;
    }

    @Override // kotlinx.coroutines.CompletionHandlerBase
    public kotlinx.coroutines.NodeList getList() {
        return null;
    }

    @Override // kotlinx.coroutines.CompletionHandlerBase
    public boolean isActive() {
        return 1;
    }

    @Override // kotlinx.coroutines.CompletionHandlerBase
    public final void setJob(kotlinx.coroutines.JobSupport <set-?>) {
        this.job = <set-?>;
    }

    @Override // kotlinx.coroutines.CompletionHandlerBase
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append(DebugStringsKt.getClassSimpleName(this)).append('@').append(DebugStringsKt.getHexAddress(this)).append("[job@").append(DebugStringsKt.getHexAddress(getJob())).append(']').toString();
    }
}
