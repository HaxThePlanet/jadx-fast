package androidx.compose.foundation;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Composer.Companion;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u001a\r\u0010\u0000\u001a\u00020\u0001H\u0001¢\u0006\u0002\u0010\u0002¨\u0006\u0003", d2 = {"rememberOverscrollEffect", "Landroidx/compose/foundation/OverscrollEffect;", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/OverscrollEffect;", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class AndroidOverscroll_androidKt {
    public static final androidx.compose.foundation.OverscrollEffect rememberOverscrollEffect(Composer $composer, int $changed) {
        boolean traceInProgress;
        String str2;
        int iNSTANCE;
        Object consume;
        int str;
        Object rememberedValue;
        int i;
        Object empty;
        Object androidEdgeEffectOverscrollEffect;
        int i2 = -1476348564;
        ComposerKt.sourceInformationMarkerStart($composer, i2, "C(rememberOverscrollEffect)64@2834L7,65@2888L7:AndroidOverscroll.android.kt#71ulvw");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i2, $changed, -1, "androidx.compose.foundation.rememberOverscrollEffect (AndroidOverscroll.android.kt:63)");
        }
        int i3 = 0;
        int i4 = 0;
        int i9 = 2023513938;
        str = "CC:CompositionLocal.kt#9igjgp";
        ComposerKt.sourceInformationMarkerStart($composer, i9, str);
        ComposerKt.sourceInformationMarkerEnd($composer);
        Object this_$iv = consume2;
        int i5 = 6;
        rememberedValue = 0;
        ComposerKt.sourceInformationMarkerStart($composer, i9, str);
        ComposerKt.sourceInformationMarkerEnd($composer);
        Object this_$iv2 = consume;
        if ((OverscrollConfiguration)this_$iv2 != null) {
            $composer.startReplaceGroup(1586021609);
            ComposerKt.sourceInformation($composer, "67@2937L80");
            ComposerKt.sourceInformationMarkerStart($composer, 1852277609, "CC(remember):AndroidOverscroll.android.kt#9igjgp");
            consume = $composer;
            str = 0;
            rememberedValue = consume.rememberedValue();
            i = 0;
            if (changed |= changed2 == 0) {
                if (rememberedValue == Composer.Companion.getEmpty()) {
                    empty = 0;
                    androidEdgeEffectOverscrollEffect = new AndroidEdgeEffectOverscrollEffect(this_$iv, this_$iv2);
                    consume.updateRememberedValue(androidEdgeEffectOverscrollEffect);
                } else {
                    androidEdgeEffectOverscrollEffect = rememberedValue;
                }
            } else {
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            $composer.endReplaceGroup();
        } else {
            $composer.startReplaceGroup(1586120933);
            $composer.endReplaceGroup();
            androidEdgeEffectOverscrollEffect = iNSTANCE;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return androidEdgeEffectOverscrollEffect;
    }
}
