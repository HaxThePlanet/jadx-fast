package androidx.compose.ui.text;

import androidx.compose.ui.text.font.DelegatingFontLoaderForDeprecatedUsage_androidKt;
import androidx.compose.ui.text.font.Font.ResourceLoader;
import androidx.compose.ui.text.font.FontFamily.Resolver;
import androidx.compose.ui.text.style.TextDirection;
import androidx.compose.ui.text.style.TextDirection.Companion;
import androidx.compose.ui.unit.Density;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.ReplaceWith;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u000b\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0007\n\u0002\u0008\t\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0007\u0018\u00002\u00020\u0001B;\u0008\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0012\u0010\u0006\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\t0\u00080\u0007\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\u000c\u001a\u00020\r¢\u0006\u0002\u0010\u000eB9\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0012\u0010\u0006\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\t0\u00080\u0007\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\u000f\u001a\u00020\u0010¢\u0006\u0002\u0010\u0011J\u0018\u0010&\u001a\u00020'2\u0006\u0010\u0004\u001a\u00020'2\u0006\u0010(\u001a\u00020'H\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\u00020\u00158VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\u0008\u0012\u0004\u0012\u00020\u00190\u0007X\u0080\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001a\u0010\u001bR\u001b\u0010\u001c\u001a\u00020\u001d8VX\u0096\u0084\u0002¢\u0006\u000c\n\u0004\u0008 \u0010!\u001a\u0004\u0008\u001e\u0010\u001fR\u001b\u0010\"\u001a\u00020\u001d8VX\u0096\u0084\u0002¢\u0006\u000c\n\u0004\u0008$\u0010!\u001a\u0004\u0008#\u0010\u001fR\u001d\u0010\u0006\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\t0\u00080\u0007¢\u0006\u0008\n\u0000\u001a\u0004\u0008%\u0010\u001b¨\u0006)", d2 = {"Landroidx/compose/ui/text/MultiParagraphIntrinsics;", "Landroidx/compose/ui/text/ParagraphIntrinsics;", "annotatedString", "Landroidx/compose/ui/text/AnnotatedString;", "style", "Landroidx/compose/ui/text/TextStyle;", "placeholders", "", "Landroidx/compose/ui/text/AnnotatedString$Range;", "Landroidx/compose/ui/text/Placeholder;", "density", "Landroidx/compose/ui/unit/Density;", "resourceLoader", "Landroidx/compose/ui/text/font/Font$ResourceLoader;", "(Landroidx/compose/ui/text/AnnotatedString;Landroidx/compose/ui/text/TextStyle;Ljava/util/List;Landroidx/compose/ui/unit/Density;Landroidx/compose/ui/text/font/Font$ResourceLoader;)V", "fontFamilyResolver", "Landroidx/compose/ui/text/font/FontFamily$Resolver;", "(Landroidx/compose/ui/text/AnnotatedString;Landroidx/compose/ui/text/TextStyle;Ljava/util/List;Landroidx/compose/ui/unit/Density;Landroidx/compose/ui/text/font/FontFamily$Resolver;)V", "getAnnotatedString", "()Landroidx/compose/ui/text/AnnotatedString;", "hasStaleResolvedFonts", "", "getHasStaleResolvedFonts", "()Z", "infoList", "Landroidx/compose/ui/text/ParagraphIntrinsicInfo;", "getInfoList$ui_text_release", "()Ljava/util/List;", "maxIntrinsicWidth", "", "getMaxIntrinsicWidth", "()F", "maxIntrinsicWidth$delegate", "Lkotlin/Lazy;", "minIntrinsicWidth", "getMinIntrinsicWidth", "minIntrinsicWidth$delegate", "getPlaceholders", "resolveTextDirection", "Landroidx/compose/ui/text/ParagraphStyle;", "defaultStyle", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class MultiParagraphIntrinsics implements androidx.compose.ui.text.ParagraphIntrinsics {

    public static final int $stable = 8;
    private final androidx.compose.ui.text.AnnotatedString annotatedString;
    private final List<androidx.compose.ui.text.ParagraphIntrinsicInfo> infoList;
    private final Lazy maxIntrinsicWidth$delegate;
    private final Lazy minIntrinsicWidth$delegate;
    private final List<androidx.compose.ui.text.AnnotatedString.Range<androidx.compose.ui.text.Placeholder>> placeholders;
    static {
        final int i = 8;
    }

    @Deprecated(message = "Font.ResourceLoader is deprecated, call with fontFamilyResolver", replaceWith = @ReplaceWith(...))
    public MultiParagraphIntrinsics(androidx.compose.ui.text.AnnotatedString annotatedString, androidx.compose.ui.text.TextStyle style, List<androidx.compose.ui.text.AnnotatedString.Range<androidx.compose.ui.text.Placeholder>> placeholders, Density density, Font.ResourceLoader resourceLoader) {
        super(annotatedString, style, placeholders, density, DelegatingFontLoaderForDeprecatedUsage_androidKt.createFontFamilyResolver(resourceLoader));
    }

    public MultiParagraphIntrinsics(androidx.compose.ui.text.AnnotatedString annotatedString, androidx.compose.ui.text.TextStyle style, List<androidx.compose.ui.text.AnnotatedString.Range<androidx.compose.ui.text.Placeholder>> placeholders, Density density, FontFamily.Resolver fontFamilyResolver) {
        androidx.compose.ui.text.AnnotatedString str;
        List list2;
        androidx.compose.ui.text.ParagraphStyle paragraphStyle2;
        androidx.compose.ui.text.AnnotatedString annotatedString2;
        int i4;
        int index$iv$iv$iv;
        Object obj3;
        Object obj4;
        int i;
        Object obj;
        int i5;
        int i3;
        Object obj2;
        int i2;
        androidx.compose.ui.text.ParagraphStyle paragraphStyle3;
        androidx.compose.ui.text.AnnotatedString str4;
        String text;
        androidx.compose.ui.text.TextStyle merge;
        List spanStyles;
        List list;
        Density density2;
        FontFamily.Resolver resolver;
        androidx.compose.ui.text.AnnotatedString str2;
        androidx.compose.ui.text.ParagraphStyle paragraphStyle;
        androidx.compose.ui.text.AnnotatedString str3;
        final Object obj5 = this;
        super();
        obj5.annotatedString = annotatedString;
        obj5.placeholders = placeholders;
        MultiParagraphIntrinsics.minIntrinsicWidth.2 anon = new MultiParagraphIntrinsics.minIntrinsicWidth.2(obj5);
        obj5.minIntrinsicWidth$delegate = LazyKt.lazy(LazyThreadSafetyMode.NONE, (Function0)anon);
        MultiParagraphIntrinsics.maxIntrinsicWidth.2 anon2 = new MultiParagraphIntrinsics.maxIntrinsicWidth.2(obj5);
        obj5.maxIntrinsicWidth$delegate = LazyKt.lazy(LazyThreadSafetyMode.NONE, (Function0)anon2);
        i4 = 0;
        final List normalizedParagraphStyles = AnnotatedStringKt.normalizedParagraphStyles(obj5.annotatedString, style.toParagraphStyle());
        final int i6 = 0;
        ArrayList arrayList = new ArrayList(normalizedParagraphStyles.size());
        List list5 = normalizedParagraphStyles;
        final int i7 = 0;
        index$iv$iv$iv = 0;
        while (index$iv$iv$iv < list5.size()) {
            i = 0;
            obj = obj4;
            i5 = 0;
            androidx.compose.ui.text.AnnotatedString str5 = AnnotatedStringKt.access$substringWithoutParagraphStyles(annotatedString2, (AnnotatedString.Range)obj.getStart(), obj.getEnd());
            androidx.compose.ui.text.AnnotatedString str6 = str5;
            obj2 = obj;
            i2 = 0;
            str4 = str5;
            androidx.compose.ui.text.ParagraphStyle paragraphStyle4 = MultiParagraphIntrinsics.access$resolveTextDirection(obj5, (ParagraphStyle)obj2.getItem(), paragraphStyle2);
            paragraphStyle = paragraphStyle4;
            str3 = str6;
            ParagraphIntrinsicInfo paragraphStyle5 = new ParagraphIntrinsicInfo(ParagraphIntrinsicsKt.ParagraphIntrinsics(str6.getText(), style.merge(paragraphStyle4), str6.getSpanStyles(), MultiParagraphIntrinsicsKt.access$getLocalPlaceholders(obj5.getPlaceholders(), obj2.getStart(), obj2.getEnd()), density, fontFamilyResolver), obj2.getStart(), obj2.getEnd());
            (Collection)arrayList.add(paragraphStyle5);
            index$iv$iv$iv++;
            str = annotatedString;
            list2 = placeholders;
            i4 = i3;
            paragraphStyle2 = paragraphStyle3;
            annotatedString2 = str2;
        }
        obj5.infoList = (List)arrayList;
    }

    public static final androidx.compose.ui.text.ParagraphStyle access$resolveTextDirection(androidx.compose.ui.text.MultiParagraphIntrinsics $this, androidx.compose.ui.text.ParagraphStyle style, androidx.compose.ui.text.ParagraphStyle defaultStyle) {
        return $this.resolveTextDirection(style, defaultStyle);
    }

    private final androidx.compose.ui.text.ParagraphStyle resolveTextDirection(androidx.compose.ui.text.ParagraphStyle style, androidx.compose.ui.text.ParagraphStyle defaultStyle) {
        androidx.compose.ui.text.ParagraphStyle copy-ykzQM6k$default;
        int unspecified-s_7X-co;
        int i2;
        int textDirection-s_7X-co;
        int i4;
        int i8;
        int i3;
        int i10;
        int i;
        int i7;
        int i6;
        int i9;
        int i5;
        if (!TextDirection.equals-impl0(style.getTextDirection-s_7X-co(), TextDirection.Companion.getUnspecified-s_7X-co())) {
            copy-ykzQM6k$default = style;
        } else {
            copy-ykzQM6k$default = ParagraphStyle.copy-ykzQM6k$default(style, 0, defaultStyle.getTextDirection-s_7X-co(), 0, obj5, 0, 0, 0, 0, 0, 0, 509);
        }
        return copy-ykzQM6k$default;
    }

    @Override // androidx.compose.ui.text.ParagraphIntrinsics
    public final androidx.compose.ui.text.AnnotatedString getAnnotatedString() {
        return this.annotatedString;
    }

    @Override // androidx.compose.ui.text.ParagraphIntrinsics
    public boolean getHasStaleResolvedFonts() {
        int index$iv$iv;
        int i;
        Object obj;
        Object obj2;
        int i3;
        boolean it;
        int i2;
        androidx.compose.ui.text.ParagraphIntrinsics intrinsics;
        final int i4 = 0;
        final List list = infoList;
        final int i5 = 0;
        index$iv$iv = 0;
        while (index$iv$iv < list.size()) {
            i3 = 0;
            i2 = 0;
            index$iv$iv++;
        }
        i = 0;
        return i;
    }

    public final List<androidx.compose.ui.text.ParagraphIntrinsicInfo> getInfoList$ui_text_release() {
        return this.infoList;
    }

    @Override // androidx.compose.ui.text.ParagraphIntrinsics
    public float getMaxIntrinsicWidth() {
        return (Number)this.maxIntrinsicWidth$delegate.getValue().floatValue();
    }

    @Override // androidx.compose.ui.text.ParagraphIntrinsics
    public float getMinIntrinsicWidth() {
        return (Number)this.minIntrinsicWidth$delegate.getValue().floatValue();
    }

    public final List<androidx.compose.ui.text.AnnotatedString.Range<androidx.compose.ui.text.Placeholder>> getPlaceholders() {
        return this.placeholders;
    }
}
