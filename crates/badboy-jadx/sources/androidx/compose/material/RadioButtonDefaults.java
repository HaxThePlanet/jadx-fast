package androidx.compose.material;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Composer.Companion;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.Color;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\u0008Ç\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J0\u0010\u0003\u001a\u00020\u00042\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u00062\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u00062\u0008\u0008\u0002\u0010\u0008\u001a\u00020\u0006H\u0007ø\u0001\u0000¢\u0006\u0004\u0008\t\u0010\n\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006\u000b", d2 = {"Landroidx/compose/material/RadioButtonDefaults;", "", "()V", "colors", "Landroidx/compose/material/RadioButtonColors;", "selectedColor", "Landroidx/compose/ui/graphics/Color;", "unselectedColor", "disabledColor", "colors-RGew2ao", "(JJJLandroidx/compose/runtime/Composer;II)Landroidx/compose/material/RadioButtonColors;", "material_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class RadioButtonDefaults {

    public static final int $stable;
    public static final androidx.compose.material.RadioButtonDefaults INSTANCE;
    static {
        RadioButtonDefaults radioButtonDefaults = new RadioButtonDefaults();
        RadioButtonDefaults.INSTANCE = radioButtonDefaults;
    }

    public final androidx.compose.material.RadioButtonColors colors-RGew2ao(long selectedColor, long unselectedColor, long disabledColor, Composer $composer, int $changed, int i6) {
        boolean changed2;
        int i7;
        int colors2;
        int colors;
        int changed3;
        int i8;
        boolean changed;
        int i11;
        long copy-wmQWz5c$default2;
        int copy-wmQWz5c$default;
        boolean traceInProgress;
        String str;
        Object defaultRadioButtonColors;
        Object empty;
        long l2;
        long l;
        int i2;
        long l3;
        int i5;
        int disabled;
        int i4;
        int i3;
        int i9;
        int i10;
        int i;
        final Composer composer = obj27;
        final int i12 = obj28;
        int i13 = 1370708026;
        ComposerKt.sourceInformationMarkerStart(composer, i13, "C(colors)P(1:c#ui.graphics.Color,2:c#ui.graphics.Color,0:c#ui.graphics.Color)162@6523L6,163@6588L6,164@6670L6,164@6713L8,166@6765L197:RadioButton.kt#jmzs0o");
        int i21 = 6;
        if (obj29 & 1 != 0) {
            l2 = copy-wmQWz5c$default2;
        } else {
            l2 = selectedColor;
        }
        if (obj29 & 2 != 0) {
            l = copy-wmQWz5c$default2;
        } else {
            l = disabledColor;
        }
        int i18 = 4;
        if (obj29 & 4 != 0) {
            l3 = copy-wmQWz5c$default;
        } else {
            l3 = $changed;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i13, i12, -1, "androidx.compose.material.RadioButtonDefaults.colors (RadioButton.kt:165)");
        }
        ComposerKt.sourceInformationMarkerStart(composer, -1778188470, "CC(remember):RadioButton.kt#9igjgp");
        i11 = 0;
        int i23 = 1;
        if (i15 ^= i21 > i18) {
            if (!composer.changed(l2)) {
                i7 = i12 & 6 == i18 ? i23 : i11;
            } else {
            }
        } else {
        }
        int i24 = 32;
        if (i19 ^= 48 > i24) {
            if (!composer.changed(l)) {
                i8 = i12 & 48 == i24 ? i23 : i11;
            } else {
            }
        } else {
        }
        int i25 = 256;
        if (i20 ^= 384 > i25) {
            if (!composer.changed(l3)) {
                if (i12 & 384 == i25) {
                    i11 = i23;
                }
            } else {
            }
        } else {
        }
        Composer composer2 = obj27;
        int i22 = 0;
        Object rememberedValue = composer2.rememberedValue();
        int i26 = 0;
        if (i16 |= i11 == 0) {
            if (rememberedValue == Composer.Companion.getEmpty()) {
                i4 = 0;
                defaultRadioButtonColors = new DefaultRadioButtonColors(l2, obj9, l, obj11, l3, i5, 0);
                composer2.updateRememberedValue(defaultRadioButtonColors);
            } else {
                defaultRadioButtonColors = rememberedValue;
            }
        } else {
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return (RadioButtonColors)(DefaultRadioButtonColors)defaultRadioButtonColors;
    }
}
