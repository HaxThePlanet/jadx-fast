package androidx.compose.foundation.lazy.staggeredgrid;

import androidx.compose.foundation.lazy.layout.IntervalList;
import androidx.compose.foundation.lazy.layout.IntervalList.Interval;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0008\n\u0000\u0008\u0000\u0018\u00002\u00020\u0001B\u0013\u0012\u000c\u0010\u0002\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u000e\u0010\u0008\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bR\u0017\u0010\u0002\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0006\u0010\u0007¨\u0006\u000c", d2 = {"Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridSpanProvider;", "", "intervals", "Landroidx/compose/foundation/lazy/layout/IntervalList;", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridInterval;", "(Landroidx/compose/foundation/lazy/layout/IntervalList;)V", "getIntervals", "()Landroidx/compose/foundation/lazy/layout/IntervalList;", "isFullSpan", "", "itemIndex", "", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class LazyStaggeredGridSpanProvider {

    public static final int $stable = 8;
    private final IntervalList<androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridInterval> intervals;
    static {
        final int i = 8;
    }

    public LazyStaggeredGridSpanProvider(IntervalList<androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridInterval> intervals) {
        super();
        this.intervals = intervals;
    }

    public final IntervalList<androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridInterval> getIntervals() {
        return this.intervals;
    }

    public final boolean isFullSpan(int itemIndex) {
        int i2;
        int size;
        int i;
        Object invoke;
        androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridItemSpan fullLine;
        final int i3 = 0;
        if (itemIndex >= 0 && itemIndex < this.intervals.getSize()) {
            i = itemIndex < this.intervals.getSize() ? i2 : i3;
        } else {
        }
        if (i == 0) {
            return i3;
        }
        IntervalList.Interval list = this.intervals.get(itemIndex);
        final int i4 = 0;
        Function1 span = (LazyStaggeredGridInterval)list.getValue().getSpan();
        if (span != null && span.invoke(Integer.valueOf(itemIndex - startIndex)) == StaggeredGridItemSpan.Companion.getFullLine()) {
            if (span.invoke(Integer.valueOf(i5)) == StaggeredGridItemSpan.Companion.getFullLine()) {
            } else {
                i2 = i3;
            }
        } else {
        }
        return i2;
    }
}
