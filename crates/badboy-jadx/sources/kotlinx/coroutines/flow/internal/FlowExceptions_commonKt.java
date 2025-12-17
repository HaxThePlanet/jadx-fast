package kotlinx.coroutines.flow.internal;

import kotlin.Metadata;
import kotlinx.coroutines.flow.FlowCollector;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000\u001a\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0011\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0081\u0008\u001a\u0018\u0010\u0003\u001a\u00020\u0004*\u00020\u00052\n\u0010\u0006\u001a\u0006\u0012\u0002\u0008\u00030\u0007H\u0000¨\u0006\u0008", d2 = {"checkIndexOverflow", "", "index", "checkOwnership", "", "Lkotlinx/coroutines/flow/internal/AbortFlowException;", "owner", "Lkotlinx/coroutines/flow/FlowCollector;", "kotlinx-coroutines-core"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class FlowExceptions_commonKt {
    public static final int checkIndexOverflow(int index) {
        final int i = 0;
        if (index < 0) {
        } else {
            return index;
        }
        ArithmeticException arithmeticException = new ArithmeticException("Index overflow has happened");
        throw arithmeticException;
    }

    public static final void checkOwnership(kotlinx.coroutines.flow.internal.AbortFlowException $this$checkOwnership, FlowCollector<?> owner) {
        if ($this$checkOwnership.owner != owner) {
        } else {
        }
        throw $this$checkOwnership;
    }
}
