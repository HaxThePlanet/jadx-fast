package androidx.collection;

import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0002\u0008\n\u001a\u0006\u0010\u0002\u001a\u00020\u0003\u001a\u0006\u0010\u0004\u001a\u00020\u0003\u001a\u0016\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0008\u001a&\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00082\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0008\u001a6\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00082\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00082\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u000c\u001a\u00020\u0008\u001aF\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00082\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00082\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u000c\u001a\u00020\u00082\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u0008\u001aV\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00082\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00082\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u000c\u001a\u00020\u00082\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u00082\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u0008\u001a\u0006\u0010\u0011\u001a\u00020\u0001\u001a\u0016\u0010\u0011\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0008\u001a&\u0010\u0011\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00082\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0008\u001a6\u0010\u0011\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00082\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00082\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u000c\u001a\u00020\u0008\u001aF\u0010\u0011\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00082\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00082\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u000c\u001a\u00020\u00082\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u0008\u001aV\u0010\u0011\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00082\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00082\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u000c\u001a\u00020\u00082\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u00082\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u0008\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012", d2 = {"EmptyLongFloatMap", "Landroidx/collection/MutableLongFloatMap;", "emptyLongFloatMap", "Landroidx/collection/LongFloatMap;", "longFloatMapOf", "key1", "", "value1", "", "key2", "value2", "key3", "value3", "key4", "value4", "key5", "value5", "mutableLongFloatMapOf", "collection"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class LongFloatMapKt {

    private static final androidx.collection.MutableLongFloatMap EmptyLongFloatMap;
    static {
        MutableLongFloatMap mutableLongFloatMap = new MutableLongFloatMap(0);
        LongFloatMapKt.EmptyLongFloatMap = mutableLongFloatMap;
    }

    public static final androidx.collection.LongFloatMap emptyLongFloatMap() {
        return (LongFloatMap)LongFloatMapKt.EmptyLongFloatMap;
    }

    public static final androidx.collection.LongFloatMap longFloatMapOf() {
        return (LongFloatMap)LongFloatMapKt.EmptyLongFloatMap;
    }

    public static final androidx.collection.LongFloatMap longFloatMapOf(long key1, float value1) {
        MutableLongFloatMap mutableLongFloatMap = new MutableLongFloatMap(0, 1, 0);
        int i3 = 0;
        mutableLongFloatMap.set(key1, value1);
        return (LongFloatMap)mutableLongFloatMap;
    }

    public static final androidx.collection.LongFloatMap longFloatMapOf(long key1, float value1, long key2, float value2) {
        MutableLongFloatMap mutableLongFloatMap = new MutableLongFloatMap(0, 1, 0);
        androidx.collection.MutableLongFloatMap num = mutableLongFloatMap;
        int i3 = 0;
        num.set(key1, value1);
        num.set(value2, obj8);
        return (LongFloatMap)mutableLongFloatMap;
    }

    public static final androidx.collection.LongFloatMap longFloatMapOf(long key1, float value1, long key2, float value2, long key3, float value3) {
        MutableLongFloatMap mutableLongFloatMap = new MutableLongFloatMap(0, 1, 0);
        androidx.collection.MutableLongFloatMap num = mutableLongFloatMap;
        int i3 = 0;
        num.set(key1, value1);
        num.set(value2, key3);
        num.set(obj10, obj11);
        return (LongFloatMap)mutableLongFloatMap;
    }

    public static final androidx.collection.LongFloatMap longFloatMapOf(long key1, float value1, long key2, float value2, long key3, float value3, long key4, float value4) {
        MutableLongFloatMap mutableLongFloatMap = new MutableLongFloatMap(0, 1, 0);
        androidx.collection.MutableLongFloatMap num = mutableLongFloatMap;
        int i3 = 0;
        num.set(key1, value1);
        num.set(value2, key3);
        num.set(key4, value4);
        num.set(obj13, obj14);
        return (LongFloatMap)mutableLongFloatMap;
    }

    public static final androidx.collection.LongFloatMap longFloatMapOf(long key1, float value1, long key2, float value2, long key3, float value3, long key4, float value4, long key5, float value5) {
        MutableLongFloatMap mutableLongFloatMap = new MutableLongFloatMap(0, 1, 0);
        androidx.collection.MutableLongFloatMap num = mutableLongFloatMap;
        long l = key1;
        num.set(l, obj4);
        num.set(value2, obj7);
        num.set(key4, obj10);
        num.set(value5, obj13);
        final int i5 = i3;
        num.set(obj28, l);
        return (LongFloatMap)mutableLongFloatMap;
    }

    public static final androidx.collection.MutableLongFloatMap mutableLongFloatMapOf() {
        MutableLongFloatMap mutableLongFloatMap = new MutableLongFloatMap(0, 1, 0);
        return mutableLongFloatMap;
    }

    public static final androidx.collection.MutableLongFloatMap mutableLongFloatMapOf(long key1, float value1) {
        MutableLongFloatMap mutableLongFloatMap = new MutableLongFloatMap(0, 1, 0);
        int i3 = 0;
        mutableLongFloatMap.set(key1, value1);
        return mutableLongFloatMap;
    }

    public static final androidx.collection.MutableLongFloatMap mutableLongFloatMapOf(long key1, float value1, long key2, float value2) {
        MutableLongFloatMap mutableLongFloatMap = new MutableLongFloatMap(0, 1, 0);
        androidx.collection.MutableLongFloatMap num = mutableLongFloatMap;
        int i3 = 0;
        num.set(key1, value1);
        num.set(value2, obj8);
        return mutableLongFloatMap;
    }

    public static final androidx.collection.MutableLongFloatMap mutableLongFloatMapOf(long key1, float value1, long key2, float value2, long key3, float value3) {
        MutableLongFloatMap mutableLongFloatMap = new MutableLongFloatMap(0, 1, 0);
        androidx.collection.MutableLongFloatMap num = mutableLongFloatMap;
        int i3 = 0;
        num.set(key1, value1);
        num.set(value2, key3);
        num.set(obj10, obj11);
        return mutableLongFloatMap;
    }

    public static final androidx.collection.MutableLongFloatMap mutableLongFloatMapOf(long key1, float value1, long key2, float value2, long key3, float value3, long key4, float value4) {
        MutableLongFloatMap mutableLongFloatMap = new MutableLongFloatMap(0, 1, 0);
        androidx.collection.MutableLongFloatMap num = mutableLongFloatMap;
        int i3 = 0;
        num.set(key1, value1);
        num.set(value2, key3);
        num.set(key4, value4);
        num.set(obj13, obj14);
        return mutableLongFloatMap;
    }

    public static final androidx.collection.MutableLongFloatMap mutableLongFloatMapOf(long key1, float value1, long key2, float value2, long key3, float value3, long key4, float value4, long key5, float value5) {
        MutableLongFloatMap mutableLongFloatMap = new MutableLongFloatMap(0, 1, 0);
        androidx.collection.MutableLongFloatMap num = mutableLongFloatMap;
        long l = key1;
        num.set(l, obj4);
        num.set(value2, obj7);
        num.set(key4, obj10);
        num.set(value5, obj13);
        final int i5 = i3;
        num.set(obj28, l);
        return mutableLongFloatMap;
    }
}
