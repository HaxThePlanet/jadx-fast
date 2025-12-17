package androidx.compose.ui.res;

import android.content.Context;
import android.content.res.Resources;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000 \n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0015\n\u0002\u0008\u0004\u001a\u0017\u0010\u0000\u001a\u00020\u00012\u0008\u0008\u0001\u0010\u0002\u001a\u00020\u0003H\u0007¢\u0006\u0002\u0010\u0004\u001a\u0017\u0010\u0005\u001a\u00020\u00062\u0008\u0008\u0001\u0010\u0002\u001a\u00020\u0003H\u0007¢\u0006\u0002\u0010\u0007\u001a\u0017\u0010\u0008\u001a\u00020\t2\u0008\u0008\u0001\u0010\u0002\u001a\u00020\u0003H\u0007¢\u0006\u0002\u0010\n\u001a\u0017\u0010\u000b\u001a\u00020\u00032\u0008\u0008\u0001\u0010\u0002\u001a\u00020\u0003H\u0007¢\u0006\u0002\u0010\u000c¨\u0006\r", d2 = {"booleanResource", "", "id", "", "(ILandroidx/compose/runtime/Composer;I)Z", "dimensionResource", "Landroidx/compose/ui/unit/Dp;", "(ILandroidx/compose/runtime/Composer;I)F", "integerArrayResource", "", "(ILandroidx/compose/runtime/Composer;I)[I", "integerResource", "(ILandroidx/compose/runtime/Composer;I)I", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class PrimitiveResources_androidKt {
    public static final boolean booleanResource(int id, Composer $composer, int $changed) {
        boolean traceInProgress;
        String str;
        int i = -432394447;
        ComposerKt.sourceInformationMarkerStart($composer, i, "C(booleanResource)63@1877L7:PrimitiveResources.android.kt#ccshc7");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i, $changed, -1, "androidx.compose.ui.res.booleanResource (PrimitiveResources.android.kt:62)");
        }
        int i2 = 6;
        int i3 = 0;
        ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        ComposerKt.sourceInformationMarkerEnd($composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return (Context)$composer.consume((CompositionLocal)AndroidCompositionLocals_androidKt.getLocalContext()).getResources().getBoolean(id);
    }

    public static final float dimensionResource(int id, Composer $composer, int $changed) {
        boolean traceInProgress;
        String str;
        int i = 804324951;
        ComposerKt.sourceInformationMarkerStart($composer, i, "C(dimensionResource)76@2180L7,77@2219L7:PrimitiveResources.android.kt#ccshc7");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i, $changed, -1, "androidx.compose.ui.res.dimensionResource (PrimitiveResources.android.kt:75)");
        }
        int i2 = 6;
        int i3 = 0;
        int i5 = 2023513938;
        String str3 = "CC:CompositionLocal.kt#9igjgp";
        ComposerKt.sourceInformationMarkerStart($composer, i5, str3);
        ComposerKt.sourceInformationMarkerEnd($composer);
        int i4 = 6;
        int i7 = 0;
        ComposerKt.sourceInformationMarkerStart($composer, i5, str3);
        ComposerKt.sourceInformationMarkerEnd($composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return Dp.constructor-impl(dimension / density);
    }

    public static final int[] integerArrayResource(int id, Composer $composer, int $changed) {
        boolean traceInProgress;
        String str;
        int i = -93991766;
        ComposerKt.sourceInformationMarkerStart($composer, i, "C(integerArrayResource)50@1581L7:PrimitiveResources.android.kt#ccshc7");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i, $changed, -1, "androidx.compose.ui.res.integerArrayResource (PrimitiveResources.android.kt:49)");
        }
        int i2 = 6;
        int i3 = 0;
        ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        ComposerKt.sourceInformationMarkerEnd($composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return (Context)$composer.consume((CompositionLocal)AndroidCompositionLocals_androidKt.getLocalContext()).getResources().getIntArray(id);
    }

    public static final int integerResource(int id, Composer $composer, int $changed) {
        boolean traceInProgress;
        String str;
        int i = 916701108;
        ComposerKt.sourceInformationMarkerStart($composer, i, "C(integerResource)37@1263L7:PrimitiveResources.android.kt#ccshc7");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i, $changed, -1, "androidx.compose.ui.res.integerResource (PrimitiveResources.android.kt:36)");
        }
        int i2 = 6;
        int i3 = 0;
        ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        ComposerKt.sourceInformationMarkerEnd($composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return (Context)$composer.consume((CompositionLocal)AndroidCompositionLocals_androidKt.getLocalContext()).getResources().getInteger(id);
    }
}
