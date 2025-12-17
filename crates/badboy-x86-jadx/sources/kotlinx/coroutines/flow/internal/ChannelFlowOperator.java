package kotlinx.coroutines.flow.internal;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineContextKt;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000D\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0010\u000e\n\u0000\u0008 \u0018\u0000*\u0004\u0008\u0000\u0010\u0001*\u0004\u0008\u0001\u0010\u00022\u0008\u0012\u0004\u0012\u0002H\u00020\u0003B+\u0012\u000c\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\u0008\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\u000cJ\u001f\u0010\r\u001a\u00020\u000e2\u000c\u0010\u000f\u001a\u0008\u0012\u0004\u0012\u00028\u00010\u0010H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u0011J\u001f\u0010\u0012\u001a\u00020\u000e2\u000c\u0010\u0013\u001a\u0008\u0012\u0004\u0012\u00028\u00010\u0014H\u0094@ø\u0001\u0000¢\u0006\u0002\u0010\u0015J'\u0010\u0016\u001a\u00020\u000e2\u000c\u0010\u000f\u001a\u0008\u0012\u0004\u0012\u00028\u00010\u00102\u0006\u0010\u0017\u001a\u00020\u0007H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\u0018J\u001f\u0010\u0019\u001a\u00020\u000e2\u000c\u0010\u000f\u001a\u0008\u0012\u0004\u0012\u00028\u00010\u0010H¤@ø\u0001\u0000¢\u0006\u0002\u0010\u0011J\u0008\u0010\u001a\u001a\u00020\u001bH\u0016R\u0016\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u00058\u0004X\u0085\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\u0008\u0019¨\u0006\u001c", d2 = {"Lkotlinx/coroutines/flow/internal/ChannelFlowOperator;", "S", "T", "Lkotlinx/coroutines/flow/internal/ChannelFlow;", "flow", "Lkotlinx/coroutines/flow/Flow;", "context", "Lkotlin/coroutines/CoroutineContext;", "capacity", "", "onBufferOverflow", "Lkotlinx/coroutines/channels/BufferOverflow;", "(Lkotlinx/coroutines/flow/Flow;Lkotlin/coroutines/CoroutineContext;ILkotlinx/coroutines/channels/BufferOverflow;)V", "collect", "", "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "collectTo", "scope", "Lkotlinx/coroutines/channels/ProducerScope;", "(Lkotlinx/coroutines/channels/ProducerScope;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "collectWithContextUndispatched", "newContext", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/CoroutineContext;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "flowCollect", "toString", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
public abstract class ChannelFlowOperator<S, T>  extends kotlinx.coroutines.flow.internal.ChannelFlow<T> {

    protected final Flow<S> flow;
    public ChannelFlowOperator(Flow<? extends S> flow, CoroutineContext context, int capacity, BufferOverflow onBufferOverflow) {
        super(context, capacity, onBufferOverflow);
        this.flow = flow;
    }

    public static final Object access$collectWithContextUndispatched(kotlinx.coroutines.flow.internal.ChannelFlowOperator $this, FlowCollector collector, CoroutineContext newContext, Continuation $completion) {
        return $this.collectWithContextUndispatched(collector, newContext, $completion);
    }

    static <S, T> Object collect$suspendImpl(kotlinx.coroutines.flow.internal.ChannelFlowOperator<S, T> $this, FlowCollector<? super T> collector, Continuation<? super Unit> $completion) {
        int capacity;
        int coroutineContext;
        boolean equal;
        kotlin.coroutines.CoroutineContext.Element context;
        capacity = $completion.getContext();
        coroutineContext = CoroutineContextKt.newCoroutineContext(capacity, $this.context);
        Object flowCollect = $this.flowCollect(collector, $completion);
        if ($this.capacity == -3 && Intrinsics.areEqual(coroutineContext, capacity) && flowCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            capacity = $completion.getContext();
            coroutineContext = CoroutineContextKt.newCoroutineContext(capacity, $this.context);
            if (Intrinsics.areEqual(coroutineContext, capacity)) {
                flowCollect = $this.flowCollect(collector, $completion);
                if (flowCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                    return flowCollect;
                }
                return Unit.INSTANCE;
            }
            Object collectWithContextUndispatched = $this.collectWithContextUndispatched(collector, coroutineContext, $completion);
            if (Intrinsics.areEqual(coroutineContext.get((CoroutineContext.Key)ContinuationInterceptor.Key), capacity.get((CoroutineContext.Key)ContinuationInterceptor.Key)) && collectWithContextUndispatched == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                collectWithContextUndispatched = $this.collectWithContextUndispatched(collector, coroutineContext, $completion);
                if (collectWithContextUndispatched == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                    return collectWithContextUndispatched;
                }
                return Unit.INSTANCE;
            }
        }
        Object collect = super.collect(collector, $completion);
        if (collect == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return collect;
        }
        return Unit.INSTANCE;
    }

    static <S, T> Object collectTo$suspendImpl(kotlinx.coroutines.flow.internal.ChannelFlowOperator<S, T> $this, ProducerScope<? super T> scope, Continuation<? super Unit> $completion) {
        SendingCollector sendingCollector = new SendingCollector((SendChannel)scope);
        Object flowCollect = $this.flowCollect((FlowCollector)sendingCollector, $completion);
        if (flowCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return flowCollect;
        }
        return Unit.INSTANCE;
    }

    private final Object collectWithContextUndispatched(FlowCollector<? super T> collector, CoroutineContext newContext, Continuation<? super Unit> $completion) {
        ChannelFlowOperator.collectWithContextUndispatched.2 anon = new ChannelFlowOperator.collectWithContextUndispatched.2(this, 0);
        Object obj10 = ChannelFlowKt.withContextUndispatched$default(newContext, ChannelFlowKt.access$withUndispatchedContextCollector(collector, $completion.getContext()), 0, (Function2)anon, $completion, 4, 0);
        if (obj10 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return obj10;
        }
        return Unit.INSTANCE;
    }

    public Object collect(FlowCollector<? super T> flowCollector, Continuation<? super Unit> continuation2) {
        return ChannelFlowOperator.collect$suspendImpl(this, flowCollector, continuation2);
    }

    protected Object collectTo(ProducerScope<? super T> producerScope, Continuation<? super Unit> continuation2) {
        return ChannelFlowOperator.collectTo$suspendImpl(this, producerScope, continuation2);
    }

    protected abstract Object flowCollect(FlowCollector<? super T> flowCollector, Continuation<? super Unit> continuation2);

    @Override // kotlinx.coroutines.flow.internal.ChannelFlow
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append(this.flow).append(" -> ").append(super.toString()).toString();
    }
}
