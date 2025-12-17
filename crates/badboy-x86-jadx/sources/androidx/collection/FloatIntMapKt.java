package androidx.collection;

import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\n\u001a\u0006\u0010\u0002\u001a\u00020\u0003\u001a\u0006\u0010\u0004\u001a\u00020\u0003\u001a\u0016\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0008\u001a&\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00082\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0008\u001a6\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00082\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00082\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u000c\u001a\u00020\u0008\u001aF\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00082\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00082\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u000c\u001a\u00020\u00082\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u0008\u001aV\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00082\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00082\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u000c\u001a\u00020\u00082\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u00082\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u0008\u001a\u0006\u0010\u0011\u001a\u00020\u0001\u001a\u0016\u0010\u0011\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0008\u001a&\u0010\u0011\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00082\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0008\u001a6\u0010\u0011\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00082\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00082\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u000c\u001a\u00020\u0008\u001aF\u0010\u0011\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00082\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00082\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u000c\u001a\u00020\u00082\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u0008\u001aV\u0010\u0011\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00082\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00082\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u000c\u001a\u00020\u00082\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u00082\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u0008\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012", d2 = {"EmptyFloatIntMap", "Landroidx/collection/MutableFloatIntMap;", "emptyFloatIntMap", "Landroidx/collection/FloatIntMap;", "floatIntMapOf", "key1", "", "value1", "", "key2", "value2", "key3", "value3", "key4", "value4", "key5", "value5", "mutableFloatIntMapOf", "collection"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class FloatIntMapKt {

    private static final androidx.collection.MutableFloatIntMap EmptyFloatIntMap;
    static {
        MutableFloatIntMap mutableFloatIntMap = new MutableFloatIntMap(0);
        FloatIntMapKt.EmptyFloatIntMap = mutableFloatIntMap;
    }

    public static final androidx.collection.FloatIntMap emptyFloatIntMap() {
        return (FloatIntMap)FloatIntMapKt.EmptyFloatIntMap;
    }

    public static final androidx.collection.FloatIntMap floatIntMapOf() {
        return (FloatIntMap)FloatIntMapKt.EmptyFloatIntMap;
    }

    public static final androidx.collection.FloatIntMap floatIntMapOf(float key1, int value1) {
        MutableFloatIntMap mutableFloatIntMap = new MutableFloatIntMap(0, 1, 0);
        int i3 = 0;
        mutableFloatIntMap.set(key1, value1);
        return (FloatIntMap)mutableFloatIntMap;
    }

    public static final androidx.collection.FloatIntMap floatIntMapOf(float key1, int value1, float key2, int value2) {
        MutableFloatIntMap mutableFloatIntMap = new MutableFloatIntMap(0, 1, 0);
        androidx.collection.MutableFloatIntMap num = mutableFloatIntMap;
        int i3 = 0;
        num.set(key1, value1);
        num.set(key2, value2);
        return (FloatIntMap)mutableFloatIntMap;
    }

    public static final androidx.collection.FloatIntMap floatIntMapOf(float key1, int value1, float key2, int value2, float key3, int value3) {
        MutableFloatIntMap mutableFloatIntMap = new MutableFloatIntMap(0, 1, 0);
        androidx.collection.MutableFloatIntMap num = mutableFloatIntMap;
        int i3 = 0;
        num.set(key1, value1);
        num.set(key2, value2);
        num.set(key3, value3);
        return (FloatIntMap)mutableFloatIntMap;
    }

    public static final androidx.collection.FloatIntMap floatIntMapOf(float key1, int value1, float key2, int value2, float key3, int value3, float key4, int value4) {
        MutableFloatIntMap mutableFloatIntMap = new MutableFloatIntMap(0, 1, 0);
        androidx.collection.MutableFloatIntMap num = mutableFloatIntMap;
        int i3 = 0;
        num.set(key1, value1);
        num.set(key2, value2);
        num.set(key3, value3);
        num.set(key4, value4);
        return (FloatIntMap)mutableFloatIntMap;
    }

    public static final androidx.collection.FloatIntMap floatIntMapOf(float key1, int value1, float key2, int value2, float key3, int value3, float key4, int value4, float key5, int value5) {
        MutableFloatIntMap mutableFloatIntMap = new MutableFloatIntMap(0, 1, 0);
        androidx.collection.MutableFloatIntMap num = mutableFloatIntMap;
        int i3 = 0;
        num.set(key1, value1);
        num.set(key2, value2);
        num.set(key3, value3);
        num.set(key4, value4);
        num.set(key5, value5);
        return (FloatIntMap)mutableFloatIntMap;
    }

    public static final androidx.collection.MutableFloatIntMap mutableFloatIntMapOf() {
        MutableFloatIntMap mutableFloatIntMap = new MutableFloatIntMap(0, 1, 0);
        return mutableFloatIntMap;
    }

    public static final androidx.collection.MutableFloatIntMap mutableFloatIntMapOf(float key1, int value1) {
        MutableFloatIntMap mutableFloatIntMap = new MutableFloatIntMap(0, 1, 0);
        int i3 = 0;
        mutableFloatIntMap.set(key1, value1);
        return mutableFloatIntMap;
    }

    public static final androidx.collection.MutableFloatIntMap mutableFloatIntMapOf(float key1, int value1, float key2, int value2) {
        MutableFloatIntMap mutableFloatIntMap = new MutableFloatIntMap(0, 1, 0);
        androidx.collection.MutableFloatIntMap num = mutableFloatIntMap;
        int i3 = 0;
        num.set(key1, value1);
        num.set(key2, value2);
        return mutableFloatIntMap;
    }

    public static final androidx.collection.MutableFloatIntMap mutableFloatIntMapOf(float key1, int value1, float key2, int value2, float key3, int value3) {
        MutableFloatIntMap mutableFloatIntMap = new MutableFloatIntMap(0, 1, 0);
        androidx.collection.MutableFloatIntMap num = mutableFloatIntMap;
        int i3 = 0;
        num.set(key1, value1);
        num.set(key2, value2);
        num.set(key3, value3);
        return mutableFloatIntMap;
    }

    public static final androidx.collection.MutableFloatIntMap mutableFloatIntMapOf(float key1, int value1, float key2, int value2, float key3, int value3, float key4, int value4) {
        MutableFloatIntMap mutableFloatIntMap = new MutableFloatIntMap(0, 1, 0);
        androidx.collection.MutableFloatIntMap num = mutableFloatIntMap;
        int i3 = 0;
        num.set(key1, value1);
        num.set(key2, value2);
        num.set(key3, value3);
        num.set(key4, value4);
        return mutableFloatIntMap;
    }

    public static final androidx.collection.MutableFloatIntMap mutableFloatIntMapOf(float key1, int value1, float key2, int value2, float key3, int value3, float key4, int value4, float key5, int value5) {
        MutableFloatIntMap mutableFloatIntMap = new MutableFloatIntMap(0, 1, 0);
        androidx.collection.MutableFloatIntMap num = mutableFloatIntMap;
        int i3 = 0;
        num.set(key1, value1);
        num.set(key2, value2);
        num.set(key3, value3);
        num.set(key4, value4);
        num.set(key5, value5);
        return mutableFloatIntMap;
    }
}
