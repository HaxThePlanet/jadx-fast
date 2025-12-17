package androidx.compose.material;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0007\n\u0002\u0008\n\u0008Ç\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002Jv\u0010\u0003\u001a\u00020\u00042\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u00062\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u00062\u0008\u0008\u0002\u0010\u0008\u001a\u00020\t2\u0008\u0008\u0002\u0010\n\u001a\u00020\u00062\u0008\u0008\u0002\u0010\u000b\u001a\u00020\u00062\u0008\u0008\u0002\u0010\u000c\u001a\u00020\t2\u0008\u0008\u0002\u0010\r\u001a\u00020\u00062\u0008\u0008\u0002\u0010\u000e\u001a\u00020\u00062\u0008\u0008\u0002\u0010\u000f\u001a\u00020\u00062\u0008\u0008\u0002\u0010\u0010\u001a\u00020\u0006H\u0007ø\u0001\u0000¢\u0006\u0004\u0008\u0011\u0010\u0012\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006\u0013", d2 = {"Landroidx/compose/material/SwitchDefaults;", "", "()V", "colors", "Landroidx/compose/material/SwitchColors;", "checkedThumbColor", "Landroidx/compose/ui/graphics/Color;", "checkedTrackColor", "checkedTrackAlpha", "", "uncheckedThumbColor", "uncheckedTrackColor", "uncheckedTrackAlpha", "disabledCheckedThumbColor", "disabledCheckedTrackColor", "disabledUncheckedThumbColor", "disabledUncheckedTrackColor", "colors-SQMK_m0", "(JJFJJFJJJJLandroidx/compose/runtime/Composer;III)Landroidx/compose/material/SwitchColors;", "material_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class SwitchDefaults {

    public static final int $stable;
    public static final androidx.compose.material.SwitchDefaults INSTANCE;
    static {
        SwitchDefaults switchDefaults = new SwitchDefaults();
        SwitchDefaults.INSTANCE = switchDefaults;
    }

    public final androidx.compose.material.SwitchColors colors-SQMK_m0(long checkedThumbColor, long checkedTrackColor, float checkedTrackAlpha, long uncheckedThumbColor, long uncheckedTrackColor, float uncheckedTrackAlpha, long disabledCheckedThumbColor, long disabledCheckedTrackColor, long disabledUncheckedThumbColor, long disabledUncheckedTrackColor, Composer $composer, int $changed, int $changed1, int i14) {
        long disabledUncheckedTrackColor2;
        androidx.compose.material.Colors colors2;
        long compositeOver--OWjLjI;
        long disabledCheckedThumbColor2;
        long disabledCheckedTrackColor2;
        int colors;
        int checkedTrackAlpha3;
        String traceInProgress;
        long checkedThumbColor2;
        long copy-wmQWz5c$default2;
        long copy-wmQWz5c$default;
        int i3;
        int i;
        int i6;
        long checkedTrackColor2;
        long uncheckedThumbColor2;
        long uncheckedTrackColor2;
        int uncheckedTrackAlpha2;
        long l;
        int i8;
        int i5;
        int checkedTrackAlpha2;
        int i4;
        int i7;
        int i2;
        int i9;
        long obj29;
        float obj31;
        int obj32;
        int obj33;
        int obj34;
        int obj35;
        int obj36;
        long obj38;
        long obj40;
        long obj42;
        Composer composer = obj47;
        int i10 = obj50;
        ComposerKt.sourceInformationMarkerStart(composer, -1032127534, "C(colors)P(0:c#ui.graphics.Color,2:c#ui.graphics.Color!1,7:c#ui.graphics.Color,9:c#ui.graphics.Color,8,3:c#ui.graphics.Color,4:c#ui.graphics.Color,5:c#ui.graphics.Color,6:c#ui.graphics.Color)326@13193L6,329@13365L6,330@13432L6,333@13594L8,334@13645L6,336@13762L8,337@13813L6,339@13934L8,340@13985L6,342@14106L8,343@14157L6:Switch.kt#jmzs0o");
        int i17 = 6;
        if (i10 & 1 != 0) {
            checkedThumbColor2 = MaterialTheme.INSTANCE.getColors(composer, i17).getSecondaryVariant-0d7_KjU();
        } else {
            checkedThumbColor2 = checkedThumbColor;
        }
        checkedTrackColor2 = i10 & 2 != 0 ? checkedThumbColor2 : checkedTrackAlpha;
        checkedTrackAlpha3 = i10 & 4 != 0 ? 1057635697 : uncheckedTrackColor;
        if (i10 & 8 != 0) {
            uncheckedThumbColor2 = MaterialTheme.INSTANCE.getColors(composer, i17).getSurface-0d7_KjU();
        } else {
            uncheckedThumbColor2 = uncheckedTrackAlpha;
        }
        if (i10 & 16 != 0) {
            uncheckedTrackColor2 = MaterialTheme.INSTANCE.getColors(composer, i17).getOnSurface-0d7_KjU();
        } else {
            uncheckedTrackColor2 = disabledCheckedTrackColor;
        }
        uncheckedTrackAlpha2 = i10 & 32 != 0 ? 1052938076 : disabledUncheckedTrackColor;
        if (i10 & 64 != 0) {
            obj29 = checkedThumbColor2;
            l = obj29;
            checkedTrackAlpha2 = checkedTrackAlpha3;
            compositeOver--OWjLjI = ColorKt.compositeOver--OWjLjI(Color.copy-wmQWz5c$default(obj29, checkedTrackColor, ContentAlpha.INSTANCE.getDisabled(composer, i17), 0, 0, 0, 14), obj6);
        } else {
            checkedTrackAlpha2 = checkedTrackAlpha3;
            l = checkedThumbColor2;
            compositeOver--OWjLjI = $composer;
        }
        if (i10 & 128 != 0) {
            i = 14;
            obj38 = compositeOver--OWjLjI;
            disabledCheckedThumbColor2 = ColorKt.compositeOver--OWjLjI(Color.copy-wmQWz5c$default(checkedTrackColor2, checkedTrackColor, ContentAlpha.INSTANCE.getDisabled(composer, i17), 0, 0, 0, i), i);
        } else {
            obj38 = compositeOver--OWjLjI;
            disabledCheckedThumbColor2 = $changed1;
        }
        if (i10 & 256 != 0) {
            i = 14;
            obj40 = disabledCheckedThumbColor2;
            disabledCheckedTrackColor2 = ColorKt.compositeOver--OWjLjI(Color.copy-wmQWz5c$default(uncheckedThumbColor2, checkedTrackColor, ContentAlpha.INSTANCE.getDisabled(composer, i17), 0, 0, 0, i), i);
        } else {
            obj40 = disabledCheckedThumbColor2;
            disabledCheckedTrackColor2 = obj43;
        }
        if (i10 &= 512 != 0) {
            i = 0;
            colors2 = MaterialTheme.INSTANCE.getColors(composer, i17);
            disabledUncheckedTrackColor2 = ColorKt.compositeOver--OWjLjI(Color.copy-wmQWz5c$default(uncheckedTrackColor2, checkedTrackColor, ContentAlpha.INSTANCE.getDisabled(composer, i17), 0, 0, 0, 14), i);
        } else {
            disabledUncheckedTrackColor2 = obj45;
        }
        if (ComposerKt.isTraceInProgress()) {
            obj42 = disabledUncheckedTrackColor2;
            ComposerKt.traceEventStart(-1032127534, obj48, obj49, "androidx.compose.material.SwitchDefaults.colors (Switch.kt:344)");
        } else {
            i3 = obj48;
            i6 = obj49;
            obj42 = disabledUncheckedTrackColor2;
        }
        int i30 = 0;
        obj29 = checkedTrackColor2;
        obj31 = checkedTrackAlpha2;
        long l4 = obj29;
        int i33 = 0;
        obj35 = i19;
        obj29 = uncheckedTrackColor2;
        long l5 = obj29;
        obj29 = obj40;
        long l6 = obj29;
        obj29 = obj42;
        obj31 = uncheckedTrackAlpha2;
        obj33 = i38;
        long l7 = obj29;
        obj42 = disabledCheckedTrackColor2;
        super(l, obj31, Color.copy-wmQWz5c$default(obj29, checkedTrackColor, obj31, 0, 0, i30, 14), obj33, uncheckedThumbColor2, obj35, Color.copy-wmQWz5c$default(obj29, checkedTrackColor, uncheckedTrackAlpha2, i30, 0, i33, obj35), disabledUncheckedThumbColor, obj38, $composer, Color.copy-wmQWz5c$default(obj29, checkedTrackColor, obj31, i33, 0, 0, obj35), $changed1, obj42, obj43, Color.copy-wmQWz5c$default(obj29, checkedTrackColor, obj31, 0, obj33, 0, obj35), obj45, 0);
        long l2 = obj38;
        long l3 = obj42;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(obj47);
        return (SwitchColors)disabledUncheckedTrackColor3;
    }
}
