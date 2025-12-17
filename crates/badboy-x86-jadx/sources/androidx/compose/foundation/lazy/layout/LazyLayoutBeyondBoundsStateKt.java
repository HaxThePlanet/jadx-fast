package androidx.compose.foundation.lazy.layout;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.ranges.IntRange;
import kotlin.ranges.IntRange.Companion;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u001c\n\u0000\n\u0002\u0010 \n\u0002\u0010\u0008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\"\u0010\u0000\u001a\u0008\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0000¨\u0006\u0008", d2 = {"calculateLazyLayoutPinnedIndices", "", "", "Landroidx/compose/foundation/lazy/layout/LazyLayoutItemProvider;", "pinnedItemList", "Landroidx/compose/foundation/lazy/layout/LazyLayoutPinnedItemList;", "beyondBoundsInfo", "Landroidx/compose/foundation/lazy/layout/LazyLayoutBeyondBoundsInfo;", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class LazyLayoutBeyondBoundsStateKt {
    public static final List<Integer> calculateLazyLayoutPinnedIndices(androidx.compose.foundation.lazy.layout.LazyLayoutItemProvider $this$calculateLazyLayoutPinnedIndices, androidx.compose.foundation.lazy.layout.LazyLayoutPinnedItemList pinnedItemList, androidx.compose.foundation.lazy.layout.LazyLayoutBeyondBoundsInfo beyondBoundsInfo) {
        boolean intervals;
        IntRange intRange;
        int i;
        int start;
        int i3;
        int valueOf;
        int i5;
        int index$iv;
        Object obj2;
        Object obj;
        int i4;
        int indexByKey;
        int itemCount;
        int last;
        int i2;
        if (!beyondBoundsInfo.hasIntervals() && pinnedItemList.isEmpty()) {
            if (pinnedItemList.isEmpty()) {
                return CollectionsKt.emptyList();
            }
        }
        ArrayList arrayList = new ArrayList();
        int i6 = 1;
        if (beyondBoundsInfo.hasIntervals()) {
            intRange = new IntRange(beyondBoundsInfo.getStart(), Math.min(beyondBoundsInfo.getEnd(), itemCount2 -= i6));
        } else {
            intRange = IntRange.Companion.getEMPTY();
        }
        List list = pinnedItemList;
        valueOf = 0;
        index$iv = 0;
        while (index$iv < (List)list.size()) {
            obj = obj2;
            i4 = 0;
            indexByKey = LazyLayoutItemProviderKt.findIndexByKey($this$calculateLazyLayoutPinnedIndices, (LazyLayoutPinnedItemList.PinnedItem)obj.getKey(), obj.getIndex());
            if (indexByKey <= intRange.getLast() && intRange.getFirst() <= indexByKey) {
            } else {
            }
            itemCount = i2;
            if (itemCount == 0 && indexByKey >= 0 && indexByKey < $this$calculateLazyLayoutPinnedIndices.getItemCount()) {
            }
            index$iv++;
            if (indexByKey >= 0) {
            }
            if (i2 != 0) {
            }
            (List)arrayList.add(Integer.valueOf(indexByKey));
            if (indexByKey < $this$calculateLazyLayoutPinnedIndices.getItemCount()) {
            }
            i2 = i6;
            if (intRange.getFirst() <= indexByKey) {
            } else {
            }
            itemCount = i6;
        }
        int last2 = intRange.getLast();
        if (intRange.getFirst() <= last2) {
        }
        return arrayList;
    }
}
