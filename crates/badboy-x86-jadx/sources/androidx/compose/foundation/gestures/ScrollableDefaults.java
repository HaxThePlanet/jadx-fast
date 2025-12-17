package androidx.compose.foundation.gestures;

import androidx.compose.animation.SplineBasedFloatDecayAnimationSpec_androidKt;
import androidx.compose.foundation.AndroidOverscroll_androidKt;
import androidx.compose.foundation.OverscrollEffect;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Composer.Companion;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008Ç\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u0008\u0010\u0003\u001a\u00020\u0004H\u0007J\r\u0010\u0005\u001a\u00020\u0006H\u0007¢\u0006\u0002\u0010\u0007J\r\u0010\u0008\u001a\u00020\tH\u0007¢\u0006\u0002\u0010\nJ\u001e\u0010\u000b\u001a\u00020\u000c2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u000c¨\u0006\u0012", d2 = {"Landroidx/compose/foundation/gestures/ScrollableDefaults;", "", "()V", "bringIntoViewSpec", "Landroidx/compose/foundation/gestures/BringIntoViewSpec;", "flingBehavior", "Landroidx/compose/foundation/gestures/FlingBehavior;", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/gestures/FlingBehavior;", "overscrollEffect", "Landroidx/compose/foundation/OverscrollEffect;", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/OverscrollEffect;", "reverseDirection", "", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "reverseScrolling", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ScrollableDefaults {

    public static final int $stable;
    public static final androidx.compose.foundation.gestures.ScrollableDefaults INSTANCE;
    static {
        ScrollableDefaults scrollableDefaults = new ScrollableDefaults();
        ScrollableDefaults.INSTANCE = scrollableDefaults;
    }

    @Deprecated(message = "This has been replaced by composition locals LocalBringIntoViewSpec", replaceWith = @ReplaceWith(...))
    public final androidx.compose.foundation.gestures.BringIntoViewSpec bringIntoViewSpec() {
        return BringIntoViewSpec.Companion.getDefaultBringIntoViewSpec$foundation_release();
    }

    public final androidx.compose.foundation.gestures.FlingBehavior flingBehavior(Composer $composer, int $changed) {
        boolean traceInProgress;
        String str;
        Object empty;
        Object defaultFlingBehavior;
        int i2;
        int i;
        int i3 = 1107739818;
        ComposerKt.sourceInformationMarkerStart($composer, i3, "C(flingBehavior)571@22168L33,572@22217L75:Scrollable.kt#8bwon0");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i3, $changed, -1, "androidx.compose.foundation.gestures.ScrollableDefaults.flingBehavior (Scrollable.kt:570)");
        }
        androidx.compose.animation.core.DecayAnimationSpec rememberSplineBasedDecay = SplineBasedFloatDecayAnimationSpec_androidKt.rememberSplineBasedDecay($composer, 0);
        ComposerKt.sourceInformationMarkerStart($composer, -480380690, "CC(remember):Scrollable.kt#9igjgp");
        Composer composer = $composer;
        final int i6 = 0;
        final Object rememberedValue = composer.rememberedValue();
        final int i7 = 0;
        if (!$composer.changed(rememberSplineBasedDecay)) {
            if (rememberedValue == Composer.Companion.getEmpty()) {
                empty = 0;
                i = 0;
                defaultFlingBehavior = new DefaultFlingBehavior(rememberSplineBasedDecay, i, 2, i);
                composer.updateRememberedValue(defaultFlingBehavior);
            } else {
                defaultFlingBehavior = rememberedValue;
            }
        } else {
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return (FlingBehavior)(DefaultFlingBehavior)defaultFlingBehavior;
    }

    public final OverscrollEffect overscrollEffect(Composer $composer, int $changed) {
        boolean traceInProgress;
        String str;
        int i = 1809802212;
        ComposerKt.sourceInformationMarkerStart($composer, i, "C(overscrollEffect)584@22537L26:Scrollable.kt#8bwon0");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i, $changed, -1, "androidx.compose.foundation.gestures.ScrollableDefaults.overscrollEffect (Scrollable.kt:583)");
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return AndroidOverscroll_androidKt.rememberOverscrollEffect($composer, 0);
    }

    public final boolean reverseDirection(LayoutDirection layoutDirection, androidx.compose.foundation.gestures.Orientation orientation, boolean reverseScrolling) {
        int reverseDirection;
        int i2;
        int i;
        androidx.compose.foundation.gestures.Orientation vertical;
        final int i3 = 1;
        i2 = layoutDirection == LayoutDirection.Rtl ? i3 : i;
        if (i2 != 0 && orientation != Orientation.Vertical && reverseScrolling ^ 1 == 0) {
            if (orientation != Orientation.Vertical) {
                if (reverseScrolling ^ 1 == 0) {
                    i = i3;
                }
                reverseDirection = i;
            }
        }
        return reverseDirection;
    }
}
