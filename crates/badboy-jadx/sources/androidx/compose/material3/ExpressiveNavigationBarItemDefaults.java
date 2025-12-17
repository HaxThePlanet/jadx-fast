package androidx.compose.material3;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.Color;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\u0008Á\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\r\u0010\u0008\u001a\u00020\u0004H\u0007¢\u0006\u0002\u0010\tR\u0018\u0010\u0003\u001a\u00020\u0004*\u00020\u00058@X\u0080\u0004¢\u0006\u0006\u001a\u0004\u0008\u0006\u0010\u0007¨\u0006\n", d2 = {"Landroidx/compose/material3/ExpressiveNavigationBarItemDefaults;", "", "()V", "defaultExpressiveNavigationBarItemColors", "Landroidx/compose/material3/NavigationItemColors;", "Landroidx/compose/material3/ColorScheme;", "getDefaultExpressiveNavigationBarItemColors$material3_release", "(Landroidx/compose/material3/ColorScheme;)Landroidx/compose/material3/NavigationItemColors;", "colors", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/material3/NavigationItemColors;", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ExpressiveNavigationBarItemDefaults {

    public static final int $stable;
    public static final androidx.compose.material3.ExpressiveNavigationBarItemDefaults INSTANCE;
    static {
        ExpressiveNavigationBarItemDefaults expressiveNavigationBarItemDefaults = new ExpressiveNavigationBarItemDefaults();
        ExpressiveNavigationBarItemDefaults.INSTANCE = expressiveNavigationBarItemDefaults;
    }

    public final androidx.compose.material3.NavigationItemColors colors(Composer $composer, int $changed) {
        boolean traceInProgress;
        String str;
        int i = 1959617551;
        ComposerKt.sourceInformationMarkerStart($composer, i, "C(colors)272@11438L11:ExpressiveNavigationBar.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i, $changed, -1, "androidx.compose.material3.ExpressiveNavigationBarItemDefaults.colors (ExpressiveNavigationBar.kt:272)");
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return getDefaultExpressiveNavigationBarItemColors$material3_release(MaterialTheme.INSTANCE.getColorScheme($composer, 6));
    }

    public final androidx.compose.material3.NavigationItemColors getDefaultExpressiveNavigationBarItemColors$material3_release(androidx.compose.material3.ColorScheme $this$defaultExpressiveNavigationBarItemColors) {
        androidx.compose.material3.NavigationItemColors defaultExpressiveNavigationBarItemColorsCached$material3_release;
        androidx.compose.material3.NavigationItemColors navigationItemColors;
        int i8;
        long token2;
        long token4;
        long token3;
        long token;
        long copy-wmQWz5c$default2;
        long copy-wmQWz5c$default;
        int i5;
        int i2;
        int i;
        int i3;
        int i4;
        int i7;
        int i6;
        final androidx.compose.material3.ColorScheme colorScheme = $this$defaultExpressiveNavigationBarItemColors;
        if (colorScheme.getDefaultExpressiveNavigationBarItemColorsCached$material3_release() == null) {
            i5 = 0;
            i = 0;
            navigationItemColors = new NavigationItemColors(ColorSchemeKt.fromToken(colorScheme, ExpressiveNavigationBarKt.access$getActiveIconColor$p()), obj4, ColorSchemeKt.fromToken(colorScheme, ExpressiveNavigationBarKt.access$getActiveLabelTextColor$p()), obj6, ColorSchemeKt.fromToken(colorScheme, ExpressiveNavigationBarKt.access$getActiveIndicatorColor$p()), obj8, ColorSchemeKt.fromToken(colorScheme, ExpressiveNavigationBarKt.access$getInactiveIconColor$p()), obj10, ColorSchemeKt.fromToken(colorScheme, ExpressiveNavigationBarKt.access$getInactiveLabelTextColor$p()), obj12, Color.copy-wmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, ExpressiveNavigationBarKt.access$getInactiveIconColor$p()), obj14, 1052938076, i5, 0, i, 14), obj14, Color.copy-wmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, ExpressiveNavigationBarKt.access$getInactiveLabelTextColor$p()), i5, 1052938076, i, 0, 0, 14), i5, 0);
            i8 = 0;
            colorScheme.setDefaultExpressiveNavigationBarItemColorsCached$material3_release(navigationItemColors);
        }
        return defaultExpressiveNavigationBarItemColorsCached$material3_release;
    }
}
