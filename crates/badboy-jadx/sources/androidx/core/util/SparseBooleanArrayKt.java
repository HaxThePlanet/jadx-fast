package androidx.core.util;

import android.util.SparseBooleanArray;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.BooleanIterator;
import kotlin.collections.IntIterator;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000>\n\u0000\n\u0002\u0010\u0008\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0002\u0008\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0000\u001a\u0015\u0010\u0005\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0001H\u0086\n\u001a\u0015\u0010\u0008\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0001H\u0086\u0008\u001a\u0015\u0010\t\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\n\u001a\u00020\u0006H\u0086\u0008\u001aE\u0010\u000b\u001a\u00020\u000c*\u00020\u000226\u0010\r\u001a2\u0012\u0013\u0012\u00110\u0001¢\u0006\u000c\u0008\u000f\u0012\u0008\u0008\u0010\u0012\u0004\u0008\u0008(\u0007\u0012\u0013\u0012\u00110\u0006¢\u0006\u000c\u0008\u000f\u0012\u0008\u0008\u0010\u0012\u0004\u0008\u0008(\n\u0012\u0004\u0012\u00020\u000c0\u000eH\u0086\u0008\u001a\u001d\u0010\u0011\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00012\u0006\u0010\u0012\u001a\u00020\u0006H\u0086\u0008\u001a#\u0010\u0013\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00012\u000c\u0010\u0012\u001a\u0008\u0012\u0004\u0012\u00020\u00060\u0014H\u0086\u0008\u001a\r\u0010\u0015\u001a\u00020\u0006*\u00020\u0002H\u0086\u0008\u001a\r\u0010\u0016\u001a\u00020\u0006*\u00020\u0002H\u0086\u0008\u001a\n\u0010\u0017\u001a\u00020\u0018*\u00020\u0002\u001a\u0015\u0010\u0019\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u0002H\u0086\u0002\u001a\u0012\u0010\u001b\u001a\u00020\u000c*\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u0002\u001a\u001a\u0010\u001c\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u0006\u001a\u001d\u0010\u001d\u001a\u00020\u000c*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u0006H\u0086\n\u001a\n\u0010\u001e\u001a\u00020\u001f*\u00020\u0002\"\u0016\u0010\u0000\u001a\u00020\u0001*\u00020\u00028Æ\u0002¢\u0006\u0006\u001a\u0004\u0008\u0003\u0010\u0004¨\u0006 ", d2 = {"size", "", "Landroid/util/SparseBooleanArray;", "getSize", "(Landroid/util/SparseBooleanArray;)I", "contains", "", "key", "containsKey", "containsValue", "value", "forEach", "", "action", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "getOrDefault", "defaultValue", "getOrElse", "Lkotlin/Function0;", "isEmpty", "isNotEmpty", "keyIterator", "Lkotlin/collections/IntIterator;", "plus", "other", "putAll", "remove", "set", "valueIterator", "Lkotlin/collections/BooleanIterator;", "core-ktx_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class SparseBooleanArrayKt {
    public static final boolean contains(SparseBooleanArray $this$contains, int key) {
        int i;
        final int i2 = 0;
        i = $this$contains.indexOfKey(key) >= 0 ? 1 : 0;
        return i;
    }

    public static final boolean containsKey(SparseBooleanArray $this$containsKey, int key) {
        int i;
        final int i2 = 0;
        i = $this$containsKey.indexOfKey(key) >= 0 ? 1 : 0;
        return i;
    }

    public static final boolean containsValue(SparseBooleanArray $this$containsValue, boolean value) {
        int i;
        final int i2 = 0;
        i = $this$containsValue.indexOfValue(value) >= 0 ? 1 : 0;
        return i;
    }

    public static final void forEach(SparseBooleanArray $this$forEach, Function2<? super Integer, ? super Boolean, Unit> action) {
        int index;
        Integer valueOf2;
        Boolean valueOf;
        final int i = 0;
        index = 0;
        while (index < $this$forEach.size()) {
            action.invoke(Integer.valueOf($this$forEach.keyAt(index)), Boolean.valueOf($this$forEach.valueAt(index)));
            index++;
        }
    }

    public static final boolean getOrDefault(SparseBooleanArray $this$getOrDefault, int key, boolean defaultValue) {
        final int i = 0;
        return $this$getOrDefault.get(key, defaultValue);
    }

    public static final boolean getOrElse(SparseBooleanArray $this$getOrElse, int key, Function0<Boolean> defaultValue) {
        boolean booleanValue;
        final int i = 0;
        final int indexOfKey = $this$getOrElse.indexOfKey(key);
        final int i2 = 0;
        if (indexOfKey >= 0) {
            booleanValue = $this$getOrElse.valueAt(indexOfKey);
        } else {
            booleanValue = (Boolean)defaultValue.invoke().booleanValue();
        }
        return booleanValue;
    }

    public static final int getSize(SparseBooleanArray $this$size) {
        final int i = 0;
        return $this$size.size();
    }

    public static final boolean isEmpty(SparseBooleanArray $this$isEmpty) {
        int i;
        final int i2 = 0;
        i = $this$isEmpty.size() == 0 ? 1 : 0;
        return i;
    }

    public static final boolean isNotEmpty(SparseBooleanArray $this$isNotEmpty) {
        int i;
        final int i2 = 0;
        i = $this$isNotEmpty.size() != 0 ? 1 : 0;
        return i;
    }

    public static final IntIterator keyIterator(SparseBooleanArray $this$keyIterator) {
        SparseBooleanArrayKt.keyIterator.1 anon = new SparseBooleanArrayKt.keyIterator.1($this$keyIterator);
        return (IntIterator)anon;
    }

    public static final SparseBooleanArray plus(SparseBooleanArray $this$plus, SparseBooleanArray other) {
        SparseBooleanArray sparseBooleanArray = new SparseBooleanArray(size += size2);
        SparseBooleanArrayKt.putAll(sparseBooleanArray, $this$plus);
        SparseBooleanArrayKt.putAll(sparseBooleanArray, other);
        return sparseBooleanArray;
    }

    public static final void putAll(SparseBooleanArray $this$putAll, SparseBooleanArray other) {
        int index$iv;
        int keyAt;
        boolean valueAt;
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

    public static final boolean remove(SparseBooleanArray $this$remove, int key, boolean value) {
        boolean valueAt;
        final int indexOfKey = $this$remove.indexOfKey(key);
        if (indexOfKey >= 0 && value == $this$remove.valueAt(indexOfKey)) {
            if (value == $this$remove.valueAt(indexOfKey)) {
                $this$remove.delete(key);
                return 1;
            }
        }
        return 0;
    }

    public static final void set(SparseBooleanArray $this$set, int key, boolean value) {
        final int i = 0;
        $this$set.put(key, value);
    }

    public static final BooleanIterator valueIterator(SparseBooleanArray $this$valueIterator) {
        SparseBooleanArrayKt.valueIterator.1 anon = new SparseBooleanArrayKt.valueIterator.1($this$valueIterator);
        return (BooleanIterator)anon;
    }
}
