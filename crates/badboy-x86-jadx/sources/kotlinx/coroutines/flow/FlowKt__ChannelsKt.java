package kotlinx.coroutines.flow;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.BroadcastChannel;
import kotlinx.coroutines.channels.ChannelIterator;
import kotlinx.coroutines.channels.ChannelsKt;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.flow.internal.ChannelFlow;
import kotlinx.coroutines.flow.internal.ChannelFlowKt;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u00000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u000b\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u001a\u001e\u0010\u0000\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\u0008\u0000\u0010\u0002*\u0008\u0012\u0004\u0012\u0002H\u00020\u0003H\u0007\u001a\u001c\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\u0008\u0000\u0010\u0002*\u0008\u0012\u0004\u0012\u0002H\u00020\u0005\u001a/\u0010\u0006\u001a\u00020\u0007\"\u0004\u0008\u0000\u0010\u0002*\u0008\u0012\u0004\u0012\u0002H\u00020\u00082\u000c\u0010\t\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\u0005H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\n\u001a9\u0010\u000b\u001a\u00020\u0007\"\u0004\u0008\u0000\u0010\u0002*\u0008\u0012\u0004\u0012\u0002H\u00020\u00082\u000c\u0010\t\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\u00052\u0006\u0010\u000c\u001a\u00020\rH\u0082@ø\u0001\u0000¢\u0006\u0004\u0008\u000e\u0010\u000f\u001a$\u0010\u0010\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\u0005\"\u0004\u0008\u0000\u0010\u0002*\u0008\u0012\u0004\u0012\u0002H\u00020\u00012\u0006\u0010\u0011\u001a\u00020\u0012\u001a\u001c\u0010\u0013\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\u0008\u0000\u0010\u0002*\u0008\u0012\u0004\u0012\u0002H\u00020\u0005\u0082\u0002\u0004\n\u0002\u0008\u0019¨\u0006\u0014", d2 = {"asFlow", "Lkotlinx/coroutines/flow/Flow;", "T", "Lkotlinx/coroutines/channels/BroadcastChannel;", "consumeAsFlow", "Lkotlinx/coroutines/channels/ReceiveChannel;", "emitAll", "", "Lkotlinx/coroutines/flow/FlowCollector;", "channel", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlinx/coroutines/channels/ReceiveChannel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "emitAllImpl", "consume", "", "emitAllImpl$FlowKt__ChannelsKt", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlinx/coroutines/channels/ReceiveChannel;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "produceIn", "scope", "Lkotlinx/coroutines/CoroutineScope;", "receiveAsFlow", "kotlinx-coroutines-core"}, k = 5, mv = {1, 8, 0}, xi = 48, xs = "kotlinx/coroutines/flow/FlowKt")
final class FlowKt__ChannelsKt {
    public static final Object access$emitAllImpl$FlowKt__ChannelsKt(kotlinx.coroutines.flow.FlowCollector $receiver, ReceiveChannel channel, boolean consume, Continuation $completion) {
        return FlowKt__ChannelsKt.emitAllImpl$FlowKt__ChannelsKt($receiver, channel, consume, $completion);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "'BroadcastChannel' is obsolete and all corresponding operators are deprecated in the favour of StateFlow and SharedFlow")
    public static final <T> kotlinx.coroutines.flow.Flow<T> asFlow(BroadcastChannel<T> $this$asFlow) {
        final int i = 0;
        FlowKt__ChannelsKt.asFlow$$inlined.unsafeFlow.1 anon = new FlowKt__ChannelsKt.asFlow$$inlined.unsafeFlow.1($this$asFlow);
        return (Flow)anon;
    }

    public static final <T> kotlinx.coroutines.flow.Flow<T> consumeAsFlow(ReceiveChannel<? extends T> $this$consumeAsFlow) {
        ChannelAsFlow channelAsFlow = new ChannelAsFlow($this$consumeAsFlow, 1, 0, 0, 0, 28, 0);
        return (Flow)channelAsFlow;
    }

