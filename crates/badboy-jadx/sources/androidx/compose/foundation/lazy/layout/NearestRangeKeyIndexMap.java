package androidx.compose.foundation.lazy.layout;

import androidx.collection.MutableObjectIntMap;
import androidx.collection.ObjectIntMap;
import androidx.collection.ObjectIntMapKt;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.ranges.IntRange;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\u0008\u0001\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\u0010\u0004\u001a\u0006\u0012\u0002\u0008\u00030\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u000f\u001a\u00020\u000c2\u0006\u0010\u0010\u001a\u00020\tH\u0016J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0012\u001a\u00020\u000cH\u0016R\u0018\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0008X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\nR\u000e\u0010\u000b\u001a\u00020\u000cX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\u0008\u0012\u0004\u0012\u00020\t0\u000eX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013", d2 = {"Landroidx/compose/foundation/lazy/layout/NearestRangeKeyIndexMap;", "Landroidx/compose/foundation/lazy/layout/LazyLayoutKeyIndexMap;", "nearestRange", "Lkotlin/ranges/IntRange;", "intervalContent", "Landroidx/compose/foundation/lazy/layout/LazyLayoutIntervalContent;", "(Lkotlin/ranges/IntRange;Landroidx/compose/foundation/lazy/layout/LazyLayoutIntervalContent;)V", "keys", "", "", "[Ljava/lang/Object;", "keysStartIndex", "", "map", "Landroidx/collection/ObjectIntMap;", "getIndex", "key", "getKey", "index", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class NearestRangeKeyIndexMap implements androidx.compose.foundation.lazy.layout.LazyLayoutKeyIndexMap {

    public static final int $stable = 8;
    private final Object[] keys;
    private final int keysStartIndex = 0;
    private final ObjectIntMap<Object> map;
    static {
        final int i = 8;
    }

    public NearestRangeKeyIndexMap(IntRange nearestRange, androidx.compose.foundation.lazy.layout.LazyLayoutIntervalContent<?> intervalContent) {
        MutableObjectIntMap $i$f$emptyArray;
        int i4;
        int i2;
        MutableObjectIntMap i;
        int i3;
        androidx.compose.foundation.lazy.layout.NearestRangeKeyIndexMap.2.1 anon;
        super();
        final androidx.compose.foundation.lazy.layout.IntervalList intervals = intervalContent.getIntervals();
        final int first = nearestRange.getFirst();
        int i5 = 1;
        i4 = 0;
        i2 = first >= 0 ? i5 : i4;
        if (i2 == 0) {
        } else {
            int i9 = Math.min(nearestRange.getLast(), size -= i5);
            if (i9 < first) {
                this.map = ObjectIntMapKt.emptyObjectIntMap();
                int i7 = 0;
                this.keys = new Object[i4];
            } else {
                i8 += i5;
                this.keys = new Object[i4];
                this.keysStartIndex = first;
                $i$f$emptyArray = new MutableObjectIntMap(i4);
                i3 = 0;
                anon = new NearestRangeKeyIndexMap.2.1(first, i9, $i$f$emptyArray, this);
                intervals.forEach(first, i9, (Function1)anon);
                this.map = (ObjectIntMap)$i$f$emptyArray;
            }
        }
        int i6 = 0;
        IllegalStateException $i$a$CheckNearestRangeKeyIndexMap$1 = new IllegalStateException("negative nearestRange.first".toString());
        throw $i$a$CheckNearestRangeKeyIndexMap$1;
    }

    public static final Object[] access$getKeys$p(androidx.compose.foundation.lazy.layout.NearestRangeKeyIndexMap $this) {
        return $this.keys;
    }

    public static final int access$getKeysStartIndex$p(androidx.compose.foundation.lazy.layout.NearestRangeKeyIndexMap $this) {
        return $this.keysStartIndex;
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutKeyIndexMap
    public int getIndex(Object key) {
        int $i$a$GetOrElseNearestRangeKeyIndexMap$getIndex$1;
        final ObjectIntMap map = this.map;
        final int i = 0;
        final int keyIndex = map.findKeyIndex(key);
        if (keyIndex >= 0) {
            $i$a$GetOrElseNearestRangeKeyIndexMap$getIndex$1 = map.values[keyIndex];
        } else {
            int i2 = 0;
            $i$a$GetOrElseNearestRangeKeyIndexMap$getIndex$1 = -1;
        }
        return $i$a$GetOrElseNearestRangeKeyIndexMap$getIndex$1;
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutKeyIndexMap
    public Object getKey(int index) {
        int $i$a$GetOrElseNearestRangeKeyIndexMap$getKey$1;
        int lastIndex;
        Object[] keys = this.keys;
        int i2 = index - keysStartIndex;
        if (i2 >= 0 && i2 <= ArraysKt.getLastIndex(keys)) {
            if (i2 <= ArraysKt.getLastIndex(keys)) {
                $i$a$GetOrElseNearestRangeKeyIndexMap$getKey$1 = keys[i2];
            } else {
                int i = 0;
                $i$a$GetOrElseNearestRangeKeyIndexMap$getKey$1 = 0;
            }
        } else {
        }
        return $i$a$GetOrElseNearestRangeKeyIndexMap$getKey$1;
    }
}
