package androidx.compose.foundation.text;

import androidx.compose.ui.text.Paragraph;
import androidx.compose.ui.text.ParagraphKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily.Resolver;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntSizeKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.text.StringsKt;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000*\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u001a9\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0008\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u000c\u001a\u00020\r2\u0008\u0008\u0002\u0010\u000e\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u000f\u001a\u00020\u0001H\u0000¢\u0006\u0002\u0010\u0010\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0004\u0010\u0005¨\u0006\u0011", d2 = {"DefaultWidthCharCount", "", "EmptyTextReplacement", "", "getEmptyTextReplacement", "()Ljava/lang/String;", "computeSizeForDefaultText", "Landroidx/compose/ui/unit/IntSize;", "style", "Landroidx/compose/ui/text/TextStyle;", "density", "Landroidx/compose/ui/unit/Density;", "fontFamilyResolver", "Landroidx/compose/ui/text/font/FontFamily$Resolver;", "text", "maxLines", "(Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/unit/Density;Landroidx/compose/ui/text/font/FontFamily$Resolver;Ljava/lang/String;I)J", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class TextFieldDelegateKt {

    public static final int DefaultWidthCharCount = 10;
    private static final String EmptyTextReplacement;
    static {
        TextFieldDelegateKt.EmptyTextReplacement = StringsKt.repeat((CharSequence)"H", 10);
    }

    public static final long computeSizeForDefaultText(TextStyle style, Density density, FontFamily.Resolver fontFamilyResolver, String text, int maxLines) {
        final int i4 = 0;
        Paragraph paragraph = ParagraphKt.Paragraph-UdtVg6A$default(text, style, ConstraintsKt.Constraints$default(0, 0, 0, i4, 15, 0), i4, density, fontFamilyResolver, CollectionsKt.emptyList(), 0, maxLines, 0, 64);
        return IntSizeKt.IntSize(TextDelegateKt.ceilToIntPx(paragraph.getMinIntrinsicWidth()), TextDelegateKt.ceilToIntPx(paragraph.getHeight()));
    }

    public static long computeSizeForDefaultText$default(TextStyle textStyle, Density density2, FontFamily.Resolver fontFamily$Resolver3, String string4, int i5, int i6, Object object7) {
        String obj3;
        int obj4;
        if (i6 & 8 != 0) {
            obj3 = TextFieldDelegateKt.EmptyTextReplacement;
        }
        if (i6 &= 16 != 0) {
            obj4 = 1;
        }
        return TextFieldDelegateKt.computeSizeForDefaultText(textStyle, density2, resolver3, obj3, obj4);
    }

    public static final String getEmptyTextReplacement() {
        return TextFieldDelegateKt.EmptyTextReplacement;
    }
}
