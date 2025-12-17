package androidx.collection;

import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\t\n\u0002\u0008\u000b\u001a\u0006\u0010\u0002\u001a\u00020\u0003\u001a\u0006\u0010\u0004\u001a\u00020\u0003\u001a\u0016\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006\u001a&\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0008\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0006\u001a6\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0008\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0006\u001aF\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0008\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u000c\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u0006\u001aV\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0008\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u000c\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0006\u001a\u0006\u0010\u0010\u001a\u00020\u0001\u001a\u0016\u0010\u0010\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006\u001a&\u0010\u0010\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0008\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0006\u001a6\u0010\u0010\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0008\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0006\u001aF\u0010\u0010\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0008\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u000c\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u0006\u001aV\u0010\u0010\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0008\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u000c\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0006\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011", d2 = {"EmptyLongLongMap", "Landroidx/collection/MutableLongLongMap;", "emptyLongLongMap", "Landroidx/collection/LongLongMap;", "longLongMapOf", "key1", "", "value1", "key2", "value2", "key3", "value3", "key4", "value4", "key5", "value5", "mutableLongLongMapOf", "collection"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class LongLongMapKt {

    private static final androidx.collection.MutableLongLongMap EmptyLongLongMap;
    static {
        MutableLongLongMap mutableLongLongMap = new MutableLongLongMap(0);
        LongLongMapKt.EmptyLongLongMap = mutableLongLongMap;
    }

    public static final androidx.collection.LongLongMap emptyLongLongMap() {
        return (LongLongMap)LongLongMapKt.EmptyLongLongMap;
    }

    public static final androidx.collection.LongLongMap longLongMapOf() {
        return (LongLongMap)LongLongMapKt.EmptyLongLongMap;
    }

    public static final androidx.collection.LongLongMap longLongMapOf(long key1, long value1) {
        MutableLongLongMap mutableLongLongMap = new MutableLongLongMap(0, 1, 0);
        int i3 = 0;
        mutableLongLongMap.set(key1, value1);
        return (LongLongMap)mutableLongLongMap;
    }

    public static final androidx.collection.LongLongMap longLongMapOf(long key1, long value1, long key2, long value2) {
        MutableLongLongMap mutableLongLongMap = new MutableLongLongMap(0, 1, 0);
        androidx.collection.MutableLongLongMap num = mutableLongLongMap;
        int i3 = 0;
        num.set(key1, value1);
        num.set(obj8, obj9);
        return (LongLongMap)mutableLongLongMap;
    }

    public static final androidx.collection.LongLongMap longLongMapOf(long key1, long value1, long key2, long value2, long key3, long value3) {
        MutableLongLongMap mutableLongLongMap = new MutableLongLongMap(0, 1, 0);
        androidx.collection.MutableLongLongMap num = mutableLongLongMap;
        int i3 = 0;
        num.set(key1, value1);
        num.set(key3, value3);
        num.set(obj12, obj13);
        return (LongLongMap)mutableLongLongMap;
    }

    public static final androidx.collection.LongLongMap longLongMapOf(long key1, long value1, long key2, long value2, long key3, long value3, long key4, long value4) {
        MutableLongLongMap mutableLongLongMap = new MutableLongLongMap(0, 1, 0);
        androidx.collection.MutableLongLongMap num = mutableLongLongMap;
        long l2 = key1;
        final Object obj2 = key2;
        num.set(l2, obj4);
        num.set(key3, obj8);
        num.set(obj24, obj12);
        final int i5 = i3;
        num.set(obj28, l2);
        return (LongLongMap)mutableLongLongMap;
    }

    public static final androidx.collection.LongLongMap longLongMapOf(long key1, long value1, long key2, long value2, long key3, long value3, long key4, long value4, long key5, long value5) {
        MutableLongLongMap mutableLongLongMap = new MutableLongLongMap(0, 1, 0);
        androidx.collection.MutableLongLongMap num = mutableLongLongMap;
        long l3 = key1;
        final Object obj3 = key2;
        num.set(l3, obj4);
        num.set(key3, obj8);
        num.set(key5, obj12);
        final int i5 = i3;
        num.set(obj28, l3);
        num.set(obj32, l3);
        return (LongLongMap)mutableLongLongMap;
    }

    public static final androidx.collection.MutableLongLongMap mutableLongLongMapOf() {
        MutableLongLongMap mutableLongLongMap = new MutableLongLongMap(0, 1, 0);
        return mutableLongLongMap;
    }

    public static final androidx.collection.MutableLongLongMap mutableLongLongMapOf(long key1, long value1) {
        MutableLongLongMap mutableLongLongMap = new MutableLongLongMap(0, 1, 0);
        int i3 = 0;
        mutableLongLongMap.set(key1, value1);
        return mutableLongLongMap;
    }

    public static final androidx.collection.MutableLongLongMap mutableLongLongMapOf(long key1, long value1, long key2, long value2) {
        MutableLongLongMap mutableLongLongMap = new MutableLongLongMap(0, 1, 0);
        androidx.collection.MutableLongLongMap num = mutableLongLongMap;
        int i3 = 0;
        num.set(key1, value1);
        num.set(obj8, obj9);
        return mutableLongLongMap;
    }

    public static final androidx.collection.MutableLongLongMap mutableLongLongMapOf(long key1, long value1, long key2, long value2, long key3, long value3) {
        MutableLongLongMap mutableLongLongMap = new MutableLongLongMap(0, 1, 0);
        androidx.collection.MutableLongLongMap num = mutableLongLongMap;
        int i3 = 0;
        num.set(key1, value1);
        num.set(key3, value3);
        num.set(obj12, obj13);
        return mutableLongLongMap;
    }

    public static final androidx.collection.MutableLongLongMap mutableLongLongMapOf(long key1, long value1, long key2, long value2, long key3, long value3, long key4, long value4) {
        MutableLongLongMap mutableLongLongMap = new MutableLongLongMap(0, 1, 0);
        androidx.collection.MutableLongLongMap num = mutableLongLongMap;
        long l2 = key1;
        final Object obj2 = key2;
        num.set(l2, obj4);
        num.set(key3, obj8);
        num.set(obj24, obj12);
        final int i5 = i3;
        num.set(obj28, l2);
        return mutableLongLongMap;
    }

    public static final androidx.collection.MutableLongLongMap mutableLongLongMapOf(long key1, long value1, long key2, long value2, long key3, long value3, long key4, long value4, long key5, long value5) {
        MutableLongLongMap mutableLongLongMap = new MutableLongLongMap(0, 1, 0);
        androidx.collection.MutableLongLongMap num = mutableLongLongMap;
        long l3 = key1;
        final Object obj3 = key2;
        num.set(l3, obj4);
        num.set(key3, obj8);
        num.set(key5, obj12);
        final int i5 = i3;
        num.set(obj28, l3);
        num.set(obj32, l3);
        return mutableLongLongMap;
    }
}
