package androidx.compose.foundation.layout;

import androidx.collection.IntIntPair;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0002\u0008\n\u0008\u0000\u0018\u00002\u00020\u0001:\u0002\"#B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\u0008\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003¢\u0006\u0002\u0010\u000bJ8\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u0003JZ\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u001a2\u0008\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\u00032\u0006\u0010\u001e\u001a\u00020\u00122\u0006\u0010\u001f\u001a\u00020\u0012ø\u0001\u0000¢\u0006\u0004\u0008 \u0010!R\u0016\u0010\u0006\u001a\u00020\u0007X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u000cR\u000e\u0010\n\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0008\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006$", d2 = {"Landroidx/compose/foundation/layout/FlowLayoutBuildingBlocks;", "", "maxItemsInMainAxis", "", "overflow", "Landroidx/compose/foundation/layout/FlowLayoutOverflowState;", "constraints", "Landroidx/compose/foundation/layout/OrientationIndependentConstraints;", "maxLines", "mainAxisSpacing", "crossAxisSpacing", "(ILandroidx/compose/foundation/layout/FlowLayoutOverflowState;JIIILkotlin/jvm/internal/DefaultConstructorMarker;)V", "J", "getWrapEllipsisInfo", "Landroidx/compose/foundation/layout/FlowLayoutBuildingBlocks$WrapEllipsisInfo;", "wrapInfo", "Landroidx/compose/foundation/layout/FlowLayoutBuildingBlocks$WrapInfo;", "hasNext", "", "lastContentLineIndex", "totalCrossAxisSize", "leftOverMainAxis", "nextIndexInLine", "getWrapInfo", "nextItemHasNext", "leftOver", "Landroidx/collection/IntIntPair;", "nextSize", "lineIndex", "currentLineCrossAxisSize", "isWrappingRound", "isEllipsisWrap", "getWrapInfo-OpUlnko", "(ZIJLandroidx/collection/IntIntPair;IIIZZ)Landroidx/compose/foundation/layout/FlowLayoutBuildingBlocks$WrapInfo;", "WrapEllipsisInfo", "WrapInfo", "foundation-layout_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class FlowLayoutBuildingBlocks {

    public static final int $stable = 8;
    private final long constraints;
    private final int crossAxisSpacing;
    private final int mainAxisSpacing;
    private final int maxItemsInMainAxis;
    private final int maxLines;
    private final androidx.compose.foundation.layout.FlowLayoutOverflowState overflow;

    @Metadata(d1 = "\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\r\u0008\u0007\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0008\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0008\u0008\u0002\u0010\u0008\u001a\u00020\t¢\u0006\u0002\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000b\u0010\u000cR\u0019\u0010\u0006\u001a\u00020\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\u0008\r\u0010\u000eR\u001a\u0010\u0008\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0010\u0010\u0011\"\u0004\u0008\u0012\u0010\u0013R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0014\u0010\u0015\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006\u0016", d2 = {"Landroidx/compose/foundation/layout/FlowLayoutBuildingBlocks$WrapEllipsisInfo;", "", "ellipsis", "Landroidx/compose/ui/layout/Measurable;", "placeable", "Landroidx/compose/ui/layout/Placeable;", "ellipsisSize", "Landroidx/collection/IntIntPair;", "placeEllipsisOnLastContentLine", "", "(Landroidx/compose/ui/layout/Measurable;Landroidx/compose/ui/layout/Placeable;JZLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getEllipsis", "()Landroidx/compose/ui/layout/Measurable;", "getEllipsisSize-OO21N7I", "()J", "J", "getPlaceEllipsisOnLastContentLine", "()Z", "setPlaceEllipsisOnLastContentLine", "(Z)V", "getPlaceable", "()Landroidx/compose/ui/layout/Placeable;", "foundation-layout_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class WrapEllipsisInfo {

        public static final int $stable = 8;
        private final Measurable ellipsis;
        private final long ellipsisSize;
        private boolean placeEllipsisOnLastContentLine;
        private final Placeable placeable;
        static {
            final int i = 8;
        }

        private WrapEllipsisInfo(Measurable ellipsis, Placeable placeable, long ellipsisSize, boolean placeEllipsisOnLastContentLine) {
            super();
            this.ellipsis = ellipsis;
            this.placeable = placeable;
            this.ellipsisSize = ellipsisSize;
            this.placeEllipsisOnLastContentLine = obj5;
        }

        public WrapEllipsisInfo(Measurable measurable, Placeable placeable2, long l3, boolean z4, int i5, DefaultConstructorMarker defaultConstructorMarker6) {
            int i;
            int obj12;
            i = defaultConstructorMarker6 &= 8 != 0 ? obj12 : i5;
            super(measurable, placeable2, l3, obj4, i, 0);
        }

        public WrapEllipsisInfo(Measurable measurable, Placeable placeable2, long l3, boolean z4, DefaultConstructorMarker defaultConstructorMarker5) {
            super(measurable, placeable2, l3, z4, defaultConstructorMarker5);
        }

        public final Measurable getEllipsis() {
            return this.ellipsis;
        }

        public final long getEllipsisSize-OO21N7I() {
            return this.ellipsisSize;
        }

        public final boolean getPlaceEllipsisOnLastContentLine() {
            return this.placeEllipsisOnLastContentLine;
        }

        public final Placeable getPlaceable() {
            return this.placeable;
        }

        public final void setPlaceEllipsisOnLastContentLine(boolean <set-?>) {
            this.placeEllipsisOnLastContentLine = <set-?>;
        }
    }

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0004\u0008\u0007\u0018\u00002\u00020\u0001B\u0019\u0012\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0004\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0002\u0010\u0006¨\u0006\u0007", d2 = {"Landroidx/compose/foundation/layout/FlowLayoutBuildingBlocks$WrapInfo;", "", "isLastItemInLine", "", "isLastItemInContainer", "(ZZ)V", "()Z", "foundation-layout_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class WrapInfo {

        public static final int $stable;
        private final boolean isLastItemInContainer;
        private final boolean isLastItemInLine;
        static {
        }

        public WrapInfo() {
            final int i3 = 0;
            super(i3, i3, 3, 0);
        }

        public WrapInfo(boolean isLastItemInLine, boolean isLastItemInContainer) {
            super();
            this.isLastItemInLine = isLastItemInLine;
            this.isLastItemInContainer = isLastItemInContainer;
        }

        public WrapInfo(boolean z, boolean z2, int i3, DefaultConstructorMarker defaultConstructorMarker4) {
            int obj2;
            int obj3;
            final int i = 0;
            obj2 = i3 & 1 != 0 ? i : obj2;
            obj3 = i3 &= 2 != 0 ? i : obj3;
            super(obj2, obj3);
        }

        public final boolean isLastItemInContainer() {
            return this.isLastItemInContainer;
        }

        public final boolean isLastItemInLine() {
            return this.isLastItemInLine;
        }
    }
    static {
        final int i = 8;
    }

    private FlowLayoutBuildingBlocks(int maxItemsInMainAxis, androidx.compose.foundation.layout.FlowLayoutOverflowState overflow, long constraints, int maxLines, int mainAxisSpacing, int crossAxisSpacing) {
        super();
        this.maxItemsInMainAxis = maxItemsInMainAxis;
        this.overflow = overflow;
        this.constraints = constraints;
        this.maxLines = mainAxisSpacing;
        this.mainAxisSpacing = crossAxisSpacing;
        this.crossAxisSpacing = obj7;
    }

    public FlowLayoutBuildingBlocks(int i, androidx.compose.foundation.layout.FlowLayoutOverflowState flowLayoutOverflowState2, long l3, int i4, int i5, int i6, DefaultConstructorMarker defaultConstructorMarker7) {
        super(i, flowLayoutOverflowState2, l3, i4, i5, i6, defaultConstructorMarker7);
    }

    public final androidx.compose.foundation.layout.FlowLayoutBuildingBlocks.WrapEllipsisInfo getWrapEllipsisInfo(androidx.compose.foundation.layout.FlowLayoutBuildingBlocks.WrapInfo wrapInfo, boolean hasNext, int lastContentLineIndex, int totalCrossAxisSize, int leftOverMainAxis, int nextIndexInLine) {
        int i;
        int maxItemsInMainAxis;
        maxItemsInMainAxis = 0;
        if (!wrapInfo.isLastItemInContainer()) {
            return maxItemsInMainAxis;
        }
        androidx.compose.foundation.layout.FlowLayoutBuildingBlocks.WrapEllipsisInfo ellipsisInfo$foundation_layout_release = this.overflow.ellipsisInfo$foundation_layout_release(hasNext, lastContentLineIndex, totalCrossAxisSize);
        if (ellipsisInfo$foundation_layout_release == null) {
            return maxItemsInMainAxis;
        }
        if (lastContentLineIndex >= 0) {
            if (nextIndexInLine != 0) {
                if (leftOverMainAxis - first-impl >= 0 && nextIndexInLine < this.maxItemsInMainAxis) {
                    i = nextIndexInLine < this.maxItemsInMainAxis ? 1 : 0;
                } else {
                }
            } else {
            }
        } else {
        }
        ellipsisInfo$foundation_layout_release.setPlaceEllipsisOnLastContentLine(i);
        return ellipsisInfo$foundation_layout_release;
    }

    public final androidx.compose.foundation.layout.FlowLayoutBuildingBlocks.WrapInfo getWrapInfo-OpUlnko(boolean nextItemHasNext, int nextIndexInLine, long leftOver, IntIntPair nextSize, int lineIndex, int totalCrossAxisSize, int currentLineCrossAxisSize, boolean isWrappingRound, boolean isEllipsisWrap) {
        int i;
        int i2;
        IntIntPair ellipsisSize-F35zm-w$foundation_layout_release;
        androidx.compose.foundation.layout.FlowLayoutOverflow.OverflowType second-impl;
        boolean z;
        long unbox-impl3;
        int i3;
        IntIntPair intIntPair;
        int maxItemsInMainAxis;
        long unbox-impl2;
        long unbox-impl;
        Object obj = this;
        final int i32 = nextIndexInLine;
        final int i33 = totalCrossAxisSize;
        final int i34 = isWrappingRound;
        final int i35 = 1;
        if (lineIndex == 0) {
            FlowLayoutBuildingBlocks.WrapInfo wrapInfo7 = new FlowLayoutBuildingBlocks.WrapInfo(i35, i35);
            return wrapInfo7;
        }
        int i14 = 0;
        i = obj.overflow.getType$foundation_layout_release() == FlowLayoutOverflow.OverflowType.Visible ? i14 : i33 >= maxLines ? i35 : i9 < 0 ? i35 : i14;
        if (i != 0) {
            FlowLayoutBuildingBlocks.WrapInfo wrapInfo6 = new FlowLayoutBuildingBlocks.WrapInfo(i35, i35);
            return wrapInfo6;
        }
        i2 = i32 == 0 ? i14 : i32 >= maxItemsInMainAxis2 ? i35 : i8 < 0 ? i35 : i14;
        if (i2 != 0 && isEllipsisWrap) {
            if (isEllipsisWrap) {
                FlowLayoutBuildingBlocks.WrapInfo wrapInfo5 = new FlowLayoutBuildingBlocks.WrapInfo(i35, i35);
                return wrapInfo5;
            }
            int i17 = 0;
            i11 -= i34;
            int second-impl5 = IntIntPair.getSecond-impl(lineIndex.unbox-impl());
            FlowLayoutBuildingBlocks.WrapInfo wrapInfo4 = new FlowLayoutBuildingBlocks.WrapInfo(i35, obj.getWrapInfo-OpUlnko(nextItemHasNext, 0, IntIntPair.constructor-impl(Constraints.getMaxWidth-impl(obj.constraints), i12), unbox-impl3, IntIntPair.box-impl(IntIntPair.constructor-impl(first-impl -= mainAxisSpacing, second-impl5)), i33 + 1, currentLineCrossAxisSize + i34, false, true).isLastItemInContainer());
            return wrapInfo4;
        }
        int totalContainerCrossAxisSize = currentLineCrossAxisSize + i4;
        if (obj29 != null) {
            z = nextItemHasNext;
            intIntPair = ellipsisSize-F35zm-w$foundation_layout_release;
        } else {
            intIntPair = ellipsisSize-F35zm-w$foundation_layout_release;
        }
        if (intIntPair != null) {
            unbox-impl2 = intIntPair.unbox-impl();
            ellipsisSize-F35zm-w$foundation_layout_release = 0;
            i3 = i32 + 1 >= obj.maxItemsInMainAxis ? i35 : i22 < 0 ? i35 : i14;
        } else {
            i3 = i14;
        }
        if (i3 != 0 && obj29 != null) {
            if (obj29 != null) {
                FlowLayoutBuildingBlocks.WrapInfo wrapInfo3 = new FlowLayoutBuildingBlocks.WrapInfo(i35, i35);
                return wrapInfo3;
            }
            int i5 = 0;
            int i18 = Math.max(i34, IntIntPair.getSecond-impl(lineIndex.unbox-impl()));
            androidx.compose.foundation.layout.FlowLayoutBuildingBlocks.WrapInfo wrapInfo-OpUlnko = obj.getWrapInfo-OpUlnko(false, 0, IntIntPair.constructor-impl(Constraints.getMaxWidth-impl(obj.constraints), i15 -= i18), i18, intIntPair, i33 + 1, totalContainerCrossAxisSize, false, true);
            FlowLayoutBuildingBlocks.WrapInfo wrapInfo = new FlowLayoutBuildingBlocks.WrapInfo(wrapInfo-OpUlnko.isLastItemInContainer(), wrapInfo-OpUlnko.isLastItemInContainer());
            return wrapInfo;
        }
        FlowLayoutBuildingBlocks.WrapInfo wrapInfo2 = new FlowLayoutBuildingBlocks.WrapInfo(i14, i14);
        return wrapInfo2;
    }
}
