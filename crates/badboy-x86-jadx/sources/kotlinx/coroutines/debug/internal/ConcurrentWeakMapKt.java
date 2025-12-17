package kotlinx.coroutines.debug.internal;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.internal.Symbol;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000\"\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0001\n\u0000\n\u0002\u0010\u0000\n\u0000\u001a\u0008\u0010\u0008\u001a\u00020\tH\u0002\u001a\u000e\u0010\n\u001a\u00020\u0003*\u0004\u0018\u00010\u000bH\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000c", d2 = {"MAGIC", "", "MARKED_NULL", "Lkotlinx/coroutines/debug/internal/Marked;", "MARKED_TRUE", "MIN_CAPACITY", "REHASH", "Lkotlinx/coroutines/internal/Symbol;", "noImpl", "", "mark", "", "kotlinx-coroutines-core"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class ConcurrentWeakMapKt {

    private static final int MAGIC = -1640531527;
    private static final kotlinx.coroutines.debug.internal.Marked MARKED_NULL = null;
    private static final kotlinx.coroutines.debug.internal.Marked MARKED_TRUE = null;
    private static final int MIN_CAPACITY = 16;
    private static final Symbol REHASH;
    static {
        Symbol symbol = new Symbol("REHASH");
        ConcurrentWeakMapKt.REHASH = symbol;
        Marked marked = new Marked(0);
        ConcurrentWeakMapKt.MARKED_NULL = marked;
        Marked marked2 = new Marked(true);
        ConcurrentWeakMapKt.MARKED_TRUE = marked2;
    }

    public static final Symbol access$getREHASH$p() {
        return ConcurrentWeakMapKt.REHASH;
    }

    public static final kotlinx.coroutines.debug.internal.Marked access$mark(Object $receiver) {
        return ConcurrentWeakMapKt.mark($receiver);
    }

    public static final Void access$noImpl() {
        return ConcurrentWeakMapKt.noImpl();
    }

    private static final kotlinx.coroutines.debug.internal.Marked mark(Object $this$mark) {
        kotlinx.coroutines.debug.internal.Marked mARKED_NULL;
        if ($this$mark == null) {
            mARKED_NULL = ConcurrentWeakMapKt.MARKED_NULL;
        } else {
            if (Intrinsics.areEqual($this$mark, true)) {
                mARKED_NULL = ConcurrentWeakMapKt.MARKED_TRUE;
            } else {
                mARKED_NULL = new Marked($this$mark);
            }
        }
        return mARKED_NULL;
    }

    private static final Void noImpl() {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("not implemented");
        throw unsupportedOperationException;
    }
}
