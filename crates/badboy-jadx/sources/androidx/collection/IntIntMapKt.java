package androidx.collection;

import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u000b\u001a\u0006\u0010\u0002\u001a\u00020\u0003\u001a\u0006\u0010\u0004\u001a\u00020\u0003\u001a\u0016\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006\u001a&\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0008\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0006\u001a6\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0008\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0006\u001aF\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0008\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u000c\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u0006\u001aV\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0008\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u000c\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0006\u001a\u0006\u0010\u0010\u001a\u00020\u0001\u001a\u0016\u0010\u0010\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006\u001a&\u0010\u0010\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0008\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0006\u001a6\u0010\u0010\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0008\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0006\u001aF\u0010\u0010\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0008\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u000c\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u0006\u001aV\u0010\u0010\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0008\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u000c\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0006\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011", d2 = {"EmptyIntIntMap", "Landroidx/collection/MutableIntIntMap;", "emptyIntIntMap", "Landroidx/collection/IntIntMap;", "intIntMapOf", "key1", "", "value1", "key2", "value2", "key3", "value3", "key4", "value4", "key5", "value5", "mutableIntIntMapOf", "collection"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class IntIntMapKt {

    private static final androidx.collection.MutableIntIntMap EmptyIntIntMap;
    static {
        MutableIntIntMap mutableIntIntMap = new MutableIntIntMap(0);
        IntIntMapKt.EmptyIntIntMap = mutableIntIntMap;
    }

    public static final androidx.collection.IntIntMap emptyIntIntMap() {
        return (IntIntMap)IntIntMapKt.EmptyIntIntMap;
    }

    public static final androidx.collection.IntIntMap intIntMapOf() {
        return (IntIntMap)IntIntMapKt.EmptyIntIntMap;
    }

    public static final androidx.collection.IntIntMap intIntMapOf(int key1, int value1) {
        MutableIntIntMap mutableIntIntMap = new MutableIntIntMap(0, 1, 0);
        int i3 = 0;
        mutableIntIntMap.set(key1, value1);
        return (IntIntMap)mutableIntIntMap;
    }

    public static final androidx.collection.IntIntMap intIntMapOf(int key1, int value1, int key2, int value2) {
        MutableIntIntMap mutableIntIntMap = new MutableIntIntMap(0, 1, 0);
        androidx.collection.MutableIntIntMap map = mutableIntIntMap;
        int i3 = 0;
        map.set(key1, value1);
        map.set(key2, value2);
        return (IntIntMap)mutableIntIntMap;
    }

    public static final androidx.collection.IntIntMap intIntMapOf(int key1, int value1, int key2, int value2, int key3, int value3) {
        MutableIntIntMap mutableIntIntMap = new MutableIntIntMap(0, 1, 0);
        androidx.collection.MutableIntIntMap map = mutableIntIntMap;
        int i3 = 0;
        map.set(key1, value1);
        map.set(key2, value2);
        map.set(key3, value3);
        return (IntIntMap)mutableIntIntMap;
    }

    public static final androidx.collection.IntIntMap intIntMapOf(int key1, int value1, int key2, int value2, int key3, int value3, int key4, int value4) {
        MutableIntIntMap mutableIntIntMap = new MutableIntIntMap(0, 1, 0);
        androidx.collection.MutableIntIntMap map = mutableIntIntMap;
        int i3 = 0;
        map.set(key1, value1);
        map.set(key2, value2);
        map.set(key3, value3);
        map.set(key4, value4);
        return (IntIntMap)mutableIntIntMap;
    }

    public static final androidx.collection.IntIntMap intIntMapOf(int key1, int value1, int key2, int value2, int key3, int value3, int key4, int value4, int key5, int value5) {
        MutableIntIntMap mutableIntIntMap = new MutableIntIntMap(0, 1, 0);
        androidx.collection.MutableIntIntMap map = mutableIntIntMap;
        int i3 = 0;
        map.set(key1, value1);
        map.set(key2, value2);
        map.set(key3, value3);
        map.set(key4, value4);
        map.set(key5, value5);
        return (IntIntMap)mutableIntIntMap;
    }

    public static final androidx.collection.MutableIntIntMap mutableIntIntMapOf() {
        MutableIntIntMap mutableIntIntMap = new MutableIntIntMap(0, 1, 0);
        return mutableIntIntMap;
    }

    public static final androidx.collection.MutableIntIntMap mutableIntIntMapOf(int key1, int value1) {
        MutableIntIntMap mutableIntIntMap = new MutableIntIntMap(0, 1, 0);
        int i3 = 0;
        mutableIntIntMap.set(key1, value1);
        return mutableIntIntMap;
    }

    public static final androidx.collection.MutableIntIntMap mutableIntIntMapOf(int key1, int value1, int key2, int value2) {
        MutableIntIntMap mutableIntIntMap = new MutableIntIntMap(0, 1, 0);
        androidx.collection.MutableIntIntMap map = mutableIntIntMap;
        int i3 = 0;
        map.set(key1, value1);
        map.set(key2, value2);
        return mutableIntIntMap;
    }

    public static final androidx.collection.MutableIntIntMap mutableIntIntMapOf(int key1, int value1, int key2, int value2, int key3, int value3) {
        MutableIntIntMap mutableIntIntMap = new MutableIntIntMap(0, 1, 0);
        androidx.collection.MutableIntIntMap map = mutableIntIntMap;
        int i3 = 0;
        map.set(key1, value1);
        map.set(key2, value2);
        map.set(key3, value3);
        return mutableIntIntMap;
    }

    public static final androidx.collection.MutableIntIntMap mutableIntIntMapOf(int key1, int value1, int key2, int value2, int key3, int value3, int key4, int value4) {
        MutableIntIntMap mutableIntIntMap = new MutableIntIntMap(0, 1, 0);
        androidx.collection.MutableIntIntMap map = mutableIntIntMap;
        int i3 = 0;
        map.set(key1, value1);
        map.set(key2, value2);
        map.set(key3, value3);
        map.set(key4, value4);
        return mutableIntIntMap;
    }

    public static final androidx.collection.MutableIntIntMap mutableIntIntMapOf(int key1, int value1, int key2, int value2, int key3, int value3, int key4, int value4, int key5, int value5) {
        MutableIntIntMap mutableIntIntMap = new MutableIntIntMap(0, 1, 0);
        androidx.collection.MutableIntIntMap map = mutableIntIntMap;
        int i3 = 0;
        map.set(key1, value1);
        map.set(key2, value2);
        map.set(key3, value3);
        map.set(key4, value4);
        map.set(key5, value5);
        return mutableIntIntMap;
    }
}
