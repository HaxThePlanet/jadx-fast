package androidx.compose.ui.res;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0002\u001a\u0017\u0010\u0000\u001a\u00020\u00012\u0008\u0008\u0001\u0010\u0002\u001a\u00020\u0003H\u0007¢\u0006\u0002\u0010\u0004¨\u0006\u0005", d2 = {"colorResource", "Landroidx/compose/ui/graphics/Color;", "id", "", "(ILandroidx/compose/runtime/Composer;I)J", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class ColorResources_androidKt {
    public static final long colorResource(int id, Composer $composer, int $changed) {
        boolean traceInProgress;
        String str;
        int i = -1777644873;
        ComposerKt.sourceInformationMarkerStart($composer, i, "C(colorResource)37@1238L7:ColorResources.android.kt#ccshc7");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i, $changed, -1, "androidx.compose.ui.res.colorResource (ColorResources.android.kt:36)");
        }
        int i2 = 6;
        int i3 = 0;
        ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        ComposerKt.sourceInformationMarkerEnd($composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return ColorResourceHelper.INSTANCE.getColor-WaAFU9c((Context)$composer.consume((CompositionLocal)AndroidCompositionLocals_androidKt.getLocalContext()), id);
    }
}
