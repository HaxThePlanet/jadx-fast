package androidx.compose.foundation.gestures.snapping;

import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.lazy.LazyListLayoutInfo;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Composer.Companion;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntSize;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000:\n\u0000\n\u0002\u0010\u0008\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\u0008\u0002\u001a\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00082\u0008\u0008\u0002\u0010\t\u001a\u00020\n\u001a\u001f\u0010\u000b\u001a\u00020\u000c2\u0006\u0010\u0007\u001a\u00020\u00082\u0008\u0008\u0002\u0010\t\u001a\u00020\nH\u0007¢\u0006\u0002\u0010\r\u001a\u0019\u0010\u000e\u001a\u00020\u000f*\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0000¢\u0006\u0002\u0010\u0013\"\u0018\u0010\u0000\u001a\u00020\u0001*\u00020\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\u0008\u0003\u0010\u0004¨\u0006\u0014", d2 = {"singleAxisViewportSize", "", "Landroidx/compose/foundation/lazy/LazyListLayoutInfo;", "getSingleAxisViewportSize", "(Landroidx/compose/foundation/lazy/LazyListLayoutInfo;)I", "SnapLayoutInfoProvider", "Landroidx/compose/foundation/gestures/snapping/SnapLayoutInfoProvider;", "lazyListState", "Landroidx/compose/foundation/lazy/LazyListState;", "snapPosition", "Landroidx/compose/foundation/gestures/snapping/SnapPosition;", "rememberSnapFlingBehavior", "Landroidx/compose/foundation/gestures/FlingBehavior;", "(Landroidx/compose/foundation/lazy/LazyListState;Landroidx/compose/foundation/gestures/snapping/SnapPosition;Landroidx/compose/runtime/Composer;II)Landroidx/compose/foundation/gestures/FlingBehavior;", "calculateFinalSnappingItem", "Landroidx/compose/foundation/gestures/snapping/FinalSnappingItem;", "Landroidx/compose/ui/unit/Density;", "velocity", "", "(Landroidx/compose/ui/unit/Density;F)I", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class LazyListSnapLayoutInfoProviderKt {
    public static final androidx.compose.foundation.gestures.snapping.SnapLayoutInfoProvider SnapLayoutInfoProvider(LazyListState lazyListState, androidx.compose.foundation.gestures.snapping.SnapPosition snapPosition) {
        LazyListSnapLayoutInfoProviderKt.SnapLayoutInfoProvider.1 anon = new LazyListSnapLayoutInfoProviderKt.SnapLayoutInfoProvider.1(lazyListState, snapPosition);
        return (SnapLayoutInfoProvider)anon;
    }

    public static androidx.compose.foundation.gestures.snapping.SnapLayoutInfoProvider SnapLayoutInfoProvider$default(LazyListState lazyListState, androidx.compose.foundation.gestures.snapping.SnapPosition snapPosition2, int i3, Object object4) {
        androidx.compose.foundation.gestures.snapping.SnapPosition.Center obj1;
        if (i3 &= 2 != 0) {
            obj1 = SnapPosition.Center.INSTANCE;
        }
        return LazyListSnapLayoutInfoProviderKt.SnapLayoutInfoProvider(lazyListState, obj1);
    }

    public static final int calculateFinalSnappingItem(Density $this$calculateFinalSnappingItem, float velocity) {
        int previousItem-bbeMdSM;
        if (Float.compare(f, px-0680j_4) < 0) {
            previousItem-bbeMdSM = FinalSnappingItem.Companion.getClosestItem-bbeMdSM();
        } else {
            if (Float.compare(velocity, i) > 0) {
                previousItem-bbeMdSM = FinalSnappingItem.Companion.getNextItem-bbeMdSM();
            } else {
                previousItem-bbeMdSM = FinalSnappingItem.Companion.getPreviousItem-bbeMdSM();
            }
        }
        return previousItem-bbeMdSM;
    }

    public static final int getSingleAxisViewportSize(LazyListLayoutInfo $this$singleAxisViewportSize) {
        int height-impl;
        final Orientation vertical = Orientation.Vertical;
        if ($this$singleAxisViewportSize.getOrientation() == vertical) {
            height-impl = IntSize.getHeight-impl($this$singleAxisViewportSize.getViewportSize-YbymL2g());
        } else {
            height-impl = IntSize.getWidth-impl($this$singleAxisViewportSize.getViewportSize-YbymL2g());
        }
        return height-impl;
    }

    public static final FlingBehavior rememberSnapFlingBehavior(LazyListState lazyListState, androidx.compose.foundation.gestures.snapping.SnapPosition snapPosition, Composer $composer, int $changed, int i5) {
        String str;
        Object $i$a$CacheLazyListSnapLayoutInfoProviderKt$rememberSnapFlingBehavior$snappingLayout$1;
        Object empty;
        androidx.compose.foundation.gestures.snapping.SnapPosition.Center obj7;
        int obj10;
        int i = -338621290;
        ComposerKt.sourceInformationMarkerStart($composer, i, "C(rememberSnapFlingBehavior)117@4457L79,118@4548L41:LazyListSnapLayoutInfoProvider.kt#ppz6w6");
        if (i5 &= 2 != 0) {
            obj7 = obj10;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i, $changed, -1, "androidx.compose.foundation.gestures.snapping.rememberSnapFlingBehavior (LazyListSnapLayoutInfoProvider.kt:115)");
        }
        ComposerKt.sourceInformationMarkerStart($composer, 962523518, "CC(remember):LazyListSnapLayoutInfoProvider.kt#9igjgp");
        int i2 = 0;
        int i3 = 4;
        if (obj10 ^= 6 > i3) {
            if (!$composer.changed(lazyListState)) {
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
                composer.updateRememberedValue(LazyListSnapLayoutInfoProviderKt.SnapLayoutInfoProvider(lazyListState, obj7));
            } else {
                $i$a$CacheLazyListSnapLayoutInfoProviderKt$rememberSnapFlingBehavior$snappingLayout$1 = rememberedValue;
            }
        } else {
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return (FlingBehavior)SnapFlingBehaviorKt.rememberSnapFlingBehavior((SnapLayoutInfoProvider)$i$a$CacheLazyListSnapLayoutInfoProviderKt$rememberSnapFlingBehavior$snappingLayout$1, $composer, i2);
    }
}
