package androidx.compose.ui.text.font;

import android.content.Context;
import android.graphics.Typeface;
import androidx.compose.ui.text.platform.AndroidDefaultTypeface;
import androidx.compose.ui.text.platform.AndroidFontListTypeface;
import androidx.compose.ui.text.platform.AndroidGenericFontFamilyTypeface;
import androidx.compose.ui.text.platform.AndroidTypefaceWrapper;
import java.util.List;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.ReplaceWith;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000.\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003\u001a6\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0008\u001a\u00020\u00012\u001c\u0008\u0002\u0010\t\u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000c\u0012\u0004\u0012\u00020\r0\u000b\u0018\u00010\nH\u0007\u001a\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0002\u001a\u00020\u0003¨\u0006\u000e", d2 = {"FontFamily", "Landroidx/compose/ui/text/font/FontFamily;", "typeface", "Landroid/graphics/Typeface;", "Typeface", "Landroidx/compose/ui/text/font/Typeface;", "context", "Landroid/content/Context;", "fontFamily", "styles", "", "Lkotlin/Pair;", "Landroidx/compose/ui/text/font/FontWeight;", "Landroidx/compose/ui/text/font/FontStyle;", "ui-text_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class AndroidTypeface_androidKt {
    public static final androidx.compose.ui.text.font.FontFamily FontFamily(Typeface typeface) {
        return FontFamilyKt.FontFamily(AndroidTypeface_androidKt.Typeface(typeface));
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "This API is deprecated with the introduction of async fonts which cannot resolve in this context. To preload fonts, use FontFamily.Resolver.", replaceWith = @ReplaceWith(...))
    public static final androidx.compose.ui.text.font.Typeface Typeface(Context context, androidx.compose.ui.text.font.FontFamily fontFamily, List<Pair<androidx.compose.ui.text.font.FontWeight, androidx.compose.ui.text.font.FontStyle>> styles) {
        androidx.compose.ui.text.font.Typeface androidFontListTypeface;
        Object obj;
        Object context2;
        Object obj2;
        int i;
        int i2;
        int i3;
        Object obj8;
        Object obj10;
        if (fontFamily instanceof FontListFontFamily) {
            androidFontListTypeface = new AndroidFontListTypeface((FontListFontFamily)fontFamily, context, styles, 0, 8, 0);
            return androidFontListTypeface;
        } else {
            context2 = context;
            obj2 = styles;
            if (fontFamily instanceof GenericFontFamily) {
                obj8 = new AndroidGenericFontFamilyTypeface((GenericFontFamily)fontFamily);
                androidFontListTypeface = obj8;
            } else {
                if (fontFamily instanceof DefaultFontFamily) {
                    obj8 = new AndroidDefaultTypeface();
                    androidFontListTypeface = obj8;
                } else {
                    if (!fontFamily instanceof LoadedFontFamily) {
                    } else {
                        androidFontListTypeface = (LoadedFontFamily)fontFamily.getTypeface();
                    }
                }
            }
        }
        obj8 = new NoWhenBranchMatchedException();
        throw obj8;
    }

    public static final androidx.compose.ui.text.font.Typeface Typeface(Typeface typeface) {
        AndroidTypefaceWrapper androidTypefaceWrapper = new AndroidTypefaceWrapper(typeface);
        return (Typeface)androidTypefaceWrapper;
    }

    public static androidx.compose.ui.text.font.Typeface Typeface$default(Context context, androidx.compose.ui.text.font.FontFamily fontFamily2, List list3, int i4, Object object5) {
        int obj2;
        if (i4 &= 4 != 0) {
            obj2 = 0;
        }
        return AndroidTypeface_androidKt.Typeface(context, fontFamily2, obj2);
    }
}
