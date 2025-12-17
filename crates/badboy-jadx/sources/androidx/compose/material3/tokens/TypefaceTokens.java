package androidx.compose.material3.tokens;

import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontFamily.Companion;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.font.FontWeight.Companion;
import androidx.compose.ui.text.font.GenericFontFamily;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0007\u0008À\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0008\u0010\u0006R\u0011\u0010\t\u001a\u00020\n¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000b\u0010\u000cR\u0011\u0010\r\u001a\u00020\n¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000e\u0010\u000cR\u0011\u0010\u000f\u001a\u00020\n¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0010\u0010\u000c¨\u0006\u0011", d2 = {"Landroidx/compose/material3/tokens/TypefaceTokens;", "", "()V", "Brand", "Landroidx/compose/ui/text/font/GenericFontFamily;", "getBrand", "()Landroidx/compose/ui/text/font/GenericFontFamily;", "Plain", "getPlain", "WeightBold", "Landroidx/compose/ui/text/font/FontWeight;", "getWeightBold", "()Landroidx/compose/ui/text/font/FontWeight;", "WeightMedium", "getWeightMedium", "WeightRegular", "getWeightRegular", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class TypefaceTokens {

    public static final int $stable;
    private static final GenericFontFamily Brand;
    public static final androidx.compose.material3.tokens.TypefaceTokens INSTANCE;
    private static final GenericFontFamily Plain;
    private static final FontWeight WeightBold;
    private static final FontWeight WeightMedium;
    private static final FontWeight WeightRegular;
    static {
        TypefaceTokens typefaceTokens = new TypefaceTokens();
        TypefaceTokens.INSTANCE = typefaceTokens;
        TypefaceTokens.Brand = FontFamily.Companion.getSansSerif();
        TypefaceTokens.Plain = FontFamily.Companion.getSansSerif();
        TypefaceTokens.WeightBold = FontWeight.Companion.getBold();
        TypefaceTokens.WeightMedium = FontWeight.Companion.getMedium();
        TypefaceTokens.WeightRegular = FontWeight.Companion.getNormal();
    }

    public final GenericFontFamily getBrand() {
        return TypefaceTokens.Brand;
    }

    public final GenericFontFamily getPlain() {
        return TypefaceTokens.Plain;
    }

    public final FontWeight getWeightBold() {
        return TypefaceTokens.WeightBold;
    }

    public final FontWeight getWeightMedium() {
        return TypefaceTokens.WeightMedium;
    }

    public final FontWeight getWeightRegular() {
        return TypefaceTokens.WeightRegular;
    }
}
