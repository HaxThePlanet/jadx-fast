package androidx.compose.foundation.lazy;

import androidx.compose.foundation.lazy.layout.LazyLayoutSemanticState;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Composer.Companion;
import androidx.compose.runtime.ComposerKt;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0002\u001a\u001d\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0001¢\u0006\u0002\u0010\u0006¨\u0006\u0007", d2 = {"rememberLazyListSemanticState", "Landroidx/compose/foundation/lazy/layout/LazyLayoutSemanticState;", "state", "Landroidx/compose/foundation/lazy/LazyListState;", "isVertical", "", "(Landroidx/compose/foundation/lazy/LazyListState;ZLandroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/lazy/layout/LazyLayoutSemanticState;", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class LazyListSemanticsKt {
    public static final LazyLayoutSemanticState rememberLazyListSemanticState(androidx.compose.foundation.lazy.LazyListState state, boolean isVertical, Composer $composer, int $changed) {
        int changed2;
        int i;
        boolean traceInProgress;
        int i2;
        String str;
        int changed;
        Object empty;
        Object $i$a$CacheLazyListSemanticsKt$rememberLazyListSemanticState$1;
        int i3 = 596174919;
        ComposerKt.sourceInformationMarkerStart($composer, i3, "C(rememberLazyListSemanticState)P(1)27@961L107:LazyListSemantics.kt#428nma");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i3, $changed, -1, "androidx.compose.foundation.lazy.rememberLazyListSemanticState (LazyListSemantics.kt:26)");
        }
        ComposerKt.sourceInformationMarkerStart($composer, 43267287, "CC(remember):LazyListSemantics.kt#9igjgp");
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
                $i$a$CacheLazyListSemanticsKt$rememberLazyListSemanticState$1 = rememberedValue;
            }
        } else {
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return (LazyLayoutSemanticState)$i$a$CacheLazyListSemanticsKt$rememberLazyListSemanticState$1;
    }
}
