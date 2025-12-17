package androidx.compose.material;

import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsetsKt;
import androidx.compose.foundation.layout.WindowInsetsSides;
import androidx.compose.foundation.layout.WindowInsetsSides.Companion;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008Ç\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u0019\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\u0008\u0005\u0010\u0006R\u0011\u0010\u0008\u001a\u00020\t8G¢\u0006\u0006\u001a\u0004\u0008\n\u0010\u000b\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006\u000c", d2 = {"Landroidx/compose/material/BottomNavigationDefaults;", "", "()V", "Elevation", "Landroidx/compose/ui/unit/Dp;", "getElevation-D9Ej5fM", "()F", "F", "windowInsets", "Landroidx/compose/foundation/layout/WindowInsets;", "getWindowInsets", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/layout/WindowInsets;", "material_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class BottomNavigationDefaults {

    public static final int $stable;
    private static final float Elevation;
    public static final androidx.compose.material.BottomNavigationDefaults INSTANCE;
    static {
        BottomNavigationDefaults bottomNavigationDefaults = new BottomNavigationDefaults();
        BottomNavigationDefaults.INSTANCE = bottomNavigationDefaults;
        final int i2 = 0;
        BottomNavigationDefaults.Elevation = Dp.constructor-impl((float)i);
    }

    public final float getElevation-D9Ej5fM() {
        return BottomNavigationDefaults.Elevation;
    }

    public final WindowInsets getWindowInsets(Composer $composer, int $changed) {
        boolean traceInProgress;
        String str;
        int i = 1427252235;
        ComposerKt.sourceInformationMarkerStart($composer, i, "C263@11301L29:BottomNavigation.kt#jmzs0o");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i, $changed, -1, "androidx.compose.material.BottomNavigationDefaults.<get-windowInsets> (BottomNavigation.kt:263)");
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return WindowInsetsKt.only-bOOhFvg(SystemBarsDefaultInsets_androidKt.getSystemBarsForVisualComponents(WindowInsets.Companion, $composer, 6), WindowInsetsSides.plus-gK_yJZ4(WindowInsetsSides.Companion.getHorizontal-JoeWqyM(), WindowInsetsSides.Companion.getBottom-JoeWqyM()));
    }
}
