package androidx.compose.material3;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.BorderStrokeKt;
import androidx.compose.material3.tokens.AssistChipTokens;
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
@Metadata(d1 = "\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u000f\n\u0002\u0018\u0002\n\u0002\u0008\r\u0008Ç\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J0\u0010\u0015\u001a\u00020\u00162\u0008\u0008\u0002\u0010\u0017\u001a\u00020\u00182\u0008\u0008\u0002\u0010\u0019\u001a\u00020\u00182\u0008\u0008\u0002\u0010\u001a\u001a\u00020\u0004H\u0007ø\u0001\u0000¢\u0006\u0004\u0008\u001b\u0010\u001cJ8\u0010\u0015\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0008\u0008\u0002\u0010\u0017\u001a\u00020\u00182\u0008\u0008\u0002\u0010\u0019\u001a\u00020\u00182\u0008\u0008\u0002\u0010\u001a\u001a\u00020\u0004H\u0007ø\u0001\u0000¢\u0006\u0004\u0008 \u0010!J\r\u0010\"\u001a\u00020\u000fH\u0007¢\u0006\u0002\u0010#Jb\u0010\"\u001a\u00020\u000f2\u0008\u0008\u0002\u0010$\u001a\u00020\u00182\u0008\u0008\u0002\u0010%\u001a\u00020\u00182\u0008\u0008\u0002\u0010&\u001a\u00020\u00182\u0008\u0008\u0002\u0010'\u001a\u00020\u00182\u0008\u0008\u0002\u0010(\u001a\u00020\u00182\u0008\u0008\u0002\u0010)\u001a\u00020\u00182\u0008\u0008\u0002\u0010*\u001a\u00020\u00182\u0008\u0008\u0002\u0010+\u001a\u00020\u0018H\u0007ø\u0001\u0000¢\u0006\u0004\u0008,\u0010-JN\u0010.\u001a\u00020/2\u0008\u0008\u0002\u00100\u001a\u00020\u00042\u0008\u0008\u0002\u00101\u001a\u00020\u00042\u0008\u0008\u0002\u00102\u001a\u00020\u00042\u0008\u0008\u0002\u00103\u001a\u00020\u00042\u0008\u0008\u0002\u00104\u001a\u00020\u00042\u0008\u0008\u0002\u00105\u001a\u00020\u0004H\u0007ø\u0001\u0000¢\u0006\u0004\u00086\u00107J\r\u00108\u001a\u00020\u000fH\u0007¢\u0006\u0002\u0010#Jb\u00108\u001a\u00020\u000f2\u0008\u0008\u0002\u0010$\u001a\u00020\u00182\u0008\u0008\u0002\u0010%\u001a\u00020\u00182\u0008\u0008\u0002\u0010&\u001a\u00020\u00182\u0008\u0008\u0002\u0010'\u001a\u00020\u00182\u0008\u0008\u0002\u0010(\u001a\u00020\u00182\u0008\u0008\u0002\u0010)\u001a\u00020\u00182\u0008\u0008\u0002\u0010*\u001a\u00020\u00182\u0008\u0008\u0002\u0010+\u001a\u00020\u0018H\u0007ø\u0001\u0000¢\u0006\u0004\u00089\u0010-JN\u0010:\u001a\u00020/2\u0008\u0008\u0002\u00100\u001a\u00020\u00042\u0008\u0008\u0002\u00101\u001a\u00020\u00042\u0008\u0008\u0002\u00102\u001a\u00020\u00042\u0008\u0008\u0002\u00103\u001a\u00020\u00042\u0008\u0008\u0002\u00104\u001a\u00020\u00042\u0008\u0008\u0002\u00105\u001a\u00020\u0004H\u0007ø\u0001\u0000¢\u0006\u0004\u0008;\u00107R\u0019\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\u0008\u0005\u0010\u0006R\u0019\u0010\u0008\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\u0008\t\u0010\u0006R\u0011\u0010\n\u001a\u00020\u000b8G¢\u0006\u0006\u001a\u0004\u0008\u000c\u0010\rR\u0018\u0010\u000e\u001a\u00020\u000f*\u00020\u00108@X\u0080\u0004¢\u0006\u0006\u001a\u0004\u0008\u0011\u0010\u0012R\u0018\u0010\u0013\u001a\u00020\u000f*\u00020\u00108@X\u0080\u0004¢\u0006\u0006\u001a\u0004\u0008\u0014\u0010\u0012\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006<", d2 = {"Landroidx/compose/material3/AssistChipDefaults;", "", "()V", "Height", "Landroidx/compose/ui/unit/Dp;", "getHeight-D9Ej5fM", "()F", "F", "IconSize", "getIconSize-D9Ej5fM", "shape", "Landroidx/compose/ui/graphics/Shape;", "getShape", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/graphics/Shape;", "defaultAssistChipColors", "Landroidx/compose/material3/ChipColors;", "Landroidx/compose/material3/ColorScheme;", "getDefaultAssistChipColors$material3_release", "(Landroidx/compose/material3/ColorScheme;)Landroidx/compose/material3/ChipColors;", "defaultElevatedAssistChipColors", "getDefaultElevatedAssistChipColors$material3_release", "assistChipBorder", "Landroidx/compose/material3/ChipBorder;", "borderColor", "Landroidx/compose/ui/graphics/Color;", "disabledBorderColor", "borderWidth", "assistChipBorder-d_3_b6Q", "(JJFLandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/ChipBorder;", "Landroidx/compose/foundation/BorderStroke;", "enabled", "", "assistChipBorder-h1eT-Ww", "(ZJJFLandroidx/compose/runtime/Composer;II)Landroidx/compose/foundation/BorderStroke;", "assistChipColors", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/material3/ChipColors;", "containerColor", "labelColor", "leadingIconContentColor", "trailingIconContentColor", "disabledContainerColor", "disabledLabelColor", "disabledLeadingIconContentColor", "disabledTrailingIconContentColor", "assistChipColors-oq7We08", "(JJJJJJJJLandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/ChipColors;", "assistChipElevation", "Landroidx/compose/material3/ChipElevation;", "elevation", "pressedElevation", "focusedElevation", "hoveredElevation", "draggedElevation", "disabledElevation", "assistChipElevation-aqJV_2Y", "(FFFFFFLandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/ChipElevation;", "elevatedAssistChipColors", "elevatedAssistChipColors-oq7We08", "elevatedAssistChipElevation", "elevatedAssistChipElevation-aqJV_2Y", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class AssistChipDefaults {

    public static final int $stable;
    private static final float Height;
    public static final androidx.compose.material3.AssistChipDefaults INSTANCE;
    private static final float IconSize;
    static {
        AssistChipDefaults assistChipDefaults = new AssistChipDefaults();
        AssistChipDefaults.INSTANCE = assistChipDefaults;
        AssistChipDefaults.Height = AssistChipTokens.INSTANCE.getContainerHeight-D9Ej5fM();
        AssistChipDefaults.IconSize = AssistChipTokens.INSTANCE.getIconSize-D9Ej5fM();
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Maintained for binary compatibility. Use the assistChipBorder function that returns BorderStroke instead", replaceWith = @ReplaceWith(...))
    public final androidx.compose.material3.ChipBorder assistChipBorder-d_3_b6Q(long borderColor, long disabledBorderColor, float borderWidth, Composer $composer, int $changed, int i6) {
        androidx.compose.material3.tokens.ColorSchemeKeyTokens flatOutlineColor;
        long copy-wmQWz5c$default;
        float flatOutlineWidth-D9Ej5fM;
        boolean traceInProgress;
        int str;
        long value;
        int i3;
        long l;
        long l2;
        float flatDisabledOutlineOpacity;
        float f;
        int i;
        int i7;
        int i2;
        int i4;
        int i5;
        final Composer composer = i6;
        int i8 = 382372847;
        ComposerKt.sourceInformationMarkerStart(composer, i8, "C(assistChipBorder)P(0:c#ui.graphics.Color,2:c#ui.graphics.Color,1:c#ui.unit.Dp)1145@54691L5,1147@54789L5:Chip.kt#uh7d8r");
        str = 6;
        if (obj25 & 1 != 0) {
            l = value;
        } else {
            l = borderColor;
        }
        if (obj25 & 2 != 0) {
            l2 = copy-wmQWz5c$default;
        } else {
            l2 = borderWidth;
        }
        if (obj25 & 4 != 0) {
            f = flatOutlineWidth-D9Ej5fM;
        } else {
            f = $changed;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i8, obj24, -1, "androidx.compose.material3.AssistChipDefaults.assistChipBorder (Chip.kt:1152)");
        } else {
            i3 = obj24;
        }
        ChipBorder chipBorder = new ChipBorder(l, obj8, l2, obj10, f, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return chipBorder;
    }

    public final BorderStroke assistChipBorder-h1eT-Ww(boolean enabled, long borderColor, long disabledBorderColor, float borderWidth, Composer $composer, int $changed, int i7) {
        androidx.compose.material3.tokens.ColorSchemeKeyTokens flatOutlineColor;
        long disabledBorderColor2;
        long borderColor2;
        long value;
        float borderWidth2;
        boolean traceInProgress;
        long l;
        float flatDisabledOutlineOpacity;
        int i2;
        int i3;
        int i6;
        int i4;
        int i5;
        int i;
        final Composer composer = i7;
        int i8 = -1458649561;
        ComposerKt.sourceInformationMarkerStart(composer, i8, "C(assistChipBorder)P(3,0:c#ui.graphics.Color,2:c#ui.graphics.Color,1:c#ui.unit.Dp)1118@53518L5,1120@53616L5:Chip.kt#uh7d8r");
        final int i10 = 6;
        if (obj23 & 2 != 0) {
            borderColor2 = ColorSchemeKt.getValue(AssistChipTokens.INSTANCE.getFlatOutlineColor(), composer, i10);
        } else {
            borderColor2 = borderColor;
        }
        if (obj23 & 4 != 0) {
            disabledBorderColor2 = Color.copy-wmQWz5c$default(ColorSchemeKt.getValue(AssistChipTokens.INSTANCE.getFlatDisabledOutlineColor(), composer, i10), obj7, AssistChipTokens.INSTANCE.getFlatDisabledOutlineOpacity(), 0, 0, 0, 14);
        } else {
            disabledBorderColor2 = borderWidth;
        }
        if (obj23 & 8 != 0) {
            borderWidth2 = AssistChipTokens.INSTANCE.getFlatOutlineWidth-D9Ej5fM();
        } else {
            borderWidth2 = $changed;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i8, obj22, -1, "androidx.compose.material3.AssistChipDefaults.assistChipBorder (Chip.kt:1124)");
        } else {
            i3 = obj22;
        }
        l = enabled ? borderColor2 : disabledBorderColor2;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return BorderStrokeKt.BorderStroke-cXLIe8U(borderWidth2, l);
    }

    public final androidx.compose.material3.ChipColors assistChipColors(Composer $composer, int $changed) {
        boolean traceInProgress;
        String str;
        int i = 1961061417;
        ComposerKt.sourceInformationMarkerStart($composer, i, "C(assistChipColors)1019@48412L11:Chip.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i, $changed, -1, "androidx.compose.material3.AssistChipDefaults.assistChipColors (Chip.kt:1019)");
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return getDefaultAssistChipColors$material3_release(MaterialTheme.INSTANCE.getColorScheme($composer, 6));
    }

    public final androidx.compose.material3.ChipColors assistChipColors-oq7We08(long containerColor, long labelColor, long leadingIconContentColor, long trailingIconContentColor, long disabledContainerColor, long disabledLabelColor, long disabledLeadingIconContentColor, long disabledTrailingIconContentColor, Composer $composer, int $changed, int i11) {
        Color.Companion companion;
        int traceInProgress;
        int unspecified-0d7_KjU7;
        int unspecified-0d7_KjU5;
        int unspecified-0d7_KjU3;
        int unspecified-0d7_KjU4;
        int unspecified-0d7_KjU2;
        int unspecified-0d7_KjU;
        int unspecified-0d7_KjU6;
        int i;
        long l;
        long l6;
        long l5;
        long l4;
        long l3;
        long l7;
        long l8;
        long l2;
        final Composer composer = obj39;
        int i2 = obj41;
        int i3 = -391745725;
        ComposerKt.sourceInformationMarkerStart(composer, i3, "C(assistChipColors)P(0:c#ui.graphics.Color,5:c#ui.graphics.Color,6:c#ui.graphics.Color,7:c#ui.graphics.Color,1:c#ui.graphics.Color,2:c#ui.graphics.Color,3:c#ui.graphics.Color,4:c#ui.graphics.Color)1045@49833L11:Chip.kt#uh7d8r");
        if (i2 & 1 != 0) {
            l = unspecified-0d7_KjU7;
        } else {
            l = containerColor;
        }
        if (i2 & 2 != 0) {
            l6 = unspecified-0d7_KjU5;
        } else {
            l6 = leadingIconContentColor;
        }
        if (i2 & 4 != 0) {
            l5 = unspecified-0d7_KjU3;
        } else {
            l5 = disabledContainerColor;
        }
        if (i2 & 8 != 0) {
            l4 = unspecified-0d7_KjU4;
        } else {
            l4 = disabledLeadingIconContentColor;
        }
        if (i2 & 16 != 0) {
            l3 = unspecified-0d7_KjU2;
        } else {
            l3 = $composer;
        }
        if (i2 & 32 != 0) {
            l7 = unspecified-0d7_KjU;
        } else {
            l7 = i11;
        }
        if (i2 & 64 != 0) {
            l8 = unspecified-0d7_KjU6;
        } else {
            l8 = obj35;
        }
        if (i2 &= 128 != 0) {
            l2 = unspecified-0d7_KjU6;
        } else {
            l2 = obj37;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i3, obj40, -1, "androidx.compose.material3.AssistChipDefaults.assistChipColors (Chip.kt:1045)");
        } else {
            i = obj40;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return this.getDefaultAssistChipColors$material3_release(MaterialTheme.INSTANCE.getColorScheme(composer, 6)).copy-FD3wquc(l, obj7, l6, obj9, l5, obj11, l4, obj13);
    }

    public final androidx.compose.material3.ChipElevation assistChipElevation-aqJV_2Y(float elevation, float pressedElevation, float focusedElevation, float hoveredElevation, float draggedElevation, float disabledElevation, Composer $composer, int $changed, int i9) {
        AssistChipTokens iNSTANCE;
        float f3;
        float f;
        float f2;
        float f6;
        float f4;
        float f5;
        float obj12;
        float obj13;
        float obj14;
        final int i = 245366099;
        final Composer composer = $composer;
        ComposerKt.sourceInformationMarkerStart(composer, i, "C(assistChipElevation)P(2:c#ui.unit.Dp,5:c#ui.unit.Dp,3:c#ui.unit.Dp,4:c#ui.unit.Dp,1:c#ui.unit.Dp,0:c#ui.unit.Dp):Chip.kt#uh7d8r");
        if (i9 & 1 != 0) {
            f3 = obj12;
        } else {
            f3 = elevation;
        }
        f = i9 & 2 != 0 ? obj13 : pressedElevation;
        f2 = i9 & 4 != 0 ? obj14 : focusedElevation;
        f6 = i9 & 8 != 0 ? obj12 : hoveredElevation;
        if (i9 & 16 != 0) {
            f4 = obj12;
        } else {
            f4 = draggedElevation;
        }
        f5 = i9 & 32 != 0 ? obj12 : disabledElevation;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i, $changed, -1, "androidx.compose.material3.AssistChipDefaults.assistChipElevation (Chip.kt:1098)");
        } else {
            obj14 = $changed;
        }
        ChipElevation chipElevation = new ChipElevation(f3, f, f2, f6, f4, f5, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return chipElevation;
    }

    public final androidx.compose.material3.ChipColors elevatedAssistChipColors(Composer $composer, int $changed) {
        boolean traceInProgress;
        String str;
        int i = 655175583;
        ComposerKt.sourceInformationMarkerStart($composer, i, "C(elevatedAssistChipColors)1163@55344L11:Chip.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i, $changed, -1, "androidx.compose.material3.AssistChipDefaults.elevatedAssistChipColors (Chip.kt:1163)");
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return getDefaultElevatedAssistChipColors$material3_release(MaterialTheme.INSTANCE.getColorScheme($composer, 6));
    }

    public final androidx.compose.material3.ChipColors elevatedAssistChipColors-oq7We08(long containerColor, long labelColor, long leadingIconContentColor, long trailingIconContentColor, long disabledContainerColor, long disabledLabelColor, long disabledLeadingIconContentColor, long disabledTrailingIconContentColor, Composer $composer, int $changed, int i11) {
        Color.Companion companion;
        int traceInProgress;
        int unspecified-0d7_KjU2;
        int unspecified-0d7_KjU3;
        int unspecified-0d7_KjU;
        int unspecified-0d7_KjU4;
        int unspecified-0d7_KjU5;
        int unspecified-0d7_KjU6;
        int unspecified-0d7_KjU7;
        int i;
        long l6;
        long l2;
        long l4;
        long l8;
        long l3;
        long l7;
        long l5;
        long l;
        final Composer composer = obj39;
        int i2 = obj41;
        int i3 = -535762675;
        ComposerKt.sourceInformationMarkerStart(composer, i3, "C(elevatedAssistChipColors)P(0:c#ui.graphics.Color,5:c#ui.graphics.Color,6:c#ui.graphics.Color,7:c#ui.graphics.Color,1:c#ui.graphics.Color,2:c#ui.graphics.Color,3:c#ui.graphics.Color,4:c#ui.graphics.Color)1189@56785L11:Chip.kt#uh7d8r");
        if (i2 & 1 != 0) {
            l6 = unspecified-0d7_KjU2;
        } else {
            l6 = containerColor;
        }
        if (i2 & 2 != 0) {
            l2 = unspecified-0d7_KjU3;
        } else {
            l2 = leadingIconContentColor;
        }
        if (i2 & 4 != 0) {
            l4 = unspecified-0d7_KjU;
        } else {
            l4 = disabledContainerColor;
        }
        if (i2 & 8 != 0) {
            l8 = unspecified-0d7_KjU4;
        } else {
            l8 = disabledLeadingIconContentColor;
        }
        if (i2 & 16 != 0) {
            l3 = unspecified-0d7_KjU5;
        } else {
            l3 = $composer;
        }
        if (i2 & 32 != 0) {
            l7 = unspecified-0d7_KjU6;
        } else {
            l7 = i11;
        }
        if (i2 & 64 != 0) {
            l5 = unspecified-0d7_KjU7;
        } else {
            l5 = obj35;
        }
        if (i2 &= 128 != 0) {
            l = unspecified-0d7_KjU7;
        } else {
            l = obj37;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i3, obj40, -1, "androidx.compose.material3.AssistChipDefaults.elevatedAssistChipColors (Chip.kt:1189)");
        } else {
            i = obj40;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return SuggestionChipDefaults.INSTANCE.getDefaultElevatedSuggestionChipColors$material3_release(MaterialTheme.INSTANCE.getColorScheme(composer, 6)).copy-FD3wquc(l6, obj7, l2, obj9, l4, obj11, l8, obj13);
    }

    public final androidx.compose.material3.ChipElevation elevatedAssistChipElevation-aqJV_2Y(float elevation, float pressedElevation, float focusedElevation, float hoveredElevation, float draggedElevation, float disabledElevation, Composer $composer, int $changed, int i9) {
        AssistChipTokens iNSTANCE;
        float f;
        float f2;
        float f4;
        float f3;
        float f6;
        float f5;
        float obj12;
        float obj13;
        float obj14;
        final int i = 1457698077;
        final Composer composer = $composer;
        ComposerKt.sourceInformationMarkerStart(composer, i, "C(elevatedAssistChipElevation)P(2:c#ui.unit.Dp,5:c#ui.unit.Dp,3:c#ui.unit.Dp,4:c#ui.unit.Dp,1:c#ui.unit.Dp,0:c#ui.unit.Dp):Chip.kt#uh7d8r");
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
            f3 = obj12;
        } else {
            f3 = hoveredElevation;
        }
        if (i9 & 16 != 0) {
            f6 = obj12;
        } else {
            f6 = draggedElevation;
        }
        if (i9 & 32 != 0) {
            f5 = obj12;
        } else {
            f5 = disabledElevation;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i, $changed, -1, "androidx.compose.material3.AssistChipDefaults.elevatedAssistChipElevation (Chip.kt:1244)");
        } else {
            obj14 = $changed;
        }
        ChipElevation chipElevation = new ChipElevation(f, f2, f4, f3, f6, f5, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return chipElevation;
    }

    public final androidx.compose.material3.ChipColors getDefaultAssistChipColors$material3_release(androidx.compose.material3.ColorScheme $this$defaultAssistChipColors) {
        androidx.compose.material3.ChipColors defaultAssistChipColorsCached$material3_release;
        androidx.compose.material3.ChipColors chipColors;
        int i7;
        long token3;
        long token2;
        long token;
        long transparent-0d7_KjU;
        long copy-wmQWz5c$default2;
        long copy-wmQWz5c$default;
        int i9;
        long copy-wmQWz5c$default3;
        int i5;
        int i4;
        int i3;
        int i;
        int i8;
        int i2;
        int i6;
        final androidx.compose.material3.ColorScheme colorScheme = $this$defaultAssistChipColors;
        if (colorScheme.getDefaultAssistChipColorsCached$material3_release() == null) {
            i9 = 0;
            i5 = 0;
            i3 = 0;
            chipColors = new ChipColors(Color.Companion.getTransparent-0d7_KjU(), obj4, ColorSchemeKt.fromToken(colorScheme, AssistChipTokens.INSTANCE.getLabelTextColor()), obj6, ColorSchemeKt.fromToken(colorScheme, AssistChipTokens.INSTANCE.getIconColor()), obj8, ColorSchemeKt.fromToken(colorScheme, AssistChipTokens.INSTANCE.getIconColor()), obj10, Color.Companion.getTransparent-0d7_KjU(), obj12, Color.copy-wmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, AssistChipTokens.INSTANCE.getDisabledLabelTextColor()), obj14, AssistChipTokens.INSTANCE.getDisabledLabelTextOpacity(), i9, 0, i5, 14), obj14, Color.copy-wmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, AssistChipTokens.INSTANCE.getDisabledIconColor()), i9, AssistChipTokens.INSTANCE.getDisabledIconOpacity(), i5, 0, i3, 14), i9, Color.copy-wmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, AssistChipTokens.INSTANCE.getDisabledIconColor()), i5, AssistChipTokens.INSTANCE.getDisabledIconOpacity(), i3, 0, 0, 14), i5, 0);
            i7 = 0;
            colorScheme.setDefaultAssistChipColorsCached$material3_release(chipColors);
        }
        return defaultAssistChipColorsCached$material3_release;
    }

    public final androidx.compose.material3.ChipColors getDefaultElevatedAssistChipColors$material3_release(androidx.compose.material3.ColorScheme $this$defaultElevatedAssistChipColors) {
        androidx.compose.material3.ChipColors defaultElevatedAssistChipColorsCached$material3_release;
        androidx.compose.material3.ChipColors chipColors;
        int i;
        long token2;
        long token3;
        long token;
        long copy-wmQWz5c$default2;
        long copy-wmQWz5c$default;
        int i6;
        long copy-wmQWz5c$default4;
        int i2;
        long copy-wmQWz5c$default3;
        int i3;
        int i4;
        int i5;
        int i7;
        int i10;
        int i9;
        int i8;
        final androidx.compose.material3.ColorScheme colorScheme = $this$defaultElevatedAssistChipColors;
        if (colorScheme.getDefaultElevatedAssistChipColorsCached$material3_release() == null) {
            i6 = 0;
            i2 = 0;
            i3 = 0;
            i5 = 0;
            chipColors = new ChipColors(ColorSchemeKt.fromToken(colorScheme, AssistChipTokens.INSTANCE.getElevatedContainerColor()), obj4, ColorSchemeKt.fromToken(colorScheme, AssistChipTokens.INSTANCE.getLabelTextColor()), obj6, ColorSchemeKt.fromToken(colorScheme, AssistChipTokens.INSTANCE.getIconColor()), obj8, ColorSchemeKt.fromToken(colorScheme, AssistChipTokens.INSTANCE.getIconColor()), obj10, Color.copy-wmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, AssistChipTokens.INSTANCE.getElevatedDisabledContainerColor()), obj12, AssistChipTokens.INSTANCE.getElevatedDisabledContainerOpacity(), i6, 0, i2, 14), obj12, Color.copy-wmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, AssistChipTokens.INSTANCE.getDisabledLabelTextColor()), i6, AssistChipTokens.INSTANCE.getDisabledLabelTextOpacity(), i2, 0, i3, 14), i6, Color.copy-wmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, AssistChipTokens.INSTANCE.getDisabledIconColor()), i2, AssistChipTokens.INSTANCE.getDisabledIconOpacity(), i3, 0, i5, 14), i2, Color.copy-wmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, AssistChipTokens.INSTANCE.getDisabledIconColor()), i3, AssistChipTokens.INSTANCE.getDisabledIconOpacity(), i5, 0, 0, 14), i3, 0);
            i = 0;
            colorScheme.setDefaultElevatedAssistChipColorsCached$material3_release(chipColors);
        }
        return defaultElevatedAssistChipColorsCached$material3_release;
    }

    public final float getHeight-D9Ej5fM() {
        return AssistChipDefaults.Height;
    }

    public final float getIconSize-D9Ej5fM() {
        return AssistChipDefaults.IconSize;
    }

    public final Shape getShape(Composer $composer, int $changed) {
        boolean traceInProgress;
        String str;
        int i = 1988153916;
        ComposerKt.sourceInformationMarkerStart($composer, i, "C1255@60496L5:Chip.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i, $changed, -1, "androidx.compose.material3.AssistChipDefaults.<get-shape> (Chip.kt:1255)");
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return ShapesKt.getValue(AssistChipTokens.INSTANCE.getContainerShape(), $composer, 6);
    }
}
