package androidx.compose.foundation.text.selection;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.MultiParagraph;
import androidx.compose.ui.text.TextLayoutInput;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.unit.IntSize;
import java.util.Comparator;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000R\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u000b\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\t\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u001a\"\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0002ø\u0001\u0000¢\u0006\u0004\u0008\u0006\u0010\u0007\u001a\"\u0010\u0008\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH\u0002ø\u0001\u0000¢\u0006\u0004\u0008\u000c\u0010\r\u001a\"\u0010\u000e\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH\u0002ø\u0001\u0000¢\u0006\u0004\u0008\u000f\u0010\r\u001a\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\tH\u0002\u001a6\u0010\u0014\u001a\u00020\u0015*\u00020\u00162\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u001aH\u0000ø\u0001\u0000¢\u0006\u0004\u0008\u001b\u0010\u001c\u001a\u001c\u0010\u001d\u001a\u00020\t*\u00020\u00162\u0006\u0010\u001e\u001a\u00020\u001a2\u0006\u0010\u001f\u001a\u00020\u001aH\u0002\u001a4\u0010 \u001a\u00020\u0001*\u00020!2\u0016\u0010\"\u001a\u0012\u0012\u0004\u0012\u00020\u001a0#j\u0008\u0012\u0004\u0012\u00020\u001a`$2\u0006\u0010\u001f\u001a\u00020\u001a2\u0006\u0010%\u001a\u00020\u0001H\u0002\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006&", d2 = {"getOffsetForPosition", "", "position", "Landroidx/compose/ui/geometry/Offset;", "textLayoutResult", "Landroidx/compose/ui/text/TextLayoutResult;", "getOffsetForPosition-3MmeM6k", "(JLandroidx/compose/ui/text/TextLayoutResult;)I", "getXDirection", "Landroidx/compose/foundation/text/selection/Direction;", "bounds", "Landroidx/compose/ui/geometry/Rect;", "getXDirection-3MmeM6k", "(JLandroidx/compose/ui/geometry/Rect;)Landroidx/compose/foundation/text/selection/Direction;", "getYDirection", "getYDirection-3MmeM6k", "isSelected", "", "currentDirection", "otherDirection", "appendSelectableInfo", "", "Landroidx/compose/foundation/text/selection/SelectionLayoutBuilder;", "localPosition", "previousHandlePosition", "selectableId", "", "appendSelectableInfo-Parwq6A", "(Landroidx/compose/foundation/text/selection/SelectionLayoutBuilder;Landroidx/compose/ui/text/TextLayoutResult;JJJ)V", "getDirectionById", "anchorSelectableId", "currentSelectableId", "getPreviousAdjustedOffset", "Landroidx/compose/foundation/text/selection/Selection$AnchorInfo;", "selectableIdOrderingComparator", "Ljava/util/Comparator;", "Lkotlin/Comparator;", "currentTextLength", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class MultiWidgetSelectionDelegateKt {
    public static final void appendSelectableInfo-Parwq6A(androidx.compose.foundation.text.selection.SelectionLayoutBuilder $this$appendSelectableInfo_u2dParwq6A, TextLayoutResult textLayoutResult, long localPosition, long previousHandlePosition, long selectableId) {
        androidx.compose.foundation.text.selection.Direction currentXDirection;
        int currentYDirection;
        int offsetForPosition-3MmeM6k;
        androidx.compose.foundation.text.selection.Direction yDirection-3MmeM6k;
        androidx.compose.foundation.text.selection.Direction previousAdjustedOffset;
        Object previousSelection;
        int start;
        androidx.compose.foundation.text.selection.SelectionLayoutBuilder startYHandleDirection;
        int i;
        androidx.compose.foundation.text.selection.Direction direction2;
        androidx.compose.foundation.text.selection.Direction otherDirection;
        androidx.compose.foundation.text.selection.Direction direction4;
        int rawStartHandleOffset;
        androidx.compose.foundation.text.selection.Direction direction5;
        androidx.compose.foundation.text.selection.Direction direction3;
        int selectableIdOrderingComparator;
        int i2;
        Object obj2;
        androidx.compose.foundation.text.selection.Direction endYHandleDirection;
        androidx.compose.foundation.text.selection.Direction direction;
        androidx.compose.foundation.text.selection.Direction startXHandleDirection;
        androidx.compose.foundation.text.selection.Direction currentYDirection2;
        final TextLayoutResult textLayoutResult2 = textLayoutResult;
        Object obj = localPosition;
        int i3 = 0;
        Rect rect = new Rect(i3, i3, (float)width-impl, (float)height-impl);
        final Rect rect2 = rect;
        androidx.compose.foundation.text.selection.Direction xDirection-3MmeM6k = MultiWidgetSelectionDelegateKt.getXDirection-3MmeM6k(obj, obj12);
        yDirection-3MmeM6k = MultiWidgetSelectionDelegateKt.getYDirection-3MmeM6k(obj, obj12);
        int i6 = 0;
        int i8 = 0;
        int i9 = 0;
        int i10 = 0;
        int i11 = 0;
        start = 0;
        if ($this$appendSelectableInfo_u2dParwq6A.isStartHandle()) {
            androidx.compose.foundation.text.selection.Selection previousSelection2 = $this$appendSelectableInfo_u2dParwq6A.getPreviousSelection();
            if (previousSelection2 != null) {
                start = previousSelection2.getEnd();
            }
            androidx.compose.foundation.text.selection.Direction appendSelectableInfo_Parwq6A$otherDirection = MultiWidgetSelectionDelegateKt.appendSelectableInfo_Parwq6A$otherDirection(xDirection-3MmeM6k, yDirection-3MmeM6k, $this$appendSelectableInfo_u2dParwq6A, obj24, obj4);
            previousAdjustedOffset = xDirection-3MmeM6k;
            direction = xDirection-3MmeM6k;
            currentXDirection = yDirection-3MmeM6k;
            direction5 = direction2;
            endYHandleDirection = appendSelectableInfo_Parwq6A$otherDirection;
            direction3 = direction4;
            otherDirection = direction9;
            startYHandleDirection = obj24;
        } else {
            androidx.compose.foundation.text.selection.Selection previousSelection3 = $this$appendSelectableInfo_u2dParwq6A.getPreviousSelection();
            if (previousSelection3 != null) {
                start = previousSelection3.getStart();
            }
            otherDirection = MultiWidgetSelectionDelegateKt.appendSelectableInfo_Parwq6A$otherDirection(xDirection-3MmeM6k, yDirection-3MmeM6k, $this$appendSelectableInfo_u2dParwq6A, obj24, obj4);
            previousAdjustedOffset = otherDirection;
            yDirection-3MmeM6k = otherDirection;
            endYHandleDirection = otherDirection;
            direction3 = direction11;
            direction5 = direction4;
        }
        if (!MultiWidgetSelectionDelegateKt.isSelected(SelectionLayoutKt.resolve2dDirection(direction, currentXDirection), endYHandleDirection)) {
        }
        int length = textLayoutResult2.getLayoutInput().getText().length();
        int i7 = 0;
        selectableIdOrderingComparator = 0;
        if ($this$appendSelectableInfo_u2dParwq6A.isStartHandle()) {
            int rawStartHandleOffset3 = MultiWidgetSelectionDelegateKt.getOffsetForPosition-3MmeM6k(obj, obj12);
            androidx.compose.foundation.text.selection.Selection previousSelection4 = $this$appendSelectableInfo_u2dParwq6A.getPreviousSelection();
            if (previousSelection4 != null) {
                currentYDirection2 = currentXDirection;
                currentXDirection = previousSelection4.getEnd();
                if (currentXDirection != null) {
                    startXHandleDirection = previousAdjustedOffset;
                    currentYDirection = MultiWidgetSelectionDelegateKt.getPreviousAdjustedOffset(currentXDirection, $this$appendSelectableInfo_u2dParwq6A.getSelectableIdOrderingComparator(), startYHandleDirection, direction2);
                } else {
                    startXHandleDirection = previousAdjustedOffset;
                    currentYDirection = rawStartHandleOffset3;
                }
            } else {
                currentYDirection2 = currentXDirection;
                startXHandleDirection = previousAdjustedOffset;
            }
            i = rawStartHandleOffset3;
            rawStartHandleOffset = currentYDirection;
        } else {
            currentYDirection2 = currentXDirection;
            startXHandleDirection = previousAdjustedOffset;
            currentYDirection = MultiWidgetSelectionDelegateKt.getOffsetForPosition-3MmeM6k(obj, obj12);
            previousSelection = $this$appendSelectableInfo_u2dParwq6A.getPreviousSelection();
            previousSelection = previousSelection.getStart();
            if (previousSelection != null && previousSelection != null) {
                previousSelection = previousSelection.getStart();
                if (previousSelection != null) {
                    previousAdjustedOffset = MultiWidgetSelectionDelegateKt.getPreviousAdjustedOffset(previousSelection, $this$appendSelectableInfo_u2dParwq6A.getSelectableIdOrderingComparator(), startYHandleDirection, direction2);
                } else {
                    previousAdjustedOffset = currentYDirection;
                }
            } else {
            }
            i = rawStartHandleOffset2;
            rawStartHandleOffset = currentYDirection;
        }
        if (OffsetKt.isUnspecified-k-4lQ0M(selectableId)) {
            obj2 = selectableId;
            i2 = offsetForPosition-3MmeM6k;
        } else {
            i2 = offsetForPosition-3MmeM6k;
        }
        int startXHandleDirection2 = length;
        $this$appendSelectableInfo_u2dParwq6A.appendInfo(obj24, previousAdjustedOffset, i, startXHandleDirection, otherDirection, rawStartHandleOffset, direction5, direction3, i2);
    }

    private static final androidx.compose.foundation.text.selection.Direction appendSelectableInfo_Parwq6A$otherDirection(androidx.compose.foundation.text.selection.Direction currentXDirection, androidx.compose.foundation.text.selection.Direction currentYDirection, androidx.compose.foundation.text.selection.SelectionLayoutBuilder $this_appendSelectableInfo, long $selectableId, androidx.compose.foundation.text.selection.Selection.AnchorInfo anchor) {
        androidx.compose.foundation.text.selection.Direction it;
        int i;
        long selectableId;
        i = 0;
        if (obj9 != null && MultiWidgetSelectionDelegateKt.getDirectionById($this_appendSelectableInfo, obj9.getSelectableId(), obj3) != null) {
            i = 0;
            if (MultiWidgetSelectionDelegateKt.getDirectionById($this_appendSelectableInfo, obj9.getSelectableId(), obj3) != null) {
            } else {
                it = SelectionLayoutKt.resolve2dDirection(currentXDirection, currentYDirection);
            }
        } else {
        }
        return it;
    }

    private static final androidx.compose.foundation.text.selection.Direction getDirectionById(androidx.compose.foundation.text.selection.SelectionLayoutBuilder $this$getDirectionById, long anchorSelectableId, long currentSelectableId) {
        androidx.compose.foundation.text.selection.Direction bEFORE;
        int compare = $this$getDirectionById.getSelectableIdOrderingComparator().compare(Long.valueOf(anchorSelectableId), Long.valueOf(obj6));
        bEFORE = compare < 0 ? Direction.BEFORE : compare > 0 ? Direction.AFTER : Direction.ON;
        return bEFORE;
    }

    private static final int getOffsetForPosition-3MmeM6k(long position, TextLayoutResult textLayoutResult) {
        int offsetForPosition-k-4lQ0M;
        int height;
        if (Float.compare(y-impl, height) <= 0) {
            offsetForPosition-k-4lQ0M = 0;
        } else {
            if (Float.compare(y-impl2, height) >= 0) {
                offsetForPosition-k-4lQ0M = obj4.getLayoutInput().getText().length();
            } else {
                offsetForPosition-k-4lQ0M = obj4.getOffsetForPosition-k-4lQ0M(position);
            }
        }
        return offsetForPosition-k-4lQ0M;
    }

    private static final int getPreviousAdjustedOffset(androidx.compose.foundation.text.selection.Selection.AnchorInfo $this$getPreviousAdjustedOffset, Comparator<Long> selectableIdOrderingComparator, long currentSelectableId, int currentTextLength) {
        int offset;
        int compare = selectableIdOrderingComparator.compare(Long.valueOf($this$getPreviousAdjustedOffset.getSelectableId()), Long.valueOf(currentSelectableId));
        if (compare < 0) {
            offset = 0;
        } else {
            if (compare > 0) {
                offset = obj6;
            } else {
                offset = $this$getPreviousAdjustedOffset.getOffset();
            }
        }
        return offset;
    }

    private static final androidx.compose.foundation.text.selection.Direction getXDirection-3MmeM6k(long position, Rect bounds) {
        androidx.compose.foundation.text.selection.Direction bEFORE;
        float right;
        bEFORE = Float.compare(x-impl, right) < 0 ? Direction.BEFORE : cmp2 > 0 ? Direction.AFTER : Direction.ON;
        return bEFORE;
    }

    private static final androidx.compose.foundation.text.selection.Direction getYDirection-3MmeM6k(long position, Rect bounds) {
        androidx.compose.foundation.text.selection.Direction bEFORE;
        float bottom;
        bEFORE = Float.compare(y-impl, bottom) < 0 ? Direction.BEFORE : cmp2 > 0 ? Direction.AFTER : Direction.ON;
        return bEFORE;
    }

    private static final boolean isSelected(androidx.compose.foundation.text.selection.Direction currentDirection, androidx.compose.foundation.text.selection.Direction otherDirection) {
        int i;
        if (currentDirection != Direction.ON) {
            if (currentDirection != otherDirection) {
                i = 1;
            } else {
                i = 0;
            }
        } else {
        }
        return i;
    }
}
