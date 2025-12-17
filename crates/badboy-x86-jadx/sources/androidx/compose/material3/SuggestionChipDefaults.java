package androidx.compose.material3;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.BorderStrokeKt;
import androidx.compose.material3.tokens.AssistChipTokens;
import androidx.compose.material3.tokens.SuggestionChipTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Color.Companion;
import androidx.compose.ui.graphics.Shape;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0008\n\u0002\u0018\u0002\n\u0002\u0008\t\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0007\u0008Ç\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\r\u0010\u0013\u001a\u00020\u000fH\u0007¢\u0006\u0002\u0010\u0014JN\u0010\u0013\u001a\u00020\u000f2\u0008\u0008\u0002\u0010\u0015\u001a\u00020\u00162\u0008\u0008\u0002\u0010\u0017\u001a\u00020\u00162\u0008\u0008\u0002\u0010\u0018\u001a\u00020\u00162\u0008\u0008\u0002\u0010\u0019\u001a\u00020\u00162\u0008\u0008\u0002\u0010\u001a\u001a\u00020\u00162\u0008\u0008\u0002\u0010\u001b\u001a\u00020\u0016H\u0007ø\u0001\u0000¢\u0006\u0004\u0008\u001c\u0010\u001dJN\u0010\u001e\u001a\u00020\u001f2\u0008\u0008\u0002\u0010 \u001a\u00020\u00042\u0008\u0008\u0002\u0010!\u001a\u00020\u00042\u0008\u0008\u0002\u0010\"\u001a\u00020\u00042\u0008\u0008\u0002\u0010#\u001a\u00020\u00042\u0008\u0008\u0002\u0010$\u001a\u00020\u00042\u0008\u0008\u0002\u0010%\u001a\u00020\u0004H\u0007ø\u0001\u0000¢\u0006\u0004\u0008&\u0010'J0\u0010(\u001a\u00020)2\u0008\u0008\u0002\u0010*\u001a\u00020\u00162\u0008\u0008\u0002\u0010+\u001a\u00020\u00162\u0008\u0008\u0002\u0010,\u001a\u00020\u0004H\u0007ø\u0001\u0000¢\u0006\u0004\u0008-\u0010.J8\u0010(\u001a\u00020/2\u0006\u00100\u001a\u0002012\u0008\u0008\u0002\u0010*\u001a\u00020\u00162\u0008\u0008\u0002\u0010+\u001a\u00020\u00162\u0008\u0008\u0002\u0010,\u001a\u00020\u0004H\u0007ø\u0001\u0000¢\u0006\u0004\u00082\u00103J\r\u00104\u001a\u00020\u000fH\u0007¢\u0006\u0002\u0010\u0014JN\u00104\u001a\u00020\u000f2\u0008\u0008\u0002\u0010\u0015\u001a\u00020\u00162\u0008\u0008\u0002\u0010\u0017\u001a\u00020\u00162\u0008\u0008\u0002\u0010\u0018\u001a\u00020\u00162\u0008\u0008\u0002\u0010\u0019\u001a\u00020\u00162\u0008\u0008\u0002\u0010\u001a\u001a\u00020\u00162\u0008\u0008\u0002\u0010\u001b\u001a\u00020\u0016H\u0007ø\u0001\u0000¢\u0006\u0004\u00085\u0010\u001dJN\u00106\u001a\u00020\u001f2\u0008\u0008\u0002\u0010 \u001a\u00020\u00042\u0008\u0008\u0002\u0010!\u001a\u00020\u00042\u0008\u0008\u0002\u0010\"\u001a\u00020\u00042\u0008\u0008\u0002\u0010#\u001a\u00020\u00042\u0008\u0008\u0002\u0010$\u001a\u00020\u00042\u0008\u0008\u0002\u0010%\u001a\u00020\u0004H\u0007ø\u0001\u0000¢\u0006\u0004\u00087\u0010'R\u0019\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\u0008\u0005\u0010\u0006R\u0019\u0010\u0008\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\u0008\t\u0010\u0006R\u0011\u0010\n\u001a\u00020\u000b8G¢\u0006\u0006\u001a\u0004\u0008\u000c\u0010\rR\u0018\u0010\u000e\u001a\u00020\u000f*\u00020\u00108@X\u0080\u0004¢\u0006\u0006\u001a\u0004\u0008\u0011\u0010\u0012\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u00068", d2 = {"Landroidx/compose/material3/SuggestionChipDefaults;", "", "()V", "Height", "Landroidx/compose/ui/unit/Dp;", "getHeight-D9Ej5fM", "()F", "F", "IconSize", "getIconSize-D9Ej5fM", "shape", "Landroidx/compose/ui/graphics/Shape;", "getShape", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/graphics/Shape;", "defaultElevatedSuggestionChipColors", "Landroidx/compose/material3/ChipColors;", "Landroidx/compose/material3/ColorScheme;", "getDefaultElevatedSuggestionChipColors$material3_release", "(Landroidx/compose/material3/ColorScheme;)Landroidx/compose/material3/ChipColors;", "elevatedSuggestionChipColors", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/material3/ChipColors;", "containerColor", "Landroidx/compose/ui/graphics/Color;", "labelColor", "iconContentColor", "disabledContainerColor", "disabledLabelColor", "disabledIconContentColor", "elevatedSuggestionChipColors-5tl4gsc", "(JJJJJJLandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/ChipColors;", "elevatedSuggestionChipElevation", "Landroidx/compose/material3/ChipElevation;", "elevation", "pressedElevation", "focusedElevation", "hoveredElevation", "draggedElevation", "disabledElevation", "elevatedSuggestionChipElevation-aqJV_2Y", "(FFFFFFLandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/ChipElevation;", "suggestionChipBorder", "Landroidx/compose/material3/ChipBorder;", "borderColor", "disabledBorderColor", "borderWidth", "suggestionChipBorder-d_3_b6Q", "(JJFLandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/ChipBorder;", "Landroidx/compose/foundation/BorderStroke;", "enabled", "", "suggestionChipBorder-h1eT-Ww", "(ZJJFLandroidx/compose/runtime/Composer;II)Landroidx/compose/foundation/BorderStroke;", "suggestionChipColors", "suggestionChipColors-5tl4gsc", "suggestionChipElevation", "suggestionChipElevation-aqJV_2Y", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class SuggestionChipDefaults {

    public static final int $stable;
    private static final float Height;
    public static final androidx.compose.material3.SuggestionChipDefaults INSTANCE;
    private static final float IconSize;
    static {
        SuggestionChipDefaults suggestionChipDefaults = new SuggestionChipDefaults();
        SuggestionChipDefaults.INSTANCE = suggestionChipDefaults;
        SuggestionChipDefaults.Height = SuggestionChipTokens.INSTANCE.getContainerHeight-D9Ej5fM();
        SuggestionChipDefaults.IconSize = SuggestionChipTokens.INSTANCE.getLeadingIconSize-D9Ej5fM();
    }

    public final androidx.compose.material3.ChipColors elevatedSuggestionChipColors(Composer $composer, int $changed) {
        boolean traceInProgress;
        String str;
        int i = 1671233087;
        ComposerKt.sourceInformationMarkerStart($composer, i, "C(elevatedSuggestionChipColors)1857@91554L11:Chip.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i, $changed, -1, "androidx.compose.material3.SuggestionChipDefaults.elevatedSuggestionChipColors (Chip.kt:1857)");
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return getDefaultElevatedSuggestionChipColors$material3_release(MaterialTheme.INSTANCE.getColorScheme($composer, 6));
    }

    public final androidx.compose.material3.ChipColors elevatedSuggestionChipColors-5tl4gsc(long containerColor, long labelColor, long iconContentColor, long disabledContainerColor, long disabledLabelColor, long disabledIconContentColor, Composer $composer, int $changed, int i9) {
        long unspecified-0d7_KjU;
        long unspecified-0d7_KjU6;
        long unspecified-0d7_KjU3;
        int unspecified-0d7_KjU2;
        int unspecified-0d7_KjU4;
        int unspecified-0d7_KjU5;
        boolean traceInProgress;
        String str;
        int i;
        long l4;
        long l5;
        long l2;
        long l6;
        long l3;
        long l;
        final Composer composer = obj34;
        int i2 = 1269423125;
        ComposerKt.sourceInformationMarkerStart(composer, i2, "C(elevatedSuggestionChipColors)P(0:c#ui.graphics.Color,5:c#ui.graphics.Color,4:c#ui.graphics.Color,1:c#ui.graphics.Color,3:c#ui.graphics.Color,2:c#ui.graphics.Color)1879@92652L11:Chip.kt#uh7d8r");
        if (obj36 & 1 != 0) {
            l4 = unspecified-0d7_KjU;
        } else {
            l4 = containerColor;
        }
        if (obj36 & 2 != 0) {
            l5 = unspecified-0d7_KjU6;
        } else {
            l5 = iconContentColor;
        }
        if (obj36 & 4 != 0) {
            l2 = unspecified-0d7_KjU3;
        } else {
            l2 = disabledLabelColor;
        }
        if (obj36 & 8 != 0) {
            l6 = unspecified-0d7_KjU2;
        } else {
            l6 = $composer;
        }
        if (obj36 & 16 != 0) {
            l3 = unspecified-0d7_KjU4;
        } else {
            l3 = i9;
        }
        if (obj36 & 32 != 0) {
            l = unspecified-0d7_KjU5;
        } else {
            l = obj32;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i2, obj35, -1, "androidx.compose.material3.SuggestionChipDefaults.elevatedSuggestionChipColors (Chip.kt:1879)");
        } else {
            i = obj35;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return this.getDefaultElevatedSuggestionChipColors$material3_release(MaterialTheme.INSTANCE.getColorScheme(composer, 6)).copy-FD3wquc(l4, obj6, l5, obj8, l2, obj10, Color.Companion.getUnspecified-0d7_KjU(), obj12);
    }

    public final androidx.compose.material3.ChipElevation elevatedSuggestionChipElevation-aqJV_2Y(float elevation, float pressedElevation, float focusedElevation, float hoveredElevation, float draggedElevation, float disabledElevation, Composer $composer, int $changed, int i9) {
        SuggestionChipTokens iNSTANCE;
        float f6;
        float f5;
        float f2;
        float f3;
        float f4;
        float f;
        float obj12;
        float obj13;
        float obj14;
        final int i = 1118088467;
        final Composer composer = $composer;
        ComposerKt.sourceInformationMarkerStart(composer, i, "C(elevatedSuggestionChipElevation)P(2:c#ui.unit.Dp,5:c#ui.unit.Dp,3:c#ui.unit.Dp,4:c#ui.unit.Dp,1:c#ui.unit.Dp,0:c#ui.unit.Dp):Chip.kt#uh7d8r");
        if (i9 & 1 != 0) {
            f6 = obj12;
        } else {
            f6 = elevation;
        }
        if (i9 & 2 != 0) {
            f5 = obj13;
        } else {
            f5 = pressedElevation;
        }
        if (i9 & 4 != 0) {
            f2 = obj14;
        } else {
            f2 = focusedElevation;
        }
        if (i9 & 8 != 0) {
            f3 = obj12;
        } else {
            f3 = hoveredElevation;
        }
        if (i9 & 16 != 0) {
            f4 = obj12;
        } else {
            f4 = draggedElevation;
        }
        if (i9 & 32 != 0) {
            f = obj12;
        } else {
            f = disabledElevation;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i, $changed, -1, "androidx.compose.material3.SuggestionChipDefaults.elevatedSuggestionChipElevation (Chip.kt:1932)");
        } else {
            obj14 = $changed;
        }
        ChipElevation chipElevation = new ChipElevation(f6, f5, f2, f3, f4, f, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return chipElevation;
    }

    public final androidx.compose.material3.ChipColors getDefaultElevatedSuggestionChipColors$material3_release(androidx.compose.material3.ColorScheme $this$defaultElevatedSuggestionChipColors) {
        androidx.compose.material3.ChipColors defaultElevatedSuggestionChipColorsCached$material3_release;
        androidx.compose.material3.ChipColors chipColors;
        int i4;
        long token2;
        long token;
        long unspecified-0d7_KjU2;
        long copy-wmQWz5c$default2;
        long copy-wmQWz5c$default3;
        int i8;
        long copy-wmQWz5c$default;
        int i3;
        long unspecified-0d7_KjU;
        int i6;
        int i7;
        int i5;
        int i2;
        int i;
        final androidx.compose.material3.ColorScheme colorScheme = $this$defaultElevatedSuggestionChipColors;
        if (colorScheme.getDefaultElevatedSuggestionChipColorsCached$material3_release() == null) {
            i8 = 0;
            i3 = 0;
            i6 = 0;
            chipColors = new ChipColors(ColorSchemeKt.fromToken(colorScheme, SuggestionChipTokens.INSTANCE.getElevatedContainerColor()), obj4, ColorSchemeKt.fromToken(colorScheme, SuggestionChipTokens.INSTANCE.getLabelTextColor()), obj6, ColorSchemeKt.fromToken(colorScheme, SuggestionChipTokens.INSTANCE.getLeadingIconColor()), obj8, Color.Companion.getUnspecified-0d7_KjU(), obj10, Color.copy-wmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, SuggestionChipTokens.INSTANCE.getElevatedDisabledContainerColor()), obj12, AssistChipTokens.INSTANCE.getElevatedDisabledContainerOpacity(), i8, 0, i3, 14), obj12, Color.copy-wmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, SuggestionChipTokens.INSTANCE.getDisabledLabelTextColor()), i8, SuggestionChipTokens.INSTANCE.getDisabledLabelTextOpacity(), i3, 0, i6, 14), i8, Color.copy-wmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, AssistChipTokens.INSTANCE.getDisabledIconColor()), i3, AssistChipTokens.INSTANCE.getDisabledIconOpacity(), i6, 0, 0, 14), i3, Color.Companion.getUnspecified-0d7_KjU(), i6, 0);
            i4 = 0;
            colorScheme.setDefaultElevatedSuggestionChipColorsCached$material3_release(chipColors);
        }
        return defaultElevatedSuggestionChipColorsCached$material3_release;
    }

    public final float getHeight-D9Ej5fM() {
        return SuggestionChipDefaults.Height;
    }

    public final float getIconSize-D9Ej5fM() {
        return SuggestionChipDefaults.IconSize;
    }

    public final Shape getShape(Composer $composer, int $changed) {
        boolean traceInProgress;
        String str;
        int i = 641188183;
        ComposerKt.sourceInformationMarkerStart($composer, i, "C1943@96240L5:Chip.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i, $changed, -1, "androidx.compose.material3.SuggestionChipDefaults.<get-shape> (Chip.kt:1943)");
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return ShapesKt.getValue(SuggestionChipTokens.INSTANCE.getContainerShape(), $composer, 6);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Maintained for binary compatibility. Use the suggestChipBorder functions instead", replaceWith = @ReplaceWith(...))
    public final androidx.compose.material3.ChipBorder suggestionChipBorder-d_3_b6Q(long borderColor, long disabledBorderColor, float borderWidth, Composer $composer, int $changed, int i6) {
        androidx.compose.material3.tokens.ColorSchemeKeyTokens flatOutlineColor;
        long copy-wmQWz5c$default;
        float flatOutlineWidth-D9Ej5fM;
        boolean traceInProgress;
        int str;
        long value;
        int i5;
        long l2;
        long l;
        float flatDisabledOutlineOpacity;
        float f;
        int i4;
        int i7;
        int i3;
        int i2;
        int i;
        final Composer composer = i6;
        int i8 = 439283919;
        ComposerKt.sourceInformationMarkerStart(composer, i8, "C(suggestionChipBorder)P(0:c#ui.graphics.Color,2:c#ui.graphics.Color,1:c#ui.unit.Dp)1838@90873L5,1840@90975L5:Chip.kt#uh7d8r");
        str = 6;
        if (obj25 & 1 != 0) {
            l2 = value;
        } else {
            l2 = borderColor;
        }
        if (obj25 & 2 != 0) {
            l = copy-wmQWz5c$default;
        } else {
            l = borderWidth;
        }
        if (obj25 & 4 != 0) {
            f = flatOutlineWidth-D9Ej5fM;
        } else {
            f = $changed;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i8, obj24, -1, "androidx.compose.material3.SuggestionChipDefaults.suggestionChipBorder (Chip.kt:1845)");
        } else {
            i5 = obj24;
        }
        ChipBorder chipBorder = new ChipBorder(l2, obj8, l, obj10, f, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return chipBorder;
    }

    public final BorderStroke suggestionChipBorder-h1eT-Ww(boolean enabled, long borderColor, long disabledBorderColor, float borderWidth, Composer $composer, int $changed, int i7) {
        androidx.compose.material3.tokens.ColorSchemeKeyTokens flatOutlineColor;
        long disabledBorderColor2;
        long borderColor2;
        long value;
        float borderWidth2;
        boolean traceInProgress;
        long l;
        float flatDisabledOutlineOpacity;
        int i5;
        int i4;
        int i6;
        int i;
        int i2;
        int i3;
        final Composer composer = i7;
        int i8 = -637354809;
        ComposerKt.sourceInformationMarkerStart(composer, i8, "C(suggestionChipBorder)P(3,0:c#ui.graphics.Color,2:c#ui.graphics.Color,1:c#ui.unit.Dp)1812@89713L5,1814@89815L5:Chip.kt#uh7d8r");
        final int i10 = 6;
        if (obj23 & 2 != 0) {
            borderColor2 = ColorSchemeKt.getValue(SuggestionChipTokens.INSTANCE.getFlatOutlineColor(), composer, i10);
        } else {
            borderColor2 = borderColor;
        }
        if (obj23 & 4 != 0) {
            disabledBorderColor2 = Color.copy-wmQWz5c$default(ColorSchemeKt.getValue(SuggestionChipTokens.INSTANCE.getFlatDisabledOutlineColor(), composer, i10), obj7, SuggestionChipTokens.INSTANCE.getFlatDisabledOutlineOpacity(), 0, 0, 0, 14);
        } else {
            disabledBorderColor2 = borderWidth;
        }
        if (obj23 & 8 != 0) {
            borderWidth2 = SuggestionChipTokens.INSTANCE.getFlatOutlineWidth-D9Ej5fM();
        } else {
            borderWidth2 = $changed;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i8, obj22, -1, "androidx.compose.material3.SuggestionChipDefaults.suggestionChipBorder (Chip.kt:1818)");
        } else {
            i4 = obj22;
        }
        l = enabled ? borderColor2 : disabledBorderColor2;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return BorderStrokeKt.BorderStroke-cXLIe8U(borderWidth2, l);
    }

    public final androidx.compose.material3.ChipColors suggestionChipColors(Composer $composer, int $changed) {
        boolean traceInProgress;
        String str;
        int i = 1918570697;
        ComposerKt.sourceInformationMarkerStart($composer, i, "C(suggestionChipColors)1739@86258L11:Chip.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i, $changed, -1, "androidx.compose.material3.SuggestionChipDefaults.suggestionChipColors (Chip.kt:1739)");
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return ChipKt.getDefaultSuggestionChipColors(MaterialTheme.INSTANCE.getColorScheme($composer, 6));
    }

    public final androidx.compose.material3.ChipColors suggestionChipColors-5tl4gsc(long containerColor, long labelColor, long iconContentColor, long disabledContainerColor, long disabledLabelColor, long disabledIconContentColor, Composer $composer, int $changed, int i9) {
        long unspecified-0d7_KjU4;
        long unspecified-0d7_KjU5;
        long unspecified-0d7_KjU2;
        int unspecified-0d7_KjU3;
        int unspecified-0d7_KjU6;
        int unspecified-0d7_KjU;
        boolean traceInProgress;
        String str;
        int i;
        long l3;
        long l6;
        long l5;
        long l;
        long l4;
        long l2;
        final Composer composer = obj34;
        int i2 = 1882647883;
        ComposerKt.sourceInformationMarkerStart(composer, i2, "C(suggestionChipColors)P(0:c#ui.graphics.Color,5:c#ui.graphics.Color,4:c#ui.graphics.Color,1:c#ui.graphics.Color,3:c#ui.graphics.Color,2:c#ui.graphics.Color)1761@87335L11:Chip.kt#uh7d8r");
        if (obj36 & 1 != 0) {
            l3 = unspecified-0d7_KjU4;
        } else {
            l3 = containerColor;
        }
        if (obj36 & 2 != 0) {
            l6 = unspecified-0d7_KjU5;
        } else {
            l6 = iconContentColor;
        }
        if (obj36 & 4 != 0) {
            l5 = unspecified-0d7_KjU2;
        } else {
            l5 = disabledLabelColor;
        }
        if (obj36 & 8 != 0) {
            l = unspecified-0d7_KjU3;
        } else {
            l = $composer;
        }
        if (obj36 & 16 != 0) {
            l4 = unspecified-0d7_KjU6;
        } else {
            l4 = i9;
        }
        if (obj36 & 32 != 0) {
            l2 = unspecified-0d7_KjU;
        } else {
            l2 = obj32;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i2, obj35, -1, "androidx.compose.material3.SuggestionChipDefaults.suggestionChipColors (Chip.kt:1761)");
        } else {
            i = obj35;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return ChipKt.getDefaultSuggestionChipColors(MaterialTheme.INSTANCE.getColorScheme(composer, 6)).copy-FD3wquc(l3, obj6, l6, obj8, l5, obj10, Color.Companion.getUnspecified-0d7_KjU(), obj12);
    }

    public final androidx.compose.material3.ChipElevation suggestionChipElevation-aqJV_2Y(float elevation, float pressedElevation, float focusedElevation, float hoveredElevation, float draggedElevation, float disabledElevation, Composer $composer, int $changed, int i9) {
        SuggestionChipTokens iNSTANCE;
        float f;
        float f3;
        float f4;
        float f2;
        float f5;
        float f6;
        float obj12;
        float obj13;
        float obj14;
        final int i = 1929994057;
        final Composer composer = $composer;
        ComposerKt.sourceInformationMarkerStart(composer, i, "C(suggestionChipElevation)P(2:c#ui.unit.Dp,5:c#ui.unit.Dp,3:c#ui.unit.Dp,4:c#ui.unit.Dp,1:c#ui.unit.Dp,0:c#ui.unit.Dp):Chip.kt#uh7d8r");
        if (i9 & 1 != 0) {
            f = obj12;
        } else {
            f = elevation;
        }
        f3 = i9 & 2 != 0 ? obj13 : pressedElevation;
        f4 = i9 & 4 != 0 ? obj14 : focusedElevation;
        f2 = i9 & 8 != 0 ? obj12 : hoveredElevation;
        if (i9 & 16 != 0) {
            f5 = obj12;
        } else {
            f5 = draggedElevation;
        }
        f6 = i9 & 32 != 0 ? obj12 : disabledElevation;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i, $changed, -1, "androidx.compose.material3.SuggestionChipDefaults.suggestionChipElevation (Chip.kt:1792)");
        } else {
            obj14 = $changed;
        }
        ChipElevation chipElevation = new ChipElevation(f, f3, f4, f2, f5, f6, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return chipElevation;
    }
}
