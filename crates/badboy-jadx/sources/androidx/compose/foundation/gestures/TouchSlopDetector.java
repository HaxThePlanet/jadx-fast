package androidx.compose.foundation.gestures;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Offset.Companion;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.input.pointer.PointerInputChange;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\u0008\u0005\n\u0002\u0010\u0002\n\u0002\u0008\u0006\u0008\u0002\u0018\u00002\u00020\u0001B\u0011\u0012\n\u0008\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J#\u0010\n\u001a\u0004\u0018\u00010\u00082\u0006\u0010\u000b\u001a\u00020\u000c2\u0006\u0010\r\u001a\u00020\u000eø\u0001\u0001ø\u0001\u0000¢\u0006\u0002\u0008\u000fJ\u001d\u0010\u0010\u001a\u00020\u00082\u0006\u0010\r\u001a\u00020\u000eH\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\u0008\u0011\u0010\u0012J\u0006\u0010\u0013\u001a\u00020\u0014J\u0014\u0010\u0015\u001a\u00020\u000e*\u00020\u0008ø\u0001\u0000¢\u0006\u0004\u0008\u0016\u0010\u0017J\u0014\u0010\u0018\u001a\u00020\u000e*\u00020\u0008ø\u0001\u0000¢\u0006\u0004\u0008\u0019\u0010\u0017R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006R\u0016\u0010\u0007\u001a\u00020\u0008X\u0082\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\t\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006\u001a", d2 = {"Landroidx/compose/foundation/gestures/TouchSlopDetector;", "", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "(Landroidx/compose/foundation/gestures/Orientation;)V", "getOrientation", "()Landroidx/compose/foundation/gestures/Orientation;", "totalPositionChange", "Landroidx/compose/ui/geometry/Offset;", "J", "addPointerInputChange", "dragEvent", "Landroidx/compose/ui/input/pointer/PointerInputChange;", "touchSlop", "", "addPointerInputChange-GcwITfU", "calculatePostSlopOffset", "calculatePostSlopOffset-tuRUvjQ", "(F)J", "reset", "", "crossAxis", "crossAxis-k-4lQ0M", "(J)F", "mainAxis", "mainAxis-k-4lQ0M", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class TouchSlopDetector {

    private final androidx.compose.foundation.gestures.Orientation orientation;
    private long totalPositionChange;
    public TouchSlopDetector() {
        final int i = 0;
        super(i, 1, i);
    }

    public TouchSlopDetector(androidx.compose.foundation.gestures.Orientation orientation) {
        super();
        this.orientation = orientation;
        this.totalPositionChange = Offset.Companion.getZero-F1C5BW0();
    }

    public TouchSlopDetector(androidx.compose.foundation.gestures.Orientation orientation, int i2, DefaultConstructorMarker defaultConstructorMarker3) {
        int obj1;
        obj1 = i2 &= 1 != 0 ? 0 : obj1;
        super(obj1);
    }

    private final long calculatePostSlopOffset-tuRUvjQ(float touchSlop) {
        long touchSlopOffset;
        long crossAxis-k-4lQ0M;
        long totalPositionChange;
        long horizontal;
        if (this.orientation == null) {
            touchSlopOffset = Offset.minus-MK-Hz9U(this.totalPositionChange, obj3);
        } else {
            mainAxis-k-4lQ0M -= i2;
            crossAxis-k-4lQ0M = crossAxis-k-4lQ0M(this.totalPositionChange);
            if (this.orientation == Orientation.Horizontal) {
                touchSlopOffset = totalPositionChange;
            } else {
                touchSlopOffset = totalPositionChange;
            }
        }
        return touchSlopOffset;
    }

    public final Offset addPointerInputChange-GcwITfU(PointerInputChange dragEvent, float touchSlop) {
        float distance-impl;
        int i;
        Offset box-impl;
        this.totalPositionChange = Offset.plus-MK-Hz9U(this.totalPositionChange, obj7);
        if (this.orientation == null) {
            distance-impl = Offset.getDistance-impl(this.totalPositionChange);
        } else {
            distance-impl = Math.abs(mainAxis-k-4lQ0M(this.totalPositionChange));
        }
        i = Float.compare(distance-impl, touchSlop) >= 0 ? 1 : 0;
        if (i != 0) {
            box-impl = Offset.box-impl(calculatePostSlopOffset-tuRUvjQ(touchSlop));
        } else {
            box-impl = 0;
        }
        return box-impl;
    }

    public final float crossAxis-k-4lQ0M(long $this$crossAxis_u2dk_u2d4lQ0M) {
        float y-impl;
        if (this.orientation == Orientation.Horizontal) {
            y-impl = Offset.getY-impl($this$crossAxis_u2dk_u2d4lQ0M);
        } else {
            y-impl = Offset.getX-impl($this$crossAxis_u2dk_u2d4lQ0M);
        }
        return y-impl;
    }

    public final androidx.compose.foundation.gestures.Orientation getOrientation() {
        return this.orientation;
    }

    public final float mainAxis-k-4lQ0M(long $this$mainAxis_u2dk_u2d4lQ0M) {
        float x-impl;
        if (this.orientation == Orientation.Horizontal) {
            x-impl = Offset.getX-impl($this$mainAxis_u2dk_u2d4lQ0M);
        } else {
            x-impl = Offset.getY-impl($this$mainAxis_u2dk_u2d4lQ0M);
        }
        return x-impl;
    }

    public final void reset() {
        this.totalPositionChange = Offset.Companion.getZero-F1C5BW0();
    }
}
