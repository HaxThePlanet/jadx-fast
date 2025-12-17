package androidx.compose.ui.text;

import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Color.Companion;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.Shadow.Companion;
import androidx.compose.ui.graphics.ShadowKt;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.graphics.drawscope.Fill;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontFamily.Companion;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontStyle.Companion;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontSynthesis.Companion;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.font.FontWeight.Companion;
import androidx.compose.ui.text.font.FontWeightKt;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.intl.LocaleList.Companion;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.BaselineShift.Companion;
import androidx.compose.ui.text.style.BaselineShiftKt;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextDecoration.Companion;
import androidx.compose.ui.text.style.TextDrawStyleKt;
import androidx.compose.ui.text.style.TextForegroundStyle;
import androidx.compose.ui.text.style.TextForegroundStyle.Companion;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.text.style.TextGeometricTransform.Companion;
import androidx.compose.ui.text.style.TextGeometricTransformKt;
import androidx.compose.ui.unit.TextUnit;
import androidx.compose.ui.unit.TextUnitKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u0082\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0007\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\t\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\u001a\u001e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u000c\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u000e\u001a+\u0010\u000f\u001a\u0002H\u0010\"\u0004\u0008\u0000\u0010\u00102\u0006\u0010\u0011\u001a\u0002H\u00102\u0006\u0010\u0012\u001a\u0002H\u00102\u0006\u0010\r\u001a\u00020\u000eH\u0000¢\u0006\u0002\u0010\u0013\u001a&\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0008\u0010\u000b\u001a\u0004\u0018\u00010\u00152\u0008\u0010\u000c\u001a\u0004\u0018\u00010\u00152\u0006\u0010\r\u001a\u00020\u000eH\u0002\u001a*\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u000eH\u0000ø\u0001\u0000¢\u0006\u0004\u0008\u0018\u0010\u0019\u001a\u0010\u0010\u001a\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\nH\u0000\u001aÀ\u0001\u0010\u001c\u001a\u00020\n*\u00020\n2\u0006\u0010\u001d\u001a\u00020\u00012\u0008\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\u0006\u0010 \u001a\u00020\u000e2\u0006\u0010!\u001a\u00020\u00072\u0008\u0010\"\u001a\u0004\u0018\u00010#2\u0008\u0010$\u001a\u0004\u0018\u00010%2\u0008\u0010&\u001a\u0004\u0018\u00010'2\u0008\u0010(\u001a\u0004\u0018\u00010)2\u0008\u0010*\u001a\u0004\u0018\u00010+2\u0006\u0010,\u001a\u00020\u00072\u0008\u0010-\u001a\u0004\u0018\u00010.2\u0008\u0010/\u001a\u0004\u0018\u0001002\u0008\u00101\u001a\u0004\u0018\u0001022\u0006\u00103\u001a\u00020\u00012\u0008\u00104\u001a\u0004\u0018\u0001052\u0008\u00106\u001a\u0004\u0018\u0001072\u0008\u00108\u001a\u0004\u0018\u00010\u00152\u0008\u00109\u001a\u0004\u0018\u00010:H\u0000ø\u0001\u0000¢\u0006\u0004\u0008;\u0010<\u001a\u0018\u0010=\u001a\u0004\u0018\u00010\u0015*\u00020\n2\u0008\u0010>\u001a\u0004\u0018\u00010\u0015H\u0002\"\u0010\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\u0003\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0010\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\u0008\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006?", d2 = {"DefaultBackgroundColor", "Landroidx/compose/ui/graphics/Color;", "J", "DefaultColor", "DefaultColorForegroundStyle", "Landroidx/compose/ui/text/style/TextForegroundStyle;", "DefaultFontSize", "Landroidx/compose/ui/unit/TextUnit;", "DefaultLetterSpacing", "lerp", "Landroidx/compose/ui/text/SpanStyle;", "start", "stop", "fraction", "", "lerpDiscrete", "T", "a", "b", "(Ljava/lang/Object;Ljava/lang/Object;F)Ljava/lang/Object;", "lerpPlatformStyle", "Landroidx/compose/ui/text/PlatformSpanStyle;", "lerpTextUnitInheritable", "t", "lerpTextUnitInheritable-C3pnCVY", "(JJF)J", "resolveSpanStyleDefaults", "style", "fastMerge", "color", "brush", "Landroidx/compose/ui/graphics/Brush;", "alpha", "fontSize", "fontWeight", "Landroidx/compose/ui/text/font/FontWeight;", "fontStyle", "Landroidx/compose/ui/text/font/FontStyle;", "fontSynthesis", "Landroidx/compose/ui/text/font/FontSynthesis;", "fontFamily", "Landroidx/compose/ui/text/font/FontFamily;", "fontFeatureSettings", "", "letterSpacing", "baselineShift", "Landroidx/compose/ui/text/style/BaselineShift;", "textGeometricTransform", "Landroidx/compose/ui/text/style/TextGeometricTransform;", "localeList", "Landroidx/compose/ui/text/intl/LocaleList;", "background", "textDecoration", "Landroidx/compose/ui/text/style/TextDecoration;", "shadow", "Landroidx/compose/ui/graphics/Shadow;", "platformStyle", "drawStyle", "Landroidx/compose/ui/graphics/drawscope/DrawStyle;", "fastMerge-dSHsh3o", "(Landroidx/compose/ui/text/SpanStyle;JLandroidx/compose/ui/graphics/Brush;FJLandroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/text/font/FontStyle;Landroidx/compose/ui/text/font/FontSynthesis;Landroidx/compose/ui/text/font/FontFamily;Ljava/lang/String;JLandroidx/compose/ui/text/style/BaselineShift;Landroidx/compose/ui/text/style/TextGeometricTransform;Landroidx/compose/ui/text/intl/LocaleList;JLandroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/graphics/Shadow;Landroidx/compose/ui/text/PlatformSpanStyle;Landroidx/compose/ui/graphics/drawscope/DrawStyle;)Landroidx/compose/ui/text/SpanStyle;", "mergePlatformStyle", "other", "ui-text_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class SpanStyleKt {

    private static final long DefaultBackgroundColor;
    private static final long DefaultColor;
    private static final TextForegroundStyle DefaultColorForegroundStyle;
    private static final long DefaultFontSize;
    private static final long DefaultLetterSpacing;
    static {
        SpanStyleKt.DefaultFontSize = TextUnitKt.getSp(14);
        SpanStyleKt.DefaultLetterSpacing = TextUnitKt.getSp(0);
        SpanStyleKt.DefaultBackgroundColor = Color.Companion.getTransparent-0d7_KjU();
        SpanStyleKt.DefaultColor = Color.Companion.getBlack-0d7_KjU();
        SpanStyleKt.DefaultColorForegroundStyle = TextForegroundStyle.Companion.from-8_81llA(SpanStyleKt.DefaultColor);
    }

    public static final TextForegroundStyle access$getDefaultColorForegroundStyle$p() {
        return SpanStyleKt.DefaultColorForegroundStyle;
    }

    public static final androidx.compose.ui.text.SpanStyle fastMerge-dSHsh3o(androidx.compose.ui.text.SpanStyle $this$fastMerge_u2ddSHsh3o, long color, Brush brush, float alpha, long fontSize, FontWeight fontWeight, FontStyle fontStyle, FontSynthesis fontSynthesis, FontFamily fontFamily, String fontFeatureSettings, long letterSpacing, BaselineShift baselineShift, TextGeometricTransform textGeometricTransform, LocaleList localeList, long background, TextDecoration textDecoration, Shadow shadow, androidx.compose.ui.text.PlatformSpanStyle platformStyle, DrawStyle drawStyle) {
        TextForegroundStyle from-8_81llA;
        Object textForegroundStyle$ui_text_release;
        long fontSynthesis-ZQGJjVo;
        long textGeometricTransform2;
        TextDecoration textDecoration2;
        long drawStyle2;
        int i4;
        Object equal3;
        Object obj11;
        boolean equal2;
        int i5;
        int i2;
        long l3;
        Object obj7;
        boolean $this$isSpecified$iv;
        boolean equal;
        int localeList2;
        Object obj4;
        int background-0d7_KjU;
        int i3;
        int unspecified--R2X_6o2;
        int unspecified--R2X_6o;
        long l2;
        Object obj3;
        Object obj6;
        Object obj12;
        FontFamily fontFamily2;
        Object obj2;
        long l;
        Object obj8;
        Object obj9;
        Object obj13;
        long i;
        Object obj5;
        Object obj10;
        Object obj;
        long l4 = color;
        final Object obj15 = alpha;
        final float f = fontSize;
        equal3 = fontSynthesis;
        equal2 = fontFamily;
        Object obj16 = fontFeatureSettings;
        final FontFamily fontFamily3 = letterSpacing;
        final Object obj17 = baselineShift;
        final Object obj18 = background;
        final Object obj19 = obj61;
        Object obj14 = obj64;
        int i9 = 0;
        int $this$isSpecified$iv2 = 16;
        i3 = 0;
        final int i11 = 1;
        if (!TextUnitKt.isUnspecified--R2X_6o(fontWeight)) {
            if (TextUnit.equals-impl0(fontWeight, obj12)) {
                if (obj15 == null) {
                    unspecified--R2X_6o2 = 0;
                    $this$isSpecified$iv = Long.compare(i7, $this$isSpecified$iv2) != 0 ? i11 : i3;
                    if ($this$isSpecified$iv != 0) {
                        if (Color.equals-impl0(l4, obj2)) {
                            if (equal2 != null) {
                                if (Intrinsics.areEqual(equal2, $this$fastMerge_u2ddSHsh3o.getFontStyle-4Lr2A7w())) {
                                    if (equal3 != null) {
                                        if (Intrinsics.areEqual(equal3, $this$fastMerge_u2ddSHsh3o.getFontWeight())) {
                                            if (fontFamily3 != null) {
                                                if (fontFamily3 == $this$fastMerge_u2ddSHsh3o.getFontFamily()) {
                                                    unspecified--R2X_6o2 = 0;
                                                    if (!TextUnitKt.isUnspecified--R2X_6o(textGeometricTransform)) {
                                                        if (TextUnit.equals-impl0(textGeometricTransform, equal2)) {
                                                            if (obj19 != null) {
                                                                if (Intrinsics.areEqual(obj19, $this$fastMerge_u2ddSHsh3o.getTextDecoration())) {
                                                                    if (Intrinsics.areEqual(obj15, $this$fastMerge_u2ddSHsh3o.getTextForegroundStyle$ui_text_release().getBrush())) {
                                                                        if (obj15 != null) {
                                                                            localeList2 = Float.compare(f, alpha2) == 0 ? i11 : i3;
                                                                            if (localeList2 != 0) {
                                                                                if (obj16 != null) {
                                                                                    if (Intrinsics.areEqual(obj16, $this$fastMerge_u2ddSHsh3o.getFontSynthesis-ZQGJjVo())) {
                                                                                        if (obj17 != null) {
                                                                                            if (Intrinsics.areEqual(obj17, $this$fastMerge_u2ddSHsh3o.getFontFeatureSettings())) {
                                                                                                if (obj18 != null) {
                                                                                                    if (Intrinsics.areEqual(obj18, $this$fastMerge_u2ddSHsh3o.getBaselineShift-5SSeXJ0())) {
                                                                                                        if (textDecoration != null) {
                                                                                                            if (Intrinsics.areEqual(textDecoration, $this$fastMerge_u2ddSHsh3o.getTextGeometricTransform())) {
                                                                                                                if (shadow != null) {
                                                                                                                    if (Intrinsics.areEqual(shadow, $this$fastMerge_u2ddSHsh3o.getLocaleList())) {
                                                                                                                        int i6 = 0;
                                                                                                                        i5 = Long.compare(unspecified--R2X_6o, $this$isSpecified$iv2) != 0 ? i11 : i3;
                                                                                                                        if (i5 != 0) {
                                                                                                                            if (Color.equals-impl0(platformStyle, fontFamily3)) {
                                                                                                                                if (obj62 != null) {
                                                                                                                                    if (Intrinsics.areEqual(obj62, $this$fastMerge_u2ddSHsh3o.getShadow())) {
                                                                                                                                        if (obj63 != null) {
                                                                                                                                            if (Intrinsics.areEqual(obj63, $this$fastMerge_u2ddSHsh3o.getPlatformStyle())) {
                                                                                                                                                if (obj14 != null && !Intrinsics.areEqual(obj14, $this$fastMerge_u2ddSHsh3o.getDrawStyle())) {
                                                                                                                                                    if (!Intrinsics.areEqual(obj14, $this$fastMerge_u2ddSHsh3o.getDrawStyle())) {
                                                                                                                                                        i4 = i11;
                                                                                                                                                    } else {
                                                                                                                                                        i4 = i3;
                                                                                                                                                    }
                                                                                                                                                } else {
                                                                                                                                                }
                                                                                                                                            } else {
                                                                                                                                            }
                                                                                                                                        } else {
                                                                                                                                            obj11 = obj63;
                                                                                                                                        }
                                                                                                                                    } else {
                                                                                                                                        obj11 = obj63;
                                                                                                                                    }
                                                                                                                                } else {
                                                                                                                                    obj7 = obj62;
                                                                                                                                }
                                                                                                                            } else {
                                                                                                                                obj7 = obj62;
                                                                                                                                obj11 = obj63;
                                                                                                                            }
                                                                                                                        } else {
                                                                                                                            i2 = platformStyle;
                                                                                                                        }
                                                                                                                    } else {
                                                                                                                        i2 = platformStyle;
                                                                                                                        obj7 = obj62;
                                                                                                                        obj11 = obj63;
                                                                                                                    }
                                                                                                                } else {
                                                                                                                    equal3 = shadow;
                                                                                                                }
                                                                                                            } else {
                                                                                                                i2 = platformStyle;
                                                                                                                obj7 = obj62;
                                                                                                                obj11 = obj63;
                                                                                                            }
                                                                                                        } else {
                                                                                                            obj4 = textDecoration;
                                                                                                        }
                                                                                                    } else {
                                                                                                        obj4 = textDecoration;
                                                                                                        i2 = platformStyle;
                                                                                                        obj7 = obj62;
                                                                                                        obj11 = obj63;
                                                                                                    }
                                                                                                } else {
                                                                                                }
                                                                                            } else {
                                                                                                obj4 = textDecoration;
                                                                                                i2 = platformStyle;
                                                                                                obj7 = obj62;
                                                                                                obj11 = obj63;
                                                                                            }
                                                                                        } else {
                                                                                        }
                                                                                    } else {
                                                                                        obj4 = textDecoration;
                                                                                        i2 = platformStyle;
                                                                                        obj7 = obj62;
                                                                                        obj11 = obj63;
                                                                                    }
                                                                                } else {
                                                                                }
                                                                            } else {
                                                                                obj4 = textDecoration;
                                                                                i2 = platformStyle;
                                                                                obj7 = obj62;
                                                                                obj11 = obj63;
                                                                            }
                                                                        } else {
                                                                        }
                                                                    } else {
                                                                        obj4 = textDecoration;
                                                                        i2 = platformStyle;
                                                                        obj7 = obj62;
                                                                        obj11 = obj63;
                                                                    }
                                                                } else {
                                                                    obj4 = textDecoration;
                                                                    i2 = platformStyle;
                                                                    obj7 = obj62;
                                                                    obj11 = obj63;
                                                                }
                                                            } else {
                                                            }
                                                        } else {
                                                            obj4 = textDecoration;
                                                            i2 = platformStyle;
                                                            obj7 = obj62;
                                                            obj11 = obj63;
                                                        }
                                                    } else {
                                                        equal3 = textGeometricTransform;
                                                    }
                                                } else {
                                                    obj4 = textDecoration;
                                                    i2 = platformStyle;
                                                    obj7 = obj62;
                                                    obj11 = obj63;
                                                }
                                            } else {
                                            }
                                        } else {
                                            obj4 = textDecoration;
                                            i2 = platformStyle;
                                            obj7 = obj62;
                                            obj11 = obj63;
                                        }
                                    } else {
                                    }
                                } else {
                                    obj4 = textDecoration;
                                    i2 = platformStyle;
                                    obj7 = obj62;
                                    obj11 = obj63;
                                }
                            } else {
                            }
                        } else {
                            obj4 = textDecoration;
                            i2 = platformStyle;
                            obj7 = obj62;
                            obj11 = obj63;
                        }
                    } else {
                    }
                } else {
                }
            } else {
                obj4 = textDecoration;
                i2 = platformStyle;
                obj7 = obj62;
                obj11 = obj63;
            }
        } else {
            l3 = fontWeight;
        }
        if (i4 == 0) {
            return $this$fastMerge_u2ddSHsh3o;
        }
        if (obj15 != null) {
            from-8_81llA = TextForegroundStyle.Companion.from(obj15, f);
        } else {
            from-8_81llA = TextForegroundStyle.Companion.from-8_81llA(l4);
        }
        if (letterSpacing == null) {
            fontFamily2 = textForegroundStyle$ui_text_release;
        } else {
            fontFamily2 = letterSpacing;
        }
        if (!TextUnitKt.isUnspecified--R2X_6o(l3)) {
            l2 = l3;
        } else {
            l2 = fontSynthesis-ZQGJjVo;
        }
        if (fontSynthesis == null) {
            obj3 = fontSynthesis-ZQGJjVo;
        } else {
            obj3 = fontSynthesis;
        }
        if (fontFamily == null) {
            obj6 = fontSynthesis-ZQGJjVo;
        } else {
            obj6 = fontFamily;
        }
        if (fontFeatureSettings == null) {
            obj12 = fontSynthesis-ZQGJjVo;
        } else {
            obj12 = fontFeatureSettings;
        }
        if (obj17 == null) {
            obj2 = fontSynthesis-ZQGJjVo;
        } else {
            obj2 = obj17;
        }
        if (!TextUnitKt.isUnspecified--R2X_6o(textGeometricTransform)) {
            l = textGeometricTransform;
        } else {
            l = textGeometricTransform2;
        }
        if (obj18 == null) {
            obj8 = textGeometricTransform2;
        } else {
            obj8 = obj18;
        }
        if (obj4 == null) {
            obj9 = textGeometricTransform2;
        } else {
            obj9 = obj4;
        }
        if (shadow == null) {
            obj13 = textGeometricTransform2;
        } else {
            obj13 = shadow;
        }
        textDecoration2 = platformStyle;
        int i10 = 0;
        int i12 = 0;
        if (Long.compare(i13, $this$isSpecified$iv2) != 0) {
            i3 = i11;
        }
        if (i3 != 0) {
            i = textDecoration2;
        } else {
            int i8 = 0;
            i = background-0d7_KjU;
        }
        if (obj19 == null) {
            obj5 = textDecoration2;
        } else {
            obj5 = obj19;
        }
        if (obj7 == null) {
            obj10 = textDecoration2;
        } else {
            obj10 = obj7;
        }
        androidx.compose.ui.text.SpanStyle spanStyle = $this$fastMerge_u2ddSHsh3o;
        if (obj64 == null) {
            obj = drawStyle2;
        } else {
            obj = obj64;
        }
        SpanStyle spanStyle2 = new SpanStyle($this$fastMerge_u2ddSHsh3o.getTextForegroundStyle$ui_text_release().merge(from-8_81llA), l2, obj24, obj3, obj6, obj12, fontFamily2, obj2, l, obj31, obj8, obj9, obj13, i, obj36, obj5, obj10, SpanStyleKt.mergePlatformStyle(spanStyle, obj11), obj, 0);
        return spanStyle2;
    }

    public static final androidx.compose.ui.text.SpanStyle lerp(androidx.compose.ui.text.SpanStyle start, androidx.compose.ui.text.SpanStyle stop, float fraction) {
        FontWeight fontWeight2;
        float constructor-impl;
        FontWeight fontWeight;
        float constructor-impl2;
        TextGeometricTransform textGeometricTransform2;
        TextGeometricTransform textGeometricTransform;
        Shadow shadow2;
        Shadow shadow3;
        Shadow shadow;
        int i;
        int i5;
        int i2;
        int i3;
        int i4;
        final float f = fraction;
        FontFamily fontFamily2 = stop.getFontFamily();
        long lerpTextUnitInheritable-C3pnCVY = SpanStyleKt.lerpTextUnitInheritable-C3pnCVY(start.getFontSize-XSAIIZE(), fontFamily2, stop.getFontSize-XSAIIZE());
        if (start.getFontWeight() == null) {
            fontWeight2 = FontWeight.Companion.getNormal();
        }
        if (stop.getFontWeight() == null) {
            fontWeight = FontWeight.Companion.getNormal();
        }
        String fontFeatureSettings2 = stop.getFontFeatureSettings();
        BaselineShift baselineShift-5SSeXJ0 = start.getBaselineShift-5SSeXJ0();
        int i6 = 0;
        if (baselineShift-5SSeXJ0 != null) {
            constructor-impl = baselineShift-5SSeXJ0.unbox-impl();
        } else {
            constructor-impl = BaselineShift.constructor-impl(i6);
        }
        BaselineShift baselineShift-5SSeXJ02 = stop.getBaselineShift-5SSeXJ0();
        if (baselineShift-5SSeXJ02 != null) {
            constructor-impl2 = baselineShift-5SSeXJ02.unbox-impl();
        } else {
            constructor-impl2 = BaselineShift.constructor-impl(i6);
        }
        if (start.getTextGeometricTransform() == null) {
            textGeometricTransform2 = TextGeometricTransform.Companion.getNone$ui_text_release();
        }
        if (stop.getTextGeometricTransform() == null) {
            textGeometricTransform = TextGeometricTransform.Companion.getNone$ui_text_release();
        }
        LocaleList localeList2 = stop.getLocaleList();
        if (start.getShadow() == null) {
            shadow = new Shadow(0, obj22, 0, obj24, 0, 7, 0);
            shadow2 = shadow;
        }
        if (stop.getShadow() == null) {
            shadow = new Shadow(0, obj22, 0, obj24, 0, 7, 0);
            shadow3 = shadow;
        }
        SpanStyle spanStyle = new SpanStyle(TextDrawStyleKt.lerp(start.getTextForegroundStyle$ui_text_release(), stop.getTextForegroundStyle$ui_text_release(), f), lerpTextUnitInheritable-C3pnCVY, obj6, FontWeightKt.lerp(fontWeight2, fontWeight, f), (FontStyle)SpanStyleKt.lerpDiscrete(start.getFontStyle-4Lr2A7w(), stop.getFontStyle-4Lr2A7w(), f), (FontSynthesis)SpanStyleKt.lerpDiscrete(start.getFontSynthesis-ZQGJjVo(), stop.getFontSynthesis-ZQGJjVo(), f), (FontFamily)SpanStyleKt.lerpDiscrete(start.getFontFamily(), fontFamily2, f), (String)SpanStyleKt.lerpDiscrete(start.getFontFeatureSettings(), fontFeatureSettings2, f), SpanStyleKt.lerpTextUnitInheritable-C3pnCVY(start.getLetterSpacing-XSAIIZE(), fontFeatureSettings2, stop.getLetterSpacing-XSAIIZE()), obj13, BaselineShift.box-impl(BaselineShiftKt.lerp-jWV1Mfo(constructor-impl, constructor-impl2, f)), TextGeometricTransformKt.lerp(textGeometricTransform2, textGeometricTransform, f), (LocaleList)SpanStyleKt.lerpDiscrete(start.getLocaleList(), localeList2, f), ColorKt.lerp-jxsXWHM(start.getBackground-0d7_KjU(), localeList2, stop.getBackground-0d7_KjU()), obj18, (TextDecoration)SpanStyleKt.lerpDiscrete(start.getTextDecoration(), stop.getTextDecoration(), f), ShadowKt.lerp(shadow2, shadow3, f), SpanStyleKt.lerpPlatformStyle(start.getPlatformStyle(), stop.getPlatformStyle(), f), (DrawStyle)SpanStyleKt.lerpDiscrete(start.getDrawStyle(), stop.getDrawStyle(), f), 0);
        return spanStyle;
    }

    public static final <T> T lerpDiscrete(T a, T b, float fraction) {
        Object obj;
        obj = Double.compare(d, l) < 0 ? a : b;
        return obj;
    }

    private static final androidx.compose.ui.text.PlatformSpanStyle lerpPlatformStyle(androidx.compose.ui.text.PlatformSpanStyle start, androidx.compose.ui.text.PlatformSpanStyle stop, float fraction) {
        androidx.compose.ui.text.PlatformSpanStyle default2;
        androidx.compose.ui.text.PlatformSpanStyle default;
        if (start == null && stop == null) {
            if (stop == null) {
                return null;
            }
        }
        if (start == null) {
            default2 = PlatformSpanStyle.Companion.getDefault();
        } else {
            default2 = start;
        }
        if (stop == null) {
            default = PlatformSpanStyle.Companion.getDefault();
        } else {
            default = stop;
        }
        return AndroidTextStyle_androidKt.lerp(default2, default, fraction);
    }

    public static final long lerpTextUnitInheritable-C3pnCVY(long a, long b, float t) {
        boolean unspecified--R2X_6o;
        if (!TextUnitKt.isUnspecified--R2X_6o(a) && TextUnitKt.isUnspecified--R2X_6o(t)) {
            if (TextUnitKt.isUnspecified--R2X_6o(t)) {
            }
            return TextUnitKt.lerp-C3pnCVY(a, b, t);
        }
        return (TextUnit)SpanStyleKt.lerpDiscrete(TextUnit.box-impl(a), TextUnit.box-impl(t), obj6).unbox-impl();
    }

    private static final androidx.compose.ui.text.PlatformSpanStyle mergePlatformStyle(androidx.compose.ui.text.SpanStyle $this$mergePlatformStyle, androidx.compose.ui.text.PlatformSpanStyle other) {
        if ($this$mergePlatformStyle.getPlatformStyle() == null) {
            return other;
        }
        if (other == null) {
            return $this$mergePlatformStyle.getPlatformStyle();
        }
        return $this$mergePlatformStyle.getPlatformStyle().merge(other);
    }

    public static final androidx.compose.ui.text.SpanStyle resolveSpanStyleDefaults(androidx.compose.ui.text.SpanStyle style) {
        long fontSize-XSAIIZE;
        FontWeight fontWeight;
        int normal-_-LCdwA;
        int all-GVVA2EU;
        FontFamily fontFamily;
        String fontFeatureSettings;
        long letterSpacing-XSAIIZE;
        float none-y9eOQZs;
        TextGeometricTransform textGeometricTransform;
        LocaleList localeList;
        TextDecoration textDecoration;
        Shadow shadow;
        DrawStyle drawStyle;
        long l;
        long defaultBackgroundColor;
        int i;
        final androidx.compose.ui.text.SpanStyleKt.resolveSpanStyleDefaults.1 iNSTANCE = SpanStyleKt.resolveSpanStyleDefaults.1.INSTANCE;
        if (TextUnitKt.isUnspecified--R2X_6o(style.getFontSize-XSAIIZE())) {
            fontSize-XSAIIZE = SpanStyleKt.DefaultFontSize;
        } else {
            fontSize-XSAIIZE = style.getFontSize-XSAIIZE();
        }
        if (style.getFontWeight() == null) {
            fontWeight = FontWeight.Companion.getNormal();
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
        if (style.getFontFamily() == null) {
            fontFamily = FontFamily.Companion.getDefault();
        }
        if (style.getFontFeatureSettings() == null) {
            fontFeatureSettings = "";
        }
        if (TextUnitKt.isUnspecified--R2X_6o(style.getLetterSpacing-XSAIIZE())) {
            l = letterSpacing-XSAIIZE;
        } else {
            l = letterSpacing-XSAIIZE;
        }
        BaselineShift baselineShift-5SSeXJ0 = style.getBaselineShift-5SSeXJ0();
        if (baselineShift-5SSeXJ0 != null) {
            none-y9eOQZs = baselineShift-5SSeXJ0.unbox-impl();
        } else {
            none-y9eOQZs = BaselineShift.Companion.getNone-y9eOQZs();
        }
        if (style.getTextGeometricTransform() == null) {
            textGeometricTransform = TextGeometricTransform.Companion.getNone$ui_text_release();
        }
        if (style.getLocaleList() == null) {
            localeList = LocaleList.Companion.getCurrent();
        }
        long background-0d7_KjU = style.getBackground-0d7_KjU();
        int i2 = 0;
        int i4 = 0;
        i = Long.compare(l3, i5) != 0 ? 1 : 0;
        if (i != 0) {
            defaultBackgroundColor = background-0d7_KjU;
        } else {
            int i3 = 0;
            defaultBackgroundColor = SpanStyleKt.DefaultBackgroundColor;
        }
        if (style.getTextDecoration() == null) {
            textDecoration = TextDecoration.Companion.getNone();
        }
        if (style.getShadow() == null) {
            shadow = Shadow.Companion.getNone();
        }
        if (style.getDrawStyle() == null) {
            drawStyle = Fill.INSTANCE;
        }
        SpanStyle spanStyle = new SpanStyle(style.getTextForegroundStyle$ui_text_release().takeOrElse((Function0)iNSTANCE), fontSize-XSAIIZE, obj5, fontWeight, FontStyle.box-impl(normal-_-LCdwA), FontSynthesis.box-impl(all-GVVA2EU), fontFamily, fontFeatureSettings, l, obj12, BaselineShift.box-impl(none-y9eOQZs), textGeometricTransform, localeList, defaultBackgroundColor, obj17, textDecoration, shadow, style.getPlatformStyle(), drawStyle, 0);
        return spanStyle;
    }
}
