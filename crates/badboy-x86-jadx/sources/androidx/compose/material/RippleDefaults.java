package androidx.compose.material;

import androidx.compose.material.ripple.RippleAlpha;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Color.Companion;
import androidx.compose.ui.graphics.ColorKt;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0006\u0008Ç\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0008ø\u0001\u0000¢\u0006\u0004\u0008\t\u0010\nJ \u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0008ø\u0001\u0000¢\u0006\u0004\u0008\u000c\u0010\r\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006\u000e", d2 = {"Landroidx/compose/material/RippleDefaults;", "", "()V", "rippleAlpha", "Landroidx/compose/material/ripple/RippleAlpha;", "contentColor", "Landroidx/compose/ui/graphics/Color;", "lightTheme", "", "rippleAlpha-DxMtmZc", "(JZ)Landroidx/compose/material/ripple/RippleAlpha;", "rippleColor", "rippleColor-5vOe2sY", "(JZ)J", "material_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class RippleDefaults {

    public static final int $stable;
    public static final androidx.compose.material.RippleDefaults INSTANCE;
    static {
        RippleDefaults rippleDefaults = new RippleDefaults();
        RippleDefaults.INSTANCE = rippleDefaults;
    }

    public final RippleAlpha rippleAlpha-DxMtmZc(long contentColor, boolean lightTheme) {
        RippleAlpha rippleAlpha;
        long l;
        if (obj7 != null) {
            if (Double.compare(d, l) > 0) {
                rippleAlpha = RippleKt.access$getLightThemeHighContrastRippleAlpha$p();
            } else {
                rippleAlpha = RippleKt.access$getLightThemeLowContrastRippleAlpha$p();
            }
        } else {
            rippleAlpha = RippleKt.access$getDarkThemeRippleAlpha$p();
        }
        return rippleAlpha;
    }

    public final long rippleColor-5vOe2sY(long contentColor, boolean lightTheme) {
        int cmp;
        long white-0d7_KjU;
        long l;
        if (obj8 == null && Double.compare(d, l) < 0) {
            if (Double.compare(d, l) < 0) {
                white-0d7_KjU = Color.Companion.getWhite-0d7_KjU();
            } else {
                white-0d7_KjU = contentColor;
            }
        } else {
        }
        return white-0d7_KjU;
    }
}
