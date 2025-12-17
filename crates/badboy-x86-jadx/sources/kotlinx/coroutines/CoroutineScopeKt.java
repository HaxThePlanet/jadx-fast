package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.internal.ContextScope;
import kotlinx.coroutines.internal.ScopeCoroutine;
import kotlinx.coroutines.intrinsics.UndispatchedKt;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000F\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u001a\u000e\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0008\u001a\u0006\u0010\t\u001a\u00020\u0002\u001aM\u0010\n\u001a\u0002H\u000b\"\u0004\u0008\u0000\u0010\u000b2'\u0010\u000c\u001a#\u0008\u0001\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\u0008\u0012\u0004\u0012\u0002H\u000b0\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\r¢\u0006\u0002\u0008\u0010H\u0086@ø\u0001\u0000\u0082\u0002\n\n\u0008\u0008\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0002\u0010\u0011\u001a\u0011\u0010\u0012\u001a\u00020\u0008H\u0086Hø\u0001\u0000¢\u0006\u0002\u0010\u0013\u001a\u001e\u0010\u0014\u001a\u00020\u0015*\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u00172\n\u0008\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0019\u001a\u001c\u0010\u0014\u001a\u00020\u0015*\u00020\u00022\u0010\u0008\u0002\u0010\u0018\u001a\n\u0018\u00010\u001aj\u0004\u0018\u0001`\u001b\u001a\n\u0010\u001c\u001a\u00020\u0015*\u00020\u0002\u001a\u0015\u0010\u001d\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0008H\u0086\u0002\"\u001b\u0010\u0000\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u000c\u0012\u0004\u0008\u0003\u0010\u0004\u001a\u0004\u0008\u0000\u0010\u0005\u0082\u0002\u0004\n\u0002\u0008\u0019¨\u0006\u001e", d2 = {"isActive", "", "Lkotlinx/coroutines/CoroutineScope;", "isActive$annotations", "(Lkotlinx/coroutines/CoroutineScope;)V", "(Lkotlinx/coroutines/CoroutineScope;)Z", "CoroutineScope", "context", "Lkotlin/coroutines/CoroutineContext;", "MainScope", "coroutineScope", "R", "block", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "currentCoroutineContext", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "cancel", "", "message", "", "cause", "", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "ensureActive", "plus", "kotlinx-coroutines-core"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class CoroutineScopeKt {
    public static final kotlinx.coroutines.CoroutineScope CoroutineScope(CoroutineContext context) {
        CoroutineContext plus;
        int i;
        if (context.get((CoroutineContext.Key)Job.Key) != null) {
            plus = context;
        } else {
            i = 0;
            plus = context.plus((CoroutineContext)JobKt.Job$default(i, 1, i));
        }
        ContextScope contextScope = new ContextScope(plus);
        return (CoroutineScope)contextScope;
    }

    public static final kotlinx.coroutines.CoroutineScope MainScope() {
        int i = 0;
        ContextScope contextScope = new ContextScope(SupervisorKt.SupervisorJob$default(i, 1, i).plus((CoroutineContext)Dispatchers.getMain()));
        return (CoroutineScope)contextScope;
    }

    public static final void cancel(kotlinx.coroutines.CoroutineScope $this$cancel, String message, Throwable cause) {
        CoroutineScopeKt.cancel($this$cancel, ExceptionsKt.CancellationException(message, cause));
    }

    public static final void cancel(kotlinx.coroutines.CoroutineScope $this$cancel, CancellationException cause) {
        kotlin.coroutines.CoroutineContext.Element context = $this$cancel.getCoroutineContext().get((CoroutineContext.Key)Job.Key);
        if ((Job)context == null) {
        } else {
            (Job)context.cancel(cause);
        }
        StringBuilder stringBuilder = new StringBuilder();
        IllegalStateException job = new IllegalStateException(stringBuilder.append("Scope cannot be cancelled because it does not have a job: ").append($this$cancel).toString().toString());
        throw job;
    }

    public static void cancel$default(kotlinx.coroutines.CoroutineScope coroutineScope, String string2, Throwable throwable3, int i4, Object object5) {
        int obj2;
        if (i4 &= 2 != 0) {
            obj2 = 0;
        }
        CoroutineScopeKt.cancel(coroutineScope, string2, obj2);
    }

    public static void cancel$default(kotlinx.coroutines.CoroutineScope coroutineScope, CancellationException cancellationException2, int i3, Object object4) {
        int obj1;
        if (i3 &= 1 != 0) {
            obj1 = 0;
        }
        CoroutineScopeKt.cancel(coroutineScope, obj1);
    }

    public static final <R> Object coroutineScope(Function2<? super kotlinx.coroutines.CoroutineScope, ? super Continuation<? super R>, ? extends Object> block, Continuation<? super R> $completion) {
        Continuation continuation = $completion;
        int i = 0;
        ScopeCoroutine scopeCoroutine = new ScopeCoroutine(continuation.getContext(), continuation);
        Object uCont = UndispatchedKt.startUndispatchedOrReturn(scopeCoroutine, scopeCoroutine, block);
        if (uCont == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended($completion);
        }
        return uCont;
    }

    public static final Object currentCoroutineContext(Continuation<? super CoroutineContext> $completion) {
        final int i = 0;
        return $completion.getContext();
    }

    private static final Object currentCoroutineContext$$forInline(Continuation<? super CoroutineContext> $completion) {
        final int obj0 = 0;
        obj0.getContext();
        throw obj0;
    }

    public static final void ensureActive(kotlinx.coroutines.CoroutineScope $this$ensureActive) {
        JobKt.ensureActive($this$ensureActive.getCoroutineContext());
    }

    public static final boolean isActive(kotlinx.coroutines.CoroutineScope $this$isActive) {
        boolean active;
        kotlin.coroutines.CoroutineContext.Element context = $this$isActive.getCoroutineContext().get((CoroutineContext.Key)Job.Key);
        if ((Job)context != null) {
            active = (Job)context.isActive();
        } else {
            active = 1;
        }
        return active;
    }

    public static void isActive$annotations(kotlinx.coroutines.CoroutineScope coroutineScope) {
    }

    public static final kotlinx.coroutines.CoroutineScope plus(kotlinx.coroutines.CoroutineScope $this$plus, CoroutineContext context) {
        ContextScope contextScope = new ContextScope($this$plus.getCoroutineContext().plus(context));
        return (CoroutineScope)contextScope;
    }
}
