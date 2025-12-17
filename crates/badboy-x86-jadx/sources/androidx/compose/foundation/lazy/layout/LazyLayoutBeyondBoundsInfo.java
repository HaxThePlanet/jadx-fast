package androidx.compose.foundation.lazy.layout;

import androidx.compose.runtime.collection.MutableVector;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0003\u0008\u0000\u0018\u00002\u00020\u0001:\u0001\u0012B\u0005¢\u0006\u0002\u0010\u0002J\u0016\u0010\u000c\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0007J\u0006\u0010\r\u001a\u00020\u000eJ\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0005R\u0014\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\u0008\u0008\u0010\tR\u0011\u0010\n\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\u0008\u000b\u0010\t¨\u0006\u0013", d2 = {"Landroidx/compose/foundation/lazy/layout/LazyLayoutBeyondBoundsInfo;", "", "()V", "beyondBoundsItems", "Landroidx/compose/runtime/collection/MutableVector;", "Landroidx/compose/foundation/lazy/layout/LazyLayoutBeyondBoundsInfo$Interval;", "end", "", "getEnd", "()I", "start", "getStart", "addInterval", "hasIntervals", "", "removeInterval", "", "interval", "Interval", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class LazyLayoutBeyondBoundsInfo {

    public static final int $stable;
    private final MutableVector<androidx.compose.foundation.lazy.layout.LazyLayoutBeyondBoundsInfo.Interval> beyondBoundsItems;

    @Metadata(d1 = "\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\t\n\u0002\u0010\u000b\n\u0002\u0008\u0003\n\u0002\u0010\u000e\n\u0000\u0008\u0080\u0008\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000c\u001a\u00020\r2\u0008\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0008\u0010\u0007¨\u0006\u0012", d2 = {"Landroidx/compose/foundation/lazy/layout/LazyLayoutBeyondBoundsInfo$Interval;", "", "start", "", "end", "(II)V", "getEnd", "()I", "getStart", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Interval {

        public static final int $stable;
        private final int end;
        private final int start;
        static {
        }

        public Interval(int start, int end) {
            int i;
            int i2;
            super();
            this.start = start;
            this.end = end;
            final int i5 = 0;
            i = this.start >= 0 ? i2 : i5;
            if (i == 0) {
            } else {
                if (this.end >= this.start) {
                } else {
                    i2 = i5;
                }
                if (i2 == 0) {
                } else {
                }
                int i4 = 0;
                IllegalArgumentException $i$a$RequireLazyLayoutBeyondBoundsInfo$Interval$2 = new IllegalArgumentException("end index greater than start".toString());
                throw $i$a$RequireLazyLayoutBeyondBoundsInfo$Interval$2;
            }
            int i3 = 0;
            IllegalArgumentException $i$a$RequireLazyLayoutBeyondBoundsInfo$Interval$1 = new IllegalArgumentException("negative start index".toString());
            throw $i$a$RequireLazyLayoutBeyondBoundsInfo$Interval$1;
        }

        public static androidx.compose.foundation.lazy.layout.LazyLayoutBeyondBoundsInfo.Interval copy$default(androidx.compose.foundation.lazy.layout.LazyLayoutBeyondBoundsInfo.Interval lazyLayoutBeyondBoundsInfo$Interval, int i2, int i3, int i4, Object object5) {
            int obj1;
            int obj2;
            if (i4 & 1 != 0) {
                obj1 = interval.start;
            }
            if (i4 &= 2 != 0) {
                obj2 = interval.end;
            }
            return interval.copy(obj1, obj2);
        }

        public final int component1() {
            return this.start;
        }

        public final int component2() {
            return this.end;
        }

        public final androidx.compose.foundation.lazy.layout.LazyLayoutBeyondBoundsInfo.Interval copy(int i, int i2) {
            LazyLayoutBeyondBoundsInfo.Interval interval = new LazyLayoutBeyondBoundsInfo.Interval(i, i2);
            return interval;
        }

        public boolean equals(Object object) {
            final int i = 1;
            if (this == object) {
                return i;
            }
            final int i2 = 0;
            if (!object instanceof LazyLayoutBeyondBoundsInfo.Interval) {
                return i2;
            }
            Object obj = object;
            if (this.start != obj.start) {
                return i2;
            }
            if (this.end != obj.end) {
                return i2;
            }
            return i;
        }

        public final int getEnd() {
            return this.end;
        }

        public final int getStart() {
            return this.start;
        }

        public int hashCode() {
            return i2 += i4;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            return stringBuilder.append("Interval(start=").append(this.start).append(", end=").append(this.end).append(')').toString();
        }
    }
    static {
        LazyLayoutBeyondBoundsInfo.$stable = MutableVector.$stable;
    }

    public LazyLayoutBeyondBoundsInfo() {
        super();
        final int i = 0;
        final int i3 = 0;
        MutableVector mutableVector = new MutableVector(new LazyLayoutBeyondBoundsInfo.Interval[16], 0);
        this.beyondBoundsItems = mutableVector;
    }

    public final androidx.compose.foundation.lazy.layout.LazyLayoutBeyondBoundsInfo.Interval addInterval(int start, int end) {
        LazyLayoutBeyondBoundsInfo.Interval interval = new LazyLayoutBeyondBoundsInfo.Interval(start, end);
        final int i = 0;
        this.beyondBoundsItems.add(interval);
        return interval;
    }

    public final int getEnd() {
        int maxIndex;
        int i$iv;
        Object[] content;
        Object obj;
        int i;
        int end;
        int i2 = 0;
        maxIndex = (LazyLayoutBeyondBoundsInfo.Interval)this.beyondBoundsItems.first().getEnd();
        MutableVector beyondBoundsItems2 = this.beyondBoundsItems;
        final int i3 = 0;
        final int size = beyondBoundsItems2.getSize();
        if (size > 0) {
            i$iv = 0;
            obj = beyondBoundsItems2.getContent()[i$iv];
            i = 0;
            do {
                obj = content[i$iv];
                i = 0;
                if (i$iv++ < size) {
                }
                maxIndex = obj.getEnd();
            } while ((LazyLayoutBeyondBoundsInfo.Interval)obj.getEnd() > maxIndex);
        }
        return maxIndex;
    }

    public final int getStart() {
        int minIndex;
        int i2;
        int i$iv;
        Object[] content;
        Object obj;
        int i;
        int start;
        int i3 = 0;
        minIndex = (LazyLayoutBeyondBoundsInfo.Interval)this.beyondBoundsItems.first().getStart();
        MutableVector beyondBoundsItems2 = this.beyondBoundsItems;
        int i5 = 0;
        final int size = beyondBoundsItems2.getSize();
        if (size > 0) {
            i$iv = 0;
            obj = beyondBoundsItems2.getContent()[i$iv];
            i = 0;
            do {
                obj = content[i$iv];
                i = 0;
                if (i$iv++ < size) {
                }
                minIndex = obj.getStart();
            } while ((LazyLayoutBeyondBoundsInfo.Interval)obj.getStart() < minIndex);
        }
        i2 = minIndex >= 0 ? 1 : 0;
        if (i2 == 0) {
        } else {
            return minIndex;
        }
        int i4 = 0;
        IllegalArgumentException $i$a$RequireLazyLayoutBeyondBoundsInfo$start$2 = new IllegalArgumentException("negative minIndex".toString());
        throw $i$a$RequireLazyLayoutBeyondBoundsInfo$start$2;
    }

    public final boolean hasIntervals() {
        return this.beyondBoundsItems.isNotEmpty();
    }

    public final void removeInterval(androidx.compose.foundation.lazy.layout.LazyLayoutBeyondBoundsInfo.Interval interval) {
        this.beyondBoundsItems.remove(interval);
    }
}
