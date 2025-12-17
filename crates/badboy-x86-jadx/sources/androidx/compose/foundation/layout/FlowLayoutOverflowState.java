package androidx.compose.foundation.layout;

import androidx.collection.IntIntPair;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\u0008\u001b\n\u0002\u0018\u0002\n\u0002\u0008\n\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u000e\n\u0000\u0008\u0080\u0008\u0018\u00002\u00020\u0001B\u001f\u0008\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J\u000e\u0010%\u001a\u00020\u0003HÀ\u0003¢\u0006\u0002\u0008&J\u000e\u0010'\u001a\u00020\u0005HÀ\u0003¢\u0006\u0002\u0008(J\u000e\u0010)\u001a\u00020\u0005HÀ\u0003¢\u0006\u0002\u0008*J'\u0010+\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J'\u0010,\u001a\u0004\u0018\u00010-2\u0006\u0010.\u001a\u00020\u00102\u0006\u0010/\u001a\u00020\u00052\u0006\u00100\u001a\u00020\u0005H\u0000¢\u0006\u0002\u00081J-\u00102\u001a\u0004\u0018\u00010\r2\u0006\u0010.\u001a\u00020\u00102\u0006\u0010/\u001a\u00020\u00052\u0006\u00100\u001a\u00020\u0005H\u0000ø\u0001\u0001ø\u0001\u0000¢\u0006\u0002\u00083J\u0013\u00104\u001a\u00020\u00102\u0008\u00105\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00106\u001a\u00020\u0005HÖ\u0001J6\u00107\u001a\u0002082\u0006\u00109\u001a\u00020:2\u0008\u0010 \u001a\u0004\u0018\u00010\t2\u0008\u0010\u0008\u001a\u0004\u0018\u00010\t2\u0006\u0010;\u001a\u00020<H\u0000ø\u0001\u0000¢\u0006\u0004\u0008=\u0010>J\\\u00107\u001a\u0002082\u0006\u00109\u001a\u00020:2\u0006\u0010;\u001a\u00020<28\u0010\u000e\u001a4\u0012\u0013\u0012\u00110\u0010¢\u0006\u000c\u0008\u0011\u0012\u0008\u0008\u0012\u0012\u0004\u0008\u0008(\u0013\u0012\u0013\u0012\u00110\u0005¢\u0006\u000c\u0008\u0011\u0012\u0008\u0008\u0012\u0012\u0004\u0008\u0008(?\u0012\u0006\u0012\u0004\u0018\u00010\t0\u000fH\u0000ø\u0001\u0000¢\u0006\u0004\u0008@\u0010AJ6\u00107\u001a\u0002082\u0008\u0010 \u001a\u0004\u0018\u00010B2\u0008\u0010\u0008\u001a\u0004\u0018\u00010B2\u0006\u0010C\u001a\u00020\u00102\u0006\u0010;\u001a\u00020<H\u0000ø\u0001\u0000¢\u0006\u0004\u0008=\u0010DJ\t\u0010E\u001a\u00020FHÖ\u0001R\u0010\u0010\u0008\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u000c\u001a\u0004\u0018\u00010\rX\u0082\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0002\n\u0000RB\u0010\u000e\u001a6\u0012\u0013\u0012\u00110\u0010¢\u0006\u000c\u0008\u0011\u0012\u0008\u0008\u0012\u0012\u0004\u0008\u0008(\u0013\u0012\u0013\u0012\u00110\u0005¢\u0006\u000c\u0008\u0011\u0012\u0008\u0008\u0012\u0012\u0004\u0008\u0008(\u0014\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0015\u001a\u00020\u0005X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0016\u0010\u0017\"\u0004\u0008\u0018\u0010\u0019R\u001a\u0010\u001a\u001a\u00020\u0005X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u001b\u0010\u0017\"\u0004\u0008\u001c\u0010\u0019R\u0014\u0010\u0006\u001a\u00020\u0005X\u0080\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001d\u0010\u0017R\u0014\u0010\u0004\u001a\u00020\u0005X\u0080\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001e\u0010\u0017R\u0014\u0010\u0014\u001a\u00020\u00058@X\u0080\u0004¢\u0006\u0006\u001a\u0004\u0008\u001f\u0010\u0017R\u0010\u0010 \u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\"\u001a\u0004\u0018\u00010\rX\u0082\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0002\n\u0000R\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008#\u0010$\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006G", d2 = {"Landroidx/compose/foundation/layout/FlowLayoutOverflowState;", "", "type", "Landroidx/compose/foundation/layout/FlowLayoutOverflow$OverflowType;", "minLinesToShowCollapse", "", "minCrossAxisSizeToShowCollapse", "(Landroidx/compose/foundation/layout/FlowLayoutOverflow$OverflowType;II)V", "collapseMeasurable", "Landroidx/compose/ui/layout/Measurable;", "collapsePlaceable", "Landroidx/compose/ui/layout/Placeable;", "collapseSize", "Landroidx/collection/IntIntPair;", "getOverflowMeasurable", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "isExpandable", "noOfItemsShown", "itemCount", "getItemCount$foundation_layout_release", "()I", "setItemCount$foundation_layout_release", "(I)V", "itemShown", "getItemShown$foundation_layout_release", "setItemShown$foundation_layout_release", "getMinCrossAxisSizeToShowCollapse$foundation_layout_release", "getMinLinesToShowCollapse$foundation_layout_release", "getNoOfItemsShown$foundation_layout_release", "seeMoreMeasurable", "seeMorePlaceable", "seeMoreSize", "getType$foundation_layout_release", "()Landroidx/compose/foundation/layout/FlowLayoutOverflow$OverflowType;", "component1", "component1$foundation_layout_release", "component2", "component2$foundation_layout_release", "component3", "component3$foundation_layout_release", "copy", "ellipsisInfo", "Landroidx/compose/foundation/layout/FlowLayoutBuildingBlocks$WrapEllipsisInfo;", "hasNext", "lineIndex", "totalCrossAxisSize", "ellipsisInfo$foundation_layout_release", "ellipsisSize", "ellipsisSize-F35zm-w$foundation_layout_release", "equals", "other", "hashCode", "setOverflowMeasurables", "", "measurePolicy", "Landroidx/compose/foundation/layout/FlowLineMeasurePolicy;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "setOverflowMeasurables--hBUhpc$foundation_layout_release", "(Landroidx/compose/foundation/layout/FlowLineMeasurePolicy;Landroidx/compose/ui/layout/Measurable;Landroidx/compose/ui/layout/Measurable;J)V", "numberOfItemsShown", "setOverflowMeasurables-VKLhPVY$foundation_layout_release", "(Landroidx/compose/foundation/layout/FlowLineMeasurePolicy;JLkotlin/jvm/functions/Function2;)V", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "isHorizontal", "(Landroidx/compose/ui/layout/IntrinsicMeasurable;Landroidx/compose/ui/layout/IntrinsicMeasurable;ZJ)V", "toString", "", "foundation-layout_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class FlowLayoutOverflowState {

    public static final int $stable = 8;
    private Measurable collapseMeasurable;
    private Placeable collapsePlaceable;
    private IntIntPair collapseSize;
    private Function2<? super Boolean, ? super Integer, ? extends Measurable> getOverflowMeasurable;
    private int itemCount;
    private int itemShown = -1;
    private final int minCrossAxisSizeToShowCollapse;
    private final int minLinesToShowCollapse;
    private Measurable seeMoreMeasurable;
    private Placeable seeMorePlaceable;
    private IntIntPair seeMoreSize;
    private final androidx.compose.foundation.layout.FlowLayoutOverflow.OverflowType type;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public class WhenMappings {

        public static final int[] $EnumSwitchMapping$0;
        static {
            int ordinal3;
            int ordinal2;
            int ordinal;
            int ordinal4;
            int[] iArr = new int[values.length];
            iArr[FlowLayoutOverflow.OverflowType.Visible.ordinal()] = 1;
            iArr[FlowLayoutOverflow.OverflowType.Clip.ordinal()] = 2;
            iArr[FlowLayoutOverflow.OverflowType.ExpandIndicator.ordinal()] = 3;
            iArr[FlowLayoutOverflow.OverflowType.ExpandOrCollapseIndicator.ordinal()] = 4;
            FlowLayoutOverflowState.WhenMappings.$EnumSwitchMapping$0 = iArr;
        }
    }
    static {
        final int i = 8;
    }

    public FlowLayoutOverflowState(androidx.compose.foundation.layout.FlowLayoutOverflow.OverflowType type, int minLinesToShowCollapse, int minCrossAxisSizeToShowCollapse) {
        super();
        this.type = type;
        this.minLinesToShowCollapse = minLinesToShowCollapse;
        this.minCrossAxisSizeToShowCollapse = minCrossAxisSizeToShowCollapse;
        final int i = -1;
    }

    public static final void access$setCollapsePlaceable$p(androidx.compose.foundation.layout.FlowLayoutOverflowState $this, Placeable <set-?>) {
        $this.collapsePlaceable = <set-?>;
    }

    public static final void access$setCollapseSize$p(androidx.compose.foundation.layout.FlowLayoutOverflowState $this, IntIntPair <set-?>) {
        $this.collapseSize = <set-?>;
    }

    public static final void access$setSeeMorePlaceable$p(androidx.compose.foundation.layout.FlowLayoutOverflowState $this, Placeable <set-?>) {
        $this.seeMorePlaceable = <set-?>;
    }

    public static final void access$setSeeMoreSize$p(androidx.compose.foundation.layout.FlowLayoutOverflowState $this, IntIntPair <set-?>) {
        $this.seeMoreSize = <set-?>;
    }

    public static androidx.compose.foundation.layout.FlowLayoutOverflowState copy$default(androidx.compose.foundation.layout.FlowLayoutOverflowState flowLayoutOverflowState, androidx.compose.foundation.layout.FlowLayoutOverflow.OverflowType flowLayoutOverflow$OverflowType2, int i3, int i4, int i5, Object object6) {
        androidx.compose.foundation.layout.FlowLayoutOverflow.OverflowType obj1;
        int obj2;
        int obj3;
        if (i5 & 1 != 0) {
            obj1 = flowLayoutOverflowState.type;
        }
        if (i5 & 2 != 0) {
            obj2 = flowLayoutOverflowState.minLinesToShowCollapse;
        }
        if (i5 &= 4 != 0) {
            obj3 = flowLayoutOverflowState.minCrossAxisSizeToShowCollapse;
        }
        return flowLayoutOverflowState.copy(obj1, obj2, obj3);
    }

    public final androidx.compose.foundation.layout.FlowLayoutOverflow.OverflowType component1$foundation_layout_release() {
        return this.type;
    }

    public final int component2$foundation_layout_release() {
        return this.minLinesToShowCollapse;
    }

    public final int component3$foundation_layout_release() {
        return this.minCrossAxisSizeToShowCollapse;
    }

    public final androidx.compose.foundation.layout.FlowLayoutOverflowState copy(androidx.compose.foundation.layout.FlowLayoutOverflow.OverflowType flowLayoutOverflow$OverflowType, int i2, int i3) {
        FlowLayoutOverflowState flowLayoutOverflowState = new FlowLayoutOverflowState(overflowType, i2, i3);
        return flowLayoutOverflowState;
    }

    public final androidx.compose.foundation.layout.FlowLayoutBuildingBlocks.WrapEllipsisInfo ellipsisInfo$foundation_layout_release(boolean hasNext, int lineIndex, int totalCrossAxisSize) {
        int measurable2;
        int measurable;
        int i4;
        androidx.compose.foundation.layout.FlowLayoutBuildingBlocks.WrapEllipsisInfo wrapEllipsisInfo;
        Placeable placeable;
        Object ellipsisSize;
        Placeable measurable3;
        Object minCrossAxisSizeToShowCollapse;
        long unbox-impl;
        int getOverflowMeasurable;
        Integer valueOf;
        int i;
        int i2;
        int i3;
        switch (measurable2) {
            case 1:
                break;
            case 2:
                break;
            case 3:
                measurable = 0;
                placeable = 0;
                int i5 = 0;
                minCrossAxisSizeToShowCollapse = 1;
                getOverflowMeasurable = this.getOverflowMeasurable;
                minCrossAxisSizeToShowCollapse = this.seeMoreMeasurable;
                measurable2 = this.seeMoreSize;
                ellipsisSize = minCrossAxisSizeToShowCollapse;
                measurable3 = placeable;
                ellipsisSize = minCrossAxisSizeToShowCollapse;
                measurable3 = placeable;
                minCrossAxisSizeToShowCollapse = this.getOverflowMeasurable;
                minCrossAxisSizeToShowCollapse = this.collapseMeasurable;
                measurable = minCrossAxisSizeToShowCollapse;
                IntIntPair ellipsisSize3 = this.collapseSize;
                ellipsisSize = measurable;
                measurable2 = intIntPair2;
                measurable3 = placeable;
                ellipsisSize = measurable;
                measurable2 = intIntPair;
                measurable3 = placeable;
                return null;
                Intrinsics.checkNotNull(measurable2);
                wrapEllipsisInfo = new FlowLayoutBuildingBlocks.WrapEllipsisInfo(ellipsisSize, measurable3, measurable2.unbox-impl(), valueOf, 0, 8, 0);
                i4 = wrapEllipsisInfo;
                break;
            default:
                NoWhenBranchMatchedException noWhenBranchMatchedException = new NoWhenBranchMatchedException();
                throw noWhenBranchMatchedException;
        }
        return i4;
    }

    public final IntIntPair ellipsisSize-F35zm-w$foundation_layout_release(boolean hasNext, int lineIndex, int totalCrossAxisSize) {
        int minCrossAxisSizeToShowCollapse;
        int collapseSize;
        int minLinesToShowCollapse;
        collapseSize = 0;
        switch (minCrossAxisSizeToShowCollapse) {
            case 1:
                break;
            case 2:
                break;
            case 3:
                collapseSize = this.seeMoreSize;
                break;
            case 4:
                collapseSize = this.seeMoreSize;
                collapseSize = this.collapseSize;
                break;
            default:
                NoWhenBranchMatchedException noWhenBranchMatchedException = new NoWhenBranchMatchedException();
                throw noWhenBranchMatchedException;
        }
        return collapseSize;
    }

    public boolean equals(Object object) {
        final int i = 1;
        if (this == object) {
            return i;
        }
        final int i2 = 0;
        if (!object instanceof FlowLayoutOverflowState) {
            return i2;
        }
        Object obj = object;
        if (this.type != obj.type) {
            return i2;
        }
        if (this.minLinesToShowCollapse != obj.minLinesToShowCollapse) {
            return i2;
        }
        if (this.minCrossAxisSizeToShowCollapse != obj.minCrossAxisSizeToShowCollapse) {
            return i2;
        }
        return i;
    }

    public final int getItemCount$foundation_layout_release() {
        return this.itemCount;
    }

    public final int getItemShown$foundation_layout_release() {
        return this.itemShown;
    }

    public final int getMinCrossAxisSizeToShowCollapse$foundation_layout_release() {
        return this.minCrossAxisSizeToShowCollapse;
    }

    public final int getMinLinesToShowCollapse$foundation_layout_release() {
        return this.minLinesToShowCollapse;
    }

    public final int getNoOfItemsShown$foundation_layout_release() {
        if (this.itemShown == -1) {
        } else {
            return this.itemShown;
        }
        IllegalStateException illegalStateException = new IllegalStateException("Accessing noOfItemsShown before it is set. Are you calling this in the Composition phase, rather than in the draw phase? Consider our samples on how to use it during the draw phase or consider using ContextualFlowRow/ContextualFlowColumn which initializes this method in the composition phase.");
        throw illegalStateException;
    }

    public final androidx.compose.foundation.layout.FlowLayoutOverflow.OverflowType getType$foundation_layout_release() {
        return this.type;
    }

    public int hashCode() {
        return i2 += i7;
    }

    public final void setItemCount$foundation_layout_release(int <set-?>) {
        this.itemCount = <set-?>;
    }

    public final void setItemShown$foundation_layout_release(int <set-?>) {
        this.itemShown = <set-?>;
    }

    public final void setOverflowMeasurables--hBUhpc$foundation_layout_release(androidx.compose.foundation.layout.FlowLineMeasurePolicy measurePolicy, Measurable seeMoreMeasurable, Measurable collapseMeasurable, long constraints) {
        androidx.compose.foundation.layout.LayoutOrientation horizontal;
        int i;
        int i2;
        int anon;
        horizontal = measurePolicy.isHorizontal() ? LayoutOrientation.Horizontal : LayoutOrientation.Vertical;
        final int i4 = 0;
        long boxConstraints-OenEA2s = OrientationIndependentConstraints.toBoxConstraints-OenEA2s(OrientationIndependentConstraints.copy-yUG9Ft0$default(OrientationIndependentConstraints.constructor-impl(constraints, obj15), obj3, 0, i4, 0, 0, 10), obj3);
        if (seeMoreMeasurable != null) {
            i = seeMoreMeasurable;
            i2 = 0;
            anon = new FlowLayoutOverflowState.setOverflowMeasurables.3.1(this, measurePolicy);
            FlowLayoutKt.measureAndCache-rqJ1uqs(i, measurePolicy, boxConstraints-OenEA2s, i4);
            this.seeMoreMeasurable = i;
        }
        if (collapseMeasurable != null) {
            i = collapseMeasurable;
            i2 = 0;
            anon = new FlowLayoutOverflowState.setOverflowMeasurables.4.1(this, measurePolicy);
            FlowLayoutKt.measureAndCache-rqJ1uqs(i, measurePolicy, boxConstraints-OenEA2s, i4);
            this.collapseMeasurable = i;
        }
    }

    public final void setOverflowMeasurables--hBUhpc$foundation_layout_release(IntrinsicMeasurable seeMoreMeasurable, IntrinsicMeasurable collapseMeasurable, boolean isHorizontal, long constraints) {
        androidx.compose.foundation.layout.LayoutOrientation horizontal;
        IntrinsicMeasurable intrinsicMeasurable;
        int i;
        int mainAxisMin;
        int crossAxisMin;
        int i2;
        horizontal = isHorizontal ? LayoutOrientation.Horizontal : LayoutOrientation.Vertical;
        final long constructor-impl = OrientationIndependentConstraints.constructor-impl(constraints, obj15);
        final int i3 = 0;
        if (seeMoreMeasurable != null) {
            intrinsicMeasurable = seeMoreMeasurable;
            i = 0;
            int i5 = 0;
            mainAxisMin = FlowLayoutKt.mainAxisMin(intrinsicMeasurable, isHorizontal, Constraints.getMaxHeight-impl(constructor-impl));
            this.seeMoreSize = IntIntPair.box-impl(IntIntPair.constructor-impl(mainAxisMin, FlowLayoutKt.crossAxisMin(intrinsicMeasurable, isHorizontal, mainAxisMin)));
            if (intrinsicMeasurable instanceof Measurable) {
                i2 = intrinsicMeasurable;
            } else {
                i2 = i3;
            }
            this.seeMoreMeasurable = i2;
            this.seeMorePlaceable = i3;
        }
        if (collapseMeasurable != null) {
            intrinsicMeasurable = collapseMeasurable;
            i = 0;
            int i4 = 0;
            mainAxisMin = FlowLayoutKt.mainAxisMin(intrinsicMeasurable, isHorizontal, Constraints.getMaxHeight-impl(constructor-impl));
            this.collapseSize = IntIntPair.box-impl(IntIntPair.constructor-impl(mainAxisMin, FlowLayoutKt.crossAxisMin(intrinsicMeasurable, isHorizontal, mainAxisMin)));
            if (intrinsicMeasurable instanceof Measurable) {
                i2 = intrinsicMeasurable;
            } else {
                i2 = i3;
            }
            this.collapseMeasurable = i2;
            this.collapsePlaceable = i3;
        }
    }

    public final void setOverflowMeasurables-VKLhPVY$foundation_layout_release(androidx.compose.foundation.layout.FlowLineMeasurePolicy measurePolicy, long constraints, Function2<? super Boolean, ? super Integer, ? extends Measurable> getOverflowMeasurable) {
        int i = 0;
        final Integer valueOf2 = Integer.valueOf(i);
        this.itemShown = i;
        this.getOverflowMeasurable = obj13;
        this.setOverflowMeasurables--hBUhpc$foundation_layout_release(measurePolicy, (Measurable)obj13.invoke(true, valueOf2), (Measurable)obj13.invoke(Boolean.valueOf(i), valueOf2), constraints);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append("FlowLayoutOverflowState(type=").append(this.type).append(", minLinesToShowCollapse=").append(this.minLinesToShowCollapse).append(", minCrossAxisSizeToShowCollapse=").append(this.minCrossAxisSizeToShowCollapse).append(')').toString();
    }
}
