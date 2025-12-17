package androidx.collection;

import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0007\n\u0002\u0008\u000b\u001a\u0006\u0010\u0002\u001a\u00020\u0003\u001a\u0006\u0010\u0004\u001a\u00020\u0003\u001a\u0016\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006\u001a&\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0008\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0006\u001a6\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0008\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0006\u001aF\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0008\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u000c\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u0006\u001aV\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0008\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u000c\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0006\u001a\u0006\u0010\u0010\u001a\u00020\u0001\u001a\u0016\u0010\u0010\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006\u001a&\u0010\u0010\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0008\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0006\u001a6\u0010\u0010\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0008\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0006\u001aF\u0010\u0010\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0008\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u000c\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u0006\u001aV\u0010\u0010\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0008\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u000c\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0006\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011", d2 = {"EmptyFloatFloatMap", "Landroidx/collection/MutableFloatFloatMap;", "emptyFloatFloatMap", "Landroidx/collection/FloatFloatMap;", "floatFloatMapOf", "key1", "", "value1", "key2", "value2", "key3", "value3", "key4", "value4", "key5", "value5", "mutableFloatFloatMapOf", "collection"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class FloatFloatMapKt {

    private static final androidx.collection.MutableFloatFloatMap EmptyFloatFloatMap;
    static {
        MutableFloatFloatMap mutableFloatFloatMap = new MutableFloatFloatMap(0);
        FloatFloatMapKt.EmptyFloatFloatMap = mutableFloatFloatMap;
    }

    public static final androidx.collection.FloatFloatMap emptyFloatFloatMap() {
        return (FloatFloatMap)FloatFloatMapKt.EmptyFloatFloatMap;
    }

    public static final androidx.collection.FloatFloatMap floatFloatMapOf() {
        return (FloatFloatMap)FloatFloatMapKt.EmptyFloatFloatMap;
    }

    public static final androidx.collection.FloatFloatMap floatFloatMapOf(float key1, float value1) {
        MutableFloatFloatMap mutableFloatFloatMap = new MutableFloatFloatMap(0, 1, 0);
        int i3 = 0;
        mutableFloatFloatMap.set(key1, value1);
        return (FloatFloatMap)mutableFloatFloatMap;
    }

    public static final androidx.collection.FloatFloatMap floatFloatMapOf(float key1, float value1, float key2, float value2) {
        MutableFloatFloatMap mutableFloatFloatMap = new MutableFloatFloatMap(0, 1, 0);
        androidx.collection.MutableFloatFloatMap num = mutableFloatFloatMap;
        int i3 = 0;
        num.set(key1, value1);
        num.set(key2, value2);
        return (FloatFloatMap)mutableFloatFloatMap;
    }

    public static final androidx.collection.FloatFloatMap floatFloatMapOf(float key1, float value1, float key2, float value2, float key3, float value3) {
        MutableFloatFloatMap mutableFloatFloatMap = new MutableFloatFloatMap(0, 1, 0);
        androidx.collection.MutableFloatFloatMap num = mutableFloatFloatMap;
        int i3 = 0;
        num.set(key1, value1);
        num.set(key2, value2);
        num.set(key3, value3);
        return (FloatFloatMap)mutableFloatFloatMap;
    }

    public static final androidx.collection.FloatFloatMap floatFloatMapOf(float key1, float value1, float key2, float value2, float key3, float value3, float key4, float value4) {
        MutableFloatFloatMap mutableFloatFloatMap = new MutableFloatFloatMap(0, 1, 0);
        androidx.collection.MutableFloatFloatMap num = mutableFloatFloatMap;
        int i3 = 0;
        num.set(key1, value1);
        num.set(key2, value2);
        num.set(key3, value3);
        num.set(key4, value4);
        return (FloatFloatMap)mutableFloatFloatMap;
    }

    public static final androidx.collection.FloatFloatMap floatFloatMapOf(float key1, float value1, float key2, float value2, float key3, float value3, float key4, float value4, float key5, float value5) {
        MutableFloatFloatMap mutableFloatFloatMap = new MutableFloatFloatMap(0, 1, 0);
        androidx.collection.MutableFloatFloatMap num = mutableFloatFloatMap;
        int i3 = 0;
        num.set(key1, value1);
        num.set(key2, value2);
        num.set(key3, value3);
        num.set(key4, value4);
        num.set(key5, value5);
        return (FloatFloatMap)mutableFloatFloatMap;
    }

    public static final androidx.collection.MutableFloatFloatMap mutableFloatFloatMapOf() {
        MutableFloatFloatMap mutableFloatFloatMap = new MutableFloatFloatMap(0, 1, 0);
        return mutableFloatFloatMap;
    }

    public static final androidx.collection.MutableFloatFloatMap mutableFloatFloatMapOf(float key1, float value1) {
        MutableFloatFloatMap mutableFloatFloatMap = new MutableFloatFloatMap(0, 1, 0);
        int i3 = 0;
        mutableFloatFloatMap.set(key1, value1);
        return mutableFloatFloatMap;
    }

    public static final androidx.collection.MutableFloatFloatMap mutableFloatFloatMapOf(float key1, float value1, float key2, float value2) {
        MutableFloatFloatMap mutableFloatFloatMap = new MutableFloatFloatMap(0, 1, 0);
        androidx.collection.MutableFloatFloatMap num = mutableFloatFloatMap;
        int i3 = 0;
        num.set(key1, value1);
        num.set(key2, value2);
        return mutableFloatFloatMap;
    }

    public static final androidx.collection.MutableFloatFloatMap mutableFloatFloatMapOf(float key1, float value1, float key2, float value2, float key3, float value3) {
        MutableFloatFloatMap mutableFloatFloatMap = new MutableFloatFloatMap(0, 1, 0);
        androidx.collection.MutableFloatFloatMap num = mutableFloatFloatMap;
        int i3 = 0;
        num.set(key1, value1);
        num.set(key2, value2);
        num.set(key3, value3);
        return mutableFloatFloatMap;
    }

    public static final androidx.collection.MutableFloatFloatMap mutableFloatFloatMapOf(float key1, float value1, float key2, float value2, float key3, float value3, float key4, float value4) {
        MutableFloatFloatMap mutableFloatFloatMap = new MutableFloatFloatMap(0, 1, 0);
        androidx.collection.MutableFloatFloatMap num = mutableFloatFloatMap;
        int i3 = 0;
        num.set(key1, value1);
        num.set(key2, value2);
        num.set(key3, value3);
        num.set(key4, value4);
        return mutableFloatFloatMap;
    }

    public static final androidx.collection.MutableFloatFloatMap mutableFloatFloatMapOf(float key1, float value1, float key2, float value2, float key3, float value3, float key4, float value4, float key5, float value5) {
        MutableFloatFloatMap mutableFloatFloatMap = new MutableFloatFloatMap(0, 1, 0);
        androidx.collection.MutableFloatFloatMap num = mutableFloatFloatMap;
        int i3 = 0;
        num.set(key1, value1);
        num.set(key2, value2);
        num.set(key3, value3);
        num.set(key4, value4);
        num.set(key5, value5);
        return mutableFloatFloatMap;
    }
}
