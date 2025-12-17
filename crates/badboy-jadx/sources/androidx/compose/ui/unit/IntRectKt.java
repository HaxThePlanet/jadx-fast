package androidx.compose.ui.unit;

import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.util.MathHelpersKt;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000.\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0008\n\u0002\u0008\u0006\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u001a\"\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0007ø\u0001\u0000¢\u0006\u0004\u0008\u0005\u0010\u0006\u001a\"\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0008\u001a\u00020\tH\u0007ø\u0001\u0000¢\u0006\u0004\u0008\n\u0010\u0006\u001a\"\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u000c\u001a\u00020\rH\u0007ø\u0001\u0000¢\u0006\u0004\u0008\u000e\u0010\u000f\u001a \u0010\u0010\u001a\u00020\u00012\u0006\u0010\u0011\u001a\u00020\u00012\u0006\u0010\u0012\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u0014H\u0007\u001a\u000c\u0010\u0015\u001a\u00020\u0001*\u00020\u0016H\u0007\u001a\u000c\u0010\u0017\u001a\u00020\u0016*\u00020\u0001H\u0007\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006\u0018", d2 = {"IntRect", "Landroidx/compose/ui/unit/IntRect;", "topLeft", "Landroidx/compose/ui/unit/IntOffset;", "bottomRight", "IntRect-E1MhUcY", "(JJ)Landroidx/compose/ui/unit/IntRect;", "offset", "size", "Landroidx/compose/ui/unit/IntSize;", "IntRect-VbeCjmY", "center", "radius", "", "IntRect-ar5cAso", "(JI)Landroidx/compose/ui/unit/IntRect;", "lerp", "start", "stop", "fraction", "", "roundToIntRect", "Landroidx/compose/ui/geometry/Rect;", "toRect", "ui-unit_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class IntRectKt {
    public static final androidx.compose.ui.unit.IntRect IntRect-E1MhUcY(long topLeft, long bottomRight) {
        IntRect intRect = new IntRect(IntOffset.getX-impl(topLeft), IntOffset.getY-impl(topLeft), IntOffset.getX-impl(obj7), IntOffset.getY-impl(obj7));
        return intRect;
    }

    public static final androidx.compose.ui.unit.IntRect IntRect-VbeCjmY(long offset, long size) {
        IntRect intRect = new IntRect(IntOffset.getX-impl(offset), IntOffset.getY-impl(offset), x-impl2 += width-impl, y-impl2 += height-impl);
        return intRect;
    }

    public static final androidx.compose.ui.unit.IntRect IntRect-ar5cAso(long center, int radius) {
        IntRect intRect = new IntRect(x-impl -= obj7, y-impl -= obj7, x-impl2 += obj7, y-impl2 += obj7);
        return intRect;
    }

    public static final androidx.compose.ui.unit.IntRect lerp(androidx.compose.ui.unit.IntRect start, androidx.compose.ui.unit.IntRect stop, float fraction) {
        IntRect intRect = new IntRect(MathHelpersKt.lerp(start.getLeft(), stop.getLeft(), fraction), MathHelpersKt.lerp(start.getTop(), stop.getTop(), fraction), MathHelpersKt.lerp(start.getRight(), stop.getRight(), fraction), MathHelpersKt.lerp(start.getBottom(), stop.getBottom(), fraction));
        return intRect;
    }

    public static final androidx.compose.ui.unit.IntRect roundToIntRect(Rect $this$roundToIntRect) {
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        final int i4 = 0;
        IntRect intRect = new IntRect(Math.round($this$roundToIntRect.getLeft()), Math.round($this$roundToIntRect.getTop()), Math.round($this$roundToIntRect.getRight()), Math.round($this$roundToIntRect.getBottom()));
        return intRect;
    }

    public static final Rect toRect(androidx.compose.ui.unit.IntRect $this$toRect) {
        Rect rect = new Rect((float)left, (float)top, (float)right, (float)bottom);
        return rect;
    }
}
