package androidx.collection;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\t\n\u0002\u0008\u0015\u001a\u0012\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u0002H\u00050\u0004\"\u0004\u0008\u0000\u0010\u0005\u001a\u0012\u0010\u0006\u001a\u0008\u0012\u0004\u0012\u0002H\u00050\u0004\"\u0004\u0008\u0000\u0010\u0005\u001a'\u0010\u0006\u001a\u0008\u0012\u0004\u0012\u0002H\u00050\u0004\"\u0004\u0008\u0000\u0010\u00052\u0006\u0010\u0007\u001a\u00020\u00082\u0006\u0010\t\u001a\u0002H\u0005¢\u0006\u0002\u0010\n\u001a7\u0010\u0006\u001a\u0008\u0012\u0004\u0012\u0002H\u00050\u0004\"\u0004\u0008\u0000\u0010\u00052\u0006\u0010\u0007\u001a\u00020\u00082\u0006\u0010\t\u001a\u0002H\u00052\u0006\u0010\u000b\u001a\u00020\u00082\u0006\u0010\u000c\u001a\u0002H\u0005¢\u0006\u0002\u0010\r\u001aG\u0010\u0006\u001a\u0008\u0012\u0004\u0012\u0002H\u00050\u0004\"\u0004\u0008\u0000\u0010\u00052\u0006\u0010\u0007\u001a\u00020\u00082\u0006\u0010\t\u001a\u0002H\u00052\u0006\u0010\u000b\u001a\u00020\u00082\u0006\u0010\u000c\u001a\u0002H\u00052\u0006\u0010\u000e\u001a\u00020\u00082\u0006\u0010\u000f\u001a\u0002H\u0005¢\u0006\u0002\u0010\u0010\u001aW\u0010\u0006\u001a\u0008\u0012\u0004\u0012\u0002H\u00050\u0004\"\u0004\u0008\u0000\u0010\u00052\u0006\u0010\u0007\u001a\u00020\u00082\u0006\u0010\t\u001a\u0002H\u00052\u0006\u0010\u000b\u001a\u00020\u00082\u0006\u0010\u000c\u001a\u0002H\u00052\u0006\u0010\u000e\u001a\u00020\u00082\u0006\u0010\u000f\u001a\u0002H\u00052\u0006\u0010\u0011\u001a\u00020\u00082\u0006\u0010\u0012\u001a\u0002H\u0005¢\u0006\u0002\u0010\u0013\u001ag\u0010\u0006\u001a\u0008\u0012\u0004\u0012\u0002H\u00050\u0004\"\u0004\u0008\u0000\u0010\u00052\u0006\u0010\u0007\u001a\u00020\u00082\u0006\u0010\t\u001a\u0002H\u00052\u0006\u0010\u000b\u001a\u00020\u00082\u0006\u0010\u000c\u001a\u0002H\u00052\u0006\u0010\u000e\u001a\u00020\u00082\u0006\u0010\u000f\u001a\u0002H\u00052\u0006\u0010\u0011\u001a\u00020\u00082\u0006\u0010\u0012\u001a\u0002H\u00052\u0006\u0010\u0014\u001a\u00020\u00082\u0006\u0010\u0015\u001a\u0002H\u0005¢\u0006\u0002\u0010\u0016\u001a\u0012\u0010\u0017\u001a\u0008\u0012\u0004\u0012\u0002H\u00050\u0001\"\u0004\u0008\u0000\u0010\u0005\u001a'\u0010\u0017\u001a\u0008\u0012\u0004\u0012\u0002H\u00050\u0001\"\u0004\u0008\u0000\u0010\u00052\u0006\u0010\u0007\u001a\u00020\u00082\u0006\u0010\t\u001a\u0002H\u0005¢\u0006\u0002\u0010\u0018\u001a7\u0010\u0017\u001a\u0008\u0012\u0004\u0012\u0002H\u00050\u0001\"\u0004\u0008\u0000\u0010\u00052\u0006\u0010\u0007\u001a\u00020\u00082\u0006\u0010\t\u001a\u0002H\u00052\u0006\u0010\u000b\u001a\u00020\u00082\u0006\u0010\u000c\u001a\u0002H\u0005¢\u0006\u0002\u0010\u0019\u001aG\u0010\u0017\u001a\u0008\u0012\u0004\u0012\u0002H\u00050\u0001\"\u0004\u0008\u0000\u0010\u00052\u0006\u0010\u0007\u001a\u00020\u00082\u0006\u0010\t\u001a\u0002H\u00052\u0006\u0010\u000b\u001a\u00020\u00082\u0006\u0010\u000c\u001a\u0002H\u00052\u0006\u0010\u000e\u001a\u00020\u00082\u0006\u0010\u000f\u001a\u0002H\u0005¢\u0006\u0002\u0010\u001a\u001aW\u0010\u0017\u001a\u0008\u0012\u0004\u0012\u0002H\u00050\u0001\"\u0004\u0008\u0000\u0010\u00052\u0006\u0010\u0007\u001a\u00020\u00082\u0006\u0010\t\u001a\u0002H\u00052\u0006\u0010\u000b\u001a\u00020\u00082\u0006\u0010\u000c\u001a\u0002H\u00052\u0006\u0010\u000e\u001a\u00020\u00082\u0006\u0010\u000f\u001a\u0002H\u00052\u0006\u0010\u0011\u001a\u00020\u00082\u0006\u0010\u0012\u001a\u0002H\u0005¢\u0006\u0002\u0010\u001b\u001ag\u0010\u0017\u001a\u0008\u0012\u0004\u0012\u0002H\u00050\u0001\"\u0004\u0008\u0000\u0010\u00052\u0006\u0010\u0007\u001a\u00020\u00082\u0006\u0010\t\u001a\u0002H\u00052\u0006\u0010\u000b\u001a\u00020\u00082\u0006\u0010\u000c\u001a\u0002H\u00052\u0006\u0010\u000e\u001a\u00020\u00082\u0006\u0010\u000f\u001a\u0002H\u00052\u0006\u0010\u0011\u001a\u00020\u00082\u0006\u0010\u0012\u001a\u0002H\u00052\u0006\u0010\u0014\u001a\u00020\u00082\u0006\u0010\u0015\u001a\u0002H\u0005¢\u0006\u0002\u0010\u001c\"\u0014\u0010\u0000\u001a\u0008\u0012\u0004\u0012\u00020\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d", d2 = {"EmptyLongObjectMap", "Landroidx/collection/MutableLongObjectMap;", "", "emptyLongObjectMap", "Landroidx/collection/LongObjectMap;", "V", "longObjectMapOf", "key1", "", "value1", "(JLjava/lang/Object;)Landroidx/collection/LongObjectMap;", "key2", "value2", "(JLjava/lang/Object;JLjava/lang/Object;)Landroidx/collection/LongObjectMap;", "key3", "value3", "(JLjava/lang/Object;JLjava/lang/Object;JLjava/lang/Object;)Landroidx/collection/LongObjectMap;", "key4", "value4", "(JLjava/lang/Object;JLjava/lang/Object;JLjava/lang/Object;JLjava/lang/Object;)Landroidx/collection/LongObjectMap;", "key5", "value5", "(JLjava/lang/Object;JLjava/lang/Object;JLjava/lang/Object;JLjava/lang/Object;JLjava/lang/Object;)Landroidx/collection/LongObjectMap;", "mutableLongObjectMapOf", "(JLjava/lang/Object;)Landroidx/collection/MutableLongObjectMap;", "(JLjava/lang/Object;JLjava/lang/Object;)Landroidx/collection/MutableLongObjectMap;", "(JLjava/lang/Object;JLjava/lang/Object;JLjava/lang/Object;)Landroidx/collection/MutableLongObjectMap;", "(JLjava/lang/Object;JLjava/lang/Object;JLjava/lang/Object;JLjava/lang/Object;)Landroidx/collection/MutableLongObjectMap;", "(JLjava/lang/Object;JLjava/lang/Object;JLjava/lang/Object;JLjava/lang/Object;JLjava/lang/Object;)Landroidx/collection/MutableLongObjectMap;", "collection"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class LongObjectMapKt {

    private static final androidx.collection.MutableLongObjectMap EmptyLongObjectMap;
    static {
        MutableLongObjectMap mutableLongObjectMap = new MutableLongObjectMap(0);
        LongObjectMapKt.EmptyLongObjectMap = mutableLongObjectMap;
    }

    public static final <V> androidx.collection.LongObjectMap<V> emptyLongObjectMap() {
        final androidx.collection.MutableLongObjectMap emptyLongObjectMap = LongObjectMapKt.EmptyLongObjectMap;
        Intrinsics.checkNotNull(emptyLongObjectMap, "null cannot be cast to non-null type androidx.collection.LongObjectMap<V of androidx.collection.LongObjectMapKt.emptyLongObjectMap>");
        return (LongObjectMap)emptyLongObjectMap;
    }

    public static final <V> androidx.collection.LongObjectMap<V> longObjectMapOf() {
        final androidx.collection.MutableLongObjectMap emptyLongObjectMap = LongObjectMapKt.EmptyLongObjectMap;
        Intrinsics.checkNotNull(emptyLongObjectMap, "null cannot be cast to non-null type androidx.collection.LongObjectMap<V of androidx.collection.LongObjectMapKt.longObjectMapOf>");
        return (LongObjectMap)emptyLongObjectMap;
    }

    public static final <V> androidx.collection.LongObjectMap<V> longObjectMapOf(long key1, V value1) {
        MutableLongObjectMap mutableLongObjectMap = new MutableLongObjectMap(0, 1, 0);
        int i3 = 0;
        mutableLongObjectMap.set(key1, value1);
        return (LongObjectMap)mutableLongObjectMap;
    }

    public static final <V> androidx.collection.LongObjectMap<V> longObjectMapOf(long key1, V value1, long key2, V value2) {
        MutableLongObjectMap mutableLongObjectMap = new MutableLongObjectMap(0, 1, 0);
        androidx.collection.MutableLongObjectMap num = mutableLongObjectMap;
        int i3 = 0;
        num.set(key1, value1);
        num.set(value2, obj8);
        return (LongObjectMap)mutableLongObjectMap;
    }

    public static final <V> androidx.collection.LongObjectMap<V> longObjectMapOf(long key1, V value1, long key2, V value2, long key3, V value3) {
        MutableLongObjectMap mutableLongObjectMap = new MutableLongObjectMap(0, 1, 0);
        androidx.collection.MutableLongObjectMap num = mutableLongObjectMap;
        int i3 = 0;
        num.set(key1, value1);
        num.set(value2, key3);
        num.set(obj10, obj11);
        return (LongObjectMap)mutableLongObjectMap;
    }

    public static final <V> androidx.collection.LongObjectMap<V> longObjectMapOf(long key1, V value1, long key2, V value2, long key3, V value3, long key4, V value4) {
        MutableLongObjectMap mutableLongObjectMap = new MutableLongObjectMap(0, 1, 0);
        androidx.collection.MutableLongObjectMap num = mutableLongObjectMap;
        int i3 = 0;
        num.set(key1, value1);
        num.set(value2, key3);
        num.set(key4, value4);
        num.set(obj13, obj14);
        return (LongObjectMap)mutableLongObjectMap;
    }

    public static final <V> androidx.collection.LongObjectMap<V> longObjectMapOf(long key1, V value1, long key2, V value2, long key3, V value3, long key4, V value4, long key5, V value5) {
        MutableLongObjectMap mutableLongObjectMap = new MutableLongObjectMap(0, 1, 0);
        androidx.collection.MutableLongObjectMap num = mutableLongObjectMap;
        long l = key1;
        num.set(l, obj4);
        num.set(value2, obj7);
        num.set(key4, obj10);
        num.set(value5, obj13);
        final int i5 = i3;
        num.set(obj28, l);
        return (LongObjectMap)mutableLongObjectMap;
    }

    public static final <V> androidx.collection.MutableLongObjectMap<V> mutableLongObjectMapOf() {
        MutableLongObjectMap mutableLongObjectMap = new MutableLongObjectMap(0, 1, 0);
        return mutableLongObjectMap;
    }

    public static final <V> androidx.collection.MutableLongObjectMap<V> mutableLongObjectMapOf(long key1, V value1) {
        MutableLongObjectMap mutableLongObjectMap = new MutableLongObjectMap(0, 1, 0);
        int i3 = 0;
        mutableLongObjectMap.set(key1, value1);
        return mutableLongObjectMap;
    }

    public static final <V> androidx.collection.MutableLongObjectMap<V> mutableLongObjectMapOf(long key1, V value1, long key2, V value2) {
        MutableLongObjectMap mutableLongObjectMap = new MutableLongObjectMap(0, 1, 0);
        androidx.collection.MutableLongObjectMap num = mutableLongObjectMap;
        int i3 = 0;
        num.set(key1, value1);
        num.set(value2, obj8);
        return mutableLongObjectMap;
    }

    public static final <V> androidx.collection.MutableLongObjectMap<V> mutableLongObjectMapOf(long key1, V value1, long key2, V value2, long key3, V value3) {
        MutableLongObjectMap mutableLongObjectMap = new MutableLongObjectMap(0, 1, 0);
        androidx.collection.MutableLongObjectMap num = mutableLongObjectMap;
        int i3 = 0;
        num.set(key1, value1);
        num.set(value2, key3);
        num.set(obj10, obj11);
        return mutableLongObjectMap;
    }

    public static final <V> androidx.collection.MutableLongObjectMap<V> mutableLongObjectMapOf(long key1, V value1, long key2, V value2, long key3, V value3, long key4, V value4) {
        MutableLongObjectMap mutableLongObjectMap = new MutableLongObjectMap(0, 1, 0);
        androidx.collection.MutableLongObjectMap num = mutableLongObjectMap;
        int i3 = 0;
        num.set(key1, value1);
        num.set(value2, key3);
        num.set(key4, value4);
        num.set(obj13, obj14);
        return mutableLongObjectMap;
    }

    public static final <V> androidx.collection.MutableLongObjectMap<V> mutableLongObjectMapOf(long key1, V value1, long key2, V value2, long key3, V value3, long key4, V value4, long key5, V value5) {
        MutableLongObjectMap mutableLongObjectMap = new MutableLongObjectMap(0, 1, 0);
        androidx.collection.MutableLongObjectMap num = mutableLongObjectMap;
        long l = key1;
        num.set(l, obj4);
        num.set(value2, obj7);
        num.set(key4, obj10);
        num.set(value5, obj13);
        final int i5 = i3;
        num.set(obj28, l);
        return mutableLongObjectMap;
    }
}
