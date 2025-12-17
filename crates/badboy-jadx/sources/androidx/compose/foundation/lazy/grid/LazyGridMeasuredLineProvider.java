package androidx.compose.foundation.lazy.grid;

import androidx.compose.foundation.lazy.layout.LazyLayoutKeyIndexMap;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Constraints.Companion;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.ranges.RangesKt;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0008\u0006\u0008 \u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\u0008\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\u000c¢\u0006\u0002\u0010\rJ%\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u0007H\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\u0008\u0016\u0010\u0017J9\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00072\u000c\u0010\u001b\u001a\u0008\u0012\u0004\u0012\u00020\u001d0\u001c2\u000c\u0010\u001e\u001a\u0008\u0012\u0004\u0012\u00020 0\u001f2\u0006\u0010!\u001a\u00020\u0007H&¢\u0006\u0002\u0010\"J\u000e\u0010#\u001a\u00020\u00192\u0006\u0010$\u001a\u00020\u0007J\u000e\u0010%\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u0007R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u000e\u001a\u00020\u000f8F¢\u0006\u0006\u001a\u0004\u0008\u0010\u0010\u0011R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0008\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u000cX\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0002\u0008!\n\u0005\u0008¡\u001e0\u0001¨\u0006&", d2 = {"Landroidx/compose/foundation/lazy/grid/LazyGridMeasuredLineProvider;", "", "isVertical", "", "slots", "Landroidx/compose/foundation/lazy/grid/LazyGridSlots;", "gridItemsCount", "", "spaceBetweenLines", "measuredItemProvider", "Landroidx/compose/foundation/lazy/grid/LazyGridMeasuredItemProvider;", "spanLayoutProvider", "Landroidx/compose/foundation/lazy/grid/LazyGridSpanLayoutProvider;", "(ZLandroidx/compose/foundation/lazy/grid/LazyGridSlots;IILandroidx/compose/foundation/lazy/grid/LazyGridMeasuredItemProvider;Landroidx/compose/foundation/lazy/grid/LazyGridSpanLayoutProvider;)V", "keyIndexMap", "Landroidx/compose/foundation/lazy/layout/LazyLayoutKeyIndexMap;", "getKeyIndexMap", "()Landroidx/compose/foundation/lazy/layout/LazyLayoutKeyIndexMap;", "childConstraints", "Landroidx/compose/ui/unit/Constraints;", "startSlot", "span", "childConstraints-JhjzzOo$foundation_release", "(II)J", "createLine", "Landroidx/compose/foundation/lazy/grid/LazyGridMeasuredLine;", "index", "items", "", "Landroidx/compose/foundation/lazy/grid/LazyGridMeasuredItem;", "spans", "", "Landroidx/compose/foundation/lazy/grid/GridItemSpan;", "mainAxisSpacing", "(I[Landroidx/compose/foundation/lazy/grid/LazyGridMeasuredItem;Ljava/util/List;I)Landroidx/compose/foundation/lazy/grid/LazyGridMeasuredLine;", "getAndMeasure", "lineIndex", "spanOf", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public abstract class LazyGridMeasuredLineProvider {

    public static final int $stable = 8;
    private final int gridItemsCount;
    private final boolean isVertical;
    private final androidx.compose.foundation.lazy.grid.LazyGridMeasuredItemProvider measuredItemProvider;
    private final androidx.compose.foundation.lazy.grid.LazyGridSlots slots;
    private final int spaceBetweenLines;
    private final androidx.compose.foundation.lazy.grid.LazyGridSpanLayoutProvider spanLayoutProvider;
    static {
        final int i = 8;
    }

    public LazyGridMeasuredLineProvider(boolean isVertical, androidx.compose.foundation.lazy.grid.LazyGridSlots slots, int gridItemsCount, int spaceBetweenLines, androidx.compose.foundation.lazy.grid.LazyGridMeasuredItemProvider measuredItemProvider, androidx.compose.foundation.lazy.grid.LazyGridSpanLayoutProvider spanLayoutProvider) {
        super();
        this.isVertical = isVertical;
        this.slots = slots;
        this.gridItemsCount = gridItemsCount;
        this.spaceBetweenLines = spaceBetweenLines;
        this.measuredItemProvider = measuredItemProvider;
        this.spanLayoutProvider = spanLayoutProvider;
    }

    public final long childConstraints-JhjzzOo$foundation_release(int startSlot, int span) {
        int i2;
        int i;
        long fixedHeight-OenEA2s;
        int i3;
        int i4 = 1;
        if (span == i4) {
            i2 = this.slots.getSizes()[startSlot];
        } else {
            i7 -= i4;
            i6 -= i3;
        }
        int coerceAtLeast = RangesKt.coerceAtLeast(i2, 0);
        if (this.isVertical) {
            fixedHeight-OenEA2s = Constraints.Companion.fixedWidth-OenEA2s(coerceAtLeast);
        } else {
            fixedHeight-OenEA2s = Constraints.Companion.fixedHeight-OenEA2s(coerceAtLeast);
        }
        return fixedHeight-OenEA2s;
    }

    public abstract androidx.compose.foundation.lazy.grid.LazyGridMeasuredLine createLine(int i, androidx.compose.foundation.lazy.grid.LazyGridMeasuredItem[] lazyGridMeasuredItem2Arr2, List<androidx.compose.foundation.lazy.grid.GridItemSpan> list3, int i4);

    public final androidx.compose.foundation.lazy.grid.LazyGridMeasuredLine getAndMeasure(int lineIndex) {
        int i;
        int spaceBetweenLines;
        int andMeasure-m8Kt_7k;
        int i3;
        int it;
        int i2;
        long childConstraints-JhjzzOo$foundation_release;
        int startSlot;
        int currentLineSpan-impl;
        androidx.compose.foundation.lazy.grid.LazyGridSpanLayoutProvider.LineConfiguration lineConfiguration = this.spanLayoutProvider.getLineConfiguration(lineIndex);
        int size = lineConfiguration.getSpans().size();
        if (size != 0) {
            if (firstItemIndex2 += size == this.gridItemsCount) {
                spaceBetweenLines = i;
            } else {
                spaceBetweenLines = this.spaceBetweenLines;
            }
        } else {
        }
        final int i6 = spaceBetweenLines;
        final androidx.compose.foundation.lazy.grid.LazyGridMeasuredItem[] arr = new LazyGridMeasuredItem[size];
        startSlot = andMeasure-m8Kt_7k;
        while (i < size) {
            currentLineSpan-impl = GridItemSpan.getCurrentLineSpan-impl((GridItemSpan)lineConfiguration.getSpans().get(i).unbox-impl());
            andMeasure-m8Kt_7k = this.measuredItemProvider.getAndMeasure-m8Kt_7k(firstItemIndex + i, childConstraints-JhjzzOo$foundation_release(startSlot, currentLineSpan-impl), obj7, startSlot, currentLineSpan-impl);
            int i4 = andMeasure-m8Kt_7k;
            i2 = 0;
            startSlot += currentLineSpan-impl;
            it = Unit.INSTANCE;
            arr[i] = andMeasure-m8Kt_7k;
            i++;
        }
        return createLine(lineIndex, arr, lineConfiguration.getSpans(), i6);
    }

    public final LazyLayoutKeyIndexMap getKeyIndexMap() {
        return this.measuredItemProvider.getKeyIndexMap();
    }

    public final int spanOf(int index) {
        return this.spanLayoutProvider.spanOf(index, this.spanLayoutProvider.getSlotsPerLine());
    }
}
