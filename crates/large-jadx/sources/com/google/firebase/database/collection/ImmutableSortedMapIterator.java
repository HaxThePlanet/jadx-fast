package com.google.firebase.database.collection;

import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.NoSuchElementException;

/* loaded from: classes2.dex */
public class ImmutableSortedMapIterator<K, V>  implements Iterator<Map.Entry<K, V>> {

    private final boolean isReverse;
    private final ArrayDeque<com.google.firebase.database.collection.LLRBValueNode<K, V>> nodeStack;
    ImmutableSortedMapIterator(com.google.firebase.database.collection.LLRBNode<K, V> lLRBNode, K k2, Comparator<K> comparator3, boolean z4) {
        ArrayDeque arrayDeque;
        Object obj;
        Object obj3;
        Object obj4;
        super();
        arrayDeque = new ArrayDeque();
        this.nodeStack = arrayDeque;
        this.isReverse = z4;
        while (!obj3.isEmpty()) {
            if (k2 != null) {
            } else {
            }
            arrayDeque = 1;
            if (arrayDeque >= 0) {
                break;
            } else {
            }
            if (arrayDeque == null) {
                break;
            } else {
            }
            this.nodeStack.push((LLRBValueNode)obj3);
            if (z4) {
            } else {
            }
            obj3 = obj3.getLeft();
            obj3 = obj3.getRight();
            if (z4) {
            } else {
            }
            obj3 = obj3.getRight();
            obj3 = obj3.getLeft();
            if (z4) {
            } else {
            }
            arrayDeque = comparator3.compare(obj3.getKey(), k2);
            arrayDeque = comparator3.compare(k2, obj3.getKey());
        }
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        int i;
        i = this.nodeStack.size() > 0 ? 1 : 0;
        return i;
    }

    @Override // java.util.Iterator
    public Object next() {
        return next();
    }

    public Map.Entry<K, V> next() {
        com.google.firebase.database.collection.LLRBNode right;
        boolean empty;
        boolean isReverse;
        Object value;
        try {
            Object obj = this.nodeStack.pop();
            AbstractMap.SimpleEntry simpleEntry = new AbstractMap.SimpleEntry((LLRBValueNode)obj.getKey(), obj.getValue());
            if (this.isReverse) {
            } else {
            }
            right = obj.getLeft();
            while (!right.isEmpty()) {
                this.nodeStack.push((LLRBValueNode)right);
                right = right.getRight();
            }
            this.nodeStack.push((LLRBValueNode)right);
            right = right.getRight();
            right = obj.getRight();
            while (!right.isEmpty()) {
                this.nodeStack.push((LLRBValueNode)right);
                right = right.getLeft();
            }
            this.nodeStack.push((LLRBValueNode)right);
            right = right.getLeft();
            return simpleEntry;
            NoSuchElementException noSuchElementException = new NoSuchElementException();
            throw noSuchElementException;
        }
    }

    @Override // java.util.Iterator
    public void remove() {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("remove called on immutable collection");
        throw unsupportedOperationException;
    }
}
