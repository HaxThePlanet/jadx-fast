package androidx.compose.foundation.pager;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.math.MathKt;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000$\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\u001a\u0017\u0010\u0003\u001a\u00020\u00042\u000c\u0010\u0005\u001a\u0008\u0012\u0004\u0012\u00020\u00070\u0006H\u0082\u0008\u001a\u000c\u0010\u0008\u001a\u00020\t*\u00020\nH\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000¨\u0006\u000b", d2 = {"NearestItemsExtraItemCount", "", "NearestItemsSlidingWindowSize", "debugLog", "", "generateMsg", "Lkotlin/Function0;", "", "currentAbsoluteScrollOffset", "", "Landroidx/compose/foundation/pager/PagerState;", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class PagerScrollPositionKt {

    public static final int NearestItemsExtraItemCount = 100;
    public static final int NearestItemsSlidingWindowSize = 30;
    public static final long currentAbsoluteScrollOffset(androidx.compose.foundation.pager.PagerState $this$currentAbsoluteScrollOffset) {
        return i + roundToLong;
    }

    private static final void debugLog(Function0<String> generateMsg) {
        final int i = 0;
    }
}
