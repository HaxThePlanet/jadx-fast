package androidx.compose.material3;

import androidx.compose.material.ripple.RippleAlpha;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008Ç\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u0007", d2 = {"Landroidx/compose/material3/RippleDefaults;", "", "()V", "RippleAlpha", "Landroidx/compose/material/ripple/RippleAlpha;", "getRippleAlpha", "()Landroidx/compose/material/ripple/RippleAlpha;", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class RippleDefaults {

    public static final int $stable;
    public static final androidx.compose.material3.RippleDefaults INSTANCE;
    private static final RippleAlpha RippleAlpha;
    static {
        RippleDefaults rippleDefaults = new RippleDefaults();
        RippleDefaults.INSTANCE = rippleDefaults;
        final int i2 = 1036831949;
        RippleAlpha rippleAlpha = new RippleAlpha(1042536202, i2, 1034147594, i2);
        RippleDefaults.RippleAlpha = rippleAlpha;
    }

    public final RippleAlpha getRippleAlpha() {
        return RippleDefaults.RippleAlpha;
    }
}
