package androidx.compose.material3;

import android.text.format.DateFormat;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0002\"\u0014\u0010\u0000\u001a\u00020\u00018AX\u0080\u0004¢\u0006\u0006\u001a\u0004\u0008\u0000\u0010\u0002¨\u0006\u0003", d2 = {"is24HourFormat", "", "(Landroidx/compose/runtime/Composer;I)Z", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class TimeFormat_androidKt {
    public static final boolean is24HourFormat(Composer $composer, int $changed) {
        boolean traceInProgress;
        String str;
        int i = -972868615;
        ComposerKt.sourceInformationMarkerStart($composer, i, "C24@966L7:TimeFormat.android.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i, $changed, -1, "androidx.compose.material3.<get-is24HourFormat> (TimeFormat.android.kt:24)");
        }
        int i2 = 0;
        int i3 = 0;
        ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        ComposerKt.sourceInformationMarkerEnd($composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return DateFormat.is24HourFormat((Context)$composer.consume((CompositionLocal)AndroidCompositionLocals_androidKt.getLocalContext()));
    }
}
