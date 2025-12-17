package androidx.compose.foundation.lazy.staggeredgrid;

import androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimation;
import androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimator;
import androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.layout.Placeable.PlacementScope;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffset.Companion;
import androidx.compose.ui.unit.IntOffsetKt;
import androidx.compose.ui.unit.IntSizeKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.RangesKt;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u001d\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0010\u0002\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0010\u000e\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008\u0000\u0018\u00002\u00020\u00012\u00020\u0002Bs\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u000c\u0010\u0007\u001a\u0008\u0012\u0004\u0012\u00020\t0\u0008\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\u000c\u001a\u00020\u0004\u0012\u0006\u0010\r\u001a\u00020\u0004\u0012\u0006\u0010\u000e\u001a\u00020\u0004\u0012\u0006\u0010\u000f\u001a\u00020\u0004\u0012\u0006\u0010\u0010\u001a\u00020\u0004\u0012\u0008\u0010\u0011\u001a\u0004\u0018\u00010\u0006\u0012\u000c\u0010\u0012\u001a\u0008\u0012\u0004\u0012\u00020\u00000\u0013\u0012\u0006\u0010\u0014\u001a\u00020\u0015¢\u0006\u0002\u0010\u0016J\u000e\u0010@\u001a\u00020A2\u0006\u0010B\u001a\u00020\u0004J\u001d\u0010C\u001a\u0002032\u0006\u0010\u0003\u001a\u00020\u0004H\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\u0008D\u0010EJ\u0012\u0010F\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u0004H\u0016J\u0016\u0010G\u001a\u00020A2\u0006\u0010H\u001a\u00020I2\u0006\u0010J\u001a\u00020KJ\u001e\u0010L\u001a\u00020A2\u0006\u0010<\u001a\u00020\u00042\u0006\u0010M\u001a\u00020\u00042\u0006\u0010&\u001a\u00020\u0004J(\u0010L\u001a\u00020A2\u0006\u0010'\u001a\u00020\u00042\u0006\u0010N\u001a\u00020\u00042\u0006\u0010O\u001a\u00020\u00042\u0006\u0010P\u001a\u00020\u0004H\u0016J\u0008\u0010Q\u001a\u00020RH\u0016J\u000e\u0010S\u001a\u00020A2\u0006\u0010&\u001a\u00020\u0004J+\u0010T\u001a\u000203*\u0002032\u0012\u0010U\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040VH\u0082\u0008ø\u0001\u0000¢\u0006\u0004\u0008W\u0010XR\u000e\u0010\u0010\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\u0008\u0012\u0004\u0012\u00020\u00000\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0014\u001a\u00020\u0015X\u0096\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\u0008\u0017\u0010\u0018R\u0016\u0010\u0011\u001a\u0004\u0018\u00010\u0006X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001a\u0010\u001bR\u0011\u0010\u001c\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001d\u0010\u001eR\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001f\u0010\u001eR\u0014\u0010\n\u001a\u00020\u000bX\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\n\u0010 R\u001a\u0010!\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008!\u0010 \"\u0004\u0008\"\u0010#R\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008$\u0010\u001bR\u0014\u0010\r\u001a\u00020\u0004X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008%\u0010\u001eR\u000e\u0010&\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010'\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\u0008(\u0010\u001eR\u0011\u0010)\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008*\u0010\u001eR\u0014\u0010+\u001a\u00020\u0004X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008,\u0010\u001eR\u000e\u0010-\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010/\u001a\u00020\u000bX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u00080\u0010 \"\u0004\u00081\u0010#R&\u00104\u001a\u0002032\u0006\u00102\u001a\u000203@RX\u0096\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\u00085\u0010\u0018R\u0014\u0010\u0007\u001a\u0008\u0012\u0004\u0012\u00020\t0\u0008X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u00106\u001a\u00020\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u00087\u0010\u001eR\u001c\u00108\u001a\u000209X\u0096\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\u0008:\u0010\u0018R\u0014\u0010\u000e\u001a\u00020\u0004X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008;\u0010\u001eR\u0018\u0010<\u001a\u00020\u0004*\u0002038BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008=\u0010>R\u0019\u0010)\u001a\u00020\u0004*\u00020\t8Â\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008*\u0010?\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006Y", d2 = {"Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridMeasuredItem;", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridItemInfo;", "Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasuredItem;", "index", "", "key", "", "placeables", "", "Landroidx/compose/ui/layout/Placeable;", "isVertical", "", "spacing", "lane", "span", "beforeContentPadding", "afterContentPadding", "contentType", "animator", "Landroidx/compose/foundation/lazy/layout/LazyLayoutItemAnimator;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "(ILjava/lang/Object;Ljava/util/List;ZIIIIILjava/lang/Object;Landroidx/compose/foundation/lazy/layout/LazyLayoutItemAnimator;JLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getConstraints-msEJaDk", "()J", "J", "getContentType", "()Ljava/lang/Object;", "crossAxisSize", "getCrossAxisSize", "()I", "getIndex", "()Z", "isVisible", "setVisible", "(Z)V", "getKey", "getLane", "mainAxisLayoutSize", "mainAxisOffset", "getMainAxisOffset", "mainAxisSize", "getMainAxisSize", "mainAxisSizeWithSpacings", "getMainAxisSizeWithSpacings", "maxMainAxisOffset", "minMainAxisOffset", "nonScrollableItem", "getNonScrollableItem", "setNonScrollableItem", "<set-?>", "Landroidx/compose/ui/unit/IntOffset;", "offset", "getOffset-nOcc-ac", "placeablesCount", "getPlaceablesCount", "size", "Landroidx/compose/ui/unit/IntSize;", "getSize-YbymL2g", "getSpan", "mainAxis", "getMainAxis--gyyYBs", "(J)I", "(Landroidx/compose/ui/layout/Placeable;)I", "applyScrollDelta", "", "delta", "getOffset", "getOffset-Bjo55l4", "(I)J", "getParentData", "place", "scope", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "context", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridMeasureContext;", "position", "crossAxis", "crossAxisOffset", "layoutWidth", "layoutHeight", "toString", "", "updateMainAxisLayoutSize", "copy", "mainAxisMap", "Lkotlin/Function1;", "copy-4Tuh3kE", "(JLkotlin/jvm/functions/Function1;)J", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class LazyStaggeredGridMeasuredItem implements androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridItemInfo, LazyLayoutMeasuredItem {

    public static final int $stable = 8;
    private final int afterContentPadding;
    private final LazyLayoutItemAnimator<androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasuredItem> animator;
    private final int beforeContentPadding;
    private final long constraints;
    private final Object contentType;
    private final int crossAxisSize;
    private final int index;
    private final boolean isVertical;
    private boolean isVisible;
    private final Object key;
    private final int lane;
    private int mainAxisLayoutSize;
    private final int mainAxisSize;
    private final int mainAxisSizeWithSpacings;
    private int maxMainAxisOffset;
    private int minMainAxisOffset;
    private boolean nonScrollableItem;
    private long offset;
    private final List<Placeable> placeables;
    private final long size;
    private final int span;
    static {
        final int i = 8;
    }

    private LazyStaggeredGridMeasuredItem(int index, Object key, List<? extends Placeable> placeables, boolean isVertical, int spacing, int lane, int span, int beforeContentPadding, int afterContentPadding, Object contentType, LazyLayoutItemAnimator<androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasuredItem> animator, long constraints) {
        int i$iv;
        int intValue;
        int intValue2;
        long l;
        int lastIndex;
        int crossAxisSize;
        List list;
        boolean empty;
        Object maxValue$iv;
        int i$iv2;
        Integer maxValue$iv2;
        int height;
        int compareTo;
        int i2;
        int compareTo2;
        int i;
        int height2;
        final Object obj = this;
        super();
        obj.index = index;
        obj.key = key;
        obj.placeables = placeables;
        obj.isVertical = isVertical;
        obj.lane = lane;
        obj.span = span;
        obj.beforeContentPadding = beforeContentPadding;
        obj.afterContentPadding = afterContentPadding;
        obj.contentType = contentType;
        obj.animator = animator;
        obj.constraints = constraints;
        obj.isVisible = true;
        maxValue$iv = obj.placeables;
        i$iv2 = 0;
        if (maxValue$iv.isEmpty()) {
            maxValue$iv2 = compareTo;
        } else {
            Object obj4 = maxValue$iv.get(0);
            i2 = 0;
            if (obj.isVertical()) {
                compareTo2 = (Placeable)obj4.getHeight();
            } else {
                compareTo2 = obj4.getWidth();
            }
            maxValue$iv2 = Integer.valueOf(compareTo2);
            lastIndex = CollectionsKt.getLastIndex(maxValue$iv);
            if (1 <= lastIndex) {
            }
        }
        if ((Integer)maxValue$iv2 != null) {
            intValue = (Integer)maxValue$iv2.intValue();
        } else {
            intValue = 0;
        }
        obj.mainAxisSize = intValue;
        obj.mainAxisSizeWithSpacings = RangesKt.coerceAtLeast(mainAxisSize += spacing, 0);
        List placeables2 = obj.placeables;
        int i7 = 0;
        if (placeables2.isEmpty()) {
        } else {
            Object obj3 = placeables2.get(0);
            int i13 = 0;
            if (obj.isVertical()) {
                height = (Placeable)obj3.getWidth();
            } else {
                height = obj3.getHeight();
            }
            maxValue$iv = Integer.valueOf(height);
            maxValue$iv2 = CollectionsKt.getLastIndex(placeables2);
            if (1 <= maxValue$iv2) {
            }
            compareTo = maxValue$iv;
        }
        if ((Integer)compareTo != 0) {
            intValue2 = (Integer)compareTo.intValue();
        } else {
            intValue2 = 0;
        }
        obj.crossAxisSize = intValue2;
        obj.mainAxisLayoutSize = -1;
        if (obj.isVertical()) {
            l = IntSizeKt.IntSize(obj.crossAxisSize, obj.mainAxisSize);
        } else {
            l = IntSizeKt.IntSize(obj.mainAxisSize, obj.crossAxisSize);
        }
        obj.size = l;
        obj.offset = IntOffset.Companion.getZero-nOcc-ac();
    }

    public LazyStaggeredGridMeasuredItem(int i, Object object2, List list3, boolean z4, int i5, int i6, int i7, int i8, int i9, Object object10, LazyLayoutItemAnimator lazyLayoutItemAnimator11, long l12, DefaultConstructorMarker defaultConstructorMarker13) {
        super(i, object2, list3, z4, i5, i6, i7, i8, i9, object10, lazyLayoutItemAnimator11, l12, defaultConstructorMarker13);
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
        final int i = 0;
        if (isVertical()) {
            height = $this$mainAxisSize.getHeight();
        } else {
            height = $this$mainAxisSize.getWidth();
        }
        return height;
    }

    @Override // androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridItemInfo
    public final void applyScrollDelta(int delta) {
        int i;
        Object obj;
        int i5;
        int it2;
        int i2;
        int it;
        int i6;
        Object obj2;
        int i3;
        int intValue;
        int mainAxis;
        int i4;
        if (getNonScrollableItem()) {
        }
        long offset-nOcc-ac = getOffset-nOcc-ac();
        obj = this;
        i5 = 0;
        if (obj.isVertical()) {
            it2 = IntOffset.getX-impl(offset-nOcc-ac);
        } else {
            i2 = 0;
            x-impl += delta;
        }
        if (obj.isVertical()) {
            i6 = 0;
            y-impl += delta;
        } else {
            it = IntOffset.getY-impl(offset-nOcc-ac);
        }
        this.offset = IntOffsetKt.IntOffset(it2, it);
        i = 0;
        while (i < getPlaceablesCount()) {
            i5 = 0;
            it2 = this.animator.getAnimation(getKey(), i);
            if (it2 != 0) {
            }
            i++;
            long rawOffset-nOcc-ac = it2.getRawOffset-nOcc-ac();
            obj2 = this;
            i3 = 0;
            if (obj2.isVertical()) {
            } else {
            }
            mainAxis = 0;
            intValue = (Number)Integer.valueOf(x-impl2 += delta).intValue();
            if (obj2.isVertical()) {
            } else {
            }
            mainAxis = IntOffset.getY-impl(rawOffset-nOcc-ac);
            it2.setRawOffset--gyyYBs(IntOffsetKt.IntOffset(intValue, mainAxis));
            i4 = 0;
            y-impl2 += delta;
            intValue = IntOffset.getX-impl(rawOffset-nOcc-ac);
        }
    }

    @Override // androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridItemInfo
    public long getConstraints-msEJaDk() {
        return this.constraints;
    }

    @Override // androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridItemInfo
    public Object getContentType() {
        return this.contentType;
    }

    @Override // androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridItemInfo
    public final int getCrossAxisSize() {
        return this.crossAxisSize;
    }

    @Override // androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridItemInfo
    public int getIndex() {
        return this.index;
    }

    @Override // androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridItemInfo
    public Object getKey() {
        return this.key;
    }

    @Override // androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridItemInfo
    public int getLane() {
        return this.lane;
    }

    @Override // androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridItemInfo
    public final int getMainAxisOffset() {
        int x-impl;
        if (!isVertical()) {
            x-impl = IntOffset.getX-impl(getOffset-nOcc-ac());
        } else {
            x-impl = IntOffset.getY-impl(getOffset-nOcc-ac());
        }
        return x-impl;
    }

    @Override // androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridItemInfo
    public final int getMainAxisSize() {
        return this.mainAxisSize;
    }

    @Override // androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridItemInfo
    public int getMainAxisSizeWithSpacings() {
        return this.mainAxisSizeWithSpacings;
    }

    @Override // androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridItemInfo
    public boolean getNonScrollableItem() {
        return this.nonScrollableItem;
    }

    @Override // androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridItemInfo
    public long getOffset-Bjo55l4(int index) {
        return getOffset-nOcc-ac();
    }

    @Override // androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridItemInfo
    public long getOffset-nOcc-ac() {
        return this.offset;
    }

    @Override // androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridItemInfo
    public Object getParentData(int index) {
        return (Placeable)this.placeables.get(index).getParentData();
    }

    @Override // androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridItemInfo
    public int getPlaceablesCount() {
        return this.placeables.size();
    }

    @Override // androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridItemInfo
    public long getSize-YbymL2g() {
        return this.size;
    }

    @Override // androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridItemInfo
    public int getSpan() {
        return this.span;
    }

    @Override // androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridItemInfo
    public boolean isVertical() {
        return this.isVertical;
    }

    @Override // androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridItemInfo
    public final boolean isVisible() {
        return this.isVisible;
    }

    @Override // androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridItemInfo
    public final void place(Placeable.PlacementScope scope, androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasureContext context) {
        Object obj3;
        int i5;
        androidx.compose.ui.graphics.layer.GraphicsLayer animatedOffset;
        int layer;
        int offset;
        int i11;
        int i7;
        int reverseLayout;
        int i8;
        int $this$place_u24lambda_u246_u24lambda_u2452;
        int i3;
        long index;
        int i;
        int maxOffset;
        int i4;
        long offset2;
        int i6;
        int i9;
        int height3;
        int i16;
        int index$iv;
        Object obj;
        int i14;
        Object obj6;
        int i2;
        int i10;
        int $this$place_u24lambda_u246_u24lambda_u245;
        int i15;
        int i12;
        int vertical;
        int x-impl;
        int i17;
        androidx.compose.ui.graphics.layer.GraphicsLayer layer2;
        int $this$copy_u2d4Tuh3kE$iv;
        long l2;
        int i13;
        int height2;
        int height;
        long l;
        final Object obj2 = this;
        i11 = obj2.mainAxisLayoutSize != -1 ? 1 : 0;
        if (i11 == 0) {
        } else {
            $this$place_u24lambda_u246_u24lambda_u2452 = scope;
            i7 = 0;
            final List placeables = obj2.placeables;
            final int i24 = 0;
            index$iv = i3;
            while (index$iv < placeables.size()) {
                i3 = obj;
                int i21 = index$iv;
                i14 = 0;
                int i22 = i3;
                int i23 = 0;
                if (this.isVertical()) {
                } else {
                }
                height3 = i22.getWidth();
                minMainAxisOffset -= height3;
                int maxMainAxisOffset = obj2.maxMainAxisOffset;
                offset2 = obj2.getOffset-nOcc-ac();
                obj6 = obj3;
                LazyLayoutItemAnimation animation = obj2.animator.getAnimation(obj2.getKey(), i21);
                i16 = 0;
                if (animation != null) {
                } else {
                }
                i2 = i5;
                i10 = i7;
                i15 = $this$place_u24lambda_u246_u24lambda_u2452;
                animatedOffset = 0;
                if (obj6.getReverseLayout()) {
                } else {
                }
                layer2 = animatedOffset;
                long plus-qkQi6aY = IntOffset.plus-qkQi6aY(offset2, i23);
                if (animation == null) {
                } else {
                }
                animation.setFinalOffset--gyyYBs(plus-qkQi6aY);
                if (layer2 != null) {
                } else {
                }
                $this$place_u24lambda_u246_u24lambda_u245 = maxMainAxisOffset;
                offset = i21;
                i8 = i;
                Placeable.PlacementScope.placeRelativeWithLayer-aW-9-wM$default(i15, (Placeable)i3, plus-qkQi6aY, i, 0, 0, 6);
                index$iv++;
                obj3 = obj6;
                i5 = i2;
                i7 = i10;
                $this$place_u24lambda_u246_u24lambda_u245 = maxMainAxisOffset;
                offset = i21;
                i8 = i;
                Placeable.PlacementScope.placeRelativeWithLayer-aW-9-wM$default(i15, i3, plus-qkQi6aY, i, layer2, 0, 4);
                long l3 = offset2;
                i16 = this;
                i12 = 0;
                if (i16.isVertical()) {
                } else {
                }
                i17 = 0;
                layer2 = animatedOffset;
                $this$copy_u2d4Tuh3kE$iv = i3;
                i13 = 0;
                if (this.isVertical()) {
                } else {
                }
                height2 = $this$copy_u2d4Tuh3kE$iv.getWidth();
                i18 -= height2;
                if (i16.isVertical()) {
                } else {
                }
                reverseLayout = IntOffset.getY-impl(l3);
                offset2 = animatedOffset;
                i17 = 0;
                $this$copy_u2d4Tuh3kE$iv = l3;
                $this$place_u24lambda_u246_u24lambda_u2452 = i3;
                height2 = 0;
                if (this.isVertical()) {
                } else {
                }
                height = $this$place_u24lambda_u246_u24lambda_u2452.getWidth();
                i19 -= height;
                height = $this$place_u24lambda_u246_u24lambda_u2452.getHeight();
                height2 = $this$copy_u2d4Tuh3kE$iv.getHeight();
                layer2 = animatedOffset;
                layer = x-impl;
                i2 = i5;
                i10 = i7;
                long plus-qkQi6aY2 = IntOffset.plus-qkQi6aY(offset2, i23);
                i15 = $this$place_u24lambda_u246_u24lambda_u2452;
                if (obj2.getMainAxis--gyyYBs(offset2) <= i) {
                } else {
                }
                if (obj2.getMainAxis--gyyYBs(offset2) >= maxMainAxisOffset && obj2.getMainAxis--gyyYBs(plus-qkQi6aY2) >= maxMainAxisOffset) {
                }
                offset2 = plus-qkQi6aY2;
                animatedOffset = animation.getLayer();
                if (obj2.getMainAxis--gyyYBs(plus-qkQi6aY2) >= maxMainAxisOffset) {
                }
                animation.cancelPlacementAnimation();
                if (obj2.getMainAxis--gyyYBs(plus-qkQi6aY2) > i) {
                } else {
                }
                height3 = i22.getHeight();
            }
        }
        Object obj5 = obj3;
        int i25 = i5;
        int $this$place_u24lambda_u246 = 0;
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("position() should be called first".toString());
        throw illegalArgumentException;
    }

    @Override // androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridItemInfo
    public final void position(int mainAxis, int crossAxis, int mainAxisLayoutSize) {
        long l;
        this.mainAxisLayoutSize = mainAxisLayoutSize;
        this.minMainAxisOffset = -beforeContentPadding;
        this.maxMainAxisOffset = afterContentPadding += mainAxisLayoutSize;
        if (isVertical()) {
            l = IntOffsetKt.IntOffset(crossAxis, mainAxis);
        } else {
            l = IntOffsetKt.IntOffset(mainAxis, crossAxis);
        }
        this.offset = l;
    }

    @Override // androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridItemInfo
    public void position(int mainAxisOffset, int crossAxisOffset, int layoutWidth, int layoutHeight) {
        int i;
        i = isVertical() ? layoutHeight : layoutWidth;
        position(mainAxisOffset, crossAxisOffset, i);
    }

    @Override // androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridItemInfo
    public void setNonScrollableItem(boolean <set-?>) {
        this.nonScrollableItem = <set-?>;
    }

    @Override // androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridItemInfo
    public final void setVisible(boolean <set-?>) {
        this.isVisible = <set-?>;
    }

    @Override // androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridItemInfo
    public String toString() {
        return super.toString();
    }

    @Override // androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridItemInfo
    public final void updateMainAxisLayoutSize(int mainAxisLayoutSize) {
        this.mainAxisLayoutSize = mainAxisLayoutSize;
        this.maxMainAxisOffset = afterContentPadding += mainAxisLayoutSize;
    }
}
