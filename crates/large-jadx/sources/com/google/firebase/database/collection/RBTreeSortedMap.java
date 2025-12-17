package com.google.firebase.database.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/* loaded from: classes2.dex */
public class RBTreeSortedMap<K, V>  extends com.google.firebase.database.collection.ImmutableSortedMap<K, V> {

    private Comparator<K> comparator;
    private com.google.firebase.database.collection.LLRBNode<K, V> root;

    private static class Builder {

        private final com.google.firebase.database.collection.ImmutableSortedMap.Builder.KeyTranslator<A, B> keyTranslator;
        private final List<A> keys;
        private com.google.firebase.database.collection.LLRBValueNode<A, C> leaf;
        private com.google.firebase.database.collection.LLRBValueNode<A, C> root;
        private final Map<B, C> values;
        private Builder(List<A> list, Map<B, C> map2, com.google.firebase.database.collection.ImmutableSortedMap.Builder.KeyTranslator<A, B> immutableSortedMap$Builder$KeyTranslator3) {
            super();
            this.keys = list;
            this.values = map2;
            this.keyTranslator = keyTranslator3;
        }

        private com.google.firebase.database.collection.LLRBNode<A, C> buildBalancedTree(int i, int i2) {
            if (i2 == 0) {
                return LLRBEmptyNode.getInstance();
            }
            if (i2 == 1) {
                Object obj4 = this.keys.get(i);
                int i5 = 0;
                LLRBBlackValueNode obj5 = new LLRBBlackValueNode(obj4, getValue(obj4), i5, i5);
                return obj5;
            }
            i2 /= 2;
            int i4 = i + obj5;
            Object obj = this.keys.get(i4);
            LLRBBlackValueNode lLRBBlackValueNode = new LLRBBlackValueNode(obj, getValue(obj), buildBalancedTree(i, obj5), buildBalancedTree(i4 + 1, obj5));
            return lLRBBlackValueNode;
        }

        public static <A, B, C> com.google.firebase.database.collection.RBTreeSortedMap<A, C> buildFrom(List<A> list, Map<B, C> map2, com.google.firebase.database.collection.ImmutableSortedMap.Builder.KeyTranslator<A, B> immutableSortedMap$Builder$KeyTranslator3, Comparator<A> comparator4) {
            int chunkSize;
            boolean isOne;
            int obj3;
            Object obj4;
            int obj5;
            RBTreeSortedMap.Builder builder = new RBTreeSortedMap.Builder(list, map2, keyTranslator3);
            Collections.sort(list, comparator4);
            obj4 = new RBTreeSortedMap.Builder.Base1_2(list.size());
            obj4 = obj4.iterator();
            obj3 = list.size();
            while (obj4.hasNext()) {
                obj5 = obj4.next();
                chunkSize = obj5.chunkSize;
                obj3 -= chunkSize;
                if (obj5.isOne) {
                } else {
                }
                builder.buildPennant(LLRBNode.Color.BLACK, chunkSize, obj3);
                obj5 = obj5.chunkSize;
                builder.buildPennant(LLRBNode.Color.RED, obj5, obj3 -= obj5);
                builder.buildPennant(LLRBNode.Color.BLACK, chunkSize, obj3);
            }
            if (builder.root == null) {
                obj4 = LLRBEmptyNode.getInstance();
            }
            obj3 = new RBTreeSortedMap(obj4, comparator4, 0);
            return obj3;
        }

        private void buildPennant(com.google.firebase.database.collection.LLRBNode.Color lLRBNode$Color, int i2, int i3) {
            Object value;
            com.google.firebase.database.collection.LLRBValueNode obj3;
            com.google.firebase.database.collection.LLRBValueNode obj4;
            obj4 = buildBalancedTree(i3 + 1, i2--);
            final Object obj5 = this.keys.get(i3);
            final int i4 = 0;
            if (color == LLRBNode.Color.RED) {
                obj3 = new LLRBRedValueNode(obj5, getValue(obj5), i4, obj4);
            } else {
                obj3 = new LLRBBlackValueNode(obj5, getValue(obj5), i4, obj4);
            }
            if (this.root == null) {
                this.root = obj3;
                this.leaf = obj3;
            } else {
                this.leaf.setLeft(obj3);
                this.leaf = obj3;
            }
        }

        private C getValue(A a) {
            return this.values.get(this.keyTranslator.translate(a));
        }
    }
    private RBTreeSortedMap(com.google.firebase.database.collection.LLRBNode<K, V> lLRBNode, Comparator<K> comparator2) {
        super();
        this.root = lLRBNode;
        this.comparator = comparator2;
    }

    RBTreeSortedMap(com.google.firebase.database.collection.LLRBNode lLRBNode, Comparator comparator2, com.google.firebase.database.collection.RBTreeSortedMap.1 rBTreeSortedMap$13) {
        super(lLRBNode, comparator2);
    }

    RBTreeSortedMap(Comparator<K> comparator) {
        super();
        this.root = LLRBEmptyNode.getInstance();
        this.comparator = comparator;
    }

    public static <A, B, C> com.google.firebase.database.collection.RBTreeSortedMap<A, C> buildFrom(List<A> list, Map<B, C> map2, com.google.firebase.database.collection.ImmutableSortedMap.Builder.KeyTranslator<A, B> immutableSortedMap$Builder$KeyTranslator3, Comparator<A> comparator4) {
        return RBTreeSortedMap.Builder.buildFrom(list, map2, keyTranslator3, comparator4);
    }

