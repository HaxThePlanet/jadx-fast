package kotlinx.coroutines.flow.internal;

import kotlin.Metadata;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.SharedFlowImpl;
import kotlinx.coroutines.flow.StateFlow;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0008\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0010\u000b\n\u0002\u0008\u0002\u0008\u0002\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00020\u00012\u0008\u0012\u0004\u0012\u00020\u00020\u0003B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0002\u0010\u0005J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0002R\u0014\u0010\u0006\u001a\u00020\u00028VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u0007\u0010\u0008¨\u0006\u000c", d2 = {"Lkotlinx/coroutines/flow/internal/SubscriptionCountStateFlow;", "Lkotlinx/coroutines/flow/StateFlow;", "", "Lkotlinx/coroutines/flow/SharedFlowImpl;", "initialValue", "(I)V", "value", "getValue", "()Ljava/lang/Integer;", "increment", "", "delta", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class SubscriptionCountStateFlow extends SharedFlowImpl<Integer> implements StateFlow<Integer> {
    public SubscriptionCountStateFlow(int initialValue) {
        super(1, Integer.MAX_VALUE, BufferOverflow.DROP_OLDEST);
        tryEmit(Integer.valueOf(initialValue));
    }

    @Override // kotlinx.coroutines.flow.SharedFlowImpl
    public Integer getValue() {
        final int i = 0;
        final int i2 = 0;
        int i3 = 0;
        return Integer.valueOf((Number)getLastReplayedLocked().intValue());
        synchronized (this) {
            i = 0;
            i2 = 0;
            i3 = 0;
            return Integer.valueOf((Number)getLastReplayedLocked().intValue());
        }
    }

    @Override // kotlinx.coroutines.flow.SharedFlowImpl
    public Object getValue() {
        return getValue();
    }

    @Override // kotlinx.coroutines.flow.SharedFlowImpl
    public final boolean increment(int delta) {
        final int i = 0;
        final int i2 = 0;
        final int i3 = 0;
        return tryEmit(Integer.valueOf(intValue += delta));
        synchronized (this) {
            i = 0;
            i2 = 0;
            i3 = 0;
            return tryEmit(Integer.valueOf(intValue += delta));
        }
    }
}
