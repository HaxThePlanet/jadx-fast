package androidx.compose.material3;

import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.material3.tokens.NavigationDrawerTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Color.Companion;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\n\u0008Ç\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002Jb\u0010\u0007\u001a\u00020\u00082\u0008\u0008\u0002\u0010\t\u001a\u00020\n2\u0008\u0008\u0002\u0010\u000b\u001a\u00020\n2\u0008\u0008\u0002\u0010\u000c\u001a\u00020\n2\u0008\u0008\u0002\u0010\r\u001a\u00020\n2\u0008\u0008\u0002\u0010\u000e\u001a\u00020\n2\u0008\u0008\u0002\u0010\u000f\u001a\u00020\n2\u0008\u0008\u0002\u0010\u0010\u001a\u00020\n2\u0008\u0008\u0002\u0010\u0011\u001a\u00020\nH\u0007ø\u0001\u0000¢\u0006\u0004\u0008\u0012\u0010\u0013R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006\u0014", d2 = {"Landroidx/compose/material3/NavigationDrawerItemDefaults;", "", "()V", "ItemPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "getItemPadding", "()Landroidx/compose/foundation/layout/PaddingValues;", "colors", "Landroidx/compose/material3/NavigationDrawerItemColors;", "selectedContainerColor", "Landroidx/compose/ui/graphics/Color;", "unselectedContainerColor", "selectedIconColor", "unselectedIconColor", "selectedTextColor", "unselectedTextColor", "selectedBadgeColor", "unselectedBadgeColor", "colors-oq7We08", "(JJJJJJJJLandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/NavigationDrawerItemColors;", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class NavigationDrawerItemDefaults {

    public static final int $stable;
    public static final androidx.compose.material3.NavigationDrawerItemDefaults INSTANCE;
    private static final PaddingValues ItemPadding;
    static {
        NavigationDrawerItemDefaults navigationDrawerItemDefaults = new NavigationDrawerItemDefaults();
        NavigationDrawerItemDefaults.INSTANCE = navigationDrawerItemDefaults;
        int i2 = 0;
        NavigationDrawerItemDefaults.ItemPadding = PaddingKt.PaddingValues-YgX7TsA$default(Dp.constructor-impl((float)i), 0, 2, 0);
    }

    public final androidx.compose.material3.NavigationDrawerItemColors colors-oq7We08(long selectedContainerColor, long unselectedContainerColor, long selectedIconColor, long unselectedIconColor, long selectedTextColor, long unselectedTextColor, long selectedBadgeColor, long unselectedBadgeColor, Composer $composer, int $changed, int i11) {
        int traceInProgress;
        int activeIndicatorColor;
        int companion;
        int activeIconColor;
        int inactiveIconColor;
        int activeLabelTextColor;
        int value;
        int str;
        int i;
        long transparent-0d7_KjU;
        long l3;
        long l6;
        long l7;
        long l8;
        long l;
        long l2;
        long l4;
        long l5;
        final Composer composer = obj42;
        int i2 = obj44;
        final int i4 = -1574983348;
        ComposerKt.sourceInformationMarkerStart(composer, i4, "C(colors)P(1:c#ui.graphics.Color,5:c#ui.graphics.Color,2:c#ui.graphics.Color,6:c#ui.graphics.Color,3:c#ui.graphics.Color,7:c#ui.graphics.Color,0:c#ui.graphics.Color,4:c#ui.graphics.Color)1014@42017L5,1016@42159L5,1017@42244L5,1018@42330L5,1019@42420L5:NavigationDrawer.kt#uh7d8r");
        int i5 = 6;
        if (i2 & 1 != 0) {
            l = transparent-0d7_KjU;
        } else {
            l = selectedContainerColor;
        }
        if (i2 & 2 != 0) {
            l2 = transparent-0d7_KjU;
        } else {
            l2 = selectedIconColor;
        }
        if (i2 & 4 != 0) {
            l3 = transparent-0d7_KjU;
        } else {
            l3 = selectedTextColor;
        }
        if (i2 & 8 != 0) {
            l6 = transparent-0d7_KjU;
        } else {
            l6 = selectedBadgeColor;
        }
        if (i2 & 16 != 0) {
            l7 = transparent-0d7_KjU;
        } else {
            l7 = $composer;
        }
        if (i2 & 32 != 0) {
            l8 = value;
        } else {
            l8 = i11;
        }
        l4 = i2 & 64 != 0 ? str : obj38;
        l5 = i2 &= 128 != 0 ? str : obj40;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i4, obj43, -1, "androidx.compose.material3.NavigationDrawerItemDefaults.colors (NavigationDrawer.kt:1023)");
        } else {
            i = obj43;
        }
        DefaultDrawerItemsColor defaultDrawerItemsColor = new DefaultDrawerItemsColor(l3, obj9, l6, obj11, l7, obj13, l8, obj15, l, obj17, l2, obj19, l4, obj21, l5, obj23, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return (NavigationDrawerItemColors)defaultDrawerItemsColor;
    }

    public final PaddingValues getItemPadding() {
        return NavigationDrawerItemDefaults.ItemPadding;
    }
}
