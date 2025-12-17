package androidx.collection;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u0008\n\u0002\u0008\u0015\u001a\u0012\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u0002H\u00050\u0004\"\u0004\u0008\u0000\u0010\u0005\u001a\u0012\u0010\u0006\u001a\u0008\u0012\u0004\u0012\u0002H\u00050\u0001\"\u0004\u0008\u0000\u0010\u0005\u001a'\u0010\u0006\u001a\u0008\u0012\u0004\u0012\u0002H\u00050\u0001\"\u0004\u0008\u0000\u0010\u00052\u0006\u0010\u0007\u001a\u0002H\u00052\u0006\u0010\u0008\u001a\u00020\t¢\u0006\u0002\u0010\n\u001a7\u0010\u0006\u001a\u0008\u0012\u0004\u0012\u0002H\u00050\u0001\"\u0004\u0008\u0000\u0010\u00052\u0006\u0010\u0007\u001a\u0002H\u00052\u0006\u0010\u0008\u001a\u00020\t2\u0006\u0010\u000b\u001a\u0002H\u00052\u0006\u0010\u000c\u001a\u00020\t¢\u0006\u0002\u0010\r\u001aG\u0010\u0006\u001a\u0008\u0012\u0004\u0012\u0002H\u00050\u0001\"\u0004\u0008\u0000\u0010\u00052\u0006\u0010\u0007\u001a\u0002H\u00052\u0006\u0010\u0008\u001a\u00020\t2\u0006\u0010\u000b\u001a\u0002H\u00052\u0006\u0010\u000c\u001a\u00020\t2\u0006\u0010\u000e\u001a\u0002H\u00052\u0006\u0010\u000f\u001a\u00020\t¢\u0006\u0002\u0010\u0010\u001aW\u0010\u0006\u001a\u0008\u0012\u0004\u0012\u0002H\u00050\u0001\"\u0004\u0008\u0000\u0010\u00052\u0006\u0010\u0007\u001a\u0002H\u00052\u0006\u0010\u0008\u001a\u00020\t2\u0006\u0010\u000b\u001a\u0002H\u00052\u0006\u0010\u000c\u001a\u00020\t2\u0006\u0010\u000e\u001a\u0002H\u00052\u0006\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0011\u001a\u0002H\u00052\u0006\u0010\u0012\u001a\u00020\t¢\u0006\u0002\u0010\u0013\u001ag\u0010\u0006\u001a\u0008\u0012\u0004\u0012\u0002H\u00050\u0001\"\u0004\u0008\u0000\u0010\u00052\u0006\u0010\u0007\u001a\u0002H\u00052\u0006\u0010\u0008\u001a\u00020\t2\u0006\u0010\u000b\u001a\u0002H\u00052\u0006\u0010\u000c\u001a\u00020\t2\u0006\u0010\u000e\u001a\u0002H\u00052\u0006\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0011\u001a\u0002H\u00052\u0006\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0014\u001a\u0002H\u00052\u0006\u0010\u0015\u001a\u00020\t¢\u0006\u0002\u0010\u0016\u001a\u0012\u0010\u0017\u001a\u0008\u0012\u0004\u0012\u0002H\u00050\u0004\"\u0004\u0008\u0000\u0010\u0005\u001a'\u0010\u0018\u001a\u0008\u0012\u0004\u0012\u0002H\u00050\u0004\"\u0004\u0008\u0000\u0010\u00052\u0006\u0010\u0007\u001a\u0002H\u00052\u0006\u0010\u0008\u001a\u00020\t¢\u0006\u0002\u0010\u0019\u001a7\u0010\u0018\u001a\u0008\u0012\u0004\u0012\u0002H\u00050\u0004\"\u0004\u0008\u0000\u0010\u00052\u0006\u0010\u0007\u001a\u0002H\u00052\u0006\u0010\u0008\u001a\u00020\t2\u0006\u0010\u000b\u001a\u0002H\u00052\u0006\u0010\u000c\u001a\u00020\t¢\u0006\u0002\u0010\u001a\u001aG\u0010\u0018\u001a\u0008\u0012\u0004\u0012\u0002H\u00050\u0004\"\u0004\u0008\u0000\u0010\u00052\u0006\u0010\u0007\u001a\u0002H\u00052\u0006\u0010\u0008\u001a\u00020\t2\u0006\u0010\u000b\u001a\u0002H\u00052\u0006\u0010\u000c\u001a\u00020\t2\u0006\u0010\u000e\u001a\u0002H\u00052\u0006\u0010\u000f\u001a\u00020\t¢\u0006\u0002\u0010\u001b\u001aW\u0010\u0018\u001a\u0008\u0012\u0004\u0012\u0002H\u00050\u0004\"\u0004\u0008\u0000\u0010\u00052\u0006\u0010\u0007\u001a\u0002H\u00052\u0006\u0010\u0008\u001a\u00020\t2\u0006\u0010\u000b\u001a\u0002H\u00052\u0006\u0010\u000c\u001a\u00020\t2\u0006\u0010\u000e\u001a\u0002H\u00052\u0006\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0011\u001a\u0002H\u00052\u0006\u0010\u0012\u001a\u00020\t¢\u0006\u0002\u0010\u001c\u001ag\u0010\u0018\u001a\u0008\u0012\u0004\u0012\u0002H\u00050\u0004\"\u0004\u0008\u0000\u0010\u00052\u0006\u0010\u0007\u001a\u0002H\u00052\u0006\u0010\u0008\u001a\u00020\t2\u0006\u0010\u000b\u001a\u0002H\u00052\u0006\u0010\u000c\u001a\u00020\t2\u0006\u0010\u000e\u001a\u0002H\u00052\u0006\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0011\u001a\u0002H\u00052\u0006\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0014\u001a\u0002H\u00052\u0006\u0010\u0015\u001a\u00020\t¢\u0006\u0002\u0010\u001d\"\u0016\u0010\u0000\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e", d2 = {"EmptyObjectIntMap", "Landroidx/collection/MutableObjectIntMap;", "", "emptyObjectIntMap", "Landroidx/collection/ObjectIntMap;", "K", "mutableObjectIntMapOf", "key1", "value1", "", "(Ljava/lang/Object;I)Landroidx/collection/MutableObjectIntMap;", "key2", "value2", "(Ljava/lang/Object;ILjava/lang/Object;I)Landroidx/collection/MutableObjectIntMap;", "key3", "value3", "(Ljava/lang/Object;ILjava/lang/Object;ILjava/lang/Object;I)Landroidx/collection/MutableObjectIntMap;", "key4", "value4", "(Ljava/lang/Object;ILjava/lang/Object;ILjava/lang/Object;ILjava/lang/Object;I)Landroidx/collection/MutableObjectIntMap;", "key5", "value5", "(Ljava/lang/Object;ILjava/lang/Object;ILjava/lang/Object;ILjava/lang/Object;ILjava/lang/Object;I)Landroidx/collection/MutableObjectIntMap;", "objectIntMap", "objectIntMapOf", "(Ljava/lang/Object;I)Landroidx/collection/ObjectIntMap;", "(Ljava/lang/Object;ILjava/lang/Object;I)Landroidx/collection/ObjectIntMap;", "(Ljava/lang/Object;ILjava/lang/Object;ILjava/lang/Object;I)Landroidx/collection/ObjectIntMap;", "(Ljava/lang/Object;ILjava/lang/Object;ILjava/lang/Object;ILjava/lang/Object;I)Landroidx/collection/ObjectIntMap;", "(Ljava/lang/Object;ILjava/lang/Object;ILjava/lang/Object;ILjava/lang/Object;ILjava/lang/Object;I)Landroidx/collection/ObjectIntMap;", "collection"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class ObjectIntMapKt {

    private static final androidx.collection.MutableObjectIntMap<Object> EmptyObjectIntMap;
    static {
        MutableObjectIntMap mutableObjectIntMap = new MutableObjectIntMap(0);
        ObjectIntMapKt.EmptyObjectIntMap = mutableObjectIntMap;
    }

    public static final <K> androidx.collection.ObjectIntMap<K> emptyObjectIntMap() {
        final androidx.collection.MutableObjectIntMap emptyObjectIntMap = ObjectIntMapKt.EmptyObjectIntMap;
        Intrinsics.checkNotNull(emptyObjectIntMap, "null cannot be cast to non-null type androidx.collection.ObjectIntMap<K of androidx.collection.ObjectIntMapKt.emptyObjectIntMap>");
        return (ObjectIntMap)emptyObjectIntMap;
    }

    public static final <K> androidx.collection.MutableObjectIntMap<K> mutableObjectIntMapOf() {
        MutableObjectIntMap mutableObjectIntMap = new MutableObjectIntMap(0, 1, 0);
        return mutableObjectIntMap;
    }

    public static final <K> androidx.collection.MutableObjectIntMap<K> mutableObjectIntMapOf(K key1, int value1) {
        MutableObjectIntMap mutableObjectIntMap = new MutableObjectIntMap(0, 1, 0);
        int i3 = 0;
        mutableObjectIntMap.set(key1, value1);
        return mutableObjectIntMap;
    }

    public static final <K> androidx.collection.MutableObjectIntMap<K> mutableObjectIntMapOf(K key1, int value1, K key2, int value2) {
        MutableObjectIntMap mutableObjectIntMap = new MutableObjectIntMap(0, 1, 0);
        androidx.collection.MutableObjectIntMap map = mutableObjectIntMap;
        int i3 = 0;
        map.set(key1, value1);
        map.set(key2, value2);
        return mutableObjectIntMap;
    }

    public static final <K> androidx.collection.MutableObjectIntMap<K> mutableObjectIntMapOf(K key1, int value1, K key2, int value2, K key3, int value3) {
        MutableObjectIntMap mutableObjectIntMap = new MutableObjectIntMap(0, 1, 0);
        androidx.collection.MutableObjectIntMap map = mutableObjectIntMap;
        int i3 = 0;
        map.set(key1, value1);
        map.set(key2, value2);
        map.set(key3, value3);
        return mutableObjectIntMap;
    }

    public static final <K> androidx.collection.MutableObjectIntMap<K> mutableObjectIntMapOf(K key1, int value1, K key2, int value2, K key3, int value3, K key4, int value4) {
        MutableObjectIntMap mutableObjectIntMap = new MutableObjectIntMap(0, 1, 0);
        androidx.collection.MutableObjectIntMap map = mutableObjectIntMap;
        int i3 = 0;
        map.set(key1, value1);
        map.set(key2, value2);
        map.set(key3, value3);
        map.set(key4, value4);
        return mutableObjectIntMap;
    }

    public static final <K> androidx.collection.MutableObjectIntMap<K> mutableObjectIntMapOf(K key1, int value1, K key2, int value2, K key3, int value3, K key4, int value4, K key5, int value5) {
        MutableObjectIntMap mutableObjectIntMap = new MutableObjectIntMap(0, 1, 0);
        androidx.collection.MutableObjectIntMap map = mutableObjectIntMap;
        int i3 = 0;
        map.set(key1, value1);
        map.set(key2, value2);
        map.set(key3, value3);
        map.set(key4, value4);
        map.set(key5, value5);
        return mutableObjectIntMap;
    }

    public static final <K> androidx.collection.ObjectIntMap<K> objectIntMap() {
        final androidx.collection.MutableObjectIntMap emptyObjectIntMap = ObjectIntMapKt.EmptyObjectIntMap;
        Intrinsics.checkNotNull(emptyObjectIntMap, "null cannot be cast to non-null type androidx.collection.ObjectIntMap<K of androidx.collection.ObjectIntMapKt.objectIntMap>");
        return (ObjectIntMap)emptyObjectIntMap;
    }

    public static final <K> androidx.collection.ObjectIntMap<K> objectIntMapOf(K key1, int value1) {
        MutableObjectIntMap mutableObjectIntMap = new MutableObjectIntMap(0, 1, 0);
        int i3 = 0;
        mutableObjectIntMap.set(key1, value1);
        return (ObjectIntMap)mutableObjectIntMap;
    }

    public static final <K> androidx.collection.ObjectIntMap<K> objectIntMapOf(K key1, int value1, K key2, int value2) {
        MutableObjectIntMap mutableObjectIntMap = new MutableObjectIntMap(0, 1, 0);
        androidx.collection.MutableObjectIntMap map = mutableObjectIntMap;
        int i3 = 0;
        map.set(key1, value1);
        map.set(key2, value2);
        return (ObjectIntMap)mutableObjectIntMap;
    }

    public static final <K> androidx.collection.ObjectIntMap<K> objectIntMapOf(K key1, int value1, K key2, int value2, K key3, int value3) {
        MutableObjectIntMap mutableObjectIntMap = new MutableObjectIntMap(0, 1, 0);
        androidx.collection.MutableObjectIntMap map = mutableObjectIntMap;
        int i3 = 0;
        map.set(key1, value1);
        map.set(key2, value2);
        map.set(key3, value3);
        return (ObjectIntMap)mutableObjectIntMap;
    }

    public static final <K> androidx.collection.ObjectIntMap<K> objectIntMapOf(K key1, int value1, K key2, int value2, K key3, int value3, K key4, int value4) {
        MutableObjectIntMap mutableObjectIntMap = new MutableObjectIntMap(0, 1, 0);
        androidx.collection.MutableObjectIntMap map = mutableObjectIntMap;
        int i3 = 0;
        map.set(key1, value1);
        map.set(key2, value2);
        map.set(key3, value3);
        map.set(key4, value4);
        return (ObjectIntMap)mutableObjectIntMap;
    }

    public static final <K> androidx.collection.ObjectIntMap<K> objectIntMapOf(K key1, int value1, K key2, int value2, K key3, int value3, K key4, int value4, K key5, int value5) {
        MutableObjectIntMap mutableObjectIntMap = new MutableObjectIntMap(0, 1, 0);
        androidx.collection.MutableObjectIntMap map = mutableObjectIntMap;
        int i3 = 0;
        map.set(key1, value1);
        map.set(key2, value2);
        map.set(key3, value3);
        map.set(key4, value4);
        map.set(key5, value5);
        return (ObjectIntMap)mutableObjectIntMap;
    }
}
