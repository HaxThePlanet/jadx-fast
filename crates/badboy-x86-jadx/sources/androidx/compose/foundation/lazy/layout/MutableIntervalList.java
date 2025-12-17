package androidx.compose.foundation.lazy.layout;

import androidx.compose.runtime.collection.MutableVector;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0004\n\u0002\u0010\u0002\n\u0002\u0008\u0008\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u000b\n\u0000\u0008\u0007\u0018\u0000*\u0004\u0008\u0000\u0010\u00012\u0008\u0012\u0004\u0012\u0002H\u00010\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u001b\u0010\r\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00028\u0000¢\u0006\u0002\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\tH\u0002J2\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\t2\u0018\u0010\u0016\u001a\u0014\u0012\n\u0012\u0008\u0012\u0004\u0012\u00028\u00000\u0006\u0012\u0004\u0012\u00020\u000e0\u0017H\u0016J\u0017\u0010\u0018\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u00062\u0006\u0010\u0012\u001a\u00020\tH\u0096\u0002J\u0016\u0010\u0019\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u00062\u0006\u0010\u001a\u001a\u00020\tH\u0002J\u001a\u0010\u001b\u001a\u00020\u001c*\u0008\u0012\u0004\u0012\u00028\u00000\u00062\u0006\u0010\u0012\u001a\u00020\tH\u0002R\u001a\u0010\u0004\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00028\u00000\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\n\u001a\u00020\t2\u0006\u0010\u0008\u001a\u00020\t@RX\u0096\u000e¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000b\u0010\u000c¨\u0006\u001d", d2 = {"Landroidx/compose/foundation/lazy/layout/MutableIntervalList;", "T", "Landroidx/compose/foundation/lazy/layout/IntervalList;", "()V", "intervals", "Landroidx/compose/runtime/collection/MutableVector;", "Landroidx/compose/foundation/lazy/layout/IntervalList$Interval;", "lastInterval", "<set-?>", "", "size", "getSize", "()I", "addInterval", "", "value", "(ILjava/lang/Object;)V", "checkIndexBounds", "index", "forEach", "fromIndex", "toIndex", "block", "Lkotlin/Function1;", "get", "getIntervalForIndex", "itemIndex", "contains", "", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class MutableIntervalList<T>  implements androidx.compose.foundation.lazy.layout.IntervalList<T> {

    public static final int $stable = 8;
    private final MutableVector<androidx.compose.foundation.lazy.layout.IntervalList.Interval<T>> intervals;
    private androidx.compose.foundation.lazy.layout.IntervalList.Interval<? extends T> lastInterval;
    private int size;
    static {
        final int i = 8;
    }

    public MutableIntervalList() {
        super();
        final int i = 0;
        final int i3 = 0;
        MutableVector mutableVector = new MutableVector(new IntervalList.Interval[16], 0);
        this.intervals = mutableVector;
    }

    private final void checkIndexBounds(int index) {
        int i;
        int size;
        i = 0;
        if (index >= 0 && index < getSize()) {
            if (index < getSize()) {
                i = 1;
            }
        }
        if (i == 0) {
        } else {
        }
        StringBuilder stringBuilder = new StringBuilder();
        IndexOutOfBoundsException indexOutOfBoundsException = new IndexOutOfBoundsException(stringBuilder.append("Index ").append(index).append(", size ").append(getSize()).toString());
        throw indexOutOfBoundsException;
    }

    private final boolean contains(androidx.compose.foundation.lazy.layout.IntervalList.Interval<? extends T> $this$contains, int index) {
        int i;
        i = 0;
        if (index < startIndex2 += size && $this$contains.getStartIndex() <= index) {
            if ($this$contains.getStartIndex() <= index) {
                i = 1;
            }
        }
        return i;
    }

    private final androidx.compose.foundation.lazy.layout.IntervalList.Interval<T> getIntervalForIndex(int itemIndex) {
        boolean contains;
        Object this_$iv;
        Object index$iv;
        int i;
        Object[] content;
        final androidx.compose.foundation.lazy.layout.IntervalList.Interval lastInterval = this.lastInterval;
        if (lastInterval != null && contains(lastInterval, itemIndex)) {
            if (contains(lastInterval, itemIndex)) {
                this_$iv = lastInterval;
            } else {
                int i3 = 0;
                i = 0;
                this.lastInterval = (IntervalList.Interval)this.intervals.getContent()[IntervalListKt.access$binarySearch(this.intervals, itemIndex)];
            }
        } else {
        }
        return this_$iv;
    }

    public final void addInterval(int size, T value) {
        int i;
        i = size >= 0 ? 1 : 0;
        if (i == 0) {
        } else {
            if (size == 0) {
            }
            IntervalList.Interval interval2 = new IntervalList.Interval(getSize(), size, value);
            this.size = size3 += size;
            this.intervals.add(interval2);
        }
        int interval = 0;
        StringBuilder stringBuilder = new StringBuilder();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.append("size should be >=0, but was ").append(size).toString().toString());
        throw illegalArgumentException;
    }

    public void forEach(int fromIndex, int toIndex, Function1<? super androidx.compose.foundation.lazy.layout.IntervalList.Interval<? extends T>, Unit> block) {
        int i;
        int intervalIndex;
        int itemIndex;
        int this_$iv;
        Object[] content;
        Object[] content2;
        checkIndexBounds(fromIndex);
        checkIndexBounds(toIndex);
        i = toIndex >= fromIndex ? 1 : 0;
        if (i == 0) {
        } else {
            this_$iv = 0;
            itemIndex = (IntervalList.Interval)this.intervals.getContent()[IntervalListKt.access$binarySearch(this.intervals, fromIndex)].getStartIndex();
            while (itemIndex <= toIndex) {
                int i3 = 0;
                this_$iv = this.intervals.getContent()[intervalIndex];
                block.invoke((IntervalList.Interval)this_$iv);
                itemIndex += content;
                intervalIndex++;
            }
        }
        int intervalIndex2 = 0;
        StringBuilder stringBuilder = new StringBuilder();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.append("toIndex (").append(toIndex).append(") should be not smaller than fromIndex (").append(fromIndex).append(')').toString().toString());
        throw illegalArgumentException;
    }

    public androidx.compose.foundation.lazy.layout.IntervalList.Interval<T> get(int index) {
        checkIndexBounds(index);
        return getIntervalForIndex(index);
    }

    @Override // androidx.compose.foundation.lazy.layout.IntervalList
    public int getSize() {
        return this.size;
    }
}
