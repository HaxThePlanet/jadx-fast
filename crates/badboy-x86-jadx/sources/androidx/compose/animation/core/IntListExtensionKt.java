package androidx.compose.animation.core;

import androidx.collection.IntList;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u000e\n\u0000\n\u0002\u0010\u0008\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u001a(\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00012\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00012\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u0001H\u0001¨\u0006\u0006", d2 = {"binarySearch", "", "Landroidx/collection/IntList;", "element", "fromIndex", "toIndex", "animation-core_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class IntListExtensionKt {
    public static final int binarySearch(IntList intList, int i2) {
        return IntListExtensionKt.binarySearch$default(intList, i2, 0, 0, 6, 0);
    }

    public static final int binarySearch(IntList intList, int i2, int i3) {
        return IntListExtensionKt.binarySearch$default(intList, i2, i3, 0, 4, 0);
    }

    public static final int binarySearch(IntList $this$binarySearch, int element, int fromIndex, int toIndex) {
        int i;
        int low;
        int high;
        String string;
        StringBuilder append;
        int i2;
        int i3 = 1;
        i = fromIndex <= toIndex ? i3 : 0;
        int i6 = 0;
        if (i == 0) {
            int i7 = 0;
            StringBuilder stringBuilder3 = new StringBuilder();
            PreconditionsKt.throwIllegalArgumentException(stringBuilder3.append("fromIndex(").append(fromIndex).append(") > toIndex(").append(toIndex).append(')').toString());
        }
        String value$iv = "Index out of range: ";
        if (fromIndex < 0) {
        } else {
            if (toIndex > $this$binarySearch.getSize()) {
            } else {
                low = fromIndex;
                high = toIndex + -1;
                while (low <= high) {
                    i8 >>>= i3;
                    append = $this$binarySearch.get(string);
                    high = i2;
                    low = string + 1;
                }
                return -i4;
            }
            StringBuilder stringBuilder = new StringBuilder();
            IndexOutOfBoundsException indexOutOfBoundsException = new IndexOutOfBoundsException(stringBuilder.append(value$iv).append(toIndex).toString());
            throw indexOutOfBoundsException;
        }
        StringBuilder stringBuilder2 = new StringBuilder();
        IndexOutOfBoundsException indexOutOfBoundsException2 = new IndexOutOfBoundsException(stringBuilder2.append(value$iv).append(fromIndex).toString());
        throw indexOutOfBoundsException2;
    }

    public static int binarySearch$default(IntList intList, int i2, int i3, int i4, int i5, Object object6) {
        int obj2;
        int obj3;
        if (i5 & 2 != 0) {
            obj2 = 0;
        }
        if (i5 &= 4 != 0) {
            obj3 = intList.getSize();
        }
        return IntListExtensionKt.binarySearch(intList, i2, obj2, obj3);
    }
}
