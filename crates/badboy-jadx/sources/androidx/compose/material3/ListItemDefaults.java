package androidx.compose.material3;

import androidx.compose.material3.tokens.ListTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u000b\u0008Ç\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002Jl\u0010\u0012\u001a\u00020\u00132\u0008\u0008\u0002\u0010\u0008\u001a\u00020\t2\u0008\u0008\u0002\u0010\u0014\u001a\u00020\t2\u0008\u0008\u0002\u0010\u0015\u001a\u00020\t2\u0008\u0008\u0002\u0010\u0016\u001a\u00020\t2\u0008\u0008\u0002\u0010\u0017\u001a\u00020\t2\u0008\u0008\u0002\u0010\u0018\u001a\u00020\t2\u0008\u0008\u0002\u0010\u0019\u001a\u00020\t2\u0008\u0008\u0002\u0010\u001a\u001a\u00020\t2\u0008\u0008\u0002\u0010\u001b\u001a\u00020\tH\u0007ø\u0001\u0000¢\u0006\u0004\u0008\u001c\u0010\u001dR\u0019\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\u0008\u0005\u0010\u0006R\u0017\u0010\u0008\u001a\u00020\t8Gø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\u0008\n\u0010\u000bR\u0017\u0010\u000c\u001a\u00020\t8Gø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\u0008\r\u0010\u000bR\u0011\u0010\u000e\u001a\u00020\u000f8G¢\u0006\u0006\u001a\u0004\u0008\u0010\u0010\u0011\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006\u001e", d2 = {"Landroidx/compose/material3/ListItemDefaults;", "", "()V", "Elevation", "Landroidx/compose/ui/unit/Dp;", "getElevation-D9Ej5fM", "()F", "F", "containerColor", "Landroidx/compose/ui/graphics/Color;", "getContainerColor", "(Landroidx/compose/runtime/Composer;I)J", "contentColor", "getContentColor", "shape", "Landroidx/compose/ui/graphics/Shape;", "getShape", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/graphics/Shape;", "colors", "Landroidx/compose/material3/ListItemColors;", "headlineColor", "leadingIconColor", "overlineColor", "supportingColor", "trailingIconColor", "disabledHeadlineColor", "disabledLeadingIconColor", "disabledTrailingIconColor", "colors-J08w3-E", "(JJJJJJJJJLandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/ListItemColors;", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ListItemDefaults {

    public static final int $stable;
    private static final float Elevation;
    public static final androidx.compose.material3.ListItemDefaults INSTANCE;
    static {
        ListItemDefaults listItemDefaults = new ListItemDefaults();
        ListItemDefaults.INSTANCE = listItemDefaults;
        ListItemDefaults.Elevation = ListTokens.INSTANCE.getListItemContainerElevation-D9Ej5fM();
    }

    public final androidx.compose.material3.ListItemColors colors-J08w3-E(long containerColor, long headlineColor, long leadingIconColor, long overlineColor, long supportingColor, long trailingIconColor, long disabledHeadlineColor, long disabledLeadingIconColor, long disabledTrailingIconColor, Composer $composer, int $changed, int i12) {
        float listItemDisabledTrailingIconOpacity;
        int traceInProgress;
        int listItemContainerColor;
        int listItemLabelTextColor;
        int listItemLeadingIconColor;
        int listItemOverlineColor;
        int listItemSupportingTextColor;
        int listItemTrailingIconColor;
        int listItemDisabledLabelTextOpacity;
        float listItemDisabledLeadingIconOpacity;
        int i2;
        long copy-wmQWz5c$default;
        int i4;
        int i3;
        long l6;
        long l3;
        long l;
        long l9;
        long l4;
        long l2;
        long l5;
        int i5;
        int i6;
        long l8;
        int i7;
        int i;
        long l7;
        int i8;
        long obj28;
        float obj30;
        int obj31;
        int obj32;
        int obj33;
        int obj34;
        int obj35;
        final Composer composer = obj46;
        int i9 = obj48;
        final int i10 = -352515689;
        ComposerKt.sourceInformationMarkerStart(composer, i10, "C(colors)P(0:c#ui.graphics.Color,4:c#ui.graphics.Color,5:c#ui.graphics.Color,6:c#ui.graphics.Color,7:c#ui.graphics.Color,8:c#ui.graphics.Color,1:c#ui.graphics.Color,2:c#ui.graphics.Color,3:c#ui.graphics.Color)563@22671L5,564@22743L5,565@22820L5,566@22891L5,567@22970L5,568@23049L5,570@23149L5,574@23342L5,578@23539L5:ListItem.kt#uh7d8r");
        int i11 = 6;
        if (i9 & 1 != 0) {
            l6 = copy-wmQWz5c$default;
        } else {
            l6 = containerColor;
        }
        if (i9 & 2 != 0) {
            l3 = copy-wmQWz5c$default;
        } else {
            l3 = leadingIconColor;
        }
        if (i9 & 4 != 0) {
            l = copy-wmQWz5c$default;
        } else {
            l = supportingColor;
        }
        if (i9 & 8 != 0) {
            l9 = copy-wmQWz5c$default;
        } else {
            l9 = disabledHeadlineColor;
        }
        if (i9 & 16 != 0) {
            l4 = copy-wmQWz5c$default;
        } else {
            l4 = disabledTrailingIconColor;
        }
        if (i9 & 32 != 0) {
            l2 = copy-wmQWz5c$default;
        } else {
            l2 = $changed;
        }
        if (i9 & 64 != 0) {
            l5 = copy-wmQWz5c$default;
        } else {
            l5 = obj40;
        }
        if (i9 & 128 != 0) {
            l8 = copy-wmQWz5c$default;
        } else {
            l8 = obj42;
        }
        if (i9 &= 256 != 0) {
            l7 = listItemDisabledLeadingIconOpacity;
        } else {
            l7 = obj44;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i10, obj47, -1, "androidx.compose.material3.ListItemDefaults.colors (ListItem.kt:582)");
        } else {
            i2 = obj47;
        }
        ListItemColors listItemColors = new ListItemColors(l6, obj9, l3, obj11, l, obj13, l9, obj15, l4, obj17, l2, obj19, l5, i5, l8, i7, l7, i8, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return listItemColors;
    }

    public final long getContainerColor(Composer $composer, int $changed) {
        boolean traceInProgress;
        String str;
        int i = -1253579929;
        ComposerKt.sourceInformationMarkerStart($composer, i, "C539@21445L5:ListItem.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i, $changed, -1, "androidx.compose.material3.ListItemDefaults.<get-containerColor> (ListItem.kt:539)");
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return ColorSchemeKt.getValue(ListTokens.INSTANCE.getListItemContainerColor(), $composer, 6);
    }

    public final long getContentColor(Composer $composer, int $changed) {
        boolean traceInProgress;
        String str;
        int i = 1076068327;
        ComposerKt.sourceInformationMarkerStart($composer, i, "C543@21606L5:ListItem.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i, $changed, -1, "androidx.compose.material3.ListItemDefaults.<get-contentColor> (ListItem.kt:543)");
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return ColorSchemeKt.getValue(ListTokens.INSTANCE.getListItemLabelTextColor(), $composer, 6);
    }

    public final float getElevation-D9Ej5fM() {
        return ListItemDefaults.Elevation;
    }

    public final Shape getShape(Composer $composer, int $changed) {
        boolean traceInProgress;
        String str;
        int i = -496871597;
        ComposerKt.sourceInformationMarkerStart($composer, i, "C535@21280L5:ListItem.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i, $changed, -1, "androidx.compose.material3.ListItemDefaults.<get-shape> (ListItem.kt:535)");
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return ShapesKt.getValue(ListTokens.INSTANCE.getListItemContainerShape(), $composer, 6);
    }
}
