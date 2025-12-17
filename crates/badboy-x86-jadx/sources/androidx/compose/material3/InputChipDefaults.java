package androidx.compose.material3;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.BorderStrokeKt;
import androidx.compose.material3.tokens.InputChipTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Color.Companion;
import androidx.compose.ui.graphics.Shape;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0008\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0019\n\u0002\u0018\u0002\n\u0002\u0008\t\u0008Ç\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J^\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00182\u0008\u0008\u0002\u0010\u001a\u001a\u00020\u001b2\u0008\u0008\u0002\u0010\u001c\u001a\u00020\u001b2\u0008\u0008\u0002\u0010\u001d\u001a\u00020\u001b2\u0008\u0008\u0002\u0010\u001e\u001a\u00020\u001b2\u0008\u0008\u0002\u0010\u001f\u001a\u00020\u00042\u0008\u0008\u0002\u0010 \u001a\u00020\u0004H\u0007ø\u0001\u0000¢\u0006\u0004\u0008!\u0010\"J\r\u0010#\u001a\u00020\u0011H\u0007¢\u0006\u0002\u0010$J\u0094\u0001\u0010#\u001a\u00020\u00112\u0008\u0008\u0002\u0010%\u001a\u00020\u001b2\u0008\u0008\u0002\u0010&\u001a\u00020\u001b2\u0008\u0008\u0002\u0010'\u001a\u00020\u001b2\u0008\u0008\u0002\u0010(\u001a\u00020\u001b2\u0008\u0008\u0002\u0010)\u001a\u00020\u001b2\u0008\u0008\u0002\u0010*\u001a\u00020\u001b2\u0008\u0008\u0002\u0010+\u001a\u00020\u001b2\u0008\u0008\u0002\u0010,\u001a\u00020\u001b2\u0008\u0008\u0002\u0010-\u001a\u00020\u001b2\u0008\u0008\u0002\u0010.\u001a\u00020\u001b2\u0008\u0008\u0002\u0010/\u001a\u00020\u001b2\u0008\u0008\u0002\u00100\u001a\u00020\u001b2\u0008\u0008\u0002\u00101\u001a\u00020\u001bH\u0007ø\u0001\u0000¢\u0006\u0004\u00082\u00103JN\u00104\u001a\u0002052\u0008\u0008\u0002\u00106\u001a\u00020\u00042\u0008\u0008\u0002\u00107\u001a\u00020\u00042\u0008\u0008\u0002\u00108\u001a\u00020\u00042\u0008\u0008\u0002\u00109\u001a\u00020\u00042\u0008\u0008\u0002\u0010:\u001a\u00020\u00042\u0008\u0008\u0002\u0010;\u001a\u00020\u0004H\u0007ø\u0001\u0000¢\u0006\u0004\u0008<\u0010=R\u0019\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\u0008\u0005\u0010\u0006R\u0019\u0010\u0008\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\u0008\t\u0010\u0006R\u0019\u0010\n\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\u0008\u000b\u0010\u0006R\u0011\u0010\u000c\u001a\u00020\r8G¢\u0006\u0006\u001a\u0004\u0008\u000e\u0010\u000fR\u0018\u0010\u0010\u001a\u00020\u0011*\u00020\u00128@X\u0080\u0004¢\u0006\u0006\u001a\u0004\u0008\u0013\u0010\u0014\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006>", d2 = {"Landroidx/compose/material3/InputChipDefaults;", "", "()V", "AvatarSize", "Landroidx/compose/ui/unit/Dp;", "getAvatarSize-D9Ej5fM", "()F", "F", "Height", "getHeight-D9Ej5fM", "IconSize", "getIconSize-D9Ej5fM", "shape", "Landroidx/compose/ui/graphics/Shape;", "getShape", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/graphics/Shape;", "defaultInputChipColors", "Landroidx/compose/material3/SelectableChipColors;", "Landroidx/compose/material3/ColorScheme;", "getDefaultInputChipColors$material3_release", "(Landroidx/compose/material3/ColorScheme;)Landroidx/compose/material3/SelectableChipColors;", "inputChipBorder", "Landroidx/compose/foundation/BorderStroke;", "enabled", "", "selected", "borderColor", "Landroidx/compose/ui/graphics/Color;", "selectedBorderColor", "disabledBorderColor", "disabledSelectedBorderColor", "borderWidth", "selectedBorderWidth", "inputChipBorder-_7El2pE", "(ZZJJJJFFLandroidx/compose/runtime/Composer;II)Landroidx/compose/foundation/BorderStroke;", "inputChipColors", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/material3/SelectableChipColors;", "containerColor", "labelColor", "leadingIconColor", "trailingIconColor", "disabledContainerColor", "disabledLabelColor", "disabledLeadingIconColor", "disabledTrailingIconColor", "selectedContainerColor", "disabledSelectedContainerColor", "selectedLabelColor", "selectedLeadingIconColor", "selectedTrailingIconColor", "inputChipColors-kwJvTHA", "(JJJJJJJJJJJJJLandroidx/compose/runtime/Composer;III)Landroidx/compose/material3/SelectableChipColors;", "inputChipElevation", "Landroidx/compose/material3/SelectableChipElevation;", "elevation", "pressedElevation", "focusedElevation", "hoveredElevation", "draggedElevation", "disabledElevation", "inputChipElevation-aqJV_2Y", "(FFFFFFLandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/SelectableChipElevation;", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class InputChipDefaults {

    public static final int $stable;
    private static final float AvatarSize;
    private static final float Height;
    public static final androidx.compose.material3.InputChipDefaults INSTANCE;
    private static final float IconSize;
    static {
        InputChipDefaults inputChipDefaults = new InputChipDefaults();
        InputChipDefaults.INSTANCE = inputChipDefaults;
        InputChipDefaults.Height = InputChipTokens.INSTANCE.getContainerHeight-D9Ej5fM();
        InputChipDefaults.IconSize = InputChipTokens.INSTANCE.getLeadingIconSize-D9Ej5fM();
        InputChipDefaults.AvatarSize = InputChipTokens.INSTANCE.getAvatarSize-D9Ej5fM();
    }

    public final float getAvatarSize-D9Ej5fM() {
        return InputChipDefaults.AvatarSize;
    }

    public final androidx.compose.material3.SelectableChipColors getDefaultInputChipColors$material3_release(androidx.compose.material3.ColorScheme $this$defaultInputChipColors) {
        androidx.compose.material3.SelectableChipColors defaultInputChipColorsCached$material3_release;
        androidx.compose.material3.SelectableChipColors selectableChipColors;
        int i4;
        long token6;
        long token7;
        long token4;
        long transparent-0d7_KjU;
        long copy-wmQWz5c$default3;
        long copy-wmQWz5c$default4;
        int i7;
        long copy-wmQWz5c$default2;
        int i2;
        long token3;
        int i8;
        long copy-wmQWz5c$default;
        int i9;
        long token;
        int i5;
        long token5;
        int i3;
        long token2;
        int i;
        int i6;
        final androidx.compose.material3.ColorScheme colorScheme = $this$defaultInputChipColors;
        if (colorScheme.getDefaultInputChipColorsCached$material3_release() == null) {
            i7 = 0;
            i2 = 0;
            i8 = 0;
            i9 = 0;
            i = 0;
            i5 = 0;
            i3 = 0;
            selectableChipColors = new SelectableChipColors(Color.Companion.getTransparent-0d7_KjU(), obj4, ColorSchemeKt.fromToken(colorScheme, InputChipTokens.INSTANCE.getUnselectedLabelTextColor()), obj6, ColorSchemeKt.fromToken(colorScheme, InputChipTokens.INSTANCE.getUnselectedLeadingIconColor()), obj8, ColorSchemeKt.fromToken(colorScheme, InputChipTokens.INSTANCE.getUnselectedTrailingIconColor()), obj10, Color.Companion.getTransparent-0d7_KjU(), obj12, Color.copy-wmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, InputChipTokens.INSTANCE.getDisabledLabelTextColor()), obj14, 1052938076, i7, 0, i2, 14), obj14, Color.copy-wmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, InputChipTokens.INSTANCE.getDisabledLeadingIconColor()), i7, 1052938076, i2, 0, i8, 14), i7, Color.copy-wmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, InputChipTokens.INSTANCE.getDisabledTrailingIconColor()), i2, 1052938076, i8, 0, i9, 14), i2, ColorSchemeKt.fromToken(colorScheme, InputChipTokens.INSTANCE.getSelectedContainerColor()), i8, Color.copy-wmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, InputChipTokens.INSTANCE.getDisabledSelectedContainerColor()), i9, 1039516303, i5, 0, i3, 14), i9, ColorSchemeKt.fromToken(colorScheme, InputChipTokens.INSTANCE.getSelectedLabelTextColor()), i5, ColorSchemeKt.fromToken(colorScheme, InputChipTokens.INSTANCE.getSelectedLeadingIconColor()), i3, ColorSchemeKt.fromToken(colorScheme, InputChipTokens.INSTANCE.getSelectedTrailingIconColor()), i, 0);
            i4 = 0;
            colorScheme.setDefaultInputChipColorsCached$material3_release(selectableChipColors);
        }
        return defaultInputChipColorsCached$material3_release;
    }

    public final float getHeight-D9Ej5fM() {
        return InputChipDefaults.Height;
    }

    public final float getIconSize-D9Ej5fM() {
        return InputChipDefaults.IconSize;
    }

    public final Shape getShape(Composer $composer, int $changed) {
        boolean traceInProgress;
        String str;
        int i = 1052444143;
        ComposerKt.sourceInformationMarkerStart($composer, i, "C1721@85639L5:Chip.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i, $changed, -1, "androidx.compose.material3.InputChipDefaults.<get-shape> (Chip.kt:1721)");
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return ShapesKt.getValue(InputChipTokens.INSTANCE.getContainerShape(), $composer, 6);
    }

    public final BorderStroke inputChipBorder-_7El2pE(boolean enabled, boolean selected, long borderColor, long selectedBorderColor, long disabledBorderColor, long disabledSelectedBorderColor, float borderWidth, float selectedBorderWidth, Composer $composer, int $changed, int i11) {
        float selectedBorderWidth2;
        float f;
        int unselectedOutlineColor;
        int companion;
        long disabledBorderColor2;
        long borderColor2;
        long selectedBorderColor2;
        long value;
        long disabledSelectedBorderColor2;
        int i3;
        float borderWidth2;
        int i2;
        boolean traceInProgress;
        long l;
        int str;
        int i;
        int i4;
        int i5;
        int i6;
        final Composer composer = obj30;
        int i7 = obj32;
        int i9 = 2050575347;
        ComposerKt.sourceInformationMarkerStart(composer, i9, "C(inputChipBorder)P(4,5,0:c#ui.graphics.Color,6:c#ui.graphics.Color,2:c#ui.graphics.Color,3:c#ui.graphics.Color,1:c#ui.unit.Dp,7:c#ui.unit.Dp)1700@84707L5,1703@84866L5:Chip.kt#uh7d8r");
        final int i12 = 6;
        if (i7 & 4 != 0) {
            borderColor2 = ColorSchemeKt.getValue(InputChipTokens.INSTANCE.getUnselectedOutlineColor(), composer, i12);
        } else {
            borderColor2 = borderColor;
        }
        if (i7 & 8 != 0) {
            selectedBorderColor2 = Color.Companion.getTransparent-0d7_KjU();
        } else {
            selectedBorderColor2 = disabledBorderColor;
        }
        if (i7 & 16 != 0) {
            disabledBorderColor2 = Color.copy-wmQWz5c$default(ColorSchemeKt.getValue(InputChipTokens.INSTANCE.getDisabledUnselectedOutlineColor(), composer, i12), obj10, 1039516303, 0, 0, 0, 14);
        } else {
            disabledBorderColor2 = borderWidth;
        }
        if (i7 & 32 != 0) {
            disabledSelectedBorderColor2 = Color.Companion.getTransparent-0d7_KjU();
        } else {
            disabledSelectedBorderColor2 = $composer;
        }
        if (i7 & 64 != 0) {
            borderWidth2 = InputChipTokens.INSTANCE.getUnselectedOutlineWidth-D9Ej5fM();
        } else {
            borderWidth2 = i11;
        }
        if (i7 &= 128 != 0) {
            selectedBorderWidth2 = InputChipTokens.INSTANCE.getSelectedOutlineWidth-D9Ej5fM();
        } else {
            selectedBorderWidth2 = obj29;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i9, obj31, -1, "androidx.compose.material3.InputChipDefaults.inputChipBorder (Chip.kt:1709)");
        } else {
            i4 = obj31;
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

    public final androidx.compose.material3.SelectableChipColors inputChipColors(Composer $composer, int $changed) {
        boolean traceInProgress;
        String str;
        int i = -770375587;
        ComposerKt.sourceInformationMarkerStart($composer, i, "C(inputChipColors)1568@77247L11:Chip.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i, $changed, -1, "androidx.compose.material3.InputChipDefaults.inputChipColors (Chip.kt:1568)");
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return getDefaultInputChipColors$material3_release(MaterialTheme.INSTANCE.getColorScheme($composer, 6));
    }

    public final androidx.compose.material3.SelectableChipColors inputChipColors-kwJvTHA(long containerColor, long labelColor, long leadingIconColor, long trailingIconColor, long disabledContainerColor, long disabledLabelColor, long disabledLeadingIconColor, long disabledTrailingIconColor, long selectedContainerColor, long disabledSelectedContainerColor, long selectedLabelColor, long selectedLeadingIconColor, long selectedTrailingIconColor, Composer $composer, int $changed, int $changed1, int i17) {
        Color.Companion companion;
        String traceInProgress;
        int unspecified-0d7_KjU12;
        int unspecified-0d7_KjU6;
        int unspecified-0d7_KjU3;
        int unspecified-0d7_KjU2;
        int unspecified-0d7_KjU8;
        int unspecified-0d7_KjU9;
        int unspecified-0d7_KjU;
        long unspecified-0d7_KjU7;
        long unspecified-0d7_KjU11;
        long unspecified-0d7_KjU10;
        long unspecified-0d7_KjU5;
        long unspecified-0d7_KjU4;
        int i2;
        int i;
        long l11;
        long l2;
        long l12;
        long l;
        long l9;
        long l6;
        long l7;
        long l13;
        long l8;
        long l10;
        long l4;
        long l3;
        long l5;
        final Composer composer = obj59;
        int i3 = obj62;
        int i4 = 1312840646;
        ComposerKt.sourceInformationMarkerStart(composer, i4, "C(inputChipColors)P(0:c#ui.graphics.Color,6:c#ui.graphics.Color,7:c#ui.graphics.Color,12:c#ui.graphics.Color,1:c#ui.graphics.Color,2:c#ui.graphics.Color,3:c#ui.graphics.Color,5:c#ui.graphics.Color,8:c#ui.graphics.Color,4:c#ui.graphics.Color,9:c#ui.graphics.Color,10:c#ui.graphics.Color,11:c#ui.graphics.Color)1605@79387L11:Chip.kt#uh7d8r");
        if (i3 & 1 != 0) {
            l11 = unspecified-0d7_KjU12;
        } else {
            l11 = containerColor;
        }
        if (i3 & 2 != 0) {
            l2 = unspecified-0d7_KjU6;
        } else {
            l2 = leadingIconColor;
        }
        if (i3 & 4 != 0) {
            l12 = unspecified-0d7_KjU3;
        } else {
            l12 = disabledContainerColor;
        }
        if (i3 & 8 != 0) {
            l = unspecified-0d7_KjU2;
        } else {
            l = disabledLeadingIconColor;
        }
        if (i3 & 16 != 0) {
            l9 = unspecified-0d7_KjU8;
        } else {
            l9 = selectedContainerColor;
        }
        if (i3 & 32 != 0) {
            l6 = unspecified-0d7_KjU9;
        } else {
            l6 = selectedLabelColor;
        }
        if (i3 & 64 != 0) {
            l7 = unspecified-0d7_KjU;
        } else {
            l7 = selectedTrailingIconColor;
        }
        if (i3 & 128 != 0) {
            l13 = unspecified-0d7_KjU7;
        } else {
            l13 = $changed;
        }
        if (i3 & 256 != 0) {
            l8 = unspecified-0d7_KjU11;
        } else {
            l8 = i17;
        }
        if (i3 & 512 != 0) {
            l10 = unspecified-0d7_KjU10;
        } else {
            l10 = obj51;
        }
        if (i3 & 1024 != 0) {
            l4 = unspecified-0d7_KjU5;
        } else {
            l4 = obj53;
        }
        if (i3 & 2048 != 0) {
            l3 = unspecified-0d7_KjU4;
        } else {
            l3 = obj55;
        }
        if (i3 &= 4096 != 0) {
            l5 = unspecified-0d7_KjU4;
        } else {
            l5 = obj57;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i4, obj60, obj61, "androidx.compose.material3.InputChipDefaults.inputChipColors (Chip.kt:1605)");
        } else {
            i2 = obj60;
            i = obj61;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return this.getDefaultInputChipColors$material3_release(MaterialTheme.INSTANCE.getColorScheme(composer, 6)).copy-daRQuJA(l11, obj7, l2, obj9, l12, obj11, l, obj13, l9, obj15, l6, obj17, l7);
    }

    public final androidx.compose.material3.SelectableChipElevation inputChipElevation-aqJV_2Y(float elevation, float pressedElevation, float focusedElevation, float hoveredElevation, float draggedElevation, float disabledElevation, Composer $composer, int $changed, int i9) {
        InputChipTokens iNSTANCE;
        float f4;
        float f6;
        float f;
        float f5;
        float f2;
        float f3;
        float obj12;
        float obj13;
        float obj14;
        final int i = 1745270109;
        final Composer composer = $composer;
        ComposerKt.sourceInformationMarkerStart(composer, i, "C(inputChipElevation)P(2:c#ui.unit.Dp,5:c#ui.unit.Dp,3:c#ui.unit.Dp,4:c#ui.unit.Dp,1:c#ui.unit.Dp,0:c#ui.unit.Dp):Chip.kt#uh7d8r");
        if (i9 & 1 != 0) {
            f4 = obj12;
        } else {
            f4 = elevation;
        }
        f6 = i9 & 2 != 0 ? obj13 : pressedElevation;
        f = i9 & 4 != 0 ? obj14 : focusedElevation;
        f5 = i9 & 8 != 0 ? obj12 : hoveredElevation;
        if (i9 & 16 != 0) {
            f2 = obj12;
        } else {
            f2 = draggedElevation;
        }
        f3 = i9 & 32 != 0 ? obj12 : disabledElevation;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i, $changed, -1, "androidx.compose.material3.InputChipDefaults.inputChipElevation (Chip.kt:1672)");
        } else {
            obj14 = $changed;
        }
        SelectableChipElevation selectableChipElevation = new SelectableChipElevation(f4, f6, f, f5, f2, f3, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return selectableChipElevation;
    }
}
