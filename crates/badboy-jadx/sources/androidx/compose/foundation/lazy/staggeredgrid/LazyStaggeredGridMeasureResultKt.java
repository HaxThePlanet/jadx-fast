package androidx.compose.foundation.lazy.staggeredgrid;

import androidx.compose.foundation.lazy.layout.MutableIntervalList;
import androidx.compose.ui.unit.DensityKt;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSize.Companion;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlinx.coroutines.CoroutineScopeKt;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000 \n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0000\u001a\u0016\u0010\u0008\u001a\u0004\u0018\u00010\t*\u00020\n2\u0006\u0010\u000b\u001a\u00020\u000cH\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u001a\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\u000e\n\u0000\u0012\u0004\u0008\u0004\u0010\u0005\u001a\u0004\u0008\u0006\u0010\u0007¨\u0006\r", d2 = {"EmptyArray", "", "EmptyLazyStaggeredGridLayoutInfo", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridMeasureResult;", "getEmptyLazyStaggeredGridLayoutInfo$annotations", "()V", "getEmptyLazyStaggeredGridLayoutInfo", "()Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridMeasureResult;", "findVisibleItem", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridItemInfo;", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridLayoutInfo;", "itemIndex", "", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class LazyStaggeredGridMeasureResultKt {

    private static final int[] EmptyArray;
    private static final androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasureResult EmptyLazyStaggeredGridLayoutInfo;
    static {
        LazyStaggeredGridMeasureResultKt.EmptyArray = new int[0];
        LazyStaggeredGridMeasureResultKt.EmptyLazyStaggeredGridLayoutInfo.1 anon = new LazyStaggeredGridMeasureResultKt.EmptyLazyStaggeredGridLayoutInfo.1();
        LazyStaggeredGridSlots lazyStaggeredGridSlots = new LazyStaggeredGridSlots(LazyStaggeredGridMeasureResultKt.EmptyArray, LazyStaggeredGridMeasureResultKt.EmptyArray);
        MutableIntervalList mutableIntervalList = new MutableIntervalList();
        LazyStaggeredGridSpanProvider lazyStaggeredGridSpanProvider = new LazyStaggeredGridSpanProvider((IntervalList)mutableIntervalList);
        LazyStaggeredGridMeasureResult lazyStaggeredGridMeasureResult = new LazyStaggeredGridMeasureResult(LazyStaggeredGridMeasureResultKt.EmptyArray, LazyStaggeredGridMeasureResultKt.EmptyArray, 0, (MeasureResult)anon, 0, 0, 0, lazyStaggeredGridSlots, lazyStaggeredGridSpanProvider, DensityKt.Density$default(1065353216, 0, 2, 0), 0, CollectionsKt.emptyList(), IntSize.Companion.getZero-YbymL2g(), obj15, 0, 0, 0, 0, 0, CoroutineScopeKt.CoroutineScope((CoroutineContext)EmptyCoroutineContext.INSTANCE), 0);
        LazyStaggeredGridMeasureResultKt.EmptyLazyStaggeredGridLayoutInfo = lazyStaggeredGridMeasureResult;
    }

    public static final androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridItemInfo findVisibleItem(androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridLayoutInfo $this$findVisibleItem, int itemIndex) {
        int i;
        int i2 = 0;
        if ($this$findVisibleItem.getVisibleItemsInfo().isEmpty()) {
            return i2;
        }
        i = 0;
        if (itemIndex <= (LazyStaggeredGridItemInfo)CollectionsKt.last($this$findVisibleItem.getVisibleItemsInfo()).getIndex() && (LazyStaggeredGridItemInfo)CollectionsKt.first($this$findVisibleItem.getVisibleItemsInfo()).getIndex() <= itemIndex) {
            if ((LazyStaggeredGridItemInfo)CollectionsKt.first($this$findVisibleItem.getVisibleItemsInfo()).getIndex() <= itemIndex) {
                i = 1;
            }
        }
        if (i == 0) {
            return i2;
        }
        LazyStaggeredGridMeasureResultKt.findVisibleItem.index.1 anon = new LazyStaggeredGridMeasureResultKt.findVisibleItem.index.1(itemIndex);
        return (LazyStaggeredGridItemInfo)CollectionsKt.getOrNull($this$findVisibleItem.getVisibleItemsInfo(), CollectionsKt.binarySearch$default($this$findVisibleItem.getVisibleItemsInfo(), 0, 0, (Function1)anon, 3, 0));
    }

    public static final androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasureResult getEmptyLazyStaggeredGridLayoutInfo() {
        return LazyStaggeredGridMeasureResultKt.EmptyLazyStaggeredGridLayoutInfo;
    }

    public static void getEmptyLazyStaggeredGridLayoutInfo$annotations() {
    }
}
