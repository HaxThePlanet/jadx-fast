package com.google.gson.internal;

import java.io.Serializable;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Arrays;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;

/* loaded from: classes2.dex */
public final class LinkedHashTreeMap<K, V>  extends AbstractMap<K, V> implements Serializable {

    static final boolean $assertionsDisabled;
    private static final Comparator<Comparable> NATURAL_ORDER;
    Comparator<? super K> comparator;
    private com.google.gson.internal.LinkedHashTreeMap.EntrySet<K, V> entrySet;
    final com.google.gson.internal.LinkedHashTreeMap.Node<K, V> header;
    private com.google.gson.internal.LinkedHashTreeMap.KeySet<K, V> keySet;
    int modCount;
    int size;
    com.google.gson.internal.LinkedHashTreeMap.Node<K, V>[] table;
    int threshold;

    static final class AvlBuilder {

        private int leavesSkipped;
        private int leavesToSkip;
        private int size;
        private com.google.gson.internal.LinkedHashTreeMap.Node<K, V> stack;
        void add(com.google.gson.internal.LinkedHashTreeMap.Node<K, V> linkedHashTreeMap$Node) {
            int leavesToSkip;
            int leavesSkipped;
            int parent;
            int parent2;
            int i;
            int obj6;
            int i2 = 0;
            node.right = i2;
            node.parent = i2;
            node.left = i2;
            int i3 = 1;
            node.height = i3;
            leavesToSkip = this.leavesToSkip;
            parent = this.size;
            if (leavesToSkip > 0 && parent & 1 == 0) {
                parent = this.size;
                if (parent & 1 == 0) {
                    this.size = parent += i3;
                    this.leavesToSkip = leavesToSkip -= i3;
                    this.leavesSkipped = leavesSkipped2 += i3;
                }
            }
            node.parent = this.stack;
            this.stack = node;
            obj6 += i3;
            this.size = obj6;
            leavesSkipped = this.leavesToSkip;
            if (leavesSkipped > 0 && obj6 & 1 == 0) {
                if (obj6 & 1 == 0) {
                    this.size = obj6 += i3;
                    this.leavesToSkip = leavesSkipped -= i3;
                    this.leavesSkipped = obj6 += i3;
                }
            }
            obj6 = 4;
            int i6 = obj6 + -1;
            while (size &= i6 == i6) {
                leavesSkipped = this.leavesSkipped;
                if (leavesSkipped == 0) {
                } else {
                }
                parent = 0;
                if (leavesSkipped == i3) {
                } else {
                }
                if (leavesSkipped == 2) {
                }
                obj6 *= 2;
                i6 = obj6 + -1;
                this.leavesSkipped = parent;
                leavesSkipped = this.stack;
                parent2 = leavesSkipped.parent;
                this.stack = parent2;
                parent2.right = leavesSkipped;
                parent2.height = height2 += i3;
                leavesSkipped.parent = parent2;
                this.leavesSkipped = parent;
                leavesSkipped = this.stack;
                parent = leavesSkipped.parent;
                parent2 = parent.parent;
                parent.parent = parent2.parent;
                this.stack = parent;
                parent.left = parent2;
                parent.right = leavesSkipped;
                parent.height = height += i3;
                parent2.parent = parent;
                leavesSkipped.parent = parent;
            }
        }

        void reset(int i) {
            this.leavesToSkip = i3 -= i;
            int obj2 = 0;
            this.size = obj2;
            this.leavesSkipped = obj2;
            this.stack = 0;
        }

        com.google.gson.internal.LinkedHashTreeMap.Node<K, V> root() {
            com.google.gson.internal.LinkedHashTreeMap.Node stack = this.stack;
            if (stack.parent != null) {
            } else {
                return stack;
            }
            IllegalStateException illegalStateException = new IllegalStateException();
            throw illegalStateException;
        }
    }

    static class AvlIterator {

