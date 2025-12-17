package androidx.compose.material3;

import androidx.compose.material.ripple.RippleAlpha;
import androidx.compose.material.ripple.RippleTheme;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.Color;
import kotlin.Deprecated;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008Á\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u0015\u0010\u0003\u001a\u00020\u0004H\u0017ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\u0008\u0005\u0010\u0006J\r\u0010\u0007\u001a\u00020\u0008H\u0017¢\u0006\u0002\u0010\t\u0082\u0002\u000b\n\u0002\u0008!\n\u0005\u0008¡\u001e0\u0001¨\u0006\n", d2 = {"Landroidx/compose/material3/CompatRippleTheme;", "Landroidx/compose/material/ripple/RippleTheme;", "()V", "defaultColor", "Landroidx/compose/ui/graphics/Color;", "defaultColor-WaAFU9c", "(Landroidx/compose/runtime/Composer;I)J", "rippleAlpha", "Landroidx/compose/material/ripple/RippleAlpha;", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/material/ripple/RippleAlpha;", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class CompatRippleTheme implements RippleTheme {

    public static final int $stable;
    public static final androidx.compose.material3.CompatRippleTheme INSTANCE;
    static {
        CompatRippleTheme compatRippleTheme = new CompatRippleTheme();
        CompatRippleTheme.INSTANCE = compatRippleTheme;
    }

    @Deprecated(message = "Super method is deprecated")
    public long defaultColor-WaAFU9c(Composer $composer, int $changed) {
        boolean traceInProgress;
        String str;
        int i = -1844533201;
        $composer.startReplaceGroup(i);
        ComposerKt.sourceInformation($composer, "C(defaultColor)244@11142L7:Ripple.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i, $changed, -1, "androidx.compose.material3.CompatRippleTheme.defaultColor (Ripple.kt:244)");
        }
        int i2 = 6;
        int i3 = 0;
        ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        ComposerKt.sourceInformationMarkerEnd($composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceGroup();
        return (Color)$composer.consume((CompositionLocal)ContentColorKt.getLocalContentColor()).unbox-impl();
    }

    @Deprecated(message = "Super method is deprecated")
    public RippleAlpha rippleAlpha(Composer $composer, int $changed) {
        boolean traceInProgress;
        String str;
        int i = -290975286;
        $composer.startReplaceGroup(i);
        ComposerKt.sourceInformation($composer, "C(rippleAlpha):Ripple.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i, $changed, -1, "androidx.compose.material3.CompatRippleTheme.rippleAlpha (Ripple.kt:248)");
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceGroup();
        return RippleDefaults.INSTANCE.getRippleAlpha();
    }
}
