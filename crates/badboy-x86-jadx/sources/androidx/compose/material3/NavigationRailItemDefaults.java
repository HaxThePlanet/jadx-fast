package androidx.compose.material3;

import androidx.compose.material3.tokens.NavigationRailTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.Color;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u000b\u0008Ç\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\r\u0010\u0008\u001a\u00020\u0004H\u0007¢\u0006\u0002\u0010\tJD\u0010\u0008\u001a\u00020\u00042\u0008\u0008\u0002\u0010\n\u001a\u00020\u000b2\u0008\u0008\u0002\u0010\u000c\u001a\u00020\u000b2\u0008\u0008\u0002\u0010\r\u001a\u00020\u000b2\u0008\u0008\u0002\u0010\u000e\u001a\u00020\u000b2\u0008\u0008\u0002\u0010\u000f\u001a\u00020\u000bH\u0007ø\u0001\u0000¢\u0006\u0004\u0008\u0010\u0010\u0011JX\u0010\u0008\u001a\u00020\u00042\u0008\u0008\u0002\u0010\n\u001a\u00020\u000b2\u0008\u0008\u0002\u0010\u000c\u001a\u00020\u000b2\u0008\u0008\u0002\u0010\r\u001a\u00020\u000b2\u0008\u0008\u0002\u0010\u000e\u001a\u00020\u000b2\u0008\u0008\u0002\u0010\u000f\u001a\u00020\u000b2\u0008\u0008\u0002\u0010\u0012\u001a\u00020\u000b2\u0008\u0008\u0002\u0010\u0013\u001a\u00020\u000bH\u0007ø\u0001\u0000¢\u0006\u0004\u0008\u0014\u0010\u0015R\u0018\u0010\u0003\u001a\u00020\u0004*\u00020\u00058@X\u0080\u0004¢\u0006\u0006\u001a\u0004\u0008\u0006\u0010\u0007\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006\u0016", d2 = {"Landroidx/compose/material3/NavigationRailItemDefaults;", "", "()V", "defaultNavigationRailItemColors", "Landroidx/compose/material3/NavigationRailItemColors;", "Landroidx/compose/material3/ColorScheme;", "getDefaultNavigationRailItemColors$material3_release", "(Landroidx/compose/material3/ColorScheme;)Landroidx/compose/material3/NavigationRailItemColors;", "colors", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/material3/NavigationRailItemColors;", "selectedIconColor", "Landroidx/compose/ui/graphics/Color;", "selectedTextColor", "indicatorColor", "unselectedIconColor", "unselectedTextColor", "colors-zjMxDiM", "(JJJJJLandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/NavigationRailItemColors;", "disabledIconColor", "disabledTextColor", "colors-69fazGs", "(JJJJJJJLandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/NavigationRailItemColors;", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class NavigationRailItemDefaults {

    public static final int $stable;
    public static final androidx.compose.material3.NavigationRailItemDefaults INSTANCE;
    static {
        NavigationRailItemDefaults navigationRailItemDefaults = new NavigationRailItemDefaults();
        NavigationRailItemDefaults.INSTANCE = navigationRailItemDefaults;
    }

    public final androidx.compose.material3.NavigationRailItemColors colors(Composer $composer, int $changed) {
        boolean traceInProgress;
        String str;
        int i = -2014332261;
        ComposerKt.sourceInformationMarkerStart($composer, i, "C(colors)308@13112L11:NavigationRail.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i, $changed, -1, "androidx.compose.material3.NavigationRailItemDefaults.colors (NavigationRail.kt:308)");
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return getDefaultNavigationRailItemColors$material3_release(MaterialTheme.INSTANCE.getColorScheme($composer, 6));
    }

    public final androidx.compose.material3.NavigationRailItemColors colors-69fazGs(long selectedIconColor, long selectedTextColor, long indicatorColor, long unselectedIconColor, long unselectedTextColor, long disabledIconColor, long disabledTextColor, Composer $composer, int $changed, int i10) {
        androidx.compose.material3.tokens.ColorSchemeKeyTokens activeIconColor;
        androidx.compose.material3.tokens.ColorSchemeKeyTokens activeLabelTextColor;
        androidx.compose.material3.tokens.ColorSchemeKeyTokens activeIndicatorColor;
        int inactiveIconColor;
        int inactiveLabelTextColor;
        int i;
        int i5;
        int traceInProgress;
        long copy-wmQWz5c$default;
        int i2;
        int i6;
        int i7;
        long l4;
        long l5;
        long l3;
        long l6;
        long l7;
        long l;
        int i3;
        long l2;
        int i4;
        long obj22;
        int obj24;
        int obj25;
        int obj26;
        int obj27;
        int obj28;
        int obj29;
        final Composer composer = obj36;
        int i8 = -2104358508;
        ComposerKt.sourceInformationMarkerStart(composer, i8, "C(colors)P(3:c#ui.graphics.Color,4:c#ui.graphics.Color,2:c#ui.graphics.Color,5:c#ui.graphics.Color,6:c#ui.graphics.Color,0:c#ui.graphics.Color,1:c#ui.graphics.Color)325@14138L5,326@14222L5,327@14303L5,328@14386L5,329@14474L5,333@14705L11:NavigationRail.kt#uh7d8r");
        int i9 = 6;
        if (obj38 & 1 != 0) {
            l4 = copy-wmQWz5c$default;
        } else {
            l4 = selectedIconColor;
        }
        if (obj38 & 2 != 0) {
            l5 = copy-wmQWz5c$default;
        } else {
            l5 = indicatorColor;
        }
        if (obj38 & 4 != 0) {
            l3 = copy-wmQWz5c$default;
        } else {
            l3 = unselectedTextColor;
        }
        if (obj38 & 8 != 0) {
            l6 = copy-wmQWz5c$default;
        } else {
            l6 = disabledTextColor;
        }
        if (obj38 & 16 != 0) {
            l7 = copy-wmQWz5c$default;
        } else {
            l7 = $changed;
        }
        if (obj38 & 32 != 0) {
            l = copy-wmQWz5c$default;
        } else {
            l = obj32;
        }
        if (obj38 & 64 != 0) {
            l2 = copy-wmQWz5c$default;
        } else {
            l2 = obj34;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i8, obj37, -1, "androidx.compose.material3.NavigationRailItemDefaults.colors (NavigationRail.kt:333)");
        } else {
            i6 = obj37;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return this.getDefaultNavigationRailItemColors$material3_release(MaterialTheme.INSTANCE.getColorScheme(composer, i9)).copy-4JmcsL4(l4, obj8, l5, obj10, l3, obj12, l6);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Use overload with disabledIconColor and disabledTextColor")
    public final androidx.compose.material3.NavigationRailItemColors colors-zjMxDiM(long selectedIconColor, long selectedTextColor, long indicatorColor, long unselectedIconColor, long unselectedTextColor, Composer $composer, int $changed, int i8) {
        androidx.compose.material3.tokens.ColorSchemeKeyTokens activeIconColor;
        androidx.compose.material3.tokens.ColorSchemeKeyTokens activeLabelTextColor;
        androidx.compose.material3.tokens.ColorSchemeKeyTokens activeIndicatorColor;
        int inactiveIconColor;
        int value;
        boolean traceInProgress;
        int str;
        long value2;
        int i;
        long l3;
        long l;
        long l2;
        long l4;
        long l5;
        final Composer composer = obj33;
        int i2 = 1621601574;
        ComposerKt.sourceInformationMarkerStart(composer, i2, "C(colors)P(1:c#ui.graphics.Color,2:c#ui.graphics.Color,0:c#ui.graphics.Color,3:c#ui.graphics.Color,4:c#ui.graphics.Color)370@16602L5,371@16686L5,372@16767L5,373@16850L5,374@16938L5:NavigationRail.kt#uh7d8r");
        str = 6;
        if (obj35 & 1 != 0) {
            l3 = value2;
        } else {
            l3 = selectedIconColor;
        }
        if (obj35 & 2 != 0) {
            l = value2;
        } else {
            l = indicatorColor;
        }
        if (obj35 & 4 != 0) {
            l2 = value2;
        } else {
            l2 = unselectedTextColor;
        }
        if (obj35 & 8 != 0) {
            l4 = value2;
        } else {
            l4 = $changed;
        }
        if (obj35 & 16 != 0) {
            l5 = value;
        } else {
            l5 = obj31;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i2, obj34, -1, "androidx.compose.material3.NavigationRailItemDefaults.colors (NavigationRail.kt:376)");
        } else {
            i = obj34;
        }
        final int i9 = 0;
        final int obj29 = i3;
        final int obj30 = i4;
        final int obj25 = i5;
        final int obj26 = i6;
        final int i11 = 0;
        NavigationRailItemColors navigationRailItemColors = new NavigationRailItemColors(l3, obj8, l, obj10, l2, obj12, l4, obj14, l5, obj16, Color.copy-wmQWz5c$default(l4, selectedTextColor, obj25, obj26, 0, i9, obj29), i9, Color.copy-wmQWz5c$default(l5, selectedTextColor, obj25, obj26, 0, i11, obj29), i11, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return navigationRailItemColors;
    }

    public final androidx.compose.material3.NavigationRailItemColors getDefaultNavigationRailItemColors$material3_release(androidx.compose.material3.ColorScheme $this$defaultNavigationRailItemColors) {
        androidx.compose.material3.NavigationRailItemColors defaultNavigationRailItemColorsCached$material3_release;
        androidx.compose.material3.NavigationRailItemColors navigationRailItemColors;
        int i7;
        long token;
        long token3;
        long token4;
        long token2;
        long copy-wmQWz5c$default;
        long copy-wmQWz5c$default2;
        int i4;
        int i2;
        int i8;
        int i3;
        int i;
        int i5;
        int i6;
        final androidx.compose.material3.ColorScheme colorScheme = $this$defaultNavigationRailItemColors;
        if (colorScheme.getDefaultNavigationRailItemColorsCached$material3_release() == null) {
            i4 = 0;
            i8 = 0;
            navigationRailItemColors = new NavigationRailItemColors(ColorSchemeKt.fromToken(colorScheme, NavigationRailTokens.INSTANCE.getActiveIconColor()), obj4, ColorSchemeKt.fromToken(colorScheme, NavigationRailTokens.INSTANCE.getActiveLabelTextColor()), obj6, ColorSchemeKt.fromToken(colorScheme, NavigationRailTokens.INSTANCE.getActiveIndicatorColor()), obj8, ColorSchemeKt.fromToken(colorScheme, NavigationRailTokens.INSTANCE.getInactiveIconColor()), obj10, ColorSchemeKt.fromToken(colorScheme, NavigationRailTokens.INSTANCE.getInactiveLabelTextColor()), obj12, Color.copy-wmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, NavigationRailTokens.INSTANCE.getInactiveIconColor()), obj14, 1052938076, i4, 0, i8, 14), obj14, Color.copy-wmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, NavigationRailTokens.INSTANCE.getInactiveLabelTextColor()), i4, 1052938076, i8, 0, 0, 14), i4, 0);
            i7 = 0;
            colorScheme.setDefaultNavigationRailItemColorsCached$material3_release(navigationRailItemColors);
        }
        return defaultNavigationRailItemColorsCached$material3_release;
    }
}
