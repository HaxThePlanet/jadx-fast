package androidx.compose.foundation.lazy.staggeredgrid;

import androidx.compose.foundation.lazy.layout.LazyLayoutItemProvider;
import androidx.compose.foundation.lazy.layout.LazyLayoutItemProviderKt;
import androidx.compose.foundation.lazy.layout.LazyLayoutNearestRangeState;
import androidx.compose.runtime.IntState;
import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.SnapshotIntStateKt;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.runtime.snapshots.Snapshot.Companion;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function2;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0015\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0008\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u000b\n\u0002\u0008\r\n\u0002\u0018\u0002\n\u0002\u0008\u000c\n\u0002\u0010\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\u0008\u0001\u0018\u00002\u00020\u0001BM\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u00126\u0010\u0005\u001a2\u0012\u0013\u0012\u00110\u0007¢\u0006\u000c\u0008\u0008\u0012\u0008\u0008\t\u0012\u0004\u0008\u0008(\n\u0012\u0013\u0012\u00110\u0007¢\u0006\u000c\u0008\u0008\u0012\u0008\u0008\t\u0012\u0004\u0008\u0008(\u000b\u0012\u0004\u0012\u00020\u00030\u0006¢\u0006\u0002\u0010\u000cJ\u0010\u0010%\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u0003H\u0002J\u0018\u0010&\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u00032\u0006\u0010'\u001a\u00020\u0003H\u0002J\u0016\u0010(\u001a\u00020)2\u0006\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020\u0007J\u0018\u0010*\u001a\u00020)2\u0006\u0010\u0017\u001a\u00020\u00032\u0006\u0010'\u001a\u00020\u0003H\u0002J\u000e\u0010+\u001a\u00020)2\u0006\u0010,\u001a\u00020-J\u000e\u0010.\u001a\u00020)2\u0006\u0010#\u001a\u00020\u0003J\u0018\u0010/\u001a\u00020\u00032\u0006\u00100\u001a\u0002012\u0006\u0010\u0017\u001a\u00020\u0003H\u0007R>\u0010\u0005\u001a2\u0012\u0013\u0012\u00110\u0007¢\u0006\u000c\u0008\u0008\u0012\u0008\u0008\t\u0012\u0004\u0008\u0008(\n\u0012\u0013\u0012\u00110\u0007¢\u0006\u000c\u0008\u0008\u0012\u0008\u0008\t\u0012\u0004\u0008\u0008(\u000b\u0012\u0004\u0012\u00020\u00030\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R+\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u00078F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\u0008\u0015\u0010\u0016\u001a\u0004\u0008\u0011\u0010\u0012\"\u0004\u0008\u0013\u0010\u0014R\u001e\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0003@BX\u0086\u000e¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0018\u0010\u0019R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u001b\u001a\u00020\u001c¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001d\u0010\u001eR+\u0010\u001f\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u00078F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\u0008\"\u0010\u0016\u001a\u0004\u0008 \u0010\u0012\"\u0004\u0008!\u0010\u0014R\u001e\u0010#\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0003@BX\u0086\u000e¢\u0006\u0008\n\u0000\u001a\u0004\u0008$\u0010\u0019¨\u00062", d2 = {"Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridScrollPosition;", "", "initialIndices", "", "initialOffsets", "fillIndices", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "targetIndex", "laneCount", "([I[ILkotlin/jvm/functions/Function2;)V", "hadFirstNotEmptyLayout", "", "<set-?>", "index", "getIndex", "()I", "setIndex", "(I)V", "index$delegate", "Landroidx/compose/runtime/MutableIntState;", "indices", "getIndices", "()[I", "lastKnownFirstItemKey", "nearestRangeState", "Landroidx/compose/foundation/lazy/layout/LazyLayoutNearestRangeState;", "getNearestRangeState", "()Landroidx/compose/foundation/lazy/layout/LazyLayoutNearestRangeState;", "scrollOffset", "getScrollOffset", "setScrollOffset", "scrollOffset$delegate", "scrollOffsets", "getScrollOffsets", "calculateFirstVisibleIndex", "calculateFirstVisibleScrollOffset", "offsets", "requestPositionAndForgetLastKnownKey", "", "update", "updateFromMeasureResult", "measureResult", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridMeasureResult;", "updateScrollOffset", "updateScrollPositionIfTheFirstItemWasMoved", "itemProvider", "Landroidx/compose/foundation/lazy/layout/LazyLayoutItemProvider;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class LazyStaggeredGridScrollPosition {

    public static final int $stable = 8;
    private final Function2<Integer, Integer, int[]> fillIndices;
    private boolean hadFirstNotEmptyLayout;
    private final MutableIntState index$delegate;
    private int[] indices;
    private Object lastKnownFirstItemKey;
    private final LazyLayoutNearestRangeState nearestRangeState;
    private final MutableIntState scrollOffset$delegate;
    private int[] scrollOffsets;
    static {
        final int i = 8;
    }

    public LazyStaggeredGridScrollPosition(int[] initialIndices, int[] initialOffsets, Function2<? super Integer, ? super Integer, int[]> fillIndices) {
        int intValue;
        super();
        this.fillIndices = fillIndices;
        this.indices = initialIndices;
        this.index$delegate = SnapshotIntStateKt.mutableIntStateOf(calculateFirstVisibleIndex(initialIndices));
        this.scrollOffsets = initialOffsets;
        this.scrollOffset$delegate = SnapshotIntStateKt.mutableIntStateOf(calculateFirstVisibleScrollOffset(initialIndices, initialOffsets));
        Integer minOrNull = ArraysKt.minOrNull(initialIndices);
        if (minOrNull != null) {
            intValue = minOrNull.intValue();
        } else {
            intValue = 0;
        }
        LazyLayoutNearestRangeState lazyLayoutNearestRangeState = new LazyLayoutNearestRangeState(intValue, 90, 200);
        this.nearestRangeState = lazyLayoutNearestRangeState;
    }

    private final int calculateFirstVisibleIndex(int[] indices) {
        int minIndex;
        int i3;
        int i2;
        int i4;
        int i;
        int i5;
        int i6 = 0;
        minIndex = Integer.MAX_VALUE;
        int[] iArr = indices;
        final int i7 = 0;
        i3 = 0;
        i2 = i3;
        while (i2 < iArr.length) {
            i = i4;
            i5 = 0;
            if (minIndex > i) {
            }
            i2++;
            minIndex = i;
        }
        if (minIndex == Integer.MAX_VALUE) {
        } else {
            i3 = minIndex;
        }
        return i3;
    }

    private final int calculateFirstVisibleScrollOffset(int[] indices, int[] offsets) {
        int minOffset;
        int lane;
        int i2;
        int i;
        minOffset = Integer.MAX_VALUE;
        lane = 0;
        while (lane < offsets.length) {
            if (indices[lane] == calculateFirstVisibleIndex(indices)) {
            }
            lane++;
            minOffset = Math.min(minOffset, offsets[lane]);
        }
        i2 = minOffset == Integer.MAX_VALUE ? 0 : minOffset;
        return i2;
    }

    private final void setIndex(int <set-?>) {
        final int i = 0;
        final int i2 = 0;
        this.index$delegate.setIntValue(<set-?>);
    }

    private final void setScrollOffset(int <set-?>) {
        final int i = 0;
        final int i2 = 0;
        this.scrollOffset$delegate.setIntValue(<set-?>);
    }

    private final void update(int[] indices, int[] offsets) {
        this.indices = indices;
        setIndex(calculateFirstVisibleIndex(indices));
        this.scrollOffsets = offsets;
        setScrollOffset(calculateFirstVisibleScrollOffset(indices, offsets));
    }

    public final int getIndex() {
        final int i = 0;
        final int i2 = 0;
        return (IntState)this.index$delegate.getIntValue();
    }

    public final int[] getIndices() {
        return this.indices;
    }

    public final LazyLayoutNearestRangeState getNearestRangeState() {
        return this.nearestRangeState;
    }

    public final int getScrollOffset() {
        final int i = 0;
        final int i2 = 0;
        return (IntState)this.scrollOffset$delegate.getIntValue();
    }

    public final int[] getScrollOffsets() {
        return this.scrollOffsets;
    }

    public final void requestPositionAndForgetLastKnownKey(int index, int scrollOffset) {
        int i;
        Object invoke = this.fillIndices.invoke(Integer.valueOf(index), Integer.valueOf(indices.length));
        int length = invoke.length;
        int[] iArr = new int[length];
        i = 0;
        while (i < length) {
            iArr[i] = scrollOffset;
            i++;
        }
        update((int[])invoke, iArr);
        this.nearestRangeState.update(index);
        this.lastKnownFirstItemKey = 0;
    }

    public final void updateFromMeasureResult(androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasureResult measureResult) {
        int key;
        boolean $i$a$WithoutReadObservationLazyStaggeredGridScrollPosition$updateFromMeasureResult$2;
        Snapshot.Companion companion;
        int list;
        Snapshot currentThreadSnapshot;
        int index$iv$iv;
        int[] firstVisibleItemIndices;
        int firstVisibleItemScrollOffsets;
        kotlin.jvm.functions.Function1 readObserver;
        Object obj;
        Object obj3;
        int i2;
        Object obj2;
        int i3;
        int i;
        final Object obj4 = this;
        final int firstVisibleIndex = obj4.calculateFirstVisibleIndex(measureResult.getFirstVisibleItemIndices());
        companion = 0;
        list = visibleItemsInfo;
        currentThreadSnapshot = 0;
        index$iv$iv = 0;
        firstVisibleItemScrollOffsets = 1;
        readObserver = 0;
        while (index$iv$iv < list.size()) {
            i2 = 0;
            i3 = 0;
            if ((LazyStaggeredGridMeasuredItem)list.get(index$iv$iv).getIndex() == firstVisibleIndex) {
            } else {
            }
            i = 0;
            index$iv$iv++;
            firstVisibleItemScrollOffsets = 1;
            readObserver = 0;
            i = firstVisibleItemScrollOffsets;
        }
        obj3 = readObserver;
        if ((LazyStaggeredGridMeasuredItem)obj3 != null) {
            key = (LazyStaggeredGridMeasuredItem)obj3.getKey();
        } else {
            key = readObserver;
        }
        obj4.lastKnownFirstItemKey = key;
        obj4.nearestRangeState.update(firstVisibleIndex);
        if (!obj4.hadFirstNotEmptyLayout) {
            obj4.hadFirstNotEmptyLayout = firstVisibleItemScrollOffsets;
            companion = Snapshot.Companion;
            list = 0;
            currentThreadSnapshot = companion.getCurrentThreadSnapshot();
            if (measureResult.getTotalItemsCount() > 0 && currentThreadSnapshot != null) {
                obj4.hadFirstNotEmptyLayout = firstVisibleItemScrollOffsets;
                companion = Snapshot.Companion;
                list = 0;
                currentThreadSnapshot = companion.getCurrentThreadSnapshot();
                if (currentThreadSnapshot != null) {
                    readObserver = currentThreadSnapshot.getReadObserver();
                }
                int i4 = 0;
                obj4.update(measureResult.getFirstVisibleItemIndices(), measureResult.getFirstVisibleItemScrollOffsets());
                $i$a$WithoutReadObservationLazyStaggeredGridScrollPosition$updateFromMeasureResult$2 = Unit.INSTANCE;
                companion.restoreNonObservable(currentThreadSnapshot, companion.makeCurrentNonObservable(currentThreadSnapshot), readObserver);
            }
        } else {
        }
    }

    public final void updateScrollOffset(int[] scrollOffsets) {
        this.scrollOffsets = scrollOffsets;
        setScrollOffset(calculateFirstVisibleScrollOffset(this.indices, scrollOffsets));
    }

    public final int[] updateScrollPositionIfTheFirstItemWasMoved(LazyLayoutItemProvider itemProvider, int[] indices) {
        int intValue;
        int firstVisibleIndex;
        int orNull;
        Snapshot currentThreadSnapshot;
        int readObserver;
        Snapshot currentNonObservable;
        int th;
        Object invoke;
        Integer valueOf;
        Integer valueOf2;
        orNull = ArraysKt.getOrNull(indices, 0);
        if (orNull != null) {
            intValue = orNull.intValue();
        }
        int indexByKey = LazyLayoutItemProviderKt.findIndexByKey(itemProvider, this.lastKnownFirstItemKey, intValue);
        if (!ArraysKt.contains(indices, indexByKey)) {
            this.nearestRangeState.update(indexByKey);
            Snapshot.Companion companion = Snapshot.Companion;
            orNull = 0;
            currentThreadSnapshot = companion.getCurrentThreadSnapshot();
            if (currentThreadSnapshot != null) {
                readObserver = currentThreadSnapshot.getReadObserver();
            } else {
                readObserver = 0;
            }
            th = 0;
            invoke = this.fillIndices.invoke(Integer.valueOf(indexByKey), Integer.valueOf(indices.length));
            companion.restoreNonObservable(currentThreadSnapshot, companion.makeCurrentNonObservable(currentThreadSnapshot), readObserver);
            this.indices = (int[])invoke;
            setIndex(calculateFirstVisibleIndex(invoke));
        } else {
            invoke = indices;
        }
        return invoke;
    }
}
