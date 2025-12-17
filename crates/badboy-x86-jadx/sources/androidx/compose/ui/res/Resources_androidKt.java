package androidx.compose.ui.res;

import android.content.Context;
import android.content.res.Resources;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u001a\r\u0010\u0000\u001a\u00020\u0001H\u0001¢\u0006\u0002\u0010\u0002¨\u0006\u0003", d2 = {"resources", "Landroid/content/res/Resources;", "(Landroidx/compose/runtime/Composer;I)Landroid/content/res/Resources;", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class Resources_androidKt {
    public static final Resources resources(Composer $composer, int $changed) {
        boolean traceInProgress;
        String str;
        int i = 1554054999;
        ComposerKt.sourceInformationMarkerStart($composer, i, "C(resources)34@1219L7,35@1251L7:Resources.android.kt#ccshc7");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i, $changed, -1, "androidx.compose.ui.res.resources (Resources.android.kt:33)");
        }
        int i2 = 6;
        int i4 = 0;
        int i6 = 2023513938;
        final String str3 = "CC:CompositionLocal.kt#9igjgp";
        ComposerKt.sourceInformationMarkerStart($composer, i6, str3);
        $composer.consume((CompositionLocal)AndroidCompositionLocals_androidKt.getLocalConfiguration());
        ComposerKt.sourceInformationMarkerEnd($composer);
        int i3 = 6;
        int i5 = 0;
        ComposerKt.sourceInformationMarkerStart($composer, i6, str3);
        ComposerKt.sourceInformationMarkerEnd($composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return (Context)$composer.consume((CompositionLocal)AndroidCompositionLocals_androidKt.getLocalContext()).getResources();
    }
}
