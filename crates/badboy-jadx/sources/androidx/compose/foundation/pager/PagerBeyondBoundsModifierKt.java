package androidx.compose.foundation.pager;

import androidx.compose.foundation.lazy.layout.LazyLayoutBeyondBoundsState;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Composer.Companion;
import androidx.compose.runtime.ComposerKt;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0002\u001a\u001d\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0001¢\u0006\u0002\u0010\u0006¨\u0006\u0007", d2 = {"rememberPagerBeyondBoundsState", "Landroidx/compose/foundation/lazy/layout/LazyLayoutBeyondBoundsState;", "state", "Landroidx/compose/foundation/pager/PagerState;", "beyondViewportPageCount", "", "(Landroidx/compose/foundation/pager/PagerState;ILandroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/lazy/layout/LazyLayoutBeyondBoundsState;", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class PagerBeyondBoundsModifierKt {
    public static final LazyLayoutBeyondBoundsState rememberPagerBeyondBoundsState(androidx.compose.foundation.pager.PagerState state, int beyondViewportPageCount, Composer $composer, int $changed) {
        int changed2;
        int i2;
        boolean traceInProgress;
        int i;
        String str;
        int changed;
        Object empty;
        Object pagerBeyondBoundsState;
        int i3 = 373558254;
        ComposerKt.sourceInformationMarkerStart($composer, i3, "C(rememberPagerBeyondBoundsState)P(1)26@976L111:PagerBeyondBoundsModifier.kt#g6yjnt");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i3, $changed, -1, "androidx.compose.foundation.pager.rememberPagerBeyondBoundsState (PagerBeyondBoundsModifier.kt:25)");
        }
        ComposerKt.sourceInformationMarkerStart($composer, 1074814635, "CC(remember):PagerBeyondBoundsModifier.kt#9igjgp");
        int i7 = 1;
        int i9 = 4;
        if (i5 ^= 6 > i9) {
            if (!$composer.changed(state)) {
                i2 = $changed & 6 == i9 ? i7 : i;
            } else {
            }
        } else {
        }
        int i11 = 32;
        if (i10 ^= 48 > i11) {
            if (!$composer.changed(beyondViewportPageCount)) {
                if ($changed & 48 == i11) {
                    i = i7;
                }
            } else {
            }
        } else {
        }
        Composer composer = $composer;
        int i8 = 0;
        Object rememberedValue = composer.rememberedValue();
        int i12 = 0;
        if (i2 |= i == 0) {
            if (rememberedValue == Composer.Companion.getEmpty()) {
                empty = 0;
                pagerBeyondBoundsState = new PagerBeyondBoundsState(state, beyondViewportPageCount);
                composer.updateRememberedValue(pagerBeyondBoundsState);
            } else {
                pagerBeyondBoundsState = rememberedValue;
            }
        } else {
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return (LazyLayoutBeyondBoundsState)(PagerBeyondBoundsState)pagerBeyondBoundsState;
    }
}
