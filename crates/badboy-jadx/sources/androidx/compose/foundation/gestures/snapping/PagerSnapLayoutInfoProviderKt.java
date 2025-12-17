package androidx.compose.foundation.gestures.snapping;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.pager.PagerLayoutInfo;
import androidx.compose.foundation.pager.PagerSnapDistance;
import androidx.compose.foundation.pager.PagerState;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000@\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0002\u001a8\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u001e\u0010\u0006\u001a\u001a\u0012\u0004\u0012\u00020\u0008\u0012\u0004\u0012\u00020\u0008\u0012\u0004\u0012\u00020\u0008\u0012\u0004\u0012\u00020\u00080\u0007H\u0000\u001a8\u0010\u0006\u001a\u00020\u00082\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00082\u0006\u0010\u000c\u001a\u00020\u00082\u0006\u0010\r\u001a\u00020\u00082\u0006\u0010\u000e\u001a\u00020\u0008H\u0000\u001a\u0017\u0010\u000f\u001a\u00020\u00102\u000c\u0010\u0011\u001a\u0008\u0012\u0004\u0012\u00020\u00130\u0012H\u0082\u0008\u001a\u000c\u0010\u0014\u001a\u00020\u0008*\u00020\u0003H\u0002\u001a\u000c\u0010\u0015\u001a\u00020\u0016*\u00020\u0003H\u0002\u001a\u000c\u0010\u0017\u001a\u00020\u0016*\u00020\u0003H\u0002¨\u0006\u0018", d2 = {"SnapLayoutInfoProvider", "Landroidx/compose/foundation/gestures/snapping/SnapLayoutInfoProvider;", "pagerState", "Landroidx/compose/foundation/pager/PagerState;", "pagerSnapDistance", "Landroidx/compose/foundation/pager/PagerSnapDistance;", "calculateFinalSnappingBound", "Lkotlin/Function3;", "", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "snapPositionalThreshold", "flingVelocity", "lowerBoundOffset", "upperBoundOffset", "debugLog", "", "generateMsg", "Lkotlin/Function0;", "", "dragGestureDelta", "isLtrDragging", "", "isScrollingForward", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class PagerSnapLayoutInfoProviderKt {
    public static final androidx.compose.foundation.gestures.snapping.SnapLayoutInfoProvider SnapLayoutInfoProvider(PagerState pagerState, PagerSnapDistance pagerSnapDistance, Function3<? super Float, ? super Float, ? super Float, Float> calculateFinalSnappingBound) {
        PagerSnapLayoutInfoProviderKt.SnapLayoutInfoProvider.1 anon = new PagerSnapLayoutInfoProviderKt.SnapLayoutInfoProvider.1(pagerState, calculateFinalSnappingBound, pagerSnapDistance);
        return (SnapLayoutInfoProvider)anon;
    }

    public static final float access$dragGestureDelta(PagerState $receiver) {
        return PagerSnapLayoutInfoProviderKt.dragGestureDelta($receiver);
    }

    public static final boolean access$isScrollingForward(PagerState $receiver) {
        return PagerSnapLayoutInfoProviderKt.isScrollingForward($receiver);
    }

    public static final float calculateFinalSnappingBound(PagerState pagerState, LayoutDirection layoutDirection, float snapPositionalThreshold, float flingVelocity, float lowerBoundOffset, float upperBoundOffset) {
        boolean scrollingForward;
        int cmp;
        int i;
        float f;
        boolean equals-impl0;
        if (pagerState.getLayoutInfo().getOrientation() == Orientation.Vertical) {
            scrollingForward = PagerSnapLayoutInfoProviderKt.isScrollingForward(pagerState);
        } else {
            if (layoutDirection == LayoutDirection.Ltr) {
                scrollingForward = PagerSnapLayoutInfoProviderKt.isScrollingForward(pagerState);
            } else {
                scrollingForward = !PagerSnapLayoutInfoProviderKt.isScrollingForward(pagerState) ? 1 : 0;
            }
        }
        int i2 = 0;
        int pageSize = pagerState.getLayoutInfo().getPageSize();
        if (pageSize == 0) {
            i = cmp;
        } else {
            dragGestureDelta /= f;
        }
        int i6 = 0;
        int $this$calculateFinalSnappingBound_u24lambda_u241 = LazyListSnapLayoutInfoProviderKt.calculateFinalSnappingItem(pagerState.getDensity$foundation_release(), flingVelocity);
        int i7 = 0;
        if (FinalSnappingItem.equals-impl0($this$calculateFinalSnappingBound_u24lambda_u241, FinalSnappingItem.Companion.getClosestItem-bbeMdSM())) {
            if (Float.compare(f2, snapPositionalThreshold) > 0) {
                cmp = 0;
                if (scrollingForward) {
                    cmp = upperBoundOffset;
                } else {
                    cmp = lowerBoundOffset;
                }
            } else {
                if (Float.compare(f3, equals-impl0) >= 0) {
                    cmp = 0;
                    if (scrollingForward) {
                    } else {
                    }
                } else {
                    int i3 = 0;
                    if (Float.compare(f4, equals-impl0) < 0) {
                    } else {
                    }
                }
            }
        } else {
            if (FinalSnappingItem.equals-impl0($this$calculateFinalSnappingBound_u24lambda_u241, FinalSnappingItem.Companion.getNextItem-bbeMdSM())) {
            } else {
                if (FinalSnappingItem.equals-impl0($this$calculateFinalSnappingBound_u24lambda_u241, FinalSnappingItem.Companion.getPreviousItem-bbeMdSM())) {
                } else {
                }
            }
        }
        return cmp;
    }

    private static final void debugLog(Function0<String> generateMsg) {
        final int i = 0;
    }

    private static final float dragGestureDelta(PagerState $this$dragGestureDelta) {
        float x-impl;
        final Orientation horizontal = Orientation.Horizontal;
        if ($this$dragGestureDelta.getLayoutInfo().getOrientation() == horizontal) {
            x-impl = Offset.getX-impl($this$dragGestureDelta.getUpDownDifference-F1C5BW0$foundation_release());
        } else {
            x-impl = Offset.getY-impl($this$dragGestureDelta.getUpDownDifference-F1C5BW0$foundation_release());
        }
        return x-impl;
    }

    private static final boolean isLtrDragging(PagerState $this$isLtrDragging) {
        int i;
        i = Float.compare(dragGestureDelta, i2) > 0 ? 1 : 0;
        return i;
    }

    private static final boolean isScrollingForward(PagerState $this$isScrollingForward) {
        int i;
        boolean ltrDragging;
        boolean reverseLayout = $this$isScrollingForward.getLayoutInfo().getReverseLayout();
        if (PagerSnapLayoutInfoProviderKt.isLtrDragging($this$isScrollingForward)) {
            if (!reverseLayout) {
                if (!PagerSnapLayoutInfoProviderKt.isLtrDragging($this$isScrollingForward) && !reverseLayout) {
                    i = !reverseLayout ? 1 : 0;
                } else {
                }
            } else {
            }
        } else {
        }
        return i;
    }
}
