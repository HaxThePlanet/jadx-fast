package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.internal.StackTraceRecoveryKt;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u00008\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u001a4\u0010\u0000\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\u0008\u0000\u0010\u00022\u0008\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u000c\u0010\u0005\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\u0006H\u0000ø\u0001\u0000¢\u0006\u0002\u0010\u0007\u001aI\u0010\u0008\u001a\u0004\u0018\u00010\u0004\"\u0004\u0008\u0000\u0010\u0002*\u0008\u0012\u0004\u0012\u0002H\u00020\u00012%\u0008\u0002\u0010\t\u001a\u001f\u0012\u0013\u0012\u00110\u000b¢\u0006\u000c\u0008\u000c\u0012\u0008\u0008\r\u0012\u0004\u0008\u0008(\u000e\u0012\u0004\u0012\u00020\u000f\u0018\u00010\nH\u0000ø\u0001\u0000¢\u0006\u0002\u0010\u0010\u001a.\u0010\u0008\u001a\u0004\u0018\u00010\u0004\"\u0004\u0008\u0000\u0010\u0002*\u0008\u0012\u0004\u0012\u0002H\u00020\u00012\n\u0010\u0011\u001a\u0006\u0012\u0002\u0008\u00030\u0012H\u0000ø\u0001\u0000¢\u0006\u0002\u0010\u0013\u0082\u0002\u0004\n\u0002\u0008\u0019¨\u0006\u0014", d2 = {"recoverResult", "Lkotlin/Result;", "T", "state", "", "uCont", "Lkotlin/coroutines/Continuation;", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toState", "onCancellation", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "cause", "", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "caller", "Lkotlinx/coroutines/CancellableContinuation;", "(Ljava/lang/Object;Lkotlinx/coroutines/CancellableContinuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class CompletionStateKt {
    public static final <T> Object recoverResult(Object state, Continuation<? super T> uCont) {
        Object constructor-impl;
        Throwable exception$iv;
        int i;
        boolean rECOVER_STACK_TRACES;
        if (state instanceof CompletedExceptionally) {
            kotlin.Result.Companion companion2 = Result.Companion;
            i = 0;
            if (DebugKt.getRECOVER_STACK_TRACES()) {
                if (!uCont instanceof CoroutineStackFrame) {
                } else {
                    exception$iv = rECOVER_STACK_TRACES;
                }
            }
            constructor-impl = Result.constructor-impl(ResultKt.createFailure(exception$iv));
        } else {
            kotlin.Result.Companion companion = Result.Companion;
            constructor-impl = Result.constructor-impl(state);
        }
        return constructor-impl;
    }

    public static final <T> Object toState(Object $this$toState, Function1<? super Throwable, Unit> onCancellation) {
        Object it;
        int i;
        kotlinx.coroutines.CompletedWithCancellation completedWithCancellation;
        int i2;
        int i4;
        int i3;
        Throwable exceptionOrNull-impl = Result.exceptionOrNull-impl($this$toState);
        if (exceptionOrNull-impl == null) {
            i = 0;
            if (onCancellation != null) {
                completedWithCancellation = new CompletedWithCancellation($this$toState, onCancellation);
                it = completedWithCancellation;
            }
        } else {
            i = 0;
            completedWithCancellation = new CompletedExceptionally(exceptionOrNull-impl, 0, 2, 0);
            it = completedWithCancellation;
        }
        return it;
    }

    public static final <T> Object toState(Object $this$toState, kotlinx.coroutines.CancellableContinuation<?> caller) {
        Object it;
        int i3;
        kotlinx.coroutines.CompletedExceptionally completedExceptionally;
        int $i$f$recoverStackTrace;
        Throwable th;
        boolean rECOVER_STACK_TRACES;
        int i2;
        int i;
        Throwable exceptionOrNull-impl = Result.exceptionOrNull-impl($this$toState);
        if (exceptionOrNull-impl == null) {
            it = $this$toState;
            i3 = 0;
        } else {
            i3 = 0;
            int i4 = 0;
            if (DebugKt.getRECOVER_STACK_TRACES()) {
                if (!obj instanceof CoroutineStackFrame) {
                    th = exceptionOrNull-impl;
                } else {
                    th = StackTraceRecoveryKt.access$recoverFromStackFrame(exceptionOrNull-impl, (CoroutineStackFrame)(Continuation)caller);
                }
            } else {
            }
            completedExceptionally = new CompletedExceptionally(th, 0, 2, 0);
            it = completedExceptionally;
        }
        return it;
    }

    public static Object toState$default(Object object, Function1 function12, int i3, Object object4) {
        int obj1;
        if (i3 &= 1 != 0) {
            obj1 = 0;
        }
        return CompletionStateKt.toState(object, obj1);
    }
}
