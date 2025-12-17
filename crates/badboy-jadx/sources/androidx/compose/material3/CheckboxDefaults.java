package androidx.compose.material3;

import androidx.compose.material3.tokens.CheckboxTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Color.Companion;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0008\u0008Ç\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\r\u0010\u0008\u001a\u00020\u0004H\u0007¢\u0006\u0002\u0010\tJN\u0010\u0008\u001a\u00020\u00042\u0008\u0008\u0002\u0010\n\u001a\u00020\u000b2\u0008\u0008\u0002\u0010\u000c\u001a\u00020\u000b2\u0008\u0008\u0002\u0010\r\u001a\u00020\u000b2\u0008\u0008\u0002\u0010\u000e\u001a\u00020\u000b2\u0008\u0008\u0002\u0010\u000f\u001a\u00020\u000b2\u0008\u0008\u0002\u0010\u0010\u001a\u00020\u000bH\u0007ø\u0001\u0000¢\u0006\u0004\u0008\u0011\u0010\u0012R\u0018\u0010\u0003\u001a\u00020\u0004*\u00020\u00058@X\u0080\u0004¢\u0006\u0006\u001a\u0004\u0008\u0006\u0010\u0007\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006\u0013", d2 = {"Landroidx/compose/material3/CheckboxDefaults;", "", "()V", "defaultCheckboxColors", "Landroidx/compose/material3/CheckboxColors;", "Landroidx/compose/material3/ColorScheme;", "getDefaultCheckboxColors$material3_release", "(Landroidx/compose/material3/ColorScheme;)Landroidx/compose/material3/CheckboxColors;", "colors", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/material3/CheckboxColors;", "checkedColor", "Landroidx/compose/ui/graphics/Color;", "uncheckedColor", "checkmarkColor", "disabledCheckedColor", "disabledUncheckedColor", "disabledIndeterminateColor", "colors-5tl4gsc", "(JJJJJJLandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/CheckboxColors;", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class CheckboxDefaults {

    public static final int $stable;
    public static final androidx.compose.material3.CheckboxDefaults INSTANCE;
    static {
        CheckboxDefaults checkboxDefaults = new CheckboxDefaults();
        CheckboxDefaults.INSTANCE = checkboxDefaults;
    }

    public final androidx.compose.material3.CheckboxColors colors(Composer $composer, int $changed) {
        boolean traceInProgress;
        String str;
        int i = -9530498;
        ComposerKt.sourceInformationMarkerStart($composer, i, "C(colors)193@8111L11:Checkbox.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i, $changed, -1, "androidx.compose.material3.CheckboxDefaults.colors (Checkbox.kt:193)");
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return getDefaultCheckboxColors$material3_release(MaterialTheme.INSTANCE.getColorScheme($composer, 6));
    }

    public final androidx.compose.material3.CheckboxColors colors-5tl4gsc(long checkedColor, long uncheckedColor, long checkmarkColor, long disabledCheckedColor, long disabledUncheckedColor, long disabledIndeterminateColor, Composer $composer, int $changed, int i9) {
        long unspecified-0d7_KjU6;
        long unspecified-0d7_KjU4;
        long unspecified-0d7_KjU5;
        int unspecified-0d7_KjU;
        int unspecified-0d7_KjU2;
        int unspecified-0d7_KjU3;
        boolean traceInProgress;
        String str;
        int i;
        long l;
        long l4;
        long l3;
        long l5;
        long l6;
        long l2;
        final Composer composer = obj42;
        int i2 = -89536160;
        ComposerKt.sourceInformationMarkerStart(composer, i2, "C(colors)P(0:c#ui.graphics.Color,5:c#ui.graphics.Color,1:c#ui.graphics.Color,2:c#ui.graphics.Color,4:c#ui.graphics.Color,3:c#ui.graphics.Color)219@9500L11:Checkbox.kt#uh7d8r");
        if (obj44 & 1 != 0) {
            l4 = unspecified-0d7_KjU6;
        } else {
            l4 = checkedColor;
        }
        if (obj44 & 2 != 0) {
            l6 = unspecified-0d7_KjU4;
        } else {
            l6 = checkmarkColor;
        }
        if (obj44 & 4 != 0) {
            l = unspecified-0d7_KjU5;
        } else {
            l = disabledUncheckedColor;
        }
        if (obj44 & 8 != 0) {
            l3 = unspecified-0d7_KjU;
        } else {
            l3 = $composer;
        }
        if (obj44 & 16 != 0) {
            l2 = unspecified-0d7_KjU2;
        } else {
            l2 = i9;
        }
        if (obj44 & 32 != 0) {
            l5 = unspecified-0d7_KjU3;
        } else {
            l5 = obj40;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i2, obj43, -1, "androidx.compose.material3.CheckboxDefaults.colors (Checkbox.kt:219)");
        } else {
            i = obj43;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return this.getDefaultCheckboxColors$material3_release(MaterialTheme.INSTANCE.getColorScheme(composer, 6)).copy-2qZNXz8(l, obj6, Color.Companion.getTransparent-0d7_KjU(), obj8, l4, obj10, Color.Companion.getTransparent-0d7_KjU(), obj12, l3, obj14, Color.Companion.getTransparent-0d7_KjU(), obj16);
    }

    public final androidx.compose.material3.CheckboxColors getDefaultCheckboxColors$material3_release(androidx.compose.material3.ColorScheme $this$defaultCheckboxColors) {
        androidx.compose.material3.CheckboxColors defaultCheckboxColorsCached$material3_release;
        androidx.compose.material3.CheckboxColors checkboxColors;
        int i3;
        long transparent-0d7_KjU;
        long token;
        long transparent-0d7_KjU3;
        long copy-wmQWz5c$default;
        long transparent-0d7_KjU2;
        int i14;
        long copy-wmQWz5c$default5;
        int i4;
        long token2;
        int i5;
        long token3;
        int i6;
        long copy-wmQWz5c$default3;
        int i12;
        long copy-wmQWz5c$default4;
        int i2;
        long copy-wmQWz5c$default2;
        int i;
        int i11;
        int i7;
        int i13;
        int i8;
        int i10;
        int i9;
        final androidx.compose.material3.ColorScheme colorScheme = $this$defaultCheckboxColors;
        if (colorScheme.getDefaultCheckboxColorsCached$material3_release() == null) {
            i14 = 0;
            i4 = 0;
            i12 = 0;
            i5 = 0;
            i6 = 0;
            i2 = 0;
            i = 0;
            i7 = 0;
            checkboxColors = new CheckboxColors(ColorSchemeKt.fromToken(colorScheme, CheckboxTokens.INSTANCE.getSelectedIconColor()), obj4, Color.Companion.getTransparent-0d7_KjU(), obj6, ColorSchemeKt.fromToken(colorScheme, CheckboxTokens.INSTANCE.getSelectedContainerColor()), obj8, Color.Companion.getTransparent-0d7_KjU(), obj10, Color.copy-wmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, CheckboxTokens.INSTANCE.getSelectedDisabledContainerColor()), obj12, 1052938076, i14, 0, i4, 14), obj12, Color.Companion.getTransparent-0d7_KjU(), i14, Color.copy-wmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, CheckboxTokens.INSTANCE.getSelectedDisabledContainerColor()), i4, 1052938076, i5, 0, i6, 14), i4, ColorSchemeKt.fromToken(colorScheme, CheckboxTokens.INSTANCE.getSelectedContainerColor()), i5, ColorSchemeKt.fromToken(colorScheme, CheckboxTokens.INSTANCE.getUnselectedOutlineColor()), i6, Color.copy-wmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, CheckboxTokens.INSTANCE.getSelectedDisabledContainerColor()), i12, 1052938076, i2, 0, i, 14), i12, Color.copy-wmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, CheckboxTokens.INSTANCE.getUnselectedDisabledOutlineColor()), i2, 1052938076, i, 0, i7, 14), i2, Color.copy-wmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, CheckboxTokens.INSTANCE.getSelectedDisabledContainerColor()), i, 1052938076, i7, 0, 0, 14), i, 0);
            i3 = 0;
            colorScheme.setDefaultCheckboxColorsCached$material3_release(checkboxColors);
        }
        return defaultCheckboxColorsCached$material3_release;
    }
}
