package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.internal.DispatchedContinuation;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000(\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0000\u001a\"\u0010\u0000\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\u0008\u0000\u0010\u00022\u000c\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\u0004H\u0000\u001a3\u0010\u0005\u001a\u0002H\u0002\"\u0004\u0008\u0000\u0010\u00022\u001a\u0008\u0004\u0010\u0006\u001a\u0014\u0012\n\u0012\u0008\u0012\u0004\u0012\u0002H\u00020\u0008\u0012\u0004\u0012\u00020\t0\u0007H\u0086Hø\u0001\u0000¢\u0006\u0002\u0010\n\u001a3\u0010\u000b\u001a\u0002H\u0002\"\u0004\u0008\u0000\u0010\u00022\u001a\u0008\u0004\u0010\u0006\u001a\u0014\u0012\n\u0012\u0008\u0012\u0004\u0012\u0002H\u00020\u0001\u0012\u0004\u0012\u00020\t0\u0007H\u0080Hø\u0001\u0000¢\u0006\u0002\u0010\n\u001a\u0018\u0010\u000c\u001a\u00020\t*\u0006\u0012\u0002\u0008\u00030\u00082\u0006\u0010\r\u001a\u00020\u000eH\u0007\u0082\u0002\u0004\n\u0002\u0008\u0019¨\u0006\u000f", d2 = {"getOrCreateCancellableContinuation", "Lkotlinx/coroutines/CancellableContinuationImpl;", "T", "delegate", "Lkotlin/coroutines/Continuation;", "suspendCancellableCoroutine", "block", "Lkotlin/Function1;", "Lkotlinx/coroutines/CancellableContinuation;", "", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "suspendCancellableCoroutineReusable", "disposeOnCancellation", "handle", "Lkotlinx/coroutines/DisposableHandle;", "kotlinx-coroutines-core"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class CancellableContinuationKt {
    public static final void disposeOnCancellation(kotlinx.coroutines.CancellableContinuation<?> $this$disposeOnCancellation, kotlinx.coroutines.DisposableHandle handle) {
        DisposeOnCancel disposeOnCancel = new DisposeOnCancel(handle);
        final int i = 0;
        $this$disposeOnCancellation.invokeOnCancellation((Function1)(CancelHandlerBase)disposeOnCancel);
    }

    public static final <T> kotlinx.coroutines.CancellableContinuationImpl<T> getOrCreateCancellableContinuation(Continuation<? super T> delegate) {
        int claimReusableCancellableContinuation$kotlinx_coroutines_core;
        boolean it;
        int i;
        if (!delegate instanceof DispatchedContinuation) {
            CancellableContinuationImpl cancellableContinuationImpl2 = new CancellableContinuationImpl(delegate, 1);
            return cancellableContinuationImpl2;
        }
        claimReusableCancellableContinuation$kotlinx_coroutines_core = (DispatchedContinuation)delegate.claimReusableCancellableContinuation$kotlinx_coroutines_core();
        if (claimReusableCancellableContinuation$kotlinx_coroutines_core != null) {
            i = 0;
            if (claimReusableCancellableContinuation$kotlinx_coroutines_core.resetStateReusable()) {
            } else {
                claimReusableCancellableContinuation$kotlinx_coroutines_core = 0;
            }
            if (claimReusableCancellableContinuation$kotlinx_coroutines_core == 0) {
            }
            return claimReusableCancellableContinuation$kotlinx_coroutines_core;
        }
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(delegate, 2);
        return cancellableContinuationImpl;
    }

    public static final <T> Object suspendCancellableCoroutine(Function1<? super kotlinx.coroutines.CancellableContinuation<? super T>, Unit> block, Continuation<? super T> $completion) {
        final int i = 0;
        int i2 = 0;
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted($completion), 1);
        cancellableContinuationImpl.initCancellability();
        block.invoke(cancellableContinuationImpl);
        Object uCont = cancellableContinuationImpl.getResult();
        if (uCont == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended($completion);
        }
        return uCont;
    }

    private static final <T> Object suspendCancellableCoroutine$$forInline(Function1<? super kotlinx.coroutines.CancellableContinuation<? super T>, Unit> block, Continuation<? super T> $completion) {
        Object cOROUTINE_SUSPENDED;
        final int i = 0;
        final int i2 = 0;
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted((Continuation)$completion), 1);
        cancellableContinuationImpl.initCancellability();
        block.invoke(cancellableContinuationImpl);
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended((Continuation)$completion);
        }
        return result;
    }

    public static final <T> Object suspendCancellableCoroutineReusable(Function1<? super kotlinx.coroutines.CancellableContinuationImpl<? super T>, Unit> block, Continuation<? super T> $completion) {
        final int i = 0;
        int i2 = 0;
        kotlinx.coroutines.CancellableContinuationImpl orCreateCancellableContinuation = CancellableContinuationKt.getOrCreateCancellableContinuation(IntrinsicsKt.intercepted($completion));
        block.invoke(orCreateCancellableContinuation);
        Object uCont = orCreateCancellableContinuation.getResult();
        if (uCont == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended($completion);
        }
        return uCont;
    }

    private static final <T> Object suspendCancellableCoroutineReusable$$forInline(Function1<? super kotlinx.coroutines.CancellableContinuationImpl<? super T>, Unit> block, Continuation<? super T> $completion) {
        Object cOROUTINE_SUSPENDED;
        final int i = 0;
        final int i2 = 0;
        kotlinx.coroutines.CancellableContinuationImpl orCreateCancellableContinuation = CancellableContinuationKt.getOrCreateCancellableContinuation(IntrinsicsKt.intercepted((Continuation)$completion));
        block.invoke(orCreateCancellableContinuation);
        final Object result = orCreateCancellableContinuation.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended((Continuation)$completion);
        }
        return result;
    }
}
