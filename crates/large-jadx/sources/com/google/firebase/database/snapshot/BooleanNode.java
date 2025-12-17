package com.google.firebase.database.snapshot;

/* loaded from: classes2.dex */
public class BooleanNode extends com.google.firebase.database.snapshot.LeafNode<com.google.firebase.database.snapshot.BooleanNode> {

    private final boolean value;
    public BooleanNode(Boolean boolean, com.google.firebase.database.snapshot.Node node2) {
        super(node2);
        this.value = boolean.booleanValue();
    }

    @Override // com.google.firebase.database.snapshot.LeafNode
    protected int compareLeafValues(com.google.firebase.database.snapshot.BooleanNode booleanNode) {
        int obj2;
        final boolean value = this.value;
        obj2 = value == booleanNode.value ? 0 : value != null ? 1 : -1;
        return obj2;
    }

    @Override // com.google.firebase.database.snapshot.LeafNode
    protected int compareLeafValues(com.google.firebase.database.snapshot.LeafNode leafNode) {
        return compareLeafValues((BooleanNode)leafNode);
    }

    @Override // com.google.firebase.database.snapshot.LeafNode
    public boolean equals(Object object) {
        boolean priority;
        int i;
        Object obj4;
        if (!object instanceof BooleanNode) {
            return 0;
        }
        if (this.value == object.value && this.priority.equals(object.priority)) {
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
        stringBuilder.append("boolean:");
        stringBuilder.append(this.value);
        return stringBuilder.toString();
    }

    @Override // com.google.firebase.database.snapshot.LeafNode
    protected com.google.firebase.database.snapshot.LeafNode.LeafType getLeafType() {
        return LeafNode.LeafType.Boolean;
    }

    @Override // com.google.firebase.database.snapshot.LeafNode
    public Object getValue() {
        return Boolean.valueOf(this.value);
    }

    @Override // com.google.firebase.database.snapshot.LeafNode
    public int hashCode() {
        return value += i2;
    }

    @Override // com.google.firebase.database.snapshot.LeafNode
    public com.google.firebase.database.snapshot.BooleanNode updatePriority(com.google.firebase.database.snapshot.Node node) {
        BooleanNode booleanNode = new BooleanNode(Boolean.valueOf(this.value), node);
        return booleanNode;
    }

    @Override // com.google.firebase.database.snapshot.LeafNode
    public com.google.firebase.database.snapshot.Node updatePriority(com.google.firebase.database.snapshot.Node node) {
        return updatePriority(node);
    }
}
