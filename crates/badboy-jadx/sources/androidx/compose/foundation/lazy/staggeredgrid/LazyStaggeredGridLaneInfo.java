package androidx.compose.foundation.lazy.staggeredgrid;

import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArrayDeque;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0002\u0008\u0012\u0008\u0000\u0018\u0000 \u001f2\u00020\u0001:\u0002\u001f B\u0005¢\u0006\u0002\u0010\u0002J\u0016\u0010\n\u001a\u00020\u000b2\u0006\u0010\u000c\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u0004J\u001a\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00042\u0008\u0008\u0002\u0010\u0011\u001a\u00020\u0004H\u0002J\u000e\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u0004J\u0016\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u000c\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u0004J\u0016\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u000c\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u0004J\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u000c\u001a\u00020\u0004J\u000e\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u000c\u001a\u00020\u0004J\u0006\u0010\u0018\u001a\u00020\u0004J\u0006\u0010\u0019\u001a\u00020\u000fJ\u0018\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u000c\u001a\u00020\u00042\u0008\u0010\u001b\u001a\u0004\u0018\u00010\u0006J\u0016\u0010\u001c\u001a\u00020\u000f2\u0006\u0010\u000c\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u0004J\u0006\u0010\u001e\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u0008\u0012\u0004\u0012\u00020\t0\u0008X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006!", d2 = {"Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridLaneInfo;", "", "()V", "anchor", "", "lanes", "", "spannedItems", "Lkotlin/collections/ArrayDeque;", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridLaneInfo$SpannedItem;", "assignedToLane", "", "itemIndex", "targetLane", "ensureCapacity", "", "capacity", "newOffset", "ensureValidIndex", "requestedIndex", "findNextItemIndex", "findPreviousItemIndex", "getGaps", "getLane", "lowerBound", "reset", "setGaps", "gaps", "setLane", "lane", "upperBound", "Companion", "SpannedItem", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class LazyStaggeredGridLaneInfo {

    public static final int $stable = 0;
    public static final androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridLaneInfo.Companion Companion = null;
    public static final int FullSpan = -2;
    private static final int MaxCapacity = 131072;
    public static final int Unset = -1;
    private int anchor;
    private int[] lanes;
    private final ArrayDeque<androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridLaneInfo.SpannedItem> spannedItems;

    @Metadata(d1 = "\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0003\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000¨\u0006\u0007", d2 = {"Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridLaneInfo$Companion;", "", "()V", "FullSpan", "", "MaxCapacity", "Unset", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
            super();
        }
    }

    @Metadata(d1 = "\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u0015\n\u0002\u0008\u0008\u0008\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0007\u0010\u0008\"\u0004\u0008\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000b\u0010\u000c¨\u0006\r", d2 = {"Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridLaneInfo$SpannedItem;", "", "index", "", "gaps", "", "(I[I)V", "getGaps", "()[I", "setGaps", "([I)V", "getIndex", "()I", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private static final class SpannedItem {

        private int[] gaps;
        private final int index;
        public SpannedItem(int index, int[] gaps) {
            super();
            this.index = index;
            this.gaps = gaps;
        }

        public final int[] getGaps() {
            return this.gaps;
        }

        public final int getIndex() {
            return this.index;
        }

        public final void setGaps(int[] <set-?>) {
            this.gaps = <set-?>;
        }
    }
    static {
        LazyStaggeredGridLaneInfo.Companion companion = new LazyStaggeredGridLaneInfo.Companion(0);
        LazyStaggeredGridLaneInfo.Companion = companion;
        LazyStaggeredGridLaneInfo.$stable = 8;
    }

    public LazyStaggeredGridLaneInfo() {
        super();
        this.lanes = new int[16];
        ArrayDeque arrayDeque = new ArrayDeque();
        this.spannedItems = arrayDeque;
    }

    private final void ensureCapacity(int capacity, int newOffset) {
        int i2;
        int newSize;
        int[] lanes;
        int[] iArr;
        int newOffset2;
        int i4;
        int i5;
        int i3;
        int i;
        int[] obj10;
        i2 = capacity <= 131072 ? 1 : 0;
        if (i2 == 0) {
        } else {
            if (lanes2.length < capacity) {
                newSize = lanes3.length;
                while (newSize < capacity) {
                    newSize *= 2;
                }
                this.lanes = ArraysKt.copyInto$default(this.lanes, new int[newSize], newOffset, 0, 0, 12, 0);
            } else {
                newOffset2 = newOffset;
            }
        }
        int newOffset3 = newOffset;
        obj10 = 0;
        StringBuilder stringBuilder = new StringBuilder();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.append("Requested item capacity ").append(capacity).append(" is larger than max supported: 131072!").toString().toString());
        throw illegalArgumentException;
    }

    static void ensureCapacity$default(androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridLaneInfo lazyStaggeredGridLaneInfo, int i2, int i3, int i4, Object object5) {
        int obj2;
        if (i4 &= 2 != 0) {
            obj2 = 0;
        }
        lazyStaggeredGridLaneInfo.ensureCapacity(i2, obj2);
    }

    public final boolean assignedToLane(int itemIndex, int targetLane) {
        int i2;
        int i;
        final int lane = getLane(itemIndex);
        if (lane != targetLane && lane != -1) {
            if (lane != -1) {
                if (lane == -2) {
                    i = 1;
                } else {
                    i = 0;
                }
            } else {
            }
        } else {
        }
        return i;
    }

    public final void ensureValidIndex(int requestedIndex) {
        int length3;
        int length;
        int[] spannedItems;
        boolean spannedItems2;
        boolean empty;
        int upperBound;
        int anchor;
        int delta;
        int length2;
        int length4;
        int i = requestedIndex - anchor2;
        int i2 = 131072;
        upperBound = 1;
        final int i5 = 0;
        if (i >= 0 && i < i2) {
            anchor = i < i2 ? upperBound : i5;
        } else {
        }
        delta = 2;
        if (anchor != 0) {
            LazyStaggeredGridLaneInfo.ensureCapacity$default(this, i + 1, i5, delta, 0);
        } else {
            this.anchor = Math.max(requestedIndex - length2, i5);
            anchor3 -= anchor;
            if (delta >= 0) {
                if (delta < lanes.length) {
                    ArraysKt.copyInto(this.lanes, this.lanes, i5, delta, lanes8.length);
                }
                ArraysKt.fill(this.lanes, i5, Math.max(i5, length6 -= delta), lanes7.length);
            } else {
                delta = -delta;
                if (length9 += delta < i2) {
                    ensureCapacity(i3 += upperBound, delta);
                } else {
                    if (delta < lanes3.length) {
                        ArraysKt.copyInto(this.lanes, this.lanes, delta, i5, length10 -= delta);
                    }
                    ArraysKt.fill(this.lanes, i5, i5, Math.min(lanes5.length, delta));
                }
            }
        }
        while (!(Collection)this.spannedItems.isEmpty()) {
            if ((LazyStaggeredGridLaneInfo.SpannedItem)this.spannedItems.first().getIndex() < lowerBound()) {
            }
            this.spannedItems.removeFirst();
        }
        while (!(Collection)this.spannedItems.isEmpty()) {
            if ((LazyStaggeredGridLaneInfo.SpannedItem)this.spannedItems.last().getIndex() > upperBound()) {
            }
            this.spannedItems.removeLast();
        }
    }

    public final int findNextItemIndex(int itemIndex, int targetLane) {
        int i;
        boolean assignedToLane;
        i = itemIndex + 1;
        while (i < upperBound()) {
            i++;
        }
        return upperBound();
    }

    public final int findPreviousItemIndex(int itemIndex, int targetLane) {
        int i;
        boolean assignedToLane;
        i = itemIndex + -1;
        int i2 = -1;
        while (i2 < i) {
            i--;
            i2 = -1;
        }
        return i2;
    }

    public final int[] getGaps(int itemIndex) {
        int[] gaps;
        ArrayDeque spannedItems = this.spannedItems;
        final int i2 = 0;
        LazyStaggeredGridLaneInfo.getGaps$$inlined.binarySearchBy.default.1 anon = new LazyStaggeredGridLaneInfo.getGaps$$inlined.binarySearchBy.default.1((Comparable)Integer.valueOf(itemIndex));
        Object orNull = CollectionsKt.getOrNull((List)this.spannedItems, CollectionsKt.binarySearch(spannedItems, 0, (List)spannedItems.size(), (Function1)anon));
        if ((LazyStaggeredGridLaneInfo.SpannedItem)orNull != null) {
            gaps = (LazyStaggeredGridLaneInfo.SpannedItem)orNull.getGaps();
        } else {
            gaps = 0;
        }
        return gaps;
    }

    public final int getLane(int itemIndex) {
        int lowerBound;
        if (itemIndex >= lowerBound() && itemIndex >= upperBound()) {
            if (itemIndex >= upperBound()) {
            }
            return i--;
        }
        return -1;
    }

    public final int lowerBound() {
        return this.anchor;
    }

    public final void reset() {
        ArraysKt.fill$default(this.lanes, 0, 0, 0, 6, 0);
        this.spannedItems.clear();
    }

    public final void setGaps(int itemIndex, int[] gaps) {
        int spannedItems;
        Object spannedItems2;
        androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridLaneInfo.SpannedItem spannedItem;
        ArrayDeque spannedItems3 = this.spannedItems;
        final int i2 = 0;
        LazyStaggeredGridLaneInfo.setGaps$$inlined.binarySearchBy.default.1 anon = new LazyStaggeredGridLaneInfo.setGaps$$inlined.binarySearchBy.default.1((Comparable)Integer.valueOf(itemIndex));
        int $this$binarySearchBy$iv$iv = CollectionsKt.binarySearch(spannedItems3, 0, (List)spannedItems3.size(), (Function1)anon);
        if ($this$binarySearchBy$iv$iv < 0) {
            if (gaps == null) {
            }
            spannedItem = new LazyStaggeredGridLaneInfo.SpannedItem(itemIndex, gaps);
            this.spannedItems.add(-i, spannedItem);
        } else {
            if (gaps == null) {
                this.spannedItems.remove($this$binarySearchBy$iv$iv);
            } else {
                (LazyStaggeredGridLaneInfo.SpannedItem)this.spannedItems.get($this$binarySearchBy$iv$iv).setGaps(gaps);
            }
        }
    }

    public final void setLane(int itemIndex, int lane) {
        int i;
        i = itemIndex >= 0 ? 1 : 0;
        if (i == 0) {
        } else {
            ensureValidIndex(itemIndex);
            this.lanes[itemIndex - anchor] = lane + 1;
        }
        int i2 = 0;
        IllegalArgumentException $i$a$RequireLazyStaggeredGridLaneInfo$setLane$1 = new IllegalArgumentException("Negative lanes are not supported".toString());
        throw $i$a$RequireLazyStaggeredGridLaneInfo$setLane$1;
    }

    public final int upperBound() {
        return anchor += length;
    }
}
