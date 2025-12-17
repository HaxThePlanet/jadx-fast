package androidx.compose.foundation.text.selection;

import androidx.compose.foundation.text.Handle;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Offset.Companion;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.RectKt;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSize.Companion;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000F\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u000b\n\u0002\u0008\u0007\u001a\"\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0000ø\u0001\u0000¢\u0006\u0004\u0008\u0008\u0010\t\u001a*\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u000cH\u0002ø\u0001\u0000¢\u0006\u0004\u0008\r\u0010\u000e\u001a*\u0010\u000f\u001a\u00020\u00012\u0018\u0010\u0010\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00140\u00120\u00112\u0006\u0010\u0015\u001a\u00020\u0016H\u0001\u001a\u001e\u0010\u0017\u001a\u0004\u0018\u00010\u00142\u0008\u0010\u0018\u001a\u0004\u0018\u00010\u00142\u0008\u0010\u0019\u001a\u0004\u0018\u00010\u0014H\u0000\u001a\u001e\u0010\u001a\u001a\u00020\u001b*\u00020\u00012\u0006\u0010\u001c\u001a\u00020\u0003H\u0000ø\u0001\u0000¢\u0006\u0004\u0008\u001d\u0010\u001e\u001a\u001e\u0010\u001f\u001a\u0008\u0012\u0004\u0012\u0002H 0\u0011\"\u0004\u0008\u0000\u0010 *\u0008\u0012\u0004\u0012\u0002H 0\u0011H\u0002\u001a\u000c\u0010!\u001a\u00020\u0001*\u00020\u0016H\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006\"", d2 = {"invertedInfiniteRect", "Landroidx/compose/ui/geometry/Rect;", "calculateSelectionMagnifierCenterAndroid", "Landroidx/compose/ui/geometry/Offset;", "manager", "Landroidx/compose/foundation/text/selection/SelectionManager;", "magnifierSize", "Landroidx/compose/ui/unit/IntSize;", "calculateSelectionMagnifierCenterAndroid-O0kMr_c", "(Landroidx/compose/foundation/text/selection/SelectionManager;J)J", "getMagnifierCenter", "anchor", "Landroidx/compose/foundation/text/selection/Selection$AnchorInfo;", "getMagnifierCenter-JVtK1S4", "(Landroidx/compose/foundation/text/selection/SelectionManager;JLandroidx/compose/foundation/text/selection/Selection$AnchorInfo;)J", "getSelectedRegionRect", "selectableSubSelectionPairs", "", "Lkotlin/Pair;", "Landroidx/compose/foundation/text/selection/Selectable;", "Landroidx/compose/foundation/text/selection/Selection;", "containerCoordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "merge", "lhs", "rhs", "containsInclusive", "", "offset", "containsInclusive-Uv8p0NA", "(Landroidx/compose/ui/geometry/Rect;J)Z", "firstAndLast", "T", "visibleBounds", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class SelectionManagerKt {

    private static final Rect invertedInfiniteRect;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public class WhenMappings {

        public static final int[] $EnumSwitchMapping$0;
        static {
            int ordinal;
            int ordinal2;
            int ordinal3;
            int[] iArr = new int[values.length];
            iArr[Handle.SelectionStart.ordinal()] = 1;
            iArr[Handle.SelectionEnd.ordinal()] = 2;
            iArr[Handle.Cursor.ordinal()] = 3;
            SelectionManagerKt.WhenMappings.$EnumSwitchMapping$0 = iArr;
        }
    }
    static {
        final int i = 2139095040;
        final int i2 = -8388608;
        Rect rect = new Rect(i, i, i2, i2);
        SelectionManagerKt.invertedInfiniteRect = rect;
    }

    public static final List access$firstAndLast(List $receiver) {
        return SelectionManagerKt.firstAndLast($receiver);
    }

    public static final Rect access$getInvertedInfiniteRect$p() {
        return SelectionManagerKt.invertedInfiniteRect;
    }

    public static final long calculateSelectionMagnifierCenterAndroid-O0kMr_c(androidx.compose.foundation.text.selection.SelectionManager manager, long magnifierSize) {
        int i;
        long magnifierCenter-JVtK1S4;
        int[] $EnumSwitchMapping$0;
        androidx.compose.foundation.text.selection.Selection selection2 = manager.getSelection();
        if (selection2 == null) {
            return Offset.Companion.getUnspecified-F1C5BW0();
        }
        Handle draggingHandle = manager.getDraggingHandle();
        if (draggingHandle == null) {
            i = -1;
        } else {
            i = SelectionManagerKt.WhenMappings.$EnumSwitchMapping$0[draggingHandle.ordinal()];
        }
        switch (i) {
            case -1:
                return Offset.Companion.getUnspecified-F1C5BW0();
            case 0:
                NoWhenBranchMatchedException noWhenBranchMatchedException = new NoWhenBranchMatchedException();
                throw noWhenBranchMatchedException;
            case 1:
                magnifierCenter-JVtK1S4 = SelectionManagerKt.getMagnifierCenter-JVtK1S4(manager, magnifierSize, obj5);
                break;
            case 2:
                magnifierCenter-JVtK1S4 = SelectionManagerKt.getMagnifierCenter-JVtK1S4(manager, magnifierSize, obj5);
                break;
            default:
                IllegalStateException illegalStateException = new IllegalStateException("SelectionContainer does not support cursor".toString());
                throw illegalStateException;
        }
        return magnifierCenter-JVtK1S4;
    }

    public static final boolean containsInclusive-Uv8p0NA(Rect $this$containsInclusive_u2dUv8p0NA, long offset) {
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

    private static final <T> List<T> firstAndLast(List<? extends T> $this$firstAndLast) {
        List listOf;
        Object last;
        if (/* condition */) {
            listOf = $this$firstAndLast;
        } else {
            listOf = CollectionsKt.listOf(/* result */);
        }
        return listOf;
    }

    private static final long getMagnifierCenter-JVtK1S4(androidx.compose.foundation.text.selection.SelectionManager manager, long magnifierSize, androidx.compose.foundation.text.selection.Selection.AnchorInfo anchor) {
        float lineStartX;
        boolean cmp;
        float lineRight;
        int i3;
        float f2;
        int i;
        float f;
        int i2;
        float coerceIn;
        Object obj = manager;
        final androidx.compose.foundation.text.selection.Selection.AnchorInfo anchorInfo = obj21;
        androidx.compose.foundation.text.selection.Selectable anchorSelectable$foundation_release = obj.getAnchorSelectable$foundation_release(anchorInfo);
        if (anchorSelectable$foundation_release == null) {
            return Offset.Companion.getUnspecified-F1C5BW0();
        }
        LayoutCoordinates containerLayoutCoordinates = obj.getContainerLayoutCoordinates();
        if (containerLayoutCoordinates == null) {
            return Offset.Companion.getUnspecified-F1C5BW0();
        }
        LayoutCoordinates layoutCoordinates = anchorSelectable$foundation_release.getLayoutCoordinates();
        if (layoutCoordinates == null) {
            return Offset.Companion.getUnspecified-F1C5BW0();
        }
        final int offset = anchorInfo.getOffset();
        if (offset > anchorSelectable$foundation_release.getLastVisibleOffset()) {
            return Offset.Companion.getUnspecified-F1C5BW0();
        }
        Offset currentDragPosition-_m7T9-E = obj.getCurrentDragPosition-_m7T9-E();
        Intrinsics.checkNotNull(currentDragPosition-_m7T9-E);
        final float x-impl = Offset.getX-impl(layoutCoordinates.localPositionOf-R5De75A(containerLayoutCoordinates, currentDragPosition-_m7T9-E.unbox-impl()));
        final long rangeOfLineContaining--jx7JFs = anchorSelectable$foundation_release.getRangeOfLineContaining--jx7JFs(offset);
        int i4 = 1;
        if (TextRange.getCollapsed-impl(rangeOfLineContaining--jx7JFs)) {
            lineStartX = anchorSelectable$foundation_release.getLineLeft(offset);
        } else {
            float lineLeft = anchorSelectable$foundation_release.getLineLeft(TextRange.getStart-impl(rangeOfLineContaining--jx7JFs));
            lineRight = anchorSelectable$foundation_release.getLineRight(end-impl -= i4);
            lineStartX = coerceIn;
        }
        i3 = -1082130432;
        i = Float.compare(lineStartX, i3) == 0 ? i4 : i2;
        if (i != 0) {
            return Offset.Companion.getUnspecified-F1C5BW0();
        }
        IntSize.Companion companion8 = IntSize.Companion;
        Object obj2 = magnifierSize;
        if (!IntSize.equals-impl0(obj2, anchorInfo) && Float.compare(f3, i3) > 0) {
            if (Float.compare(f3, i3) > 0) {
                return Offset.Companion.getUnspecified-F1C5BW0();
            }
        }
        float centerYForOffset = anchorSelectable$foundation_release.getCenterYForOffset(offset);
        if (Float.compare(centerYForOffset, i8) == 0) {
            i2 = 1;
        }
        if (i2 != 0) {
            return Offset.Companion.getUnspecified-F1C5BW0();
        }
        return containerLayoutCoordinates.localPositionOf-R5De75A(layoutCoordinates, OffsetKt.Offset(lineStartX, centerYForOffset));
    }

    public static final Rect getSelectedRegionRect(List<? extends Pair<? extends androidx.compose.foundation.text.selection.Selectable, androidx.compose.foundation.text.selection.Selection>> selectableSubSelectionPairs, LayoutCoordinates containerCoordinates) {
        float f;
        float containerBottom;
        float containerLeft;
        float containerTop;
        float containerRight;
        long containerBottom2;
        int minOffset;
        int offsets;
        int[] iArr;
        int bottom;
        int size;
        float left2;
        Object item$iv;
        Object subSelection;
        int i4;
        Object component1;
        int offset;
        int offset2;
        LayoutCoordinates layoutCoordinates;
        long $this$fastForEach$iv;
        int i5;
        int i;
        int[] iArr2;
        int i2;
        int left;
        Object top;
        Object right;
        int i3;
        float f2;
        float boundingBox;
        long localPositionOf-R5De75A;
        long localPositionOf-R5De75A2;
        float f3;
        f = containerCoordinates;
        if (selectableSubSelectionPairs.isEmpty()) {
            return SelectionManagerKt.invertedInfiniteRect;
        }
        Rect invertedInfiniteRect2 = SelectionManagerKt.invertedInfiniteRect;
        int i6 = 0;
        containerLeft = invertedInfiniteRect2.component1();
        int i7 = 0;
        containerTop = invertedInfiniteRect2.component2();
        int i8 = 0;
        containerRight = invertedInfiniteRect2.component3();
        int i9 = 0;
        containerBottom = invertedInfiniteRect2.component4();
        offsets = 0;
        bottom = 0;
        size = selectableSubSelectionPairs.size();
        while (bottom < size) {
            item$iv = containerBottom2.get(bottom);
            Object obj = item$iv;
            i4 = 0;
            component1 = (Pair)obj.component1();
            subSelection = obj.component2();
            offset = (Selection)subSelection.getStart().getOffset();
            offset2 = subSelection.getEnd().getOffset();
            if (offset != offset2) {
            } else {
            }
            $this$fastForEach$iv = containerBottom2;
            i = offsets;
            i2 = bottom;
            left = size;
            top = item$iv;
            right = subSelection;
            bottom = i2 + 1;
            f = containerCoordinates;
            containerBottom2 = $this$fastForEach$iv;
            offsets = i;
            size = left;
            layoutCoordinates = (Selectable)component1.getLayoutCoordinates();
            if (layoutCoordinates == null) {
            } else {
            }
            $this$fastForEach$iv = containerBottom2;
            int i10 = Math.min(offset, offset2);
            i5 = Math.max(offset, offset2);
            i = offsets;
            int i13 = 0;
            i2 = bottom;
            int index$iv = 1;
            if (i10 == i5 + -1) {
            } else {
            }
            iArr = new int[2];
            iArr[i13] = i10;
            iArr[index$iv] = i5 + -1;
            Rect invertedInfiniteRect3 = SelectionManagerKt.invertedInfiniteRect;
            bottom = invertedInfiniteRect3.component4();
            i3 = i10;
            minOffset = iArr.length;
            offsets = i14;
            left = size;
            left2 = f6;
            top = item$iv;
            item$iv = f7;
            right = subSelection;
            subSelection = f3;
            while (offsets < minOffset) {
                int i11 = iArr[offsets];
                boundingBox = component1.getBoundingBox(i11);
                localPositionOf-R5De75A = i11;
                left2 = Math.min(left2, boundingBox.getLeft());
                item$iv = Math.min(item$iv, boundingBox.getTop());
                subSelection = Math.max(subSelection, boundingBox.getRight());
                bottom = Math.max(bottom, boundingBox.getBottom());
                offsets++;
                minOffset = f2;
            }
            f2 = left2;
            boundingBox = item$iv;
            localPositionOf-R5De75A = f.localPositionOf-R5De75A(layoutCoordinates, OffsetKt.Offset(left2, item$iv));
            localPositionOf-R5De75A2 = f.localPositionOf-R5De75A(layoutCoordinates, OffsetKt.Offset(subSelection, bottom));
            containerBottom = Math.max(containerBottom, Offset.getY-impl(localPositionOf-R5De75A2));
            containerRight = f5;
            containerTop = f4;
            containerLeft = f;
            i11 = iArr2[offsets];
            boundingBox = component1.getBoundingBox(i11);
            localPositionOf-R5De75A = i11;
            left2 = Math.min(left2, boundingBox.getLeft());
            item$iv = Math.min(item$iv, boundingBox.getTop());
            subSelection = Math.max(subSelection, boundingBox.getRight());
            bottom = Math.max(bottom, boundingBox.getBottom());
            offsets++;
            minOffset = f2;
            new int[index$iv][i13] = i10;
            $this$fastForEach$iv = containerBottom2;
            i = offsets;
            i2 = bottom;
            left = size;
            top = item$iv;
        }
        Rect rect = new Rect(containerLeft, containerTop, containerRight, containerBottom);
        return rect;
    }

    public static final androidx.compose.foundation.text.selection.Selection merge(androidx.compose.foundation.text.selection.Selection lhs, androidx.compose.foundation.text.selection.Selection rhs) {
        androidx.compose.foundation.text.selection.Selection merge;
        if (lhs != null) {
            if (lhs.merge(rhs) == null) {
                merge = rhs;
            }
        } else {
        }
        return merge;
    }

    public static final Rect visibleBounds(LayoutCoordinates $this$visibleBounds) {
        final Rect boundsInWindow = LayoutCoordinatesKt.boundsInWindow($this$visibleBounds);
        return RectKt.Rect-0a9Yr6o($this$visibleBounds.windowToLocal-MK-Hz9U(boundsInWindow.getTopLeft-F1C5BW0()), obj2);
    }
}
