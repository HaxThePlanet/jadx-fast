package androidx.collection;

import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\t\n\u0002\u0008\n\u001a\u0006\u0010\u0002\u001a\u00020\u0003\u001a\u0006\u0010\u0004\u001a\u00020\u0003\u001a\u0016\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0008\u001a&\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00082\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0008\u001a6\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00082\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00082\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u000c\u001a\u00020\u0008\u001aF\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00082\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00082\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u000c\u001a\u00020\u00082\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u0008\u001aV\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00082\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00082\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u000c\u001a\u00020\u00082\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u00082\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u0008\u001a\u0006\u0010\u0011\u001a\u00020\u0001\u001a\u0016\u0010\u0011\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0008\u001a&\u0010\u0011\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00082\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0008\u001a6\u0010\u0011\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00082\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00082\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u000c\u001a\u00020\u0008\u001aF\u0010\u0011\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00082\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00082\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u000c\u001a\u00020\u00082\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u0008\u001aV\u0010\u0011\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00082\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00082\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u000c\u001a\u00020\u00082\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u00082\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u0008\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012", d2 = {"EmptyFloatLongMap", "Landroidx/collection/MutableFloatLongMap;", "emptyFloatLongMap", "Landroidx/collection/FloatLongMap;", "floatLongMapOf", "key1", "", "value1", "", "key2", "value2", "key3", "value3", "key4", "value4", "key5", "value5", "mutableFloatLongMapOf", "collection"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class FloatLongMapKt {

    private static final androidx.collection.MutableFloatLongMap EmptyFloatLongMap;
    static {
        MutableFloatLongMap mutableFloatLongMap = new MutableFloatLongMap(0);
        FloatLongMapKt.EmptyFloatLongMap = mutableFloatLongMap;
    }

    public static final androidx.collection.FloatLongMap emptyFloatLongMap() {
        return (FloatLongMap)FloatLongMapKt.EmptyFloatLongMap;
    }

    public static final androidx.collection.FloatLongMap floatLongMapOf() {
        return (FloatLongMap)FloatLongMapKt.EmptyFloatLongMap;
    }

    public static final androidx.collection.FloatLongMap floatLongMapOf(float key1, long value1) {
        MutableFloatLongMap mutableFloatLongMap = new MutableFloatLongMap(0, 1, 0);
        int i3 = 0;
        mutableFloatLongMap.set(key1, value1);
        return (FloatLongMap)mutableFloatLongMap;
    }

    public static final androidx.collection.FloatLongMap floatLongMapOf(float key1, long value1, float key2, long value2) {
        MutableFloatLongMap mutableFloatLongMap = new MutableFloatLongMap(0, 1, 0);
        androidx.collection.MutableFloatLongMap num = mutableFloatLongMap;
        int i3 = 0;
        num.set(key1, value1);
        num.set(value2, obj8);
        return (FloatLongMap)mutableFloatLongMap;
    }

    public static final androidx.collection.FloatLongMap floatLongMapOf(float key1, long value1, float key2, long value2, float key3, long value3) {
        MutableFloatLongMap mutableFloatLongMap = new MutableFloatLongMap(0, 1, 0);
        androidx.collection.MutableFloatLongMap num = mutableFloatLongMap;
        int i3 = 0;
        num.set(key1, value1);
        num.set(value2, key3);
        num.set(obj10, obj11);
        return (FloatLongMap)mutableFloatLongMap;
    }

    public static final androidx.collection.FloatLongMap floatLongMapOf(float key1, long value1, float key2, long value2, float key3, long value3, float key4, long value4) {
        MutableFloatLongMap mutableFloatLongMap = new MutableFloatLongMap(0, 1, 0);
        androidx.collection.MutableFloatLongMap num = mutableFloatLongMap;
        int i3 = 0;
        num.set(key1, value1);
        num.set(value2, key3);
        num.set(key4, value4);
        num.set(obj13, obj14);
        return (FloatLongMap)mutableFloatLongMap;
    }

    public static final androidx.collection.FloatLongMap floatLongMapOf(float key1, long value1, float key2, long value2, float key3, long value3, float key4, long value4, float key5, long value5) {
        MutableFloatLongMap mutableFloatLongMap = new MutableFloatLongMap(0, 1, 0);
        androidx.collection.MutableFloatLongMap num = mutableFloatLongMap;
        float f = key1;
        num.set(f, value1);
        num.set(value2, key3);
        num.set(key4, value4);
        num.set(value5, obj27);
        final int i5 = i3;
        num.set(obj29, obj30);
        return (FloatLongMap)mutableFloatLongMap;
    }

    public static final androidx.collection.MutableFloatLongMap mutableFloatLongMapOf() {
        MutableFloatLongMap mutableFloatLongMap = new MutableFloatLongMap(0, 1, 0);
        return mutableFloatLongMap;
    }

    public static final androidx.collection.MutableFloatLongMap mutableFloatLongMapOf(float key1, long value1) {
        MutableFloatLongMap mutableFloatLongMap = new MutableFloatLongMap(0, 1, 0);
        int i3 = 0;
        mutableFloatLongMap.set(key1, value1);
        return mutableFloatLongMap;
    }

    public static final androidx.collection.MutableFloatLongMap mutableFloatLongMapOf(float key1, long value1, float key2, long value2) {
        MutableFloatLongMap mutableFloatLongMap = new MutableFloatLongMap(0, 1, 0);
        androidx.collection.MutableFloatLongMap num = mutableFloatLongMap;
        int i3 = 0;
        num.set(key1, value1);
        num.set(value2, obj8);
        return mutableFloatLongMap;
    }

    public static final androidx.collection.MutableFloatLongMap mutableFloatLongMapOf(float key1, long value1, float key2, long value2, float key3, long value3) {
        MutableFloatLongMap mutableFloatLongMap = new MutableFloatLongMap(0, 1, 0);
        androidx.collection.MutableFloatLongMap num = mutableFloatLongMap;
        int i3 = 0;
        num.set(key1, value1);
        num.set(value2, key3);
        num.set(obj10, obj11);
        return mutableFloatLongMap;
    }

    public static final androidx.collection.MutableFloatLongMap mutableFloatLongMapOf(float key1, long value1, float key2, long value2, float key3, long value3, float key4, long value4) {
        MutableFloatLongMap mutableFloatLongMap = new MutableFloatLongMap(0, 1, 0);
        androidx.collection.MutableFloatLongMap num = mutableFloatLongMap;
        int i3 = 0;
        num.set(key1, value1);
        num.set(value2, key3);
        num.set(key4, value4);
        num.set(obj13, obj14);
        return mutableFloatLongMap;
    }

    public static final androidx.collection.MutableFloatLongMap mutableFloatLongMapOf(float key1, long value1, float key2, long value2, float key3, long value3, float key4, long value4, float key5, long value5) {
        MutableFloatLongMap mutableFloatLongMap = new MutableFloatLongMap(0, 1, 0);
        androidx.collection.MutableFloatLongMap num = mutableFloatLongMap;
        float f = key1;
        num.set(f, value1);
        num.set(value2, key3);
        num.set(key4, value4);
        num.set(value5, obj27);
        final int i5 = i3;
        num.set(obj29, obj30);
        return mutableFloatLongMap;
    }
}
