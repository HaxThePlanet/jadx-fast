package androidx.collection;

import androidx.collection.internal.ContainerHelpersKt;
import java.util.Arrays;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000@\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001a\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0004\n\u0002\u0010\u0015\n\u0002\u0008\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0002\u0008\u001f\n\u0002\u0010\u000e\n\u0002\u0008\u0002\u0008\u0016\u0018\u0000*\u0004\u0008\u0000\u0010\u00012\u00020\u0002B\u0011\u0008\u0007\u0012\u0008\u0008\u0002\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u001d\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0016J\u0008\u0010\u0017\u001a\u00020\u0013H\u0016J\u000e\u0010\u0018\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0000H\u0016J\u0010\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u0004H\u0016J\u0015\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u001bJ\u0010\u0010\u001c\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0004H\u0017J\u0018\u0010\u001d\u001a\u0004\u0018\u00018\u00002\u0006\u0010\u0014\u001a\u00020\u0004H\u0096\u0002¢\u0006\u0002\u0010\u001eJ\u001d\u0010\u001d\u001a\u00028\u00002\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010 J\u0010\u0010!\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0004H\u0016J\u0015\u0010\"\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010#J\u0008\u0010\u0008\u001a\u00020\u0007H\u0016J\u0010\u0010$\u001a\u00020\u00042\u0006\u0010%\u001a\u00020\u0004H\u0016J\u001d\u0010&\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0016J\u0018\u0010'\u001a\u00020\u00132\u000e\u0010(\u001a\n\u0012\u0006\u0008\u0001\u0012\u00028\u00000\u0000H\u0016J\u001f\u0010)\u001a\u0004\u0018\u00018\u00002\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010 J\u0010\u0010*\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0004H\u0016J\u001a\u0010*\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u00042\u0008\u0010\u0015\u001a\u0004\u0018\u00010\u0010H\u0016J\u0010\u0010+\u001a\u00020\u00132\u0006\u0010%\u001a\u00020\u0004H\u0016J\u0018\u0010,\u001a\u00020\u00132\u0006\u0010%\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u0004H\u0016J\u001f\u0010-\u001a\u0004\u0018\u00018\u00002\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010 J%\u0010-\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010.\u001a\u00028\u00002\u0006\u0010/\u001a\u00028\u0000H\u0016¢\u0006\u0002\u00100J\u001d\u00101\u001a\u00020\u00132\u0006\u0010%\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0016J\u0008\u0010\r\u001a\u00020\u0004H\u0016J\u0008\u00102\u001a\u000203H\u0016J\u0015\u00104\u001a\u00028\u00002\u0006\u0010%\u001a\u00020\u0004H\u0016¢\u0006\u0002\u0010\u001eR\u0012\u0010\u0006\u001a\u00020\u00078\u0000@\u0000X\u0081\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0008\u001a\u00020\u00078G¢\u0006\u0006\u001a\u0004\u0008\t\u0010\nR\u0012\u0010\u000b\u001a\u00020\u000c8\u0000@\u0000X\u0081\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\r\u001a\u00020\u00048\u0000@\u0000X\u0081\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u000e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u000f8\u0000@\u0000X\u0081\u000e¢\u0006\u0004\n\u0002\u0010\u0011¨\u00065", d2 = {"Landroidx/collection/SparseArrayCompat;", "E", "", "initialCapacity", "", "(I)V", "garbage", "", "isEmpty", "getIsEmpty", "()Z", "keys", "", "size", "values", "", "", "[Ljava/lang/Object;", "append", "", "key", "value", "(ILjava/lang/Object;)V", "clear", "clone", "containsKey", "containsValue", "(Ljava/lang/Object;)Z", "delete", "get", "(I)Ljava/lang/Object;", "defaultValue", "(ILjava/lang/Object;)Ljava/lang/Object;", "indexOfKey", "indexOfValue", "(Ljava/lang/Object;)I", "keyAt", "index", "put", "putAll", "other", "putIfAbsent", "remove", "removeAt", "removeAtRange", "replace", "oldValue", "newValue", "(ILjava/lang/Object;Ljava/lang/Object;)Z", "setValueAt", "toString", "", "valueAt", "collection"}, k = 1, mv = {1, 8, 0}, xi = 48)
public class SparseArrayCompat<E>  implements java.lang.Cloneable {

