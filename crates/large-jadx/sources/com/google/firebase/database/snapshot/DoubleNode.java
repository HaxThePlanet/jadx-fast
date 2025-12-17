package com.google.firebase.database.snapshot;

import com.google.firebase.database.core.utilities.Utilities;

/* loaded from: classes2.dex */
public class DoubleNode extends com.google.firebase.database.snapshot.LeafNode<com.google.firebase.database.snapshot.DoubleNode> {

    private final Double value;
    public DoubleNode(Double double, com.google.firebase.database.snapshot.Node node2) {
        super(node2);
        this.value = double;
    }

    @Override // com.google.firebase.database.snapshot.LeafNode
    protected int compareLeafValues(com.google.firebase.database.snapshot.DoubleNode doubleNode) {
        return this.value.compareTo(doubleNode.value);
    }

    @Override // com.google.firebase.database.snapshot.LeafNode
    protected int compareLeafValues(com.google.firebase.database.snapshot.LeafNode leafNode) {
        return compareLeafValues((DoubleNode)leafNode);
    }

    @Override // com.google.firebase.database.snapshot.LeafNode
    public boolean equals(Object object) {
        boolean priority;
        int i;
        Object obj4;
        if (!object instanceof DoubleNode) {
            return 0;
        }
        if (this.value.equals(object.value) && this.priority.equals(object.priority)) {
            if (this.priority.equals(object.priority)) {
                i = 1;
            }
        }
        return i;
    }

    @Override // com.google.firebase.database.snapshot.LeafNode
    public String getHashRepresentation(com.google.firebase.database.snapshot.Node.HashVersion node$HashVersion) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(getPriorityHash(hashVersion));
        stringBuilder.append("number:");
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append(stringBuilder.toString());
        stringBuilder2.append(Utilities.doubleToHashString(this.value.doubleValue()));
        return stringBuilder2.toString();
    }

    @Override // com.google.firebase.database.snapshot.LeafNode
    protected com.google.firebase.database.snapshot.LeafNode.LeafType getLeafType() {
        return LeafNode.LeafType.Number;
    }

    @Override // com.google.firebase.database.snapshot.LeafNode
    public Object getValue() {
        return this.value;
    }

    @Override // com.google.firebase.database.snapshot.LeafNode
    public int hashCode() {
        return i += i3;
    }

    @Override // com.google.firebase.database.snapshot.LeafNode
    public com.google.firebase.database.snapshot.DoubleNode updatePriority(com.google.firebase.database.snapshot.Node node) {
        Utilities.hardAssert(PriorityUtilities.isValidPriority(node));
        DoubleNode doubleNode = new DoubleNode(this.value, node);
        return doubleNode;
    }

    @Override // com.google.firebase.database.snapshot.LeafNode
    public com.google.firebase.database.snapshot.Node updatePriority(com.google.firebase.database.snapshot.Node node) {
        return updatePriority(node);
    }
}
