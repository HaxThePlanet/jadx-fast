package androidx.core.util;

import android.util.SparseIntArray;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.IntIterator;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u00008\n\u0000\n\u0002\u0010\u0008\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0002\u0008\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0007\u001a\u0015\u0010\u0005\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0001H\u0086\n\u001a\u0015\u0010\u0008\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0001H\u0086\u0008\u001a\u0015\u0010\t\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\n\u001a\u00020\u0001H\u0086\u0008\u001aE\u0010\u000b\u001a\u00020\u000c*\u00020\u000226\u0010\r\u001a2\u0012\u0013\u0012\u00110\u0001¢\u0006\u000c\u0008\u000f\u0012\u0008\u0008\u0010\u0012\u0004\u0008\u0008(\u0007\u0012\u0013\u0012\u00110\u0001¢\u0006\u000c\u0008\u000f\u0012\u0008\u0008\u0010\u0012\u0004\u0008\u0008(\n\u0012\u0004\u0012\u00020\u000c0\u000eH\u0086\u0008\u001a\u001d\u0010\u0011\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00012\u0006\u0010\u0012\u001a\u00020\u0001H\u0086\u0008\u001a#\u0010\u0013\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00012\u000c\u0010\u0012\u001a\u0008\u0012\u0004\u0012\u00020\u00010\u0014H\u0086\u0008\u001a\r\u0010\u0015\u001a\u00020\u0006*\u00020\u0002H\u0086\u0008\u001a\r\u0010\u0016\u001a\u00020\u0006*\u00020\u0002H\u0086\u0008\u001a\n\u0010\u0017\u001a\u00020\u0018*\u00020\u0002\u001a\u0015\u0010\u0019\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u0002H\u0086\u0002\u001a\u0012\u0010\u001b\u001a\u00020\u000c*\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u0002\u001a\u001a\u0010\u001c\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u0001\u001a\u001d\u0010\u001d\u001a\u00020\u000c*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u0001H\u0086\n\u001a\n\u0010\u001e\u001a\u00020\u0018*\u00020\u0002\"\u0016\u0010\u0000\u001a\u00020\u0001*\u00020\u00028Æ\u0002¢\u0006\u0006\u001a\u0004\u0008\u0003\u0010\u0004¨\u0006\u001f", d2 = {"size", "", "Landroid/util/SparseIntArray;", "getSize", "(Landroid/util/SparseIntArray;)I", "contains", "", "key", "containsKey", "containsValue", "value", "forEach", "", "action", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "getOrDefault", "defaultValue", "getOrElse", "Lkotlin/Function0;", "isEmpty", "isNotEmpty", "keyIterator", "Lkotlin/collections/IntIterator;", "plus", "other", "putAll", "remove", "set", "valueIterator", "core-ktx_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class SparseIntArrayKt {
    public static final boolean contains(SparseIntArray $this$contains, int key) {
        int i;
        final int i2 = 0;
        i = $this$contains.indexOfKey(key) >= 0 ? 1 : 0;
        return i;
    }

    public static final boolean containsKey(SparseIntArray $this$containsKey, int key) {
        int i;
        final int i2 = 0;
        i = $this$containsKey.indexOfKey(key) >= 0 ? 1 : 0;
        return i;
    }

    public static final boolean containsValue(SparseIntArray $this$containsValue, int value) {
        int i;
        final int i2 = 0;
        i = $this$containsValue.indexOfValue(value) >= 0 ? 1 : 0;
        return i;
    }

    public static final void forEach(SparseIntArray $this$forEach, Function2<? super Integer, ? super Integer, Unit> action) {
        int index;
        Integer valueOf2;
        Integer valueOf;
        final int i = 0;
        index = 0;
        while (index < $this$forEach.size()) {
            action.invoke(Integer.valueOf($this$forEach.keyAt(index)), Integer.valueOf($this$forEach.valueAt(index)));
            index++;
        }
    }

    public static final int getOrDefault(SparseIntArray $this$getOrDefault, int key, int defaultValue) {
        final int i = 0;
        return $this$getOrDefault.get(key, defaultValue);
    }

    public static final int getOrElse(SparseIntArray $this$getOrElse, int key, Function0<Integer> defaultValue) {
        int intValue;
        final int i = 0;
        final int indexOfKey = $this$getOrElse.indexOfKey(key);
        final int i2 = 0;
        if (indexOfKey >= 0) {
            intValue = $this$getOrElse.valueAt(indexOfKey);
        } else {
            intValue = (Number)defaultValue.invoke().intValue();
        }
        return intValue;
    }

    public static final int getSize(SparseIntArray $this$size) {
        final int i = 0;
        return $this$size.size();
    }

    public static final boolean isEmpty(SparseIntArray $this$isEmpty) {
        int i;
        final int i2 = 0;
        i = $this$isEmpty.size() == 0 ? 1 : 0;
        return i;
    }

    public static final boolean isNotEmpty(SparseIntArray $this$isNotEmpty) {
        int i;
        final int i2 = 0;
        i = $this$isNotEmpty.size() != 0 ? 1 : 0;
        return i;
    }

    public static final IntIterator keyIterator(SparseIntArray $this$keyIterator) {
        SparseIntArrayKt.keyIterator.1 anon = new SparseIntArrayKt.keyIterator.1($this$keyIterator);
        return (IntIterator)anon;
    }

    public static final SparseIntArray plus(SparseIntArray $this$plus, SparseIntArray other) {
        SparseIntArray sparseIntArray = new SparseIntArray(size += size2);
        SparseIntArrayKt.putAll(sparseIntArray, $this$plus);
        SparseIntArrayKt.putAll(sparseIntArray, other);
        return sparseIntArray;
    }

    public static final void putAll(SparseIntArray $this$putAll, SparseIntArray other) {
        int index$iv;
        int keyAt;
        int valueAt;
        int i;
        final Object obj = other;
        final int i2 = 0;
        index$iv = 0;
        while (index$iv < obj.size()) {
            i = 0;
            $this$putAll.put(obj.keyAt(index$iv), obj.valueAt(index$iv));
            index$iv++;
        }
    }

    public static final boolean remove(SparseIntArray $this$remove, int key, int value) {
        int valueAt;
        final int indexOfKey = $this$remove.indexOfKey(key);
        if (indexOfKey >= 0 && value == $this$remove.valueAt(indexOfKey)) {
            if (value == $this$remove.valueAt(indexOfKey)) {
                $this$remove.removeAt(indexOfKey);
                return 1;
            }
        }
        return 0;
    }

    public static final void set(SparseIntArray $this$set, int key, int value) {
        final int i = 0;
        $this$set.put(key, value);
    }

    public static final IntIterator valueIterator(SparseIntArray $this$valueIterator) {
        SparseIntArrayKt.valueIterator.1 anon = new SparseIntArrayKt.valueIterator.1($this$valueIterator);
        return (IntIterator)anon;
    }
}
