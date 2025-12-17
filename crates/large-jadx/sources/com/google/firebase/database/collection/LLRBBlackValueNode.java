package com.google.firebase.database.collection;

/* loaded from: classes2.dex */
public class LLRBBlackValueNode<K, V>  extends com.google.firebase.database.collection.LLRBValueNode<K, V> {

    private int size = -1;
    LLRBBlackValueNode(K k, V v2, com.google.firebase.database.collection.LLRBNode<K, V> lLRBNode3, com.google.firebase.database.collection.LLRBNode<K, V> lLRBNode4) {
        super(k, v2, lLRBNode3, lLRBNode4);
        final int obj1 = -1;
    }

    protected com.google.firebase.database.collection.LLRBValueNode<K, V> copy(K k, V v2, com.google.firebase.database.collection.LLRBNode<K, V> lLRBNode3, com.google.firebase.database.collection.LLRBNode<K, V> lLRBNode4) {
        Object obj2;
        Object obj3;
        com.google.firebase.database.collection.LLRBNode obj4;
        com.google.firebase.database.collection.LLRBNode obj5;
        if (k == null) {
            obj2 = getKey();
        }
        if (v2 == null) {
            obj3 = getValue();
        }
        if (lLRBNode3 == null) {
            obj4 = getLeft();
        }
        if (lLRBNode4 == null) {
            obj5 = getRight();
        }
        LLRBBlackValueNode lLRBBlackValueNode = new LLRBBlackValueNode(obj2, obj3, obj4, obj5);
        return lLRBBlackValueNode;
    }

    @Override // com.google.firebase.database.collection.LLRBValueNode
    protected com.google.firebase.database.collection.LLRBNode.Color getColor() {
        return LLRBNode.Color.BLACK;
    }

    @Override // com.google.firebase.database.collection.LLRBValueNode
    public boolean isRed() {
        return 0;
    }

    void setLeft(com.google.firebase.database.collection.LLRBNode<K, V> lLRBNode) {
        if (this.size != -1) {
        } else {
            super.setLeft(lLRBNode);
        }
        IllegalStateException obj3 = new IllegalStateException("Can't set left after using size");
        throw obj3;
    }

    @Override // com.google.firebase.database.collection.LLRBValueNode
    public int size() {
        int size2;
        int size;
        if (this.size == -1) {
            this.size = i += size;
        }
        return this.size;
    }
}
