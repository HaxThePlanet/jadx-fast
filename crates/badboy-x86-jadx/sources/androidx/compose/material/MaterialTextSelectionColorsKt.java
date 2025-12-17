package androidx.compose.material;

import androidx.compose.foundation.text.selection.TextSelectionColors;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Composer.Companion;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000 \n\u0000\n\u0002\u0010\u0007\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u001a*\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0008\u001a\u00020\u0006H\u0002ø\u0001\u0000¢\u0006\u0004\u0008\t\u0010\n\u001a\"\u0010\u000b\u001a\u00020\u00012\u0006\u0010\u000c\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u0006H\u0000ø\u0001\u0000¢\u0006\u0004\u0008\u000e\u0010\u000f\u001a2\u0010\u000b\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0008\u001a\u00020\u0006H\u0002ø\u0001\u0000¢\u0006\u0004\u0008\u0011\u0010\u0012\u001a*\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0008\u001a\u00020\u0006H\u0000ø\u0001\u0000¢\u0006\u0004\u0008\u0014\u0010\u0015\u001a\u0015\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0001¢\u0006\u0002\u0010\u001a\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006\u001b", d2 = {"DefaultSelectionBackgroundAlpha", "", "DesiredContrastRatio", "MinimumSelectionBackgroundAlpha", "binarySearchForAccessibleSelectionColorAlpha", "selectionColor", "Landroidx/compose/ui/graphics/Color;", "textColor", "backgroundColor", "binarySearchForAccessibleSelectionColorAlpha-ysEtTa8", "(JJJ)F", "calculateContrastRatio", "foreground", "background", "calculateContrastRatio--OWjLjI", "(JJ)F", "selectionColorAlpha", "calculateContrastRatio-nb2GgbA", "(JFJJ)F", "calculateSelectionBackgroundColor", "calculateSelectionBackgroundColor-ysEtTa8", "(JJJ)J", "rememberTextSelectionColors", "Landroidx/compose/foundation/text/selection/TextSelectionColors;", "colors", "Landroidx/compose/material/Colors;", "(Landroidx/compose/material/Colors;Landroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/text/selection/TextSelectionColors;", "material_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class MaterialTextSelectionColorsKt {

    private static final float DefaultSelectionBackgroundAlpha = 0.4f;
    private static final float DesiredContrastRatio = 4.5f;
    private static final float MinimumSelectionBackgroundAlpha = 0.2f;
    private static final float binarySearchForAccessibleSelectionColorAlpha-ysEtTa8(long selectionColor, long textColor, long backgroundColor) {
        int attempts;
        int lowAlpha;
        int i;
        int i2;
        int cmp2;
        int alpha;
        int cmp;
        long l;
        Object obj2;
        int highAlpha;
        float contrastRatio-nb2GgbA;
        attempts = 0;
        lowAlpha = 1045220557;
        alpha = i;
        highAlpha = i2;
        while (attempts < 7) {
            i5 -= i6;
            i2 = 0;
            l = 0;
            if (Float.compare(i2, i) <= 0 && Float.compare(i, i7) <= 0) {
            }
            if (l == 0) {
            }
            if (Float.compare(i, i2) < 0) {
            } else {
            }
            lowAlpha = alpha;
            alpha = i2 / cmp;
            attempts++;
            highAlpha = cmp2;
            if (Float.compare(i, i7) <= 0) {
            }
            l = 1;
        }
        return alpha;
    }

    public static final float calculateContrastRatio--OWjLjI(long foreground, long background) {
        int i2 = 1028443341;
        luminance-8_81llA += i2;
        luminance-8_81llA2 += i2;
        return f /= f2;
    }

    private static final float calculateContrastRatio-nb2GgbA(long selectionColor, float selectionColorAlpha, long textColor, long backgroundColor) {
        final int i2 = 0;
        long obj8 = ColorKt.compositeOver--OWjLjI(Color.copy-wmQWz5c$default(selectionColor, obj1, textColor, 0, i2, 0, 14), selectionColorAlpha);
        return MaterialTextSelectionColorsKt.calculateContrastRatio--OWjLjI(ColorKt.compositeOver--OWjLjI(backgroundColor, obj12), i2);
    }

    public static final long calculateSelectionBackgroundColor-ysEtTa8(long selectionColor, long textColor, long backgroundColor) {
        int textColor2;
        long l;
        long l2;
        int obj12;
        long obj13;
        final Object obj = selectionColor;
        long l4 = backgroundColor;
        long l5 = obj14;
        obj12 = 1083179008;
        if (Float.compare(obj10, obj12) >= 0) {
            textColor2 = obj12;
            obj13 = l4;
            l2 = l5;
        } else {
            if (Float.compare(obj11, obj12) < 0) {
                textColor2 = obj12;
                obj13 = l4;
                l2 = l5;
            } else {
                long l3 = l4;
                l = l5;
                obj13 = l3;
                l2 = l;
                textColor2 = obj12;
            }
        }
        return Color.copy-wmQWz5c$default(obj, obj1, textColor2, 0, 0, 0, 14);
    }

    public static final TextSelectionColors rememberTextSelectionColors(androidx.compose.material.Colors colors, Composer $composer, int $changed) {
        int traceInProgress;
        String str2;
        int i;
        int i2;
        long unbox-impl;
        int i5;
        int i3;
        long l;
        Object consume;
        String str;
        Object textSelectionColors;
        int primary-0d7_KjU;
        int selectionBackgroundColor-ysEtTa8;
        int i4;
        final Composer composer = $composer;
        int i6 = -721696685;
        ComposerKt.sourceInformationMarkerStart(composer, i6, "C(rememberTextSelectionColors)45@1902L6,47@1930L384:MaterialTextSelectionColors.kt#jmzs0o");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i6, $changed, -1, "androidx.compose.material.rememberTextSelectionColors (MaterialTextSelectionColors.kt:35)");
        } else {
            i = $changed;
        }
        final long primary-0d7_KjU2 = colors.getPrimary-0d7_KjU();
        final long background-0d7_KjU = colors.getBackground-0d7_KjU();
        composer.startReplaceGroup(1102762072);
        ComposerKt.sourceInformation(composer, "*43@1845L7");
        Object obj = colors;
        long contentColorFor-4WTKRHQ = ColorsKt.contentColorFor-4WTKRHQ(obj, background-0d7_KjU);
        int i12 = 0;
        i2 = 0;
        i3 = Long.compare(unbox-impl, i14) != 0 ? 1 : 0;
        if (i3 != 0) {
            l = contentColorFor-4WTKRHQ;
        } else {
            i2 = 0;
            i5 = 6;
            int i16 = 0;
            ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            ComposerKt.sourceInformationMarkerEnd(composer);
            l = unbox-impl;
        }
        composer.endReplaceGroup();
        final int i19 = 14;
        final int i18 = 0;
        long copy-wmQWz5c$default = Color.copy-wmQWz5c$default(l, consume, ContentAlpha.INSTANCE.getMedium(composer, 6), 0, i18, 0, i19);
        ComposerKt.sourceInformationMarkerStart(composer, 1102766492, "CC(remember):MaterialTextSelectionColors.kt#9igjgp");
        Composer composer2 = $composer;
        int i13 = 0;
        Object rememberedValue = composer2.rememberedValue();
        int i15 = 0;
        if (i9 |= changed3 == 0) {
            if (rememberedValue == Composer.Companion.getEmpty()) {
                consume = 0;
                textSelectionColors = new TextSelectionColors(obj.getPrimary-0d7_KjU(), i18, MaterialTextSelectionColorsKt.calculateSelectionBackgroundColor-ysEtTa8(primary-0d7_KjU2, obj6, copy-wmQWz5c$default), i19, 0);
                composer2.updateRememberedValue(textSelectionColors);
            } else {
                textSelectionColors = rememberedValue;
            }
        } else {
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return (TextSelectionColors)textSelectionColors;
    }
}
