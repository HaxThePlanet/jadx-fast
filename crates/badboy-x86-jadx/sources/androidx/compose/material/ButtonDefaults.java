package androidx.compose.material;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.BorderStrokeKt;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Composer.Companion;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Color.Companion;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.unit.Dp;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u000c\n\u0002\u0010\u0007\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\u000f\u0008Ç\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J:\u0010\u001f\u001a\u00020 2\u0008\u0008\u0002\u0010!\u001a\u00020\"2\u0008\u0008\u0002\u0010#\u001a\u00020\"2\u0008\u0008\u0002\u0010$\u001a\u00020\"2\u0008\u0008\u0002\u0010%\u001a\u00020\"H\u0007ø\u0001\u0000¢\u0006\u0004\u0008&\u0010'J0\u0010(\u001a\u00020)2\u0008\u0008\u0002\u0010*\u001a\u00020\u00042\u0008\u0008\u0002\u0010+\u001a\u00020\u00042\u0008\u0008\u0002\u0010,\u001a\u00020\u0004H\u0007ø\u0001\u0000¢\u0006\u0004\u0008-\u0010.JD\u0010(\u001a\u00020)2\u0008\u0008\u0002\u0010*\u001a\u00020\u00042\u0008\u0008\u0002\u0010+\u001a\u00020\u00042\u0008\u0008\u0002\u0010,\u001a\u00020\u00042\u0008\u0008\u0002\u0010/\u001a\u00020\u00042\u0008\u0008\u0002\u00100\u001a\u00020\u0004H\u0007ø\u0001\u0000¢\u0006\u0004\u00081\u00102J0\u00103\u001a\u00020 2\u0008\u0008\u0002\u0010!\u001a\u00020\"2\u0008\u0008\u0002\u0010#\u001a\u00020\"2\u0008\u0008\u0002\u0010%\u001a\u00020\"H\u0007ø\u0001\u0000¢\u0006\u0004\u00084\u00105J0\u00106\u001a\u00020 2\u0008\u0008\u0002\u0010!\u001a\u00020\"2\u0008\u0008\u0002\u0010#\u001a\u00020\"2\u0008\u0008\u0002\u0010%\u001a\u00020\"H\u0007ø\u0001\u0000¢\u0006\u0004\u00087\u00105R\u0016\u0010\u0003\u001a\u00020\u0004X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0005R\u0016\u0010\u0006\u001a\u00020\u0004X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0005R\u0011\u0010\u0007\u001a\u00020\u0008¢\u0006\u0008\n\u0000\u001a\u0004\u0008\t\u0010\nR\u0019\u0010\u000b\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0005\u001a\u0004\u0008\u000c\u0010\rR\u0019\u0010\u000e\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0005\u001a\u0004\u0008\u000f\u0010\rR\u0019\u0010\u0010\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0005\u001a\u0004\u0008\u0011\u0010\rR\u0019\u0010\u0012\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0005\u001a\u0004\u0008\u0013\u0010\rR\u000e\u0010\u0014\u001a\u00020\u0015X\u0086T¢\u0006\u0002\n\u0000R\u0019\u0010\u0016\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0005\u001a\u0004\u0008\u0017\u0010\rR\u0011\u0010\u0018\u001a\u00020\u0008¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0019\u0010\nR\u0016\u0010\u001a\u001a\u00020\u0004X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0005R\u0011\u0010\u001b\u001a\u00020\u001c8G¢\u0006\u0006\u001a\u0004\u0008\u001d\u0010\u001e\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u00068", d2 = {"Landroidx/compose/material/ButtonDefaults;", "", "()V", "ButtonHorizontalPadding", "Landroidx/compose/ui/unit/Dp;", "F", "ButtonVerticalPadding", "ContentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "getContentPadding", "()Landroidx/compose/foundation/layout/PaddingValues;", "IconSize", "getIconSize-D9Ej5fM", "()F", "IconSpacing", "getIconSpacing-D9Ej5fM", "MinHeight", "getMinHeight-D9Ej5fM", "MinWidth", "getMinWidth-D9Ej5fM", "OutlinedBorderOpacity", "", "OutlinedBorderSize", "getOutlinedBorderSize-D9Ej5fM", "TextButtonContentPadding", "getTextButtonContentPadding", "TextButtonHorizontalPadding", "outlinedBorder", "Landroidx/compose/foundation/BorderStroke;", "getOutlinedBorder", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/BorderStroke;", "buttonColors", "Landroidx/compose/material/ButtonColors;", "backgroundColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "disabledBackgroundColor", "disabledContentColor", "buttonColors-ro_MJ88", "(JJJJLandroidx/compose/runtime/Composer;II)Landroidx/compose/material/ButtonColors;", "elevation", "Landroidx/compose/material/ButtonElevation;", "defaultElevation", "pressedElevation", "disabledElevation", "elevation-yajeYGU", "(FFFLandroidx/compose/runtime/Composer;II)Landroidx/compose/material/ButtonElevation;", "hoveredElevation", "focusedElevation", "elevation-R_JCAzs", "(FFFFFLandroidx/compose/runtime/Composer;II)Landroidx/compose/material/ButtonElevation;", "outlinedButtonColors", "outlinedButtonColors-RGew2ao", "(JJJLandroidx/compose/runtime/Composer;II)Landroidx/compose/material/ButtonColors;", "textButtonColors", "textButtonColors-RGew2ao", "material_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ButtonDefaults {

    public static final int $stable = 0;
    private static final float ButtonHorizontalPadding = 0f;
    private static final float ButtonVerticalPadding = 0f;
    private static final PaddingValues ContentPadding = null;
    public static final androidx.compose.material.ButtonDefaults INSTANCE = null;
    private static final float IconSize = 0f;
    private static final float IconSpacing = 0f;
    private static final float MinHeight = 0f;
    private static final float MinWidth = 0f;
    public static final float OutlinedBorderOpacity = 0.12f;
    private static final float OutlinedBorderSize;
    private static final PaddingValues TextButtonContentPadding;
    private static final float TextButtonHorizontalPadding;
    static {
        ButtonDefaults buttonDefaults = new ButtonDefaults();
        ButtonDefaults.INSTANCE = buttonDefaults;
        int i9 = 0;
        ButtonDefaults.ButtonHorizontalPadding = Dp.constructor-impl((float)i);
        int i10 = 0;
        ButtonDefaults.ButtonVerticalPadding = Dp.constructor-impl((float)i2);
        ButtonDefaults.ContentPadding = PaddingKt.PaddingValues-a9UjIt4(ButtonDefaults.ButtonHorizontalPadding, ButtonDefaults.ButtonVerticalPadding, ButtonDefaults.ButtonHorizontalPadding, ButtonDefaults.ButtonVerticalPadding);
        int i11 = 0;
        ButtonDefaults.MinWidth = Dp.constructor-impl((float)i3);
        int i12 = 0;
        ButtonDefaults.MinHeight = Dp.constructor-impl((float)i4);
        int i13 = 0;
        ButtonDefaults.IconSize = Dp.constructor-impl((float)i5);
        int i14 = 0;
        ButtonDefaults.IconSpacing = Dp.constructor-impl((float)i6);
        int i15 = 0;
        ButtonDefaults.OutlinedBorderSize = Dp.constructor-impl((float)i7);
        int i16 = 0;
        ButtonDefaults.TextButtonHorizontalPadding = Dp.constructor-impl((float)i8);
        ButtonDefaults.TextButtonContentPadding = PaddingKt.PaddingValues-a9UjIt4(ButtonDefaults.TextButtonHorizontalPadding, ButtonDefaults.ContentPadding.calculateTopPadding-D9Ej5fM(), ButtonDefaults.TextButtonHorizontalPadding, ButtonDefaults.ContentPadding.calculateBottomPadding-D9Ej5fM());
    }

    public final androidx.compose.material.ButtonColors buttonColors-ro_MJ88(long backgroundColor, long contentColor, long disabledBackgroundColor, long disabledContentColor, Composer $composer, int $changed, int i7) {
        androidx.compose.material.Colors colors;
        int i9;
        androidx.compose.material.Colors colors2;
        int copy-wmQWz5c$default;
        boolean traceInProgress;
        int str;
        long compositeOver--OWjLjI;
        long l3;
        long l2;
        long l;
        int i;
        long l4;
        int i6;
        int disabled;
        int i2;
        int i5;
        int i3;
        int i8;
        int i4;
        final Composer composer = obj31;
        final int i10 = obj32;
        int i11 = 1870371134;
        ComposerKt.sourceInformationMarkerStart(composer, i11, "C(buttonColors)P(0:c#ui.graphics.Color,1:c#ui.graphics.Color,2:c#ui.graphics.Color,3:c#ui.graphics.Color)407@16814L6,408@16860L32,409@16949L6,410@17027L6,411@17096L6,412@17152L8:Button.kt#jmzs0o");
        str = 6;
        if (obj33 & 1 != 0) {
            l3 = compositeOver--OWjLjI;
        } else {
            l3 = backgroundColor;
        }
        if (obj33 & 2 != 0) {
            l2 = compositeOver--OWjLjI;
        } else {
            l2 = disabledBackgroundColor;
        }
        if (obj33 & 4 != 0) {
            l = compositeOver--OWjLjI;
        } else {
            l = $composer;
        }
        if (obj33 & 8 != 0) {
            l4 = copy-wmQWz5c$default;
        } else {
            l4 = i7;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i11, i10, -1, "androidx.compose.material.ButtonDefaults.buttonColors (Button.kt:413)");
        }
        DefaultButtonColors defaultButtonColors = new DefaultButtonColors(l3, obj9, l2, obj11, l, obj13, l4, i6, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return (ButtonColors)defaultButtonColors;
    }

    public final androidx.compose.material.ButtonElevation elevation-R_JCAzs(float defaultElevation, float pressedElevation, float disabledElevation, float hoveredElevation, float focusedElevation, Composer $composer, int $changed, int i8) {
        int i6;
        boolean changed2;
        int $this$dp$iv4;
        int $this$dp$iv3;
        int $this$dp$iv2;
        int $this$dp$iv5;
        int $this$dp$iv;
        boolean traceInProgress;
        int changed5;
        int i4;
        boolean changed4;
        int i2;
        int changed3;
        int i;
        int changed;
        int str;
        int empty;
        Object defaultButtonElevation;
        float f4;
        float f3;
        float f5;
        float f;
        float f2;
        int i5;
        int i3;
        final Composer composer = $composer;
        final int i7 = $changed;
        int i9 = -737170518;
        ComposerKt.sourceInformationMarkerStart(composer, i9, "C(elevation)P(0:c#ui.unit.Dp,4:c#ui.unit.Dp,1:c#ui.unit.Dp,3:c#ui.unit.Dp,2:c#ui.unit.Dp)379@15748L497:Button.kt#jmzs0o");
        if (i8 & 1 != 0) {
            str = 0;
            f4 = $this$dp$iv4;
        } else {
            f4 = defaultElevation;
        }
        if (i8 & 2 != 0) {
            str = 0;
            f3 = $this$dp$iv3;
        } else {
            f3 = pressedElevation;
        }
        if (i8 & 4 != 0) {
            str = 0;
            f5 = $this$dp$iv2;
        } else {
            f5 = disabledElevation;
        }
        if (i8 & 8 != 0) {
            str = 0;
            f = $this$dp$iv5;
        } else {
            f = hoveredElevation;
        }
        if (i8 & 16 != 0) {
            str = 0;
            f2 = $this$dp$iv;
        } else {
            f2 = focusedElevation;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i9, i7, -1, "androidx.compose.material.ButtonDefaults.elevation (Button.kt:378)");
        }
        ComposerKt.sourceInformationMarkerStart(composer, -511819094, "CC(remember):Button.kt#9igjgp");
        int i16 = 4;
        empty = 0;
        i5 = 1;
        if (i11 ^= 6 > i16) {
            if (!composer.changed(f4)) {
                i6 = i7 & 6 == i16 ? i5 : empty;
            } else {
            }
        } else {
        }
        int i27 = 32;
        if (i17 ^= 48 > i27) {
            if (!composer.changed(f3)) {
                i4 = i7 & 48 == i27 ? i5 : empty;
            } else {
            }
        } else {
        }
        int i28 = 256;
        if (i18 ^= 384 > i28) {
            if (!composer.changed(f5)) {
                i2 = i7 & 384 == i28 ? i5 : empty;
            } else {
            }
        } else {
        }
        int i29 = 2048;
        if (i19 ^= 3072 > i29) {
            if (!composer.changed(f)) {
                i = i7 & 3072 == i29 ? i5 : empty;
            } else {
            }
        } else {
        }
        int i30 = 16384;
        if (i21 ^= 24576 > i30) {
            if (!composer.changed(f2)) {
                if (i7 & 24576 == i30) {
                    empty = i5;
                }
            } else {
            }
        } else {
        }
        Composer composer2 = $composer;
        int i31 = 0;
        final Object rememberedValue = composer2.rememberedValue();
        final int i32 = 0;
        if (i14 |= empty == 0) {
            if (rememberedValue == Composer.Companion.getEmpty()) {
                i3 = 0;
                defaultButtonElevation = new DefaultButtonElevation(f4, f3, f5, f, f2, 0);
                composer2.updateRememberedValue(defaultButtonElevation);
            } else {
                defaultButtonElevation = rememberedValue;
            }
        } else {
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return (ButtonElevation)(DefaultButtonElevation)defaultButtonElevation;
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Use another overload of elevation")
    public final androidx.compose.material.ButtonElevation elevation-yajeYGU(float defaultElevation, float pressedElevation, float disabledElevation, Composer $composer, int $changed, int i6) {
        int i2;
        int i;
        float f2;
        float f;
        float f3;
        float obj13;
        float obj14;
        float obj15;
        final int i3 = $changed;
        final int i4 = 1428576874;
        final Composer composer = $composer;
        ComposerKt.sourceInformationMarkerStart(composer, i4, "C(elevation)P(0:c#ui.unit.Dp,2:c#ui.unit.Dp,1:c#ui.unit.Dp)350@14616L161:Button.kt#jmzs0o");
        if (i6 & 1 != 0) {
            i = 0;
            f2 = obj13;
        } else {
            f2 = defaultElevation;
        }
        if (i6 & 2 != 0) {
            i2 = 0;
            f = obj14;
        } else {
            f = pressedElevation;
        }
        if (i6 & 4 != 0) {
            obj14 = 0;
            f3 = obj15;
        } else {
            f3 = disabledElevation;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i4, i3, -1, "androidx.compose.material.ButtonDefaults.elevation (Button.kt:350)");
        }
        obj14 = 0;
        obj14 = 0;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return this.elevation-R_JCAzs(f2, f, f3, Dp.constructor-impl((float)obj13), Dp.constructor-impl((float)obj13), composer, obj13 | obj14, 0);
    }

    public final PaddingValues getContentPadding() {
        return ButtonDefaults.ContentPadding;
    }

    public final float getIconSize-D9Ej5fM() {
        return ButtonDefaults.IconSize;
    }

    public final float getIconSpacing-D9Ej5fM() {
        return ButtonDefaults.IconSpacing;
    }

    public final float getMinHeight-D9Ej5fM() {
        return ButtonDefaults.MinHeight;
    }

    public final float getMinWidth-D9Ej5fM() {
        return ButtonDefaults.MinWidth;
    }

    public final BorderStroke getOutlinedBorder(Composer $composer, int $changed) {
        boolean traceInProgress;
        String str;
        int i = -2091313033;
        ComposerKt.sourceInformationMarkerStart($composer, i, "C478@19678L6:Button.kt#jmzs0o");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i, $changed, -1, "androidx.compose.material.ButtonDefaults.<get-outlinedBorder> (Button.kt:477)");
        }
        long onSurface-0d7_KjU = MaterialTheme.INSTANCE.getColors($composer, 6).getOnSurface-0d7_KjU();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return BorderStrokeKt.BorderStroke-cXLIe8U(ButtonDefaults.OutlinedBorderSize, Color.copy-wmQWz5c$default(onSurface-0d7_KjU, obj3, 1039516303, 0, 0, 0, 14));
    }

    public final float getOutlinedBorderSize-D9Ej5fM() {
        return ButtonDefaults.OutlinedBorderSize;
    }

    public final PaddingValues getTextButtonContentPadding() {
        return ButtonDefaults.TextButtonContentPadding;
    }

    public final androidx.compose.material.ButtonColors outlinedButtonColors-RGew2ao(long backgroundColor, long contentColor, long disabledContentColor, Composer $composer, int $changed, int i6) {
        androidx.compose.material.Colors colors2;
        androidx.compose.material.Colors colors;
        long copy-wmQWz5c$default;
        boolean traceInProgress;
        int str;
        long primary-0d7_KjU;
        int i;
        long l;
        long l3;
        long onSurface-0d7_KjU;
        long l2;
        int i5;
        int i3;
        int i2;
        int i7;
        int i4;
        final Composer composer = obj26;
        int i8 = -2124406093;
        ComposerKt.sourceInformationMarkerStart(composer, i8, "C(outlinedButtonColors)P(0:c#ui.graphics.Color,1:c#ui.graphics.Color,2:c#ui.graphics.Color)430@17899L6,431@17959L6,432@18027L6,433@18083L8:Button.kt#jmzs0o");
        str = 6;
        if (obj28 & 1 != 0) {
            l = primary-0d7_KjU;
        } else {
            l = backgroundColor;
        }
        if (obj28 & 2 != 0) {
            l3 = primary-0d7_KjU;
        } else {
            l3 = disabledContentColor;
        }
        if (obj28 & 4 != 0) {
            l2 = copy-wmQWz5c$default;
        } else {
            l2 = $changed;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i8, obj27, -1, "androidx.compose.material.ButtonDefaults.outlinedButtonColors (Button.kt:434)");
        } else {
            i = obj27;
        }
        DefaultButtonColors defaultButtonColors = new DefaultButtonColors(l, obj8, l3, obj10, l, obj12, l2, i5, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return (ButtonColors)defaultButtonColors;
    }

    public final androidx.compose.material.ButtonColors textButtonColors-RGew2ao(long backgroundColor, long contentColor, long disabledContentColor, Composer $composer, int $changed, int i6) {
        long transparent-0d7_KjU;
        androidx.compose.material.Colors colors;
        long copy-wmQWz5c$default;
        boolean traceInProgress;
        int str;
        long l2;
        long contentColor2;
        long onSurface-0d7_KjU;
        long l;
        int i5;
        int i7;
        int i;
        int i2;
        int i3;
        int i4;
        final Composer composer = obj24;
        int i8 = 182742216;
        ComposerKt.sourceInformationMarkerStart(composer, i8, "C(textButtonColors)P(0:c#ui.graphics.Color,1:c#ui.graphics.Color,2:c#ui.graphics.Color)452@18850L6,453@18918L6,454@18974L8:Button.kt#jmzs0o");
        if (obj26 & 1 != 0) {
            l2 = transparent-0d7_KjU;
        } else {
            l2 = backgroundColor;
        }
        str = 6;
        if (obj26 & 2 != 0) {
            contentColor2 = MaterialTheme.INSTANCE.getColors(composer, str).getPrimary-0d7_KjU();
        } else {
            contentColor2 = disabledContentColor;
        }
        if (obj26 & 4 != 0) {
            l = copy-wmQWz5c$default;
        } else {
            l = $changed;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i8, obj25, -1, "androidx.compose.material.ButtonDefaults.textButtonColors (Button.kt:455)");
        } else {
            i2 = obj25;
        }
        DefaultButtonColors defaultButtonColors = new DefaultButtonColors(l2, obj6, contentColor2, obj8, l2, obj10, l, i5, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return (ButtonColors)defaultButtonColors;
    }
}
