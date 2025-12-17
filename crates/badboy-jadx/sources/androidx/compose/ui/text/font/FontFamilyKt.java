package androidx.compose.ui.text.font;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0007\u001a!\u0010\u0000\u001a\u00020\u00012\u0012\u0010\u0004\u001a\n\u0012\u0006\u0008\u0001\u0012\u00020\u00060\u0005\"\u00020\u0006H\u0007¢\u0006\u0002\u0010\u0007\u001a\u0016\u0010\u0000\u001a\u00020\u00012\u000c\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u00020\u00060\u0008H\u0007¨\u0006\t", d2 = {"FontFamily", "Landroidx/compose/ui/text/font/FontFamily;", "typeface", "Landroidx/compose/ui/text/font/Typeface;", "fonts", "", "Landroidx/compose/ui/text/font/Font;", "([Landroidx/compose/ui/text/font/Font;)Landroidx/compose/ui/text/font/FontFamily;", "", "ui-text_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class FontFamilyKt {
    public static final androidx.compose.ui.text.font.FontFamily FontFamily(androidx.compose.ui.text.font.Typeface typeface) {
        LoadedFontFamily loadedFontFamily = new LoadedFontFamily(typeface);
        return (FontFamily)loadedFontFamily;
    }

    public static final androidx.compose.ui.text.font.FontFamily FontFamily(List<? extends androidx.compose.ui.text.font.Font> fonts) {
        FontListFontFamily fontListFontFamily = new FontListFontFamily(fonts);
        return (FontFamily)fontListFontFamily;
    }

    public static final androidx.compose.ui.text.font.FontFamily FontFamily(androidx.compose.ui.text.font.Font... fonts) {
        FontListFontFamily fontListFontFamily = new FontListFontFamily(ArraysKt.asList(fonts));
        return (FontFamily)fontListFontFamily;
    }
}
