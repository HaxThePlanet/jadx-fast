package androidx.collection;

import androidx.collection.internal.ContainerHelpersKt;
import java.util.Arrays;
import java.util.Iterator;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.LongIterator;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000X\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0010\t\n\u0002\u0008\u0004\n\u0002\u0010\u000b\n\u0002\u0008\u001d\n\u0002\u0010\u000e\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010(\n\u0000\u001a.\u0010\n\u001a\u00020\u000b\"\u0004\u0008\u0000\u0010\u000c*\u0008\u0012\u0004\u0012\u0002H\u000c0\u00052\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u0002H\u000cH\u0080\u0008¢\u0006\u0002\u0010\u0010\u001a\u0019\u0010\u0011\u001a\u00020\u000b\"\u0004\u0008\u0000\u0010\u000c*\u0008\u0012\u0004\u0012\u0002H\u000c0\u0005H\u0080\u0008\u001a!\u0010\u0012\u001a\u00020\u0013\"\u0004\u0008\u0000\u0010\u000c*\u0008\u0012\u0004\u0012\u0002H\u000c0\u00052\u0006\u0010\r\u001a\u00020\u000eH\u0080\u0008\u001a&\u0010\u0014\u001a\u00020\u0013\"\u0004\u0008\u0000\u0010\u000c*\u0008\u0012\u0004\u0012\u0002H\u000c0\u00052\u0006\u0010\u000f\u001a\u0002H\u000cH\u0080\u0008¢\u0006\u0002\u0010\u0015\u001a\u0019\u0010\u0016\u001a\u00020\u000b\"\u0004\u0008\u0000\u0010\u000c*\u0008\u0012\u0004\u0012\u0002H\u000c0\u0005H\u0080\u0008\u001a(\u0010\u0017\u001a\u0004\u0018\u0001H\u000c\"\u0004\u0008\u0000\u0010\u000c*\u0008\u0012\u0004\u0012\u0002H\u000c0\u00052\u0006\u0010\r\u001a\u00020\u000eH\u0080\u0008¢\u0006\u0002\u0010\u0018\u001a.\u0010\u0017\u001a\u0002H\u000c\"\u0004\u0008\u0000\u0010\u000c*\u0008\u0012\u0004\u0012\u0002H\u000c0\u00052\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0019\u001a\u0002H\u000cH\u0080\u0008¢\u0006\u0002\u0010\u001a\u001a:\u0010\u001b\u001a\u0002H\u0004\"\n\u0008\u0000\u0010\u0004*\u0004\u0018\u0001H\u000c\"\u0004\u0008\u0001\u0010\u000c*\u0008\u0012\u0004\u0012\u0002H\u000c0\u00052\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0019\u001a\u0002H\u0004H\u0080\u0008¢\u0006\u0002\u0010\u001a\u001a!\u0010\u001c\u001a\u00020\u0003\"\u0004\u0008\u0000\u0010\u000c*\u0008\u0012\u0004\u0012\u0002H\u000c0\u00052\u0006\u0010\r\u001a\u00020\u000eH\u0080\u0008\u001a&\u0010\u001d\u001a\u00020\u0003\"\u0004\u0008\u0000\u0010\u000c*\u0008\u0012\u0004\u0012\u0002H\u000c0\u00052\u0006\u0010\u000f\u001a\u0002H\u000cH\u0080\u0008¢\u0006\u0002\u0010\u001e\u001a\u0019\u0010\u001f\u001a\u00020\u0013\"\u0004\u0008\u0000\u0010\u000c*\u0008\u0012\u0004\u0012\u0002H\u000c0\u0005H\u0080\u0008\u001a!\u0010 \u001a\u00020\u000e\"\u0004\u0008\u0000\u0010\u000c*\u0008\u0012\u0004\u0012\u0002H\u000c0\u00052\u0006\u0010!\u001a\u00020\u0003H\u0080\u0008\u001a.\u0010\"\u001a\u00020\u000b\"\u0004\u0008\u0000\u0010\u000c*\u0008\u0012\u0004\u0012\u0002H\u000c0\u00052\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u0002H\u000cH\u0080\u0008¢\u0006\u0002\u0010\u0010\u001a)\u0010#\u001a\u00020\u000b\"\u0004\u0008\u0000\u0010\u000c*\u0008\u0012\u0004\u0012\u0002H\u000c0\u00052\u000e\u0010$\u001a\n\u0012\u0006\u0008\u0001\u0012\u0002H\u000c0\u0005H\u0080\u0008\u001a0\u0010%\u001a\u0004\u0018\u0001H\u000c\"\u0004\u0008\u0000\u0010\u000c*\u0008\u0012\u0004\u0012\u0002H\u000c0\u00052\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u0002H\u000cH\u0080\u0008¢\u0006\u0002\u0010\u001a\u001a!\u0010&\u001a\u00020\u000b\"\u0004\u0008\u0000\u0010\u000c*\u0008\u0012\u0004\u0012\u0002H\u000c0\u00052\u0006\u0010\r\u001a\u00020\u000eH\u0080\u0008\u001a.\u0010&\u001a\u00020\u0013\"\u0004\u0008\u0000\u0010\u000c*\u0008\u0012\u0004\u0012\u0002H\u000c0\u00052\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u0002H\u000cH\u0080\u0008¢\u0006\u0002\u0010'\u001a!\u0010(\u001a\u00020\u000b\"\u0004\u0008\u0000\u0010\u000c*\u0008\u0012\u0004\u0012\u0002H\u000c0\u00052\u0006\u0010!\u001a\u00020\u0003H\u0080\u0008\u001a0\u0010)\u001a\u0004\u0018\u0001H\u000c\"\u0004\u0008\u0000\u0010\u000c*\u0008\u0012\u0004\u0012\u0002H\u000c0\u00052\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u0002H\u000cH\u0080\u0008¢\u0006\u0002\u0010\u001a\u001a6\u0010)\u001a\u00020\u0013\"\u0004\u0008\u0000\u0010\u000c*\u0008\u0012\u0004\u0012\u0002H\u000c0\u00052\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010*\u001a\u0002H\u000c2\u0006\u0010+\u001a\u0002H\u000cH\u0080\u0008¢\u0006\u0002\u0010,\u001a.\u0010-\u001a\u00020\u000b\"\u0004\u0008\u0000\u0010\u000c*\u0008\u0012\u0004\u0012\u0002H\u000c0\u00052\u0006\u0010!\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u0002H\u000cH\u0080\u0008¢\u0006\u0002\u0010.\u001a\u0019\u0010/\u001a\u00020\u0003\"\u0004\u0008\u0000\u0010\u000c*\u0008\u0012\u0004\u0012\u0002H\u000c0\u0005H\u0080\u0008\u001a\u0019\u00100\u001a\u000201\"\u0004\u0008\u0000\u0010\u000c*\u0008\u0012\u0004\u0012\u0002H\u000c0\u0005H\u0080\u0008\u001a&\u00102\u001a\u0002H\u000c\"\u0004\u0008\u0000\u0010\u000c*\u0008\u0012\u0004\u0012\u0002H\u000c0\u00052\u0006\u0010!\u001a\u00020\u0003H\u0080\u0008¢\u0006\u0002\u00103\u001a!\u00104\u001a\u00020\u0013\"\u0004\u0008\u0000\u0010\u0004*\u0008\u0012\u0004\u0012\u0002H\u00040\u00052\u0006\u0010\r\u001a\u00020\u000eH\u0086\n\u001aT\u00105\u001a\u00020\u000b\"\u0004\u0008\u0000\u0010\u0004*\u0008\u0012\u0004\u0012\u0002H\u00040\u000526\u00106\u001a2\u0012\u0013\u0012\u00110\u000e¢\u0006\u000c\u00088\u0012\u0008\u00089\u0012\u0004\u0008\u0008(\r\u0012\u0013\u0012\u0011H\u0004¢\u0006\u000c\u00088\u0012\u0008\u00089\u0012\u0004\u0008\u0008(\u000f\u0012\u0004\u0012\u00020\u000b07H\u0086\u0008ø\u0001\u0000\u001a.\u0010:\u001a\u0002H\u0004\"\u0004\u0008\u0000\u0010\u0004*\u0008\u0012\u0004\u0012\u0002H\u00040\u00052\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0019\u001a\u0002H\u0004H\u0086\u0008¢\u0006\u0002\u0010\u001a\u001a7\u0010;\u001a\u0002H\u0004\"\u0004\u0008\u0000\u0010\u0004*\u0008\u0012\u0004\u0012\u0002H\u00040\u00052\u0006\u0010\r\u001a\u00020\u000e2\u000c\u0010\u0019\u001a\u0008\u0012\u0004\u0012\u0002H\u00040<H\u0086\u0008ø\u0001\u0000¢\u0006\u0002\u0010=\u001a\u0019\u0010>\u001a\u00020\u0013\"\u0004\u0008\u0000\u0010\u0004*\u0008\u0012\u0004\u0012\u0002H\u00040\u0005H\u0086\u0008\u001a\u0016\u0010?\u001a\u00020@\"\u0004\u0008\u0000\u0010\u0004*\u0008\u0012\u0004\u0012\u0002H\u00040\u0005\u001a-\u0010A\u001a\u0008\u0012\u0004\u0012\u0002H\u00040\u0005\"\u0004\u0008\u0000\u0010\u0004*\u0008\u0012\u0004\u0012\u0002H\u00040\u00052\u000c\u0010$\u001a\u0008\u0012\u0004\u0012\u0002H\u00040\u0005H\u0086\u0002\u001a-\u0010B\u001a\u00020\u0013\"\u0004\u0008\u0000\u0010\u0004*\u0008\u0012\u0004\u0012\u0002H\u00040\u00052\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u0002H\u0004H\u0007¢\u0006\u0002\u0010'\u001a.\u0010C\u001a\u00020\u000b\"\u0004\u0008\u0000\u0010\u0004*\u0008\u0012\u0004\u0012\u0002H\u00040\u00052\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u0002H\u0004H\u0086\n¢\u0006\u0002\u0010\u0010\u001a\u001c\u0010D\u001a\u0008\u0012\u0004\u0012\u0002H\u00040E\"\u0004\u0008\u0000\u0010\u0004*\u0008\u0012\u0004\u0012\u0002H\u00040\u0005\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"(\u0010\u0002\u001a\u00020\u0003\"\u0004\u0008\u0000\u0010\u0004*\u0008\u0012\u0004\u0012\u0002H\u00040\u00058Æ\u0002¢\u0006\u000c\u0012\u0004\u0008\u0006\u0010\u0007\u001a\u0004\u0008\u0008\u0010\t\u0082\u0002\u0007\n\u0005\u0008\u009920\u0001¨\u0006F", d2 = {"DELETED", "", "size", "", "T", "Landroidx/collection/LongSparseArray;", "getSize$annotations", "(Landroidx/collection/LongSparseArray;)V", "getSize", "(Landroidx/collection/LongSparseArray;)I", "commonAppend", "", "E", "key", "", "value", "(Landroidx/collection/LongSparseArray;JLjava/lang/Object;)V", "commonClear", "commonContainsKey", "", "commonContainsValue", "(Landroidx/collection/LongSparseArray;Ljava/lang/Object;)Z", "commonGc", "commonGet", "(Landroidx/collection/LongSparseArray;J)Ljava/lang/Object;", "defaultValue", "(Landroidx/collection/LongSparseArray;JLjava/lang/Object;)Ljava/lang/Object;", "commonGetInternal", "commonIndexOfKey", "commonIndexOfValue", "(Landroidx/collection/LongSparseArray;Ljava/lang/Object;)I", "commonIsEmpty", "commonKeyAt", "index", "commonPut", "commonPutAll", "other", "commonPutIfAbsent", "commonRemove", "(Landroidx/collection/LongSparseArray;JLjava/lang/Object;)Z", "commonRemoveAt", "commonReplace", "oldValue", "newValue", "(Landroidx/collection/LongSparseArray;JLjava/lang/Object;Ljava/lang/Object;)Z", "commonSetValueAt", "(Landroidx/collection/LongSparseArray;ILjava/lang/Object;)V", "commonSize", "commonToString", "", "commonValueAt", "(Landroidx/collection/LongSparseArray;I)Ljava/lang/Object;", "contains", "forEach", "action", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "getOrDefault", "getOrElse", "Lkotlin/Function0;", "(Landroidx/collection/LongSparseArray;JLkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "isNotEmpty", "keyIterator", "Lkotlin/collections/LongIterator;", "plus", "remove", "set", "valueIterator", "", "collection"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class LongSparseArrayKt {

    private static final Object DELETED;
    static {
        Object object = new Object();
        LongSparseArrayKt.DELETED = object;
    }

    public static final Object access$getDELETED$p() {
        return LongSparseArrayKt.DELETED;
    }

    public static final <E> void commonAppend(androidx.collection.LongSparseArray<E> $this$commonAppend, long key, E value) {
        int size;
        boolean garbage;
        int length;
        int idealLongArraySize;
        int copyOf;
        int newSize$iv;
        long[] keys;
        Object[] values;
        int i$iv2;
        int i$iv;
        Object obj2;
        Object obj;
        Intrinsics.checkNotNullParameter($this$commonAppend, "<this>");
        int i = 0;
        if ($this$commonAppend.size != 0 && Long.compare(key, l) <= 0) {
            if (Long.compare(key, l) <= 0) {
                $this$commonAppend.put(key, value);
            }
        }
        if ($this$commonAppend.garbage && $this$commonAppend.size >= keys3.length) {
            if ($this$commonAppend.size >= keys3.length) {
                garbage = $this$commonAppend;
                length = 0;
                newSize$iv = 0;
                keys = garbage.keys;
                values = garbage.values;
                i$iv2 = 0;
                while (i$iv2 < garbage.size) {
                    obj2 = values[i$iv2];
                    if (obj2 != LongSparseArrayKt.access$getDELETED$p() && i$iv2 != newSize$iv) {
                    }
                    i$iv2++;
                    if (i$iv2 != newSize$iv) {
                    }
                    newSize$iv++;
                    keys[newSize$iv] = keys[i$iv2];
                    values[newSize$iv] = obj2;
                    values[i$iv2] = 0;
                }
                garbage.garbage = false;
                garbage.size = newSize$iv;
            }
        }
        int $this$commonGc$iv = $this$commonAppend.size;
        if ($this$commonGc$iv >= keys4.length) {
            idealLongArraySize = ContainerHelpersKt.idealLongArraySize($this$commonGc$iv + 1);
            long[] copyOf2 = Arrays.copyOf($this$commonAppend.keys, idealLongArraySize);
            newSize$iv = "copyOf(this, newSize)";
            Intrinsics.checkNotNullExpressionValue(copyOf2, newSize$iv);
            $this$commonAppend.keys = copyOf2;
            copyOf = Arrays.copyOf($this$commonAppend.values, idealLongArraySize);
            Intrinsics.checkNotNullExpressionValue(copyOf, newSize$iv);
            $this$commonAppend.values = copyOf;
        }
        $this$commonAppend.keys[$this$commonGc$iv] = key;
        $this$commonAppend.values[$this$commonGc$iv] = obj14;
        $this$commonAppend.size = $this$commonGc$iv + 1;
    }

    public static final <E> void commonClear(androidx.collection.LongSparseArray<E> $this$commonClear) {
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

    public static final <E> boolean commonContainsKey(androidx.collection.LongSparseArray<E> $this$commonContainsKey, long key) {
        int i;
        Intrinsics.checkNotNullParameter($this$commonContainsKey, "<this>");
        int i2 = 0;
        i = $this$commonContainsKey.indexOfKey(key) >= 0 ? 1 : 0;
        return i;
    }

    public static final <E> boolean commonContainsValue(androidx.collection.LongSparseArray<E> $this$commonContainsValue, E value) {
        int i;
        Intrinsics.checkNotNullParameter($this$commonContainsValue, "<this>");
        int i2 = 0;
        i = $this$commonContainsValue.indexOfValue(value) >= 0 ? 1 : 0;
        return i;
    }

    public static final <E> void commonGc(androidx.collection.LongSparseArray<E> $this$commonGc) {
        int newSize;
        int i;
        Object obj2;
        Object obj;
        Intrinsics.checkNotNullParameter($this$commonGc, "<this>");
        int i2 = 0;
        newSize = 0;
        final long[] keys = $this$commonGc.keys;
        final Object[] values = $this$commonGc.values;
        i = 0;
        while (i < $this$commonGc.size) {
            obj2 = values[i];
            if (obj2 != LongSparseArrayKt.access$getDELETED$p() && i != newSize) {
            }
            i++;
            if (i != newSize) {
            }
            newSize++;
            keys[newSize] = keys[i];
            values[newSize] = obj2;
            values[i] = 0;
        }
        $this$commonGc.garbage = false;
        $this$commonGc.size = newSize;
    }

    public static final <E> E commonGet(androidx.collection.LongSparseArray<E> $this$commonGet, long key) {
        Object obj;
        int size;
        Object obj2;
        Intrinsics.checkNotNullParameter($this$commonGet, "<this>");
        int i = 0;
        final Object obj3 = $this$commonGet;
        final int i3 = 0;
        int binarySearch = ContainerHelpersKt.binarySearch(obj3.keys, obj3.size, key);
        if (binarySearch >= 0) {
            if (obj3.values[binarySearch] == LongSparseArrayKt.access$getDELETED$p()) {
                obj = i2;
            } else {
                obj = obj3.values[binarySearch];
            }
        } else {
        }
        return obj;
    }

    public static final <E> E commonGet(androidx.collection.LongSparseArray<E> $this$commonGet, long key, E defaultValue) {
        Object obj;
        int size;
        Object obj2;
        Intrinsics.checkNotNullParameter($this$commonGet, "<this>");
        int i = 0;
        final Object obj3 = $this$commonGet;
        final int i2 = 0;
        int binarySearch = ContainerHelpersKt.binarySearch(obj3.keys, obj3.size, key);
        if (binarySearch >= 0) {
            if (obj3.values[binarySearch] == LongSparseArrayKt.access$getDELETED$p()) {
                obj = obj9;
            } else {
                obj = obj3.values[binarySearch];
            }
        } else {
        }
        return obj;
    }

    public static final <T extends E, E> T commonGetInternal(androidx.collection.LongSparseArray<E> $this$commonGetInternal, long key, T defaultValue) {
        Object obj;
        int size;
        Object obj2;
        Intrinsics.checkNotNullParameter($this$commonGetInternal, "<this>");
        int i = 0;
        int binarySearch = ContainerHelpersKt.binarySearch($this$commonGetInternal.keys, $this$commonGetInternal.size, key);
        if (binarySearch >= 0) {
            if ($this$commonGetInternal.values[binarySearch] == LongSparseArrayKt.access$getDELETED$p()) {
                obj = obj7;
            } else {
                obj = $this$commonGetInternal.values[binarySearch];
            }
        } else {
        }
        return obj;
    }

    public static final <E> int commonIndexOfKey(androidx.collection.LongSparseArray<E> $this$commonIndexOfKey, long key) {
        boolean garbage;
        int i;
        int size;
        int newSize$iv;
        long[] keys;
        Object[] values;
        int i$iv;
        int i$iv2;
        Object obj2;
        Object obj;
        Intrinsics.checkNotNullParameter($this$commonIndexOfKey, "<this>");
        int i2 = 0;
        if ($this$commonIndexOfKey.garbage) {
            garbage = $this$commonIndexOfKey;
            i = 0;
            newSize$iv = 0;
            keys = garbage.keys;
            values = garbage.values;
            i$iv2 = 0;
            while (i$iv2 < garbage.size) {
                obj2 = values[i$iv2];
                if (obj2 != LongSparseArrayKt.access$getDELETED$p() && i$iv2 != newSize$iv) {
                }
                i$iv2++;
                if (i$iv2 != newSize$iv) {
                }
                newSize$iv++;
                keys[newSize$iv] = keys[i$iv2];
                values[newSize$iv] = obj2;
                values[i$iv2] = 0;
            }
            garbage.garbage = false;
            garbage.size = newSize$iv;
        }
        return ContainerHelpersKt.binarySearch($this$commonIndexOfKey.keys, $this$commonIndexOfKey.size, key);
    }

    public static final <E> int commonIndexOfValue(androidx.collection.LongSparseArray<E> $this$commonIndexOfValue, E value) {
        boolean garbage;
        int i2;
        int i;
        int size;
        int newSize$iv;
        long[] keys;
        Object[] values;
        int i$iv;
        Object obj;
        Object obj2;
        Intrinsics.checkNotNullParameter($this$commonIndexOfValue, "<this>");
        int i3 = 0;
        if ($this$commonIndexOfValue.garbage) {
            garbage = $this$commonIndexOfValue;
            i = 0;
            newSize$iv = 0;
            keys = garbage.keys;
            values = garbage.values;
            i$iv = 0;
            while (i$iv < garbage.size) {
                obj = values[i$iv];
                if (obj != LongSparseArrayKt.access$getDELETED$p() && i$iv != newSize$iv) {
                }
                i$iv++;
                if (i$iv != newSize$iv) {
                }
                newSize$iv++;
                keys[newSize$iv] = keys[i$iv];
                values[newSize$iv] = obj;
                values[i$iv] = 0;
            }
            garbage.garbage = false;
            garbage.size = newSize$iv;
        }
        while (i2 < $this$commonIndexOfValue.size) {
            i = i2;
            size = 0;
            i2++;
        }
        return -1;
    }

    public static final <E> boolean commonIsEmpty(androidx.collection.LongSparseArray<E> $this$commonIsEmpty) {
        int i;
        Intrinsics.checkNotNullParameter($this$commonIsEmpty, "<this>");
        int i2 = 0;
        i = $this$commonIsEmpty.size() == 0 ? 1 : 0;
        return i;
    }

    public static final <E> long commonKeyAt(androidx.collection.LongSparseArray<E> $this$commonKeyAt, int index) {
        int size2;
        int i2;
        boolean garbage;
        int i;
        int size;
        int newSize$iv;
        long[] keys;
        Object[] values;
        int i$iv;
        Object obj;
        Object obj2;
        Intrinsics.checkNotNullParameter($this$commonKeyAt, "<this>");
        int i3 = 0;
        int i4 = 0;
        if (index >= 0 && index < $this$commonKeyAt.size) {
            i2 = index < $this$commonKeyAt.size ? 1 : i4;
        } else {
        }
        if (i2 == 0) {
        } else {
            if ($this$commonKeyAt.garbage) {
                garbage = $this$commonKeyAt;
                i = 0;
                newSize$iv = 0;
                keys = garbage.keys;
                values = garbage.values;
                i$iv = 0;
                while (i$iv < garbage.size) {
                    obj = values[i$iv];
                    if (obj != LongSparseArrayKt.access$getDELETED$p() && i$iv != newSize$iv) {
                    }
                    i$iv++;
                    if (i$iv != newSize$iv) {
                    }
                    newSize$iv++;
                    keys[newSize$iv] = keys[i$iv];
                    values[newSize$iv] = obj;
                    values[i$iv] = 0;
                }
                garbage.garbage = i4;
                garbage.size = newSize$iv;
            }
            return $this$commonKeyAt.keys[index];
        }
        int i5 = 0;
        StringBuilder stringBuilder = new StringBuilder();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.append("Expected index to be within 0..size()-1, but was ").append(index).toString().toString());
        throw illegalArgumentException;
    }

    public static final <E> void commonPut(androidx.collection.LongSparseArray<E> $this$commonPut, long key, E value) {
        int index;
        Object[] values2;
        int size2;
        boolean binarySearch;
        int idealLongArraySize;
        int values3;
        int copyOf;
        int size;
        int newSize$iv;
        long[] keys;
        Object[] values;
        int i$iv;
        int i$iv2;
        Object obj2;
        Object obj;
        Intrinsics.checkNotNullParameter($this$commonPut, "<this>");
        int i = 0;
        index = ContainerHelpersKt.binarySearch($this$commonPut.keys, $this$commonPut.size, key);
        if (index >= 0) {
            $this$commonPut.values[index] = obj15;
        } else {
            index = ~index;
            if (index < $this$commonPut.size && $this$commonPut.values[index] == LongSparseArrayKt.access$getDELETED$p()) {
                if ($this$commonPut.values[index] == LongSparseArrayKt.access$getDELETED$p()) {
                    $this$commonPut.keys[index] = key;
                    $this$commonPut.values[index] = obj15;
                }
            }
            if ($this$commonPut.garbage && $this$commonPut.size >= keys6.length) {
                if ($this$commonPut.size >= keys6.length) {
                    Object obj3 = $this$commonPut;
                    int i3 = 0;
                    newSize$iv = 0;
                    keys = obj3.keys;
                    values = obj3.values;
                    i$iv2 = 0;
                    while (i$iv2 < obj3.size) {
                        obj2 = values[i$iv2];
                        if (obj2 != LongSparseArrayKt.access$getDELETED$p() && i$iv2 != newSize$iv) {
                        }
                        i$iv2++;
                        if (i$iv2 != newSize$iv) {
                        }
                        newSize$iv++;
                        keys[newSize$iv] = keys[i$iv2];
                        values[newSize$iv] = obj2;
                        values[i$iv2] = 0;
                    }
                    obj3.garbage = false;
                    obj3.size = newSize$iv;
                    index = ~binarySearch;
                }
            }
            if ($this$commonPut.size >= keys7.length) {
                idealLongArraySize = ContainerHelpersKt.idealLongArraySize(size5++);
                long[] copyOf2 = Arrays.copyOf($this$commonPut.keys, idealLongArraySize);
                size = "copyOf(this, newSize)";
                Intrinsics.checkNotNullExpressionValue(copyOf2, size);
                $this$commonPut.keys = copyOf2;
                copyOf = Arrays.copyOf($this$commonPut.values, idealLongArraySize);
                Intrinsics.checkNotNullExpressionValue(copyOf, size);
                $this$commonPut.values = copyOf;
            }
            if (newSize -= index != 0) {
                ArraysKt.copyInto($this$commonPut.keys, $this$commonPut.keys, index + 1, index, $this$commonPut.size);
                ArraysKt.copyInto($this$commonPut.values, $this$commonPut.values, index + 1, index, $this$commonPut.size);
            }
            $this$commonPut.keys[index] = key;
            $this$commonPut.values[index] = obj15;
            $this$commonPut.size = size4++;
        }
    }

    public static final <E> void commonPutAll(androidx.collection.LongSparseArray<E> $this$commonPutAll, androidx.collection.LongSparseArray<? extends E> other) {
        int i3;
        int i2;
        int i;
        long keyAt;
        Object valueAt;
        Intrinsics.checkNotNullParameter($this$commonPutAll, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        int i4 = 0;
        i3 = 0;
        while (i3 < other.size()) {
            i2 = i3;
            i = 0;
            $this$commonPutAll.put(other.keyAt(i2), obj6);
            i3++;
        }
    }

    public static final <E> E commonPutIfAbsent(androidx.collection.LongSparseArray<E> $this$commonPutIfAbsent, long key, E value) {
        Intrinsics.checkNotNullParameter($this$commonPutIfAbsent, "<this>");
        int i = 0;
        final Object obj = $this$commonPutIfAbsent.get(key);
        if (obj == null) {
            $this$commonPutIfAbsent.put(key, value);
        }
        return obj;
    }

    public static final <E> void commonRemove(androidx.collection.LongSparseArray<E> $this$commonRemove, long key) {
        int size;
        Object obj;
        Intrinsics.checkNotNullParameter($this$commonRemove, "<this>");
        int i = 0;
        int binarySearch = ContainerHelpersKt.binarySearch($this$commonRemove.keys, $this$commonRemove.size, key);
        if (binarySearch >= 0 && $this$commonRemove.values[binarySearch] != LongSparseArrayKt.access$getDELETED$p()) {
            if ($this$commonRemove.values[binarySearch] != LongSparseArrayKt.access$getDELETED$p()) {
                $this$commonRemove.values[binarySearch] = LongSparseArrayKt.access$getDELETED$p();
                $this$commonRemove.garbage = true;
            }
        }
    }

    public static final <E> boolean commonRemove(androidx.collection.LongSparseArray<E> $this$commonRemove, long key, E value) {
        Object valueAt;
        boolean equal;
        Intrinsics.checkNotNullParameter($this$commonRemove, "<this>");
        int i = 0;
        final int indexOfKey = $this$commonRemove.indexOfKey(key);
        if (indexOfKey >= 0 && Intrinsics.areEqual(obj7, $this$commonRemove.valueAt(indexOfKey))) {
            if (Intrinsics.areEqual(obj7, $this$commonRemove.valueAt(indexOfKey))) {
                $this$commonRemove.removeAt(indexOfKey);
                return 1;
            }
        }
        return 0;
    }

    public static final <E> void commonRemoveAt(androidx.collection.LongSparseArray<E> $this$commonRemoveAt, int index) {
        Object obj2;
        Object obj;
        Intrinsics.checkNotNullParameter($this$commonRemoveAt, "<this>");
        int i = 0;
        if ($this$commonRemoveAt.values[index] != LongSparseArrayKt.access$getDELETED$p()) {
            $this$commonRemoveAt.values[index] = LongSparseArrayKt.access$getDELETED$p();
            $this$commonRemoveAt.garbage = true;
        }
    }

    public static final <E> E commonReplace(androidx.collection.LongSparseArray<E> $this$commonReplace, long key, E value) {
        Intrinsics.checkNotNullParameter($this$commonReplace, "<this>");
        int i = 0;
        final int indexOfKey = $this$commonReplace.indexOfKey(key);
        if (indexOfKey >= 0) {
            $this$commonReplace.values[indexOfKey] = obj7;
            return $this$commonReplace.values[indexOfKey];
        }
        return 0;
    }

    public static final <E> boolean commonReplace(androidx.collection.LongSparseArray<E> $this$commonReplace, long key, E oldValue, E newValue) {
        Object obj;
        boolean equal;
        Intrinsics.checkNotNullParameter($this$commonReplace, "<this>");
        int i = 0;
        final int indexOfKey = $this$commonReplace.indexOfKey(key);
        if (indexOfKey >= 0 && Intrinsics.areEqual($this$commonReplace.values[indexOfKey], newValue)) {
            if (Intrinsics.areEqual($this$commonReplace.values[indexOfKey], newValue)) {
                $this$commonReplace.values[indexOfKey] = obj8;
                return 1;
            }
        }
        return 0;
    }

    public static final <E> void commonSetValueAt(androidx.collection.LongSparseArray<E> $this$commonSetValueAt, int index, E value) {
        int size2;
        int i;
        boolean garbage;
        int i2;
        int size;
        int newSize$iv;
        long[] keys;
        Object[] values;
        int i$iv;
        Object obj2;
        Object obj;
        Intrinsics.checkNotNullParameter($this$commonSetValueAt, "<this>");
        int i3 = 0;
        int i4 = 0;
        if (index >= 0 && index < $this$commonSetValueAt.size) {
            i = index < $this$commonSetValueAt.size ? 1 : i4;
        } else {
        }
        if (i == 0) {
        } else {
            if ($this$commonSetValueAt.garbage) {
                garbage = $this$commonSetValueAt;
                i2 = 0;
                newSize$iv = 0;
                keys = garbage.keys;
                values = garbage.values;
                i$iv = 0;
                while (i$iv < garbage.size) {
                    obj2 = values[i$iv];
                    if (obj2 != LongSparseArrayKt.access$getDELETED$p() && i$iv != newSize$iv) {
                    }
                    i$iv++;
                    if (i$iv != newSize$iv) {
                    }
                    newSize$iv++;
                    keys[newSize$iv] = keys[i$iv];
                    values[newSize$iv] = obj2;
                    values[i$iv] = 0;
                }
                garbage.garbage = i4;
                garbage.size = newSize$iv;
            }
            $this$commonSetValueAt.values[index] = value;
        }
        int i5 = 0;
        StringBuilder stringBuilder = new StringBuilder();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.append("Expected index to be within 0..size()-1, but was ").append(index).toString().toString());
        throw illegalArgumentException;
    }

    public static final <E> int commonSize(androidx.collection.LongSparseArray<E> $this$commonSize) {
        boolean garbage;
        int i;
        int size;
        int newSize$iv;
        long[] keys;
        Object[] values;
        int i$iv;
        int i$iv2;
        Object obj;
        Object obj2;
        Intrinsics.checkNotNullParameter($this$commonSize, "<this>");
        int i2 = 0;
        if ($this$commonSize.garbage) {
            garbage = $this$commonSize;
            i = 0;
            newSize$iv = 0;
            keys = garbage.keys;
            values = garbage.values;
            i$iv2 = 0;
            while (i$iv2 < garbage.size) {
                obj = values[i$iv2];
                if (obj != LongSparseArrayKt.access$getDELETED$p() && i$iv2 != newSize$iv) {
                }
                i$iv2++;
                if (i$iv2 != newSize$iv) {
                }
                newSize$iv++;
                keys[newSize$iv] = keys[i$iv2];
                values[newSize$iv] = obj;
                values[i$iv2] = 0;
            }
            garbage.garbage = false;
            garbage.size = newSize$iv;
        }
        return $this$commonSize.size;
    }

    public static final <E> String commonToString(androidx.collection.LongSparseArray<E> $this$commonToString) {
        int i;
        long keyAt;
        Object valueAt;
        String str;
        Intrinsics.checkNotNullParameter($this$commonToString, "<this>");
        int i2 = 0;
        if ($this$commonToString.size() <= 0) {
            return "{}";
        }
        StringBuilder stringBuilder = new StringBuilder(size2 *= 28);
        StringBuilder sb = stringBuilder;
        final int i4 = 0;
        sb.append('{');
        i = 0;
        while (i < $this$commonToString.size) {
            if (i > 0) {
            }
            sb.append($this$commonToString.keyAt(i));
            sb.append('=');
            valueAt = $this$commonToString.valueAt(i);
            if (valueAt != sb) {
            } else {
            }
            sb.append("(this Map)");
            i++;
            sb.append(valueAt);
            sb.append(", ");
        }
        sb.append('}');
        String string = stringBuilder.toString();
        Intrinsics.checkNotNullExpressionValue(string, "StringBuilder(capacity).…builderAction).toString()");
        return string;
    }

    public static final <E> E commonValueAt(androidx.collection.LongSparseArray<E> $this$commonValueAt, int index) {
        int size;
        int i2;
        boolean garbage;
        int i;
        int size2;
        int newSize$iv;
        long[] keys;
        Object[] values;
        int i$iv;
        Object obj2;
        Object obj;
        Intrinsics.checkNotNullParameter($this$commonValueAt, "<this>");
        int i3 = 0;
        int i4 = 0;
        if (index >= 0 && index < $this$commonValueAt.size) {
            i2 = index < $this$commonValueAt.size ? 1 : i4;
        } else {
        }
        if (i2 == 0) {
        } else {
            if ($this$commonValueAt.garbage) {
                garbage = $this$commonValueAt;
                i = 0;
                newSize$iv = 0;
                keys = garbage.keys;
                values = garbage.values;
                i$iv = 0;
                while (i$iv < garbage.size) {
                    obj2 = values[i$iv];
                    if (obj2 != LongSparseArrayKt.access$getDELETED$p() && i$iv != newSize$iv) {
                    }
                    i$iv++;
                    if (i$iv != newSize$iv) {
                    }
                    newSize$iv++;
                    keys[newSize$iv] = keys[i$iv];
                    values[newSize$iv] = obj2;
                    values[i$iv] = 0;
                }
                garbage.garbage = i4;
                garbage.size = newSize$iv;
            }
            return $this$commonValueAt.values[index];
        }
        int i5 = 0;
        StringBuilder stringBuilder = new StringBuilder();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.append("Expected index to be within 0..size()-1, but was ").append(index).toString().toString());
        throw illegalArgumentException;
    }

    public static final <T> boolean contains(androidx.collection.LongSparseArray<T> $this$contains, long key) {
        Intrinsics.checkNotNullParameter($this$contains, "<this>");
        int i = 0;
        return $this$contains.containsKey(key);
    }

    public static final <T> void forEach(androidx.collection.LongSparseArray<T> $this$forEach, Function2<? super Long, ? super T, Unit> action) {
        int index;
        Long valueOf;
        long valueAt;
        Intrinsics.checkNotNullParameter($this$forEach, "<this>");
        Intrinsics.checkNotNullParameter(action, "action");
        int i = 0;
        index = 0;
        while (index < $this$forEach.size()) {
            action.invoke(Long.valueOf($this$forEach.keyAt(index)), $this$forEach.valueAt(index));
            index++;
        }
    }

    public static final <T> T getOrDefault(androidx.collection.LongSparseArray<T> $this$getOrDefault, long key, T defaultValue) {
        Intrinsics.checkNotNullParameter($this$getOrDefault, "<this>");
        int i = 0;
        return $this$getOrDefault.get(key, defaultValue);
    }

    public static final <T> T getOrElse(androidx.collection.LongSparseArray<T> $this$getOrElse, long key, Function0<? extends T> defaultValue) {
        Object invoke;
        Intrinsics.checkNotNullParameter($this$getOrElse, "<this>");
        Intrinsics.checkNotNullParameter(obj5, "defaultValue");
        int i = 0;
        if ($this$getOrElse.get(key) == null) {
            invoke = obj5.invoke();
        }
        return invoke;
    }

    public static final <T> int getSize(androidx.collection.LongSparseArray<T> $this$size) {
        Intrinsics.checkNotNullParameter($this$size, "<this>");
        int i = 0;
        return $this$size.size();
    }

    public static void getSize$annotations(androidx.collection.LongSparseArray longSparseArray) {
    }

    public static final <T> boolean isNotEmpty(androidx.collection.LongSparseArray<T> $this$isNotEmpty) {
        Intrinsics.checkNotNullParameter($this$isNotEmpty, "<this>");
        int i = 0;
        return empty ^= 1;
    }

    public static final <T> LongIterator keyIterator(androidx.collection.LongSparseArray<T> $this$keyIterator) {
        Intrinsics.checkNotNullParameter($this$keyIterator, "<this>");
        LongSparseArrayKt.keyIterator.1 anon = new LongSparseArrayKt.keyIterator.1($this$keyIterator);
        return (LongIterator)anon;
    }

    public static final <T> androidx.collection.LongSparseArray<T> plus(androidx.collection.LongSparseArray<T> $this$plus, androidx.collection.LongSparseArray<T> other) {
        Intrinsics.checkNotNullParameter($this$plus, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        LongSparseArray longSparseArray = new LongSparseArray(size += size2);
        longSparseArray.putAll($this$plus);
        longSparseArray.putAll(other);
        return longSparseArray;
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Replaced with member function. Remove extension import!")
    public static final boolean remove(androidx.collection.LongSparseArray $this$remove, long key, Object value) {
        Intrinsics.checkNotNullParameter($this$remove, "<this>");
        return $this$remove.remove(key, value);
    }

    public static final <T> void set(androidx.collection.LongSparseArray<T> $this$set, long key, T value) {
        Intrinsics.checkNotNullParameter($this$set, "<this>");
        int i = 0;
        $this$set.put(key, value);
    }

    public static final <T> Iterator<T> valueIterator(androidx.collection.LongSparseArray<T> $this$valueIterator) {
        Intrinsics.checkNotNullParameter($this$valueIterator, "<this>");
        LongSparseArrayKt.valueIterator.1 anon = new LongSparseArrayKt.valueIterator.1($this$valueIterator);
        return (Iterator)anon;
    }
}
