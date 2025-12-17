package kotlinx.coroutines.selects;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CoroutineDispatcher;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000&\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u0003\n\u0000\u001a8\u0010\u0000\u001a\u0002H\u0001\"\u0004\u0008\u0000\u0010\u00012\u001f\u0008\u0004\u0010\u0002\u001a\u0019\u0012\n\u0012\u0008\u0012\u0004\u0012\u0002H\u00010\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\u0008\u0006H\u0081Hø\u0001\u0000¢\u0006\u0002\u0010\u0007\u001a8\u0010\u0008\u001a\u0002H\u0001\"\u0004\u0008\u0000\u0010\u00012\u001f\u0008\u0004\u0010\u0002\u001a\u0019\u0012\n\u0012\u0008\u0012\u0004\u0012\u0002H\u00010\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\u0008\u0006H\u0081Hø\u0001\u0000¢\u0006\u0002\u0010\u0007\u001a%\u0010\t\u001a\u00020\u0005\"\u0004\u0008\u0000\u0010\n*\u0008\u0012\u0004\u0012\u0002H\n0\u000b2\u0006\u0010\u000c\u001a\u0002H\nH\u0002¢\u0006\u0002\u0010\r\u001a\u0018\u0010\u000e\u001a\u00020\u0005*\u0006\u0012\u0002\u0008\u00030\u000b2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002\u0082\u0002\u0004\n\u0002\u0008\u0019¨\u0006\u0011", d2 = {"selectOld", "R", "builder", "Lkotlin/Function1;", "Lkotlinx/coroutines/selects/SelectBuilder;", "", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "selectUnbiasedOld", "resumeUndispatched", "T", "Lkotlinx/coroutines/CancellableContinuation;", "result", "(Lkotlinx/coroutines/CancellableContinuation;Ljava/lang/Object;)V", "resumeUndispatchedWithException", "exception", "", "kotlinx-coroutines-core"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class SelectOldKt {
    public static final void access$resumeUndispatched(CancellableContinuation $receiver, Object result) {
        SelectOldKt.resumeUndispatched($receiver, result);
    }

    public static final void access$resumeUndispatchedWithException(CancellableContinuation $receiver, Throwable exception) {
        SelectOldKt.resumeUndispatchedWithException($receiver, exception);
    }

    private static final <T> void resumeUndispatched(CancellableContinuation<? super T> $this$resumeUndispatched, T result) {
        kotlinx.coroutines.CoroutineDispatcher.Key key;
        Object constructor-impl;
        kotlin.coroutines.CoroutineContext.Element context2 = $this$resumeUndispatched.getContext().get((CoroutineContext.Key)CoroutineDispatcher.Key);
        if ((CoroutineDispatcher)context2 != null) {
            $this$resumeUndispatched.resumeUndispatched((CoroutineDispatcher)context2, result);
        } else {
            kotlin.Result.Companion companion = Result.Companion;
            (Continuation)$this$resumeUndispatched.resumeWith(Result.constructor-impl(result));
        }
    }

    private static final void resumeUndispatchedWithException(CancellableContinuation<?> $this$resumeUndispatchedWithException, Throwable exception) {
        kotlinx.coroutines.CoroutineDispatcher.Key key;
        Object constructor-impl;
        kotlin.coroutines.CoroutineContext.Element context2 = $this$resumeUndispatchedWithException.getContext().get((CoroutineContext.Key)CoroutineDispatcher.Key);
        if ((CoroutineDispatcher)context2 != null) {
            $this$resumeUndispatchedWithException.resumeUndispatchedWithException((CoroutineDispatcher)context2, exception);
        } else {
            kotlin.Result.Companion companion = Result.Companion;
            (Continuation)$this$resumeUndispatchedWithException.resumeWith(Result.constructor-impl(ResultKt.createFailure(exception)));
        }
    }

    public static final <R> Object selectOld(Function1<? super kotlinx.coroutines.selects.SelectBuilder<? super R>, Unit> builder, Continuation<? super R> $completion) {
        Throwable th;
        final int i = 0;
        int i2 = 0;
        SelectBuilderImpl selectBuilderImpl = new SelectBuilderImpl($completion);
        builder.invoke(selectBuilderImpl);
        Object uCont = selectBuilderImpl.getResult();
        if (uCont == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended($completion);
        }
        return uCont;
    }

    private static final <R> Object selectOld$$forInline(Function1<? super kotlinx.coroutines.selects.SelectBuilder<? super R>, Unit> builder, Continuation<? super R> $completion) {
        Object cOROUTINE_SUSPENDED;
        Throwable th;
        final int i = 0;
        final int i2 = 0;
        SelectBuilderImpl selectBuilderImpl = new SelectBuilderImpl((Continuation)$completion);
        builder.invoke(selectBuilderImpl);
        Object result = selectBuilderImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended((Continuation)$completion);
        }
        return result;
    }

    public static final <R> Object selectUnbiasedOld(Function1<? super kotlinx.coroutines.selects.SelectBuilder<? super R>, Unit> builder, Continuation<? super R> $completion) {
        Throwable th;
        final int i = 0;
        int i2 = 0;
        UnbiasedSelectBuilderImpl unbiasedSelectBuilderImpl = new UnbiasedSelectBuilderImpl($completion);
        builder.invoke(unbiasedSelectBuilderImpl);
        Object uCont = unbiasedSelectBuilderImpl.initSelectResult();
        if (uCont == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended($completion);
        }
        return uCont;
    }

    private static final <R> Object selectUnbiasedOld$$forInline(Function1<? super kotlinx.coroutines.selects.SelectBuilder<? super R>, Unit> builder, Continuation<? super R> $completion) {
        Object cOROUTINE_SUSPENDED;
        Throwable th;
        final int i = 0;
        final int i2 = 0;
        UnbiasedSelectBuilderImpl unbiasedSelectBuilderImpl = new UnbiasedSelectBuilderImpl((Continuation)$completion);
        builder.invoke(unbiasedSelectBuilderImpl);
        Object selectResult = unbiasedSelectBuilderImpl.initSelectResult();
        if (selectResult == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended((Continuation)$completion);
        }
        return selectResult;
    }
}
