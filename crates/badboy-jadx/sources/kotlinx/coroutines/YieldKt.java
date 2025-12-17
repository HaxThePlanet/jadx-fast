package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlinx.coroutines.internal.DispatchedContinuation;
import kotlinx.coroutines.internal.DispatchedContinuationKt;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0002\u001a\u0011\u0010\u0000\u001a\u00020\u0001H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0002\u0082\u0002\u0004\n\u0002\u0008\u0019¨\u0006\u0003", d2 = {"yield", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class YieldKt {
    public static final Object yield(Continuation<? super Unit> $completion) {
        Continuation intercepted;
        Object cont;
        boolean cOROUTINE_SUSPENDED;
        boolean dispatcherWasUnconfined;
        Unit iNSTANCE;
        Continuation continuation = $completion;
        final int i = 0;
        final CoroutineContext context = continuation.getContext();
        JobKt.ensureActive(context);
        if (intercepted instanceof DispatchedContinuation) {
        } else {
            intercepted = 0;
        }
        if (intercepted == null) {
            cont = Unit.INSTANCE;
        } else {
            if (intercepted.dispatcher.isDispatchNeeded(context)) {
                intercepted.dispatchYield$kotlinx_coroutines_core(context, Unit.INSTANCE);
                cont = cOROUTINE_SUSPENDED;
            } else {
                cOROUTINE_SUSPENDED = new YieldContext();
                intercepted.dispatchYield$kotlinx_coroutines_core(context.plus((CoroutineContext)cOROUTINE_SUSPENDED), Unit.INSTANCE);
                if (cOROUTINE_SUSPENDED.dispatcherWasUnconfined) {
                    if (DispatchedContinuationKt.yieldUndispatched(intercepted)) {
                        dispatcherWasUnconfined = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    } else {
                        dispatcherWasUnconfined = Unit.INSTANCE;
                    }
                    cont = dispatcherWasUnconfined;
                } else {
                }
            }
        }
        if (cont == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended($completion);
        }
        if (cont == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return cont;
        }
        return Unit.INSTANCE;
    }
}
