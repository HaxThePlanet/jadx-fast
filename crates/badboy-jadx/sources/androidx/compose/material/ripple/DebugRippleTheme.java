package androidx.compose.material.ripple;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Color.Companion;
import kotlin.Deprecated;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008Ã\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u0015\u0010\u0003\u001a\u00020\u0004H\u0017ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\u0008\u0005\u0010\u0006J\r\u0010\u0007\u001a\u00020\u0008H\u0017¢\u0006\u0002\u0010\t\u0082\u0002\u000b\n\u0002\u0008!\n\u0005\u0008¡\u001e0\u0001¨\u0006\n", d2 = {"Landroidx/compose/material/ripple/DebugRippleTheme;", "Landroidx/compose/material/ripple/RippleTheme;", "()V", "defaultColor", "Landroidx/compose/ui/graphics/Color;", "defaultColor-WaAFU9c", "(Landroidx/compose/runtime/Composer;I)J", "rippleAlpha", "Landroidx/compose/material/ripple/RippleAlpha;", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/material/ripple/RippleAlpha;", "material-ripple_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class DebugRippleTheme implements androidx.compose.material.ripple.RippleTheme {

    public static final androidx.compose.material.ripple.DebugRippleTheme INSTANCE;
    static {
        DebugRippleTheme debugRippleTheme = new DebugRippleTheme();
        DebugRippleTheme.INSTANCE = debugRippleTheme;
    }

    @Deprecated(message = "Super method is deprecated")
    public long defaultColor-WaAFU9c(Composer $composer, int $changed) {
        boolean traceInProgress;
        String str;
        int i = 2042140174;
        $composer.startReplaceGroup(i);
        ComposerKt.sourceInformation($composer, "C(defaultColor):RippleTheme.kt#vhb33q");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i, $changed, -1, "androidx.compose.material.ripple.DebugRippleTheme.defaultColor (RippleTheme.kt:239)");
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceGroup();
        return RippleTheme.Companion.defaultRippleColor-5vOe2sY(Color.Companion.getBlack-0d7_KjU(), str);
    }

    @Deprecated(message = "Super method is deprecated")
    public androidx.compose.material.ripple.RippleAlpha rippleAlpha(Composer $composer, int $changed) {
        boolean traceInProgress;
        String str;
        int i = -1629816343;
        $composer.startReplaceGroup(i);
        ComposerKt.sourceInformation($composer, "C(rippleAlpha):RippleTheme.kt#vhb33q");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i, $changed, -1, "androidx.compose.material.ripple.DebugRippleTheme.rippleAlpha (RippleTheme.kt:243)");
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceGroup();
        return RippleTheme.Companion.defaultRippleAlpha-DxMtmZc(Color.Companion.getBlack-0d7_KjU(), str);
    }
}
