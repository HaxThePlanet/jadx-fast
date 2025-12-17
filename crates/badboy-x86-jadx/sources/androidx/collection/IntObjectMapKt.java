package androidx.collection;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0008\n\u0002\u0008\u0015\u001a\u0012\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u0002H\u00050\u0004\"\u0004\u0008\u0000\u0010\u0005\u001a\u0012\u0010\u0006\u001a\u0008\u0012\u0004\u0012\u0002H\u00050\u0004\"\u0004\u0008\u0000\u0010\u0005\u001a'\u0010\u0006\u001a\u0008\u0012\u0004\u0012\u0002H\u00050\u0004\"\u0004\u0008\u0000\u0010\u00052\u0006\u0010\u0007\u001a\u00020\u00082\u0006\u0010\t\u001a\u0002H\u0005¢\u0006\u0002\u0010\n\u001a7\u0010\u0006\u001a\u0008\u0012\u0004\u0012\u0002H\u00050\u0004\"\u0004\u0008\u0000\u0010\u00052\u0006\u0010\u0007\u001a\u00020\u00082\u0006\u0010\t\u001a\u0002H\u00052\u0006\u0010\u000b\u001a\u00020\u00082\u0006\u0010\u000c\u001a\u0002H\u0005¢\u0006\u0002\u0010\r\u001aG\u0010\u0006\u001a\u0008\u0012\u0004\u0012\u0002H\u00050\u0004\"\u0004\u0008\u0000\u0010\u00052\u0006\u0010\u0007\u001a\u00020\u00082\u0006\u0010\t\u001a\u0002H\u00052\u0006\u0010\u000b\u001a\u00020\u00082\u0006\u0010\u000c\u001a\u0002H\u00052\u0006\u0010\u000e\u001a\u00020\u00082\u0006\u0010\u000f\u001a\u0002H\u0005¢\u0006\u0002\u0010\u0010\u001aW\u0010\u0006\u001a\u0008\u0012\u0004\u0012\u0002H\u00050\u0004\"\u0004\u0008\u0000\u0010\u00052\u0006\u0010\u0007\u001a\u00020\u00082\u0006\u0010\t\u001a\u0002H\u00052\u0006\u0010\u000b\u001a\u00020\u00082\u0006\u0010\u000c\u001a\u0002H\u00052\u0006\u0010\u000e\u001a\u00020\u00082\u0006\u0010\u000f\u001a\u0002H\u00052\u0006\u0010\u0011\u001a\u00020\u00082\u0006\u0010\u0012\u001a\u0002H\u0005¢\u0006\u0002\u0010\u0013\u001ag\u0010\u0006\u001a\u0008\u0012\u0004\u0012\u0002H\u00050\u0004\"\u0004\u0008\u0000\u0010\u00052\u0006\u0010\u0007\u001a\u00020\u00082\u0006\u0010\t\u001a\u0002H\u00052\u0006\u0010\u000b\u001a\u00020\u00082\u0006\u0010\u000c\u001a\u0002H\u00052\u0006\u0010\u000e\u001a\u00020\u00082\u0006\u0010\u000f\u001a\u0002H\u00052\u0006\u0010\u0011\u001a\u00020\u00082\u0006\u0010\u0012\u001a\u0002H\u00052\u0006\u0010\u0014\u001a\u00020\u00082\u0006\u0010\u0015\u001a\u0002H\u0005¢\u0006\u0002\u0010\u0016\u001a\u0012\u0010\u0017\u001a\u0008\u0012\u0004\u0012\u0002H\u00050\u0001\"\u0004\u0008\u0000\u0010\u0005\u001a'\u0010\u0017\u001a\u0008\u0012\u0004\u0012\u0002H\u00050\u0001\"\u0004\u0008\u0000\u0010\u00052\u0006\u0010\u0007\u001a\u00020\u00082\u0006\u0010\t\u001a\u0002H\u0005¢\u0006\u0002\u0010\u0018\u001a7\u0010\u0017\u001a\u0008\u0012\u0004\u0012\u0002H\u00050\u0001\"\u0004\u0008\u0000\u0010\u00052\u0006\u0010\u0007\u001a\u00020\u00082\u0006\u0010\t\u001a\u0002H\u00052\u0006\u0010\u000b\u001a\u00020\u00082\u0006\u0010\u000c\u001a\u0002H\u0005¢\u0006\u0002\u0010\u0019\u001aG\u0010\u0017\u001a\u0008\u0012\u0004\u0012\u0002H\u00050\u0001\"\u0004\u0008\u0000\u0010\u00052\u0006\u0010\u0007\u001a\u00020\u00082\u0006\u0010\t\u001a\u0002H\u00052\u0006\u0010\u000b\u001a\u00020\u00082\u0006\u0010\u000c\u001a\u0002H\u00052\u0006\u0010\u000e\u001a\u00020\u00082\u0006\u0010\u000f\u001a\u0002H\u0005¢\u0006\u0002\u0010\u001a\u001aW\u0010\u0017\u001a\u0008\u0012\u0004\u0012\u0002H\u00050\u0001\"\u0004\u0008\u0000\u0010\u00052\u0006\u0010\u0007\u001a\u00020\u00082\u0006\u0010\t\u001a\u0002H\u00052\u0006\u0010\u000b\u001a\u00020\u00082\u0006\u0010\u000c\u001a\u0002H\u00052\u0006\u0010\u000e\u001a\u00020\u00082\u0006\u0010\u000f\u001a\u0002H\u00052\u0006\u0010\u0011\u001a\u00020\u00082\u0006\u0010\u0012\u001a\u0002H\u0005¢\u0006\u0002\u0010\u001b\u001ag\u0010\u0017\u001a\u0008\u0012\u0004\u0012\u0002H\u00050\u0001\"\u0004\u0008\u0000\u0010\u00052\u0006\u0010\u0007\u001a\u00020\u00082\u0006\u0010\t\u001a\u0002H\u00052\u0006\u0010\u000b\u001a\u00020\u00082\u0006\u0010\u000c\u001a\u0002H\u00052\u0006\u0010\u000e\u001a\u00020\u00082\u0006\u0010\u000f\u001a\u0002H\u00052\u0006\u0010\u0011\u001a\u00020\u00082\u0006\u0010\u0012\u001a\u0002H\u00052\u0006\u0010\u0014\u001a\u00020\u00082\u0006\u0010\u0015\u001a\u0002H\u0005¢\u0006\u0002\u0010\u001c\"\u0014\u0010\u0000\u001a\u0008\u0012\u0004\u0012\u00020\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d", d2 = {"EmptyIntObjectMap", "Landroidx/collection/MutableIntObjectMap;", "", "emptyIntObjectMap", "Landroidx/collection/IntObjectMap;", "V", "intObjectMapOf", "key1", "", "value1", "(ILjava/lang/Object;)Landroidx/collection/IntObjectMap;", "key2", "value2", "(ILjava/lang/Object;ILjava/lang/Object;)Landroidx/collection/IntObjectMap;", "key3", "value3", "(ILjava/lang/Object;ILjava/lang/Object;ILjava/lang/Object;)Landroidx/collection/IntObjectMap;", "key4", "value4", "(ILjava/lang/Object;ILjava/lang/Object;ILjava/lang/Object;ILjava/lang/Object;)Landroidx/collection/IntObjectMap;", "key5", "value5", "(ILjava/lang/Object;ILjava/lang/Object;ILjava/lang/Object;ILjava/lang/Object;ILjava/lang/Object;)Landroidx/collection/IntObjectMap;", "mutableIntObjectMapOf", "(ILjava/lang/Object;)Landroidx/collection/MutableIntObjectMap;", "(ILjava/lang/Object;ILjava/lang/Object;)Landroidx/collection/MutableIntObjectMap;", "(ILjava/lang/Object;ILjava/lang/Object;ILjava/lang/Object;)Landroidx/collection/MutableIntObjectMap;", "(ILjava/lang/Object;ILjava/lang/Object;ILjava/lang/Object;ILjava/lang/Object;)Landroidx/collection/MutableIntObjectMap;", "(ILjava/lang/Object;ILjava/lang/Object;ILjava/lang/Object;ILjava/lang/Object;ILjava/lang/Object;)Landroidx/collection/MutableIntObjectMap;", "collection"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class IntObjectMapKt {

    private static final androidx.collection.MutableIntObjectMap EmptyIntObjectMap;
    static {
        MutableIntObjectMap mutableIntObjectMap = new MutableIntObjectMap(0);
        IntObjectMapKt.EmptyIntObjectMap = mutableIntObjectMap;
    }

    public static final <V> androidx.collection.IntObjectMap<V> emptyIntObjectMap() {
        final androidx.collection.MutableIntObjectMap emptyIntObjectMap = IntObjectMapKt.EmptyIntObjectMap;
        Intrinsics.checkNotNull(emptyIntObjectMap, "null cannot be cast to non-null type androidx.collection.IntObjectMap<V of androidx.collection.IntObjectMapKt.emptyIntObjectMap>");
        return (IntObjectMap)emptyIntObjectMap;
    }

    public static final <V> androidx.collection.IntObjectMap<V> intObjectMapOf() {
        final androidx.collection.MutableIntObjectMap emptyIntObjectMap = IntObjectMapKt.EmptyIntObjectMap;
        Intrinsics.checkNotNull(emptyIntObjectMap, "null cannot be cast to non-null type androidx.collection.IntObjectMap<V of androidx.collection.IntObjectMapKt.intObjectMapOf>");
        return (IntObjectMap)emptyIntObjectMap;
    }

    public static final <V> androidx.collection.IntObjectMap<V> intObjectMapOf(int key1, V value1) {
        MutableIntObjectMap mutableIntObjectMap = new MutableIntObjectMap(0, 1, 0);
        int i3 = 0;
        mutableIntObjectMap.set(key1, value1);
        return (IntObjectMap)mutableIntObjectMap;
    }

    public static final <V> androidx.collection.IntObjectMap<V> intObjectMapOf(int key1, V value1, int key2, V value2) {
        MutableIntObjectMap mutableIntObjectMap = new MutableIntObjectMap(0, 1, 0);
        androidx.collection.MutableIntObjectMap map = mutableIntObjectMap;
        int i3 = 0;
        map.set(key1, value1);
        map.set(key2, value2);
        return (IntObjectMap)mutableIntObjectMap;
    }

    public static final <V> androidx.collection.IntObjectMap<V> intObjectMapOf(int key1, V value1, int key2, V value2, int key3, V value3) {
        MutableIntObjectMap mutableIntObjectMap = new MutableIntObjectMap(0, 1, 0);
        androidx.collection.MutableIntObjectMap map = mutableIntObjectMap;
        int i3 = 0;
        map.set(key1, value1);
        map.set(key2, value2);
        map.set(key3, value3);
        return (IntObjectMap)mutableIntObjectMap;
    }

    public static final <V> androidx.collection.IntObjectMap<V> intObjectMapOf(int key1, V value1, int key2, V value2, int key3, V value3, int key4, V value4) {
        MutableIntObjectMap mutableIntObjectMap = new MutableIntObjectMap(0, 1, 0);
        androidx.collection.MutableIntObjectMap map = mutableIntObjectMap;
        int i3 = 0;
        map.set(key1, value1);
        map.set(key2, value2);
        map.set(key3, value3);
        map.set(key4, value4);
        return (IntObjectMap)mutableIntObjectMap;
    }

    public static final <V> androidx.collection.IntObjectMap<V> intObjectMapOf(int key1, V value1, int key2, V value2, int key3, V value3, int key4, V value4, int key5, V value5) {
        MutableIntObjectMap mutableIntObjectMap = new MutableIntObjectMap(0, 1, 0);
        androidx.collection.MutableIntObjectMap map = mutableIntObjectMap;
        int i3 = 0;
        map.set(key1, value1);
        map.set(key2, value2);
        map.set(key3, value3);
        map.set(key4, value4);
        map.set(key5, value5);
        return (IntObjectMap)mutableIntObjectMap;
    }

    public static final <V> androidx.collection.MutableIntObjectMap<V> mutableIntObjectMapOf() {
        MutableIntObjectMap mutableIntObjectMap = new MutableIntObjectMap(0, 1, 0);
        return mutableIntObjectMap;
    }

    public static final <V> androidx.collection.MutableIntObjectMap<V> mutableIntObjectMapOf(int key1, V value1) {
        MutableIntObjectMap mutableIntObjectMap = new MutableIntObjectMap(0, 1, 0);
        int i3 = 0;
        mutableIntObjectMap.set(key1, value1);
        return mutableIntObjectMap;
    }

    public static final <V> androidx.collection.MutableIntObjectMap<V> mutableIntObjectMapOf(int key1, V value1, int key2, V value2) {
        MutableIntObjectMap mutableIntObjectMap = new MutableIntObjectMap(0, 1, 0);
        androidx.collection.MutableIntObjectMap map = mutableIntObjectMap;
        int i3 = 0;
        map.set(key1, value1);
        map.set(key2, value2);
        return mutableIntObjectMap;
    }

    public static final <V> androidx.collection.MutableIntObjectMap<V> mutableIntObjectMapOf(int key1, V value1, int key2, V value2, int key3, V value3) {
        MutableIntObjectMap mutableIntObjectMap = new MutableIntObjectMap(0, 1, 0);
        androidx.collection.MutableIntObjectMap map = mutableIntObjectMap;
        int i3 = 0;
        map.set(key1, value1);
        map.set(key2, value2);
        map.set(key3, value3);
        return mutableIntObjectMap;
    }

    public static final <V> androidx.collection.MutableIntObjectMap<V> mutableIntObjectMapOf(int key1, V value1, int key2, V value2, int key3, V value3, int key4, V value4) {
        MutableIntObjectMap mutableIntObjectMap = new MutableIntObjectMap(0, 1, 0);
        androidx.collection.MutableIntObjectMap map = mutableIntObjectMap;
        int i3 = 0;
        map.set(key1, value1);
        map.set(key2, value2);
        map.set(key3, value3);
        map.set(key4, value4);
        return mutableIntObjectMap;
    }

    public static final <V> androidx.collection.MutableIntObjectMap<V> mutableIntObjectMapOf(int key1, V value1, int key2, V value2, int key3, V value3, int key4, V value4, int key5, V value5) {
        MutableIntObjectMap mutableIntObjectMap = new MutableIntObjectMap(0, 1, 0);
        androidx.collection.MutableIntObjectMap map = mutableIntObjectMap;
        int i3 = 0;
        map.set(key1, value1);
        map.set(key2, value2);
        map.set(key3, value3);
        map.set(key4, value4);
        map.set(key5, value5);
        return mutableIntObjectMap;
    }
}
