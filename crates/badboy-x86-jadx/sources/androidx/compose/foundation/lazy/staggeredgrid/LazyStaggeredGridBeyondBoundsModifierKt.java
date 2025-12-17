package androidx.compose.foundation.lazy.staggeredgrid;

import androidx.compose.foundation.lazy.layout.LazyLayoutBeyondBoundsState;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Composer.Companion;
import androidx.compose.runtime.ComposerKt;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u001a\u0015\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0001¢\u0006\u0002\u0010\u0004¨\u0006\u0005", d2 = {"rememberLazyStaggeredGridBeyondBoundsState", "Landroidx/compose/foundation/lazy/layout/LazyLayoutBeyondBoundsState;", "state", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridState;", "(Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridState;Landroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/lazy/layout/LazyLayoutBeyondBoundsState;", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class LazyStaggeredGridBeyondBoundsModifierKt {
    public static final LazyLayoutBeyondBoundsState rememberLazyStaggeredGridBeyondBoundsState(androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridState state, Composer $composer, int $changed) {
        boolean traceInProgress;
        String str;
        Object empty;
        Object lazyStaggeredGridBeyondBoundsState;
        int i = -363070453;
        ComposerKt.sourceInformationMarkerStart($composer, i, "C(rememberLazyStaggeredGridBeyondBoundsState)26@980L73:LazyStaggeredGridBeyondBoundsModifier.kt#fzvcnm");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i, $changed, -1, "androidx.compose.foundation.lazy.staggeredgrid.rememberLazyStaggeredGridBeyondBoundsState (LazyStaggeredGridBeyondBoundsModifier.kt:25)");
        }
        ComposerKt.sourceInformationMarkerStart($composer, -1392793503, "CC(remember):LazyStaggeredGridBeyondBoundsModifier.kt#9igjgp");
        Composer composer = $composer;
        int i3 = 0;
        final Object rememberedValue = composer.rememberedValue();
        final int i4 = 0;
        if (!$composer.changed(state)) {
            if (rememberedValue == Composer.Companion.getEmpty()) {
                empty = 0;
                lazyStaggeredGridBeyondBoundsState = new LazyStaggeredGridBeyondBoundsState(state);
                composer.updateRememberedValue(lazyStaggeredGridBeyondBoundsState);
            } else {
                lazyStaggeredGridBeyondBoundsState = rememberedValue;
            }
        } else {
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return (LazyLayoutBeyondBoundsState)(LazyStaggeredGridBeyondBoundsState)lazyStaggeredGridBeyondBoundsState;
    }
}
