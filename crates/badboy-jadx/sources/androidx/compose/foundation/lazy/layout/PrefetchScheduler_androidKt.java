package androidx.compose.foundation.lazy.layout;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Composer.Companion;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u001a\r\u0010\u0000\u001a\u00020\u0001H\u0001¢\u0006\u0002\u0010\u0002¨\u0006\u0003", d2 = {"rememberDefaultPrefetchScheduler", "Landroidx/compose/foundation/lazy/layout/PrefetchScheduler;", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/lazy/layout/PrefetchScheduler;", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class PrefetchScheduler_androidKt {
    public static final androidx.compose.foundation.lazy.layout.PrefetchScheduler rememberDefaultPrefetchScheduler(Composer $composer, int $changed) {
        boolean traceInProgress;
        String str;
        Object empty;
        Object androidPrefetchScheduler;
        int i = 1141871251;
        ComposerKt.sourceInformationMarkerStart($composer, i, "C(rememberDefaultPrefetchScheduler)32@1216L7,33@1235L61:PrefetchScheduler.android.kt#wow0x6");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i, $changed, -1, "androidx.compose.foundation.lazy.layout.rememberDefaultPrefetchScheduler (PrefetchScheduler.android.kt:31)");
        }
        int i2 = 0;
        int i4 = 0;
        ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        ComposerKt.sourceInformationMarkerEnd($composer);
        Object this_$iv = consume;
        ComposerKt.sourceInformationMarkerStart($composer, -930674095, "CC(remember):PrefetchScheduler.android.kt#9igjgp");
        Composer composer = $composer;
        int i6 = 0;
        Object rememberedValue = composer.rememberedValue();
        final int i7 = 0;
        if (!$composer.changed((View)this_$iv)) {
            if (rememberedValue == Composer.Companion.getEmpty()) {
                empty = 0;
                androidPrefetchScheduler = new AndroidPrefetchScheduler(this_$iv);
                composer.updateRememberedValue(androidPrefetchScheduler);
            } else {
                androidPrefetchScheduler = rememberedValue;
            }
        } else {
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return (PrefetchScheduler)(AndroidPrefetchScheduler)androidPrefetchScheduler;
    }
}
