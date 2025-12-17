package androidx.compose.material;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u0007\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u000c\u0008Ç\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002Jv\u0010\t\u001a\u00020\n2\u0008\u0008\u0002\u0010\u000b\u001a\u00020\u000c2\u0008\u0008\u0002\u0010\r\u001a\u00020\u000c2\u0008\u0008\u0002\u0010\u000e\u001a\u00020\u000c2\u0008\u0008\u0002\u0010\u000f\u001a\u00020\u000c2\u0008\u0008\u0002\u0010\u0010\u001a\u00020\u000c2\u0008\u0008\u0002\u0010\u0011\u001a\u00020\u000c2\u0008\u0008\u0002\u0010\u0012\u001a\u00020\u000c2\u0008\u0008\u0002\u0010\u0013\u001a\u00020\u000c2\u0008\u0008\u0002\u0010\u0014\u001a\u00020\u000c2\u0008\u0008\u0002\u0010\u0015\u001a\u00020\u000cH\u0007ø\u0001\u0000¢\u0006\u0004\u0008\u0016\u0010\u0017R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0008\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006\u0018", d2 = {"Landroidx/compose/material/SliderDefaults;", "", "()V", "DisabledActiveTrackAlpha", "", "DisabledInactiveTrackAlpha", "DisabledTickAlpha", "InactiveTrackAlpha", "TickAlpha", "colors", "Landroidx/compose/material/SliderColors;", "thumbColor", "Landroidx/compose/ui/graphics/Color;", "disabledThumbColor", "activeTrackColor", "inactiveTrackColor", "disabledActiveTrackColor", "disabledInactiveTrackColor", "activeTickColor", "inactiveTickColor", "disabledActiveTickColor", "disabledInactiveTickColor", "colors-q0g_0yA", "(JJJJJJJJJJLandroidx/compose/runtime/Composer;III)Landroidx/compose/material/SliderColors;", "material_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class SliderDefaults {

    public static final int $stable = 0;
    public static final float DisabledActiveTrackAlpha = 0.32f;
    public static final float DisabledInactiveTrackAlpha = 0.12f;
    public static final float DisabledTickAlpha = 0.12f;
    public static final androidx.compose.material.SliderDefaults INSTANCE = null;
    public static final float InactiveTrackAlpha = 0.24f;
    public static final float TickAlpha = 0.54f;
    static {
        SliderDefaults sliderDefaults = new SliderDefaults();
        SliderDefaults.INSTANCE = sliderDefaults;
    }

    public final androidx.compose.material.SliderColors colors-q0g_0yA(long thumbColor, long disabledThumbColor, long activeTrackColor, long inactiveTrackColor, long disabledActiveTrackColor, long disabledInactiveTrackColor, long activeTickColor, long inactiveTickColor, long disabledActiveTickColor, long disabledInactiveTickColor, Composer $composer, int $changed, int $changed1, int i14) {
        int i;
        String traceInProgress;
        int colors2;
        int colors;
        int colors3;
        int copy-wmQWz5c$default4;
        int copy-wmQWz5c$default5;
        int copy-wmQWz5c$default2;
        long copy-wmQWz5c$default;
        long copy-wmQWz5c$default6;
        int i6;
        int i7;
        long copy-wmQWz5c$default3;
        long l3;
        int i12;
        long l6;
        long l;
        float disabled;
        long l7;
        int i10;
        int i3;
        long l8;
        int i9;
        int i8;
        long l4;
        int i11;
        int i13;
        long l11;
        int i4;
        long l9;
        int i5;
        int i2;
        long l10;
        long l2;
        long l5;
        long obj31;
        int obj33;
        int obj34;
        int obj35;
        int obj36;
        int obj37;
        int obj38;
        final Composer composer = obj51;
        final int i15 = obj52;
        int i16 = obj54;
        final int i17 = 436017687;
        ComposerKt.sourceInformationMarkerStart(composer, i17, "C(colors)P(9:c#ui.graphics.Color,6:c#ui.graphics.Color,1:c#ui.graphics.Color,8:c#ui.graphics.Color,3:c#ui.graphics.Color,5:c#ui.graphics.Color,0:c#ui.graphics.Color,7:c#ui.graphics.Color,2:c#ui.graphics.Color,4:c#ui.graphics.Color)485@21094L6,486@21160L6,487@21216L8,488@21267L6,489@21332L6,492@21503L6,495@21716L33:Slider.kt#jmzs0o");
        i7 = 6;
        if (i16 & 1 != 0) {
            l6 = copy-wmQWz5c$default3;
        } else {
            l6 = thumbColor;
        }
        if (i16 & 2 != 0) {
            l = copy-wmQWz5c$default3;
        } else {
            l = activeTrackColor;
        }
        if (i16 & 4 != 0) {
            l7 = copy-wmQWz5c$default3;
        } else {
            l7 = disabledActiveTrackColor;
        }
        if (i16 & 8 != 0) {
            l8 = copy-wmQWz5c$default3;
        } else {
            l8 = activeTickColor;
        }
        if (i16 & 16 != 0) {
            l4 = copy-wmQWz5c$default4;
        } else {
            l4 = disabledActiveTickColor;
        }
        if (i16 & 32 != 0) {
            l11 = copy-wmQWz5c$default5;
        } else {
            l11 = $composer;
        }
        if (i16 & 64 != 0) {
            l9 = copy-wmQWz5c$default2;
        } else {
            l9 = $changed1;
        }
        if (i16 & 128 != 0) {
            l10 = copy-wmQWz5c$default;
        } else {
            l10 = obj45;
        }
        if (i16 & 256 != 0) {
            l2 = copy-wmQWz5c$default6;
        } else {
            l2 = obj47;
        }
        if (i16 &= 512 != 0) {
            l5 = copy-wmQWz5c$default6;
        } else {
            l5 = obj49;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i17, i15, obj53, "androidx.compose.material.SliderDefaults.colors (Slider.kt:500)");
        } else {
            i6 = obj53;
        }
        DefaultSliderColors defaultSliderColors = new DefaultSliderColors(l6, obj10, l, obj12, l7, i10, l8, i9, l4, i11, l11, i4, l9, i5, l10, obj24, l2, obj26, l5, obj28, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return (SliderColors)defaultSliderColors;
    }
}
