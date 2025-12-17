package androidx.compose.foundation.lazy.grid;

import androidx.compose.foundation.lazy.layout.LazyLayoutBeyondBoundsState;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Composer.Companion;
import androidx.compose.runtime.ComposerKt;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u001a\u0015\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0001¢\u0006\u0002\u0010\u0004¨\u0006\u0005", d2 = {"rememberLazyGridBeyondBoundsState", "Landroidx/compose/foundation/lazy/layout/LazyLayoutBeyondBoundsState;", "state", "Landroidx/compose/foundation/lazy/grid/LazyGridState;", "(Landroidx/compose/foundation/lazy/grid/LazyGridState;Landroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/lazy/layout/LazyLayoutBeyondBoundsState;", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class LazyGridBeyondBoundsModifierKt {
    public static final LazyLayoutBeyondBoundsState rememberLazyGridBeyondBoundsState(androidx.compose.foundation.lazy.grid.LazyGridState state, Composer $composer, int $changed) {
        int changed;
        int i;
        boolean traceInProgress;
        String str;
        Object empty;
        Object lazyGridBeyondBoundsState;
        int i2 = 2004349821;
        ComposerKt.sourceInformationMarkerStart($composer, i2, "C(rememberLazyGridBeyondBoundsState)24@947L64:LazyGridBeyondBoundsModifier.kt#7791vq");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i2, $changed, -1, "androidx.compose.foundation.lazy.grid.rememberLazyGridBeyondBoundsState (LazyGridBeyondBoundsModifier.kt:23)");
        }
        ComposerKt.sourceInformationMarkerStart($composer, -242332290, "CC(remember):LazyGridBeyondBoundsModifier.kt#9igjgp");
        int i5 = 4;
        if (i4 ^= 6 > i5) {
            if (!$composer.changed(state)) {
                i = $changed & 6 == i5 ? 1 : 0;
            } else {
            }
        } else {
        }
        Composer composer = $composer;
        int i6 = 0;
        final Object rememberedValue = composer.rememberedValue();
        final int i7 = 0;
        if (i == 0) {
            if (rememberedValue == Composer.Companion.getEmpty()) {
                empty = 0;
                lazyGridBeyondBoundsState = new LazyGridBeyondBoundsState(state);
                composer.updateRememberedValue(lazyGridBeyondBoundsState);
            } else {
                lazyGridBeyondBoundsState = rememberedValue;
            }
        } else {
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return (LazyLayoutBeyondBoundsState)(LazyGridBeyondBoundsState)lazyGridBeyondBoundsState;
    }
}
