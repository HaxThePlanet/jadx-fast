package androidx.compose.ui.text;

import androidx.compose.ui.text.font.DelegatingFontLoaderForDeprecatedUsage_androidKt;
import androidx.compose.ui.text.font.Font.ResourceLoader;
import androidx.compose.ui.text.font.FontFamily.Resolver;
import androidx.compose.ui.text.platform.AndroidParagraphIntrinsics_androidKt;
import androidx.compose.ui.unit.Density;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.collections.CollectionsKt;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001aT\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0014\u0008\u0002\u0010\u0006\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\t0\u00080\u00072\u0014\u0008\u0002\u0010\n\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u000b0\u00080\u00072\u0006\u0010\u000c\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0007\u001aR\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0014\u0008\u0002\u0010\u0006\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\t0\u00080\u00072\u0014\u0008\u0002\u0010\n\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u000b0\u00080\u00072\u0006\u0010\u000c\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u0011¨\u0006\u0012", d2 = {"ParagraphIntrinsics", "Landroidx/compose/ui/text/ParagraphIntrinsics;", "text", "", "style", "Landroidx/compose/ui/text/TextStyle;", "spanStyles", "", "Landroidx/compose/ui/text/AnnotatedString$Range;", "Landroidx/compose/ui/text/SpanStyle;", "placeholders", "Landroidx/compose/ui/text/Placeholder;", "density", "Landroidx/compose/ui/unit/Density;", "resourceLoader", "Landroidx/compose/ui/text/font/Font$ResourceLoader;", "fontFamilyResolver", "Landroidx/compose/ui/text/font/FontFamily$Resolver;", "ui-text_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class ParagraphIntrinsicsKt {
    @Deprecated(message = "Font.ResourceLoader is deprecated, instead use FontFamily.Resolver", replaceWith = @ReplaceWith(...))
    public static final androidx.compose.ui.text.ParagraphIntrinsics ParagraphIntrinsics(String text, androidx.compose.ui.text.TextStyle style, List<androidx.compose.ui.text.AnnotatedString.Range<androidx.compose.ui.text.SpanStyle>> spanStyles, List<androidx.compose.ui.text.AnnotatedString.Range<androidx.compose.ui.text.Placeholder>> placeholders, Density density, Font.ResourceLoader resourceLoader) {
        return AndroidParagraphIntrinsics_androidKt.ActualParagraphIntrinsics(text, style, spanStyles, placeholders, density, DelegatingFontLoaderForDeprecatedUsage_androidKt.createFontFamilyResolver(resourceLoader));
    }

    public static final androidx.compose.ui.text.ParagraphIntrinsics ParagraphIntrinsics(String text, androidx.compose.ui.text.TextStyle style, List<androidx.compose.ui.text.AnnotatedString.Range<androidx.compose.ui.text.SpanStyle>> spanStyles, List<androidx.compose.ui.text.AnnotatedString.Range<androidx.compose.ui.text.Placeholder>> placeholders, Density density, FontFamily.Resolver fontFamilyResolver) {
        return AndroidParagraphIntrinsics_androidKt.ActualParagraphIntrinsics(text, style, spanStyles, placeholders, density, fontFamilyResolver);
    }

    public static androidx.compose.ui.text.ParagraphIntrinsics ParagraphIntrinsics$default(String string, androidx.compose.ui.text.TextStyle textStyle2, List list3, List list4, Density density5, Font.ResourceLoader font$ResourceLoader6, int i7, Object object8) {
        List list2;
        List list;
        List obj8;
        List obj9;
        if (i7 & 4 != 0) {
            list2 = obj8;
        } else {
            list2 = list3;
        }
        if (i7 & 8 != 0) {
            list = obj9;
        } else {
            list = list4;
        }
        return ParagraphIntrinsicsKt.ParagraphIntrinsics(string, textStyle2, list2, list, density5, resourceLoader6);
    }

    public static androidx.compose.ui.text.ParagraphIntrinsics ParagraphIntrinsics$default(String string, androidx.compose.ui.text.TextStyle textStyle2, List list3, List list4, Density density5, FontFamily.Resolver fontFamily$Resolver6, int i7, Object object8) {
        List list2;
        List list;
        List obj8;
        List obj9;
        if (i7 & 4 != 0) {
            list2 = obj8;
        } else {
            list2 = list3;
        }
        if (i7 & 8 != 0) {
            list = obj9;
        } else {
            list = list4;
        }
        return ParagraphIntrinsicsKt.ParagraphIntrinsics(string, textStyle2, list2, list, density5, resolver6);
    }
}
