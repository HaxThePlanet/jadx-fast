package androidx.compose.ui.text.font;

import android.graphics.Typeface;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000b\n\u0000\u0008Á\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0008\u001a\u00020\tH\u0007¨\u0006\n", d2 = {"Landroidx/compose/ui/text/font/TypefaceHelperMethodsApi28;", "", "()V", "create", "Landroid/graphics/Typeface;", "typeface", "finalFontWeight", "", "finalFontStyle", "", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class TypefaceHelperMethodsApi28 {

    public static final int $stable;
    public static final androidx.compose.ui.text.font.TypefaceHelperMethodsApi28 INSTANCE;
    static {
        TypefaceHelperMethodsApi28 typefaceHelperMethodsApi28 = new TypefaceHelperMethodsApi28();
        TypefaceHelperMethodsApi28.INSTANCE = typefaceHelperMethodsApi28;
    }

    public final Typeface create(Typeface typeface, int finalFontWeight, boolean finalFontStyle) {
        return Typeface.create(typeface, finalFontWeight, finalFontStyle);
    }
}
