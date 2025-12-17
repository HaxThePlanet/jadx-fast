package androidx.compose.foundation.lazy.grid;

import androidx.compose.foundation.lazy.layout.IntervalList.Interval;
import androidx.compose.foundation.lazy.layout.MutableIntervalList;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.RangesKt;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0008\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0008\n\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u0002\n\u0002\u0008\u0006\u0008\u0000\u0018\u00002\u00020\u0001:\u0003()*B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0016\u0010\u001d\u001a\u0008\u0012\u0004\u0012\u00020\u00150\u00142\u0006\u0010\u001e\u001a\u00020\u0006H\u0002J\u000e\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u0006J\u000e\u0010\"\u001a\u00020\u00062\u0006\u0010#\u001a\u00020\u0006J\u0008\u0010$\u001a\u00020%H\u0002J\u0016\u0010&\u001a\u00020\u00062\u0006\u0010#\u001a\u00020\u00062\u0006\u0010'\u001a\u00020\u0006R\u0014\u0010\u0005\u001a\u00020\u00068BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008\u0007\u0010\u0008R\u001e\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\nj\u0008\u0012\u0004\u0012\u00020\u000b`\u000cX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\u0008\u0012\u0004\u0012\u00020\u00060\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\u0008\u0012\u0004\u0012\u00020\u00150\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u0006@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0018\u0010\u0008\"\u0004\u0008\u0019\u0010\u001aR\u0011\u0010\u001b\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\u0008\u001c\u0010\u0008¨\u0006+", d2 = {"Landroidx/compose/foundation/lazy/grid/LazyGridSpanLayoutProvider;", "", "gridContent", "Landroidx/compose/foundation/lazy/grid/LazyGridIntervalContent;", "(Landroidx/compose/foundation/lazy/grid/LazyGridIntervalContent;)V", "bucketSize", "", "getBucketSize", "()I", "buckets", "Ljava/util/ArrayList;", "Landroidx/compose/foundation/lazy/grid/LazyGridSpanLayoutProvider$Bucket;", "Lkotlin/collections/ArrayList;", "cachedBucket", "", "cachedBucketIndex", "lastLineIndex", "lastLineStartItemIndex", "lastLineStartKnownSpan", "previousDefaultSpans", "", "Landroidx/compose/foundation/lazy/grid/GridItemSpan;", "value", "slotsPerLine", "getSlotsPerLine", "setSlotsPerLine", "(I)V", "totalSize", "getTotalSize", "getDefaultSpans", "currentSlotsPerLine", "getLineConfiguration", "Landroidx/compose/foundation/lazy/grid/LazyGridSpanLayoutProvider$LineConfiguration;", "lineIndex", "getLineIndexOfItem", "itemIndex", "invalidateCache", "", "spanOf", "maxSpan", "Bucket", "LazyGridItemSpanScopeImpl", "LineConfiguration", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class LazyGridSpanLayoutProvider {

    public static final int $stable = 8;
    private final ArrayList<androidx.compose.foundation.lazy.grid.LazyGridSpanLayoutProvider.Bucket> buckets;
    private final List<Integer> cachedBucket;
    private int cachedBucketIndex = -1;
    private final androidx.compose.foundation.lazy.grid.LazyGridIntervalContent gridContent;
    private int lastLineIndex;
    private int lastLineStartItemIndex;
    private int lastLineStartKnownSpan;
    private List<androidx.compose.foundation.lazy.grid.GridItemSpan> previousDefaultSpans;
    private int slotsPerLine;

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0006\u0008\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0008\u0010\u0007¨\u0006\t", d2 = {"Landroidx/compose/foundation/lazy/grid/LazyGridSpanLayoutProvider$Bucket;", "", "firstItemIndex", "", "firstItemKnownSpan", "(II)V", "getFirstItemIndex", "()I", "getFirstItemKnownSpan", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private static final class Bucket {

        private final int firstItemIndex;
        private final int firstItemKnownSpan;
        public Bucket(int firstItemIndex, int firstItemKnownSpan) {
            super();
            this.firstItemIndex = firstItemIndex;
            this.firstItemKnownSpan = firstItemKnownSpan;
        }

        public Bucket(int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker4) {
            int obj2;
            obj2 = i3 &= 2 != 0 ? 0 : obj2;
            super(i, obj2);
        }

        public final int getFirstItemIndex() {
            return this.firstItemIndex;
        }

        public final int getFirstItemKnownSpan() {
            return this.firstItemKnownSpan;
        }
    }

    @Metadata(d1 = "\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0008\u0008Â\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006\"\u0004\u0008\u0007\u0010\u0008R\u001a\u0010\t\u001a\u00020\u0004X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\n\u0010\u0006\"\u0004\u0008\u000b\u0010\u0008¨\u0006\u000c", d2 = {"Landroidx/compose/foundation/lazy/grid/LazyGridSpanLayoutProvider$LazyGridItemSpanScopeImpl;", "Landroidx/compose/foundation/lazy/grid/LazyGridItemSpanScope;", "()V", "maxCurrentLineSpan", "", "getMaxCurrentLineSpan", "()I", "setMaxCurrentLineSpan", "(I)V", "maxLineSpan", "getMaxLineSpan", "setMaxLineSpan", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private static final class LazyGridItemSpanScopeImpl implements androidx.compose.foundation.lazy.grid.LazyGridItemSpanScope {

        public static final androidx.compose.foundation.lazy.grid.LazyGridSpanLayoutProvider.LazyGridItemSpanScopeImpl INSTANCE;
        private static int maxCurrentLineSpan;
        private static int maxLineSpan;
        static {
            LazyGridSpanLayoutProvider.LazyGridItemSpanScopeImpl lazyGridItemSpanScopeImpl = new LazyGridSpanLayoutProvider.LazyGridItemSpanScopeImpl();
            LazyGridSpanLayoutProvider.LazyGridItemSpanScopeImpl.INSTANCE = lazyGridItemSpanScopeImpl;
        }

        @Override // androidx.compose.foundation.lazy.grid.LazyGridItemSpanScope
        public int getMaxCurrentLineSpan() {
            return LazyGridSpanLayoutProvider.LazyGridItemSpanScopeImpl.maxCurrentLineSpan;
        }

        @Override // androidx.compose.foundation.lazy.grid.LazyGridItemSpanScope
        public int getMaxLineSpan() {
            return LazyGridSpanLayoutProvider.LazyGridItemSpanScopeImpl.maxLineSpan;
        }

        @Override // androidx.compose.foundation.lazy.grid.LazyGridItemSpanScope
        public void setMaxCurrentLineSpan(int <set-?>) {
            LazyGridSpanLayoutProvider.LazyGridItemSpanScopeImpl.maxCurrentLineSpan = <set-?>;
        }

        @Override // androidx.compose.foundation.lazy.grid.LazyGridItemSpanScope
        public void setMaxLineSpan(int <set-?>) {
            LazyGridSpanLayoutProvider.LazyGridItemSpanScopeImpl.maxLineSpan = <set-?>;
        }
    }

    @Metadata(d1 = "\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0008\u0006\u0008\u0007\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000c\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0008\u0010\tR\u0017\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\n\u0010\u000b¨\u0006\u000c", d2 = {"Landroidx/compose/foundation/lazy/grid/LazyGridSpanLayoutProvider$LineConfiguration;", "", "firstItemIndex", "", "spans", "", "Landroidx/compose/foundation/lazy/grid/GridItemSpan;", "(ILjava/util/List;)V", "getFirstItemIndex", "()I", "getSpans", "()Ljava/util/List;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class LineConfiguration {

        public static final int $stable = 8;
        private final int firstItemIndex;
        private final List<androidx.compose.foundation.lazy.grid.GridItemSpan> spans;
        static {
            final int i = 8;
        }

        public LineConfiguration(int firstItemIndex, List<androidx.compose.foundation.lazy.grid.GridItemSpan> spans) {
            super();
            this.firstItemIndex = firstItemIndex;
            this.spans = spans;
        }

        public final int getFirstItemIndex() {
            return this.firstItemIndex;
        }

        public final List<androidx.compose.foundation.lazy.grid.GridItemSpan> getSpans() {
            return this.spans;
        }
    }
    static {
        final int i = 8;
    }

    public LazyGridSpanLayoutProvider(androidx.compose.foundation.lazy.grid.LazyGridIntervalContent gridContent) {
        super();
        this.gridContent = gridContent;
        ArrayList arrayList = new ArrayList();
        final int i2 = 0;
        final int i5 = 0;
        LazyGridSpanLayoutProvider.Bucket bucket = new LazyGridSpanLayoutProvider.Bucket(i5, i5, 2, 0);
        arrayList.add(bucket);
        this.buckets = arrayList;
        int i = -1;
        ArrayList arrayList2 = new ArrayList();
        this.cachedBucket = (List)arrayList2;
        this.previousDefaultSpans = CollectionsKt.emptyList();
    }

    private final int getBucketSize() {
        return i3++;
    }

    private final List<androidx.compose.foundation.lazy.grid.GridItemSpan> getDefaultSpans(int currentSlotsPerLine) {
        Object previousDefaultSpans;
        ArrayList list;
        int i3;
        int box-impl;
        int i;
        int i2;
        if (currentSlotsPerLine == this.previousDefaultSpans.size()) {
            previousDefaultSpans = this.previousDefaultSpans;
        } else {
            previousDefaultSpans = new ArrayList(currentSlotsPerLine);
            i3 = 0;
            while (i3 < currentSlotsPerLine) {
                int i4 = i3;
                previousDefaultSpans.add(GridItemSpan.box-impl(LazyGridSpanKt.GridItemSpan(1)));
                i3++;
            }
            box-impl = 0;
            this.previousDefaultSpans = (List)previousDefaultSpans;
        }
        return previousDefaultSpans;
    }

    private final void invalidateCache() {
        this.buckets.clear();
        final int i4 = 0;
        LazyGridSpanLayoutProvider.Bucket bucket = new LazyGridSpanLayoutProvider.Bucket(i4, i4, 2, 0);
        this.buckets.add(bucket);
        this.lastLineIndex = i4;
        this.lastLineStartItemIndex = i4;
        this.lastLineStartKnownSpan = i4;
        this.cachedBucketIndex = -1;
        this.cachedBucket.clear();
    }

    public final androidx.compose.foundation.lazy.grid.LazyGridSpanLayoutProvider.LineConfiguration getLineConfiguration(int lineIndex) {
        int currentLine;
        int currentItemIndex;
        int knownCurrentItemSpan2;
        int cachedBucketIndex;
        int i4;
        int i;
        int cachedBucket;
        int spansUsed;
        int spansUsed2;
        int it;
        int knownCurrentItemSpan;
        int box-impl;
        int i3;
        int slotsPerLine;
        int i2;
        int i8 = 0;
        if (!this.gridContent.getHasCustomSpans$foundation_release()) {
            slotsPerLine2 *= lineIndex;
            LazyGridSpanLayoutProvider.LineConfiguration lineConfiguration = new LazyGridSpanLayoutProvider.LineConfiguration(i7, getDefaultSpans(RangesKt.coerceAtLeast(RangesKt.coerceAtMost(this.slotsPerLine, totalSize -= i7), i8)));
            return lineConfiguration;
        }
        int i12 = 1;
        int i6 = Math.min(lineIndex / bucketSize, size -= i12);
        bucketSize2 *= i6;
        currentItemIndex = (LazyGridSpanLayoutProvider.Bucket)this.buckets.get(i6).getFirstItemIndex();
        int i14 = 0;
        knownCurrentItemSpan2 = (LazyGridSpanLayoutProvider.Bucket)this.buckets.get(i6).getFirstItemKnownSpan();
        int lastLineIndex = this.lastLineIndex;
        if (currentLine <= lastLineIndex && lastLineIndex <= lineIndex) {
            cachedBucketIndex = lastLineIndex <= lineIndex ? i12 : i8;
        } else {
        }
        if (cachedBucketIndex != 0) {
            currentLine = this.lastLineIndex;
            currentItemIndex = this.lastLineStartItemIndex;
            knownCurrentItemSpan2 = this.lastLineStartKnownSpan;
        } else {
            if (i6 == this.cachedBucketIndex && lineIndex - currentLine < this.cachedBucket.size()) {
                if (lineIndex - currentLine < this.cachedBucket.size()) {
                    currentItemIndex = (Number)this.cachedBucket.get(lineIndex - currentLine).intValue();
                    currentLine = lineIndex;
                    knownCurrentItemSpan2 = 0;
                }
            }
        }
        if (currentLine % bucketSize3 == 0) {
            cachedBucket = lineIndex - currentLine;
            if (2 <= cachedBucket && cachedBucket < getBucketSize()) {
                i4 = cachedBucket < getBucketSize() ? i12 : i8;
            } else {
            }
            i = i4 != 0 ? i12 : i8;
        } else {
        }
        if (i != 0) {
            this.cachedBucketIndex = i6;
            this.cachedBucket.clear();
        }
        spansUsed = currentLine <= lineIndex ? i12 : i8;
        if (spansUsed == 0) {
        }
        int firstItemIndex = 0;
        IllegalStateException $i$a$CheckLazyGridSpanLayoutProvider$getLineConfiguration$1 = new IllegalStateException("currentLine > lineIndex".toString());
        throw $i$a$CheckLazyGridSpanLayoutProvider$getLineConfiguration$1;
    }

    public final int getLineIndexOfItem(int itemIndex) {
        int i3;
        int it;
        int currentLine;
        int i;
        int span;
        int i4;
        int spansUsed;
        int i7;
        int i5;
        int i9;
        int slotsPerLine;
        androidx.compose.foundation.lazy.grid.LazyGridSpanLayoutProvider.Bucket bucket;
        int i2;
        int i6;
        int i8;
        int i11 = 0;
        if (getTotalSize() <= 0) {
            return i11;
        }
        int i15 = 1;
        i3 = itemIndex < getTotalSize() ? i15 : i11;
        if (i3 == 0) {
        } else {
            if (!this.gridContent.getHasCustomSpans$foundation_release()) {
                return itemIndex / slotsPerLine2;
            }
            LazyGridSpanLayoutProvider.getLineIndexOfItem.lowerBoundBucket.1 anon = new LazyGridSpanLayoutProvider.getLineIndexOfItem.lowerBoundBucket.1(itemIndex);
            it = CollectionsKt.binarySearch$default((List)this.buckets, 0, 0, (Function1)anon, 3, 0);
            int i16 = 0;
            int i18 = 2;
            if (it >= 0) {
            } else {
                it = i;
            }
            bucketSize *= it;
            i4 = (LazyGridSpanLayoutProvider.Bucket)this.buckets.get(it).getFirstItemIndex() <= itemIndex ? i15 : i11;
            if (i4 == 0) {
            } else {
                spansUsed = 0;
                while (span < itemIndex) {
                    i7 = span + 1;
                    int spanOf2 = spanOf(span, slotsPerLine5 -= spansUsed);
                    if (spansUsed + spanOf2 < this.slotsPerLine) {
                    } else {
                    }
                    if (spansUsed + spanOf2 == this.slotsPerLine) {
                    } else {
                    }
                    currentLine++;
                    spansUsed = spanOf2;
                    if (currentLine % bucketSize2 == 0 && currentLine / bucketSize3 >= this.buckets.size()) {
                    }
                    span = i7;
                    if (currentLine / bucketSize3 >= this.buckets.size()) {
                    }
                    if (spansUsed > 0) {
                    } else {
                    }
                    i6 = i11;
                    bucket = new LazyGridSpanLayoutProvider.Bucket(i7 - i6, i11, i18, 0);
                    this.buckets.add(bucket);
                    i6 = i15;
                    currentLine++;
                    spansUsed = 0;
                    spansUsed += spanOf2;
                }
                if (spanOf += spansUsed > this.slotsPerLine) {
                    currentLine++;
                }
                return currentLine;
            }
            int i14 = 0;
            IllegalArgumentException $i$a$RequireLazyGridSpanLayoutProvider$getLineIndexOfItem$2 = new IllegalArgumentException("currentItemIndex > itemIndex".toString());
            throw $i$a$RequireLazyGridSpanLayoutProvider$getLineIndexOfItem$2;
        }
        int lowerBoundBucket = 0;
        IllegalArgumentException $i$a$RequireLazyGridSpanLayoutProvider$getLineIndexOfItem$1 = new IllegalArgumentException("ItemIndex > total count".toString());
        throw $i$a$RequireLazyGridSpanLayoutProvider$getLineIndexOfItem$1;
    }

    public final int getSlotsPerLine() {
        return this.slotsPerLine;
    }

    public final int getTotalSize() {
        return this.gridContent.getIntervals().getSize();
    }

    public final void setSlotsPerLine(int value) {
        if (value != this.slotsPerLine) {
            this.slotsPerLine = value;
            invalidateCache();
        }
    }

    public final int spanOf(int itemIndex, int maxSpan) {
        final androidx.compose.foundation.lazy.grid.LazyGridSpanLayoutProvider.LazyGridItemSpanScopeImpl iNSTANCE = LazyGridSpanLayoutProvider.LazyGridItemSpanScopeImpl.INSTANCE;
        final int i = 0;
        iNSTANCE.setMaxCurrentLineSpan(maxSpan);
        iNSTANCE.setMaxLineSpan(this.slotsPerLine);
        IntervalList.Interval list = this.gridContent.getIntervals().get(itemIndex);
        final Integer valueOf = Integer.valueOf(itemIndex - startIndex);
        return GridItemSpan.getCurrentLineSpan-impl((GridItemSpan)(LazyGridInterval)list.getValue().getSpan().invoke(iNSTANCE, valueOf).unbox-impl());
    }
}