        private com.google.gson.internal.LinkedHashTreeMap.Node<K, V> stackTop;
        public com.google.gson.internal.LinkedHashTreeMap.Node<K, V> next() {
            com.google.gson.internal.LinkedHashTreeMap.Node right;
            com.google.gson.internal.LinkedHashTreeMap.Node parent;
            com.google.gson.internal.LinkedHashTreeMap.Node map;
            final com.google.gson.internal.LinkedHashTreeMap.Node stackTop = this.stackTop;
            int i = 0;
            if (stackTop == null) {
                return i;
            }
            parent = stackTop.parent;
            stackTop.parent = i;
            right = stackTop.right;
            parent = right;
            com.google.gson.internal.LinkedHashTreeMap.Node map2 = map;
            while (parent != null) {
                parent.parent = map2;
                right = parent.left;
                parent = right;
                map2 = map;
            }
            this.stackTop = map2;
            return stackTop;
        }

        void reset(com.google.gson.internal.LinkedHashTreeMap.Node<K, V> linkedHashTreeMap$Node) {
            int i;
            com.google.gson.internal.LinkedHashTreeMap.Node map;
            Object obj3;
            i = 0;
            while (obj3 != null) {
                obj3.parent = i;
                i = obj3;
                obj3 = map;
            }
            this.stackTop = i;
        }
    }

    final class EntrySet extends AbstractSet<Map.Entry<K, V>> {

        final com.google.gson.internal.LinkedHashTreeMap this$0;
        EntrySet(com.google.gson.internal.LinkedHashTreeMap linkedHashTreeMap) {
            this.this$0 = linkedHashTreeMap;
            super();
        }

        @Override // java.util.AbstractSet
        public void clear() {
            this.this$0.clear();
        }

        @Override // java.util.AbstractSet
        public boolean contains(Object object) {
            boolean this$0;
            Object obj2;
            if (object instanceof Map.Entry && this.this$0.findByEntry((Map.Entry)object) != null) {
                obj2 = this.this$0.findByEntry((Map.Entry)object) != null ? 1 : 0;
            } else {
            }
            return obj2;
        }

        public Iterator<Map.Entry<K, V>> iterator() {
            LinkedHashTreeMap.EntrySet.1 anon = new LinkedHashTreeMap.EntrySet.1(this);
            return anon;
        }

        @Override // java.util.AbstractSet
        public boolean remove(Object object) {
            int i = 0;
            if (!object instanceof Map.Entry) {
                return i;
            }
            final com.google.gson.internal.LinkedHashTreeMap.Node obj3 = this.this$0.findByEntry((Map.Entry)object);
            if (obj3 == null) {
                return i;
            }
            int i2 = 1;
            this.this$0.removeInternal(obj3, i2);
            return i2;
        }

        @Override // java.util.AbstractSet
        public int size() {
            return this$0.size;
        }
    }

    final class KeySet extends AbstractSet<K> {

        final com.google.gson.internal.LinkedHashTreeMap this$0;
        KeySet(com.google.gson.internal.LinkedHashTreeMap linkedHashTreeMap) {
            this.this$0 = linkedHashTreeMap;
            super();
        }

        @Override // java.util.AbstractSet
        public void clear() {
            this.this$0.clear();
        }

        @Override // java.util.AbstractSet
        public boolean contains(Object object) {
            return this.this$0.containsKey(object);
        }

        public Iterator<K> iterator() {
            LinkedHashTreeMap.KeySet.1 anon = new LinkedHashTreeMap.KeySet.1(this);
            return anon;
        }

        @Override // java.util.AbstractSet
        public boolean remove(Object object) {
            int obj2;
            obj2 = this.this$0.removeInternalByKey(object) != null ? 1 : 0;
            return obj2;
        }

        @Override // java.util.AbstractSet
        public int size() {
            return this$0.size;
        }
    }

    private abstract class LinkedTreeMapIterator implements Iterator<T> {

        int expectedModCount;
        com.google.gson.internal.LinkedHashTreeMap.Node<K, V> lastReturned = null;
        com.google.gson.internal.LinkedHashTreeMap.Node<K, V> next;
        final com.google.gson.internal.LinkedHashTreeMap this$0;
        LinkedTreeMapIterator(com.google.gson.internal.LinkedHashTreeMap linkedHashTreeMap) {
            this.this$0 = linkedHashTreeMap;
            super();
            this.next = header.next;
            int i = 0;
            this.expectedModCount = linkedHashTreeMap.modCount;
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            int i;
            i = this.next != this$0.header ? 1 : 0;
            return i;
        }

