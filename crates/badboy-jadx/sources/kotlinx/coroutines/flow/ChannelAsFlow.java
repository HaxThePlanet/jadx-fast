package kotlinx.coroutines.flow;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.Volatile;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.flow.internal.ChannelFlow;
import kotlinx.coroutines.flow.internal.SendingCollector;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000\\\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u0008\u0002\u0018\u0000*\u0004\u0008\u0000\u0010\u00012\u0008\u0012\u0004\u0012\u0002H\u00010\u0002B9\u0012\u000c\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u0008\u0012\u0008\u0008\u0002\u0010\t\u001a\u00020\n\u0012\u0008\u0008\u0002\u0010\u000b\u001a\u00020\u000c¢\u0006\u0002\u0010\rJ\u0008\u0010\u0010\u001a\u00020\u0011H\u0014J\u001f\u0010\u0012\u001a\u00020\u00132\u000c\u0010\u0014\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0015H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u0016J\u001f\u0010\u0017\u001a\u00020\u00132\u000c\u0010\u0018\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0019H\u0094@ø\u0001\u0000¢\u0006\u0002\u0010\u001aJ&\u0010\u001b\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\u0007\u001a\u00020\u00082\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u000cH\u0014J\u000e\u0010\u001c\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u001dH\u0016J\u0008\u0010\u001e\u001a\u00020\u0013H\u0002J\u0016\u0010\u001f\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u00042\u0006\u0010\u0018\u001a\u00020 H\u0016R\u0014\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\t\u0010\u000e\u001a\u00020\u000fX\u0082\u0004\u0082\u0002\u0004\n\u0002\u0008\u0019¨\u0006!", d2 = {"Lkotlinx/coroutines/flow/ChannelAsFlow;", "T", "Lkotlinx/coroutines/flow/internal/ChannelFlow;", "channel", "Lkotlinx/coroutines/channels/ReceiveChannel;", "consume", "", "context", "Lkotlin/coroutines/CoroutineContext;", "capacity", "", "onBufferOverflow", "Lkotlinx/coroutines/channels/BufferOverflow;", "(Lkotlinx/coroutines/channels/ReceiveChannel;ZLkotlin/coroutines/CoroutineContext;ILkotlinx/coroutines/channels/BufferOverflow;)V", "consumed", "Lkotlinx/atomicfu/AtomicBoolean;", "additionalToStringProps", "", "collect", "", "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "collectTo", "scope", "Lkotlinx/coroutines/channels/ProducerScope;", "(Lkotlinx/coroutines/channels/ProducerScope;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "create", "dropChannelOperators", "Lkotlinx/coroutines/flow/Flow;", "markConsumed", "produceImpl", "Lkotlinx/coroutines/CoroutineScope;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class ChannelAsFlow<T>  extends ChannelFlow<T> {

    private static final AtomicIntegerFieldUpdater consumed$FU;
    private final ReceiveChannel<T> channel;
    private final boolean consume;
    @Volatile
    private volatile int consumed;
    static {
        ChannelAsFlow.consumed$FU = AtomicIntegerFieldUpdater.newUpdater(ChannelAsFlow.class, "consumed");
    }

    public ChannelAsFlow(ReceiveChannel<? extends T> channel, boolean consume, CoroutineContext context, int capacity, BufferOverflow onBufferOverflow) {
        super(context, capacity, onBufferOverflow);
        this.channel = channel;
        this.consume = consume;
        this.consumed = 0;
    }

    public ChannelAsFlow(ReceiveChannel receiveChannel, boolean z2, CoroutineContext coroutineContext3, int i4, BufferOverflow bufferOverflow5, int i6, DefaultConstructorMarker defaultConstructorMarker7) {
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
        super(receiveChannel, z2, context, i, buf);
    }

    private final void markConsumed() {
        boolean andSet;
        int i;
        if (this.consume) {
            if (ChannelAsFlow.consumed$FU.getAndSet(this, 1) == 0) {
            } else {
                i = 0;
            }
            if (i == 0) {
            } else {
            }
            int i2 = 0;
            IllegalStateException $i$a$CheckChannelAsFlow$markConsumed$1 = new IllegalStateException("ReceiveChannel.consumeAsFlow can be collected just once".toString());
            throw $i$a$CheckChannelAsFlow$markConsumed$1;
        }
    }

    @Override // kotlinx.coroutines.flow.internal.ChannelFlow
    protected String additionalToStringProps() {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append("channel=").append(this.channel).toString();
    }

    public Object collect(kotlinx.coroutines.flow.FlowCollector<? super T> collector, Continuation<? super Unit> $completion) {
        Unit iNSTANCE;
        Object cOROUTINE_SUSPENDED;
        if (this.capacity == -3) {
            markConsumed();
            Object obj = FlowKt__ChannelsKt.access$emitAllImpl$FlowKt__ChannelsKt(collector, this.channel, this.consume, $completion);
            if (obj == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                return obj;
            }
            iNSTANCE = Unit.INSTANCE;
        } else {
            Object collect = super.collect(collector, $completion);
            if (collect == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                return collect;
            } else {
                iNSTANCE = Unit.INSTANCE;
            }
        }
        return iNSTANCE;
    }

    protected Object collectTo(ProducerScope<? super T> scope, Continuation<? super Unit> $completion) {
        SendingCollector sendingCollector = new SendingCollector((SendChannel)scope);
        Object obj = FlowKt__ChannelsKt.access$emitAllImpl$FlowKt__ChannelsKt((FlowCollector)sendingCollector, this.channel, this.consume, $completion);
        if (obj == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return obj;
        }
        return Unit.INSTANCE;
    }

    protected ChannelFlow<T> create(CoroutineContext context, int capacity, BufferOverflow onBufferOverflow) {
        ChannelAsFlow channelAsFlow = new ChannelAsFlow(this.channel, this.consume, context, capacity, onBufferOverflow);
        return (ChannelFlow)channelAsFlow;
    }

    public kotlinx.coroutines.flow.Flow<T> dropChannelOperators() {
        ChannelAsFlow channelAsFlow = new ChannelAsFlow(this.channel, this.consume, 0, 0, 0, 28, 0);
        return (Flow)channelAsFlow;
    }

    public ReceiveChannel<T> produceImpl(CoroutineScope scope) {
        ReceiveChannel produceImpl;
        markConsumed();
        if (this.capacity == -3) {
            produceImpl = this.channel;
        } else {
            produceImpl = super.produceImpl(scope);
        }
        return produceImpl;
    }
}
