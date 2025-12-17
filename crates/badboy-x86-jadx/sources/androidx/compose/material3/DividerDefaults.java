package androidx.compose.material3;

import androidx.compose.material3.tokens.DividerTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008Ç\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u0019\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\u0008\u0005\u0010\u0006R\u0017\u0010\u0008\u001a\u00020\t8Gø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\u0008\n\u0010\u000b\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006\u000c", d2 = {"Landroidx/compose/material3/DividerDefaults;", "", "()V", "Thickness", "Landroidx/compose/ui/unit/Dp;", "getThickness-D9Ej5fM", "()F", "F", "color", "Landroidx/compose/ui/graphics/Color;", "getColor", "(Landroidx/compose/runtime/Composer;I)J", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class DividerDefaults {

    public static final int $stable;
    public static final androidx.compose.material3.DividerDefaults INSTANCE;
    private static final float Thickness;
    static {
        DividerDefaults dividerDefaults = new DividerDefaults();
        DividerDefaults.INSTANCE = dividerDefaults;
        DividerDefaults.Thickness = DividerTokens.INSTANCE.getThickness-D9Ej5fM();
    }

    public final long getColor(Composer $composer, int $changed) {
        boolean traceInProgress;
        String str;
        int i = 77461041;
        ComposerKt.sourceInformationMarkerStart($composer, i, "C118@4183L5:Divider.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i, $changed, -1, "androidx.compose.material3.DividerDefaults.<get-color> (Divider.kt:118)");
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return ColorSchemeKt.getValue(DividerTokens.INSTANCE.getColor(), $composer, 6);
    }

    public final float getThickness-D9Ej5fM() {
        return DividerDefaults.Thickness;
    }
}
