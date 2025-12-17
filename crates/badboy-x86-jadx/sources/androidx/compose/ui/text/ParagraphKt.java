package androidx.compose.ui.text;

import androidx.compose.ui.text.font.Font.ResourceLoader;
import androidx.compose.ui.text.font.FontFamily.Resolver;
import androidx.compose.ui.text.platform.AndroidParagraph_androidKt;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Density;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.collections.CollectionsKt;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000`\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u001a4\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0008\u0008\u0002\u0010\u0008\u001a\u00020\u00012\u0008\u0008\u0002\u0010\t\u001a\u00020\nø\u0001\u0000¢\u0006\u0004\u0008\u000b\u0010\u000c\u001a,\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u0008\u001a\u00020\u00012\u0008\u0008\u0002\u0010\t\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u000eH\u0007\u001ax\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0014\u0008\u0002\u0010\u0017\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u001a0\u00190\u00182\u0014\u0008\u0002\u0010\u001b\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u001c0\u00190\u00182\u0008\u0008\u0002\u0010\u0008\u001a\u00020\u00012\u0008\u0008\u0002\u0010\t\u001a\u00020\nø\u0001\u0000¢\u0006\u0004\u0008\u001d\u0010\u001e\u001ap\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0014\u0008\u0002\u0010\u0017\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u001a0\u00190\u00182\u0014\u0008\u0002\u0010\u001b\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u001c0\u00190\u00182\u0008\u0008\u0002\u0010\u0008\u001a\u00020\u00012\u0008\u0008\u0002\u0010\t\u001a\u00020\nH\u0007\u001ap\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0014\u0008\u0002\u0010\u0017\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u001a0\u00190\u00182\u0014\u0008\u0002\u0010\u001b\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u001c0\u00190\u00182\u0008\u0008\u0002\u0010\u0008\u001a\u00020\u00012\u0008\u0008\u0002\u0010\t\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u001f\u001a\u00020 H\u0007\u001a\u000c\u0010!\u001a\u00020\u0001*\u00020\u000eH\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006\"", d2 = {"DefaultMaxLines", "", "Paragraph", "Landroidx/compose/ui/text/Paragraph;", "paragraphIntrinsics", "Landroidx/compose/ui/text/ParagraphIntrinsics;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "maxLines", "ellipsis", "", "Paragraph-_EkL_-Y", "(Landroidx/compose/ui/text/ParagraphIntrinsics;JIZ)Landroidx/compose/ui/text/Paragraph;", "width", "", "text", "", "style", "Landroidx/compose/ui/text/TextStyle;", "density", "Landroidx/compose/ui/unit/Density;", "fontFamilyResolver", "Landroidx/compose/ui/text/font/FontFamily$Resolver;", "spanStyles", "", "Landroidx/compose/ui/text/AnnotatedString$Range;", "Landroidx/compose/ui/text/SpanStyle;", "placeholders", "Landroidx/compose/ui/text/Placeholder;", "Paragraph-UdtVg6A", "(Ljava/lang/String;Landroidx/compose/ui/text/TextStyle;JLandroidx/compose/ui/unit/Density;Landroidx/compose/ui/text/font/FontFamily$Resolver;Ljava/util/List;Ljava/util/List;IZ)Landroidx/compose/ui/text/Paragraph;", "resourceLoader", "Landroidx/compose/ui/text/font/Font$ResourceLoader;", "ceilToInt", "ui-text_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class ParagraphKt {

    public static final int DefaultMaxLines = Integer.MAX_VALUE;
    @Deprecated(message = "Paragraph that takes maximum allowed width is deprecated, pass constraints instead.", replaceWith = @ReplaceWith(...))
    public static final androidx.compose.ui.text.Paragraph Paragraph(androidx.compose.ui.text.ParagraphIntrinsics paragraphIntrinsics, int maxLines, boolean ellipsis, float width) {
        final int ceilToInt = ParagraphKt.ceilToInt(width);
        return AndroidParagraph_androidKt.ActualParagraph--hBUhpc(paragraphIntrinsics, maxLines, ellipsis, ConstraintsKt.Constraints$default(0, ceilToInt, 0, 0, 13, 0));
    }

    @Deprecated(message = "Paragraph that takes maximum allowed width is deprecated, pass constraints instead.", replaceWith = @ReplaceWith(...))
    public static final androidx.compose.ui.text.Paragraph Paragraph(String text, androidx.compose.ui.text.TextStyle style, float width, Density density, FontFamily.Resolver fontFamilyResolver, List<androidx.compose.ui.text.AnnotatedString.Range<androidx.compose.ui.text.SpanStyle>> spanStyles, List<androidx.compose.ui.text.AnnotatedString.Range<androidx.compose.ui.text.Placeholder>> placeholders, int maxLines, boolean ellipsis) {
        return AndroidParagraph_androidKt.ActualParagraph-O3s9Psw(text, style, spanStyles, placeholders, maxLines, ellipsis, ConstraintsKt.Constraints$default(0, ParagraphKt.ceilToInt(width), 0, 0, 13, 0), obj13, density);
    }

    @Deprecated(message = "Font.ResourceLoader is deprecated, instead pass FontFamily.Resolver", replaceWith = @ReplaceWith(...))
    public static final androidx.compose.ui.text.Paragraph Paragraph(String text, androidx.compose.ui.text.TextStyle style, List<androidx.compose.ui.text.AnnotatedString.Range<androidx.compose.ui.text.SpanStyle>> spanStyles, List<androidx.compose.ui.text.AnnotatedString.Range<androidx.compose.ui.text.Placeholder>> placeholders, int maxLines, boolean ellipsis, float width, Density density, Font.ResourceLoader resourceLoader) {
        return AndroidParagraph_androidKt.ActualParagraph(text, style, spanStyles, placeholders, maxLines, ellipsis, width, density, resourceLoader);
    }

    public static androidx.compose.ui.text.Paragraph Paragraph$default(androidx.compose.ui.text.ParagraphIntrinsics paragraphIntrinsics, int i2, boolean z3, float f4, int i5, Object object6) {
        int obj1;
        int obj2;
        if (i5 & 2 != 0) {
            obj1 = Integer.MAX_VALUE;
        }
        if (i5 &= 4 != 0) {
            obj2 = 0;
        }
        return ParagraphKt.Paragraph(paragraphIntrinsics, obj1, obj2, f4);
    }

    public static androidx.compose.ui.text.Paragraph Paragraph$default(String string, androidx.compose.ui.text.TextStyle textStyle2, float f3, Density density4, FontFamily.Resolver fontFamily$Resolver5, List list6, List list7, int i8, boolean z9, int i10, Object object11) {
        int i;
        int emptyList2;
        int emptyList;
        int i4;
        List list2;
        List list;
        int i2;
        int i3;
        int i5 = i10;
        if (i5 & 32 != 0) {
            list2 = emptyList2;
        } else {
            list2 = list6;
        }
        if (i5 & 64 != 0) {
            list = emptyList;
        } else {
            list = list7;
        }
        i2 = i5 & 128 != 0 ? i4 : i8;
        i3 = i5 &= 256 != 0 ? i : z9;
        return ParagraphKt.Paragraph(string, textStyle2, f3, density4, resolver5, list2, list, i2, i3);
    }

    public static androidx.compose.ui.text.Paragraph Paragraph$default(String string, androidx.compose.ui.text.TextStyle textStyle2, List list3, List list4, int i5, boolean z6, float f7, Density density8, Font.ResourceLoader font$ResourceLoader9, int i10, Object object11) {
        List list;
        List list2;
        int i;
        int i2;
        List obj11;
        List obj12;
        int obj13;
        int obj14;
        if (i10 & 4 != 0) {
            list = obj11;
        } else {
            list = list3;
        }
        if (i10 & 8 != 0) {
            list2 = obj12;
        } else {
            list2 = list4;
        }
        i = i10 & 16 != 0 ? obj13 : i5;
        i2 = i10 & 32 != 0 ? obj14 : z6;
        return ParagraphKt.Paragraph(string, textStyle2, list, list2, i, i2, f7, density8, resourceLoader9);
    }

    public static final androidx.compose.ui.text.Paragraph Paragraph-UdtVg6A(String text, androidx.compose.ui.text.TextStyle style, long constraints, Density density, FontFamily.Resolver fontFamilyResolver, List<androidx.compose.ui.text.AnnotatedString.Range<androidx.compose.ui.text.SpanStyle>> spanStyles, List<androidx.compose.ui.text.AnnotatedString.Range<androidx.compose.ui.text.Placeholder>> placeholders, int maxLines, boolean ellipsis) {
        return AndroidParagraph_androidKt.ActualParagraph-O3s9Psw(text, style, placeholders, maxLines, ellipsis, obj12, constraints, maxLines, fontFamilyResolver);
    }

    public static androidx.compose.ui.text.Paragraph Paragraph-UdtVg6A$default(String string, androidx.compose.ui.text.TextStyle textStyle2, long l3, Density density4, FontFamily.Resolver fontFamily$Resolver5, List list6, List list7, int i8, boolean z9, int i10, Object object11) {
        int i2;
        int emptyList2;
        int emptyList;
        int i3;
        List list2;
        List list;
        int i4;
        int i;
        int i5 = object11;
        if (i5 & 32 != 0) {
            list2 = emptyList2;
        } else {
            list2 = list7;
        }
        if (i5 & 64 != 0) {
            list = emptyList;
        } else {
            list = i8;
        }
        i4 = i5 & 128 != 0 ? i3 : z9;
        i = i5 &= 256 != 0 ? i2 : i10;
        return ParagraphKt.Paragraph-UdtVg6A(string, textStyle2, l3, obj5, resolver5, list6, list2, list, i4);
    }

    public static final androidx.compose.ui.text.Paragraph Paragraph-_EkL_-Y(androidx.compose.ui.text.ParagraphIntrinsics paragraphIntrinsics, long constraints, int maxLines, boolean ellipsis) {
        return AndroidParagraph_androidKt.ActualParagraph--hBUhpc(paragraphIntrinsics, ellipsis, obj5, constraints);
    }

    public static androidx.compose.ui.text.Paragraph Paragraph-_EkL_-Y$default(androidx.compose.ui.text.ParagraphIntrinsics paragraphIntrinsics, long l2, int i3, boolean z4, int i5, Object object6) {
        int obj3;
        int obj4;
        if (object6 & 4 != 0) {
            obj3 = Integer.MAX_VALUE;
        }
        if (object6 &= 8 != 0) {
            obj4 = 0;
        }
        return ParagraphKt.Paragraph-_EkL_-Y(paragraphIntrinsics, l2, i3, obj3);
    }

    public static final int ceilToInt(float $this$ceilToInt) {
        return (int)f;
    }
}
