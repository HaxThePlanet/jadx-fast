package com.google.gson.internal;

import java.io.Serializable;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;

/* loaded from: classes2.dex */
public final class LinkedTreeMap<K, V>  extends AbstractMap<K, V> implements Serializable {

    static final boolean $assertionsDisabled;
    private static final Comparator<Comparable> NATURAL_ORDER;
    Comparator<? super K> comparator;
    private com.google.gson.internal.LinkedTreeMap.EntrySet<K, V> entrySet;
    final com.google.gson.internal.LinkedTreeMap.Node<K, V> header;
    private com.google.gson.internal.LinkedTreeMap.KeySet<K, V> keySet;
    int modCount;
    com.google.gson.internal.LinkedTreeMap.Node<K, V> root;
    int size;

    class EntrySet extends AbstractSet<Map.Entry<K, V>> {

        final com.google.gson.internal.LinkedTreeMap this$0;
        EntrySet(com.google.gson.internal.LinkedTreeMap linkedTreeMap) {
            this.this$0 = linkedTreeMap;
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
            LinkedTreeMap.EntrySet.1 anon = new LinkedTreeMap.EntrySet.1(this);
            return anon;
        }

        @Override // java.util.AbstractSet
        public boolean remove(Object object) {
            int i = 0;
            if (!object instanceof Map.Entry) {
                return i;
            }
            final com.google.gson.internal.LinkedTreeMap.Node obj3 = this.this$0.findByEntry((Map.Entry)object);
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

        final com.google.gson.internal.LinkedTreeMap this$0;
        KeySet(com.google.gson.internal.LinkedTreeMap linkedTreeMap) {
            this.this$0 = linkedTreeMap;
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
            LinkedTreeMap.KeySet.1 anon = new LinkedTreeMap.KeySet.1(this);
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
        com.google.gson.internal.LinkedTreeMap.Node<K, V> lastReturned = null;
        com.google.gson.internal.LinkedTreeMap.Node<K, V> next;
        final com.google.gson.internal.LinkedTreeMap this$0;
        LinkedTreeMapIterator(com.google.gson.internal.LinkedTreeMap linkedTreeMap) {
            this.this$0 = linkedTreeMap;
            super();
            this.next = header.next;
            int i = 0;
            this.expectedModCount = linkedTreeMap.modCount;
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            int i;
            i = this.next != this$0.header ? 1 : 0;
            return i;
        }

        final com.google.gson.internal.LinkedTreeMap.Node<K, V> nextNode() {
            com.google.gson.internal.LinkedTreeMap.Node next = this.next;
            com.google.gson.internal.LinkedTreeMap this$0 = this.this$0;
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
            com.google.gson.internal.LinkedTreeMap.Node lastReturned = this.lastReturned;
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

        int height;
        final K key;
        com.google.gson.internal.LinkedTreeMap.Node<K, V> left;
        com.google.gson.internal.LinkedTreeMap.Node<K, V> next;
        com.google.gson.internal.LinkedTreeMap.Node<K, V> parent;
        com.google.gson.internal.LinkedTreeMap.Node<K, V> prev;
        com.google.gson.internal.LinkedTreeMap.Node<K, V> right;
        V value;
        Node() {
            super();
            this.key = 0;
            this.prev = this;
            this.next = this;
        }

        Node(com.google.gson.internal.LinkedTreeMap.Node<K, V> linkedTreeMap$Node, K k2, com.google.gson.internal.LinkedTreeMap.Node<K, V> linkedTreeMap$Node3, com.google.gson.internal.LinkedTreeMap.Node<K, V> linkedTreeMap$Node4) {
            super();
            this.parent = node;
            this.key = k2;
            this.height = 1;
            this.next = node3;
            this.prev = node4;
            node4.next = this;
            node3.prev = this;
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

        public com.google.gson.internal.LinkedTreeMap.Node<K, V> first() {
            com.google.gson.internal.LinkedTreeMap.Node left;
            Object obj;
            com.google.gson.internal.LinkedTreeMap.Node map;
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

        public com.google.gson.internal.LinkedTreeMap.Node<K, V> last() {
            com.google.gson.internal.LinkedTreeMap.Node right;
            Object obj;
            com.google.gson.internal.LinkedTreeMap.Node map;
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
        Class<com.google.gson.internal.LinkedTreeMap> obj = LinkedTreeMap.class;
        LinkedTreeMap.1 anon = new LinkedTreeMap.1();
        LinkedTreeMap.NATURAL_ORDER = anon;
    }

    public LinkedTreeMap() {
        super(LinkedTreeMap.NATURAL_ORDER);
    }

    public LinkedTreeMap(Comparator<? super K> comparator) {
        Comparator obj2;
        super();
        int i = 0;
        this.size = i;
        this.modCount = i;
        LinkedTreeMap.Node node = new LinkedTreeMap.Node();
        this.header = node;
        if (comparator != null) {
        } else {
            obj2 = LinkedTreeMap.NATURAL_ORDER;
        }
        this.comparator = obj2;
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

    private void rebalance(com.google.gson.internal.LinkedTreeMap.Node<K, V> linkedTreeMap$Node, boolean z2) {
        com.google.gson.internal.LinkedTreeMap.Node left;
        com.google.gson.internal.LinkedTreeMap.Node right;
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
            final com.google.gson.internal.LinkedTreeMap.Node obj8 = node.parent;
            node.height = height++;
            right = left.left;
            com.google.gson.internal.LinkedTreeMap.Node right2 = left.right;
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
            com.google.gson.internal.LinkedTreeMap.Node left2 = right.left;
            com.google.gson.internal.LinkedTreeMap.Node right3 = right.right;
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

    private void replaceInParent(com.google.gson.internal.LinkedTreeMap.Node<K, V> linkedTreeMap$Node, com.google.gson.internal.LinkedTreeMap.Node<K, V> linkedTreeMap$Node2) {
        com.google.gson.internal.LinkedTreeMap.Node left;
        final com.google.gson.internal.LinkedTreeMap.Node parent = node.parent;
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
            this.root = node2;
        }
    }

    private void rotateLeft(com.google.gson.internal.LinkedTreeMap.Node<K, V> linkedTreeMap$Node) {
        int height;
        int height2;
        int height3;
        com.google.gson.internal.LinkedTreeMap.Node left = node.left;
        final com.google.gson.internal.LinkedTreeMap.Node right = node.right;
        com.google.gson.internal.LinkedTreeMap.Node left2 = right.left;
        final com.google.gson.internal.LinkedTreeMap.Node right2 = right.right;
        node.right = left2;
        if (left2 != null) {
            left2.parent = node;
        }
        replaceInParent(node, right);
        right.left = node;
        node.parent = right;
        height3 = 0;
        height = left != null ? left.height : height3;
        height2 = left2 != null ? left2.height : height3;
        i++;
        node.height = i2;
        if (right2 != null) {
            height3 = right2.height;
        }
        right.height = obj6++;
    }

    private void rotateRight(com.google.gson.internal.LinkedTreeMap.Node<K, V> linkedTreeMap$Node) {
        int height2;
        int height3;
        int height;
        final com.google.gson.internal.LinkedTreeMap.Node left = node.left;
        com.google.gson.internal.LinkedTreeMap.Node right = node.right;
        final com.google.gson.internal.LinkedTreeMap.Node left2 = left.left;
        com.google.gson.internal.LinkedTreeMap.Node right2 = left.right;
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

    private Object writeReplace() {
        LinkedHashMap linkedHashMap = new LinkedHashMap(this);
        return linkedHashMap;
    }

    @Override // java.util.AbstractMap
    public void clear() {
        this.root = 0;
        this.size = 0;
        this.modCount = modCount++;
        com.google.gson.internal.LinkedTreeMap.Node header = this.header;
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
        com.google.gson.internal.LinkedTreeMap.EntrySet entrySet;
        if (this.entrySet != null) {
        } else {
            entrySet = new LinkedTreeMap.EntrySet(this);
            this.entrySet = entrySet;
        }
        return entrySet;
    }

    com.google.gson.internal.LinkedTreeMap.Node<K, V> find(K k, boolean z2) {
        com.google.gson.internal.LinkedTreeMap.Node node;
        Comparator comparator;
        com.google.gson.internal.LinkedTreeMap.Node root;
        int i;
        com.google.gson.internal.LinkedTreeMap.Node prev;
        int compareTo;
        com.google.gson.internal.LinkedTreeMap.Node right;
        comparator = this.comparator;
        int i2 = 0;
        if (this.root != null) {
            if (comparator == LinkedTreeMap.NATURAL_ORDER) {
                i = k;
            } else {
                i = i2;
            }
            while (i != 0) {
                compareTo = i.compareTo(root.key);
                if (compareTo < 0) {
                } else {
                }
                right = root.right;
                root = right;
                compareTo = comparator.compare(k, root.key);
                right = root.left;
            }
            return root;
        }
        compareTo = 0;
        if (!z2) {
            return i2;
        }
        com.google.gson.internal.LinkedTreeMap.Node obj8 = this.header;
        int i3 = 1;
        if (root == null) {
            if (comparator == LinkedTreeMap.NATURAL_ORDER) {
                if (!k instanceof Comparable) {
                } else {
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(k.getClass().getName());
                stringBuilder.append(" is not Comparable");
                obj8 = new ClassCastException(stringBuilder.toString());
                throw obj8;
            }
            node = new LinkedTreeMap.Node(root, k, obj8, obj8.prev);
            this.root = node;
        } else {
            node = new LinkedTreeMap.Node(root, k, obj8, obj8.prev);
            if (compareTo < 0) {
                root.left = node;
            } else {
                root.right = node;
            }
            rebalance(root, i3);
        }
        this.size = obj7 += i3;
        this.modCount = obj7 += i3;
        return node;
    }

    com.google.gson.internal.LinkedTreeMap.Node<K, V> findByEntry(Map.Entry<?, ?> map$Entry) {
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

    com.google.gson.internal.LinkedTreeMap.Node<K, V> findByObject(Object object) {
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
        com.google.gson.internal.LinkedTreeMap.KeySet keySet;
        if (this.keySet != null) {
        } else {
            keySet = new LinkedTreeMap.KeySet(this);
            this.keySet = keySet;
        }
        return keySet;
    }

    public V put(K k, V v2) {
        Objects.requireNonNull(k, "key == null");
        final com.google.gson.internal.LinkedTreeMap.Node obj2 = find(k, true);
        obj2.value = v2;
        return obj2.value;
    }

    public V remove(Object object) {
        Object obj1;
        obj1 = removeInternalByKey(object);
        obj1 = obj1 != null ? obj1.value : 0;
        return obj1;
    }

    void removeInternal(com.google.gson.internal.LinkedTreeMap.Node<K, V> linkedTreeMap$Node, boolean z2) {
        com.google.gson.internal.LinkedTreeMap.Node next;
        int height2;
        int height;
        com.google.gson.internal.LinkedTreeMap.Node obj7;
        if (z2 != null) {
            obj7 = node.prev;
            obj7.next = node.next;
            next.prev = obj7;
        }
        obj7 = node.left;
        com.google.gson.internal.LinkedTreeMap.Node right = node.right;
        height = 0;
        final int i3 = 0;
        if (obj7 != null && right != null) {
            if (right != null) {
                if (obj7.height > right.height) {
                    obj7 = obj7.last();
                } else {
                    obj7 = right.first();
                }
                removeInternal(obj7, height);
                com.google.gson.internal.LinkedTreeMap.Node left = node.left;
                if (left != null) {
                    height2 = left.height;
                    obj7.left = left;
                    left.parent = obj7;
                    node.left = i3;
                } else {
                    height2 = height;
                }
                com.google.gson.internal.LinkedTreeMap.Node right2 = node.right;
                if (right2 != null) {
                    height = right2.height;
                    obj7.right = right2;
                    right2.parent = obj7;
                    node.right = i3;
                }
                obj7.height = i++;
                replaceInParent(node, obj7);
            }
        }
        if (obj7 != null) {
            replaceInParent(node, obj7);
            node.left = i3;
        } else {
            if (right != null) {
                replaceInParent(node, right);
                node.right = i3;
            } else {
                replaceInParent(node, i3);
            }
        }
        rebalance(node.parent, height);
        this.size = obj6--;
        this.modCount = obj6++;
    }

    com.google.gson.internal.LinkedTreeMap.Node<K, V> removeInternalByKey(Object object) {
        int i;
        final com.google.gson.internal.LinkedTreeMap.Node obj2 = findByObject(object);
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
