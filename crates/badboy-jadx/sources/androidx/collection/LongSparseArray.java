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
@Metadata(d1 = "\u0000D\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001a\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0016\n\u0002\u0008\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0008 \n\u0002\u0010\u000e\n\u0002\u0008\u0003\u0008\u0016\u0018\u0000*\u0004\u0008\u0000\u0010\u00012\u00020\u0002B\u0011\u0008\u0007\u0012\u0008\u0008\u0002\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u001d\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0014J\u0008\u0010\u0015\u001a\u00020\u0010H\u0016J\u000e\u0010\u0016\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0000H\u0016J\u0010\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0015\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0019J\u0010\u0010\u001a\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0017J\u0018\u0010\u001b\u001a\u0004\u0018\u00018\u00002\u0006\u0010\u0011\u001a\u00020\u0012H\u0096\u0002¢\u0006\u0002\u0010\u001cJ\u001d\u0010\u001b\u001a\u00028\u00002\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u001d\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u001eJ\u0010\u0010\u001f\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0015\u0010 \u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010!J\u0008\u0010\"\u001a\u00020\u0007H\u0016J\u0010\u0010#\u001a\u00020\u00122\u0006\u0010$\u001a\u00020\u0004H\u0016J\u001d\u0010%\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0014J\u0018\u0010&\u001a\u00020\u00102\u000e\u0010'\u001a\n\u0012\u0006\u0008\u0001\u0012\u00028\u00000\u0000H\u0016J\u001f\u0010(\u001a\u0004\u0018\u00018\u00002\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u001eJ\u0010\u0010)\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u001d\u0010)\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010*J\u0010\u0010+\u001a\u00020\u00102\u0006\u0010$\u001a\u00020\u0004H\u0016J\u001f\u0010,\u001a\u0004\u0018\u00018\u00002\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u001eJ%\u0010,\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010-\u001a\u00028\u00002\u0006\u0010.\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010/J\u001d\u00100\u001a\u00020\u00102\u0006\u0010$\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00028\u0000H\u0016¢\u0006\u0002\u00101J\u0008\u0010\n\u001a\u00020\u0004H\u0016J\u0008\u00102\u001a\u000203H\u0016J\u0015\u00104\u001a\u00028\u00002\u0006\u0010$\u001a\u00020\u0004H\u0016¢\u0006\u0002\u00105R\u0012\u0010\u0006\u001a\u00020\u00078\u0000@\u0000X\u0081\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0008\u001a\u00020\t8\u0000@\u0000X\u0081\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\n\u001a\u00020\u00048\u0000@\u0000X\u0081\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\u000c8\u0000@\u0000X\u0081\u000e¢\u0006\u0004\n\u0002\u0010\u000e¨\u00066", d2 = {"Landroidx/collection/LongSparseArray;", "E", "", "initialCapacity", "", "(I)V", "garbage", "", "keys", "", "size", "values", "", "", "[Ljava/lang/Object;", "append", "", "key", "", "value", "(JLjava/lang/Object;)V", "clear", "clone", "containsKey", "containsValue", "(Ljava/lang/Object;)Z", "delete", "get", "(J)Ljava/lang/Object;", "defaultValue", "(JLjava/lang/Object;)Ljava/lang/Object;", "indexOfKey", "indexOfValue", "(Ljava/lang/Object;)I", "isEmpty", "keyAt", "index", "put", "putAll", "other", "putIfAbsent", "remove", "(JLjava/lang/Object;)Z", "removeAt", "replace", "oldValue", "newValue", "(JLjava/lang/Object;Ljava/lang/Object;)Z", "setValueAt", "(ILjava/lang/Object;)V", "toString", "", "valueAt", "(I)Ljava/lang/Object;", "collection"}, k = 1, mv = {1, 8, 0}, xi = 48)
public class LongSparseArray<E>  implements java.lang.Cloneable {

    public boolean garbage;
    public long[] keys;
    public int size;
    public Object[] values;
    public LongSparseArray() {
        super(0, 1, 0);
    }

    public LongSparseArray(int initialCapacity) {
        Object[] idealLongArraySize;
        Object[] arr;
        super();
        if (initialCapacity == 0) {
            this.keys = ContainerHelpersKt.EMPTY_LONGS;
            this.values = ContainerHelpersKt.EMPTY_OBJECTS;
        } else {
            idealLongArraySize = ContainerHelpersKt.idealLongArraySize(initialCapacity);
            this.keys = new long[idealLongArraySize];
            this.values = new Object[idealLongArraySize];
        }
    }

