package androidx.compose.material3;

import androidx.compose.material3.tokens.SnackbarTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.Shape;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u000b\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008Ç\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u0017\u0010\u0003\u001a\u00020\u00048Gø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\u0008\u0005\u0010\u0006R\u0017\u0010\u0007\u001a\u00020\u00048Gø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\u0008\u0008\u0010\u0006R\u0017\u0010\t\u001a\u00020\u00048Gø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\u0008\n\u0010\u0006R\u0017\u0010\u000b\u001a\u00020\u00048Gø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\u0008\u000c\u0010\u0006R\u0017\u0010\r\u001a\u00020\u00048Gø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\u0008\u000e\u0010\u0006R\u0011\u0010\u000f\u001a\u00020\u00108G¢\u0006\u0006\u001a\u0004\u0008\u0011\u0010\u0012\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006\u0013", d2 = {"Landroidx/compose/material3/SnackbarDefaults;", "", "()V", "actionColor", "Landroidx/compose/ui/graphics/Color;", "getActionColor", "(Landroidx/compose/runtime/Composer;I)J", "actionContentColor", "getActionContentColor", "color", "getColor", "contentColor", "getContentColor", "dismissActionContentColor", "getDismissActionContentColor", "shape", "Landroidx/compose/ui/graphics/Shape;", "getShape", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/graphics/Shape;", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class SnackbarDefaults {

    public static final int $stable;
    public static final androidx.compose.material3.SnackbarDefaults INSTANCE;
    static {
        SnackbarDefaults snackbarDefaults = new SnackbarDefaults();
        SnackbarDefaults.INSTANCE = snackbarDefaults;
    }

    public final long getActionColor(Composer $composer, int $changed) {
        boolean traceInProgress;
        String str;
        int i = 743425465;
        ComposerKt.sourceInformationMarkerStart($composer, i, "C430@18431L5:Snackbar.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i, $changed, -1, "androidx.compose.material3.SnackbarDefaults.<get-actionColor> (Snackbar.kt:430)");
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return ColorSchemeKt.getValue(SnackbarTokens.INSTANCE.getActionLabelTextColor(), $composer, 6);
    }

    public final long getActionContentColor(Composer $composer, int $changed) {
        boolean traceInProgress;
        String str;
        int i = -1313141593;
        ComposerKt.sourceInformationMarkerStart($composer, i, "C434@18591L5:Snackbar.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i, $changed, -1, "androidx.compose.material3.SnackbarDefaults.<get-actionContentColor> (Snackbar.kt:434)");
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return ColorSchemeKt.getValue(SnackbarTokens.INSTANCE.getActionLabelTextColor(), $composer, 6);
    }

    public final long getColor(Composer $composer, int $changed) {
        boolean traceInProgress;
        String str;
        int i = 987938253;
        ComposerKt.sourceInformationMarkerStart($composer, i, "C422@18140L5:Snackbar.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i, $changed, -1, "androidx.compose.material3.SnackbarDefaults.<get-color> (Snackbar.kt:422)");
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return ColorSchemeKt.getValue(SnackbarTokens.INSTANCE.getContainerColor(), $composer, 6);
    }

    public final long getContentColor(Composer $composer, int $changed) {
        boolean traceInProgress;
        String str;
        int i = 1021310823;
        ComposerKt.sourceInformationMarkerStart($composer, i, "C426@18286L5:Snackbar.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i, $changed, -1, "androidx.compose.material3.SnackbarDefaults.<get-contentColor> (Snackbar.kt:426)");
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return ColorSchemeKt.getValue(SnackbarTokens.INSTANCE.getSupportingTextColor(), $composer, 6);
    }

    public final long getDismissActionContentColor(Composer $composer, int $changed) {
        boolean traceInProgress;
        String str;
        int i = -528602817;
        ComposerKt.sourceInformationMarkerStart($composer, i, "C438@18755L5:Snackbar.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i, $changed, -1, "androidx.compose.material3.SnackbarDefaults.<get-dismissActionContentColor> (Snackbar.kt:438)");
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return ColorSchemeKt.getValue(SnackbarTokens.INSTANCE.getIconColor(), $composer, 6);
    }

    public final Shape getShape(Composer $composer, int $changed) {
        boolean traceInProgress;
        String str;
        int i = -551629101;
        ComposerKt.sourceInformationMarkerStart($composer, i, "C418@18014L5:Snackbar.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i, $changed, -1, "androidx.compose.material3.SnackbarDefaults.<get-shape> (Snackbar.kt:418)");
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return ShapesKt.getValue(SnackbarTokens.INSTANCE.getContainerShape(), $composer, 6);
    }
}
