package androidx.compose.ui.text.platform.extensions;

import android.graphics.Typeface;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.Size.Companion;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Color.Companion;
import androidx.compose.ui.text.SpanStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontStyle.Companion;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontSynthesis.Companion;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.font.FontWeight.Companion;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.intl.LocaleList.Companion;
import androidx.compose.ui.text.platform.AndroidTextPaint;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.BaselineShift.Companion;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.text.style.TextGeometricTransform.Companion;
import androidx.compose.ui.text.style.TextMotion;
import androidx.compose.ui.text.style.TextMotion.Companion;
import androidx.compose.ui.text.style.TextMotion.Linearity;
import androidx.compose.ui.text.style.TextMotion.Linearity.Companion;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.TextUnit;
import androidx.compose.ui.unit.TextUnit.Companion;
import androidx.compose.ui.unit.TextUnitType;
import androidx.compose.ui.unit.TextUnitType.Companion;
import kotlin.Metadata;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000`\n\u0000\n\u0002\u0010\u0007\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0000\u001a6\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00082\u0006\u0010\t\u001a\u00020\n2\u0008\u0010\u000b\u001a\u0004\u0018\u00010\u000cH\u0002ø\u0001\u0000¢\u0006\u0004\u0008\r\u0010\u000e\u001aP\u0010\u000f\u001a\u0004\u0018\u00010\u0004*\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00042&\u0010\u0012\u001a\"\u0012\u0006\u0012\u0004\u0018\u00010\u0014\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00180\u00132\u0006\u0010\u0019\u001a\u00020\u001a2\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u0008H\u0000\u001a\u000c\u0010\u001b\u001a\u00020\u0008*\u00020\u0004H\u0000\u001a\u0016\u0010\u001c\u001a\u00020\u001d*\u00020\u00102\u0008\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0000\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006 ", d2 = {"correctBlurRadius", "", "blurRadius", "generateFallbackSpanStyle", "Landroidx/compose/ui/text/SpanStyle;", "letterSpacing", "Landroidx/compose/ui/unit/TextUnit;", "requiresLetterSpacing", "", "background", "Landroidx/compose/ui/graphics/Color;", "baselineShift", "Landroidx/compose/ui/text/style/BaselineShift;", "generateFallbackSpanStyle-62GTOB8", "(JZJLandroidx/compose/ui/text/style/BaselineShift;)Landroidx/compose/ui/text/SpanStyle;", "applySpanStyle", "Landroidx/compose/ui/text/platform/AndroidTextPaint;", "style", "resolveTypeface", "Lkotlin/Function4;", "Landroidx/compose/ui/text/font/FontFamily;", "Landroidx/compose/ui/text/font/FontWeight;", "Landroidx/compose/ui/text/font/FontStyle;", "Landroidx/compose/ui/text/font/FontSynthesis;", "Landroid/graphics/Typeface;", "density", "Landroidx/compose/ui/unit/Density;", "hasFontAttributes", "setTextMotion", "", "textMotion", "Landroidx/compose/ui/text/style/TextMotion;", "ui-text_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class TextPaintExtensions_androidKt {
    public static final SpanStyle applySpanStyle(AndroidTextPaint $this$applySpanStyle, SpanStyle style, Function4<? super FontFamily, ? super FontWeight, ? super FontStyle, ? super FontSynthesis, ? extends Typeface> resolveTypeface, Density density, boolean requiresLetterSpacing) {
        boolean equals-impl02;
        boolean fontAttributes;
        LocaleList localeList;
        String fontFeatureSettings;
        TextGeometricTransform textGeometricTransform;
        int equals-impl0;
        int value-impl;
        long none$ui_text_release;
        long unspecified-NH-jbRc;
        long em-UIouoOA;
        int normal-_-LCdwA;
        int sp-UIouoOA;
        int all-GVVA2EU;
        FontSynthesis box-impl;
        float alpha;
        float $this$applySpanStyle_u24lambda_u241;
        int i;
        long letterSpacing-XSAIIZE;
        long type-UIouoOA = TextUnit.getType-UIouoOA(style.getFontSize-XSAIIZE());
        if (TextUnitType.equals-impl0(type-UIouoOA, obj1)) {
            none$ui_text_release = 0;
            $this$applySpanStyle.setTextSize(density.toPx--R2X_6o(style.getFontSize-XSAIIZE()));
        } else {
            em-UIouoOA = TextUnitType.Companion.getEm-UIouoOA();
            if (TextUnitType.equals-impl0(type-UIouoOA, obj1)) {
                $this$applySpanStyle.setTextSize(textSize *= none$ui_text_release);
            }
        }
        if (TextPaintExtensions_androidKt.hasFontAttributes(style) && style.getFontWeight() == null) {
            if (style.getFontWeight() == null) {
                none$ui_text_release = FontWeight.Companion.getNormal();
            }
            FontStyle fontStyle-4Lr2A7w = style.getFontStyle-4Lr2A7w();
            if (fontStyle-4Lr2A7w != null) {
                normal-_-LCdwA = fontStyle-4Lr2A7w.unbox-impl();
            } else {
                normal-_-LCdwA = FontStyle.Companion.getNormal-_-LCdwA();
            }
            FontSynthesis fontSynthesis-ZQGJjVo = style.getFontSynthesis-ZQGJjVo();
            if (fontSynthesis-ZQGJjVo != null) {
                all-GVVA2EU = fontSynthesis-ZQGJjVo.unbox-impl();
            } else {
                all-GVVA2EU = FontSynthesis.Companion.getAll-GVVA2EU();
            }
            $this$applySpanStyle.setTypeface((Typeface)resolveTypeface.invoke(style.getFontFamily(), none$ui_text_release, FontStyle.box-impl(normal-_-LCdwA), FontSynthesis.box-impl(all-GVVA2EU)));
        }
        if (style.getLocaleList() != null && !Intrinsics.areEqual(style.getLocaleList(), LocaleList.Companion.getCurrent())) {
            if (!Intrinsics.areEqual(style.getLocaleList(), LocaleList.Companion.getCurrent())) {
                LocaleListHelperMethods.INSTANCE.setTextLocales($this$applySpanStyle, style.getLocaleList());
            }
        }
        if (style.getFontFeatureSettings() != null && !Intrinsics.areEqual(style.getFontFeatureSettings(), "")) {
            if (!Intrinsics.areEqual(style.getFontFeatureSettings(), "")) {
                $this$applySpanStyle.setFontFeatureSettings(style.getFontFeatureSettings());
            }
        }
        if (style.getTextGeometricTransform() != null && !Intrinsics.areEqual(style.getTextGeometricTransform(), TextGeometricTransform.Companion.getNone$ui_text_release())) {
            if (!Intrinsics.areEqual(style.getTextGeometricTransform(), TextGeometricTransform.Companion.getNone$ui_text_release())) {
                $this$applySpanStyle.setTextScaleX(textScaleX *= scaleX);
                $this$applySpanStyle.setTextSkewX(textSkewX += none$ui_text_release);
            }
        }
        $this$applySpanStyle.setColor-8_81llA(style.getColor-0d7_KjU());
        unspecified-NH-jbRc = Size.Companion.getUnspecified-NH-jbRc();
        alpha = style.getAlpha();
        $this$applySpanStyle.setBrush-12SF9DM(style.getBrush(), unspecified-NH-jbRc, em-UIouoOA);
        $this$applySpanStyle.setShadow(style.getShadow());
        $this$applySpanStyle.setTextDecoration(style.getTextDecoration());
        $this$applySpanStyle.setDrawStyle(style.getDrawStyle());
        if (TextUnitType.equals-impl0(TextUnit.getType-UIouoOA(style.getLetterSpacing-XSAIIZE()), unspecified-NH-jbRc)) {
            unspecified-NH-jbRc = 0;
            alpha = 0;
            equals-impl0 = Float.compare(value-impl2, unspecified-NH-jbRc) == 0 ? sp-UIouoOA : alpha;
            if (equals-impl0 == 0) {
                textSize2 *= textScaleX2;
                i = 0;
                if (Float.compare(value-impl, unspecified-NH-jbRc) == 0) {
                } else {
                    sp-UIouoOA = alpha;
                }
                if (sp-UIouoOA == 0) {
                    $this$applySpanStyle.setLetterSpacing($this$applySpanStyle_u24lambda_u241 / value-impl);
                }
            } else {
                if (TextUnitType.equals-impl0(TextUnit.getType-UIouoOA(style.getLetterSpacing-XSAIIZE()), unspecified-NH-jbRc)) {
                    $this$applySpanStyle.setLetterSpacing(TextUnit.getValue-impl(style.getLetterSpacing-XSAIIZE()));
                }
            }
        } else {
        }
        return TextPaintExtensions_androidKt.generateFallbackSpanStyle-62GTOB8(style.getLetterSpacing-XSAIIZE(), sp-UIouoOA, requiresLetterSpacing, style.getBackground-0d7_KjU());
    }

    public static SpanStyle applySpanStyle$default(AndroidTextPaint androidTextPaint, SpanStyle spanStyle2, Function4 function43, Density density4, boolean z5, int i6, Object object7) {
        int obj4;
        if (i6 &= 8 != 0) {
            obj4 = 0;
        }
        return TextPaintExtensions_androidKt.applySpanStyle(androidTextPaint, spanStyle2, function43, density4, obj4);
    }

    public static final float correctBlurRadius(float blurRadius) {
        int i;
        int i2;
        i = Float.compare(blurRadius, i3) == 0 ? 1 : 0;
        i2 = i != 0 ? 1 : blurRadius;
        return i2;
    }

    private static final SpanStyle generateFallbackSpanStyle-62GTOB8(long letterSpacing, boolean requiresLetterSpacing, long background, BaselineShift baselineShift) {
        int i13;
        int i19;
        int i5;
        int equals-impl0;
        int i8;
        int i6;
        boolean equals-impl02;
        long unspecified-XSAIIZE;
        float unbox-impl;
        SpanStyle spanStyle;
        int i;
        int i10;
        int i7;
        int i4;
        int i9;
        int i21;
        int i14;
        long l2;
        int i2;
        int i3;
        int i16;
        long l;
        int i11;
        int i12;
        int i20;
        int i18;
        int i15;
        int i17;
        final long l3 = baselineShift;
        i13 = 1;
        int i22 = 0;
        if (background != 0 && TextUnitType.equals-impl0(TextUnit.getType-UIouoOA(letterSpacing), obj5)) {
            if (TextUnitType.equals-impl0(TextUnit.getType-UIouoOA(letterSpacing), obj5)) {
                equals-impl0 = Float.compare(value-impl, i8) == 0 ? i13 : i22;
                i5 = equals-impl0 == 0 ? i13 : i22;
            } else {
            }
        } else {
        }
        if (!Color.equals-impl0(l3, obj1) && !Color.equals-impl0(l3, obj1)) {
            i6 = !Color.equals-impl0(l3, obj1) ? i13 : i22;
        } else {
        }
        if (obj36 != null && !BaselineShift.equals-impl0(obj36.unbox-impl(), BaselineShift.Companion.getNone-y9eOQZs())) {
            if (!BaselineShift.equals-impl0(obj36.unbox-impl(), BaselineShift.Companion.getNone-y9eOQZs())) {
            } else {
                i13 = i22;
            }
        } else {
        }
        if (i5 == 0 && i6 == 0 && i13 == 0) {
            if (i6 == 0) {
                if (i13 == 0) {
                } else {
                    if (i5 != 0) {
                        l2 = letterSpacing;
                    } else {
                        l2 = unspecified-XSAIIZE;
                    }
                    if (i6 != 0) {
                        l = l3;
                    } else {
                        l = unspecified-XSAIIZE;
                    }
                    i2 = i13 != 0 ? obj36 : i19;
                    spanStyle = new SpanStyle(0, obj10, 0, obj12, 0, 0, 0, 0, 0, l2, obj19, i2, 0, 0, l, obj24, 0, 0, 0, 0, 63103, 0);
                    i19 = spanStyle;
                }
            } else {
            }
        } else {
        }
        return i19;
    }

    public static final boolean hasFontAttributes(SpanStyle $this$hasFontAttributes) {
        Object fontStyle-4Lr2A7w;
        int i;
        if ($this$hasFontAttributes.getFontFamily() == null && $this$hasFontAttributes.getFontStyle-4Lr2A7w() == null) {
            if ($this$hasFontAttributes.getFontStyle-4Lr2A7w() == null) {
                if ($this$hasFontAttributes.getFontWeight() != null) {
                    i = 1;
                } else {
                    i = 0;
                }
            } else {
            }
        } else {
        }
        return i;
    }

    public static final void setTextMotion(AndroidTextPaint $this$setTextMotion, TextMotion textMotion) {
        TextMotion static;
        int i;
        int equals-impl0;
        boolean equals-impl02;
        if (textMotion == null) {
            static = TextMotion.Companion.getStatic();
        } else {
            static = textMotion;
        }
        if (static.getSubpixelTextPositioning$ui_text_release()) {
            flags3 |= 128;
        } else {
            flags2 &= -129;
        }
        $this$setTextMotion.setFlags(i);
        int linearity-4e0Vf04$ui_text_release = static.getLinearity-4e0Vf04$ui_text_release();
        final int i2 = 0;
        if (TextMotion.Linearity.equals-impl0(linearity-4e0Vf04$ui_text_release, TextMotion.Linearity.Companion.getLinear-4e0Vf04())) {
            $this$setTextMotion.setFlags(flags |= 64);
            $this$setTextMotion.setHinting(i2);
        } else {
            if (TextMotion.Linearity.equals-impl0(linearity-4e0Vf04$ui_text_release, TextMotion.Linearity.Companion.getFontHinting-4e0Vf04())) {
                $this$setTextMotion.getFlags();
                $this$setTextMotion.setHinting(1);
            } else {
                if (TextMotion.Linearity.equals-impl0(linearity-4e0Vf04$ui_text_release, TextMotion.Linearity.Companion.getNone-4e0Vf04())) {
                    $this$setTextMotion.getFlags();
                    $this$setTextMotion.setHinting(i2);
                } else {
                    $this$setTextMotion.getFlags();
                }
            }
        }
    }
}
