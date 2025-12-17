package com.google.firebase.database.collection;

import java.util.Comparator;

/* loaded from: classes2.dex */
public abstract class LLRBValueNode<K, V>  implements com.google.firebase.database.collection.LLRBNode<K, V> {

    private final K key;
    private com.google.firebase.database.collection.LLRBNode<K, V> left;
    private final com.google.firebase.database.collection.LLRBNode<K, V> right;
    private final V value;
    LLRBValueNode(K k, V v2, com.google.firebase.database.collection.LLRBNode<K, V> lLRBNode3, com.google.firebase.database.collection.LLRBNode<K, V> lLRBNode4) {
        com.google.firebase.database.collection.LLRBEmptyNode obj3;
        com.google.firebase.database.collection.LLRBEmptyNode obj4;
        super();
        this.key = k;
        this.value = v2;
        if (lLRBNode3 == null) {
            obj3 = LLRBEmptyNode.getInstance();
        }
        this.left = obj3;
        if (lLRBNode4 == null) {
            obj4 = LLRBEmptyNode.getInstance();
        }
        this.right = obj4;
    }

    private com.google.firebase.database.collection.LLRBValueNode<K, V> colorFlip() {
        com.google.firebase.database.collection.LLRBNode left = this.left;
        final int i = 0;
        final int i2 = 0;
        final int i3 = 0;
        final int i4 = 0;
        com.google.firebase.database.collection.LLRBNode right = this.right;
        return this.copy(0, 0, LLRBValueNode.oppositeColor(this), left.copy(i, i2, LLRBValueNode.oppositeColor(left), i3, i4), right.copy(i, i2, LLRBValueNode.oppositeColor(right), i3, i4));
    }

    private com.google.firebase.database.collection.LLRBValueNode<K, V> fixUp() {
        boolean red3;
        Object rotateRight;
        boolean red2;
        boolean red;
        if (this.right.isRed() && !this.left.isRed()) {
            if (!this.left.isRed()) {
                rotateRight = rotateLeft();
            } else {
                rotateRight = this;
            }
        } else {
        }
        if (rotateRight.left.isRed() && left4.left.isRed()) {
            if (left4.left.isRed()) {
                rotateRight = rotateRight.rotateRight();
            }
        }
        if (rotateRight.left.isRed() && rotateRight.right.isRed()) {
            if (rotateRight.right.isRed()) {
                rotateRight = rotateRight.colorFlip();
            }
        }
        return rotateRight;
    }

    private com.google.firebase.database.collection.LLRBValueNode<K, V> moveRedLeft() {
        com.google.firebase.database.collection.LLRBValueNode colorFlip;
        boolean rotateRight;
        int i;
        colorFlip = colorFlip();
        if (colorFlip.getRight().getLeft().isRed()) {
            i = 0;
            colorFlip = colorFlip.copy(i, i, i, (LLRBValueNode)colorFlip.getRight().rotateRight()).rotateLeft().colorFlip();
        }
        return colorFlip;
    }

    private com.google.firebase.database.collection.LLRBValueNode<K, V> moveRedRight() {
        com.google.firebase.database.collection.LLRBValueNode colorFlip;
        colorFlip = colorFlip();
        if (colorFlip.getLeft().getLeft().isRed()) {
            colorFlip = colorFlip.rotateRight().colorFlip();
        }
        return colorFlip;
    }

    private static com.google.firebase.database.collection.LLRBNode.Color oppositeColor(com.google.firebase.database.collection.LLRBNode lLRBNode) {
        com.google.firebase.database.collection.LLRBNode.Color obj0;
        obj0 = lLRBNode.isRed() ? LLRBNode.Color.BLACK : LLRBNode.Color.RED;
        return obj0;
    }

    private com.google.firebase.database.collection.LLRBNode<K, V> removeMin() {
        boolean red;
        Object moveRedLeft;
        if (this.left.isEmpty()) {
            return LLRBEmptyNode.getInstance();
        }
        if (!getLeft().isRed() && !getLeft().getLeft().isRed()) {
            if (!getLeft().getLeft().isRed()) {
                moveRedLeft = moveRedLeft();
            } else {
                moveRedLeft = this;
            }
        } else {
        }
        final int i = 0;
        return moveRedLeft.copy(i, i, (LLRBValueNode)moveRedLeft.left.removeMin(), i).fixUp();
    }

