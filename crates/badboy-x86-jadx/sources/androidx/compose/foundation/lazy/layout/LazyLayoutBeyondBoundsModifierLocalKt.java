package androidx.compose.foundation.lazy.layout;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Composer.Companion;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000.\n\u0000\n\u0002\u0010\u0001\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u001a\u0008\u0010\u0000\u001a\u00020\u0001H\u0002\u001aA\u0010\u0002\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0008\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u000c\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\tH\u0001¢\u0006\u0002\u0010\u000f¨\u0006\u0010", d2 = {"unsupportedDirection", "", "lazyLayoutBeyondBoundsModifier", "Landroidx/compose/ui/Modifier;", "state", "Landroidx/compose/foundation/lazy/layout/LazyLayoutBeyondBoundsState;", "beyondBoundsInfo", "Landroidx/compose/foundation/lazy/layout/LazyLayoutBeyondBoundsInfo;", "reverseLayout", "", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "enabled", "(Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/lazy/layout/LazyLayoutBeyondBoundsState;Landroidx/compose/foundation/lazy/layout/LazyLayoutBeyondBoundsInfo;ZLandroidx/compose/ui/unit/LayoutDirection;Landroidx/compose/foundation/gestures/Orientation;ZLandroidx/compose/runtime/Composer;I)Landroidx/compose/ui/Modifier;", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class LazyLayoutBeyondBoundsModifierLocalKt {
    public static final Void access$unsupportedDirection() {
        return LazyLayoutBeyondBoundsModifierLocalKt.unsupportedDirection();
    }

    public static final Modifier lazyLayoutBeyondBoundsModifier(Modifier $this$lazyLayoutBeyondBoundsModifier, androidx.compose.foundation.lazy.layout.LazyLayoutBeyondBoundsState state, androidx.compose.foundation.lazy.layout.LazyLayoutBeyondBoundsInfo beyondBoundsInfo, boolean reverseLayout, LayoutDirection layoutDirection, Orientation orientation, boolean enabled, Composer $composer, int $changed) {
        Modifier then;
        boolean changed3;
        int i9;
        boolean traceInProgress;
        boolean changed4;
        int i7;
        int changed;
        int i;
        boolean changed2;
        int i3;
        String str;
        int i5;
        int i4;
        Object lazyLayoutBeyondBoundsModifierLocal;
        int empty;
        Object obj3;
        Object obj2;
        boolean z;
        Object obj;
        int i2;
        boolean rememberedValue;
        int i6;
        int i8;
        final Composer composer = $composer;
        final int i10 = $changed;
        int i11 = 1331498025;
        ComposerKt.sourceInformationMarkerStart(composer, i11, "C(lazyLayoutBeyondBoundsModifier)P(5!1,4,2,3):LazyLayoutBeyondBoundsModifierLocal.kt#wow0x6");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i11, i10, -1, "androidx.compose.foundation.lazy.layout.lazyLayoutBeyondBoundsModifier (LazyLayoutBeyondBoundsModifierLocal.kt:51)");
        }
        if (!enabled) {
            composer.startReplaceGroup(-1890658823);
            composer.endReplaceGroup();
            then = $this$lazyLayoutBeyondBoundsModifier;
        } else {
            composer.startReplaceGroup(-1890632411);
            ComposerKt.sourceInformation(composer, "54@2427L270");
            ComposerKt.sourceInformationMarkerStart(composer, -753724309, "CC(remember):LazyLayoutBeyondBoundsModifierLocal.kt#9igjgp");
            int i20 = 32;
            i5 = 0;
            int i28 = 1;
            if (i15 ^= 48 > i20) {
                if (!composer.changed(state)) {
                    i9 = i10 & 48 == i20 ? i28 : i5;
                } else {
                }
            } else {
                obj3 = state;
            }
            int i29 = 256;
            if (i21 ^= 384 > i29) {
                if (!composer.changed(beyondBoundsInfo)) {
                    i7 = i10 & 384 == i29 ? i28 : i5;
                } else {
                }
            } else {
                obj2 = beyondBoundsInfo;
            }
            int i30 = 2048;
            if (i22 ^= 3072 > i30) {
                if (!composer.changed(reverseLayout)) {
                    i = i10 & 3072 == i30 ? i28 : i5;
                } else {
                }
            } else {
                z = reverseLayout;
            }
            int i31 = 16384;
            if (i24 ^= 24576 > i31) {
                if (!composer.changed(layoutDirection)) {
                    i3 = i10 & 24576 == i31 ? i28 : i5;
                } else {
                }
            } else {
                obj = layoutDirection;
            }
            empty = 196608;
            i2 = 131072;
            if (i26 ^= empty > i2) {
                if (!composer.changed(orientation)) {
                    if (empty &= i10 == i2) {
                        i5 = i28;
                    }
                } else {
                }
            } else {
                traceInProgress = orientation;
            }
            str = $composer;
            i4 = 0;
            rememberedValue = str.rememberedValue();
            i6 = 0;
            if (i18 |= i5 == 0) {
                if (rememberedValue == Composer.Companion.getEmpty()) {
                    i8 = 0;
                    lazyLayoutBeyondBoundsModifierLocal = new LazyLayoutBeyondBoundsModifierLocal(obj3, obj2, z, obj, traceInProgress);
                    str.updateRememberedValue(lazyLayoutBeyondBoundsModifierLocal);
                } else {
                    lazyLayoutBeyondBoundsModifierLocal = rememberedValue;
                }
            } else {
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            then = $this$lazyLayoutBeyondBoundsModifier.then((Modifier)(LazyLayoutBeyondBoundsModifierLocal)lazyLayoutBeyondBoundsModifierLocal);
            composer.endReplaceGroup();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return then;
    }

    private static final Void unsupportedDirection() {
        IllegalStateException illegalStateException = new IllegalStateException("Lazy list does not support beyond bounds layout for the specified direction".toString());
        throw illegalStateException;
    }
}
