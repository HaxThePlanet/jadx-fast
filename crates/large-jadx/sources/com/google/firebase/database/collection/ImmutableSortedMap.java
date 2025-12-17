package com.google.firebase.database.collection;

import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/* loaded from: classes2.dex */
public abstract class ImmutableSortedMap<K, V>  implements Iterable<Map.Entry<K, V>> {

    public static class Builder {

        static final int ARRAY_TO_RB_TREE_SIZE_THRESHOLD = 25;
        private static final com.google.firebase.database.collection.ImmutableSortedMap.Builder.KeyTranslator IDENTITY_TRANSLATOR;
        static {
            ImmutableSortedMap.Builder.IDENTITY_TRANSLATOR = a.a;
        }

        static Object a(Object object) {
            return object;
        }

        public static <A, B, C> com.google.firebase.database.collection.ImmutableSortedMap<A, C> buildFrom(List<A> list, Map<B, C> map2, com.google.firebase.database.collection.ImmutableSortedMap.Builder.KeyTranslator<A, B> immutableSortedMap$Builder$KeyTranslator3, Comparator<A> comparator4) {
            if (list.size() < 25) {
                return ArraySortedMap.buildFrom(list, map2, keyTranslator3, comparator4);
            }
            return RBTreeSortedMap.buildFrom(list, map2, keyTranslator3, comparator4);
        }

        public static <K, V> com.google.firebase.database.collection.ImmutableSortedMap<K, V> emptyMap(Comparator<K> comparator) {
            ArraySortedMap arraySortedMap = new ArraySortedMap(comparator);
            return arraySortedMap;
        }

        public static <A, B> com.google.firebase.database.collection.ImmutableSortedMap<A, B> fromMap(Map<A, B> map, Comparator<A> comparator2) {
            if (map.size() < 25) {
                return ArraySortedMap.fromMap(map, comparator2);
            }
            return RBTreeSortedMap.fromMap(map, comparator2);
        }

        public static <A> com.google.firebase.database.collection.ImmutableSortedMap.Builder.KeyTranslator<A, A> identityTranslator() {
            return ImmutableSortedMap.Builder.IDENTITY_TRANSLATOR;
        }
    }
    public abstract boolean containsKey(K k);

    @Override // java.lang.Iterable
    public boolean equals(Object object) {
        int equals;
        Object next;
        final int i = 1;
        if (this == object) {
            return i;
        }
        final int i2 = 0;
        if (object instanceof ImmutableSortedMap == null) {
            return i2;
        }
        if (!getComparator().equals((ImmutableSortedMap)object.getComparator())) {
            return i2;
        }
        if (size() != object.size()) {
            return i2;
        }
        Iterator iterator = iterator();
        for (Map.Entry next3 : iterator) {
        }
        return i;
    }

    public abstract V get(K k);

    public abstract Comparator<K> getComparator();

    public abstract K getMaxKey();

    public abstract K getMinKey();

    public abstract K getPredecessorKey(K k);

    public abstract K getSuccessorKey(K k);

    @Override // java.lang.Iterable
    public int hashCode() {
        int i;
        int i2;
        i = getComparator().hashCode();
        final Iterator iterator = iterator();
        for (Map.Entry next2 : iterator) {
            i3 += i2;
        }
        return i;
    }

    public abstract void inOrderTraversal(com.google.firebase.database.collection.LLRBNode.NodeVisitor<K, V> lLRBNode$NodeVisitor);

    public abstract int indexOf(K k);

    public abstract com.google.firebase.database.collection.ImmutableSortedMap<K, V> insert(K k, V v2);

    @Override // java.lang.Iterable
    public abstract boolean isEmpty();

    public abstract Iterator<Map.Entry<K, V>> iterator();

    public abstract Iterator<Map.Entry<K, V>> iteratorFrom(K k);

    public abstract com.google.firebase.database.collection.ImmutableSortedMap<K, V> remove(K k);

    public abstract Iterator<Map.Entry<K, V>> reverseIterator();

    public abstract Iterator<Map.Entry<K, V>> reverseIteratorFrom(K k);

    @Override // java.lang.Iterable
    public abstract int size();

    @Override // java.lang.Iterable
    public String toString() {
        int i;
        String str;
        String str2;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(getClass().getSimpleName());
        stringBuilder.append("{");
        Iterator iterator = iterator();
        i = 1;
        while (iterator.hasNext()) {
            Object next2 = iterator.next();
            if (i != 0) {
            } else {
            }
            stringBuilder.append(", ");
            stringBuilder.append("(");
            stringBuilder.append((Map.Entry)next2.getKey());
            stringBuilder.append("=>");
            stringBuilder.append(next2.getValue());
            stringBuilder.append(")");
            i = 0;
        }
        stringBuilder.append("};");
        return stringBuilder.toString();
    }
}
