package androidx.core.util;

import android.util.SparseArray;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.IntIterator;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000@\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0002\u0008\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0008\n\u0002\u0010(\n\u0000\u001a!\u0010\u0006\u001a\u00020\u0007\"\u0004\u0008\u0000\u0010\u0002*\u0008\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\u0008\u001a\u00020\u0001H\u0086\n\u001a!\u0010\t\u001a\u00020\u0007\"\u0004\u0008\u0000\u0010\u0002*\u0008\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\u0008\u001a\u00020\u0001H\u0086\u0008\u001a&\u0010\n\u001a\u00020\u0007\"\u0004\u0008\u0000\u0010\u0002*\u0008\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\u000b\u001a\u0002H\u0002H\u0086\u0008¢\u0006\u0002\u0010\u000c\u001aQ\u0010\r\u001a\u00020\u000e\"\u0004\u0008\u0000\u0010\u0002*\u0008\u0012\u0004\u0012\u0002H\u00020\u000326\u0010\u000f\u001a2\u0012\u0013\u0012\u00110\u0001¢\u0006\u000c\u0008\u0011\u0012\u0008\u0008\u0012\u0012\u0004\u0008\u0008(\u0008\u0012\u0013\u0012\u0011H\u0002¢\u0006\u000c\u0008\u0011\u0012\u0008\u0008\u0012\u0012\u0004\u0008\u0008(\u000b\u0012\u0004\u0012\u00020\u000e0\u0010H\u0086\u0008\u001a.\u0010\u0013\u001a\u0002H\u0002\"\u0004\u0008\u0000\u0010\u0002*\u0008\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\u0008\u001a\u00020\u00012\u0006\u0010\u0014\u001a\u0002H\u0002H\u0086\u0008¢\u0006\u0002\u0010\u0015\u001a4\u0010\u0016\u001a\u0002H\u0002\"\u0004\u0008\u0000\u0010\u0002*\u0008\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\u0008\u001a\u00020\u00012\u000c\u0010\u0014\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\u0017H\u0086\u0008¢\u0006\u0002\u0010\u0018\u001a\u0019\u0010\u0019\u001a\u00020\u0007\"\u0004\u0008\u0000\u0010\u0002*\u0008\u0012\u0004\u0012\u0002H\u00020\u0003H\u0086\u0008\u001a\u0019\u0010\u001a\u001a\u00020\u0007\"\u0004\u0008\u0000\u0010\u0002*\u0008\u0012\u0004\u0012\u0002H\u00020\u0003H\u0086\u0008\u001a\u0016\u0010\u001b\u001a\u00020\u001c\"\u0004\u0008\u0000\u0010\u0002*\u0008\u0012\u0004\u0012\u0002H\u00020\u0003\u001a-\u0010\u001d\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\u0003\"\u0004\u0008\u0000\u0010\u0002*\u0008\u0012\u0004\u0012\u0002H\u00020\u00032\u000c\u0010\u001e\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\u0003H\u0086\u0002\u001a$\u0010\u001f\u001a\u00020\u000e\"\u0004\u0008\u0000\u0010\u0002*\u0008\u0012\u0004\u0012\u0002H\u00020\u00032\u000c\u0010\u001e\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\u0003\u001a+\u0010 \u001a\u00020\u0007\"\u0004\u0008\u0000\u0010\u0002*\u0008\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\u0008\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u0002H\u0002¢\u0006\u0002\u0010!\u001a.\u0010\"\u001a\u00020\u000e\"\u0004\u0008\u0000\u0010\u0002*\u0008\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\u0008\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u0002H\u0002H\u0086\n¢\u0006\u0002\u0010#\u001a\u001c\u0010$\u001a\u0008\u0012\u0004\u0012\u0002H\u00020%\"\u0004\u0008\u0000\u0010\u0002*\u0008\u0012\u0004\u0012\u0002H\u00020\u0003\"\"\u0010\u0000\u001a\u00020\u0001\"\u0004\u0008\u0000\u0010\u0002*\u0008\u0012\u0004\u0012\u0002H\u00020\u00038Æ\u0002¢\u0006\u0006\u001a\u0004\u0008\u0004\u0010\u0005¨\u0006&", d2 = {"size", "", "T", "Landroid/util/SparseArray;", "getSize", "(Landroid/util/SparseArray;)I", "contains", "", "key", "containsKey", "containsValue", "value", "(Landroid/util/SparseArray;Ljava/lang/Object;)Z", "forEach", "", "action", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "getOrDefault", "defaultValue", "(Landroid/util/SparseArray;ILjava/lang/Object;)Ljava/lang/Object;", "getOrElse", "Lkotlin/Function0;", "(Landroid/util/SparseArray;ILkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "isEmpty", "isNotEmpty", "keyIterator", "Lkotlin/collections/IntIterator;", "plus", "other", "putAll", "remove", "(Landroid/util/SparseArray;ILjava/lang/Object;)Z", "set", "(Landroid/util/SparseArray;ILjava/lang/Object;)V", "valueIterator", "", "core-ktx_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class SparseArrayKt {
    public static final <T> boolean contains(SparseArray<T> $this$contains, int key) {
        int i;
        final int i2 = 0;
        i = $this$contains.indexOfKey(key) >= 0 ? 1 : 0;
        return i;
    }

    public static final <T> boolean containsKey(SparseArray<T> $this$containsKey, int key) {
        int i;
        final int i2 = 0;
        i = $this$containsKey.indexOfKey(key) >= 0 ? 1 : 0;
        return i;
    }

    public static final <T> boolean containsValue(SparseArray<T> $this$containsValue, T value) {
        int i;
        final int i2 = 0;
        i = $this$containsValue.indexOfValue(value) >= 0 ? 1 : 0;
        return i;
    }

    public static final <T> void forEach(SparseArray<T> $this$forEach, Function2<? super Integer, ? super T, Unit> action) {
        int index;
        Integer valueOf;
        Object valueAt;
        final int i = 0;
        index = 0;
        while (index < $this$forEach.size()) {
            action.invoke(Integer.valueOf($this$forEach.keyAt(index)), $this$forEach.valueAt(index));
            index++;
        }
    }

    public static final <T> T getOrDefault(SparseArray<T> $this$getOrDefault, int key, T defaultValue) {
        Object obj;
        final int i = 0;
        if ($this$getOrDefault.get(key) == null) {
            obj = defaultValue;
        }
        return obj;
    }

    public static final <T> T getOrElse(SparseArray<T> $this$getOrElse, int key, Function0<? extends T> defaultValue) {
        Object invoke;
        final int i = 0;
        if ($this$getOrElse.get(key) == null) {
            invoke = defaultValue.invoke();
        }
        return invoke;
    }

    public static final <T> int getSize(SparseArray<T> $this$size) {
        final int i = 0;
        return $this$size.size();
    }

    public static final <T> boolean isEmpty(SparseArray<T> $this$isEmpty) {
        int i;
        final int i2 = 0;
        i = $this$isEmpty.size() == 0 ? 1 : 0;
        return i;
    }

    public static final <T> boolean isNotEmpty(SparseArray<T> $this$isNotEmpty) {
        int i;
        final int i2 = 0;
        i = $this$isNotEmpty.size() != 0 ? 1 : 0;
        return i;
    }

    public static final <T> IntIterator keyIterator(SparseArray<T> $this$keyIterator) {
        SparseArrayKt.keyIterator.1 anon = new SparseArrayKt.keyIterator.1($this$keyIterator);
        return (IntIterator)anon;
    }

    public static final <T> SparseArray<T> plus(SparseArray<T> $this$plus, SparseArray<T> other) {
        SparseArray sparseArray = new SparseArray(size += size2);
        SparseArrayKt.putAll(sparseArray, $this$plus);
        SparseArrayKt.putAll(sparseArray, other);
        return sparseArray;
    }

    public static final <T> void putAll(SparseArray<T> $this$putAll, SparseArray<T> other) {
        int index$iv;
        int keyAt;
        Object valueAt;
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

    public static final <T> boolean remove(SparseArray<T> $this$remove, int key, T value) {
        boolean equal;
        final int indexOfKey = $this$remove.indexOfKey(key);
        if (indexOfKey >= 0 && Intrinsics.areEqual(value, $this$remove.valueAt(indexOfKey))) {
            if (Intrinsics.areEqual(value, $this$remove.valueAt(indexOfKey))) {
                $this$remove.removeAt(indexOfKey);
                return 1;
            }
        }
        return 0;
    }

    public static final <T> void set(SparseArray<T> $this$set, int key, T value) {
        final int i = 0;
        $this$set.put(key, value);
    }

    public static final <T> Iterator<T> valueIterator(SparseArray<T> $this$valueIterator) {
        SparseArrayKt.valueIterator.1 anon = new SparseArrayKt.valueIterator.1($this$valueIterator);
        return (Iterator)anon;
    }
}
