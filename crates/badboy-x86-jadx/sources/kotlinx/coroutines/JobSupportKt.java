package kotlinx.coroutines;

import kotlin.Metadata;
import kotlinx.coroutines.internal.Symbol;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0005\n\u0002\u0010\u0000\n\u0002\u0008\u0002\u001a\u0010\u0010\r\u001a\u0004\u0018\u00010\u000e*\u0004\u0018\u00010\u000eH\u0000\u001a\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u000e*\u0004\u0018\u00010\u000eH\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0010\u0010\u0003\u001a\u00020\u00018\u0000X\u0081\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\u0008X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\t\u001a\u00020\u0008X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\n\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u000b\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u000c\u001a\u00020\u0008X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0010", d2 = {"COMPLETING_ALREADY", "Lkotlinx/coroutines/internal/Symbol;", "COMPLETING_RETRY", "COMPLETING_WAITING_CHILDREN", "EMPTY_ACTIVE", "Lkotlinx/coroutines/Empty;", "EMPTY_NEW", "FALSE", "", "RETRY", "SEALED", "TOO_LATE_TO_CANCEL", "TRUE", "boxIncomplete", "", "unboxState", "kotlinx-coroutines-core"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class JobSupportKt {

    private static final Symbol COMPLETING_ALREADY = null;
    private static final Symbol COMPLETING_RETRY = null;
    public static final Symbol COMPLETING_WAITING_CHILDREN = null;
    private static final kotlinx.coroutines.Empty EMPTY_ACTIVE = null;
    private static final kotlinx.coroutines.Empty EMPTY_NEW = null;
    private static final int FALSE = 0;
    private static final int RETRY = -1;
    private static final Symbol SEALED = null;
    private static final Symbol TOO_LATE_TO_CANCEL = null;
    private static final int TRUE = 1;
    static {
        Symbol symbol = new Symbol("COMPLETING_ALREADY");
        JobSupportKt.COMPLETING_ALREADY = symbol;
        Symbol symbol2 = new Symbol("COMPLETING_WAITING_CHILDREN");
        JobSupportKt.COMPLETING_WAITING_CHILDREN = symbol2;
        Symbol symbol3 = new Symbol("COMPLETING_RETRY");
        JobSupportKt.COMPLETING_RETRY = symbol3;
        Symbol symbol4 = new Symbol("TOO_LATE_TO_CANCEL");
        JobSupportKt.TOO_LATE_TO_CANCEL = symbol4;
        Symbol symbol5 = new Symbol("SEALED");
        JobSupportKt.SEALED = symbol5;
        Empty empty = new Empty(0);
        JobSupportKt.EMPTY_NEW = empty;
        Empty empty2 = new Empty(1);
        JobSupportKt.EMPTY_ACTIVE = empty2;
    }

    public static final Symbol access$getCOMPLETING_ALREADY$p() {
        return JobSupportKt.COMPLETING_ALREADY;
    }

    public static final Symbol access$getCOMPLETING_RETRY$p() {
        return JobSupportKt.COMPLETING_RETRY;
    }

    public static final kotlinx.coroutines.Empty access$getEMPTY_ACTIVE$p() {
        return JobSupportKt.EMPTY_ACTIVE;
    }

    public static final kotlinx.coroutines.Empty access$getEMPTY_NEW$p() {
        return JobSupportKt.EMPTY_NEW;
    }

    public static final Symbol access$getSEALED$p() {
        return JobSupportKt.SEALED;
    }

    public static final Symbol access$getTOO_LATE_TO_CANCEL$p() {
        return JobSupportKt.TOO_LATE_TO_CANCEL;
    }

    public static final Object boxIncomplete(Object $this$boxIncomplete) {
        Object incompleteStateBox;
        Object obj;
        if ($this$boxIncomplete instanceof Incomplete) {
            incompleteStateBox = new IncompleteStateBox((Incomplete)$this$boxIncomplete);
        } else {
            incompleteStateBox = $this$boxIncomplete;
        }
        return incompleteStateBox;
    }

    public static final Object unboxState(Object $this$unboxState) {
        Object state;
        if ($this$unboxState instanceof IncompleteStateBox) {
            state = $this$unboxState;
        } else {
            state = 0;
        }
        if (state != null) {
            if (state.state == null) {
                state = $this$unboxState;
            }
        } else {
        }
        return state;
    }
}
