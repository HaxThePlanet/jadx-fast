package androidx.compose.material;

import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsetsKt;
import androidx.compose.foundation.layout.WindowInsetsSides;
import androidx.compose.foundation.layout.WindowInsetsSides.Companion;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0005\u0008Ç\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u0019\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\u0008\u0005\u0010\u0006R\u0011\u0010\u0008\u001a\u00020\t¢\u0006\u0008\n\u0000\u001a\u0004\u0008\n\u0010\u000bR\u0019\u0010\u000c\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\u0008\r\u0010\u0006R\u0011\u0010\u000e\u001a\u00020\u000f8G¢\u0006\u0006\u001a\u0004\u0008\u0010\u0010\u0011R\u0011\u0010\u0012\u001a\u00020\u000f8G¢\u0006\u0006\u001a\u0004\u0008\u0013\u0010\u0011\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006\u0014", d2 = {"Landroidx/compose/material/AppBarDefaults;", "", "()V", "BottomAppBarElevation", "Landroidx/compose/ui/unit/Dp;", "getBottomAppBarElevation-D9Ej5fM", "()F", "F", "ContentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "getContentPadding", "()Landroidx/compose/foundation/layout/PaddingValues;", "TopAppBarElevation", "getTopAppBarElevation-D9Ej5fM", "bottomAppBarWindowInsets", "Landroidx/compose/foundation/layout/WindowInsets;", "getBottomAppBarWindowInsets", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/layout/WindowInsets;", "topAppBarWindowInsets", "getTopAppBarWindowInsets", "material_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class AppBarDefaults {

    public static final int $stable;
    private static final float BottomAppBarElevation;
    private static final PaddingValues ContentPadding;
    public static final androidx.compose.material.AppBarDefaults INSTANCE;
    private static final float TopAppBarElevation;
    static {
        AppBarDefaults appBarDefaults = new AppBarDefaults();
        AppBarDefaults.INSTANCE = appBarDefaults;
        int i3 = 0;
        AppBarDefaults.TopAppBarElevation = Dp.constructor-impl((float)i);
        int i4 = 0;
        AppBarDefaults.BottomAppBarElevation = Dp.constructor-impl((float)i2);
        AppBarDefaults.ContentPadding = PaddingKt.PaddingValues-a9UjIt4$default(AppBarKt.access$getAppBarHorizontalPadding$p(), 0, AppBarKt.access$getAppBarHorizontalPadding$p(), 0, 10, 0);
    }

    public final float getBottomAppBarElevation-D9Ej5fM() {
        return AppBarDefaults.BottomAppBarElevation;
    }

    public final WindowInsets getBottomAppBarWindowInsets(Composer $composer, int $changed) {
        boolean traceInProgress;
        String str;
        int i = 1469837023;
        ComposerKt.sourceInformationMarkerStart($composer, i, "C466@20324L29:AppBar.kt#jmzs0o");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i, $changed, -1, "androidx.compose.material.AppBarDefaults.<get-bottomAppBarWindowInsets> (AppBar.kt:465)");
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return WindowInsetsKt.only-bOOhFvg(SystemBarsDefaultInsets_androidKt.getSystemBarsForVisualComponents(WindowInsets.Companion, $composer, 6), WindowInsetsSides.plus-gK_yJZ4(WindowInsetsSides.Companion.getHorizontal-JoeWqyM(), WindowInsetsSides.Companion.getBottom-JoeWqyM()));
    }

    public final PaddingValues getContentPadding() {
        return AppBarDefaults.ContentPadding;
    }

    public final float getTopAppBarElevation-D9Ej5fM() {
        return AppBarDefaults.TopAppBarElevation;
    }

    public final WindowInsets getTopAppBarWindowInsets(Composer $composer, int $changed) {
        boolean traceInProgress;
        String str;
        int i = -427176825;
        ComposerKt.sourceInformationMarkerStart($composer, i, "C457@20017L29:AppBar.kt#jmzs0o");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i, $changed, -1, "androidx.compose.material.AppBarDefaults.<get-topAppBarWindowInsets> (AppBar.kt:457)");
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return WindowInsetsKt.only-bOOhFvg(SystemBarsDefaultInsets_androidKt.getSystemBarsForVisualComponents(WindowInsets.Companion, $composer, 6), WindowInsetsSides.plus-gK_yJZ4(WindowInsetsSides.Companion.getHorizontal-JoeWqyM(), WindowInsetsSides.Companion.getTop-JoeWqyM()));
    }
}
