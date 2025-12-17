package androidx.compose.foundation.text.selection;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.semantics.SemanticsPropertyKey;
import androidx.compose.ui.text.style.ResolvedTextDirection;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000,\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\u001a\u001a\u0010\u000c\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rH\u0000ø\u0001\u0000¢\u0006\u0004\u0008\u000f\u0010\u0010\u001a\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0012H\u0000\u001a \u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u0012H\u0000\"\u0016\u0010\u0000\u001a\u00020\u0001X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\u0008\u0002\u0010\u0003\"\u0016\u0010\u0005\u001a\u00020\u0001X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\u0008\u0006\u0010\u0003\"\u001a\u0010\u0007\u001a\u0008\u0012\u0004\u0012\u00020\t0\u0008X\u0080\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\n\u0010\u000b\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006\u0019", d2 = {"HandleHeight", "Landroidx/compose/ui/unit/Dp;", "getHandleHeight", "()F", "F", "HandleWidth", "getHandleWidth", "SelectionHandleInfoKey", "Landroidx/compose/ui/semantics/SemanticsPropertyKey;", "Landroidx/compose/foundation/text/selection/SelectionHandleInfo;", "getSelectionHandleInfoKey", "()Landroidx/compose/ui/semantics/SemanticsPropertyKey;", "getAdjustedCoordinates", "Landroidx/compose/ui/geometry/Offset;", "position", "getAdjustedCoordinates-k-4lQ0M", "(J)J", "isHandleLtrDirection", "", "direction", "Landroidx/compose/ui/text/style/ResolvedTextDirection;", "areHandlesCrossed", "isLeftSelectionHandle", "isStartHandle", "handlesCrossed", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class SelectionHandlesKt {

    private static final float HandleHeight;
    private static final float HandleWidth;
    private static final SemanticsPropertyKey<androidx.compose.foundation.text.selection.SelectionHandleInfo> SelectionHandleInfoKey;
    static {
        int i3 = 0;
        SelectionHandlesKt.HandleWidth = Dp.constructor-impl((float)i);
        int i4 = 0;
        SelectionHandlesKt.HandleHeight = Dp.constructor-impl((float)i2);
        int i5 = 0;
        SemanticsPropertyKey semanticsPropertyKey = new SemanticsPropertyKey("SelectionHandleInfo", i5, 2, i5);
        SelectionHandlesKt.SelectionHandleInfoKey = semanticsPropertyKey;
    }

    public static final long getAdjustedCoordinates-k-4lQ0M(long position) {
        return OffsetKt.Offset(Offset.getX-impl(position), y-impl -= i2);
    }

    public static final float getHandleHeight() {
        return SelectionHandlesKt.HandleHeight;
    }

    public static final float getHandleWidth() {
        return SelectionHandlesKt.HandleWidth;
    }

    public static final SemanticsPropertyKey<androidx.compose.foundation.text.selection.SelectionHandleInfo> getSelectionHandleInfoKey() {
        return SelectionHandlesKt.SelectionHandleInfoKey;
    }

    public static final boolean isHandleLtrDirection(ResolvedTextDirection direction, boolean areHandlesCrossed) {
        int i;
        ResolvedTextDirection ltr;
        if (direction == ResolvedTextDirection.Ltr) {
            if (areHandlesCrossed) {
                if (direction == ResolvedTextDirection.Rtl && areHandlesCrossed) {
                    i = areHandlesCrossed ? 1 : 0;
                } else {
                }
            } else {
            }
        } else {
        }
        return i;
    }

    public static final boolean isLeftSelectionHandle(boolean isStartHandle, ResolvedTextDirection direction, boolean handlesCrossed) {
        boolean handleLtrDirection;
        if (isStartHandle) {
            handleLtrDirection = SelectionHandlesKt.isHandleLtrDirection(direction, handlesCrossed);
        } else {
            handleLtrDirection = !SelectionHandlesKt.isHandleLtrDirection(direction, handlesCrossed) ? 1 : 0;
        }
        return handleLtrDirection;
    }
}