    private com.google.firebase.database.collection.LLRBValueNode<K, V> rotateLeft() {
        return (LLRBValueNode)this.right.copy(0, 0, getColor(), this.copy(0, 0, LLRBNode.Color.RED, 0, right.left), 0);
    }

    private com.google.firebase.database.collection.LLRBValueNode<K, V> rotateRight() {
        return (LLRBValueNode)this.left.copy(0, 0, getColor(), 0, this.copy(0, 0, LLRBNode.Color.RED, left.right, 0));
    }

    @Override // com.google.firebase.database.collection.LLRBNode
    public com.google.firebase.database.collection.LLRBNode copy(Object object, Object object2, com.google.firebase.database.collection.LLRBNode.Color lLRBNode$Color3, com.google.firebase.database.collection.LLRBNode lLRBNode4, com.google.firebase.database.collection.LLRBNode lLRBNode5) {
        return copy(object, object2, color3, lLRBNode4, lLRBNode5);
    }

    public com.google.firebase.database.collection.LLRBValueNode<K, V> copy(K k, V v2, com.google.firebase.database.collection.LLRBNode.Color lLRBNode$Color3, com.google.firebase.database.collection.LLRBNode<K, V> lLRBNode4, com.google.firebase.database.collection.LLRBNode<K, V> lLRBNode5) {
        Object obj2;
        Object obj3;
        com.google.firebase.database.collection.LLRBNode obj5;
        com.google.firebase.database.collection.LLRBNode obj6;
        if (k == null) {
            obj2 = this.key;
        }
        if (v2 == null) {
            obj3 = this.value;
        }
        if (lLRBNode4 == null) {
            obj5 = this.left;
        }
        if (lLRBNode5 == null) {
            obj6 = this.right;
        }
        if (color3 == LLRBNode.Color.RED) {
            LLRBRedValueNode obj4 = new LLRBRedValueNode(obj2, obj3, obj5, obj6);
            return obj4;
        }
        obj4 = new LLRBBlackValueNode(obj2, obj3, obj5, obj6);
        return obj4;
    }

    protected abstract com.google.firebase.database.collection.LLRBValueNode<K, V> copy(K k, V v2, com.google.firebase.database.collection.LLRBNode<K, V> lLRBNode3, com.google.firebase.database.collection.LLRBNode<K, V> lLRBNode4);

    @Override // com.google.firebase.database.collection.LLRBNode
    protected abstract com.google.firebase.database.collection.LLRBNode.Color getColor();

    public K getKey() {
        return this.key;
    }

    public com.google.firebase.database.collection.LLRBNode<K, V> getLeft() {
        return this.left;
    }

    public com.google.firebase.database.collection.LLRBNode<K, V> getMax() {
        if (this.right.isEmpty()) {
            return this;
        }
        return this.right.getMax();
    }

    public com.google.firebase.database.collection.LLRBNode<K, V> getMin() {
        if (this.left.isEmpty()) {
            return this;
        }
        return this.left.getMin();
    }

    public com.google.firebase.database.collection.LLRBNode<K, V> getRight() {
        return this.right;
    }

    public V getValue() {
        return this.value;
    }

    public void inOrderTraversal(com.google.firebase.database.collection.LLRBNode.NodeVisitor<K, V> lLRBNode$NodeVisitor) {
        this.left.inOrderTraversal(nodeVisitor);
        nodeVisitor.visitEntry(this.key, this.value);
        this.right.inOrderTraversal(nodeVisitor);
    }

