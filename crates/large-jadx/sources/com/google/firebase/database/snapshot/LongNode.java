package com.google.firebase.database.snapshot;

import com.google.firebase.database.core.utilities.Utilities;

/* loaded from: classes2.dex */
public class LongNode extends com.google.firebase.database.snapshot.LeafNode<com.google.firebase.database.snapshot.LongNode> {

    private final long value;
    public LongNode(Long long, com.google.firebase.database.snapshot.Node node2) {
        super(node2);
        this.value = long.longValue();
    }

    @Override // com.google.firebase.database.snapshot.LeafNode
    protected int compareLeafValues(com.google.firebase.database.snapshot.LeafNode leafNode) {
        return compareLeafValues((LongNode)leafNode);
    }

    @Override // com.google.firebase.database.snapshot.LeafNode
    protected int compareLeafValues(com.google.firebase.database.snapshot.LongNode longNode) {
        return Utilities.compareLongs(this.value, obj1);
    }

    @Override // com.google.firebase.database.snapshot.LeafNode
    public boolean equals(Object object) {
        int priority;
        int i;
        Object obj7;
        if (!object instanceof LongNode) {
            return 0;
        }
        if (Long.compare(value, value2) == 0 && this.priority.equals(object.priority)) {
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
        stringBuilder2.append(Utilities.doubleToHashString((double)value));
        return stringBuilder2.toString();
    }

    @Override // com.google.firebase.database.snapshot.LeafNode
    protected com.google.firebase.database.snapshot.LeafNode.LeafType getLeafType() {
        return LeafNode.LeafType.Number;
    }

    @Override // com.google.firebase.database.snapshot.LeafNode
    public Object getValue() {
        return Long.valueOf(this.value);
    }

    @Override // com.google.firebase.database.snapshot.LeafNode
    public int hashCode() {
        long value = this.value;
        return i2 += i4;
    }

    @Override // com.google.firebase.database.snapshot.LeafNode
    public com.google.firebase.database.snapshot.LongNode updatePriority(com.google.firebase.database.snapshot.Node node) {
        LongNode longNode = new LongNode(Long.valueOf(this.value), node);
        return longNode;
    }

    @Override // com.google.firebase.database.snapshot.LeafNode
    public com.google.firebase.database.snapshot.Node updatePriority(com.google.firebase.database.snapshot.Node node) {
        return updatePriority(node);
    }
}
