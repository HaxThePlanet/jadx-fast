package kotlinx.coroutines.flow.internal;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.ProduceKt;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.sync.SemaphoreKt;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000F\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0008\u0000\u0018\u0000*\u0004\u0008\u0000\u0010\u00012\u0008\u0012\u0004\u0012\u0002H\u00010\u0002B?\u0012\u0012\u0010\u0003\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00028\u00000\u00040\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u0008\u0012\u0008\u0008\u0002\u0010\t\u001a\u00020\u0006\u0012\u0008\u0008\u0002\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\u000cJ\u0008\u0010\r\u001a\u00020\u000eH\u0014J\u001f\u0010\u000f\u001a\u00020\u00102\u000c\u0010\u0011\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0012H\u0094@ø\u0001\u0000¢\u0006\u0002\u0010\u0013J&\u0010\u0014\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\u0007\u001a\u00020\u00082\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bH\u0014J\u0016\u0010\u0015\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u00162\u0006\u0010\u0011\u001a\u00020\u0017H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0003\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00028\u00000\u00040\u0004X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\u0008\u0019¨\u0006\u0018", d2 = {"Lkotlinx/coroutines/flow/internal/ChannelFlowMerge;", "T", "Lkotlinx/coroutines/flow/internal/ChannelFlow;", "flow", "Lkotlinx/coroutines/flow/Flow;", "concurrency", "", "context", "Lkotlin/coroutines/CoroutineContext;", "capacity", "onBufferOverflow", "Lkotlinx/coroutines/channels/BufferOverflow;", "(Lkotlinx/coroutines/flow/Flow;ILkotlin/coroutines/CoroutineContext;ILkotlinx/coroutines/channels/BufferOverflow;)V", "additionalToStringProps", "", "collectTo", "", "scope", "Lkotlinx/coroutines/channels/ProducerScope;", "(Lkotlinx/coroutines/channels/ProducerScope;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "create", "produceImpl", "Lkotlinx/coroutines/channels/ReceiveChannel;", "Lkotlinx/coroutines/CoroutineScope;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ChannelFlowMerge<T>  extends kotlinx.coroutines.flow.internal.ChannelFlow<T> {

    private final int concurrency;
    private final Flow<Flow<T>> flow;
    public ChannelFlowMerge(Flow<? extends Flow<? extends T>> flow, int concurrency, CoroutineContext context, int capacity, BufferOverflow onBufferOverflow) {
        super(context, capacity, onBufferOverflow);
        this.flow = flow;
        this.concurrency = concurrency;
    }

    public ChannelFlowMerge(Flow flow, int i2, CoroutineContext coroutineContext3, int i4, BufferOverflow bufferOverflow5, int i6, DefaultConstructorMarker defaultConstructorMarker7) {
        EmptyCoroutineContext context;
        int i;
        BufferOverflow buf;
        EmptyCoroutineContext obj9;
        int obj10;
        BufferOverflow obj11;
        if (i6 & 4 != 0) {
            context = obj9;
        } else {
            context = coroutineContext3;
        }
        i = i6 & 8 != 0 ? obj10 : i4;
        buf = i6 & 16 != 0 ? obj11 : bufferOverflow5;
        super(flow, i2, context, i, buf);
    }

    @Override // kotlinx.coroutines.flow.internal.ChannelFlow
    protected String additionalToStringProps() {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append("concurrency=").append(this.concurrency).toString();
    }

    protected Object collectTo(ProducerScope<? super T> scope, Continuation<? super Unit> $completion) {
        SendingCollector sendingCollector = new SendingCollector((SendChannel)scope);
        ChannelFlowMerge.collectTo.2 anon = new ChannelFlowMerge.collectTo.2((Job)$completion.getContext().get((CoroutineContext.Key)Job.Key), SemaphoreKt.Semaphore$default(this.concurrency, 0, 2, 0), scope, sendingCollector);
        Object collect = this.flow.collect((FlowCollector)anon, $completion);
        if (collect == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return collect;
        }
        return Unit.INSTANCE;
    }

    protected kotlinx.coroutines.flow.internal.ChannelFlow<T> create(CoroutineContext context, int capacity, BufferOverflow onBufferOverflow) {
        ChannelFlowMerge channelFlowMerge = new ChannelFlowMerge(this.flow, this.concurrency, context, capacity, onBufferOverflow);
        return (ChannelFlow)channelFlowMerge;
    }

    public ReceiveChannel<T> produceImpl(CoroutineScope scope) {
        return ProduceKt.produce(scope, this.context, this.capacity, getCollectToFun$kotlinx_coroutines_core());
    }
}
