package androidx.compose.foundation.text.selection;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0002\u0008\u000b\u0008\u0080\u0001\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\"\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0008H ø\u0001\u0000¢\u0006\u0004\u0008\t\u0010\nJ*\u0010\u000b\u001a\u00020\u000c2\u0006\u0010\u0007\u001a\u00020\u00082\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u0006H\u0000ø\u0001\u0000¢\u0006\u0004\u0008\u000f\u0010\u0010J\u001e\u0010\u0011\u001a\u00020\u000c*\u00020\u00082\u0006\u0010\u0012\u001a\u00020\u0006H\u0002ø\u0001\u0000¢\u0006\u0004\u0008\u0013\u0010\u0014j\u0002\u0008\u0015j\u0002\u0008\u0016\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006\u0017", d2 = {"Landroidx/compose/foundation/text/selection/SelectionMode;", "", "(Ljava/lang/String;I)V", "compare", "", "position", "Landroidx/compose/ui/geometry/Offset;", "bounds", "Landroidx/compose/ui/geometry/Rect;", "compare-3MmeM6k$foundation_release", "(JLandroidx/compose/ui/geometry/Rect;)I", "isSelected", "", "start", "end", "isSelected-2x9bVx0$foundation_release", "(Landroidx/compose/ui/geometry/Rect;JJ)Z", "containsInclusive", "offset", "containsInclusive-Uv8p0NA", "(Landroidx/compose/ui/geometry/Rect;J)Z", "Vertical", "Horizontal", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public enum SelectionMode {

    Vertical,
    Horizontal;

    @Metadata(d1 = "\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008Æ\u0001\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0010ø\u0001\u0000¢\u0006\u0004\u0008\u0008\u0010\t\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006\n", d2 = {"Landroidx/compose/foundation/text/selection/SelectionMode$Horizontal;", "Landroidx/compose/foundation/text/selection/SelectionMode;", "compare", "", "position", "Landroidx/compose/ui/geometry/Offset;", "bounds", "Landroidx/compose/ui/geometry/Rect;", "compare-3MmeM6k$foundation_release", "(JLandroidx/compose/ui/geometry/Rect;)I", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    static final class Horizontal extends androidx.compose.foundation.text.selection.SelectionMode {
        Horizontal(String $enum$name, int $enum$ordinal) {
            super($enum$name, $enum$ordinal, 0);
        }

        @Override // androidx.compose.foundation.text.selection.SelectionMode
        public int compare-3MmeM6k$foundation_release(long position, Rect bounds) {
            int cmp;
            float right;
            if (SelectionManagerKt.containsInclusive-Uv8p0NA(obj6, position)) {
                return 0;
            }
            int i3 = -1;
            if (Float.compare(x-impl, left) < 0) {
                return i3;
            }
            if (Float.compare(y-impl, right) < 0 && Float.compare(x-impl2, right) < 0) {
                if (Float.compare(x-impl2, right) < 0) {
                    return i3;
                }
            }
            return 1;
        }
    }

    @Metadata(d1 = "\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008Æ\u0001\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0010ø\u0001\u0000¢\u0006\u0004\u0008\u0008\u0010\t\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006\n", d2 = {"Landroidx/compose/foundation/text/selection/SelectionMode$Vertical;", "Landroidx/compose/foundation/text/selection/SelectionMode;", "compare", "", "position", "Landroidx/compose/ui/geometry/Offset;", "bounds", "Landroidx/compose/ui/geometry/Rect;", "compare-3MmeM6k$foundation_release", "(JLandroidx/compose/ui/geometry/Rect;)I", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    static final class Vertical extends androidx.compose.foundation.text.selection.SelectionMode {
        Vertical(String $enum$name, int $enum$ordinal) {
            super($enum$name, $enum$ordinal, 0);
        }

        @Override // androidx.compose.foundation.text.selection.SelectionMode
        public int compare-3MmeM6k$foundation_release(long position, Rect bounds) {
            int cmp;
            float bottom;
            if (SelectionManagerKt.containsInclusive-Uv8p0NA(obj6, position)) {
                return 0;
            }
            int i3 = -1;
            if (Float.compare(y-impl, top) < 0) {
                return i3;
            }
            if (Float.compare(x-impl, bottom) < 0 && Float.compare(y-impl2, bottom) < 0) {
                if (Float.compare(y-impl2, bottom) < 0) {
                    return i3;
                }
            }
            return 1;
        }
    }
    private static final androidx.compose.foundation.text.selection.SelectionMode[] $values() {
        return /* result */;
    }

    private final boolean containsInclusive-Uv8p0NA(Rect $this$containsInclusive_u2dUv8p0NA, long offset) {
        int cmp;
        int i;
        int cmp2;
        float bottom;
        float x-impl;
        int i2;
        x-impl = Offset.getX-impl(offset);
        i2 = 1;
        final int i3 = 0;
        if (Float.compare(left, x-impl) <= 0 && Float.compare(x-impl, bottom) <= 0) {
            i = Float.compare(x-impl, bottom) <= 0 ? i2 : i3;
        } else {
        }
        if (i != 0) {
            x-impl = Offset.getY-impl(offset);
            if (Float.compare(top, x-impl) <= 0 && Float.compare(x-impl, bottom) <= 0) {
                i = Float.compare(x-impl, bottom) <= 0 ? i2 : i3;
            } else {
            }
            if (i != 0) {
            } else {
                i2 = i3;
            }
        } else {
        }
        return i2;
    }

    @Override // java.lang.Enum
    public abstract int compare-3MmeM6k$foundation_release(long l, Rect rect2);

    @Override // java.lang.Enum
    public final boolean isSelected-2x9bVx0$foundation_release(Rect bounds, long start, long end) {
        boolean inclusive-Uv8p0NA;
        int i2;
        int i;
        i2 = 1;
        if (!containsInclusive-Uv8p0NA(bounds, start)) {
            if (containsInclusive-Uv8p0NA(bounds, obj9)) {
            } else {
                final int i4 = 0;
                i = compare-3MmeM6k$foundation_release(start, end) > 0 ? i2 : i4;
                if (compare-3MmeM6k$foundation_release(obj9, obj10) > 0) {
                } else {
                    i2 = i4;
                }
            }
            return i2 ^= i;
        }
        return i2;
    }
}
