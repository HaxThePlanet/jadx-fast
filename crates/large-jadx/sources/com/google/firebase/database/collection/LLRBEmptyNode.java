package com.google.firebase.database.collection;

import java.util.Comparator;

/* loaded from: classes2.dex */
public class LLRBEmptyNode<K, V>  implements com.google.firebase.database.collection.LLRBNode<K, V> {

    private static final com.google.firebase.database.collection.LLRBEmptyNode INSTANCE;
    static {
        LLRBEmptyNode lLRBEmptyNode = new LLRBEmptyNode();
        LLRBEmptyNode.INSTANCE = lLRBEmptyNode;
    }

    public static <K, V> com.google.firebase.database.collection.LLRBEmptyNode<K, V> getInstance() {
        return LLRBEmptyNode.INSTANCE;
    }

    public com.google.firebase.database.collection.LLRBNode<K, V> copy(K k, V v2, com.google.firebase.database.collection.LLRBNode.Color lLRBNode$Color3, com.google.firebase.database.collection.LLRBNode<K, V> lLRBNode4, com.google.firebase.database.collection.LLRBNode<K, V> lLRBNode5) {
        return this;
    }

    public K getKey() {
        return 0;
    }

    public com.google.firebase.database.collection.LLRBNode<K, V> getLeft() {
        return this;
    }

    public com.google.firebase.database.collection.LLRBNode<K, V> getMax() {
        return this;
    }

    public com.google.firebase.database.collection.LLRBNode<K, V> getMin() {
        return this;
    }

    public com.google.firebase.database.collection.LLRBNode<K, V> getRight() {
        return this;
    }

    public V getValue() {
        return 0;
    }

    public void inOrderTraversal(com.google.firebase.database.collection.LLRBNode.NodeVisitor<K, V> lLRBNode$NodeVisitor) {
    }

    public com.google.firebase.database.collection.LLRBNode<K, V> insert(K k, V v2, Comparator<K> comparator3) {
        LLRBRedValueNode obj3 = new LLRBRedValueNode(k, v2);
        return obj3;
    }

    @Override // com.google.firebase.database.collection.LLRBNode
    public boolean isEmpty() {
        return 1;
    }

    @Override // com.google.firebase.database.collection.LLRBNode
    public boolean isRed() {
        return 0;
    }

    public com.google.firebase.database.collection.LLRBNode<K, V> remove(K k, Comparator<K> comparator2) {
        return this;
    }

    public boolean shortCircuitingInOrderTraversal(com.google.firebase.database.collection.LLRBNode.ShortCircuitingNodeVisitor<K, V> lLRBNode$ShortCircuitingNodeVisitor) {
        return 1;
    }

    public boolean shortCircuitingReverseOrderTraversal(com.google.firebase.database.collection.LLRBNode.ShortCircuitingNodeVisitor<K, V> lLRBNode$ShortCircuitingNodeVisitor) {
        return 1;
    }

    @Override // com.google.firebase.database.collection.LLRBNode
    public int size() {
        return 0;
    }
}
