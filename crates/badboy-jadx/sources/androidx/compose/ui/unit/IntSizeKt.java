package androidx.compose.ui.unit;

import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000&\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\u0007\u001a\u001d\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0008\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0007¢\u0006\u0002\u0010\u000b\u001a\u0016\u0010\u000c\u001a\u00020\u0002*\u00020\rH\u0007ø\u0001\u0000¢\u0006\u0004\u0008\u000e\u0010\u0006\u001a\u001f\u0010\u000f\u001a\u00020\u0002*\u00020\t2\u0006\u0010\u0010\u001a\u00020\u0002H\u0087\nø\u0001\u0000¢\u0006\u0004\u0008\u0011\u0010\u0012\u001a\u0016\u0010\u0013\u001a\u00020\u0014*\u00020\u0002H\u0007ø\u0001\u0000¢\u0006\u0004\u0008\u0015\u0010\u0016\u001a\u0016\u0010\u0017\u001a\u00020\u0002*\u00020\rH\u0007ø\u0001\u0000¢\u0006\u0004\u0008\u0018\u0010\u0006\u001a\u0016\u0010\u0019\u001a\u00020\r*\u00020\u0002H\u0007ø\u0001\u0000¢\u0006\u0004\u0008\u001a\u0010\u0006\"\u001e\u0010\u0000\u001a\u00020\u0001*\u00020\u00028FX\u0087\u0004¢\u0006\u000c\u0012\u0004\u0008\u0003\u0010\u0004\u001a\u0004\u0008\u0005\u0010\u0006\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006\u001b", d2 = {"center", "Landroidx/compose/ui/unit/IntOffset;", "Landroidx/compose/ui/unit/IntSize;", "getCenter-ozmzZPI$annotations", "(J)V", "getCenter-ozmzZPI", "(J)J", "IntSize", "width", "", "height", "(II)J", "roundToIntSize", "Landroidx/compose/ui/geometry/Size;", "roundToIntSize-uvyYCjk", "times", "size", "times-O0kMr_c", "(IJ)J", "toIntRect", "Landroidx/compose/ui/unit/IntRect;", "toIntRect-ozmzZPI", "(J)Landroidx/compose/ui/unit/IntRect;", "toIntSize", "toIntSize-uvyYCjk", "toSize", "toSize-ozmzZPI", "ui-unit_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class IntSizeKt {
    public static final long IntSize(int width, int height) {
        int i = 0;
        l <<= i3;
        return IntSize.constructor-impl(i2 | i4);
    }

    public static final long getCenter-ozmzZPI(long $this$center) {
        int i = 33;
        int i5 = 32;
        i3 <<= i5;
        return IntOffset.constructor-impl(i4 | i8);
    }

    public static void getCenter-ozmzZPI$annotations(long l) {
    }

    public static final long roundToIntSize-uvyYCjk(long $this$roundToIntSize_u2duvyYCjk) {
        int i = 0;
        int i2 = 0;
        int $this$fastRoundToInt$iv2 = Math.round(Size.getHeight-impl($this$roundToIntSize_u2duvyYCjk));
        int i3 = 0;
        return IntSize.constructor-impl(i4 | i6);
    }

    public static final long times-O0kMr_c(int $this$times_u2dO0kMr_c, long size) {
        final int i = 0;
        return IntSize.times-YEO4UFw(size, obj5);
    }

    public static final androidx.compose.ui.unit.IntRect toIntRect-ozmzZPI(long $this$toIntRect_u2dozmzZPI) {
        return IntRectKt.IntRect-VbeCjmY(IntOffset.Companion.getZero-nOcc-ac(), obj1);
    }

    public static final long toIntSize-uvyYCjk(long $this$toIntSize_u2duvyYCjk) {
        int i2 = (int)height-impl;
        final int i3 = 0;
        return IntSize.constructor-impl(i4 | i6);
    }

    public static final long toSize-ozmzZPI(long $this$toSize_u2dozmzZPI) {
        return SizeKt.Size((float)width-impl, (float)height-impl);
    }
}
