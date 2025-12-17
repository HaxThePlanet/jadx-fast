package androidx.compose.ui.text.font;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\u001a.\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u0007H\u0007ø\u0001\u0000¢\u0006\u0004\u0008\u0008\u0010\t\u001a8\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u00072\u0008\u0008\u0002\u0010\n\u001a\u00020\u000bH\u0007ø\u0001\u0000¢\u0006\u0004\u0008\u000c\u0010\r\u001aB\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u00072\u0008\u0008\u0002\u0010\n\u001a\u00020\u000b2\u0008\u0008\u0002\u0010\u000e\u001a\u00020\u000fH\u0007ø\u0001\u0000¢\u0006\u0004\u0008\u0010\u0010\u0011\u001a\u000c\u0010\u0012\u001a\u00020\u0013*\u00020\u0001H\u0007\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006\u0014", d2 = {"Font", "Landroidx/compose/ui/text/font/Font;", "resId", "", "weight", "Landroidx/compose/ui/text/font/FontWeight;", "style", "Landroidx/compose/ui/text/font/FontStyle;", "Font-RetOiIg", "(ILandroidx/compose/ui/text/font/FontWeight;I)Landroidx/compose/ui/text/font/Font;", "loadingStrategy", "Landroidx/compose/ui/text/font/FontLoadingStrategy;", "Font-YpTlLL0", "(ILandroidx/compose/ui/text/font/FontWeight;II)Landroidx/compose/ui/text/font/Font;", "variationSettings", "Landroidx/compose/ui/text/font/FontVariation$Settings;", "Font-F3nL8kk", "(ILandroidx/compose/ui/text/font/FontWeight;IILandroidx/compose/ui/text/font/FontVariation$Settings;)Landroidx/compose/ui/text/font/Font;", "toFontFamily", "Landroidx/compose/ui/text/font/FontFamily;", "ui-text_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class FontKt {
    public static final androidx.compose.ui.text.font.Font Font-F3nL8kk(int resId, androidx.compose.ui.text.font.FontWeight weight, int style, int loadingStrategy, androidx.compose.ui.text.font.FontVariation.Settings variationSettings) {
        ResourceFont resourceFont = new ResourceFont(resId, weight, style, variationSettings, loadingStrategy, 0);
        return (Font)resourceFont;
    }

    public static androidx.compose.ui.text.font.Font Font-F3nL8kk$default(int i, androidx.compose.ui.text.font.FontWeight fontWeight2, int i3, int i4, androidx.compose.ui.text.font.FontVariation.Settings fontVariation$Settings5, int i6, Object object7) {
        androidx.compose.ui.text.font.FontWeight obj1;
        int obj2;
        int obj3;
        androidx.compose.ui.text.font.FontVariation.Settings obj4;
        int obj5;
        if (i6 & 2 != 0) {
            obj1 = FontWeight.Companion.getNormal();
        }
        if (i6 & 4 != 0) {
            obj2 = FontStyle.Companion.getNormal-_-LCdwA();
        }
        if (i6 & 8 != 0) {
            obj3 = FontLoadingStrategy.Companion.getBlocking-PKNRLFQ();
        }
        if (i6 &= 16 != 0) {
            obj4 = FontVariation.INSTANCE.Settings-6EWAqTQ(obj1, obj2, new FontVariation.Setting[0]);
        }
        return FontKt.Font-F3nL8kk(i, obj1, obj2, obj3, obj4);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility until Compose 1.3.", replaceWith = @ReplaceWith(...))
    public static final androidx.compose.ui.text.font.Font Font-RetOiIg(int resId, androidx.compose.ui.text.font.FontWeight weight, int style) {
        ResourceFont resourceFont = new ResourceFont(resId, weight, style, 0, FontLoadingStrategy.Companion.getBlocking-PKNRLFQ(), 8, 0);
        return (Font)resourceFont;
    }

    public static androidx.compose.ui.text.font.Font Font-RetOiIg$default(int i, androidx.compose.ui.text.font.FontWeight fontWeight2, int i3, int i4, Object object5) {
        androidx.compose.ui.text.font.FontWeight obj1;
        int obj2;
        if (i4 & 2 != 0) {
            obj1 = FontWeight.Companion.getNormal();
        }
        if (i4 &= 4 != 0) {
            obj2 = FontStyle.Companion.getNormal-_-LCdwA();
        }
        return FontKt.Font-RetOiIg(i, obj1, obj2);
    }

    public static final androidx.compose.ui.text.font.Font Font-YpTlLL0(int resId, androidx.compose.ui.text.font.FontWeight weight, int style, int loadingStrategy) {
        FontVariation.Settings settings = new FontVariation.Settings(new FontVariation.Setting[0]);
        ResourceFont resourceFont = new ResourceFont(resId, weight, style, settings, loadingStrategy, 0);
        return (Font)resourceFont;
    }

    public static androidx.compose.ui.text.font.Font Font-YpTlLL0$default(int i, androidx.compose.ui.text.font.FontWeight fontWeight2, int i3, int i4, int i5, Object object6) {
        androidx.compose.ui.text.font.FontWeight obj1;
        int obj2;
        int obj3;
        if (i5 & 2 != 0) {
            obj1 = FontWeight.Companion.getNormal();
        }
        if (i5 & 4 != 0) {
            obj2 = FontStyle.Companion.getNormal-_-LCdwA();
        }
        if (i5 &= 8 != 0) {
            obj3 = FontLoadingStrategy.Companion.getBlocking-PKNRLFQ();
        }
        return FontKt.Font-YpTlLL0(i, obj1, obj2, obj3);
    }

    public static final androidx.compose.ui.text.font.FontFamily toFontFamily(androidx.compose.ui.text.font.Font $this$toFontFamily) {
        androidx.compose.ui.text.font.Font[] arr = new Font[1];
        return FontFamilyKt.FontFamily($this$toFontFamily);
    }
}
