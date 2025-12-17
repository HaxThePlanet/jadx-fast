package androidx.compose.material;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Composer.Companion;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.Color;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0007\u0008Ç\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002JD\u0010\u0003\u001a\u00020\u00042\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u00062\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u00062\u0008\u0008\u0002\u0010\u0008\u001a\u00020\u00062\u0008\u0008\u0002\u0010\t\u001a\u00020\u00062\u0008\u0008\u0002\u0010\n\u001a\u00020\u0006H\u0007ø\u0001\u0000¢\u0006\u0004\u0008\u000b\u0010\u000c\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006\r", d2 = {"Landroidx/compose/material/CheckboxDefaults;", "", "()V", "colors", "Landroidx/compose/material/CheckboxColors;", "checkedColor", "Landroidx/compose/ui/graphics/Color;", "uncheckedColor", "checkmarkColor", "disabledColor", "disabledIndeterminateColor", "colors-zjMxDiM", "(JJJJJLandroidx/compose/runtime/Composer;II)Landroidx/compose/material/CheckboxColors;", "material_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class CheckboxDefaults {

    public static final int $stable;
    public static final androidx.compose.material.CheckboxDefaults INSTANCE;
    static {
        CheckboxDefaults checkboxDefaults = new CheckboxDefaults();
        CheckboxDefaults.INSTANCE = checkboxDefaults;
    }

    public final androidx.compose.material.CheckboxColors colors-zjMxDiM(long checkedColor, long uncheckedColor, long checkmarkColor, long disabledColor, long disabledIndeterminateColor, Composer $composer, int $changed, int i8) {
        Object empty;
        int i13;
        boolean changed;
        int colors;
        int colors2;
        int colors3;
        int iNSTANCE;
        int disabled;
        boolean traceInProgress;
        int changed5;
        int i9;
        boolean changed4;
        int i4;
        int changed2;
        int i2;
        int changed3;
        int i3;
        long secondary-0d7_KjU;
        long uncheckedColor2;
        Object uncheckedColor3;
        long surface-0d7_KjU;
        Object it$iv;
        long l4;
        long disabledColor2;
        long l2;
        long checkedColor2;
        long onSurface-0d7_KjU;
        long checkedColor3;
        long l5;
        int checkmarkColor2;
        int i;
        int i12;
        long l6;
        int i7;
        int i11;
        long disabledIndeterminateColor2;
        int i14;
        long it$iv2;
        int i6;
        long it$iv3;
        int i10;
        long l7;
        long l3;
        int i5;
        long l;
        long obj35;
        float obj37;
        int obj38;
        int obj39;
        int obj40;
        int obj41;
        int obj42;
        empty = obj45;
        final int i15 = obj46;
        int i16 = 469524104;
        ComposerKt.sourceInformationMarkerStart(empty, i16, "C(colors)P(0:c#ui.graphics.Color,4:c#ui.graphics.Color,1:c#ui.graphics.Color,2:c#ui.graphics.Color,3:c#ui.graphics.Color)226@9439L6,227@9503L6,228@9586L6,229@9647L6,229@9690L8,230@9784L8,232@9833L922:Checkbox.kt#jmzs0o");
        int i29 = 6;
        if (obj47 & 1 != 0) {
            l2 = secondary-0d7_KjU;
        } else {
            l2 = checkedColor;
        }
        if (obj47 & 2 != 0) {
            uncheckedColor2 = Color.copy-wmQWz5c$default(MaterialTheme.INSTANCE.getColors(empty, i29).getOnSurface-0d7_KjU(), obj15, 1058642330, 0, 0, 0, 14);
        } else {
            uncheckedColor2 = checkmarkColor;
        }
        if (obj47 & 4 != 0) {
            l4 = surface-0d7_KjU;
        } else {
            l4 = disabledIndeterminateColor;
        }
        if (obj47 & 8 != 0) {
            disabledColor2 = Color.copy-wmQWz5c$default(MaterialTheme.INSTANCE.getColors(empty, i29).getOnSurface-0d7_KjU(), obj15, ContentAlpha.INSTANCE.getDisabled(empty, i29), 0, 0, 0, 14);
        } else {
            disabledColor2 = $changed;
        }
        if (obj47 & 16 != 0) {
            obj35 = l2;
            checkedColor2 = Color.copy-wmQWz5c$default(obj35, uncheckedColor, ContentAlpha.INSTANCE.getDisabled(empty, i29), 0, 0, 0, 14);
            checkedColor3 = obj35;
        } else {
            checkedColor3 = l2;
            checkedColor2 = obj43;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i16, i15, -1, "androidx.compose.material.CheckboxDefaults.colors (Checkbox.kt:231)");
        }
        ComposerKt.sourceInformationMarkerStart(empty, 654676893, "CC(remember):Checkbox.kt#9igjgp");
        int i23 = 4;
        int i35 = 1;
        if (i18 ^= i29 > i23) {
            if (!empty.changed(checkedColor3)) {
                i13 = i15 & 6 == i23 ? i35 : 0;
            } else {
            }
        } else {
        }
        int i30 = 32;
        if (i24 ^= 48 > i30) {
            if (!empty.changed(uncheckedColor2)) {
                i9 = i15 & 48 == i30 ? i35 : 0;
            } else {
            }
        } else {
        }
        int i31 = 256;
        if (i25 ^= 384 > i31) {
            if (!empty.changed(l4)) {
                i4 = i15 & 384 == i31 ? i35 : 0;
            } else {
            }
        } else {
        }
        int i32 = 2048;
        if (i26 ^= 3072 > i32) {
            if (!empty.changed(disabledColor2)) {
                i2 = i15 & 3072 == i32 ? i35 : 0;
            } else {
            }
        } else {
        }
        int i33 = 16384;
        if (i28 ^= 24576 > i33) {
            if (!empty.changed(checkedColor2)) {
                i3 = i15 & 24576 == i33 ? i35 : 0;
            } else {
            }
        } else {
        }
        Composer composer = obj45;
        int i34 = 0;
        it$iv = composer.rememberedValue();
        final int i46 = 0;
        if (i21 |= i3 == 0) {
            if (it$iv == Composer.Companion.getEmpty()) {
                empty = 0;
                i = 0;
                int i41 = 0;
                int i43 = 0;
                obj35 = l4;
                i7 = 0;
                int i44 = 0;
                i6 = 0;
                obj35 = checkedColor3;
                long l9 = obj35;
                i14 = 0;
                i10 = 0;
                obj35 = disabledColor2;
                long l10 = obj35;
                uncheckedColor3 = obj2;
                checkmarkColor2 = l10;
                long disabledColor3 = checkedColor2;
                long disabledIndeterminateColor3 = l9;
                it$iv = new DefaultCheckboxColors(obj35, obj9, Color.copy-wmQWz5c$default(obj35, uncheckedColor, 0, 0, i41, i43, 14), obj11, disabledIndeterminateColor3, obj13, Color.copy-wmQWz5c$default(obj35, uncheckedColor, i41, i43, i44, i6, 14), l5, checkmarkColor2, i, Color.copy-wmQWz5c$default(obj35, uncheckedColor, i44, i6, 0, i10, 14), i7, disabledColor3, i14, l9, i6, uncheckedColor2, i10, l10, obj27, checkedColor2, obj29, 0);
                l6 = disabledIndeterminateColor3;
                checkedColor2 = disabledColor3;
                disabledIndeterminateColor2 = checkmarkColor2;
                composer.updateRememberedValue(it$iv);
            } else {
                it$iv3 = uncheckedColor2;
                uncheckedColor3 = it$iv;
                disabledIndeterminateColor2 = disabledColor2;
                l6 = checkedColor3;
            }
        } else {
        }
        ComposerKt.sourceInformationMarkerEnd(obj45);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(obj45);
        return (CheckboxColors)(DefaultCheckboxColors)it$iv;
    }
}
