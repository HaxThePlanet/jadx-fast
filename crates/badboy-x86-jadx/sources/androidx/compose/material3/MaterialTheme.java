package androidx.compose.material3;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008Ç\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u00048G¢\u0006\u0006\u001a\u0004\u0008\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\u00088G¢\u0006\u0006\u001a\u0004\u0008\t\u0010\nR\u0011\u0010\u000b\u001a\u00020\u000c8G¢\u0006\u0006\u001a\u0004\u0008\r\u0010\u000e¨\u0006\u000f", d2 = {"Landroidx/compose/material3/MaterialTheme;", "", "()V", "colorScheme", "Landroidx/compose/material3/ColorScheme;", "getColorScheme", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/material3/ColorScheme;", "shapes", "Landroidx/compose/material3/Shapes;", "getShapes", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/material3/Shapes;", "typography", "Landroidx/compose/material3/Typography;", "getTypography", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/material3/Typography;", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class MaterialTheme {

    public static final int $stable;
    public static final androidx.compose.material3.MaterialTheme INSTANCE;
    static {
        MaterialTheme materialTheme = new MaterialTheme();
        MaterialTheme.INSTANCE = materialTheme;
    }

    public final androidx.compose.material3.ColorScheme getColorScheme(Composer $composer, int $changed) {
        boolean traceInProgress;
        String str;
        int i = -561618718;
        ComposerKt.sourceInformationMarkerStart($composer, i, "C83@3609L7:MaterialTheme.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i, $changed, -1, "androidx.compose.material3.MaterialTheme.<get-colorScheme> (MaterialTheme.kt:83)");
        }
        int i2 = 6;
        int i3 = 0;
        ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        ComposerKt.sourceInformationMarkerEnd($composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return (ColorScheme)$composer.consume((CompositionLocal)ColorSchemeKt.getLocalColorScheme());
    }

    public final androidx.compose.material3.Shapes getShapes(Composer $composer, int $changed) {
        boolean traceInProgress;
        String str;
        int i = 419509830;
        ComposerKt.sourceInformationMarkerStart($composer, i, "C99@4161L7:MaterialTheme.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i, $changed, -1, "androidx.compose.material3.MaterialTheme.<get-shapes> (MaterialTheme.kt:99)");
        }
        int i2 = 6;
        int i3 = 0;
        ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        ComposerKt.sourceInformationMarkerEnd($composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return (Shapes)$composer.consume((CompositionLocal)ShapesKt.getLocalShapes());
    }

    public final androidx.compose.material3.Typography getTypography(Composer $composer, int $changed) {
        boolean traceInProgress;
        String str;
        int i = -942794935;
        ComposerKt.sourceInformationMarkerStart($composer, i, "C91@3895L7:MaterialTheme.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i, $changed, -1, "androidx.compose.material3.MaterialTheme.<get-typography> (MaterialTheme.kt:91)");
        }
        int i2 = 6;
        int i3 = 0;
        ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        ComposerKt.sourceInformationMarkerEnd($composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return (Typography)$composer.consume((CompositionLocal)TypographyKt.getLocalTypography());
    }
}
