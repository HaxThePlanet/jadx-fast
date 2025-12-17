package androidx.compose.foundation.lazy.grid;

import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.ranges.RangesKt;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0012\u0008\u0000\u0018\u00002\u00020\u0001BA\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000c\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0008\u0012\u000c\u0010\t\u001a\u0008\u0012\u0004\u0012\u00020\u000b0\n\u0012\u0006\u0010\u000c\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u0003¢\u0006\u0002\u0010\u000fJ\u0006\u0010\u0019\u001a\u00020\rJ)\u0010\u001a\u001a\u0008\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\u0003¢\u0006\u0002\u0010\u001eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0010\u0010\u0011R\u000e\u0010\u000c\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\u0008\u0012\u0010\u0013R\u0011\u0010\u0015\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0016\u0010\u0011R\u0011\u0010\u0017\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0018\u0010\u0011R\u000e\u0010\u000e\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0008X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u0008\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f", d2 = {"Landroidx/compose/foundation/lazy/grid/LazyGridMeasuredLine;", "", "index", "", "items", "", "Landroidx/compose/foundation/lazy/grid/LazyGridMeasuredItem;", "slots", "Landroidx/compose/foundation/lazy/grid/LazyGridSlots;", "spans", "", "Landroidx/compose/foundation/lazy/grid/GridItemSpan;", "isVertical", "", "mainAxisSpacing", "(I[Landroidx/compose/foundation/lazy/grid/LazyGridMeasuredItem;Landroidx/compose/foundation/lazy/grid/LazyGridSlots;Ljava/util/List;ZI)V", "getIndex", "()I", "getItems", "()[Landroidx/compose/foundation/lazy/grid/LazyGridMeasuredItem;", "[Landroidx/compose/foundation/lazy/grid/LazyGridMeasuredItem;", "mainAxisSize", "getMainAxisSize", "mainAxisSizeWithSpacings", "getMainAxisSizeWithSpacings", "isEmpty", "position", "offset", "layoutWidth", "layoutHeight", "(III)[Landroidx/compose/foundation/lazy/grid/LazyGridMeasuredItem;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class LazyGridMeasuredLine {

    public static final int $stable = 8;
    private final int index;
    private final boolean isVertical;
    private final androidx.compose.foundation.lazy.grid.LazyGridMeasuredItem[] items;
    private final int mainAxisSize;
    private final int mainAxisSizeWithSpacings;
    private final int mainAxisSpacing;
    private final androidx.compose.foundation.lazy.grid.LazyGridSlots slots;
    private final List<androidx.compose.foundation.lazy.grid.GridItemSpan> spans;
    static {
        final int i = 8;
    }

    public LazyGridMeasuredLine(int index, androidx.compose.foundation.lazy.grid.LazyGridMeasuredItem[] items, androidx.compose.foundation.lazy.grid.LazyGridSlots slots, List<androidx.compose.foundation.lazy.grid.GridItemSpan> spans, boolean isVertical, int mainAxisSpacing) {
        int maxMainAxis;
        int mainAxisSize;
        int i;
        androidx.compose.foundation.lazy.grid.LazyGridMeasuredItem lazyGridMeasuredItem;
        androidx.compose.foundation.lazy.grid.LazyGridMeasuredItem lazyGridMeasuredItem2;
        int i2;
        final Object obj = this;
        super();
        obj.index = index;
        obj.items = items;
        obj.slots = slots;
        obj.spans = spans;
        obj.isVertical = isVertical;
        obj.mainAxisSpacing = mainAxisSpacing;
        maxMainAxis = 0;
        androidx.compose.foundation.lazy.grid.LazyGridMeasuredItem[] items2 = obj.items;
        int i6 = 0;
        i = 0;
        while (i < items2.length) {
            i2 = 0;
            maxMainAxis = Math.max(maxMainAxis, items2[i].getMainAxisSize());
            i++;
        }
        obj.mainAxisSize = maxMainAxis;
        obj.mainAxisSizeWithSpacings = RangesKt.coerceAtLeast(mainAxisSpacing2 += maxMainAxis, 0);
    }

    public final int getIndex() {
        return this.index;
    }

    public final androidx.compose.foundation.lazy.grid.LazyGridMeasuredItem[] getItems() {
        return this.items;
    }

    public final int getMainAxisSize() {
        return this.mainAxisSize;
    }

    public final int getMainAxisSizeWithSpacings() {
        return this.mainAxisSizeWithSpacings;
    }

    public final boolean isEmpty() {
        int i;
        i = items.length == 0 ? 1 : 0;
        return i;
    }

    public final androidx.compose.foundation.lazy.grid.LazyGridMeasuredItem[] position(int offset, int layoutWidth, int layoutHeight) {
        int usedSpan;
        int i5;
        int i3;
        androidx.compose.foundation.lazy.grid.LazyGridMeasuredItem lazyGridMeasuredItem;
        int i4;
        androidx.compose.foundation.lazy.grid.LazyGridMeasuredItem lazyGridMeasuredItem2;
        Unit iNSTANCE;
        int isVertical;
        int isVertical2;
        long l;
        int i7;
        int i;
        int i9;
        int i2;
        int i6;
        int currentLineSpan-impl;
        int i8;
        final Object obj = this;
        usedSpan = 0;
        androidx.compose.foundation.lazy.grid.LazyGridMeasuredItem[] items = obj.items;
        final int i10 = 0;
        i5 = 0;
        i3 = 0;
        while (i3 < items.length) {
            i6 = 0;
            i8 = usedSpan;
            if (obj.isVertical) {
            } else {
            }
            i9 = i8;
            if (obj.isVertical) {
            } else {
            }
            i2 = isVertical2;
            items[i3].position(offset, obj.slots.getPositions()[i8], layoutWidth, layoutHeight, i9, i2);
            iNSTANCE = Unit.INSTANCE;
            l = 0;
            usedSpan += currentLineSpan-impl;
            i3++;
            i5 = i4;
            i2 = i8;
            i9 = isVertical;
        }
        return obj.items;
    }
}
