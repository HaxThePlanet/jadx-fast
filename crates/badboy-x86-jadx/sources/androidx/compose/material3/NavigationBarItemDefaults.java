package androidx.compose.material3;

import androidx.compose.material3.tokens.NavigationBarTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Color.Companion;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u000b\u0008Ç\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\r\u0010\u0008\u001a\u00020\u0004H\u0007¢\u0006\u0002\u0010\tJD\u0010\u0008\u001a\u00020\u00042\u0008\u0008\u0002\u0010\n\u001a\u00020\u000b2\u0008\u0008\u0002\u0010\u000c\u001a\u00020\u000b2\u0008\u0008\u0002\u0010\r\u001a\u00020\u000b2\u0008\u0008\u0002\u0010\u000e\u001a\u00020\u000b2\u0008\u0008\u0002\u0010\u000f\u001a\u00020\u000bH\u0007ø\u0001\u0000¢\u0006\u0004\u0008\u0010\u0010\u0011JX\u0010\u0008\u001a\u00020\u00042\u0008\u0008\u0002\u0010\n\u001a\u00020\u000b2\u0008\u0008\u0002\u0010\u000c\u001a\u00020\u000b2\u0008\u0008\u0002\u0010\r\u001a\u00020\u000b2\u0008\u0008\u0002\u0010\u000e\u001a\u00020\u000b2\u0008\u0008\u0002\u0010\u000f\u001a\u00020\u000b2\u0008\u0008\u0002\u0010\u0012\u001a\u00020\u000b2\u0008\u0008\u0002\u0010\u0013\u001a\u00020\u000bH\u0007ø\u0001\u0000¢\u0006\u0004\u0008\u0014\u0010\u0015R\u0018\u0010\u0003\u001a\u00020\u0004*\u00020\u00058@X\u0080\u0004¢\u0006\u0006\u001a\u0004\u0008\u0006\u0010\u0007\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006\u0016", d2 = {"Landroidx/compose/material3/NavigationBarItemDefaults;", "", "()V", "defaultNavigationBarItemColors", "Landroidx/compose/material3/NavigationBarItemColors;", "Landroidx/compose/material3/ColorScheme;", "getDefaultNavigationBarItemColors$material3_release", "(Landroidx/compose/material3/ColorScheme;)Landroidx/compose/material3/NavigationBarItemColors;", "colors", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/material3/NavigationBarItemColors;", "selectedIconColor", "Landroidx/compose/ui/graphics/Color;", "selectedTextColor", "indicatorColor", "unselectedIconColor", "unselectedTextColor", "colors-zjMxDiM", "(JJJJJLandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/NavigationBarItemColors;", "disabledIconColor", "disabledTextColor", "colors-69fazGs", "(JJJJJJJLandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/NavigationBarItemColors;", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class NavigationBarItemDefaults {

    public static final int $stable;
    public static final androidx.compose.material3.NavigationBarItemDefaults INSTANCE;
    static {
        NavigationBarItemDefaults navigationBarItemDefaults = new NavigationBarItemDefaults();
        NavigationBarItemDefaults.INSTANCE = navigationBarItemDefaults;
    }

    public final androidx.compose.material3.NavigationBarItemColors colors(Composer $composer, int $changed) {
        boolean traceInProgress;
        String str;
        int i = 1018883954;
        ComposerKt.sourceInformationMarkerStart($composer, i, "C(colors)311@13475L11:NavigationBar.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i, $changed, -1, "androidx.compose.material3.NavigationBarItemDefaults.colors (NavigationBar.kt:311)");
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return getDefaultNavigationBarItemColors$material3_release(MaterialTheme.INSTANCE.getColorScheme($composer, 6));
    }

    public final androidx.compose.material3.NavigationBarItemColors colors-69fazGs(long selectedIconColor, long selectedTextColor, long indicatorColor, long unselectedIconColor, long unselectedTextColor, long disabledIconColor, long disabledTextColor, Composer $composer, int $changed, int i10) {
        long unspecified-0d7_KjU7;
        long unspecified-0d7_KjU3;
        long unspecified-0d7_KjU5;
        int unspecified-0d7_KjU;
        int unspecified-0d7_KjU6;
        int unspecified-0d7_KjU4;
        int unspecified-0d7_KjU2;
        int traceInProgress;
        String str;
        int i;
        long l4;
        long l6;
        long l2;
        long l5;
        long l;
        long l7;
        long l3;
        final Composer composer = obj34;
        int i2 = -1618564327;
        ComposerKt.sourceInformationMarkerStart(composer, i2, "C(colors)P(3:c#ui.graphics.Color,4:c#ui.graphics.Color,2:c#ui.graphics.Color,5:c#ui.graphics.Color,6:c#ui.graphics.Color,0:c#ui.graphics.Color,1:c#ui.graphics.Color)336@14859L11:NavigationBar.kt#uh7d8r");
        if (obj36 & 1 != 0) {
            l4 = unspecified-0d7_KjU7;
        } else {
            l4 = selectedIconColor;
        }
        if (obj36 & 2 != 0) {
            l6 = unspecified-0d7_KjU3;
        } else {
            l6 = indicatorColor;
        }
        if (obj36 & 4 != 0) {
            l2 = unspecified-0d7_KjU5;
        } else {
            l2 = unselectedTextColor;
        }
        if (obj36 & 8 != 0) {
            l5 = unspecified-0d7_KjU;
        } else {
            l5 = disabledTextColor;
        }
        if (obj36 & 16 != 0) {
            l = unspecified-0d7_KjU6;
        } else {
            l = $changed;
        }
        if (obj36 & 32 != 0) {
            l7 = unspecified-0d7_KjU4;
        } else {
            l7 = obj30;
        }
        if (obj36 & 64 != 0) {
            l3 = unspecified-0d7_KjU2;
        } else {
            l3 = obj32;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i2, obj35, -1, "androidx.compose.material3.NavigationBarItemDefaults.colors (NavigationBar.kt:336)");
        } else {
            i = obj35;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return this.getDefaultNavigationBarItemColors$material3_release(MaterialTheme.INSTANCE.getColorScheme(composer, 6)).copy-4JmcsL4(l4, obj6, l6, obj8, l2, obj10, l5);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Use overload with disabledIconColor and disabledTextColor")
    public final androidx.compose.material3.NavigationBarItemColors colors-zjMxDiM(long selectedIconColor, long selectedTextColor, long indicatorColor, long unselectedIconColor, long unselectedTextColor, Composer $composer, int $changed, int i8) {
        androidx.compose.material3.tokens.ColorSchemeKeyTokens activeIconColor;
        androidx.compose.material3.tokens.ColorSchemeKeyTokens activeLabelTextColor;
        androidx.compose.material3.tokens.ColorSchemeKeyTokens activeIndicatorColor;
        int inactiveIconColor;
        int value;
        boolean traceInProgress;
        int str;
        long value2;
        int i;
        long l;
        long l2;
        long l3;
        long l4;
        long l5;
        final Composer composer = obj33;
        int i2 = -213647161;
        ComposerKt.sourceInformationMarkerStart(composer, i2, "C(colors)P(1:c#ui.graphics.Color,2:c#ui.graphics.Color,0:c#ui.graphics.Color,3:c#ui.graphics.Color,4:c#ui.graphics.Color)372@16714L5,373@16797L5,374@16877L5,375@16959L5,376@17046L5:NavigationBar.kt#uh7d8r");
        str = 6;
        if (obj35 & 1 != 0) {
            l = value2;
        } else {
            l = selectedIconColor;
        }
        if (obj35 & 2 != 0) {
            l2 = value2;
        } else {
            l2 = indicatorColor;
        }
        if (obj35 & 4 != 0) {
            l3 = value2;
        } else {
            l3 = unselectedTextColor;
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
            ComposerKt.traceEventStart(i2, obj34, -1, "androidx.compose.material3.NavigationBarItemDefaults.colors (NavigationBar.kt:378)");
        } else {
            i = obj34;
        }
        final int i9 = 0;
        final int obj29 = i3;
        final int obj30 = i4;
        final int obj25 = i5;
        final int obj26 = i6;
        final int i11 = 0;
        NavigationBarItemColors navigationBarItemColors = new NavigationBarItemColors(l, obj8, l2, obj10, l3, obj12, l4, obj14, l5, obj16, Color.copy-wmQWz5c$default(l4, selectedTextColor, obj25, obj26, 0, i9, obj29), i9, Color.copy-wmQWz5c$default(l5, selectedTextColor, obj25, obj26, 0, i11, obj29), i11, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return navigationBarItemColors;
    }

    public final androidx.compose.material3.NavigationBarItemColors getDefaultNavigationBarItemColors$material3_release(androidx.compose.material3.ColorScheme $this$defaultNavigationBarItemColors) {
        androidx.compose.material3.NavigationBarItemColors defaultNavigationBarItemColorsCached$material3_release;
        androidx.compose.material3.NavigationBarItemColors navigationBarItemColors;
        int i4;
        long token3;
        long token4;
        long token;
        long token2;
        long copy-wmQWz5c$default2;
        long copy-wmQWz5c$default;
        int i6;
        int i8;
        int i2;
        int i5;
        int i7;
        int i;
        int i3;
        final androidx.compose.material3.ColorScheme colorScheme = $this$defaultNavigationBarItemColors;
        if (colorScheme.getDefaultNavigationBarItemColorsCached$material3_release() == null) {
            i6 = 0;
            i2 = 0;
            navigationBarItemColors = new NavigationBarItemColors(ColorSchemeKt.fromToken(colorScheme, NavigationBarTokens.INSTANCE.getActiveIconColor()), obj4, ColorSchemeKt.fromToken(colorScheme, NavigationBarTokens.INSTANCE.getActiveLabelTextColor()), obj6, ColorSchemeKt.fromToken(colorScheme, NavigationBarTokens.INSTANCE.getActiveIndicatorColor()), obj8, ColorSchemeKt.fromToken(colorScheme, NavigationBarTokens.INSTANCE.getInactiveIconColor()), obj10, ColorSchemeKt.fromToken(colorScheme, NavigationBarTokens.INSTANCE.getInactiveLabelTextColor()), obj12, Color.copy-wmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, NavigationBarTokens.INSTANCE.getInactiveIconColor()), obj14, 1052938076, i6, 0, i2, 14), obj14, Color.copy-wmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, NavigationBarTokens.INSTANCE.getInactiveLabelTextColor()), i6, 1052938076, i2, 0, 0, 14), i6, 0);
            i4 = 0;
            colorScheme.setDefaultNavigationBarItemColorsCached$material3_release(navigationBarItemColors);
        }
        return defaultNavigationBarItemColorsCached$material3_release;
    }
}
