package androidx.compose.ui.text.platform.extensions;

import android.graphics.Typeface;
import android.text.Spannable;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.LeadingMarginSpan.Standard;
import android.text.style.MetricAffectingSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.ScaleXSpan;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.text.AnnotatedString.Range;
import androidx.compose.ui.text.AnnotatedStringKt;
import androidx.compose.ui.text.SpanStyle;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.android.style.BaselineShiftSpan;
import androidx.compose.ui.text.android.style.FontFeatureSpan;
import androidx.compose.ui.text.android.style.LetterSpacingSpanEm;
import androidx.compose.ui.text.android.style.LetterSpacingSpanPx;
import androidx.compose.ui.text.android.style.LineHeightSpan;
import androidx.compose.ui.text.android.style.LineHeightStyleSpan;
import androidx.compose.ui.text.android.style.ShadowSpan;
import androidx.compose.ui.text.android.style.SkewXSpan;
import androidx.compose.ui.text.android.style.TextDecorationSpan;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.platform.style.DrawStyleSpan;
import androidx.compose.ui.text.platform.style.ShaderBrushSpan;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.LineHeightStyle;
import androidx.compose.ui.text.style.LineHeightStyle.Trim;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextDecoration.Companion;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.text.style.TextIndent;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.TextUnit;
import androidx.compose.ui.unit.TextUnitKt;
import androidx.compose.ui.unit.TextUnitType;
import androidx.compose.ui.unit.TextUnitType.Companion;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.math.MathKt;
import kotlin.text.StringsKt;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000Ð\u0001\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0010\u0007\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u001a$\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\u00082\u0006\u0010\t\u001a\u00020\nH\u0002ø\u0001\u0000¢\u0006\u0004\u0008\u000b\u0010\u000c\u001aF\u0010\r\u001a\u00020\u000e2\u0008\u0010\u000f\u001a\u0004\u0018\u00010\u00022\u0012\u0010\u0010\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00020\u00120\u00112\u001e\u0010\u0013\u001a\u001a\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u000e0\u0014H\u0000\u001a\u0010\u0010\u0016\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\nH\u0002\u001a*\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00082\u0006\u0010\u001a\u001a\u00020\u00182\u0006\u0010\t\u001a\u00020\nH\u0002ø\u0001\u0000¢\u0006\u0004\u0008\u001b\u0010\u001c\u001a\u000c\u0010\u001d\u001a\u00020\u0001*\u00020\u001eH\u0002\u001a\u0016\u0010\u001f\u001a\u00020\u0002*\u0004\u0018\u00010\u00022\u0006\u0010 \u001a\u00020\u0002H\u0002\u001a.\u0010!\u001a\u00020\u000e*\u00020\"2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u00152\u0006\u0010&\u001a\u00020\u0015H\u0000ø\u0001\u0000¢\u0006\u0004\u0008'\u0010(\u001a.\u0010)\u001a\u00020\u000e*\u00020\"2\u0008\u0010*\u001a\u0004\u0018\u00010+2\u0006\u0010%\u001a\u00020\u00152\u0006\u0010&\u001a\u00020\u0015H\u0002ø\u0001\u0000¢\u0006\u0002\u0008,\u001a.\u0010-\u001a\u00020\u000e*\u00020\"2\u0008\u0010.\u001a\u0004\u0018\u00010/2\u0006\u00100\u001a\u00020\u00182\u0006\u0010%\u001a\u00020\u00152\u0006\u0010&\u001a\u00020\u0015H\u0002\u001a.\u00101\u001a\u00020\u000e*\u00020\"2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u00152\u0006\u0010&\u001a\u00020\u0015H\u0000ø\u0001\u0000¢\u0006\u0004\u00082\u0010(\u001a&\u00103\u001a\u00020\u000e*\u00020\"2\u0008\u00104\u001a\u0004\u0018\u0001052\u0006\u0010%\u001a\u00020\u00152\u0006\u0010&\u001a\u00020\u0015H\u0002\u001aP\u00106\u001a\u00020\u000e*\u00020\"2\u0006\u00107\u001a\u00020\u001e2\u0012\u0010\u0010\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00020\u00120\u00112&\u00108\u001a\"\u0012\u0006\u0012\u0004\u0018\u00010:\u0012\u0004\u0012\u00020;\u0012\u0004\u0012\u00020<\u0012\u0004\u0012\u00020=\u0012\u0004\u0012\u00020>09H\u0002\u001a&\u0010?\u001a\u00020\u000e*\u00020\"2\u0008\u0010@\u001a\u0004\u0018\u00010A2\u0006\u0010%\u001a\u00020\u00152\u0006\u0010&\u001a\u00020\u0015H\u0002\u001a6\u0010B\u001a\u00020\u000e*\u00020\"2\u0006\u0010C\u001a\u00020\u00082\u0006\u0010\t\u001a\u00020\n2\u0006\u0010%\u001a\u00020\u00152\u0006\u0010&\u001a\u00020\u0015H\u0000ø\u0001\u0000¢\u0006\u0004\u0008D\u0010E\u001a&\u0010F\u001a\u00020\u000e*\u00020\"2\u0008\u0010G\u001a\u0004\u0018\u00010H2\u0006\u0010%\u001a\u00020\u00152\u0006\u0010&\u001a\u00020\u0015H\u0002\u001a.\u0010I\u001a\u00020\u000e*\u00020\"2\u0006\u0010\u0019\u001a\u00020\u00082\u0006\u0010\u001a\u001a\u00020\u00182\u0006\u0010\t\u001a\u00020\nH\u0000ø\u0001\u0000¢\u0006\u0004\u0008J\u0010K\u001a6\u0010I\u001a\u00020\u000e*\u00020\"2\u0006\u0010\u0019\u001a\u00020\u00082\u0006\u0010\u001a\u001a\u00020\u00182\u0006\u0010\t\u001a\u00020\n2\u0006\u0010L\u001a\u00020MH\u0000ø\u0001\u0000¢\u0006\u0004\u0008N\u0010O\u001a&\u0010P\u001a\u00020\u000e*\u00020\"2\u0008\u0010Q\u001a\u0004\u0018\u00010R2\u0006\u0010%\u001a\u00020\u00152\u0006\u0010&\u001a\u00020\u0015H\u0000\u001a&\u0010S\u001a\u00020\u000e*\u00020\"2\u0008\u0010T\u001a\u0004\u0018\u00010U2\u0006\u0010%\u001a\u00020\u00152\u0006\u0010&\u001a\u00020\u0015H\u0002\u001a$\u0010V\u001a\u00020\u000e*\u00020\"2\u0006\u0010W\u001a\u00020X2\u0006\u0010%\u001a\u00020\u00152\u0006\u0010&\u001a\u00020\u0015H\u0000\u001a\"\u0010Y\u001a\u00020\u000e*\u00020\"2\u000c\u0010Z\u001a\u0008\u0012\u0004\u0012\u00020\u00020\u00122\u0006\u0010\t\u001a\u00020\nH\u0002\u001aX\u0010[\u001a\u00020\u000e*\u00020\"2\u0006\u00107\u001a\u00020\u001e2\u0012\u0010\u0010\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00020\u00120\u00112\u0006\u0010\t\u001a\u00020\n2&\u00108\u001a\"\u0012\u0006\u0012\u0004\u0018\u00010:\u0012\u0004\u0012\u00020;\u0012\u0004\u0012\u00020<\u0012\u0004\u0012\u00020=\u0012\u0004\u0012\u00020>09H\u0000\u001a&\u0010\\\u001a\u00020\u000e*\u00020\"2\u0008\u0010]\u001a\u0004\u0018\u00010^2\u0006\u0010%\u001a\u00020\u00152\u0006\u0010&\u001a\u00020\u0015H\u0000\u001a&\u0010_\u001a\u00020\u000e*\u00020\"2\u0008\u0010`\u001a\u0004\u0018\u00010a2\u0006\u0010\u001a\u001a\u00020\u00182\u0006\u0010\t\u001a\u00020\nH\u0000\"\u0018\u0010\u0000\u001a\u00020\u0001*\u00020\u00028BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008\u0003\u0010\u0004\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006b", d2 = {"needsLetterSpacingSpan", "", "Landroidx/compose/ui/text/SpanStyle;", "getNeedsLetterSpacingSpan", "(Landroidx/compose/ui/text/SpanStyle;)Z", "createLetterSpacingSpan", "Landroid/text/style/MetricAffectingSpan;", "letterSpacing", "Landroidx/compose/ui/unit/TextUnit;", "density", "Landroidx/compose/ui/unit/Density;", "createLetterSpacingSpan-eAf_CNQ", "(JLandroidx/compose/ui/unit/Density;)Landroid/text/style/MetricAffectingSpan;", "flattenFontStylesAndApply", "", "contextFontSpanStyle", "spanStyles", "", "Landroidx/compose/ui/text/AnnotatedString$Range;", "block", "Lkotlin/Function3;", "", "isNonLinearFontScalingActive", "resolveLineHeightInPx", "", "lineHeight", "contextFontSize", "resolveLineHeightInPx-o2QH7mI", "(JFLandroidx/compose/ui/unit/Density;)F", "hasFontAttributes", "Landroidx/compose/ui/text/TextStyle;", "merge", "spanStyle", "setBackground", "Landroid/text/Spannable;", "color", "Landroidx/compose/ui/graphics/Color;", "start", "end", "setBackground-RPmYEkk", "(Landroid/text/Spannable;JII)V", "setBaselineShift", "baselineShift", "Landroidx/compose/ui/text/style/BaselineShift;", "setBaselineShift-0ocSgnM", "setBrush", "brush", "Landroidx/compose/ui/graphics/Brush;", "alpha", "setColor", "setColor-RPmYEkk", "setDrawStyle", "drawStyle", "Landroidx/compose/ui/graphics/drawscope/DrawStyle;", "setFontAttributes", "contextTextStyle", "resolveTypeface", "Lkotlin/Function4;", "Landroidx/compose/ui/text/font/FontFamily;", "Landroidx/compose/ui/text/font/FontWeight;", "Landroidx/compose/ui/text/font/FontStyle;", "Landroidx/compose/ui/text/font/FontSynthesis;", "Landroid/graphics/Typeface;", "setFontFeatureSettings", "fontFeatureSettings", "", "setFontSize", "fontSize", "setFontSize-KmRG4DE", "(Landroid/text/Spannable;JLandroidx/compose/ui/unit/Density;II)V", "setGeometricTransform", "textGeometricTransform", "Landroidx/compose/ui/text/style/TextGeometricTransform;", "setLineHeight", "setLineHeight-r9BaKPg", "(Landroid/text/Spannable;JFLandroidx/compose/ui/unit/Density;)V", "lineHeightStyle", "Landroidx/compose/ui/text/style/LineHeightStyle;", "setLineHeight-KmRG4DE", "(Landroid/text/Spannable;JFLandroidx/compose/ui/unit/Density;Landroidx/compose/ui/text/style/LineHeightStyle;)V", "setLocaleList", "localeList", "Landroidx/compose/ui/text/intl/LocaleList;", "setShadow", "shadow", "Landroidx/compose/ui/graphics/Shadow;", "setSpan", "span", "", "setSpanStyle", "spanStyleRange", "setSpanStyles", "setTextDecoration", "textDecoration", "Landroidx/compose/ui/text/style/TextDecoration;", "setTextIndent", "textIndent", "Landroidx/compose/ui/text/style/TextIndent;", "ui-text_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class SpannableExtensions_androidKt {
    private static final MetricAffectingSpan createLetterSpacingSpan-eAf_CNQ(long letterSpacing, Density density) {
        LetterSpacingSpanEm letterSpacingSpanEm;
        int value-impl;
        LetterSpacingSpanPx letterSpacingSpanPx;
        float px--R2X_6o;
        long type-UIouoOA = TextUnit.getType-UIouoOA(letterSpacing);
        if (TextUnitType.equals-impl0(type-UIouoOA, obj1)) {
            value-impl = 0;
            letterSpacingSpanPx = new LetterSpacingSpanPx(obj6.toPx--R2X_6o(letterSpacing));
        } else {
            if (TextUnitType.equals-impl0(type-UIouoOA, obj1)) {
                letterSpacingSpanEm = new LetterSpacingSpanEm(TextUnit.getValue-impl(letterSpacing));
                letterSpacingSpanPx = letterSpacingSpanEm;
            } else {
                letterSpacingSpanPx = 0;
            }
        }
        return letterSpacingSpanPx;
    }

    public static final void flattenFontStylesAndApply(SpanStyle contextFontSpanStyle, List<AnnotatedString.Range<SpanStyle>> spanStyles, Function3<? super SpanStyle, ? super Integer, ? super Integer, Unit> block) {
        int i;
        int intersect;
        boolean empty;
        int size;
        int end;
        SpanStyle spanStyle;
        int valueOf3;
        Integer valueOf6;
        int lastTransitionOffsets;
        int i4;
        Integer valueOf4;
        int index$iv2;
        int mergedSpanStyle;
        Object valueOf5;
        Object valueOf;
        int index$iv;
        int size2;
        int i2;
        Integer valueOf2;
        int i3;
        int spanCount;
        i = spanStyles;
        final Object obj = block;
        valueOf3 = 0;
        if (i.size() <= 1) {
            if (!(Collection)i.isEmpty()) {
                obj.invoke(SpannableExtensions_androidKt.merge(contextFontSpanStyle, (SpanStyle)(AnnotatedString.Range)i.get(valueOf3).getItem()), Integer.valueOf((AnnotatedString.Range)i.get(valueOf3).getStart()), Integer.valueOf((AnnotatedString.Range)i.get(valueOf3).getEnd()));
            } else {
                spanStyle = contextFontSpanStyle;
            }
        }
        SpanStyle spanStyle2 = contextFontSpanStyle;
        size = i.size();
        int i7 = size * 2;
        final Integer[] arr = new Integer[i7];
        i4 = valueOf3;
        while (i4 < i7) {
            arr[i4] = Integer.valueOf(valueOf3);
            i4++;
        }
        Integer num = spanStyles;
        int i9 = 0;
        index$iv2 = 0;
        while (index$iv2 < num.size()) {
            valueOf = valueOf5;
            index$iv = index$iv2;
            size2 = 0;
            arr[index$iv] = Integer.valueOf((AnnotatedString.Range)valueOf.getStart());
            arr[index$iv + size] = Integer.valueOf(valueOf.getEnd());
            index$iv2++;
        }
        ArraysKt.sort((Comparable[])arr);
        int i8 = 0;
        lastTransitionOffsets = (Number)ArraysKt.first(arr).intValue();
        while (valueOf3 < arr.length) {
            index$iv2 = arr[valueOf3].intValue();
            if (index$iv2 == lastTransitionOffsets) {
            } else {
            }
            int i10 = 0;
            mergedSpanStyle = contextFontSpanStyle;
            valueOf5 = spanStyles;
            valueOf = 0;
            index$iv = 0;
            while (index$iv < valueOf5.size()) {
                valueOf2 = i2;
                i3 = 0;
                if ((AnnotatedString.Range)valueOf2.getStart() != valueOf2.getEnd() && AnnotatedStringKt.intersect(lastTransitionOffsets, index$iv2, valueOf2.getStart(), valueOf2.getEnd())) {
                }
                index$iv++;
                i = spanStyles;
                size = spanCount;
                if (AnnotatedStringKt.intersect(lastTransitionOffsets, index$iv2, valueOf2.getStart(), valueOf2.getEnd())) {
                }
                mergedSpanStyle = intersect;
            }
            spanCount = size;
            if (mergedSpanStyle != null) {
            }
            lastTransitionOffsets = i;
            valueOf3++;
            i = spanStyles;
            size = spanCount;
            size = 0;
            obj.invoke(mergedSpanStyle, Integer.valueOf(lastTransitionOffsets), Integer.valueOf(index$iv2));
            valueOf2 = i2;
            i3 = 0;
            if ((AnnotatedString.Range)valueOf2.getStart() != valueOf2.getEnd() && AnnotatedStringKt.intersect(lastTransitionOffsets, index$iv2, valueOf2.getStart(), valueOf2.getEnd())) {
            }
            index$iv++;
            i = spanStyles;
            size = spanCount;
            if (AnnotatedStringKt.intersect(lastTransitionOffsets, index$iv2, valueOf2.getStart(), valueOf2.getEnd())) {
            }
            mergedSpanStyle = intersect;
            spanCount = size;
        }
    }

    private static final boolean getNeedsLetterSpacingSpan(SpanStyle $this$needsLetterSpacingSpan) {
        int i;
        boolean equals-impl0;
        long sp-UIouoOA;
        if (!TextUnitType.equals-impl0(TextUnit.getType-UIouoOA($this$needsLetterSpacingSpan.getLetterSpacing-XSAIIZE()), obj1)) {
            if (TextUnitType.equals-impl0(TextUnit.getType-UIouoOA($this$needsLetterSpacingSpan.getLetterSpacing-XSAIIZE()), obj1)) {
                i = 1;
            } else {
                i = 0;
            }
        } else {
        }
        return i;
    }

    private static final boolean hasFontAttributes(TextStyle $this$hasFontAttributes) {
        int i;
        boolean fontSynthesis-ZQGJjVo;
        if (!TextPaintExtensions_androidKt.hasFontAttributes($this$hasFontAttributes.toSpanStyle())) {
            if ($this$hasFontAttributes.getFontSynthesis-ZQGJjVo() != null) {
                i = 1;
            } else {
                i = 0;
            }
        } else {
        }
        return i;
    }

    private static final boolean isNonLinearFontScalingActive(Density density) {
        int i;
        i = Double.compare(d, l) > 0 ? 1 : 0;
        return i;
    }

    private static final SpanStyle merge(SpanStyle $this$merge, SpanStyle spanStyle) {
        if ($this$merge == null) {
            return spanStyle;
        }
        return $this$merge.merge(spanStyle);
    }

    private static final float resolveLineHeightInPx-o2QH7mI(long lineHeight, float contextFontSize, Density density) {
        int fontSizeSp;
        int i;
        int em-UIouoOA;
        float value-impl;
        long type-UIouoOA = TextUnit.getType-UIouoOA(lineHeight);
        if (TextUnitType.equals-impl0(type-UIouoOA, obj1)) {
            if (!SpannableExtensions_androidKt.isNonLinearFontScalingActive(obj7)) {
                i = 0;
                fontSizeSp = obj7.toPx--R2X_6o(lineHeight);
            } else {
                fontSizeSp = em-UIouoOA * density;
            }
        } else {
            if (TextUnitType.equals-impl0(type-UIouoOA, obj1)) {
                value-impl2 *= density;
            } else {
                fontSizeSp = 2143289344;
            }
        }
        return fontSizeSp;
    }

    public static final void setBackground-RPmYEkk(Spannable $this$setBackground_u2dRPmYEkk, long color, int start, int end) {
        int backgroundColorSpan;
        int argb-8_81llA;
        int i;
        final int i2 = 0;
        i = Long.compare(backgroundColorSpan, i3) != 0 ? 1 : 0;
        if (i != 0) {
            backgroundColorSpan = new BackgroundColorSpan(ColorKt.toArgb-8_81llA(color));
            SpannableExtensions_androidKt.setSpan($this$setBackground_u2dRPmYEkk, backgroundColorSpan, end, obj9);
        }
    }

    private static final void setBaselineShift-0ocSgnM(Spannable $this$setBaselineShift_u2d0ocSgnM, BaselineShift baselineShift, int start, int end) {
        float unbox-impl;
        int i;
        BaselineShiftSpan baselineShiftSpan;
        if (baselineShift != null) {
            i = 0;
            baselineShiftSpan = new BaselineShiftSpan(baselineShift.unbox-impl());
            SpannableExtensions_androidKt.setSpan($this$setBaselineShift_u2d0ocSgnM, baselineShiftSpan, start, end);
        }
    }

    private static final void setBrush(Spannable $this$setBrush, Brush brush, float alpha, int start, int end) {
        Object obj2;
        int i;
        boolean shaderBrushSpan;
        long obj;
        if (brush != null) {
            obj2 = brush;
            i = 0;
            if (brush instanceof SolidColor) {
                SpannableExtensions_androidKt.setColor-RPmYEkk($this$setBrush, (SolidColor)brush.getValue-0d7_KjU(), obj3, start);
            } else {
                if (brush instanceof ShaderBrush) {
                    shaderBrushSpan = new ShaderBrushSpan((ShaderBrush)brush, alpha);
                    SpannableExtensions_androidKt.setSpan($this$setBrush, shaderBrushSpan, start, end);
                }
            }
        }
    }

    public static final void setColor-RPmYEkk(Spannable $this$setColor_u2dRPmYEkk, long color, int start, int end) {
        int foregroundColorSpan;
        int argb-8_81llA;
        int i;
        final int i2 = 0;
        i = Long.compare(foregroundColorSpan, i3) != 0 ? 1 : 0;
        if (i != 0) {
            foregroundColorSpan = new ForegroundColorSpan(ColorKt.toArgb-8_81llA(color));
            SpannableExtensions_androidKt.setSpan($this$setColor_u2dRPmYEkk, foregroundColorSpan, end, obj9);
        }
    }

    private static final void setDrawStyle(Spannable $this$setDrawStyle, DrawStyle drawStyle, int start, int end) {
        DrawStyle drawStyle2;
        int i;
        DrawStyleSpan drawStyleSpan;
        if (drawStyle != null) {
            i = 0;
            drawStyleSpan = new DrawStyleSpan(drawStyle);
            SpannableExtensions_androidKt.setSpan($this$setDrawStyle, drawStyleSpan, start, end);
        }
    }

    private static final void setFontAttributes(Spannable $this$setFontAttributes, TextStyle contextTextStyle, List<AnnotatedString.Range<SpanStyle>> spanStyles, Function4<? super FontFamily, ? super FontWeight, ? super FontStyle, ? super FontSynthesis, ? extends Typeface> resolveTypeface) {
        SpanStyle spanStyle;
        int i8;
        int index$iv$iv;
        Object fontWeight;
        Object fontStyle-4Lr2A7w;
        FontSynthesis fontSynthesis-ZQGJjVo;
        Object fontFamily;
        int i;
        int i3;
        boolean fontSynthesis-ZQGJjVo2;
        int i4;
        int i5;
        int i6;
        int i7;
        int i11;
        int i13;
        int i12;
        int i9;
        int i2;
        int i10;
        int i14 = spanStyles;
        int i15 = 0;
        ArrayList arrayList = new ArrayList(i14.size());
        i8 = i14;
        index$iv$iv = 0;
        final int size2 = i8.size();
        while (index$iv$iv < size2) {
            fontStyle-4Lr2A7w = fontWeight;
            fontSynthesis-ZQGJjVo = 0;
            fontFamily = fontStyle-4Lr2A7w;
            i = 0;
            if (!TextPaintExtensions_androidKt.hasFontAttributes((SpanStyle)(AnnotatedString.Range)fontFamily.getItem())) {
            } else {
            }
            i3 = 1;
            if (i3 != 0) {
            }
            index$iv$iv++;
            (Collection)arrayList.add(fontStyle-4Lr2A7w);
            if ((SpanStyle)fontFamily.getItem().getFontSynthesis-ZQGJjVo() != null) {
            } else {
            }
            i3 = 0;
        }
        if (SpannableExtensions_androidKt.hasFontAttributes(contextTextStyle)) {
            spanStyle = new SpanStyle(0, 0, 0, size2, contextTextStyle.getFontWeight(), contextTextStyle.getFontStyle-4Lr2A7w(), contextTextStyle.getFontSynthesis-ZQGJjVo(), contextTextStyle.getFontFamily(), 0, 0, obj13, 0, 0, 0, 0, obj18, 0, 0, 0, 0, 65475, 0);
        } else {
            spanStyle = 0;
        }
        SpannableExtensions_androidKt.setFontAttributes.1 anon = new SpannableExtensions_androidKt.setFontAttributes.1($this$setFontAttributes, resolveTypeface);
        SpannableExtensions_androidKt.flattenFontStylesAndApply(spanStyle, (List)arrayList, (Function3)anon);
    }

    private static final void setFontFeatureSettings(Spannable $this$setFontFeatureSettings, String fontFeatureSettings, int start, int end) {
        String str;
        int i;
        FontFeatureSpan fontFeatureSpan;
        if (fontFeatureSettings != null) {
            i = 0;
            fontFeatureSpan = new FontFeatureSpan(fontFeatureSettings);
            SpannableExtensions_androidKt.setSpan($this$setFontFeatureSettings, fontFeatureSpan, start, end);
        }
    }

    public static final void setFontSize-KmRG4DE(Spannable $this$setFontSize_u2dKmRG4DE, long fontSize, Density density, int start, int end) {
        boolean relativeSizeSpan;
        int value-impl;
        AbsoluteSizeSpan absoluteSizeSpan;
        int roundToInt;
        int i;
        long type-UIouoOA = TextUnit.getType-UIouoOA(fontSize);
        if (TextUnitType.equals-impl0(type-UIouoOA, obj1)) {
            value-impl = 0;
            absoluteSizeSpan = new AbsoluteSizeSpan(MathKt.roundToInt(start.toPx--R2X_6o(fontSize)), 0);
            SpannableExtensions_androidKt.setSpan($this$setFontSize_u2dKmRG4DE, absoluteSizeSpan, end, obj10);
        } else {
            if (TextUnitType.equals-impl0(type-UIouoOA, obj1)) {
                relativeSizeSpan = new RelativeSizeSpan(TextUnit.getValue-impl(fontSize));
                SpannableExtensions_androidKt.setSpan($this$setFontSize_u2dKmRG4DE, relativeSizeSpan, end, obj10);
            }
        }
    }

    private static final void setGeometricTransform(Spannable $this$setGeometricTransform, TextGeometricTransform textGeometricTransform, int start, int end) {
        Object obj;
        int i;
        SkewXSpan skewXSpan;
        float skewX;
        if (textGeometricTransform != null) {
            obj = textGeometricTransform;
            i = 0;
            ScaleXSpan scaleXSpan = new ScaleXSpan(obj.getScaleX());
            SpannableExtensions_androidKt.setSpan($this$setGeometricTransform, scaleXSpan, start, end);
            skewXSpan = new SkewXSpan(obj.getSkewX());
            SpannableExtensions_androidKt.setSpan($this$setGeometricTransform, skewXSpan, start, end);
        }
    }

    public static final void setLineHeight-KmRG4DE(Spannable $this$setLineHeight_u2dKmRG4DE, long lineHeight, float contextFontSize, Density density, LineHeightStyle lineHeightStyle) {
        boolean lineHeightStyleSpan;
        int last;
        int length;
        int length2;
        int i;
        boolean trimFirstLineTop-impl$ui_text_release;
        boolean trimLastLineBottom-impl$ui_text_release;
        float alignment-PIaL0Z0;
        int i2;
        final float resolveLineHeightInPx-o2QH7mI = SpannableExtensions_androidKt.resolveLineHeightInPx-o2QH7mI(lineHeight, contextFontSize, density);
        if (!Float.isNaN(resolveLineHeightInPx-o2QH7mI)) {
            int i3 = 1;
            i2 = 0;
            last = (CharSequence)$this$setLineHeight_u2dKmRG4DE.length() == 0 ? i3 : i2;
            if (last == 0) {
                if (StringsKt.last((CharSequence)$this$setLineHeight_u2dKmRG4DE) == 10) {
                    length4 += i3;
                } else {
                    length = $this$setLineHeight_u2dKmRG4DE.length();
                }
            } else {
            }
            lineHeightStyleSpan = new LineHeightStyleSpan(resolveLineHeightInPx-o2QH7mI, 0, length, LineHeightStyle.Trim.isTrimFirstLineTop-impl$ui_text_release(obj13.getTrim-EVpEnUU()), LineHeightStyle.Trim.isTrimLastLineBottom-impl$ui_text_release(obj13.getTrim-EVpEnUU()), obj13.getAlignment-PIaL0Z0());
            SpannableExtensions_androidKt.setSpan($this$setLineHeight_u2dKmRG4DE, lineHeightStyleSpan, i2, $this$setLineHeight_u2dKmRG4DE.length());
        }
    }

    public static final void setLineHeight-r9BaKPg(Spannable $this$setLineHeight_u2dr9BaKPg, long lineHeight, float contextFontSize, Density density) {
        boolean lineHeightSpan;
        int length;
        int i;
        final float resolveLineHeightInPx-o2QH7mI = SpannableExtensions_androidKt.resolveLineHeightInPx-o2QH7mI(lineHeight, contextFontSize, density);
        if (!Float.isNaN(resolveLineHeightInPx-o2QH7mI)) {
            lineHeightSpan = new LineHeightSpan(resolveLineHeightInPx-o2QH7mI);
            SpannableExtensions_androidKt.setSpan($this$setLineHeight_u2dr9BaKPg, lineHeightSpan, 0, $this$setLineHeight_u2dr9BaKPg.length());
        }
    }

    public static final void setLocaleList(Spannable $this$setLocaleList, LocaleList localeList, int start, int end) {
        LocaleList list;
        int i;
        Object localeSpan;
        if (localeList != null) {
            i = 0;
            SpannableExtensions_androidKt.setSpan($this$setLocaleList, LocaleListHelperMethods.INSTANCE.localeSpan(localeList), start, end);
        }
    }

    private static final void setShadow(Spannable $this$setShadow, Shadow shadow, int start, int end) {
        Object obj;
        int i;
        ShadowSpan shadowSpan;
        int argb-8_81llA;
        long x-impl;
        long y-impl;
        long correctBlurRadius;
        if (shadow != null) {
            obj = shadow;
            i = 0;
            shadowSpan = new ShadowSpan(ColorKt.toArgb-8_81llA(obj.getColor-0d7_KjU()), Offset.getX-impl(obj.getOffset-F1C5BW0()), Offset.getY-impl(obj.getOffset-F1C5BW0()), TextPaintExtensions_androidKt.correctBlurRadius(obj.getBlurRadius()));
            SpannableExtensions_androidKt.setSpan($this$setShadow, shadowSpan, start, end);
        }
    }

    public static final void setSpan(Spannable $this$setSpan, Object span, int start, int end) {
        $this$setSpan.setSpan(span, start, end, 33);
    }

    private static final void setSpanStyle(Spannable $this$setSpanStyle, AnnotatedString.Range<SpanStyle> spanStyleRange, Density density) {
        final int start = spanStyleRange.getStart();
        final int end = spanStyleRange.getEnd();
        final Object obj = item;
        SpannableExtensions_androidKt.setBaselineShift-0ocSgnM($this$setSpanStyle, (SpanStyle)obj.getBaselineShift-5SSeXJ0(), start, end);
        SpannableExtensions_androidKt.setColor-RPmYEkk($this$setSpanStyle, obj.getColor-0d7_KjU(), obj1, start);
        SpannableExtensions_androidKt.setBrush($this$setSpanStyle, obj.getBrush(), obj.getAlpha(), start, end);
        SpannableExtensions_androidKt.setTextDecoration($this$setSpanStyle, obj.getTextDecoration(), start, end);
        Spannable spannable = $this$setSpanStyle;
        SpannableExtensions_androidKt.setFontSize-KmRG4DE(spannable, obj.getFontSize-XSAIIZE(), obj2, density, start);
        SpannableExtensions_androidKt.setFontFeatureSettings(spannable, obj.getFontFeatureSettings(), start, end);
        SpannableExtensions_androidKt.setGeometricTransform(spannable, obj.getTextGeometricTransform(), start, end);
        SpannableExtensions_androidKt.setLocaleList(spannable, obj.getLocaleList(), start, end);
        SpannableExtensions_androidKt.setBackground-RPmYEkk(spannable, obj.getBackground-0d7_KjU(), obj2, start);
        SpannableExtensions_androidKt.setShadow(spannable, obj.getShadow(), start, end);
        SpannableExtensions_androidKt.setDrawStyle(spannable, obj.getDrawStyle(), start, end);
    }

    public static final void setSpanStyles(Spannable $this$setSpanStyles, TextStyle contextTextStyle, List<AnnotatedString.Range<SpanStyle>> spanStyles, Density density, Function4<? super FontFamily, ? super FontWeight, ? super FontStyle, ? super FontSynthesis, ? extends Typeface> resolveTypeface) {
        int hasLetterSpacing;
        int i;
        int size;
        Object obj;
        int start;
        int end;
        int needsLetterSpacingSpan;
        int letterSpacingSpan-eAf_CNQ;
        long l;
        SpannableExtensions_androidKt.setFontAttributes($this$setSpanStyles, contextTextStyle, spanStyles, resolveTypeface);
        hasLetterSpacing = 0;
        i = 0;
        while (i < spanStyles.size()) {
            obj = spanStyles.get(i);
            start = (AnnotatedString.Range)obj.getStart();
            end = obj.getEnd();
            if (start >= 0 && start < $this$setSpanStyles.length() && end > start) {
            }
            i++;
            if (start < $this$setSpanStyles.length()) {
            }
            if (end > start) {
            }
            if (end > $this$setSpanStyles.length()) {
            } else {
            }
            SpannableExtensions_androidKt.setSpanStyle($this$setSpanStyles, obj, density);
            if (SpannableExtensions_androidKt.getNeedsLetterSpacingSpan((SpanStyle)obj.getItem())) {
            }
            hasLetterSpacing = 1;
        }
        if (hasLetterSpacing != 0) {
            i = 0;
            while (i < spanStyles.size()) {
                obj = spanStyles.get(i);
                start = (AnnotatedString.Range)obj.getStart();
                end = obj.getEnd();
                if (start >= 0 && start < $this$setSpanStyles.length() && end > start) {
                }
                i++;
                if (start < $this$setSpanStyles.length()) {
                }
                if (end > start) {
                }
                if (end > $this$setSpanStyles.length()) {
                } else {
                }
                letterSpacingSpan-eAf_CNQ = SpannableExtensions_androidKt.createLetterSpacingSpan-eAf_CNQ((SpanStyle)obj.getItem().getLetterSpacing-XSAIIZE(), l);
                if (letterSpacingSpan-eAf_CNQ != null) {
                }
                l = 0;
                SpannableExtensions_androidKt.setSpan($this$setSpanStyles, letterSpacingSpan-eAf_CNQ, start, end);
            }
        }
    }

    public static final void setTextDecoration(Spannable $this$setTextDecoration, TextDecoration textDecoration, int start, int end) {
        Object obj;
        int i;
        TextDecorationSpan textDecorationSpan;
        boolean contains;
        boolean contains2;
        if (textDecoration != null) {
            obj = textDecoration;
            i = 0;
            textDecorationSpan = new TextDecorationSpan(obj.contains(TextDecoration.Companion.getUnderline()), obj.contains(TextDecoration.Companion.getLineThrough()));
            SpannableExtensions_androidKt.setSpan($this$setTextDecoration, textDecorationSpan, start, end);
        }
    }

    public static final void setTextIndent(Spannable $this$setTextIndent, TextIndent textIndent, float contextFontSize, Density density) {
        Object obj;
        int i2;
        boolean unspecified--R2X_6o;
        long l;
        int i;
        long px--R2X_6o;
        long standard;
        long restLine-XSAIIZE;
        int length;
        boolean companion;
        float px--R2X_6o2;
        int em-UIouoOA;
        boolean em-UIouoOA2;
        if (textIndent != null) {
            obj = textIndent;
            i2 = 0;
            i = 0;
            if (TextUnit.equals-impl0(obj.getFirstLine-XSAIIZE(), obj3)) {
                if (!TextUnit.equals-impl0(obj.getRestLine-XSAIIZE(), obj3) && !TextUnitKt.isUnspecified--R2X_6o(obj.getFirstLine-XSAIIZE())) {
                    if (!TextUnitKt.isUnspecified--R2X_6o(obj.getFirstLine-XSAIIZE())) {
                        if (TextUnitKt.isUnspecified--R2X_6o(obj.getRestLine-XSAIIZE())) {
                        } else {
                            unspecified--R2X_6o = density;
                            l = 0;
                            long type-UIouoOA = TextUnit.getType-UIouoOA(obj.getFirstLine-XSAIIZE());
                            if (TextUnitType.equals-impl0(type-UIouoOA, obj6)) {
                                px--R2X_6o = unspecified--R2X_6o.toPx--R2X_6o(obj.getFirstLine-XSAIIZE());
                            } else {
                                if (TextUnitType.equals-impl0(type-UIouoOA, obj6)) {
                                    value-impl *= contextFontSize;
                                } else {
                                    px--R2X_6o = px--R2X_6o2;
                                }
                            }
                            long type-UIouoOA2 = TextUnit.getType-UIouoOA(obj.getRestLine-XSAIIZE());
                            if (TextUnitType.equals-impl0(type-UIouoOA2, companion)) {
                                px--R2X_6o2 = unspecified--R2X_6o.toPx--R2X_6o(obj.getRestLine-XSAIIZE());
                            } else {
                                if (TextUnitType.equals-impl0(type-UIouoOA2, companion)) {
                                    px--R2X_6o2 = restLine-XSAIIZE * contextFontSize;
                                } else {
                                }
                            }
                            standard = new LeadingMarginSpan.Standard((int)f, (int)f2);
                            SpannableExtensions_androidKt.setSpan($this$setTextIndent, standard, i, $this$setTextIndent.length());
                        }
                    }
                }
            } else {
            }
        }
    }
}
