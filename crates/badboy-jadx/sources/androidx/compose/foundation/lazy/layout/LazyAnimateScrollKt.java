package androidx.compose.foundation.lazy.layout;

import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00008\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u001a\u0017\u0010\u0007\u001a\u00020\u00082\u000c\u0010\t\u001a\u0008\u0012\u0004\u0012\u00020\u000b0\nH\u0082\u0008\u001a2\u0010\u000c\u001a\u00020\u0008*\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0013H\u0080@¢\u0006\u0002\u0010\u0014\u001a\u0014\u0010\u0015\u001a\u00020\u0004*\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0000\"\u0010\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000\"\u0010\u0010\u0005\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\u0006\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002¨\u0006\u0016", d2 = {"BoundDistance", "Landroidx/compose/ui/unit/Dp;", "F", "DEBUG", "", "MinimumDistance", "TargetDistance", "debugLog", "", "generateMsg", "Lkotlin/Function0;", "", "animateScrollToItem", "Landroidx/compose/foundation/lazy/layout/LazyLayoutAnimateScrollScope;", "index", "", "scrollOffset", "numOfItemsForTeleport", "density", "Landroidx/compose/ui/unit/Density;", "(Landroidx/compose/foundation/lazy/layout/LazyLayoutAnimateScrollScope;IIILandroidx/compose/ui/unit/Density;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isItemVisible", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class LazyAnimateScrollKt {

    private static final float BoundDistance = 0f;
    private static final boolean DEBUG = false;
    private static final float MinimumDistance;
    private static final float TargetDistance;
    static {
        int i4 = 0;
        LazyAnimateScrollKt.TargetDistance = Dp.constructor-impl((float)i);
        int i5 = 0;
        LazyAnimateScrollKt.BoundDistance = Dp.constructor-impl((float)i2);
        int i6 = 0;
        LazyAnimateScrollKt.MinimumDistance = Dp.constructor-impl((float)i3);
    }

    public static final float access$getBoundDistance$p() {
        return LazyAnimateScrollKt.BoundDistance;
    }

    public static final float access$getMinimumDistance$p() {
        return LazyAnimateScrollKt.MinimumDistance;
    }

    public static final float access$getTargetDistance$p() {
        return LazyAnimateScrollKt.TargetDistance;
    }

    public static final Object animateScrollToItem(androidx.compose.foundation.lazy.layout.LazyLayoutAnimateScrollScope $this$animateScrollToItem, int index, int scrollOffset, int numOfItemsForTeleport, Density density, Continuation<? super Unit> $completion) {
        final androidx.compose.foundation.lazy.layout.LazyLayoutAnimateScrollScope lazyLayoutAnimateScrollScope = $this$animateScrollToItem;
        LazyAnimateScrollKt.animateScrollToItem.2 anon = new LazyAnimateScrollKt.animateScrollToItem.2(index, density, lazyLayoutAnimateScrollScope, scrollOffset, numOfItemsForTeleport, 0);
        Object obj7 = lazyLayoutAnimateScrollScope.scroll((Function2)anon, $completion);
        if (obj7 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return obj7;
        }
        return Unit.INSTANCE;
    }

    private static final void debugLog(Function0<String> generateMsg) {
        final int i = 0;
    }

    public static final boolean isItemVisible(androidx.compose.foundation.lazy.layout.LazyLayoutAnimateScrollScope $this$isItemVisible, int index) {
        int i;
        i = 0;
        if (index <= $this$isItemVisible.getLastVisibleItemIndex() && $this$isItemVisible.getFirstVisibleItemIndex() <= index) {
            if ($this$isItemVisible.getFirstVisibleItemIndex() <= index) {
                i = 1;
            }
        }
        return i;
    }
}
