package kotlinx.coroutines.flow;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.internal.ChannelFlowOperatorImpl;
import kotlinx.coroutines.flow.internal.FusibleFlow.DefaultImpls;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000&\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u001a\u0015\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0002¢\u0006\u0002\u0008\u0004\u001a(\u0010\u0005\u001a\u0008\u0012\u0004\u0012\u0002H\u00070\u0006\"\u0004\u0008\u0000\u0010\u0007*\u0008\u0012\u0004\u0012\u0002H\u00070\u00062\u0008\u0008\u0002\u0010\u0008\u001a\u00020\tH\u0007\u001a0\u0010\u0005\u001a\u0008\u0012\u0004\u0012\u0002H\u00070\u0006\"\u0004\u0008\u0000\u0010\u0007*\u0008\u0012\u0004\u0012\u0002H\u00070\u00062\u0008\u0008\u0002\u0010\u0008\u001a\u00020\t2\u0008\u0008\u0002\u0010\n\u001a\u00020\u000b\u001a\u001c\u0010\u000c\u001a\u0008\u0012\u0004\u0012\u0002H\u00070\u0006\"\u0004\u0008\u0000\u0010\u0007*\u0008\u0012\u0004\u0012\u0002H\u00070\u0006\u001a\u001c\u0010\r\u001a\u0008\u0012\u0004\u0012\u0002H\u00070\u0006\"\u0004\u0008\u0000\u0010\u0007*\u0008\u0012\u0004\u0012\u0002H\u00070\u0006\u001a$\u0010\u000e\u001a\u0008\u0012\u0004\u0012\u0002H\u00070\u0006\"\u0004\u0008\u0000\u0010\u0007*\u0008\u0012\u0004\u0012\u0002H\u00070\u00062\u0006\u0010\u0002\u001a\u00020\u0003¨\u0006\u000f", d2 = {"checkFlowContext", "", "context", "Lkotlin/coroutines/CoroutineContext;", "checkFlowContext$FlowKt__ContextKt", "buffer", "Lkotlinx/coroutines/flow/Flow;", "T", "capacity", "", "onBufferOverflow", "Lkotlinx/coroutines/channels/BufferOverflow;", "cancellable", "conflate", "flowOn", "kotlinx-coroutines-core"}, k = 5, mv = {1, 8, 0}, xi = 48, xs = "kotlinx/coroutines/flow/FlowKt")
final class FlowKt__ContextKt {
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Since 1.4.0, binary compatibility with earlier versions")
    public static final kotlinx.coroutines.flow.Flow buffer(kotlinx.coroutines.flow.Flow $this$buffer, int capacity) {
        int i = 0;
        return FlowKt.buffer$default($this$buffer, capacity, i, 2, i);
    }

