package androidx.compose.foundation;

import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Composer.Companion;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.InspectableValueKt;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000&\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0006\u001a\u0017\u0010\u0000\u001a\u00020\u00012\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u0003H\u0007¢\u0006\u0002\u0010\u0004\u001a2\u0010\u0005\u001a\u00020\u0006*\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00012\u0008\u0008\u0002\u0010\u0008\u001a\u00020\t2\n\u0008\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0008\u0008\u0002\u0010\u000c\u001a\u00020\t\u001a6\u0010\r\u001a\u00020\u0006*\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00012\u0006\u0010\u000c\u001a\u00020\t2\u0008\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\tH\u0002\u001a2\u0010\u0010\u001a\u00020\u0006*\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00012\u0008\u0008\u0002\u0010\u0008\u001a\u00020\t2\n\u0008\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0008\u0008\u0002\u0010\u000c\u001a\u00020\t¨\u0006\u0011", d2 = {"rememberScrollState", "Landroidx/compose/foundation/ScrollState;", "initial", "", "(ILandroidx/compose/runtime/Composer;II)Landroidx/compose/foundation/ScrollState;", "horizontalScroll", "Landroidx/compose/ui/Modifier;", "state", "enabled", "", "flingBehavior", "Landroidx/compose/foundation/gestures/FlingBehavior;", "reverseScrolling", "scroll", "isScrollable", "isVertical", "verticalScroll", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class ScrollKt {
    public static final Modifier horizontalScroll(Modifier $this$horizontalScroll, androidx.compose.foundation.ScrollState state, boolean enabled, FlingBehavior flingBehavior, boolean reverseScrolling) {
        return ScrollKt.scroll($this$horizontalScroll, state, reverseScrolling, flingBehavior, enabled, false);
    }

    public static Modifier horizontalScroll$default(Modifier modifier, androidx.compose.foundation.ScrollState scrollState2, boolean z3, FlingBehavior flingBehavior4, boolean z5, int i6, Object object7) {
        int obj2;
        int obj3;
        int obj4;
        if (i6 & 2 != 0) {
            obj2 = 1;
        }
        if (i6 & 4 != 0) {
            obj3 = 0;
        }
        if (i6 &= 8 != 0) {
            obj4 = 0;
        }
        return ScrollKt.horizontalScroll(modifier, scrollState2, obj2, obj3, obj4);
    }

    public static final androidx.compose.foundation.ScrollState rememberScrollState(int initial, Composer $composer, int $changed, int i4) {
        int changed;
        int i;
        String str;
        Object empty;
        Object anon;
        int obj9;
        boolean obj12;
        int i2 = -1464256199;
        ComposerKt.sourceInformationMarkerStart($composer, i2, "C(rememberScrollState)70@3262L46,70@3218L90:Scroll.kt#71ulvw");
        if (i4 &= i != 0) {
            obj9 = 0;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i2, $changed, -1, "androidx.compose.foundation.rememberScrollState (Scroll.kt:69)");
        }
        obj12 = 0;
        ComposerKt.sourceInformationMarkerStart($composer, -506669717, "CC(remember):Scroll.kt#9igjgp");
        int i7 = 4;
        if (i5 ^= 6 > i7) {
            if (!$composer.changed(obj9)) {
                if ($changed & 6 == i7) {
                } else {
                    i = obj12;
                }
            } else {
            }
        } else {
        }
        obj12 = $composer;
        int i6 = 0;
        Object rememberedValue = obj12.rememberedValue();
        int i9 = 0;
        if (i == 0) {
            if (rememberedValue == Composer.Companion.getEmpty()) {
                empty = 0;
                anon = new ScrollKt.rememberScrollState.1.1(obj9);
                obj12.updateRememberedValue((Function0)anon);
            } else {
                anon = rememberedValue;
            }
        } else {
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        Composer composer = $composer;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return (ScrollState)RememberSaveableKt.rememberSaveable(new Object[obj12], ScrollState.Companion.getSaver(), 0, (Function0)anon, composer, 0, 4);
    }

    private static final Modifier scroll(Modifier $this$scroll, androidx.compose.foundation.ScrollState state, boolean reverseScrolling, FlingBehavior flingBehavior, boolean isScrollable, boolean isVertical) {
        kotlin.jvm.functions.Function1 noInspectorInfo;
        androidx.compose.foundation.ScrollState state2;
        boolean z3;
        FlingBehavior flingBehavior2;
        boolean z2;
        boolean z;
        final int i = 0;
        if (InspectableValueKt.isDebugInspectorInfoEnabled()) {
            noInspectorInfo = new ScrollKt.scroll$$inlined.debugInspectorInfo.1(state, reverseScrolling, flingBehavior, isScrollable, isVertical);
        } else {
            state2 = state;
            z3 = reverseScrolling;
            flingBehavior2 = flingBehavior;
            z2 = isScrollable;
            z = isVertical;
            noInspectorInfo = InspectableValueKt.getNoInspectorInfo();
        }
        final boolean z4 = z;
        boolean isVertical2 = z2;
        FlingBehavior isScrollable2 = flingBehavior2;
        boolean flingBehavior3 = z3;
        androidx.compose.foundation.ScrollState reverseScrolling2 = state2;
        ScrollKt.scroll.2 state3 = new ScrollKt.scroll.2(reverseScrolling2, flingBehavior3, isScrollable2, isVertical2, z4);
        androidx.compose.foundation.ScrollState scrollState = reverseScrolling2;
        boolean state4 = flingBehavior3;
        FlingBehavior reverseScrolling3 = isScrollable2;
        boolean flingBehavior4 = isVertical2;
        boolean isScrollable3 = z4;
        return ComposedModifierKt.composed($this$scroll, noInspectorInfo, (Function3)state3);
    }

    public static final Modifier verticalScroll(Modifier $this$verticalScroll, androidx.compose.foundation.ScrollState state, boolean enabled, FlingBehavior flingBehavior, boolean reverseScrolling) {
        return ScrollKt.scroll($this$verticalScroll, state, reverseScrolling, flingBehavior, enabled, true);
    }

    public static Modifier verticalScroll$default(Modifier modifier, androidx.compose.foundation.ScrollState scrollState2, boolean z3, FlingBehavior flingBehavior4, boolean z5, int i6, Object object7) {
        int obj2;
        int obj3;
        int obj4;
        if (i6 & 2 != 0) {
            obj2 = 1;
        }
        if (i6 & 4 != 0) {
            obj3 = 0;
        }
        if (i6 &= 8 != 0) {
            obj4 = 0;
        }
        return ScrollKt.verticalScroll(modifier, scrollState2, obj2, obj3, obj4);
    }
}
