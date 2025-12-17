package androidx.collection;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\t\n\u0002\u0008\u0015\u001a\u0012\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u0002H\u00050\u0004\"\u0004\u0008\u0000\u0010\u0005\u001a\u0012\u0010\u0006\u001a\u0008\u0012\u0004\u0012\u0002H\u00050\u0001\"\u0004\u0008\u0000\u0010\u0005\u001a'\u0010\u0006\u001a\u0008\u0012\u0004\u0012\u0002H\u00050\u0001\"\u0004\u0008\u0000\u0010\u00052\u0006\u0010\u0007\u001a\u0002H\u00052\u0006\u0010\u0008\u001a\u00020\t¢\u0006\u0002\u0010\n\u001a7\u0010\u0006\u001a\u0008\u0012\u0004\u0012\u0002H\u00050\u0001\"\u0004\u0008\u0000\u0010\u00052\u0006\u0010\u0007\u001a\u0002H\u00052\u0006\u0010\u0008\u001a\u00020\t2\u0006\u0010\u000b\u001a\u0002H\u00052\u0006\u0010\u000c\u001a\u00020\t¢\u0006\u0002\u0010\r\u001aG\u0010\u0006\u001a\u0008\u0012\u0004\u0012\u0002H\u00050\u0001\"\u0004\u0008\u0000\u0010\u00052\u0006\u0010\u0007\u001a\u0002H\u00052\u0006\u0010\u0008\u001a\u00020\t2\u0006\u0010\u000b\u001a\u0002H\u00052\u0006\u0010\u000c\u001a\u00020\t2\u0006\u0010\u000e\u001a\u0002H\u00052\u0006\u0010\u000f\u001a\u00020\t¢\u0006\u0002\u0010\u0010\u001aW\u0010\u0006\u001a\u0008\u0012\u0004\u0012\u0002H\u00050\u0001\"\u0004\u0008\u0000\u0010\u00052\u0006\u0010\u0007\u001a\u0002H\u00052\u0006\u0010\u0008\u001a\u00020\t2\u0006\u0010\u000b\u001a\u0002H\u00052\u0006\u0010\u000c\u001a\u00020\t2\u0006\u0010\u000e\u001a\u0002H\u00052\u0006\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0011\u001a\u0002H\u00052\u0006\u0010\u0012\u001a\u00020\t¢\u0006\u0002\u0010\u0013\u001ag\u0010\u0006\u001a\u0008\u0012\u0004\u0012\u0002H\u00050\u0001\"\u0004\u0008\u0000\u0010\u00052\u0006\u0010\u0007\u001a\u0002H\u00052\u0006\u0010\u0008\u001a\u00020\t2\u0006\u0010\u000b\u001a\u0002H\u00052\u0006\u0010\u000c\u001a\u00020\t2\u0006\u0010\u000e\u001a\u0002H\u00052\u0006\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0011\u001a\u0002H\u00052\u0006\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0014\u001a\u0002H\u00052\u0006\u0010\u0015\u001a\u00020\t¢\u0006\u0002\u0010\u0016\u001a\u0012\u0010\u0017\u001a\u0008\u0012\u0004\u0012\u0002H\u00050\u0004\"\u0004\u0008\u0000\u0010\u0005\u001a'\u0010\u0018\u001a\u0008\u0012\u0004\u0012\u0002H\u00050\u0004\"\u0004\u0008\u0000\u0010\u00052\u0006\u0010\u0007\u001a\u0002H\u00052\u0006\u0010\u0008\u001a\u00020\t¢\u0006\u0002\u0010\u0019\u001a7\u0010\u0018\u001a\u0008\u0012\u0004\u0012\u0002H\u00050\u0004\"\u0004\u0008\u0000\u0010\u00052\u0006\u0010\u0007\u001a\u0002H\u00052\u0006\u0010\u0008\u001a\u00020\t2\u0006\u0010\u000b\u001a\u0002H\u00052\u0006\u0010\u000c\u001a\u00020\t¢\u0006\u0002\u0010\u001a\u001aG\u0010\u0018\u001a\u0008\u0012\u0004\u0012\u0002H\u00050\u0004\"\u0004\u0008\u0000\u0010\u00052\u0006\u0010\u0007\u001a\u0002H\u00052\u0006\u0010\u0008\u001a\u00020\t2\u0006\u0010\u000b\u001a\u0002H\u00052\u0006\u0010\u000c\u001a\u00020\t2\u0006\u0010\u000e\u001a\u0002H\u00052\u0006\u0010\u000f\u001a\u00020\t¢\u0006\u0002\u0010\u001b\u001aW\u0010\u0018\u001a\u0008\u0012\u0004\u0012\u0002H\u00050\u0004\"\u0004\u0008\u0000\u0010\u00052\u0006\u0010\u0007\u001a\u0002H\u00052\u0006\u0010\u0008\u001a\u00020\t2\u0006\u0010\u000b\u001a\u0002H\u00052\u0006\u0010\u000c\u001a\u00020\t2\u0006\u0010\u000e\u001a\u0002H\u00052\u0006\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0011\u001a\u0002H\u00052\u0006\u0010\u0012\u001a\u00020\t¢\u0006\u0002\u0010\u001c\u001ag\u0010\u0018\u001a\u0008\u0012\u0004\u0012\u0002H\u00050\u0004\"\u0004\u0008\u0000\u0010\u00052\u0006\u0010\u0007\u001a\u0002H\u00052\u0006\u0010\u0008\u001a\u00020\t2\u0006\u0010\u000b\u001a\u0002H\u00052\u0006\u0010\u000c\u001a\u00020\t2\u0006\u0010\u000e\u001a\u0002H\u00052\u0006\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0011\u001a\u0002H\u00052\u0006\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0014\u001a\u0002H\u00052\u0006\u0010\u0015\u001a\u00020\t¢\u0006\u0002\u0010\u001d\"\u0016\u0010\u0000\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e", d2 = {"EmptyObjectLongMap", "Landroidx/collection/MutableObjectLongMap;", "", "emptyObjectLongMap", "Landroidx/collection/ObjectLongMap;", "K", "mutableObjectLongMapOf", "key1", "value1", "", "(Ljava/lang/Object;J)Landroidx/collection/MutableObjectLongMap;", "key2", "value2", "(Ljava/lang/Object;JLjava/lang/Object;J)Landroidx/collection/MutableObjectLongMap;", "key3", "value3", "(Ljava/lang/Object;JLjava/lang/Object;JLjava/lang/Object;J)Landroidx/collection/MutableObjectLongMap;", "key4", "value4", "(Ljava/lang/Object;JLjava/lang/Object;JLjava/lang/Object;JLjava/lang/Object;J)Landroidx/collection/MutableObjectLongMap;", "key5", "value5", "(Ljava/lang/Object;JLjava/lang/Object;JLjava/lang/Object;JLjava/lang/Object;JLjava/lang/Object;J)Landroidx/collection/MutableObjectLongMap;", "objectLongMap", "objectLongMapOf", "(Ljava/lang/Object;J)Landroidx/collection/ObjectLongMap;", "(Ljava/lang/Object;JLjava/lang/Object;J)Landroidx/collection/ObjectLongMap;", "(Ljava/lang/Object;JLjava/lang/Object;JLjava/lang/Object;J)Landroidx/collection/ObjectLongMap;", "(Ljava/lang/Object;JLjava/lang/Object;JLjava/lang/Object;JLjava/lang/Object;J)Landroidx/collection/ObjectLongMap;", "(Ljava/lang/Object;JLjava/lang/Object;JLjava/lang/Object;JLjava/lang/Object;JLjava/lang/Object;J)Landroidx/collection/ObjectLongMap;", "collection"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class ObjectLongMapKt {

    private static final androidx.collection.MutableObjectLongMap<Object> EmptyObjectLongMap;
    static {
        MutableObjectLongMap mutableObjectLongMap = new MutableObjectLongMap(0);
        ObjectLongMapKt.EmptyObjectLongMap = mutableObjectLongMap;
    }

    public static final <K> androidx.collection.ObjectLongMap<K> emptyObjectLongMap() {
        final androidx.collection.MutableObjectLongMap emptyObjectLongMap = ObjectLongMapKt.EmptyObjectLongMap;
        Intrinsics.checkNotNull(emptyObjectLongMap, "null cannot be cast to non-null type androidx.collection.ObjectLongMap<K of androidx.collection.ObjectLongMapKt.emptyObjectLongMap>");
        return (ObjectLongMap)emptyObjectLongMap;
    }

    public static final <K> androidx.collection.MutableObjectLongMap<K> mutableObjectLongMapOf() {
        MutableObjectLongMap mutableObjectLongMap = new MutableObjectLongMap(0, 1, 0);
        return mutableObjectLongMap;
    }

    public static final <K> androidx.collection.MutableObjectLongMap<K> mutableObjectLongMapOf(K key1, long value1) {
        MutableObjectLongMap mutableObjectLongMap = new MutableObjectLongMap(0, 1, 0);
        int i3 = 0;
        mutableObjectLongMap.set(key1, value1);
        return mutableObjectLongMap;
    }

    public static final <K> androidx.collection.MutableObjectLongMap<K> mutableObjectLongMapOf(K key1, long value1, K key2, long value2) {
        MutableObjectLongMap mutableObjectLongMap = new MutableObjectLongMap(0, 1, 0);
        androidx.collection.MutableObjectLongMap num = mutableObjectLongMap;
        int i3 = 0;
        num.set(key1, value1);
        num.set(value2, obj8);
        return mutableObjectLongMap;
    }

    public static final <K> androidx.collection.MutableObjectLongMap<K> mutableObjectLongMapOf(K key1, long value1, K key2, long value2, K key3, long value3) {
        MutableObjectLongMap mutableObjectLongMap = new MutableObjectLongMap(0, 1, 0);
        androidx.collection.MutableObjectLongMap num = mutableObjectLongMap;
        int i3 = 0;
        num.set(key1, value1);
        num.set(value2, key3);
        num.set(obj10, obj11);
        return mutableObjectLongMap;
    }

    public static final <K> androidx.collection.MutableObjectLongMap<K> mutableObjectLongMapOf(K key1, long value1, K key2, long value2, K key3, long value3, K key4, long value4) {
        MutableObjectLongMap mutableObjectLongMap = new MutableObjectLongMap(0, 1, 0);
        androidx.collection.MutableObjectLongMap num = mutableObjectLongMap;
        int i3 = 0;
        num.set(key1, value1);
        num.set(value2, key3);
        num.set(key4, value4);
        num.set(obj13, obj14);
        return mutableObjectLongMap;
    }

    public static final <K> androidx.collection.MutableObjectLongMap<K> mutableObjectLongMapOf(K key1, long value1, K key2, long value2, K key3, long value3, K key4, long value4, K key5, long value5) {
        MutableObjectLongMap mutableObjectLongMap = new MutableObjectLongMap(0, 1, 0);
        androidx.collection.MutableObjectLongMap num = mutableObjectLongMap;
        Object obj = key1;
        num.set(obj, value1);
        num.set(value2, key3);
        num.set(key4, value4);
        num.set(value5, obj27);
        final int i5 = i3;
        num.set(obj29, obj30);
        return mutableObjectLongMap;
    }

    public static final <K> androidx.collection.ObjectLongMap<K> objectLongMap() {
        final androidx.collection.MutableObjectLongMap emptyObjectLongMap = ObjectLongMapKt.EmptyObjectLongMap;
        Intrinsics.checkNotNull(emptyObjectLongMap, "null cannot be cast to non-null type androidx.collection.ObjectLongMap<K of androidx.collection.ObjectLongMapKt.objectLongMap>");
        return (ObjectLongMap)emptyObjectLongMap;
    }

    public static final <K> androidx.collection.ObjectLongMap<K> objectLongMapOf(K key1, long value1) {
        MutableObjectLongMap mutableObjectLongMap = new MutableObjectLongMap(0, 1, 0);
        int i3 = 0;
        mutableObjectLongMap.set(key1, value1);
        return (ObjectLongMap)mutableObjectLongMap;
    }

    public static final <K> androidx.collection.ObjectLongMap<K> objectLongMapOf(K key1, long value1, K key2, long value2) {
        MutableObjectLongMap mutableObjectLongMap = new MutableObjectLongMap(0, 1, 0);
        androidx.collection.MutableObjectLongMap num = mutableObjectLongMap;
        int i3 = 0;
        num.set(key1, value1);
        num.set(value2, obj8);
        return (ObjectLongMap)mutableObjectLongMap;
    }

    public static final <K> androidx.collection.ObjectLongMap<K> objectLongMapOf(K key1, long value1, K key2, long value2, K key3, long value3) {
        MutableObjectLongMap mutableObjectLongMap = new MutableObjectLongMap(0, 1, 0);
        androidx.collection.MutableObjectLongMap num = mutableObjectLongMap;
        int i3 = 0;
        num.set(key1, value1);
        num.set(value2, key3);
        num.set(obj10, obj11);
        return (ObjectLongMap)mutableObjectLongMap;
    }

    public static final <K> androidx.collection.ObjectLongMap<K> objectLongMapOf(K key1, long value1, K key2, long value2, K key3, long value3, K key4, long value4) {
        MutableObjectLongMap mutableObjectLongMap = new MutableObjectLongMap(0, 1, 0);
        androidx.collection.MutableObjectLongMap num = mutableObjectLongMap;
        int i3 = 0;
        num.set(key1, value1);
        num.set(value2, key3);
        num.set(key4, value4);
        num.set(obj13, obj14);
        return (ObjectLongMap)mutableObjectLongMap;
    }

    public static final <K> androidx.collection.ObjectLongMap<K> objectLongMapOf(K key1, long value1, K key2, long value2, K key3, long value3, K key4, long value4, K key5, long value5) {
        MutableObjectLongMap mutableObjectLongMap = new MutableObjectLongMap(0, 1, 0);
        androidx.collection.MutableObjectLongMap num = mutableObjectLongMap;
        Object obj = key1;
        num.set(obj, value1);
        num.set(value2, key3);
        num.set(key4, value4);
        num.set(value5, obj27);
        final int i5 = i3;
        num.set(obj29, obj30);
        return (ObjectLongMap)mutableObjectLongMap;
    }
}
