package androidx.compose.material3;

import androidx.compose.material3.tokens.RadioButtonTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Color.Companion;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0006\u0008Ç\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\r\u0010\u0008\u001a\u00020\u0004H\u0007¢\u0006\u0002\u0010\tJ:\u0010\u0008\u001a\u00020\u00042\u0008\u0008\u0002\u0010\n\u001a\u00020\u000b2\u0008\u0008\u0002\u0010\u000c\u001a\u00020\u000b2\u0008\u0008\u0002\u0010\r\u001a\u00020\u000b2\u0008\u0008\u0002\u0010\u000e\u001a\u00020\u000bH\u0007ø\u0001\u0000¢\u0006\u0004\u0008\u000f\u0010\u0010R\u0018\u0010\u0003\u001a\u00020\u0004*\u00020\u00058@X\u0080\u0004¢\u0006\u0006\u001a\u0004\u0008\u0006\u0010\u0007\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006\u0011", d2 = {"Landroidx/compose/material3/RadioButtonDefaults;", "", "()V", "defaultRadioButtonColors", "Landroidx/compose/material3/RadioButtonColors;", "Landroidx/compose/material3/ColorScheme;", "getDefaultRadioButtonColors$material3_release", "(Landroidx/compose/material3/ColorScheme;)Landroidx/compose/material3/RadioButtonColors;", "colors", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/material3/RadioButtonColors;", "selectedColor", "Landroidx/compose/ui/graphics/Color;", "unselectedColor", "disabledSelectedColor", "disabledUnselectedColor", "colors-ro_MJ88", "(JJJJLandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/RadioButtonColors;", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class RadioButtonDefaults {

    public static final int $stable;
    public static final androidx.compose.material3.RadioButtonDefaults INSTANCE;
    static {
        RadioButtonDefaults radioButtonDefaults = new RadioButtonDefaults();
        RadioButtonDefaults.INSTANCE = radioButtonDefaults;
    }

    public final androidx.compose.material3.RadioButtonColors colors(Composer $composer, int $changed) {
        boolean traceInProgress;
        String str;
        int i = -1191566130;
        ComposerKt.sourceInformationMarkerStart($composer, i, "C(colors)140@5777L11:RadioButton.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i, $changed, -1, "androidx.compose.material3.RadioButtonDefaults.colors (RadioButton.kt:140)");
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return getDefaultRadioButtonColors$material3_release(MaterialTheme.INSTANCE.getColorScheme($composer, 6));
    }

    public final androidx.compose.material3.RadioButtonColors colors-ro_MJ88(long selectedColor, long unselectedColor, long disabledSelectedColor, long disabledUnselectedColor, Composer $composer, int $changed, int i7) {
        long unspecified-0d7_KjU2;
        long unspecified-0d7_KjU3;
        long unspecified-0d7_KjU4;
        int unspecified-0d7_KjU;
        boolean traceInProgress;
        String str;
        long l2;
        long l;
        long l3;
        long l4;
        int i;
        final Composer composer = obj23;
        int i2 = -351083046;
        ComposerKt.sourceInformationMarkerStart(composer, i2, "C(colors)P(2:c#ui.graphics.Color,3:c#ui.graphics.Color,0:c#ui.graphics.Color,1:c#ui.graphics.Color)160@6748L11:RadioButton.kt#uh7d8r");
        if (obj25 & 1 != 0) {
            l2 = unspecified-0d7_KjU2;
        } else {
            l2 = selectedColor;
        }
        if (obj25 & 2 != 0) {
            l = unspecified-0d7_KjU3;
        } else {
            l = disabledSelectedColor;
        }
        if (obj25 & 4 != 0) {
            l3 = unspecified-0d7_KjU4;
        } else {
            l3 = $composer;
        }
        if (obj25 & 8 != 0) {
            l4 = unspecified-0d7_KjU;
        } else {
            l4 = i7;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i2, obj24, -1, "androidx.compose.material3.RadioButtonDefaults.colors (RadioButton.kt:160)");
        } else {
            i = obj24;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return getDefaultRadioButtonColors$material3_release(MaterialTheme.INSTANCE.getColorScheme(composer, 6)).copy-jRlVdoo(l2, obj6, l, obj8);
    }

    public final androidx.compose.material3.RadioButtonColors getDefaultRadioButtonColors$material3_release(androidx.compose.material3.ColorScheme $this$defaultRadioButtonColors) {
        androidx.compose.material3.RadioButtonColors defaultRadioButtonColorsCached$material3_release;
        androidx.compose.material3.RadioButtonColors radioButtonColors;
        int i;
        long token;
        long copy-wmQWz5c$default;
        long copy-wmQWz5c$default2;
        int i7;
        int i2;
        int i3;
        int i4;
        int i8;
        int i6;
        int i5;
        final androidx.compose.material3.ColorScheme colorScheme = $this$defaultRadioButtonColors;
        if (colorScheme.getDefaultRadioButtonColorsCached$material3_release() == null) {
            i7 = 0;
            i3 = 0;
            radioButtonColors = new RadioButtonColors(ColorSchemeKt.fromToken(colorScheme, RadioButtonTokens.INSTANCE.getSelectedIconColor()), obj4, ColorSchemeKt.fromToken(colorScheme, RadioButtonTokens.INSTANCE.getUnselectedIconColor()), obj6, Color.copy-wmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, RadioButtonTokens.INSTANCE.getDisabledSelectedIconColor()), obj8, 1052938076, i7, 0, i3, 14), obj8, Color.copy-wmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, RadioButtonTokens.INSTANCE.getDisabledUnselectedIconColor()), i7, 1052938076, i3, 0, 0, 14), i7, 0);
            i = 0;
            colorScheme.setDefaultRadioButtonColorsCached$material3_release(radioButtonColors);
        }
        return defaultRadioButtonColorsCached$material3_release;
    }
}