    public boolean garbage;
    public int[] keys;
    public int size;
    public Object[] values;
    public SparseArrayCompat() {
        super(0, 1, 0);
    }

    public SparseArrayCompat(int initialCapacity) {
        Object[] idealIntArraySize;
        Object[] arr;
        super();
        if (initialCapacity == 0) {
            this.keys = ContainerHelpersKt.EMPTY_INTS;
            this.values = ContainerHelpersKt.EMPTY_OBJECTS;
        } else {
            idealIntArraySize = ContainerHelpersKt.idealIntArraySize(initialCapacity);
            this.keys = new int[idealIntArraySize];
            this.values = new Object[idealIntArraySize];
        }
    }

    public SparseArrayCompat(int i, int i2, DefaultConstructorMarker defaultConstructorMarker3) {
        int obj1;
        obj1 = i2 &= 1 != 0 ? 10 : obj1;
        super(obj1);
    }

    public void append(int key, E value) {
        int size;
        boolean garbage;
        int length;
        int idealIntArraySize;
        Object[] copyOf;
        String str;
        final Object obj = this;
        final int i = 0;
        if (obj.size != 0 && key <= obj.keys[size2--]) {
            if (key <= obj.keys[size2--]) {
                obj.put(key, value);
            } else {
                if (obj.garbage && obj.size >= keys3.length) {
                    if (obj.size >= keys3.length) {
                        SparseArrayCompatKt.access$gc(obj);
                    }
                }
                size = obj.size;
                if (size >= keys2.length) {
                    idealIntArraySize = ContainerHelpersKt.idealIntArraySize(size + 1);
                    int[] copyOf2 = Arrays.copyOf(obj.keys, idealIntArraySize);
                    str = "copyOf(this, newSize)";
                    Intrinsics.checkNotNullExpressionValue(copyOf2, str);
                    obj.keys = copyOf2;
                    copyOf = Arrays.copyOf(obj.values, idealIntArraySize);
                    Intrinsics.checkNotNullExpressionValue(copyOf, str);
                    obj.values = copyOf;
                }
                obj.keys[size] = key;
                obj.values[size] = value;
                obj.size = size + 1;
            }
        } else {
        }
    }

    @Override // java.lang.Cloneable
    public void clear() {
        int i$iv;
        int i;
        final Object obj = this;
        final int i2 = 0;
        i$iv = 0;
        while (i$iv < obj.size) {
            obj.values[i$iv] = 0;
            i$iv++;
        }
        int i$iv2 = 0;
        obj.size = i$iv2;
        obj.garbage = i$iv2;
    }

    public androidx.collection.SparseArrayCompat<E> clone() {
        final Object clone = super.clone();
        Intrinsics.checkNotNull(clone, "null cannot be cast to non-null type androidx.collection.SparseArrayCompat<E of androidx.collection.SparseArrayCompat>");
        clone.keys = (int[])this.keys.clone();
        clone.values = (Object[])this.values.clone();
        return (SparseArrayCompat)clone;
    }

    @Override // java.lang.Cloneable
    public Object clone() {
        return clone();
    }

    @Override // java.lang.Cloneable
    public boolean containsKey(int key) {
        int i;
        final int i2 = 0;
        i = this.indexOfKey(key) >= 0 ? 1 : 0;
        return i;
    }

    public boolean containsValue(E value) {
        int i;
        int i$iv$iv;
        Object obj;
        final int i2 = 0;
        Object obj3 = obj2;
        final int i3 = 0;
        if (obj3.garbage) {
            SparseArrayCompatKt.access$gc(obj3);
        }
        i$iv$iv = 0;
        while (i$iv$iv < obj3.size) {
            i$iv$iv++;
        }
        i$iv$iv = -1;
        i = i$iv$iv >= 0 ? 1 : 0;
        return i;
    }

    @Deprecated(message = "Alias for remove(int).", replaceWith = @ReplaceWith(...))
    public void delete(int key) {
        remove(key);
    }

    public E get(int key) {
        return SparseArrayCompatKt.commonGet(this, key);
    }

    public E get(int key, E defaultValue) {
        return SparseArrayCompatKt.commonGet(this, key, defaultValue);
    }

    @Override // java.lang.Cloneable
    public final boolean getIsEmpty() {
        return isEmpty();
    }

