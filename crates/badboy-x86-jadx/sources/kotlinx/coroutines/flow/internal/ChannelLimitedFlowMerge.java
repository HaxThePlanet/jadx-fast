package kotlinx.coroutines.flow.internal;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.ProduceKt;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.flow.Flow;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000B\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0008\u0000\u0018\u0000*\u0004\u0008\u0000\u0010\u00012\u0008\u0012\u0004\u0012\u0002H\u00010\u0002B7\u0012\u0012\u0010\u0003\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00028\u00000\u00050\u0004\u0012\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u0007\u0012\u0008\u0008\u0002\u0010\u0008\u001a\u00020\t\u0012\u0008\u0008\u0002\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\u000cJ\u001f\u0010\r\u001a\u00020\u000e2\u000c\u0010\u000f\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0010H\u0094@ø\u0001\u0000¢\u0006\u0002\u0010\u0011J&\u0010\u0012\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0008\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0014J\u0016\u0010\u0013\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u00142\u0006\u0010\u000f\u001a\u00020\u0015H\u0016R\u001a\u0010\u0003\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00028\u00000\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\u0008\u0019¨\u0006\u0016", d2 = {"Lkotlinx/coroutines/flow/internal/ChannelLimitedFlowMerge;", "T", "Lkotlinx/coroutines/flow/internal/ChannelFlow;", "flows", "", "Lkotlinx/coroutines/flow/Flow;", "context", "Lkotlin/coroutines/CoroutineContext;", "capacity", "", "onBufferOverflow", "Lkotlinx/coroutines/channels/BufferOverflow;", "(Ljava/lang/Iterable;Lkotlin/coroutines/CoroutineContext;ILkotlinx/coroutines/channels/BufferOverflow;)V", "collectTo", "", "scope", "Lkotlinx/coroutines/channels/ProducerScope;", "(Lkotlinx/coroutines/channels/ProducerScope;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "create", "produceImpl", "Lkotlinx/coroutines/channels/ReceiveChannel;", "Lkotlinx/coroutines/CoroutineScope;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ChannelLimitedFlowMerge<T>  extends kotlinx.coroutines.flow.internal.ChannelFlow<T> {

    private final Iterable<Flow<T>> flows;
    public ChannelLimitedFlowMerge(Iterable<? extends Flow<? extends T>> flows, CoroutineContext context, int capacity, BufferOverflow onBufferOverflow) {
        super(context, capacity, onBufferOverflow);
        this.flows = flows;
    }

    public ChannelLimitedFlowMerge(Iterable iterable, CoroutineContext coroutineContext2, int i3, BufferOverflow bufferOverflow4, int i5, DefaultConstructorMarker defaultConstructorMarker6) {
        EmptyCoroutineContext obj2;
        int obj3;
        BufferOverflow obj4;
        if (i5 & 2 != 0) {
            obj2 = EmptyCoroutineContext.INSTANCE;
        }
        obj3 = i5 & 4 != 0 ? -2 : obj3;
        obj4 = i5 &= 8 != 0 ? BufferOverflow.SUSPEND : obj4;
        super(iterable, obj2, obj3, obj4);
    }

    protected Object collectTo(ProducerScope<? super T> scope, Continuation<? super Unit> $completion) {
        Object next;
        Object obj;
        int i5;
        CoroutineScope coroutineScope;
        int i4;
        int i2;
        kotlinx.coroutines.flow.internal.ChannelLimitedFlowMerge.collectTo.2.1 anon;
        int i;
        int i3;
        SendingCollector sendingCollector = new SendingCollector((SendChannel)scope);
        final int i6 = 0;
        final Iterator iterator = this.flows.iterator();
        for (Object next : iterator) {
            i5 = 0;
            i2 = 0;
            ChannelLimitedFlowMerge.collectTo.2.1 anon2 = new ChannelLimitedFlowMerge.collectTo.2.1((Flow)next, sendingCollector, i2);
            BuildersKt.launch$default((CoroutineScope)scope, 0, i2, (Function2)anon2, 3, 0);
        }
        return Unit.INSTANCE;
    }

    protected kotlinx.coroutines.flow.internal.ChannelFlow<T> create(CoroutineContext context, int capacity, BufferOverflow onBufferOverflow) {
        ChannelLimitedFlowMerge channelLimitedFlowMerge = new ChannelLimitedFlowMerge(this.flows, context, capacity, onBufferOverflow);
        return (ChannelFlow)channelLimitedFlowMerge;
    }

    public ReceiveChannel<T> produceImpl(CoroutineScope scope) {
        return ProduceKt.produce(scope, this.context, this.capacity, getCollectToFun$kotlinx_coroutines_core());
    }
}
