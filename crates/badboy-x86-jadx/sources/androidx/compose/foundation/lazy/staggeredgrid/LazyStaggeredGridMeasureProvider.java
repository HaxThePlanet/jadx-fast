package androidx.compose.foundation.lazy.staggeredgrid;

import androidx.compose.foundation.lazy.layout.LazyLayoutKeyIndexMap;
import androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScope;
import androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem;
import androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItemProvider;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Constraints.Companion;
import java.util.List;
import kotlin.Metadata;
import kotlin.ranges.RangesKt;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0007\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0005\u0008 \u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00020\u0001B%\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0008\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ%\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0013H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\u0008\u0015\u0010\u0016JR\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u001a\u001a\u00020\u001b2\u0008\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\u000c\u0010\u001d\u001a\u0008\u0012\u0004\u0012\u00020\u001f0\u001e2\u0006\u0010 \u001a\u00020\u0011H&ø\u0001\u0001¢\u0006\u0004\u0008!\u0010\"J \u0010#\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020$ø\u0001\u0001¢\u0006\u0004\u0008%\u0010&J2\u0010#\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010 \u001a\u00020\u0011H\u0016ø\u0001\u0001¢\u0006\u0004\u0008'\u0010(R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u000c\u001a\u00020\r8F¢\u0006\u0006\u001a\u0004\u0008\u000e\u0010\u000fR\u000e\u0010\u0007\u001a\u00020\u0008X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0002\u0008!\n\u0005\u0008¡\u001e0\u0001¨\u0006)", d2 = {"Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridMeasureProvider;", "Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasuredItemProvider;", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridMeasuredItem;", "isVertical", "", "itemProvider", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridItemProvider;", "measureScope", "Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasureScope;", "resolvedSlots", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridSlots;", "(ZLandroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridItemProvider;Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasureScope;Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridSlots;)V", "keyIndexMap", "Landroidx/compose/foundation/lazy/layout/LazyLayoutKeyIndexMap;", "getKeyIndexMap", "()Landroidx/compose/foundation/lazy/layout/LazyLayoutKeyIndexMap;", "childConstraints", "Landroidx/compose/ui/unit/Constraints;", "slot", "", "span", "childConstraints-JhjzzOo", "(II)J", "createItem", "index", "lane", "key", "", "contentType", "placeables", "", "Landroidx/compose/ui/layout/Placeable;", "constraints", "createItem-pitSLOA", "(IIILjava/lang/Object;Ljava/lang/Object;Ljava/util/List;J)Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridMeasuredItem;", "getAndMeasure", "Landroidx/compose/foundation/lazy/staggeredgrid/SpanRange;", "getAndMeasure-jy6DScQ", "(IJ)Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridMeasuredItem;", "getAndMeasure--hBUhpc", "(IIIJ)Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridMeasuredItem;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public abstract class LazyStaggeredGridMeasureProvider implements LazyLayoutMeasuredItemProvider<androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasuredItem> {

    public static final int $stable = 8;
    private final boolean isVertical;
    private final androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridItemProvider itemProvider;
    private final LazyLayoutMeasureScope measureScope;
    private final androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridSlots resolvedSlots;
    static {
        final int i = 8;
    }

    public LazyStaggeredGridMeasureProvider(boolean isVertical, androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridItemProvider itemProvider, LazyLayoutMeasureScope measureScope, androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridSlots resolvedSlots) {
        super();
        this.isVertical = isVertical;
        this.itemProvider = itemProvider;
        this.measureScope = measureScope;
        this.resolvedSlots = resolvedSlots;
    }

    private final long childConstraints-JhjzzOo(int slot, int span) {
        int end;
        int i3;
        long fixedHeight-OenEA2s;
        int i2;
        int i;
        int i4 = 1;
        if (span == i4) {
            end = this.resolvedSlots.getSizes()[slot];
        } else {
            i7 -= i4;
            end = i;
        }
        if (this.isVertical) {
            fixedHeight-OenEA2s = Constraints.Companion.fixedWidth-OenEA2s(end);
        } else {
            fixedHeight-OenEA2s = Constraints.Companion.fixedHeight-OenEA2s(end);
        }
        return fixedHeight-OenEA2s;
    }

    public abstract androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasuredItem createItem-pitSLOA(int i, int i2, int i3, Object object4, Object object5, List<? extends Placeable> list6, long l7);

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItemProvider
    public LazyLayoutMeasuredItem getAndMeasure--hBUhpc(int index, int lane, int span, long constraints) {
        return (LazyLayoutMeasuredItem)getAndMeasure--hBUhpc(index, lane, span, constraints);
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItemProvider
    public androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasuredItem getAndMeasure--hBUhpc(int index, int lane, int span, long constraints) {
        return this.createItem-pitSLOA(index, lane, span, this.itemProvider.getKey(index), this.itemProvider.getContentType(index), this.measureScope.measure-0kLqBqw(index, constraints), constraints);
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItemProvider
    public final androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasuredItem getAndMeasure-jy6DScQ(int index, long span) {
        final int length = sizes.length;
        int i = 0;
        int i9 = 0;
        int i12 = 32;
        int coerceAtMost = RangesKt.coerceAtMost((int)i15, length + -1);
        int i3 = 0;
        int i7 = 0;
        int i16 = span;
        int i10 = 0;
        int i8 = 0;
        final int i14 = 0;
        int coerceAtMost2 = RangesKt.coerceAtMost($i$f$unpackInt2 -= i13, length - coerceAtMost);
        long childConstraints-JhjzzOo = childConstraints-JhjzzOo(coerceAtMost, coerceAtMost2);
        return this.createItem-pitSLOA(index, coerceAtMost, coerceAtMost2, this.itemProvider.getKey(index), this.itemProvider.getContentType(index), this.measureScope.measure-0kLqBqw(index, childConstraints-JhjzzOo), childConstraints-JhjzzOo);
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItemProvider
    public final LazyLayoutKeyIndexMap getKeyIndexMap() {
        return this.itemProvider.getKeyIndexMap();
    }
}
