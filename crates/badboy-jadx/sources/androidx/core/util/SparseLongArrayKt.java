package androidx.core.util;

import android.util.SparseLongArray;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.IntIterator;
import kotlin.collections.LongIterator;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000D\n\u0000\n\u0002\u0010\u0008\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0002\u0008\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0000\u001a\u0015\u0010\u0005\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0001H\u0086\n\u001a\u0015\u0010\u0008\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0001H\u0086\u0008\u001a\u0015\u0010\t\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bH\u0086\u0008\u001aE\u0010\u000c\u001a\u00020\r*\u00020\u000226\u0010\u000e\u001a2\u0012\u0013\u0012\u00110\u0001¢\u0006\u000c\u0008\u0010\u0012\u0008\u0008\u0011\u0012\u0004\u0008\u0008(\u0007\u0012\u0013\u0012\u00110\u000b¢\u0006\u000c\u0008\u0010\u0012\u0008\u0008\u0011\u0012\u0004\u0008\u0008(\n\u0012\u0004\u0012\u00020\r0\u000fH\u0086\u0008\u001a\u001d\u0010\u0012\u001a\u00020\u000b*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u000bH\u0086\u0008\u001a#\u0010\u0014\u001a\u00020\u000b*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00012\u000c\u0010\u0013\u001a\u0008\u0012\u0004\u0012\u00020\u000b0\u0015H\u0086\u0008\u001a\r\u0010\u0016\u001a\u00020\u0006*\u00020\u0002H\u0086\u0008\u001a\r\u0010\u0017\u001a\u00020\u0006*\u00020\u0002H\u0086\u0008\u001a\n\u0010\u0018\u001a\u00020\u0019*\u00020\u0002\u001a\u0015\u0010\u001a\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u0002H\u0086\u0002\u001a\u0012\u0010\u001c\u001a\u00020\r*\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u0002\u001a\u001a\u0010\u001d\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u000b\u001a\u001d\u0010\u001e\u001a\u00020\r*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u000bH\u0086\n\u001a\n\u0010\u001f\u001a\u00020 *\u00020\u0002\"\u0016\u0010\u0000\u001a\u00020\u0001*\u00020\u00028Æ\u0002¢\u0006\u0006\u001a\u0004\u0008\u0003\u0010\u0004¨\u0006!", d2 = {"size", "", "Landroid/util/SparseLongArray;", "getSize", "(Landroid/util/SparseLongArray;)I", "contains", "", "key", "containsKey", "containsValue", "value", "", "forEach", "", "action", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "getOrDefault", "defaultValue", "getOrElse", "Lkotlin/Function0;", "isEmpty", "isNotEmpty", "keyIterator", "Lkotlin/collections/IntIterator;", "plus", "other", "putAll", "remove", "set", "valueIterator", "Lkotlin/collections/LongIterator;", "core-ktx_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class SparseLongArrayKt {
    public static final boolean contains(SparseLongArray $this$contains, int key) {
        int i;
        final int i2 = 0;
        i = $this$contains.indexOfKey(key) >= 0 ? 1 : 0;
        return i;
    }

    public static final boolean containsKey(SparseLongArray $this$containsKey, int key) {
        int i;
        final int i2 = 0;
        i = $this$containsKey.indexOfKey(key) >= 0 ? 1 : 0;
        return i;
    }

    public static final boolean containsValue(SparseLongArray $this$containsValue, long value) {
        int i;
        final int i2 = 0;
        i = $this$containsValue.indexOfValue(value) >= 0 ? 1 : 0;
        return i;
    }

    public static final void forEach(SparseLongArray $this$forEach, Function2<? super Integer, ? super Long, Unit> action) {
        int index;
        Integer valueOf2;
        Long valueOf;
        final int i = 0;
        index = 0;
        while (index < $this$forEach.size()) {
            action.invoke(Integer.valueOf($this$forEach.keyAt(index)), Long.valueOf($this$forEach.valueAt(index)));
            index++;
        }
    }

    public static final long getOrDefault(SparseLongArray $this$getOrDefault, int key, long defaultValue) {
        final int i = 0;
        return $this$getOrDefault.get(key, defaultValue);
    }

    public static final long getOrElse(SparseLongArray $this$getOrElse, int key, Function0<Long> defaultValue) {
        long longValue;
        final int i = 0;
        final int indexOfKey = $this$getOrElse.indexOfKey(key);
        final int i2 = 0;
        if (indexOfKey >= 0) {
            longValue = $this$getOrElse.valueAt(indexOfKey);
        } else {
            longValue = (Number)defaultValue.invoke().longValue();
        }
        return longValue;
    }

    public static final int getSize(SparseLongArray $this$size) {
        final int i = 0;
        return $this$size.size();
    }

    public static final boolean isEmpty(SparseLongArray $this$isEmpty) {
        int i;
        final int i2 = 0;
        i = $this$isEmpty.size() == 0 ? 1 : 0;
        return i;
    }

    public static final boolean isNotEmpty(SparseLongArray $this$isNotEmpty) {
        int i;
        final int i2 = 0;
        i = $this$isNotEmpty.size() != 0 ? 1 : 0;
        return i;
    }

    public static final IntIterator keyIterator(SparseLongArray $this$keyIterator) {
        SparseLongArrayKt.keyIterator.1 anon = new SparseLongArrayKt.keyIterator.1($this$keyIterator);
        return (IntIterator)anon;
    }

    public static final SparseLongArray plus(SparseLongArray $this$plus, SparseLongArray other) {
        SparseLongArray sparseLongArray = new SparseLongArray(size += size2);
        SparseLongArrayKt.putAll(sparseLongArray, $this$plus);
        SparseLongArrayKt.putAll(sparseLongArray, other);
        return sparseLongArray;
    }

    public static final void putAll(SparseLongArray $this$putAll, SparseLongArray other) {
        int index$iv;
        int keyAt;
        long valueAt;
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

    public static final boolean remove(SparseLongArray $this$remove, int key, long value) {
        int cmp;
        final int indexOfKey = $this$remove.indexOfKey(key);
        if (indexOfKey >= 0 && Long.compare(value, valueAt) == 0) {
            if (Long.compare(value, valueAt) == 0) {
                $this$remove.removeAt(indexOfKey);
                return 1;
            }
        }
        return 0;
    }

    public static final void set(SparseLongArray $this$set, int key, long value) {
        final int i = 0;
        $this$set.put(key, value);
    }

    public static final LongIterator valueIterator(SparseLongArray $this$valueIterator) {
        SparseLongArrayKt.valueIterator.1 anon = new SparseLongArrayKt.valueIterator.1($this$valueIterator);
        return (LongIterator)anon;
    }
}