        final com.google.gson.internal.LinkedHashTreeMap.Node<K, V> nextNode() {
            com.google.gson.internal.LinkedHashTreeMap.Node next = this.next;
            com.google.gson.internal.LinkedHashTreeMap this$0 = this.this$0;
            if (next == this$0.header) {
            } else {
                if (this$0.modCount != this.expectedModCount) {
                } else {
                    this.next = next.next;
                    this.lastReturned = next;
                    return next;
                }
                ConcurrentModificationException concurrentModificationException = new ConcurrentModificationException();
                throw concurrentModificationException;
            }
            NoSuchElementException noSuchElementException = new NoSuchElementException();
            throw noSuchElementException;
        }

        @Override // java.util.Iterator
        public final void remove() {
            com.google.gson.internal.LinkedHashTreeMap.Node lastReturned = this.lastReturned;
            if (lastReturned == null) {
            } else {
                this.this$0.removeInternal(lastReturned, true);
                this.lastReturned = 0;
                this.expectedModCount = this$0.modCount;
            }
            IllegalStateException illegalStateException = new IllegalStateException();
            throw illegalStateException;
        }
    }

    static final class Node implements Map.Entry<K, V> {

        final int hash;
        int height;
        final K key;
        com.google.gson.internal.LinkedHashTreeMap.Node<K, V> left;
        com.google.gson.internal.LinkedHashTreeMap.Node<K, V> next;
        com.google.gson.internal.LinkedHashTreeMap.Node<K, V> parent;
        com.google.gson.internal.LinkedHashTreeMap.Node<K, V> prev;
        com.google.gson.internal.LinkedHashTreeMap.Node<K, V> right;
        V value;
        Node() {
            super();
            this.key = 0;
            this.hash = -1;
            this.prev = this;
            this.next = this;
        }

        Node(com.google.gson.internal.LinkedHashTreeMap.Node<K, V> linkedHashTreeMap$Node, K k2, int i3, com.google.gson.internal.LinkedHashTreeMap.Node<K, V> linkedHashTreeMap$Node4, com.google.gson.internal.LinkedHashTreeMap.Node<K, V> linkedHashTreeMap$Node5) {
            super();
            this.parent = node;
            this.key = k2;
            this.hash = i3;
            this.height = 1;
            this.next = node4;
            this.prev = node5;
            node5.next = this;
            node4.prev = this;
        }

        @Override // java.util.Map$Entry
        public boolean equals(Object object) {
            boolean equals;
            int i;
            Object key;
            Object obj4;
            i = 0;
            if (object instanceof Map.Entry) {
                Object key2 = this.key;
                if (key2 == null) {
                    if ((Map.Entry)object.getKey() == null) {
                        equals = this.value;
                        if (equals == null) {
                            if (object.getValue() == null) {
                                i = 1;
                            }
                        } else {
                            if (equals.equals(object.getValue())) {
                            }
                        }
                    }
                } else {
                    if (key2.equals(object.getKey())) {
                    }
                }
            }
            return i;
        }

        public com.google.gson.internal.LinkedHashTreeMap.Node<K, V> first() {
            com.google.gson.internal.LinkedHashTreeMap.Node left;
            Object obj;
            com.google.gson.internal.LinkedHashTreeMap.Node map;
            left = this.left;
            obj = this;
            while (left != null) {
                obj = left;
                left = map;
            }
            return obj;
        }

        public K getKey() {
            return this.key;
        }

        public V getValue() {
            return this.value;
        }

        @Override // java.util.Map$Entry
        public int hashCode() {
            int i2;
            int i;
            Object key = this.key;
            if (key == null) {
                i2 = i;
            } else {
                i2 = key.hashCode();
            }
            final Object value = this.value;
            if (value == null) {
            } else {
                i = value.hashCode();
            }
            return i2 ^= i;
        }