    public static <A, B> com.google.firebase.database.collection.RBTreeSortedMap<A, B> fromMap(Map<A, B> map, Comparator<A> comparator2) {
        ArrayList arrayList = new ArrayList(map.keySet());
        return RBTreeSortedMap.Builder.buildFrom(arrayList, map, ImmutableSortedMap.Builder.identityTranslator(), comparator2);
    }

    private com.google.firebase.database.collection.LLRBNode<K, V> getNode(K k) {
        com.google.firebase.database.collection.LLRBNode right;
        int compare;
        Object key;
        right = this.root;
        while (!right.isEmpty()) {
            compare = this.comparator.compare(k, right.getKey());
            right = right.getRight();
            right = right.getLeft();
        }
        return 0;
    }

    public boolean containsKey(K k) {
        int obj1;
        obj1 = getNode(k) != null ? 1 : 0;
        return obj1;
    }

    public V get(K k) {
        Object obj1;
        obj1 = getNode(k);
        if (obj1 != null) {
            obj1 = obj1.getValue();
        } else {
            obj1 = 0;
        }
        return obj1;
    }

    public Comparator<K> getComparator() {
        return this.comparator;
    }

    public K getMaxKey() {
        return this.root.getMax().getKey();
    }

    public K getMinKey() {
        return this.root.getMin().getKey();
    }

    public K getPredecessorKey(K k) {
        com.google.firebase.database.collection.LLRBNode empty;
        int i;
        int compare;
        Object key;
        com.google.firebase.database.collection.LLRBNode lLRBNode;
        com.google.firebase.database.collection.LLRBNode obj7;
        empty = this.root;
        int i2 = 0;
        i = i2;
        while (!empty.isEmpty()) {
            compare = this.comparator.compare(k, empty.getKey());
            if (compare < 0) {
            } else {
            }
            i = empty;
            empty = lLRBNode;
            empty = empty.getLeft();
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Couldn't find predecessor key of non-present key: ");
        stringBuilder.append(k);
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.toString());
        throw illegalArgumentException;
    }

    com.google.firebase.database.collection.LLRBNode<K, V> getRoot() {
        return this.root;
    }

    public K getSuccessorKey(K k) {
        com.google.firebase.database.collection.LLRBNode right;
        int i;
        int compare;
        Object key;
        com.google.firebase.database.collection.LLRBNode lLRBNode;
        com.google.firebase.database.collection.LLRBNode obj7;
        right = this.root;
        int i2 = 0;
        i = i2;
        while (!right.isEmpty()) {
            compare = this.comparator.compare(right.getKey(), k);
            if (compare < 0) {
            } else {
            }
            i = right;
            right = lLRBNode;
            right = right.getRight();
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Couldn't find successor key of non-present key: ");
        stringBuilder.append(k);
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.toString());
        throw illegalArgumentException;
    }

    public void inOrderTraversal(com.google.firebase.database.collection.LLRBNode.NodeVisitor<K, V> lLRBNode$NodeVisitor) {
        this.root.inOrderTraversal(nodeVisitor);
    }

    public int indexOf(K k) {
        com.google.firebase.database.collection.LLRBNode right;
        int i;
        int compare;
        Object key;
        right = this.root;
        i = 0;
        while (!right.isEmpty()) {
            compare = this.comparator.compare(k, right.getKey());
            if (compare < 0) {
            } else {
            }
            i += compare;
            right = right.getRight();
            right = right.getLeft();
        }
        return -1;
    }

    public com.google.firebase.database.collection.ImmutableSortedMap<K, V> insert(K k, V v2) {
        RBTreeSortedMap obj10 = new RBTreeSortedMap(this.root.insert(k, v2, this.comparator).copy(0, 0, LLRBNode.Color.BLACK, 0, 0), this.comparator);
        return obj10;
    }

    @Override // com.google.firebase.database.collection.ImmutableSortedMap
    public boolean isEmpty() {
        return this.root.isEmpty();
    }

    public Iterator<Map.Entry<K, V>> iterator() {
        ImmutableSortedMapIterator immutableSortedMapIterator = new ImmutableSortedMapIterator(this.root, 0, this.comparator, 0);
        return immutableSortedMapIterator;
    }

    public Iterator<Map.Entry<K, V>> iteratorFrom(K k) {
        ImmutableSortedMapIterator immutableSortedMapIterator = new ImmutableSortedMapIterator(this.root, k, this.comparator, 0);
        return immutableSortedMapIterator;
    }

    public com.google.firebase.database.collection.ImmutableSortedMap<K, V> remove(K k) {
        if (!containsKey(k)) {
            return this;
        }
        RBTreeSortedMap rBTreeSortedMap = new RBTreeSortedMap(this.root.remove(k, this.comparator).copy(0, 0, LLRBNode.Color.BLACK, 0, 0), this.comparator);
        return rBTreeSortedMap;
    }

    public Iterator<Map.Entry<K, V>> reverseIterator() {
        ImmutableSortedMapIterator immutableSortedMapIterator = new ImmutableSortedMapIterator(this.root, 0, this.comparator, 1);
        return immutableSortedMapIterator;
    }

    public Iterator<Map.Entry<K, V>> reverseIteratorFrom(K k) {
        ImmutableSortedMapIterator immutableSortedMapIterator = new ImmutableSortedMapIterator(this.root, k, this.comparator, 1);
        return immutableSortedMapIterator;
    }

    @Override // com.google.firebase.database.collection.ImmutableSortedMap
    public int size() {
        return this.root.size();
    }
}
