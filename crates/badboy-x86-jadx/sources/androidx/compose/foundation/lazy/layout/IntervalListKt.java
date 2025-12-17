package androidx.compose.foundation.lazy.layout;

import androidx.compose.runtime.collection.MutableVector;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u0014\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u001a&\u0010\u0000\u001a\u00020\u0001\"\u0004\u0008\u0000\u0010\u0002*\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u0002H\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0001H\u0003¨\u0006\u0006", d2 = {"binarySearch", "", "T", "Landroidx/compose/runtime/collection/MutableVector;", "Landroidx/compose/foundation/lazy/layout/IntervalList$Interval;", "itemIndex", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class IntervalListKt {
    public static final int access$binarySearch(MutableVector $receiver, int itemIndex) {
        return IntervalListKt.binarySearch($receiver, itemIndex);
    }

    private static final <T> int binarySearch(MutableVector<androidx.compose.foundation.lazy.layout.IntervalList.Interval<T>> $this$binarySearch, int itemIndex) {
        int left;
        int i;
        int startIndex;
        int right;
        int startIndex2;
        Object[] content;
        Object[] content2;
        left = 0;
        startIndex = 0;
        size--;
        while (left < right) {
            i3 += left;
            startIndex2 = 0;
            startIndex = (IntervalList.Interval)$this$binarySearch.getContent()[i].getStartIndex();
            right = i + -1;
            content = 0;
        }
        return left;
    }
}
