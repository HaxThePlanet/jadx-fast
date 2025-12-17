package kotlinx.coroutines.channels;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlinx.coroutines.internal.Symbol;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0000\u001a\u001c\u0010\u0002\u001a\u0008\u0012\u0004\u0012\u0002H\u00040\u0003\"\u0004\u0008\u0000\u0010\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0007", d2 = {"NO_ELEMENT", "Lkotlinx/coroutines/internal/Symbol;", "BroadcastChannel", "Lkotlinx/coroutines/channels/BroadcastChannel;", "E", "capacity", "", "kotlinx-coroutines-core"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class BroadcastChannelKt {

    private static final Symbol NO_ELEMENT;
    static {
        Symbol symbol = new Symbol("NO_ELEMENT");
        BroadcastChannelKt.NO_ELEMENT = symbol;
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "BroadcastChannel is deprecated in the favour of SharedFlow and StateFlow, and is no longer supported")
    public static final <E> kotlinx.coroutines.channels.BroadcastChannel<E> BroadcastChannel(int capacity) {
        Object broadcastChannelImpl;
        int cHANNEL_DEFAULT_CAPACITY$kotlinx_coroutines_core;
        switch (capacity) {
            case -2:
                broadcastChannelImpl = new BroadcastChannelImpl(Channel.Factory.getCHANNEL_DEFAULT_CAPACITY$kotlinx_coroutines_core());
                break;
            case -1:
                broadcastChannelImpl = new ConflatedBroadcastChannel();
                break;
            case 0:
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Unsupported 0 capacity for BroadcastChannel");
                throw illegalArgumentException;
            case 2147483647:
                IllegalArgumentException illegalArgumentException2 = new IllegalArgumentException("Unsupported UNLIMITED capacity for BroadcastChannel");
                throw illegalArgumentException2;
            default:
                broadcastChannelImpl = new BroadcastChannelImpl(capacity);
        }
        return broadcastChannelImpl;
    }

    public static final Symbol access$getNO_ELEMENT$p() {
        return BroadcastChannelKt.NO_ELEMENT;
    }
}