    public LongSparseArray(int i, int i2, DefaultConstructorMarker defaultConstructorMarker3) {
        int obj1;
        obj1 = i2 &= 1 != 0 ? 10 : obj1;
        super(obj1);
    }

    public void append(long key, E value) {
        int $this$commonGc$iv$iv;
        boolean garbage;
        int length;
        int idealLongArraySize;
        int copyOf;
        int newSize$iv$iv;
        long[] keys;
        Object[] values;
        int i$iv$iv;
        int i$iv$iv2;
        Object obj;
        Object obj2;
        final Object obj3 = this;
        final int i = 0;
        if (obj3.size != 0 && Long.compare(key, l) <= 0) {
            if (Long.compare(key, l) <= 0) {
                obj3.put(key, value);
            } else {
                if (obj3.garbage && obj3.size >= keys3.length) {
                    if (obj3.size >= keys3.length) {
                        garbage = obj3;
                        length = 0;
                        newSize$iv$iv = 0;
                        keys = garbage.keys;
                        values = garbage.values;
                        i$iv$iv = 0;
                        while (i$iv$iv < garbage.size) {
                            obj = values[i$iv$iv];
                            if (obj != LongSparseArrayKt.access$getDELETED$p() && i$iv$iv != newSize$iv$iv) {
                            }
                            i$iv$iv++;
                            if (i$iv$iv != newSize$iv$iv) {
                            }
                            newSize$iv$iv++;
                            keys[newSize$iv$iv] = keys[i$iv$iv];
                            values[newSize$iv$iv] = obj;
                            values[i$iv$iv] = 0;
                        }
                        garbage.garbage = false;
                        garbage.size = newSize$iv$iv;
                    }
                }
                $this$commonGc$iv$iv = obj3.size;
                if ($this$commonGc$iv$iv >= keys4.length) {
                    idealLongArraySize = ContainerHelpersKt.idealLongArraySize($this$commonGc$iv$iv + 1);
                    long[] copyOf2 = Arrays.copyOf(obj3.keys, idealLongArraySize);
                    newSize$iv$iv = "copyOf(this, newSize)";
                    Intrinsics.checkNotNullExpressionValue(copyOf2, newSize$iv$iv);
                    obj3.keys = copyOf2;
                    copyOf = Arrays.copyOf(obj3.values, idealLongArraySize);
                    Intrinsics.checkNotNullExpressionValue(copyOf, newSize$iv$iv);
                    obj3.values = copyOf;
                }
                obj3.keys[$this$commonGc$iv$iv] = key;
                obj3.values[$this$commonGc$iv$iv] = obj15;
                obj3.size = $this$commonGc$iv$iv + 1;
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

    public androidx.collection.LongSparseArray<E> clone() {
        final Object clone = super.clone();
        Intrinsics.checkNotNull(clone, "null cannot be cast to non-null type androidx.collection.LongSparseArray<E of androidx.collection.LongSparseArray>");
        clone.keys = (long[])this.keys.clone();
        clone.values = (Object[])this.values.clone();
        return (LongSparseArray)clone;
    }

    @Override // java.lang.Cloneable
    public Object clone() {
        return clone();
    }

    @Override // java.lang.Cloneable
    public boolean containsKey(long key) {
        int i;
        final int i2 = 0;
        i = this.indexOfKey(key) >= 0 ? 1 : 0;
        return i;
    }

    public boolean containsValue(E value) {
        int i;
        final int i2 = 0;
        i = this.indexOfValue(value) >= 0 ? 1 : 0;
        return i;
    }

    @Deprecated(message = "Alias for `remove(key)`.", replaceWith = @ReplaceWith(...))
    public void delete(long key) {
        int size;
        Object obj;
        final Object obj2 = this;
        final int i = 0;
        int binarySearch = ContainerHelpersKt.binarySearch(obj2.keys, obj2.size, key);
        if (binarySearch >= 0 && obj2.values[binarySearch] != LongSparseArrayKt.access$getDELETED$p()) {
            if (obj2.values[binarySearch] != LongSparseArrayKt.access$getDELETED$p()) {
                obj2.values[binarySearch] = LongSparseArrayKt.access$getDELETED$p();
                obj2.garbage = true;
            }
        }
    }

    public E get(long key) {
        Object obj2;
        int size;
        Object obj;
        final int i = 0;
        final Object obj4 = obj3;
        final int i3 = 0;
        int binarySearch = ContainerHelpersKt.binarySearch(obj4.keys, obj4.size, key);
        if (binarySearch >= 0) {
            if (obj4.values[binarySearch] == LongSparseArrayKt.access$getDELETED$p()) {
                obj2 = i2;
            } else {
                obj2 = obj4.values[binarySearch];
            }
        } else {
        }
        return obj2;
    }

    public E get(long key, E defaultValue) {
        Object obj;
        int size;
        Object obj2;
        final int i = 0;
        final Object obj4 = obj3;
        final int i2 = 0;
        int binarySearch = ContainerHelpersKt.binarySearch(obj4.keys, obj4.size, key);
        if (binarySearch >= 0) {
            if (obj4.values[binarySearch] == LongSparseArrayKt.access$getDELETED$p()) {
                obj = obj10;
            } else {
                obj = obj4.values[binarySearch];
            }
        } else {
        }
        return obj;
    }

    @Override // java.lang.Cloneable
    public int indexOfKey(long key) {
        boolean garbage;
        int i;
        int size;
        int newSize$iv$iv;
        long[] keys;
        Object[] values;
        int i$iv$iv2;
        int i$iv$iv;
        Object obj2;
        Object obj;
        Object obj3 = this;
        final int i2 = 0;
        if (obj3.garbage) {
            garbage = obj3;
            i = 0;
            newSize$iv$iv = 0;
            keys = garbage.keys;
            values = garbage.values;
            i$iv$iv = 0;
            while (i$iv$iv < garbage.size) {
                obj2 = values[i$iv$iv];
                if (obj2 != LongSparseArrayKt.access$getDELETED$p() && i$iv$iv != newSize$iv$iv) {
                }
                i$iv$iv++;
                if (i$iv$iv != newSize$iv$iv) {
                }
                newSize$iv$iv++;
                keys[newSize$iv$iv] = keys[i$iv$iv];
                values[newSize$iv$iv] = obj2;
                values[i$iv$iv] = 0;
            }
            garbage.garbage = false;
            garbage.size = newSize$iv$iv;
        }
        return ContainerHelpersKt.binarySearch(obj3.keys, obj3.size, key);
    }

    public int indexOfValue(E value) {
        boolean garbage;
        int i2;
        int i;
        int size;
        int newSize$iv$iv;
        long[] keys;
        Object[] values;
        int i$iv$iv;
        Object obj;
        Object obj2;
        final Object obj3 = this;
        final int i3 = 0;
        if (obj3.garbage) {
            garbage = obj3;
            i = 0;
            newSize$iv$iv = 0;
            keys = garbage.keys;
            values = garbage.values;
            i$iv$iv = 0;
            while (i$iv$iv < garbage.size) {
                obj = values[i$iv$iv];
                if (obj != LongSparseArrayKt.access$getDELETED$p() && i$iv$iv != newSize$iv$iv) {
                }
                i$iv$iv++;
                if (i$iv$iv != newSize$iv$iv) {
                }
                newSize$iv$iv++;
                keys[newSize$iv$iv] = keys[i$iv$iv];
                values[newSize$iv$iv] = obj;
                values[i$iv$iv] = 0;
            }
            garbage.garbage = false;
            garbage.size = newSize$iv$iv;
        }
        while (i2 < obj3.size) {
            size = 0;
            i2++;
        }
        i = -1;
        return i;
    }

    @Override // java.lang.Cloneable
    public boolean isEmpty() {
        int i;
        final int i2 = 0;
        i = this.size() == 0 ? 1 : 0;
        return i;
    }

    @Override // java.lang.Cloneable
    public long keyAt(int index) {
        int size2;
        int i2;
        boolean garbage;
        int i;
        int size;
        int newSize$iv$iv;
        long[] keys;
        Object[] values;
        int i$iv$iv;
        Object obj2;
        Object obj;
        Object obj3 = this;
        final int i3 = 0;
        int i4 = 0;
        if (index >= 0 && index < obj3.size) {
            i2 = index < obj3.size ? 1 : i4;
        } else {
        }
        if (i2 == 0) {
        } else {
            if (obj3.garbage) {
                garbage = obj3;
                i = 0;
                newSize$iv$iv = 0;
                keys = garbage.keys;
                values = garbage.values;
                i$iv$iv = 0;
                while (i$iv$iv < garbage.size) {
                    obj2 = values[i$iv$iv];
                    if (obj2 != LongSparseArrayKt.access$getDELETED$p() && i$iv$iv != newSize$iv$iv) {
                    }
                    i$iv$iv++;
                    if (i$iv$iv != newSize$iv$iv) {
                    }
                    newSize$iv$iv++;
                    keys[newSize$iv$iv] = keys[i$iv$iv];
                    values[newSize$iv$iv] = obj2;
                    values[i$iv$iv] = 0;
                }
                garbage.garbage = i4;
                garbage.size = newSize$iv$iv;
            }
            return obj3.keys[index];
        }
        int i5 = 0;
        StringBuilder stringBuilder = new StringBuilder();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.append("Expected index to be within 0..size()-1, but was ").append(index).toString().toString());
        throw illegalArgumentException;
    }

    public void put(long key, E value) {
        int index$iv;
        Object[] values;
        int size2;
        boolean binarySearch;
        int idealLongArraySize;
        int values2;
        int copyOf;
        int size;
        int newSize$iv$iv;
        long[] keys;
        Object[] values3;
        int i$iv$iv2;
        int i$iv$iv;
        Object obj2;
        Object obj;
        final int i = key;
        final Object obj3 = this;
        final int i2 = 0;
        index$iv = ContainerHelpersKt.binarySearch(obj3.keys, obj3.size, i);
        if (index$iv >= 0) {
            obj3.values[index$iv] = obj18;
        } else {
            index$iv = ~index$iv;
            if (index$iv < obj3.size && obj3.values[index$iv] == LongSparseArrayKt.access$getDELETED$p()) {
                if (obj3.values[index$iv] == LongSparseArrayKt.access$getDELETED$p()) {
                    obj3.keys[index$iv] = i;
                    obj3.values[index$iv] = obj18;
                } else {
                    if (obj3.garbage && obj3.size >= keys6.length) {
                        if (obj3.size >= keys6.length) {
                            Object obj4 = obj3;
                            int i4 = 0;
                            newSize$iv$iv = 0;
                            keys = obj4.keys;
                            values3 = obj4.values;
                            i$iv$iv = 0;
                            while (i$iv$iv < obj4.size) {
                                obj2 = values3[i$iv$iv];
                                if (obj2 != LongSparseArrayKt.access$getDELETED$p() && i$iv$iv != newSize$iv$iv) {
                                }
                                i$iv$iv++;
                                if (i$iv$iv != newSize$iv$iv) {
                                }
                                newSize$iv$iv++;
                                keys[newSize$iv$iv] = keys[i$iv$iv];
                                values3[newSize$iv$iv] = obj2;
                                values3[i$iv$iv] = 0;
                            }
                            obj4.garbage = false;
                            obj4.size = newSize$iv$iv;
                            index$iv = ~binarySearch;
                        }
                    }
                    if (obj3.size >= keys7.length) {
                        idealLongArraySize = ContainerHelpersKt.idealLongArraySize(size5++);
                        long[] copyOf2 = Arrays.copyOf(obj3.keys, idealLongArraySize);
                        size = "copyOf(this, newSize)";
                        Intrinsics.checkNotNullExpressionValue(copyOf2, size);
                        obj3.keys = copyOf2;
                        copyOf = Arrays.copyOf(obj3.values, idealLongArraySize);
                        Intrinsics.checkNotNullExpressionValue(copyOf, size);
                        obj3.values = copyOf;
                    }
                    if (newSize$iv -= index$iv != 0) {
                        ArraysKt.copyInto(obj3.keys, obj3.keys, index$iv + 1, index$iv, obj3.size);
                        ArraysKt.copyInto(obj3.values, obj3.values, index$iv + 1, index$iv, obj3.size);
                    }
                    obj3.keys[index$iv] = i;
                    obj3.values[index$iv] = obj18;
                    obj3.size = size4++;
                }
            } else {
            }
        }
    }

    public void putAll(androidx.collection.LongSparseArray<? extends E> other) {
        int i;
        int i2;
        int i3;
        long keyAt;
        Object valueAt;
        Intrinsics.checkNotNullParameter(other, "other");
        final int i4 = 0;
        i = 0;
        while (i < other.size()) {
            i2 = i;
            i3 = 0;
            this.put(other.keyAt(i2), obj7);
            i++;
        }
    }

    public E putIfAbsent(long key, E value) {
        final Object obj = this;
        final int i = 0;
        final Object obj2 = obj.get(key);
        if (obj2 == null) {
            obj.put(key, value);
        }
        return obj2;
    }

    @Override // java.lang.Cloneable
    public void remove(long key) {
        int size;
        Object obj;
        final Object obj2 = this;
        final int i = 0;
        int binarySearch = ContainerHelpersKt.binarySearch(obj2.keys, obj2.size, key);
        if (binarySearch >= 0 && obj2.values[binarySearch] != LongSparseArrayKt.access$getDELETED$p()) {
            if (obj2.values[binarySearch] != LongSparseArrayKt.access$getDELETED$p()) {
                obj2.values[binarySearch] = LongSparseArrayKt.access$getDELETED$p();
                obj2.garbage = true;
            }
        }
    }

    public boolean remove(long key, E value) {
        Object valueAt;
        boolean equal;
        int i;
        final Object obj = this;
        final int i2 = 0;
        final int indexOfKey = obj.indexOfKey(key);
        if (indexOfKey >= 0 && Intrinsics.areEqual(obj8, obj.valueAt(indexOfKey))) {
            i = Intrinsics.areEqual(obj8, obj.valueAt(indexOfKey)) ? 1 : 0;
        } else {
        }
        return i;
    }

    @Override // java.lang.Cloneable
    public void removeAt(int index) {
        Object obj;
        Object obj2;
        final Object obj3 = this;
        final int i = 0;
        if (obj3.values[index] != LongSparseArrayKt.access$getDELETED$p()) {
            obj3.values[index] = LongSparseArrayKt.access$getDELETED$p();
            obj3.garbage = true;
        }
    }

    public E replace(long key, E value) {
        Object oldValue$iv;
        Object[] values;
        final Object obj = this;
        final int i = 0;
        final int indexOfKey = obj.indexOfKey(key);
        if (indexOfKey >= 0) {
            oldValue$iv = obj.values[indexOfKey];
            obj.values[indexOfKey] = obj8;
        } else {
            oldValue$iv = 0;
        }
        return oldValue$iv;
    }

    public boolean replace(long key, E oldValue, E newValue) {
        Object obj;
        boolean equal;
        int i;
        final Object obj2 = this;
        final int i2 = 0;
        final int indexOfKey = obj2.indexOfKey(key);
        if (indexOfKey >= 0 && Intrinsics.areEqual(obj2.values[indexOfKey], newValue)) {
            if (Intrinsics.areEqual(obj2.values[indexOfKey], newValue)) {
                obj2.values[indexOfKey] = obj9;
                i = 1;
            } else {
                i = 0;
            }
        } else {
        }
        return i;
    }

    public void setValueAt(int index, E value) {
        int size;
        int i;
        boolean garbage;
        int i2;
        int size2;
        int newSize$iv$iv;
        long[] keys;
        Object[] values;
        int i$iv$iv;
        Object obj;
        Object obj2;
        final Object obj3 = this;
        final int i3 = 0;
        int i4 = 0;
        if (index >= 0 && index < obj3.size) {
            i = index < obj3.size ? 1 : i4;
        } else {
        }
        if (i == 0) {
        } else {
            if (obj3.garbage) {
                garbage = obj3;
                i2 = 0;
                newSize$iv$iv = 0;
                keys = garbage.keys;
                values = garbage.values;
                i$iv$iv = 0;
                while (i$iv$iv < garbage.size) {
                    obj = values[i$iv$iv];
                    if (obj != LongSparseArrayKt.access$getDELETED$p() && i$iv$iv != newSize$iv$iv) {
                    }
                    i$iv$iv++;
                    if (i$iv$iv != newSize$iv$iv) {
                    }
                    newSize$iv$iv++;
                    keys[newSize$iv$iv] = keys[i$iv$iv];
                    values[newSize$iv$iv] = obj;
                    values[i$iv$iv] = 0;
                }
                garbage.garbage = i4;
                garbage.size = newSize$iv$iv;
            }
            obj3.values[index] = value;
        }
        int i5 = 0;
        StringBuilder stringBuilder = new StringBuilder();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.append("Expected index to be within 0..size()-1, but was ").append(index).toString().toString());
        throw illegalArgumentException;
    }

    @Override // java.lang.Cloneable
    public int size() {
        boolean garbage;
        int i;
        int size;
        int newSize$iv$iv;
        long[] keys;
        Object[] values;
        int i$iv$iv2;
        int i$iv$iv;
        Object obj2;
        Object obj;
        Object obj3 = this;
        final int i2 = 0;
        if (obj3.garbage) {
            garbage = obj3;
            i = 0;
            newSize$iv$iv = 0;
            keys = garbage.keys;
            values = garbage.values;
            i$iv$iv = 0;
            while (i$iv$iv < garbage.size) {
                obj2 = values[i$iv$iv];
                if (obj2 != LongSparseArrayKt.access$getDELETED$p() && i$iv$iv != newSize$iv$iv) {
                }
                i$iv$iv++;
                if (i$iv$iv != newSize$iv$iv) {
                }
                newSize$iv$iv++;
                keys[newSize$iv$iv] = keys[i$iv$iv];
                values[newSize$iv$iv] = obj2;
                values[i$iv$iv] = 0;
            }
            garbage.garbage = false;
            garbage.size = newSize$iv$iv;
        }
        return obj3.size;
    }

    @Override // java.lang.Cloneable
    public String toString() {
        String string;
        String str;
        int i;
        int i$iv;
        int i$iv2;
        int size;
        long keyAt;
        Object valueAt;
        String str2;
        final Object obj = this;
        final int i2 = 0;
        if (obj.size() <= 0) {
            string = "{}";
        } else {
            StringBuilder stringBuilder = new StringBuilder(size3 *= 28);
            StringBuilder sb = stringBuilder;
            i = 0;
            sb.append('{');
            i$iv2 = 0;
            while (i$iv2 < obj.size) {
                if (i$iv2 > 0) {
                }
                sb.append(obj.keyAt(i$iv2));
                sb.append('=');
                valueAt = obj.valueAt(i$iv2);
                if (valueAt != sb) {
                } else {
                }
                sb.append("(this Map)");
                i$iv2++;
                sb.append(valueAt);
                sb.append(", ");
            }
            sb.append('}');
            Intrinsics.checkNotNullExpressionValue(stringBuilder.toString(), "StringBuilder(capacity).…builderAction).toString()");
        }
        return string;
    }

    public E valueAt(int index) {
        int size2;
        int i2;
        boolean garbage;
        int i;
        int size;
        int newSize$iv$iv;
        long[] keys;
        Object[] values;
        int i$iv$iv;
        Object obj;
        Object obj2;
        Object obj3 = this;
        final int i3 = 0;
        int i4 = 0;
        if (index >= 0 && index < obj3.size) {
            i2 = index < obj3.size ? 1 : i4;
        } else {
        }
        if (i2 == 0) {
        } else {
            if (obj3.garbage) {
                garbage = obj3;
                i = 0;
                newSize$iv$iv = 0;
                keys = garbage.keys;
                values = garbage.values;
                i$iv$iv = 0;
                while (i$iv$iv < garbage.size) {
                    obj = values[i$iv$iv];
                    if (obj != LongSparseArrayKt.access$getDELETED$p() && i$iv$iv != newSize$iv$iv) {
                    }
                    i$iv$iv++;
                    if (i$iv$iv != newSize$iv$iv) {
                    }
                    newSize$iv$iv++;
                    keys[newSize$iv$iv] = keys[i$iv$iv];
                    values[newSize$iv$iv] = obj;
                    values[i$iv$iv] = 0;
                }
                garbage.garbage = i4;
                garbage.size = newSize$iv$iv;
            }
            return obj3.values[index];
        }
        int i5 = 0;
        StringBuilder stringBuilder = new StringBuilder();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.append("Expected index to be within 0..size()-1, but was ").append(index).toString().toString());
        throw illegalArgumentException;
    }
}
