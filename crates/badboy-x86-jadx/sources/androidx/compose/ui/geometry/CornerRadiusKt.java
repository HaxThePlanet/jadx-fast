package androidx.compose.ui.geometry;

import androidx.compose.ui.util.MathHelpersKt;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\u0008\t\u001a\u001f\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u0003H\u0007¢\u0006\u0002\u0010\u0005\u001a*\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\u00012\u0006\u0010\u0008\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\u0003H\u0007ø\u0001\u0000¢\u0006\u0004\u0008\n\u0010\u000b\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006\u000c", d2 = {"CornerRadius", "Landroidx/compose/ui/geometry/CornerRadius;", "x", "", "y", "(FF)J", "lerp", "start", "stop", "fraction", "lerp-3Ry4LBc", "(JJF)J", "ui-geometry_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class CornerRadiusKt {
    public static final long CornerRadius(float x, float y) {
        int i = 0;
        long l = (long)floatToRawIntBits;
        return CornerRadius.constructor-impl(i3 | i4);
    }

    public static long CornerRadius$default(float f, float f2, int i3, Object object4) {
        float obj1;
        if (i3 &= 2 != 0) {
            obj1 = f;
        }
        return CornerRadiusKt.CornerRadius(f, obj1);
    }

    public static final long lerp-3Ry4LBc(long start, long stop, float fraction) {
        return CornerRadiusKt.CornerRadius(MathHelpersKt.lerp(CornerRadius.getX-impl(start), CornerRadius.getX-impl(fraction), obj7), MathHelpersKt.lerp(CornerRadius.getY-impl(start), CornerRadius.getY-impl(fraction), obj7));
    }
}
