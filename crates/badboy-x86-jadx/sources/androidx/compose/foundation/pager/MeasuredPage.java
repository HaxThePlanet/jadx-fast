package androidx.compose.foundation.pager;

import androidx.compose.foundation.gestures.Orientation;
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

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\r\n\u0002\u0010\u0015\n\u0002\u0008\u0006\n\u0002\u0010\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008\u0000\u0018\u00002\u00020\u0001B_\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u000c\u0010\u0005\u001a\u0008\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0010\u0008\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\u000c\u001a\u00020\r\u0012\u0008\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\u0008\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\u0006\u0010\u0014\u001a\u00020\u0015¢\u0006\u0002\u0010\u0016J\u000e\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\u0003J\u001d\u0010!\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\u0008,\u0010-J\u000e\u0010.\u001a\u00020*2\u0006\u0010/\u001a\u000200J\u001e\u00101\u001a\u00020*2\u0006\u0010 \u001a\u00020\u00032\u0006\u00102\u001a\u00020\u00032\u0006\u00103\u001a\u00020\u0003J+\u00104\u001a\u00020\t*\u00020\t2\u0012\u00105\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u000306H\u0082\u0008ø\u0001\u0000¢\u0006\u0004\u00087\u00108R\u0011\u0010\u0017\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0018\u0010\u0019R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001a\u0010\u0019R\u000e\u0010\u001b\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\u00020\u000bX\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001c\u0010\u001dR\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010 \u001a\u00020\u00032\u0006\u0010\u001f\u001a\u00020\u0003@RX\u0096\u000e¢\u0006\u0008\n\u0000\u001a\u0004\u0008!\u0010\u0019R\u000e\u0010\"\u001a\u00020#X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u0008\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008$\u0010\u0019R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0008\u001a\u00020\tX\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010%R\u0018\u0010&\u001a\u00020\u0003*\u00020\u00078BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008'\u0010(\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u00069", d2 = {"Landroidx/compose/foundation/pager/MeasuredPage;", "Landroidx/compose/foundation/pager/PageInfo;", "index", "", "size", "placeables", "", "Landroidx/compose/ui/layout/Placeable;", "visualOffset", "Landroidx/compose/ui/unit/IntOffset;", "key", "", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "horizontalAlignment", "Landroidx/compose/ui/Alignment$Horizontal;", "verticalAlignment", "Landroidx/compose/ui/Alignment$Vertical;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "reverseLayout", "", "(IILjava/util/List;JLjava/lang/Object;Landroidx/compose/foundation/gestures/Orientation;Landroidx/compose/ui/Alignment$Horizontal;Landroidx/compose/ui/Alignment$Vertical;Landroidx/compose/ui/unit/LayoutDirection;ZLkotlin/jvm/internal/DefaultConstructorMarker;)V", "crossAxisSize", "getCrossAxisSize", "()I", "getIndex", "isVertical", "getKey", "()Ljava/lang/Object;", "mainAxisLayoutSize", "<set-?>", "offset", "getOffset", "placeableOffsets", "", "getSize", "J", "mainAxisSize", "getMainAxisSize", "(Landroidx/compose/ui/layout/Placeable;)I", "applyScrollDelta", "", "delta", "getOffset-Bjo55l4", "(I)J", "place", "scope", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "position", "layoutWidth", "layoutHeight", "copy", "mainAxisMap", "Lkotlin/Function1;", "copy-4Tuh3kE", "(JLkotlin/jvm/functions/Function1;)J", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class MeasuredPage implements androidx.compose.foundation.pager.PageInfo {

    public static final int $stable = 8;
    private final int crossAxisSize;
    private final Alignment.Horizontal horizontalAlignment;
    private final int index;
    private final boolean isVertical;
    private final Object key;
    private final LayoutDirection layoutDirection;
    private int mainAxisLayoutSize;
    private int offset;
    private final int[] placeableOffsets;
    private final List<Placeable> placeables;
    private final boolean reverseLayout;
    private final int size;
    private final Alignment.Vertical verticalAlignment;
    private final long visualOffset;
    static {
        final int i = 8;
    }

    private MeasuredPage(int index, int size, List<? extends Placeable> placeables, long visualOffset, Object key, Orientation orientation, Alignment.Horizontal horizontalAlignment, Alignment.Vertical verticalAlignment, LayoutDirection layoutDirection, boolean reverseLayout) {
        int size2;
        int height;
        int i3;
        int maxCrossAxis;
        int index$iv;
        Object obj2;
        Object obj;
        int i2;
        int i;
        final Object obj3 = this;
        super();
        obj3.index = index;
        obj3.size = size;
        obj3.placeables = placeables;
        obj3.visualOffset = visualOffset;
        obj3.key = orientation;
        obj3.horizontalAlignment = verticalAlignment;
        obj3.verticalAlignment = layoutDirection;
        obj3.layoutDirection = reverseLayout;
        obj3.reverseLayout = obj31;
        i3 = horizontalAlignment == Orientation.Vertical ? 1 : 0;
        obj3.isVertical = i3;
        maxCrossAxis = 0;
        final List placeables3 = obj3.placeables;
        final int i9 = 0;
        index$iv = 0;
        size2 = placeables3.size();
        while (index$iv < size2) {
            obj = obj2;
            i2 = 0;
            if (!obj3.isVertical) {
            } else {
            }
            height = (Placeable)obj.getWidth();
            maxCrossAxis = i7;
            index$iv++;
            size2 = i;
            height = obj.getHeight();
        }
        obj3.crossAxisSize = maxCrossAxis;
        obj3.placeableOffsets = new int[size3 *= 2];
        obj3.mainAxisLayoutSize = Integer.MIN_VALUE;
    }

    public MeasuredPage(int i, int i2, List list3, long l4, Object object5, Orientation orientation6, Alignment.Horizontal alignment$Horizontal7, Alignment.Vertical alignment$Vertical8, LayoutDirection layoutDirection9, boolean z10, DefaultConstructorMarker defaultConstructorMarker11) {
        super(i, i2, list3, l4, object5, orientation6, horizontal7, vertical8, layoutDirection9, z10, defaultConstructorMarker11);
    }

    private final long copy-4Tuh3kE(long $this$copy_u2d4Tuh3kE, Function1<? super Integer, Integer> mainAxisMap) {
        int intValue;
        int intValue2;
        final int i = 0;
        if (this.isVertical) {
            intValue = IntOffset.getX-impl($this$copy_u2d4Tuh3kE);
        } else {
            intValue = (Number)obj6.invoke(Integer.valueOf(IntOffset.getX-impl($this$copy_u2d4Tuh3kE))).intValue();
        }
        if (this.isVertical) {
            intValue2 = (Number)obj6.invoke(Integer.valueOf(IntOffset.getY-impl($this$copy_u2d4Tuh3kE))).intValue();
        } else {
            intValue2 = IntOffset.getY-impl($this$copy_u2d4Tuh3kE);
        }
        return IntOffsetKt.IntOffset(intValue, intValue2);
    }

    private final int getMainAxisSize(Placeable $this$mainAxisSize) {
        int height;
        if (this.isVertical) {
            height = $this$mainAxisSize.getHeight();
        } else {
            height = $this$mainAxisSize.getWidth();
        }
        return height;
    }

    private final long getOffset-Bjo55l4(int index) {
        return IntOffsetKt.IntOffset(this.placeableOffsets[index * 2], this.placeableOffsets[i4++]);
    }

    @Override // androidx.compose.foundation.pager.PageInfo
    public final void applyScrollDelta(int delta) {
        int i2;
        int i;
        int i3;
        int[] placeableOffsets;
        int i4;
        this.offset = offset += delta;
        i2 = 0;
        while (i2 < placeableOffsets2.length) {
            i = i2;
            i3 = 0;
            if (this.isVertical) {
            } else {
            }
            if (!this.isVertical && i % 2 == 0) {
            }
            i2++;
            if (i % 2 == 0) {
            }
            placeableOffsets = this.placeableOffsets;
            placeableOffsets[i] = i6 += delta;
            if (i % 2 != 1) {
            } else {
            }
        }
    }

    @Override // androidx.compose.foundation.pager.PageInfo
    public final int getCrossAxisSize() {
        return this.crossAxisSize;
    }

    @Override // androidx.compose.foundation.pager.PageInfo
    public int getIndex() {
        return this.index;
    }

    @Override // androidx.compose.foundation.pager.PageInfo
    public Object getKey() {
        return this.key;
    }

    @Override // androidx.compose.foundation.pager.PageInfo
    public int getOffset() {
        return this.offset;
    }

    @Override // androidx.compose.foundation.pager.PageInfo
    public final int getSize() {
        return this.size;
    }

    @Override // androidx.compose.foundation.pager.PageInfo
    public final void place(Placeable.PlacementScope scope) {
        int $this$place_u24lambda_u247;
        int i3;
        List placeables;
        int offset;
        long offset2;
        int i4;
        boolean $this$copy_u2d4Tuh3kE$iv;
        long l;
        int i;
        int i5;
        int i7;
        int i6;
        int i2;
        int mainAxisOffset;
        int i8;
        int $this$place_u24lambda_u2472;
        int mainAxisSize;
        int mainAxisSize2;
        final Object obj = this;
        $this$place_u24lambda_u247 = scope;
        final int i13 = 0;
        final int i12 = 0;
        i3 = obj.mainAxisLayoutSize != Integer.MIN_VALUE ? 1 : i12;
        if (i3 == 0) {
        } else {
            i7 = i12;
            while (i7 < obj.placeables.size()) {
                i6 = i7;
                i2 = 0;
                placeables = obj.placeables.get(i6);
                if (obj.reverseLayout) {
                } else {
                }
                $this$place_u24lambda_u2472 = $this$place_u24lambda_u247;
                offset = IntOffset.plus-qkQi6aY(offset2, i12);
                if (obj.isVertical) {
                } else {
                }
                Placeable.PlacementScope.placeRelativeWithLayer-aW-9-wM$default($this$place_u24lambda_u2472, (Placeable)placeables, offset, i12, 0, 0, 6);
                i7++;
                Placeable.PlacementScope.placeWithLayer-aW-9-wM$default($this$place_u24lambda_u2472, placeables, offset, i12, 0, 0, 6);
                long l2 = offset2;
                i = this;
                i5 = 0;
                if (i.isVertical) {
                } else {
                }
                i8 = 0;
                $this$place_u24lambda_u2472 = $this$place_u24lambda_u247;
                mainAxisOffset = $this$place_u24lambda_u247;
                if (i.isVertical) {
                } else {
                }
                $this$place_u24lambda_u247 = IntOffset.getY-impl(l2);
                offset2 = $this$copy_u2d4Tuh3kE$iv;
                i8 = 0;
                i10 -= mainAxisSize2;
                mainAxisOffset = IntOffset.getX-impl(l2);
                $this$place_u24lambda_u2472 = $this$place_u24lambda_u247;
            }
        }
        int i11 = 0;
        IllegalArgumentException $i$a$RequireMeasuredPage$place$1$1 = new IllegalArgumentException("position() should be called first".toString());
        throw $i$a$RequireMeasuredPage$place$1$1;
    }

    @Override // androidx.compose.foundation.pager.PageInfo
    public final void position(int offset, int layoutWidth, int layoutHeight) {
        Object obj2;
        int i4;
        int i6;
        int i5;
        int i8;
        int mainAxisOffset;
        int index$iv;
        Object obj;
        Object obj3;
        int i3;
        int i2;
        int i;
        int height;
        int i7;
        int width;
        LayoutDirection layoutDirection;
        obj2 = this;
        obj2.offset = offset;
        i8 = obj2.isVertical ? layoutHeight : layoutWidth;
        obj2.mainAxisLayoutSize = i8;
        int i13 = 0;
        mainAxisOffset = offset;
        final List placeables = obj2.placeables;
        final int i14 = 0;
        index$iv = 0;
        while (index$iv < placeables.size()) {
            obj3 = obj;
            i2 = 0;
            i = i3 * 2;
            i5 = layoutWidth;
            obj2.placeableOffsets[i] = mainAxisOffset;
            Alignment.Vertical verticalAlignment = obj2.verticalAlignment;
            obj2.placeableOffsets[i + 1] = verticalAlignment.align((Placeable)obj3.getHeight(), layoutHeight);
            mainAxisOffset += height;
            index$iv++;
            obj2 = this;
            i6 = offset;
            Alignment.Horizontal horizontalAlignment = obj2.horizontalAlignment;
            obj2.placeableOffsets[i] = horizontalAlignment.align(obj3.getWidth(), layoutWidth, obj2.layoutDirection);
            obj2.placeableOffsets[i + 1] = mainAxisOffset;
            mainAxisOffset += height;
            i4 = layoutHeight;
        }
        int i11 = layoutWidth;
        int i9 = layoutHeight;
    }
}
