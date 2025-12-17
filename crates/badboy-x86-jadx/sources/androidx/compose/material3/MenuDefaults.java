package androidx.compose.material3;

import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.material3.tokens.ElevationTokens;
import androidx.compose.material3.tokens.ListTokens;
import androidx.compose.material3.tokens.MenuTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Color.Companion;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\r\u0008Ç\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\r\u0010\u001b\u001a\u00020\u0017H\u0007¢\u0006\u0002\u0010\u001cJN\u0010\u001b\u001a\u00020\u00172\u0008\u0008\u0002\u0010\u001d\u001a\u00020\u000f2\u0008\u0008\u0002\u0010\u001e\u001a\u00020\u000f2\u0008\u0008\u0002\u0010\u001f\u001a\u00020\u000f2\u0008\u0008\u0002\u0010 \u001a\u00020\u000f2\u0008\u0008\u0002\u0010!\u001a\u00020\u000f2\u0008\u0008\u0002\u0010\"\u001a\u00020\u000fH\u0007ø\u0001\u0000¢\u0006\u0004\u0008#\u0010$R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006R\u0019\u0010\u0007\u001a\u00020\u0008ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\u0008\t\u0010\nR\u0019\u0010\u000c\u001a\u00020\u0008ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\u0008\r\u0010\nR\u0017\u0010\u000e\u001a\u00020\u000f8Gø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\u0008\u0010\u0010\u0011R\u0011\u0010\u0012\u001a\u00020\u00138G¢\u0006\u0006\u001a\u0004\u0008\u0014\u0010\u0015R\u0018\u0010\u0016\u001a\u00020\u0017*\u00020\u00188@X\u0080\u0004¢\u0006\u0006\u001a\u0004\u0008\u0019\u0010\u001a\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006%", d2 = {"Landroidx/compose/material3/MenuDefaults;", "", "()V", "DropdownMenuItemContentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "getDropdownMenuItemContentPadding", "()Landroidx/compose/foundation/layout/PaddingValues;", "ShadowElevation", "Landroidx/compose/ui/unit/Dp;", "getShadowElevation-D9Ej5fM", "()F", "F", "TonalElevation", "getTonalElevation-D9Ej5fM", "containerColor", "Landroidx/compose/ui/graphics/Color;", "getContainerColor", "(Landroidx/compose/runtime/Composer;I)J", "shape", "Landroidx/compose/ui/graphics/Shape;", "getShape", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/graphics/Shape;", "defaultMenuItemColors", "Landroidx/compose/material3/MenuItemColors;", "Landroidx/compose/material3/ColorScheme;", "getDefaultMenuItemColors$material3_release", "(Landroidx/compose/material3/ColorScheme;)Landroidx/compose/material3/MenuItemColors;", "itemColors", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/material3/MenuItemColors;", "textColor", "leadingIconColor", "trailingIconColor", "disabledTextColor", "disabledLeadingIconColor", "disabledTrailingIconColor", "itemColors-5tl4gsc", "(JJJJJJLandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/MenuItemColors;", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class MenuDefaults {

    public static final int $stable;
    private static final PaddingValues DropdownMenuItemContentPadding;
    public static final androidx.compose.material3.MenuDefaults INSTANCE;
    private static final float ShadowElevation;
    private static final float TonalElevation;
    static {
        MenuDefaults menuDefaults = new MenuDefaults();
        MenuDefaults.INSTANCE = menuDefaults;
        MenuDefaults.TonalElevation = ElevationTokens.INSTANCE.getLevel0-D9Ej5fM();
        MenuDefaults.ShadowElevation = MenuTokens.INSTANCE.getContainerElevation-D9Ej5fM();
        final int i2 = 0;
        MenuDefaults.DropdownMenuItemContentPadding = PaddingKt.PaddingValues-YgX7TsA(MenuKt.access$getDropdownMenuItemHorizontalPadding$p(), Dp.constructor-impl((float)i));
    }

    public final long getContainerColor(Composer $composer, int $changed) {
        boolean traceInProgress;
        String str;
        int i = -1787427929;
        ComposerKt.sourceInformationMarkerStart($composer, i, "C198@9634L5:Menu.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i, $changed, -1, "androidx.compose.material3.MenuDefaults.<get-containerColor> (Menu.kt:198)");
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return ColorSchemeKt.getValue(MenuTokens.INSTANCE.getContainerColor(), $composer, 6);
    }

    public final androidx.compose.material3.MenuItemColors getDefaultMenuItemColors$material3_release(androidx.compose.material3.ColorScheme $this$defaultMenuItemColors) {
        androidx.compose.material3.MenuItemColors defaultMenuItemColorsCached$material3_release;
        androidx.compose.material3.MenuItemColors menuItemColors;
        int i2;
        long token2;
        long token;
        long copy-wmQWz5c$default;
        long copy-wmQWz5c$default3;
        int i6;
        long copy-wmQWz5c$default2;
        int i;
        int i5;
        int i8;
        int i3;
        int i7;
        int i4;
        int i9;
        final androidx.compose.material3.ColorScheme colorScheme = $this$defaultMenuItemColors;
        if (colorScheme.getDefaultMenuItemColorsCached$material3_release() == null) {
            i6 = 0;
            i = 0;
            i8 = 0;
            menuItemColors = new MenuItemColors(ColorSchemeKt.fromToken(colorScheme, ListTokens.INSTANCE.getListItemLabelTextColor()), obj4, ColorSchemeKt.fromToken(colorScheme, ListTokens.INSTANCE.getListItemLeadingIconColor()), obj6, ColorSchemeKt.fromToken(colorScheme, ListTokens.INSTANCE.getListItemTrailingIconColor()), obj8, Color.copy-wmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, ListTokens.INSTANCE.getListItemDisabledLabelTextColor()), obj10, ListTokens.INSTANCE.getListItemDisabledLabelTextOpacity(), i6, 0, i, 14), obj10, Color.copy-wmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, ListTokens.INSTANCE.getListItemDisabledLeadingIconColor()), i6, ListTokens.INSTANCE.getListItemDisabledLeadingIconOpacity(), i, 0, i8, 14), i6, Color.copy-wmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, ListTokens.INSTANCE.getListItemDisabledTrailingIconColor()), i, ListTokens.INSTANCE.getListItemDisabledTrailingIconOpacity(), i8, 0, 0, 14), i, 0);
            i2 = 0;
            colorScheme.setDefaultMenuItemColorsCached$material3_release(menuItemColors);
        }
        return defaultMenuItemColorsCached$material3_release;
    }

    public final PaddingValues getDropdownMenuItemContentPadding() {
        return MenuDefaults.DropdownMenuItemContentPadding;
    }

    public final float getShadowElevation-D9Ej5fM() {
        return MenuDefaults.ShadowElevation;
    }

    public final Shape getShape(Composer $composer, int $changed) {
        boolean traceInProgress;
        String str;
        int i = 218702739;
        ComposerKt.sourceInformationMarkerStart($composer, i, "C194@9499L5:Menu.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i, $changed, -1, "androidx.compose.material3.MenuDefaults.<get-shape> (Menu.kt:194)");
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return ShapesKt.getValue(MenuTokens.INSTANCE.getContainerShape(), $composer, 6);
    }

    public final float getTonalElevation-D9Ej5fM() {
        return MenuDefaults.TonalElevation;
    }

    public final androidx.compose.material3.MenuItemColors itemColors(Composer $composer, int $changed) {
        boolean traceInProgress;
        String str;
        int i = 1326531516;
        ComposerKt.sourceInformationMarkerStart($composer, i, "C(itemColors)204@9833L11:Menu.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i, $changed, -1, "androidx.compose.material3.MenuDefaults.itemColors (Menu.kt:204)");
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return getDefaultMenuItemColors$material3_release(MaterialTheme.INSTANCE.getColorScheme($composer, 6));
    }

    public final androidx.compose.material3.MenuItemColors itemColors-5tl4gsc(long textColor, long leadingIconColor, long trailingIconColor, long disabledTextColor, long disabledLeadingIconColor, long disabledTrailingIconColor, Composer $composer, int $changed, int i9) {
        long unspecified-0d7_KjU;
        long unspecified-0d7_KjU2;
        long unspecified-0d7_KjU3;
        int unspecified-0d7_KjU5;
        int unspecified-0d7_KjU4;
        int unspecified-0d7_KjU6;
        boolean traceInProgress;
        String str;
        int i;
        long l;
        long l4;
        long l5;
        long l2;
        long l3;
        long l6;
        final Composer composer = obj30;
        int i2 = -1278543580;
        ComposerKt.sourceInformationMarkerStart(composer, i2, "C(itemColors)P(4:c#ui.graphics.Color,3:c#ui.graphics.Color,5:c#ui.graphics.Color,1:c#ui.graphics.Color,0:c#ui.graphics.Color,2:c#ui.graphics.Color)229@11073L11:Menu.kt#uh7d8r");
        if (obj32 & 1 != 0) {
            l = unspecified-0d7_KjU;
        } else {
            l = textColor;
        }
        if (obj32 & 2 != 0) {
            l4 = unspecified-0d7_KjU2;
        } else {
            l4 = trailingIconColor;
        }
        if (obj32 & 4 != 0) {
            l5 = unspecified-0d7_KjU3;
        } else {
            l5 = disabledLeadingIconColor;
        }
        if (obj32 & 8 != 0) {
            l2 = unspecified-0d7_KjU5;
        } else {
            l2 = $composer;
        }
        if (obj32 & 16 != 0) {
            l3 = unspecified-0d7_KjU4;
        } else {
            l3 = i9;
        }
        if (obj32 & 32 != 0) {
            l6 = unspecified-0d7_KjU6;
        } else {
            l6 = obj28;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i2, obj31, -1, "androidx.compose.material3.MenuDefaults.itemColors (Menu.kt:229)");
        } else {
            i = obj31;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return this.getDefaultMenuItemColors$material3_release(MaterialTheme.INSTANCE.getColorScheme(composer, 6)).copy-tNS2XkQ(l, obj6, l4, obj8, l5, obj10);
    }
}
