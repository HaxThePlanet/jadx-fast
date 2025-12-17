package androidx.compose.material;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\u0008Ç\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0017\u0010\u0005\u001a\u00020\u00068Gø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\u0008\u0007\u0010\u0008R\u0017\u0010\t\u001a\u00020\u00068Gø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\u0008\n\u0010\u0008\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006\u000b", d2 = {"Landroidx/compose/material/SnackbarDefaults;", "", "()V", "SnackbarOverlayAlpha", "", "backgroundColor", "Landroidx/compose/ui/graphics/Color;", "getBackgroundColor", "(Landroidx/compose/runtime/Composer;I)J", "primaryActionColor", "getPrimaryActionColor", "material_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class SnackbarDefaults {

    public static final int $stable = 0;
    public static final androidx.compose.material.SnackbarDefaults INSTANCE = null;
    private static final float SnackbarOverlayAlpha = 0.8f;
    static {
        SnackbarDefaults snackbarDefaults = new SnackbarDefaults();
        SnackbarDefaults.INSTANCE = snackbarDefaults;
    }

    public final long getBackgroundColor(Composer $composer, int $changed) {
        boolean traceInProgress;
        String str;
        int i = 1630911716;
        ComposerKt.sourceInformationMarkerStart($composer, i, "C204@8614L6,206@8728L6:Snackbar.kt#jmzs0o");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i, $changed, -1, "androidx.compose.material.SnackbarDefaults.<get-backgroundColor> (Snackbar.kt:204)");
        }
        int i2 = 6;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return ColorKt.compositeOver--OWjLjI(Color.copy-wmQWz5c$default(MaterialTheme.INSTANCE.getColors($composer, i2).getOnSurface-0d7_KjU(), obj3, 1061997773, 0, 0, 0, 14), obj3);
    }

    public final long getPrimaryActionColor(Composer $composer, int $changed) {
        boolean traceInProgress;
        long primary;
        String str;
        long copy-wmQWz5c$default;
        int i6;
        int i3;
        int i2;
        int i5;
        int i;
        int i4;
        int i7 = -810329402;
        ComposerKt.sourceInformationMarkerStart($composer, i7, "C225@9676L6:Snackbar.kt#jmzs0o");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i7, $changed, -1, "androidx.compose.material.SnackbarDefaults.<get-primaryActionColor> (Snackbar.kt:224)");
        }
        androidx.compose.material.Colors colors = MaterialTheme.INSTANCE.getColors($composer, 6);
        if (colors.isLight()) {
            primary = ColorKt.compositeOver--OWjLjI(Color.copy-wmQWz5c$default(colors.getSurface-0d7_KjU(), obj4, 1058642330, 0, 0, 0, 14), obj4);
        } else {
            primary = colors.getPrimaryVariant-0d7_KjU();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return primary;
    }
}
