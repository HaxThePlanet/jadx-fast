package androidx.core.util;

import android.util.LongSparseArray;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.LongIterator;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000F\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\u0008\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0008\n\u0002\u0010(\n\u0000\u001a!\u0010\u0006\u001a\u00020\u0007\"\u0004\u0008\u0000\u0010\u0002*\u0008\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\u0008\u001a\u00020\tH\u0086\n\u001a!\u0010\n\u001a\u00020\u0007\"\u0004\u0008\u0000\u0010\u0002*\u0008\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\u0008\u001a\u00020\tH\u0086\u0008\u001a&\u0010\u000b\u001a\u00020\u0007\"\u0004\u0008\u0000\u0010\u0002*\u0008\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\u000c\u001a\u0002H\u0002H\u0086\u0008¢\u0006\u0002\u0010\r\u001aQ\u0010\u000e\u001a\u00020\u000f\"\u0004\u0008\u0000\u0010\u0002*\u0008\u0012\u0004\u0012\u0002H\u00020\u000326\u0010\u0010\u001a2\u0012\u0013\u0012\u00110\t¢\u0006\u000c\u0008\u0012\u0012\u0008\u0008\u0013\u0012\u0004\u0008\u0008(\u0008\u0012\u0013\u0012\u0011H\u0002¢\u0006\u000c\u0008\u0012\u0012\u0008\u0008\u0013\u0012\u0004\u0008\u0008(\u000c\u0012\u0004\u0012\u00020\u000f0\u0011H\u0086\u0008\u001a.\u0010\u0014\u001a\u0002H\u0002\"\u0004\u0008\u0000\u0010\u0002*\u0008\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\u0008\u001a\u00020\t2\u0006\u0010\u0015\u001a\u0002H\u0002H\u0086\u0008¢\u0006\u0002\u0010\u0016\u001a4\u0010\u0017\u001a\u0002H\u0002\"\u0004\u0008\u0000\u0010\u0002*\u0008\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\u0008\u001a\u00020\t2\u000c\u0010\u0015\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\u0018H\u0086\u0008¢\u0006\u0002\u0010\u0019\u001a\u0019\u0010\u001a\u001a\u00020\u0007\"\u0004\u0008\u0000\u0010\u0002*\u0008\u0012\u0004\u0012\u0002H\u00020\u0003H\u0086\u0008\u001a\u0019\u0010\u001b\u001a\u00020\u0007\"\u0004\u0008\u0000\u0010\u0002*\u0008\u0012\u0004\u0012\u0002H\u00020\u0003H\u0086\u0008\u001a\u0016\u0010\u001c\u001a\u00020\u001d\"\u0004\u0008\u0000\u0010\u0002*\u0008\u0012\u0004\u0012\u0002H\u00020\u0003\u001a-\u0010\u001e\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\u0003\"\u0004\u0008\u0000\u0010\u0002*\u0008\u0012\u0004\u0012\u0002H\u00020\u00032\u000c\u0010\u001f\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\u0003H\u0086\u0002\u001a$\u0010 \u001a\u00020\u000f\"\u0004\u0008\u0000\u0010\u0002*\u0008\u0012\u0004\u0012\u0002H\u00020\u00032\u000c\u0010\u001f\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\u0003\u001a+\u0010!\u001a\u00020\u0007\"\u0004\u0008\u0000\u0010\u0002*\u0008\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\u0008\u001a\u00020\t2\u0006\u0010\u000c\u001a\u0002H\u0002¢\u0006\u0002\u0010\"\u001a.\u0010#\u001a\u00020\u000f\"\u0004\u0008\u0000\u0010\u0002*\u0008\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\u0008\u001a\u00020\t2\u0006\u0010\u000c\u001a\u0002H\u0002H\u0086\n¢\u0006\u0002\u0010$\u001a\u001c\u0010%\u001a\u0008\u0012\u0004\u0012\u0002H\u00020&\"\u0004\u0008\u0000\u0010\u0002*\u0008\u0012\u0004\u0012\u0002H\u00020\u0003\"\"\u0010\u0000\u001a\u00020\u0001\"\u0004\u0008\u0000\u0010\u0002*\u0008\u0012\u0004\u0012\u0002H\u00020\u00038Æ\u0002¢\u0006\u0006\u001a\u0004\u0008\u0004\u0010\u0005¨\u0006'", d2 = {"size", "", "T", "Landroid/util/LongSparseArray;", "getSize", "(Landroid/util/LongSparseArray;)I", "contains", "", "key", "", "containsKey", "containsValue", "value", "(Landroid/util/LongSparseArray;Ljava/lang/Object;)Z", "forEach", "", "action", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "getOrDefault", "defaultValue", "(Landroid/util/LongSparseArray;JLjava/lang/Object;)Ljava/lang/Object;", "getOrElse", "Lkotlin/Function0;", "(Landroid/util/LongSparseArray;JLkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "isEmpty", "isNotEmpty", "keyIterator", "Lkotlin/collections/LongIterator;", "plus", "other", "putAll", "remove", "(Landroid/util/LongSparseArray;JLjava/lang/Object;)Z", "set", "(Landroid/util/LongSparseArray;JLjava/lang/Object;)V", "valueIterator", "", "core-ktx_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class LongSparseArrayKt {
    public static final <T> boolean contains(LongSparseArray<T> $this$contains, long key) {
        int i;
        final int i2 = 0;
        i = $this$contains.indexOfKey(key) >= 0 ? 1 : 0;
        return i;
    }

    public static final <T> boolean containsKey(LongSparseArray<T> $this$containsKey, long key) {
        int i;
        final int i2 = 0;
        i = $this$containsKey.indexOfKey(key) >= 0 ? 1 : 0;
        return i;
    }

    public static final <T> boolean containsValue(LongSparseArray<T> $this$containsValue, T value) {
        int i;
        final int i2 = 0;
        i = $this$containsValue.indexOfValue(value) >= 0 ? 1 : 0;
        return i;
    }

    public static final <T> void forEach(LongSparseArray<T> $this$forEach, Function2<? super Long, ? super T, Unit> action) {
        int index;
        Long valueOf;
        long valueAt;
        final int i = 0;
        index = 0;
        while (index < $this$forEach.size()) {
            action.invoke(Long.valueOf($this$forEach.keyAt(index)), $this$forEach.valueAt(index));
            index++;
        }
    }

    public static final <T> T getOrDefault(LongSparseArray<T> $this$getOrDefault, long key, T defaultValue) {
        Object obj;
        final int i = 0;
        if ($this$getOrDefault.get(key) == null) {
            obj = obj5;
        }
        return obj;
    }

    public static final <T> T getOrElse(LongSparseArray<T> $this$getOrElse, long key, Function0<? extends T> defaultValue) {
        Object invoke;
        final int i = 0;
        if ($this$getOrElse.get(key) == null) {
            invoke = obj5.invoke();
        }
        return invoke;
    }

    public static final <T> int getSize(LongSparseArray<T> $this$size) {
        final int i = 0;
        return $this$size.size();
    }

    public static final <T> boolean isEmpty(LongSparseArray<T> $this$isEmpty) {
        int i;
        final int i2 = 0;
        i = $this$isEmpty.size() == 0 ? 1 : 0;
        return i;
    }

    public static final <T> boolean isNotEmpty(LongSparseArray<T> $this$isNotEmpty) {
        int i;
        final int i2 = 0;
        i = $this$isNotEmpty.size() != 0 ? 1 : 0;
        return i;
    }

    public static final <T> LongIterator keyIterator(LongSparseArray<T> $this$keyIterator) {
        LongSparseArrayKt.keyIterator.1 anon = new LongSparseArrayKt.keyIterator.1($this$keyIterator);
        return (LongIterator)anon;
    }

    public static final <T> LongSparseArray<T> plus(LongSparseArray<T> $this$plus, LongSparseArray<T> other) {
        LongSparseArray longSparseArray = new LongSparseArray(size += size2);
        LongSparseArrayKt.putAll(longSparseArray, $this$plus);
        LongSparseArrayKt.putAll(longSparseArray, other);
        return longSparseArray;
    }

    public static final <T> void putAll(LongSparseArray<T> $this$putAll, LongSparseArray<T> other) {
        int index$iv;
        long keyAt;
        Object valueAt;
        int i;
        final Object obj = other;
        final int i2 = 0;
        index$iv = 0;
        while (index$iv < obj.size()) {
            i = 0;
            $this$putAll.put(obj.keyAt(index$iv), obj5);
            index$iv++;
        }
    }

    public static final <T> boolean remove(LongSparseArray<T> $this$remove, long key, T value) {
        boolean equal;
        final int indexOfKey = $this$remove.indexOfKey(key);
        if (indexOfKey >= 0 && Intrinsics.areEqual(obj5, $this$remove.valueAt(indexOfKey))) {
            if (Intrinsics.areEqual(obj5, $this$remove.valueAt(indexOfKey))) {
                $this$remove.removeAt(indexOfKey);
                return 1;
            }
        }
        return 0;
    }

    public static final <T> void set(LongSparseArray<T> $this$set, long key, T value) {
        final int i = 0;
        $this$set.put(key, value);
    }

    public static final <T> Iterator<T> valueIterator(LongSparseArray<T> $this$valueIterator) {
        LongSparseArrayKt.valueIterator.1 anon = new LongSparseArrayKt.valueIterator.1($this$valueIterator);
        return (Iterator)anon;
    }
}
