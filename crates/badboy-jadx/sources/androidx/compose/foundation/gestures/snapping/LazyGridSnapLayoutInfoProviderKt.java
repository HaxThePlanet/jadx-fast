package androidx.compose.foundation.gestures.snapping;

import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.lazy.grid.LazyGridItemInfo;
import androidx.compose.foundation.lazy.grid.LazyGridLayoutInfo;
import androidx.compose.foundation.lazy.grid.LazyGridState;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Composer.Companion;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSize;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00006\n\u0000\n\u0002\u0010\u0008\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u001a\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00082\u0008\u0008\u0002\u0010\t\u001a\u00020\n\u001a\u001f\u0010\u000b\u001a\u00020\u000c2\u0006\u0010\u0007\u001a\u00020\u00082\u0008\u0008\u0002\u0010\t\u001a\u00020\nH\u0007¢\u0006\u0002\u0010\r\u001a\u0014\u0010\u000e\u001a\u00020\u0001*\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0000\u001a\u0014\u0010\u0012\u001a\u00020\u0001*\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0000\"\u0018\u0010\u0000\u001a\u00020\u0001*\u00020\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\u0008\u0003\u0010\u0004¨\u0006\u0013", d2 = {"singleAxisViewportSize", "", "Landroidx/compose/foundation/lazy/grid/LazyGridLayoutInfo;", "getSingleAxisViewportSize", "(Landroidx/compose/foundation/lazy/grid/LazyGridLayoutInfo;)I", "SnapLayoutInfoProvider", "Landroidx/compose/foundation/gestures/snapping/SnapLayoutInfoProvider;", "lazyGridState", "Landroidx/compose/foundation/lazy/grid/LazyGridState;", "snapPosition", "Landroidx/compose/foundation/gestures/snapping/SnapPosition;", "rememberSnapFlingBehavior", "Landroidx/compose/foundation/gestures/FlingBehavior;", "(Landroidx/compose/foundation/lazy/grid/LazyGridState;Landroidx/compose/foundation/gestures/snapping/SnapPosition;Landroidx/compose/runtime/Composer;II)Landroidx/compose/foundation/gestures/FlingBehavior;", "offsetOnMainAxis", "Landroidx/compose/foundation/lazy/grid/LazyGridItemInfo;", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "sizeOnMainAxis", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class LazyGridSnapLayoutInfoProviderKt {
    public static final androidx.compose.foundation.gestures.snapping.SnapLayoutInfoProvider SnapLayoutInfoProvider(LazyGridState lazyGridState, androidx.compose.foundation.gestures.snapping.SnapPosition snapPosition) {
        LazyGridSnapLayoutInfoProviderKt.SnapLayoutInfoProvider.1 anon = new LazyGridSnapLayoutInfoProviderKt.SnapLayoutInfoProvider.1(lazyGridState, snapPosition);
        return (SnapLayoutInfoProvider)anon;
    }

    public static androidx.compose.foundation.gestures.snapping.SnapLayoutInfoProvider SnapLayoutInfoProvider$default(LazyGridState lazyGridState, androidx.compose.foundation.gestures.snapping.SnapPosition snapPosition2, int i3, Object object4) {
        androidx.compose.foundation.gestures.snapping.SnapPosition.Center obj1;
        if (i3 &= 2 != 0) {
            obj1 = SnapPosition.Center.INSTANCE;
        }
        return LazyGridSnapLayoutInfoProviderKt.SnapLayoutInfoProvider(lazyGridState, obj1);
    }

    public static final int getSingleAxisViewportSize(LazyGridLayoutInfo $this$singleAxisViewportSize) {
        int height-impl;
        final Orientation vertical = Orientation.Vertical;
        if ($this$singleAxisViewportSize.getOrientation() == vertical) {
            height-impl = IntSize.getHeight-impl($this$singleAxisViewportSize.getViewportSize-YbymL2g());
        } else {
            height-impl = IntSize.getWidth-impl($this$singleAxisViewportSize.getViewportSize-YbymL2g());
        }
        return height-impl;
    }

    public static final int offsetOnMainAxis(LazyGridItemInfo $this$offsetOnMainAxis, Orientation orientation) {
        int y-impl;
        if (orientation == Orientation.Vertical) {
            y-impl = IntOffset.getY-impl($this$offsetOnMainAxis.getOffset-nOcc-ac());
        } else {
            y-impl = IntOffset.getX-impl($this$offsetOnMainAxis.getOffset-nOcc-ac());
        }
        return y-impl;
    }

    public static final FlingBehavior rememberSnapFlingBehavior(LazyGridState lazyGridState, androidx.compose.foundation.gestures.snapping.SnapPosition snapPosition, Composer $composer, int $changed, int i5) {
        String str;
        Object $i$a$CacheLazyGridSnapLayoutInfoProviderKt$rememberSnapFlingBehavior$snappingLayout$1;
        Object empty;
        androidx.compose.foundation.gestures.snapping.SnapPosition.Center obj7;
        int obj10;
        int i = -234434234;
        ComposerKt.sourceInformationMarkerStart($composer, i, "C(rememberSnapFlingBehavior)118@4715L79,119@4806L41:LazyGridSnapLayoutInfoProvider.kt#ppz6w6");
        if (i5 &= 2 != 0) {
            obj7 = obj10;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i, $changed, -1, "androidx.compose.foundation.gestures.snapping.rememberSnapFlingBehavior (LazyGridSnapLayoutInfoProvider.kt:116)");
        }
        ComposerKt.sourceInformationMarkerStart($composer, 962531774, "CC(remember):LazyGridSnapLayoutInfoProvider.kt#9igjgp");
        int i2 = 0;
        int i3 = 4;
        if (obj10 ^= 6 > i3) {
            if (!$composer.changed(lazyGridState)) {
                obj10 = $changed & 6 == i3 ? 1 : i2;
            } else {
            }
        } else {
        }
        Composer composer = $composer;
        final int i4 = 0;
        final Object rememberedValue = composer.rememberedValue();
        final int i6 = 0;
        if (obj10 == null) {
            if (rememberedValue == Composer.Companion.getEmpty()) {
                int i7 = 0;
                composer.updateRememberedValue(LazyGridSnapLayoutInfoProviderKt.SnapLayoutInfoProvider(lazyGridState, obj7));
            } else {
                $i$a$CacheLazyGridSnapLayoutInfoProviderKt$rememberSnapFlingBehavior$snappingLayout$1 = rememberedValue;
            }
        } else {
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return (FlingBehavior)SnapFlingBehaviorKt.rememberSnapFlingBehavior((SnapLayoutInfoProvider)$i$a$CacheLazyGridSnapLayoutInfoProviderKt$rememberSnapFlingBehavior$snappingLayout$1, $composer, i2);
    }

    public static final int sizeOnMainAxis(LazyGridItemInfo $this$sizeOnMainAxis, Orientation orientation) {
        int height-impl;
        if (orientation == Orientation.Vertical) {
            height-impl = IntSize.getHeight-impl($this$sizeOnMainAxis.getSize-YbymL2g());
        } else {
            height-impl = IntSize.getWidth-impl($this$sizeOnMainAxis.getSize-YbymL2g());
        }
        return height-impl;
    }
}
