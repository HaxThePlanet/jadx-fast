package kotlinx.coroutines.channels;

import kotlin.Metadata;

/* loaded from: classes3.dex */
@Metadata(d1 = "\u0000\u000c\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0008\u0005\u0008\u0086\u0001\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002j\u0002\u0008\u0003j\u0002\u0008\u0004j\u0002\u0008\u0005¨\u0006\u0006", d2 = {"Lkotlinx/coroutines/channels/BufferOverflow;", "", "(Ljava/lang/String;I)V", "SUSPEND", "DROP_OLDEST", "DROP_LATEST", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
public enum e {

    SUSPEND,
    DROP_OLDEST,
    DROP_LATEST;
    private static final kotlinx.coroutines.channels.e[] $values() {
        kotlinx.coroutines.channels.e[] arr = new e[3];
        return arr;
    }
}
