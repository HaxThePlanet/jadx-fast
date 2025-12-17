package androidx.compose.material3;

import androidx.compose.material3.tokens.SwitchTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Color.Companion;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0012\u0008Ç\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\r\u0010\r\u001a\u00020\tH\u0007¢\u0006\u0002\u0010\u000eJ²\u0001\u0010\r\u001a\u00020\t2\u0008\u0008\u0002\u0010\u000f\u001a\u00020\u00102\u0008\u0008\u0002\u0010\u0011\u001a\u00020\u00102\u0008\u0008\u0002\u0010\u0012\u001a\u00020\u00102\u0008\u0008\u0002\u0010\u0013\u001a\u00020\u00102\u0008\u0008\u0002\u0010\u0014\u001a\u00020\u00102\u0008\u0008\u0002\u0010\u0015\u001a\u00020\u00102\u0008\u0008\u0002\u0010\u0016\u001a\u00020\u00102\u0008\u0008\u0002\u0010\u0017\u001a\u00020\u00102\u0008\u0008\u0002\u0010\u0018\u001a\u00020\u00102\u0008\u0008\u0002\u0010\u0019\u001a\u00020\u00102\u0008\u0008\u0002\u0010\u001a\u001a\u00020\u00102\u0008\u0008\u0002\u0010\u001b\u001a\u00020\u00102\u0008\u0008\u0002\u0010\u001c\u001a\u00020\u00102\u0008\u0008\u0002\u0010\u001d\u001a\u00020\u00102\u0008\u0008\u0002\u0010\u001e\u001a\u00020\u00102\u0008\u0008\u0002\u0010\u001f\u001a\u00020\u0010H\u0007ø\u0001\u0000¢\u0006\u0004\u0008 \u0010!R\u0019\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\u0008\u0005\u0010\u0006R\u0018\u0010\u0008\u001a\u00020\t*\u00020\n8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\u0008\u000b\u0010\u000c\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006\"", d2 = {"Landroidx/compose/material3/SwitchDefaults;", "", "()V", "IconSize", "Landroidx/compose/ui/unit/Dp;", "getIconSize-D9Ej5fM", "()F", "F", "defaultSwitchColors", "Landroidx/compose/material3/SwitchColors;", "Landroidx/compose/material3/ColorScheme;", "getDefaultSwitchColors$material3_release", "(Landroidx/compose/material3/ColorScheme;)Landroidx/compose/material3/SwitchColors;", "colors", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/material3/SwitchColors;", "checkedThumbColor", "Landroidx/compose/ui/graphics/Color;", "checkedTrackColor", "checkedBorderColor", "checkedIconColor", "uncheckedThumbColor", "uncheckedTrackColor", "uncheckedBorderColor", "uncheckedIconColor", "disabledCheckedThumbColor", "disabledCheckedTrackColor", "disabledCheckedBorderColor", "disabledCheckedIconColor", "disabledUncheckedThumbColor", "disabledUncheckedTrackColor", "disabledUncheckedBorderColor", "disabledUncheckedIconColor", "colors-V1nXRL4", "(JJJJJJJJJJJJJJJJLandroidx/compose/runtime/Composer;III)Landroidx/compose/material3/SwitchColors;", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class SwitchDefaults {

    public static final int $stable;
    public static final androidx.compose.material3.SwitchDefaults INSTANCE;
    private static final float IconSize;
    static {
        SwitchDefaults switchDefaults = new SwitchDefaults();
        SwitchDefaults.INSTANCE = switchDefaults;
        final int i2 = 0;
        SwitchDefaults.IconSize = Dp.constructor-impl((float)i);
    }

    public final androidx.compose.material3.SwitchColors colors(Composer $composer, int $changed) {
        boolean traceInProgress;
        String str;
        int i = 435552781;
        ComposerKt.sourceInformationMarkerStart($composer, i, "C(colors)299@11393L11:Switch.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i, $changed, -1, "androidx.compose.material3.SwitchDefaults.colors (Switch.kt:299)");
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return getDefaultSwitchColors$material3_release(MaterialTheme.INSTANCE.getColorScheme($composer, 6));
    }

    public final androidx.compose.material3.SwitchColors colors-V1nXRL4(long checkedThumbColor, long checkedTrackColor, long checkedBorderColor, long checkedIconColor, long uncheckedThumbColor, long uncheckedTrackColor, long uncheckedBorderColor, long uncheckedIconColor, long disabledCheckedThumbColor, long disabledCheckedTrackColor, long disabledCheckedBorderColor, long disabledCheckedIconColor, long disabledUncheckedThumbColor, long disabledUncheckedTrackColor, long disabledUncheckedBorderColor, long disabledUncheckedIconColor, Composer $composer, int $changed, int $changed1, int i20) {
        int compositeOver--OWjLjI3;
        boolean traceInProgress;
        long compositeOver--OWjLjI;
        long compositeOver--OWjLjI6;
        long transparent-0d7_KjU;
        long compositeOver--OWjLjI7;
        long compositeOver--OWjLjI2;
        long compositeOver--OWjLjI5;
        int compositeOver--OWjLjI4;
        int i8;
        int selectedHandleColor;
        int selectedTrackColor;
        int companion;
        int selectedIconColor;
        int unselectedHandleColor;
        int unselectedTrackColor;
        int unselectedFocusTrackOutlineColor;
        androidx.compose.material3.tokens.ColorSchemeKeyTokens unselectedIconColor;
        androidx.compose.material3.ColorScheme surface-0d7_KjU;
        int i17;
        long copy-wmQWz5c$default;
        int i13;
        int i7;
        long l4;
        long l13;
        long l5;
        long l6;
        long l14;
        long l3;
        long l10;
        long l15;
        long l11;
        int i18;
        int i16;
        long l16;
        int i5;
        int i6;
        long l2;
        int i14;
        long l7;
        int i9;
        int i19;
        long l8;
        int i4;
        int i12;
        long l12;
        int i10;
        int i15;
        long l9;
        int i;
        int i2;
        long l;
        int i3;
        int i11;
        long obj42;
        float obj44;
        int obj45;
        int obj46;
        int obj47;
        int obj48;
        int obj49;
        final Composer composer = obj74;
        int i21 = obj77;
        ComposerKt.sourceInformationMarkerStart(composer, 1937926421, "C(colors)P(2:c#ui.graphics.Color,3:c#ui.graphics.Color,0:c#ui.graphics.Color,1:c#ui.graphics.Color,14:c#ui.graphics.Color,15:c#ui.graphics.Color,12:c#ui.graphics.Color,13:c#ui.graphics.Color,6:c#ui.graphics.Color,7:c#ui.graphics.Color,4:c#ui.graphics.Color,5:c#ui.graphics.Color,10:c#ui.graphics.Color,11:c#ui.graphics.Color,8:c#ui.graphics.Color,9:c#ui.graphics.Color)324@13145L5,325@13219L5,327@13346L5,328@13425L5,329@13503L5,330@13594L5,331@13670L5,333@13773L5,335@13898L11,337@14015L5,339@14131L11,342@14309L5,344@14432L11,346@14554L5,348@14681L11,350@14802L5,352@14918L11,354@15047L5,356@15163L11,358@15282L5,360@15407L11:Switch.kt#uh7d8r");
        final int i23 = 6;
        if (i21 & 1 != 0) {
            l4 = copy-wmQWz5c$default;
        } else {
            l4 = checkedThumbColor;
        }
        if (i21 & 2 != 0) {
            l13 = copy-wmQWz5c$default;
        } else {
            l13 = checkedBorderColor;
        }
        if (i21 & 4 != 0) {
            l5 = copy-wmQWz5c$default;
        } else {
            l5 = uncheckedThumbColor;
        }
        if (i21 & 8 != 0) {
            l6 = copy-wmQWz5c$default;
        } else {
            l6 = uncheckedBorderColor;
        }
        if (i21 & 16 != 0) {
            l14 = copy-wmQWz5c$default;
        } else {
            l14 = disabledCheckedThumbColor;
        }
        if (i21 & 32 != 0) {
            l3 = copy-wmQWz5c$default;
        } else {
            l3 = disabledCheckedBorderColor;
        }
        if (i21 & 64 != 0) {
            l10 = copy-wmQWz5c$default;
        } else {
            l10 = disabledUncheckedThumbColor;
        }
        if (i21 & 128 != 0) {
            l15 = copy-wmQWz5c$default;
        } else {
            l15 = disabledUncheckedBorderColor;
        }
        if (i21 & 256 != 0) {
            surface-0d7_KjU = MaterialTheme.INSTANCE.getColorScheme(composer, i23);
            l11 = compositeOver--OWjLjI;
        } else {
            l11 = $composer;
        }
        if (i21 & 512 != 0) {
            i13 = 14;
            l16 = compositeOver--OWjLjI6;
        } else {
            l16 = $changed1;
        }
        if (i21 & 1024 != 0) {
            l2 = transparent-0d7_KjU;
        } else {
            l2 = obj62;
        }
        if (i21 & 2048 != 0) {
            i13 = 14;
            l7 = compositeOver--OWjLjI7;
        } else {
            l7 = obj64;
        }
        if (i21 & 4096 != 0) {
            i13 = 14;
            l8 = compositeOver--OWjLjI2;
        } else {
            l8 = obj66;
        }
        if (i21 & 8192 != 0) {
            i13 = 14;
            l12 = compositeOver--OWjLjI5;
        } else {
            l12 = obj68;
        }
        if (i21 & 16384 != 0) {
            i13 = 14;
            l9 = compositeOver--OWjLjI4;
        } else {
            l9 = obj70;
        }
        int i22 = 32768;
        if (i21 &= i22 != 0) {
            l = compositeOver--OWjLjI3;
        } else {
            l = obj72;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1937926421, obj75, obj76, "androidx.compose.material3.SwitchDefaults.colors (Switch.kt:362)");
        } else {
            i8 = obj75;
            i17 = obj76;
        }
        SwitchColors switchColors = new SwitchColors(l4, obj9, l13, obj11, l5, obj13, l6, obj15, l14, obj17, l3, obj19, l10, obj21, l15, obj23, l11, i18, l16, i5, l2, i14, l7, i9, l8, i4, l12, i10, l9, i, l, i3, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return switchColors;
    }

    public final androidx.compose.material3.SwitchColors getDefaultSwitchColors$material3_release(androidx.compose.material3.ColorScheme $this$defaultSwitchColors) {
        androidx.compose.material3.SwitchColors defaultSwitchColorsCached$material3_release;
        androidx.compose.material3.SwitchColors switchColors;
        int i10;
        long token2;
        long transparent-0d7_KjU2;
        long token3;
        long token6;
        long token5;
        long token4;
        long token;
        long l7;
        long l5;
        int i8;
        long transparent-0d7_KjU;
        int i5;
        long l4;
        int i;
        long l2;
        long l6;
        long l3;
        long l8;
        long l10;
        long l11;
        long l9;
        long l;
        int i6;
        float disabledUnselectedIconOpacity;
        int i7;
        int i3;
        int i9;
        int i2;
        int i4;
        long l12;
        final androidx.compose.material3.ColorScheme colorScheme = $this$defaultSwitchColors;
        if (colorScheme.getDefaultSwitchColorsCached$material3_release() == null) {
            i = 0;
            i8 = 0;
            i5 = 0;
            int i16 = 14;
            int i18 = 0;
            int i13 = 0;
            int i14 = 0;
            int i15 = 0;
            l6 = compositeOver--OWjLjI3;
            int i19 = 0;
            l8 = compositeOver--OWjLjI4;
            i7 = 0;
            l11 = compositeOver--OWjLjI5;
            l = compositeOver--OWjLjI6;
            switchColors = switchColors3;
            switchColors = new SwitchColors(ColorSchemeKt.fromToken(colorScheme, SwitchTokens.INSTANCE.getSelectedHandleColor()), obj4, ColorSchemeKt.fromToken(colorScheme, SwitchTokens.INSTANCE.getSelectedTrackColor()), obj6, Color.Companion.getTransparent-0d7_KjU(), obj8, ColorSchemeKt.fromToken(colorScheme, SwitchTokens.INSTANCE.getSelectedIconColor()), obj10, ColorSchemeKt.fromToken(colorScheme, SwitchTokens.INSTANCE.getUnselectedHandleColor()), obj12, ColorSchemeKt.fromToken(colorScheme, SwitchTokens.INSTANCE.getUnselectedTrackColor()), obj14, ColorSchemeKt.fromToken(colorScheme, SwitchTokens.INSTANCE.getUnselectedFocusTrackOutlineColor()), obj16, ColorSchemeKt.fromToken(colorScheme, SwitchTokens.INSTANCE.getUnselectedIconColor()), obj18, ColorKt.compositeOver--OWjLjI(Color.copy-wmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, SwitchTokens.INSTANCE.getDisabledSelectedHandleColor()), obj20, SwitchTokens.INSTANCE.getDisabledSelectedHandleOpacity(), i8, 0, i5, 14), switchColors2), obj20, ColorKt.compositeOver--OWjLjI(Color.copy-wmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, SwitchTokens.INSTANCE.getDisabledSelectedTrackColor()), obj29, SwitchTokens.INSTANCE.getDisabledTrackOpacity(), i13, i14, i15, i16), obj4), i8, Color.Companion.getTransparent-0d7_KjU(), i5, l6, i, l8, l6, l11, l8, l, l11, ColorKt.compositeOver--OWjLjI(Color.copy-wmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, SwitchTokens.INSTANCE.getDisabledUnselectedIconColor()), i19, SwitchTokens.INSTANCE.getDisabledUnselectedIconOpacity(), i7, 0, 0, 14), obj4), l, 0);
            i10 = 0;
            colorScheme.setDefaultSwitchColorsCached$material3_release(switchColors);
        }
        return defaultSwitchColorsCached$material3_release;
    }

    public final float getIconSize-D9Ej5fM() {
        return SwitchDefaults.IconSize;
    }
}
