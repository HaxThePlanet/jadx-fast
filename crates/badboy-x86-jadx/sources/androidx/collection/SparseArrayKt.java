package androidx.collection;

import java.util.Iterator;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.IntIterator;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000@\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0010(\n\u0000\u001a!\u0010\u0006\u001a\u00020\u0007\"\u0004\u0008\u0000\u0010\u0002*\u0008\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\u0008\u001a\u00020\u0001H\u0086\n\u001aT\u0010\t\u001a\u00020\n\"\u0004\u0008\u0000\u0010\u0002*\u0008\u0012\u0004\u0012\u0002H\u00020\u000326\u0010\u000b\u001a2\u0012\u0013\u0012\u00110\u0001¢\u0006\u000c\u0008\r\u0012\u0008\u0008\u000e\u0012\u0004\u0008\u0008(\u0008\u0012\u0013\u0012\u0011H\u0002¢\u0006\u000c\u0008\r\u0012\u0008\u0008\u000e\u0012\u0004\u0008\u0008(\u000f\u0012\u0004\u0012\u00020\n0\u000cH\u0086\u0008ø\u0001\u0000\u001a.\u0010\u0010\u001a\u0002H\u0002\"\u0004\u0008\u0000\u0010\u0002*\u0008\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\u0008\u001a\u00020\u00012\u0006\u0010\u0011\u001a\u0002H\u0002H\u0086\u0008¢\u0006\u0002\u0010\u0012\u001a7\u0010\u0013\u001a\u0002H\u0002\"\u0004\u0008\u0000\u0010\u0002*\u0008\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\u0008\u001a\u00020\u00012\u000c\u0010\u0011\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\u0014H\u0086\u0008ø\u0001\u0000¢\u0006\u0002\u0010\u0015\u001a\u0019\u0010\u0016\u001a\u00020\u0007\"\u0004\u0008\u0000\u0010\u0002*\u0008\u0012\u0004\u0012\u0002H\u00020\u0003H\u0086\u0008\u001a\u0016\u0010\u0017\u001a\u00020\u0018\"\u0004\u0008\u0000\u0010\u0002*\u0008\u0012\u0004\u0012\u0002H\u00020\u0003\u001a-\u0010\u0019\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\u0003\"\u0004\u0008\u0000\u0010\u0002*\u0008\u0012\u0004\u0012\u0002H\u00020\u00032\u000c\u0010\u001a\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\u0003H\u0086\u0002\u001a-\u0010\u001b\u001a\u00020\u0007\"\u0004\u0008\u0000\u0010\u0002*\u0008\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\u0008\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u0002H\u0002H\u0007¢\u0006\u0002\u0010\u001c\u001a.\u0010\u001d\u001a\u00020\n\"\u0004\u0008\u0000\u0010\u0002*\u0008\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\u0008\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u0002H\u0002H\u0086\n¢\u0006\u0002\u0010\u001e\u001a\u001c\u0010\u001f\u001a\u0008\u0012\u0004\u0012\u0002H\u00020 \"\u0004\u0008\u0000\u0010\u0002*\u0008\u0012\u0004\u0012\u0002H\u00020\u0003\"\"\u0010\u0000\u001a\u00020\u0001\"\u0004\u0008\u0000\u0010\u0002*\u0008\u0012\u0004\u0012\u0002H\u00020\u00038Æ\u0002¢\u0006\u0006\u001a\u0004\u0008\u0004\u0010\u0005\u0082\u0002\u0007\n\u0005\u0008\u009920\u0001¨\u0006!", d2 = {"size", "", "T", "Landroidx/collection/SparseArrayCompat;", "getSize", "(Landroidx/collection/SparseArrayCompat;)I", "contains", "", "key", "forEach", "", "action", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "value", "getOrDefault", "defaultValue", "(Landroidx/collection/SparseArrayCompat;ILjava/lang/Object;)Ljava/lang/Object;", "getOrElse", "Lkotlin/Function0;", "(Landroidx/collection/SparseArrayCompat;ILkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "isNotEmpty", "keyIterator", "Lkotlin/collections/IntIterator;", "plus", "other", "remove", "(Landroidx/collection/SparseArrayCompat;ILjava/lang/Object;)Z", "set", "(Landroidx/collection/SparseArrayCompat;ILjava/lang/Object;)V", "valueIterator", "", "collection"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class SparseArrayKt {
    public static final <T> boolean contains(androidx.collection.SparseArrayCompat<T> $this$contains, int key) {
        Intrinsics.checkNotNullParameter($this$contains, "<this>");
        int i = 0;
        return $this$contains.containsKey(key);
    }

    public static final <T> void forEach(androidx.collection.SparseArrayCompat<T> $this$forEach, Function2<? super Integer, ? super T, Unit> action) {
        int index;
        Integer valueOf;
        Object valueAt;
        Intrinsics.checkNotNullParameter($this$forEach, "<this>");
        Intrinsics.checkNotNullParameter(action, "action");
        int i = 0;
        index = 0;
        while (index < $this$forEach.size()) {
            action.invoke(Integer.valueOf($this$forEach.keyAt(index)), $this$forEach.valueAt(index));
            index++;
        }
    }

    public static final <T> T getOrDefault(androidx.collection.SparseArrayCompat<T> $this$getOrDefault, int key, T defaultValue) {
        Intrinsics.checkNotNullParameter($this$getOrDefault, "<this>");
        int i = 0;
        return $this$getOrDefault.get(key, defaultValue);
    }

    public static final <T> T getOrElse(androidx.collection.SparseArrayCompat<T> $this$getOrElse, int key, Function0<? extends T> defaultValue) {
        Object invoke;
        Intrinsics.checkNotNullParameter($this$getOrElse, "<this>");
        Intrinsics.checkNotNullParameter(defaultValue, "defaultValue");
        int i = 0;
        if ($this$getOrElse.get(key) == null) {
            invoke = defaultValue.invoke();
        }
        return invoke;
    }

    public static final <T> int getSize(androidx.collection.SparseArrayCompat<T> $this$size) {
        Intrinsics.checkNotNullParameter($this$size, "<this>");
        int i = 0;
        return $this$size.size();
    }

    public static final <T> boolean isNotEmpty(androidx.collection.SparseArrayCompat<T> $this$isNotEmpty) {
        Intrinsics.checkNotNullParameter($this$isNotEmpty, "<this>");
        int i = 0;
        return empty ^= 1;
    }

    public static final <T> IntIterator keyIterator(androidx.collection.SparseArrayCompat<T> $this$keyIterator) {
        Intrinsics.checkNotNullParameter($this$keyIterator, "<this>");
        SparseArrayKt.keyIterator.1 anon = new SparseArrayKt.keyIterator.1($this$keyIterator);
        return (IntIterator)anon;
    }

    public static final <T> androidx.collection.SparseArrayCompat<T> plus(androidx.collection.SparseArrayCompat<T> $this$plus, androidx.collection.SparseArrayCompat<T> other) {
        Intrinsics.checkNotNullParameter($this$plus, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        SparseArrayCompat sparseArrayCompat = new SparseArrayCompat(size += size2);
        sparseArrayCompat.putAll($this$plus);
        sparseArrayCompat.putAll(other);
        return sparseArrayCompat;
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Replaced with member function. Remove extension import!")
    public static final boolean remove(androidx.collection.SparseArrayCompat $this$remove, int key, Object value) {
        Intrinsics.checkNotNullParameter($this$remove, "<this>");
        return $this$remove.remove(key, value);
    }

    public static final <T> void set(androidx.collection.SparseArrayCompat<T> $this$set, int key, T value) {
        Intrinsics.checkNotNullParameter($this$set, "<this>");
        int i = 0;
        $this$set.put(key, value);
    }

    public static final <T> Iterator<T> valueIterator(androidx.collection.SparseArrayCompat<T> $this$valueIterator) {
        Intrinsics.checkNotNullParameter($this$valueIterator, "<this>");
        SparseArrayKt.valueIterator.1 anon = new SparseArrayKt.valueIterator.1($this$valueIterator);
        return (Iterator)anon;
    }
}