    @Override // java.lang.Cloneable
    public int indexOfKey(int key) {
        Object obj = this;
        final int i = 0;
        if (obj.garbage) {
            SparseArrayCompatKt.access$gc(obj);
        }
        return ContainerHelpersKt.binarySearch(obj.keys, obj.size, key);
    }

    public int indexOfValue(E value) {
        int i$iv;
        Object obj;
        final Object obj2 = this;
        final int i = 0;
        if (obj2.garbage) {
            SparseArrayCompatKt.access$gc(obj2);
        }
        i$iv = 0;
        while (i$iv < obj2.size) {
            i$iv++;
        }
        i$iv = -1;
        return i$iv;
    }

    @Override // java.lang.Cloneable
    public boolean isEmpty() {
        int i;
        final int i2 = 0;
        i = this.size() == 0 ? 1 : 0;
        return i;
    }

    @Override // java.lang.Cloneable
    public int keyAt(int index) {
        Object obj = this;
        final int i = 0;
        if (obj.garbage) {
            SparseArrayCompatKt.access$gc(obj);
        }
        return obj.keys[index];
    }

    public void put(int key, E value) {
        int i$iv;
        Object[] values;
        int size2;
        boolean binarySearch;
        int idealIntArraySize;
        int values2;
        Object copyOf;
        String str;
        int size;
        final Object obj = this;
        final int i = 0;
        i$iv = ContainerHelpersKt.binarySearch(obj.keys, obj.size, key);
        if (i$iv >= 0) {
            obj.values[i$iv] = value;
        } else {
            i$iv = ~i$iv;
            if (i$iv < obj.size && obj.values[i$iv] == SparseArrayCompatKt.access$getDELETED$p()) {
                if (obj.values[i$iv] == SparseArrayCompatKt.access$getDELETED$p()) {
                    obj.keys[i$iv] = key;
                    obj.values[i$iv] = value;
                } else {
                    if (obj.garbage && obj.size >= keys6.length) {
                        if (obj.size >= keys6.length) {
                            SparseArrayCompatKt.access$gc(obj);
                            i$iv = ~binarySearch;
                        }
                    }
                    if (obj.size >= keys7.length) {
                        idealIntArraySize = ContainerHelpersKt.idealIntArraySize(size4++);
                        int[] copyOf2 = Arrays.copyOf(obj.keys, idealIntArraySize);
                        str = "copyOf(this, newSize)";
                        Intrinsics.checkNotNullExpressionValue(copyOf2, str);
                        obj.keys = copyOf2;
                        copyOf = Arrays.copyOf(obj.values, idealIntArraySize);
                        Intrinsics.checkNotNullExpressionValue(copyOf, str);
                        obj.values = copyOf;
                    }
                    if (n$iv -= i$iv != 0) {
                        ArraysKt.copyInto(obj.keys, obj.keys, i$iv + 1, i$iv, obj.size);
                        ArraysKt.copyInto(obj.values, obj.values, i$iv + 1, i$iv, obj.size);
                    }
                    obj.keys[i$iv] = key;
                    obj.values[i$iv] = value;
                    obj.size = size5++;
                }
            } else {
            }
        }
    }

