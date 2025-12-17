package androidx.compose.ui.text.platform;

import android.text.SpannableString;
import android.text.style.ScaleXSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.TypefaceSpan;
import android.text.style.UnderlineSpan;
import androidx.compose.runtime.State;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.AnnotatedString.Range;
import androidx.compose.ui.text.LinkAnnotation;
import androidx.compose.ui.text.LinkAnnotation.Url;
import androidx.compose.ui.text.SpanStyle;
import androidx.compose.ui.text.font.AndroidFontUtils_androidKt;
import androidx.compose.ui.text.font.FontFamily.Resolver;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontStyle.Companion;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontSynthesis.Companion;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.font.FontWeight.Companion;
import androidx.compose.ui.text.font.GenericFontFamily;
import androidx.compose.ui.text.platform.extensions.SpannableExtensions_androidKt;
import androidx.compose.ui.text.platform.extensions.TtsAnnotationExtensions_androidKt;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextDecoration.Companion;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.unit.Density;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000@\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a4\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0008\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0002\u001a$\u0010\u000c\u001a\u00020\u0002*\u00020\r2\u0006\u0010\u0008\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000fH\u0007\u001a\u0018\u0010\u0010\u001a\u0008\u0012\u0004\u0012\u00020\u00120\u0011*\u0008\u0012\u0004\u0012\u00020\u00130\u0011H\u0002¨\u0006\u0014", d2 = {"setSpanStyle", "", "Landroid/text/SpannableString;", "spanStyle", "Landroidx/compose/ui/text/SpanStyle;", "start", "", "end", "density", "Landroidx/compose/ui/unit/Density;", "fontFamilyResolver", "Landroidx/compose/ui/text/font/FontFamily$Resolver;", "toAccessibilitySpannableString", "Landroidx/compose/ui/text/AnnotatedString;", "urlSpanCache", "Landroidx/compose/ui/text/platform/URLSpanCache;", "toUrlLink", "Landroidx/compose/ui/text/AnnotatedString$Range;", "Landroidx/compose/ui/text/LinkAnnotation$Url;", "Landroidx/compose/ui/text/LinkAnnotation;", "ui-text_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class AndroidAccessibilitySpannableString_androidKt {
    private static final void setSpanStyle(SpannableString $this$setSpanStyle, SpanStyle spanStyle, int start, int end, Density density, FontFamily.Resolver fontFamilyResolver) {
        Object fontStyle-4Lr2A7w;
        int all-GVVA2EU;
        Object typefaceSpan;
        TextDecoration strikethroughSpan;
        Object textGeometricTransform;
        boolean underlineSpan;
        int normal-_-LCdwA;
        Object styleSpan;
        int androidTypefaceStyle-FO1MlWM;
        androidx.compose.ui.text.font.FontFamily fontFamily;
        int i;
        int i5;
        int i4;
        int i2;
        int i3;
        final int i8 = end;
        SpannableExtensions_androidKt.setColor-RPmYEkk((Spannable)$this$setSpanStyle, spanStyle.getColor-0d7_KjU(), obj2, start);
        SpannableExtensions_androidKt.setFontSize-KmRG4DE((Spannable)$this$setSpanStyle, spanStyle.getFontSize-XSAIIZE(), obj2, density, start);
        int i6 = 33;
        if (spanStyle.getFontWeight() == null) {
            if (spanStyle.getFontStyle-4Lr2A7w() != null && spanStyle.getFontWeight() == null) {
                if (spanStyle.getFontWeight() == null) {
                    fontStyle-4Lr2A7w = FontWeight.Companion.getNormal();
                }
                FontStyle fontStyle-4Lr2A7w2 = spanStyle.getFontStyle-4Lr2A7w();
                if (fontStyle-4Lr2A7w2 != null) {
                    normal-_-LCdwA = fontStyle-4Lr2A7w2.unbox-impl();
                } else {
                    normal-_-LCdwA = FontStyle.Companion.getNormal-_-LCdwA();
                }
                styleSpan = new StyleSpan(AndroidFontUtils_androidKt.getAndroidTypefaceStyle-FO1MlWM(fontStyle-4Lr2A7w, normal-_-LCdwA));
                $this$setSpanStyle.setSpan(styleSpan, start, i8, i6);
            }
        } else {
        }
        if (spanStyle.getFontFamily() != null) {
            if (fontFamily2 instanceof GenericFontFamily) {
                typefaceSpan = new TypefaceSpan((GenericFontFamily)spanStyle.getFontFamily().getName());
                $this$setSpanStyle.setSpan(typefaceSpan, start, i8, i6);
            } else {
                FontSynthesis fontSynthesis-ZQGJjVo = spanStyle.getFontSynthesis-ZQGJjVo();
                if (fontSynthesis-ZQGJjVo != null) {
                    all-GVVA2EU = fontSynthesis-ZQGJjVo.unbox-impl();
                } else {
                    all-GVVA2EU = FontSynthesis.Companion.getAll-GVVA2EU();
                }
                typefaceSpan = FontFamily.Resolver.resolve-DPcqOEQ$default(fontFamilyResolver, spanStyle.getFontFamily(), 0, 0, all-GVVA2EU, 6, 0).getValue();
                Intrinsics.checkNotNull(typefaceSpan, "null cannot be cast to non-null type android.graphics.Typeface");
                $this$setSpanStyle.setSpan(Api28Impl.INSTANCE.createTypefaceSpan((Typeface)typefaceSpan), start, i8, i6);
            }
        }
        if (spanStyle.getTextDecoration() != null && spanStyle.getTextDecoration().contains(TextDecoration.Companion.getUnderline())) {
            if (spanStyle.getTextDecoration().contains(TextDecoration.Companion.getUnderline())) {
                underlineSpan = new UnderlineSpan();
                $this$setSpanStyle.setSpan(underlineSpan, start, i8, i6);
            }
            if (spanStyle.getTextDecoration().contains(TextDecoration.Companion.getLineThrough())) {
                strikethroughSpan = new StrikethroughSpan();
                $this$setSpanStyle.setSpan(strikethroughSpan, start, i8, i6);
            }
        }
        if (spanStyle.getTextGeometricTransform() != null) {
            textGeometricTransform = new ScaleXSpan(spanStyle.getTextGeometricTransform().getScaleX());
            $this$setSpanStyle.setSpan(textGeometricTransform, start, i8, i6);
        }
        SpannableExtensions_androidKt.setLocaleList((Spannable)$this$setSpanStyle, spanStyle.getLocaleList(), start, i8);
        SpannableExtensions_androidKt.setBackground-RPmYEkk((Spannable)$this$setSpanStyle, spanStyle.getBackground-0d7_KjU(), normal-_-LCdwA, start);
    }

    public static final SpannableString toAccessibilitySpannableString(AnnotatedString $this$toAccessibilitySpannableString, Density density, FontFamily.Resolver fontFamilyResolver, androidx.compose.ui.text.platform.URLSpanCache urlSpanCache) {
        String text;
        int copy-GSF8kmg$default;
        int index$iv3;
        int component2;
        int index$iv2;
        int index$iv4;
        int component3;
        int size2;
        Density density2;
        FontFamily.Resolver resolver;
        int size;
        int index$iv;
        Object clickableSpan;
        boolean linkInteractionListener;
        int start;
        Object uRLSpan;
        int i5;
        int i12;
        int i9;
        int i14;
        int i;
        int i7;
        int i15;
        int i18;
        int i17;
        int i2;
        int i3;
        int i6;
        int i8;
        int i4;
        int i16;
        int i10;
        int i13;
        int i11;
        final Object obj = $this$toAccessibilitySpannableString;
        final Object obj2 = urlSpanCache;
        SpannableString spannableString = new SpannableString((CharSequence)obj.getText());
        final SpannableString str = spannableString;
        List spanStylesOrNull$ui_text_release = obj.getSpanStylesOrNull$ui_text_release();
        if (spanStylesOrNull$ui_text_release != null) {
            text = 0;
            index$iv = copy-GSF8kmg$default;
            while (index$iv < spanStylesOrNull$ui_text_release.size()) {
                Object obj3 = clickableSpan;
                start = 0;
                AndroidAccessibilitySpannableString_androidKt.setSpanStyle(str, SpanStyle.copy-GSF8kmg$default((SpanStyle)(AnnotatedString.Range)obj3.component1(), 0, obj16, 0, obj18, 0, 0, 0, 0, 0, 0, obj25, 0, 0, 0, 0, obj30, 0, 0), obj3.component2(), obj3.component3(), density, fontFamilyResolver);
                index$iv++;
            }
        }
        int i19 = 0;
        List ttsAnnotations = obj.getTtsAnnotations(i19, obj.length());
        int i21 = 0;
        index$iv2 = 0;
        density2 = 33;
        while (index$iv2 < ttsAnnotations.size()) {
            Object obj4 = resolver;
            index$iv = 0;
            str.setSpan(TtsAnnotationExtensions_androidKt.toSpan((TtsAnnotation)(AnnotatedString.Range)obj4.component1()), obj4.component2(), obj4.component3(), density2);
            index$iv2++;
            density2 = 33;
        }
        List urlAnnotations = obj.getUrlAnnotations(i19, obj.length());
        int i22 = 0;
        index$iv4 = 0;
        while (index$iv4 < urlAnnotations.size()) {
            Object obj5 = resolver;
            index$iv = 0;
            str.setSpan(obj2.toURLSpan((UrlAnnotation)(AnnotatedString.Range)obj5.component1()), obj5.component2(), obj5.component3(), density2);
            index$iv4++;
        }
        List linkAnnotations = obj.getLinkAnnotations(i19, obj.length());
        int i20 = 0;
        index$iv3 = 0;
        while (index$iv3 < linkAnnotations.size()) {
            resolver = size2;
            size = 0;
            index$iv = (AnnotatedString.Range)resolver.getItem();
            if (index$iv instanceof LinkAnnotation.Url && (LinkAnnotation)index$iv.getLinkInteractionListener() == null) {
            } else {
            }
            str.setSpan(obj2.toClickableSpan(resolver), resolver.getStart(), resolver.getEnd(), density2);
            index$iv3++;
            if (index$iv.getLinkInteractionListener() == null) {
            } else {
            }
            str.setSpan(obj2.toURLSpan(AndroidAccessibilitySpannableString_androidKt.toUrlLink(resolver)), resolver.getStart(), resolver.getEnd(), density2);
        }
        return str;
    }

    private static final AnnotatedString.Range<LinkAnnotation.Url> toUrlLink(AnnotatedString.Range<LinkAnnotation> $this$toUrlLink) {
        final Object item = $this$toUrlLink.getItem();
        Intrinsics.checkNotNull(item, "null cannot be cast to non-null type androidx.compose.ui.text.LinkAnnotation.Url");
        AnnotatedString.Range range = new AnnotatedString.Range((LinkAnnotation.Url)item, $this$toUrlLink.getStart(), $this$toUrlLink.getEnd());
        return range;
    }
}
