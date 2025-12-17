package kotlinx.coroutines.intrinsics;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlinx.coroutines.CompletedExceptionally;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.JobSupportKt;
import kotlinx.coroutines.internal.ScopeCoroutine;
import kotlinx.coroutines.internal.StackTraceRecoveryKt;
import kotlinx.coroutines.internal.ThreadContextKt;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000@\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a9\u0010\u0000\u001a\u00020\u0001\"\u0004\u0008\u0000\u0010\u00022\u000c\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\u00042\u001a\u0010\u0005\u001a\u0016\u0012\n\u0012\u0008\u0012\u0004\u0012\u0002H\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006H\u0082\u0008\u001a>\u0010\u0008\u001a\u00020\u0001\"\u0004\u0008\u0000\u0010\u0002*\u0018\u0008\u0001\u0012\n\u0012\u0008\u0012\u0004\u0012\u0002H\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00062\u000c\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\u0004H\u0000ø\u0001\u0000¢\u0006\u0002\u0010\t\u001aR\u0010\u0008\u001a\u00020\u0001\"\u0004\u0008\u0000\u0010\n\"\u0004\u0008\u0001\u0010\u0002*\u001e\u0008\u0001\u0012\u0004\u0012\u0002H\n\u0012\n\u0012\u0008\u0012\u0004\u0012\u0002H\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u000b2\u0006\u0010\u000c\u001a\u0002H\n2\u000c\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\u0004H\u0000ø\u0001\u0000¢\u0006\u0002\u0010\r\u001a>\u0010\u000e\u001a\u00020\u0001\"\u0004\u0008\u0000\u0010\u0002*\u0018\u0008\u0001\u0012\n\u0012\u0008\u0012\u0004\u0012\u0002H\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00062\u000c\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\u0004H\u0000ø\u0001\u0000¢\u0006\u0002\u0010\t\u001aY\u0010\u000f\u001a\u0004\u0018\u00010\u0007\"\u0004\u0008\u0000\u0010\u0002\"\u0004\u0008\u0001\u0010\n*\u0008\u0012\u0004\u0012\u0002H\u00020\u00102\u0006\u0010\u000c\u001a\u0002H\n2'\u0010\u0005\u001a#\u0008\u0001\u0012\u0004\u0012\u0002H\n\u0012\n\u0012\u0008\u0012\u0004\u0012\u0002H\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u000b¢\u0006\u0002\u0008\u0011H\u0000ø\u0001\u0000¢\u0006\u0002\u0010\u0012\u001aY\u0010\u0013\u001a\u0004\u0018\u00010\u0007\"\u0004\u0008\u0000\u0010\u0002\"\u0004\u0008\u0001\u0010\n*\u0008\u0012\u0004\u0012\u0002H\u00020\u00102\u0006\u0010\u000c\u001a\u0002H\n2'\u0010\u0005\u001a#\u0008\u0001\u0012\u0004\u0012\u0002H\n\u0012\n\u0012\u0008\u0012\u0004\u0012\u0002H\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u000b¢\u0006\u0002\u0008\u0011H\u0000ø\u0001\u0000¢\u0006\u0002\u0010\u0012\u001a?\u0010\u0014\u001a\u0004\u0018\u00010\u0007\"\u0004\u0008\u0000\u0010\u0002*\u0008\u0012\u0004\u0012\u0002H\u00020\u00102\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00170\u00062\u000e\u0010\u0018\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0019H\u0082\u0008\u0082\u0002\u0004\n\u0002\u0008\u0019¨\u0006\u001a", d2 = {"startDirect", "", "T", "completion", "Lkotlin/coroutines/Continuation;", "block", "Lkotlin/Function1;", "", "startCoroutineUndispatched", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)V", "R", "Lkotlin/Function2;", "receiver", "(Lkotlin/jvm/functions/Function2;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)V", "startCoroutineUnintercepted", "startUndispatchedOrReturn", "Lkotlinx/coroutines/internal/ScopeCoroutine;", "Lkotlin/ExtensionFunctionType;", "(Lkotlinx/coroutines/internal/ScopeCoroutine;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "startUndispatchedOrReturnIgnoreTimeout", "undispatchedResult", "shouldThrow", "", "", "startBlock", "Lkotlin/Function0;", "kotlinx-coroutines-core"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class UndispatchedKt {
    public static final <T> void startCoroutineUndispatched(Function1<? super Continuation<? super T>, ? extends Object> $this$startCoroutineUndispatched, Continuation<? super T> completion) {
        Object cOROUTINE_SUSPENDED;
        int i;
        final int i2 = 0;
        int i3 = 0;
        Continuation $i$f$probeCoroutineCreated = DebugProbesKt.probeCoroutineCreated(completion);
        i = 0;
        final kotlin.coroutines.CoroutineContext context = completion.getContext();
        final int i5 = 0;
        final int i6 = 0;
        Object invoke = (Function1)TypeIntrinsics.beforeCheckcastToFunctionOfArity($this$startCoroutineUndispatched, 1).invoke($i$f$probeCoroutineCreated);
        ThreadContextKt.restoreThreadContext(context, ThreadContextKt.updateThreadContext(context, 0));
        if (invoke != IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            kotlin.Result.Companion companion = Result.Companion;
            $i$f$probeCoroutineCreated.resumeWith(Result.constructor-impl(invoke));
        }
    }

    public static final <R, T> void startCoroutineUndispatched(Function2<? super R, ? super Continuation<? super T>, ? extends Object> $this$startCoroutineUndispatched, R receiver, Continuation<? super T> completion) {
        Object cOROUTINE_SUSPENDED;
        int i;
        final int i2 = 0;
        int i3 = 0;
        Continuation $i$f$probeCoroutineCreated = DebugProbesKt.probeCoroutineCreated(completion);
        i = 0;
        final kotlin.coroutines.CoroutineContext context = completion.getContext();
        final int i5 = 0;
        final int i6 = 0;
        Object invoke = (Function2)TypeIntrinsics.beforeCheckcastToFunctionOfArity($this$startCoroutineUndispatched, 2).invoke(receiver, $i$f$probeCoroutineCreated);
        ThreadContextKt.restoreThreadContext(context, ThreadContextKt.updateThreadContext(context, 0));
        if (invoke != IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            kotlin.Result.Companion companion = Result.Companion;
            $i$f$probeCoroutineCreated.resumeWith(Result.constructor-impl(invoke));
        }
    }

    public static final <T> void startCoroutineUnintercepted(Function1<? super Continuation<? super T>, ? extends Object> $this$startCoroutineUnintercepted, Continuation<? super T> completion) {
        Object cOROUTINE_SUSPENDED;
        int i;
        final int i2 = 0;
        int i3 = 0;
        Continuation $i$f$probeCoroutineCreated = DebugProbesKt.probeCoroutineCreated(completion);
        i = 0;
        Object invoke = (Function1)TypeIntrinsics.beforeCheckcastToFunctionOfArity($this$startCoroutineUnintercepted, 1).invoke($i$f$probeCoroutineCreated);
        if (invoke != IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            kotlin.Result.Companion companion = Result.Companion;
            $i$f$probeCoroutineCreated.resumeWith(Result.constructor-impl(invoke));
        }
    }

    private static final <T> void startDirect(Continuation<? super T> completion, Function1<? super Continuation<? super T>, ? extends Object> block) {
        Object cOROUTINE_SUSPENDED;
        final int i = 0;
        int i2 = 0;
        Continuation $i$f$probeCoroutineCreated = DebugProbesKt.probeCoroutineCreated(completion);
        final Object invoke = block.invoke($i$f$probeCoroutineCreated);
        if (invoke != IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            kotlin.Result.Companion companion = Result.Companion;
            $i$f$probeCoroutineCreated.resumeWith(Result.constructor-impl(invoke));
        }
    }

    public static final <T, R> Object startUndispatchedOrReturn(ScopeCoroutine<? super T> $this$startUndispatchedOrReturn, R receiver, Function2<? super R, ? super Continuation<? super T>, ? extends Object> block) {
        int i2;
        Object state$iv;
        Object invoke;
        Object beforeCheckcastToFunctionOfArity;
        Throwable exception$iv$iv;
        Object obj;
        int i;
        boolean rECOVER_STACK_TRACES;
        final Object obj2 = $this$startUndispatchedOrReturn;
        final int i3 = 0;
        i2 = 0;
        invoke = (Function2)TypeIntrinsics.beforeCheckcastToFunctionOfArity(block, 2).invoke(receiver, (Continuation)$this$startUndispatchedOrReturn);
        if (invoke == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            state$iv = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        } else {
            Object completingOnce$kotlinx_coroutines_core = obj2.makeCompletingOnce$kotlinx_coroutines_core(invoke);
            if (completingOnce$kotlinx_coroutines_core == JobSupportKt.COMPLETING_WAITING_CHILDREN) {
                try {
                    state$iv = beforeCheckcastToFunctionOfArity;
                    if (completingOnce$kotlinx_coroutines_core instanceof CompletedExceptionally) {
                    }
                    Throwable cause = obj3.cause;
                    int i7 = 0;
                    Continuation uCont = obj2.uCont;
                    int i8 = 0;
                    if (!DebugKt.getRECOVER_STACK_TRACES()) {
                    } else {
                    }
                    if (!uCont instanceof CoroutineStackFrame) {
                    } else {
                    }
                    exception$iv$iv = rECOVER_STACK_TRACES;
                    throw exception$iv$iv;
                    state$iv = beforeCheckcastToFunctionOfArity;
                    return state$iv;
                }
            } else {
            }
        }
    }

    public static final <T, R> Object startUndispatchedOrReturnIgnoreTimeout(ScopeCoroutine<? super T> $this$startUndispatchedOrReturnIgnoreTimeout, R receiver, Function2<? super R, ? super Continuation<? super T>, ? extends Object> block) {
        int i;
        Object state$iv;
        int cOROUTINE_SUSPENDED;
        Throwable exception$iv$iv;
        Throwable exception$iv$iv2;
        Object invoke;
        Object beforeCheckcastToFunctionOfArity;
        Object obj;
        boolean coroutine;
        boolean rECOVER_STACK_TRACES2;
        boolean rECOVER_STACK_TRACES;
        final Object obj2 = $this$startUndispatchedOrReturnIgnoreTimeout;
        final int i2 = 0;
        i = 0;
        cOROUTINE_SUSPENDED = 0;
        invoke = (Function2)TypeIntrinsics.beforeCheckcastToFunctionOfArity(block, 2).invoke(receiver, (Continuation)$this$startUndispatchedOrReturnIgnoreTimeout);
        if (invoke == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            state$iv = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        } else {
            Object completingOnce$kotlinx_coroutines_core = obj2.makeCompletingOnce$kotlinx_coroutines_core(invoke);
            if (completingOnce$kotlinx_coroutines_core == JobSupportKt.COMPLETING_WAITING_CHILDREN) {
                state$iv = cOROUTINE_SUSPENDED;
            } else {
                try {
                    beforeCheckcastToFunctionOfArity = obj5.cause;
                    obj = 0;
                    if (beforeCheckcastToFunctionOfArity instanceof TimeoutCancellationException != null) {
                    } else {
                    }
                    if (th2.coroutine != $this$startUndispatchedOrReturnIgnoreTimeout) {
                    }
                    cOROUTINE_SUSPENDED = 1;
                    if (cOROUTINE_SUSPENDED != 0) {
                    }
                    Continuation uCont = obj2.uCont;
                    int i6 = 0;
                    if (!DebugKt.getRECOVER_STACK_TRACES()) {
                    } else {
                    }
                    if (!uCont instanceof CoroutineStackFrame) {
                    } else {
                    }
                    exception$iv$iv = rECOVER_STACK_TRACES2;
                    throw exception$iv$iv;
                    Continuation uCont2 = obj2.uCont;
                    int i7 = 0;
                }
                cOROUTINE_SUSPENDED = JobSupportKt.unboxState(completingOnce$kotlinx_coroutines_core);
                state$iv = cOROUTINE_SUSPENDED;
            }
        }
        return state$iv;
    }

    private static final <T> Object undispatchedResult(ScopeCoroutine<? super T> $this$undispatchedResult, Function1<? super Throwable, Boolean> shouldThrow, Function0<? extends Object> startBlock) {
        Object invoke;
        CompletedExceptionally completedExceptionally;
        int i3;
        Throwable exception$iv2;
        Throwable exception$iv;
        Object unboxState;
        int i;
        int i2;
        boolean rECOVER_STACK_TRACES;
        boolean rECOVER_STACK_TRACES2;
        final int i4 = 0;
        invoke = startBlock.invoke();
        try {
            if (invoke == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            }
            return IntrinsicsKt.getCOROUTINE_SUSPENDED();
            Object completingOnce$kotlinx_coroutines_core = $this$undispatchedResult.makeCompletingOnce$kotlinx_coroutines_core(invoke);
            if (completingOnce$kotlinx_coroutines_core == JobSupportKt.COMPLETING_WAITING_CHILDREN) {
            }
            return IntrinsicsKt.getCOROUTINE_SUSPENDED();
        }
        if (completingOnce$kotlinx_coroutines_core instanceof CompletedExceptionally) {
            if ((Boolean)shouldThrow.invoke(obj.cause).booleanValue()) {
                Continuation uCont2 = $this$undispatchedResult.uCont;
                int i6 = 0;
                if (!DebugKt.getRECOVER_STACK_TRACES()) {
                } else {
                    if (!uCont2 instanceof CoroutineStackFrame) {
                    } else {
                        exception$iv = rECOVER_STACK_TRACES2;
                    }
                }
                throw exception$iv;
            }
            if (invoke instanceof CompletedExceptionally) {
                Continuation uCont = $this$undispatchedResult.uCont;
                int i5 = 0;
                if (!DebugKt.getRECOVER_STACK_TRACES()) {
                } else {
                    if (!uCont instanceof CoroutineStackFrame) {
                    } else {
                        exception$iv2 = rECOVER_STACK_TRACES;
                    }
                }
                throw exception$iv2;
            }
            unboxState = invoke;
        } else {
            unboxState = JobSupportKt.unboxState(completingOnce$kotlinx_coroutines_core);
        }
        return unboxState;
    }
}
