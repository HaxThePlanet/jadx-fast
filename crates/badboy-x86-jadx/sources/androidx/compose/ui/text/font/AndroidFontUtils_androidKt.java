package androidx.compose.ui.text.font;

import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000&\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0002\u0008\u0002\u001a\"\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00012\u0006\u0010\u0008\u001a\u00020\tH\u0000ø\u0001\u0000¢\u0006\u0004\u0008\n\u0010\u000b\u001a\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000c\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rH\u0000\"\u0018\u0010\u0000\u001a\u00020\u0001*\u00020\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\u0008\u0003\u0010\u0004\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006\u000f", d2 = {"AndroidBold", "Landroidx/compose/ui/text/font/FontWeight;", "Landroidx/compose/ui/text/font/FontWeight$Companion;", "getAndroidBold", "(Landroidx/compose/ui/text/font/FontWeight$Companion;)Landroidx/compose/ui/text/font/FontWeight;", "getAndroidTypefaceStyle", "", "fontWeight", "fontStyle", "Landroidx/compose/ui/text/font/FontStyle;", "getAndroidTypefaceStyle-FO1MlWM", "(Landroidx/compose/ui/text/font/FontWeight;I)I", "isBold", "", "isItalic", "ui-text_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class AndroidFontUtils_androidKt {
    public static final androidx.compose.ui.text.font.FontWeight getAndroidBold(androidx.compose.ui.text.font.FontWeight.Companion $this$AndroidBold) {
        return $this$AndroidBold.getW600();
    }

    public static final int getAndroidTypefaceStyle(boolean isBold, boolean isItalic) {
        int i;
        if (isItalic && isBold) {
            i = isBold ? 3 : isBold ? 1 : isItalic ? 2 : 0;
        } else {
        }
        return i;
    }

    public static final int getAndroidTypefaceStyle-FO1MlWM(androidx.compose.ui.text.font.FontWeight fontWeight, int fontStyle) {
        int i;
        i = fontWeight.compareTo(AndroidFontUtils_androidKt.getAndroidBold(FontWeight.Companion)) >= 0 ? 1 : 0;
        return AndroidFontUtils_androidKt.getAndroidTypefaceStyle(i, FontStyle.equals-impl0(fontStyle, FontStyle.Companion.getItalic-_-LCdwA()));
    }
}
