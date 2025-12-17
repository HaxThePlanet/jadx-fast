package kotlinx.coroutines.flow.internal;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.internal.ThreadContextKt;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u00000\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u001a[\u0010\u0000\u001a\u0002H\u0001\"\u0004\u0008\u0000\u0010\u0001\"\u0004\u0008\u0001\u0010\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u0002H\u00022\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u00072\"\u0010\u0008\u001a\u001e\u0008\u0001\u0012\u0004\u0012\u0002H\u0002\u0012\n\u0012\u0008\u0012\u0004\u0012\u0002H\u00010\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\tH\u0080@ø\u0001\u0000¢\u0006\u0002\u0010\u000b\u001a\u001e\u0010\u000c\u001a\u0008\u0012\u0004\u0012\u0002H\u00010\r\"\u0004\u0008\u0000\u0010\u0001*\u0008\u0012\u0004\u0012\u0002H\u00010\u000eH\u0000\u001a&\u0010\u000f\u001a\u0008\u0012\u0004\u0012\u0002H\u00010\u0010\"\u0004\u0008\u0000\u0010\u0001*\u0008\u0012\u0004\u0012\u0002H\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u0004H\u0002\u0082\u0002\u0004\n\u0002\u0008\u0019¨\u0006\u0012", d2 = {"withContextUndispatched", "T", "V", "newContext", "Lkotlin/coroutines/CoroutineContext;", "value", "countOrElement", "", "block", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "(Lkotlin/coroutines/CoroutineContext;Ljava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "asChannelFlow", "Lkotlinx/coroutines/flow/internal/ChannelFlow;", "Lkotlinx/coroutines/flow/Flow;", "withUndispatchedContextCollector", "Lkotlinx/coroutines/flow/FlowCollector;", "emitContext", "kotlinx-coroutines-core"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class ChannelFlowKt {
    public static final FlowCollector access$withUndispatchedContextCollector(FlowCollector $receiver, CoroutineContext emitContext) {
        return ChannelFlowKt.withUndispatchedContextCollector($receiver, emitContext);
    }

    public static final <T> kotlinx.coroutines.flow.internal.ChannelFlow<T> asChannelFlow(Flow<? extends T> $this$asChannelFlow) {
        Object obj;
        kotlinx.coroutines.flow.internal.ChannelFlowOperatorImpl channelFlowOperatorImpl;
        Object $this$asChannelFlow2;
        int i;
        int i4;
        int i3;
        int i5;
        int i2;
        if ($this$asChannelFlow instanceof ChannelFlow) {
            obj = $this$asChannelFlow;
        } else {
            obj = 0;
        }
        if (obj == null) {
            channelFlowOperatorImpl = new ChannelFlowOperatorImpl($this$asChannelFlow, 0, 0, 0, 14, 0);
            obj = channelFlowOperatorImpl;
        } else {
            $this$asChannelFlow2 = $this$asChannelFlow;
        }
        return obj;
    }

    public static final <T, V> Object withContextUndispatched(CoroutineContext newContext, V value, Object countOrElement, Function2<? super V, ? super Continuation<? super T>, ? extends Object> block, Continuation<? super T> $completion) {
        final int i = 0;
        final int i2 = 0;
        final int i3 = 0;
        StackFrameContinuation stackFrameContinuation = new StackFrameContinuation($completion, newContext);
        Object invoke = (Function2)TypeIntrinsics.beforeCheckcastToFunctionOfArity(block, 2).invoke(value, (Continuation)stackFrameContinuation);
        ThreadContextKt.restoreThreadContext(newContext, ThreadContextKt.updateThreadContext(newContext, countOrElement));
        if (invoke == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended($completion);
        }
        return invoke;
    }

    public static Object withContextUndispatched$default(CoroutineContext coroutineContext, Object object2, Object object3, Function2 function24, Continuation continuation5, int i6, Object object7) {
        Object obj2;
        if (i6 &= 4 != 0) {
            obj2 = ThreadContextKt.threadContextElements(coroutineContext);
        }
        return ChannelFlowKt.withContextUndispatched(coroutineContext, object2, obj2, function24, continuation5);
    }

    private static final <T> FlowCollector<T> withUndispatchedContextCollector(FlowCollector<? super T> $this$withUndispatchedContextCollector, CoroutineContext emitContext) {
        int i;
        Object undispatchedContextCollector;
        i = $this$withUndispatchedContextCollector instanceof SendingCollector ? 1 : $this$withUndispatchedContextCollector instanceof NopCollector;
        if (i != 0) {
            undispatchedContextCollector = $this$withUndispatchedContextCollector;
        } else {
            undispatchedContextCollector = new UndispatchedContextCollector($this$withUndispatchedContextCollector, emitContext);
        }
        return undispatchedContextCollector;
    }
}