    public static final <T> Object emitAll(kotlinx.coroutines.flow.FlowCollector<? super T> $this$emitAll, ReceiveChannel<? extends T> channel, Continuation<? super Unit> $completion) {
        Object emitAllImpl$FlowKt__ChannelsKt = FlowKt__ChannelsKt.emitAllImpl$FlowKt__ChannelsKt($this$emitAll, channel, true, $completion);
        if (emitAllImpl$FlowKt__ChannelsKt == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return emitAllImpl$FlowKt__ChannelsKt;
        }
        return Unit.INSTANCE;
    }

    private static final <T> Object emitAllImpl$FlowKt__ChannelsKt(kotlinx.coroutines.flow.FlowCollector<? super T> flowCollector, ReceiveChannel<? extends T> receiveChannel2, boolean z3, Continuation<? super Unit> continuation4) {
        boolean $result;
        Object $continuation3;
        int i;
        Object $continuation;
        kotlinx.coroutines.flow.FlowKt__ChannelsKt.emitAllImpl.1 anon;
        ReceiveChannel receiveChannel;
        Object l$1;
        Object channel;
        Object $this$emitAllImpl;
        Object $this$emitAllImpl2;
        Object obj;
        Object emit;
        Throwable th;
        Object obj7;
        int obj8;
        boolean obj9;
        Object obj10;
        $result = continuation4;
        receiveChannel = Integer.MIN_VALUE;
        if (continuation4 instanceof FlowKt__ChannelsKt.emitAllImpl.1 && label &= receiveChannel != 0) {
            $result = continuation4;
            receiveChannel = Integer.MIN_VALUE;
            if (label &= receiveChannel != 0) {
                $result.label = obj10 -= receiveChannel;
            } else {
                $result = new FlowKt__ChannelsKt.emitAllImpl.1(continuation4);
            }
        } else {
        }
        obj10 = $result.result;
        switch (label2) {
            case 0:
                ResultKt.throwOnFailure(obj10);
                FlowKt.ensureActive(flowCollector);
                obj8 = 0;
                $this$emitAllImpl = receiveChannel2.iterator();
                break;
            case 1:
                obj7 = $result.Z$0;
                obj8 = $result.L$2;
                obj9 = 0;
                ResultKt.throwOnFailure(obj10);
                obj = l$02;
                $this$emitAllImpl2 = l$12;
                channel = $continuation;
                anon = $result;
                $continuation3 = obj10;
                anon.L$0 = obj;
                anon.L$1 = $this$emitAllImpl2;
                anon.L$2 = obj8;
                anon.Z$0 = obj7;
                anon.label = 2;
                return channel;
                obj10 = $continuation3;
                $result = anon;
                $continuation = channel;
                l$1 = $this$emitAllImpl2;
                $this$emitAllImpl = obj8;
                obj8 = obj9;
                obj9 = obj7;
                obj7 = obj;
                ChannelsKt.cancelConsumed($this$emitAllImpl2, obj9);
                return Unit.INSTANCE;
            case 2:
                l$1 = $result.L$1;
                ResultKt.throwOnFailure(obj10);
                obj9 = obj7;
                obj7 = l$0;
                $this$emitAllImpl = obj8;
                obj8 = th;
                break;
            default:
                obj7 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                throw obj7;
        }
        $result.L$0 = obj7;
        $result.L$1 = l$1;
        $result.L$2 = $this$emitAllImpl;
        $result.Z$0 = obj9;
        $result.label = 1;
        Object next = $this$emitAllImpl.hasNext($result);
        if (next == $continuation) {
            return $continuation;
        } else {
            obj = obj7;
            obj7 = obj9;
            obj9 = obj8;
            obj8 = $this$emitAllImpl;
            $this$emitAllImpl2 = l$1;
            channel = $continuation;
            anon = $result;
            $continuation3 = obj10;
            obj10 = th;
        }
    }

    public static final <T> ReceiveChannel<T> produceIn(kotlinx.coroutines.flow.Flow<? extends T> $this$produceIn, CoroutineScope scope) {
        return ChannelFlowKt.asChannelFlow($this$produceIn).produceImpl(scope);
    }

    public static final <T> kotlinx.coroutines.flow.Flow<T> receiveAsFlow(ReceiveChannel<? extends T> $this$receiveAsFlow) {
        ChannelAsFlow channelAsFlow = new ChannelAsFlow($this$receiveAsFlow, 0, 0, 0, 0, 28, 0);
        return (Flow)channelAsFlow;
    }
}
