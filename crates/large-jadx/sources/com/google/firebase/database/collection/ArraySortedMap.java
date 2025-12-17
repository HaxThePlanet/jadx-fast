package com.google.firebase.database.collection;

import java.util.AbstractMap.SimpleImmutableEntry;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/* loaded from: classes2.dex */
public class ArraySortedMap<K, V>  extends com.google.firebase.database.collection.ImmutableSortedMap<K, V> {

    private final Comparator<K> comparator;
    private final K[] keys;
    private final V[] values;
    public ArraySortedMap(Comparator<K> comparator) {
        super();
        int i = 0;
        this.keys = new Object[i];
        this.values = new Object[i];
        this.comparator = comparator;
    }

    private ArraySortedMap(Comparator<K> comparator, K[] k2Arr2, V[] v3Arr3) {
        super();
        this.keys = k2Arr2;
        this.values = v3Arr3;
        this.comparator = comparator;
    }

    static Object[] access$000(com.google.firebase.database.collection.ArraySortedMap arraySortedMap) {
        return arraySortedMap.keys;
    }

    static Object[] access$100(com.google.firebase.database.collection.ArraySortedMap arraySortedMap) {
        return arraySortedMap.values;
    }

    private static <T> T[] addToArray(T[] tArr, int i2, T t3) {
        length++;
        final Object[] arr = new Object[i];
        final int i5 = 0;
        System.arraycopy(tArr, i5, arr, i5, i2);
        arr[i2] = t3;
        System.arraycopy(tArr, i2, arr, i2 + 1, i3--);
        return arr;
    }

    public static <A, B, C> com.google.firebase.database.collection.ArraySortedMap<A, C> buildFrom(List<A> list, Map<B, C> map2, com.google.firebase.database.collection.ImmutableSortedMap.Builder.KeyTranslator<A, B> immutableSortedMap$Builder$KeyTranslator3, Comparator<A> comparator4) {
        int i;
        Object obj;
        Collections.sort(list, comparator4);
        int size = list.size();
        final Object[] arr2 = new Object[size];
        Object[] arr = new Object[size];
        Iterator obj4 = list.iterator();
        i = 0;
        for (Object next2 : obj4) {
            arr2[i] = next2;
            arr[i] = map2.get(keyTranslator3.translate(next2));
            i++;
        }
        obj4 = new ArraySortedMap(comparator4, arr2, arr);
        return obj4;
    }

    private int findKey(K k) {
        int i;
        int i2;
        int compare;
        Comparator comparator;
        final Object[] keys = this.keys;
        i2 = i;
        while (i < keys.length) {
            i2++;
            i++;
        }
        return -1;
    }

    private int findKeyOrInsertPosition(K k) {
        int i;
        int compare;
        Comparator comparator;
        i = 0;
        compare = this.keys;
        while (i < compare.length) {
            if (this.comparator.compare(compare[i], k) < 0) {
            }
            i++;
            compare = this.keys;
        }
        return i;
    }

    public static <K, V> com.google.firebase.database.collection.ArraySortedMap<K, V> fromMap(Map<K, V> map, Comparator<K> comparator2) {
        ArrayList arrayList = new ArrayList(map.keySet());
        return ArraySortedMap.buildFrom(arrayList, map, ImmutableSortedMap.Builder.identityTranslator(), comparator2);
    }

    private Iterator<Map.Entry<K, V>> iterator(int i, boolean z2) {
        ArraySortedMap.1 anon = new ArraySortedMap.1(this, i, z2);
        return anon;
    }

    private static <T> T[] removeFromArray(T[] tArr, int i2) {
        length--;
        final Object[] arr = new Object[i];
        int i4 = 0;
        System.arraycopy(tArr, i4, arr, i4, i2);
        System.arraycopy(tArr, i2 + 1, arr, i2, i -= i2);
        return arr;
    }

    private static <T> T[] replaceInArray(T[] tArr, int i2, T t3) {
        final int length = tArr.length;
        final Object[] arr = new Object[length];
        final int i = 0;
        System.arraycopy(tArr, i, arr, i, length);
        arr[i2] = t3;
        return arr;
    }

    public boolean containsKey(K k) {
        int obj2;
        obj2 = findKey(k) != -1 ? 1 : 0;
        return obj2;
    }

    public V get(K k) {
        Object[] values;
        Object obj2;
        obj2 = findKey(k);
        obj2 = obj2 != -1 ? values[obj2] : 0;
        return obj2;
    }

    public Comparator<K> getComparator() {
        return this.comparator;
    }

    public K getMaxKey() {
        Object obj;
        int length;
        Object[] keys = this.keys;
        if (keys.length > 0) {
            obj = keys[length2--];
        } else {
            obj = 0;
        }
        return obj;
    }