    public static final <T> kotlinx.coroutines.flow.Flow<T> buffer(kotlinx.coroutines.flow.Flow<? extends T> $this$buffer, int capacity, BufferOverflow onBufferOverflow) {
        int i3;
        int capacity2;
        kotlinx.coroutines.flow.Flow fuse$default;
        BufferOverflow onBufferOverflow2;
        Object channelFlowOperatorImpl;
        int sUSPEND;
        Object obj;
        int i2;
        int i4;
        BufferOverflow capacity3;
        int i5;
        int i;
        int i6;
        int i7 = 1;
        int i8 = -1;
        if (capacity < 0 && capacity != -2) {
            if (capacity != -2) {
                if (capacity == i8) {
                    sUSPEND = i7;
                } else {
                    sUSPEND = i3;
                }
            } else {
            }
        } else {
        }
        if (sUSPEND == 0) {
        } else {
            if (capacity == i8) {
                if (onBufferOverflow == BufferOverflow.SUSPEND) {
                    i3 = i7;
                }
            } else {
            }
            if (i3 == 0) {
            } else {
                capacity2 = capacity;
                if (capacity2 == i8) {
                    i4 = capacity2;
                    capacity3 = onBufferOverflow2;
                } else {
                    i4 = capacity2;
                    capacity3 = onBufferOverflow2;
                }
                if ($this$buffer instanceof FusibleFlow) {
                    fuse$default = FusibleFlow.DefaultImpls.fuse$default((FusibleFlow)$this$buffer, 0, i4, capacity3, 1, 0);
                    obj = $this$buffer;
                } else {
                    i5 = capacity3;
                    int onBufferOverflow3 = i4;
                    channelFlowOperatorImpl = new ChannelFlowOperatorImpl($this$buffer, 0, onBufferOverflow3, i5, 2, 0);
                    i4 = onBufferOverflow3;
                    capacity3 = i5;
                    fuse$default = channelFlowOperatorImpl;
                }
                return fuse$default;
            }
            Object $this$buffer2 = $this$buffer;
            int obj9 = 0;
            obj9 = new IllegalArgumentException("CONFLATED capacity cannot be used with non-default onBufferOverflow".toString());
            throw obj9;
        }
        Object $this$buffer3 = $this$buffer;
        obj9 = 0;
        StringBuilder stringBuilder = new StringBuilder();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.append("Buffer size should be non-negative, BUFFERED, or CONFLATED, but was ").append(capacity).toString().toString());
        throw illegalArgumentException;
    }

    public static kotlinx.coroutines.flow.Flow buffer$default(kotlinx.coroutines.flow.Flow flow, int i2, int i3, Object object4) {
        int obj1;
        if (i3 &= 1 != 0) {
            obj1 = -2;
        }
        return FlowKt.buffer(flow, obj1);
    }

    public static kotlinx.coroutines.flow.Flow buffer$default(kotlinx.coroutines.flow.Flow flow, int i2, BufferOverflow bufferOverflow3, int i4, Object object5) {
        int obj1;
        BufferOverflow obj2;
        if (i4 & 1 != 0) {
            obj1 = -2;
        }
        if (i4 &= 2 != 0) {
            obj2 = BufferOverflow.SUSPEND;
        }
        return FlowKt.buffer(flow, obj1, obj2);
    }

    public static final <T> kotlinx.coroutines.flow.Flow<T> cancellable(kotlinx.coroutines.flow.Flow<? extends T> $this$cancellable) {
        Object cancellableFlowImpl;
        if ($this$cancellable instanceof CancellableFlow) {
            cancellableFlowImpl = $this$cancellable;
        } else {
            cancellableFlowImpl = new CancellableFlowImpl($this$cancellable);
        }
        return cancellableFlowImpl;
    }

    private static final void checkFlowContext$FlowKt__ContextKt(CoroutineContext context) {
        int i;
        i = context.get((CoroutineContext.Key)Job.Key) == null ? 1 : 0;
        if (i == 0) {
        } else {
        }
        int i2 = 0;
        StringBuilder stringBuilder = new StringBuilder();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.append("Flow context cannot contain job in it. Had ").append(context).toString().toString());
        throw illegalArgumentException;
    }

    public static final <T> kotlinx.coroutines.flow.Flow<T> conflate(kotlinx.coroutines.flow.Flow<? extends T> $this$conflate) {
        int i = 0;
        return FlowKt.buffer$default($this$conflate, -1, i, 2, i);
    }

    public static final <T> kotlinx.coroutines.flow.Flow<T> flowOn(kotlinx.coroutines.flow.Flow<? extends T> $this$flowOn, CoroutineContext context) {
        boolean channelFlowOperatorImpl;
        Object obj;
        CoroutineContext context2;
        int i3;
        int i4;
        int i;
        int i2;
        Object obj8;
        FlowKt__ContextKt.checkFlowContext$FlowKt__ContextKt(context);
        if (Intrinsics.areEqual(context, EmptyCoroutineContext.INSTANCE)) {
            context2 = context;
            obj8 = obj;
        } else {
            if ($this$flowOn instanceof FusibleFlow) {
                obj8 = FusibleFlow.DefaultImpls.fuse$default((FusibleFlow)$this$flowOn, context, 0, 0, 6, 0);
                obj = $this$flowOn;
            } else {
                channelFlowOperatorImpl = new ChannelFlowOperatorImpl($this$flowOn, context, 0, 0, 12, 0);
                obj8 = channelFlowOperatorImpl;
            }
        }
        return obj8;
    }
}
