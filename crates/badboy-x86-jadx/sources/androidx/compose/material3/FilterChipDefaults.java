package androidx.compose.material3;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.BorderStrokeKt;
import androidx.compose.material3.tokens.FilterChipTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Color.Companion;
import androidx.compose.ui.graphics.Shape;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0002\u0008\u000e\n\u0002\u0018\u0002\n\u0002\u0008\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u000e\u0008Ç\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\r\u0010\u0015\u001a\u00020\u000fH\u0007¢\u0006\u0002\u0010\u0016J\u008a\u0001\u0010\u0015\u001a\u00020\u000f2\u0008\u0008\u0002\u0010\u0017\u001a\u00020\u00182\u0008\u0008\u0002\u0010\u0019\u001a\u00020\u00182\u0008\u0008\u0002\u0010\u001a\u001a\u00020\u00182\u0008\u0008\u0002\u0010\u001b\u001a\u00020\u00182\u0008\u0008\u0002\u0010\u001c\u001a\u00020\u00182\u0008\u0008\u0002\u0010\u001d\u001a\u00020\u00182\u0008\u0008\u0002\u0010\u001e\u001a\u00020\u00182\u0008\u0008\u0002\u0010\u001f\u001a\u00020\u00182\u0008\u0008\u0002\u0010 \u001a\u00020\u00182\u0008\u0008\u0002\u0010!\u001a\u00020\u00182\u0008\u0008\u0002\u0010\"\u001a\u00020\u00182\u0008\u0008\u0002\u0010#\u001a\u00020\u0018H\u0007ø\u0001\u0000¢\u0006\u0004\u0008$\u0010%JN\u0010&\u001a\u00020'2\u0008\u0008\u0002\u0010(\u001a\u00020\u00042\u0008\u0008\u0002\u0010)\u001a\u00020\u00042\u0008\u0008\u0002\u0010*\u001a\u00020\u00042\u0008\u0008\u0002\u0010+\u001a\u00020\u00042\u0008\u0008\u0002\u0010,\u001a\u00020\u00042\u0008\u0008\u0002\u0010-\u001a\u00020\u0004H\u0007ø\u0001\u0000¢\u0006\u0004\u0008.\u0010/J^\u00100\u001a\u0002012\u0006\u00102\u001a\u0002032\u0006\u00104\u001a\u0002032\u0008\u0008\u0002\u00105\u001a\u00020\u00182\u0008\u0008\u0002\u00106\u001a\u00020\u00182\u0008\u0008\u0002\u00107\u001a\u00020\u00182\u0008\u0008\u0002\u00108\u001a\u00020\u00182\u0008\u0008\u0002\u00109\u001a\u00020\u00042\u0008\u0008\u0002\u0010:\u001a\u00020\u0004H\u0007ø\u0001\u0000¢\u0006\u0004\u0008;\u0010<J\r\u0010=\u001a\u00020\u000fH\u0007¢\u0006\u0002\u0010\u0016J\u008a\u0001\u0010=\u001a\u00020\u000f2\u0008\u0008\u0002\u0010\u0017\u001a\u00020\u00182\u0008\u0008\u0002\u0010\u0019\u001a\u00020\u00182\u0008\u0008\u0002\u0010\u001a\u001a\u00020\u00182\u0008\u0008\u0002\u0010\u001b\u001a\u00020\u00182\u0008\u0008\u0002\u0010\u001c\u001a\u00020\u00182\u0008\u0008\u0002\u0010\u001d\u001a\u00020\u00182\u0008\u0008\u0002\u0010\u001e\u001a\u00020\u00182\u0008\u0008\u0002\u0010\u001f\u001a\u00020\u00182\u0008\u0008\u0002\u0010 \u001a\u00020\u00182\u0008\u0008\u0002\u0010!\u001a\u00020\u00182\u0008\u0008\u0002\u0010\"\u001a\u00020\u00182\u0008\u0008\u0002\u0010#\u001a\u00020\u0018H\u0007ø\u0001\u0000¢\u0006\u0004\u0008>\u0010%JN\u0010?\u001a\u00020'2\u0008\u0008\u0002\u0010(\u001a\u00020\u00042\u0008\u0008\u0002\u0010)\u001a\u00020\u00042\u0008\u0008\u0002\u0010*\u001a\u00020\u00042\u0008\u0008\u0002\u0010+\u001a\u00020\u00042\u0008\u0008\u0002\u0010,\u001a\u00020\u00042\u0008\u0008\u0002\u0010-\u001a\u00020\u0004H\u0007ø\u0001\u0000¢\u0006\u0004\u0008@\u0010/R\u0019\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\u0008\u0005\u0010\u0006R\u0019\u0010\u0008\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\u0008\t\u0010\u0006R\u0011\u0010\n\u001a\u00020\u000b8G¢\u0006\u0006\u001a\u0004\u0008\u000c\u0010\rR\u0018\u0010\u000e\u001a\u00020\u000f*\u00020\u00108@X\u0080\u0004¢\u0006\u0006\u001a\u0004\u0008\u0011\u0010\u0012R\u0018\u0010\u0013\u001a\u00020\u000f*\u00020\u00108@X\u0080\u0004¢\u0006\u0006\u001a\u0004\u0008\u0014\u0010\u0012\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006A", d2 = {"Landroidx/compose/material3/FilterChipDefaults;", "", "()V", "Height", "Landroidx/compose/ui/unit/Dp;", "getHeight-D9Ej5fM", "()F", "F", "IconSize", "getIconSize-D9Ej5fM", "shape", "Landroidx/compose/ui/graphics/Shape;", "getShape", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/graphics/Shape;", "defaultElevatedFilterChipColors", "Landroidx/compose/material3/SelectableChipColors;", "Landroidx/compose/material3/ColorScheme;", "getDefaultElevatedFilterChipColors$material3_release", "(Landroidx/compose/material3/ColorScheme;)Landroidx/compose/material3/SelectableChipColors;", "defaultFilterChipColors", "getDefaultFilterChipColors$material3_release", "elevatedFilterChipColors", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/material3/SelectableChipColors;", "containerColor", "Landroidx/compose/ui/graphics/Color;", "labelColor", "iconColor", "disabledContainerColor", "disabledLabelColor", "disabledLeadingIconColor", "disabledTrailingIconColor", "selectedContainerColor", "disabledSelectedContainerColor", "selectedLabelColor", "selectedLeadingIconColor", "selectedTrailingIconColor", "elevatedFilterChipColors-XqyqHi0", "(JJJJJJJJJJJJLandroidx/compose/runtime/Composer;III)Landroidx/compose/material3/SelectableChipColors;", "elevatedFilterChipElevation", "Landroidx/compose/material3/SelectableChipElevation;", "elevation", "pressedElevation", "focusedElevation", "hoveredElevation", "draggedElevation", "disabledElevation", "elevatedFilterChipElevation-aqJV_2Y", "(FFFFFFLandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/SelectableChipElevation;", "filterChipBorder", "Landroidx/compose/foundation/BorderStroke;", "enabled", "", "selected", "borderColor", "selectedBorderColor", "disabledBorderColor", "disabledSelectedBorderColor", "borderWidth", "selectedBorderWidth", "filterChipBorder-_7El2pE", "(ZZJJJJFFLandroidx/compose/runtime/Composer;II)Landroidx/compose/foundation/BorderStroke;", "filterChipColors", "filterChipColors-XqyqHi0", "filterChipElevation", "filterChipElevation-aqJV_2Y", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class FilterChipDefaults {

    public static final int $stable;
    private static final float Height;
    public static final androidx.compose.material3.FilterChipDefaults INSTANCE;
    private static final float IconSize;
    static {
        FilterChipDefaults filterChipDefaults = new FilterChipDefaults();
        FilterChipDefaults.INSTANCE = filterChipDefaults;
        FilterChipDefaults.Height = FilterChipTokens.INSTANCE.getContainerHeight-D9Ej5fM();
        FilterChipDefaults.IconSize = FilterChipTokens.INSTANCE.getIconSize-D9Ej5fM();
    }

    public final androidx.compose.material3.SelectableChipColors elevatedFilterChipColors(Composer $composer, int $changed) {
        boolean traceInProgress;
        String str;
        int i = 1082953289;
        ComposerKt.sourceInformationMarkerStart($composer, i, "C(elevatedFilterChipColors)1430@69720L11:Chip.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i, $changed, -1, "androidx.compose.material3.FilterChipDefaults.elevatedFilterChipColors (Chip.kt:1430)");
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return getDefaultElevatedFilterChipColors$material3_release(MaterialTheme.INSTANCE.getColorScheme($composer, 6));
    }

    public final androidx.compose.material3.SelectableChipColors elevatedFilterChipColors-XqyqHi0(long containerColor, long labelColor, long iconColor, long disabledContainerColor, long disabledLabelColor, long disabledLeadingIconColor, long disabledTrailingIconColor, long selectedContainerColor, long disabledSelectedContainerColor, long selectedLabelColor, long selectedLeadingIconColor, long selectedTrailingIconColor, Composer $composer, int $changed, int $changed1, int i16) {
        Color.Companion companion;
        String traceInProgress;
        int unspecified-0d7_KjU7;
        int unspecified-0d7_KjU3;
        int unspecified-0d7_KjU10;
        int unspecified-0d7_KjU2;
        int unspecified-0d7_KjU;
        int unspecified-0d7_KjU11;
        int unspecified-0d7_KjU8;
        long unspecified-0d7_KjU4;
        long unspecified-0d7_KjU6;
        long unspecified-0d7_KjU5;
        long unspecified-0d7_KjU9;
        int i2;
        int i;
        long l3;
        long l5;
        long l6;
        long l8;
        long l10;
        long l2;
        long l9;
        long l;
        long l4;
        long l7;
        long l11;
        long l12;
        final Composer composer = obj57;
        int i3 = obj60;
        int i4 = -915841711;
        ComposerKt.sourceInformationMarkerStart(composer, i4, "C(elevatedFilterChipColors)P(0:c#ui.graphics.Color,7:c#ui.graphics.Color,6:c#ui.graphics.Color,1:c#ui.graphics.Color,2:c#ui.graphics.Color,3:c#ui.graphics.Color,5:c#ui.graphics.Color,8:c#ui.graphics.Color,4:c#ui.graphics.Color,9:c#ui.graphics.Color,10:c#ui.graphics.Color,11:c#ui.graphics.Color)1465@71739L11:Chip.kt#uh7d8r");
        if (i3 & 1 != 0) {
            l3 = unspecified-0d7_KjU7;
        } else {
            l3 = containerColor;
        }
        if (i3 & 2 != 0) {
            l5 = unspecified-0d7_KjU3;
        } else {
            l5 = iconColor;
        }
        if (i3 & 4 != 0) {
            l6 = unspecified-0d7_KjU10;
        } else {
            l6 = disabledLabelColor;
        }
        if (i3 & 8 != 0) {
            l8 = unspecified-0d7_KjU2;
        } else {
            l8 = disabledTrailingIconColor;
        }
        if (i3 & 16 != 0) {
            l10 = unspecified-0d7_KjU;
        } else {
            l10 = disabledSelectedContainerColor;
        }
        if (i3 & 32 != 0) {
            l2 = unspecified-0d7_KjU11;
        } else {
            l2 = selectedLeadingIconColor;
        }
        if (i3 & 64 != 0) {
            l9 = unspecified-0d7_KjU8;
        } else {
            l9 = $composer;
        }
        if (i3 & 128 != 0) {
            l = unspecified-0d7_KjU4;
        } else {
            l = $changed1;
        }
        if (i3 & 256 != 0) {
            l4 = unspecified-0d7_KjU6;
        } else {
            l4 = obj49;
        }
        if (i3 & 512 != 0) {
            l7 = unspecified-0d7_KjU5;
        } else {
            l7 = obj51;
        }
        if (i3 & 1024 != 0) {
            l11 = unspecified-0d7_KjU9;
        } else {
            l11 = obj53;
        }
        if (i3 &= 2048 != 0) {
            l12 = unspecified-0d7_KjU9;
        } else {
            l12 = obj55;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i4, obj58, obj59, "androidx.compose.material3.FilterChipDefaults.elevatedFilterChipColors (Chip.kt:1465)");
        } else {
            i2 = obj58;
            i = obj59;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return this.getDefaultElevatedFilterChipColors$material3_release(MaterialTheme.INSTANCE.getColorScheme(composer, 6)).copy-daRQuJA(l3, obj7, l5, obj9, l6, obj11, l6, obj13, l8, obj15, l10, obj17, l2);
    }

    public final androidx.compose.material3.SelectableChipElevation elevatedFilterChipElevation-aqJV_2Y(float elevation, float pressedElevation, float focusedElevation, float hoveredElevation, float draggedElevation, float disabledElevation, Composer $composer, int $changed, int i9) {
        FilterChipTokens iNSTANCE;
        float f;
        float f2;
        float f4;
        float f6;
        float f5;
        float f3;
        float obj12;
        float obj13;
        float obj14;
        final int i = 684803697;
        final Composer composer = $composer;
        ComposerKt.sourceInformationMarkerStart(composer, i, "C(elevatedFilterChipElevation)P(2:c#ui.unit.Dp,5:c#ui.unit.Dp,3:c#ui.unit.Dp,4:c#ui.unit.Dp,1:c#ui.unit.Dp,0:c#ui.unit.Dp):Chip.kt#uh7d8r");
        if (i9 & 1 != 0) {
            f = obj12;
        } else {
            f = elevation;
        }
        if (i9 & 2 != 0) {
            f2 = obj13;
        } else {
            f2 = pressedElevation;
        }
        if (i9 & 4 != 0) {
            f4 = obj14;
        } else {
            f4 = focusedElevation;
        }
        if (i9 & 8 != 0) {
            f6 = obj12;
        } else {
            f6 = hoveredElevation;
        }
        if (i9 & 16 != 0) {
            f5 = obj12;
        } else {
            f5 = draggedElevation;
        }
        if (i9 & 32 != 0) {
            f3 = obj12;
        } else {
            f3 = disabledElevation;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i, $changed, -1, "androidx.compose.material3.FilterChipDefaults.elevatedFilterChipElevation (Chip.kt:1536)");
        } else {
            obj14 = $changed;
        }
        SelectableChipElevation selectableChipElevation = new SelectableChipElevation(f, f2, f4, f6, f5, f3, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return selectableChipElevation;
    }

    public final BorderStroke filterChipBorder-_7El2pE(boolean enabled, boolean selected, long borderColor, long selectedBorderColor, long disabledBorderColor, long disabledSelectedBorderColor, float borderWidth, float selectedBorderWidth, Composer $composer, int $changed, int i11) {
        float selectedBorderWidth2;
        float f;
        int flatUnselectedOutlineColor;
        int companion;
        long disabledBorderColor2;
        long borderColor2;
        long selectedBorderColor2;
        long value;
        long disabledSelectedBorderColor2;
        float flatDisabledUnselectedOutlineOpacity;
        float borderWidth2;
        int i5;
        boolean traceInProgress;
        long l;
        int str;
        int i3;
        int i;
        int i2;
        int i4;
        final Composer composer = obj30;
        int i6 = obj32;
        int i8 = -1138342447;
        ComposerKt.sourceInformationMarkerStart(composer, i8, "C(filterChipBorder)P(4,5,0:c#ui.graphics.Color,6:c#ui.graphics.Color,2:c#ui.graphics.Color,3:c#ui.graphics.Color,1:c#ui.unit.Dp,7:c#ui.unit.Dp)1406@68670L5,1409@68834L5:Chip.kt#uh7d8r");
        final int i10 = 6;
        if (i6 & 4 != 0) {
            borderColor2 = ColorSchemeKt.getValue(FilterChipTokens.INSTANCE.getFlatUnselectedOutlineColor(), composer, i10);
        } else {
            borderColor2 = borderColor;
        }
        if (i6 & 8 != 0) {
            selectedBorderColor2 = Color.Companion.getTransparent-0d7_KjU();
        } else {
            selectedBorderColor2 = disabledBorderColor;
        }
        if (i6 & 16 != 0) {
            disabledBorderColor2 = Color.copy-wmQWz5c$default(ColorSchemeKt.getValue(FilterChipTokens.INSTANCE.getFlatDisabledUnselectedOutlineColor(), composer, i10), obj10, FilterChipTokens.INSTANCE.getFlatDisabledUnselectedOutlineOpacity(), 0, 0, 0, 14);
        } else {
            disabledBorderColor2 = borderWidth;
        }
        if (i6 & 32 != 0) {
            disabledSelectedBorderColor2 = Color.Companion.getTransparent-0d7_KjU();
        } else {
            disabledSelectedBorderColor2 = $composer;
        }
        if (i6 & 64 != 0) {
            borderWidth2 = FilterChipTokens.INSTANCE.getFlatUnselectedOutlineWidth-D9Ej5fM();
        } else {
            borderWidth2 = i11;
        }
        if (i6 &= 128 != 0) {
            selectedBorderWidth2 = FilterChipTokens.INSTANCE.getFlatSelectedOutlineWidth-D9Ej5fM();
        } else {
            selectedBorderWidth2 = obj29;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i8, obj31, -1, "androidx.compose.material3.FilterChipDefaults.filterChipBorder (Chip.kt:1415)");
        } else {
            i = obj31;
        }
        if (enabled) {
            l = selected ? selectedBorderColor2 : borderColor2;
        } else {
            l = selected ? disabledSelectedBorderColor2 : disabledBorderColor2;
        }
        f = selected ? selectedBorderWidth2 : borderWidth2;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return BorderStrokeKt.BorderStroke-cXLIe8U(f, l);
    }

    public final androidx.compose.material3.SelectableChipColors filterChipColors(Composer $composer, int $changed) {
        boolean traceInProgress;
        String str;
        int i = -1743772077;
        ComposerKt.sourceInformationMarkerStart($composer, i, "C(filterChipColors)1273@61089L11:Chip.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i, $changed, -1, "androidx.compose.material3.FilterChipDefaults.filterChipColors (Chip.kt:1273)");
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return getDefaultFilterChipColors$material3_release(MaterialTheme.INSTANCE.getColorScheme($composer, 6));
    }

    public final androidx.compose.material3.SelectableChipColors filterChipColors-XqyqHi0(long containerColor, long labelColor, long iconColor, long disabledContainerColor, long disabledLabelColor, long disabledLeadingIconColor, long disabledTrailingIconColor, long selectedContainerColor, long disabledSelectedContainerColor, long selectedLabelColor, long selectedLeadingIconColor, long selectedTrailingIconColor, Composer $composer, int $changed, int $changed1, int i16) {
        Color.Companion companion;
        String traceInProgress;
        int unspecified-0d7_KjU11;
        int unspecified-0d7_KjU10;
        int unspecified-0d7_KjU9;
        int unspecified-0d7_KjU2;
        int unspecified-0d7_KjU7;
        int unspecified-0d7_KjU4;
        int unspecified-0d7_KjU6;
        long unspecified-0d7_KjU3;
        long unspecified-0d7_KjU5;
        long unspecified-0d7_KjU;
        long unspecified-0d7_KjU8;
        int i2;
        int i;
        long l7;
        long l2;
        long l3;
        long l11;
        long l4;
        long l5;
        long l;
        long l6;
        long l8;
        long l12;
        long l9;
        long l10;
        final Composer composer = obj57;
        int i3 = obj60;
        int i4 = -1831479801;
        ComposerKt.sourceInformationMarkerStart(composer, i4, "C(filterChipColors)P(0:c#ui.graphics.Color,7:c#ui.graphics.Color,6:c#ui.graphics.Color,1:c#ui.graphics.Color,2:c#ui.graphics.Color,3:c#ui.graphics.Color,5:c#ui.graphics.Color,8:c#ui.graphics.Color,4:c#ui.graphics.Color,9:c#ui.graphics.Color,10:c#ui.graphics.Color,11:c#ui.graphics.Color)1308@63087L11:Chip.kt#uh7d8r");
        if (i3 & 1 != 0) {
            l7 = unspecified-0d7_KjU11;
        } else {
            l7 = containerColor;
        }
        if (i3 & 2 != 0) {
            l2 = unspecified-0d7_KjU10;
        } else {
            l2 = iconColor;
        }
        if (i3 & 4 != 0) {
            l3 = unspecified-0d7_KjU9;
        } else {
            l3 = disabledLabelColor;
        }
        if (i3 & 8 != 0) {
            l11 = unspecified-0d7_KjU2;
        } else {
            l11 = disabledTrailingIconColor;
        }
        if (i3 & 16 != 0) {
            l4 = unspecified-0d7_KjU7;
        } else {
            l4 = disabledSelectedContainerColor;
        }
        if (i3 & 32 != 0) {
            l5 = unspecified-0d7_KjU4;
        } else {
            l5 = selectedLeadingIconColor;
        }
        if (i3 & 64 != 0) {
            l = unspecified-0d7_KjU6;
        } else {
            l = $composer;
        }
        if (i3 & 128 != 0) {
            l6 = unspecified-0d7_KjU3;
        } else {
            l6 = $changed1;
        }
        if (i3 & 256 != 0) {
            l8 = unspecified-0d7_KjU5;
        } else {
            l8 = obj49;
        }
        if (i3 & 512 != 0) {
            l12 = unspecified-0d7_KjU;
        } else {
            l12 = obj51;
        }
        if (i3 & 1024 != 0) {
            l9 = unspecified-0d7_KjU8;
        } else {
            l9 = obj53;
        }
        if (i3 &= 2048 != 0) {
            l10 = unspecified-0d7_KjU8;
        } else {
            l10 = obj55;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i4, obj58, obj59, "androidx.compose.material3.FilterChipDefaults.filterChipColors (Chip.kt:1308)");
        } else {
            i2 = obj58;
            i = obj59;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return this.getDefaultFilterChipColors$material3_release(MaterialTheme.INSTANCE.getColorScheme(composer, 6)).copy-daRQuJA(l7, obj7, l2, obj9, l3, obj11, l3, obj13, l11, obj15, l4, obj17, l5);
    }

    public final androidx.compose.material3.SelectableChipElevation filterChipElevation-aqJV_2Y(float elevation, float pressedElevation, float focusedElevation, float hoveredElevation, float draggedElevation, float disabledElevation, Composer $composer, int $changed, int i9) {
        FilterChipTokens iNSTANCE;
        float f6;
        float f2;
        float f;
        float f5;
        float f4;
        float f3;
        float obj12;
        float obj13;
        float obj14;
        final int i = -757972185;
        final Composer composer = $composer;
        ComposerKt.sourceInformationMarkerStart(composer, i, "C(filterChipElevation)P(2:c#ui.unit.Dp,5:c#ui.unit.Dp,3:c#ui.unit.Dp,4:c#ui.unit.Dp,1:c#ui.unit.Dp,0:c#ui.unit.Dp):Chip.kt#uh7d8r");
        if (i9 & 1 != 0) {
            f6 = obj12;
        } else {
            f6 = elevation;
        }
        if (i9 & 2 != 0) {
            f2 = obj13;
        } else {
            f2 = pressedElevation;
        }
        if (i9 & 4 != 0) {
            f = obj14;
        } else {
            f = focusedElevation;
        }
        if (i9 & 8 != 0) {
            f5 = obj12;
        } else {
            f5 = hoveredElevation;
        }
        if (i9 & 16 != 0) {
            f4 = obj12;
        } else {
            f4 = draggedElevation;
        }
        f3 = i9 & 32 != 0 ? obj12 : disabledElevation;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i, $changed, -1, "androidx.compose.material3.FilterChipDefaults.filterChipElevation (Chip.kt:1378)");
        } else {
            obj14 = $changed;
        }
        SelectableChipElevation selectableChipElevation = new SelectableChipElevation(f6, f2, f, f5, f4, f3, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return selectableChipElevation;
    }

    public final androidx.compose.material3.SelectableChipColors getDefaultElevatedFilterChipColors$material3_release(androidx.compose.material3.ColorScheme $this$defaultElevatedFilterChipColors) {
        androidx.compose.material3.SelectableChipColors defaultElevatedFilterChipColorsCached$material3_release;
        androidx.compose.material3.SelectableChipColors selectableChipColors;
        int i6;
        long token7;
        long token5;
        long token3;
        long copy-wmQWz5c$default4;
        long copy-wmQWz5c$default2;
        int i;
        long copy-wmQWz5c$default;
        int i7;
        long copy-wmQWz5c$default5;
        int i5;
        long token2;
        int i8;
        long copy-wmQWz5c$default3;
        int i10;
        long token4;
        int i2;
        long token6;
        int i3;
        long token;
        int i9;
        int i4;
        final androidx.compose.material3.ColorScheme colorScheme = $this$defaultElevatedFilterChipColors;
        if (colorScheme.getDefaultElevatedFilterChipColorsCached$material3_release() == null) {
            i = 0;
            i7 = 0;
            i5 = 0;
            i8 = 0;
            i10 = 0;
            i9 = 0;
            i2 = 0;
            i3 = 0;
            selectableChipColors = new SelectableChipColors(ColorSchemeKt.fromToken(colorScheme, FilterChipTokens.INSTANCE.getElevatedUnselectedContainerColor()), obj4, ColorSchemeKt.fromToken(colorScheme, FilterChipTokens.INSTANCE.getUnselectedLabelTextColor()), obj6, ColorSchemeKt.fromToken(colorScheme, FilterChipTokens.INSTANCE.getUnselectedLeadingIconColor()), obj8, ColorSchemeKt.fromToken(colorScheme, FilterChipTokens.INSTANCE.getUnselectedLeadingIconColor()), obj10, Color.copy-wmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, FilterChipTokens.INSTANCE.getElevatedDisabledContainerColor()), obj12, FilterChipTokens.INSTANCE.getElevatedDisabledContainerOpacity(), i, 0, i7, 14), obj12, Color.copy-wmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, FilterChipTokens.INSTANCE.getDisabledLabelTextColor()), i, FilterChipTokens.INSTANCE.getDisabledLabelTextOpacity(), i7, 0, i5, 14), i, Color.copy-wmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, FilterChipTokens.INSTANCE.getDisabledLeadingIconColor()), i7, FilterChipTokens.INSTANCE.getDisabledLeadingIconOpacity(), i5, 0, i8, 14), i7, Color.copy-wmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, FilterChipTokens.INSTANCE.getDisabledLeadingIconColor()), i5, FilterChipTokens.INSTANCE.getDisabledLeadingIconOpacity(), i8, 0, i10, 14), i5, ColorSchemeKt.fromToken(colorScheme, FilterChipTokens.INSTANCE.getElevatedSelectedContainerColor()), i8, Color.copy-wmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, FilterChipTokens.INSTANCE.getElevatedDisabledContainerColor()), i10, FilterChipTokens.INSTANCE.getElevatedDisabledContainerOpacity(), i2, 0, i3, 14), i10, ColorSchemeKt.fromToken(colorScheme, FilterChipTokens.INSTANCE.getSelectedLabelTextColor()), i2, ColorSchemeKt.fromToken(colorScheme, FilterChipTokens.INSTANCE.getSelectedLeadingIconColor()), i3, ColorSchemeKt.fromToken(colorScheme, FilterChipTokens.INSTANCE.getSelectedLeadingIconColor()), i9, 0);
            i6 = 0;
            colorScheme.setDefaultElevatedFilterChipColorsCached$material3_release(selectableChipColors);
        }
        return defaultElevatedFilterChipColorsCached$material3_release;
    }

    public final androidx.compose.material3.SelectableChipColors getDefaultFilterChipColors$material3_release(androidx.compose.material3.ColorScheme $this$defaultFilterChipColors) {
        androidx.compose.material3.SelectableChipColors defaultFilterChipColorsCached$material3_release;
        androidx.compose.material3.SelectableChipColors selectableChipColors;
        int i2;
        long token3;
        long token7;
        long token;
        long transparent-0d7_KjU;
        long copy-wmQWz5c$default;
        long copy-wmQWz5c$default2;
        int i3;
        long copy-wmQWz5c$default3;
        int i9;
        long token5;
        int i4;
        long copy-wmQWz5c$default4;
        int i5;
        long token2;
        int i8;
        long token4;
        int i6;
        long token6;
        int i7;
        int i;
        final androidx.compose.material3.ColorScheme colorScheme = $this$defaultFilterChipColors;
        if (colorScheme.getDefaultFilterChipColorsCached$material3_release() == null) {
            i3 = 0;
            i9 = 0;
            i4 = 0;
            i5 = 0;
            i7 = 0;
            i8 = 0;
            i6 = 0;
            selectableChipColors = new SelectableChipColors(Color.Companion.getTransparent-0d7_KjU(), obj4, ColorSchemeKt.fromToken(colorScheme, FilterChipTokens.INSTANCE.getUnselectedLabelTextColor()), obj6, ColorSchemeKt.fromToken(colorScheme, FilterChipTokens.INSTANCE.getUnselectedLeadingIconColor()), obj8, ColorSchemeKt.fromToken(colorScheme, FilterChipTokens.INSTANCE.getUnselectedLeadingIconColor()), obj10, Color.Companion.getTransparent-0d7_KjU(), obj12, Color.copy-wmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, FilterChipTokens.INSTANCE.getDisabledLabelTextColor()), obj14, FilterChipTokens.INSTANCE.getDisabledLabelTextOpacity(), i3, 0, i9, 14), obj14, Color.copy-wmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, FilterChipTokens.INSTANCE.getDisabledLeadingIconColor()), i3, FilterChipTokens.INSTANCE.getDisabledLeadingIconOpacity(), i9, 0, i4, 14), i3, Color.copy-wmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, FilterChipTokens.INSTANCE.getDisabledLeadingIconColor()), i9, FilterChipTokens.INSTANCE.getDisabledLeadingIconOpacity(), i4, 0, i5, 14), i9, ColorSchemeKt.fromToken(colorScheme, FilterChipTokens.INSTANCE.getFlatSelectedContainerColor()), i4, Color.copy-wmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, FilterChipTokens.INSTANCE.getFlatDisabledSelectedContainerColor()), i5, FilterChipTokens.INSTANCE.getFlatDisabledSelectedContainerOpacity(), i8, 0, i6, 14), i5, ColorSchemeKt.fromToken(colorScheme, FilterChipTokens.INSTANCE.getSelectedLabelTextColor()), i8, ColorSchemeKt.fromToken(colorScheme, FilterChipTokens.INSTANCE.getSelectedLeadingIconColor()), i6, ColorSchemeKt.fromToken(colorScheme, FilterChipTokens.INSTANCE.getSelectedLeadingIconColor()), i7, 0);
            i2 = 0;
            colorScheme.setDefaultFilterChipColorsCached$material3_release(selectableChipColors);
        }
        return defaultFilterChipColorsCached$material3_release;
    }

    public final float getHeight-D9Ej5fM() {
        return FilterChipDefaults.Height;
    }

    public final float getIconSize-D9Ej5fM() {
        return FilterChipDefaults.IconSize;
    }

    public final Shape getShape(Composer $composer, int $changed) {
        boolean traceInProgress;
        String str;
        int i = -1598643637;
        ComposerKt.sourceInformationMarkerStart($composer, i, "C1547@76563L5:Chip.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i, $changed, -1, "androidx.compose.material3.FilterChipDefaults.<get-shape> (Chip.kt:1547)");
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return ShapesKt.getValue(FilterChipTokens.INSTANCE.getContainerShape(), $composer, 6);
    }
}
