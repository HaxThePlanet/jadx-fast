package androidx.compose.material;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008Â\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\"\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\u0017ø\u0001\u0000¢\u0006\u0004\u0008\u0008\u0010\t\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006\n", d2 = {"Landroidx/compose/material/DefaultElevationOverlay;", "Landroidx/compose/material/ElevationOverlay;", "()V", "apply", "Landroidx/compose/ui/graphics/Color;", "color", "elevation", "Landroidx/compose/ui/unit/Dp;", "apply-7g2Lkgo", "(JFLandroidx/compose/runtime/Composer;I)J", "material_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class DefaultElevationOverlay implements androidx.compose.material.ElevationOverlay {

    public static final androidx.compose.material.DefaultElevationOverlay INSTANCE;
    static {
        DefaultElevationOverlay defaultElevationOverlay = new DefaultElevationOverlay();
        DefaultElevationOverlay.INSTANCE = defaultElevationOverlay;
    }

    @Override // androidx.compose.material.ElevationOverlay
    public long apply-7g2Lkgo(long color, float elevation, Composer $composer, int $changed) {
        boolean traceInProgress;
        long foregroundColor;
        int light;
        String str;
        int i;
        int i2 = -1687113661;
        $changed.startReplaceGroup(i2);
        ComposerKt.sourceInformation($changed, "C(apply)P(0:c#ui.graphics.Color,1:c#ui.unit.Dp)69@2742L6:ElevationOverlay.kt#jmzs0o");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i2, obj9, -1, "androidx.compose.material.DefaultElevationOverlay.apply (ElevationOverlay.kt:68)");
        }
        i = 0;
        if (Dp.compareTo-0680j_4($composer, Dp.constructor-impl((float)i4)) > 0 && !MaterialTheme.INSTANCE.getColors($changed, 6).isLight()) {
            if (!colors.isLight()) {
                $changed.startReplaceGroup(1169013963);
                ComposerKt.sourceInformation($changed, "71@2841L42");
                i = obj9 & 112;
                foregroundColor = ColorKt.compositeOver--OWjLjI(ElevationOverlayKt.access$calculateForegroundColor-CLU3JFs(color, elevation, $composer, $changed), i);
                $changed.endReplaceGroup();
            } else {
                $changed.startReplaceGroup(1169152471);
                $changed.endReplaceGroup();
                foregroundColor = color;
            }
        } else {
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $changed.endReplaceGroup();
        return foregroundColor;
    }
}
