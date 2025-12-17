package androidx.compose.material3;

import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsetsKt;
import androidx.compose.foundation.layout.WindowInsetsSides;
import androidx.compose.foundation.layout.WindowInsetsSides.Companion;
import androidx.compose.material3.internal.SystemBarsDefaultInsets_androidKt;
import androidx.compose.material3.tokens.ElevationTokens;
import androidx.compose.material3.tokens.NavigationDrawerTokens;
import androidx.compose.material3.tokens.ScrimTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\n\n\u0002\u0018\u0002\n\u0002\u0008\u0008\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008Ç\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u0019\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\u0008\u0005\u0010\u0006R\u0019\u0010\u0008\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\u0008\t\u0010\u0006R\u0019\u0010\n\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\u0008\u000b\u0010\u0006R\u0019\u0010\u000c\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\u0008\r\u0010\u0006R \u0010\u000e\u001a\u00020\u000f8GX\u0087\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u000c\u0012\u0004\u0008\u0010\u0010\u0002\u001a\u0004\u0008\u0011\u0010\u0012R\u0017\u0010\u0013\u001a\u00020\u000f8Gø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\u0008\u0014\u0010\u0012R\u0017\u0010\u0015\u001a\u00020\u000f8Gø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\u0008\u0016\u0010\u0012R\u0011\u0010\u0017\u001a\u00020\u00188G¢\u0006\u0006\u001a\u0004\u0008\u0019\u0010\u001aR\u0017\u0010\u001b\u001a\u00020\u000f8Gø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\u0008\u001c\u0010\u0012R\u0011\u0010\u001d\u001a\u00020\u001e8G¢\u0006\u0006\u001a\u0004\u0008\u001f\u0010 \u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006!", d2 = {"Landroidx/compose/material3/DrawerDefaults;", "", "()V", "DismissibleDrawerElevation", "Landroidx/compose/ui/unit/Dp;", "getDismissibleDrawerElevation-D9Ej5fM", "()F", "F", "MaximumDrawerWidth", "getMaximumDrawerWidth-D9Ej5fM", "ModalDrawerElevation", "getModalDrawerElevation-D9Ej5fM", "PermanentDrawerElevation", "getPermanentDrawerElevation-D9Ej5fM", "containerColor", "Landroidx/compose/ui/graphics/Color;", "getContainerColor$annotations", "getContainerColor", "(Landroidx/compose/runtime/Composer;I)J", "modalContainerColor", "getModalContainerColor", "scrimColor", "getScrimColor", "shape", "Landroidx/compose/ui/graphics/Shape;", "getShape", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/graphics/Shape;", "standardContainerColor", "getStandardContainerColor", "windowInsets", "Landroidx/compose/foundation/layout/WindowInsets;", "getWindowInsets", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/layout/WindowInsets;", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class DrawerDefaults {

    public static final int $stable;
    private static final float DismissibleDrawerElevation;
    public static final androidx.compose.material3.DrawerDefaults INSTANCE;
    private static final float MaximumDrawerWidth;
    private static final float ModalDrawerElevation;
    private static final float PermanentDrawerElevation;
    static {
        DrawerDefaults drawerDefaults = new DrawerDefaults();
        DrawerDefaults.INSTANCE = drawerDefaults;
        DrawerDefaults.ModalDrawerElevation = ElevationTokens.INSTANCE.getLevel0-D9Ej5fM();
        DrawerDefaults.PermanentDrawerElevation = NavigationDrawerTokens.INSTANCE.getStandardContainerElevation-D9Ej5fM();
        DrawerDefaults.DismissibleDrawerElevation = NavigationDrawerTokens.INSTANCE.getStandardContainerElevation-D9Ej5fM();
        DrawerDefaults.MaximumDrawerWidth = NavigationDrawerTokens.INSTANCE.getContainerWidth-D9Ej5fM();
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Please use standardContainerColor or modalContainerColor instead.", replaceWith = @ReplaceWith(...))
    public static void getContainerColor$annotations() {
    }

    public final long getContainerColor(Composer $composer, int $changed) {
        boolean traceInProgress;
        String str;
        int i = -1797317261;
        ComposerKt.sourceInformationMarkerStart($composer, i, "C872@36094L5:NavigationDrawer.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i, $changed, -1, "androidx.compose.material3.DrawerDefaults.<get-containerColor> (NavigationDrawer.kt:872)");
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return ColorSchemeKt.getValue(NavigationDrawerTokens.INSTANCE.getStandardContainerColor(), $composer, 6);
    }

    public final float getDismissibleDrawerElevation-D9Ej5fM() {
        return DrawerDefaults.DismissibleDrawerElevation;
    }

    public final float getMaximumDrawerWidth-D9Ej5fM() {
        return DrawerDefaults.MaximumDrawerWidth;
    }

    public final long getModalContainerColor(Composer $composer, int $changed) {
        boolean traceInProgress;
        String str;
        int i = 706424321;
        ComposerKt.sourceInformationMarkerStart($composer, i, "C882@36506L5:NavigationDrawer.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i, $changed, -1, "androidx.compose.material3.DrawerDefaults.<get-modalContainerColor> (NavigationDrawer.kt:882)");
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return ColorSchemeKt.getValue(NavigationDrawerTokens.INSTANCE.getModalContainerColor(), $composer, 6);
    }

    public final float getModalDrawerElevation-D9Ej5fM() {
        return DrawerDefaults.ModalDrawerElevation;
    }

    public final float getPermanentDrawerElevation-D9Ej5fM() {
        return DrawerDefaults.PermanentDrawerElevation;
    }

    public final long getScrimColor(Composer $composer, int $changed) {
        boolean traceInProgress;
        String str;
        int i = -1055074989;
        ComposerKt.sourceInformationMarkerStart($composer, i, "C863@35676L5:NavigationDrawer.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i, $changed, -1, "androidx.compose.material3.DrawerDefaults.<get-scrimColor> (NavigationDrawer.kt:863)");
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return Color.copy-wmQWz5c$default(ColorSchemeKt.getValue(ScrimTokens.INSTANCE.getContainerColor(), $composer, 6), obj3, 1050924810, 0, 0, 0, 14);
    }

    public final Shape getShape(Composer $composer, int $changed) {
        boolean traceInProgress;
        String str;
        int i = 928378975;
        ComposerKt.sourceInformationMarkerStart($composer, i, "C859@35504L5:NavigationDrawer.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i, $changed, -1, "androidx.compose.material3.DrawerDefaults.<get-shape> (NavigationDrawer.kt:859)");
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return ShapesKt.getValue(NavigationDrawerTokens.INSTANCE.getContainerShape(), $composer, 6);
    }

    public final long getStandardContainerColor(Composer $composer, int $changed) {
        boolean traceInProgress;
        String str;
        int i = -125949421;
        ComposerKt.sourceInformationMarkerStart($composer, i, "C878@36328L5:NavigationDrawer.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i, $changed, -1, "androidx.compose.material3.DrawerDefaults.<get-standardContainerColor> (NavigationDrawer.kt:878)");
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return ColorSchemeKt.getValue(NavigationDrawerTokens.INSTANCE.getStandardContainerColor(), $composer, 6);
    }

    public final WindowInsets getWindowInsets(Composer $composer, int $changed) {
        boolean traceInProgress;
        String str;
        int i = -909973510;
        ComposerKt.sourceInformationMarkerStart($composer, i, "C891@36788L29:NavigationDrawer.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i, $changed, -1, "androidx.compose.material3.DrawerDefaults.<get-windowInsets> (NavigationDrawer.kt:891)");
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return WindowInsetsKt.only-bOOhFvg(SystemBarsDefaultInsets_androidKt.getSystemBarsForVisualComponents(WindowInsets.Companion, $composer, 6), WindowInsetsSides.plus-gK_yJZ4(WindowInsetsSides.Companion.getVertical-JoeWqyM(), WindowInsetsSides.Companion.getStart-JoeWqyM()));
    }
}
