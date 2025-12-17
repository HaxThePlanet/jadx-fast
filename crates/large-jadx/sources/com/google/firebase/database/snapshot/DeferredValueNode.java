package com.google.firebase.database.snapshot;

import com.google.firebase.database.core.utilities.Utilities;
import java.util.Map;

/* loaded from: classes2.dex */
public class DeferredValueNode extends com.google.firebase.database.snapshot.LeafNode<com.google.firebase.database.snapshot.DeferredValueNode> {

    private Map<Object, Object> value;
    public DeferredValueNode(Map<Object, Object> map, com.google.firebase.database.snapshot.Node node2) {
        super(node2);
        this.value = map;
    }

    @Override // com.google.firebase.database.snapshot.LeafNode
    protected int compareLeafValues(com.google.firebase.database.snapshot.DeferredValueNode deferredValueNode) {
        return 0;
    }

    @Override // com.google.firebase.database.snapshot.LeafNode
    protected int compareLeafValues(com.google.firebase.database.snapshot.LeafNode leafNode) {
        return compareLeafValues((DeferredValueNode)leafNode);
    }

    @Override // com.google.firebase.database.snapshot.LeafNode
    public boolean equals(Object object) {
        boolean priority;
        int i;
        Object obj4;
        if (!object instanceof DeferredValueNode) {
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
        stringBuilder.append("deferredValue:");
        stringBuilder.append(this.value);
        return stringBuilder.toString();
    }

    @Override // com.google.firebase.database.snapshot.LeafNode
    protected com.google.firebase.database.snapshot.LeafNode.LeafType getLeafType() {
        return LeafNode.LeafType.DeferredValue;
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
    public com.google.firebase.database.snapshot.DeferredValueNode updatePriority(com.google.firebase.database.snapshot.Node node) {
        Utilities.hardAssert(PriorityUtilities.isValidPriority(node));
        DeferredValueNode deferredValueNode = new DeferredValueNode(this.value, node);
        return deferredValueNode;
    }

    @Override // com.google.firebase.database.snapshot.LeafNode
    public com.google.firebase.database.snapshot.Node updatePriority(com.google.firebase.database.snapshot.Node node) {
        return updatePriority(node);
    }
}
