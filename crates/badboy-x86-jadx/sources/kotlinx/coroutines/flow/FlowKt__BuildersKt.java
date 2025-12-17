package kotlinx.coroutines.flow;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.ranges.IntRange;
import kotlin.ranges.LongRange;
import kotlin.sequences.Sequence;
import kotlinx.coroutines.channels.ProducerScope;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u0011\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0008\n\u0002\u0010\u0015\n\u0002\u0010\t\n\u0002\u0010\u0016\n\u0002\u0010\u001c\n\u0002\u0010(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u001aK\u0010\u0000\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\u0008\u0000\u0010\u00022/\u0008\u0001\u0010\u0003\u001a)\u0008\u0001\u0012\n\u0012\u0008\u0012\u0004\u0012\u0002H\u00020\u0005\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00080\u0004¢\u0006\u0002\u0008\tø\u0001\u0000¢\u0006\u0002\u0010\n\u001aK\u0010\u000b\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\u0008\u0000\u0010\u00022/\u0008\u0001\u0010\u0003\u001a)\u0008\u0001\u0012\n\u0012\u0008\u0012\u0004\u0012\u0002H\u00020\u0005\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00080\u0004¢\u0006\u0002\u0008\tø\u0001\u0000¢\u0006\u0002\u0010\n\u001a\u0012\u0010\u000c\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\u0008\u0000\u0010\u0002\u001aK\u0010\r\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\u0008\u0000\u0010\u00022/\u0008\u0001\u0010\u0003\u001a)\u0008\u0001\u0012\n\u0012\u0008\u0012\u0004\u0012\u0002H\u00020\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00080\u0004¢\u0006\u0002\u0008\tø\u0001\u0000¢\u0006\u0002\u0010\n\u001a\u001f\u0010\u000f\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\u0008\u0000\u0010\u00022\u0006\u0010\u0010\u001a\u0002H\u0002¢\u0006\u0002\u0010\u0011\u001a+\u0010\u000f\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\u0008\u0000\u0010\u00022\u0012\u0010\u0012\u001a\n\u0012\u0006\u0008\u0001\u0012\u0002H\u00020\u0013\"\u0002H\u0002¢\u0006\u0002\u0010\u0014\u001a\u001c\u0010\u0015\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\u0008\u0000\u0010\u0002*\u0008\u0012\u0004\u0012\u0002H\u00020\u0016\u001a!\u0010\u0015\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\u0008\u0000\u0010\u0002*\u0008\u0012\u0004\u0012\u0002H\u00020\u0013¢\u0006\u0002\u0010\u0014\u001a\u0010\u0010\u0015\u001a\u0008\u0012\u0004\u0012\u00020\u00170\u0001*\u00020\u0018\u001a\u0010\u0010\u0015\u001a\u0008\u0012\u0004\u0012\u00020\u00190\u0001*\u00020\u001a\u001a\u001c\u0010\u0015\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\u0008\u0000\u0010\u0002*\u0008\u0012\u0004\u0012\u0002H\u00020\u001b\u001a\u001c\u0010\u0015\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\u0008\u0000\u0010\u0002*\u0008\u0012\u0004\u0012\u0002H\u00020\u001c\u001a\u0010\u0010\u0015\u001a\u0008\u0012\u0004\u0012\u00020\u00170\u0001*\u00020\u001d\u001a\u0010\u0010\u0015\u001a\u0008\u0012\u0004\u0012\u00020\u00190\u0001*\u00020\u001e\u001a\u001c\u0010\u0015\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\u0008\u0000\u0010\u0002*\u0008\u0012\u0004\u0012\u0002H\u00020\u001f\u001a4\u0010\u0015\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\u0008\u0000\u0010\u0002*\u0018\u0008\u0001\u0012\n\u0012\u0008\u0012\u0004\u0012\u0002H\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00080 ø\u0001\u0000¢\u0006\u0002\u0010!\u0082\u0002\u0004\n\u0002\u0008\u0019¨\u0006\"", d2 = {"callbackFlow", "Lkotlinx/coroutines/flow/Flow;", "T", "block", "Lkotlin/Function2;", "Lkotlinx/coroutines/channels/ProducerScope;", "Lkotlin/coroutines/Continuation;", "", "", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/flow/Flow;", "channelFlow", "emptyFlow", "flow", "Lkotlinx/coroutines/flow/FlowCollector;", "flowOf", "value", "(Ljava/lang/Object;)Lkotlinx/coroutines/flow/Flow;", "elements", "", "([Ljava/lang/Object;)Lkotlinx/coroutines/flow/Flow;", "asFlow", "Lkotlin/Function0;", "", "", "", "", "", "", "Lkotlin/ranges/IntRange;", "Lkotlin/ranges/LongRange;", "Lkotlin/sequences/Sequence;", "Lkotlin/Function1;", "(Lkotlin/jvm/functions/Function1;)Lkotlinx/coroutines/flow/Flow;", "kotlinx-coroutines-core"}, k = 5, mv = {1, 8, 0}, xi = 48, xs = "kotlinx/coroutines/flow/FlowKt")
final class FlowKt__BuildersKt {
    public static final <T> kotlinx.coroutines.flow.Flow<T> asFlow(Iterable<? extends T> $this$asFlow) {
        final int i = 0;
        FlowKt__BuildersKt.asFlow$$inlined.unsafeFlow.3 anon = new FlowKt__BuildersKt.asFlow$$inlined.unsafeFlow.3($this$asFlow);
        return (Flow)anon;
    }

    public static final <T> kotlinx.coroutines.flow.Flow<T> asFlow(Iterator<? extends T> $this$asFlow) {
        final int i = 0;
        FlowKt__BuildersKt.asFlow$$inlined.unsafeFlow.4 anon = new FlowKt__BuildersKt.asFlow$$inlined.unsafeFlow.4($this$asFlow);
        return (Flow)anon;
    }

    public static final <T> kotlinx.coroutines.flow.Flow<T> asFlow(Function0<? extends T> $this$asFlow) {
        final int i = 0;
        FlowKt__BuildersKt.asFlow$$inlined.unsafeFlow.1 anon = new FlowKt__BuildersKt.asFlow$$inlined.unsafeFlow.1($this$asFlow);
        return (Flow)anon;
    }

    public static final <T> kotlinx.coroutines.flow.Flow<T> asFlow(Function1<? super Continuation<? super T>, ? extends Object> $this$asFlow) {
        final int i = 0;
        FlowKt__BuildersKt.asFlow$$inlined.unsafeFlow.2 anon = new FlowKt__BuildersKt.asFlow$$inlined.unsafeFlow.2($this$asFlow);
        return (Flow)anon;
    }

    public static final kotlinx.coroutines.flow.Flow<Integer> asFlow(IntRange $this$asFlow) {
        final int i = 0;
        FlowKt__BuildersKt.asFlow$$inlined.unsafeFlow.9 anon = new FlowKt__BuildersKt.asFlow$$inlined.unsafeFlow.9($this$asFlow);
        return (Flow)anon;
    }

    public static final kotlinx.coroutines.flow.Flow<Long> asFlow(LongRange $this$asFlow) {
        final int i = 0;
        FlowKt__BuildersKt.asFlow$$inlined.unsafeFlow.10 anon = new FlowKt__BuildersKt.asFlow$$inlined.unsafeFlow.10($this$asFlow);
        return (Flow)anon;
    }

    public static final <T> kotlinx.coroutines.flow.Flow<T> asFlow(Sequence<? extends T> $this$asFlow) {
        final int i = 0;
        FlowKt__BuildersKt.asFlow$$inlined.unsafeFlow.5 anon = new FlowKt__BuildersKt.asFlow$$inlined.unsafeFlow.5($this$asFlow);
        return (Flow)anon;
    }

    public static final kotlinx.coroutines.flow.Flow<Integer> asFlow(int[] $this$asFlow) {
        final int i = 0;
        FlowKt__BuildersKt.asFlow$$inlined.unsafeFlow.7 anon = new FlowKt__BuildersKt.asFlow$$inlined.unsafeFlow.7($this$asFlow);
        return (Flow)anon;
    }

    public static final kotlinx.coroutines.flow.Flow<Long> asFlow(long[] $this$asFlow) {
        final int i = 0;
        FlowKt__BuildersKt.asFlow$$inlined.unsafeFlow.8 anon = new FlowKt__BuildersKt.asFlow$$inlined.unsafeFlow.8($this$asFlow);
        return (Flow)anon;
    }

    public static final <T> kotlinx.coroutines.flow.Flow<T> asFlow(T[] $this$asFlow) {
        final int i = 0;
        FlowKt__BuildersKt.asFlow$$inlined.unsafeFlow.6 anon = new FlowKt__BuildersKt.asFlow$$inlined.unsafeFlow.6($this$asFlow);
        return (Flow)anon;
    }

    public static final <T> kotlinx.coroutines.flow.Flow<T> callbackFlow(Function2<? super ProducerScope<? super T>, ? super Continuation<? super Unit>, ? extends Object> block) {
        CallbackFlowBuilder callbackFlowBuilder = new CallbackFlowBuilder(block, 0, 0, 0, 14, 0);
        return (Flow)callbackFlowBuilder;
    }

    public static final <T> kotlinx.coroutines.flow.Flow<T> channelFlow(Function2<? super ProducerScope<? super T>, ? super Continuation<? super Unit>, ? extends Object> block) {
        ChannelFlowBuilder channelFlowBuilder = new ChannelFlowBuilder(block, 0, 0, 0, 14, 0);
        return (Flow)channelFlowBuilder;
    }

    public static final <T> kotlinx.coroutines.flow.Flow<T> emptyFlow() {
        return (Flow)EmptyFlow.INSTANCE;
    }

    public static final <T> kotlinx.coroutines.flow.Flow<T> flow(Function2<? super kotlinx.coroutines.flow.FlowCollector<? super T>, ? super Continuation<? super Unit>, ? extends Object> block) {
        SafeFlow safeFlow = new SafeFlow(block);
        return (Flow)safeFlow;
    }

    public static final <T> kotlinx.coroutines.flow.Flow<T> flowOf(T value) {
        final int i = 0;
        FlowKt__BuildersKt.flowOf$$inlined.unsafeFlow.2 anon = new FlowKt__BuildersKt.flowOf$$inlined.unsafeFlow.2(value);
        return (Flow)anon;
    }

    public static final <T> kotlinx.coroutines.flow.Flow<T> flowOf(T... elements) {
        final int i = 0;
        FlowKt__BuildersKt.flowOf$$inlined.unsafeFlow.1 anon = new FlowKt__BuildersKt.flowOf$$inlined.unsafeFlow.1(elements);
        return (Flow)anon;
    }
}
