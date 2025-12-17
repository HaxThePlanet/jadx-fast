package androidx.compose.foundation.pager;

import androidx.compose.foundation.lazy.layout.LazyLayoutSemanticState;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Composer.Companion;
import androidx.compose.runtime.ComposerKt;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0002\u001a\u001d\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0001¢\u0006\u0002\u0010\u0006¨\u0006\u0007", d2 = {"rememberPagerSemanticState", "Landroidx/compose/foundation/lazy/layout/LazyLayoutSemanticState;", "state", "Landroidx/compose/foundation/pager/PagerState;", "isVertical", "", "(Landroidx/compose/foundation/pager/PagerState;ZLandroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/lazy/layout/LazyLayoutSemanticState;", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class PagerSemanticsKt {
    public static final LazyLayoutSemanticState rememberPagerSemanticState(androidx.compose.foundation.pager.PagerState state, boolean isVertical, Composer $composer, int $changed) {
        int changed;
        int i;
        boolean traceInProgress;
        int i2;
        String str;
        int changed2;
        Object empty;
        Object $i$a$CachePagerSemanticsKt$rememberPagerSemanticState$1;
        int i3 = -786344289;
        ComposerKt.sourceInformationMarkerStart($composer, i3, "C(rememberPagerSemanticState)P(1)27@956L86:PagerSemantics.kt#g6yjnt");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i3, $changed, -1, "androidx.compose.foundation.pager.rememberPagerSemanticState (PagerSemantics.kt:26)");
        }
        ComposerKt.sourceInformationMarkerStart($composer, -502460112, "CC(remember):PagerSemantics.kt#9igjgp");
        int i7 = 1;
        int i9 = 4;
        if (i5 ^= 6 > i9) {
            if (!$composer.changed(state)) {
                i = $changed & 6 == i9 ? i7 : i2;
            } else {
            }
        } else {
        }
        int i11 = 32;
        if (i10 ^= 48 > i11) {
            if (!$composer.changed(isVertical)) {
                if ($changed & 48 == i11) {
                    i2 = i7;
                }
            } else {
            }
        } else {
        }
        Composer composer = $composer;
        int i8 = 0;
        Object rememberedValue = composer.rememberedValue();
        int i12 = 0;
        if (i |= i2 == 0) {
            if (rememberedValue == Composer.Companion.getEmpty()) {
                int i13 = 0;
                composer.updateRememberedValue(LazyLayoutSemanticStateKt.LazyLayoutSemanticState(state, isVertical));
            } else {
                $i$a$CachePagerSemanticsKt$rememberPagerSemanticState$1 = rememberedValue;
            }
        } else {
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return (LazyLayoutSemanticState)$i$a$CachePagerSemanticsKt$rememberPagerSemanticState$1;
    }
}