    public void putAll(androidx.collection.SparseArrayCompat<? extends E> other) {
        int i$iv;
        int keyAt;
        Object valueAt;
        Object obj;
        int i;
        int i$iv$iv;
        Object[] values;
        int size;
        boolean binarySearch;
        int idealIntArraySize;
        int values2;
        Object copyOf;
        String str;
        int size2;
        Intrinsics.checkNotNullParameter(other, "other");
        final int i2 = 0;
        i$iv = 0;
        while (i$iv < other.size()) {
            keyAt = other.keyAt(i$iv);
            valueAt = other.valueAt(i$iv);
            obj = obj2;
            i = 0;
            i$iv$iv = ContainerHelpersKt.binarySearch(obj.keys, obj.size, keyAt);
            if (i$iv$iv >= 0) {
            } else {
            }
            i$iv$iv = ~i$iv$iv;
            if (i$iv$iv < obj.size && obj.values[i$iv$iv] == SparseArrayCompatKt.access$getDELETED$p()) {
            } else {
            }
            if (obj.garbage && obj.size >= keys9.length) {
            }
            if (obj.size >= keys6.length) {
            }
            if (n$iv$iv -= i$iv$iv != 0) {
            }
            obj.keys[i$iv$iv] = keyAt;
            obj.values[i$iv$iv] = valueAt;
            obj.size = size6++;
            i$iv++;
            ArraysKt.copyInto(obj.keys, obj.keys, i$iv$iv + 1, i$iv$iv, obj.size);
            ArraysKt.copyInto(obj.values, obj.values, i$iv$iv + 1, i$iv$iv, obj.size);
            idealIntArraySize = ContainerHelpersKt.idealIntArraySize(size5++);
            int[] copyOf2 = Arrays.copyOf(obj.keys, idealIntArraySize);
            str = "copyOf(this, newSize)";
            Intrinsics.checkNotNullExpressionValue(copyOf2, str);
            obj.keys = copyOf2;
            copyOf = Arrays.copyOf(obj.values, idealIntArraySize);
            Intrinsics.checkNotNullExpressionValue(copyOf, str);
            obj.values = copyOf;
            if (obj.size >= keys9.length) {
            }
            SparseArrayCompatKt.access$gc(obj);
            i$iv$iv = ~binarySearch;
            if (obj.values[i$iv$iv] == SparseArrayCompatKt.access$getDELETED$p()) {
            } else {
            }
            obj.keys[i$iv$iv] = keyAt;
            obj.values[i$iv$iv] = valueAt;
            obj.values[i$iv$iv] = valueAt;
        }
    }

    public E putIfAbsent(int key, E value) {
        androidx.collection.SparseArrayCompat sparseArrayCompat;
        int i;
        int i$iv$iv;
        int size;
        boolean binarySearch;
        int idealIntArraySize;
        int values;
        int values2;
        Object copyOf;
        String str;
        int size2;
        final androidx.collection.SparseArrayCompat sparseArrayCompat2 = this;
        final int i2 = 0;
        final Object commonGet = SparseArrayCompatKt.commonGet(sparseArrayCompat2, key);
        if (commonGet == null) {
            sparseArrayCompat = sparseArrayCompat2;
            i = 0;
            i$iv$iv = ContainerHelpersKt.binarySearch(sparseArrayCompat.keys, sparseArrayCompat.size, key);
            if (i$iv$iv >= 0) {
                sparseArrayCompat.values[i$iv$iv] = value;
            } else {
                i$iv$iv = ~i$iv$iv;
                if (i$iv$iv < sparseArrayCompat.size && sparseArrayCompat.values[i$iv$iv] == SparseArrayCompatKt.access$getDELETED$p()) {
                    if (sparseArrayCompat.values[i$iv$iv] == SparseArrayCompatKt.access$getDELETED$p()) {
                        sparseArrayCompat.keys[i$iv$iv] = key;
                        sparseArrayCompat.values[i$iv$iv] = value;
                    } else {
                        if (sparseArrayCompat.garbage && sparseArrayCompat.size >= keys9.length) {
                            if (sparseArrayCompat.size >= keys9.length) {
                                SparseArrayCompatKt.access$gc(sparseArrayCompat);
                                i$iv$iv = ~binarySearch;
                            }
                        }
                        if (sparseArrayCompat.size >= keys6.length) {
                            idealIntArraySize = ContainerHelpersKt.idealIntArraySize(size5++);
                            int[] copyOf2 = Arrays.copyOf(sparseArrayCompat.keys, idealIntArraySize);
                            str = "copyOf(this, newSize)";
                            Intrinsics.checkNotNullExpressionValue(copyOf2, str);
                            sparseArrayCompat.keys = copyOf2;
                            copyOf = Arrays.copyOf(sparseArrayCompat.values, idealIntArraySize);
                            Intrinsics.checkNotNullExpressionValue(copyOf, str);
                            sparseArrayCompat.values = copyOf;
                        }
                        if (n$iv$iv -= i$iv$iv != 0) {
                            ArraysKt.copyInto(sparseArrayCompat.keys, sparseArrayCompat.keys, i$iv$iv + 1, i$iv$iv, sparseArrayCompat.size);
                            ArraysKt.copyInto(sparseArrayCompat.values, sparseArrayCompat.values, i$iv$iv + 1, i$iv$iv, sparseArrayCompat.size);
                        }
                        sparseArrayCompat.keys[i$iv$iv] = key;
                        sparseArrayCompat.values[i$iv$iv] = value;
                        sparseArrayCompat.size = size4++;
                    }
                } else {
                }
            }
        }
        return commonGet;
    }

