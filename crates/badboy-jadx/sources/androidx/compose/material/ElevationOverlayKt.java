package androidx.compose.material;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\u001a\"\u0010\u0008\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u0002H\u0003ø\u0001\u0000¢\u0006\u0004\u0008\u000c\u0010\r\"\u0017\u0010\u0000\u001a\u0008\u0012\u0004\u0012\u00020\u00020\u0001¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0003\u0010\u0004\"\u0019\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0001¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0007\u0010\u0004\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006\u000e", d2 = {"LocalAbsoluteElevation", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "Landroidx/compose/ui/unit/Dp;", "getLocalAbsoluteElevation", "()Landroidx/compose/runtime/ProvidableCompositionLocal;", "LocalElevationOverlay", "Landroidx/compose/material/ElevationOverlay;", "getLocalElevationOverlay", "calculateForegroundColor", "Landroidx/compose/ui/graphics/Color;", "backgroundColor", "elevation", "calculateForegroundColor-CLU3JFs", "(JFLandroidx/compose/runtime/Composer;I)J", "material_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class ElevationOverlayKt {

    private static final ProvidableCompositionLocal<Dp> LocalAbsoluteElevation;
    private static final ProvidableCompositionLocal<androidx.compose.material.ElevationOverlay> LocalElevationOverlay;
    static {
        ElevationOverlayKt.LocalElevationOverlay = CompositionLocalKt.staticCompositionLocalOf((Function0)ElevationOverlayKt.LocalElevationOverlay.1.INSTANCE);
        final int i2 = 0;
        ElevationOverlayKt.LocalAbsoluteElevation = CompositionLocalKt.compositionLocalOf$default(i2, (Function0)ElevationOverlayKt.LocalAbsoluteElevation.1.INSTANCE, 1, i2);
    }

    public static final long access$calculateForegroundColor-CLU3JFs(long backgroundColor, float elevation, Composer $composer, int $changed) {
        return ElevationOverlayKt.calculateForegroundColor-CLU3JFs(backgroundColor, elevation, $composer, $changed);
    }

    private static final long calculateForegroundColor-CLU3JFs(long backgroundColor, float elevation, Composer $composer, int $changed) {
        boolean traceInProgress;
        String str;
        int i = 1613340891;
        ComposerKt.sourceInformationMarkerStart($changed, i, "C(calculateForegroundColor)P(0:c#ui.graphics.Color,1:c#ui.unit.Dp)88@3446L32:ElevationOverlay.kt#jmzs0o");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i, obj14, -1, "androidx.compose.material.calculateForegroundColor (ElevationOverlay.kt:86)");
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($changed);
        return Color.copy-wmQWz5c$default(ColorsKt.contentColorFor-ek8zF_U(backgroundColor, elevation, $changed), obj3, i5 / i9, 0, 0, 0, 14);
    }

    public static final ProvidableCompositionLocal<Dp> getLocalAbsoluteElevation() {
        return ElevationOverlayKt.LocalAbsoluteElevation;
    }

    public static final ProvidableCompositionLocal<androidx.compose.material.ElevationOverlay> getLocalElevationOverlay() {
        return ElevationOverlayKt.LocalElevationOverlay;
    }
}
