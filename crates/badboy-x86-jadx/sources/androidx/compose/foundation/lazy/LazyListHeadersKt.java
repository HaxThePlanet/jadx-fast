package androidx.compose.foundation.lazy;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u0008\n\u0002\u0008\u0004\u001aF\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u000c\u0010\u0002\u001a\u0008\u0012\u0004\u0012\u00020\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u000c\u0010\u0006\u001a\u0008\u0012\u0004\u0012\u00020\u00080\u00072\u0006\u0010\t\u001a\u00020\u00082\u0006\u0010\n\u001a\u00020\u00082\u0006\u0010\u000b\u001a\u00020\u0008H\u0000¨\u0006\u000c", d2 = {"findOrComposeLazyListHeader", "Landroidx/compose/foundation/lazy/LazyListMeasuredItem;", "composedVisibleItems", "", "itemProvider", "Landroidx/compose/foundation/lazy/LazyListMeasuredItemProvider;", "headerIndexes", "", "", "beforeContentPadding", "layoutWidth", "layoutHeight", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class LazyListHeadersKt {
    public static final androidx.compose.foundation.lazy.LazyListMeasuredItem findOrComposeLazyListHeader(List<androidx.compose.foundation.lazy.LazyListMeasuredItem> composedVisibleItems, androidx.compose.foundation.lazy.LazyListMeasuredItemProvider itemProvider, List<Integer> headerIndexes, int beforeContentPadding, int layoutWidth, int layoutHeight) {
        int currentHeaderOffset;
        int nextHeaderOffset;
        int currentHeaderListPosition3;
        int currentHeaderListPosition;
        int index2;
        int nextHeaderListPosition;
        int index;
        int indexInComposedVisibleItems;
        int i4;
        int intValue;
        int headerOffset;
        int currentHeaderListPosition2;
        int lastIndex;
        int index$iv;
        int i;
        Object obj;
        Object obj2;
        int i2;
        int i3;
        final List list = composedVisibleItems;
        final List list2 = headerIndexes;
        final int i5 = beforeContentPadding;
        int i6 = 0;
        currentHeaderOffset = Integer.MIN_VALUE;
        int i7 = 0;
        nextHeaderOffset = Integer.MIN_VALUE;
        int i8 = 0;
        int i11 = 0;
        nextHeaderListPosition = -1;
        index = 0;
        currentHeaderListPosition2 = currentHeaderListPosition3;
        while (index < list2.size()) {
            if ((Number)list2.get(index).intValue() > (LazyListMeasuredItem)CollectionsKt.first(list).getIndex()) {
                break;
            } else {
            }
            currentHeaderListPosition2 = (Number)list2.get(index).intValue();
            intValue = index + 1;
            if (intValue >= 0 && intValue <= CollectionsKt.getLastIndex(list2)) {
            } else {
            }
            lastIndex = 0;
            currentHeaderListPosition3 = -1;
            nextHeaderListPosition = (Number)currentHeaderListPosition3.intValue();
            index++;
            if (intValue <= CollectionsKt.getLastIndex(list2)) {
            } else {
            }
            currentHeaderListPosition3 = list2.get(intValue);
        }
        int index5 = 0;
        indexInComposedVisibleItems = -1;
        List list3 = composedVisibleItems;
        int i14 = 0;
        index$iv = 0;
        int size3 = list3.size();
        while (index$iv < size3) {
            obj2 = obj;
            i3 = 0;
            if ((LazyListMeasuredItem)obj2.getIndex() == currentHeaderListPosition2) {
            } else {
            }
            if (obj2.getIndex() == nextHeaderListPosition) {
            }
            index$iv++;
            currentHeaderListPosition = -1;
            nextHeaderOffset = obj2.getOffset();
            currentHeaderOffset = obj2.getOffset();
            indexInComposedVisibleItems = index2;
        }
        if (currentHeaderListPosition2 == -1) {
            return null;
        }
        androidx.compose.foundation.lazy.LazyListMeasuredItem andMeasure-0kLqBqw$default = LazyListMeasuredItemProvider.getAndMeasure-0kLqBqw$default(itemProvider, currentHeaderListPosition2, 0, size3, 2);
        andMeasure-0kLqBqw$default.setNonScrollableItem(true);
        i4 = Integer.MIN_VALUE;
        if (currentHeaderOffset != i4) {
            headerOffset = Math.max(-i5, currentHeaderOffset);
        } else {
            headerOffset = -i5;
        }
        if (nextHeaderOffset != i4) {
            headerOffset = Math.min(headerOffset, nextHeaderOffset - size2);
        }
        andMeasure-0kLqBqw$default.position(headerOffset, layoutWidth, layoutHeight);
        if (indexInComposedVisibleItems != -1) {
            list.set(indexInComposedVisibleItems, andMeasure-0kLqBqw$default);
        } else {
            list.add(0, andMeasure-0kLqBqw$default);
        }
        return andMeasure-0kLqBqw$default;
    }
}
