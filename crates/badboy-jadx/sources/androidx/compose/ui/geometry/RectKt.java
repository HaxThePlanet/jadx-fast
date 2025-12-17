package androidx.compose.ui.geometry;

import androidx.compose.ui.util.MathHelpersKt;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0007\n\u0002\u0008\u0007\u001a\"\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0007ø\u0001\u0000¢\u0006\u0004\u0008\u0005\u0010\u0006\u001a\"\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0008\u001a\u00020\tH\u0007ø\u0001\u0000¢\u0006\u0004\u0008\n\u0010\u0006\u001a\"\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u000c\u001a\u00020\rH\u0007ø\u0001\u0000¢\u0006\u0004\u0008\u000e\u0010\u000f\u001a \u0010\u0010\u001a\u00020\u00012\u0006\u0010\u0011\u001a\u00020\u00012\u0006\u0010\u0012\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\rH\u0007\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006\u0014", d2 = {"Rect", "Landroidx/compose/ui/geometry/Rect;", "topLeft", "Landroidx/compose/ui/geometry/Offset;", "bottomRight", "Rect-0a9Yr6o", "(JJ)Landroidx/compose/ui/geometry/Rect;", "offset", "size", "Landroidx/compose/ui/geometry/Size;", "Rect-tz77jQw", "center", "radius", "", "Rect-3MmeM6k", "(JF)Landroidx/compose/ui/geometry/Rect;", "lerp", "start", "stop", "fraction", "ui-geometry_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class RectKt {
    public static final androidx.compose.ui.geometry.Rect Rect-0a9Yr6o(long topLeft, long bottomRight) {
        Rect rect = new Rect(Offset.getX-impl(topLeft), Offset.getY-impl(topLeft), Offset.getX-impl(obj7), Offset.getY-impl(obj7));
        return rect;
    }

    public static final androidx.compose.ui.geometry.Rect Rect-3MmeM6k(long center, float radius) {
        Rect rect = new Rect(x-impl -= obj7, y-impl -= obj7, x-impl2 += obj7, y-impl2 += obj7);
        return rect;
    }

    public static final androidx.compose.ui.geometry.Rect Rect-tz77jQw(long offset, long size) {
        Rect rect = new Rect(Offset.getX-impl(offset), Offset.getY-impl(offset), x-impl2 += width-impl, y-impl2 += height-impl);
        return rect;
    }

    public static final androidx.compose.ui.geometry.Rect lerp(androidx.compose.ui.geometry.Rect start, androidx.compose.ui.geometry.Rect stop, float fraction) {
        Rect rect = new Rect(MathHelpersKt.lerp(start.getLeft(), stop.getLeft(), fraction), MathHelpersKt.lerp(start.getTop(), stop.getTop(), fraction), MathHelpersKt.lerp(start.getRight(), stop.getRight(), fraction), MathHelpersKt.lerp(start.getBottom(), stop.getBottom(), fraction));
        return rect;
    }
}
