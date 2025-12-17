package androidx.compose.foundation.text.input.internal;

import androidx.compose.foundation.text.selection.SelectionManagerKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\"\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\t\u001a#\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u000c\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u00020\u00010\u0004H\u0080\u0008\u001a\u001e\u0010\u0005\u001a\u00020\u0006*\u00020\u00072\u0006\u0010\u0008\u001a\u00020\tH\u0002ø\u0001\u0000¢\u0006\u0004\u0008\n\u0010\u000b\u001a&\u0010\u000c\u001a\u00020\u0001*\u00020\u00072\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\tH\u0000ø\u0001\u0000¢\u0006\u0004\u0008\u000f\u0010\u0010\u001a#\u0010\u0011\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u000c\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u00020\u00010\u0004H\u0080\u0008\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006\u0012", d2 = {"addExactOrElse", "", "right", "defaultValue", "Lkotlin/Function0;", "distanceSquaredToClosestCornerFromOutside", "", "Landroidx/compose/ui/geometry/Offset;", "rect", "Landroidx/compose/ui/geometry/Rect;", "distanceSquaredToClosestCornerFromOutside-3MmeM6k", "(JLandroidx/compose/ui/geometry/Rect;)F", "findClosestRect", "rect1", "rect2", "findClosestRect-9KIMszo", "(JLandroidx/compose/ui/geometry/Rect;Landroidx/compose/ui/geometry/Rect;)I", "subtractExactOrElse", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class MathUtilsKt {
    public static final int addExactOrElse(int $this$addExactOrElse, int right, Function0<Integer> defaultValue) {
        int intValue;
        final int i = 0;
        final int i2 = $this$addExactOrElse + right;
        if (i3 &= i5 < 0) {
            intValue = (Number)defaultValue.invoke().intValue();
        } else {
            intValue = i2;
        }
        return intValue;
    }

    private static final float distanceSquaredToClosestCornerFromOutside-3MmeM6k(long $this$distanceSquaredToClosestCornerFromOutside_u2d3MmeM6k, Rect rect) {
        int distance;
        if (SelectionManagerKt.containsInclusive-Uv8p0NA(obj6, $this$distanceSquaredToClosestCornerFromOutside_u2d3MmeM6k)) {
            return 0;
        }
        int i = 0;
        float distanceSquared-impl = Offset.getDistanceSquared-impl(Offset.minus-MK-Hz9U(obj6.getTopLeft-F1C5BW0(), obj2));
        int i3 = 0;
        if (Float.compare(distanceSquared-impl, distance) < 0) {
            distance = distanceSquared-impl;
        }
        float distanceSquared-impl2 = Offset.getDistanceSquared-impl(Offset.minus-MK-Hz9U(obj6.getTopRight-F1C5BW0(), i3));
        int i4 = 0;
        if (Float.compare(distanceSquared-impl2, distance) < 0) {
            distance = distanceSquared-impl2;
        }
        float distanceSquared-impl3 = Offset.getDistanceSquared-impl(Offset.minus-MK-Hz9U(obj6.getBottomLeft-F1C5BW0(), i4));
        int i5 = 0;
        if (Float.compare(distanceSquared-impl3, distance) < 0) {
            distance = distanceSquared-impl3;
        }
        float distanceSquared-impl4 = Offset.getDistanceSquared-impl(Offset.minus-MK-Hz9U(obj6.getBottomRight-F1C5BW0(), i5));
        int i6 = 0;
        if (Float.compare(distanceSquared-impl4, distance) < 0) {
            distance = distanceSquared-impl4;
        }
        return distance;
    }

    public static final int findClosestRect-9KIMszo(long $this$findClosestRect_u2d9KIMszo, Rect rect1, Rect rect2) {
        int i2;
        int i;
        final float distanceSquaredToClosestCornerFromOutside-3MmeM6k = MathUtilsKt.distanceSquaredToClosestCornerFromOutside-3MmeM6k($this$findClosestRect_u2d9KIMszo, rect1);
        final float distanceSquaredToClosestCornerFromOutside-3MmeM6k2 = MathUtilsKt.distanceSquaredToClosestCornerFromOutside-3MmeM6k($this$findClosestRect_u2d9KIMszo, rect1);
        final int i3 = 0;
        i2 = Float.compare(distanceSquaredToClosestCornerFromOutside-3MmeM6k, distanceSquaredToClosestCornerFromOutside-3MmeM6k2) == 0 ? i : i3;
        if (i2 != 0) {
            return i3;
        }
        if (Float.compare(distanceSquaredToClosestCornerFromOutside-3MmeM6k, distanceSquaredToClosestCornerFromOutside-3MmeM6k2) < 0) {
            i = -1;
        }
        return i;
    }

    public static final int subtractExactOrElse(int $this$subtractExactOrElse, int right, Function0<Integer> defaultValue) {
        int intValue;
        final int i = 0;
        final int i2 = $this$subtractExactOrElse - right;
        if (i3 &= i5 < 0) {
            intValue = (Number)defaultValue.invoke().intValue();
        } else {
            intValue = i2;
        }
        return intValue;
    }
}