    public com.google.firebase.database.collection.LLRBNode<K, V> insert(K k, V v2, Comparator<K> comparator3) {
        com.google.firebase.database.collection.LLRBNode compare;
        com.google.firebase.database.collection.LLRBValueNode obj3;
        compare = comparator3.compare(k, this.key);
        final int i = 0;
        if (compare < 0) {
            obj3 = copy(i, i, this.left.insert(k, v2, comparator3), i);
        } else {
            if (compare == 0) {
                obj3 = copy(k, v2, i, i);
            } else {
                obj3 = copy(i, i, i, this.right.insert(k, v2, comparator3));
            }
        }
        return obj3.fixUp();
    }

    @Override // com.google.firebase.database.collection.LLRBNode
    public boolean isEmpty() {
        return 0;
    }

    public com.google.firebase.database.collection.LLRBNode<K, V> remove(K k, Comparator<K> comparator2) {
        Object moveRedRight;
        boolean empty;
        boolean empty2;
        int compare;
        com.google.firebase.database.collection.LLRBNode right;
        Object key;
        com.google.firebase.database.collection.LLRBNode min;
        com.google.firebase.database.collection.LLRBValueNode obj6;
        final int i = 0;
        if (comparator2.compare(k, this.key) < 0) {
            if (!this.left.isEmpty() && !this.left.isRed() && !left3.left.isRed()) {
                if (!this.left.isRed()) {
                    if (!left3.left.isRed()) {
                        moveRedRight = moveRedLeft();
                    } else {
                        moveRedRight = this;
                    }
                } else {
                }
            } else {
            }
            obj6 = moveRedRight.copy(i, i, moveRedRight.left.remove(k, comparator2), i);
        } else {
            if (this.left.isRed()) {
                moveRedRight = rotateRight();
            } else {
                moveRedRight = this;
            }
            if (!moveRedRight.right.isEmpty() && !moveRedRight.right.isRed() && !right4.left.isRed()) {
                if (!moveRedRight.right.isRed()) {
                    if (!right4.left.isRed()) {
                        moveRedRight = moveRedRight.moveRedRight();
                    }
                }
            }
            if (comparator2.compare(k, moveRedRight.key) == 0 && moveRedRight.right.isEmpty()) {
                if (moveRedRight.right.isEmpty()) {
                    return LLRBEmptyNode.getInstance();
                }
                com.google.firebase.database.collection.LLRBNode min2 = moveRedRight.right.getMin();
                moveRedRight = moveRedRight.copy(min2.getKey(), min2.getValue(), i, (LLRBValueNode)moveRedRight.right.removeMin());
            }
            obj6 = moveRedRight.copy(i, i, i, moveRedRight.right.remove(k, comparator2));
        }
        return obj6.fixUp();
    }

    void setLeft(com.google.firebase.database.collection.LLRBNode<K, V> lLRBNode) {
        this.left = lLRBNode;
    }

    public boolean shortCircuitingInOrderTraversal(com.google.firebase.database.collection.LLRBNode.ShortCircuitingNodeVisitor<K, V> lLRBNode$ShortCircuitingNodeVisitor) {
        boolean shortCircuitingInOrderTraversal;
        Object value;
        if (this.left.shortCircuitingInOrderTraversal(shortCircuitingNodeVisitor) && shortCircuitingNodeVisitor.shouldContinue(this.key, this.value)) {
            if (shortCircuitingNodeVisitor.shouldContinue(this.key, this.value)) {
                return this.right.shortCircuitingInOrderTraversal(shortCircuitingNodeVisitor);
            }
        }
        return 0;
    }

    public boolean shortCircuitingReverseOrderTraversal(com.google.firebase.database.collection.LLRBNode.ShortCircuitingNodeVisitor<K, V> lLRBNode$ShortCircuitingNodeVisitor) {
        boolean shortCircuitingReverseOrderTraversal;
        Object value;
        if (this.right.shortCircuitingReverseOrderTraversal(shortCircuitingNodeVisitor) && shortCircuitingNodeVisitor.shouldContinue(this.key, this.value)) {
            if (shortCircuitingNodeVisitor.shouldContinue(this.key, this.value)) {
                return this.left.shortCircuitingReverseOrderTraversal(shortCircuitingNodeVisitor);
            }
        }
        return 0;
    }
}
