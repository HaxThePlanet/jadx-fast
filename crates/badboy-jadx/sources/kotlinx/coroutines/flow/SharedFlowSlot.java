package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0010\u0011\n\u0002\u0008\u0002\u0008\u0000\u0018\u00002\u000c\u0012\u0008\u0012\u0006\u0012\u0002\u0008\u00030\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0014\u0010\t\u001a\u00020\n2\n\u0010\u000b\u001a\u0006\u0012\u0002\u0008\u00030\u0002H\u0016J'\u0010\u000c\u001a\u0010\u0012\u000c\u0012\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00050\r2\n\u0010\u000b\u001a\u0006\u0012\u0002\u0008\u00030\u0002H\u0016¢\u0006\u0002\u0010\u000eR\u001a\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u00020\u00088\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f", d2 = {"Lkotlinx/coroutines/flow/SharedFlowSlot;", "Lkotlinx/coroutines/flow/internal/AbstractSharedFlowSlot;", "Lkotlinx/coroutines/flow/SharedFlowImpl;", "()V", "cont", "Lkotlin/coroutines/Continuation;", "", "index", "", "allocateLocked", "", "flow", "freeLocked", "", "(Lkotlinx/coroutines/flow/SharedFlowImpl;)[Lkotlin/coroutines/Continuation;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class SharedFlowSlot extends AbstractSharedFlowSlot<kotlinx.coroutines.flow.SharedFlowImpl<?>> {

    public Continuation<? super Unit> cont;
    public long index = -1;
    public SharedFlowSlot() {
        super();
        final int i = -1;
    }

    @Override // kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot
    public boolean allocateLocked(Object flow) {
        return allocateLocked((SharedFlowImpl)flow);
    }

    public boolean allocateLocked(kotlinx.coroutines.flow.SharedFlowImpl<?> flow) {
        if (Long.compare(index, i3) >= 0) {
            return 0;
        }
        this.index = flow.updateNewCollectorIndexLocked$kotlinx_coroutines_core();
        return 1;
    }

    @Override // kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot
    public Continuation[] freeLocked(Object flow) {
        return freeLocked((SharedFlowImpl)flow);
    }

    public Continuation<Unit>[] freeLocked(kotlinx.coroutines.flow.SharedFlowImpl<?> flow) {
        boolean aSSERTIONS_ENABLED;
        int i2;
        int i;
        if (DebugKt.getASSERTIONS_ENABLED()) {
            aSSERTIONS_ENABLED = 0;
            i2 = Long.compare(index2, i) >= 0 ? 1 : 0;
            if (i2 == 0) {
            } else {
            }
            AssertionError assertionError = new AssertionError();
            throw assertionError;
        }
        this.index = -1;
        this.cont = 0;
        return flow.updateCollectorIndexLocked$kotlinx_coroutines_core(this.index);
    }
}