        public com.google.gson.internal.LinkedHashTreeMap.Node<K, V> last() {
            com.google.gson.internal.LinkedHashTreeMap.Node right;
            Object obj;
            com.google.gson.internal.LinkedHashTreeMap.Node map;
            right = this.right;
            obj = this;
            while (right != null) {
                obj = right;
                right = map;
            }
            return obj;
        }

        public V setValue(V v) {
            this.value = v;
            return this.value;
        }

        @Override // java.util.Map$Entry
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.key);
            stringBuilder.append("=");
            stringBuilder.append(this.value);
            return stringBuilder.toString();
        }
    }
    static {
        Class<com.google.gson.internal.LinkedHashTreeMap> obj = LinkedHashTreeMap.class;
        LinkedHashTreeMap.1 anon = new LinkedHashTreeMap.1();
        LinkedHashTreeMap.NATURAL_ORDER = anon;
    }

    public LinkedHashTreeMap() {
        super(LinkedHashTreeMap.NATURAL_ORDER);
    }

    public LinkedHashTreeMap(Comparator<? super K> comparator) {
        Comparator obj2;
        super();
        int i = 0;
        this.size = i;
        this.modCount = i;
        if (comparator != null) {
        } else {
            obj2 = LinkedHashTreeMap.NATURAL_ORDER;
        }
        this.comparator = obj2;
        obj2 = new LinkedHashTreeMap.Node();
        this.header = obj2;
        obj2 = new LinkedHashTreeMap.Node[16];
        this.table = obj2;
        this.threshold = i2 += obj2;
    }

    private void doubleCapacity() {
        com.google.gson.internal.LinkedHashTreeMap.Node[] doubleCapacity = LinkedHashTreeMap.doubleCapacity(this.table);
        this.table = doubleCapacity;
        this.threshold = i2 += i;
    }

    static <K, V> com.google.gson.internal.LinkedHashTreeMap.Node<K, V>[] doubleCapacity(com.google.gson.internal.LinkedHashTreeMap.Node<K, V>[] linkedHashTreeMap$NodeArr) {
        int i;
        Object next;
        int i2;
        int i3;
        com.google.gson.internal.LinkedHashTreeMap.Node root;
        int i4;
        com.google.gson.internal.LinkedHashTreeMap.Node next2;
        final int length = nodeArr.length;
        com.google.gson.internal.LinkedHashTreeMap.Node[] arr = new LinkedHashTreeMap.Node[length * 2];
        LinkedHashTreeMap.AvlIterator avlIterator = new LinkedHashTreeMap.AvlIterator();
        LinkedHashTreeMap.AvlBuilder avlBuilder = new LinkedHashTreeMap.AvlBuilder();
        LinkedHashTreeMap.AvlBuilder avlBuilder2 = new LinkedHashTreeMap.AvlBuilder();
        final int i6 = 0;
        i = i6;
        while (i < length) {
            next = nodeArr[i];
            if (next == null) {
            } else {
            }
            avlIterator.reset(next);
            i4 = i3;
            next2 = avlIterator.next();
            while (next2 != null) {
                if (hash &= length == 0) {
                } else {
                }
                i4++;
                next2 = avlIterator.next();
                i3++;
            }
            avlBuilder.reset(i3);
            avlBuilder2.reset(i4);
            avlIterator.reset(next);
            next = avlIterator.next();
            while (next != null) {
                if (hash2 &= length == null) {
                } else {
                }
                avlBuilder2.add(next);
                next = avlIterator.next();
                avlBuilder.add(next);
            }
            if (i3 > 0) {
            } else {
            }
            root = next;
            arr[i] = root;
            if (i4 > 0) {
            }
            arr[i + length] = next;
            i++;
            next = avlBuilder2.root();
            root = avlBuilder.root();
            if (hash2 &= length == null) {
            } else {
            }
            avlBuilder2.add(next);
            avlBuilder.add(next);
            if (hash &= length == 0) {
            } else {
            }
            i4++;
            i3++;
        }
        return arr;
    }

    private boolean equal(Object object, Object object2) {
        boolean obj1;
        if (object != object2) {
            if (object != null && object.equals(object2)) {
                if (object.equals(object2)) {
                    obj1 = 1;
                } else {
                    obj1 = 0;
                }
            } else {
            }
        } else {
        }
        return obj1;
    }

    private void rebalance(com.google.gson.internal.LinkedHashTreeMap.Node<K, V> linkedHashTreeMap$Node, boolean z2) {
        com.google.gson.internal.LinkedHashTreeMap.Node left;
        com.google.gson.internal.LinkedHashTreeMap.Node right;
        int height3;
        int height;
        int height2;
        int i;
        int i2;
        while (node != null) {
            left = node.left;
            right = node.right;
            height3 = 0;
            if (left != null) {
            } else {
            }
            height = height3;
            if (right != null) {
            } else {
            }
            height2 = height3;
            i = height - height2;
            i2 = 1;
            node.height = i3 += i2;
            final com.google.gson.internal.LinkedHashTreeMap.Node obj8 = node.parent;
            node.height = height++;
            right = left.left;
            com.google.gson.internal.LinkedHashTreeMap.Node right2 = left.right;
            if (right2 != null) {
            } else {
            }
            height = height3;
            if (right != null) {
            }
            height3 -= height;
            if (height3 != i2) {
            } else {
            }
            rotateRight(node);
            if (height3 == 0 && !z2) {
            } else {
            }
            rotateLeft(left);
            rotateRight(node);
            if (!z2) {
            } else {
            }
            height3 = right.height;
            height = right2.height;
            com.google.gson.internal.LinkedHashTreeMap.Node left2 = right.left;
            com.google.gson.internal.LinkedHashTreeMap.Node right3 = right.right;
            if (right3 != null) {
            } else {
            }
            height = height3;
            if (left2 != null) {
            }
            height3 -= height;
            if (height3 != -1) {
            } else {
            }
            rotateLeft(node);
            if (height3 == 0 && !z2) {
            } else {
            }
            rotateRight(right);
            rotateLeft(node);
            if (!z2) {
            } else {
            }
            height3 = left2.height;
            height = right3.height;
            height2 = right.height;
            height = left.height;
        }
    }

    private void replaceInParent(com.google.gson.internal.LinkedHashTreeMap.Node<K, V> linkedHashTreeMap$Node, com.google.gson.internal.LinkedHashTreeMap.Node<K, V> linkedHashTreeMap$Node2) {
        com.google.gson.internal.LinkedHashTreeMap.Node parent;
        com.google.gson.internal.LinkedHashTreeMap.Node left;
        Object obj3;
        parent = node.parent;
        node.parent = 0;
        if (node2 != null) {
            node2.parent = parent;
        }
        if (parent != null) {
            if (parent.left == node) {
                parent.left = node2;
            } else {
                parent.right = node2;
            }
        } else {
            parent = this.table;
            parent[obj3 &= left] = node2;
        }
    }

    private void rotateLeft(com.google.gson.internal.LinkedHashTreeMap.Node<K, V> linkedHashTreeMap$Node) {
        int height;
        int height3;
        int height2;
        com.google.gson.internal.LinkedHashTreeMap.Node left = node.left;
        final com.google.gson.internal.LinkedHashTreeMap.Node right = node.right;
        com.google.gson.internal.LinkedHashTreeMap.Node left2 = right.left;
        final com.google.gson.internal.LinkedHashTreeMap.Node right2 = right.right;
        node.right = left2;
        if (left2 != null) {
            left2.parent = node;
        }
        replaceInParent(node, right);
        right.left = node;
        node.parent = right;
        height2 = 0;
        height = left != null ? left.height : height2;
        height3 = left2 != null ? left2.height : height2;
        i++;
        node.height = i2;
        if (right2 != null) {
            height2 = right2.height;
        }
        right.height = obj6++;
    }

    private void rotateRight(com.google.gson.internal.LinkedHashTreeMap.Node<K, V> linkedHashTreeMap$Node) {
        int height2;
        int height3;
        int height;
        final com.google.gson.internal.LinkedHashTreeMap.Node left = node.left;
        com.google.gson.internal.LinkedHashTreeMap.Node right = node.right;
        final com.google.gson.internal.LinkedHashTreeMap.Node left2 = left.left;
        com.google.gson.internal.LinkedHashTreeMap.Node right2 = left.right;
        node.left = right2;
        if (right2 != null) {
            right2.parent = node;
        }
        replaceInParent(node, left);
        left.right = node;
        node.parent = left;
        height = 0;
        height2 = right != null ? right.height : height;
        height3 = right2 != null ? right2.height : height;
        i++;
        node.height = i2;
        if (left2 != null) {
            height = left2.height;
        }
        left.height = obj6++;
    }

    private static int secondaryHash(int i) {
        i ^= i3;
        return obj2 ^= i5;
    }

    private Object writeReplace() {
        LinkedHashMap linkedHashMap = new LinkedHashMap(this);
        return linkedHashMap;
    }

    @Override // java.util.AbstractMap
    public void clear() {
        com.google.gson.internal.LinkedHashTreeMap.Node next;
        com.google.gson.internal.LinkedHashTreeMap.Node next2;
        final int i3 = 0;
        Arrays.fill(this.table, i3);
        this.size = 0;
        this.modCount = modCount++;
        com.google.gson.internal.LinkedHashTreeMap.Node header = this.header;
        next = header.next;
        while (next != header) {
            next.prev = i3;
            next.next = i3;
            next = next2;
        }
        header.prev = header;
        header.next = header;
    }

    @Override // java.util.AbstractMap
    public boolean containsKey(Object object) {
        int obj1;
        obj1 = findByObject(object) != null ? 1 : 0;
        return obj1;
    }

    public Set<Map.Entry<K, V>> entrySet() {
        com.google.gson.internal.LinkedHashTreeMap.EntrySet entrySet;
        if (this.entrySet != null) {
        } else {
            entrySet = new LinkedHashTreeMap.EntrySet(this);
            this.entrySet = entrySet;
        }
        return entrySet;
    }

    com.google.gson.internal.LinkedHashTreeMap.Node<K, V> find(K k, boolean z2) {
        com.google.gson.internal.LinkedHashTreeMap.Node map3;
        com.google.gson.internal.LinkedHashTreeMap.Node map;
        com.google.gson.internal.LinkedHashTreeMap.Node map2;
        int i;
        Object obj;
        int compareTo;
        com.google.gson.internal.LinkedHashTreeMap.Node right;
        com.google.gson.internal.LinkedHashTreeMap.Node prev;
        com.google.gson.internal.LinkedHashTreeMap.Node obj14;
        Comparator comparator = this.comparator;
        final com.google.gson.internal.LinkedHashTreeMap.Node[] table = this.table;
        final int secondaryHash = LinkedHashTreeMap.secondaryHash(k.hashCode());
        final int i7 = 1;
        i4 &= secondaryHash;
        int i6 = 0;
        if (table[i5] != null) {
            if (comparator == LinkedHashTreeMap.NATURAL_ORDER) {
                i = k;
            } else {
                i = i6;
            }
            while (i != 0) {
                compareTo = i.compareTo(map3.key);
                if (compareTo < 0) {
                } else {
                }
                right = map3.right;
                map3 = right;
                compareTo = comparator.compare(k, map3.key);
                right = map3.left;
            }
            return map3;
        }
        compareTo = 0;
        final com.google.gson.internal.LinkedHashTreeMap.Node map4 = map3;
        if (!z2) {
            return i6;
        }
        com.google.gson.internal.LinkedHashTreeMap.Node header = this.header;
        if (map4 == null) {
            if (comparator == LinkedHashTreeMap.NATURAL_ORDER) {
                if (!k instanceof Comparable) {
                } else {
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(k.getClass().getName());
                stringBuilder.append(" is not Comparable");
                obj14 = new ClassCastException(stringBuilder.toString());
                throw obj14;
            }
            super(map4, k, secondaryHash, header, header.prev);
            table[i5] = obj14;
        } else {
            super(map4, k, secondaryHash, header, header.prev);
            if (compareTo < 0) {
                map4.left = obj14;
            } else {
                map4.right = obj14;
            }
            rebalance(map4, i7);
        }
        int obj13 = this.size;
        this.size = obj13 + 1;
        if (obj13 > this.threshold) {
            doubleCapacity();
        }
        this.modCount = obj13 += i7;
        return obj14;
    }

    com.google.gson.internal.LinkedHashTreeMap.Node<K, V> findByEntry(Map.Entry<?, ?> map$Entry) {
        int byObject;
        Object value;
        boolean obj3;
        byObject = findByObject(entry.getKey());
        if (byObject != null && equal(byObject.value, entry.getValue())) {
            obj3 = equal(byObject.value, entry.getValue()) ? 1 : 0;
        } else {
        }
        if (obj3 != null) {
        } else {
            byObject = 0;
        }
        return byObject;
    }

    com.google.gson.internal.LinkedHashTreeMap.Node<K, V> findByObject(Object object) {
        int find;
        int i;
        find = 0;
        if (object != null) {
            find = find(object, false);
        }
        return find;
    }

    public V get(Object object) {
        Object obj1;
        obj1 = findByObject(object);
        obj1 = obj1 != null ? obj1.value : 0;
        return obj1;
    }

    public Set<K> keySet() {
        com.google.gson.internal.LinkedHashTreeMap.KeySet keySet;
        if (this.keySet != null) {
        } else {
            keySet = new LinkedHashTreeMap.KeySet(this);
            this.keySet = keySet;
        }
        return keySet;
    }

    public V put(K k, V v2) {
        Objects.requireNonNull(k, "key == null");
        final com.google.gson.internal.LinkedHashTreeMap.Node obj2 = find(k, true);
        obj2.value = v2;
        return obj2.value;
    }

    public V remove(Object object) {
        Object obj1;
        obj1 = removeInternalByKey(object);
        obj1 = obj1 != null ? obj1.value : 0;
        return obj1;
    }

    void removeInternal(com.google.gson.internal.LinkedHashTreeMap.Node<K, V> linkedHashTreeMap$Node, boolean z2) {
        com.google.gson.internal.LinkedHashTreeMap.Node next;
        int height2;
        int height;
        com.google.gson.internal.LinkedHashTreeMap.Node obj7;
        int i = 0;
        if (z2 != null) {
            obj7 = node.prev;
            obj7.next = node.next;
            next.prev = obj7;
            node.prev = i;
            node.next = i;
        }
        obj7 = node.left;
        com.google.gson.internal.LinkedHashTreeMap.Node right = node.right;
        height = 0;
        if (obj7 != null && right != null) {
            if (right != null) {
                if (obj7.height > right.height) {
                    obj7 = obj7.last();
                } else {
                    obj7 = right.first();
                }
                removeInternal(obj7, height);
                com.google.gson.internal.LinkedHashTreeMap.Node left = node.left;
                if (left != null) {
                    height2 = left.height;
                    obj7.left = left;
                    left.parent = obj7;
                    node.left = i;
                } else {
                    height2 = height;
                }
                com.google.gson.internal.LinkedHashTreeMap.Node right2 = node.right;
                if (right2 != null) {
                    height = right2.height;
                    obj7.right = right2;
                    right2.parent = obj7;
                    node.right = i;
                }
                obj7.height = i2++;
                replaceInParent(node, obj7);
            }
        }
        if (obj7 != null) {
            replaceInParent(node, obj7);
            node.left = i;
        } else {
            if (right != null) {
                replaceInParent(node, right);
                node.right = i;
            } else {
                replaceInParent(node, i);
            }
        }
        rebalance(node.parent, height);
        this.size = obj6--;
        this.modCount = obj6++;
    }

    com.google.gson.internal.LinkedHashTreeMap.Node<K, V> removeInternalByKey(Object object) {
        int i;
        final com.google.gson.internal.LinkedHashTreeMap.Node obj2 = findByObject(object);
        if (obj2 != null) {
            removeInternal(obj2, true);
        }
        return obj2;
    }

    @Override // java.util.AbstractMap
    public int size() {
        return this.size;
    }
}
