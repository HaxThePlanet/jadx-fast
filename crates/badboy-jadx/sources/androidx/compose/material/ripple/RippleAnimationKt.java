package androidx.compose.material.ripple;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000.\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0003\u001a\u001a\u0010\u0007\u001a\u00020\u00082\u0006\u0010\t\u001a\u00020\nH\u0000ø\u0001\u0000¢\u0006\u0004\u0008\u000b\u0010\u000c\u001a&\u0010\r\u001a\u00020\u0008*\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\nH\u0000ø\u0001\u0000¢\u0006\u0004\u0008\u0011\u0010\u0012\"\u0010\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006\u0013", d2 = {"BoundedRippleExtraRadius", "Landroidx/compose/ui/unit/Dp;", "F", "FadeInDuration", "", "FadeOutDuration", "RadiusDuration", "getRippleStartRadius", "", "size", "Landroidx/compose/ui/geometry/Size;", "getRippleStartRadius-uvyYCjk", "(J)F", "getRippleEndRadius", "Landroidx/compose/ui/unit/Density;", "bounded", "", "getRippleEndRadius-cSwnlzA", "(Landroidx/compose/ui/unit/Density;ZJ)F", "material-ripple_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class RippleAnimationKt {

    private static final float BoundedRippleExtraRadius = 0f;
    private static final int FadeInDuration = 75;
    private static final int FadeOutDuration = 150;
    private static final int RadiusDuration = 225;
    static {
        final int i2 = 0;
        RippleAnimationKt.BoundedRippleExtraRadius = Dp.constructor-impl((float)i);
    }

    public static final float getRippleEndRadius-cSwnlzA(Density $this$getRippleEndRadius_u2dcSwnlzA, boolean bounded, long size) {
        int i;
        float height-impl = Size.getHeight-impl(size);
        distance-impl /= i3;
        if (bounded) {
            px-0680j_4 += i2;
        } else {
            i = i2;
        }
        return i;
    }

    public static final float getRippleStartRadius-uvyYCjk(long size) {
        return f *= i2;
    }
}
