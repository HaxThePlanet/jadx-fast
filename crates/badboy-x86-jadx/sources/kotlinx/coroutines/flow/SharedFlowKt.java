package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.internal.ChannelFlowOperatorImpl;
import kotlinx.coroutines.internal.Symbol;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000J\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\t\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0002\u0008\u0003\u001a0\u0010\u0002\u001a\u0008\u0012\u0004\u0012\u0002H\u00040\u0003\"\u0004\u0008\u0000\u0010\u00042\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u00062\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u00062\u0008\u0008\u0002\u0010\u0008\u001a\u00020\t\u001a6\u0010\n\u001a\u0008\u0012\u0004\u0012\u0002H\u00040\u000b\"\u0004\u0008\u0000\u0010\u0004*\u0008\u0012\u0004\u0012\u0002H\u00040\u000c2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0008\u001a\u00020\tH\u0000\u001a#\u0010\u0010\u001a\u0004\u0018\u00010\u0011*\n\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0002¢\u0006\u0002\u0010\u0015\u001a+\u0010\u0016\u001a\u00020\u0017*\n\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0008\u0010\u0018\u001a\u0004\u0018\u00010\u0011H\u0002¢\u0006\u0002\u0010\u0019\"\u0010\u0010\u0000\u001a\u00020\u00018\u0000X\u0081\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a", d2 = {"NO_VALUE", "Lkotlinx/coroutines/internal/Symbol;", "MutableSharedFlow", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "T", "replay", "", "extraBufferCapacity", "onBufferOverflow", "Lkotlinx/coroutines/channels/BufferOverflow;", "fuseSharedFlow", "Lkotlinx/coroutines/flow/Flow;", "Lkotlinx/coroutines/flow/SharedFlow;", "context", "Lkotlin/coroutines/CoroutineContext;", "capacity", "getBufferAt", "", "", "index", "", "([Ljava/lang/Object;J)Ljava/lang/Object;", "setBufferAt", "", "item", "([Ljava/lang/Object;JLjava/lang/Object;)V", "kotlinx-coroutines-core"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class SharedFlowKt {

    public static final Symbol NO_VALUE;
    static {
        Symbol symbol = new Symbol("NO_VALUE");
        SharedFlowKt.NO_VALUE = symbol;
    }

    public static final <T> kotlinx.coroutines.flow.MutableSharedFlow<T> MutableSharedFlow(int replay, int extraBufferCapacity, BufferOverflow onBufferOverflow) {
        int i;
        int i2;
        int i3;
        int sUSPEND;
        i = 1;
        int i7 = 0;
        i3 = replay >= 0 ? i : i7;
        if (i3 == 0) {
        } else {
            sUSPEND = extraBufferCapacity >= 0 ? i : i7;
            if (sUSPEND == 0) {
            } else {
                if (replay <= 0 && extraBufferCapacity <= 0) {
                    if (extraBufferCapacity <= 0) {
                        if (onBufferOverflow == BufferOverflow.SUSPEND) {
                        } else {
                            i = i7;
                        }
                    }
                }
                if (i == 0) {
                } else {
                    int i6 = replay + extraBufferCapacity;
                    i2 = i6 < 0 ? 0x7fffffff /* Unknown resource */ : i6;
                    SharedFlowImpl sharedFlowImpl = new SharedFlowImpl(replay, i2, onBufferOverflow);
                    return (MutableSharedFlow)sharedFlowImpl;
                }
                int bufferCapacity0 = 0;
                StringBuilder stringBuilder3 = new StringBuilder();
                IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException(stringBuilder3.append("replay or extraBufferCapacity must be positive with non-default onBufferOverflow strategy ").append(onBufferOverflow).toString().toString());
                throw illegalArgumentException3;
            }
            int i5 = 0;
            StringBuilder stringBuilder2 = new StringBuilder();
            IllegalArgumentException illegalArgumentException2 = new IllegalArgumentException(stringBuilder2.append("extraBufferCapacity cannot be negative, but was ").append(extraBufferCapacity).toString().toString());
            throw illegalArgumentException2;
        }
        int i4 = 0;
        StringBuilder stringBuilder = new StringBuilder();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.append("replay cannot be negative, but was ").append(replay).toString().toString());
        throw illegalArgumentException;
    }

    public static kotlinx.coroutines.flow.MutableSharedFlow MutableSharedFlow$default(int i, int i2, BufferOverflow bufferOverflow3, int i4, Object object5) {
        int obj1;
        int obj2;
        BufferOverflow obj3;
        final int i3 = 0;
        if (i4 & 1 != 0) {
            obj1 = i3;
        }
        if (i4 & 2 != 0) {
            obj2 = i3;
        }
        if (i4 &= 4 != 0) {
            obj3 = BufferOverflow.SUSPEND;
        }
        return SharedFlowKt.MutableSharedFlow(obj1, obj2, obj3);
    }

    public static final Object access$getBufferAt(Object[] $receiver, long index) {
        return SharedFlowKt.getBufferAt($receiver, index);
    }

    public static final void access$setBufferAt(Object[] $receiver, long index, Object item) {
        SharedFlowKt.setBufferAt($receiver, index, item);
    }

    public static final <T> kotlinx.coroutines.flow.Flow<T> fuseSharedFlow(kotlinx.coroutines.flow.SharedFlow<? extends T> $this$fuseSharedFlow, CoroutineContext context, int capacity, BufferOverflow onBufferOverflow) {
        int sUSPEND;
        if (capacity != 0) {
            if (capacity == -3 && onBufferOverflow == BufferOverflow.SUSPEND) {
                if (onBufferOverflow == BufferOverflow.SUSPEND) {
                    return (Flow)$this$fuseSharedFlow;
                }
            }
        } else {
        }
        ChannelFlowOperatorImpl channelFlowOperatorImpl = new ChannelFlowOperatorImpl((Flow)$this$fuseSharedFlow, context, capacity, onBufferOverflow);
        return (Flow)channelFlowOperatorImpl;
    }

    private static final Object getBufferAt(Object[] $this$getBufferAt, long index) {
        return $this$getBufferAt[i &= i3];
    }

    private static final void setBufferAt(Object[] $this$setBufferAt, long index, Object item) {
        $this$setBufferAt[i &= i3] = obj5;
    }
}
