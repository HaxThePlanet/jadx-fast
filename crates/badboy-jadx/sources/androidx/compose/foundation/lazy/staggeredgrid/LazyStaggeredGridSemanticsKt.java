package androidx.compose.foundation.lazy.staggeredgrid;

import androidx.compose.foundation.lazy.layout.LazyLayoutSemanticState;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Composer.Companion;
import androidx.compose.runtime.ComposerKt;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0002\u001a\u001d\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0001¢\u0006\u0002\u0010\u0006¨\u0006\u0007", d2 = {"rememberLazyStaggeredGridSemanticState", "Landroidx/compose/foundation/lazy/layout/LazyLayoutSemanticState;", "state", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridState;", "reverseScrolling", "", "(Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridState;ZLandroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/lazy/layout/LazyLayoutSemanticState;", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class LazyStaggeredGridSemanticsKt {
    public static final LazyLayoutSemanticState rememberLazyStaggeredGridSemanticState(androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridState state, boolean reverseScrolling, Composer $composer, int $changed) {
        boolean traceInProgress;
        int changed;
        int i;
        String str;
        Object empty;
        Object anon;
        int i2 = 1629354903;
        ComposerKt.sourceInformationMarkerStart($composer, i2, "C(rememberLazyStaggeredGridSemanticState)P(1)33@1351L1223:LazyStaggeredGridSemantics.kt#fzvcnm");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i2, $changed, -1, "androidx.compose.foundation.lazy.staggeredgrid.rememberLazyStaggeredGridSemanticState (LazyStaggeredGridSemantics.kt:33)");
        }
        ComposerKt.sourceInformationMarkerStart($composer, 518757981, "CC(remember):LazyStaggeredGridSemantics.kt#9igjgp");
        int i6 = 32;
        if (i5 ^= 48 > i6) {
            if (!$composer.changed(reverseScrolling)) {
                i = $changed & 48 == i6 ? 1 : 0;
            } else {
            }
        } else {
        }
        Composer composer = $composer;
        int i7 = 0;
        final Object rememberedValue = composer.rememberedValue();
        final int i8 = 0;
        if (changed2 |= i == 0) {
            if (rememberedValue == Composer.Companion.getEmpty()) {
                empty = 0;
                anon = new LazyStaggeredGridSemanticsKt.rememberLazyStaggeredGridSemanticState.1.1(state);
                composer.updateRememberedValue(anon);
            } else {
                anon = rememberedValue;
            }
        } else {
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return (LazyLayoutSemanticState)(LazyStaggeredGridSemanticsKt.rememberLazyStaggeredGridSemanticState.1.1)anon;
    }
}
