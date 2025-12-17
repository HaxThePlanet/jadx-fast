package kotlinx.coroutines.flow;

import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref.ObjectRef;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.internal.StackTraceRecoveryKt;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000V\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u001ah\u0010\u0000\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\u0008\u0000\u0010\u0002*\u0008\u0012\u0004\u0012\u0002H\u00020\u00012B\u0010\u0003\u001a>\u0008\u0001\u0012\n\u0012\u0008\u0012\u0004\u0012\u0002H\u00020\u0005\u0012\u0013\u0012\u00110\u0006¢\u0006\u000c\u0008\u0007\u0012\u0008\u0008\u0008\u0012\u0004\u0008\u0008(\t\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u000b0\n\u0012\u0006\u0012\u0004\u0018\u00010\u000c0\u0004¢\u0006\u0002\u0008\rø\u0001\u0000¢\u0006\u0002\u0010\u000e\u001a1\u0010\u000f\u001a\u0004\u0018\u00010\u0006\"\u0004\u0008\u0000\u0010\u0002*\u0008\u0012\u0004\u0012\u0002H\u00020\u00012\u000c\u0010\u0010\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\u0005H\u0080@ø\u0001\u0000¢\u0006\u0002\u0010\u0011\u001a\u0019\u0010\u0012\u001a\u00020\u0013*\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u0015H\u0002¢\u0006\u0002\u0008\u0016\u001a\u001b\u0010\u0017\u001a\u00020\u0013*\u00020\u00062\u0008\u0010\u0018\u001a\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0002\u0008\u0019\u001ac\u0010\u001a\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\u0008\u0000\u0010\u0002*\u0008\u0012\u0004\u0012\u0002H\u00020\u00012\u0008\u0008\u0002\u0010\u001b\u001a\u00020\u001c23\u0008\u0002\u0010\u001d\u001a-\u0008\u0001\u0012\u0013\u0012\u00110\u0006¢\u0006\u000c\u0008\u0007\u0012\u0008\u0008\u0008\u0012\u0004\u0008\u0008(\t\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00130\n\u0012\u0006\u0012\u0004\u0018\u00010\u000c0\u001eø\u0001\u0000¢\u0006\u0002\u0010\u001f\u001a}\u0010 \u001a\u0008\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\u0008\u0000\u0010\u0002*\u0008\u0012\u0004\u0012\u0002H\u00020\u00012W\u0010\u001d\u001aS\u0008\u0001\u0012\n\u0012\u0008\u0012\u0004\u0012\u0002H\u00020\u0005\u0012\u0013\u0012\u00110\u0006¢\u0006\u000c\u0008\u0007\u0012\u0008\u0008\u0008\u0012\u0004\u0008\u0008(\t\u0012\u0013\u0012\u00110\u001c¢\u0006\u000c\u0008\u0007\u0012\u0008\u0008\u0008\u0012\u0004\u0008\u0008(\"\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00130\n\u0012\u0006\u0012\u0004\u0018\u00010\u000c0!¢\u0006\u0002\u0008\rø\u0001\u0000¢\u0006\u0002\u0010#\u0082\u0002\u0004\n\u0002\u0008\u0019¨\u0006$", d2 = {"catch", "Lkotlinx/coroutines/flow/Flow;", "T", "action", "Lkotlin/Function3;", "Lkotlinx/coroutines/flow/FlowCollector;", "", "Lkotlin/ParameterName;", "name", "cause", "Lkotlin/coroutines/Continuation;", "", "", "Lkotlin/ExtensionFunctionType;", "(Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function3;)Lkotlinx/coroutines/flow/Flow;", "catchImpl", "collector", "(Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isCancellationCause", "", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "isCancellationCause$FlowKt__ErrorsKt", "isSameExceptionAs", "other", "isSameExceptionAs$FlowKt__ErrorsKt", "retry", "retries", "", "predicate", "Lkotlin/Function2;", "(Lkotlinx/coroutines/flow/Flow;JLkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/flow/Flow;", "retryWhen", "Lkotlin/Function4;", "attempt", "(Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function4;)Lkotlinx/coroutines/flow/Flow;", "kotlinx-coroutines-core"}, k = 5, mv = {1, 8, 0}, xi = 48, xs = "kotlinx/coroutines/flow/FlowKt")
final class FlowKt__ErrorsKt {
    public static final <T> kotlinx.coroutines.flow.Flow<T> catch(kotlinx.coroutines.flow.Flow<? extends T> $this$catch, Function3<? super kotlinx.coroutines.flow.FlowCollector<? super T>, ? super Throwable, ? super Continuation<? super Unit>, ? extends Object> action) {
        final int i = 0;
        FlowKt__ErrorsKt.catch$$inlined.unsafeFlow.1 anon = new FlowKt__ErrorsKt.catch$$inlined.unsafeFlow.1($this$catch, action);
        return (Flow)anon;
    }

