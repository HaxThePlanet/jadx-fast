package androidx.compose.foundation.lazy;

import androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimation;
import androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimation.Companion;
import androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimator;
import androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem;
import androidx.compose.ui.Alignment.Horizontal;
import androidx.compose.ui.Alignment.Vertical;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.layout.Placeable.PlacementScope;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.RangesKt;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u001b\n\u0002\u0010\u0015\n\u0002\u0008\r\n\u0002\u0010\u0002\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0002\u0008\t\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0091\u0001\u0008\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u000c\u0010\u0005\u001a\u0008\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0010\u0008\u001a\u00020\t\u0012\u0008\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\u0008\u0010\u000c\u001a\u0004\u0018\u00010\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\t\u0012\u0006\u0010\u0011\u001a\u00020\u0004\u0012\u0006\u0010\u0012\u001a\u00020\u0004\u0012\u0006\u0010\u0013\u001a\u00020\u0004\u0012\u0006\u0010\u0014\u001a\u00020\u0015\u0012\u0006\u0010\u0016\u001a\u00020\u0017\u0012\u0008\u0010\u0018\u001a\u0004\u0018\u00010\u0017\u0012\u000c\u0010\u0019\u001a\u0008\u0012\u0004\u0012\u00020\u00000\u001a\u0012\u0006\u0010\u001b\u001a\u00020\u001c¢\u0006\u0002\u0010\u001dJ\u0016\u0010E\u001a\u00020F2\u0006\u0010G\u001a\u00020\u00042\u0006\u0010H\u001a\u00020\tJ\u001d\u00106\u001a\u00020\u00152\u0006\u0010\u0003\u001a\u00020\u0004H\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\u0008I\u0010JJ\u0012\u0010K\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0003\u001a\u00020\u0004H\u0016J\u0016\u0010L\u001a\u00020F2\u0006\u0010M\u001a\u00020N2\u0006\u0010O\u001a\u00020\tJ\u001e\u0010P\u001a\u00020F2\u0006\u0010Q\u001a\u00020\u00042\u0006\u0010R\u001a\u00020\u00042\u0006\u0010S\u001a\u00020\u0004J(\u0010P\u001a\u00020F2\u0006\u0010Q\u001a\u00020\u00042\u0006\u0010T\u001a\u00020\u00042\u0006\u0010R\u001a\u00020\u00042\u0006\u0010S\u001a\u00020\u0004H\u0016J\u000e\u0010U\u001a\u00020F2\u0006\u0010+\u001a\u00020\u0004J+\u0010V\u001a\u00020\u0015*\u00020\u00152\u0012\u0010W\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040XH\u0082\u0008ø\u0001\u0000¢\u0006\u0004\u0008Y\u0010ZR\u000e\u0010\u0012\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0019\u001a\u0008\u0012\u0004\u0012\u00020\u00000\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u001b\u001a\u00020\u001cX\u0096\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010 \u001a\u0004\u0008\u001e\u0010\u001fR\u0016\u0010\u0018\u001a\u0004\u0018\u00010\u0017X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008!\u0010\"R\u0011\u0010#\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008$\u0010%R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008&\u0010%R\u0014\u0010\u0008\u001a\u00020\tX\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0008\u0010'R\u0014\u0010\u0016\u001a\u00020\u0017X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008(\u0010\"R\u0014\u0010)\u001a\u00020\u0004X\u0096D¢\u0006\u0008\n\u0000\u001a\u0004\u0008*\u0010%R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010,\u001a\u00020\u0004X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008-\u0010%R\u000e\u0010.\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u00100\u001a\u00020\tX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u00081\u0010'\"\u0004\u00082\u00103R\u001e\u00105\u001a\u00020\u00042\u0006\u00104\u001a\u00020\u0004@RX\u0096\u000e¢\u0006\u0008\n\u0000\u001a\u0004\u00086\u0010%R\u000e\u00107\u001a\u000208X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u0008\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u00109\u001a\u00020\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008:\u0010%R\u000e\u0010\u0010\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010;\u001a\u00020\u0004X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008<\u0010%R\u000e\u0010\u0013\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010=\u001a\u00020\u0004X\u0096D¢\u0006\u0008\n\u0000\u001a\u0004\u0008>\u0010%R\u0010\u0010\u000c\u001a\u0004\u0018\u00010\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0014\u001a\u00020\u0015X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010 R\u0018\u0010?\u001a\u00020\u0004*\u00020\u00158BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008@\u0010AR\u0018\u0010B\u001a\u00020\u0004*\u00020\u00078BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008C\u0010D\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006[", d2 = {"Landroidx/compose/foundation/lazy/LazyListMeasuredItem;", "Landroidx/compose/foundation/lazy/LazyListItemInfo;", "Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasuredItem;", "index", "", "placeables", "", "Landroidx/compose/ui/layout/Placeable;", "isVertical", "", "horizontalAlignment", "Landroidx/compose/ui/Alignment$Horizontal;", "verticalAlignment", "Landroidx/compose/ui/Alignment$Vertical;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "reverseLayout", "beforeContentPadding", "afterContentPadding", "spacing", "visualOffset", "Landroidx/compose/ui/unit/IntOffset;", "key", "", "contentType", "animator", "Landroidx/compose/foundation/lazy/layout/LazyLayoutItemAnimator;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "(ILjava/util/List;ZLandroidx/compose/ui/Alignment$Horizontal;Landroidx/compose/ui/Alignment$Vertical;Landroidx/compose/ui/unit/LayoutDirection;ZIIIJLjava/lang/Object;Ljava/lang/Object;Landroidx/compose/foundation/lazy/layout/LazyLayoutItemAnimator;JLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getConstraints-msEJaDk", "()J", "J", "getContentType", "()Ljava/lang/Object;", "crossAxisSize", "getCrossAxisSize", "()I", "getIndex", "()Z", "getKey", "lane", "getLane", "mainAxisLayoutSize", "mainAxisSizeWithSpacings", "getMainAxisSizeWithSpacings", "maxMainAxisOffset", "minMainAxisOffset", "nonScrollableItem", "getNonScrollableItem", "setNonScrollableItem", "(Z)V", "<set-?>", "offset", "getOffset", "placeableOffsets", "", "placeablesCount", "getPlaceablesCount", "size", "getSize", "span", "getSpan", "mainAxis", "getMainAxis--gyyYBs", "(J)I", "mainAxisSize", "getMainAxisSize", "(Landroidx/compose/ui/layout/Placeable;)I", "applyScrollDelta", "", "delta", "updateAnimations", "getOffset-Bjo55l4", "(I)J", "getParentData", "place", "scope", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "isLookingAhead", "position", "mainAxisOffset", "layoutWidth", "layoutHeight", "crossAxisOffset", "updateMainAxisLayoutSize", "copy", "mainAxisMap", "Lkotlin/Function1;", "copy-4Tuh3kE", "(JLkotlin/jvm/functions/Function1;)J", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class LazyListMeasuredItem implements androidx.compose.foundation.lazy.LazyListItemInfo, LazyLayoutMeasuredItem {

    public static final int $stable = 8;
    private final int afterContentPadding;
    private final LazyLayoutItemAnimator<androidx.compose.foundation.lazy.LazyListMeasuredItem> animator;
    private final int beforeContentPadding;
    private final long constraints;
    private final Object contentType;
    private final int crossAxisSize;
    private final Alignment.Horizontal horizontalAlignment;
    private final int index;
    private final boolean isVertical;
    private final Object key;
    private final int lane;
    private final LayoutDirection layoutDirection;
    private int mainAxisLayoutSize;
    private final int mainAxisSizeWithSpacings;
    private int maxMainAxisOffset;
    private int minMainAxisOffset;
    private boolean nonScrollableItem;
    private int offset;
    private final int[] placeableOffsets;
    private final List<Placeable> placeables;
    private final boolean reverseLayout;
    private final int size;
    private final int spacing;
    private final int span;
    private final Alignment.Vertical verticalAlignment;
    private final long visualOffset;
    static {
        final int i = 8;
    }

    private LazyListMeasuredItem(int index, List<? extends Placeable> placeables, boolean isVertical, Alignment.Horizontal horizontalAlignment, Alignment.Vertical verticalAlignment, LayoutDirection layoutDirection, boolean reverseLayout, int beforeContentPadding, int afterContentPadding, int spacing, long visualOffset, Object key, Object contentType, LazyLayoutItemAnimator<androidx.compose.foundation.lazy.LazyListMeasuredItem> animator, long constraints) {
        List mainAxisSize;
        int mainAxisSize2;
        int maxCrossAxis;
        int index$iv;
        int i3;
        int i;
        int i2;
        int height;
        int height2;
        List list;
        final Object obj = this;
        super();
        obj.index = index;
        obj.placeables = placeables;
        obj.isVertical = isVertical;
        obj.horizontalAlignment = horizontalAlignment;
        obj.verticalAlignment = verticalAlignment;
        obj.layoutDirection = layoutDirection;
        obj.reverseLayout = reverseLayout;
        obj.beforeContentPadding = beforeContentPadding;
        obj.afterContentPadding = afterContentPadding;
        obj.spacing = spacing;
        obj.visualOffset = visualOffset;
        obj.key = contentType;
        obj.contentType = animator;
        obj.animator = constraints;
        obj.constraints = obj38;
        obj.span = 1;
        obj.mainAxisLayoutSize = Integer.MIN_VALUE;
        final int i15 = 0;
        mainAxisSize2 = i3;
        index$iv = i;
        maxCrossAxis = i2;
        while (index$iv < obj.placeables.size()) {
            i = i3;
            i2 = 0;
            if (obj.isVertical()) {
            } else {
            }
            height2 = (Placeable)i.getWidth();
            mainAxisSize2 += height2;
            if (!obj.isVertical()) {
            } else {
            }
            height = i.getWidth();
            maxCrossAxis = Math.max(maxCrossAxis, height);
            index$iv++;
            mainAxisSize = list;
            height = i.getHeight();
            height2 = i.getHeight();
        }
        List $this$fastForEach$iv2 = mainAxisSize;
        obj.size = mainAxisSize2;
        obj.mainAxisSizeWithSpacings = RangesKt.coerceAtLeast(size += spacing2, 0);
        obj.crossAxisSize = maxCrossAxis;
        obj.placeableOffsets = new int[size2 *= 2];
    }

    public LazyListMeasuredItem(int i, List list2, boolean z3, Alignment.Horizontal alignment$Horizontal4, Alignment.Vertical alignment$Vertical5, LayoutDirection layoutDirection6, boolean z7, int i8, int i9, int i10, long l11, Object object12, Object object13, LazyLayoutItemAnimator lazyLayoutItemAnimator14, long l15, DefaultConstructorMarker defaultConstructorMarker16) {
        super(i, list2, z3, horizontal4, vertical5, layoutDirection6, z7, i8, i9, i10, l11, object12, object13, lazyLayoutItemAnimator14, l15, defaultConstructorMarker16, obj17);
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

    @Override // androidx.compose.foundation.lazy.LazyListItemInfo
    public final void applyScrollDelta(int delta, boolean updateAnimations) {
        int placeablesCount;
        int i3;
        int i5;
        int i2;
        int animation;
        boolean $this$copy_u2d4Tuh3kE$iv;
        long l;
        Object obj;
        int i;
        int intValue;
        int mainAxis;
        int i4;
        if (getNonScrollableItem()) {
        }
        this.offset = offset += delta;
        i5 = i3;
        while (i5 < placeableOffsets.length) {
            i2 = i5;
            animation = 0;
            if (isVertical()) {
            } else {
            }
            if (!isVertical() && i2 % 2 == 0) {
            }
            i5++;
            if (i2 % 2 == 0) {
            }
            $this$copy_u2d4Tuh3kE$iv = this.placeableOffsets;
            $this$copy_u2d4Tuh3kE$iv[i2] = i7 += delta;
            if (i2 % 2 != 1) {
            } else {
            }
        }
        if (updateAnimations) {
            while (i3 < getPlaceablesCount()) {
                i2 = 0;
                animation = this.animator.getAnimation(getKey(), i3);
                if (animation != null) {
                }
                i3++;
                long rawOffset-nOcc-ac = animation.getRawOffset-nOcc-ac();
                obj = this;
                i = 0;
                if (obj.isVertical()) {
                } else {
                }
                mainAxis = 0;
                intValue = (Number)Integer.valueOf(x-impl += delta).intValue();
                if (obj.isVertical()) {
                } else {
                }
                mainAxis = IntOffset.getY-impl(rawOffset-nOcc-ac);
                animation.setRawOffset--gyyYBs(IntOffsetKt.IntOffset(intValue, mainAxis));
                i4 = 0;
                y-impl += delta;
                intValue = IntOffset.getX-impl(rawOffset-nOcc-ac);
            }
        }
    }

    @Override // androidx.compose.foundation.lazy.LazyListItemInfo
    public long getConstraints-msEJaDk() {
        return this.constraints;
    }

    @Override // androidx.compose.foundation.lazy.LazyListItemInfo
    public Object getContentType() {
        return this.contentType;
    }

    @Override // androidx.compose.foundation.lazy.LazyListItemInfo
    public final int getCrossAxisSize() {
        return this.crossAxisSize;
    }

    @Override // androidx.compose.foundation.lazy.LazyListItemInfo
    public int getIndex() {
        return this.index;
    }

    @Override // androidx.compose.foundation.lazy.LazyListItemInfo
    public Object getKey() {
        return this.key;
    }

    @Override // androidx.compose.foundation.lazy.LazyListItemInfo
    public int getLane() {
        return this.lane;
    }

    @Override // androidx.compose.foundation.lazy.LazyListItemInfo
    public int getMainAxisSizeWithSpacings() {
        return this.mainAxisSizeWithSpacings;
    }

    @Override // androidx.compose.foundation.lazy.LazyListItemInfo
    public boolean getNonScrollableItem() {
        return this.nonScrollableItem;
    }

    @Override // androidx.compose.foundation.lazy.LazyListItemInfo
    public int getOffset() {
        return this.offset;
    }

    @Override // androidx.compose.foundation.lazy.LazyListItemInfo
    public long getOffset-Bjo55l4(int index) {
        return IntOffsetKt.IntOffset(this.placeableOffsets[index * 2], this.placeableOffsets[i4++]);
    }

    @Override // androidx.compose.foundation.lazy.LazyListItemInfo
    public Object getParentData(int index) {
        return (Placeable)this.placeables.get(index).getParentData();
    }

    @Override // androidx.compose.foundation.lazy.LazyListItemInfo
    public int getPlaceablesCount() {
        return this.placeables.size();
    }

    @Override // androidx.compose.foundation.lazy.LazyListItemInfo
    public int getSize() {
        return this.size;
    }

    @Override // androidx.compose.foundation.lazy.LazyListItemInfo
    public int getSpan() {
        return this.span;
    }

    @Override // androidx.compose.foundation.lazy.LazyListItemInfo
    public boolean isVertical() {
        return this.isVertical;
    }

    @Override // androidx.compose.foundation.lazy.LazyListItemInfo
    public final void place(Placeable.PlacementScope scope, boolean isLookingAhead) {
        int $this$place_u24lambda_u24103;
        androidx.compose.ui.graphics.layer.GraphicsLayer layer;
        int i5;
        int offset;
        long targetOffset;
        int y-impl;
        long lookaheadOffset-nOcc-ac;
        int mainAxisSize;
        int animation;
        int i6;
        boolean layer3;
        long plus-qkQi6aY;
        long l;
        int i4;
        int i;
        int i2;
        int i3;
        int maxMainAxisOffset;
        LazyLayoutItemAnimation $this$place_u24lambda_u2410;
        int $this$place_u24lambda_u24102;
        long offset2;
        int vertical;
        int x-impl;
        int i7;
        androidx.compose.ui.graphics.layer.GraphicsLayer layer2;
        long offset3;
        final Object obj = this;
        $this$place_u24lambda_u24103 = scope;
        final int i12 = 0;
        mainAxisSize = 0;
        i5 = obj.mainAxisLayoutSize != Integer.MIN_VALUE ? 1 : mainAxisSize;
        if (i5 == 0) {
        } else {
            i4 = mainAxisSize;
            while (i4 < obj.getPlaceablesCount()) {
                i = i4;
                i2 = 0;
                i5 = obj.placeables.get(i);
                mainAxisSize = obj.getMainAxisSize((Placeable)i5);
                i3 = minMainAxisOffset - mainAxisSize;
                maxMainAxisOffset = obj.maxMainAxisOffset;
                targetOffset = obj.getOffset-Bjo55l4(i);
                LazyLayoutItemAnimation animation2 = obj.animator.getAnimation(obj.getKey(), i);
                int i11 = 0;
                if (animation2 != null) {
                } else {
                }
                $this$place_u24lambda_u24102 = $this$place_u24lambda_u24103;
                offset2 = targetOffset;
                layer = 0;
                if (obj.reverseLayout) {
                } else {
                }
                layer2 = layer;
                offset3 = targetOffset;
                offset = IntOffset.plus-qkQi6aY(targetOffset, mainAxisSize);
                if (!isLookingAhead) {
                }
                if (obj.isVertical()) {
                } else {
                }
                $this$place_u24lambda_u24103 = $this$place_u24lambda_u24102;
                $this$place_u24lambda_u2410 = animation2;
                if (layer2 != null) {
                } else {
                }
                Placeable.PlacementScope.placeRelativeWithLayer-aW-9-wM$default($this$place_u24lambda_u24103, i5, offset, mainAxisSize, 0, 0, 6);
                i4++;
                Placeable.PlacementScope.placeRelativeWithLayer-aW-9-wM$default($this$place_u24lambda_u24103, i5, offset, mainAxisSize, layer2, 0, 4);
                if (layer2 != null) {
                } else {
                }
                $this$place_u24lambda_u2410 = animation2;
                Placeable.PlacementScope.placeWithLayer-aW-9-wM$default($this$place_u24lambda_u24102, i5, offset, mainAxisSize, 0, 0, 6);
                $this$place_u24lambda_u2410 = animation2;
                Placeable.PlacementScope.placeWithLayer-aW-9-wM$default($this$place_u24lambda_u24102, i5, offset, mainAxisSize, layer2, 0, 4);
                if (animation2 == null) {
                } else {
                }
                animation2.setFinalOffset--gyyYBs(offset);
                layer3 = targetOffset;
                l = this;
                offset2 = 0;
                if (l.isVertical()) {
                } else {
                }
                i7 = 0;
                layer2 = layer;
                i8 -= offset3;
                if (l.isVertical()) {
                } else {
                }
                offset3 = targetOffset;
                y-impl = IntOffset.getY-impl(layer3);
                targetOffset = IntOffsetKt.IntOffset(layer, y-impl);
                i7 = 0;
                offset3 = targetOffset;
                i10 -= mainAxisSize;
                layer2 = layer;
                layer = x-impl;
                if (isLookingAhead) {
                } else {
                }
                if (!IntOffset.equals-impl0(animation2.getLookaheadOffset-nOcc-ac(), l)) {
                } else {
                }
                lookaheadOffset-nOcc-ac = l2;
                plus-qkQi6aY = IntOffset.plus-qkQi6aY(lookaheadOffset-nOcc-ac, mainAxisSize);
                $this$place_u24lambda_u24102 = $this$place_u24lambda_u24103;
                if (obj.getMainAxis--gyyYBs(lookaheadOffset-nOcc-ac) <= i3) {
                } else {
                }
                if (obj.getMainAxis--gyyYBs(lookaheadOffset-nOcc-ac) >= maxMainAxisOffset && obj.getMainAxis--gyyYBs(plus-qkQi6aY) >= maxMainAxisOffset) {
                }
                targetOffset = offset2;
                layer = animation2.getLayer();
                if (obj.getMainAxis--gyyYBs(plus-qkQi6aY) >= maxMainAxisOffset) {
                }
                animation2.cancelPlacementAnimation();
                if (obj.getMainAxis--gyyYBs(plus-qkQi6aY) > i3) {
                } else {
                }
                lookaheadOffset-nOcc-ac = animation2.getLookaheadOffset-nOcc-ac();
                animation2.setLookaheadOffset--gyyYBs(targetOffset);
                $this$place_u24lambda_u24102 = $this$place_u24lambda_u24103;
            }
        }
        int i9 = 0;
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("position() should be called first".toString());
        throw illegalArgumentException;
    }

    @Override // androidx.compose.foundation.lazy.LazyListItemInfo
    public final void position(int mainAxisOffset, int layoutWidth, int layoutHeight) {
        int i;
        int i5;
        int i4;
        int index$iv;
        int mainAxisOffset2;
        Object obj;
        Object obj2;
        int i6;
        int i7;
        int i3;
        int height;
        int i2;
        int width;
        LayoutDirection layoutDirection;
        final Object obj3 = this;
        i = mainAxisOffset;
        obj3.offset = i;
        i4 = obj3.isVertical() ? layoutHeight : layoutWidth;
        obj3.mainAxisLayoutSize = i4;
        List placeables = obj3.placeables;
        int i15 = 0;
        index$iv = 0;
        mainAxisOffset2 = i;
        while (index$iv < placeables.size()) {
            obj2 = obj;
            i7 = 0;
            i3 = i6 * 2;
            int i11 = layoutWidth;
            obj3.placeableOffsets[i3] = mainAxisOffset2;
            Alignment.Vertical verticalAlignment = obj3.verticalAlignment;
            obj3.placeableOffsets[i3 + 1] = verticalAlignment.align((Placeable)obj2.getHeight(), layoutHeight);
            mainAxisOffset2 += height;
            index$iv++;
            i = mainAxisOffset;
            Alignment.Horizontal horizontalAlignment = obj3.horizontalAlignment;
            obj3.placeableOffsets[i3] = horizontalAlignment.align(obj2.getWidth(), layoutWidth, obj3.layoutDirection);
            obj3.placeableOffsets[i3 + 1] = mainAxisOffset2;
            mainAxisOffset2 += height;
            i5 = layoutHeight;
        }
        int i8 = layoutHeight;
        obj3.minMainAxisOffset = -$this$fastForEachIndexed$iv;
        obj3.maxMainAxisOffset = mainAxisLayoutSize += afterContentPadding;
    }

    @Override // androidx.compose.foundation.lazy.LazyListItemInfo
    public void position(int mainAxisOffset, int crossAxisOffset, int layoutWidth, int layoutHeight) {
        position(mainAxisOffset, layoutWidth, layoutHeight);
    }

    @Override // androidx.compose.foundation.lazy.LazyListItemInfo
    public void setNonScrollableItem(boolean <set-?>) {
        this.nonScrollableItem = <set-?>;
    }

    @Override // androidx.compose.foundation.lazy.LazyListItemInfo
    public final void updateMainAxisLayoutSize(int mainAxisLayoutSize) {
        this.mainAxisLayoutSize = mainAxisLayoutSize;
        this.maxMainAxisOffset = afterContentPadding += mainAxisLayoutSize;
    }
}