    public K getMinKey() {
        Object obj;
        int length;
        Object[] keys = this.keys;
        obj = keys.length > 0 ? keys[length] : 0;
        return obj;
    }

    public K getPredecessorKey(K k) {
        int keys;
        int obj2;
        obj2 = findKey(k);
        if (obj2 == -1) {
        } else {
            if (obj2 > 0) {
                obj2 = this.keys[obj2--];
            } else {
                obj2 = 0;
            }
            return obj2;
        }
        obj2 = new IllegalArgumentException("Can't find predecessor of nonexistent key");
        throw obj2;
    }

    public K getSuccessorKey(K k) {
        int obj3;
        obj3 = findKey(k);
        if (obj3 == -1) {
        } else {
            Object[] keys = this.keys;
            obj3 = obj3 < length-- ? keys[obj3] : 0;
            return obj3;
        }
        obj3 = new IllegalArgumentException("Can't find successor of nonexistent key");
        throw obj3;
    }

    public void inOrderTraversal(com.google.firebase.database.collection.LLRBNode.NodeVisitor<K, V> lLRBNode$NodeVisitor) {
        int i;
        Object obj;
        Object obj2;
        i = 0;
        Object[] keys = this.keys;
        for (Object obj : obj1) {
            nodeVisitor.visitEntry(obj, this.values[i]);
            keys = this.keys;
        }
    }

    public int indexOf(K k) {
        return findKey(k);
    }

    public com.google.firebase.database.collection.ImmutableSortedMap<K, V> insert(K k, V v2) {
        int i;
        Object obj3;
        Object obj;
        Object obj2;
        int key = findKey(k);
        Object[] keys4 = this.keys;
        if (key != -1 && keys4[key] == k && this.values[key] == v2) {
            keys4 = this.keys;
            if (keys4[key] == k) {
                if (this.values[key] == v2) {
                    return this;
                }
            }
            ArraySortedMap arraySortedMap2 = new ArraySortedMap(this.comparator, ArraySortedMap.replaceInArray(keys4, key, k), ArraySortedMap.replaceInArray(this.values, key, v2));
            return arraySortedMap2;
        }
        if (keys.length > 25) {
            HashMap hashMap = new HashMap(length2++);
            i = 0;
            Object[] keys5 = this.keys;
            for (Object obj3 : obj2) {
                hashMap.put(obj3, this.values[i]);
                keys5 = this.keys;
            }
            hashMap.put(k, v2);
            return RBTreeSortedMap.fromMap(hashMap, this.comparator);
        }
        int keyOrInsertPosition = findKeyOrInsertPosition(k);
        ArraySortedMap arraySortedMap = new ArraySortedMap(this.comparator, ArraySortedMap.addToArray(this.keys, keyOrInsertPosition, k), ArraySortedMap.addToArray(this.values, keyOrInsertPosition, v2));
        return arraySortedMap;
    }

    @Override // com.google.firebase.database.collection.ImmutableSortedMap
    public boolean isEmpty() {
        int i;
        i = keys.length == 0 ? 1 : 0;
        return i;
    }

    public Iterator<Map.Entry<K, V>> iterator() {
        int i = 0;
        return iterator(i, i);
    }

    public Iterator<Map.Entry<K, V>> iteratorFrom(K k) {
        return iterator(findKeyOrInsertPosition(k), false);
    }

    public com.google.firebase.database.collection.ImmutableSortedMap<K, V> remove(K k) {
        int obj4 = findKey(k);
        if (obj4 == -1) {
            return this;
        }
        ArraySortedMap arraySortedMap = new ArraySortedMap(this.comparator, ArraySortedMap.removeFromArray(this.keys, obj4), ArraySortedMap.removeFromArray(this.values, obj4));
        return arraySortedMap;
    }

    public Iterator<Map.Entry<K, V>> reverseIterator() {
        final int i2 = 1;
        return iterator(length -= i2, i2);
    }

    public Iterator<Map.Entry<K, V>> reverseIteratorFrom(K k) {
        Object[] keys;
        int comparator;
        Object obj5;
        int keyOrInsertPosition = findKeyOrInsertPosition(k);
        keys = this.keys;
        final int i2 = 1;
        if (keyOrInsertPosition < keys.length && this.comparator.compare(keys[keyOrInsertPosition], k) == 0) {
            if (this.comparator.compare(keys[keyOrInsertPosition], k) == 0) {
                return iterator(keyOrInsertPosition, i2);
            }
        }
        return iterator(keyOrInsertPosition -= i2, i2);
    }

    @Override // com.google.firebase.database.collection.ImmutableSortedMap
    public int size() {
        return keys.length;
    }
}