    public static final <T> Object catchImpl(kotlinx.coroutines.flow.Flow<? extends T> flow, kotlinx.coroutines.flow.FlowCollector<? super T> flowCollector2, Continuation<? super Throwable> continuation3) {
        boolean anon;
        Object i2;
        int i3;
        int objectRef;
        Object collect;
        int i;
        Object obj5;
        Object obj7;
        anon = continuation3;
        i3 = Integer.MIN_VALUE;
        if (continuation3 instanceof FlowKt__ErrorsKt.catchImpl.1 && label &= i3 != 0) {
            anon = continuation3;
            i3 = Integer.MIN_VALUE;
            if (label &= i3 != 0) {
                anon.label = obj7 -= i3;
            } else {
                anon = new FlowKt__ErrorsKt.catchImpl.1(continuation3);
            }
        } else {
        }
        obj7 = anon.result;
        Object cOROUTINE_SUSPENDED = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (objectRef) {
            case 0:
                ResultKt.throwOnFailure(obj7);
                objectRef = new Ref.ObjectRef();
                FlowKt__ErrorsKt.catchImpl.2 anon2 = new FlowKt__ErrorsKt.catchImpl.2(flowCollector2, objectRef);
                anon.L$0 = objectRef;
                anon.label = 1;
                return cOROUTINE_SUSPENDED;
                obj5 = objectRef;
                break;
            case 1:
                obj5 = anon.L$0;
                ResultKt.throwOnFailure(obj7);
                break;
            default:
                obj5 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                throw obj5;
        }
        return null;
    }

    private static final boolean isCancellationCause$FlowKt__ErrorsKt(Throwable $this$isCancellationCause, CoroutineContext coroutineContext) {
        boolean cancelled;
        kotlin.coroutines.CoroutineContext.Element context = coroutineContext.get((CoroutineContext.Key)Job.Key);
        if (context != null && !(Job)context.isCancelled()) {
            if (!context.isCancelled()) {
            }
            return FlowKt__ErrorsKt.isSameExceptionAs$FlowKt__ErrorsKt($this$isCancellationCause, (Throwable)context.getCancellationException());
        }
        return 0;
    }

    private static final boolean isSameExceptionAs$FlowKt__ErrorsKt(Throwable $this$isSameExceptionAs, Throwable other) {
        int i;
        boolean equal;
        Throwable unwrapImpl;
        Throwable unwrapImpl2;
        if (other != null) {
            int i2 = 0;
            if (!DebugKt.getRECOVER_STACK_TRACES()) {
                unwrapImpl = other;
            } else {
                unwrapImpl = StackTraceRecoveryKt.unwrapImpl(other);
            }
            int $i$f$unwrap = 0;
            if (!DebugKt.getRECOVER_STACK_TRACES()) {
                unwrapImpl2 = $this$isSameExceptionAs;
            } else {
                unwrapImpl2 = StackTraceRecoveryKt.unwrapImpl($this$isSameExceptionAs);
            }
            i = Intrinsics.areEqual(unwrapImpl, unwrapImpl2) ? 1 : 0;
        } else {
        }
        return i;
    }

    public static final <T> kotlinx.coroutines.flow.Flow<T> retry(kotlinx.coroutines.flow.Flow<? extends T> $this$retry, long retries, Function2<? super Throwable, ? super Continuation<? super Boolean>, ? extends Object> predicate) {
        int i;
        i = Long.compare(retries, i2) > 0 ? 1 : 0;
        if (i == 0) {
        } else {
            FlowKt__ErrorsKt.retry.3 anon = new FlowKt__ErrorsKt.retry.3(retries, predicate, obj6, 0);
            return FlowKt.retryWhen($this$retry, (Function4)anon);
        }
        int i3 = 0;
        StringBuilder stringBuilder = new StringBuilder();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.append("Expected positive amount of retries, but had ").append(retries).toString().toString());
        throw illegalArgumentException;
    }

    public static kotlinx.coroutines.flow.Flow retry$default(kotlinx.coroutines.flow.Flow flow, long l2, Function2 function23, int i4, Object object5) {
        long obj1;
        kotlinx.coroutines.flow.FlowKt__ErrorsKt.retry.1 obj3;
        int obj4;
        if (object5 & 1 != 0) {
            obj1 = Long.MAX_VALUE;
        }
        if (object5 &= 2 != 0) {
            obj3 = new FlowKt__ErrorsKt.retry.1(0);
        }
        return FlowKt.retry(flow, obj1, function23);
    }

    public static final <T> kotlinx.coroutines.flow.Flow<T> retryWhen(kotlinx.coroutines.flow.Flow<? extends T> $this$retryWhen, Function4<? super kotlinx.coroutines.flow.FlowCollector<? super T>, ? super Throwable, ? super Long, ? super Continuation<? super Boolean>, ? extends Object> predicate) {
        final int i = 0;
        FlowKt__ErrorsKt.retryWhen$$inlined.unsafeFlow.1 anon = new FlowKt__ErrorsKt.retryWhen$$inlined.unsafeFlow.1($this$retryWhen, predicate);
        return (Flow)anon;
    }
}