    @Override // java.lang.Cloneable
    public void remove(int key) {
        SparseArrayCompatKt.commonRemove(this, key);
    }

    @Override // java.lang.Cloneable
    public boolean remove(int key, Object value) {
        Object valueAt;
        boolean equal;
        int i;
        final Object obj = this;
        final int i2 = 0;
        final int indexOfKey = obj.indexOfKey(key);
        if (indexOfKey >= 0 && Intrinsics.areEqual(value, obj.valueAt(indexOfKey))) {
            i = Intrinsics.areEqual(value, obj.valueAt(indexOfKey)) ? 1 : 0;
        } else {
        }
        return i;
    }

    @Override // java.lang.Cloneable
    public void removeAt(int index) {
        Object obj2;
        Object obj;
        final Object obj3 = this;
        final int i = 0;
        if (obj3.values[index] != SparseArrayCompatKt.access$getDELETED$p()) {
            obj3.values[index] = SparseArrayCompatKt.access$getDELETED$p();
            obj3.garbage = true;
        }
    }

    @Override // java.lang.Cloneable
    public void removeAtRange(int index, int size) {
        int i$iv;
        final int i = 0;
        i$iv = index;
        while (i$iv < Math.min(size, index + size)) {
            this.removeAt(i$iv);
            i$iv++;
        }
    }

    public E replace(int key, E value) {
        Object oldValue$iv;
        Object[] values;
        final Object obj = this;
        final int i = 0;
        final int indexOfKey = obj.indexOfKey(key);
        if (indexOfKey >= 0) {
            oldValue$iv = obj.values[indexOfKey];
            obj.values[indexOfKey] = value;
        } else {
            oldValue$iv = 0;
        }
        return oldValue$iv;
    }

    public boolean replace(int key, E oldValue, E newValue) {
        Object obj;
        boolean equal;
        int i;
        final Object obj2 = this;
        final int i2 = 0;
        final int indexOfKey = obj2.indexOfKey(key);
        if (indexOfKey >= 0 && Intrinsics.areEqual(obj2.values[indexOfKey], oldValue)) {
            if (Intrinsics.areEqual(obj2.values[indexOfKey], oldValue)) {
                obj2.values[indexOfKey] = newValue;
                i = 1;
            } else {
                i = 0;
            }
        } else {
        }
        return i;
    }

    public void setValueAt(int index, E value) {
        final Object obj = this;
        final int i = 0;
        if (obj.garbage) {
            SparseArrayCompatKt.access$gc(obj);
        }
        obj.values[index] = value;
    }

    @Override // java.lang.Cloneable
    public int size() {
        Object obj = this;
        final int i = 0;
        if (obj.garbage) {
            SparseArrayCompatKt.access$gc(obj);
        }
        return obj.size;
    }

    @Override // java.lang.Cloneable
    public String toString() {
        String buffer$iv;
        String string;
        int i$iv;
        String str2;
        int keyAt;
        Object valueAt;
        String str;
        final Object obj = this;
        final int i = 0;
        if (obj.size() <= 0) {
            buffer$iv = "{}";
        } else {
            StringBuilder stringBuilder = new StringBuilder(size2 *= 28);
            stringBuilder.append('{');
            i$iv = 0;
            while (i$iv < obj.size) {
                if (i$iv > 0) {
                }
                stringBuilder.append(obj.keyAt(i$iv));
                stringBuilder.append('=');
                valueAt = obj.valueAt(i$iv);
                if (valueAt != obj) {
                } else {
                }
                stringBuilder.append("(this Map)");
                i$iv++;
                stringBuilder.append(valueAt);
                stringBuilder.append(", ");
            }
            stringBuilder.append('}');
            string = stringBuilder.toString();
            Intrinsics.checkNotNullExpressionValue(string, "buffer.toString()");
            buffer$iv = string;
        }
        return buffer$iv;
    }

    public E valueAt(int index) {
        Object obj = this;
        final int i = 0;
        if (obj.garbage) {
            SparseArrayCompatKt.access$gc(obj);
        }
        return obj.values[index];
    }
}
