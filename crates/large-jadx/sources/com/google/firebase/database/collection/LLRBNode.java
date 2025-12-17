package com.google.firebase.database.collection;

import java.util.Comparator;

/* loaded from: classes2.dex */
public interface LLRBNode<K, V>  {

    public static enum Color {

        RED,
        BLACK;
    }

    public interface ShortCircuitingNodeVisitor {
        public abstract boolean shouldContinue(K k, V v2);
    }

    public static abstract class NodeVisitor implements com.google.firebase.database.collection.LLRBNode.ShortCircuitingNodeVisitor<K, V> {
        public boolean shouldContinue(K k, V v2) {
            visitEntry(k, v2);
            return 1;
        }

        public abstract void visitEntry(K k, V v2);
    }
    public abstract com.google.firebase.database.collection.LLRBNode<K, V> copy(K k, V v2, com.google.firebase.database.collection.LLRBNode.Color lLRBNode$Color3, com.google.firebase.database.collection.LLRBNode<K, V> lLRBNode4, com.google.firebase.database.collection.LLRBNode<K, V> lLRBNode5);

    public abstract K getKey();

    public abstract com.google.firebase.database.collection.LLRBNode<K, V> getLeft();

    public abstract com.google.firebase.database.collection.LLRBNode<K, V> getMax();

    public abstract com.google.firebase.database.collection.LLRBNode<K, V> getMin();

    public abstract com.google.firebase.database.collection.LLRBNode<K, V> getRight();

    public abstract V getValue();

    public abstract void inOrderTraversal(com.google.firebase.database.collection.LLRBNode.NodeVisitor<K, V> lLRBNode$NodeVisitor);

    public abstract com.google.firebase.database.collection.LLRBNode<K, V> insert(K k, V v2, Comparator<K> comparator3);

    public abstract boolean isEmpty();

    public abstract boolean isRed();

    public abstract com.google.firebase.database.collection.LLRBNode<K, V> remove(K k, Comparator<K> comparator2);

    public abstract boolean shortCircuitingInOrderTraversal(com.google.firebase.database.collection.LLRBNode.ShortCircuitingNodeVisitor<K, V> lLRBNode$ShortCircuitingNodeVisitor);

    public abstract boolean shortCircuitingReverseOrderTraversal(com.google.firebase.database.collection.LLRBNode.ShortCircuitingNodeVisitor<K, V> lLRBNode$ShortCircuitingNodeVisitor);

    public abstract int size();
}
