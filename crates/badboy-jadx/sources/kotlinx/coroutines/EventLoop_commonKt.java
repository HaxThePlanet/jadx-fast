package kotlinx.coroutines;

import kotlin.Metadata;
import kotlinx.coroutines.internal.Symbol;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\t\n\u0002\u0008\u0003\n\u0002\u0010\u0008\n\u0002\u0008\u0008\n\u0002\u0018\u0002\n\u0000\u001a\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u000c\u001a\u00020\u0004H\u0000\u001a\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0004H\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\u0008X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\t\u001a\u00020\u0008X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\n\u001a\u00020\u0008X\u0082T¢\u0006\u0002\n\u0000*\u001e\u0008\u0002\u0010\u000f\u001a\u0004\u0008\u0000\u0010\u0010\"\u0008\u0012\u0004\u0012\u0002H\u00100\u00112\u0008\u0012\u0004\u0012\u0002H\u00100\u0011¨\u0006\u0012", d2 = {"CLOSED_EMPTY", "Lkotlinx/coroutines/internal/Symbol;", "DISPOSED_TASK", "MAX_DELAY_NS", "", "MAX_MS", "MS_TO_NS", "SCHEDULE_COMPLETED", "", "SCHEDULE_DISPOSED", "SCHEDULE_OK", "delayNanosToMillis", "timeNanos", "delayToNanos", "timeMillis", "Queue", "T", "Lkotlinx/coroutines/internal/LockFreeTaskQueueCore;", "kotlinx-coroutines-core"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class EventLoop_commonKt {

    private static final Symbol CLOSED_EMPTY = null;
    private static final Symbol DISPOSED_TASK = null;
    private static final long MAX_DELAY_NS = 4611686018427387903L;
    private static final long MAX_MS = 9223372036854L;
    private static final long MS_TO_NS = 1000000L;
    private static final int SCHEDULE_COMPLETED = 1;
    private static final int SCHEDULE_DISPOSED = 2;
    private static final int SCHEDULE_OK;
    static {
        Symbol symbol = new Symbol("REMOVED_TASK");
        EventLoop_commonKt.DISPOSED_TASK = symbol;
        Symbol symbol2 = new Symbol("CLOSED_EMPTY");
        EventLoop_commonKt.CLOSED_EMPTY = symbol2;
    }

    public static final Symbol access$getCLOSED_EMPTY$p() {
        return EventLoop_commonKt.CLOSED_EMPTY;
    }

    public static final Symbol access$getDISPOSED_TASK$p() {
        return EventLoop_commonKt.DISPOSED_TASK;
    }

    public static final long delayNanosToMillis(long timeNanos) {
        return timeNanos / i;
    }

    public static final long delayToNanos(long timeMillis) {
        int i;
        if (Long.compare(timeMillis, i) <= 0) {
        } else {
            i = Long.compare(timeMillis, l) >= 0 ? 9223372036854775807L : i2 * timeMillis;
        }
        return i;
    }
}
