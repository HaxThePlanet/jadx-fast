package androidx.compose.foundation.lazy.grid;

import androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimation;
import androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimator;
import androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.layout.Placeable.PlacementScope;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffset.Companion;
import androidx.compose.ui.unit.IntOffsetKt;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.RangesKt;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008#\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0010\u0002\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0002\u0008\u0008\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0093\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0008\u0012\u0006\u0010\t\u001a\u00020\u0004\u0012\u0006\u0010\n\u001a\u00020\u0004\u0012\u0006\u0010\u000b\u001a\u00020\u0008\u0012\u0006\u0010\u000c\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u0004\u0012\u0006\u0010\u000f\u001a\u00020\u0004\u0012\u000c\u0010\u0010\u001a\u0008\u0012\u0004\u0012\u00020\u00120\u0011\u0012\u0006\u0010\u0013\u001a\u00020\u0014\u0012\u0008\u0010\u0015\u001a\u0004\u0018\u00010\u0006\u0012\u000c\u0010\u0016\u001a\u0008\u0012\u0004\u0012\u00020\u00000\u0017\u0012\u0006\u0010\u0018\u001a\u00020\u0019\u0012\u0006\u0010\u001a\u001a\u00020\u0004\u0012\u0006\u0010\u001b\u001a\u00020\u0004¢\u0006\u0002\u0010\u001cJ\u000e\u0010D\u001a\u00020E2\u0006\u0010F\u001a\u00020\u0004J\u001d\u0010G\u001a\u00020\u00142\u0006\u0010\u0003\u001a\u00020\u0004H\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\u0008H\u0010IJ\u0012\u0010J\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u0004H\u0016J\u000e\u0010K\u001a\u00020E2\u0006\u0010L\u001a\u00020MJ(\u0010N\u001a\u00020E2\u0006\u0010O\u001a\u00020\u00042\u0006\u0010P\u001a\u00020\u00042\u0006\u0010Q\u001a\u00020\u00042\u0006\u0010R\u001a\u00020\u0004H\u0016J6\u0010N\u001a\u00020E2\u0006\u0010O\u001a\u00020\u00042\u0006\u0010P\u001a\u00020\u00042\u0006\u0010Q\u001a\u00020\u00042\u0006\u0010R\u001a\u00020\u00042\u0006\u0010:\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u0004J\u000e\u0010S\u001a\u00020E2\u0006\u0010+\u001a\u00020\u0004J+\u0010T\u001a\u00020\u0014*\u00020\u00142\u0012\u0010U\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040VH\u0082\u0008ø\u0001\u0000¢\u0006\u0004\u0008W\u0010XR\u000e\u0010\u000f\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\u0008\u0012\u0004\u0012\u00020\u00000\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u0004@RX\u0096\u000e¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001f\u0010 R\u001c\u0010\u0018\u001a\u00020\u0019X\u0096\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010#\u001a\u0004\u0008!\u0010\"R\u0016\u0010\u0015\u001a\u0004\u0018\u00010\u0006X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008$\u0010%R\u0011\u0010\t\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008&\u0010 R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008'\u0010 R\u0014\u0010\u0007\u001a\u00020\u0008X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0007\u0010(R\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008)\u0010%R\u0014\u0010\u001a\u001a\u00020\u0004X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008*\u0010 R\u000e\u0010\u000c\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010,\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008-\u0010 R\u0014\u0010.\u001a\u00020\u0004X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008/\u0010 R\u000e\u00100\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u00102\u001a\u00020\u0008X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u00083\u0010(\"\u0004\u00084\u00105R&\u00106\u001a\u00020\u00142\u0006\u0010\u001d\u001a\u00020\u0014@RX\u0096\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010#\u001a\u0004\u00087\u0010\"R\u0014\u0010\u0010\u001a\u0008\u0012\u0004\u0012\u00020\u00120\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u00108\u001a\u00020\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u00089\u0010 R\u000e\u0010\u000b\u001a\u00020\u0008X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010:\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u0004@RX\u0096\u000e¢\u0006\u0008\n\u0000\u001a\u0004\u0008;\u0010 R\u001c\u0010<\u001a\u00020=X\u0096\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010#\u001a\u0004\u0008>\u0010\"R\u0014\u0010\u001b\u001a\u00020\u0004X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008?\u0010 R\u0016\u0010\u0013\u001a\u00020\u0014X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010#R\u0018\u0010@\u001a\u00020\u0004*\u00020\u00148BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008A\u0010BR\u0018\u0010,\u001a\u00020\u0004*\u00020\u00128BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008-\u0010C\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006Y", d2 = {"Landroidx/compose/foundation/lazy/grid/LazyGridMeasuredItem;", "Landroidx/compose/foundation/lazy/grid/LazyGridItemInfo;", "Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasuredItem;", "index", "", "key", "", "isVertical", "", "crossAxisSize", "mainAxisSpacing", "reverseLayout", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "beforeContentPadding", "afterContentPadding", "placeables", "", "Landroidx/compose/ui/layout/Placeable;", "visualOffset", "Landroidx/compose/ui/unit/IntOffset;", "contentType", "animator", "Landroidx/compose/foundation/lazy/layout/LazyLayoutItemAnimator;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "lane", "span", "(ILjava/lang/Object;ZIIZLandroidx/compose/ui/unit/LayoutDirection;IILjava/util/List;JLjava/lang/Object;Landroidx/compose/foundation/lazy/layout/LazyLayoutItemAnimator;JIILkotlin/jvm/internal/DefaultConstructorMarker;)V", "<set-?>", "column", "getColumn", "()I", "getConstraints-msEJaDk", "()J", "J", "getContentType", "()Ljava/lang/Object;", "getCrossAxisSize", "getIndex", "()Z", "getKey", "getLane", "mainAxisLayoutSize", "mainAxisSize", "getMainAxisSize", "mainAxisSizeWithSpacings", "getMainAxisSizeWithSpacings", "maxMainAxisOffset", "minMainAxisOffset", "nonScrollableItem", "getNonScrollableItem", "setNonScrollableItem", "(Z)V", "offset", "getOffset-nOcc-ac", "placeablesCount", "getPlaceablesCount", "row", "getRow", "size", "Landroidx/compose/ui/unit/IntSize;", "getSize-YbymL2g", "getSpan", "mainAxis", "getMainAxis--gyyYBs", "(J)I", "(Landroidx/compose/ui/layout/Placeable;)I", "applyScrollDelta", "", "delta", "getOffset", "getOffset-Bjo55l4", "(I)J", "getParentData", "place", "scope", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "position", "mainAxisOffset", "crossAxisOffset", "layoutWidth", "layoutHeight", "updateMainAxisLayoutSize", "copy", "mainAxisMap", "Lkotlin/Function1;", "copy-4Tuh3kE", "(JLkotlin/jvm/functions/Function1;)J", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class LazyGridMeasuredItem implements androidx.compose.foundation.lazy.grid.LazyGridItemInfo, LazyLayoutMeasuredItem {

    public static final int $stable = 8;
    private final int afterContentPadding;
    private final LazyLayoutItemAnimator<androidx.compose.foundation.lazy.grid.LazyGridMeasuredItem> animator;
    private final int beforeContentPadding;
    private int column;
    private final long constraints;
    private final Object contentType;
    private final int crossAxisSize;
    private final int index;
    private final boolean isVertical;
    private final Object key;
    private final int lane;
    private final LayoutDirection layoutDirection;
    private int mainAxisLayoutSize;
    private final int mainAxisSize;
    private final int mainAxisSizeWithSpacings;
    private int maxMainAxisOffset;
    private int minMainAxisOffset;
    private boolean nonScrollableItem;
    private long offset;
    private final List<Placeable> placeables;
    private final boolean reverseLayout;
    private int row;
    private final long size;
    private final int span;
    private final long visualOffset;
    static {
        final int i = 8;
    }

    private LazyGridMeasuredItem(int index, Object key, boolean isVertical, int crossAxisSize, int mainAxisSpacing, boolean reverseLayout, LayoutDirection layoutDirection, int beforeContentPadding, int afterContentPadding, List<? extends Placeable> placeables, long visualOffset, Object contentType, LazyLayoutItemAnimator<androidx.compose.foundation.lazy.grid.LazyGridMeasuredItem> animator, long constraints, int lane, int span) {
        List maxMainAxis;
        long l;
        int crossAxisSize2;
        int maxMainAxis2;
        int index$iv;
        int i2;
        int i;
        int i3;
        int height;
        List list;
        final Object obj = this;
        super();
        obj.index = index;
        obj.key = key;
        obj.isVertical = isVertical;
        obj.crossAxisSize = crossAxisSize;
        obj.reverseLayout = reverseLayout;
        obj.layoutDirection = layoutDirection;
        obj.beforeContentPadding = beforeContentPadding;
        obj.afterContentPadding = afterContentPadding;
        obj.placeables = placeables;
        obj.visualOffset = visualOffset;
        obj.contentType = animator;
        obj.animator = constraints;
        obj.constraints = lane;
        obj.lane = obj39;
        obj.span = obj40;
        obj.mainAxisLayoutSize = Integer.MIN_VALUE;
        final int i15 = 0;
        maxMainAxis2 = i2;
        index$iv = i;
        while (index$iv < obj.placeables.size()) {
            i = i2;
            i3 = 0;
            if (obj.isVertical()) {
            } else {
            }
            height = (Placeable)i.getWidth();
            maxMainAxis2 = Math.max(maxMainAxis2, height);
            index$iv++;
            maxMainAxis = list;
            height = i.getHeight();
        }
        List $this$fastForEach$iv2 = maxMainAxis;
        obj.mainAxisSize = maxMainAxis2;
        obj.mainAxisSizeWithSpacings = RangesKt.coerceAtLeast(maxMainAxis2 + mainAxisSpacing, 0);
        if (obj.isVertical()) {
            l = IntSizeKt.IntSize(obj.crossAxisSize, obj.mainAxisSize);
        } else {
            l = IntSizeKt.IntSize(obj.mainAxisSize, obj.crossAxisSize);
        }
        obj.size = l;
        obj.offset = IntOffset.Companion.getZero-nOcc-ac();
        int i10 = -1;
        obj.row = i10;
        obj.column = i10;
    }

    public LazyGridMeasuredItem(int i, Object object2, boolean z3, int i4, int i5, boolean z6, LayoutDirection layoutDirection7, int i8, int i9, List list10, long l11, Object object12, LazyLayoutItemAnimator lazyLayoutItemAnimator13, long l14, int i15, int i16, DefaultConstructorMarker defaultConstructorMarker17) {
        super(i, object2, z3, i4, i5, z6, layoutDirection7, i8, i9, list10, l11, object12, lazyLayoutItemAnimator13, l14, i15, i16, defaultConstructorMarker17, obj18);
    }

    private final long copy-4Tuh3kE(long $this$copy_u2d4Tuh3kE, Function1<? super Integer, Integer> mainAxisMap) {
        int intValue;
        int intValue2;
        final int i = 0;
        if (isVertical()) {
            intValue = IntOffset.getX-impl($this$copy_u2d4Tuh3kE);
        } else {
            intValue = (Number)obj6.invoke(Integer.valueOf(IntOffset.getX-impl($this$copy_u2d4Tuh3kE))).intValue();
        }
        if (isVertical()) {
            intValue2 = (Number)obj6.invoke(Integer.valueOf(IntOffset.getY-impl($this$copy_u2d4Tuh3kE))).intValue();
        } else {
            intValue2 = IntOffset.getY-impl($this$copy_u2d4Tuh3kE);
        }
        return IntOffsetKt.IntOffset(intValue, intValue2);
    }

    private final int getMainAxis--gyyYBs(long $this$mainAxis) {
        int y-impl;
        if (isVertical()) {
            y-impl = IntOffset.getY-impl($this$mainAxis);
        } else {
            y-impl = IntOffset.getX-impl($this$mainAxis);
        }
        return y-impl;
    }

    private final int getMainAxisSize(Placeable $this$mainAxisSize) {
        int height;
        if (isVertical()) {
            height = $this$mainAxisSize.getHeight();
        } else {
            height = $this$mainAxisSize.getWidth();
        }
        return height;
    }

    @Override // androidx.compose.foundation.lazy.grid.LazyGridItemInfo
    public final void applyScrollDelta(int delta) {
        int i6;
        Object obj2;
        int i2;
        int it;
        int i5;
        int it2;
        int i;
        Object obj;
        int i4;
        int intValue;
        int mainAxis;
        int i3;
        if (getNonScrollableItem()) {
        }
        long offset-nOcc-ac = getOffset-nOcc-ac();
        obj2 = this;
        i2 = 0;
        if (obj2.isVertical()) {
            it = IntOffset.getX-impl(offset-nOcc-ac);
        } else {
            i5 = 0;
            x-impl += delta;
        }
        if (obj2.isVertical()) {
            i = 0;
            y-impl += delta;
        } else {
            it2 = IntOffset.getY-impl(offset-nOcc-ac);
        }
        this.offset = IntOffsetKt.IntOffset(it, it2);
        i6 = 0;
        while (i6 < getPlaceablesCount()) {
            i2 = 0;
            it = this.animator.getAnimation(getKey(), i6);
            if (it != 0) {
            }
            i6++;
            long rawOffset-nOcc-ac = it.getRawOffset-nOcc-ac();
            obj = this;
            i4 = 0;
            if (obj.isVertical()) {
            } else {
            }
            mainAxis = 0;
            intValue = (Number)Integer.valueOf(x-impl2 += delta).intValue();
            if (obj.isVertical()) {
            } else {
            }
            mainAxis = IntOffset.getY-impl(rawOffset-nOcc-ac);
            it.setRawOffset--gyyYBs(IntOffsetKt.IntOffset(intValue, mainAxis));
            i3 = 0;
            y-impl2 += delta;
            intValue = IntOffset.getX-impl(rawOffset-nOcc-ac);
        }
    }

    @Override // androidx.compose.foundation.lazy.grid.LazyGridItemInfo
    public int getColumn() {
        return this.column;
    }

    @Override // androidx.compose.foundation.lazy.grid.LazyGridItemInfo
    public long getConstraints-msEJaDk() {
        return this.constraints;
    }

    @Override // androidx.compose.foundation.lazy.grid.LazyGridItemInfo
    public Object getContentType() {
        return this.contentType;
    }

    @Override // androidx.compose.foundation.lazy.grid.LazyGridItemInfo
    public final int getCrossAxisSize() {
        return this.crossAxisSize;
    }

    @Override // androidx.compose.foundation.lazy.grid.LazyGridItemInfo
    public int getIndex() {
        return this.index;
    }

    @Override // androidx.compose.foundation.lazy.grid.LazyGridItemInfo
    public Object getKey() {
        return this.key;
    }

    @Override // androidx.compose.foundation.lazy.grid.LazyGridItemInfo
    public int getLane() {
        return this.lane;
    }

    @Override // androidx.compose.foundation.lazy.grid.LazyGridItemInfo
    public final int getMainAxisSize() {
        return this.mainAxisSize;
    }

    @Override // androidx.compose.foundation.lazy.grid.LazyGridItemInfo
    public int getMainAxisSizeWithSpacings() {
        return this.mainAxisSizeWithSpacings;
    }

    @Override // androidx.compose.foundation.lazy.grid.LazyGridItemInfo
    public boolean getNonScrollableItem() {
        return this.nonScrollableItem;
    }

    @Override // androidx.compose.foundation.lazy.grid.LazyGridItemInfo
    public long getOffset-Bjo55l4(int index) {
        return getOffset-nOcc-ac();
    }

    @Override // androidx.compose.foundation.lazy.grid.LazyGridItemInfo
    public long getOffset-nOcc-ac() {
        return this.offset;
    }

    @Override // androidx.compose.foundation.lazy.grid.LazyGridItemInfo
    public Object getParentData(int index) {
        return (Placeable)this.placeables.get(index).getParentData();
    }

    @Override // androidx.compose.foundation.lazy.grid.LazyGridItemInfo
    public int getPlaceablesCount() {
        return this.placeables.size();
    }

    @Override // androidx.compose.foundation.lazy.grid.LazyGridItemInfo
    public int getRow() {
        return this.row;
    }

    @Override // androidx.compose.foundation.lazy.grid.LazyGridItemInfo
    public long getSize-YbymL2g() {
        return this.size;
    }

    @Override // androidx.compose.foundation.lazy.grid.LazyGridItemInfo
    public int getSpan() {
        return this.span;
    }

    @Override // androidx.compose.foundation.lazy.grid.LazyGridItemInfo
    public boolean isVertical() {
        return this.isVertical;
    }

    @Override // androidx.compose.foundation.lazy.grid.LazyGridItemInfo
    public final void place(Placeable.PlacementScope scope) {
        Object $this$place_u24lambda_u247;
        androidx.compose.ui.graphics.layer.GraphicsLayer layer;
        int mainAxis--gyyYBs;
        int i4;
        int offset3;
        long offset;
        int y-impl;
        int mainAxisSize;
        androidx.compose.ui.graphics.layer.GraphicsLayer animation;
        int i2;
        boolean layer2;
        long plus-qkQi6aY;
        int i5;
        int i3;
        int i6;
        int i8;
        int i;
        int maxMainAxisOffset;
        LazyLayoutItemAnimation $this$place_u24lambda_u2472;
        LazyLayoutItemAnimation $this$place_u24lambda_u2473;
        int i7;
        boolean vertical;
        int x-impl;
        int i9;
        androidx.compose.ui.graphics.layer.GraphicsLayer layer3;
        int offset2;
        final Object obj = this;
        $this$place_u24lambda_u247 = scope;
        final int i14 = 0;
        mainAxisSize = 0;
        i4 = obj.mainAxisLayoutSize != Integer.MIN_VALUE ? 1 : mainAxisSize;
        if (i4 == 0) {
        } else {
            i3 = mainAxisSize;
            while (i3 < obj.getPlaceablesCount()) {
                i6 = i3;
                i8 = 0;
                i4 = obj.placeables.get(i6);
                mainAxisSize = obj.getMainAxisSize((Placeable)i4);
                i = minMainAxisOffset - mainAxisSize;
                maxMainAxisOffset = obj.maxMainAxisOffset;
                offset = obj.getOffset-nOcc-ac();
                LazyLayoutItemAnimation animation2 = obj.animator.getAnimation(obj.getKey(), i6);
                int i13 = 0;
                if (animation2 != null) {
                } else {
                }
                $this$place_u24lambda_u2473 = $this$place_u24lambda_u247;
                layer = 0;
                if (obj.reverseLayout) {
                } else {
                }
                layer3 = layer;
                offset2 = offset;
                offset3 = IntOffset.plus-qkQi6aY(offset, mainAxisSize);
                if (animation2 == null) {
                } else {
                }
                animation2.setFinalOffset--gyyYBs(offset3);
                if (obj.isVertical()) {
                } else {
                }
                $this$place_u24lambda_u247 = $this$place_u24lambda_u2473;
                $this$place_u24lambda_u2472 = animation2;
                if (layer3 != null) {
                } else {
                }
                Placeable.PlacementScope.placeRelativeWithLayer-aW-9-wM$default($this$place_u24lambda_u247, i4, offset3, mainAxisSize, 0, 0, 6);
                i3++;
                Placeable.PlacementScope.placeRelativeWithLayer-aW-9-wM$default($this$place_u24lambda_u247, i4, offset3, mainAxisSize, layer3, 0, 4);
                if (layer3 != null) {
                } else {
                }
                $this$place_u24lambda_u2472 = animation2;
                Placeable.PlacementScope.placeWithLayer-aW-9-wM$default($this$place_u24lambda_u2473, i4, offset3, mainAxisSize, 0, 0, 6);
                $this$place_u24lambda_u2472 = animation2;
                Placeable.PlacementScope.placeWithLayer-aW-9-wM$default($this$place_u24lambda_u2473, i4, offset3, mainAxisSize, layer3, 0, 4);
                layer2 = offset;
                i5 = this;
                i7 = 0;
                if (i5.isVertical()) {
                } else {
                }
                i9 = 0;
                layer3 = layer;
                i10 -= offset2;
                if (i5.isVertical()) {
                } else {
                }
                offset2 = offset;
                y-impl = IntOffset.getY-impl(layer2);
                offset = IntOffsetKt.IntOffset(layer, y-impl);
                i9 = 0;
                offset2 = offset;
                i12 -= mainAxisSize;
                layer3 = layer;
                layer = x-impl;
                plus-qkQi6aY = IntOffset.plus-qkQi6aY(offset, mainAxisSize);
                $this$place_u24lambda_u2473 = $this$place_u24lambda_u247;
                if (obj.getMainAxis--gyyYBs(offset) <= i) {
                } else {
                }
                if (obj.getMainAxis--gyyYBs(offset) >= maxMainAxisOffset && obj.getMainAxis--gyyYBs(plus-qkQi6aY) >= maxMainAxisOffset) {
                }
                offset = plus-qkQi6aY;
                layer = animation2.getLayer();
                if (obj.getMainAxis--gyyYBs(plus-qkQi6aY) >= maxMainAxisOffset) {
                }
                animation2.cancelPlacementAnimation();
                if (obj.getMainAxis--gyyYBs(plus-qkQi6aY) > i) {
                } else {
                }
            }
        }
        int i11 = 0;
        IllegalArgumentException $i$a$RequireLazyGridMeasuredItem$place$1$1 = new IllegalArgumentException("position() should be called first".toString());
        throw $i$a$RequireLazyGridMeasuredItem$place$1$1;
    }

    @Override // androidx.compose.foundation.lazy.grid.LazyGridItemInfo
    public void position(int mainAxisOffset, int crossAxisOffset, int layoutWidth, int layoutHeight) {
        this.position(mainAxisOffset, crossAxisOffset, layoutWidth, layoutHeight, -1, -1);
    }

    @Override // androidx.compose.foundation.lazy.grid.LazyGridItemInfo
    public final void position(int mainAxisOffset, int crossAxisOffset, int layoutWidth, int layoutHeight, int row, int column) {
        int i;
        int i2;
        int i3;
        boolean layoutDirection;
        int crossAxisSize;
        long l;
        i = isVertical() ? layoutHeight : layoutWidth;
        this.mainAxisLayoutSize = i;
        i2 = isVertical() ? layoutWidth : layoutHeight;
        if (isVertical() && this.layoutDirection == LayoutDirection.Rtl) {
            if (this.layoutDirection == LayoutDirection.Rtl) {
                i4 -= crossAxisSize;
            } else {
                i3 = crossAxisOffset;
            }
        } else {
        }
        if (isVertical()) {
            l = IntOffsetKt.IntOffset(i3, mainAxisOffset);
        } else {
            l = IntOffsetKt.IntOffset(mainAxisOffset, i3);
        }
        this.offset = l;
        this.row = row;
        this.column = column;
        this.minMainAxisOffset = -beforeContentPadding;
        this.maxMainAxisOffset = mainAxisLayoutSize += afterContentPadding;
    }

    @Override // androidx.compose.foundation.lazy.grid.LazyGridItemInfo
    public void setNonScrollableItem(boolean <set-?>) {
        this.nonScrollableItem = <set-?>;
    }

    @Override // androidx.compose.foundation.lazy.grid.LazyGridItemInfo
    public final void updateMainAxisLayoutSize(int mainAxisLayoutSize) {
        this.mainAxisLayoutSize = mainAxisLayoutSize;
        this.maxMainAxisOffset = afterContentPadding += mainAxisLayoutSize;
    }
}
