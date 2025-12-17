package androidx.collection;

import androidx.collection.internal.ContainerHelpersKt;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000,\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0004\n\u0002\u0010\u000b\n\u0002\u0008\u001b\n\u0002\u0010\u000e\n\u0002\u0008\u0005\u001a.\u0010\u0002\u001a\u00020\u0003\"\u0004\u0008\u0000\u0010\u0004*\u0008\u0012\u0004\u0012\u0002H\u00040\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0008\u001a\u0002H\u0004H\u0080\u0008¢\u0006\u0002\u0010\t\u001a\u0019\u0010\n\u001a\u00020\u0003\"\u0004\u0008\u0000\u0010\u0004*\u0008\u0012\u0004\u0012\u0002H\u00040\u0005H\u0080\u0008\u001a!\u0010\u000b\u001a\u00020\u000c\"\u0004\u0008\u0000\u0010\u0004*\u0008\u0012\u0004\u0012\u0002H\u00040\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0080\u0008\u001a&\u0010\r\u001a\u00020\u000c\"\u0004\u0008\u0000\u0010\u0004*\u0008\u0012\u0004\u0012\u0002H\u00040\u00052\u0006\u0010\u0008\u001a\u0002H\u0004H\u0080\u0008¢\u0006\u0002\u0010\u000e\u001a'\u0010\u000f\u001a\u0004\u0018\u0001H\u0004\"\u0004\u0008\u0000\u0010\u0004*\u0008\u0012\u0004\u0012\u0002H\u00040\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0000¢\u0006\u0002\u0010\u0010\u001a-\u0010\u000f\u001a\u0002H\u0004\"\u0004\u0008\u0000\u0010\u0004*\u0008\u0012\u0004\u0012\u0002H\u00040\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u0002H\u0004H\u0000¢\u0006\u0002\u0010\u0012\u001a!\u0010\u0013\u001a\u00020\u0007\"\u0004\u0008\u0000\u0010\u0004*\u0008\u0012\u0004\u0012\u0002H\u00040\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0080\u0008\u001a&\u0010\u0014\u001a\u00020\u0007\"\u0004\u0008\u0000\u0010\u0004*\u0008\u0012\u0004\u0012\u0002H\u00040\u00052\u0006\u0010\u0008\u001a\u0002H\u0004H\u0080\u0008¢\u0006\u0002\u0010\u0015\u001a\u0019\u0010\u0016\u001a\u00020\u000c\"\u0004\u0008\u0000\u0010\u0004*\u0008\u0012\u0004\u0012\u0002H\u00040\u0005H\u0080\u0008\u001a!\u0010\u0017\u001a\u00020\u0007\"\u0004\u0008\u0000\u0010\u0004*\u0008\u0012\u0004\u0012\u0002H\u00040\u00052\u0006\u0010\u0018\u001a\u00020\u0007H\u0080\u0008\u001a.\u0010\u0019\u001a\u00020\u0003\"\u0004\u0008\u0000\u0010\u0004*\u0008\u0012\u0004\u0012\u0002H\u00040\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0008\u001a\u0002H\u0004H\u0080\u0008¢\u0006\u0002\u0010\t\u001a)\u0010\u001a\u001a\u00020\u0003\"\u0004\u0008\u0000\u0010\u0004*\u0008\u0012\u0004\u0012\u0002H\u00040\u00052\u000e\u0010\u001b\u001a\n\u0012\u0006\u0008\u0001\u0012\u0002H\u00040\u0005H\u0080\u0008\u001a0\u0010\u001c\u001a\u0004\u0018\u0001H\u0004\"\u0004\u0008\u0000\u0010\u0004*\u0008\u0012\u0004\u0012\u0002H\u00040\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0008\u001a\u0002H\u0004H\u0080\u0008¢\u0006\u0002\u0010\u0012\u001a \u0010\u001d\u001a\u00020\u0003\"\u0004\u0008\u0000\u0010\u0004*\u0008\u0012\u0004\u0012\u0002H\u00040\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0000\u001a+\u0010\u001d\u001a\u00020\u000c\"\u0004\u0008\u0000\u0010\u0004*\u0008\u0012\u0004\u0012\u0002H\u00040\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0008\u0010\u0008\u001a\u0004\u0018\u00010\u0001H\u0080\u0008\u001a!\u0010\u001e\u001a\u00020\u0003\"\u0004\u0008\u0000\u0010\u0004*\u0008\u0012\u0004\u0012\u0002H\u00040\u00052\u0006\u0010\u0018\u001a\u00020\u0007H\u0080\u0008\u001a)\u0010\u001f\u001a\u00020\u0003\"\u0004\u0008\u0000\u0010\u0004*\u0008\u0012\u0004\u0012\u0002H\u00040\u00052\u0006\u0010\u0018\u001a\u00020\u00072\u0006\u0010 \u001a\u00020\u0007H\u0080\u0008\u001a0\u0010!\u001a\u0004\u0018\u0001H\u0004\"\u0004\u0008\u0000\u0010\u0004*\u0008\u0012\u0004\u0012\u0002H\u00040\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0008\u001a\u0002H\u0004H\u0080\u0008¢\u0006\u0002\u0010\u0012\u001a6\u0010!\u001a\u00020\u000c\"\u0004\u0008\u0000\u0010\u0004*\u0008\u0012\u0004\u0012\u0002H\u00040\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\"\u001a\u0002H\u00042\u0006\u0010#\u001a\u0002H\u0004H\u0080\u0008¢\u0006\u0002\u0010$\u001a.\u0010%\u001a\u00020\u0003\"\u0004\u0008\u0000\u0010\u0004*\u0008\u0012\u0004\u0012\u0002H\u00040\u00052\u0006\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0008\u001a\u0002H\u0004H\u0080\u0008¢\u0006\u0002\u0010\t\u001a\u0019\u0010&\u001a\u00020\u0007\"\u0004\u0008\u0000\u0010\u0004*\u0008\u0012\u0004\u0012\u0002H\u00040\u0005H\u0080\u0008\u001a\u0019\u0010'\u001a\u00020(\"\u0004\u0008\u0000\u0010\u0004*\u0008\u0012\u0004\u0012\u0002H\u00040\u0005H\u0080\u0008\u001a&\u0010)\u001a\u0002H\u0004\"\u0004\u0008\u0000\u0010\u0004*\u0008\u0012\u0004\u0012\u0002H\u00040\u00052\u0006\u0010\u0018\u001a\u00020\u0007H\u0080\u0008¢\u0006\u0002\u0010\u0010\u001a\u0018\u0010*\u001a\u00020\u0003\"\u0004\u0008\u0000\u0010\u0004*\u0008\u0012\u0004\u0012\u0002H\u00040\u0005H\u0002\u001a:\u0010+\u001a\u0002H,\"\u0004\u0008\u0000\u0010\u0004\"\n\u0008\u0001\u0010,*\u0004\u0018\u0001H\u0004*\u0008\u0012\u0004\u0012\u0002H\u00040\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u0002H,H\u0082\u0008¢\u0006\u0002\u0010\u0012\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006-", d2 = {"DELETED", "", "commonAppend", "", "E", "Landroidx/collection/SparseArrayCompat;", "key", "", "value", "(Landroidx/collection/SparseArrayCompat;ILjava/lang/Object;)V", "commonClear", "commonContainsKey", "", "commonContainsValue", "(Landroidx/collection/SparseArrayCompat;Ljava/lang/Object;)Z", "commonGet", "(Landroidx/collection/SparseArrayCompat;I)Ljava/lang/Object;", "defaultValue", "(Landroidx/collection/SparseArrayCompat;ILjava/lang/Object;)Ljava/lang/Object;", "commonIndexOfKey", "commonIndexOfValue", "(Landroidx/collection/SparseArrayCompat;Ljava/lang/Object;)I", "commonIsEmpty", "commonKeyAt", "index", "commonPut", "commonPutAll", "other", "commonPutIfAbsent", "commonRemove", "commonRemoveAt", "commonRemoveAtRange", "size", "commonReplace", "oldValue", "newValue", "(Landroidx/collection/SparseArrayCompat;ILjava/lang/Object;Ljava/lang/Object;)Z", "commonSetValueAt", "commonSize", "commonToString", "", "commonValueAt", "gc", "internalGet", "T", "collection"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class SparseArrayCompatKt {

    private static final Object DELETED;
    static {
        Object object = new Object();
        SparseArrayCompatKt.DELETED = object;
    }

    public static final void access$gc(androidx.collection.SparseArrayCompat $receiver) {
        SparseArrayCompatKt.gc($receiver);
    }

    public static final Object access$getDELETED$p() {
        return SparseArrayCompatKt.DELETED;
    }

    public static final <E> void commonAppend(androidx.collection.SparseArrayCompat<E> $this$commonAppend, int key, E value) {
        int size;
        boolean garbage;
        int length;
        int idealIntArraySize;
        Object[] copyOf;
        String str;
        Intrinsics.checkNotNullParameter($this$commonAppend, "<this>");
        int i = 0;
        if ($this$commonAppend.size != 0 && key <= $this$commonAppend.keys[size3--]) {
            if (key <= $this$commonAppend.keys[size3--]) {
                $this$commonAppend.put(key, value);
            }
        }
        if ($this$commonAppend.garbage && $this$commonAppend.size >= keys3.length) {
            if ($this$commonAppend.size >= keys3.length) {
                SparseArrayCompatKt.access$gc($this$commonAppend);
            }
        }
        int size2 = $this$commonAppend.size;
        if (size2 >= keys2.length) {
            idealIntArraySize = ContainerHelpersKt.idealIntArraySize(size2 + 1);
            int[] copyOf2 = Arrays.copyOf($this$commonAppend.keys, idealIntArraySize);
            str = "copyOf(this, newSize)";
            Intrinsics.checkNotNullExpressionValue(copyOf2, str);
            $this$commonAppend.keys = copyOf2;
            copyOf = Arrays.copyOf($this$commonAppend.values, idealIntArraySize);
            Intrinsics.checkNotNullExpressionValue(copyOf, str);
            $this$commonAppend.values = copyOf;
        }
        $this$commonAppend.keys[size2] = key;
        $this$commonAppend.values[size2] = value;
        $this$commonAppend.size = size2 + 1;
    }

    public static final <E> void commonClear(androidx.collection.SparseArrayCompat<E> $this$commonClear) {
        int i;
        int i2;
        Intrinsics.checkNotNullParameter($this$commonClear, "<this>");
        int i3 = 0;
        i = 0;
        while (i < $this$commonClear.size) {
            $this$commonClear.values[i] = 0;
            i++;
        }
        int i4 = 0;
        $this$commonClear.size = i4;
        $this$commonClear.garbage = i4;
    }

    public static final <E> boolean commonContainsKey(androidx.collection.SparseArrayCompat<E> $this$commonContainsKey, int key) {
        int i;
        Intrinsics.checkNotNullParameter($this$commonContainsKey, "<this>");
        int i2 = 0;
        i = $this$commonContainsKey.indexOfKey(key) >= 0 ? 1 : 0;
        return i;
    }

    public static final <E> boolean commonContainsValue(androidx.collection.SparseArrayCompat<E> $this$commonContainsValue, E value) {
        int i;
        int i$iv;
        Object obj;
        Intrinsics.checkNotNullParameter($this$commonContainsValue, "<this>");
        int i2 = 0;
        Object obj2 = $this$commonContainsValue;
        final int i3 = 0;
        if (obj2.garbage) {
            SparseArrayCompatKt.access$gc(obj2);
        }
        i$iv = 0;
        while (i$iv < obj2.size) {
            i$iv++;
        }
        i$iv = -1;
        i = i$iv >= 0 ? 1 : 0;
        return i;
    }

    public static final <E> E commonGet(androidx.collection.SparseArrayCompat<E> $this$commonGet, int key) {
        Object obj;
        int size;
        Object dELETED;
        Intrinsics.checkNotNullParameter($this$commonGet, "<this>");
        final Object obj2 = $this$commonGet;
        final int i2 = 0;
        int binarySearch = ContainerHelpersKt.binarySearch(obj2.keys, obj2.size, key);
        if (binarySearch >= 0) {
            if (obj2.values[binarySearch] == SparseArrayCompatKt.DELETED) {
                obj = i;
            } else {
                obj = obj2.values[binarySearch];
            }
        } else {
        }
        return obj;
    }

    public static final <E> E commonGet(androidx.collection.SparseArrayCompat<E> $this$commonGet, int key, E defaultValue) {
        Object obj;
        int size;
        Object dELETED;
        Intrinsics.checkNotNullParameter($this$commonGet, "<this>");
        Object obj2 = $this$commonGet;
        final int i = 0;
        int binarySearch = ContainerHelpersKt.binarySearch(obj2.keys, obj2.size, key);
        if (binarySearch >= 0) {
            if (obj2.values[binarySearch] == SparseArrayCompatKt.DELETED) {
                obj = defaultValue;
            } else {
                obj = obj2.values[binarySearch];
            }
        } else {
        }
        return obj;
    }

    public static final <E> int commonIndexOfKey(androidx.collection.SparseArrayCompat<E> $this$commonIndexOfKey, int key) {
        Intrinsics.checkNotNullParameter($this$commonIndexOfKey, "<this>");
        int i = 0;
        if ($this$commonIndexOfKey.garbage) {
            SparseArrayCompatKt.access$gc($this$commonIndexOfKey);
        }
        return ContainerHelpersKt.binarySearch($this$commonIndexOfKey.keys, $this$commonIndexOfKey.size, key);
    }

    public static final <E> int commonIndexOfValue(androidx.collection.SparseArrayCompat<E> $this$commonIndexOfValue, E value) {
        int i;
        Object obj;
        Intrinsics.checkNotNullParameter($this$commonIndexOfValue, "<this>");
        int i2 = 0;
        if ($this$commonIndexOfValue.garbage) {
            SparseArrayCompatKt.access$gc($this$commonIndexOfValue);
        }
        i = 0;
        while (i < $this$commonIndexOfValue.size) {
            i++;
        }
        return -1;
    }

    public static final <E> boolean commonIsEmpty(androidx.collection.SparseArrayCompat<E> $this$commonIsEmpty) {
        int i;
        Intrinsics.checkNotNullParameter($this$commonIsEmpty, "<this>");
        int i2 = 0;
        i = $this$commonIsEmpty.size() == 0 ? 1 : 0;
        return i;
    }

    public static final <E> int commonKeyAt(androidx.collection.SparseArrayCompat<E> $this$commonKeyAt, int index) {
        Intrinsics.checkNotNullParameter($this$commonKeyAt, "<this>");
        int i = 0;
        if ($this$commonKeyAt.garbage) {
            SparseArrayCompatKt.access$gc($this$commonKeyAt);
        }
        return $this$commonKeyAt.keys[index];
    }

    public static final <E> void commonPut(androidx.collection.SparseArrayCompat<E> $this$commonPut, int key, E value) {
        int i;
        int size;
        boolean binarySearch;
        int idealIntArraySize;
        int values2;
        int values;
        Object copyOf;
        String str;
        int size2;
        Intrinsics.checkNotNullParameter($this$commonPut, "<this>");
        int i2 = 0;
        i = ContainerHelpersKt.binarySearch($this$commonPut.keys, $this$commonPut.size, key);
        if (i >= 0) {
            $this$commonPut.values[i] = value;
        } else {
            i = ~i;
            if (i < $this$commonPut.size && $this$commonPut.values[i] == SparseArrayCompatKt.access$getDELETED$p()) {
                if ($this$commonPut.values[i] == SparseArrayCompatKt.access$getDELETED$p()) {
                    $this$commonPut.keys[i] = key;
                    $this$commonPut.values[i] = value;
                }
            }
            if ($this$commonPut.garbage && $this$commonPut.size >= keys6.length) {
                if ($this$commonPut.size >= keys6.length) {
                    SparseArrayCompatKt.access$gc($this$commonPut);
                    i = ~binarySearch;
                }
            }
            if ($this$commonPut.size >= keys7.length) {
                idealIntArraySize = ContainerHelpersKt.idealIntArraySize(size5++);
                int[] copyOf2 = Arrays.copyOf($this$commonPut.keys, idealIntArraySize);
                str = "copyOf(this, newSize)";
                Intrinsics.checkNotNullExpressionValue(copyOf2, str);
                $this$commonPut.keys = copyOf2;
                copyOf = Arrays.copyOf($this$commonPut.values, idealIntArraySize);
                Intrinsics.checkNotNullExpressionValue(copyOf, str);
                $this$commonPut.values = copyOf;
            }
            if (n -= i != 0) {
                ArraysKt.copyInto($this$commonPut.keys, $this$commonPut.keys, i + 1, i, $this$commonPut.size);
                ArraysKt.copyInto($this$commonPut.values, $this$commonPut.values, i + 1, i, $this$commonPut.size);
            }
            $this$commonPut.keys[i] = key;
            $this$commonPut.values[i] = value;
            $this$commonPut.size = size4++;
        }
    }

    public static final <E> void commonPutAll(androidx.collection.SparseArrayCompat<E> $this$commonPutAll, androidx.collection.SparseArrayCompat<? extends E> other) {
        int i2;
        int keyAt;
        Object valueAt;
        Object obj;
        int i;
        int i$iv;
        Object[] values2;
        int size2;
        boolean binarySearch;
        int idealIntArraySize;
        int values;
        Object copyOf;
        String str;
        int size;
        Intrinsics.checkNotNullParameter($this$commonPutAll, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        int i3 = 0;
        i2 = 0;
        while (i2 < other.size()) {
            keyAt = other.keyAt(i2);
            valueAt = other.valueAt(i2);
            obj = $this$commonPutAll;
            i = 0;
            i$iv = ContainerHelpersKt.binarySearch(obj.keys, obj.size, keyAt);
            if (i$iv >= 0) {
            } else {
            }
            i$iv = ~i$iv;
            if (i$iv < obj.size && obj.values[i$iv] == SparseArrayCompatKt.access$getDELETED$p()) {
            } else {
            }
            if (obj.garbage && obj.size >= keys9.length) {
            }
            if (obj.size >= keys6.length) {
            }
            if (n$iv -= i$iv != 0) {
            }
            obj.keys[i$iv] = keyAt;
            obj.values[i$iv] = valueAt;
            obj.size = size6++;
            i2++;
            ArraysKt.copyInto(obj.keys, obj.keys, i$iv + 1, i$iv, obj.size);
            ArraysKt.copyInto(obj.values, obj.values, i$iv + 1, i$iv, obj.size);
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
            i$iv = ~binarySearch;
            if (obj.values[i$iv] == SparseArrayCompatKt.access$getDELETED$p()) {
            } else {
            }
            obj.keys[i$iv] = keyAt;
            obj.values[i$iv] = valueAt;
            obj.values[i$iv] = valueAt;
        }
    }

    public static final <E> E commonPutIfAbsent(androidx.collection.SparseArrayCompat<E> $this$commonPutIfAbsent, int key, E value) {
        Object obj;
        int i;
        int i$iv;
        int size;
        boolean binarySearch;
        int idealIntArraySize;
        int values2;
        int values;
        Object copyOf;
        String str;
        int size2;
        Intrinsics.checkNotNullParameter($this$commonPutIfAbsent, "<this>");
        int i2 = 0;
        final Object commonGet = SparseArrayCompatKt.commonGet($this$commonPutIfAbsent, key);
        if (commonGet == null) {
            obj = $this$commonPutIfAbsent;
            i = 0;
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
                        if (obj.garbage && obj.size >= keys9.length) {
                            if (obj.size >= keys9.length) {
                                SparseArrayCompatKt.access$gc(obj);
                                i$iv = ~binarySearch;
                            }
                        }
                        if (obj.size >= keys6.length) {
                            idealIntArraySize = ContainerHelpersKt.idealIntArraySize(size5++);
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
                        obj.size = size4++;
                    }
                } else {
                }
            }
        }
        return commonGet;
    }

    public static final <E> void commonRemove(androidx.collection.SparseArrayCompat<E> $this$commonRemove, int key) {
        int size;
        Object dELETED;
        Intrinsics.checkNotNullParameter($this$commonRemove, "<this>");
        int binarySearch = ContainerHelpersKt.binarySearch($this$commonRemove.keys, $this$commonRemove.size, key);
        if (binarySearch >= 0 && $this$commonRemove.values[binarySearch] != SparseArrayCompatKt.DELETED) {
            if ($this$commonRemove.values[binarySearch] != SparseArrayCompatKt.DELETED) {
                $this$commonRemove.values[binarySearch] = SparseArrayCompatKt.DELETED;
                $this$commonRemove.garbage = true;
            }
        }
    }

    public static final <E> boolean commonRemove(androidx.collection.SparseArrayCompat<E> $this$commonRemove, int key, Object value) {
        Object valueAt;
        boolean equal;
        Intrinsics.checkNotNullParameter($this$commonRemove, "<this>");
        int i = 0;
        final int indexOfKey = $this$commonRemove.indexOfKey(key);
        if (indexOfKey >= 0 && Intrinsics.areEqual(value, $this$commonRemove.valueAt(indexOfKey))) {
            if (Intrinsics.areEqual(value, $this$commonRemove.valueAt(indexOfKey))) {
                $this$commonRemove.removeAt(indexOfKey);
                return 1;
            }
        }
        return 0;
    }

    public static final <E> void commonRemoveAt(androidx.collection.SparseArrayCompat<E> $this$commonRemoveAt, int index) {
        Object obj;
        Object obj2;
        Intrinsics.checkNotNullParameter($this$commonRemoveAt, "<this>");
        int i = 0;
        if ($this$commonRemoveAt.values[index] != SparseArrayCompatKt.access$getDELETED$p()) {
            $this$commonRemoveAt.values[index] = SparseArrayCompatKt.access$getDELETED$p();
            $this$commonRemoveAt.garbage = true;
        }
    }

    public static final <E> void commonRemoveAtRange(androidx.collection.SparseArrayCompat<E> $this$commonRemoveAtRange, int index, int size) {
        int i;
        Intrinsics.checkNotNullParameter($this$commonRemoveAtRange, "<this>");
        int i2 = 0;
        i = index;
        while (i < Math.min(size, index + size)) {
            $this$commonRemoveAtRange.removeAt(i);
            i++;
        }
    }

    public static final <E> E commonReplace(androidx.collection.SparseArrayCompat<E> $this$commonReplace, int key, E value) {
        Intrinsics.checkNotNullParameter($this$commonReplace, "<this>");
        int i = 0;
        final int indexOfKey = $this$commonReplace.indexOfKey(key);
        if (indexOfKey >= 0) {
            $this$commonReplace.values[indexOfKey] = value;
            return $this$commonReplace.values[indexOfKey];
        }
        return 0;
    }

    public static final <E> boolean commonReplace(androidx.collection.SparseArrayCompat<E> $this$commonReplace, int key, E oldValue, E newValue) {
        Object obj;
        boolean equal;
        Intrinsics.checkNotNullParameter($this$commonReplace, "<this>");
        int i = 0;
        final int indexOfKey = $this$commonReplace.indexOfKey(key);
        if (indexOfKey >= 0 && Intrinsics.areEqual($this$commonReplace.values[indexOfKey], oldValue)) {
            if (Intrinsics.areEqual($this$commonReplace.values[indexOfKey], oldValue)) {
                $this$commonReplace.values[indexOfKey] = newValue;
                return 1;
            }
        }
        return 0;
    }

    public static final <E> void commonSetValueAt(androidx.collection.SparseArrayCompat<E> $this$commonSetValueAt, int index, E value) {
        Intrinsics.checkNotNullParameter($this$commonSetValueAt, "<this>");
        int i = 0;
        if ($this$commonSetValueAt.garbage) {
            SparseArrayCompatKt.access$gc($this$commonSetValueAt);
        }
        $this$commonSetValueAt.values[index] = value;
    }

    public static final <E> int commonSize(androidx.collection.SparseArrayCompat<E> $this$commonSize) {
        Intrinsics.checkNotNullParameter($this$commonSize, "<this>");
        int i = 0;
        if ($this$commonSize.garbage) {
            SparseArrayCompatKt.access$gc($this$commonSize);
        }
        return $this$commonSize.size;
    }

    public static final <E> String commonToString(androidx.collection.SparseArrayCompat<E> $this$commonToString) {
        int i;
        int keyAt;
        Object valueAt;
        String str;
        Intrinsics.checkNotNullParameter($this$commonToString, "<this>");
        int i2 = 0;
        if ($this$commonToString.size() <= 0) {
            return "{}";
        }
        StringBuilder stringBuilder = new StringBuilder(size2 *= 28);
        stringBuilder.append('{');
        i = 0;
        while (i < $this$commonToString.size) {
            if (i > 0) {
            }
            stringBuilder.append($this$commonToString.keyAt(i));
            stringBuilder.append('=');
            valueAt = $this$commonToString.valueAt(i);
            if (valueAt != $this$commonToString) {
            } else {
            }
            stringBuilder.append("(this Map)");
            i++;
            stringBuilder.append(valueAt);
            stringBuilder.append(", ");
        }
        stringBuilder.append('}');
        String string = stringBuilder.toString();
        Intrinsics.checkNotNullExpressionValue(string, "buffer.toString()");
        return string;
    }

    public static final <E> E commonValueAt(androidx.collection.SparseArrayCompat<E> $this$commonValueAt, int index) {
        Intrinsics.checkNotNullParameter($this$commonValueAt, "<this>");
        int i = 0;
        if ($this$commonValueAt.garbage) {
            SparseArrayCompatKt.access$gc($this$commonValueAt);
        }
        return $this$commonValueAt.values[index];
    }

    private static final <E> void gc(androidx.collection.SparseArrayCompat<E> $this$gc) {
        int o;
        int i;
        Object obj;
        Object dELETED;
        o = 0;
        final int[] keys = $this$gc.keys;
        final Object[] values = $this$gc.values;
        i = 0;
        while (i < $this$gc.size) {
            obj = values[i];
            if (obj != SparseArrayCompatKt.DELETED && i != o) {
            }
            i++;
            if (i != o) {
            }
            o++;
            keys[o] = keys[i];
            values[o] = obj;
            values[i] = 0;
        }
        $this$gc.garbage = false;
        $this$gc.size = o;
    }

    private static final <E, T extends E> T internalGet(androidx.collection.SparseArrayCompat<E> $this$internalGet, int key, T defaultValue) {
        Object obj;
        int size;
        Object dELETED;
        final int i = 0;
        int binarySearch = ContainerHelpersKt.binarySearch($this$internalGet.keys, $this$internalGet.size, key);
        if (binarySearch >= 0) {
            if ($this$internalGet.values[binarySearch] == SparseArrayCompatKt.DELETED) {
                obj = defaultValue;
            } else {
                obj = $this$internalGet.values[binarySearch];
            }
        } else {
        }
        return obj;
    }
}
