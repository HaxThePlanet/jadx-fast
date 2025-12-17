package androidx.compose.material3;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\"\u001a\u0010\u0000\u001a\u00020\u00018AX\u0080\u0004¢\u0006\u000c\u0012\u0004\u0008\u0002\u0010\u0003\u001a\u0004\u0008\u0004\u0010\u0005¨\u0006\u0006", d2 = {"defaultTimePickerLayoutType", "Landroidx/compose/material3/TimePickerLayoutType;", "getDefaultTimePickerLayoutType$annotations", "()V", "getDefaultTimePickerLayoutType", "(Landroidx/compose/runtime/Composer;I)I", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class TimePicker_androidKt {
    public static final int getDefaultTimePickerLayoutType(Composer $composer, int $changed) {
        boolean traceInProgress;
        String str;
        int horizontal-QJTpgSE;
        int i = -1979410629;
        ComposerKt.sourceInformationMarkerStart($composer, i, "C*27@997L7:TimePicker.android.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i, $changed, -1, "androidx.compose.material3.<get-defaultTimePickerLayoutType> (TimePicker.android.kt:27)");
        }
        int i2 = 0;
        int i4 = 0;
        ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        ComposerKt.sourceInformationMarkerEnd($composer);
        Object this_$iv = consume;
        int i3 = 0;
        if (this_$iv.screenHeightDp < this_$iv.screenWidthDp) {
            horizontal-QJTpgSE = TimePickerLayoutType.Companion.getHorizontal-QJTpgSE();
        } else {
            horizontal-QJTpgSE = TimePickerLayoutType.Companion.getVertical-QJTpgSE();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return horizontal-QJTpgSE;
    }

    public static void getDefaultTimePickerLayoutType$annotations() {
    }
}
