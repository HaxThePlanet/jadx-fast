package kotlin.collections;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000\u0018\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010!\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0007\u001a\u001c\u0010\u0000\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\u0008\u0000\u0010\u0002*\u0008\u0012\u0004\u0012\u0002H\u00020\u0001\u001a#\u0010\u0000\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\u0003\"\u0004\u0008\u0000\u0010\u0002*\u0008\u0012\u0004\u0012\u0002H\u00020\u0003H\u0007¢\u0006\u0002\u0008\u0004\u001a\u001d\u0010\u0005\u001a\u00020\u0006*\u0006\u0012\u0002\u0008\u00030\u00012\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0002\u0008\u0008\u001a\u001d\u0010\t\u001a\u00020\u0006*\u0006\u0012\u0002\u0008\u00030\u00012\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0002\u0008\n\u001a\u001d\u0010\u000b\u001a\u00020\u0006*\u0006\u0012\u0002\u0008\u00030\u00012\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0002\u0008\u000c¨\u0006\r", d2 = {"asReversed", "", "T", "", "asReversedMutable", "reverseElementIndex", "", "index", "reverseElementIndex$CollectionsKt__ReversedViewsKt", "reverseIteratorIndex", "reverseIteratorIndex$CollectionsKt__ReversedViewsKt", "reversePositionIndex", "reversePositionIndex$CollectionsKt__ReversedViewsKt", "kotlin-stdlib"}, k = 5, mv = {1, 9, 0}, xi = 49, xs = "kotlin/collections/CollectionsKt")
class CollectionsKt__ReversedViewsKt extends kotlin.collections.CollectionsKt__MutableCollectionsKt {
    public static final int access$reverseElementIndex(List $receiver, int index) {
        return CollectionsKt__ReversedViewsKt.reverseElementIndex$CollectionsKt__ReversedViewsKt($receiver, index);
    }

    public static final int access$reverseIteratorIndex(List $receiver, int index) {
        return CollectionsKt__ReversedViewsKt.reverseIteratorIndex$CollectionsKt__ReversedViewsKt($receiver, index);
    }

    public static final int access$reversePositionIndex(List $receiver, int index) {
        return CollectionsKt__ReversedViewsKt.reversePositionIndex$CollectionsKt__ReversedViewsKt($receiver, index);
    }

    public static final <T> List<T> asReversed(List<? extends T> $this$asReversed) {
        Intrinsics.checkNotNullParameter($this$asReversed, "<this>");
        ReversedListReadOnly reversedListReadOnly = new ReversedListReadOnly($this$asReversed);
        return (List)reversedListReadOnly;
    }

    public static final <T> List<T> asReversedMutable(List<T> $this$asReversed) {
        Intrinsics.checkNotNullParameter($this$asReversed, "<this>");
        ReversedList reversedList = new ReversedList($this$asReversed);
        return (List)reversedList;
    }

    private static final int reverseElementIndex$CollectionsKt__ReversedViewsKt(List<?> $this$reverseElementIndex, int index) {
        int lastIndex;
        int i;
        int i2 = 0;
        if (index >= 0 && index <= CollectionsKt.getLastIndex($this$reverseElementIndex)) {
            i = index <= CollectionsKt.getLastIndex($this$reverseElementIndex) ? 1 : i2;
        } else {
        }
        if (i == 0) {
        } else {
            return lastIndex2 -= index;
        }
        StringBuilder stringBuilder = new StringBuilder();
        IntRange intRange = new IntRange(i2, CollectionsKt.getLastIndex($this$reverseElementIndex));
        IndexOutOfBoundsException indexOutOfBoundsException = new IndexOutOfBoundsException(stringBuilder.append("Element index ").append(index).append(" must be in range [").append(intRange).append("].").toString());
        throw indexOutOfBoundsException;
    }

    private static final int reverseIteratorIndex$CollectionsKt__ReversedViewsKt(List<?> $this$reverseIteratorIndex, int index) {
        return lastIndex -= index;
    }

    private static final int reversePositionIndex$CollectionsKt__ReversedViewsKt(List<?> $this$reversePositionIndex, int index) {
        int size;
        int i;
        int i2 = 0;
        if (index >= 0 && index <= $this$reversePositionIndex.size()) {
            i = index <= $this$reversePositionIndex.size() ? 1 : i2;
        } else {
        }
        if (i == 0) {
        } else {
            return size2 -= index;
        }
        StringBuilder stringBuilder = new StringBuilder();
        IntRange intRange = new IntRange(i2, $this$reversePositionIndex.size());
        IndexOutOfBoundsException indexOutOfBoundsException = new IndexOutOfBoundsException(stringBuilder.append("Position index ").append(index).append(" must be in range [").append(intRange).append("].").toString());
        throw indexOutOfBoundsException;
    }
}
