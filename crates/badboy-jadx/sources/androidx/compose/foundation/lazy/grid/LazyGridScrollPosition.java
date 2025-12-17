package androidx.compose.foundation.lazy.grid;

import androidx.compose.foundation.lazy.layout.LazyLayoutItemProviderKt;
import androidx.compose.foundation.lazy.layout.LazyLayoutNearestRangeState;
import androidx.compose.runtime.IntState;
import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.SnapshotIntStateKt;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0002\u0008\n\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0010\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\u0008\u0000\u0018\u00002\u00020\u0001B\u0019\u0012\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\u0016\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0003J\u0018\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0003H\u0002J\u000e\u0010\u001c\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u001eJ\u000e\u0010\u001f\u001a\u00020\u001a2\u0006\u0010\u0015\u001a\u00020\u0003J\u0016\u0010 \u001a\u00020\u00032\u0006\u0010!\u001a\u00020\"2\u0006\u0010\t\u001a\u00020\u0003R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R+\u0010\t\u001a\u00020\u00032\u0006\u0010\u0008\u001a\u00020\u00038F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\u0008\u000e\u0010\u000f\u001a\u0004\u0008\n\u0010\u000b\"\u0004\u0008\u000c\u0010\rR\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0013\u0010\u0014R+\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0008\u001a\u00020\u00038F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\u0008\u0018\u0010\u000f\u001a\u0004\u0008\u0016\u0010\u000b\"\u0004\u0008\u0017\u0010\r¨\u0006#", d2 = {"Landroidx/compose/foundation/lazy/grid/LazyGridScrollPosition;", "", "initialIndex", "", "initialScrollOffset", "(II)V", "hadFirstNotEmptyLayout", "", "<set-?>", "index", "getIndex", "()I", "setIndex", "(I)V", "index$delegate", "Landroidx/compose/runtime/MutableIntState;", "lastKnownFirstItemKey", "nearestRangeState", "Landroidx/compose/foundation/lazy/layout/LazyLayoutNearestRangeState;", "getNearestRangeState", "()Landroidx/compose/foundation/lazy/layout/LazyLayoutNearestRangeState;", "scrollOffset", "getScrollOffset", "setScrollOffset", "scrollOffset$delegate", "requestPositionAndForgetLastKnownKey", "", "update", "updateFromMeasureResult", "measureResult", "Landroidx/compose/foundation/lazy/grid/LazyGridMeasureResult;", "updateScrollOffset", "updateScrollPositionIfTheFirstItemWasMoved", "itemProvider", "Landroidx/compose/foundation/lazy/grid/LazyGridItemProvider;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class LazyGridScrollPosition {

    public static final int $stable = 8;
    private boolean hadFirstNotEmptyLayout;
    private final MutableIntState index$delegate;
    private Object lastKnownFirstItemKey;
    private final LazyLayoutNearestRangeState nearestRangeState;
    private final MutableIntState scrollOffset$delegate;
    static {
        final int i = 8;
    }

    public LazyGridScrollPosition() {
        final int i3 = 0;
        super(i3, i3, 3, 0);
    }

    public LazyGridScrollPosition(int initialIndex, int initialScrollOffset) {
        super();
        this.index$delegate = SnapshotIntStateKt.mutableIntStateOf(initialIndex);
        this.scrollOffset$delegate = SnapshotIntStateKt.mutableIntStateOf(initialScrollOffset);
        LazyLayoutNearestRangeState lazyLayoutNearestRangeState = new LazyLayoutNearestRangeState(initialIndex, 90, 200);
        this.nearestRangeState = lazyLayoutNearestRangeState;
    }

    public LazyGridScrollPosition(int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker4) {
        int obj2;
        int obj3;
        final int i4 = 0;
        obj2 = i3 & 1 != 0 ? i4 : obj2;
        obj3 = i3 &= 2 != 0 ? i4 : obj3;
        super(obj2, obj3);
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

    private final void update(int index, int scrollOffset) {
        int i;
        i = Float.compare(f, i3) >= 0 ? 1 : 0;
        if (i == 0) {
        } else {
            setIndex(index);
            this.nearestRangeState.update(index);
            setScrollOffset(scrollOffset);
        }
        int i2 = 0;
        StringBuilder stringBuilder = new StringBuilder();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.append("Index should be non-negative (").append(index).append(')').toString().toString());
        throw illegalArgumentException;
    }

    public final int getIndex() {
        final int i = 0;
        final int i2 = 0;
        return (IntState)this.index$delegate.getIntValue();
    }

    public final LazyLayoutNearestRangeState getNearestRangeState() {
        return this.nearestRangeState;
    }

    public final int getScrollOffset() {
        final int i = 0;
        final int i2 = 0;
        return (IntState)this.scrollOffset$delegate.getIntValue();
    }

    public final void requestPositionAndForgetLastKnownKey(int index, int scrollOffset) {
        update(index, scrollOffset);
        this.lastKnownFirstItemKey = 0;
    }

    public final void updateFromMeasureResult(androidx.compose.foundation.lazy.grid.LazyGridMeasureResult measureResult) {
        Object firstVisibleLine;
        Object key;
        boolean hadFirstNotEmptyLayout;
        int i;
        int firstVisibleLineScrollOffset;
        int cmp;
        int index;
        firstVisibleLine = measureResult.getFirstVisibleLine();
        firstVisibleLine = firstVisibleLine.getItems();
        firstVisibleLine = ArraysKt.firstOrNull(firstVisibleLine);
        if (firstVisibleLine != null && firstVisibleLine != null && (LazyGridMeasuredItem)firstVisibleLine != null) {
            firstVisibleLine = firstVisibleLine.getItems();
            if (firstVisibleLine != null) {
                firstVisibleLine = ArraysKt.firstOrNull(firstVisibleLine);
                if ((LazyGridMeasuredItem)(LazyGridMeasuredItem)firstVisibleLine != null) {
                    key = (LazyGridMeasuredItem)(LazyGridMeasuredItem)firstVisibleLine.getKey();
                } else {
                    key = 0;
                }
            } else {
            }
        } else {
        }
        this.lastKnownFirstItemKey = key;
        if (!this.hadFirstNotEmptyLayout) {
            if (measureResult.getTotalItemsCount() > 0) {
                this.hadFirstNotEmptyLayout = true;
                firstVisibleLineScrollOffset = measureResult.getFirstVisibleLineScrollOffset();
                if (Float.compare(f, i3) >= 0) {
                } else {
                    i = index;
                }
                if (i == 0) {
                } else {
                    hadFirstNotEmptyLayout = measureResult.getFirstVisibleLine();
                    hadFirstNotEmptyLayout = hadFirstNotEmptyLayout.getItems();
                    hadFirstNotEmptyLayout = ArraysKt.firstOrNull(hadFirstNotEmptyLayout);
                    if (hadFirstNotEmptyLayout != null && hadFirstNotEmptyLayout != null && (LazyGridMeasuredItem)hadFirstNotEmptyLayout != null) {
                        hadFirstNotEmptyLayout = hadFirstNotEmptyLayout.getItems();
                        if (hadFirstNotEmptyLayout != null) {
                            hadFirstNotEmptyLayout = ArraysKt.firstOrNull(hadFirstNotEmptyLayout);
                            if ((LazyGridMeasuredItem)(LazyGridMeasuredItem)hadFirstNotEmptyLayout != null) {
                                index = (LazyGridMeasuredItem)(LazyGridMeasuredItem)hadFirstNotEmptyLayout.getIndex();
                            }
                        }
                    }
                    update(index, firstVisibleLineScrollOffset);
                }
            }
        } else {
        }
        int i2 = 0;
        StringBuilder stringBuilder = new StringBuilder();
        IllegalStateException illegalStateException = new IllegalStateException(stringBuilder.append("scrollOffset should be non-negative (").append(firstVisibleLineScrollOffset).append(')').toString().toString());
        throw illegalStateException;
    }

    public final void updateScrollOffset(int scrollOffset) {
        int i;
        i = Float.compare(f, i3) >= 0 ? 1 : 0;
        if (i == 0) {
        } else {
            setScrollOffset(scrollOffset);
        }
        int i2 = 0;
        StringBuilder stringBuilder = new StringBuilder();
        IllegalStateException illegalStateException = new IllegalStateException(stringBuilder.append("scrollOffset should be non-negative (").append(scrollOffset).append(')').toString().toString());
        throw illegalStateException;
    }

    public final int updateScrollPositionIfTheFirstItemWasMoved(androidx.compose.foundation.lazy.grid.LazyGridItemProvider itemProvider, int index) {
        Object lastKnownFirstItemKey;
        int indexByKey = LazyLayoutItemProviderKt.findIndexByKey((LazyLayoutItemProvider)itemProvider, this.lastKnownFirstItemKey, index);
        if (index != indexByKey) {
            setIndex(indexByKey);
            this.nearestRangeState.update(index);
        }
        return indexByKey;
    }
}
