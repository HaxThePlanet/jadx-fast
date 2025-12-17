package com.google.firebase.database.collection;

/* loaded from: classes2.dex */
public class LLRBRedValueNode<K, V>  extends com.google.firebase.database.collection.LLRBValueNode<K, V> {
    LLRBRedValueNode(K k, V v2) {
        super(k, v2, LLRBEmptyNode.getInstance(), LLRBEmptyNode.getInstance());
    }

    LLRBRedValueNode(K k, V v2, com.google.firebase.database.collection.LLRBNode<K, V> lLRBNode3, com.google.firebase.database.collection.LLRBNode<K, V> lLRBNode4) {
        super(k, v2, lLRBNode3, lLRBNode4);
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
        LLRBRedValueNode lLRBRedValueNode = new LLRBRedValueNode(obj2, obj3, obj4, obj5);
        return lLRBRedValueNode;
    }

    @Override // com.google.firebase.database.collection.LLRBValueNode
    protected com.google.firebase.database.collection.LLRBNode.Color getColor() {
        return LLRBNode.Color.RED;
    }

    @Override // com.google.firebase.database.collection.LLRBValueNode
    public boolean isRed() {
        return 1;
    }

    @Override // com.google.firebase.database.collection.LLRBValueNode
    public int size() {
        return i += size2;
    }
}
