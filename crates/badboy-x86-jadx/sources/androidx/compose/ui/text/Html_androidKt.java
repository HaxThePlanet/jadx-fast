package androidx.compose.ui.text;

import _COROUTINE.CoroutineDebuggingKt;
import android.graphics.Typeface;
import android.text.Layout.Alignment;
import android.text.Spanned;
import android.text.style.AlignmentSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StyleSpan;
import android.text.style.TypefaceSpan;
import android.text.style.URLSpan;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.text.font.AndroidTypeface_androidKt;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontFamily.Companion;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontStyle.Companion;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.font.FontWeight.Companion;
import androidx.compose.ui.text.font.GenericFontFamily;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.BaselineShift.Companion;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextAlign.Companion;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextDecoration.Companion;
import androidx.compose.ui.unit.TextUnitKt;
import androidx.core.text.HtmlCompat;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000i\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0004\u001a\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0008\u0010\u0008\u001a\u0004\u0018\u00010\u0001H\u0002\u001a8\u0010\t\u001a\u00020\n*\u00020\u000b2\u0006\u0010\u000c\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0008\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0008\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0002\u001a(\u0010\u0015\u001a\u00020\n*\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u00172\u0008\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0008\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0002\u001a*\u0010\u0018\u001a\u00020\u0019*\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u00012\n\u0008\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\n\u0008\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014\u001a$\u0010\u001c\u001a\u00020\u0019*\u00020\u00172\n\u0008\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\n\u0008\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0001\u001a\u000c\u0010\u001d\u001a\u00020\u001e*\u00020\u001fH\u0002\u001a\u000e\u0010 \u001a\u0004\u0018\u00010!*\u00020\"H\u0002\u001a\u000c\u0010 \u001a\u00020!*\u00020#H\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u0010\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0005¨\u0006$", d2 = {"AnnotationTag", "", "ContentHandlerReplacementTag", "TagHandler", "androidx/compose/ui/text/Html_androidKt$TagHandler$1", "Landroidx/compose/ui/text/Html_androidKt$TagHandler$1;", "optionalFontFamilyFromName", "Landroidx/compose/ui/text/font/FontFamily;", "familyName", "addSpan", "", "Landroidx/compose/ui/text/AnnotatedString$Builder;", "span", "", "start", "", "end", "linkStyles", "Landroidx/compose/ui/text/TextLinkStyles;", "linkInteractionListener", "Landroidx/compose/ui/text/LinkInteractionListener;", "addSpans", "spanned", "Landroid/text/Spanned;", "fromHtml", "Landroidx/compose/ui/text/AnnotatedString;", "Landroidx/compose/ui/text/AnnotatedString$Companion;", "htmlString", "toAnnotatedString", "toParagraphStyle", "Landroidx/compose/ui/text/ParagraphStyle;", "Landroid/text/style/AlignmentSpan;", "toSpanStyle", "Landroidx/compose/ui/text/SpanStyle;", "Landroid/text/style/StyleSpan;", "Landroid/text/style/TypefaceSpan;", "ui-text_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class Html_androidKt {

    private static final String AnnotationTag = "annotation";
    private static final String ContentHandlerReplacementTag = "ContentHandlerReplacementTag";
    private static final androidx.compose.ui.text.Html_androidKt.TagHandler.1 TagHandler;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public class WhenMappings {

        public static final int[] $EnumSwitchMapping$0;
        static {
            int ordinal;
            int ordinal3;
            int ordinal2;
            int[] iArr = new int[values.length];
            iArr[Layout.Alignment.ALIGN_NORMAL.ordinal()] = 1;
            iArr[Layout.Alignment.ALIGN_CENTER.ordinal()] = 2;
            iArr[Layout.Alignment.ALIGN_OPPOSITE.ordinal()] = 3;
            Html_androidKt.WhenMappings.$EnumSwitchMapping$0 = iArr;
        }
    }
    static {
        Html_androidKt.TagHandler.1 anon = new Html_androidKt.TagHandler.1();
        Html_androidKt.TagHandler = anon;
    }

    private static final void addSpan(androidx.compose.ui.text.AnnotatedString.Builder $this$addSpan, Object span, int start, int end, androidx.compose.ui.text.TextLinkStyles linkStyles, androidx.compose.ui.text.LinkInteractionListener linkInteractionListener) {
        boolean superscript-y9eOQZs;
        int spanStyle;
        androidx.compose.ui.text.LinkAnnotation.Url url;
        androidx.compose.ui.text.TextLinkStyles textLinkStyles;
        androidx.compose.ui.text.LinkInteractionListener list;
        int i3;
        int i;
        int i12;
        int i5;
        int i9;
        int i2;
        int box-impl;
        int i13;
        int i6;
        long l;
        int lineThrough;
        int i8;
        int i7;
        int i10;
        int i11;
        int i4;
        final Object obj = $this$addSpan;
        final Object obj2 = span;
        final int i14 = start;
        final int i15 = end;
        if (!obj2 instanceof AbsoluteSizeSpan) {
            if (obj2 instanceof AlignmentSpan) {
                obj.addStyle(Html_androidKt.toParagraphStyle((AlignmentSpan)obj2), i14, i15);
                textLinkStyles = linkStyles;
                list = linkInteractionListener;
            } else {
                if (obj2 instanceof AnnotationSpan) {
                    obj.addStringAnnotation((AnnotationSpan)obj2.getKey(), (AnnotationSpan)obj2.getValue(), i14, i15);
                    textLinkStyles = linkStyles;
                    list = linkInteractionListener;
                } else {
                    if (obj2 instanceof BackgroundColorSpan) {
                        spanStyle = new SpanStyle(0, obj7, 0, obj9, 0, 0, 0, 0, 0, 0, obj16, 0, 0, 0, ColorKt.Color((BackgroundColorSpan)obj2.getBackgroundColor()), obj21, 0, 0, 0, 0, 63487, 0);
                        obj.addStyle(spanStyle, i14, i15);
                        textLinkStyles = linkStyles;
                        list = linkInteractionListener;
                    } else {
                        if (obj2 instanceof ForegroundColorSpan) {
                            spanStyle = new SpanStyle(ColorKt.Color((ForegroundColorSpan)obj2.getForegroundColor()), obj7, 0, obj9, 0, 0, 0, 0, 0, 0, obj16, 0, 0, 0, 0, obj21, 0, 0, 0, 0, 65534, 0);
                            obj.addStyle(spanStyle, i14, i15);
                            textLinkStyles = linkStyles;
                            list = linkInteractionListener;
                        } else {
                            if (obj2 instanceof RelativeSizeSpan) {
                                spanStyle = new SpanStyle(0, obj7, TextUnitKt.getEm((RelativeSizeSpan)obj2.getSizeChange()), obj9, 0, 0, 0, 0, 0, 0, obj16, 0, 0, 0, 0, obj21, 0, 0, 0, 0, 65533, 0);
                                obj.addStyle(spanStyle, i14, i15);
                                textLinkStyles = linkStyles;
                                list = linkInteractionListener;
                            } else {
                                if (obj2 instanceof StrikethroughSpan) {
                                    spanStyle = new SpanStyle(0, obj7, 0, obj9, 0, 0, 0, 0, 0, 0, obj16, 0, 0, 0, 0, obj21, TextDecoration.Companion.getLineThrough(), 0, 0, 0, 61439, 0);
                                    obj.addStyle(spanStyle, i14, i15);
                                    textLinkStyles = linkStyles;
                                    list = linkInteractionListener;
                                } else {
                                    if (obj2 instanceof StyleSpan) {
                                        superscript-y9eOQZs = Html_androidKt.toSpanStyle((StyleSpan)obj2);
                                        if (superscript-y9eOQZs != null) {
                                            spanStyle = 0;
                                            obj.addStyle(superscript-y9eOQZs, i14, i15);
                                            textLinkStyles = linkStyles;
                                            list = linkInteractionListener;
                                        } else {
                                            textLinkStyles = linkStyles;
                                            list = linkInteractionListener;
                                        }
                                    } else {
                                        if (obj2 instanceof SubscriptSpan) {
                                            spanStyle = new SpanStyle(0, obj7, 0, obj9, 0, 0, 0, 0, 0, 0, obj16, BaselineShift.box-impl(BaselineShift.Companion.getSubscript-y9eOQZs()), 0, 0, 0, obj21, 0, 0, 0, 0, 65279, 0);
                                            obj.addStyle(spanStyle, i14, i15);
                                            textLinkStyles = linkStyles;
                                            list = linkInteractionListener;
                                        } else {
                                            if (obj2 instanceof SuperscriptSpan) {
                                                spanStyle = new SpanStyle(0, obj7, 0, obj9, 0, 0, 0, 0, 0, 0, obj16, BaselineShift.box-impl(BaselineShift.Companion.getSuperscript-y9eOQZs()), 0, 0, 0, obj21, 0, 0, 0, 0, 65279, 0);
                                                obj.addStyle(spanStyle, i14, i15);
                                                textLinkStyles = linkStyles;
                                                list = linkInteractionListener;
                                            } else {
                                                if (obj2 instanceof TypefaceSpan) {
                                                    obj.addStyle(Html_androidKt.toSpanStyle((TypefaceSpan)obj2), i14, i15);
                                                    textLinkStyles = linkStyles;
                                                    list = linkInteractionListener;
                                                } else {
                                                    if (obj2 instanceof UnderlineSpan) {
                                                        spanStyle = new SpanStyle(0, obj7, 0, obj9, 0, 0, 0, 0, 0, 0, obj16, 0, 0, 0, 0, obj21, TextDecoration.Companion.getUnderline(), 0, 0, 0, 61439, 0);
                                                        obj.addStyle(spanStyle, i14, i15);
                                                        textLinkStyles = linkStyles;
                                                        list = linkInteractionListener;
                                                    } else {
                                                        if (obj2 instanceof URLSpan) {
                                                            superscript-y9eOQZs = (URLSpan)obj2.getURL();
                                                            if (superscript-y9eOQZs != null) {
                                                                spanStyle = 0;
                                                                url = new LinkAnnotation.Url(superscript-y9eOQZs, linkStyles, linkInteractionListener);
                                                                obj.addLink(url, i14, i15);
                                                            } else {
                                                                textLinkStyles = linkStyles;
                                                                list = linkInteractionListener;
                                                            }
                                                        } else {
                                                            textLinkStyles = linkStyles;
                                                            list = linkInteractionListener;
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        } else {
            textLinkStyles = linkStyles;
            list = linkInteractionListener;
        }
    }

    private static final void addSpans(androidx.compose.ui.text.AnnotatedString.Builder $this$addSpans, Spanned spanned, androidx.compose.ui.text.TextLinkStyles linkStyles, androidx.compose.ui.text.LinkInteractionListener linkInteractionListener) {
        int i2;
        Object obj2;
        androidx.compose.ui.text.AnnotatedString.Builder str;
        Object obj;
        int start-impl;
        int end-impl;
        androidx.compose.ui.text.TextLinkStyles textLinkStyles;
        androidx.compose.ui.text.LinkInteractionListener list;
        int i;
        long l;
        final Object obj3 = spanned;
        Object[] spans = obj3.getSpans(0, $this$addSpans.getLength(), Object.class);
        int i3 = 0;
        while (i2 < spans.length) {
            obj = obj2;
            i = 0;
            l = TextRangeKt.TextRange(obj3.getSpanStart(obj), obj3.getSpanEnd(obj));
            Html_androidKt.addSpan($this$addSpans, obj, TextRange.getStart-impl(l), TextRange.getEnd-impl(l), linkStyles, linkInteractionListener);
            i2++;
        }
    }

    public static final androidx.compose.ui.text.AnnotatedString fromHtml(androidx.compose.ui.text.AnnotatedString.Companion $this$fromHtml, String htmlString, androidx.compose.ui.text.TextLinkStyles linkStyles, androidx.compose.ui.text.LinkInteractionListener linkInteractionListener) {
        StringBuilder stringBuilder = new StringBuilder();
        return Html_androidKt.toAnnotatedString(HtmlCompat.fromHtml(stringBuilder.append("<ContentHandlerReplacementTag />").append(htmlString).toString(), 63, 0, (Html.TagHandler)Html_androidKt.TagHandler), linkStyles, linkInteractionListener);
    }

    public static androidx.compose.ui.text.AnnotatedString fromHtml$default(androidx.compose.ui.text.AnnotatedString.Companion annotatedString$Companion, String string2, androidx.compose.ui.text.TextLinkStyles textLinkStyles3, androidx.compose.ui.text.LinkInteractionListener linkInteractionListener4, int i5, Object object6) {
        int obj3;
        int obj4;
        final int i = 0;
        if (i5 & 2 != 0) {
            obj3 = i;
        }
        if (i5 &= 4 != 0) {
            obj4 = i;
        }
        return Html_androidKt.fromHtml(companion, string2, obj3, obj4);
    }

    private static final FontFamily optionalFontFamilyFromName(String familyName) {
        int length;
        int i3;
        int i4;
        Typeface typeface;
        int i2;
        int i;
        boolean equal;
        length = familyName;
        i2 = 0;
        if ((CharSequence)length != null) {
            if ((CharSequence)length.length() == 0) {
                i3 = i4;
            } else {
                i3 = i2;
            }
        } else {
        }
        i = 0;
        if (i3 != 0) {
            return i;
        }
        Typeface create = Typeface.create(familyName, i2);
        final Typeface typeface2 = create;
        final int i5 = 0;
        if (!Intrinsics.areEqual(create, Typeface.DEFAULT) && !Intrinsics.areEqual(create, Typeface.create(Typeface.DEFAULT, i2))) {
            if (!Intrinsics.areEqual(create, Typeface.create(Typeface.DEFAULT, i2))) {
            } else {
                i4 = i2;
            }
        } else {
        }
        typeface = i4 != 0 ? create : i;
        if (typeface != null) {
            i2 = 0;
            i = AndroidTypeface_androidKt.FontFamily(typeface);
        }
        return i;
    }

    public static final androidx.compose.ui.text.AnnotatedString toAnnotatedString(Spanned $this$toAnnotatedString, androidx.compose.ui.text.TextLinkStyles linkStyles, androidx.compose.ui.text.LinkInteractionListener linkInteractionListener) {
        AnnotatedString.Builder builder = new AnnotatedString.Builder($this$toAnnotatedString.length());
        androidx.compose.ui.text.AnnotatedString.Builder append = builder.append((CharSequence)$this$toAnnotatedString);
        final int i = 0;
        Html_androidKt.addSpans(append, $this$toAnnotatedString, linkStyles, linkInteractionListener);
        return append.toAnnotatedString();
    }

    public static androidx.compose.ui.text.AnnotatedString toAnnotatedString$default(Spanned spanned, androidx.compose.ui.text.TextLinkStyles textLinkStyles2, androidx.compose.ui.text.LinkInteractionListener linkInteractionListener3, int i4, Object object5) {
        int obj2;
        int obj3;
        final int i = 0;
        if (i4 & 1 != 0) {
            obj2 = i;
        }
        if (i4 &= 2 != 0) {
            obj3 = i;
        }
        return Html_androidKt.toAnnotatedString(spanned, obj2, obj3);
    }

    private static final androidx.compose.ui.text.ParagraphStyle toParagraphStyle(AlignmentSpan $this$toParagraphStyle) {
        int i;
        int unspecified-e0LSkKk;
        int[] $EnumSwitchMapping$0;
        Layout.Alignment alignment = $this$toParagraphStyle.getAlignment();
        if (alignment == null) {
            i = -1;
        } else {
            i = Html_androidKt.WhenMappings.$EnumSwitchMapping$0[alignment.ordinal()];
        }
        switch (i) {
            case 1:
                unspecified-e0LSkKk = TextAlign.Companion.getStart-e0LSkKk();
                break;
            case 2:
                unspecified-e0LSkKk = TextAlign.Companion.getCenter-e0LSkKk();
                break;
            case 3:
                unspecified-e0LSkKk = TextAlign.Companion.getEnd-e0LSkKk();
                break;
            default:
                unspecified-e0LSkKk = TextAlign.Companion.getUnspecified-e0LSkKk();
        }
        ParagraphStyle paragraphStyle = new ParagraphStyle(unspecified-e0LSkKk, 0, 0, obj5, 0, 0, 0, 0, 0, 0, 510, 0);
        return paragraphStyle;
    }

    private static final androidx.compose.ui.text.SpanStyle toSpanStyle(StyleSpan $this$toSpanStyle) {
        int italic-_-LCdwA;
        String str;
        androidx.compose.ui.text.SpanStyle spanStyle3;
        androidx.compose.ui.text.SpanStyle spanStyle;
        int spanStyle2;
        long l;
        int i3;
        FontStyle bold;
        int box-impl2;
        FontStyle box-impl;
        int i;
        int i11;
        int i4;
        int i2;
        androidx.compose.ui.text.intl.LocaleList list;
        int i9;
        int i5;
        int i6;
        int i7;
        androidx.compose.ui.graphics.drawscope.DrawStyle drawStyle;
        int i12;
        int i16;
        int i8;
        int i13;
        int i15;
        int i10;
        int i14;
        switch (italic-_-LCdwA) {
            case 1:
                spanStyle2 = new SpanStyle(0, obj5, 0, obj7, FontWeight.Companion.getBold(), 0, 0, 0, 0, 0, obj14, 0, 0, 0, 0, obj19, 0, 0, 0, 0, 65531, 0);
                spanStyle3 = spanStyle2;
                break;
            case 2:
                spanStyle = new SpanStyle(0, obj4, 0, obj6, 0, FontStyle.box-impl(FontStyle.Companion.getItalic-_-LCdwA()), 0, 0, 0, 0, obj13, 0, 0, 0, 0, obj18, 0, 0, 0, 0, 65527, 0);
                spanStyle3 = spanStyle;
                break;
            case 3:
                spanStyle3 = new SpanStyle(0, obj3, 0, obj5, FontWeight.Companion.getBold(), FontStyle.box-impl(FontStyle.Companion.getItalic-_-LCdwA()), 0, 0, 0, 0, obj12, 0, 0, 0, 0, obj17, 0, 0, 0, 0, 65523, 0);
                break;
            default:
                spanStyle3 = 0;
        }
        return spanStyle3;
    }

    private static final androidx.compose.ui.text.SpanStyle toSpanStyle(TypefaceSpan $this$toSpanStyle) {
        FontFamily optionalFontFamilyFromName;
        boolean equal;
        String family = $this$toSpanStyle.getFamily();
        if (Intrinsics.areEqual(family, FontFamily.Companion.getCursive().getName())) {
            optionalFontFamilyFromName = FontFamily.Companion.getCursive();
        } else {
            if (Intrinsics.areEqual(family, FontFamily.Companion.getMonospace().getName())) {
                optionalFontFamilyFromName = FontFamily.Companion.getMonospace();
            } else {
                if (Intrinsics.areEqual(family, FontFamily.Companion.getSansSerif().getName())) {
                    optionalFontFamilyFromName = FontFamily.Companion.getSansSerif();
                } else {
                    if (Intrinsics.areEqual(family, FontFamily.Companion.getSerif().getName())) {
                        optionalFontFamilyFromName = FontFamily.Companion.getSerif();
                    } else {
                        optionalFontFamilyFromName = Html_androidKt.optionalFontFamilyFromName($this$toSpanStyle.getFamily());
                    }
                }
            }
        }
        SpanStyle spanStyle = new SpanStyle(0, obj3, 0, obj5, 0, 0, 0, optionalFontFamilyFromName, 0, 0, obj12, 0, 0, 0, 0, obj17, 0, 0, 0, 0, 65503, 0);
        return spanStyle;
    }
}
